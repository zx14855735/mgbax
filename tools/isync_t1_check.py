#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""ISYNC18/T1 — 输入同步确定性回放 + 深缓冲的 MVU-E2E 离线判读脚本（只读）。

本脚本 **不编译、不跑 E2E、不写产物**，只读 run 目录里的日志与 summary.txt，
逐文件、逐行扫描（目录级 grep 对 >1MB 日志会漏报，故禁用），输出判据链每一步
PASS / UNOBSERVED / FAIL 与合成 VERDICT。

==============================================================================
实现方（ROOTHUNT2 / 父会话）须产出的日志契约（具名宏 + 三端对称，缺字段即 UNOBSERVED）
==============================================================================
统一事件前缀 ``[ISYNC-T1][EVENT]``（也接受 ``[ISYNC18]`` / ``[ISYNC20]`` 同形），
每事件后面挂 ``key=value`` 对。事件与字段：

  1. GATE      role=APP|PC|iOS  MGBAX_INPUT_LOCKSTEP=<0|1>  MGBAX_INPUT_DELAY_FRAMES=<n>
               —— 三端门 readback。也接受 summary.txt 的
                  gate_INPUT_LOCKSTEP_<role> / gate_INPUT_DELAY_FRAMES_<role> 形式。
  1. TYPE18    role=<R>  frame=<F>            —— type18 帧号线帧（带帧号）
  1. TYPE19    role=<R>  seed_frame=<S>  seed_sha=<hex>   —— type19 seed 带帧号 S
  2. KEYS      role=<R>  dir=send|recv  peer=<对端>  frame=<F>  sha=<hex>
               —— 按键序列 hash。交叉对：APP.send ≡ PC.recv(peer=APP)；
                  PC.send ≡ APP.recv(peer=PC)。绝不用同进程 mirror↔visible 互比。
  3. STATE     role=<R>  core=mirror|visible  version=<V>  frame=<F>  sha=<hex>
               —— 每帧状态 hash。交叉对：APP.mirror@F ≡ PC.visible@F 且
                  PC.mirror@F ≡ APP.visible@F；先版本核对，≥5 个共同时刻帧。
  4. SEEDAPPLY role=<R>  frame=<S>  ring_cleared=<0|1>  base_frame=<B>
                         keys_cleared=<0|1>  [seed_sha=<hex>]
               —— seed 第 S 帧 applied，ring.clear/setBaseFrame(S)/清 keys。
                  B 必须 == S；seed_sha 若给出须与 TYPE19 seed_sha 一致。
  5. HS        role=<R>  st=<n>  pc_stage=<n>  —— 进程内握手：APP st>=4、PC pc_stage==2。
  6. CB2       role=<R>  pc=080B4845           —— cb2 窗严格命中 0x080B4845。
                  summary.txt 另须 BATTLE=YES / in_battle(_frame)=True / battle_samples>0。
  7. (复用现成) summary.txt: RH_OFF=1、mode_alias=pathB-zero、
                  diff_party_verdict=CROSSED 或 diff_party_exit=0、
                  opponent_app=0006 / opponent_pc=00D5；日志 [OPPSPECIES] mons= 佐证。
                  零注入：SPENC/SPDEC/RHVIS/RHREND 注入标签必须全部关闭。
  8. (复用现成) summary.txt: fps_app / fps_pc / speed / baseline_1x / baseline_2x
                  + 步骤6 的 in-battle + cb2 窗证据。

防伪纪律（不可动摇）：
  * 按键 hash 只认交叉对（send vs 对端 recv），不认同进程 mirror↔visible 自比；
  * 状态 hash 先做版本核对：版本缺失 → UNOBSERVED，版本冲突 → FAIL，绝不在
    不同版本间比 hash；匹配只认四流（APP/PC × mirror/visible）交叉对且 ≥5 帧；
  * CROSSED 必须零注入（RH_OFF=1 且无注入标签），mode_alias=pathB-zero 只声明
    「判据可用」不降门槛；注入标签与 CROSSED 同现 = 伪造 → FAIL；
  * DIVERGENCE 一旦出现，禁止「补造输入」掩盖：步骤2/3 降 UNOBSERVED 并标注；
  * 深缓冲 30 帧 @60fps = 0.5s 输入延迟是语义代价，步骤8 **不因此判 FAIL**，
    但必须在报告里诚实标注；帧率判据不放宽；
  * 字段缺失一律 UNOBSERVED（fail-closed）；FAIL > UNOBSERVED > PASS。

门纪律：本脚本判的是 T1 判据链，不是总门裁决。总门维持 FAIL / 对手真实性 0/9；
唯一裁决仍是零注入 diff_party_check 的 CROSSED（APP 框 0006 ↔ PC 框 00D5），
本脚本任何一步 PASS 都不自动升级总门。必要非充分，不预设成功。中文，不伪造。

用法：
    python tools/isync_t1_check.py <run目录> [tag] [--json]
    python tools/isync_t1_check.py --selftest
"""

import argparse
import json
import os
import re
import sys
import tempfile
from collections import defaultdict

TEXT_EXTS = ('.log', '.txt', '.out')
MAX_FILE_BYTES = 256 * 1024 * 1024
ROLES = ('APP', 'PC', 'IOS')
MAIN_ROLES = ('APP', 'PC')

# 统一事件标记：[ISYNC-T1][EV] / [ISYNC18][EV] / [ISYNC20][EV]
MK_RE = re.compile(r'\[(ISYNC-T1|ISYNC18|ISYNC20)\]\[([A-Z0-9_]+)\]')
KV_RE = re.compile(r'\b([A-Za-z][A-Za-z0-9_.]*)\s*=\s*([^\s\],]+)')
OPP_RE = re.compile(r'\[OPPSPECIES\](.*)$', re.I)
INJ_TAGS = ('SPENC', 'SPDEC', 'RHVIS', 'RHREND')

# PB8 帧率门槛（不放宽；深缓冲延迟只标注、不降门槛）
FPS_FLOOR = {1: 54.09, 2: 110.97}
SPREAD_MAX = 0.10
SCALE_LO, SCALE_HI = 1.5, 2.67
CB2_ADDR = '080b4845'


def _truthy(v):
    if v is None:
        return None
    return str(v).strip().lower() in ('1', 'yes', 'true', 'ok', 'y', 'on')


def _int(v):
    try:
        return int(str(v).strip(), 0) if str(v).strip().lower().startswith('0x') else int(str(v).strip())
    except (TypeError, ValueError):
        return None


def _norm_role(v):
    if not v:
        return 'UNK'
    s = str(v).strip().lower()
    if s in ('app', 'android'):
        return 'APP'
    if s == 'pc':
        return 'PC'
    if s == 'ios':
        return 'IOS'
    return s.upper()


def _sha_ok(v):
    return bool(v) and bool(re.fullmatch(r'[0-9a-fA-F]{8,64}', str(v)))


def _sha(v):
    return str(v).lower() if v else None


def _norm_hex(v):
    """去 0x 前缀但保留前导 0（'0006' 不能被 lstrip('0x') 削成 '6'）。"""
    x = str(v).strip().lower()
    return x[2:] if x.startswith('0x') else x


def _new_records():
    return {
        'files': [], 'sample': [], 'summary': {},
        'events': [],          # {ev, kv, role, where}
        'opp_species': [],     # {role, mons:[...], where}
        'inj_tags': [],        # 注入标签命中
        'divergence': [],      # {role, where, text}
    }


def _add_sample(rec, rel, lineno, text):
    if len(rec['sample']) < 160:
        rec['sample'].append('%s:%d: %s' % (rel, lineno, text.strip()[:240]))


def _classify_line(rel, text, rec, lineno):
    where = '%s:%d' % (rel, lineno)
    low = text.lower()

    m = MK_RE.search(text)
    if m:
        ev = m.group(2)
        kv = {k.lower(): v for k, v in KV_RE.findall(text[m.end():])}
        role = _norm_role(kv.get('role'))
        rec['events'].append({'ev': ev, 'kv': kv, 'role': role, 'where': where})
        _add_sample(rec, rel, lineno, text)
        if ev == 'DIVERGENCE':
            rec['divergence'].append({'role': role, 'where': where, 'text': text.strip()[:240]})
        return

    # OPPSPECIES：零注入 CROSSED 的数据层佐证（mons=gBattleMons[0..3].species CSV）
    mo = OPP_RE.search(text)
    if mo:
        mm = re.search(r'\bmons(?:\[[^\]]*\])?=([0-9A-Fa-f,]+)', mo.group(1))
        if mm:
            mons = [x.strip().lower() for x in mm.group(1).split(',') if x.strip()]
            # 侧别：APP 行带 n= 或 cb2=；PC 反之；文件名兜底
            role = 'APP' if re.search(r'\bn\s*=', mo.group(1)) else (
                'PC' if re.search(r'cb2\s*=', mo.group(1)) else
                ('PC' if re.search(r'(?:^|/|\\)(pc_|mgba_sio|mgba_lobby)', rel, re.I) else 'APP'))
            rec['opp_species'].append({'role': role, 'mons': mons, 'where': where})
            _add_sample(rec, rel, lineno, text)
        return

    for tag in INJ_TAGS:
        if '[' + tag + ']' in text:
            rec['inj_tags'].append({'tag': tag, 'where': where})
            _add_sample(rec, rel, lineno, text)
            break


def _parse_summary(text, rec):
    for line in text.splitlines():
        m = re.match(r'^\s*([^=#]+?)\s*=\s*(.*?)\s*$', line)
        if not m:
            continue
        key = m.group(1).strip()
        val = re.split(r'\s+#', m.group(2).strip(), 1)[0].strip()
        rec['summary'][key.lower()] = val
        # gate readback 也接受 summary 形式：gate_INPUT_LOCKSTEP_APP=1 等
        kl = key.lower()
        for role in ROLES:
            if 'input_lockstep' in kl and role.lower() in kl:
                rec['events'].append({'ev': 'GATE', 'kv': {'role': role.lower(),
                                      'mgbax_input_lockstep': val}, 'role': role,
                                      'where': 'summary.txt:' + key})
            if 'input_delay_frames' in kl and role.lower() in kl:
                rec['events'].append({'ev': 'GATE', 'kv': {'role': role.lower(),
                                      'mgbax_input_delay_frames': val}, 'role': role,
                                      'where': 'summary.txt:' + key})


def scan_run(run_dir):
    rec = _new_records()
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
                        _classify_line(rel, line.rstrip('\r\n'), rec, lineno)
            except OSError:
                pass
    return rec


def _combine(statuses):
    if any(s == 'FAIL' for s in statuses):
        return 'FAIL'
    if statuses and all(s == 'PASS' for s in statuses):
        return 'PASS'
    return 'UNOBSERVED'


def judge(rec, tag=None):
    s = rec['summary']
    res = {'tag_expected': tag, 'tag_field': s.get('tag'),
           'files': rec['files'], 'sample': rec['sample']}
    tag_field = s.get('tag')
    if tag and tag_field:
        res['TAG_CHECK'] = 'OK' if tag.strip() == tag_field.strip() else 'MISMATCH'
    elif tag_field:
        res['TAG_CHECK'] = 'NO_EXPECTED_TAG'
    else:
        res['TAG_CHECK'] = 'NO_TAG_FIELD'

    evs = rec['events']
    def pick(ev):
        return [e for e in evs if e['ev'] == ev]

    gate_ev = pick('GATE')
    t18 = pick('TYPE18')
    t19 = pick('TYPE19')
    keys = pick('KEYS')
    states = pick('STATE')
    seedap = pick('SEEDAPPLY')
    hs = pick('HS')
    cb2 = pick('CB2')

    # ---------- 步骤1：门生效 ----------
    lock = {r: set() for r in ROLES}
    delay = {r: set() for r in ROLES}
    for e in gate_ev:
        r = e['role']
        kv = e['kv']
        v = kv.get('mgbax_input_lockstep') if 'mgbax_input_lockstep' in kv else kv.get('lockstep')
        d = (kv.get('mgbax_input_delay_frames') if 'mgbax_input_delay_frames' in kv
             else kv.get('delay_frames'))
        if v is not None:
            lock.setdefault(r, set()).add(_int(v))
        if d is not None:
            delay.setdefault(r, set()).add(_int(d))
    lock_ok = all(lock.get(r) == {1} for r in ROLES)
    delay_ok = all(delay.get(r) == {30} for r in ROLES)
    t18_frames = {e['role']: set() for e in t18}
    for e in t18:
        f = _int(e['kv'].get('frame'))
        if f is not None:
            t18_frames.setdefault(e['role'], set()).add(f)
    t18_ok = bool(t18) and all(t18_frames.get(r) for r in MAIN_ROLES)
    seed_frames = set()
    seed_sha = set()
    for e in t19:
        sf = _int(e['kv'].get('seed_frame'))
        if sf is not None:
            seed_frames.add(sf)
        if _sha_ok(e['kv'].get('seed_sha')):
            seed_sha.add(_sha(e['kv'].get('seed_sha')))
    t19_ok = bool(t19) and len(seed_frames) == 1
    # 门语义：三端 readback 全 1/30 + type18 两端帧线 + type19 单一 seed 帧号
    explicit_off = any(lock.get(r) == {0} for r in ROLES)
    if lock_ok and delay_ok and t18_ok and t19_ok:
        st1, d1 = 'PASS', '三端门=1/30，type18 帧线两端出现，type19 seed 帧号 S=%s' % next(iter(seed_frames))
    elif explicit_off or any(v and any(x == 0 for x in v) for v in lock.values()):
        st1, d1 = 'FAIL', '门 readback 存在 0（MGBAX_INPUT_LOCKSTEP 未生效）'
    else:
        miss = []
        if not lock_ok:
            miss.append('lockstep readback 缺/不全为1')
        if not delay_ok:
            miss.append('delay_frames readback 缺/不全为30')
        if not t18_ok:
            miss.append('type18 帧线缺')
        if not t19_ok:
            miss.append('type19 seed 帧号缺/多值')
        st1, d1 = 'UNOBSERVED', '门证据不齐: ' + '; '.join(miss)
    res['S1_GATE_EFFECTIVE'] = {
        'status': st1, 'detail': d1,
        'lockstep': {r: sorted(x for x in lock.get(r, ()) if x is not None) for r in ROLES},
        'delay_frames': {r: sorted(x for x in delay.get(r, ()) if x is not None) for r in ROLES},
        'type18_frames': {r: sorted(t18_frames.get(r, ())) for r in MAIN_ROLES},
        'seed_frames': sorted(seed_frames), 'seed_sha': sorted(seed_sha),
    }

    # ---------- 步骤2：逐帧按键 hash 相等（交叉对，不镜像互比） ----------
    app_send, pc_send, pc_recv_app, app_recv_pc = set(), set(), set(), set()
    for e in keys:
        kv = e['kv']
        h = _sha(kv.get('sha') or kv.get('sha256') or kv.get('hash') or kv.get('seq_sha'))
        if not _sha_ok(h):
            continue
        r, direction, peer = e['role'], (kv.get('dir') or '').lower(), _norm_role(kv.get('peer'))
        if r == 'APP' and direction == 'send':
            app_send.add(h)
        elif r == 'PC' and direction == 'send':
            pc_send.add(h)
        elif r == 'PC' and direction == 'recv' and peer == 'APP':
            pc_recv_app.add(h)
        elif r == 'APP' and direction == 'recv' and peer == 'PC':
            app_recv_pc.add(h)
    pair_a = bool(app_send and pc_recv_app and app_send == pc_recv_app)
    pair_b = bool(pc_send and app_recv_pc and pc_send == app_recv_pc)
    conflict = bool(app_send and pc_recv_app and app_send != pc_recv_app) or \
               bool(pc_send and app_recv_pc and pc_send != app_recv_pc)
    if rec['divergence']:
        st2, d2 = 'UNOBSERVED', '存在 DIVERGENCE：禁止补造输入掩盖，按键 hash 链降 UNOBSERVED（fail-closed）'
    elif conflict:
        st2, d2 = 'FAIL', '交叉对按键 hash 冲突（可能输入漂移，非模拟不确定）'
    elif pair_a and pair_b:
        st2, d2 = 'PASS', 'APP.send≡PC.recv(APP) 且 PC.send≡APP.recv(PC)'
    else:
        st2, d2 = 'UNOBSERVED', '交叉对按键 hash 缺失（必须 send vs 对端 recv，禁止同进程 mirror↔visible 自比）'
    res['S2_KEY_HASH_CROSS_PAIR'] = {
        'status': st2, 'detail': d2,
        'app_send': sorted(app_send), 'pc_recv_from_app': sorted(pc_recv_app),
        'pc_send': sorted(pc_send), 'app_recv_from_pc': sorted(app_recv_pc),
        'divergence_count': len(rec['divergence']),
    }

    # ---------- 步骤3：状态 hash 交叉对相等（先版本核对，≥5 帧） ----------
    streams = {}
    for e in states:
        kv = e['kv']
        r, core = e['role'], (kv.get('core') or '').lower()
        if r not in MAIN_ROLES or core not in ('mirror', 'visible'):
            continue
        ver = kv.get('version')
        f = _int(kv.get('frame'))
        h = _sha(kv.get('sha') or kv.get('sha256') or kv.get('hash'))
        if f is None or not _sha_ok(h):
            continue
        stm = streams.setdefault((r, core), {'versions': set(), 'frames': defaultdict(set)})
        if ver is not None:
            stm['versions'].add(str(ver))
        stm['frames'][f].add(h)
    needed = [('APP', 'mirror'), ('PC', 'visible'), ('PC', 'mirror'), ('APP', 'visible')]
    vers = set()
    for k in needed:
        vers |= streams.get(k, {}).get('versions', set())
    ver_missing = any(not streams.get(k, {}).get('versions') for k in needed)
    ver_conflict = len(vers) > 1
    common_frames = set.intersection(*[set(streams.get(k, {}).get('frames', {})) for k in needed]) \
        if all(streams.get(k, {}).get('frames') for k in needed) else set()
    mismatch = []
    for f in sorted(common_frames):
        am = streams[('APP', 'mirror')]['frames'][f]
        pv = streams[('PC', 'visible')]['frames'][f]
        pm = streams[('PC', 'mirror')]['frames'][f]
        av = streams[('APP', 'visible')]['frames'][f]
        if not (am & pv) or not (pm & av):
            mismatch.append(f)
    if rec['divergence']:
        st3, d3 = 'UNOBSERVED', '存在 DIVERGENCE：状态 hash 链降 UNOBSERVED，禁止补造输入掩盖'
    elif ver_conflict:
        st3, d3 = 'FAIL', '版本核对失败：跨端 version 冲突 %s，hash 不可比' % sorted(vers)
    elif ver_missing:
        st3, d3 = 'UNOBSERVED', '版本核对缺字段：四流 version 未齐全，fail-closed'
    elif mismatch:
        st3, d3 = 'FAIL', '交叉对状态 hash 不一致帧=%s（输入相同则属模拟不确定）' % mismatch[:12]
    elif len(common_frames) >= 5:
        st3, d3 = 'PASS', '四流交叉对一致，共同时刻帧=%d（≥5）version=%s' % (len(common_frames), sorted(vers))
    else:
        st3, d3 = 'UNOBSERVED', '共同时刻帧不足 5（只有 %d），不预设成功' % len(common_frames)
    res['S3_STATE_HASH_CROSS_PAIR'] = {
        'status': st3, 'detail': d3, 'versions': sorted(vers),
        'common_frames': sorted(common_frames), 'mismatch_frames': mismatch[:20],
        'version_conflict': ver_conflict, 'version_missing': ver_missing,
    }

    # ---------- 步骤4：seed 起点对齐（seed@S → 从 S 重放，ring.clear/baseFrame/清 keys） ----------
    S = next(iter(seed_frames)) if len(seed_frames) == 1 else None
    seed_rows = {}
    for e in seedap:
        r = e['role']
        if r in MAIN_ROLES:
            seed_rows.setdefault(r, []).append(e)
    bad4, miss4 = [], []
    for r in MAIN_ROLES:
        rows = seed_rows.get(r, [])
        if not rows:
            miss4.append(r + ' 缺 SEEDAPPLY')
            continue
        for e in rows:
            kv = e['kv']
            f, base = _int(kv.get('frame')), _int(kv.get('base_frame'))
            rc, kc = _truthy(kv.get('ring_cleared')), _truthy(kv.get('keys_cleared'))
            ssh = _sha(kv.get('seed_sha'))
            if f is not None and S is not None and f != S:
                bad4.append('%s seed_applied_frame=%s != S=%s' % (r, f, S))
            if base is not None and S is not None and base != S:
                bad4.append('%s base_frame=%s != S=%s' % (r, base, S))
            if rc is False:
                bad4.append('%s ring_cleared=0' % r)
            if kc is False:
                bad4.append('%s keys_cleared=0' % r)
            if ssh and seed_sha and ssh not in seed_sha:
                bad4.append('%s seed_sha 与 TYPE19 不一致' % r)
            if base is None or rc is None or kc is None:
                miss4.append('%s 缺 base_frame/ring_cleared/keys_cleared' % r)
    if bad4:
        st4, d4 = 'FAIL', 'seed 起点未对齐: ' + '; '.join(bad4[:8])
    elif miss4:
        st4, d4 = 'UNOBSERVED', '缺字段: ' + '; '.join(miss4)
    elif S is not None and all(seed_rows.get(r) for r in MAIN_ROLES):
        st4, d4 = 'PASS', '双端 seed@S 对齐：ring.clear + setBaseFrame(S) + 清 keys'
    else:
        st4, d4 = 'UNOBSERVED', '缺 TYPE19 seed 帧号 S 或 SEEDAPPLY 记录'
    res['S4_SEED_START_ALIGN'] = {'status': st4, 'detail': d4, 'S': S,
                                  'bad': bad4[:12], 'missing': miss4[:12]}

    # ---------- 步骤5：进程内握手（PC 已 pc2，看 T1 后 APP 是否推进到 st4） ----------
    # T1 专属下游效果：门未 PASS 时不可判，降 UNOBSERVED。
    app_st = [_int(e['kv'].get('st')) for e in hs if e['role'] == 'APP']
    app_st = [x for x in app_st if x is not None]
    pc_stage = [_int(e['kv'].get('pc_stage') or e['kv'].get('pcstage') or e['kv'].get('pc'))
                for e in hs if e['role'] == 'PC']
    pc_stage = [x for x in pc_stage if x is not None]
    if st1 != 'PASS':
        st5, d5 = 'UNOBSERVED', 'T1 门未生效，进程内握手推进不可判'
    elif app_st and any(x >= 4 for x in app_st) and pc_stage and 2 in pc_stage:
        st5, d5 = 'PASS', 'PC pc_stage=2 已达成；T1 后 APP st=%s（>=4）' % max(app_st)
    elif app_st and all(x < 4 for x in app_st):
        st5, d5 = 'FAIL', 'T1 后 APP 仍卡 st=%s（未推进到 4）' % app_st
    else:
        st5, d5 = 'UNOBSERVED', 'HS 埋点缺失（APP st / PC pc_stage）'
    res['S5_INPROC_HANDSHAKE'] = {'status': st5, 'detail': d5,
                                  'app_st': app_st, 'pc_stage': pc_stage}

    # ---------- 步骤6：进战斗（cb2 窗 080B4845 + BATTLE=YES + in_battle） ----------
    cb2_hit = any(CB2_ADDR in str(e['kv'].get('pc') or e['kv'].get('addr')
                                  or e['kv'].get('at') or '').lower() for e in cb2)
    battle = str(s.get('battle', '')).strip().upper()
    in_battle_v = _truthy(s.get('in_battle_frame', s.get('in_battle')))
    samples = _int(s.get('battle_samples'))
    # summary 的 battle_window 也接受（严格窗）
    bw_hit = CB2_ADDR in str(s.get('battle_window', '')).lower()
    if st1 != 'PASS':
        st6, d6 = 'UNOBSERVED', 'T1 门未生效，不再以 summary 的 BATTLE 字段判 T1 战斗门'
    elif battle == 'NO':
        st6, d6 = 'FAIL', 'summary BATTLE=NO（未进战斗）'
    elif battle == 'YES' and in_battle_v is True and (samples is None or samples > 0) \
            and (cb2_hit or bw_hit):
        st6, d6 = 'PASS', 'BATTLE=YES + in_battle + cb2 窗 080B4845 命中'
    else:
        miss6 = []
        if battle != 'YES':
            miss6.append('BATTLE!=YES(%s)' % battle)
        if in_battle_v is not True:
            miss6.append('in_battle 非 True')
        if samples is not None and samples <= 0:
            miss6.append('battle_samples<=0')
        if not (cb2_hit or bw_hit):
            miss6.append('cb2 窗未命中 080B4845')
        st6, d6 = 'UNOBSERVED', '战斗证据不齐: ' + '; '.join(miss6)
    res['S6_ENTER_BATTLE'] = {'status': st6, 'detail': d6,
                              'BATTLE': battle or None, 'in_battle': in_battle_v,
                              'battle_samples': samples, 'cb2_hit': bool(cb2_hit or bw_hit)}

    # ---------- 步骤7：B1b 零注入 CROSSED（唯一裁决来源，独立评估） ----------
    rh_off = _truthy(s.get('rh_off', s.get('mgbax_rh_off')))
    alias = str(s.get('mode_alias', '')).strip().lower()
    dverdict = str(s.get('diff_party_verdict', s.get('party_verdict', s.get('crossed', '')))).strip().upper()
    dexit = _int(s.get('diff_party_exit'))
    opp_app = _norm_hex(s.get('opponent_app', s.get('cross_marker_app', '')))
    opp_pc = _norm_hex(s.get('opponent_pc', s.get('cross_marker_pc', '')))
    crossed_claim = dverdict == 'CROSSED' or dexit == 0
    self_echo = dverdict in ('SELF_ECHO', 'FAIL')
    inj = rec['inj_tags']
    # OPPSPECIES 佐证（slot1=对端标记、slot0 未污染）
    opp_ok = True
    opp_detail = []
    for r, expected in (('APP', '0006'), ('PC', '00d5')):
        rows = [x for x in rec['opp_species'] if x['role'] == r]
        if rows:
            hit = any(len(x['mons']) >= 2 and x['mons'][1] == expected
                      and x['mons'][0] != expected for x in rows)
            if not hit:
                opp_ok = False
                opp_detail.append('%s OPPSPECIES slot1!=%s/slot0污染' % (r, expected))
    if inj and crossed_claim:
        st7, d7 = 'FAIL', '注入标签 %s 与 CROSSED 同现 = 伪造，非纯零注入' % sorted(set(x['tag'] for x in inj))
    elif self_echo:
        st7, d7 = 'FAIL', 'diff_party 判 SELF_ECHO/FAIL（自我回显，非 CROSSED）'
    elif rh_off is False:
        st7, d7 = 'FAIL', 'RH_OFF=0（非零注入），CROSSED 不成立'
    elif rh_off is None or alias != 'pathb-zero' or not crossed_claim \
            or opp_app != '0006' or opp_pc != '00d5' or not opp_ok:
        miss7 = []
        if rh_off is None:
            miss7.append('RH_OFF 缺失')
        if alias != 'pathb-zero':
            miss7.append('mode_alias!=pathB-zero')
        if not crossed_claim:
            miss7.append('diff_party verdict/exit 缺失')
        if opp_app != '0006':
            miss7.append('APP 对手框!=0006')
        if opp_pc != '00d5':
            miss7.append('PC 对手框!=00D5')
        miss7 += opp_detail
        st7, d7 = 'UNOBSERVED', '零注入 CROSSED 证据不齐: ' + '; '.join(miss7)
    else:
        st7, d7 = 'PASS', '零注入双交叉 APP=0006/PC=00D5，mode_alias=pathB-zero，diff_party CROSSED/exit0'
    res['S7_ZERO_INJECT_CROSSED'] = {'status': st7, 'detail': d7,
                                     'rh_off': rh_off, 'mode_alias': alias or None,
                                     'diff_verdict': dverdict or None, 'diff_exit': dexit,
                                     'opponent_app': opp_app or None, 'opponent_pc': opp_pc or None,
                                     'injection_tags': sorted(set(x['tag'] for x in inj)),
                                     'opp_species_ok': opp_ok}

    # ---------- 步骤8：帧率 parity（PB8 四门槛，仅 in-battle+cb2 窗；深缓冲延迟不判 FAIL） ----------
    if st6 != 'PASS':
        st8, d8 = 'UNOBSERVED', '非 in-battle+cb2 窗，帧率 parity 不判（大堂/menu 60fps 不算）'
    else:
        fp, fc = _float(s.get('fps_app')), _float(s.get('fps_pc'))
        speed = _int(s.get('speed', s.get('speed_requested', s.get('speed_multiplier'))))
        b1, b2 = _float(s.get('baseline_1x')), _float(s.get('baseline_2x'))
        f8 = []
        if fp is None or fc is None:
            f8.append('缺 fps_app/fps_pc')
        if speed not in FPS_FLOOR:
            f8.append('speed 缺/非 1x|2x')
        else:
            floor = FPS_FLOOR[speed]
            for who, val in (('APP', fp), ('PC', fc)):
                if val is not None and val < floor:
                    f8.append('%s fps=%.2f < %s 门槛 %.2f' % (who, val, speed, floor))
        spread = None
        if fp is not None and fc is not None and min(fp, fc) > 0:
            spread = max(fp, fc) / min(fp, fc) - 1.0
            if spread > SPREAD_MAX + 1e-9:
                f8.append('双端 fps spread=%.1f%% > 10%%' % (spread * 100))
        scale = (b2 / b1) if (b1 and b2) else None
        if b1 is not None and b2 is not None and (scale is None or not (SCALE_LO <= scale <= SCALE_HI)):
            f8.append('scale=%.2f 不在 [1.5,2.67]' % (scale if scale else 0))
        if f8:
            st8, d8 = 'FAIL', '帧率门槛未过: ' + '; '.join(f8)
        elif fp is not None and fc is not None and speed in FPS_FLOOR and b1 is not None and b2 is not None:
            st8, d8 = 'PASS', 'in-battle cb2 窗：1x/2x 门槛达标 + spread=%.1f%% + scale=%.2f' % (
                spread * 100, scale)
        else:
            st8, d8 = 'UNOBSERVED', '帧率字段不齐（baseline/fps/speed 缺）'
    # 深缓冲语义代价：只标注，绝不因此判帧率 FAIL
    semantic_cost = (st1 == 'PASS' and any(_int(e['kv'].get('mgbax_input_delay_frames',
                          e['kv'].get('delay_frames'))) == 30 for e in gate_ev))
    res['S8_FPS_PARITY'] = {
        'status': st8, 'detail': d8,
        'fps_app': _float(s.get('fps_app')), 'fps_pc': _float(s.get('fps_pc')),
        'speed': _int(s.get('speed', s.get('speed_requested'))),
        'baseline_1x': _float(s.get('baseline_1x')), 'baseline_2x': _float(s.get('baseline_2x')),
        'floors': FPS_FLOOR, 'spread_max': SPREAD_MAX, 'scale_range': [SCALE_LO, SCALE_HI],
        'deep_buffer_semantic_cost': bool(semantic_cost),
        'semantic_note': ('30 帧深缓冲 @60fps ≈ 0.5s 输入延迟是确定性回放的语义代价；'
                          '不判帧率 FAIL，也不放宽任何帧率门槛' if semantic_cost else ''),
    }

    steps = ('S1_GATE_EFFECTIVE', 'S2_KEY_HASH_CROSS_PAIR', 'S3_STATE_HASH_CROSS_PAIR',
             'S4_SEED_START_ALIGN', 'S5_INPROC_HANDSHAKE', 'S6_ENTER_BATTLE',
             'S7_ZERO_INJECT_CROSSED', 'S8_FPS_PARITY')
    res['VERDICT'] = _combine([res[k]['status'] for k in steps])
    res['TOTAL_GATE'] = 'FAIL（本脚本不改总门；门 FAIL / 对手真实性 0/9）'
    res['STEPS'] = steps
    res['notes'] = [
        '判据链 PASS ≠ 总门升级；唯一裁决仍是零注入 diff_party_check CROSSED（APP 0006 ↔ PC 00D5），必要非充分。',
        '按键 hash 只认交叉对（send vs 对端 recv），状态 hash 先版本核对且 ≥5 帧四流交叉对。',
        'CROSSED 必须零注入（RH_OFF=1 且无注入标签）；注入标签与 CROSSED 同现即 FAIL。',
        'DIVERGENCE 出现时禁止补造输入掩盖，相关步骤降 UNOBSERVED。',
        '深缓冲 0.5s 输入延迟是语义代价：不判帧率 FAIL、不放宽门槛，诚实标注。',
        '逐文件逐行读取（禁目录级 grep，>1MB 日志不漏报）；字段缺失一律 UNOBSERVED；FAIL>UNOBSERVED>PASS。',
    ]
    return res


def _float(v):
    try:
        return float(str(v).strip())
    except (TypeError, ValueError):
        return None


def _fmt(res):
    lines = ['=== ISYNC18/T1 输入同步确定性回放 判据链 ===']
    lines.append('tag_expected=%s tag_field=%s TAG_CHECK=%s' %
                 (res['tag_expected'], res['tag_field'], res['TAG_CHECK']))
    files = res['files']
    lines.append('files_scanned=%d total_bytes=%d over_limit=%d  # 逐文件读取，禁目录级 grep' % (
        sum(1 for f in files if f['scanned']), sum(f['bytes'] for f in files if f['scanned']),
        sum(1 for f in files if f['over_limit'])))
    for k in res['STEPS']:
        v = res[k]
        lines.append('%s=%s | %s' % (k, v['status'], v['detail']))
        if k == 'S8_FPS_PARITY' and v.get('deep_buffer_semantic_cost'):
            lines.append('  SEMANTIC_COST: ' + v['semantic_note'])
    lines.append('VERDICT=%s' % res['VERDICT'])
    lines.append('TOTAL_GATE=%s' % res['TOTAL_GATE'])
    for n in res['notes']:
        lines.append('NOTE: ' + n)
    if res['sample']:
        lines.append('-- 命中样本（前 12 条，供人工复核）--')
        lines.extend('  ' + x for x in res['sample'][:12])
    return '\n'.join(lines)


# ---------------- 自测（合成日志只写系统临时目录，不碰仓库产物/在途源码）----------------
def _good_files():
    APP_SHA, PC_SHA = 'a' * 64, 'b' * 64
    def kv(d):
        return ' '.join('%s=%s' % (k, v) for k, v in d.items())
    applines = [
        '[ISYNC-T1][GATE] ' + kv({'role': 'APP', 'MGBAX_INPUT_LOCKSTEP': 1, 'MGBAX_INPUT_DELAY_FRAMES': 30}),
        '[ISYNC-T1][TYPE18] ' + kv({'role': 'APP', 'frame': 100}),
        '[ISYNC-T1][TYPE19] ' + kv({'role': 'APP', 'seed_frame': 120, 'seed_sha': 'c' * 64}),
        '[ISYNC-T1][KEYS] ' + kv({'role': 'APP', 'dir': 'send', 'peer': 'PC', 'frame': 120, 'sha': APP_SHA}),
        '[ISYNC-T1][KEYS] ' + kv({'role': 'APP', 'dir': 'recv', 'peer': 'PC', 'frame': 120, 'sha': PC_SHA}),
        '[ISYNC-T1][SEEDAPPLY] ' + kv({'role': 'APP', 'frame': 120, 'ring_cleared': 1, 'base_frame': 120, 'keys_cleared': 1, 'seed_sha': 'c' * 64}),
        '[ISYNC-T1][HS] ' + kv({'role': 'APP', 'st': 4, 'pc_stage': 2}),
        '[ISYNC-T1][CB2] ' + kv({'role': 'APP', 'pc': '080B4845'}),
        # APP 对手框应显示 PC 标记 0006（slot1），本端槽 slot0=00D5 未污染
        '[OPPSPECIES] n=4 mons=00D5,0006,0006,0006',
    ]
    # 5 个共同时刻帧，四流交叉对一致：
    #   APP.mirror@F == PC.visible@F == h1；APP.visible@F == PC.mirror@F == h2
    for f in range(121, 126):
        h1, h2 = ('%064x' % (0x1000 + f)), ('%064x' % (0x2000 + f))
        applines.append('[ISYNC-T1][STATE] ' + kv({'role': 'APP', 'core': 'mirror', 'version': 'v1', 'frame': f, 'sha': h1}))
        applines.append('[ISYNC-T1][STATE] ' + kv({'role': 'APP', 'core': 'visible', 'version': 'v1', 'frame': f, 'sha': h2}))
    pclines = [
        '[ISYNC-T1][GATE] ' + kv({'role': 'PC', 'MGBAX_INPUT_LOCKSTEP': 1, 'MGBAX_INPUT_DELAY_FRAMES': 30}),
        '[ISYNC-T1][GATE] ' + kv({'role': 'iOS', 'MGBAX_INPUT_LOCKSTEP': 1, 'MGBAX_INPUT_DELAY_FRAMES': 30}),
        '[ISYNC-T1][TYPE18] ' + kv({'role': 'PC', 'frame': 100}),
        '[ISYNC-T1][TYPE19] ' + kv({'role': 'PC', 'seed_frame': 120, 'seed_sha': 'c' * 64}),
        '[ISYNC-T1][KEYS] ' + kv({'role': 'PC', 'dir': 'send', 'peer': 'APP', 'frame': 120, 'sha': PC_SHA}),
        '[ISYNC-T1][KEYS] ' + kv({'role': 'PC', 'dir': 'recv', 'peer': 'APP', 'frame': 120, 'sha': APP_SHA}),
        '[ISYNC-T1][CB2] ' + kv({'role': 'PC', 'pc': '080B4845'}),
        # PC 对手框应显示 APP 标记 00D5（slot1），本端槽 slot0=0006 未污染
        '[OPPSPECIES] mons=0006,00D5,00D5,00D5',
    ]
    for f in range(121, 126):
        h1, h2 = ('%064x' % (0x1000 + f)), ('%064x' % (0x2000 + f))
        pclines.append('[ISYNC-T1][STATE] ' + kv({'role': 'PC', 'core': 'visible', 'version': 'v1', 'frame': f, 'sha': h1}))
        pclines.append('[ISYNC-T1][STATE] ' + kv({'role': 'PC', 'core': 'mirror', 'version': 'v1', 'frame': f, 'sha': h2}))
    pclines.append('[ISYNC-T1][HS] ' + kv({'role': 'PC', 'st': 4, 'pc_stage': 2}))
    pclines.append('[ISYNC-T1][SEEDAPPLY] ' + kv({'role': 'PC', 'frame': 120, 'ring_cleared': 1, 'base_frame': 120, 'keys_cleared': 1, 'seed_sha': 'c' * 64}))
    summary = '\n'.join([
        'tag=ISYNC18-SELFTEST',
        'BATTLE=YES', 'in_battle_frame=True', 'battle_samples=30',
        'RH_OFF=1', 'mode_alias=pathB-zero', 'diff_party_verdict=CROSSED', 'diff_party_exit=0',
        'opponent_app=0006', 'opponent_pc=00D5',
        'fps_app=60.2', 'fps_pc=60.0', 'speed=1', 'baseline_1x=59.8', 'baseline_2x=119.6',
    ]) + '\n'
    return {'app_logcat.log': '\n'.join(applines) + '\n',
            'pc_stdout.log': '\n'.join(pclines) + '\n',
            'summary.txt': summary}


def _make_run(files, prefix='isync18_selftest_'):
    d = tempfile.mkdtemp(prefix=prefix)
    for name, text in files.items():
        with open(os.path.join(d, name), 'w', encoding='utf-8') as fh:
            fh.write(text)
    return d


def _selftest():
    try:
        sys.stdout.reconfigure(encoding='utf-8')
    except Exception:
        pass
    passed, total = 0, 0
    def check(name, cond):
        nonlocal passed, total
        total += 1
        if cond:
            passed += 1
            print('SELFTEST PASS: ' + name)
        else:
            print('SELFTEST FAIL: ' + name)

    # (1) 合成好例：8 步全 PASS，总 VERDICT PASS
    good = _make_run(_good_files())
    r = judge(scan_run(good), 'ISYNC18-SELFTEST')
    for k in r['STEPS']:
        check('好例 %s=PASS' % k, r[k]['status'] == 'PASS')
    check('好例 VERDICT=PASS', r['VERDICT'] == 'PASS')
    check('好例 TAG_CHECK=OK', r['TAG_CHECK'] == 'OK')

    # (2) 深缓冲语义代价标注（不判帧率 FAIL）
    check('好例深缓冲语义代价标注', r['S8_FPS_PARITY']['deep_buffer_semantic_cost'] is True)

    # (3) 版本冲突 → S3 FAIL（先版本核对）
    badver = _good_files()
    lines = badver['pc_stdout.log'].splitlines()
    for i, ln in enumerate(lines):
        if '[ISYNC-T1][STATE]' in ln and 'core=visible' in ln:
            lines[i] = ln.replace('version=v1', 'version=v2')
    badver['pc_stdout.log'] = '\n'.join(lines) + '\n'
    rb = judge(scan_run(_make_run(badver)), 'ISYNC18-SELFTEST')
    check('版本冲突 S3=FAIL', rb['S3_STATE_HASH_CROSS_PAIR']['status'] == 'FAIL')

    # (4) 同进程 mirror↔visible 自比不得冒充交叉对 → S2 UNOBSERVED
    selfcmp = _good_files()
    lines = selfcmp['pc_stdout.log'].splitlines()
    lines = [ln for ln in lines if '[ISYNC-T1][KEYS]' not in ln]
    selfcmp['pc_stdout.log'] = '\n'.join(lines) + '\n'
    rs = judge(scan_run(_make_run(selfcmp)), 'ISYNC18-SELFTEST')
    check('缺交叉对按键 hash S2=UNOBSERVED', rs['S2_KEY_HASH_CROSS_PAIR']['status'] == 'UNOBSERVED')

    # (5) 注入标签 + CROSSED → S7 FAIL（伪造）
    inj = _good_files()
    inj['pc_stdout.log'] = '[SPENC] species=0006\n' + inj['pc_stdout.log']
    ri = judge(scan_run(_make_run(inj)), 'ISYNC18-SELFTEST')
    check('注入+CROSSED S7=FAIL', ri['S7_ZERO_INJECT_CROSSED']['status'] == 'FAIL')

    # (6) DIVERGENCE → S2/S3 降 UNOBSERVED，禁止补造掩盖
    div = _good_files()
    div['app_logcat.log'] = '[ISYNC-T1][DIVERGENCE] role=APP frame=123 detail=rollback\n' + div['app_logcat.log']
    rd = judge(scan_run(_make_run(div)), 'ISYNC18-SELFTEST')
    check('DIVERGENCE S2=UNOBSERVED', rd['S2_KEY_HASH_CROSS_PAIR']['status'] == 'UNOBSERVED')
    check('DIVERGENCE S3=UNOBSERVED', rd['S3_STATE_HASH_CROSS_PAIR']['status'] == 'UNOBSERVED')

    # (7) 同版本但状态 hash 不匹配 → S3 FAIL（交叉对分歧，输入相同则模拟不确定）
    hm = _good_files()
    lines = hm['pc_stdout.log'].splitlines()
    for i, ln in enumerate(lines):
        if '[ISYNC-T1][STATE]' in ln and 'core=visible' in ln and 'frame=123' in ln:
            lines[i] = ln.replace('sha=' + ('%064x' % (0x1000 + 123)), 'sha=' + 'f' * 64)
    hm['pc_stdout.log'] = '\n'.join(lines) + '\n'
    rh = judge(scan_run(_make_run(hm)), 'ISYNC18-SELFTEST')
    check('状态 hash 分歧 S3=FAIL', rh['S3_STATE_HASH_CROSS_PAIR']['status'] == 'FAIL')

    # (8) 门显式 0 → S1 FAIL
    off = _good_files()
    off['app_logcat.log'] = off['app_logcat.log'].replace('MGBAX_INPUT_LOCKSTEP=1',
                                                          'MGBAX_INPUT_LOCKSTEP=0', 1)
    r_off = judge(scan_run(_make_run(off)), 'ISYNC18-SELFTEST')
    check('门显式0 S1=FAIL', r_off['S1_GATE_EFFECTIVE']['status'] == 'FAIL')

    # (9) 2x 帧率低于门槛 → S8 FAIL；spread>10% → S8 FAIL
    fpsbad = _good_files()
    fpsbad['summary.txt'] = fpsbad['summary.txt'].replace('speed=1', 'speed=2') \
        .replace('fps_app=60.2', 'fps_app=100.0').replace('fps_pc=60.0', 'fps_pc=112.0')
    rf = judge(scan_run(_make_run(fpsbad)), 'ISYNC18-SELFTEST')
    check('2x 帧率低于门槛 S8=FAIL', rf['S8_FPS_PARITY']['status'] == 'FAIL')

    # (10) tag 不一致 → TAG_CHECK=MISMATCH（不伪造拿错 artifact）
    rtag = judge(scan_run(_make_run(_good_files())), 'OTHER-TAG')
    check('tag 不一致 TAG_CHECK=MISMATCH', rtag['TAG_CHECK'] == 'MISMATCH')

    # (11) M1 基线（无 T1 门）：应全 UNOBSERVED（只读，不修改基线）
    root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    baseline = os.path.join(root, '.zcode-tmp', 'cloud2p', 'M1-APPLIED-01')
    if os.path.isdir(baseline):
        r0 = judge(scan_run(baseline), 'M1-APPLIED-01')
        bad = [k for k in r0['STEPS'] if r0[k]['status'] != 'UNOBSERVED']
        check('M1 基线全 UNOBSERVED', not bad)
        if bad:
            print('  unexpected: ' + ', '.join('%s=%s' % (k, r0[k]['status']) for k in bad))
    else:
        print('SELFTEST SKIP: M1 基线不存在（%s）' % baseline)

    print('\nSELFTEST %d/%d PASS' % (passed, total))
    return 0 if passed == total else 1


def main(argv=None):
    p = argparse.ArgumentParser(description='ISYNC18/T1 判据链离线判读（只读，不编译/不跑 E2E）')
    p.add_argument('run_dir', nargs='?', help='run 目录')
    p.add_argument('tag', nargs='?', help='期望 tag（可选，做一致性校验）')
    p.add_argument('--json', action='store_true', help='输出完整 JSON')
    p.add_argument('--selftest', action='store_true', help='合成日志自测，不碰仓库产物')
    args = p.parse_args(argv)
    if args.selftest:
        return _selftest()
    if not args.run_dir:
        p.error('需要 <run目录>，或使用 --selftest')
    res = judge(scan_run(args.run_dir), args.tag)
    if args.json:
        print(json.dumps(res, ensure_ascii=False, indent=2, default=str))
    else:
        print(_fmt(res))
    return 0 if res['VERDICT'] == 'PASS' else (1 if res['VERDICT'] == 'FAIL' else 3)


if __name__ == '__main__':
    sys.exit(main())
