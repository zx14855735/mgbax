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


def write_fps_report(app_log, out_path, t_start, t_end):
    """N1: 从握手期活 logcat 解析 FRM emuFps/callsFps，阶段化落盘。
    0 样本写 UNOBSERVED，不写 0、不编造。emuFps≈4&callsFps≈60=lockstep 冻时钟
    （非渲染慢）；两者都≈4=APP 层真慢；两者都≈60=之前 4fps 是导航假象。"""
    import re, statistics
    emu, calls = [], []
    if os.path.exists(app_log):
        # C 侧 FRM 已加阶段标签 link=<state> att=<0/1>；只收握手期(link=2 && att=0)
        pat = re.compile(r"FRM me=\S+ emuFps=([0-9.]+) callsFps=([0-9.]+).*?link=(-?\d+) att=(\d+)")
        with open(app_log, encoding="utf-8", errors="replace") as f:
            for line in f:
                m = pat.search(line)
                if m and m.group(3) == "2" and m.group(4) == "0":
                    emu.append(float(m.group(1)))
                    calls.append(float(m.group(2)))
    lines = [
        "# 握手期 APP 帧率（handshake_probe --fps，N1）",
        "阶段=handshake (APP 已 cable club waiting + PC 纯链路加入，无 screencap 导航负载)",
        "窗口=[%s, %s]" % (time.strftime("%H:%M:%S", time.localtime(t_start)),
                           time.strftime("%H:%M:%S", time.localtime(t_end))),
        "log=%s" % app_log,
        "判据: emu≈4&calls≈4→APP层真慢; emu≈4&calls≈60→lockstep冻时钟(非渲染慢); emu≈60&calls≈60→之前4fps是导航假象",
    ]
    if not emu:
        lines.append("FRM 样本=0 → UNOBSERVED（不写 0，不编造）")
    else:
        lines.append("FRM 样本 n=%d" % len(emu))
        lines.append("fps_handshake_emu_median=%.2f (min=%.2f max=%.2f)" %
                     (statistics.median(emu), min(emu), max(emu)))
        lines.append("fps_handshake_calls_median=%.2f (min=%.2f max=%.2f)" %
                     (statistics.median(calls), min(calls), max(calls)))
    with open(out_path, "w", encoding="utf-8") as f:
        f.write("\n".join(lines) + "\n")
    log("握手期帧率报告 → %s（FRM n=%d）" % (out_path, len(emu)))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--room", required=True)
    ap.add_argument("--monitor", type=int, default=180)
    ap.add_argument("--tag", default="HSPROBE-01")
    # N1：三个具名默认关 flag（握手期 FRM 阶段化采集 / mode A BF1 门对齐 / PC 导航）
    ap.add_argument("--fps", action="store_true",
                    help="活 logcat 抓 FRM emuFps/callsFps，阶段化落盘 handshake_fps.md")
    ap.add_argument("--bf1", action="store_true",
                    help="PC env 与 launch_mode_a_bf1.py 逐字对齐（含 MGBAX_SIO_MASTER_ECHO=1）")
    ap.add_argument("--pc-nav", action="store_true",
                    help="PC 侧写 nav_at=1500 2（与 mode A 同导航输入）")
    ap.add_argument("--serial", default="emulator-5554", help="APP 设备 serial（--fps 活 logcat 用）")
    ap.add_argument("--skip-present", action="store_true",
                    help="setprop debug.mgbax.skip_present=1（诊断：跳过 presentFrame 判 EGL 读回阻塞）")
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
    if a.bf1:
        # N1: 与 launch_mode_a_bf1.py:24-31 + cloud2p mode A 逐字对齐。
        # 绝不能漏 MGBAX_SIO_MASTER_ECHO=1（J1：漏开→主机发 8FFF 无回环→卡 st2）。
        env.update({
            "MGBAX_SIO_MASTER_ECHO": "1",
            "MGBAX_RH_VERBOSE": "1",
            "MGBAX_LINK_MODE": "A",
            "MGBAX_SIO_LOG": "1",
            "MGBAX_LINK_DIAG": "1",
            "MGBAX_DIRECT_LOCAL_FIRST": "1",
            "MGBAX_ROM_PATH": PC_ROM,
            "MGBAX_GNP_RUN_DIR": gdir,
        })
        log("BF1 门对齐: SIO_MASTER_ECHO=1 RH_VERBOSE=1 MODE=A (J1 漏开会卡 st2)")
    # 不改系统 TEMP/TMP（改了会导致 Windows CreateProcess 拒绝/EDR 拦截）；
    # 隔离靠独立 cwd(ROOT) + 独立 keys/lobby 目录(D.Inst) + 不同账号/uuid。
    pc = D.Inst("PC", pc_tmp, pc_keys, nav_on=a.pc_nav)
    if a.pc_nav:
        # N1: 与 cloud2p:2487-2489 对齐，PC 侧走与 mode A 同导航输入
        with open(os.path.join(pc_keys, "nav_at"), "w") as f:
            f.write("1500 2")
        log("PC nav_at=1500 2（与 mode A 对齐）")
    pc.stdout = os.path.join(gdir, "pc_stdout.log")
    pc.proc = subprocess.Popen([EXE, PC_ROM], cwd=ROOT, env=env,
                               stdout=open(pc.stdout, "w"), stderr=subprocess.STDOUT)
    pc.pid = pc.proc.pid
    log("PC 启动 pid=%d room=%s AUTOLINK=%s:…:%s" % (pc.pid, a.room, PC_ACC.split(":")[0], a.room))

    if a.skip_present:
        subprocess.run([ADB, "-s", a.serial, "shell", "setprop",
                        "debug.mgbax.skip_present", "1"], capture_output=True)
        rb = subprocess.run([ADB, "-s", a.serial, "shell", "getprop",
                             "debug.mgbax.skip_present"], capture_output=True, text=True)
        log("诊断门 skip_present=1 readback=%s（跳过 presentFrame 判 EGL 读回阻塞）" %
            (rb.stdout or "").strip())

    # N1: --fps 起活 logcat（避免 -t600 被 SIO/PEEK 冲掉），全程落盘握手期 FRM
    app_log = os.path.join(gdir, "app_link_startup.log")
    logcat_proc = None
    if a.fps:
        import threading
        def _pump_logcat():
            nonlocal logcat_proc
            try:
                logcat_proc = subprocess.Popen(
                    [ADB, "-s", a.serial, "logcat", "-v", "threadtime"],
                    stdout=open(app_log, "w"), stderr=subprocess.STDOUT)
                logcat_proc.wait()
            except Exception as e:
                log("logcat pump 异常: %s" % e)
        threading.Thread(target=_pump_logcat, daemon=True).start()
        log("FRM 采集: 活 logcat -s %s → %s" % (a.serial, app_log))

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
    if a.fps:
        if logcat_proc:
            try:
                logcat_proc.terminate()
            except Exception:
                pass
        time.sleep(1)
        write_fps_report(app_log, os.path.join(gdir, "handshake_fps.md"), t0, time.time())
    return 0


if __name__ == "__main__":
    sys.exit(main())
