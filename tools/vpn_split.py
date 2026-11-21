#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""vpn_split.py — 跨设备不同公网出口 IP 的可回滚分流工具（见 ADR-007）。

用法：
  python tools/vpn_split.py status    # 只读：规则状态 + 两端 STUN 映射
  python tools/vpn_split.py apply     # 在 AVD 丢弃 UDP/3478，使 AVD 回落 Google STUN
  python tools/vpn_split.py restore   # 删除规则，恢复原状

安全：apply 前检查宿主无活跃 python/mGBA 对战进程；只改 AVD 的 iptables，
不动 Windows 路由 / hosts，不影响在途 agent。
"""
import os
import random
import re
import socket
import struct
import subprocess
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"
SERIAL = "emulator-5554"
RULE = ("OUTPUT", "-p", "udp", "--dport", "3478", "-j", "DROP")
MAGIC = 0x2112A442
STUN = [("miwifi", "111.206.174.3", 3478), ("google", "74.125.250.129", 19302)]


def run(cmd, timeout=30):
    r = subprocess.run(cmd, capture_output=True, text=True, timeout=timeout,
                       encoding="utf-8", errors="replace")
    return r.returncode, (r.stdout or "") + (r.stderr or "")


def adb(*args, timeout=30):
    return run([ADB, "-s", SERIAL] + list(args), timeout=timeout)


def active_battle():
    """仅当存在真正的对战驱动进程（排除本脚本自身）才认为有活跃 run。"""
    me = os.getpid()
    ps = subprocess.run(
        ["powershell", "-NoProfile", "-Command",
         "Get-CimInstance Win32_Process | Where-Object { "
         "($_.Name -match 'python|mGBA') -and $_.ProcessId -ne %d "
         "-and ($_.CommandLine -match 'cloud2p|frame_stutter|speed_parity|mGBA\\.exe') "
         "} | Select-Object -ExpandProperty ProcessId" % me],
        capture_output=True, text=True, timeout=20)
    return bool((ps.stdout or "").strip())


def parse_stun(data):
    if len(data) < 20 or struct.unpack("!H", data[:2])[0] != 0x0101:
        return None
    off = 20
    while off + 4 <= len(data):
        typ, ln = struct.unpack("!HH", data[off:off + 4])
        if off + 4 + ln > len(data):
            break
        if typ in (0x0020, 0x0001) and ln >= 8:
            v = data[off + 4:off + 4 + ln]
            p = struct.unpack("!H", v[2:4])[0]
            a = struct.unpack("!I", v[4:8])[0]
            if typ == 0x0020:
                p ^= 0x2112
                a ^= MAGIC
            return "%d.%d.%d.%d:%d" % ((a >> 24) & 255, (a >> 16) & 255,
                                       (a >> 8) & 255, a & 255, p)
        off += 4 + ln + ((4 - ln % 4) % 4)
    return None


def pc_stun(host, port, src=""):
    try:
        infos = socket.getaddrinfo(host, port, socket.AF_INET, socket.SOCK_DGRAM)
        server = infos[0][4]
    except Exception as e:
        return "DNS_ERR=%s" % e
    import base64  # noqa: F401  (not used; keep host-side raw socket)
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.settimeout(2.0)
        if src:
            s.bind((src, 0))
        req = struct.pack("!HHI", 0x0001, 0, MAGIC) + bytes(
            random.randrange(256) for _ in range(12))
        s.sendto(req, server)
        while True:
            data, _ = s.recvfrom(512)
            mapped = parse_stun(data)
            if mapped:
                s.close()
                return mapped
    except Exception as e:
        return "ERR=%s" % e
    finally:
        try:
            s.close()
        except Exception:
            pass
    return "TIMEOUT"


def avd_stun(host, port, attempts=3):
    import base64
    last = "NO_RESPONSE"
    for _ in range(attempts):
        req = struct.pack("!HHI", 0x0001, 0, MAGIC) + bytes(
            random.randrange(256) for _ in range(12))
        b64 = base64.b64encode(req).decode()
        cmd = ("echo %s | base64 -d | nc -u -n -w 2 -q 2 %s %d | base64 -w 0"
               % (b64, host, port))
        _rc, out = adb("shell", cmd, timeout=20)
        out = out.strip()
        try:
            raw = base64.b64decode(out + "=" * (-len(out) % 4))
        except Exception:
            continue
        mapped = parse_stun(raw)
        if mapped:
            return mapped
        last = "NO_MAPPED"
    return last


def rule_present():
    _rc, out = adb("shell", "iptables -S OUTPUT")
    return any(("3478" in ln and "DROP" in ln) for ln in out.splitlines())


def do_apply():
    if active_battle():
        print("REFUSE: 检测到活跃 python/mGBA 对战进程，先不要切分流（见 ADR-007 §3.1）")
        return 2
    adb("root")
    if not rule_present():
        rc, out = adb("shell", "iptables " + " ".join(
            ["-A"] + list(RULE)))
        if rc != 0:
            print("APPLY FAILED: %s" % out[:300])
            return 3
    print("APPLIED: AVD OUTPUT DROP udp/3478")
    return do_status()


def do_restore():
    adb("root")
    while rule_present():
        rc, out = adb("shell", "iptables " + " ".join(["-D"] + list(RULE)))
        if rc != 0:
            print("RESTORE FAILED: %s" % out[:300])
            return 3
    print("RESTORED: AVD udp/3478 规则已删除")
    return do_status()


def do_status():
    print("RULE_AVD_DROP_UDP3478=%s" % rule_present())
    results = {}
    for name, host, port in STUN:
        results[("pc", name)] = pc_stun(host, port)
        print("PC  %-8s -> %s" % (name, results[("pc", name)]))
    for name, host, port in STUN:
        results[("avd", name)] = avd_stun(host, port)
        print("AVD %-8s -> %s" % (name, results[("avd", name)]))
    p_mi = results[("pc", "miwifi")]
    a_go = results[("avd", "google")]
    ok = bool(re.match(r"\d+\.\d+\.\d+\.\d+", p_mi)
              and re.match(r"\d+\.\d+\.\d+\.\d+", a_go)
              and p_mi.split(":")[0] != a_go.split(":")[0])
    print("EGRESS_DISTINCT=%s  (PC=%s / AVD=%s)" % (ok, p_mi, a_go))
    return 0 if ok else 1


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "status"
    if cmd == "apply":
        sys.exit(do_apply())
    elif cmd == "restore":
        sys.exit(do_restore())
    elif cmd == "status":
        sys.exit(do_status())
    else:
        print(__doc__)
        sys.exit(2)
