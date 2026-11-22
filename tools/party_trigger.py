#!/usr/bin/env python3
"""S2 TYPE_PARTY 触发辅助脚本（仿 isync_trigger.py；driver 零改）。

命中 marker 后写 0 字节 <run>/pc_keys/party_mailbox —— PC 侧 CloudLink.cpp 的
250ms 轮询块检测该文件，exists→remove→sendPartyMailboxSync()，把本机真
gPlayerParty 的 500B GNP 邮槽镜像经 TYPE_PARTY=18 帧发给 APP。

内容不被读取，0 字节即可。间隔 >=1s（APP 写口每次做整 ROM md5）。
本脚本属灰区诊断（S2）；产物须标注「CROSSED 可信度存疑 / 非纯零注入」。
"""
import argparse
import os
import sys
import time


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--run-dir", required=True, help="E2E run 目录（含 pc_keys/）")
    ap.add_argument("--keys-dir", default=None, help="pc_keys 路径（默认 <run-dir>/pc_keys）")
    ap.add_argument("--after-marker", default="LINKUP_OK",
                    help="日志 marker 文件/子串，命中后才开始触发（默认 LINKUP_OK）")
    ap.add_argument("--marker-file", default=None,
                    help="marker 日志文件路径（默认 <run-dir>/pc_nav.log）")
    ap.add_argument("--wait", type=float, default=1.0, help="命中后等待秒数")
    ap.add_argument("--repeat", type=int, default=5, help="触发次数")
    ap.add_argument("--interval", type=float, default=2.0, help="触发间隔秒（>=1）")
    args = ap.parse_args()

    keys = args.keys_dir or os.path.join(args.run_dir, "pc_keys")
    if not os.path.isdir(keys):
        print("[party_trigger] pc_keys not found: " + keys, flush=True)
        return 2
    if args.interval < 1.0:
        print("[party_trigger] interval <1s refused (ROM md5 cost)", flush=True)
        return 2

    marker = args.marker_file or os.path.join(args.run_dir, "pc_nav.log")
    if args.after_marker:
        deadline = time.time() + 300
        while time.time() < deadline:
            hit = False
            if os.path.isfile(marker):
                try:
                    with open(marker, "r", errors="ignore") as f:
                        hit = args.after_marker in f.read()
                except OSError:
                    hit = False
            if hit:
                break
            time.sleep(0.5)
        else:
            print("[party_trigger] marker timeout, abort", flush=True)
            return 3

    time.sleep(args.wait)
    path = os.path.join(keys, "party_mailbox")
    for i in range(args.repeat):
        with open(path, "wb"):
            pass
        print("[party_trigger] fired %d/%d -> %s" % (i + 1, args.repeat, path), flush=True)
        if i + 1 < args.repeat:
            time.sleep(args.interval)
    return 0


if __name__ == "__main__":
    sys.exit(main())
