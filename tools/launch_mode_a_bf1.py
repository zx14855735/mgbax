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
    ap.add_argument("--nav-accept-st4", action="store_true",
                    help="F1: st4/pc2 真时接受 LINKUP 停 tap A，让块交换自跑（默认关）")
    ap.add_argument("--b7-verbose", action="store_true",
                    help="F1: 开 APP 侧 [B7BLK] 块打点（sc/rc/sq0/pos/cnt/brs），定位 APP 卡点")
    ap.add_argument("--label-any", action="store_true",
                    help="G1 切片乙: 三端宽松 label 取字，治 want/got 差一（默认关，A/B 用）")
    ap.add_argument("--btlcfg", action="store_true",
                    help="PUSH-VALUE-ROOT: 开三端块字路由门 MGBAX_LINK_BTLCFG=1，让 PC/mobile 真推 BBBB/8888/party 块字（默认关，A/B 用）")
    ap.add_argument("--route-a", action="store_true",
                    help="J1: 路线A完整配置——恢复 2222_sticky=1(源码默认,被GATES误关)+BTLCFG=1，"
                         "让 APP 真 2222 走块路由出网→PC 收 2222→InitBlockSend→推真 BBBB/8888。默认关。")
    ap.add_argument("--netparty", action="store_true",
                    help="S1/B2: 开 GNP 带外 party 邮槽门 MGBAX_NET_PARTY_MAILBOX=1，"
                         "TYPE_PARTY 帧写 IWRAM 邮槽→ROM 直装 gEnemyParty（需匹配 ROM + 冷启动前 setprop）。默认关。")
    ap.add_argument("--pc-exe", default=None,
                    help="显式指定 PC exe 路径（具名 MGBAX_PC_EXE），用于冻结/避开被占用产物。默认 None=driver 默认。")
    ap.add_argument("--no-direct", action="store_true",
                    help="U2/A-B: 关 MGBAX_DIRECT_LOCAL_FIRST=0，让 PC 走 CloudLink serve()（含 party_mailbox 轮询）；默认关。")
    ap.add_argument("--no-seat-walk", action="store_true",
                    help="B2: 跳过 LINKUP 后 APP 座位走位（卡在 pos(5,8)）——GNP 带外 party 不依赖物理座位；"
                         "透传 driver --no-app-seat-walk。默认关。")
    ap.add_argument("--pc-sav", default=None,
                    help="B2: PC 端 sav（透传 driver --sav）。必须用有 6 只 party 的母本（如 rom_pc_diff.sav "
                         "party0=0006），否则 sioBuildNetPartyMailbox 因 gPlayerPartyCount=0 返回空、TYPE_PARTY 不发。默认 None=driver 默认。")
    ap.add_argument("--gnp-manifest-src", action="store_true",
                    help="V1: 用 gnp_manifest nm 实测绝对地址读真 gPlayerParty（修 SIO_EW delta 偏 +0xE8 致 cnt=0）。默认关。")
    ap.add_argument("--confirm-a", action="store_true",
                    help="W2: P2 linkup 确认相位机——按 mm 3→0 发两次 A 边沿（替代盲 tap），adv 0→1 判定。默认关。")
    ap.add_argument("--seat-assist", action="store_true",
                    help="X1: 单开 SEAT_ASSIST(不 GRAY_ALL)手建 seat task→CB2_InitBattle，让 ROM NetParty 钩子"
                         "在 case1 rem 门前 Apply 真 party（不触 rem 红线）。默认关。")
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
    if a.nav_accept_st4:
        # F1: driver 自身读 os.environ（非 PC env），需在 launch 进程环境里设
        os.environ["MGBAX_NAV_ACCEPT_ST4"] = "1"
    if a.confirm_a:
        # W2: P2 相位机门（driver 自身读 os.environ），覆盖 NAV_ACCEPT_ST4
        os.environ["MGBAX_NAV_CONFIRM_A_ONCE"] = "1"
    if a.seat_assist:
        # X1: 单开 seat-assist（不 GRAY_ALL，避免 GZ7 rem-restore 红线）
        gates.append("MGBAX_SEAT_ASSIST=1")
    if a.b7_verbose:
        gates.append("MGBAX_B7_VERBOSE=1")
    if a.label_any:
        gates.append("MGBAX_LABEL_ANY=1")
    if a.btlcfg:
        # PUSH-VALUE-ROOT: 块字路由门，PC sioBlockOutWord / mobile 对偶默认早退返回
        # local(=0000)，块字从未进推送流。开=从 gLink.sendQueue 队头推真 BBBB/8888/party。
        gates.append("MGBAX_LINK_BTLCFG=1")
    if a.route_a:
        # J1 源码终审: GATES 误把源码默认开的 2222_sticky 关成 0，致 APP 真 2222
        # 从未出网→PC 收不到→不 InitBlockSend→sendQueue 空→推 0000。恢复 1 并配
        # BTLCFG=1(2222 走 sioBlockOutWord 路由的硬门)。只搬真字非伪造。
        gates = [g for g in gates if not g.startswith("MGBAX_2222_STICKY=")]
        gates.append("MGBAX_2222_STICKY=1")
        gates.append("MGBAX_LINK_BTLCFG=1")
    if a.netparty:
        gates.append("MGBAX_NET_PARTY_MAILBOX=1")
    if a.no_direct:
        # driver :2255 默认钉 MGBAX_DIRECT_LOCAL_FIRST=1 → PC 走 DirectLink，
        # 绕过 CloudLink serve()（party_mailbox 轮询只在 serve/serveOfficial）。关它走 serve()。
        gates.append("MGBAX_DIRECT_LOCAL_FIRST=0")
    if a.shift:
        gates.append("MGBAX_PEER_SHIFT=%d" % a.shift)
    args = [PY, os.path.join(TOOLS, "cloud2p_avd.py"),
            "--tag", a.tag, "--mode", "A", "--runsec", str(a.runsec), "--app-nav",
            "--app-sav", BOOT_SAV]
    if a.attach_existing:
        args += ["--attach-existing"]
    if a.no_seat_walk:
        args += ["--no-app-seat-walk"]
    if a.pc_sav:
        args += ["--sav", a.pc_sav]
    if a.gnp_manifest_src:
        gates.append("MGBAX_GNP_PARTY_MANIFEST_SRC=1")
    if not a.self_emulator:
        args += ["--no-emulator", "--serial", "emulator-5554"]
    else:
        args += ["--serial", "emulator-5554"]
    args += [
            "--env", "MGBAX_GNP_RUN_DIR=" + gdir]
    for g in gates:
        args += ["--env", g]
    env = os.environ.copy()
    if a.pc_exe:
        os.environ["MGBAX_PC_EXE"] = a.pc_exe
        env["MGBAX_PC_EXE"] = a.pc_exe
        # 22:08 弹窗根因：driver 用 cwd=ROOT 起 exe，Qt 从 ROOT 找不到 platform plugin
        # ("no Qt platform plugin could be initialized")→PC 进程挂起/崩溃。显式钉插件路径
        # （exe 同目录 platforms/），由 launch→driver→PC 子进程继承。
        _qtplat = os.path.join(os.path.dirname(a.pc_exe), "platforms")
        os.environ["QT_QPA_PLATFORM_PLUGIN_PATH"] = _qtplat
        env["QT_QPA_PLATFORM_PLUGIN_PATH"] = _qtplat
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
