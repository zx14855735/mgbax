#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""CRASHJUDGE — seed applied SIGSEGV 守卫修复的 A/B 机械判读（只读，不改源码/产物/不编译/不跑 E2E）。

用法：
    python tools/crash_ab_check.py <B_run目录> <A_run目录> [--json] [--frm-min N]
    python tools/crash_ab_check.py --selftest

A/B 设计（CRASHAB）—— 唯一变量 = MGBAX_STATE_REARM_GUARD 门值：
  * B 轮 CRASHFIX-B-01：门=0（default），期望 seed applied 后复现 SIGSEGV
    （Fatal signal 11 / SEGV / tombstone mirrorLoop / has died / rip=0x0）。
  * A 轮 CRASHFIX-A-01：门=1，期望不崩、mirrorLoop 继续 runFrames、BOOT 指纹、
    真 applied 里程碑、无 deferred/bounded exhausted、门回读=1、进战斗窗。
  * driver 用 --env MGBAX_STATE_REARM_GUARD=1/0 下发（无独立 flag）；setprop 回读
    在 avd_driver.log，形如 `setprop debug.mgbax.link.state_rearm_guard=1 readback=1`。

判据输出：
  B_REPRODUCED = PASS(复现且 applied 有效) / UNOBSERVED(applied 有效但未复现) / INVALID(applied 都没发生)
  A_FIXED      = PASS(全部必需项成立) / FAIL(仍崩或里程碑自相矛盾) / UNOBSERVED(证据不足)
  AB_VERDICT   = STRONG_CAUSAL / GUARD_INSUFFICIENT / ROOT_CAUSE_WRONG / INVALID_ABORT / INCONCLUSIVE

防伪与纪律：
  * 逐文件逐行扫描（含 >1MB 大日志），绝不用目录级 grep 漏报；二进制/超限文件跳过并声明。
  * 门回读失败（缺行 / readback!=1 / WARN 未生效）一律 UNOBSERVED。
  * `mirrorLoop` 只在 tombstone/栈帧上下文计为崩溃信号；正常 mirrorLoop 生命周期行
    不计崩溃（防「提到 mirrorLoop 就算崩」的假阳性）。
  * 负向标记用完整事件模式（TYPE_STATE deferred / consoles not ready / bounded
    exhausted），且排除 driver 观测载体行（applied=loaded / negative_marker=0，
    deferred 仅在注释）——防「注释提到 deferred 就算负向」的假阳性。
  * FAIL > UNOBSERVED > PASS；字段缺失一律 UNOBSERVED；不预设成功、不伪造。
  * 本脚本只判「崩溃修复门」，不判对手真实性；CROSSED 由 diff_party_check 另案裁决。
    门维持 FAIL / 对手真实性 0/9；修崩溃 == 必要非充分，不等于成功。

退出码：0=STRONG_CAUSAL / 1=其它结论 / 2=INVALID_ABORT 或输入错误。
中文注释，不伪造。
"""

import argparse
import json
import os
import re
import shutil
import sys
import tempfile

# 只扫文本类日志；二进制一律不读（源码/产物同理跳过）。
TEXT_EXTS = ('.log', '.txt', '.out')
SKIP_EXT = {
    '.gba', '.sav', '.png', '.jpg', '.jpeg', '.gif', '.zip', '.dex', '.db',
    '.exe', '.elf', '.so', '.dll', '.pyc', '.ppm', '.bmp', '.pdf', '.7z',
    '.gz', '.py', '.class', '.ipa', '.apk', '.mp4', '.o', '.a',
}
MAX_FILE_BYTES = 256 * 1024 * 1024
DEFAULT_FRM_MIN = 3

# ---- 崩溃信号（B 期望出现，A 期望绝不出现）----
_CRASH_PATS = (
    r'fatal\s+signal\s+11',          # Android tombstone 头：Fatal signal 11 (SIGSEGV)...
    r'\bSIGSEGV\b',
    r'\bSEGV\b',                      # SEGV_MAPERR / SEGV_ACCERR
    r'\bhas\s+died\b',                # Process io.mgba.android has died
    r'tombstone\s+written\s+to\b',    # Tombstone written to: /data/tombstones/...
    r'/data/tombstones/',
    r'beginning\s+of\s+crash',
    r'rip\s*[=:]\s*0x0+\b',           # PC 侧崩溃落点 rip=0x0
    r'rip\s+0x0+\b',
    r'fault\s+addr\s+0x0+\b',         # null callback 解引用
)
# mirrorLoop 只有出现在 tombstone 栈帧（`#NN pc ... mirrorLoop`)）或与 tombstone
# 同现才算崩溃证据；正常生命周期行 `mirrorLoop started` 不算。
_CRASH_MIRROR_FRAMERE = re.compile(r'#\s*\d+\s+pc\b.*mirrorLoop\)', re.I)
_TOMBSTONE_RE = re.compile(
    r'tombstone\s+written\s+to\b|/data/tombstones/|beginning\s+of\s+crash', re.I)

# ---- seed applied 里程碑（B/A 都要确认 applied 真发生过）----
_APPLIED_HIT_RE = re.compile(
    r'remote\s+state\s+loaded|peer\s+state\s+loaded|applied\s+peer\s+state'
    r'|\[ISYNC-EV\]\[A4\][^\n]*side\s*=\s*apply', re.I)
# 负向上下文：deferred/queued/not applied 绝不当 applied 里程碑。
_APPLIED_NEG_CTX_RE = re.compile(
    r'\bnot\s+applied\b|\bdeferred\b|\bqueued\b|\benqueued\b'
    r'|\brejected\b|\bexhausted\b|consoles?\s+not\s+ready', re.I)

# ---- BOOT 指纹 ----
_BOOT_RE = re.compile(r'\[ISYNC-EV\]\[BOOT\]', re.I)
_BOOT_HAS_RE = re.compile(r'\bhasCurrent\s*=\s*([01])\b', re.I)
_BOOT_PATH_RE = re.compile(r'\bpathResolved\s*=\s*([01])\b', re.I)

# ---- 门回读（avd_driver.log）----
_GATE_RE = re.compile(
    r'setprop\s+debug\.mgbax\.link\.state_rearm_guard\s*=\s*([01])'
    r'(?:\s+readback\s*=\s*([^\s]+))?', re.I)

# ---- 负向标记（deferred / bounded exhausted / rejected ...）----
# 真负向必须是 app 日志的「正面事件行」，用完整事件模式，不能用裸 \bdeferred\b：
#   `TYPE_STATE deferred: consoles not ready, queued (ISYNC bounded retry)`
#   `bounded wait exhausted tries=N`
# 否则会误匹配 driver 观测载体行的注释文字（deferred/负向(无真load)→UNOBSERVED）。
_NEG_EVENT_RE = re.compile(
    r'type_state[^\n]*deferred'
    r'|deferred\s*:\s*consoles?\s+not\s+ready'
    r'|\bconsoles?\s+not\s+ready\b'
    r'|\bbounded\s+(?:wait|retry)\s+exhausted\b'
    r'|\bnot\s+applied\b|\bnot-applied\b'
    r'|\bpeer\s+state\s+rejected\b'
    r'|\bseed\s+unconsumed\b'
    r'|\bapply\s+failed\b|\bload\s+failed\b'
    r'|\brejected\b|\bexhausted\b', re.I)
_STATE_CTX_RE = re.compile(
    r'type_state|\bstate\b|\bseed\b|\bpeer\b|\bpending\b|\bconsol'
    r'|\bapply\b|\bload\b|\bslot\b|\bexhausted\b', re.I)
# driver 观测载体行：令牌值是 applied=loaded / negative_marker=0，deferred 等词
# 只出现在 `#` 注释里，不是真负向事件（与 isync_applied_check 假阳性兜底同口径）。
# 命中任一令牌 / 注释模式即排除，不进入 negative。
_DRIVER_CARRIER_TOKEN_RE = re.compile(
    r'\bstate_sync\s*=|\[isync\]\s+applied\s*=|\bnegative_marker\s*='
    r'|\[pathb\]|\bapplied\s*=\s*loaded\b', re.I)
_DRIVER_COMMENT_DEFERRED_RE = re.compile(r'#\s*[^\n]*\bdeferred\b', re.I)


def _is_driver_observation_carrier(text):
    """driver 观测载体行（applied=loaded / negative_marker=0，deferred 仅在注释）
    绝不计为真实负向标记，防 CRASHJUDGE-A 那类假阳性。"""
    return bool(_DRIVER_CARRIER_TOKEN_RE.search(text)
                or _DRIVER_COMMENT_DEFERRED_RE.search(text))

# ---- mirrorLoop 存活采样 / 战斗窗（信息项）----
_FRM_RE = re.compile(r'\bFRM\b', re.I)
_EMUFPS_RE = re.compile(r'\bemuFps\s*=\s*([0-9.]+)', re.I)
_FRAMES_RE = re.compile(r'\bframes\s*=\s*(\d+)', re.I)
_BATTLE_RE = re.compile(r'\[BATTLE\b|\bbtlType\s*=', re.I)


def _token(text, key, pattern=r'([^\s]+)'):
    m = re.search(r'\b' + re.escape(key) + r'\s*=\s*' + pattern, text, re.I)
    return m.group(1) if m else None


def _new_records():
    return {
        'files': [], 'sample': [],
        'crash': [],       # {where, text, kind}
        'applied': [],     # {where, text, slot, mirror_slot, visible_slot, index, bytes}
        'boot': [],        # {where, text, has_current, path_resolved}
        'gate': [],        # {where, text, setprop, readback, ok}
        'negative': [],    # {where, text}
        'frm': [],         # {where, text, emu_fps, frames}
        'mirror_activity': [],  # {where, text} 正常 mirrorLoop 生命周期行（非崩溃）
        'battle': [],      # {where, text}
    }


def _add_sample(rec, rel, lineno, text):
    if len(rec['sample']) < 160:
        rec['sample'].append('%s:%d: %s' % (rel, lineno, text.strip()[:240]))


def _as_int(value):
    """_token 返回的是字符串；统一转 int，非法返回 None（fail-closed）。"""
    if value is None:
        return None
    try:
        return int(value, 10)
    except (TypeError, ValueError):
        return None


def _is_applied_real(e):
    """里程碑落真槽：index==0 且槽非 0、非可见核槽（SELF_ECHO 陷阱）。"""
    slot = _as_int(e['mirror_slot'] if e['mirror_slot'] is not None else e['slot'])
    index = _as_int(e['index'])
    visible = _as_int(e['visible_slot'])
    if slot is None:
        return False, '缺槽字段'
    if index is None:
        return False, '缺 index 字段'
    if index != 0:
        return False, 'index!=0'
    if slot == 0:
        return False, 'slot=0 非法'
    if visible is not None and slot == visible:
        return False, '落可见核槽(SELF_ECHO)'
    return True, 'index=0 真槽=%d' % slot


def _classify_line(rel, lineno, text, rec):
    low = text.lower()

    # 1) 崩溃信号：显式崩溃模式；mirrorLoop 仅 tombstone/栈帧上下文计崩溃。
    crash_kind = None
    for pat in _CRASH_PATS:
        if re.search(pat, text, re.I):
            crash_kind = pat
            break
    if crash_kind is None:
        if _CRASH_MIRROR_FRAMERE.search(text) or (
                _TOMBSTONE_RE.search(text) and 'mirrorloop' in low):
            crash_kind = 'tombstone:mirrorLoop'
    if crash_kind:
        rec['crash'].append({'where': '%s:%d' % (rel, lineno),
                             'text': text.strip()[:240], 'kind': crash_kind})
        _add_sample(rec, rel, lineno, text)

    # 2) 正常 mirrorLoop 活动（仅信息，绝不当崩溃）。
    if 'mirrorloop' in low and crash_kind is None:
        rec['mirror_activity'].append({'where': '%s:%d' % (rel, lineno),
                                       'text': text.strip()[:240]})

    # 3) seed applied 里程碑：负向上下文行（deferred/queued/not applied）不算。
    #    另须排除 driver 假阳性载体：`[PATHB]/[ISYNC] state_sync=...  # ... remote state
    #    loaded` 只是在注释里引用该短语，不是 load 成功事件（isync_applied_check 同口径）。
    if ('state_sync=' not in low and _APPLIED_HIT_RE.search(text)
            and not _APPLIED_NEG_CTX_RE.search(text)):
        mirror_slot = _token(text, 'mirrorSlot', r'(\d+)')
        rec['applied'].append({
            'where': '%s:%d' % (rel, lineno),
            'text': text.strip()[:240],
            'slot': _token(text, 'slot', r'(\d+)'),
            'mirror_slot': mirror_slot,
            'visible_slot': _token(text, 'visibleSlot', r'(\d+)'),
            'index': _token(text, 'index', r'(\d+)'),
            'bytes': _token(text, 'bytes', r'(\d+)'),
        })
        _add_sample(rec, rel, lineno, text)

    # 4) BOOT 指纹
    if _BOOT_RE.search(text):
        h = _BOOT_HAS_RE.search(text)
        p = _BOOT_PATH_RE.search(text)
        rec['boot'].append({'where': '%s:%d' % (rel, lineno),
                            'text': text.strip()[:240],
                            'has_current': int(h.group(1)) if h else None,
                            'path_resolved': int(p.group(1)) if p else None})
        _add_sample(rec, rel, lineno, text)

    # 5) 门回读（setprop + readback 必须同现且都为 1）
    gm = _GATE_RE.search(text)
    if gm:
        rb = gm.group(2)
        ok = (gm.group(1) == '1' and rb is not None and rb.strip() == '1'
              and 'warn' not in low)
        rec['gate'].append({'where': '%s:%d' % (rel, lineno),
                            'text': text.strip()[:240],
                            'setprop': gm.group(1), 'readback': rb, 'ok': ok})
        _add_sample(rec, rel, lineno, text)

    # 6) 负向标记：真负向事件 + state 上下文；排除 driver 观测载体行（假阳性兜底）。
    #    载体行的 deferred 只是注释说明、值为 applied=loaded / negative_marker=0，
    #    不得计入 negative（否则 NO_DEFERRED_EXHAUSTED 误判 UNOBSERVED）。
    if (_NEG_EVENT_RE.search(text) and _STATE_CTX_RE.search(text)
            and not _is_driver_observation_carrier(text)):
        rec['negative'].append({'where': '%s:%d' % (rel, lineno),
                                'text': text.strip()[:240]})
        _add_sample(rec, rel, lineno, text)

    # 7) FRM 存活采样
    if _FRM_RE.search(text) and 'emufps=' in low:
        f = _EMUFPS_RE.search(text)
        n = _FRAMES_RE.search(text)
        rec['frm'].append({'where': '%s:%d' % (rel, lineno),
                           'text': text.strip()[:240],
                           'emu_fps': f.group(1) if f else None,
                           'frames': n.group(1) if n else None})

    # 8) 战斗窗（信息项，可选判据）
    if _BATTLE_RE.search(text):
        rec['battle'].append({'where': '%s:%d' % (rel, lineno),
                              'text': text.strip()[:240]})


def scan_run(run_dir):
    """逐文件逐行扫描 run 目录；返回 rec。不读二进制、不读超限文件并声明。"""
    rec = _new_records()
    rec['run_dir'] = os.path.abspath(run_dir) if run_dir else None
    if not run_dir or not os.path.isdir(run_dir):
        rec['scan_error'] = '不是有效目录: %s' % run_dir
        return rec
    for root, _dirs, files in os.walk(run_dir):
        for name in sorted(files):
            full = os.path.join(root, name)
            rel = os.path.relpath(full, run_dir).replace('\\', '/')
            ext = os.path.splitext(name)[1].lower()
            if ext not in TEXT_EXTS or ext in SKIP_EXT:
                continue
            try:
                size = os.path.getsize(full)
            except OSError:
                continue
            if size > MAX_FILE_BYTES:
                rec['files'].append({'path': rel, 'bytes': size,
                                     'scanned': False, 'over_limit': True})
                continue
            rec['files'].append({'path': rel, 'bytes': size,
                                 'scanned': True, 'over_limit': False})
            try:
                with open(full, 'r', encoding='utf-8', errors='replace') as fh:
                    for lineno, line in enumerate(fh, 1):
                        _classify_line(rel, lineno, line.rstrip('\r\n'), rec)
            except OSError:
                pass
    return rec


def judge_b(rec):
    """B 轮（门=0）：期望复现崩溃，但前提是 seed 真 applied 过。"""
    applied_ok = bool(rec['applied'])
    crash_seen = bool(rec['crash'])
    if not applied_ok:
        status = 'INVALID'
        detail = 'B 轮未见 TYPE_STATE remote state loaded 等 applied 里程碑：实验前提不成立'
    elif crash_seen:
        status = 'PASS'
        detail = 'B 轮 applied 有效且观测到 SIGSEGV/tombstone 崩溃信号（根因复现）'
    else:
        status = 'UNOBSERVED'
        detail = 'B 轮 applied 有效但未观测到崩溃（不反驳根因：可能未命中崩溃窗口）'
    return {
        'status': status, 'applied_ok': applied_ok, 'crash_seen': crash_seen,
        'applied_count': len(rec['applied']), 'crash_count': len(rec['crash']),
        'detail': detail,
        'crash_sample': rec['crash'][:6], 'applied_sample': rec['applied'][:4],
    }


def judge_a(rec, frm_min):
    """A 轮（门=1）：期望不崩且 6 项必需判据成立；战斗窗为可选信息项。"""
    files_scanned = sum(1 for f in rec['files'] if f['scanned'])
    checks = {}

    # ① 无 Fatal/SIGSEGV
    if not files_scanned:
        checks['NO_CRASH'] = ('UNOBSERVED', '无可扫描日志文件')
    elif rec['crash']:
        checks['NO_CRASH'] = ('FAIL', 'A 轮仍观测到崩溃信号（%d 条）' % len(rec['crash']))
    else:
        checks['NO_CRASH'] = ('PASS', '已扫描 %d 文件，无 Fatal/SIGSEGV/tombstone' % files_scanned)

    # ② BOOT 指纹 [ISYNC-EV][BOOT] hasCurrent=1 pathResolved=1（同一行）
    pos = [b for b in rec['boot']
           if b['has_current'] == 1 and b['path_resolved'] == 1]
    neg = [b for b in rec['boot']
           if b['has_current'] == 0 or b['path_resolved'] == 0]
    if pos:
        checks['BOOT_FINGERPRINT'] = ('PASS', '%s' % pos[0]['where'])
    elif neg:
        checks['BOOT_FINGERPRINT'] = ('FAIL', 'BOOT 指纹出现 hasCurrent=0/pathResolved=0')
    else:
        checks['BOOT_FINGERPRINT'] = ('UNOBSERVED', '缺同一行 hasCurrent=1 + pathResolved=1 的 BOOT 指纹')

    # ③ 真 applied 里程碑（mirrorSlot 真槽、index=0）
    real = []
    bad = []
    for e in rec['applied']:
        ok, why = _is_applied_real(e)
        (real if ok else bad).append((e, why))
    if real:
        checks['APPLIED_MILESTONE'] = ('PASS', '%s（%s）' % (real[0][0]['where'], real[0][1]))
    elif bad:
        checks['APPLIED_MILESTONE'] = ('FAIL', '里程碑落非法槽: %s' % bad[0][1])
    else:
        checks['APPLIED_MILESTONE'] = ('UNOBSERVED', '缺真实 applied 里程碑（rx/deferred 不等于 applied）')

    # ④ 无 deferred/bounded exhausted（fail-closed：出现即 UNOBSERVED）
    if not files_scanned:
        checks['NO_DEFERRED_EXHAUSTED'] = ('UNOBSERVED', '无可扫描日志文件')
    elif rec['negative']:
        checks['NO_DEFERRED_EXHAUSTED'] = (
            'UNOBSERVED', '出现 %d 条 deferred/not applied/exhausted 等负向标记' % len(rec['negative']))
    else:
        checks['NO_DEFERRED_EXHAUSTED'] = ('PASS', '未见 deferred/bounded exhausted/rejected')

    # ⑤ mirrorLoop 持续：FRM 采样行数 > 阈值
    if len(rec['frm']) >= frm_min:
        checks['MIRRORLOOP_ALIVE'] = ('PASS', 'FRM 采样 %d 行 ≥ 阈值 %d' % (len(rec['frm']), frm_min))
    else:
        checks['MIRRORLOOP_ALIVE'] = ('UNOBSERVED', 'FRM 采样 %d 行 < 阈值 %d' % (len(rec['frm']), frm_min))

    # ⑥ 门回读：setprop=1 且 readback=1（缺失/不等/WARN 一律 UNOBSERVED）
    gate_ok = [g for g in rec['gate'] if g['ok']]
    if gate_ok:
        checks['GATE_READBACK'] = ('PASS', '%s' % gate_ok[0]['where'])
    elif rec['gate']:
        checks['GATE_READBACK'] = ('UNOBSERVED', 'setprop 行存在但 readback≠1 或带 WARN 未生效')
    else:
        checks['GATE_READBACK'] = ('UNOBSERVED', 'avd_driver.log 缺 state_rearm_guard setprop/readback 行')

    # ⑦ 进战斗窗（可选，不参与必需项合并）
    if rec['battle']:
        battle = ('PASS', '命中 %d 条战斗窗标记' % len(rec['battle']))
    else:
        battle = ('UNOBSERVED', '未见战斗窗标记（可选判据，不影响 A_FIXED）')
    checks['BATTLE_WINDOW'] = battle

    required = ('NO_CRASH', 'BOOT_FINGERPRINT', 'APPLIED_MILESTONE',
                'NO_DEFERRED_EXHAUSTED', 'MIRRORLOOP_ALIVE', 'GATE_READBACK')
    statuses = [checks[k][0] for k in required]
    if 'FAIL' in statuses:
        status = 'FAIL'
    elif all(s == 'PASS' for s in statuses):
        status = 'PASS'
    else:
        status = 'UNOBSERVED'

    if status == 'PASS':
        detail = '6 项必需判据全 PASS：门=1 下不崩、boot/applied/存活/回读齐备'
    elif status == 'FAIL':
        detail = '存在 FAIL 判据（仍崩或里程碑/BOOT 自相矛盾）'
    else:
        detail = '存在 UNOBSERVED 判据：证据不足，不预设成功'

    return {
        'status': status, 'checks': {k: {'status': v[0], 'detail': v[1]}
                                     for k, v in checks.items()},
        'crash_seen': bool(rec['crash']), 'crash_count': len(rec['crash']),
        'frm_samples': len(rec['frm']), 'negative_count': len(rec['negative']),
        'gate_lines': len(rec['gate']), 'battle_seen': bool(rec['battle']),
        'detail': detail,
        'crash_sample': rec['crash'][:6], 'gate_sample': rec['gate'][:4],
        'negative_sample': rec['negative'][:6], 'frm_sample': rec['frm'][:4],
    }


def causal(b, a):
    """A/B 因果裁决（按任务给定优先级逐条判定）。"""
    if (not b['applied_ok']
            or a['checks']['APPLIED_MILESTONE']['status'] not in ('PASS', 'FAIL')):
        # 任一轮未 applied：A 轮「缺 milestone=UNOBSERVED」也算前提未观测。
        return 'INVALID_ABORT'
    if a['crash_seen'] and a['status'] == 'FAIL':
        return 'GUARD_INSUFFICIENT'
    if b['status'] == 'UNOBSERVED':
        return 'ROOT_CAUSE_WRONG'
    if b['status'] == 'PASS' and a['status'] == 'PASS':
        return 'STRONG_CAUSAL'
    return 'INCONCLUSIVE'


def analyze(b_dir, a_dir, frm_min=DEFAULT_FRM_MIN):
    rb = scan_run(b_dir)
    ra = scan_run(a_dir)
    b = judge_b(rb)
    a = judge_a(ra, frm_min)
    verdict = causal(b, a)
    return {
        'B_RUN': os.path.abspath(b_dir), 'A_RUN': os.path.abspath(a_dir),
        'B_REPRODUCED': b['status'], 'A_FIXED': a['status'], 'AB_VERDICT': verdict,
        'B': b, 'A': a,
        'files_B': rb['files'], 'files_A': ra['files'],
        'scan_error_B': rb.get('scan_error'), 'scan_error_A': ra.get('scan_error'),
        'samples_B': rb['sample'][:20], 'samples_A': ra['sample'][:20],
        'frm_min': frm_min,
        'criterion': {
            'B': 'applied 有效 + 崩溃信号 => PASS；applied 有效但无崩溃 => UNOBSERVED；applied 缺失 => INVALID',
            'A': '6 项必需(NO_CRASH/BOOT/APPLIED/NO_DEFERRED/MIRRORLOOP_ALIVE/GATE_READBACK) 全 PASS => PASS；任一 FAIL => FAIL；否则 UNOBSERVED',
            'AB': '任一轮未 applied => INVALID_ABORT；A 仍崩 => GUARD_INSUFFICIENT；'
                  'B applied 有效但不崩 => ROOT_CAUSE_WRONG；B PASS 且 A PASS => STRONG_CAUSAL；否则 INCONCLUSIVE',
        },
        'notes': [
            '本脚本只判 seed applied SIGSEGV 守卫修复门，不判对手真实性；CROSSED 由 diff_party_check 另案裁决。',
            '门维持 FAIL / 对手真实性 0/9；修崩溃 == 必要非充分，不等于成功。',
            'FAIL > UNOBSERVED > PASS；字段缺失一律 UNOBSERVED；门回读失败判 UNOBS；不伪造、不预设成功。',
            '逐文件逐行扫描（含 >1MB 日志），禁目录级 grep；二进制/超限文件跳过并声明。',
            'mirrorLoop 仅在 tombstone 栈帧上下文计崩溃；正常 mirrorLoop 生命周期行不计崩溃。',
            'A/B 唯一变量 = MGBAX_STATE_REARM_GUARD 门值（B=0 / A=1），driver --env 下发；'
            'setprop readback 在 avd_driver.log 核验。',
        ],
    }


def fmt(res):
    lines = []
    lines.append('=== CRASHJUDGE A/B 崩溃修复判读 ===')
    lines.append('B_RUN=%s' % res['B_RUN'])
    lines.append('A_RUN=%s' % res['A_RUN'])
    if res['scan_error_B']:
        lines.append('WARN B: ' + res['scan_error_B'])
    if res['scan_error_A']:
        lines.append('WARN A: ' + res['scan_error_A'])
    lines.append('files_scanned B=%d A=%d  (逐文件，禁目录级 grep)' % (
        sum(1 for f in res['files_B'] if f['scanned']),
        sum(1 for f in res['files_A'] if f['scanned'])))
    b = res['B']
    lines.append('B_REPRODUCED=%s | applied=%s crash=%s | %s' % (
        res['B_REPRODUCED'], b['applied_ok'], b['crash_seen'], b['detail']))
    a = res['A']
    lines.append('A_FIXED=%s | crash=%s frm=%d neg=%d gate_lines=%d | %s' % (
        res['A_FIXED'], a['crash_seen'], a['frm_samples'], a['negative_count'],
        a['gate_lines'], a['detail']))
    lines.append('-- A 逐项判据 --')
    for k, v in a['checks'].items():
        lines.append('  %-24s=%-11s | %s' % (k, v['status'], v['detail']))
    lines.append('AB_VERDICT=%s' % res['AB_VERDICT'])
    for n in res['notes']:
        lines.append('NOTE: ' + n)
    return '\n'.join(lines)


# ---------------- 自测（合成日志只写系统临时目录，不碰仓库产物）----------------

def _b_files(crash=True, applied=True):
    lines = []
    if applied:
        lines += [
            '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2 (visibleSlot=1) hash=1a2b3c4d',
            'peer state loaded (no reset) bytes=37816 index=0 slot=2',
        ]
    if crash:
        lines += [
            'Fatal signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr 0x0'
            ' in tid 16155 (mGBA-console-1), pid 16055 (io.mgba.android)',
            '#16 pc 000000000004013c  <anonymous:7154561cd000> (io.mgba.android.GBoyConsoleSet.mirrorLoop)',
        ]
    return {
        'app_link_startup.log': '\n'.join(lines) + '\n',
        'avd_driver.log': 'setprop debug.mgbax.link.state_rearm_guard=0 readback=0\n',
        'summary.txt': 'tag=CRASHFIX-B-01\n',
    }


def _a_files(crash=False, gate_ok=True):
    lines = [
        '[ISYNC-EV][BOOT] role=APP official=1 hasCurrent=1 hasLast=0 coreReady=1 pathResolved=1',
        'I GBoyConsoleSet: mirrorLoop started index=0',   # 正常生命周期行：不得判崩溃
        'peer state loaded (no reset) bytes=37816 index=0 slot=2',
        '[ISYNC] remote state loaded 37816 bytes index=0 mirrorSlot=2 (visibleSlot=1) hash=1a2b3c4d',
        '[BATTLE] btlType=0000002E entered battle window',
    ]
    lines += ['FRM me=0 emuFps=59.73 callsFps=59.7 frames=120 wall=2009ms'] * 4
    if crash:
        lines += [
            'Fatal signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr 0x0 in tid 1, pid 2',
            '#16 pc 000000000004013c  (io.mgba.android.GBoyConsoleSet.mirrorLoop)',
        ]
    gate = ('setprop debug.mgbax.link.state_rearm_guard=1 readback=1'
            if gate_ok else 'setprop debug.mgbax.link.state_rearm_guard=1 readback=0  <-- WARN: 未生效')
    return {
        'app_link_startup.log': '\n'.join(lines) + '\n',
        'avd_driver.log': gate + '\n',
        'summary.txt': 'tag=CRASHFIX-A-01\n',
    }


def _make_run(files):
    d = tempfile.mkdtemp(prefix='crash_ab_selftest_')
    for name, text in files.items():
        with open(os.path.join(d, name), 'w', encoding='utf-8') as fh:
            fh.write(text)
    return d


def _selftest():
    passed, total = 0, 0

    def check(name, cond):
        nonlocal passed, total
        total += 1
        if cond:
            passed += 1
            print('SELFTEST PASS: ' + name)
        else:
            print('SELFTEST FAIL: ' + name)

    dirs = []
    try:
        # (1) B 崩溃 + A 不崩 → STRONG_CAUSAL
        db = _make_run(_b_files(crash=True, applied=True))
        da = _make_run(_a_files(crash=False, gate_ok=True))
        dirs += [db, da]
        r = analyze(db, da)
        check('(1) B崩溃+A正常 => STRONG_CAUSAL', r['AB_VERDICT'] == 'STRONG_CAUSAL')
        check('(1) B_REPRODUCED=PASS', r['B_REPRODUCED'] == 'PASS')
        check('(1) A_FIXED=PASS', r['A_FIXED'] == 'PASS')
        check('(1) 正常mirrorLoop生命周期行不判崩溃', r['A']['crash_seen'] is False)
        print(fmt(r))

        # (2) B 不崩（applied 有效）+ A 正常 → ROOT_CAUSE_WRONG
        db2 = _make_run(_b_files(crash=False, applied=True))
        da2 = _make_run(_a_files(crash=False, gate_ok=True))
        dirs += [db2, da2]
        r2 = analyze(db2, da2)
        check('(2) B不崩且applied有效 => ROOT_CAUSE_WRONG', r2['AB_VERDICT'] == 'ROOT_CAUSE_WRONG')
        check('(2) B_REPRODUCED=UNOBSERVED', r2['B_REPRODUCED'] == 'UNOBSERVED')

        # (3) A 仍崩（applied 有效）→ GUARD_INSUFFICIENT
        db3 = _make_run(_b_files(crash=True, applied=True))
        da3 = _make_run(_a_files(crash=True, gate_ok=True))
        dirs += [db3, da3]
        r3 = analyze(db3, da3)
        check('(3) A仍崩 => GUARD_INSUFFICIENT', r3['AB_VERDICT'] == 'GUARD_INSUFFICIENT')
        check('(3) A_FIXED=FAIL', r3['A_FIXED'] == 'FAIL')

        # (4) B 无 applied → INVALID_ABORT
        db4 = _make_run(_b_files(crash=False, applied=False))
        da4 = _make_run(_a_files(crash=False, gate_ok=True))
        dirs += [db4, da4]
        r4 = analyze(db4, da4)
        check('(4) B未applied => INVALID_ABORT', r4['AB_VERDICT'] == 'INVALID_ABORT')
        check('(4) B_REPRODUCED=INVALID', r4['B_REPRODUCED'] == 'INVALID')

        # (5) A 门回读失败 → A_FIXED=UNOBSERVED，裁决不预设成功
        db5 = _make_run(_b_files(crash=True, applied=True))
        da5 = _make_run(_a_files(crash=False, gate_ok=False))
        dirs += [db5, da5]
        r5 = analyze(db5, da5)
        check('(5) 门回读失败 => A_FIXED=UNOBSERVED', r5['A_FIXED'] == 'UNOBSERVED')
        check('(5) 门回读失败 => GATE_READBACK=UNOBSERVED',
              r5['A']['checks']['GATE_READBACK']['status'] == 'UNOBSERVED')
        check('(5) 门回读失败 => 不判 STRONG_CAUSAL', r5['AB_VERDICT'] != 'STRONG_CAUSAL')

        # (6) driver state_sync= 注释载体假阳性：只在注释里提到 remote state loaded，
        #     不算 applied（拿真实 M1-APPLIED-02 的载体形态验证 fail-closed）。
        f6 = _b_files(crash=False, applied=False)
        f6['avd_driver.log'] = (
            '[16:13:07] [PATHB] state_sync=UNOBSERVED  # TYPE_STATE/remote state loaded'
            ' 的假阳性载体，不是 load 成功事件\n')
        db6 = _make_run(f6)
        da6 = _make_run(_a_files(crash=False, gate_ok=True))
        dirs += [db6, da6]
        r6 = analyze(db6, da6)
        check('(6) state_sync= 注释不算 applied => B_REPRODUCED=INVALID',
              r6['B_REPRODUCED'] == 'INVALID')
        check('(6) state_sync= 注释不算 applied => AB_VERDICT=INVALID_ABORT',
              r6['AB_VERDICT'] == 'INVALID_ABORT')

        # (7) CRASHJUDGE-A 假阳性回归：driver 观测载体行（applied=loaded /
        #     negative_marker=0，deferred 仅在注释）绝不计入 negative。
        carrier = ('[19:21:54] [ISYNC] applied=loaded app_load_slot=2 pc_load_slot=- '
                   'negative_marker=0  # 只读观测、非判据：deferred/负向(无真load)→UNOBSERVED\n')
        f7 = _a_files(crash=False, gate_ok=True)
        f7['avd_driver.log'] += carrier
        f7['summary.txt'] += carrier
        d7 = _make_run(f7)
        dirs.append(d7)
        a7 = judge_a(scan_run(d7), DEFAULT_FRM_MIN)
        check('(7) driver观测载体行(注释含deferred)不计入negative',
              a7['negative_count'] == 0)
        check('(7) NO_DEFERRED_EXHAUSTED=PASS',
              a7['checks']['NO_DEFERRED_EXHAUSTED']['status'] == 'PASS')

        # (8) 真负向事件必须仍计入：TYPE_STATE deferred: consoles not ready。
        f8 = _a_files(crash=False, gate_ok=True)
        f8['app_link_startup.log'] += (
            '11-20 07:36:10.146 16729 16729 W mGBA-App: TYPE_STATE deferred: '
            'consoles not ready, queued (ISYNC bounded retry)\n')
        d8 = _make_run(f8)
        dirs.append(d8)
        a8 = judge_a(scan_run(d8), DEFAULT_FRM_MIN)
        check('(8) 真 TYPE_STATE deferred 计入 negative', a8['negative_count'] >= 1)
        check('(8) 真负向 => NO_DEFERRED_EXHAUSTED=UNOBSERVED',
              a8['checks']['NO_DEFERRED_EXHAUSTED']['status'] == 'UNOBSERVED')
    finally:
        for d in dirs:
            shutil.rmtree(d, ignore_errors=True)

    print('SELFTEST_SUMMARY: %d/%d passed' % (passed, total))
    return 0 if passed == total else 1


def main(argv=None):
    ap = argparse.ArgumentParser(description='CRASHJUDGE seed applied SIGSEGV 守卫 A/B 判读（只读）')
    ap.add_argument('b_run', nargs='?', help='B 轮 CRASHFIX-B-01（门=0）run 目录')
    ap.add_argument('a_run', nargs='?', help='A 轮 CRASHFIX-A-01（门=1）run 目录')
    ap.add_argument('--json', action='store_true', help='输出 JSON')
    ap.add_argument('--frm-min', type=int, default=DEFAULT_FRM_MIN,
                    help='mirrorLoop 存活所需 FRM 采样行数阈值（默认 %d）' % DEFAULT_FRM_MIN)
    ap.add_argument('--selftest', action='store_true', help='合成日志自测（只写系统 temp）')
    args = ap.parse_args(argv)

    if args.selftest:
        return _selftest()
    if not args.b_run or not args.a_run:
        ap.error('需要 <B_run目录> <A_run目录>，或使用 --selftest')
    if not os.path.isdir(args.b_run):
        print('ERROR: B run 目录不存在: %s' % args.b_run)
        return 2
    if not os.path.isdir(args.a_run):
        print('ERROR: A run 目录不存在: %s' % args.a_run)
        return 2
    if args.frm_min < 1:
        print('ERROR: --frm-min 必须 >= 1')
        return 2

    res = analyze(args.b_run, args.a_run, args.frm_min)
    if args.json:
        print(json.dumps(res, ensure_ascii=False, indent=2))
    else:
        print(fmt(res))
    if res['AB_VERDICT'] == 'STRONG_CAUSAL':
        return 0
    if res['AB_VERDICT'] == 'INVALID_ABORT':
        return 2
    return 1


if __name__ == '__main__':
    sys.exit(main())
