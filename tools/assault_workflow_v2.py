# -*- coding: utf-8 -*-
r"""联机攻坚工作流 v2（2026-11-24 重构）—— 基于 ZEROE2E-08 决定性新证据。

v1 (assault_workflow.py) 的致命缺陷：用 --no-emulator 直调 cloud2p 时，未做
`build-win/dist/mGBA.exe` 的 copy 前置 → PC 从未真正启动 → 之前所有 ZEROE2E run 的
8FFF/B9A0/LINKUP 全 0 是"没有对端"的假象，非握手失败证据。

v2 固化：
  1. 起跑前强制 copy build-win/mGBA.exe → dist/ 并 md5 校验（PC 真启动前提）
  2. 7 数据门全关（--env 显式覆盖，纯零注入）
  3. 可选 INTRO_KEYPUSH（受控输入辅助，非数据注入）
  4. 结果到达后逐文件严格判读（8FFF/B9A0/ST idx/LINKUP + PC lobby P2P）

诚实：门 FAIL/0/9/CROSSED 从未产出。入口轴已通、链路层 P2P 46ms 已通（首次），
握手层 st=2 自锁是架构级硬墙（mode B 只传按键、SIO 字不过网）。本工作流产出诊断证据，
非 CROSSED、不翻门、不造假。

用法：
  python tools/assault_workflow_v2.py --tag <TAG> --launch [--intro-keypush]
  python tools/assault_workflow_v2.py --tag <TAG> --watch --pid <PID>
  python tools/assault_workflow_v2.py --tag <TAG> --judge
"""
import argparse, hashlib, os, shutil, subprocess, sys, time

BASE = r"D:\mgba-android-version"
TOOLS = os.path.join(BASE, "tools")
CLOUD_DIR = os.path.join(BASE, ".zcode-tmp", "cloud2p")
PY = r"C:\Users\lenovo\AppData\Local\Programs\Python\Python312\python.exe"
PC_FRESH = os.path.join(BASE, "build-win", "mGBA.exe")
PC_DIST = os.path.join(BASE, "build-win", "dist", "mGBA.exe")
BOOT_SAV = r"D:\gen8\rom_b.sav"   # 干净母本 1AD3BC83 party00D5
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"

# 7 数据门全关（纯零注入；PC 真启动 + 不同账号同房）
ZERO_GATES = [
    "MGBAX_RH_OFF=1", "MGBAX_LINK_HSBYPASS=0", "MGBAX_LINK_FORCEHS=0",
    "MGBAX_HS_HOLD=0", "MGBAX_2222_STICKY=0",
    "MGBAX_BUS_HS_PRESERVE=0", "MGBAX_LINK_REARM=0",
]


def log(m):
    print("[WF2 %s] %s" % (time.strftime("%H:%M:%S"), m), flush=True)


def md5(p):
    try:
        return hashlib.md5(open(p, "rb").read()).hexdigest()
    except Exception:
        return "MISSING"


def ensure_pc_exe():
    """★ v1 致命缺陷修复：dist/mGBA.exe 缺失 → PC 从不启动。强制 copy + md5 校验。"""
    want = md5(PC_FRESH)
    if md5(PC_DIST) != want:
        shutil.copy2(PC_FRESH, PC_DIST)
    got = md5(PC_DIST)
    ok = (got == want and got != "MISSING")
    log("PC exe dist=%s fresh=%s %s" % (got[:12], want[:12], "OK" if ok else "FAIL"))
    return ok


def cpu_ok():
    try:
        o = subprocess.check_output(["powershell", "-NoProfile", "-Command",
             "(Get-CimInstance Win32_Processor|Measure-Object LoadPercentage -Average).Average"],
             text=True).strip()
        c = float(o)
        log("CPU=%.1f%% %s" % (c, "OK" if c <= 70 else "FAIL>70"))
        return c <= 70
    except Exception:
        return True


def preflight():
    log("=== PREFLIGHT ===")
    if not cpu_ok():
        return False
    if not ensure_pc_exe():
        return False
    r = subprocess.run([ADB, "get-state"], capture_output=True, text=True)
    if "device" not in r.stdout:
        log("FAIL: 设备未就绪")
        return False
    pm = subprocess.run([ADB, "shell", "pm", "path", "io.mgba.android"], capture_output=True, text=True)
    if "io.mgba.android" not in pm.stdout:
        log("FAIL: APK 未安装（driver 从不 install）")
        return False
    log("sav md5=%s (期望 1ad3bc83)" % md5(BOOT_SAV)[:12])
    return True


def launch(tag, intro_keypush, master_echo=False, phase_align=False, state_apply=False, send_diag=False, nav_msgbox=False):
    log("=== LAUNCH %s ===" % tag)
    gdir = os.path.join(CLOUD_DIR, tag)
    os.makedirs(gdir, exist_ok=True)
    lpath = os.path.join(CLOUD_DIR, tag + "_run.out")
    args = [PY, os.path.join(TOOLS, "cloud2p_avd.py"),
            "--tag", tag, "--mode", "B", "--runsec", "900", "--app-nav",
            "--no-emulator", "--serial", "emulator-5554", "--pathb-pc-nav", "--force-full-menu",
            "--app-sav", BOOT_SAV,
            "--env", "MGBAX_NETGATE_LOG=1",
            "--env", "MGBAX_GNP_RUN_DIR=" + gdir]
    for g in ZERO_GATES:
        args += ["--env", g]
    env = os.environ.copy()
    env["PATH"] = (r"D:\Android\Sdk\emulator;D:\Android\Sdk\platform-tools;C:\msys64\usr\bin;" +
                   env.get("PATH", ""))
    env["PYTHONPATH"] = TOOLS
    if master_echo:
        args += ["--env", "MGBAX_SIO_MASTER_ECHO=1"]  # BF1 主机字回环门（真字搬运非造字）
        log("MGBAX_SIO_MASTER_ECHO=1（BF1 主机握手字真自回环·门开验证）")
    if phase_align:
        # BG1: P5 相位错格门组合——CMD_HARD 优先(自动让位 PHASE_GATE/sioAlignCmdPhase),
        # CMD_FRAMEALIGN=0 避免写序冲突, CS_FORGE 保持开(校验和兜底)。
        args += ["--env", "MGBAX_CMD_HARD=1", "--env", "MGBAX_CMD_FRAMEALIGN=0",
                 "--env", "MGBAX_PHASE_GATE=0", "--env", "MGBAX_SYNCIDX=0",
                 "--env", "MGBAX_CS_FORGE=1"]
        log("P5相位对齐门: CMD_HARD=1 CMD_FRAMEALIGN=0 PHASE_GATE=0 SYNCIDX=0 CS_FORGE=1")
    if nav_msgbox:
        # P-ISYNC-1 导航试参：开 msgbox 驱动 A 脉冲，推过 mode B 可见核卡住的柜台对话框
        # （mgba_mobile.c navMsgboxEnabled 默认关，旧固定 A 脉冲推不动 msgbox）。
        args += ["--env", "MGBAX_NAV_MSGBOX=1"]
        log("MGBAX_NAV_MSGBOX=1（可见核 msgbox 驱动导航，受控输入非造数据）")
    if send_diag:
        # P-ISYNC-1 阶段2诊断：maybeSendInitialState 各 return 点 fprintf 直写进 pc_stdout.log
        args += ["--env", "MGBAX_ISYNC_SEND_DIAG=1"]
        log("MGBAX_ISYNC_SEND_DIAG=1（TYPE_STATE发送侧诊断打点，非游戏态）")
    if state_apply:
        # P-ISYNC-1 阶段2：开三端同名门 MGBAX_ISYNC_STATE_APPLY，让 mode B 下
        # TYPE_STATE 对端真 savestate 种子到达时核未建好也有界重试 applied。
        args += ["--env", "MGBAX_ISYNC_STATE_APPLY=1", "--isync-state-apply"]
        log("MGBAX_ISYNC_STATE_APPLY=1（对端真savestate种子 applied 门，非造数据）")
    if intro_keypush:
        env["MGBAX_INTRO_KEYPUSH"] = "1"   # 受控输入辅助（非数据注入）
        log("MGBAX_INTRO_KEYPUSH=1（受控输入灰区，标注非纯玩家自然操作）")
    f = open(lpath, "w", encoding="utf-8")
    p = subprocess.Popen(args, cwd=TOOLS, env=env, stdout=f, stderr=subprocess.STDOUT)
    log("PID=%d TAG=%s LOG=%s" % (p.pid, tag, lpath))
    return p


def watch(tag, pid):
    log("=== WATCH %s ===" % tag)
    lpath = os.path.join(CLOUD_DIR, tag + "_run.out")
    t0 = time.time()
    while time.time() - t0 < 900:
        time.sleep(15)
        alive = subprocess.run(["powershell", "-NoProfile", "-Command",
            "Get-Process -Id %d -ErrorAction SilentlyContinue|ForEach-Object{$_.Id}" % pid],
            capture_output=True, text=True).stdout.strip()
        if not alive:
            log("进程退出，结果到达闸门：暂停补派，父会话独占判读")
            return True
        hit = ""
        if os.path.exists(lpath):
            import re
            txt = open(lpath, encoding="utf-8", errors="ignore").read()[-3000:]
            m = re.search(r"reason=(\w+)", txt)
            hit = m.group(1) if m else ""
        if hit in ("timeout", "app-dead"):
            log("导航 %s，等待采样收尾" % hit)
    log("WATCH 超时(900s)")
    return False


def judge(tag):
    log("=== JUDGE %s ===" % tag)
    d = os.path.join(CLOUD_DIR, tag)
    out = []
    out.append("# %s 严格判读（零数据注入裁决级）" % tag)
    out.append("")
    out.append("> 门 FAIL/0/9/CROSSED 从未产出。入口轴+链路层进展≠翻门。")
    # 逐文件 8FFF/B9A0/ST/LINKUP
    for fn in ("app_link_startup.log", "app_link_timeline.log", "app_logcat_full.log"):
        p = os.path.join(d, fn)
        if not os.path.exists(p):
            out.append("%s : MISSING" % fn)
            continue
        txt = open(p, encoding="utf-8", errors="replace").read()
        c = {k: txt.count(k) for k in ("8FFF", "B9A0", "ST idx=", "LINKUP_OK")}
        out.append("%s : 8FFF=%d B9A0=%d ST=%d LINKUP_OK=%d" %
                   (fn, c["8FFF"], c["B9A0"], c["ST idx="], c["LINKUP_OK"]))
    # PC lobby P2P
    lp = os.path.join(d, "pc_tmp", "mgba_lobby_debug.log")
    if os.path.exists(lp):
        txt = open(lp, encoding="utf-8", errors="replace").read()
        for key in ("p2p-rtt", "advertised relay", "peerSeen", "2->4"):
            out.append("PC lobby %s=%d" % (key, txt.count(key)))
    rp = os.path.join(CLOUD_DIR, tag + "_run.out")
    if os.path.exists(rp):
        for ln in open(rp, encoding="utf-8", errors="ignore").read().splitlines()[-12:]:
            out.append("- " + ln[:160])
    vp = os.path.join(BASE, ".zcode-tmp", tag + "-VERDICT.md")
    open(vp, "w", encoding="utf-8").write("\n".join(out))
    log("判读落盘 %s" % vp)
    print("\n".join(out[:20]))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", required=True)
    ap.add_argument("--launch", action="store_true")
    ap.add_argument("--intro-keypush", action="store_true")
    ap.add_argument("--master-echo", action="store_true", help="BF1 主机握手字真自回环门开验证")
    ap.add_argument("--phase-align", action="store_true", help="BG1 P5相位对齐门组合(CMD_HARD等)")
    ap.add_argument("--state-apply", action="store_true", help="P-ISYNC-1阶段2: MGBAX_ISYNC_STATE_APPLY=1, mode B下对端真savestate种子applied(非造数据)")
    ap.add_argument("--send-diag", action="store_true", help="P-ISYNC-1阶段2诊断: MGBAX_ISYNC_SEND_DIAG=1, TYPE_STATE发送侧各return点fprintf直写")
    ap.add_argument("--nav-msgbox", action="store_true", help="P-ISYNC-1导航试参: MGBAX_NAV_MSGBOX=1, 可见核msgbox驱动A脉冲推柜台对话框(受控输入)")
    ap.add_argument("--watch", action="store_true")
    ap.add_argument("--pid", type=int, default=0)
    ap.add_argument("--judge", action="store_true")
    a = ap.parse_args()
    if a.launch:
        if not preflight():
            return 2
        launch(a.tag, a.intro_keypush, a.master_echo, a.phase_align, a.state_apply, a.send_diag, a.nav_msgbox)
        return 0
    if a.watch:
        return 0 if watch(a.tag, a.pid) else 1
    if a.judge:
        judge(a.tag)
        return 0
    return 1


if __name__ == "__main__":
    sys.exit(main())
