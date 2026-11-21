#!/usr/bin/env bash
# 真「跨设备」2P（PC ↔ Android AVD/真机）的一条可复制命令 —— 文档 + 入口。
# 这是 tools/cloud2p_avd.py 的薄封装；先读下面 3 个硬前提再跑。
#
# === 证据纪律（不可混为一谈）=============================================
#   * tools/cloud2p-duo.py 跑的是「同机两个 PC 实例 via P2P」，只是本地 PROXY，
#     它的 summary 会写 scope=PROXY-2PC，**不能**当成跨设备 E2E。
#   * 本脚本跑 PC ↔ Android，summary 写 scope=CROSS-DEVICE-AVD / REAL-DEVICE。
#     只有这里的 BATTLE=YES 才算跨设备 2P 闭环证据；否则 2P 云端门维持 FAIL。
#
# === 三个硬前提（MEMORY.md §5）==========================================
#   1. 两端不同账号：app=z x14855734@gmail.com / PC=525612743@qq.com（下面默认值）；
#      同账号会让先登录者的 token 失效。
#   2. 两端不同 game uuid（uuid = "BPEE," + ROM md5）：PC 用改 1 字节填充的
#      D:/gen8/rom_b.gba + rom_b.sav，app 用原始 rom.gba。同 rom 会被服务器当
#      同一玩家，消息只回显 self:true。
#   3. 启动时序：本脚本先起 app（CLOUD 广播不带 room = host），等 logcat 出现
#      `advertised relay <ip:port> for room <R>`，读**最新**一条 R，再起 PC 带
#      MGBAX_AUTOLINK=<pc账号>:<pc密码>:R。**期间不要重启 app**（leave_room 解散房间）。
#      尤其不要让外部 watchdog 补发 CLOUD：每补发一次 app 就 leave_room 解散旧房、
#      重建新房（attempt-4 实测 572161 -> 505099），PC 会 pin 在旧房号而永远连不上。
#      驱动现会在运行中检测房号漂移并只重指 PC（不重发 CLOUD）；summary 用
#      room_app/room_pc/rooms_match 断言两端同房，不一致即 fail-fast（exit 5）。
#
# === 用法 ================================================================
#   bash tools/cloud2p_cross_device.sh                 # 默认 AVD + 默认账号
#   APP_USER=a@b.com APP_PASS=p PC_ACC=c@d.com:p \
#     bash tools/cloud2p_cross_device.sh --mode A --runsec 420
#   bash tools/cloud2p_cross_device.sh --no-emulator --serial <真机序列号> \
#     --room 123456                                   # 真机 + 已存在的房间
#   bash tools/cloud2p_cross_device.sh --mode A --fast-align   # Agent 1 从机 idx 对齐门
#   bash tools/cloud2p_cross_device.sh --app-nav               # app 侧游戏导航：title→俱乐部→单打→等待
#     （默认 OFF；启用后驱动会用 PEEK logcat 作 oracle 把 app 也导航进联机，
#      推入预置存档并等待 EmulatorActivity 就绪后再发 ROM 广播；仅跨设备/E2E 用）
#
# 机器可读判据（summary.txt，Agent 13 直接消费）：
#   BATTLE / linkup_stable / in_battle_frame / path_PC / via /
#   peerCandidates_PC / peerCandidateCount_PC / mode_negotiated_PC /
#   official_mode_PC / gate_PC / rearm_PC / slave_fast_align_blocked_PC /
#   badchecksum_PC / pathB_2p_bus_ok /
#   room_app / room_pc / rooms_match / room_resyncs（两端同房断言，不一致 exit 5）
#   judge = gLink.state==4 && pc==2 && st&MASTER(0x20)；linkup=1 只是诊断残留值。
#   path B 2P fallback：netLinkBusHostLocal(key,2) + netLinkBusJoinLocalSlot(key,1)
#   （host=slot0/1P，1 镜像=slot1/2P）。当前 C++ 调用方仍写死 MIRROR_COUNT+1=4，
#   驱动只做 go/no-go 断言（pathB_2p_bus_ok），产品侧改动不在本脚本范围内。
#
set -euo pipefail
cd /d/mgba-android-version
export PATH="/c/msys64/mingw64/bin:/d/Android/Sdk/platform-tools:/d/Android/Sdk/emulator:$PATH"
export ANDROID_AVD_HOME="D:\avd-home\avd"

# app 侧导航开关：APP_NAV=1 等价 --app-nav（--app-nav 也会经下面的 "$@" 透传）。
# 这是让 app 核从标题进入有线俱乐部并到达「等待连接」的唯一入口；默认关闭。
if [[ "${APP_NAV:-0}" == "1" ]]; then
  set -- "$@" --app-nav
fi

# 起测前清场（会杀掉所有 mGBA.exe！同机若有别的 agent 实例请勿这样做）：
#   taskkill //F //IM mGBA.exe

python tools/cloud2p_avd.py \
  --tag "${TAG:-XDEV1}" \
  --mode "${MODE:-A}" \
  --runsec "${RUNSEC:-420}" \
  --app-user "${APP_USER:-zx14855734@gmail.com}" \
  --app-pass "${APP_PASS:-14855735}" \
  --pc-acc  "${PC_ACC:-525612743@qq.com:14855735}" \
  "$@"
