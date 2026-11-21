#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""M1ROOM — APP_ROOM_BUILT 前置门离线判读脚本（只读，不编译、不跑 E2E、不写产物）。

用法：
    python tools/isync_room_check.py <run目录> [tag] [--json]
    python tools/isync_room_check.py --selftest

背景（M1NEW 实证）：8 个历史 path B 轮的 APP 侧 consoleSet 从未创建；BOOTSTRAP
一行修复（commit 7c2ef2816）后首次真正双端。为防止 `[C0-GATE] ACCEPT` 这类空值
误判 PASS，M1NEW 要求给 CROSSED 加「APP 房间建成」前置门。本脚本固化该前置门。

判据（APP 房间建成的可观测指纹，M1V3/ISYNC31 口径）——五项全部命中且值合法才 PASS：
  1. SESSION_OK        `cloud link session=ok cloud=set`  (EmulatorActivity.java:2285, startGBoyLink 入口)
  2. SNAPSHOT_PATH     `save snapshot path=<绝对路径> ...` (GBoyConsoleSet.java:222, 不为空/null)
  3. ARM_REBUILT       `cloud arm: N-core room rebuilt ...` (EmulatorActivity.java:2771)
  4. ARM_RELEASED      `cloud arm released: frames unlocked` (EmulatorActivity.java:2781)
  5. BOOT_BOOL         `[ISYNC-EV][BOOT] ... hasCurrent=1 ... pathResolved=1 ... coreReady/coreLoaded=1`
                       （BOOTSTRAP 新增；接受 coreReady=1 与 coreLoaded=1 两种写法）

判读纪律（与 isync_applied_check.py 对齐）：
  * 逐文件读取日志（>1MB 大日志也逐行扫，绝不用目录级 grep 漏报）；仅文本类日志，
    二进制（.gba/.sav/.png/...）一律不读；单文件 >256MB 不读并在报告声明 UNOBSERVED。
  * 负向变体（`session=NULL` / `cloud=null` / `save snapshot path=null` /
    `cloud arm: rebuild failed` / BOOT 布尔=0）是「房间未建成」的正向证据：
    对应正向指纹缺失且有负向变体 → FAIL；全缺且无负向 → UNOBSERVED。
  * 反向诊断：若出现 `[C0-GATE] ACCEPT` 但五项指纹不全 → 房间仍未建、一行修复未命中，
    明确写进 notes，绝不因此判 PASS。
  * tag 与 summary.txt 不一致 → fail-closed 降 UNOBSERVED（可能拿错 artifact）。
  * 字段缺失一律 UNOBSERVED；不伪造、不预设成功。

门语义（前置门，不是成功证据）：
  * APP_ROOM_BUILT=PASS 才允许下游 applied/CROSSED 判读；
  * APP_ROOM_BUILT=FAIL/UNOBSERVED 时，下游一律 UNOBSERVED（不 PASS、不 FAIL）。
  * 本门必要非充分：门 PASS 不升级总门；对手真实性仍只由零注入 diff_party_check 的
    CROSSED（APP 框 0006 ↔ PC 框 00D5）唯一裁决；门维持 FAIL / 0/9。
  * 标记 `downstream_allowed = (APP_ROOM_BUILT == 'PASS')` 供整合方直接读取。
  中文，不伪造，不预设成功；红线禁造假。
"""

import argparse
import json
import os
import re
import shutil
import sys
import tempfile

TEXT_EXTS = ('.log', '.txt', '.out')
MAX_FILE_BYTES = 256 * 1024 * 1024

# 五项指纹：positive 必须全中；negative 是「明确未建成」的正向证据。
FINGERPRINTS = {
    'SESSION_OK': {
        'label': 'cloud link session=ok cloud=set',
        'positive': (r'cloud\s+link\s+session\s*=\s*ok\b', r'cloud\s*=\s*set\b'),
        'negative': (r'cloud\s+link\s+session\s*=\s*NULL\b', r'cloud\s*=\s*null\b'),
    },
    'SNAPSHOT_PATH': {
        'label': 'save snapshot path=<绝对路径> (非 null)',
        'positive': (r'save\s+snapshot\s+path\s*=\s*(?P<path>\S+)',),
        'negative': (r'save\s+snapshot\s+path\s*=\s*null\b',),
    },
    'ARM_REBUILT': {
        'label': 'cloud arm: N-core room rebuilt',
        'positive': (r'cloud\s+arm\s*:\s*\d+\s*-core\s+room\s+rebuilt\b',),
        'negative': (r'cloud\s+arm\s*:\s*rebuild\s+failed\b',),
    },
    'ARM_RELEASED': {
        'label': 'cloud arm released: frames unlocked',
        'positive': (r'cloud\s+arm\s+released\s*:\s*frames\s+unlocked\b',),
        'negative': (),
    },
    'BOOT_BOOL': {
        'label': '[ISYNC-EV][BOOT] hasCurrent=1/pathResolved=1/coreReady|coreLoaded=1',
        'positive': (r'\[ISYNC-EV\]\[BOOT\]', r'\bhasCurrent\s*=\s*1\b',
                     r'\bpathResolved\s*=\s*1\b',
                     r'\b(?:coreReady|coreLoaded)\s*=\s*1\b'),
        'negative': (r'\[ISYNC-EV\]\[BOOT\]',
                     r'\b(?:hasCurrent|pathResolved|coreReady|coreLoaded)\s*=\s*0\b'),
    },
}
FP_IDS = tuple(FINGERPRINTS.keys())

_C0_ACCEPT_RE = re.compile(r'\[C0-GATE\]\s*ACCEPT\b', re.I)


def _new_rec():
    return {
        'fp': {k: {'positive': [], 'negative': []} for k in FP_IDS},
        'c0_accept': [],
        'summary': {},
        'files': [],
        'sample': [],
    }


def _add_sample(rec, rel, lineno, text):
    if len(rec['sample']) < 120:
        rec['sample'].append('%s:%d: %s' % (rel, lineno, text.strip()[:240]))


def _all_match(text, patterns):
    for pat in patterns:
        if not re.search(pat, text, re.I):
            return None
    return True


def _classify_line(rel, text, rec, lineno):
    # 反向诊断：[C0-GATE] ACCEPT 出现本身不是房间建成的证据。
    if _C0_ACCEPT_RE.search(text):
        rec['c0_accept'].append({'where': '%s:%d' % (rel, lineno),
                                 'text': text.strip()[:240]})
        _add_sample(rec, rel, lineno, text)

    for fp_id, spec in FINGERPRINTS.items():
        if _all_match(text, spec['positive']):
            # SNAPSHOT_PATH 额外要求捕获到绝对路径（非 null、以 / 开头）。
            if fp_id == 'SNAPSHOT_PATH':
                m = re.search(spec['positive'][0], text, re.I)
                path = m.group('path') if m else ''
                if not path or path.lower() == 'null' or not path.startswith('/'):
                    rec['fp'][fp_id]['negative'].append(
                        {'where': '%s:%d' % (rel, lineno), 'text': text.strip()[:240],
                         'reason': 'path 非绝对路径'})
                    _add_sample(rec, rel, lineno, text)
                    continue
            if len(rec['fp'][fp_id]['positive']) < 8:
                rec['fp'][fp_id]['positive'].append(
                    {'where': '%s:%d' % (rel, lineno), 'text': text.strip()[:240]})
            _add_sample(rec, rel, lineno, text)
            continue
        if spec['negative'] and _all_match(text, spec['negative']):
            if fp_id == 'SNAPSHOT_PATH':
                m = re.search(spec['negative'][0], text, re.I)
                if not m:
                    continue
            rec['fp'][fp_id]['negative'].append(
                {'where': '%s:%d' % (rel, lineno), 'text': text.strip()[:240]})
            _add_sample(rec, rel, lineno, text)


def _parse_summary(text, rec):
    for line in text.splitlines():
        m = re.match(r'^\s*([^=#]+?)\s*=\s*(.*?)\s*$', line)
        if m:
            rec['summary'][m.group(1).strip()] = m.group(2).strip()


def scan_run(run_dir):
    rec = _new_rec()
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
                rec['files'].append({'path': rel, 'bytes': size,
                                     'scanned': False, 'over_limit': True})
                continue
            rec['files'].append({'path': rel, 'bytes': size,
                                 'scanned': True, 'over_limit': False})
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


def judge(rec, tag=None):
    tag_field = rec['summary'].get('tag')
    if tag and tag_field:
        tag_check = 'OK' if tag.strip() == tag_field.strip() else 'MISMATCH'
    elif tag_field:
        tag_check = 'NO_EXPECTED_TAG'
    else:
        tag_check = 'NO_TAG_FIELD'

    fp_out = {}
    for fp_id in FP_IDS:
        pos = rec['fp'][fp_id]['positive']
        neg = rec['fp'][fp_id]['negative']
        fp_out[fp_id] = {
            'status': 'HIT' if pos else 'MISS',
            'positive_hits': len(pos),
            'negative_hits': len(neg),
            'first_hit': pos[0]['where'] if pos else None,
            'first_negative': neg[0]['where'] if neg else None,
        }

    hits = [k for k in FP_IDS if fp_out[k]['status'] == 'HIT']
    missing = [k for k in FP_IDS if fp_out[k]['status'] == 'MISS']
    all_hit = len(hits) == len(FP_IDS)

    # 负向变体只在「对应正向指纹缺失」时构成 FAIL（防重试先失败后成功的瞬时负向误判）。
    decisive_neg = [k for k in missing if fp_out[k]['negative_hits'] > 0]
    over_limit = [f['path'] for f in rec['files'] if f['over_limit']]

    if all_hit:
        verdict = 'PASS'
        detail = '五项 APP 房间指纹全部命中且值合法'
    elif decisive_neg:
        verdict = 'FAIL'
        detail = '房间未建成的正向证据: ' + ', '.join(decisive_neg)
    else:
        verdict = 'UNOBSERVED'
        detail = '缺失指纹: ' + (', '.join(missing) if missing else '无')

    # fail-closed：tag 不一致或存在超大文件未扫时，PASS 降级为 UNOBSERVED。
    if verdict == 'PASS' and tag_check == 'MISMATCH':
        verdict = 'UNOBSERVED'
        detail += '；tag MISMATCH（疑似拿错 artifact），PASS 降级 UNOBSERVED'
    if verdict == 'PASS' and over_limit:
        verdict = 'UNOBSERVED'
        detail += '；存在 >256MB 未扫文件，fail-closed 降级 UNOBSERVED'

    notes = [
        'APP_ROOM_BUILT 是前置门，不是成功证据；门 PASS 不升级总门。',
        '门 PASS 才允许下游 applied/CROSSED 判读；否则下游一律 UNOBSERVED（不 PASS 不 FAIL）。',
        '前置门必要非充分；总门 FAIL / 对手真实性 0/9 不变。',
        'CROSSED 唯一裁决不放宽：零注入 diff_party_check（APP 框 0006 ↔ PC 框 00D5）。',
        'FAIL > UNOBSERVED > PASS；字段缺失一律 UNOBSERVED；不伪造、不预设成功；红线禁造假。',
        '逐文件读取日志（含 >1MB 大日志），禁目录级 grep；SNAPSHOT_PATH 要求绝对路径非 null。',
        'BOOT 布尔接受 coreReady=1 / coreLoaded=1 两种写法（BOOTSTRAP 版本差异）。',
    ]
    if rec['c0_accept'] and not all_hit:
        notes.append(
            '反向命中：仍出现 [C0-GATE] ACCEPT（%d 条）但五项房间指纹不全 → '
            '房间仍未建、一行修复未命中，绝不判 PASS。' % len(rec['c0_accept']))
    if over_limit and verdict != 'UNOBSERVED':
        notes.append('存在未扫超大文件: ' + ', '.join(over_limit))

    return {
        'run_dir_tag_expected': tag,
        'tag_field': tag_field,
        'tag_check': tag_check,
        'APP_ROOM_BUILT': verdict,
        'verdict_detail': detail,
        'downstream_allowed': verdict == 'PASS',
        'fingerprints': fp_out,
        'hits': hits,
        'missing': missing,
        'decisive_negatives': decisive_neg,
        'c0_gate_accept_seen': bool(rec['c0_accept']),
        'files_scanned': sum(1 for f in rec['files'] if f['scanned']),
        'files_over_limit': over_limit,
        'total_bytes_scanned': sum(f['bytes'] for f in rec['files'] if f['scanned']),
        'sample': rec['sample'],
        'notes': notes,
    }


def gate_applied_result(room_res, applied_res):
    """整合方式（判读顺序：先 room 再 applied）：
    把 isync_applied_check.py 的 judge() 结果 applied_res 与本门结果合并。
    room 非 PASS（FAIL/UNOBSERVED）→ 下游 applied/CROSSED 一律 UNOBSERVED，
    不 PASS、不 FAIL；room PASS 时 applied 原判读不变（仍非成功证据）。
    返回浅拷贝，不修改入参。
    """
    merged = dict(applied_res)
    room_ok = room_res.get('APP_ROOM_BUILT') == 'PASS'
    merged['APP_ROOM_BUILT'] = room_res.get('APP_ROOM_BUILT')
    merged['room_downstream_allowed'] = room_ok
    if not room_ok:
        merged['VERDICT'] = 'UNOBSERVED'
        merged['APPLIED_GATE_VERDICT'] = 'UNOBSERVED'
        merged['A_EVIDENCE_VERDICT'] = 'UNOBSERVED'
        merged['room_gate_block'] = (
            'APP_ROOM_BUILT=%s，未通过前置门；下游 applied/CROSSED 一律 UNOBSERVED'
            % room_res.get('APP_ROOM_BUILT'))
    else:
        merged['room_gate_block'] = None
    return merged


def _fmt(res):
    lines = []
    lines.append('=== M1ROOM APP_ROOM_BUILT 前置门离线判读 ===')
    lines.append('tag_expected=%s tag_field=%s tag_check=%s' %
                 (res['run_dir_tag_expected'], res['tag_field'], res['tag_check']))
    lines.append('files_scanned=%d total_bytes=%d over_limit=%d  # 逐文件读取，禁目录级 grep' % (
        res['files_scanned'], res['total_bytes_scanned'], len(res['files_over_limit'])))
    lines.append('-- 五项可观测指纹 --')
    for fp_id in FP_IDS:
        v = res['fingerprints'][fp_id]
        lines.append('%s=%s pos=%d neg=%d first=%s' %
                     (fp_id, v['status'], v['positive_hits'], v['negative_hits'],
                      v['first_hit'] or v['first_negative'] or '-'))
    lines.append('hits=%s' % ','.join(res['hits']))
    lines.append('missing=%s' % (','.join(res['missing']) if res['missing'] else '-'))
    lines.append('decisive_negatives=%s' %
                 (','.join(res['decisive_negatives']) if res['decisive_negatives'] else '-'))
    lines.append('c0_gate_accept_seen=%s' % res['c0_gate_accept_seen'])
    lines.append('APP_ROOM_BUILT=%s | %s' % (res['APP_ROOM_BUILT'], res['verdict_detail']))
    lines.append('downstream_allowed=%s' % res['downstream_allowed'])
    for n in res['notes']:
        lines.append('NOTE: ' + n)
    if res['sample']:
        lines.append('-- 命中样本（前 12 条，供人工复核）--')
        lines.extend('  ' + s for s in res['sample'][:12])
    return '\n'.join(lines)


# ---------------- 自测（合成日志只写系统临时目录，不碰仓库产物）----------------
def _good_files():
    app = '\n'.join([
        '11-20 07:36:10.100   519  1597 I mGBA-App: [ISYNC-EV][BOOT] role=APP official=1'
        ' hasCurrent=1 hasLast=0 coreReady=1 pathResolved=1',
        '11-20 07:36:10.200   519  1597 I mGBA-App: save snapshot path='
        '/storage/emulated/0/Android/data/io.mgba.android/files/rom_b.sav'
        ' bytes=131088 mirrors=2 cached=yes',
        '11-20 07:36:11.100   519  1597 I mGBA-App: cloud link session=ok cloud=set',
        '11-20 07:36:12.100   519  1597 I mGBA-App: cloud arm: 2-core room rebuilt, visible slot=1',
        '11-20 07:36:12.200   519  1597 I mGBA-App: cloud arm released: frames unlocked',
    ]) + '\n'
    return {'app_logcat_full.log': app, 'summary.txt': 'tag=M1ROOM-SELFTEST\n'}


def _make_run(files):
    d = tempfile.mkdtemp(prefix='m1room_selftest_')
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

    root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

    # (1) 合成全指纹 → PASS + downstream_allowed=True
    d = _make_run(_good_files())
    try:
        r = judge(scan_run(d), 'M1ROOM-SELFTEST')
        check('(1) 合成全指纹 APP_ROOM_BUILT=PASS', r['APP_ROOM_BUILT'] == 'PASS')
        check('(1) downstream_allowed=True', r['downstream_allowed'] is True)
        check('(1) missing 为空', r['missing'] == [])
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (2) BOOT 用 coreLoaded=1 替代 coreReady=1 → 仍 PASS（版本差异兼容）
    f = _good_files()
    f['app_logcat_full.log'] = f['app_logcat_full.log'].replace('coreReady=1', 'coreLoaded=1')
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'M1ROOM-SELFTEST')
        check('(2) coreLoaded=1 变体仍 PASS', r['APP_ROOM_BUILT'] == 'PASS')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (3) M1-APPLIED-01 基线（全缺）→ UNOBSERVED
    baseline = os.path.join(root, '.zcode-tmp', 'cloud2p', 'M1-APPLIED-01')
    if os.path.isdir(baseline):
        r = judge(scan_run(baseline), 'M1-APPLIED-01')
        check('(3) M1-APPLIED-01 基线 APP_ROOM_BUILT=UNOBSERVED',
              r['APP_ROOM_BUILT'] == 'UNOBSERVED')
        check('(3) M1-APPLIED-01 五项全缺', len(r['missing']) == len(FP_IDS))
        check('(3) M1-APPLIED-01 downstream_allowed=False', r['downstream_allowed'] is False)
    else:
        print('SELFTEST SKIP: M1-APPLIED-01 基线不存在')

    # (4) M1-APPLIED-02 基线（全缺）→ UNOBSERVED
    baseline2 = os.path.join(root, '.zcode-tmp', 'cloud2p', 'M1-APPLIED-02')
    if os.path.isdir(baseline2):
        r = judge(scan_run(baseline2), 'M1-APPLIED-02')
        check('(4) M1-APPLIED-02 基线 APP_ROOM_BUILT=UNOBSERVED',
              r['APP_ROOM_BUILT'] == 'UNOBSERVED')
    else:
        print('SELFTEST SKIP: M1-APPLIED-02 基线不存在')

    # (5) 负向变体（save snapshot path=null + rebuild failed）→ FAIL
    f = _good_files()
    f['app_logcat_full.log'] = '\n'.join([
        '11-20 07:36:10.100 I mGBA-App: [ISYNC-EV][BOOT] role=APP official=1'
        ' hasCurrent=1 hasLast=0 coreReady=1 pathResolved=1',
        '11-20 07:36:10.200 I mGBA-App: save snapshot path=null bytes=-1 mirrors=0 cached=no',
        '11-20 07:36:11.100 I mGBA-App: cloud arm: rebuild failed: no core',
    ]) + '\n'
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'M1ROOM-SELFTEST')
        check('(5) 负向变体 APP_ROOM_BUILT=FAIL', r['APP_ROOM_BUILT'] == 'FAIL')
        check('(5) FAIL 时 downstream_allowed=False', r['downstream_allowed'] is False)
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (6) [C0-GATE] ACCEPT + 指纹不全 → UNOBSERVED + 反向 note
    f = _good_files()
    f['app_logcat_full.log'] = '\n'.join(
        ln for ln in f['app_logcat_full.log'].splitlines()
        if 'cloud arm released' not in ln and 'cloud arm:' not in ln) + '\n'
    f['app_logcat_full.log'] += 'I mGBA-App: [C0-GATE] ACCEPT\n'
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'M1ROOM-SELFTEST')
        check('(6) C0-GATE ACCEPT+缺指纹 → UNOBSERVED', r['APP_ROOM_BUILT'] == 'UNOBSERVED')
        check('(6) c0_gate_accept_seen=True', r['c0_gate_accept_seen'] is True)
        check('(6) 反向 note 出现', any('C0-GATE' in n and '一行修复' in n for n in r['notes']))
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (7) tag 不一致 → PASS 降级 UNOBSERVED
    d = _make_run(_good_files())
    try:
        r = judge(scan_run(d), 'WRONG-TAG')
        check('(7) tag MISMATCH → UNOBSERVED', r['APP_ROOM_BUILT'] == 'UNOBSERVED')
        check('(7) tag_check=MISMATCH', r['tag_check'] == 'MISMATCH')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (8) 部分指纹命中（无负向）→ UNOBSERVED，非 FAIL
    f = _good_files()
    f['app_logcat_full.log'] = '\n'.join(
        ln for ln in f['app_logcat_full.log'].splitlines()
        if 'cloud arm' not in ln) + '\n'
    d = _make_run(f)
    try:
        r = judge(scan_run(d), 'M1ROOM-SELFTEST')
        check('(8) 部分指纹缺 → UNOBSERVED（非 FAIL）',
              r['APP_ROOM_BUILT'] == 'UNOBSERVED')
    finally:
        shutil.rmtree(d, ignore_errors=True)

    # (9) 整合 helper：room 非 PASS → applied VERDICT 被强制 UNOBSERVED
    room_bad = {'APP_ROOM_BUILT': 'UNOBSERVED'}
    merged = gate_applied_result(room_bad, {'VERDICT': 'PASS',
                                            'APPLIED_GATE_VERDICT': 'PASS',
                                            'A_EVIDENCE_VERDICT': 'PASS'})
    check('(9) room 非 PASS → 下游 VERDICT=UNOBSERVED',
          merged['VERDICT'] == 'UNOBSERVED'
          and merged['APPLIED_GATE_VERDICT'] == 'UNOBSERVED'
          and merged['room_downstream_allowed'] is False)
    room_ok = {'APP_ROOM_BUILT': 'PASS'}
    merged2 = gate_applied_result(room_ok, {'VERDICT': 'PASS',
                                            'APPLIED_GATE_VERDICT': 'PASS',
                                            'A_EVIDENCE_VERDICT': 'PASS'})
    check('(9) room PASS → 下游判读不变', merged2['VERDICT'] == 'PASS'
          and merged2['room_downstream_allowed'] is True)

    print('SELFTEST_SUMMARY: %d/%d passed' % (passed, total))
    return 0 if passed == total else 1


def main(argv=None):
    # Windows 控制台默认 GBK，含 ↔/↕/中文 的报告与 JSON 会触发 UnicodeEncodeError；
    # 统一切 UTF-8（错误用 replace 兜底），保证判读结果稳定落盘/管道。
    try:
        sys.stdout.reconfigure(encoding='utf-8', errors='replace')
    except (AttributeError, ValueError):
        pass
    ap = argparse.ArgumentParser(description='M1ROOM APP_ROOM_BUILT 前置门离线判读（只读）')
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
    return {'PASS': 0, 'FAIL': 1, 'UNOBSERVED': 3}[res['APP_ROOM_BUILT']]


if __name__ == '__main__':
    sys.exit(main())
