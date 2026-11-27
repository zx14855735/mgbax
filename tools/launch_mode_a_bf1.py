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
    ap.add_argument("--counter-approach", action="store_true",
                    help="P0 入口轴: 游戏停大厅柜台(10,4) Overworld、cur_b=0 时,先 UP 走一格到(10,3)"
                         "面向柜台NPC(10,2)再按A触发服务菜单→var8004。受控方向键+A,默认关。")
    ap.add_argument("--arena-linkup", action="store_true",
                    help="游戏自走菜单 warp 竞技场(map group25)+st4/pc2 即判 linkup,免 singles_confirmed"
                         "(游戏没经driver cur_b==4确认点)。配 --counter-approach 用。默认关。")
    ap.add_argument("--seat-walk-always", action="store_true",
                    help="POST-LINKUP 竞技场但 pos≠(10,5) 时仍强制走位踩 coord_event 座位格"
                         "(默认因rcvpl漂移跳过走位致卡pos=5,8不进战斗)。配 --arena-linkup 用。默认关。")
    ap.add_argument("--seat-slowfps", action="store_true",
                    help="P0 座位层低帧长按门(具名默认关): MGBAX_NAV_SEAT_WALK_SLOWFPS=1,"
                         "app_seat_walk 用 AL1 实证的 7s/格长按档+300s 超时,治 0.55s 在低帧下一次走不动。"
                         "只改 KEYS 按住时长,不写游戏态、不进 CROSSED 裁决。默认关。")
    ap.add_argument("--shot-to-peek", action="store_true",
                    help="P0 oracle 切换门(具名默认关): MGBAX_NAV_SCREENSHOT_TO_PEEK=1,"
                         "冷启动截图 oracle 卡住时 PEEK 一旦读到有效 field 即切回 PEEK oracle,"
                         "治冷启动在标题菜单盲按 A 走不到柜台。默认关。")
    ap.add_argument("--cb2-map", type=str, default=None,
                    help="cb2 地址解析来源 rom.map（新 ROM/移动靶须指向冻结 map；默认 None=主仓旧 map 零回归）。")
    ap.add_argument("--link-log", action="store_true",
                    help="诊断：设 PC MGBAX_LINK_LOG=<run目录>/pc_link.log，记录 netLink PUSH/PUSH value/req 真实字。默认关。")
    ap.add_argument("--no-master-echo", action="store_true",
                    help="§3.6 架构诊断：MGBAX_SIO_MASTER_ECHO=0，让 PC 不回环 8FFF、成从机响应 APP 主机。"
                         "治'两端皆主机发 PUSH、无 REQ 响应'握手死锁。默认关(保持 BF1)。")
    ap.add_argument("--counter-b", action="store_true",
                    help="§3.6 柜台对话框门: MGBAX_NAV_COUNTER_B=1, 柜台A交互N次后发B取消'请稍候'对话框"
                         "(gen8 Task_EnterCableClubSeat case1需IsFieldMessageBoxHidden才推进)。默认关。")
    ap.add_argument("--cb-restore", action="store_true",
                    help="GZ8 灰区(§3.5): MGBAX_CB_RESTORE=1, 握手闭合瞬间写真值 gLinkCallback="
                         "LinkCB_RequestPlayerDataExchange 修'回调晚装3.5min'时序错配。"
                         "写真实函数地址非造假;产物标灰区、不进CROSSED裁决。默认关。")
    ap.add_argument("--cmd2222", action="store_true",
                    help="GZ9 灰区(§3.5): MGBAX_CMD2222=1, 驱动层写真实协议字 0x2222 到 "
                         "sendCmd[0] 启动块交换(仿 sioStandbyInject 写 0x2FFE 先例)。"
                         "写真实命令字非造假;产物标灰区、不进CROSSED裁决。默认关。")
    ap.add_argument("--counter-walk", action="store_true",
                    help="P0 柜台走位门(具名默认关): NPC 在(10,2)玩家(10,4)相距2格,先长hold UP走到(10,3)"
                         "再A交互,治原地A够不到NPC。纯方向键+A输入,默认关。")
    ap.add_argument("--no-pc-restart", action="store_true",
                    help="P0 诊断门(具名默认关): 禁用 pc_join_guard 运行期重启,治 PC 无限重启循环。默认关。")
    ap.add_argument("--forcehs-on", action="store_true",
                    help="P0 握手对照门: MGBAX_LINK_FORCEHS=1 打开握手字强制(主机8FFF/从机B9A0),"
                         "sio_link.c state==2 时主机自槽定死8FFF(PUREBLOCK6曾得lstate=4)。默认关(历史A/B对照=0)。")
    ap.add_argument("--rearm-on", action="store_true",
                    help="P0 主从选举门: MGBAX_LINK_REARM=1 打开握手重选举(maybeRearmHandshake),"
                         "治'两端进房差几十帧都退化从机都发B9A0无8FFF'。GATES默认=0(历史全关),本旗标改=1。默认关。")
    ap.add_argument("--app-rom", type=str, default=None,
                    help="新 ROM APP 母本（默认 None=driver 默认主仓 rom.gba）。配 --pc-rom/--cb2-map 跑重锚 ROM。")
    ap.add_argument("--pc-rom", type=str, default=None,
                    help="新 ROM PC 配对件（末字节 FE，uuid 与 APP 不同）。默认 None=driver 默认 rom_b.gba。")
    ap.add_argument("--patha-tcp", action="store_true",
                    help="mode A 本地 TCP 桥判别实验: 真 SIO 字走本地 TCP(~1ms)绕开 relay RTT 墙。"
                         "只换传输(判别工具非已论证解法),本地桥非真机,不预设成功。默认关。")
    ap.add_argument("--seat-assist", action="store_true",
                    help="X1: 单开 SEAT_ASSIST(不 GRAY_ALL)手建 seat task→CB2_InitBattle，让 ROM NetParty 钩子"
                         "在 case1 rem 门前 Apply 真 party（不触 rem 红线）。默认关。")
    ap.add_argument("--vpn-relay-only", action="store_true",
                    help="VPN分流组合: 设 MGBAX_NO_DIRECT=1 关UDP打洞(避VPN隧道659ms P2P+BYE),"
                         "两端走国内relay(各自出口IP仍不同→身份门可过)。默认关。")
    ap.add_argument("--hs-assist", action="store_true",
                    help="握手保真门组合(灰区/具名默认关): GATES 把源码默认开的 HSBYPASS/HOLD/"
                         "FORCEHS/REARM 关成 0，致 APP master 的 8FFF 不回环→卡 st=2(PC slave 已 st4)。"
                         "开此 flag 恢复四门为 1——只保真真握手字、不写 btlType/case1/brs/party/信任位。"
                         "非纯零注入、不进 CROSSED 裁决。")
    ap.add_argument("--gray-lobby", action="store_true",
                    help="C3 直写 gLinkOpen=1 灰区门(具名默认关): st=4 但 LinkMain2 没调 callback 装 2222 时，"
                         "恢复链路打开态让 callback 执行。只写 gLinkOpen，不写 rem/nr/brs/party/信任位。"
                         "非纯零注入、CROSSED 可信度存疑、不进裁决。")
    ap.add_argument("--obs-chain", action="store_true",
                    help="OBS 打点总门(只读): 让移动端打 [OBSCHAIN][GATES]/[ST] open= 直证门缓存与 gLinkOpen。默认关。")
    ap.add_argument("--phase-fix", action="store_true",
                    help="PHASE-FIX(灰区/具名默认关): rem==1 仅 trainer card 收齐,继续为 party 块钉正 8888 帧首相位"
                         "(修 FRESHALL PC [RHALIGN] n=8 sc=0 rc=0)。只写 sc/rc 索引,不写 brs/rem/nr/party。")
    ap.add_argument("--force-full-menu", action="store_true",
                    help="强制走完 cable club 完整菜单(服务菜单→模式菜单→确认单打→游戏自然设"
                         "var8004)，专治'nav-accept-st4 早退跳过菜单致 var8004=0/btlType=0/不进战斗'。"
                         "透传 driver --force-full-menu，480s 窗口；默认关。")
    ap.add_argument("--iw-delta", type=str, default=None,
                    help="强制 PC IWRAM delta(十六进制,如 0x260)用于判据正确性验证: "
                         "默认签名扫描得 0x244,但 brs/rem/cb 三字段 map 真实地址需 0x260。默认 None=不强制。")
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
    if a.counter_approach:
        # P0 入口轴门（driver 自身读 os.environ）：柜台 NPC 走位触发菜单
        os.environ["MGBAX_NAV_COUNTER_APPROACH"] = "1"
    if a.arena_linkup:
        # 竞技场客观证据优先判 linkup（driver 自身读 os.environ）
        os.environ["MGBAX_NAV_ARENA_LINKUP"] = "1"
    if a.seat_walk_always:
        # 竞技场 pos≠座位格时仍强制走位踩格（driver 自身读 os.environ）
        os.environ["MGBAX_NAV_SEAT_WALK_ALWAYS"] = "1"
    if a.seat_slowfps:
        # P0 座位层低帧长按档（driver 自身读 os.environ，默认关可逆）
        os.environ["MGBAX_NAV_SEAT_WALK_SLOWFPS"] = "1"
    if a.shot_to_peek:
        # P0 oracle 切换门（driver 自身读 os.environ，默认关可逆）
        os.environ["MGBAX_NAV_SCREENSHOT_TO_PEEK"] = "1"
    if a.counter_walk:
        # P0 柜台走位门（driver 自身读 os.environ，默认关可逆）
        os.environ["MGBAX_NAV_COUNTER_WALK"] = "1"
    if a.no_pc_restart:
        # P0 诊断门：禁用 PC 运行期重启（默认关可逆）
        os.environ["MGBAX_NO_PC_RESTART"] = "1"
    if a.forcehs_on:
        # P0 握手对照门：把默认 MGBAX_LINK_FORCEHS=0 覆盖为 =1（state==2 强制主机8FFF自槽）
        gates = [g for g in gates if not g.startswith("MGBAX_LINK_FORCEHS=")]
        gates.append("MGBAX_LINK_FORCEHS=1")
        os.environ["MGBAX_LINK_FORCEHS"] = "1"   # APP 侧 driver 也需读（若用到）
    if a.rearm_on:
        # P0 主从选举门：把默认 MGBAX_LINK_REARM=0 覆盖为 =1（两端进房差帧退化从机时重选举）
        gates = [g for g in gates if not g.startswith("MGBAX_LINK_REARM=")]
        gates.append("MGBAX_LINK_REARM=1")
        os.environ["MGBAX_LINK_REARM"] = "1"
    if a.counter_b:
        # §3.6 柜台对话框门（driver 自身读 os.environ）
        os.environ["MGBAX_NAV_COUNTER_B"] = "1"
    if a.cb_restore:
        # GZ8 灰区：握手闭合瞬间写真值回调（driver 读 env 下发 setprop）
        os.environ["MGBAX_CB_RESTORE"] = "1"
    if a.cmd2222:
        # GZ9 灰区：驱动层写 0x2222 到 sendCmd[0]（driver 读 env 下发 setprop）
        os.environ["MGBAX_CMD2222"] = "1"
    if a.seat_assist:
        # X1: 单开 seat-assist（不 GRAY_ALL，避免 GZ7 rem-restore 红线）
        gates.append("MGBAX_SEAT_ASSIST=1")
    if a.vpn_relay_only:
        # VPN分流组合: 关UDP打洞→不走VPN隧道659ms P2P+BYE,两端走国内relay
        # (出口IP仍不同: PC miwifi / AVD VPN隧道→身份门可过)。具名默认关。
        gates.append("MGBAX_NO_DIRECT=1")
    if a.link_log:
        # 诊断：PC netLink 字级打点落盘（确认 PC push 的真字 value）
        gdir = os.path.join(BASE, ".zcode-tmp", "cloud2p", a.tag)
        os.makedirs(gdir, exist_ok=True)
        gates.append("MGBAX_LINK_LOG=" + os.path.join(gdir, "pc_link.log").replace("\\", "/"))
    if a.no_master_echo:
        # §3.6 架构诊断：关 PC master_echo，让 PC 成从机（不回环 8FFF、响应 APP 主机）
        gates = [g for g in gates if not g.startswith("MGBAX_SIO_MASTER_ECHO=")]
        gates.append("MGBAX_SIO_MASTER_ECHO=0")   # 只改 PC gates；APP 侧 setprop 不受影响
    if a.hs_assist:
        # 握手保真门恢复源码默认(灰区/非纯零注入,不进裁决):
        # GATES 把 HSBYPASS/HOLD/FORCEHS/REARM 关成 0,致 APP master 8FFF 不回环卡 st=2。
        # 这里逐项覆盖为 1——只保真真握手字,不写任何游戏态/信任位/party/ brs。
        for k in ("MGBAX_LINK_HSBYPASS", "MGBAX_HS_HOLD",
                  "MGBAX_LINK_FORCEHS", "MGBAX_LINK_REARM"):
            gates = [g for g in gates if not g.startswith(k + "=")]
            gates.append(k + "=1")
    if a.gray_lobby:
        # C3 直写 gLinkOpen=1 灰区门: st=4 但 callback 没装 2222 时恢复链路打开态。
        # 只写 gLinkOpen,不写 rem/nr/brs/party/信任位;非纯零注入、不进裁决。
        gates.append("MGBAX_GRAY_LOBBY_OPEN=1")
    if a.obs_chain:
        # 只读 OBS 打点门: 让移动端 [OBSCHAIN][GATES]/[ST] open= 直证门缓存与 gLinkOpen。
        gates.append("MGBAX_OBS_CHAIN=1")
    if a.phase_fix:
        # PHASE-FIX: rem==1 后继续钉 party 块帧首相位(灰区,只写 sc/rc 索引)。
        gates.append("MGBAX_PHASE_FIX=1")
    if a.iw_delta:
        # 强制 PC IWRAM delta 验证 brs/rem/cb 地址正确性(判据验证,零改码)。
        gates.append("MGBAX_IWRAM_DELTA=" + a.iw_delta)
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
    if a.force_full_menu:
        args += ["--force-full-menu"]
    if a.patha_tcp:
        args += ["--patha-tcp"]
    if a.cb2_map:
        args += ["--cb2-map", a.cb2_map]
    if a.app_rom:
        args += ["--app-rom", a.app_rom]
    if a.pc_rom:
        args += ["--pc-rom", a.pc_rom]
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
