# -*- coding: utf-8 -*-
r"""握手层探针：PC 端 AUTOLINK 加入 APP 已建的房，观察 APP link st=2 握手演进。

前提：APP 已手动走到 cable club 等待连接（open=1 st=2）并已发 CLOUD host 建房拿到房号。
本脚本只做"起 PC 加入房间 + 监控握手"，不碰 APP 导航。

零注入：7 数据门全关（rh_off=1/hs_bypass=0/hs_hold=0/2222_sticky=0/bus_hs_preserve=0）。
PC 用不同账号（525612743@qq.com）+ 不同 uuid（D:\gen8 干净母本）。

用法：python tools/handshake_probe.py --room 818373 [--monitor 180]
"""
import argparse, os, subprocess, sys, time

ROOT = r"D:\mgba-android-version"
TOOLS = os.path.join(ROOT, "tools")
sys.path.insert(0, TOOLS)
import importlib.util  # noqa: E402
_spec = importlib.util.spec_from_file_location("cloud2p_duo", os.path.join(TOOLS, "cloud2p-duo.py"))
D = importlib.util.module_from_spec(_spec)
_spec.loader.exec_module(D)  # noqa: E402

EXE = os.path.join(ROOT, "build-win", "mGBA.exe")   # 新版(含NETGATE钩子),dist/ 下无此文件
PC_ROM = os.path.join(ROOT, "rom.gba")   # PC 用 ROM（与 APP 同源）
PC_ACC = "525612743@qq.com:14855735"
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"


def log(m):
    print("[HS %s] %s" % (time.strftime("%H:%M:%S"), m), flush=True)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--room", required=True)
    ap.add_argument("--monitor", type=int, default=180)
    ap.add_argument("--tag", default="HSPROBE-01")
    a = ap.parse_args()

    gdir = os.path.join(ROOT, ".zcode-tmp", a.tag)
    pc_tmp = os.path.join(gdir, "pc_tmp")
    pc_keys = os.path.join(gdir, "pc_keys")
    os.makedirs(pc_tmp, exist_ok=True)
    os.makedirs(pc_keys, exist_ok=True)

    # PC env：干净 + 7 数据门全关（PC 侧门名）
    env = dict(os.environ)
    for k in list(env):
        if k.startswith("MGBAX_"):
            env.pop(k, None)
    env.update({
        "MGBAX_AUTOLINK": "%s:%s" % (PC_ACC, a.room),
        "MGBAX_RH_OFF": "1",
        "MGBAX_LINK_HSBYPASS": "0",
        "MGBAX_LINK_FORCEHS": "0",
        "MGBAX_HS_HOLD": "0",
        "MGBAX_2222_STICKY": "0",
        "MGBAX_BUS_HS_PRESERVE": "0",
        "MGBAX_LINK_REARM": "0",
        "MGBAX_NETGATE_LOG": "1",
    })
    # 不改系统 TEMP/TMP（改了会导致 Windows CreateProcess 拒绝/EDR 拦截）；
    # 隔离靠独立 cwd(ROOT) + 独立 keys/lobby 目录(D.Inst) + 不同账号/uuid。
    pc = D.Inst("PC", pc_tmp, pc_keys, nav_on=False)
    pc.stdout = os.path.join(gdir, "pc_stdout.log")
    pc.proc = subprocess.Popen([EXE, PC_ROM], cwd=ROOT, env=env,
                               stdout=open(pc.stdout, "w"), stderr=subprocess.STDOUT)
    pc.pid = pc.proc.pid
    log("PC 启动 pid=%d room=%s AUTOLINK=%s:…:%s" % (pc.pid, a.room, PC_ACC.split(":")[0], a.room))

    # 监控：PC lobby + APP PEEK 握手演进
    t0 = time.time()
    last_st = None
    while time.time() - t0 < a.monitor:
        time.sleep(6)
        # PC lobby 房号/连接状态
        lobby = pc.text(pc.lobby)
        room_hits = [l for l in lobby.splitlines() if "房" in l or "room" in l.lower() or "连接" in l]
        # APP PEEK st/pc/8fff
        r = subprocess.run([ADB, "shell", "logcat", "-d", "-t", "200", "-s", "mGBA:I"],
                           capture_output=True, text=True, encoding="utf-8", errors="replace")
        peeks = [l for l in (r.stdout or "").splitlines() if "PEEK st=" in l]
        last = peeks[-1] if peeks else ""
        import re
        st = re.search(r"link\[m=-?\d+ st=(-?\d+) pc=(-?\d+)", last)
        st_s = ("st=%s pc=%s" % (st.group(1), st.group(2))) if st else "no-PEEK"
        if st_s != last_st:
            log("APP %s | PC lobby末: %s" % (st_s, room_hits[-1][:100] if room_hits else "-"))
            last_st = st_s
    log("监控结束。诚实判据: APP st≥4 才是真握手; PC st4/pc2 是本地闭合不算。")
    return 0


if __name__ == "__main__":
    sys.exit(main())
