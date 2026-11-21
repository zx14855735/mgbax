#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""ISYNC16 — seed applied 验收的离线判读脚本（只读，不编译、不跑 E2E、不写产物）。

用法：
    python tools/isync_applied_check.py <run目录> [tag] [--json]
    python tools/isync_applied_check.py --selftest

判读对象：ISYNC14 的 5 项 applied 成功判据 + ISYNC7 A1-A4（任务口径）证据。
严格防伪：
  * 逐文件读取日志（>1MB 大日志也逐行扫，绝不用目录级 grep 漏报）；
  * summary 里的 `[PATHB] state_sync=loaded` 是 driver 正则假阳性载体（把
    「not applied」里的 applied 当成功），只记录、绝不当 applied 证据；
  * 「not applied yet / consoles not ready / rejected / bounded wait exhausted」
    等负向标记一旦出现，applied 判 UNOBSERVED，绝不判 PASS；
  * 槽号（ISYNC25 双源交叉）：权威源 GBoyConsoleSet.java:662-663 的
    `peer state loaded (no reset) ... index=0 slot=<S_auth>` 必须与里程碑的
    `mirrorSlot=<S_mile>` 一致，且 index==0、槽非 0、非可见核槽(SELF_ECHO)；
    mirrorSlotFor 随 localSlot 变（localSlot=1→2，localSlot=2→1），禁写死 slot==2。
    双源冲突 / 可见核槽 / slot=0 / index!=0 判 FAIL；单源或槽字段缺失 UNOBSERVED。
  * queued/enqueued = 「已入队未载入」，既不当 applied、也不当负向标记；仅统计种子相关 deferred（收窄正则，排除
     ActivityManager Enqueued broadcast / OpenGL SyncQueued），重叠 logcat 副本按
     (时间戳+事件)去重（M1FIX）；
  * 有 rx 但无真实 applied → UNOBSERVED；hash 缺失 → UNOBSERVED（fail-closed）；
  * 字段缺失一律 UNOBSERVED，不伪造补位。

门纪律：本脚本判的是「applied 前置门」，不是对手真实性裁决。门维持
FAIL / 对手真实性 0/9；唯一裁决仍是零注入 diff_party_check 的 CROSSED
（APP 框 0006 ↔ PC 框 00D5），本脚本任一项 PASS 都不升级总门。
中文，不伪造，不预设成功。
"""

import argparse
import json
import os
import re
import shutil
import sys
import tempfile

# 只读扫描：仅文本类日志；二进制（.gba/.sav/.png/...）一律不读。
TEXT_EXTS = ('.log', '.txt', '.out')
# 单文件上限：超过则不读并在报告里声明（防止异常巨文件拖垮判读）。
MAX_FILE_BYTES = 256 * 1024 * 1024
ROLES = ('APP', 'PC')
EXPECTED_PARTY = {'APP': '00d5', 'PC': '0006'}  # 各自可见核的 party 首位（ISYNC7 A3 口径）

# M1FIX：queued 统计口径收窄（ISYNC25 §1-A / M1DRIVER §4-a）。
# 旧式 `\b(queued|enqueued)\b` 把 ActivityManager 的 `Enqueued broadcast Intent`
# （ROM/KEYS/CLOUD/TCP/... 广播，与种子无关）也计成「种子入队」，M1-APPLIED-01
# 两份重叠 logcat 共 154 条广播 + 6 条种子 deferred = 假象 160。改为「必须有种子
# 上下文 + 显式排除广播/SyncQueued」，并只统计中立桶，绝不动 neg_pats（防过度纠正）。
_QUEUED_WORD_RE = re.compile(r'\b(?:queued|enqueued)\b', re.I)
_QUEUED_SEED_CTX_RE = re.compile(
    r'\btype_state\b|\bseed\b|consoles?\s+not\s+ready|queued\s+to\s+mirror'
    r'|deferred\s*:\s*consoles', re.I)
_QUEUED_BROADCAST_RE = re.compile(
    r'\bactivitymanager\b|\bbroadcast\s+intent\b|\benqueued\s+broadcast\b'
    r'|\bsyncqueued\b|\bdequeuebuffer', re.I)
# logcat 时间戳前缀（如 `11-20 07:36:10.146`）；重叠副本同一事件时间戳+事件完全一致。
_LOGCAT_TS_RE = re.compile(r'^\s*(\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}\.\d+)')


def _norm_role(value):
    if not value:
        return 'UNK'
    v = value.lower()
    if v in ('app', 'android'):
        return 'APP'
    if v == 'pc':
        return 'PC'
    if v == 'ios':
        return 'iOS'
    return 'UNK'


def _infer_role(path, text):
    m = re.search(r'\brole\s*=\s*(APP|PC|iOS)\b', text, re.I)
    if m:
        return _norm_role(m.group(1))
    base = os.path.basename(path).lower()
    if base.startswith('app_') or 'logcat' in base:
        return 'APP'
    if base.startswith('ios_'):
        return 'iOS'
    if base.startswith('pc_') or base in ('mgba_sio.log', 'mgba_lobby_debug.log'):
        return 'PC'
    return 'UNK'


def _token(text, key, pattern=r'([^\s]+)'):
    m = re.search(r'\b' + re.escape(key) + r'\s*=\s*' + pattern, text, re.I)
    return m.group(1) if m else None


def _sha_ok(value):
    """sha256 必须是 64 位 hex；否则视为不可用（fail-closed）。"""
    return bool(value) and bool(re.fullmatch(r'[0-9a-fA-F]{64}', value))


def _new_records():
    return {
        'rx': [],        # TYPE_STATE 收包：{role, bytes, where, text}
        'send': [],      # A1-SEND：{role, bytes, sha256, where}
        'rxsha': [],     # A1-RX：{role, bytes, sha256, where}
        'land': [],      # A1-LAND：{role, slot, bytes, sha256, where}
        'applied': [],   # 真实 applied 里程碑：{role, slot, index, mirror_slot, visible_slot, slot_source, bytes, hash, count, where}
        'queued': [],    # G1 入队口径（seeded/TYPE_STATE queued）：中立，既非 applied 亦非负向，只记录
        'a3': [],        # A3 seed party == live party
        'negative': [],  # 负向标记（not applied / rejected / ...）
        'state_sync_claim': [],  # driver 正则产出的 state_sync=...（仅记录，不作证据）
        'summary': {},   # summary.txt 的 key=value
        'files': [],     # {path, bytes, scanned, over_limit}
        'sample': [],    # 命中样本（便于人工复核）
    }


def _add_sample(rec, rel, lineno, text):
    if len(rec['sample']) < 120:
        rec['sample'].append('%s:%d: %s' % (rel, lineno, text.strip()[:240]))


def _is_seed_queued(low):
    """真种子入队口径（M1FIX）：含 queued/enqueued 且带种子上下文，
    且不是 ActivityManager 广播 / OpenGL SyncQueued / DequeueBuffer。"""
    if not _QUEUED_WORD_RE.search(low):
        return False
    if _QUEUED_BROADCAST_RE.search(low):
        return False
    return bool(_QUEUED_SEED_CTX_RE.search(low))


def _queued_event_key(text):
    """(时间戳, 事件) 去重键：两份重叠 logcat 的同一事件键相同。
    无时间戳的合成行退化为 ('', 归一化整行)。"""
    m = _LOGCAT_TS_RE.match(text)
    ts = m.group(1) if m else ''
    rest = text[m.end():] if m else text
    return (ts, re.sub(r'\s+', ' ', rest).strip().lower())


def _classify_line(rel, text, rec, lineno, queued_seen=None):
    low = text.lower()
    role = _infer_role(rel, text)

    # 0) driver 假阳性载体：summary 的 `[PATHB] state_sync=loaded ...` / ISYNC23
    #    新增的 `[ISYNC] state_sync=loaded ...` 里含「remote state loaded」字样，
    #    绝不能当 applied 正向证据。两种前缀都靠 `state_sync=` 子串覆盖。
    if 'state_sync=' in low:
        m = re.search(r'state_sync\s*=\s*([A-Za-z_]+)', text, re.I)
        if m:
            rec['state_sync_claim'].append(m.group(1).lower())
        return

    # 0.5) G1 入队口径（M1FIX 收窄）：仅「种子相关 deferred」计入中立 queued 桶——
    #      `TYPE_STATE deferred: consoles not ready, queued` / `seed queued` /
    #      `queued to mirror` / `[ISYNC] TYPE_STATE queued`。显式排除 ActivityManager
    #      的 `Enqueued broadcast Intent`（广播，非种子）与 OpenGL SyncQueued。
    #      语义中立：绝不当 applied 里程碑，也绝不进 neg_pats（防过度纠正，
    #      ISYNC25 §1-A 红线）。两份重叠 logcat 按(时间戳+事件)去重，避免同一
    #      种子包被双计。无论是否种子，queued/enqueued 行一律早返回。
    if _QUEUED_WORD_RE.search(low):
        if _is_seed_queued(low):
            key = _queued_event_key(text)
            if queued_seen is None or key not in queued_seen:
                if queued_seen is not None:
                    queued_seen.add(key)
                rec['queued'].append({'role': role, 'where': '%s:%d' % (rel, lineno),
                                      'text': text.strip()[:240]})
                _add_sample(rec, rel, lineno, text)
        return

    # 1) 负向标记：必须优先于任何正向匹配。
    neg_pats = (
        r'not\s+applied', r'not-applied', r'consoles?\s+not\s+ready',
        r'\bdeferred\b', r'still\s+pending', r'bounded\s+wait\s+exhausted',
        r'seed\s+unconsumed', r'peer\s+state\s+rejected',
        r'type_state[^\n]*reject', r'\bcode\s+-5\b', r'\breject(?:ed)?\b',
        r'apply\s+failed', r'load\s+failed', r'state_size_mismatch',
    )
    if re.search(r'type_state|state|seed|peer|pending|consol|apply|load|slot', low):
        for pat in neg_pats:
            if re.search(pat, text, re.I):
                rec['negative'].append({'role': role, 'where': '%s:%d' % (rel, lineno),
                                        'text': text.strip()[:240]})
                _add_sample(rec, rel, lineno, text)
                break

    # 2) TYPE_STATE rx（收包事实）
    m = (re.search(r'rx\s+TYPE_STATE\s+(\d+)\s*bytes', text, re.I)
         or re.search(r'TYPE_STATE\s+rx\s+(\d+)\s*bytes', text, re.I))
    if m:
        rec['rx'].append({'role': role, 'bytes': int(m.group(1)),
                          'where': '%s:%d' % (rel, lineno)})
        _add_sample(rec, rel, lineno, text)

    # 3) A1 埋点：SEND / RX / LAND（LAND 只是落地取 hash，不单独算 applied）
    if '[isync-ev][a1-send]' in low:
        b, s = _token(text, 'bytes', r'(\d+)'), _token(text, 'sha256', r'([0-9a-fA-F]+)')
        if b and s:
            rec['send'].append({'role': role, 'bytes': int(b), 'sha256': s.lower(),
                                'where': '%s:%d' % (rel, lineno)})
            _add_sample(rec, rel, lineno, text)
    elif '[isync-ev][a1-rx]' in low:
        b, s = _token(text, 'bytes', r'(\d+)'), _token(text, 'sha256', r'([0-9a-fA-F]+)')
        if b and s:
            rec['rxsha'].append({'role': role, 'bytes': int(b), 'sha256': s.lower(),
                                 'where': '%s:%d' % (rel, lineno)})
            _add_sample(rec, rel, lineno, text)
    elif '[isync-ev][a1-land]' in low:
        b, s = _token(text, 'bytes', r'(\d+)'), _token(text, 'sha256', r'([0-9a-fA-F]+)')
        slot = _token(text, 'slot', r'(\d+)')
        if b and s:
            rec['land'].append({'role': role, 'bytes': int(b), 'sha256': s.lower(),
                                'slot': int(slot) if slot else None,
                                'where': '%s:%d' % (rel, lineno)})
            _add_sample(rec, rel, lineno, text)

    # 4) A3：seed party == 发送端可见核 live party（防本地改造 party 造伪交叉）
    if '[isync-ev][a3]' in low:
        sp = _token(text, 'seed_party_first', r'([0-9A-Fa-f]{4})')
        lp = _token(text, 'live_party_first', r'([0-9A-Fa-f]{4})')
        eq = _token(text, 'eq', r'([01])')
        if sp and lp and eq is not None:
            rec['a3'].append({'role': role, 'seed': sp.lower(), 'live': lp.lower(),
                              'eq': int(eq), 'where': '%s:%d' % (rel, lineno)})
            _add_sample(rec, rel, lineno, text)

    # 5) 真实 applied 里程碑（五种正则，均来自 load 返回成功之后打的日志）
    #    a) 权威真槽(源 A): peer state loaded (no reset) bytes=<n> index=0 slot=<m>
    #       —— GBoyConsoleSet.java:662-663，无条件打，mirrorSlotFor 真槽证据。
    #    b) PC 里程碑(源 B): [GBoyMirror] applied peer state <n> bytes slot <m>
    #    c) 三端里程碑(源 B): [ISYNC] remote state loaded slot=<m> bytes=<n> hash=<hex>
    #       —— G2 修复后 Android 形态为 ... index=0 mirrorSlot=<m> (visibleSlot=<v>) ...
    #       iOS GBoyConsoleSet.swift 真里程碑无 slot 字段，_token 返回 None 属预期。
    #    d) A4(源 B): [ISYNC-EV][A4] ... side=apply slot=<m> bytes=<n> applied_count=<k> seed_hash=<hex>
    #    e) G1 修复后 iOS 入队行: [ISYNC] TYPE_STATE queued ... —— 已被 0.5 早返回挡掉。
    #    G1: queued/enqueued 行绝不计入 applied（哪怕同一行混有 loaded 字样）。
    hit = ('[isync-ev][a4]' in low and 'side=apply' in low) \
        or 'remote state loaded' in low or 'applied peer state' in low \
        or 'peer state loaded' in low
    if hit and 'queued' not in low and 'enqueued' not in low:
        # 源 A（权威真槽）与源 B（里程碑）分别存，供 C3 双源交叉校验。
        is_auth = 'peer state loaded' in low
        mirror_slot = _token(text, 'mirrorSlot', r'(\d+)')
        visible_slot = _token(text, 'visibleSlot', r'(\d+)')
        slot = mirror_slot or _token(text, 'slot', r'(\d+)') \
            or (re.search(r'\bslot\s+(\d+)', text).group(1)
                if re.search(r'\bslot\s+(\d+)', text) else None)
        index = _token(text, 'index', r'(\d+)')
        nbytes = _token(text, 'bytes', r'(\d+)')
        if not nbytes:
            m2 = re.search(r'\b(\d+)\s+bytes', text, re.I)
            nbytes = m2.group(1) if m2 else None
        hv = _token(text, 'seed_hash', r'([0-9a-fA-F]{4,})') or _token(text, 'hash', r'([0-9a-fA-F]{4,})')
        cnt = _token(text, 'applied_count', r'(\d+)')
        rec['applied'].append({
            'role': role,
            'slot': int(slot) if slot else None,
            'index': int(index) if index else None,
            'mirror_slot': int(mirror_slot) if mirror_slot else None,
            'visible_slot': int(visible_slot) if visible_slot else None,
            'slot_source': 'auth' if is_auth else 'mile',
            'bytes': int(nbytes) if nbytes else None,
            'hash': hv.lower() if hv else None,
            'count': int(cnt) if cnt else None,
            'where': '%s:%d' % (rel, lineno),
        })
        _add_sample(rec, rel, lineno, text)


def _parse_summary(text, rec):
    for line in text.splitlines():
        m = re.match(r'^\s*([^=#]+?)\s*=\s*(.*?)\s*$', line)
        if not m:
            continue
        key, val = m.group(1).strip(), m.group(2).strip()
        rec['summary'][key] = val
        if 'state_sync=' in line.lower():
            cm = re.search(r'state_sync\s*=\s*([A-Za-z_]+)', line, re.I)
            if cm:
                rec['state_sync_claim'].append(cm.group(1).lower())


def scan_run(run_dir):
    rec = _new_records()
    # M1FIX：跨文件queued去重键集。app_link_startup.log 与 app_logcat_full.log
    # 是同一 logcat 的两份重叠副本，同一 (时间戳,事件) 只应计一次。
    queued_seen = set()
    if not os.path.isdir(run_dir):
        return rec
    for root, _dirs, files in os.walk(run_dir):
        for name in sorted(files):
            full = os.path.join(root, name)
            rel = os.path.relpath(full, run_dir).replace('\\', '/')
            if not name.lower().endswith(TEXT_EXTS):
                continue
            try:
                size = os.path.getsize(full)
            except OSError:
                continue
            if size > MAX_FILE_BYTES:
                rec['files'].append({'path': rel, 'bytes': size, 'scanned': False, 'over_limit': True})
                continue
            rec['files'].append({'path': rel, 'bytes': size, 'scanned': True, 'over_limit': False})
            try:
                with open(full, 'r', encoding='utf-8', errors='replace') as fh:
                    if name.lower() == 'summary.txt':
                        _parse_summary(fh.read(), rec)
                        fh.seek(0)
                    for lineno, line in enumerate(fh, 1):
                        _classify_line(rel, line.rstrip('\r\n'), rec, lineno, queued_seen)
            except OSError:
                pass
    # summary 里的 isync_seed_sha_* / len_* 字段也纳入（key 名与 ISYNC12 §3 对齐）
    s = rec['summary']
    for role in ROLES + ('iOS',):
        lr = role.lower()
        for suffix, bucket in (('send', 'send'), ('rx', 'rxsha'), ('land', 'land')):
            v = s.get('isync_seed_sha_%s_%s' % (lr, suffix))
            if v and _sha_ok(v):
                rec[bucket].append({'role': role, 'bytes': None, 'sha256': v.lower(),
                                    'where': 'summary.txt:isync_seed_sha_%s_%s' % (lr, suffix),
                                    'slot': None})
    return rec


def _combine(statuses):
    if any(s == 'FAIL' for s in statuses):
        return 'FAIL'
    if statuses and all(s == 'PASS' for s in statuses):
        return 'PASS'
    return 'UNOBSERVED'


def judge(rec, tag=None):
    res = {'tag_expected': tag, 'tag_field': rec['summary'].get('tag'),
           'files': rec['files'], 'sample': rec['sample']}
    # tag 一致性：不一致时 fail-closed（可能是拿错 artifact）。
    tag_field = rec['summary'].get('tag')
    if tag and tag_field:
        res['tag_check'] = 'OK' if tag.strip() == tag_field.strip() else 'MISMATCH'
    elif tag_field:
        res['tag_check'] = 'NO_EXPECTED_TAG'
    else:
        res['tag_check'] = 'NO_TAG_FIELD'

    send = {}
    for e in rec['send']:
        if _sha_ok(e['sha256']):
            send.setdefault(e['role'], set()).add(e['sha256'].lower())
    land = {}
    for e in rec['land']:
        if _sha_ok(e['sha256']):
            land.setdefault(e['role'], set()).add(e['sha256'].lower())
    rxsha = {}
    for e in rec['rxsha']:
        if _sha_ok(e['sha256']):
            rxsha.setdefault(e['role'], set()).add(e['sha256'].lower())
    rx_bytes = {}
    for e in rec['rx'] + rec['rxsha']:
        if e.get('bytes'):
            rx_bytes.setdefault(e['role'], set()).add(e['bytes'])
    applied_by_role = {r: [e for e in rec['applied'] if e['role'] == r] for r in ROLES}
    neg_roles = set(e['role'] for e in rec['negative'])
    has_negative = bool(neg_roles & (set(ROLES) | {'UNK', 'iOS'}))

    # ---------- 5 项 applied 判据 ----------
    # C1 收到 TYPE_STATE rx：两端都要有，否则 UNOBSERVED（不判 FAIL）。
    missing_rx = [r for r in ROLES if not rx_bytes.get(r)]
    c1 = 'UNOBSERVED' if missing_rx else 'PASS'
    res['C1_RX_RECEIVED'] = {
        'status': c1, 'rx_bytes': {r: sorted(rx_bytes.get(r, ())) for r in ROLES},
        'detail': '缺 rx: ' + ','.join(missing_rx) if missing_rx else '两端均收到 TYPE_STATE',
    }

    # C2 applied 到镜像核：负向标记优先；无负向且两端都有真实 applied 才 PASS。
    missing_applied = [r for r in ROLES if not applied_by_role[r]]
    if has_negative:
        c2 = 'UNOBSERVED'
        detail = '存在 not applied / rejected 等负向标记，applied 判 UNOBSERVED（不 PASS）'
        if rec['applied']:
            detail += ('；但有 %d 条真实 applied 里程碑与负向标记共存（可能是重试后成功），'
                       '按 fail-closed 不升 PASS，须父会话逐文件人工复核时序' % len(rec['applied']))
    elif missing_applied:
        c2 = 'UNOBSERVED'
        detail = '缺真实 applied 里程碑: ' + ','.join(missing_applied) + '（rx 不等于 applied）'
    else:
        c2 = 'PASS'
        detail = '两端均有 load 成功后的 applied 里程碑'
    res['C2_APPLIED_TO_MIRROR'] = {'status': c2, 'detail': detail,
                                   'negative_markers': len(rec['negative'])}

    # C3 槽号正确（ISYNC25 双源交叉）—— 删硬编码 slot==2。
    #   mirrorSlotFor(localSlot, players, 0) 随 localSlot 变：
    #     localSlot=1 → 镜像核=2；localSlot=2 → 镜像核=1。写死必然误判合法槽。
    #   源 A(权威真槽) = GBoyConsoleSet.java:662-663：
    #     `peer state loaded (no reset) bytes=N index=0 slot=<S_auth>`
    #   源 B(里程碑)   = `remote state loaded` / `applied peer state` / A4，
    #     G2 修复后带 `mirrorSlot=<S_mile>` 与 `visibleSlot=<V>`（可见核/SELF_ECHO）。
    #   PASS: S_auth==S_mile 且 index_auth==0 且 S_auth∉{0} 且 S_mile∉{V}。
    #   FAIL: 双源冲突 / 里程碑落可见核槽 / slot==0 / index!=0。
    #   单源或槽字段缺失 → UNOBSERVED（fail-closed，不放宽判据）。
    c3, c3_detail, wrong = 'UNOBSERVED', [], []
    slot_seen = {r: [] for r in ROLES}
    role_c3 = {}
    for r in ROLES:
        auth = [e for e in applied_by_role[r]
                if e.get('slot_source') == 'auth' and e['slot'] is not None]
        mile = [e for e in applied_by_role[r]
                if e.get('slot_source') == 'mile' and e['slot'] is not None]
        slot_seen[r] = {
            'auth': [e['slot'] for e in auth],
            'mile': [e['slot'] for e in mile],
            'visible': [e['visible_slot'] for e in mile if e['visible_slot'] is not None],
        }
        if not auth or not mile:
            c3_detail.append('%s 槽证据单源或缺失(auth=%d,mile=%d)' % (r, len(auth), len(mile)))
            role_c3[r] = 'UNOBSERVED'
            continue
        s_auth = set(e['slot'] for e in auth)
        s_mile = set(e['slot'] for e in mile)
        idx_auth = set(e['index'] for e in auth if e['index'] is not None)
        idx_mile = set(e['index'] for e in mile if e['index'] is not None)
        vis = set(e['visible_slot'] for e in mile if e['visible_slot'] is not None)
        bad, missing_field = [], False
        if len(s_auth) != 1 or len(s_mile) != 1:
            bad.append('%s 同源槽值不唯一 auth=%s mile=%s' %
                       (r, sorted(s_auth), sorted(s_mile)))
        else:
            a, m = next(iter(s_auth)), next(iter(s_mile))
            if a != m:
                bad.append('%s 双源冲突 auth=%s mile=%s' % (r, a, m))
            if a == 0 or m == 0:
                bad.append('%s 非法槽(0) auth=%s mile=%s' % (r, a, m))
            if vis and m in vis:
                bad.append('%s 里程碑落可见核槽(SELF_ECHO) mile=%s visible=%s' %
                           (r, m, sorted(vis)))
        if idx_auth and any(i != 0 for i in idx_auth):
            bad.append('%s index_auth!=0 %s' % (r, sorted(idx_auth)))
        if idx_mile and any(i != 0 for i in idx_mile):
            bad.append('%s index_mile!=0 %s' % (r, sorted(idx_mile)))
        if not idx_auth:
            c3_detail.append('%s 权威行缺 index 字段' % r)
            missing_field = True
        if bad:
            wrong.extend(bad)
            role_c3[r] = 'FAIL'
        elif missing_field:
            role_c3[r] = 'UNOBSERVED'
        else:
            role_c3[r] = 'PASS'
            c3_detail.append('%s 双源一致 slot=%s index=0 非可见核' %
                             (r, next(iter(s_auth))))
    if wrong:
        c3 = 'FAIL'
        c3_detail.append('槽源冲突/可见核槽/非法槽(0)/index!=0: ' + '; '.join(wrong))
    elif all(role_c3[r] == 'PASS' for r in ROLES):
        c3 = 'PASS'
    else:
        c3 = 'UNOBSERVED'
    res['C3_SLOT_CORRECT'] = {'status': c3, 'detail': ' | '.join(c3_detail),
                              'slots': slot_seen, 'role_status': role_c3}

    # C4 字节数 == stateSize（以本端实际收到的 TYPE_STATE 字节数为基准）。
    c4, c4_detail = 'UNOBSERVED', []
    mism = []
    for r in ROLES:
        ab = [e['bytes'] for e in applied_by_role[r] if e['bytes'] is not None]
        if not ab or not rx_bytes.get(r):
            c4_detail.append('%s 缺 applied/rx 字节数' % r)
            continue
        bad = [b for b in ab if b not in rx_bytes[r]]
        if bad:
            mism.append('%s applied=%s rx=%s' % (r, bad, sorted(rx_bytes[r])))
    if mism:
        c4 = 'FAIL'
        c4_detail.append('字节数不符: ' + '; '.join(mism))
    elif all(any(e['bytes'] is not None for e in applied_by_role[r])
             and rx_bytes.get(r) for r in ROLES):
        c4 = 'PASS'
        c4_detail.append('两端 applied 字节数均命中本端 rx 字节数')
    res['C4_BYTES_MATCH'] = {'status': c4, 'detail': ' | '.join(c4_detail)}

    # C5 hash 匹配发送端：applied 落地 hash（A1-LAND）必须等于对端 SEND hash。
    #     只用 sha256（同算法比）；FNV hash 只在有对端同算法值时才比，缺则不动。
    c5, c5_detail = 'UNOBSERVED', []
    hash_mism = []
    for r in ROLES:
        opposite = 'PC' if r == 'APP' else 'APP'
        mine, theirs = land.get(r, set()), send.get(opposite, set())
        if not mine:
            c5_detail.append('%s 缺落地 sha256（A1-LAND），fail-closed' % r)
            continue
        if not theirs:
            c5_detail.append('%s 缺对端(%s)发送 sha256，fail-closed' % (r, opposite))
            continue
        # fail-closed：只要有一条落地 hash 不在对端发送 hash 集合里，就判 FAIL，
        # 不允许「多条里有一条对上」掩盖冲突（summary 与日志不一致也要暴露）。
        bad = [v for v in mine if v not in theirs]
        if not bad:
            c5_detail.append('%s land==%s send' % (r, opposite))
        else:
            hash_mism.append('%s land 不匹配项=%s vs %s send=%s' %
                             (r, sorted(bad), opposite, sorted(theirs)))
    if hash_mism:
        c5 = 'FAIL'
        c5_detail.append('hash 不符: ' + '; '.join(hash_mism))
    elif not any('缺' in d for d in c5_detail) and all(
            land.get(r) and send.get('PC' if r == 'APP' else 'APP') for r in ROLES):
        c5 = 'PASS'
    res['C5_HASH_MATCH'] = {'status': c5, 'detail': ' | '.join(c5_detail),
                            'send_sha': {r: sorted(send.get(r, ())) for r in ROLES},
                            'land_sha': {r: sorted(land.get(r, ())) for r in ROLES}}

    applied_verdict = _combine([res[k]['status'] for k in
                                ('C1_RX_RECEIVED', 'C2_APPLIED_TO_MIRROR',
                                 'C3_SLOT_CORRECT', 'C4_BYTES_MATCH', 'C5_HASH_MATCH')])

    # ---------- A1-A4 证据（任务口径；规范标签见 ISYNC7 §2.1）----------
    # A1' seed party == 发送端 live party（规范标签 A3）
    a3_by_role = {r: [e for e in rec['a3'] if e['role'] == r] for r in ROLES}
    a1, a1_detail = 'UNOBSERVED', []
    a1_bad = []
    for r in ROLES:
        if not a3_by_role[r]:
            a1_detail.append('%s 缺 A3 埋点' % r)
            continue
        for e in a3_by_role[r]:
            if e['eq'] != 1 or e['seed'] != EXPECTED_PARTY[r] or e['live'] != EXPECTED_PARTY[r]:
                a1_bad.append('%s seed=%s live=%s eq=%s' % (r, e['seed'], e['live'], e['eq']))
    if a1_bad:
        a1 = 'FAIL'
        a1_detail.append('party 不一致: ' + '; '.join(a1_bad))
    elif all(a3_by_role[r] for r in ROLES):
        a1 = 'PASS'
        a1_detail.append('APP=00D5 / PC=0006，seed==live')
    res['A1_SEED_PARTY_EQ_LIVE'] = {'status': a1, 'detail': ' | '.join(a1_detail)}

    # A2' 双端 hash 相异（防同源自产）
    if send.get('APP') and send.get('PC'):
        if send['APP'] & send['PC']:
            a2, a2_detail = 'FAIL', '两端 send sha256 相同 = 同源自产'
        else:
            a2, a2_detail = 'PASS', '两端 send sha256 相异'
    else:
        a2, a2_detail = 'UNOBSERVED', '缺一端或双端 send sha256'
    res['A2_SEED_HASH_DISTINCT'] = {'status': a2, 'detail': a2_detail}

    # A3' 落槽正确（复用 C3）
    res['A3_TARGET_SLOT_CORRECT'] = {'status': c3, 'detail': res['C3_SLOT_CORRECT']['detail']}

    # A4' applied >= 1
    counts = {r: [e['count'] for e in applied_by_role[r] if e['count'] is not None] for r in ROLES}
    if has_negative:
        a4, a4_detail = 'UNOBSERVED', '存在负向标记，applied 判 UNOBSERVED'
    elif any(any(c == 0 for c in counts[r]) for r in ROLES):
        a4, a4_detail = 'FAIL', 'applied_count=0'
    elif all(counts[r] and all(c >= 1 for c in counts[r]) for r in ROLES):
        a4, a4_detail = 'PASS', '两端 applied_count>=1'
    else:
        a4, a4_detail = 'UNOBSERVED', '缺 applied_count 字段'
    res['A4_APPLIED_COUNT_GE1'] = {'status': a4, 'detail': a4_detail}

    a_verdict = _combine([res[k]['status'] for k in
                          ('A1_SEED_PARTY_EQ_LIVE', 'A2_SEED_HASH_DISTINCT',
                           'A3_TARGET_SLOT_CORRECT', 'A4_APPLIED_COUNT_GE1')])

    res['APPLIED_GATE_VERDICT'] = applied_verdict
    res['A_EVIDENCE_VERDICT'] = a_verdict
    res['VERDICT'] = _combine([applied_verdict, a_verdict])
    res['TAG_CHECK'] = res['tag_check']

    # driver 假阳性识别：summary 声称 loaded，但真实日志有负向标记或无真实 applied。
    # ISYNC25/§1-B：`[PATHB] state_sync=` 与 `[ISYNC] state_sync=` 两种前缀都由
    # `state_sync=` 子串覆盖；queued/buffered/rejected 是诚实口径，绝不计为 loaded、
    # 也不单独触发 false_positive（普通入队不是假阳性载体）。
    claims = rec['state_sync_claim']
    res['driver_state_sync_claim'] = sorted(set(claims))
    res['driver_state_sync_queued_claim'] = sorted(set(c for c in claims if c == 'queued'))
    res['queued_marker_count'] = len(rec['queued'])
    res['driver_state_sync_false_positive'] = bool(
        any(c == 'loaded' for c in claims) and (has_negative or c2 != 'PASS'))
    res['notes'] = [
        '本脚本判 applied 前置门，非对手真实性裁决；门 FAIL / 0/9 不变。',
        '唯一裁决仍是零注入 diff_party_check CROSSED（APP 0006 ↔ PC 00D5）；必要非充分。',
        'FAIL > UNOBSERVED > PASS；字段缺失一律 UNOBSERVED；不伪造、不预设成功。',
        '逐文件读取日志（含 >1MB 大日志）；[PATHB]/[ISYNC] 两前缀 state_sync=loaded 均不作证据。',
        '里程碑受 MGBAX_ISYNC_STATE_APPLY 门控；门 readback=1 仅代表诊断开启，不等于 applied；applied 仍只按 load 成功日志+双源槽证据判。',
        'queued/enqueued 只记录，既非 applied 亦非负向；正常入队不锁死真 applied。',
        'M1FIX: queued 仅种子相关 deferred（排除 AM Enqueued broadcast/OpenGL SyncQueued），'
        '重叠 logcat 按(时间戳+事件)去重，queued_markers=distinct 种子入队数。',
    ]
    return res


def _fmt(res):
    lines = []
    lines.append('=== ISYNC16 seed applied 离线判读 ===')
    lines.append('tag_expected=%s tag_field=%s tag_check=%s' %
                 (res['tag_expected'], res['tag_field'], res['TAG_CHECK']))
    files = res['files']
    lines.append('files_scanned=%d total_bytes=%d over_limit=%d  # 逐文件读取，禁目录级 grep' % (
        sum(1 for f in files if f['scanned']), sum(f['bytes'] for f in files if f['scanned']),
        sum(1 for f in files if f['over_limit'])))
    for k in ('C1_RX_RECEIVED', 'C2_APPLIED_TO_MIRROR', 'C3_SLOT_CORRECT',
              'C4_BYTES_MATCH', 'C5_HASH_MATCH'):
        v = res[k]
        lines.append('%s=%s | %s' % (k, v['status'], v['detail']))
    lines.append('-- A1-A4 证据（任务口径）--')
    for k in ('A1_SEED_PARTY_EQ_LIVE', 'A2_SEED_HASH_DISTINCT',
              'A3_TARGET_SLOT_CORRECT', 'A4_APPLIED_COUNT_GE1'):
        v = res[k]
        lines.append('%s=%s | %s' % (k, v['status'], v['detail']))
    lines.append('APPLIED_GATE_VERDICT=%s' % res['APPLIED_GATE_VERDICT'])
    lines.append('A_EVIDENCE_VERDICT=%s' % res['A_EVIDENCE_VERDICT'])
    lines.append('VERDICT=%s' % res['VERDICT'])
    lines.append('driver_state_sync_claim=%s queued_claim=%s false_positive=%s'
                 ' queued_markers=%d' %
                 (res['driver_state_sync_claim'], res['driver_state_sync_queued_claim'],
                  res['driver_state_sync_false_positive'], res['queued_marker_count']))
    for n in res['notes']:
        lines.append('NOTE: ' + n)
    if res['sample']:
        lines.append('-- 命中样本（前 %d 条，供人工复核）--' % len(res['sample']))
        lines.extend('  ' + s for s in res['sample'][:12])
    return '\n'.join(lines)


# ---------------- 自测（合成日志只写系统临时目录，不碰仓库产物）----------------
PC_SHA = 'a' * 64
APP_SHA = 'b' * 64


def _good_files():
    app = '\n'.join([
        '11-20 06:20:36.725 I GBoyLink: rx TYPE_STATE 37816 bytes',
        '11-20 06:20:36.800 I mGBA-App: peer state loaded (no reset) bytes=37816 index=0 slot=2',
        '11-20 06:20:36.801 I mGBA-App: [ISYNC] remote state loaded slot=2 bytes=37816 hash=1a2b3c4d',
        '[ISYNC-EV][A1-RX] role=APP bytes=37816 sha256=' + PC_SHA,
        '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=37816 sha256=' + PC_SHA,
        '[ISYNC-EV][A1-SEND] role=APP bytes=46091 sha256=' + APP_SHA,
        '[ISYNC-EV][A3] role=APP seed_party_first=00D5 live_party_first=00D5 eq=1',
        '[ISYNC-EV][A4] role=APP side=apply slot=2 bytes=37816 applied_count=1 seed_hash=1a2b3c4d',
    ]) + '\n'
    pc = '\n'.join([
        'I GBoyLink: rx TYPE_STATE 46091 bytes',
        # 合成双源：权威真槽行（真实 PC 日志只有 m_slot 里程碑，此处补一条仅用于
        # 让 C3 双源交叉有 A/B 两源；self-test 全为合成，不产出任何门证据）。
        'peer state loaded (no reset) bytes=46091 index=0 slot=2',
        '[GBoyMirror] applied peer state 46091 bytes slot 2',
        '[ISYNC] remote state loaded slot=2 bytes=46091 hash=5e6f7081',
        '[ISYNC-EV][A1-RX] role=PC bytes=46091 sha256=' + APP_SHA,
        '[ISYNC-EV][A1-LAND] role=PC slot=2 bytes=46091 sha256=' + APP_SHA,
        '[ISYNC-EV][A1-SEND] role=PC path=initial bytes=37816 sha256=' + PC_SHA,
        '[ISYNC-EV][A3] role=PC seed_party_first=0006 live_party_first=0006 eq=1',
        '[ISYNC-EV][A4] role=PC side=apply slot=2 bytes=46091 applied_count=1 seed_hash=5e6f7081',
    ]) + '\n'
    summary = '\n'.join([
        'tag=ISYNC16-SELFTEST',
        'isync_seed_sha_app_send=' + APP_SHA,
        'isync_seed_sha_pc_send=' + PC_SHA,
        'isync_seed_sha_app_rx=' + PC_SHA,
        'isync_seed_sha_pc_rx=' + APP_SHA,
        'isync_seed_sha_app_land=' + PC_SHA,
        'isync_seed_sha_pc_land=' + APP_SHA,
    ]) + '\n'
    return {'app_logcat_full.log': app, 'pc_stdout.log': pc, 'summary.txt': summary}


def _make_run(files):
    d = tempfile.mkdtemp(prefix='isync16_selftest_')
    for name, text in files.items():
        with open(os.path.join(d, name), 'w', encoding='utf-8') as fh:
            fh.write(text)
    return d


def _selftest():
    import copy
    passed, total = 0, 0

    def check(name, cond):
        nonlocal passed, total
        total += 1
        if cond:
            passed += 1
            print('SELFTEST PASS: ' + name)
        else:
            print('SELFTEST FAIL: ' + name)

    # (1) 真实基线 BUSFIX-A-02：seed 仍 not applied → 期望 UNOBSERVED + 识破假阳性
    root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    baseline = os.path.join(root, '.zcode-tmp', 'cloud2p', 'BUSFIX-A-02')
    if os.path.isdir(baseline):
        r = judge(scan_run(baseline), 'BUSFIX-A-02')
        check('BUSFIX-A-02 基线 VERDICT=UNOBSERVED', r['VERDICT'] == 'UNOBSERVED')
        check('BUSFIX-A-02 C2=UNOBSERVED', r['C2_APPLIED_TO_MIRROR']['status'] == 'UNOBSERVED')
        check('BUSFIX-A-02 识破 state_sync=loaded 假阳性',
              r['driver_state_sync_false_positive'] is True)
    else:
        print('SELFTEST SKIP: BUSFIX-A-02 基线目录不存在（%s）' % baseline)

    # (2) 合成全正向日志 → 期望 applied 门与 A 证据全 PASS
    d = _make_run(_good_files())
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('合成正向 APPLIED_GATE_VERDICT=PASS', r['APPLIED_GATE_VERDICT'] == 'PASS')
        check('合成正向 A_EVIDENCE_VERDICT=PASS', r['A_EVIDENCE_VERDICT'] == 'PASS')
        check('合成正向 VERDICT=PASS', r['VERDICT'] == 'PASS')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (3) 合成「not applied yet + state_sync=loaded」→ 必须 UNOBSERVED，识破假阳性
    f = _good_files()
    f['app_logcat_full.log'] += 'W mGBA-App: TYPE_STATE not applied yet (consoles not ready)\n'
    f['summary.txt'] += '[PATHB] state_sync=loaded  # TYPE_STATE/remote state loaded\n'
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('not applied → C2=UNOBSERVED', r['C2_APPLIED_TO_MIRROR']['status'] == 'UNOBSERVED')
        check('not applied → VERDICT=UNOBSERVED', r['VERDICT'] == 'UNOBSERVED')
        check('not applied → driver 假阳性=True', r['driver_state_sync_false_positive'] is True)
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (4) 合成错误槽（APP 里程碑落可见核/SELF_ECHO）→ 期望 C3=FAIL
    #     ISYNC25 后 slot=1 本身合法（localSlot=2），可见核陷阱靠 visibleSlot 令牌识别。
    f = _good_files()
    f['app_logcat_full.log'] = f['app_logcat_full.log'].replace('index=0 slot=2', 'index=0 slot=1') \
        .replace('remote state loaded slot=2',
                 'remote state loaded mirrorSlot=1 (visibleSlot=1)') \
        .replace('role=APP side=apply slot=2', 'role=APP side=apply slot=1') \
        .replace('role=APP slot=2 bytes=37816', 'role=APP slot=1 bytes=37816')
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('错误槽 → C3=FAIL', r['C3_SLOT_CORRECT']['status'] == 'FAIL')
        check('错误槽 → VERDICT=FAIL', r['VERDICT'] == 'FAIL')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (5) 只有 rx 无 applied → UNOBSERVED（rx 不等于 applied）
    f = {'app_logcat_full.log': 'I GBoyLink: rx TYPE_STATE 37816 bytes\n',
         'pc_stdout.log': 'I GBoyLink: rx TYPE_STATE 46091 bytes\n',
         'summary.txt': 'tag=ISYNC16-SELFTEST\n'}
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('仅 rx → C1=PASS', r['C1_RX_RECEIVED']['status'] == 'PASS')
        check('仅 rx → C2=UNOBSERVED', r['C2_APPLIED_TO_MIRROR']['status'] == 'UNOBSERVED')
        check('仅 rx → VERDICT=UNOBSERVED', r['VERDICT'] == 'UNOBSERVED')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (6) applied 有但 hash 缺失 → C5=UNOBSERVED（fail-closed）
    f = _good_files()
    f['app_logcat_full.log'] = '\n'.join(
        ln for ln in f['app_logcat_full.log'].splitlines() if '[A1-LAND]' not in ln) + '\n'
    f['pc_stdout.log'] = '\n'.join(
        ln for ln in f['pc_stdout.log'].splitlines() if '[A1-LAND]' not in ln) + '\n'
    f['summary.txt'] = '\n'.join(
        ln for ln in f['summary.txt'].splitlines() if '_land=' not in ln) + '\n'
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('hash 缺失 → C5=UNOBSERVED', r['C5_HASH_MATCH']['status'] == 'UNOBSERVED')
        check('hash 缺失 → VERDICT=UNOBSERVED', r['VERDICT'] == 'UNOBSERVED')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (7) land hash 与对端 send hash 不符 → C5=FAIL
    f = _good_files()
    f['app_logcat_full.log'] = f['app_logcat_full.log'].replace(
        '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=37816 sha256=' + PC_SHA,
        '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=37816 sha256=' + 'c' * 64)
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('hash 不符 → C5=FAIL', r['C5_HASH_MATCH']['status'] == 'FAIL')
        check('hash 不符 → VERDICT=FAIL', r['VERDICT'] == 'FAIL')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # ---------- ISYNC25 新增 9 例（合成日志，仍只写 tempfile）----------
    def _strip_applied(ff):
        """删掉全部真实 applied 里程碑（权威行/里程碑/A4），保留 rx/A1/A3。"""
        for k in ('app_logcat_full.log', 'pc_stdout.log'):
            ff[k] = '\n'.join(
                ln for ln in ff[k].splitlines()
                if not any(t in ln for t in ('peer state loaded',
                                             'remote state loaded',
                                             'applied peer state',
                                             '[A4]'))) + '\n'
        return ff

    def _dual_fixture(auth_slot, mile_line, mile_slot):
        """在 _good_files 基础上把 APP 权威行/里程碑行替换为 G2 修复后形态，
        供 C3 双源交叉测试。A4/A1-LAND 的槽号同步到 mile_slot 保持一致。"""
        f = _good_files()
        f['app_logcat_full.log'] = f['app_logcat_full.log'] \
            .replace('peer state loaded (no reset) bytes=37816 index=0 slot=2',
                     'peer state loaded (no reset) bytes=37816 index=0 slot=%d' % auth_slot) \
            .replace('[ISYNC] remote state loaded slot=2 bytes=37816 hash=1a2b3c4d',
                     mile_line) \
            .replace('[ISYNC-EV][A4] role=APP side=apply slot=2',
                     '[ISYNC-EV][A4] role=APP side=apply slot=%d' % mile_slot) \
            .replace('[ISYNC-EV][A1-LAND] role=APP slot=2',
                     '[ISYNC-EV][A1-LAND] role=APP slot=%d' % mile_slot)
        return f

    # (8) queued 不误判：含 queued 但无真 load → UNOBSERVED，queued 桶非空，无 loaded claim
    f = _strip_applied(_good_files())
    f['app_logcat_full.log'] += (
        '[ISYNC] TYPE_STATE queued 46091 bytes (mirror slot=2; real load is async)\n')
    d = _make_run(f)
    try:
        rec = scan_run(d)
        r = judge(rec, 'ISYNC16-SELFTEST')
        check('(8) queued无真load→C2/VERDICT=UNOBSERVED且queued桶非空且无loaded claim',
              r['C2_APPLIED_TO_MIRROR']['status'] == 'UNOBSERVED'
              and r['VERDICT'] == 'UNOBSERVED'
              and len(rec['queued']) >= 1
              and 'loaded' not in r['driver_state_sync_claim'])
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (9) queued + loaded 共存不过度纠正：正常入队不得把真 applied 锁成 UNOBSERVED
    f = _good_files()
    f['app_logcat_full.log'] += (
        '[ISYNC] TYPE_STATE queued 46091 bytes (mirror slot=2; real load is async)\n')
    f['pc_stdout.log'] += (
        '[ISYNC] TYPE_STATE queued 37816 bytes (mirror slot=2; real load is async)\n')
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('(9) queued+真load共存→C2=PASS且VERDICT=PASS(未过度纠正)',
              r['C2_APPLIED_TO_MIRROR']['status'] == 'PASS'
              and r['VERDICT'] == 'PASS')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (10) localSlot=1 → mirrorSlot=2 正确例（回归旧行为，双源一致）
    f = _dual_fixture(
        2, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2 (visibleSlot=1)'
        ' hash=1a2b3c4d', 2)
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('(10) localSlot=1→mirrorSlot=2 双源一致→C3=PASS且VERDICT=PASS',
              r['C3_SLOT_CORRECT']['status'] == 'PASS' and r['VERDICT'] == 'PASS')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (11) localSlot=2 → mirrorSlot=1 正确例（ISYNC25 关键发现：写死 slot==2 是错的）
    f = _dual_fixture(
        1, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=1 (visibleSlot=2)'
        ' hash=1a2b3c4d', 1)
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('(11) localSlot=2→mirrorSlot=1 双源一致→C3=PASS(旧硬编码slot==2会误FAIL)',
              r['C3_SLOT_CORRECT']['status'] == 'PASS' and r['VERDICT'] == 'PASS')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (12) G2 可见核陷阱：里程碑 slot=visibleSlotIdx（SELF_ECHO）→ FAIL
    f = _dual_fixture(
        1, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=1 (visibleSlot=1)'
        ' hash=1a2b3c4d', 1)
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'ISYNC16-SELFTEST')
        check('(12) G2里程碑落可见核槽→C3=FAIL且VERDICT=FAIL',
              r['C3_SLOT_CORRECT']['status'] == 'FAIL' and r['VERDICT'] == 'FAIL')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (13) 双源冲突→FAIL；单源→UNOBSERVED
    dlist = []
    try:
        f = _dual_fixture(
            1, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2'
            ' hash=1a2b3c4d', 2)
        dlist.append(_make_run(f))
        r_conflict = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')
        f = _dual_fixture(
            1, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=1'
            ' (visibleSlot=2) hash=1a2b3c4d', 1)
        f['app_logcat_full.log'] = '\n'.join(
            ln for ln in f['app_logcat_full.log'].splitlines()
            if 'peer state loaded (no reset)' not in ln) + '\n'
        dlist.append(_make_run(f))
        r_single = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')
        check('(13) 双源冲突→C3=FAIL/VERDICT=FAIL且单源→C3=UNOBSERVED',
              r_conflict['C3_SLOT_CORRECT']['status'] == 'FAIL'
              and r_conflict['VERDICT'] == 'FAIL'
              and r_single['C3_SLOT_CORRECT']['status'] == 'UNOBSERVED')
    finally:
        for d in dlist:
            shutil.rmtree(d, ignore_errors=True)

    # (14) slot=0 非法返回 / index!=0 异常 → 均 C3=FAIL
    dlist = []
    try:
        f = _dual_fixture(
            0, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=0'
            ' hash=1a2b3c4d', 0)
        dlist.append(_make_run(f))
        r_slot0 = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')
        f = _dual_fixture(
            2, '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2'
            ' (visibleSlot=1) hash=1a2b3c4d', 2)
        f['app_logcat_full.log'] = f['app_logcat_full.log'].replace(
            'peer state loaded (no reset) bytes=37816 index=0 slot=2',
            'peer state loaded (no reset) bytes=37816 index=1 slot=2')
        dlist.append(_make_run(f))
        r_index = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')
        check('(14) slot=0与index!=0→C3=FAIL且VERDICT=FAIL',
              r_slot0['C3_SLOT_CORRECT']['status'] == 'FAIL'
              and r_slot0['VERDICT'] == 'FAIL'
              and r_index['C3_SLOT_CORRECT']['status'] == 'FAIL'
              and r_index['VERDICT'] == 'FAIL')
    finally:
        for d in dlist:
            shutil.rmtree(d, ignore_errors=True)

    # (15) G3 门控：关门无里程碑 / 开门仅 queued / 真 applied PASS；门字段不作 PASS 条件
    good_mile = ('[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2'
                 ' (visibleSlot=1) hash=1a2b3c4d')
    dlist = []
    try:
        f = _strip_applied(_good_files())
        f['summary.txt'] += '[ISYNC] state_apply_gate=0\n'
        dlist.append(_make_run(f))
        r_gate0_no = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')

        f = _strip_applied(_good_files())
        f['summary.txt'] += '[ISYNC] state_apply_gate=1\n'
        f['app_logcat_full.log'] += '[ISYNC] TYPE_STATE queued 46091 bytes\n'
        dlist.append(_make_run(f))
        r_gate1_queued = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')

        f = _dual_fixture(2, good_mile, 2)
        f['summary.txt'] += '[ISYNC] state_apply_gate=1\n'
        dlist.append(_make_run(f))
        r_gate1_loaded = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')

        f = _dual_fixture(2, good_mile, 2)
        f['summary.txt'] += '[ISYNC] state_apply_gate=0\n'
        dlist.append(_make_run(f))
        r_gate0_loaded = judge(scan_run(dlist[-1]), 'ISYNC16-SELFTEST')

        check('(15) G3门控: 关门无里程碑UNOBSERVED/开门仅queued UNOBSERVED/'
              '真applied PASS/门字段不作PASS条件',
              r_gate0_no['VERDICT'] == 'UNOBSERVED'
              and r_gate1_queued['VERDICT'] == 'UNOBSERVED'
              and r_gate1_loaded['VERDICT'] == 'PASS'
              and r_gate0_loaded['VERDICT'] == 'PASS')
    finally:
        for d in dlist:
            shutil.rmtree(d, ignore_errors=True)

    # (16) `[ISYNC] state_sync=queued` 兜底：不算 loaded、不触发假阳性、C2=UNOBSERVED
    f = _strip_applied(_good_files())
    f['summary.txt'] += '[ISYNC] state_sync=queued\n'
    d = _make_run(f)
    try:
        rec = scan_run(d)
        r = judge(rec, 'ISYNC16-SELFTEST')
        check('(16) [ISYNC] state_sync=queued兜底: 不触发假阳性/C2=UNOBSERVED/queued单列',
              r['driver_state_sync_false_positive'] is False
              and r['driver_state_sync_claim'] == ['queued']
              and 'queued' in r['driver_state_sync_queued_claim']
              and r['C2_APPLIED_TO_MIRROR']['status'] == 'UNOBSERVED')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (17) M1FIX 收窄：ActivityManager `Enqueued broadcast Intent` 不计入 queued
    #      仅 `TYPE_STATE deferred: consoles not ready, queued` 计入（中立桶）。
    f = _strip_applied(_good_files())
    f['app_logcat_full.log'] += '\n'.join([
        '11-20 07:35:20.672   519  1597 I ActivityManager: Enqueued broadcast Intent'
        ' { act=io.mgba.android.action.ROM flg=0x400000 (has extras) }: 0',
        '11-20 07:35:25.905   519  1732 I ActivityManager: Enqueued broadcast Intent'
        ' { act=io.mgba.android.action.ISYNC_STATE_APPLY flg=0x400000 (has extras) }: 0',
        '11-20 07:35:42.573   519  1732 I ActivityManager: Enqueued broadcast Intent'
        ' { act=io.mgba.android.action.KEYS flg=0x400000 (has extras) }: 0',
        '11-20 07:36:10.146 16729 16729 W mGBA-App: TYPE_STATE deferred:'
        ' consoles not ready, queued (ISYNC bounded retry)',
    ]) + '\n'
    d = _make_run(f)
    try:
        rec = scan_run(d)
        r = judge(rec, 'ISYNC16-SELFTEST')
        check('(17) AM Enqueued broadcast不计入queued(仅种子deferred计数)/VERDICT不变',
              r['queued_marker_count'] == 1
              and all('activitymanager' not in e['text'].lower() for e in rec['queued'])
              and r['VERDICT'] == 'UNOBSERVED')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (18) M1FIX 去重叠：两份 logcat 副本同一(时间戳+事件)只计一次，3 包不双计为 6。
    seed_deferred = [
        '11-20 07:36:10.146 16729 16729 W mGBA-App: TYPE_STATE deferred:'
        ' consoles not ready, queued (ISYNC bounded retry)',
        '11-20 07:36:14.768 16729 16729 W mGBA-App: TYPE_STATE deferred:'
        ' consoles not ready, queued (ISYNC bounded retry)',
        '11-20 07:36:19.788 16729 16729 W mGBA-App: TYPE_STATE deferred:'
        ' consoles not ready, queued (ISYNC bounded retry)',
    ]
    f = _strip_applied(_good_files())
    f['app_logcat_full.log'] += '\n'.join(seed_deferred) + '\n'
    f['app_link_startup.log'] = '\n'.join(seed_deferred) + '\n'  # 重叠副本
    d = _make_run(f)
    try:
        rec = scan_run(d)
        r = judge(rec, 'ISYNC16-SELFTEST')
        check('(18) 重叠logcat按(时间戳+事件)去重,3条种子入队不双计为6',
              r['queued_marker_count'] == 3
              and len(rec['queued']) == 3)
    finally:
        shutil.rmtree(d, ignore_errors=True)

    print('SELFTEST_SUMMARY: %d/%d passed' % (passed, total))
    return 0 if passed == total else 1


def main(argv=None):
    ap = argparse.ArgumentParser(description='ISYNC16 seed applied 离线判读（只读）')
    ap.add_argument('run_dir', nargs='?', help='E2E run 目录')
    ap.add_argument('tag', nargs='?', help='期望 tag（可选，核对 summary tag）')
    ap.add_argument('--json', action='store_true', help='输出 JSON')
    ap.add_argument('--selftest', action='store_true', help='运行自测（合成日志写系统临时目录）')
    args = ap.parse_args(argv)
    if args.selftest:
        return _selftest()
    if not args.run_dir:
        ap.print_usage()
        return 2
    res = judge(scan_run(args.run_dir), args.tag)
    if args.json:
        print(json.dumps(res, ensure_ascii=False, indent=2))
    else:
        print(_fmt(res))
    return {'PASS': 0, 'FAIL': 1, 'UNOBSERVED': 3}[res['VERDICT']]


if __name__ == '__main__':
    sys.exit(main())
