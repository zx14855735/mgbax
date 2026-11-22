/* Copyright (c) 2013-2016 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef GBA_MEMORY_H
#define GBA_MEMORY_H

#include <mgba-util/common.h>

CXX_GUARD_START

#include <mgba/core/timing.h>

#include <mgba/internal/arm/arm.h>
#include <mgba/internal/gba/dma.h>
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gba/cart/ereader.h>
#include <mgba/internal/gba/cart/gpio.h>
#include <mgba/internal/gba/cart/matrix.h>
#include <mgba/internal/gba/cart/unlicensed.h>

enum GBAMemoryRegion {
	GBA_REGION_BIOS = 0x0,
	GBA_REGION_EWRAM = 0x2,
	GBA_REGION_IWRAM = 0x3,
	GBA_REGION_IO = 0x4,
	GBA_REGION_PALETTE_RAM = 0x5,
	GBA_REGION_VRAM = 0x6,
	GBA_REGION_OAM = 0x7,
	GBA_REGION_ROM0 = 0x8,
	GBA_REGION_ROM0_EX = 0x9,
	GBA_REGION_ROM1 = 0xA,
	GBA_REGION_ROM1_EX = 0xB,
	GBA_REGION_ROM2 = 0xC,
	GBA_REGION_ROM2_EX = 0xD,
	GBA_REGION_SRAM = 0xE,
	GBA_REGION_SRAM_MIRROR = 0xF
};

enum GBAMemoryBase {
	GBA_BASE_BIOS = 0x00000000,
	GBA_BASE_EWRAM = 0x02000000,
	GBA_BASE_IWRAM = 0x03000000,
	GBA_BASE_IO = 0x04000000,
	GBA_BASE_PALETTE_RAM = 0x05000000,
	GBA_BASE_VRAM = 0x06000000,
	GBA_BASE_OAM = 0x07000000,
	GBA_BASE_ROM0 = 0x08000000,
	GBA_BASE_ROM0_EX = 0x09000000,
	GBA_BASE_ROM1 = 0x0A000000,
	GBA_BASE_ROM1_EX = 0x0B000000,
	GBA_BASE_ROM2 = 0x0C000000,
	GBA_BASE_ROM2_EX = 0x0D000000,
	GBA_BASE_SRAM = 0x0E000000,
	GBA_BASE_SRAM_MIRROR = 0x0F000000
};

/* === G1 EX-1 b-lite：RNG reseed 拦截（具名宏唯一真源，三端共享 C 自动对称） ===
 * 绑定 r10 冻结 ROM md5 6E0058EE… 的 gRngValue @ IWRAM+0x4EF8（gRng2Value @ +0x4EFC）；
 * 换 ROM 必须重解析 .bss 符号（旧代 0x4B70/0x4A9C 不适用），禁裸 hex 扩散。
 * 默认门关：只有 g1det harness 显式调用 GBADetRngForceEnable() 才生效。 */
#define MGBAX_DET_IWRAM_BASE      ((uint32_t) GBA_BASE_IWRAM)                  /* 0x03000000 */
#define MGBAX_DET_RNG_OFF         ((uint32_t) 0x4EF8u)                         /* gRngValue 在 IWRAM 的字节偏移 */
#define MGBAX_DET_RNG2_OFF        ((uint32_t) 0x4EFCu)                         /* gRng2Value 在 IWRAM 的字节偏移 */
#define MGBAX_DET_RNG_ADDR        (MGBAX_DET_IWRAM_BASE + MGBAX_DET_RNG_OFF)   /* 0x03004EF8 */
#define MGBAX_DET_RNG_LCG_MUL     ((uint32_t) 1103515245u)                     /* gen8 Random(): gRngValue = MUL * gRngValue + ADD (mod 2^32) */
#define MGBAX_DET_RNG_LCG_ADD     ((uint32_t) 0x6073u)                         /* LCG 加数：x = MUL*x + 0x6073；漏此项会把每次真实 LCG 写误判为 reseed/unknown */
#define MGBAX_DET_RNG_RESEED_MAX  ((uint32_t) 0x0000FFFFu)                     /* SeedRng(u16) 零扩展 ⇒ reseed 形写 ≤ 0xFFFF */
#ifndef MGBAX_DET_RNG_FORCE_SEED
#define MGBAX_DET_RNG_FORCE_SEED  ((uint32_t) 0x1A2B3C4Du)                     /* 与 EX-1 请求 seed 同值；可被 setter 覆盖 */
#endif
#define MGBAX_DET_RNG_HOOK_AUDIT  (16)                                         /* 强制写审计行上限，防日志爆 */

enum {
	GBA_SIZE_BIOS = 0x00004000,
	/* Expanded to 512 KiB so ROM hacks linked against a 512 KiB EWRAM window
	 * (pointers in 0x02040000..0x0207FFFF) get distinct RAM instead of the
	 * real-hardware 256 KiB mirror that overlays 0x02000000..0x0203FFFF.
	 * Commercial games never touch 0x02040000+, so this is harmless for them. */
	GBA_SIZE_EWRAM = 0x00080000,
	GBA_SIZE_IWRAM = 0x00008000,
	GBA_SIZE_IO = 0x00000400,
	GBA_SIZE_PALETTE_RAM = 0x00000400,
	GBA_SIZE_VRAM = 0x00018000,
	GBA_SIZE_OAM = 0x00000400,
	GBA_SIZE_ROM0 = 0x02000000,
	GBA_SIZE_ROM1 = 0x02000000,
	GBA_SIZE_ROM2 = 0x02000000,
	GBA_SIZE_SRAM = 0x00008000,
	GBA_SIZE_SRAM512 = 0x00010000,
	GBA_SIZE_FLASH512 = 0x00010000,
	GBA_SIZE_FLASH1M = 0x00020000,
	GBA_SIZE_EEPROM = 0x00002000,
	GBA_SIZE_EEPROM512 = 0x00000200,

	GBA_SIZE_AGB_PRINT = 0x10000
};

enum {
	OFFSET_MASK = 0x00FFFFFF,
	BASE_OFFSET = 24
};

enum {
	AGB_PRINT_BASE = 0x00FD0000,
	AGB_PRINT_TOP = 0x00FE0000,
	AGB_PRINT_PROTECT = 0x00FE2FFE,
	AGB_PRINT_STRUCT = 0x00FE20F8,
	AGB_PRINT_FLUSH_ADDR = 0x00FE209C,
};

mLOG_DECLARE_CATEGORY(GBA_MEM);

struct GBAPrintContext {
	uint16_t request;
	uint16_t bank;
	uint16_t get;
	uint16_t put;
};

struct GBAMemory {
	uint32_t* bios;
	uint32_t* wram;
	uint32_t* iwram;
	uint32_t* rom;
	uint16_t io[512];

	struct GBACartridgeHardware hw;
	struct GBASavedata savedata;
	struct GBAMatrix matrix;
	struct GBAUnlCart unl;
	struct GBACartEReader ereader;
	size_t romSize;
	/* Bytes behind the rom pointer (0 = the plain 32 MiB window). Oversized
	 * romhack images and their patched/COW copies allocate more. */
	size_t romAllocSize;
	uint32_t romMask;
	uint16_t romID;
	int fullBios;

	char waitstatesSeq32[256];
	char waitstatesSeq16[256];
	char waitstatesNonseq32[256];
	char waitstatesNonseq16[256];
	int activeRegion;
	bool prefetch;
	uint32_t lastPrefetchedPc;
	uint32_t biosPrefetch;

	struct GBADMA dma[4];
	struct mTimingEvent dmaEvent;
	int activeDMA;

	uint32_t agbPrintBase;
	uint16_t agbPrintProtect;
	struct GBAPrintContext agbPrintCtx;
	uint16_t* agbPrintBuffer;
	uint16_t agbPrintProtectBackup;
	struct GBAPrintContext agbPrintCtxBackup;
	uint32_t agbPrintFuncBackup;
	uint16_t* agbPrintBufferBackup;
};

struct GBA;
void GBAMemoryInit(struct GBA* gba);
void GBAMemoryDeinit(struct GBA* gba);

/* TEMP PROBE (rom64): print the WS1 window access profile. */
void GBARom64ProbeDump(void);
extern int mgbaIoLogOn;
extern uint32_t mgbaGpioWrites;
extern uint32_t mgbaFlashWrites;
extern uint32_t mgbaFlashLastAddr;
extern uint32_t mgbaFlashLastValue;
extern uint32_t mgbaGpioReads;
extern uint32_t mgbaGpioLastValue;
void GBARom64ProbeReset(void);
uint32_t GBARom64ProbePhaseCount(void);

void GBAMemoryReset(struct GBA* gba);
void GBAMemoryClearAGBPrint(struct GBA* gba);

uint32_t GBALoad32(struct ARMCore* cpu, uint32_t address, int* cycleCounter);
uint32_t GBALoad16(struct ARMCore* cpu, uint32_t address, int* cycleCounter);
uint32_t GBALoad8(struct ARMCore* cpu, uint32_t address, int* cycleCounter);

uint32_t GBALoadBad(struct ARMCore* cpu);

void GBAStore32(struct ARMCore* cpu, uint32_t address, int32_t value, int* cycleCounter);
void GBAStore16(struct ARMCore* cpu, uint32_t address, int16_t value, int* cycleCounter);
void GBAStore8(struct ARMCore* cpu, uint32_t address, int8_t value, int* cycleCounter);

uint32_t GBAView32(struct ARMCore* cpu, uint32_t address);
uint16_t GBAView16(struct ARMCore* cpu, uint32_t address);
uint8_t GBAView8(struct ARMCore* cpu, uint32_t address);

void GBAPatch32(struct ARMCore* cpu, uint32_t address, int32_t value, int32_t* old);
void GBAPatch16(struct ARMCore* cpu, uint32_t address, int16_t value, int16_t* old);
void GBAPatch8(struct ARMCore* cpu, uint32_t address, int8_t value, int8_t* old);

/* 【2026-11-16】云端联机：吞掉 gen8 写 gLink.lag(+0x13, 绝对地址 0x03002B07)
 * 的**非零** store，避免 LinkVSync 在一帧没跑满 9 次传送时把「时钟滞后」标成
 * 致命错误（EXTRACT_LINK_ERRORS 含 LAG_MASTER 0x10000 / LAG_SLAVE 0x40000），
 * 一次公网抖动就被 CheckErrorStatus() 拆链。
 *
 * 为什么必须拦在 store 上而不是事后清位：LinkVSync 在 VBlank 中断里写这个字节，
 * 同一帧的 LinkMain2 → CheckErrorStatus 紧接着就读它，中间只有几百个周期，
 * 任何轮询/事件都来不及插进去（实测 lgc=0，一次都没清到）。链路是否真的还活着
 * 由传输层判断（对端 1s 内推过字才置位），真断链仍然让游戏自己报错。 */
extern bool gbaLinkDropClockLag;

/* G1 b-lite 钩子注册/注销与审计（per-core；默认全 0，只有 g1det 调用者置位）。 */
void GBADetRngForceEnable(struct GBA* gba, uint32_t seed); /* 注册：置门+清计数+设强制 seed */
void GBADetRngForceDisable(struct GBA* gba);               /* 注销：门清回 false，正常联机恢复 */
bool GBADetRngForceEnabled(const struct GBA* gba);
uint32_t GBADetRngForceSeed(const struct GBA* gba);
uint32_t GBADetRngForceHits(const struct GBA* gba);        /* 命中次数＝被替换的 reseed 形写数 */
uint32_t GBADetRngForceLcgPass(const struct GBA* gba);     /* LCG 递推放行次数（证明确有 Random() 演化） */
uint32_t GBADetRngForceUnknown(const struct GBA* gba);     /* 非 LCG 非 reseed 形写次数（fail-closed 信号） */
uint32_t GBADetRngForceWidthSkip(const struct GBA* gba);   /* 16/8 位 store 绕开次数（可选护栏） */

uint32_t GBALoadMultiple(struct ARMCore*, uint32_t baseAddress, int mask, enum LSMDirection direction,
                         int* cycleCounter);
uint32_t GBAStoreMultiple(struct ARMCore*, uint32_t baseAddress, int mask, enum LSMDirection direction,
                          int* cycleCounter);

void GBAAdjustWaitstates(struct GBA* gba, uint16_t parameters);
void GBAAdjustEWRAMWaitstates(struct GBA* gba, uint16_t parameters);

struct GBASerializedState;
void GBAMemorySerialize(const struct GBAMemory* memory, struct GBASerializedState* state);
void GBAMemoryDeserialize(struct GBAMemory* memory, const struct GBASerializedState* state);

void GBAPrintFlush(struct GBA* gba);

CXX_GUARD_END

#endif
