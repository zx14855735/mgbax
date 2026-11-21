#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""RACEREAD — 竞态根治门 + 竞态修复证据的机械判读（只读，不编译、不跑 E2E、不写产物）。

用法：
    python tools/race_gate_check.py <run目录> <tag> [--json]
    python tools/race_gate_check.py <run目录> <tag> [--config cfg.json]
        [--gate-pattern REGEX] [--expect KEY=VAL]... [--role fix|control]
        [--expect-crash no|yes] [--frm-min N] [--root-gate 0|1]
    python tools/race_gate_check.py --selftest

判据（压测每轮必判，fail-closed：字段缺失 UNOBSERVED，绝不 PASS）：
  1. ROOT_GATE_ACTIVE  根治门真生效。一级证据 = Android logcat
     `[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 (enqueue + owner-thread ...
      frame-boundary load + gen token)`（RACEGATE §验收点：接收器 on=true 才打）。
     **driver 的 `setprop debug.mgbax.link.isync_seed_frame_boundary=1 readback=1`
     只证属性写入，不证 Java 门开**；仅见弱证据一律 UNOBSERVED，下游 applied
     判读随之降级（门没开的数据无效）。
  2. NO_CRASH          无 Fatal signal 11 / SIGSEGV / mCoreLoadStateNamed 崩溃铁证，且排除他进程 has died 误报。
     control 轮用 --expect-crash yes 改判「崩溃/双灌必须复现」（不复现=造窗无效）。
  3. APPLIED_UNIQUE    按 (seed 字节数, sha256) 配对（W69 口径修正）。
     gen=接收端 ConsoleSet 实例代次（rebuild/retarget 跳号，如 1→4），
     applied_count=接收端全局 AtomicInteger（只认真 load 时 +1），二者**非 1:1**：
     同 gen 停滞期内多个重发包先后到达、各 load 一次（ac 递增）属合法串行重灌。
     CRASH5 双 apply 铁证收敛为：①同 (bytes,hash,gen) 跨 tid 并发；②同 gen 多条
     load 含主线程 tid；③同 gen 多条 load 与崩溃铁证同现。合法串行重灌
     （同 tid + ac 严格递增）判 PASS；applied_count>1 不单独判 FAIL；
     STATE_QUEUED / state_sync= 注释载体一律不算 applied。
     **跨文件去重**：同一真实 applied 常被 app_link_startup.log 与 app_logcat_full.log
     各记一条（后者是前者超集）；分组前按(毫秒时间戳,bytes,hash,gen)折叠同一事件，
     同键多条只算一次。真双灌（同 gen 跨 tid）时间戳/tid 不同，不会被折叠。
  4. STALE_SEMANTICS   SEED_DROPPED_STALE 存在且只丢真正 stale（gen != current），
     不误丢已 applied 的 gen；SEED_APPLY_OVERLAP 必须 0 命中。
  5. MIRRORLOOP_ALIVE  FRM 采样持续；若已崩则崩后须仍有 FRM（无空 tap）。
  6. BATTLE_WINDOW     cb2=080B4845 / BATTLE=YES（**仅观察，不参与总判据**）。
  7. GATE_DIRECTIONS   NO_LAG_CLEAR(0 灰区/1 关)、STATE_REARM_GUARD(恒 1)、
     SEED_CLEAN_RESEND(1/0)、RACE_STRESS(压测 1)；缺值 UNOBSERVED、漂移 FAIL。
  8. MAIN_THREAD_LOAD_ZERO  主线程零 load（竞态根治的线程归属判据，RACETID §3.2）。
     从 logcat threadtime 的 `[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1` 回读行
     （pid==tid，如 11232 11232）或 BroadcastReceiver/onReceive 行锚定主线程 tid；
     所有 load 里程碑（TYPE_STATE remote state loaded / peer state loaded）的 tid
     ==main_tid => FAIL（load 仍在主线程=竞态未根治）；tid 全≠main_tid 且可解析 =>
     PASS（主线程零 load，宽窗可省）；tid 全 None（不可观测）/主线程 tid 不可锚定/
     无 load 里程碑 => UNOBSERVED（退回宽窗压测，报告要求）。
  另：TAG_MATCH 核对 summary.txt 的 tag；门方向含 NO_LAG_CLEAR=0 / RACE_STRESS=1
  时输出强制灰区/压测标注。

防伪：逐文件逐行扫（>1MB 也逐行，禁目录级 grep）；二进制/超限文件跳过并声明；
fmt/hash/sha/gen/applied_count 字段缺失即 UNOBSERVED；崩溃证据串配 CRASH5 实测值；
双 apply 按 (bytes,sha/hash) 配对，不同包不误判。
崩溃证据须按进程归属过滤（NOCRASH2）：'has died' 泛匹配会命中 Google QuickSearchBox
等系统缓存回收，必须明确是 io.mgba.android 或 pid 命中 app 门回读行锚点才计；
app pid 不可锚定时 'has died' 一律不计（fail-safe），铁证信号仍保留灵敏度。

诚实：本脚本判的是「竞态修复必要门」，不是对手真实性裁决。总门维持 FAIL /
对手真实性 0/9；CROSSED（APP 0006 ↔ PC 00D5）由零注入 diff_party_check 另案
唯一裁决。必要非充分：竞态修复 ≠ 进战斗 ≠ 对手真实 ≠ CROSSED；脚本任一 PASS
都不升级总门，不预设成功。红线禁造假（造 party/信任位/伪 CROSSED/造 species/
stale 后补灌凑 applied/STATE_QUEUED 冒充 loaded/bump gen）；灰区须标注；全中文不伪造。

退出码：0=判据全 PASS（**不代表竞态根治成功**，总门仍 FAIL/0/9）；
1=FAIL/UNOBSERVED/INVALID；2=输入错误。
"""

import argparse
import contextlib
import io
import json
import os
import re
import shutil
import sys
import tempfile

# ---------------- 可配置判据（--config 深度合并；列表 plain=追加，{"$set":[...]}=替换）----------------

DEFAULT_CONFIG = {
    'text_exts': ['.log', '.txt', '.out'],
    'max_file_bytes': 256 * 1024 * 1024,
    'frm_min': 3,
    'patterns': {
        # 根治门：一级 = app 接收器回读（唯一强证据）；二级 = driver 下发（弱，绝不够）
        'root_gate_strong': [
            r'\[ISYNC\]\s+MGBAX_ISYNC_SEED_FRAME_BOUNDARY=(\d)',
        ],
        'root_gate_weak': [
            r'PC\s+env\s+显式覆盖:\s*MGBAX_ISYNC_SEED_FRAME_BOUNDARY=(\d)',
            r'setprop\s+debug\.mgbax\.link\.isync_seed_frame_boundary=(\d)',
            r'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=(\d)',
        ],
        # 主线程锚点（回退）：门回读行由 root_strong 提供；此处收 BroadcastReceiver/onReceive。
        # 仅当该行 pid==tid（Android 主线程 tid==pid）才用于锚定。
        'main_anchor': [
            r'\bBroadcastReceiver\b', r'\bonReceive\b', r'\bmain\s+thread\b',
        ],
        # 崩溃候选全集（保留向后兼容，分类实际用 crash_hard/crash_died）
        'crash': [
            r'Fatal\s+signal\s+11',
            r'\bSIGSEGV\b',
            r'\bSEGV_(?:MAPERR|ACCERR)\b',
            r'\bmCoreLoadStateNamed\b',
            r'Tombstone\s+written\s+to\b',
            r'/data/tombstones/',
            r'beginning\s+of\s+crash',
            r'\bhas\s+died\b',
            r'rip\s*[=:]\s*0x0+\b',
            r'fault\s+addr\s+0x0+\b',
        ],
        # 铁证类：本身即崩溃证据（CRASH5 实测 Fatal signal 11 / SEGV / mCore 栈帧 /
        # tombstone / 空指针落点）。进程归属见 _classify_crash：app 名字或 pid 命中
        # 即计；明确他进程才排除；app pid 不可锚定时仍计（保持真崩溃灵敏度）。
        'crash_hard': [
            r'Fatal\s+signal\s+11',
            r'\bSIGSEGV\b',
            r'\bSEGV_(?:MAPERR|ACCERR)\b',
            r'\bmCoreLoadStateNamed\b',
            r'Tombstone\s+written\s+to\b',
            r'/data/tombstones/',
            r'beginning\s+of\s+crash',
            r'rip\s*[=:]\s*0x0+\b',
            r'fault\s+addr\s+0x0+\b',
        ],
        # 'has died' 类：ActivityManager 进程死亡广播。泛匹配会命中
        # com.google.android.googlequicksearchbox:search 被缓存回收（cch CACC）
        # 等系统噪声——必须明确归属 app 才计崩溃（NOCRASH2）。
        'crash_died': [r'\bhas\s+died\b'],
        # 进程归属识别（inline (?i) 不依赖外部 flags）
        'app_proc': [r'(?i)\bio\.mgba\.android\b', r'(?i)\bmGBA-App\b'],
        'other_proc': [
            r'(?i)com\.google\.', r'(?i)com\.android\.', r'(?i)\bgms\b',
            r'(?i)googlequicksearchbox', r'(?i)system_server',
            r'(?i)com\.sec\.', r'(?i)com\.miui\.',
        ],
        # "Process <name> (pid <n>) has died" —— 取被杀进程名与 pid
        'died_proc': [r'Process\s+([^\s(]+)\s+\(pid\s+(\d+)\)\s+has\s+died'],
        'seed_send': [r'\[ISYNC-EV\]\[A1-SEND\]'],
        'seed_land': [r'\[ISYNC-EV\]\[A1-LAND\]'],
        'applied_hit': [r'remote\s+state\s+loaded'],
        'applied_neg': [
            r'state_sync\s*=', r'\bnot\s+applied\b', r'\bdeferred\b',
            r'\bqueued\b', r'\benqueued\b', r'\brejected\b', r'\bexhausted\b',
            r'consoles?\s+not\s+ready',
        ],
        'peer_loaded': [r'peer\s+state\s+loaded'],
        'stale_hit': [r'SEED_DROPPED_STALE'],
        'retarget_hit': [r'seed\s+retarget'],
        'overlap_hit': [r'SEED_APPLY_OVERLAP'],
        'queued_hit': [r'STATE_QUEUED', r'queued\s+to\s+owner\s+thread'],
        'load_trace': [r'loadStateFromMemory', r'nativeLoadStateFromMemory'],
        'frm': [r'\bFRM\b'],
        'battle': [
            r'\bcb2\s*=\s*080B4845\b', r'\bBATTLE\s*=\s*YES\b',
            r'\bbtlType\s*=\s*0000000A\b', r'\[BATTLE\b',
        ],
        'tag': [r'\btag\s*=\s*([A-Za-z0-9_.\-]+)'],
        'gate_prop': [
            r'setprop\s+(debug\.mgbax\.link\.[A-Za-z0-9_.]+)\s*=\s*([^\s]+)'
            r'(?:\s+readback\s*=\s*([^\s]+))?'
        ],
        'gate_env': [r'\bMGBAX_([A-Z0-9_]+)\s*=\s*(\d+)'],
    },
    'fields': {
        'bytes': [r'\bbytes\s*[= ]\s*(\d+)', r'\b(\d+)\s+bytes\b'],
        'sha256': [r'\bsha256\s*=\s*([0-9a-fA-F]{64})'],
        'hash': [r'\bhash\s*=\s*([0-9a-fA-F]+)'],
        'gen': [r'\bgen\s*=\s*(-?\d+)'],
        'current': [r'\bcurrent\s*=\s*(-?\d+)'],
        'applied_count': [r'\bapplied_count\s*=\s*(\d+)'],
        'slot': [r'\b(?:mirrorSlot|slot)\s*=\s*(\d+)'],
        'oldGen': [r'\boldGen\s*=\s*(-?\d+)'],
        'newGen': [r'\bnewGen\s*=\s*(-?\d+)'],
    },
    # 门方向：键为 MGBAX_ 后缀（同时匹配 debug.mgbax.link.<小写> 属性）
    'gates': ['NO_LAG_CLEAR', 'STATE_REARM_GUARD', 'SEED_CLEAN_RESEND', 'RACE_STRESS'],
}

_HASH64_RE = re.compile(r'^[0-9a-fA-F]{64}$')
_LOGCAT_PID_TID_RE = re.compile(
    r'^\s*\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}(?:\.\d+)?\s+(\d+)\s+(\d+)\s+[A-Z]')
# 毫秒级 threadtime 时间戳（跨文件去重用：同一真实 apply 在两路抓取里时间戳逐字相同）
_LOGCAT_TS_RE = re.compile(r'^\s*(\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}\.\d+)')


def _merge_into(base, over):
    """dict 递归合并；列表 plain=追加，{"$set":[...]}=替换（便于改 pattern）。"""
    for k, v in over.items():
        if isinstance(v, dict) and '$set' in v:
            base[k] = v['$set']
        elif isinstance(v, dict) and isinstance(base.get(k), dict):
            _merge_into(base[k], v)
        elif isinstance(v, dict):
            base[k] = dict(v)
        elif isinstance(v, list) and isinstance(base.get(k), list):
            base[k] = list(base[k]) + list(v)
        else:
            base[k] = v
    return base


def load_config(path):
    cfg = json.loads(json.dumps(DEFAULT_CONFIG))  # deep copy
    if path:
        with open(path, 'r', encoding='utf-8') as fh:
            over = json.load(fh)
        if not isinstance(over, dict):
            raise ValueError('--config JSON 顶层必须是对象')
        _merge_into(cfg, over)
    return cfg


def compile_config(cfg):
    p = {}
    for key, pats in cfg['patterns'].items():
        p[key] = [re.compile(s) for s in pats]
    p['fields'] = {k: [re.compile(s) for s in pats]
                   for k, pats in cfg['fields'].items()}
    return p


def _any(patterns, text):
    return any(pat.search(text) for pat in patterns)


def _gate_hits(text, patterns):
    """根治门 pattern 命中 → 门值（0/1）；无数字捕获组的自定义 pattern 一律忽略（fail-closed）。"""
    out = []
    for pat in patterns:
        m = pat.search(text)
        if not m:
            continue
        try:
            out.append(int(m.group(1)))
        except (IndexError, TypeError, ValueError):
            continue
    return out


def _field(text, key, p):
    for pat in p['fields'].get(key, []):
        m = pat.search(text)
        if m:
            return m.group(1)
    return None


def _as_int(value):
    if value is None:
        return None
    try:
        return int(value, 10)
    except (TypeError, ValueError):
        return None


def _pid_tid(text):
    """threadtime 行 → (pid, tid)；无 threadtime 前缀（driver/env 载体）返回 (None, None)。"""
    m = _LOGCAT_PID_TID_RE.match(text)
    return (m.group(1), m.group(2)) if m else (None, None)


def _tid(text):
    return _pid_tid(text)[1]


def _applied_dedup_key(e):
    """跨文件去重的 applied 事件身份。

    主键为父会话指定的 (毫秒时间戳, bytes, hash, gen)：同一真实 apply 被
    app_link_startup.log 与 app_logcat_full.log 各记一条时两行的毫秒时间戳与
    关键字段逐字相同 => 同键。附加 pid/tid/applied_count/slot 作保守约束，
    仅在全部一致时才折叠；真双灌（同 gen 跨 tid 或不同时刻）身份不同，绝不折叠。
    无毫秒时间戳时以正文全文代替时间戳，避免把不同事件误折叠（fail-safe）。
    """
    text = e.get('text') or ''
    m = _LOGCAT_TS_RE.match(text)
    if m:
        ts = m.group(1)
    else:
        ts = 'NOTS|' + re.sub(r'\s+', ' ', text).strip()
    pid, tid = _pid_tid(text)
    return (ts, pid, e.get('tid') or tid,
            _as_int(e.get('bytes')), (e.get('hash') or '').lower(), e.get('gen'),
            e.get('applied_count'), e.get('slot'))


def _role(rel, text):
    m = re.search(r'\brole\s*=\s*(APP|PC|iOS)\b', text, re.I)
    if m:
        return m.group(1).upper()
    base = os.path.basename(rel).lower()
    if base.startswith('app_') or 'logcat' in base or 'mGBA-App' in text:
        return 'APP'
    if base.startswith('pc_') or base.startswith('mgba'):
        return 'PC'
    return 'UNK'


def _readback_ok(text, value):
    """setprop 行但 readback != 设定值 / 带 WARN 未生效 → 弱证据也不可用。"""
    if 'warn' in text.lower():
        return False
    m = re.search(r'readback\s*=\s*(\S+)', text, re.I)
    if not m:
        return True  # env 行无 readback 概念
    return m.group(1).strip() == str(value)


def _new_records():
    return {
        '_seq': 0, 'files': [], 'sample': [],
        'tags': [], 'root_strong': [], 'root_weak': [],
        'crash': [], 'crash_raw': [], 'crash_rejected': [],
        'send': [], 'land': [], 'applied': [], 'peer_loaded': [],
        'stale': [], 'retarget': [], 'overlap': [], 'queued': [],
        'load_trace': [], 'frm': [], 'battle': [], 'main_anchor': [],
        'gate_props': [], 'gate_env': [],
    }


def _add_sample(rec, rel, lineno, text):
    if len(rec['sample']) < 160:
        rec['sample'].append('%s:%d: %s' % (rel, lineno, text.strip()[:260]))


def _classify_line(rel, lineno, text, rec, p):
    low = text.lower()
    seq = rec['_seq']
    rec['_seq'] += 1
    where = '%s:%d' % (rel, lineno)
    snap = text.strip()[:260]
    pid, tid = _pid_tid(text)
    role = _role(rel, text)

    # 1) 根治门回读：强（app 接收器）/弱（driver 下发），注意 WARN/readback 不符作废
    #    自定义 pattern 必须有且仅有一个数字捕获组（门值），否则忽略并 fail-closed。
    for val in _gate_hits(text, p['root_gate_strong']):
        rec['root_strong'].append({'value': val, 'where': where, 'text': snap, 'seq': seq,
                                   'pid': pid, 'tid': tid})
    for val in _gate_hits(text, p['root_gate_weak']):
        rec['root_weak'].append({'value': val, 'where': where, 'text': snap,
                                 'ok': _readback_ok(text, val), 'seq': seq})

    # 2) 崩溃候选：先分铁证(hard)/'has died'(died)两类，进程归属在 scan_run 末尾过滤
    #    （NOCRASH2：系统服务缓存回收的 'has died' 不算 app 崩溃）
    crash_kind = ('hard' if _any(p['crash_hard'], text) else
                  'died' if _any(p['crash_died'], text) else None)
    if crash_kind:
        rec['crash_raw'].append({'where': where, 'text': snap, 'pid': pid,
                                 'tid': tid, 'seq': seq, 'kind': crash_kind})
        _add_sample(rec, rel, lineno, text)

    # 3) 种子 sha256 观测（A1-SEND / A1-LAND）
    for key, bucket in (('seed_send', 'send'), ('seed_land', 'land')):
        if _any(p[key], text):
            rec[bucket].append({
                'where': where, 'text': snap, 'role': role, 'tid': tid, 'seq': seq,
                'bytes': _field(text, 'bytes', p),
                'sha256': _field(text, 'sha256', p),
            })
            _add_sample(rec, rel, lineno, text)

    # 4) 真 applied 里程碑：仅 'remote state loaded'，负向上下文/驱动载体一律不算
    if not _any(p['applied_neg'], text) and _any(p['applied_hit'], text):
        rec['applied'].append({
            'where': where, 'text': snap, 'role': role, 'pid': pid, 'tid': tid, 'seq': seq,
            'bytes': _field(text, 'bytes', p),
            'hash': _field(text, 'hash', p),
            'sha256': _field(text, 'sha256', p),
            'gen': _field(text, 'gen', p),
            'applied_count': _field(text, 'applied_count', p),
            'slot': _field(text, 'slot', p),
        })
        _add_sample(rec, rel, lineno, text)

    # 5) 辅助里程碑（不算 applied，只作旁证）
    if _any(p['peer_loaded'], text):
        rec['peer_loaded'].append({'where': where, 'text': snap, 'seq': seq,
                                   'pid': pid, 'tid': tid,
                                   'bytes': _field(text, 'bytes', p)})
    if _any(p['stale_hit'], text):
        rec['stale'].append({
            'where': where, 'text': snap, 'seq': seq,
            'gen': _field(text, 'gen', p), 'current': _field(text, 'current', p),
            'bytes': _field(text, 'bytes', p), 'slot': _field(text, 'slot', p),
        })
        _add_sample(rec, rel, lineno, text)
    if _any(p['retarget_hit'], text):
        rec['retarget'].append({'where': where, 'text': snap, 'seq': seq,
                                'oldGen': _field(text, 'oldGen', p),
                                'newGen': _field(text, 'newGen', p)})
    if _any(p['overlap_hit'], text):
        rec['overlap'].append({'where': where, 'text': snap, 'seq': seq})
    if _any(p['queued_hit'], text):
        rec['queued'].append({'where': where, 'text': snap, 'seq': seq})
    if _any(p['load_trace'], text):
        rec['load_trace'].append({'where': where, 'text': snap, 'tid': tid, 'seq': seq})
    # 主线程锚点回退（BroadcastReceiver/onReceive）；只有 pid==tid 才可用于锚定
    if _any(p['main_anchor'], text):
        rec['main_anchor'].append({'where': where, 'text': snap, 'pid': pid,
                                   'tid': tid, 'seq': seq})

    # 6) mirrorLoop 存活 FRM 采样（FRM + emuFps/frames，防裸 FRM 假阳性）
    if _any(p['frm'], text) and ('emufps' in low or 'frames' in low):
        rec['frm'].append({'where': where, 'text': snap, 'seq': seq})

    # 7) 进战斗窗（观察项）
    if _any(p['battle'], text):
        rec['battle'].append({'where': where, 'text': snap, 'seq': seq})

    # 8) tag：只认 summary* 文件的 key=value，不扫 logcat 正文里的 tag=（防误入
    #    system_app_strictmode 之类 Android 日志字段）
    if os.path.basename(rel).lower().startswith('summary'):
        for pat in p['tag']:
            m = pat.match(text.strip())
            if m:
                rec['tags'].append({'value': m.group(1), 'where': where})

    # 9) 门方向：setprop(readback) + MGBAX_ env
    for pat in p['gate_prop']:
        m = pat.search(text)
        if m:
            name = m.group(1).split('.')[-1].upper()  # isync_seed_frame_boundary → ...
            rec['gate_props'].append({
                'prop': m.group(1), 'name': name, 'value': m.group(2),
                'readback': m.group(3), 'ok': _readback_ok(text, m.group(2)),
                'where': where, 'text': snap,
            })
    for pat in p['gate_env']:
        for m in pat.finditer(text):
            rec['gate_env'].append({'name': m.group(1), 'value': m.group(2),
                                    'where': where})


def _app_pid(rec):
    """app 进程 pid 锚点：门回读行/BroadcastReceiver 行中 pid==tid（Android 主线程）者。

    多值冲突或缺失返回 None（fail-safe：无法锚定 app pid 时 'has died' 一律不计）。
    只取 pid==tid 的行，避免把 worker tid 当进程 pid。
    """
    for rows in (rec.get('root_strong', []), rec.get('main_anchor', [])):
        cands = set(r['pid'] for r in rows
                    if r.get('pid') and r.get('pid') == r.get('tid'))
        if len(cands) == 1:
            return next(iter(cands))
        if len(cands) > 1:
            return None
    return None


def _classify_crash(rec, p):
    """按进程归属过滤崩溃候选（NOCRASH2），返回 (计入, 排除含原因)。

    hard（Fatal11/SIGSEGV/mCore/tombstone/空指针落点）：
      - app 名字命中或 threadtime pid 命中 app_pid => 计入；
      - 明确他进程（com.google/gms/system_server 等）且非 app => 排除；
      - app_pid 不可锚定且无他进程名 => 仍计入（fail-safe 保留真崩溃灵敏度）。
    died（'has died'）：
      - 进程名明确 io.mgba.android，或 threadtime pid 命中 app_pid => 计入；
      - 其余（含 com.google.* 缓存回收、无法识别 app pid）=> 一律排除。
    """
    app_pid = _app_pid(rec)
    valid, rejected = [], []
    for c in rec.get('crash_raw', []):
        text = c['text']
        pid = c.get('pid')
        died_name = None
        for pat in p.get('died_proc', []):
            m = pat.search(text)
            if m:
                died_name = m.group(1)
                break
        app_named = ((died_name is not None and 'io.mgba.android' in died_name.lower())
                     or _any(p['app_proc'], text))
        other_named = _any(p['other_proc'], text)
        pid_hit = app_pid is not None and pid == app_pid
        if c['kind'] == 'died':
            if app_named or pid_hit:
                ok, why = True, ('has died 归属 app（名字=%s / pid=%s 命中 app_pid=%s）'
                                 % (died_name or '?', pid or '?', app_pid))
            else:
                ok, why = False, ('has died 非 app 进程（name=%s pid=%s app_pid=%s）'
                                  % (died_name or '?', pid or '?', app_pid or '未知'))
        else:
            if app_named or pid_hit:
                ok, why = True, '崩溃铁证归属 app（名字/pid 命中）'
            elif other_named:
                ok, why = False, '崩溃铁证明确归属他进程（com.google/gms 等）'
            else:
                ok, why = True, '崩溃铁证信号（app pid 不可锚定，保留灵敏度）'
        if ok:
            valid.append(c)
        else:
            rejected.append(dict(c, reject_reason=why))
    return valid, rejected


def scan_run(run_dir, p, cfg):
    rec = _new_records()
    rec['run_dir'] = os.path.abspath(run_dir) if run_dir else None
    if not run_dir or not os.path.isdir(run_dir):
        rec['scan_error'] = '不是有效目录: %s' % run_dir
        return rec
    exts = tuple(e.lower() for e in cfg['text_exts'])
    for root, _dirs, files in os.walk(run_dir):
        for name in sorted(files):
            full = os.path.join(root, name)
            rel = os.path.relpath(full, run_dir).replace('\\', '/')
            if os.path.splitext(name)[1].lower() not in exts:
                continue
            try:
                size = os.path.getsize(full)
            except OSError:
                continue
            over = size > cfg['max_file_bytes']
            rec['files'].append({'path': rel, 'bytes': size,
                                 'scanned': not over, 'over_limit': over})
            if over:
                continue
            try:
                with open(full, 'r', encoding='utf-8', errors='replace') as fh:
                    for lineno, line in enumerate(fh, 1):
                        _classify_line(rel, lineno, line.rstrip('\r\n'), rec, p)
            except OSError:
                pass
    # 崩溃候选按进程归属过滤（NOCRASH2）：去系统服务 'has died' 噪声，保留 app 铁证
    rec['crash'], rec['crash_rejected'] = _classify_crash(rec, p)
    return rec


# ---------------- 判读 ----------------

def _gate_values(rec, cfg):
    """{门名: (值, 来源, 是否一致)}；同门多值冲突即不一致（FAIL）。"""
    want = set(cfg['gates'])
    out = {}
    for src, rows in (('prop', rec['gate_props']), ('env', rec['gate_env'])):
        for r in rows:
            # prop: debug.mgbax.link.no_lag_clear → NO_LAG_CLEAR；env: MGBAX_NO_LAG_CLEAR → NO_LAG_CLEAR
            canonical = r['name'] if src == 'env' else r['name'].split('.')[-1].upper()
            if canonical not in want:
                continue
            if src == 'prop':
                ok = r['ok'] and (r['readback'] is None or r['readback'] == r['value'])
                value = r['value'] if ok else r['value'] + '!无效'
            else:
                value = r['value']
            out.setdefault(canonical, []).append((value, r['where']))
    result = {}
    for g, vals in out.items():
        distinct = set(v for v, _ in vals)
        result[g] = {
            'values': sorted(distinct), 'consistent': len(distinct) == 1,
            'value': next(iter(distinct)) if len(distinct) == 1 else None,
            'where': vals[0][1], 'count': len(vals),
        }
    return result


def judge(rec, p, cfg, args):
    checks = {}
    files_scanned = sum(1 for f in rec['files'] if f['scanned'])
    app_files = sum(1 for f in rec['files'] if f['scanned'] and
                    (os.path.basename(f['path']).lower().startswith('app_')
                     or 'logcat' in f['path'].lower()))

    # --- TAG_MATCH：summary 的 tag 必须等于命令行 tag（缺=UNOBS，不符=FAIL）---
    tags = sorted(set(t['value'] for t in rec['tags']))
    if not tags:
        checks['TAG_MATCH'] = ('UNOBSERVED', '所有扫描文件均缺 tag= 字段')
    elif args.tag in tags:
        checks['TAG_MATCH'] = ('PASS', 'tag=%s 匹配' % args.tag)
    else:
        checks['TAG_MATCH'] = ('FAIL', 'tag 不匹配：观测=%s 期望=%s（可能跑错轮/覆盖 artifact）'
                               % (','.join(tags), args.tag))

    # --- ROOT_GATE_ACTIVE：强证据仅 app 接收器回读；弱证据只下发不证生效 ---
    expect_root = args.root_gate if args.root_gate is not None else (0 if args.role == 'control' else 1)
    strong = rec['root_strong']
    weak = [w for w in rec['root_weak'] if w['ok']]
    if strong:
        vals = sorted(set(s['value'] for s in strong))
        if len(vals) > 1:
            checks['ROOT_GATE_ACTIVE'] = (
                'FAIL', 'app 回读门值漂移=%s（不可同时开/关）' % ','.join(map(str, vals)))
        elif vals[0] == expect_root:
            basis = 'app 接收器一级回读' 
            if expect_root == 0:
                basis += '=0（对照组门关强确认）'
            checks['ROOT_GATE_ACTIVE'] = ('PASS', '%s MGBAX_ISYNC_SEED_FRAME_BOUNDARY=%d @%s'
                                          % (basis, vals[0], strong[0]['where']))
        else:
            checks['ROOT_GATE_ACTIVE'] = (
                'FAIL', 'app 回读门值=%d，预期=%d（门意外开/关，前提破裂）'
                % (vals[0], expect_root))
    elif weak:
        wvals = sorted(set(w['value'] for w in weak))
        if expect_root == 0 and wvals == [0]:
            checks['ROOT_GATE_ACTIVE'] = (
                'PASS', '弱证据：driver env/setprop=0 且无 app 回读=1；对照组门关'
                '（app 接收器未触发属预期；仅用于对照方向，不作用于修复结论）@%s'
                % weak[0]['where'])
        else:
            checks['ROOT_GATE_ACTIVE'] = (
                'UNOBSERVED', '仅 driver 下发(=%s) 无 app 一级回读；setprop readback 不证 Java 门生效'
                % (','.join(map(str, wvals))))
    else:
        checks['ROOT_GATE_ACTIVE'] = ('UNOBSERVED', '无任何根治门回读/下发记录（fail-closed）')

    # --- 崩溃 / 对照组复现 ---
    crash = rec['crash']
    if args.role == 'control' and args.expect_crash == 'yes':
        if crash:
            checks['CRASH_REPRODUCED'] = ('PASS', '对照组复现崩溃 %d 条（造窗有效）' % len(crash))
        else:
            checks['CRASH_REPRODUCED'] = (
                'FAIL', '对照组未复现崩溃/双灌 => 窗口未造出，本轮 INVALID（不得当修复有效）')
    else:
        if not app_files:
            checks['NO_CRASH'] = ('UNOBSERVED', '无可扫描 app 日志，不能宣称无崩溃')
        elif crash:
            checks['NO_CRASH'] = ('FAIL', 'app 日志命中 %d 条归属 app 的崩溃证据（Fatal11/'
                                  'SIGSEGV/mCoreLoadStateNamed/tombstone 或 io.mgba.android '
                                  'has died）' % len(crash))
        else:
            rejected_n = len(rec.get('crash_rejected', []))
            checks['NO_CRASH'] = (
                'PASS', '已扫 %d 个 app 日志文件，未见归属 app 的崩溃信号%s'
                % (app_files, '；排除 %d 条他进程 has died 噪声（如 Google 缓存回收）'
                   % rejected_n if rejected_n else ''))

    # --- APPLIED_UNIQUE（W69 口径）：按 (bytes,sha256) 配对；铁证收敛到并发/主线程/崩溃 ---
    # 修正（W69）：gen=接收端 ConsoleSet 实例代次（SEED_SET_GEN 单调，rebuild/retarget
    # 跳号如 1→4），applied_count=Activity 全局 AtomicInteger（只认真 load，跨 gen 单调），
    # 二者非 1:1。同 gen 停滞期内多个重发包先后到达各 load 一次（ac 递增）是合法串行
    # 重灌，不是双灌。旧「applied_count 取值数 == distinct gen 数」的 1:1 双射假设
    # （AU2 遗留）在 gen 停滞+ac 递增形态下必然误报（A 轮 gen=1/4/4/4、ac=1/2/3/4），
    # 予以废弃。按 (bytes,hash,gen) 分组与跨文件去重保留；同 hash 跨 gen 仍属合法重灌。
    # 修正（APPLIEDUNIQUE2）：分组/判铁证前先跨文件去重。r2 的 6 条 loaded 是
    # app_link_startup.log(3) + app_logcat_full.log(3) 逐字相同的同一运行两路抓取
    # （同毫秒时间戳/同 pid/同 tid），旧口径把每个 gen 折叠前算 2 条 → 误判
    # 同(bytes,hash,gen)重复 3 组。按事件身份去重后每个 gen 只算 1 条真 applied。
    applied_raw = rec['applied']
    applied = []
    _first_where = {}
    _dup_by_kept = {}
    for e in applied_raw:
        k = _applied_dedup_key(e)
        if k in _first_where:
            _dup_by_kept.setdefault(_first_where[k]['where'], []).append(e['where'])
        else:
            _first_where[k] = e
            applied.append(e)
    applied_dup = [{'kept': k, 'collapsed': v} for k, v in _dup_by_kept.items()]
    seeds = {}
    for r in rec['send'] + rec['land']:
        b, s = _as_int(r['bytes']), r['sha256']
        if b is not None and s and _HASH64_RE.match(s):
            seeds.setdefault((b, s.lower()), []).append(r)
    bytes_to_seeds = {}
    for (b, s), rows in seeds.items():
        bytes_to_seeds.setdefault(b, []).append((s, rows))

    # 以 (bytes, hash, gen) 为键分组：合法多 gen 重灌 = 多条、每条不同 gen。
    groups = {}
    for e in applied:
        key = (_as_int(e['bytes']), (e['hash'] or '').lower(), e['gen'])
        groups.setdefault(key, []).append(e)

    # 真双灌铁证 ①：同一 (bytes,hash,gen) 跨 tid —— 同一代状态被两个（镜像/重建）
    # 线程同时 load（CRASH5 核心形态）。gen 停滞但同一 tid 串行 load 不属此类。
    same_gen_tid_multi = {k: v for k, v in groups.items()
                          if len(set(e['tid'] for e in v if e['tid'])) > 1}

    # 合法「gen 停滞 + 串行重灌」判据：同 gen 组内 tid 唯一且可解析、applied_count 严格
    # 递增（全局 AtomicInteger 每次真 load +1）。不满足者（重复 ac / tid 不可解析 /
    # 多 tid）不是合法重灌，按铁证 A 处理——保留旧 case(28)「同 gen 同 tid 不同时刻
    # 重复 ac」的灵敏度，绝不因修盲区删真双灌灵敏度。
    def _legit_serial_reload(v):
        tids = set(e['tid'] for e in v if e['tid'])
        if len(tids) != 1:
            return False
        acs = [e['applied_count'] for e in v]
        if any(a is None for a in acs):
            return False
        try:
            vals = [int(a) for a in acs]
        except (TypeError, ValueError):
            return False
        return all(b > a for a, b in zip(vals, vals[1:]))
    same_gen_multi = {k: v for k, v in groups.items()
                      if len(v) > 1 and not _legit_serial_reload(v)}

    # 真双灌铁证 ②：同 gen 多条 load 中存在主线程 tid（主线程崩 + 重建线程再灌的形态）。
    # 主线程 tid 从 pid==tid 的门回读/BroadcastReceiver 行锚定（与 MAIN_THREAD_LOAD_ZERO 同源）。
    main_tid_ap = None
    for s in strong:
        if s.get('value') == 1 and s.get('pid') and s.get('pid') == s.get('tid'):
            main_tid_ap = s['tid']
            break
    if main_tid_ap is None:
        for a in rec['main_anchor']:
            if a.get('pid') and a.get('pid') == a.get('tid'):
                main_tid_ap = a['tid']
                break
    same_gen_main_thread = {k: v for k, v in groups.items()
                            if len(v) > 1 and any(e['tid'] == main_tid_ap for e in v)}

    # 真双灌铁证 ③：同 gen 多条 load 与本轮崩溃铁证同现（即使 tid 形态不典型）。
    crash_with_multi = bool(crash) and any(len(v) > 1 for v in groups.values())

    missing_field = [e for e in applied if not e['bytes'] or not e['hash'] or not e['gen']
                     or not e['applied_count']]

    if not applied:
        checks['APPLIED_UNIQUE'] = ('UNOBSERVED', '无 "remote state loaded" 里程碑'
                                    '（STATE_QUEUED/入队/re-target 不算 applied）')
    elif args.role == 'fix' and missing_field:
        # fail-closed 优先：字段缺失无法按 gen 判读，先降级（不拿缺失 gen 凑同 gen 组）
        checks['APPLIED_UNIQUE'] = (
            'UNOBSERVED', 'applied 里程碑字段缺失（bytes/hash/gen/applied_count），fail-closed @%s'
            % missing_field[0]['where'])
    elif same_gen_multi or same_gen_tid_multi or same_gen_main_thread or crash_with_multi:
        iron = []
        if same_gen_tid_multi:
            iron.append('同(bytes,hash,gen)跨tid并发 %d 组' % len(same_gen_tid_multi))
        if same_gen_multi:
            iron.append('同gen非合法串行重灌(重复ac/多tid/不可解析) %d 组' % len(same_gen_multi))
        if same_gen_main_thread:
            iron.append('同gen多条load含主线程tid %d 组' % len(same_gen_main_thread))
        if crash_with_multi:
            iron.append('同gen多条load与崩溃铁证同现')
        where = None
        for bucket in (same_gen_tid_multi, same_gen_multi, same_gen_main_thread):
            if bucket:
                where = next(iter(bucket.values()))[0]['where']
                break
        checks['APPLIED_UNIQUE'] = (
            'FAIL', '双 apply 并存（CRASH5 铁证：%s）%s'
            % ('；'.join(iron), ' @%s' % where if where else ''))
    elif not seeds:
        checks['APPLIED_UNIQUE'] = (
            'UNOBSERVED', '缺 A1-SEND/A1-LAND sha256，无法按(字节数,sha256)配对')
    else:
        ambiguous = []
        unmatched = []
        for key, rows in groups.items():
            b, _h, _g = key
            cands = bytes_to_seeds.get(b, [])
            if not cands:
                unmatched.append(rows[0])
            elif len(cands) > 1:
                ambiguous.append(rows[0])
        if unmatched or ambiguous:
            checks['APPLIED_UNIQUE'] = (
                'UNOBSERVED', '配对不唯一/无匹配：%d 条无同字节 seed，%d 条同字节多 sha（fail-closed）'
                % (len(unmatched), len(ambiguous)))
        else:
            dedup_note = ('；跨文件去重折叠 %d 条重复抓取' % (len(applied_raw) - len(applied))
                          if len(applied) != len(applied_raw) else '')
            checks['APPLIED_UNIQUE'] = (
                'PASS', '%d 个 distinct gen 共 %d 条 applied；重灌均为「同 tid + applied_count '
                '严格递增」的合法串行形态（gen 停滞=接收端实例未重建、ac=全局计数，二者非 1:1）、'
                '无同 gen 跨 tid/主线程/崩溃同现，已按(bytes,sha256)与 A1-SEND/A1-LAND 配对%s'
                % (len(groups), len(applied), dedup_note))
    # 门没开 → applied/stale 判读降级（数据无效）
    degraded = []
    if args.role == 'fix' and checks['ROOT_GATE_ACTIVE'][0] != 'PASS':
        for k in ('APPLIED_UNIQUE', 'STALE_SEMANTICS'):
            if checks.get(k) and checks[k][0] == 'PASS':
                checks[k] = ('UNOBSERVED', '根治门未证实生效，该轮 applied/stale 数据无效（降级）：'
                             + checks[k][1])
            degraded.append(k)

    # --- STALE_SEMANTICS ---
    stale = rec['stale']
    if not stale:
        checks['STALE_SEMANTICS'] = ('UNOBSERVED', '未见 SEED_DROPPED_STALE，代次丢弃语义未被触发/无法核验')
    else:
        bad = []
        for s in stale:
            g, c = _as_int(s['gen']), _as_int(s['current'])
            if g is not None and c is not None and g == c:
                bad.append('gen==current（误丢合法）@%s' % s['where'])
        applied_gens = set(e['gen'] for e in applied if e['gen'] is not None)
        for s in stale:
            if s['gen'] in applied_gens:
                bad.append('丢弃已 applied 的 gen=%s @%s' % (s['gen'], s['where']))
        if rec['overlap']:
            bad.append('SEED_APPLY_OVERLAP 命中 %d 次' % len(rec['overlap']))
        if bad:
            checks['STALE_SEMANTICS'] = ('FAIL', 'stale 语义错：' + '；'.join(bad[:4]))
        else:
            checks['STALE_SEMANTICS'] = (
                'PASS', '%d 条 SEED_DROPPED_STALE 均 gen!=current 且未丢已 applied 的 gen，'
                'SEED_APPLY_OVERLAP=0' % len(stale))

    # --- MIRRORLOOP_ALIVE：FRM 持续，崩后不得空 tap ---
    frm = rec['frm']
    last_crash_seq = max((c['seq'] for c in crash), default=-1)
    frm_after = [f for f in frm if f['seq'] > last_crash_seq] if crash else frm
    if crash and not frm_after:
        checks['MIRRORLOOP_ALIVE'] = ('FAIL', '崩溃后无 FRM 采样（空 tap），mirrorLoop 未存活')
    elif len(frm) >= cfg['frm_min']:
        checks['MIRRORLOOP_ALIVE'] = (
            'PASS', 'FRM 采样 %d 行 >= 阈值 %d%s'
            % (len(frm), cfg['frm_min'], '；崩后仍有 %d 行' % len(frm_after) if crash else ''))
    else:
        checks['MIRRORLOOP_ALIVE'] = (
            'UNOBSERVED', 'FRM 采样 %d 行 < 阈值 %d' % (len(frm), cfg['frm_min']))

    # --- GATE_DIRECTIONS：门方向 + 漂移/缺失 + 显式期望 ---
    gv = _gate_values(rec, cfg)
    gproblems = []   # 观测到的错误值/漂移 => FAIL
    gmissing = []    # 必要门缺值 => UNOBSERVED（fail-closed，不伪造补位）
    observed = {}
    for g in cfg['gates']:
        info = gv.get(g)
        if info is None:
            observed[g] = None
            if g in ('STATE_REARM_GUARD',) or g in args.expect:
                gmissing.append('%s 缺值' % g)
            continue
        observed[g] = info['value'] if info['consistent'] else info['values']
        if not info['consistent']:
            gproblems.append('%s 门值漂移=%s' % (g, info['values']))
        if g == 'STATE_REARM_GUARD' and info['value'] != '1':
            gproblems.append('STATE_REARM_GUARD=%s（须恒 1）' % info['value'])
        if g in args.expect and info['value'] != args.expect[g]:
            gproblems.append('%s=%s 与 --expect %s 不符' % (g, info['value'], args.expect[g]))
    # 根治门方向也纳入展示（强/弱由 ROOT_GATE_ACTIVE 判）
    rg = gv.get('ISYNC_SEED_FRAME_BOUNDARY') or gv.get('SEED_FRAME_BOUNDARY')
    if rg:
        observed['ISYNC_SEED_FRAME_BOUNDARY'] = rg['value'] if rg['consistent'] else rg['values']
    if gproblems:
        checks['GATE_DIRECTIONS'] = ('FAIL', '；'.join(gproblems))
    elif gmissing:
        checks['GATE_DIRECTIONS'] = ('UNOBSERVED', '必要门值缺失（fail-closed）：' + '、'.join(gmissing))
    else:
        checks['GATE_DIRECTIONS'] = (
            'PASS', '门方向：' + '，'.join('%s=%s' % (k, v) for k, v in observed.items()))

    # --- 进战斗窗（观察，不参与总判据）---
    if rec['battle']:
        checks['BATTLE_WINDOW'] = ('PASS', '命中 %d 条战斗窗标记（仅观察，不参与总判据）'
                                   % len(rec['battle']))
    else:
        checks['BATTLE_WINDOW'] = ('UNOBSERVED', '未见 cb2=080B4845/BATTLE=YES（仅观察）')

    # --- MAIN_THREAD_LOAD_ZERO：主线程零 load（RACETID §3.2，宽窗可省前提）---
    # 锚点优先级：门回读行(value=1, pid==tid) > BroadcastReceiver/onReceive(pid==tid)。
    # Android 主线程 tid==pid；只有 pid==tid 的行才配做主线程锚点，避免把 worker  tid 当主线程。
    main_tid = None
    anchor_where = None
    anchor_conflict = []
    anchor_candidates = set()
    for s in strong:
        if s.get('value') == 1 and s.get('pid') and s.get('pid') == s.get('tid'):
            anchor_candidates.add(s['tid'])
            if anchor_where is None:
                anchor_where = s['where']
    if len(anchor_candidates) == 1:
        main_tid = next(iter(anchor_candidates))
    elif len(anchor_candidates) > 1:
        anchor_conflict = sorted(anchor_candidates)
    else:
        anchor_conflict = []
        rc_candidates = set()
        for a in rec['main_anchor']:
            if a.get('pid') and a.get('pid') == a.get('tid'):
                rc_candidates.add(a['tid'])
                if anchor_where is None:
                    anchor_where = a['where']
        if len(rc_candidates) == 1:
            main_tid = next(iter(rc_candidates))
        elif len(rc_candidates) > 1:
            anchor_conflict = sorted(rc_candidates)

    # load 里程碑：remote state loaded（applied）+ peer state loaded，二者都算。
    loads = list(applied) + list(rec['peer_loaded'])
    on_main = [r for r in loads if r.get('tid') is not None and r.get('tid') == main_tid]
    unobservable = [r for r in loads if r.get('tid') is None]
    if anchor_conflict:
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'UNOBSERVED', '主线程 tid 锚点冲突=%s（不可锚定）→ 退回宽窗压测'
            % ','.join(anchor_conflict))
    elif main_tid is None:
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'UNOBSERVED', '无 pid==tid 的门回读/BroadcastReceiver 行，主线程 tid 不可锚定'
            '→ 退回宽窗压测（fail-closed）')
    elif not loads:
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'UNOBSERVED', '无 load 里程碑（remote/peer state loaded），线程归属不可判'
            '→ 退回宽窗压测（fail-closed）')
    elif on_main:
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'FAIL', '主线程 tid=%s(锚点@%s)；%d/%d 条 load 里程碑 tid==main_tid（%s）@%s'
            '=> load 仍在主线程，竞态未根治'
            % (main_tid, anchor_where, len(on_main), len(loads),
               ','.join(r['tid'] for r in on_main), on_main[0]['where']))
    elif unobservable:
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'UNOBSERVED', '主线程 tid=%s；%d/%d 条 load 里程碑 tid 不可解析（无 threadtime '
            'pid/tid），fail-closed → 退回宽窗压测'
            % (main_tid, len(unobservable), len(loads)))
    else:
        load_tids = sorted(set(r['tid'] for r in loads))
        checks['MAIN_THREAD_LOAD_ZERO'] = (
            'PASS', '主线程 tid=%s(锚点@%s)；%d 条 load 里程碑 tid 全≠主线程（%s，可解析）'
            '=> 主线程零 load，宽窗可省'
            % (main_tid, anchor_where, len(loads), ','.join(load_tids)))

    # --- CRASH5 铁证合并标记 ---
    crash5 = bool((same_gen_tid_multi or same_gen_multi or same_gen_main_thread) and crash)
    crash5_detail = ('双 apply 并存 + 主线程崩溃信号同现（CRASH5 铁证）' if crash5 else
                     '未见「双 apply + 崩溃」同现；不足以断言 CRASH5')

    # --- 总判据 ---
    if args.role == 'control':
        required = ['TAG_MATCH', 'ROOT_GATE_ACTIVE', 'CRASH_REPRODUCED', 'GATE_DIRECTIONS']
    else:
        required = ['TAG_MATCH', 'ROOT_GATE_ACTIVE', 'NO_CRASH', 'APPLIED_UNIQUE',
                    'STALE_SEMANTICS', 'MIRRORLOOP_ALIVE', 'GATE_DIRECTIONS',
                    'MAIN_THREAD_LOAD_ZERO']
    statuses = [checks[k][0] for k in required]
    if 'FAIL' in statuses:
        overall = 'FAIL'
    elif 'UNOBSERVED' in statuses:
        overall = 'UNOBSERVED'
    else:
        overall = 'PASS'
    if args.role == 'control' and checks.get('CRASH_REPRODUCED', ('', ''))[0] == 'FAIL':
        overall = 'INVALID'

    # 灰区判定数值化：RACE_STRESS 是压测强度，任何 >0（含 300/1000）都属灰区全开，
    # 旧 =='1' 漏判强度>1。门值漂移时 observed[g] 为 list，须逐项判定（fail-safe 不过漏）。
    def _gt_zero(v):
        try:
            return int(v) > 0
        except (TypeError, ValueError):
            return False

    _stress = observed.get('RACE_STRESS')
    _stress_on = (any(_gt_zero(x) for x in _stress) if isinstance(_stress, list)
                  else _gt_zero(_stress))
    gray = (observed.get('NO_LAG_CLEAR') == '0' or _stress_on
            or any(v == '1' for k, v in observed.items() if k in ('GRAY_ALL', 'GRAY_LOBBY_OPEN')))
    notes = [
        '本脚本只判竞态修复必要门，不判对手真实性；总门维持 FAIL / 对手真实性 0/9。',
        'CROSSED（APP 0006 <-> PC 00D5）由零注入 diff_party_check 另案唯一裁决；本脚本任一项 PASS 都不升级总门。',
        '必要非充分：竞态修复 ≠ 进战斗 ≠ 对手真实 ≠ CROSSED；不预设成功。',
        '根治门仅认 app 一级回读：setprop debug.mgbax.link.isync_seed_frame_boundary readback=1 只证属性写入。',
        '门未证实生效时 applied/stale 判读降级为 UNOBSERVED（门没开的数据无效）。',
        '逐文件逐行扫描（含 >1MB 日志），禁目录级 grep；二进制/超限文件跳过并声明。',
        'applied 跨文件去重：同一真实 apply 常被 app_link_startup.log 与 app_logcat_full.log 各记一条；'
        '按(毫秒时间戳,bytes,hash,gen)+pid/tid/applied_count/slot 折叠同一事件，真同gen跨tid双灌不折叠。',
        'NOCRASH2 崩溃归属：铁证(Fatal11/SIGSEGV/mCore/tombstone)按 app 名字/pid 命中计入；'
        "'has died' 仅 io.mgba.android 或 pid 命中 app 门回读锚点才计，com.google 等系统缓存回收排除；"
        'app pid 不可锚定时 has died 一律不计，铁证仍计（不放松真崩溃灵敏度）。',
    ]
    notes.append('MAIN_THREAD_LOAD_ZERO：主线程 tid 从门回读/BroadcastReceiver 行（pid==tid）锚定；'
                 'load 里程碑 tid==主线程 => FAIL，全≠主线程且可解析 => PASS，不可观测 => UNOBSERVED。')
    if checks['MAIN_THREAD_LOAD_ZERO'][0] == 'UNOBSERVED':
        notes.append('主线程 load 归属不可观测 => 退回宽窗压测（RACETID「宽窗可省」前提不成立，不得省窗）。')
    if degraded:
        notes.append('本轮降级项（门未证实生效）：' + '、'.join(degraded))
    if gray:
        # 文案数据驱动：显示本轮实测门值，不再硬编码 "RACE_STRESS=1"（与数值>0 判定一致）。
        notes.append('灰区/压测标注：NO_LAG_CLEAR=%s 或 RACE_STRESS=%s => 灰区全开、'
                     'CROSSED 可信度存疑、非纯零注入；只能判崩/双灌/窗口覆盖度，不得作 CROSSED 证据。'
                     % (observed.get('NO_LAG_CLEAR'), observed.get('RACE_STRESS')))

    return {
        'RUN': rec['run_dir'], 'TAG_EXPECT': args.tag, 'TAGS_OBSERVED': tags,
        'ROLE': args.role, 'EXPECT_ROOT_GATE': expect_root,
        'RACE_GATE_ACTIVE': checks['ROOT_GATE_ACTIVE'][0],
        'ROOT_GATE_DETAIL': checks['ROOT_GATE_ACTIVE'][1],
        'MAIN_THREAD_LOAD_ZERO': checks['MAIN_THREAD_LOAD_ZERO'][0],
        'MAIN_TID_ANCHOR': main_tid,
        'OVERALL': overall,
        'CHECKS': {k: {'status': v[0], 'detail': v[1]} for k, v in checks.items()},
        'GATES_OBSERVED': observed,
        'CRASH5_IRONCLAD': crash5, 'CRASH5_DETAIL': crash5_detail,
        'COUNTS': {
            'files_scanned': files_scanned, 'app_files': app_files,
            'root_strong': len(strong), 'root_weak_ok': len(weak),
            'crash': len(crash), 'crash_raw': len(rec.get('crash_raw', [])),
            'crash_rejected': len(rec.get('crash_rejected', [])),
            'app_pid': _app_pid(rec),
            'send': len(rec['send']), 'land': len(rec['land']),
            'applied': len(applied), 'applied_raw': len(applied_raw),
            'applied_dup_collapsed': len(applied_raw) - len(applied),
            'peer_loaded': len(rec['peer_loaded']),
            'stale': len(stale), 'retarget': len(rec['retarget']),
            'overlap': len(rec['overlap']), 'queued': len(rec['queued']),
            'load_trace': len(rec['load_trace']), 'frm': len(frm),
            'battle': len(rec['battle']),
            'main_anchor': len(rec['main_anchor']), 'load_milestones': len(loads),
        },
        'DEGRADED': degraded, 'GRAY_OR_STRESS': gray,
        # P2 可选（纯附加字段，不改任何 check/OVERALL）：overlap 可观测性标记。
        # 只有「有 app 日志且有 stale/applied 里程碑」时，SEED_APPLY_OVERLAP=0 才是有
        # 意义的观测；否则 0 命中只代表「未见命中」，不得表述为「已证实无重叠」。
        'OVERLAP_OBSERVABLE': bool(app_files and (stale or applied)),
        'CRITERION': {
            'fix': 'TAG/ROOT_GATE_ACTIVE/NO_CRASH/APPLIED_UNIQUE/STALE_SEMANTICS/'
                   'MIRRORLOOP_ALIVE/GATE_DIRECTIONS/MAIN_THREAD_LOAD_ZERO 全 PASS => PASS；'
                   'FAIL > UNOBSERVED > PASS；根治门未证实 => applied/stale 降级；'
                   '主线程 load 归属不可观测 => 退回宽窗压测',
            'control': 'TAG/ROOT_GATE_ACTIVE(门关)/CRASH_REPRODUCED/GATE_DIRECTIONS；'
                       '不复现崩溃 => INVALID',
        },
        'NOTES': notes,
        'FILES': rec['files'], 'SAMPLES': rec['sample'][:30],
        'ROOT_GATE_SAMPLES': strong[:4] + weak[:4],
        'APPLIED_SAMPLES': applied[:6], 'APPLIED_DEDUP': applied_dup[:12],
        'CRASH_SAMPLES': crash[:6],
        'CRASH_RAW_SAMPLES': rec.get('crash_raw', [])[:6],
        'CRASH_REJECTED': rec.get('crash_rejected', [])[:12],
        'STALE_SAMPLES': stale[:6], 'GATE_PROPS': rec['gate_props'][:12],
        'scan_error': rec.get('scan_error'),
    }


def fmt(res):
    lines = []
    lines.append('=== RACEREAD 根治门 + 竞态修复证据判读（只读，非成功裁决）===')
    lines.append('RUN=%s' % res['RUN'])
    lines.append('TAG expect=%s observed=%s' % (res['TAG_EXPECT'], ','.join(res['TAGS_OBSERVED'])))
    lines.append('ROLE=%s  EXPECT_ROOT_GATE=%s' % (res['ROLE'], res['EXPECT_ROOT_GATE']))
    if res['scan_error']:
        lines.append('WARN: ' + res['scan_error'])
    c = res['COUNTS']
    lines.append('files_scanned=%d app=%d (逐文件，禁目录级 grep)' % (c['files_scanned'], c['app_files']))
    lines.append('applied: raw=%d 去重后=%d 折叠重复=%d（跨文件同事件）'
                 % (c.get('applied_raw', c['applied']), c['applied'],
                    c.get('applied_dup_collapsed', 0)))
    lines.append('RACE_GATE_ACTIVE=%s | %s' % (res['RACE_GATE_ACTIVE'], res['ROOT_GATE_DETAIL']))
    lines.append('-- 逐项判据 --')
    for k, v in res['CHECKS'].items():
        lines.append('  %-20s=%-11s | %s' % (k, v['status'], v['detail']))
    lines.append('GATES=%s' % res['GATES_OBSERVED'])
    lines.append('CRASH5_IRONCLAD=%s | %s' % (res['CRASH5_IRONCLAD'], res['CRASH5_DETAIL']))
    lines.append('OVERALL=%s（判据全绿，非成功；总门 FAIL/0/9）' % res['OVERALL'])
    for n in res['NOTES']:
        lines.append('NOTE: ' + n)
    return '\n'.join(lines)


# ---------------- 自测（合成日志只写系统 temp，不碰仓库产物）----------------

_SHA = 'a' * 64
_SHA2 = 'b' * 64


def _run(files, tag='RACE-BASE-r1', **kw):
    d = tempfile.mkdtemp(prefix='raceread_selftest_')
    for name, text in files.items():
        with open(os.path.join(d, name), 'w', encoding='utf-8') as fh:
            fh.write(text if text.endswith('\n') else text + '\n')
    args = argparse.Namespace(tag=kw.get('tag', tag), role=kw.get('role', 'fix'),
                              root_gate=kw.get('root_gate'), expect=kw.get('expect', {}),
                              expect_crash=kw.get('expect_crash', 'no'))
    cfg = load_config(None)
    if kw.get('config'):
        _merge_into(cfg, kw['config'])
    p = compile_config(cfg)
    res = judge(scan_run(d, p, cfg), p, cfg, args)
    res['_tmpdir'] = d
    return res


def _cleanup(res):
    shutil.rmtree(res.get('_tmpdir', ''), ignore_errors=True)


def _cli(files, extra=(), tag='RACE-CLI-r1'):
    """CLI 级回归助手：写临时 run 目录，真实调用 main([dir, tag]+extra+['--json'])。

    返回 {'rc': 退出码或 SystemExit.code, 'json': 解析后的 dict|None,
          'stdout': 原始 stdout, '_tmpdir': 临时目录}。argparse 非法值抛 SystemExit，
    在此捕获为 rc，交由用例断言（不污染 selftest 主流程）。只读、不编译、不跑 E2E。
    """
    d = tempfile.mkdtemp(prefix='raceread_cli_')
    for name, text in files.items():
        with open(os.path.join(d, name), 'w', encoding='utf-8') as fh:
            fh.write(text if text.endswith('\n') else text + '\n')
    buf, err = io.StringIO(), io.StringIO()
    rc = None
    try:
        with contextlib.redirect_stdout(buf), contextlib.redirect_stderr(err):
            rc = main([d, tag] + list(extra) + ['--json'])
    except SystemExit as e:
        rc = e.code
    out = buf.getvalue()
    try:
        parsed = json.loads(out)
    except (ValueError, TypeError):
        parsed = None
    return {'rc': rc, 'json': parsed, 'stdout': out, '_tmpdir': d}


def _gate_lines(root='1', rearm='1', nolang='0', resend='1', stress='0'):
    return ('setprop debug.mgbax.link.state_rearm_guard=%s readback=%s\n'
            'setprop debug.mgbax.link.no_lag_clear=%s readback=%s\n'
            'setprop debug.mgbax.link.seed_clean_resend=%s readback=%s\n'
            'setprop debug.mgbax.link.race_stress=%s readback=%s\n'
            % (rearm, rearm, nolang, nolang, resend, resend, stress, stress))


def _base(gate_readback=True, with_applied=True, with_stale=True, frm=4):
    app = []
    if gate_readback:
        app.append('11-20 10:00:01.100 6010 6010 I mGBA-App: '
                   '[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 '
                   '(enqueue + owner-thread frame-boundary load + gen token)')
    if with_applied:
        app.append('11-20 10:00:10.200 6038 6038 I mGBA-App: '
                   '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=1000 sha256=%s' % _SHA)
        app.append('11-20 10:00:10.201 6038 6038 I mGBA-App: '
                   '[ISYNC] TYPE_STATE remote state loaded 1000 bytes index=0 '
                   'mirrorSlot=2 hash=abc123 gen=7 applied_count=1')
    if with_stale:
        app.append('11-20 10:00:09.100 6038 6038 W mGBA-App: '
                   'SEED_DROPPED_STALE gen=5 current=7')
    app += ['11-20 10:00:1%d.000 6038 6038 I mGBA-App: '
            'FRM me=0 emuFps=59.7 frames=%d wall=100ms' % (i, 100 + i)
            for i in range(frm)]
    app.append('11-20 10:00:30.000 6038 6038 I mGBA-App: cb2=080B4845 BATTLE=YES')
    return {
        'app_link_startup.log': '\n'.join(app) + '\n',
        'pc_link.log': ('[ISYNC-EV][A1-SEND] role=PC path=x bytes=1000 sha256=%s\n' % _SHA),
        'avd_driver.log': ('PC env 显式覆盖: MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1\n'
                           + _gate_lines()),
        'summary.txt': 'tag=RACE-BASE-r1\nBATTLE=YES\n',
    }


def _tid_base(load_tid=None, anchor='gate', tag='RACE-TID-r1'):
    """合成 threadtime 样本：主线程 pid==tid==11232；load 里程碑 tid=load_tid。

    load_tid=None 表示里程碑无 threadtime 前缀（tid 不可观测）。
    anchor='gate' 用门回读行锚定；anchor='receiver' 用 BroadcastReceiver 行回退锚定。
    """
    app = []
    if anchor == 'gate':
        app.append('11-20 15:07:34.000 11232 11232 I mGBA: '
                   '[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 '
                   '(enqueue + owner-thread frame-boundary load + gen token)')
    elif anchor == 'receiver':
        app.append('11-20 15:07:34.000 11232 11232 I mGBA: '
                   'BroadcastReceiver onReceive: isync seed frame boundary enable')
    if load_tid is not None:
        p1 = '11-20 15:07:35.100 11232 %s I mGBA: ' % load_tid
        p2 = '11-20 15:07:35.200 11232 %s I mGBA: ' % load_tid
    else:
        p1 = p2 = ''  # 无 threadtime 前缀 => tid 不可解析
    app.append(p1 + '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=1000 sha256=%s' % _SHA)
    app.append(p2 + '[ISYNC] TYPE_STATE remote state loaded 1000 bytes index=0 '
                    'mirrorSlot=2 hash=abc123 gen=7 applied_count=1')
    app.append('11-20 15:07:36.100 11232 11232 W mGBA: '
               'SEED_DROPPED_STALE gen=5 current=7')
    app += ['11-20 15:07:3%d.000 11232 11232 I mGBA: '
            'FRM me=0 emuFps=59.7 frames=%d wall=100ms' % (i, 100 + i)
            for i in range(4)]
    app.append('11-20 15:07:40.000 11232 11232 I mGBA: cb2=080B4845 BATTLE=YES')
    return {
        'app_link_startup.log': '\n'.join(app) + '\n',
        'pc_link.log': '[ISYNC-EV][A1-SEND] role=PC path=x bytes=1000 sha256=%s\n' % _SHA,
        'avd_driver.log': ('PC env 显式覆盖: MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1\n'
                           + _gate_lines()),
        'summary.txt': 'tag=%s\nBATTLE=YES\n' % tag,
    }


def _multigen_base(tag='RACE-MULTIGEN-r1'):
    """合法多 gen 重灌：同 bytes/hash/slot，gen=1/2/4，applied_count=1/2/3，
    load tid 各不同且均≠主线程 11232（镜像线程每次重建换 tid）——复刻 RACETID r1。"""
    app = ['11-20 16:00:00.000 11232 11232 I mGBA: '
           '[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 '
           '(enqueue + owner-thread frame-boundary load + gen token)']
    for gen, cnt, tid in ((1, 1, '11437'), (2, 2, '11440'), (4, 3, '11457')):
        app.append('11-20 16:00:0%d.100 11232 %s I mGBA: '
                   '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=62480 sha256=%s'
                   % (gen, tid, _SHA))
        app.append('11-20 16:00:0%d.200 11232 %s I mGBA: '
                   '[ISYNC] TYPE_STATE remote state loaded 62480 bytes index=0 '
                   'mirrorSlot=2 hash=abc123 gen=%d applied_count=%d'
                   % (gen, tid, gen, cnt))
    app.append('11-20 16:00:09.100 11232 11232 W mGBA: '
               'SEED_DROPPED_STALE gen=0 current=5')
    app += ['11-20 16:00:1%d.000 11232 11232 I mGBA: '
            'FRM me=0 emuFps=59.7 frames=%d wall=100ms' % (i, 100 + i)
            for i in range(4)]
    app.append('11-20 16:00:20.000 11232 11232 I mGBA: cb2=080B4845 BATTLE=YES')
    return {
        'app_link_startup.log': '\n'.join(app) + '\n',
        'pc_link.log': '[ISYNC-EV][A1-SEND] role=PC path=x bytes=62480 sha256=%s\n' % _SHA,
        'avd_driver.log': ('PC env 显式覆盖: MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1\n'
                           + _gate_lines()),
        'summary.txt': 'tag=%s\nBATTLE=YES\n' % tag,
    }


def _genstall_base(tag='RACE-GENSTALL-r1'):
    """模拟 A 轮：同 hash 连续重灌 + gen 停滞（gen=1/4/4/4，ac=1/2/3/4，
    tid 9936/9943×3），4 条真 load 全在镜像线程（≠主线程 11232）、串行、零崩溃、
    无同 gen 跨 tid 并发。用于验证 W69 判据盲区修复，不代表真实竞态已根治。"""
    app = ['11-20 19:22:44.000 11232 11232 I mGBA: '
           '[ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 '
           '(enqueue + owner-thread frame-boundary load + gen token)']
    for gen, cnt, tid, sec in ((1, 1, '9936', '35'),
                               (4, 2, '9943', '39'),
                               (4, 3, '9943', '40'),
                               (4, 4, '9943', '44')):
        app.append('11-20 19:23:%s.100 11232 %s I mGBA: '
                   '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=44001 sha256=%s'
                   % (sec, tid, _SHA))
        app.append('11-20 19:23:%s.200 11232 %s I mGBA: '
                   '[ISYNC] TYPE_STATE remote state loaded 44001 bytes index=0 '
                   'mirrorSlot=2 hash=abc123 gen=%d applied_count=%d'
                   % (sec, tid, gen, cnt))
    app.append('11-20 19:23:45.100 11232 11232 W mGBA: '
               'SEED_DROPPED_STALE gen=2 current=5')
    app += ['11-20 19:23:%d.000 11232 11232 I mGBA: '
            'FRM me=0 emuFps=59.7 frames=%d wall=100ms' % (45 + i, 100 + i)
            for i in range(4)]
    app.append('11-20 19:24:00.000 11232 11232 I mGBA: cb2=080B4845 BATTLE=YES')
    return {
        'app_link_startup.log': '\n'.join(app) + '\n',
        'pc_link.log': '[ISYNC-EV][A1-SEND] role=PC path=x bytes=44001 sha256=%s\n' % _SHA,
        'avd_driver.log': ('PC env 显式覆盖: MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1\n'
                           + _gate_lines()),
        'summary.txt': 'tag=%s\nBATTLE=YES\n' % tag,
    }


def _selftest():
    passed, total = 0, 0
    results = []

    def check(name, cond):
        nonlocal passed, total
        total += 1
        if cond:
            passed += 1
            print('SELFTEST PASS: ' + name)
        else:
            print('SELFTEST FAIL: ' + name)

    # (1) 全绿 fix 轮
    r = _run(_base())
    results.append(r)
    check('(1) 全绿：OVERALL=PASS', r['OVERALL'] == 'PASS')
    check('(1) RACE_GATE_ACTIVE=PASS', r['RACE_GATE_ACTIVE'] == 'PASS')
    check('(1) APPLIED_UNIQUE=PASS', r['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS')
    check('(1) STALE_SEMANTICS=PASS', r['CHECKS']['STALE_SEMANTICS']['status'] == 'PASS')
    check('(1) MIRRORLOOP_ALIVE=PASS', r['CHECKS']['MIRRORLOOP_ALIVE']['status'] == 'PASS')
    check('(1) NO_LAG_CLEAR=0 触发灰区标注', r['GRAY_OR_STRESS'] is True)
    check('(1) BATTLE_WINDOW 观察 PASS 但总门非成功裁决',
          r['CHECKS']['BATTLE_WINDOW']['status'] == 'PASS' and 'FAIL/0/9' in fmt(r))

    # (2) 根治门 readback 缺失（仅 driver setprop）→ 降级
    f = _base(gate_readback=False)
    r2 = _run(f)
    results.append(r2)
    check('(2) 无 app 回读 => RACE_GATE_ACTIVE=UNOBSERVED', r2['RACE_GATE_ACTIVE'] == 'UNOBSERVED')
    check('(2) 下游 APPLIED_UNIQUE 降级 UNOBSERVED',
          r2['CHECKS']['APPLIED_UNIQUE']['status'] == 'UNOBSERVED')
    check('(2) OVERALL=UNOBSERVED', r2['OVERALL'] == 'UNOBSERVED')

    # (3) app 回读门=0 但期望 1 → FAIL
    f = _base()
    f['app_link_startup.log'] = f['app_link_startup.log'].replace(
        'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1', 'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=0')
    r3 = _run(f)
    results.append(r3)
    check('(3) 门=0 期望1 => ROOT_GATE FAIL', r3['RACE_GATE_ACTIVE'] == 'FAIL')
    check('(3) OVERALL=FAIL', r3['OVERALL'] == 'FAIL')

    # (4) 崩溃（Fatal11 + mCoreLoadStateNamed 栈帧）
    f = _base()
    f['app_link_startup.log'] += ('\n11-20 10:00:20.000 6010 6010 F mGBA-App: '
                                  'Fatal signal 11 (SIGSEGV), fault addr 0x0\n'
                                  '#05 pc 0000000000400000  (mCoreLoadStateNamed)\n')
    r4 = _run(f)
    results.append(r4)
    check('(4) Fatal11+mCoreLoadStateNamed => NO_CRASH=FAIL',
          r4['CHECKS']['NO_CRASH']['status'] == 'FAIL')
    check('(4) OVERALL=FAIL', r4['OVERALL'] == 'FAIL')

    # (5) CRASH5 双 apply：同 bytes/hash 两条、不同 tid、applied_count=2 + 崩溃
    f = _base()
    lines = f['app_link_startup.log'].split('\n')
    ins = ('11-20 10:00:12.000 6010 6010 I mGBA-App: '
           '[ISYNC] TYPE_STATE remote state loaded 1000 bytes index=0 mirrorSlot=2 '
           'hash=abc123 gen=7 applied_count=2')
    lines.insert(3, ins)
    f['app_link_startup.log'] = '\n'.join(lines)
    f['app_link_startup.log'] += ('\n11-20 10:00:20.000 6010 6010 F mGBA-App: '
                                  'Fatal signal 11 (SIGSEGV)\n')
    r5 = _run(f)
    results.append(r5)
    check('(5) 双 apply => APPLIED_UNIQUE=FAIL',
          r5['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')
    check('(5) 双 apply+崩溃 => CRASH5_IRONCLAD=True', r5['CRASH5_IRONCLAD'] is True)

    # (6) driver state_sync= 注释载体不算 applied
    f = _base(with_applied=False)
    f['avd_driver.log'] += ('[10:00:xx] [PATHB] state_sync=loaded  # TYPE_STATE/'
                            'remote state loaded 的假阳性载体\n')
    r6 = _run(f)
    results.append(r6)
    check('(6) state_sync= 载体不算 applied => UNOBSERVED',
          r6['CHECKS']['APPLIED_UNIQUE']['status'] == 'UNOBSERVED')

    # (7) stale 误丢合法：gen==current（且等于 applied gen）
    f = _base()
    f['app_link_startup.log'] = f['app_link_startup.log'].replace(
        'SEED_DROPPED_STALE gen=5 current=7', 'SEED_DROPPED_STALE gen=7 current=7')
    r7 = _run(f)
    results.append(r7)
    check('(7) stale gen==current => STALE_SEMANTICS=FAIL',
          r7['CHECKS']['STALE_SEMANTICS']['status'] == 'FAIL')

    # (8) 真 stale（gen<current）不误丢
    r8 = _run(_base())
    results.append(r8)
    check('(8) 真 stale => STALE_SEMANTICS=PASS',
          r8['CHECKS']['STALE_SEMANTICS']['status'] == 'PASS')

    # (9) 两个不同 seed 各一次 applied → 不误判双 apply
    f = _base()
    f['app_link_startup.log'] += ('\n11-20 10:00:13.000 6038 6038 I mGBA-App: '
                                  '[ISYNC] TYPE_STATE remote state loaded 2000 bytes '
                                  'index=0 mirrorSlot=2 hash=def456 gen=8 applied_count=1\n'
                                  '11-20 10:00:13.100 6038 6038 I mGBA-App: '
                                  '[ISYNC-EV][A1-LAND] role=APP slot=2 bytes=2000 sha256=%s'
                                  % _SHA2)
    f['pc_link.log'] += ('[ISYNC-EV][A1-SEND] role=PC path=y bytes=2000 sha256=%s\n' % _SHA2)
    r9 = _run(f)
    results.append(r9)
    check('(9) 不同(字节,sha)两包各一次 => APPLIED_UNIQUE=PASS（不误判双灌）',
          r9['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS')

    # (10) tag 不符
    r10 = _run(_base(), tag='RACE-WIN-A')
    results.append(r10)
    check('(10) tag 不符 => TAG_MATCH=FAIL', r10['CHECKS']['TAG_MATCH']['status'] == 'FAIL')

    # (11) 门值漂移 STATE_REARM_GUARD 同时 1/0
    f = _base()
    f['avd_driver.log'] += 'setprop debug.mgbax.link.state_rearm_guard=0 readback=0\n'
    r11 = _run(f)
    results.append(r11)
    check('(11) STATE_REARM_GUARD 漂移 => GATE_DIRECTIONS=FAIL',
          r11['CHECKS']['GATE_DIRECTIONS']['status'] == 'FAIL')

    # (12) FRM 不足 → UNOBSERVED
    r12 = _run(_base(frm=1))
    results.append(r12)
    check('(12) FRM<3 => MIRRORLOOP_ALIVE=UNOBSERVED',
          r12['CHECKS']['MIRRORLOOP_ALIVE']['status'] == 'UNOBSERVED')

    # (13) control 轮：门关 + 崩溃复现 => 判据全绿（INVALID 不触发）
    f = _base(gate_readback=False, with_applied=False, with_stale=False)
    f['app_link_startup.log'] += ('\n11-20 10:00:20.000 6010 6010 F mGBA-App: '
                                  'Fatal signal 11 (SIGSEGV)\n')
    f['avd_driver.log'] = f['avd_driver.log'].replace(
        'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1', 'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=0')
    f['summary.txt'] = 'tag=RACE-WIN-B\n'
    r13 = _run(f, tag='RACE-WIN-B', role='control', expect_crash='yes')
    results.append(r13)
    check('(13) control 门关+复现崩溃 => OVERALL=PASS(对照有效)',
          r13['OVERALL'] == 'PASS' and r13['CHECKS']['CRASH_REPRODUCED']['status'] == 'PASS')

    # (14) control 不复现 → INVALID
    f = _base(gate_readback=False, with_applied=False, with_stale=False)
    f['avd_driver.log'] = f['avd_driver.log'].replace(
        'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1', 'MGBAX_ISYNC_SEED_FRAME_BOUNDARY=0')
    f['summary.txt'] = 'tag=RACE-WIN-B\n'
    r14 = _run(f, tag='RACE-WIN-B', role='control', expect_crash='yes')
    results.append(r14)
    check('(14) control 不复现 => OVERALL=INVALID',
          r14['OVERALL'] == 'INVALID')

    # (15) applied 缺字段（无 applied_count）→ fail-closed UNOBSERVED
    f = _base()
    f['app_link_startup.log'] = f['app_link_startup.log'].replace(
        'hash=abc123 gen=7 applied_count=1', 'hash=abc123 gen=7')
    r15 = _run(f)
    results.append(r15)
    check('(15) applied 缺 applied_count => UNOBSERVED',
          r15['CHECKS']['APPLIED_UNIQUE']['status'] == 'UNOBSERVED')

    # (16) 可配置 pattern：新增 root_gate_strong 命中即 PASS
    f = _base(gate_readback=False)
    cfg = {'patterns': {'root_gate_strong': [r'RACEREAD_TEST_GATE_ON=(\d)']}}
    f['app_link_startup.log'] += '\nRACEREAD_TEST_GATE_ON=1 (自定义门回读)\n'
    r16 = _run(f, config=cfg)
    results.append(r16)
    check('(16) --config 自定义强 pattern => RACE_GATE_ACTIVE=PASS',
          r16['RACE_GATE_ACTIVE'] == 'PASS')

    # (17) A 轮对照：load 全在主线程（tid==pid==11232）=> FAIL
    r17 = _run(_tid_base(load_tid='11232'), tag='RACE-TID-r1')
    results.append(r17)
    check('(17) A轮对照 load tid==main_tid => MAIN_THREAD_LOAD_ZERO=FAIL',
          r17['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'FAIL')
    check('(17) 主线程 load => OVERALL=FAIL', r17['OVERALL'] == 'FAIL')

    # (18) 根治后：load tid=11437 ≠ main_tid=11232 => PASS
    r18 = _run(_tid_base(load_tid='11437'), tag='RACE-TID-r1')
    results.append(r18)
    check('(18) 根治后 load tid≠main_tid => MAIN_THREAD_LOAD_ZERO=PASS',
          r18['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'PASS')
    check('(18) MAIN_TID_ANCHOR=11232', r18['MAIN_TID_ANCHOR'] == '11232')
    check('(18) 主线程零 load => OVERALL=PASS', r18['OVERALL'] == 'PASS')

    # (19) tid 不可观测：load 里程碑无 threadtime 前缀 => UNOBSERVED（退回宽窗压测）
    r19 = _run(_tid_base(load_tid=None), tag='RACE-TID-r1')
    results.append(r19)
    check('(19) load tid 不可解析 => MAIN_THREAD_LOAD_ZERO=UNOBSERVED',
          r19['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'UNOBSERVED')
    check('(19) UNOBSERVED => OVERALL=UNOBSERVED 且报告要求宽窗压测',
          r19['OVERALL'] == 'UNOBSERVED' and any('宽窗压测' in n for n in r19['NOTES']))

    # (20) peer state loaded 在主线程也算 load 里程碑 => FAIL
    f20 = _tid_base(load_tid='11437')
    f20['app_link_startup.log'] += ('\n11-20 15:07:38.000 11232 11232 I mGBA: '
                                    '[ISYNC] peer state loaded 1000 bytes\n')
    r20 = _run(f20, tag='RACE-TID-r1')
    results.append(r20)
    check('(20) peer state loaded tid==main_tid => MAIN_THREAD_LOAD_ZERO=FAIL',
          r20['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'FAIL')

    # (21) BroadcastReceiver 行回退锚定主线程 tid
    r21 = _run(_tid_base(load_tid='11437', anchor='receiver'), tag='RACE-TID-r1')
    results.append(r21)
    check('(21) BroadcastReceiver 锚点 + load tid≠主线程 => MAIN_THREAD_LOAD_ZERO=PASS',
          r21['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'PASS'
          and r21['MAIN_TID_ANCHOR'] == '11232')

    # (22) 合成优先级：主线程 load=FAIL 且 stale=UNOBSERVED => OVERALL 仍 FAIL
    f22 = _tid_base(load_tid='11232')
    f22['app_link_startup.log'] = '\n'.join(
        ln for ln in f22['app_link_startup.log'].split('\n')
        if 'SEED_DROPPED_STALE' not in ln)
    r22 = _run(f22, tag='RACE-TID-r1')
    results.append(r22)
    check('(22) FAIL > UNOBSERVED 合成 => OVERALL=FAIL',
          r22['CHECKS']['STALE_SEMANTICS']['status'] == 'UNOBSERVED'
          and r22['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'FAIL'
          and r22['OVERALL'] == 'FAIL')

    # (23) 合法多 gen 重灌（同 hash/gen 递增/applied_count 递增/不同 tid）=> PASS
    r23 = _run(_multigen_base(), tag='RACE-MULTIGEN-r1')
    results.append(r23)
    check('(23) 合法多 gen 重灌 => APPLIED_UNIQUE=PASS（不再误判双灌）',
          r23['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS'
          and r23['COUNTS']['applied'] == 3)
    check('(23) 且 OVERALL=PASS', r23['OVERALL'] == 'PASS')

    # (24) 真双灌：同 gen+hash+applied_count 跨 tid（主线程崩+重建线程再灌）=> FAIL + CRASH5
    f24 = _multigen_base()
    ins = ('11-20 16:00:01.250 11232 11232 I mGBA: '
           '[ISYNC] TYPE_STATE remote state loaded 62480 bytes index=0 '
           'mirrorSlot=2 hash=abc123 gen=2 applied_count=2')
    lines = f24['app_link_startup.log'].split('\n')
    idx = next(i for i, ln in enumerate(lines) if 'gen=2 applied_count=2' in ln)
    lines.insert(idx + 1, ins)
    f24['app_link_startup.log'] = '\n'.join(lines) + (
        '\n11-20 16:00:25.000 11232 11232 F mGBA: Fatal signal 11 (SIGSEGV)\n')
    r24 = _run(f24, tag='RACE-MULTIGEN-r1')
    results.append(r24)
    check('(24) 同gen跨tid双灌 => APPLIED_UNIQUE=FAIL',
          r24['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')
    check('(24) 双灌+崩溃 => CRASH5_IRONCLAD=True', r24['CRASH5_IRONCLAD'] is True)
    check('(24) OVERALL=FAIL', r24['OVERALL'] == 'FAIL')

    # (25) 同 hash 不同 gen 即使同 tid 也 PASS —— 证明按 gen 而非按 tid 分组
    f25 = _multigen_base()
    f25['app_link_startup.log'] = (f25['app_link_startup.log']
                                   .replace('11440', '11437').replace('11457', '11437'))
    r25 = _run(f25, tag='RACE-MULTIGEN-r1')
    results.append(r25)
    check('(25) 同hash不同gen同tid => APPLIED_UNIQUE=PASS',
          r25['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS')

    # (26) 跨文件重复同一事件（复刻 r2）：app_link_startup.log 与
    #      app_logcat_full.log 是同一运行两路抓取、逐字相同 => 6 条折叠为 3 条
    f26 = _multigen_base()
    f26['app_logcat_full.log'] = f26['app_link_startup.log']
    r26 = _run(f26, tag='RACE-MULTIGEN-r1')
    results.append(r26)
    check('(26) 跨文件重复同一事件 => APPLIED_UNIQUE=PASS',
          r26['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS')
    check('(26) applied_raw=6 / 去重后=3 / 折叠=3',
          r26['COUNTS']['applied_raw'] == 6 and r26['COUNTS']['applied'] == 3
          and r26['COUNTS']['applied_dup_collapsed'] == 3)
    check('(26) 去重后 OVERALL=PASS', r26['OVERALL'] == 'PASS')

    # (27) 真同gen跨tid双灌，且两路抓取各自重复 => 去重后仍须 FAIL（去重不得掩盖真 bug）
    f27 = _multigen_base()
    ins27 = ('11-20 16:00:02.250 11232 11232 I mGBA: '
             '[ISYNC] TYPE_STATE remote state loaded 62480 bytes index=0 '
             'mirrorSlot=2 hash=abc123 gen=2 applied_count=2')
    lines27 = f27['app_link_startup.log'].split('\n')
    idx27 = next(i for i, ln in enumerate(lines27) if 'gen=2 applied_count=2' in ln)
    lines27.insert(idx27 + 1, ins27)
    f27['app_link_startup.log'] = '\n'.join(lines27)
    f27['app_logcat_full.log'] = f27['app_link_startup.log']
    f27['app_link_startup.log'] += ('\n11-20 16:00:25.000 11232 11232 F mGBA: '
                                    'Fatal signal 11 (SIGSEGV)\n')
    f27['app_logcat_full.log'] = f27['app_link_startup.log']
    r27 = _run(f27, tag='RACE-MULTIGEN-r1')
    results.append(r27)
    check('(27) 真同gen跨tid双灌(且跨文件重复) => APPLIED_UNIQUE=FAIL',
          r27['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')
    check('(27) 双灌+崩溃 => CRASH5_IRONCLAD=True 且 OVERALL=FAIL',
          r27['CRASH5_IRONCLAD'] is True and r27['OVERALL'] == 'FAIL')

    # (28) 同 gen 同 tid 但不同毫秒时间戳 => 两条独立事件，不折叠 => FAIL
    #      证明去重键含毫秒时间戳，不是「按 gen 唯一」（后者会抹掉 CRASH5 信号）
    f28 = _multigen_base()
    ins28 = ('11-20 16:00:02.250 11232 11440 I mGBA: '
             '[ISYNC] TYPE_STATE remote state loaded 62480 bytes index=0 '
             'mirrorSlot=2 hash=abc123 gen=2 applied_count=2')
    lines28 = f28['app_link_startup.log'].split('\n')
    idx28 = next(i for i, ln in enumerate(lines28) if 'gen=2 applied_count=2' in ln)
    lines28.insert(idx28 + 1, ins28)
    f28['app_link_startup.log'] = '\n'.join(lines28)
    r28 = _run(f28, tag='RACE-MULTIGEN-r1')
    results.append(r28)
    check('(28) 同gen同tid不同毫秒时间戳不折叠 => APPLIED_UNIQUE=FAIL',
          r28['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')

    # ---- W69：gen 停滞 + 全局 applied_count 递增的判据盲区修复（只读 selftest，不改门状态）----
    # (39) A 轮形态：同 hash 同 gen 同 tid 串行、ac 递增、镜像线程、零崩溃 => PASS
    r39 = _run(_genstall_base(), tag='RACE-GENSTALL-r1')
    results.append(r39)
    check('(39) A轮形态 gen停滞+ac递增+同tid串行 => APPLIED_UNIQUE=PASS',
          r39['CHECKS']['APPLIED_UNIQUE']['status'] == 'PASS'
          and r39['COUNTS']['applied'] == 4)
    check('(39) 且 MAIN_THREAD_LOAD_ZERO=PASS / NO_CRASH=PASS',
          r39['CHECKS']['MAIN_THREAD_LOAD_ZERO']['status'] == 'PASS'
          and r39['CHECKS']['NO_CRASH']['status'] == 'PASS')

    # (40) 同 hash 同 gen 跨 tid 并发 => FAIL（不删真双灌灵敏度）
    f40 = _genstall_base()
    ins40 = ('11-20 19:23:39.250 11232 9950 I mGBA: '
             '[ISYNC] TYPE_STATE remote state loaded 44001 bytes index=0 '
             'mirrorSlot=2 hash=abc123 gen=4 applied_count=5')
    lines40 = f40['app_link_startup.log'].split('\n')
    idx40 = next(i for i, ln in enumerate(lines40) if 'gen=4 applied_count=2' in ln)
    lines40.insert(idx40 + 1, ins40)
    f40['app_link_startup.log'] = '\n'.join(lines40)
    r40 = _run(f40, tag='RACE-GENSTALL-r1')
    results.append(r40)
    check('(40) 同hash同gen跨tid并发 => APPLIED_UNIQUE=FAIL（灵敏度不删）',
          r40['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')

    # (41) gen 停滞 + ac 递增 + 主线程 load => FAIL（CRASH5 主线程形态）
    f41 = _genstall_base()
    f41['app_link_startup.log'] = f41['app_link_startup.log'].replace(
        '19:23:40.200 11232 9943', '19:23:40.200 11232 11232')
    r41 = _run(f41, tag='RACE-GENSTALL-r1')
    results.append(r41)
    check('(41) gen停滞+ac递增+主线程load => APPLIED_UNIQUE=FAIL',
          r41['CHECKS']['APPLIED_UNIQUE']['status'] == 'FAIL')

    # ---- NOCRASH2：崩溃证据按进程归属过滤（r4 假阳性回归）----
    # (29) Google QuickSearchBox 缓存回收的 'has died' 不算 app 崩溃（r4 实测噪声）
    noise = ('11-20 17:19:55.907   519  1888 I ActivityManager: Process '
             'com.google.android.googlequicksearchbox:search (pid 1501) has died: cch CACC\n')
    f29 = _base()
    f29['app_link_startup.log'] += '\n' + noise
    f29['app_logcat_full.log'] = noise  # 重复抓取（r4 两条 CRASH_SAMPLES 同源）
    r29 = _run(f29)
    results.append(r29)
    check('(29) com.google has died => NO_CRASH=PASS',
          r29['CHECKS']['NO_CRASH']['status'] == 'PASS')
    check('(29) 噪声排除(crash=0/rejected>=2)',
          r29['COUNTS']['crash'] == 0 and r29['COUNTS']['crash_rejected'] >= 2)
    check('(29) app_pid 由门回读行锚定=6010', r29['COUNTS']['app_pid'] == '6010')

    # (30) 真崩溃：io.mgba.android Fatal signal 11 必须 FAIL（不放松灵敏度）
    f30 = _base()
    f30['app_link_startup.log'] += ('\n11-20 17:20:20.000  6010 6010 F DEBUG: '
                                    'Fatal signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), '
                                    'fault addr 0x0 in tid 6010, pid 6010 (io.mgba.android)\n')
    r30 = _run(f30)
    results.append(r30)
    check('(30) io.mgba.android Fatal signal 11 => NO_CRASH=FAIL',
          r30['CHECKS']['NO_CRASH']['status'] == 'FAIL')

    # (31) io.mgba.android 的 'has died' 必须计入（真 app 死亡）
    f31 = _base()
    f31['app_link_startup.log'] += ('\n11-20 17:20:21.000   519  1888 I ActivityManager: '
                                    'Process io.mgba.android (pid 6010) has died: cch CACC\n')
    r31 = _run(f31)
    results.append(r31)
    check('(31) io.mgba.android has died => NO_CRASH=FAIL',
          r31['CHECKS']['NO_CRASH']['status'] == 'FAIL')

    # (32) fail-safe：app pid 不可锚定 + 无名字的 'has died' => 一律不计
    f32 = _base(gate_readback=False)
    f32['app_link_startup.log'] += ('\nActivityManager: Process 10042:remote (pid 9999) '
                                    'has died: cch CACC\n')
    r32 = _run(f32)
    results.append(r32)
    check('(32) app pid 未知 + has died => NO_CRASH=PASS(fail-safe)',
          r32['CHECKS']['NO_CRASH']['status'] == 'PASS'
          and r32['COUNTS']['crash_rejected'] >= 1)

    # (33) fail-safe 不放松铁证：app pid 不可锚定 + Fatal11 仍计崩溃
    f33 = _base(gate_readback=False)
    f33['app_link_startup.log'] += '\nFatal signal 11 (SIGSEGV), fault addr 0x0\n'
    r33 = _run(f33)
    results.append(r33)
    check('(33) app pid 未知 + Fatal11 => NO_CRASH=FAIL(灵敏度保持)',
          r33['CHECKS']['NO_CRASH']['status'] == 'FAIL')

    # (34) 铁证明确归属他进程（无 app pid）=> 不计，避免张冠李戴
    f34 = _base(gate_readback=False)
    f34['app_link_startup.log'] += ('\nFatal signal 11 (SIGSEGV) in pid 1501 '
                                    '(com.google.android.googlequicksearchbox)\n')
    r34 = _run(f34)
    results.append(r34)
    check('(34) 铁证归属 com.google => NO_CRASH=PASS',
          r34['CHECKS']['NO_CRASH']['status'] == 'PASS')

    # ---- CLI 级回归（覆盖 main() 的 argparse / expect 回填，_run 直调 judge 覆盖不到）----
    # (35) BUG-A：--expect 漂移必须 FAIL（main 必须把 expect dict 回填 args.expect）
    r35 = _cli(_base(), extra=['--expect', 'NO_LAG_CLEAR=1'], tag='RACE-BASE-r1')
    results.append(r35)
    check('(35) CLI --expect 漂移 => GATE_DIRECTIONS=FAIL 且 OVERALL=FAIL(rc=1)',
          r35['json'] is not None and r35['rc'] == 1
          and r35['json']['CHECKS']['GATE_DIRECTIONS']['status'] == 'FAIL'
          and r35['json']['OVERALL'] == 'FAIL')

    # (36) BUG-B：--root-gate 0/1 不再因 str/int 比较误判或崩溃
    r36a = _cli(_base(), extra=['--root-gate', '1'], tag='RACE-BASE-r1')
    r36b = _cli(_base(), extra=['--root-gate', '0'], tag='RACE-BASE-r1')
    results.append(r36a); results.append(r36b)
    check('(36) CLI --root-gate 0/1 均可正常判读（int 比较，不再 str/int 误判或崩溃）',
          r36a['json'] is not None and r36a['rc'] in (0, 1)
          and r36a['json']['RACE_GATE_ACTIVE'] == 'PASS'
          and r36b['json'] is not None and r36b['rc'] in (0, 1)
          and r36b['json']['RACE_GATE_ACTIVE'] == 'FAIL')

    # (37) 非法 --root-gate 必须由 argparse 拒绝（SystemExit 2），不得进入判读
    r37 = _cli(_base(), extra=['--root-gate', '2'], tag='RACE-BASE-r1')
    results.append(r37)
    check('(37) CLI --root-gate 2 => 退出码 2 且不产出 JSON',
          r37['rc'] == 2 and r37['json'] is None)

    # (38) 灰区数值化 + 文案数据驱动：仅 RACE_STRESS=300（NO_LAG_CLEAR=1）也须灰区标注
    f38 = _base()
    f38['avd_driver.log'] = f38['avd_driver.log'].replace(
        'no_lag_clear=0 readback=0', 'no_lag_clear=1 readback=1').replace(
        'race_stress=0 readback=0', 'race_stress=300 readback=300')
    r38 = _cli(f38, tag='RACE-BASE-r1')
    results.append(r38)
    check('(38) RACE_STRESS=300 单独触发灰区，文案显示 300 而非硬编码 1',
          r38['json'] is not None and r38['json'].get('GRAY_OR_STRESS') is True
          and r38['json']['GATES_OBSERVED'].get('NO_LAG_CLEAR') == '1'
          and '灰区/压测标注：NO_LAG_CLEAR=1 或 RACE_STRESS=300 =>' in r38['stdout']
          and 'RACE_STRESS=1 =>' not in r38['stdout'])

    for r in results:
        _cleanup(r)
    print('SELFTEST_SUMMARY: %d/%d passed' % (passed, total))
    return 0 if passed == total else 1


def main(argv=None):
    # Windows 控制台常见 GBK：强制 UTF-8 输出，避免中文/符号触发 UnicodeEncodeError。
    try:
        sys.stdout.reconfigure(encoding='utf-8', errors='replace')
    except (AttributeError, ValueError):
        pass
    ap = argparse.ArgumentParser(
        description='RACEREAD 根治门+竞态修复证据机械判读（只读，非成功裁决）')
    ap.add_argument('run_dir', nargs='?', help='压测轮产物目录')
    ap.add_argument('tag', nargs='?', help='本轮 tag（与 summary tag 核对）')
    ap.add_argument('--json', action='store_true', help='输出 JSON')
    ap.add_argument('--config', help='JSON 配置覆盖 pattern/fields（list plain=追加，$set=替换）')
    ap.add_argument('--gate-pattern', action='append', default=[],
                    help='追加一条根治门强回读正则（可多次）')
    ap.add_argument('--expect', action='append', default=[], metavar='KEY=VAL',
                    help='断言门方向，如 --expect NO_LAG_CLEAR=1（可多次）')
    ap.add_argument('--role', choices=('fix', 'control'), default='fix',
                    help='fix=修复轮（默认，期望不崩）；control=因果对照轮（期望门关+复现）')
    ap.add_argument('--expect-crash', choices=('no', 'yes'), default='no',
                    help='control 轮用 yes：要求复现崩溃/双灌，否则 INVALID')
    # BUG-B 修复：argparse 原返回 str '0'/'1'，root_strong 门值是 int，
    # judge() 中 vals[0] == expect_root 恒 False（传 --root-gate 必误判）。改为 type=int。
    ap.add_argument('--root-gate', type=int, choices=(0, 1), default=None,
                    help='覆盖根治门期望值（默认 fix=1 / control=0）')
    ap.add_argument('--frm-min', type=int, default=None,
                    help='mirrorLoop 存活所需 FRM 行数阈值（默认取配置）')
    ap.add_argument('--selftest', action='store_true', help='合成日志自测（只写系统 temp）')
    args = ap.parse_args(argv)

    if args.selftest:
        return _selftest()
    if not args.run_dir or not args.tag:
        ap.error('需要 <run目录> <tag>，或使用 --selftest')
    if not os.path.isdir(args.run_dir):
        print('ERROR: run 目录不存在: %s' % args.run_dir)
        return 2

    try:
        cfg = load_config(args.config)
    except (OSError, ValueError, json.JSONDecodeError) as e:
        print('ERROR: --config 载入失败: %s' % e)
        return 2
    if args.gate_pattern:
        cfg['patterns']['root_gate_strong'] = (cfg['patterns']['root_gate_strong']
                                               + args.gate_pattern)
    if args.frm_min is not None:
        if args.frm_min < 1:
            print('ERROR: --frm-min 必须 >= 1')
            return 2
        cfg['frm_min'] = args.frm_min
    expect = {}
    for item in args.expect:
        if '=' not in item:
            print('ERROR: --expect 格式应为 KEY=VAL: %s' % item)
            return 2
        k, v = item.split('=', 1)
        expect[k.strip().upper()] = v.strip()
    # BUG-A 修复：judge() 按 dict 读 args.expect（g in args.expect / args.expect[g]），
    # 此前只构造局部 expect、未回填，--expect 被静默忽略。必须回填同一命名空间。
    args.expect = expect

    try:
        p = compile_config(cfg)
    except re.error as e:
        print('ERROR: pattern 正则非法: %s' % e)
        return 2

    # judge() 用 Namespace 的字段，复用同一命名空间（补 expect/root_gate/role 已在其中）
    res = judge(scan_run(args.run_dir, p, cfg), p, cfg, args)
    if args.json:
        print(json.dumps(res, ensure_ascii=False, indent=2))
    else:
        print(fmt(res))
    if res['OVERALL'] == 'PASS':
        return 0  # 注意：仅判据全绿，总门仍 FAIL/0/9
    return 1


if __name__ == '__main__':
    sys.exit(main())
