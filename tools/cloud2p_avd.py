#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""真「跨设备」2P 驱动：PC ↔ Android AVD（或真机）经云端房间走 path A。

和 cloud2p-duo.py 的区别（证据纪律，不可混为一谈）
------------------------------------------------
* cloud2p-duo.py 跑的是**同一台机器上的两个 PC 实例**，P2P 直连只是快速本地
  代理（PROXY-2PC），它证明不了跨设备。
* 本脚本才跑 `(b)` PC ↔ Android：summary.txt 写 `topology=avd` /
  `scope=CROSS-DEVICE`（用 --no-emulator + 设备序列号时为 REAL-DEVICE）。
  **只有这里的 BATTLE=YES 才能作为跨设备 2P 闭环证据。**

两个硬前提（MEMORY.md §5）
------------------------
① 两端必须**不同账号**（同账号先登录者 token 失效）；
② 两端必须**不同 game uuid**（uuid = "BPEE," + ROM md5；同 rom 服务器当同一
   玩家，消息只回显 self:true）。做法：PC 用改 1 字节填充的
   D:/gen8/rom_b.gba + rom_b.sav，app 用原始 rom.gba。
③ 启动时序：先起 app（CLOUD 广播**不带 room** = host），等 logcat 出现
   `advertised relay <ip:port> for room <R>` 读出 R；再起 PC 带 `MGBAX_AUTOLINK=
   <pc账号>:<pc密码>:R`。**之后别重启 app**（重启 leave_room 解散房间）。

房号漂移（attempt-4 事故，driver 必须自愈）
------------------------------------------
若外部 watchdog 在 host 之后**又补发一次 CLOUD 广播**，app 会 leave_room 解散旧房
并重建新房（实测 572161 → 505099），旧 session 的 relay 广告还会继续残留，于是
logcat 同时出现两个房号。此时绝**不能**由 driver 再发 CLOUD（会解散并造出第三个
房），只能：① 读最新 `advertised relay ... for room R`（多房时用最近
`create_game_room` 的 room_id 消歧）；② 停掉 PC、用新房号重起 `MGBAX_AUTOLINK`。
summary.txt 用 room_app/room_pc/rooms_match 断言两端同房，不一致即 fail-fast。

用法
----
    python tools/cloud2p_avd.py --preflight
    python tools/cloud2p_avd.py --tag XDEV1 --mode A --runsec 420 \
        --app-user <app账号> --app-pass <app密码> --pc-acc <pc账号>:<pc密码>
    python tools/cloud2p_avd.py --tag XDEV2 --mode A --no-emulator --room 123456 ...

默认 ROM/账号取仓库约定值；真机请用 --app-user/--app-pass/--pc-acc 覆盖。
"""

import argparse
import atexit
import hashlib
import io
import ipaddress
import importlib.util
import os
import re
import shutil
import subprocess
import sys
import time

import gba_addrs as gba  # 统一地址宏（AGENTS §5，三端同名同值）

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BASE = os.path.join(ROOT, ".zcode-tmp", "cloud2p")
EXE = os.environ.get("MGBAX_PC_EXE") or os.path.join(ROOT, "build-win", "dist", "mGBA.exe")
AVD_HOME = os.environ.get("ANDROID_AVD_HOME", r"D:\avd-home\avd")
EMULATOR = "emulator"
REMOTE_ROM = "/sdcard/Download/rom.gba"
PKG = "io.mgba.android"          # ROM/CLOUD 广播接收器是动态注册的，必须 app 在前台才收得到
BOOT_TIMEOUT = 180               # sys.boot_completed=1 上限（adb 显示 device ≠ framework 起完）
APP_START_WAIT = 30              # pm clear 后 am start 到 pid 出现的上限
ROM_LOAD_TIMEOUT = 90            # 等 logcat 确认「app 真的加载了本轮推送的 ROM」的上限
PC_ROM = os.environ.get("MGBAX_ROM_B", os.path.join(ROOT, "rom_b.gba"))
APP_ROM = os.environ.get("MGBAX_ROM_A", os.path.join(ROOT, "rom.gba"))
DEF_SAV = "D:/gen8/rom.sav"
DEF_APP_ACC = "zx14855734@gmail.com:14855735"
DEF_PC_ACC = "525612743@qq.com:14855735"

# ---- app 侧游戏导航（--app-nav）------------------------------------------------
# 按键掩码与 .workbuddy/drive/android_drive.py:19 完全一致（KEYS 广播，边沿触发）。
AK_A, AK_B, AK_START, AK_DOWN, AK_UP, AK_LEFT, AK_RIGHT = 1, 2, 8, 128, 64, 32, 16
APP_REMOTE_SAV = "/sdcard/Download/rom.sav"
APP_SAV_DEFAULT = os.environ.get(
    "MGBAX_APP_SAV", os.path.join(os.path.dirname(DEF_SAV), "rom.sav.bak-before-link"))
APP_READY_WAIT = 15      # am start 后等 EmulatorActivity onResume 就绪：2s 会丢 ROM 广播（E1 教训）
APP_NAV_TIMEOUT = 480    # AQ1: 2.2fps 下 UI 链(标题→菜单→field)≈6-8min，480s；deadline 在等动画后起算。
# AF6 等开场动画常量（模板匹配主 + 画面演变备 + cap 兜底）
INTRO_WAIT_CAP_S = 500       # AT1: 2.2fps 下 UI 链到 field 实测≈200-400s，cb2 field 判据留余量 500s
INTRO_TPL_NAME = "tpl_main_menu.png"  # nav_028 主菜单帧（已落 .workbuddy/drive/）
INTRO_SIG_SIZE = (120, 90)           # 与 topmenu_sig 一致的灰度签名尺寸
INTRO_MENU_THRESH = 12.0             # AF6 实测：主菜单0/黑屏15.4/Logo33.7/战斗93.6/灰屏160.5
INTRO_SAMPLE_SEC = 1.5               # 等待期采样间隔
INTRO_CHANGE_EPS = 6.0               # 签名变化阈值（动画进行中）
INTRO_STABLE_EPS = 1.5               # 签名稳定阈值（主菜单静止）
INTRO_BRIGHT_LUMA = 100.0            # AG3: 高亮演出段门槛(Logo暗帧luma19.6必须被挡;亮屏nav_004=182)
INTRO_CONFIRM_SEC = 4.0              # AG3: 首命中后二次确认等待(s)
INTRO_MIN_WAIT_S = 120.0             # AG3: 最小等待(误命中102.5s;真菜单156.8s;防早期假阳性)
# AG4: PEEK map 语义硬确认（club 档到竞技场 25.24/(10,5) 才放行，否决 Logo 帧假阳性）
INTRO_MAP_GROUP = 25
INTRO_MAP_NUM = 24
INTRO_MAP_TX = 10
INTRO_MAP_TY = 5
INTRO_MAP_STREAK = 3              # 连续 N 次 map/pos 命中才放行（同 TID 连续，排除抖动)
# AL1: 座位格 coord_event 踩格门（默认关、具名、受控输入灰区）。构造档直接放 (10,5)
# 不走格 → tookStep 恒 FALSE → coord_event 座位事件链不触发 → link.state 停 1。
# 需 DOWN 离格→UP 踩回（2 次方向步）触发，方进 cable club 握手。
NAV_COORD_STEP = os.environ.get("MGBAX_NAV_COORD_STEP", "0") == "1"
# AQ1: peek-arena 放行门（默认关）。注入 club 档使 pos/map 立即=25.24，会在 UI 链跑完前
# 提前放行→方向键被当菜单光标吞。默认走截图 template 等真主菜单，oracle 解耦。
NAV_PEEK_ARENA = os.environ.get("MGBAX_NAV_PEEK_ARENA", "0") == "1"
# AQ1: field-ready 判据（具名近似区间，待 C 侧精确化）——CB2_Overworld 族落在 main/menu 段，
# 高于 intro(~0x0817) 且低于 title(~0x0821)。截图+pos 为主证，cb2 区间为辅。
NAV_FIELD_CB2_LO = 0x081A0000   # 实测真 field cb2=081A52AD；menu 态=081900ED 须排除(旧下界0x08190000假阳性)
NAV_FIELD_CB2_HI = 0x081E0000
NAV_FIELD_CB2_STREAK = 3             # cb2 连续 N 拍稳定才认 field idle
INTRO_MIN_LUMA = 25.0                # 演变判据亮度下界（菜单非纯白）
INTRO_MAX_LUMA = 180.0               # 演变判据亮度上界
INTRO_MIN_CHANGES = 3                # 演变判据：至少经历 N 次画面变化
INTRO_MENU_STABLE = 3                # 演变判据：连续 N 次稳定
INTRO_HIT_SHOT = "intro_hit.png"
# AV1: INTRO-WAIT 连打键推进 UI 链（默认关、具名、受控输入灰区）。
# 死锁根因：AQ1 纯等 cb2 进 field 但 intro 出口需 newKeys 按键⇒永不到 field。
NAV_INTRO_KEYPUSH = os.environ.get("MGBAX_INTRO_KEYPUSH", "0") == "1"
INTRO_PULSE_MASK = 1                 # ZEROE2E: 手动连打A(mask=1)实证能跳过动画;driver原用START(8)失败
INTRO_PULSE_HOLD = 0.6               # ≥1 模拟帧(2.4fps≈0.42s/帧)，长按 newKeys 恒 0 故用脉冲
INTRO_PULSE_GAP = 0.3                # ZEROE2E: 缩短间隔提高 newKeys 命中率(手动密集连打18-25成功)
INTRO_PULSE_BURST = 12               # ZEROE2E: 每轮12边沿(原3太稀疏,2.2fps下命中概率低致动画跳不过)
                                     # 脉冲内每边沿查cb2,到field立即停手,不会冲过头
APP_NAV_POLL = 1.2       # PEEK 采样间隔（oracle 本身约 2~5s 一条）
APP_STABLE_N = 3         # 去抖：签名连续 N 次一致才按一次键（避免 PC 侧那种 A 振荡）
# --force-full-menu：主菜单→cable_club 路径长，放宽阈值但仍防死循环（默认关由 flag 控制）
FORCE_MENU_TAP_LIMIT = 120       # force 模式 A 键硬上限
FORCE_MENU_STALL_LIMIT = 30      # 连续 N 次 A 无菜单进度即判卡死
FORCE_MENU_WINDOW = 480          # AQ1：与 APP_NAV_TIMEOUT=480 对齐
# cable_club.o 的 cb2 地址段基准宏（rom.map）；禁裸 hex，运行时按 rom.map delta 平移
CABLE_CLUB_CB2_LO = gba.CABLE_CLUB_CB2_LO  # 统一宏（原值 0x08105FD4）
CABLE_CLUB_CB2_HI = gba.CABLE_CLUB_CB2_HI  # 统一宏（原值 0x08107488）
# ---- 入口轴 ENTRY-FIX-01：竞技场座位地图守卫（W46 §2.1a；具名禁裸 hex）--------------
# MAP_BATTLE_COLOSSEUM_2P = (24 | (25 << 8))；PEEK map=G.N ⇒ group=25, num=24 ⇒ (25,24)
SEAT_MAP_GROUP     = 25
SEAT_MAP_NUM       = 24
SEAT_MAP           = (SEAT_MAP_GROUP, SEAT_MAP_NUM)   # 真 coord_event 所在图（PlayerSpot1）
SEAT_TX, SEAT_TY   = 10, 5                            # (10,5)=PlayerSpot1 座位格
SEAT_WARP_WAIT_S   = 90.0     # 等游戏 warp 到大厅→竞技场的有界墙钟（推断值，实测可调）
SEAT_CONFIRM_LIMIT = 60       # 待机室→战斗确认循环上限（替换盲 A×80）
# 队伍菜单类型（party_menu.h L67/L68；gba 未暴露，须模块级具名常量，调用点禁裸 hex）
PARTY_MENU_CHOOSE_MON  = 3
PARTY_MENU_CHOOSE_HALF = 4


# ---- path B P2P 启动同步（--pathb-sync-start，仅 mode B，默认关可逆）----------------
# 根因（ROUTEA-PATHB-01 实证）：APP host 建房后 PC 进程要 ~20s 才入房，两端 4s 候选
# 公告窗口不重叠 → PC 收到 s 时 APP 已 5s 超时放弃（APP result=tunnel / PC result=p2p
# 分裂）。同步法：PC 先无房号 AUTOLINK 建房，APP 后带房号入房，双方 peerSeen 同刻触发。
PATHB_SYNC_ROOM_POLL = 0.5       # PC 房号轮询间隔（s），本地文件读，无 adb 开销
PATHB_SYNC_ROOM_TIMEOUT = 30     # 用户裁决：等 PC 建房 30s 上限，未建房即判不成功

# ---- path B TCP 直连（--pathb-tcp，仅 mode B，默认关可逆）------------------------
# GRAYPATH4 拓扑②：PC 设 MGBAX_TCP_LISTEN 监听（listenAndAccept 20s），App 以
# 10.0.2.2:port（emulator 宿主回环别名）作 TCP client 连入，无需 adb forward。
# 只换 game-data 传输：CLOUD 广播保留（真实邮箱登录语义），身份缺口由 STUN 摘要补。
# 数据面是宿主↔AVD 本机桥接，不经 WAN；对外不得称「纯公网跨设备 P2P」。
PATHB_TCP_PORT = 15678           # PC MGBAX_TCP_LISTEN / App peer 端口
PATHB_TCP_HOST = "10.0.2.2"      # emulator 内宿主机回环别名
PATHB_TCP_BROADCAST = "io.mgba.android.action.TCP"
# CloudLink::status() 把「正在监听 TCP 端口 N 等待对端…」写进 [status] lobby 日志；
# driver 轮询该行才算 PC 进入 accept 窗，避免猜时间（UDP 直连耗时实测 20s+）。
PATHB_TCP_LISTEN_RE = re.compile(r"正在监听 TCP 端口\s*(\d+)")
PATHB_TCP_LISTEN_TIMEOUT = 90    # 等 PC TCP listen 日志上限（s）；超时仍 best-effort 发广播

# ---- path B PC 可见核导航输入（--pathb-pc-nav，仅 mode B，默认关可逆）------------
# 根因（PB15 实证）：mode B 下 driver 清理 MGBAX_NAV_AT、nav_at 文件只在 mode!=B 写、
# 全文无 pc.tap/pc.key ⇒ CloudLink.cpp 读不到 MGBAX_NAV_AT(navMenuAt=-1) 不写 nav_at ⇒
# PC 可见核停在菜单 cb=0 ⇒ gLinkCallback 装不上/st 不推进 ⇒ 整链卡死。
# 本 flag 把 "1500 2"（与 mode A 的 nav_at、cloud2p-duo.py path B 的 env_for 逐字一致）
# 还给 env，CloudLink 在三镜像核 LINK_CONNECTED 后写 nav_at，可见核经 ScriptedControl
# 真实走菜单→等待。纯驱动输入修复：不造 party/信任位/CROSSED/species，红线不动。
PATHB_PC_NAV_AT = 1500
PATHB_PC_NAV_DOWNS = 2

# ---- ISYNC23: ISYNC_STATE_APPLY 门（三端同名门 MGBAX_ISYNC_STATE_APPLY，默认关可逆）----
# ISYNC20 §2.1 / ISYNC1：Android stock 无 setprop 能力，门只能靠 app 前台动态广播接收器下发；
# EmulatorActivity.java:527-535 注册 io.mgba.android.action.ISYNC_STATE_APPLY，读 --ez on true
# 后打里程碑 [ISYNC] MGBAX_ISYNC_STATE_APPLY=1 (bounded retry 100x100ms)。
# 门只控有界重试/诊断口径，门开≠seed applied（ISYNC14 §0）；applied 仅作只读观测、不判 PASS。
ISYNC_STATE_APPLY_BROADCAST = "io.mgba.android.action.ISYNC_STATE_APPLY"
ISYNC_STATE_APPLY_READBACK_RE = re.compile(r"\[ISYNC\]\s+MGBAX_ISYNC_STATE_APPLY=1")
# ---- RACEBROAD: 根治门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY（三端同名门，默认关可逆）----
# RACEGATE 实锤：当前 driver 只在 PC 侧 --env 下发；Android Java 只读 System.getenv +
# 广播 io.mgba.android.action.ISYNC_SEED_FRAME_BOUNDARY，不读 debug.* 属性；--env 只到
# PC、am start 不传 env ⇒ Java 门恒 false。这里补 Android 广播通道：EmulatorActivity
# 前台动态接收器读 --ez on true 后打里程碑 [ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1
# （有界回读 15s）。门只控 seed 帧边界同步时序；门开≠压测有效（CROSSED 唯一裁决），
# FAIL/0/9 不变，不预设成功。
ISYNC_SEED_FRAME_BOUNDARY_BROADCAST = "io.mgba.android.action.ISYNC_SEED_FRAME_BOUNDARY"
ISYNC_SEED_FRAME_BOUNDARY_READBACK_RE = re.compile(
    r"\[ISYNC\]\s+MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1")
# BOOTSTRAP/ISYNC-EV: A1 seed sha256 只读埋点门（具名总门 MGBAX_ISYNC_EVIDENCE
# + 子开关 MGBAX_ISYNC_EVIDENCE_A1，默认关可逆，独立于 ISYNC_STATE_APPLY）。
# 门只启 SEND/LAND 观测，不造 seed/party/信任位；门开≠C5 PASS，不预设成功。
ISYNC_EVIDENCE_BROADCAST = "io.mgba.android.action.ISYNC_EVIDENCE"
ISYNC_EVIDENCE_READBACK_RE = re.compile(r"\[ISYNC-EV\]\s+MGBAX_ISYNC_EVIDENCE=1")
ISYNC_APPLIED_APP_RE = re.compile(
    r"peer state loaded \(no reset\) bytes=(\d+) index=0 slot=(\d+)", re.I)
ISYNC_APPLIED_PC_RE = re.compile(r"applied peer state (\d+) bytes slot (\d+)", re.I)
ISYNC_STATE_NEG_RE = re.compile(
    r"not\s+applied|consoles?\s+not\s+ready|\bdeferred\b|still\s+pending|"
    r"bounded\s+wait\s+exhausted|seed\s+unconsumed|peer\s+state\s+rejected|"
    r"TYPE_STATE[^\n]*(queued|dropped)", re.I)

# PC 建房日志行：`host: room 570954` / `[status] 房间已创建，房号 570954 ...`
# stale room 会先建后弃（见 E2-FAST-a-lobby.log），取最后一条「游戏房间创建成功」。
PC_ROOM_OK_RE = re.compile(
    r'"type":"create_game_room"[^}]*?"message":"游戏房间创建成功"[^}]*?"room_id":"(\d+)"')
PC_ROOM_HOST_RE = re.compile(r"host: room\s+(\d+)")
PC_ROOM_STATUS_RE = re.compile(r"房号\s*(\d+)")


def extract_pc_host_room(text):
    """从 PC lobby debug 日志取它当前持有的房号（最后一条成功新建/最终房号）；取不到返回 None。"""
    fresh = PC_ROOM_OK_RE.findall(text or "")
    if fresh:
        return fresh[-1]
    host = PC_ROOM_HOST_RE.findall(text or "")
    if host:
        return host[-1]
    st = PC_ROOM_STATUS_RE.findall(text or "")
    return st[-1] if st else None

# PEEK 是 app 唯一的游戏状态 oracle（mgba_mobile.c:5330-5366）。只在 logcat 里取
# **最后一条** PEEK；刻意不写死任何 cb2 字面量（ROM 重链会平移），只用 cb2 是否落
# 在动态解析的 battle 窗口、pos/cur/mm/link 这些语义字段。
PEEK_RE = re.compile(
    r"PEEK st=([0-9A-Fa-f]+).*?link\[m=(-?\d+) st=(-?\d+) id=(-?\d+) pc=(-?\d+).*?"
    r"pos=(-?\d+),(-?\d+) map=(-?\d+)\.(-?\d+) cb2=([0-9A-Fa-f]+) mm=(-?\d+) "
    r"pt=(-?\d+) s01=(-?\d+)/(-?\d+) slot=(-?\d+) cur=(-?\d+)/(-?\d+)\]")

# ---- W13 读核修复（两 driver 逐字对称）：threadtime 命名组 + 走位核签名 ----
# 坑：旧 WALKREAD 把 tag 连冒号写成字面量，但 -v threadtime 下 tag 会被补齐
# （tag 后带空格），那种字面量永不命中 ⇒ 全部 PEEK 被当成无 TID。这里只用命名组
# 取 pid/tid，tag 用 \S+?\s* 通配，绝不在正则里写死任何 tag 字符串。
THREADTIME_PEEK_RE = re.compile(
    r"^\s*(?P<date>\d{2}-\d{2})\s+(?P<time>\d{2}:\d{2}:\d{2}\.\d+)\s+"
    r"(?P<pid>\d+)\s+(?P<tid>\d+)\s+(?P<prio>[VDIWEAF])\s+\S+?\s*:\s*"
    r"(?P<msg>PEEK\b.*)$")

# 走位核内容签名（discover_walk_tid 用）：link 前 open=0/st=1/cur=0/0；
# 后_LINKUP 回退 open=0/st>=4/cur_a=0/cur_b∈{0,1,4}（NX12）。
PEEK_SIG_RE = re.compile(
    r"\bopen=(?P<open>-?\d+)\b.*?\blink\[m=(?P<m>-?\d+)\s+st=(?P<lkst>-?\d+).*?"
    r"\bcur=(?P<cura>-?\d+)/(?P<curb>-?\d+)\]")
# ---- W22 阶段 B：步长自适应（WALKSTEP 3 轮实测反演 + 更新过程建模推荐值，推断值）------
WALK_STEP_HOLD   = 0.35   # 基线短按（s）；1.3s 长按实测 +4 格 ⇒ 单格≈0.32s
WALK_HOLD_MIN    = 0.22   # 最短按（d==1 精调档）
WALK_HOLD_MAX    = 0.55   # 最长按（≈2 格上界，防过冲）
WALK_HOLD_ADJ    = 0.05   # 自适应步进（≈1/7 格）
WALK_STEP_SETTLE = 0.60   # 松键静置（PEEK 去抖）
WALK_POLL_S      = 16.0   # 单步等新鲜 PEEK 的墙钟上限
WALK_POLL_TICK   = 1.0    # 轮询间隔（沿用现状）
WALK_STEP_LIMIT  = 48     # 单格步数上限（旧 16 按 ±4 格设计）
WALK_DEADLINE_S  = 120    # 走位总墙钟上限，防低帧率空转
WALK_BIAS_CAP    = 0.10   # 每轴学习偏置上限（±2 档）
WALK_TIER_FAR    = 0.50   # d>=3 粗调
WALK_TIER_MID    = 0.35   # d==2 中调
WALK_TIER_FINE   = 0.22   # d==1 精调



def _peek_records(text):
    """threadtime logcat 文本 → PEEK 记录列表 [{tid,pid,ts,line,msg}]。

    纯函数，便于 selftest 合成双核日志验证；无 threadtime 前缀的行一律忽略
    （fail-closed：没有 TID 就不猜核，绝不让 lines[-1] 跨核乱读）。
    """
    recs = []
    for line in (text or "").splitlines():
        m = THREADTIME_PEEK_RE.match(line)
        if not m:
            continue
        recs.append({
            "tid": m.group("tid"), "pid": m.group("pid"),
            "ts": m.group("date") + " " + m.group("time"),
            "line": line, "msg": m.group("msg"),
        })
    return recs


# 复用 cloud2p-duo.py 的 Inst / 判据解析（文件名带 '-'，只能 importlib 加载）
_spec = importlib.util.spec_from_file_location(
    "cloud2p_duo", os.path.join(ROOT, "tools", "cloud2p-duo.py"))
D = importlib.util.module_from_spec(_spec)
_spec.loader.exec_module(D)


def _resolve_adb():
    """adb 常不在 PATH（尤其从 msys shell / IDE 起驱动时）。优先 PATH，其次 SDK 默认位置。"""
    p = shutil.which("adb")
    if p:
        return p
    for cand in (r"D:\Android\Sdk\platform-tools\adb.exe",
                 r"C:\Android\Sdk\platform-tools\adb.exe"):
        if os.path.exists(cand):
            return cand
    return "adb"


ADB_BIN = _resolve_adb()


def adb(argv, timeout=30):
    try:
        return subprocess.run([ADB_BIN] + list(argv), capture_output=True, text=True,
                              encoding="utf-8", errors="replace", timeout=timeout)
    except Exception as ex:                       # noqa: BLE001
        print("  !! adb %s 失败: %s" % (" ".join(argv), ex))
        return None


def _stop_live_log(proc, fh):
    """进程退出时收掉全程 logcat 子进程，避免 adb logcat 悬挂。"""
    try:
        proc.terminate()
        proc.wait(timeout=5)
    except Exception:                                  # noqa: BLE001
        pass
    try:
        fh.close()
    except Exception:                                  # noqa: BLE001
        pass


def wait_device(serial=None, timeout=120):
    t = time.time()
    while time.time() - t < timeout:
        r = adb(["devices"])
        if r:
            lines = [ln.split("\t", 1)[0] for ln in r.stdout.splitlines()
                     if "\tdevice" in ln]
            if serial:
                if serial in lines:
                    return serial
            elif lines:
                return lines[0]
        time.sleep(2)
    return None


def _clean_logcat(text):
    """logcat 偶尔夹 UTF-16/NUL 与 CR；正则按 UTF-8 行匹配前先归一化，避免房号/ROM 行漏判。"""
    return text.replace("\x00", "").replace("\r", "")


def logcat_text():
    r = adb(["logcat", "-d", "-t", "600", "-v", "threadtime"], timeout=20)
    return _clean_logcat(r.stdout) if r else ""


# APP 端帧率源：mgba_mobile.c mobileRunFramesLocked() 每 ~2s 打一条 FRM：
#   FRM me=<player> emuFps=<模拟帧率> callsFps=<真实帧率> frames=<n> wall=<ms>ms
# emuFps 是模拟帧率（联机时对端等待会冻住模拟时钟，掉帧最先体现在这里），
# callsFps 是真实渲染帧率。parity 关心「游戏实际跑多快」，故取 emuFps。
# 这是 APP 端唯一可观测的 fps 源；不采集到就写 fps_app=-，绝不编造。
APP_FPS_RE = re.compile(r"emuFps=([0-9.]+)")


def app_fps_samples(text):
    """从 app logcat 文本收集 {行时间戳: emuFps}，用时间戳去重。

    只认 mGBA 的 FRM 行（LINK_ERR 等也带 emuFps，但不能混入 parity 样本）。
    无样本返回空 dict —— 驱动据此写 fps_app=-（UNOBSERVED）。
    """
    out = {}
    for line in _clean_logcat(text or "").splitlines():
        if "FRM me=" not in line:
            continue
        m = APP_FPS_RE.search(line)
        if not m:
            continue
        try:
            v = float(m.group(1))
        except ValueError:
            continue
        if not (0 < v <= 1000):            # 排除 nan/异常值
            continue
        # logcat 行首是 "MM-DD HH:MM:SS.mmm pid tid ..."，时间戳占两个 token；
        # 只取 split()[0] 会退化成日期 "11-19"，把同一天所有 FRM 合并成一个样本。
        parts = line.split(" ", 2)
        ts = " ".join(parts[:2]) if len(parts) >= 2 else line
        out[ts] = v
    return out


def median_of(values):
    """取中位数；偶数个取中间两数均值。空输入返回 None。"""
    vals = sorted(values)
    if not vals:
        return None
    n = len(vals)
    return vals[n // 2] if n % 2 else (vals[n // 2 - 1] + vals[n // 2]) / 2.0


# 房号判据：relay 广告行 + create_game_room（后者用来在双房并发时消歧）。
RELAY_RE = re.compile(r"advertised relay\s+(\S+)\s+for room\s+(\d+)")
CREATE_RE = re.compile(r'"type":"create_game_room".*?"room_id":"(\d+)".*?"node_port":(\d+)')


def room_logcat_text():
    """只取 GBoyCloud/GBoyLink 的大缓冲 logcat。

    普通 600 行缓冲会被 hello/tunnel push 洪泛冲掉 create_game_room 行；房号判据要
    跨整个 run，所以用带标签过滤的 4000 行缓冲（adb 参数以 argv 传递，-s 不转义）。
    """
    # -s 把默认过滤器设为 silent，随后 GBoyCloud:I / GBoyLink:I 覆盖为只放这两个 tag。
    r = adb(["logcat", "-d", "-t", "4000", "-v", "threadtime", "-s",
             "GBoyCloud:I", "GBoyLink:I"], timeout=20)
    return _clean_logcat(r.stdout) if r else ""


def extract_room(txt):
    """返回 app 当前持有房的房号（供启动读房号 + 运行中检测重开房 + 断言复用）。

    * 正常：取**最后一条** `advertised relay ... for room R`（任务要求：始终跟最新广告）。
    * attempt-4 特例：外部 watchdog 补发 CLOUD 后，app 解散旧房(572161)重建新房
      (505099)，两个线程长期交替广告两个房号，"最后一条"会在两者间抖动。此时用
      最近一条带 node_port 的 `create_game_room` room_id 消歧——它正是 app 真正持有
      并广告 relay 的那个房，因此取到的仍是"最新广告行对应的房号"。
    """
    ads = RELAY_RE.findall(txt)                 # [(addr, room), ...]，按时间顺序
    if not ads:
        return None
    rooms = [rm for _, rm in ads]
    last_ad = rooms[-1]
    if len(set(rooms)) == 1:
        return last_ad
    hosted = None
    for line in txt.splitlines():
        m = CREATE_RE.search(line)
        if m:
            hosted = m.group(1)                 # 最近一次 create_game_room 的 room_id
    return hosted if hosted in set(rooms) else last_ad


def rom_uuid(path):
    """按 app 的 GBoyCloudLink.gameUuid() 同口径算 uuid = gameCode(0xAC..0xB0)+','+md5。

    驱动必须校验的是「本轮真正推送给 app 的那份 ROM」的 uuid，而不是文档里写死的
    BPEE,5038… —— ROM 每次重建 md5 都会漂。返回 (uuid, md5)；读不到返回 (None, None)。
    """
    try:
        with open(path, "rb") as f:
            data = f.read()
    except OSError:
        return None, None
    md5 = hashlib.md5(data).hexdigest()
    code = "".join(chr(b) if 0x20 <= b < 0x7F else "0" for b in data[0xAC:0xB0])
    return (code if len(code) == 4 else "BPEE") + "," + md5, md5


def main():
    try:
        sys.stdout.reconfigure(encoding="utf-8", errors="replace")
    except Exception:                             # noqa: BLE001
        pass
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", default="XDEV")
    ap.add_argument("--mode", default="AUTO", choices=["AUTO", "A", "B"])
    ap.add_argument("--runsec", type=int, default=420)
    ap.add_argument("--avd", default="mgba_test")
    ap.add_argument("--no-emulator", action="store_true",
                    help="不启动 emulator，连已存在的设备/AVD（配合 --serial 用真机）。")
    ap.add_argument("--serial", default=None, help="adb 设备序列号（真机必填）。")
    ap.add_argument("--room", default=None,
                    help="指定房号（此时 app 为 join，跳过 host 广播）；默认 app 先建房。")
    ap.add_argument("--app-user", default=None, help="app 端账号（必须与 PC 不同）。")
    ap.add_argument("--app-pass", default=None)
    ap.add_argument("--pc-acc", default=DEF_PC_ACC, help="PC 端 邮箱:密码[:房号]。")
    ap.add_argument("--app-rom", default=APP_ROM, help="推到 app 的原始 ROM（uuid 与 PC 不同）。")
    ap.add_argument("--pc-rom", default=PC_ROM, help="PC 端 ROM（填充字节改过 md5）。")
    ap.add_argument("--sav", default=DEF_SAV, help="PC 端存档母本（每轮干净副本）。")
    ap.add_argument("--stable-sec", type=float, default=3.0)
    ap.add_argument("--fast-early", action="store_true",
                    help="MGBAX_FAST_MIN_OK=8（主机快帧提前放行）。")
    ap.add_argument("--force-full-menu", action="store_true",
                    help="app-nav: 忽略标题屏假 LINKUP_OK 早退，强制走到 cable_club 段后再放行；"
                         "默认关（原有行为不变），可逆。")
    ap.add_argument("--fast-min-ok-slave", type=int, default=None,
                    help="MGBAX_FAST_MIN_OK_SLAVE（从机快帧门，默认 C 侧 256）。")
    ap.add_argument("--fast-slave-align", type=int, default=None,
                    help="MGBAX_FAST_SLAVE_ALIGN（Agent 1：从机快帧要求两端 idx 对齐，典型 4）。")
    ap.add_argument("--fast-align", action="store_true",
                    help="一键组合 FAST_MIN_OK=8 + FAST_MIN_OK_SLAVE=8 + FAST_SLAVE_ALIGN=4。")
    ap.add_argument("--env", action="append", default=[], metavar="K=V",
                    help="显式覆盖 PC 环境变量（在清理继承环境之后应用），可重复。"
                         "用于 MGBAX_SIO_CONNECT_POLL=0 / MGBAX_SIO_FAST=0 等 A/B 对照。")
    ap.add_argument("--app-nav", action="store_true",
                    help="启用 app 侧游戏导航：title→游戏→有线俱乐部→单打→等待连接。"
                         "默认 OFF（原有行为不变：只有 PC 有 nav_at）。启用后会推入预置存档、"
                         "用 PEEK logcat 作状态 oracle 驱动 KEYS 广播，并在 summary 落 "
                         "app_nav_* 判据。")
    ap.add_argument("--attach-existing", action="store_true",
                    help="E1-60FPS: 跳过 APP 重建(pm clear/push/am start/ROM)，接管已运行的 APP。"
                         "用于保留 angle-vulkan 下首次 EGL 上下文的 60fps；重建会回退 SwiftShader 4fps。"
                         "需配合 --app-nav 让 driver 自动导航现有 APP 到 waiting。默认 OFF。")
    ap.add_argument("--app-sav", default=APP_SAV_DEFAULT,
                    help="app 端预置存档（spawn 在俱乐部柜台 pos=10,4），仅 --app-nav 时推入。")
    ap.add_argument("--no-app-seat-walk", action="store_true",
                    help="--app-nav 时跳过 LINKUP 成功后的 app 座位走位（默认执行，目标 (10,5)）。")
    ap.add_argument("--pathb-skip-seat", action="store_true",
                    help="--mode B 时 POST-LINKUP 跳过 app 座位走位：path B 的对手来自镜像核 "
                         "savestate，不依赖 APP 走到物理座位，直接进入等待/采样。"
                         "纯控制流，默认 OFF（原有行为不变），可逆。")
    ap.add_argument("--pathb-sync-start", action="store_true",
                    help="--mode B 时 P2P 启动同步：PC 先以无房号 AUTOLINK 建房，APP 随后"
                         "带房号入房，使两端 4s 候选公告窗口落在同一时刻（原串行流程 PC"
                         "晚 ~20s，窗口不重叠→单边放弃/分裂）。纯控制流，默认 OFF"
                         "（原有 APP host 行为不变），可逆。仅修同步，不预设 P2P 成功。")
    ap.add_argument("--pathb-tcp", action="store_true",
                    help="--mode B 时 TCP 直连（GRAYPATH4 拓扑②）：PC 设 "
                         "MGBAX_TCP_LISTEN=15678 监听，APP 以 --es peer 10.0.2.2:15678 "
                         "作 TCP client 连入（emulator 宿主别名，无需 adb forward）。"
                         "同时设 MGBAX_NO_DIRECT=1 关 UDP 打洞（官方候选顺序 UDP 优先，打洞成功则 TCP env 永不触发）；"
                          "只换 game-data 传输，CLOUD 邮箱登录广播保留；身份缺口用 "
                         "vpn_split STUN 探测补 public_ip_* 摘要（真实测量，非造 email/"
                         "party/CROSSED）。纯控制流，默认 OFF，可逆；不预设直连成功。")
    ap.add_argument("--pathb-pc-nav", action="store_true",
                    help="--mode B 时给 PC 可见核恢复导航输入：把 MGBAX_NAV_AT=1500/"
                         "MGBAX_NAV_DOWNS=2 还给 env，CloudLink 在三镜像核就绪后写 nav_at，"
                         "可见核经 ScriptedControl 从菜单走到等待/战斗（PB15 缺口修复，"
                         "与 cloud2p-duo.py path B 对称）。纯驱动输入修复、非造假；"
                         "默认 OFF（原有 mode B 行为不变），可逆，不预设成功。")
    ap.add_argument("--pathb-native-sio", action="store_true",
                    help="W92/path B：下发三端同名门 MGBAX_PATHB_NATIVE_SIO=1（默认关可逆）。"
                         "PC 走 env；Android 走 debug.mgbax.link.pathb_native_sio setprop。"
                         "门开让本机 SIO 字路由原生完成握手/块交换、消 HSBYPASS 灰区依赖；"
                         "禁写真握手字、sidecar 早退、gEnemyParty 由游戏自己 SIO 组装。"
                         "不造 party/信任位/CROSSED；门开≠成功，CROSSED 唯一裁决，不预设成功。")
    ap.add_argument("--isync-state-apply", action="store_true",
                    help="ISYNC23：下发三端同名门 MGBAX_ISYNC_STATE_APPLY=1（默认关可逆）。"
                         "PC 走 env；Android 无 setprop API，改在 ROM 加载就绪后、CLOUD/"
                         "联机启动前发广播 io.mgba.android.action.ISYNC_STATE_APPLY --ez on true"
                         "并回读 logcat 里程碑。门开只启有界重试/诊断，不造成 seed applied；"
                         "applied 仅作只读观测，不预设成功、不判 PASS。")
    ap.add_argument("--isync-seed-frame-boundary", action="store_true",
                    help="RACEBROAD：下发三端同名根治门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1"
                         "（默认关可逆）。PC 走 env；Android Java 不读 debug.* 属性，"
                         "改在 ROM 加载就绪后、CLOUD/seed 到达前发广播 "
                         "io.mgba.android.action.ISYNC_SEED_FRAME_BOUNDARY --ez on true "
                         "并回读 logcat 里程碑 [ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1。"
                         "门开只启 seed 帧边界同步时序，门开≠压测有效；"
                         "CROSSED 唯一裁决，FAIL/0/9 不变，不预设成功。")
    ap.add_argument("--isync-evidence", action="store_true",
                    help="BOOTSTRAP/ISYNC-EV：下发三端同名总门 MGBAX_ISYNC_EVIDENCE=1 + "
                         "子开关 MGBAX_ISYNC_EVIDENCE_A1=1（默认关可逆，独立于 --isync-state-apply）。"
                         "PC 走 env；Android 广播 io.mgba.android.action.ISYNC_EVIDENCE --ez on true 并回读。"
                         "只启 A1 seed sha256 只读埋点（SEND/LAND/BOOT），不造 seed/party/信任位；"
                         "门开≠C5 PASS，不预设成功。")
    ap.add_argument("--opponent-visual", choices=["real", "fake", "unobserved"],
                    default="unobserved",
                    help="人工核对战斗截图后的视觉判据：出现「野生的」/问号球=fake；"
                         "真实对手精灵=real；未核对=unobserved。fake 直接判对手 FAIL。")
    ap.add_argument("--battle-hold-sec", type=float, default=25.0,
                    help="进战斗后继续长稳采样秒数（每 1s 记 rem/brs/st/cmdguard/cb2/fps/RTT，"
                         "用于判定「不卡帧不断链」；0=关闭，保持旧行为）。")
    ap.add_argument("--preflight", action="store_true")
    args = ap.parse_args()

    # ISYNC23：门与 applied 只读观测上下文（默认关；广播/回读如实记录，不预设成功）
    isync_ctx = {"enabled": bool(args.isync_state_apply),
                 "broadcast_sent": False, "gate_readback": "UNOBSERVED",
                 "ev_enabled": bool(args.isync_evidence),
                 "ev_broadcast_sent": False, "ev_gate_readback": "UNOBSERVED",
                 "sfb_enabled": bool(args.isync_seed_frame_boundary),
                 "sfb_broadcast_sent": False, "sfb_gate_readback": "UNOBSERVED"}

    app_user = args.app_user or DEF_APP_ACC.split(":", 1)[0]
    app_pass = args.app_pass or DEF_APP_ACC.split(":", 1)[1]

    gdir = os.path.join(BASE, args.tag)
    os.makedirs(gdir, exist_ok=True)
    logf = open(os.path.join(gdir, "avd_driver.log"), "w", encoding="utf-8")

    def log(msg):
        line = "[%s] %s" % (time.strftime("%H:%M:%S"), msg)
        print(line, flush=True)
        logf.write(line + "\n")
        logf.flush()

    # --no-emulator --serial emulator-5554 仍是在用 AVD（复用已启动的后端），不是真机；
    # 只有序列号不是 emulator-* 时才记 REAL-DEVICE，避免把 AVD 证据冒充真机（E7）。
    scope = ("REAL-DEVICE" if (args.no_emulator and args.serial
                               and not args.serial.startswith("emulator-"))
             else "CROSS-DEVICE-AVD")
    log("scope=%s topology=avd mode=%s" % (scope, args.mode))
    log("preflight: EXE=%s emulator_AVD=%s rom_app=%s rom_pc=%s"
        % (os.path.exists(EXE), args.avd, os.path.exists(args.app_rom),
           os.path.exists(args.pc_rom)))
    if args.preflight:
        log("PREFLIGHT 完成")
        return 0
    for p in (EXE, args.app_rom, args.pc_rom, args.sav):
        if not os.path.exists(p):
            log("FATAL: 缺少 %s" % p)
            return 2

    # ---------- 1. 启动 AVD ----------
    emu_proc = None
    if not args.no_emulator:
        env = dict(os.environ)
        env["ANDROID_AVD_HOME"] = AVD_HOME
        # AVDWIPE-01：禁今日劣化的 quickboot 快照(saveOnExit 持续覆写)+全新 userdata，
        # 恢复 11/19 稳定输入层。env MGBAX_AVD_WIPE 可回退到默认行为。
        _wipe = os.environ.get("MGBAX_AVD_WIPE", "1") == "1"
        # K1 坐实：'angle_indirect' 是非法 GPU 选项 → emulator fallback SwiftShader 软渲染(~4fps)，
        # 拖垮 SIO 字率致 want≠got 漂移。改 host(硬件加速)；env MGBAX_AVD_GPU 可回退。
        _gpu = os.environ.get("MGBAX_AVD_GPU", "angle-vulkan")
        _emu_args = [EMULATOR, "-avd", args.avd, "-no-window", "-gpu", _gpu]
        if _wipe:
            _emu_args += ["-wipe-data", "-no-snapshot", "-no-snapshot-save", "-no-snapshot-load"]
        log("启动 emulator %s (AVD_HOME=%s wipe=%s)"
            % (" ".join(_emu_args[1:]), AVD_HOME, _wipe))
        emu_proc = subprocess.Popen(
            _emu_args,
            cwd=ROOT, env=env,
            stdout=open(os.path.join(gdir, "emulator.log"), "w"),
            stderr=subprocess.STDOUT)
    serial = wait_device(args.serial)
    if not serial:
        log("FATAL: adb 没等到 device")
        return 3
    log("设备就绪 serial=%s" % serial)
    ADB = [ADB_BIN, "-s", serial]

    def shell(argv, timeout=60):   # A14 教训：adb shell CLOUD 广播偶发 >30s，放宽到 60s 不重发广播
        try:
            return subprocess.run(ADB + ["shell"] + list(argv), capture_output=True,
                                  text=True, encoding="utf-8", errors="replace",
                                  timeout=timeout)
        except Exception as ex:                    # noqa: BLE001
            log("  !! adb shell 失败 %s: %s" % (" ".join(argv), ex))
            return None

    # ---- AD5/沉浸层 dismiss（默认开，env 可关）--------------------------------
    # 根因实证(2026-11-23)：-wipe-data 全新 userdata 首次启动，系统 ImmersiveModeConfirmation
    # 覆盖层("Viewing full screen / Got it")抢走 mCurrentFocus，截图 oracle 看到对话框非游戏、
    # 按键被吞。实测 swipe 从顶部下滑即可 dismiss 并使 mCurrentFocus 回到 EmulatorActivity。
    IMMERSIVE_DISMISS = os.environ.get("MGBAX_IMMERSIVE_DISMISS", "1") == "1"
    def dismiss_immersive():
        if not IMMERSIVE_DISMISS:
            return
        def focus():
            r = shell(["dumpsys", "window"])
            m = re.search(r"mCurrentFocus=Window\{[^}]*\s([^\s}]+)\}", r.stdout) if r else None
            return m.group(1) if m else ""
        try:
            for attempt in range(3):
                cur = focus()
                if "ImmersiveModeConfirmation" in cur:
                    log("沉浸覆盖层遮挡(mCurrentFocus=%s)，swipe 顶部下滑 dismiss (第%d次)"
                        % (cur, attempt + 1))
                    shell(["input", "swipe", "240", "5", "240", "400", "400"])
                    time.sleep(2)
                    if "EmulatorActivity" in focus():
                        log("沉浸层已 dismiss，焦点回到 EmulatorActivity")
                        return
                else:
                    return  # 无覆盖层，无需处理
            log("WARN: 沉浸层 dismiss 3 次未确认焦点，继续(诊断标注)")
        except Exception as ex:                    # noqa: BLE001
            log("WARN: dismiss_immersive 异常 %s，继续" % ex)

    # ================= app 侧导航助手（--app-nav）===============================
    # 全部只依赖已定义的 shell()/log()/ADB。PEEK 是唯一状态 oracle；按键走
    # android_drive.py 的 KEYS 广播（每次按键前显式 release，防 A 粘键）。
    app_nav_fh = None

    def app_nav_log(msg):
        line = "[%s] %s" % (time.strftime("%H:%M:%S"), msg)
        log("APP-NAV " + msg)
        nonlocal app_nav_fh
        nav_path = os.path.join(gdir, "app_nav.log")
        if app_nav_fh is None or app_nav_fh.closed:
            app_nav_fh = open(nav_path, "a" if os.path.exists(nav_path) else "w",
                              encoding="utf-8")
        app_nav_fh.write(line + "\n")
        app_nav_fh.flush()

    def akeys(mask):
        return shell(["am", "broadcast", "-a", "io.mgba.android.action.KEYS",
                      "--ei", "mask", str(mask)])

    def app_press(mask, hold=0.9, settle=1.2):
        """显式松键→按下→松键（GBA 输入边沿触发；长按无新边沿）。"""
        akeys(0)
        time.sleep(0.35)
        akeys(mask)
        time.sleep(hold)
        akeys(0)
        time.sleep(settle)

    def p2_confirm_a(s):
        """W2: linkup 确认相位机（仅 MGBAX_NAV_CONFIRM_A_ONCE 门开时调用）。
        主机在 st4/pc2/map2.3 柜台等待态，需按游戏任务窗口发两次 A 边沿：
          mm=3（自动滚动框）→ 不按；mm=0（框隐藏）→ 一记 A 边沿（hold≥1模拟帧）；
        第二次 mm=0 后再发一次 → adv 应 0→1（gShouldAdvanceLinkState，P2 命中判据）。
        不写任何游戏态/不造数据，纯 KEYS 广播受控输入。返回 True=adv 已翻1（可进P3）。"""
        if not confirm_a_ctx["entered"]:
            confirm_a_ctx["entered"] = True
            confirm_a_ctx["start"] = time.time()
            confirm_a_ctx["adv_before"] = s.get("adv", 0)
            app_nav_log("P2 确认相位机启动: st=%d pc=%d map=%d.%d mm=%d adv=%s"
                        % (s["lkst"], s["lkpc"], s["map"][0], s["map"][1],
                           s["mm"], confirm_a_ctx["adv_before"]))
        # 止损：st 掉回 / map 跳 25.25 / 超时
        if s["lkst"] < 4 or (s["map"] and s["map"][0] == SEAT_MAP_GROUP):
            app_nav_log("P2 fail-closed: st=%d map=%s（脚本重开链/错图），停 A"
                        % (s["lkst"], str(s["map"])))
            return "stop"
        if time.time() - confirm_a_ctx["start"] > 180:
            app_nav_log("P2 fail-closed: 180s 超时 adv 未翻，停 A")
            return "stop"
        # adv 已翻 → P2 成功
        if s.get("adv", 0) == 1 and confirm_a_ctx["adv_before"] == 0:
            app_nav_log("P2 命中: adv 0→1（linkup 确认成功），转 P3")
            return "done"
        mm = s["mm"]
        if mm == 3:
            # 自动滚动框：不按 A（框自行隐藏，按了也不会命中边沿）
            if confirm_a_ctx["phase"] != 3:
                confirm_a_ctx["phase"] = 3
                app_nav_log("P2: mm=3 自动滚动框，等待隐藏（不按 A）")
            return "wait"
        # mm==0：框隐藏窗口，发一记 A 边沿（hold 1.5s≈≥1模拟帧，settle 1.2s）
        app_nav_log("P2: mm=0 框隐藏，发 A 边沿（phase %d→%d）"
                    % (confirm_a_ctx["phase"], confirm_a_ctx["phase"] + 1))
        app_press(AK_A, 1.5, 1.2)
        confirm_a_ctx["phase"] += 1
        return "wait"

    def discover_walk_tid():
        """W13/NX12：内容签名动态发现走位核 TID（fail-closed，命中不唯一返回 None）。

        ① 先试 link 前签名 open=0 / lkst==1 / cur=0/0（W13 原口径）；
        ② 未命中再试后_LINKUP 签名 open=0 / lkst>=4 / cur_a==0 / cur_b∈{0,1,4}
           （04 轮 post-linkup 实际 st4/cur=0/4、0/1，旧签名完全不匹配 ⇒ TID 未发现）。
        任一签名命中恰好 1 个 TID 才返回，否则 None（不猜核）；两签名为优先级回退，
        不做并集，避免静止核混入导致误判多 TID。
        """
        r = shell(["logcat", "-d", "-t", "1600", "-v", "threadtime",
                   "-s", "mGBA:I"], timeout=25)
        if not r:
            return None
        recs = _peek_records(_clean_logcat(r.stdout))
        for matcher in (
            lambda sg: (sg.group("open") == "0" and sg.group("lkst") == "1"
                        and sg.group("cura") == "0" and sg.group("curb") == "0"),
            lambda sg: (sg.group("open") == "0" and int(sg.group("lkst")) >= 4
                        and sg.group("cura") == "0" and sg.group("curb") in ("0", "1", "4")),
        ):
            tids = set()
            for rec in recs:
                sig = PEEK_SIG_RE.search(rec["line"])
                if sig and matcher(sig):
                    tids.add(rec["tid"])
            if len(tids) == 1:
                return next(iter(tids))
        return None

    def peek_state(tid=None):
        """W13 读核修复：取指定 TID（走位核）的最后一条 PEEK。

        旧实现 raw=lines[-1] 把两核 PEEK 混在一个列表取末行，70-78% 命中静止核
        ⇒ 走位读到静止核 pos、taps=0 早退。现在按 TID 过滤后取该核末行。
        tid=None 仅作发现不到走位核时的兜底（保留旧语义，不假装读到正确核）。
        """
        r = shell(["logcat", "-d", "-t", "1600", "-v", "threadtime",
                   "-s", "mGBA:I"], timeout=25)
        if not r:
            return None
        recs = _peek_records(_clean_logcat(r.stdout))
        if tid is not None:
            recs = [rec for rec in recs if rec["tid"] == str(tid)]
        if not recs:
            return None
        raw = recs[-1]["line"]
        m = PEEK_RE.search(raw)
        if not m:
            return {"line": raw, "raw_ok": False}
        (st, lkm, lkst, lkid, lkpc, px, py, mg, mn, cb2, mm, pt,
         s01a, s01b, slot, cura, curb) = m.groups()
        rcv = re.search(r"rcvpl=(-?\d+)", raw)
        # W2: adv=gShouldAdvanceLinkState（link.c:1150）是 P2 linkup 确认命中的决定性判据
        adv = re.search(r"\badv=(-?\d+)\b", raw)
        return {
            "line": raw, "raw_ok": True, "tid": recs[-1]["tid"],
            "st": int(st, 16), "lkm": int(lkm), "lkst": int(lkst),
            "lkid": int(lkid), "lkpc": int(lkpc),
            "rcvpl": int(rcv.group(1)) if rcv else 0,
            "adv": int(adv.group(1)) if adv else 0,
            "pos": (int(px), int(py)), "map": (int(mg), int(mn)),
            "cb2": int(cb2, 16), "mm": int(mm), "pt": int(pt),
            "cur": (int(cura), int(curb)), "slot": int(slot),
        }

    def cb2_class(cb2):
        # 严格判据：只有 BattleMainCB2 本体算进战斗；InitBattle/StartBattle/错误屏不算。
        if S_LO <= cb2 < S_HI:
            return "battle"
        if cb2 == 0:
            return "zero"
        return "game"

    def peek_norm(s):
        """去抖用的归一化签名（NAVSTATE §6）。"""
        return (s["cur"][0], s["cur"][1], s["mm"] == 0,
                s["lkpc"], s["lkst"], cb2_class(s["cb2"]))

    def peek_brief(s):
        if not s or not s.get("raw_ok"):
            return (s or {}).get("line", "<no PEEK>")[-220:]
        return ("link[m=%d st=%d id=%d pc=%d] pos=%d,%d map=%d.%d "
                "cb2=%08X mm=%d cur=%d/%d st=%08X"
                % (s["lkm"], s["lkst"], s["lkid"], s["lkpc"],
                   s["pos"][0], s["pos"][1], s["map"][0], s["map"][1],
                   s["cb2"], s["mm"], s["cur"][0], s["cur"][1], s["st"]))

    app_nav_state = {
        "enabled": bool(args.app_nav), "reached": "disabled",
        "taps": 0, "samples": 0, "final_peek": "", "seat_ok": False,
        "overshoots": 0,   # W22 落点校验真实记录（不伪造 0）
    }
    walk_ctx = {"tid": None}   # W81 走位核 TID 经此传给 _walk_peek（不重复 discover）
    pc_guard_ctx = {"last": 0.0, "resyncs": 0, "log_off": 0, "joined": False}
    linkup_ctx = {"seen": False, "master": False}
    # W2: P2 linkup 确认相位机（按游戏任务阶段发 A，不按 st/pc 盲 tap）
    confirm_a_ctx = {"entered": False, "phase": 0, "last_a": 0.0, "start": 0.0,
                     "adv_before": None, "log": []}

    def app_linkup_seen():
        """LINKUP_OK 是一次性事件（PC 侧 lstate=4/pc=2 也印证），PEEK 的
        link pc=2 只持续几帧就会被采样漏掉；改从 app logcat 抓这一条里程碑。"""
        r = shell(["logcat", "-d", "-t", "2000", "-s", "mGBA:I"], timeout=25)
        hit = r and re.search(r"LINKUP_OK st=4 pc=2 master=(\d+)", _clean_logcat(r.stdout))
        if hit and hit.group(1) == "1":
            linkup_ctx["master"] = True   # app 才是主机：PC 侧 st 自然没有 0x20 位
        return bool(hit)

    # 截图 oracle：本轮 app 构建里 PEEK 的 NAV_EW 地址自解析漂移，实测 app 明明站在
    # 俱乐部柜台（截图佐证）而 PEEK 仍全零（cb2=0 pos=0,0 cur=0/0）⇒ PEEK 不能作
    # 导航判据。改用任务书允许的另一路 oracle：`adb exec-out screencap -p`，完全复用
    # final_battle.py / walk_battle.py 已验证的取景 + 指纹 + advance + topmenu 判据。
    app_shot_dir = os.path.join(gdir, "app_nav_shots")
    app_nav_ctx = {"tpl": None}

    def app_shot_sig():
        try:
            from PIL import Image
        except ImportError:
            return None
        try:
            r = subprocess.run(ADB + ["exec-out", "screencap", "-p"],
                               capture_output=True, timeout=90)
            if r.returncode != 0 or not r.stdout:
                return None
            im = Image.open(io.BytesIO(r.stdout)).convert("L")
            w, h = im.size
            # 与 final_battle.view() 同取景：800x480 用固定框，大屏按比例。
            if w >= 1600:
                box = (int(w * 0.1917), int(h * 0.0370),
                       int(w * 0.7542), int(h * 0.8704))
            else:
                box = (135, 35, 690, 405)
            crop = im.crop(box).resize((480, 320))
            sig = list(crop.resize((120, 90)).getdata())
            return crop, sig
        except Exception as ex:                       # noqa: BLE001
            app_nav_log("screencap 失败: %s" % ex)
            return None

    def sig_dist(a, b):
        if a is None or b is None:
            return -1.0
        return sum(abs(x - y) for x, y in zip(a, b)) / len(a)

    def topmenu_sig():
        if app_nav_ctx["tpl"] is None:
            try:
                from PIL import Image
                p = os.path.join(ROOT, ".workbuddy", "drive", "tpl_and_linkmenu.png")
                app_nav_ctx["tpl"] = list(
                    Image.open(p).convert("L").resize((120, 90)).getdata())
            except Exception as ex:                   # noqa: BLE001
                app_nav_log("模板读取失败 %s" % ex)
                app_nav_ctx["tpl"] = []
        return app_nav_ctx["tpl"]

    # ---- AF6 等开场动画走完（ROM 加载后播 Game Freak Logo→战斗→主菜单，约 157s）----
    # 性质：只读截图做模板/演变匹配，不注入任何按键、不改游戏态；等到主菜单才导航，
    # 解决"导航从黑屏就开始、按键被动画吞"的入口轴时序 bug（AF1 读图实证）。
    def intro_menu_sig():
        if app_nav_ctx.get("intro_tpl") is None:
            try:
                from PIL import Image
                p = os.path.join(ROOT, ".workbuddy", "drive", INTRO_TPL_NAME)
                app_nav_ctx["intro_tpl"] = list(
                    Image.open(p).convert("L").resize(INTRO_SIG_SIZE).getdata())
            except Exception as ex:                   # noqa: BLE001
                app_nav_log("主菜单模板读取失败 %s（退回演变判据）" % ex)
                app_nav_ctx["intro_tpl"] = []
        return app_nav_ctx["intro_tpl"]

    # AV1/AV1b: intro 连打键推进（newKeys 单帧边沿，长按无效 → 用 0→mask→0 脉冲）。
    # AV1b 修正：每个边沿后必查 cb2，一旦落 field 段立即停手——否则连打 START 会把
    # 已到 field 的游戏推回 main_menu（AV1 实测 081A5039↔0818FE79 严格交替震荡）。
    def intro_pulse_step():
        # ZEROE2E: burst 内连续发(不每边沿查 logcat,否则打乱节奏致命中率极低),
        # 整个 burst 发完查一次 cb2。手动密集连打18-25脉冲能稳定跳过动画,据此提高密度。
        for _ in range(INTRO_PULSE_BURST):
            akeys(0)
            time.sleep(INTRO_PULSE_GAP)
            akeys(INTRO_PULSE_MASK)
            time.sleep(INTRO_PULSE_HOLD)
            akeys(0)
            time.sleep(INTRO_PULSE_GAP)
        ps = peek_state()
        cb = (ps.get("cb2", 0) & ~1) if ps else 0
        if cb and NAV_FIELD_CB2_LO <= cb < NAV_FIELD_CB2_HI:
            app_nav_log("AV1b: burst后 cb2 已落 field 段(%08X)，停手防推回菜单" % cb)
            return True
        return False

    def app_wait_intro_done():
        t0 = time.time()
        last_sig = None
        changes = 0
        stable = 0
        seen_bright = False
        candidate = None       # AG3: 首次命中候选，二次确认后放行
        candidate_t = 0.0
        map_streak = 0         # AG4: PEEK map 连续命中竞技场的计数
        # AT1/AQ1: cb2 field 段稳定计数——游戏真到 field(有 avatar 可走)的权威信号，
        # 替代 2.2fps 下不可靠的截图 template。cb2 可观测性已由 AK1 gMain 锚定修好。
        field_cb2_streak = 0
        last_field_cb2 = None
        field_pulse_hold = False    # AV1b: 脉冲曾到 field → 停发，让 streak 累积
        tpl = intro_menu_sig()
        app_nav_log("INTRO-WAIT 开始 cap=%.0fs tpl=%s min_wait=%.0fs bright=%.0f"
                    % (INTRO_WAIT_CAP_S, bool(tpl), INTRO_MIN_WAIT_S, INTRO_BRIGHT_LUMA))
        while time.time() - t0 < INTRO_WAIT_CAP_S:
            if app_pid() is None:
                time.sleep(INTRO_SAMPLE_SEC)
                continue
            shot = app_shot_sig()
            if not shot:
                time.sleep(INTRO_SAMPLE_SEC)
                continue
            sig = shot[1]
            luma = sum(sig) / len(sig)
            td = sig_dist(tpl, sig) if tpl else -1.0
            elapsed = time.time() - t0
            if luma >= INTRO_BRIGHT_LUMA:
                seen_bright = True
            if last_sig is not None:
                sd = sig_dist(last_sig, sig)
                if sd >= INTRO_CHANGE_EPS:
                    changes += 1
                    stable = 0
                elif sd < INTRO_STABLE_EPS:
                    stable += 1
                else:
                    stable = 0
            last_sig = sig
            # AG3 修正：模板命中必须满足 seen_bright(已过高亮演出段) + stable>=3(静止) + 最小等待。
            # 原 hit_tpl 只看 td<12，Logo 暗帧(td=9.7 luma=19.6)误命中；加此三条件挡掉。
            hit_tpl = (td >= 0 and td < INTRO_MENU_THRESH and seen_bright
                       and stable >= INTRO_MENU_STABLE and elapsed >= INTRO_MIN_WAIT_S)
            hit_evo = (not tpl and seen_bright and changes >= INTRO_MIN_CHANGES
                       and stable >= INTRO_MENU_STABLE
                       and INTRO_MIN_LUMA < luma < INTRO_MAX_LUMA
                       and elapsed >= INTRO_MIN_WAIT_S)
            hit = hit_tpl or hit_evo
            # AG3 二次确认：首次命中记候选，INTRO_CONFIRM_SEC 后复测签名仍稳定才放行。
            if hit and candidate is None:
                candidate = sig
                candidate_t = elapsed
                app_nav_log("INTRO-WAIT 候选命中 td=%.1f luma=%.1f stable=%d，%.1fs 后复测确认"
                            % (td, luma, stable, INTRO_CONFIRM_SEC))
                time.sleep(INTRO_CONFIRM_SEC)
                continue
            # AG4 独立放行路径：club 档直接到竞技场 (25,24)/(10,5)，PEEK map 是最可靠信号，
            # 不依赖图像 seen_bright（club 档可能跳过亮演出/主菜单，图像路会死等）。
            # 连续 INTRO_MAP_STREAK 次 map/pos 命中才放行，排除哨兵(-1/-1,0/0)。
            _ps = peek_state()
            _map = _ps.get("map") if _ps else None
            _pos = _ps.get("pos") if _ps else None
            _cb2 = (_ps.get("cb2", 0) & ~1) if _ps else 0
            if (_map == (INTRO_MAP_GROUP, INTRO_MAP_NUM)
                    and _pos == (INTRO_MAP_TX, INTRO_MAP_TY)):
                map_streak += 1
            else:
                map_streak = 0
            # AT1/AQ1 权威判据：cb2 落 field 段(CB2_Overworld 族)且连续稳定 = 游戏真进 field，
            # 此时才有 avatar 可走格。替代 2.2fps 下不可靠的截图 template。
            # map/pos 由注入档立即满足，但 cb2 只在 UI 链真走完(标题→菜单→继续游戏→field)后才落 field 段。
            # BB1: 去掉 map==(25,24) 构造档专属条件——干净母本从 Oldale PC(2.3/10,4) 起步，
            # 进任意 field(含 2.3) 都应放行到 SCREENSHOT oracle 走完整 club 导航。
            if _cb2 and NAV_FIELD_CB2_LO <= _cb2 < NAV_FIELD_CB2_HI:
                if _cb2 == last_field_cb2:
                    field_cb2_streak += 1
                else:
                    field_cb2_streak = 0
                last_field_cb2 = _cb2
            else:
                field_cb2_streak = 0
                last_field_cb2 = None
            if field_cb2_streak >= NAV_FIELD_CB2_STREAK:
                try:
                    shot[0].save(os.path.join(app_shot_dir, INTRO_HIT_SHOT))
                    shot[0].save(os.path.join(app_shot_dir, "nav_000.png"))
                except Exception as ex:               # noqa: BLE001
                    app_nav_log("INTRO-WAIT 证据图保存失败（忽略）: %s" % ex)
                app_nav_log("INTRO_DONE elapsed=%.1fs reason=peek-field map=%s pos=%s "
                            "cb2=%08X field_streak=%d (游戏真到 field,有 avatar 可走)"
                            % (elapsed, _map, _pos, _cb2, field_cb2_streak))
                return True, elapsed, "peek-field"
            # 旧 peek-arena 路径（默认关 NAV_PEEK_ARENA；注入档 pos/map 假阳性，保留可回退）
            if map_streak >= INTRO_MAP_STREAK and NAV_PEEK_ARENA:
                app_nav_log("INTRO_DONE elapsed=%.1fs reason=peek-arena map=%s pos=%s streak=%d"
                            % (elapsed, _map, _pos, map_streak))
                return True, elapsed, "peek-arena"
            if hit and candidate is not None:
                if sig_dist(candidate, sig) < INTRO_STABLE_EPS and td >= 0 and td < INTRO_MENU_THRESH:
                    pass  # 图像二次确认通过（无 club 档时走此路，如真到主菜单）
                else:
                    candidate = None   # 复测失败，重新等待候选
                    app_nav_log("INTRO-WAIT 二次确认未过(漂移)，重新等待")
                    time.sleep(INTRO_SAMPLE_SEC)
                    continue
            elif not hit and candidate is not None:
                candidate = None       # 命中消失，重置
            if hit and candidate is not None:
                try:
                    shot[0].save(os.path.join(app_shot_dir, INTRO_HIT_SHOT))
                    shot[0].save(os.path.join(app_shot_dir, "nav_000.png"))
                except Exception as ex:               # noqa: BLE001
                    app_nav_log("INTRO-WAIT 证据图保存失败（忽略）: %s" % ex)
                why = "template-confirm" if hit_tpl else "evolution-confirm"
                app_nav_log("INTRO_DONE elapsed=%.1fs reason=%s td=%.1f luma=%.1f changes=%d stable=%d bright=%d"
                            % (time.time() - t0, why, td, luma, changes, stable, seen_bright))
                return True, time.time() - t0, why
            # AV1/AV1b: 未到任何放行态 → 连打键推进 UI 链（intro 出口需 newKeys）。
            # AV1b: 脉冲内到 field 即停发(hold)，让主循环 field streak 累积，不再推回菜单。
            if NAV_INTRO_KEYPUSH and not field_pulse_hold:
                if intro_pulse_step():
                    field_pulse_hold = True
                app_nav_state["intro_pulses"] = app_nav_state.get("intro_pulses", 0) + INTRO_PULSE_BURST
            time.sleep(INTRO_SAMPLE_SEC)
        app_nav_log("INTRO_DONE elapsed=%.1fs reason=cap（兜底上限，未确认主菜单）"
                    " intro_pulses=%d last_cb2=%08X"
                    % (time.time() - t0, app_nav_state.get("intro_pulses", 0), _cb2 or 0))
        return False, time.time() - t0, "cap"

    def app_advance(tag, mask, hold=0.9, settle=1.3, tries=3, threshold=0.15):
        """按键直到画面真的变了（丢键自动补，生效立刻停手）—— 与 final_battle.advance 同口径。"""
        shot = app_shot_sig()
        if not shot:
            return False, -1.0
        before = shot[1]
        for i in range(tries):
            app_press(mask, hold, settle)
            app_nav_state["taps"] += 1
            cur_shot = app_shot_sig()
            if cur_shot:
                d = sig_dist(before, cur_shot[1])
                if d > threshold:
                    app_nav_log("  %-10s OK d=%.1f" % (tag, d))
                    return True, d
                time.sleep(0.6)
                cur_shot = app_shot_sig()
                if cur_shot:
                    d = sig_dist(before, cur_shot[1])
                    if d > threshold:
                        app_nav_log("  %-10s OK d=%.1f" % (tag, d))
                        return True, d
                    before = cur_shot[1]
        app_nav_log("  %-10s NOCHG" % tag)
        return False, 0.0

    def app_nav_screenshot():
        """title → 游戏 → 有线俱乐部服务菜单 → 单打 → 等待连接（截图 oracle 兜底）。"""
        os.makedirs(app_shot_dir, exist_ok=True)
        app_nav_log("开始（timeout=%ds，oracle=screencap，PEEK 仅诊断）" % APP_NAV_TIMEOUT)
        # AF6：先等开场动画走完到主菜单，再起算 deadline（180s 全留给导航）
        if not app_nav_state.get("intro_done"):
            _ok, _elapsed, _why = app_wait_intro_done()
            app_nav_state["intro_done"] = True
            app_nav_state["intro_why"] = _why
            app_nav_log("INTRO-WAIT 收尾 ok=%s elapsed=%.1fs why=%s；deadline 重新起算"
                        % (_ok, _elapsed, _why))
        # AL1: INTRO 后若已 peek-arena 到竞技场（PEEK 现在可读 map=25.24/pos=10,5），
        # 切回 PEEK oracle——SCREENSHOT oracle 走不到 AD2 门/踩格分支，只会 timeout。
        # coord_step 门开时强制切（需要 PEEK 语义判座位格踩格）。
        if (NAV_COORD_STEP
                and str(app_nav_state.get("intro_why", "")).startswith("peek")):
            app_nav_log("AT1: field 已确认(%s) + coord_step 门开 → 切 PEEK oracle 踩格"
                        % app_nav_state.get("intro_why"))
            return app_nav_peek()
        deadline = time.time() + APP_NAV_TIMEOUT
        # 1) 标题 LOGO 只吃 START：按到画面变化为止
        for i in range(3):
            ok, _ = app_advance("start%d" % i, AK_START, 0.6, 1.0)
            if ok:
                break
        # 2) 进游戏后一路 A；识别到「交换中心/大竞技场」服务菜单时插一次 DOWN，
        #    之后继续 A 过保存确认 + 单打确认，直到连续 N 次 A 都推不动画面 = 等待连接。
        down_done = False
        stable = 0
        i = 0
        end_reason = "timeout"
        pid_miss = 0
        # AQ1: field-ready 检测（截图 oracle 走完 UI 链后，PEEK 确认真进 field 才切踩格）
        field_cb2_streak = 0
        last_field_cb2 = None
        while time.time() < deadline:
            if app_pid() is None:
                pid_miss += 1
                if pid_miss >= 3:
                    end_reason = "app-dead"
                    app_nav_log("FATAL: app 进程消失")
                    break
                time.sleep(1.0)
                continue
            pid_miss = 0
            shot = app_shot_sig()
            if not shot:
                time.sleep(1.0)
                continue
            app_nav_state["samples"] += 1
            ps = peek_state()
            if ps:
                app_nav_state["final_peek"] = ps.get("line", "")
            # AQ1 field-ready：截图 oracle 已走完 UI 链，PEEK 确认真进 field
            # (pos 在座位格 + cb2 落 field 区间且连续稳定) → 切 PEEK oracle 踩格。
            _cb2v = (ps.get("cb2", 0) & ~1) if ps else 0
            if (NAV_COORD_STEP and ps and ps.get("raw_ok")
                    and ps.get("pos") == (SEAT_TX, SEAT_TY)
                    and ps.get("map") == SEAT_MAP
                    and _cb2v and NAV_FIELD_CB2_LO <= _cb2v < NAV_FIELD_CB2_HI):
                _c = _cb2v
                if _c == last_field_cb2:
                    field_cb2_streak += 1
                else:
                    field_cb2_streak = 0
                last_field_cb2 = _c
                if field_cb2_streak >= NAV_FIELD_CB2_STREAK:
                    app_nav_log("AQ1: field-ready pos=%s map=%s cb2=%08X streak=%d → 切 PEEK oracle 踩格"
                                % (ps["pos"], ps["map"], ps["cb2"], field_cb2_streak))
                    return app_nav_peek()
            td = sig_dist(topmenu_sig(), shot[1])
            if not down_done and td >= 0 and td < 10:
                ok, d = app_advance("down", AK_DOWN, 0.6, 0.9)
                down_done = True
                stable = 0
                app_nav_log("服务菜单 td=%.1f → DOWN 大竞技场 ok=%s" % (td, ok))
                i += 1
                continue
            ok, d = app_advance("a%02d" % i, AK_A)
            stable = 0 if ok else stable + 1
            app_nav_log("i=%02d topmenu_d=%.1f change_d=%.1f stable=%d down=%s"
                        % (i, td, d, stable, down_done))
            if i % 4 == 0:
                shot[0].save(os.path.join(app_shot_dir, "nav_%03d.png" % i))
            i += 1
            if stable >= APP_STABLE_N and down_done:
                end_reason = "waiting"
                app_nav_log("到达等待连接（连续 %d 次 A 画面不变）" % stable)
                break
        app_nav_state["reached"] = end_reason
        app_nav_log("结束 reason=%s taps=%d samples=%d"
                    % (end_reason, app_nav_state["taps"], app_nav_state["samples"]))
        return end_reason

    def app_nav_peek():
        """PEEK oracle（本轮修好的 APK 已验证）：pos=10,4 / cur=a/3 服务菜单 /
        cur=a/4 模式菜单 / cur=0/1 yes-no 提示 / link pc>=1 等待。
        每键要求归一化签名连续 APP_STABLE_N 次一致，绝不每轮盲按 A。"""
        app_nav_log("PEEK oracle 路径：cur/mm/link/pos 作状态机判据")
        force_menu = bool(args.force_full_menu)
        # AD2: 构造档座位初态导航门（driver 本地 env 门，默认关可逆；非三端 C 门）
        # 读父进程 os.environ（与 MGBAX_AVD_WIPE 同风格），不经 --env 下发 PC/Android。
        nav_spawn_at_seat = os.environ.get("MGBAX_NAV_SPAWN_AT_SEAT", "0") == "1"
        app_nav_log("AD2 gate MGBAX_NAV_SPAWN_AT_SEAT=%d" % (1 if nav_spawn_at_seat else 0))
        # AF6：先等开场动画走完到主菜单，再起算 deadline（备用 PEEK oracle 路径）
        if not app_nav_state.get("intro_done"):
            _ok, _elapsed, _why = app_wait_intro_done()
            app_nav_state["intro_done"] = True
            app_nav_state["intro_why"] = _why
            app_nav_log("INTRO-WAIT 收尾 ok=%s elapsed=%.1fs why=%s；deadline 重新起算"
                        % (_ok, _elapsed, _why))
        # force 窗口与现有 APP_NAV_TIMEOUT 共存：取大者，避免 480s 先到期截断菜单路径
        deadline = time.time() + (max(APP_NAV_TIMEOUT, FORCE_MENU_WINDOW)
                                  if force_menu else APP_NAV_TIMEOUT)
        last = None
        stable = 0
        start_taps = 0
        pid_miss = 0
        end_reason = "timeout"
        # cur=0/1 在俱乐部柜台实测是「要保存游戏进度吗?」的 yes/no（光标默认在 是），
        # 不是等待连接。确认一次后必须给保存阶段墙钟时间（掉到 6fps 可达 1~2 分钟），
        # 期间反复按 A 不会推进 —— 这正是 APPNAV4 看似卡住的原因（G6）。
        save_ctx = {"entered": False, "t": 0.0, "confirmed": False}
        # AL1: 座位格踩格状态（构造档 spawn (10,5) 不走格，需 DOWN→UP 触发 coord_event）。
        coord_step = {"phase": 0, "done": False}  # phase 0=未开始 1=已DOWN待UP 2=完成
        # menu_ctx：--force-full-menu 的 cb2/cur_b 演变观测器。主判据=cb2 进 cable_club 段
        # （游戏真进有线俱乐部）或战斗窗；cur_b 3→4 是俱乐部内服务/模式菜单，仅作辅助。
        menu_ctx = {
            "seq": [],                 # cb2 序列（诊断）
            "seen_club": False,        # cb2 曾落入 cable_club 段
            "seen3": False,            # 服务菜单 cur_b=3
            "seen4": False,            # 模式菜单 cur_b=4
            "ordered": False,          # 俱乐部内 cur_b 3→4 达成（辅助，仅诊断，非菜单完成）
            "singles_confirmed": False,# 模式菜单 A 确认单打已发出（NX12：菜单完成的前提）
            "save_confirmed": False,   # 保存提示 cur=0/1 已按过 A≥4（W34 ①）
            "stage": 0,                # 单调推进阶段 0→1→2（W34 ④，只增不减）
            "locked": False,           # 菜单完成闩锁（W34 ④，置位后不回落）
            "menu_taps": 0,            # force 模式下按下的 A 次数
            "last_progress_taps": 0,   # 最近一次菜单进度时的 menu_taps
            "t0": time.time(),         # force 窗口起点
        }

        def menu_lock_done(s):
            """菜单走完（单调闩锁）：必须以「模式菜单 A 确认单打」为前提（NX3 §3.2-a）。
            模式菜单刚弹出（cur_b=4 / ordered）≠菜单完成：还差那一记 A 才会跑
            cable_club.inc:322 setvar var8004=USING_SINGLE_BATTLE。再叠加任一晚态证据
            （保存提示 A≥4 / map=竞技场 / cb2 进 club 段或战斗窗）才算真正走完。
            一旦置位不再回落，避免陈旧读数让早退门反复开合（W34 ④）。
            诚实口径：菜单完成=推断（cur/mm/link/map），PEEK 无 var8004，非直读实锤。"""
            if menu_ctx["locked"]:
                return True
            # NAVORACLE-01：实测 APP 到 map=(25,25)（对战竞技场同 group 的另一房间），
            # 老判据只认 SEAT_MAP=(25,24) 致 menu_lock_done 恒假、导航 timeout 跳过
            # POST-LINKUP。放宽为「竞技场 group==25 任一房间」+ 已有 singles_confirmed
            # + 外层 st4/pc2 守卫（menu_lock_done 只在 link 合格时被调用）——驱动输入
            # 判据修复，非造假；map 仍是真 PEEK 读值。
            _map = s.get("map")
            in_colosseum = bool(_map and _map[0] == SEAT_MAP_GROUP)
            late = (menu_ctx["save_confirmed"]
                    or s.get("map") == SEAT_MAP
                    or in_colosseum
                    or cb2_class(s["cb2"]) == "battle"
                    or CC_LO <= s["cb2"] < CC_HI)
            done = menu_ctx["singles_confirmed"] and late
            if done:
                menu_ctx["locked"] = True
            return done

        while time.time() < deadline:
            if app_pid() is None:
                pid_miss += 1
                if pid_miss >= 3:
                    end_reason = "app-dead"
                    app_nav_log("FATAL: app 进程消失")
                    break
                time.sleep(APP_NAV_POLL)
                continue
            pid_miss = 0
            pc_join_guard()
            s = peek_state()
            if not s:
                time.sleep(APP_NAV_POLL)
                continue
            app_nav_state["samples"] += 1
            app_nav_state["final_peek"] = s.get("line", "")
            if not s.get("raw_ok"):
                time.sleep(APP_NAV_POLL)
                continue
            n = peek_norm(s)

            # --- 观测 cb2/cur_b 演变（默认模式也跑，供 menu_lock 判早退） ---
            cb2, cb = s["cb2"], s["cur"][1]
            # ---- AD2 观测口径适配门（默认关，可逆）----
            # 读真 PEEK（map/pos/cb2）非造假；构造存档是受控输入，可信度存疑、
            # 非纯零注入、不进 CROSSED 裁决。三重防误判：map group==SEAT_MAP_GROUP
            # 且 pos==(SEAT_TX,SEAT_TY) 且 cb2_class!="zero"（cb2 漂移恒0时不误置）。
            if (nav_spawn_at_seat
                    and not menu_ctx["singles_confirmed"]
                    and s.get("map") and s["map"][0] == SEAT_MAP_GROUP
                    and s["pos"] == (SEAT_TX, SEAT_TY)
                    and cb2_class(s["cb2"]) != "zero"):
                menu_ctx["singles_confirmed"] = True
                app_nav_log("AD2: 座位初态源自预置档(map=%s pos=%s cb2=%08X)，"
                            "singles_confirmed 由 PEEK 推断置位（非 var8004 直读、非造假；"
                            "受控输入可信度存疑/非纯零注入、不进 CROSSED 裁决）"
                            % (s["map"], s["pos"], s["cb2"]))
            if not menu_ctx["seq"] or menu_ctx["seq"][-1] != cb2:
                menu_ctx["seq"].append(cb2)
                if len(menu_ctx["seq"]) > 24:
                    menu_ctx["seq"] = menu_ctx["seq"][-24:]
                menu_ctx["last_progress_taps"] = menu_ctx["menu_taps"]
            if CC_LO <= cb2 < CC_HI and not menu_ctx["seen_club"]:
                menu_ctx["seen_club"] = True
                menu_ctx["last_progress_taps"] = menu_ctx["menu_taps"]
            # W34 ①：seen3/seen4 原被错关在 CC_LO<=cb2<CC_HI 内，但真实服务/模式菜单
            # cb2=081897B1(CB2_Overworld) 不在 club 段 ⇒ ordered 永远置不上。改为只要
            # cb2 非战斗段且 cur_b∈{3,4} 就记录，不再受 club 守卫约束。
            # W34 ④：单调推进门——stage 0→1→2 只增不减；cur_b=4 必须先见过 3。
            if cb2_class(cb2) != "battle" and cb in (3, 4):
                if cb == 3 and menu_ctx["stage"] < 1:
                    menu_ctx["seen3"] = True
                    menu_ctx["stage"] = 1
                    menu_ctx["last_progress_taps"] = menu_ctx["menu_taps"]
                elif cb == 4 and menu_ctx["stage"] == 1:
                    menu_ctx["seen4"] = True
                    menu_ctx["ordered"] = True
                    menu_ctx["stage"] = 2
                    menu_ctx["last_progress_taps"] = menu_ctx["menu_taps"]
            # 菜单未走完的 fail-fast（仅 force 模式）：硬上限/无进度/时间窗三重保护
            if force_menu and not menu_lock_done(s):
                    stuck = None
                    if time.time() - menu_ctx["t0"] >= FORCE_MENU_WINDOW:
                        stuck = "window"
                    elif menu_ctx["menu_taps"] >= FORCE_MENU_TAP_LIMIT:
                        stuck = "tap-limit"
                    elif (menu_ctx["menu_taps"] - menu_ctx["last_progress_taps"]
                          >= FORCE_MENU_STALL_LIMIT):
                        stuck = "no-progress"
                    if stuck:
                        end_reason = "force-menu-stuck"
                        app_nav_log("FATAL: force-full-menu 未走完(%s): cb2=%08X menu_taps=%d seq=%s"
                                    % (stuck, cb2, menu_ctx["menu_taps"], menu_ctx["seq"]))
                        break

            # 终态优先级：battle > LINKUP > waiting（W34 ②：三支都无条件先过 menu_lock）。
            # LINKUP_OK 里程碑（gLink.state=4 && pc=2 && MASTER）才会真正触发
            # 游戏进入联机房间；PEEK 的瞬时 pc=2 会被 1.2s 采样漏掉，必须查 logcat。
            # 菜单未走完时灰区合成 st4/pc2 只记日志不 break，driver 继续按 A 推菜单。
            linkup_hit = (not linkup_ctx["seen"]) and app_linkup_seen()
            if menu_lock_done(s):
                if linkup_hit:
                    linkup_ctx["seen"] = True
                    end_reason = "linkup"
                    app_nav_log("logcat 捕获 LINKUP_OK st=4 pc=2（握手收尾）")
                    break
            elif linkup_hit:
                app_nav_log("忽略LINKUP早退(菜单未走完): cb2=%08X seq=%s"
                            % (s["cb2"], menu_ctx["seq"]))
            if cb2_class(s["cb2"]) == "battle":
                end_reason = "battle"
                app_nav_log("BATTLE cb2 命中: %s" % peek_brief(s))
                break
            # W2: P2 确认相位机优先（覆盖 menu_lock_done/linkup_hit 的 st4 早退判断）
            if (os.environ.get("MGBAX_NAV_CONFIRM_A_ONCE", "0") == "1"
                    and s["lkpc"] >= 2 and s["lkst"] >= 4):
                _p2 = p2_confirm_a(s)
                if _p2 == "done":
                    linkup_ctx["seen"] = True
                    end_reason = "linkup"
                    app_nav_log("P2 确认完成，结束导航转 POST-LINKUP/P3")
                    break
                elif _p2 == "stop":
                    app_nav_log("P2 fail-closed，停线（不换 tag 重跑）")
                    return False
                time.sleep(APP_NAV_POLL)
                continue
            if menu_lock_done(s):
                if s["lkpc"] >= 2 and s["lkst"] >= 4:
                    # 不因合成 st4/pc2 抢跑：须已有竞技场 map / 战斗窗客观证据（NX3 §3.2-b）
                    # NAVORACLE-01：竞技场 group==25 任一房间均算客观证据（实测 25.25）
                    _lk_in_arena = bool(s.get("map") and s["map"][0] == SEAT_MAP_GROUP)
                    if _lk_in_arena or cb2_class(s["cb2"]) == "battle":
                        end_reason = "linkup"
                        app_nav_log("LINKUP 达成(菜单走完+竞技场/战斗窗): %s" % peek_brief(s))
                        break
                    app_nav_log("忽略LINKUP早退(st4/pc2真但地图/战斗窗未到): %s" % peek_brief(s))
            elif (s["lkpc"] >= 2 and s["lkst"] >= 4
                  and os.environ.get("MGBAX_NAV_ACCEPT_ST4", "0") == "1"):
                # B2 实测修正：gen8 cable club 联机就是在柜台 (10,4) 等待对方加入后直接进战斗，
                # **不需要 warp 到竞技场**。map=2.3 st=4 是正确的联机等待态；此时继续 tap A
                # 反而把 st4 踢回 st2（13:52 实测）。故 st4/pc2 真即停 tap，不再要求 map=25.x。
                linkup_ctx["seen"] = True
                end_reason = "linkup"
                app_nav_log("NAV_ACCEPT_ST4: st=4 pc=2（cable club 等待态），停 tap 等对方加入/进战斗")
                break
            elif s["lkpc"] >= 2 and s["lkst"] >= 4:
                app_nav_log("忽略LINKUP早退(st4/pc2真但菜单未走完): cb2=%08X seq=%s"
                            % (s["cb2"], menu_ctx["seq"]))
            if menu_lock_done(s):
                if s["mm"] == 0 and s["cur"][1] == 1 and (s["lkpc"] >= 1 or s["lkst"] >= 2):
                    if n == last:
                        stable += 1
                    else:
                        last, stable = n, 1
                    if stable >= APP_STABLE_N:
                        end_reason = "waiting"
                        app_nav_log("到达等待连接（stable=%d）: %s" % (stable, peek_brief(s)))
                        break
                    time.sleep(APP_NAV_POLL)
                    continue

            # --- 保存进度 yes/no（cur=0/1）：解耦 link 态（NX3 §3.2-c）---
            # 灰区底座 st4/pc2 早已为真，旧 guard `not(lkpc>=1 or lkst>=2)` 恒假 ⇒
            # 保存分支被跳过、确认单打后的「要保存吗?」只走通用 cur_b==1→A（A×1/轮），
            # 形不成 A×4+ 的自然保存节奏。改用 singles_confirmed 作为阶段证据：
            # 只有「确认单打 A 已发出」之后的 cur=0/1 才当作保存提示（菜单前等待连接不算）。
            if s["cur"][1] == 1 and menu_ctx["singles_confirmed"]:
                if not save_ctx["entered"]:
                    save_ctx.update(entered=True, t=time.time(), confirmed=False)
                    app_nav_log("保存提示 cur=0/1：按 A 确认「是」: %s" % peek_brief(s))
                # 实测 cur=0/1 会连续出现两次（「要保存吗?」+「已存在存档,覆盖吗?」），
                # 工作探针以 ~2.3s 间隔连按 A 6 次后 link st 才从 1→2。因此这里按
                # 同样的节奏补 A（最多 8 次），而不是只按一次后干等 180s（APPNAV9 教训）。
                save_ctx.setdefault("tap_n", 0)
                if save_ctx["tap_n"] < 8:
                    app_press(AK_A, 0.9, 1.2)
                    app_nav_state["taps"] += 1
                    if force_menu:
                        menu_ctx["menu_taps"] += 1
                    save_ctx["tap_n"] += 1
                    # W34 ①：保存提示 A≥4 视为菜单自然走完的辅助证据（非 var8004 直读）
                    if save_ctx["tap_n"] >= 4:
                        menu_ctx["save_confirmed"] = True
                    save_ctx["confirmed"] = True
                    app_nav_log("保存提示 A #%d" % save_ctx["tap_n"])
                    last, stable = None, 0
                    time.sleep(1.5)
                    continue
                # 保存确认后会出现「保存中…/欢迎来到宝可梦有线俱乐部」等对话框
                # （mm=2），此时 cur 仍是上一次菜单的陈旧值 0/1。必须继续按 A
                # 把对话框推完，否则会误以为还在保存而一直空等（APPNAV7 教训）。
                if s["mm"] != 0:
                    app_press(AK_A, 0.9, 1.2)
                    app_nav_state["taps"] += 1
                    if force_menu:
                        menu_ctx["menu_taps"] += 1
                    app_nav_log("存档后续对话框 mm=%d → A" % s["mm"])
                    last, stable = None, 0
                    continue
                if time.time() - save_ctx["t"] < 180:
                    time.sleep(3)      # 保存中：不按键，只等 PEEK 签名变化
                    continue
                # 180s 仍未离开：按一次 B 退回柜台重走（B 是唯一取消键）
                app_press(AK_B, 0.6, 1.0)
                app_nav_state["taps"] += 1
                app_nav_log("保存阶段 180s 超时，按 B 退回重试")
                save_ctx.update(entered=False, t=0.0, confirmed=False, tap_n=0)
                last, stable = None, 0
                continue
            else:
                save_ctx.update(entered=False, t=0.0, confirmed=False, tap_n=0)

            # 去抖：签名稳定后才按键
            if n == last:
                stable += 1
            else:
                last, stable = n, 1
            if stable < APP_STABLE_N:
                time.sleep(APP_NAV_POLL)
                continue

            cur_a, cur_b = s["cur"]
            hold, settle = 0.9, 1.2
            # W34 ③：cb2 主导标题判定。cb2 落战斗窗或 CB2_Overworld（D.GAME_CB2，运行时
            # 解析/环境覆盖，禁裸 hex）都说明已越过标题；仅其余 game 类 cb2 才可能是
            # 标题，pos/link/cur 退为次级守卫，避免错核旧值误判 title/stuck-title。
            # cb2 是 Thumb 回调指针（如 081897B1=GAME_CB2|1），比较前清低 1 位。
            try:
                game_cb2 = int(D.GAME_CB2, 16)
            except (TypeError, ValueError):
                game_cb2 = -1
            cb2_after_title = (cb2_class(s["cb2"]) == "battle"
                               or (s["cb2"] & ~1) == (game_cb2 & ~1))
            at_title = (not cb2_after_title
                        and s["lkpc"] == 0 and s["lkst"] in (0, 1)
                        and cur_b == 0
                        and s["pos"] in ((0, 0), (-1, -1)))
            # AL1: 座位格 coord_event 踩格（构造档 spawn (10,5) 无走格 → tookStep 恒 FALSE）。
            # 在竞技场座位格且 link 未起时，DOWN 离格→UP 踩回触发 coord_event 座位事件链。
            at_seat = (s.get("map") == (SEAT_MAP_GROUP, SEAT_MAP_NUM)
                       and s["pos"] == (SEAT_TX, SEAT_TY) and s["lkst"] <= 1)
            if NAV_COORD_STEP and at_seat and not coord_step["done"]:
                # AN1: GBA 走一格需 ~16 帧；AVD 软渲染 emuFps≈2.65 ⇒ 需 6-7s。
                # 原 hold=1.0s 仅 ~2.7 帧(pos 从未到 10,6)，coord_event 不触发。
                if coord_step["phase"] == 0:
                    action, hold, settle = AK_DOWN, 7.0, 2.0
                    why = "座位格 DOWN 离格 7s(低fps走格)触发 tookStep (coord_event 前半)"
                    coord_step["phase"] = 1
                elif coord_step["phase"] == 1:
                    action, hold, settle = AK_UP, 7.0, 2.0
                    why = "座位格 UP 踩回 7s 触发 coord_event → cable club 握手"
                    coord_step["phase"] = 2
                    coord_step["done"] = True
                else:
                    action, why = AK_A, "座位格踩格后 A 推进"
            elif at_title and start_taps < 2:
                # NETDUAL-07 实测：title 按 A 无效（pos 仍 -1,-1），GBA 标题必须 START 才能进游戏。
                # 回退 START（用户"直接按 A"的意图在游戏内推进，不是标题）。
                action, hold, settle = AK_START, 0.6, 1.0
                start_taps += 1
                why = "title START #%d" % start_taps
            elif at_title:
                end_reason = "stuck-title"
                app_nav_log("FATAL: START 后仍在标题: %s" % peek_brief(s))
                break
            elif cur_b == 3:
                # 服务菜单 0=交换中心 / 1=大竞技场
                if cur_a == 0:
                    action, hold, settle = AK_DOWN, 0.6, 0.9
                    why = "服务菜单 DOWN→大竞技场"
                else:
                    action, why = AK_A, "服务菜单 A→进入大竞技场"
            elif cur_b == 4:
                # 模式菜单 0=单打（循环菜单，非 0 才用 UP 最小步归位）
                if cur_a == 0:
                    action, why = AK_A, "模式菜单 A→确认单打"
                    # NX3 §3.2-a/c：记下决定性一记 A，供 menu_lock_done / 保存分支用。
                    # 命中后游戏自然跑 cable_club.inc:322 setvar var8004=1（不用 BTLCFG 灰门）。
                    menu_ctx["singles_confirmed"] = True
                    app_nav_log("确认单打A决策点：预期 var8004 由游戏自然置1（非 BTLCFG 补写）")
                else:
                    action, hold, settle = AK_UP, 0.35, 0.6
                    why = "模式菜单 UP 归位 (cur=%d/4)" % cur_a
            elif cur_b == 1:
                action, why = AK_A, "yes/no 提示 A→是"
            else:
                action, why = AK_A, "对话/推进 A"

            app_press(action, hold, settle)
            app_nav_state["taps"] += 1
            if force_menu and action == AK_A:
                menu_ctx["menu_taps"] += 1
            app_nav_log("tap %-3s %-26s %s" % (action, why, peek_brief(s)))
            # 截图仅作诊断证据：任何失败都不能中断导航。
            try:
                sh = app_shot_sig()
                if sh:
                    sh[0].save(os.path.join(app_shot_dir,
                                            "peek_%03d.png" % app_nav_state["taps"]))
            except Exception as ex:                   # noqa: BLE001
                app_nav_log("诊断截图失败（忽略）: %s" % ex)
            last, stable = None, 0
        app_nav_state["reached"] = end_reason
        app_nav_log("结束 reason=%s taps=%d samples=%d"
                    % (end_reason, app_nav_state["taps"], app_nav_state["samples"]))
        return end_reason

    def app_navigate_to_wait():
        """根据 PEEK 是否可读自动选 oracle：优先 PEEK，失效时回落截图。"""
        os.makedirs(app_shot_dir, exist_ok=True)
        if args.app_nav:
            time.sleep(8)   # 等 console/镜像核就绪再按第一个键
        ps = peek_state()
        peek_ok = bool(ps and ps.get("raw_ok") and ps["pos"] not in ((0, 0), (-1, -1)))
        app_nav_log("oracle 选择: %s（PEEK pos=%s）"
                    % ("PEEK" if peek_ok else "SCREENSHOT",
                       ps.get("pos") if ps and ps.get("raw_ok") else "-"))
        if peek_ok:
            return app_nav_peek()
        return app_nav_screenshot()

    def app_fresh_link(timeout=12):
        """等一条**新鲜**的 PEEK 确认 link 已起（pc>=2 或 st>=4）。
        LINKUP_OK 是一次性 logcat 事件，PEEK 是 60 帧一次采样，紧跟事件读到的
        往往是事件前的旧值（lkpc=0 / cur=0/1）——A8 就是这样误判跳过座位走位。"""
        t = time.time()
        last = None
        while time.time() - t < timeout:
            s = peek_state()
            if s and s.get("raw_ok"):
                last = s
                if s["lkpc"] >= 2 or s["lkst"] >= 4:
                    return s
            time.sleep(APP_NAV_POLL)
        app_nav_log("等新鲜 link PEEK 超时（末条=%s）"
                    % (last.get("line", "")[-160:] if last else "<none>"))
        return last

    def _walk_peek():
        """读核适配层：W81 的 discover_walk_tid() 结果存在 walk_ctx["tid"]，
        这里统一经 peek_state(tid=...) 回读，W81 读核口径不变；
        tid=None 仅作发现失败时的全核兜底（不假装读到正确核）。"""
        return peek_state(tid=walk_ctx["tid"])

    def _fresh_walk_pos(after=None, timeout=WALK_POLL_S):
        """只读移动核的新鲜 PEEK；新鲜判据优先 ts（W13 threadtime），否则退化为 line。"""
        t0 = time.time()
        while time.time() - t0 < timeout:
            s = _walk_peek()
            if s and s.get("raw_ok"):
                mark = s.get("ts") or s.get("line")
                if after is None or str(mark) != str(after):
                    return s
            time.sleep(WALK_POLL_TICK)
        return None

    def _dialog_evidence(s):
        """仅用移动核 PEEK 判真对话框：mm!=0 或 cur!=(0,0)。
        静止核 cur=0/1 是保存提示，不得据此按 A。"""
        return bool(s and (s.get("mm", 0) != 0 or tuple(s.get("cur", (0, 0))) != (0, 0)))

    def _seat_reached(s):
        """座位到位唯一判据：pos==(10,5) 且 map==SEAT_MAP(25,24)。
        历史 49/49 的 (10,5) 都在 map=2.3（Oldale PC 2F），一律不算到位。"""
        # NAVORACLE-01：竞技场 group==25 任一房间（实测 25.25 与 SEAT_MAP 25.24 同 group）
        return bool(s and s.get("raw_ok")
                    and tuple(s.get("pos", (-1, -1))) == (SEAT_TX, SEAT_TY)
                    and s.get("map") and s["map"][0] == SEAT_MAP_GROUP)

    def app_seat_walk():
        """LINKUP 后把 app 走到 (10,5) 座位（walk_battle.py 的座位坐标）。
        用 PEEK pos 闭环 + 方向自校准（驱动层掩码可能与注释相反）。
        ★ 不在这里用「cur=0/1 且 pc=0」跳过：LINKUP_OK 后紧读的 PEEK 是旧值
          （A8 教训），会误判成还在对话框而永远不走位。改由 app_fresh_link() 确认。"""
        walk_tid = discover_walk_tid()
        walk_ctx["tid"] = walk_tid   # W81 走位核 TID → 共享给 _walk_peek（保留 W81 读核）
        app_nav_log("座位走位开始，目标 (10,5)，走位核TID=%s" %
                    (walk_tid if walk_tid else "<未发现,退回全核>"))
        # W22 距离档闭环 + W46 map 条件（两处到位判定一处不漏）
        def _tier_hold(d, key):
            base = (WALK_TIER_FAR if d >= 3 else
                    WALK_TIER_MID if d == 2 else WALK_TIER_FINE)
            return min(WALK_HOLD_MAX, max(WALK_HOLD_MIN, base + bias_of.get(key, 0.0)))

        def _opp(k):
            return {"up": "down", "down": "up", "left": "right", "right": "left"}[k]

        canonical = {"up": AK_UP, "down": AK_DOWN, "left": AK_LEFT, "right": AK_RIGHT}
        mask_for = dict(canonical)          # 已校准掩码（不来回翻）
        axis_of = {"up": "y", "down": "y", "left": "x", "right": "x"}
        tx, ty = SEAT_TX, SEAT_TY
        bias_of = dict.fromkeys(canonical, 0.0)
        zero_of = dict.fromkeys(canonical, 0)
        flipped = set()
        overshoots = 0
        after_mark = None
        t0 = time.time()

        # ENTRY-FIX-01：先等游戏把玩家从大厅 warp 到竞技场（map=25.24）。
        # (6,8)/(7,8) 是 25.24 内部 warp_def 落点；换图由游戏完成，driver 只轮询
        # 等待、不发方向键。错图 (2.3) 即便 pos=(10,5) 也不是座位（历史 49/49 假阳性）。
        s0 = _fresh_walk_pos(timeout=SEAT_WARP_WAIT_S)
        if not s0:
            app_nav_log("等竞技场 warp 无回读，未设 seat_ok")
            return False
        # NAVORACLE-01：竞技场 group==25 任一房间均算到达（实测 25.25）
        if not (s0.get("map") and s0["map"][0] == SEAT_MAP_GROUP):
            app_nav_log("未先到竞技场（当前 map=%s），pos=(10,5) 不作座位，不设 seat_ok"
                        % (str(tuple(s0["map"])) if s0.get("map") else s0.get("map")))
            return False
        app_nav_log("已到竞技场 map=%d.%d（座位 (10,5) 生效）" % SEAT_MAP)

        for i in range(WALK_STEP_LIMIT):
            if time.time() - t0 > WALK_DEADLINE_S:
                app_nav_log("座位走位超时（%.0fs），未到位" % WALK_DEADLINE_S)
                app_nav_state["overshoots"] = overshoots
                return False
            s = _fresh_walk_pos(after_mark)
            if not s:
                app_nav_log("走位 i=%02d 无新鲜 PEEK" % i)
                continue
            after_mark = s.get("ts") or s.get("line")
            x, y = s["pos"]
            if _seat_reached(s):
                app_nav_state["seat_ok"] = True
                app_nav_log("座位走位到位（闭环回读）(%d,%d) map=%d.%d steps=%d"
                            % (x, y, s["map"][0], s["map"][1], i + 1))
                app_nav_state["overshoots"] = overshoots
                return True
            if cb2_class(s["cb2"]) == "battle":
                app_nav_log("座位走位中 cb2 已进战斗，停止走位")
                return True
            if x < 0 or y < 0:
                continue
            dy, dx = abs(y - ty), abs(x - tx)
            key = (("up" if y > ty else "down") if dy >= dx else
                   ("left" if x > tx else "right"))
            axis = axis_of[key]
            sign = -1 if key in ("up", "left") else 1
            before = y if axis == "y" else x
            d = dx + dy
            hold = _tier_hold(d, key)
            app_nav_log("走位 i=%02d (%d,%d) d=%d key=%s hold=%.2f bias=%+.2f"
                        % (i, x, y, d, key, hold, bias_of[key]))
            app_press(mask_for[key], hold, WALK_STEP_SETTLE)

            # 落点校验：press 后必须读到**新鲜**样本再判，不沿用 press 前的 s
            s2 = _fresh_walk_pos(after_mark)
            if not s2:
                app_nav_log("走位 i=%02d 落点校验无回读" % i)
                continue
            after_mark = s2.get("ts") or s2.get("line")
            if _seat_reached(s2):
                app_nav_state["seat_ok"] = True
                app_nav_log("落点校验到位 (%d,%d) map=%d.%d steps=%d"
                            % (s2["pos"][0], s2["pos"][1],
                               s2["map"][0], s2["map"][1], i + 1))
                app_nav_state["overshoots"] = overshoots
                return True
            if cb2_class(s2["cb2"]) == "battle":
                app_nav_log("落点校验时 cb2 已进战斗，停止走位")
                return True
            after = s2["pos"][1] if axis == "y" else s2["pos"][0]
            delta = after - before
            d_after = abs(s2["pos"][0] - tx) + abs(s2["pos"][1] - ty)
            if delta == 0:
                zero_of[key] += 1
                if zero_of[key] >= 2:
                    if _dialog_evidence(s2):
                        for _ in range(3):
                            app_press(AK_A, 0.9, 1.2)
                            app_nav_state["taps"] += 1
                            time.sleep(0.6)
                            ad = _fresh_walk_pos(after_mark)
                            if ad:
                                after_mark = ad.get("ts") or ad.get("line")
                                if not _dialog_evidence(ad):
                                    break
                        app_nav_log("blocked 且移动核有对话框证据：按 A 推进后重试")
                    else:
                        app_nav_log("blocked 但移动核无对话框证据：不按 A，仅加档")
                    bias_of[key] = min(WALK_BIAS_CAP, bias_of[key] + WALK_HOLD_ADJ)
                    zero_of[key] = 0
                    # B2 绕障：单轴贪心撞墙（如 (5,8)→(10,5) 直走 right 被墙挡）时，
                    # 改走垂直轴朝目标一格绕行，否则永远卡住、APP 到不了 (10,5) 进战斗。
                    if axis == "x":
                        detour = "up" if y > ty else ("down" if y < ty else None)
                    else:
                        detour = "left" if x > tx else ("right" if x < tx else None)
                    if detour:
                        app_press(mask_for[detour], _tier_hold(1, detour), WALK_STEP_SETTLE)
                        app_nav_log("绕障：改按 %s 一格（x=%d y=%d，目标 %d,%d）"
                                    % (detour, x, y, tx, ty))
                continue
            zero_of[key] = 0
            if delta * sign > 0:
                if d_after > d:                     # 越过目标 = 真过冲
                    overshoots += 1
                    app_nav_state["overshoots"] = overshoots
                    bias_of[key] = max(-WALK_BIAS_CAP, bias_of[key] - WALK_HOLD_ADJ)
                    app_nav_log("走位 i=%02d (%d,%d) → (%d,%d) 过冲(第%d次)，减档反向微调"
                                % (i, x, y, s2["pos"][0], s2["pos"][1], overshoots))
                elif abs(delta) >= 2:                # 同向 2 格但未越界
                    bias_of[key] = max(-WALK_BIAS_CAP, bias_of[key] - WALK_HOLD_ADJ)
                    app_nav_log("走位 i=%02d Δ=%d 同向 2 格，减档" % (i, delta))
                else:
                    app_nav_log("走位 i=%02d Δ=%d 理想单格" % (i, delta))
            else:
                if key not in flipped:               # 真反向：每轴 latch 一次，不来回翻
                    mask_for[key] = canonical[_opp(key)]
                    flipped.add(key)
                    app_nav_log("走位 i=%02d 走反，锁定反掩码" % i)
                else:
                    app_nav_log("走位 i=%02d 走反但已 latch：记录不回翻" % i)

        app_nav_log("座位走位步数用尽，overshoots=%d" % overshoots)
        app_nav_state["overshoots"] = overshoots
        return False

    def app_post_linkup():
        """LINKUP 之后的收尾：推进对话框 → 走到座位 → 按 A 确认准备 → 等战斗 CB2。
        gen8 流程：state4 + rem=1 后双方进待机室，需走到座位并按 A 确认，
        若双方都确认则 cb2 进入 battle 窗口；否则 600 帧超时后链路关闭（app st=1）。"""
        deadline = time.time() + APP_NAV_TIMEOUT
        # W83 重锚：W81 读核口径延伸到 post-linkup（用其自身 discover_walk_tid，
        # 未发现则 None → _walk_peek 退回全核兜底，与 W81 旧行为一致）。
        walk_ctx["tid"] = discover_walk_tid()
        # 1) 等新鲜 link 状态，别用 LINKUP_OK 事件旁的旧 PEEK
        fresh = app_fresh_link(timeout=45)
        if fresh:
            app_nav_log("POST-LINKUP 新鲜 link: %s" % peek_brief(fresh))
        # 2) 推完待机室对话框：只用移动核证据 _dialog_evidence，去掉陈旧保存提示空 A
        for _ in range(6):
            s = _walk_peek()
            if not s or not s.get("raw_ok"):
                time.sleep(APP_NAV_POLL)
                continue
            if cb2_class(s["cb2"]) == "battle":
                return True
            if not _dialog_evidence(s):
                break
            app_press(AK_A, 0.9, 1.2)
            app_nav_state["taps"] += 1
            app_nav_log("POST-LINKUP 对话框 mm=%d cur=%d/%d → A"
                        % (s["mm"], s["cur"][0], s["cur"][1]))
            time.sleep(0.6)
        # 3) 只有当 map 真为竞技场时才认可「游戏已自动到位」；堵住 map=2.3 的跳过旁路
        walk_needed = True
        s = _walk_peek()
        # NAVORACLE-01：兼容竞技场 group==25 任一房间（实测 25.25，老精确 25.24 恒假）
        # B2: rcvpl 在竞技场采样不稳定（0/1 漂移），依赖它会偶发触发走位并把 APP 卡死在
        # (5,8)。竞技场 map=group25 本身就是"已到位"的客观证据（warp 已完成），无条件跳过。
        if (s and s.get("raw_ok")
                and s.get("map") and s["map"][0] == SEAT_MAP_GROUP):
            walk_needed = False
            app_nav_log("POST-LINKUP map=%d.%d（竞技场，已到位），跳过座位走位" % tuple(s["map"]))
        if walk_needed and not app_nav_state["seat_ok"] and not args.no_app_seat_walk:
            # B2: --no-app-seat-walk 此前只在 :2732/:2914 生效，app_post_linkup 这条路径漏了，
            # 致 GNP 带外通道 run 仍卡在座位走位 pos(5,8)。补门判断（默认关零回归）。
            app_seat_walk()
        # 4) 待机室→战斗：踩 (10,5) coord_event 自动触发（0 A）；其后只按证据驱动
        #    条件 A，替换原盲 A×80。pt∈{3,4} 时逐只确认（A×2/只，选够后 A 关闭）。
        #    【推断】键序须运行时 pt/s01/slot 采样确认；当前 peek_state 未暴露 s01，
        #    故用 slot + 本地计数代替 s01，不冒充实锤。
        sel_count = 0
        for i in range(SEAT_CONFIRM_LIMIT):
            if time.time() > deadline:
                break
            s = _walk_peek()
            if not s or not s.get("raw_ok"):
                time.sleep(APP_NAV_POLL)
                continue
            # NAVORACLE-01：竞技场 group==25 任一房间均认可（实测 25.25）
            if not (s.get("map") and s["map"][0] == SEAT_MAP_GROUP):
                app_nav_log("POST-LINKUP 错图 map=%d.%d，停止确认（不把错图当战斗证据）"
                            % tuple(s["map"]) if s.get("map") else s.get("map"))
                return False
            if cb2_class(s["cb2"]) == "battle":
                app_nav_log("POST-LINKUP 进入战斗 cb2=%08X" % s["cb2"])
                return True
            pt = s.get("pt", -1)
            if pt in (PARTY_MENU_CHOOSE_MON, PARTY_MENU_CHOOSE_HALF):
                if sel_count >= 2:
                    app_press(AK_A, 0.9, 1.2)
                    app_nav_state["taps"] += 1
                    app_nav_log("POST-LINKUP pt=%d 选够 2 只，A 关闭队伍菜单" % pt)
                else:
                    app_press(AK_A, 0.9, 1.2)
                    app_press(AK_A, 0.9, 1.2)
                    app_nav_state["taps"] += 2
                    app_nav_pulses[0] += 1
                    sel_count += 1
                    app_nav_log("POST-LINKUP pt=%d slot=%d 选第 %d 只（A×2，推断）"
                                % (pt, s.get("slot", -1), sel_count))
                time.sleep(0.5)
            elif s.get("mm", 0) != 0:
                app_press(AK_A, 0.9, 1.2)
                app_nav_state["taps"] += 1
                app_nav_pulses[0] += 1
                app_nav_log("POST-LINKUP 关框/发 ready A（mm=%d）" % s["mm"])
                time.sleep(0.5)
            else:
                time.sleep(APP_NAV_POLL)   # 等对方/链路，不空按 A
        app_nav_log("POST-LINKUP 未进战斗（末条=%s）"
                    % (_walk_peek() or {}).get("line", "")[-180:])
        return False

    def wait_boot_completed():
        """adb devices 显示 device 只代表 adbd 起来，framework 未必就绪；
        不等 sys.boot_completed=1 就发广播会被 system_server 丢掉 ⇒ 假阴性。"""
        t = time.time()
        while time.time() - t < BOOT_TIMEOUT:
            r = shell(["getprop", "sys.boot_completed"], timeout=10)
            if r and r.returncode == 0 and r.stdout.strip() == "1":
                log("sys.boot_completed=1 (%.0fs)" % (time.time() - t))
                return True
            time.sleep(2)
        log("FATAL: %ds 内 sys.boot_completed != 1（framework 未起完）" % BOOT_TIMEOUT)
        return False

    def app_pid():
        r = shell(["pidof", PKG], timeout=10)
        if r and r.returncode == 0:
            m = re.search(r"(\d+)", r.stdout)
            return m.group(1) if m else None
        return None

    def start_app():
        """pm clear 会 force-stop app；ROM/CLOUD 接收器是动态注册的，必须显式拉起。
        AVD 冷启动/adb daemon 抖动时 pidof 可能短暂读不到，补发一次 start 再等。"""
        for attempt in range(2):
            c = shell(["am", "start", "-n", PKG + "/.EmulatorActivity"])
            ok = bool(c is not None and c.returncode == 0 and "Error" not in c.stdout)
            t = time.time()
            while ok and time.time() - t < APP_START_WAIT:
                if app_pid():
                    time.sleep(2)                  # 等 onResume 注册完广播接收器
                    return True
                time.sleep(1)
            if attempt == 0:
                log("WARN: 首轮 %ds 内未见 pid，补发 am start 重试" % APP_START_WAIT)
        log("FATAL: 拉起 %s 失败（未安装 / am start 失败 / 两轮共 %ds 无 pid）"
            % (PKG, APP_START_WAIT * 2))
        return False

    def wait_rom_loaded():
        """确认 app 真的加载了本轮推送的路径（不是 lastRom 里的旧 ROM）。
        'rom broadcast load' = 接收器收到路径，'emu loop reloading' = 模拟线程开始加载；
        两者都命中才算加载成功，否则宁可 fail-fast 也不发 CLOUD（single broadcast 不可重发）。"""
        t = time.time()
        seen_broadcast = seen_reloading = False
        while time.time() - t < ROM_LOAD_TIMEOUT:
            dt = logcat_text()
            if "rom broadcast load " + REMOTE_ROM in dt:
                seen_broadcast = True
            if "emu loop reloading " + REMOTE_ROM in dt:
                seen_reloading = True
            if seen_broadcast and seen_reloading:
                log("ROM 加载确认：app 已加载 %s (%.0fs)" % (REMOTE_ROM, time.time() - t))
                return True
            time.sleep(2)
        log("FATAL: %ds 内未确认 app 加载 %s（broadcast=%s reloading=%s）；"
            "lastRom 可能仍指向旧 ROM，拒绝发 CLOUD" %
            (ROM_LOAD_TIMEOUT, REMOTE_ROM, seen_broadcast, seen_reloading))
        return False

    # ---- ISYNC23: Android 侧 ISYNC_STATE_APPLY 门广播（默认关可逆）-------------
    # ISYNC1 实测：Android stock 无 setprop 能力，门只能靠 app 前台动态接收器；
    # 在 ROM 加载就绪后、CLOUD/联机启动前下发。回读只看门里程碑日志，
    # 门开≠seed applied（ISYNC14 §0），绝不预设 applied/PASS。
    def send_isync_state_apply():
        if not isync_ctx["enabled"]:
            log("[ISYNC] state_apply 门未启用（--isync-state-apply 默认关），跳过广播")
            return
        r = shell(["am", "broadcast", "-a", ISYNC_STATE_APPLY_BROADCAST,
                   "--ez", "on", "true"])
        ok = bool(r is not None and r.returncode == 0 and "Error" not in (r.stdout or ""))
        isync_ctx["broadcast_sent"] = bool(ok)
        if not ok:
            log("[ISYNC] WARN ISYNC_STATE_APPLY 广播失败（rc=%s out=%s）；"
                "门可能未生效，不预设成功"
                % (getattr(r, "returncode", "?"),
                   (r.stdout or "").strip()[:160] if r else "无响应"))
            return
        log("[ISYNC] ISYNC_STATE_APPLY 广播已发（--ez on true），回读 logcat 门里程碑")
        t = time.time()
        while time.time() - t < 15:
            rr = shell(["logcat", "-d", "-t", "2000"], timeout=25)
            if rr and ISYNC_STATE_APPLY_READBACK_RE.search(_clean_logcat(rr.stdout)):
                isync_ctx["gate_readback"] = "YES"
                break
            time.sleep(1)
        if isync_ctx["gate_readback"] == "YES":
            log("[ISYNC] 门 readback=YES（里程碑；仅证门开，不证 seed applied）")
        else:
            log("[ISYNC] WARN 15s 内未见 [ISYNC] MGBAX_ISYNC_STATE_APPLY=1 回读；"
                "接收器可能未注册/广播被丢，不预设门生效（FAIL/0/9 不变）")

    # ---- RACEBROAD: Android 侧根治门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY 广播（默认关可逆）----
    # RACEGATE 实锤：Java 只读 System.getenv + 广播，不读 debug.* 属性；--env 只到 PC、
    # am start 不传 env ⇒ Java 门恒 false。在 ROM 加载就绪后、CLOUD/seed 到达前下发，
    # 接收器已注册、早于 seed。回读只看门里程碑，门开≠压测有效（CROSSED 唯一裁决），
    # 绝不预设成功。
    def send_isync_seed_frame_boundary():
        if not isync_ctx["sfb_enabled"]:
            log("[ISYNC-SFB] seed_frame_boundary 根治门未启用（--isync-seed-frame-boundary 默认关），跳过广播")
            return
        r = shell(["am", "broadcast", "-a", ISYNC_SEED_FRAME_BOUNDARY_BROADCAST,
                   "--ez", "on", "true"])
        ok = bool(r is not None and r.returncode == 0 and "Error" not in (r.stdout or ""))
        isync_ctx["sfb_broadcast_sent"] = bool(ok)
        if not ok:
            log("[ISYNC-SFB] WARN seed_frame_boundary 广播失败（rc=%s out=%s）；"
                "Java 门可能未生效，不预设成功"
                % (getattr(r, "returncode", "?"),
                   (r.stdout or "").strip()[:160] if r else "无响应"))
            return
        log("[ISYNC-SFB] seed_frame_boundary 广播已发（--ez on true），回读 logcat 门里程碑")
        t = time.time()
        while time.time() - t < 15:
            rr = shell(["logcat", "-d", "-t", "2000"], timeout=25)
            if rr and ISYNC_SEED_FRAME_BOUNDARY_READBACK_RE.search(_clean_logcat(rr.stdout)):
                isync_ctx["sfb_gate_readback"] = "YES"
                break
            time.sleep(1)
        if isync_ctx["sfb_gate_readback"] == "YES":
            log("[ISYNC-SFB] 根治门 readback=YES（里程碑；仅证 Java 门开，不证压测有效）")
        else:
            log("[ISYNC-SFB] WARN 15s 内未见 [ISYNC] MGBAX_ISYNC_SEED_FRAME_BOUNDARY=1 回读；"
                "接收器可能未注册/广播被丢，不预设门生效（FAIL/0/9 不变）")

    # ---- BOOTSTRAP/ISYNC-EV: Android 侧 A1 埋点门广播（默认关可逆，独立门）--------
    # 具名总门 MGBAX_ISYNC_EVIDENCE + 子开关 MGBAX_ISYNC_EVIDENCE_A1，只启只读
    # SEND/LAND sha256 埋点；不造 seed/party/信任位，门开≠C5 PASS，不预设成功。
    def send_isync_evidence():
        if not isync_ctx["ev_enabled"]:
            log("[ISYNC-EV] A1 埋点门未启用（--isync-evidence 默认关），跳过广播")
            return
        r = shell(["am", "broadcast", "-a", ISYNC_EVIDENCE_BROADCAST,
                   "--ez", "on", "true"])
        ok = bool(r is not None and r.returncode == 0 and "Error" not in (r.stdout or ""))
        isync_ctx["ev_broadcast_sent"] = bool(ok)
        if not ok:
            log("[ISYNC-EV] WARN A1 埋点门广播失败（rc=%s out=%s）；门可能未生效，不预设成功"
                % (getattr(r, "returncode", "?"),
                   (r.stdout or "").strip()[:160] if r else "无响应"))
            return
        log("[ISYNC-EV] A1 埋点门广播已发（--ez on true），回读 logcat 门里程碑")
        t = time.time()
        while time.time() - t < 15:
            rr = shell(["logcat", "-d", "-t", "2000"], timeout=25)
            if rr and ISYNC_EVIDENCE_READBACK_RE.search(_clean_logcat(rr.stdout)):
                isync_ctx["ev_gate_readback"] = "YES"
                break
            time.sleep(1)
        log("[ISYNC-EV] A1 门 readback=%s（仅证门开，不证 C5 PASS）"
            % isync_ctx["ev_gate_readback"])

    if not wait_boot_completed():
        return 3

    # ---------- 2. 清旧偏好 + 推 ROM + 起 app + 设模式 + 起 app 端云房间 ----------
    # app 的 "lastRom" SharedPreference 会覆盖 ROM 广播里的 path；不清就可能加载
    # 上一轮的旧 ROM（曾实测 reload 到 bus4.gba）。pm clear 同时 force-stop app，
    # 故必须随后 am start 重新拉起（ROM/CLOUD 接收器是动态注册的），
    # 再校验 app 实际加载路径 = 本轮推送路径，之后才发 CLOUD（single broadcast 不可重发）。
    # E1-60FPS: --attach-existing 保留已运行的 60fps APP EGL 上下文，跳过整个 APP 重建段
    # （pm clear/push am start/ROM 广播会重建 EGL 上下文→回退 SwiftShader 4fps）
    attach_existing = bool(getattr(args, "attach_existing", False))
    if attach_existing:
        log("ATTACH-EXISTING: 跳过 APP 重建，保留现有 60fps EGL 上下文")
    if not attach_existing:
        shell(["pm", "clear", PKG])
        log("pm clear %s（清 lastRom 偏好，避免 reload 旧 ROM）" % PKG)
        if args.app_nav:
            # 必须清 logcat：否则上一轮残留的 LINKUP_OK 里程碑会让 app_linkup_seen()
            # 在导航第一步就误判握手已收尾（APPNAVFINAL taps=0 的根因）。
            shell(["logcat", "-c"])
            log("APP-NAV: 清空 logcat，避免上一轮 LINKUP_OK 里程碑污染本轮 oracle")
            # APPHUNT: 全程全 tag logcat 单独落盘。主采样循环的 app_logcat.log 每次只取
            # -t600，链接启动期的 GBoyCloud/GBoyLink/mGBA-App / "Link attached as P%d" /
            # "SIOCNT patched at attach" 行会被高频 SIO poll/PEEK 冲掉，导致无法判断
            # native SIO 驱动是否挂载（APPNAVDEFINITIVE 就是这样丢掉第一现场的）。
            live_path = os.path.join(gdir, "app_link_startup.log")
            try:
                live_fh = open(live_path, "wb")
                live_proc = subprocess.Popen(
                    [ADB_BIN, "-s", serial, "logcat", "-v", "threadtime"],
                    stdout=live_fh, stderr=subprocess.DEVNULL)
                atexit.register(_stop_live_log, live_proc, live_fh)
                log("APP-NAV: 全程 logcat → %s（所有 tag，保住 link 启动期日志）" % live_path)
            except Exception as ex:                          # noqa: BLE001
                log("APP-NAV: WARN 全程 logcat 启动失败: %s" % ex)
        # pm clear 会连带撤销运行时权限；targetSdk 36 读 /sdcard/Download 依赖
        # MANAGE_EXTERNAL_STORAGE，被撤掉后 File.isFile() 假 ⇒ ROM 加载失败。补回。
        shell(["appops", "set", PKG, "MANAGE_EXTERNAL_STORAGE", "allow"])
        log("推送 app ROM %s -> %s" % (args.app_rom, REMOTE_ROM))
        # AVDWIPE-01 教训：-wipe-data 后 boot_completed=1 但 /sdcard 可能未就绪，push 偶发 rc=1。
        # 重试 3 次(每次等 3s)，不破坏既有成功路径。
        push = None
        for _pr in range(3):
            push = subprocess.run(ADB + ["push", args.app_rom, REMOTE_ROM], capture_output=True)
            if push.returncode == 0:
                break
            log("推送 app ROM 第 %d 次失败 rc=%s，等 3s 重试" % (_pr + 1, push.returncode))
            time.sleep(3)
        if push is None or push.returncode != 0:
            log("FATAL: 推送 app ROM 失败(3次) rc=%s" % (push.returncode if push else "?"))
            return 6
        if args.app_nav:
            # 干净存档把玩家 spawn 在俱乐部柜台 pos=10,4（walk_battle.py / NAVSTATE §0.1）。
            # 不推这轮存档的话，rom.sav 是上一轮打完的状态，菜单步数会漂、导航必失败。
            if os.path.exists(args.app_sav):
                r_sav = subprocess.run(ADB + ["push", args.app_sav, APP_REMOTE_SAV],
                                       capture_output=True)
                log("APP-NAV: 推送预置存档 %s -> %s rc=%s" %
                    (args.app_sav, APP_REMOTE_SAV, r_sav.returncode))
            else:
                log("APP-NAV: WARN 预置存档不存在 %s（沿用设备上的 rom.sav）" % args.app_sav)
        # 【Y1 修复2】OBS 门必须在 am start/首帧之前写入：mgba_mobile.c 的 s_obsChain
        # 惰性缓存首次 OBS-A 即固化，原晚写 ~41s ⇒ 整轮 0 行。此处 env/setprop() 尚未
        # 定义，直接解析 args.env（最后一次出现生效），用 shell 就地写 + readback。
        _obs_val = "0"
        for _kv in (args.env or []):
            if _kv.strip().startswith("MGBAX_OBS_CHAIN="):
                _obs_val = "1" if _kv.strip().split("=", 1)[1] == "1" else "0"
        shell(["setprop", "debug.mgbax.link.obs_chain", _obs_val])
        _obs_rb = shell(["getprop", "debug.mgbax.link.obs_chain"])
        log("setprop debug.mgbax.link.obs_chain=%s readback=%s（Y1 提前：pm clear 后 / am start 前）"
            % (_obs_val, _obs_rb.stdout.strip()
               if _obs_rb is not None and _obs_rb.returncode == 0 else "?"))
        if _obs_val == "1" and (not _obs_rb or _obs_rb.stdout.strip() != "1"):
            log("WARN: OBS 门早写 readback != 1，APP 首帧 s_obsChain 将固化 0（本轮 APP 打点不可判）")
        # 【档1 NETGATE 门早写】s_ngLog 首帧懒加载固化，必须 am start 前 setprop。
        # 与 PC 侧 --env MGBAX_NETGATE_LOG=1 同开关；默认 0 零回归。
        _ng_val = "0"
        for _kv in (args.env or []):
            if _kv.strip().startswith("MGBAX_NETGATE_LOG="):
                _ng_val = "1" if _kv.strip().split("=", 1)[1] == "1" else "0"
        shell(["setprop", "debug.mgbax.link.netgate_log", _ng_val])
        _ng_rb = shell(["getprop", "debug.mgbax.link.netgate_log"])
        log("setprop debug.mgbax.link.netgate_log=%s readback=%s（档1：pm clear 后 / am start 前）"
            % (_ng_val, _ng_rb.stdout.strip()
               if _ng_rb is not None and _ng_rb.returncode == 0 else "?"))
        if _ng_val == "1" and (not _ng_rb or _ng_rb.stdout.strip() != "1"):
            log("WARN: NETGATE 门早写 readback != 1，APP 首帧 s_ngLog 将固化 0（本轮 APP 不产 [NGPEEK]）")
        # 档1 party provenance：run 目录通过 env 传给 C 侧 gnpNgRunDir()（writer=ROM 真 party）
        for _kv in (args.env or []):
            if _kv.strip().startswith("MGBAX_GNP_RUN_DIR="):
                _run_dir = _kv.strip().split("=", 1)[1]
                shell(["setprop", "debug.mgbax.link.gnp_run_dir", _run_dir])
                break
        if not start_app():
            return 6
        if args.app_nav:
            # E1 教训：start_app() 只在 pid 出现后等 2s，而 EmulatorActivity onResume 需 ~14s，
            # 早发的 ROM 广播会被丢（两次 exit-6）。等真正就绪再发，保证导航前 ROM 已加载。
            log("APP-NAV: 等 EmulatorActivity onResume 就绪 %ds 后再发 ROM 广播" % APP_READY_WAIT)
            time.sleep(APP_READY_WAIT)
            # AD5：覆盖层在 onResume 后才出现，等待期结束后 dismiss，再发 ROM 广播/导航。
            dismiss_immersive()
        else:
            dismiss_immersive()
        shell(["am", "broadcast", "-a", "io.mgba.android.action.ROM", "--es",
               "path", REMOTE_ROM])
        if not wait_rom_loaded():
            if args.app_nav:
                # ROM 广播是可重试的（只有 CLOUD 广播是 single-shot）；onResume 慢导致
                # 首播被丢时补发一次再验，避免无谓整轮失败。
                log("APP-NAV: 首播未确认加载，补发 ROM 广播后重验")
                time.sleep(5)
                shell(["am", "broadcast", "-a", "io.mgba.android.action.ROM", "--es",
                       "path", REMOTE_ROM])
                if not wait_rom_loaded():
                    return 6
            else:
                return 6
    # 'emu loop reloading' 在 loadRom() 之前打印；CLOUD 接收器要求 core.isLoaded()，
    # 给 32MB ROM 的加载留一个短 grace，避免 CLOUD 广播撞上加载中被丢弃（single
    # broadcast 不可重发，丢了只能等 120s 房号超时）。
    time.sleep(5)
    # ISYNC23：APP ROM 就绪后、CLOUD/联机启动前下发门（默认关可逆；广播失败显式 WARN）
    send_isync_state_apply()
    # RACEBROAD: 根治门（独立门，默认关；广播失败显式 WARN），早于 CLOUD/seed 到达
    send_isync_seed_frame_boundary()
    # BOOTSTRAP/ISYNC-EV: A1 埋点门（独立门，默认关；广播失败显式 WARN）
    send_isync_evidence()
    shell(["am", "broadcast", "-a", "io.mgba.android.action.GBOY_LINK_MODE",
           "--es", "mode", args.mode])
    log("已设 app 联机模式 mode=%s" % args.mode)

    room = args.room
    # path B 启动同步：PC 先建房、APP 后入房。房号来自 PC 建房日志，故此处先不发
    # CLOUD；真正的入房广播在 launch_pc 定义之后（见下方 pathb_sync 分支）。
    # 显式 --room 时关闭同步（尊重用户指定的房号），默认 OFF 完全不改原有流程。
    pathb_sync = bool(args.mode == "B" and args.pathb_sync_start and not room)
    pathb_sync_ctx = {"enabled": pathb_sync, "room": None,
                      "pc_ready_at": None, "app_join_at": None, "gap": None}
    # GRAYPATH4 TCP 直连（仅 mode B，默认关可逆）：CLOUD 广播流程原样保留（真实邮箱
    # 登录语义），TCP 只换 game-data 传输；身份缺口单独用 STUN 摘要补，不造 email。
    pathb_tcp = bool(args.mode == "B" and args.pathb_tcp)
    pathb_tcp_ctx = {"broadcast_sent": False, "sent_at": None,
                     "listen_ready": None, "listen_wait": None,
                     "listen_port_seen": None, "listen_source": "none"}
    if pathb_tcp:
        log("[PATHB-TCP] 启用 TCP 直连（拓扑②）：PC MGBAX_TCP_LISTEN=%d，"
            "APP 待连 %s:%d（无需 adb forward）"
            % (PATHB_TCP_PORT, PATHB_TCP_HOST, PATHB_TCP_PORT))

    def pc_tcp_port_listening(pid=None):
        """兜底判据：本机 15678 是否处于 LISTENING（且属本轮 PC pid）。

        ROUTEA-TCP-01 教训：仅靠 lobby 日志文案，一旦候选顺序没走到 TCP env 就永远
        等不到。这里用 netstat 直接看端口（Windows 宿主与 PC 同机），并校验 PID
        防止上一轮残留 listener 造成假阳性。仅作辅助，绝不替代真实连接证据。
        """
        try:
            r = subprocess.run(["netstat", "-ano", "-p", "TCP"],
                               capture_output=True, text=True, timeout=10)
            for ln in (r.stdout or "").splitlines():
                if "LISTENING" not in ln.upper():
                    continue
                if not re.search(r":%d\b" % PATHB_TCP_PORT, ln):
                    continue
                if pid is not None:
                    mpid = re.search(r"(\d+)\s*$", ln.strip())
                    if not mpid or int(mpid.group(1)) != pid:
                        continue
                return True
        except Exception:                                  # noqa: BLE001
            pass
        return False

    def wait_pc_tcp_listen(timeout=PATHB_TCP_LISTEN_TIMEOUT):
        """等 PC 进入 TCP accept 窗：lobby 日志文案为主，端口 LISTENING 为兜底。

        返回 dict{ready, wait, port, source}；source=lobby-log/port-check/none。
        日志与端口都是**就绪**信号，不等于 TCP 已连通；真正成功仍看 pc_tcp_up_log。
        """
        lp = os.path.join(pc_tmp, "mgba_lobby_debug.log")
        t = time.time()
        tick = 0
        while time.time() - t < timeout:
            try:
                txt = (open(lp, encoding="utf-8", errors="replace").read()
                       if os.path.exists(lp) else "")
            except OSError:
                txt = ""
            m = PATHB_TCP_LISTEN_RE.search(txt)
            if m:
                return {"ready": True, "wait": time.time() - t,
                        "port": m.group(1), "source": "lobby-log"}
            # 每 ~3s 查一次端口（netstat 较重，别每 0.5s 打）
            tick += 1
            if tick % 6 == 0 and pc_tcp_port_listening(pid=getattr(pc, "pid", None)):
                return {"ready": True, "wait": time.time() - t,
                        "port": str(PATHB_TCP_PORT), "source": "port-check"}
            time.sleep(0.5)
        if pc_tcp_port_listening(pid=getattr(pc, "pid", None)):
            return {"ready": True, "wait": time.time() - t,
                    "port": str(PATHB_TCP_PORT), "source": "port-check-timeout"}
        return {"ready": False, "wait": time.time() - t, "port": None, "source": "none"}

    def send_app_tcp_broadcast(wait_for_listen=False):
        """发 APP 侧 TCP 广播（client 连 PC listen）；单次，幂等。

        注意：GBoyCloudLink.startTcp 会替换 linkSession/socketLink，与 CLOUD 会话
        共存性须烟测确认（GRAYPATH4 §4.3）。这里只如实发送并打点，不预设直连成功。
        """
        if not pathb_tcp or pathb_tcp_ctx["broadcast_sent"]:
            return
        if wait_for_listen:
            rdy = wait_pc_tcp_listen()
            pathb_tcp_ctx["listen_ready"] = rdy["ready"]
            pathb_tcp_ctx["listen_wait"] = rdy["wait"]
            pathb_tcp_ctx["listen_port_seen"] = rdy["port"]
            pathb_tcp_ctx["listen_source"] = rdy["source"]
            if rdy["ready"]:
                log("[PATHB-TCP] PC TCP listen 已就绪（等 %.1fs，端口 %s，判据 %s），"
                    "发 APP 广播" % (rdy["wait"], rdy["port"], rdy["source"]))
            else:
                log("[PATHB-TCP] WARN %ds 内既无 '正在监听 TCP 端口' 日志也无本轮 PC "
                    "pid 的 15678 LISTENING；仍 best-effort 发广播（不预设成功）"
                    % PATHB_TCP_LISTEN_TIMEOUT)
        shell(["am", "broadcast", "-a", PATHB_TCP_BROADCAST,
               "--es", "peer", "%s:%d" % (PATHB_TCP_HOST, PATHB_TCP_PORT)])
        pathb_tcp_ctx["broadcast_sent"] = True
        pathb_tcp_ctx["sent_at"] = time.time()
        log("[PATHB-TCP] APP TCP 广播已发 peer=%s:%d（client 连 PC listen；"
            "CLOUD/TCP 会话共存须烟测；不预设直连成功）"
            % (PATHB_TCP_HOST, PATHB_TCP_PORT))

    if pathb_sync:
        log("[PATHB-SYNC] 暂缓 APP CLOUD 广播：先让 PC 建房，再带房号入房（窗口对齐）")
    elif not room:
        # host：CLOUD 广播**不带 room**。先等 app 把 relay 广告发出去。
        shell(["am", "broadcast", "-a", "io.mgba.android.action.CLOUD",
               "--es", "user", app_user, "--es", "pass", app_pass])
        log("app 已以 host 身份广播 CLOUD，等待 advertised relay ... for room <R>")
        t = time.time()
        while time.time() - t < 120:
            # 始终取最新一条 relay 广告（多房并发时由 extract_room 消歧）。
            room = extract_room(room_logcat_text())
            if room:
                break
            time.sleep(2)
        if not room:
            log("FATAL: 没拿到房号（检查 app logcat / 账号密码）")
            return 4
        log("app host 房号 R=%s（注意：之后不要重启 app）" % room)
    else:
        shell(["am", "broadcast", "-a", "io.mgba.android.action.CLOUD",
               "--es", "user", app_user, "--es", "pass", app_pass,
               "--es", "room", room])
        log("app 以 join 身份入房 R=%s" % room)

    # ---------- 3. 起 PC 实例（独立 TEMP，用 rom_b + rom_b.sav，不同 uuid）----------
    # uuid = gameCode+','+md5，从本轮两份 ROM 的真实字节算，不照抄任务书里会漂的常量。
    uuid_app, md5_app = rom_uuid(args.app_rom)
    uuid_pc, md5_pc = rom_uuid(args.pc_rom)
    log("uuid app=%s (md5=%s)" % (uuid_app, md5_app))
    log("uuid PC =%s (md5=%s)" % (uuid_pc, md5_pc))
    uuids_distinct = bool(uuid_app and uuid_pc and uuid_app != uuid_pc)
    if not uuids_distinct:
        log("FATAL: 两端 uuid 相同或无法计算（app=%s PC=%s）；"
            "同 uuid 会被云端当同一玩家只回显 self:true" % (uuid_app, uuid_pc))
        return 6
    pc_tmp = os.path.join(gdir, "pc_tmp")
    pc_keys = os.path.join(gdir, "pc_keys")
    os.makedirs(pc_tmp, exist_ok=True)
    os.makedirs(pc_keys, exist_ok=True)
    rom_pc = os.path.join(gdir, "rom_b.gba")
    if not os.path.exists(rom_pc):
        shutil.copyfile(args.pc_rom, rom_pc)
    shutil.copyfile(args.sav, os.path.join(gdir, "rom_b.sav"))
    pc = D.Inst("PC", pc_tmp, pc_keys, nav_on=(args.mode != "B"))
    pc.stdout = os.path.join(gdir, "pc_stdout.log")
    env = dict(os.environ)
    # 宿主 shell 里 export 的这些变量一律不作数（证据纪律：配置必须走 --fast-* 等
    # 显式 flag）。MGBAX_NO_DIRECT=1/MGBAX_SIO_FAST=0 从宿主漏进来会悄悄拖慢握手 ⇒ 假阴性。
    for k in ("MGBAX_OFFICIAL_LINK", "MGBAX_LINK_MODE", "MGBAX_NAV_AT",
              "MGBAX_NAV_DOWNS", "MGBAX_AUTOLINK", "MGBAX_FAST_MIN_OK",
              "MGBAX_FAST_MIN_OK_SLAVE", "MGBAX_FAST_SLAVE_ALIGN",
              "MGBAX_LINK_REARM", "MGBAX_NO_DIRECT", "MGBAX_SIO_FAST",
              "MGBAX_SIO_CONNECT_POLL", "MGBAX_SIO_DELAY_N", "MGBAX_RH_OFF",
              "MGBAX_BATTLE_RELAY", "MGBAX_B7_VERBOSE", "MGBAX_RELAY_EXT_MS",
              "MGBAX_OBS_CHAIN",  # OBS 打点总门：防宿主 export 泄漏造"默认开"假象
              "MGBAX_LINK_BTLCFG", "MGBAX_LINK_HSBYPASS", "MGBAX_HS_HOLD", "MGBAX_SIO_MASTER_ECHO",
              "MGBAX_2222_STICKY",  # 路线A 0x2222 兜底门：防宿主 export 泄漏造 PC/移动端半开
              "MGBAX_BUS_HS_PRESERVE", "MGBAX_LOCALBUS_2P",  # path B LocalBus 保真/2P 钳位门
              "MGBAX_PATHB_NATIVE_SIO",  # W92 path B 原生 SIO 字路由门：防宿主 export 泄漏造半开
              "MGBAX_STATE_REARM_GUARD",  # M1 seed 崩溃修复门：防宿主 export 泄漏造半开
              "MGBAX_FORCE_EXCHANGE", "MGBAX_SEAT_ASSIST",
              # GRAYPATH4 TCP 直连门：防宿主 export 泄漏造 PC/移动端半开（仅 --pathb-tcp 下发）。
              "MGBAX_TCP_PEER", "MGBAX_TCP_LISTEN",
              # Z19 清理清单补全：这些门 C 侧会读，宿主 export 漏进来会造 PC/移动端半开。
              "MGBAX_LINK_FORCEHS", "MGBAX_CLOSE_GRACE", "MGBAX_RH_VERBOSE",
              "MGBAX_LOCALBUS_DIAG", "MGBAX_BUS_HOST_MS", "MGBAX_LINK_LOG",
              "MGBAX_IWRAM_DELTA", "MGBAX_EWRAM_DELTA",
              "MGBAX_ISYNC_EVIDENCE", "MGBAX_ISYNC_EVIDENCE_A1",  # ISYNC-EV A1 gate anti-leak
              "MGBAX_ISYNC_STATE_APPLY",  # ISYNC23 三端同门：防宿主 export 泄漏造半开
              # P0 全套：禁用门 NO_LAG_CLEAR / 启用门 SEED_CLEAN_RESEND 防宿主 export 泄漏造
              # PC/移动端半开（两门方向相反，见下方钉值表与属性下发处注释）。
              "MGBAX_NO_LAG_CLEAR", "MGBAX_SEED_CLEAN_RESEND",
              # RACEDRV: 根治门（两候选门名都列，最终以 JAVARACE/GENTRIAD 交付为准）
              # + 造宽窗压测门 MGBAX_RACE_STRESS；防宿主 export 泄漏造半开，
              # 默认关，验证用 --env KEY=1 显式打开。
              "MGBAX_ISYNC_SEED_FRAME_BOUNDARY", "MGBAX_SEED_APPLY_SERIALIZE",
              "MGBAX_RACE_STRESS"):
        env.pop(k, None)
    env.update({"MGBAX_RH_OFF": "0",  # 零注入总闸默认关；--env 可覆盖为 1
                # P0 证据纪律：禁强写 nr=FALSE/rem=1。FORCE_EXCHANGE 是迭代25遗留的
                # nr 强写 opt-in，必须钉 0；宿主泄漏会让零注入下 nr=FALSE 成假证据。
                "MGBAX_FORCE_EXCHANGE": "0", "MGBAX_SEAT_ASSIST": "0",
                "MGBAX_BATTLE_RELAY": "0",  # B7 块中继默认 OFF
                "MGBAX_B7_VERBOSE": "0",
                "MGBAX_OBS_CHAIN": "0",  # OBS 打点总门默认关；--env MGBAX_OBS_CHAIN=1 可显式开
                "MGBAX_RELAY_EXT_MS": "5000",
                "MGBAX_LINK_BTLCFG": "0",  # 方案Y var8004 写入门默认 OFF
                "MGBAX_LINK_HSBYPASS": "1",  # P0/M1 握手态保真 8FFF 旁路门默认开（=0 秒回退）
                "MGBAX_HS_HOLD": "1",  # 路线A 从机握手保持门默认开（=0 秒回退）；钉死防宿主 export 泄漏
                "MGBAX_2222_STICKY": "1",  # 路线A 0x2222 兜底门默认开（=0 秒回退），与移动端逐字对称
                "MGBAX_BUS_HS_PRESERVE": "1",  # path B LocalBus 握手字保真默认开（=0 秒回退）
                "MGBAX_LOCALBUS_2P": "0",  # path B 2P 钳位门默认关（=1 开启可逆 A/B）
                "MGBAX_PATHB_NATIVE_SIO": "0",  # W92 path B 原生 SIO 字路由门默认关（=1 开启可逆 A/B）
                "MGBAX_STATE_REARM_GUARD": "0",  # M1 seed 崩溃修复门默认关（关=复现崩溃便于A/B，开=修复）
                # Z19 清理清单：布尔门钉死默认值，防宿主 export 泄漏造半开。
                "MGBAX_LINK_FORCEHS": "1",  # 与移动端 mgbax.link.forcehs=1 对齐（默认开）
                "MGBAX_CLOSE_GRACE": "0",  # 战斗结束补 READY_CLOSE 默认 OFF
                "MGBAX_RH_VERBOSE": "0",  # A12 事故门：严格 opt-in，钉死 OFF 防 RTT 污染/导航超时
                # 诊断/地址类只 pop 不钉值：LOCALBUS_DIAG 是 presence 检查（钉"0"反而开启），
                # BUS_HOST_MS/LINK_LOG/IWRAM_DELTA/EWRAM_DELTA 交给 C 默认与运行时 delta 解析。
                "TEMP": pc_tmp, "TMP": pc_tmp,
                "MGBAX_SCRIPT_DIR": pc_keys,
                "MGBAX_LINK_MODE": args.mode,
                "MGBAX_SIO_LOG": "1", "MGBAX_LINK_DIAG": "1",
                "MGBAX_DIRECT_LOCAL_FIRST": "1",
                "MGBAX_LINK_REARM": "1",  # Qt/mobile 产品默认已统一为开，幂等钉死
                "MGBAX_ROM_PATH": rom_pc})
    # P0 全套：两门默认均钉 0（上面 pop 已清掉宿主 export，这里补默认；--env 可再显式覆盖）。
    # MGBAX_NO_LAG_CLEAR=禁用门：C 侧 atoi(v)==1 关拦截；0/默认=吞 LAG 修复态 ⇒ 正确修复值=0。
    # MGBAX_SEED_CLEAN_RESEND=启用门（宏默认 0）：=1 才开干净重发 ⇒ 正确修复值=1，验证用 --env 开。
    env.setdefault("MGBAX_NO_LAG_CLEAR", "0")
    env.setdefault("MGBAX_SEED_CLEAN_RESEND", "0")
    # RACEDRV: 根治门（两候选门名都钉 0，最终以 JAVARACE/GENTRIAD 交付门名为准）
    # + 造宽窗压测门 MGBAX_RACE_STRESS，默认全关；验证用 --env KEY=1 显式打开。
    env.setdefault("MGBAX_ISYNC_SEED_FRAME_BOUNDARY", "0")
    env.setdefault("MGBAX_SEED_APPLY_SERIALIZE", "0")
    env.setdefault("MGBAX_RACE_STRESS", "0")
    # ---- W92: path B 原生 SIO 字路由门（--pathb-native-sio，默认关可逆）----
    # PC 走 env（上面 pop 已清宿主 export 并钉 0；--env 仍可显式覆盖）；
    # Android 在下方 debug.* setprop 处同名下发。门开只改握手字投递路由/禁写真
    # 握手字/sidecar 早退，不造 party/信任位/CROSSED；门开≠成功，CROSSED 唯一裁决。
    if args.pathb_native_sio:
        env["MGBAX_PATHB_NATIVE_SIO"] = "1"
        log("[PATHBNATIVE] PC env 下发 MGBAX_PATHB_NATIVE_SIO=1"
            "（原生 SIO 字路由；门开≠CROSSED，不预设成功）")
    else:
        log("[PATHBNATIVE] 原生 SIO 字路由门未启用，MGBAX_PATHB_NATIVE_SIO 保持默认 0")
    # ---- PB18: path B PC 可见核导航输入（--pathb-pc-nav，仅 mode B，默认关可逆）----
    # PB15 缺口：mode B 下 MGBAX_NAV_AT 被上面清理、nav_at 只在 mode!=B 写、无 pc.tap/key
    # ⇒ navMenuAt=-1 ⇒ 无 nav_at ⇒ 可见核停在菜单 cb=0。这里把参数还原给 env（--env 可
    # 再显式覆盖），CloudLink 在三镜像核就绪后写 nav_at（与 duo path B 的 env_for 对称）。
    if args.mode == "B" and args.pathb_pc_nav:
        env.setdefault("MGBAX_NAV_AT", str(PATHB_PC_NAV_AT))
        env.setdefault("MGBAX_NAV_DOWNS", str(PATHB_PC_NAV_DOWNS))
        log("[PATHB-PCNAV] mode B PC 可见核导航输入已启用：MGBAX_NAV_AT=%s "
            "MGBAX_NAV_DOWNS=%s，由 CloudLink 在三镜像核就绪后写 nav_at"
            "（驱动输入修复、非造假，不造 party/信任位/CROSSED）"
            % (env["MGBAX_NAV_AT"], env["MGBAX_NAV_DOWNS"]))
    # ---- ISYNC23: MGBAX_ISYNC_STATE_APPLY（--isync-state-apply，默认关可逆）----
    # PC 走 env（--env 是唯一能注入被清理变量的通道；setdefault 后 --env 可再显式覆盖）。
    if args.isync_state_apply:
        env.setdefault("MGBAX_ISYNC_STATE_APPLY", "1")
        log("[ISYNC] PC env 下发 MGBAX_ISYNC_STATE_APPLY=%s（门开≠seed applied，不预设成功）"
            % env["MGBAX_ISYNC_STATE_APPLY"])
    else:
        log("[ISYNC] state_apply 门未启用，PC env 未下发 MGBAX_ISYNC_STATE_APPLY（默认关可逆）")
    # ---- ISYNC-EV: MGBAX_ISYNC_EVIDENCE + A1 子开关（--isync-evidence，默认关可逆）----
    # PC 走 env；门只启 A1 seed sha256 只读埋点，不造 seed/party/信任位，不预设成功。
    if args.isync_evidence:
        env.setdefault("MGBAX_ISYNC_EVIDENCE", "1")
        env.setdefault("MGBAX_ISYNC_EVIDENCE_A1", "1")
        log("[ISYNC-EV] PC env 下发 MGBAX_ISYNC_EVIDENCE=1 A1=1（门开!=C5 PASS，不预设成功）")
    else:
        log("[ISYNC-EV] A1 埋点门未启用，PC env 未下发 MGBAX_ISYNC_EVIDENCE（默认关可逆）")
    # ---- RACEBROAD: MGBAX_ISYNC_SEED_FRAME_BOUNDARY（--isync-seed-frame-boundary，默认关可逆）----
    # PC 走 env；该门在上面 anti-leak/pin 清单已钉 0，故直接赋值覆盖为 1（--env 仍可再显式覆盖）。
    # 根治门只启 seed 帧边界同步时序，门开≠压测有效；CROSSED 唯一裁决，不预设成功。
    if args.isync_seed_frame_boundary:
        env["MGBAX_ISYNC_SEED_FRAME_BOUNDARY"] = "1"
        log("[ISYNC-SFB] PC env 下发 MGBAX_ISYNC_SEED_FRAME_BOUNDARY=%s"
            "（门开≠压测有效，CROSSED 唯一裁决，不预设成功）"
            % env["MGBAX_ISYNC_SEED_FRAME_BOUNDARY"])
    else:
        log("[ISYNC-SFB] seed_frame_boundary 根治门未启用，PC env 未下发"
            " MGBAX_ISYNC_SEED_FRAME_BOUNDARY（默认关可逆）")
    fast_min = 8 if (args.fast_early or args.fast_align) else None
    fast_min_slave = args.fast_min_ok_slave
    fast_align = args.fast_slave_align
    if args.fast_align:
        fast_min_slave = fast_min_slave if fast_min_slave is not None else 8
        fast_align = fast_align if fast_align is not None else 4
    if fast_min is not None:
        env["MGBAX_FAST_MIN_OK"] = str(fast_min)
    if fast_min_slave is not None:
        env["MGBAX_FAST_MIN_OK_SLAVE"] = str(fast_min_slave)
    if fast_align is not None:
        env["MGBAX_FAST_SLAVE_ALIGN"] = str(fast_align)
    # 显式 --env 在 pop/默认/fast-* 之后应用，是唯一能注入被清理变量（如
    # MGBAX_SIO_CONNECT_POLL / MGBAX_SIO_FAST）的通道。
    for kv in args.env or []:
        if "=" not in kv:
            log("WARN: 忽略无效 --env %s（格式 K=V）" % kv)
            continue
        k, v = kv.split("=", 1)
        env[k.strip()] = v.strip()
        log("PC env 显式覆盖: %s=%s" % (k.strip(), v.strip()))
    # OBS 门审计（只读）：通用 --env 循环已把 MGBAX_OBS_CHAIN 透传到 PC env；
    # 这里只补一行日志确认门态，不改值、不写游戏态、不改判据。
    log("[OBSCHAIN] PC env MGBAX_OBS_CHAIN=%s（只读打点门；门开≠CROSSED，不预设成功）"
        % env.get("MGBAX_OBS_CHAIN", "0"))

    # ---------- 2b. Android 端 mgbax.* 系统属性（外部 setter）----------
    # app 对这些属性只读（__system_property_get），stock Android 没有应用内
    # setter；唯一投递通道就是 `adb shell setprop`（ENV-REGISTRY.md §3 / issue #2）。
    # 与 PC env 同源下发，保证跨设备两端快帧/握手门同一口径。属性在 app 首次
    # 走到 SIO/握手路径时才被静态缓存，此处（开战前）写入即可生效。
    def setprop(name, value):
        r = shell(["setprop", name, str(value)])
        got = ""
        if r is not None and r.returncode == 0:
            g = shell(["getprop", name])
            if g is not None and g.returncode == 0:
                got = g.stdout.strip()
        line = "setprop %s=%s" % (name, value)
        if got:
            line += " readback=%s" % got
        if got != str(value):
            line += "  <-- WARN: 未生效（属性只读/需 root），app 将用默认值"
        log(line)
        return got

    android_props = {
        # 【Y1 修复5】forcehs/rearm 改 env 驱动：默认 "1" 保持兼容，--env 可设 0 做真零注入。
        "mgbax.link.rearm": "1" if env.get("MGBAX_LINK_REARM", "1") != "0" else "0",
        "mgbax.link.forcehs": "1" if env.get("MGBAX_LINK_FORCEHS", "1") != "0" else "0",
    }
    if fast_min is not None:
        android_props["mgbax.sio.fast.min_ok"] = str(fast_min)
    if fast_min_slave is not None:
        android_props["mgbax.sio.fast.min_ok_slave"] = str(fast_min_slave)
    if fast_align is not None:
        android_props["mgbax.sio.fast.slave_align"] = str(fast_align)
    log("Android props: 下发 %d 项 mgbax.*（外部 setter=adb shell setprop）"
        % len(android_props))
    for _name, _val in sorted(android_props.items()):
        setprop(_name, _val)
    # A11 教训：stock A14 AVD 的 SELinux 拒绝设置 mgbax.* / persist.* 属性
    # （setprop mgbax.link.seat_assist 1 → "Failed to set property"），但 debug.*
    # 前缀允许：setprop debug.apphunt.test 1 → getprop 回读 1。ROOTHUNT 的
    # mobileSeatAssist 若把属性改名为 debug.mgbax.*（或默认开），下面两项即刻生效；
    # 当前 C 代码不读它们，设置也无害。
    # A12 教训：rh_verbose=1 让 PC 打出 ~2800 条 [RHSEAT]、链路 RTT 飙到 1.7s、
    # app 导航超时。verbose 必须严格 opt-in；seat_assist 才是本轮真正要打开的。
    # 显式写 0/1：setprop 的属性跨 run 残留（A13 被 A12 的 rh_verbose=1 污染，
    # RTT 飙到 1.1s、链路 collapse）。每次 run 必须先清成默认再按需打开。
    setprop("debug.mgbax.link.seat_assist",
            "1" if env.get("MGBAX_SEAT_ASSIST") == "1" else "0")
    setprop("debug.mgbax.link.rh_verbose",
            "1" if env.get("MGBAX_RH_VERBOSE") == "1" else "0")
    # 零注入总闸（MGBAX_RH_OFF）：PC 读 getenv，移动端读本 debug.* 属性；
    # 必须显式下发，否则 Run A 只关 PC 端、实验不纯净。
    setprop("debug.mgbax.link.rh_off",
            "1" if env.get("MGBAX_RH_OFF") == "1" else "0")
    # B7 块中继（移动端门读这些 debug.* 属性）：必须显式下发 + readback，
    # 否则移动端门读不到 = G2 半开态作废（同 rh_off 类缺口）。
    setprop("debug.mgbax.link.battle_relay",
            "1" if env.get("MGBAX_BATTLE_RELAY") == "1" else "0")
    setprop("debug.mgbax.link.b7_verbose",
            "1" if env.get("MGBAX_B7_VERBOSE") == "1" else "0")
    setprop("debug.mgbax.link.relay_ext_ms",
            env.get("MGBAX_RELAY_EXT_MS", "5000"))
    # 方案Y：var8004 写入门（属性名逐字对齐 C 侧 debug.mgbax.link.link_btcfg）
    setprop("debug.mgbax.link.link_btcfg",
            "1" if env.get("MGBAX_LINK_BTLCFG") == "1" else "0")
    # P0/M1：握手态保真 8FFF 旁路门（移动端 debug.* 属性，默认开）。
    setprop("debug.mgbax.link.hs_bypass",
            "1" if env.get("MGBAX_LINK_HSBYPASS", "1") != "0" else "0")
    # 路线A：从机握手保持门（推真 B9A0 + 窗口重装，移动端 debug.* 属性，默认开）。
    setprop("debug.mgbax.link.hs_hold",
            "1" if env.get("MGBAX_HS_HOLD", "1") != "0" else "0")
    # BF1：主机握手字真自回环门（默认关，显式 =1 才开；只搬运真字非造字）。
    setprop("debug.mgbax.link.sio_master_echo",
            "1" if env.get("MGBAX_SIO_MASTER_ECHO", "0") == "1" else "0")
    # 握手期跳过 netLinkBarrier(400) 自伤帧率门（默认关，显式 =1 才开；
    # 属性名与 mgba_mobile.c::mob-HandshakeNoBarrier 逐字对齐，三端对称）。
    setprop("debug.mgbax.link.handshake_no_barrier",
            "1" if env.get("MGBAX_HANDSHAKE_NO_BARRIER", "0") == "1" else "0")
    # G1 切片乙：宽松 label 取字门（PC 走 MGBAX_LABEL_ANY env，mobile 走同名 prop，
    # 三端对称）。治 want/got 差一致块字进不了 APP 接收缓冲。默认关。
    setprop("debug.mgbax.link.label_any",
            "1" if env.get("MGBAX_LABEL_ANY", "0") == "1" else "0")
    # 路线A：0x2222 启动字 sticky 兜底门（移动端 debug.* 属性，默认开；
    # 属性名与 C 侧 rhGetProp("debug.mgbax.link.block2222_sticky") 逐字对齐）。
    setprop("debug.mgbax.link.block2222_sticky",
            "1" if env.get("MGBAX_2222_STICKY", "1") != "0" else "0")
    # S1/B2: GNP 带外 party 邮槽门（宿端写口 mgba_mobile.c mobileGnpNetPartyOn，
    # 属性名逐字对齐 MGBAX_NET_PARTY_MAILBOX_PROP）。默认关；开=TYPE_PARTY 帧可写
    # IWRAM 邮槽→ROM PollRx/Apply 直装 gEnemyParty（writer=ROM，不造字）。
    setprop("debug.mgbax.link.net_party_mailbox",
            "1" if env.get("MGBAX_NET_PARTY_MAILBOX", "0") == "1" else "0")
    # path B：LocalBus 握手字保真（默认开）+ 2P 钳位门（默认关）；属性名与 C 侧逐字对齐。
    setprop("debug.mgbax.link.bus_hs_preserve",
            "1" if env.get("MGBAX_BUS_HS_PRESERVE", "1") != "0" else "0")
    setprop("debug.mgbax.link.localbus_2p",
            "1" if env.get("MGBAX_LOCALBUS_2P", "0") == "1" else "0")
    # W92 path B 原生 SIO 字路由门（默认关）：属性名与 C 侧
    # MGBAX_PATHB_NATIVE_SIO_PROP 逐字对齐；门开只改字路由、不造数据/信任位。
    setprop("debug.mgbax.link.pathb_native_sio",
            "1" if env.get("MGBAX_PATHB_NATIVE_SIO", "0") == "1" else "0")
    # M1 seed 崩溃修复门：默认关（关=复现崩溃便于 A/B，开=修复）；属性名与 C 侧逐字对齐。
    setprop("debug.mgbax.link.state_rearm_guard",
            "1" if env.get("MGBAX_STATE_REARM_GUARD", "0") == "1" else "0")
    # P0 全套：两门方向相反，逐字按 env 值映射（仅 "1"→"1"，其它→"0"），沿用自带 getprop 回读。
    # no_lag_clear 禁用门：1=关拦截，0/默认=吞 LAG 修复态 ⇒ 默认下发 0（修复值）。
    setprop("debug.mgbax.link.no_lag_clear",
            "1" if env.get("MGBAX_NO_LAG_CLEAR", "0") == "1" else "0")
    # seed_clean_resend 启用门（宏默认 0）：=1 才开干净重发。当前仅 PC/Qt 读、Android C 侧未读取，
    # 下发该 prop 暂无运行时效果；仍对称下发以保持一致 + 未来扩展（报告如实标注）。
    setprop("debug.mgbax.link.seed_clean_resend",
            "1" if env.get("MGBAX_SEED_CLEAN_RESEND", "0") == "1" else "0")
    # 灰区全开（用户明示解禁）：移动端 debug.* 属性，与 C 侧
    # rhGetProp("debug.mgbax.link.gray_all"/"gray_lobby_open") 逐字对齐；默认关。
    setprop("debug.mgbax.link.gray_all",
            "1" if env.get("MGBAX_GRAY_ALL") == "1" else "0")
    setprop("debug.mgbax.link.gray_lobby_open",
            "1" if env.get("MGBAX_GRAY_LOBBY_OPEN") == "1" else "0")
    # OBS 打点总门：移动端 C 读 debug.mgbax.link.obs_chain；debug.* 是 stock A14 AVD
    # 唯一可 setprop 前缀（A11 教训）；默认 0。setprop() 自带 getprop readback + WARN。
    # 门只开"只读日志打点"：不写 gLinkOpen/rem/nr/brs/st，不改判据、不造 CROSSED。
    setprop("debug.mgbax.link.obs_chain",
            "1" if env.get("MGBAX_OBS_CHAIN") == "1" else "0")
    # P0 证据断言：FORCE_EXCHANGE 已钉 0（禁强写 nr=FALSE/rem=1）；移动端
    # mgbax.force_exchange 为非 debug 前缀，stock A14 AVD SELinux 拒绝 setprop ⇒ 恒 0。
    log("P0 证据断言: FORCE_EXCHANGE=0（禁强写nr=FALSE）；RH_OFF=%s HSBYPASS=%s（两门独立，无互斥）"
        % (env.get("MGBAX_RH_OFF"), env.get("MGBAX_LINK_HSBYPASS", "1")))
    if env.get("MGBAX_CLOSE_GRACE") == "1":
        setprop("debug.mgbax.link.close_grace", "1")
    else:
        setprop("debug.mgbax.link.close_grace", "0")
    # RACEDRV: 根治门 + 造宽窗压测门下发（debug.* 前缀可被 stock A14 AVD setprop）；
    # 根治门沿用 "1"→"1"/其余→"0" 映射；造宽窗门 RACE_STRESS 透传 ms 值（见下）。
    # 门默认关，验证用 --env MGBAX_RACE_STRESS=<ms> 显式打开。注：当前 Android Java
    # reader 走 System.getenv / 前台广播，若最终 reader 改读这些 debug.* prop 即刻生效；
    # MGBAX_RACE_STRESS 为压测造宽窗门（非造数据/信任位/CROSSED，仅放大时序窗口复现
    # 竞态，产物按压测口径标注）。
    setprop("debug.mgbax.link.isync_seed_frame_boundary",
            "1" if env.get("MGBAX_ISYNC_SEED_FRAME_BOUNDARY", "0") == "1" else "0")
    setprop("debug.mgbax.link.seed_apply_serialize",
            "1" if env.get("MGBAX_SEED_APPLY_SERIALIZE", "0") == "1" else "0")
    # RACESTRESS ms 映射：driver 把 env 值转成 ms 字符串下发，C 侧 reader 按 ms 解释
    # 并 clamp 0-500。历史 "--env MGBAX_RACE_STRESS=1" 是布尔写法（旧 driver 写 "1"，
    # reader 按 ms 解释仅 1ms，远小于 CRASH5~0.4s 窗口 ⇒ 造不出宽窗），映射到合理
    # 默认宽窗 300ms（在 clamp 内）；纯十进制数字按 ms 直接透传（clamp 由 C reader 做，
    # driver 不重复钳位口径）；其余（含 "0"/非数字/带符号）→ "0" 门关。仅改本门。
    _rs_raw = env.get("MGBAX_RACE_STRESS", "0").strip()
    if _rs_raw == "1":
        race_stress_ms = "300"              # 历史布尔写法 → 默认宽窗 300ms
    elif _rs_raw.isdecimal():
        race_stress_ms = str(int(_rs_raw))   # 纯数字 → ms 透传（clamp 由 C reader 做）
    else:
        race_stress_ms = "0"                # 0/非数字/带符号 → 门关
    _rs_readback = setprop("debug.mgbax.link.race_stress", race_stress_ms)

    if args.mode == "B":
        # Agent 7：总线收敛诊断（2P fallback go/no-go 用）。
        env["MGBAX_LOCALBUS_DIAG"] = "1"
        if pathb_tcp:
            # GRAYPATH4 拓扑②：PC 作 TCP server（listenAndAccept 20s）。
            # 关键（ROUTEA-TCP-01 实证）：官方模式候选顺序是 BT → UDP DirectLink →
            # TCP env → 隧道（CloudLink.cpp:1593-1619）。上一版只设 LISTEN 不关 UDP，
            # UDP 打洞先成功（via=p2p 739ms）→ tryEnvTcpLink 根本不被调用 → 无
            # 「正在监听 TCP 端口」日志、PC 从不 listen，TCP 路径空转（90s 超时）。
            # 故这里必须 MGBAX_NO_DIRECT=1 让 tryDirectLink 提前返回 nullptr
            # （CloudLink.cpp:1215-1217），强制走 TCP env。身份证据已由 vpn_split
            # 的 public_ip_* STRONG 摘要承担，不再依赖 PC 的 [direct] 候选行。
            env["MGBAX_TCP_LISTEN"] = str(PATHB_TCP_PORT)
            env["MGBAX_NO_DIRECT"] = "1"
            log("[PATHB-TCP] PC 设 MGBAX_TCP_LISTEN=%d + MGBAX_NO_DIRECT=1"
                "（关 UDP 打洞以强制 TCP env 候选，listenAndAccept 20s）"
                % PATHB_TCP_PORT)
    log("PC env: FAST_MIN_OK=%s FAST_MIN_OK_SLAVE=%s FAST_SLAVE_ALIGN=%s LinkRearm=1"
        % (env.get("MGBAX_FAST_MIN_OK", "<unset>"),
           env.get("MGBAX_FAST_MIN_OK_SLAVE", "<unset>"),
           env.get("MGBAX_FAST_SLAVE_ALIGN", "<unset>")))
    if args.mode != "B":
        with open(os.path.join(pc_keys, "nav_at"), "w") as f:
            f.write("1500 2")
    acc_user = args.pc_acc.split(":", 2)[0]
    acc_pass = args.pc_acc.split(":", 2)[1]
    pc_launch_count = [0]

    def launch_pc(link_room):
        """起（或重起）PC，MGBAX_AUTOLINK 固定到 link_room。

        attempt-4 根因：外部 watchdog 补发 CLOUD 让 app 重开房，PC 却仍 pin 在旧房。
        重开房时只能**重指 PC**，绝不能再由本驱动发 CLOUD——那会再次解散房间并造出
        第三个房号，问题更糟。整个 run 只在上面发一次 CLOUD 广播（single host broadcast）。
        """
        if pc.proc is not None and pc.proc.poll() is None:
            log("  停掉旧 PC pid=%s（重指房号 %s）" % (pc.pid, link_room))
            subprocess.run(["taskkill", "/F", "/PID", str(pc.pid)], capture_output=True)
            try:
                pc.proc.wait(timeout=5)
            except Exception:                      # noqa: BLE001
                pass
        # link_room=None → 无房号 AUTOLINK = 建房（Window.cpp: config.roomId 空即建房）；
        # 仅 --pathb-sync-start 的 PC-host 路径用；原有路径永远传房号，行为不变。
        env["MGBAX_AUTOLINK"] = ("%s:%s:%s" % (acc_user, acc_pass, link_room)
                                 if link_room else "%s:%s" % (acc_user, acc_pass))
        mode = "a" if pc_launch_count[0] else "w"
        pc_launch_count[0] += 1
        pc.proc = subprocess.Popen([EXE, rom_pc], cwd=ROOT, env=env,
                                   stdout=open(pc.stdout, mode),
                                   stderr=subprocess.STDOUT)
        pc.pid = pc.proc.pid
        # T1: 记录本代 PC 的 lobby 日志偏移 + 清"已入房"标记，使 pc_join_guard 只判本代。
        try:
            _lb = os.path.join(pc_tmp, "mgba_lobby_debug.log")
            pc_guard_ctx["log_off"] = os.path.getsize(_lb) if os.path.exists(_lb) else 0
        except OSError:
            pc_guard_ctx["log_off"] = 0
        pc_guard_ctx["joined"] = False
        log("PC pid=%d  MGBAX_AUTOLINK=%s:…%s（不同账号 + 不同 uuid）"
            % (pc.pid, acc_user, (":" + link_room) if link_room else "(建房)"))
        # B2 诊断：确认 party 触发目录真传给 PC（marker 消费前置）
        log("[GNP-DIAG] PC env MGBAX_SCRIPT_DIR=%s party门=%s" %
            (env.get("MGBAX_SCRIPT_DIR", "<unset>"),
             env.get("MGBAX_NET_PARTY_MAILBOX", "<unset>")))
        return link_room

    if pathb_sync:
        # 1) PC 先起并建房。room_pc 先置 None，拿到 APP 实际入的房号后再回填。
        room_pc = launch_pc(None)
        log("[PATHB-SYNC] PC 先启动建房 pid=%d；轮询 PC lobby 日志取房号（上限 %ds）"
            % (pc.pid, PATHB_SYNC_ROOM_TIMEOUT))
        lobby_path = os.path.join(pc_tmp, "mgba_lobby_debug.log")
        t = time.time()
        while time.time() - t < PATHB_SYNC_ROOM_TIMEOUT:
            txt = ""
            try:
                if os.path.exists(lobby_path):
                    with open(lobby_path, encoding="utf-8", errors="replace") as f:
                        txt = f.read()
            except OSError:
                pass
            room = extract_pc_host_room(txt)
            if room:
                break
            time.sleep(PATHB_SYNC_ROOM_POLL)
        if not room:
            log("FATAL: [PATHB-SYNC] %ds 内未从 PC lobby 日志读到房号；不伪造房号，退出"
                % PATHB_SYNC_ROOM_TIMEOUT)
            return 4
        pathb_sync_ctx.update(room=room, pc_ready_at=time.time())
        log("[PATHB-SYNC] PC 建房 R=%s（%.1fs）；APP 现在带房号入房（两端 peerSeen 同刻）"
            % (room, time.time() - t))
        # 2) APP 带房号入房（join）。PC 已在房内等待 → 双方 peerSeen 几乎同时触发，
        #    4s 候选公告窗口重叠，s/s2 才来得及互达（原串行流程单边超时分裂）。
        shell(["am", "broadcast", "-a", "io.mgba.android.action.CLOUD",
               "--es", "user", app_user, "--es", "pass", app_pass,
               "--es", "room", room])
        pathb_sync_ctx["app_join_at"] = time.time()
        pathb_sync_ctx["gap"] = (pathb_sync_ctx["app_join_at"]
                                 - pathb_sync_ctx["pc_ready_at"])
        log("[PATHB-SYNC] APP 以 join 身份入房 R=%s（gap=%.2fs；single CLOUD broadcast）"
            % (room, pathb_sync_ctx["gap"]))
        # peerSeen 后 PC 才会尝试 UDP→TCP listen；轮询到 listen 日志再发 APP 广播，
        # 确保落在 20s accept 窗内（同步路径是本拓扑推荐的组合）。
        send_app_tcp_broadcast(wait_for_listen=True)
        room_pc = room
    else:
        room_pc = launch_pc(room)
        if pathb_tcp:
            # 非同步路径 PC 入房晚 ~20s；同样轮询 listen 日志（不猜延时）。
            # 注意 app 此时已 host 建房，CLOUD+TCP 会话共存须烟测，默认建议合用
            # --pathb-sync-start。
            log("[PATHB-TCP] 未开 --pathb-sync-start：PC 入房晚 ~20s，轮询 TCP listen 日志")
            send_app_tcp_broadcast(wait_for_listen=True)

    def pc_join_guard():
        """app 导航可能耗时数分钟；期间 PC 若因房号失效（房间不存在）而退出/app 重开房，
        必须及时用**最新**房号重起 PC，否则 app 会在等待连接处空等到天荒地老。
        这里只重起 PC，绝不重发 CLOUD（single broadcast 纪律）。"""
        if time.time() - pc_guard_ctx["last"] < 12:
            return
        pc_guard_ctx["last"] = time.time()
        if pathb_sync:
            # APP 是 joiner，不再广播 relay；拿 APP logcat 房号重指 PC 会指到 APP ROM
            # 自动建房留下的 stale 房（见 ROUTEA-PATHB-01 的 686048→181579）。
            # 房号权威此时在 PC lobby 日志；运行期重起 PC 还要连带重发 CLOUD，
            # 超出本最小启动同步补丁范围 —— 不误动，只标记。
            return
        try:
            lobby = os.path.join(pc_tmp, "mgba_lobby_debug.log")
            full = open(lobby, encoding="utf-8", errors="replace").read() \
                   if os.path.exists(lobby) else ""
        except OSError:
            full = ""
        # T1 修复：只读本代 PC 新增日志（launch_pc 记录的偏移），且"已加入房间"清 bad。
        # 原实现读全量累积日志，首个 PC 的陈旧失败文本永久残留 bad=True，
        # 每 12s 误杀一个其实已成功入房的 PC（user_leave 反复打断 P2P 协商）。
        txt = full[pc_guard_ctx["log_off"]:]
        if (u"已加入房间" in txt or "player_joined" in txt
                or "join_room\" success:true" in txt):
            pc_guard_ctx["joined"] = True
        bad = (not pc_guard_ctx["joined"]) and (
            u"房间不存" in txt or u"联机流程中断" in txt
            or "join_room\" success:false" in txt)
        if not (bad or not pc.alive()):
            return
        latest = extract_room(room_logcat_text())
        if not latest:
            return
        pc_guard_ctx["resyncs"] += 1
        app_nav_log("PC 未入房/退出（bad=%s alive=%s），用最新房号 %s 重起 PC #%d"
                    % (bad, pc.alive(), latest, pc_guard_ctx["resyncs"]))
        launch_pc(latest)

    # battle 窗口要先解析：app 导航用它判断「cb2 是否已进战斗」，不能写死 cb2 字面量。
    B_LO, B_HI, B_SRC = D.resolve_battle_window()

    # 严格战斗主循环窗口：CB2_InitBattle 后的初始化帧（如 app 的 080B376D）不算
    # 「真进战斗」，必须是 BattleMainCB2+1 起、下一个符号之前的精确区。
    def resolve_strict_window():
        try:
            lines = open(os.path.join(ROOT, "rom.map"), encoding="utf-8",
                         errors="replace").read().splitlines()
        except OSError:
            return None, None, "rom.map-unavailable"
        syms = []
        for ln in lines:
            m = re.match(r"\s*0x([0-9A-Fa-f]{8})\s+(\S+)", ln)
            if m:
                syms.append((int(m.group(1), 16), m.group(2)))
        for i, (addr, name) in enumerate(syms):
            if name == "BattleMainCB2":
                hi = syms[i + 1][0] if i + 1 < len(syms) else addr + 0x1000
                return addr + 1, hi, "rom.map:BattleMainCB2"
        return None, None, "BattleMainCB2-not-found"

    _map_lo, _map_hi, _map_src = resolve_strict_window()
    # ROOTHUNT 用 rom.elf 定标：只有 BattleMainCB2 本体才是真进战斗。
    # 080B310D=InitBattle / 080B376D=HandleStartBattle / 0816D8CD=错误屏，都不算。
    S_LO, S_HI = gba.BATTLE_CB2_LO, gba.BATTLE_CB2_HI  # 统一宏（原值 0x080B4845 / 0x080B48A8）
    log("严格战斗窗口=[0x%X,0x%X) source=rom.elf:BattleMainCB2（rom.map 旁证 %s/%s）"
        % (S_LO, S_HI, _map_src,
           ("%08X-%08X" % (_map_lo, _map_hi)) if _map_lo else "n/a"))

    # cable_club 段（cb2 落此即游戏真进有线俱乐部）：基准宏 + rom.map 运行时 delta 平移。
    # 根 rom.map 为 0x08105FD4..0x08107488；重链构建会整体平移（E2E 样本 +0x70），
    # 故禁裸 hex 写死，运行时从 rom.map 的 cable_club.o .text 段重解析。
    def resolve_cable_club_window():
        try:
            lines = open(os.path.join(ROOT, "rom.map"), encoding="utf-8",
                         errors="replace").read().splitlines()
        except OSError:
            return CABLE_CLUB_CB2_LO, CABLE_CLUB_CB2_HI, "baseline-macros(rom.map-unavailable)"
        for ln in lines:
            m = re.match(r"\s*\.text\s+0x([0-9A-Fa-f]{8})\s+0x([0-9A-Fa-f]+)\s+src/cable_club\.o", ln)
            if m:
                lo, size = int(m.group(1), 16), int(m.group(2), 16)
                delta = lo - CABLE_CLUB_CB2_LO
                return (lo, lo + size,
                        "rom.map:cable_club.o delta=0x%X size=0x%X (base 0x%X..0x%X)"
                        % (delta & 0xFFFFFFFF, size, CABLE_CLUB_CB2_LO, CABLE_CLUB_CB2_HI))
        return CABLE_CLUB_CB2_LO, CABLE_CLUB_CB2_HI, "baseline-macros(no .text symbol)"

    CC_LO, CC_HI, CC_SRC = resolve_cable_club_window()
    if args.force_full_menu:
        log("cable_club 段=[0x%X,0x%X) source=%s" % (CC_LO, CC_HI, CC_SRC))

    # ---------- 3b. app 侧游戏导航（--app-nav）----------
    # 两端并行入场：PC 的 nav_at 已随 launch_pc 起来，这里把 app 从 title 走到
    # 有线俱乐部→单打→等待连接。PEEK 是唯一 oracle；不重启 app（会 leave_room）。
    app_nav_pulses = [0]
    app_nav_seat_done = [False]
    battle_shot_done = [False]
    battle_shot_path = [""]
    pc_battle_shot_path = [""]
    app_battle_at_pc = ["UNOBSERVED", ""]   # [in_battle, cb2] at PC's first battle frame
    force_menu_on = bool(args.force_full_menu)
    menu_lock_ok = True   # --force-full-menu 下按导航结果收紧，挡住假 LINKUP 证据
    if force_menu_on and args.runsec < FORCE_MENU_WINDOW:
        log("WARN: --force-full-menu 需 --runsec>=%d（当前 %d），否则采样会被截断"
            % (FORCE_MENU_WINDOW, args.runsec))
    if args.app_nav:
        app_reason = app_navigate_to_wait()
        # 菜单没走完时 LINKUP_OK 是假信号：禁止下游把它记成 app_link_seen（判 UNOBSERVED）
        menu_lock_ok = (not force_menu_on) or (app_reason in ("linkup", "battle", "waiting"))
        if force_menu_on:
            app_nav_log("force-full-menu=%s menu_lock_ok=%s reached=%s"
                        % (force_menu_on, menu_lock_ok, app_reason))
        # LINKUP 收尾（A8 教训）：LINKUP_OK 后必须等新鲜 PEEK 再走座位、按 A 确认准备，
        # 否则会因读到事件前的旧值（lkpc=0/cur=0/1）跳过走位，双方停在待机室直到
        # 600 帧超时链路关闭（app st=1）。app_post_linkup 负责 对话框→座位→A→战斗。
        if app_reason in ("linkup", "battle", "waiting"):
            if args.mode == "B" and args.pathb_skip_seat:
                # path B 对手来自镜像核 savestate，不依赖 APP 走到物理座位；
                # flag 默认关可逆，开启时跳过整段 POST-LINKUP 导航直接进等待/采样。
                app_nav_log("[PATHB] POST-LINKUP 跳过座位走位（--pathb-skip-seat），"
                            "直接进入等待/采样；reached=%s" % app_reason)
            elif not args.no_app_seat_walk:
                app_post_linkup()
            else:
                app_nav_log("POST-LINKUP 跳过（--no-app-seat-walk）")
        else:
            ps = peek_state()
            app_nav_log("跳过 POST-LINKUP（reached=%s, peek_ok=%s）"
                        % (app_reason, bool(ps and ps.get("raw_ok"))))

    # ---------- 4. 采样（PC 侧 diag + app logcat）----------
    BT = D.BattleTrack(S_LO, S_HI)
    stable_since = None
    linkup_stable = False
    t0 = time.time()
    deadline = t0 + args.runsec
    # app-nav 已经捕获过 LINKUP_OK 就视为已见证（A9 教训：漫长的 POST-LINKUP
    # 会让 -t2000 logcat 窗口把 LINKUP_OK 冲掉，导致采样期 app_link_seen=False，
    # 即便真的进战斗也会被 battle_yes 的 app_link_seen 条件挡成 NO）。
    app_link_seen = app_nav_state["reached"] in ("linkup", "battle")
    app_log = os.path.join(gdir, "app_logcat.log")
    smp = open(os.path.join(gdir, "samples.log"), "w", encoding="utf-8")
    samples = 0
    # 战斗中 APP 端 emuFps 样本（行时间戳 -> fps），用于 summary 的 fps_app。
    app_fps_by_ts = {}
    # 房号一致性状态：app 房号来自 logcat（最新 relay 广告），PC 房号来自 AUTOLINK。
    room_app = room
    room_resyncs = 0
    MAX_RESYNCS = 3
    ROOM_CHECK_EVERY = 3                 # 每 3 次采样（~6s）读一次房号
    rooms_match = True
    # app 进程看门狗：app 被回收后 logcat 不再有房号/握手行，旧的 relay 广告还留在
    # 缓冲里 ⇒ 驱动会静默等到 420s 才报 BATTLE=NO（假阴性）。每 ROOM_CHECK_EVERY
    # 次采样查一次 pid，连续 3 次查不到就 fail-fast 并写明原因。
    app_pid0 = app_pid()
    app_pid_miss = 0
    app_restarts = 0
    app_alive = True
    while time.time() < deadline:
        if not pc.alive():
            log("FATAL: PC 进程退出 rc=%s" % pc.proc.poll())
            break
        dt = logcat_text()
        with open(app_log, "w", encoding="utf-8") as f:
            f.write(dt)
        if menu_lock_ok and re.search(r"pc=2|lstate=4|st=4|LINKUP|linkup.*(1|success)", dt, re.I):
            app_link_seen = True
        # B17 fix: app_nav_peek() 可能先以 reached=waiting 退出导航循环，LINKUP_OK
        # 里程碑此时还未进 logcat；必须在主采样循环每轮补查，否则
        # linkup_ctx["master"] 永远为 False -> master_any=False -> BATTLE 假阴性。
        if menu_lock_ok and not linkup_ctx["seen"] and app_linkup_seen():
            linkup_ctx["seen"] = True
            app_link_seen = True
        # ---- app 重开房检测：只重指 PC，不重发 CLOUD（见 launch_pc 注释）----
        if samples % ROOM_CHECK_EVERY == 0:
            pid_now = app_pid()
            if pid_now is None:
                app_pid_miss += 1
                if app_pid_miss >= 3:
                    log("FATAL: app 进程消失（pidof %s 连续 %d 次为空）；停止静默等待"
                        % (PKG, app_pid_miss))
                    app_alive = False
                    break
            else:
                app_pid_miss = 0
                if pid_now != app_pid0:
                    app_restarts += 1
                    log("!! app pid 变化 %s -> %s（第 %d 次；重启会 leave_room 解散房间）"
                        % (app_pid0, pid_now, app_restarts))
                    app_pid0 = pid_now
            # pathb_sync 下 APP 是 joiner，APP logcat 的 relay 广告不是房号权威
            # （可能是 ROM 自动建房残留），拿它比对会把 PC 重指到 stale 房。跳过。
            if not pathb_sync:
                latest = extract_room(room_logcat_text())
                if latest:
                    room_app = latest
                if room_app != room_pc:
                    if room_resyncs < MAX_RESYNCS:
                        room_resyncs += 1
                        log("!! 房号漂移 room_app=%s room_pc=%s（看门狗补发/重开房）；"
                            "重同步 PC #%d（不重发 CLOUD）"
                            % (room_app, room_pc, room_resyncs))
                        room_pc = launch_pc(room_app)
                        room = room_pc
                        rooms_match = True
                    else:
                        log("FATAL: 房号持续不一致 room_app=%s room_pc=%s，重同步 %d 次"
                            "仍失败；停止静默等待（rooms_match=False）"
                            % (room_app, room_pc, room_resyncs))
                        rooms_match = False
                        break
        d = pc.diag()
        # 与 cloud2p-duo.py 共用唯一判据（state4/pc2/MASTER）；
        # gSpecialVar_Result(linkup=1) 仅作诊断，绝不判绿（Agent 15 J1–J4）。
        l4_pc2, master = D.judge_side(d)
        # MASTER 位只会出现在真正的主端：app 作主机时 PC 是从机（lid=1），PC 的
        # st 没有 0x20 位，不能据此判失败。用 app 侧 LINKUP_OK master=1 作为等价信号。
        master_any = master or linkup_ctx["master"]
        success = l4_pc2 and master_any
        if success:
            if stable_since is None:
                stable_since = time.time()
        else:
            stable_since = None
            linkup_stable = False
        if stable_since and time.time() - stable_since >= args.stable_sec:
            linkup_stable = True
        in_battle, cb = pc.in_battle(S_LO, S_HI)   # 严格主循环窗口，初始化帧不算
        if in_battle:
            BT.hits += 1
            BT.last_a = cb
            # 同一时刻抓 APP 的模拟帧率（FRM emuFps），供 speed_parity_check 的
            # 两端 spread 判据使用。dt 是本轮刚读的 logcat，时间戳去重。
            app_fps_by_ts.update(app_fps_samples(dt))
            # 用户新验收标准：进战斗必须核对“对面精灵不是 ???”。首帧落盘战斗截图，
            # 供人工/后续图像判读对手精灵是否真实（名字/sprite），而不只是 cb2 命中。
            if not battle_shot_done[0]:
                battle_shot_done[0] = True
                # 同时记录“PC 进战斗那一瞬 APP 自己的 cb2/link” —— PC 单端进战斗不算成功。
                _aps = peek_state()
                if _aps and _aps.get("raw_ok"):
                    app_battle_at_pc[0] = ("True" if cb2_class(_aps["cb2"]) == "battle"
                                           else "False")
                    app_battle_at_pc[1] = "%08X" % _aps["cb2"]
                    log("PC 进战斗瞬间 APP cb2=%s in_battle=%s m=%d st=%d pc=%d"
                        % (app_battle_at_pc[1], app_battle_at_pc[0],
                           _aps["lkm"], _aps["lkst"], _aps["lkpc"]))
            # 首帧常是黑屏过场：进战斗后 +3/+6/+9 秒各抓一张，
            # 等战斗画面真正渲染出来再判读对手精灵/名字。
            if BT.hits == 1:
                time.sleep(3.0)
                for _fi in range(3):
                    try:
                        sh = app_shot_sig()
                        if sh:
                            _bp = os.path.join(
                                gdir, "battle_opponent_%s_%d.png" % (args.tag, _fi + 1))
                            sh[0].save(_bp)
                            battle_shot_path[0] = _bp
                            log("BATTLE 第 %d 帧截图落盘: %s（核对对手是否为 ???）"
                                % (_fi + 1, _bp))
                    except Exception as ex:                      # noqa: BLE001
                        log("WARN: 战斗截图失败 %s" % ex)
                    time.sleep(3.0)
                # 视觉判据：PC 对战窗口截图也落盘。用户硬标准：出现「野生的」字样
                # 或问号球精灵 => opponent_visual_real=False => opponent FAIL。
                try:
                    # 用 tools/ 下具名的 PID 感知版本（.workbuddy 被 gitignore，改动不入库）。
                    # 关键：只抓本轮 PC(pid=pc.pid) 的窗口——多个 mGBA 并存时绝不因别的
                    # agent 的 mGBA 抢到 EnumWindows 首位而抓错窗口（视觉门假 FAIL 根因）。
                    sys.path.insert(0, os.path.join(ROOT, "tools"))
                    import pcscreen
                    _title_hint = env.get("MGBAX_PC_WINDOW_TITLE")
                    hwnd, wpid, wtitle = pcscreen.find_window_info(
                        pid=pc.pid, title_contains=_title_hint)
                    if hwnd:
                        # 文件名带 PID 便于追溯抓的是哪个窗口；前缀不变，
                        # battle_visual_gate / quick_compare_frames 仍按前缀+glob 命中。
                        _pp = os.path.join(
                            gdir, "battle_opponent_pc_%s_pid%d.png" % (args.tag, pc.pid))
                        pcscreen.grab(hwnd, _pp)
                        pc_battle_shot_path[0] = _pp
                        log("PC 对战截图落盘: %s（hwnd=%d pid=%d title=%s）"
                            % (_pp, hwnd, wpid, wtitle))
                    else:
                        log("WARN: 未找到本轮 PC(pid=%d) 的可见 mGBA 窗口，跳过抓屏"
                            "（绝不抓别的 mGBA 窗口）" % pc.pid)
                except Exception as ex:                      # noqa: BLE001
                    log("WARN: PC 对战截图失败(忽略): %s" % ex)
        samples += 1
        # --app-nav 到达「等待连接」后，若握手尚未收尾（link pc<2），每 5 个采样
        # (~10s) 补一个 A 边沿给 app，驱动 LINKUP 确认；握手一旦到 pc=2 立即停手，
        # 避免 PC 侧那种 A 振荡。app 原生 mgba_mobile.c 也有 mm==0 时的 A 保持逻辑，
        # 这里只是保守补刀，不按 B（B 才是取消）。
        if (args.app_nav and app_nav_state["reached"] == "waiting"
                and samples % 5 == 0 and app_nav_pulses[0] < 12):
            app_press(AK_A, 0.9, 1.4)
            app_nav_state["taps"] += 1
            app_nav_pulses[0] += 1
            app_nav_log("waiting pulse A #%d" % app_nav_pulses[0])
        # LINKUP 收尾后若 cb2 仍未进战斗：按 walk_battle 的座位坐标走一次（只一次）。
        if (args.app_nav and app_nav_state["reached"] in ("waiting", "linkup")
                and not app_nav_seat_done[0] and samples >= 5
                and not args.no_app_seat_walk):
            ps2 = peek_state()
            if (ps2 and ps2.get("raw_ok") and ps2["lkpc"] >= 2
                    and cb2_class(ps2["cb2"]) != "battle"):
                app_nav_seat_done[0] = True
                app_nav_log("触发座位走位: %s" % peek_brief(ps2))
                app_seat_walk()
        smp.write("%s %s fps=%s app_link=%s\n"
                  % (time.strftime("%H:%M:%S"), pc.snap(), pc.fps(), app_link_seen))
        smp.flush()
        if samples % 8 == 0:
            log("采样 %d | %s | app_link_seen=%s" % (samples, pc.snap(), app_link_seen))
        if linkup_stable and in_battle:
            log("BATTLE=YES（PC 稳定 LINKUP + cb2 进对战窗口；app_link_seen=%s）"
                % app_link_seen)
            break
        time.sleep(2.0)

    # ---------- 4b. 进战斗后长稳采样（卡帧/断链判据）----------
    # 旧行为是进战斗 2 帧就结束，无法判断链路是否稳定。这里每秒记一行 PC GLINK
    # + app PEEK + fps + RTT，持续 --battle-hold-sec 秒，落 battle_stability.log。
    hold_stat = {"samples": 0, "rem1": 0, "battle_cb2": 0, "comm_err": 0,
                 "rtt_peak": 0, "app_linkerr": 0}
    if (args.app_nav and args.battle_hold_sec > 0 and linkup_stable and in_battle):
        end_hold = time.time() + args.battle_hold_sec
        with open(os.path.join(gdir, "battle_stability.log"), "w", encoding="utf-8") as hf:
            hf.write("# t rem brs lstate pc st cmdguard cb2 fps rtt_avg rtt_peak "
                     "app_st app_pc app_cb2 app_err\n")
            while time.time() < end_hold:
                d = pc.diag()
                ps = peek_state()
                m = re.search(r"avg=(\d+)ms peak=(\d+)ms", pc.rtt() or "")
                ra, rp = (m.group(1), m.group(2)) if m else ("-", "-")
                if rp.isdigit():
                    hold_stat["rtt_peak"] = max(hold_stat["rtt_peak"], int(rp))
                cb = d.get("cb2", "-")
                try:
                    cb_in = B_LO <= int(cb, 16) < B_HI
                except (TypeError, ValueError):
                    cb_in = False
                if str(d.get("rem", "-")) == "1":
                    hold_stat["rem1"] += 1
                if cb_in:
                    hold_stat["battle_cb2"] += 1
                if ps and ps.get("raw_ok"):
                    if ps["cb2"] == gba.APP_ERR_CB2:  # 统一宏（原值 0x0816D8CD）
                        hold_stat["app_linkerr"] += 1
                    ap_st, ap_pc, ap_cb2 = ps["lkst"], ps["lkpc"], "%08X" % ps["cb2"]
                else:
                    ap_st, ap_pc, ap_cb2 = "-", "-", "-"
                app_err = 1 if (ps and ps.get("raw_ok") and ps["cb2"] == gba.APP_ERR_CB2) else 0
                dt = logcat_text()
                app_fps_by_ts.update(app_fps_samples(dt))  # 战斗稳定期的 APP fps
                if "通信错误" in dt or "LinkError" in dt:
                    hold_stat["comm_err"] += 1
                hf.write("%s rem=%s brs=%s l=%s pc=%s st=%s cmdguard=%s cb2=%s "
                         "fps=%s rtt_avg=%s rtt_peak=%s app_st=%s app_pc=%s "
                         "app_cb2=%s app_err=%d\n"
                         % (time.strftime("%H:%M:%S"), d.get("rem", "-"),
                            d.get("brs", "-"), d.get("lstate", "-"), d.get("pc", "-"),
                            d.get("st", "-"), d.get("cmdguard", "-"), cb,
                            pc.fps(), ra, rp, ap_st, ap_pc, ap_cb2, app_err))
                hf.flush()
                hold_stat["samples"] += 1
                time.sleep(1.0)
        log("长稳采样完成: samples=%d rem1=%d battle_cb2=%d rtt_peak=%dms "
            "app_linkerr=%d comm_err=%d"
            % (hold_stat["samples"], hold_stat["rem1"], hold_stat["battle_cb2"],
               hold_stat["rtt_peak"], hold_stat["app_linkerr"], hold_stat["comm_err"]))

    # 对手真实性双证据：trainer 卡 [RHPLYR] + 上场精灵 [OPPSPECIES]。
    # 两者都非空且合法才允许人工把 opponent_data_real 置 True；driver 自己绝不自动判绿。
    def opponent_evidence():
        r = shell(["logcat", "-d", "-t", "4000", "-s", "mGBA:I"], timeout=25)
        txt = _clean_logcat(r.stdout) if r else ""
        tr = [ln for ln in txt.splitlines() if "[RHPLYR]" in ln]
        sp = [ln for ln in txt.splitlines() if "[OPPSPECIES]" in ln]
        return (tr[-1] if tr else "", sp[-1] if sp else "")

    opp_tr_line, opp_sp_line = opponent_evidence()

    # 跨设备身份：不同邮箱已有 accounts_distinct；不同 IP 只取候选/直连行里的
    # 端 IP，中继地址（两端都连的 relay）不算。拿不到就 UNOBSERVED，保留原始行。
    def identity_evidence():
        pc_txt = ""
        try:
            pc_txt = open(pc.lobby, encoding="utf-8", errors="replace").read()
        except OSError:
            pass
        # 用全量 logcat（600 行窗口会漏掉早期的 [direct] 候选行，IDENTITY 工具已指出）。
        saved_app = os.path.join(gdir, "app_link_startup.log")
        if os.path.exists(saved_app):
            try:
                app_txt = _clean_logcat(open(saved_app, encoding="utf-8",
                                             errors="replace").read())
            except OSError:
                app_txt = logcat_text()
        else:
            app_txt = logcat_text()

        def pick_ip(txt, keys):
            # 只认**本端候选**行；排除 peer= 对端地址、relay 与内网地址。
            # [direct] p2p-rtt 行只有 peer=，绝不能当本端 IP（IDENTITY 反馈的 bug）。
            for ln in reversed(txt.splitlines()):
                if not any(k in ln for k in keys):
                    continue
                peer_ips = set(re.findall(r"peer=((?:\d{1,3}\.){3}\d{1,3})", ln))
                for ip in re.findall(r"(?<![\d.])((?:\d{1,3}\.){3}\d{1,3})(?![\d.])", ln):
                    if ip in peer_ips or ip == "47.103.87.123" \
                            or ip.startswith("10.") or ip.startswith("127."):
                        continue
                    return ip
            return "UNOBSERVED"

        def pick_from_candidates(txt):
            # `[direct] ... 候选 [ip:port, ...] / 对端端口` 行：取 global IP，
            # 排除 peer= 对端地址与 relay。IDENTITY 工具的同一口径。
            for ln in reversed(txt.splitlines()):
                if "候选" not in ln and "candidate" not in ln.lower():
                    continue
                if "对端候选" in ln or "peerCandidates" in ln or "peer candidate" in ln.lower():
                    continue   # 对端候选不是本端出口 IP
                peer = set(re.findall(r"peer=((?:\d{1,3}\.){3}\d{1,3})", ln))
                for ip in re.findall(r"(?<![\d.])((?:\d{1,3}\.){3}\d{1,3})(?![\d.])", ln):
                    if ip in peer or ip == "47.103.87.123":
                        continue
                    try:
                        if ipaddress.ip_address(ip).is_global:
                            return ip
                    except ValueError:
                        continue
            return "UNOBSERVED"

        ip_pc = pick_ip(pc_txt, ("localCandidates", "local=", "本端候选"))
        ip_app = pick_ip(app_txt, ("候选", "candidate", "local="))
        if ip_pc == "UNOBSERVED":
            ip_pc = pick_from_candidates(pc_txt)
        if ip_app == "UNOBSERVED":
            ip_app = pick_from_candidates(app_txt)
        m = re.search(r"peer=((?:\d{1,3}\.){3}\d{1,3}):\d+", pc_txt)
        ip_peer_pc = m.group(1) if m else "UNOBSERVED"
        distinct = ("true" if (ip_pc != "UNOBSERVED" and ip_app != "UNOBSERVED"
                               and ip_pc != ip_app) else "UNOBSERVED")
        mask = lambda s: (s[:3] + "***" + s[-6:]) if s and len(s) > 9 else "***"
        return ip_pc, ip_app, ip_peer_pc, distinct, mask(app_user), mask(acc_user)

    ip_pc, ip_app, ip_peer_pc, ip_distinct, email_app, email_pc = identity_evidence()

    # ---- GRAYPATH4 身份证据补强（仅 --pathb-tcp）：STUN 摘要，真实测量非造假 ----
    # TCP 广播路径不跑 GBoyDirectLink.candidates() → app 无 [direct] 候选行；若只读日志，
    # cross_device_identity_check 的 IP_DISTINCT 会落 UNOBSERVED。这里直接调用 vpn_split
    # 的 pc_stun()/avd_stun() 探测两端公网出口，写 summary 的 public_ip_app/public_ip_pc
    # （该工具 IP_APP_KEYS/IP_PC_KEYS 认作 STRONG）。这是**测量增强**：IP 由 STUN 真实
    # 应答得出，不造邮箱、不造 party、不伪造 CROSSED；探测失败写 UNOBSERVED，绝不编造。
    public_ip_app = "UNOBSERVED"
    public_ip_pc = "UNOBSERVED"
    stun_source = "off"
    if pathb_tcp:
        stun_source = "vpn_split"
        try:
            _vp = os.path.join(ROOT, "tools", "vpn_split.py")
            _spec_vp = importlib.util.spec_from_file_location("mgba_vpn_split", _vp)
            _vpn = importlib.util.module_from_spec(_spec_vp)
            _spec_vp.loader.exec_module(_vpn)
            # vpn_split.apply 后：PC 走 miwifi/WLAN 出口、AVD 回落 google/隧道出口；
            # 真机 run 用 --serial 覆盖脚本默认的 emulator-5554，避免探错设备。
            if getattr(args, "serial", None):
                _vpn.SERIAL = args.serial
            public_ip_pc = _vpn.pc_stun(_vpn.STUN[0][1], _vpn.STUN[0][2]) or "UNOBSERVED"
            public_ip_app = _vpn.avd_stun(_vpn.STUN[1][1], _vpn.STUN[1][2]) or "UNOBSERVED"
        except Exception as ex:                            # noqa: BLE001
            log("[PATHB-TCP] WARN STUN 摘要探测失败: %s（字段写 UNOBSERVED，不伪造）" % ex)
        # 只接受真正含 IPv4 的结果；NO_RESPONSE/TIMEOUT/ERR=* 一律降为 UNOBSERVED。
        _ipv4_re = re.compile(r"(?<![\d.])(?:\d{1,3}\.){3}\d{1,3}(?![\d.])")
        if not _ipv4_re.search(public_ip_app or ""):
            public_ip_app = "UNOBSERVED"
        if not _ipv4_re.search(public_ip_pc or ""):
            public_ip_pc = "UNOBSERVED"
        log("[PATHB-TCP] STUN 摘要 public_ip_pc=%s public_ip_app=%s（测量增强，非造邮箱/"
            "party/CROSSED）" % (public_ip_pc, public_ip_app))

    # app 侧关链/重握手时间序列：ST 迁移、LINK_RESET、CloseLink、GLINK 的 st/brs/rem/sc/rc。
    # ROOTHUNT 新根因：进战斗时 SetCloseLinkCallback 关链 → 重开握手失败 → 0816D8CD 错误屏。
    def app_link_timeline():
        # 优先读 driver 已保存的全量 logcat（verbose 下 4000 行会被冲掉）。
        saved = os.path.join(gdir, "app_link_startup.log")
        if os.path.exists(saved):
            try:
                txt = _clean_logcat(open(saved, encoding="utf-8",
                                         errors="replace").read())
            except OSError:
                txt = ""
        else:
            r = shell(["logcat", "-d", "-t", "12000", "-s", "mGBA:I", "GBoyLink:I"],
                      timeout=25)
            txt = _clean_logcat(r.stdout) if r else ""
        keys = ("ST idx=", "LINK_RESET", "CloseLink", "closeLink", "GLINK ",
                "LINKUP_OK", "[RHTAKE]", "[BIDLE]", "[BSTATE]", "[rearm]", "SetCloseLink")
        lines = [ln.strip() for ln in txt.splitlines()
                 if any(k in ln for k in keys)]
        with open(os.path.join(gdir, "app_link_timeline.log"), "w", encoding="utf-8") as f:
            f.write("\n".join(lines) + "\n")
        return lines

    app_tl = app_link_timeline()
    log("app 侧链路时间线: %d 行（ST/LINK_RESET/CloseLink/GLINK st-brs-rem-sc-rc）"
        % len(app_tl))

    # ---------- 5. 落盘机器可读判据 ----------
    # 收尾再读一次房号，确保断言反映最终状态（app 可能在最后一次采样后又重开房）。
    final_room = extract_room(room_logcat_text())
    if final_room:
        room_app = final_room
    rooms_match = (room_app == room_pc)
    in_battle = BT.hits > 0
    # --app-nav 时额外要求 app 真的走到等待/LINKUP/战斗；只靠 app_link_seen（logcat
    # 文本里出现 pc=2 字样）不足以证明 app 核进入了 link session（E1 假阳性来源）。
    app_nav_ok = ((not args.app_nav) or
                  app_nav_state["reached"] in ("waiting", "linkup", "battle"))
    # 用户硬标准：PC 单端进战斗不算成功，app 也必须在同一时刻处于严格 BattleMainCB2 区。
    app_battle_ok = (app_battle_at_pc[0] == "True")
    battle_yes = bool(linkup_stable and in_battle and app_battle_ok and app_link_seen
                      and rooms_match and app_alive and app_nav_ok)
    fps = pc.fps()

    # ---- Agent 3/8/1/7 结构化证据（与 cloud2p-duo.py 同口径）----
    pr, pd = pc.p2p_result(), pc.p2p_diag()
    pp, pg = pc.mgbx_path(), pc.mgbx_gate()
    rr, bd = pc.rearm_hs(), pc.bus2p_diag()
    raw_link = pc.diag().get("linkup", "-")
    bus2p_ok, bus2p_reason = "N/A", "not path B"
    if args.mode == "B":
        try:
            bus_players = int(bd.get("players", 0))
        except (ValueError, TypeError):
            bus_players = 0
        bus2p_ok = bus_players == 2
        bus2p_reason = ("ok" if bus2p_ok else
                        "caller requests MIRROR_COUNT+1=4 (CloudLink.cpp:2002/2013); "
                        "needs netLinkBusHostLocal(key,2)+netLinkBusJoinLocalSlot(key,1)")

    # APPHUNT: 全程全 tag logcat 的一次性大缓冲落盘。上面的 live 流（app_link_startup.log）
    # 偶尔会被并发 adb 命令打断（APPHUNT-A3 只活了 20s，丢掉了 LINKUP_OK/LINK_ERR 现场），
    # 这里在收尾时再取一次大窗口，任一路径活着就能保住握手/命令期原文。
    full_log_text = ""
    try:
        # 12000 行会被 tunnel push 刷满，把开局 `[direct] 候选` 行挤出窗口，
        # 导致 cross_device_identity_check 默认找不到 app 侧公网候选（见 ADR-007）。
        full = adb(["logcat", "-d", "-t", "120000", "-v", "threadtime"], timeout=120)
        if full:
            full_log_text = _clean_logcat(full.stdout)
            with open(os.path.join(gdir, "app_logcat_full.log"), "w", encoding="utf-8") as f:
                f.write(full_log_text)
    except Exception as ex:                            # noqa: BLE001
        log("APP-NAV: WARN 全量 logcat 落盘失败: %s" % ex)

    # APP 端战斗中 fps：优先用战斗中实时收集的 FRM emuFps（时间戳去重）；
    # 若没启用 battle-hold / 主循环未命中 in_battle，则退回全量 logcat 末尾
    # FRM 样本（收尾紧接战斗之后）。没有样本写 None -> fps_app=-，绝不编造。
    app_fps_pairs = dict(app_fps_by_ts)
    if not app_fps_pairs and full_log_text:
        _recent = app_fps_samples(full_log_text)
        app_fps_pairs = {k: _recent[k] for k in sorted(_recent)[-15:]}
    app_fps = median_of(app_fps_pairs.values())
    # OBS-E：沉默一律显式 UNOBSERVED(...)，禁写 0/空；纯读日志，不改判据。
    _obs_pg_line = ""
    _obs_sp_line = ""
    for _ln in (full_log_text or "").splitlines():
        if "[OPPGATE]" in _ln and not _obs_pg_line:
            _obs_pg_line = _ln
        if "[OPPSPECIES]" in _ln and not _obs_sp_line:
            _obs_sp_line = _ln
    _obs_oppgate = _obs_pg_line or "UNOBSERVED(no_b7_verbose_or_no_battle)"
    _obs_g_enemy_party = _obs_sp_line or "UNOBSERVED(inBattle_gate)"
    _obs_brs_m = re.search(r"\[(?:B7BLK|OPPGATE)\][^\n]*\bbrs=([0-9A-Fa-f]+)",
                           full_log_text or "")
    _obs_brs = _obs_brs_m.group(1) if _obs_brs_m else "UNOBSERVED(no_probe_line)"

    summary = [
        "tag=%s" % args.tag,
        "topology=avd scope=%s" % scope,
        "room=%s mode_requested=%s" % (room, args.mode),
        "room_app=%s room_pc=%s rooms_match=%s" % (room_app, room_pc, rooms_match),
        "room_resyncs=%d" % room_resyncs,
        "BATTLE=%s" % ("YES" if battle_yes else "NO"),
        "linkup_stable=%s master_source=%s" % (
            linkup_stable, "APP" if linkup_ctx["master"] else ("PC" if master else "-")),
        "in_battle_frame=%s battle_samples=%d" % (in_battle, BT.hits),
        "in_battle_cb2_PC=%s" % BT.last_a,
        # 用户硬标准：trainer 卡 ver=4003 + 上场 species 合法（非 0/FFFF）双证据才算真实。
        # driver 只落原始证据行，人工核对后才允许把 opponent_data_real 置 True。
        "opponent_data_real=UNOBSERVED  # 双证据人工核对：RHPLYR ver=4003 且 OPPSPECIES 合法才 True",
        "opponent_trainer_evidence=%s" % (opp_tr_line or "<none>"),
        "opponent_species_evidence=%s" % (opp_sp_line or "<none>"),
        "oppgate=%s  # OBS-E：无 [OPPGATE] 行→UNOBSERVED，不写 0；仅观测" % _obs_oppgate,
        "gEnemyParty=%s  # OBS-E：无 [OPPSPECIES] 行→UNOBSERVED(inBattle_gate)，不写 0" % _obs_g_enemy_party,
        "brs=%s  # OBS-E：无 [B7BLK]/[OPPGATE] brs 行→UNOBSERVED，不写 0000；不进判据" % _obs_brs,
        "email_app=%s email_pc=%s accounts_distinct_email=%s" % (
            email_app, email_pc, app_user != acc_user),
        "ip_local_PC=%s ip_local_APP=%s ip_distinct=%s" % (
            ip_pc, ip_app, ip_distinct),
        "ip_peer_from_PC=%s  # PC 观察到的对端(app)公网 IP；relay 地址不算端 IP" % ip_peer_pc,
        "public_ip_app=%s public_ip_pc=%s stun_source=%s  # GRAYPATH4 STUN 摘要："
        "真实测量出口 IP，非造 email/party/CROSSED；cross_device_identity_check 认作 STRONG"
        % (public_ip_app, public_ip_pc, stun_source),
        "app_link_timeline_lines=%d app_link_timeline_tail=%s"
        % (len(app_tl), " | ".join(app_tl[-4:]) if app_tl else "<none>"),
        "battle_screenshot=%s" % (battle_shot_path[0] or "<none>"),
        "battle_screenshot_PC=%s" % (pc_battle_shot_path[0] or "<none>"),
        "opponent_visual_real=%s  # 人工核对：野生的/问号球=fake；三者全真才可置 opponent_data_real=True"
        % args.opponent_visual,
        "app_in_battle_at_pc_battle=%s app_cb2=%s  # PC 单端进战斗不算成功"
        % (app_battle_at_pc[0], app_battle_at_pc[1] or "<none>"),
        "battle_window=[0x%X,0x%X) source=rom.elf:BattleMainCB2  # 严格主循环；宽窗=[0x%X,0x%X)"
        % (S_LO, S_HI, B_LO, B_HI),
        "app_link_seen=%s app_alive=%s app_restarts=%d" % (
            app_link_seen, app_alive, app_restarts),
        "fps_pc=%s" % ("%.1f" % fps if fps else "-"),
        "fps_app=%s  # APP FRM emuFps（战斗中模拟帧率），供两端 spread 判据"
        % ("%.1f" % app_fps if app_fps is not None else "-"),
        "via=%s" % pc.via(),
        "peerCandidates_PC=%s" % pc.peer_candidates(),
        "peerCandidateCount_PC=%s directEnabled_PC=%s p2p_result_PC=%s"
        % (pr.get("peerCandidateCount", pd.get("peerCandidates", "-")),
           pr.get("directEnabled", "-"), pr.get("result", "-")),
        "p2p_avg_PC=%s p2p_ignored_PC=%s" % (pd.get("avg", "-"), pd.get("ignored", "-")),
        "path_PC=%s" % pp.get("path", "-"),
        "mode_negotiated_PC=%s" % (pc.negotiated_mode() or "-"),
        "official_mode_PC=%s" % pc.official_mode(),
        "gate_PC envLinkMode=%s envOfficialLink=%s envRearm=%s fastMinOk=%s fastMinOkSlave=%s"
        % (pg.get("envLinkMode", "-"), pg.get("envOfficialLink", "-"),
           pg.get("envRearm", "-"), pg.get("fastMinOk", "-"),
           pg.get("fastMinOkSlave", "-")),
        "env_fast_slave_align=%s" % env.get("MGBAX_FAST_SLAVE_ALIGN", "<unset>"),
        "rearm_PC fired=%s hs1=%s rounds=%s" % (rr["fired"], rr["hs1"], rr["rounds"]),
        "slave_fast_align_blocked_PC=%s badchecksum_PC=%s"
        % (pc.fast_align_blocked(), pc.bad_checksum_count()),
        "bus_diag_PC players=%s attached=%s slot=%s idx=%s hostIdx=%s"
        % (bd["players"], bd["attached"], bd["slot"], bd["idx"], bd["hostIdx"]),
        "pathB_2p_bus_ok=%s reason=%s" % (bus2p_ok, bus2p_reason),
        "linkup_raw_PC=%s  # gSpecialVar_Result 残留值，仅诊断不判绿" % raw_link,
        "accounts_distinct=%s" % (app_user != args.pc_acc.split(":", 1)[0]),
        "uuid_app=%s uuid_pc=%s uuids_distinct=%s" % (
            uuid_app, uuid_pc, uuids_distinct),
        "rom_load_verified=1  # logcat 命中 rom broadcast load + emu loop reloading 的推送路径",
        "app_nav_enabled=%s app_nav_reached=%s app_nav_ok=%s" % (
            app_nav_state["enabled"], app_nav_state["reached"], app_nav_ok),
        "app_nav_taps=%d app_nav_samples=%d app_nav_seat_ok=%s" % (
            app_nav_state["taps"], app_nav_state["samples"], app_nav_state["seat_ok"]),
        "app_nav_final_peek=%s" % (app_nav_state["final_peek"] or "(none)"),
        "battle_hold_sec=%.0f hold_samples=%d hold_rem1=%d hold_battle_cb2=%d "
        "hold_rtt_peak_ms=%d hold_app_linkerr=%d hold_comm_err=%d"
        % (args.battle_hold_sec, hold_stat["samples"], hold_stat["rem1"],
           hold_stat["battle_cb2"], hold_stat["rtt_peak"],
           hold_stat["app_linkerr"], hold_stat["comm_err"]),
        "host_first=%s" % (not args.room),
        "final_PC=%s" % pc.snap(),
        "rtt_PC=%s" % (pc.rtt() or "-"),
        "multi_PC=%s" % (pc.multi() or "-"),
        "note=%s" % ("PROXY-2PC 不算跨设备；本轮为 PC↔AVD/真机"
                     if scope != "PROXY-2PC" else ""),
    ]
    # ---- PATHB 判据观测（只读打点，仅 mode B 输出；门 FAIL/0/9 如实，不预设成功）----
    # 这些是 ARCH15 判读矩阵所需字段：players/mirrors、via、state 同步、localbus 2p、cb2 战斗窗。
    # 纯观测：日志未出现的状态一律写 UNOBSERVED，绝不伪造成功。
    if args.mode == "B":
        mirror_idx = set()
        state_sync = "UNOBSERVED"
        _pathb_txt = pc.stdout_text() + "\n" + full_log_text
        for _ln in _pathb_txt.splitlines():
            _mi = re.search(r"\[mirror\]\s+idx=(\d+)", _ln)
            if _mi:
                mirror_idx.add(_mi.group(1))
            if state_sync == "UNOBSERVED":
                if ("remote state loaded" in _ln
                        or re.search(r"TYPE_STATE[^\n]*(loaded|applied|ok)", _ln, re.I)):
                    state_sync = "loaded"
                elif re.search(r"TYPE_STATE[^\n]*(reject|code -5)", _ln, re.I):
                    state_sync = "rejected"
        summary.extend([
            "[PATHB] players=%s mirrors=%d via=%s" % (
                bd.get("players", "-"), len(mirror_idx), pc.via()),
            "[PATHB] state_sync=%s  # TYPE_STATE/remote state loaded；UNOBSERVED=日志未见，不预设成功"
            % state_sync,
            "[PATHB] localbus_2p_ok=%s bus_players=%s  # players==2 才算 2P bus 就绪"
            % (bus2p_ok, bd.get("players", "-")),
            "[PATHB] cb2_battle_window_PC=%s in_battle=%s app_battle_at_pc=%s  # 是否进战斗窗"
            % ("YES" if BT.hits > 0 else "NO", in_battle, app_battle_at_pc[0]),
        ])
        # ---- PATHB-PCNAV 观测（PB18；纯只读打点，不预设成功）----
        # pc_nav.log 由 ScriptedControl 在可见核写：nav armed / f=… cb2=… BATTLE=YES /
        # battle reached keys released。cb2 全 0=仍在菜单、非 0=已走过菜单；未见一律 UNOBSERVED。
        _pcnav_txt = ""
        try:
            _pn = os.path.join(pc_keys, "pc_nav.log")
            if os.path.exists(_pn):
                with open(_pn, encoding="utf-8", errors="replace") as f:
                    _pcnav_txt = f.read()
        except OSError:
            pass
        _pcnav_armed = "YES" if "nav armed" in _pcnav_txt else "UNOBSERVED"
        _pcnav_reached = "YES" if "battle reached" in _pcnav_txt else "UNOBSERVED"
        _pcnav_cb2 = re.findall(r"cb2=([0-9A-Fa-f]+)", _pcnav_txt)
        _pcnav_cb2_leave = ("YES" if any(v.lstrip("0") for v in _pcnav_cb2)
                            else "NO") if _pcnav_cb2 else "UNOBSERVED"
        summary.append(
            "[PATHB-PCNAV] enabled=%d nav_source=%s armed=%s cb2_left_menu=%s "
            "battle_reached=%s  # 纯观测；UNOBSERVED=pc_nav.log 未见，不预设成功"
            % (1 if (args.mode == "B" and args.pathb_pc_nav) else 0,
               ("CloudLink(env MGBAX_NAV_AT)" if (args.mode == "B" and args.pathb_pc_nav)
                else "none"),
               _pcnav_armed, _pcnav_cb2_leave, _pcnav_reached))
        # ---- PATHB-SYNC 观测（只读打点；窗口对齐≠P2P 成功，不预设）----
        def _p2p_tail(txt):
            _m = re.search(
                r"\[MGBAX_P2P\][^\n]*event=result[^\n]*result=(\w+)[^\n]*via=(\w+)",
                txt or "")
            return ("%s/%s" % (_m.group(1), _m.group(2))) if _m else "UNOBSERVED"

        _pc_lobby = ""
        try:
            _lp = os.path.join(pc_tmp, "mgba_lobby_debug.log")
            if os.path.exists(_lp):
                with open(_lp, encoding="utf-8", errors="replace") as f:
                    _pc_lobby = f.read()
        except OSError:
            pass
        summary.extend([
            "[PATHB-SYNC] enabled=%d role=%s room=%s gap=%s  # gap=检测到PC建房→发APP入房广播"
            "（不含APP处理延迟）；仅窗口对齐证明，非成功判据"
            % (1 if pathb_sync else 0,
               ("PC-host/APP-join" if pathb_sync else "APP-host/PC-join(原流程)"),
               pathb_sync_ctx["room"] or "-",
               ("%.2fs" % pathb_sync_ctx["gap"])
               if pathb_sync_ctx["gap"] is not None else "-"),
            "[PATHB-SYNC] p2p_result_APP=%s p2p_result_PC=%s  # 两端都 result=ok/via=p2p "
            "才算协商成功；UNOBSERVED=日志未见，不伪造"
            % (_p2p_tail(full_log_text), _p2p_tail(_pc_lobby)),
        ])
        # ---- PATHB-TCP 观测（只读打点；直连成功≠对手真实性，不预设）----
        # OBS-F（1 行纯 bug）：CloudLink::status() 的 TCP 状态行写进 mgba_lobby_debug.log
        # （=_pc_lobby），不写 pc stdout。原只检索 stdout ⇒ 恒 UNOBSERVED 假阴性。
        _tcp_pc_txt = pc.stdout_text() + "\n" + _pc_lobby
        _pc_listen_seen = "YES" if "正在监听 TCP 端口" in _tcp_pc_txt else "UNOBSERVED"
        _pc_tcp_up_seen = "YES" if "TCP 直连已建立" in _tcp_pc_txt else "UNOBSERVED"
        _app_tcp_bcast_seen = ("YES" if re.search(r"tcp broadcast peer=", full_log_text or "")
                               else "UNOBSERVED")
        summary.extend([
            "[PATHB-TCP] enabled=%d pc_listen_port=%s app_peer=%s:%d  "
            "# 拓扑② 本机桥接，数据面不经 WAN；对外不得称纯公网跨设备 P2P"
            % (1 if pathb_tcp else 0,
               (str(PATHB_TCP_PORT) if pathb_tcp else "-"),
               PATHB_TCP_HOST, PATHB_TCP_PORT),
            "[PATHB-TCP] no_direct=%d broadcast_sent=%d sent_at=%s listen_ready=%s "
            "listen_wait=%s listen_source=%s pc_listen_log=%s pc_tcp_up_log=%s "
            "app_tcp_broadcast_log=%s  # no_direct=1 关 UDP 打洞强制 TCP env；"
            "日志/端口未见一律 UNOBSERVED，不作成功判据"
            % (1 if (pathb_tcp and env.get("MGBAX_NO_DIRECT") == "1") else 0,
               1 if pathb_tcp_ctx["broadcast_sent"] else 0,
               ("%.1fs" % pathb_tcp_ctx["sent_at"])
               if pathb_tcp_ctx["sent_at"] else "-",
               str(pathb_tcp_ctx["listen_ready"]),
               ("%.1fs" % pathb_tcp_ctx["listen_wait"])
               if pathb_tcp_ctx["listen_wait"] is not None else "-",
               pathb_tcp_ctx["listen_source"],
               _pc_listen_seen, _pc_tcp_up_seen, _app_tcp_bcast_seen),
            "[PATHB-TCP] stun_source=%s public_ip_app=%s public_ip_pc=%s via_PC=%s  "
            "# 身份仅由 STUN 出口证明；UNOBSERVED=探测失败不伪造"
            % (stun_source, public_ip_app, public_ip_pc, pc.via()),
        ])
    # ---- ISYNC23: ISYNC_STATE_APPLY 门 + seed applied 只读观测（不判 PASS）------
    # 门回读只证门开（ISYNC14 §0：门开≠applied）；applied 按日志只读观测：
    # 真 load 证据才写 loaded，只有 deferred/负向标记（无 load）写 UNOBSERVED；
    # 里程碑 "[ISYNC] ... slot=" 是可见核槽（ISYNC14 §1.3），一律不采信；不预设成功。
    _isync_txt = pc.stdout_text() + "\n" + full_log_text
    _isync_app_load = ISYNC_APPLIED_APP_RE.search(_isync_txt)
    _isync_pc_load = ISYNC_APPLIED_PC_RE.search(_isync_txt)
    _isync_neg = bool(ISYNC_STATE_NEG_RE.search(_isync_txt))
    _isync_applied = ("loaded" if (_isync_app_load or _isync_pc_load)
                      else "UNOBSERVED")
    _isync_gate_seen = bool(ISYNC_STATE_APPLY_READBACK_RE.search(_isync_txt))
    summary.extend([
        "[ISYNC] state_apply_gate=%d broadcast_sent=%d gate_readback=%s  "
        "# 只读观测；门开≠applied，广播失败显式WARN，不预设成功"
        % (1 if isync_ctx["enabled"] else 0,
           1 if isync_ctx["broadcast_sent"] else 0,
           "YES" if _isync_gate_seen else isync_ctx["gate_readback"]),
        "[ISYNC-EV] evidence_gate=%d broadcast_sent=%d gate_readback=%s  "
        "# 只读观测；门开!=C5 PASS，广播失败显式WARN，不预设成功"
        % (1 if isync_ctx["ev_enabled"] else 0,
           1 if isync_ctx["ev_broadcast_sent"] else 0,
           isync_ctx["ev_gate_readback"]),
        "[ISYNC-SFB] seed_frame_boundary_gate=%d broadcast_sent=%d gate_readback=%s  "
        "# 只读观测、非证据：根治门广播/回读只反映 Java 门开，门开≠压测有效；"
        "CROSSED 唯一裁决，FAIL/0/9 不变，不预设成功"
        % (1 if isync_ctx["sfb_enabled"] else 0,
           1 if isync_ctx["sfb_broadcast_sent"] else 0,
           isync_ctx["sfb_gate_readback"]),
        "[ISYNC] applied=%s app_load_slot=%s pc_load_slot=%s negative_marker=%d  "
        "# 只读观测、非判据：deferred/负向(无真load)→UNOBSERVED；真loaded+index=0 slot=→loaded；"
        "里程碑slot=（可见核）不采信；不判PASS"
        % (_isync_applied,
           _isync_app_load.group(2) if _isync_app_load else "-",
           _isync_pc_load.group(2) if _isync_pc_load else "-",
           1 if _isync_neg else 0),
    ])
    # ---- RACESTRESS: 造宽窗门 ms 下发值 + getprop 回读只读打点（非判据）----
    # 门关=0ms、历史布尔 "1"→300ms、纯数字=透传 ms。仅记 driver 下发与回读，
    # 不证竞态命中；压测轮产物按灰区/压测口径标注，CROSSED 唯一裁决，
    # 门 FAIL/0/9 不变，不预设成功。
    summary.append(
        "[RACESTRESS] ms=%s readback=%s  # 造宽窗门下发值/回读：0ms=门关，非0=造窗；"
        "纯观测非判据，压测口径标注、CROSSED 唯一裁决，不预设成功"
        % (race_stress_ms, (_rs_readback or "UNOBSERVED")))
    with open(os.path.join(gdir, "summary.txt"), "w", encoding="utf-8") as f:
        f.write("\n".join(summary) + "\n")
    for s in summary:
        log(s)

    if not rooms_match:
        # fail-fast 的可读出口：机器可读判据 room_app/room_pc/rooms_match 已落盘，
        # 这里再打一条明确的中文 FATAL，并把非零返回码交给调用方（Agent 13）。
        log("FATAL: room_app(%s) != room_pc(%s)：app 与 PC 不在同一房间；"
            "本轮跨设备 2P 无效。检查是否有外部 watchdog 重复发送 CLOUD 广播"
            "（每发一次就会解散旧房并重建新房）" % (room_app, room_pc))

    if pc.alive():
        subprocess.run(["taskkill", "/F", "/PID", str(pc.pid)], capture_output=True)
    if emu_proc and emu_proc.poll() is None:
        subprocess.run(["taskkill", "/F", "/PID", str(emu_proc.pid)], capture_output=True)
    log("结束")
    return 0 if rooms_match else 5


if __name__ == "__main__":
    sys.exit(main())
