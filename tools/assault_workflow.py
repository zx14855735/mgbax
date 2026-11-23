# -*- coding: utf-8 -*-
r"""联机持续攻坚工作流（父会话独占串行执行；2026-11-23 立）。

纪律（AGENTS §1/§2/§2.5/§3）：
  * 每轮新 TAG，禁复用同 tag 并发；先查无在途 cloud2p/qemu 进程。
  * CPU ≤70% 闸；单 AVD（emulator-5554）；APK 预检（cloud2p 从不 install，老坑）。
  * 输入层已修复（AVDWIPE-03）：-wipe-data + 禁快照 + 180s 完整导航窗口。
  * 结果到达闸门：等进程退出、日志停增后，父会话独占逐文件判读。
诚实：门 FAIL / 对手 0/9 / 零注入 CROSSED 从未产出，一分不动。
      本工作流产出为入口轴 + 块闭合诊断证据，非 CROSSED、不翻门、不造假。

用法：
  python tools/assault_workflow.py --tag ASSAULT-01            # 起跑（复用现有 emulator）
  python tools/assault_workflow.py --tag ASSAULT-01 --judge     # 结果到达后判读
  python tools/assault_workflow.py --tag ASSAULT-01 --watch     # 阻塞等进程退出
"""
import argparse, hashlib, os, re, subprocess, sys, time

BASE = r"D:\mgba-android-version"
TOOLS = os.path.join(BASE, "tools")
CLOUD_DIR = os.path.join(BASE, ".zcode-tmp", "cloud2p")
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"
EMULATOR = r"D:\Android\Sdk\emulator\emulator.exe"
PKG = "io.mgba.android"
APP_APK = os.path.join(BASE, "android", "app", "build", "outputs", "apk", "debug", "app-debug.apk")
APP_ROM = os.path.join(BASE, "rom.gba")
PC_EXE_FRESH = os.path.join(BASE, "build-win", "mGBA.exe")
PC_EXE_DIST = os.path.join(BASE, "build-win", "dist", "mGBA.exe")


def log(msg):
    print("[WF %s] %s" % (time.strftime("%H:%M:%S"), msg), flush=True)


def md5(path):
    try:
        return hashlib.md5(open(path, "rb").read()).hexdigest()
    except Exception:
        return "MISSING"


def cpu_pct():
    try:
        out = subprocess.check_output(
            ["powershell", "-NoProfile", "-Command",
             "(Get-CimInstance Win32_Processor|Measure-Object LoadPercentage -Average).Average"],
            text=True).strip()
        return float(out)
    except Exception:
        return -1.0


def running_procs():
    try:
        out = subprocess.check_output(
            ["powershell", "-NoProfile", "-Command",
             "Get-CimInstance Win32_Process | Where-Object{$_.Name -match 'emulator|qemu|cloud2p_avd'} | "
             "ForEach-Object{\"$($_.ProcessId):$($_.Name)\"}"],
            text=True)
        return [x for x in out.split() if x]
    except Exception:
        return []


def adb(*argv):
    return subprocess.run([ADB] + list(argv), capture_output=True, text=True)


def preflight(tag):
    log("=== PREFLIGHT %s ===" % tag)
    rundir = os.path.join(CLOUD_DIR, tag)
    if os.path.exists(rundir) and os.listdir(rundir):
        log("WARN: rundir %s 已有内容(可能复用旧 tag)，请换新 tag" % tag)
    c = cpu_pct()
    log("CPU=%.1f%% %s" % (c, "OK" if 0 <= c <= 70 else "FAIL>70 禁止起跑"))
    if c > 70:
        return False, "CPU>70"
    procs = running_procs()
    log("在途进程: %s" % (procs or "无"))
    emu = [p for p in procs if "emulator" in p or "qemu" in p]
    cloud = [p for p in procs if "cloud2p" in p]
    if cloud:
        return False, "有在途 cloud2p 进程（同 tag 铁律）"
    log("ROM md5=%s  APK md5=%s" % (md5(APP_ROM), md5(APP_APK)))
    log("PC dist md5=%s  fresh md5=%s" % (md5(PC_EXE_DIST), md5(PC_EXE_FRESH)))
    # 对齐 PC exe（老坑：dist 可能旧无钩子）
    if md5(PC_EXE_DIST) != md5(PC_EXE_FRESH):
        import shutil
        shutil.copy2(PC_EXE_FRESH, PC_EXE_DIST)
        log("已用 fresh PC exe 覆盖 dist -> %s" % md5(PC_EXE_DIST))
    st = adb("get-state")
    if "device" not in st.stdout:
        return False, "emulator-5554 未就绪: %s" % st.stdout.strip()
    pm = adb("shell", "pm", "path", PKG)
    if PKG not in pm.stdout:
        log("APK 未安装，安装中…")
        ir = adb("install", "-r", APP_APK)
        log("install rc=%d %s" % (ir.returncode, (ir.stdout + ir.stderr)[-120:]))
        if ir.returncode != 0:
            return False, "APK install 失败"
    log("APK path=%s" % pm.stdout.strip())
    return True, "OK"


def launch(tag, app_sav=None, pc_sav=None):
    log("=== LAUNCH %s ===" % tag)
    rundir = os.path.join(CLOUD_DIR, tag)
    os.makedirs(rundir, exist_ok=True)
    log_path = os.path.join(CLOUD_DIR, tag + "_run.out")
    args = [
        sys.executable, os.path.join(TOOLS, "cloud2p_avd.py"),
        "--tag", tag, "--mode", "B", "--runsec", "180", "--app-nav",
        "--no-emulator", "--serial", "emulator-5554",
        "--pathb-pc-nav",
        "--env", "MGBAX_NETGATE_LOG=1",
        "--env", "MGBAX_GNP_RUN_DIR=" + rundir,
    ]
    # AD6 硬前置：--app-sav 只在 --app-nav 生效；不传则 club 档不会推送、组合白跑。
    # BUGFIX(AD5-COMBO-01)：driver cwd=tools/，相对路径会解析失败→必须转绝对路径。
    if app_sav:
        app_sav = os.path.abspath(app_sav)
        args += ["--app-sav", app_sav]
        log("--app-sav=%s md5=%s" % (app_sav, md5(app_sav)))
    if pc_sav:
        pc_sav = os.path.abspath(pc_sav)
        args += ["--sav", pc_sav]
        log("--sav(PC)=%s md5=%s" % (pc_sav, md5(pc_sav)))
    env = os.environ.copy()
    env["PATH"] = (r"C:\msys64\usr\bin;" + r"D:\Android\Sdk\emulator;" +
                   r"D:\Android\Sdk\platform-tools;" + env.get("PATH", ""))
    env["PYTHONPATH"] = TOOLS
    env["MGBAX_AVD_WIPE"] = "1"  # 全新 userdata（输入层修复）
    # AD2 门：观测口径适配（读真 PEEK），受控输入须标注，不进 CROSSED 裁决。
    if os.environ.get("MGBAX_NAV_SPAWN_AT_SEAT", "0") == "1":
        env["MGBAX_NAV_SPAWN_AT_SEAT"] = "1"
        log("MGBAX_NAV_SPAWN_AT_SEAT=1（构造档已到座位·观测口径适配·灰区标注）")
    with open(log_path, "w", encoding="utf-8") as f:
        p = subprocess.Popen(args, cwd=TOOLS, env=env, stdout=f, stderr=subprocess.STDOUT)
    log("PID=%d TAG=%s LOG=%s" % (p.pid, tag, log_path))
    return p, log_path


def watch(tag, pid_int):
    log("=== WATCH %s pid=%d ===" % (tag, pid_int))
    log_path = os.path.join(CLOUD_DIR, tag + "_run.out")
    deadline = time.time() + 480  # 8 分钟硬墙
    last_size = -1
    stable = 0
    while time.time() < deadline:
        time.sleep(10)
        alive = False
        try:
            out = subprocess.check_output(
                ["powershell", "-NoProfile", "-Command",
                 "Get-Process -Id %d -ErrorAction SilentlyContinue | ForEach-Object{$_.Id}" % pid_int],
                text=True)
            alive = bool(out.strip())
        except Exception:
            pass
        try:
            size = os.path.getsize(log_path)
        except Exception:
            size = -1
        if size == last_size:
            stable += 1
        else:
            stable = 0
        last_size = size
        if not alive:
            log("进程退出，日志停增。结果到达闸门：暂停一切补派，父会话独占判读。")
            return True
        if stable >= 3 and _log_has_end(log_path):
            log("日志出现结束标记且停增（进程可能拖延），建议判读。")
            return True
    log("WATCH 超时(8min)，进程仍在——按结果到达闸门不得并发，请人工核查。")
    return False


def _log_has_end(path):
    try:
        txt = open(path, encoding="utf-8", errors="ignore").read()
        return "结束" in txt[-2000:] or "=== END" in txt[-2000:]
    except Exception:
        return False


def judge(tag):
    log("=== JUDGE %s ===" % tag)
    rundir = os.path.join(CLOUD_DIR, tag)
    log_path = os.path.join(CLOUD_DIR, tag + "_run.out")
    app_log = os.path.join(rundir, "app_link_startup.log")
    lines = []
    lines.append("# %s 工作流判读（父会话独占·结果到达闸门后）" % tag)
    lines.append("")
    lines.append("> 门 FAIL / 对手 0/9 / 零注入 CROSSED 从未产出，一分不动。")
    lines.append("> 入口轴 + 块闭合诊断证据，非 CROSSED、不翻门。")
    lines.append("")
    # 输入层统计（Held/FrameKeys 比值）
    if os.path.exists(app_log):
        r = subprocess.run([sys.executable, os.path.join(BASE, ".zcode-tmp", "held_frame_stats.py"),
                            "--log", app_log], capture_output=True, text=True)
        lines.append("## 输入层（held_frame_stats.py）")
        lines.append("```")
        lines.append((r.stdout + r.stderr)[-1500:])
        lines.append("```")
    else:
        lines.append("## 输入层：app_link_startup.log 缺失（未产出）")
    # 里程碑
    lines.append("## 里程碑（run.out 末段逐文件判读）")
    if os.path.exists(log_path):
        txt = open(log_path, encoding="utf-8", errors="ignore").read().splitlines()
        pats = ["ROM 加载确认", "APP-NAV 结束", "LINKUP 达成", "POST-LINKUP",
                "final_PC=", "multi_PC=", "app_link_seen", "结束"]
        hits = [ln for ln in txt if any(p in ln for p in pats)]
        for ln in hits[-16:]:
            lines.append("- " + ln[:180])
    verdict_path = os.path.join(BASE, ".zcode-tmp", tag + "-VERDICT.md")
    open(verdict_path, "w", encoding="utf-8").write("\n".join(lines))
    log("判读落盘 %s" % verdict_path)
    print("\n".join(lines[-12:]))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", required=True)
    ap.add_argument("--launch", action="store_true")
    ap.add_argument("--watch", action="store_true")
    ap.add_argument("--judge", action="store_true")
    ap.add_argument("--pid", type=int, default=0)
    ap.add_argument("--app-sav", default=None, help="APP club 预置存档（受控输入·灰区标注）")
    ap.add_argument("--sav", default=None, help="PC 端差分存档")
    a = ap.parse_args()
    if a.launch:
        ok, why = preflight(a.tag)
        log("PREFLIGHT %s: %s" % ("PASS" if ok else "FAIL", why))
        if not ok:
            return 2
        if a.app_sav and not os.path.exists(a.app_sav):
            log("FAIL: --app-sav 不存在 %s" % a.app_sav)
            return 2
        p, _ = launch(a.tag, a.app_sav, a.sav)
        print("PID=%d" % p.pid)
        return 0
    if a.watch:
        return 0 if watch(a.tag, a.pid) else 1
    if a.judge:
        judge(a.tag)
        return 0
    print("需 --launch / --watch --pid N / --judge 之一")
    return 1


if __name__ == "__main__":
    sys.exit(main())
