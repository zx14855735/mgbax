# -*- coding: utf-8 -*-
r"""mode A（字过网）+ BF1（主机 8FFF 回环）一键 launch（父会话 2026-11-25）。

教训：GPUHOST-MODEA-01 漏开 MGBAX_SIO_MASTER_ECHO（门=0）→ APP 主机发 8FFF 无回环
→ 握手字失配 → 卡 st2（J1 实证）。本脚本固化 mode A 完整门配置，杜绝漏门。

前提：
  - emulator 已用 `-gpu host` 启动（APP 60fps；若用 angle_indirect 则 1fps 拖垮字率）
  - APK 已装（cloud2p 从不 install）
  - ROM/sav 在 /sdcard/Download/

用法：
  python tools/launch_mode_a_bf1.py --tag MODEA-BF1-01 [--shift 1] [--no-intro-keypush]
"""
import argparse, os, subprocess, sys

BASE = r"D:\mgba-android-version"
TOOLS = os.path.join(BASE, "tools")
PY = r"C:\Users\lenovo\AppData\Local\Programs\Python\Python312\python.exe"
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"
BOOT_SAV = r"D:\gen8\rom_b.sav"   # 干净母本 1AD3BC83 party00D5

# mode A 完整门配置（7 数据门全关 + BF1 + RH_VERBOSE 打点）
GATES = [
    "MGBAX_NETGATE_LOG=1",
    "MGBAX_RH_OFF=1", "MGBAX_LINK_HSBYPASS=0", "MGBAX_LINK_FORCEHS=0",
    "MGBAX_HS_HOLD=0", "MGBAX_2222_STICKY=0", "MGBAX_BUS_HS_PRESERVE=0",
    "MGBAX_LINK_REARM=0",
    "MGBAX_SIO_MASTER_ECHO=1",   # ★ BF1：绝不再漏
    "MGBAX_RH_VERBOSE=1",        # 相位打点（看 sc/rc/sic/8FFF）
]


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", required=True)
    ap.add_argument("--shift", type=int, default=0, help="MGBAX_PEER_SHIFT（E1 α，slot0 落位）")
    ap.add_argument("--no-intro-keypush", action="store_true")
    ap.add_argument("--self-emulator", action="store_true",
                    help="让 driver 自起 emulator（新 -gpu host 生效）；默认复用")
    ap.add_argument("--handshake-no-barrier", action="store_true",
                    help="握手期跳过 netLinkBarrier(400) 自伤帧率门（默认关，A/B 用）")
    ap.add_argument("--attach-existing", action="store_true",
                    help="E1-60FPS: 跳过 APP 重建，接管已运行 APP 保留 60fps EGL（需 --app-nav）")
    ap.add_argument("--runsec", type=int, default=600)
    a = ap.parse_args()

    # 前置：设备 + APK + CPU（--self-emulator 时 driver 自己起 emulator，跳过设备检查）
    if not a.self_emulator:
        r = subprocess.run([ADB, "get-state"], capture_output=True, text=True)
        if "device" not in r.stdout:
            print("FATAL: 设备未就绪"); return 2
        pm = subprocess.run([ADB, "shell", "pm", "path", "io.mgba.android"], capture_output=True, text=True)
        if "io.mgba.android" not in pm.stdout:
            print("FATAL: APK 未安装"); return 2
    cpu = subprocess.check_output(["powershell", "-NoProfile", "-Command",
        "(Get-CimInstance Win32_Processor|Measure-Object LoadPercentage -Average).Average"], text=True).strip()
    if float(cpu) > 70:
        print("FATAL: CPU=%s>70" % cpu); return 2

    gdir = os.path.join(BASE, ".zcode-tmp", "cloud2p", a.tag)
    os.makedirs(gdir, exist_ok=True)
    lpath = os.path.join(BASE, ".zcode-tmp", "cloud2p", a.tag + "_run.out")
    gates = list(GATES)
    if a.handshake_no_barrier:
        gates.append("MGBAX_HANDSHAKE_NO_BARRIER=1")
    if a.shift:
        gates.append("MGBAX_PEER_SHIFT=%d" % a.shift)
    args = [PY, os.path.join(TOOLS, "cloud2p_avd.py"),
            "--tag", a.tag, "--mode", "A", "--runsec", str(a.runsec), "--app-nav",
            "--app-sav", BOOT_SAV]
    if a.attach_existing:
        args += ["--attach-existing"]
    if not a.self_emulator:
        args += ["--no-emulator", "--serial", "emulator-5554"]
    else:
        args += ["--serial", "emulator-5554"]
    args += [
            "--env", "MGBAX_GNP_RUN_DIR=" + gdir]
    for g in gates:
        args += ["--env", g]
    env = os.environ.copy()
    env["PATH"] = (r"D:\Android\Sdk\emulator;D:\Android\Sdk\platform-tools;C:\msys64\usr\bin;" +
                   env.get("PATH", ""))
    env["PYTHONPATH"] = TOOLS
    if not a.no_intro_keypush:
        env["MGBAX_INTRO_KEYPUSH"] = "1"
    f = open(lpath, "w", encoding="utf-8")
    p = subprocess.Popen(args, cwd=TOOLS, env=env, stdout=f, stderr=subprocess.STDOUT)
    print("PID=%d TAG=%s mode=A BF1=ON shift=%d CPU=%s LOG=%s" %
          (p.pid, a.tag, a.shift, cpu, lpath))
    print("灰区标注：受控输入 + master_echo 主机自回环，非纯零注入，不进 CROSSED 裁决")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
