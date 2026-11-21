#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""M1AUTO — 实时 sync_state 触发辅助脚本（driver 时序辅助，零造假）。

用途
----
CloudLink.cpp:2361-2372 每 250ms 轮询 <MGBAX_SCRIPT_DIR>/sync_state：
发现该文件即 remove + sendStateSync()，把 PC 真快照（TYPE_STATE）重发一次。
本脚本在 E2E 运行时 tail-follow run 目录的 driver console/log，
命中 --after-marker 后等 --wait 秒，写 0 字节 sync_state 到
<run>/pc_keys/sync_state，并按 --repeat/--interval 重写多次。

    MGBAX_SCRIPT_DIR = <gdir>/pc_keys      （cloud2p_avd.py:1423）
    触发文件         = <run>/pc_keys/sync_state
    kArmResendMax=2  只约束 CloudLink 的自动补发；
                     本脚本的 --repeat 是文件触发重写次数，无次数上限。

用法
----
    python tools/isync_trigger.py <run目录> \
        --after-marker "consoleSet ready" --wait 2 --repeat 3 --interval 2
    python tools/isync_trigger.py <run目录> --after-marker "M" \
        --log driver_stdout.log --log avd_driver.log --start end --timeout 300
    python tools/isync_trigger.py --selftest

锚点（--after-marker）由父会话 / M1TRIGGER 判定后填入，本脚本不预设锚点值。
已知线索（仅供父会话参考，不作结论）：M1SEED 说门开晚于 seed
（导航进战斗 mm=2、ST 跳变）；ISYNC28 说耗尽比核就绪早 33-51s。
--start 默认 start（从文件头读，便于补抓已落盘的锚点）；若日志里已有历史
同名字符串则用 --start end 只看新增内容。

严格纪律（诚实，不可动摇）
--------------------------
* 只写 0 字节 sync_state，绝不写数据/信任位/party/CROSSED 字符串——
  触发后发出去的仍是 PC 真快照，不造假。
* 只 tail-follow 读日志 + 只写 sync_state 文件；不改 run 其他产物、
  不碰设备/账号、不编译、不跑 E2E、不判 PASS。
* 每次写入打时间戳日志到 stdout，便于事后判读触发时刻；要持久化请父会话重定向。
* 总门维持 FAIL / 对手真实性 0/9；唯一裁决仍是零注入 diff_party_check 的
  CROSSED（APP 框 0006 ↔ PC 框 00D5）。命中/写入不构成任何成功证据；
  产物须标注「driver 辅助时序触发、非纯零注入时机、CROSSED 可信度存疑」。
* 中文注释如实，不预设成功，不伪造。

退出码：0=已触发并完成写入；1=selftest 失败；2=未命中 marker / 无可跟随日志。
"""

import argparse
import os
import sys
import tempfile
import threading
import time

TEXT_EXTS = ('.log', '.txt', '.out')
DEFAULT_TIMEOUT = 600.0
DEFAULT_POLL = 0.25


def decode_line(raw):
    """字节行 → 文本：utf-8 优先，退化 gbk，再退化替换字符（编码容错）。"""
    if isinstance(raw, str):
        return raw
    for enc in ('utf-8', 'gbk'):
        try:
            return raw.decode(enc)
        except UnicodeDecodeError:
            pass
    return raw.decode('utf-8', errors='replace')


def _wall_stamp():
    """人读墙钟时间戳（毫秒），与单调钟分开记录，便于事后判读。"""
    return '%s.%03d' % (time.strftime('%Y-%m-%d %H:%M:%S', time.localtime()),
                        int((time.time() % 1) * 1000))


class SyncTrigger(object):
    """可注入 sleep/clock/emit 的触发引擎，便于快速自测（不依赖真实长等待）。"""

    def __init__(self, run_dir, marker, wait, repeat, interval,
                 log_paths=None, start='start', poll_interval=DEFAULT_POLL,
                 timeout=DEFAULT_TIMEOUT, sleep_func=None, clock=None, emit=None):
        self.run_dir = os.path.abspath(run_dir)
        self.marker = marker
        self.wait = float(wait)
        self.repeat = int(repeat)
        self.interval = float(interval)
        self.log_paths = log_paths
        self.start = start
        self.poll_interval = float(poll_interval)
        self.timeout = float(timeout)
        self._sleep = sleep_func if sleep_func is not None else time.sleep
        self._clock = clock if clock is not None else time.monotonic
        self._emit = emit if emit is not None else (lambda s: print(s, flush=True))
        self.sync_path = os.path.join(self.run_dir, 'pc_keys', 'sync_state')
        self.result = {
            'status': 'INIT', 'logs': [], 'marker': None, 'writes': [],
            'run_dir': self.run_dir, 'trigger_mode': 'driver-timed-sync_state',
        }

    def _resolve_logs(self):
        """--log 指定（相对 run_dir）优先；否则自动发现 run 根目录的文本日志。"""
        paths = []
        if self.log_paths:
            for p in self.log_paths:
                ap = p if os.path.isabs(p) else os.path.join(self.run_dir, p)
                ap = os.path.abspath(ap)
                if ap not in paths:
                    paths.append(ap)
        else:
            try:
                names = sorted(os.listdir(self.run_dir))
            except OSError:
                names = []
            for n in names:
                if n.lower().endswith(TEXT_EXTS):
                    fp = os.path.join(self.run_dir, n)
                    if os.path.isfile(fp):
                        paths.append(fp)
        return paths

    @staticmethod
    def _has_marker(text, marker):
        return marker in text

    def _write_sync(self, n):
        """只做一件事：确保 pc_keys 存在并写 0 字节 sync_state。"""
        ok = False
        try:
            d = os.path.dirname(self.sync_path)
            if not os.path.isdir(d):
                os.makedirs(d, exist_ok=True)
                self._emit('[M1AUTO] 创建目录 %s' % d)
            with open(self.sync_path, 'wb') as fh:
                fh.write(b'')  # 0 字节；CloudLink 见文件即重发真快照后删除
            ok = os.path.getsize(self.sync_path) == 0
        except OSError as e:
            self._emit('[M1AUTO][写失败] %s: %s' % (self.sync_path, e))
        rec = {
            'n': n,
            'mono_ts': self._clock(),
            'wall': _wall_stamp(),
            'ok': ok,
            'path': self.sync_path,
        }
        self._emit('[sync_state] 写 %d/%d wall=%s mono=%.3f ok=%s path=%s'
                   % (n, self.repeat, rec['wall'], rec['mono_ts'], ok, self.sync_path))
        return rec

    def run(self):
        resolved = self._resolve_logs()
        self.result['logs'] = resolved
        self._emit('[M1AUTO] run_dir=%s marker=%r wait=%.2fs repeat=%d interval=%.2fs '
                   'start=%s logs=%d'
                   % (self.run_dir, self.marker, self.wait, self.repeat,
                      self.interval, self.start, len(resolved)))
        if not resolved:
            self._emit('[M1AUTO] 未找到可跟随日志（可用 --log 指定）→ 未触发')
            self.result['status'] = 'NO_LOG'
            return self.result

        states = []
        for p in resolved:
            try:
                f = open(p, 'rb')
            except OSError as e:
                self._emit('[M1AUTO] 打开日志失败 %s: %s' % (p, e))
                continue
            if self.start == 'end':
                f.seek(0, os.SEEK_END)
            states.append({'path': p, 'f': f, 'pos': f.tell(), 'leftover': b''})
        if not states:
            self._emit('[M1AUTO] 所有日志均打开失败 → 未触发')
            self.result['status'] = 'NO_LOG'
            return self.result

        deadline = self._clock() + self.timeout
        matched = None
        try:
            while self._clock() < deadline:
                progressed = False
                for st in states:
                    f = st['f']
                    # 日志轮转/截断保护：文件比上次位置短则从头再读。
                    try:
                        if os.fstat(f.fileno()).st_size < st['pos']:
                            f.seek(0)
                            st['pos'] = 0
                            st['leftover'] = b''
                    except OSError:
                        pass
                    f.seek(st['pos'])
                    data = f.read()
                    if not data:
                        continue
                    progressed = True
                    st['pos'] = f.tell()
                    buf = st['leftover'] + data
                    parts = buf.split(b'\n')
                    st['leftover'] = parts.pop()  # 末尾未换行的残段留到下一轮
                    for raw in parts:
                        line = decode_line(raw).rstrip('\r')
                        if self._has_marker(line, self.marker):
                            matched = {'path': st['path'], 'line': line.strip(),
                                       'wall': _wall_stamp(), 'at': self._clock()}
                            break
                    if matched is None:
                        # 无换行结尾的行也扫一次，避免最后一行永久滞留 leftover。
                        tail = decode_line(st['leftover']).rstrip('\r')
                        if self._has_marker(tail, self.marker):
                            matched = {'path': st['path'], 'line': tail.strip(),
                                       'wall': _wall_stamp(), 'at': self._clock()}
                    if matched:
                        break
                if matched:
                    break
                if not progressed:
                    self._sleep(self.poll_interval)
        finally:
            for st in states:
                try:
                    st['f'].close()
                except Exception:
                    pass

        if matched is None:
            self._emit('[M1AUTO] 超时 %.1fs 未见 marker → 未触发（不判 PASS，门维持 FAIL/0/9）'
                       % self.timeout)
            self.result['status'] = 'NO_MARKER'
            return self.result

        self.result['status'] = 'TRIGGERED'
        self.result['marker'] = matched
        self._emit('[M1AUTO] 命中 marker @%s [%s] %s'
                   % (matched['wall'], os.path.basename(matched['path']),
                      matched['line'][:200]))
        self._emit('[M1AUTO] 触发方式=driver 辅助时序触发（非纯零注入时机，须标注；'
                   'CROSSED 可信度存疑）；等 %.2fs 后写 0 字节 sync_state' % self.wait)
        self._sleep(self.wait)

        for i in range(1, self.repeat + 1):
            self.result['writes'].append(self._write_sync(i))
            if i < self.repeat and self.interval > 0:
                self._sleep(self.interval)

        self._emit('[M1AUTO] 完成：%d 次写入；数据仍为 PC 真快照，零注入；'
                   '门维持 FAIL/0/9，CROSSED 唯一裁决，不判 PASS'
                   % len(self.result['writes']))
        return self.result


def run_selftest():
    """合成日志流验证：marker 匹配、写前不触发、0 字节、重复次数/间隔、gbk、--start end。"""
    print('=== M1AUTO selftest start ===')
    all_ok = True

    # 场景 1：utf-8 marker 增量喂入 —— 断言写前不触发、命中后按 wait/repeat/interval 写 0 字节。
    with tempfile.TemporaryDirectory(prefix='m1auto-selftest-') as td:
        run = os.path.join(td, 'run')
        os.makedirs(run, exist_ok=True)
        logp = os.path.join(run, 'driver_stdout.log')
        marker = 'CONSOLESET_READY'
        with open(logp, 'w', encoding='utf-8') as f:
            f.write('boot line 1\nseed applied\n')
        emitted = []
        trig = SyncTrigger(run, marker, wait=0.3, repeat=3, interval=0.15,
                           log_paths=['driver_stdout.log'], start='start',
                           poll_interval=0.05, timeout=5,
                           emit=lambda s: emitted.append(s))
        t = threading.Thread(target=trig.run)
        t.start()
        time.sleep(0.3)
        syncp = os.path.join(run, 'pc_keys', 'sync_state')
        pre_ok = not os.path.exists(syncp)
        print('  [1] marker 未出现前未写 sync_state: %s' % pre_ok)
        with open(logp, 'a', encoding='utf-8') as f:
            f.write(' milestone %s reached\npost line\n' % marker)
        t.join(timeout=6)
        res = trig.result
        writes = res['writes']
        n_ok = res['status'] == 'TRIGGERED' and len(writes) == 3
        z_ok = os.path.exists(syncp) and os.path.getsize(syncp) == 0
        wait_ok = bool(writes) and (writes[0]['mono_ts'] - res['marker']['at']) >= 0.3 - 0.12
        gaps = [writes[i + 1]['mono_ts'] - writes[i]['mono_ts'] for i in range(len(writes) - 1)]
        gap_ok = bool(gaps) and all(0.15 - 0.12 <= g <= 0.15 + 0.35 for g in gaps)
        print('  [1] status=%s writes=%d 0字节=%s wait≈0.3=%s interval≈0.15=%s gaps=%s'
              % (res['status'], len(writes), z_ok, wait_ok, gap_ok,
                 ['%.3f' % g for g in gaps]))
        ok1 = pre_ok and n_ok and z_ok and wait_ok and gap_ok
        all_ok = all_ok and ok1
        print('  [1] %s' % ('PASS' if ok1 else 'FAIL'))

    # 场景 2：gbk 编码中文 marker —— 编码容错命中。
    with tempfile.TemporaryDirectory(prefix='m1auto-selftest-') as td:
        run = os.path.join(td, 'run')
        os.makedirs(run, exist_ok=True)
        logp = os.path.join(run, 'pc_stdout.log')
        marker = '控制台就绪'
        with open(logp, 'wb') as f:
            f.write(b'boot\n')
            f.write(('里程碑 %s 到达\n' % marker).encode('gbk'))
        trig = SyncTrigger(run, marker, wait=0.0, repeat=1, interval=0.0,
                           log_paths=['pc_stdout.log'], start='start',
                           poll_interval=0.02, timeout=3, emit=lambda s: None)
        res = trig.run()
        syncp = os.path.join(run, 'pc_keys', 'sync_state')
        ok2 = (res['status'] == 'TRIGGERED' and len(res['writes']) == 1
               and os.path.exists(syncp) and os.path.getsize(syncp) == 0)
        print('  [2] gbk marker 命中并写 0 字节: %s (status=%s)' % (ok2, res['status']))
        all_ok = all_ok and ok2
        print('  [2] %s' % ('PASS' if ok2 else 'FAIL'))

    # 场景 3：--start end 不看历史 marker —— 已有 marker 但不应触发。
    with tempfile.TemporaryDirectory(prefix='m1auto-selftest-') as td:
        run = os.path.join(td, 'run')
        os.makedirs(run, exist_ok=True)
        logp = os.path.join(run, 'driver_stdout.log')
        marker = 'OLD_MARKER'
        with open(logp, 'w', encoding='utf-8') as f:
            f.write('historical %s line\n' % marker)
        trig = SyncTrigger(run, marker, wait=0.0, repeat=1, interval=0.0,
                           log_paths=['driver_stdout.log'], start='end',
                           poll_interval=0.02, timeout=0.6, emit=lambda s: None)
        res = trig.run()
        syncp = os.path.join(run, 'pc_keys', 'sync_state')
        ok3 = res['status'] == 'NO_MARKER' and not os.path.exists(syncp)
        print('  [3] --start end 忽略历史 marker: %s (status=%s)' % (ok3, res['status']))
        all_ok = all_ok and ok3
        print('  [3] %s' % ('PASS' if ok3 else 'FAIL'))

    print('=== M1AUTO selftest %s ===' % ('PASS' if all_ok else 'FAIL'))
    return all_ok


def main(argv=None):
    ap = argparse.ArgumentParser(
        description='M1AUTO：命中 console marker 后定时写 0 字节 sync_state '
                    '（driver 辅助时序触发，PC 真快照零注入，不判 PASS）')
    ap.add_argument('run_dir', nargs='?', help='run 目录（内含 pc_keys/ 与各 console/log）')
    ap.add_argument('--after-marker', dest='marker',
                    help='锚点字符串（由父会话/M1TRIGGER 填入；本脚本不预设）')
    ap.add_argument('--wait', type=float, default=1.0, help='命中后等待秒数（默认 1.0）')
    ap.add_argument('--repeat', type=int, default=3, help='写 sync_state 次数（无上限，默认 3）')
    ap.add_argument('--interval', type=float, default=2.0, help='两次写之间隔秒数（默认 2.0）')
    ap.add_argument('--log', dest='logs', action='append', default=None,
                    help='要跟随的日志文件（相对 run_dir；可重复）。不指定则自动发现 run 根目录文本日志')
    ap.add_argument('--start', choices=('start', 'end'), default='start',
                    help='从文件头读(start，默认，可补抓已落盘锚点) / 从当前末尾读(end)')
    ap.add_argument('--poll-interval', type=float, default=DEFAULT_POLL,
                    help='跟随轮询间隔秒（默认 0.25）')
    ap.add_argument('--timeout', type=float, default=DEFAULT_TIMEOUT,
                    help='等待 marker 的超时秒（默认 600）')
    ap.add_argument('--selftest', action='store_true', help='运行合成日志流自测')
    args = ap.parse_args(argv)

    if args.selftest:
        return 0 if run_selftest() else 1
    if not args.run_dir:
        ap.error('需要 <run目录>（或 --selftest）')
    if not args.marker:
        ap.error('需要 --after-marker（锚点由父会话/M1TRIGGER 填入）')
    if args.repeat < 1:
        ap.error('--repeat 必须 >= 1')
    if args.wait < 0 or args.interval < 0:
        ap.error('--wait/--interval 必须 >= 0')
    if not os.path.isdir(args.run_dir):
        ap.error('run 目录不存在: %s' % args.run_dir)

    trig = SyncTrigger(args.run_dir, args.marker, args.wait, args.repeat,
                       args.interval, log_paths=args.logs, start=args.start,
                       poll_interval=args.poll_interval, timeout=args.timeout)
    res = trig.run()
    return 0 if res['status'] == 'TRIGGERED' else 2


if __name__ == '__main__':
    sys.exit(main())
