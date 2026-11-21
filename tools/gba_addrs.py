#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""gba_addrs.py -- GBA 联机工作流统一地址宏模块（AGENTS §5 地址硬约束落地）。

目的
----
把工作流脚本里散落的裸 hex 地址全部收拢为**具名宏**（本模块的模块级常量）。
PC driver（cloud2p_avd.py）、mobile driver（cloud2p_avd_vis.py）、双 PC 驱动
（cloud2p-duo.py）以及各校验/观测脚本统一 `from gba_addrs import ...`，
三端引用同一份定义 ⇒ **天然同名同值**，杜绝"各写各的裸 hex 导致口径漂移"。

来源标注（每个宏的注释末尾）
--------------------------
  * rom.map        —— 由仓库/构建产物 rom.map 离线提取的符号地址
  * 源码实测        —— 由 sio_link.c / mgba_mobile.c / link.c 侧实测或定义
  * 文档值/待核实   —— 仅出现在任务文本/文档/summary 字符串里，未在本轮代码里
                       作为整数常量使用，标"待核实"，不据此下任何判据
  * Win32          —— Windows API 常量（非 GBA 地址，仅为屏幕抓取工具一并收敛）

纪律
----
  * 宏化纯属工程纪律（AGENTS §5），**不改变任何判据真实性**：
    总门 FAIL / 对手真实性 0/9、CROSSED 唯一裁决、不预设成功、红线禁造假。
  * 仅替换"可执行代码里的整数地址字面量"；注释/文档字符串/测试夹具字符串里
    出现的 hex 属于人类可读文档与期望文本，保持原样以零改变行为。
  * 运行时 delta 解析（sioResolve*Delta）口径不变，本模块只钉死基准地址。
"""

# =============================================================================
# 一、ROM 函数 / 符号地址（0x08xxxxxx）
# =============================================================================

# 战斗主循环精确 cb2 窗口 = BattleMainCB2 .. FreeRestoreBattleData。
# 这是"真进战斗"的唯一 cb2 区间判据（Thumb cb2 值，直接比较，非符号值）。
BATTLE_CB2_LO = 0x080B4845          # BattleMainCB2 Thumb cb2，精确区下界（rom.map）
BATTLE_CB2_HI = 0x080B48A8          # FreeRestoreBattleData，精确区上界（rom.map）
BATTLE_CB2_SYM = 0x080B4844         # BattleMainCB2 符号值（Thumb 位清零）（rom.map）

# battle_main.o .text 宽窗（= 整个 section）。summary.battle_window 旧口径，
# 含 CB2_InitBattle / CB2_HandleStartBattle，是历史假阳性来源，不作成功判据。
BATTLE_PROLOGUE_LO = 0x080B30C0     # battle_main.o .text prologue / 战斗宽窗 lo（rom.map）
BATTLE_PROLOGUE_HI = 0x080BCA78     # battle_main.o .text 宽窗 hi（rom.map）
BATTLE_WIDE_SIZE = 0x99B8           # 宽窗 section_size（几何量，非地址）（rom.map）

# 里程碑 cb2（均落在宽窗内、精确战斗窗外 —— 出现它们说明"未进主循环"）。
CB2_HANDLE_START_BATTLE = 0x080B376D  # CB2_HandleStartBattle 早窗（rom.map）
CB2_INIT_BATTLE = 0x080B310D          # CB2_InitBattle（rom.map；仅文档引用，待核实）

# 错误屏 / CABLE_CLUB 回调。
APP_ERR_CB2 = 0x0816D8CD            # CB2_PrintErrorMessage，APP 错误屏 cb2（rom.map）
CABLE_CLUB_CB2_LO = 0x08105FD4      # CABLE_CLUB_CB2 起点（rom.map）
CABLE_CLUB_CB2_HI = 0x08107488      # CABLE_CLUB_CB2 终点（rom.map）

# 旧构建 / 废弃硬编码窗口（仅作 ENV 对照与仿真夹具，非当前判据）。
STALE_BATTLE_LO = 0x08099848        # 废弃硬编码战斗窗 lo（ENV 对照值，文档值/待核实）
STALE_BATTLE_HI = 0x080A30FD        # 废弃硬编码战斗窗 hi（ENV 对照值，文档值/待核实）
OLD_PROLOGUE_LO = 0x080B24B8        # 旧构建 battle_main.o prologue（旧 map，文档值/待核实）
OLD_PROLOGUE_HI = 0x080BBE4C        # 旧构建宽窗 hi（旧 map，文档值/待核实）
OLD_BATTLE_CB2_SYM = 0x080B3C3C     # 旧构建 BattleMainCB2 map 值（文档值/待核实）
OLD_BATTLE_CB2_TASKTEXT = 0x080B3C3D  # 任务文本所写（off-by-one，文档值/待核实）
BATTLE_MAIN_TEXT_LO = 0x080B7FB0    # battle_main.o .text lo（仅注释引用，文档值/待核实）
BATTLE_MAIN_TEXT_HI = 0x080C1968    # battle_main.o .text hi（仅注释引用，文档值/待核实）

# 几何偏移：prologue 起点 -> BattleMainCB2 符号（Thumb 位清零）。非地址。
PROLOGUE_TO_CB2 = 0x1784            # section start -> BattleMainCB2（geometry）

# =============================================================================
# 二、ROM 区边界（0x08xxxxxx，用于 cb2 合法性预筛）
# =============================================================================
ROM_BASE = 0x08000000               # GBA ROM 镜像基址；运行时 = 基址 + 文件偏移（源码实测）
ROM_BATTLE_WINDOW_LO = 0x08100000   # summary.battle_window lo（rom.map，文档值）
ROM_BATTLE_WINDOW_HI = 0x08110000   # summary.battle_window hi（rom.map，文档值）
ROM_TEXT_LO = 0x08160000            # cb2 合法性区间下界（源码实测）
ROM_TEXT_HI = 0x08190000            # cb2 合法性区间上界（源码实测）

# =============================================================================
# 三、IWRAM / SIO 变量地址与偏移（0x030xxxxx）
# =============================================================================
IWRAM_LO = 0x03000000               # IWRAM 下界（源码实测）
IWRAM_HI = 0x03007FF0               # IWRAM 上界（源码实测）
IWRAM_SCAN_ARRAY_SIZE = 0x8000      # cnt[0x8000] 静态表大小（按字节地址索引）（geometry）

SIO_GLINK_BASE = 0x03002AF4         # 旧基准 gLink（delta 基准；C 侧 SIOROM 同判据）（源码实测）
SIO_RECV_BASE = 0x03002B1E          # gen8 gRecvCmds（rom.map）
SIO_SEND_BASE = 0x03002B84          # gen8 gSendCmd（rom.map）
SIO_GLINK_GEN8 = 0x03002BC8         # gen8 gLink（rom.map）
SIO_RECV_OLD = 0x03002A4A           # 旧构建 gRecvCmds（旧 map，文档值/待核实）
SIO_SEND_OLD = 0x03002AB0           # 旧构建 gSendCmd（旧 map，文档值/待核实）

IWRAM_SPACING = 0x66                # gSendCmd - gRecvCmds 字节偏移（源码实测）
GLINK_OFFSET = 0xAA                 # gLink - gRecvCmds 字节偏移（源码实测）

# =============================================================================
# 四、EWRAM 地址（0x020xxxxx）
# =============================================================================
EWRAM_LO = 0x02000000               # EWRAM 下界（源码实测）
EWRAM_HI = 0x0203FFF0               # EWRAM 上界（源码实测）
EWRAM_END = 0x02040000              # EWRAM 结束地址（源码实测）
G_TASKS_BASE = 0x02033D0C           # gTasks 基准（delta 基准）（源码实测）

# =============================================================================
# 五、屏幕抓取常量（Win32，非 GBA 地址；一并收敛便于三端一致引用）
# =============================================================================
PW_RENDERFULLCONTENT = 0x00000002   # PrintWindow 全内容标志（Win32）
SRCCOPY = 0x00CC0020                # BitBlt 光栅操作码（Win32）


# -----------------------------------------------------------------------------
# 自检：宏值 == 原裸 hex（防止手滑改值）。`python tools/gba_addrs.py` 运行。
# -----------------------------------------------------------------------------
_EXPECTED = {
    "BATTLE_CB2_LO": 0x080B4845, "BATTLE_CB2_HI": 0x080B48A8,
    "BATTLE_CB2_SYM": 0x080B4844,
    "BATTLE_PROLOGUE_LO": 0x080B30C0, "BATTLE_PROLOGUE_HI": 0x080BCA78,
    "BATTLE_WIDE_SIZE": 0x99B8,
    "CB2_HANDLE_START_BATTLE": 0x080B376D, "CB2_INIT_BATTLE": 0x080B310D,
    "APP_ERR_CB2": 0x0816D8CD,
    "CABLE_CLUB_CB2_LO": 0x08105FD4, "CABLE_CLUB_CB2_HI": 0x08107488,
    "STALE_BATTLE_LO": 0x08099848, "STALE_BATTLE_HI": 0x080A30FD,
    "OLD_PROLOGUE_LO": 0x080B24B8, "OLD_PROLOGUE_HI": 0x080BBE4C,
    "OLD_BATTLE_CB2_SYM": 0x080B3C3C, "OLD_BATTLE_CB2_TASKTEXT": 0x080B3C3D,
    "BATTLE_MAIN_TEXT_LO": 0x080B7FB0, "BATTLE_MAIN_TEXT_HI": 0x080C1968,
    "PROLOGUE_TO_CB2": 0x1784,
    "ROM_BASE": 0x08000000,
    "ROM_BATTLE_WINDOW_LO": 0x08100000, "ROM_BATTLE_WINDOW_HI": 0x08110000,
    "ROM_TEXT_LO": 0x08160000, "ROM_TEXT_HI": 0x08190000,
    "IWRAM_LO": 0x03000000, "IWRAM_HI": 0x03007FF0,
    "IWRAM_SCAN_ARRAY_SIZE": 0x8000,
    "SIO_GLINK_BASE": 0x03002AF4, "SIO_RECV_BASE": 0x03002B1E,
    "SIO_SEND_BASE": 0x03002B84, "SIO_GLINK_GEN8": 0x03002BC8,
    "SIO_RECV_OLD": 0x03002A4A, "SIO_SEND_OLD": 0x03002AB0,
    "IWRAM_SPACING": 0x66, "GLINK_OFFSET": 0xAA,
    "EWRAM_LO": 0x02000000, "EWRAM_HI": 0x0203FFF0,
    "EWRAM_END": 0x02040000, "G_TASKS_BASE": 0x02033D0C,
    "PW_RENDERFULLCONTENT": 0x00000002, "SRCCOPY": 0x00CC0020,
}


def self_test():
    bad = [k for k, v in _EXPECTED.items() if globals()[k] != v]
    if bad:
        raise AssertionError("宏值漂移: " + ", ".join(bad))
    return len(_EXPECTED)


if __name__ == "__main__":
    n = self_test()
    print("gba_addrs self-test OK: %d 个宏值 == 原裸 hex" % n)
