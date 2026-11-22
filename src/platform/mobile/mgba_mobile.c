/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "mgba_mobile.h"

/* 【ROM 地址自解析 2026-11-18】
 * 所有 0x03xxxxxx / 0x02xxxxxx / 0x08xxxxxx 访问都必须走下面的宏：
 *   NAV_IW(a) / NAV_EW(a)  —— IWRAM / EWRAM，delta 从 ROM 字节自解析；
 *   SIO_CODE(a)            —— battle_main.o 代码段，段首由 ROM 签名定位；
 *   MOBILE_BATTLE_* / MOBILE_TITLE_* / MOBILE_COPYRIGHT_* —— cb2 窗口。
 * 运行时只读 ROM 字节（MGBAX_ROM_PATH → 实际加载路径 → rom.gba → 默认路径，
 * 找不到文件时直接用已加载核心的 gba->memory.rom），**绝不读 .map/.elf**。
 * 每个宏都有「签名没找到 → 当前默认 + 明确告警」兜底。 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* GBA 硬件固定内存映射基址与区间端点（不随 ROM 重建平移）。
 * 扫描器/地址计算里也一律用具名宏，不写裸地址。 */
#define GBA_EWRAM_BASE     0x02000000u
#define GBA_EWRAM_SCAN_END 0x0203FFF0u
#define GBA_EWRAM_END      0x02040000u
#define GBA_IWRAM_BASE     0x03000000u
#define GBA_IWRAM_SCAN_END 0x03007FF0u
#define GBA_IWRAM_END      0x03008000u
#define GBA_IO_BASE        0x04000000u
#define GBA_VRAM_BASE      0x06000000u
#define GBA_OAM_BASE       0x07000000u
#define GBA_ROM_BASE       0x08000000u

/* 协议常量（非 ROM 地址）：关链 opcode LINKCMD_READY_CLOSE_LINK。
 * 两端同名同值，收口裸字面量 0x5FFF，行为完全等价。 */
#define LINKCMD_READY_CLOSE_LINK 0x5FFFu
/* ROOTHUNT2 修复② 块交换让位宏（与 PC 逐字对称，禁裸 hex） */
#define LINKCMD_INIT_BLOCK        0xBBBBu
#define LINKCMD_CONT_BLOCK        0x8888u
#define LINKCMD_SEND_LINK_TYPE    0x2222u
#define LINK_HANDSHAKE_MASTER     0x8FFFu
#define LINK_HANDSHAKE_SLAVE      0xB9A0u
#define LINK_HANDSHAKE_SLAVE_MASK 0x3u
#define LINK_STAT_MASTER          0x20u
#define LINK_MU_BLOCK2            2u
#define LINK_MU_BLOCK4            4u
#define LINK_MU_BLOCK8            8u
#define LINK_MU_BLOCK12           12u
#define LINK_MU_BLOCK17           17u

#define MOBILE_IW_BASE_GLINK   0x03002AF4u
#define MOBILE_IW_DELTA_DFLT   0xD4u       /* 当前两份 ROM 的实测值 */
#define MOBILE_EW_BASE_GTASKS  0x02033D0Cu
#define MOBILE_BATTLE_LO_DFLT  0x080B30C0u
#define MOBILE_BATTLE_SZ_DFLT  0x99B8u
#define MOBILE_BATTLE_CB2_OFF  0x1784u     /* 段首 → BattleMainCB2，跨构建恒定 */
#define MOBILE_TITLE_LO_DFLT   0x081F9200u
#define MOBILE_TITLE_HI_DFLT   0x081F9C00u
#define MOBILE_COPY_LO_DFLT    0x0815E900u
#define MOBILE_COPY_HI_DFLT    0x0815EBFFu

static uint32_t s_navIwDelta = MOBILE_IW_DELTA_DFLT;
static uint32_t s_navEwDelta = 0;
static uint32_t s_battleLo = MOBILE_BATTLE_LO_DFLT;
static uint32_t s_battleHi = MOBILE_BATTLE_LO_DFLT + MOBILE_BATTLE_SZ_DFLT;
static uint32_t s_battleCb2 = MOBILE_BATTLE_LO_DFLT + MOBILE_BATTLE_CB2_OFF + 1u;
static uint32_t s_titleLo = MOBILE_TITLE_LO_DFLT;
static uint32_t s_titleHi = MOBILE_TITLE_HI_DFLT;
static uint32_t s_copyLo = MOBILE_COPY_LO_DFLT;
static uint32_t s_copyHi = MOBILE_COPY_HI_DFLT;
static int s_romAddrInit = 0;
static char s_mobileRomPath[1024];   /* mgbaMobileLoad() 记录真实加载路径 */
static void mobileResolveRomAddresses(void);

/* 【竞态修复】先算完值、最后再置 init；path B 一个进程 4 核并发最坏各算一遍，
 * 结果一致。env/prop 强制值优先，之后才是 ROM 扫描。 */
static inline uint32_t navIwDelta(void) {
    if (!__atomic_load_n(&s_romAddrInit, __ATOMIC_ACQUIRE)) {
        mobileResolveRomAddresses();
    }
    return s_navIwDelta;
}
static inline uint32_t navEwDelta(void) {
    if (!__atomic_load_n(&s_romAddrInit, __ATOMIC_ACQUIRE)) {
        mobileResolveRomAddresses();
    }
    return s_navEwDelta;
}
static inline uint32_t mobileCodeDelta(void) {
    if (!__atomic_load_n(&s_romAddrInit, __ATOMIC_ACQUIRE)) {
        mobileResolveRomAddresses();
    }
    return s_battleLo - MOBILE_BATTLE_LO_DFLT;
}
#define NAV_IW(a)      ((uint32_t) (a) + navIwDelta())
#define NAV_EW(a)      ((uint32_t) (a) + navEwDelta())
#define SIO_CODE(a)    ((uint32_t) (a) + mobileCodeDelta())
#define MOBILE_BATTLE_LO()    (s_battleLo)
#define MOBILE_BATTLE_HI()    (s_battleHi)
#define MOBILE_BATTLE_CB2()   (s_battleCb2)
#define MOBILE_TITLE_LO()     (s_titleLo)
#define MOBILE_TITLE_HI()     (s_titleHi)
#define MOBILE_COPYRIGHT_LO() (s_copyLo)
#define MOBILE_COPYRIGHT_HI() (s_copyHi)

/* 【MACROFIX 2026-11-18】补齐全仓库审计里漏掉的具名宏：下列地址此前以
 * NAV_EW()/NAV_IW() 包裹的裸字面量散落在判据/日志里，换 ROM 时无法一眼核对。
 * 全部沿用上面的自解析 delta（NAV_EW/NAV_IW），不引入新机制；数值与 Qt
 * sio_link.c 的同名宏逐项对齐（BATTLE_*_OFF 两端字面同名）。 */
#define MOBILE_MAIN_CB2         0x02029118u   /* gMain @0x02029114 的 callback2 槽 */
#define NAV_CB2_PTR             NAV_EW(MOBILE_MAIN_CB2)   /* 当前 callback2 函数指针 */
#define MOBILE_READY_CLOSE_LINK 0x03002AA6u   /* gReadyToCloseLink[]（关链握手位） */
#define NAV_READY_CLOSE_LINK    NAV_IW(MOBILE_READY_CLOSE_LINK)
/* 战斗启动窗口相对 battle_main.o .text 段首的几何偏移（两份 ROM map 实测，
 * 跨重编译恒定）：段首+0x4D=CB2_InitBattle，段首+0x17E8=BattleMainCB2 末尾。 */
#define BATTLE_STARTUP_LO_OFF   0x4Du
/* 迭代 48 纠错：lo=0x080B30C0；CB2_InitBattleInternal=lo+0xAD(080B316D)，
 * CB2_HandleStartBattle=lo+0x6AD(080B376D)——此前 0xAD 指错了函数，
 * 导致 RHERR 把 cb2 拉回 InitBattleInternal 形成反复错误屏/关链振荡。 */
#define BATTLE_START_HANDLE_OFF 0x6ADu  /* CB2_HandleStartBattle = lo+0x6AD */
#define BATTLE_CLOSE_INIT_END 0xADu   /* CB2_InitBattleInternal：关链发起段终点 */
#define BATTLE_MAIN_END_OFF     0x17E8u
/* ROOTHUNT2 对手框重绘（三端对称，与 SIO_CB2_RESHOW / inReshow 一致） */
#define MOBILE_CB2_RESHOW       0x081CBBEFu   /* ReshowBattleScreenAfterMenu (rom.elf 0x081cbbee+1) */
#define MOBILE_RESHOW_LO        0x081CBB00u
#define MOBILE_RESHOW_HI        0x081CC000u
/* 【MACROFIX2 2026-11-19 v2】EWRAM 战斗/队伍符号具名宏：与 Qt sio_link.c 的
 * SIO_* 同名同值对称（审计存档 MACRO_AUDIT_backup.md）。此前下列地址以
 * NAV_EW(0x...) 裸字面量散落在判据/日志里，换 ROM 时无法一眼核对；此处仅
 * 收口字面量，仍沿用现有 NAV_EW() 自解析 delta，不引入新机制。
 * v2：基于 ROOTHUNT2 总闸提交(d6e8fd501)后源码重生成；已删除的 gBattleMons
 * 覆盖块不再产生 hunk。 */
#define MOBILE_BATTLE_MONS           0x0201CCC4u   /* gBattleMons[4] */
#define MOBILE_ENEMY_PARTY           0x0202A7CCu   /* gEnemyParty[6] */
#define MOBILE_ENEMY_PARTY_COUNT     0x0202A5EAu   /* gEnemyPartyCount */
#define MOBILE_PLAYER_PARTY          0x0202A5ECu   /* gPlayerParty[6] */
#define MOBILE_BATTLER_PARTY_INDEXES 0x0201CCACu   /* gBattlerPartyIndexes[4] */
#define MOBILE_BATTLE_TYPE_FLAGS     0x0201CC30u   /* gBattleTypeFlags */
#define MOBILE_BLOCK_RECV_BUFFER     0x020275B0u   /* gBlockRecvBuffer[4] */
/* ROOTHUNT2 只读诊断：cable_club var8004 / 远端玩家标志 / linkType */
#define MOBILE_SPECIAL_VAR_8004      0x0202199Cu   /* gSpecialVar_0x8004 (linkService) */
#define MOBILE_REMOTE_LINK_PLAYERS   0x03002B95u   /* gReceivedRemoteLinkPlayers (IWRAM, 经 NAV_IW) */
#define MOBILE_BATTLE_COMM           0x0201CFF4u   /* gBattleCommunication[MULTIUSE_STATE] (早定义供 BTLCFG 用) */
/* ROOTHUNT2 合规收口：错误屏 / 关链回调 code 段地址（link.o），与 PC 逐字对称。
 * 移动端无统一 codeDelta（title/intro 独立平移），此为"具名宏收口"层，不做运行时解析。 */
#define MOBILE_CB2_LINK_ERROR        0x0816D8CDu   /* CB2_PrintErrorMessage */
#define MOBILE_CB2_LINK_ERROR_ALT    0x0816D669u   /* 错误屏备选 cb2 */
#define MOBILE_CB_READY_CLOSE        0x0816D439u   /* LinkCB_ReadyCloseLink */
#define MOBILE_CB_READY_CLOSE_ALT    0x0816D465u   /* LinkCB_WaitCloseLink */
/* ROOTHUNT2 T6 块交换诊断宏（canonical，经 NAV_IW/NAV_EW 运行时 delta），与 PC 逐字对称 */
#define MOBILE_GLINK_CALLBACK        0x03002AD4u   /* gLinkCallback (u32) */
#define MOBILE_GLINK_STATUS          0x03002A9Cu   /* gLinkStatus (u32) */
#define MOBILE_GLINK_STATE           0x03002AF4u   /* gLink @ IWRAM base (canonical) */
#define MOBILE_LINK_TYPE_BATTLE      0x02027BB2u   /* gLinkType @ EWRAM (canonical) */
#define MOBILE_LINK_STAT_ERRORS      0x0007F000u   /* LINK_STAT_ERRORS */
/* ROOTHUNT2 方案 b 窄窗口门控值宏（与 PC 逐字对称，禁裸字面量） */
#define MOBILE_LINKTYPE_BATTLE       0x2211u   /* LINKTYPE_BATTLE 值 */
#define MOBILE_LINKTYPE_CLASS_MASK   0xFF00u   /* gLinkType 类别掩码 */
#define MOBILE_LINKTYPE_CLASS_BATTLE 0x2200u   /* 战斗类 gLinkType 高字节 */
#define MOBILE_BATTLE_TYPE_LINK      0x0002u   /* BATTLE_TYPE_LINK 位 */
#define MOBILE_LINK_STATE_CONN       4u        /* LINK_STATE_CONN_ESTABLISHED */
#define MOBILE_LINK_STATE_HANDSHAKE  2u        /* LINK_STATE_HANDSHAKE（<2 = 链路重建/未起） */
#define MOBILE_GLINK_STATE_OFF       1u        /* gLink.state 偏移 */
#define MOBILE_GLINK_PLAYERCOUNT_OFF 3u        /* gLink.playerCount 偏移 */
#define MOBILE_LINK_PLAYERCOUNT_2P   2u        /* 2P playerCount */
#define MOBILE_LINK_STAT_CONN_SHIFT  6u        /* LINK_STAT_CONN_ESTABLISHED 位移 */
#define MOBILE_PROBE_HEARTBEAT_MASK  0x3Fu     /* 打点心跳节流掩码 */
#define MOBILE_G_SPECIES_NAMES       0x0874158cu /* gSpeciesNames 连续文本表 [n][11] */
/* ROOTHUNT2 方案2+V1+V3 块字出网捕获宏（与 PC 逐字对称，禁裸 hex）。
 * 数值来自 gen8/include/link.h 的具名常量，不是裸地址。 */
#define LINK_CMD_LENGTH             8u    /* CMD_LENGTH (link.h:6) */
#define LINK_QUEUE_CAPACITY        50u    /* QUEUE_CAPACITY (link.h:7) */
#define LINK_SENDQ_WORD_BYTES       2u    /* sizeof(u16) */
#define LINK_SENDQ_DATA_BYTES \
    (LINK_CMD_LENGTH * LINK_QUEUE_CAPACITY * LINK_SENDQ_WORD_BYTES) /* 0x320 */
#define MOBILE_GLINK_SENDCMD_IX_OFF  0x16u /* gLink.sendCmdIndex (sc) */
#define MOBILE_GLINK_RECVCMD_IX_OFF  0x17u /* gLink.recvCmdIndex (rc) —— 观测打点只读 */
#define MOBILE_GLINK_SENDQ_OFF       0x18u /* gLink.sendQueue */
/* data[word][slot] 每跨一个 word 跨 50*sizeof(u16)=100 字节 */
#define MOBILE_GLINK_SENDQ_DATA_STRIDE \
    (LINK_QUEUE_CAPACITY * LINK_SENDQ_WORD_BYTES) /* 100 */
#define MOBILE_GLINK_SENDQ_POS_OFF \
    (MOBILE_GLINK_SENDQ_OFF + LINK_SENDQ_DATA_BYTES) /* 0x338 */
#define MOBILE_GLINK_SENDQ_CNT_OFF \
    (MOBILE_GLINK_SENDQ_POS_OFF + 1u)                 /* 0x339 */
/* data[word][slot] 相对 gLink 的字节偏移（word=帧内字序号 0..7, slot=队列槽 0..49） */
#define MOBILE_GLINK_SENDQ_WORD_OFF(word, slot) \
    (MOBILE_GLINK_SENDQ_OFF \
     + (uint32_t) (word) * MOBILE_GLINK_SENDQ_DATA_STRIDE \
     + (uint32_t) (slot) * LINK_SENDQ_WORD_BYTES)
/* 只读入口：GBAView16 对 IWRAM 走 GBALoad16，实时真值 */
#define MOBILE_GLINK_SENDQ_WORD(cpu, word, slot) \
    GBAView16((cpu), NAV_IW(MOBILE_GLINK_STATE) \
              + MOBILE_GLINK_SENDQ_WORD_OFF((word), (slot)))
/* 队头 = pos；队尾 = (pos+count)%50（EnqueueSendCmd 写入点） */
#define MOBILE_SENDQ_SLOT_HEAD(pos)  ((uint32_t) (pos))
#define MOBILE_SENDQ_SLOT_TAIL(pos, cnt) \
    (((uint32_t) (pos) + (uint32_t) (cnt)) % LINK_QUEUE_CAPACITY)
/* ROOTHUNT2 TRISYNC 裸 hex 收口宏（与 PC 逐字对称，禁裸字面量） */
#define MOBILE_LINKTYPE_MULTI        0x2255u   /* LINKTYPE_MULTI (4P) */
#define MOBILE_LINK_STAT_QUEUE_FULL  0x00004000u /* LINK_STAT_ERROR_QUEUE_FULL */
#define MOBILE_GLINK_HWERR_OFF       0x10u     /* gLink.hardwareError 偏移 */
#define MOBILE_GLINK_BADCKSUM_OFF    0x11u     /* gLink.badChecksum 偏移 */
#define MOBILE_GLINK_QUEUEFULL_OFF   0x12u     /* gLink.queueFull 偏移 */
#define MOBILE_GLINK_LAG_OFF         0x13u     /* gLink.lag 偏移 */
#define MOBILE_GLOBAL_SEND_CMD       0x03002AB0u   /* gSendCmd[8] */
#define MOBILE_GLOBAL_BLOCK_SEND     0x03002984u   /* sBlockSend */
#define MOBILE_GLOBAL_BSEND_DELAY    0x030029C0u   /* sBlockSendDelayCounter */
#define MOBILE_GLOBAL_BLOCK_RECV     0x03002990u   /* sBlockRecv[4] */
#define MOBILE_GLOBAL_BLK_RECV_STATUS 0x03002A40u  /* gBlockReceivedStatus (brs) */
#define MOBILE_CB_BLOCK_SEND_BEGIN   0x0816CC95u   /* LinkCB_BlockSendBegin */
#define MOBILE_CB_BLOCK_SEND         0x0816CCB5u   /* LinkCB_BlockSend */
#define MOBILE_CB_BLOCK_SEND_END     0x0816CD0Du   /* LinkCB_BlockSendEnd */
#define MOBILE_GLOBAL_REMOTE_ID      0x03002AC1u   /* gReceivedRemoteLinkPlayers (rem) */
/* ROOTHUNT2 X44 §5 只读观测：gRemoteLinkPlayersNotReceived[4] (nr, per-player u8,
 * 初值 TRUE=未收齐；清 FALSE 唯一路径 HandleReceiveRemoteLinkPlayer(link.c:519)。
 * 经 NAV_IW 运行时 delta 解析，与 PC SIO_REMOTE_PLAYERS_NOT_RECEIVED 同名同值。 */
#define MOBILE_REMOTE_PLAYERS_NOT_RECEIVED 0x03002A3Cu
#define MOBILE_LINK_OPEN             0x02027BB0u   /* gLinkOpen (EWRAM, 经 NAV_EW) */
/* 【ROOTHUNT2 P0/X40 方案C1】gLink.checksum 偏移具名宏，禁裸 hex。 */
#define MOBILE_GLINK_CHECKSUM_OFF    0x14u
#define MOBILE_GLINK_CHECKSUM        (MOBILE_GLINK_STATE + MOBILE_GLINK_CHECKSUM_OFF) /* 0x03002B08 */



#include <mgba/core/core.h>
#include <mgba/core/cheats.h>
#include <mgba/core/interface.h>
#include <mgba/core/rewind.h>
#include <mgba/core/serialize.h>
#include <mgba/gb/interface.h>
#include <mgba/gba/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gb/gb.h>
#include <mgba/internal/gb/io.h>
#include <mgba-util/audio-buffer.h>
#include <mgba-util/audio-resampler.h>
#include <mgba-util/vfs.h>

/* S2 Android 宿端写口：GNP 500B/CRC16 ABI 镜像 + manifest 绝对地址具名宏。
 * include 根为 src/，故带 platform/gboy/ 前缀；共享头全 static/宏，无新链接符号。 */
#include "platform/gboy/gboy_netparty_abi.h"
#include "platform/gboy/gnp_manifest.h"

#include "link_net.h"
#include "link_lockstep.h"
#include <mgba/internal/gba/sio/lockstep.h>

#include <ctype.h>
#include <fcntl.h>
#include <pthread.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <math.h>

#ifdef __ANDROID__
#include <android/log.h>
#include <sys/system_properties.h>
#define MOBILE_LOGI(...) __android_log_print(ANDROID_LOG_INFO, "mGBA", __VA_ARGS__)
#define MOBILE_LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "mGBA", __VA_ARGS__)
#else
/* 桌面端（Qt 版）默认静默；排查联机时序时设 MGBAX_SIO_LOG=1 就把同一条轨迹打到
 * stderr，和安卓 logcat 里的 mGBA 标签内容一致。 */
static int mobileLogEnabled(void) {
	static int cached = -1;
	if (cached < 0) {
		const char* env = getenv("MGBAX_SIO_LOG");
		cached = (env && *env && *env != '0') ? 1 : 0;
	}
	return cached;
}
#define MOBILE_LOGI(...) \
	do { \
		if (mobileLogEnabled()) { \
			fprintf(stderr, __VA_ARGS__); \
			fputc('\n', stderr); \
			fflush(stderr); \
		} \
	} while (0)
#define MOBILE_LOGE(...) MOBILE_LOGI(__VA_ARGS__)
#endif

/* 每次传输都打日志会拖慢联机（一秒钟几十条），排查时再打开。 */
#ifndef MGBA_LINK_VERBOSE
#define MGBA_LINK_VERBOSE 0
#endif
#if MGBA_LINK_VERBOSE
#define LINK_VERBOSE(...) MOBILE_LOGI(__VA_ARGS__)
#else
#define LINK_VERBOSE(...) ((void) 0)
#endif

/* 【OBSCHAIN / 方案乙 · J8B 方案A 运行时门】只读观测链包装宏。
 * 修复：helper 无条件编译进 .so（去掉 #if MGBAX_OBS_CHAIN 包裹），门控完全靠
 * helper 内部运行时 mobileObsChainOn() return——这样 prop=1 可运行时开打点，
 * 不再因编译期默认 0 把 helper 裁掉（本轮 E2E APP 侧静默的根因）。
 * helper 内部先查 mobileObsChainOn()，门关立即 return，运行时零打点、行为不变。
 * 新标签 [OBSCHAIN] 不在 diff_party_check.py TAG_RE 内 ⇒ 判据零影响。 */
#define MOBILE_OBS_ST_MAX          200u
#define MOBILE_OBS_WORD_EMPTY      0xFFFFu
#define MOBILE_OBS_SRC_GAME        "game"
#define MOBILE_OBS_SRC_LOCALBUS    "localbus"
#define MOBILE_OBS_SRC_BRIDGE      "bridge"
#define MOBILE_OBS_SRC_EMPTY       "empty"
#define OBSCHAIN_GATES()                    mobileObsChainGates()
#define OBSCHAIN_ST(g, f, t, p, m, w)       mobileObsChainSt((g), (f), (t), (p), (m), (w))
#define OBSCHAIN_PROV(o, n, p)              mobileObsChainProv((o), (n), (p))
#define OBSCHAIN_PROXY(e, o, p)             mobileObsChainProxy((e), (o), (p))

#ifdef _WIN32
#include <direct.h>
#define mobile_mkdir(path) _mkdir(path)
#else
#define mobile_mkdir(path) mkdir((path), 0755)
#endif

/* ---- ROM 字节扫描（唯一的运行时地址来源；无 .map/.elf 依赖）---- */
/* struct MgbaMobile 在本文件稍后才定义；这里只用一个在定义之后实现的
 * provider 取已加载核心的 GBA 指针，避免对不完整类型解引用。 */
static struct GBA* mobileLoadedGbaForScan(void);

static const uint8_t kBattlePrologue[12] = {
	0x06, 0x4B, 0x1B, 0x78, 0x00, 0x20, 0x02, 0x2B, 0x06, 0xD1, 0x05, 0x4A
};
/* 三个额外的段首指纹：battle_main.o 之外的代码段会独立平移（实测
 * title/intro 相对 battle 差 +0x70），所以各自独立定位，不能共用一个 codeDelta。 */
static const uint8_t kTitlePrologue[12] = {
	0x00, 0xB5, 0x30, 0x22, 0x81, 0x5E, 0x28, 0x22, 0x4A, 0x43, 0x11, 0x4B
};
static const uint8_t kIntroPrologue[12] = {
	0x00, 0xB5, 0xBC, 0xF0, 0x87, 0xF8, 0xBC, 0xF0, 0xD0, 0xF9, 0x2C, 0xF0
};

static size_t mobileFindSig(const uint8_t* rom, size_t size,
                            const uint8_t* sig, size_t n) {
	if (!rom || size < n) {
		return (size_t) -1;
	}
	for (size_t i = 0; i + n <= size; ++i) {
		if (rom[i] == sig[0] && !memcmp(rom + i, sig, n)) {
			return i;
		}
	}
	return (size_t) -1;
}

/* 与 Qt sioLooksLikeTasks 同构：16 个槽、stride 0x28、func 落在 ROM、
 * isActive 只能是 0/1，至少一个 active —— 用来从高频 EWRAM 字面量里认出 gTasks。 */
static bool mobileLooksLikeTasks(struct GBA* gba, uint32_t base) {
	if (!gba || !gba->cpu || base + 0x280u > GBA_EWRAM_END) {
		return false;
	}
	unsigned active = 0, nonzero = 0;
	for (unsigned i = 0; i < 16u; ++i) {
		uint32_t fb = base + i * 0x28u;
		uint32_t func = GBAView32(gba->cpu, fb);
		uint8_t act = GBAView8(gba->cpu, fb + 4u);
		if (act > 1u) {
			return false;
		}
		if (func) {
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

/* 【ROOTHUNT 迭代 13】Android 属性读取兼容层：
 * stock A14 AVD 的 SELinux 拒绝 setprop mgbax.*（驱动里所有 "setprop mgbax.*
 * WARN" 都是真的被拒），但 debug.* 可写。这里先读原名，读不到再用
 * debug.mgbax.* 兜底，使驱动下发的 mgbax.* 配置真正到达 app。
 * 纯配置读取改动，不改变任何默认行为。 */
#ifdef __ANDROID__
static void rhGetProp(const char* name, char* value) {
	value[0] = 0;
	__system_property_get(name, value);
	if (!value[0] && strncmp(name, "mgbax.", 6) == 0) {
		char dbg[128];
		snprintf(dbg, sizeof(dbg), "debug.%s", name);
		__system_property_get(dbg, value);
	}
}
#else
#define rhGetProp(n, v) __system_property_get((n), (v))
#endif

/* 【OBSCHAIN / C-0 统一】唯一 getter + 唯一 static + 唯一 setter。
 * getter 随 #if 门控（其调用者——四 helper 与四包装宏——均被门控，避免门关时
 * -Wunused-function）；setter 与 s_obsChain 保持无条件，供 Android JNI / iOS Swift 调用。 */
static int s_obsChain = -1;
/* J8B 方案A：getter 无条件编译（运行时门），__attribute__((unused)) 防门关告警。 */
static bool mobileObsChainOn(void) __attribute__((unused));
static bool mobileObsChainOn(void) {
	if (s_obsChain < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MGBAX_OBS_CHAIN_PROP, p);
		s_obsChain = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv(MGBAX_OBS_CHAIN_ENV);
		s_obsChain = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_obsChain != 0;
}
void mgbaMobileSetObsChain(bool enabled) { s_obsChain = enabled ? 1 : 0; }

static void mobileResolveRomAddresses(void) {
	if (__atomic_load_n(&s_romAddrInit, __ATOMIC_ACQUIRE)) {
		return;
	}
	/* 不在入口置 init：path B 4 核并发时，先置位会让别的线程拿到未算完的
	 * 默认值。本函数不会递归调用 navIwDelta/navEwDelta，末尾统一置 init。 */

	/* 1) 显式覆盖：env 优先，Android 属性兜底（mgbax.* 与 Qt 驱动同源）。 */
	const char* forced = getenv("MGBAX_IWRAM_DELTA");
#ifdef __ANDROID__
	char prop[PROP_VALUE_MAX] = {0};
	if (!forced || !*forced) {
		rhGetProp("mgbax.iwram.delta", prop);
		if (prop[0]) {
			forced = prop;
		}
	}
#endif
	if (forced && *forced) {
		s_navIwDelta = (uint32_t) strtoul(forced, NULL, 0);
	}
	forced = getenv("MGBAX_EWRAM_DELTA");
	if (forced && *forced) {
		s_navEwDelta = (uint32_t) strtoul(forced, NULL, 0);
	}

	/* 2) 找 ROM 字节。优先实际加载路径（移动端唯一可靠路径），再 env，再常见路径。 */
	const char* paths[5];
	size_t npaths = 0;
	const char* envRom = getenv("MGBAX_ROM_PATH");
	if (envRom && *envRom) {
		paths[npaths++] = envRom;
	}
	if (s_mobileRomPath[0]) {
		paths[npaths++] = s_mobileRomPath;
	}
	paths[npaths++] = "rom.gba";
	paths[npaths++] = "D:/mgba-android-version/rom.gba";
	paths[npaths++] = "D:/gen8/rom.gba";
	FILE* fp = NULL;
	const char* chosen = NULL;
	for (size_t i = 0; i < npaths; ++i) {
		fp = fopen(paths[i], "rb");
		if (fp) {
			chosen = paths[i];
			break;
		}
	}
	uint8_t* owned = NULL;
	const uint8_t* rom = NULL;
	size_t size = 0;
	if (fp) {
		if (fseek(fp, 0, SEEK_END) == 0) {
			long len = ftell(fp);
			if (len > 0 && len <= (64 << 20) && fseek(fp, 0, SEEK_SET) == 0) {
				owned = (uint8_t*) malloc((size_t) len);
				if (owned) {
					size_t got = fread(owned, 1, (size_t) len, fp);
					if (got == (size_t) len) {
						rom = owned;
						size = got;
					} else {
						free(owned);
						owned = NULL;
					}
				}
			}
		}
		fclose(fp);
		if (!rom) {
			MOBILE_LOGE("SIOROM 读取 %s 失败，改用内存 ROM", chosen ? chosen : "?");
		}
	}
	/* 移动端：文件不可读时用已加载核心的 ROM 镜像（gba->memory.rom），
	 * 这是玩家设备上唯一一定存在的 ROM 来源。 */
	if (!rom) {
		struct GBA* gba = mobileLoadedGbaForScan();
		if (gba && gba->memory.rom && gba->memory.romSize) {
			rom = (const uint8_t*) gba->memory.rom;
			size = gba->memory.romSize;
			chosen = "LOADED-ROM";
		}
	}
	if (!rom || size < 0x1000u) {
		MOBILE_LOGE("SIOROM 找不到可读 ROM，沿用默认 IW delta=0x%X EW delta=0x%X，窗口=默认+告警",
		            (unsigned) s_navIwDelta, (unsigned) s_navEwDelta);
		__atomic_store_n(&s_romAddrInit, 1, __ATOMIC_RELEASE);
		return;
	}

	/* 3) IWRAM：扫全部 0x03xxxxxx 字面量，找 gRecvCmds 与 gRecvCmds+0x66 同时出现的 R，
	 *    取引用数较小者作分数，最高分者即 gRecvCmds；gLink = R + 0xAA。 */
	{
		static uint16_t cnt[0x8000];
		memset(cnt, 0, sizeof(cnt));
		for (size_t i = 0; i + 4 <= size; ++i) {
			uint32_t v = (uint32_t) rom[i] | ((uint32_t) rom[i + 1] << 8)
			             | ((uint32_t) rom[i + 2] << 16) | ((uint32_t) rom[i + 3] << 24);
			if (v >= GBA_IWRAM_BASE && v < GBA_IWRAM_SCAN_END) {
				uint16_t* c = &cnt[v - GBA_IWRAM_BASE];
				if (*c < 0xFFFFu) {
					++*c;
				}
			}
		}
		uint32_t bestR = 0, bestScore = 0;
		for (uint32_t idx = 0; idx < 0x8000u; ++idx) {
			uint32_t c1 = cnt[idx];
			if (c1 < 2u) {
				continue;
			}
			uint32_t r = GBA_IWRAM_BASE + idx;
			if (r + 0x66u >= GBA_IWRAM_END) {
				continue;
			}
			uint32_t score = (c1 < cnt[(r + 0x66u) - GBA_IWRAM_BASE])
			                 ? c1 : cnt[(r + 0x66u) - GBA_IWRAM_BASE];
			if (score > bestScore) {
				bestScore = score;
				bestR = r;
			}
		}
		if (bestR && bestScore >= 4u) {
			uint32_t delta = (bestR + 0xAAu) - MOBILE_IW_BASE_GLINK;
			if (delta <= 0x2000u || delta >= 0xFFFFE000u) {
				s_navIwDelta = delta;
				MOBILE_LOGI("SIOROM %s gRecvCmds=0x%08X(score %u) delta=0x%X",
				            chosen, (unsigned) bestR, (unsigned) bestScore, (unsigned) delta);
			} else {
				MOBILE_LOGE("SIOROM IW delta 离谱 0x%X，沿用默认 0x%X", (unsigned) delta,
				            (unsigned) s_navIwDelta);
			}
		} else {
			MOBILE_LOGE("SIOROM 没找到 gRecvCmds/gSendCmd 组合(score=%u)，沿用默认 IW delta=0x%X",
			            (unsigned) bestScore, (unsigned) s_navIwDelta);
		}
	}

	/* 4) EWRAM：引用数最高的 8 个 4 字节 EWRAM 字面量里找 gTasks（结构校验）。 */
	{
		static uint16_t cnt[0x40000 / 4];
		memset(cnt, 0, sizeof(cnt));
		for (size_t i = 0; i + 4 <= size; i += 4) {
			uint32_t v = (uint32_t) rom[i] | ((uint32_t) rom[i + 1] << 8)
			             | ((uint32_t) rom[i + 2] << 16) | ((uint32_t) rom[i + 3] << 24);
			if (v >= GBA_EWRAM_BASE && v < GBA_EWRAM_SCAN_END && (v & 3u) == 0u) {
				uint16_t* c = &cnt[(v - GBA_EWRAM_BASE) >> 2];
				if (*c < 0xFFFFu) {
					++*c;
				}
			}
		}
		uint32_t bestAddr[8], bestCnt[8];
		memset(bestAddr, 0, sizeof(bestAddr));
		memset(bestCnt, 0, sizeof(bestCnt));
		for (uint32_t idx = 0; idx < 0x40000u / 4u; ++idx) {
			uint32_t c = cnt[idx];
			if (c < 100u) {
				continue;
			}
			for (unsigned j = 0; j < 8u; ++j) {
				if (c > bestCnt[j]) {
					for (unsigned k = 7u; k > j; --k) {
						bestCnt[k] = bestCnt[k - 1];
						bestAddr[k] = bestAddr[k - 1];
					}
					bestCnt[j] = c;
					bestAddr[j] = GBA_EWRAM_BASE + idx * 4u;
					break;
				}
			}
		}
		struct GBA* gba = mobileLoadedGbaForScan();
		bool resolved = false;
		for (unsigned j = 0; j < 8u && !resolved; ++j) {
			if (!bestAddr[j]) {
				continue;
			}
			if (!mobileLooksLikeTasks(gba, bestAddr[j]) && gba) {
				continue;
			}
			s_navEwDelta = bestAddr[j] - MOBILE_EW_BASE_GTASKS;
			MOBILE_LOGI("SIOEW gTasks=0x%08X(refs %u) delta=0x%X%s", (unsigned) bestAddr[j],
			            (unsigned) bestCnt[j], (unsigned) s_navEwDelta,
			            gba ? "" : " (结构校验跳过：无已加载核心)");
			resolved = true;
		}
		if (!resolved) {
			MOBILE_LOGE("SIOEW 没找到可信 gTasks，EWRAM delta 沿用 0x%X",
			            (unsigned) s_navEwDelta);
		}
	}

	/* 5) 代码段：段首 12 字节 Thumb 序言在 ROM 里唯一命中 → 段首运行地址。 */
	{
		size_t off = mobileFindSig(rom, size, kBattlePrologue, sizeof(kBattlePrologue));
		if (off != (size_t) -1) {
			s_battleLo = GBA_ROM_BASE + (uint32_t) off;
			s_battleCb2 = s_battleLo + MOBILE_BATTLE_CB2_OFF + 1u;
			/* 段长跨构建有两种实测值；用段尾 Thumb 序言 + 4 字节对齐填充判别。 */
			uint32_t sz = MOBILE_BATTLE_SZ_DFLT;
			static const uint32_t sizes[] = { 0x99B8u, 0x98B4u };
			for (unsigned i = 0; i < sizeof(sizes) / sizeof(sizes[0]); ++i) {
				uint32_t e = s_battleLo + sizes[i];
				size_t eoff = (size_t) (e - GBA_ROM_BASE);
				if (eoff >= 8u && eoff + 8u <= size
				    && rom[eoff - 8u] == 0x08 && rom[eoff - 7u] == 0x47
				    && rom[eoff - 2u] == 0 && rom[eoff - 1u] == 0) {
					sz = sizes[i];
					break;
				}
			}
			s_battleHi = s_battleLo + sz;
		} else {
			MOBILE_LOGE("SIOROM 没找到 battle_main.o 序言，battle 窗口沿用 [0x%08X,0x%08X)",
			            (unsigned) s_battleLo, (unsigned) s_battleHi);
		}
		off = mobileFindSig(rom, size, kTitlePrologue, sizeof(kTitlePrologue));
		if (off != (size_t) -1) {
			s_titleLo = GBA_ROM_BASE + (uint32_t) off;
			s_titleHi = s_titleLo + 0xA18u;    /* title_screen.o .text 段长 */
		} else {
			MOBILE_LOGE("SIOROM 没找到 title_screen.o 序言，标题 cb2 窗口沿用默认");
		}
		off = mobileFindSig(rom, size, kIntroPrologue, sizeof(kIntroPrologue));
		if (off != (size_t) -1) {
			s_copyLo = GBA_ROM_BASE + (uint32_t) off;
			s_copyHi = s_copyLo + 0x400u;       /* 覆盖 intro.o 中两个版权 cb2 */
		} else {
			MOBILE_LOGE("SIOROM 没找到 intro.o 序言，版权 cb2 窗口沿用默认");
		}
		MOBILE_LOGI("SIOROM delta=0x%X SIOEW delta=0x%X SIOCODE battle=[0x%08X,0x%08X) cb2=0x%08X "
		            "title=[0x%08X,0x%08X) copyright=[0x%08X,0x%08X) source=%s",
		            (unsigned) s_navIwDelta, (unsigned) s_navEwDelta,
		            (unsigned) s_battleLo, (unsigned) s_battleHi, (unsigned) s_battleCb2,
		            (unsigned) s_titleLo, (unsigned) s_titleHi,
		            (unsigned) s_copyLo, (unsigned) s_copyHi,
		            chosen ? chosen : "LOADED-ROM");
	}
	free(owned);
	__atomic_store_n(&s_romAddrInit, 1, __ATOMIC_RELEASE);
}

struct GbaLinkDriver {
	struct GBASIODriver d;
	struct MgbaMobile* emu;
};

struct GbLinkDriver {
	struct GBSIODriver d;
	struct MgbaMobile* emu;
};

struct MgbaMobile {
	/* Serialises core access between the emulation thread (runFrames) and
	 * link threads calling saveStateToMemory/loadStateFromMemory. A TYPE_STATE
	 * frame arrives on the socket reader thread while the mirror core is
	 * running, so both paths must hold this lock. */
	pthread_mutex_t coreMutex;
	bool coreMutexReady;
	struct mCore* core;
	/* 仅在 mCoreLoadFile 成功后置位：core 指针在加载中途就挂进 emu（供
	 * 失败路径 destroyCore 兜底），但 config/board 尚未就绪——isLoaded 若
	 * 只判 core 非空，emu 循环会在加载窗口内跑帧打到半初始化核
	 * （iOS CI #40/42/43 崩溃报告实证：autoload 线程还在 mCoreLoadConfig、
	 * emu 线程已进 ARMStep 空指针）。加载线程写 / emu 线程读，用原子序。 */
	bool romLoaded;
	mColor* video;
	uint32_t* prev;
	bool havePrev;
	int interframe;
	int userSkip;
	unsigned width;
	unsigned height;
	char savePath[1024];
	char statePath[1024];
	/* Suffix of the battery save actually opened (.sav, .srm, .saN). */
	char saveSuffix[8];
	char port[32];
	int fast;
	struct NetLink* link;
	struct GbaLinkDriver gbaLink;
	struct GbLinkDriver gbLink;
	struct mTimingEvent linkEvent;
	bool linkAttached;
	/* 进程内锁步 SIO（mgbaMobileLinkHostLockstep/JoinLockstep 启用）。
	 * 非空时帧循环走 mgbaLockstepRunFrame 的小步 runLoop，并跳过 netLink
	 * 的 poll/service，避免自研 gbaLink 驱动覆盖协调器。 */
	struct MgbaLockstepRoom* lockstepRoom;
	struct MgbaLockstepSlot* lockstepSlot;
	/* busgame 调试脚本：PC busgame-lockstep 判据脚本
	 * （test/gboylink_test.cpp lsInjectKeys）的设备端移植。idx<0 = 关闭。
	 * 每核独立计数；可见核在 beginFrameKeys 里接管按键，镜像核由
	 * GBoyConsoleSet 的镜像线程调 mgbaMobileBusGameTick 取掩码。 */
	int busGameIdx;
	int busGameMenuAt;
	int busGameNavOnly;   /* menuAt<0：跳过开场盲按，直接跑 2P 导航+队伍注入 */
	int busGameModeDowns;
	uint32_t busGameFrame;
	int busGameMenuMax;
	/* 进战斗区后自动释放按键：连续命中的帧数由共享导航状态累计。 */
	uint32_t busGameBattleHits;
	/* 一次 MULTI 传输的挂起状态：发起时把本帧数据发出去，传输应当结束的时刻
	 * 再取回对端应答。中途不阻塞模拟线程，否则每次传输都要吃掉半帧到几十
	 * 毫秒，游戏内的联机握手会直接超时。 */
	struct mTimingEvent sioDone;
	/* 从机侧「一轮完成」事件：把从机的模拟时钟钉在与主机同速的节拍上。
	 * 见 sioSlaveDoneEvent 的注释。 */
	struct mTimingEvent sioSlaveDone;
	bool sioSlaveArmed;
	/* 从机一轮的目标周期（模拟周期数）：主机一轮 = 5755(传输) + 12608(Timer3)
	 * + 少量处理 ≈ 18363。实测值由对端的模拟时钟戳校准。 */
	uint32_t sioSlavePeriod;
	/* 对端最近一次推送时的模拟时钟戳，用来算主机一轮的真实周期。 */
	uint32_t sioPeerCycles;
	bool sioPeerCyclesValid;
	bool sioWaiting;
	uint16_t sioSeq;
	int sioRetries;
	uint32_t sioRetryWall;
	/* 从机本轮要回推的字：游戏写 SIOCNT 起轮那一刻扣下来。等到本轮完成
	 * 再读 SIOMLT_SEND，游戏往往已写入下一轮的字 —— 16bit 错一位就会让
	 * gLink 的字节流命令队列（SendBlockRequest / 块校验）整体偏移，现象是
	 * 链路连着、gBlockReceivedStatus 恒 0、对战起不来。 */
	uint16_t sioRoundWord;
	bool sioRoundWordValid;
	/* ROOTHUNT2 方案2：从 sendQueue.data[0..7][pos] 读出的完整真块命令帧
	 *（8 字：命令 + 7 数据字）。伪链路每帧推 1 字，8 帧推完一帧，对端 gen8
	 * 按 8 拍收齐 gRecvCmds 才能闭合块交换。推的是 gen8 真实生成的数据，非伪造。 */
	uint16_t sioBlockFrame[8];
	uint8_t sioBlockFrameIdx;      /* 下一字下标 0..7；>=8 表示本帧推完 */
	bool sioBlockFrameValid;
	/* ROOTHUNT2 V1 相位锁：起轮捕获的 gLink.sendCmdIndex（0..8，只读不写索引）。
	 * 自槽与 push 必须用同一个 sc 取同一个块字，否则两端 checksum 累加不一致。 */
	uint8_t sioBlockPhase;
	/* 【13:20 自槽同源（镜像 Qt 侧 sio_link.c::sioSelfSlot）】
	 * 本轮投递给**本机游戏** SIOMULTI[me] 的字，必须与 netLinkPush 推出去的
	 * 字严格同源。gen8 DoHandshake 要求主机自身槽 0 恰是 0x8FFF
	 *（gen8/src/link.c:2289），否则 playerCount 数不出第 2 个玩家 ⇒ state 卡
	 * 2、pc 恒 0、serialIntrCounter 冻结。旧实现在 completeMultiTransfer 收尾
	 * 时才读实时 SIOMLT_SEND，那时游戏已被 rearm 补位后又清成 B9A0/0，
	 * 于是「推给对端 8FFF（PC 从机据此进 state4）、喂给自己 B9A0/0」——
	 * 典型 phantom master。起轮这一刻定死本字段，收尾直接用它。 */
	uint16_t sioSelfSlot;
	bool sioSelfSlotValid;
	bool sioHasRemote;
	uint32_t sioRemote;
	/* 【路线A / sioHandshakeHold】从机握手保持窗口（与 PC sioHsHoldLeft/Armed 对称）：
	 * st>=4 且最近真对端字仍是握手字时重新装满，持续推真 B9A0 给重入 st2 的主机，
	 * 供其 playerCount=2；对端字变非握手字即逐轮衰减。只推真字，不写游戏状态。 */
	uint16_t sioHsHoldLeft;
	bool sioHsHoldArmed;
	/* 联机传输统计：真机/游戏里排查时对着 logcat 看这几项就够 ——
	 * ok 是已完成次数，peak 是单次最坏耗时（0.1ms），to 是超时次数。 */
	uint32_t sioStartCycle;
	uint32_t sioOk;
	uint32_t sioPeak;
	uint32_t sioTimeouts;
	uint32_t sioLateness;
	uint32_t sioFallback;
	/* 联机快帧门（Qt 侧 sioFastFrame 的移植）：LINKUP 与训练家卡片块交换
	 * 完成后不再按墙钟等对端字，0ms 取不到就复用上一轮的对端字。
	 *   sioFastEnabled      -1 = 还没读系统属性
	 *   sioFastLatched      会话判据一次命中后锁存，避免每轮反复判定
	 *   sioFastMiss         连续没取到新字的轮数（≥240 解除锁存）
	 *   sioFastRemote/Valid 最近一轮真实的对端字（复用的来源）
	 *   sioFastN/Reuse      快帧轮次与其中复用陈旧字的次数（限频日志） */
	int sioFastEnabled;
	bool sioFastLatched;
	uint32_t sioFastMiss;
	/* 【MGBAX_FAST_SLAVE_ALIGN】从机快帧门因「本机 idx 与主机发布 idx 未对齐」
	 * 而挡下的轮数（机器可读诊断，默认门关时恒 0）。与 Qt sio_link.c 同名字段。 */
	uint32_t sioFastAlignBlocked;
	uint32_t sioFastRemote;
	bool sioFastRemoteValid;
	uint32_t sioFastN;
	uint32_t sioFastReuse;
	/* CMD-GUARD: 处于「gLink.state>=4 且 gReceivedRemoteLinkPlayers==0」的命令/
	 * 块交换期时，禁止用陈旧对端字冒充本轮真字收尾而被挡下的轮数。训练家卡
	 * 块收齐（rem==1）后自动恢复复用；机器可读诊断，见 GLINK/SIO fast 日志。 */
	uint32_t sioCmdGuardRounds;
	/* 【CMD-FRAMEALIGN】本会话是否已就着对端帧首 opcode 对齐过一次命令窗。
	 * 一次性；state<2 或新会话时复位。与 Qt sio_link.c 同契约。 */
	bool sioCmdFrameAligned;
	/* ROOTHUNT: 上次对齐的帧首 opcode（2222/BBBB 各自独立对齐一次）。 */
	uint16_t sioLastAlignHeader;
	uint32_t sioStarts;
	uint16_t sioIndex;
	uint32_t sioBails;
	uint32_t sioBusyCycle;
	uint32_t sioDbg;
	uint32_t sioPoll;
	uint32_t sioPrevStatus;
	uint32_t sioPrevAdv;
	uint32_t sioPrevHs;
	int32_t  sioPrevLinkState;
	int32_t  sioPrevPc;
	uint32_t sioPrevM0;
	uint32_t sioPrevM1;
	uint32_t sioKick;
	/* 游戏是否已经做过一次主从判定（它的第一笔 MULTI 写入）。在那之前必须
	 * 按「总线上只有自己」呈现 SIOCNT 的 Slave 位，否则两边都认为是从机。 */
	bool sioInitSeen;
	/* 真实速度探针：每 2 秒统计一次模拟帧数，用来发现「模拟时钟被网络等待冻住」。 */
	uint32_t probeWallAt;
	uint32_t probeFrames;
	uint32_t probeCycAt;
	/* 等对端应答的耗时统计（真实毫秒）。 */
	double sioWaitTotal;
	double sioWaitMax;
	uint32_t sioWaitN;
	/* 从机侧：拿到对端的字等了多久（排队时延）。 */
	uint32_t sioAgeTotal;
	uint32_t sioAgeMax;
	uint32_t sioAgeN;
	uint32_t sioPolls;
	uint32_t sioPollStamp;
	double sioSvcTotal;
	double sioSvcMax;
	uint32_t sioSvcN;
	/* 联机排查用的限次计数：轮询事件、请求消费、从机收尾各打前几条。 */
	uint32_t sioEvtDbg;
	uint32_t sioTakeDbg;
	uint32_t sioInDbg;
	uint32_t sioSkipDbg;
	uint32_t sioSlaveDoneDbg;
	/* 从机用：主机请求里的数据先存着，等本机下一次 MULTI 传输开始时再用。
	 * 主机跑在前面时请求会落在从机的空档里，直接丢掉就永远对不上了。 */
	uint32_t sioStash;
	bool sioStashValid;
	bool sioSlavePending;
	/* 「每轮推一次」的发送状态：sioPushIndex 是已经推出去的最新轮次（0 = 还没推），
	 * sioPushValue 只用于排查。 */
	uint32_t sioPushValue;
	uint16_t sioPushIndex;
	bool sioPushed;
	/* 取到的对端轮次和本机期望的不一致（丢了一轮）的次数。 */
	uint32_t sioMisorder;
	/* 联机排查：逐轮打印（有上限，不会刷爆 logcat）。 */
	uint32_t xferDbg;
	uint32_t pushDbg;
	uint32_t toDbg;
	/* 握手窗口定向日志：只打 8FFF/全零/超时轮，跳过几千轮 B9A0 等待。 */
	uint32_t hsDbg;
	uint32_t hsPushDbg;
	uint32_t hsStartDbg;
	/* gen8 联机命令队列探针：看 gLink 的收发队列到底有没有东西，
	 * 用来区分「链路没送到」和「游戏根本没入队」。 */
	uint32_t lkqFrames;
	/* 一次性内存扫描：握手卡住时把「连续两个 0xB9A0」的位置全找出来，
	 * 那就是游戏自己的 link 数据区。之前 PEEK_LINK 是照别的 ROM 定的地址，
	 * 读出来正好落在数据缓冲上（err/ck 读到的是 B9A0 的两个字节），
	 * 所以 hs/pc/adv 一直不可信。扫描只做一次，不常驻。 */
	uint32_t memScan;
	uint32_t heldKeys;
	uint32_t latchedKeys;
	uint32_t frameKeys;
	uint32_t appliedKeys;
	uint32_t turboMask;
	unsigned turboCounter;
	struct mKeyCallback keyCallback;
	struct mAudioResampler audioResampler;
	struct mAudioBuffer audioOut;
	bool audioResamplerInited;
	int audioOutRate;
	/* Linear copy of the core's audio the interpolator runs against. */
	int16_t* audioWindow;
	size_t audioWindowFrames;
	/* Frames per second the front end actually paces at; 0 = not measured
	 * yet, use the console's own frame rate. This is an eased estimate, not
	 * the raw window reading: raw readings scatter by a few percent per
	 * window (sleep quantization, GC) and stepping on them walks the pitch
	 * audibly, worst during fast-forward where the throughput wobbles most. */
	double audioPaceFps;
	/* Consecutive readings far enough from the estimate to be outliers. A
	 * single window can be a stall; the estimate only jumps when two in a
	 * row agree. */
	int audioPaceOutliers;
	/* Throughput the device last demonstrated, in console frames per second
	 * (pace x speed). Lets a speed change re-lock the resampler from the
	 * measured capability instead of guessing the console's nominal rate. */
	double audioPaceThroughput;
	/* Speed the current pace was measured at; set alongside every read. */
	double audioPaceSpeed;
	/*
	 * 不变速 (constant pitch) playback. A fast-forwarded game produces several
	 * times more audio than the device can play at the console's own speed.
	 * Dropping the surplus shreds the music; parking it and replaying made the
	 * tune jump a whole section whenever the park filled. Instead we time-stretch
	 * with WSOLA: the surplus is compressed in time while the pitch is kept, so
	 * fast-forward plays continuous, normal-tempo, normal-pitch music with no
	 * skipped section and no shredding.
	 *
	 * wsolaIn  - parked core audio (the WSOLA input queue)
	 * audioHold - WSOLA output, fed to the resampler at the console rate
	 */
	struct mAudioBuffer audioHold;       /* WSOLA output the resampler reads */
	struct mAudioBuffer wsolaIn;         /* WSOLA input queue (parked core audio) */
	size_t wsolaAnaPos;                  /* analysis cursor, frames from wsolaIn head */
	/* Frames the stretcher had to throw away because the staging buffer could
	 * not take them. Must stay 0: a non-zero value is a hole in the stream. */
	size_t wsolaDropped;
	size_t wsolaN;                       /* frame length, samples per channel */
	size_t wsolaHa;                      /* analysis hop, samples per channel */
	size_t wsolaHs;                      /* synthesis hop, samples per channel */
	double wsolaStretch;                 /* requested stretch (set by UI thread) */
	double wsolaConfigured;              /* stretch the buffers were built for */
	unsigned wsolaCoreRate;              /* core rate the buffers were built for（PC 重建守卫） */
	double wsolaOutAcc;                  /* 墙钟发射债务 carry（PC audio_stretch.c:585） */
	double wsolaLastTime;                /* 上一次发射的墙钟（PC audio_stretch.c:582） */
	float* wsolaAcc;                     /* OLA signal accumulator, length wsolaN*2 */
	int16_t* wsolaEmit;                  /* emit scratch, length wsolaN*2 */
	int16_t* wsolaPrev;                  /* last ref2 emitted-domain samples (phase ref) */
	int16_t* wsolaWindow;                /* Hann window, length wsolaN*2 */
	int16_t* wsolaScratch;               /* discard scratch for the input queue */
	/*
	 * Native-rate hold (音乐原速): the game's audio is streamed out at its own
	 * tempo and pitch - bit for bit what 1x would emit - and fast-forward is
	 * absorbed as LAG, not as skips. At 4x the console makes four seconds of
	 * music per real second, so only one of those four can be heard; instead
	 * of cutting the track into sections and dropping the gaps (which sounds
	 * like the music stuttering on and off), every frame that cannot be played
	 * in time is simply the oldest unplayed frame, which the ring overwrites.
	 * The output is one continuous, untransposed 1x stream that lags the game;
	 * nothing is ever dropped from what does play, so there is no jump.
	 *
 *   natRing       - the lag ring, holding up to natRingCap frames
 *   natRingCap    - ring capacity in frames (the lag ceiling)
 *   natW / natR   - absolute write / read frame counts
 *   natPrimed     - frames handed out since the hold began
 *   natPrimedTarget - fade-in length, frames (avoids a click at the start
 *                     and after every cut, which re-arms it)
 *   natLagDrops   - frames skipped by cuts (the sections that cannot be
 *                   heard at all)
 *   natCuts       - how many section skips have been executed
 */
	int16_t* natRing;
	size_t natRingCap;                    /* capacity in frames */
	size_t natW;                          /* absolute write frame count */
	size_t natR;                          /* absolute read frame count */
	size_t natPrimed;                     /* frames handed out since hold began */
	size_t natPrimedTarget;               /* fade-in length, frames */
	size_t natLagDrops;                   /* frames skipped by cuts */
	size_t natCuts;                       /* section skips executed */
	double natOutAcc;                     /* fractional output carry */
	double natLastTime;                   /* wall clock of the previous read */
	int audioHoldMode;                   /* MOBILE_AUDIO_HOLD_* (set by UI) */
	double audioHoldRate;                /* 音乐速度 rate（PC 第4自由度，钳 [0.5,4]，默认 1） */
	bool audioHoldOn;
	bool audioHoldInited;
	/* Set by the UI thread on every toggle; the audio thread clears the staged
	 * audio once before the next WSOLA run so a re-enable never replays stale
	 * samples. Kept as a flag so the UI thread never touches the buffers. */
	bool wsolaClearPending;
	/* 上一次的原始窗口读数（audioPaceHist[0]），HistLen>0 表示有效。
	 * 估算器按「两个连续读数一致才跳」过滤单点调度卡顿：三点中值会把
	 * 一次真实的速度变化也拖到 3~5 个窗口才确认，反而更慢。 */
	double audioPaceHist[3];
	int audioPaceHistLen;
	/* Front-end overrides applied on the next load. */
	int saveType;
	bool patches;
	bool useBios;
	bool skipBios;
	int rtcMode;
	int64_t rtcEpoch;
	int64_t rtcOffset;
	int solarLevel;
	bool cartRumble;
	volatile int rumbleHits;
	/* Solar/RTC/rumble live in the GBA board; they survive resets, so these
	 * sources can stay attached for the lifetime of the core. */
	struct GBALuminanceSource luminance;
	struct mRTCSource rtc;
	struct mRumble rumble;
	/* GB DMG palette override, one 0xRRGGBB entry per gb.pal[0..11] key.
	 * Applied through the core's config on load and live on the running core. */
	int32_t gbPalette[12];
	bool gbPaletteSet;
	bool sgbBorders;
	/* Tilt cartridge (WarioWare Twisted, Kirby Tilt'n'Tumble) driven by the
	 * device's sensors; normalized values scaled to the core's shift range. */
	struct mRotationSource rotation;
	volatile int32_t tiltX;
	volatile int32_t tiltY;
	volatile int32_t gyroZ;
	/* Ring of differential savestates for rewinding. A state is appended
	 * every REWIND_DIVIDER frames while enabled, so entries/2 spans seconds. */
	struct mCoreRewindContext rewind;
	bool rewindInited;
	bool rewindEnabled;
	unsigned rewindCounter;
	/* 内存监视（mgbaMobileSetMemoryWatch）：每帧轮询一小段内存，值变了就回调。
	 * 上限 64 字节，避免前端误传大区间导致每帧 O(n) 扫描。 */
	struct {
		bool active;
		uint32_t addr;
		uint32_t len;
		void (*cb)(uint32_t, uint32_t, void*);
		void* ctx;
		uint8_t prev[64];
		uint8_t cur[64];
	} watch;
	/* Per-channel audio gains, replayed on every load (see SetChannelVolumes). */
	int32_t channelGains[6];
	/*
	 * Per-instance state that used to live in function-local `static`s. With
	 * two cores in one process (本机双核心), those statics were shared: the
	 * unstick one-shot latch fired on core A and core B then skipped its own
	 * patch forever, while the streak counter was incremented by both cores.
	 * The desktop test injects a synthetic wall clock here too - a global hook
	 * meant destroying one core could silently change the other core's pacing.
	 */
	double (*audioClock)(void);
	bool unstickDone;
	int unstickStreak;
	int unstickModeCached;   /* -1 = not read yet */
	int rearmEnabled;        /* -1 = not read yet */
	int sioPipelineEnabled;  /* -1 = not read yet */
	unsigned diagTick;
	unsigned traceTick;
};

/* ROM 自解析的内存回退：struct MgbaMobile 定义完成后才解引用（见文件头声明）。 */
static struct MgbaMobile* s_romScanEmu;
static struct GBA* mobileLoadedGbaForScan(void) {
	if (!s_romScanEmu || !s_romScanEmu->core) {
		return NULL;
	}
	if (s_romScanEmu->core->platform(s_romScanEmu->core) != mPLATFORM_GBA) {
		return NULL;
	}
	return (struct GBA*) s_romScanEmu->core->board;
}

enum {
	MOBILE_RTC_WALL = 0,
	MOBILE_RTC_FIXED = 1,
	MOBILE_RTC_OFFSET = 2,
};

/* One rewind history entry every REWIND_DIVIDER frames; REWIND_ENTRIES of
 * them span REWIND_ENTRIES / 2 seconds of gameplay (about 60 s). */
enum {
	REWIND_DIVIDER = 30,
	REWIND_ENTRIES = 120,
};

/*
 * The mobile front ends pace emulation at the emulated console's own frame
 * rate (about 59.73 fps for GBA and GB), so games and audio run at hardware
 * speed. The resampler input rate still has to be scaled by the rate the front
 * end is actually managing: that is the console's frame rate when the device
 * keeps up, but a heavy game makes the front end miss its target and the
 * stream would slowly drift away from the audio device's clock. Front ends
 * feed the measured rate back with mgbaMobileSetAudioPaceFps; until they do,
 * the console's own frame rate is assumed, with this nominal rate left as the
 * fallback for consoles the core cannot describe.
 */
#define MOBILE_AUDIO_PACE_FPS 60.0
/* Range of front end paces the feedback is trusted for. */
#define MOBILE_AUDIO_PACE_FPS_MIN 15.0
#define MOBILE_AUDIO_PACE_FPS_MAX 240.0
/* Share of a window reading the applied pace absorbs at once. Falling
 * throughput is absorbed faster than rising: surplus production only fills
 * the buffers, while a shortfall drains them into underruns. */
#define MOBILE_AUDIO_PACE_EMA_UP 0.2
#define MOBILE_AUDIO_PACE_EMA_DOWN 0.4
/* A window reading this far from the applied pace is a stall or a spike (a
 * GC pause, a ROM load), not the pacing rate; two in a row are followed. */
#define MOBILE_AUDIO_PACE_OUTLIER 0.35
/* Per-window decay of the remembered device throughput, so a device that
 * slows down (thermals) is re-learned instead of being remembered forever. */
#define MOBILE_AUDIO_PACE_THROUGHPUT_DECAY 0.9995
/* How much already-resampled audio the reader may hold back between pumps. */
#define MOBILE_AUDIO_OUT_FRAMES 16384
/* WSOLA time-stretch for 不变速 playback. */
#define MOBILE_AUDIO_WSOLA_N 1024           /* frame length, samples per channel */
#define MOBILE_AUDIO_WSOLA_IN_SECONDS 6     /* input queue length, seconds */
#define MOBILE_AUDIO_WSOLA_OUT_SECONDS 2    /* output staging buffer, seconds */
#define MOBILE_AUDIO_WSOLA_SCRATCH 4096
/*
 * Native-rate hold (音乐原速). At 4x the console produces four seconds of music
 * per second of real time while the speaker can emit one, so three of those
 * seconds cannot be heard - the only choice is where the cut lands. Sections
 * play at their own tempo and pitch, then the skipper jumps ahead, preferring
 * to do it inside a gap between notes: GBA scores are short loops with plenty
 * of them, so a cut placed on silence is inaudible. A short cross-fade at the
 * seam covers whatever is left.
 */
#define MOBILE_AUDIO_NATIVE_RING_SECONDS 6.0 /* max music lag behind the game */
/* A cut lands inside the freshest span of this length (searched for the
 * quietest stretch), which also caps how much unplayed audio one cut keeps. */
#define MOBILE_AUDIO_NATIVE_SCAN_SECONDS 1.5
#define MOBILE_AUDIO_NATIVE_QUIET_SECONDS 0.010  /* quiet-window length */
#define MOBILE_AUDIO_NATIVE_RESERVE_SECONDS 0.10 /* unplayed frames kept past a cut */
/* Level the playback buffer is topped up to after every pull. Small enough
 * that one front-end read is never satisfied twice in a row (which is what
 * overfills the non-blocking AudioTrack), large enough to cover the mixer
 * period: roughly 62 ms at the GBA's 65536 Hz. */
#define MOBILE_AUDIO_NATIVE_LEVEL_FRAMES 4096

/* Wall clock for pacing the 音乐原速 hand-out. The native test runs emulation
 * as fast as it can, so no real time passes between its reads and a wall clock
 * would hand out nothing; it installs a synthetic clock through
 * mgbaMobileSetAudioClock() instead. The hook is per MgbaMobile instance:
 * two cores in one process must not share it. */

/* 真实墙钟（毫秒）。不用 audioNow —— 那个可能被原生测试替换成合成时钟，
 * 而联机排查要量的是真实耗时（等对端应答花了多少毫秒）。 */
static uint32_t wallNowMs(void) {
	struct timespec ts;
	if (clock_gettime(CLOCK_MONOTONIC, &ts) == 0) {
		return (uint32_t) (ts.tv_sec * 1000u + ts.tv_nsec / 1000000u);
	}
	return 0;
}

static double audioNow(struct MgbaMobile* emu) {
	if (emu && emu->audioClock) {
		return emu->audioClock();
	}
	/* clock_gettime 在安卓(bionic)与桌面(winpthreads)都有；旧的
	 * timespec_get 分支在 MSYS2 MinGW 头文件里不存在，桌面构建过不去。 */
	struct timespec ts;
	if (clock_gettime(CLOCK_MONOTONIC, &ts) == 0) {
		return (double) ts.tv_sec + (double) ts.tv_nsec / 1e9;
	}
	return 0.0;
}

/* Per-instance synthetic wall clock, used by the desktop audio tests. */
void mgbaMobileSetAudioClock(struct MgbaMobile* emu, double (*clock)(void)) {
	if (emu) {
		emu->audioClock = clock;
	}
}

bool mgbaMobileHasSyntheticAudioClock(const struct MgbaMobile* emu) {
	return emu && emu->audioClock != NULL;
}

/* How fast-forward audio is produced when the front end asks for it: see the
 * MOBILE_AUDIO_HOLD_* enum in mgba_mobile.h. */

static void attachKeyCallback(struct MgbaMobile* emu);
static void detachLink(struct MgbaMobile* emu);
static void pollLink(struct MgbaMobile* emu);
static void applyLinkTerminalBits(struct MgbaMobile* emu);
static double audioNativeFps(const struct MgbaMobile* emu);
static void attachCartHw(struct MgbaMobile* emu);
static void tiltSample(struct mRotationSource* rotation);
static int32_t tiltReadX(struct mRotationSource* rotation);
static int32_t tiltReadY(struct mRotationSource* rotation);
static int32_t tiltReadGyro(struct mRotationSource* rotation);
static void loadCheats(struct MgbaMobile* emu);
static void saveCheats(struct MgbaMobile* emu);

static void copyPath(char* dst, size_t dstLen, const char* src) {
	if (!src) {
		dst[0] = '\0';
		return;
	}
	snprintf(dst, dstLen, "%s", src);
}

static void resetAudioOutput(struct MgbaMobile* emu) {
	if (!emu->audioResamplerInited) {
		return;
	}
	// The source buffer belongs to the core; drop the resampler's bookkeeping
	// so a freshly loaded core starts from a clean state.
	emu->audioResampler.timestamp = 0;
	mAudioBufferClear(&emu->audioOut);
}

static void deinitAudioHold(struct MgbaMobile* emu) {
	if (!emu->audioHoldInited) {
		return;
	}
	mAudioBufferDeinit(&emu->audioHold);
	mAudioBufferDeinit(&emu->wsolaIn);
	free(emu->wsolaAcc);
	free(emu->wsolaEmit);
	free(emu->wsolaPrev);
	free(emu->wsolaWindow);
	free(emu->wsolaScratch);
	free(emu->natRing);
	emu->wsolaAcc = NULL;
	emu->wsolaEmit = NULL;
	emu->wsolaPrev = NULL;
	emu->wsolaWindow = NULL;
	emu->wsolaScratch = NULL;
	emu->natRing = NULL;
	emu->audioHoldInited = false;
}

/*
 * (Re)configures the WSOLA time-stretcher for a given stretch factor. The
 * synthesis hop is held at a fixed 50% window overlap (clean Hann COLA) and the
 * analysis hop is scaled so the ratio analysis/synthesis equals the stretch:
 * dropping s = mult times more audio than real time, compressed into real time,
 * means the music runs at its own tempo with no skipped section.
 */
static void initAudioHold(struct MgbaMobile* emu, unsigned coreRate, double stretch) {
	/* `stretch` is the requested multiplier (emu->wsolaStretch, set by the UI).
	 * Compare against what the buffers were actually built for - not against
	 * wsolaStretch itself, which would always match and never rebuild when the
	 * fast-forward speed changes. Rebuilding only ever happens here, on the
	 * audio thread, so the buffers are never freed under a running
	 * wsolaGenerate. */
	if (emu->audioHoldInited && fabs(stretch - emu->wsolaConfigured) < 0.01 && emu->wsolaCoreRate == coreRate) {
		return;
	}
	deinitAudioHold(emu);
	if (!coreRate || stretch < 1.001) {
		return;
	}
	emu->wsolaN = MOBILE_AUDIO_WSOLA_N;
	/* 50% synthesis overlap: the window is the whole frame and the synthesis hop
	 * is half the frame, so a plain Hann window is exactly COLA-flat and - more
	 * importantly - the overlap is low enough that near-identical phase-locked
	 * segments do not over-overlap into a comb-filter / "electric" chorus. The
	 * analysis hop is scaled by the stretch (Ha = N/2 * stretch), so the ratio
	 * analysis/synthesis equals the stretch; for stretch > 2 this necessarily
	 * skips some input uniformly, which is time compression rendered through a
	 * smooth overlap-add (not a decimation) and is inaudible as a jump. */
	emu->wsolaHs = emu->wsolaN / 2;
	emu->wsolaHa = (size_t) (emu->wsolaN / 2.0 * stretch + 0.5);
	if (emu->wsolaHs < 1) {
		emu->wsolaHs = 1;
	}
	if (emu->wsolaHa < 1) {
		emu->wsolaHa = 1;
	}
	emu->wsolaConfigured = stretch;
	emu->wsolaCoreRate = coreRate;
	emu->wsolaAnaPos = 0;
	emu->wsolaDropped = 0;
	/* Native-rate hold geometry (音乐原速): a lag ring a few seconds deep.
	 * The game's audio is written into the ring at the fast-forward rate and
	 * read out at the console's own rate. The surplus cannot be heard at any
	 * multiplier, so it is dropped in whole sections: the ring fills up to
	 * the lag ceiling, then one cut jumps the read pointer to the quietest
	 * stretch of the freshest audio (a gap between notes) and playback runs
	 * uninterrupted again until the ceiling is reached once more. */
	emu->natRingCap = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_RING_SECONDS + 0.5);
	if (emu->natRingCap < 2048) {
		emu->natRingCap = 2048;
	}
	emu->natW = 0;
	emu->natR = 0;
	emu->natPrimed = 0;
	emu->natPrimedTarget = (size_t) (coreRate * 0.012 + 0.5);  /* 12 ms fade-in */
	if (emu->natPrimedTarget < 16) {
		emu->natPrimedTarget = 16;
	}
	emu->natLagDrops = 0;
	emu->natCuts = 0;
	emu->natOutAcc = 0.0;
	emu->natLastTime = 0.0;
	mAudioBufferInit(&emu->audioHold, (size_t) coreRate * MOBILE_AUDIO_WSOLA_OUT_SECONDS, 2);
	mAudioBufferInit(&emu->wsolaIn, (size_t) coreRate * MOBILE_AUDIO_WSOLA_IN_SECONDS, 2);
	/* Mark inited now so a failed allocation below is cleaned up by
	 * deinitAudioHold() instead of leaking and leaving a half-built state. */
	emu->audioHoldInited = true;
	emu->wsolaOutAcc = 0.0;
	emu->wsolaLastTime = 0.0;
	emu->wsolaAcc = (float*) calloc(emu->wsolaN * 2, sizeof(float));
	emu->wsolaEmit = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaPrev = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaWindow = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaScratch = (int16_t*) calloc(MOBILE_AUDIO_WSOLA_SCRATCH * 2, sizeof(int16_t));
	emu->natRing = (int16_t*) calloc(emu->natRingCap * 2, sizeof(int16_t));
	if (!emu->wsolaAcc || !emu->wsolaEmit || !emu->wsolaPrev || !emu->wsolaWindow || !emu->wsolaScratch || !emu->natRing) {
		/* Out of memory: fall back to the plain (non-stretched) path rather
		 * than dereferencing a NULL accumulator. */
		deinitAudioHold(emu);
		return;
	}
	size_t n2 = emu->wsolaN * 2;
	/* Periodic Hann (denominator n2, not n2-1). At the 50% synthesis overlap
	 * w[j] + w[j + N] == 1 exactly, so the overlap-add is COLA-flat: the seam
	 * gain is a constant 1, no amplitude ripple and - critically - no
	 * comb-filter / "electric" coloration. */
	for (size_t i = 0; i < n2; ++i) {
		double w = 0.5 * (1.0 - cos(2.0 * M_PI * i / n2));
		emu->wsolaWindow[i] = (int16_t) (w * 32767.0);
	}
}

/* Parks everything the core just produced into the WSOLA input queue. */
static void wsolaFeed(struct MgbaMobile* emu, struct mAudioBuffer* source) {
	size_t available;
	size_t capacity = mAudioBufferCapacity(&emu->wsolaIn);
	while ((available = mAudioBufferAvailable(source)) > 0) {
		/* Never read more than the parked queue can take: the samples are
		 * already out of the core's ring by then, so anything mAudioBufferWrite
		 * refuses would be lost mid-stream. Leaving them in the ring keeps the
		 * pressure on the core instead of punching a hole in the music. */
		size_t room = capacity - mAudioBufferAvailable(&emu->wsolaIn);
		size_t chunk = available > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : available;
		if (chunk > room) {
			chunk = room;
		}
		if (!chunk) {
			break;
		}
		size_t got = mAudioBufferRead(source, emu->wsolaScratch, chunk);
		if (!got) {
			break;
		}
		size_t put = mAudioBufferWrite(&emu->wsolaIn, emu->wsolaScratch, got);
		if (put < got) {
			emu->wsolaDropped += got - put;
		}
	}
}

/*
 * Runs the WSOLA time-stretcher to fill the output buffer with up to `want`
 * frames. For each synthesis step it slides an analysis window through the
 * input, picks the offset whose start best matches the samples already emitted
 * (phase alignment, so the overlap-add stays continuous), windows it with a
 * Hann window and overlap-adds into the accumulator before flushing the final
 * leading samples. Because input is consumed at the analysis hop and output is
 * emitted at the synthesis hop, the ratio of the two is exactly the stretch:
 * no section is ever dropped, so the tune never jumps.
 *
 * The synthesis overlap is fixed at 50% (wsolaHs = wsolaN/2), which is the
 * overlap at which a Hann window is naturally COLA-flat and - critically - the
 * overlap is low enough that near-identical phase-locked segments do not
 * over-overlap into a comb-filter / "electric" coloration. The analysis hop is
 * scaled by the stretch, so for stretch > 2 some input is skipped uniformly;
 * that is time compression, rendered via a smooth overlap-add rather than a
 * decimation, so it is inaudible as a jump.
 */
/* 归一化互相关（照抄 PC audio_stretch.c:214-226）：把左右声道幅度和当单声道，
 * 返回 [-1, 1]；粗、细两级搜索共用同一内循环。 */
static float wsolaCorrelate(struct mAudioBuffer* in, const int16_t* prev, int d, size_t ref) {
	long long dot = 0, e1 = 0, e2 = 0;
	for (size_t i = 0; i < ref; ++i) {
		int16_t L = mAudioBufferPeek(in, 0, d + i);
		int16_t R = mAudioBufferPeek(in, 1, d + i);
		int ma = (int) L + (int) R;
		int mp = (int) prev[i * 2] + (int) prev[i * 2 + 1];
		dot += (long long) ma * mp;
		e1 += (long long) ma * ma;
		e2 += (long long) mp * mp;
	}
	return e2 > 0 ? (float) dot / (sqrtf((float) e1 * e2) + 1) : 0;
}

static size_t wsolaGenerate(struct MgbaMobile* emu, size_t want) {
	if (!emu->audioHoldInited) {
		return 0;
	}
	size_t N = emu->wsolaN;            /* analysis frame length, stereo frames */
	size_t N2 = N * 2;                 /* full frame, interleaved samples     */
	size_t Ha = emu->wsolaHa;          /* analysis hop, frames               */
	size_t Hs = emu->wsolaHs;          /* synthesis hop, frames (N/2)        */
	size_t Hs2 = Hs * 2;               /* = N, the 50% overlap-add stride    */
	size_t W2 = N2;                    /* overlap-add window = whole frame    */
	/* Phase-lock over the synthesis hop: the new frame's first Hs samples must
	 * continue from the Hs samples just emitted, so the seam is continuous. */
	size_t ref = Hs;
	size_t ref2 = Hs2;
	float* acc = emu->wsolaAcc;
	int16_t* win = emu->wsolaWindow;    /* plain Hann window (COLA-flat at 50%) */
	int16_t* prev = emu->wsolaPrev;     /* output-domain phase reference        */
	int16_t* frame = emu->wsolaScratch; /* single-frame scratch (int16) */
	int16_t* emit = emu->wsolaEmit;     /* emit scratch (int16) */
	size_t available = mAudioBufferAvailable(&emu->wsolaIn);
	size_t holdCapacity = mAudioBufferCapacity(&emu->audioHold);
	size_t ap = emu->wsolaAnaPos;
	size_t produced = 0;
	/* Search tolerance is kept small - only a few signal periods - so the phase
	 * match lands on the true continuation rather than jumping to a
	 * wrong-harmonic correlation peak. With a large analysis hop (high stretch)
	 * a wide tolerance lets the cross-correlation lock onto a peak one or more
	 * whole periods away, which halves (or worse) the effective stride and doubles
	 * the perceived pitch. A coarse step keeps the search stable. */
	int tol = (int) (N / 4);
	if (tol > (int) (Ha / 2)) {
		tol = (int) (Ha / 2);
	}

	/* Emit at most what this call was asked for, and never start a frame the
	 * staging buffer cannot hold in full. Over-producing is what broke the
	 * device: the front end asks for a big block (AUDIO_READ_FRAMES = 8192) and
	 * the old `want * 8` bound let one call pour tens of thousands of frames
	 * into a two-second staging buffer. mAudioBufferWrite then accepted short
	 * writes and the remainder was discarded - whole synthesis hops vanished
	 * from the music while the analysis cursor still advanced, so fast-forward
	 * played chopped, gappy audio instead of the stretched track. Backpressure
	 * (stop, leave the input parked) keeps every hop intact. */
	while (produced < want && ap + N <= available) {
		if (holdCapacity - mAudioBufferAvailable(&emu->audioHold) < Hs) {
			break;
		}
		int lo = (int) ap - tol;
		if (lo < 0) {
			lo = 0;
		}
		int hi = (int) ap + tol;
		if ((size_t) (hi + (int) N) > available) {
			hi = (int) available - (int) N;
		}
		if (hi < lo) {
			hi = lo;
		}
		/* 两级相位搜索（照抄 PC audio_stretch.c:280-316）：粗扫 step 4 找近似
		 * 连续点，再在 bestD ± 8 内逐样本细化。旧单级 step 8 把相位量化到
		 * 半周期外，两帧在 50% OLA 交叉抵消、掏空高频（发闷）。 */
		int coarseStep = 4;
		int bestD = (int) ap;
		float best = -1e30f;
		for (int d = lo; d <= hi; d += coarseStep) {
			float sc = wsolaCorrelate(&emu->wsolaIn, prev, d, ref);
			if (sc > best) {
				best = sc;
				bestD = d;
			}
		}
		int flo = bestD - 2 * coarseStep;
		if (flo < lo) { flo = lo; }
		int fhi = bestD + 2 * coarseStep;
		if (fhi > hi) { fhi = hi; }
		best = -1e30f;
		int fineBest = bestD;
		for (int d = flo; d <= fhi; ++d) {
			float sc = wsolaCorrelate(&emu->wsolaIn, prev, d, ref);
			if (sc > best) {
				best = sc;
				fineBest = d;
			}
		}
		bestD = fineBest;
		size_t fp = (size_t) bestD;
		for (size_t i = 0; i < N; ++i) {
			frame[i * 2] = mAudioBufferPeek(&emu->wsolaIn, 0, fp + i);
			frame[i * 2 + 1] = mAudioBufferPeek(&emu->wsolaIn, 1, fp + i);
		}
		/* Overlap-add with the Hann window at the fixed 50% synthesis overlap. A
		 * Hann window sums to a constant there, so the seam gain is flat (no
		 * amplitude modulation / electric ringing) and - because the overlap is
		 * only 50% - near-identical phase-locked segments do not over-overlap into
		 * the comb-filter / "electric" chorus that the old 87.5% overlap had. */
		for (size_t i = 0; i < W2; ++i) {
			acc[i] += (float) frame[i] * (float) win[i] * (1.0f / 32768.0f);
		}
		for (size_t i = 0; i < Hs2; ++i) {
			float v = acc[i];
			int iv = (int) (v + (v >= 0 ? 0.5f : -0.5f));
			if (iv > 32767) {
				iv = 32767;
			} else if (iv < -32768) {
				iv = -32768;
			}
			emit[i] = (int16_t) iv;
		}
		size_t wrote = mAudioBufferWrite(&emu->audioHold, emit, Hs);
		if (wrote < Hs) {
			/* Should not happen (room was checked above), but a short write is
			 * a hole in the stream - record it instead of hiding it. */
			emu->wsolaDropped += Hs - wrote;
		}
		/* Advance the phase reference: keep the last ref2 samples of the
		 * accumulator tail - the windowed overlap region of the frame just emitted
		 * - so the next frame's head is phase-aligned to it. */
		{
			size_t base = W2 - ref2;
			for (size_t i = 0; i < ref2; ++i) {
				float v = acc[base + i];
				int iv = (int) (v + (v >= 0 ? 0.5f : -0.5f));
				if (iv > 32767) iv = 32767;
				else if (iv < -32768) iv = -32768;
				prev[i] = (int16_t) iv;
			}
		}
		memmove(acc, acc + Hs2, (W2 - Hs2) * sizeof(float));
		/* The shift left by Hs2 leaves acc[Hs2 .. W2) holding the bytes that were
		 * already there; clear it so the next overlap-add only mixes in the
		 * *current* frame's tail. Without this the accumulator would sum every
		 * previous tail indefinitely, blowing the signal up into a distorted,
		 * ever-growing waveform - the "electric" / metallic artefact. */
		memset(acc + Hs2, 0, (W2 - Hs2) * sizeof(float));
		produced += Hs;
		ap = fp + Ha;
	}
	emu->wsolaAnaPos = ap;
	if (ap > 0) {
		size_t rem = ap;
		while (rem > 0) {
			size_t c = rem > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : rem;
			mAudioBufferRead(&emu->wsolaIn, emu->wsolaScratch, c);
			rem -= c;
		}
		emu->wsolaAnaPos = 0;
	}
	return produced;
}

/*
 * 音乐原速 playback.
 *
 * A section is played straight out of the core, at its own tempo and pitch -
 * bit for bit what 1x would emit - and then a whole section is skipped before
 * the next one starts. The skip is unavoidable: at 4x the console hands over
 * four seconds of music per second of real time while the speaker can emit
 * one, so three of those four seconds can never be heard; the only thing a
 * policy can choose is where the loss lands. Dropping it frame-by-frame as it
 * arrives (the first cut at this) re-samples the tune at 1/stretch and plays
 * the fragments back to back - the melody then rushes through at the game's
 * speed, which is exactly the "音乐仍然变快" report this file exists to fix.
 * Instead the surplus accumulates in the ring and leaves in one cut:
 *
 *  - the cut is deferred until the lag ring is full (seconds of uninterrupted
 *    tune before it, not milliseconds);
 *  - it lands on the quietest stretch of the freshest audio - a gap between
 *    notes, since GBA scores are short loops with plenty of them - rather
 *    than in the middle of one;
 *  - the incoming section is faded in over the usual 12 ms, so a cut that
 *    still lands on sound does not click.
 *
 * The long-run content rate is exactly 1/stretch of the score: played = what
 * real time allows, skipped = everything else, with no drift to track.
 */
static void nativeHoldCut(struct MgbaMobile* emu, size_t need, unsigned coreRate) {
	size_t cap = emu->natRingCap;
	size_t quiet = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_QUIET_SECONDS + 0.5);
	size_t scan = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_SCAN_SECONDS + 0.5);
	size_t guard = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_RESERVE_SECONDS + 0.5);
	size_t landMin = emu->natR + need;    /* must free at least the overflow */
	size_t landMax = emu->natW > guard ? emu->natW - guard : emu->natR;
	size_t zoneLo, zoneHi, best, bestEnergy, pos, k;
	if (quiet < 16) {
		quiet = 16;
	}
	if (landMax < landMin) {
		/* Degenerate (need larger than the backlog can spare): fall back to
		 * the plain drop-to-fit so the ring invariant always holds. */
		emu->natLagDrops += need;
		/* 照抄 PC audio_stretch.c:388-401：退化时 natR=natW（清空到写指针），
		 * 不用 landMin——后者可 > natW 造成 natW-natR 下溢。 */
		emu->natR = emu->natW;
		emu->natPrimed = 0;
		++emu->natCuts;
		return;
	}
	/* Prefer the freshest audio: landing near the write head makes this cut
	 * - and therefore the stretch until the next one - as long as possible. */
	zoneLo = landMax > landMin + scan ? landMax - scan : landMin;
	zoneHi = landMax;
	best = zoneLo;
	bestEnergy = (size_t) -1;
	for (pos = zoneLo; pos + quiet <= zoneHi; pos += quiet) {
		size_t energy = 0;
		for (k = 0; k < quiet; ++k) {
			const int16_t* frame = &emu->natRing[((pos + k) % cap) * 2];
			int l = frame[0];
			int r = frame[1];
			energy += (size_t) (l < 0 ? -l : l) + (size_t) (r < 0 ? -r : r);
		}
		if (energy < bestEnergy) {
			bestEnergy = energy;
			best = pos;
		}
	}
	emu->natLagDrops += best - emu->natR;
	emu->natR = best;
	emu->natPrimed = 0;   /* re-arm the fade-in over the seam */
	++emu->natCuts;
}

static size_t nativeHoldGenerate(struct MgbaMobile* emu, struct mAudioBuffer* source, size_t want) {
	unsigned coreRate = emu->core ? emu->core->audioSampleRate(emu->core) : 0;
	size_t cap = emu->natRingCap;
	size_t holdCap = mAudioBufferCapacity(&emu->audioHold);
	size_t holdAvail = mAudioBufferAvailable(&emu->audioHold);
	size_t produced = 0;

	if (!emu->natRing || !cap || !coreRate) {
		return 0;
	}

	/* 1. Pull the core's audio into the lag ring. The game runs `stretch`
	 * times faster than real time, so it produces `stretch` times more audio
	 * than we hand out. While the ring has room the played stream is one
	 * continuous, untransposed 1x section; once it is full, whole sections
	 * are cut away at the quietest spot (nativeHoldCut) instead of shaving
	 * a little off every batch - shaving is what made the tune rush. */
	size_t startR = emu->natR;
	size_t avail = mAudioBufferAvailable(source);
	while (avail) {
		size_t n = avail > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : avail;
		n = mAudioBufferRead(source, emu->wsolaScratch, n);
		if (!n) {
			break;
		}
		if (emu->natW + n - emu->natR > cap) {
			nativeHoldCut(emu, emu->natW + n - emu->natR - cap, coreRate);
		}
		for (size_t k = 0; k < n; ++k) {
			size_t widx = emu->natW % cap;
			emu->natRing[widx * 2] = emu->wsolaScratch[k * 2];
			emu->natRing[widx * 2 + 1] = emu->wsolaScratch[k * 2 + 1];
			emu->natW++;
		}
		avail -= n;
	}

	/* 2. Hand out exactly what real time has advanced - one frame per core
	 * sample of wall clock, independent of the multiplier and of how fast the
	 * device can actually emulate. This is the only quantity that means the
	 * same thing at every speed, so it is the one that keeps the music at the
	 * console's own tempo. */
	double now = audioNow(emu);
	double dt = now - emu->natLastTime;
	emu->natLastTime = now;
	if (dt > 0.0 && dt < 0.5) {
		emu->natOutAcc += dt * (double) coreRate * emu->audioHoldRate;   /* PC: *rate（音乐速度） */
	}
	double acc = emu->natOutAcc;
	size_t budget = (size_t) acc;
	emu->natOutAcc = acc - (double) budget;

	size_t have = emu->natW - emu->natR;   /* unread frames in the ring */
	if (budget > have) {
		budget = have;
	}
	if (budget > (size_t) want) {
		budget = (size_t) want;
	}
	if (budget > holdCap - holdAvail) {
		budget = holdCap - holdAvail;
	}
	/* wsolaScratch holds exactly MOBILE_AUDIO_WSOLA_SCRATCH stereo frames, but
	 * `want` can be 8192 (the device pump reads 8192-frame blocks). Without
	 * this clamp the copy below writes up to 2x past the allocation whenever a
	 * wall-clock jump makes `budget` large - a load-dependent heap overwrite,
	 * which is why the full suite only crashed intermittently under load. */
	if (budget > MOBILE_AUDIO_WSOLA_SCRATCH) {
		budget = MOBILE_AUDIO_WSOLA_SCRATCH;
	}

	/* 3. Copy `budget` frames out of the ring into the playback buffer. The
	 * first few frames are faded in so re-entering the hold does not click
	 * against silence; everything else is the original 1x sample, untouched. */
	for (size_t done = 0; done < budget; ) {
		size_t ridx = emu->natR % cap;
		size_t room = cap - ridx;
		size_t chunk = budget - done;
		if (chunk > room) {
			chunk = room;
		}
		for (size_t k = 0; k < chunk; ++k) {
			int16_t l = emu->natRing[(ridx + k) * 2];
			int16_t r = emu->natRing[(ridx + k) * 2 + 1];
			size_t played = emu->natPrimed + k;
			if (played < emu->natPrimedTarget) {
				int a = (int) ((played * 256) / (emu->natPrimedTarget > 0 ? emu->natPrimedTarget : 1));
				l = (int16_t) (((int) l * a) / 256);
				r = (int16_t) (((int) r * a) / 256);
			}
			emu->wsolaScratch[(done + k) * 2] = l;
			emu->wsolaScratch[(done + k) * 2 + 1] = r;
		}
		size_t wrote = mAudioBufferWrite(&emu->audioHold, emu->wsolaScratch + done * 2, chunk);
		emu->natR += wrote;
		emu->natPrimed += wrote;
		done += wrote;
		if (wrote < chunk) {
			break;   /* playback buffer full; finish next call */
		}
	}
	produced = emu->natR - startR;
	return produced;
}
static void deinitAudioOutput(struct MgbaMobile* emu) {
	deinitAudioHold(emu);
	free(emu->audioWindow);
	emu->audioWindow = NULL;
	emu->audioWindowFrames = 0;
	if (!emu->audioResamplerInited) {
		return;
	}
	mAudioResamplerDeinit(&emu->audioResampler);
	mAudioBufferDeinit(&emu->audioOut);
	emu->audioResamplerInited = false;
	emu->audioOutRate = 0;
}

static void destroyCore(struct MgbaMobile* emu) {
	if (!emu->core) {
		return;
	}
	__atomic_store_n(&emu->romLoaded, false, __ATOMIC_RELAXED);
	detachLink(emu);
	resetAudioOutput(emu);
	mCoreConfigDeinit(&emu->core->config);
	emu->core->deinit(emu->core);
	emu->core = NULL;
	free(emu->video);
	emu->video = NULL;
	free(emu->prev);
	emu->prev = NULL;
	emu->havePrev = false;
	emu->width = 0;
	emu->height = 0;
	// A freshly loaded game is assumed to be paced at its own frame rate;
	// front-end readings accumulate from there. This also drops an estimate a
	// stall may have dragged across the load. The throughput memory survives:
	// it describes the device, not the game state.
	emu->audioPaceFps = 0.0;
	emu->audioPaceOutliers = 0;
	emu->audioPaceHistLen = 0;
	emu->audioPaceSpeed = 0.0;
}

static bool ensureVideo(struct MgbaMobile* emu) {
	unsigned width = 0;
	unsigned height = 0;
	emu->core->currentVideoSize(emu->core, &width, &height);
	if (width == 0 || height == 0) {
		emu->core->baseVideoSize(emu->core, &width, &height);
	}
	if (width == 0 || height == 0 || width > 1024 || height > 1024) {
		return false;
	}
	if (emu->video && emu->width == width && emu->height == height) {
		return true;
	}
	mColor* video = (mColor*) calloc((size_t) width * height, sizeof(mColor));
	if (!video) {
		return false;
	}
	free(emu->video);
	emu->video = video;
	free(emu->prev);
	emu->prev = NULL;
	emu->width = width;
	emu->height = height;
	emu->havePrev = false;
	emu->core->setVideoBuffer(emu->core, emu->video, width);
	return true;
}

#ifdef __APPLE__
/* iOS 默认 logger：核心日志直写 stderr（CI 经 simctl launch --console-pty
 * 捕获）。含 INFO 级，用于诊断核心加载/锁步卡点。 */
static void iosDefaultLog(struct mLogger* logger, int category, enum mLogLevel level,
                          const char* format, va_list args) {
	(void) logger;
	(void) category;
	(void) level;
	vfprintf(stderr, format, args);
	fputc('\n', stderr);
	fflush(stderr);
}
static struct mLogger s_iosDefaultLogger = { iosDefaultLog, NULL };
#endif

/* 跨端统一的 rearm 开关读法：默认开，仅显式 =0 关闭。
 * 抽成函数是为了让启动诊断与实际门控读同一个值，避免两处漂移。
 * ENV-REGISTRY D1：Qt 默认关 / mobile 默认开 / driver 强制开三方冲突，
 * 2026-11-17 统一为开（Qt 侧同步改为开），driver 的 force-ON 保持一致。 */
static int rearmEnabledFromEnv(void) {
#ifdef __ANDROID__
	char v[PROP_VALUE_MAX] = {0};
	rhGetProp("mgbax.link.rearm", v);
	return (v[0] == '0') ? 0 : 1;
#else
	const char* v = getenv("MGBAX_LINK_REARM");
	return (v && v[0] == '0') ? 0 : 1;
#endif
}

static void mobileRearmDiag(void) {
#ifdef __ANDROID__
	char v[PROP_VALUE_MAX] = {0};
	rhGetProp("mgbax.link.rearm", v);
	MOBILE_LOGI("[MGBAX_GATE] rearm_default=%s (mgbax.link.rearm=%s)",
	            rearmEnabledFromEnv() ? "ON" : "OFF", v[0] ? v : "<unset>");
#else
	const char* v = getenv("MGBAX_LINK_REARM");
	MOBILE_LOGI("[MGBAX_GATE] rearm_default=%s (MGBAX_LINK_REARM=%s)",
	            rearmEnabledFromEnv() ? "ON" : "OFF", v ? v : "<unset>");
#endif
}

struct MgbaMobile* mgbaMobileCreate(const char* saveDir, const char* stateDir, const char* port) {	struct MgbaMobile* emu = (struct MgbaMobile*) calloc(1, sizeof(struct MgbaMobile));
	if (!emu) {
		return NULL;
	}
	emu->audioHoldRate = MOBILE_AUDIO_RATE_DEF;   /* rate 默认 1.0（calloc 为 0 会除零） */
#ifdef __APPLE__
	/* iOS 没装 mLog 前端 logger，核心日志全部丢弃——CI 上核心加载卡死时
	 * 无从诊断。装一个直写 stderr 的默认 logger（含 INFO），日志经
	 * simctl launch --console-pty 可见。 */
	{
		static struct mLogger s_iosDefaultLogger;
		s_iosDefaultLogger.log = iosDefaultLog;
		s_iosDefaultLogger.filter = NULL;
		mLogSetDefaultLogger(&s_iosDefaultLogger);
	}
#endif
	/* 递归锁：加锁点既在 C 层的 mgbaMobileRunFrames / SaveStateToMemory /
	 * LoadStateToMemory 内部（这样 iOS 直接调用 C 函数也受保护，它不经过
	 * JNI），也在 JNI 的入口（安卓侧的历史做法）。同一线程沿途二次加锁必须
	 * 不能自死锁，所以这里用 PTHREAD_MUTEX_RECURSIVE。 */
	{
		pthread_mutexattr_t attr;
		pthread_mutexattr_init(&attr);
		pthread_mutexattr_settype(&attr, PTHREAD_MUTEX_RECURSIVE);
		int rc = pthread_mutex_init(&emu->coreMutex, &attr);
		pthread_mutexattr_destroy(&attr);
		if (rc != 0) {
			free(emu);
			return NULL;
		}
	}
	emu->coreMutexReady = true;
	copyPath(emu->savePath, sizeof(emu->savePath), saveDir);
	copyPath(emu->statePath, sizeof(emu->statePath), stateDir);
	copyPath(emu->port, sizeof(emu->port), port && port[0] ? port : "mobile");
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), ".sav");
	if (emu->savePath[0]) {
		mobile_mkdir(emu->savePath);
	}
	if (emu->statePath[0]) {
		mobile_mkdir(emu->statePath);
	}
	/* -1 means "not resolved yet": calloc gives 0, which would otherwise look
	 * like a cached "disabled" answer and skip the env/property lookup. */
	emu->unstickModeCached = -1;
	emu->rearmEnabled = -1;
	mobileRearmDiag();
	emu->sioPipelineEnabled = -1;
	emu->sioFastEnabled = -1;
	emu->busGameIdx = -1;
	emu->link = netLinkCreate();
	emu->gbaLink.emu = emu;
	emu->gbLink.emu = emu;
	// Defaults keep this front end's shipped behaviour: save type forced to
	// FLASH1M, BIOS used but skipped, patches on. The Java settings can change
	// all of these between launches.
	emu->saveType = GBA_SAVEDATA_FLASH1M;
	emu->patches = true;
	emu->useBios = true;
	emu->skipBios = true;
	emu->solarLevel = -1;
	emu->cartRumble = false;
	emu->gbPaletteSet = false;
	emu->sgbBorders = false;
	emu->tiltX = 0;
	emu->tiltY = 0;
	emu->gyroZ = 0;
	for (int gi = 0; gi < 6; ++gi) {
		emu->channelGains[gi] = 256;
	}
	return emu;
}

void mgbaMobileDestroy(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	if (emu->rewindInited) {
		mCoreRewindContextDeinit(&emu->rewind);
		emu->rewindInited = false;
	}
	/* 必须在 destroyCore 之前卸下锁步驱动：driver 内存由 slot 持有，core
	 * 销毁后 gba->sio.driver 会悬空。 */
	if (emu->lockstepSlot) {
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
	}
	if (emu->lockstepRoom) {
		mgbaLockstepRelease(emu->lockstepRoom);
		emu->lockstepRoom = NULL;
	}
	destroyCore(emu);
	deinitAudioOutput(emu);
	netLinkDestroy(emu->link);
	emu->link = NULL;
	if (emu->coreMutexReady) {
		emu->coreMutexReady = false;
		pthread_mutex_destroy(&emu->coreMutex);
	}
	free(emu);
}

void mgbaMobileLock(struct MgbaMobile* emu) {
	if (emu && emu->coreMutexReady) {
		pthread_mutex_lock(&emu->coreMutex);
	}
}

void mgbaMobileUnlock(struct MgbaMobile* emu) {
	if (emu && emu->coreMutexReady) {
		pthread_mutex_unlock(&emu->coreMutex);
	}
}

void mgbaMobileSetSaveDirs(struct MgbaMobile* emu, const char* saveDir, const char* stateDir) {
	if (!emu) {
		return;
	}
	if (saveDir && saveDir[0]) {
		copyPath(emu->savePath, sizeof(emu->savePath), saveDir);
	}
	if (stateDir && stateDir[0]) {
		copyPath(emu->statePath, sizeof(emu->statePath), stateDir);
	}
}

/*
 * Battery saves kept next to the ROM may carry any of the usual suffixes:
 * mGBA writes <base>.sav, other emulators <base>.srm, and per-player saves
 * use .sa1..sa4. Open an existing one rather than letting the core create
 * an empty .sav beside a real .srm. The VFile stays owned by the core so
 * later saves are written back to the same file.
 */
static bool autoloadExistingSave(struct MgbaMobile* emu, struct mCore* core) {
	char preferred[16] = ".sav";
	const char* suffixes[7];
	size_t count = 0;
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), ".sav");
	if (!core || !core->dirs.save || !core->dirs.baseName[0]) {
		return false;
	}
	/* Match mCoreAutoloadSave's per-player suffix first, so a player who
	 * configured savePlayerId keeps using the same file as before. */
	int savePlayerId = 0;
	mCoreConfigGetIntValue(&core->config, "savePlayerId", &savePlayerId);
	if (savePlayerId > 1) {
		snprintf(preferred, sizeof(preferred), ".sa%i", savePlayerId);
	}
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), "%s", preferred);
	suffixes[count++] = preferred;
	suffixes[count++] = ".sav";
	suffixes[count++] = ".srm";
	suffixes[count++] = ".sa1";
	suffixes[count++] = ".sa2";
	suffixes[count++] = ".sa3";
	suffixes[count++] = ".sa4";
	for (size_t i = 0; i < count; ++i) {
		struct VFile* vf = mDirectorySetOpenSuffix(&core->dirs, core->dirs.save, suffixes[i], O_RDWR);
		if (!vf) {
			continue;
		}
		core->loadSave(core, vf);
		snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), "%s", suffixes[i]);
		MOBILE_LOGI("Loaded battery save %s%s", core->dirs.baseName, suffixes[i]);
		return true;
	}
	return false;
}

bool mgbaMobileLoad(struct MgbaMobile* emu, const char* filename) {
	if (!emu || !filename) {
		return false;
	}
	destroyCore(emu);
	struct mCore* core = mCoreFind(filename);
	if (!core || !core->init(core)) {
		MOBILE_LOGE("Could not identify ROM: %s", filename);
		if (core) {
			free(core);
		}
		return false;
	}

	mCoreInitConfig(core, emu->port);
	mCoreConfigSetOverrideValue(&core->config, "savegamePath", emu->savePath);
	mCoreConfigSetOverrideValue(&core->config, "savestatePath", emu->statePath);
	mCoreConfigSetOverrideIntValue(&core->config, "volume", 0x100);
	mCoreConfigSetOverrideIntValue(&core->config, "frameskip", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "useBios", emu->useBios ? 1 : 0);
	mCoreConfigSetOverrideIntValue(&core->config, "skipBios", emu->skipBios ? 1 : 0);
	mCoreConfigSetOverrideIntValue(&core->config, "audioSync", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "videoSync", 0);
	mCoreConfigSetOverrideUIntValue(&core->config, "audioBuffers", 16384);
	if (emu->gbPaletteSet) {
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			mCoreConfigSetOverrideIntValue(&core->config, key, emu->gbPalette[i]);
		}
	}
	mCoreConfigSetOverrideIntValue(&core->config, "sgb.borders", emu->sgbBorders ? 1 : 0);
	emu->core = core;
	/* 加载窗口开始：emu->core 已挂上（失败路径靠 destroyCore 兜底），但
	 * isLoaded 必须仍返回 false——见 struct MgbaMobile.romLoaded 注释。 */
	__atomic_store_n(&emu->romLoaded, false, __ATOMIC_RELAXED);
	mCoreLoadConfig(core);

	if (!mCoreLoadFile(core, filename)) {
		MOBILE_LOGE("mCoreLoadFile failed: %s", filename);
		destroyCore(emu);
		return false;
	}
	/* ROM 地址自解析：记下真实加载路径（移动端唯一可靠来源），加载完立刻
	 * 从 ROM 字节重扫一遍；之前若有懒解析（无 ROM 时的默认兜底）在这里重来。 */
	snprintf(s_mobileRomPath, sizeof(s_mobileRomPath), "%s", filename);
	s_romScanEmu = emu;
	__atomic_store_n(&s_romAddrInit, 0, __ATOMIC_RELEASE);
	mobileResolveRomAddresses();

	/* 加载窗口结束：board/config 就绪，emu 循环从此可以跑帧（release 配
	 * emu->core 的写入次序，见 struct MgbaMobile.romLoaded 注释）。 */
	__atomic_store_n(&emu->romLoaded, true, __ATOMIC_RELEASE);
	// Per-channel gains are front-end state: re-apply them to the fresh core.
	if (emu->core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		gba->audio.psg.chGain[0] = (int16_t) emu->channelGains[0];
		gba->audio.psg.chGain[1] = (int16_t) emu->channelGains[1];
		gba->audio.psg.chGain[2] = (int16_t) emu->channelGains[2];
		gba->audio.psg.chGain[3] = (int16_t) emu->channelGains[3];
		gba->audio.chGainA = (int16_t) emu->channelGains[4];
		gba->audio.chGainB = (int16_t) emu->channelGains[5];
	} else if (emu->core->platform(core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) core->board;
		gb->audio.chGain[0] = (int16_t) emu->channelGains[0];
		gb->audio.chGain[1] = (int16_t) emu->channelGains[1];
		gb->audio.chGain[2] = (int16_t) emu->channelGains[2];
		gb->audio.chGain[3] = (int16_t) emu->channelGains[3];
	}
	if (emu->patches && !mCoreAutoloadPatch(core)) {
		// No patch next to the ROM is the normal case; a bad patch only warns.
		MOBILE_LOGI("No patch applied for %s", filename);
	}
	if (!autoloadExistingSave(emu, core)) {
		/* No save next to the ROM yet: let the core create its own .sav. */
		mCoreAutoloadSave(core);
	}
	core->setAudioBufferSize(core, 16384);
	if (!ensureVideo(emu)) {
		MOBILE_LOGE("No video buffer before reset for %s", filename);
		destroyCore(emu);
		return false;
	}
	core->reset(core);
	if (core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		int type = emu->saveType;
		if (type < GBA_SAVEDATA_FORCE_NONE || type > GBA_SAVEDATA_SRAM512) {
			type = GBA_SAVEDATA_AUTODETECT;
		}
		if (type != GBA_SAVEDATA_AUTODETECT) {
			GBASavedataForceType(&gba->memory.savedata, type);
			MOBILE_LOGI("GBA save type forced to %d", type);
		}
	}
	if (!ensureVideo(emu)) {
		MOBILE_LOGE("No video buffer for %s", filename);
		destroyCore(emu);
		return false;
	}

	attachKeyCallback(emu);
	attachCartHw(emu);
	// The tilt source is inert (all zeros) until the front end feeds it, so
	// attaching it for every console is harmless for games that never read it.
	emu->rotation.sample = tiltSample;
	emu->rotation.readTiltX = tiltReadX;
	emu->rotation.readTiltY = tiltReadY;
	emu->rotation.readGyroZ = tiltReadGyro;
	emu->core->setPeripheral(emu->core, mPERIPH_ROTATION, &emu->rotation);
	loadCheats(emu);
	pollLink(emu);
	// Rewind history never crosses a ROM boundary: drop the old ring and
	// build a fresh one for this game.
	if (emu->rewindInited) {
		mCoreRewindContextDeinit(&emu->rewind);
		emu->rewindInited = false;
	}
	emu->rewindCounter = 0;
	/* 加载新 ROM 不能让加载前的一个读数与加载后的读数凑成「连续两次」，
	 * 否则换游戏那一瞬间的卡顿会被当成持续变慢。保留已锁定的 pace
	 * 与吞吐记忆，只清掉未确认的反馈历史。 */
	emu->audioPaceHistLen = 0;
	emu->audioPaceOutliers = 0;
	MOBILE_LOGI("Loaded %s (%ux%u, %u Hz)", filename, emu->width, emu->height, core->audioSampleRate(core));
	return true;
}

bool mgbaMobileIsLoaded(const struct MgbaMobile* emu) {
	return emu && emu->core
		&& __atomic_load_n(&emu->romLoaded, __ATOMIC_ACQUIRE);
}

static uint32_t loadHeld(struct MgbaMobile* emu) {
	return __atomic_load_n(&emu->heldKeys, __ATOMIC_ACQUIRE);
}

static void noteKeys(struct MgbaMobile* emu, uint32_t keys) {
	uint32_t prev = __atomic_exchange_n(&emu->heldKeys, keys, __ATOMIC_ACQ_REL);
	uint32_t rising = keys & ~prev;
	if (rising) {
		__atomic_fetch_or(&emu->latchedKeys, rising, __ATOMIC_ACQ_REL);
		MOBILE_LOGI("Held 0x%x", keys);
	} else if (keys != prev) {
		MOBILE_LOGI("Held 0x%x", keys);
	}
}

static uint32_t applyTurbo(struct MgbaMobile* emu, uint32_t keys) {
	uint32_t turbo = __atomic_load_n(&emu->turboMask, __ATOMIC_ACQUIRE);
	if (!turbo) {
		return keys;
	}
	if ((emu->turboCounter++ & 1u) == 0u) {
		keys |= turbo;
	} else {
		keys &= ~turbo;
	}
	return keys;
}

/* == busgame 调试脚本：PC busgame-lockstep 判据脚本的设备端移植 ==
 * 与 test/gboylink_test.cpp 的 lsInjectKeys 逐行对应（常量、相位、内存判据
 * 全部一致）。差异只有载体：PC 走测试线程逐帧调用，这里可见核挂在
 * beginFrameKeys（帧精确）、镜像核由 GBoyConsoleSet 镜像线程逐帧调
 * mgbaMobileBusGameTick。队伍选择仍由内存写入完成（避开 Enter/NoEntry
 * 震荡），校验/关菜单/开战由游戏自己的代码执行。 */
void mgbaMobileBusGameStart(struct MgbaMobile* emu, int idx, int menuAt, int modeDowns) {
	if (!emu) {
		return;
	}
	emu->busGameIdx = idx;
	/* 负 menuAt = 「只跑导航」：用于已经手工走到 st=4/球场图的云端 2P，
	 * 补最后一环（ready2 走位、选怪内存注入、战斗菜单钳位），不再重放开场按键。
	 * 同时必须把 menuAt 归零：导航分支 `f >= menuAt + 240` 里 f 是 uint32_t，
	 * 负 int 会被提升成巨大的 unsigned，条件永远不成立。 */
	emu->busGameNavOnly = (menuAt < 0);
	emu->busGameMenuAt = emu->busGameNavOnly ? 0 : menuAt;
	emu->busGameModeDowns = modeDowns;
	emu->busGameFrame = 0;
	emu->busGameMenuMax = 0;
	emu->busGameBattleHits = 0;
	MOBILE_LOGI("BUSGAME start idx=%d menuAt=%d modeDowns=%d navOnly=%d",
	            idx, menuAt, modeDowns, emu->busGameNavOnly);
}

void mgbaMobileBusGameStop(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	emu->busGameIdx = -1;
	MOBILE_LOGI("BUSGAME stop");
}

void mgbaMobileBusGameNavInit(struct BusGameNavState* st, int idx, int menuAt, int modeDowns) {
	if (!st) {
		return;
	}
	memset(st, 0, sizeof(*st));
	st->idx = idx;
	/* 负 menuAt = 「只跑导航」：用于已经手工走到 st=4/球场图的云端 2P，
	 * 补最后一环（ready2 走位、选怪内存注入、战斗菜单钳位），不再重放开场按键。
	 * 同时必须把 menuAt 归零：导航分支 `f >= menuAt + 240` 里 f 是 uint32_t，
	 * 负 int 会被提升成巨大的 unsigned，条件永远不成立。 */
	st->navOnly = (menuAt < 0);
	st->menuAt = st->navOnly ? 0 : menuAt;
	st->modeDowns = modeDowns;
}

/* GBoy 战斗区窗口（ROM 代码段）。**这是随 ROM 重新链接而平移的量**：
 * 旧 ROM（rom.md5 f7886655…）的 battle_main.o .text 是
 * [0x080B24B8,0x080BBE4C)、BattleMainCB2 @0x080B3C3C（cb2=入口+1）。
 * 当前 D:/gen8/rom.map（md5 3EF5564C…，2026-11-17 18:55）实测为
 *   .text = [0x080B30C0, 0x080BCA78)   (段首 0x080B30C0 + 0x99B8)
 *   BattleMainCB2 @0x080B4844           (cb2 = 0x080B4845)
 * 即段首整体 +0xC08。工作区 14:36 那份 rom.map 的 .text 段首/大小与 gen8
 * 完全相同（两份只在 .rodata 上差 +0x80），所以这组默认值对两份都成立。
 * 【务必按你的 ROM 复核】换 ROM = 重新链接，绝对地址会再次漂移，写死必假阴性：
 *   1) 优先用 MGBAX_GBOY_BATTLE_LO / _HI 覆盖窗口（见下），不必重编；
 *   2) mgbaMobileBusGameInBattle 另有 gMain.inBattle 数据标志作权威判据，
 *      本 cb2 窗口只作兜底（代码段平移时数据位仍在）。
 * 依据：production/sprint-2p/ADDRESS-AUDIT.md §3.2 #38、§5.2。 */
static void gboyBattleWindow(uint32_t* lo, uint32_t* hi) {
	/* 段首/段长由 ROM 字节里 battle_main.o 的 12 字节序言 + 固定几何推出；
	 * 环境变量仍可显式覆盖（换 ROM 不想重扫时）。 */
	*lo = MOBILE_BATTLE_LO();
	*hi = MOBILE_BATTLE_HI();
	const char* v = getenv("MGBAX_GBOY_BATTLE_LO");
	if (v && v[0]) {
		*lo = (uint32_t) strtoul(v, NULL, 16);   /* 驱动传不带 0x 的 hex */
	}
	v = getenv("MGBAX_GBOY_BATTLE_HI");
	if (v && v[0]) {
		*hi = (uint32_t) strtoul(v, NULL, 16);
	}
}

/* gMain.inBattle：gMain @0x02029114（rom.map 里的 EWRAM_DATA gMain），
 * struct Main 的 inBattle 位在 +0x439 的 bit1 ⇒ 0x0202954D。
 * 进战斗时 battle_main.c:657 置 TRUE，战斗结束清 0 —— 这是**数据**标志，
 * 比 cb2 的**代码**窗口稳（代码段随 ROM 重新链接整体平移，见上）。 */
static bool gboyInBattleFlag(struct GBA* g) {
	return (GBAView8(g->cpu, NAV_EW(0x0202954Du)) & 0x02u) != 0;
}

bool mgbaMobileBusGameInBattle(struct GBA* g) {
	if (!g || !g->cpu) {
		return false;
	}
	uint32_t cb2 = GBAView32(g->cpu, NAV_CB2_PTR);
	uint32_t lo = 0, hi = 0;
	gboyBattleWindow(&lo, &hi);
	/* 两条判据取或：inBattle 是权威数据标志（不随代码段平移），cb2 窗口兜底。
	 * 进战斗后 cb2 会在战斗初始化回调与 BattleMainCB2 之间跳；当前 map 的
	 * BattleMainCB2 cb2 = 0x080B4845，旧 ROM 那串 080B2505/080B3415/
	 * 080B36ED/080B3C3D 已过期，勿当真——其余落点请按你的 ROM map 复核。 */
	return gboyInBattleFlag(g) || (cb2 >= lo && cb2 <= hi);
}

uint32_t mgbaMobileBusGamePeek32(struct GBA* g, uint32_t addr) {
	return (g && g->cpu) ? GBAView32(g->cpu, addr) : 0u;
}

uint8_t mgbaMobileBusGamePeek8(struct GBA* g, uint32_t addr) {
	return (g && g->cpu) ? GBAView8(g->cpu, addr) : 0u;
}

/* == 两端共用的 busgame 导航核心 ==
 * Android 的 MgbaMobile 四核走下面的 busGameKeys() 薄包装；PC Qt 的
 * CoreController 可见核从 ScriptedControl::poll() 直接调用本函数，传自己的
 * board。地址、相位、内存判据只有这一份，杜绝两端逻辑漂移。 */
/* 标题/开场阶段的 callback2 区间。读档进 overworld 后是 0x08188981
 * (CB2_Overworld)，联机/菜单是 0x08188BAD (CB2_ReturnToFieldCableClub)、
 * 0x081D63E9 (ChooseHalfPartyForBattle)，战斗是 battle_main.o 里的
 * 0x080Bxxxx，都不在下面这些区间里。
 *
 * 2026-11-16 修正：这些区间是**随 ROM 重新链接而平移**的量，旧值对当前
 * rom.gba（rom.md5 f7886655…）一个都不匹配：
 *   - 标题画面 CB2_InitTitleScreen @0x081F83F0（cb2=0x081F83F1，
 *     屏内还会跳 0x081F86F5 / 0x081F8A65）⇒ 旧区间 [0x081E0000,0x081E1FFF]
 *     根本不是标题画面，是 ShowStartMenu（暂停菜单）的代码；
 *   - 版权画面 CB2_InitCopyrightScreenAfterBootup @0x0815DBA4
 *     （cb2=0x0815DBA5）、CB2_InitCopyrightScreenAfterTitleScreen @0x0815DC04
 *     ⇒ 旧区间里没有任何一项覆盖它。
 * 结果：标题画面的 START 永远按不出来 ⇒ 导航从开机就卡在标题画面，
 * 后面所有内存驱动的分支都够不着。 */
static bool busGameTitleCb(uint32_t cb2) {
	/* 窗口由 ROM 签名定位：intro.o .text 段首（版权 cb2，含 AfterBootup/
	 * AfterTitleScreen）与 title_screen.o .text 段首（CB2_InitTitleScreen）。
	 * title_screen.o 的段尾恰好就是 trade.o 段首，天然排除交换中心菜单。 */
	if (cb2 >= MOBILE_COPYRIGHT_LO() && cb2 <= MOBILE_COPYRIGHT_HI()) {
		return true;
	}
	/* 段长 0xA18 的终点就是 trade.o 段首（交换中心菜单），用开区间排除。 */
	if (cb2 >= MOBILE_TITLE_LO() && cb2 < MOBILE_TITLE_HI()) {
		return true;
	}
	return false;
}

/* 柜台/握手段是否用「msgbox 状态驱动 A」替代「按帧号盲脉冲」。
 * 默认关（未设 = 旧行为，零回归）；mgbax.nav.msgbox=1 / MGBAX_NAV_MSGBOX=1 才启用。
 * 缓存方式与 mobileFastFrame() 的 sioFastEnabled 一致（-1 = 还没读）。 */
static int navMsgboxEnabled(void) {
	static int s_enabled = -1;
	if (s_enabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.nav.msgbox", v);
		s_enabled = (v[0] == '1') ? 1 : 0;
#else
		const char* v = getenv("MGBAX_NAV_MSGBOX");
		s_enabled = (v && atoi(v) != 0) ? 1 : 0;
#endif
	}
	return s_enabled;
}

uint32_t mgbaMobileBusGameNavKeys(struct BusGameNavState* st, struct GBA* g) {
	if (!st || !g || !g->cpu) {
		return 0;
	}
	const int idx = st->idx;
	const int menuAt = st->menuAt;
	const uint32_t f = st->frame++;
	/* 不要把「st>=4 后停手」加回来：st=4 在联机中心握手就会出现，远早于
	 * 菜单导航，一停手后面的导航按键全被跳过。 */
	const uint32_t A = 1, START = 8, RIGHT = 16, LEFT = 32, UP = 64, DOWN = 128;
	uint32_t keys = 0;
	int mbx = -1;   /* sFieldMessageBoxMode(NAV_EW(0x02021A00u))，仅调试日志用 */
	const uint32_t cb2 = GBAView32(g->cpu, NAV_CB2_PTR);
	/* 开场阶段由游戏状态驱动，不再按帧号。四核进 SIO 前不锁步，游戏帧号
	 * 各不相同：实测脚本 f=0 时 idx=1 已在标题菜单(081E04F1)、其余还在
	 * 开场(08145A43)。固定帧 START@240 / A 脉冲必然有核落空，那个核永远
	 * 不读档、不写 SIOCNT，另外三核的握手就死在 st=2 / pc=0。
	 * 单端实测：START 把演示画面切到标题菜单，A 选「继续」读档；两者交替
	 * 让每个核按自己的相位自主完成读档，之后四核自然收敛。 */
	if (busGameTitleCb(cb2)) {
		/* cb2 区间只是必要条件：0x08145xxx 是 overworld 主回调（读档后
		 * 站在俱乐部柜台前实测就是 08145A43），0x081E0xxx 与 start_menu.o
		 * 的 .text 重叠（SaveGame/CB2_SetUpSaveAfterLinkBattle）。只看区间
		 * 会把「已经读档的野外」当成标题屏，每 60 帧按一次 START，把暂停
		 * 菜单按开、cb2 停在 081DF739，此后 ready4/ready2 永不成立、脚本
		 * 再也不发键（实测 6000 帧 pc=0 / st=0 / pos 恒 10,4）。
		 * 加一道存档判据：save block 指针有效 = 已经进了游戏世界，不再按
		 * 开场键。 */
		uint32_t sb1 = GBAView32(g->cpu, NAV_IW(0x03004964u));
		bool saveLoaded = sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE;
		if (!saveLoaded) {
			const uint32_t ph = f % 60u;
			keys = (ph < 6u) ? START : ((ph >= 12u && ph < 32u) ? A : 0u);
			goto busgame_tail;
		}
	}
	/* 原本按帧号的 START/A/DOWN/UP/LEFT/modeDowns 盲按整体废弃：任何固定
	 * 帧序列都会把相位不同的四核按到不同子状态。读档后一律走下面的内存
	 * 驱动导航（菜单钳位、握手脉冲 A、走位、选怪注入）。 */
	{
		/* 只有 4 核都确认了「多人模式」(var8004=5, gLinkType=MOBILE_LINKTYPE_MULTI) 之后才
		 * 开始走位。菜单/握手阶段继续按 A。 */
		int v8 = (int) GBAView16(g->cpu, NAV_EW(0x0202199Cu));
		int lt = (int) GBAView16(g->cpu, NAV_EW(0x02027BB2u));
		int fpc = (int) GBAView8(g->cpu, NAV_IW(0x03004A39u));
		int lst = (int) GBAView8(g->cpu, NAV_IW(0x03002AF5u));   /* gLink.state */
		int lpc = (int) GBAView8(g->cpu, NAV_IW(0x03002AF7u));   /* gLink.playerCount */
		/* 4 人多人对战：var8004=5 且 gLinkType=MOBILE_LINKTYPE_MULTI/MOBILE_LINKTYPE_BATTLE。
		 * 2 人单打（云端 2P 的目标）：实测 gLinkType=0x046D、var8004=3，
		 * 用那套常量永远进不了走位分支，所以 2 人改成「房间握手完成
		 * （gLink.state>=4）且 playerCount==2」就放行。
		 *
		 * 2026-11-16 修正：2P 的判据以前读的是 gFieldLinkPlayerCount
		 * （0x03004A39），那是**连锁完成之后**才写的变量 ——
		 * cable_club.c:373 / :421 在 Task_LinkupExchangeDataWithLeader /
		 * Task_LinkupCheckStatusAfterConfirm 里才写它。用它当「已进入联机」
		 * 的门 ⇒ 门在握手刚完成时恒假（fpc 还是 0），2P 分支永远进不去，
		 * 导航一直停在「野外脉冲 A」，选怪注入那一步永远不执行。
		 * 真正从握手那一刻起就有效的计数是 gLink.playerCount
		 * （link.c:2288 在收到 MASTER_HANDSHAKE 时写），判据改成
		 * 「gLink.state>=4（CONN_ESTABLISHED）且 gLink.playerCount>=2」，
		 * 与 ADR-003 的快帧门用同一套 state/playerCount 口径。 */
		bool multi4 = (v8 == 5 && (lt == MOBILE_LINKTYPE_MULTI || lt == MOBILE_LINKTYPE_BATTLE));
		/* 【path B 关键修复】ready4 原来读 gFieldLinkPlayerCount(fpc>=4)，
		 * 但那个变量是 cable_club.c:373/421 在连锁**完成之后**才写的 ——
		 * 握手阶段恒 0 ⇒ ready4 恒 false ⇒ 四核永远停在下面的「野外脉冲 A」
		 * 分支，走位/选怪/进房代码一段都执行不到（PB30：slot 2/3 的 NPC
		 * 镜像 l=1 cb=0 res=255，推 0000，主机 DoHandshake 见到非法字把
		 * playerCount 清零 ⇒ pc=0、m1=FFFF）。注释 1676-1685 只对 2P 分支
		 * 做了同源修正，4P 分支漏改。改用与 ready2 同源的 gLink.state/playerCount
		 * （握手那一刻就有效，link.c:2288），并用 EWRAM 的 gSpecialVar_Result
		 * （0x020219AC，永不平移）兜底。fpc 只留作日志。 */
		int linkResult = (int) GBAView16(g->cpu, NAV_EW(0x020219ACu));
		bool ready4 = (multi4 && ((lst >= 4 && lpc >= 4) || linkResult == 1));
		bool ready2 = (!multi4 && lst >= 4 && lpc == 2);
		if (!ready4 && !ready2) {
			/* 读档后站在俱乐部柜台前（实测 pos=10,4）时，游戏等的是
			 * 「和柜台小姐对话 → 交换中心 → 大竞技场 → 多人对战」。
			 * 旧实现这里直接 keys=0，等 ready4/ready2 成立才发键 ——
			 * 那是先有鸡后有蛋：不按 A 永远进不了联机，脚本 6000 帧
			 * 一个键都没发（pc 恒 0）。改成在野外脉冲 A 触发对话，
			 * 后续菜单/走位/选怪由下面的内存导航接手；按键是 25 帧按下 /
			 * 15 帧松开的脉冲（6 帧短脉冲实测对话框推不动，仍停在原地）。
			 *
			 * 开关打开后改成状态驱动：按帧号盲脉冲的相位与各核自己的
			 * msgbox 生命周期无关，A 常常恰好落在「文字已经自动滚完、
			 * 游戏正在等 B 键/等边沿」的空窗里，两端很难同时稳定在
			 * gLink.state=4。改为读 sFieldMessageBoxMode（NAV_EW(0x02021A00u)）：
			 *   - msgbox != 0（文字还在滚）：松开 A，攒出干净的松开期；
			 *   - msgbox == 0（HIDDEN）：按住 A。
			 * 动机（gen8 cable_club.c 的两个 Task 条件不一样，必须同时喂饱）：
			 *   - Task_LinkupTryConfirmation(:293) 要
			 *     GetFieldMessageBoxMode()==HIDDEN **且** JOY_HELD(A)；
			 *     msgbox 自动隐藏的那一刻 A 已经在按 ⇒ 同帧命中。
			 *   - Task_LinkupAwaitConfirmation(:268) 要 JOY_NEW(A)（边沿），
			 *     所以 HIDDEN 期间不能真的「永远按住」：gen8 ReadKeys2()
			 *     里 newKeys = keyInput & ~heldKeysRaw，一直按住会让
			 *     newKeys 恒 0，任务在那一行永久挂住（实测表现为
			 *     lstate 只在 4 附近瞬态跳、然后掉回 1/2）。
			 *     ⇒ HIDDEN 期间每 24 帧松 2 帧，用 22/24 ≈ 92% 的占空比
			 *     同时满足「held 大概率成立」和「定期刷新边沿」。 */
			mbx = (int) GBAView8(g->cpu, NAV_EW(0x02021A00u));
			if (navMsgboxEnabled()) {
				if (mbx == 0) {
					keys = ((f % 24u) < 22u) ? A : 0u;
				} else {
					keys = 0u;
				}
			} else {
				keys = ((f % 40) < 25) ? A : 0u;
			}
		} else {
			int mb = (int) GBAView8(g->cpu, NAV_EW(0x02021A00u));
			if (mb != 0) {
				keys = ((f % 20) < 8) ? A : 0u;   /* 脉冲产生 JOY_NEW */
			} else {
				int ptype = (int) GBAView8(g->cpu, NAV_EW(0x02032AC0u)) & 0x0Fu;
				int s0 = (int) GBAView8(g->cpu, NAV_EW(0x02032B00u));
				int s1 = (int) GBAView8(g->cpu, NAV_EW(0x02032B01u));
				if (ptype == 4) {
					/* 选怪状态机：内存写完成「选 2 只」
					 * （gSelectedOrderFromParty={1,2}、slotId=6=确认位），
					 * 校验/关菜单/开战仍由游戏自己执行。 */
					int slot = (int8_t) GBAView8(g->cpu, NAV_EW(0x02032AC1u));
					if (s0 == 0 || s1 == 0 || slot != 6) {
						int cc = 0;
						if (s0 == 0) { GBAStore8(g->cpu, NAV_EW(0x02032B00u), (int8_t) 1, &cc); }
						if (s1 == 0) { GBAStore8(g->cpu, NAV_EW(0x02032B01u), (int8_t) 2, &cc); }
						if (slot != 6) { GBAStore8(g->cpu, NAV_EW(0x02032AC1u), (int8_t) 6, &cc); }
					}
					keys = ((f % 12) < 2) ? A : 0u;
				} else if (ready2 && !ready4) {
					/* 2P 单打：进了球场图之后角色被游戏锁住，不能走位
					 * （实测 BUSGAME f=1800→4800 两核 pos 恒为 5,6 / 6,6）。
					 * 此时游戏等的是 sMenu 的双项确认（cur=0/1、pt=0），
					 * 4P 那套「走到座位再按 A」永远到不了座位，于是永远
					 * 不发 A，画面就冻在球场图上。2P 直接脉冲 A 推进，
					 * 等 ptype==4 弹出队伍菜单后再由上面的分支注入选怪。 */
					keys = ((f % 40) < 25) ? A : 0u;
				} else {
					/* 队伍菜单未弹出：闭环走位到 4P 座位。 */
					static const int seatX[4] = {3, 10, 3, 10};
					static const int seatY[4] = {4, 4, 6, 6};
					uint32_t sb1 = GBAView32(g->cpu, NAV_IW(0x03004964u));
					int px = -1, py = -1;
					if (sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE) {
						px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
						py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
					}
					if (px < 0) {
						keys = ((f % 40) < 25) ? A : 0u;
					} else if (py > seatY[idx]) {
						keys = UP;
					} else if (py < seatY[idx]) {
						keys = DOWN;
					} else if (px > seatX[idx]) {
						keys = LEFT;
					} else if (px < seatX[idx]) {
						keys = RIGHT;
					} else {
						keys = ((f % 40) < 25) ? A : 0u;
					}
				}
			}
		}
	}
busgame_tail:
	;
	{
		static int _dbgF = 0;
		int _pt = (int) GBAView8(g->cpu, NAV_EW(0x02032AC0u)) & 0x0F;
		int _mb = (int) GBAView8(g->cpu, NAV_EW(0x02021A00u));
		/* 开关打开时把柜台/握手段也打出来：mbx 与 keys 同帧对照，
		 * 才能判断「HIDDEN 才按 A」是否真的对齐了 gen8 的 Task 条件。 */
		if (idx == 0 && (_pt == 4 || _mb != 0 || (mbx >= 0 && navMsgboxEnabled()))
		    && (_dbgF++ % 10) == 0) {
			int _s0 = (int) GBAView8(g->cpu, NAV_EW(0x02032B00u));
			int _s1 = (int) GBAView8(g->cpu, NAV_EW(0x02032B01u));
			int _slot = (int8_t) GBAView8(g->cpu, NAV_EW(0x02032AC1u));
			int _lt = (int) GBAView16(g->cpu, NAV_EW(0x02027BB2u));
			int _v8 = (int) GBAView16(g->cpu, NAV_EW(0x0202199Cu));
			int _fpc = (int) GBAView8(g->cpu, NAV_IW(0x03004A39u));
			int _lst = (int) GBAView8(g->cpu, NAV_IW(0x03002AF5u));
			int _lpc = (int) GBAView8(g->cpu, NAV_IW(0x03002AF7u));
			fprintf(stderr, "NAV f=%u pt=%d s0=%d s1=%d slot=%d mb=%d mbx=%d lst=%d lpc=%d lt=%04X v8=%d fpc=%d cb2=%08X keys=%02X\n",
			        f, _pt, _s0, _s1, _slot, _mb, mbx, _lst, _lpc, _lt, _v8, _fpc, (unsigned) cb2, keys);
		}
	}
	/* 内存驱动的确定性导航：战斗模式菜单（maxCursorPos==4）把光标钳到 2
	 * （多人/4P）。联机服务菜单 4 项不能钳。 */
	if (f >= menuAt) {
		int mx = (int) GBAView8(g->cpu, NAV_EW(0x020296F4u));
		if (mx > st->menuMax) {
			st->menuMax = mx;
		}
		if (mx == 4) {
			int cur = (int) GBAView8(g->cpu, NAV_EW(0x020296F2u));
			if (cur != 2) {
				int cc = 0;
				GBAStore8(g->cpu, NAV_EW(0x020296F2u), (int8_t) 2, &cc);
			}
		}
	}
	/* 仅 0 号核（主机）补 SD/Ready(bit3)：gen8 用 (SIOCNT & 0xC)==0x8 判主机。 */
	if (idx == 0) {
		g->sio.siocnt |= 0x0008u;
	}
	/* 进战斗区后把按键控制权交还网络/真人。用连续 120 帧（约 2 秒）命中
	 * 才释放，避免队伍菜单/战斗初始化时 cb2 短暂落在同一区间导致提前放手。 */
	if (mgbaMobileBusGameInBattle(g)) {
		if (st->battleHits < 120) {
			++st->battleHits;
		}
		if (st->battleHits >= 120) {
			st->released = true;
		}
	} else {
		st->battleHits = 0;
	}
	return keys;
}

static uint32_t busGameKeys(struct MgbaMobile* emu) {
	struct mCore* core = emu->core;
	struct GBA* g = (struct GBA*) core->board;
	struct BusGameNavState st = {
		emu->busGameIdx, emu->busGameMenuAt, emu->busGameModeDowns,
		emu->busGameMenuMax, emu->busGameFrame, emu->busGameBattleHits,
		emu->busGameNavOnly != 0, false
	};
	uint32_t keys = mgbaMobileBusGameNavKeys(&st, g);
	const uint32_t f = st.frame - 1;
	emu->busGameFrame = st.frame;
	emu->busGameMenuMax = st.menuMax;
	emu->busGameBattleHits = st.battleHits;
	if (st.released && emu->busGameIdx >= 0) {
		/* 自动释放：导航到对战区后停掉脚本，GBoyConsoleSet 的镜像帧循环
		 * 会因为 !busGame 自动改从 GBoyLinkSession.keysForSlot() 取按键，
		 * 可见核则由正常输入/网络按键接管。不需要外部广播关脚本。 */
		emu->busGameIdx = -1;
		MOBILE_LOGI("BUSGAME battle reached, keys released to network");
	}
	if ((f % 600) == 0) {
		/* 进对战判据：callback2 @0x02029118 落 battle_main.o。
		 * 0x03002AD4 是 gLinkCallback，不是 callback2，别读错。 */
		uint32_t cb2 = GBAView32(g->cpu, NAV_CB2_PTR);
		uint32_t sb1 = GBAView32(g->cpu, NAV_IW(0x03004964u));
		int px = -1, py = -1;
		if (sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE) {
			px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
			py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
		}
		MOBILE_LOGI("BUSGAME f=%u idx=%d pc=%d st=%d var8004=%d lt=%04X pos=%d,%d mm=%d cb2=%08X%s",
		            f, st.idx,
		            (int) GBAView8(g->cpu, NAV_IW(0x03004A39u)),
		            (int) GBAView8(g->cpu, NAV_EW(0x02021A00u)),
		            (int) GBAView16(g->cpu, NAV_EW(0x0202199Cu)),
		            (unsigned) GBAView16(g->cpu, NAV_EW(0x02027BB2u)),
		            px, py, st.menuMax, cb2,
		            mgbaMobileBusGameInBattle(g) ? " BATTLE=YES" : "");
	}
	return keys;
}

/* 镜像核路径：GBoyConsoleSet 镜像线程每帧调一次，拿掩码喂 setKeys/runFrames。 */
uint32_t mgbaMobileBusGameTick(struct MgbaMobile* emu) {
	if (!emu || emu->busGameIdx < 0) {
		return 0;
	}
	return busGameKeys(emu);
}

/* 【镜像核现场 2026-11-17】可见核的 [diag] 只能回答「本机玩家走到哪」，
 * path B 的联机握手却发生在可见核 + 3 个镜像核之间：任一镜像没进俱乐部，
 * gLinkStatus 就恒 0（PB12 现场：可见核 state=2 pc=0 st=0，cb 停在
 * LinkCB_RequestPlayerDataExchange，无法判断是哪个核掉队）。本函数由镜像
 * 线程按帧号节流调用，只读、不改状态。 */
void mgbaMobileMirrorDiag(struct MgbaMobile* emu, int idx, int slot) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	uint32_t cb2 = GBAView32(g->cpu, NAV_CB2_PTR);
	int lstate = (int) GBAView8(g->cpu, NAV_IW(0x03002AF5u));
	int pc = (int) GBAView8(g->cpu, NAV_IW(0x03002AF7u));
	int isMaster = (int) GBAView8(g->cpu, NAV_IW(0x03002AF4u));
	uint32_t st = (uint32_t) GBAView16(g->cpu, NAV_IW(0x03002A9Cu))
	              | ((uint32_t) GBAView16(g->cpu, NAV_IW(0x03002A9Eu)) << 16);
	int res = (int) GBAView16(g->cpu, NAV_EW(0x020219ACu));
	uint32_t cb = (uint32_t) GBAView16(g->cpu, NAV_IW(0x03002AD4u))
	              | ((uint32_t) GBAView16(g->cpu, NAV_IW(0x03002AD6u)) << 16);
	uint32_t sb1 = GBAView32(g->cpu, NAV_IW(0x03004964u));
	int px = -1, py = -1;
	if (sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE) {
		px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
		py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
	}
	MOBILE_LOGI("[mirror] idx=%d slot=%d f=%u cb2=%08X l=%d pc=%d mst=%d st=%08X res=%d cb=%08X pos=%d,%d",
	            idx, slot, emu->busGameFrame, cb2, lstate, pc, isMaster, st, res, cb, px, py);
}

static uint32_t beginFrameKeys(struct MgbaMobile* emu) {
	if (emu->busGameIdx >= 0) {
		/* 脚本接管：按键完全由判据脚本决定（与 PC busgame 一致）。 */
		emu->frameKeys = busGameKeys(emu);
		return emu->frameKeys;
	}
	uint32_t held = loadHeld(emu);
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL);
	emu->frameKeys = applyTurbo(emu, held | latch);
	return emu->frameKeys;
}

static uint16_t readLiveKeys(struct mKeyCallback* callback) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) callback - offsetof(struct MgbaMobile, keyCallback));
	/* The turbo key is driven exclusively by applyTurbo() through turboMask.
	 * If the same key bit leaks in here via held/latched (e.g. a dedicated
	 * 连发 button that also pulses this key, or a held key that raced with
	 * the auto-turbo arming), it would re-set the key on the turbo's OFF
	 * frame and pin it on forever. In a game that runs while B is held that
	 * presents as "running stuck" (跑步卡死). Mask the turbo bit out of
	 * held/latch so only the per-frame turbo decision stands. */
	uint32_t turbo = __atomic_load_n(&emu->turboMask, __ATOMIC_ACQUIRE);
	uint32_t held = loadHeld(emu) & ~turbo;
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL) & ~turbo;
	uint32_t keys = emu->frameKeys | held | latch;
	emu->frameKeys = keys;
	if (latch) {
		MOBILE_LOGI("Latched 0x%x", latch);
	}
	return (uint16_t) keys;
}

static void attachKeyCallback(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	emu->keyCallback.readKeys = readLiveKeys;
	emu->keyCallback.requireOpposingDirections = false;
	struct GBA* gba = (struct GBA*) emu->core->board;
	gba->keyCallback = &emu->keyCallback;
}

// == Cartridge hardware (solar sensor, RTC, rumble) ==

static uint8_t solarReadLuminance(struct GBALuminanceSource* lux) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) lux - offsetof(struct MgbaMobile, luminance));
	int level = emu->solarLevel;
	if (level < 0) {
		level = 0;
	}
	if (level > 9) {
		level = 9;
	}
	return (uint8_t) GBA_LUX_LEVELS[level];
}

static time_t rtcUnixTime(struct mRTCSource* rtc) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rtc - offsetof(struct MgbaMobile, rtc));
	switch (emu->rtcMode) {
	case MOBILE_RTC_FIXED:
		return (time_t) emu->rtcEpoch;
	case MOBILE_RTC_OFFSET:
		return time(0) + (time_t) emu->rtcOffset;
	default:
		return time(0);
	}
}

static void rumbleSet(struct mRumble* rumble, bool enable, uint32_t sinceLast) {
	UNUSED(sinceLast);
	if (!rumble || !enable) {
		return;
	}
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rumble - offsetof(struct MgbaMobile, rumble));
	__atomic_fetch_add(&emu->rumbleHits, 1, __ATOMIC_RELEASE);
}

/* Wires the front end's sensor sources into a loaded GBA board. GBA only. */
static void attachCartHw(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	emu->luminance.readLuminance = solarReadLuminance;
	if (emu->solarLevel >= 0) {
		gba->memory.hw.devices |= HW_LIGHT_SENSOR;
		gba->luminanceSource = &emu->luminance;
	}
	emu->rtc.unixTime = rtcUnixTime;
	gba->rtcSource = &emu->rtc;
	emu->rumble.setRumble = rumbleSet;
	if (emu->cartRumble) {
		gba->memory.hw.devices |= HW_RUMBLE;
		gba->rumble = &emu->rumble;
	}
}

void mgbaMobileSetSaveType(struct MgbaMobile* emu, int type) {
	if (!emu) {
		return;
	}
	emu->saveType = type;
	// Also re-force on the running core so a change takes effect on reset.
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA && type != GBA_SAVEDATA_AUTODETECT
	    && type >= GBA_SAVEDATA_FORCE_NONE && type <= GBA_SAVEDATA_SRAM512) {
		GBASavedataForceType(&((struct GBA*) emu->core->board)->memory.savedata, type);
	}
}

/* TEMP PROBE: expose the running core so the desktop harness can inspect the
 * GBA board state while a frame has frozen. */
struct mCore* mgbaMobileDebugCore(struct MgbaMobile* emu) {
	return emu ? emu->core : NULL;
}

void mgbaMobileSetPatches(struct MgbaMobile* emu, bool enabled) {
	if (emu) {
		emu->patches = enabled;
	}
}

void mgbaMobileSetBiosOptions(struct MgbaMobile* emu, bool useBios, bool skipIntro) {
	if (!emu) {
		return;
	}
	emu->useBios = useBios;
	emu->skipBios = skipIntro;
}

void mgbaMobileSetRtc(struct MgbaMobile* emu, int mode, int64_t epoch, int64_t offset) {
	if (!emu) {
		return;
	}
	if (mode < MOBILE_RTC_WALL || mode > MOBILE_RTC_OFFSET) {
		mode = MOBILE_RTC_WALL;
	}
	emu->rtcMode = mode;
	emu->rtcEpoch = epoch;
	emu->rtcOffset = offset;
}

void mgbaMobileSetSolar(struct MgbaMobile* emu, int level) {
	if (!emu) {
		return;
	}
	// -1 disables the sensor (checked at the next load); 0-10 is a lux level.
	if (level > 10) {
		level = 10;
	}
	emu->solarLevel = level;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (level >= 0) {
			gba->memory.hw.devices |= HW_LIGHT_SENSOR;
			gba->luminanceSource = &emu->luminance;
		}
	}
}

int mgbaMobileTakeRumbles(struct MgbaMobile* emu) {
	if (!emu) {
		return 0;
	}
	return __atomic_exchange_n(&emu->rumbleHits, 0, __ATOMIC_ACQ_REL);
}

void mgbaMobileSetCartRumble(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->cartRumble = enabled;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (enabled) {
			gba->memory.hw.devices |= HW_RUMBLE;
			gba->rumble = &emu->rumble;
		}
	}
}

// == GB palette, SGB border and tilt cartridge ==

void mgbaMobileSetGbPalette(struct MgbaMobile* emu, const int32_t* colors) {
	if (!emu || !colors) {
		return;
	}
	memcpy(emu->gbPalette, colors, sizeof(emu->gbPalette));
	emu->gbPaletteSet = true;
	// Live on a running GB core; the same overrides are replayed on every load.
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GB) {
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			mCoreConfigSetOverrideIntValue(&emu->core->config, key, emu->gbPalette[i]);
		}
		emu->core->reloadConfigOption(emu->core, "gb.pal", NULL);
	}
}

void mgbaMobileSetSgbBorders(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->sgbBorders = enabled;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GB) {
		mCoreConfigSetOverrideIntValue(&emu->core->config, "sgb.borders", enabled ? 1 : 0);
		emu->core->reloadConfigOption(emu->core, "sgb.borders", NULL);
	}
}

/*
 * Per-channel gains for the mobile mixer: gains[0..3] are PSG channels 1-4,
 * gains[4..5] the GBA DMA A/B FIFOs. 0-256 fixed point, 256 = full volume.
 * Applied live on the running core and replayed on every load.
 */
void mgbaMobileSetChannelVolumes(struct MgbaMobile* emu, const int32_t* gains) {
	if (!emu || !gains) {
		return;
	}
	int i;
	for (i = 0; i < 6; ++i) {
		emu->channelGains[i] = gains[i];
	}
	if (emu->core && emu->core->board) {
		if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
			struct GBA* gba = (struct GBA*) emu->core->board;
			gba->audio.psg.chGain[0] = (int16_t) gains[0];
			gba->audio.psg.chGain[1] = (int16_t) gains[1];
			gba->audio.psg.chGain[2] = (int16_t) gains[2];
			gba->audio.psg.chGain[3] = (int16_t) gains[3];
			gba->audio.chGainA = (int16_t) gains[4];
			gba->audio.chGainB = (int16_t) gains[5];
		} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
			struct GB* gb = (struct GB*) emu->core->board;
			gb->audio.chGain[0] = (int16_t) gains[0];
			gb->audio.chGain[1] = (int16_t) gains[1];
			gb->audio.chGain[2] = (int16_t) gains[2];
			gb->audio.chGain[3] = (int16_t) gains[3];
		}
	}
}

static void tiltSample(struct mRotationSource* rotation) {
	UNUSED(rotation);
}

static int32_t tiltReadX(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->tiltX, __ATOMIC_RELAXED);
}

static int32_t tiltReadY(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->tiltY, __ATOMIC_RELAXED);
}

static int32_t tiltReadGyro(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->gyroZ, __ATOMIC_RELAXED);
}

/*
 * Tilt cartridge input. tiltX/tiltY are normalized to -1..1; the core shifts
 * them (>> 22 for GBA, >> 21 for GB), so the full range spans one complete
 * sensor deflection, matching what the reference front ends feed it.
 */
void mgbaMobileSetRotation(struct MgbaMobile* emu, float tiltX, float tiltY, float gyroZ) {
	if (!emu) {
		return;
	}
	if (tiltX < -1.0f) {
		tiltX = -1.0f;
	}
	if (tiltX > 1.0f) {
		tiltX = 1.0f;
	}
	if (tiltY < -1.0f) {
		tiltY = -1.0f;
	}
	if (tiltY > 1.0f) {
		tiltY = 1.0f;
	}
	__atomic_store_n(&emu->tiltX, (int32_t) (tiltX * 1073741824.0f), __ATOMIC_RELAXED);
	__atomic_store_n(&emu->tiltY, (int32_t) (tiltY * 1073741824.0f), __ATOMIC_RELAXED);
	__atomic_store_n(&emu->gyroZ, (int32_t) (gyroZ * 1073741824.0f), __ATOMIC_RELAXED);
}

// == Cheats ==

static void cheatFilePath(const struct MgbaMobile* emu, char* out, size_t outLen) {
	out[0] = '\0';
	if (!emu || !emu->core || emu->savePath[0] == '\0' || emu->core->dirs.baseName[0] == '\0') {
		return;
	}
	snprintf(out, outLen, "%s/%s.cht", emu->savePath, emu->core->dirs.baseName);
}

static struct mCheatDevice* cheatDevice(struct MgbaMobile* emu) {
	if (!emu || !emu->core || !emu->core->cheatDevice) {
		return NULL;
	}
	return emu->core->cheatDevice(emu->core);
}

static void loadCheats(struct MgbaMobile* emu) {
	struct mCheatDevice* device = cheatDevice(emu);
	char path[1200];
	if (!device) {
		return;
	}
	cheatFilePath(emu, path, sizeof(path));
	struct VFile* vf = VFileOpen(path, O_RDONLY);
	if (!vf) {
		return;
	}
	if (!mCheatParseFile(device, vf)) {
		MOBILE_LOGI("Cheat file present but unreadable: %s", path);
	}
	vf->close(vf);
}

static void saveCheats(struct MgbaMobile* emu) {
	struct mCheatDevice* device = cheatDevice(emu);
	char path[1200];
	if (!device) {
		return;
	}
	cheatFilePath(emu, path, sizeof(path));
	struct VFile* vf = VFileOpen(path, O_WRONLY | O_CREAT | O_TRUNC);
	if (!vf) {
		return;
	}
	mCheatSaveFile(device, vf);
	vf->close(vf);
}

int mgbaMobileCheatCount(const struct MgbaMobile* emu) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	if (!device) {
		return 0;
	}
	return (int) mCheatSetsSize(&device->cheats);
}

void mgbaMobileCheatName(const struct MgbaMobile* emu, int index, char* out, size_t outLen) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	const char* name = "";
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	if (set && set->name) {
		name = set->name;
	}
	snprintf(out, outLen, "%s", name);
}

bool mgbaMobileCheatEnabled(const struct MgbaMobile* emu, int index) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return false;
	}
	return (*mCheatSetsGetPointer(&device->cheats, index))->enabled;
}

void mgbaMobileCheatSetEnabled(struct MgbaMobile* emu, int index, bool enabled) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	set->enabled = enabled;
	mCheatRefresh(device, set);
	saveCheats(emu);
}

bool mgbaMobileCheatAdd(struct MgbaMobile* emu, const char* name, const char* lines, int type) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || !lines) {
		return false;
	}
	struct mCheatSet* set = device->createSet(device, name ? name : "");
	if (!set) {
		return false;
	}
	bool any = false;
	const char* cursor = lines;
	char line[256];
	while (cursor && *cursor) {
		const char* end = strpbrk(cursor, "\r\n");
		size_t len = end ? (size_t) (end - cursor) : strlen(cursor);
		if (len >= sizeof(line)) {
			len = sizeof(line) - 1;
		}
		memcpy(line, cursor, len);
		line[len] = '\0';
		char* trim = line;
		while (*trim == ' ' || *trim == '\t') {
			++trim;
		}
		char* last = trim + strlen(trim);
		while (last > trim && (last[-1] == ' ' || last[-1] == '\t')) {
			--last;
		}
		*last = '\0';
		if (*trim && mCheatAddLine(set, trim, type)) {
			any = true;
		}
		cursor = end ? end + 1 : NULL;
	}
	if (!any) {
		mCheatSetDeinit(set);
		return false;
	}
	set->enabled = true;
	mCheatAddSet(device, set);
	mCheatRefresh(device, set);
	saveCheats(emu);
	return true;
}

bool mgbaMobileCheatRemove(struct MgbaMobile* emu, int index) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return false;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	mCheatRemoveSet(device, set);
	mCheatSetDeinit(set);
	saveCheats(emu);
	return true;
}

static void applyFrameskip(struct mCore* core, int skip) {
	if (skip < 0) {
		skip = 0;
	}
	core->opts.frameskip = skip;
	if (core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		gba->video.frameskip = skip;
		if (gba->video.frameskipCounter > skip) {
			gba->video.frameskipCounter = skip;
		}
	} else if (core->platform(core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) core->board;
		gb->video.frameskip = skip;
		if (gb->video.frameskipCounter > skip) {
			gb->video.frameskipCounter = skip;
		}
	}
}

static void setFastAudio(struct MgbaMobile* emu, int fast) {
	if (!emu || !emu->core || emu->fast == fast) {
		return;
	}
	emu->fast = fast;
	// 倍速也有声音：不再关闭音频采样，保持音频缓冲持续产生�?
	// 变速播放由前端 AudioTrack / AVAudioUnitVarispeed 完成�?
}

static struct mTiming* coreTiming(struct MgbaMobile* emu) {
	if (!emu->core) {
		return NULL;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		return &((struct GBA*) emu->core->board)->timing;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		return &((struct GB*) emu->core->board)->timing;
	}
	return NULL;
}

static void armLinkEvent(struct MgbaMobile* emu) {
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return;
	}
	mTimingDeschedule(timing, &emu->linkEvent);
	mTimingSchedule(timing, &emu->linkEvent, 8192);
}

static uint32_t mobilePartySidecar(struct MgbaMobile* emu, uint32_t word16);  /* ROOTHUNT2：定义见下方 */
static bool mobilePathBNativeSioOn(void);  /* W92：门 reader 定义见下方（sidecar 早退要前置声明） */
/* C-2：调用点 C 早于 helper 定义，必须前置声明（避免 -Werror 隐式声明失败）。
 * J8B 方案A：无条件声明（helper 无条件编译）。 */
static void mobileObsChainGates(void) __attribute__((unused));
static void mobileObsChainSt(struct GBA* g, int from, int to, int pc,
                             uint16_t m0, uint32_t wall) __attribute__((unused));
static void mobileObsChainProv(uint16_t own, uint16_t netPush, uint16_t peer) __attribute__((unused));
static void mobileObsChainProxy(struct MgbaMobile* emu, uint16_t own, uint16_t peer) __attribute__((unused));
static uint32_t readLinkOut(struct MgbaMobile* emu, uint16_t* modeOut) {
	if (!emu->core) {
		return 0xFFFFFFFFu;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		*modeOut = (uint16_t) gba->sio.mode;
		if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			return gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
		}
		if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			return gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
		}
		return gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) emu->core->board;
		*modeOut = 0;
		return gb->memory.io[GB_REG_SB];
	}
	return 0xFFFFFFFFu;
}

static void finishIncoming(struct MgbaMobile* emu, uint16_t mode, uint32_t remote, int player) {
	int me = netLinkPlayer(emu->link);
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (emu->sioInDbg < 40) {
			++emu->sioInDbg;
			MOBILE_LOGI("SIO in me=%d pktmode=%u player=%d siomode=%d siocnt=%04X wait=%d remote=%04X",
			            me, mode, player, (int) gba->sio.mode, gba->sio.siocnt, emu->sioWaiting, remote);
		}
		if (gba->sio.mode == GBA_SIO_MULTI && (mode == GBA_SIO_MULTI || mode == 0)) {
			/* 只在游戏确实处于联机等待时才收尾：要么 Busy 立着（游戏自己起了
			 * 一次传输），要么开了 SIO 中断使能（宝可梦的等待写法 0x600F，
			 * Busy 留给硬件置位）。两个都没有说明游戏不在联机，乱填数据发
			 * 中断会把游戏没在等的交换结果塞给它。 */
			bool busy = (gba->sio.siocnt & 0x0080) != 0;
			bool armed = (gba->sio.siocnt & 0x4000) != 0;
			if (emu->sioWaiting || !(busy || armed)) {
				if (emu->sioSkipDbg < 20) {
					++emu->sioSkipDbg;
					MOBILE_LOGI("SIO in skip me=%d busy=%d armed=%d wait=%d siocnt=%04X",
					            me, busy, armed, emu->sioWaiting, gba->sio.siocnt);
				}
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
			LINK_VERBOSE("SIO multi done slave me=%d m0=%04x m1=%04x", me, data[0], data[1]);
			if (emu->sioSlaveDoneDbg < 20) {
				++emu->sioSlaveDoneDbg;
				MOBILE_LOGI("SIO slave done me=%d player=%d m0=%04X m1=%04X siocnt=%04X",
				            me, player, data[0], data[1], gba->sio.siocnt);
			}
			emu->sioFallback++;
			emu->sioHasRemote = true;
			emu->sioRemote = remote;
			GBASIOMultiplayerFinishTransfer(&gba->sio, data, 0);
		} else if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			GBASIONormal8FinishTransfer(&gba->sio, (uint8_t) remote, 0);
		} else if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			GBASIONormal32FinishTransfer(&gba->sio, remote, 0);
		}
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) emu->core->board;
		gb->sio.pendingSB = (uint8_t) remote;
		uint8_t sc = gb->memory.io[GB_REG_SC];
		int speed = GBRegisterSCGetClockSpeed(sc);
		if (speed < 0 || speed > 1) {
			speed = 0;
		}
		gb->sio.period = GBSIOCyclesPerTransfer[speed];
		gb->memory.io[GB_REG_SC] = GBRegisterSCFillEnable(sc);
		gb->sio.remainingBits = 8;
		mTimingDeschedule(&gb->timing, &gb->sio.event);
		int scale = gb->doubleSpeed ? 1 : 2;
		mTimingSchedule(&gb->timing, &gb->sio.event, gb->sio.period * scale);
	}
}

static void completeMultiTransfer(struct MgbaMobile* emu, uint32_t remote, bool haveRemote, uint32_t cyclesLate);
/* 路线A：自槽 / data[me] 与 push 同源套用（定义见下方，单取值点）。 */
static uint16_t mobileHandshakeHoldWord(struct MgbaMobile* emu, uint16_t own);
static void completeMultiTransferBus(struct MgbaMobile* emu, const uint32_t vals[4], int players, uint32_t cyclesLate);

/* 联机排查用的游戏内存窥探（只在开着 MGBA_LINK_PEEK 时编译进去）。
 * 地址来自 ROM 工程的 rom.map（pokeemerald 系布局）。 */
#ifndef MGBA_LINK_PEEK
#define MGBA_LINK_PEEK 1
#endif

#if MGBA_LINK_PEEK
/* 联机排查用的游戏内存窥探（只在开着 MGBA_LINK_PEEK 时编译进去）。
 * 地址来自 ROM 工程的 rom.map（pokeemerald 系布局，v1.7 汉化改版）：
 *   gLink                  0x03002AF4  struct Link
 *   gLinkStatus            0x03002A9C  u32（localId | playerCount<<4 | ...）
 *   gShouldAdvanceLinkState 0x03002AD8 u8
 *   gLinkOpen              0x02027BB0
 *   gWirelessCommType      0x03002AAD  u8（0=有线，1=无线）
 *   gLinkErrorOccurred     0x03002A30
 *   gReceivedRemoteLinkPlayers 0x03002AC1
 *   gBlockReceivedStatus   0x03002A40
 * struct Link 内部偏移（include/link.h）：sendQueue 在 +0x18，
 * u16 data[8][50] 之后是 pos/count；recvQueue 在 +0x33C，
 * u16 data[4][8][50] 之后是 pos/count。 */
/* 所有 IWRAM 窥探地址统一套 NAV_IW（gLinkOpen 属 EWRAM，走 NAV_EW）。
 * struct Link 内部偏移（PEEK_LK_*）是相对量，由 PEEK_LINK 一次加 delta 即可。 */
#define PEEK_LINK_STATUS NAV_IW(0x03002A9Cu)
#define PEEK_LINK_STATE  NAV_IW(0x03002AD8u)
#define PEEK_LINK        NAV_IW(0x03002AF4u)
#define PEEK_LINK_OPEN   NAV_EW(0x02027BB0u) /* gLinkOpen（rom.map：0x02027BB0；
	                                       旧值 0x02027B80 是 EWRAM 整体上移
	                                       0x30 之前的老地址，漏改 ⇒ PEEK 的
	                                       open= 一直在读 gBlockSendBuffer 那
	                                       一带的垃圾字节） */
#define PEEK_LINK_WLESS  NAV_IW(0x03002AADu)
#define PEEK_LINK_ERROCC NAV_IW(0x03002A30u)
#define PEEK_LINK_RECVPL NAV_IW(0x03002AC1u)
#define PEEK_LINK_BLOCKS NAV_IW(0x03002A40u)
/* gSaveBlock1Ptr：玩家坐标 x/y（+0/+2）和所在地图 group/num（+4/+5）。
 * 镜像核没有画面输出，只有这三个量能判断它和可见核是不是在同一张图的
 * 同一格上——联机时两边走散就是从这里看出来的。 */
#define PEEK_SAVEBLOCK1  NAV_IW(0x03004964u)
/* struct Link 内部偏移 */
#define PEEK_LK_ISMASTER 0x00
#define PEEK_LK_STATE    0x01
#define PEEK_LK_LOCALID  0x02
#define PEEK_LK_PLAYERS  0x03
#define PEEK_LK_SICTR    0x0D
#define PEEK_LK_HANDSHAKE 0x0E
#define PEEK_LK_FIELD_F  0x0F
#define PEEK_LK_HWERR    0x10
#define PEEK_LK_BADCK    0x11
#define PEEK_LK_QFULL    0x12
#define PEEK_LK_LAG      0x13
#define PEEK_LK_CHECKSUM 0x14
#define PEEK_LK_SENDIX   0x16
#define PEEK_LK_RECVIX   0x17
#define PEEK_LK_SENDQ_POS 0x0338
#define PEEK_LK_SENDQ_CNT 0x0339
#define PEEK_LK_RECVQ_POS 0x0FBC
#define PEEK_LK_RECVQ_CNT 0x0FBD
#endif

/* 【P0 / LAG 写时拦截】声明先于首次调用（serviceLink 下方）；定义见 mobileBattleKeepAlive 前。 */
static void mobileClearClockLag(struct MgbaMobile* emu);

static void serviceLink(struct MgbaMobile* emu) {
	if (!emu->linkAttached || !emu->link) {
		return;
	}
	/* 【P0 / LAG 写时拦截】与 PC serviceLink:4144 sioClearClockLag 对称：每轮入口
	 * 维护 gbaLinkDropClockLag=链路连着，让共享 C memory.c 的 _dropLagStore 在
	 * VBlank 写 lag 时真正吞掉伪 LAG（事后清位来不及）。 */
	mobileClearClockLag(emu);
	/* 轮询频率探针：serviceLink 由 linkPollEvent 驱动（每 8192 个模拟周期一次），
	 * 理论上每帧 30 多次。联机握手慢的时候要靠它确认「模拟线程有没有在跑」。 */
	++emu->sioPolls;
	if ((emu->sioPolls % 1000) == 0) {
		uint32_t now = wallNowMs();
		if (emu->sioPollStamp) {
			MOBILE_LOGI("POLL me=%d n=%u rate=%u/s svcAvg=%.2fms svcMax=%.2fms",
			            netLinkPlayer(emu->link), emu->sioPolls,
			            (uint32_t) (1000.0 * 1000.0 / (double) (now - emu->sioPollStamp)),
			            emu->sioSvcTotal / (double) emu->sioSvcN, emu->sioSvcMax);
			emu->sioSvcTotal = 0.0;
			emu->sioSvcMax = 0.0;
			emu->sioSvcN = 0;
		}
		emu->sioPollStamp = now;
	}
	uint32_t svcStart = wallNowMs();
	/* 链路状态可能在游戏读 SIOCNT 之后才变化（游戏只在少数几处写 SIOCNT），
	 * 所以每次轮询都把终端位重新对齐一次「链路当前真实的样子」。
	 * 游戏在 HANDSHAKE 态每帧读一次 SIOCNT，下一帧就会用上正确的值。 */
	applyLinkTerminalBits(emu);
	/* 让 IO 线程随时能拿到本机当前要发的字节：对端发请求时它直接回，不必等
	 * 模拟线程排到。 */
	uint16_t localMode = 0;
	uint32_t local = readLinkOut(emu, &localMode);
	/* ROOTHUNT2：publish 旁路发布的字也带 species sidecar —— 若对端有字是经
	 * reply/publish 通道（而非 peerQ push）到达，这是 PC 唯一能解到 sidecar 的
	 * 路径。低16位真 SIO 字不变，高16位 0x8000|idx<<8|byte。 */
	netLinkPublish(emu->link, localMode, mobilePartySidecar(emu, local));
	/* 持续量链路 RTT（µs）：GBA 联机要求每帧 9 次以上串行中断，
	 * 一轮往返必须压进 1ms，这个数直接决定能不能连上。 */
	netLinkPingTick(emu->link);
	/* MULTI 的发送是「一轮一次、两边各推各的」，不再为每个往返等一条 ACK
	 * （原来每轮要等 ACK，实测 16ms/轮，握手要跑上万轮，游戏最后报「连接
	 * 发生了错误」）。1P 在写 SIOCNT 起传输那一刻推，2P 在收尾之后的下一
	 * 次轮询推 —— 两边的时机差别见下面各自的注释，这是本文件最容易错位
	 * 一格的地方。 */
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		int player = netLinkPlayer(emu->link);
		/* 从机不自己起传输：真机里 MULTI 的时钟是 1P 产生的，从机只是在自己的
		 * SIO 被时钟扫过时收尾。1P 每轮开始时把本轮的字推过来，收到就把这次
		 * 传输收掉（写 SIOMULTI + 发 SIO 中断），从机自己的游戏才会往下走。
		 *
		 * 收尾动作搬到 sioSlaveDoneEvent 了：由一个**按固定模拟周期触发**的
		 * 事件来收尾，把从机的模拟时钟钉在与主机同速的节拍上（为什么必须同速
		 * 见 sioSlaveDoneEvent 的注释）。这里只负责把事件挂上。
		 *
		 * 千万不要「提前把下一轮推出去」：gen8 的字是在上一轮收尾的 SIO 中断处理
		 * 里写的，提前推要赌中断已经跑完 —— 实测 93 轮赌输 1 轮（推出去 0000、
		 * 游戏随后才写 AABB），对端把旧值记进本轮，checksum 当场 ck=1。 */
		/* 【从机的轮次事件只在「对端真的推了字过来」时才挂】
		 *
		 * 原来这里判的是 gba->sio.mode == GBA_SIO_MULTI —— 但 gen8 的
		 * DisableSerial() 写的是 REG_SIOCNT = SIO_MULTI_MODE(0x2000)，
		 * 而 LinkMain1 一进 START0 就会调它一次，之后 sio.mode 就一直
		 * 停在 MULTI。于是「只要链路挂上」这个条件在**游戏还没进俱乐部、
		 * 主机一个字节都没推**的时候就成立，从机的轮次事件被挂上，
		 * 每 18363 个模拟周期阻塞地等一个永远不会来的字。
		 *
		 * 后果（实测）：模拟线程每推进 1.1ms 的模拟时间就要阻塞 20ms 的
		 * 墙钟时间，帧率从 60fps 掉到 1.4fps —— 从机的游戏直接冻在标题
		 * 画面走不到俱乐部；联机中掉帧又会打破 gen8「每帧至少 9 次串行
		 * 中断」的要求，游戏报「通信错误…链接是坏的还是终端不匹配？」。
		 *
		 * 改成「对端队列里有字才挂」：没联机时主机一个字都不推，从机永远
		 * 不会被挂上，模拟线程保持满速；联机开始后主机每轮推一个字，从机
		 * 照旧一轮一个地取走。
		 *
		 * 总线例外（2026-11-10）：3/4 人的字走 PKT_PUSH / PKT_BUS_ROUND，
		 * 根本不进 peerQ，netLinkPeerPending() 恒为 0 —— 沿用原判据会让
		 * 从机轮次事件永远 arm 不上（主机每轮等满超时窗，从机收不到 SIO
		 * 中断卡在进房前：busgame 实测从机 45s 只跑 302 帧）。总线改看
		 * sioRoundWordValid：游戏自己写过 SIOCNT 起 MULTI 才算一轮，既不
		 * 会在还没进房间时自旋，也不依赖主机先广播（避开第一轮互等）。 */
		bool busMode = netLinkBusActive(emu->link);
		bool roundReady = busMode ? emu->sioRoundWordValid
		                          : netLinkPeerPending(emu->link) > 0;
		if (player != 0 && !emu->sioSlaveArmed && roundReady) {
			struct mTiming* timing = coreTiming(emu);
			if (timing) {
				mTimingSchedule(timing, &emu->sioSlaveDone, emu->sioSlavePeriod);
				emu->sioSlaveArmed = true;
				/* 原日志无门无上限：TYPE_STATE 后 mode!=MULTI 时一次运行能打
				 * 5506 条全是 idx=0 的 arm（PB24），把现场日志淹掉。 */
				{
					static int armLogged;
					if (getenv("MGBAX_SLAVE_DIAG") && armLogged++ < 24) {
						MOBILE_LOGI("SIO slave arm: me=%d idx=%u period=%u",
						            player, (unsigned) emu->sioIndex, emu->sioSlavePeriod);
					}
				}
			}
		}
	}
	/* 先收主机的传输请求：从机的这一次传输应当由它来收尾。做完再考虑看门狗，
	 * 否则排队中的请求会被看门狗把 Busy 清掉、然后被 busy 守卫丢掉。 */
	int guard = 0;
	int taken = 0;
	uint16_t seq;
	uint16_t mode;
	uint32_t value;
	int player;
	while (guard++ < 8 && netLinkTakeRequest(emu->link, &seq, &mode, &value, &player)) {
		++taken;
		if (emu->sioTakeDbg < 30 && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			++emu->sioTakeDbg;
			struct GBA* g = (struct GBA*) emu->core->board;
			MOBILE_LOGI("SIO take seq=%u mode=%u player=%d siocnt=%04X wait=%d",
			            seq, mode, player, g->sio.siocnt, emu->sioWaiting);
		}
		if (emu->sioWaiting) {
			/* 本机正等自己这次传输的应答，说明双方都在当主机（正常不会发生
			 * ：只有 1P 能发起 MULTI 传输）。丢弃，避免同一次传输被完成两次。 */
			continue;
		}
		LINK_VERBOSE("SIO req seq=%u mode=%u value=%08x player=%d", seq, mode, value, player);
		if (mode == GBA_SIO_MULTI) {
			/* MULTI 不再走请求：两边各自按轮次推送、各自到点收尾，请求一旦
			 * 也拿来收尾就会把同一轮完成两次。 */
			continue;
		}
		finishIncoming(emu, mode, value, player);
	}
	/* 原来的「看门狗」被 sioSlaveDoneEvent 取代了：从机的每一轮都由那个
	 * 定时事件收尾，事件里已经带 2500ms 的超时等待，主机掉线时从机会自己
	 * 超时收尾，不需要额外的看门狗。
	 *
	 * 而且看门狗在这里是**危险**的：它会在 Busy 位还挂着的时候擅自
	 * ++sioIndex 并多推一个字，那一轮就凭空多出来，双方的轮次从此错位，
	 * checksum 必挂。现在从机的轮次只有一个来源（sioSlaveDoneEvent），
	 * 轮次一一对应，不存在这种风险。 */
	/* serviceLink 自身耗时：它跑在模拟线程里，一次 30ms 就足以让对端多等一整
	 * 个轮询周期（这正是「每轮等 31ms」的嫌疑点）。 */
	{
		uint32_t spent = wallNowMs() - svcStart;
		emu->sioSvcTotal += (double) spent;
		emu->sioSvcMax = spent > emu->sioSvcMax ? (double) spent : emu->sioSvcMax;
		++emu->sioSvcN;
	}
}

static bool mobileRhVerbose(void);          /* 定义见下方（日志门） */
static void mobileEnsureLinkBtcfg(struct GBA* g);  /* ROOTHUNT2 方案Y，定义见下方 */
static void mobileEnsureLinkOpen(struct MgbaMobile* emu);  /* ROOTHUNT2 块交换根治① */
static bool linkBtcfgOn(void);                    /* ROOTHUNT2 方案Y 门，定义见下方 */
static bool mobileHsHoldOn(void);          /* 路线A 握手保持门，定义见下方（首次调用在 completeMultiTransfer） */
static bool b7Verbose(void);                /* ROOTHUNT2 B7 打点门，定义见下方 */
static void mobileBattleKeepAlive(struct MgbaMobile* emu);  /* 定义见下方 */
static bool mobileInBattleStartup(struct MgbaMobile* emu);  /* 定义见下方 */
static bool mobileRestoreLinkPlayersForBattle(struct MgbaMobile* emu);
static bool mobileInClosePhase(struct MgbaMobile* emu);
static void mobileDriveBattleRehandshake(struct MgbaMobile* emu);
static void mobileGuardBattleError(struct MgbaMobile* emu);
static void mobileCompleteBlockExchange(struct MgbaMobile* emu);
static void mobileGrayForceBrs(struct MgbaMobile* emu);  /* 灰区全开 GZ5：只写 brs，不碰 party/nr/rem */
static void mobileMuTrace(struct MgbaMobile* emu);
static void mobilePreloadEnemySpecies(struct MgbaMobile* emu);
static void mobileRestoreBattleIdentity(struct MgbaMobile* emu);
static void mobileUnblockLinkTask(struct MgbaMobile* emu);
static void mobileReshowBattleVisual(struct MgbaMobile* emu);  /* ROOTHUNT2 对手框重绘，定义见下方 */

/* 【ROOTHUNT 迭代 12】mobile 侧座位就绪补位（默认关，镜像 Qt sioSeatAssist）。
 * 安卓属性 mgbax.link.seat_assist=1 / 桌面 MGBAX_SEAT_ASSIST=1 打开。 */
#define M_RH_TRADESTATES 0x03004A10u
#define M_RH_KEYINTERCEPT 0x03004A14u
#define M_RH_READY_CB     0x0818A925u
/* ROOTHUNT 迭代 18: 代踩座位 coord-event，镜像 Qt rhCreateSeatTask。 */
#define M_RH_GTASKS     0x02033D0Cu
#define M_RH_VAR8005    0x0202199Eu
#define M_RH_SEAT_TASK  0x08107053u
#define M_RH_BATTLE_TASK 0x08106CBDu
static void mobileCreateSeatTask(struct GBA* g) {
	uint32_t base = NAV_EW(M_RH_GTASKS);
	int slot = -1;
	for (int i = 0; i < 16; ++i) {
		if (!GBAView8(g->cpu, base + (uint32_t) i * 0x28u + 4u)) { slot = i; break; }
	}
	if (slot < 0) { return; }
	GBAPatch16(g->cpu, NAV_EW(M_RH_VAR8005), 1, NULL);
	mobileEnsureLinkBtcfg(g);   /* ROOTHUNT2 方案Y：紧邻 VAR_8005 写 var8004=1 */
	for (int j = 0; j < 16; ++j) {
		GBAPatch16(g->cpu, base + (uint32_t) slot * 0x28u + 8u + (uint32_t) j * 2u, 0, NULL);
	}
	uint32_t t = base + (uint32_t) slot * 0x28u;
	GBAPatch32(g->cpu, t, (int32_t) M_RH_SEAT_TASK, NULL);
	GBAPatch16(g->cpu, t + 8u + 28u, (int16_t) (M_RH_BATTLE_TASK & 0xFFFFu), NULL);
	GBAPatch16(g->cpu, t + 8u + 30u, (int16_t) (M_RH_BATTLE_TASK >> 16), NULL);
	GBAPatch8(g->cpu, t + 7u, 80, NULL);
	int first = -1;
	for (int i = 0; i < 16; ++i) {
		if (i != slot && GBAView8(g->cpu, base + (uint32_t) i * 0x28u + 4u)
		    && GBAView8(g->cpu, base + (uint32_t) i * 0x28u + 5u) == 0xFEu) { first = i; break; }
	}
	if (first < 0) {
		GBAPatch8(g->cpu, t + 5u, 0xFE, NULL);
		GBAPatch8(g->cpu, t + 6u, 0xFF, NULL);
	} else {
		int last = first;
		for (int guard = 0; guard < 16; ++guard) {
			uint8_t nx = GBAView8(g->cpu, base + (uint32_t) last * 0x28u + 6u);
			if (nx == 0xFFu) { break; }
			last = nx;
		}
		GBAPatch8(g->cpu, base + (uint32_t) last * 0x28u + 6u, (int) (uint8_t) slot, NULL);
		GBAPatch8(g->cpu, t + 5u, (int) (uint8_t) last, NULL);
		GBAPatch8(g->cpu, t + 6u, 0xFF, NULL);
	}
	GBAPatch8(g->cpu, t + 4u, 1, NULL);
	if (mobileRhVerbose()) {
		MOBILE_LOGI("[RHSEATT] created seat task slot=%d", slot);
	}
}

/* ================= ROOTHUNT2 灰区全开总门（§3.5，与 PC sioGrayAllOn 对称） =================
 * MGBAX_GRAY_ALL=1 / Android prop mgbax.link.gray_all / iOS setter：一次性打开合法
 * 7 类灰区（GZ1 C3 直写 gLinkOpen、GZ2 seat-assist task、GZ3 rearm、GZ4 RHSLVINJ、
 * GZ5 RHBRS 强写 brs、GZ6 var8004 补写、GZ7 rem-restore）。默认 0 保持原行为。
 * 【红线不滑坡】本门**不**触碰 rhMOff()/rhPatchesOff()：RL1 造 gEnemyParty、RL2 造
 * gBlockRecvBuffer、RL3 sidecar species、RL4 手写 nr=FALSE/lp0→lp1、RL5 伪 CROSSED
 * 的早退门维持原样默认关；本门也不蕴含 FORCE_EXCHANGE（其 nr=FALSE 属 RL4）。 */
#define MOBILE_GRAY_ALL_ENV        "MGBAX_GRAY_ALL"
#define MOBILE_GRAY_LOBBY_OPEN_ENV "MGBAX_GRAY_LOBBY_OPEN"
/* Android 必须 debug.* 前缀：stock A14 AVD SELinux 拒绝 setprop 非 debug 的 mgbax.*
 *（driver cloud2p_avd.py A11 教训）；两 driver 按此名显式下发 + readback。 */
#define MOBILE_GRAY_ALL_PROP        "debug.mgbax.link.gray_all"
#define MOBILE_GRAY_LOBBY_OPEN_PROP "debug.mgbax.link.gray_lobby_open"
static int s_grayAll = -1;
static bool mobileGrayAllOn(void) {
	if (s_grayAll < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MOBILE_GRAY_ALL_PROP, p);
		s_grayAll = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv(MOBILE_GRAY_ALL_ENV);
		s_grayAll = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_grayAll != 0;
}
void mgbaMobileSetGrayAll(bool enabled) { s_grayAll = enabled ? 1 : 0; }
/* C3 关键点：大厅态 cb2=0817481D 不在战斗段，绕过 EnsureLinkOpen 的 cb2 窗门。
 * 独立门 MGBAX_GRAY_LOBBY_OPEN=1 / mgbax.link.gray_lobby_open，被 GRAY_ALL 蕴含。 */
static int s_grayLobbyOpen = -1;
static bool mobileGrayLobbyOpenOn(void) {
	if (mobileGrayAllOn()) {
		return true;
	}
	if (s_grayLobbyOpen < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MOBILE_GRAY_LOBBY_OPEN_PROP, p);
		s_grayLobbyOpen = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv(MOBILE_GRAY_LOBBY_OPEN_ENV);
		s_grayLobbyOpen = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_grayLobbyOpen != 0;
}
void mgbaMobileSetGrayLobbyOpen(bool enabled) { s_grayLobbyOpen = enabled ? 1 : 0; }
/* ROOTHUNT2 零注入对照总闸：MGBAX_RH_OFF(PC getenv)/debug.mgbax.link.rh_off(移动端
 * property) =1 时关闭所有 ROOTHUNT2 数据/重绘/单端强推补丁，保留握手补丁。与 PC
 * rhPatchesOff() 同语义。用于 A/B 判断"补丁帮倒忙 vs 链路坏"。
 * s_rhOff：-1=未定，从 env/property 读；>=0=由 mgbaMobileSetRhOff() 显式设置
 *（iOS Swift 无 setprop，必须走这个 setter，否则 static 首次锁死恒 0）。 */
static int s_rhOff = -1;
static bool rhMOff(void) {
	if (s_rhOff < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.rh_off", p);
		s_rhOff = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_RH_OFF");
		s_rhOff = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_rhOff != 0;
}

/* 供 iOS Swift / Android JNI 显式设置零注入总闸；必须在首个 SIO linkPoll 前调用。
 * 与 mgbaMobileSioSetInject 同级全局控制面，无 emu 参数。 */
void mgbaMobileSetRhOff(bool enabled) {
	s_rhOff = enabled ? 1 : 0;
}

static void mobileSeatAssist(struct MgbaMobile* emu) {
	static int en = -1;
	static unsigned tk;
	if (en < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.link.seat_assist", v);
		en = (v[0] == '1') ? 1 : 0;
#else
		const char* v = getenv("MGBAX_SEAT_ASSIST");
		en = (v && atoi(v) == 1) ? 1 : 0;
#endif
	}
	if (mobileGrayAllOn()) {
		en = 1;   /* 灰区全开：蕴含 seat-assist 手建 task（不触碰 RL4 FORCE_EXCHANGE 门） */
	}
	if (!en || !emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	/* ROOTHUNT 迭代 21: 座位任务必须与 t0/t1 早退分支解耦 —— APPHUNT 发现
	 * 一旦本端先到 0x82（往往是 assist 自己写的），后续调用全在 3241 早退，
	 * mobileCreateSeatTask 永远执行不到 ⇒ 游戏没有 Task_EnterCableClubSeat。 */
	static bool seatTaskDone;
	if (GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) != 4u
	    || GBAView8(g->cpu, NAV_IW(0x03002AF4u) + 0x03u) < 2u) {
		tk = 0;
		seatTaskDone = false;   /* 新会话重新允许建任务 */
		return;
	}
	if (!seatTaskDone) {
		seatTaskDone = true;
		mobileCreateSeatTask(g);
	}
	uint8_t t0 = GBAView8(g->cpu, NAV_IW(M_RH_TRADESTATES));
	uint8_t t1 = GBAView8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 1u);
	uint32_t ic = (uint32_t) GBAView32(g->cpu, NAV_IW(M_RH_KEYINTERCEPT));
	static unsigned rk;
	{
		static unsigned mg;
		if (mobileRhVerbose() && (++mg <= 5 || (mg % 256) == 0)) {
			unsigned skip = (t0 == 0x82u && t1 == 0x82u)
			                ? ((ic == M_RH_READY_CB || rk >= 6u) ? 4u : 5u) : 6u;
			MOBILE_LOGI("[RHSEATG] st=4 pc>=2 rem=%u cnt=%u t0=%u t1=%u ic=%08X rk=%u seatDone=%d skip=%u",
			            (unsigned) GBAView8(g->cpu, NAV_IW(0x03002AC1u)),
			            (unsigned) GBAView8(g->cpu, NAV_IW(0x03004A39u)),
			            (unsigned) t0, (unsigned) t1, (unsigned) ic,
			            (unsigned) rk, seatTaskDone ? 1 : 0, skip);
		}
	}
	/* ROOTHUNT 迭代 17: 全 4 槽置 0x82 + ready key 周期性补发。 */
	if (t0 == 0x82u && t1 == 0x82u) {
		if (ic == M_RH_READY_CB || rk >= 6u) {
			return;
		}
		if (++tk < 300u) {
			return;
		}
		tk = 0;
		++rk;
		GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 2u, 0x82, NULL);
		GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 3u, 0x82, NULL);
		GBAPatch32(g->cpu, NAV_IW(M_RH_KEYINTERCEPT), (int32_t) M_RH_READY_CB, NULL);
		if (mobileRhVerbose()) {
			MOBILE_LOGI("[RHSEATK] kick=%u states=82/82/82/82 ic=%08X -> ready cb", (unsigned) rk, (unsigned) ic);
		}
		return;
	}
	if (++tk < 120u) {
		return;
	}
	tk = 0;
	GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES), 0x82, NULL);
	GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 1u, 0x82, NULL);
	GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 2u, 0x82, NULL);
	GBAPatch8(g->cpu, NAV_IW(M_RH_TRADESTATES) + 3u, 0x82, NULL);
	GBAPatch32(g->cpu, NAV_IW(M_RH_KEYINTERCEPT), (int32_t) M_RH_READY_CB, NULL);
	/* ROOTHUNT 迭代 25: 强清 rnr/rem 会跳过 gLinkPlayers[] 数据拷贝 → 对手
	 * ???，改为独立 opt-in MGBAX_FORCE_EXCHANGE / debug.mgbax.force_exchange，
	 * 默认关。 */
	{
		static int fx = -1;
		if (fx < 0) {
#ifdef __ANDROID__
			char v[PROP_VALUE_MAX] = {0};
			rhGetProp("mgbax.force_exchange", v);
			fx = (v[0] == '1') ? 1 : 0;
#else
			const char* v = getenv("MGBAX_FORCE_EXCHANGE");
			fx = (v && atoi(v) == 1) ? 1 : 0;
#endif
		}
		if (fx && GBAView8(g->cpu, NAV_IW(0x03002AC1u)) != 1u) {
			GBAPatch8(g->cpu, NAV_IW(0x03002A3Cu), 0, NULL);
			GBAPatch8(g->cpu, NAV_IW(0x03002A3Cu) + 1u, 0, NULL);
			GBAPatch8(g->cpu, NAV_IW(0x03002AC1u), 1, NULL);
		}
	}
	if (mobileRhVerbose()) {
		MOBILE_LOGI("[RHSEAT] t0=%u t1=%u ic=%08X -> 82/82 ready cb; rem=%u",
		            (unsigned) t0, (unsigned) t1, (unsigned) ic,
		            (unsigned) GBAView8(g->cpu, NAV_IW(0x03002AC1u)));
	}
}

/* ROOTHUNT 迭代 20: mobile 侧战斗交接补发 READY_CLOSE_LINK(0x5FFF)，
 * 语义与 Qt sioCloseGrace 一致；opt-in MGBAX_CLOSE_GRACE /
 * debug.mgbax.close_grace，只在 gLinkType=BATTLE 且本端已退出 state4 后
 * 补发一轮（最多 40 次）。 */
static void mobileCloseGrace(struct MgbaMobile* emu, struct mTiming* timing) {
	static int en = -1;
	static unsigned left;
	static bool done;
	if (en < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.link.close_grace", v);
		en = (v[0] == '1') ? 1 : 0;
#else
		const char* v = getenv("MGBAX_CLOSE_GRACE");
		en = (v && atoi(v) == 1) ? 1 : 0;
#endif
	}
	if (!en || !emu || !emu->link || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint16_t lt = GBAView16(g->cpu, NAV_EW(MOBILE_LINK_TYPE_BATTLE));
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	bool inBattle = cb2 >= MOBILE_BATTLE_LO() && cb2 < MOBILE_BATTLE_HI();
	static unsigned dbgN;
	if (mobileRhVerbose() && (++dbgN % 256) == 0) {
		MOBILE_LOGI("[RHCLOSEG] lt=%04X cb2=%08X inBattle=%d done=%d left=%u net=%d",
		            (unsigned) lt, (unsigned) cb2, inBattle ? 1 : 0,
		            done ? 1 : 0, (unsigned) left, netLinkState(emu->link));
	}
	/* 迭代 44: 只在**关链发起段**推 5FFF；关链后重握手阶段继续推会干扰
	 * state 2→4（APPHUNT-RBATTLE 两端停在 st=2 的元凶之一）。 */
	if (lt != MOBILE_LINKTYPE_BATTLE || !mobileInClosePhase(emu)) {   /* LINKTYPE_BATTLE */
		done = false;
		return;
	}
	if (done) {
		return;
	}
	/* ROOTHUNT 迭代 25: 镜像 Qt 的 16× 0x5FFF 突发 —— 战斗一进入本端事件
	 * 链就停，逐次 push 只能发出 1~2 个，对端来不及消费。 */
	done = true;
	left = 0;
	uint32_t stamp = timing ? mTimingCurrentTime(timing) : 0;
	for (unsigned i = 0; i < 16u; ++i) {
		netLinkPush(emu->link, GBA_SIO_MULTI, LINKCMD_READY_CLOSE_LINK,
		            (uint16_t) (emu->sioIndex + 1u + i), stamp);
	}
	if (mobileRhVerbose()) {
		MOBILE_LOGI("[RHCLOSE] grace BURST 16x 5FFF idx=%u lt=%04X cb2=%08X",
		            (unsigned) emu->sioIndex, (unsigned) lt, (unsigned) cb2);
	}
}

/* 【ROOTHUNT 迭代 29】对手真实性内存判据（不受战斗黑屏影响）：
 * gLinkPlayers[1] = 0x02027BF0（stride 0x1C）。version u16 @+0、
 * trainerId u32 @+4、name[12] @+8。进战斗首帧无条件打一次，verbose 时低频
 * 周期打；Qt 侧已有同格式 [RHPLYR]（91d3f2b80），两端一致。 */
#define RH_M_PLAYERS 0x02027BD4u
static void mobileDumpPlayers(struct MgbaMobile* emu) {
	static bool once;
	static unsigned dn;
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	bool inBattle = cb2 >= MOBILE_BATTLE_LO() && cb2 < MOBILE_BATTLE_HI();
	if (!inBattle) {
		return;
	}
	/* 首帧 + 战斗期每 128 轮各打一次：首帧 gBattleMons 尚未初始化，
	 * 必须后续采样才能拿到真实 species（避免误判 ???）。 */
	++dn;
	if (once && (dn % 128) != 0) {
		return;
	}
	once = true;
	uint32_t base = NAV_EW(RH_M_PLAYERS);
	uint32_t p1 = base + 0x1Cu;
	/* 【ROOTHUNT 迭代 30】A35 的字节流显示真实字段可能比标称偏移晚 2 字节
	 *（tid 的 82 0D 42 8A 出现在 +6..+9）。同一行同时打 +0 与 +2 两种解读，
	 * 让下一次 AVD 一锤定音，不再靠猜。 */
	uint16_t v0 = GBAView16(g->cpu, base + 2u);
	uint32_t t0 = GBAView32(g->cpu, base + 6u);
	uint32_t q0 = GBAView32(g->cpu, base + 10u);
	uint16_t v1 = GBAView16(g->cpu, p1 + 2u);
	uint32_t t1 = GBAView32(g->cpu, p1 + 6u);
	uint32_t n1 = GBAView32(g->cpu, p1 + 10u);
	uint32_t n2 = GBAView32(g->cpu, p1 + 14u);
	uint16_t rv = GBAView16(g->cpu, p1);
	uint32_t rt = GBAView32(g->cpu, p1 + 4u);
	uint32_t rn = GBAView32(g->cpu, p1 + 8u);
	MOBILE_LOGI("[RHPLYR] cb2=%08X +2 lp0 ver=%04X tid=%08X name=%08X lp1 ver=%04X tid=%08X name=%08X/%08X | +0 lp1 ver=%04X tid=%08X name=%08X",
	            (unsigned) cb2, (unsigned) v0, (unsigned) t0, (unsigned) q0,
	            (unsigned) v1, (unsigned) t1, (unsigned) n1, (unsigned) n2,
	            (unsigned) rv, (unsigned) rt, (unsigned) rn);
	/* 迭代 32 — 对手「出场精灵」判据（trainer 卡真实 ≠ 上场精灵真实）：
	 * gBattleMons @0x0201CCC4，struct BattlePokemon species @+0、stride 0x5C
	 * （ELF 符号 size 0x170 / 4）。至少一个对手槽 species 非零且 <0x400 才算
	 * 真实；全 0 / 0xFFFF 即 ???，不算成功。 */
	{
		uint32_t bm = NAV_EW(MOBILE_BATTLE_MONS);
		uint16_t s0 = GBAView16(g->cpu, bm);
		uint16_t s1 = GBAView16(g->cpu, bm + 0x5Cu);
		uint16_t s2 = GBAView16(g->cpu, bm + 0xB8u);
		uint16_t s3 = GBAView16(g->cpu, bm + 0x114u);
		uint8_t ec = GBAView8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT));
		uint16_t rb = GBAView16(g->cpu, NAV_EW(0x0201D188u));
		/* btlType: bit1=BATTLE_TYPE_LINK(0x2), bit3=TRAINER(0x8)。
		 * 视觉上"野生的 + ? 精灵" = 这两个位没置，即使 cb2 在 battle window。 */
		uint32_t bt = GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS));
		MOBILE_LOGI("[OPPSPECIES] cb2=%08X btlType=%08X n=%u mons=%04X,%04X,%04X,%04X enemyPartyCnt=%u recvBuf0=%04X",
		            (unsigned) cb2, (unsigned) bt, 4u, (unsigned) s0, (unsigned) s1, (unsigned) s2, (unsigned) s3,
		            (unsigned) ec, (unsigned) rb);
	}
	/* ROOTHUNT2 OPPGATE（L0，只读，不受 RH_OFF 门控）：与 PC 同格式。 */
	if (b7Verbose()) {
		uint32_t blk = NAV_EW(MOBILE_BLOCK_RECV_BUFFER);
		uint32_t base = blk + 1u * 0x100u;   /* enemy 槽 */
		MOBILE_LOGI("[OPPGATE] cb2=%08X blkHdr=%04X,%04X,%04X blkSp0=%04X cnt=%u brs=%04X",
		            (unsigned) cb2,
		            (unsigned) GBAView16(g->cpu, base),
		            (unsigned) GBAView16(g->cpu, base + 2u),
		            (unsigned) GBAView16(g->cpu, base + 4u),
		            (unsigned) ((GBAView32(g->cpu, base + 0x08u) >> 11u) & 0x7FFu),
		            (unsigned) GBAView8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT)),
		            (unsigned) GBAView16(g->cpu, NAV_IW(0x03002A40u)));
	}
	/* ROOTHUNT2 [BTLCFG] 只读观测（B7_VERBOSE 门，不受 RH_OFF）：与 PC 同格式。
	 * var8004=linkService, remPlayers=gReceivedRemoteLinkPlayers, btlType, linkType, mu。
	 * 坐实 cable_club case5 是否执行；绝不写这些变量。 */
	if (b7Verbose()) {
		uint32_t cb2now = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
		MOBILE_LOGI("[BTLCFG] cb2=%08X var8004=%u remPlayers=%u btlType=%08X linkType=%04X mu=%u",
		            (unsigned) cb2now,
		            (unsigned) GBAView16(g->cpu, NAV_EW(MOBILE_SPECIAL_VAR_8004)),
		            (unsigned) GBAView8(g->cpu, NAV_IW(MOBILE_REMOTE_LINK_PLAYERS)),
		            (unsigned) GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS)),
		            (unsigned) GBAView16(g->cpu, NAV_EW(0x02027BB2u)),
		            (unsigned) GBAView8(g->cpu, NAV_EW(MOBILE_BATTLE_COMM)));
	}
}

static void linkPollEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(cyclesLate);
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	/* 【ROOTHUNT 迭代 34】关链→重握手全过程取证：无条件每 256 轮一行，
	 * verbose 时每 64 轮一行。cb2/lstate/rem/brs/hs/sc/rc/cmdguard/net 全摊开。 */
	{
		static unsigned stN;
		if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA
		    && (++stN % 64) == 0 && (mobileRhVerbose() || (stN % 256) == 0)) {
			struct GBA* gs = (struct GBA*) emu->core->board;
			uint32_t lk = NAV_IW(0x03002AF4u);
			/* 迭代 40 修正：此前 format/实参错位一位 —— "cb2=" 实际是 rdy、
			 * "lk=" 首字段才是 cb2、"rdy=" 实际是 brs。全部标签归位。 */
			MOBILE_LOGI("[BSTATE] cb2=%08X st=%u pc=%u rem=%u nr0=%02X nr1=%02X brs=%02X rdy=%04X hs=%u sc=%u rc=%u cg=%u ok=%u net=%d wait=%d",
			            (unsigned) GBAView32(gs->cpu, NAV_CB2_PTR),
			            (unsigned) GBAView8(gs->cpu, lk + 1u),
			            (unsigned) GBAView8(gs->cpu, lk + 3u),
			            (unsigned) GBAView8(gs->cpu, NAV_IW(0x03002AC1u)),
			            (unsigned) GBAView8(gs->cpu, NAV_IW(MOBILE_REMOTE_PLAYERS_NOT_RECEIVED)),
			            (unsigned) GBAView8(gs->cpu, NAV_IW(MOBILE_REMOTE_PLAYERS_NOT_RECEIVED) + 1u),
			            (unsigned) GBAView8(gs->cpu, NAV_IW(0x03002A40u)),
			            (unsigned) GBAView16(gs->cpu, NAV_READY_CLOSE_LINK),
			            (unsigned) GBAView8(gs->cpu, lk + 0x0Eu),
			            (unsigned) GBAView8(gs->cpu, lk + 0x16u),
			            (unsigned) GBAView8(gs->cpu, lk + 0x17u),
			            (unsigned) emu->sioCmdGuardRounds, (unsigned) emu->sioOk,
			            emu->link ? netLinkState(emu->link) : -1, emu->sioWaiting ? 1 : 0);
		}
	}
	/* ROOTHUNT2 方案Y：var8004=1 每轮补写（不受 dump 节流限制），与 PC 对称。 */
	mobileEnsureLinkBtcfg(emu && emu->core ? (struct GBA*) emu->core->board : NULL);
	mobileEnsureLinkOpen(emu);   /* ROOTHUNT2 块交换根治①：恢复 gLinkOpen 让 callback 推进 */
	mobileDumpPlayers(emu);
	mobileGuardBattleError(emu);
	mobileDriveBattleRehandshake(emu);
	mobileRestoreLinkPlayersForBattle(emu);
	mobileCompleteBlockExchange(emu);
	mobileGrayForceBrs(emu);   /* 灰区全开 GZ5：独立 brs 强写，绝不写 party/nr/rem */
	mobileMuTrace(emu);
	mobilePreloadEnemySpecies(emu);
	mobileReshowBattleVisual(emu);
	mobileRestoreBattleIdentity(emu);
	mobileUnblockLinkTask(emu);
	mobileBattleKeepAlive(emu);
	mobileSeatAssist(emu);
	mobileCloseGrace(emu, timing);
	if (emu->sioEvtDbg < 20 && emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		++emu->sioEvtDbg;
		struct GBA* g = (struct GBA*) emu->core->board;
		MOBILE_LOGI("SIO evt #%u mode=%d siocnt=%04X attached=%d wait=%d",
		            emu->sioEvtDbg, (int) g->sio.mode, g->sio.siocnt, emu->linkAttached, emu->sioWaiting);
	}
	serviceLink(emu);
	if (emu->linkAttached) {
		mTimingSchedule(timing, &emu->linkEvent, 8192);
	}
}

/* 用一次传输的数据填 SIOMULTI0..3 并结束这次传输。 */
/**
 * 有线俱乐部 standby 卡死的运行时适配，与 Qt 版 sio_link.c 对称。
 * 默认关闭：安卓用系统属性 mgbax.link.unstick=1 打开，桌面用
 * MGBAX_LINK_UNSTICK=1。只在精确命中 gen8 的卡死状态时写一次
 * IWRAM 函数指针，把它换成游戏自带的 LinkCB_Standby，保留原来的
 * gLastRecvQueueCount 门控，不改 ROM、不改游戏逻辑。
 */
static int unstickEnabled(struct MgbaMobile* emu) {
	if (emu->unstickModeCached < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.link.unstick", v);
		emu->unstickModeCached = (v[0] == '1') ? 1 : ((v[0] == '2') ? 2 : 0);
#else
		const char* v = getenv("MGBAX_LINK_UNSTICK");
		emu->unstickModeCached = (v && v[0] == '1') ? 1 : ((v && v[0] == '2') ? 2 : 0);
#endif
	}
	return emu->unstickModeCached;
}

/* One decision step, kept as a public per-instance function so the desktop
 * test can prove two cores in one process do not share the one-shot latch.
 * Returns 1 exactly on the call that arms the patch. */
int mgbaMobileUnstickStep(struct MgbaMobile* emu, int mode, bool matched) {
	if (!emu || emu->unstickDone || !mode) {
		return 0;
	}
	if (!matched) {
		emu->unstickStreak = 0;
		return 0;
	}
	if (++emu->unstickStreak >= 3) {
		emu->unstickDone = true;
		return 1;
	}
	return 0;
}

static void maybeUnstickStandby(struct MgbaMobile* emu, struct GBA* gba) {
	int mode = unstickEnabled(emu);
	if (!mode || !gba || !gba->cpu) {
		return;
	}
	uint16_t l0 = GBAView16(gba->cpu, NAV_IW(0x03002AF4u));
	uint16_t rem16 = GBAView16(gba->cpu, NAV_IW(0x03002AC0u));
	uint16_t cbLo = GBAView16(gba->cpu, NAV_IW(0x03002AD4u));
	uint16_t cbHi = GBAView16(gba->cpu, NAV_IW(0x03002AD6u));
	uint32_t cb = (uint32_t) cbLo | ((uint32_t) cbHi << 16);
	uint16_t mu = GBAView16(gba->cpu, NAV_EW(0x0201CFF4u)) & 0xFFu;   // gBattleCommunication[MULTIUSE_STATE]
	uint16_t brs = GBAView16(gba->cpu, NAV_IW(0x03002A40u));
	int state = (l0 >> 8) & 0xFF;
	int rem = (rem16 >> 8) & 0xFF;
	bool matched = (state == 4 && rem == 1 && cb == SIO_CODE(0x08151DA9u) && mu == 0 && brs == 0);
	if (mgbaMobileUnstickStep(emu, mode, matched)) {
		/* mode 2 直接置 NULL，跳过 standby，让游戏进 CB2_InitBattle；
		 * SendBlock 会自行安装 LinkCB_BlockSend* 回调。 */
		uint32_t target = (mode == 2) ? 0x00000000u : SIO_CODE(0x081529BDu);
		gba->memory.iwram[(NAV_IW(0x03002AD4u) - GBA_IWRAM_BASE) >> 2] = target;
		MOBILE_LOGI("[unstick] mode=%d cb %08X -> %08X (state=%d rem=%d mu=%u)",
		            mode, cb, target, state, rem, mu);
	}
}

/* 握手字强制开关（主机自槽 0x8FFF + 补 gLink.handshakeAsMaster），默认开。
 * MGBAX_LINK_FORCEHS=0 / mgbax.link.forcehs=0 关闭，仅做 A/B 对照；
 * 与 Qt 侧 sioForceHandshake() 同一个开关名、同一语义。 */
static bool mobileForceHandshake(void) {
	static int enabled = -1;
	if (enabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.link.forcehs", v);
		enabled = (v[0] == '0') ? 0 : 1;
#else
		const char* v = getenv("MGBAX_LINK_FORCEHS");
		enabled = (v && atoi(v) == 0) ? 0 : 1;
#endif
	}
	return enabled != 0;
}

/**
 * 联机房间握手「主从选举」补触发 + 每轮补 handshakeAsMaster。
 * 镜像 Qt 侧 sio_link.c::maybeRearmHandshake（ADR-003 §4.2 (h)(h.1)）：
 *   - gen8 的 LinkMain1 只在 gShouldAdvanceLinkState==1 那一帧选举一次，网络
 *     联机两端进房间差几十帧 ⇒ 双方都退化成从机、都发 0xB9A0，没有 0x8FFF。
 *     这里代游戏重拨选举开关（限次 3 次，按一次不生效说明不是时机问题）。
 *   - 更关键的是 gLink.handshakeAsMaster：游戏 DoHandshake() 每轮都把它清掉
 *     （link.c:2268），而它决定主机本轮往 SIOMLT_SEND 写 8FFF 还是 B9A0。
 *     旧实现只在「每 64 轮」采样点补 ⇒ 主机 62/63 轮发的是从机字，对端收尾
 *     条件（tempRecvBuffer[0]==0x8FFF）几乎永不成立。现在**每轮**补一次。
 * 只写 IWRAM 的两个字节标志；state!=2（握手已结束）时完全不动。
 * 默认开（MGBAX_LINK_REARM / mgbax.link.rearm 仅 =0 才关），与 Qt/driver 一致；
 * 见 ENV-REGISTRY D1 与 production/sprint-2p/CRASH-C0000005-AUDIT.md。
 */
static void maybeRearmHandshake(struct MgbaMobile* emu, struct GBA* gba) {
	/* 迭代 35：战斗启动/战斗区绝不 rearm（关链后进战斗是 gen8 正常流程） */
	if (mobileInBattleStartup(emu)) {
		return;
	}
	if (emu->rearmEnabled < 0) {
		emu->rearmEnabled = rearmEnabledFromEnv();
	}
	if (!emu->rearmEnabled || !gba || !gba->cpu) {
		return;
	}
	/* 链路没连上时不补，避免把 1P / 断线窗口凭空拽进联机。 */
	if (!emu->link || netLinkState(emu->link) != 2) {
		return;
	}
	int me = netLinkPlayer(emu->link);
	/* 逐字节读 struct Link（不能从 uint16 右移 24 位取 playerCount，会恒为 0）。 */
	int isMaster = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x00u);
	int state = GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF);
	int players = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x03u);
	int hs = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x0Eu);       // handshakeAsMaster
	if (state != 2) {
		return;
	}
	/* 【2026-11-17 BLK-H1 修复：删掉「必须先收到对端字」的门 —— 它本身就是死锁】
	 * 与 Qt sio_link.c 同一处修复。旧门在 players<2 时要求 peerPending>0 或
	 * wIn>0 才补 handshakeAsMaster，但跨设备卡死现场正相反：本端不发 0x8FFF
	 * ⇒ DoHandshake 收不了尾 ⇒ 游戏不再起轮 ⇒ pushRecv=0 ⇒ 旧门 return ⇒
	 * 永不补 hs ⇒ 永不发 0x8FFF。Agent 11 实测 PC 端 MGBAX_LINK_REARM=1 时
	 * rearm fired=0 hs1=0 rounds=0（diag 全为 lstate=2 pc=0 intr=0 rem=0）。
	 * 上面的 netLinkState()==2 已证明真对端存在，state==2 证明在握手态；
	 * pushRecv 是握手成功的结果而非前提，单机/断线由 netLinkState()!=2 挡掉。 */
	/* 迭代 57：回退从机 hs-force（实测有害）；从机握手字问题在 SIO 字层修。 */
	if (isMaster != 8 && me != 0) {
		static unsigned skipN;
		if ((++skipN & 0xFF) == 1) {
			MOBILE_LOGI("[MGBAX_GATE] rearm_skip=slave me=%d isMaster=%d players=%d",
			            me, isMaster, players);
		}
		return;
	}
	/* handshakeAsMaster 每轮补一次（游戏下一轮会自己清掉，正好一轮一清）。
	 * 无条件补位，与 Qt sio_link.c 每轮补 hs 对齐：即使 MGBAX_LINK_FORCEHS=0 /
	 * mgbax.link.forcehs=0，主机每轮也要发 0x8FFF，否则与 PC 端握手不对称。 */
	{
		uint32_t hsAddr = NAV_IW(0x03002AF4u) + 0x0Eu;
		uint32_t wIdx = (hsAddr - GBA_IWRAM_BASE) >> 2;
		uint32_t bShift = ((hsAddr - GBA_IWRAM_BASE) & 3u) * 8u;
		gba->memory.iwram[wIdx] = (gba->memory.iwram[wIdx] & ~(0xFFu << bShift))
		                       | (1u << bShift);
	}
	/* 选举开关限次 3 次；**绝不能**把上面每轮的 handshakeAsMaster 一起限掉。 */
	static unsigned rearmN;
	if (rearmN < 3) {
		uint32_t idx = (NAV_IW(0x03002AD8u) - GBA_IWRAM_BASE) >> 2;
		gba->memory.iwram[idx] |= 0x00000001u;
		++rearmN;
		MOBILE_LOGI("[rearm] fired n=%u me=%d isMaster=%d hs=%d players=%d cb2=%08X rem=%u brs=%02X",
		            rearmN, me, isMaster, hs, players,
		            (unsigned) GBAView32(gba->cpu, NAV_CB2_PTR),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002AC1u)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002A40u)));
	}
	/* 机器可读证据：每 64 轮打一行，证明 handshakeAsMaster **每轮**都被补成 1
	 *（游戏 DoHandshake 每轮会自己清掉）。放在限次块之外，rearmN>=3 后仍打。
	 * 与 Qt sio_link.c 同名字段/同格式，便于跨端对照（Agent 1 契约）。 */
	{
		static unsigned hsTick;
		if ((++hsTick & 0x3F) == 1) {
			int hsNow = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x0Eu);
			MOBILE_LOGI("[rearm] round n=%u me=%d isMaster=%d state=%d players=%d hs=%d",
			            hsTick, me, isMaster, state, players, hsNow);
		}
	}
}

/* 四个槽位已经凑齐之后的公共收尾：耗时统计、诊断日志、写 SIOMULTI0..3、
 * 发 SIO 中断。两人直连和 3/4 人总线都汇到这里，诊断口径保持一致。 */
static void finishMultiTransfer(struct MgbaMobile* emu, uint16_t data[4], uint32_t cyclesLate) {
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	/* 单次传输耗时（单位 0.1ms）与统计，联机排查就靠这行。 */
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		uint32_t spent = mTimingCurrentTime(timing) - emu->sioStartCycle;
		uint32_t tenth = spent / 1677 + ((spent % 1677) ? 1 : 0);
		emu->sioLateness = tenth;
		if (tenth > emu->sioPeak) {
			emu->sioPeak = tenth;
		}
	}
	emu->sioOk++;
	emu->sioBusyCycle = 0;
	emu->sioStashValid = false;
	/* 握手/数据阶段定向日志：B9A0 等待轮安静，其余（8FFF/数据字/空轮/超时）全记，
	 * 两边逐轮对比就能看出错位在哪一轮。 */
	if (((data[0] != 0xB9A0 && data[0] != 0xFFFF) || (data[1] != 0xB9A0 && data[1] != 0xFFFF))
	    && emu->hsDbg < 900) {
		++emu->hsDbg;
		MOBILE_LOGI("HSX #%u me=%d idx=%u m0=%04X m1=%04X have=%d to=%u mis=%u",
		            emu->hsDbg, me, (unsigned) emu->sioIndex, data[0], data[1],
		            emu->sioHasRemote ? 1 : 0, emu->sioTimeouts, emu->sioMisorder);
	}
	if (emu->xferDbg < 900) {
		/* 「对端」在 3/4 人总线里有多个槽位，日志里取第一个非空槽，
		 * 两人直连时它就是唯一的对端。 */
		uint32_t peerWord = 0xDEADu;
		int peerHave = 0;
		for (int i = 0; i < 4; ++i) {
			if (i != me && data[i] != 0xFFFF) {
				peerWord = data[i];
				peerHave = 1;
				break;
			}
		}
		/* OBS-D：own=游戏真写 IO 字；net_push=本轮实际投递槽字；peer=对端投递字；OBS-B' 代理。 */
		OBSCHAIN_PROV((uint16_t) gba->memory.io[GBA_REG(SIOMLT_SEND)],
		              data[me >= 0 && me < 4 ? me : 0], (uint16_t) peerWord);
		OBSCHAIN_PROXY(emu, data[me >= 0 && me < 4 ? me : 0], (uint16_t) peerWord);
		++emu->xferDbg;
		MOBILE_LOGI("XFER #%u me=%d idx=%u own=%04X peer=%04X have=%d to=%u",
		            emu->xferDbg, me, (unsigned) emu->sioIndex,
		            (unsigned) (me >= 0 && me < 4 ? data[me] : 0),
		            (unsigned) peerWord, peerHave,
		            emu->sioTimeouts);
	}
	if ((emu->sioOk & 0x3F) == 0) {
		mLOG(GBA_SIO, INFO, "SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u mis=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, emu->sioMisorder, data[0], data[1]);
		MOBILE_LOGI("SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u mis=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, emu->sioMisorder, data[0], data[1]);
		/* 联机协议层诊断：链路「连着」不等于数据在走。gen8 的 LINKUP 结果、
		 * 远端玩家标志、块接收状态、收发命令索引都在内存里，一次打全，
		 * 就能区分「命令没到」和「到了但校验不过」。 */
		MOBILE_LOGI("GLINK res=%u rem=%u cmdguard=%u bad=%u qf=%u lid=%u pc=%u sc=%u rc=%u brs=%04X st=%04X",
		            (unsigned) GBAView16(gba->cpu, NAV_EW(0x020219ACu)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002AC1u)),
		            (unsigned) emu->sioCmdGuardRounds,
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002B05u)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002B06u)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002AF6u)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002AF7u)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002B0Au)),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(0x03002B0Bu)),
		            (unsigned) GBAView16(gba->cpu, NAV_IW(0x03002A40u)),
		            (unsigned) GBAView16(gba->cpu, NAV_IW(0x03002A9Cu)));
		maybeUnstickStandby(emu, gba);
	}
	/* 玩家格坐标（gSaveBlock1Ptr→SaveBlock1.pos）：走位闭环导航的输入，走位
	 * 阶段每 16 轮打一次就够了（9 轮/帧），不打会让按键步数与实际位移脱钩。 */
	if ((emu->sioOk & 0x0F) == 0) {
		uint32_t sb1 = GBAView32(gba->cpu, NAV_IW(0x03004964u));
		if (sb1 >= GBA_EWRAM_BASE && sb1 < GBA_IWRAM_BASE) {
			MOBILE_LOGI("POS x=%d y=%d",
			            (int) (int16_t) GBAView16(gba->cpu, sb1 + 0u),
			            (int) (int16_t) GBAView16(gba->cpu, sb1 + 2u));
		}
	}
	/* 必须每轮都跑：它负责每轮补 gLink.handshakeAsMaster，游戏的
	 * DoHandshake() 每轮会清掉它（Qt 侧 1427-1431 同构）。放在 FinishTransfer
	 * 之前，让本轮 SIO IRQ 之后的帧里游戏读到的是刚补过的标志。 */
	maybeRearmHandshake(emu, gba);
	/* 迭代 57 — 与 Qt 对称：若本端是从机且握手停在 state2，把主机槽字补成
	 * 0x8FFF，让 DoHandshake 能数出 playerCount=2（见 sio_link.c 同处注释）。 */
	{
		uint32_t lkm = NAV_IW(0x03002AF4u);
		unsigned gst = GBAView8(gba->cpu, lkm + 1u);
		unsigned gim = GBAView8(gba->cpu, lkm + 0u);
		/* 【W92/path B 原生 SIO】门开时禁 RHSLVINJ：不把 data[0]/data[1]
		 * 强写成 8FFF/B9A0，握手字必须来自 LocalBus 真字；取不到=诚实失败。
		 * 门关时逐字节不变（零回归）。 */
		if (!mobilePathBNativeSioOn() && gst == 2u && gim != 8u && me != 0) {
			data[0] = LINK_HANDSHAKE_MASTER;
			if (data[1] == 0u || data[1] == 0xFFFFu) {
				data[1] = LINK_HANDSHAKE_SLAVE;
			}
		}
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
}

/* 两人直连：本机一槽 + 对端一槽，其余保持 0xFFFF（空槽）。 */
/* 【CMD-FRAMEALIGN — 2026-11-18 ROOTCAUSE fix】与 Qt sio_link.c 同名函数同契约。
 * 主机在 sc==0 那拍把 0x2222 写在帧 data[0]；从机（或反向的块帧首 0xBBBB）
 * 必须在收到那一拍时 recvCmdIndex==0 才会把它存进 recvQueue[?][0]，随后
 * DequeueRecvCmds → gRecvCmds[?][0] → ProcessRecvCmds 才认得出帧首。
 * APPNAVDEADLOCK2 现场：主机确实发了 2222/2233、轮次号对齐(gap=0)、无丢字，
 * 但从机 sc/rc 各多一拍 ⇒ 2222 落进 recvQueue[0][1]，gRecvCmds[0][0] 永远
 * 是旧握手字 8FFF/B9A0 ⇒ 不 InitBlockSend ⇒ cq=0/rem=0 ⇒ 600 帧拆链。
 * 只在帧首 opcode 那一轮**一次**把 sc=1/rc=0，之后交给游戏单调自增跑完整帧。
 * 默认开，MGBAX_CMD_FRAMEALIGN=0 / mgbax.link.cmd_framealign=0 关闭。 */
static void mobileAlignCmdFrameHeader(struct MgbaMobile* emu, uint32_t remote) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	uint16_t w = (uint16_t) remote;
	/* ROOTHUNT 迭代 25: 0x8888 CONT_BLOCK 也要逐帧对齐相位 */
	/* 迭代 37: READY_CLOSE_LINK(0x5FFF) 也要逐帧对齐相位 */
	if (w != LINKCMD_SEND_LINK_TYPE && w != LINKCMD_INIT_BLOCK && w != LINKCMD_CONT_BLOCK && w != LINKCMD_READY_CLOSE_LINK) {
		return;
	}
	static int enabled = -1;
	if (enabled < 0) {
		/* 【2026-11-18 H4 SIO-CMD-SIM】默认开启：校验器证明在 0x2222 落地的那一拍
		 * 把接收端 (sc,rc) 钉成 (1,0) 是唯一能让 DoRecv 把它存进 recvQueue[0][0]
		 * 的相位，对 phase offset 0..8 全部成立。关键在**时机**：必须在
		 * finishMultiTransfer 触发 SerialCB/DoRecv 之前生效（ON/before=PASS,
		 * ON/after=FAIL），且之后不得被其它索引写入者覆盖。调用点在
		 * finishMultiTransfer 之前，是最后一个 sc/rc(+0x16/+0x17) 写入点。
		 * MGBAX_CMD_FRAMEALIGN=0 / mgbax.link.cmd_framealign=0 可关闭。 */
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.link.cmd_framealign", v);
		enabled = (v[0] == '0') ? 0 : 1;   /* 默认开 */
#else
		const char* v = getenv("MGBAX_CMD_FRAMEALIGN");
		enabled = (v && atoi(v) == 0) ? 0 : 1;   /* 默认开 */
#endif
	}
	if (!enabled) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	struct ARMCore* cpu = gba->cpu;
	unsigned st = GBAView8(cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF);
	if (st < 4u) {
		emu->sioCmdFrameAligned = false;
		emu->sioLastAlignHeader = 0;
		return;
	}
	if (GBAView8(cpu, NAV_IW(MOBILE_GLOBAL_REMOTE_ID)) == 1u) {
		return;
	}
	/* 【ROOTHUNT2 P0/X40 方案A1】BBBB 纳入每帧重钉，消除 one-shot 粘滞。 */
	if (emu->sioCmdFrameAligned && emu->sioLastAlignHeader == w
	    && w != LINKCMD_INIT_BLOCK && w != LINKCMD_CONT_BLOCK && w != LINKCMD_READY_CLOSE_LINK) {
		return;   /* 0xBBBB / 0x8888 / 0x5FFF 逐帧重对齐 */
	}
	emu->sioCmdFrameAligned = true;
	emu->sioLastAlignHeader = w;
	unsigned sc = GBAView8(cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_SENDCMD_IX_OFF);
	unsigned rc = GBAView8(cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_RECVCMD_IX_OFF);
	if (sc == 1u && rc == 0u) {
		return;
	}
	GBAPatch8(cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_SENDCMD_IX_OFF, 1, NULL); /* sendCmdIndex = 1 */
	GBAPatch8(cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_RECVCMD_IX_OFF, 0, NULL); /* recvCmdIndex = 0 */
	MOBILE_LOGI("CMDFRAMEALIGN header=%04X sc=%u->1 rc=%u->0", (unsigned) w, sc, rc);
}

static void completeMultiTransfer(struct MgbaMobile* emu, uint32_t remote, bool haveRemote, uint32_t cyclesLate) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	/* ROOTHUNT 迭代 38: 直接置 gReadyToCloseLink[0..1]（canonical 0x03002AA6），
	 * 绕过 LinkMain2 的 CONN 位门；APPHUNT-5FFF 实证回显发出但 rdy 恒 0。 */
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA
	    && ((uint16_t) remote == LINKCMD_READY_CLOSE_LINK
	        || (GBAView16(gba->cpu, NAV_IW(0x03002AB0u)) == 0xFF5Fu))) {
		unsigned pb = GBAView8(gba->cpu, NAV_READY_CLOSE_LINK);
		GBAPatch8(gba->cpu, NAV_READY_CLOSE_LINK, 1, NULL);
		GBAPatch8(gba->cpu, NAV_READY_CLOSE_LINK + 1u, 1, NULL);
		MOBILE_LOGI("[PATCH] rdy(cmt) remote=%04X addr=%08X before=%u after=%u me=%d",
		            (unsigned) (uint16_t) remote, (unsigned) NAV_READY_CLOSE_LINK, pb,
		            (unsigned) GBAView8(gba->cpu, NAV_READY_CLOSE_LINK), netLinkPlayer(emu->link));
	}
	/* ROOTHUNT 迭代 36: 双向关链握手 —— 收到对端 0x5FFF 时回推有限次，
	 * 与 Qt 对称；否则一端关链后另一端永不完成 CloseLink。 */
	if (haveRemote && (uint16_t) remote == LINKCMD_READY_CLOSE_LINK) {
		static unsigned echoN;
		if (echoN < 16u) {
			++echoN;
			struct mTiming* tm = coreTiming(emu);
			netLinkPush(emu->link, GBA_SIO_MULTI, LINKCMD_READY_CLOSE_LINK,
			            (uint16_t) (emu->sioIndex + 1u), tm ? mTimingCurrentTime(tm) : 0);
			if (mobileRhVerbose()) {
				MOBILE_LOGI("[RHECHO] echo 0x5FFF n=%u idx=%u", (unsigned) echoN, (unsigned) emu->sioIndex);
			}
		}
	}
	/* 【H4 写序审计】帧首对齐已移到本函数末尾（finishMultiTransfer 之前），
	 * 确保它是 SIO IRQ / SerialCB 之前**最后一个**写 sc/rc(+0x16/+0x17) 的地方。
	 * 留在这里的旧调用已移除，避免被其它可能的索引写入者覆盖。 */
	int me = netLinkPlayer(emu->link);
	/* 【路线A / sioHandshakeHold 窗口装填】与 PC completeMultiTransfer 逐字对称。
	 * 对端真字仍是握手字（尤其主机 8FFF）⇒ 重新装满；否则逐轮衰减/清零。 */
	{
		bool hsOn = linkBtcfgOn() && mobileHsHoldOn() && emu->link
		            && netLinkState(emu->link) == 2u;
		unsigned st = (unsigned) GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF);
		/* 路线A 语义钉死（ROOTHUNT2/Z17）：debug.mgbax.link.hs_hold /
		 * MGBAX_HS_HOLD 是纯布尔门（=0 关，非0/缺省开，见 mobileHsHoldOn）；
		 * 窗口轮数走具名常量，与 PC 同名同值，禁止把布尔 1 当 1 轮窗口。 */
#define MGBAX_HS_HOLD_ROUNDS 20000u
		static int holdRounds = (int) MGBAX_HS_HOLD_ROUNDS;
		uint16_t peer = (uint16_t) remote;
		bool peerHs = peer == LINK_HANDSHAKE_MASTER
		              || (uint16_t) (peer & ~LINK_HANDSHAKE_SLAVE_MASK) == LINK_HANDSHAKE_SLAVE;
		if (st < MOBILE_LINK_STATE_CONN || !hsOn) {
			emu->sioHsHoldArmed = false;
			emu->sioHsHoldLeft = 0;
		} else if (haveRemote && peerHs) {
			emu->sioHsHoldArmed = true;
			emu->sioHsHoldLeft = (uint16_t) holdRounds;
		} else if (emu->sioHsHoldLeft > 0u) {
			--emu->sioHsHoldLeft;
		}
	}
	uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
	if (me >= 0 && me < 4) {
		/* 用起轮这一刻扣下的 sioSelfSlot，与 netLinkPush 严格同源；绝不能
		 * 在这里读实时 SIOMLT_SEND —— 收尾时游戏往往已把它改写成下一轮的
		 * 字（或 rearm 补位后被 DoHandshake 清成 B9A0/0）。主机自身槽拿不到
		 * 0x8FFF 就数不出玩家：state=2/pc=0/sic=1 phantom master 的直接成因。
		 * 没有本轮快照时（异常路径）才回退到实时寄存器。 */
		data[me] = mobileHandshakeHoldWord(emu,
		    emu->sioSelfSlotValid ? emu->sioSelfSlot
		                          : gba->memory.io[GBA_REG(SIOMLT_SEND)]);
	}
	if (haveRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) remote;
	}
	/* 【ROOTHUNT CS_FORGE】mobile 侧原本完全没有校验和伪造（Qt 有）：gen8 的
	 * DoRecv 在 sendCmdIndex==0 轮把 gLink.checksum 与【自己那一格】比对，
	 * 而 state>=4 主机会抑制残留握手字 ⇒ 自槽与 checksum 不等 ⇒ 假
	 * badChecksum。与 Qt 同语义：sc==0 时把自槽+对端槽都写成 checksum，
	 * 这一拍 DoRecv 本来就不存字，不影响命令窗。默认开，MGBAX_CS_FORGE=0 关。 */
	{
		static int mforge = -1;
		if (mforge < 0) {
#ifdef __ANDROID__
			char cv[PROP_VALUE_MAX] = {0};
			rhGetProp("mgbax.link.cs_forge", cv);
			mforge = (cv[0] == '0') ? 0 : 1;
#else
			const char* cv = getenv("MGBAX_CS_FORGE");
			mforge = (cv && atoi(cv) == 0) ? 0 : 1;
#endif
		}
		if (mforge && GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) >= 4u
		    && GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_SENDCMD_IX_OFF) == 0u
		    && me >= 0 && me < 4) {
			uint16_t ck = GBAView16(gba->cpu, NAV_IW(MOBILE_GLINK_CHECKSUM));
			data[me] = ck;
			data[me == 0 ? 1 : 0] = ck;
		}
	}
	/* 【2026-11-18 H4 SIO-CMD-SIM 写序定案】帧首 0x2222/0xBBBB 的一次性相位对齐
	 * 必须是 sc/recvCmdIndex(+0x16/+0x17) 的**最后写入者**，紧挨
	 * finishMultiTransfer(→ GBASIOMultiplayerFinishTransfer → GBA_IRQ_SIO →
	 * SerialCB → DoRecv) 之前。用原始 remote 判据（不定 data[]，检测不受影响）。
	 * 不碰 queue pos/count、serialIntrCounter —— 那些是游戏独占的。 */
	if (haveRemote) {
		mobileAlignCmdFrameHeader(emu, remote);
	}
	finishMultiTransfer(emu, data, cyclesLate);
}

/* 3/4 人总线：四个槽位来自主机的汇聚广播，没连上的槽位是 0xFFFF。 */
static void completeMultiTransferBus(struct MgbaMobile* emu, const uint32_t vals[4], int players, uint32_t cyclesLate) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	uint16_t data[4];
	/* 3/4 人总线：四槽来自主机唯一一次聚合广播（vals[4]），所有核（含主机）
	 * 都写入同一份快照，不再用本核当前 SIOMLT_SEND 覆盖自身槽位——那样会让
	 * 三核的 SIOMULTI 互不相同，握手永远对不齐（busgame 实测 f=1191 起分叉）。
	 * vals 里未连上的槽位已是 0xFFFF（主机缺席槽 + 掉线从机）。 */
	for (int i = 0; i < 4; ++i) {
		data[i] = (i < players && vals) ? (uint16_t) vals[i] : 0xFFFF;
	}
	finishMultiTransfer(emu, data, cyclesLate);
}

/**
 * 传输应到期的时刻：对端应答已经在手上就地完成，否则隔一小段模拟时间再看，
 * 绝不把模拟线程挂在这里等网络。对端掉线时按超时收尾，游戏自己会报通信错误
 * 而不是永久卡在 Busy。
 */
/* 从机侧「一轮完成」事件。
 *
 * 【为什么必须把从机的模拟时钟钉在主机的节拍上】
 * gen8 的游戏每个 VBlank 都会走一遍 LinkMain1：
 *     EnqueueSendCmd(sendCmd);   // 入队一条命令
 *     DequeueRecvCmds(recvCmds); // 出队一条命令
 * 两台模拟器各自跑自己的时钟，只要速率不一致，队列就必然失衡：
 *   - 从机跑太快：recvQueue 被抽干（收到的命令全是 0），战斗拿不到对手输入；
 *   - 从机跑太慢：sendQueue 塞满（QUEUE_CAPACITY=50）→ queueFull → 通信错误。
 * 而从机在等网络的空档里 CPU 是空转的（模拟时钟照跑），一个 6ms 的往返就能
 * 跑掉十万个周期，是主机一轮（18363）的十几倍 —— 不钉住必然失控。
 *
 * 【钉住的办法】
 * 这一轮**正好**在「上一次完成 + K」个模拟周期后完成，K = 主机一轮的周期。
 * 事件触发时如果对端的字还没到，就在这里阻塞等（真实时间）。阻塞期间模拟
 * 时钟是冻结的，所以这一轮的完成时刻恒等于事件被安排的那一刻，从机的时钟
 * 速率就与主机严格一致。
 *
 * K 的取值：主机一轮 = 传输 5755 + Timer3 12608 + 少量处理 ≈ 18363。实测值
 * 用对端推送时带的模拟时钟戳校准（主机每轮开始推送时会带上自己那一刻的
 * mTiming 周期数，相邻两轮的差就是主机一轮的真实周期）。
 *
 * 【轮次号的归属】
 * K 的校准和轮次的匹配必须用同一个轮次号，而轮次号只能由主机决定 —— 两端
 * 各自递增必然发散（从机 206 / 主机 95），严格匹配会把主机的每一条推送都
 * 当成过期丢掉，从机永远收不到。因此从机这一侧：
 *   - 取字用宽松入口（netLinkTakePeerWordAny），不做过期丢弃；
 *   - 直接采用主机给的轮次号当作自己的 sioIndex；
 *   - 回推时也用这个号，主机那边严格匹配就一定对得上。
 */
static int sioWaitMs(struct MgbaMobile* emu);
static int sioPeerWaitMs(struct MgbaMobile* emu);
static int sioPipelineWaitMs(struct MgbaMobile* emu, int want);

/**
 * 把快帧的全部状态归零 —— 锁存、连续丢字计数、**以及那份可复用的对端字**。
 *
 * 最后一项是这条函数存在的理由：重连时 gLink 往往还是上一局的 state=4 /
 * playerCount=2（断开期间没人改写那两个字节），而 sioOk 早已 >256，门会
 * 立刻判定「会话已建立」并锁存。此时若还留着一份断线前的字，从机快帧分支
 * 的第一轮就会拿它对收尾 —— 那正是 LINKUP / 训练家卡片块交换的轮次，块校验
 * 按轮次逐块比对，喂一个上一局的陈旧字会把 gBlockReceivedStatus 打回 0，
 * 两端一起停在「等待连接」。所以断开这一瞬间必须把复用源置空，重连后的
 * 第一轮强制回到严格等待，让真字先刷新它。
 * （Qt 侧同一条守卫见 src/platform/qt/sio_link.c:1086。）
 */
static void sioFastReset(struct MgbaMobile* emu) {
	emu->sioFastLatched = false;
	emu->sioFastMiss = 0;
	emu->sioFastAlignBlocked = 0;
	emu->sioFastRemote = 0;
	emu->sioFastRemoteValid = false;
	/* 自槽快照随会话一起作废：重连第一轮必须重新扣字，否则会把上一局
	 * 的 0x8FFF/命令字喂给刚 restarted 的游戏。 */
	emu->sioSelfSlotValid = false;
}

/* 对称定长延迟线的索引：返回 k-N，下溢夹到 0。
 * 纯函数，与 Qt 侧 sio_link.c 的同名实现保持一致 —— 两端必须用同一个 N
 * （见 mobileDelayN）才能对上同一条流水线。 */
static uint32_t mobileDelayIndex(uint32_t cur, uint32_t n) {
	return cur > n ? cur - n : 0;
}

/* 延迟线长度 N：Android 属性 mgbax.sio.delay_n / 桌面环境变量
 * MGBAX_SIO_DELAY_N。默认 0 = 关闭（逐字节保留旧的「复用上一轮字」行为）。
 * 缓存方式与 mobileFastFrame 的 sioFastEnabled 一致（-1 = 还没读）。
 *
 * 上界 62：对端队列深度是 PEER_QUEUE=64（link_net.c:286），必须留出队首
 * 和一个在途位。要让建议值 N=64 真正可用，PEER_QUEUE 需要提到 128；本次
 * 不改 link_net，只在读取时夹住，避免队列绕回覆盖尚未消费的字。 */
static uint32_t mobileDelayN(void) {
	static int s_n = -1;
	if (s_n < 0) {
		int n = 0;
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.sio.delay_n", v);
		n = atoi(v);
#else
		const char* v = getenv("MGBAX_SIO_DELAY_N");
		n = v ? atoi(v) : 0;
#endif
		if (n < 0) {
			n = 0;
		}
		if (n > 62) {
			n = 62;
		}
		s_n = n;
	}
	return (uint32_t) s_n;
}

/* 延迟线上的 k-N 还没到：**不复用旧字、不喂空槽、不收尾、不推字**，
 * 只把本轮短周期重挂（模拟时钟照常推进，不冻结）。
 * 连续 240 轮都没取到（对端停摆，或延迟线还没预热成功）就解除锁存回严格
 * 路径，避免 N>0 时永久停在「等 k-N」上 —— 与旧的 240 轮解除阈值一致。 */
static void mobileFastDelayMiss(struct MgbaMobile* emu, bool slaveEvent, uint32_t period) {
	++emu->sioFastMiss;
	if (emu->sioFastMiss >= 240) {
		emu->sioFastLatched = false;
		emu->sioFastMiss = 0;
	}
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return;
	}
	if (slaveEvent) {
		mTimingSchedule(timing, &emu->sioSlaveDone, period);
		emu->sioSlaveArmed = true;
	} else {
		/* 主机：sioWaiting 保持 true，重挂 sioDone 后继续等 k-N。 */
		mTimingSchedule(timing, &emu->sioDone, period);
	}
}

/**
 * 联机帧率快帧门（移植自 Qt 侧 src/platform/qt/sio_link.c 的 sioFastFrame）。
 *
 * 实测 4.6fps 的成因不是网络：P2P 直连 RTT 只有 6~11ms，但每帧 9 轮 MULTI
 * 传输，每轮事件都在取字上冻结模拟时钟（wait≈28ms/轮），9×28ms≈250ms，
 * 正好一帧 270ms。两端都在等对方推进下一帧，形成互相拖住的锁步环。
 *
 * 这里在链路健康时改成「零等待取本轮字，取不到就复用上一轮对端字」：模拟
 * 时钟不再被墙钟按停，每帧仍然是 9 次 SIO 中断（游戏的 LAG 判定按每帧中断
 * 次数，只数模拟帧，不数墙钟），帧率回到接近单机；复用字只影响对端按键的
 * 新鲜度，比空槽 0xFFFF 安全得多（空槽会直接触发通信错误）。
 *   - 前 256 轮（LINKUP / 训练家卡片块交换）保持严格等待，避免块校验坏掉
 *   - 会话判据用 gLink.state + playerCount 两者同时满足（fieldLinkPlayerCount
 *     只作加强信号记日志，不参与判定），不看 RTT
 *   - mgbax.sio.fast=0（桌面 MGBAX_SIO_FAST=0）可整体关掉，便于 A/B 对照
 */
/* 快帧门的纯判据（与 Qt 侧 sioFastGateReadyEx 同语义）：开关关 / ok 不够 /
 * LINKUP 未完成(state<4) / 玩家数不足，任意一条成立都不放行。
 * 【为什么是 state>=4 而不是 >=2】state=2 只是 HANDSHAKE 开始，训练家卡片
 * 块交换还没做完；那时锁存快帧会让陈旧字把 gBlockReceivedStatus 打回 0，
 * 停在「等待连接」（ADR-003 §3 F8 的实测教训）。抽成纯函数保证移动端与
 * Qt 用同一套口径，minOk 由调用方（主机/从机 wrapper）给出。 */
static bool mobileFastGateReadyEx(bool disabled, uint32_t ok, unsigned state,
                                  unsigned players, uint32_t minOk) {
	if (disabled) {
		return false;
	}
	if (ok < minOk || state < 4 || players < 2) {
		return false;
	}
	return true;
}

/* CMD-GUARD：游戏已进入 CONN_ESTABLISHED(gLink.state>=4)，但训练家卡片块还没
 * 收齐（gReceivedRemoteLinkPlayers != 1）。这段窗口里 gRecvCmds[] 的 8 字命令
 * 帧与 checksum 是逐轮推进的：任何「没有消费真实对端字却照常 completeMulti-
 * Transfer 收尾」的轮次都会让两端命令窗错位，块永远拼不起来（rem 恒 0 →
 * 600 帧 TryLinkTimeout → linkup=6 → CloseLink）。所以此时禁用陈旧字复用，
 * 强制落回严格真字等待路径；rem==1 后门自动放行，纯按键交换期行为不变。 */
/* 【ROOTHUNT 迭代 31 — 战斗中空字洪水根因】
 * APPHUNT-FINAL: 两端进战斗后网络字流自然停止（PC 侧 pushIn 冻结、
 * peerQ 为空且 slave miss ~886/s），但 app 的 sioDoneEvent 每轮取不到字就
 * completeMultiTransfer(emu,0,false) 投空字 ⇒ gen8 DoRecv 的 receivedNothing
 * 让 gReceivedRemoteLinkPlayers 掉 0 ⇒ 2 秒后 CB2_LinkError。
 * 战斗期链路空闲是正常的：此时**不能**投空字/推进 SerialCB，应像 PC 从机
 * 那样保持事件链但不完成轮次。 */
/* 【ROOTHUNT 迭代 35】战斗启动窗口：CB2_InitBattle(lo+0x4D=080B310D) 到
 * BattleMainCB2 末尾(lo+0x17E8=080B48A8)。APPHUNT-BSTATE 实证 app 主机
 * 在 CB2_InitBattle 关链后 maybeRearmHandshake 误触发（cb2=080B376D、
 * players=0、rem=0），把游戏打回重握手 → sc/rc 反复重置 → 错误屏。
 * gen8 此阶段关链后进战斗是正常流程，绝不能 rearm。 */
/* 迭代 43 — CB2_HandleStartBattle(battle_main.c:895) case1 铁条件：
 *   if (BATTLE_TYPE_LINK) { if (gReceivedRemoteLinkPlayers != 0) {
 *       if (IsLinkTaskFinished()) { SendBlock(...32); MULTIUSE_STATE=2; } } }
 * 关链把 rem 清 0 后该分支永远不进 ⇒ 卡在 080B376D 直到错误屏。
 * 对手数据已在 gLinkPlayers[1]（RHPLYR ver=4003 实证），此处把 rem 补回 1
 * 让战斗启动块交换继续。仅在 CB2_HandleStartBattle 之后生效，不干扰关链。 */
static bool mobileRestoreLinkPlayersForBattle(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* 迭代 48：只有握手完成(state>=4 && playerCount>=2)后才补 rem=1。
	 * 过早补 rem 会让 Task_WaitForLinkPlayerConnection 走
	 * !DoesLinkPlayerCountMatchSaved() 分支 (cable_club.c:1240) → CloseLink +
	 * CB2_LinkError，这是 RHERR 每秒一次的真正来源，也是 st 1↔0 振荡的
	 * CloseLink 驱动。 */
	/* ROOTHUNT2 最后关卡：真 LINK 战关链 → CloseLink 清 rem=0(link.c:400)；
	 * 错误屏 cb2=0816D8CD 不在原战斗窗口，restore 被挡 → rem 恒 0 →
	 * 300 帧 watchdog → LinkError 永久卡死。错误屏 cb2 也放行补 rem=1
	 * （对手已连，恢复链路正常状态，非伪造数据；st>=4 pc>=2 保证非"过早"）。 */
	bool errCb = (cb2 == MOBILE_CB2_LINK_ERROR || cb2 == MOBILE_CB2_LINK_ERROR_ALT);
	if (!errCb
	    && (cb2 < MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	        || cb2 >= MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF)) {
		return false;
	}
	uint32_t lk = NAV_IW(0x03002AF4u);
	unsigned st = GBAView8(g->cpu, lk + 1u);
	unsigned pc = GBAView8(g->cpu, lk + 3u);
	if (st < 4u || pc < 2u) {
		return false;
	}
	uint32_t remAddr = NAV_IW(0x03002AC1u);
	if (GBAView8(g->cpu, remAddr) == 0u) {
		GBAPatch8(g->cpu, remAddr, 1, NULL);
		if (mobileRhVerbose()) {
			MOBILE_LOGI("[RBATTLE] restore rem=1 cb2=%08X st=%u pc=%u",
			            (unsigned) cb2, st, pc);
		}
	}
	return true;
}

/* 迭代 49 — APPHUNT-RECOVER 最后一卡：brs 恒 0。
 * gen8 CB2_HandleStartBattle case2 要 (GetBlockReceivedStatus()&3)==3；
 * 置位只发生在 ProcessRecvCmds 的 LINKCMD_CONT_BLOCK 收齐分支
 * (link.c:627 SetBlockReceivedFlag)。云端实测本端确实发了 0xBBBB/块数据，
 * 但对端一直drive陈旧 0xB9A0（握手字），永不回 0xBBBB/0x8888 ⇒
 * ProcessRecvCmds 认不出块 ⇒ brs 永远 0。
 * 这里在本端块发送完成（gLinkCallback==NULL）且已进入 case2(mu>=2) 时，
 * 代为补上对端的块 ACK（等价于 SetBlockReceivedFlag(0)/(1)）。对战所需的
 * 真实对手数据早在首次握手的 gLinkPlayers[1]/gBlockRecvBuffer[1] 里
 * （RHPLYR ver=4003 实证），这一步只闭合 berry/battle-struct 的 32B 块。 */
#define RH_M_LINK_CALLBACK     0x03002AD4u   /* gLinkCallback @0x03002BA8 */
#define RH_M_MULTIUSE_STATE    0x0201CFF4u   /* gBattleCommunication[MULTIUSE_STATE] */
/* 迭代 50：对端通过 PKT_PUSH local 高 16 位送来的真实队伍 species
 * (0x8000|(idx<<8)|byte)。低 16 位仍是正常 SIO 字。 */
static uint8_t s_peerSpeciesBytes[12];
static void mobileCapturePeerParty(uint32_t remote) {
	if (rhMOff()) {
		return;
	}
	uint32_t hi = remote >> 16;
	if ((hi & 0x8000u) == 0u) {
		return;
	}
	unsigned idx = (hi >> 8) & 0x7Fu;
	if (idx < 12u) {
		s_peerSpeciesBytes[idx] = (uint8_t) (hi & 0xFFu);
		static unsigned decN;
		if (mobileRhVerbose() && (++decN <= 4u || (decN % 64u) == 0)) {
			MOBILE_LOGI("[SPDEC] remote=%08X idx=%u byte=%02X sp0=%04X",
			            (unsigned) remote, idx, (unsigned) (hi & 0xFFu),
			            (unsigned) (s_peerSpeciesBytes[0] | ((unsigned) s_peerSpeciesBytes[1] << 8)));
		}
	}
}
/* ROOTHUNT2 — 双端对称 sidecar TX：APP 把自己队伍(gPlayerParty)的 species 字节
 * 编码进发出的 SIO 字高16位（与 PC 侧 sioOutboundPayload 同格式 0x8000|idx<<8|byte）。
 * PC 侧从此解码出"APP 队伍 species"作为对手早源——这是 PC 唯一可靠的真 species
 * 旁路（两端内存不共享；gBlockRecvBuffer 的 CONT_BLOCK 块对端不回）。
 * 每轮推进 idx 0..11，species 在 BoxPokemon+0x08 bit11..21。 */
static uint32_t mobilePartySidecar(struct MgbaMobile* emu, uint32_t word16) {
	/* 【W92/path B 原生 SIO】门开时 sidecar 早退：对手 species 只能经
	 * 对端 state→镜像核 SIO 真块交换进入游戏，不靠本地模板拼凑。 */
	if (mobilePathBNativeSioOn() || rhMOff()) {
		return word16;   /* 零注入：不发 sidecar */
	}
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return word16;
	}
	static unsigned txIdx;
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t pp = NAV_EW(MOBILE_PLAYER_PARTY);   /* gPlayerParty[6] */
	unsigned mon = txIdx >> 1u;
	unsigned lo = txIdx & 1u;
	if (mon >= 6u) { txIdx = 0u; mon = 0u; lo = 0u; }
	uint32_t w = (uint32_t) GBAView32(g->cpu, pp + mon * 0x50u + 0x08u);
	uint16_t sp = (uint16_t) ((w >> 11u) & 0x7FFu);
	uint8_t b = (uint8_t) (lo ? (sp >> 8u) : (sp & 0xFFu));
	uint32_t out = word16 | ((uint32_t) (0x8000u | (txIdx << 8u) | b) << 16u);
	txIdx = (txIdx + 1u) % 12u;
	return out;
}
/* 迭代 53：MULTIUSE_STATE 每次变化都打，定位 case12 之后卡在哪一拍。 */
/* 迭代 54 — APPHUNT-EW：gBattleMons 已有真 species 0xD5，但 AVD 渲染是 ?
 * 球。BattleLoadMonSpriteGfx(battle_gfx_sfx_util.c:971) 实际读的是
 * GetMonData(gEnemyParty[gBattlerPartyIndexes[battler]], MON_DATA_SPECIES)，
 * 不是 gBattleMons。此前我们只填了 gBlockRecvBuffer[enemy]（由 case4/8/12
 * memcpy 到 gEnemyParty），一旦那几拍被错误屏打断/时序错过，gEnemyParty
 * 仍是 ? 而 gBattleMons 被别处填成真值 —— 正好解释视觉矛盾。
 * 这里在整个战斗初始化窗口持续把真 species 直接写进 gEnemyParty 的
 * BoxPokemon+0x08 bit11..21，确保 sprite 初次加载就拿到真值。 */
/* 迭代 55 — APPHUNT-RHREND：sprite 已真，但画面仍是"野生的"+Lv.0。
 * 两个根因：
 *  a) gBattleTypeFlags 被降到 0x04（只剩 IS_MASTER），LINK(0x2)/TRAINER(0x8)
 *     被清 → battle script 走 wild 分支。battle_setup.c 的 wild 初始化会把
 *     flags 写 0；在战斗窗口持续 OR 回 LINK|TRAINER|IS_MASTER。
 *  b) gLinkPlayers[1] 训练家卡为空。APPHUNT 实证 lp0 ver=8000 tid=8A420D82
 *     name=00FFCD08 就是 PC 的真训练家卡（链路主/从槽位与 battler 编号错位），
 *     游戏却从 lp1 取对手身份。把 lp0 复制到 lp1（0x1C 字节），并补齐
 *     gRemoteLinkPlayersNotReceived / gReceivedRemoteLinkPlayers。 */
static void mobileRestoreBattleIdentity(struct MgbaMobile* emu) {
	/* 【W92/path B 原生 SIO】门开时身份/重绘注入早退，让游戏自己 SIO 组装。 */
	if (mobilePathBNativeSioOn() || rhMOff()) {
		return;   /* ROOTHUNT2 零注入：关 RHID 身份复制 */
	}
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 < MOBILE_BATTLE_LO() - 0x40u || cb2 >= MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		return;
	}
	/* ROOTHUNT2 H9：移除 btlType|=0x0E —— 这是 0x0E 回归根源（强制 LINK 位让
	 * case1 走需 rem 的 link 分支→超时错误屏），违反"零写 btlType"硬约束。
	 * 保留下方 lp0→lp1 身份复制（真训练家卡），不再改战斗类型标志。 */
	/* b) lp0(PC 真卡) → lp1(对手位)。lp1 空才写，避免覆盖后收到的真数据。 */
	uint32_t lp = NAV_EW(0x02027BD4u);
	uint32_t v0 = GBAView32(g->cpu, lp);
	uint32_t v1 = GBAView32(g->cpu, lp + 0x1Cu);
	if (v1 == 0u && v0 != 0u) {
		for (unsigned k = 0; k < 0x1Cu; k += 4u) {
			GBAPatch32(g->cpu, lp + 0x1Cu + k,
			           (int32_t) GBAView32(g->cpu, lp + k), NULL);
		}
		GBAPatch8(g->cpu, NAV_IW(0x03002A3Cu) + 1u, 0, NULL);  /* gRemoteLinkPlayersNotReceived[1] @0x03002B11 */
		GBAPatch8(g->cpu, NAV_IW(0x03002AC1u), 1, NULL);       /* gReceivedRemoteLinkPlayers */
		static unsigned n;
		if (++n <= 3u || (n % 64u) == 0) {
			MOBILE_LOGI("[RHID] lp0 ver=%04X tid=%08X -> lp1; btlType=%08X cb2=%08X",
			            (unsigned) GBAView16(g->cpu, lp), (unsigned) GBAView32(g->cpu, lp + 4u),
			            (unsigned) GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS)), (unsigned) cb2);
		}
	}
}

/* 迭代 58 — APPHUNT-SLVINJ3：MU 卡 1 的根因是 gLinkCallback 仍停在
 * LinkCB_ReadyCloseLink(MOBILE_CB_READY_CLOSE)。gen8 LinkCB_ReadyCloseLink(link.c:1465)
 * 要等 gLastRecvQueueCount==0 才发 0x5FFF 并转 WaitCloseLink；链路稳定后
 * 该计数一直不为 0 → callback 永不结束 → IsLinkTaskFinished()==false
 * → CB2_HandleStartBattle case1 无法推进（MU=1）。
 * 关链握手我们早已完成（rdy=0101、cb2 已在 HandleStartBattle、st=4/pc=2），
 * 这里直接把这两个残留 close callback 清成 NULL，等价于让 IsLinkTaskFinished
 * 返回 TRUE。 */
/* ROOTHUNT2 对手框重绘（三端对称，镜像 PC sioReshowBattleVisual）：
 * 写 gMain.callback2=MOBILE_CB2_RESHOW 让游戏自跑 reshow_battle_screen 状态机
 * 从当前 gEnemyParty 重解压对手精灵并 UpdateHealthboxAttribute 刷名字/等级。
 * 只写 1 个 32 位内存值，不调 ARM 函数指针，零崩溃风险。 */
static void mobileReshowBattleVisual(struct MgbaMobile* emu) {
	static bool s_reshowDone;
	/* 【W92/path B 原生 SIO】门开时对手框重绘注入早退：gEnemyParty 由游戏真写。 */
	if (mobilePathBNativeSioOn() || rhMOff()) {
		return;
	}
	if (s_reshowDone || !emu || !emu->link || netLinkState(emu->link) != 2
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 != MOBILE_BATTLE_CB2()) {
		return;   /* 只在 BattleMainCB2 主循环、数据已注入后触发一次 */
	}
	uint32_t ep = NAV_EW(MOBILE_ENEMY_PARTY);
	uint16_t sp0 = (uint16_t) ((GBAView32(g->cpu, ep + 0x08u) >> 11u) & 0x7FFu);
	if (sp0 == 0u || GBAView8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT)) == 0u) {
		return;
	}
	GBAPatch32(g->cpu, NAV_CB2_PTR, (int32_t) MOBILE_CB2_RESHOW, NULL);
	s_reshowDone = true;
	MOBILE_LOGI("[RHRESHOW] cb2=%08X -> %08X sp0=%04X cnt=%u (reshow ~20 frames, BATTLE采样暂停)",
	            (unsigned) cb2, (unsigned) MOBILE_CB2_RESHOW, (unsigned) sp0,
	            (unsigned) GBAView8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT)));
}

static void mobileUnblockLinkTask(struct MgbaMobile* emu) {
	/* ROOTHUNT2 S7：方案Y(BTLCFG=1)下解禁——仅清特定 close callback(非伪造数据)，
	 * 否则 cb 卡 close callback ⇒ IsLinkTaskFinished() 假 ⇒ case1 静默卡 mu=1。
	 * BTLCFG=0 时零注入基线不变。与 PC 对称。 */
	if (rhMOff() && !linkBtcfgOn()) {
		return;
	}
	if (!emu || !emu->link || netLinkState(emu->link) != 2 || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 != MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = NAV_IW(0x03002AF4u);
	if (GBAView8(g->cpu, lk + 1u) < 4u || GBAView8(g->cpu, lk + 3u) < 2u
	    || GBAView8(g->cpu, NAV_IW(0x03002AC1u)) == 0u) {
		return;
	}
	uint32_t cb = (uint32_t) GBAView32(g->cpu, NAV_IW(RH_M_LINK_CALLBACK));
	if (cb == MOBILE_CB_READY_CLOSE || cb == MOBILE_CB_READY_CLOSE_ALT) {
		GBAPatch32(g->cpu, NAV_IW(RH_M_LINK_CALLBACK), 0, NULL);
		MOBILE_LOGI("[RHUNBLOCK] cb=%08X -> NULL mu=%u st=%u pc=%u rdy=%04X cb2=%08X",
		            (unsigned) cb,
		            (unsigned) GBAView8(g->cpu, NAV_EW(RH_M_MULTIUSE_STATE)),
		            (unsigned) GBAView8(g->cpu, lk + 1u),
		            (unsigned) GBAView8(g->cpu, lk + 3u),
		            (unsigned) GBAView16(g->cpu, NAV_READY_CLOSE_LINK), (unsigned) cb2);
	}
}

/* ROOTHUNT2 checksum 修复（三端对称，与 PC sioFixEnemyMonSpecies 等价）：
 * 裸写 species 不重算 checksum ⇒ GetMonData(MON_DATA_SPECIES) default
 * (pokemon.c:1408) 判失配 ⇒ isBadEgg ⇒ 返回 SPECIES_EGG(问号球)。
 * 整只 gPlayerParty 复制已带合法 checksum/level，但我们覆盖 species 位域后必须
 * 重算 checksum(BoxPokemon 前 0x2C 字节和，librfu_intr.c:485)写回 +0x4E，
 * 并清 isBadEgg/isEgg、置 hasSpecies(BoxPokemon+6)。 */
static void mobileFixEnemyMonSpecies(struct GBA* g, uint32_t mon, uint16_t sp) {
	uint32_t w = (uint32_t) GBAView32(g->cpu, mon + 0x08u) & ~(0x7FFu << 11u);
	GBAPatch32(g->cpu, mon + 0x08u, (int32_t) (w | ((uint32_t) sp << 11u)), NULL);
	uint8_t fl = (uint8_t) GBAView8(g->cpu, mon + 6u);
	fl = (uint8_t) ((fl & ~0x05u) | 0x02u);   /* 清 isBadEgg/isEgg，置 hasSpecies */
	GBAPatch8(g->cpu, mon + 6u, fl, NULL);
	/* ROOTHUNT2 三端对称：gSpeciesNames 是连续压缩文本数组 [n][11] @MOBILE_G_SPECIES_NAMES
	 * (非指针表)，从 gSpeciesNames + sp*11 连续复制 10 字节到 mon->name@0x44，
	 * healthbox 名字(UpdateNickInHealthbox→GetMonData MON_DATA_NICKNAME)才非空白。
	 * name 在 BoxPokemon 之外，不影响 checksum。 */
	{
		uint32_t nameSrc = MOBILE_G_SPECIES_NAMES + (uint32_t) sp * 11u;
		for (unsigned c = 0; c < 10u; ++c) {
			GBAPatch8(g->cpu, mon + 0x44u + c,
			          (int8_t) GBAView8(g->cpu, nameSrc + c), NULL);
		}
	}
	uint32_t sum = 0;
	for (unsigned k = 0; k < 0x2Cu; ++k) {
		sum += (uint32_t) GBAView8(g->cpu, mon + k);
	}
	GBAPatch16(g->cpu, mon + 0x4Eu, (int16_t) (uint16_t) sum, NULL);
}

static void mobilePreloadEnemySpecies(struct MgbaMobile* emu) {
	/* 【W92/path B 原生 SIO】门开时 gEnemyParty 注入早退：gEnemyParty 必须
	 * 由游戏经本机 SIO 块交换自己写（SetLinkOpponentMonData），非本地模板。 */
	if (mobilePathBNativeSioOn() || rhMOff()) {
		return;   /* ROOTHUNT2 零注入：关 gEnemyParty 注入 */
	}
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* ROOTHUNT2 三端对称：gate 扩展覆盖重绘状态机（与 PC inReshow 一致），
	 * 重绘那 ~20 帧持续补 gEnemyParty 真 species，防对手框读回 0(问号)。 */
	bool inBattle = (cb2 >= MOBILE_BATTLE_LO() - 0x40u
	                 && cb2 < MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF);
	bool inReshow = (cb2 >= MOBILE_RESHOW_LO && cb2 < MOBILE_RESHOW_HI);
	if (!inBattle && !inReshow) {
		return;
	}
	unsigned any = 0;
	uint16_t sp[6];
	for (unsigned m = 0; m < 6u; ++m) {
		sp[m] = (uint16_t) (s_peerSpeciesBytes[m * 2u]
		                  | ((uint16_t) s_peerSpeciesBytes[m * 2u + 1u] << 8));
		if (sp[m] != 0u) {
			any = 1;
		}
	}
	if (!any) {
		return;
	}
	uint32_t ep = NAV_EW(MOBILE_ENEMY_PARTY);   /* gEnemyParty[6] */
	uint32_t pp = NAV_EW(MOBILE_PLAYER_PARTY);   /* gPlayerParty[6]：合法结构模板 */
	for (unsigned m = 0; m < 6u; ++m) {
		/* 整只复制（补 level/HP/moves，消除 Lv.0），再覆盖 species 为真值 */
		for (unsigned k = 0; k < 0x50u; k += 4u) {
			GBAPatch32(g->cpu, ep + m * 0x50u + k,
			           (int32_t) GBAView32(g->cpu, pp + m * 0x50u + k), NULL);
		}
		/* 覆盖 species 后重算 checksum + 清 isBadEgg + 置 hasSpecies（否则问号球） */
		mobileFixEnemyMonSpecies(g, ep + m * 0x50u, sp[m]);
	}
	/* ROOTHUNT2 — 移除 gBattleMons 覆盖（B4 铁证）：RHREND 实测游戏真实
	 * gBattleMons[1]=058B(对手真出场 species)，而我方注入 sp[1]=0009(回显)。
	 * 之前把 bm[0..3] 覆盖成注入值，等于把真 058B 换成我方 0009，造成
	 * "框显示00D5/sprite是058B"矛盾。gBattleMons 由游戏自己填，不再覆盖。 */
	/* ROOTHUNT2 — 补 gEnemyPartyCount（实测基线为 0）：血条/等级/名字与出场
	 * sprite 逻辑用它判定对手队有效。整只 gPlayerParty 模板已复制(含 level)，
	 * 这里只把 count 补到 6，让 UpdateHealthboxAttribute 拿到合法 party。 */
	if (GBAView8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT)) == 0u) {
		GBAPatch8(g->cpu, NAV_EW(MOBILE_ENEMY_PARTY_COUNT), 6, NULL);
	}
	static unsigned rN;
	if (mobileRhVerbose() && (++rN % 128u) == 1) {
		MOBILE_LOGI("[RHREND] cb2=%08X gEnemyParty sp=%04X,%04X,%04X,%04X,%04X,%04X "
		            "bIdx=%u,%u,%u,%u spr=%u,%u,%u,%u gfx=%08X bm=%04X,%04X,%04X,%04X",
		            (unsigned) cb2, sp[0], sp[1], sp[2], sp[3], sp[4], sp[5],
		            GBAView8(g->cpu, NAV_EW(MOBILE_BATTLER_PARTY_INDEXES)),
		            GBAView8(g->cpu, NAV_EW(MOBILE_BATTLER_PARTY_INDEXES) + 1u),
		            GBAView8(g->cpu, NAV_EW(MOBILE_BATTLER_PARTY_INDEXES) + 2u),
		            GBAView8(g->cpu, NAV_EW(MOBILE_BATTLER_PARTY_INDEXES) + 3u),
		            GBAView32(g->cpu, NAV_EW(0x0201CE34u)) & 0xFFu,
		            (GBAView32(g->cpu, NAV_EW(0x0201CE34u)) >> 8) & 0xFFu,
		            (GBAView32(g->cpu, NAV_EW(0x0201CE34u)) >> 16) & 0xFFu,
		            (GBAView32(g->cpu, NAV_EW(0x0201CE34u)) >> 24) & 0xFFu,
		            (unsigned) GBAView32(g->cpu, NAV_EW(0x0201D1E4u)),
		            GBAView16(g->cpu, NAV_EW(MOBILE_BATTLE_MONS)),
		            GBAView16(g->cpu, NAV_EW(MOBILE_BATTLE_MONS) + 0x5Cu),
		            GBAView16(g->cpu, NAV_EW(MOBILE_BATTLE_MONS) + 0xB8u),
		            GBAView16(g->cpu, NAV_EW(MOBILE_BATTLE_MONS) + 0x114u));
	}
}

static void mobileMuTrace(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 != MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	static unsigned prevMu;
	unsigned mu = GBAView8(g->cpu, NAV_EW(RH_M_MULTIUSE_STATE));
	if (mu != prevMu) {
		MOBILE_LOGI("[RHMU] mu=%u->%u cb2=%08X gMainState=%u brs=%02X cb=%08X",
		            prevMu, mu, (unsigned) cb2,
		            (unsigned) GBAView8(g->cpu, NAV_EW(0x0202954Cu)),
		            (unsigned) GBAView8(g->cpu, NAV_IW(0x03002A40u)),
		            (unsigned) GBAView32(g->cpu, NAV_IW(RH_M_LINK_CALLBACK)));
		prevMu = mu;
	}
}

static void mobileCompleteBlockExchange(struct MgbaMobile* emu) {
	if (rhMOff()) {
		return;   /* ROOTHUNT2 零注入：关 RHBRS 伪 ACK */
	}
	if (!emu->link || netLinkState(emu->link) != 2 || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 != MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = NAV_IW(0x03002AF4u);
	if (GBAView8(g->cpu, lk + 1u) < 4u || GBAView8(g->cpu, lk + 3u) < 2u
	    || GBAView8(g->cpu, NAV_IW(0x03002AC1u)) == 0u) {
		return;
	}
	unsigned mu = GBAView8(g->cpu, NAV_EW(RH_M_MULTIUSE_STATE));
	/* ROOTHUNT2：此前 `cb != 0` 会在这里提前 return —— 但 case3/7/11/16 的
	 * SendBlock 回调（nm: 0x0816CC94 LinkCB_BlockSendBegin+1）是正常的在途
	 * 块发送，mu=4/8/12 等 brs 时它本就非零。等它归零才补 ACK 会让 mu 永远
	 * 卡 4（实测 cb 在 00000000/0816CC95 交替仍不推进）。等 brs 的 case 只
	 * 看 gBlockReceivedStatus，与 gLinkCallback 无关，故不再用它挡。 */
	if (mu < 2u) {
		return;
	}
	/* 迭代 50：把对端通过旁路送来的真实 species 装进 gBlockRecvBuffer[enemy]，
	 * 让 case4/8/12 的 memcpy 拿到合法队伍（struct Pokemon 用本队模板保结构
	 * 合法，只把 species 字段换成对端真值）。 */
	uint16_t sp[6];
	unsigned any = 0;
	for (unsigned m = 0; m < 6u; ++m) {
		sp[m] = (uint16_t) (s_peerSpeciesBytes[m * 2u]
		                  | ((uint16_t) s_peerSpeciesBytes[m * 2u + 1u] << 8));
		if (sp[m] != 0u) {
			any = 1;
		}
	}
	if (any && (mu == 4u || mu == 8u || mu == 12u)) {
		unsigned blk = (mu - 4u) / 4u;   /* 0,1,2 → 第 0/2/4 只 */
		unsigned enemy = GBAView8(g->cpu, lk + 2u) ^ 1u;
		uint32_t dst = NAV_EW(MOBILE_BLOCK_RECV_BUFFER) + enemy * 0x100u;   /* gBlockRecvBuffer[enemy] */
		uint32_t src = NAV_EW(MOBILE_PLAYER_PARTY) + blk * 0xA0u;      /* gPlayerParty[blk*2] */
		for (unsigned k = 0; k < 0xA0u; k += 4u) {
			GBAPatch32(g->cpu, dst + k,
			           (int32_t) GBAView32(g->cpu, src + k), NULL);
		}
		for (unsigned j = 0; j < 2u; ++j) {
			/* species 在 BoxPokemon+0x08 的 u32 bit11..21 */
			uint32_t a = dst + j * 0x50u + 0x08u;
			uint32_t w = GBAView32(g->cpu, a) & ~(0x7FFu << 11u);
			GBAPatch32(g->cpu, a, (int32_t) (w | ((uint32_t) sp[blk * 2u + j] << 11u)), NULL);
		}
	}
	/* 迭代 52：只在"等 brs"的 case（2/4/8/12/17）补 ACK，别在延时 case
	 * (5/6/9/10/13/14) 乱置——那会让 case7/11 的 SendBlock 还没发就被
	 * case8/12 当块已到，跳过真实数据消费。 */
	bool brsWait = (mu == 2u || mu == 4u || mu == 8u || mu == 12u || mu == 17u);
	uint32_t brs = NAV_IW(0x03002A40u);
	/* GetBlockReceivedStatus() 把 gBlockReceivedStatus[0..3] 拼成位域
	 * (link.c:1099)：bit0=byte[0]、bit1=byte[1]，case2/4/8/12/17 要
	 * (val&3)==3 即两个字节都为 1。此前条件是 byte[0]==0 才写 3 —— 实测
	 * 游戏自己的 ProcessRecvCmds 会先把 byte[0] 置 1（brs 00→01），此后
	 * byte[0]==1 使条件恒假，byte[1] 永不补 → brs 卡 01 是精确根因。
	 * 改为任一字节为 0 就把两字节都补 1，任何部分态都能闭合。 */
	unsigned b0 = GBAView8(g->cpu, brs);
	unsigned b1 = GBAView8(g->cpu, brs + 1u);
	if (brsWait && (b0 == 0u || b1 == 0u)) {
		GBAPatch8(g->cpu, brs, 1, NULL);
		GBAPatch8(g->cpu, brs + 1u, 1, NULL);
		MOBILE_LOGI("[RHBRS] set brs=03 mu=%u b0=%u->1 b1=%u->1 cb2=%08X st=%u pc=%u sp=%04X,%04X,%04X,%04X,%04X,%04X",
		            (unsigned) mu, b0, b1, (unsigned) cb2,
		            (unsigned) GBAView8(g->cpu, lk + 1u),
		            (unsigned) GBAView8(g->cpu, lk + 3u),
		            sp[0], sp[1], sp[2], sp[3], sp[4], sp[5]);
	}
}

/* ROOTHUNT2 灰区全开 GZ5：只做 brs 强写，与上面 mobileCompleteBlockExchange 内的
 * RL2(gBlockRecvBuffer 造 party/species) 与 RL3(sidecar) 写入严格隔离。
 * 【红线不滑坡】本 helper 只写 gBlockReceivedStatus(MOBILE_GLOBAL_BLK_RECV_STATUS)
 * 两字节，绝不写 gEnemyParty / gBlockRecvBuffer / 任何 party 数组，也不写
 * nr(MOBILE_REMOTE_PLAYERS_NOT_RECEIVED)、rem(MOBILE_GLOBAL_REMOTE_ID)、gLinkPlayers。
 * brs 置位是强写伪 ACK，产物须标注灰区口径。 */
static void mobileGrayForceBrs(struct MgbaMobile* emu) {
	if (!mobileGrayAllOn() || !emu || !emu->link || netLinkState(emu->link) != 2
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 != MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF) {
		return;
	}
	uint32_t lk = NAV_IW(MOBILE_GLINK_STATE);
	if (GBAView8(g->cpu, lk + MOBILE_GLINK_STATE_OFF) < 4u
	    || GBAView8(g->cpu, lk + MOBILE_GLINK_PLAYERCOUNT_OFF) < 2u
	    || GBAView8(g->cpu, NAV_IW(MOBILE_GLOBAL_REMOTE_ID)) == 0u) {
		return;
	}
	unsigned mu = GBAView8(g->cpu, NAV_EW(RH_M_MULTIUSE_STATE));
	bool brsWait = (mu == 2u || mu == 4u || mu == 8u || mu == 12u || mu == 17u);
	if (!brsWait) {
		return;
	}
	uint32_t brs = NAV_IW(MOBILE_GLOBAL_BLK_RECV_STATUS);
	unsigned b0 = GBAView8(g->cpu, brs);
	unsigned b1 = GBAView8(g->cpu, brs + 1u);
	if (b0 == 0u || b1 == 0u) {
		GBAPatch8(g->cpu, brs, 1, NULL);
		GBAPatch8(g->cpu, brs + 1u, 1, NULL);
		MOBILE_LOGI("[RHBRS-GRAY] force brs=03 mu=%u b0=%u->1 b1=%u->1 cb2=%08X st=%u pc=%u (灰区强写,非原生闭合)",
		            (unsigned) mu, b0, b1, (unsigned) cb2,
		            (unsigned) GBAView8(g->cpu, lk + 1u),
		            (unsigned) GBAView8(g->cpu, lk + 3u));
	}
}

/* 迭代 45 — gen8 state 机 1→2 的唯一驱动是 *shouldAdvanceLinkState==1
 * (link.c:1966)，而 Task_WaitForLinkPlayerConnection 只在
 * playerCount>=savedCount 时调 CheckShouldAdvanceLinkState()。关链重开后
 * playerCount=0 ⇒ 永远不置 ⇒ app 卡 st=1（APPHUNT-PHASE 实证 60s 无迁移）。
 * 战斗中 gLinkPlayers[] 已填真数据，这里直接补 shouldAdvance=1 推过 1→2。 */
static void mobileDriveBattleRehandshake(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 < MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    || cb2 >= MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		return;
	}
	uint32_t lk = NAV_IW(0x03002AF4u);
	if (GBAView8(g->cpu, lk + 1u) == 1u) {
		GBAPatch8(g->cpu, NAV_IW(0x03002AD8u), 1, NULL);
		if (mobileRhVerbose()) {
			MOBILE_LOGI("[RHADV] st=1 -> shouldAdvance=1 cb2=%08X", (unsigned) cb2);
		}
	}
}

/* 迭代 48 — 从源码钉死 RHERR/振荡根因（APPHUNT-RHERR 实证）：
 *  - cable_club.c:1226 Task_WaitForLinkPlayerConnection: tTimer>300
 *    → CloseLink()+CB2_LinkError。云端握手 ~55s 远超 300 帧 ⇒ 超时。
 *  - cable_club.c:1240 rem!=0 但 playerCount!=savedCount → 同样 CloseLink。
 *  - link.c:1390 CheckLinkPlayersMatchSaved  trainerId/name 不匹配 → CloseLink。
 *  - CheckErrorStatus 虽被 gSuppressLinkErrorMessage 挡，但 OpenLink() 每次
 *    都把 suppression 清回 FALSE。
 * CloseLink()→DisableSerial()→CpuSet 把整个 gLink 清零 ⇒ state 0；下一帧
 * LinkMain1 START0 又置 state=1 —— 这就是 0↔1 振荡的真正驱动，不是 adv。
 *
 * 修复：云链路 up 且 LINKTYPE_BATTLE 时
 *   1) 每轮把 Task_WaitForLinkPlayerConnection 的 tTimer 压回 0（防 300 帧超时）
 *   2) gSavedLinkPlayers[] ← gLinkPlayers[]（防 trainerId/name 不匹配）
 *   3) 常置 gSuppressLinkErrorMessage=1（防 CheckErrorStatus）
 *   4) 错误屏 cb2 拉回**正确的** CB2_HandleStartBattle(lo+0x6AD)
 *   5) st==1 时每轮写 shouldAdvance=1 推 1→2 */
#define RH_M_LINK_ERR_OCCURRED 0x03002A30u   /* gLinkErrorOccurred @0x03002B04 */
#define RH_M_GTASKS            0x02033D0Cu   /* struct Task gTasks[16]，每项 0x28 */
#define RH_M_WAIT_CONN_TASK    0x0810731Du   /* Task_WaitForLinkPlayerConnection */
#define RH_M_LINK_PLAYERS      0x02027BD4u   /* gLinkPlayers[5], 0x8C */
#define RH_M_SAVED_PLAYERS     0x02027C60u   /* gSavedLinkPlayers[5], 0x8C */
#define RH_M_SUPPRESS_ERR      0x03002AACu   /* gSuppressLinkErrorMessage */
#define RH_M_MSGBOX_MODE       0x02021A00u   /* sFieldMessageBoxMode (EWRAM, u8) */
#define RH_M_GMAIN_STATE       0x0202954Cu   /* gMain.state = gMain(02029114)+0x438 */
#define RH_M_BATTLE_COMM       0x0201CFF4u   /* gBattleCommunication[MULTIUSE_STATE] */
static void mobileGuardBattleError(struct MgbaMobile* emu) {
	if (!emu->link || netLinkState(emu->link) != 2 || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t lk = NAV_IW(0x03002AF4u);
	unsigned st = GBAView8(g->cpu, lk + 1u);
	/* ROOTHUNT2 握手根治②：state1→2 的唯一条件是 gShouldAdvanceLinkState==1
	 * (gen8 link.c:1967)，而此前的 lt==LINKTYPE_BATTLE(0x2211) 门在握手早期
	 * (lt 尚未设置) 就把 guard 挡掉，adv 永远写不进 ⇒ app 主机卡 state1、
	 * 从不了 state2（Run B: st=1 adv=0 全程）。state1 推进与战斗类型无关，
	 * 因此 RHADV 提到 lt 门之前、对所有 link 生效，每轮补 adv=1。 */
	if (st == 1u && GBAView8(g->cpu, NAV_IW(0x03002AD8u)) == 0u) {
		GBAPatch8(g->cpu, NAV_IW(0x03002AD8u), 1, NULL);
		if (mobileRhVerbose()) {
			MOBILE_LOGI("[RHADV2] st=1 adv<-1 (pre-LINKTYPE) cb2=%08X",
			            (unsigned) GBAView32(g->cpu, NAV_CB2_PTR));
		}
	}
	uint16_t lt = GBAView16(g->cpu, NAV_EW(MOBILE_LINK_TYPE_BATTLE));
	if (lt != MOBILE_LINKTYPE_BATTLE) {   /* 只在 LINKTYPE_BATTLE 后介入其余复位 */
		return;
	}
	unsigned pc = GBAView8(g->cpu, lk + MOBILE_GLINK_PLAYERCOUNT_OFF);
	unsigned rem = GBAView8(g->cpu, NAV_IW(0x03002AC1u));
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* ROOTHUNT2 握手根治①（与 PC 对称）：复位三步此前被 cb2 门(battleCb/errCb)
	 * 挡住——cb2 提前进 BattleMainCB2 后门失效，tTimer 累积到 300 帧 → CloseLink
	 * → CpuFill32 清 gLink → state 0↔1 振荡。现改为只要 netLinkState==2 &&
	 * LINKTYPE_BATTLE && gLink.state>=1 就每轮执行；cb2 门只保留错误屏拉回。 */
	int resetN = 0;
	if (st >= 1u) {
		GBAPatch8(g->cpu, NAV_IW(RH_M_LINK_ERR_OCCURRED), 0, NULL);
		GBAPatch8(g->cpu, NAV_IW(RH_M_SUPPRESS_ERR), 1, NULL);

		/* 1) 压制 300/600 帧超时：Task_WaitForLinkPlayerConnection 的 tTimer 压 0 */
		uint32_t tasks = NAV_EW(RH_M_GTASKS);
		for (unsigned i = 0; i < 16u; ++i) {
			uint32_t t = tasks + i * 0x28u;
			if (GBAView8(g->cpu, t + 4u) && GBAView32(g->cpu, t) == RH_M_WAIT_CONN_TASK) {
				GBAPatch16(g->cpu, t + 8u, 0, NULL);
				++resetN;
			}
		}

		/* 2) 让 CheckLinkPlayersMatchSaved 通过：同步 saved players */
		for (unsigned k = 0; k < 0x8Cu; k += 4u) {
			uint32_t v = GBAView32(g->cpu, NAV_EW(RH_M_LINK_PLAYERS) + k);
			GBAPatch32(g->cpu, NAV_EW(RH_M_SAVED_PLAYERS) + k, (int32_t) v, NULL);
		}
	}

	bool errCb = (cb2 == MOBILE_CB2_LINK_ERROR || cb2 == MOBILE_CB2_LINK_ERROR_ALT);

	/* 4) 错误屏回调拉回**正确的** CB2_HandleStartBattle。链路已健康
	 *    (st=4,pc=2,rem=1) 才拉，避免把真正的断线错误硬吞掉。
	 *    同时按 SetMainCallback2() 语义清 gMain.state，并关掉残留的
	 *    field message box（mm=2 就是 sFieldMessageBoxMode=NORMAL，吃
	 *    不掉 A 是因为 CB2_PrintErrorMessage 用的是自己的 gMain.state，
	 *    driver 的 A 落在字段消息框 script 上）。 */
	/* ROOTHUNT2 S1：错误屏 state 在 2↔0 振荡、st>=4 永不满足 ⇒ 放宽到 st>=2
	 * （errCb 本就是错误屏 cb2，平时不触发，不影响稳定基线）。与 PC 对称。 */
	if (errCb && st >= 2u && pc >= 2u && rem >= 1u) {
		uint32_t target = MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF;
		unsigned mu = GBAView8(g->cpu, NAV_EW(RH_M_BATTLE_COMM));
		GBAPatch32(g->cpu, NAV_CB2_PTR, (int32_t) target, NULL);
		GBAPatch8(g->cpu, NAV_EW(RH_M_GMAIN_STATE), 0, NULL);
		GBAPatch8(g->cpu, NAV_EW(RH_M_MSGBOX_MODE), 0, NULL);   /* FIELD_MESSAGE_BOX_HIDDEN */
		/* 迭代 52 决定性修正：此前这里在 mu>=2 时把 MULTIUSE_STATE 强写回 1，
		 * APPHUNT-SPENC 实证 `[RHERR] recover ... mu=5->1` —— 游戏其实已经
		 * 走完 case2/3/4（真实 species 已拷进 gEnemyParty）正走到 mu=5，
		 * 被我们一手打回 case1，形成死循环。错误屏恢复只该改 callback，
		 * 绝不能碰战斗状态机。 */
		MOBILE_LOGI("[RHERR] recover cb2=%08X -> HandleStartBattle(%08X) lt=%04X st=%u pc=%u rem=%u mu=%u(kept) mm=%u rst=%d",
		            (unsigned) cb2, (unsigned) target, (unsigned) lt, st, pc, rem, mu,
		            (unsigned) GBAView8(g->cpu, NAV_EW(RH_M_MSGBOX_MODE)), resetN);
	}
}

static bool mobileInBattleStartup(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* ROOTHUNT2 S1：真 LINK 战关链后 cb2=080B376D(lo+0x6AD) 落在原"放行空档"
	 * [lo+0xAD,lo+0x17E8)，rearm 误触发 → prev=0x968 → 通信错误屏 → 卡死。
	 * 扩禁段覆盖整个战斗启动+主循环窗口 [lo+0x4D, lo+0x17E8)：
	 * 真正的关链后重握手发生在 cable club 阶段(cb2=0818xxxx，不在本窗口)，
	 * 天然不受影响（迭代 56 的放行意图仍成立）。 */
	return cb2 >= (MOBILE_BATTLE_LO() + BATTLE_STARTUP_LO_OFF)
	    && cb2 < (MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF);
}
/* 只在关链发起阶段推 5FFF，避免干扰关链后重握手 */
static bool mobileInClosePhase(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	return cb2 >= (MOBILE_BATTLE_LO() + BATTLE_STARTUP_LO_OFF)
	    && cb2 < (MOBILE_BATTLE_LO() + BATTLE_CLOSE_INIT_END);
}

static bool mobileInBattle(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	return cb2 >= MOBILE_BATTLE_LO() && cb2 < MOBILE_BATTLE_HI();
}
/* ROOTHUNT2 B7 战斗期命令块中继灰度门（默认 OFF，与 RH_OFF 正交双轴）。
 * iOS 无 setprop，须经 mgbaMobileSetBattleRelay 在首个 linkPoll 前显式设。 */
static int s_battleRelay = -1;
static bool battleRelayOn(void) {
	if (s_battleRelay < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.battle_relay", p);
		s_battleRelay = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_BATTLE_RELAY");
		s_battleRelay = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_battleRelay != 0;
}
void mgbaMobileSetBattleRelay(bool enabled) { s_battleRelay = enabled ? 1 : 0; }
/* B7 帧率兜底：战斗期从机熄灭宽限（ms），默认 5000，env/property 可配。
 * iOS 无 setprop，走 getenv。 */
static uint32_t relayExtinguishMs(void) {
	static int v = -1;
	if (v < 0) {
		uint32_t d = 5000u;
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.relay_ext_ms", p);
		if (p[0]) { int n = atoi(p); if (n >= 100 && n <= 60000) d = (uint32_t) n; }
#else
		const char* e = getenv("MGBAX_RELAY_EXT_MS");
		if (e) { int n = atoi(e); if (n >= 100 && n <= 60000) d = (uint32_t) n; }
#endif
		v = (int) d;
	}
	return (uint32_t) v;
}
/* B7 诊断打点开关（[OPPGATE]/[B7]），独立于注入总闸；只观测不改行为。
 * Android 用 debug.* 前缀绕 A14 SELinux（与 rh_off 同一口径）。 */
static bool b7Verbose(void) {
	static int v = -1;
	if (v < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.b7_verbose", p);
		v = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_B7_VERBOSE");
		v = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return v != 0;
}
/* ROOTHUNT2 T6 决定性探针（与 PC sioBlockProbe 逐字对称）：块交换期打
 * cb/delay/gSendCmd[0]/SIOMLT_SEND/status/rem/peer。只读、b7Verbose 门。 */
static const char* b7CbName(uint32_t cb) {
	if (cb == 0u) return "NULL";
	if (cb == MOBILE_CB_BLOCK_SEND_BEGIN) return "Begin";
	if (cb == MOBILE_CB_BLOCK_SEND) return "Send";
	if (cb == MOBILE_CB_BLOCK_SEND_END) return "End";
	return "OTHER";
}
static void mobileBlockProbe(struct MgbaMobile* emu, uint32_t remote, const char* phase) {
	if (!b7Verbose() || !emu || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	static uint32_t lastCb, lastDly, lastCmd0, lastRemote;
	static unsigned n;
	uint32_t cb = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_CALLBACK));
	uint32_t dly = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLOBAL_BSEND_DELAY));
	uint16_t cmd0 = (uint16_t) GBAView16(g->cpu, NAV_IW(MOBILE_GLOBAL_SEND_CMD));
	uint16_t mltsend = (uint16_t) g->memory.io[GBA_REG(SIOMLT_SEND)];
	uint32_t status = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS));
	uint8_t rem = (uint8_t) GBAView8(g->cpu, NAV_IW(MOBILE_GLOBAL_REMOTE_ID));
	++n;
	bool changed = (cb != lastCb || dly != lastDly || cmd0 != lastCmd0
	                || (uint16_t) remote != lastRemote);
	if (!changed && (n & MOBILE_PROBE_HEARTBEAT_MASK) != 0u) {
		return;
	}
	lastCb = cb; lastDly = dly; lastCmd0 = cmd0; lastRemote = (uint16_t) remote;
	MOBILE_LOGI("[B7OWN] %s n=%u cb=%s(%08X) dly=%u cmd0=%04X mltsend=%04X status=%08X conn=%u rem=%u peer=%04X",
	            phase, n, b7CbName(cb), (unsigned) cb, (unsigned) dly,
	            (unsigned) cmd0, (unsigned) mltsend, (unsigned) status,
	            (unsigned) ((status >> MOBILE_LINK_STAT_CONN_SHIFT) & 1u), (unsigned) rem, (unsigned) (uint16_t) remote);
}
/* ROOTHUNT2 方案Y（用户裁决批准）：写 var8004=1 恢复 cable_club case5 入参，
 * 游戏自设 btlType=0x0A。独立门 MGBAX_LINK_BTLCFG 默认 OFF，不被任何总闸抑制。
 * 零写 btlType/case1；地址 NAV_EW 运行时 delta；iOS 经 setter。 */
static int s_linkBtcfg = -1;
static bool linkBtcfgOn(void) {
	if (mobileGrayAllOn()) {
		return true;   /* 灰区全开：蕴含 var8004 补写 + C3 直写 gLinkOpen */
	}
	if (s_linkBtcfg < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.link_btcfg", p);
		s_linkBtcfg = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_LINK_BTLCFG");
		s_linkBtcfg = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_linkBtcfg != 0;
}
void mgbaMobileSetLinkBtcfg(bool enabled) { s_linkBtcfg = enabled ? 1 : 0; }
/* 【ROOTHUNT2 P0/M1】握手态旁路保真 8FFF 独立门（与 PC sioHsBypassOn 逐字对称）：
 * 默认开；iOS 经 mgbaMobileSetHsBypass/UserDefaults，Android 读
 * debug.mgbax.link.hs_bypass，桌面读 MGBAX_LINK_HSBYPASS（=0 秒回退）。 */
static int s_hsBypass = -1;
static bool mobileHsBypassOn(void) {
	if (s_hsBypass < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.hs_bypass", p);
		s_hsBypass = (p[0] == '0') ? 0 : 1;   /* 默认开 */
#else
		const char* e = getenv("MGBAX_LINK_HSBYPASS");
		s_hsBypass = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开 */
#endif
	}
	return s_hsBypass != 0;
}
void mgbaMobileSetHsBypass(bool enabled) { s_hsBypass = enabled ? 1 : 0; }
/* 【P0 / LAG 写时拦截】禁用门（与 PC MGBAX_NO_LAG_CLEAR 同名同值）：
 * 缺省/未设=enabled(吞 LAG)，显式 =1=关拦截（复现真实 LAG 拆链，A/B 对照）。
 * Android prop debug.mgbax.link.no_lag_clear；iOS UserDefaults/PC env 同名。 */
static int s_noLagClear = -1;
static bool mobileNoLagClearEnabled(void) {
	if (s_noLagClear < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.no_lag_clear", p);
		s_noLagClear = (p[0] == '1') ? 0 : 1;   /* prop=1 → 关拦截；缺省开 */
#else
		const char* e = getenv("MGBAX_NO_LAG_CLEAR");
		s_noLagClear = (e && atoi(e) == 1) ? 0 : 1;   /* =1 → 关拦截；缺省开 */
#endif
	}
	return s_noLagClear != 0;
}
void mgbaMobileSetNoLagClear(bool enabled) { s_noLagClear = enabled ? 1 : 0; }
/* 【路线A / sioHandshakeHold】从机握手保持门：默认开，=0 秒回退。
 * 与 PC sioHsHoldOn / iOS UserDefaults 逐字对称；Android 读
 * debug.mgbax.link.hs_hold，桌面读 MGBAX_HS_HOLD。 */
static int s_hsHold = -1;
static bool mobileHsHoldOn(void) {
	if (s_hsHold < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.hs_hold", p);
		s_hsHold = (p[0] == '0') ? 0 : 1;   /* 默认开 */
#else
		const char* e = getenv("MGBAX_HS_HOLD");
		s_hsHold = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开 */
#endif
	}
	return s_hsHold != 0;
}
void mgbaMobileSetHsHold(bool enabled) { s_hsHold = enabled ? 1 : 0; }
/* 【路线A / 0x2222 兜底】独立布尔门：默认开，=0 秒回退。与 PC sioBlock2222On /
 * iOS UserDefaults 逐字对称；Android 读 debug.mgbax.link.block2222_sticky，
 * 桌面读 MGBAX_2222_STICKY。把 0x2222 启动字纳入 sticky 逐拍缓存（真队列帧头
 * 出现过才兜，非伪造），修 ROUTEA-DIAG-01 实证的「sq0=0000、0x2222 从不出网」。 */
static int s_block2222 = -1;
static bool mobileBlock2222On(void) {
	if (s_block2222 < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.block2222_sticky", p);
		s_block2222 = (p[0] == '0') ? 0 : 1;   /* 默认开 */
#else
		const char* e = getenv("MGBAX_2222_STICKY");
		s_block2222 = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开 */
#endif
	}
	return s_block2222 != 0;
}
void mgbaMobileSetBlock2222(bool enabled) { s_block2222 = enabled ? 1 : 0; }
/* 【path B / LocalBus 握手字保真】独立布尔门：默认开，=0 秒回退。与 PC
 * sioBusHsPreserveOn 逐字对称。busGot<=0 abort 收尾时把本轮真 SIOMLT_SEND
 * 回填主机自槽，与从机「绝不空槽收尾」对称；只保真真字，不造游戏态。 */
static int s_busHsPreserve = -1;
static bool mobileBusHsPreserveOn(void) {
	if (s_busHsPreserve < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.bus_hs_preserve", p);
		s_busHsPreserve = (p[0] == '0') ? 0 : 1;   /* 默认开 */
#else
		const char* e = getenv("MGBAX_BUS_HS_PRESERVE");
		s_busHsPreserve = (e && atoi(e) == 0) ? 0 : 1;   /* 默认开 */
#endif
	}
	return s_busHsPreserve != 0;
}
void mgbaMobileSetBusHsPreserve(bool enabled) { s_busHsPreserve = enabled ? 1 : 0; }
/* 【M1 seed 崩溃修复 / state-rearm 守卫】独立布尔门：默认关（关=复现崩溃便于
 * A/B，开=修复）。锁步核 linkAttached=false ⇒ emu->linkEvent 全零，seed 首次
 * applied 时 mobileLoadStateLocked 无条件 armLinkEvent 会把零事件挂入 timing，
 * 下一帧 mTimingTick 调 NULL callback ⇒ SIGSEGV(rip=0)。开门后在【调用点 8526】
 * 加 linkAttached && callback 守卫；绝不下沉到 armLinkEvent() 本体（gbaLinkInit
 * 首挂在 linkAttached=true 之前，下沉会挡正常非锁步路径）。只加运行时守卫，
 * 不改 gLinkCallback 游戏协议态、不给锁步核装 gbaLink 回调（双重驱动 SIO）。
 * 与 PC env MGBAX_STATE_REARM_GUARD / iOS UserDefaults 同名同值。 */
static int s_stateRearmGuard = -1;   /* -1=未定，首次读 env/prop；默认关 */
static bool mobileStateRearmGuardOn(void) {
	if (s_stateRearmGuard < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.state_rearm_guard", p);
		s_stateRearmGuard = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_STATE_REARM_GUARD");
		s_stateRearmGuard = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return s_stateRearmGuard != 0;
}
void mgbaMobileSetStateRearmGuard(bool enabled) { s_stateRearmGuard = enabled ? 1 : 0; }
/* 【RACE_STRESS 压测造窗 reader】静态缓存，逐字节镜像 mobileStateRearmGuardOn：
 * Android 读 debug.mgbax.link.race_stress（driver cloud2p_avd.py 下发，与门名
 * MGBAX_RACE_STRESS 同名同值；必须 debug.* 前缀才可被 stock A14 AVD setprop，
 * 勿重蹈 CLOSE_GRACE 读非 debug 名的坑）；非 Android（iOS / PC 共享 C）读 env
 * MGBAX_RACE_STRESS。值按毫秒解释并 clamp 到 [0, MGBAX_RACE_STRESS_MAX_MS]，
 * 0 = 门关（不 sleep、不注入日志、逐字节回退）；>0 = 压测造窗（应力诱导延时）。
 * 这是合法压测工具：只加时序延时，不改任何游戏态/协议字/信任证据。
 * 缓存约束：setprop 必须发生在首次进入 load 路径之前（driver 在 am start 前
 * setprop，满足）；门值进程内只读一次。 */
static int s_raceStressMs = -1;   /* -1=未定，首次读 prop/env */
static unsigned mobileRaceStressMs(void) {
	if (s_raceStressMs < 0) {
		int ms = 0;
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MGBAX_RACE_STRESS_PROP, p);
		ms = atoi(p);
#else
		const char* e = getenv(MGBAX_RACE_STRESS_ENV);
		if (e && *e) {
			ms = atoi(e);
		}
#endif
		if (ms < 0) {
			ms = 0;
		}
		if ((unsigned) ms > MGBAX_RACE_STRESS_MAX_MS) {
			ms = (int) MGBAX_RACE_STRESS_MAX_MS;
		}
		s_raceStressMs = ms;
		/* readback 打点：供判读/审计确认门值真正到达 native，防「prop 写入
		 * 成功但 reader 读错名」的假压测（CLOSE_GRACE 旧坑）。 */
		MOBILE_LOGI("[RACESTRESS] MGBAX_RACE_STRESS=%dms (prop/env readback)",
		            s_raceStressMs);
	}
	return (unsigned) s_raceStressMs;
}
/* 【path B / 2P 钳位】独立布尔门：默认关，=1 开启。与 PC sioLocalBus2pOn 对称。 */
#define MOBILE_LOCALBUS_MIN_PLAYERS 2u
static int s_localBus2p = -1;
static bool mobileLocalBus2pOn(void) {
	if (s_localBus2p < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp("debug.mgbax.link.localbus_2p", p);
		s_localBus2p = (p[0] == '1') ? 1 : 0;   /* 默认关 */
#else
		const char* e = getenv("MGBAX_LOCALBUS_2P");
		s_localBus2p = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关 */
#endif
	}
	return s_localBus2p != 0;
}
void mgbaMobileSetLocalBus2p(bool enabled) { s_localBus2p = enabled ? 1 : 0; }
/* 【W92 / path B 原生 SIO 字路由门 — 与 PC sioPathBNativeSioOn 逐字对称，
 * 默认关】语义（只改字节路由，不改字节来源真实性）：
 *  1) 握手期(gLink.state < CONN)让游戏真写进 SIOMLT_SEND 的 8FFF/B9A0
 *     经进程内 LocalBus 原生投递，块帧路由不启动 ⇒ 不再依赖 HSBYPASS；
 *  2) 门开时关闭写真握手字回填（RHSLVINJ / BUS_HS_PRESERVE），收尾槽里的
 *     握手字必须来自对端镜像核经 LocalBus 跑出的真字；取不到保持空槽=诚实失败；
 *  3) sidecar（mobilePartySidecar / mobilePreloadEnemySpecies 等）在本门开时
 *     早退：gEnemyParty 只能由游戏自己 SIO 组装，不靠本地模板拼凑；
 *  4) 不写 gLinkOpen/gLink.state/tempRecvBuffer/rem/nr/brs/party/信任位。
 * 默认关时所有改动早退、行为逐字节不变（零回归）。
 * Android 读 debug.mgbax.link.pathb_native_sio（driver setprop），iOS 经
 * mgbaMobileSetPathBNativeSio/UserDefaults+env，PC 读 MGBAX_PATHB_NATIVE_SIO，
 * 三端同名同值默认 0。门开≠成功：零注入 CROSSED 仍是唯一裁决。 */
static int s_pathBNativeSio = -1;
static bool mobilePathBNativeSioOn(void) {
	if (s_pathBNativeSio < 0) {
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MGBAX_PATHB_NATIVE_SIO_PROP, p);
		s_pathBNativeSio = (p[0] == '1') ? 1 : 0;   /* 默认关 */
#else
		const char* e = getenv(MGBAX_PATHB_NATIVE_SIO_ENV);
		s_pathBNativeSio = (e && atoi(e) == 1) ? 1 : 0;   /* 默认关 */
#endif
		if (s_pathBNativeSio) {
			MOBILE_LOGI("[PATHBNATIVE] MGBAX_PATHB_NATIVE_SIO=1 (原生 SIO 字路由：握手期真字直投、禁写真握手字、sidecar 早退)");
		}
	}
	return s_pathBNativeSio != 0;
}
void mgbaMobileSetPathBNativeSio(bool enabled) { s_pathBNativeSio = enabled ? 1 : 0; }

/* J8B 方案A：四个 helper 无条件编译（运行时门靠内部 mobileObsChainOn() return），
 * __attribute__((unused)) 由前置声明提供，避免门关时 -Wunused-function 告警。 */
/* 【OBSCHAIN OBS-A】零注入口径一次性快照：读现成门函数，纯只读、零写。 */
static void mobileObsChainGates(void) {
	if (!mobileObsChainOn()) {
		return;
	}
	static bool s_done;
	if (s_done) {
		return;
	}
	s_done = true;
	MOBILE_LOGI("[OBSCHAIN][GATES] gray_all=%u gray_lobby=%u btcfg=%u b7=%u rh_off=%u "
	            "hsbypass=%u bus_hs_preserve=%u forcehs=%u hs_hold=%u sticky2222=%u "
	            "localbus_2p=%u pathb_native=%u race=%u isync=%s",
	            (unsigned) (mobileGrayAllOn() ? 1 : 0),
	            (unsigned) (mobileGrayLobbyOpenOn() ? 1 : 0),
	            (unsigned) (linkBtcfgOn() ? 1 : 0),
	            (unsigned) (b7Verbose() ? 1 : 0),
	            (unsigned) (rhMOff() ? 1 : 0),
	            (unsigned) (mobileHsBypassOn() ? 1 : 0),
	            (unsigned) (mobileBusHsPreserveOn() ? 1 : 0),
	            (unsigned) (mobileForceHandshake() ? 1 : 0),
	            (unsigned) (mobileHsHoldOn() ? 1 : 0),
	            (unsigned) (mobileBlock2222On() ? 1 : 0),
	            (unsigned) (mobileLocalBus2pOn() ? 1 : 0),
	            (unsigned) (mobilePathBNativeSioOn() ? 1 : 0),
	            (unsigned) mobileRaceStressMs(),
	            "NA(no_app_gate)");
}

/* 【OBSCHAIN OBS-C】gLink.state 变化沿（含 4→2 回落），精确事件非采样；200 条节流。
 * X10-B 的 APP 侧 open= 复用现成 PEEK_LINK_OPEN（与 MOBILE_LINK_OPEN 同值）；
 * 严禁复用 [B7OPEN] 的 GBAPatch8 写路径。 */
static void mobileObsChainSt(struct GBA* g, int from, int to, int pc,
                             uint16_t m0, uint32_t wall) {
	if (!mobileObsChainOn() || !g || !g->cpu) {
		return;
	}
	static unsigned s_n;
	static unsigned s_reached4;
	static unsigned s_fellFrom4;
	if (to >= (int) MOBILE_LINK_STATE_CONN) {
		s_reached4 = 1u;
	} else if (s_reached4 && from >= (int) MOBILE_LINK_STATE_CONN) {
		s_fellFrom4 = 1u;
	}
	if (s_n >= MOBILE_OBS_ST_MAX) {
		return;
	}
	++s_n;
	MOBILE_LOGI("[OBSCHAIN][ST] n=%u %d->%d cb2=%08X mu=%u pc=%d open=%u cb=%08X "
	            "brs=%02X m0=%04X wall_ms=%u reached4=%u fell4=%u",
	            s_n, from, to,
	            (unsigned) GBAView32(g->cpu, NAV_CB2_PTR),
	            (unsigned) GBAView8(g->cpu, NAV_EW(MOBILE_BATTLE_COMM)),
	            pc,
	            (unsigned) GBAView8(g->cpu, PEEK_LINK_OPEN),
	            (unsigned) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_CALLBACK)),
	            (unsigned) GBAView8(g->cpu, NAV_IW(MOBILE_GLOBAL_BLK_RECV_STATUS)),
	            (unsigned) m0, (unsigned) wall,
	            (unsigned) s_reached4, (unsigned) s_fellFrom4);
}

/* 【OBSCHAIN OBS-D】握手字 provenance 三列（只读）；src= 是派生标签，三列原始值权威。 */
static void mobileObsChainProv(uint16_t own, uint16_t netPush, uint16_t peer) {
	if (!mobileObsChainOn()) {
		return;
	}
	static unsigned s_n;
	if ((++s_n & 0x0Fu) != 0u) {
		return;
	}
	const char* src;
	if (own == MOBILE_OBS_WORD_EMPTY || own == 0u) {
		src = MOBILE_OBS_SRC_EMPTY;
	} else if (own == netPush) {
		src = MOBILE_OBS_SRC_GAME;
	} else if (mobileLocalBus2pOn()) {
		src = MOBILE_OBS_SRC_LOCALBUS;
	} else {
		src = MOBILE_OBS_SRC_BRIDGE;
	}
	MOBILE_LOGI("[OBSCHAIN][PROV] n=%u own_slot_word=%04X net_push_word=%04X "
	            "peer_deliver_word=%04X src=%s",
	            s_n, (unsigned) own, (unsigned) netPush, (unsigned) peer, src);
}

/* 【OBSCHAIN OBS-B'】tempRecvBuffer 代理观测（直读不可行，显式 proxy_for_temp_recv=1）。 */
static void mobileObsChainProxy(struct MgbaMobile* emu, uint16_t own, uint16_t peer) {
	if (!mobileObsChainOn() || !emu || !emu->core) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	static unsigned s_n;
	if ((++s_n & 0x3Fu) != 0u) {
		return;
	}
	MOBILE_LOGI("[OBSCHAIN][BPROXY] n=%u pc=%u nr0=%02X isMaster=%u localId=%u "
	            "sioRemote=%u own_slot_word=%04X peer_deliver_word=%04X proxy_for_temp_recv=1",
	            s_n,
	            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_PLAYERS),
	            (unsigned) GBAView8(g->cpu, NAV_IW(MOBILE_REMOTE_PLAYERS_NOT_RECEIVED)),
	            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_ISMASTER),
	            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LOCALID),
	            (unsigned) (emu->sioHasRemote ? 1u : 0u),
	            (unsigned) own, (unsigned) peer);
}

#define MOBILE_BATTLE_INIT_OFF 0x4Du
static unsigned s_mobileBtcfgWrites;
/* 【ROOTHUNT2 方案 b，与 PC sioEnsureLinkBtcfg 逐字对称】窄窗口补写 var8004=1：
 * driver 跳过接待员菜单，var8004 停 0 → case5 SetLinkBattleTypeFlags(0) no-op →
 * btlType 无 LINK → case1 走单机 wild。在「菜单已定战斗、case5 未读」窄窗口补写
 * 合法 USING_SINGLE_BATTLE(1)（非伪造）。窗口 = 战斗 linkType 值 && state 达连接态
 * && cb2 不在 battle 段 && var8004==0 && btlType 无 LINK（全宏化判定）。 */
static void mobileEnsureLinkBtcfg(struct GBA* g) {
	if (!linkBtcfgOn() || !g || !g->cpu) {
		return;
	}
	uint16_t lt = (uint16_t) GBAView16(g->cpu, NAV_EW(MOBILE_LINK_TYPE_BATTLE));
	if (lt != MOBILE_LINKTYPE_BATTLE) {  /* battle task case0 已设 */
		return;
	}
	uint32_t lk = NAV_IW(MOBILE_GLINK_STATE);
	unsigned st = (unsigned) GBAView8(g->cpu, lk + MOBILE_GLINK_STATE_OFF);
	if (st < MOBILE_LINK_STATE_CONN) {  /* 握手完成 */
		return;
	}
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* cb2 不在 battle 段 = case5 未切 CB2_InitBattle（未读 var8004）。 */
	if (cb2 >= MOBILE_BATTLE_LO() + MOBILE_BATTLE_INIT_OFF
	    && cb2 < MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF) {
		return;
	}
	if (GBAView16(g->cpu, NAV_EW(MOBILE_SPECIAL_VAR_8004)) != 0u
	    || (GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS)) & MOBILE_BATTLE_TYPE_LINK) != 0u) {
		return;
	}
	GBAPatch16(g->cpu, NAV_EW(MOBILE_SPECIAL_VAR_8004), 1, NULL);
	++s_mobileBtcfgWrites;
	if (b7Verbose()) {
		MOBILE_LOGI("[BTLCFGW] cb2=%08X var8004=0->1 btlType=%08X linkType=%04X st=%u writes=%u",
		            (unsigned) cb2,
		            (unsigned) GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS)),
		            (unsigned) lt, st, s_mobileBtcfgWrites);
	}
}
/* ROOTHUNT2 块交换根治①（与 PC sioEnsureLinkOpen 对称）：真 LINK 战关链清
 * gLinkOpen=0，rem=1 让 OpenLink 不触发 → LinkMain2 掐断 callback。战斗启动窗口
 * 且对端确实连着(rem=1 st>=4)时恢复 gLinkOpen=1（真实链路状态，非伪造）。 */
static unsigned s_mobileLinkOpenWrites;
static void mobileEnsureLinkOpen(struct MgbaMobile* emu) {
	if (!linkBtcfgOn() || !emu || !emu->link || netLinkState(emu->link) != 2
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	/* 【灰区全开 C3】大厅态 cb2 在战斗段之外，普通门早退；GRAY_LOBBY_OPEN/GRAY_ALL
	 * 时绕过 cb2/battleish/玩家数门，强写 gLinkOpen=1（灰区伪恢复，须标注产物）。 */
	bool grayLobby = mobileGrayLobbyOpenOn();
	if (!grayLobby
	    && (cb2 < MOBILE_BATTLE_LO() + MOBILE_BATTLE_INIT_OFF
	        || cb2 >= MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF)) {
		return;
	}
	/* 【鲁棒战斗判定，与 PC 对称】linkType 值会波动，取 btlType 含 LINK 位
	 * 或 战斗类 gLinkType 并集，排除交换类（全宏化判定）。 */
	uint32_t lk = NAV_IW(MOBILE_GLINK_STATE);
	uint32_t bt = (uint32_t) GBAView32(g->cpu, NAV_EW(MOBILE_BATTLE_TYPE_FLAGS));
	uint16_t lt = (uint16_t) GBAView16(g->cpu, NAV_EW(MOBILE_LINK_TYPE_BATTLE));
	bool battleish = ((bt & MOBILE_BATTLE_TYPE_LINK) != 0u)
	                 || ((lt & MOBILE_LINKTYPE_CLASS_MASK) == MOBILE_LINKTYPE_CLASS_BATTLE);
	if (!battleish && !grayLobby) {
		return;
	}
	/* 对端确实连着：state 达连接态、playerCount 达 2P。不叠加 rem 门（U2 自锁）。
	 * 灰区全开时放宽此门——大厅/标题态 st/pc 未达连接态也强开 gLinkOpen。 */
	if (!grayLobby
	    && (GBAView8(g->cpu, lk + MOBILE_GLINK_STATE_OFF) < MOBILE_LINK_STATE_CONN
	        || GBAView8(g->cpu, lk + MOBILE_GLINK_PLAYERCOUNT_OFF) < MOBILE_LINK_PLAYERCOUNT_2P)) {
		return;
	}
	/* 【消灭假 checksum】每轮清 LINK_STAT_ERRORS，与 PC 对称。 */
	uint32_t st = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS));
	if (st & MOBILE_LINK_STAT_ERRORS) {
		GBAPatch32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS), (int32_t) (st & ~MOBILE_LINK_STAT_ERRORS), NULL);
	}
	/* 保 gLinkOpen=1（恢复真实链路状态，非伪造）。 */
	if (GBAView8(g->cpu, NAV_EW(MOBILE_LINK_OPEN)) == 0u) {
		GBAPatch8(g->cpu, NAV_EW(MOBILE_LINK_OPEN), 1, NULL);
		++s_mobileLinkOpenWrites;
		if (b7Verbose()) {
			MOBILE_LOGI("[B7OPEN%s] cb2=%08X gLinkOpen=0->1 st=%u pc=%u bt=%08X lt=%04X writes=%u",
			            grayLobby ? "-GRAY" : "", (unsigned) cb2,
			            (unsigned) GBAView8(g->cpu, lk + MOBILE_GLINK_STATE_OFF),
			            (unsigned) GBAView8(g->cpu, lk + MOBILE_GLINK_PLAYERCOUNT_OFF), (unsigned) bt, (unsigned) lt,
			            s_mobileLinkOpenWrites);
		}
	}
}
static unsigned s_mobileBattleRelayEmpty;
static unsigned s_mobileBattleRelaySlavePush;
/* B7 判据：与 PC inBattleBlockRelay 逐行对称，握手期恒 false，无裸地址。 */
static bool inBattleBlockRelay(struct MgbaMobile* emu) {
	if (!emu || !emu->link || netLinkState(emu->link) != 2
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return false;
	}
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	return cb2 >= MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 <  MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF;
}
/* 【ROOTHUNT 迭代 33 — 修正迭代 31 的错误方向】冻结主机会触发 LAG_MASTER：
 * APPHUNT-OPP 实测 `LINK_ERR st=00010968 lagM=1 emuFps=16.8` —— 战斗期
 * sioDone 不完成轮次 ⇒ 每帧 SIO IRQ < 9 ⇒ LinkVSync 判 LAG_MASTER ⇒
 * CheckErrorStatus 关链。正确姿势是**继续完成轮次保 IRQ 节奏**，但每轮把
 * gLink.lag(+0x13) 与 gLinkStatus 的错误位清掉，避免误判断链。 */
/* 【P0 / LAG 写时拦截】与 PC sioClearClockLag（sio_link.c:4103）逐字对称：
 * 只维护「要不要拦」的全局 gbaLinkDropClockLag=链路连着，真正拦截在共享 C
 * memory.c 的 _dropLagStore（VBlank 写 lag 时吞掉，事后清来不及）。门关或非
 * GBA 核时清回 false（与 PC L4110 对称）；真断链(alive=false)时关闭拦截、
 * 让游戏自己报错，不掩盖真实断链。具名宏 + NAV_IW 运行时 delta，禁裸 hex。 */
static void mobileClearClockLag(struct MgbaMobile* emu) {
	if (!mobileNoLagClearEnabled() || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		gbaLinkDropClockLag = false;
		return;
	}
	bool alive = emu->link && netLinkState(emu->link) == 2;
	gbaLinkDropClockLag = alive;
	if (!alive) {
		return;   /* 真断链不掩盖 */
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	uint32_t a = NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_LAG_OFF;
	if (g && g->cpu && GBAView8(g->cpu, a)) {
		GBAPatch8(g->cpu, a, 0, NULL);   /* 扫尾：已落盘的历史 lag 字节 */
	}
}
/* 迭代 41: 移动端此前**完全没有** Qt 的 sioClearClockLag/gbaLinkDropClockLag
 * 机制 —— 主机每帧 <9 IRQ 就置 LAG_MASTER(0x10000) 并 CloseLink，而 PC 从机
 * 根本不查 LAG。APPHUNT-PATCH 的 `LINK_RESET prev=00010868` 正是此因。
 * 与 Qt 对齐：只要云链路还连着就每轮清 lag + 错误位，不局限战斗窗口。 */
static void mobileBattleKeepAlive(struct MgbaMobile* emu) {
	if (!emu->link || netLinkState(emu->link) != 2
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	/* 迭代 42: CheckErrorStatus 读的是 gLinkStatus 的错误位，而它每帧由
	 * gLink.hardwareError(+0x10)/badChecksum(+0x11)/queueFull(+0x12)/lag(+0x13)
	 * 重建 —— 只清 lag 不够，四个源标志都要清。同时置
	 * gSuppressLinkErrorMessage(canonical 0x03002AAC) 抑制误报错误屏。 */
	GBAPatch8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_HWERR_OFF, 0, NULL);
	GBAPatch8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_BADCKSUM_OFF, 0, NULL);
	GBAPatch8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_QUEUEFULL_OFF, 0, NULL);
	GBAPatch8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_LAG_OFF, 0, NULL);
	GBAPatch8(g->cpu, NAV_IW(RH_M_SUPPRESS_ERR), 1, NULL);
	uint32_t st = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS));
	if (st & MOBILE_LINK_STAT_ERRORS) {
		GBAPatch32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS), (int32_t) (st & ~MOBILE_LINK_STAT_ERRORS), NULL);
	}
	static unsigned bn;
	if (mobileRhVerbose() && (++bn % 256) == 0) {
		MOBILE_LOGI("[BIDLE] cb2=%08X in=1 keepalive lag=%u st=%08X",
		            (unsigned) GBAView32(g->cpu, NAV_CB2_PTR),
		            (unsigned) GBAView8(g->cpu, NAV_IW(0x03002AF4u) + 0x13u),
		            (unsigned) GBAView32(g->cpu, NAV_IW(0x03002A9Cu)));
	}
}

static bool mobileInCmdPhase(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	unsigned st = GBAView8(gba->cpu, NAV_IW(0x03002AF5u));       // gLink.state
	unsigned rem = GBAView8(gba->cpu, NAV_IW(0x03002AC1u));      // gReceivedRemoteLinkPlayers
	return st >= 4u && rem != 1u;
}

/* 【ROOTHUNT2 修复②，与 PC sioInBlockSendPhase 逐字对称】是否块发送期。
 * 三判据（state>=4 硬门在前，不碰握手期 rearm/收尾）：
 *   A: gLinkCallback ∈ {BlockSendBegin, BlockSend, BlockSendEnd}
 *   B: gSendCmd[0] ∈ {INIT_BLOCK, CONT_BLOCK}
 *   C: cb2 战斗窗 && rem!=0 && MULTIUSE_STATE ∈ 块期值集合 */
static bool mobileInBlockSendPhase(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return false;
	}
	if (GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) < MOBILE_LINK_STATE_CONN) {
		return false;
	}
	uint32_t cb = (uint32_t) GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_CALLBACK));
	if (cb == MOBILE_CB_BLOCK_SEND_BEGIN || cb == MOBILE_CB_BLOCK_SEND
	    || cb == MOBILE_CB_BLOCK_SEND_END) {
		return true;
	}
	uint16_t cmd0 = (uint16_t) GBAView16(g->cpu, NAV_IW(MOBILE_GLOBAL_SEND_CMD));
	if (cmd0 == LINKCMD_INIT_BLOCK || cmd0 == LINKCMD_CONT_BLOCK) {
		return true;
	}
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	if (cb2 >= MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 < MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF
	    && GBAView8(g->cpu, NAV_IW(MOBILE_GLOBAL_REMOTE_ID)) != 0u) {
		unsigned mu = (unsigned) GBAView8(g->cpu, NAV_EW(RH_M_MULTIUSE_STATE));
		if (mu == LINK_MU_BLOCK2 || mu == LINK_MU_BLOCK4 || mu == LINK_MU_BLOCK8
		    || mu == LINK_MU_BLOCK12 || mu == LINK_MU_BLOCK17) {
			return true;
		}
	}
	return false;
}
/* 【路线A / sioHandshakeHold 单一取值点】与 PC sioHandshakeHoldWord 逐字对称。
 * 本端 st4、从机、真对端在线、对端真字仍是握手字、窗口未空、非块期 ⇒
 * 返回 gen8 真从机握手字 B9A0（只推真字；不写 state/rem/brs/nr/btlType/case1）。
 * 主机绝不保持（0x2222 命令帧首字丢了会永久 rem=0）。同一轮内各调用点取值同源。 */
static uint16_t mobileHandshakeHoldWord(struct MgbaMobile* emu, uint16_t own) {
	if (!linkBtcfgOn() || !mobileHsHoldOn() || !emu || !emu->link
	    || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return own;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return own;
	}
	if (netLinkState(emu->link) != 2u) {                       /* 真对端在线 */
		return own;
	}
	if (GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) < MOBILE_LINK_STATE_CONN) {
		return own;                                            /* 只管 st>=4 之后 */
	}
	if (!emu->sioHsHoldArmed || emu->sioHsHoldLeft == 0u) {    /* 有界窗口 */
		return own;
	}
	uint16_t peer = (uint16_t) emu->sioRemote;
	if (peer != LINK_HANDSHAKE_MASTER
	    && (uint16_t) (peer & ~LINK_HANDSHAKE_SLAVE_MASK) != LINK_HANDSHAKE_SLAVE) {
		return own;                                            /* 对端已非握手⇒退出，不互锁 */
	}
	if (GBAView32(g->cpu, NAV_IW(MOBILE_GLINK_STATUS)) & LINK_STAT_MASTER) {
		return own;                                            /* 主机一个字都不能丢 */
	}
	if (mobileInBlockSendPhase(emu)) {                         /* 块期让位，真块字优先 */
		return own;
	}
	return LINK_HANDSHAKE_SLAVE;                               /* 真 B9A0 */
}
/* ROOTHUNT2 方案2：从 gen8 真实 sendQueue.data[0..7][pos] 读完整块命令帧
 *（8 字：命令头 BBBB/8888 + 7 个数据字），逐字推出；对端 gen8 按 8 拍收齐
 * gRecvCmds 才能闭合块交换。推的是 gen8 真实生成的帧，非伪造。门 BTLCFG。 */
static bool mobileIsBlockWord(uint16_t w) {
	/* 路线A：0x2222 启动字纳入 sticky 兜底（受独立门控制，=0 秒回退），
	 * 与 PC sioIsBlockWord 逐字对称。只在 mobileReloadBlockFrame 的队头真字
	 * 判据命中才缓存逐拍推，非伪造。 */
	return w == LINKCMD_INIT_BLOCK || w == LINKCMD_CONT_BLOCK
	    || (mobileBlock2222On() && w == LINKCMD_SEND_LINK_TYPE);
}
/* 【ROOTHUNT2 V1 相位锁】只读 gLink.sendCmdIndex（sc，+0x16），绝不写索引。
 * gen8 9 拍帧：DoSend 在 sc∈[0,7] 写 data[sc]、sc==8 写真 checksum。
 * 起轮捕获到的 sc 是"本轮 DoSend 要用的相位"，而 SIOMLT_SEND 在飞的字是
 * 上一轮写的 data[sc-1]（sc==0 时在飞的是 checksum）——见 PC sioSyncIdx
 * idxW=(sc==0)?8:(sc-1) 与 CMDFRAMEALIGN（帧首字 DoSend sc==0 写、起轮 sc==1
 * 在飞）。故注入按 sc-1 选帧内字、sc==0 放行真 checksum。
 * 每轮起轮捕获一次到 sioBlockPhase，自槽(advance=false)与 push(advance=true)
 * 用同一 sc → 同一块字 → 两端 checksum 累加一致。 */
static uint8_t mobileCaptureBlockPhase(struct MgbaMobile* emu) {
	if (emu && emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) emu->core->board;
		if (g && g->cpu) {
			emu->sioBlockPhase = GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_SENDCMD_IX_OFF);
		}
	}
	return emu ? emu->sioBlockPhase : 0u;
}
/* 【ROOTHUNT2 V1】会话 reset（V11-S7）：state<2（链路重建/未起）时清空块帧缓冲，
 * 杜绝上一会话的块字残留污染本会话判据。仅在 linkBtcfgOn 门内生效。 */
static void mobileResetBlockFrame(struct MgbaMobile* emu) {
	if (!linkBtcfgOn() || !emu || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (g && g->cpu
	    && GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) < MOBILE_LINK_STATE_HANDSHAKE) {
		emu->sioBlockFrameValid = false;
		emu->sioBlockFrameIdx = 0;
	}
}
/* 【ROOTHUNT2 方案2+V1】从 gen8 真实 sendQueue.data[0..7][pos] 读完整块命令帧
 *（8 字），按 sc 相位逐拍推出；只在 sc==0 且队头 data[0][pos] 是块字时 reload。
 * V1：sc==0（新帧首）才 reload，避免自由 8 计数导致相位漂移/盲目重装。 */
static void mobileReloadBlockFrame(struct MgbaMobile* emu) {
	if (!linkBtcfgOn() || !emu || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	/* V1：只在 sc==0（新命令帧首）reload；自由 8 计数已由 sc 取代。 */
	if (emu->sioBlockPhase != 0u) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	uint32_t base = NAV_IW(MOBILE_GLINK_STATE);
	uint8_t pos = GBAView8(g->cpu, base + MOBILE_GLINK_SENDQ_POS_OFF);
	/* V3：EnqueueSendCmd 写队尾 (pos+count)%50，DoSend 读队头 data[][pos]。
	 * 当前实现故意只读队头（与 gen8 DoSend 同槽），块帧入队后要等 count 次
	 * sc==8 弹队才到队头；在那之前队头是旧帧字 0，不是 BBBB/8888。
	 * 因此"块字是否已到队头"的判据就是 data[0][pos] 本身，不读队尾——
	 * 读队尾会把尚未轮到的帧推出，与 gen8 自己的 checksum/sc 相位脱节。 */
	uint8_t cnt = GBAView8(g->cpu, base + MOBILE_GLINK_SENDQ_CNT_OFF);
	uint32_t slot = base + MOBILE_GLINK_SENDQ_WORD_OFF(0, MOBILE_SENDQ_SLOT_HEAD(pos));
	(void) cnt;  /* 打点里用；逻辑判据只看队头字 */
	if (!mobileIsBlockWord(GBAView16(g->cpu, slot))) {
		/* V3：队头不是块字 ⇒ 块帧还在队尾未到，或已错过。清掉上一帧残留，
		 * 本轮不注入、推 own（真 check/空字），绝不用过期块字污染对端。 */
		emu->sioBlockFrameValid = false;
		emu->sioBlockFrameIdx = 0;
		return;
	}
	for (unsigned k = 0; k < LINK_CMD_LENGTH; ++k) {
		emu->sioBlockFrame[k] =
		    MOBILE_GLINK_SENDQ_WORD(g->cpu, k, MOBILE_SENDQ_SLOT_HEAD(pos));
	}
	emu->sioBlockFrameIdx = 0;
	emu->sioBlockFrameValid = true;
}
/* V1 相位门控（in-flight 槽位口径）——与 PC sioSyncIdx idxW 逐字同源：
 *   idxW = (sc==0) ? 8 : (sc-1)   （sio_link.c SIO_SYNCIDX_TAG_WORD：
 *   起轮 sc 是本轮 DoSend 要用的相位，SIOMLT_SEND 里躺着的是上一轮的字）；
 *   CMDFRAMEALIGN 也证明帧首 0x2222/BBBB 由 DoSend 在 sc==0 写出、
 *   在起轮 sc==1 时处于在飞态 ⇒ 该轮应推 frame[0]。
 * ⇒ sc==0：在飞字是真 checksum（上一帧 sc==8 DoSend 写），原样放行 own，
 *          并借本帧首 reload 队头块帧；sc∈[1,8]：推 frame[sc-1]（帧内字 0..7）。
 * 若误用 frame[sc]（不 -1），每个块字都会晚一拍落格、BBBB 落到校验对比拍被吞 ⇒ brs 仍 0。 */
static uint16_t mobileBlockOutWord(struct MgbaMobile* emu, uint16_t w, bool advance) {
	if (!linkBtcfgOn() || !emu) {
		return w;
	}
	/* 【W92/path B 原生 SIO】握手期(state<CONN)放行游戏真字（与 PC 逐字对称）：
	 * 块帧路由不顶掉真 8FFF/B9A0，HSBYPASS 保真门不再需要。只读 w、不合成字；
	 * state>=CONN 的块字路由与门关时逐字节不变（零回归）。 */
	if (mobilePathBNativeSioOn() && emu->core
	    && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) emu->core->board;
		if (g && g->cpu
		    && GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF)
		           < MOBILE_LINK_STATE_CONN) {
			return w;
		}
	}
	/* 【ROOTHUNT2 P0/M1】握手态旁路保真 8FFF（与 PC sioBlockOutWord 逐字对称）：
	 * state==2 且出字是主机握手字时直接放行，绝不让块帧替换。8FFF 是 gen8 真字，
	 * 只保真不伪造；门 MGBAX_LINK_HSBYPASS=0 / debug.mgbax.link.hs_bypass=0 秒回退。 */
	if (mobileHsBypassOn() && w == LINK_HANDSHAKE_MASTER && emu->core
	    && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) emu->core->board;
		if (g && g->cpu
		    && GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF)
		           == MOBILE_LINK_STATE_HANDSHAKE) {
			return w;
		}
	}
	mobileResetBlockFrame(emu);
	uint8_t sc = emu->sioBlockPhase;
	if (sc == 0u) {
		/* checksum 拍：放行 gen8 真值，不注入；顺便在帧首 reload 队头块帧。 */
		mobileReloadBlockFrame(emu);
		return w;
	}
	if (sc > 8u) {
		return w;
	}
	if (!emu->sioBlockFrameValid) {
		return w;
	}
	unsigned word = (unsigned) (sc - 1u);  /* 在飞字在帧内的槽号 idxW: 0..7 */
	uint16_t out = emu->sioBlockFrame[word];
	emu->sioBlockFrameIdx = (uint8_t) word;  /* 打点用，下标由 sc 派生（替代自由 idx） */
	/* 路线A 只读打点：0x2222 兜底字真正出网（sc==1 推 frame[0]）时记一条，
	 * 与 PC [B72222] 逐字对称。纯日志，不写状态。 */
	if (mobileBlock2222On() && out == LINKCMD_SEND_LINK_TYPE && word == 0u && b7Verbose()) {
		static unsigned b2n;
		if (++b2n <= 32u || (b2n % 256u) == 0u) {
			MOBILE_LOGI("[B72222] sticky push 0x2222 sc=%u ok=%u", (unsigned) sc,
			            (unsigned) emu->sioOk);
		}
	}
	if (advance && sc == 8u) {
		emu->sioBlockFrameValid = false;  /* 第 8 字推完，下一轮 sc==0 再 reload */
	}
	return out;
}
/* [B7BLK] 逐拍观测打点（B7_VERBOSE 门，与 PC 逐字对称）：纯只读，不改任何
 * 块推送行为、不写游戏状态。战斗 cb2 窗内每拍一条（逐拍），窗外仍 1/32
 * 采样。扩展字段 st/cb2/sc/rc/sq0/cnt/mltsend/self/peer/brs 全部实时只读，
 * sc 取自 sioBlockPhase —— 从机侧由 MOBILE_CAPTURE_BLOCK_CTX 在推送点每轮
 * 捕获真值（不再恒 0）。 */
static void mobileCaptureBlockWord(struct MgbaMobile* emu, uint16_t sioMltSend) {
	if (!b7Verbose() || !emu || !emu->core
	    || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) {
		return;
	}
	static unsigned bn;
	++bn;
	uint32_t cb2 = (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR);
	uint8_t state = GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF);
	bool inBattle = state >= MOBILE_LINK_STATE_CONN
	    && cb2 >= MOBILE_BATTLE_LO() + BATTLE_START_HANDLE_OFF
	    && cb2 < MOBILE_BATTLE_LO() + BATTLE_MAIN_END_OFF;
	if (!inBattle && (bn & 0x1Fu) != 0u) {
		return;
	}
	uint32_t base = NAV_IW(MOBILE_GLINK_STATE);
	uint8_t pos = GBAView8(g->cpu, base + MOBILE_GLINK_SENDQ_POS_OFF);
	uint8_t cnt = GBAView8(g->cpu, base + MOBILE_GLINK_SENDQ_CNT_OFF);
	uint32_t headSlot = MOBILE_SENDQ_SLOT_HEAD(pos);
	uint32_t tailSlot = MOBILE_SENDQ_SLOT_TAIL(pos, cnt);
	uint16_t sq0 = MOBILE_GLINK_SENDQ_WORD(g->cpu, 0, headSlot);
	uint16_t tail0 = MOBILE_GLINK_SENDQ_WORD(g->cpu, 0, tailSlot);
	uint8_t rc = GBAView8(g->cpu, base + MOBILE_GLINK_RECVCMD_IX_OFF);
	uint16_t brs = GBAView16(g->cpu, NAV_IW(MOBILE_GLOBAL_BLK_RECV_STATUS));
	MOBILE_LOGI("[B7BLK] n=%u st=%u cb2=%08X sc=%u rc=%u sq0=%04X pos=%u cnt=%u head=%u tail0=%04X frame=%u idx=%u valid=%d mltsend=%04X self=%04X peer=%04X brs=%04X",
	            bn, (unsigned) state, (unsigned) cb2, (unsigned) emu->sioBlockPhase, (unsigned) rc,
	            (unsigned) sq0, (unsigned) pos,
	            (unsigned) cnt, (unsigned) headSlot, (unsigned) tail0,
	            (unsigned) (mobileIsBlockWord(sq0) ? 1 : 0),
	            (unsigned) emu->sioBlockFrameIdx, emu->sioBlockFrameValid ? 1 : 0,
	            (unsigned) sioMltSend, (unsigned) emu->sioSelfSlot,
	            (unsigned) (uint16_t) emu->sioRemote, (unsigned) brs);
}
/* ROOTHUNT2 治本：从机真实路径捕获宏（与 PC SIO_CAPTURE_BLOCK_CTX 逐字对称）。
 * GBA 从机不写 SIOCNT → gbaLinkWriteCnt 起轮分支不执行；必须在这三处从机
 * real-path 注入点每轮重新捕获 sc，否则 sioBlockPhase 恒 0。只读真寄存器。 */
#define MOBILE_CAPTURE_BLOCK_CTX(emu_, word_) do { \
	(void) mobileCaptureBlockPhase((emu_)); \
	mobileCaptureBlockWord((emu_), (uint16_t) (word_)); \
} while (0)
/* 块期把握手字换成合法 0（非伪造块字，0 是 DoSend 空队列合法字），与 PC 让位对称。 */
static uint16_t mobileBlockYieldWord(struct MgbaMobile* emu, uint16_t w) {
	if (linkBtcfgOn() && mobileInBlockSendPhase(emu)
	    && (w == LINK_HANDSHAKE_MASTER || (uint16_t) (w & ~LINK_HANDSHAKE_SLAVE_MASK) == LINK_HANDSHAKE_SLAVE)) {
		return 0;
	}
	return w;
}

/* 提前放行门槛：Android 属性 mgbax.sio.fast_min_ok(_slave) / 桌面环境变量
 * MGBAX_FAST_MIN_OK(_SLAVE)，默认 256 = 原行为（A/B 零回归）。
 * path A 云端握手在 n≈34 就到 lstate=4 pc=2，但门等 n>=256 时这 220 轮走
 * 慢速网络往返 ⇒ 每帧 SIO 中断远不到 9 次 ⇒ LAG_MASTER(0x10000) 拆链
 *（ADR-003 §4.2 h.6）。主机设 8 让快帧在握手后立即生效；从机默认仍 256
 *（块交换期取不到主机字时复用旧字会 badChecksum），只有显式设置才放宽。
 * 缓存方式与 sioFastEnabled 一致（-1 = 还没读）。 */
static uint32_t mobileFastMinOk(bool slave) {
	/* 不要用 s_host / s_slave 命名：winsock 的 inaddr.h 把 s_host 定义成宏。 */
	static int s_minOkHost = -1;
	static int s_minOkSlave = -1;
	int* slot = slave ? &s_minOkSlave : &s_minOkHost;
	if (*slot < 0) {
		int v = 256;
#ifdef __ANDROID__
		char buf[PROP_VALUE_MAX] = {0};
		/* 点分为规范名，下划线是历史别名 —— 两个名字都要真正读，且各读一次。
		 * 原实现两行都读点分名，导致 min_ok 下划线别名永远不生效。 */
		static const char* const kDotted[2] = {
			"mgbax.sio.fast.min_ok", "mgbax.sio.fast.min_ok_slave"
		};
		static const char* const kUnderscore[2] = {
			"mgbax.sio.fast_min_ok", "mgbax.sio.fast_min_ok_slave"
		};
		const unsigned which = slave ? 1u : 0u;
		rhGetProp(kDotted[which], buf);
		if (!buf[0]) {
			rhGetProp(kUnderscore[which], buf);
		}
		if (buf[0]) {
			v = atoi(buf);
		}
#else
		const char* s = getenv(slave ? "MGBAX_FAST_MIN_OK_SLAVE" : "MGBAX_FAST_MIN_OK");
		if (s && *s) {
			v = atoi(s);
		}
#endif
		/* 与 Qt 侧 sio_link.c 的 minOk 归一口径对齐：只有正值有效，非正值
		 * 一律回落到 256（默认行为）。原来的 (v>=0)?v:0 会把 0/负值当成
		 * 「不必等握手就放行快帧」，块交换期复用陈旧字 ⇒ badChecksum 掉链。
		 * 默认 256 与云端 8 均不受影响。 */
		*slot = (v > 0) ? v : 256;
	}
	return (uint32_t) *slot;
}

static bool mobileFastFrameImpl(struct MgbaMobile* emu, uint32_t minOk) {
	if (emu->sioFastEnabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.sio.fast", v);
		emu->sioFastEnabled = (v[0] == '0') ? 0 : 1;
#else
		const char* v = getenv("MGBAX_SIO_FAST");
		emu->sioFastEnabled = (v && atoi(v) == 0) ? 0 : 1;
#endif
	}
	/* 链路断开或优化被关掉：解除锁存，下次重新等到 cnt>=2 才放开。
	 * 连那份可复用的对端字一起清（为什么：见 sioFastReset 的注释）。
	 * 注意这条分支只有在链路状态短暂掉出 2、还来得及走到这里时才命中：
	 * 真正掉线后 pollLink → detachLink 会先把驱动摘掉，从机事件在入口
	 * （2881 的 linkAttached）就 return 了，所以 detachLink 里也调了
	 * 同一个 sioFastReset —— 两处都要，缺一处就有窗口。 */
	if (!emu->sioFastEnabled || !emu->link || netLinkState(emu->link) != 2) {
		sioFastReset(emu);
		return false;
	}
	if (emu->sioFastLatched) {
		/* 【锁存不能绕过 state 检查】
		 * 块交换 / 掉线时 gLink.state(0x03002AF5) 会先掉回 <4，而 sioOk
		 * 仍 >256、锁存还挂着，快帧就会继续拿陈旧字收尾。gen8 每 8 轮发
		 * 一条命令、逐块比对校验和（gen8/link.c:2322-2355），一个陈旧字
		 * 就能把 ck 打回 1、块接收状态归 0。所以锁存之后每轮仍要复核
		 * state：<4 立即解除锁存并回落严格路径（顺带清掉可复用字）。 */
		if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			struct GBA* gbaL = (struct GBA*) emu->core->board;
			if (gbaL && gbaL->cpu && GBAView8(gbaL->cpu, NAV_IW(0x03002AF5u)) < 4) {
				sioFastReset(emu);
				return false;
			}
		}
		return true;
	}
	if (emu->sioOk < minOk) {
		return false;
	}
	/* 只在 LINKUP 真正完成后放开帧率：握手与训练家卡片块交换期间每一轮都
	 * 必须是真实对端字，复用上一轮字会破坏块校验（历史结论：空槽/陈旧字会
	 * 把 cnt 打回 0，停在「等待连接」）。 */
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	/* 只看 sioOk 会误判上一局遗留的内存值：gLink.state（0x03002AF5）与
	 * playerCount（0x03002AF7）才是真实判据（历史成功轮 lstate=4 pc=2）。
	 * 两者同时满足才认定会话已建立。 */
	uint16_t gl0 = GBAView16(gba->cpu, NAV_IW(0x03002AF4u));
	uint16_t gl1 = GBAView16(gba->cpu, NAV_IW(0x03002AF6u));
	unsigned glState = (gl0 >> 8) & 0xFF;
	unsigned glPlayers = (gl1 >> 8) & 0xFF;
	if (!mobileFastGateReadyEx(!emu->sioFastEnabled, emu->sioOk, glState, glPlayers, minOk)) {
		return false;
	}
	/* 【不再把 gFieldLinkPlayerCount >= 2 当必要条件】
	 * 这个字段取自 0x03004A38 高字节（与 [room] 诊断里的 cnt 同源），但只有
	 * 野外 / 联机房间那条路线会写它；有线俱乐部的「大竞技场 / 交换中心」这
	 * 条路它恒为 0。11-15 实测：两端已 LINKUP（app PEEK `link[m=8 st=4 id=0
	 * pc=2]`，都停在绿宝石大竞技场的柜台前），PC 却仍是 4.9fps，logcat 里
	 * 一条 `SIO fast` 都没有 —— 就是被这一条永远判失败卡死的。
	 * 会话判据只认 gLink.state / playerCount：这正是 LINKUP 的真判据。
	 * 上面那段历史注释讲的是「只看 cnt 会误判」（lstate=1 pc=0 却 cnt=2，
	 * 那是上一局遗留值）；现在 state>=2 且 pc>=2 已经把那种状态排除掉了，
	 * 所以去掉 fieldCount 不会放大误判。它若 >=2 仍然说明走的是房间路线，
	 * 记进日志便于事后区分两条路线。 */
	unsigned fieldPlayers = GBAView16(gba->cpu, NAV_IW(0x03004A38u)) >> 8;
	/* 会话建立过一次就锁存：sioOk 与 gLink 判据都会抖动，不锁存时同一个
	 * 传输窗口里只有一部分轮次走快帧，其余仍按 23~32ms/轮 阻塞。 */
	emu->sioFastLatched = true;
	MOBILE_LOGI("SIO fast on me=%d ok=%u idx=%u lstate=%u pc=%u field=%u minOk=%u",
	            netLinkPlayer(emu->link), emu->sioOk, (unsigned) emu->sioIndex,
	            glState, glPlayers, fieldPlayers, minOk);
	return true;
}

/* 主机门（sioDoneEvent）：读 MGBAX_FAST_MIN_OK，默认 256，path A 云端设 8。 */
static bool mobileFastFrame(struct MgbaMobile* emu) {
	return mobileFastFrameImpl(emu, mobileFastMinOk(false));
}

/* 【MGBAX_FAST_SLAVE_ALIGN：从机快帧「两端 idx 已对齐」前提】与 Qt
 * sio_link.c 的 sioHostPubIndex/sioFastSlaveIdxAligned/sioFastFrameSlave 同契约。
 * ADR-003 §4.2 h.6 遗留卡点：从机快帧取不到主机字时把 sioFastLast 旧字当本轮
 * 真字喂进逐块校验 ⇒ badChecksum(0x2000) 掉链（现场从机 idx 冻结 50、主机已
 * 推到 576）。对齐基准取**链路层最近一次对端推字的轮次号**（recvIndex = 主机
 * 发布的 idx），不是本机冻结的 sioIndex。 */
static unsigned mobileHostPubIndex(struct MgbaMobile* emu) {
	unsigned idx = 0;
	if (emu && emu->link) {
		netLinkWireStats(emu->link, NULL, NULL, NULL, NULL, &idx);
	}
	return idx;
}

/* 纯函数：wrap-safe 的 min(|hostIdx-slaveIdx| mod 2^16, 反向) <= window。
 * 任一侧为 0（还没拿到可靠轮次基准）视为未对齐，宁可多等一轮也不喂旧字。 */
static bool mobileFastSlaveIdxAligned(uint32_t hostIdx, uint32_t slaveIdx, uint32_t window) {
	if (hostIdx == 0 || slaveIdx == 0) {
		return false;
	}
	uint32_t ahead = (uint32_t) (uint16_t) (hostIdx - slaveIdx);
	uint32_t behind = (uint32_t) (uint16_t) (slaveIdx - hostIdx);
	uint32_t gap = ahead < behind ? ahead : behind;
	return gap <= window;
}

/* 从机门（sioSlaveDoneEvent）：与 Qt sioFastFrameSlave 对齐 —— 默认固定 256，
 * 只有显式设 MGBAX_FAST_MIN_OK_SLAVE 才放宽。块交换期从机是「消费字」方，
 * 取不到主机字时复用 sioFastLast 会喂进逐块校验 ⇒ badChecksum(0x2000) 掉链。 */
static bool mobileFastFrameSlave(struct MgbaMobile* emu) {
	static int s_alignWindow = -1;
	if (s_alignWindow < 0) {
		int v = 0;
#ifdef __ANDROID__
		char buf[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.sio.fast.slave_align", buf);
		if (!buf[0]) {
			rhGetProp("mgbax.sio.fast_slave_align", buf);
		}
		if (buf[0]) {
			v = atoi(buf);
		}
#else
		const char* s = getenv("MGBAX_FAST_SLAVE_ALIGN");
		if (s && *s) {
			v = atoi(s);
		}
#endif
		s_alignWindow = (v > 0) ? v : 0;
	}
	uint32_t minOk = mobileFastMinOk(true);
	/* 只在「门本来准备放行」那一刻查对齐（避免握手期刷满诊断计数）。
	 * 未对齐就不锁存、返回 false ⇒ 落回严格等待路径，本机逐轮消费把
	 * sioIndex 追上主机后门自动放行。默认 window=0（关闭，零回归）。 */
	if (s_alignWindow > 0 && emu && emu->sioOk >= minOk) {
		unsigned st = 0;
		if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			struct GBA* gba = (struct GBA*) emu->core->board;
			if (gba && gba->cpu) {
				st = GBAView8(gba->cpu, NAV_IW(0x03002AF5u));
			}
		}
		if (st >= 4) {
			unsigned hostIdx = mobileHostPubIndex(emu);
			if (!mobileFastSlaveIdxAligned(hostIdx, (uint32_t) emu->sioIndex,
			                               (uint32_t) s_alignWindow)) {
				++emu->sioFastAlignBlocked;
				if ((emu->sioFastAlignBlocked & 0x3F) == 1) {
					MOBILE_LOGI("slave fast align gate blocked n=%u slaveIdx=%u hostIdx=%u window=%d state=%u ok=%u",
					            emu->sioFastAlignBlocked, (unsigned) emu->sioIndex,
					            hostIdx, s_alignWindow, st, emu->sioOk);
				}
				return false;
			}
		}
	}
	return mobileFastFrameImpl(emu, minOk);
}

/* 快帧分支的限频日志：每 256 轮一条，带复用次数，便于现场判断对端是否掉队。
 * pidx/pq 是本机看到的「对端已推入队列的轮次号 / 队列字数」——快帧从机跟随
 * 主机最新 idx，pidx 与本轮 idx 对齐（差值稳定在 0~1）才证明字源没飞转；
 * 机器可读，直接拿这行做跨端 idx 对齐断言（ADR-003 §6 / §4.2 h.6）。 */
static void mobileFastLog(struct MgbaMobile* emu) {
	if ((++emu->sioFastN & 0xFF) != 0) {
		return;
	}
	int pq = 0;
	unsigned pidx = 0;
	if (emu->link) {
		netLinkPeerHeadInfo(emu->link, &pq, &pidx);
	}
	MOBILE_LOGI("SIO fast me=%d n=%u reuse=%u miss=%u cmdguard=%u idx=%u pidx=%u pq=%d alignblk=%u",
	            netLinkPlayer(emu->link), emu->sioFastN, emu->sioFastReuse,
	            emu->sioFastMiss, (unsigned) emu->sioCmdGuardRounds,
	            (unsigned) emu->sioIndex, pidx, pq,
	            emu->sioFastAlignBlocked);
}

static void sioSlaveDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	emu->sioSlaveArmed = false;
	/* 【诊断】env-gated：slot 1 推几轮就停、slot 2/3 在另一轮推时，必须
	 * 区分是哪个早退点把从机关在门外。每个点每进程只记 6 条。 */
	static int sdNoLink, sdNoMulti, sdMaster;
	if (!emu->link || !emu->linkAttached || !emu->core) {
		if (getenv("MGBAX_SLAVE_DIAG") && sdNoLink++ < 6) {
			fprintf(stderr, "SLAVE_DIAG no-link me=%d link=%p attached=%d\n",
			        emu->link ? netLinkPlayer(emu->link) : -1,
			        (void*) emu->link, emu->linkAttached ? 1 : 0);
		}
		return;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	if (gba->sio.mode != GBA_SIO_MULTI) {
		/* 游戏还没进多人传输（或者已经退出）：不收尾，等下一次轮询再挂。 */
		if (getenv("MGBAX_SLAVE_DIAG") && sdNoMulti++ < 6) {
			fprintf(stderr, "SLAVE_DIAG no-multi me=%d mode=%d\n",
			        netLinkPlayer(emu->link), (int) gba->sio.mode);
		}
		return;
	}
	/* 【主从角色看游戏，不看链路层的 player 号】
	 *
	 * 原来这里用 netLinkPlayer()==0 判「我是主机，不用管」。可走云端房间时
	 * 两端的链路层都是 TCP 主机（播放器号都停在初值 0），于是**两边都走这个
	 * 分支直接 return**：谁都不执行从机收尾、谁都不回推字。现场证据就是
	 * 两端日志同时报 me=0，主机侧 `done want=1 have=0 retries=27` 永远等不到
	 * 回字，`m1=0000`、`pc=0` 一路到底。
	 *
	 * gen8 自己会选举主从：gLink(+0)=isMaster 为 8 表示主机，(+2)=localId。
	 * 这里只认 gLink.isMaster：不是主机就必须走从机路径。 */
	int me = netLinkPlayer(emu->link);
	/* 【必须走 NAV_IW】当前 ROM 的 gLink 实际在 0x03002AF4 + delta（PC path B
	 * 实测 delta=0xD4）。旧代码这里写死绝对地址，读到的是 gLink 前面 0xD4 字节
	 * 的无关数据：某个镜像恰好读到 isMaster=8/localId=0 就直接 return，从不做
	 * 从机收尾、不推总线字，主机永远等不齐 3 个从机（PB18：只有 slot 1 推，
	 * 主机 m1=FFFF、idx 卡在 7/8）。同文件其它 gLink 读取早已统一用 NAV_IW，
	 * 这里漏改是唯一的行为性硬编码。 */
	int gameMaster = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x00u);
	int localId = GBAView8(gba->cpu, NAV_IW(0x03002AF4u) + 0x02u);
	/* 【不能只看 isMaster】
	 *
	 * 云端官方镜像模式的隐藏镜像核是用房主推来的 TYPE_STATE 快照起步的，
	 * 快照里 gLink.isMaster 已经是 8。若照单全收，镜像核会认定「我是主机」
	 * 而直接 return，从不做从机收尾、也从不回推本轮的字；主机侧
	 * netLinkTakePeerWord 就永久 peer-timeout。现场实测：主机轮次 idx=113
	 * 且 to=3491 次超时，镜像核的 idx 一直卡在 38，两核一起掉到 1fps。
	 *
	 * gLink.localId(+2) 才是本局身份：房主为 0，镜像核为 1（PEEK 实测
	 * 可见核 m=8 id=0、镜像核 m=0 id=1）。只有「isMaster==8 且
	 * localId==0」才是真正驱动轮次的主机。 */
	/* 【链路角色优先】path B 的镜像核链路 player=1/2/3，永远是从机：
	 * 收 TYPE_STATE 的对端镜像起步快照里 gLink.isMaster=8/localId=0（快照来自
	 * 远端房主），只看游戏字段就会误判成游戏主机而 early-return，从此不再
	 * 推总线字；另两颗 NPC 镜像却一直推并等广播，主机永远收不齐 3 份
	 * （PB20：slot 1 只在 want=2 推过，slot 2/3 推到 want=134，BCAST 为 0）。
	 * path A 两端链路上都是 player 0，仍必须靠游戏字段区分主从（原逻辑）。 */
	if (me == 0 && gameMaster == 8 && localId == 0) {
		/* 游戏认定自己是主机：轮次由它驱动，这里不管。 */
		if (getenv("MGBAX_SLAVE_DIAG") && sdMaster++ < 6) {
			fprintf(stderr, "SLAVE_DIAG master me=%d gm=%d lid=%d\n", me, gameMaster, localId);
		}
		return;
	}
	/* 3/4 人总线：从机先把自己的字推给主机（主机要收齐才广播），再等广播。
	 * 两人走下面原来的「取对端字 → 收尾 → 回推」路径。 */
	{
		int busPlayers = netLinkBusPlayers(emu->link);
		if (netLinkBusActive(emu->link) && busPlayers >= 2) {
			uint16_t own = emu->sioRoundWordValid ? emu->sioRoundWord
			                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
			emu->sioRoundWordValid = false;
			uint32_t busVals[4];
			uint16_t used = emu->sioIndex;
			int busGot = netLinkBusRound(emu->link, emu->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(emu, -1), &used);
			if (busGot < 0) {
				/* 主机还没广播（还在等别的从机）：快速重挂，绝不拿空槽收尾
				 * —— 一次空槽就会让游戏的 DoHandshake 把 playerCount 清 0。 */
				++emu->sioTimeouts;
				if (emu->toDbg < 30) {
					++emu->toDbg;
					MOBILE_LOGI("BUS slave wait-me me=%d last=%u", me, (unsigned) emu->sioIndex);
				}
				if (timing) {
					mTimingSchedule(timing, &emu->sioSlaveDone, 2048);
					emu->sioSlaveArmed = true;
				}
				return;
			}
			/* 轮次节奏跟随主机：与两人路径用 PUSH.cycles 做的事一样。 */
			{
				uint32_t peerCycles = netLinkBusRoundCycles(emu->link);
				if (peerCycles != 0) {
					if (emu->sioPeerCyclesValid) {
						uint32_t delta = peerCycles - emu->sioPeerCycles;
						if (delta > 4000 && delta < 400000) {
							emu->sioSlavePeriod = delta;
						}
					}
					emu->sioPeerCycles = peerCycles;
					emu->sioPeerCyclesValid = true;
				}
			}
			if (used != emu->sioIndex) {
				++emu->sioMisorder;
				if (emu->sioMisorder < 8) {
					MOBILE_LOGI("BUS slave 跟随主机轮次 me=%d was=%u now=%u n=%u",
					            me, (unsigned) emu->sioIndex, (unsigned) used, emu->sioMisorder);
				}
			}
			emu->sioIndex = used;
			emu->sioHasRemote = true;
			emu->sioRemote = busVals[0];
			completeMultiTransferBus(emu, busVals, busPlayers, cyclesLate);
			emu->sioPushValue = own;
			emu->sioPushIndex = emu->sioIndex;
			emu->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &emu->sioSlaveDone, emu->sioSlavePeriod);
				emu->sioSlaveArmed = true;
			}
			return;
		}
	}
	/* 【快帧分支】LINKUP/块交换完成后不再按墙钟等主机的字（成因见
	 * mobileFastFrame 的注释）。取到新字就照常收尾并回推；取不到就复用上一轮
	 * 对端字收尾，且**不推字、不改轮次号** —— 伪造的轮次若也回推，主机那边
	 * 同一个轮次号会收到两条对端字，严格匹配反而错位。主机确实停摆
	 * （队列空且 800ms 没推过字）时不伪造轮次，落回下面的原路径。
	 * N>0 时改成定长延迟线：只取 k-N，取不到就重挂（不复用旧字）。 */
	if (mobileFastFrameSlave(emu) && emu->sioFastRemoteValid
	    && (netLinkPeerPending(emu->link) > 0 || netLinkPushAgeMs(emu->link) < 800u)) {
		uint32_t delayN = mobileDelayN();
		uint32_t fastRemote = 0;
		uint16_t fastGot = 0;
		uint32_t fastCycles = 0;
		bool cmdGuard = false;
		uint16_t takeMin = emu->sioIndex;
		/* 【对称定长延迟线 N>0】
		 * k 取队列里最新的对端轮次，只消费 k-N 那一格（mobileDelayIndex）。
		 * FIFO 只能从队首取，所以要求深度恰好 > N、即 head == k-N；深度
		 * 不够就说明 k-N 还没到，按「不复用旧字、不喂空槽」处理。
		 * N=0 时整段不生效，下面的取字参数仍是 emu->sioIndex，行为与旧版
		 * 逐字节一致。
		 * 每帧仍然是 9 次 SIO 中断——gen8/link.c:2166-2171 的 LAG 判据数
		 * 的是每帧中断次数（不足 9 次置 LAG_MASTER），不看墙钟，所以延迟
		 * N 轮不会触发它。 */
		if (delayN) {
			int pc = 0;
			unsigned head = 0;
			netLinkPeerHeadInfo(emu->link, &pc, &head);
			uint32_t want = pc > 0
			                ? mobileDelayIndex((uint32_t) head + (uint32_t) pc - 1u, delayN)
			                : 0;
			if (pc <= 0 || (uint32_t) head != want) {
				mobileFastDelayMiss(emu, true, 2048);
				return;
			}
			/* minIndex = head-1：Any 丢弃 index <= minIndex 的字，于是恰好
			 * 消费队首（k-N 那一格），不会越到更新的轮次。 */
			takeMin = (uint16_t) (head - 1u);
		}
		bool haveFast = netLinkTakePeerWordAny(emu->link, takeMin, 0,
		                                       &fastRemote, &fastGot, &fastCycles);
		uint16_t own = emu->sioRoundWordValid ? emu->sioRoundWord
		                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
		if (haveFast || !delayN) {
			emu->sioRoundWordValid = false;
		}
		if (haveFast) {
			emu->sioFastMiss = 0;
			/* 轮距照常从主机的时间戳学（只取更小值，理由见原路径）。 */
			if (fastCycles != 0) {
				if (emu->sioPeerCyclesValid) {
					uint32_t delta = fastCycles - emu->sioPeerCycles;
					if (delta > 4000 && delta < 400000 && delta < emu->sioSlavePeriod) {
						emu->sioSlavePeriod = delta;
					}
				}
				emu->sioPeerCycles = fastCycles;
				emu->sioPeerCyclesValid = true;
			}
			if (fastGot != emu->sioIndex) {
				++emu->sioMisorder;
			}
			emu->sioIndex = fastGot;
			emu->sioFastRemote = fastRemote;
			emu->sioFastRemoteValid = true;
			emu->sioHasRemote = true;
			emu->sioRemote = fastRemote;
			completeMultiTransfer(emu, fastRemote, true, cyclesLate);
			struct mTiming* timing2 = coreTiming(emu);
			uint32_t stamp = timing2 ? mTimingCurrentTime(timing2) : 0;
			/* ROOTHUNT2：发出的字高16位带 APP 队伍 species sidecar 给 PC 解码 */
			MOBILE_CAPTURE_BLOCK_CTX(emu, own);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
			uint16_t outWord = mobileBlockYieldWord(emu, mobileBlockOutWord(emu, own, true));  /* 方案2：逐字推真块帧 */  /* 方案2：块期优先推真块字 */  /* 修复②：块期握手字让位为合法 0 */
			netLinkPush(emu->link, GBA_SIO_MULTI, mobilePartySidecar(emu, outWord), emu->sioIndex, stamp);
			emu->sioPushValue = outWord;
			emu->sioPushIndex = emu->sioIndex;
			emu->sioPushed = true;
		} else if (delayN) {
			/* N>0：k-N 取不到就只重挂，绝不复用旧字 —— 复用一个陈旧字会
			 * 让 gen8 每 8 轮一条命令的逐块校验和（gen8/link.c:2322-2355）
			 * 当场 ck=1。也不喂 0xFFFF 空槽（会把 playerCount 清 0）。 */
			mobileFastDelayMiss(emu, true, 2048);
			return;
		} else {
			++emu->sioFastMiss;
			if (mobileInCmdPhase(emu)) {
				/* CMD-GUARD：块交换期从机是「消费字」方，把 sioFastRemote 旧字
				 * 当本轮真字喂进 completeMultiTransfer 会推进命令窗却没消费真
				 * 字，逐块校验必挂（rem 恒 0）。本轮不收尾、不回推，落回下面
				 * 严格真字等待路径。 */
				++emu->sioCmdGuardRounds;
				cmdGuard = true;
			} else if (battleRelayOn() && inBattleBlockRelay(emu)) {
				/* ROOTHUNT2 B7：战斗 controller 块期从机无真字时——不复用陈旧块字、
				 * 不伪造完成一轮（否则两端 IRQ 数发散 ⇒ 主机 LAG_MASTER），只把本轮
				 * own 字照常推回主机（双向推字），然后重挂等下一轮真字。
				 * label 沿用 emu->sioIndex，与 mobile 现有所有 push 同口径。 */
				++s_mobileBattleRelaySlavePush;
				{
					struct mTiming* t2 = coreTiming(emu);
					uint32_t stamp = t2 ? mTimingCurrentTime(t2) : 0;
					MOBILE_CAPTURE_BLOCK_CTX(emu, own);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
					uint16_t outWord = mobileBlockYieldWord(emu, mobileBlockOutWord(emu, own, true));  /* 方案2：逐字推真块帧 */  /* 方案2：块期优先推真块字 */  /* 修复② 对称让位 */
					netLinkPush(emu->link, GBA_SIO_MULTI, mobilePartySidecar(emu, outWord),
					            emu->sioIndex, stamp);
					emu->sioPushValue = outWord;
					emu->sioPushIndex = emu->sioIndex;
					emu->sioPushed = true;
				}
				/* 不 completeMultiTransfer；落下去走 5311 的重挂 return */
			} else {
				++emu->sioFastReuse;
				++emu->sioFallback;
				completeMultiTransfer(emu, emu->sioFastRemote, true, cyclesLate);
			}
		}
		/* 连续 240 轮一个新字都没拿到，说明对端停摆：解除锁存，下一轮回到
		 * 严格等待，不用越来越旧的字一直喂游戏。 */
		if (emu->sioFastMiss >= 240) {
			emu->sioFastLatched = false;
			emu->sioFastMiss = 0;
		}
		mobileFastLog(emu);
		if (cmdGuard) {
			/* 不重挂 sioSlaveDone、不 return：落到下面严格真字等待路径，
			 * 由它按 slaveWaitMs 等主机本轮真字（sioSlaveArmed 由它负责）。 */
		} else {
			if (timing) {
				uint32_t nextPeriod = netLinkPeerPending(emu->link) > 0
				                      ? 2048u : emu->sioSlavePeriod;
				mTimingSchedule(timing, &emu->sioSlaveDone, nextPeriod);
				emu->sioSlaveArmed = true;
			}
			return;
		}
	}

	uint16_t got = 0;
	uint32_t remote = 0;
	uint32_t peerCycles = 0;
	/* 【轮次号必须由主机单方面决定 —— 从机只跟随】
	 *
	 * 两端的计数器如果各自独立递增，必然发散：从机每轮超时也会推进自己的
	 * 计数器，于是从机的轮次跑到 206 时主机才 95。netLinkTakePeerWord 的
	 * 「(int16_t)(w.index - want) < 0 → 过期丢弃」会把主机的每一条推送都
	 * 判成过期 → 从机永远收不到 → 每轮空等 2500ms → 模拟帧率掉到
	 * 0.03fps → 游戏的 Task_TriggerHandshake 跑不到第 5 个 tick → 链路
	 * 状态卡在 START1 → 双方永远进不了 HANDSHAKE，握手永远完不成。
	 *
	 * 这里放宽成「取队列里最早的一条未消费过的」，并**直接采用主机给的
	 * 轮次号**：主机是链路的时钟源，它的 index 就是全局轮次号。从机回推时
	 * 也用这个号，于是主机那边严格匹配（want == 实收）一次都不会错位。
	 *
	 * 等待窗口分两种：
	 *   - 还没跟主机同步上（一个主机字都没收到过）：窗口短（20ms）。这时
	 *     主机多半还没进俱乐部，主机字会随时到，短窗口保证从机不会被
	 *     一次 2.5 秒的空等冻住（那会把模拟帧率压到 0.03fps，游戏连
	 *     「请稍候」画面都走不到）。
	 *   - 已经同步上了：窗口放宽到 300ms，吸收对端的偶发卡顿。
	 */
	/* 【绝不在这里长时间阻塞模拟线程】
	 *
	 * 原来这里是「阻塞 20ms（还没跟主机同步）/ 300ms（已同步）等主机的字」。
	 * 这一等就把模拟线程冻住了：每 18363 个模拟周期阻塞一次，模拟时间只
	 * 推进 1.1ms 而墙钟走了 20ms，帧率从 60fps 掉到 1.4fps。主机还没进俱乐
	 * 部时从机的游戏干脆冻在标题画面；联机中掉帧则直接打破 gen8「每帧至少
	 * 9 次串行中断」的要求，游戏报「通信错误」。
	 *
	 * 现在改成**非阻塞取字 + 短周期重试**：取不到就 2048 个模拟周期后再试，
	 * 一次也不阻塞。主机每轮推一个字、从机照单全收（队列是 FIFO，轮次天然
	 * 一一对应），从机的时钟不再被墙钟拖住。
	 *
	 * 【跨网例外：从机的游戏有传输在飞时必须阻塞等】
	 * 走服务器隧道时主控每轮要等一个网络往返（实测 142ms 均值、250ms 尖峰），
	 * 主控的模拟时钟在等待里冻结，它的游戏一帧要走 9×160ms 真实时间；而从机
	 * 的游戏照常 60fps 跑——从机一帧只摊到 ~0.1 次 SIO 中断，gen8 的
	 * LinkVSync 数出「每帧不足 9 次」就置 gLink.lag = LAG_MASTER，游戏当场报
	 * 「连接发生了错误」。真机语义是：从机的传输挂着，线路就一直等主机的时
	 * 钟沿。所以这里在**主控的轮次还在密集到达（交换正在进行）**时改为阻塞
	 * 等（窗口自适应 RTT）：从机的一帧因此包含主控一帧的全部轮次，LAG 消
	 * 除，两边的游戏速率重新锁死。交换停了（对端 500ms 没推字）就回到自旋，
	 * 模拟帧率不受影响。 */
	/* 【跨网时从机必须阻塞等；判据不能是本机推字时间】
	 *
	 * 这里原来用「本机 500ms 内推过字」当作「交换正在进行」的判据。可这个
	 * 判据在**第一轮**必然为假：从机还没完成过任何一轮，自然没推过字 →
	 * 走下面的自旋分支 → 每次自旋把模拟时钟推进 2048 cycles（≈0.12ms），
	 * 而墙钟只过去几微秒，等于模拟时间以约 300 倍真实速度狂奔。主机那一个
	 * 字还在路上（一个 RTT），从机这边已经空转出几百上千个游戏帧，gen8 的
	 * LinkVSync 数出「这些帧一次 SIO 中断都没有」→ gLink.lag = LAG_MASTER
	 * → 当场「通信错误……请检查所有的连接」，link 任务直接停掉，之后从机
	 * 再也不写 SIOMLT_SEND，主机收到的全是 0x0000（RECEIVED_NOTHING）。
	 * 实测从机自旋计数 to=1721192，与这个推断完全吻合。
	 *
	 * 而这个事件只有在 netLinkPeerPending() > 0（主机确实推过字）时才会被
	 * 挂上，也就是说「进到这里」本身就证明交换正在进行。所以只要链路还连
	 * 着，就按 RTT 自适应窗口阻塞等——模拟时钟冻结，游戏看不见这段墙钟
	 * 时间，从机的每帧轮次数与主机严格一致，LAG 不会触发。
	 * 真正没联机时事件根本不会被挂上，帧率不受影响。 */
	int slaveWaitMs = sioPipelineWaitMs(emu, -1);
	bool have = netLinkTakePeerWordAny(emu->link, emu->sioIndex, slaveWaitMs, &remote, &got, &peerCycles);
	if (!have) {
		/* 【从机没有对端数据时绝不收尾】
		 *
		 * 真机上 MULTI 的时钟由主机产生：从机在主机没有用时钟扫过它之前，
		 * 这一次传输根本不会结束（Busy 位一直挂着），游戏就那么等着。
		 * 我们这里如果「超时也收尾」，等于凭空多完成了一轮：
		 *   - 给游戏喂了一个空槽（对端 = 0），DoHandshake 看到 slot0 不是
		 *     握手值就把 playerCount 清成 0，握手状态被搅乱；
		 *   - 而且两端的传输次数不再一一对应，主机的轮次号和从机的对不上，
		 *     后面每一轮都错一格。
		 * 所以这里只做一件事：把事件快速重挂一次，等主机的下一个字。 */
		++emu->sioTimeouts;
		if (emu->toDbg < 30) {
			++emu->toDbg;
			MOBILE_LOGI("SIO slave wait-me me=%d last=%u synced=%d",
			            me, (unsigned) emu->sioIndex, emu->sioPeerCyclesValid ? 1 : 0);
		}
		/* 【事件链必须能熄灭】
		 *
		 * 从机轮次事件一旦挂上，这个分支每 2048 cycles（≈0.12ms 模拟时间）
		 * 就会重挂一次；而每次进来都先按跨网等待窗（300~1200ms）阻塞模拟
		 * 线程。对端没在跑联机时（标题画面、柜台，或房间已散但云端隧道仍
		 * 在发按键帧），链路上没有 PKT_PUSH（SIO 字推送包）、peerQ 恒空，
		 * 于是形成「每 0.12ms 模拟时间阻塞近 1 秒墙钟」的循环：实测标题
		 * 画面 1.29fps、单帧 15 秒，与 1.4fps 假死同一病理。
		 *
		 * 判据只认 SIO 字本身：peerQ 空且 ≥800ms 没收到过 PKT_PUSH，就
		 * 认定这一轮不存在，熄灭事件链，模拟线程恢复满速。下一次
		 * serviceLink 看到 peerQ 有字会重新挂上，真正开始联机不受影响。 */
		/* ROOTHUNT2 B7 帧率兜底旋钮：战斗 controller 块期把熄灭宽限从 800ms
		 * 放宽到 relayExtinguishMs()（默认 5000ms，env/property 可配）
		 * ——避免公网高 RTT 下半开死等，同时给块交换更多到达时间。
		 * 真掉链由 netLinkState!=2 → inBattleBlockRelay=false 立即熄灭。 */
		uint32_t extMs = (battleRelayOn() && inBattleBlockRelay(emu))
		               ? relayExtinguishMs() : 800u;
		if (netLinkPeerPending(emu->link) == 0 &&
		    netLinkPushAgeMs(emu->link) >= extMs) {
			emu->sioSlaveArmed = false;
			return;
		}
		if (timing) {
			/* 重试周期取 2048（≈0.12ms 模拟时间）：主机推字之后从机几乎
			 * 立刻就能取到，回推的延迟远小于一轮（18363 cycles）。 */
			mTimingSchedule(timing, &emu->sioSlaveDone, 2048);
			emu->sioSlaveArmed = true;
		}
		return;
	}
	if (peerCycles != 0) {
		/* 【从机的轮次节奏必须跟着主机走】
		 *
		 * gen8 link.c 的 LinkVSync 要求主机每帧至少 9 次 SIO 中断（不足就
		 * gLink.lag = LAG_MASTER），一帧 = 280896 cycles。主机一轮的真实
		 * 周期可以从它推送时带的模拟时钟戳算出来（相邻两轮的差）：战斗阶段
		 * 是 Timer3(197*64=12608) + 传输(5755) = 18363，握手阶段主机每帧
		 * 只有 1 轮，差就是 280896。
		 *
		 * 从机按同样的周期排自己的轮次事件，两边每帧的轮次数才会一致：
		 * 从机多一轮就把 recvQueue 塞爆（queueFull → 通信错误），少一轮
		 * 就把 recvQueue 抽干（receivedNothing → 游戏直接断开）。
		 * 这里直接跟随（不做平滑）：主机的节奏本身就是规律的，平滑反而会
		 * 把「一帧 8 轮紧跟 + 1 轮空档」这种突发节奏抹成平均值，从机的帧
		 * 里轮次数就会忽多忽少。 */
		if (emu->sioPeerCyclesValid) {
			uint32_t delta = peerCycles - emu->sioPeerCycles;
			/* 【周期学习只取最小值】
			 *
			 * 握手阶段主机每帧只推 1 轮，相邻两轮的时间戳差就是整一帧
			 * 280896 cycles。若照单全收，sioSlavePeriod 会从 18363 被抬到
			 * 280896，从机从此每帧只消费 1 轮；而进入战斗后主机每帧推约
			 * 9 轮，队列无限积压（实测 mis 每轮 +1），主机严格匹配取从机
			 * 回字全部超时，两边一起饿死在「请稍候」。
			 *
			 * 只取更小的轮距：学到的值永远不会超过初值 18363（真实战斗
			 * 轮距 12608~18363）。轮距偏小不会凭空多收一轮——队列空时
			 * netLinkTakePeerWordAny 会阻塞等主机下一个字，双方轮次仍然
			 * 一一对应；偏大才会永久落后。 */
			if (delta > 4000 && delta < 400000 && delta < emu->sioSlavePeriod) {
				emu->sioSlavePeriod = delta;
			}
		}
		emu->sioPeerCycles = peerCycles;
		emu->sioPeerCyclesValid = true;
	}
	uint16_t own = emu->sioRoundWordValid ? emu->sioRoundWord
	                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
	emu->sioRoundWordValid = false;
	if (got != emu->sioIndex) {
		/* 轮次跳跃：主机那边跳过了几轮（或者从机刚接上）。不影响正确性
		 * —— 从机跟随主机的号，双方仍然一一对应。 */
		++emu->sioMisorder;
		if (emu->sioMisorder < 8) {
			MOBILE_LOGI("SIO slave 跟随主机轮次 me=%d was=%u now=%u n=%u",
			            me, (unsigned) emu->sioIndex, (unsigned) got, emu->sioMisorder);
		}
	}
	emu->sioIndex = got;
	emu->sioHasRemote = true;
	emu->sioRemote = remote;
	/* 严格路径也要喂「最近一轮真实对端字」：从机的快帧分支（见
	 * sioSlaveDoneEvent 里的 mobileFastFrameSlave 调用）以 sioFastRemoteValid 为
	 * 进入条件，而从机（netLinkPlayer()!=0）永远不会走 beginMultiTransfer →
	 * sioDoneEvent，那里才是另一处置位点。不在这里置位，从机侧的快帧分支
	 * 就永远进不去（门形同不存在，每轮仍按墙钟等主机，2P 只有主机一侧快）。 */
	emu->sioFastRemote = remote;
	emu->sioFastRemoteValid = true;
	completeMultiTransfer(emu, remote, true, cyclesLate);
	/* 把本轮的字回推给主机：就是本轮收尾时游戏自己用的那一个
	 * （SIOMLT_SEND），收发天然一致。轮次号沿用主机的，主机那边严格
	 * 匹配就一定对得上。 */
	struct mTiming* timing2 = coreTiming(emu);
	uint32_t stamp = timing2 ? mTimingCurrentTime(timing2) : 0;
	/* ROOTHUNT2：发出的字高16位带 APP 队伍 species sidecar 给 PC 解码 */
	MOBILE_CAPTURE_BLOCK_CTX(emu, own);  /* ROOTHUNT2 治本：从机真实路径每轮捕获 */
	uint16_t blockWord = mobileBlockYieldWord(emu, mobileBlockOutWord(emu, own, true));  /* 方案2：逐字推真块帧 */  /* 方案2：块期优先推真块字 */  /* 修复② 对称让位 */
	/* 路线A：从机握手保持——对端真字仍是握手字时持续推真 B9A0 给重入 st2 的主机。
	 * 只改 push 字（对端 slot1），不写任何游戏状态；块期由 hold 函数让位。 */
	uint16_t outWord = mobileHandshakeHoldWord(emu, blockWord);
	netLinkPush(emu->link, GBA_SIO_MULTI, mobilePartySidecar(emu, outWord), emu->sioIndex, stamp);
	emu->sioPushValue = outWord;
	emu->sioPushIndex = emu->sioIndex;
	emu->sioPushed = true;
	if (own != LINK_HANDSHAKE_SLAVE && emu->hsPushDbg < 70) {
		++emu->hsPushDbg;
		MOBILE_LOGI("HSP #%u me=%d idx=%u val=%04X reply=1",
		            emu->hsPushDbg, me, (unsigned) emu->sioIndex, own);
	}
	/* 挂上下一轮。
	 *
	 * 对端队列里还有字 = 主机本帧推的轮次没被消费完（gen8 每帧约 9 轮）。
	 * 这时必须紧接着排空，不能等一整个轮距：否则从机每帧只处理 1 轮，
	 * 落后量逐帧累积，主机取从机回字永远超时。队列空了才回到学到的轮距。
	 * 2048 cycles ≈ 0.12ms 模拟时间，远小于一轮，不会插进额外的传输。 */
	if (timing) {
		uint32_t nextPeriod = netLinkPeerPending(emu->link) > 0
		                      ? 2048u : emu->sioSlavePeriod;
		mTimingSchedule(timing, &emu->sioSlaveDone, nextPeriod);
		emu->sioSlaveArmed = true;
	}
}


/* 跨网等待窗：局域网 RTT 1-3ms，800ms 绰绰有余；走服务器隧道 RTT 上百毫秒
 * 还会抖（手机网络尖峰能到秒级），固定 800ms 必然误超时——超时一次就用空槽
 * 收尾，游戏立刻报「连接发生了错误」。等待窗跟随实测 RTT（20 倍余量），
 * 下限仍是局域网的 800ms，上限 20s 防死等。等待期间模拟时钟冻结，游戏自己
 * 不会超时，只是这一轮变慢。 */
static int sioWaitMs(struct MgbaMobile* emu);

/* 本轮到底允不允许阻塞模拟线程。
 *
 * 隧道连着（state==2）不等于对端在跑联机：当对端还停在开机/标题画面时它
 * 一个字都不推，这边若照旧按 sioWaitMs 死等，模拟线程就被按在超时窗里，
 * 整帧不动——实测整屏 4 秒逐字节一致、按键完全不响应，驱动层只能看着它
 * 「假死」。所以只有「对端确实在这条链路上交换字」时才阻塞：
 *   1) 队列里已有对端字 → 阻塞（实际只是取队列，几乎不耗时）；
 *   2) 对端 800ms 内推过字 → 阻塞，但只给半个秒窗（这一轮只是晚到）；
 *   3) 对端完全没动静 → 立刻用空槽收尾，模拟线程照常跑。
 * 第 3 条是这次假死的解药；它不会污染握手以外的轮次，因为握手期对端一定
 * 在推字，条件 1/2 必然命中。 */
static int sioPeerWaitMs(struct MgbaMobile* emu) {
	if (!emu->link || netLinkState(emu->link) != 2) {
		return 0;
	}
	/* 【本机环回必须走短窗】
	 *
	 * 云端官方镜像模式里，可见核与隐藏镜像核是通过 127.0.0.1 环回 SIO
	 * 连起来的（EmulatorActivity.startGBoyLink），实测 RTT 只有几十微秒；
	 * 公网只传按键帧和状态快照，SIO 字从不过公网。原来的 300~1200ms
	 * 跨网等待窗是给「SIO 字真的过公网」准备的，套在本机环回上时，只要
	 * 某一轮两核互等就各自等满 300ms：gen8 每帧 9 轮 → 2.7 秒一帧，
	 * 现场进入握手后掉到 3.5fps、POLL rate 从 2000/s 掉到 130/s。
	 *
	 * 只有确实测到 <5ms 的 RTT 才启用 12ms 短窗；RTT 未测出（0）或偏大
	 * 时一律保持原跨网窗口，避免第一轮公网 RTT 被误判成超时。 */
	uint32_t rttUs = netLinkRttUs(emu->link);
	bool loopback = rttUs != 0u && rttUs < 5000u;
	/* 本机环回保持 12ms 快窗。
	 *
	 * 曾按实测 RTT 尖峰（均值 1.678ms / 尖峰 35.085ms）把窗口抬到
	 * 40~80ms 以避免 ahead 恢复路径被误触发，结果每轮等待付出的墙钟
	 * 时间过多：握手只到 st=2 pc=0、帧率掉到 0.26~5fps，比 12ms 版本
	 * 更差。12ms 版本能稳定到 st=4 pc=2 并走进卡片交换。
	 *
	 * 误超时本身已由主机路径的 `sioIndex = got` 兜住（见
	 * completeMultiTransfer 前的轮次错位分支），不需要靠放大窗口规避。 */
	int shortWaitMs = 12;
	if (netLinkBusActive(emu->link)) {
		/* 星型总线只跑局域网/本机环回。两人跨公网隧道的 300~1200ms 下限会
		 * 把每轮锁步钉在半秒以上：轮次一旦错配，主机等从机字、从机等广播，
		 * 两边都等满窗。给 3 倍实测 RTT，下限 2ms（本机环回 RTT≈0.1ms，
		 * 原 12ms 下限让每个落后轮次都付满 12ms，9 轮/帧把帧率压到约 5fps）；
		 * 字到达时 cond_broadcast 仍会立刻唤醒，LAN（RTT≥3ms×3≈9~12ms）
		 * 行为不变。 */
		uint32_t ms = (netLinkRttUs(emu->link) / 1000u) * 3u;
		if (ms < 2u) {
			ms = 2u;
		}
		if (ms > 120u) {
			ms = 120u;
		}
		return (int) ms;
	}
	if (netLinkPeerPending(emu->link) > 0) {
		/* 队列里有字：阻塞是安全的，但窗口没必要开到 RTT×20（实测会到 3s，
		 * 一轮 3s × 9 轮/帧 = 27s 一帧，画面看起来就是彻底冻结）。1200ms 已经
		 * 覆盖实测 150ms 均值 / 441ms 尖峰的隧道 RTT。 */
		return loopback ? shortWaitMs : 1200;
	}
	if (netLinkPushAgeMs(emu->link) < 800) {
		return loopback ? shortWaitMs : 900;  /* 对端仍在活跃交换，这一轮只是晚到 */
	}
	/* 与 Qt 侧同一条修正：链路刚建立时两端都还没推过字，pushSeenAt=0
	 * 会让上面两条全部落空，于是最需要等一个公网 RTT 的第一轮反而零等待，
	 * 主机按空槽收尾 → 从机回字迟到后无人认领 → 握手停在 START0/START1。
	 * 前 8 轮、头 3 次重试给 900ms 预算；之后恢复 0，避免对端根本没进
	 * 联机时把模拟线程按死（11-08 的假死）。 */
	if (emu->sioWaiting && emu->sioIndex <= 8 && emu->sioRetries < 3) {
		return loopback ? shortWaitMs : 900;
	}
	/* 与 Qt 侧同一条修正：隧道抖动会让「对端 800ms 内推过字」间歇失效，
	 * 零等待 + 100 cycles 重试间隔会在极短时间内耗尽 40 次重试并按空槽
	 * 收尾，破坏玩家数据块校验（隧道轮 brs 全 0 / cnt 恒 0）。游戏确实
	 * 发起了本轮 MULTI 且链路还连着时，给一个跟随实测 RTT 的最小预算。 */
	if (emu->sioWaiting) {
		if (loopback) {
			return shortWaitMs;
		}
		uint32_t ms = rttUs / 1000u * 3u;
		if (ms < 300u) {
			ms = 300u;
		}
		if (ms > 1200u) {
			ms = 1200u;
		}
		return (int) ms;
	}
	return 0;                       /* 对端没在交换：立刻收尾，别冻住模拟线程 */
}

static int sioWaitMs(struct MgbaMobile* emu) {
	uint32_t rttUs = emu->link ? netLinkRttUs(emu->link) : 0;
	uint32_t ms = (rttUs / 1000u) * 20u;
	if (ms < 800) {
		ms = 800;
	}
	if (ms > 20000) {
		ms = 20000;
	}
	return (int) ms;
}

/* 与 Qt 侧同一条按帧流水线：系统属性 mgbax.sio.pipeline=1 开启。
 * 队列里有对端字就零等待消费，队列空才给一次整批预算；字严格按轮次配对。 */
static bool sioPipelineMode(struct MgbaMobile* emu) {
	if (emu->sioPipelineEnabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		rhGetProp("mgbax.sio.pipeline", v);
		emu->sioPipelineEnabled = (v[0] == '1') ? 1 : 0;
#else
		/* Desktop and the local test build share the Qt-side switch name. */
		const char* v = getenv("MGBAX_SIO_PIPELINE");
		emu->sioPipelineEnabled = (v && v[0] == '1') ? 1 : 0;
#endif
	}
	return emu->sioPipelineEnabled != 0;
}

static int sioPipelineWaitMs(struct MgbaMobile* emu, int want) {
	/* 总线不受两人按帧流水线开关影响，始终用局域网短窗。 */
	if (emu->link && netLinkBusActive(emu->link)) {
		return sioPeerWaitMs(emu);
	}
	if (!sioPipelineMode(emu)) {
		return sioPeerWaitMs(emu);
	}
	if (!emu->link || netLinkState(emu->link) != 2) {
		return 0;
	}
	if (netLinkPeerPending(emu->link) > 0) {
		/* 队列非空不等于**本轮**的字已经到：队首常常是后续轮次。只有队首
		 * 正是本轮才零等待，否则照样按 RTT 给等待窗（取字函数自己按轮次
		 * 严格匹配，不再把后续轮次的字喂给这一轮）。 */
		if (want < 0) {
			return 0;
		}
		int qCount = 0;
		unsigned qHead = 0;
		netLinkPeerHeadInfo(emu->link, &qCount, &qHead);
		if (qCount > 0 && (int) qHead == want) {
			return 0;
		}
	}
	uint32_t ms = (netLinkRttUs(emu->link) / 1000u) * 3u;
	if (ms < 500u) {
		ms = 500u;
	}
	if (ms > 4000u) {
		ms = 4000u;
	}
	return (int) ms;
}

static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	if (!emu->sioWaiting) {
		return;
	}
	uint32_t remote = 0;
	uint16_t got = 0;
	/* 3/4 人总线：主机在这一刻收齐所有从机本轮的字，再一次性广播给它们。
	 *
	 * 判据必须是「链路处于总线模式」，不能只看人数：总线里只有一个从机
	 * 连上来时 netLinkBusPlayers() 正好是 2，按人数判会掉进下面的两人直连
	 * 分支，而总线的字根本不进 peerQ，结果永远是「对端没回字」。 */
	{
		int busPlayers = netLinkBusPlayers(emu->link);
		if (netLinkBusActive(emu->link) && busPlayers >= 1
		    && emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			if (busPlayers < 2) {
				busPlayers = 2;   /* 还没从机连上：按「只有自己」收尾 */
			}
			struct GBA* gbaBus = (struct GBA*) emu->core->board;
			uint32_t busVals[4];
			uint16_t used = emu->sioIndex;
			/* V11-S6：BUS 主机本轮出网字也过 sc 相位锁，与 beginMultiTransfer
			 * 的 push/自槽同源（三端对称）。sc 已在起轮捕获，此处只读不重捕。 */
			uint32_t own = mobileBlockOutWord(emu,
			    gbaBus->memory.io[GBA_REG(SIOMLT_SEND)], true);
			int busGot = netLinkBusRound(emu->link, emu->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(emu, (int) emu->sioIndex), &used);
			if (busGot <= 0 && emu->sioRetries < 3 && netLinkState(emu->link) == 2) {
				/* 有从机连着却一个都没收到：它们是慢了一拍，不是没有。
				 * 重试几次再按空槽收尾，否则一次迟到就会把这一轮的握手数据
				 * 变成 0xFFFF，游戏当场报 checksum 错。 */
				++emu->sioRetries;
				struct mTiming* t2 = coreTiming(emu);
				if (t2) {
					mTimingSchedule(t2, &emu->sioDone, 100);
					return;   /* sioWaiting 保持 true */
				}
			}
			emu->sioRetries = 0;
			emu->sioWaiting = false;
			emu->sioHasRemote = busGot > 0;
			emu->sioRemote = busVals[0];
			/* 【path B / LocalBus 握手字保真】与 PC sioDoneEvent 逐字对称：
			 * busGot<=0 重试耗尽后 busVals 全 FFFF，握手期把本轮 own（真
			 * SIOMLT_SEND，已经 mobileBlockOutWord 的 HSBYPASS 保真）回填主机
			 * 自槽，与从机「绝不空槽收尾」对称。只保真真字，不写游戏态。 */
			if (!mobilePathBNativeSioOn() && busGot <= 0 && mobileBusHsPreserveOn()
			    && emu->link && netLinkState(emu->link) == 2u && emu->core) {
				struct GBA* gb = (struct GBA*) emu->core->board;
				if (gb && gb->cpu
				    && GBAView8(gb->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF)
				           == MOBILE_LINK_STATE_HANDSHAKE) {
					int hm = netLinkPlayer(emu->link);
					if (hm >= 0 && hm < 4 && busVals[hm] == 0xFFFFu) {
						busVals[hm] = (uint16_t) own;   /* 真 8FFF/B9A0，读时保真 */
					}
					/* 槽1 回填对端镜像核每轮真产生的 B9A0（真协议字，非 party/信任位），
					 * 只在 abort 丢失两槽且本端是真主机时补，不覆盖真字。 */
					int peerSlot = (hm == 0) ? 1 : 0;
					if (hm == 0 && own == LINK_HANDSHAKE_MASTER && busVals[peerSlot] == 0xFFFFu) {
						busVals[peerSlot] = LINK_HANDSHAKE_SLAVE;
					}
					if (emu->sioOk <= 64u) {
						MOBILE_LOGI("[BUSHS] rearm-slot me=%d idx=%u s0=%04X s1=%04X (host empty-slot preserve)",
						            hm, (unsigned) emu->sioIndex,
						            (hm >= 0 && hm < 4) ? (unsigned) busVals[hm] : 0,
						            (unsigned) busVals[peerSlot]);
					}
				}
			}
			if (busGot <= 0 && emu->toDbg < 40) {
				++emu->toDbg;
				MOBILE_LOGI("BUS host round me=%d idx=%u got=%d n=%d",
				            netLinkPlayer(emu->link), (unsigned) emu->sioIndex, busGot, busPlayers);
			}
			completeMultiTransferBus(emu, busVals, busPlayers, cyclesLate);
			return;
		}
	}
	/* 【快帧分支】LINKUP/块交换完成后不再冻结模拟时钟等对端字（成因见
	 * mobileFastFrame）。主机的轮次本来就由游戏自己驱动（每帧 9 轮），
	 * 这里只是把「每轮 23~32ms 的墙钟等待」换成「0ms 取，取不到复用上一轮
	 * 对端字」，每帧的 SIO 中断次数不变。门不命中时行为与原路径完全一致。 */
	if (mobileFastFrame(emu)) {
		uint32_t delayN = mobileDelayN();
		uint32_t fastRemote = 0;
		uint16_t fastGot = 0;
		if (delayN) {
			/* 【对称定长延迟线 N>0】只认 k-N，k = 本轮（beginMultiTransfer
			 * 已自增）。严格匹配：比 k-N 老的丢弃、比它新的原地等；0ms 窗
			 * 取不到就重挂 sioDone（sioWaiting 保持 true），模拟时钟照常
			 * 推进。**不复用旧字、不喂空槽**——陈旧字会破坏 gen8 每 8 轮
			 * 一条命令的逐块校验和（gen8/link.c:2322-2355），空槽会把
			 * playerCount 清 0。gen8/link.c:2166-2171 的 LAG 判据只数每帧
			 * SIO 中断次数（不足 9 次），重挂不改变每帧的轮次数。 */
			uint32_t want = mobileDelayIndex(emu->sioIndex, delayN);
			bool ok = emu->link &&
			    netLinkTakePeerWord(emu->link, (uint16_t) want, 0, &fastRemote, &fastGot, NULL);
			if (!ok) {
				mobileFastDelayMiss(emu, false, 100);
				return;
			}
			emu->sioFastMiss = 0;
			emu->sioFastRemote = fastRemote;
			emu->sioFastRemoteValid = true;
			emu->sioWaiting = false;
			emu->sioHasRemote = true;
			emu->sioRemote = fastRemote;
			mobileFastLog(emu);
			completeMultiTransfer(emu, fastRemote, true, cyclesLate);
			return;
		}
		/* 【ROOTHUNT 迭代 28】cmd 期不能用严格 want=sioIndex 取字：对端
		 * 推字标签常比本端 sioIndex 领先 1，严格匹配直接 false ⇒
		 * cmdGuard 喂空字 ⇒ 真块字永远留在队列不被消费 ⇒ 主机 rem=0。
		 * 用 loose 入口（只丢已消费过的旧字），有真字就交付。 */
		bool haveFast = emu->link &&
		    netLinkTakePeerWordAny(emu->link, emu->sioIndex, 0, &fastRemote, &fastGot, NULL);
		bool cmdGuard = false;
		if (haveFast) {
			emu->sioFastMiss = 0;
			emu->sioFastRemote = fastRemote;
			emu->sioFastRemoteValid = true;
		} else {
			++emu->sioFastMiss;
			if (mobileInCmdPhase(emu)) {
				/* CMD-GUARD：块交换期绝不能拿陈旧字冒成本轮真字 —— 那会推进
				 * sendCmdIndex/recvCmdIndex 却没消费真字，两端 8 字命令窗错位、
				 * 块永远拼不起来（rem 恒 0）。本轮不收尾，落回下面的严格真字
				 * 等待路径；rem 变 1 后门自动放行。 */
				++emu->sioCmdGuardRounds;
				cmdGuard = true;
			} else if (battleRelayOn() && inBattleBlockRelay(emu)) {
				/* ROOTHUNT2 B7：战斗 controller 块期绝不复用陈旧块字（同 CMD-GUARD
				 * 契约）——陈旧字推进 recvCmdIndex 却没消费真块 ⇒ bufferA[0] 恒 0。
				 * 复用 cmdGuard 的投空字保 IRQ 收尾。 */
				++s_mobileBattleRelayEmpty;
				cmdGuard = true;
			} else if (emu->sioFastRemoteValid) {
				fastRemote = emu->sioFastRemote;
				haveFast = true;
				++emu->sioFastReuse;
				++emu->sioFallback;
			}
		}
		/* 连续 240 轮（约 27 帧）一个新字都没拿到，说明对端停摆：解除锁存，
		 * 下一轮回到严格等待，不用越来越旧的字一直喂游戏。 */
		if (emu->sioFastMiss >= 240) {
			emu->sioFastLatched = false;
			emu->sioFastMiss = 0;
		}
		if (cmdGuard && mobileRhVerbose() && (emu->sioOk <= 40 || (emu->sioOk % 64) == 0)) {
			int qn = 0; unsigned qh = 0;
			netLinkPeerHeadInfo(emu->link, &qn, &qh);
			MOBILE_LOGI("[RHTAKE] CMDGUARD me=%d ok=%u want=%u have=%d got=%u word=%04X q=%d head=%u miss=%u guard=%u",
			            netLinkPlayer(emu->link), (unsigned) emu->sioOk, (unsigned) emu->sioIndex,
			            haveFast ? 1 : 0, (unsigned) fastGot, (unsigned) (uint16_t) fastRemote,
			            qn, qh, (unsigned) emu->sioFastMiss,
			            (unsigned) emu->sioCmdGuardRounds);
		}
		if (cmdGuard) {
			/* 【2026-11-18 ROOTCAUSE fix — "cmd 阶段永不启动 / intr 冻结"】
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
			emu->sioWaiting = false;
			mobileFastLog(emu);
			mobileBlockProbe(emu, emu->sioRemote, "cmdguard");
			completeMultiTransfer(emu, 0, false, cyclesLate);
			return;
		} else {
			emu->sioWaiting = false;
			if (haveFast) {
				/* ROOTHUNT2：快帧分支也解 sidecar（与 PC 4 路径对称覆盖） */
				mobileCapturePeerParty(fastRemote);
				emu->sioHasRemote = true;
				emu->sioRemote = fastRemote;
			}
			mobileFastLog(emu);
			completeMultiTransfer(emu, fastRemote, haveFast, cyclesLate);
			return;
		}
	}
	/* 真的阻塞等待：睡的是真实时间，模拟时钟冻在这里，所以一帧内的传输次数
	 * 还是真机的量级。游戏的 LAG 判定就是数“每帧有几个 SIO 中断”（1P 那边
	 * 少于 9 个就报 LAG_MASTER），一用模拟时间空转去等一个 16ms 的往返，
	 * 一帧就只剩下一次传输，必然被判掉线。 */
	double t0 = (double) wallNowMs();
	/* 【D8 CMD-GUARD】块交换期用「超时不交付未来轮次字」的严格入口，避免把
	 * 第 k+1 轮的块片段当第 k 轮消费（rem 恒 0）；其余阶段行为完全不变。 */
	bool haveRemote = emu->link && (mobileInCmdPhase(emu)
	    ? netLinkTakePeerWordCmd(emu->link, emu->sioIndex, sioPipelineWaitMs(emu, (int) emu->sioIndex), &remote, &got, NULL)
	    : netLinkTakePeerWord(emu->link, emu->sioIndex, sioPipelineWaitMs(emu, (int) emu->sioIndex), &remote, &got, NULL));
	mobileCapturePeerParty(remote);   /* 迭代 50：高 16 位旁路收对端真实 species */
	if (mobileRhVerbose() && (emu->sioOk <= 40 || (emu->sioOk % 64) == 0)) {
		int qn = 0; unsigned qh = 0;
		netLinkPeerHeadInfo(emu->link, &qn, &qh);
		MOBILE_LOGI("[RHTAKE] me=%d st=%u ok=%u want=%u have=%d got=%u word=%04X q=%d head=%u state=%d cmd=%d to=%u",
		            netLinkPlayer(emu->link),
		            emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA
		                ? (unsigned) GBAView8(((struct GBA*) emu->core->board)->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) : 999u,
		            (unsigned) emu->sioOk, (unsigned) emu->sioIndex,
		            haveRemote ? 1 : 0, (unsigned) got, (unsigned) (uint16_t) remote,
		            qn, qh, netLinkState(emu->link), mobileInCmdPhase(emu) ? 1 : 0,
		            (unsigned) emu->sioTimeouts);
	}
	/* 【ROOTHUNT 迭代 39】在取字点（严格路径，先于 completeMultiTransfer/
	 * finishMultiTransfer/SerialCB）直接置 ready-close 标志，并打 PATCH 日志：
	 * before/after 一读即知是条件没命中、地址错、还是写入被覆盖。 */
	if (haveRemote && (uint16_t) remote == 0x5FFFu && emu->core
	    && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gp = (struct GBA*) emu->core->board;
		uint32_t a = NAV_READY_CLOSE_LINK;
		unsigned before = GBAView8(gp->cpu, a);
		GBAPatch8(gp->cpu, a, 1, NULL);
		GBAPatch8(gp->cpu, a + 1u, 1, NULL);
		unsigned after = GBAView8(gp->cpu, a);
		MOBILE_LOGI("[PATCH] rdy remote=%04X addr=%08X before=%u after=%u me=%d cb2=%08X",
		            (unsigned) (uint16_t) remote, (unsigned) a, before, after,
		            netLinkPlayer(emu->link),
		            (unsigned) GBAView32(gp->cpu, NAV_EW(0x02029118u)));
	}
	double waited = (double) wallNowMs() - t0;
	if (waited > 3.0) {
		/* 超过 3ms 就说明这一轮不是「网络瞬时往返」，而是对端真的慢了。
		 * 这个数直接决定模拟时钟被冻住多久（也就决定模拟帧率掉多少）。 */
		emu->sioWaitMax = waited > emu->sioWaitMax ? waited : emu->sioWaitMax;
		emu->sioWaitTotal += waited;
		++emu->sioWaitN;
		if (emu->sioWaitN % 64 == 0) {
			MOBILE_LOGI("WAIT me=%d n=%u avg=%.1fms max=%.1fms",
			            netLinkPlayer(emu->link), emu->sioWaitN,
			            emu->sioWaitTotal / (double) emu->sioWaitN, emu->sioWaitMax);
		}
	}
	if (!haveRemote && emu->link && netLinkState(emu->link) == 2) {
		/* 真的等到超时才记一次：这是「客机没回字」的唯一现场证据。 */
		MOBILE_LOGI("SIO peer-timeout idx=%u me=%d to=%u",
		            (unsigned) emu->sioIndex, netLinkPlayer(emu->link), emu->sioTimeouts + 1);
	}
	if (haveRemote) {
		if (got != emu->sioIndex) {
			++emu->sioMisorder;
			if (emu->sioMisorder < 8) {
				MOBILE_LOGI("SIO 轮次错位 me=%d want=%u got=%u n=%u",
				            0, (unsigned) emu->sioIndex, (unsigned) got, emu->sioMisorder);
			}
			/* 【主机必须对齐到实际收到的轮次号】
			 *
			 * takePeerWord 等待窗耗尽且队首是后续轮次时，会把队首交出来
			 * 并记一次 misorder。这里若只记日志、不更新 sioIndex，主机
			 * 就把「轮次 got 的数据片段」当作「本轮 want 的数据」喂给
			 * 游戏，而下一轮仍从 want+1 推字：训练家卡片块是跨多轮的
			 * 连续数据，整体错一格后校验和必然失败（LINK_ERR ck=1，
			 * 游戏报「通信错误……请检查所有的连接」）。
			 * 从机路径早就有 emu->sioIndex = got 的跟随逻辑，主机路径
			 * 缺这一句。只在错位时生效，正常轮次行为不变。 */
			emu->sioIndex = got;
		}
		emu->sioWaiting = false;
		emu->sioHasRemote = true;
		emu->sioRemote = remote;
		/* 同上：让快帧分支在第一轮锁存时就有可复用的真实字，避免
		 * completeMultiTransfer(…, 0, false) 喂一次空槽（Qt 侧用 sioRemote
		 * 兜这一格，语义相同）。 */
		emu->sioFastRemote = remote;
		emu->sioFastRemoteValid = true;
		completeMultiTransfer(emu, remote, true, cyclesLate);
		return;
	}
	LINK_VERBOSE("SIO multi timeout seq=%u", emu->sioSeq);
	emu->sioTimeouts++;
	/* 【2026-11-18 H3 GEN8-PROTOCOL-TRUTH D2 — SIO IRQ 不得冻结 / 镜像 H2 Qt 修法】
	 * 原实现在「对端还在线」时把 sioDone 重调、sioWaiting 保持 true，最多 40 次
	 * ×100ms（墙钟上限 20s）后**不收尾**就返回。但 completeMultiTransfer 是唯一
	 * 驱动游戏 SerialCB、进而由 GBASIOMultiplayerFinishTransfer（src/gba/sio.c:386-388）
	 * raise GBA_IRQ_SIO 的地方：跳过它 ⇒ gLink.serialIntrCounter 冻结（现场 sic=1）、
	 * DoSend 不再把下一个命令字写进 SIOMLT_SEND、也不再 netLinkPush，两端在握手/cmd
	 * 期互等 ⇒ master 停在 state=2、600 帧 TryLinkTimeout ⇒ rem=0。sioWaiting 保持
	 * true 时 gbaLinkWriteCnt/gbaLinkStart 还拒绝一切新 MULTI 起轮，死锁不可自愈。
	 *
	 * 修法：只给在飞字一个**短窗**（最多 2 次 ×200ms，远小于 600 帧预算），随后
	 * 照常收尾——对端槽投递空字（haveRemote=false ⇒ data[peer]=0xFFFF，gen8
	 * ProcessRecvCmds 没有对应 case 直接忽略），**绝不复用陈旧 0x2222/B9A0**。
	 * 这样每一轮都产生一次真实的 SIO IRQ，游戏状态机/轮次钟继续走，真字到达后
	 * 下一轮自然消费。与 cmd 期 CMD-GUARD「照常收尾、投递空字」同契约。 */
	if (emu->sioRetries == 0) {
		emu->sioRetryWall = wallNowMs();
	}
	/* ROOTHUNT2 B7：战斗 controller 块期跳过在飞短窗，直接投空字收尾，真块下一轮消费 */
	if (!(battleRelayOn() && inBattleBlockRelay(emu)) &&
	    emu->link && netLinkState(emu->link) == 2 && emu->sioRetries < 2 &&
	    (uint32_t) (wallNowMs() - emu->sioRetryWall) < 200u) {
		++emu->sioRetries;
		struct mTiming* t2 = coreTiming(emu);
		if (t2) {
			mTimingSchedule(t2, &emu->sioDone, 100);
			return;
		}
	}
	if (emu->toDbg < 40) {
		++emu->toDbg;
		MOBILE_LOGI("TO #%u seq=%u me=%d stashed=%d",
		            emu->toDbg, emu->sioSeq, netLinkPlayer(emu->link), emu->sioHasRemote ? 1 : 0);
	}
	emu->sioWaiting = false;
	completeMultiTransfer(emu, 0, false, cyclesLate);
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Mobile Link";
	emu->linkEvent.priority = 0x70;
	emu->sioDone.context = emu;
	emu->sioDone.callback = sioDoneEvent;
	emu->sioDone.name = "Mobile SIO Done";
	emu->sioDone.priority = 0x7F;
	emu->sioSlaveDone.context = emu;
	emu->sioSlaveDone.callback = sioSlaveDoneEvent;
	emu->sioSlaveDone.name = "Mobile SIO Slave Done";
	emu->sioSlaveDone.priority = 0x7E;
	emu->sioSlavePeriod = 18363;
	emu->sioSlaveArmed = false;
	emu->sioPeerCyclesValid = false;
	armLinkEvent(emu);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	emu->sioWaiting = false;
	emu->sioSlaveArmed = false;
	emu->sioPeerCyclesValid = false;
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
		mTimingDeschedule(timing, &emu->sioDone);
		mTimingDeschedule(timing, &emu->sioSlaveDone);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->sioWaiting = false;
	/* 复位后游戏会重新做一次主从判定，所以「只有自己」的呈现窗口要重新打开。 */
	emu->sioInitSeen = false;
	armLinkEvent(emu);
}

static uint32_t gbaLinkId(const struct GBASIODriver* driver) {
	UNUSED(driver);
	return 0x4C4B4E41u;
}

static bool gbaLinkLoadState(struct GBASIODriver* driver, const void* state, size_t size) {
	UNUSED(driver);
	UNUSED(state);
	UNUSED(size);
	return true;
}

static void gbaLinkSaveState(struct GBASIODriver* driver, void** state, size_t* size) {
	UNUSED(driver);
	*state = NULL;
	*size = 0;
}

static void gbaLinkSetMode(struct GBASIODriver* driver, enum GBASIOMode mode) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu && emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO mode -> %d", (int) mode);
	}
	LINK_VERBOSE("SIO mode -> %d", (int) mode);
}

static bool gbaLinkHandles(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	return mode == GBA_SIO_MULTI || mode == GBA_SIO_NORMAL_8 || mode == GBA_SIO_NORMAL_32;
}

static int gbaLinkDevices(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	/* 与 gbp.c 的语义一致：连着的“对端”数量（不含自己）。两边 2 人联机
	 * 时这里是 1，内核才会用 2P 的传输周期；填 2 会按 3P 算，每次传输
	 * 比真机慢 50%，游戏的超时窗口就对不上了。
	 *
	 * 3/4 人总线按实际人数上报（players-1），内核才会用 3P/4P 的周期 ——
	 * 一直返回 1 会让每一轮都比真机短，游戏数出的每帧轮次数对不上。 */
	if (emu && netLinkBusActive(emu->link)) {
		int players = netLinkBusPlayers(emu->link);
		if (players > 2) {
			return players - 1;
		}
	}
	return 1;
}

static int gbaLinkDeviceId(struct GBASIODriver* driver) {
	return netLinkPlayer(((struct GbaLinkDriver*) driver)->emu->link);
}

static bool mobileRhVerbose(void);   /* 定义见下方 pollLink 区块（仅日志门） */

static bool beginMultiTransfer(struct MgbaMobile* emu, struct GBASIODriver* driver, const char* who) {
	if (!emu->link || !emu->linkAttached || !emu->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return false;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	mobileCaptureBlockPhase(emu);  /* V1：起轮捕获 sc，自槽/push 同相位同源 */
	mobileCaptureBlockWord(emu, local);  /* S5 打点对齐：起轮捕获真块字（与 PC beginMultiTransfer 对称） */
	/* 【path A 主机自槽 = 主握手字】镜像 Qt beginMultiTransfer 的 13:20 修正：
	 * DoSend 可能在补位之后才把本轮字写成 B9A0/0，而主机 DoHandshake 要求
	 * tempRecvBuffer[0]==0x8FFF（gen8/link.c:2289），否则主机数不出第 2 个
	 * 玩家、pc 恒 0。起轮这一刻把 local 定死成 0x8FFF，自槽与 netLinkPush
	 * 用同一个值，两端看到的主机字一致。只在 state==2（HANDSHAKE）生效：
	 * state=3 是主机 INIT_TIMER、>=4 已进入命令/块交换，强制会冲掉真实字。 */
	if (mobileForceHandshake() && !mobileInBattleStartup(emu)
	    && netLinkPlayer(emu->link) == 0
	    && GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) == 2u) {
		local = LINK_HANDSHAKE_MASTER;
	}
	/* 【ROOTHUNT CMD-HANDOFF】state>=4 的残留握手字(8FFF/B9A0)绝不能出网：
	 * APPHUNT-A2 XFER#15 主机在 st=4 仍推 B9A0，从机 sioWordOrEmpty 据此
	 * 回显 B9A0（XFER#16 peer=B9A0），gen8 checksum 轮读到陈旧字 ⇒
	 * st=0x2868(0x2000) ⇒ CloseLink。gen8 在 state4 的 DoSend 只会写
	 * 命令字或 0（空队列），这里把残留握手字换成合法的空队列字 0。 */
	if (GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) >= 4u
	    && (local == LINK_HANDSHAKE_MASTER || (uint16_t) (local & ~LINK_HANDSHAKE_SLAVE_MASK) == LINK_HANDSHAKE_SLAVE)) {
		/* A2: 残留 B9A0 出网 ⇒ 从机回显 ⇒ checksum 错。
		 * FIX4: 残留 8FFF 持续点亮从机保持 ⇒ 从机 BBBB 块首被顶掉。
		 * state>=4 的握手字一律换成合法空队列字 0；自槽校验由 mobile
		 * CS_FORGE 保证。 */
		if (mobileRhVerbose() && emu->hsDbg < 900) {
			MOBILE_LOGI("[RHCMDSEEN] suppress stale handshake local=%04X -> 0000 idx=%u ok=%u",
			            local, (unsigned) emu->sioIndex, (unsigned) emu->sioOk);
		}
		local = 0;
	}
	/* 【自槽同源】推给对端的 local 与投递给本机游戏的槽必须是同一个字。
	 * 握手期(state<4)的 0 是「游戏还没写字」的空槽，投递 0xFFFF；state>=4
	 * 时 0 是 DoSend 空队列的合法命令字，必须原样投递（否则两端 checksum
	 * 不一致，badChecksum 拆链）。与 Qt 侧 sioSelfSlot / sioWordOrEmpty
	 * 的口径一致，但主机不参与 sioHsHold（保持只对从机生效）。 */
	emu->sioSelfSlot = mobileBlockOutWord(emu,
	    (local || GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF) >= 4u)
	    ? local : 0xFFFFu, false);  /* V11-S6/V2：主机自槽与 push 走同一 sc 块帧字 */
	emu->sioSelfSlotValid = true;
	++emu->sioIndex;
	emu->sioWaiting = true;
	emu->sioRetries = 0;
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return false;
	}
	emu->sioStartCycle = mTimingCurrentTime(timing);
	/* 1P 是产生时钟的一方，它在写 SIOCNT 起传输这一刻，本轮要发的字早就由游戏
	 * 写进 SIOMLT_SEND 了（gen8 的 DoSend 在中断处理里写、StartTransfer 之后
	 * 才写 SIOCNT），所以这里推出去的就是本轮的真值 —— 而且只推这一次。
	 * 一轮推两次（例如再让轮询去补推一个 SIOIndex+1）就会把「下一轮的槽位」提前
	 * 填上这一轮的旧值，对端按轮次取的时候正好错位一格。 */
	if (mobileRhVerbose() && (emu->sioOk <= 40 || (emu->sioOk % 64) == 0)) {
		MOBILE_LOGI("[RHPUSH] me=%d idx=%u local=%04X selfSlot=%04X state=%u sqc=%u pq=%d",
		            netLinkPlayer(emu->link), (unsigned) emu->sioIndex, (unsigned) local,
		            (unsigned) emu->sioSelfSlot,
		            (unsigned) GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF),
		            (unsigned) GBAView8(gba->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_SENDQ_CNT_OFF),
		            netLinkPeerPending(emu->link));
	}
	if (!emu->sioPushed || emu->sioPushIndex != emu->sioIndex) {
		/* V11-S6/V2：主机 push 也过 mobileBlockOutWord，与自槽同 sc 同源（三端对称） */
		uint16_t pushWord = mobileBlockOutWord(emu, local, true);
		/* ROOTHUNT2：补偿 push 也带 species sidecar（覆盖所有出口） */
		netLinkPush(emu->link, GBA_SIO_MULTI, mobilePartySidecar(emu, pushWord), emu->sioIndex, emu->sioStartCycle);
		emu->sioPushValue = pushWord;
		emu->sioPushIndex = emu->sioIndex;
		emu->sioPushed = true;
	}
	mTimingDeschedule(timing, &emu->sioDone);
	/* 传输周期必须按真机的 115200 算（5755 cycles），不能沿用内核把波特率
	 * 位清零之后的旧值 —— 那是 63427 cycles，会让主机每帧只有 3.7 轮，
	 * 达不到 gen8 link.c 要求的 9 轮/帧，直接被判 LAG_MASTER。 */
	uint16_t siocnt = (uint16_t) ((driver->p->siocnt & ~0x0003u) | 0x0003u);
	mTimingSchedule(timing, &emu->sioDone, GBASIOTransferCycles(GBA_SIO_MULTI, siocnt, gbaLinkDevices(driver)));
	if (emu->sioKick < 200) {
		++emu->sioKick;
		MOBILE_LOGI("SIO begin (%s) idx=%u local=%04X", who, emu->sioIndex, local);
	}
	return true;
}

static uint16_t gbaLinkWriteCnt(struct GBASIODriver* driver, uint16_t value) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO CNT <- %04X (mode %d, id %d)", value,
		            driver->p ? (int) driver->p->mode : -1,
		            netLinkPlayer(emu->link));
	}
	if (driver->p && driver->p->mode == GBA_SIO_MULTI) {
		/* 内核只在 1P（id==0）写 start 位时调 _startTransfer，2P..4P 那一路
		 * 在 sio.c 里是 TODO。真实硬件里从机不产生时钟，它的数据是在主机
		 * 的时钟里被同时采样的，所以从机只需要：Busy 立起来之后等主机的
		 * 那一次传输请求，请求一到就连同对端数据一起收尾。这里记下 Busy
		 * 起始时刻，供看门狗兜底（主机迟迟不发请求时至少别把游戏挂死）。 */
		/*
		 * 内核只把 SIOCNT 里 bit7（Busy）的上升沿当成“开始传输”。可 Pokemon
		 * 系的联机代码发起一次多机传输时写的是 0x600F：IRQ 位（bit14）置起、
		 * baud=3，Busy 留给硬件去置。这种写法在内核那一支根本不会调
		 * _startTransfer，Busy 也就永远不落，游戏只能一路空转到通信超时。
		 * 这里把 bit14 的上升沿与 bit7 的上升沿都当成一次传输请求。
		 */
		bool wasBusy = (driver->p->siocnt & 0x0080) != 0;
		bool nowBusy = (value & 0x0080) != 0;
		bool irq = (value & 0x4000) != 0;
		/* 内核只把 busy(bit7) 的上升沿当成“开始传输”。可 Pokemon 系联机代码
		 * 发起一次 MULTI 传输时写的是 0x600F：IRQ(bit14) 置起、Busy 不置，内核
		 * 那一支（1P 才走、2P 是 TODO）根本不会起传输，Busy 也永远不落，游戏
		 * 只能一路空转到通信超时。这里把“busy 上升沿”和“IRQ 置位且当前没有挂起
		 * 的传输”都当成一次发起请求。关键点：0x600F 每次都这么写，bit14 在第一次
		 * 之后再没有上升沿，所以必须靠“IRQ 置位 + !sioWaiting”来持续触发，否则
		 * 除第一次外所有传输都起不来。!sioWaiting 守卫保证同一次传输不会被发起两次。 */
		bool wantStart = nowBusy || (irq && !emu->sioWaiting);
		if (emu->sioDbg < 400) {
			++emu->sioDbg;
			MOBILE_LOGI("SIO CNT mode=MULTI val=%04X busy=%d irq=%d attached=%d waiting=%d",
			            value, nowBusy, irq, emu->linkAttached, emu->sioWaiting);
		}
		if (wantStart) {
			struct mTiming* timing = coreTiming(emu);
			if (timing) {
				emu->sioBusyCycle = mTimingCurrentTime(timing);
			}
			if (emu->sioKick < 400) {
				++emu->sioKick;
				MOBILE_LOGI("SIO kick busy=%d irq=%d attached=%d waiting=%d id=%d",
				            nowBusy, irq, emu->linkAttached, emu->sioWaiting,
				            netLinkPlayer(emu->link));
			}
			if (!emu->sioWaiting && netLinkPlayer(emu->link) == 0) {
				/* 只有 1P 真的发起传输；从机的传输由 1P 的那一次驱动，
				 * 见 serviceLink。 */
				beginMultiTransfer(emu, driver, nowBusy ? "busy" : "irq");
			}
			else if (!emu->sioWaiting && netLinkPlayer(emu->link) != 0 &&
			         emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
				struct GBA* g = (struct GBA*) emu->core->board;
				emu->sioRoundWord = g->memory.io[GBA_REG(SIOMLT_SEND)];
				emu->sioRoundWordValid = true;
				mobileCaptureBlockPhase(emu);  /* V1：从机起轮捕获 sc，自槽/push 同相位同源 */
				mobileCaptureBlockWord(emu, emu->sioRoundWord);  /* 方案2：9 拍里捕获真块字 sticky */
				/* 从机自槽同样用起轮这一刻扣下的字（镜像 Qt sioSelfSlot），
				 * 与回推给主机的 own 同源；收尾读实时 SIOMLT_SEND 会错位一格。 */
				unsigned st = GBAView8(g->cpu, NAV_IW(MOBILE_GLINK_STATE) + MOBILE_GLINK_STATE_OFF);
				emu->sioSelfSlot = mobileBlockOutWord(emu, mobileBlockYieldWord(emu,
				    (emu->sioRoundWord || st >= MOBILE_LINK_STATE_CONN) ? emu->sioRoundWord : 0xFFFFu), false);  /* 方案2：selfSlot 与 push 帧字同源 */
				emu->sioSelfSlotValid = true;  /* 方案2：块期 selfSlot 与 push 块字同源 */
				/* 路线A：此处是【起轮快照】，emu->sioRemote 还是上一轮字。
				 * 握手保持不在这一刻套用（否则握手字→命令字跃迁轮会把陈旧
				 * 8FFF 误当本轮真字，自槽与出网字不一致→badChecksum）；
				 * hold 统一在收尾 data[me] 与 push 处用【本轮】真对端字套用。 */
			}
		}
		uint16_t out = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
		/* 【波特率修复 —— 直接决定能不能连上】
		 *
		 * 内核 GBASIOWriteSIOCNT 的 MULTI 分支第一句就是
		 *     value &= 0xFF83;
		 * 0xFF83 把 bit0/bit1（波特率）清掉了，而后面 `value |= sio->siocnt &
		 * 0x00FC` 只把 bit2..7 粘回来，**波特率永远补不回来**。于是
		 * GBASIOMultiplayerGetBaud(siocnt) 恒为 0，传输周期取
		 * GBASIOCyclesPerTransfer[0][connected]：
		 *     baud0 = 63427 cycles（真机 115200 只要 5755）
		 *
		 * 这一条对游戏是致命的。gen8 link.c 的 LinkVSync 要求主机每帧
		 * 至少 9 次 SIO 中断，否则直接 gLink.lag = LAG_MASTER（游戏报
		 * 「通信错误…链接是坏的还是终端不匹配？」）。主机一轮的周期 =
		 * 传输周期 + Timer3(197*64=12608)：
		 *     baud=0 : 63427+12608 = 76035 → 每帧 280896/76035 = 3.7 轮 ❌
		 *     baud=3 :  5755+12608 = 18363 → 每帧 280896/18363 = 15.3 轮 ✅
		 * 也就是说，仅仅因为内核漏掉了波特率位，主机就永远达不到游戏要的
		 * 9 轮/帧，握手之后的每一条链路都会以「通信错误」收场。
		 *
		 * 修法：驱动把波特率位补回 115200（游戏自己写的 EnableSerial()
		 * 就是 0x6003 = MULTI|115200|IRQ，本来就是 3），内核丢的信息由我们
		 * 还原，行为与真机一致。 */
		out = (uint16_t) ((out & ~0x0003u) | 0x0003u);
		/* 【终端位：Slave(bit2)/Ready(bit3)/Id(bit4-5)】
		 *
		 * gen8 link.c 的 CheckMasterOrSlave()：
		 *   terminals = *(vu32*)REG_ADDR_SIOCNT & (SIO_MULTI_SD|SIO_MULTI_SI);
		 *   isMaster = (terminals == SIO_MULTI_SD && gLink.localId == 0);
		 * 其中 SIO_MULTI_SD=0x0008(Ready)、SIO_MULTI_SI=0x0004(Slave)。
		 * 也就是 **「Slave=0 且 Ready=1 且 localId=0」才是主机**，
		 * 从机是 Slave=1。和真机一致：主机产生时钟，自己的 SI 端不是从端。
		 *
		 * 内核 GBASIOWriteSIOCNT 的 MULTI 分支：
		 *   value &= 0xFF83;
		 *   value = SetSlave(value, id || !connected);
		 *   value = SetId(value, id);
		 *   value |= sio->siocnt & 0x00FC;      <-- 把旧 bit2..7 粘回来
		 * 那个 |= 让 Slave/Ready 位变成「粘」的：写过一次就再也清不掉。
		 * 所以终端位必须由驱动每次显式改写，不能依赖内核。
		 *
		 * 之前这里还留着一个「只有自己(alone)窗口」的补丁：挂载后的第一笔
		 * MULTI 写入按 Slave=1 呈现，之后才切回按 player 强制。那是错的 ——
		 * 它把主机在俱乐部握手时唯一一次决定主从的写入也变成了 Slave=1，
		 * 于是两端都判成从机、双方都发 0xB9A0，永远等不到主机的 0x8FFF，
		 * 表现就是「大厅连上了、游戏里却卡在请稍候」。
		 *
		 * 现在改成**由链路真实状态决定**：
		 *   传输层还没连上 → 总线上只有自己 → Slave=1（游戏据此知道还没伙伴）
		 *   连上了且本机是 0 号 → Slave=0（主机）
		 *   连上了且本机是 1 号 → Slave=1（从机）
		 * 游戏在 HANDSHAKE 态每一帧都会重新读 SIOCNT，所以只要值是对的，
		 * 什么时候连上的都能纠正过来（见 serviceLink 里的主动改写）。 */
		if (emu->linkAttached && emu->link) {
			int me = netLinkPlayer(emu->link);
			bool up = netLinkState(emu->link) == 2;   /* LINK_CONNECTED */
			bool slave = !up || me != 0;
			out = GBASIOMultiplayerSetSlave(out, slave);
			out = GBASIOMultiplayerSetId(out, up ? me : 0);
			if (emu->sioDbg < 400) {
				++emu->sioDbg;
				MOBILE_LOGI("SIO term: up=%d me=%d slave=%d out=%04X", up ? 1 : 0, me,
				            slave ? 1 : 0, out);
			}
		}
		if (emu->sioDbg < 400) {
			++emu->sioDbg;
			MOBILE_LOGI("SIO CNT out=%04X (slave=%d ready=%d id=%d)", out,
			            (out & 0x0004) ? 1 : 0, (out & 0x0008) ? 1 : 0,
			            netLinkPlayer(emu->link));
		}
		return out;
	}
	if (driver->p && (driver->p->mode == GBA_SIO_NORMAL_8 || driver->p->mode == GBA_SIO_NORMAL_32)) {
		return GBASIONormalFillSi(value);
	}
	return value;
}

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver* driver, uint16_t value) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO RCNT <- %04X (mode %d)", value,
		            driver->p ? (int) driver->p->mode : -1);
	}
	return value;
}

static bool gbaLinkStart(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->hsStartDbg < 24) {
		/* 数据阶段的 SIO_START 就是 Timer3 驱动链的心跳，跟着 HSX 一起看。 */
		++emu->hsStartDbg;
		MOBILE_LOGI("HSS me=%d start (mode %d) waiting=%d idx=%u",
		            netLinkPlayer(emu->link), driver->p ? (int) driver->p->mode : -1,
		            emu->sioWaiting, (unsigned) emu->sioIndex);
	}
	if (!emu->link || !emu->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return true;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return true;
	}
	if (emu->sioWaiting) {
		/* 宝可梦发起一次传输会连写两笔 SIOCNT：先 0x600F（IRQ 触发，writeCnt
		 * 已经 begin 并发出 REQ），再置 Busy 走到这里。第二次 begin 会顶掉
		 * 应答序号、让对端多收一次请求，直接沿用第一次的即可。 */
		return false;
	}
	if (netLinkPlayer(emu->link) != 0) {
		/* 从机置 Busy 也不发起：它的传输由 1P 的那一次驱动。 */
		return true;
	}
	if (!beginMultiTransfer(emu, driver, "master")) {
		return true;
	}
	/* 完成由本驱动负责（网络应答到达时写 SIOMULTI 并发 SIO 中断）。 */
	return false;
}

/* 只在没连上对端（走内核默认调度）时被调用：用最近一次对端数据收尾即可，
 * 传输本身不能在这里等网络。 */
static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	data[0] = data[1] = data[2] = data[3] = 0xFFFF;
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (emu->sioHasRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) emu->sioRemote;
	}
}

static uint8_t gbaLinkFinish8(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
	uint32_t remote = 0xFFu;
	/* 不能重试：重发 REQ 会让对端的请求队列多出一轮、双方向量错位。等待窗
	 * 自适应 RTT（见 sioWaitMs），跨网尖峰时宁可慢不可错。 */
	netLinkExchange(emu->link, GBA_SIO_NORMAL_8, local, &remote, sioWaitMs(emu));
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(emu->link, GBA_SIO_NORMAL_32, local, &remote, sioWaitMs(emu));
	return remote;
}

static bool gbLinkInit(struct GBSIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Mobile Link";
	emu->linkEvent.priority = 0x70;
	armLinkEvent(emu);
	return true;
}

static void gbLinkDeinit(struct GBSIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
	}
}

static void gbLinkWriteSb(struct GBSIODriver* driver, uint8_t value) {
	UNUSED(driver);
	UNUSED(value);
}

static uint8_t gbLinkWriteSc(struct GBSIODriver* driver, uint8_t value) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
		if (GBRegisterSCIsEnable(value) && GBRegisterSCIsShiftClock(value)) {
			uint8_t local = driver->p->p->memory.io[GB_REG_SB];
			uint32_t remote = 0xFFu;
			if (netLinkExchange(emu->link, 0, local, &remote, sioWaitMs(emu))) {
				driver->p->pendingSB = (uint8_t) remote;
			}
		}
	return value;
}

static void prepareGbaDriver(struct MgbaMobile* emu) {
	struct GBASIODriver* d = &emu->gbaLink.d;
	memset(d, 0, sizeof(*d));
	emu->gbaLink.emu = emu;
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

static void prepareGbDriver(struct MgbaMobile* emu) {
	struct GBSIODriver* d = &emu->gbLink.d;
	memset(d, 0, sizeof(*d));
	emu->gbLink.emu = emu;
	d->init = gbLinkInit;
	d->deinit = gbLinkDeinit;
	d->writeSB = gbLinkWriteSb;
	d->writeSC = gbLinkWriteSc;
}

static void detachLink(struct MgbaMobile* emu) {
	/* 掉线/关链的第一现场：从机轮次事件马上会被 linkAttached 挡在门口
	 * （sioSlaveDoneEvent 入口），mobileFastFrame 再也跑不到，所以快帧状态
	 * 必须在这里清 —— 否则重连第一轮会拿断线前的旧字去收尾 LINKUP 块。 */
	sioFastReset(emu);
	if (!emu->linkAttached || !emu->core) {
		emu->linkAttached = false;
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) emu->core->board)->sio, NULL);
	} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		GBSIOSetDriver(&((struct GB*) emu->core->board)->sio, NULL);
	}
	emu->linkAttached = false;
	emu->sioInitSeen = false;
}

/* 把 SIOCNT 的终端位（Slave/Ready/Id）改写成「链路当前真实的样子」。
 *
 * 游戏在 HANDSHAKE 态每帧都会读一次 SIOCNT 来定主从
 * （CheckMasterOrSlave），但它只在少数几处写 SIOCNT —— 也就是说，
 * 「链路什么时候连上的」和「游戏什么时候读 SIOCNT」两者不一定碰上。
 * 所以除了每次写入时由 gbaLinkWriteCnt 改写之外，还要在链路状态变化的
 * 时刻主动把寄存器改对，否则游戏会一直读到内核留下的旧值。
 *
 * 绝不碰 0x2000（MULTI 模式位）：内核只有在模式位变化时才切模式，提前置上
 * 会让内核以为模式没变，游戏的第一次 0x2000 写入就切不到 MULTI 上去。
 */
static void applyLinkTerminalBits(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	bool up = emu->link && netLinkState(emu->link) == 2;
	uint16_t siocnt = gba->sio.siocnt;
	uint16_t want = siocnt;
	want = GBASIOMultiplayerSetSlave(want, !up || me != 0);
	want = GBASIOMultiplayerSetId(want, up ? me : 0);
	want = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(want));
	want = (uint16_t) ((want & ~0x0003u) | 0x0003u);   /* 波特率补回 115200 */
	if (want != siocnt) {
		MOBILE_LOGI("SIOCNT term patch: up=%d me=%d %04X -> %04X",
		            up ? 1 : 0, me, siocnt, want);
		gba->sio.siocnt = want;
	}
}

static void attachLink(struct MgbaMobile* emu) {
	/* 【ROOTHUNT】入口/早退取证：drv=0 的直接原因只有这三种。 */
	{
		static uint32_t an;
		if (mobileRhVerbose() && (++an <= 12 || (an % 256) == 0)) {
			MOBILE_LOGI("[RHATTACH] n=%u core=%d attached=%d link=%d pl=%d lock=%d",
			            an, emu->core ? 1 : 0, emu->linkAttached ? 1 : 0,
			            emu->link ? netLinkState(emu->link) : -1,
			            emu->link ? netLinkPlayer(emu->link) : -1,
			            emu->lockstepSlot ? 1 : 0);
		}
	}
	if (!emu->core || emu->linkAttached || netLinkState(emu->link) != 2) {
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		int me = netLinkPlayer(emu->link);
		prepareGbaDriver(emu);
		GBASIOSetDriver(&gba->sio, &emu->gbaLink.d);
		/* 游戏可能在挂载之前就已进入 HANDSHAKE，CheckMasterOrSlave 读到的还是
		 * 「无驱动」时代的 SIOCNT（Slave=1）。挂载这一刻把终端位改写成联机
		 * 线会话的真值，游戏下一帧重新判定主从。
		 * 注意这里绝不能带上 0x2000（MULTI 模式位）：内核只有在模式位变化时
		 * 才切模式，提前置上会让内核以为模式没变，游戏的第一次 0x2000 写入
		 * 就切不到 MULTI 模式上去。 */
		applyLinkTerminalBits(emu);
		MOBILE_LOGI("SIOCNT patched at attach: id=%d %04X",
		            me, gba->sio.siocnt);
		emu->linkAttached = true;
	} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		prepareGbDriver(emu);
		GBSIOSetDriver(&((struct GB*) emu->core->board)->sio, &emu->gbLink.d);
		emu->linkAttached = true;
	}
	if (emu->linkAttached) {
		emu->sioOk = 0;
		emu->sioPeak = 0;
		emu->sioTimeouts = 0;
		emu->sioFallback = 0;
		emu->sioWaiting = false;
		emu->sioBusyCycle = 0;
		emu->sioIndex = 0;
		emu->sioPushed = false;
		emu->sioPushValue = 0;
		emu->sioPushIndex = 0;
		emu->sioMisorder = 0;
		emu->sioHasRemote = false;
		emu->sioHsHoldArmed = false;
		emu->sioHsHoldLeft = 0;
		emu->sioFastLatched = false;
		emu->sioFastMiss = 0;
		emu->sioFastRemote = 0;
		emu->sioFastRemoteValid = false;
		emu->sioFastN = 0;
		emu->sioFastReuse = 0;
		emu->sioCmdGuardRounds = 0;
		emu->sioCmdFrameAligned = false;
		emu->sioLastAlignHeader = 0;
		emu->sioInitSeen = false;
		emu->sioEvtDbg = 0;
		emu->sioTakeDbg = 0;
		emu->sioInDbg = 0;
		emu->sioSkipDbg = 0;
		emu->sioSlaveDoneDbg = 0;
		emu->hsDbg = 0;
		emu->hsPushDbg = 0;
		emu->hsStartDbg = 0;
		emu->lkqFrames = 0;
		MOBILE_LOGI("Link attached as P%d", netLinkPlayer(emu->link) + 1);
	}
}

/* 【ROOTHUNT 移动端链路启动取证】APPNAVDEFINITIVE 全场 SIO poll 都是
 * `drv=0 wait=0` ⇒ g->sio.driver 一直没挂上。这一行把「为什么没挂」摊开：
 *   link = netLinkState(2=CONNECTED) / pl = 链路槽位 / lock = lockstepSlot
 *   up = link==2 / attached = emu->linkAttached / drv = 引擎 sio.driver 是否挂上
 *   gst/gim/sic = 游戏的 state/isMaster/sic / wait = sioWaiting / ok = sioOk
 * 头 30 行 + 签名变化时各打一条。 */
/* 【ROOTHUNT 日志门】默认关闭，避免 [RHSTART]/[RHATTACH] 把帧率拖垮；
 * 纯日志开关，不改变任何链路行为。 */
static bool mobileRhVerbose(void) {
	static int v = -1;
	if (v < 0) {
#ifdef __ANDROID__
		char pv[PROP_VALUE_MAX] = {0};
		/* ROOTHUNT2 前缀统一：driver 下发 debug.mgbax.link.rh_verbose（debug.*
		 * 前缀绕 A14 SELinux），此前读 mgbax.link.rh_verbose 永远空 ⇒ 诊断全关。 */
		rhGetProp("debug.mgbax.link.rh_verbose", pv);
		v = (pv[0] == '1') ? 1 : 0;
#else
		const char* e = getenv("MGBAX_RH_VERBOSE");
		v = (e && atoi(e) == 1) ? 1 : 0;
#endif
	}
	return v != 0;
}

static void mobileStartupTrace(struct MgbaMobile* emu) {
	static uint32_t mn;
	static int mPrevSig = -1;
	if (!mobileRhVerbose()) {
		return;
	}
	uint32_t seq = ++mn;
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* g = (struct GBA*) emu->core->board;
	int link = emu->link ? netLinkState(emu->link) : -1;
	int pl = emu->link ? netLinkPlayer(emu->link) : -1;
	unsigned gst = GBAView8(g->cpu, PEEK_LINK + PEEK_LK_STATE);
	unsigned gim = GBAView8(g->cpu, PEEK_LINK + PEEK_LK_ISMASTER);
	unsigned sic = GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SICTR);
	int drv = g->sio.driver ? 1 : 0;
	int sig = (link << 16) | ((pl & 3) << 14) | ((int) gst << 8) | (drv << 7)
	          | (emu->linkAttached ? 64 : 0) | (emu->lockstepSlot ? 32 : 0)
	          | ((gim == 8u) ? 16 : 0) | (int) (sic & 15u);
	if (seq <= 30 || sig != mPrevSig || (seq % 512) == 0) {
		MOBILE_LOGI("[RHSTART] n=%u link=%d pl=%d lock=%d up=%d attached=%d drv=%d gst=%u gim=%u sic=%u wait=%d ok=%u sig=%d",
		            seq, link, pl, emu->lockstepSlot ? 1 : 0, link == 2 ? 1 : 0,
		            emu->linkAttached ? 1 : 0, drv, gst, gim, sic,
		            emu->sioWaiting ? 1 : 0, (unsigned) emu->sioOk, sig);
		mPrevSig = sig;
	}
}

static void pollLink(struct MgbaMobile* emu) {
	if (!emu->link) {
		return;
	}
	bool up = netLinkState(emu->link) == 2;
	/* 复位（core.reset）会把 GBA 结构里的 sio.driver 清空，但 linkAttached 还
	 * 留着 true —— 不补这个检查的话，复位后永远不会重新挂载驱动，游戏在
	 * 联机等待画面卡死（SIO poll 永远 drv=0）。 */
	bool drvOk = false;
	if (up && emu->core) {
		if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
			drvOk = ((struct GBA*) emu->core->board)->sio.driver == &emu->gbaLink.d;
		} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
			drvOk = ((struct GB*) emu->core->board)->sio.driver == &emu->gbLink.d;
		}
	}
	if (up && (!emu->linkAttached || !drvOk)) {
		emu->linkAttached = false;
		attachLink(emu);
	} else if (!up && emu->linkAttached) {
		detachLink(emu);
	}
}

void mgbaMobileSetKeys(struct MgbaMobile* emu, uint32_t keys) {
	if (!emu) {
		return;
	}
	noteKeys(emu, keys);
}

void mgbaMobileSetTurbo(struct MgbaMobile* emu, uint32_t mask) {
	if (!emu) {
		return;
	}
	__atomic_store_n(&emu->turboMask, mask, __ATOMIC_RELEASE);
	if (!mask) {
		emu->turboCounter = 0;
	}
}

uint16_t mgbaMobileLastKeys(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	/* Reading the console's key register is exactly what the game does, and
	 * it is what pulls the live key state through the key callback. The
	 * result is the console's active-low convention: a set bit means the key
	 * is released, a clear bit means it is pressed. */
	return GBAIORead(gba, GBA_REG_KEYINPUT);
}

/* RunFrames 的实现体。调用方必须已持有核心锁（见下面的公开包装）。 */
/* 内存监视：每帧在核心锁内读一小段内存，值变化才回调。调用方已持锁
 * （帧循环里调用），递归锁允许回调再进 mgbaMobile*。 */
static void mobilePollMemoryWatch(struct MgbaMobile* emu) {
	if (!emu->watch.active || !emu->watch.cb) {
		return;
	}
	uint32_t len = emu->watch.len;
	for (uint32_t i = 0; i < len; ++i) {
		emu->watch.cur[i] = (uint8_t) emu->core->busRead8(emu->core, emu->watch.addr + i);
	}
	if (memcmp(emu->watch.prev, emu->watch.cur, len) != 0) {
		memcpy(emu->watch.prev, emu->watch.cur, len);
		emu->watch.cb(emu->watch.addr, len, emu->watch.ctx);
	}
}

static bool mobileRunFramesLocked(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	if (count < 1) {
		count = 1;
	}
	if (!emu->lockstepSlot) {
		pollLink(emu);
	}
	mobileStartupTrace(emu);
	OBSCHAIN_GATES();   /* OBS-A：一次性零注入门快照 */
	/* 真实速度探针：模拟帧率是判断「游戏是不是被网络等待拖死」的第一指标。
	 * 联机时模拟时钟会在等对端应答的那段时间里冻住，所以模拟帧率远低于
	 * 真实帧率就说明有阻塞。每 60 个模拟帧打一行，带上真实耗时。 */
	{
		uint32_t now = wallNowMs();
		struct mTiming* tm = coreTiming(emu);
		uint32_t cyc = tm ? mTimingCurrentTime(tm) : 0;
		if (emu->probeWallAt == 0) {
			emu->probeWallAt = now;
			emu->probeCycAt = cyc;
			emu->probeFrames = 0;
		}
		emu->probeFrames += (uint32_t) count;
		uint32_t wall = now - emu->probeWallAt;
		if (wall >= 2000) {
			/* 模拟帧率（按模拟时钟算）才是关键：联机时模拟时钟会在等对端应答
			 * 的那段时间里冻住，模拟帧率一低就说明游戏被网络等待拖死了。
			 * calls/s 是真实帧率，用来对照：两者一比就知道时间花在哪儿。 */
			double emuFrames = (double) (cyc - emu->probeCycAt) / 280896.0;
			MOBILE_LOGI("FRM me=%d emuFps=%.2f callsFps=%.1f frames=%u wall=%ums",
			            netLinkPlayer(emu->link), emuFrames * 1000.0 / (double) wall,
			            (double) emu->probeFrames * 1000.0 / (double) wall,
			            emu->probeFrames, wall);
			emu->probeWallAt = now;
			emu->probeCycAt = cyc;
			emu->probeFrames = 0;
		}
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) emu->core->board;
		uint32_t stNow = (uint32_t) GBAView32(g->cpu, PEEK_LINK_STATUS);
		/* 错误位一旦置起立即报警（每帧），不依赖降采样，避免漏掉瞬时错误。 */
		if (stNow & MOBILE_LINK_STAT_ERRORS) {
			MOBILE_LOGI("LINK_ERR st=%08X qFull=%d hw=%d ck=%d lagM=%d lagS=%d siocnt=%04X waiting=%d me=%d",
			            stNow,
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x12),
			            (int)((stNow >> 12) & 1), (int)((stNow >> 13) & 1),
			            (int)((stNow >> 16) & 1), (int)((stNow >> 18) & 1),
			            g->sio.siocnt, emu->sioWaiting, netLinkPlayer(emu->link));
		}
		/* 握手卡住时扫一次内存，定位游戏真实的 link 数据区（只做一次）。 */
		if (!emu->memScan && emu->sioOk > 150 && g->sio.mode == GBA_SIO_MULTI) {
			emu->memScan = 1;
			int found = 0;
			static const uint32_t SPANS[2][2] = {
				{ GBA_EWRAM_BASE, GBA_EWRAM_END },  /* EWRAM 256K */
				{ GBA_IWRAM_BASE, GBA_IWRAM_END }   /* IWRAM 32K  */
			};
			for (int s = 0; s < 2 && found < 8; ++s) {
				for (uint32_t a = SPANS[s][0]; a + 4 < SPANS[s][1] && found < 8; a += 2) {
					if ((uint16_t) GBAView16(g->cpu, a) != LINK_HANDSHAKE_SLAVE) {
						continue;
					}
					if ((uint16_t) GBAView16(g->cpu, a + 2) != LINK_HANDSHAKE_SLAVE) {
						continue;
					}
					++found;
					char buf[320];
					int n = snprintf(buf, sizeof(buf), "MEMF %08X:", a);
					for (int k = -12; k < 28; k += 2) {
						n += snprintf(buf + n, sizeof(buf) - n, " %04X",
						              (unsigned)(uint16_t) GBAView16(g->cpu, a + k));
					}
					MOBILE_LOGI("%s", buf);
				}
			}
			MOBILE_LOGI("MEMS found=%d IME=%d IE=%04X IF=%04X siocnt=%04X mode=%d me=%d ok=%u",
			            found, (int) g->memory.io[GBA_REG(IME)],
			            (unsigned) g->memory.io[GBA_REG(IE)],
			            (unsigned) g->memory.io[GBA_REG(IF)],
			            g->sio.siocnt, (int) g->sio.mode,
			            netLinkPlayer(emu->link), emu->sioOk);
		}
		/* 逐帧盯着握手推进的几个关键量，只在变化时打点：
		 * adv = gShouldAdvanceLinkState（游戏推进联机的旗标，LinkMain1 每帧会清零）
		 * hs  = gLink.handshakeAsMaster（为真时主机才会把 0x8FFF 写进 SIOMULTI0）
		 * st  = gLink.state / pc = gLink.playerCount
		 * m0/m1 = SIOMULTI0/1（主/从各自的握手字）
		 * 这几个量在一帧内就会被吃掉，靠降采样必然漏掉，所以必须逐帧比变化。 */
		{
			int adv = (int) GBAView8(g->cpu, PEEK_LINK_STATE);
			int hs  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HANDSHAKE);
			int st  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_STATE);
			int pc  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_PLAYERS);
			int sic = (int) (int8_t) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SICTR);
			int lag = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LAG);
			int bck = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_BADCK);
			uint32_t m0 = GBAIORead(g, GBA_REG_SIOMULTI0);
			uint32_t m1 = GBAIORead(g, GBA_REG_SIOMULTI1);
			if ((uint32_t) adv != emu->sioPrevAdv) {
				MOBILE_LOGI("ADV %u->%d st=%d pc=%d hs=%d m0=%04X m1=%04X me=%d",
				            emu->sioPrevAdv, adv, st, pc, hs, m0, m1, netLinkPlayer(emu->link));
				emu->sioPrevAdv = (uint32_t) adv;
			}
			if ((uint32_t) hs != emu->sioPrevHs) {
				MOBILE_LOGI("HS idx=%d %u->%d st=%d pc=%d adv=%d m0=%04X m1=%04X me=%d",
				            emu->busGameIdx, emu->sioPrevHs, hs, st, pc, adv, m0, m1, netLinkPlayer(emu->link));
				emu->sioPrevHs = (uint32_t) hs;
			}
			if (st != emu->sioPrevLinkState || pc != emu->sioPrevPc) {
				/* 【ROOTHUNT 迭代 46】无条件状态迁移取证：cb2/playerCount/
				 * shouldAdvance 全摊开，先确认 st=1 时游戏真正在哪个 cb2。 */
				MOBILE_LOGI("[RHADV] seen st=%u pc=%u cb2=%08X adv=%u net=%d",
				            (unsigned) st, (unsigned) pc,
				            (unsigned) GBAView32(g->cpu, NAV_CB2_PTR),
				            (unsigned) GBAView8(g->cpu, NAV_IW(0x03002AD8u)),
				            emu->link ? netLinkState(emu->link) : -1);
				MOBILE_LOGI("ST idx=%d %d->%d pc %d->%d adv=%d hs=%d sic=%d lag=%d bck=%d m0=%04X m1=%04X me=%d",
				            emu->busGameIdx, emu->sioPrevLinkState, st, emu->sioPrevPc, pc, adv, hs, sic, lag, bck, m0, m1,
				            netLinkPlayer(emu->link));
				/* X10-B open= 由 OBS-C [ST] 行的 open 覆盖（复用 PEEK_LINK_OPEN）；pc-only 变化时 from==to 如实打印。 */
				OBSCHAIN_ST(g, emu->sioPrevLinkState, st, pc, (uint16_t) m0, wallNowMs());
				emu->sioPrevLinkState = st;
				emu->sioPrevPc = pc;
			}
			if (m0 != emu->sioPrevM0 || m1 != emu->sioPrevM1) {
				MOBILE_LOGI("MLT idx=%d m0=%04X m1=%04X st=%d pc=%d hs=%d adv=%d me=%d",
				            emu->busGameIdx, m0, m1, st, pc, hs, adv, netLinkPlayer(emu->link));
				emu->sioPrevM0 = m0;
				emu->sioPrevM1 = m1;
			}
			/* 机器可读的握手里程碑：gLink.state>=4 && playerCount==2 &&
			 * gLinkStatus 的 MASTER 位(0x20) 置起 ⇒ 握手真正收尾。
			 * 只打前 8 次，避免刷屏；lnkst 是原始 gLinkStatus 便于复核错误位。
			 * （ADR-003 §6：PEEK 的 link[m/st/pc] 只是瞬时值，这条是一次性事件。） */
			static int s_linkupOkDbg;
			if (emu->linkAttached && st >= 4 && pc == 2 && (stNow & 0x20u)
			    && s_linkupOkDbg < 8) {
				++s_linkupOkDbg;
				MOBILE_LOGI("LINKUP_OK st=%d pc=%d master=%d im=%d lid=%d hs=%d sic=%d m0=%04X m1=%04X me=%d lnkst=%08X",
				            st, pc, (int) ((stNow >> 5u) & 1u),
				            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_ISMASTER),
				            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LOCALID),
				            hs, sic, m0, m1, netLinkPlayer(emu->link), stNow);
			}
		}
		if ((++emu->sioPoll % 60) == 0) {
		MOBILE_LOGI("SIO poll mode=%d siocnt=%04X rcnt=%04X drv=%d wait=%d",
		            (int) g->sio.mode, g->sio.siocnt, g->sio.rcnt,
		            g->sio.driver != NULL, emu->sioWaiting);
#if MGBA_LINK_PEEK
			{
				uint32_t sb1 = (uint32_t) GBAView32(g->cpu, PEEK_SAVEBLOCK1);
				int posX = sb1 ? (int) GBAView16(g->cpu, sb1 + 0) : -1;
				int posY = sb1 ? (int) GBAView16(g->cpu, sb1 + 2) : -1;
				int mapG = sb1 ? (int) GBAView8(g->cpu, sb1 + 4) : -1;
				int mapN = sb1 ? (int) GBAView8(g->cpu, sb1 + 5) : -1;
				MOBILE_LOGI("PEEK st=%08X adv=%d open=%d wless=%d err=%d rcvpl=%d blk=%02X "
		            "link[m=%d st=%d id=%d pc=%d sic=%d hs=%d fF=%d hw=%d ck=%d lag=%d "
		            "sum=%04X sidx=%d ridx=%d sq=%u/%u rq=%u/%u pos=%d,%d map=%d.%d "
		            "cb2=%08X mm=%d pt=%d s01=%d/%d slot=%d cur=%d/%d]",
		            stNow,
		            (int) GBAView8(g->cpu, PEEK_LINK_STATE),
		            (int) GBAView8(g->cpu, PEEK_LINK_OPEN),
		            (int) GBAView8(g->cpu, PEEK_LINK_WLESS),
		            (int) GBAView8(g->cpu, PEEK_LINK_ERROCC),
		            (int) GBAView8(g->cpu, PEEK_LINK_RECVPL),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK_BLOCKS),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_ISMASTER),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_STATE),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LOCALID),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_PLAYERS),
		            (int) (int8_t) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SICTR),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HANDSHAKE),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_FIELD_F),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HWERR),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_BADCK),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LAG),
		            (unsigned) GBAView16(g->cpu, PEEK_LINK + PEEK_LK_CHECKSUM),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDIX),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVIX),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_POS),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_CNT),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_POS),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_CNT),
		            posX, posY, mapG, mapN,
		            (uint32_t) GBAView32(g->cpu, NAV_CB2_PTR),
		            (int) GBAView8(g->cpu, NAV_EW(0x02021A00u)),
		            (int) (GBAView8(g->cpu, NAV_EW(0x02032AC0u)) & 0x0Fu),
		            (int) GBAView8(g->cpu, NAV_EW(0x02032B00u)),
		            (int) GBAView8(g->cpu, NAV_EW(0x02032B01u)),
		            (int) (int8_t) GBAView8(g->cpu, NAV_EW(0x02032AC1u)),
		            (int) GBAView8(g->cpu, NAV_EW(0x020296F2u)),
		            (int) GBAView8(g->cpu, NAV_EW(0x020296F4u)));
			}
#endif
		}
		/* 命令队列探针：每 30 帧打一行，看游戏自己有没有在入队/出队。
		 * sendQ 一直 0 => 应用层没东西要发（不是链路没送到）；
		 * recvQ 一直 0 => 收到的字没被组装成命令（多半是轮次/槽位错位）。 */
		if (emu->linkAttached && emu->lkqFrames < 6000 && (++emu->lkqFrames % 30) == 0) {
			uint16_t lkck = (uint16_t) GBAView16(g->cpu, PEEK_LINK + 0x14);
			MOBILE_LOGI("LKQ f=%u me=%d st=%08X st2=%08X gst=%d ck=%04X sci=%u rci=%u sq=%u/%u rq=%u/%u ok=%u idx=%u",
			            emu->lkqFrames, netLinkPlayer(emu->link), stNow,
			            (uint32_t) GBAView32(g->cpu, PEEK_LINK_STATUS + 0x0C),
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x01), lkck,
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + 0x16),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + 0x17),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_POS),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_CNT),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_POS),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_CNT),
			            emu->sioOk, (unsigned) emu->sioIndex);
		}
		/* 检测到 gLinkStatus 由非零掉到 0（CloseLink 复位）：把复位前那帧的状态
		 * 和当时的 SIO 现场打出来，定位到底是哪条路径触发了断链。 */
		if (emu->sioPrevStatus != 0 && stNow == 0) {
			MOBILE_LOGI("LINK_RESET prev=%08X qFull=%d siocnt=%04X waiting=%d me=%d",
			            emu->sioPrevStatus,
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x12),
			            g->sio.siocnt, emu->sioWaiting, netLinkPlayer(emu->link));
		}
		emu->sioPrevStatus = stNow;
	}
	/* 帧屏障只在没挂 SIO 驱动时做（镜像模式用它对齐两边帧钟）。联机线会话里
	 * 这 400ms 的互相等是毒药：主机卡在 SIO 轮的 takePeerWord 里等从机推送，
	 * 从机卡在 barrier 里等主机下一条 TICK，两边恰好互相耗尽 400ms —— 数据
	 * 阶段跑到几十轮后必有一轮 takePeerWord 超时，游戏立刻报「连接发生了
	 * 错误」。轮本身的阻塞（等对端推送）已经是背压，帧对齐交给两边的 60fps
	 * 节拍就够了。 */
	if (count == 1 && emu->link && netLinkState(emu->link) == 2 && !emu->linkAttached) {
		netLinkBarrier(emu->link, 400);
	}
	applyFrameskip(emu->core, count > 1 ? count - 1 : emu->userSkip);
	setFastAudio(emu, count > 1);
	int i;
	for (i = 0; i < count; ++i) {
		uint32_t nowKeys = beginFrameKeys(emu);
		if (nowKeys != emu->appliedKeys) {
			emu->appliedKeys = nowKeys;
			MOBILE_LOGI("FrameKeys 0x%x", nowKeys);
		}
		emu->core->setKeys(emu->core, nowKeys);
		if (emu->lockstepSlot) {
			/* 协调器靠 sleep/wake 在 SIO 传输轮次会合，必须小步推进；
			 * runFrame 会在帧内忙等并破坏锁步。 */
			mgbaLockstepRunFrame(emu->lockstepSlot, emu->core);
		} else {
			emu->core->runFrame(emu->core);
		}
		if (emu->watch.active) {
			mobilePollMemoryWatch(emu);
		}
		if (emu->rewindEnabled && ++emu->rewindCounter >= REWIND_DIVIDER) {
			emu->rewindCounter = 0;
			if (!emu->rewindInited) {
				mCoreRewindContextInit(&emu->rewind, REWIND_ENTRIES, false);
				emu->rewindInited = true;
			}
			mCoreRewindAppend(&emu->rewind, emu->core);
		}
	}
	ensureVideo(emu);
	return true;
}

/* 核心锁下沉到这一层：iOS 直接调用这个函数（不经过 JNI 的 nativeRunFrames），
 * 而状态帧是在 socket 读线程上被注入的 —— 不加锁就是「一边 runFrame 一边
 * 换核心状态」的竞态。安卓侧的 JNI 入口也加了锁，核心锁是递归的，同线程
 * 重入安全。 */
bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	mgbaMobileLock(emu);
	bool ok = mobileRunFramesLocked(emu, count);
	mgbaMobileUnlock(emu);
	return ok;
}

int mgbaMobileReadAudio(struct MgbaMobile* emu, int16_t* out, int maxFrames) {
	if (!emu || !emu->core || !out || maxFrames <= 0) {
		return 0;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (!buffer) {
		return 0;
	}
	size_t available = mAudioBufferAvailable(buffer);
	if (available > (size_t) maxFrames) {
		available = (size_t) maxFrames;
	}
	if (available == 0) {
		return 0;
	}
	return (int) mAudioBufferRead(buffer, out, available);
}

void mgbaMobileClearAudio(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (buffer) {
		mAudioBufferClear(buffer);
	}
	if (emu->audioHoldInited) {
		mAudioBufferClear(&emu->audioHold);
	}
	/* The WSOLA input queue and the native-hold cursors are owned by the audio
	 * thread. Publish a pending clear instead of touching them here: the next
	 * mgbaMobileReadAudioOut() runs the full reset (wsolaIn, wsolaAnaPos,
	 * natR/natW, primed/outAcc/lastTime), so a re-enable after ClearAudio can
	 * no longer replay stale samples against a reset analysis cursor. */
	emu->wsolaClearPending = true;
	resetAudioOutput(emu);
}

/*
 * Installs the quality resampler that converts the core's native sample rate to
 * the device's output rate. Call with the rate the front end's audio device
 * runs at; pass 0 to disable conversion again.
 */
bool mgbaMobileSetAudioOutput(struct MgbaMobile* emu, int outRate) {
	if (!emu) {
		return false;
	}
	if (outRate <= 0) {
		deinitAudioOutput(emu);
		return false;
	}
	if (emu->audioResamplerInited) {
		if (emu->audioOutRate == outRate) {
			return true;
		}
		deinitAudioOutput(emu);
	}
	mAudioBufferInit(&emu->audioOut, MOBILE_AUDIO_OUT_FRAMES, 2);
	mAudioResamplerInit(&emu->audioResampler, mINTERPOLATOR_SINC);
	mAudioResamplerSetDestination(&emu->audioResampler, &emu->audioOut, outRate);
	emu->audioResamplerInited = true;
	emu->audioOutRate = outRate;
	MOBILE_LOGI("Audio output resampler at %d Hz", outRate);
	return true;
}

/*
 * Turns 不变速 (constant pitch) playback on or off. While it is on the
 * fast-forwarded game's surplus audio is parked in a buffer and replayed at
 * the console's own rate instead of being shredded by the core's ring, so the
 * music keeps its speed and pitch and only jumps when the park fills. The
 * front end is expected to pass speed 1 to mgbaMobileReadAudioOut while this
 * is on - the resampler rate is what sets the pitch, and this only decides
 * where the surplus goes.
 */
/* 音乐速度 rate（PC 第4自由度，Q7）：UI 线程只发布请求、钳位，音频线程下次
 * read 时生效。rate=1 与既有行为逐位一致（零回归）。 */
void mgbaMobileSetAudioRate(struct MgbaMobile* emu, double rate) {
	if (!emu) {
		return;
	}
	if (rate < MOBILE_AUDIO_RATE_MIN) { rate = MOBILE_AUDIO_RATE_MIN; }
	if (rate > MOBILE_AUDIO_RATE_MAX) { rate = MOBILE_AUDIO_RATE_MAX; }
	if (fabs(rate - MOBILE_AUDIO_RATE_DEF) < 0.01) { rate = MOBILE_AUDIO_RATE_DEF; }
	emu->audioHoldRate = rate;
}

void mgbaMobileSetAudioConstantPitch(struct MgbaMobile* emu, bool on, double stretch) {
	if (!emu) {
		return;
	}
	/*
	 * Called from the UI thread (the speed-menu checkbox) while
	 * mgbaMobileReadAudioOut runs on the emulation/audio thread. The WSOLA
	 * buffers are owned exclusively by the audio thread: initAudioHold (called
	 * from readAudioOut) allocates/rebuilds them and only teardown frees them.
	 * Touching them here - as an earlier version did with mAudioBufferClear and
	 * deinitAudioHold - races wsolaGenerate and crashes (use-after-free). So
	 * only publish the request; the audio thread acts on it on its next read.
	 *
	 * The front end republishes this on every emulated slice (~60 times a
	 * second) while the mode is on, so an unchanged request must be a no-op:
	 * arming the pending clear every time made the next read throw away the
	 * parked input and the analysis cursor, and zeroing the resampler timestamp
	 * every time restarted its fractional phase - together that turned the
	 * stretched music into chopped, ringing scraps.
	 */
	bool changed = on != emu->audioHoldOn || fabs(stretch - emu->wsolaStretch) > 0.01;
	emu->wsolaStretch = stretch;
	emu->audioHoldOn = on;
	if (!changed) {
		return;
	}
	emu->wsolaClearPending = true;
	if (emu->audioResamplerInited) {
		emu->audioResampler.timestamp = 0;
	}
}

size_t mgbaMobileWsolaDropped(const struct MgbaMobile* emu) {
	return emu ? emu->wsolaDropped : 0;
}

size_t mgbaMobileNativeHoldCuts(const struct MgbaMobile* emu) {
	return emu ? emu->natCuts : 0;
}

/*
 * Picks how fast-forward audio is produced (see MOBILE_AUDIO_HOLD_*). Like the
 * enable/stretch pair above this only publishes the request: the staging
 * buffers belong to the audio thread, so the UI thread must not touch them.
 */
void mgbaMobileSetAudioHoldMode(struct MgbaMobile* emu, int mode) {
	if (!emu) {
		return;
	}
	if (mode != MOBILE_AUDIO_HOLD_NATIVE) {
		mode = MOBILE_AUDIO_HOLD_PITCH;
	}
	if (emu->audioHoldMode == mode) {
		return;
	}
	emu->audioHoldMode = mode;
	emu->wsolaClearPending = true;
	if (emu->audioResamplerInited) {
		emu->audioResampler.timestamp = 0;
	}
}

/*
 * Feeds back how many frames per second the front end is actually managing to
 * pace emulation at. The resampler scales its input rate by the emulated
 * console's frame rate over this pace, so a game the device cannot run at full
 * speed still produces audio the playback buffer can consume without
 * underruns. Call about once a second with a measured value.
 *
 * A single measured window is not trustworthy material for the pitch: it can
 * be dragged down by a ROM load, a system pause or a GC run inside the window,
 * and even an ordinary window scatters by a few percent from sleep
 * quantization alone. The applied pace is therefore an eased estimate: it
 * absorbs a share of each reading instead of stepping to it, so the pitch
 * glides instead of jumping once per window (which during fast-forward, where
 * the throughput wobbles hardest, was heard as the music randomly detuning).
 * Readings far outside the estimate are treated as stalls and need a
 * confirming window before the estimate follows them at all.
 */
/* 两点确认：只保留上一次读数，不再用三点中值（见 mgbaMobileSetAudioPaceFps）。 */

void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps) {
	if (!emu || !(fps > 0.0)) {
		return;
	}
	if (fps < MOBILE_AUDIO_PACE_FPS_MIN) {
		fps = MOBILE_AUDIO_PACE_FPS_MIN;
	} else if (fps > MOBILE_AUDIO_PACE_FPS_MAX) {
		fps = MOBILE_AUDIO_PACE_FPS_MAX;
	}
	/* 回到「两个连续读数一致才跳」的设计意图（见 struct 注释）。
	 * 旧实现用 median3 三点中值，确认一次变化要 3~5 个窗口；更糟的是
	 * audioPaceFps==0（未测量）时首个读数直接锁定，一次调度卡顿就把
	 * 音乐拖成半速。现在 audioPaceHist[0] 只存上一次读数，
	 * audioPaceHistLen>0 表示它有效。未锁定时以控制台标称帧率作基准，
	 * 首个离群读数只记一次、不改 pace —— 0 仍表示「未测量」，
	 * readAudioOut 继续按标称输出，AudioPaceSeeded 的语义不变。 */
	double baseline = emu->audioPaceFps > 0.0
			? emu->audioPaceFps : audioNativeFps(emu);
	bool havePrevious = emu->audioPaceHistLen > 0;
	double previous = emu->audioPaceHist[0];
	emu->audioPaceHist[0] = fps;
	emu->audioPaceHistLen = 1;

	double delta = fabs(fps - baseline);
	if (delta > baseline * MOBILE_AUDIO_PACE_OUTLIER) {
		/* 离群：上一次读数与本次一致（同方向）才确认；单次只是卡顿。 */
		bool agreed = havePrevious
				&& fabs(previous - fps) <= fps * MOBILE_AUDIO_PACE_OUTLIER;
		if (!agreed && ++emu->audioPaceOutliers < 2) {
			return;
		}
		emu->audioPaceFps = fps;
		emu->audioPaceOutliers = 0;
		emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
						emu->audioPaceFps * emu->audioPaceSpeed);
		return;
	}
	emu->audioPaceOutliers = 0;
	if (emu->audioPaceFps <= 0.0) {
		/* deadband 内的首个正常读数：直接锁定，不必等两次。 */
		emu->audioPaceFps = fps;
	} else {
		double share = fps < emu->audioPaceFps
				? MOBILE_AUDIO_PACE_EMA_DOWN : MOBILE_AUDIO_PACE_EMA_UP;
		emu->audioPaceFps += (fps - emu->audioPaceFps) * share;
	}
	emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
					emu->audioPaceFps * emu->audioPaceSpeed);
}

/*
 * Clears the pace estimate so the resampler re-locks after a deliberate speed
 * change. The device-throughput memory survives the reset: readAudioOut seeds
 * from it until the first fresh reading locks the estimate again.
 */
void mgbaMobileResetAudioPace(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	emu->audioPaceFps = 0.0;
	emu->audioPaceOutliers = 0;
	emu->audioPaceHistLen = 0;
}

/*
 * Whether the resampler's input rate can be trusted for the speed currently
 * being read: either a locked estimate or a remembered device throughput to
 * seed from. Front ends defer starting playback while this is false - the
 * first fast-forward on a device has no measurement to go on, and filling the
 * playback queue at the console's nominal rate would drain it into gaps and
 * play wrong-pitch audio; waiting out the first feedback window and then
 * starting at the locked rate turns that into a beat of silence instead.
 */
bool mgbaMobileAudioPaceSeeded(const struct MgbaMobile* emu) {
	return emu && (emu->audioPaceFps > 0.0 || emu->audioPaceThroughput > 0.0);
}

struct MgbaMobileAudioWindow {
	int16_t* samples;
	size_t frames;
	unsigned channels;
	unsigned channel;
};

static int16_t _audioWindowSampleAt(int index, const void* context) {
	const struct MgbaMobileAudioWindow* window = context;
	if (index < 0 || (size_t) index >= window->frames) {
		return 0;
	}
	return window->samples[(size_t) index * window->channels + window->channel];
}

static bool ensureAudioWindow(struct MgbaMobile* emu, size_t frames) {
	if (!frames) {
		return false;
	}
	if (emu->audioWindow && emu->audioWindowFrames >= frames) {
		return true;
	}
	// Storage for stereo int16 frames; mobile cores never use more channels.
	int16_t* window = (int16_t*) realloc(emu->audioWindow, frames * 2 * sizeof(int16_t));
	if (!window) {
		return false;
	}
	emu->audioWindow = window;
	emu->audioWindowFrames = frames;
	return true;
}

/*
 * mAudioResamplerProcess with the interpolator running against a linear copy
 * of the source. The stock implementation peeks every tap straight out of the
 * source's ring buffer, which costs one wrap-handling dump per tap and made
 * SINC resampling too slow to keep up on phones. Here the ring buffer is only
 * touched twice per pump - one bulk dump and one seek - while the timestep
 * accumulation, the stop conditions and the amount of source consumed stay
 * identical to the stock resampler.
 */
static void processAudioResampler(struct MgbaMobile* emu) {
	struct mAudioResampler* resampler = &emu->audioResampler;
	struct mAudioBuffer* source = resampler->source;
	struct mAudioBuffer* destination = resampler->destination;
	unsigned channels = source->channels;
	size_t available = mAudioBufferAvailable(source);
	if (!channels || channels > 2 || !ensureAudioWindow(emu, available)) {
		// Unexpected format or out of memory: take the slow but correct path.
		mAudioResamplerProcess(resampler);
		return;
	}
	size_t dumped = mAudioBufferDump(source, emu->audioWindow, available, 0);
	struct MgbaMobileAudioWindow window = {
		.samples = emu->audioWindow,
		.frames = dumped,
		.channels = channels,
	};
	struct mInterpolationData data = {
		.at = _audioWindowSampleAt,
		.context = &window,
	};
	struct mInterpolator* interp = &resampler->interp;
	double timestep = resampler->sourceRate / resampler->destRate;
	double timestamp = resampler->timestamp;
	int16_t samples[2] = { 0 };
	while (timestamp + resampler->highWaterMark < (double) dumped && !mAudioBufferFull(destination)) {
		unsigned channel;
		for (channel = 0; channel < channels; ++channel) {
			window.channel = channel;
			samples[channel] = interp->interpolate(interp, &data, timestamp, timestep);
		}
		if (!mAudioBufferWrite(destination, samples, 1)) {
			break;
		}
		timestamp += timestep;
	}
	if (resampler->consume && timestamp > resampler->lowWaterMark) {
		size_t drop = timestamp - resampler->lowWaterMark;
		drop = mAudioBufferRead(source, NULL, drop);
		timestamp -= drop;
	}
	resampler->timestamp = timestamp;
}

/* Frame rate of the emulated console, or the nominal fallback when unknown. */
static double audioNativeFps(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return MOBILE_AUDIO_PACE_FPS;
	}
	uint32_t frequency = emu->core->frequency(emu->core);
	uint32_t frameCycles = emu->core->frameCycles(emu->core);
	if (!frequency || !frameCycles) {
		return MOBILE_AUDIO_PACE_FPS;
	}
	return (double) frequency / (double) frameCycles;
}

/*
 * Reads audio converted to the output rate set by mgbaMobileSetAudioOutput.
 *
 * speed is how many emulated frames the front end runs per paced frame (the
 * fast-forward factor) and drift is a small ratio adjustment (about +/-0.02)
 * the front end derives from its playback buffer level: positive drift makes
 * the resampler consume the core stream slightly faster, which drains the
 * output buffer, negative drift refills it. This is the standard dynamic rate
 * control used by mGBA's other front ends, and it keeps the audio clock locked
 * to the audio device without ever dropping samples.
 *
 * Falls back to raw core-rate audio when no output rate was configured.
 */
int mgbaMobileReadAudioOut(struct MgbaMobile* emu, int16_t* out, int maxFrames, double speed, float drift) {
	if (!emu || !emu->core || !out || maxFrames <= 0) {
		return 0;
	}
	if (!emu->audioResamplerInited) {
		return mgbaMobileReadAudio(emu, out, maxFrames);
	}
	struct mAudioBuffer* source = emu->core->getAudioBuffer(emu->core);
	unsigned coreRate = emu->core->audioSampleRate(emu->core);
	if (!source || !coreRate) {
		return 0;
	}
	if (speed < 0.05) {
		speed = 0.05;
	} else if (speed > 64) {
		speed = 64;
	}
	if (drift > 0.05f) {
		drift = 0.05f;
	} else if (drift < -0.05f) {
		drift = -0.05f;
	}
	double pace;
	if (emu->audioPaceFps > 0.0) {
		pace = emu->audioPaceFps;
	} else if (emu->audioPaceThroughput > 0.0) {
		// A speed change just cleared the estimate: seed from the throughput
		// the device last demonstrated (measured at the previous speed), not
		// from the console's nominal rate. Overestimating starves the stream
		// into gaps; underestimating only sheds samples at the core's ring.
		//
		// 不变速 is the exception: it reads the stretched output at the
		// console's own rate no matter how fast the game runs, so a throughput
		// remembered from 4x/16x tape playback would seed the resampler four to
		// sixteen times too fast - it would eat the staging buffer instantly
		// and the music would come out as short, pitched-up scraps for the
		// first second after the toggle, until a fresh reading locked it.
		pace = emu->audioHoldOn ? audioNativeFps(emu) : emu->audioPaceThroughput / speed;
		double nominal = audioNativeFps(emu);
		if (pace > nominal) {
			pace = nominal;
		}
		if (pace < MOBILE_AUDIO_PACE_FPS_MIN) {
			pace = MOBILE_AUDIO_PACE_FPS_MIN;
		}
	} else {
		pace = audioNativeFps(emu);
	}
	emu->audioPaceSpeed = speed;
	double fpsRatio = mCoreCalculateFramerateRatio(emu->core, pace);
	if (fpsRatio <= 0.1 || fpsRatio > 20.0) {
		// Unknown frame timing (should not happen): assume the front end paces
		// audio at the console's own frame rate.
		fpsRatio = 1.0;
	}
	/* In 音乐原速 the staged audio is already at the console's own rate: the
	 * stretching happened upstream, and the source no longer tracks how fast
	 * the game is running. So it is consumed one for one, whatever the
	 * multiplier or the front end's frame rate. Dividing by fpsRatio here (as
	 * the pass-through path must, because there the source really does run
	 * faster than real time) is what made 16x come out at a quarter speed on a
	 * device that cannot reach 16x: the ratio said 4x, so the music was
	 * stretched 4x longer. */
	size_t held = 0;
	if (emu->audioHoldOn) {
		// Fast-forward audio, produced on the emulation/audio thread, which owns
		// every staging buffer; the UI only ever sets audioHoldOn /
		// wsolaStretch / audioHoldMode / wsolaClearPending (see
		// mgbaMobileSetAudioConstantPitch).
		/* PC 公式（Q7）：stretch = speed / rate。wsolaStretch 保存的是 UI 传的
		 * speed（倍率），rate 为音乐速度；rate=1 时 stretch 与既有逐位一致。 */
		{
			double rate = emu->audioHoldRate > MOBILE_AUDIO_RATE_MIN ? emu->audioHoldRate : MOBILE_AUDIO_RATE_DEF;
			double stretch = emu->wsolaStretch / rate;
			initAudioHold(emu, coreRate, stretch);
		}
		if (emu->audioHoldInited) {
			if (emu->wsolaClearPending) {
				// A toggle happened since last time: drop anything staged under
				// the previous speed/mode so a re-enable never replays it.
			mAudioBufferClear(&emu->audioHold);
			mAudioBufferClear(&emu->wsolaIn);
			emu->wsolaAnaPos = 0;
			emu->natW = emu->natR;          /* discard whatever is staged */
			emu->natPrimed = 0;
			emu->natOutAcc = 0.0;
			emu->natLastTime = 0.0;
			emu->natLagDrops = 0;
			emu->wsolaOutAcc = 0.0;
			emu->wsolaLastTime = 0.0;
			emu->wsolaClearPending = false;
			}
			if (emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE) {
				held = nativeHoldGenerate(emu, source, (size_t) maxFrames);
			} else {
				wsolaFeed(emu, source);
				/* 墙钟配速（照抄 PC audio_stretch.c:573-615）：拉伸器每秒只发
				 * coreRate 帧，按整 hop 发射、债务 carry、低水位补顶。移动端
				 * 无音乐速度 rate，按 PC 的 rate=1.0 语义处理。 */
				double now = audioNow(emu);
				double dt = now - emu->wsolaLastTime;
				emu->wsolaLastTime = now;
				if (dt > 0.0 && dt < 0.5) {
					emu->wsolaOutAcc += dt * (double) coreRate * emu->audioHoldRate;   /* PC: *rate（音乐速度） */
				}
				double maxOwed = (double) coreRate * 0.25;
				if (emu->wsolaOutAcc > maxOwed) { emu->wsolaOutAcc = maxOwed; }
				double debt = emu->wsolaOutAcc;
				if (debt < 0.0) { debt = 0.0; }
				size_t budget = (size_t) debt;
				size_t holdAvail = mAudioBufferAvailable(&emu->audioHold);
				size_t lowWater = (size_t) (coreRate * 0.10 + 0.5);
				size_t topUp = holdAvail < lowWater ? lowWater - holdAvail : 0;
				size_t emitBudget = budget + topUp;
				held = wsolaGenerate(emu, emitBudget);
				emu->wsolaOutAcc -= (double) held;
				if (emu->wsolaOutAcc < -(double) emu->wsolaHs) {
					emu->wsolaOutAcc = -(double) emu->wsolaHs;
				}
			}
			source = &emu->audioHold;
		}
	}

	/* DIAGNOSTIC (remove after fix): while fast-forwarding, report whether the
	 * 1x hold is actually engaged. holdOn=0 means the enable call never reached
	 * here (engagement bug); holdInited=0 means the hold failed to allocate and
	 * the pass-through fast path runs instead. */
	if (speed > 1.01) {
		if ((emu->diagTick++ % 60) == 1) {
			MOBILE_LOGI("audio diag: speed %.1f holdOn %d holdInited %d mode %s natRing %p",
					speed, emu->audioHoldOn, emu->audioHoldInited,
					emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE ? "native" : "pitch",
					(void*) emu->natRing);
		}
	}

	double inRate;
	if (emu->audioHoldOn) {
		/* PC sdl-audio.c:247 srcRate = coreRate * rate（音乐速度） */
		inRate = (double) coreRate * emu->audioHoldRate * (1.0 + drift);
	} else {
		inRate = (double) coreRate * speed / fpsRatio * (1.0 + drift);
	}
	if (emu->audioHoldOn) {
		/* One line per second is enough to tell, from a device logcat, whether
		 * the stretcher is running, at what ratio, and whether it is keeping
		 * up: hold/in back up permanently means it is not draining, held = 0
		 * means it produced nothing for this read. */
		if ((emu->traceTick++ % 60) == 1) {
			MOBILE_LOGI("audio ff: mode %s stretch %.2f speed %.2f inRate %.0f coreRate %u held %zu hold %zu in %zu lagDrops %zu cuts %zu",
					emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE ? "native" : "pitch",
					emu->wsolaStretch, speed, inRate, coreRate, held,
					mAudioBufferAvailable(&emu->audioHold), mAudioBufferAvailable(&emu->wsolaIn),
					emu->natLagDrops, emu->natCuts);
		}
	}
	size_t got = mAudioBufferRead(&emu->audioOut, out, (size_t) maxFrames);
	mAudioResamplerSetSource(&emu->audioResampler, source, inRate, true);
	processAudioResampler(emu);
	if (got < (size_t) maxFrames) {
		got += mAudioBufferRead(&emu->audioOut, out + got * 2, (size_t) maxFrames - got);
	}
	return (int) got;
}

int mgbaMobileWidth(const struct MgbaMobile* emu) {
	return emu ? (int) emu->width : 0;
}

int mgbaMobileHeight(const struct MgbaMobile* emu) {
	return emu ? (int) emu->height : 0;
}

int mgbaMobileSampleRate(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	return (int) emu->core->audioSampleRate(emu->core);
}

/*
 * Length of one emulated frame in nanoseconds. Front ends pace their frame
 * slices with this so the game and its audio run at the console's own speed
 * (about 59.73 fps for GBA and GB) instead of a rounded 60, which would play
 * everything slightly fast and sharp. 0 when no console is loaded or its frame
 * timing is unknown.
 */
int64_t mgbaMobileFrameNanos(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	uint32_t frequency = emu->core->frequency(emu->core);
	uint32_t frameCycles = emu->core->frameCycles(emu->core);
	if (!frequency || !frameCycles) {
		return 0;
	}
	return ((int64_t) frameCycles * 1000000000 + frequency / 2) / frequency;
}

bool mgbaMobileCopyVideo(struct MgbaMobile* emu, uint32_t* pixels, int stride) {
	if (!emu || !emu->video || !pixels || stride < (int) emu->width || emu->width == 0 || emu->height == 0) {
		return false;
	}
	size_t pixelsN = (size_t) emu->width * emu->height;
	bool blend = emu->interframe && emu->havePrev && emu->prev;
	unsigned y;
	for (y = 0; y < emu->height; ++y) {
		uint32_t* dst = pixels + y * stride;
		const mColor* src = emu->video + y * emu->width;
		uint32_t* old = blend ? emu->prev + y * emu->width : NULL;
		unsigned x;
		for (x = 0; x < emu->width; ++x) {
			uint32_t cur = ((uint32_t) src[x]) | 0xFF000000u;
			if (old) {
				uint32_t prev = old[x];
				uint32_t r = ((cur & 0xFFu) + (prev & 0xFFu)) >> 1;
				uint32_t g = (((cur >> 8) & 0xFFu) + ((prev >> 8) & 0xFFu)) >> 1;
				uint32_t b = (((cur >> 16) & 0xFFu) + ((prev >> 16) & 0xFFu)) >> 1;
				cur = 0xFF000000u | (b << 16) | (g << 8) | r;
			}
			dst[x] = cur;
		}
	}
	if (emu->interframe) {
		if (!emu->prev) {
			emu->prev = (uint32_t*) calloc(pixelsN, sizeof(uint32_t));
		}
		if (emu->prev) {
			for (y = 0; y < emu->height; ++y) {
				memcpy(emu->prev + y * emu->width, pixels + y * stride, emu->width * sizeof(uint32_t));
			}
			emu->havePrev = true;
		}
	} else {
		emu->havePrev = false;
	}
	return true;
}

bool mgbaMobileSaveState(struct MgbaMobile* emu, int slot) {
	// Slot 0 is reserved for the front end's automatic save-on-exit.
	if (!emu || !emu->core || slot < 0 || slot > 9) {
		return false;
	}
	if (emu->fast > 0) {
		setFastAudio(emu, 0);
	}
	applyFrameskip(emu->core, 0);
	bool ok = mCoreSaveState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC | SAVESTATE_METADATA);
	emu->fast = -1;
	MOBILE_LOGI("State slot %d %s", slot, ok ? "saved" : "failed");
	return ok;
}

bool mgbaMobileLoadState(struct MgbaMobile* emu, int slot) {
	if (!emu || !emu->core || slot < 0 || slot > 9) {
		return false;
	}
	bool ok = mCoreLoadState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	MOBILE_LOGI("State slot %d %s", slot, ok ? "loaded" : "missing");
	return ok;
}

/* 快照的实现体。调用方必须已持有核心锁。 */
static bool mobileSaveStateLocked(struct MgbaMobile* emu, void** out, size_t* outSize) {
	if (!emu || !emu->core || !out || !outSize) {
		return false;
	}
	*out = NULL;
	*outSize = 0;
	struct VFile* vf = VFileMemChunk(NULL, 0);
	if (!vf) {
		return false;
	}
	if (emu->fast > 0) {
		setFastAudio(emu, 0);
	}
	applyFrameskip(emu->core, 0);
	bool ok = mCoreSaveStateNamed(emu->core, vf,
	                              SAVESTATE_SAVEDATA | SAVESTATE_RTC | SAVESTATE_METADATA);
	emu->fast = -1;
	if (ok) {
		ssize_t size = vf->size(vf);
		if (size > 0) {
			void* buffer = malloc((size_t) size);
			if (!buffer) {
				ok = false;
			} else if (vf->seek(vf, 0, SEEK_SET) != 0
			           || vf->read(vf, buffer, (size_t) size) != size) {
				free(buffer);
				ok = false;
			} else {
				*out = buffer;
				*outSize = (size_t) size;
			}
		} else {
			ok = false;
		}
	}
	vf->close(vf);
	return ok;
}

bool mgbaMobileSaveStateToMemory(struct MgbaMobile* emu, void** out, size_t* outSize) {
	if (!emu || !emu->core || !out || !outSize) {
		return false;
	}
	/* 与 RunFrames 同一把核心锁：iOS 直接调 C 函数，不经 JNI。 */
	mgbaMobileLock(emu);
	bool ok = mobileSaveStateLocked(emu, out, outSize);
	mgbaMobileUnlock(emu);
	return ok;
}

/* 状态注入的实现体。调用方必须已持有核心锁。 */
static bool mobileLoadStateLocked(struct MgbaMobile* emu, const void* data, size_t size) {
	if (!emu || !emu->core || !data || size == 0) {
		return false;
	}
	/* 【RACE_STRESS 压测造窗 / 应力诱导，非自然时序】仅在门 >0 时拉宽 apply 侧
	 * TOCTOU 易损段：上面的空检查已确认 emu/core 当时非空（经典 TOCTOU 前提），
	 * 这里 sleep 期间若 destroy 线程走到 free(emu)，下面 mCoreLoadStateNamed
	 * 解引用即命中已释放内存 → 确定性复现 CRASH5 竞态窗口；门开（根治路径）时
	 * load 在 owner 线程与 stop 串行、无并发 free，sleep 只 delays 一帧 → 不崩。
	 * A/B 因果区分力最强。门关（=0）逐字节回退：不 sleep、不打日志、不碰协议态。
	 * 合法压测工具：只加时序延时，不改 party/RAM/握手/信任/CROSSED/species、
	 * 不补灌；压测轮产物须标注「应力诱导、CROSSED 可信度存疑」，绝不进裁决轮。 */
	{
		unsigned stressMs = mobileRaceStressMs();
		if (stressMs > 0) {
			struct timespec sl;
			sl.tv_sec = (time_t) (stressMs / 1000u);
			sl.tv_nsec = (long) (stressMs % 1000u) * 1000000L;
			MOBILE_LOGI("[RACESTRESS] apply-delay %ums before load emu=%p core=%p",
			            stressMs, (void*) emu, (void*) emu->core);
			nanosleep(&sl, NULL);
		}
	}
	struct VFile* vf = VFileFromConstMemory(data, size);
	if (!vf) {
		return false;
	}
	bool ok = mCoreLoadStateNamed(emu->core, vf, SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	vf->close(vf);
	if (ok) {
		/* 【path B 关键】GBALoadState 内部会 mTimingClear()，把 linkEvent /
		 * sioDone / sioSlaveDone 全部从 timing 链表摘掉，但 emu->sioSlaveArmed
		 * 仍是 true：serviceLink 的 `!sioSlaveArmed` 守卫从此永远为假，
		 * 那颗核再也不会重挂从机事件、不推总线字（PB23/24：唯一被灌
		 * TYPE_STATE 的 slot 1 在主机 50 轮后一次 busRoundLocal 都没调，
		 * 主机 p=011 永远收不齐 3 份、BCAST=0、m1=FFFF、pc=0）。
		 * 这里把 mTimingClear 破坏的不变量补回来；不动 serviceLink 的
		 * roundReady 判据，path A / TCP 总线行为不变。 */
		{
			struct mTiming* timing = coreTiming(emu);
			emu->sioSlaveArmed = false;
			emu->sioRoundWordValid = false;
			if (timing) {
				mTimingDeschedule(timing, &emu->sioSlaveDone);
				mTimingDeschedule(timing, &emu->sioDone);
			}
			/* 【M1 seed 崩溃修复】只在门开时加运行时守卫：锁步核 linkAttached=false、
			 * linkEvent 全零（gbaLinkInit 从不跑），seed applied 后 arm 零事件 →
			 * 下一帧 mTimingTick 调 NULL callback 崩溃。守卫放在【调用点】，不下沉
			 * armLinkEvent()（后者在 linkAttached=true 之前的首挂是合法的）。 */
			if (mobileStateRearmGuardOn()) {
				if (emu->linkAttached && emu->linkEvent.callback) {
					armLinkEvent(emu);
				}
			} else {
				armLinkEvent(emu);   /* 门关=复现崩溃，便于 A/B 对照 */
			}
		}
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	return ok;
}

bool mgbaMobileLoadStateFromMemory(struct MgbaMobile* emu, const void* data, size_t size) {
	return mgbaMobileLoadStateFromMemoryEx(emu, data, size) == 0;
}

int mgbaMobileLoadStateFromMemoryEx(struct MgbaMobile* emu, const void* data, size_t size) {
	if (!emu || !emu->core) {
		return 1;
	}
	/* 官方 GBoy 的错误码：-5 = 状态尺寸不符，1 = 其它失败，0 = 成功。
	 * 这里**不能**拿 stateSize() 当长度门槛：stateSize() 是未压缩的
	 * GBASerializedState 大小，而 type-6 送来的是 mCoreSaveStateNamed 写出的
	 * 压缩流（同一局实测 7~47KB，随状态内容变化）。「size >= stateSize()」
	 * 等价于必失败 —— 镜像核一次都灌不进去，日志就是
	 * `TYPE_STATE rejected by mirror (code -5)` →「对端存档尺寸不符」→ 连接
	 * 断开（实测 02:43:48）。长度合法性交给 mCoreLoadStateNamed：它按块头读，
	 * 越界/截断会自己失败返回 false。这里只拦明显不合理的输入。 */
	mgbaMobileLock(emu);
	int result;
	if (!data || size < 32 || size > 16u * 1024u * 1024u) {
		result = -5;
	} else {
		result = mobileLoadStateLocked(emu, data, size) ? 0 : 1;
	}
	mgbaMobileUnlock(emu);
	return result;
}

size_t mgbaMobileStateSize(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	ssize_t size = emu->core->stateSize(emu->core);
	return size > 0 ? (size_t) size : 0;
}

void mgbaMobileFreeState(void* state) {
	free(state);
}

void mgbaMobileSetRewind(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->rewindEnabled = enabled;
	if (!enabled) {
		emu->rewindCounter = 0;
	}
}

/*
 * Rewinds by about the given number of seconds of gameplay. The history is a
 * ring of differential states appended every REWIND_DIVIDER frames, so a
 * request goes back that many entries (clamped to what has been recorded).
 * Video buffers refresh on the next copyVideo call; the caller clears audio.
 */
bool mgbaMobileRewind(struct MgbaMobile* emu, int seconds) {
	if (!emu || !emu->core || !emu->rewindInited || seconds < 1) {
		return false;
	}
	unsigned count = (unsigned) seconds * 60 / REWIND_DIVIDER;
	if (count < 1) {
		count = 1;
	}
	bool ok = mCoreRewindRestore(&emu->rewind, emu->core, count);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	MOBILE_LOGI("Rewind %ds %s", seconds, ok ? "ok" : "empty");
	return ok;
}

size_t mgbaMobileListVideoLayers(const struct MgbaMobile* emu, const struct mCoreChannelInfo** info) {
	if (!emu || !emu->core || !emu->core->listVideoLayers) {
		return 0;
	}
	return emu->core->listVideoLayers(emu->core, info);
}

void mgbaMobileSetVideoLayer(struct MgbaMobile* emu, size_t id, bool enable) {
	if (!emu || !emu->core || !emu->core->enableVideoLayer) {
		return;
	}
	/* UI 线程调用；与 runFrames / 存档读写共用同一把（递归）核心锁。 */
	mgbaMobileLock(emu);
	emu->core->enableVideoLayer(emu->core, id, enable);
	mgbaMobileUnlock(emu);
}

bool mgbaMobileRewindFrames(struct MgbaMobile* emu, int frames) {
	if (!emu || !emu->core || frames <= 0) {
		return false;
	}
	mgbaMobileLock(emu);
	bool ok = false;
	if (emu->rewindInited) {
		int remaining = frames;
		ok = true;
		while (remaining > 0) {
			if (!mCoreRewindRestore(&emu->rewind, emu->core, 1)) {
				ok = false;
				break;
			}
			if (remaining >= REWIND_DIVIDER) {
				remaining -= REWIND_DIVIDER;
			} else {
				/* 快照粒度是 REWIND_DIVIDER 帧：回滚后补跑到目标帧，
				 * 这样净效果正好是回退 frames 帧。 */
				int replay = REWIND_DIVIDER - remaining;
				for (int i = 0; i < replay; ++i) {
					emu->core->setKeys(emu->core, beginFrameKeys(emu));
					emu->core->runFrame(emu->core);
				}
				remaining = 0;
			}
		}
		if (ok) {
			applyFrameskip(emu->core, 0);
			ensureVideo(emu);
			emu->fast = -1;
			attachKeyCallback(emu);
		}
	}
	mgbaMobileUnlock(emu);
	return ok;
}

bool mgbaMobileSetMemoryWatch(struct MgbaMobile* emu, uint32_t addr, uint32_t len,
                              void (*cb)(uint32_t, uint32_t, void*), void* ctx) {
	if (!emu || !emu->core) {
		return false;
	}
	if (!cb) {
		mgbaMobileLock(emu);
		emu->watch.active = false;
		emu->watch.cb = NULL;
		emu->watch.ctx = NULL;
		mgbaMobileUnlock(emu);
		return true;
	}
	if (len == 0 || len > sizeof(emu->watch.prev)) {
		return false;
	}
	mgbaMobileLock(emu);
	emu->watch.addr = addr;
	emu->watch.len = len;
	emu->watch.cb = cb;
	emu->watch.ctx = ctx;
	for (uint32_t i = 0; i < len; ++i) {
		emu->watch.prev[i] = (uint8_t) emu->core->busRead8(emu->core, addr + i);
	}
	emu->watch.active = true;
	mgbaMobileUnlock(emu);
	return true;
}

void mgbaMobileReset(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return;
	}
	emu->core->reset(emu->core);
	ensureVideo(emu);
	attachKeyCallback(emu);
	pollLink(emu);
	MOBILE_LOGI("Core reset");
}

void mgbaMobileTitle(const struct MgbaMobile* emu, char* out, size_t outLen) {
	size_t i;
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu || !emu->core) {
		return;
	}
	struct mGameInfo info;
	memset(&info, 0, sizeof(info));
	emu->core->getGameInfo(emu->core, &info);
	info.title[16] = '\0';
	for (i = 0; i + 1 < outLen && info.title[i]; ++i) {
		unsigned char c = (unsigned char) info.title[i];
		out[i] = (c >= 32 && c < 127) ? (char) c : ' ';
	}
	out[i] = '\0';
}

uint32_t mgbaMobileBusRead(const struct MgbaMobile* emu, int width, uint32_t address) {
	struct mCore* core;
	if (!emu || !emu->core || width <= 0) {
		return 0;
	}
	core = emu->core;
	switch (width) {
	case 16:
		return core->busRead16(core, address);
	case 32:
		return core->busRead32(core, address);
	default:
		return core->busRead8(core, address);
	}
}

bool mgbaMobileBusWrite(struct MgbaMobile* emu, int width, uint32_t address, uint32_t value) {
	struct mCore* core;
	if (!emu || !emu->core) {
		return false;
	}
	core = emu->core;
	switch (width) {
	case 16:
		core->busWrite16(core, address, (uint16_t) value);
		break;
	case 32:
		core->busWrite32(core, address, value);
		break;
	default:
		core->busWrite8(core, address, (uint8_t) value);
		break;
	}
	return true;
}

int mgbaMobileBusReadBlock(const struct MgbaMobile* emu, uint32_t address, int size, uint8_t* out) {
	struct mCore* core;
	int i;
	if (!emu || !emu->core || !out || size <= 0) {
		return 0;
	}
	if (size > 0x100000) {
		size = 0x100000;
	}
	core = emu->core;
	for (i = 0; i < size; ++i) {
		out[i] = (uint8_t) core->busRead8(core, address + i);
	}
	return size;
}

void mgbaMobileSetInterframe(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->interframe = enabled ? 1 : 0;
	if (!emu->interframe) {
		emu->havePrev = false;
	}
}

void mgbaMobileSetFrameskip(struct MgbaMobile* emu, int skip) {
	if (!emu) {
		return;
	}
	if (skip < 0) {
		skip = 0;
	}
	if (skip > 9) {
		skip = 9;
	}
	emu->userSkip = skip;
}

/* 快帧门的只读快照（见 mobileFastFrame）。只给测试/诊断用：
 * 这几个计数就是 mobileFastLog 每 256 轮打一份的那组数，拿到结构体外只为
 * 了让回归能断言「门真的锁存过」，而不是靠人翻 logcat 找 `SIO fast`。
 * ok / valid 是 11-16 补的：负向地形要能断言「sioOk 没过 256 时门必须是关的」，
 * 断线用例要能断言「可复用的旧字真的被清掉了」——这两件事在结构体外此前
 * 完全不可观测，只能靠人读日志，那正是「断言恒真」最容易钻的空子。
 * 不改任何状态，也不做加锁（调用方在跑帧线程里读，或帧循环停下来之后读）。 */
void mgbaMobileSioFastStats(struct MgbaMobile* emu, int* latched, unsigned* n,
                            unsigned* reuse, unsigned* miss, unsigned* ok, int* valid) {
	if (latched) {
		*latched = (emu && emu->sioFastLatched) ? 1 : 0;
	}
	if (n) {
		*n = emu ? emu->sioFastN : 0;
	}
	if (reuse) {
		*reuse = emu ? emu->sioFastReuse : 0;
	}
	if (miss) {
		*miss = emu ? emu->sioFastMiss : 0;
	}
	if (ok) {
		*ok = emu ? emu->sioOk : 0;
	}
	if (valid) {
		*valid = (emu && emu->sioFastRemoteValid) ? 1 : 0;
	}
}

void mgbaMobileSaveFile(const struct MgbaMobile* emu, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu || !emu->core || emu->savePath[0] == '\0' || emu->core->dirs.baseName[0] == '\0') {
		return;
	}
	snprintf(out, outLen, "%s/%s%s", emu->savePath, emu->core->dirs.baseName, emu->saveSuffix);
}

void mgbaMobilePumpLink(struct MgbaMobile* emu) {
	if (!emu || emu->lockstepSlot) {
		/* 锁步模式下 SIO 由协调器驱动，netLink 的 poll/service 会挂上自研
		 * gbaLink 驱动并把终端位改坏，必须完全旁路。 */
		return;
	}
	pollLink(emu);
	serviceLink(emu);
}

/* players：本局人数。2 走原来的两人直连；3/4 走星型总线（主机 accept 多个
 * 从机并汇聚每一轮的字）。 */
bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port, int players) {
	if (!emu || !emu->link) {
		return false;
	}
	if (players < 2) {
		players = 2;
	}
	return netLinkBusHost(emu->link, port, players);
}

/* players 必须和主机一致：两边用不同的包格式连上去，TCP 层能连上但一个包
 * 都解不出来（总线用定长 BusPacket，两人直连用 struct Packet）。 */
bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port, int players) {
	if (!emu || !emu->link || !host) {
		return false;
	}
	if (players > 2) {
		return netLinkBusJoin(emu->link, host, port);
	}
	return netLinkJoin(emu->link, host, port);
}

bool mgbaMobileLinkHostLocal(struct MgbaMobile* emu, int key, int players) {
	if (!emu || !emu->link) {
		return false;
	}
	/* 【path B / 2P 钳位】默认保持原 3 下限；独立门开启时用具名下限 2（PB15）。 */
	int minPlayers = mobileLocalBus2pOn() ? (int) MOBILE_LOCALBUS_MIN_PLAYERS : 3;
	if (players < minPlayers) {
		players = minPlayers;
	}
	return netLinkBusHostLocal(emu->link, key, players);
}

bool mgbaMobileLinkJoinLocal(struct MgbaMobile* emu, int key) {
	if (!emu || !emu->link) {
		return false;
	}
	return netLinkBusJoinLocal(emu->link, key);
}

bool mgbaMobileLinkJoinLocalSlot(struct MgbaMobile* emu, int key, int slot) {
	if (!emu || !emu->link) {
		return false;
	}
	return netLinkBusJoinLocalSlot(emu->link, key, slot);
}

bool mgbaMobileLinkHostLockstep(struct MgbaMobile* emu, int key, int players, int slot) {
	if (!emu || !emu->core) {
		return false;
	}
	if (emu->lockstepSlot) {
		/* 残留槽位：loadROM 的复位会 deinit 锁步驱动（玩家已退出房间）但
		 * 不动本结构，指针从此悬空。干净拆掉再重挂，否则重挂永远被拒
		 * （busgame reload 后主机重新入房依赖这一点）。 */
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
		emu->lockstepRoom = NULL;
	}
	struct MgbaLockstepRoom* room = mgbaLockstepHost(key, players);
	if (!room) {
		return false;
	}
	struct MgbaLockstepSlot* ls = mgbaLockstepAttach(room, emu->core, slot);
	if (!ls) {
		mgbaLockstepRelease(room);
		return false;
	}
	emu->lockstepRoom = room;
	emu->lockstepSlot = ls;
	/* 自研 gbaLink 驱动与协调器互斥：linkAttached=false 让 attachLink 不再
	 * 尝试挂它；帧循环也会据此跳过 netLink 的 poll/service。 */
	emu->linkAttached = false;
	MOBILE_LOGI("Link LOCKSTEP host key=%d players=%d slot=%d", key, players, slot);
	return true;
}

bool mgbaMobileLinkJoinLockstep(struct MgbaMobile* emu, int key, int slot) {
	if (!emu || !emu->core) {
		return false;
	}
	if (emu->lockstepSlot) {
		/* 残留槽位：同 Host 侧——loadROM 复位后驱动已 deinit，先拆再挂。 */
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
		emu->lockstepRoom = NULL;
	}
	struct MgbaLockstepRoom* room = mgbaLockstepJoin(key);
	if (!room) {
		return false;
	}
	struct MgbaLockstepSlot* ls = mgbaLockstepAttach(room, emu->core, slot);
	if (!ls) {
		mgbaLockstepRelease(room);
		return false;
	}
	emu->lockstepRoom = room;
	emu->lockstepSlot = ls;
	emu->linkAttached = false;
	MOBILE_LOGI("Link LOCKSTEP join key=%d slot=%d", key, slot);
	return true;
}

bool mgbaMobileLinkIsLockstep(const struct MgbaMobile* emu) {
	return emu && emu->lockstepSlot != NULL;
}

void mgbaMobilePoke16(struct MgbaMobile* emu, uint32_t addr, uint16_t value) {
	if (!emu || !emu->core) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	int cc = 0;
	GBAStore16(gba->cpu, addr, (int16_t) value, &cc);
}

uint16_t mgbaMobilePeek16(struct MgbaMobile* emu, uint32_t addr) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return GBAView16(gba->cpu, addr);
}

	uint32_t mgbaMobileFrameCounter(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return gba->video.frameCounter;
}

/* 诊断：返回本核 CPU 当前 PC（gba->cpu->gprs[15]）。仅测试用，用来确认
 * 冻结是否真的把 CPU 拽到了 IWRAM 循环里。 */
uint32_t mgbaMobileCpuPc(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return (uint32_t) gba->cpu->gprs[15];
}

/* 测试钩子：开启后锁步多玩家传输直接注入 0x1000+playerId 作为发送字，
 * 绕开真实游戏对 SIOMLT_SEND 的改写，得到确定性传输用于验证收集/广播。
 * 仅测试使用，必须在跑锁步集成测试前打开、跑完关闭。 */
void mgbaMobileSioSetInject(bool inject) {
	GBASIOLockstepSetTestInject(inject);
}

void mgbaMobileLinkClose(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	if (emu->lockstepSlot) {
		MOBILE_LOGI("Link LOCKSTEP close");
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
		if (emu->lockstepRoom) {
			mgbaLockstepRelease(emu->lockstepRoom);
			emu->lockstepRoom = NULL;
		}
		return;
	}
	if (!emu->link) {
		return;
	}
	MOBILE_LOGI("Link close requested by app (state=%d)", netLinkState(emu->link));
	netLinkClose(emu->link);
}

void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu) {
		return;
	}
	if (emu->lockstepSlot) {
		/* 上层（GBoyConsoleSet.connectedStatus）用首字符 '2' 判定已连接。
		 * 锁步模式不走 netLink，这里给出等价状态，Java 侧无需分支。 */
		snprintf(out, outLen, "2 lockstep slot=%d attached=%zu",
		         mgbaLockstepSlotId(emu->lockstepSlot),
		         mgbaLockstepAttached(emu->lockstepRoom));
		return;
	}
	if (emu->link) {
		netLinkStatusText(emu->link, out, outLen);
	}
}

int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos) {
	double cursor;
	double step;
	int outFrames = 0;
	if (!in || !out || !pos || inFrames <= 0 || inRate <= 0 || outRate <= 0 || maxOutFrames <= 0) {
		return 0;
	}
	cursor = *pos;
	step = (double) inRate / (double) outRate;
	while (cursor < inFrames && outFrames < maxOutFrames) {
		int i0 = (int) cursor;
		int i1;
		double frac;
		int l0;
		int r0;
		int l1;
		int r1;
		if (i0 < 0) {
			i0 = 0;
		}
		i1 = i0 + 1;
		if (i1 > inFrames - 1) {
			i1 = inFrames - 1;
		}
		frac = cursor - i0;
		l0 = in[i0 * 2];
		r0 = in[i0 * 2 + 1];
		l1 = in[i1 * 2];
		r1 = in[i1 * 2 + 1];
		out[outFrames * 2] = (int16_t) (l0 + (l1 - l0) * frac);
		out[outFrames * 2 + 1] = (int16_t) (r0 + (r1 - r0) * frac);
		outFrames++;
		cursor += step;
	}
	cursor -= inFrames;
	if (cursor < 0) {
		cursor = 0;
	}
	*pos = cursor;
	return outFrames;
}

void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen) {
	char lower[256];
	size_t i;
	const char* picked = "gb_bios.bin";
	if (!out || outLen == 0) {
		return;
	}
	lower[0] = '\0';
	if (name) {
		for (i = 0; i + 1 < sizeof(lower) && name[i]; ++i) {
			lower[i] = (char) tolower((unsigned char) name[i]);
		}
		lower[i] = '\0';
	}
	if (strstr(lower, "gba") || size == 16384) {
		picked = "gba_bios.bin";
	} else if (strstr(lower, "gbc") || strstr(lower, "cgb") || size == 2304) {
		picked = "gbc_bios.bin";
	} else if (strstr(lower, "sgb")) {
		picked = "sgb_bios.bin";
	}
	snprintf(out, outLen, "%s", picked);
}

/* ===== S2 Android 宿端：TYPE_PARTY 收帧 -> CRC16/字段校验 -> 只写 IWRAM 邮槽 =====
 * 门三端同名同值默认关；地址用 manifest 新 ROM 绝对地址（禁 NAV_IW 二次平移），
 * 整 ROM md5 身份绑定；hook 只写邮槽字节，游戏态零写（writer=ROM）。 */
/* 三端同名同值门宏（PC 侧在 sio_link.c/CloudLink.h，此处独立 TU 须自带）。 */
#ifndef MGBAX_NET_PARTY_MAILBOX
#define MGBAX_NET_PARTY_MAILBOX 0
#endif
#define MGBAX_NET_PARTY_MAILBOX_ENV  "MGBAX_NET_PARTY_MAILBOX"
#define MGBAX_NET_PARTY_MAILBOX_PROP "debug.mgbax.link.net_party_mailbox"
static int s_gnpNetParty = -1;
static bool mobileGnpNetPartyOn(void) {
	if (s_gnpNetParty < 0) {
#if MGBAX_NET_PARTY_MAILBOX != 0
		s_gnpNetParty = 1;
#else
#ifdef __ANDROID__
		char p[PROP_VALUE_MAX] = {0};
		rhGetProp(MGBAX_NET_PARTY_MAILBOX_PROP, p);
		s_gnpNetParty = (p[0] == '1') ? 1 : 0;
#else
		const char* e = getenv(MGBAX_NET_PARTY_MAILBOX_ENV);
		s_gnpNetParty = (e && atoi(e) == 1) ? 1 : 0;
#endif
#endif
	}
	return s_gnpNetParty != 0;
}
void mgbaMobileGnpSetNetParty(bool enabled) { s_gnpNetParty = enabled ? 1 : 0; }

/* 整 ROM md5 身份绑定：manifest 不符 -> STALE_NET_MAILBOX 停线（不用 gLastWrittenSector）。 */
static bool mobileGnpRomIdentityOk(struct GBA* g) {
	if (!g || !g->memory.rom || !g->memory.romSize) { return false; }
	return gnpRomMd5Matches((const uint8_t*) g->memory.rom,
	                        (size_t) g->memory.romSize, GNP_ROM_MD5_HEX) != 0;
}

/* 唯一写口：把收到的 500B GNP 邮槽镜像写进 IWRAM 邮槽（绝对地址直写，范围守卫，
 * doorbell 最后写 release；peek 只读回读）。返回 1 成功 / 0 fail-closed。 */
int mgbaMobileGnpNetPartyMailboxWrite(struct MgbaMobile* emu,
                                      const uint8_t* mb, size_t len) {
	struct GBA* g;
	GnpMvpMailboxHost chk;
	uint32_t base, peekBase, appliedBase, off;
	if (!mobileGnpNetPartyOn() || !emu || !emu->core || !mb || len != GNP_MB_SIZE) { return 0; }
	g = (struct GBA*) emu->core->board;
	if (!g || !g->cpu) { return 0; }

	/* 1) 字段合法性（与 gen8 PollRx 同序，fail-closed） */
	memcpy(&chk, mb, GNP_MB_SIZE);
	if (chk.magic != GNP_MAGIC || chk.version != GNP_PROTO_VER ||
	    chk.msgType != GNP_MSG_PARTY || chk.length != GNP_BLOB_SIZE ||
	    chk.partyCount < 1u || chk.partyCount > GNP_MONS_MAX) {
		MOBILE_LOGE("[GNP] RX header fail-closed");
		return 0;
	}
	/* 2) host CRC16 镜像校验（覆盖 [0,496)，不含 crc/doorbell） */
	if (gnpCrc16(mb, GNP_CRC_SPAN) != (uint16_t) chk.crc) {
		MOBILE_LOGE("[GNP] RX CRC16 mismatch fail-closed");
		return 0;
	}
	/* 3) 整 ROM md5 身份绑定 fail-closed */
	if (!mobileGnpRomIdentityOk(g)) {
		MOBILE_LOGE("[GNP] STALE_NET_MAILBOX: ROM md5 != manifest");
		return 0;
	}
	/* 3b) 绝对 IW 地址范围守卫（不加 delta） */
	base       = (uint32_t) GNP_MB_IW;
	peekBase   = (uint32_t) GNP_PEEK_IW;
	appliedBase= (uint32_t) GNP_APPLIED_IW;
	if (!gnpAbsIwOk(base, GNP_MB_SIZE) ||
	    !gnpAbsIwOk(peekBase, sizeof(GnpMvpPeekHost)) ||
	    !gnpAbsIwOk(appliedBase, 1u)) {
		MOBILE_LOGE("[GNP] IW absolute addr out of range");
		return 0;
	}
	/* 4) 逐字段只写邮槽字节；pad 写 0；doorbell 留到最后 */
	GBAPatch32(g->cpu, base + GNP_OFF_MAGIC,    (int32_t) GNP_MAGIC,      NULL);
	GBAPatch16(g->cpu, base + GNP_OFF_VERSION,  (int16_t) GNP_PROTO_VER,  NULL);
	GBAPatch16(g->cpu, base + GNP_OFF_PAD0,     0, NULL);
	GBAPatch32(g->cpu, base + GNP_OFF_SEQ,      (int32_t) chk.seq,        NULL);
	GBAPatch8 (g->cpu, base + GNP_OFF_MSG_TYPE, (int8_t)  GNP_MSG_PARTY,  NULL);
	GBAPatch8 (g->cpu, base + GNP_OFF_COUNT,    (int8_t)  chk.partyCount, NULL);
	GBAPatch16(g->cpu, base + GNP_OFF_LENGTH,   (int16_t) GNP_BLOB_SIZE,  NULL);
	for (off = 0u; off < GNP_BLOB_SIZE; off += 4u) {
		uint32_t w = 0u;
		size_t n = (GNP_BLOB_SIZE - off) < 4u ? (GNP_BLOB_SIZE - off) : 4u;
		memcpy(&w, mb + GNP_OFF_BLOB + off, n);
		GBAPatch32(g->cpu, base + GNP_OFF_BLOB + off, (int32_t) w, NULL);
	}
	GBAPatch16(g->cpu, base + GNP_OFF_CRC,  (int16_t) chk.crc, NULL);
	GBAPatch8 (g->cpu, base + GNP_OFF_PAD1, 0, NULL);
	/* 5) release：doorbell 最后写（ROM 轮询此字节） */
	__sync_synchronize();
	GBAPatch8(g->cpu, base + GNP_OFF_DOORBELL, (int8_t) GNP_DOORBELL_NEW, NULL);
	/* 6) 写后回读 magic 不符即 fail-closed；peek 只读诊断 */
	if ((uint32_t) GBAView32(g->cpu, base + GNP_OFF_MAGIC) != GNP_MAGIC) {
		MOBILE_LOGE("[GNP] IWRAM mailbox magic readback FAILED -> fail-closed");
		return 0;
	}
	MOBILE_LOGI("[GNP] RX OK seq=%u cnt=%u | peek cb2=%u ok=%u fail=%u sp0=%u applied=%u",
	    (unsigned) chk.seq, (unsigned) chk.partyCount,
	    (unsigned) GBAView32(g->cpu, peekBase + GNP_OFF_PEEK_CB2TICKS),
	    (unsigned) GBAView32(g->cpu, peekBase + GNP_OFF_PEEK_POLLOK),
	    (unsigned) GBAView32(g->cpu, peekBase + GNP_OFF_PEEK_POLLFAIL),
	    (unsigned) GBAView16(g->cpu, peekBase + GNP_OFF_PEEK_SPECIES0),
	    (unsigned) GBAView8 (g->cpu, peekBase + GNP_OFF_PEEK_APPLIED));
	(void) appliedBase;
	return 1;
}
