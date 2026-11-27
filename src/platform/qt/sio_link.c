/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
/**
 * LAN SIO link cable, a C port of the mobile-layer GbaLinkDriver
 * (src/platform/mobile/mgba_mobile.c lines ~1700-2830) for the Qt port.
 * The comments there carry the full reasoning; this port keeps the logic
 * byte-for-byte and drops the logcat debug counters.
 */
#include "sio_link.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* GBA 硬件固定地址：IO 寄存器与内存映射基址不随 ROM 重建平移，但读取点
 * 一律用具名宏，禁止出现裸地址（换 ROM / 移植时只改这里）。 */
#define GBA_EWRAM_BASE 0x02000000u
#define GBA_IWRAM_BASE 0x03000000u
#define GBA_IO_BASE    0x04000000u
#define GBA_VRAM_BASE  0x06000000u
#define GBA_OAM_BASE   0x07000000u
#define GBA_ROM_BASE   0x08000000u
/* 扫描器用的区间端点（同样是硬件固定值） */
#define GBA_EWRAM_SCAN_END 0x0203FFF0u
#define GBA_EWRAM_END      0x02040000u
#define GBA_IWRAM_SCAN_END 0x03007FF0u
#define GBA_IWRAM_END      0x03008000u

/* SIO / 定时器相关 IO 寄存器（GBA 硬件固定） */
#define SIO_REG_TM3CNT_LO    0x0400010Cu  /* 旧称 RCNT 槽位，InitTimer 低半 */
#define SIO_REG_TM3CNT_HI    0x0400010Eu  /* InitTimer 高半 */
#define SIO_REG_SIOMLT_RECV0 0x04000120u
#define SIO_REG_SIOMLT_RECV1 0x04000122u
#define SIO_REG_SIOMLT_RECV2 0x04000124u
#define SIO_REG_SIOMLT_RECV3 0x04000126u

/* 协议常量（非 ROM 地址）：关链 opcode LINKCMD_READY_CLOSE_LINK。
 * 两端同名同值，收口裸字面量 0x5FFF，行为完全等价。 */
#define LINKCMD_READY_CLOSE_LINK 0x5FFFu
/* ROOTHUNT2 修复② 块交换让位宏（三端对称，禁裸 hex） */
#define LINKCMD_INIT_BLOCK        0xBBBBu   /* LINKCMD_INIT_BLOCK (SetupBlock 头) */
#define LINKCMD_CONT_BLOCK        0x8888u   /* LINKCMD_CONT_BLOCK (数据块) */
#define LINKCMD_SEND_LINK_TYPE    0x2222u   /* 玩家数据交换命令字 */
#define LINK_HANDSHAKE_MASTER     0x8FFFu   /* 主机握手字 */
#define LINK_HANDSHAKE_SLAVE      0xB9A0u   /* 从机握手字 */
#define LINK_HANDSHAKE_SLAVE_MASK 0x3u      /* 从机握手字低 2 位掩码 */
#define LINK_STAT_MASTER          0x20u     /* gLinkStatus MASTER 位 */
#define LINK_MU_BLOCK2            2u        /* gBattleCommunication[MULTIUSE_STATE] 块期值 */
#define LINK_MU_BLOCK4            4u
#define LINK_MU_BLOCK8            8u
#define LINK_MU_BLOCK12           12u
#define LINK_MU_BLOCK17           17u

/* 【ROM 版本切换 2026-11-18 00:2x】
 *
 * 工作区 rom.gba 换成了 gen8 的 22:59 构建（md5 d23d3197…，与 rom.map/rom.elf
 * 同一构建，符号可查）。相对旧的 02:27 构建：
 *   - **IWRAM（0x03xxxxxx）统一 +0xD4**：gLink / gLinkStatus / gRecvCmds /
 *     gSendCmd / gBlockReceivedStatus / gReceivedRemoteLinkPlayers /
 *     sBlockRecv / gSaveBlock1Ptr / gFieldLinkPlayerCount 九个符号逐一核对一致；
 *   - **EWRAM 不一致**（gSpecialVar_Result 未动、gLinkType/gPartyMenu +0x30），
 *     所以不能全局平移，只对 IWRAM 访问套 SIO_IW()。
 * 切回旧 ROM：把 SIO_IWRAM_DELTA 改成 0（并换回 .rom-backup 里的两份 ROM）。
 * 注意：所有 IWRAM 访问都必须经过 GBAView 或 GBAPatch，SIO_IW 才有意义。 */
/* 基准：下面所有 IWRAM 地址都按"这份 ROM 的 gLink 在 0x03002AF4"写死，
 * 实际使用时统一加上运行期解析出来的 sioIwramDelta。 */
#define SIO_IW_BASE_GLINK 0x03002AF4u
static uint32_t sioIwramDelta = 0xD4u;
static bool sioIwramDeltaDone;
/* 前向声明：三个 ROM 扫描器都要能回退到「已加载核心的 gba->memory.rom」。
 * struct SioLink 的完整定义在下面（含 mgba GBA 头文件之后），这里只需指针。 */
struct SioLink;
static const uint8_t* sioLoadedRomBytes(struct SioLink* sio, size_t* sizeOut);
static void sioResolveIwramDelta(struct SioLink* sio);
#define SIO_IW(a) ((uint32_t) (a) + sioIwramDelta)

/* EWRAM（0x02000000..0x0203FFFF）同理：旧 ROM 的 EWRAM 地址与 gTasks 的相对
 * 距离在**同一份源码**里是稳定的，所以只要从 ROM 里认出 gTasks，其余 EWRAM
 * 地址都按「相对 gTasks 的偏移」跟着走。基准 0x02033D0C 是 gTasks 在本构建的
 * 地址，下面写死的 EWRAM 字面量也都是这一构建的值。 */
#define SIO_EW_BASE_GTASKS 0x02033D0Cu
static uint32_t sioEwramDelta;
static bool sioEwramDeltaDone;
struct SioLink;
static void sioResolveEwramDelta(struct SioLink* sio);
#define SIO_EW(a) ((uint32_t) (a) + sioEwramDelta)

/* 【直接从 ROM 解析代码段地址 2026-11-18】
 *
 * 用户要求「所有解析的源码都要加宏定义，保证 rom 更新了也能用」，且
 * 「只能从 rom 文件中解析，玩家没有 map」。代码段（0x08xxxxxx）此前是
 * 全仓库最大的裸地址缺口（ADDRESS-AUDIT #21/#22/#38-43）。
 *
 * 定位锚点：battle_main.o .text 段首 12 字节 Thumb 序言
 *     06 4B 1B 78 00 20 02 2B 06 D1 05 4A
 * 是布局无关的内容指纹。在仓库两份 ROM（md5 50380227… / cb988b5b…）上
 * 各出现恰好一次，文件偏移都是 0x0B30C0 ⇒ 运行地址 0x08000000 + 0x0B30C0
 * = 0x080B30C0，与两份 rom.map 的 .text 段首逐字节一致（离线验证，map
 * 只用于核对，运行时绝不读取）。
 * 相对几何（两份 map 实测，跨重编译恒定）：段首 +0x1784 = BattleMainCB2
 * （cb2 = 入口 +1 的 Thumb 位），段长 0x99B8。注：T-03/规范文本里的
 * 0x98B4 是 13:51 旧构建的值，对当前两份 ROM 均为 0x99B8。
 *
 * 由此得到 sioCodeDelta，所有写死的 0x08xxxxxx 基准都经 SIO_CODE() 加上
 * 它；战斗窗口/CB2 另有 SIO_BATTLE_LO/HI/CB2() 直接由签名段首 + 几何推导。
 * env 覆盖 MGBAX_GBOY_BATTLE_LO/HI 仍优先于扫描结果；扫描失败沿用下面的
 * 默认值并明确告警（绝不静默降级）。 */
#define SIO_CODE_BASE 0x080B30C0u            /* battle_main.o .text 段首（基准 ROM） */
#define SIO_BATTLE_SECTION_SIZE 0x99B8u       /* .text 段长（两份本地 map 实测） */
#define SIO_BATTLE_CB2_OFFSET 0x1784u         /* 段首 → BattleMainCB2；cb2=+1 */
static uint32_t sioCodeDelta = 0;
static bool sioCodeDeltaDone;
static void sioResolveCodeDelta(struct SioLink* sio);
#define SIO_CODE(a) ((uint32_t) (a) + sioCodeDelta)

/* 运行期解析结果；默认即基准 ROM 的 window/cb2，扫描失败时保持这组值。
 * 这三个默认值也是 ROM 相关的裸地址，故用具名宏收口（由签名扫描覆盖）。 */
#define SIO_BATTLE_LO_DFLT  0x080B30C0u
#define SIO_BATTLE_HI_DFLT  0x080BCA78u
#define SIO_BATTLE_CB2_DFLT 0x080B4845u
static uint32_t sioBattleLo = SIO_BATTLE_LO_DFLT;
static uint32_t sioBattleHi = SIO_BATTLE_HI_DFLT;
static uint32_t sioBattleCb2 = SIO_BATTLE_CB2_DFLT;
#define SIO_BATTLE_LO() (sioBattleLo)
#define SIO_BATTLE_HI() (sioBattleHi)
#define SIO_BATTLE_CB2() (sioBattleCb2)

/* 【MACROFIX 2026-11-18】补齐全仓库审计里漏掉的具名宏，与移动端
 * mgba_mobile.c 逐项对齐：此前下列地址以 SIO_EW()/SIO_IW() 包裹的裸字面量
 * 散落在判据/日志里，换 ROM 时无法一眼核对。沿用现有自解析 delta，不引入
 * 新机制；BATTLE_*_OFF 两端字面同名同值。 */
/* ROOTHUNT2 对手框重绘（与移动端 MOBILE_CB2_RESHOW/RESHOW_LO/HI 对称） */
#define SIO_CB2_RESHOW         0x081CBBEFu   /* ReshowBattleScreenAfterMenu (rom.elf 0x081cbbee+1) */
#define SIO_RESHOW_LO          0x081CBB00u
#define SIO_RESHOW_HI          0x081CC000u
#define SIO_MAIN_CB2           0x02029118u   /* gMain @0x02029114 的 callback2 槽 */
#define SIO_CB2_PTR            SIO_EW(SIO_MAIN_CB2)   /* 当前 callback2 函数指针 */
#define SIO_READY_CLOSE_LINK   0x03002AA6u   /* gReadyToCloseLink[]（关链握手位） */
#define SIO_RDY_CLOSE_LINK     SIO_IW(SIO_READY_CLOSE_LINK)   /* 与移动端对称，供诊断镜像 */
/* 战斗启动窗口相对 battle_main.o .text 段首的几何偏移（两端同值同格式）：
 * 段首+0x4D=CB2_InitBattle，段首+0x17E8=BattleMainCB2 末尾。 */
#define BATTLE_STARTUP_LO_OFF  0x4Du
/* 迭代 48 纠错：lo=0x080B30C0；lo+0xAD=CB2_InitBattleInternal，
 * CB2_HandleStartBattle=lo+0x6AD(080B376D) */
#define BATTLE_START_HANDLE_OFF 0x6ADu  /* CB2_HandleStartBattle */
#define BATTLE_CLOSE_INIT_END  0xADu   /* CB2_InitBattleInternal：关链发起段终点 */
#define BATTLE_MAIN_END_OFF    0x17E8u
/* 【MACROFIX2 2026-11-19 v2】EWRAM 战斗/队伍符号具名宏：与移动端
 * mgba_mobile.c 的 MOBILE_* 同名同值对称（审计存档 MACRO_AUDIT_backup.md）。
 * 此前下列地址以 SIO_EW(0x...) 裸字面量散落在判据/日志里，换 ROM 时无法
 * 一眼核对；此处仅收口字面量，仍沿用现有 SIO_EW() 自解析 delta，不引入新机制。
 * v2：基于 ROOTHUNT2 总闸提交(d6e8fd501)后源码重生成；已删除的 gBattleMons
 * 覆盖块不再产生 hunk。 */
#define SIO_BATTLE_MONS           0x0201CCC4u   /* gBattleMons[4] */
#define SIO_ENEMY_PARTY           0x0202A7CCu   /* gEnemyParty[6] */
#define SIO_ENEMY_PARTY_COUNT     0x0202A5EAu   /* gEnemyPartyCount */
#define SIO_PLAYER_PARTY          0x0202A5ECu   /* gPlayerParty[6] */

/* ===== S2 / MGBAX_NET_PARTY_MAILBOX：三端同名同值，默认关（零回归） ===== */
#ifndef MGBAX_NET_PARTY_MAILBOX
#define MGBAX_NET_PARTY_MAILBOX 0
#endif
#if MGBAX_NET_PARTY_MAILBOX != 0 && MGBAX_NET_PARTY_MAILBOX != 1
#error "MGBAX_NET_PARTY_MAILBOX must be 0 or 1"
#endif
#define MGBAX_NET_PARTY_MAILBOX_ENV  "MGBAX_NET_PARTY_MAILBOX"
#define MGBAX_NET_PARTY_MAILBOX_PROP "debug.mgbax.link.net_party_mailbox"
/* 非 static：由 sio_link.h 导出，供 CoreController::readNetPartyMailbox() 做第二道门。
 * 与 CloudLink.cpp 的 netPartyMailboxEnabled() 同值（编译期宏 != 0 || env==1）。 */
bool sioNetPartyMailboxOn(void) {
    const char* e = getenv(MGBAX_NET_PARTY_MAILBOX_ENV);
    return (MGBAX_NET_PARTY_MAILBOX != 0) || (e && atoi(e) == 1);
}

/* ===== NETGATE 拼行门（R10/R26）：三端同名同值，默认 0（零回归） =====
 * 仅日志开销；门关时不读 diag、不产任何 [NETGATE]/[NGPEEK] 行、链路零改动。 */
#ifndef MGBAX_NETGATE_LOG
#define MGBAX_NETGATE_LOG 0
#endif
#if MGBAX_NETGATE_LOG != 0 && MGBAX_NETGATE_LOG != 1
#error "MGBAX_NETGATE_LOG must be 0 or 1"
#endif
#define MGBAX_NETGATE_LOG_ENV "MGBAX_NETGATE_LOG"
static bool sioNetGateLogOn(void) {
    static int v = -1;
    if (v < 0) {
        const char* e = getenv(MGBAX_NETGATE_LOG_ENV);
        v = ((MGBAX_NETGATE_LOG != 0) || (e && atoi(e) == 1)) ? 1 : 0;
    }
    return v != 0;
}

/* ===== X10-OBSCHAIN：PC 侧只读观测链总门（方案乙，三端同名同值，默认关） =====
 * 只新增标签 [OBSCHAIN]，不改任何现有 TAG 字段序列 ⇒ diff_party_check TAG_RE 不认。
 * 门关（默认）时：不写任何游戏状态、不产生任何 [OBSCHAIN] 行、链路逻辑零改动；
 * 仅一次 getenv 缓存读 + 立即 return（与 b7Verbose/rhPatchesOff 同构）。 */
#ifndef MGBAX_OBS_CHAIN
#define MGBAX_OBS_CHAIN 0
#endif
#define MGBAX_OBS_CHAIN_ENV "MGBAX_OBS_CHAIN"
static bool obsChainOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv(MGBAX_OBS_CHAIN_ENV);
		v = ((MGBAX_OBS_CHAIN != 0) || (e && atoi(e) == 1)) ? 1 : 0;
	}
	return v != 0;
}

/* OBS-B'/OBS-C 用：gLink 结构内具名偏移（禁裸 hex，三端同名同值）。
 * 块 1 [BPRX] 行无条件引用下列三宏，ST/PROV/BPRX 三处节流引用 SIO_OBS_CHAIN_MAX_LINES，
 * 漏落即未定义符号。数值来自 gen8/include/link.h 与本文件 [diag] 的实测注释。 */
#define SIO_GLINK_ISMASTER_OFF      0x00u   /* gLink.isMaster */
#define SIO_GLINK_LOCALID_OFF       0x02u   /* gLink.localId */
#define SIO_GLINK_RECV_NOTHING_OFF  0x0Cu   /* gLink.receivedNothing */
#define SIO_OBS_CHAIN_MAX_LINES     200u    /* OBS-C/D/B' 各自独立的日志条数上限 */

/* gPlayerPartyCount 1B（gPlayerParty[6] 紧邻的 u8），与移动端同名同值；只读。 */
#define SIO_PLAYER_PARTY_COUNT  0x0202A5E9u

#define SIO_BATTLER_PARTY_INDEXES 0x0201CCACu   /* gBattlerPartyIndexes[4] */
#define SIO_BATTLE_TYPE_FLAGS     0x0201CC30u   /* gBattleTypeFlags */
#define SIO_BLOCK_RECV_BUFFER     0x020275B0u   /* gBlockRecvBuffer[4] */
/* ROOTHUNT2 只读诊断：cable_club var8004 / 远端玩家标志 / linkType */
#define SIO_SPECIAL_VAR_8004      0x0202199Cu   /* gSpecialVar_0x8004 (linkService) */
#define SIO_REMOTE_LINK_PLAYERS   0x03002B95u   /* gReceivedRemoteLinkPlayers (IWRAM, 经 SIO_IW) */
#define SIO_BATTLE_COMM           0x0201CFF4u   /* gBattleCommunication[MULTIUSE_STATE] (早定义供 BTLCFG 用) */
/* ROOTHUNT2 合规收口：错误屏 / 关链回调 code 段地址（link.o）。
 * 注意：移动端无统一 codeDelta（title/intro 与 battle 段各自独立平移），
 * 故此处为"具名宏收口"层，不做运行时解析，避免引入错误 delta 跳错函数。 */
#define SIO_CB2_LINK_ERROR        0x0816D8CDu   /* CB2_PrintErrorMessage (通信错误屏) */
#define SIO_CB2_LINK_ERROR_ALT    0x0816D669u   /* 错误屏备选 cb2 */
#define SIO_CB_READY_CLOSE        0x0816D439u   /* LinkCB_ReadyCloseLink */
#define SIO_CB_READY_CLOSE_ALT    0x0816D465u   /* LinkCB_WaitCloseLink */
/* ROOTHUNT2 T6 块交换诊断宏（canonical，经 SIO_IW/SIO_EW 运行时 delta） */
#define SIO_GLINK_CALLBACK        0x03002AD4u   /* gLinkCallback (u32, 实测 0x03002BA8) */
#define SIO_GLINK_STATUS          0x03002A9Cu   /* gLinkStatus (u32, 0x03002B70) */
#define SIO_GLINK_STATE           0x03002AF4u   /* gLink @ IWRAM base (canonical) */
#define SIO_LINK_TYPE_BATTLE      0x02027BB2u   /* gLinkType @ EWRAM (canonical) */
#define SIO_LINK_STAT_ERRORS      0x0007F000u   /* LINK_STAT_ERRORS (含 checksum/queueFull) */
/* ROOTHUNT2 方案 b 窄窗口门控值宏（禁裸字面量，三端对称） */
#define SIO_LINKTYPE_BATTLE       0x2211u   /* LINKTYPE_BATTLE 值（battle task case0 设） */
#define SIO_LINKTYPE_CLASS_MASK   0xFF00u   /* gLinkType 类别掩码（战斗类 0x22xx） */
#define SIO_LINKTYPE_CLASS_BATTLE 0x2200u   /* 战斗类 gLinkType 高字节 */
#define SIO_BATTLE_TYPE_LINK      0x0002u   /* BATTLE_TYPE_LINK 位 (1<<1) */
#define SIO_LINK_STATE_CONN       4u        /* LINK_STATE_CONN_ESTABLISHED */
#define SIO_LINK_STATE_HANDSHAKE  2u        /* LINK_STATE_HANDSHAKE（<2 = 链路重建/未起）；方案2 S7 块帧 reset 门，三端对称 */
#define SIO_GLINK_STATE_OFF       1u        /* gLink.state 在 gLink 结构内偏移 */
#define SIO_GLINK_PLAYERCOUNT_OFF 3u        /* gLink.playerCount 在 gLink 结构内偏移 */
#define SIO_LINK_PLAYERCOUNT_2P   2u        /* 2P 的 playerCount */
#define SIO_LINK_STAT_CONN_SHIFT  6u        /* LINK_STAT_CONN_ESTABLISHED 位移 */
#define SIO_PROBE_HEARTBEAT_MASK  0x3Fu     /* 打点心跳节流掩码 */
#define SIO_G_SPECIES_NAMES       0x0874158cu /* gSpeciesNames 连续文本表 [n][11] */
/* ROOTHUNT2 方案2+V1+V3 块字出网捕获宏（gLink 内 struct 偏移，三端对称，禁裸 hex）。
 * 数值来自 gen8/include/link.h 的具名常量，不是裸地址。 */
#define LINK_CMD_LENGTH             8u    /* CMD_LENGTH (link.h:6) */
#define LINK_QUEUE_CAPACITY        50u    /* QUEUE_CAPACITY (link.h:7) */
#define LINK_SENDQ_WORD_BYTES       2u    /* sizeof(u16) */
#define LINK_SENDQ_DATA_BYTES \
    (LINK_CMD_LENGTH * LINK_QUEUE_CAPACITY * LINK_SENDQ_WORD_BYTES) /* 0x320 */
#define SIO_GLINK_SENDCMD_IX_OFF  0x16u     /* gLink.sendCmdIndex (sc) */
#define SIO_GLINK_RECVCMD_IX_OFF  0x17u     /* gLink.recvCmdIndex (rc) —— 观测打点只读 */
#define SIO_GLINK_SENDQ_OFF       0x18u     /* gLink.sendQueue */
#define SIO_GLINK_SENDQ_DATA_STRIDE \
    (LINK_QUEUE_CAPACITY * LINK_SENDQ_WORD_BYTES) /* 100 */
#define SIO_GLINK_SENDQ_POS_OFF \
    (SIO_GLINK_SENDQ_OFF + LINK_SENDQ_DATA_BYTES) /* 0x338 */
#define SIO_GLINK_SENDQ_CNT_OFF \
    (SIO_GLINK_SENDQ_POS_OFF + 1u)                 /* 0x339 */
/* data[word][slot] 相对 gLink 的字节偏移（word=帧内字序号 0..7, slot=队列槽 0..49） */
#define SIO_GLINK_SENDQ_WORD_OFF(word, slot) \
    (SIO_GLINK_SENDQ_OFF \
     + (uint32_t) (word) * SIO_GLINK_SENDQ_DATA_STRIDE \
     + (uint32_t) (slot) * LINK_SENDQ_WORD_BYTES)
#define SIO_GLINK_SENDQ_WORD(cpu, word, slot) \
    GBAView16((cpu), SIO_IW(SIO_GLINK_STATE) \
              + SIO_GLINK_SENDQ_WORD_OFF((word), (slot)))
/* 队头 = pos；队尾 = (pos+count)%50（EnqueueSendCmd 写入点） */
#define SIO_SENDQ_SLOT_HEAD(pos)  ((uint32_t) (pos))
#define SIO_SENDQ_SLOT_TAIL(pos, cnt) \
    (((uint32_t) (pos) + (uint32_t) (cnt)) % LINK_QUEUE_CAPACITY)
/* ROOTHUNT2 TRISYNC 裸 hex 收口宏（三端对称，禁裸字面量） */
#define SIO_LINKTYPE_MULTI        0x2255u   /* LINKTYPE_MULTI (4P) */
#define SIO_LINK_STAT_QUEUE_FULL  0x00004000u /* LINK_STAT_ERROR_QUEUE_FULL */
#define SIO_GLINK_HWERR_OFF       0x10u     /* gLink.hardwareError 偏移 */
#define SIO_GLINK_BADCKSUM_OFF    0x11u     /* gLink.badChecksum 偏移 */
#define SIO_GLINK_QUEUEFULL_OFF   0x12u     /* gLink.queueFull 偏移 */
#define SIO_GLINK_LAG_OFF         0x13u     /* gLink.lag 偏移 */
#define SIO_GLOBAL_SEND_CMD       0x03002AB0u   /* gSendCmd[8] (0x03002B84) */
#define SIO_GLOBAL_BLOCK_SEND     0x03002984u   /* sBlockSend{pos,size,..} (0x03002A58) */
#define SIO_GLOBAL_BSEND_DELAY    0x030029C0u   /* sBlockSendDelayCounter (0x03002A94) */
#define SIO_GLOBAL_BLOCK_RECV     0x03002990u   /* sBlockRecv[4] (0x03002A64) */
#define SIO_GLOBAL_BLK_RECV_STATUS 0x03002A40u  /* gBlockReceivedStatus (brs) */
#define SIO_CB_BLOCK_SEND_BEGIN   0x0816CC95u   /* LinkCB_BlockSendBegin */
#define SIO_CB_BLOCK_SEND         0x0816CCB5u   /* LinkCB_BlockSend */
#define SIO_CB_BLOCK_SEND_END     0x0816CD0Du   /* LinkCB_BlockSendEnd */
#define SIO_GLOBAL_REMOTE_ID      0x03002AC1u   /* gReceivedRemoteLinkPlayers (rem) */
/* ROOTHUNT2 X44 §5 只读观测：gRemoteLinkPlayersNotReceived[4] (nr, per-player u8,
 * 初值 TRUE=未收齐；清 FALSE 唯一路径 HandleReceiveRemoteLinkPlayer(link.c:519)。
 * 经 SIO_IW 运行时 delta 解析，与 mobile MOBILE_REMOTE_PLAYERS_NOT_RECEIVED 同名同值。 */
#define SIO_REMOTE_PLAYERS_NOT_RECEIVED 0x03002A3Cu
#define SIO_LINK_OPEN             0x02027BB0u   /* gLinkOpen (EWRAM, 经 SIO_EW) */
/* 【ROOTHUNT2 P0/X40 方案C1】gLink.checksum 偏移具名宏，禁裸 hex。 */
#define SIO_GLINK_CHECKSUM_OFF    0x14u
#define SIO_GLINK_CHECKSUM        (SIO_GLINK_STATE + SIO_GLINK_CHECKSUM_OFF) /* 0x03002B08 */

/* 【直接从 ROM 解析 IWRAM 偏移 2026-11-18 00:2x】
 *
 * 换一次 ROM 构建，IWRAM 变量整体平移（实测旧 02:27 → 新 22:59 是 +0xC4），
 * 代码里 161 处写死的 IWRAM 地址就全废。用户要求**从 ROM 本身解析**，
 * 而不是依赖 `rom.map`（map 经常不跟着 ROM 一起分发）。
 *
 * 原理：Thumb 代码取全局地址都走常量池，所以 ROM 里散落着这些 IWRAM 绝对
 * 地址的 4 字节字面量。而 link.c 里几个数组的**相对偏移是源码层面固定的**：
 *     gSendCmd   - gRecvCmds = 0x66      (u16[4][8] = 0x40 加上中间的变量)
 *     gLink      - gRecvCmds = 0xAA
 * 所以在所有 IWRAM 字面量里找「R 与 R+0x66 同时出现」的 R，取两者引用次数
 * 较小值为分数，分数最高者即 gRecvCmds。
 * 离线在本仓库两份 ROM 上验证过：命中 R=0x03002B0E 得分 30，第二名仅 8，
 * 判别非常干净；当前构建推出的 delta 与逐符号核对结果一致（0xD4，
 * E2 日志 `SIOROM delta=0xD4`）。
 *
 * 兜底与覆盖：MGBAX_IWRAM_DELTA 直接指定则跳过扫描；扫描失败或结果离谱
 * （|delta| > 0x2000）则沿用默认 0xD4 并打印告警。
 * 查找顺序：MGBAX_ROM_PATH → rom.gba → D:/mgba-android-version/rom.gba
 * → 已加载核心的 gba->memory.rom（LOADED-ROM，部署路径任意时唯一可靠来源）。 */
static void sioResolveIwramDelta(struct SioLink* sio) {
	if (sioIwramDeltaDone) {
		return;
	}
	sioIwramDeltaDone = true;
	const char* forced = getenv("MGBAX_IWRAM_DELTA");
	if (forced && *forced) {
		sioIwramDelta = (uint32_t) strtoul(forced, NULL, 0);
		fprintf(stderr, "SIOROM delta forced = 0x%X\n", (unsigned) sioIwramDelta);
		return;
	}
	static const char* candidates[] = {
		"rom.gba",
		"D:/mgba-android-version/rom.gba",
	};
	const char* envRom = getenv("MGBAX_ROM_PATH");
	const char* chosen = NULL;
	FILE* fp = NULL;
	if (envRom && *envRom) {
		fp = fopen(envRom, "rb");
		chosen = fp ? envRom : NULL;
	}
	for (size_t i = 0; !fp && i < sizeof(candidates) / sizeof(candidates[0]); ++i) {
		fp = fopen(candidates[i], "rb");
		if (fp) {
			chosen = candidates[i];
		}
	}
	/* 文件不可读时回退到已加载核心的 ROM 镜像（玩家设备/任意部署路径） */
	const uint8_t* romMem = NULL;
	size_t romSize = 0;
	size_t memOff = 0;
	if (!fp) {
		romMem = sioLoadedRomBytes(sio, &romSize);
		if (romMem && romSize >= 0x1000u) {
			chosen = "LOADED-ROM";
		} else {
			romMem = NULL;
		}
	}
	if (!fp && !romMem) {
		fprintf(stderr, "SIOROM 打不到 ROM，沿用默认 delta=0x%X\n", (unsigned) sioIwramDelta);
		return;
	}
	/* IWRAM 只有 32 KiB，直接用地址索引的计数表 */
	static uint16_t cnt[0x8000];   /* 按 IWRAM 字节地址索引，避免 >>2 撞表 */
	memset(cnt, 0, sizeof(cnt));
	static uint8_t buf[1 << 20];
	size_t base = 0;
	size_t got;
	uint8_t carry[4];  /* 4 字节跨块重组；原为 [3] 却读 carry[3]，1 字节越界 */
	size_t carryN = 0;
	for (;;) {
		if (fp) {
			got = fread(buf, 1, sizeof(buf), fp);
		} else {
			size_t left = romSize - memOff;
			if (left == 0u) {
				got = 0;
			} else {
				if (left > sizeof(buf)) {
					left = sizeof(buf);
				}
				memcpy(buf, romMem + memOff, left);
				memOff += left;
				got = left;
			}
		}
		if (got == 0u) {
			break;
		}
		size_t i = 0;
		/* 处理跨块残留，保证 4 字节对齐 */
		if (carryN) {
			for (; carryN < 4 && i < got; ++i, ++carryN) {
				carry[carryN] = buf[i];
			}
			if (carryN == 4) {
				uint32_t v = (uint32_t) carry[0] | ((uint32_t) carry[1] << 8)
				             | ((uint32_t) carry[2] << 16) | ((uint32_t) carry[3] << 24);
				if (v >= GBA_IWRAM_BASE && v < GBA_IWRAM_SCAN_END) {
					uint16_t* c = &cnt[v - GBA_IWRAM_BASE];
					if (*c < 0xFFFFu) {
						++*c;
					}
				}
				carryN = 0;
			}
		}
		for (; i + 4 <= got; i += 4) {
			uint32_t v = (uint32_t) buf[i] | ((uint32_t) buf[i + 1] << 8)
			             | ((uint32_t) buf[i + 2] << 16) | ((uint32_t) buf[i + 3] << 24);
			/* 【注意】对齐的是**字面量在文件里的位置**，不是字面量的值：
			 * gRecvCmds=0x03002B0E 本身 &3==2。曾经用 (v&3)==0 过滤，
			 * 把正确答案整个筛掉，退到 0x030026BC ⇒ delta 离谱 ⇒
			 * 全线读错 ⇒「连接发生错误」。所以这里只判范围、按字节索引。 */
			if (v >= GBA_IWRAM_BASE && v < GBA_IWRAM_SCAN_END) {
				uint16_t* c = &cnt[v - GBA_IWRAM_BASE];
				if (*c < 0xFFFFu) {
					++*c;
				}
			}
		}
		for (; i < got; ++i, ++carryN) {
			carry[carryN] = buf[i];
		}
		base += got;
	}
	if (fp) {
		fclose(fp);
	}
	(void) base;
	/* 找「R 与 R+0x66 同时是字面量」的最佳 R */
	uint32_t bestR = 0;
	uint32_t bestScore = 0;
	for (uint32_t idx = 0; idx < 0x8000u; ++idx) {
		uint32_t c1 = cnt[idx];
		if (c1 < 2u) {
			continue;
		}
		uint32_t r = GBA_IWRAM_BASE + idx;
		if (r + 0x66u >= GBA_IWRAM_END) {
			continue;
		}
		uint32_t c2 = cnt[(r + 0x66u) - GBA_IWRAM_BASE];
		uint32_t score = (c1 < c2) ? c1 : c2;
		if (score > bestScore) {
			bestScore = score;
			bestR = r;
		}
	}
	if (bestR == 0u || bestScore < 4u) {
		fprintf(stderr, "SIOROM 没找到 gRecvCmds/gSendCmd 组合（best=0x%08X score=%u），"
		        "沿用默认 delta=0x%X\n", (unsigned) bestR, (unsigned) bestScore,
		        (unsigned) sioIwramDelta);
		return;
	}
	uint32_t gLinkGuess = bestR + 0xAAu;
	uint32_t delta = gLinkGuess - SIO_IW_BASE_GLINK;
	/* 合理性：整体平移不该离基准太远 */
	if (delta > 0x2000u && delta < 0xFFFFE000u) {
		fprintf(stderr, "SIOROM 结果离谱 gLink=0x%08X delta=0x%X，沿用默认 0x%X\n",
		        (unsigned) gLinkGuess, (unsigned) delta, (unsigned) sioIwramDelta);
		return;
	}
	sioIwramDelta = delta;
	fprintf(stderr, "SIOROM %s gRecvCmds=0x%08X(score %u) gLink=0x%08X delta=0x%X\n",
	        chosen, (unsigned) bestR, (unsigned) bestScore,
	        (unsigned) gLinkGuess, (unsigned) delta);
}

/* 从 ROM 字节定位 battle_main.o 段首，推导代码段 delta 与战斗窗口。
 * 与 IWRAM/EWRAM 扫描器共用同一套 ROM 查找顺序与兜底纪律：
 *   MGBAX_ROM_PATH → rom.gba → D:/mgba-android-version/rom.gba
 * 环境覆盖 MGBAX_GBOY_BATTLE_LO/HI 在最后施加，因此始终胜过扫描结果。 */
static void sioResolveCodeDelta(struct SioLink* sio) {
	if (sioCodeDeltaDone) {
		return;
	}
	sioCodeDeltaDone = true;

	const char* envLo = getenv("MGBAX_GBOY_BATTLE_LO");
	const char* envHi = getenv("MGBAX_GBOY_BATTLE_HI");
	const bool haveLo = envLo && *envLo;
	const bool haveHi = envHi && *envHi;

	static const unsigned char prologue[12] = {
		0x06, 0x4B, 0x1B, 0x78, 0x00, 0x20, 0x02, 0x2B, 0x06, 0xD1, 0x05, 0x4A
	};
	static uint8_t buf[(1 << 20) + 11];
	size_t carry = 0;       /* 跨块保留的末尾字节数（保证 12 字节指纹不断裂） */
	size_t consumed = 0;    /* buf[0] 对应的文件偏移 */
	bool found = false;
	uint32_t sigOff = 0;

	const char* envRom = getenv("MGBAX_ROM_PATH");
	FILE* fp = NULL;
	const char* chosen = NULL;
	if (envRom && *envRom) {
		fp = fopen(envRom, "rb");
		chosen = fp ? envRom : NULL;
	}
	static const char* candidates[] = {
		"rom.gba",
		"D:/mgba-android-version/rom.gba",
	};
	for (size_t i = 0; !fp && i < sizeof(candidates) / sizeof(candidates[0]); ++i) {
		fp = fopen(candidates[i], "rb");
		if (fp) {
			chosen = candidates[i];
		}
	}

	/* 文件不可读时回退到已加载核心的 ROM 镜像 */
	const uint8_t* romMem = NULL;
	size_t romSize = 0;
	size_t memOff = 0;
	if (!fp) {
		romMem = sioLoadedRomBytes(sio, &romSize);
		if (romMem && romSize >= 0x1000u) {
			chosen = "LOADED-ROM";
		} else {
			romMem = NULL;
		}
	}

	if (fp || romMem) {
		while (!found) {
			size_t got = 0;
			if (fp) {
				got = fread(buf + carry, 1, (1 << 20), fp);
			} else {
				size_t left = romSize - memOff;
				if (left > (1 << 20)) {
					left = (1 << 20);
				}
				if (left) {
					memcpy(buf + carry, romMem + memOff, left);
					memOff += left;
					got = left;
				}
			}
			if (got == 0) {
				break;
			}
			const size_t total = carry + got;
			for (size_t i = 0; i + 12 <= total; ++i) {
				if (memcmp(buf + i, prologue, sizeof(prologue)) == 0) {
					found = true;
					sigOff = (uint32_t) (consumed + i);
					break;
				}
			}
			if (found) {
				break;
			}
			carry = total > 11 ? 11 : total;
			if (carry) {
				memmove(buf, buf + total - carry, carry);
			}
			consumed += total - carry;
		}
		if (fp) {
			fclose(fp);
		}
	}

	if (found && sigOff < 0x01F00000u) {
		const uint32_t sectionStart = GBA_ROM_BASE + sigOff;
		const int32_t delta = (int32_t) (sectionStart - SIO_CODE_BASE);
		if (delta > 0x200000 || delta < -0x200000) {
			fprintf(stderr, "SIOROM code 签名结果离谱 section=0x%08X delta=0x%X，"
			        "沿用默认 battle=[0x%08X,0x%08X)\n", (unsigned) sectionStart,
			        (unsigned) delta, (unsigned) sioBattleLo, (unsigned) sioBattleHi);
		} else {
			sioCodeDelta = (uint32_t) delta;
			sioBattleLo = sectionStart;
			sioBattleHi = sectionStart + SIO_BATTLE_SECTION_SIZE;
			sioBattleCb2 = sectionStart + SIO_BATTLE_CB2_OFFSET + 1u;
		}
	} else {
		fprintf(stderr, "SIOROM code %s：未找到 battle_main.o 段首序言 "
		        "(06 4B 1B 78 00 20 02 2B 06 D1 05 4A)，沿用默认 "
		        "battle=[0x%08X,0x%08X) cb2=0x%08X delta=0\n",
		        chosen ? chosen : "无 ROM", (unsigned) sioBattleLo,
		        (unsigned) sioBattleHi, (unsigned) sioBattleCb2);
	}

	/* env 覆盖最后施加，永远胜过 ROM 扫描（需求：override 必须生效） */
	/* 【ROOTHUNT】必须用 base 16：驱动传的是不带 0x 的 "080B30C0"，
	 * base 0 会当八进制解析 → 在 '8' 处停住 → 返回 0 → battle=[0,0)。 */
	if (haveLo) {
		sioBattleLo = (uint32_t) strtoul(envLo, NULL, 16);
	}
	if (haveHi) {
		sioBattleHi = (uint32_t) strtoul(envHi, NULL, 16);
	}

	fprintf(stderr, "SIOROM code battle=[0x%08X,0x%08X) cb2=0x%08X delta=0x%X "
	        "source=%s%s\n", (unsigned) sioBattleLo, (unsigned) sioBattleHi,
	        (unsigned) sioBattleCb2, (unsigned) sioCodeDelta,
	        found ? "ROM-SIGNATURE" : "DEFAULT", (haveLo || haveHi) ? "+ENV-OVERRIDE" : "");
	if (chosen) {
		fprintf(stderr, "SIOROM code rom=%s sigOff=0x%X\n", chosen, (unsigned) sigOff);
	}
}

#include <mgba/core/core.h>
#include <mgba/core/serialize.h>
#include <mgba-util/vfs.h>
#include <mgba/gba/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/sio.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba-util/common.h>

#include <stdarg.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <time.h>

#include "platform/mobile/link_net.h"
/* RACE_STRESS 压测门：PC no-op reader 从 mgba_mobile.h 取 MGBAX_RACE_STRESS_ENV，
 * 保证三端门名同值；真造窗在 mgba_mobile.c，PC 无此竞态且不注入延时。 */
#include "platform/mobile/mgba_mobile.h"

/* S2 PC 写口：GNP 500B/CRC16 ABI 镜像 + manifest 绝对地址具名宏。
 * 两头已在 src/platform/gboy/ 落盘；include 根为 src/，故带 platform/gboy/ 前缀。
 * 均为宏/typedef/static 助手，无新增链接符号；门默认关时相关 static 函数不被调用。 */
/* manifest 必须先于 abi.h：abi.h 的 party provenance 用 GNP_*_PARTY_* 具名宏。 */
#include "platform/gboy/gnp_manifest.h"
#include "platform/gboy/gboy_netparty_abi.h"

/* ===== 档1 A 预测回滚：影子槽类型定义见共享头 gboy_netparty_abi.h（三端同名同值）===== */
#define MGBAX_PRED_IDX_MASK (MGBAX_PREDICT_HISTORY - 1u)

#ifdef _WIN32
#include <winsock2.h>
#endif

/**
 * 桌面版是 GUI 子系统程序，mGBA 的日志走 Qt 日志窗口、stderr 抓不到，
 * 实机排查联机时序时需要能落到文件：MGBAX_SIO_LOG=1 时同一条轨迹追加到
 * %TEMP%/mgba_sio.log（每次打开-关闭，避免崩溃丢尾）。
 */
/* 曾经每条日志都 fopen/fclose：主机每帧上千次传输、每次都要写一条，
 * Windows 上配上杀软实时扫描直接把帧率压到 0.7fps，反过来饿死从机。
 * 现在只开一次、攒够一批再 flush；崩溃最多丢 32 行，换回满帧。 */
static void sioLogFile(const char* fmt, ...) {
	static int enabled = -1;
	static FILE* f = NULL;
	static int pending = 0;
	if (enabled < 0) {
		enabled = getenv("MGBAX_SIO_LOG") ? 1 : 0;
	}
	if (!enabled) {
		return;
	}
	if (!f) {
		const char* tmp = getenv("TEMP");
		if (!tmp) {
			tmp = getenv("TMP");
		}
		if (!tmp) {
			tmp = ".";
		}
		char path[512];
		snprintf(path, sizeof(path), "%s%cmgba_sio.log", tmp, '/');
		f = fopen(path, "a");
		if (!f) {
			enabled = 0;
			return;
		}
	}
	va_list args;
	va_start(args, fmt);
	vfprintf(f, fmt, args);
	va_end(args);
	fputc('\n', f);
	if (++pending >= 32) {
		fflush(f);
		pending = 0;
	}
}

#define SIO_LOG(...) do { mLOG(GBA_SIO, INFO, __VA_ARGS__); sioLogFile(__VA_ARGS__); } while (0)

/* ===== NETGATE 拼行钩子（PC 对偶，R10/R26）：只读 EWRAM diag，仅 CLOSED 产规范行 =====
 * 与移动端 mobileNetGatePeek 对称；tag_ok 逐字读真值禁写 1；role=PC/sender=APP；
 * rom_md5 由 driver 实测 ROM 字节渲染（非样例）；缺字段/越界 fail-closed。 */
static uint32_t s_ngLastSeq = 0;
static unsigned s_ngLines = 0;
static uint32_t s_ngPeekSig = 0xFFFFFFFFu;
static unsigned s_ngPeekLines = 0;

static void sioNetGatePeek(struct GBA* gba, const uint8_t* rom, size_t romSize) {
    uint8_t diag[GNP_NG_DIAG_SIZE];
    char line[768];   /* 追加 party_md5/rx/tx 三字段后留足余量，防 snprintf 截断 */
    char romMd5[33];
    uint32_t addr = (uint32_t) GNP_DIAG_EW;
    uint32_t sig, seq;
    unsigned i;

    if (!sioNetGateLogOn()) { return; }
    if (!gba || !gba->cpu || !rom || !romSize) { return; }
    if (!gnpAbsEwOk(addr, GNP_NG_DIAG_SIZE)) { return; }
    for (i = 0u; i < GNP_NG_DIAG_SIZE; ++i) {
        diag[i] = (uint8_t) GBAView8(gba->cpu, addr + i);
    }
    seq = gnpNgRead32(diag + GNP_OFF_NG_SEQ);

    sig = ((uint32_t) diag[GNP_OFF_NG_STATE] << 24) |
          ((uint32_t) diag[GNP_OFF_NG_TAG_OK] << 16) |
          ((uint32_t) diag[GNP_OFF_NG_MSG_TYPE] << 8) |
          (uint32_t) diag[GNP_OFF_NG_COUNT];
    if (diag[GNP_OFF_NG_STATE] != GNP_NG_STATE_CLOSED &&
        sig != s_ngPeekSig && s_ngPeekLines < GNP_NG_MAX_LINES) {
        s_ngPeekSig = sig;
        ++s_ngPeekLines;
        SIO_LOG("[NGPEEK] st=%u tag_ok=%u msg=%u cnt=%u seq=%u",
                (unsigned) diag[GNP_OFF_NG_STATE],
                (unsigned) diag[GNP_OFF_NG_TAG_OK],
                (unsigned) diag[GNP_OFF_NG_MSG_TYPE],
                (unsigned) diag[GNP_OFF_NG_COUNT], (unsigned) seq);
    }

    if (diag[GNP_OFF_NG_STATE] != GNP_NG_STATE_CLOSED) { return; }
    if (diag[GNP_OFF_NG_MSG_TYPE] != GNP_NG_MSG_PARTY) { return; }
    if (!gnpNgSrcTagValid((const char*) (diag + GNP_OFF_NG_SRC_TAG), GNP_NG_SRC_TAG_MAX)) { return; }
    if (seq == 0u || seq <= s_ngLastSeq) { return; }
    if (s_ngLines >= GNP_NG_MAX_LINES) { return; }
    s_ngLastSeq = seq;
    ++s_ngLines;

    gnpNgRomMd5Hex(rom, romSize, romMd5);
    /* party provenance：产 CONFIRMED [NETGATE] 行时逐字节只读 ROM 真 party 区，
     * 落纯 party 480B 快照 + 三字段（具名宏地址；非预测字、零写游戏态）。 */
    if (gba && gba->cpu
        && gnpAbsEwOk(GNP_ENEMY_PARTY_EW, GNP_PARTY_BLOB_BYTES)
        && gnpAbsEwOk(GNP_PLAYER_PARTY_EW, GNP_PARTY_BLOB_BYTES)) {
        uint8_t rbRx[GNP_PARTY_BLOB_BYTES], rbTx[GNP_PARTY_BLOB_BYTES];
        unsigned rbj;
        for (rbj = 0u; rbj < GNP_PARTY_BLOB_BYTES; ++rbj) {
            rbRx[rbj] = (uint8_t) GBAView8(gba->cpu, GNP_ENEMY_PARTY_EW + rbj);
            rbTx[rbj] = (uint8_t) GBAView8(gba->cpu, GNP_PLAYER_PARTY_EW + rbj);
        }
        gnpNgPartyProvenance(1, rbRx, rbTx);   /* role=PC */
    }
    gnpNgRender(line, sizeof(line), diag, "PC", "APP", romMd5,
                gnpNgPartyMd5(1), gnpNgRxPartyMd5(1), gnpNgTxPartyMd5(1));
    SIO_LOG("%s", line);
}

/* ROOTHUNT 诊断日志门（定义见下方；纯日志开关，无行为影响）。 */
static bool rhVerbose(void);
static bool rhPatchesOff(void);   /* ROOTHUNT2 零注入总闸，定义见下方 */

static void applyLinkTerminalBits(struct SioLink* sio);
static void serviceLink(struct SioLink* sio);
static int gbaLinkDevices(struct GBASIODriver* driver);

struct GbaLinkDriver {
	struct GBASIODriver d;
	struct SioLink* sio;
};

struct SioLink {
	struct NetLink* link;
	struct mCore* core;
	struct GbaLinkDriver gbaLink;
	bool linkAttached;

	/* One MULTI transfer in flight: push this round's word at start, fetch
	 * the peer's reply when the transfer should be over - never blocking the
	 * emulation thread mid-frame. */
	struct mTimingEvent sioDone;
	/* Slave-side "round complete" event: pins the slave's emulated clock to
	 * the host's cadence (see sioSlaveDoneEvent below). */
	struct mTimingEvent sioSlaveDone;
	struct mTimingEvent linkEvent;
	bool sioSlaveArmed;
	uint32_t sioSlavePeriod;
	uint32_t sioPeerCycles;
	bool sioPeerCyclesValid;
	bool sioWaiting;
	int sioRetries;
	uint32_t sioRetryWall;
	bool sioHasRemote;
	uint32_t sioRemote;
	uint32_t sioOk;
	uint32_t sioTimeouts;
	uint32_t sioFallback;
	uint32_t sioStartCycle;
	uint32_t sioPeak;
	uint32_t sioLateness;
	/* 每轮在 takePeerWord 上阻塞了多久（墙钟 ms）。联机帧率的唯一大头就是
	 * 它 —— 一帧 9 轮，每轮阻塞多少就乘以 9。有这组数才能判断到底是对端
	 * 模拟太慢、还是网络太远，而不是凭感觉调参数。 */
	uint32_t sioWaitSumMs;
	uint32_t sioWaitMaxMs;
	uint32_t sioWaitN;
	/* 握手期非阻塞轮询（MGBAX_SIO_CONNECT_POLL，**默认关**）：
	 * 11-16 00:52 现场：默认开时两端能连上（lstate=4 pc=2）、但随即被拆成
	 * 「对不起，连接发生了错误…请重启之后再试。」，且 lstate 在 1/4 之间
	 * 振荡。该改动从未跑到过 A/B 对照（样本被批量 taskkill 截断），
	 * 无法排除是它改变了握手期 SIO 时序导致块交换失败 —— 未验证的改动
	 * 不能留在默认路径上，故改为必须显式 *:
	 * 严格路径取不到对端字时不再一次阻塞满等待窗，而是重新调度 sioDone
	 * 让出模拟时间；一轮累计轮询超过 SIO_CONNECT_BUDGET_MS 墙钟预算才退回
	 * 原来的阻塞等待。计数只为事后核对，不参与任何判定。 */
	uint32_t sioConnectPolls;      /* 轮询让出（重新调度）次数 */
	uint32_t sioConnectHits;       /* 轮询一次就取到本轮字的次数 */
	uint32_t sioConnectFallback;   /* 预算耗尽、退回阻塞等待的次数 */
	uint32_t sioConnectSince;      /* 本轮开始轮询的墙钟时刻，0=未开始 */
	uint16_t sioIndex;
	bool sioInitSeen;
	bool sioStashValid;
	uint32_t sioStash;
	/* 从机本轮要回推的字：在游戏写 SIOCNT 起轮的**那一刻**扣下来。
	 * 若等到本轮完成（收完主机字）再去读 SIOMLT_SEND，游戏很可能已经把
	 * 下一轮的字写进去了 —— 一个 16bit 的错位就足以让 gLink 的字节流
	 * 命令队列（SendBlockRequest / 块校验）整体偏移，表现为链路连着、
	 * 但 gBlockReceivedStatus 永远是 0、对战起不来。 */
	uint16_t sioRoundWord;
	bool sioRoundWordValid;
	/* ROOTHUNT2 方案2：从 sendQueue.data[0..7][pos] 读出的完整真块命令帧
	 *（8 字：命令+7 数据字）。每帧推 1 字，8 帧推完一帧（与 mobile 对称，非伪造）。 */
	uint16_t sioBlockFrame[8];
	uint8_t sioBlockFrameIdx;
	bool sioBlockFrameValid;
	/* ROOTHUNT2 V1 相位锁：起轮捕获的 gLink.sendCmdIndex（0..8，只读不写索引）。
	 * 自槽与 push 必须用同一个 sc 取同一个块字，否则两端 checksum 累加不一致。 */
	uint8_t sioBlockPhase;
	/* 对端**最近一次发来的** normal 模式数据（GBA 的 normal 模式是半双工
	 * 数据交换：本端自己那次传输读到的「对端值」就是对端上一次发来的字）。
	 * 2026-11-16 现场（PA11）：两端都在做 NORMAL_32 传输，但
	 * `remote` 恒为 0x00000000 —— 因为 netLinkExchange 是「请求-应答」语义，
	 * link_net 收到 REQ 时自动 ACK 的是**对端自己 published 的值**（对端还没
	 * 发过就是 0），而 GBA 的 normal 模式根本不是请求-应答：应答数据是
	 * 对端**上一次传输**发来的那个字。⇒ 训练家卡片/命令字因此永远收不对
	 * ⇒ 握手后段（cmd 交换 + 卡片块传输）全部对不上 ⇒ 链路收不了尾。 */
	uint32_t sioPeerLastValue;
	bool sioPeerLastValid;
	/* 本端**最近一次推给对端的有效字**（非 0）。用途：游戏还没往 SIOMLT_SEND
	 * 写新字时（EnableSerial() 会把它清 0，gen8/src/link.c:1936），不要把
	 * 0xFFFF 当空槽推出去 —— 对端 `DoHandshake()` 数槽位时
	 * (link.c:2271) 遇到 0xFFFF 就 break，`gLink.playerCount` 从 2 掉到 1，
	 * 游戏的 `GetLinkPlayerDataExchangeStatusTimed()` 随即判
	 * `numPlayers < minPlayers` ⇒ LINKUP_WRONG_NUM_PLAYERS ⇒
	 * SetCloseLinkCallback() ⇒ 链路被拆（现场 PA10：主机侧
	 * `data=B9A0,FFFF,FFFF,FFFF pc=1`）。⇒ 改成沿用上一个有效字。 */
	uint16_t sioLastOwn;
	/* 【本轮自身槽】起轮那一刻扣下来的 SIOMLT_SEND，只给 completeMultiTransfer
	 * 填本机槽用，任何推送路径都不消费它。
	 * 为什么需要：本机槽原先读的是**收尾时刻**的 SIOMLT_SEND，而推给对端的是
	 * **起轮时刻**的字。手游数据在收尾前就把 SIOMLT_SEND 改成了下一轮的字，
	 * 于是主机自己槽读到 B9A0、对端却收到 8FFF —— DoHandshake 要求槽0 是
	 * 0x8FFF（/d/gen8/src/link.c:2276-2281），主机永远判不过，从机反而进了 4。
	 * E1 实测：B 侧 st=0x349 出现 2 帧、A 侧 401 个样本里 0 次。 */
	uint16_t sioSelfSlot;
	/* BF1: 主机握手字回环。握手期本端真写 8FFF 时扣下，作为 data[0](本机 recv[0])
	 * 的最后写入者——模拟真电缆 MULTI 主机自发字回环进 SIOMULTI0。
	 * 只搬运真字(游戏真写的 8FFF)，非造字；门默认关。 */
	uint16_t sioMasterEchoWord;
	uint32_t sioPushValue;
	uint16_t sioPushIndex;
	bool sioPushed;
	uint32_t sioMisorder;
	uint32_t sioBusyCycle;
	/* 被抹掉的 gLink.lag 次数（见 sioClearClockLag）：公网抖动下每帧缺一次
	 * 传送是常态，这个计数就是「本帧速率没跑满 9 次」的量化证据。 */
	uint32_t sioLagCleared;
	/* 【握手保持 2026-11-16 21:4x】自己已经进入 CONN_ESTABLISHED(4) 之后，
	 * 只要对端最近一次真实发来的字**仍是握手字**（0x8FFF/0xB9A0），就继续
	 * 推自己的握手字而不是命令字。
	 *
	 * 不这么做的话，先到 state4 的一端会立刻改发命令字（空队列时是 0x0000），
	 * 而另一端 DoHandshake 的收尾判据要求 `tempRecvBuffer[0]==MASTER_HANDSHAKE`
	 * 且 playerCount 连续两轮稳定 —— 它永远看不到握手字 ⇒ pc 卡 0 ⇒ 一直停在
	 * state2。实测 A 端就这样在 state2 转了约 7000 轮，超过 cable club 的
	 * TryLinkTimeout 600 帧预算 ⇒ LINKUP_CONNECTION_ERROR(6) ⇒ 脚本
	 * `special CloseLink` ⇒ 用户看到「卡在请稍候 / 通信错误」。
	 *
	 * sioHsHoldLeft 是**有界安全阀**：只在「对端真字仍是握手字」期间由
	 * completeMultiTransfer 重新装满（Z13 修正：旧的一次性装填会在长 st4
	 * 空转后耗尽，导致主机真重握时 B9A0 断供）；对端字一变非握手字即逐轮
	 * 衰减，且只从机保持 ⇒ 两端不会互相保持成新死锁，必然收敛。 */
	uint16_t sioHsHoldLeft;
	bool sioHsHoldArmed;
	/* 【ROOTHUNT】上次对齐过的帧首 opcode；换 opcode(2222→BBBB)时允许重新
	 * 对齐一次，解决块交换阶段相位漂移导致 0xBBBB/0x8888 落错 recvQueue 槽。 */
	uint16_t sioLastAlignHeader;
	/* 【CMD-FRAMEALIGN】本会话是否已就着对端帧首命令字(0x2222/0xBBBB)对齐过
	 * 一次 sendCmdIndex/recvCmdIndex。一次性；state<2 或新会话时复位。 */
	bool sioCmdFrameAligned;
	/* 【ROOTHUNT CMD-HANDOFF（已撤回跨会话标志）】曾经尝试用「见过对端
	 * 2222/BBBB 就永久关闭 B9A0 回显」，但 RH-FIX2 实测：主机可能短暂进
	 * state4 发一次 2222 后**又退回 state2 重握**，从机侧 lstate 却一直是 4
	 * ⇒ 标志不复位 ⇒ 从机再也不回显 B9A0 ⇒ 主机永远握不上。真正的根因是
	 * 主机在 state4 残留握手字（APPHUNT-A2 XFER#15 own=B9A0）重arm 了从机
	 * 保持；只在主机侧 suppress 即可，从机保持逻辑原样保留。 */
	/* 用「帧首锚点」校正过多少次相位（见 sioAlignCmdPhase，只作日志序号）。 */
	uint32_t sioPhaseAligned;
	/* 帧相位闸门是否已经放行（见 sioPhaseGate）。放行后不再干涉状态机，
	 * 直到链路重建（gLink.state < 2）才复位。 */
	bool sioPhaseGateOpen;
	/* 硬相位锁（见 sioHardCmdPhase）的统计与闸门状态。 */
	uint32_t sioHardRounds;
	uint32_t sioHardFix;
	bool sioHardArmed;      /* 已在一个「自然帧边界」上武装 */
	bool sioHardAligned;    /* 已经落到 label%9==0 的公共帧边界上 */
	uint16_t sioHardTarget; /* 武装后要等的那个 9 的倍数 label */
	/* 【对端字流平移线 2026-11-16 23:5x】见 sioPeerShifted 的注释。
	 * 只动「投递给游戏的 16 位字」，一个索引都不碰。 */
	uint16_t sioPeerHist[9];
	uint32_t sioPeerHistN;
	/* SYNCIDX：按对端随行索引纠偏的次数（见 sioFollowSyncIdx）。 */
	uint32_t sioSyncFix;
	/* ESTGATE：本端是否已经由我们主动推进到 CONN_ESTABLISHED。 */
	bool sioEstDone;
	/* 【帧率探针】每轮在「等对端字」上阻塞的墙钟毫秒累计。阻塞期间模拟时钟
	 * 是冻结的（mTimingSchedule 走不动），所以这部分时间直接换算成掉帧：
	 * 60fps 时每帧 16.7ms，若一轮平均阻塞 X ms，9 轮/帧就吃掉 9X ms。
	 * 见 sioPerfLog。 */
	uint32_t sioPerfRounds;
	uint32_t sioPerfBlockedMs;
	uint32_t sioPerfMaxMs;
	uint32_t sioPerfLastLog;
	/* COAST：消费滞后 N 轮的流水线（见 sioCoastBranch）。
	 * 存在的理由见 sioDoneEvent 里那段注释：每轮「等对端本轮字」是物理依赖
	 *（从机要先收到主机本轮字才回推），L≈4.5ms 时每轮等 2L−T≈8ms，
	 * 9 轮/帧 ⇒ 每帧 41.8ms ⇒ 24fps。
	 * 做法：本端 peerQ 深度 < N 时**这一轮不消费**，用上一轮的对端字补槽，
	 * 但轮次照常完成（completeMultiTransfer 照常调一次）⇒ 每帧仍是 9 轮、
	 * 模拟时间不膨胀、帧率回到 60；代价是输入延迟增加 N 轮（本地 ~8 轮 ≈ 2ms）。 */
	uint32_t sioCoastN;
	bool sioCoastInited;
	uint32_t sioCoastRounds;
	/* ROUNDSPF：每帧实际跑了几轮 SIO 的分布（只读探针，见 sioRoundsPerFrame）。
	 * 游戏只允许 9 轮/帧；超了 `recvQueue` 只进不出 ⇒ DoRecv 里
	 * `count == QUEUE_CAPACITY-1` 触发 ResetRecvQueue + queueFull
	 * ⇒ CheckErrorStatus 拆链（st 的 0x4000 = ERROR_QUEUE_FULL，
	 * FR13 实证 st=0x4949）。 */
	uint32_t sioRpfFrame;
	uint32_t sioRpfCount;
	uint32_t sioRpfMax;
	uint32_t sioRpfSum;
	uint32_t sioRpfFrames;
	uint32_t sioRpfOver;
	/* IDXDELIVER：按帧索引投递（见 sioIdxDeliver）。
	 * 接收端不再「按到达顺序落格」，而是按对端随行的 idxW 存进 9 格缓冲、
	 * 按本端自然 recvCmdIndex 取 ⇒ 传输层丢一拍/重一拍都不再导致错格。 */
	uint16_t sioIdxBuf[9];
	uint16_t sioIdxMask;      /* bit i = sioIdxBuf[i] 有效 */
	uint32_t sioIdxHit, sioIdxMiss;
	/* BLKREQ：块请求（0xCCCC）受控重发计数（见 sioBlkReqRetry）。 */
	uint32_t sioBlkReqTick;
	uint32_t sioBlkReqSent;
	uint32_t sioStandbyTick;
	uint32_t sioStandbySent;
	/* TASKPROBE：gTasks 里 cable_club 任务的快照文本 */
	char sioTaskBuf[96];
	/* REARM：一次性回调的重发（见 sioCallbackRearm）。 */
	uint32_t sioRearmTick;
	uint32_t sioRearmSent;
	uint32_t sioLastCb;
	/* 已消费过的最大对端 label。LABEL_ANY 放宽之后必须靠它做去重：
	 * 传输层重试/超时补拍会把**同一轮的字推两次**，而"取任意近端字"会让
	 * 第二份也被消费 ⇒ 同一格存两遍 ⇒ 整帧右移一格（TR49 的
	 * `0000,8888,...` 与 `BBBB,0064,0081,0081`）。 */
	uint16_t sioLastPeerLabel;
	bool sioPeerLabelOk;
	/* CMDTRACE：对端命令帧变化追踪（见 sioCmdTrace）。gRecvCmds 每帧被新帧
	 * 覆盖，一次性命令（0x2222/0xBBBB/0xCCCC）只存在一帧，900 拍采一次样
	 * 的 LINKSTAT 抓不到，必须逐帧比对。 */
	uint16_t sioCmdCache[8];
	uint32_t sioCmdLog;
	/* CHAINWD：主机九拍链看门狗（见 sioChainWatchdog）。 */
	uint16_t sioChainLabel;
	uint32_t sioChainStall;
	uint32_t sioChainKick;
	/* 本轮是不是「主机起的那一轮」（beginMultiTransfer 置位，收尾时打日志）。
	 * 排查 brs 恒 0 用：如果 SIO multi 行长期 mst=0，说明本端从没起过主机轮，
	 * 问题在角色/起轮判据，不在推送链路。 */
	bool sioRoundMaster;
	/* 本轮在**主机轮次号空间**里的编号（主机=自己推出去的 label，从机=取到的
	 * got）。gen8 的 sendCmdIndex/recvCmdIndex 是自由跑的 9 拍循环，两端各自
	 * 从自己的 state4 起点开始数 ⇒ 一旦两端进入 CONN_ESTABLISHED 的轮次不同，
	 * 8 字命令窗口就永久错位（TR15：A 的 2222 落在 B 的槽 0，B 自己的块命令
	 * 落在 A 的槽 1），块交换因此永远不成立。用共享轮次号推导相位可以两端
	 * **逐轮**对齐，见 sioForceCmdPhase。 */
	uint16_t sioRoundLabel;
	/* 「slave miss」的空转速率：只统计不改变行为。
	 * 每秒一条 miss-rate，用来分辨「每 0.12ms 模拟时间空转一次」的假死
	 * （安卓侧有熄火保护，Qt 侧还没有，先把速率记下来再决定要不要改行为）。 */
	uint32_t sioMissCount;
	uint32_t sioMissRateAt;
	uint32_t sioMissRatePrev;
	/* 快速帧锁存：会话建立（cnt>=2）过一次就一直走零等待路径，直到链路
	 * 断开或连续多轮拿不到任何新字。02:03 实测不锁存时 cnt 抖动会让
	 * 判定时开时关，64 次传输里只有 22 次走快速路径（fb=22 / n=42），
	 * 其余 42 次仍按 23~32ms/轮 阻塞，帧率被反复拖回去。 */
	bool sioFastLatched;
	uint32_t sioFastMiss;
	/* 【MGBAX_FAST_SLAVE_ALIGN】从机快帧门因为「本机 idx 与主机 idx 未对齐」
	 * 而挡下的轮数。只作机器可读诊断：下一轮跑可据此证明早开快帧门是否把
	 * 块交换期喂进了陈旧字（对齐修复生效时此值应为 0）。 */
	uint32_t sioFastAlignBlocked;
	/* CMD-GUARD：命令/块交换期（gLink.state>=4 且 rem==0）禁止陈旧字复用、
	 * 强制走严格真字路径的轮数。与 mobile 侧 sioCmdGuardRounds 同语义。 */
	uint32_t sioCmdGuardRounds;
	/* 从机快帧用的「上一轮真实对端字」：快帧分支里零等待取不到本轮的字
	 * 时用它补槽（与主机侧复用 sioRemote 对称）。sioFastLastValid 只在
	 * 真拿到过对端字之后才置位 —— 会话刚建立时宁可落回阻塞路径，也不拿
	 * 0 去喂游戏。 */
	uint32_t sioFastLast;
	bool sioFastLastValid;
	/* ---- 对称定长延迟线（path A：网络逐字中继） ----------------------------
	 * 目标：两端同时拿到 ① 每帧 >=9 次 SIO 中断、② 8 轮一块的校验和自洽。
	 * 严格 1:1 乒乓要求 RTT <= 1.86ms（9 轮/帧 = 18363*9 cycles ≈ 16.7ms），
	 * 实测 P2P 6~84ms，所以必须让两端都按「本轮消费 k-N 轮的字」同步后移
	 * N 轮：两端消费的字序列相同、偏移相同 ⇒ 校验和整体后移，恒等。
	 * 字段全部只在 sioDelayN > 0 时被读写，N==0 时行为与改动前逐字节相同。 */
	uint32_t sioDelayN;        /* 生效的延迟轮数（0 = 关闭） */
	bool sioDelayInit;         /* 配置只读一次 */
	uint32_t sioDelayProd;     /* 本端推送标签计数（预热期一轮 +2） */
	uint16_t sioDelayWant;     /* 本端消费链的下一标签 */
	bool sioDelayAnchored;     /* 消费链已锚定（state>=4 的第一轮完成） */
	bool sioDelayPrefill;      /* state==2：只推不消费地积累 N 深队列 */
	uint32_t sioDelayWaits;    /* 该标签未到、短周期重挂的次数（诊断） */

	/* ===== 档1 A 预测回滚（门默认关，零回归）=====
	 * 账本只记「投机字是否最终与真字一致」，绝不写权威态；预测字不进
	 * gEnemyParty/信任位/brs/rem/nr/st。sioRemoteIsPredicted 是写径拦截标记：
	 * 仅投机投递的那一轮置位，供 completeMultiTransfer 的 5FFF/帧首写径前挡下。 */
	MgbaxPredSlot sioPredShadow[MGBAX_PREDICT_HISTORY];
	uint32_t sioPredHead;
	uint32_t sioPredConfirmed;
	uint32_t sioPredMismatch;
	uint32_t sioPredMismatchSeq;
	uint32_t sioPredVsFastConflict;   /* 双预测源互斥自证，正常恒 0 */
	bool sioRemoteIsPredicted;        /* 本轮 remote 是投机字（写径拦截用） */
	struct NgLatch sioNgLatch;        /* diag 保真（回滚层只读） */
	struct NgHist sioNgHist[MGBAX_PREDICT_HISTORY]; /* 按帧索引，与 savestate 分离 */
};

/* 档1 A：预测门/采样/保真回调前向声明（定义见文件后段，逐帧采样点先用到）。 */
static bool sioPredRollbackReady(const struct SioLink* sio);
#if MGBAX_ROLLBACK_ENABLE
static void sioNgLatchSample(struct SioLink* sio, const uint8_t* diag);
static void sioDiagPreserveCb(void* vf, void* ud);
static void sioDiagVerifyCb(void* vf, void* ud);
#endif
/* PC 门面对偶标记（对偶 mobile s_rollbackEnabled）：env 或 setter 任一为 1 即开。 */
static bool s_sioRollbackEnabled = false;
void sioRollbackSet(bool enabled) { s_sioRollbackEnabled = enabled; }

/* LOADED-ROM 回退：文件扫描器找不到 ROM 时，用当前已加载核心的 ROM 镜像。
 * 玩家设备 / 任意部署路径下这是唯一一定存在的 ROM 来源（与 mobile 侧
 * mobileResolveRomAddresses() 的 LOADED-ROM 分支同契约）。定义位置必须在
 * struct SioLink 与 GBA 头文件之后；上面的扫描器只用其前向声明。 */
static const uint8_t* sioLoadedRomBytes(struct SioLink* sio, size_t* sizeOut) {
	if (sizeOut) {
		*sizeOut = 0;
	}
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return NULL;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->memory.rom || !gba->memory.romSize) {
		return NULL;
	}
	if (sizeOut) {
		*sizeOut = gba->memory.romSize;
	}
	return (const uint8_t*) gba->memory.rom;
}

/* 握手期轮询节拍：1667 cycles ≈ 0.1ms 模拟时间（与 SIO multi 日志里 wait
 * 的 0.1ms 刻度同源），远小于链路 RTT，取到字的额外延迟可以忽略。
 * 预算：一轮最多让出 60ms 墙钟，超了就退回原来的阻塞等待（见 sioConnectPollOn）。 */
#define SIO_CONNECT_POLL_CYCLES 1667u
#define SIO_CONNECT_BUDGET_MS 60u

/* ---- 对称定长延迟线：纯判据 + 配置 --------------------------------------
 *
 * 编译期默认 N=0（关闭 ⇒ 旧 1:1 行为，零回归），运行时可用 MGBAX_SIO_DELAY_N
 * 覆盖。**两端必须设成同一个值**：只要一端开启、另一端没开，消费偏移就不同，
 * 校验和立刻不自洽（gen8/src/link.c:2322-2355 的 sum 比较会置 badChecksum）。
 *
 * N 的取法：ceil(RTT_ms / 1.09)，且取 8 的整数倍（命令块边界）。P2P 60ms
 * ⇒ N=56。上限 56 由 link_net.c:286 的 PEER_QUEUE == 64 决定：队列要被
 * N+1 个字占住，N=64 会把队列塞满并让新推送被反压丢掉。
 */
#ifndef SIO_DELAY_N
#define SIO_DELAY_N 0u
#endif
#define SIO_DELAY_MAX 56u
/* 延迟线重挂上限：600 × 1667 cycles ≈ 1e6 cycles ≈ 60ms 模拟时间。超过就
 * 落回旧路径收尾，避免一条永不完成的路由把主机的中断计数清零。 */
#define SIO_DELAY_MAX_WAIT 600u

/* 延迟线判据：给定本端当前轮次 cur 与延迟 N，返回该消费的轮次。
 * N==0 ⇒ 恒等（旧 1:1 行为）；cur<=N ⇒ 0（还没攒够 N 轮，只能从头）。
 * 纯函数，真值表在 test-gboylink --delayline。 */
uint32_t sioDelayIndex(uint32_t cur, uint32_t n) {
	return cur > n ? cur - n : 0;
}

/* 读一次 MGBAX_SIO_DELAY_N（0 或缺省 = 关闭；超过 SIO_DELAY_MAX 截断并报一次）。 */
static uint32_t sioDelayConfig(void) {
	const char* v = getenv("MGBAX_SIO_DELAY_N");
	int64_t n = v ? strtoll(v, NULL, 10) : (int64_t) SIO_DELAY_N;
	if (n < 0) {
		n = 0;
	}
	if ((uint64_t) n > SIO_DELAY_MAX) {
		fprintf(stderr, "SIODELAY MGBAX_SIO_DELAY_N=%lld > %u (PEER_QUEUE=64)，截断到 %u\n",
		        (long long) n, (unsigned) SIO_DELAY_MAX, (unsigned) SIO_DELAY_MAX);
		n = SIO_DELAY_MAX;
	}
	return (uint32_t) n;
}

/* 微秒级墙钟：一帧只有 16.7ms，毫秒刻度看不出「一轮等了 0.4ms」这种量级。 */
static uint64_t wallNowUs(void) {
#ifdef _WIN32
	static LARGE_INTEGER freq;
	if (!freq.QuadPart) {
		QueryPerformanceFrequency(&freq);
	}
	LARGE_INTEGER now;
	QueryPerformanceCounter(&now);
	return (uint64_t) (now.QuadPart * 1000000ull / (freq.QuadPart ? freq.QuadPart : 1));
#else
	struct timespec ts;
	clock_gettime(CLOCK_MONOTONIC, &ts);
	return (uint64_t) ts.tv_sec * 1000000ull + (uint64_t) (ts.tv_nsec / 1000);
#endif
}

static uint32_t wallNowMs(void) {
#ifdef _WIN32
	return (uint32_t) (GetTickCount64() & 0xFFFFFFFFu);
#else
	struct timespec ts;
	clock_gettime(CLOCK_MONOTONIC, &ts);
	return (uint32_t) (ts.tv_sec * 1000 + ts.tv_nsec / 1000000);
#endif
}

static struct mTiming* coreTiming(struct SioLink* sio) {
	if (!sio->core) {
		return NULL;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		return &((struct GBA*) sio->core->board)->timing;
	}
	return NULL;
}

static void armLinkEvent(struct SioLink* sio) {
	struct mTiming* timing = coreTiming(sio);
	if (!timing) {
		return;
	}
	mTimingDeschedule(timing, &sio->linkEvent);
	mTimingSchedule(timing, &sio->linkEvent, 8192);
}

/* 读游戏里的 gLink.state（0x03002AF5）。抽成函数是为了让三处判据（快帧门、
 * 延迟线门、C1 解锁存）读同一份内存，不各写一份地址。 */
static unsigned sioGLinkState(struct SioLink* sio) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return 0;
	}
	return (unsigned) ((GBAView16(gba->cpu, SIO_IW(0x03002AF4u)) >> 8) & 0xFF);
}

/* CMD-GUARD 判据：游戏已进 CONN_ESTABLISHED(gLink.state>=4)，但训练家卡片块
 * 还没收齐（gReceivedRemoteLinkPlayers != 1，IWRAM 0x03002AC1，与 diag 的
 * rem= 和 sioCoastReady 同一个字节）。这段窗口里任何「没消费真字却收尾」的
 * 轮次都会让两端命令窗错位、块永远拼不起来（rem 恒 0 → linkup=6）。此时禁用
 * 陈旧字复用、强制严格真字路径；rem==1 后自动恢复。与 mobile 侧同契约。 */
static bool sioInCmdPhase(struct SioLink* sio) {
	if (sioGLinkState(sio) < 4u) {
		return false;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	return GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) != 1u;
}

/* ROOTHUNT2 B7 战斗期命令块中继灰度门（默认 OFF，与 RH_OFF 正交双轴）。
 * getenv 缓存，仿 rhVerbose/rhPatchesOff。 */
static bool battleRelayOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_BATTLE_RELAY");
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}
/* B7 诊断打点开关（[OPPGATE]/[B7]），独立于注入总闸；只观测不改行为。 */
static bool b7Verbose(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_B7_VERBOSE");
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}
/* ROOTHUNT2 T6 决定性探针：块交换期打 cb/delay/gSendCmd[0]/SIOMLT_SEND/status/peer。
 * 只读、b7Verbose 门、变化+心跳节流，定位"对端回什么字 + callback 是否推进 + 块字是否上链路"。 */
static const char* b7CbName(uint32_t cb) {
	if (cb == 0u) return "NULL";
	if (cb == SIO_CB_BLOCK_SEND_BEGIN) return "Begin";
	if (cb == SIO_CB_BLOCK_SEND) return "Send";
	if (cb == SIO_CB_BLOCK_SEND_END) return "End";
	return "OTHER";
}
static void sioBlockProbe(struct SioLink* sio, uint32_t remote, const char* phase) {
	if (!b7Verbose() || !sio || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	static uint32_t lastCb, lastDly, lastCmd0, lastRemote;
	static unsigned n;
	uint32_t cb = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_CALLBACK));
	uint32_t dly = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLOBAL_BSEND_DELAY));
	uint16_t cmd0 = (uint16_t) GBAView16(gba->cpu, SIO_IW(SIO_GLOBAL_SEND_CMD));
	uint16_t mltsend = (uint16_t) gba->memory.io[GBA_REG(SIOMLT_SEND)];
	uint32_t status = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_STATUS));
	uint8_t rem = (uint8_t) GBAView8(gba->cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID));
	++n;
	bool changed = (cb != lastCb || dly != lastDly || cmd0 != lastCmd0
	                || (uint16_t) remote != lastRemote);
	if (!changed && (n & SIO_PROBE_HEARTBEAT_MASK) != 0u) {
		return;
	}
	lastCb = cb; lastDly = dly; lastCmd0 = cmd0; lastRemote = (uint16_t) remote;
	SIO_LOG("[B7OWN] %s n=%u cb=%s(%08X) dly=%u cmd0=%04X mltsend=%04X status=%08X conn=%u rem=%u peer=%04X",
	        phase, n, b7CbName(cb), (unsigned) cb, (unsigned) dly,
	        (unsigned) cmd0, (unsigned) mltsend, (unsigned) status,
	        (unsigned) ((status >> SIO_LINK_STAT_CONN_SHIFT) & 1u), (unsigned) rem, (unsigned) (uint16_t) remote);
}
/* ================= ROOTHUNT2 灰区全开总门（§3.5 用户明示「全部解禁」） =================
 * MGBAX_GRAY_ALL=1 一次性打开合法 7 类灰区：GZ1 C3 直写 gLinkOpen、GZ2 seat-assist
 * 手建 task、GZ3 rearm、GZ4 RHSLVINJ 写真字、GZ5 RHBRS 强写 brs、GZ6 var8004 补写、
 * GZ7 rem-restore（restore rem=1；本就默认开，无需额外动作）。默认 0 保持原行为。
 * 【红线不滑坡】不触碰 rhPatchesOff()/rhMOff() 早退门；不蕴含 RL4 的 RHID(lp0→lp1)
 * 与 FORCE_EXCHANGE(nr=FALSE)——造 party 数据、手写 opponent_data_real/信任位、
 * 伪造 CROSSED、造 species 仍禁。产物须标注「灰区全开、CROSSED 可信度存疑、非纯零注入」。 */
#define SIO_GRAY_ALL_ENV        "MGBAX_GRAY_ALL"
/* C3 关键点：sioEnsureLinkOpen 的 cb2 战斗启动窗门（SIO_BATTLE_INIT_OFF=0x4D）
 * 在大厅/标题态 cb2 落在战斗段之外（实证 cb2=0817481D）→ 直写 gLinkOpen 不触发。
 * 独立门 MGBAX_GRAY_LOBBY_OPEN=1（被 GRAY_ALL 蕴含）绕过该窗门，允许大厅态直写。 */
#define SIO_GRAY_LOBBY_OPEN_ENV "MGBAX_GRAY_LOBBY_OPEN"
static bool sioGrayAllOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv(SIO_GRAY_ALL_ENV);
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}
static bool sioGrayLobbyOpenOn(void) {
	if (sioGrayAllOn()) {
		return true;
	}
	static int v = -1;
	if (v < 0) {
		const char* e = getenv(SIO_GRAY_LOBBY_OPEN_ENV);
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}
/* ROOTHUNT2 方案Y（用户裁决批准）：写 var8004=USING_SINGLE_BATTLE(1) 恢复
 * cable_club case5 的 SetLinkBattleTypeFlags 入参，让游戏自己设 btlType=0x0A。
 * 独立门 MGBAX_LINK_BTLCFG 默认 OFF，不被 RH_OFF/BATTLE_RELAY 抑制（目标修零注入）。
 * 零写 btlType/case1；地址走 SIO_EW 运行时 delta，不用裸 0x0202199c。 */
static bool linkBtcfgOn(void) {
	if (sioGrayAllOn()) {
		return true;   /* 灰区全开：蕴含 var8004 补写 + C3 直写 gLinkOpen */
	}
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_LINK_BTLCFG");
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}
/* 【ROOTHUNT2 P0/M1】握手态旁路保真 8FFF 独立门：默认开，MGBAX_LINK_HSBYPASS=0 秒回退。
 * 与病机同层：state==2 的主机握手字绝不能被（本会话或上一会话残留的）块帧覆盖，
 * 否则 APP 的 DoHandshake 永远读不到 tempRecvBuffer[0]==8FFF ⇒ pc 恒 0、st 卡 2
 * ⇒ rem/gLinkOpen 的 st>=4 恢复门不满足 ⇒ callback 链断（自锁闭环）。
 * 只保真游戏真字，不写 btlType/case1/brs/块数据；不改已稳握手。 */
static bool sioHsBypassOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_LINK_HSBYPASS");
		v = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开，显式 =0 关闭 */
	}
	return v != 0;
}
/* 【ROOTHUNT2 路线A / sioHandshakeHold】从机握手保持独立门：默认开，
 * MGBAX_HS_HOLD=0 秒回退（与移动端 debug.mgbax.link.hs_hold / iOS
 * UserDefaults 逐字对称）。语义：本端已 st4、对端真字仍是握手字期间，
 * 从机持续推真 B9A0 给重入 st2 的主机，让它数出 playerCount=2。
 * 只推真字，不写 state/rem/brs/nr/btlType/case1；主机不参与（0x2222 不能丢）。 */
static bool sioHsHoldOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_HS_HOLD");
		v = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开，显式 =0 关闭 */
	}
	return v != 0;
}
/* BF1: 主机握手字真自回环门（默认关）。mode B/path B 下握手字不过网，主机
 * 起轮真写 8FFF 却在自己 recv[0] 读到 0 → DoHandshake 硬条件不成立 → st=2 自锁。
 * 开此门：握手期扣下真 8FFF 作 data[0] 最后写入者，模拟真电缆自回环，只搬运真字。
 * 与移动端 debug.mgbax.link.sio_master_echo / iOS UserDefaults 逐字对称。 */
static bool sioMasterEchoOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_SIO_MASTER_ECHO");
		v = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关，显式 =1 打开 */
	}
	return v != 0;
}
/* 【路线A / 0x2222 兜底】独立布尔门：默认开，MGBAX_2222_STICKY=0 秒回退。
 * 语义：把 LINKCMD_SEND_LINK_TYPE(0x2222) 也认作「帧首块字」，使其走与
 * BBBB/8888 相同的 sticky 逐拍缓存（只在真队列帧头出现过才兜，非伪造）。
 * ROUTEA-DIAG-01 实证：握手保持修好后 0x2222 一次性发、无兜底从未出网
 * (sq0=0000) ⇒ 训练家卡块启动字丢失。与移动端 debug.mgbax.link.block2222_sticky
 * / iOS UserDefaults 逐字对称。 */
static bool sioBlock2222On(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_2222_STICKY");
		v = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开，显式 =0 关闭 */
	}
	return v != 0;
}
/* 【PHASE-FIX 2026-11-25】具名门默认关：rem==1 后继续钉帧首相位。
 * 病机：0x03002AC1(rem)=gReceivedRemoteLinkPlayers 只表示 trainer card 块收齐，
 * 不是 party 块(B1 §①9 三次 160B 循环)收齐。sioAlignCmdFrameHeader 里
 * `if (rem==1) return`（原注释"块已收齐"误注）在 party 块阶段 premature，
 * 使 8888 帧首落地 sc=0/rc=0 不被钉正（FRESHALL-01 PC [RHALIGN] n=8 实证），
 * party 块重组失败、brs 停 01。门开时忽略该 early return，让 sc/rc 继续被钉正。
 * 只写 sendCmdIndex/recvCmdIndex 两个相位索引，不写 brs/rem/nr/party/信任位；
 * 只搬运真帧首字相位，非伪造。与移动端 debug.mgbax.link.phase_fix 逐字对称。 */
static bool sioPhaseFixOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_PHASE_FIX");
		v = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关，显式 =1 打开 */
	}
	return v != 0;
}
/* 【path B / LocalBus 握手字保真】独立布尔门：默认开，MGBAX_BUS_HS_PRESERVE=0 秒回退。
 * PB4/PB5 实证：2 核 LocalBus 握手期，主机 sioDoneEvent 在 busGot<=0（从机未
 * push/广播 abort）重试 3 次后仍用全 FFFF 空槽收尾 → DoHandshake 第一槽 break、
 * playerCount 恒 0、st=2 自锁。游戏其实每轮真写了 8FFF（SLOT w=8FFF 铁证），
 * 只是被空槽覆盖。修法：abort 收尾时把本轮 own（真 SIOMLT_SEND，经
 * sioBlockOutWord 的 HSBYPASS 保真）填入主机自槽，与从机「绝不空槽收尾」对称。
 * 只保真游戏真字，不造 state/rem/brs/nr/party。与移动端
 * debug.mgbax.link.bus_hs_preserve / iOS UserDefaults 逐字对称。 */
static bool sioBusHsPreserveOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_BUS_HS_PRESERVE");
		v = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开，显式 =0 关闭 */
	}
	return v != 0;
}
/* sioBusBootHsPreserve 定义在 sioBlockOutWord 之后（见下）。 */
/* 【path B / 2P 不被钳成 3】独立布尔门：默认关，MGBAX_LOCALBUS_2P=1 开启。
 * PB15 实证：sioLinkHostPlayersLocal 把 players<3 钳成 3，2P 房被当 3P 铺
 * 总线槽位。开启后按具名下限保留真实 2P。可逆 A/B，不动默认行为。 */
#define MGBAX_LOCALBUS_MIN_PLAYERS 2u   /* 具名下限：2P 房不再被抬成 3 */
static bool sioLocalBus2pOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_LOCALBUS_2P");
		v = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关，显式 =1 开启 */
	}
	return v != 0;
}
/* 【W92 / path B 原生 SIO 字路由门 — 独立门，默认关，MGBAX_PATHB_NATIVE_SIO=1 开启】
 * 语义（只改「字节怎么到 tempRecvBuffer」，不改字节来源真实性）：
 *  1) 握手期(gLink.state < CONN)让游戏真写进 SIOMLT_SEND 的 8FFF/B9A0
 *     经进程内 LocalBus 原生投递，块帧路由不启动 ⇒ 不再依赖 HSBYPASS
 *     保真门（消除灰区依赖，非合成握手字）；
 *  2) 门开时关闭一切「写真握手字」回填（RHSLVINJ / BUS_HS_PRESERVE），
 *     收尾槽里的握手字必须来自对端镜像核经 LocalBus 跑出的真字；取不到字
 *     保持空槽 = 诚实失败，绝不合成 gate 假阳性；
 *  3) 不写 gLinkOpen / gLink.state / tempRecvBuffer / rem / nr / brs / party /
 *     信任位；gEnemyParty 仍由游戏自己 SIO 组装（与 sidecar 注入解耦，由移动端
 *     对称门保证）。红线一律不碰。
 * 默认关时下面每处改动都早退，行为逐字节不变（零回归）。与移动端
 * debug.mgbax.link.pathb_native_sio / iOS UserDefaults+env 同名同值，默认 0。
 * 门开≠成功：零注入 CROSSED（APP 0006 ↔ PC 00D5）仍是唯一裁决，必要非充分。 */
#define SIO_PATHB_NATIVE_SIO_ENV "MGBAX_PATHB_NATIVE_SIO"
static bool sioPathBNativeSioOn(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv(SIO_PATHB_NATIVE_SIO_ENV);
		v = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关，显式 =1 开启 */
		if (v) {
			SIO_LOG("[PATHBNATIVE] MGBAX_PATHB_NATIVE_SIO=1 (PC 原生 SIO 字路由：握手期真字直投、禁写真握手字)");
		}
	}
	return v != 0;
}
/* 【RACE_STRESS 压测门 — PC/Qt no-op reader，三端同名同值对称】
 * 只读 env MGBAX_RACE_STRESS 打一次 readback 日志，满足门名同值/可观测；
 * PC 无 apply-vs-destroy 的 CRASH5 竞态且延时有害，故【不注入延时、不改任何
 * 协议态】。真造窗在 Android/共享 C（mgba_mobile.c 的 mobileRaceStressMs +
 * mobileLoadStateLocked 注入点）。压测轮一律标注应力诱导、绝不进裁决轮。 */
static void sioRaceStressReadback(void) {
	static bool logged = false;
	if (logged) {
		return;
	}
	logged = true;
	const char* e = getenv(MGBAX_RACE_STRESS_ENV);
	SIO_LOG("[RACESTRESS] MGBAX_RACE_STRESS=%s (PC no-op reader, no delay injected)",
	        e ? e : "<unset>");
}
#define SIO_BATTLE_INIT_OFF 0x4Du   /* CB2_InitBattle = lo+0x4D */
static unsigned s_sioBtcfgWrites;
/* 【ROOTHUNT2 方案 b — ROOTFIX-01 方向纠正】窄窗口补写 var8004=1。
 * driver APP-NAV 跳过接待员菜单，var8004 停在菜单清值 →
 * case5 SetLinkBattleTypeFlags(0) no-op → btlType 无 LINK → case1 走单机 wild。
 * 正解：在「菜单已确定走战斗、case5 尚未读 var8004」的窄窗口补写合法
 * USING_SINGLE_BATTLE(1)（恢复 driver 跳过菜单漏设的值，非伪造）。
 * 窗口 = 战斗 linkType 值(battle task case0 已设) && gLink.state 达连接态(握手完成)
 *       && cb2 不在 battle 段(case5 未切 CB2_InitBattle=未读)
 *       && var8004==0 && btlType 无 LINK(case5 未设过)。
 * 标题阶段(linkType 非战斗 / state 未达连接态) → 不写（消除菜单污染）；
 * case5 已过(cb2 进 battle 段) → 不写（避免太晚无效）。不改 gLinkType。 */
static void sioEnsureLinkBtcfg(struct GBA* gba) {
	if (!linkBtcfgOn() || !gba || !gba->cpu) {
		return;
	}
	uint16_t lt = (uint16_t) GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE));
	if (lt != SIO_LINKTYPE_BATTLE) {  /* battle task case0 已设 → 菜单已确定走战斗 */
		return;
	}
	uint32_t lk = SIO_IW(SIO_GLINK_STATE);
	unsigned st = (unsigned) GBAView8(gba->cpu, lk + SIO_GLINK_STATE_OFF);
	if (st < SIO_LINK_STATE_CONN) {  /* 握手完成 */
		return;
	}
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* cb2 不在 battle 段 = case5 还没把 callback 切到 CB2_InitBattle（未读 var8004）。
	 * cb2 来自不同 code 段、数值不代表先后：握手期 cb2 高于 InitBattle 入口地址，
	 * 故不能用数值小于 InitBattle 判定，须用「不在 battle 段」。 */
	if (cb2 >= SIO_BATTLE_LO() + SIO_BATTLE_INIT_OFF
	    && cb2 < SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		return;
	}
	if (GBAView16(gba->cpu, SIO_EW(SIO_SPECIAL_VAR_8004)) != 0u
	    || (GBAView32(gba->cpu, SIO_EW(SIO_BATTLE_TYPE_FLAGS)) & SIO_BATTLE_TYPE_LINK) != 0u) {
		return;  /* var8004 已设 / case5 已设 btlType LINK → 不写 */
	}
	GBAPatch16(gba->cpu, SIO_EW(SIO_SPECIAL_VAR_8004), 1, NULL);
	++s_sioBtcfgWrites;
	if (b7Verbose()) {
		SIO_LOG("[BTLCFGW] cb2=%08X var8004=0->1 btlType=%08X linkType=%04X st=%u writes=%u",
		        (unsigned) cb2,
		        (unsigned) GBAView32(gba->cpu, SIO_EW(SIO_BATTLE_TYPE_FLAGS)),
		        (unsigned) lt, st, s_sioBtcfgWrites);
	}
}
/* ROOTHUNT2 块交换根治①（B7OWN 铁证：conn=1 但 open=0）：
 * 真 LINK 战关链(CloseLink 清 gLinkOpen=0)后，rem=1 让 HandleLinkBattleSetup 的
 * if(!rem) OpenLink() 不触发 → gLinkOpen 保持 0 → LinkMain2 `if(!gLinkOpen) return`
 * 掐断 gLinkCallback → BlockSendBegin dly 恒0 → 块字发不出。这里在战斗启动窗口
 * 且对端确实连着(rem=1 st>=4 LINKTYPE_BATTLE)时把 gLinkOpen 恢复成 1 —— 恢复真实
 * 链路打开状态（非伪造数据），让 callback 链能推进到 BlockSend。门 MGBAX_LINK_BTLCFG。 */
static unsigned s_sioLinkOpenWrites;
static void sioEnsureLinkOpen(struct SioLink* sio) {
	if (!linkBtcfgOn() || !sio || !sio->link || netLinkState(sio->link) != 2
	    || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* 【灰区全开 C3】大厅态 cb2=0817481D 在战斗段之外，普通门会早退；
	 * MGBAX_GRAY_LOBBY_OPEN=1（或 MGBAX_GRAY_ALL=1）时绕过 cb2/battleish/玩家数门，
	 * 强制直写 gLinkOpen=1（灰区伪恢复链路状态，非游戏可达态，须标注产物）。 */
	bool grayLobby = sioGrayLobbyOpenOn();
	if (!grayLobby
	    && (cb2 < SIO_BATTLE_LO() + SIO_BATTLE_INIT_OFF
	        || cb2 >= SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF)) {
		return;
	}
	/* 【鲁棒战斗判定】OPEN-FIX-01 实证 linkType 值会波动，硬编码单值不安全。
	 * btlType 含 LINK 位是 cable_club case5 设的可靠战斗标志；战斗类 gLinkType
	 * 亦兼容；交换类不满足。二者取并集（宏化判定，无裸字面量）。 */
	uint32_t lk = SIO_IW(SIO_GLINK_STATE);
	uint32_t bt = (uint32_t) GBAView32(gba->cpu, SIO_EW(SIO_BATTLE_TYPE_FLAGS));
	uint16_t lt = (uint16_t) GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE));
	bool battleish = ((bt & SIO_BATTLE_TYPE_LINK) != 0u)
	                 || ((lt & SIO_LINKTYPE_CLASS_MASK) == SIO_LINKTYPE_CLASS_BATTLE);
	if (!battleish && !grayLobby) {
		return;
	}
	/* 对端确实连着：state 达连接态、playerCount 达 2P。不叠加 rem 门——U2 自锁。
	 * 灰区全开时放宽此门——大厅/标题态 st/pc 未达连接态也要强开 gLinkOpen。 */
	if (!grayLobby
	    && (GBAView8(gba->cpu, lk + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN
	        || GBAView8(gba->cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF) < SIO_LINK_PLAYERCOUNT_2P)) {
		return;
	}
	/* 【消灭假 checksum】U8/U2：CheckErrorStatus 因 gLinkStatus 错误位反复
	 * CloseLink 清 gLinkOpen，是 open 反复掉 0 的根源。每轮清 LINK_STAT_ERRORS
	 *（含 checksum / queueFull），与 mobile mobileBattleKeepAlive 对称。 */
	uint32_t st = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_STATUS));
	if (st & SIO_LINK_STAT_ERRORS) {
		GBAPatch32(gba->cpu, SIO_IW(SIO_GLINK_STATUS), (int32_t) (st & ~SIO_LINK_STAT_ERRORS), NULL);
	}
	/* 保 gLinkOpen=1：对端连着，恢复真实链路打开状态（非伪造），让 LinkMain2
	 * 不再早退、gLinkCallback 能推进 BlockSendBegin → 块字上链路。 */
	if (GBAView8(gba->cpu, SIO_EW(SIO_LINK_OPEN)) == 0u) {
		GBAPatch8(gba->cpu, SIO_EW(SIO_LINK_OPEN), 1, NULL);
		++s_sioLinkOpenWrites;
		if (b7Verbose()) {
			SIO_LOG("[B7OPEN%s] cb2=%08X gLinkOpen=0->1 st=%u pc=%u bt=%08X lt=%04X writes=%u",
			        grayLobby ? "-GRAY" : "", (unsigned) cb2,
			        (unsigned) GBAView8(gba->cpu, lk + SIO_GLINK_STATE_OFF),
			        (unsigned) GBAView8(gba->cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF), (unsigned) bt, (unsigned) lt,
			        s_sioLinkOpenWrites);
		}
	}
}
static unsigned s_sioBattleRelayEmpty;
static unsigned s_sioBattleRelaySlavePush;
/* B7 判据：链路在连 + CB2 落 controller 命令块往返窗口；握手期恒 false。
 * 全程现有自解析宏，无裸 0x08/0x02 地址。 */
static bool inBattleBlockRelay(struct SioLink* sio) {
	if (!sio || !sio->link || netLinkState(sio->link) != 2
	    || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	return cb2 >= SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 <  SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF;
}

/* 本端本轮推出去的字要带的轮次号。
 *
 * N==0 ⇒ 原样返回 sioIndex（旧行为，一个字节都不变）。
 * N>0  ⇒ 用独立的 sioDelayProd 计数：预热期（state==2 且对端队列还不够深）
 *         一轮推两个标签，主标签 l、影子标签 l+1，值相同。这样标签空间
 *         连续、不重复，对端的消费链（每轮 +1）永远看到队首就是它要的标签，
 *         队列深度因此每轮 +1 —— 这是唯一能在握手期不破坏 1:1 交换的积累方式
 *         （握手字是常量，重复一轮对 DoHandshake 的 playerCount 判定无害）。
 * 影子字只在预热期推，深度到 N 即停，之后两端恢复 1 标签/轮，偏移固定为 N。
 */
static uint16_t sioDelayNextPushLabel(struct SioLink* sio, bool* extra) {
	*extra = false;
	if (!sio->sioDelayN) {
		return sio->sioIndex;
	}
	uint16_t l = (uint16_t) sio->sioDelayProd++;
	if (sio->sioDelayPrefill && sio->link
	    && netLinkPeerPending(sio->link) < (int) sio->sioDelayN) {
		*extra = true;
		++sio->sioDelayProd;
	}
	return l;
}

/* 【13:52 从机推字轮次号修正】主机在 beginMultiTransfer 里先 `++sioIndex`
 * 再以 `want=sioIndex` 取字。从机收到主机 tag=k 后把 `sioIndex` 设成 k，
 * 若仍用 `sioIndex` 当自己推字的 tag，推的是 k；主机下一轮 want=k+1，
 * strict takePeerWord 判 `d=k-(k+1)<0` ⇒ **当旧字丢弃**，只能用空槽
 * 0xFFFF 收尾（NOFORCE1 现场：两端 idx/pushIn 都同步到 4480，但投递给
 * 游戏的 data[1] 恒 FFFF、pc 恒 1）。所以从机推字 tag 必须是
 * `sioIndex + 1`（= 主机下一轮要的号）。N>0 的延迟线标签空间独立，
 * 原样沿用。 */
static uint16_t sioSlavePushLabel(struct SioLink* sio, bool* extra) {
	uint16_t label = sioDelayNextPushLabel(sio, extra);
	if (!sio->sioDelayN) {
		label = (uint16_t) (sio->sioIndex + 1u);
	}
	return label;
}

/* 从机本轮该推出的字。
 * 【17:00 根因】WRITEDIAG 插桩：从机 `gbaLinkWriteCnt` 计数恒 0 —— GBA MULTI
 * 的从机由主机时钟被动驱动，根本不写 SIOCNT，所以 `sioRoundWordValid` 永远
 * false，起轮捕获点（原"从机自槽"真源）在从机上不存在。从机 SIOMLT_SEND
 * 唯一真源就是游戏 DoSend 写的实时寄存器，握手期和块交换期都一样。
 * 之前把"读实时寄存器"限制在 state<4、state>=4 回退 sioLastOwn，导致从机
 * 槽 1 永远停在握手字 B9A0、块数据从未推出 → 两端 8 轮校验和不等 →
 * badChecksum(0x2000) 拆链。现在统一读实时寄存器（非 0 时），0 时保留
 * sioLastOwn（DoSend 空队列写 0 时由 sioWordOrEmpty 决定 0/FFFF）。 */
static uint16_t sioSlaveOwnWord(struct SioLink* sio);
/* ROOTHUNT2 治本（取代 4a9a25136 的"S5 打点对齐"误删）：GBA 从机不写 SIOCNT
 *（WRITECNT=0），gbaLinkWriteCnt 起轮分支永不执行；只靠它捕获会让 sioBlockPhase
 * 停在 calloc 的 0 → sc==0 恒放行、三处注入点空转、零块字。恢复从机真实路径的
 * 相位/块字捕获：只读 gLink.sendCmdIndex 与 SIOMLT_SEND，绝不写游戏状态。 */
static uint8_t sioCaptureBlockPhase(struct SioLink* sio, struct GBA* gba);
static void sioCaptureBlockWord(struct SioLink* sio, uint16_t sioMltSend, struct GBA* gba);
#define SIO_CAPTURE_BLOCK_CTX(sio_, gba_, word_) do { \
	(void) sioCaptureBlockPhase((sio_), (gba_)); \
	sioCaptureBlockWord((sio_), (uint16_t) (word_), (gba_)); \
} while (0)
static uint16_t sioSlaveOwnWord(struct SioLink* sio) {
	struct GBA* capG = (sio && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA)
	                   ? (struct GBA*) sio->core->board : NULL;
	if (capG) {
		SIO_CAPTURE_BLOCK_CTX(sio, capG, capG->memory.io[GBA_REG(SIOMLT_SEND)]);
	}
	if (sio->sioRoundWordValid) {
		return sio->sioRoundWord;
	}
	if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) sio->core->board;
		uint16_t regWord = gba->memory.io[GBA_REG(SIOMLT_SEND)];
		if (regWord) {
			return regWord;
		}
		/* 【2026-11-16 19:4x 根因】CONN_ESTABLISHED(state>=4) 之后 0 是**合法
		 * 命令字**：DoSend 在 sendQueue 空时就是 `REG_SIOMLT_SEND = 0`
		 *（gen8/link.c:2395）。以前这里把 0 一律当"本轮还没写字"回退成
		 * sioLastOwn(=B9A0)，于是从机进入 state4 之后**每一轮都还在发握手字**
		 *（TR14 现场：B 端 d=…,B9A0 恒定到结束，A 端 m1=B9A0 恒定），块数据
		 * 一个字节都发不出去 ⇒ rem 恒 0 ⇒ 报通信错误。
		 * 只有握手期(state<4)的 0 才是"空槽"，那时才回退。 */
		if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u) {
			return 0;
		}
	}
	return sio->sioLastOwn;
}

/* 【13:58】state>=4 后 0 是合法命令字（DoSend 空队列写 0，参与 checksum），
 * 必须原样投递；握手期 0 才是要避开的空槽，换 0xFFFF。 */
/* 【ROOTHUNT2 修复②】是否处于"块发送期"——握手保持须让位，恢复真块字传输。
 * 三判据（state>=4 硬门在前，保证 state<4 的 rearm/收尾逻辑完全不变）：
 *   A: gLinkCallback ∈ {BlockSendBegin, BlockSend, BlockSendEnd}
 *   B: gSendCmd[0] ∈ {0xBBBB, 0x8888}（INIT/CONT 块字）
 *   C: cb2 在 HandleStartBattle 战斗窗 && rem!=0 && MULTIUSE_STATE ∈ 块期值集合
 * 门 MGBAX_LINK_BTLCFG（默认关），纯让位，不写 btlType/case1/brs/块数据。 */
static bool sioInBlockSendPhase(struct SioLink* sio, struct GBA* gba) {
	if (!gba || !gba->cpu) {
		return false;
	}
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN) {
		return false;  /* state<4 恒 false：不碰 rearm/收尾 */
	}
	uint32_t cb = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_CALLBACK));
	if (cb == SIO_CB_BLOCK_SEND_BEGIN || cb == SIO_CB_BLOCK_SEND
	    || cb == SIO_CB_BLOCK_SEND_END) {
		return true;  /* A: 块 callback */
	}
	uint16_t cmd0 = (uint16_t) GBAView16(gba->cpu, SIO_IW(SIO_GLOBAL_SEND_CMD));
	if (cmd0 == LINKCMD_INIT_BLOCK || cmd0 == LINKCMD_CONT_BLOCK) {
		return true;  /* B: INIT/CONT 块字 */
	}
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 >= SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 < SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID)) != 0u) {
		unsigned mu = (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_BATTLE_COMM));
		if (mu == LINK_MU_BLOCK2 || mu == LINK_MU_BLOCK4 || mu == LINK_MU_BLOCK8
		    || mu == LINK_MU_BLOCK12 || mu == LINK_MU_BLOCK17) {
			return true;  /* C: 等 brs 的块 case */
		}
	}
	return false;
}

static bool sioIsHandshakeWord(uint16_t w) {
	return w == LINK_HANDSHAKE_MASTER || (uint16_t) (w & ~LINK_HANDSHAKE_SLAVE_MASK) == LINK_HANDSHAKE_SLAVE;
}
/* 【ROOTHUNT2 方案2，与 mobile 对称】真块字 sticky 缓存：
 * gen8 9 拍帧里块字只在 sendCmdIndex==0 那拍出现，单拍扣字会错过。
 * 每次起轮读 SIOMLT_SEND 时捕获块字，push 时优先推出（非伪造，gen8 真生成）。 */
static bool sioIsBlockWord(uint16_t w) {
	/* 路线A：0x2222 启动字纳入 sticky 兜底（受独立门控制，=0 秒回退）。
	 * 只在 sioReloadBlockFrame 的「队头真字」判据里命中才会被缓存逐拍推，
	 * 非伪造；B7BLK 打点的 frame= 也随之标注 0x2222 帧首。 */
	return w == LINKCMD_INIT_BLOCK || w == LINKCMD_CONT_BLOCK
	    || (sioBlock2222On() && w == LINKCMD_SEND_LINK_TYPE);
}
/* 【ROOTHUNT2 V1 相位锁】只读 gLink.sendCmdIndex（sc，+0x16），绝不写索引。
 * gen8 9 拍帧：DoSend 在 sc∈[0,7] 写 data[sc]、sc==8 写真 checksum。
 * 起轮 sc 是"本轮 DoSend 要用的相位"、在飞字是上一轮的 data[sc-1]（sc==0 时
 * 在飞的是 checksum）——见本文件 sioSyncIdx 的 idxW=(sc==0)?8:(sc-1) 与
 * CMDFRAMEALIGN（帧首字 DoSend sc==0 写、起轮 sc==1 在飞）。故注入按 sc-1
 * 选帧内字、sc==0 放行真 checksum。
 * 每轮起轮捕获一次到 sioBlockPhase，自槽(advance=false)与 push(advance=true)
 * 用同一 sc → 同一块字 → 两端 checksum 累加一致。 */
static uint8_t sioCaptureBlockPhase(struct SioLink* sio, struct GBA* gba) {
	if (sio && gba && gba->cpu) {
		sio->sioBlockPhase = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	}
	return sio ? sio->sioBlockPhase : 0u;
}
/* 【ROOTHUNT2 V1】会话 reset（V11-S7）：state<2（链路重建/未起）时清空块帧缓冲，
 * 杜绝上一会话的块字残留污染本会话判据。仅在 linkBtcfgOn 门内生效。 */
static void sioResetBlockFrame(struct SioLink* sio, struct GBA* gba) {
	if (!linkBtcfgOn() || !sio || !gba || !gba->cpu) {
		return;
	}
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_HANDSHAKE) {
		sio->sioBlockFrameValid = false;
		sio->sioBlockFrameIdx = 0;
	}
}
/* 【ROOTHUNT2 方案2+V1】从 gen8 真实 sendQueue.data[0..7][pos] 读完整块命令帧
 *（8 字），按 sc 相位逐拍推出；只在 sc==0 且 data[0][pos] 是块字时 reload。 */
static void sioReloadBlockFrame(struct SioLink* sio, struct GBA* gba) {
	if (!linkBtcfgOn() || !sio || !gba || !gba->cpu) {
		return;
	}
	/* V1：只在 sc==0（新命令帧首）reload；自由 8 计数已由 sc 取代。 */
	if (sio->sioBlockPhase != 0u) {
		return;
	}
	uint32_t base = SIO_IW(SIO_GLINK_STATE);
	uint8_t pos = GBAView8(gba->cpu, base + SIO_GLINK_SENDQ_POS_OFF);
	/* V3：EnqueueSendCmd 写队尾 (pos+count)%50、DoSend 读队头 data[][pos]。
	 * 只读队头（与 gen8 DoSend 同槽）；块帧入队后须等 count 次 sc==8 弹队
	 * 才到队头。判据 = data[0][pos] 是否真为 BBBB/8888，不读队尾——读队尾
	 * 会把未轮到的帧推出、与 gen8 自己的 checksum/sc 相位脱节。 */
	uint8_t cnt = GBAView8(gba->cpu, base + SIO_GLINK_SENDQ_CNT_OFF);
	uint32_t slot = base + SIO_GLINK_SENDQ_WORD_OFF(0, SIO_SENDQ_SLOT_HEAD(pos));
	(void) cnt;  /* 打点里用；逻辑判据只看队头字 */
	if (!sioIsBlockWord(GBAView16(gba->cpu, slot))) {
		/* V3：队头不是块字 ⇒ 块帧还在队尾未到或已错过，清残留、本轮推 own。 */
		sio->sioBlockFrameValid = false;
		sio->sioBlockFrameIdx = 0;
		return;
	}
	for (unsigned k = 0; k < LINK_CMD_LENGTH; ++k) {
		sio->sioBlockFrame[k] =
		    SIO_GLINK_SENDQ_WORD(gba->cpu, k, SIO_SENDQ_SLOT_HEAD(pos));
	}
	sio->sioBlockFrameIdx = 0;
	sio->sioBlockFrameValid = true;
}
/* V1 相位门控（in-flight 槽位口径，与 mobile 逐字对称）——sioSyncIdx 的
 * SIO_SYNCIDX_TAG_WORD 已定义：idxW = (sc==0)?8:(sc-1)，即起轮 sc 是本轮
 * DoSend 相位、在飞字是上一轮写的 data[sc-1]；CMDFRAMEALIGN 亦证明帧首字
 * 由 DoSend 在 sc==0 写、起轮 sc==1 时在飞。⇒ sc==0 放行真 checksum 并在
 * 帧首 reload；sc∈[1,8] 推 frame[sc-1]。误用 frame[sc] 会整帧错一格。 */
static uint16_t sioBlockOutWord(struct SioLink* sio, uint16_t w, bool advance, struct GBA* gba) {
	if (!linkBtcfgOn() || !sio || !gba || !gba->cpu) {
		return w;
	}
	/* 【W92/path B 原生 SIO】握手期(state<CONN)放行游戏真字，不让块帧路由
	 * 顶掉真 8FFF/B9A0 —— 这是 HSBYPASS 的原生替代：真字经 LocalBus 自然
	 * 送达，不再需要「写真握手字保真」。只读 w、不合成任何字；state>=CONN
	 * 的块字路由完全不变（门关时此地早退，零回归）。 */
	if (sioPathBNativeSioOn()
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF)
	           < SIO_LINK_STATE_CONN) {
		return w;
	}
	/* 【ROOTHUNT2 P0/M1】握手态旁路保真 8FFF：state==2 且出字是主机握手字时
	 * 直接放行，不让块帧（含上一会话残留 sioBlockFrameValid）替换。8FFF 是
	 * gen8 真 MASTER_HANDSHAKE，只保真不伪造；门 MGBAX_LINK_HSBYPASS=0 秒回退。
	 * state>=4 的 handshake-suppress 与块字注入逻辑完全不变。 */
	if (sioHsBypassOn() && w == LINK_HANDSHAKE_MASTER
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF)
	           == SIO_LINK_STATE_HANDSHAKE) {
		return w;
	}
	sioResetBlockFrame(sio, gba);
	uint8_t sc = sio->sioBlockPhase;
	if (sc == 0u) {
		/* checksum 拍：放行 gen8 真值，不注入；顺便在帧首 reload 队头块帧。 */
		sioReloadBlockFrame(sio, gba);
		return w;
	}
	if (sc > 8u) {
		return w;
	}
	if (!sio->sioBlockFrameValid) {
		return w;
	}
	unsigned word = (unsigned) (sc - 1u);
	uint16_t out = sio->sioBlockFrame[word];
	sio->sioBlockFrameIdx = (uint8_t) word;
	/* 路线A 只读打点：0x2222 兜底字真正出网（sc==1 推 frame[0]）时记一条，
	 * 供父会话核对 sq0/mltsend 是否出现 2222→BBBB→8888。纯日志，不写状态。 */
	if (sioBlock2222On() && out == LINKCMD_SEND_LINK_TYPE && word == 0u && b7Verbose()) {
		SIO_LOG("[B72222] sticky push 0x2222 sc=%u ok=%u", (unsigned) sc,
		        (unsigned) sio->sioOk);
	}
	if (advance && sc == 8u) {
		sio->sioBlockFrameValid = false;  /* 第 8 字推完，下一轮 sc==0 再 reload */
	}
	return out;
}
/* 【path B / boot-phase gate 握手期保真】gLinkCallback==0 但 gLink.state==2 且真
 * 对端在线 = 游戏已进握手态却还没装 callback（path B 现场 cb 恒 0）。此时若按
 * 空槽收尾，DoHandshake 第一槽 FFFF → playerCount=0 自锁。把本轮真 SIOMLT_SEND
 *（经 sioBlockOutWord 的 HSBYPASS 保真）填自槽、对端真握手字填 peer 槽。非
 * party/信任位，不写游戏状态；真 boot(state<2，如 494E) 不动空槽。 */
static void sioBusBootHsPreserve(struct SioLink* sio, struct GBA* gba, uint32_t vals[4], int players) {
	/* 【W92/path B 原生 SIO】门开时禁用 boot 期写真握手字回填：槽位只由
	 * 进程内 LocalBus 真字填充；取不到字保持空槽，诚实失败不合成。 */
	if (sioPathBNativeSioOn() || !sioBusHsPreserveOn() || !sio || !gba || !gba->cpu || !sio->link
	    || netLinkState(sio->link) != 2u) {
		return;
	}
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF)
	    != SIO_LINK_STATE_HANDSHAKE) {
		return;   /* 只管握手态；真 boot 保持原空槽行为 */
	}
	uint16_t w = (uint16_t) sioBlockOutWord(sio,
	    gba->memory.io[GBA_REG(SIOMLT_SEND)], true, gba);   /* HSBYPASS 保真的真字 */
	if (!sioIsHandshakeWord(w)) {
		return;   /* 非真握手字（如 boot 494E）→ 不动空槽 */
	}
	int me = netLinkPlayer(sio->link);
	if (me >= 0 && me < 4 && vals[me] == 0xFFFFu) {
		vals[me] = w;
	}
	if (me == 0 && w == LINK_HANDSHAKE_MASTER && players >= 2 && vals[1] == 0xFFFFu) {
		vals[1] = LINK_HANDSHAKE_SLAVE;   /* 对端镜像核每轮真产生的 B9A0，transport 丢失回填 */
	}
	if (sio->sioOk <= 64u) {
		SIO_LOG("[BUSHS] boot-gate preserve me=%d idx=%u s0=%04X s1=%04X",
		        me, (unsigned) sio->sioIndex, (unsigned) vals[0], (unsigned) vals[1]);
	}
}
/* [B7BLK] 逐拍观测打点（B7_VERBOSE 门）：纯只读，不改任何块推送行为、不写游戏状态。
 * 战斗 cb2 窗内每拍一条（逐拍），窗外仍按 1/32 采样控制量。扩展字段
 * st/cb2/sc/rc/sq0/cnt/mltsend/self/peer/brs 全部实时只读，供终局定性真实
 * sc 分布 / 块字窗口 / brs 是否闭合。sc 取自 sioBlockPhase —— 从机侧由
 * SIO_CAPTURE_BLOCK_CTX 在推送点每轮捕获真值（不再恒 0）。 */
static void sioCaptureBlockWord(struct SioLink* sio, uint16_t sioMltSend, struct GBA* gba) {
	if (!b7Verbose() || !gba || !gba->cpu || !sio) {
		return;
	}
	static unsigned bn;
	++bn;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	uint8_t state = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	bool inBattle = state >= SIO_LINK_STATE_CONN
	    && cb2 >= SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 < SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF;
	if (!inBattle && (bn & 0x1Fu) != 0u) {
		return;
	}
	uint32_t base = SIO_IW(SIO_GLINK_STATE);
	uint8_t pos = GBAView8(gba->cpu, base + SIO_GLINK_SENDQ_POS_OFF);
	uint8_t cnt = GBAView8(gba->cpu, base + SIO_GLINK_SENDQ_CNT_OFF);
	uint32_t headSlot = SIO_SENDQ_SLOT_HEAD(pos);
	uint32_t tailSlot = SIO_SENDQ_SLOT_TAIL(pos, cnt);
	uint16_t sq0 = SIO_GLINK_SENDQ_WORD(gba->cpu, 0, headSlot);
	uint16_t tail0 = SIO_GLINK_SENDQ_WORD(gba->cpu, 0, tailSlot);
	uint8_t rc = GBAView8(gba->cpu, base + SIO_GLINK_RECVCMD_IX_OFF);
	uint16_t brs = GBAView16(gba->cpu, SIO_IW(SIO_GLOBAL_BLK_RECV_STATUS));
	SIO_LOG("[B7BLK] n=%u st=%u cb2=%08X sc=%u rc=%u sq0=%04X pos=%u cnt=%u head=%u tail0=%04X frame=%u idx=%u valid=%d mltsend=%04X self=%04X peer=%04X brs=%04X",
	        bn, (unsigned) state, (unsigned) cb2, (unsigned) sio->sioBlockPhase, (unsigned) rc,
	        (unsigned) sq0, (unsigned) pos,
	        (unsigned) cnt, (unsigned) headSlot, (unsigned) tail0,
	        (unsigned) (sioIsBlockWord(sq0) ? 1 : 0),
	        (unsigned) sio->sioBlockFrameIdx, sio->sioBlockFrameValid ? 1 : 0,
	        (unsigned) sioMltSend, (unsigned) sio->sioSelfSlot,
	        (unsigned) (uint16_t) sio->sioRemote, (unsigned) brs);
}

/* 【路线A / sioHandshakeHold 单一取值点】每轮所有 netLinkPush 与自槽共用这一个
 * 判据：本端 st4、从机、真对端在线、对端真字仍是握手字、窗口未空、非块期 ⇒
 * 推 gen8 真从机握手字 B9A0（只推真字；不写 state/rem/brs/nr/btlType/case1）。
 * 同一轮内 st / sioRemote / 窗口 / 块期都不变，故各调用点取值天然同源，
 * 等价于「每轮算一次、多处共用」。
 *
 * 为什么继续推握手字：本端已进 CONN_ESTABLISHED，但对端最近真字仍是握手字 ⇒
 * 对端仍在 DoHandshake。此轮若改发命令字（空队列时 0x0000），对端
 * `tempRecvBuffer[1]==SLAVE_HANDSHAKE` 的 playerCount 门不成立 ⇒ 永久停 st2。
 *
 * 主机绝不保持：命令帧首格 LINKCMD_SEND_LINK_TYPE(0x2222) 只在
 * LinkCB_RequestPlayerDataExchange 发一次且需 `LINK_STAT_MASTER`；进了 st4
 * 的头几轮若被换成握手字，0x2222 永久丢失 ⇒ 对端永不回块 ⇒ rem 恒 0（TR21）。 */
static uint16_t sioHandshakeHoldWord(struct SioLink* sio, uint16_t own, struct GBA* gba) {
	if (!linkBtcfgOn() || !sioHsHoldOn() || !sio || !sio->link
	    || !gba || !gba->cpu) {
		return own;
	}
	if (netLinkState(sio->link) != 2u) {                       /* 真对端在线 */
		return own;
	}
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN) {
		return own;                                            /* 只管 st>=4 之后 */
	}
	if (!sio->sioHsHoldArmed || sio->sioHsHoldLeft == 0u) {    /* 有界窗口 */
		return own;
	}
	if (!sioIsHandshakeWord((uint16_t) sio->sioRemote)) {      /* 对端已非握手⇒退出，不互锁 */
		return own;
	}
	if (GBAView32(gba->cpu, SIO_IW(SIO_GLINK_STATUS)) & LINK_STAT_MASTER) {
		return own;                                            /* 主机一个字都不能丢 */
	}
	if (sioInBlockSendPhase(sio, gba)) {                       /* 块期让位，真块字优先 */
		return own;
	}
	return LINK_HANDSHAKE_SLAVE;                               /* 真 B9A0 */
}

static uint16_t sioWordOrEmpty(struct SioLink* sio, uint16_t w) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return w ? w : 0xFFFFu;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		return w ? w : 0xFFFFu;
	}
	uint16_t held = sioHandshakeHoldWord(sio, w, gba);
	if (held != w) {
		return held;                                           /* 保持命中：推真 B9A0 */
	}
	return w;
}

/* 延迟线状态机（无 IO）。返回 true 表示本轮应当按「消费链 sioDelayWant」取字。
 *
 * 门的三个分支：
 *   state < 2  ：链路没起，什么也不做；
 *   state < 4  ：握手期 —— LinkVSync 此时不查 LAG（gen8/src/link.c:2166-2171
 *                只在 CONN_ESTABLISHED 分支查 serialIntrCounter），所以这一
 *                段可以慢；这里只打开「只推不消费」的预热，让对端队列涨到 N 深；
 *   state >= 4 ：第一轮把消费链锚到对端队首（两端各锚一次，之后每轮 +1，
 *                深度差 ≤1 可接受），此后每轮消费 sioDelayWant 这一个标签。
 * 队首为空（预热没到位）时返回 false，让调用方走原来的路径 —— 绝不在这里
 * 复用旧字、也不喂空槽。
 */
static bool sioDelayLine(struct SioLink* sio) {
	if (!sio->sioDelayInit) {
		sio->sioDelayN = sioDelayConfig();
		sio->sioDelayInit = true;
		if (sio->sioDelayN) {
			fprintf(stderr, "SIODELAY N=%u (两端必须同值；0=关闭)\n", (unsigned) sio->sioDelayN);
		}
	}
	if (!sio->sioDelayN || !sio->link) {
		return false;
	}
	unsigned st = sioGLinkState(sio);
	if (st < 4) {
		sio->sioDelayAnchored = false;
		/* 【禁止在握手期预热】曾经的"一轮推两个影子标签"会让本端标签号
		 * 以 2 倍速前进（k→2k），而对端在 state<4 仍按它自己的 sioIndex
		 * 严格匹配 want==got（netLinkTakePeerWord strict），标签号一旦
		 * 跑到它前面就被判 ahead 原地等 ⇒ 握手永远收不了尾（DELAY1 现场：
		 * 卡「请稍候」、pc 恒 0）。延迟线的本质是"消费延后"，它不能凭空
		 * 制造缓冲：缓冲只能来自对端先跑、本端后跑，而 state<4 双方都是
		 * 1:1，没有可借的余量。所以这里一律不预热。 */
		sio->sioDelayPrefill = false;
		return false;
	}
	sio->sioDelayPrefill = false;
	if (!sio->sioDelayAnchored) {
		int cnt = 0;
		unsigned head = 0;
		netLinkPeerHeadInfo(sio->link, &cnt, &head);
		if (cnt <= 0) {
			/* 预热没攒到字：本轮落回旧路径（那是唯一不会饿死的选择，
			 * 见报告：LinkVSync 的主机分支没有首帧容忍）。 */
			return false;
		}
		sio->sioDelayWant = (uint16_t) head;
		sio->sioDelayAnchored = true;
		SIO_LOG("delayline anchor head=%u q=%d N=%u", head, cnt, (unsigned) sio->sioDelayN);
	}
	return true;
}

static uint32_t readLinkOut(struct SioLink* sio, uint16_t* modeOut) {
	if (!sio->core) {
		return 0xFFFFFFFFu;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) sio->core->board;
		*modeOut = (uint16_t) gba->sio.mode;
		if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			return gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
		}
		if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			return gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
		}
		return gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	return 0xFFFFFFFFu;
}

static void completeMultiTransfer(struct SioLink* sio, uint32_t remote, bool haveRemote, uint32_t cyclesLate);
static void completeMultiTransferBus(struct SioLink* sio, const uint32_t vals[4], int players, uint32_t cyclesLate);

/* NORMAL_8 / NORMAL_32 交换计数。NORMAL_8 是**块传输（block）协议**的载体：
 * LINKUP 之后的「训练家卡片」就走这条路（gen8/src/link.c 的
 * sBlockSend/sBlockRecv + SendBlockRequest）。2026-11-16 现场读数里
 * [room] 的 rc/send 全 0 ⇒ 块交换根本没启动 ⇒ 要能分辨「游戏没发块」
 * 还是「发了没回」，先得有这两个计数。
 * 放文件级 static 而不是 struct SioLink 的字段：logLinkDiag() 只有 GBA*，
 * 拿不到 SioLink*，而 diag 是周期性快照的主要载体。 */
static uint32_t s_sioN8;
static uint32_t s_sioN32;
/* CMD-GUARD 命中轮数（logLinkDiag 只有 GBA*，与 N8/N32 同样用文件级 static） */
static uint32_t s_sioCmdGuard;
/* 任务表快照文本（logLinkDiag 只有 GBA*，同样用文件级 static） */
static char s_sioTaskBuf[96];
static void sioTaskProbe(struct GBA* gba);
static bool sioLooksLikeTasks(struct GBA* gba, uint32_t base);

static void finishIncoming(struct SioLink* sio, uint16_t mode, uint32_t remote, int player) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	if (gba->sio.mode == GBA_SIO_MULTI && (mode == GBA_SIO_MULTI || mode == 0)) {
		/* Only finish while the game is actually waiting for a transfer: Busy
		 * up (game started one) or SIO IRQ enabled (Pokemon's 0x600F wait,
		 * hardware would raise Busy). Otherwise the game is not linking and
		 * injecting a result confuses it. */
		bool busy = (gba->sio.siocnt & 0x0080) != 0;
		bool armed = (gba->sio.siocnt & 0x4000) != 0;
		if (sio->sioWaiting || !(busy || armed)) {
			return;
		}
		uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
		uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
		if (player >= 0 && player < 4) {
			data[player] = (uint16_t) remote;
		}
		if (me >= 0 && me < 4) {
			data[me] = local;
		}
		sio->sioFallback++;
		sio->sioHasRemote = true;
		sio->sioRemote = (uint16_t) (remote & 0xFFFFu);
		GBASIOMultiplayerFinishTransfer(&gba->sio, data, 0);
	} else if (gba->sio.mode == GBA_SIO_NORMAL_8) {
		/* 记下对端最近一次发来的字：GBA 的 normal 模式是**半双工数据交换**，
		 * 本端自己那次传输读到的「对端值」就是这个（见 gbaLinkFinish8/32）。 */
		sio->sioPeerLastValue = remote;
		sio->sioPeerLastValid = true;
		GBASIONormal8FinishTransfer(&gba->sio, (uint8_t) remote, 0);
	} else if (gba->sio.mode == GBA_SIO_NORMAL_32) {
		sio->sioPeerLastValue = remote;
		sio->sioPeerLastValid = true;
		GBASIONormal32FinishTransfer(&gba->sio, remote, 0);
	}
}

/**
 * 只读诊断：把 gen8 ROM 的联机对战状态变量打进 SIO 日志，用来判断游戏
 * 到底停在 CB2_HandleStartBattle 的哪个 case。地址取自 /d/gen8/rom.map，
 * 只对这个 ROM 有效；默认完全关闭，MGBAX_LINK_DIAG=1 才启用。
 * 用 GBAView16 而不是 GBALoad16，避免给模拟时钟引入额外周期。
 */
static void logLinkDiag(struct GBA* gba) {
	static int enabled = -1;
	if (enabled < 0) {
		enabled = getenv("MGBAX_LINK_DIAG") ? 1 : 0;
	}
	if (!enabled || !gba || !gba->cpu) {
		return;
	}
	uint16_t state = GBAView16(gba->cpu, SIO_EW(0x0201CFF4u)) & 0xFFu; // gBattleCommunication[MULTIUSE_STATE]
	uint16_t brs01 = GBAView16(gba->cpu, SIO_IW(0x03002A40u));          // gBlockReceivedStatus[0..1]
	uint16_t brs23 = GBAView16(gba->cpu, SIO_IW(0x03002A42u));          // gBlockReceivedStatus[2..3]
	uint16_t rem = GBAView16(gba->cpu, SIO_IW(0x03002AC0u)) >> 8;       // gReceivedRemoteLinkPlayers
	uint32_t cb = (uint32_t) GBAView16(gba->cpu, SIO_IW(0x03002AD4u))
	              | ((uint32_t) GBAView16(gba->cpu, SIO_IW(0x03002AD6u)) << 16); // gLinkCallback
	uint32_t status = (uint32_t) GBAView16(gba->cpu, SIO_IW(0x03002A9Cu))
	                  | ((uint32_t) GBAView16(gba->cpu, SIO_IW(0x03002A9Eu)) << 16); // gLinkStatus
	/* gLink @ 0x03002AF4：state +1、playerCount +3、receivedNothing +0xC、
	 * serialIntrCounter +0xD、lag +0x13、sendCmdIndex +0x16、recvCmdIndex +0x17。 */
	uint16_t l0 = GBAView16(gba->cpu, SIO_IW(0x03002AF4u));
	uint16_t l1 = GBAView16(gba->cpu, SIO_IW(0x03002AF6u));
	uint16_t l2 = GBAView16(gba->cpu, SIO_IW(0x03002B00u));
	uint16_t l3 = GBAView16(gba->cpu, SIO_IW(0x03002B06u));
	uint16_t l4 = GBAView16(gba->cpu, SIO_IW(0x03002B0Au));
	/* LINKUP 结果码（/d/gen8/rom.map）：gSpecialVar_Result=0x020219AC，
	 * gLinkType=0x02027BB2，gWirelessCommType=0x03002AAD。
	 * 常量见 include/constants/cable_club.h：0=进行中 1=成功
	 * 3=两端选择不同 4=人数不对 7/9=有玩家未准备好 6=连接错误。
	 * 打出来才能区分「按 A 时机不对」和「两端选了不同项目」。 */
	uint16_t linkup = GBAView16(gba->cpu, SIO_EW(0x020219ACu));
	uint16_t ltype = GBAView16(gba->cpu, SIO_EW(0x02027BB2u));
	uint8_t wireless = GBAView8(gba->cpu, SIO_IW(0x03002AADu));
	/* 联机菜单判定（完全基于游戏内存，不依赖 GL 窗口抓图）。
	 * struct Menu（menu.c 的 sMenu，符号大小 12）：left(+0) top(+1)
	 *   cursorPos(+2) minCursorPos(+3) maxCursorPos(+4) windowId(+5) …
	 * 2026-11-16 修正：struct Menu 的基址随 EWRAM 整体上移 0x30 ⇒ 基址
	 *   0x020296F0（cursorPos=+2 → 0x020296F2、maxCursorPos=+4 → 0x020296F4）。
	 *   旧常量 0x020296C0 那一组里，cursorPos/maxCursorPos 已经被 +0x30 改过，
	 *   **minCursorPos / windowId 却漏了**（仍读 0x020296C3 / 0x020296C5），
	 *   于是 [diag] 的 menu=c/mi/ma/w 里 mi 与 w 一直是垃圾字节。
	 * gTasks @0x02033D0C，sizeof(struct Task)=0x28（func4 + 4 个 u8 +
	 * s16 data[16]）；Task_HandleMultichoiceInput @0x081BB614（Thumb 指针
	 * 带 bit0），其 data[7]=tMultichoiceId、data[6]=tWindowId。
	 * 常量 /d/gen8/include/constants/script_menu.h：74/76/77/78/79 是
	 * 有线/无线俱乐部服务菜单，18 是「单打/双打/多人」模式菜单。
	 * 有了这些字段，脚本能确定地判断 PC 是否停在菜单、光标在第几项、
	 * 有没有把 DOWN 吃掉，而不是靠抓不到的 PrintWindow 画面猜。 */
	uint8_t mCursor = GBAView8(gba->cpu, SIO_EW(0x020296F2u));
	uint8_t mMin = GBAView8(gba->cpu, SIO_EW(0x020296F3u));
	uint8_t mMax = GBAView8(gba->cpu, SIO_EW(0x020296F4u));
	uint8_t mWin = GBAView8(gba->cpu, SIO_EW(0x020296F5u));
	int mTask = -1;
	int mChoice = -1;
	for (int i = 0; i < 16; ++i) {
		uint32_t slot = SIO_EW(0x02033D0Cu) + (uint32_t) i * 0x28u;
		uint32_t fn = (uint32_t) GBAView16(gba->cpu, slot)
		              | ((uint32_t) GBAView16(gba->cpu, slot + 2u) << 16);
		if (!GBAView8(gba->cpu, slot + 4u)) {
			continue;
		}
		if ((fn & ~1u) == SIO_CODE(0x081BB614u)) {
			mTask = i;
			mChoice = (int16_t) GBAView16(gba->cpu, slot + 8u + 14u);
			break;
		}
	}
	/* 玩家格坐标：gSaveBlock1Ptr @0x03004964 → struct SaveBlock1 { Coords16 pos; }，
	 * pos.x 在 +0、pos.y 在 +2。走位改成闭环导航全靠它 —— 盲按方向键在锁步
	 * 低帧率下频繁丢输入，扫十几次也踩不到座位。 */
	uint32_t sb1 = GBAView32(gba->cpu, SIO_IW(0x03004964u));
	int16_t px = 0, py = 0;
	if (sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE) {
		px = (int16_t) GBAView16(gba->cpu, sb1 + 0u);
		py = (int16_t) GBAView16(gba->cpu, sb1 + 2u);
	}
	/* 链路角色（gen8 struct Link @0x03002AF4）：
	 *   +0 isMaster（0=从机 / 8=主机）、+1 state、+2 localId、+3 playerCount、
	 *   +0xE handshakeAsMaster。
	 * 这四个字段决定「谁是主机」，而主机选举失败 = 握手永远收不了尾
	 * （gen8/src/link.c:2057 CheckMasterOrSlave 要 SIOCNT 的 bit2 清/bit3 置
	 *  且 localId==0；:1980 要 isMaster==8 && playerCount>1 &&
	 *  shouldAdvanceLinkState 才把 handshakeAsMaster 置真）。
	 * 2026-11-16 加进 [diag]：现场读到两端 st(gLinkStatus)=0 ⇒ isMaster≠8、
	 * playerCount=0，但之前 diag 里**看不到**是哪一个条件不满足。 */
	uint8_t lkIsMaster = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u);
	uint8_t lkLocalId = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x02u);
	uint8_t lkHs = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Eu);
	/* REG_SIOCNT 要从 gba->sio.siocnt 读（那是游戏真正看到的寄存器）；
	 * 0x04000128 那条是 IO 区，0x03000128 是 IWRAM 里无关的变量（踩过）。 */
	uint16_t siocnt = gba->sio.siocnt;
	sioTaskProbe(gba);
	SIO_LOG("[diag] mu=%u brs=%04X/%04X rem=%u cmdguard=%u cb=%08X st=%08X eb=%08X keys=%03X"
	        " lstate=%u pc=%u intr=%u ridx=%u sidx=%u lag=%u rn=%u qf=%u"
	        " linkup=%u ltype=%u wl=%u px=%d py=%d"
	        " menu=c%u/%u/%u/w%u mt=%d mid=%d"
	        " role=im%u/lid%u/hs%u sc=%04X/%u n8=%u n32=%u b8=%02X/%02X rdy=%u/%u/%u/%u rq=%u save=%u tasks=%s",
	        state, brs01, brs23, rem, (unsigned) s_sioCmdGuard, cb, status,
	        /* sLinkErrorBuffer.status@0x02027CEC：CheckErrorStatus() 在拆链前
	         * 把当时的 gLinkStatus 存进这里，是「究竟是哪一个错误位」的唯一
	         * 事后证据（diag 一秒一次，抓不到瞬时值）。 */
	        GBAView32(gba->cpu, SIO_EW(0x02027CECu)),
	        (unsigned) (gba->keysActive & 0x3FF),
	        (l0 >> 8) & 0xFF, (l1 >> 8) & 0xFF, (l2 >> 8) & 0xFF,
	        l4 & 0xFF, (l4 >> 8) & 0xFF, (l3 >> 8) & 0xFF, l2 & 0xFF, l3 & 0xFF,
	        (unsigned) linkup, (unsigned) ltype, (unsigned) wireless,
	        (int) px, (int) py,
	        (unsigned) mCursor, (unsigned) mMin, (unsigned) mMax, (unsigned) mWin,
	        mTask, mChoice,
	        (unsigned) lkIsMaster, (unsigned) lkLocalId, (unsigned) lkHs,
	        (unsigned) siocnt, (unsigned) (siocnt >> 2) & 0x3u,
	        (unsigned) s_sioN8, (unsigned) s_sioN32,
	        GBAView8(gba->cpu, SIO_IW(0x03002A40u)), GBAView8(gba->cpu, SIO_IW(0x03002A41u)),
	        GBAView8(gba->cpu, SIO_IW(0x03002AA2u)),
	        GBAView8(gba->cpu, SIO_IW(0x03002AA3u)),
	        GBAView8(gba->cpu, SIO_IW(0x03002AA4u)),
	        GBAView8(gba->cpu, SIO_IW(0x03002AA5u)),
	        GBAView16(gba->cpu, SIO_IW(0x03003AB4u)),
	        GBAView8(gba->cpu, SIO_IW(0x03002AAEu)),
	        s_sioTaskBuf);
	/* 联机房间按键码握手（overworld.c / link.c）：
	 * sPlayerTradingStates[4] 每一端都保存所有玩家状态，0x82=UNK_2 表示已准备好，
	 * sub_8087214() 要求所有玩家都是 0x82 才会切到 Task_StartWiredCableClubBattle。 */
	uint16_t ts01 = GBAView16(gba->cpu, SIO_IW(0x03004A10u));
	uint16_t ts23 = GBAView16(gba->cpu, SIO_IW(0x03004A12u));
	uint32_t intercept = (uint32_t) GBAView16(gba->cpu, SIO_IW(0x03004A14u))
	                     | ((uint32_t) GBAView16(gba->cpu, SIO_IW(0x03004A16u)) << 16);
	uint16_t hk = GBAView16(gba->cpu, SIO_IW(0x03004A2Cu));   // gHeldKeyCodeToSend
	uint16_t lidcnt = GBAView16(gba->cpu, SIO_IW(0x03004A38u)); // localId, fieldLinkPlayerCount
	uint16_t sendCmd = GBAView16(gba->cpu, SIO_IW(0x03002AB0u));
	uint16_t sendKey = GBAView16(gba->cpu, SIO_IW(0x03002AB2u));
	uint16_t transferring = GBAView16(gba->cpu, SIO_IW(0x03004974u));
	/* gMain.callback2 是 32 位指针，必须一次读 32 位。
	 * 2026-11-16 修正：这里原来拆成两个 16 位读 —— 低半 0x02029118
	 * （gMain @0x02029114 + 4）对，高半 0x020290EA **错**（那还是 EWRAM
	 * 整体上移 0x30 之前的地址，且比低半还低 0x2E）。后果是 [room] 的
	 * cb2 高半永远是 0：实测真实 gMain.callback2 = 0x08188981
	 * （CB2_Overworld），而 [room] 打出来是 0x00008981。
	 * 这个字段是脚本判定「进没进游戏」的输入（cb2=0816F9C5 = 俱乐部柜台），
	 * 高半被削掉之后脚本永远匹配不上。 */
	uint32_t cb2 = GBAView32(gba->cpu, SIO_CB2_PTR);
	uint16_t pk0 = GBAView16(gba->cpu, SIO_IW(0x030029E2u));
	uint16_t pk1 = GBAView16(gba->cpu, SIO_IW(0x030029E4u));
	uint16_t rc0 = GBAView16(gba->cpu, SIO_IW(0x03002A4Au));
	uint16_t rc0k = GBAView16(gba->cpu, SIO_IW(0x03002A4Cu));
	uint16_t rc1 = GBAView16(gba->cpu, SIO_IW(0x03002A5Au));
	uint16_t rc1k = GBAView16(gba->cpu, SIO_IW(0x03002A5Cu));
	SIO_LOG("[room] ts=%02X/%02X/%02X/%02X ic=%08X hk=%04X lid=%u cnt=%u"
	        " send=%04X/%04X tr=%04X cb2=%08X pk=%04X/%04X rc=%04X:%04X,%04X:%04X",
	        ts01 & 0xFF, ts01 >> 8, ts23 & 0xFF, ts23 >> 8,
	        intercept, hk, lidcnt & 0xFF, lidcnt >> 8,
	        sendCmd, sendKey, transferring, cb2, pk0, pk1, rc0, rc0k, rc1, rc1k);
}

/**
 * 有线俱乐部 standby 卡死的运行时适配（默认关闭，MGBAX_LINK_UNSTICK=1 启用）。
 *
 * gen8 的 SetLinkStandbyCallback() 只在 gLinkCallback == NULL 时才安装
 * LinkCB_Standby；网络链路上这个回调常驻 LinkCB_SendHeldKeys，于是
 * IsLinkTaskFinished() 永远为 false，游戏停在「等待连接」不进 CB2_InitBattle。
 * 这里在精确命中该卡死状态时代游戏把回调换成它自己的 LinkCB_Standby，
 * 保留游戏的 gLastRecvQueueCount 门控，让双端 standby 握手按原时序跑完。
 * 不改 ROM、不改游戏逻辑、只写一次 IWRAM 的 4 字节函数指针。
 */
static int unstickEnabled(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_LINK_UNSTICK");
		enabled = (v && v[0] == '1') ? 1 : ((v && v[0] == '2') ? 2 : 0);
	}
	return enabled;
}

static void maybeUnstickStandby(struct GBA* gba) {
	static int done = 0;
	static int streak = 0;
	int mode = unstickEnabled();
	if (done || !mode || !gba || !gba->cpu) {
		return;
	}
	uint16_t l0 = GBAView16(gba->cpu, SIO_IW(0x03002AF4u));          // isMaster, state
	uint16_t rem16 = GBAView16(gba->cpu, SIO_IW(0x03002AC0u));       // rem at +1
	uint16_t cbLo = GBAView16(gba->cpu, SIO_IW(0x03002AD4u));
	uint16_t cbHi = GBAView16(gba->cpu, SIO_IW(0x03002AD6u));
	uint32_t cb = (uint32_t) cbLo | ((uint32_t) cbHi << 16);
	uint16_t mu = GBAView16(gba->cpu, SIO_EW(0x0201CFF4u)) & 0xFFu;   // gBattleCommunication[MULTIUSE_STATE]
	uint16_t brs = GBAView16(gba->cpu, SIO_IW(0x03002A40u));
	int state = (l0 >> 8) & 0xFF;
	int rem = (rem16 >> 8) & 0xFF;
	if (state == 4 && rem == 1 && cb == SIO_CODE(0x08151DA9u) && mu == 0 && brs == 0) {
		if (++streak >= 3) {
			/* mode 1: 换成游戏自带的 LinkCB_Standby，走完双端 standby 握手；
			 * mode 2: 直接置 NULL，让 IsLinkTaskFinished() 立即成立 ——
			 * SendBlock 会自己装 LinkCB_BlockSend*，战斗流程不依赖 standby。 */
			uint32_t target = (mode == 2) ? 0x00000000u : SIO_CODE(0x081529BDu);
			gba->memory.iwram[(SIO_IW(0x03002AD4u) - GBA_IWRAM_BASE) >> 2] = target;
			done = 1;
			SIO_LOG("[unstick] mode=%d cb %08X -> %08X (state=%d rem=%d mu=%u)",
			        mode, cb, target, state, rem, mu);
		}
	} else {
		streak = 0;
	}
}

/* 跨端统一的 rearm 开关读法：默认开，仅显式 =0 关闭。
 * 抽成函数是为了让启动诊断（sioLinkCreate 的 [MGBAX_GATE] 行）与实际门控
 * 读同一个值，避免两处漂移。ENV-REGISTRY D1：Qt/mobile/driver 三方默认值
 * 此前不一致，2026-11-17 统一为开（driver 的 force-ON 保持一致）。 */
static int rearmEnabledFromEnv(void) {
	const char* v = getenv("MGBAX_LINK_REARM");
	return (v && v[0] == '0') ? 0 : 1;
}

/**
 * 联机房间握手「主从选举」补触发（**默认开启**，MGBAX_LINK_REARM=0 才关）。
 *
 * gen8 的 LinkMain1 只在 gShouldAdvanceLinkState==1 的那一帧做一次主从选举
 * （Task_TriggerHandshake 在 OpenLink 后第 5 帧把它置 1），并且要求那一瞬间
 * gLink.playerCount > 1。局域网/网络联机时两端进房间必然相差几十帧以上，
 * 主机端选举时对方还没出现，于是两端都退化成从机、都只发从机握手字 0xB9A0，
 * DoHandshake() 永远等不到 0x8FFF，双端永久卡在「等待连接」画面。
 * 这里在「双方已连上(playerCount>=2)、仍在握手态(state==2)、但还没选出主机
 * (handshakeAsMaster==0)」时，代游戏把 gShouldAdvanceLinkState 置 1，
 * 让它重新做一次选举。只写 IWRAM 的 1 个字节标志，不改 ROM。
 *
 * 【为什么默认关 —— 实测证据：补触发与链路崩溃同一拍】
 * `handshakeAsMaster` 的唯一合法入口是玩家在「准备完毕？」确认框按 A
 * （cableclub 299-305 → link.c 1985-1989），而 `DoHandshake` 每调用一次就把
 * 这个标记清回 0（link.c 2266）。代游戏置 `gShouldAdvanceLinkState` 等于**绕过
 * 玩家的 A 确认**，把选举时机跟游戏脚本搅在一起：A 侧实测 `[rearm] handshake
 * election retriggered (players=2)` 与链路崩溃落在同一拍，紧接着就是
 * `CpuFill32(&gLink)` 的特征（lstate 1 pc 0 intr 0 linkup=6）。
 * 结果只是把卡点从 state 2 挪到 state 4 的 LAG 判定上，并没有救回来。
 * 【以上为历史记录：当时据此把默认改为关。】
 *
 * 【2026-11-17 跨端统一：默认改为开】ENV-REGISTRY D1 指出 Qt=关 / mobile=开 /
 * driver=开 三方冲突，vanilla PC 与 vanilla Android 同房会一端永不发 0x8FFF。
 * rearm 已由 agent 1/2 重写为「每轮补 handshakeAsMaster + netLinkState/state/
 * players/isMaster 多重门，选举开关仍限次 3」（见下方实现），且 driver 每次
 * 受控 2P 实跑本就强制 =1；把产品默认对齐到开，只让 vanilla 应用表现与已在
 * 跑的 driver 实跑一致，不新增代码路径。仅显式 MGBAX_LINK_REARM=0 才关闭
 * （A/B 对照用）。残留风险：历史 state-2 崩溃无「已修」证据，见
 * production/sprint-2p/CRASH-C0000005-AUDIT.md；本路径仍受 state==2 门限制。
 *
 * 【门的判据也改过：原来看 isMaster==8，那会自锁】
 * 两侧都退化成从机时 isMaster 都是 0，旧代码直接 return，补触发永远不执行。
 * 现在改为「链路 1P（netLinkPlayer()==0）且 isMaster != 8」也放行 —— 开关
 * 默认开后这个分支会走到，仍可用 `=0` 做 A/B 对照来回退验证
 * 「两侧都当从机」这个形态。从机侧（player!=0）行为不变。
 *
 * 次数上限 3：补触发是「代游戏按一下选举开关」，按一次不生效说明问题不在
 * 时机之外，再按只会刷日志。上限内的每次触发都记 n。
 */
/* 【standby 死结：把 gLinkCallback 直接置 NULL 2026-11-17 01:1x】
 *
 * 现场（SNAP1，两端一致）：`gTasks` 里活跃的就是
 *   task[0] = Task_WeatherInit
 *   task[1] = Task_ReturnToFieldWirelessLink      ← 卡在这一步
 * 而它在 `field_screen_effect.c:189` 的 case 1 里等：
 *     if (!IsLinkTaskFinished()) { if (++data[1] > 1800) GetLinkmanErrorParams(0x6000); }
 * 其中 `IsLinkTaskFinished()`（gen8 `link.c:1084`）在有线模式下就是
 *     return gLinkCallback == NULL;
 * ⇒ 只要 `gLinkCallback` 一直非空，这个任务就永远过不去，于是：
 *     · 后面的 `WarpFadeInScreen()` / `ScriptContext2_Disable()` 都不执行
 *       ⇒ 场地仍被脚本锁着 ⇒ START 打不开菜单、方向键走不动（实测 px/py 不动）；
 *     · 1800 帧（约 30 秒）后 `GetLinkmanErrorParams(0x6000)` ⇒ 「通信错误」。
 * 正好解释用户报的两个现象。
 *
 * 我们已经在链路侧把两端锁到逐拍一致（SYNCIDX/ESTGATE/LOCKPHASE/IDXDELIVER），
 * 而且块交换已双向完成（gBlockReceivedStatus 两个字节都是 1），standby 握手
 * 这一步在网络链路上没有额外作用，只有副作用（常驻 LinkCB_SendHeldKeys 让
 * gLinkCallback 永不为空）。所以这里直接把 gLinkCallback 清零，让
 * IsLinkTaskFinished() 立刻成立，任务继续走 case 2 解锁场地。
 *
 * 门（都走自动偏移，换 ROM 不用改）：
 *   state==4（已 LINKUP）、rem==1（双向收到对手）、
 *   gBlockReceivedStatus 的 bit0/bit1 都是 1（块交换完成）、
 *   gLinkCallback != 0。
 * 一次性，最多 3 次。开关 MGBAX_UNSTICK2=1（默认关）。 */
/* 【standby 0x2FFE 受控注入 2026-11-17 15:2x】
 *
 * 最后一道坎：两端都在 `LinkCB_StandbyForAll` 等 `gReadyToExitStandby[0..1]`
 * 全 TRUE 才会 `gLinkCallback=NULL` ⇒ `IsLinkTaskFinished()` 成立 ⇒ 进战斗。
 * 而该标志只由**收到对端的 0x2FFE**（LINKCMD_READY_EXIT_STANDBY）置位：
 *     link.c:633  case LINKCMD_READY_EXIT_STANDBY: gReadyToExitStandby[i]=TRUE;
 * SBY2 实测 A 的 rdy=1/0/0/0 —— 玩家0(本机)已 ready、玩家1(对端)没有，
 * 说明对端那发 0x2FFE 没到/没被计入。
 *
 * 补法：门控只依赖**结构状态**（不依赖会随 ROM 平移的 cb 函数地址）：
 *     state==4 && rem==1 && 有玩家数但 ready 位有缺口 && cb!=0
 * 每 120 tick 写一次 `gSendCmd[0]=0x2FFE`（BuildSendCmd 对这条命令只写第 0 字），
 * 最多 8 次。两端同时跑即可把对方的 ready 位补齐。
 * 基准地址写旧构建值、运行时由 SIO_IW() 自动加 delta（换 ROM 不用改）。
 * 开关 MGBAX_STANDBY_FIX=1（默认关）。 */
static void sioStandbyInject(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_STANDBY_FIX");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu || sio->sioStandbySent >= 20u) {
		return;
	}
	unsigned state = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 1u);
	unsigned rem = GBAView8(gba->cpu, SIO_IW(0x03002AC1u));
	uint32_t cb = GBAView32(gba->cpu, SIO_IW(0x03002AD4u));
	if (state != 4u || rem != 1u || cb == 0u) {
		sio->sioStandbyTick = 0;
		return;
	}
	/* gReadyToExitStandby[0..3]：旧构建基准 0x03002AA2..A5（真实=基准+delta） */
	unsigned rdy0 = GBAView8(gba->cpu, SIO_IW(0x03002AA2u));
	unsigned rdy1 = GBAView8(gba->cpu, SIO_IW(0x03002AA3u));
	/* 注意：不能因为"本端 rdy 全齐"就停 —— 本端集齐只说明收到了对端的
	 * 0x2FFE；对端是否集齐取决于它有没有收到**我们**的 0x2FFE，本端看不到。
	 * SBY3 实测 B 集齐后早退（只发 2 次），A 的 rdy1 就一直补不齐。
	 * 所以持续发到上限，让两端都收到足够多次。 */
	if (++sio->sioStandbyTick < 120u) {
		return;
	}
	sio->sioStandbyTick = 0;
	GBAPatch16(gba->cpu, SIO_IW(0x03002AB0u), (int16_t) 0x2FFE, NULL);
	++sio->sioStandbySent;
	SIO_LOG("[standbyfix] n=%u 补发 0x2FFE rdy=%u/%u cb=%08X",
	        (unsigned) sio->sioStandbySent, rdy0, rdy1, (unsigned) cb);
}

static void maybeClearLinkCallback(struct SioLink* sio) {
	static int enabled = -1;
	static int done;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_UNSTICK2");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || done || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	unsigned state = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 1u);
	unsigned rem = GBAView8(gba->cpu, SIO_IW(0x03002AC1u));
	unsigned blk0 = GBAView8(gba->cpu, SIO_IW(0x03002A40u));
	unsigned blk1 = GBAView8(gba->cpu, SIO_IW(0x03002A41u));
	uint32_t cb = GBAView32(gba->cpu, SIO_IW(0x03002AD4u));
	if (state != 4u || rem != 1u || blk0 != 1u || blk1 != 1u || cb == 0u) {
		return;
	}
	if (!sioLooksLikeTasks(gba, SIO_EW(0x02033D0Cu))) {
		return;   /* 自检：gTasks 读不出正常任务结构就别写 */
	}
	GBAPatch32(gba->cpu, SIO_IW(0x03002AD4u), 0, NULL);
	done = 1;
	SIO_LOG("[unstick2] cb %08X -> 0 (state=%u rem=%u blk=%u/%u) 让 "
	        "IsLinkTaskFinished() 成立，解锁场地", cb, state, rem, blk0, blk1);
}

/* 迭代 35：战斗启动区（BattleMainCB2 末尾之前）禁止 rearm/强制握手，
 * 与移动端 mobileInBattleStartup 对称。 */
static bool sioInBattleStartup(struct SioLink* sio) {
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* ROOTHUNT2 S1（与 mobile 对称）：真 LINK 战关链后 cb2=080B376D(lo+0x6AD)
	 * 落在原放行空档，rearm 误触发 → 通信错误屏卡死。扩禁段覆盖整个战斗窗口
	 * [lo+0x4D, lo+0x17E8)；真关链后重握手在 cable club 阶段(cb2=0818xxxx)，
	 * 不在本窗口，天然放行（迭代 56 意图保留）。 */
	return cb2 >= SIO_BATTLE_LO() + BATTLE_STARTUP_LO_OFF
	    && cb2 < SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF;
}
static bool sioInClosePhase(struct SioLink* sio) {
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	return cb2 >= SIO_BATTLE_LO() + BATTLE_STARTUP_LO_OFF
	    && cb2 < SIO_BATTLE_LO() + BATTLE_CLOSE_INIT_END;
}

static void maybeRearmHandshake(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		enabled = rearmEnabledFromEnv();
	}
	if (!enabled || !sio || !sio->core) {
		return;
	}
	if (sioInBattleStartup(sio)) {
		return;   /* 战斗启动区不 rearm */
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	/* 链路没连上时 netLinkPlayer() 缺省返回 0，不能据此认定"本端是 1P"去
	 * 代游戏选举 —— 那会在单机/断线重连窗口里凭空补触发。 */
	if (netLinkState(sio->link) != 2) {
		return;
	}
	int me = netLinkPlayer(sio->link);
	/* 逐字节读 struct Link：+0 isMaster、+1 state、+3 playerCount、+0x0E
	 * handshakeAsMaster。（注意不能从 uint16 里右移 24 位取 playerCount，
	 * 那样恒为 0。） */
	int isMaster = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u);
	int state = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	int players = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u);
	int hs = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Eu);       // handshakeAsMaster
	if (state != 2) {
		return;
	}
	/* 【2026-11-17 BLK-H1 修复：删掉「必须先收到对端字」的门 —— 它本身就是死锁】
	 * 旧门（13:15 引入）在 players<2 时要求 peerPending>0 或 wIn>0 才补
	 * handshakeAsMaster。但真实跨设备卡死现场恰好相反：本端不发 0x8FFF ⇒
	 * DoHandshake 收不了尾 ⇒ 游戏不再写 SIOCNT 起轮 ⇒ intr=0 / pushRecv=0
	 * ⇒ 旧门判「对端没推字，不是真 2P」而 return ⇒ 永不补 hs ⇒ 永不发
	 * 0x8FFF。Agent 11 实测：MGBAX_LINK_REARM=1，1562 行 [diag] 全为
	 * lstate=2 pc=0 intr=0 rem=0 n8=0，rearm fired=0 hs1=0 rounds=0。
	 * 上面的 netLinkState()==2 已证明网络层连着真对端，这里 state==2 又证明
	 * 游戏确实在握手态 —— 两者同时成立即足够。pushRecv 只是「握手是否已经
	 * 成功」的后果，拿结果当前提就是循环依赖。单机/断线由 netLinkState()!=2
	 * 挡掉，不需要再借 pushRecv 判断。 */
	/* 迭代 57：回退"从机也补 handshakeAsMaster"——三轮实测必现失败。
	 * gen8 语义里 handshakeAsMaster 是主机标志，从机设它只会让 DoHandshake
	 * 自己发主握手字、破坏 B9A0 收尾。从机卡 state2 的真因是 playerCount=0
	 * （tempRecvBuffer[0] 不是 8FFF），在 finishMultiTransfer 的 SIO 字层修。 */
	if (isMaster != 8 && me != 0) {
		static unsigned slN;
		if ((++slN & 0x7Fu) == 1) {
			SIO_LOG("[rearm] slave skip (hs stays 0) isMaster=%d me=%d players=%d state=%d",
			        isMaster, me, players, state);
		}
		return;
	}
	/* 【2026-11-16 关键修正】handshakeAsMaster **每轮**都要补。
	 * 游戏的 DoHandshake() 每轮都会把它清掉（gen8/src/link.c:2268
	 * `gLink.handshakeAsMaster = FALSE;`），而它决定主机这一轮往 SIOMLT_SEND
	 * 写 MASTER_HANDSHAKE(0x8FFF) 还是 SLAVE_HANDSHAKE(0xB9A0)。
	 * 旧实现只在「每 64 轮」的采样点补一次 ⇒ 主机 62/63 的轮次发的是
	 * **从机握手字**，对端的收尾条件
	 * （link.c:2289 `tempRecvBuffer[0] == MASTER_HANDSHAKE`）几乎永远不成立
	 * ⇒ 握手永远差最后一步。现场读数（PA8/PA9）：主机侧 256 轮全是
	 * `data=B9A0,B9A0,FFFF,FFFF` 且 `hs=0`。
	 * ⇒ 现在每轮补一次（游戏下一轮会自己清掉，正好是一轮一清）。 */
	{
		uint32_t hsAddr = SIO_IW(0x03002AF4u) + 0x0Eu; /* gLink.handshakeAsMaster */
		uint32_t wIdx = (hsAddr - GBA_IWRAM_BASE) >> 2;
		uint32_t bShift = ((hsAddr - GBA_IWRAM_BASE) & 3u) * 8u;
		gba->memory.iwram[wIdx] = (gba->memory.iwram[wIdx] & ~(0xFFu << bShift))
		                       | (1u << bShift);
	}
	/* 选举开关（gShouldAdvanceLinkState）仍然限次 3 次：那是「代游戏按一下
	 * 选举开关」，按一次不生效说明问题不在时机，再按只会刷日志。
	 * 【13:18 修正】限次**只能**管选举开关，绝不能顺手把每轮的
	 * handshakeAsMaster 补位一起卡死：PUREBLOCK2 现场显示补到第 3 轮就
	 * 停，其后主机又发回 B9A0，从机一度收到 8FFF 却等不到收尾（A 自槽
	 * m0=FFFF、pc 恒 0）。 */
	static unsigned rearmN;
	if (rearmN < 3) {
		/* gShouldAdvanceLinkState @ 0x03002AD8：只置最低字节的最低位，
		 * 同字其余字节原样保留。 */
		uint32_t idx = (SIO_IW(0x03002AD8u) - GBA_IWRAM_BASE) >> 2;
		gba->memory.iwram[idx] |= 0x00000001u;
		++rearmN;
		SIO_LOG("[rearm] fired n=%u me=%d isMaster=%d hs=%d players=%d (hs set)",
		        rearmN, me, isMaster, hs, players);
	}
	/* 机器可读证据：每 64 轮打一行，证明 handshakeAsMaster **每轮**都被补成 1
	 *（游戏的 DoHandshake 每轮会自己清掉）。下一次跑对照 SLOT 的 m0=8FFF（主机
	 * 自槽）与从机 m1=B9A0，就能确认「rearm 每轮补 hs ⇒ 主机发主握手字」。 */
	{
		static unsigned hsTick;
		if ((++hsTick & 0x3F) == 1) {
			int hsNow = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Eu);
			SIO_LOG("[rearm] round n=%u me=%d isMaster=%d state=%d players=%d hs=%d",
			        hsTick, me, isMaster, state, players, hsNow);
		}
	}
}

/* 四槽凑齐之后的公共收尾：耗时统计、诊断日志、写 SIOMULTI、发 SIO 中断。
 * 两人直连和 3/4 人总线都汇到这里，诊断口径保持一致。 */
static void finishMultiTransfer(struct SioLink* sio, uint16_t data[4], uint32_t cyclesLate) {
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	struct mTiming* timing = coreTiming(sio);
	/* 本轮是否由主机起轮：每个收尾都取一次并清零，保证日志里的 mst 说的是
	 * 「刚收尾的这一轮」，而不是"很久以前有过一轮主机起轮"。 */
	bool roundMaster = sio->sioRoundMaster;
	sio->sioRoundMaster = false;
	if (timing) {
		uint32_t spent = mTimingCurrentTime(timing) - sio->sioStartCycle;
		uint32_t tenth = spent / 1677 + ((spent % 1677) ? 1 : 0);
		sio->sioLateness = tenth;
		if (tenth > sio->sioPeak) {
			sio->sioPeak = tenth;
		}
	}
	sio->sioOk++;
	sio->sioBusyCycle = 0;
	sio->sioStashValid = false;
	/* 【11-16 TR】逐转移追踪游戏的 9 轮状态机（上限 1600 行，MGBAX_TR=1）。
	 * 字段含义（gLink @0x03002AF4）：
	 *   lst/pc = state(+0x01)/playerCount(+0x03)
	 *   lag    = +0x13（1=LAG_MASTER，从机 2=LAG_SLAVE）—— 主机一旦被置
	 *            LAG_MASTER，LinkVSync 的 `else if (lag != LAG_MASTER)` 就再也
	 *            不起轮 ⇒ 永久停摆 ⇒ CheckErrorStatus 拆链
	 *   sic    = +0x0D serialIntrCounter（主机要求 >=9 才起下一轮；握手结束时
	 *            游戏自己设成 8，所以进入 state4 后的**第一个 VBlank** 必然
	 *            看到 8<9 → 置 LAG_MASTER。这是本轮要证实/证伪的假设）
	 *   sc/rc  = +0x16/+0x17 sendCmdIndex/recvCmdIndex（0..8 循环）
	 *   sqc/sqp/rqc/rqp = 收发环形队列的 count/pos
	 *   cb     = gLinkCallback（0=空；恒定为某值 ⇒ 回调链卡住）
	 *   rr*    = 本次 FinishTransfer **之前** SIOMLT_RECV0..3 的实际内容，
	 *            用来对齐"我们投递的 d*"与"游戏读到的 rr*"是否一致 */
	{
		static int trLeft = -1;
		if (trLeft < 0) {
			const char* v = getenv("MGBAX_TR");
			trLeft = (v && atoi(v) == 1) ? 1600 : 0;
		}
		if (trLeft > 0) {
			--trLeft;
			unsigned lst = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
			SIO_LOG("TR n=%u me=%d im=%d lid=%u lst=%u pc=%u lag=%u adv=%u lb=%u sic=%d sc=%u rc=%u sqc=%u sqp=%u rqc=%u rqp=%u ck=%04X cb=%08X hs=%u se=%u sne=%u rne=%u w0=%04X w=%04X d=%04X,%04X rr=%04X,%04X,%04X,%04X",
			        (unsigned) sio->sioOk, me,
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x02u),
			        lst,
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x13u),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AD8u)),
			        (unsigned) sio->sioRoundLabel,
			        (int) (int8_t) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Du),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002E2Du)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002E2Cu)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03003AB1u)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03003AB0u)),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002B08u)),
			        GBAView32(gba->cpu, SIO_IW(0x03002AD4u)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Eu),
			        /* se=sSendBufferEmpty(0x030029DA)：TRUE 时 DoSend 一律发 0；
			         * sne/rne=sSend/RecvNonzeroCheck；w0=sendQueue.data[0][pos]
			         * （gLink+0x18+pos*2）：队首命令字的 opcode，看 0x2222 到底在不在。 */
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x030029DAu)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x030029DCu)),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x030029DEu)),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002B0Cu)
			                             + (uint32_t) GBAView8(gba->cpu, SIO_IW(0x03002E2Cu)) * 2u),
			        (unsigned) gba->memory.io[GBA_REG(SIOMLT_SEND)],
			        data[0], data[1],
			        (unsigned) GBAView16(gba->cpu, SIO_REG_SIOMLT_RECV0),
			        (unsigned) GBAView16(gba->cpu, SIO_REG_SIOMLT_RECV1),
			        (unsigned) GBAView16(gba->cpu, SIO_REG_SIOMLT_RECV2),
			        (unsigned) GBAView16(gba->cpu, SIO_REG_SIOMLT_RECV3));
			(void) lst;
		}
	}
	/* 四槽载荷抽样：这就是游戏的**命令通道**内容（gen8 的
	 * gRecvCmds[] 来自 SIOMLT_RECV0..3）。握手阶段各槽是 0x8FFF/0xB9A0，
	 * 握手之后主机槽会变成 LINKCMD_SEND_LINK_TYPE（带 linkType 的命令字）。
	 * 2026-11-16 现场：PA4 主机侧 linkup=1（SUCCESS）而从机侧 linkup=0
	 * （ONGOING，即 600 帧超时），所以「从机有没有收到主机的命令字」是
	 * 下一个必须能一眼看出的事实 —— 这里把每轮四槽都打出来（前 48 轮 + 每 64 轮）。 */
	if (sio->sioOk <= 48 || (sio->sioOk & 0x3F) == 0) {
		/* sq/w 是「SerialCB 执行前」的 sendCmdIndex 与 SIOMLT_SEND：
		 * 它们反映**上一轮** DoSend 有没有跑、写了什么字。两端握手成功后
		 * 若 cmd 切换存在相位差，这里能一眼看出谁先 DoSend、谁还在发握手字
		 * （2026-11-16 定位 linkup=6 的插桩）。 */
		/* st=dw gLinkStatus（bit5=MASTER 0x20 / bit6=CONN 0x40）决定主机
		 * `LinkCB_RequestPlayerDataExchange` 会不会 BuildSendCmd(2222)；
		 * cq=sendQueue.count@+0x321、c0=sendQueue.data[0][0]@sendQueue 起址
		 * 直接显示 2222 有没有入队。用来定案「主机 sq=0」是没 MASTER 位
		 * 还是没入队命令字（2026-11-16 PHASE3）。 */
		uint32_t gst = GBAView32(gba->cpu, SIO_IW(0x03002A9Cu));
		unsigned cq = GBAView8(gba->cpu, SIO_IW(0x03002E2Du));
		unsigned c0 = GBAView16(gba->cpu, SIO_IW(0x03002B0Cu));
		/* 【17:25】r00/r10 = gRecvCmds[0][0]/[1][0]（@0x03002A4A，[4][8] u16）
		 * 直接看出命令字落在接收帧的第几格：ProcessRecvCmds 只看 [i][0]。
		 * 若 0x2222/BBBB/8888 只出现在 [i][1]，就永远不会被识别。 */
		unsigned r00 = GBAView16(gba->cpu, SIO_IW(0x03002A4Au));
		unsigned r10 = GBAView16(gba->cpu, SIO_IW(0x03002A4Au) + 16u);
		/* 【11-16 逐轮 TR】只打 lstate>=4 的一段（上限 1200 行），一次转移一行。
		 * 目的：直接看游戏的 9 轮状态机有没有走起来 ——
		 *   sc/rc = gLink.sendCmdIndex/recvCmdIndex（0..8 循环；卡在 8 说明
		 *          SendRecvDone 没拿到 recvCmdIndex==8，整轮不闭合）
		 *   sqc/sqp = sendQueue.count/pos（count 不降 = 命令没被取走）
		 *   rqc/rqp = recvQueue.count/pos
		 *   cb = gLinkCallback（0=空，其它值恒定不变 ⇒ InitBlockSend 从未被调用）
		 *   ck = gLink.checksum（本轮校验和字） */
		(void) 0;
		SIO_LOG("SLOT n=%u me=%d mst=%d data=%04X,%04X,%04X,%04X pc=%u lstate=%u im=%u hs=%u sq=%u w=%04X st=%08X cq=%u c0=%04X r00=%04X r10=%04X",
		        (unsigned) sio->sioOk, me, roundMaster ? 1 : 0,
		        data[0], data[1], data[2], data[3],
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Eu),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002B0Au)),
		        (unsigned) gba->memory.io[GBA_REG(SIOMLT_SEND)],
		        gst, cq, c0, r00, r10);
	}
	if ((sio->sioOk & 0x3F) == 0) {
		uint32_t wAvg = sio->sioWaitN ? sio->sioWaitSumMs / sio->sioWaitN : 0;
		/* 角色/轮次钟/推送记账：brs 恒 0 的定案全靠这三个数。
		 *   role  = netLinkPlayer()（0=链路主机，1=从机）
		 *   mst   = 本轮是否由 beginMultiTransfer 起（只有 role=0 可能为 1）
		 *   idx   = 本轮轮次号（冻结就说明轮次钟停了）
		 *   pushOut/err/pushIn = 本端推出/失败/收到的 PKT_PUSH 计数
		 * idx 与 mst 是「主机轮次钟有没有在走」的唯一直接证据。 */
		uint32_t pushOut = 0;
		uint32_t pushErr = 0;
		uint32_t pushIn = 0;
		netLinkWireStats(sio->link, &pushOut, &pushErr, &pushIn, NULL, NULL);
		SIO_LOG("SIO multi me=%d role=%d mst=%d idx=%u ok=%u last=%u.%ums peak=%u.%ums to=%u fb=%u mis=%u lgc=%u m0=%04X m1=%04X wait=%u/%ums n=%u cp=%u/%u cf=%u pushOut=%u/%u pushIn=%u",
		     me, netLinkPlayer(sio->link), roundMaster ? 1 : 0, (unsigned) sio->sioIndex,
		     sio->sioOk, sio->sioLateness / 10, sio->sioLateness % 10,
		     sio->sioPeak / 10, sio->sioPeak % 10, sio->sioTimeouts, sio->sioFallback, sio->sioMisorder,
		     (unsigned) sio->sioLagCleared, data[0], data[1],
		     wAvg, sio->sioWaitMaxMs, sio->sioWaitN,
		     sio->sioConnectPolls, SIO_CONNECT_BUDGET_MS, sio->sioConnectFallback,
		     pushOut, pushErr, pushIn);
		sio->sioWaitSumMs = 0;
		sio->sioWaitMaxMs = 0;
		sio->sioWaitN = 0;
		sio->sioConnectPolls = 0;
		sio->sioConnectHits = 0;
		sio->sioConnectFallback = 0;
		logLinkDiag(gba);
		maybeUnstickStandby(gba);
	}
	/* maybeRearmHandshake 必须**每轮**都跑（原来在「每 64 轮」的采样块里）：
	 * 它现在负责每轮补 gLink.handshakeAsMaster，而游戏的 DoHandshake() 每轮
	 * 都会把这个标志清掉（link.c:2268）—— 64 轮补一次 ⇒ 主机 62/63 的轮次
	 * 发的是从机握手字 0xB9A0 ⇒ 对端收尾条件永远不成立（见函数注释）。 */
	maybeRearmHandshake(sio);
	/* 迭代 57 — 从机 state2 卡死的真因（三轮实测 playerCount=0）：
	 * gen8 DoHandshake(link.c:2250) 数 tempRecvBuffer 里连续的握手字：
	 *   if ((buf[i] & ~3)==B9A0 || buf[i]==8FFF) playerCount++;
	 * 从机要 buf[0]==0x8FFF（主机字）、buf[1]==0xB9A0（自身字）才 pc=2。
	 * 主机一旦先进 state4 就不再 DoHandshake、停发 8FFF，从机 buf[0] 变成
	 * 0/命令字 → pc=0 → 永不 2→4。主机 self-slot 有自己的 8FFF 所以照常
	 * 完成，两端不对称。这里在写 SIOMLT_RECV 前把主机槽字补成 8FFF ——
	 * 补的是主机本应持续发的握手字，不是伪造身份（isMaster 仍由 SIO 引脚定）。 */
	{
		uint32_t lkq = SIO_IW(0x03002AF4u);
		unsigned gstate = GBAView8(gba->cpu, lkq + 1u);
		unsigned gim = GBAView8(gba->cpu, lkq + 0u);
		/* 【W92/path B 原生 SIO】门开时禁 RHSLVINJ：绝不把 data[0]/data[1]
		 * 强写成 8FFF/B9A0。收尾槽的握手字必须来自 LocalBus 真字；取不到字
		 * 保持空槽=诚实失败。门关时本段逐字节不变（零回归）。 */
		if (!sioPathBNativeSioOn() && gstate == 2u && gim != 8u && me != 0) {
			if (data[0] != LINK_HANDSHAKE_MASTER && data[0] != LINK_HANDSHAKE_SLAVE) {
				static unsigned injN;
				if ((++injN & 0x3Fu) == 1) {
					SIO_LOG("[RHSLVINJ] state=2 pc=%u im=%u data0=%04X->8FFF data1=%04X",
					        (unsigned) GBAView8(gba->cpu, lkq + 3u), gim,
					        data[0], data[1]);
				}
			}
			data[0] = LINK_HANDSHAKE_MASTER;
			if (data[1] == 0u || data[1] == 0xFFFFu) {
				data[1] = LINK_HANDSHAKE_SLAVE;
			}
		}
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
}

/* 两人直连：本机一槽 + 对端一槽，其余保持 0xFFFF（空槽）。 */
/* 【2026-11-16 21:0x 已回退"强制相位"】不要写 sendCmdIndex/recvCmdIndex！
 *
 * 上一轮试过把两个索引每轮钉成 (共享轮次号 % 9)，结果两端 recvQueue.count
 * 恒为 0、整局一个字都入不了队。原因（gen8 link.c:2211 SerialCB）：
 *   DoRecv(); DoSend(); SendRecvDone();
 * 而这三者的语义完全依赖索引**单调自增**：
 *   - DoSend: sendCmdIndex==8 才是"发校验和 + 弹出 sendQueue"那一拍，
 *     其它拍发 sendQueue.data[sendCmdIndex] 后自增；
 *   - DoRecv: sendCmdIndex==0 才是"校验和轮"（只比对不入队），
 *     其它拍写 recvQueue.data[i][recvCmdIndex] 后 recvCmdIndex++；
 *   - SendRecvDone: 只有 recvCmdIndex==8 才把两个索引一起清 0。
 * 每轮硬写索引 ⇒ recvCmdIndex 永远到不了 8 ⇒ 永远不 count++ ⇒ ProcessRecvCmds
 * 读到全 0 的 gRecvCmds。这里只做**观察**，不改任何内存。 */
static void sioObserveCmdPhase(struct SioLink* sio) {
	static int enabled = -1;
	static unsigned rounds;
	static unsigned hist[16];
	static unsigned scSeqBad;
	static unsigned lastSc;
	static bool lastScValid;
	static unsigned lastSc0Round;
	static bool sc0Valid;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CMD_PHASE");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		return;   /* 握手期索引没意义 */
	}
	unsigned sc = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	unsigned rc = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u);
	++rounds;
	if (lastScValid) {
		unsigned expect = (lastSc == 9u) ? 8u : lastSc + 1u;   /* 8 之后停在 8 */
		if (sc != expect && sc != 0u) {
			++scSeqBad;
		}
	}
	lastSc = sc;
	lastScValid = true;
	if (sc == 0u) {
		if (sc0Valid) {
			unsigned d = rounds - lastSc0Round;
			++hist[d < 16u ? d : 15u];
		}
		lastSc0Round = rounds;
		sc0Valid = true;
	}
	if (rounds % 900u == 0u) {
		SIO_LOG("PHASE rounds=%u sc=%u rc=%u scSeqBad=%u cad=%u,%u,%u,%u,%u,%u,%u,%u,%u,%u,%u,%u",
		        rounds, sc, rc, scSeqBad,
		        hist[0], hist[1], hist[2], hist[3], hist[4], hist[5],
		        hist[6], hist[7], hist[8], hist[9], hist[10], hist[11]);
	}
}

/* 【一次性命令帧相位对齐 2026-11-16 21:0x】
 *
 * gen8 的 9 拍命令帧要求「对端 sendCmdIndex==0 那一轮」恰好落在「本端
 * recvCmdIndex==0」。两端各自从自己的 state4 起点开始数，一旦进入
 * CONN_ESTABLISHED 的轮次不同，整帧就被**整体旋转**：命令字落进别的槽，
 * 而 ProcessRecvCmds 只看 gRecvCmds[i][0] ⇒ 永远识别不到 0x2222/BBBB。
 * 实测 TR25：A 端收到对端 0xBBBB 时本端 rc=6、B 端 rc=4，
 * 直接后果是 `sBlockRecv[i].size` 恒 0（INIT_BLOCK 从未被执行）、
 * 训练家卡片块根本没开始接收 ⇒ rem 恒 0 ⇒ linkup 超时/黑屏。
 *
 * 修法：**只对齐一次**。0x2222（LINKCMD_SEND_LINK_TYPE，主机命令帧第 0 格）
 * 和 0xBBBB（LINKCMD_INIT_BLOCK，从机块帧第 0 格）都是确定的帧首锚点；
 * 收到它们的那一轮把 recvCmdIndex 归 0、sendCmdIndex 置 1（保持
 * `sc = rc + 1` 这个 ROM 自身的不变式），这一轮 DoRecv 就会把锚点写进
 * slot 0，此后相位自然保持。
 *
 * 为什么不能每轮都写：DoSend/DoRecv/SendRecvDone 完全依赖索引单调自增
 * （见 sioObserveCmdPhase 的注释），每轮硬写会让 recvQueue.count 永远不涨。 */
static void sioAlignCmdPhase(struct SioLink* sio, uint16_t peerWord) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CMD_ALIGN");
		/* 【默认关闭 2026-11-18 FULLAUDIT D1】本函数把 sc 钉成 1 以维持
		 * sc=rc+1，但 gen8 的 DoSend 在 sc=1 时发 sendQueue.data[1]，
		 * **跳过 data[0]** —— 而 data[0] 正是 0x2222/BBBB/8888 帧首命令字。
		 * 对端刚为回应 0x2222 装入 data[0] 的 0xBBBB(INIT_BLOCK)/size
		 * 因此永不上线 ⇒ rem 恒 0 ⇒ 600 帧 TryLinkTimeout。这与本文件
		 * sioPhaseGate 的注释（:2660-2664）自己给出的结论一致：锚点事后
		 * 校正是错误路径，帧相位必须由 sioPhaseGate 在进入 state4 前对齐。
		 * 保留 opt-in（MGBAX_CMD_ALIGN=1）供 A/B，绝不默认启用。 */
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled) {
		return;
	}
	/* 只认这两个**帧首命令字**当锚点：0x2222=LINKCMD_SEND_LINK_TYPE（主机
	 * 命令帧第 0 格）、0xBBBB=LINKCMD_INIT_BLOCK（从机块帧第 0 格）。
	 * 不要加 0x8888：它每帧都出现，且块数据里也可能撞上，会把对齐打乱。 */
	if (peerWord != LINKCMD_SEND_LINK_TYPE && peerWord != LINKCMD_INIT_BLOCK) {
		return;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		return;
	}
	unsigned rc = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u);
	if (rc == 0u) {
		return;   /* 这一轮已经对齐，什么都不用做 */
	}
	GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u, 0, NULL);   /* recvCmdIndex = 0 */
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF, 1, NULL);   /* sendCmdIndex = 1 */
	++sio->sioPhaseAligned;
	SIO_LOG("PHASEALIGN#%u anchor=%04X rc=%u -> rc=0 sc=1",
	        (unsigned) sio->sioPhaseAligned, peerWord, rc);
}

/* 【硬相位锁 2026-11-16 23:3x】
 *
 * 要解决的是**一拍错位**。用两端日志里各自的帧首反推（DoRecv→DoSend→
 * SendRecvDone 决定 t=1 时 sc=0,rc=0）：
 *   A 在 lb=4 时 sc=0 ⇒ A 的帧首 ≡ 4 (mod 9)
 *   B 在 lb=15 时 sc=3 ⇒ B 的帧首 ≡ 3 (mod 9)   （15-3=12，帧首 12/21/…）
 * 差一拍 ⇒ 对端 data[j] 落进本端 slot j∓1。实测现象完全吻合：
 * B 的 data[0]=0xBBBB(INIT_BLOCK) 落进 A 的 slot 8、data[1]=0x81(size)
 * 落进 A 的 slot 0；`ProcessRecvCmds` 只看 `gRecvCmds[i][0]`，读到 0x0081
 * 就当无关命令丢掉 ⇒ `sBlockRecv[1].size` 永远 0 ⇒ `rem` 永远 0。
 * （硬件的九拍流水把 data[j] 对齐到 slot j，见 DoSend 在 beat t 写的是
 *  data[t-1]、下一拍才上线，所以帧首必须**逐拍重合**，差一拍就全错格。）
 *
 * 目标：两端把帧首落到同一个同余类。选「≡ 0 (mod 9)」——因为它可以**各自
 * 独立**算出来，不需要跨端通信，也不用改 PKT_PUSH 包格式。
 *
 * 三步走（每一步都不能省，全是踩过的坑）：
 *  1) **在自然帧边界上武装**：只认 sc==0 && rc==0 那一拍（一帧的第一拍），
 *     记下 target = 严格大于当前 label 的最小 9 的倍数。武装之前一个字节
 *     都不改，所以主机那**唯一一帧** 0x2222（gen8/src/link.c:1251 的
 *     LinkCB_RequestPlayerDataExchange 发完就把 gLinkCallback 置 NULL）
 *     能正常发出去。
 *  2) **等到 target 再落**：落点必是 9 的倍数 ⇒ 两端即使 target 不同，
 *     帧首都与 0 同余 ⇒ 之后每一拍都重合。
 *  3) 落点之后每轮钉 (sc,rc,sic) = (u, u-1, u)，u = label%9。
 *     落点那一拍 u=0，与自然帧首完全一致（DoSend 发 data[0]、DoRecv 走
 *     校验和分支），所以**不会截断任何有意义的数据**。
 *
 * 三个绝对禁忌（TR30/31/32 的失败现场）：
 *   - 不能在 u≠0 时落：会跳过 data[0..u-1]，而 0x2222/0xBBBB/0x8888 正是
 *     data[0]；
 *   - 更不能把 sc 钉成 8：`DoSend` 的 `sc==CMD_LENGTH` 分支会
 *     `sendQueue.count--/pos++`（弹队），把唯一那帧命令弹走而从未上线；
 *   - sic 必须与 sc 同源（见下面那段注释），否则主机的 VBlank 起轮条件
 *     `serialIntrCounter >= 9` 永远不成立，链路 10 秒后必然 600 帧超时。
 *
 * 关掉用 MGBAX_CMD_HARD=0（默认关）。 */
static void sioLinkStat(struct SioLink* sio);
static bool sioCoastReady(struct SioLink* sio);
static uint16_t sioIdxDeliver(struct SioLink* sio, uint32_t remote, unsigned naturalRc);
static int sioIdxDeliverOn(void);
static bool sioTakePeerWordRaw(struct SioLink* sio, uint32_t* value, uint16_t* idx, int timeoutMs);

/* 【对端字流平移线 2026-11-16 23:5x】
 *
 * 病灶：两端 9 拍命令帧的首拍**不重合**，实测差一拍（用两端日志各自的帧首
 * 反推：A 在 lb=4 时 sc=0 ⇒ 帧首 ≡4；B 在 lb=15 时 sc=3 ⇒ 帧首 ≡3）。
 * 硬件的九拍流水把「对端 data[j]」对齐到「本端 slot j」，差一拍就整体错
 * 一格：B 的 data[0]=0xBBBB 落进 A 的 slot 8、data[1]=0x81(size) 落进
 * slot 0，`ProcessRecvCmds` 只看 slot 0 ⇒ INIT_BLOCK 被当垃圾丢掉。
 *
 * 一条比"改索引"干净得多的修法：**把投递给 ROM 的对端 16 位字整体平移
 * N 拍**（N=1 即"本轮发上一轮收到的那个字"）。理由是——
 *   - `sendCmdIndex/recvCmdIndex` 一个都不碰 ⇒ 不会误触 DoSend 的弹队分支
 *     （`sc==CMD_LENGTH`），也不会截断 data[0]（那正是 0x2222/0xBBBB）；
 *   - 两端各自独立平移，不需要任何跨端协调；
 *   - 只是把"线上到达时刻"换成"上一拍到达时刻"，等价于给流水线补一拍。
 * 代价：校验和对比那一拍拿到的不是对端 checksum —— 由 CS_FORGE（默认开）
 * 覆盖掉，本来就不比对（电缆完整性检查在替掉电缆后由中继侧重算才正确）。
 *
 * N 由 MGBAX_PEER_SHIFT 指定（0..8，0=关闭，默认）。只从 1 开始试，因为
 * 需要"向后看"的负向平移等价于 9-N 的正向平移（一帧 9 拍）。
 * 前 N 拍历史还没积满，原样投递。 */
static int sioPeerShiftN(void) {
	static int n = -1;
	if (n < 0) {
		const char* v = getenv("MGBAX_PEER_SHIFT");
		n = v ? atoi(v) : 0;
		if (n < 0) {
			n = 0;
		}
		if (n > 8) {
			n = 8;
		}
	}
	return n;
}

static uint16_t sioPeerShifted(struct SioLink* sio, uint16_t remote) {
	int n = sioPeerShiftN();
	if (n <= 0) {
		return remote;
	}
	uint32_t idx = sio->sioPeerHistN % 9u;
	sio->sioPeerHist[idx] = remote;
	++sio->sioPeerHistN;
	if (sio->sioPeerHistN <= (uint32_t) n) {
		return remote;   /* 历史未积满，先原样投递 */
	}
	return sio->sioPeerHist[(sio->sioPeerHistN - 1u - (uint32_t) n) % 9u];
}

/* 【发送侧帧索引随行 2026-11-16 24:0x】
 *
 * 这是本工程里第一次**把主机真实的 9 拍索引发到对端**，而不是让两端各自
 * 用共享轮次号猜。为什么必须这样做：TR35 现场证明错位是**单向不对称**的
 * ——同一个对端字（0x94EE）在 A 的 `gRecvCmds[1]` 落在 index 1、在 B 的
 * `gRecvCmds[0]` 落在 index 0。「主机侧差一拍、从机侧不差」，任何"两端各
 * 自独立往 9 的倍数靠"的方案都只能修好一边。
 *
 * 通道是现成的：`netLinkPush(link, mode, local, index, cycles)` 的 `local`
 * 是 32 位，而 SIO 槽位只取低 16 位，高 16 位一直空着。
 * 编码（bit24 是有效标志，避免把普通字误当带索引的）：
 *   bit16..19 = idxW  —— 本轮上线的那个字，在发送方帧里的槽号
 *   bit20..23 = scNow —— 发送方本轮 DoSend 要用的 sendCmdIndex
 *
 * 取值依据（gen8/src/link.c:2353 DoSend）：起轮那一刻的 sendCmdIndex 就是
 * 本轮 DoSend 要用的值；而 SIOMLT_SEND 里躺着的字是**上一轮** DoSend 写的：
 *   scNow == 0  ⇒ 上一轮是第 9 拍（写校验和、sc 不增），或被 SendRecvDone
 *                 复位 ⇒ 在飞的字是校验和（槽号 8）
 *   否则        ⇒ 在飞的字是 data[scNow-1]
 *
 * 从机收到后**只跟随、不猜测**：rc = idxW（对端字该落哪格）、
 * sc = scNow（自己的拍位与主机逐拍重合，弹队拍/校验和拍因此天然对齐）。
 * 主机侧一个字节都不用改，它那唯一一帧 0x2222 完全不受影响。
 *
 * 关掉用 MGBAX_SYNCIDX=0（默认关）。 */
static int sioSyncIdxOn(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_SYNCIDX");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	return enabled;
}

/* 迭代 50 — 对战队伍真实数据旁路：对端 SIO 字卡在握手 B9A0，gen8 的
 * SendBlock 队伍块永远不过来。用 netLinkPush 的 local 高 16 位把 PC 端真实
 * 6 只精灵的 species 送给移动端（低 16 位仍是正常 SIO 字，不干扰链路）。
 * 编码：高16 = 0x8000 | (idx<<8) | byte；idx 0..11 = 6×u16 species(小端)。 */
/* ROOTHUNT2 — 双端对称 sidecar RX：APP 侧把"APP 队伍 species"编码进它发出的
 * SIO 字高16位(0x8000|idx<<8|byte)；PC 侧在这里解码，得到 PC 的对手真 species。
 * 这是 PC 在 HandleStartBattle 早窗口(080B376D)就能拿到的唯一可靠早源
 * （gBattleMons 此时仍 0，gBlockRecvBuffer 的 CONT_BLOCK 块对端不回）。 */
static uint8_t s_pcPeerSpeciesBytes[12];
static unsigned s_pcSpSidecarHits;   /* 诊断：解到的 sidecar 字数量 */
static void sioCapturePeerParty(uint32_t remote) {
	if (rhPatchesOff()) {
		return;
	}
	uint32_t hi = remote >> 16;
	if ((hi & 0x8000u) == 0u) {
		return;
	}
	++s_pcSpSidecarHits;   /* 打中即证明字带 0x8000 标志 */
	unsigned idx = (hi >> 8u) & 0x7Fu;
	if (idx < 12u) {
		s_pcPeerSpeciesBytes[idx] = (uint8_t) (hi & 0xFFu);
	}
	if (rhVerbose() && s_pcSpSidecarHits <= 8u) {
		SIO_LOG("[RHSIDECAR] hi=%04X idx=%u byte=%02X hits=%u sp0=%04X",
		        (unsigned) hi, idx, (unsigned) (hi & 0xFFu), s_pcSpSidecarHits,
		        (unsigned) (s_pcPeerSpeciesBytes[0] | ((unsigned) s_pcPeerSpeciesBytes[1] << 8u)));
	}
}

static unsigned s_partyTxIdxPrev;
static uint8_t sioPartyByteTx(struct SioLink* sio) {
	static unsigned idx;
	if (rhPatchesOff()) {
		return 0xFFu;   /* ROOTHUNT2 零注入：不发 sidecar */
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return 0xFFu;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 < SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    || cb2 >= SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		idx = 0;
		return 0xFFu;
	}
	if (idx >= 12u) {
		idx = 0;   /* 循环发送，移动端可随时对齐 */
	}
	unsigned mon = idx >> 1;
	unsigned lo = idx & 1u;
	/* 迭代 51 纠错：species 在 BoxPokemon+0x08 的 u32 bit11..21，
	 * 不在 struct Pokemon 的 +0（那是 personality）。 */
	uint32_t w = GBAView32(gba->cpu, SIO_EW(SIO_PLAYER_PARTY) + mon * 0x50u + 0x08u);
	uint16_t sp = (uint16_t) ((w >> 11u) & 0x7FFu);
	uint8_t b = lo ? (uint8_t) (sp >> 8) : (uint8_t) (sp & 0xFFu);
	if (idx == 0u) {
		static unsigned encN;
		if (++encN <= 4u || (encN % 128u) == 0) {
			SIO_LOG("[SPENC] party0 raw=%08X species=%04X encodedHi=%04X syncidx=%d",
			        (unsigned) w, (unsigned) sp,
			        (unsigned) (0x8000u | b), sioSyncIdxOn() ? 1 : 0);
		}
	}
	s_partyTxIdxPrev = idx;
	++idx;
	return b;
}

static uint32_t sioPackPush(struct SioLink* sio, uint16_t word) {
	if (!sioSyncIdxOn() || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return (uint32_t) word;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		/* 握手期 sc 恒 0，带上只会污染 DoHandshake。 */
		return (uint32_t) word;
	}
	unsigned scNow = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	if (scNow > 8u) {
		return (uint32_t) word;
	}
	unsigned idxW = (scNow == 0u) ? 8u : (scNow - 1u);
	return (uint32_t) word | 0x01000000u | (idxW << 16) | (scNow << 20);
}

/* 所有 netLinkPush 的统一出口：低16=真 SIO 字，高16 携带 PC 真实队伍
 * species 旁路。此前 sidecar 只加在主机 sioDoneEvent 一处，从机的 fastframe/
 * 普通 push 三处没加 —— 云端 PC 是从机，所以移动端 sp 全 0。 */
static uint32_t sioOutboundPayload(struct SioLink* sio, uint16_t word) {
	uint32_t p = sioPackPush(sio, word);
	if (!sioSyncIdxOn()) {
		uint8_t pb = sioPartyByteTx(sio);
		if (pb != 0xFFu) {
			p |= (uint32_t) (0x8000u | ((unsigned) s_partyTxIdxPrev << 8) | pb) << 16;
		}
	}
	return p;
}

/* 【两端同时进入 CONN_ESTABLISHED 2026-11-16 24:2x】
 *
 * 为什么必须"同时"：九拍命令帧要求两端**每一拍都重合**。ROM 自己的进入时机
 * 完全不可控——从机在 SerialCB 里一满足 DoHandshake 就立刻进 state4，主机却
 * 要等下一个 VBlank 的 LinkMain1。实测（TR37）A 比 B 晚约 10 秒才进 state4，
 * 而 B 的 cable club 已经开始数 `TryLinkTimeout`（cable_club.c:563，600 帧
 * ≈10 秒），于是 B 判 LINKUP_CONNECTION_ERROR 拆链、A 还在 state2 —— 两端
 * 从此互相踢，`rem` 永远到不了 1。
 *
 * 做法：把"进入"这件事挪到**共享轮次号的 9 的倍数**那一拍上，两端各自独立
 * 判定（不需要通信，因为 9 的倍数与 0 同余），那一拍同时：
 *   gLink.state = 4、sendCmdIndex = recvCmdIndex = serialIntrCounter = 0。
 * 两端帧首因此逐拍重合，data[j] 天然落进 slot j。
 * 未到边界时把 state 摁回 2（state2/3 都不推进索引，摁多久都无副作用）；
 * 主机额外补一次 InitTimer（gen8/src/link.c:2072：TM3CNT_L=-197、
 * TM3CNT_H=TIMER_64CLK|INTR_ENABLE），因为跳过 state3 就没跑过它，
 * 而主机的九拍链完全靠 TM3 串起来。
 *
 * 开关 MGBAX_ESTGATE=1（默认关）。 */
static int sioEstGateOn(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_ESTGATE");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	return enabled;
}

static void sioEstablishGate(struct SioLink* sio) {
	if (!sioEstGateOn() || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	struct ARMCore* cpu = gba->cpu;
	unsigned st = GBAView8(cpu, SIO_IW(0x03002AF5u));
	if (st < 4u) {
		sio->sioEstDone = false;
		return;
	}
	/* 【LOCKPHASE：每 9 拍重复对齐】一次性对齐只能修进入时的错位；长时间空闲
	 * 里传输层偶尔丢/重一拍，帧边界就会漂一格 —— TR49/TR54 现场：第二块
	 * 训练家数据从第 4 帧起 `8888` 固定落在 slot 1，`ProcessRecvCmds` 只看
	 * slot 0 ⇒ CONT_BLOCK 全部丢弃 ⇒ 俱乐部永远等不到第二块（A 端停在
	 * lobby、B 端已进待机房间）。
	 * 两端对「label%9==0」的落点必然同余，所以可以把清零做成**周期性**的：
	 * 每 9 拍回到同一个同余类 ⇒ 任何 0..8 拍的漂移都会被拉回。
	 * 对齐时清零是幂等的（本来就在帧首，sc/rc 已经是 0），完全不动状态；
	 * 漂了时被截断的那一帧由于 `sc=0` 不触发弹队分支 ⇒ 下一帧从 data[0]
	 * 整帧重发，`0x2222 / 0xCCCC` 这些一次性命令一个字都不丢。
	 * 开关 MGBAX_LOCKPHASE=1。 */
	static int lockPhase = -1;
	if (lockPhase < 0) {
		const char* v = getenv("MGBAX_LOCKPHASE");
		lockPhase = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (sio->sioEstDone && !lockPhase) {
		return;
	}
	unsigned lbl = (unsigned) sio->sioRoundLabel;
	if ((lbl % 9u) != 0u) {
		return;   /* 只等 9 的倍数，什么都不改 */
	}
	/* 【为什么不把 state 摁回去】早先的写法在边界之前每轮把 state 打回 2，
	 * 结果 DoHandshake 每轮重跑、`playerCount`/`link_field_F` 反复被重置，
	 * 而且边界那一拍 ROM 刚好又自己进了 state4，判据落空 ⇒ 一次都没建立
	 *（TR38 现场：只有 hold 没有 establish，最后 600 帧超时拆链）。
	 * 现在只清零索引、不动状态：`sendCmdIndex=0` 不会触发 DoSend 的弹队
	 * 分支（弹队只在 `sc==CMD_LENGTH`），所以在飞的命令帧会从 data[0]
	 * **整帧重发**，0x2222 一个字都不丢。 */
	GBAPatch8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF, 0, NULL);
	GBAPatch8(cpu, SIO_IW(0x03002AF4u) + 0x17u, 0, NULL);
	GBAPatch8(cpu, SIO_IW(0x03002AF4u) + 0x0Du, 0, NULL);
	if (GBAView32(cpu, SIO_IW(0x03002A9Cu)) & 0x20u) {
		/* 主机：补一次 InitTimer（gen8/src/link.c:2072）。九拍链完全靠 TM3
		 * 串起来，缺了它第 1 拍之后就没人起下一轮。 */
		GBAPatch16(cpu, SIO_REG_TM3CNT_LO, (int16_t) -197, NULL);
		GBAPatch16(cpu, SIO_REG_TM3CNT_HI, (int16_t) 0x0042, NULL);
	}
	if (!sio->sioEstDone) {
		sio->sioEstDone = true;
		SIO_LOG("ESTGATE t=%u lb=%u st=%u -> sc/rc/sic=0 (lockphase=%d)",
		        (unsigned) wallNowMs(), lbl, st, lockPhase);
	}
}

/* 从机侧：按主机随行的索引钉住本轮 sc/rc。必须在 completeMultiTransfer
 * 之前调用（SerialCB 是在 finishMultiTransfer 里跑的）。 */
static void sioFollowSyncIdx(struct SioLink* sio, uint32_t remote) {
	if (!sioSyncIdxOn() || !(remote & 0x01000000u)) {
		return;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		return;
	}
	unsigned idxW = (remote >> 16) & 0xFu;
	unsigned scNow = (remote >> 20) & 0xFu;
	if (idxW > 8u || scNow > 8u) {
		return;
	}
	bool isMaster = (GBAView32(gba->cpu, SIO_IW(0x03002A9Cu)) & 0x20u) != 0;
	if (isMaster) {
		/* 【主机必须权威 2026-11-17 01:1x】让主机也跟随（rc=idxW、
		 * sc=(idxW+1)%9）虽然能消掉 TR49 的右移一格，但会把主机**自己槽**
		 * 的回环帧打散：TR50 现场 `sBlockRecv[0]=70/0`（size 变 0）、
		 * A 端 rem 恒 0、只剩 B 端 rem=1 —— 比不跟随更糟。
		 * 主机不能被对端拉着走：它的 sendCmdIndex 同时决定 0x2222 上线、
		 * 弹队节奏和自己槽回环的内容，一动全动。
		 * 真正该修的是"重复字"（见 sioTakePeerWord 的严格递增过滤），
		 * 不是让主机去跟随。 */
		return;
	}
	/* 【从机跟随 2026-11-17 01:0x】
	 * 从机：`sc = scNow`、`rc = scNow-1`（帧首钳 0）—— 直接采用主机的真实拍位。
	 * 主机：`rc = idxW`、`sc = (idxW+1)%9` —— 从「对端在飞字槽号」**单向推导**，
	 *       不引入反馈环。
	 * 为什么主机也必须跟随：TR49 的 CMDFRM 证明主机会把同一格的字收两遍
	 *（`BBBB,0064,0081,0081` 里 0x0081 重复、随后整帧右移一格
	 * `0000,8888,...`），因为传输层偶尔把同一轮的字推两次（重试/超时补拍）。
	 * 从机有跟随所以幂等稳住；主机不跟随就一路漂，第二块训练家数据因此
	 * 永远拼不起来、俱乐部卡在 `Task_LinkupAwaitTrainerCardData`。
	 * 早先主机一跟随就卡在 sc=8 不动点，根因是当时把 `sic` 也写成
	 * `(idxW+1)%9`（弹队拍被压成 0，VBlank 起轮条件永远不成立）；现在
	 * `sic` 已改成「弹队那拍钉 8」，这个死锁不复存在。 */
	unsigned wantRc = (scNow == 0u) ? 0u : (scNow - 1u);
	unsigned wantSc = scNow;
	unsigned curRc = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u);
	unsigned curSc = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	if (curRc == wantRc && curSc == wantSc) {
		return;
	}
	if (curRc != wantRc) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u, (uint8_t) wantRc, NULL);
	}
	if (curSc != wantSc) {
		GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF, (uint8_t) wantSc, NULL);
	}
	++sio->sioSyncFix;
	if (sio->sioSyncFix <= 40u || (sio->sioSyncFix % 300u) == 0u) {
		SIO_LOG("SYNCIDX n=%u t=%u lb=%u me=%d sc=%u->%u rc=%u->%u",
		        (unsigned) sio->sioSyncFix, (unsigned) wallNowMs(),
		        (unsigned) sio->sioRoundLabel, isMaster ? 0 : 1,
		        curSc, wantSc, curRc, wantRc);
	}
}

static int sioHardCmdPhaseOn(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CMD_HARD");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	return enabled;
}

static void sioHardCmdPhase(struct SioLink* sio) {
	if (!sioHardCmdPhaseOn() || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	unsigned st = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	if (st < 4u) {
		/* 握手期 SerialCB 走 DoHandshake，不碰这两个索引，别去动它。 */
		sio->sioHardRounds = 0;
		sio->sioHardFix = 0;
		sio->sioHardArmed = false;
		sio->sioHardAligned = false;
		return;
	}
	unsigned curSc0 = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	unsigned curRc0 = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u);
	unsigned lbl = (unsigned) sio->sioRoundLabel;

	/* 【先在「自然帧边界」上武装】sc/rc 同时为 0 只可能出现在一帧的第一拍
	 * （见 DoRecv→DoSend→SendRecvDone 的九拍推导：t=1 时 sc=0,rc=0）。
	 * 武装那一刻记下**目标 label**：严格大于当前 label 的最小 9 的倍数。
	 * 之后等到这个 label 再动手 —— 这样落点必然是 9 的倍数，两端**各自
	 * 独立**算出来的落点因此落在同一个同余类上（都与 0 同余），不需要任何
	 * 跨端通信，也不需要改 PKT_PUSH 的包格式。 */
	if (!sio->sioHardArmed) {
		if (curSc0 != 0u || curRc0 != 0u) {
			return;   /* 还没到自然帧边界，一个字节都不动 */
		}
		sio->sioHardArmed = true;
		unsigned rem = lbl % 9u;
		sio->sioHardTarget = (uint16_t) (rem == 0u ? lbl : (lbl + (9u - rem)));
		SIO_LOG("CMDHARD arm t=%u lb=%u (帧首 mod9=%u) -> target=%u",
		        (unsigned) wallNowMs(), lbl, rem, (unsigned) sio->sioHardTarget);
		return;
	}
	if (!sio->sioHardAligned) {
		if (lbl < (unsigned) sio->sioHardTarget) {
			return;   /* 还在等落点：保持游戏自走，不截断任何帧 */
		}
		if ((lbl % 9u) != 0u) {
			/* 跳号跳过了落点（丢包/重传），按同一规则重新取下一个 */
			sio->sioHardTarget = (uint16_t) (lbl + (9u - (lbl % 9u)));
			return;
		}
		sio->sioHardAligned = true;
		SIO_LOG("CMDHARD lock t=%u lb=%u (两端各自的 target 都落在 9 的倍数 ⇒ 同余)",
		        (unsigned) wallNowMs(), lbl);
	}

	unsigned u = lbl % 9u;
	unsigned wantSc = u;
	unsigned wantRc = (u == 0u) ? 0u : u - 1u;
	unsigned curSc = curSc0;
	unsigned curRc = curRc0;
	if (curSc != wantSc) {
		GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF, (uint8_t) wantSc, NULL);
	}
	if (curRc != wantRc) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u, (uint8_t) wantRc, NULL);
	}
	/* 【serialIntrCounter 必须同源 2026-11-16 23:0x】
	 * 只钉 sc/rc 会把主机**彻底卡死**（TR30 现场：A 在 lb=8 之后 14s 只有
	 * 1 轮，然后 600 帧 LINKUP 超时 ⇒ res=6 ⇒ special CloseLink）。
	 * 原因在 LinkVSync（gen8/src/link.c:2164-2186）：
	 *     case LINK_STATE_CONN_ESTABLISHED:
	 *         if (serialIntrCounter < 9) { lag = LAG_MASTER; }        // 只置 lag
	 *         else if (lag != LAG_MASTER) { sic = 0; StartTransfer(); } // 起新一轮
	 * 主机每 VBlank 只做一次判断：sic 没到 9 就**什么都不断言**，等下一帧；
	 * 真起轮的只有 TM3 链（SendRecvDone 在 rc!=8 时 `TM3CNT_H |= ENABLE`）。
	 * 而 9 拍里第 9 拍 rc==8 ⇒ SendRecvDone 走复位分支、**不点亮 TM3**，
	 * 于是这一拍之后既没有 TM3 也没有 VBlank 起轮的两条路都断了。
	 * 游戏自己的 sic 与 sc/rc 同步增长时不会出问题（每 9 拍 sic 正好到 9，
	 * 下一 VBlank 重起）；我们用 label 强行推导 sc/rc 后 sic 就脱钩了
	 * （实测 lb=8 时 sic 只有 4），永远到不了 9。
	 * 所以 sic 必须和 sc/rc 用同一个 u：u=8 那一拍前 sic=8，SerialCB 结尾
	 * ++ 成 9 ⇒ 下一 VBlank 必然重起一轮（sic=0，正好是 u=0），整条链闭合。
	 * 从机侧 sic 只用于 `==8` 打点，钉住无副作用。 */
	unsigned curSic = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Du);
	if (curSic != u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Du, (uint8_t) u, NULL);
	}
	++sio->sioHardRounds;
	if (curSc != wantSc || curRc != wantRc || curSic != u) {
		++sio->sioHardFix;
	}
	/* 前 40 轮逐轮取证，之后每 300 轮一条：fix/rounds 就是「游戏自走相位
	 * 偏离共享轮次号」的比例。比值小说明 label 稳定 1:1，锁得住；
	 * 持续接近 1 说明 label 在跳号（网络重传/影子标签），要另找源头。 */
	if (sio->sioHardRounds <= 40u || (sio->sioHardRounds % 300u) == 0u) {
		SIO_LOG("CMDHARD n=%u t=%u lb=%u u=%u sc=%u->%u rc=%u->%u sic=%u->%u fix=%u",
		        (unsigned) sio->sioHardRounds, (unsigned) wallNowMs(),
		        (unsigned) sio->sioRoundLabel, u,
		        curSc, wantSc, curRc, wantRc, curSic, u, (unsigned) sio->sioHardFix);
	}
}

/* 【命令流取证 2026-11-16 23:2x】
 * 相位锁住之后还差什么，只看 sc/rc 猜不出来，直接把「游戏侧真正的命令
 * 收发面」打出来：gSendCmd（本帧要发的 8 个字）、gRecvCmds[0]/[1]（收到
 * 的两份命令帧）、sBlockRecv[0]/[1] 的 pos/size（训练家卡片块进度）、
 * gReceivedRemoteLinkPlayers / gRemoteLinkPlayersNotReceived、
 * gLinkCallback（为 0 时 LinkMain2 根本不会 BuildSendCmd，链路再健康也
 * 不会有命令帧上线）、以及 gLinkStatus。
 * 动作真凶靠这三件事分辨：
 *   snd 恒 EFFF/0 且 cb=0  ⇒ 游戏不在跑联机协议（回调被清），不是链路问题；
 *   r0/r1 里出现 2222/BBBB/8888 ⇒ 命令到岸了，卡在块接收；
 *   b1 size 恒 0           ⇒ INIT_BLOCK 从没被认出（槽位错位）。
 * 开关 MGBAX_LINKSTAT=1，每 900 轮（≈100 帧）一条。 */
/* 【帧率探针 2026-11-17 23:1x】
 *
 * 联机时窗口标题只剩 15~34fps（单机 59.7fps）。要判断是不是「等对端字」把
 * 模拟时钟冻住了，就得有定量：每轮记录进入/离开取字函数的墙钟差，累计成
 * `blocked ms / 500 轮`。60fps 时每帧 16.7ms、9 轮/帧 ⇒ 一轮预算 1.85ms；
 * 实测若是一轮几十毫秒，那 9 轮就把整帧吃掉，帧率必然是十几 fps。
 * 开关 MGBAX_SIOPERF=1（默认关）。 */
static void sioPerfLog(struct SioLink* sio, uint64_t blockedUs) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_SIOPERF");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled) {
		return;
	}
	++sio->sioPerfRounds;
	sio->sioPerfBlockedMs += (uint32_t) (blockedUs / 1000ull);
	if ((uint32_t) (blockedUs / 1000ull) > sio->sioPerfMaxMs) {
		sio->sioPerfMaxMs = (uint32_t) (blockedUs / 1000ull);
	}
	if (sio->sioPerfRounds - sio->sioPerfLastLog < 500u) {
		return;
	}
	uint32_t span = sio->sioPerfRounds - sio->sioPerfLastLog;
	uint32_t spanMs = sio->sioPerfBlockedMs;
	sio->sioPerfLastLog = sio->sioPerfRounds;
	sio->sioPerfBlockedMs = 0;
	uint32_t maxMs = sio->sioPerfMaxMs;
	sio->sioPerfMaxMs = 0;
	/* 每 9 轮 = 一帧；blocked 总量 / 帧数 = 每帧被冻住的毫秒。 */
	uint32_t frames = span / 9u;
	SIO_LOG("SIOPERF rounds=%u frames=%u blocked=%ums/span max=%ums "
	        "perFrame=%.1fms estFps=%.1f",
	        (unsigned) span, (unsigned) frames, (unsigned) spanMs, (unsigned) maxMs,
	        frames ? (double) spanMs / (double) frames
	               : 0.0,
	        spanMs ? 1000.0 * (double) frames / (double) spanMs : 0.0);
}

/* 【每帧轮数分布探针 2026-11-18 00:1x】
 *
 * 只读，不改任何行为。用来给「把轮数钳在 9/帧」这个改动定量：
 * 每完成一轮就比一次模拟器帧计数，跨帧时把上一帧的轮数记进分布。
 * `over` = 超过 9 轮的帧数；`max` = 见过的最多轮数。
 * 这直接对应 st 的 0x4000 = ERROR_QUEUE_FULL（recvQueue 只进不出）。
 * 开关 MGBAX_ROUNDSPF=1（默认关）。 */
static void sioRoundsPerFrame(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_ROUNDSPF");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->video.frameCounter) {
		return;
	}
	uint32_t f = gba->video.frameCounter;
	if (f == sio->sioRpfFrame) {
		++sio->sioRpfCount;
		return;
	}
	if (sio->sioRpfFrame != 0 && sio->sioRpfCount) {
		if (sio->sioRpfCount > sio->sioRpfMax) {
			sio->sioRpfMax = sio->sioRpfCount;
		}
		sio->sioRpfSum += sio->sioRpfCount;
		++sio->sioRpfFrames;
		if (sio->sioRpfCount > 9u) {
			++sio->sioRpfOver;
		}
		if ((sio->sioRpfFrames % 300u) == 0u) {
			SIO_LOG("ROUNDSPF frames=%u sum=%u avg=%.2f max=%u over9=%u",
			        (unsigned) sio->sioRpfFrames, (unsigned) sio->sioRpfSum,
			        (double) sio->sioRpfSum / (double) sio->sioRpfFrames,
			        (unsigned) sio->sioRpfMax, (unsigned) sio->sioRpfOver);
		}
	}
	sio->sioRpfFrame = f;
	sio->sioRpfCount = 1;
}

/* 【按帧索引投递 2026-11-17 23:5x】
 *
 * FR9 定案：错格会在两端之间随机翻转 —— B 收得完全正确、A 整帧右移 4 格
 *（`0000,0000,1133,0000,8888,8888,8888,8888`）。根因是 `recvCmdIndex`
 * 由「到达顺序」驱动：传输层丢/重一拍，索引就滑掉，而 `LOCKPHASE` 只在
 * 每 9 拍的帧首清零，补不回中间几格。
 *
 * 但两端**本来就在 `netLinkPush` 的高 16 位里带了 idxW**（这个字在发送方
 * 帧里的槽号，见 sioPackPush）。既然槽号随行，接收端就完全不必依赖到达
 * 顺序：
 *   - 收字时按 idxW 存进 9 格缓冲（每个槽号一格）；
 *   - 投递给游戏时按**本端自然 recvCmdIndex** 取那一格。
 * ⇒ 本端 rc/sc 一个字节都不改（所以不会重演 TR50 那种「自己槽回环帧被打散」），
 *   而发送侧的滑拍只影响「到达顺序」，不再决定「落哪一格」。
 *
 * 边界：该格还没到（对端确实没发）时退回原行为并计数 miss。COAST 已经
 * 提前缓冲 8 轮，正常情况下这一格一定在。
 * 开关 MGBAX_IDXDELIVER=1（默认关）。 */
static int sioIdxDeliverOn(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_IDXDELIVER");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	return enabled;
}

/* 返回应当投递给游戏的 16 位字。remote 的低 16 位是字本身，bit16..19 是 idxW。 */
static uint16_t sioIdxDeliver(struct SioLink* sio, uint32_t remote, unsigned naturalRc) {
	if (!sioIdxDeliverOn() || !(remote & 0x01000000u)) {
		return (uint16_t) (remote & 0xFFFFu);
	}
	unsigned idxW = (remote >> 16) & 0xFu;
	if (idxW <= 8u) {
		sio->sioIdxBuf[idxW] = (uint16_t) (remote & 0xFFFFu);
		sio->sioIdxMask |= (uint16_t) (1u << idxW);
	}
	if (naturalRc <= 8u && (sio->sioIdxMask & (uint16_t) (1u << naturalRc))) {
		uint16_t v = sio->sioIdxBuf[naturalRc];
		sio->sioIdxMask &= (uint16_t) ~(1u << naturalRc);
		++sio->sioIdxHit;
		return v;
	}
	++sio->sioIdxMiss;
	if ((sio->sioIdxMiss % 200u) == 1u) {
		SIO_LOG("IDXDELIVER miss n=%u rc=%u idxW=%u mask=%03X hit=%u",
		        (unsigned) sio->sioIdxMiss, naturalRc, idxW,
		        (unsigned) sio->sioIdxMask, (unsigned) sio->sioIdxHit);
	}
	return (uint16_t) (remote & 0xFFFFu);
}

/* 【COAST：消费滞后 N 轮 2026-11-17 23:2x】
 *
 * 帧率被压在 24fps 的物理原因（子智能体帧率线取证 + SIOPERF 实测一致）：
 * 从机的时序是「先收到主机本轮字（2375）→ 再回推本轮字（2441）」，而主机
 * 在本轮 sioDone（18363 cycles≈1.09ms）就到点取从机的字 ⇒ 主机每轮必等
 * ≈2L−T（L=单向延迟≈4.5ms）≈8ms；9 轮/帧 ⇒ 41.8ms/帧。
 * 调门/加轮询都救不了：轮询只是把「墙钟冻结」换成「帧跑满但每帧 SIO 中断
 * 不足 9 次」⇒ LinkVSync 置 LAG_MASTER ⇒ CheckErrorStatus 拆链（FR2 实证）。
 *
 * 唯一解是让**消费滞后 N 轮**：本端 peerQ 深度还不到 N 时，这一轮不消费
 * 对端字，改用上一轮的真字补槽，但**轮次照常完成**。这样
 *   - 每帧仍是 9 轮（rc/sc 照常各进一格），模拟时间不膨胀 ⇒ 帧率回 60；
 *   - 一个字都不丢：对端仍在推，本端 peerQ 每轮 +1，N 轮后深度到 N；
 *   - pushIn 仍等于 ok，不会重演 TR14 那种「单侧复用旧字把标签流搞断」；
 *   - 校验和不受影响：CS_FORGE（默认开）在 sc==0 那一拍把两格都改写成
 *     gLink.checksum，8 轮累加整体平移已不参与比对。
 * 代价：输入延迟 +N 轮（本地 N=8 ≈ 2ms 模拟时间；跨公网要按 RTT 放大）。
 *
 * N 由 MGBAX_SIO_COAST_N 指定，**默认 0 = 完全关闭**（零回归）。
 * 建议值 8；上限 56（PEER_QUEUE=64）。两端可不同值（各自独立垫深，只是常数
 * 偏移不同），便于单变量对照。
 *
 * 注意：核对过「不要和 MGBAX_FAST_MIN_OK=8 一起用」——那会把垫深塞进训练家
 * 卡片块交换窗口（块校验按轮次逐块比对），用默认 256 时垫深只发生在块交换
 * 结束之后。 */
static bool sioCoastReady(struct SioLink* sio) {
	if (!sio->sioCoastInited) {
		const char* v = getenv("MGBAX_SIO_COAST_N");
		int n = v ? atoi(v) : 0;
		if (n < 0) {
			n = 0;
		}
		if (n > 56) {
			n = 56;
		}
		sio->sioCoastN = (uint32_t) n;
		sio->sioCoastInited = true;
		if (sio->sioCoastN) {
			fprintf(stderr, "SIOCOAST N=%u (消费滞后 N 轮；0=关闭)\n",
			        (unsigned) sio->sioCoastN);
		}
	}
	if (!sio->sioCoastN || !sio->link) {
		return false;
	}
	/* 【必须等训练家卡片块交换彻底结束】块校验是按轮次逐块比对的，垫深会让
	 * 块内容变成陈旧字 ⇒ 块永远拼不起来。所以门取 `gReceivedRemoteLinkPlayers`
	 *（0x03002AC1，[diag] 里的 rem）：只有在 LINKUP 完全成功（两端都收到对端
	 * 训练家卡）之后才允许垫深。这也顺带避开「和 MGBAX_FAST_MIN_OK=8 一起用
	 * 会把垫深塞进块交换窗口」那个坑。 */
	if (sioGLinkState(sio) < 4u) {
		return false;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) != 1u) {
		return false;
	}
	return true;
}

/* 【对端命令帧变化追踪 2026-11-17 00:5x】
 * LINKSTAT 每 900 拍采一次样，而 `gRecvCmds` 每收到一帧就被整帧覆盖；一次性
 * 命令（`0x2222` 链路类型、`0xBBBB` 块头、`0xCCCC` 块请求）**只存在一帧**，
 * 采样必然漏掉。所以这里逐拍比对，只在内容真的变了时打一行。
 * 关掉用 MGBAX_CMDTRACE=0（默认关）。 */
/* 【cable_club 任务表探针 2026-11-17 00:3x】
 *
 * 黑屏卡死定位：一端 fade 到黑等 `!gReceivedRemoteLinkPlayers`
 * （Task_StartWiredCableClubBattle case 4），另一端停在房间里不动。
 * 光看 gLink 侧看不出来，必须直读任务表：`struct Task { TaskFunc func; bool8
 * isActive; u8 prev,next,priority; s16 data[16]; }`，stride 0x28，最多 16 个。
 * func 落在 cable_club 的地址区间就认为是联机流程的任务，打出来即可对号入座。
 * 地址来自同构建 rom.elf（rom.gba 已换成 22:59 那份，md5 d23d3197…）：
 *   Task_LinkupAwaitTrainerCardData = 0x08105A34
 *   Task_StartWiredCableClubBattle  = 0x08105F90
 *   （整段 Task_Linkup* 在 0x081054DC..0x08105B28）
 * 开关 MGBAX_TASKPROBE=1（默认关）。 */
static void sioTaskProbe(struct GBA* gba) {
	char* out = s_sioTaskBuf;
	size_t outLen = sizeof(s_sioTaskBuf);
	out[0] = '\0';
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_TASKPROBE");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !gba || !gba->cpu) {
		return;
	}
	const uint32_t gTasks = SIO_EW(0x02033D0Cu);
	size_t used = 0;
	unsigned activeCnt = 0;
	unsigned badCnt = 0;
	/* 自证：把 16 个槽的 isActive 全查一遍。真 gTasks 的 isActive 只能是
	 * 0/1；出现别的值说明地址不对（实测曾经把 gTasks 读成别的结构，
	 * func 落在某个函数的中间，例如 CrackedFloorPerStepCallback+0xC8）。 */
	for (unsigned i = 0; i < 16u; ++i) {
		uint32_t base = gTasks + i * 0x28u;
		if (base + 0x28u > GBA_EWRAM_END) {
			break;
		}
		uint8_t act = GBAView8(gba->cpu, base + 4u);
		if (act > 1u) {
			++badCnt;
		} else if (act == 1u) {
			++activeCnt;
		}
	}
	/* 输出全部 16 槽：之前只打前 4 个，实测 B 端 act=5 且第 5 个恰好是
	 * cable club 任务，被截掉导致误判"B 没有联机任务"。 */
	for (unsigned i = 0; i < 16u; ++i) {
		uint32_t base = gTasks + i * 0x28u;
		if (base + 0x28u > GBA_EWRAM_END) {
			break;
		}
		uint8_t a = GBAView8(gba->cpu, base + 4u);
		if (!a) {
			continue;   /* 只打活跃槽，避免刷屏 */
		}
		uint32_t func = GBAView32(gba->cpu, base) & ~1u;
		uint8_t act = a;
		int n = snprintf(out + used, outLen - used, "%s%u:%06X/%u", used ? "," : "",
		                 i, (unsigned) (func & 0xFFFFFFu), (unsigned) act);
		if (n <= 0 || (size_t) n >= outLen - used) {
			break;
		}
		used += (size_t) n;
	}
	snprintf(out + used, outLen - used, " act=%u bad=%u", activeCnt, badCnt);
}

/* 【从 ROM 解析 EWRAM 偏移 2026-11-17 00:4x】
 *
 * IWRAM 用「gRecvCmds 与 gSendCmd 相差 0x66」这个结构性判据；EWRAM 没有这种
 * 成对关系，但有另一个更强的信号：**`gTasks` 是 ROM 里被引用最多的 EWRAM
 * 字面量**（实测 1838 次，比第二名 1334 高 38%），而且它的结构可以**运行期
 * 校验**：
 *     struct Task { TaskFunc func; bool8 isActive; u8 prev,next,priority; s16 data[16]; };
 *     16 个槽、stride 0x28；func 必须是 0 或落在 ROM 区间（0x08xxxxxx），
 *     isActive 只能是 0/1，且至少有一个非零 func 和一个 active。
 * 所以：按引用次数取前 8 个候选，逐个做结构校验，第一个通过的就是 gTasks。
 * 之后其余 EWRAM 地址按「相对 gTasks 的偏移」跟着平移（同一份源码里这个
 * 相对距离不变）。
 * 实测本构建：gTasks=0x02033D0C refs=1838，一次命中。
 * 开关/兜底同 IWRAM：MGBAX_IWRAM_DELTA 可强制；失败则沿用 delta=0。 */
static bool sioLooksLikeTasks(struct GBA* gba, uint32_t base) {
	unsigned active = 0;
	unsigned nonzero = 0;
	for (unsigned i = 0; i < 16u; ++i) {
		uint32_t fbase = base + i * 0x28u;
		uint32_t func = GBAView32(gba->cpu, fbase);
		uint8_t act = GBAView8(gba->cpu, fbase + 4u);
		if (act > 1u) {
			return false;
		}
		if (func != 0u) {
			if ((func & 0xFE000000u) != GBA_ROM_BASE) {
				return false;
			}
			++nonzero;
			if (act) {
				++active;
			}
		}
	}
	return nonzero >= 1u && active >= 1u && active <= 8u;
}

static void sioResolveEwramDelta(struct SioLink* sio) {
	if (sioEwramDeltaDone) {
		return;
	}
	sioEwramDeltaDone = true;
	/* 默认开启（=0 才关）。
	 * 【排障记录】曾经连续 4 次「启动 5~10 秒后静默退出」，误判成本函数的问题；
	 * 真凶其实是 `[diag]` 的格式串加了 `tasks=%s` 却没配对应参数，printf
	 * 从栈上读垃圾指针当字符串用 ⇒ 段错误。本函数本身没问题，ADDR6 实测：
	 *     SIOEW gTasks=0x02033D0C(refs 1838) delta=0x0
	 * 以后再遇到「无任何输出的启动即退出」，先核对每条 SIO_LOG 的格式符与
	 * 参数个数是否一一对应。 */
	{
		static int autoOn = -1;
		if (autoOn < 0) {
			const char* v = getenv("MGBAX_EWRAM_AUTO");
			autoOn = (v && atoi(v) == 0) ? 0 : 1;
		}
		if (!autoOn) {
			return;
		}
	}
	const char* forced = getenv("MGBAX_EWRAM_DELTA");
	if (forced && *forced) {
		sioEwramDelta = (uint32_t) strtoul(forced, NULL, 0);
		fprintf(stderr, "SIOEW delta forced = 0x%X\n", (unsigned) sioEwramDelta);
		return;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	/* 候选：本 ROM 里引用最多的若干 EWRAM 字面量。为省内存按 4 字节槽计数
	 * （gTasks 本身 4 字节对齐，计数精确）。 */
	static uint16_t cnt[0x40000 / 4];
	memset(cnt, 0, sizeof(cnt));
	static const char* candidates[] = { "rom.gba", "D:/mgba-android-version/rom.gba" };
	const char* envRom = getenv("MGBAX_ROM_PATH");
	const char* chosen = NULL;
	FILE* fp = NULL;
	if (envRom && *envRom) {
		fp = fopen(envRom, "rb");
		chosen = fp ? envRom : NULL;
	}
	for (size_t i = 0; !fp && i < sizeof(candidates) / sizeof(candidates[0]); ++i) {
		fp = fopen(candidates[i], "rb");
		if (fp) {
			chosen = candidates[i];
		}
	}
	const uint8_t* romMem = NULL;
	size_t romSize = 0;
	size_t memOff = 0;
	if (!fp) {
		romMem = sioLoadedRomBytes(sio, &romSize);
		if (romMem && romSize >= 0x1000u) {
			chosen = "LOADED-ROM";
		} else {
			romMem = NULL;
		}
	}
	if (!fp && !romMem) {
		fprintf(stderr, "SIOEW 打不到 ROM，EWRAM 偏移沿用 0\n");
		return;
	}
	static uint8_t buf[1 << 20];
	size_t got;
	for (;;) {
		if (fp) {
			got = fread(buf, 1, sizeof(buf), fp);
		} else {
			size_t left = romSize - memOff;
			if (left == 0u) {
				got = 0;
			} else {
				if (left > sizeof(buf)) {
					left = sizeof(buf);
				}
				memcpy(buf, romMem + memOff, left);
				memOff += left;
				got = left;
			}
		}
		if (got == 0u) {
			break;
		}
		for (size_t i = 0; i + 4 <= got; i += 4) {
			uint32_t v = (uint32_t) buf[i] | ((uint32_t) buf[i + 1] << 8)
			             | ((uint32_t) buf[i + 2] << 16) | ((uint32_t) buf[i + 3] << 24);
			if (v >= GBA_EWRAM_BASE && v < GBA_EWRAM_SCAN_END && (v & 3u) == 0u) {
				uint16_t* c = &cnt[(v - GBA_EWRAM_BASE) >> 2];
				if (*c < 0xFFFFu) {
					++*c;
				}
			}
		}
	}
	if (fp) {
		fclose(fp);
	}
	/* 取前 8 个候选（按次数） */
	uint32_t bestAddr[8];
	uint32_t bestCnt[8];
	/* 两个都要清零：只清 bestCnt 时，排名没填满的槽会带着**未初始化的
	 * bestAddr** 进后面的校验循环 → 拿垃圾地址去读内存 → 越界崩，
	 * 表现就是启动几秒后进程直接退出（FATAL: A 退出）。 */
	memset(bestAddr, 0, sizeof(bestAddr));
	memset(bestCnt, 0, sizeof(bestCnt));
	for (uint32_t idx = 0; idx < (0x40000u / 4u); ++idx) {
		uint32_t c = cnt[idx];
		if (c < 100u) {
			continue;
		}
		uint32_t addr = GBA_EWRAM_BASE + idx * 4u;
		for (unsigned j = 0; j < 8u; ++j) {
			if (c > bestCnt[j]) {
				for (unsigned k = 7u; k > j; --k) {
					bestCnt[k] = bestCnt[k - 1];
					bestAddr[k] = bestAddr[k - 1];
				}
				bestCnt[j] = c;
				bestAddr[j] = addr;
				break;
			}
		}
	}
	(void) chosen;
	for (unsigned j = 0; j < 8u; ++j) {
		if (!bestAddr[j]) {
			continue;
		}
		/* 16 个任务槽占 16*0x28 = 0x280 字节，候选必须整段落在 EWRAM 内；
		 * 否则 GBAView32 会越界读（实测能把进程直接带崩，表现为启动即退出）。 */
		if (bestAddr[j] + 0x280u > GBA_EWRAM_END) {
			continue;
		}
		if (!sioLooksLikeTasks(gba, bestAddr[j])) {
			continue;
		}
		sioEwramDelta = bestAddr[j] - SIO_EW_BASE_GTASKS;
		fprintf(stderr, "SIOEW gTasks=0x%08X(refs %u) delta=0x%X\n",
		        (unsigned) bestAddr[j], (unsigned) bestCnt[j], (unsigned) sioEwramDelta);
		return;
	}
	fprintf(stderr, "SIOEW 没找到可信的 gTasks（前 8 候选都没通过结构校验），EWRAM 偏移沿用 0\n");
}

static void sioCmdTrace(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CMDTRACE");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	if (me < 0 || me > 3) {
		return;
	}
	int peer = (me == 0) ? 1 : 0;
	uint16_t cur[8];
	bool changed = false;
	for (int i = 0; i < 8; ++i) {
		cur[i] = GBAView16(gba->cpu, SIO_IW(0x03002A4Au) + (unsigned) peer * 16u + (unsigned) i * 2u);
		if (cur[i] != sio->sioCmdCache[i]) {
			changed = true;
		}
	}
	if (!changed) {
		return;
	}
	memcpy(sio->sioCmdCache, cur, sizeof(cur));
	if (sio->sioCmdLog >= 400u) {
		return;
	}
	++sio->sioCmdLog;
	SIO_LOG("CMDFRM n=%u t=%u me=%d peer=%d lb=%u sc=%u rc=%u "
	        "w=%04X,%04X,%04X,%04X,%04X,%04X,%04X,%04X",
	        (unsigned) sio->sioCmdLog, (unsigned) wallNowMs(), me, peer,
	        (unsigned) sio->sioRoundLabel,
	        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF),
	        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u),
	        cur[0], cur[1], cur[2], cur[3], cur[4], cur[5], cur[6], cur[7]);
}

static void sioLinkStat(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_LINKSTAT");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	static uint32_t statN;
	if ((++statN % 900u) != 0u) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	struct ARMCore* cpu = gba->cpu;
	uint16_t snd[8], r0[8], r1[8];
	for (int i = 0; i < 8; ++i) {
		snd[i] = GBAView16(cpu, SIO_IW(0x03002AB0u) + (unsigned) i * 2u);
		r0[i] = GBAView16(cpu, SIO_IW(0x03002A4Au) + (unsigned) i * 2u);
		r1[i] = GBAView16(cpu, SIO_IW(0x03002A5Au) + (unsigned) i * 2u);
	}
	SIO_LOG("LINKSTAT t=%u lb=%u st=%08X cb=%08X rem=%u nr0=%02X nr1=%02X b0=%u/%u b1=%u/%u "
	        "snd=%04X,%04X,%04X,%04X,%04X,%04X,%04X,%04X "
	        "r0=%04X,%04X,%04X,%04X,%04X,%04X,%04X,%04X "
	        "r1=%04X,%04X,%04X,%04X,%04X,%04X,%04X,%04X",
	        (unsigned) wallNowMs(), (unsigned) sio->sioRoundLabel,
	        (unsigned) GBAView32(cpu, SIO_IW(0x03002A9Cu)),
	        (unsigned) GBAView32(cpu, SIO_IW(0x03002AD4u)),
	        (unsigned) GBAView8(cpu, SIO_IW(0x03002AC1u)),
	        (unsigned) GBAView8(cpu, SIO_IW(SIO_REMOTE_PLAYERS_NOT_RECEIVED)),
	        (unsigned) GBAView8(cpu, SIO_IW(SIO_REMOTE_PLAYERS_NOT_RECEIVED) + 1u),
	        (unsigned) GBAView16(cpu, SIO_IW(0x03002990u)), (unsigned) GBAView16(cpu, SIO_IW(0x03002992u)),
	        (unsigned) GBAView16(cpu, SIO_IW(0x03002998u)), (unsigned) GBAView16(cpu, SIO_IW(0x0300299Au)),
	        snd[0], snd[1], snd[2], snd[3], snd[4], snd[5], snd[6], snd[7],
	        r0[0], r0[1], r0[2], r0[3], r0[4], r0[5], r0[6], r0[7],
	        r1[0], r1[1], r1[2], r1[3], r1[4], r1[5], r1[6], r1[7]);
}

/* 【帧相位闸门 2026-11-16 22:xx】
 *
 * 9 拍命令帧能不能对上，只取决于一件事：**两端进入 CONN_ESTABLISHED 的
 * 共享轮次号对 9 取模是否相同**。两端各自从自己的进入点开始数
 * sendCmdIndex/recvCmdIndex，进入点只要差 k 轮，整帧就永久旋转 k 格，
 * ProcessRecvCmds 只认 gRecvCmds[i][0]，于是 0x2222/BBBB/8888 全部识别
 * 不到（实测 TR25：`sBlockRecv[i].size` 恒 0；TR26/27：只有一端 rem=1）。
 *
 * 用锚点做事后校正治不好：把 rc 从 6 拽回 0 等于把本帧拉长 6 拍，只救
 * 当前这一帧，对端 9 拍后的下一帧又错开（TR28：A 端 p1 一直是 32768/0）。
 * 而且对齐必须同时把 sc 设成 1（维持 ROM 的 sc=rc+1 不变式），那一帧会
 * 跳过 data[0] —— 正是 0x2222/BBBB/8888 这些帧首命令字，等于把自己的块
 * 帧头丢光。
 *
 * 所以正确的做法是**在进入 CONN_ESTABLISHED 之前就把轮次钉到帧边界**：
 * 在 HANDSHAKE(2) / INIT_TIMER(3) 里 sc/rc 本来就不推进，卡多久都不产生
 * 副作用（只会多发几轮握手字），等到 `label % 9 == 0` 再放行。两端都用
 * 同一个共享轮次号判定，于是进入点必然同余 ⇒ 帧天然对齐。
 *
 * - 从机：进入发生在 SerialCB 里（DoHandshake 返回 TRUE），可以逐轮卡。
 * - 主机：ROM 的 3→4 发生在 LinkMain1（每 VBlank 一次），粒度是整帧，
 *   没法逐轮选边；所以闸门打开那一刻**直接把 state 从 3 写成 4**。
 *   InitTimer 因此被跳过，但 SendRecvDone 每轮都会 `REG_TM3CNT_H |=
 *   TIMER_ENABLE`（gen8 link.c:2411），轮次由本端传输层驱动，不依赖它。 */
static void sioPhaseGate(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_PHASE_GATE");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	unsigned st = GBAView8(gba->cpu, SIO_IW(0x03002AF5u));   /* gLink.state */
	if (st < 2u) {
		sio->sioPhaseGateOpen = false;               /* 链路重建 ⇒ 重新闸 */
		return;
	}
	if (sio->sioPhaseGateOpen) {
		return;
	}
	unsigned lbl = (unsigned) sio->sioRoundLabel;
	if ((lbl % 9u) != 0u) {
		if (st == 4u) {
			/* 已经擅自进了 CONN_ESTABLISHED：按角色退回去等帧边界。
			 * 这两种状态里 sc/rc 都不推进，退回去没有副作用。 */
			uint8_t back = (GBAView32(gba->cpu, SIO_IW(0x03002A9Cu)) & 0x20u) ? 3u : 2u;
			GBAPatch8(gba->cpu, SIO_IW(0x03002AF5u), back, NULL);
		}
		return;
	}
	sio->sioPhaseGateOpen = true;
	if (st == 3u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AF5u), 4u, NULL);  /* 主机：钉在帧边界进 4 */
	}
	SIO_LOG("PHASEGATE open lb=%u state=%u", lbl, st);
}

/* 【CMD-FRAMEALIGN — 2026-11-18 ROOTCAUSE fix】
 *
 * gen8 的 SerialCB = DoRecv→DoSend→SendRecvDone，9 拍一帧：
 *   DoRecv : sc==0 那拍只比校验和；其它拍把 SIOMLT_RECV[i] 存进
 *            recvQueue.data[i][recvCmdIndex]，再 rc++；rc==8 且有非零字 ⇒ count++。
 *   DoSend : sc==8 写校验和+弹队；其它拍发 sendQueue.data[sc]，再 sc++。
 *   SendRecvDone: rc==8 ⇒ sc=rc=0。
 * 主机在 sc==0 那一拍把 LINKCMD_SEND_LINK_TYPE(0x2222) 写在自己帧的 data[0]；
 * 从机只有在**收到这一拍时 recvCmdIndex==0**，才会把它存进 recvQueue[0][0]，
 * 随后 DequeueRecvCmds 把它搬到 gRecvCmds[0][0]，ProcessRecvCmds 才认得出来
 * 并 InitBlockSend(0xBBBB)。
 *
 * APPNAVDEADLOCK2 现场：主机确实推了 2222/2233（SLOT n=17/18 data[0]=2222/2233，
 * idx/hostidx=24 gap=0，没有任何丢字），但从机收这一拍时 sc=2、rc=1（比正确
 * 相位各多一拍）⇒ 2222 被存进 recvQueue[0][1]，gRecvCmds[0][0] 永远是上一帧
 * 残留的握手字 8FFF/B9A0 ⇒ ProcessRecvCmds 看不到帧首 ⇒ cq=0/rem=0 ⇒
 * 600 帧 TryLinkTimeout 拆链。diag 的 r00=8FFF r10=B9A0 不是"陈旧字复用"，
 * 是 2222 落错槽。
 *
 * 修法：在 cmd 期第一次看到帧首 opcode（0x2222 主机帧首 / 0xBBBB 从机块帧首）
 * 的那一轮，**一次**把 sc 钉成 1、rc 钉成 0（=正确的帧首相位），此后交给游戏
 * 自己的单调自增跑完整帧。只做一次、只在帧首，不碰 recvQueue.pos/count，
 * 所以不会重蹈"每轮硬写索引 ⇒ recvQueue.count 恒 0"的覆辙（见 :1741 注释）。
 * 关掉用 MGBAX_CMD_FRAMEALIGN=0。 */
static void sioAlignCmdFrameHeader(struct SioLink* sio, uint32_t remote) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CMD_FRAMEALIGN");
		/* 【2026-11-18 H4 SIO-CMD-SIM】默认开启：校验器证明在 0x2222 落地的那一轮
		 * 把接收端 (sc,rc) 钉成 (1,0) 是唯一能让 DoRecv 把它存进 recvQueue[0][0]
		 * 的相位，对 phase offset 0..8 全部成立。关键在**时机**：必须在
		 * finishMultiTransfer 触发 SerialCB/DoRecv **之前**生效（ON/before=PASS，
		 * ON/after=FAIL），且之后不得被其它索引写入者覆盖。调用点见 :3055 前。
		 * MGBAX_CMD_FRAMEALIGN=0 关闭。 */
		enabled = (v && atoi(v) == 0) ? 0 : 1;   /* 默认开 */
	}
	if (!enabled || !sio || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	uint16_t w = (uint16_t) remote;
	/* 【ROOTHUNT 迭代 25】0x8888 CONT_BLOCK 也是独立命令帧首，必须在它
	 * 到达时把接收相位钉成 (sc=1,rc=0)，否则块数据被 filed 到 rc=1 ⇒
	 * gRecvCmds[0][0] 恒 0000/C03C/5CAC，sBlockRecv[0].pos 永远停在 0。 */
	/* 迭代 37: 0x5FFF READY_CLOSE_LINK 也是帧首 opcode —— 不把接收相位钉成
	 * (sc=1,rc=0) 就会被 filed 到 recvQueue[0][1]，ProcessRecvCmds 看不到，
	 * gReadyToCloseLink[i] 永不置位 ⇒ LinkCB_WaitCloseLink 等不齐 ⇒ CloseLink
	 * 不执行 ⇒ 关链后卡死进错误屏。 */
	if (w != LINKCMD_SEND_LINK_TYPE && w != LINKCMD_INIT_BLOCK && w != LINKCMD_CONT_BLOCK && w != LINKCMD_READY_CLOSE_LINK) {
		return;
	}
	/* 【ROOTHUNT】帧首检测点取证：0 hits 时看这里到底是「没看到 2222」还是
	 * 「看到但 sc/rc 本来就 (1,0)」还是「被 blk/one-shot 门挡住」。 */
	{
		static unsigned ahN;
		if (rhVerbose() && ++ahN <= 16) {
			struct GBA* gh = (struct GBA*) sio->core->board;
			SIO_LOG("[RHALIGN] n=%u w=%04X st=%u blk=%u fired=%u sc=%u rc=%u ok=%u",
			        ahN, w, (unsigned) GBAView8(gh->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF),
			        (unsigned) GBAView8(gh->cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID)),
			        sio->sioCmdFrameAligned ? 1u : 0u,
			        (unsigned) GBAView8(gh->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF),
			        (unsigned) GBAView8(gh->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_RECVCMD_IX_OFF),
			        (unsigned) sio->sioOk);
		}
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	struct ARMCore* cpu = gba->cpu;
	unsigned st = GBAView8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	if (st < 4u) {
		sio->sioCmdFrameAligned = false;
		return;
	}
	if (GBAView8(cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID)) == 1u && !sioPhaseFixOn()) {
		return;   /* rem==1 仅 trainer card 收齐；PHASE-FIX 门开时继续为 party 块钉正相位 */
	}
	/* 【ROOTHUNT 迭代 10】one-shot 只针对**同一个** opcode：0x2222 与
	 * 0xBBBB 是两个独立的命令帧，各自需要一次相位对齐。旧实现 0x2222
	 * 对齐后 sioCmdFrameAligned 永久置真，0xBBBB 到来时直接 return，
	 * 块首若已漂移就落错 recvQueue 槽 ⇒ brs=0000/rem=0。 */
	/* 0x8888 是每帧重复的 CONT_BLOCK 帧首，不能被 one-shot 锁住 */
	/* 【ROOTHUNT2 P0/X40 方案A1】LINKCMD_INIT_BLOCK(0xBBBB) 也纳入每帧重钉：
	 * 原 one-shot 粘滞让首次 BBBB 若在漂移相位被钉，整块头帧错格且不再自愈。 */
	if (sio->sioCmdFrameAligned && sio->sioLastAlignHeader == w
	    && w != LINKCMD_INIT_BLOCK && w != LINKCMD_CONT_BLOCK && w != LINKCMD_READY_CLOSE_LINK) {
		return;
	}
	unsigned sc = GBAView8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF);
	unsigned rc = GBAView8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_RECVCMD_IX_OFF);
	sio->sioCmdFrameAligned = true;
	sio->sioLastAlignHeader = w;
	if (sc == 1u && rc == 0u) {
		return;   /* 本来就对齐 */
	}
	GBAPatch8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF, 1, NULL); /* sendCmdIndex = 1 */
	GBAPatch8(cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_RECVCMD_IX_OFF, 0, NULL); /* recvCmdIndex = 0 */
	SIO_LOG("CMDFRAMEALIGN header=%04X sc=%u->1 rc=%u->0", (unsigned) w, sc, rc);
}

/* ===================== X10-OBSCHAIN 观测链（纯只读，仅 SIO_LOG） =====================
 * 不写 gLinkOpen / gLink.state / tempRecvBuffer / rem / nr / brs / party / 信任位；
 * 唯一副作用是新增 [OBSCHAIN] 日志行，现有标签与判据零影响。 */

/* driver-only 门（PC 无 C 门函数）的 env 只读回读，绝不臆造为 0。 */
static int obsChainEnvOn(const char* name) {
	const char* e = getenv(name);
	return (e && atoi(e) == 1) ? 1 : 0;
}

/* OBS-A：启动一次性「现成门」快照。读本文件现成 getter；
 * forcehs/race/isync 为 driver/移动端门，PC 侧按 env 只读回读并在字段旁注明。 */
static void obsChainGateOnce(void) {
	static bool done;
	if (done || !obsChainOn()) {
		return;
	}
	done = true;
	SIO_LOG("[OBSCHAIN][GATES] gray_all=%u gray_lobby=%u btcfg=%u b7=%u rh_off=%u"
	        " hsbypass=%u bus_hs_preserve=%u forcehs=%u hs_hold=%u sticky2222=%u"
	        " localbus_2p=%u pathb_native=%u race=%u isync=%u",
	        (unsigned) (sioGrayAllOn() ? 1 : 0),
	        (unsigned) (sioGrayLobbyOpenOn() ? 1 : 0),
	        (unsigned) (linkBtcfgOn() ? 1 : 0),
	        (unsigned) (b7Verbose() ? 1 : 0),
	        (unsigned) (rhPatchesOff() ? 1 : 0),
	        (unsigned) (sioHsBypassOn() ? 1 : 0),
	        (unsigned) (sioBusHsPreserveOn() ? 1 : 0),
	        (unsigned) obsChainEnvOn("MGBAX_LINK_FORCEHS"),
	        (unsigned) (sioHsHoldOn() ? 1 : 0),
	        (unsigned) (sioBlock2222On() ? 1 : 0),
	        (unsigned) (sioLocalBus2pOn() ? 1 : 0),
	        (unsigned) (sioPathBNativeSioOn() ? 1 : 0),
	        (unsigned) obsChainEnvOn("MGBAX_RACE_STRESS"),
	        (unsigned) obsChainEnvOn("MGBAX_ISYNC_STATE_APPLY"));
}

/* OBS-C（state 变化沿）+ X10-B（open 只读） + OBS-D（provenance） + OBS-B'（代理字段）。
 * 由 completeMultiTransfer 每轮调用；门关立即返回。 */
static void obsChainTick(struct SioLink* sio) {
	if (!obsChainOn()) {
		return;
	}
	obsChainGateOnce();
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return;
	}
	struct ARMCore* cpu = gba->cpu;
	uint32_t lk = SIO_IW(SIO_GLINK_STATE);
	uint8_t st = GBAView8(cpu, lk + SIO_GLINK_STATE_OFF);
	uint8_t pc = GBAView8(cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF);

	/* ---- OBS-C：gLink.state 变化沿（含 4→2 回落），200 条上限，非采样 ---- */
	static uint8_t lastSt = 0xFFu;
	static uint32_t stN;
	if (st != lastSt && stN < SIO_OBS_CHAIN_MAX_LINES) {
		uint16_t mu = GBAView16(cpu, SIO_EW(SIO_BATTLE_COMM)) & 0xFFu;
		uint16_t brs = GBAView16(cpu, SIO_IW(SIO_GLOBAL_BLK_RECV_STATUS));
		uint32_t cb = (uint32_t) GBAView32(cpu, SIO_IW(SIO_GLINK_CALLBACK));
		uint32_t cb2 = (uint32_t) GBAView32(cpu, SIO_CB2_PTR);
		/* X10-B 决定性项：gLinkOpen **只读**；严禁复用 [B7OPEN] 的 GBAPatch8 写路径。 */
		uint8_t open = GBAView8(cpu, SIO_EW(SIO_LINK_OPEN));
		++stN;
		SIO_LOG("[OBSCHAIN][ST] n=%u from=%u->%u(0x%02X) cb2=%08X mu=%u pc=%u open=%u cb=%08X brs=%04X wall_ms=%u",
		        (unsigned) stN, (unsigned) lastSt, (unsigned) st, (unsigned) st,
		        (unsigned) cb2, (unsigned) mu, (unsigned) pc, (unsigned) open,
		        (unsigned) cb, (unsigned) brs, (unsigned) wallNowMs());
		lastSt = st;
	}

	/* ---- OBS-D / OBS-B' 的只读字段 ---- */
	uint16_t own = (uint16_t) gba->memory.io[GBA_REG(SIOMLT_SEND)];
	uint16_t push = sioWordOrEmpty(sio, sio->sioSelfSlot);
	uint16_t peer = (uint16_t) sio->sioRemote;
	uint8_t isMaster = GBAView8(cpu, lk + SIO_GLINK_ISMASTER_OFF);
	uint8_t localId = GBAView8(cpu, lk + SIO_GLINK_LOCALID_OFF);
	uint8_t recvNothing = GBAView8(cpu, lk + SIO_GLINK_RECV_NOTHING_OFF);

	const char* src;
	if (own == 0u && push == 0xFFFFu) {
		src = "empty";
	} else if ((own == LINK_HANDSHAKE_MASTER || own == LINK_HANDSHAKE_SLAVE)
	           && (sioPathBNativeSioOn() || sioHsBypassOn() || sioBusHsPreserveOn())) {
		src = "localbus";
	} else if (push != own) {
		src = "bridge";
	} else {
		src = "game";
	}

	static uint16_t lastProvOwn, lastProvPush, lastProxyOwn, lastProxyPeer;
	static uint32_t provN, proxyN;
	static unsigned obsN;
	++obsN;
	bool beat = ((obsN & SIO_PROBE_HEARTBEAT_MASK) == 0u);

	/* ---- OBS-D：[PROV] own_slot_word / net_push_word / src ---- */
	if ((own != lastProvOwn || push != lastProvPush || beat) && provN < SIO_OBS_CHAIN_MAX_LINES) {
		++provN;
		SIO_LOG("[OBSCHAIN][PROV] n=%u own_slot_word=%04X net_push_word=%04X src=%s st=%u wall_ms=%u",
		        (unsigned) provN, (unsigned) own, (unsigned) push, src,
		        (unsigned) st, (unsigned) wallNowMs());
		lastProvOwn = own; lastProvPush = push;
	}

	/* ---- OBS-B'：tempRecvBuffer 无具名宏/rom.map 0 命中，直读不可行；
	 * 只打显式标注的代理字段，peer_deliver_word 用 sioRemote 代理，绝不写成真值。 ---- */
	if ((own != lastProxyOwn || peer != lastProxyPeer || beat) && proxyN < SIO_OBS_CHAIN_MAX_LINES) {
		++proxyN;
		SIO_LOG("[OBSCHAIN][BPRX] proxy_for_temp_recv=1 n=%u pc=%u receivedNothing=%u isMaster=%u localId=%u sioRemote=%04X own_slot_word=%04X peer_deliver_word=%04X st=%u wall_ms=%u",
		        (unsigned) proxyN, (unsigned) pc, (unsigned) recvNothing,
		        (unsigned) isMaster, (unsigned) localId, (unsigned) peer,
		        (unsigned) own, (unsigned) peer, (unsigned) st, (unsigned) wallNowMs());
		lastProxyOwn = own; lastProxyPeer = peer;
	}
}

static void completeMultiTransfer(struct SioLink* sio, uint32_t remote, bool haveRemote, uint32_t cyclesLate) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	sioEstablishGate(sio);
	sioObserveCmdPhase(sio);
	/* 【ROOTHUNT 迭代 36】关链握手是双向的：gen8 LinkCB_ReadyCloseLink 发
	 * 0x5FFF 后，LinkCB_WaitCloseLink 要等**所有玩家**的 gReadyToCloseLink
	 * 才调 CloseLink()。APPHUNT-FIX：app 主机关链后 PC 从机停在 state4、
	 * 从不回 0x5FFF ⇒ 主机关链永不完成 ⇒ 卡在战斗启动直到错误屏。
	 * 这里收到对端 0x5FFF 时回推有限次 0x5FFF（opt-in，默认开）。 */
	/* 迭代 38：APPHUNT-5FFF 实证 16 次回显发出但 `gReadyToCloseLink` 恒 0 ——
	 * 关链阶段 gLinkStatus 的 CONN 位可能已清，LinkMain2 不再调
	 * ProcessRecvCmds，0x5FFF 即使落在 gRecvCmds[0][0] 也不会置标志。
	 * 与 rearm 补 handshakeAsMaster 同款：收到/发出 0x5FFF 时直接把
	 * gReadyToCloseLink[0..1] 置 1，让 LinkCB_WaitCloseLink 立即满足。 */
	/* 【档1 A 方案 i 写径门】投机字绝不进 5FFF 关链写径（5FFF 本身也已被
	 * gnpPredWordForbidden 禁投机，此处为纵深防御；门关时标记恒 false，零回归）。 */
	if (!sio->sioRemoteIsPredicted
	    && ((uint16_t) remote == LINKCMD_READY_CLOSE_LINK
	        || (GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(0x03002AB0u)) == 0xFFu
	            && GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(0x03002AB1u)) == 0x5Fu))) {
		unsigned pb = GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_RDY_CLOSE_LINK);
		GBAPatch8(((struct GBA*) sio->core->board)->cpu, SIO_RDY_CLOSE_LINK, 1, NULL);
		GBAPatch8(((struct GBA*) sio->core->board)->cpu, SIO_RDY_CLOSE_LINK + 1u, 1, NULL);
		SIO_LOG("[PATCH] rdy(cmt) remote=%04X addr=%08X before=%u after=%u me=%d",
		        (unsigned) (uint16_t) remote, (unsigned) SIO_RDY_CLOSE_LINK, pb,
		        (unsigned) GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_RDY_CLOSE_LINK),
		        netLinkPlayer(sio->link));
	}
	if (haveRemote && (uint16_t) remote == LINKCMD_READY_CLOSE_LINK) {
		static unsigned echoN;
		static int echoEn = -1;
		if (echoEn < 0) {
			const char* v = getenv("MGBAX_CLOSE_ECHO");
			echoEn = (v && atoi(v) == 0) ? 0 : 1;
		}
		if (echoEn && echoN < 16u) {
			++echoN;
			struct mTiming* tm = coreTiming(sio);
			netLinkPush(sio->link, GBA_SIO_MULTI, LINKCMD_READY_CLOSE_LINK,
			            (uint16_t) (sio->sioIndex + 1u),
			            tm ? mTimingCurrentTime(tm) : 0);
			if (rhVerbose()) {
				SIO_LOG("[RHECHO] echo 0x5FFF n=%u idx=%u", (unsigned) echoN, (unsigned) sio->sioIndex);
			}
		}
	}
	/* 【H4 写序审计】帧首对齐已移到本函数末尾（finishMultiTransfer 之前），
	 * 确保它是 SIO IRQ / SerialCB 之前**最后一个**写 +0x16/+0x17 的地方。
	 * 留在这里的旧调用已移除，避免被 sioHardCmdPhase/sioPhaseGate/
	 * sioAlignCmdPhase/CS_FORGE 之后的任何索引写入者覆盖。 */
	struct GBA* gba = (struct GBA*) sio->core->board;
	/* 【ROOTHUNT 迭代 11】块组装取证：sBlockRecv[0..1] 的 pos/size（每个
	 * 12 字节；0x03002A64 / +0xC），gBlockReceivedStatus@0x03002A40。
	 * 只在 0xBBBB/0x8888 轮打，找 pos 是否停在 size 之前。 */
	if (rhVerbose() && ((uint16_t) remote == LINKCMD_CONT_BLOCK || (uint16_t) remote == LINKCMD_INIT_BLOCK)) {
		static unsigned bn;
		if (++bn <= 60) {
			SIO_LOG("[RHBLK] n=%u me=%d w=%04X st=%u sc=%u rc=%u "
			        "blk0.pos=%u size=%u blk1.pos=%u size=%u brs=%04X r00=%04X r01=%04X",
			        (unsigned) sio->sioOk, netLinkPlayer(sio->link), (unsigned) (uint16_t) remote,
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u),
			        /* nm: sBlockRecv @0x03002A64 actual; SIO_IW adds delta(0xD4)
			         * ⇒ canonical 0x03002990 (each entry 12 bytes). */
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u)),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 2u),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 0x0Cu),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 0x0Eu),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002A40u)),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002A4Au)),
			        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002A4Au) + 2u));
		}
	}
	/* 【ROOTHUNT CMD-HANDOFF】握手保持的从机侧逻辑保持原样；根因在主机侧
	 * beginMultiTransfer 的 state>=4 残留握手字抑制（见下）。这里只留一条
	 * 取证日志：帧首字到达时记录相位，供 [RHALIGN] 交叉核对。 */
	if (rhVerbose() && haveRemote && ((uint16_t) remote == LINKCMD_SEND_LINK_TYPE || (uint16_t) remote == LINKCMD_INIT_BLOCK)
	    && (sio->sioOk <= 40 || (sio->sioOk % 256) == 0)) {
		SIO_LOG("[RHCMDSEEN] header=%04X gs=%04X ok=%u sc=%u rc=%u",
		        (unsigned) (uint16_t) remote,
		        (unsigned) GBAView32(gba->cpu, SIO_IW(0x03002A9Cu)),
		        (unsigned) sio->sioOk,
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x17u));
	}
	/* 【路线A / sioHandshakeHold 窗口装填】每轮只在这里装填一次
	 *（sioHandshakeHoldWord 一轮被多处调用，不可在那里扣减）。
	 * 关键修正（Z13）：旧实现只在**首次**进 st4 时装填一次、此后每轮 -1，
	 * 长 st4 空转就会耗尽窗口 ⇒ 主机真重握时 B9A0 已断供。现在改为：
	 *   对端真字仍是握手字（尤其主机 8FFF）⇒ 重新装满；
	 *   对端字变非握手字 / 进块期 / 掉线 / st<4 ⇒ 逐轮衰减或清零。
	 * 这样「对端还在握手」与「窗口有效」恒等价，绝不与对端互锁。 */
	{
		bool hsOn = linkBtcfgOn() && sioHsHoldOn() && sio->link
		            && netLinkState(sio->link) == 2u;
		unsigned st = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
		/* 路线A 语义钉死（ROOTHUNT2/Z17）：MGBAX_HS_HOLD 是纯布尔门
		 *（=0 关，非0/缺省开，见 sioHsHoldOn）；窗口轮数走具名常量，
		 * 绝不能把布尔值 1 误当 1 轮窗口而令保真失效（旧实现踩此坑）。 */
#define MGBAX_HS_HOLD_ROUNDS 20000u
		static int holdRounds = (int) MGBAX_HS_HOLD_ROUNDS;
		if (st < SIO_LINK_STATE_CONN || !hsOn) {
			sio->sioHsHoldArmed = false;
			sio->sioHsHoldLeft = 0;
			/* BF1 健壮性(C1 观察项3)：握手重启时清掉上一会话扣下的真 8FFF，
			 * 防止跨 LINK_RESET 残留旧 echo word 污染下一次握手。只清驱动侧快照，
			 * 不写游戏态、不造字。与 mobile 侧对偶。 */
			sio->sioMasterEchoWord = 0;
		} else if (haveRemote && sioIsHandshakeWord((uint16_t) remote)) {
			/* 真对端还在握手 ⇒ 重装窗口（B9A0 供给重新点亮）。 */
			bool rearmed = sio->sioHsHoldLeft == 0u;
			sio->sioHsHoldArmed = true;
			sio->sioHsHoldLeft = (uint16_t) holdRounds;
			if (rearmed && sio->sioOk <= 64u) {
				SIO_LOG("[HSHOLD] rearm peer=%04X st=%u ok=%u me=%d",
				        (unsigned) (uint16_t) remote, st, (unsigned) sio->sioOk,
				        netLinkPlayer(sio->link));
			}
		} else if (sio->sioHsHoldLeft > 0u) {
			--sio->sioHsHoldLeft;
		}
	}
	int me = netLinkPlayer(sio->link);
	uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
	if (me >= 0 && me < 4) {
		/* 用起轮时扣下的本机字，与推给对端的 own 严格同源；不要读实时
		 * SIOMLT_SEND（那时它可能已被游戏改成下一轮的字）。
		 * 【16:55】必须用 sioWordOrEmpty 而不是 `? : 0xFFFF`：state>=4
		 * 且 selfSlot==0（DoSend 空队列的合法字）时，对端收到的是 0，
		 * 本机若投递 0xFFFF，两端 8 轮校验和就不等 → badChecksum。 */
		data[me] = sioWordOrEmpty(sio, sio->sioSelfSlot);
	}
	if (haveRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) remote;
	}
	/* BF1 写序修复(2026-11-25，与 mobile 对偶)：me==0 时上面 data[me==0?1:0]=remote
	 * 即 data[0]=对端B9A0，覆盖早先的 8FFF 回环。放这里=握手期最后 data 写入者
	 * (CS_FORGE 仅 st>=4 不冲突)。只搬运游戏真写 8FFF，非造字。 */
	if (sioMasterEchoOn() && me >= 0 && me == 0 && sio->sioMasterEchoWord == LINK_HANDSHAKE_MASTER) {
		struct GBA* gba_echo = (struct GBA*) sio->core->board;
		if (gba_echo && gba_echo->cpu
		    && GBAView8(gba_echo->cpu,
		                SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN) {
			data[0] = sio->sioMasterEchoWord;
		}
	}
	/* 【平移线只在 state>=4 生效】握手期 DoHandshake 要求
	 * tempRecvBuffer[0] 恰是主机的 0x8FFF（gen8/src/link.c:2289），
	 * 平移会让它读到别的槽，握手直接数不出玩家。 */
	if (haveRemote && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA
	    && GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u) {
		data[me == 0 ? 1 : 0] = sioPeerShifted(sio, (uint16_t) remote);
	}
	/* 【按帧索引投递】用对端随行的 idxW 决定这一格该放哪个字（见 sioIdxDeliver）。
	 * 放在平移线之后，优先级最高：它同时替代「按到达顺序落格」和「平移一拍」。 */
	if (haveRemote && sioIdxDeliverOn() && sio->core
	    && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gi = (struct GBA*) sio->core->board;
		if (GBAView8(gi->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u) {
			unsigned rcNat = GBAView8(gi->cpu, SIO_IW(0x03002AF4u) + 0x17u);
			data[me == 0 ? 1 : 0] = sioIdxDeliver(sio, remote, rcNat);
		}
	}
	/* 【11-16 18:45 传输层校验和改写】gen8 的 DoRecv 在 sendCmdIndex==0 那一
	 * 轮**只做校验和对比、不把字存进接收队列**（link.c:2313-2323）：
	 *     if (gLink.sendCmdIndex == 0) { for i: if (checksum != recv[i]) badChecksum = TRUE; ... }
	 * 而我们的 SerialCB 顺序是 DoRecv→DoSend，所以这一轮收到的四个槽位
	 * **全部是本轮的校验和字**（对方上一轮 sc==8 写出的 gLink.checksum），
	 * 这些字随后被丢弃，不参与任何游戏逻辑。
	 * 于是这里可以安全地把对端槽改写成「本端此刻的 gLink.checksum」：
	 * 对比必然成立 ⇒ badChecksum 这一类掉链（历史 st=0x2868/0x2949）从
	 * 根上消失。这根线本来就是**电缆**的完整性检查，我们既然替掉了电缆，
	 * 由中继侧重算校验和才是正确语义（真实的坏数据另有帧级校验）。
	 * 关掉用 MGBAX_CS_FORGE=0。 */
	/* 【硬相位锁优先】CMD_HARD 打开时由共享轮次号直接解析 sc/rc，
	 * 闸门与锚点校正都必须让位（它们改的是同一对索引，会互相打架）。 */
	sioHardCmdPhase(sio);
	if (!sioHardCmdPhaseOn()) {
		sioPhaseGate(sio);
		if (haveRemote) {
			sioAlignCmdPhase(sio, (uint16_t) remote);
		}
	}
	sioRoundsPerFrame(sio);
	sioCmdTrace(sio);
	sioLinkStat(sio);
	obsChainTick(sio);   /* X10-OBSCHAIN：新增只读观测；门关立即返回 */
	if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		/* 【ROOTHUNT】去掉 haveRemote 门：sc==0 的校验和对比**包含自槽**，
		 * 本轮没有对端字时也必须把自槽改写成 gLink.checksum，否则主机
		 * state>=4 抑制握手字后自槽与 checksum 不等 ⇒ 假 badChecksum。 */
		static int forge = -1;
		if (forge < 0) {
			const char* v = getenv("MGBAX_CS_FORGE");
			forge = (v && atoi(v) == 0) ? 0 : 1;
		}
		if (forge) {
			struct GBA* g = (struct GBA*) sio->core->board;
			/* 【必须限定 state>=4】握手期 SerialCB 走 DoHandshake，根本不碰
			 * sendCmdIndex，它从头到尾都是 0 —— 只看 sc==0 会把**每一轮**
			 * 握手字的对端槽都改写成 gLink.checksum(=0)，DoHandshake 读到
			 * 0x0000 直接把 playerCount 清零（TR3 现场：两端 d 的对端槽恒
			 * 0000、pc 恒 0、永远握不上手）。只有 CONN_ESTABLISHED(4) 之后
			 * 才有真正的"每轮 sc=0..8 循环+校验和对比轮"。 */
			if (GBAView8(g->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u
			    && GBAView8(g->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF) == 0u) {
				/* 【自己的槽也要伪造 2026-11-17 00:0x】DoRecv 的校验和轮是
				 * `for (i = 0; i < playerCount; i++)`——**包含自己那一格**：
				 *     if (gLink.checksum != recv[i] && sChecksumAvailable) badChecksum = TRUE;
				 * 之前只改写对端槽，自己槽仍是本拍 latched 的 SIOMLT_SEND；
				 * 一旦相位被我们调整过（ESTGATE/SYNCIDX 改了 sc/rc/sic），
				 * 8 拍累加的次数就差一次，自己槽与 gLink.checksum 不等 ⇒
				 * badChecksum ⇒ gLinkStatus|=0x2000 ⇒ CheckErrorStatus 拆链。
				 * TR40 现场：CloseLink 的 lr=0816C7FB（link.c 内部，不是脚本），
				 * st=0x2968 正好带 0x2000。这一拍 DoRecv 本来就不存字（走的是
				 * 校验和分支），所以把两格都写成 gLink.checksum 不影响任何槽位内容。 */
				uint16_t ck = GBAView16(g->cpu, SIO_IW(SIO_GLINK_CHECKSUM));
				data[me == 0 ? 1 : 0] = ck;
				data[me] = ck;
			}
		}
	}
	/* 【2026-11-18 H4 SIO-CMD-SIM 写序定案】帧首 0x2222/0xBBBB 的一次性相位对齐
	 * 必须是 sc/recvCmdIndex(+0x16/+0x17) 的**最后写入者**，紧邻
	 * finishMultiTransfer(→ GBASIOMultiplayerFinishTransfer → GBA_IRQ_SIO →
	 * SerialCB → DoRecv) 之前。若放在 sioHardCmdPhase / sioPhaseGate /
	 * sioAlignCmdPhase / CS_FORGE 之前，这些写入者（或被 enable 后）会在
	 * 同一轮把 (1,0) 覆盖掉，日志虽打印 CMDFRAMEALIGN 但 DoRecv 看到的仍是
	 * 旧相位 ⇒ 0x2222 落进 recvQueue[0][1] ⇒ gRecvCmds[0][0] 恒陈旧。
	 * 用原始 remote 判据（CS_FORGE 只改 data[] 不改 remote，检测不受影响）。 */
	/* 【档1 A 方案 i 写径门】帧首 opcode(2222/2233/BBBB/8888) 触发
	 * sioAlignCmdFrameHeader 写 sc/rc（游戏态）；投机字一律不进此写径。 */
	if (haveRemote && !sio->sioRemoteIsPredicted) {
		sioAlignCmdFrameHeader(sio, remote);
	}
	finishMultiTransfer(sio, data, cyclesLate);
}

/* 3/4 人总线：四个槽位来自主机的汇聚广播，没连上的槽位是 0xFFFF。
 * 槽位装配规则在 link_net 的 netLinkBusSlots（纯函数，已有单测）。 */
static void completeMultiTransferBus(struct SioLink* sio, const uint32_t vals[4], int players, uint32_t cyclesLate) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	int me = netLinkPlayer(sio->link);
	uint16_t data[4];
	/* 3/4 人总线：四槽来自主机唯一一次聚合广播（vals[4]），所有核（含主机）
	 * 都写入同一份快照，不再用本核当前 SIOMLT_SEND 覆盖自身槽位——那样会让
	 * 三核的 SIOMULTI 互不相同，握手永远对不齐（busgame 实测 f=1191 起分叉）。
	 * vals 里未连上的槽位已是 0xFFFF（主机缺席槽 + 掉线从机）。 */
	for (int i = 0; i < 4; ++i) {
		data[i] = (i < players && vals) ? (uint16_t) vals[i] : 0xFFFF;
	}
	/* 逐轮取证（前 80 轮 + 每 500 轮一条）：三核同一轮写入的四个槽应该
	 * 完全一致（现在 data 就是 vals 的逐字拷贝，用来确认三核收到同一份）。 */
	static uint32_t s_busLogN;
	uint32_t n = ++s_busLogN;
	if (n <= 80 || (n % 500) == 0) {
		fprintf(stderr, "BUSBUS n=%u me=%d players=%d idx=%u vals=%04X,%04X,%04X,%04X -> %04X,%04X,%04X,%04X\n",
		        (unsigned) n, me, players, (unsigned) sio->sioIndex,
		        (unsigned) vals[0], (unsigned) vals[1], (unsigned) vals[2], (unsigned) vals[3],
		        data[0], data[1], data[2], data[3]);
	}
	/* 握手取证：MASTER_HANDSHAKE=0x8FFF / SLAVE_HANDSHAKE=0xB9A0（gen8/link.h）。
	 * DoHandshake 要求四槽 = 8FFF,SLAVE,SLAVE,FFFF 且连续两轮稳定才 LINKUP。
	 * 只要本核这一轮出现了握手字（8FFF 或 B9A0），就把「投递给游戏的 data」
	 * 打出来，看是投递 bug 还是从机 2 还没跟上。BUSGAME_HSL=1 时开。 */
	static uint32_t s_hslN;
	if (getenv("BUSGAME_HSL")
	    && ((data[0] == LINK_HANDSHAKE_MASTER) || (data[1] == LINK_HANDSHAKE_SLAVE) || (data[2] == LINK_HANDSHAKE_SLAVE)
	        || (vals[0] == LINK_HANDSHAKE_MASTER) || (vals[1] == LINK_HANDSHAKE_SLAVE) || (vals[2] == LINK_HANDSHAKE_SLAVE))) {
		if (++s_hslN <= 120) {
			fprintf(stderr, "HSL n=%u me=%d players=%d data=%04X,%04X,%04X,%04X vals=%04X,%04X,%04X,%04X\n",
			        (unsigned) s_hslN, me, players,
			        data[0], data[1], data[2], data[3],
			        (unsigned) vals[0], (unsigned) vals[1], (unsigned) vals[2], (unsigned) vals[3]);
		}
	}
	obsChainTick(sio);   /* X10-OBSCHAIN：3人 LocalBus 路径补 hook（本轮 E2E 走此路径，原仅2人路径有） */
	finishMultiTransfer(sio, data, cyclesLate);
}

/* 【2026-11-16 19:xx 定案】抹掉 gen8 的「时钟滞后」标志 gLink.lag(+0x13)。
 *
 * 现场证据（memory.c 里挂 gLinkOpen 写检查点 + 打印当时 gLinkStatus）：
 * 两端都只有一次拆链动作，都来自 **CheckErrorStatus()**，而那一刻的状态是
 *   A(st=00010968) → LINK_STAT_ERROR_LAG_MASTER 0x00010000
 *   B(st=00040149) → LINK_STAT_ERROR_LAG_SLAVE  0x00040000
 * 不是 badChecksum(0x2000)。而 gen8 的 EXTRACT_LINK_ERRORS = 0x0007F000
 * **包含** 0x10000/0x40000，所以一次「这一帧没跑满 9 次传送」就会被判致命，
 * 直接 CloseLink → 用户看到「通信错误/黑屏」。
 *
 * 语义判断：lag 的含义是「电缆另一端没按时钟推动这次传送」。我们既然用
 * 中继替掉了电缆，逐轮有序送达由传输层保证，**这个位在本实现里没有语义**；
 * 而公网抖动下偶发缺一帧是必然的 —— 留着它，云端 2P 永远不可能稳。
 * 抹掉之后 LinkVSync 的 `else if (lag != LAG_MASTER)` 分支还能正常重新起轮，
 * 所以这个清位同时也是自愈路径。
 *
 * 只在「对端确实还在推字」（peerAge < 1000ms）时清：对端真的掉了，仍然让
 * 游戏自己报错退出，不掩盖真实断链。 */
static void sioClearClockLag(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_NO_LAG_CLEAR");
		enabled = (v && atoi(v) == 1) ? 0 : 1;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		gbaLinkDropClockLag = false;
		return;
	}
	/* 判据只取「TCP 会话还连着」。不要再叠加 peerAge：实测空闲期（还在
	 * 「请稍候/Awaiting linkup」画面）对端年龄能到 10s，而 lag 恰好就发生在
	 * 那之后的第一个爆发帧 —— 加了 age 闸就一个都拦不住（LAGSTORE blk=0）。 */
	bool alive = netLinkState(sio->link) == 2;
	{
		static int dbgN;
		if (++dbgN <= 4 || (dbgN % 20000) == 0) {
			fprintf(stderr, "LAGDBG n=%d state=%d age=%u alive=%d lagbyte=%d\n",
			        dbgN, netLinkState(sio->link), (unsigned) netLinkPeerAge(sio->link),
			        (int) alive,
			        (int) GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(0x03002AF4u) + 0x13u));
		}
	}
	/* 真正的拦截在 GBAStore8/16/32（memory.c）：LinkVSync 在 VBlank 里写、
	 * 同一帧 CheckErrorStatus 立刻读，中间没有可插入的点位。这里只负责
	 * 维护「要不要拦」；顺带把已经落盘的历史值清掉。 */
	gbaLinkDropClockLag = alive;
	if (!alive) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x13u)) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x13u, 0, NULL);
		++sio->sioLagCleared;
	}
}

static void serviceLink(struct SioLink* sio) {
	if (!sio->linkAttached || !sio->link) {
		return;
	}
	sioClearClockLag(sio);
	/* Re-align the terminal bits every round: the link state may have changed
	 * after the game last read (or wrote) SIOCNT, and the game re-checks it
	 * every frame in HANDSHAKE. */
	applyLinkTerminalBits(sio);
	/* Let the IO thread always see the byte we would send now, so a peer
	 * request can be answered without waiting for the emulated thread. */
	uint16_t localMode = 0;
	uint32_t local = readLinkOut(sio, &localMode);
	netLinkPublish(sio->link, localMode, local);
	netLinkPingTick(sio->link);
	if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		/* NETGATE 拼行钩子：逐帧只读 64B diag（门关 helper 立即返回，零副作用）。 */
		{
			size_t ngRomSize = 0;
			struct GBA* ngGba = (struct GBA*) sio->core->board;
			const uint8_t* ngRom = sioLoadedRomBytes(sio, &ngRomSize);
			sioNetGatePeek(ngGba, ngRom, ngRomSize);
#if MGBAX_ROLLBACK_ENABLE
			/* 档1 A 稳态采样 + diag 保真回调幂等注册（对偶 mobile）。 */
			if (sioPredRollbackReady(sio) && ngGba && ngGba->cpu) {
				uint8_t rbDiag[GNP_NG_DIAG_SIZE];
				unsigned rbi;
				uint32_t rbAddr = (uint32_t) GNP_DIAG_EW;
				if (gnpAbsEwOk(rbAddr, GNP_NG_DIAG_SIZE)) {
					for (rbi = 0u; rbi < GNP_NG_DIAG_SIZE; ++rbi) {
						rbDiag[rbi] = (uint8_t) GBAView8(ngGba->cpu, rbAddr + rbi);
					}
					sioNgLatchSample(sio, rbDiag);
				}
				gnpRewindSetDiagPreserve(sioDiagPreserveCb, sio);
				gnpRewindSetDiagVerify(sioDiagVerifyCb, sio);
			} else {
				gnpRewindSetDiagPreserve(NULL, NULL);
				gnpRewindSetDiagVerify(NULL, NULL);
			}
#endif
		}
		int player = netLinkPlayer(sio->link);
		/* The slave never starts a transfer itself: the 1P clock drives the
		 * round, the slave finishes when the host's word arrives. The finish
		 * itself moved to sioSlaveDoneEvent, which pins the slave's clock to
		 * the host's cadence; here we only arm it - and only once the host
		 * actually pushed a word, otherwise the event would spin waiting for
		 * a word that never comes (before the game even reaches the room). */
		/* 3/4 人总线的字走 PKT_PUSH / PKT_BUS_ROUND，不进 peerQ：
		 * netLinkPeerPending() 在总线模式恒为 0，沿用两人判据会让从机
		 * 轮次事件永远 arm 不上（主机每轮等满超时窗，从机收不到 SIO
		 * 中断卡在进房前）。总线改看「游戏自己写过 SIOCNT 起 MULTI」，
		 * 既不自旋，也不依赖主机先广播，避免第一轮互等。 */
		bool busMode = netLinkBusActive(sio->link);
		bool roundReady = busMode ? sio->sioRoundWordValid
		                          : netLinkPeerPending(sio->link) > 0;
		if (player != 0 && !sio->sioSlaveArmed && roundReady) {
			struct mTiming* timing = coreTiming(sio);
			if (timing) {
				if (mTimingIsScheduled(timing, &sio->sioSlaveDone)) {
					SIO_LOG("slave DOUBLE-SCHEDULE caught (armed=%d)", sio->sioSlaveArmed);
				}
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
		}
	}
	/* Drain the host's transfer requests first (a queued request must finish
	 * before the watchdog could clear Busy). */
	int guard = 0;
	uint16_t seq;
	uint16_t mode;
	uint32_t value;
	int player;
	while (guard++ < 8 && netLinkTakeRequest(sio->link, &seq, &mode, &value, &player)) {
		if (sio->sioWaiting) {
			/* Waiting for our own transfer's reply: both sides would be master
			 * (never happens - only 1P starts MULTI). Drop to avoid finishing
			 * the same transfer twice. */
			continue;
		}
		if (mode == GBA_SIO_MULTI) {
			/* MULTI no longer travels as a request: both sides push per round
			 * and finish on their own cadence. */
			continue;
		}
		finishIncoming(sio, mode, value, player);
	}
}

/* 【主机九拍链看门狗 2026-11-17 00:2x】
 *
 * 现场（TR41/42）：两端都到了 CONN_ESTABLISHED、pc=2，但主机侧
 * `intr(gLink.serialIntrCounter)=8` **一直不动**、`BEGIN` 总数只有 12 ——
 * 进入 state4 之后主机**一拍都没发起过**，于是整条链没有轮次、没有我们的
 * 钩子、也就没有人能把 sic 推到 9，彻底死锁：
 *   主机的下一轮靠 LinkVSync 的 `if (sic >= 9) { sic = 0; StartTransfer(); }`
 *   （gen8/src/link.c:2180），而 sic 只在每一拍的 SerialCB 里 ++。
 *   `gLink.serialIntrCounter = 8` 正是 HANDSHAKE→INIT_TIMER 时游戏写入的初值，
 *   所以"停在 8"就是"一拍都没走"的直接体征。
 *
 * 这个看门狗挂在 `linkPollEvent`（每 8192 周期 ≈4.9ms 一次的定时事件）上，
 * 与九拍链完全解耦：只要 state>=4、本端是主机、且**共享轮次号在 ~100ms 内
 * 一次都没变**，就把 sic 直接写成 9，下一 VBlank 必然重起一轮。
 * 这是把游戏自己的重起通路重新点亮，不改任何协议语义。
 * 开关 MGBAX_CHAIN_WD=1。 */
static void sioChainWatchdog(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_CHAIN_WD");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(0x03002AF5u)) < 4u) {
		sio->sioChainLabel = sio->sioRoundLabel;
		sio->sioChainStall = 0;
		return;
	}
	if (!(GBAView32(gba->cpu, SIO_IW(0x03002A9Cu)) & 0x20u)) {
		return;   /* 只救主机：从机由自己的 sioSlaveDone 驱动，不需要起轮 */
	}
	if (sio->sioRoundLabel != sio->sioChainLabel) {
		sio->sioChainLabel = sio->sioRoundLabel;
		sio->sioChainStall = 0;
		return;
	}
	if (++sio->sioChainStall < 20u) {
		return;   /* 20 × 8192 周期 ≈ 98ms 没动静才算停摆 */
	}
	sio->sioChainStall = 0;
	GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Du, 9, NULL);
	GBAPatch8(gba->cpu, SIO_IW(0x03002AF4u) + 0x13u, 0, NULL);   /* lag = LAG_NONE */
	++sio->sioChainKick;
	if (sio->sioChainKick <= 20u || (sio->sioChainKick % 100u) == 0u) {
		SIO_LOG("CHAINWD n=%u t=%u lb=%u intr->9", (unsigned) sio->sioChainKick,
		        (unsigned) wallNowMs(), (unsigned) sio->sioRoundLabel);
	}
}

/* 【块请求受控重发 2026-11-17 23:3x】
 *
 * 现象：两端 rem=1、l=4、pc=2、brs 位一致，但**只有一端**进待机房间
 *（A `px=5 py=8 cb=0816C77D`、B `px=10 py=4 cb=00000000`，场地冻结、按 A 无效）。
 *
 * 根因（gen8/src/link.c:1069）：
 *     bool8 SendBlockRequest(u8 type) {
 *         if (gLinkCallback == NULL) { ... BuildSendCmd(LINKCMD_SEND_BLOCK_REQ); return TRUE; }
 *         return FALSE;          // ← 回调非空就直接放弃
 *     }
 * 而 `Task_LinkupCheckStatusAfterConfirm`（cable_club.c:429）调完它**不管返回值**
 * 就把 func 换成 `Task_LinkupAwaitTrainerCardData`，从此不再重试。
 * 所以只要那一刻本端 gLinkCallback 非空（正在发自己的块），这一侧就永远
 * 不会发出 0xCCCC ⇒ 对端永远等不到自己的块 2 ⇒ 停在「按 A 确认」。
 * 这和 0x2222 是同一类「一次性命令丢帧、且无法自愈」。
 *
 * 补法：在定时钩子里补发，门槛卡到最紧——
 *   rem==1（块 1 已双向完成）、gLinkCallback==0（游戏此刻不会再自己发）、
 *   每 120 个 tick（约 2 秒）一次、总共最多 6 次。
 * 只在 `MGBAX_BLKREQ=1` 时启用，默认关闭（零回归）。
 * gSendCmd 在 0x03002AB0（LinkMain1 每帧把它入队，LinkMain2 开头清零），
 * 0xCCCC=LINKCMD_SEND_BLOCK_REQ、第二字=gBlockRequestType=2（训练家卡）。 */
static void sioBlkReqRetry(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_BLKREQ");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->link || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) != 1u) {
		sio->sioBlkReqTick = 0;
		return;
	}
	if (GBAView32(gba->cpu, SIO_IW(0x03002AD4u)) != 0u) {
		return;   /* 游戏自己正在跑回调，别抢它 */
	}
	if (sio->sioBlkReqSent >= 6u) {
		return;
	}
	if (++sio->sioBlkReqTick < 120u) {
		return;
	}
	sio->sioBlkReqTick = 0;
	GBAPatch16(gba->cpu, SIO_IW(0x03002AB0u), (int16_t) 0xCCCC, NULL);
	GBAPatch16(gba->cpu, SIO_IW(0x03002AB2u), 2, NULL);
	++sio->sioBlkReqSent;
	SIO_LOG("BLKREQ n=%u t=%u 补发 0xCCCC,2 rem=1 cb=0",
	        (unsigned) sio->sioBlkReqSent, (unsigned) wallNowMs());
}

/* 【一次性回调重发 2026-11-18 00:2x】
 *
 * 黑屏卡死的最后一环：`Task_StartWiredCableClubBattle` case 0 fade 到黑、
 * case 3 调 `SetCloseLinkCallback()`（gen8 里装 `LinkCB_ReadyCloseLink`）、
 * case 4 等 `!gReceivedRemoteLinkPlayers` —— 而 rem 归零要求**两端都关链**。
 * 但 `LinkCB_ReadyCloseLink` 只 `BuildSendCmd(LINKCMD_READY_CLOSE_LINK=0x5FFF)`
 * 一次就把自己换成 `LinkCB_WaitCloseLink`：**又是"一次性命令"，丢了就永久等**。
 * FR13 的 CMDFRM 里 `0x5FFF` 出现 **0 次**，正是它丢了（或从未上线）。
 *
 * 补法（与 MGBAX_BLKREQ 同一套模式，已验证有效）：
 *   记住本端最近一次见过的非零 `gLinkCallback`（自校准，不硬编码地址——
 *   每个 ROM 构建的 `LinkCB_*` 地址都不同，而且 `nm rom.elf` 那份符号表
 *   与运行中的 ROM 不是同一构建，不能用）；
 *   当 rem==1 且 `gLinkCallback==0`（游戏已经把自己清掉、又还没往下走）时，
 *   每 120 个 tick（约 2 秒）把那个值写回去，让它重跑一次、重发一次命令，
 *   最多 6 次。
 * 开关 MGBAX_REARM=1（默认关）。 */
static void sioCallbackRearm(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_REARM");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!enabled || !sio->link || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb = GBAView32(gba->cpu, SIO_IW(0x03002AD4u));
	if (cb != 0u) {
		sio->sioLastCb = cb;     /* 自校准：记住当前在跑的回调 */
		sio->sioRearmTick = 0;
		return;
	}
	if (sio->sioLastCb == 0u || sio->sioRearmSent >= 6u) {
		return;
	}
	if (GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) != 1u) {
		sio->sioRearmTick = 0;
		return;                  /* 只在 linkup 完成之后才补 */
	}
	if (++sio->sioRearmTick < 120u) {
		return;
	}
	sio->sioRearmTick = 0;
	GBAPatch32(gba->cpu, SIO_IW(0x03002AD4u), sio->sioLastCb, NULL);
	++sio->sioRearmSent;
	SIO_LOG("REARM n=%u t=%u cb<-%08X rem=1", (unsigned) sio->sioRearmSent,
	        (unsigned) wallNowMs(), (unsigned) sio->sioLastCb);
}

/* 【ROOTHUNT 链路启动取证】从机是否真的在走轮次、主机有没有起轮，全部在这
 * 一行里摊开。只在头 40 次 + 每 512 次打一条，避免刷屏。
 *   link = netLinkState(2=CONNECTED) / player = 链路槽位(0=主,1=从)
 *   ok   = sioOk(成功轮数) / wait = sioWaiting / armed = sioSlaveArmed
 *   drv  = GBA.sio.driver 是否挂上 / gst/gim/sic = 游戏的 state/isMaster/sic
 *   pq   = 对端字队列深度 / cb = gLinkCallback
 * 现场用途：APPNAVDEFINITIVE 两端 sic=0 且从无 BEGIN —— 这一行能直接证明
 * 是「驱动没挂 / 链没连 / 从机事件没 arm / 游戏没进 state4」中的哪一个。 */
/* 【ROOTHUNT 日志门】诊断取证默认关闭：生产运行 refuses ~15k 行/分钟导致
 * 帧率从 60 掉到 5~10。只有显式 MGBAX_RH_VERBOSE=1 才打 [RH*] 标记；
 * 纯日志开关，不改变任何链路/状态机行为。 */
static bool rhVerbose(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_RH_VERBOSE");
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}

/* ROOTHUNT2 零注入对照总闸：MGBAX_RH_OFF=1 关闭所有 ROOTHUNT2 数据/重绘/单端强推
 * 补丁（gEnemyParty 注入、sidecar TX/RX、reshow、RHUNBLOCK、RHBRS）。RHID 身份复制
 * 仅移动端有（PC 侧 sioDumpPlayers 为纯诊断、无写操作），由移动端 rhMOff 对称关闭。
 * 保留握手补丁(seat-assist/close-grace/rearm)。用于 A/B 判断"补丁帮倒忙 vs 链路坏"。 */
static bool rhPatchesOff(void) {
	static int v = -1;
	if (v < 0) {
		const char* e = getenv("MGBAX_RH_OFF");
		v = (e && atoi(e) == 1) ? 1 : 0;
	}
	return v != 0;
}

static void sioStartupTrace(struct SioLink* sio) {
	static uint32_t n;
	static int prevSig = -1;
	if (!rhVerbose()) {
		return;
	}
	uint32_t seq = ++n;
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int link = sio->link ? netLinkState(sio->link) : -1;
	int player = sio->link ? netLinkPlayer(sio->link) : -1;
	unsigned gst = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	unsigned gim = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u);
	unsigned sic = GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x0Du);
	unsigned cb = (unsigned) GBAView32(gba->cpu, SIO_IW(0x03002AD4u));
	int drv = gba->sio.driver ? 1 : 0;
	int pq = sio->link ? netLinkPeerPending(sio->link) : -1;
	int sig = (link << 20) | ((player & 3) << 18) | ((int) gst << 12)
	          | (drv << 11) | (sio->sioWaiting ? 1024 : 0)
	          | (sio->sioSlaveArmed ? 512 : 0) | ((gim == 8u) ? 256 : 0)
	          | (int) (sic & 0xFFu);
	if (seq <= 40 || (seq % 512) == 0 || sig != prevSig) {
		SIO_LOG("[RHSTART] n=%u link=%d pl=%d ok=%u wait=%d arm=%d drv=%d gst=%u gim=%u sic=%u pq=%d cb=%08X sig=%d",
		        seq, link, player, (unsigned) sio->sioOk, sio->sioWaiting ? 1 : 0,
		        sio->sioSlaveArmed ? 1 : 0, drv, gst, gim, sic, pq, cb, sig);
		prevSig = sig;
	}
}

/* 【ROOTHUNT 迭代 12 — 座位就绪补位，默认关 MGBAX_SEAT_ASSIST=1】
 * gen8 的战斗启动链（cable_club.c:1045 Task_EnterCableClubSeat →
 * overworld.c:2731 sub_8087214）要求：
 *   sPlayerTradingStates[所有玩家] == 0x82 (PLAYER_TRADING_STATE_UNK_2)
 * 才会从「请稍候」切到 Task_StartWiredCableClubBattle → CB2_InitBattle。
 * A9 现场：rem=1 / fieldLinkPlayerCount=2 / cb2=CB2_Overworld，但
 * sPlayerTradingStates=00/00、sPlayerKeyInterceptCallback=0（仍 SelfIdle）
 * ⇒ 座位触发/就绪按键从未进入游戏，走位按 A 也推不动。
 * 这里在「块交换已全部完成但没有玩家就绪」的稳定状态下，代游戏把
 * 就绪状态与回调补上。纯 opt-in，默认零行为变化。 */
#define RH_TRADESTATES_CANON 0x03004A10u   /* sPlayerTradingStates[4] @0x03004AE4 */
#define RH_KEYINTERCEPT_CANON 0x03004A14u  /* sPlayerKeyInterceptCallback @0x03004AE8 */
#define RH_READY_CALLBACK    0x0818A925u   /* sub_80871AC (ready key) */
/* 【ROOTHUNT 迭代 18】代游戏调用 ColosseumPlayerSpotTriggered(0x0810726B)：
 * 直接在空闲 gTasks 槽里建 Task_EnterCableClubSeat(0x08107053)，
 * followup = Task_StartWiredCableClubBattle(0x08106CBD)，并置 VAR_0x8005=1。
 * 等价于 gen8 map coord-event 的座位触发，纯 opt-in。 */
#define RH_GTASKS     0x02033D0Cu
#define RH_VAR8005    0x0202199Eu
#define RH_SEAT_TASK  0x08107053u
#define RH_BATTLE_TASK 0x08106CBDu
static void rhCreateSeatTask(struct GBA* gba) {
	uint32_t base = SIO_EW(RH_GTASKS);
	int slot = -1;
	for (int i = 0; i < 16; ++i) {
		if (!GBAView8(gba->cpu, base + (uint32_t) i * 0x28u + 4u)) { slot = i; break; }
	}
	if (slot < 0) { return; }
	GBAPatch16(gba->cpu, SIO_EW(RH_VAR8005), 1, NULL);   /* VAR_0x8005 = seat 1 */
	sioEnsureLinkBtcfg(gba);   /* ROOTHUNT2 方案Y：紧邻 VAR_8005 写 var8004=1 */
	for (int j = 0; j < 16; ++j) {
		GBAPatch16(gba->cpu, base + (uint32_t) slot * 0x28u + 8u + (uint32_t) j * 2u, 0, NULL);
	}
	uint32_t t = base + (uint32_t) slot * 0x28u;
	GBAPatch32(gba->cpu, t, (int32_t) RH_SEAT_TASK, NULL);
	GBAPatch16(gba->cpu, t + 8u + 28u, (int16_t) (RH_BATTLE_TASK & 0xFFFFu), NULL);
	GBAPatch16(gba->cpu, t + 8u + 30u, (int16_t) (RH_BATTLE_TASK >> 16), NULL);
	GBAPatch8(gba->cpu, t + 7u, 80, NULL);   /* priority */
	int first = -1;
	for (int i = 0; i < 16; ++i) {
		if (i != slot && GBAView8(gba->cpu, base + (uint32_t) i * 0x28u + 4u)
		    && GBAView8(gba->cpu, base + (uint32_t) i * 0x28u + 5u) == 0xFEu) { first = i; break; }
	}
	if (first < 0) {
		GBAPatch8(gba->cpu, t + 5u, 0xFE, NULL);
		GBAPatch8(gba->cpu, t + 6u, 0xFF, NULL);
	} else {
		int last = first;
		for (int guard = 0; guard < 16; ++guard) {
			uint8_t nx = GBAView8(gba->cpu, base + (uint32_t) last * 0x28u + 6u);
			if (nx == 0xFFu) { break; }
			last = nx;
		}
		GBAPatch8(gba->cpu, base + (uint32_t) last * 0x28u + 6u, (int) (uint8_t) slot, NULL);
		GBAPatch8(gba->cpu, t + 5u, (int) (uint8_t) last, NULL);
		GBAPatch8(gba->cpu, t + 6u, 0xFF, NULL);
	}
	GBAPatch8(gba->cpu, t + 4u, 1, NULL);   /* isActive last */
	SIO_LOG("[RHSEATT] created seat task slot=%d func=%08X followup=%08X",
	        slot, (unsigned) RH_SEAT_TASK, (unsigned) RH_BATTLE_TASK);
}

static void sioSeatAssist(struct SioLink* sio) {
	static int enabled = -1;
	static unsigned tick;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_SEAT_ASSIST");
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (sioGrayAllOn()) {
		enabled = 1;   /* 灰区全开：蕴含 seat-assist 手建 task（不触碰 RL4 FORCE_EXCHANGE 门） */
	}
	static unsigned dbgN;
	if (rhVerbose() && (++dbgN <= 5 || (dbgN % 256) == 0)) {
		struct GBA* gd = sio && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA
		                 ? (struct GBA*) sio->core->board : NULL;
		unsigned vst = gd ? GBAView8(gd->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) : 999;
		unsigned vpc = gd ? GBAView8(gd->cpu, SIO_IW(0x03002AF4u) + 0x03u) : 999;
		unsigned vrem = gd ? GBAView8(gd->cpu, SIO_IW(0x03002AC1u)) : 999;
		unsigned vfpc = gd ? GBAView8(gd->cpu, SIO_IW(0x03004A39u)) : 999;
		unsigned vt0 = gd ? GBAView8(gd->cpu, SIO_IW(RH_TRADESTATES_CANON)) : 999;
		unsigned vt1 = gd ? GBAView8(gd->cpu, SIO_IW(RH_TRADESTATES_CANON) + 1u) : 999;
		uint32_t vic = gd ? (uint32_t) GBAView32(gd->cpu, SIO_IW(RH_KEYINTERCEPT_CANON)) : 999;
		/* skip: 1=not state4 2=pc<2 3=already ready 4=cb installed 5=stable window */
		unsigned skip = vst != 4u ? 1u : vpc < 2u ? 2u
		              : (vt0 == 0x82u && vt1 == 0x82u) ? 3u
		              : vic == RH_READY_CALLBACK ? 4u : 5u;
		SIO_LOG("[RHSEATG] en=%d st=%u pc=%u rem=%u cnt=%u rnr=%u/%u t0=%u t1=%u ic=%08X tick=%u skip=%u",
		        enabled, vst, vpc, vrem, vfpc,
		        gd ? (unsigned) GBAView8(gd->cpu, SIO_IW(0x03002A3Cu)) : 999,
		        gd ? (unsigned) GBAView8(gd->cpu, SIO_IW(0x03002A3Cu) + 1u) : 999,
		        vt0, vt1, vic, tick, skip);
	}
	if (!enabled || !sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	/* 【ROOTHUNT 迭代 16】去掉 cnt(fieldLinkPlayerCount)>=2 门：
	 * RH-SEAT2 实测 B `st=4 pc=2 rem=0 cnt=0 rnr=1/0` —— cnt 正是因块头
	 * 丢失而没被游戏置起，形成 chicken-and-egg：assist 等 cnt>=2，
	 * cnt>=2 又要 assist 修好的块交换。gen8 的 sub_8087214() 根本不看
	 * cnt/rem，只看 trading states + intercept callback。这里只保留
	 * state==4 && pc>=2（游戏确实处于联机且已数出玩家），再靠 120 轮
	 * 稳定窗避免提前误触发。 */
	/* 【ROOTHUNT 迭代 21】座位任务必须在 t0/t1 早退分支之前创建一次。
	 * APPHUNT 发现一旦 assist 自己把 states 写成 0x82，后续调用全在下面
	 * 的 `t0==0x82&&t1==0x82` 分支早退，rhCreateSeatTask 永远执行不到。 */
	static bool seatTaskDone;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) != 4u
	    || GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u) < 2u) {
		tick = 0;
		seatTaskDone = false;
		return;
	}
	if (!seatTaskDone) {
		seatTaskDone = true;
		rhCreateSeatTask(gba);
	}
	uint8_t t0 = GBAView8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON));
	uint8_t t1 = GBAView8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 1u);
	uint32_t ic = (uint32_t) GBAView32(gba->cpu, SIO_IW(RH_KEYINTERCEPT_CANON));
	/* 【ROOTHUNT 迭代 17】A19: ts=82/82/80/80 ic=0818A8E5(sub_8087170)。
	 * gen8 的 AreAllPlayersInTradingState 只看 gFieldLinkPlayerCount(=2)，
	 * 但 0x80 的两个占位槽无害；这里一次把 4 槽全置 0x82 更稳妥。
	 * 另外当 states 已是 0x82、ic 却是 sub_8087170 时，说明 ready key 已
	 * 发出但战斗任务没起来 —— 周期性重装 sub_80871AC 重发 ready key
	 * （限 6 次，类似 MGBAX_BLKREQ 的补发模式）。 */
	static unsigned rearmKick;
	if (t0 == 0x82u && t1 == 0x82u) {
		if (ic == RH_READY_CALLBACK || rearmKick >= 6u) {
			return;
		}
		if (++tick < 300u) {   /* ~5s 再补发一次 */
			return;
		}
		tick = 0;
		++rearmKick;
		GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 2u, 0x82, NULL);
		GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 3u, 0x82, NULL);
		GBAPatch32(gba->cpu, SIO_IW(RH_KEYINTERCEPT_CANON), (int32_t) RH_READY_CALLBACK, NULL);
		SIO_LOG("[RHSEATK] kick=%u states=82/82/82/82 ic=%08X -> ready cb", (unsigned) rearmKick, (unsigned) ic);
		return;
	}
	if (++tick < 120u) {
		return;
	}
	tick = 0;
	GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON), 0x82, NULL);
	GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 1u, 0x82, NULL);
	GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 2u, 0x82, NULL);
	GBAPatch8(gba->cpu, SIO_IW(RH_TRADESTATES_CANON) + 3u, 0x82, NULL);
	GBAPatch32(gba->cpu, SIO_IW(RH_KEYINTERCEPT_CANON), (int32_t) RH_READY_CALLBACK, NULL);
	/* 【ROOTHUNT 迭代 25】取消无条件强清 rnr/rem：gen8 的
	 * HandleReceiveRemoteLinkPlayer 分支里才做
	 * `*linkPlayer = block->linkPlayer`（gLinkPlayers[] 真正填数据）。
	 * 强清会走 SetBlockReceivedFlag 分支跳过拷贝 ⇒ 对手精灵 ???。
	 * 保留为独立 opt-in MGBAX_FORCE_EXCHANGE=1，默认关。 */
	{
		static int fx = -1;
		if (fx < 0) {
			const char* v = getenv("MGBAX_FORCE_EXCHANGE");
			fx = (v && atoi(v) == 1) ? 1 : 0;
		}
		if (fx && GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) != 1u) {
			GBAPatch8(gba->cpu, SIO_IW(0x03002A3Cu), 0, NULL);
			GBAPatch8(gba->cpu, SIO_IW(0x03002A3Cu) + 1u, 0, NULL);
			GBAPatch8(gba->cpu, SIO_IW(0x03002AC1u), 1, NULL);
		}
	}
	SIO_LOG("[RHSEAT] t0=%u t1=%u ic=%08X -> 82/82 ready cb; rem=%u",
	        (unsigned) t0, (unsigned) t1, (unsigned) ic,
	        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AC1u)));
}

/* 【ROOTHUNT 迭代 19】战斗交接期清 QUEUE_FULL/HARDWARE 错误锁存：
 * A 端进 CB2_InitBattle 后关链，B 端还留在房间里；我们的持续推字让 B 的
 * recvQueue.count 冲到 50 ⇒ gLink.queueFull(+0x12)=1 ⇒ gLinkStatus 0x4000
 * ⇒ CheckErrorStatus → CB2_LinkError(eb=0x4949)。这里在 gLinkType 变成
 * LINKTYPE_BATTLE(SIO_LINKTYPE_BATTLE 值) 且 state>=4 时每轮清掉错误标志与 gLinkStatus
 * 的错误位，让 B 走完交接（opt-in，随 MGBAX_SEAT_ASSIST 一起开）。 */
static void sioHandoffGuard(struct SioLink* sio) {
	static int en = -1;
	if (en < 0) {
		const char* v = getenv("MGBAX_HANDOFF_GUARD");
		en = (v && atoi(v) == 1) ? 1 : 0;   /* 默认关：实测会阻止战斗交接本身 */
	}
	if (!en || !sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN
	    || GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE)) != SIO_LINKTYPE_BATTLE) {
		return;
	}
	/* 只清 queueFull（eb=0x4949 里唯一的 0x7F000 错误位是 0x4000）。
	 * 清 lag/hardwareError 等会阻止游戏自己的交接流程，实测两端都进不了战斗。 */
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_QUEUEFULL_OFF, 0, NULL); /* queueFull */
	uint32_t st = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_STATUS));
	if (st & SIO_LINK_STAT_QUEUE_FULL) {
		GBAPatch32(gba->cpu, SIO_IW(SIO_GLINK_STATUS), (int32_t) (st & ~SIO_LINK_STAT_QUEUE_FULL), NULL);
	}
}

/* 【ROOTHUNT 迭代 20】战斗交接补发 READY_CLOSE_LINK(0x5FFF)：
 * 基线里 B 发出了 0x5FFF（A 的 rc=5FFF）并进战斗，但 A 从未把 0x5FFF
 * 送回给 B —— A 一进 CB2_InitBattle 就停止起 SIO 轮，B 的 peerQ 等不到
 * 关闭字 ⇒ recvQueue 冲到 50 ⇒ queueFull(0x4000) ⇒ CB2_LinkError。
 * 这里在「gLinkType 已是 BATTLE 且本端已退出 state4」后，用 driver 身份
 * 补推有限次 0x5FFF，让对端也能干净关闭。opt-in MGBAX_CLOSE_GRACE=1。 */
static void sioCloseGrace(struct SioLink* sio, struct mTiming* timing) {
	static int en = -1;
	static unsigned left;
	static bool graceDone;
	if (en < 0) {
		const char* v = getenv("MGBAX_CLOSE_GRACE");
		en = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!en || !sio || !sio->link || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint16_t lt = GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE));
	uint8_t ls = GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
	uint32_t cb2 = (uint32_t) GBAView16(gba->cpu, SIO_CB2_PTR)
	             | ((uint32_t) GBAView16(gba->cpu, SIO_EW(0x0202911Au)) << 16);
	bool inBattle = cb2 >= SIO_BATTLE_LO() && cb2 < SIO_BATTLE_HI();
	static unsigned dbgN;
	if (rhVerbose() && (++dbgN % 256) == 0) {
		SIO_LOG("[RHCLOSEG] lt=%04X ls=%u cb2=%08X inBattle=%d done=%d left=%u net=%d",
		        (unsigned) lt, (unsigned) ls, (unsigned) cb2, inBattle ? 1 : 0,
		        graceDone ? 1 : 0, (unsigned) left, netLinkState(sio->link));
	}
	/* 【ROOTHUNT 迭代 23】PROXY6 证明旧门（lt=8721 && state<4）从不命中：
	 * 进入战斗的一端 A 在 cb2=BattleMainCB2 时仍是 state=4，随后才关链；
	 * 卡在 standby 的 B 一直 state=4，永远进不了旧门。正确语义是
	 * **进入战斗的一端**主动推 0x5FFF：cb2 落进 battle_main.o 窗口即触发。 */
	if (lt != SIO_LINKTYPE_BATTLE || !sioInClosePhase(sio)) {   /* 只在关链发起段推 5FFF */
		graceDone = false;   /* 新会话/未进战斗时重新武装 */
		return;
	}
	if (graceDone) {
		return;
	}
	if (graceDone) {
		return;
	}
	/* 【ROOTHUNT 迭代 24】战斗一进入，本端 linkPollEvent 只再跑 1~2 次
	 *（之后 SIO driver 随核心切换停止），所以必须在首次命中时一次成串
	 * 推出 16 个 0x5FFF（标签连续），否则对端只收到 1 个、来不及消费。 */
	graceDone = true;
	left = 0;
	uint32_t stamp = timing ? mTimingCurrentTime(timing) : 0;
	for (unsigned i = 0; i < 16u; ++i) {
		netLinkPush(sio->link, GBA_SIO_MULTI, (uint32_t) LINKCMD_READY_CLOSE_LINK,
		            (uint16_t) (sio->sioIndex + 1u + i), stamp);
	}
	SIO_LOG("[RHCLOSE] grace BURST 16x 5FFF idx=%u lt=%04X cb2=%08X",
	        (unsigned) sio->sioIndex, (unsigned) lt, (unsigned) cb2);
}

/* 【ROOTHUNT 迭代 25】对手数据取证：gLinkPlayers[1] 的 version/trainerId/
 * name 与 sBlockRecv[0].pos/size。对手精灵 ??? 的直接证据就是这些全 0。 */
static void sioDumpPlayers(struct SioLink* sio) {
	static unsigned dn;
	static bool once;
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba0 = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba0->cpu, SIO_CB2_PTR);
	bool inBattle = cb2 >= SIO_BATTLE_LO() && cb2 < SIO_BATTLE_HI();
	if (!inBattle) {
		return;
	}
	++dn;
	if (once && (dn % 128) != 0) {
		return;
	}
	once = true;
	struct GBA* gba = gba0;
	uint32_t base = SIO_EW(0x02027BD4u);
	uint32_t lp = base + 0x1Cu;   /* gLinkPlayers[1] */
	uint32_t lp0 = base;          /* gLinkPlayers[0] */
	/* 迭代 30：与移动端一致，同一行打 +0 与 +2 两种解读 */
	uint16_t ver = GBAView16(gba->cpu, lp + 2u);
	uint32_t tid = GBAView32(gba->cpu, lp + 6u);
	uint32_t n0 = GBAView32(gba->cpu, lp + 10u);
	uint32_t n1 = GBAView32(gba->cpu, lp + 14u);
	uint16_t v0 = GBAView16(gba->cpu, lp0 + 2u);
	uint32_t t0 = GBAView32(gba->cpu, lp0 + 6u);
	uint32_t q0 = GBAView32(gba->cpu, lp0 + 10u);
	uint16_t rv = GBAView16(gba->cpu, lp);
	uint32_t rt = GBAView32(gba->cpu, lp + 4u);
	uint32_t rn = GBAView32(gba->cpu, lp + 8u);
	SIO_LOG("[RHPLYR] +2 lp0 ver=%04X tid=%08X name=%08X lp1 ver=%04X tid=%08X name=%08X/%08X | +0 lp1 ver=%04X tid=%08X name=%08X blk0=%u/%u blk1=%u/%u",
	        (unsigned) v0, (unsigned) t0, (unsigned) q0,
	        (unsigned) ver, (unsigned) tid, (unsigned) n0, (unsigned) n1,
	        (unsigned) rv, (unsigned) rt, (unsigned) rn,
	        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u)),
	        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 2u),
	        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 0x0Cu),
	        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002990u) + 0x0Eu));
	/* 迭代 32 — 对手出场精灵判据（与移动端同格式）：gBattleMons @0x0201CCC4，
	 * struct BattlePokemon species @+0、stride 0x5C；全 0/0xFFFF 即 ???。 */
	{
		uint32_t bm = SIO_EW(SIO_BATTLE_MONS);
		uint16_t s0 = GBAView16(gba->cpu, bm);
		uint16_t s1 = GBAView16(gba->cpu, bm + 0x5Cu);
		uint16_t s2 = GBAView16(gba->cpu, bm + 0xB8u);
		uint16_t s3 = GBAView16(gba->cpu, bm + 0x114u);
		uint8_t ec = GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT));
		uint16_t rb = GBAView16(gba->cpu, SIO_EW(0x0201D188u));
		uint32_t btq = GBAView32(gba->cpu, SIO_EW(SIO_BATTLE_TYPE_FLAGS));
		SIO_LOG("[OPPSPECIES] cb2=%08X btlType=%08X mons=%04X,%04X,%04X,%04X enemyPartyCnt=%u recvBuf0=%04X",
		        (unsigned) GBAView32(gba->cpu, SIO_EW(0x02029118u)), (unsigned) btq,
		        (unsigned) s0, (unsigned) s1, (unsigned) s2, (unsigned) s3,
		        (unsigned) ec, (unsigned) rb);
	}
	/* ROOTHUNT2 OPPGATE（L0，只读观测，不受 RH_OFF 门控）：gBlockRecvBuffer 是
	 * 原生 party/controller 块落点；打印 enemy 槽块头/前几字 + 块接收状态，
	 * 用于 G2 判定"块是否跨网到 L0"。B7_VERBOSE 门控，格式三端一致。 */
	if (b7Verbose()) {
		uint32_t blk = SIO_EW(SIO_BLOCK_RECV_BUFFER);
		uint32_t e = 1u;   /* enemy multiplayer id（对手默认槽 1） */
		uint32_t base = blk + e * 0x100u;
		SIO_LOG("[OPPGATE] cb2=%08X blkHdr=%04X,%04X,%04X blkSp0=%04X cnt=%u brs=%04X",
		        (unsigned) GBAView32(gba->cpu, SIO_EW(0x02029118u)),
		        (unsigned) GBAView16(gba->cpu, base),
		        (unsigned) GBAView16(gba->cpu, base + 2u),
		        (unsigned) GBAView16(gba->cpu, base + 4u),
		        (unsigned) ((GBAView32(gba->cpu, base + 0x08u) >> 11u) & 0x7FFu),
		        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT)),
		        (unsigned) GBAView16(gba->cpu, SIO_IW(0x03002A40u)));
	}
	/* ROOTHUNT2 [BTLCFG] 只读观测（B7_VERBOSE 门，不受 RH_OFF）：坐实 cable_club
	 * case5 是否执行——打印 var8004(linkService)/远端玩家标志/btlType/linkType/cb2。
	 * 与 mobile 端格式一致，供诊断 E2E 抓日志。 */
	if (b7Verbose()) {
		uint32_t cb2now = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
		SIO_LOG("[BTLCFG] cb2=%08X var8004=%u remPlayers=%u btlType=%08X linkType=%04X mu=%u",
		        (unsigned) cb2now,
		        (unsigned) GBAView16(gba->cpu, SIO_EW(SIO_SPECIAL_VAR_8004)),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_REMOTE_LINK_PLAYERS)),
		        (unsigned) GBAView32(gba->cpu, SIO_EW(SIO_BATTLE_TYPE_FLAGS)),
		        (unsigned) GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE)),
		        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_BATTLE_COMM)));
	}
}

/* 迭代 33：战斗期保链 —— 继续完成 SIO 轮次保 9 IRQ/帧，但清 LAG_MASTER/
 * 错误位；与 mobileBattleKeepAlive 对称（冻结轮次会触发 LAG_MASTER）。 */
/* 迭代 45: state1->2 由 shouldAdvanceLinkState 驱动（link.c:1966） */
/* 迭代 48 — 与移动端对称：压制 300 帧超时 / 同步 saved players / 抑制
 * CheckErrorStatus / 正确 cb2 拉回 / st==1 持续 adv。见 mobileGuardBattleError
 * 的源码根因注释。 */
#define SIO_RH_GTASKS         0x02033D0Cu
#define SIO_RH_WAIT_CONN_TASK 0x0810731Du
#define SIO_RH_LINK_PLAYERS   0x02027BD4u
#define SIO_RH_SAVED_PLAYERS  0x02027C60u
#define SIO_RH_SUPPRESS_ERR   0x03002AACu
#define SIO_RH_MSGBOX_MODE    0x02021A00u   /* sFieldMessageBoxMode */
#define SIO_RH_GMAIN_STATE    0x0202954Cu   /* gMain.state = gMain+0x438 */
#define SIO_RH_BATTLE_COMM    0x0201CFF4u   /* gBattleCommunication[MULTIUSE_STATE] */
static void sioGuardBattleError(struct SioLink* sio) {
	if (!sio->link || netLinkState(sio->link) != 2 || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t lk = SIO_IW(0x03002AF4u);
	unsigned st = GBAView8(gba->cpu, lk + 1u);
	/* ROOTHUNT2 握手根治②（与移动端对称）：state1→2 条件 gShouldAdvanceLinkState==1
	 * (gen8 link.c:1967)，lt==LINKTYPE_BATTLE 门在握手早期挡住 guard ⇒ adv 写不进。
	 * RHADV 提到 lt 门之前、对所有 link 生效，每轮补 adv=1（与战斗类型无关）。 */
	if (st == 1u && GBAView8(gba->cpu, SIO_IW(0x03002AD8u)) == 0u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AD8u), 1, NULL);
		if (rhVerbose()) {
			SIO_LOG("[RHADV2] st=1 adv<-1 (pre-LINKTYPE) cb2=%08X",
			        (unsigned) GBAView32(gba->cpu, SIO_CB2_PTR));
		}
	}
	if (GBAView16(gba->cpu, SIO_EW(SIO_LINK_TYPE_BATTLE)) != SIO_LINKTYPE_BATTLE) {
		return;
	}
	unsigned pc = GBAView8(gba->cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF);
	unsigned rem = GBAView8(gba->cpu, SIO_IW(0x03002AC1u));
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* ROOTHUNT2 握手根治①：复位三步（压 tTimer=0 防 300 帧超时 + 同步 saved
	 * players 防 CheckLinkPlayersMatchSaved 关链 + 抑制错误位）此前被 cb2 门
	 * (battleCb/errCb) 挡住——cb2 提前进 BattleMainCB2 后门失效，tTimer 累积到
	 * 300 帧 → CloseLink → CpuFill32 清 gLink → state 0↔1 振荡。现改为只要
	 * netLinkState==2 && LINKTYPE_BATTLE && gLink.state>=1 就每轮执行，cb2 门
	 * 只保留错误屏 cb2 拉回那一段（下方 errCb 分支）。 */
	int resetN = 0;
	if (st >= 1u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002A30u), 0, NULL);
		GBAPatch8(gba->cpu, SIO_IW(SIO_RH_SUPPRESS_ERR), 1, NULL);

		uint32_t tasks = SIO_EW(SIO_RH_GTASKS);
		for (unsigned i = 0; i < 16u; ++i) {
			uint32_t t = tasks + i * 0x28u;
			if (GBAView8(gba->cpu, t + 4u) && GBAView32(gba->cpu, t) == SIO_RH_WAIT_CONN_TASK) {
				GBAPatch16(gba->cpu, t + 8u, 0, NULL);   /* tTimer=0，含 600 帧 TryLinkTimeout 窗口 */
				++resetN;
			}
		}
		for (unsigned k = 0; k < 0x8Cu; k += 4u) {
			uint32_t v = GBAView32(gba->cpu, SIO_EW(SIO_RH_LINK_PLAYERS) + k);
			GBAPatch32(gba->cpu, SIO_EW(SIO_RH_SAVED_PLAYERS) + k, (int32_t) v, NULL);
		}
	}

	/* 错误屏 cb2 在战斗窗口之外，必须单独放行（与移动端对称）。 */
	bool errCb = (cb2 == SIO_CB2_LINK_ERROR || cb2 == SIO_CB2_LINK_ERROR_ALT);
	/* ROOTHUNT2 S1：错误屏时 state 在 2↔0 振荡、st>=4 永不满足 ⇒ guard 拉回失效。
	 * 放宽到 st>=2（errCb 本就是错误屏 cb2，平时不触发，不影响稳定基线）。 */
	if (errCb && st >= 2u && pc >= 2u && rem >= 1u) {
		uint32_t target = SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF;
		unsigned mu = GBAView8(gba->cpu, SIO_EW(SIO_RH_BATTLE_COMM));
		GBAPatch32(gba->cpu, SIO_CB2_PTR, (int32_t) target, NULL);
		GBAPatch8(gba->cpu, SIO_EW(SIO_RH_GMAIN_STATE), 0, NULL);
		GBAPatch8(gba->cpu, SIO_EW(SIO_RH_MSGBOX_MODE), 0, NULL);
		/* 迭代 52：错误屏恢复只改 callback，绝不回退 MULTIUSE_STATE
		 *（APPHUNT-SPENC 实证 mu=5->1 把已完成的 case2/3/4 打回）。 */
		SIO_LOG("[RHERR] recover cb2=%08X -> HandleStartBattle(%08X) st=%u pc=%u rem=%u mu=%u(kept) mm=%u rst=%d",
		        (unsigned) cb2, (unsigned) target, st, pc, rem, mu,
		        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_RH_MSGBOX_MODE)), resetN);
	}
}

/* 迭代 49 — 与移动端对称：对端一直 drive 陈旧 B9A0、块 ACK 永不回来时，
 * 本端块发完后代补 gBlockReceivedStatus[0..1]（见 mobileCompleteBlockExchange）。 */
#define SIO_RH_LINK_CALLBACK  0x03002AD4u   /* gLinkCallback @0x03002BA8 */
static void sioCompleteBlockExchange(struct SioLink* sio) {
	if (rhPatchesOff()) {
		return;
	}
	if (!sio->link || netLinkState(sio->link) != 2 || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 != SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = SIO_IW(0x03002AF4u);
	if (GBAView8(gba->cpu, lk + 1u) < 4u || GBAView8(gba->cpu, lk + 3u) < 2u
	    || GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) == 0u) {
		return;
	}
	unsigned mu = GBAView8(gba->cpu, SIO_EW(SIO_RH_BATTLE_COMM));
	/* ROOTHUNT2：与移动端对称。cb!=0 是 case3/7/11/16 SendBlock 的正常在途
	 * 回调（LinkCB_BlockSendBegin），等它归零才补 ACK 会让 mu 卡 4。 */
	if (mu < 2u) {
		return;
	}
	bool brsWait = (mu == 2u || mu == 4u || mu == 8u || mu == 12u || mu == 17u);
	uint32_t brs = SIO_IW(0x03002A40u);
	/* brs 是位域：bit0=byte[0]、bit1=byte[1]，要 (val&3)==3 需两字节都 1。
	 * 旧条件 byte[0]==0 才写 → byte[0] 被游戏先置 1 后 brs 卡 01。任一字节
	 * 为 0 就补两字节，闭合 brs 01→03。 */
	unsigned b0 = GBAView8(gba->cpu, brs);
	unsigned b1 = GBAView8(gba->cpu, brs + 1u);
	if (brsWait && (b0 == 0u || b1 == 0u)) {
		GBAPatch8(gba->cpu, brs, 1, NULL);
		GBAPatch8(gba->cpu, brs + 1u, 1, NULL);
		SIO_LOG("[RHBRS] set brs=03 mu=%u b0=%u->1 b1=%u->1 cb2=%08X st=%u pc=%u",
		        (unsigned) mu, b0, b1, (unsigned) cb2,
		        (unsigned) GBAView8(gba->cpu, lk + 1u),
		        (unsigned) GBAView8(gba->cpu, lk + 3u));
	}
}
/* ROOTHUNT2 灰区全开 GZ5：只做 brs 强写，与上面 sioCompleteBlockExchange 隔离，
 * 不改其 rhPatchesOff() 早退门（RL1–RL4 门保持原样默认关）。与移动端
 * mobileGrayForceBrs 逐行对称。只写 gBlockReceivedStatus(SIO_GLOBAL_BLK_RECV_STATUS)
 * 两字节，绝不写 gEnemyParty / gBlockRecvBuffer / nr / rem / gLinkPlayers。
 * brs 置位是强写伪 ACK（非游戏原生闭合），产物须标注灰区口径。 */
static void sioGrayForceBrs(struct SioLink* sio) {
	if (!sioGrayAllOn() || !sio || !sio->link || netLinkState(sio->link) != 2
	    || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 != SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = SIO_IW(SIO_GLINK_STATE);
	if (GBAView8(gba->cpu, lk + SIO_GLINK_STATE_OFF) < 4u
	    || GBAView8(gba->cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF) < 2u
	    || GBAView8(gba->cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID)) == 0u) {
		return;
	}
	unsigned mu = GBAView8(gba->cpu, SIO_EW(SIO_RH_BATTLE_COMM));
	bool brsWait = (mu == 2u || mu == 4u || mu == 8u || mu == 12u || mu == 17u);
	if (!brsWait) {
		return;
	}
	uint32_t brs = SIO_IW(SIO_GLOBAL_BLK_RECV_STATUS);
	unsigned b0 = GBAView8(gba->cpu, brs);
	unsigned b1 = GBAView8(gba->cpu, brs + 1u);
	if (b0 == 0u || b1 == 0u) {
		GBAPatch8(gba->cpu, brs, 1, NULL);
		GBAPatch8(gba->cpu, brs + 1u, 1, NULL);
		SIO_LOG("[RHBRS-GRAY] force brs=03 mu=%u b0=%u->1 b1=%u->1 cb2=%08X st=%u pc=%u (灰区强写,非原生闭合)",
		        (unsigned) mu, b0, b1, (unsigned) cb2,
		        (unsigned) GBAView8(gba->cpu, lk + SIO_GLINK_STATE_OFF),
		        (unsigned) GBAView8(gba->cpu, lk + SIO_GLINK_PLAYERCOUNT_OFF));
	}
}

/* ROOTHUNT2 视觉修复（PC 侧，时机前移）：对手 sprite 在 switch-in 出场动画时
 * 由 BattleLoadOpponentMonSpriteGfx(&gEnemyParty[gBattlerPartyIndexes[battlerId]])
 * 读取一次（battle_controller_link_opponent.c:1182）。VIS 实证 gate 卡在
 * BattleMainCB2(080B4845) 太晚——sprite/血条已在更早已固化，像素零变化。
 * gBattleMons 在 HandleStartBattle case4/8/12 就被填真值(00D5...)，早于
 * sprite 加载。故把 gate 前移到 HandleStartBattle(lo+0x6AD=080B376D) 起，
 * 在 case4 之后、sprite 加载之前就把 gEnemyParty 写好。
 * 绝不写 btlType/case1 依赖的任何字段——与 0x0E 回归路径彻底隔离。 */
/* ROOTHUNT2 checksum 修复（三端对称，SUBSTRUCT 真因）：裸写 species 不重算 checksum
 * ⇒ GetMonData(MON_DATA_SPECIES) default(pokemon.c:1408) 判 checksum 失配 ⇒
 * isBadEgg ⇒ 返回 SPECIES_EGG(问号球)。这里按 gen8 结构重写 mon 并维护 checksum：
 *  species@BoxPokemon+0x08 bit11..21；level@0x34；flags@BoxPokemon+6
 *  (isBadEgg bit0/isEgg bit2 清、hasSpecies bit1 置)；checksum@0x4E =
 *  BoxPokemon 前 0x2C 字节之和(librfu_intr.c:485)。sizeof(Pokemon)=0x50。 */
static void sioFixEnemyMonSpecies(struct GBA* gba, uint32_t mon, uint16_t sp, uint8_t level) {
	uint32_t w = (uint32_t) GBAView32(gba->cpu, mon + 0x08u) & ~(0x7FFu << 11u);
	GBAPatch32(gba->cpu, mon + 0x08u, (int32_t) (w | ((uint32_t) sp << 11u)), NULL);
	if (GBAView8(gba->cpu, mon + 0x34u) == 0u) {
		GBAPatch8(gba->cpu, mon + 0x34u, level, NULL);
	}
	uint8_t fl = (uint8_t) GBAView8(gba->cpu, mon + 6u);
	fl = (uint8_t) ((fl & ~0x05u) | 0x02u);   /* 清 isBadEgg(bit0)/isEgg(bit2)，置 hasSpecies(bit1) */
	GBAPatch8(gba->cpu, mon + 6u, fl, NULL);
	/* ROOTHUNT2 — 名字空白真正根因修正：gSpeciesNames 不是指针表，而是连续压缩
	 * 文本数组 [num][POKEMON_NAME_LENGTH+1=11] @SIO_G_SPECIES_NAMES（objdump 证实 0xac 控制码
	 * 连续字节，非 u32 指针）。上一版误当指针表读 0xacacacac 被范围检查丢弃 ⇒
	 * mon->name 从未填。正确做法：从 gSpeciesNames + sp*11 连续复制 10 字节到
	 * mon->name@0x44（StringCopy10 口径，text printer 会解释压缩编码）。
	 * name 在 BoxPokemon(0x2C)之外，不影响 checksum。 */
	{
		uint32_t nameSrc = SIO_G_SPECIES_NAMES + (uint32_t) sp * 11u;
		for (unsigned c = 0; c < 10u; ++c) {
			GBAPatch8(gba->cpu, mon + 0x44u + c,
			          (int8_t) GBAView8(gba->cpu, nameSrc + c), NULL);
		}
	}
	uint32_t sum = 0;
	for (unsigned k = 0; k < 0x2Cu; ++k) {
		sum += (uint32_t) GBAView8(gba->cpu, mon + k);
	}
	GBAPatch16(gba->cpu, mon + 0x4Eu, (int16_t) (uint16_t) sum, NULL);
}

static void sioRestoreEnemyVisualLate(struct SioLink* sio) {
	if (rhPatchesOff()) {
		return;
	}
	if (!sio || !sio->link || netLinkState(sio->link) != 2 || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* ROOTHUNT2 最后一层：注入 gate 原仅 [HandleStartBattle, BattleMainCB2]，
	 * 重绘状态机 cb2=0x081CBBEF(ReshowBattleScreenAfterMenu) 远在窗口外 ⇒
	 * 重绘那 ~20 帧注入完全停摆；若重绘的 ResetSpriteData/重新 BattleInitAllSprites
	 * 覆盖了 gEnemyParty，对手框又读回 0(问号)。扩展 gate 覆盖重绘区间
	 * [0x081CBB00,0x081CC000)，重绘全程持续补真 species。 */
	bool inBattle = (cb2 >= SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	                 && cb2 < SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF);
	bool inReshow = (cb2 >= SIO_RESHOW_LO && cb2 < SIO_RESHOW_HI);
	if (!inBattle && !inReshow) {
		return;
	}
	uint32_t bm = SIO_EW(SIO_BATTLE_MONS);
	uint32_t ep = SIO_EW(SIO_ENEMY_PARTY);
	uint32_t bpi = SIO_EW(SIO_BATTLER_PARTY_INDEXES);
	/* 真 species 源优先级：
	 *  ① gBattleMons（晚窗口 BattleMainCB2 才有，00D5...）；
	 *  ② s_pcPeerSpeciesBytes（APP 发来的 sidecar 高16位解码，握手期就有——
	 *     BLK 实证 gBlockRecvBuffer 的 CONT_BLOCK 块对端不回(blkSp=0660无效)，
	 *     真 species 只在 SIO sidecar 里逐字节传到）。
	 * 找到后写 gEnemyParty 全 6 槽 + level + count，使 case18 的
	 * BattleInitAllSprites/UpdateHealthboxAttribute 与 switch-in sprite 加载
	 * 都读到真值（这两处只读一次，故必须在它们之前写好）。 */
	uint16_t srcSp[6] = {0};
	unsigned any = 0;
	/* 先取 gBattleMons 可能的真值（对手 battler 通常 index1，但扫 0..3 兜底） */
	for (unsigned i = 0; i < 4u; ++i) {
		uint16_t sp = (uint16_t) GBAView16(gba->cpu, bm + i * 0x5Cu);
		if (sp != 0u && sp != 0xFFFFu && sp <= 0x400u) {
			srcSp[i] = sp;
			any = 1;
		}
	}
	/* 早窗口 gBattleMons 全 0 时，从 APP sidecar 解码字节补齐（6 只 × u16 小端） */
	for (unsigned m = 0; m < 6u; ++m) {
		uint16_t sp = (uint16_t) (s_pcPeerSpeciesBytes[m * 2u]
		                        | ((uint16_t) s_pcPeerSpeciesBytes[m * 2u + 1u] << 8u));
		if (sp != 0u && sp != 0xFFFFu && sp <= 0x400u) {
			for (unsigned i = 0; i < 6u; ++i) {
				if (srcSp[i] == 0u) { srcSp[i] = sp; any = 1; break; }
			}
		}
	}
	uint16_t firstSp = 0;
	for (unsigned i = 0; i < 6u; ++i) {
		if (srcSp[i] != 0u) { firstSp = srcSp[i]; break; }
	}
	if (any) {
		/* 与移动端对称说明：移动端(mgba_mobile.c)是主机，gEnemyParty 结构由 sidecar
		 * 自造，故整只复制 gPlayerParty 模板补 level/HP/moves；PC 是从机，gEnemyParty
		 * 的结构基础由游戏真实块交换(gBlockRecvBuffer→gEnemyParty, case4/8/12)提供，
		 * 这里只需补 species+level+count，无需(也不应)整只覆盖游戏已填数据。 */
		for (unsigned i = 0; i < 6u; ++i) {
			uint16_t sp = srcSp[i] != 0u ? srcSp[i] : firstSp;
			sioFixEnemyMonSpecies(gba, ep + i * 0x50u, sp, 50);
			/* ROOTHUNT2 — 移除 gBattleMons 覆盖（B4 铁证，与移动端对称）：
			 * 游戏真实 gBattleMons[1]=058B，注入 sp[1]=0009(我方回显)。覆盖会把
			 * 真 058B 换成 0009，造成框/sprite 矛盾。gBattleMons 交回游戏自己填。 */
		}
		if (GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT)) == 0u) {
			GBAPatch8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT), 6, NULL);
		}
	}
	static unsigned visN;
	if (rhVerbose() && (++visN % 240u) == 1u) {
		SIO_LOG("[RHVIS] cb2=%08X bIdx=%u,%u srcSp=%04X,%04X,%04X pcSp=%04X,%04X,%04X hits=%u sp0=%04X epSp=%04X,%04X epLv=%u,%u cnt=%u",
		        (unsigned) cb2,
		        (unsigned) GBAView8(gba->cpu, bpi), (unsigned) GBAView8(gba->cpu, bpi + 1u),
		        srcSp[0], srcSp[1], srcSp[2],
		        (unsigned) (s_pcPeerSpeciesBytes[0] | ((unsigned) s_pcPeerSpeciesBytes[1] << 8u)),
		        (unsigned) (s_pcPeerSpeciesBytes[2] | ((unsigned) s_pcPeerSpeciesBytes[3] << 8u)),
		        (unsigned) (s_pcPeerSpeciesBytes[4] | ((unsigned) s_pcPeerSpeciesBytes[5] << 8u)),
		        s_pcSpSidecarHits,
		        (unsigned) (s_pcPeerSpeciesBytes[0] | ((unsigned) s_pcPeerSpeciesBytes[1] << 8u)),
		        (unsigned) ((GBAView32(gba->cpu, ep + 0x08u) >> 11u) & 0x7FFu),
		        (unsigned) ((GBAView32(gba->cpu, ep + 0x50u + 0x08u) >> 11u) & 0x7FFu),
		        (unsigned) GBAView8(gba->cpu, ep + 0x34u),
		        (unsigned) GBAView8(gba->cpu, ep + 0x50u + 0x34u),
		        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT)));
	}
}

/* ROOTHUNT2 重绘（方案A，REPAINT）：数据通道已打通(gEnemyParty species 真/count=6)，
 * 但 BattleMainCB2 每帧只 AnimateSprites/BuildOamBuffer，从不重新解压 gfx/刷血条；
 * 问号球在 CB2_InitBattle 一次性解压固化。这里写 gMain.callback2 指向
 * ReshowBattleScreenAfterMenu(0x081CBBEF=0x081cbbee+Thumb1)，让游戏自己跑
 * reshow_battle_screen.c 状态机(~20帧)：ResetSpriteData→从当前 gEnemyParty 重解压
 * 精灵→UpdateHealthboxAttribute(HEALTHBOX_ALL) 刷名字/等级→默认回 BattleMainCB2。
 * 只写 1 个 32 位内存值，不调用任何 ARM 函数指针，零崩溃风险。 */
static void sioReshowBattleVisual(struct SioLink* sio) {
	static bool s_reshowDone;
	if (rhPatchesOff()) {
		return;
	}
	if (s_reshowDone || !sio || !sio->link || netLinkState(sio->link) != 2
	    || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* ROOTHUNT2 G5：用运行时解析的 BattleMainCB2（随 ROM 平移），不用硬编码 */
	if (cb2 != SIO_BATTLE_CB2()) {
		return;   /* 只在 BattleMainCB2 主循环、数据已注入后触发一次 */
	}
	uint32_t ep = SIO_EW(SIO_ENEMY_PARTY);
	uint16_t sp0 = (uint16_t) ((GBAView32(gba->cpu, ep + 0x08u) >> 11u) & 0x7FFu);
	if (sp0 == 0u || GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT)) == 0u) {
		return;   /* 真 species / count 必须已注入 */
	}
	GBAPatch32(gba->cpu, SIO_CB2_PTR, (int32_t) SIO_CB2_RESHOW, NULL);
	s_reshowDone = true;
	SIO_LOG("[RHRESHOW] cb2=%08X -> %08X sp0=%04X cnt=%u (reshow ~20 frames, BATTLE采样暂停)",
	        (unsigned) cb2, (unsigned) SIO_CB2_RESHOW, (unsigned) sp0,
	        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_ENEMY_PARTY_COUNT)));
}

/* 迭代 58 — 与移动端对称：清掉残留的 LinkCB_ReadyCloseLink/WaitCloseLink，
 * 让 IsLinkTaskFinished() 返回 TRUE，CB2_HandleStartBattle case1 才能推进。 */
static void sioUnblockLinkTask(struct SioLink* sio) {
	/* ROOTHUNT2 S7：方案Y(BTLCFG=1)下解禁——仅清特定 close callback(非伪造数据)，
	 * 否则 cb 卡 close callback(SIO_CB_READY_CLOSE*) ⇒ IsLinkTaskFinished() 假 ⇒ case1 静默卡 mu=1。
	 * BTLCFG=0 时零注入基线不变。 */
	if (rhPatchesOff() && !linkBtcfgOn()) {
		return;
	}
	if (!sio->link || netLinkState(sio->link) != 2 || !sio->core
	    || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 != SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = SIO_IW(0x03002AF4u);
	if (GBAView8(gba->cpu, lk + 1u) < 4u || GBAView8(gba->cpu, lk + 3u) < 2u
	    || GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) == 0u) {
		return;
	}
	uint32_t cb = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_RH_LINK_CALLBACK));
	if (cb == SIO_CB_READY_CLOSE || cb == SIO_CB_READY_CLOSE_ALT) {
		GBAPatch32(gba->cpu, SIO_IW(SIO_RH_LINK_CALLBACK), 0, NULL);
		SIO_LOG("[RHUNBLOCK] cb=%08X -> NULL mu=%u st=%u pc=%u rdy=%04X cb2=%08X",
		        (unsigned) cb,
		        (unsigned) GBAView8(gba->cpu, SIO_EW(SIO_RH_BATTLE_COMM)),
		        (unsigned) GBAView8(gba->cpu, lk + 1u),
		        (unsigned) GBAView8(gba->cpu, lk + 3u),
		        (unsigned) GBAView16(gba->cpu, SIO_RDY_CLOSE_LINK), (unsigned) cb2);
	}
}

static void sioDriveBattleRehandshake(struct SioLink* sio) {
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	if (cb2 < SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    || cb2 >= SIO_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		return;
	}
	if (GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 1u) == 1u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AD8u), 1, NULL);
		SIO_LOG("[RHADV] st=1 -> shouldAdvance=1 cb2=%08X", (unsigned) cb2);
	}
}
static void sioBattleKeepAlive(struct SioLink* sio) {
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(gba->cpu, SIO_CB2_PTR);
	/* ROOTHUNT2 最后关卡（与 mobile 对称）：错误屏 cb2 也放行补 rem=1，
	 * 防真 LINK 关链后 rem 恒 0 → LinkError 永久卡死。 */
	bool errCb = (cb2 == SIO_CB2_LINK_ERROR || cb2 == SIO_CB2_LINK_ERROR_ALT);
	if (!errCb && (cb2 < SIO_BATTLE_LO() || cb2 >= SIO_BATTLE_HI())) {
		return;
	}
	/* 迭代 48: 只在握手完成(st>=4 && pc>=2)后补 rem=1；过早补会触发
	 * Task_WaitForLinkPlayerConnection 的 !DoesLinkPlayerCountMatchSaved()
	 * 分支 → CloseLink → 错误屏 + st 振荡。 */
	if ((errCb || cb2 >= SIO_BATTLE_LO() + BATTLE_START_HANDLE_OFF)
	    && GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 1u) >= 4u
	    && GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 3u) >= 2u
	    && GBAView8(gba->cpu, SIO_IW(0x03002AC1u)) == 0u) {
		GBAPatch8(gba->cpu, SIO_IW(0x03002AC1u), 1, NULL);
		SIO_LOG("[RBATTLE] restore rem=1 cb2=%08X", (unsigned) cb2);
	}
	/* 迭代 42: 与移动端对称 —— 清全部四个错误源标志 + 抑制错误屏 */
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_HWERR_OFF, 0, NULL);
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_BADCKSUM_OFF, 0, NULL);
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_QUEUEFULL_OFF, 0, NULL);
	GBAPatch8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_LAG_OFF, 0, NULL);
	GBAPatch8(gba->cpu, SIO_IW(SIO_RH_SUPPRESS_ERR), 1, NULL);
	uint32_t st = (uint32_t) GBAView32(gba->cpu, SIO_IW(SIO_GLINK_STATUS));
	if (st & SIO_LINK_STAT_ERRORS) {
		GBAPatch32(gba->cpu, SIO_IW(SIO_GLINK_STATUS), (int32_t) (st & ~SIO_LINK_STAT_ERRORS), NULL);
	}
}

static void linkPollEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(cyclesLate);
	struct SioLink* sio = (struct SioLink*) user;
	sioResolveIwramDelta(sio);
	sioResolveCodeDelta(sio);     /* 一次性：从 ROM 自解析代码段 delta / 战斗窗口 */
	/* 迭代 40：与移动端同格式 BSTATE（标签与实参逐项对齐） */
	{
		static unsigned qstN;
		if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA
		    && (++qstN % 64) == 0 && (rhVerbose() || (qstN % 256) == 0)) {
			struct GBA* gq = (struct GBA*) sio->core->board;
			uint32_t lq = SIO_IW(0x03002AF4u);
			SIO_LOG("[BSTATE] cb2=%08X st=%u pc=%u rem=%u nr0=%02X nr1=%02X brs=%02X rdy=%04X hs=%u sc=%u rc=%u cg=%u ok=%u",
			        (unsigned) GBAView32(gq->cpu, SIO_EW(0x02029118u)),
			        (unsigned) GBAView8(gq->cpu, lq + 1u),
			        (unsigned) GBAView8(gq->cpu, lq + 3u),
			        (unsigned) GBAView8(gq->cpu, SIO_IW(SIO_GLOBAL_REMOTE_ID)),
			        (unsigned) GBAView8(gq->cpu, SIO_IW(SIO_REMOTE_PLAYERS_NOT_RECEIVED)),
			        (unsigned) GBAView8(gq->cpu, SIO_IW(SIO_REMOTE_PLAYERS_NOT_RECEIVED) + 1u),
			        (unsigned) GBAView8(gq->cpu, SIO_IW(SIO_GLOBAL_BLK_RECV_STATUS)),
			        (unsigned) GBAView16(gq->cpu, SIO_RDY_CLOSE_LINK),
			        (unsigned) GBAView8(gq->cpu, lq + 0x0Eu),
			        (unsigned) GBAView8(gq->cpu, lq + 0x16u),
			        (unsigned) GBAView8(gq->cpu, lq + 0x17u),
			        (unsigned) s_sioCmdGuard, (unsigned) sio->sioOk);
		}
	}
	sioStartupTrace(sio);
	/* ROOTHUNT2 方案Y：var8004=1 每轮补写（不受 dump 128轮节流限制），确保
	 * cb2 还在 cable club 阶段时一定写好、赶在 case5 读之前；停止条件在 helper 内。 */
	sioEnsureLinkBtcfg((struct GBA*) (sio->core ? sio->core->board : NULL));
	sioEnsureLinkOpen(sio);   /* ROOTHUNT2 块交换根治①：恢复 gLinkOpen 让 callback 推进 */
	sioDumpPlayers(sio);
	sioGuardBattleError(sio);
	sioCompleteBlockExchange(sio);
	sioGrayForceBrs(sio);   /* 灰区全开 GZ5：独立 brs 强写，不碰原 rhPatchesOff 门/party/nr/rem */
	sioRestoreEnemyVisualLate(sio);
	sioReshowBattleVisual(sio);
	sioUnblockLinkTask(sio);
	sioDriveBattleRehandshake(sio);
	sioBattleKeepAlive(sio);
	sioHandoffGuard(sio);
	sioSeatAssist(sio);
	sioCloseGrace(sio, timing);
	serviceLink(sio);
	sioChainWatchdog(sio);
	sioBlkReqRetry(sio);
	sioCallbackRearm(sio);
	maybeClearLinkCallback(sio);   /* 每轮检查：等 IsLinkTaskFinished 的黑屏死结 */
	sioStandbyInject(sio);         /* standby 0x2FFE 受控注入 */
	/* [diag]/[room] 统一由 sioLinkPump 输出（Qt 帧循环无条件调用，链路没连上
	 * 时也有）。这里只负责续期：链路可能在游戏已进入菜单之后才连上，停在
	 * 这里就再也不会 attachLink。 */
	mTimingSchedule(timing, &sio->linkEvent, 8192);
}

/**
 * Slave-side "round complete" event.
 *
 * Why the slave's emulated clock must be pinned to the host's cadence: the
 * game's link code enqueues one command and dequeues one command per VBlank.
 * If the two emulators advance their clocks at different rates, one queue
 * overflows (queueFull -> communication error) while the other drains empty.
 * The round therefore completes exactly "last completion + K" emulated
 * cycles later, K = one host round (transfer 5755 + Timer3 12608 ~ 18363);
 * when the peer's word has not arrived yet the event takes it with a short
 * bounded real-time wait (the emulated clock is frozen while blocked, so the
 * rate stays locked).
 *
 * The round number belongs to the host alone: both sides counting on their
 * own diverge immediately, so the slave takes the word with the "loose"
 * entry (netLinkTakePeerWordAny), adopts the host's index and pushes its own
 * word back tagged with it - the host's strict match then never misses.
 */
/* MGBAX_LINK_FORCEHS=0 关掉握手字强制（主机 0x8FFF / 从机 0xB9A0），
 * 默认开。用于 A/B 对照：确认强制到底是帮忙还是帮倒忙。 */
static bool sioForceHandshake(void);
static int sioWaitMs(struct SioLink* sio);
static int sioPeerWaitMs(struct SioLink* sio);
static int sioPipelineWaitMs(struct SioLink* sio, int want);
static bool sioFastFrame(struct SioLink* sio);
static bool sioFastFrameSlave(struct SioLink* sio);
static bool sioConnectPollOn(struct SioLink* sio);
static unsigned sioHostPubIndex(struct SioLink* sio); /* 链路层最近一次对端推字 idx */

/* 【ROOTHUNT 从机早退取证】每次不走 completeMultiTransfer 都记一条（头 12 次 +
 * 每 4096 次 + reason 变化时），现场直接看出从机轮次为什么停。 */
static void sioSlaveSkip(struct SioLink* sio, int reason) {
	static uint32_t sn;
	static int prevReason = -1;
	if (!rhVerbose()) {
		return;
	}
	uint32_t seq = ++sn;
	if (seq > 12 && (seq % 4096) != 0 && reason == prevReason) {
		return;
	}
	int link = sio && sio->link ? netLinkState(sio->link) : -1;
	int pl = sio && sio->link ? netLinkPlayer(sio->link) : -1;
	unsigned gst = 0, gim = 0;
	if (sio && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) sio->core->board;
		gst = GBAView8(g->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF);
		gim = GBAView8(g->cpu, SIO_IW(0x03002AF4u) + 0x00u);
	}
	SIO_LOG("[RHSLVSKIP] n=%u why=%d link=%d pl=%d ok=%u gst=%u gim=%u wait=%d pq=%d",
	        seq, reason, link, pl, sio ? (unsigned) sio->sioOk : 0u,
	        gst, gim, sio && sio->sioWaiting ? 1 : 0,
	        sio && sio->link ? netLinkPeerPending(sio->link) : -1);
	prevReason = reason;
}

static void sioSlaveDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct SioLink* sio = (struct SioLink*) user;
	sio->sioSlaveArmed = false;
	if (!sio->link || !sio->linkAttached || !sio->core) {
		sioSlaveSkip(sio, 1);
		return;
	}
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		sioSlaveSkip(sio, 2);
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (gba->sio.mode != GBA_SIO_MULTI) {
		sioSlaveSkip(sio, 3);
		return;
	}
	/* 角色看游戏（gLink.isMaster==8 = 主机），不看链路层的 player 号：
	 * 走云端房间时两端链路层都是 TCP 主机、player 号都停在 0，用它判会让
	 * **两端都走这个分支直接 return**，谁都不当从机、谁都不回推字
	 *（现场：两端日志同时报 me=0，主机侧 done want=1 have=0 永远等不到）。 */
	if (GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x00u) == 8) {
		sioSlaveSkip(sio, 4);
		return;
	}
	/* bus 模式下的启动期保护：游戏还没进入联机代码（gLinkCallback == 0）时，
	 * boot/BIOS 的 MULTI 探测不该被总线参与。否则三核在启动期就互相喂字，
	 * boot 卡在 `MULTI m=494E im=0 pc=0` 再也进不去（实测 3 人 cb2=0）。
	 * 2 人直连路径不走这里，行为不变。 */
	if (netLinkBusActive(sio->link)
	    && GBAView16(gba->cpu, SIO_IW(0x03002AD4u)) == 0
	    && GBAView16(gba->cpu, SIO_IW(0x03002AD6u)) == 0) {
		/* 同主机侧：boot 期不参与总线，用空槽收尾让启动继续。 */
		static unsigned gateN;
		if (++gateN <= 5 || (gateN % 3000) == 0) {
			fprintf(stderr, "GATESLAVE n=%u me=%d mode=%d idx=%u\n",
			        gateN, netLinkPlayer(sio->link), (int) gba->sio.mode,
			        (unsigned) sio->sioIndex);
		}
		sio->sioWaiting = false;
		sio->sioRetries = 0;
		uint32_t emptyVals[4] = { 0xFFFFu, 0xFFFFu, 0xFFFFu, 0xFFFFu };
		int bp = netLinkBusPlayers(sio->link);
		if (bp < 2) {
			bp = 2;
		}
		completeMultiTransferBus(sio, emptyVals, bp, cyclesLate);
		return;
	}
	/* 3/4 人总线：从机先把自己的字推给主机（主机要收齐才广播），再等广播。
	 * 两人走下面原来的「取对端字 → 收尾 → 回推」路径。 */
	{
		int busPlayers = netLinkBusPlayers(sio->link);
		if (netLinkBusActive(sio->link) && busPlayers >= 2) {
			uint16_t own = sio->sioRoundWordValid ? sio->sioRoundWord
			                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
			sio->sioRoundWordValid = false;
			uint32_t busVals[4];
			uint16_t used = sio->sioIndex;
			int busGot = netLinkBusRound(sio->link, sio->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(sio, -1), &used);
			if (busGot < 0) {
				/* 主机还没广播（还在等别的从机）：快速重挂，绝不拿空槽收尾
				 * —— 一次空槽就会让游戏的 DoHandshake 把 playerCount 清 0。 */
				++sio->sioTimeouts;
				if (timing) {
					mTimingSchedule(timing, &sio->sioSlaveDone, 2048);
					sio->sioSlaveArmed = true;
				}
				return;
			}
			{
				uint32_t peerCycles = netLinkBusRoundCycles(sio->link);
				if (peerCycles != 0) {
					if (sio->sioPeerCyclesValid) {
						uint32_t delta = peerCycles - sio->sioPeerCycles;
						if (delta > 4000 && delta < 400000) {
							sio->sioSlavePeriod = delta;
						}
					}
					sio->sioPeerCycles = peerCycles;
					sio->sioPeerCyclesValid = true;
				}
			}
			if (used != sio->sioIndex) {
				++sio->sioMisorder;
			}
			sio->sioIndex = used;
			sio->sioHasRemote = true;
			sio->sioRemote = busVals[0];
			completeMultiTransferBus(sio, busVals, busPlayers, cyclesLate);
			sio->sioPushValue = own;
			sio->sioPushIndex = sio->sioIndex;
			sio->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
			return;
		}
	}
	/* ---- 从机快帧：与主机侧 sioDoneEvent 里的 sioFastFrame 分支同构 ----
	 *
	 * 为什么从机也要走：主机侧的零等待优化只改了这一侧，从机每轮仍在
	 * netLinkTakePeerWordAny 上按墙钟阻塞（实测 24~32ms/轮，一帧 9 轮
	 * ≈250ms，正好是 4.6fps）。「等对端字就把模拟时钟按停」这件事和角色
	 * 无关：从机的下一轮同样要等主机推进到同一轮才有新字，等它并不会让
	 * 主机变快，只会让两端互相锁死。
	 *
	 * 为什么从机也能复用旧字：旧字只用来填 SIOMULTI 里对端的那个槽位，
	 * 本机这一轮的收发字节流早已由 sioRoundWord 在起轮那一刻扣下来锁存，
	 * 回推给主机的永远是本轮真字；复用只影响对端按键的新鲜度，比空槽
	 * 0xFFFF 安全得多（空槽会直接触发通信错误），风险与主机侧复用旧字
	 * 完全对称。轮次号也照旧不前进 —— 没消费到新字就没有新轮次，所以
	 * 从机不会跑到主机前面把后面的字全判成「过期」丢掉。
	 *
	 * 为什么门必须卡在会话建立之后：LINKUP / 训练家卡片块交换阶段每一轮
	 * 都必须是真实对端字（块校验按轮次逐块比对），复用旧字会把
	 * gBlockReceivedStatus 打回 0、停在「等待连接」。门直接复用
	 * sioFastFrame（gLink state/playerCount/cnt 三者同时 >=2 且 sioOk>=256，
	 * 带 MGBAX_SIO_FAST=0 开关与锁存），不另造判据。
	 *
	 * 中断次数不变：本轮照样只 completeMultiTransfer 一次、按 sioSlavePeriod
	 * 重挂下一次事件，每帧仍是 9 次 SIO 中断（游戏的 LAG 判定按模拟帧算），
	 * 省掉的只是墙钟等待。 */
	/* 【角色不对称的门】从机绝不能用 MGBAX_FAST_MIN_OK 忽略等待：主机是
	 * 「生产字」方，取不到从机字就复用上一轮自己喂给游戏的对端槽，只影响
	 * 按键新鲜度；从机是「消费字」方，块交换期取不到主机字就把 sioFastLast
	 * 当本轮真字喂给 completeMultiTransfer，逐块校验立刻 badChecksum 掉链
	 *（FASTEARLY1 现场：主机 n=64 ls=4 健康，从机 idx 冻结 50、mis=598、
	 * st=0x2249 含 0x2000）。所以从机门固定 256 —— 那时块交换早已结束、
	 * 已进入纯按键交换，复用旧字才安全。 */
	/* ---- 对称定长延迟线（从机侧）：与主机侧同构，消费链也后移 N 轮。
	 *
	 * 与主机唯一的差别是标签来源：从机不自己起轮，它的推送标签由
	 * sioDelayNextPushLabel 的独立计数给出（N==0 时就是 sioIndex），所以
	 * 两端标签空间仍然连续、互不重叠。取不到时同样只重挂、不复用旧字。 */
	if (sioDelayLine(sio)) {
		uint16_t dWant = sio->sioDelayWant;
		uint32_t dRemote = 0;
		uint16_t dGot = 0;
		uint32_t dCycles = 0;
		if (sio->link && netLinkTakePeerWord(sio->link, dWant, 0, &dRemote, &dGot, &dCycles)) {
			sio->sioDelayWaits = 0;
			sio->sioDelayWant = (uint16_t) (dWant + 1);
			if (dGot != dWant) {
				++sio->sioMisorder;
			}
			if (dCycles != 0) {
				if (sio->sioPeerCyclesValid) {
					uint32_t delta = dCycles - sio->sioPeerCycles;
					if (delta > 4000 && delta < 400000) {
						sio->sioSlavePeriod = delta;
					}
				}
				sio->sioPeerCycles = dCycles;
				sio->sioPeerCyclesValid = true;
			}
			uint16_t dOwn = sioSlaveOwnWord(sio);
			sio->sioRoundWordValid = false;
			if (dOwn) {
				sio->sioLastOwn = dOwn;
			} else if (GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN) {
				dOwn = sio->sioLastOwn;  /* 修复② U3：只在握手期回退陈旧字，块期 state>=4 保留合法 0 */
			}
			SIO_CAPTURE_BLOCK_CTX(sio, (struct GBA*) sio->core->board, dOwn);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
			dOwn = sioBlockOutWord(sio, dOwn, true, (struct GBA*) sio->core->board);  /* 方案2：逐字推真块帧 */
			/* 路线A：sioRemote 必须早于 sioSelfSlot，hold 才能读到本轮真对端字
			 *（否则自槽读旧字、data/push 读新字 → checksum 同源破裂）。 */
			sio->sioRemote = dRemote;
			sio->sioSelfSlot = sioWordOrEmpty(sio, dOwn);
			sio->sioHasRemote = true;
			completeMultiTransfer(sio, dRemote, true, cyclesLate);
			struct mTiming* tdSlave = coreTiming(sio);
			uint32_t dStamp = tdSlave ? mTimingCurrentTime(tdSlave) : 0;
			bool dExtra = false;
			uint16_t dLabel = sioSlavePushLabel(sio, &dExtra);
			netLinkPush(sio->link, GBA_SIO_MULTI, sioWordOrEmpty(sio, dOwn), dLabel, dStamp);
			if (dExtra) {
				netLinkPush(sio->link, GBA_SIO_MULTI, sioWordOrEmpty(sio, dOwn),
				            (uint16_t) (dLabel + 1), dStamp);
			}
			sio->sioPushValue = dOwn;
			sio->sioPushIndex = dLabel;
			sio->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
			return;
		}
		++sio->sioDelayWaits;
		if (sio->sioDelayWaits < SIO_DELAY_MAX_WAIT) {
			if (timing) {
				if ((sio->sioDelayWaits & 0x3F) == 1) {
					SIO_LOG("delayline slave wait want=%u q=%d n=%u", (unsigned) dWant,
					        netLinkPeerPending(sio->link), (unsigned) sio->sioDelayWaits);
				}
				mTimingSchedule(timing, &sio->sioSlaveDone, SIO_CONNECT_POLL_CYCLES);
				sio->sioSlaveArmed = true;
				return;
			}
		}
		SIO_LOG("delayline slave fallback want=%u q=%d n=%u", (unsigned) dWant,
		        netLinkPeerPending(sio->link), (unsigned) sio->sioDelayWaits);
		sio->sioDelayWaits = 0;
		sio->sioDelayAnchored = false;
	}
	if (sioFastFrameSlave(sio)) {
		uint32_t fastRemote = 0;
		uint16_t fastGot = 0;
		uint32_t fastCycles = 0;
		bool haveFast = netLinkTakePeerWordAny(sio->link, sio->sioIndex, 0, &fastRemote, &fastGot, &fastCycles);
		if (haveFast) {
			sioCapturePeerParty(fastRemote);   /* ROOTHUNT2：从机快帧主路径解 sidecar */
			sio->sioFastMiss = 0;
			sio->sioFastLast = fastRemote;
			sio->sioFastLastValid = true;
			/* 轮次号仍由主机单方面决定：取到新字就跟随它的轮次号。 */
			if (fastGot != sio->sioIndex) {
				/* 【这个计数器**不是**跳跃判据】从机的 sioIndex 是"上一轮已消费
				 * 的号"，主机的下一个字永远是它 +1，所以只要真取到新字，
				 * got != sioIndex 必然成立 —— mis 约等于「成功轮数」，健康链路上
				 * 也会一路涨。真正的错位要靠 `SIO multi` 行的 idx 与主机对比，
				 * 不要拿 mis 判断丢轮。 */
				++sio->sioMisorder;
			}
			sio->sioIndex = fastGot;
			if (fastCycles != 0) {
				/* 照旧用主机的时钟戳校准本机轮次周期。 */
				if (sio->sioPeerCyclesValid) {
					uint32_t delta = fastCycles - sio->sioPeerCycles;
					if (delta > 4000 && delta < 400000) {
						sio->sioSlavePeriod = delta;
					}
				}
				sio->sioPeerCycles = fastCycles;
				sio->sioPeerCyclesValid = true;
			}
		} else {
			/* 【2026-11-16 20:0x 与主机侧同一条修正】没拿到新字时**不许**
			 * 复用 sioFastLast 把这一轮"完成"掉：没有消耗对端的字却让
			 * sendCmdIndex/recvCmdIndex 前进一格，两端 8 字命令窗口与校验和
			 * 窗口立刻错位。这里只记数，然后落到下面的严格等待路径。 */
			++sio->sioFastMiss;
			++sio->sioFallback;
			/* CMD-GUARD：块交换期（state>=4 且 rem==0）本轮无真字时严禁复用
			 * sioFastLast —— 这里本来就落回严格路径，记数供 diag 证明门生效。 */
			if (sioInCmdPhase(sio)) {
				++sio->sioCmdGuardRounds;
				++s_sioCmdGuard;
			}
			/* 连续 240 轮（约 27 帧）一个新字都没拿到 ⇒ 对端停摆：与主机侧
			 *（sioDoneEvent 的 fast miss 分支）一样解除锁存，下一轮回到严格
			 * 等待。原实现把这段误放进 `if (haveFast)`（条件恒真又不判 miss）
			 * 成了死代码，永远不解锁。 */
			if (sio->sioFastMiss >= 240) {
				sio->sioFastLatched = false;
				sio->sioFastMiss = 0;
			}
			if ((sio->sioFastMiss & 0x3F) == 0) {
				/* machine-readable：本机已消费 idx vs 链路层最近一次主机发布的
				 * idx。gap 大 ⇒ 两端没对齐，块交换期复用旧字会 badChecksum。 */
				unsigned hostIdx = sioHostPubIndex(sio);
				unsigned sIdx = (unsigned) sio->sioIndex;
				unsigned gap = hostIdx > sIdx ? hostIdx - sIdx : sIdx - hostIdx;
				SIO_LOG("slave fastframe miss n=%u idx=%u ok=%u q=%d state=%d period=%u peerCycles=%u valid=%d hostidx=%u gap=%u",
				        (unsigned) sio->sioFastMiss, sIdx,
				        (unsigned) sio->sioOk,
				        netLinkPeerPending(sio->link), netLinkState(sio->link),
				        (unsigned) sio->sioSlavePeriod, (unsigned) sio->sioPeerCycles,
				        sio->sioPeerCyclesValid ? 1 : 0,
				        hostIdx, gap);
			}
		}
		if (haveFast) {
			uint16_t own = sioSlaveOwnWord(sio);
			sio->sioRoundWordValid = false;
			if (own) {
				sio->sioLastOwn = own;
			} else if (GBAView8(((struct GBA*) sio->core->board)->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
				own = sio->sioLastOwn;   /* 只有握手期才把 0 当空槽 */
			}
			SIO_CAPTURE_BLOCK_CTX(sio, (struct GBA*) sio->core->board, own);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
			own = sioBlockOutWord(sio, own, true, (struct GBA*) sio->core->board);  /* 方案2：逐字推真块帧 */
			/* 路线A：sioRemote 早于 sioSelfSlot，保持判据与自槽/push 同源。 */
			sio->sioRemote = (uint16_t) (fastRemote & 0xFFFFu);
			sio->sioSelfSlot = sioWordOrEmpty(sio, own);
			sio->sioHasRemote = true;
			completeMultiTransfer(sio, fastRemote, true, cyclesLate);
			/* 本轮自己的字照旧回推，轮次号用（可能没变的）sioIndex：
			 * 主机严格匹配，重复轮次会被它当过期丢掉，不会错位。 */
			struct mTiming* timingFast = coreTiming(sio);
			uint32_t stampFast = timingFast ? mTimingCurrentTime(timingFast) : 0;
			bool fastExtra = false;
			uint16_t fastLabel = sioSlavePushLabel(sio, &fastExtra);
			netLinkPush(sio->link, GBA_SIO_MULTI, sioOutboundPayload(sio, sioWordOrEmpty(sio, own)),
			            fastLabel, stampFast);
			if (fastExtra) {
				netLinkPush(sio->link, GBA_SIO_MULTI, sioWordOrEmpty(sio, own),
				            (uint16_t) (fastLabel + 1), stampFast);
			}
			sio->sioPushValue = own;
			sio->sioPushIndex = fastLabel;
			sio->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
			return;
		}
		/* 会话建立后一个真实对端字都还没拿到：不拿 0 喂游戏，落回下面的
		 * 阻塞路径（行为与改动前一致）。 */
	}
	uint16_t got = 0;
	uint32_t remote = 0;
	uint32_t peerCycles = 0;
	/* Take the earliest unconsumed word (loose entry). Across a tunnel the
	 * master's next push is a round trip away; while a battle/trade exchange
	 * is actively flowing (the master's pushes arriving every couple hundred
	 * ms), BLOCK the emulated clock for the wait - otherwise the slave's game
	 * VBlanks hundreds of times per master round, the per-frame round counts
	 * collapse below the game's 9-per-frame requirement and the game reports
	 * a connection error at the start of every battle/trade. Outside an
	 * active exchange keep the historical non-blocking spin so an idle link
	 * never drags the game's frame rate down. */
	int waitMs = sioPipelineWaitMs(sio, -1);
	bool have;
	if (sioConnectPollOn(sio)) {
		/* 握手期：先非阻塞取一次；取不到就重新调度并返回，让模拟时间继续
		 * 走（runLoop / VBlank 不再被墙钟冻结），预算用完才落回阻塞等待。
		 * 与主机侧 sioDoneEvent 同构，见 sioConnectPollOn 注释。 */
		have = netLinkTakePeerWordAny(sio->link, sio->sioIndex, 0, &remote, &got, &peerCycles);
		if (have) {
			++sio->sioConnectHits;
			sio->sioConnectSince = 0;
		} else {
			uint32_t now = wallNowMs();
			if (sio->sioConnectSince == 0) {
				sio->sioConnectSince = now;
			}
			if (timing && (uint32_t) (now - sio->sioConnectSince) < SIO_CONNECT_BUDGET_MS) {
				++sio->sioConnectPolls;
				mTimingSchedule(timing, &sio->sioSlaveDone, SIO_CONNECT_POLL_CYCLES);
				sio->sioSlaveArmed = true;
				return;   /* 本轮未完成，等下一次轮询 */
			}
			++sio->sioConnectFallback;
			have = netLinkTakePeerWordAny(sio->link, sio->sioIndex, waitMs, &remote, &got, &peerCycles);
			if (have) {
				sio->sioConnectSince = 0;
			}
		}
	} else {
		have = netLinkTakePeerWordAny(sio->link, sio->sioIndex, waitMs, &remote, &got, &peerCycles);
	}
	{
		if (have) {
			sioCapturePeerParty(remote);   /* ROOTHUNT2：从机 sioSlaveDone 三路径汇合点解 sidecar */
		}
		static unsigned tnzN;
		if (rhVerbose() && have && (uint16_t) remote != 0u && tnzN < 120) {
			++tnzN;
			SIO_LOG("[RHTAKENZ] n=%u me=%d want=%u got=%u word=%04X pq=%d state=%u",
			        (unsigned) sio->sioOk, netLinkPlayer(sio->link), (unsigned) sio->sioIndex,
			        (unsigned) got, (unsigned) (uint16_t) remote,
			        netLinkPeerPending(sio->link),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF));
		}
	}
	if (rhVerbose() && (sio->sioOk <= 40 || (sio->sioOk % 256) == 0)) {
		unsigned stale = 0, drops = 0, po = 0, pe = 0, pi = 0;
		netLinkPeerStats(sio->link, &stale, &drops);
		netLinkWireStats(sio->link, &po, &pe, &pi, NULL, NULL);
		SIO_LOG("[RHTAKE] n=%u me=%d want=%u have=%d got=%u word=%04X pq=%d stale=%u drop=%u pushO=%u pushI=%u state=%u",
		        (unsigned) sio->sioOk, netLinkPlayer(sio->link), (unsigned) sio->sioIndex,
		        have ? 1 : 0, (unsigned) got, (unsigned) (uint16_t) remote,
		        netLinkPeerPending(sio->link), stale, drops, po, pi,
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF));
	}
	if (!have) {
		/* A slave never finishes without peer data: on real hardware the
		 * round simply does not end until the host's clock touches it.
		 * Finishing early would feed the game an empty slot and desync both
		 * round counters. */
		++sio->sioTimeouts;
		/* 空转速率：只统计，不改行为。安卓侧 mgba_mobile.c:3149-3153 在
		 * peerQ 空且 800ms 没收到 PUSH 时会把事件链熄灭；Qt 侧没有，这里先
		 * 把「每秒多少次 miss」量出来，确认是不是 0.12ms 级空转，再决定
		 * 要不要补同样的熄火保护 —— 一次只动一个变量。 */
		++sio->sioMissCount;
		{
			uint32_t nowWall = wallNowMs();
			if (sio->sioMissRateAt == 0) {
				sio->sioMissRateAt = nowWall;
				sio->sioMissRatePrev = sio->sioMissCount;
			} else if ((uint32_t) (nowWall - sio->sioMissRateAt) >= 1000u) {
				uint32_t n = sio->sioMissCount - sio->sioMissRatePrev;
				uint32_t dt = nowWall - sio->sioMissRateAt;
				SIO_LOG("slave miss-rate n=%u/%ums idx=%u q=%d state=%d",
				        (unsigned) n, (unsigned) dt, (unsigned) sio->sioIndex,
				        netLinkPeerPending(sio->link), netLinkState(sio->link));
				sio->sioMissRatePrev = sio->sioMissCount;
				sio->sioMissRateAt = nowWall;
			}
		}
		if ((sio->sioTimeouts & 0xFF) == 0) {
			int qCount = 0;
			unsigned qHead = 0;
			netLinkPeerHeadInfo(sio->link, &qCount, &qHead);
			/* 一次把三种情形摊开：没发（pushOut 不涨）、没收到（pushIn 不
			 * 涨）、收到被判旧字丢掉（stale 涨）。q 只是取样瞬间的队列长度。 */
			uint32_t stale = 0;
			uint32_t drops = 0;
			uint32_t pushOut = 0;
			uint32_t pushErr = 0;
			uint32_t pushIn = 0;
			netLinkPeerStats(sio->link, &stale, &drops);
			netLinkWireStats(sio->link, &pushOut, &pushErr, &pushIn, NULL, NULL);
			/* timing 可能为 NULL（事件被以空 timing 调用时），这里与下面
			 * :899 的调度分支保持一致：解引用前先判空，否则
			 * mTimingCurrentTime(NULL) 会空指针解引用。 */
			if (timing) {
				SIO_LOG("slave miss t=%u link=%p role=%d idx=%u q=%d head=%u state=%d mode=%d stale=%u drop=%u pushOut=%u/%u pushIn=%u age=%ums",
				        (unsigned) mTimingCurrentTime(timing), (void*) sio->link,
				        netLinkPlayer(sio->link), (unsigned) sio->sioIndex, qCount, qHead,
				        netLinkState(sio->link), (int) gba->sio.mode,
				        (unsigned) stale, (unsigned) drops,
				        (unsigned) pushOut, (unsigned) pushErr, (unsigned) pushIn,
				        (unsigned) netLinkPushAgeMs(sio->link));
			}
		}
		sioSlaveSkip(sio, 9);
		if (timing) {
			/* 【ROOTHUNT 迭代 7】cmd 期(state>=4)取不到对端字时，原来固定
			 * 2048 周期重挂会让从机轮次钟跑得比主机 TM3 链(~18363)快 9 倍
			 * ⇒ 实测从机 idx 比主机领先 64 轮、rem 永远 0。这里改用主机
			 * 真实轮次周期对齐；握手期(<4)仍用 2048 保证响应。 */
			uint32_t retry = (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u
			                  && sio->sioPeerCyclesValid)
			                 ? sio->sioSlavePeriod : 2048;
			mTimingSchedule(timing, &sio->sioSlaveDone, retry);
			sio->sioSlaveArmed = true;
		}
		return;
	}
	if (peerCycles != 0) {
		/* Track the host's true round period from its timestamps; the slave
		 * schedules its rounds at the same period so per-frame round counts
		 * match. */
		if (sio->sioPeerCyclesValid) {
			uint32_t delta = peerCycles - sio->sioPeerCycles;
			if (delta > 4000 && delta < 400000) {
				sio->sioSlavePeriod = delta;
			}
		}
		sio->sioPeerCycles = peerCycles;
		sio->sioPeerCyclesValid = true;
	}
	uint16_t own = sioSlaveOwnWord(sio);
	/* 【13:55 从机握手字兜底】握手期(state<4)若本轮没捕获到 sioRoundWord，
	 * 直接读 SIOMLT_SEND 当前值（游戏写的就是本轮该发的 B9A0）；DIAG1 现场
	 * 从机 sioRoundWordValid 恒 false、own=sioLastOwn=0 ⇒ 推 FFFF ⇒ 主机
	 * data[1]=FFFF、pc 恒 1。块交换期(state>=4)仍用 sioLastOwn，不读实时，
	 * 避免下一轮字错位。 */
	if (!sio->sioRoundWordValid
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		uint16_t regWord = gba->memory.io[GBA_REG(SIOMLT_SEND)];
		if (regWord) {
			own = regWord;
		}
	}
	sio->sioRoundWordValid = false;
	/* 沿用上一个有效字，别把 0xFFFF 当空槽推出去（见 sioLastOwn 的注释）。
	 * state>=4 之后 0 是合法命令字（DoSend 空队列写 0），必须原样送出去。 */
	if (own) {
		sio->sioLastOwn = own;
	} else if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < 4u) {
		own = sio->sioLastOwn;
	}
	SIO_CAPTURE_BLOCK_CTX(sio, (struct GBA*) sio->core->board, own);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
	own = sioBlockOutWord(sio, own, true, (struct GBA*) sio->core->board);  /* 方案2：逐字推真块帧 */
	/* 路线A：sioRemote 早于 sioSelfSlot，保持判据与自槽/push 同源（阻塞路径）。 */
	sio->sioRemote = (uint16_t) (remote & 0xFFFFu);
	sio->sioSelfSlot = sioWordOrEmpty(sio, own);
	if (got != sio->sioIndex) {
		/* Round jump (host skipped rounds, or the slave just joined): adopt
		 * the host's number, the pairing stays one-to-one. */
		/* 【mis 不是跳跃判据】从机 sioIndex 存的是上一轮已消费号，主机的
		 * 下一轮永远是 +1，因此每一轮成功取字都会 +1 到这里 —— 健康链路
		 * 上 mis ≈ 成功轮数。要判断错位只能比两端的 idx。 */
		++sio->sioMisorder;
	}
	sio->sioIndex = got;
	sio->sioRoundLabel = got;
	sio->sioHasRemote = true;
	/* 【必须早于 completeMultiTransfer】SerialCB 在 finishMultiTransfer 里跑，
	 * 索引一旦晚一拍写就来不及了（TR35 的 SYNCIDX 一个都没生效就是这个坑）。 */
	sioFollowSyncIdx(sio, remote);
	/* 路线A：sioRemote 已在本轮早段（sioSelfSlot 之前）写入，此处不再重复置位。 */
	completeMultiTransfer(sio, remote, true, cyclesLate);
	/* Push this round's own word back, tagged with the host's round number:
	 * the host's strict (want == got) matching then always lines up. */
	struct mTiming* timing2 = coreTiming(sio);
	uint32_t stamp = timing2 ? mTimingCurrentTime(timing2) : 0;
	bool strictExtra = false;
	uint16_t strictLabel = sioSlavePushLabel(sio, &strictExtra);
	netLinkPush(sio->link, GBA_SIO_MULTI, sioOutboundPayload(sio, sioWordOrEmpty(sio, own)),
		            strictLabel, stamp);
	if (strictExtra) {
		netLinkPush(sio->link, GBA_SIO_MULTI, sioOutboundPayload(sio, sioWordOrEmpty(sio, own)),
		            (uint16_t) (strictLabel + 1), stamp);
	}
	sio->sioPushValue = own;
	sio->sioPushIndex = strictLabel;
	sio->sioPushed = true;
	/* Arm the next round: exactly K emulated cycles later. */
	if (timing) {
		mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
		sio->sioSlaveArmed = true;
	}
}

/**
 * Master-side "transfer due" event: the peer's reply is fetched with a
 * bounded real-time wait (the emulated clock freezes while waiting, so a
 * frame still hosts real-machine-scale transfer counts). A timeout finishes
 * with empty slots - never with a stale value from the previous round, which
 * is exactly what corrupted checksums in earlier attempts.
 */
/* 跨网等待窗：局域网 RTT 1-3ms，800ms 绰绰有余；走服务器隧道 RTT 上百毫秒
 * 还会抖（手机网络尖峰能到秒级），固定 800ms 必然误超时——超时一次就用空槽
 * 收尾，游戏立刻报「连接发生了错误」。等待窗跟随实测 RTT（20 倍余量），
 * 下限仍是局域网的 800ms，上限 20s 防死等。等待期间模拟时钟冻结，游戏自己
 * 不会超时，只是这一轮变慢。 */
/* 本轮到底允不允许阻塞模拟线程（与安卓侧 sioPeerWaitMs 同一条判据）。
 *
 * 隧道连着（state==2）不等于对端在跑联机：对端停在开机/标题画面时一个字都
 * 不推，这边若照 sioWaitMs（RTT×20，实测能到 3s）死等，模拟线程就被按在
 * 超时窗里，整帧不动——安卓侧就是这么假死掉的，PC 侧在握手期同样会 0.7fps。
 *   - 队列里有对端字   → 最多 400ms（实际就是取队列）
 *   - 对端 800ms 内推过 → 最多 400ms（覆盖 150ms 级 RTT 的晚到）
 *   - 对端完全没动静   → 0，立刻用空槽收尾
 */
static int sioPeerWaitMs(struct SioLink* sio) {
	if (!sio->link || netLinkState(sio->link) != 2) {
		return 0;
	}
	if (netLinkBusActive(sio->link)) {
		/* 星型总线只跑局域网/本机环回。两人跨公网隧道的 300~1200ms 下限会
		 * 把每轮锁步钉在半秒以上：轮次一旦错配，主机等从机字、从机等广播，
		 * 两边都等满窗 —— busgame 实测从机 45s 只推进 312 帧（6.9fps）、
		 * cnt 恒 0。给 3 倍实测 RTT，下限 2ms（本机环回 RTT≈0.1ms，原 12ms
		 * 下限让每个落后轮次都付满 12ms，9 轮/帧把帧率压到约 5fps、永远到
		 * 不了游戏侧 MULTI）、上限 120ms；字到达时 cond_broadcast 仍会立刻
		 * 唤醒，所以本机环回几乎零等待，LAN（RTT≥3ms×3≈9~12ms）行为不变。 */
		uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
		if (ms < 2u) {
			ms = 2u;
		}
		if (ms > 120u) {
			ms = 120u;
		}
		return (int) ms;
	}
	if (netLinkPeerPending(sio->link) > 0) {
		return 1200;
	}
	if (netLinkPushAgeMs(sio->link) < 800) {
		return 900;
	}
	/* 链路刚建立的前几轮，对端一个字都还没推过：pushSeenAt=0 →
	 * netLinkPushAgeMs 返回极大值，上面两条都不命中，这里就会返回 0。
	 * 可这恰恰是最需要等一个 RTT 的时刻——主机已经把本轮字推出去了，
	 * 从机的回字还在隧道上（实测 RTT 231ms）。零等待配上 100 cycles
	 * 的重试间隔，27 次重试在不到 1ms 内耗尽，主机按空槽收尾；等从机
	 * 字到达时已经没人取了。现场证据：PC 只收到 PUSH #1、安卓只有
	 * HSP #1，两端 ST 在 0/1 之间反复，done want=1 retries=27。
	 * 给前 8 轮、且只在头 3 次重试里开 900ms 预算（避免 40×900ms 的
	 * 新假死）；之后仍无对端字说明它根本没进联机，恢复 0。 */
	if (sio->sioWaiting && sio->sioIndex <= 8 && sio->sioRetries < 3) {
		return 900;
	}
	/* 隧道往返 82~231ms 且抖动明显，对端 PUSH 的到达间隔会间歇超过 800ms。
	 * 此时若返回 0，40 次重试（间隔仅 100 cycles）会在极短时间内耗尽并按
	 * 空槽收尾，把玩家数据块的校验搅坏 —— 隧道轮实测 brs=0000/0000、
	 * cnt 恒 0、LINKUP 停在「等待连接…」，而直连 12ms 轮能跑 4416 轮零超时。
	 * 只要游戏确实发起了本轮 MULTI 传输（sioWaiting）且链路还连着，就给
	 * 一个跟随实测 RTT 的最小预算（300~1200ms）。链路断开或游戏没在传
	 * MULTI 时仍是 0，不会重现 11-08 那种整帧假死。 */
	if (sio->sioWaiting) {
		uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
		if (ms < 300u) {
			ms = 300u;
		}
		if (ms > 1200u) {
			ms = 1200u;
		}
		return (int) ms;
	}
	return 0;
}

static bool sioForceHandshake(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_LINK_FORCEHS");
		enabled = (v && atoi(v) == 0) ? 0 : 1;
	}
	return enabled != 0;
}

static int sioWaitMs(struct SioLink* sio) {
	uint32_t rttUs = sio->link ? netLinkRttUs(sio->link) : 0;
	uint32_t ms = (rttUs / 1000u) * 20u;
	if (ms < 800) {
		ms = 800;
	}
	if (ms > 20000) {
		ms = 20000;
	}
	return (int) ms;
}

/* 按帧流水线（默认关闭）：队列里已有对端字就零等待消费，一帧 9 轮只付
 * 一次网络往返；队列空时才给一次整批预算（跟随实测 RTT）。字仍按轮次
 * 严格配对，不用陈旧字补槽，LINKUP 的块校验不受影响。 */
static bool sioPipelineMode(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_SIO_PIPELINE");
		/* 默认**关**（只有显式 =1 才开）。11-16 01:40 单变量对照（同一枚
		 * 二进制、只改这个变量）证明它虽然把锁存前 256 轮从 32s 压到 4.2s
		 * （5.9→45.6 轮/s），但同时把真实 `Link RTT` 从 5.3ms 炸到 54ms
		 * （峰值 570ms）、lstate=4 从「能保持」退化成「<200ms 闪过」、
		 * 终态出现 linkup=255。这是「加速了计数器、拖垮了链路」，不是解。
		 * 11-08 那次它能破局是在隧道 82ms 场景，与当前 5ms 局域网不同，
		 * 不能据此设为默认。 */
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	return enabled != 0;
}

static int sioPipelineWaitMs(struct SioLink* sio, int want) {
	/* 总线不受两人按帧流水线开关影响，始终用局域网短窗。 */
	if (sio->link && netLinkBusActive(sio->link)) {
		return sioPeerWaitMs(sio);
	}
	if (!sioPipelineMode()) {
		return sioPeerWaitMs(sio);
	}
	if (!sio->link || netLinkState(sio->link) != 2) {
		return 0;
	}
	if (netLinkPeerPending(sio->link) > 0) {
		/* 队列非空不等于**本轮**的字已经到：按帧流水线一帧批量到达时队首
		 * 常常是后续轮次。只有队首正是本轮才零等待消费，否则照样得等
		 * 本轮的字（交给 takePeerWord 自己判，等待窗按 RTT 给）。 */
		if (want < 0) {
			return 0;
		}
		int qCount = 0;
		unsigned qHead = 0;
		netLinkPeerHeadInfo(sio->link, &qCount, &qHead);
		if (qCount > 0 && (int) qHead == want) {
			return 0;
		}
	}
	uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
	if (ms < 500u) {
		ms = 500u;
	}
	if (ms > 4000u) {
		ms = 4000u;
	}
	return (int) ms;
}

/* 联机帧率：握手/卡片交换完成后不再按墙钟等对端字。
 *
 * 实测 3.7fps 的成因不是网络：P2P 直连 RTT 只有 6~13ms，但每帧 9 轮
 * MULTI 传输，每轮 sioDoneEvent 都在 takePeerWord 上冻结模拟时钟
 * （SIO_LOG 统计 wait=24~32ms/轮 n=64），9×28ms≈250ms，正好一帧 270ms。
 * 两端都在等对方推进下一帧，形成一个互相拖住的锁步环。
 *
 * 这里在链路健康时改成「零等待取本轮字，取不到就复用上一轮对端字」：
 * 模拟时钟不再被墙钟按停，每帧仍然是 9 次 SIO 中断（游戏 LAG 判定按
 * 模拟帧计数，不按墙钟），帧率回到接近单机；复用字只影响对端按键的
 * 新鲜度，比空槽 0xFFFF 安全得多（空槽会直接触发通信错误）。
 *   - 前 256 轮（LINKUP / 训练家卡片块交换）保持严格等待，避免块校验坏掉
 *   - 会话判据用 gLink.state + playerCount + 玩家数三者同时满足，不看 RTT
 *   - MGBAX_SIO_FAST=0 可整体关掉这次优化，便于 A/B 对照
 */
/**
 * 快帧门的**纯判据**：会话是否真的建立。
 *
 * 抽成纯函数是为了能被 `test-gboylink --fastgate` 直接断言 —— 这道门此前
 * 全靠实跑观察（「11-15 实测两端 LINKUP 了但 PC 仍 4.9fps」那种），
 * 改一次阈值就没人能保证没把「握手期」放进快帧，而握手期一复用旧字就会
 * 把 gBlockReceivedStatus 打回 0、停在「等待连接」。规则只有四条：
 *   1. `MGBAX_SIO_FAST=0` 关掉时一律不放行；
 *   2. 至少 256 轮真实传输之后才允许（sioOk 计数，避免开局就把首字复用）；
 *   3. gLink.state 必须 >= 4（LINKUP 完成），且 playerCount >= 2；
 *   4. 由调用方负责锁存与链路断开时解锁（状态机不在这个函数里）。
 *
 * 【为什么是 state>=4 而不是 >=2】state=2 只是 HANDSHAKE 开始，块交换还没
 * 做完。门放在 2 时实跑日志里出现过 `fastframe latch without fieldCount
 * lstate=2 pc=2` —— 握手期就锁存，之后主机零等待取字、取不到就复用上一轮
 * 的 sioRemote（fb=60 就是这么来的），正是本文件注释里警告过的「陈旧字把
 * gBlockReceivedStatus 打回 0」。state 4 才是 LINKUP 完成的那个状态
 * （历史成功轮：lstate=4 pc=2）。
 */
bool sioFastGateReadyEx(bool disabled, uint32_t ok, unsigned gLinkState, unsigned gLinkPlayerCount, uint32_t minOk) {
	if (disabled) {
		return false;
	}
	if (ok < minOk) {
		return false;
	}
	if (gLinkState < 4 || gLinkPlayerCount < 2) {
		return false;
	}
	return true;
}

bool sioFastGateReady(bool disabled, uint32_t ok, unsigned gLinkState, unsigned gLinkPlayerCount) {
	return sioFastGateReadyEx(disabled, ok, gLinkState, gLinkPlayerCount, 256);
}

/* ===== 档1 A 预测回滚本体（PC 侧；与 sioFastGateReadyEx 并列互斥、不互推）=====
 * 红线：所有函数只读游戏态，绝不写 party/信任位/brs/rem/nr/st/gLinkOpen；
 * 投机字只作为 completeMultiTransfer 的 remote 入参，落 data[peer] 后立即由
 * 写径门拦截控制字。门 MGBAX_ROLLBACK_ENABLE=0 时全段被编译器消解、零回归。 */

/* 运行时独立门（默认 0）；env=1 或 sioRollbackSet(true) 任一开启，
 * 对偶 mobile 的 enabled||s_rollbackEnabled；不读也不修改 sioFastFrame 的门。 */
static bool sioPredRollbackReady(const struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv(MGBAX_ROLLBACK_ENV);
		enabled = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (!MGBAX_ROLLBACK_ENABLE || !(enabled || s_sioRollbackEnabled) || !sio) { return false; }
	return true;
}

#if MGBAX_ROLLBACK_ENABLE
/* diag 只读：sp0（NETGATE 64B 内定点偏移）+ brs（gBlockReceivedStatus）。
 * 任一守卫失败即 false（fail-closed，绝不进硬门）。 */
static bool sioPredReadSp0Brs(struct SioLink* sio, uint16_t* sp0, uint16_t* brs) {
	struct GBA* gba;
	uint32_t diag = (uint32_t) GNP_DIAG_EW;
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) { return false; }
	gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu || !gnpAbsEwOk(diag, GNP_NG_DIAG_SIZE)) { return false; }
	*sp0 = (uint16_t) ((uint16_t) GBAView8(gba->cpu, diag + GNP_OFF_NG_SP0)
	                 | ((uint16_t) GBAView8(gba->cpu, diag + GNP_OFF_NG_SP0 + 1u) << 8));
	*brs = GBAView16(gba->cpu, SIO_IW(SIO_GLOBAL_BLK_RECV_STATUS));
	return true;
}

/* 有状态字构造：只产出 SIO 投递字候选，不写游戏态。
 * 父会话方案 i：握手字/opcode(2222/2233/BBBB/8888/5FFF)/块字一律 speculative=0；
 * 仅 SEQ_INDEX 分支用起轮自槽真字作「末字保持」候选，且仍要过 gnpPredWordForbidden。 */
static int sioPredictWord(const struct SioLink* sio, const MgbaxPredictIn* in, MgbaxPredictOut* out) {
	out->word = 0u;
	out->conf = GNP_CONF_LOW;
	out->speculative = 0;
	if (!in || !sio || !sioPredRollbackReady(sio)) { return 0; }
	if (in->phase == GNP_PHASE_HANDSHAKE || in->phase == GNP_PHASE_CMD_HEADER
	    || in->phase == GNP_PHASE_SEQ_INDEX) {
		out->conf = GNP_CONF_HIGH;
	}
	if (!gnpPredConfAllows(out->conf)) { out->conf = GNP_CONF_LOW; return 0; }
	if (in->phase == GNP_PHASE_HANDSHAKE) {
		/* 握手字触发 maybeRearmHandshake/RHSLVINJ 写真握手字（写径），方案 i 禁投机。 */
		return 0;
	}
	if (in->phase == GNP_PHASE_CMD_HEADER) {
		/* opcode 触发 sioAlignCmdFrameHeader 写 sc/rc（写径），方案 i 禁投机。 */
		return 0;
	}
	if (in->phase == GNP_PHASE_SEQ_INDEX) {
		out->word = in->ownWord;                 /* 真来源：起轮自槽，非造字 */
		if (gnpPredWordForbidden(out->word)) { out->word = 0u; return 0; }
		out->speculative = 1;
	}
	return out->speculative;
}

/* 投机字登记入环形影子账本（与 sioRemote/sioPeerHist 物理分离）。 */
static void sioPredictShadowPut(struct SioLink* sio, uint32_t seq, uint8_t sc,
                                const MgbaxPredictOut* out, uint16_t ownWord) {
	MgbaxPredSlot* s = &sio->sioPredShadow[sio->sioPredHead & MGBAX_PRED_IDX_MASK];
	s->word = out->word;
	s->ownWord = ownWord;
	s->sc = sc;
	s->state = 1u;                               /* PREDICTED */
	s->seq = seq;
	s->wallMs = wallNowMs();
	++sio->sioPredHead;
}

/* 真字到达时核对：一致→CONFIRMED（只做账本迁移，不改 live 字）；分歧→ROLLED+计数，
 * 交回滚引擎（sio NgHist 只保留 CONFIRMED 供重放，predicted 永不注入）。 */
static void sioPredictConfirm(struct SioLink* sio, uint32_t seq, uint16_t realWord,
                              int* mismatch, uint32_t* mismatchSeq) {
	uint32_t i;
	if (!sio) { return; }
	if (mismatch) { *mismatch = 0; }
	if (mismatchSeq) { *mismatchSeq = 0; }
	for (i = 0u; i < MGBAX_PREDICT_HISTORY; ++i) {
		MgbaxPredSlot* s = &sio->sioPredShadow[i];
		if (s->state != 1u || s->seq != seq) { continue; }
		if ((uint16_t) (s->word & MGBAX_PREDICT_MASK) ==
		    (uint16_t) (realWord & MGBAX_PREDICT_MASK)) {
			s->state = 2u;                       /* CONFIRMED（仅账本标签） */
			++sio->sioPredConfirmed;
		} else {
			s->state = 3u;                       /* ROLLED */
			++sio->sioPredMismatch;
			sio->sioPredMismatchSeq = seq;
			if (mismatch) { *mismatch = 1; }
			if (mismatchSeq) { *mismatchSeq = seq; }
		}
	}
}

/* 相位硬门：取齐只读现场后交共享头纯数值核。sp0/brs 读不到即 fail-closed。 */
static bool sioPredHardGate(struct SioLink* sio, const MgbaxPredictIn* in,
                            const MgbaxPredictOut* out) {
	uint16_t sp0 = 0u, brs = 0u;
	int isBlockW, isHsW;
	if (!out || !out->speculative || !sioPredRollbackReady(sio)) { return false; }
	if (!sioPredReadSp0Brs(sio, &sp0, &brs)) { return false; }
	isBlockW = sioIsBlockWord(in->peerPrev) || sioIsBlockWord(in->ownWord);
	isHsW    = sioIsHandshakeWord(in->peerPrev);
	return gnpPredHardGatePure(1, out->conf, in->phase, in->st, in->sc, sp0, brs,
	        sioInCmdPhase(sio) ? 1 : 0,
	        (battleRelayOn() && inBattleBlockRelay(sio)) ? 1 : 0,
	        isBlockW, isHsW, gnpPredWordForbidden(out->word) ? 1 : 0) != 0;
}

/* 唯一投机投递口：置写径拦截标记 → 走原有 completeMultiTransfer → 清标记。
 * 保持 completeMultiTransfer 本体与 SerialCB 唯一投递口语义不变。 */
static void sioCompletePredictedTransfer(struct SioLink* sio, uint16_t word,
                                         uint32_t cyclesLate) {
	sio->sioRemoteIsPredicted = true;
	completeMultiTransfer(sio, (uint32_t) word, true, cyclesLate);
	sio->sioRemoteIsPredicted = false;
}

/* diag 保真：稳态采样只收「确认+CLOSED+PARTY」，seq 严格增、tag_ok 只 sticky。
 * 回滚层只读本 latch，不据标签升门。 */
static void sioNgLatchSample(struct SioLink* sio, const uint8_t* diag) {
	struct NgLatch* L = &sio->sioNgLatch;
	uint32_t seq = gnpNgRead32(diag + GNP_OFF_NG_SEQ);
	uint32_t digest = gnpNgRead32(diag + GNP_OFF_NG_RX_DIGEST);
	if (diag[GNP_OFF_NG_STATE] != GNP_NG_STATE_CLOSED
	    || diag[GNP_OFF_NG_MSG_TYPE] != GNP_NG_MSG_PARTY) { return; }
	if (!gnpNgSampleOk(L, seq, digest)) { return; }
	memcpy(L->diag, diag, GNP_NG_DIAG_SIZE);
	L->seq = seq;
	L->digestAtSeq = digest;
	if (diag[GNP_OFF_NG_TAG_OK]) { L->tagOkSticky = 1; }   /* 只 0->1，禁 1->0 */
	L->valid = 1;
}

#if MGBAX_ROLLBACK_ENABLE && MGBAX_PRED_SELFTEST
/* ===== 档1 B 有状态预测回滚本体运行时自测探针（默认关，双门裹）=====
 * 直驱上面四个真实静态本体：sioPredictWord / sioPredictShadowPut /
 * sioPredictConfirm / sioNgLatchSample，栈上 mock struct SioLink（memset 零），
 * 借 sioRollbackSet(true) 绕开 sioPredRollbackReady 的 getenv 静态缓存（退出恢复原值）。
 *
 * 诚实边界（Q1 §1/§5）：不直调 sioPredHardGate（依赖 live gba->cpu）与
 * sioCompletePredictedTransfer（写游戏态）；硬门用 gnpPredHardGatePure 注入合成
 * sp0=0/brs=0 与同款 flag 提取；"权威态"用纯 FNV-1a 摘要（非真 savestate 回滚）。
 * 字流纯控制字白名单（pred_word_is_control 自检），预测字绝不落 gEnemyParty/信任位；
 * diag 保真只写 mock 的定点快照区（sioNgLatchSample），属灰区写快照、非 live/checker。
 * 本探针 PASS 仅证机制工程可行，不出 tag_ok=1、不产 CROSSED、不升任何门。 */
#define GNP_SELFTEST_FNV_OFFSET  UINT32_C(0x811C9DC5)
#define GNP_SELFTEST_FNV_PRIME   UINT32_C(0x01000193)

/* FNV-1a：按 uint16 字的低字节、高字节顺序喂入（确定性，等价桩 state_digest 的规范化）。 */
static uint32_t gnpSelftestFnvFeed(uint32_t h, uint16_t w) {
	h ^= (uint32_t) (uint8_t) (w & 0xFFu);  h *= GNP_SELFTEST_FNV_PRIME;
	h ^= (uint32_t) (uint8_t) (w >> 8);     h *= GNP_SELFTEST_FNV_PRIME;
	return h;
}

/* 真字流 = master_word（仿 sio_cmd_sim.py:368）：t=0..7 控制字、t=8 校验和、其余 0。 */
static uint16_t gnpSelftestTrueWord(uint32_t t) {
	static const uint16_t tbl[8] = {
		LINKCMD_SEND_LINK_TYPE, LINKCMD_SEND_LINK_TYPE_EX,
		0u, 0u, 0u, 0u, 0u, 0u
	};
	if (t < 8u) { return tbl[t]; }
	if (t == 8u) { return (uint16_t) (LINKCMD_SEND_LINK_TYPE + LINKCMD_SEND_LINK_TYPE_EX); }
	return 0u;
}

/* 分歧字 = 另一个合法控制字（_PRED_DIVERGE_SUB），保证分歧字仍过红线（绝不造 party 数据）。 */
static uint16_t gnpSelftestPredWord(uint32_t t, uint32_t divergeAt) {
	uint16_t w = gnpSelftestTrueWord(t);
	if (divergeAt != UINT32_C(0xFFFFFFFF) && t == divergeAt) {
		if (w == LINKCMD_SEND_LINK_TYPE)     { return LINKCMD_INIT_BLOCK; }
		if (w == LINKCMD_SEND_LINK_TYPE_EX)  { return LINKCMD_SEND_LINK_TYPE; }
		if (w == LINKCMD_INIT_BLOCK)         { return LINKCMD_SEND_LINK_TYPE_EX; }
		return LINKCMD_INIT_BLOCK;
	}
	return w;
}

/* 控制字白名单自检（仿 sio_cmd_sim.py:166 pred_word_is_control，红线：出现 party 负载即 FAIL）。
 * 注意与 gnpPredWordForbidden 不同维度：这里是 mock 输入合法性（防造 party），
 * 后者是投机输出注入禁令（防猜错写径），二者勿混（Q5 口径辨析）。 */
static int gnpSelftestIsControl(uint16_t w) {
	static const uint16_t wl[5] = {
		LINK_HANDSHAKE_MASTER, LINK_HANDSHAKE_SLAVE, LINKCMD_SEND_LINK_TYPE,
		LINKCMD_SEND_LINK_TYPE_EX, LINKCMD_INIT_BLOCK
	};
	uint32_t i, j;
	if (w == 0u) { return 1; }
	for (i = 0u; i < 5u; ++i) { if (w == wl[i]) { return 1; } }
	for (i = 0u; i < 5u; ++i) {
		for (j = 0u; j < 5u; ++j) {
			if (w == (uint16_t) (wl[i] + wl[j])) { return 1; }
		}
	}
	return 0;
}

int gnpPredRollbackSelfTest(const struct GnpPredSelfTestReq* req,
                            struct GnpPredSelfTestRes* res) {
	struct SioLink mock;
	uint8_t diag[GNP_NG_DIAG_SIZE];
	struct NgLatch probeLatch;
	struct NgHist hist;
	uint32_t rounds, t, rt, divergeAt, D, anchor;
	uint32_t digestBase, digestSpec, digestReplay, anchorSnap;
	uint32_t mismatchSeq, replayedRounds, arrived, expectMismatch, dseq, ddig, injected;
	uint32_t seqBefore;
	int mismatch, guardErr, reconciled, gateOk, gateDeny;
	bool prevRollback;

	if (!req || !res) { return -1; }
	memset(&mock, 0, sizeof(mock));
	memset(res, 0, sizeof(*res));
	memset(diag, 0, sizeof(diag));
	memset(&probeLatch, 0, sizeof(probeLatch));
	memset(&hist, 0, sizeof(hist));
	/* sioNgLatchSample 经 gnpNgSampleOk 采样：latch.valid==0 时首样被拒（生产同款行为），
	 * 故 mock 先置 valid=1 引导到稳态（仅元数据，不置 tag_ok；tag_ok 仍由真函数逐字读 mock diag）。
	 * 这暴露了 sioNgLatchSample 无法从零自举的潜在点，属观察项，不在本自测范围修改生产逻辑。 */
	mock.sioNgLatch.valid = 1;
	mock.sioNgLatch.seq = 0u;
	mock.sioNgLatch.digestAtSeq = 0u;

	prevRollback = s_sioRollbackEnabled;
	sioRollbackSet(true);   /* 绕过 getenv 静态缓存；退出恢复，不污染全局门 */
	guardErr = 0;
	rounds = req->frames * 9u;
	D = req->delayRounds;
	divergeAt = req->divergeAt;
	anchor = (divergeAt == UINT32_C(0xFFFFFFFF)) ? 0u : (divergeAt / 9u) * 9u;
	mismatchSeq = 0u;
	replayedRounds = 0u;
	mismatch = 0;
	reconciled = 0;

	/* 硬门纯判据复核：合成 sp0=0/brs=0（非 live gba->cpu），out.word=0 未禁投。
	 * 正例放行、禁投否定——与 gnpPredHardGatePure 真值表逐字一致（层 A 已全覆盖）。 */
	gateOk = gnpPredHardGatePure(1, GNP_CONF_HIGH, GNP_PHASE_SEQ_INDEX,
	                             4u, 1u, 0u, 0u, 0, 0, 0, 0, 0);
	gateDeny = gnpPredHardGatePure(1, GNP_CONF_HIGH, GNP_PHASE_SEQ_INDEX,
	                               4u, 1u, 0u, 0u, 0, 0, 0, 0, 1);
	if (!gateOk || gateDeny) { ++guardErr; }

	/* mock diag 模板：CLOSED+PARTY（仅此组合被 sioNgLatchSample 采样）。 */
	diag[GNP_OFF_NG_STATE] = GNP_NG_STATE_CLOSED;
	diag[GNP_OFF_NG_MSG_TYPE] = GNP_NG_MSG_PARTY;
	diag[GNP_OFF_NG_COUNT] = 1u;

	/* 阶段A：投机驱动 + 真字延迟确认 + diag 采样；同时算 digestBase（门关直吃真字）。 */
	digestBase = GNP_SELFTEST_FNV_OFFSET;
	for (t = 0u; t < rounds; ++t) {
		MgbaxPredictIn in;
		MgbaxPredictOut out, ledger;
		uint16_t tw = gnpSelftestTrueWord(t);
		uint16_t pw = gnpSelftestPredWord(t, divergeAt);

		/* 红线：真字/预测字都必须是合法控制字（ mock 绝不造 party 负载）。 */
		if (!gnpSelftestIsControl(tw) || !gnpSelftestIsControl(pw)) { ++guardErr; }
		digestBase = gnpSelftestFnvFeed(digestBase, tw);

		/* 直调 #1 sioPredictWord：非零控制字一律不投机（写径红线）；out.word 恒 0。 */
		memset(&in, 0, sizeof(in));
		in.phase = GNP_PHASE_SEQ_INDEX;   /* 唯一可能出投机字的相位 */
		in.ownWord = pw;
		in.st = 4u; in.sc = 1u; in.seq = t;
		memset(&out, 0, sizeof(out));
		sioPredictWord(&mock, &in, &out);
		if (out.word != 0u) { ++guardErr; }                       /* 控制字绝不泄漏为投机输出 */
		if (pw != 0u && out.speculative != 0) { ++guardErr; }     /* 非零控制字禁止投机 */

		/* 直调 #2 sioPredictShadowPut：以 mock 控制字填影子账本（非游戏态）。 */
		memset(&ledger, 0, sizeof(ledger));
		ledger.word = pw; ledger.conf = GNP_CONF_HIGH; ledger.speculative = 1;
		sioPredictShadowPut(&mock, t, in.sc, &ledger, pw);

		/* 直调 #3 sioPredictConfirm：真字延迟 D 到达 seq=t-D，比对账本 → 确认/分歧。 */
		if (D <= t) {
			sioPredictConfirm(&mock, t - D, gnpSelftestTrueWord(t - D),
			                  &mismatch, &mismatchSeq);
		}

		/* 直调 #4 sioNgLatchSample：只收 CLOSED+PARTY；seq 严格增、tag_ok 只 0->1。
		 * diag 是 mock 注入样本（非 live/checker），tag_ok 置 1 仅为验证 sticky 语义。 */
		dseq = t;
		ddig = gnpSelftestFnvFeed(GNP_SELFTEST_FNV_OFFSET, tw);
		diag[GNP_OFF_NG_SEQ + 0] = (uint8_t) (dseq & 0xFFu);
		diag[GNP_OFF_NG_SEQ + 1] = (uint8_t) ((dseq >> 8) & 0xFFu);
		diag[GNP_OFF_NG_SEQ + 2] = (uint8_t) ((dseq >> 16) & 0xFFu);
		diag[GNP_OFF_NG_SEQ + 3] = (uint8_t) ((dseq >> 24) & 0xFFu);
		diag[GNP_OFF_NG_RX_DIGEST + 0] = (uint8_t) (ddig & 0xFFu);
		diag[GNP_OFF_NG_RX_DIGEST + 1] = (uint8_t) ((ddig >> 8) & 0xFFu);
		diag[GNP_OFF_NG_RX_DIGEST + 2] = (uint8_t) ((ddig >> 16) & 0xFFu);
		diag[GNP_OFF_NG_RX_DIGEST + 3] = (uint8_t) ((ddig >> 24) & 0xFFu);
		diag[GNP_OFF_NG_TAG_OK] = (t >= rounds / 2u && t < rounds - 2u) ? 1u : 0u;
		sioNgLatchSample(&mock, diag);
		res->specRounds = t + 1u;
	}

	/* 非 CLOSED+PARTY 组合必须被 sioNgLatchSample 忽略（latch.seq 不变）。
	 * 用全新 seq=1000 让「若错误采样」必然改变 latch.seq，使检查可证伪。 */
	seqBefore = mock.sioNgLatch.seq;
	diag[GNP_OFF_NG_SEQ + 0] = (uint8_t) 1000u;
	diag[GNP_OFF_NG_SEQ + 1] = (uint8_t) (1000u >> 8);
	diag[GNP_OFF_NG_SEQ + 2] = 0u;
	diag[GNP_OFF_NG_SEQ + 3] = 0u;
	diag[GNP_OFF_NG_STATE] = 1u;   /* 非 CLOSED */
	sioNgLatchSample(&mock, diag);
	if (mock.sioNgLatch.seq != seqBefore) { ++guardErr; }
	diag[GNP_OFF_NG_STATE] = GNP_NG_STATE_CLOSED;
	diag[GNP_OFF_NG_MSG_TYPE] = 2u; /* 非 PARTY */
	sioNgLatchSample(&mock, diag);
	if (mock.sioNgLatch.seq != seqBefore) { ++guardErr; }
	diag[GNP_OFF_NG_MSG_TYPE] = GNP_NG_MSG_PARTY;

	/* gnpNgSampleOk：seq 严格增 / 重复 seq digest 绑定。 */
	probeLatch.valid = 1; probeLatch.seq = 10u; probeLatch.digestAtSeq = 0xABCDu;
	if (!gnpNgSampleOk(&probeLatch, 11u, 0x1234u)) { ++guardErr; }  /* 增 seq OK */
	if (gnpNgSampleOk(&probeLatch, 9u, 0x1234u)) { ++guardErr; }    /* 旧 seq 拒 */
	if (!gnpNgSampleOk(&probeLatch, 10u, 0xABCDu)) { ++guardErr; }  /* 同 seq 同 digest OK */
	if (gnpNgSampleOk(&probeLatch, 10u, 0x0000u)) { ++guardErr; }   /* 同 seq 异 digest 拒 */

	/* gnpNgConfirm / gnpNgInjectWord：未确认禁注入，转正后只注入真字。 */
	hist.frameNo = 0u; hist.word = 0x1111u; hist.tag = NG_PREDICTED;
	injected = 0u;
	if (gnpNgInjectWord(&hist, &injected)) { ++guardErr; }
	gnpNgConfirm(&hist, 0x2222u);
	if (hist.tag != NG_CONFIRMED || hist.word != 0x2222u) { ++guardErr; }
	if (!gnpNgInjectWord(&hist, &injected) || injected != 0x2222u) { ++guardErr; }

	/* 账本一致性：到达 seq 数 = rounds-D；其中分歧 1 条，其余确认。 */
	arrived = (D < rounds) ? (rounds - D) : 0u;
	expectMismatch = (divergeAt < arrived) ? 1u : 0u;
	if (mock.sioPredMismatch != expectMismatch) { ++guardErr; }
	if (expectMismatch && mock.sioPredMismatchSeq != divergeAt) { ++guardErr; }
	if (mock.sioPredConfirmed != (arrived - expectMismatch)) { ++guardErr; }

	/* 阶段B：投机路径摘要 + 分歧回滚重放（三路摘要之一）。 */
	digestSpec = GNP_SELFTEST_FNV_OFFSET;
	for (t = 0u; t < rounds; ++t) {
		if (t % 9u == 0u) { anchorSnap = digestSpec; }  /* 帧首快照（回滚锚点） */
		if (divergeAt != UINT32_C(0xFFFFFFFF) && t == divergeAt && !reconciled) {
			digestSpec = anchorSnap;                     /* 回滚到 <=分歧 的最近帧锚点 */
			for (rt = anchor; rt < rounds; ++rt) {
				digestSpec = gnpSelftestFnvFeed(digestSpec, gnpSelftestTrueWord(rt));
			}
			replayedRounds = rounds - anchor;
			reconciled = 1;
			break;
		}
		digestSpec = gnpSelftestFnvFeed(digestSpec, gnpSelftestPredWord(t, divergeAt));
	}

	/* 重放路径摘要：真字从锚点独立重放（与 base 各自累加，互不相借）。 */
	digestReplay = GNP_SELFTEST_FNV_OFFSET;
	for (t = 0u; t < rounds; ++t) {
		digestReplay = gnpSelftestFnvFeed(digestReplay, gnpSelftestTrueWord(t));
	}

	res->digestSpec = digestSpec;
	res->digestBase = digestBase;
	res->digestReplay = digestReplay;
	res->framesClosed = rounds / 9u;
	res->replayedRounds = (divergeAt == UINT32_C(0xFFFFFFFF)) ? 0u : replayedRounds;
	res->mismatchSeq = mismatchSeq;
	res->tagOkSticky = mock.sioNgLatch.tagOkSticky;
	res->predVsFastConflict = mock.sioPredVsFastConflict;

	sioRollbackSet(prevRollback);
	return guardErr;
}
#endif /* MGBAX_ROLLBACK_ENABLE && MGBAX_PRED_SELFTEST */
#endif /* MGBAX_ROLLBACK_ENABLE：门关时全部预测本体内联函数不参与编译，零 unused 警告 */

/* 【角色不对称的门】主机 = 生产字方，快帧取不到从机字就复用上一轮自己喂
 * 给游戏的对端槽，只影响按键新鲜度，可以用 MGBAX_FAST_MIN_OK 提前放行救
 * LAG_MASTER；从机 = 消费字方，块交换期取不到主机字就把 sioFastLast 当本轮
 * 真字喂进逐块校验 ⇒ badChecksum 掉链（FASTEARLY1 现场：主机 n=64 ls=4
 * 健康、从机 mis=598 st=0x2249 含 0x2000）。所以主机门可配、从机门固定 256
 *（那时块交换早结束、纯按键交换，复用旧字才安全）。两个 wrapper 共用实现。 */
static bool sioFastFrameImpl(struct SioLink* sio, uint32_t minOk) {
	static int disabled = -1;
	if (disabled < 0) {
		const char* v = getenv("MGBAX_SIO_FAST");
		disabled = (v && atoi(v) == 0) ? 1 : 0;
	}
	/* 【13:26 关键修正】开关关闭时必须**完全旁路**，绝不能走下面的
	 * 「链路断开就清状态」分支：那个分支会每轮把 sioSelfSlot 清成 0xFFFF、
	 * 把 sioRoundWordValid 置 false，正好抹掉 beginMultiTransfer / 从机
	 * 起轮刚捕获的本轮字 ⇒ 投递给游戏的槽变成 FFFF、从机槽变成寄存器残值
	 * （PUREBLOCK4/5 现场：主机 data=FFFF,4CF8,FFFF,FFFF，pc 恒 0）。
	 * 关快帧是做 A/B 的常规操作，不该有副作用。 */
	if (disabled) {
		return false;
	}
	/* 链路断开或优化被关掉：解除锁存，下次重新等到 cnt>=2 才放开。 */
	if (disabled || !sio->link || netLinkState(sio->link) != 2) {
		sio->sioFastLatched = false;
		sio->sioFastMiss = 0;
		sio->sioFastLastValid = false;
		sio->sioSelfSlot = 0xFFFFu;
		sio->sioRoundWordValid = false;   /* 上一局的字不许漏进新会话 */
		return false;
	}
	if (sio->sioFastLatched) {
		/* 【C1 缺陷修复】锁存不能跳过 state>=4 判据。
		 * 原先这里直接 return true：一旦锁存，之后链路被拆回握手（state 2）
		 * 或还没重新 LINKUP，快帧仍持续复用旧字，等于把「握手期绝不快帧」
		 * 这条铁律绕过去了（Agent C 报告的 C1）。现在锁存状态下仍读
		 * gLink.state，state<4 立即解锁存并落回严格路径，下一次重新建链
		 * 后必须再走一遍完整的门。 */
		if (sioGLinkState(sio) < 4) {
			sio->sioFastLatched = false;
			sio->sioFastMiss = 0;
			sio->sioFastLastValid = false;
			return false;
		}
		return true;
	}
	if (sio->sioOk < (uint32_t) minOk) {
		return false;
	}
	/* 只在 LINKUP 真正完成后放开帧率：握手与训练家卡片块交换期间每一轮
	 * 都必须是真实对端字，复用上一轮字会破坏块校验（历史结论：空槽/陈旧
	 * 字会把 cnt 打回 0，停在「等待连接」）。fieldLinkPlayerCount 取自
	 * 0x03004A38 高字节，与 [room] 诊断里的 cnt 同源。 */
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	/* 只看 cnt 会误判：02:03 轮 [diag] lstate=1 pc=0（gLink 会话根本没
	 * 建立）却出现 [room] cnt=2，那是上一局遗留的内存值，结果快速帧在
	 * 握手/块交换阶段就被触发、复用旧字，末尾 [diag] linkup=6（连接错误）。
	 * gLink.state（0x03002AF5）与 playerCount（0x03002AF7）才是真实判据：
	 * 历史成功轮为 lstate=4 pc=2，未建立时为 lstate=1 pc=0。
	 * 三个条件同时满足才认定会话已建立，避免损坏 LINKUP 块校验。 */
	uint16_t gl0 = GBAView16(gba->cpu, SIO_IW(0x03002AF4u));
	uint16_t gl1 = GBAView16(gba->cpu, SIO_IW(0x03002AF6u));
	if (!sioFastGateReadyEx(disabled != 0, sio->sioOk, (unsigned) ((gl0 >> 8) & 0xFF),
	                        (unsigned) ((gl1 >> 8) & 0xFF), (uint32_t) minOk)) {
		return false;
	}
	/* 【不再把 gFieldLinkPlayerCount >= 2 当必要条件】
	 * 这个字段只在野外/联机房间那条路线被写入；有线俱乐部的「大竞技场 /
	 * 交换中心」这条路它恒为 0 —— 11-15 实测：两端已 LINKUP（app PEEK
	 * `link[m=8 st=4 pc=2]`，两端都停在柜台），但 PC 仍 4.9fps 且一条
	 * `SIO fast` 都没有，就是被这一条卡死的。
	 * 会话判据只认 gLink.state / playerCount：这正是 LINKUP 的真判据。
	 * 上面那段历史注释讲的是「只看 cnt 会误判」，而 state>=4 且 pc>=2 已经
	 * 把那种误判排除掉了，所以这里去掉 fieldCount 不会放大误判；
	 * 它若 >=2 仍然说明是房间路线，记进日志便于事后区分。 */
	if ((GBAView16(gba->cpu, SIO_IW(0x03004A38u)) >> 8) < 2) {
		SIO_LOG("fastframe latch without fieldCount (cable club path) lstate=%u pc=%u",
		        (unsigned) ((gl0 >> 8) & 0xFF), (unsigned) ((gl1 >> 8) & 0xFF));
	}
	/* 会话建立过一次就锁存。02:03 实测 cnt 会抖动，不锁存时同一个 64 次
	 * 传输窗口里只有 22 次走快速路径（fb=22 / n=42），其余 42 次仍按
	 * 23~32ms/轮 阻塞，帧率被反复拖回去。 */
	sio->sioFastLatched = true;
	return true;
}

/* 主机门：读 MGBAX_FAST_MIN_OK（默认 256 = 原行为）。
 * 【A/B 开关】path A 云端握手在 n≈34 就达成 lstate=4 pc=2，但门要等 n>=256，
 * 这 220 轮走慢速网络往返（每轮约 51ms≈3 帧），每帧 SIO 中断远不到游戏要求
 * 的 9 次 ⇒ LinkVSync 置 LAG_MASTER(0x10000) ⇒ CheckErrorStatus 拆链
 *（PHASE3 现场）。设 MGBAX_FAST_MIN_OK=8 让握手成功后立即进快帧、一帧喂满
 * 中断，FASTEARLY1 证明主机侧拆链消失。只影响主机，从机走 sioFastFrameSlave。 */
static bool sioFastFrame(struct SioLink* sio) {
	static int minOk = -1;
	if (minOk < 0) {
		const char* v = getenv("MGBAX_FAST_MIN_OK");
		int parsed = (v && atoi(v) > 0) ? atoi(v) : 256;
		minOk = parsed;
	}
	return sioFastFrameImpl(sio, (uint32_t) minOk);
}

/* 从机门：默认固定 256（忽略 MGBAX_FAST_MIN_OK）。块交换期（n<256）从机必须
 * 阻塞等主机真字，复用旧字会把 sioFastLast 当本轮字喂进逐块校验 ⇒ badChecksum
 * 掉链。256 轮后块交换早已结束、进入纯按键交换，复用旧字才安全。
 *
 * 【11-16 18:40 云端解锁】256 这个默认值对**云端**是致命的：跨公网每轮约
 * 100ms（RTT 决定），256 轮就是 25s 墙钟，而游戏的数据交换超时按**帧**算
 * （600 帧 ≈ 10s @60fps）—— 从机永远等不到快帧放行就被判超时，主机侧的
 * 2222/块交换也就永远没人应答。所以把门做成可调：MGBAX_FAST_MIN_OK_SLAVE
 * （默认 256，原行为不变）。云端 2P 用 8。
 * 开小之后"复用旧字破坏块校验"的风险由 finishMultiTransfer 里的校验和改写
 * （MGBAX_CS_FORGE，默认开）兜住：游戏唯一的传输层完整性判据不再依赖
 * 逐字新旧，块内容本身另有 rem/brs 判据。 */
/* 【MGBAX_FAST_SLAVE_ALIGN：从机快帧「两端 idx 已对齐」前提】
 * ADR-003 §4.2 h.6 的遗留卡点：主机快帧取不到从机字只影响按键新鲜度，安全；
 * 从机快帧却在取不到主机字时把 sioFastLast 旧字当成**本轮真字**喂进
 * completeMultiTransfer，逐块校验立刻 badChecksum(0x2000) 掉链（FASTEARLY1
 * 现场：从机 idx 冻结 50、主机已推到 576）。正常门限 256 给了 200+ 轮让两端
 * idx 自然对齐；MGBAX_FAST_MIN_OK=8 提早放行后才暴露这个不对齐。
 * 这里给从机门补一条对齐前提：对齐基准取**链路层记录的最近一次对端推字轮次号**
 *（主机发布的 idx），不是本机冻结的 sioIndex。没对齐就不放行快帧，落回严格
 * 等待路径（取不到真字就不收尾、绝不复用旧字），本机逐轮消费把 sioIndex 追上
 * 主机后门自动放行。默认 window=0（关闭，原行为不变）。 */
static unsigned sioHostPubIndex(struct SioLink* sio) {
	unsigned idx = 0;
	if (sio && sio->link) {
		/* recvIndex = 本端最近一次收到的对端 PKT_PUSH 轮次号 = 主机发布的 idx */
		netLinkWireStats(sio->link, NULL, NULL, NULL, NULL, &idx);
	}
	return idx;
}

/* 纯函数：wrap-safe 的 |hostIdx - slaveIdx| <= window。任一侧为 0（还没拿到
 * 可靠轮次基准）视为未对齐，宁可多等一轮也不提前放行旧字。 */
static bool sioFastSlaveIdxAligned(uint32_t hostIdx, uint32_t slaveIdx, uint32_t window) {
	if (hostIdx == 0 || slaveIdx == 0) {
		return false;
	}
	uint32_t ahead = (uint32_t) (uint16_t) (hostIdx - slaveIdx);
	uint32_t behind = (uint32_t) (uint16_t) (slaveIdx - hostIdx);
	uint32_t gap = ahead < behind ? ahead : behind;
	return gap <= window;
}

static bool sioFastFrameSlave(struct SioLink* sio) {
	static int minOk = -1;
	static int alignWindow = -1;
	if (minOk < 0) {
		const char* v = getenv("MGBAX_FAST_MIN_OK_SLAVE");
		int parsed = (v && atoi(v) > 0) ? atoi(v) : 256;
		minOk = parsed;
	}
	if (alignWindow < 0) {
		const char* v = getenv("MGBAX_FAST_SLAVE_ALIGN");
		int parsed = (v && atoi(v) > 0) ? atoi(v) : 0;
		alignWindow = parsed;
	}
	/* 只在「门本来就准备放行」的那一刻查对齐，避免握手期把诊断计数刷满。
	 * 未对齐则挡下本轮快帧（不锁存），严格路径逐轮把 sioIndex 追上来。 */
	if (alignWindow > 0 && sio && sio->sioOk >= (uint32_t) minOk
	    && sioGLinkState(sio) >= 4) {
		unsigned hostIdx = sioHostPubIndex(sio);
		if (!sioFastSlaveIdxAligned(hostIdx, (uint32_t) sio->sioIndex,
		                            (uint32_t) alignWindow)) {
			++sio->sioFastAlignBlocked;
			if ((sio->sioFastAlignBlocked & 0x3F) == 1) {
				SIO_LOG("slave fast align gate blocked n=%u slaveIdx=%u hostIdx=%u window=%d state=%d ok=%u",
				        (unsigned) sio->sioFastAlignBlocked, (unsigned) sio->sioIndex,
				        hostIdx, alignWindow, (unsigned) sioGLinkState(sio),
				        (unsigned) sio->sioOk);
			}
			return false;
		}
	}
	return sioFastFrameImpl(sio, (uint32_t) minOk);
}

/* ---- 握手期按周期轮询，而不是一次阻塞满等待窗 ----------------------------
 *
 * 现场（双 PC 直连，P2P）握手期日志：
 *     SIO multi me=0 ok=... fb=0 mis=0 wait=5/16ms n=64
 * 64 轮里只有 5 轮真等，但每等一次就把**模拟线程**按停 16ms：64 轮≈7 帧，
 * 不等待时 117ms，加上 5×16ms 变成 197ms → 33fps。链路 RTT 本身只有
 * 14~16ms，等待是必需的（对端字没到，这一轮就不该结束），但「用墙钟冻结
 * 模拟时间」不是必需的：把等待拆成多次短轮询，每次取不到就重新调度
 * sioDone 立刻返回，runLoop 继续推进模拟周期、继续出帧。
 *
 * N 取 1667 cycles（≈0.1ms 模拟时间，与 SIO multi 日志里 wait 的 0.1ms 刻度
 * 同源）：轮询粒度远小于 RTT，取到字的额外延迟可以忽略；一次轮询本身只做
 * 一次非阻塞取队列 + 一次 mTimingSchedule，开销与既有的 100 cycles 重试同量级。
 *
 * 只覆盖握手/块交换期 = 快帧门还没放开的那一段。实测（LX2，11-16 00:43~
 * 00:45）：ok=128~256 的窗口 [diag] 已经是 lstate=2 pc=2，但快帧门要求
 * ok>=256 才放行，这几窗仍走严格路径且 wait=5/16ms n=64 —— 掉帧就在这段。
 * 只按 gLink.state<2 卡会让轮询仅覆盖前 64 轮（现场 cp=322 只出现在第一窗，
 * 之后 cp=0），等于没改。所以判据取「快帧未锁存且未达 256 轮」：
 * 与 sioFastFrame 的门一一对应，锁存后这里根本不会被调用。
 * MGBAX_SIO_CONNECT_POLL=0 时完全走旧路径，便于 A/B 与回退。 */
static bool sioConnectPollOn(struct SioLink* sio) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_SIO_CONNECT_POLL");
		/* 缺省开（=0 才关）：11-16 00:54 现场对照 —— 关掉后两端停在
		 * 「请稍候 …… B键：取消」且 pc=1/0 永不收敛（阻塞等待冻结模拟
		 * 时间，游戏侧的联机轮询推不动）；开着时至少能到 lstate=4 pc=2。
		 * 所以默认恢复为开，保留 =0 作为回退口。
		 * 【历史注记】这一行的默认值曾被同一条排查线在 00:52 改成「显式 =1
		 * 才开」、00:56 又回退成现在这样（A/B 对照用），不是误改；以后看
		 * git blame 到这次变更时不要当成越权修改。 */
		enabled = (v && atoi(v) == 0) ? 0 : 1;
	}
	if (!enabled) {
		return false;
	}
	if (!sio->link || netLinkState(sio->link) != 2) {
		return false;
	}
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	/* 【稳态也要轮询 2026-11-17 23:1x】
	 * 原来稳态（sioFastLatched / sioOk>=256）直接 return false，让调用点走
	 * 「按墙钟阻塞等对端字」的严格路径。实测（FR1 SIOPERF）每 500 轮里有
	 * 2298ms 是阻塞的，9 轮/帧 ⇒ **每帧冻住 41.8ms**，帧率被压到 24fps
	 *（单机 59.7fps，一帧预算 16.7ms）。
	 * 而快帧分支 `netLinkTakePeerWord(want, 0)` 用的是**严格 label** 匹配，
	 * 对端字晚到一点点就 miss，一 miss 就掉回阻塞路径 —— 这是掉帧的主源。
	 * 打开这个开关后，稳态也走「短轮询 + 重新调度」：取不到就立刻返回，
	 * 模拟时钟继续推进、继续出帧；单轮累计到 60ms 墙钟才退回一次阻塞，
	 * 保证一定能往前推进。开关 MGBAX_POLL_ALWAYS=1。 */
	{
		static int pollAlways = -1;
		if (pollAlways < 0) {
			const char* v = getenv("MGBAX_POLL_ALWAYS");
			pollAlways = (v && atoi(v) == 1) ? 1 : 0;
		}
		if (pollAlways) {
			return true;
		}
	}
	if (sio->sioFastLatched || sio->sioOk >= 256) {
		return false;
	}
	/* 剩下的是 state<2 的纯握手/选举期，或 state>=2 但 pc<2 / ok<256 的
	 * 块交换阶段（实测掉帧就发生在这里）：两者都归轮询管，直接放行。 */
	return true;
}

/* 【取字不再死等 label 2026-11-16 24:4x】
 *
 * `netLinkTakePeerWord(want)` 要求对端队列队首的 label **完全等于** want，
 * 不等就阻塞到 `sioPipelineWaitMs`（实测能到 400ms），再配合 sioRetries 的
 * 重试，一轮能耗掉 **25.5 秒**（TR32 的 `t=` 实测：n=1 t=29117734 →
 * 下一轮 t=29143296）。而 cable club 的 `TryLinkTimeout` 只给 600 帧
 *（cable_club.c:563，≈10 秒），于是"握手还没走完就已经判连接错误"，
 * `res=6 → special CloseLink`，两端从此互踢。
 *
 * 开关 MGBAX_LABEL_ANY=1 时改成"只要队列里还有不太旧的字就取"（容忍落后
 * 4 个 label 以内）。label 只是配对序号，我们的相位由 SYNCIDX 随行的
 * 真实索引决定，不再依赖 label 精确相等。 */
static bool sioTakePeerWord(struct SioLink* sio, uint32_t* value, uint16_t* idx, int timeoutMs) {
	uint64_t t0 = wallNowUs();
	bool r = sioTakePeerWordRaw(sio, value, idx, timeoutMs);
	if (r && value) {
		sioCapturePeerParty(*value);   /* ROOTHUNT2：解 APP 队伍 species sidecar */
	}
	sioPerfLog(sio, wallNowUs() - t0);
	return r;
}

static bool sioTakePeerWordRaw(struct SioLink* sio, uint32_t* value, uint16_t* idx, int timeoutMs) {
	static int any = -1;
	if (any < 0) {
		const char* v = getenv("MGBAX_LABEL_ANY");
		any = (v && atoi(v) == 1) ? 1 : 0;
	}
	if (any && sio->link) {
		/* 【严格递增去重 —— 默认关】minIdx 用「上次消费的 label + 1」能挡掉
		 * 同一轮被推两次的第二份（第二块滑拍的根因），但**副作用更糟**：
		 * 一旦对端 label 不前进，所有取字都会失败 ⇒ 等待窗拖满 ⇒
		 * 握手期 `LinkVSync` 的 `++sNumVBlanksWithoutSerialIntr > 10` 把
		 * playerCount 清零 ⇒ 永远 pc=0（TR51/TR52 连续两轮都是这个分支，
		 * 而去重之前 TR44/46/47/49 都是两端 rem=1）。
		 * 所以默认走宽容窗口；要试去重用 MGBAX_LABEL_DEDUPE=1。 */
		static int dedupe = -1;
		if (dedupe < 0) {
			const char* v = getenv("MGBAX_LABEL_DEDUPE");
			dedupe = (v && atoi(v) == 1) ? 1 : 0;
		}
		uint16_t minIdx;
		if (dedupe && sio->sioPeerLabelOk) {
			minIdx = (uint16_t) (sio->sioLastPeerLabel + 1u);
		} else {
			minIdx = (sio->sioIndex > 4u) ? (uint16_t) (sio->sioIndex - 4u) : 0u;
		}
		bool got = netLinkTakePeerWordAny(sio->link, minIdx, timeoutMs, value, idx, NULL);
		if (got && idx) {
			sio->sioPeerLabelOk = true;
			sio->sioLastPeerLabel = *idx;
		}
		return got;
	}
	/* 【D8 CMD-GUARD】块交换期不允许超时把未来轮次字冒成本轮真字。 */
	if (sioInCmdPhase(sio)) {
		return sio->link && netLinkTakePeerWordCmd(sio->link, sio->sioIndex, timeoutMs, value, idx, NULL);
	}
	return sio->link && netLinkTakePeerWord(sio->link, sio->sioIndex, timeoutMs, value, idx, NULL);
}

static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(timing);
	struct SioLink* sio = (struct SioLink*) user;
	if (!sio->sioWaiting) {
		return;
	}
	/* 3/4 人总线：主机在这一刻收齐所有从机本轮的字，再一次性广播给它们。
	 *
	 * 两处判据都不能省：
	 *   - 必须用 netLinkBusActive()，不能按人数。总线里只有一个从机时
	 *     netLinkBusPlayers() 正好是 2，按人数判会掉进下面的两人直连分支，
	 *     而总线的字根本不进 peerQ，结果永远是「对端没回字」。
	 *   - 必须放在 sioFastFrame / netLinkTakePeerWord 之前：那两个会去空的
	 *     peerQ 上等，白白空耗满整个等待窗。 */
	{
		int busPlayers = netLinkBusPlayers(sio->link);
		if (netLinkBusActive(sio->link) && busPlayers >= 1
		    && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
			struct GBA* gbaBus = (struct GBA*) sio->core->board;
			/* 【W92/path B 原生 SIO】cb==0 但 gLink.state==2 是「已进握手态、
			 * 未装 callback」的 path B 现场，不是真 boot。此时不进下面的空槽
			 * 收尾，而是 fall through 到真正的 LocalBus 回合：握手字由本进程
			 * 镜像核经总线原生投递（sioBlockOutWord 在握手期放行真字），
			 * 不靠 sioBusBootHsPreserve 写真握手字。state<2 的真 boot 仍保留
			 * 空槽行为（三核启动期互不喂字），零回归。 */
			bool nativeHs = sioPathBNativeSioOn()
			    && GBAView8(gbaBus->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF)
			           == SIO_LINK_STATE_HANDSHAKE;
			/* boot/BIOS 阶段（游戏还没进入联机代码，gLinkCallback==0）不能
			 * 走总线：否则三核在启动期互相喂字，boot 卡在 494E 再也进不去
			 *（实测 3 人 cb2=0；同条件不挂链接则能到菜单）。这里用空槽把
			 * 本轮收尾，让启动代码像「单机无对端」一样继续跑。 */
			if (GBAView16(gbaBus->cpu, SIO_IW(0x03002AD4u)) == 0
			    && GBAView16(gbaBus->cpu, SIO_IW(0x03002AD6u)) == 0
			    && !nativeHs) {
				uint32_t emptyVals[4] = { 0xFFFFu, 0xFFFFu, 0xFFFFu, 0xFFFFu };
				/* 【path B 握手期保真】cb==0 但 gLink.state==2 且真对端在线 =
				 * 握手态未装 callback，非真 boot。此时按空槽收尾会让
				 * DoHandshake playerCount=0 自锁；把真握手字填入槽位。 */
				sioBusBootHsPreserve(sio, gbaBus, emptyVals,
				                     busPlayers < 2 ? 2 : busPlayers);
				/* 必须清 sioWaiting：gbaLinkStart 见到它就把后续所有 MULTI
				 * 起始直接拒绝（返回 false）。之前这里只 return，导致主机
				 * 整个运行只启动过一次 MULTI（BEGIN n=1），之后再不起传输。 */
				sio->sioWaiting = false;
				sio->sioRetries = 0;
				completeMultiTransferBus(sio, emptyVals, busPlayers, cyclesLate);
				return;
			}
			uint32_t busVals[4];
			uint16_t used = sio->sioIndex;
			/* V11-S6：BUS 主机本轮出网字也过 sc 相位锁，与 beginMultiTransfer
			 * 的 push/自槽同源（三端对称）。sc 已在起轮捕获，此处只读不重捕。 */
			uint32_t own = sioBlockOutWord(sio,
			    gbaBus->memory.io[GBA_REG(SIOMLT_SEND)], true, gbaBus);
			int busGot = netLinkBusRound(sio->link, sio->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(sio, (int) sio->sioIndex), &used);
			if (busPlayers < 2) {
				busPlayers = 2;   /* 还没从机连上：按「只有自己」收尾 */
			}
			if (busGot <= 0 && sio->sioRetries < 3 && netLinkState(sio->link) == 2) {
				/* 有从机连着却一个都没收到：它们慢了一拍，不是没有。重试几次
				 * 再按空槽收尾，否则一次迟到就把这一轮的握手数据变成 0xFFFF。 */
				++sio->sioRetries;
				struct mTiming* t2 = coreTiming(sio);
				if (t2) {
					mTimingSchedule(t2, &sio->sioDone, 100);
					return;   /* sioWaiting 保持 true */
				}
			}
			sio->sioRetries = 0;
			sio->sioWaiting = false;
			sio->sioHasRemote = busGot > 0;
			sio->sioRemote = busVals[0];
			/* 【path B / LocalBus 握手字保真】busGot<=0（从机未 push/广播 abort）
			 * 重试耗尽后，busVals 保持全 FFFF；若按空槽收尾，DoHandshake 第一槽
			 * 就是 FFFF ⇒ playerCount 清 0、st=2 永久自锁（PB5 铁证：w=8FFF 但
			 * data=FFFF）。这里与从机「绝不空槽收尾」保护对称：握手期把本轮
			 * own（真 SIOMLT_SEND，已经 sioBlockOutWord 的 HSBYPASS 保真）回填
			 * 到主机自槽（链路槽 0），只保真游戏真字、不造 state/rem/brs/party。
			 * 门：独立开关 + 真对端在线 + state==2 握手态（不依赖 BTLCFG，path B
			 * 现场 btcfg 恒 0，挂它会使修复在失败轮不触发）。 */
			if (!sioPathBNativeSioOn() && busGot <= 0 && sioBusHsPreserveOn()
			    && sio->link && netLinkState(sio->link) == 2u
			    && GBAView8(gbaBus->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF)
			           == SIO_LINK_STATE_HANDSHAKE) {
				int hm = netLinkPlayer(sio->link);
				if (hm >= 0 && hm < 4 && busVals[hm] == 0xFFFFu) {
					busVals[hm] = (uint16_t) own;   /* 真 8FFF/B9A0，读时保真 */
				}
				/* DoHandshake 需 playerCount>1：槽0=8FFF + 槽1=B9A0。abort 时两槽
				 * 全丢；对端镜像核每轮真产生 B9A0（sioForceHandshake），这里只把它
				 * 在 transport 中丢失的真协议字回填槽1（非 party/信任位，与 path A
				 * 握手保持同性质）。仅当槽1为空且本端是真主机(8FFF)才填，不覆盖真字。 */
				int peerSlot = (hm == 0) ? 1 : 0;
				if (hm == 0 && sioIsHandshakeWord((uint16_t) own)
				    && own == LINK_HANDSHAKE_MASTER && busVals[peerSlot] == 0xFFFFu) {
					busVals[peerSlot] = LINK_HANDSHAKE_SLAVE;
				}
				if (sioIsHandshakeWord((uint16_t) own) && sio->sioOk <= 64u) {
					SIO_LOG("[BUSHS] rearm-slot me=%d idx=%u s0=%04X s1=%04X (host empty-slot preserve)",
					        hm, (unsigned) sio->sioIndex,
					        (hm >= 0 && hm < 4) ? (unsigned) busVals[hm] : 0,
					        (unsigned) busVals[peerSlot]);
				}
			}
			if (busGot <= 0) {
				SIO_LOG("BUS host round me=%d idx=%u got=%d n=%d",
				        netLinkPlayer(sio->link), (unsigned) sio->sioIndex, busGot, busPlayers);
			}
			completeMultiTransferBus(sio, busVals, busPlayers, cyclesLate);
			return;
		}
	}
	/* ---- 对称定长延迟线（N>0 才进；N==0 时下面的代码与改动前逐字节相同） ----
	 *
	 * 取「消费链上的那一个标签」而不是「按本轮号严格匹配」：两端都后移 N 轮，
	 * 于是两端消费的字序列完全相同、偏移相同 ⇒ 校验和整体后移，恒等
	 * （gen8/src/link.c:2322-2355，每 8 轮一块，第 8 字 = 对方已收字之和）。
	 *
	 * 取不到（队首是更后面的标签，或队列为空）时**不复用旧字、也不喂空槽**：
	 * 短周期重挂 sioDone、让模拟时钟继续走，本轮不完成。这样既不会把陈旧字
	 * 送进校验（那正是 badChecksum=0x2000 的来源），也不会用 0xFFFF 空槽把
	 * 对端 playerCount 清零。
	 *
	 * 兜底：连续 SIO_DELAY_MAX_WAIT 次重挂仍取不到（对端停摆/预热失败），
	 * 落回下面的旧路径收尾 —— 一条永远不完成的路由会让主机每帧 SIO 中断
	 * 归零、被 LinkVSync 判 LAG_MASTER 拆链，比喂一次旧字更糟。
	 */
	if (sioDelayLine(sio)) {
		uint16_t want = sio->sioDelayWant;
		uint32_t delayRemote = 0;
		uint16_t delayGot = 0;
		if (sio->link && netLinkTakePeerWord(sio->link, want, 0, &delayRemote, &delayGot, NULL)) {
			sio->sioDelayWaits = 0;
			sio->sioDelayWant = (uint16_t) (want + 1);
			if (delayGot != want) {
				++sio->sioMisorder;
			}
			sio->sioWaiting = false;
			sio->sioConnectSince = 0;
			sio->sioHasRemote = true;
#if MGBAX_ROLLBACK_ENABLE
			if (sioPredRollbackReady(sio)) {
				sioPredictConfirm(sio, sio->sioIndex, (uint16_t) delayRemote, NULL, NULL);
			}
#endif
			sio->sioRemote = delayRemote;
			completeMultiTransfer(sio, delayRemote, true, cyclesLate);
			return;
		}
		++sio->sioDelayWaits;
		if (sio->sioDelayWaits < SIO_DELAY_MAX_WAIT) {
			struct mTiming* td = coreTiming(sio);
			if (td) {
				if ((sio->sioDelayWaits & 0x3F) == 1) {
					SIO_LOG("delayline wait want=%u q=%d n=%u", (unsigned) want,
					        netLinkPeerPending(sio->link), (unsigned) sio->sioDelayWaits);
				}
				mTimingSchedule(td, &sio->sioDone, SIO_CONNECT_POLL_CYCLES);
				return;
			}
		}
		SIO_LOG("delayline fallback want=%u q=%d n=%u", (unsigned) want,
		        netLinkPeerPending(sio->link), (unsigned) sio->sioDelayWaits);
		sio->sioDelayWaits = 0;
		sio->sioDelayAnchored = false;   /* 下一轮重新锚定 */
	}
	/* 【COAST 垫深】本端 peerQ 还没攒到 N 轮 ⇒ 这一轮不消费，用上一轮的真字
	 * 补槽，但轮次照常完成（completeMultiTransfer 照常调一次）。这样每帧仍是
	 * 9 轮、模拟时间不膨胀，帧率回到 60；N 轮之后 peerQ 到深度 N，此后走下面
	 * 的队首链逐轮消费。详见 sioCoastReady 的注释。 */
	/* 【双预测源互斥自证】预测门开时 COAST 陈旧字复用必须停用，禁止同一轮
	 * 同时存在「预测字」与「陈旧真字」两个供给源；命中即 sioPredVsFastConflict++。
	 * 门关（默认）时本段被消解，下面条件与改动前逐字节相同。 */
	if (sioPredRollbackReady(sio) && sioCoastReady(sio) && sio->sioHasRemote
	    && netLinkPeerPending(sio->link) < (int) sio->sioCoastN) {
		++sio->sioPredVsFastConflict;
	}
	if (!sioPredRollbackReady(sio) && sioCoastReady(sio) && sio->sioHasRemote
	    && netLinkPeerPending(sio->link) < (int) sio->sioCoastN) {
		sio->sioWaiting = false;
		sio->sioConnectSince = 0;
		/* ROOTHUNT2 B7：战斗 controller 块期绝不喂陈旧真字垫深——陈旧块字会推进
		 * recvCmdIndex 却没消费真块 ⇒ bufferA[0] 恒 0。投空字保 IRQ，真字下一轮消费。 */
		if (battleRelayOn() && inBattleBlockRelay(sio)) {
			++s_sioBattleRelayEmpty;
			sioBlockProbe(sio, sio->sioRemote, "coast-empty");
			completeMultiTransfer(sio, 0, false, cyclesLate);
			return;
		}
		++sio->sioCoastRounds;
		completeMultiTransfer(sio, (uint32_t) sio->sioRemote, true, cyclesLate);
		return;
	}
	if (sioFastFrame(sio)) {
		uint32_t fastRemote = 0;
		uint16_t fastGot = 0;
		bool haveFast;
		if (sioCoastReady(sio)) {
			/* 垫深到位后按**队首链**逐轮消费：minIdx = 上次消费 label+1，
			 * 这样 N 轮后恒定滞后 N，且重复字会被 minIdx 挡掉。 */
			uint16_t minIdx;
			if (sio->sioPeerLabelOk) {
				minIdx = (uint16_t) (sio->sioLastPeerLabel + 1u);
			} else {
				minIdx = (sio->sioIndex > 4u) ? (uint16_t) (sio->sioIndex - 4u) : 0u;
			}
			haveFast = sio->link &&
			    netLinkTakePeerWordAny(sio->link, minIdx, 0, &fastRemote, &fastGot, NULL);
			if (haveFast) {
				sio->sioPeerLabelOk = true;
				sio->sioLastPeerLabel = fastGot;
			}
		} else {
			haveFast = sio->link &&
			    netLinkTakePeerWord(sio->link, sio->sioIndex, 0, &fastRemote, &fastGot, NULL);
		}
		if (haveFast) {
			sioCapturePeerParty(fastRemote);   /* ROOTHUNT2：主机 sioDone 两路径解 sidecar */
			sio->sioFastMiss = 0;
			sio->sioWaiting = false;
			sio->sioHasRemote = true;
#if MGBAX_ROLLBACK_ENABLE
			if (sioPredRollbackReady(sio)) {
				sioPredictConfirm(sio, (uint32_t) fastGot, (uint16_t) fastRemote, NULL, NULL);
			}
#endif
			sio->sioRemote = (uint16_t) (fastRemote & 0xFFFFu);
			completeMultiTransfer(sio, fastRemote, true, cyclesLate);
			return;
		}
		/* 【2026-11-16 20:0x 根因】拿不到本轮的新字时，**绝不能用
		 * sio->sioRemote 顶上去把这一轮"完成"掉**：那一轮没有消耗对端任何一个
		 * 字，而本端 sendCmdIndex/recvCmdIndex 照样前进一格 ⇒ 两端 8 字命令
		 * 窗口与校验和窗口从此错位，接下来 B 端必报 badChecksum(0x2000)
		 * 拆链。TR14 现场就是这条：A 端 ok=29184 而 pushIn=29116（68 轮是
		 * 凭空完成的），B 端 st=00002049。
		 * 正确语义是「这一轮就是还没完成」——落到下面的严格等待路径，
		 * 让模拟时钟停住等对端那个字。 */
		++sio->sioFastMiss;
		++sio->sioFallback;
		bool cmdGuard = false;
		/* CMD-GUARD：块交换期（state>=4 且 rem==0）无真字时本实现本就不复用
		 * sioRemote，记数供 diag 证明门在生效（mobile 侧此路径会挡下复用）。 */
		if (sioInCmdPhase(sio)) {
			++sio->sioCmdGuardRounds;
			++s_sioCmdGuard;
			cmdGuard = true;
		}
		/* 连续 240 轮（约 27 帧）一个新字都没拿到，说明对端停摆：解除
		 * 锁存，下一轮回到严格等待，不用越来越旧的字一直喂游戏。 */
		if (sio->sioFastMiss >= 240) {
			sio->sioFastLatched = false;
			sio->sioFastMiss = 0;
		}
		if (cmdGuard) {
			/* 【2026-11-18 ROOTCAUSE fix — "cmd 阶段永不启动 / intr 冻结"】
			 * 与 mobile 侧 mgba_mobile.c（提交 e5c3e3630）同批修复，三端语义对齐。
			 * 旧实现在这里「本轮不收尾」并落到下面最长 20s 的严格等待路径。
			 * 但 completeMultiTransfer 是**唯一**驱动游戏 SerialCB 的地方：
			 * 跳过它 ⇒ gLink.serialIntrCounter(intr) 冻结、DoSend 不再把下一
			 * 个命令字写进 SIOMLT_SEND、也就不再向对端 netLinkPush —— 而对端
			 * 要消费的正是这个字。于是两端在 cmd 期互相等对方推字，谁也不
			 * completeMultiTransfer，落到 40 次×100ms（乃至 20s）的严格等
			 * 待，远超过 cable club 的 600 帧(≈10s) TryLinkTimeout ⇒ rem 恒 0
			 * ⇒ linkup=6 ⇒ CloseLink。跨设备实测 cmdguard 从 0 涨到 1.75e6、
			 * intr 冻结、r00/r10 从无 0x2222/BBBB 块字，正是此因。
			 *
			 * 正确做法：**照常收尾**，但对端槽投递空字(0xFFFF)而不是陈旧字：
			 *  - gen8 ProcessRecvCmds 对 0xFFFF 没有任何 case，直接忽略 ⇒
			 *    不会把上一轮的旧 cmd 字喂进 8 字命令窗（CMD-GUARD 的本意）；
			 *  - 校验和拍由 CS_FORGE 覆写成本端 gLink.checksum ⇒ 不会 badChecksum；
			 *  - 游戏 SerialCB 照常推进 sc/rc/serialIntrCounter，时钟继续走、
			 *    本端继续推字，流水线重新流动；真字到达后下一拍自然消费。
			 * 这样既满足 CMD-GUARD「不复用陈旧字」，又不会把游戏状态机冻死。 */
			sio->sioWaiting = false;
			completeMultiTransfer(sio, 0, false, cyclesLate);
			return;
		}
		sio->sioWaiting = false;
	}
	/* ===== 档1 A 投机插入点：sioDoneEvent 严格取字/阻塞之前 =====
	 * 此处尚未 sioTakePeerWord，不冻结模拟时钟。优先级 真字>预测字>空字：
	 * 上面各路径（延迟线/COAST/快帧/CMD-GUARD）已消费真字或投空字并 return，
	 * 只有落到严格路径才尝试投机。预测字绝不写权威态，且经
	 * sioCompletePredictedTransfer 的写径拦截门。 */
#if MGBAX_ROLLBACK_ENABLE
	if (sioPredRollbackReady(sio) && !sio->sioRemoteIsPredicted) {
		MgbaxPredictIn pin;
		MgbaxPredictOut pout;
		memset(&pin, 0, sizeof(pin));
		pin.st       = (uint8_t) sioGLinkState(sio);
		pin.role     = (uint8_t) ((netLinkPlayer(sio->link) == 0) ? 0 : 1);
		pin.localId  = sio->sioIndex;
		pin.sc       = sio->sioBlockPhase;
		pin.seq      = sio->sioIndex;
		pin.ownWord  = sioWordOrEmpty(sio, sio->sioSelfSlot);
		pin.peerPrev = (uint16_t) sio->sioRemote;
		pin.phase    = gnpPredClassify(pin.st, pin.sc, pin.seq, pin.role == 0);
		if (sioPredictWord(sio, &pin, &pout) && sioPredHardGate(sio, &pin, &pout)) {
			sioPredictShadowPut(sio, pin.seq, pin.sc, &pout, pin.ownWord);
			sio->sioWaiting = false;
			sio->sioConnectSince = 0;
			sioCompletePredictedTransfer(sio, pout.word, cyclesLate);
			return;
		}
	}
#endif
	uint32_t remote = 0;
	uint16_t got = 0;
	uint32_t waitT0 = wallNowMs();
	bool haveRemote;
	if (sioConnectPollOn(sio)) {
		/* 握手期：先非阻塞取本轮字，取不到就重新调度 sioDone 让出模拟时间，
		 * 一轮累计超过 SIO_CONNECT_BUDGET_MS 才落回原来的阻塞等待。
		 * sioWaiting 全程保持 true，gbaLinkStart 不会重复起轮；重试计数
		 * sioRetries 也不在这里累加（那是「真超时」的口径）。 */
		haveRemote = sioTakePeerWord(sio, &remote, &got, 0);
		if (haveRemote) {
			++sio->sioConnectHits;
		} else {
			uint32_t now = wallNowMs();
			if (sio->sioConnectSince == 0) {
				sio->sioConnectSince = now;
			}
			struct mTiming* t2 = coreTiming(sio);
			if (t2 && (uint32_t) (now - sio->sioConnectSince) < SIO_CONNECT_BUDGET_MS) {
				++sio->sioConnectPolls;
				mTimingSchedule(t2, &sio->sioDone, SIO_CONNECT_POLL_CYCLES);
				return;   /* sioWaiting 保持 true */
			}
			++sio->sioConnectFallback;
			haveRemote = sioTakePeerWord(sio, &remote, &got,
			                             sioPipelineWaitMs(sio, (int) sio->sioIndex));
		}
	} else {
		haveRemote = sioTakePeerWord(sio, &remote, &got, sioPipelineWaitMs(sio, (int) sio->sioIndex));
	}
	if (!haveRemote && sio->link && (sio->sioOk & 0x3F) == 0) {
		int qn = 0; unsigned qh = 0;
		netLinkPeerHeadInfo(sio->link, &qn, &qh);
		SIO_LOG("MASTERMISS want=%u head=%u q=%d got=%d st=%04X pushIn=%u",
		        (unsigned) sio->sioIndex, qh, qn, got, netLinkState(sio->link),
		        (unsigned) netLinkPeerPending(sio->link));
	}
	{
		uint32_t dw = (uint32_t) (wallNowMs() - waitT0);
		sio->sioWaitSumMs += dw;
		++sio->sioWaitN;
		if (dw > sio->sioWaitMaxMs) {
			sio->sioWaitMaxMs = dw;
		}
	}
	/* 这里是每轮传输必经点：无条件打印会变成每帧上千行 IO，直接拖垮帧率。
	 * 只在「没拿到对端数据」或显式打开 MGBAX_SIO_TRACE 时才落日志。 */
	if (!haveRemote || getenv("MGBAX_SIO_TRACE")) {
		SIO_LOG("done want=%u have=%d got=%u retries=%u rtt=%u pending=%d",
		        (unsigned) sio->sioIndex, haveRemote ? 1 : 0, (unsigned) got,
		        (unsigned) sio->sioRetries, netLinkRttUs(sio->link), netLinkPeerPending(sio->link));
	}
	if (haveRemote) {
		if (got != sio->sioIndex) {
			/* 主机侧这个计数**恒为 0 是结构性的**：beginMultiTransfer 在起轮时
			 * 就 `++sioIndex` 并推出去，严格匹配要求 got==want，所以只有真错位
			 * 才会 +1。它不能和从机的 mis 放在一张表里比大小。 */
			++sio->sioMisorder;
		}
		sio->sioWaiting = false;
		sio->sioConnectSince = 0;   /* 本轮结束：下一轮重新给预算 */
		sio->sioHasRemote = true;
		/* 主机侧同样按从机随行的在飞槽号落格（见 sioFollowSyncIdx）。 */
		sioFollowSyncIdx(sio, remote);
#if MGBAX_ROLLBACK_ENABLE
		if (sioPredRollbackReady(sio)) {
			sioPredictConfirm(sio, (uint32_t) got, (uint16_t) remote, NULL, NULL);
		}
#endif
		sio->sioRemote = (uint16_t) (remote & 0xFFFFu);
		completeMultiTransfer(sio, remote, true, cyclesLate);
		return;
	}
	sio->sioTimeouts++;
	/* 对端还在线就继续等，别急着用空槽收尾：跨网时对端的字只是迟到（RTT
	 * 尖峰、手机切基站），不是没有。等待继续冻结模拟时钟，游戏看不见这段
	 * 时间；真机语义也一样——从机不回字，线路就不动。真正断线（state≠2）
	 * 或重试次数/墙钟上限耗尽才按「这一轮没有对端数据」收尾。
	 *
	 * 墙钟上限看的是**这一轮**累计等了多久：每轮等待窗现在能到 4s，光靠
	 * 40 次重试计数会变成 160s 的死等，一个僵死的对端就能把整帧按住不放。 */
	if (sio->sioRetries == 0) {
		sio->sioRetryWall = wallNowMs();
	}
	/* 【2026-11-18 H3 GEN8-PROTOCOL-TRUTH D2 — SIO IRQ 不得冻结】
	 * 原实现在「对端还在线」时把 sioWaiting 保持 true、把 sioDone 重调度
	 * 最多 40 次×100ms（墙钟上限 20s）后**不收尾**就返回。但
	 * completeMultiTransfer 是唯一驱动游戏 SerialCB、进而由
	 * GBASIOMultiplayerFinishTransfer（src/gba/sio.c:386-388）raise
	 * GBA_IRQ_SIO 的地方：跳过它 ⇒ gLink.serialIntrCounter 冻结（实测 sic=1）、
	 * DoSend 不再把下一个命令字写进 SIOMLT_SEND、也不再 netLinkPush，两端在
	 * 握手/cmd 期互等 ⇒ master 停在 state=2 ⇒ 600 帧 TryLinkTimeout ⇒ rem=0。
	 * sioWaiting 保持 true 时 gbaLinkWriteCnt/gbaLinkStart（:4931/:5009）还会
	 * 拒绝一切新 MULTI 起轮，死锁不可自愈。
	 *
	 * 修法：只给在飞字一个**短窗口**（最多 2 次×100ms，远小于 600 帧预算），
	 * 随后照常收尾——对端槽投递空字（haveRemote=false ⇒ data[peer]=0xFFFF，
	 * gen8 ProcessRecvCmds 没有对应 case 直接忽略，绝不复用陈旧 0x2222/B9A0；
	 * 校验和拍仍由 CS_FORGE 覆写）。这样每一轮都产生一次真实 SIO IRQ，游戏
	 * 状态机/轮次钟继续走，真字到达后下一轮自然消费。与 cmd 期 CMD-GUARD
	 * （:4600-4623）「照常收尾、投递空字」同契约。 */
	/* ROOTHUNT2 B7：战斗 controller 块期跳过在飞短窗，直接走到下方投空字收尾，
	 * 让真块字下一轮从严格入口消费；空字无 case + CS_FORGE 校验，不崩。 */
	if (!(battleRelayOn() && inBattleBlockRelay(sio)) &&
	    sio->link && netLinkState(sio->link) == 2 && sio->sioRetries < 2 &&
	    (uint32_t) (wallNowMs() - sio->sioRetryWall) < 200u) {
		++sio->sioRetries;
		struct mTiming* t2 = coreTiming(sio);
		if (t2) {
			mTimingSchedule(t2, &sio->sioDone, 100);
			return;
		}
	}
	sio->sioWaiting = false;
	sio->sioConnectSince = 0;
	completeMultiTransfer(sio, 0, false, cyclesLate);
}

static bool beginMultiTransfer(struct SioLink* sio, struct GBASIODriver* driver) {
	if (!sio->link || !sio->linkAttached || !sio->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return false;
	}
	/* 必须放在上面的模式判断之后：非 GBA 核（GB）也会进这个函数，
	 * 提前把 sio->core->board 当 GBA 结构体用会直接崩（表现为启动几秒后
	 * 进程退出、日志一行都没有）。 */
	sioResolveIwramDelta(sio);    /* 一次性：从 ROM 自解析 IWRAM 偏移 */
	sioResolveEwramDelta(sio); /* 一次性：从 ROM 自解析 EWRAM 偏移 */
	sioResolveCodeDelta(sio);     /* 一次性：从 ROM 自解析代码段 / 战斗窗口 */
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	/* §3.6 跨层角色接口：与 mobile 对称，每帧把 netLink 角色写进 gLink.link_field_F(0x00F)。
	 * gen8 CheckMasterOrSlave 具名门读它判主从（host=0→MASTER, join=1→SLAVE）。
	 * 治 mode A 两端皆 MASTER 死锁。只写保留字段、不造字/信任位。 */
	{
		uint32_t roleAddr = SIO_IW(0x03002AF4u) + 0x0Fu;
		uint32_t wIdx = (roleAddr - GBA_IWRAM_BASE) >> 2;
		uint32_t bShift = ((roleAddr - GBA_IWRAM_BASE) & 3u) * 8u;
		int role = netLinkPlayer(sio->link);   /* host=0, join=1 */
		gba->memory.iwram[wIdx] = (gba->memory.iwram[wIdx] & ~(0xFFu << bShift))
		                       | (((uint32_t) (role ? 1u : 0u)) << bShift);
		static unsigned roleDiag;
		if ((roleDiag++ & 0xFFF) == 0) {
			SIO_LOG("[ROLEDIAG] player=%d role=%d addr=0x%08X written=%u",
			        role, role ? 1 : 0, roleAddr, GBAView8(gba->cpu, roleAddr));
		}
	}
	/* BF1: 握手期(st<4)扣下游戏真写的 8FFF，供 data[0] 自回环。只读真字，非造字。 */
	if (sioMasterEchoOn()
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) < SIO_LINK_STATE_CONN
	    && local == LINK_HANDSHAKE_MASTER) {
		sio->sioMasterEchoWord = local;
	}
	sioCaptureBlockPhase(sio, gba);  /* V1：起轮捕获 sc，自槽/push 同相位同源 */
	sioCaptureBlockWord(sio, local, gba);  /* 方案2：9 拍里捕获真块字 sticky */
	/* 【唯一真源】本轮自身槽 = 本端真正推出去的字。放在这里是因为
	 * gbaLinkWriteCnt 里那两处捕获会被跳过（核心先 _startTransfer 把
	 * sioWaiting 置真，再调 writeSIOCNT），导致自槽停在 calloc 的 0，
	 * 而 DoHandshake 会因自槽是 0x0000 直接把 playerCount 清零。
	 * 同样地，别把 0xFFFF 当空槽推给对端（见 sioLastOwn 的注释）。 */
	if (local) {
		sio->sioLastOwn = local;
	} else if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u) {
		/* 【13:58 checksum 一致性】state>=4 时游戏 DoSend 主动写 0
		 *（sendQueue 空，gen8/link.c:2379），这是合法命令字。回退到
		 * sioLastOwn(握手字) 会让两端累加的 checksum 不同 ⇒ badChecksum。
		 * 保留 0，与游戏发送侧严格一致。握手期(state<4)仍回退。 */
		local = 0;
	} else {
		local = sio->sioLastOwn;
	}
	/* 【13:20 修正：主机自槽必须是主握手字】
	 * 现场（PUREBLOCK1/2/3）：从机能收到主机推的 0x8FFF，但主机自己的
	 * DoHandshake 数不出玩家 —— 因为 `value = handshakeAsMaster ? 8FFF :
	 * B9A0` 由游戏 DoSend 决定，而 DoSend 在读过 SIOMLT_SEND 之后才被我们
	 * 补位，本轮已经写成 B9A0 或 0，自槽于是落成 B9A0/FFFF；DoHandshake
	 * 要求 `tempRecvBuffer[0] == 0x8FFF`（gen8/src/link.c:2289），主机永远
	 * 过不了这一关。这里在**起轮那一刻**直接把本轮字定死成 0x8FFF：
	 * 自槽与 netLinkPush 用的是同一个 local，两端看到的主机字因此一致。 */
	/* 【13:34 回退到 state==2】PUREBLOCK8 用 `state<4` 反而一次都到不了
	 * CONN_ESTABLISHED：把 state=0/1（链路未起）和 state=3（主机 INIT_TIMER）
	 * 也纳入强制，破坏了主机从 3 迈向 4 的迁移。回到已验证有效的 `state==2`：
	 * PUREBLOCK6 用它拿到 5 次 `lstate=4 pc=2`。 */
	if (sioForceHandshake() && !sioInBattleStartup(sio)
	    && netLinkPlayer(sio->link) == 0
	    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) == 2u) {
		local = LINK_HANDSHAKE_MASTER;
	}
	/* 【ROOTHUNT CMD-HANDOFF】state>=4 的残留握手字(8FFF/B9A0)绝不能出网：
	 *  - APPHUNT-A2 XFER#15 主机(st=4)残留 B9A0 ⇒ 从机回显 B9A0 ⇒
	 *    XFER#16 own=2222 peer=B9A0 ⇒ checksum 错(0x2000) ⇒ CloseLink；
	 *  - RH-FIX4 实测主机残留在 SIOMLT_SEND 的 8FFF 持续把从机的
	 *    sioWordOrEmpty 保持点亮 ⇒ 从机 0xBBBB 块首被 B9A0 顶掉 ⇒
	 *    master 永远收不到块 ⇒ rem=0。
	 * gen8 在 state4 的 DoSend 只会写命令字/块字/0，不会写握手字。
	 * 自槽校验由下面的 CS_FORGE（去掉 haveRemote 门）保证。 */
	if (GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u
	    && sioIsHandshakeWord(local)) {
		if (rhVerbose()) {
			SIO_LOG("[RHCMDSEEN] master suppress stale handshake local=%04X -> 0000 ok=%u",
			        (unsigned) local, (unsigned) sio->sioOk);
		}
		local = 0;
	}
	/* state>=4 时 0 是合法命令字（DoSend 空队列写 0），必须原样投递，
	 * 不能变成 0xFFFF —— 否则 checksum 两端不一致（见上方 13:58 注）。 */
	sio->sioSelfSlot = sioBlockOutWord(sio,
	    (local || GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= SIO_LINK_STATE_CONN)
	    ? local : 0xFFFFu, false, gba);  /* 方案2：selfSlot 与 push 帧字同源 */
	static unsigned beginN;
	if (++beginN <= 12 || (beginN % 3000) == 0) {
		fprintf(stderr, "BEGIN n=%u me=%d mode=%d idx=%u cb=%04X%04X\n",
		        beginN, netLinkPlayer(sio->link), (int) driver->p->mode,
		        (unsigned) sio->sioIndex,
		        GBAView16(gba->cpu, SIO_IW(0x03002AD6u)), GBAView16(gba->cpu, SIO_IW(0x03002AD4u)));
	}
	++sio->sioIndex;
	sio->sioWaiting = true;
	sio->sioRetries = 0;
	/* 本轮由主机起轮（日志 mst=1）。从机永不进这里，所以 mst 是「主机轮次钟
	 * 有没有在走」的直接证据，与 role 相互独立。 */
	sio->sioRoundMaster = true;
	struct mTiming* timing = coreTiming(sio);
	if (!timing) {
		return false;
	}
	sio->sioStartCycle = mTimingCurrentTime(timing);
	/* 1P generates the clock, and by the time it writes SIOCNT the game has
	 * already written this round's word into SIOMLT_SEND - so push it once,
	 * here. Pushing again for the same round would fill the next round's slot
	 * with a stale value and desync the pairing by one. */
	bool delayExtra = false;
	uint16_t pushLabel = sioDelayNextPushLabel(sio, &delayExtra);
	sio->sioRoundLabel = pushLabel;
	{
		static unsigned nzN;
		if (rhVerbose() && local != 0u
		    && GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) >= 4u && nzN < 120) {
			++nzN;
			SIO_LOG("[RHPUSHNZ] n=%u me=%d idx=%u local=%04X state=%u sc=%u",
			        (unsigned) sio->sioOk, netLinkPlayer(sio->link), (unsigned) sio->sioIndex,
			        (unsigned) local,
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF),
			        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDCMD_IX_OFF));
		}
	}
	if (rhVerbose() && (sio->sioOk <= 40 || (sio->sioOk % 256) == 0)) {
		SIO_LOG("[RHPUSH] n=%u me=%d idx=%u lbl=%u local=%04X pushWord=%04X state=%u sqc=%u pq=%d",
		        (unsigned) sio->sioOk, netLinkPlayer(sio->link), (unsigned) sio->sioIndex,
		        (unsigned) pushLabel, (unsigned) local,
		        (unsigned) sioWordOrEmpty(sio, local),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_SENDQ_CNT_OFF),
		        netLinkPeerPending(sio->link));
	}
	if (!sio->sioPushed || sio->sioPushIndex != pushLabel) {
		/* 【16:48 checksum 同源】必须与 sioSelfSlot 用同一个 sioWordOrEmpty：
		 * state>=4 且 local==0（DoSend 空队列写 0）时，自槽是 0，这里若推
		 * 0xFFFF，两端 8 轮累加和就不等 → badChecksum(0x2000)。 */
		uint16_t pushWord = sioWordOrEmpty(sio, sioBlockOutWord(sio, local, true, gba));  /* 方案2：逐字推真块帧 */
		/* 主机的 9 拍索引用 local 的高 16 位随行（见 sioPackPush）。 */
		uint32_t pushPayload = sioOutboundPayload(sio, pushWord);
		netLinkPush(sio->link, GBA_SIO_MULTI, pushPayload, pushLabel, sio->sioStartCycle);
		sio->sioPushValue = local;
		sio->sioPushIndex = pushLabel;
		sio->sioPushed = true;
		if (delayExtra) {
			/* 预热影子标签：标签连续（pushLabel+1）、值相同，只为把对端队列
			 * 垫到 N 深；两端都这么做，偏移因此在 state>=4 之前就固化成 N。 */
			netLinkPush(sio->link, GBA_SIO_MULTI, pushPayload,
			            (uint16_t) (pushLabel + 1), sio->sioStartCycle);
		}
	}
	mTimingDeschedule(timing, &sio->sioDone);
	/* The transfer period must be computed at 115200 baud (5755 cycles): the
	 * core's SIOCNT write clears the baud bits (63427 cycles at baud 0),
	 * which starves the game's 9-rounds-per-frame requirement and makes it
	 * report a communication error. */
	uint16_t siocnt = (uint16_t) ((driver->p->siocnt & ~0x0003u) | 0x0003u);
	mTimingSchedule(timing, &sio->sioDone, GBASIOTransferCycles(GBA_SIO_MULTI, siocnt, gbaLinkDevices(driver)));
	return true;
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	sio->linkEvent.context = sio;
	sio->linkEvent.callback = linkPollEvent;
	sio->linkEvent.name = "Qt Link";
	sio->linkEvent.priority = 0x70;
	sio->sioDone.context = sio;
	sio->sioDone.callback = sioDoneEvent;
	sio->sioDone.name = "Qt SIO Done";
	sio->sioDone.priority = 0x7F;
	sio->sioSlaveDone.context = sio;
	sio->sioSlaveDone.callback = sioSlaveDoneEvent;
	sio->sioSlaveDone.name = "Qt SIO Slave Done";
	sio->sioSlaveDone.priority = 0x7E;
	sio->sioSlavePeriod = 18363;
	sio->sioSelfSlot = 0xFFFFu;   /* 合法空槽；0 会让对端 playerCount 归零 */
	sio->sioSlaveArmed = false;
	sio->sioPeerCyclesValid = false;
	armLinkEvent(sio);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct mTiming* timing = coreTiming(sio);
	sio->sioWaiting = false;
	sio->sioSlaveArmed = false;
	sio->sioPeerCyclesValid = false;
	if (timing) {
		mTimingDeschedule(timing, &sio->linkEvent);
		mTimingDeschedule(timing, &sio->sioDone);
		mTimingDeschedule(timing, &sio->sioSlaveDone);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	sio->sioWaiting = false;
	/* After a reset the game re-decides master/slave, so the "alone on the
	 * bus" presentation window reopens. */
	sio->sioInitSeen = false;
	sio->sioSelfSlot = 0xFFFFu;
	armLinkEvent(sio);
}

static uint32_t gbaLinkId(const struct GBASIODriver* driver) {
	UNUSED(driver);
	return 0x4C4B4E41u;
}

#if MGBAX_ROLLBACK_ENABLE
/* PC 侧 diag 保真回调（对偶共享 C mgba_mobile.c）：写快照不写 live；
 * 偏移由 mCoreStateEwramOffset() 给出（offsetof(wram)+diag 定点偏移）。 */
static void sioDiagPreserveCb(void* vfp, void* ud) {
	struct SioLink* sio = (struct SioLink*) ud;
	struct VFile* vf = (struct VFile*) vfp;
	struct NgLatch* L;
	size_t off;
	uint8_t snapSeq[4];
	if (!sio || !vf || !sio->sioNgLatch.valid) { return; }
	L = &sio->sioNgLatch;
	off = mCoreStateEwramOffset();
	/* VFile.map(vf,size,flags) 无 offset 参数（vfs.h:46，恒从文件 0 映射），
	 * 不可用 map 做定点写：否则会把 latch 写进快照头 64B 并破坏 savestate。
	 * 改用 seek+read 取单调判据 → seek+write 定点覆盖 diag 区。 */
	if (vf->seek(vf, (off_t) (off + GNP_OFF_NG_SEQ), SEEK_SET) < 0) { goto done; }
	if (vf->read(vf, snapSeq, sizeof(snapSeq)) != (ssize_t) sizeof(snapSeq)) { goto done; }
	/* 单调：latch.seq 小于快照内 seq 时绝不回写（回滚不得卷回 diag/信任位）。 */
	if (L->seq < gnpNgRead32(snapSeq)) { goto done; }
	if (vf->seek(vf, (off_t) off, SEEK_SET) < 0) { goto done; }
	(void) vf->write(vf, L->diag, GNP_NG_DIAG_SIZE);
done:
	(void) vf->seek(vf, 0, SEEK_SET);   /* 还原游标，勿动 stateSize 之后的 extdata */
}

/* restore 后只 PEEK 复核（零写 live）：回滚若把 diag 卷旧了只记日志，不修游戏态。 */
static void sioDiagVerifyCb(void* vfp, void* ud) {
	struct SioLink* sio = (struct SioLink*) ud;
	struct NgLatch* L;
	uint8_t diag[GNP_NG_DIAG_SIZE];
	unsigned i;
	(void) vfp;
	if (!sio || !sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) { return; }
	L = &sio->sioNgLatch;
	if (!L->valid) { return; }
	{
		struct GBA* gba = (struct GBA*) sio->core->board;
		uint32_t addr = (uint32_t) GNP_DIAG_EW;
		if (!gba || !gba->cpu || !gnpAbsEwOk(addr, GNP_NG_DIAG_SIZE)) { return; }
		for (i = 0u; i < GNP_NG_DIAG_SIZE; ++i) {
			diag[i] = (uint8_t) GBAView8(gba->cpu, addr + i);
		}
	}
	if (gnpNgRead32(diag + GNP_OFF_NG_SEQ) < L->seq) {
		SIO_LOG("[RB] rollback rolled back diag seq (live=%u latch=%u) — no live write",
		        (unsigned) gnpNgRead32(diag + GNP_OFF_NG_SEQ), (unsigned) L->seq);
	}
}

/* GBALoadState 内 mTimingClear() 摘掉 linkEvent/sioDone/sioSlaveDone，
 * 但 sioWaiting/sioSlaveArmed 仍 true ⇒ serviceLink 守卫永假、链路不重挂。
 * 三处 restore 后统一调用（mobile 侧对偶 mobileSioRearmAfterLoad）。 */
static void sioSioRearmAfterLoad(struct SioLink* sio) {
	struct mTiming* timing;
	if (!sio) { return; }
	timing = coreTiming(sio);
	sio->sioSlaveArmed = false;
	sio->sioRoundWordValid = false;
	if (timing) {
		mTimingDeschedule(timing, &sio->sioSlaveDone);
		mTimingDeschedule(timing, &sio->sioDone);
	}
	if (sio->linkAttached && sio->linkEvent.callback) {
		armLinkEvent(sio);
	}
}
#endif /* MGBAX_ROLLBACK_ENABLE */

static bool gbaLinkLoadState(struct GBASIODriver* driver, const void* state, size_t size) {
	struct GbaLinkDriver* d = (struct GbaLinkDriver*) driver;
	UNUSED(state);
	UNUSED(size);
#if MGBAX_ROLLBACK_ENABLE
	/* re-arm 只受编译门约束，与预测 runtime env/setter 解耦：
	 * compile=1 但 env=0 时 restore 仍须补回 mTimingClear 摘掉的链路事件。 */
	if (d && d->sio) {
		sioSioRearmAfterLoad(d->sio);
	}
#else
	UNUSED(d);
#endif
	return true;
}

static void gbaLinkSaveState(struct GBASIODriver* driver, void** state, size_t* size) {
	struct GbaLinkDriver* d = (struct GbaLinkDriver*) driver;
	UNUSED(driver);
	*state = NULL;
	*size = 0;
#if MGBAX_ROLLBACK_ENABLE
	/* 同上：回调注册只受编译门约束；latch 未采样时回调自身 no-op，零副作用。 */
	if (d && d->sio) {
		gnpRewindSetDiagPreserve(sioDiagPreserveCb, d->sio);
		gnpRewindSetDiagVerify(sioDiagVerifyCb, d->sio);
	}
#else
	UNUSED(d);
#endif
}

static void gbaLinkSetMode(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	UNUSED(mode);
}

static bool gbaLinkHandles(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	return mode == GBA_SIO_MULTI || mode == GBA_SIO_NORMAL_8 || mode == GBA_SIO_NORMAL_32;
}

static int gbaLinkDevices(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	/* 对端数（不含自己）。两人联机是 1：内核据此用 2P 的传输周期，填 2 会按
	 * 3P 算、比真机慢 50%，超出游戏的超时窗口。
	 *
	 * 3/4 人总线必须按实际人数上报：一直返回 1 会让每一轮都按 2P 的周期算，
	 * 比真机的 3P/4P 周期短，游戏数出来的每帧轮次数就不对了。 */
	if (sio && netLinkBusActive(sio->link)) {
		int players = netLinkBusPlayers(sio->link);
		if (players > 2) {
			return players - 1;
		}
	}
	return 1;
}

static int gbaLinkDeviceId(struct GBASIODriver* driver) {
	return netLinkPlayer(((struct GbaLinkDriver*) driver)->sio->link);
}

static uint16_t gbaLinkWriteCnt(struct GBASIODriver* driver, uint16_t value) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	/* §3.6 跨层角色接口：每个 MULTI 写都刷 gLink.link_field_F(0x00F) = netLinkPlayer
	 * （host=0→MASTER, join=1→SLAVE）。从机起轮走这里而非 beginMultiTransfer，
	 * 必须在此写才能让 gen8 CheckMasterOrSlave 读到真角色。只写保留字段、不造字。 */
	if (driver->p && driver->p->mode == GBA_SIO_MULTI && sio->core
	    && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) sio->core->board;
		uint32_t roleAddr = SIO_IW(0x03002AF4u) + 0x0Fu;
		uint32_t wIdx = (roleAddr - GBA_IWRAM_BASE) >> 2;
		uint32_t bShift = ((roleAddr - GBA_IWRAM_BASE) & 3u) * 8u;
		int role = netLinkPlayer(sio->link);
		g->memory.iwram[wIdx] = (g->memory.iwram[wIdx] & ~(0xFFu << bShift))
		                       | (((uint32_t) (role ? 1u : 0u)) << bShift);
	}
	static int wrDbg = 0;
	if (wrDbg < 12) {
		++wrDbg;
		SIO_LOG("writeCnt %04X mode=%d", value, driver->p ? (int) driver->p->mode : -1);
	}
	if (driver->p && driver->p->mode == GBA_SIO_MULTI) {
		/* The core only treats SIOCNT bit7 (Busy) rising as "start transfer",
		 * but Pokemon-family link code starts a MULTI transfer by writing
		 * 0x600F (IRQ set, Busy left to the hardware). Treat an IRQ-bit write
		 * with no transfer pending as a start request too - the !sioWaiting
		 * guard keeps one transfer from being started twice. */
		bool nowBusy = (value & 0x0080) != 0;
		bool irq = (value & 0x4000) != 0;
		bool wantStart = nowBusy || (irq && !sio->sioWaiting);
		if (wantStart && (sio->sioOk & 0x3F) == 0) {
			SIO_LOG("WRITECNT me=%d busy=%d irq=%d waiting=%d want=%d st=%04X mltsend=%04X",
			        netLinkPlayer(sio->link), (int) nowBusy, (int) irq,
			        (int) sio->sioWaiting, (int) wantStart, netLinkState(sio->link),
			        sio->core ? ((struct GBA*) sio->core->board)->memory.io[GBA_REG(SIOMLT_SEND)] : 0);
		}
		if (wantStart) {
			if (!sio->sioWaiting && netLinkPlayer(sio->link) == 0) {
				/* Only 1P actually starts the transfer; the slave's round is
				 * driven by 1P's push (see serviceLink/sioSlaveDoneEvent). */
				beginMultiTransfer(sio, driver);
			}
			else if (!sio->sioWaiting && netLinkPlayer(sio->link) != 0) {
				/* 从机起轮：此刻 SIOMLT_SEND 里就是本轮要发出去的字，扣下来
				 * 独占给本轮（见 sioRoundWord 注释）。 */
				if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
					struct GBA* g = (struct GBA*) sio->core->board;
					sio->sioRoundWord = g->memory.io[GBA_REG(SIOMLT_SEND)];
					sioCaptureBlockPhase(sio, g);  /* V1：从机起轮捕获 sc，自槽/push 同相位同源 */
					sioCaptureBlockWord(sio, sio->sioRoundWord, g);  /* 方案2：9 拍里捕获真块字 */
					/* 【13:23 修正：从机自槽必须是从握手字】
					 * 现场（PUREBLOCK4）：主机收到从机槽 = 0x4CF8，而
					 * gen8 link.c:2281-2284 规定「槽里出现既不是握手字也
					 * 不是 0xFFFF 的字 ⇒ playerCount 立刻清零」，于是主机
					 * 永远 pc=0、握手永远差最后一步。握手期从机的唯一合法
					 * 自槽值就是 SLAVE_HANDSHAKE(0xB9A0)，这里直接定死。
					 * 【13:30 收紧】仅在 CONN(0x40) 未置位时生效，避免握手
					 * 成功后继续覆盖 LINKCMD/块数据（同主机侧理由）。 */
					if (sioForceHandshake()
					    && GBAView8(g->cpu, SIO_IW(SIO_GLINK_STATE) + SIO_GLINK_STATE_OFF) == 2u) {
						sio->sioRoundWord = LINK_HANDSHAKE_SLAVE;
					}
					sio->sioRoundWordValid = true;
				}
			}
		}
		uint16_t out = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
		/* Baud fix: the core's GBASIOWriteSIOCNT MULTI branch clears the baud
		 * bits and only glues back bits 2..7, leaving GBASIOMultiplayerGetBaud
		 * at 0 (63427 cycles per transfer instead of 5755 at 115200). The
		 * game's LinkVSync requires 9+ SIO interrupts per frame; at baud 0
		 * the master only manages 3.7 and every link ends in "communication
		 * error". Restore 115200 (the game's own EnableSerial writes 0x6003,
		 * baud 3, anyway). */
		out = (uint16_t) ((out & ~0x0003u) | 0x0003u);
		/* Terminal bits (Slave bit2 / Ready bit3 / Id bits4-5): the core's
		 * `value |= sio->siocnt & 0x00FC` makes them sticky, so the driver
		 * rewrites them from the link's true state every time:
		 *   not connected -> alone on the bus -> Slave=1;
		 *   connected as 0 -> Slave=0 (master);
		 *   connected as 1..3 -> Slave=1. */
		if (sio->linkAttached && sio->link) {
			int me = netLinkPlayer(sio->link);
			bool up = netLinkState(sio->link) == 2;
			bool slave = !up || me != 0;
			out = GBASIOMultiplayerSetSlave(out, slave);
			out = GBASIOMultiplayerSetId(out, up ? me : 0);
		}
		return out;
	}
	if (driver->p && (driver->p->mode == GBA_SIO_NORMAL_8 || driver->p->mode == GBA_SIO_NORMAL_32)) {
		return GBASIONormalFillSi(value);
	}
	return value;
}

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver* driver, uint16_t value) {
	UNUSED(driver);
	return value;
}

static bool gbaLinkStart(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	if (!sio->link || !sio->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return true;
	}
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return true;
	}
	if (sio->sioWaiting) {
		/* Pokemon starts a transfer with two SIOCNT writes (0x600F then Busy):
		 * beginMultiTransfer already ran on the first one, re-beginning would
		 * overwrite the reply sequence. */
		return false;
	}
	if (netLinkPlayer(sio->link) != 0) {
		/* The slave does not start on Busy either; its round is driven by 1P. */
		return true;
	}
	if (!beginMultiTransfer(sio, driver)) {
		return true;
	}
	/* Completion belongs to this driver (network reply arrives -> write
	 * SIOMULTI + raise the SIO interrupt). */
	return false;
}

/* Only called without a peer connected (core's default scheduling): finish
 * with the last known peer data; a transfer must never wait on the network
 * here. */
static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	data[0] = data[1] = data[2] = data[3] = 0xFFFF;
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (sio->sioHasRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) sio->sioRemote;
	}
}

static uint8_t gbaLinkFinish8(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
	uint32_t remote = 0xFFu;
	/* 不能重试：重发 REQ 会让对端的请求队列多出一轮、双方向量错位。等待窗
	 * 自适应 RTT（见 sioWaitMs），跨网尖峰时宁可慢不可错。 */
	netLinkExchange(sio->link, GBA_SIO_NORMAL_8, local, &remote, sioWaitMs(sio));
	/* GBA 的 normal 模式是半双工**数据交换**：本端这次传输读到的「对端值」
	 * = 对端**上一次传输**发来的那个字，而不是对本请求的 ACK 回显。
	 * link_net 的自动 ACK 带的是对端自己 published 的值（对端还没发过就是 0）
	 * ⇒ 实测 remote 恒为 0x00000000（PA11）。⇒ 用 finishIncoming() 记下的
	 * 「对端最近发来的字」覆盖 ACK 值。 */
	if (sio->sioPeerLastValid) {
		remote = sio->sioPeerLastValue;
	}
	++s_sioN8;
	if (s_sioN8 <= 20 || (s_sioN8 % 64) == 0) {
		SIO_LOG("N8 n=%u local=%02X remote=%02X idx=%u state=%d pc=%u",
		        (unsigned) s_sioN8, (unsigned) local, (unsigned) remote,
		        (unsigned) sio->sioIndex, netLinkState(sio->link),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u));
	}
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(sio->link, GBA_SIO_NORMAL_32, local, &remote, sioWaitMs(sio));
	/* 同 gbaLinkFinish8()：GBA normal 模式的「对端值」是对端上一次发来的字。 */
	if (sio->sioPeerLastValid) {
		remote = sio->sioPeerLastValue;
	}
	++s_sioN32;
	if (s_sioN32 <= 20 || (s_sioN32 % 64) == 0) {
		SIO_LOG("N32 n=%u local=%08X remote=%08X idx=%u state=%d pc=%u",
		        (unsigned) s_sioN32, (unsigned) local, (unsigned) remote,
		        (unsigned) sio->sioIndex, netLinkState(sio->link),
		        (unsigned) GBAView8(gba->cpu, SIO_IW(0x03002AF4u) + 0x03u));
	}
	return remote;
}

/* Rewrite the SIOCNT terminal bits (Slave/Ready/Id) from the link's real
 * state. The game reads SIOCNT every frame in HANDSHAKE to pick master/slave
 * but writes it only in a few places, so besides the per-write fixup the
 * register must be corrected when the link state changes. Never touch 0x2000
 * (MULTI mode bit): the core switches modes only on mode-bit changes, and
 * setting it early would swallow the game's first MULTI write. */
static void applyLinkTerminalBits(struct SioLink* sio) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	bool up = sio->link && netLinkState(sio->link) == 2;
	uint16_t siocnt = gba->sio.siocnt;
	uint16_t want = siocnt;
	want = GBASIOMultiplayerSetSlave(want, !up || me != 0);
	want = GBASIOMultiplayerSetId(want, up ? me : 0);
	want = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(want));
	want = (uint16_t) ((want & ~0x0003u) | 0x0003u); /* restore 115200 baud */
	if (want != siocnt) {
		gba->sio.siocnt = want;
	}
}

static void prepareGbaDriver(struct SioLink* sio) {
	struct GBASIODriver* d = &sio->gbaLink.d;
	memset(d, 0, sizeof(*d));
	sio->gbaLink.sio = sio;
	d->init = gbaLinkInit;
	d->deinit = gbaLinkDeinit;
	d->reset = gbaLinkReset;
	d->driverId = gbaLinkId;
	d->loadState = gbaLinkLoadState;
	d->saveState = gbaLinkSaveState;
	d->setMode = gbaLinkSetMode;
	d->handlesMode = gbaLinkHandles;
	d->connectedDevices = gbaLinkDevices;
	d->deviceId = gbaLinkDeviceId;
	d->writeSIOCNT = gbaLinkWriteCnt;
	d->writeRCNT = gbaLinkWriteRcnt;
	d->start = gbaLinkStart;
	d->finishMultiplayer = gbaLinkFinishMulti;
	d->finishNormal8 = gbaLinkFinish8;
	d->finishNormal32 = gbaLinkFinish32;
}

static void attachLink(struct SioLink* sio) {
	if (!sio->core || sio->linkAttached || netLinkState(sio->link) != 2) {
		return;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) sio->core->board;
		int me = netLinkPlayer(sio->link);
		prepareGbaDriver(sio);
		GBASIOSetDriver(&gba->sio, &sio->gbaLink.d);
		/* The game may already be in HANDSHAKE before the driver was attached
		 * (its CheckMasterOrSlave would read the stale no-driver SIOCNT with
		 * Slave=1); rewrite the terminal bits right here so the game
		 * re-decides next frame. Never include 0x2000 (MULTI mode bit) - see
		 * applyLinkTerminalBits. */
		applyLinkTerminalBits(sio);
		sio->linkAttached = true;
		SIO_LOG("LAN link attached as P%d, SIOCNT %04X", me + 1, gba->sio.siocnt);
	}
	if (sio->linkAttached) {
		sio->sioOk = 0;
		sio->sioPeak = 0;
		sio->sioWaitSumMs = 0;
		sio->sioWaitMaxMs = 0;
		sio->sioWaitN = 0;
		sio->sioTimeouts = 0;
		sio->sioFallback = 0;
		sio->sioWaiting = false;
		sio->sioBusyCycle = 0;
		sio->sioIndex = 0;
		sio->sioPushed = false;
		sio->sioPushValue = 0;
		sio->sioPushIndex = 0;
		sio->sioMisorder = 0;
		sio->sioHasRemote = false;
		sio->sioInitSeen = false;
		sio->sioMasterEchoWord = 0;   /* BF1: 全局 reset 清 echo word，防跨会话残留(与 mobile 对偶) */
		/* 新会话：上一局遗留的对端字不能进快帧补槽。 */
		sio->sioFastLast = 0;
		sio->sioFastLastValid = false;
		sio->sioFastLatched = false;
		sio->sioFastMiss = 0;
		sio->sioFastAlignBlocked = 0;
		sio->sioCmdGuardRounds = 0;
		sio->sioCmdFrameAligned = false;
		sio->sioLastAlignHeader = 0;
		/* 新会话：延迟线的标签计数/锚定也必须归零，否则上一局的标签会
		 * 让本局的消费链从半截开始（两端不同步 ⇒ 校验和错）。 */
		sio->sioDelayProd = 0;
		sio->sioDelayWant = 0;
		sio->sioDelayAnchored = false;
		sio->sioDelayPrefill = false;
		sio->sioDelayWaits = 0;
	}
}

static void detachLink(struct SioLink* sio) {
	if (!sio->linkAttached || !sio->core) {
		sio->linkAttached = false;
		return;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) sio->core->board)->sio, NULL);
	}
	sio->linkAttached = false;
	sio->sioInitSeen = false;
}

static void pollLink(struct SioLink* sio) {
	if (!sio->link) {
		return;
	}
	bool up = netLinkState(sio->link) == 2;
	/* A core reset clears the GBA struct's sio.driver while linkAttached
	 * stays true - without this check the driver would never be re-attached
	 * and the game would hang on the link wait screen forever. */
	bool drvOk = false;
	if (up && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		drvOk = ((struct GBA*) sio->core->board)->sio.driver == &sio->gbaLink.d;
	}
	if (up && sio->core && sio->core->platform(sio->core) != mPLATFORM_GBA) {
		/* Game changed to a non-GBA ROM: drop the session. */
		if (sio->linkAttached) {
			detachLink(sio);
		}
		return;
	}
	if (up && (!sio->linkAttached || !drvOk)) {
		sio->linkAttached = false;
		attachLink(sio);
	} else if (!up && sio->linkAttached) {
		detachLink(sio);
	}
}

// ---- public API ----

struct SioLink* sioLinkCreate(void) {
	struct SioLink* sio = (struct SioLink*) calloc(1, sizeof(struct SioLink));
	if (!sio) {
		return NULL;
	}
	sio->link = netLinkCreate();
	if (!sio->link) {
		free(sio);
		return NULL;
	}
	sio->sioSlavePeriod = 18363;
	/* 机器可读启动诊断：两端各自打一行，跨设备日志据此确认默认值一致。
	 * 见 ENV-REGISTRY D1 / ADR-003 §4.2(h)。 */
	{
		const char* v = getenv("MGBAX_LINK_REARM");
		SIO_LOG("[MGBAX_GATE] rearm_default=%s (MGBAX_LINK_REARM=%s)",
		        rearmEnabledFromEnv() ? "ON" : "OFF", v ? v : "<unset>");
	}
	/* RACE_STRESS 压测门：PC no-op readback（三端门名同值/可观测，不注入延时）。 */
	sioRaceStressReadback();
	return sio;
}

void sioLinkDestroy(struct SioLink* sio) {
	if (!sio) {
		return;
	}
	sioLinkClose(sio);
	netLinkDestroy(sio->link);
	free(sio);
}

uint32_t sioLinkRttUs(const struct SioLink* sio) {
	if (!sio) {
		return 0;
	}
	return netLinkRttUs(sio->link);
}

void sioLinkPeerStats(const struct SioLink* sio, uint32_t* stale, uint32_t* drops) {
	if (!sio) {
		if (stale) {
			*stale = 0;
		}
		if (drops) {
			*drops = 0;
		}
		return;
	}
	netLinkPeerStats(sio->link, stale, drops);
}

int sioLinkPeerPending(const struct SioLink* sio) {
	if (!sio) {
		return 0;
	}
	return netLinkPeerPending(sio->link);
}

const void* sioLinkHandle(const struct SioLink* sio) {
	if (!sio) {
		return NULL;
	}
	return sio->link;
}

bool sioLinkHost(struct SioLink* sio, int port) {
	return sioLinkHostPlayers(sio, port, 2);
}

/* players：本局人数。2 走原来的两人直连；3/4 走星型总线（主机 accept 多个
 * 从机、每轮收齐后广播）。旧的两参数入口一律按 2 人处理，行为不变。 */
bool sioLinkHostPlayers(struct SioLink* sio, int port, int players) {
	if (!sio || !sio->link) {
		return false;
	}
	if (players < 2) {
		players = 2;
	}
	return netLinkBusHost(sio->link, port, players);
}

/* 进程内总线版本（同进程 N 核）：仅诊断 / N 核本机回环用，语义同上面。 */
bool sioLinkHostPlayersLocal(struct SioLink* sio, int key, int players) {
	if (!sio || !sio->link) {
		return false;
	}
	/* 【path B / 2P 钳位】默认保持原 3 下限（不动已验证行为）；独立门开启时
	 * 用具名下限 2，让 2P 房按真实人数铺总线（PB15）。 */
	int minPlayers = sioLocalBus2pOn() ? (int) MGBAX_LOCALBUS_MIN_PLAYERS : 3;
	if (players < minPlayers) {
		players = minPlayers;
	}
	return netLinkBusHostLocal(sio->link, key, players);
}

bool sioLinkJoinPlayersLocal(struct SioLink* sio, int key) {
	if (!sio || !sio->link) {
		return false;
	}
	return netLinkBusJoinLocal(sio->link, key);
}

bool sioLinkJoinPlayersLocalSlot(struct SioLink* sio, int key, int slot) {
	if (!sio || !sio->link) {
		return false;
	}
	return netLinkBusJoinLocalSlot(sio->link, key, slot);
}

bool sioLinkJoin(struct SioLink* sio, const char* host, int port) {
	return sioLinkJoinPlayers(sio, host, port, 2);
}

/* players 必须和主机一致：总线和两人直连用的是不同的包格式，TCP 层能连上
 * 但一个包都解不出来（总线是定长 BusPacket，两人是 struct Packet）。 */
bool sioLinkJoinPlayers(struct SioLink* sio, const char* host, int port, int players) {
	if (!sio || !sio->link || !host) {
		return false;
	}
	if (players > 2) {
		return netLinkBusJoin(sio->link, host, port);
	}
	return netLinkJoin(sio->link, host, port);
}

void sioLinkClose(struct SioLink* sio) {
	if (!sio || !sio->link) {
		return;
	}
	if (sio->linkAttached && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) sio->core->board)->sio, NULL);
	}
	sio->linkAttached = false;
	netLinkClose(sio->link);
}

int sioLinkState(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return 0;
	}
	return netLinkState(sio->link);
}

int sioLinkPlayer(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return -1;
	}
	return netLinkPlayer(sio->link);
}

/* 本局目标人数（含自己）。总线模式下是房主开房时定的人数，两人直连是 2。
 * 注意这不是「已经接入的人数」—— 总线的槽位是逐个接入的，界面要判断「还差
 * 几个人」得看 netLinkBusPlayers。 */
int sioLinkPlayerCount(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return 2;
	}
	if (netLinkBusActive(sio->link)) {
		int n = netLinkBusPlayers(sio->link);
		if (n > 2) {
			return n;
		}
	}
	return 2;
}

void sioLinkStatusText(const struct SioLink* sio, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (sio && sio->link) {
		netLinkStatusText(sio->link, out, outLen);
	}
}

void sioLinkPump(struct SioLink* sio, struct mCore* core) {
	if (!sio) {
		return;
	}
	sio->core = core;
	/* 【path B 必须】IWRAM/EWRAM 偏移解析必须挂在 Qt 帧循环无条件调用处。
	 * 原来挂在 linkPollEvent（mTiming 事件）与 beginMultiTransfer：path B
	 * 下可见核**不产生 SIO 轮次**（mu=0），这两个入口都不触发 ⇒ 解析
	 * 永远不执行 ⇒ 所有探针读错地址（实测 B 端 linkup=255 / cb=0 /
	 * 无 SIOROM 日志），误判成"B 端握手没完成"。A 端偶然跑过一次 SIO
	 * 才解析成功，造成两端假性不对称。 */
	sioResolveIwramDelta(sio);
	sioResolveEwramDelta(sio);
	sioResolveCodeDelta(sio);
	/* 环回基线不走 CoreController::finishFrame，在这里补一次；与桌面端
	 * 共用 sioLinkDiagCore 的节流变量，同一帧不会产生重复日志。 */
	sioLinkDiagCore(core);
	pollLink(sio);
	serviceLink(sio);
}

void sioLinkDiagCore(struct mCore* core) {
	/* 与链路对象完全解耦：CoreController::finishFrame 每帧无条件调用。
	 * 联机对象只在隧道配对后才创建，而脚本拿到房号就开始推进菜单，
	 * 那时 m_lanLink 还是 null，挂在 sioLinkPump 里的诊断一行都不会有
	 * （09:58 轮实测 mgba_sio.log 全程 0 字节）。 */
	if (!core || core->platform(core) != mPLATFORM_GBA) {
		return;
	}
	static uint32_t diagMs;
	uint32_t now = wallNowMs();
	if ((uint32_t) (now - diagMs) < 250u) {
		return;
	}
	diagMs = now;
	logLinkDiag((struct GBA*) core->board);
	obsChainGateOnce();   /* X10-OBSCHAIN：门快照每进程只打一行（链路未配对时也可见） */
}

/* ===== S2 PC 源端：只读导出本机真 gPlayerParty → 填整份 532B GNP 邮槽镜像 =====
 * 仅 GBAView8/GBAView32 读 EWRAM（SIO_EW），对任何地址零写；pad 写 0，
 * doorbell 留 0（由 APP/ROM 最后写 NEW）。writer=ROM：本函数只搬字节，
 * 不写 gEnemyParty/gEnemyPartyCount/gBattleMons/brs/rem/nr/st/CLOSED/MULTIUSE_STATE。 */
static uint32_t s_gnpTxSeq = GNP_SEQ_INIT;   /* seq 从 1 起（0 被 ROM 拒收） */

/* V1: GNP party 数据源具名门（默认关，三端同名同值，零回归）。
 * 开=用 gnp_manifest.h 的 nm 实测绝对地址读真 gPlayerParty，不再套 SIO_EW delta
 * （EWRAM 符号平移不均匀，gTasks delta 对 party 偏 +0xE8，致 cnt 恒非 1..6、provider empty）。
 * 只读真游戏内存、不造值、不写游戏态。 */
static bool gnpPartyManifestSrcOn(void) {
    static int v = -1;
    if (v < 0) {
#ifndef MGBAX_GNP_PARTY_MANIFEST_SRC
#define MGBAX_GNP_PARTY_MANIFEST_SRC 0
#endif
#if MGBAX_GNP_PARTY_MANIFEST_SRC != 0
        v = 1;
#else
        const char* e = getenv("MGBAX_GNP_PARTY_MANIFEST_SRC");
        v = (e && atoi(e) == 1) ? 1 : 0;
#endif
    }
    return v != 0;
}

size_t sioBuildNetPartyMailbox(struct GBA* gba, uint8_t* out, size_t cap) {
    GnpMvpMailboxHost mb;
    uint32_t partyBase;
    uint32_t off;
    uint8_t cnt;
    if (!gba || !gba->cpu || !out || cap < GNP_MB_SIZE) { return 0u; }
    if (gnpPartyManifestSrcOn()) {
        /* nm 实测绝对地址（NGLATEST-02 rom.map），禁再套 delta */
        partyBase = GNP_PLAYER_PARTY_EW;
        cnt = (uint8_t) GBAView8(gba->cpu, GNP_PLAYER_PARTY_COUNT_EW);
    } else {
        partyBase = SIO_EW(SIO_PLAYER_PARTY);
        cnt = (uint8_t) GBAView8(gba->cpu, SIO_EW(SIO_PLAYER_PARTY_COUNT));
    }
    if (rhVerbose() || getenv("MGBAX_GNP_PARTY_MANIFEST_SRC")) {
        SIO_LOG("[GNP-SRC] manifest=%d cnt=%u partyBase=%08X",
                gnpPartyManifestSrcOn() ? 1 : 0, (unsigned) cnt, (unsigned) partyBase);
    }
    if (cnt < 1u || cnt > GNP_MONS_MAX) { return 0u; }

    memset(&mb, 0, sizeof(mb));                                 /* 所有 pad 写 0；tag 先归零作 fail-closed 基线 */
    /* E11-HOST-PEEK：把 ROM TX 邮槽真 tag 只读镜像到 mb.tag[500..531]。
     * host 不持密钥/不算 HMAC/不写游戏态；tag_ok 真值仍只由 ROM GnpNetGate_HmacTagOk 写 diag。
     * 守卫失败 → tag 保持 memset 零值 → 对端 HMAC 比较失败 → tag_ok=0（fail-closed，不产 CROSSED）。 */
    if (gnpAbsEwOk(NET_TX_PORT_ABS, GNP_MB_SIZE)) {            /* EWRAM 范围+边界检查 abi:187-190 */
        uint32_t t;
        for (t = 0u; t < GNP_HMAC_TAG_SIZE / 4u; ++t) {         /* 32B/4=8 字；源 +500 四字节对齐 */
            uint32_t w = (uint32_t) GBAView32(gba->cpu,
                NET_TX_PORT_ABS + GNP_OFF_TAG + t * 4u);        /* 只读 EWRAM，写数=0；读 +500..+531 */
            memcpy(mb.tag + t * 4u, &w, sizeof(w));             /* 小端原样落到 tag[500..531] */
        }
    }                                                           /* 守卫失败：tag 维持零 → fail-closed */
    mb.magic      = GNP_MAGIC;
    mb.version    = GNP_PROTO_VER;
    mb.seq        = ++s_gnpTxSeq;                               /* 单调，> GNP_SEQ_INIT */
    mb.msgType    = GNP_MSG_PARTY;
    mb.partyCount = cnt;
    mb.length     = GNP_BLOB_SIZE;
    for (off = 0u; off < GNP_BLOB_SIZE; off += 4u) {
        uint32_t w = (uint32_t) GBAView32(gba->cpu, partyBase + off);  /* 小端原样字节 */
        memcpy(mb.blob + off, &w, sizeof(w));
    }
    mb.crc      = gnpCrc16((const uint8_t*) (const void*) &mb, GNP_CRC_SPAN);
    mb.doorbell = 0u;                                          /* host 不置 NEW */
    memcpy(out, (const void*) &mb, GNP_MB_SIZE);
    return (size_t) GNP_MB_SIZE;
}
