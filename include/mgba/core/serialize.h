/* Copyright (c) 2013-2016 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef M_SERIALIZE_H
#define M_SERIALIZE_H

#include <mgba-util/common.h>
#include <stddef.h>

CXX_GUARD_START

enum mStateExtdataTag {
	EXTDATA_NONE = 0,
	EXTDATA_SCREENSHOT = 1,
	EXTDATA_SAVEDATA = 2,
	EXTDATA_CHEATS = 3,
	EXTDATA_RTC = 4,
	EXTDATA_SCREENSHOT_DIMENSIONS = 5,
	EXTDATA_SUBSYSTEM_START = 0x40,
	EXTDATA_SUBSYSTEM_MAX = 0x7F,
	EXTDATA_META_TIME = 0x101,
	EXTDATA_META_CREATOR = 0x102,
	EXTDATA_MAX
};

#define SAVESTATE_SCREENSHOT 1
#define SAVESTATE_SAVEDATA   2
#define SAVESTATE_CHEATS     4
#define SAVESTATE_RTC        8
#define SAVESTATE_METADATA   16
#define SAVESTATE_ALL        31

struct mStateExtdataItem {
	int32_t size;
	void* data;
	void (*clean)(void*);
};

struct mStateExtdata {
	struct mStateExtdataItem data[EXTDATA_MAX];
};

void mStateExtdataInit(struct mStateExtdata*);
void mStateExtdataDeinit(struct mStateExtdata*);
void mStateExtdataPut(struct mStateExtdata*, enum mStateExtdataTag, struct mStateExtdataItem*);
bool mStateExtdataGet(const struct mStateExtdata*, enum mStateExtdataTag, struct mStateExtdataItem*);

struct VFile;
bool mStateExtdataSerialize(struct mStateExtdata* extdata, struct VFile* vf);
bool mStateExtdataDeserialize(struct mStateExtdata* extdata, struct VFile* vf);

struct mCore;
bool mCoreSaveStateNamed(struct mCore* core, struct VFile* vf, int flags);
bool mCoreLoadStateNamed(struct mCore* core, struct VFile* vf, int flags);
void* mCoreExtractState(struct mCore* core, struct VFile* vf, struct mStateExtdata* extdata);
bool mCoreExtractExtdata(struct mCore* core, struct VFile* vf, struct mStateExtdata* extdata);

/* ===== 档1 A 回滚 diag 保真：裸快照内 NETGATE diag 的定点偏移 =====
 * = offsetof(struct GBASerializedState, wram) + 0x298E8（GNP_DIAG_EW 0x020298E8
 * 减 GBA EWRAM 基址 0x02000000）。具名常量、禁裸 hex 散落；实现在 core/serialize.c
 * 并用 static_assert 锁边界（末字节 0x02029927 不越入 NET_TX_PORT_ABS）。 */
#ifndef MGBAX_NG_DIAG_STATE_OFF
#define MGBAX_NG_DIAG_STATE_OFF 0x298E8u
#endif
#ifndef MGBAX_NG_DIAG_BYTES
#define MGBAX_NG_DIAG_BYTES      64u
#endif
size_t mCoreStateEwramOffset(void);

CXX_GUARD_END

#endif
