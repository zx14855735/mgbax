#ifndef GUARD_GBOY_NETPARTY_ABI_H
#define GUARD_GBOY_NETPARTY_ABI_H

#include <stddef.h>
#include <stdint.h>
#include <string.h>
#include <mgba-util/md5.h>

/* ===== S2 邮槽 ABI 的 host 镜像（与 gen8 include/netcode.h 同名同值，三端共用） =====
 * 方向：PC(源) 读自身真 gPlayerParty -> 填本结构 -> TYPE_PARTY 帧 -> APP(宿)
 *       APP host 只把字节写进 IWRAM 邮槽；语义写者=ROM netcode（writer=ROM）。
 * 本头不含任何游戏态地址；hook 禁写 gEnemyParty/gBattleMons/brs/rem/nr/st/CLOSED。 */
#define GNP_MAGIC                 UINT32_C(0x474E5056)   /* 'GNPV' 身份锚，非信任根 */
#define GNP_PROTO_VER             UINT16_C(1)
#define GNP_MSG_PARTY             UINT8_C(1)             /* 唯一接受类型 */
#define GNP_DOORBELL_NEW          UINT8_C(0xA5)          /* 生产者最后写（release） */
#define GNP_DOORBELL_CONSUMED     UINT8_C(0x5A)          /* ROM 消费后写；host 永不写 */
#define GNP_SEQ_INIT              UINT32_C(0)            /* seq=0 被 ROM 拒收，TX 从 1 起 */
#define GNP_CRC_INIT              UINT16_C(0x1121)       /* 与 gen8 util.c:243 同值 */
#define GNP_CRC_POLY_REFLECTED    UINT16_C(0x8408)       /* 反射 poly（sCrc16Table[0x80]） */
#define GNP_BLOB_SIZE             UINT16_C(480)          /* 6 * sizeof(struct Pokemon)=6*80 */
#define GNP_MB_SIZE               UINT16_C(532)          /* = GNP_FRAME_SIZE；原 500 退役 */
#define GNP_FRAME_SIZE            UINT16_C(532)          /* 三端同值：ROM netcode.h / netparty_tx.h 同为 532 */
#define GNP_HMAC_TAG_SIZE         UINT16_C(32)           /* 与 ROM GNP_HMAC_TAG_SIZE 同值；host 零解释 */
#define GNP_CRC_SPAN              UINT16_C(496)          /* = GNP_OFF_BLOB + GNP_BLOB_SIZE，保持不变 */
#define GNP_MONS_MAX              UINT8_C(6)

typedef struct {
    volatile uint32_t magic;         /* 0   GNP_MAGIC */
    volatile uint16_t version;       /* 4   GNP_PROTO_VER */
    volatile uint16_t _pad0;         /* 6   host 写 0 */
    volatile uint32_t seq;           /* 8   单调 seq（>0，TX 递增） */
    volatile uint8_t  msgType;       /* 12  GNP_MSG_PARTY */
    volatile uint8_t  partyCount;    /* 13  1..GNP_MONS_MAX */
    volatile uint16_t length;        /* 14  GNP_BLOB_SIZE */
    uint8_t  blob[GNP_BLOB_SIZE];    /* 16..495 对端真 gPlayerParty 原始字节 */
    volatile uint16_t crc;           /* 496 覆盖 [0,GNP_CRC_SPAN) */
    volatile uint8_t  doorbell;      /* 498 host 最后写 GNP_DOORBELL_NEW */
    uint8_t  _pad1;                  /* 499 host 写 0，对齐 4 */
    uint8_t  tag[GNP_HMAC_TAG_SIZE]; /* 500..531 对端 HMAC-SHA256 标签；host 逐字节镜像，不解释、不重算、不持密钥 */
} GnpMvpMailboxHost;                 /* sizeof = 532 = GNP_FRAME_SIZE（静态锁在下） */

/* 字节偏移具名宏（三端同名同值；禁裸 hex 出现在写口逻辑） */
#define GNP_OFF_MAGIC     offsetof(GnpMvpMailboxHost, magic)
#define GNP_OFF_VERSION   offsetof(GnpMvpMailboxHost, version)
#define GNP_OFF_PAD0      offsetof(GnpMvpMailboxHost, _pad0)
#define GNP_OFF_SEQ       offsetof(GnpMvpMailboxHost, seq)
#define GNP_OFF_MSG_TYPE  offsetof(GnpMvpMailboxHost, msgType)
#define GNP_OFF_COUNT     offsetof(GnpMvpMailboxHost, partyCount)
#define GNP_OFF_LENGTH    offsetof(GnpMvpMailboxHost, length)
#define GNP_OFF_BLOB      offsetof(GnpMvpMailboxHost, blob)
#define GNP_OFF_CRC       offsetof(GnpMvpMailboxHost, crc)
#define GNP_OFF_DOORBELL  offsetof(GnpMvpMailboxHost, doorbell)
#define GNP_OFF_PAD1      offsetof(GnpMvpMailboxHost, _pad1)
#define GNP_OFF_TAG       offsetof(GnpMvpMailboxHost, tag)      /* 500，三端同名同值 */

/* peek 结构（gen8 netcode.h 镜像；驱动 IW 只读回读诊断，非 NETGATE/非 CROSSED） */
typedef struct {
    volatile uint32_t cb2Ticks;      /*  0 CB2_HandleStartBattle 进入次数 */
    volatile uint32_t pollOk;        /*  4 PollRx 校验通过次数 */
    volatile uint32_t pollFail;      /*  8 校验失败/fail-closed 次数 */
    volatile uint32_t seq;           /* 12 最后接受的 seq */
    volatile uint16_t crc;           /* 16 最后接受的 crc */
    volatile uint16_t species0;      /* 18 gEnemyParty[0].species（ROM GetMonData 取） */
    volatile uint8_t  applied;       /* 20 是否执行过 fast path */
    volatile uint8_t  count;         /* 21 装入的 gEnemyPartyCount */
} GnpMvpPeekHost;

#define GNP_OFF_PEEK_CB2TICKS  offsetof(GnpMvpPeekHost, cb2Ticks)
#define GNP_OFF_PEEK_POLLOK    offsetof(GnpMvpPeekHost, pollOk)
#define GNP_OFF_PEEK_POLLFAIL  offsetof(GnpMvpPeekHost, pollFail)
#define GNP_OFF_PEEK_SEQ       offsetof(GnpMvpPeekHost, seq)
#define GNP_OFF_PEEK_CRC       offsetof(GnpMvpPeekHost, crc)
#define GNP_OFF_PEEK_SPECIES0  offsetof(GnpMvpPeekHost, species0)
#define GNP_OFF_PEEK_APPLIED   offsetof(GnpMvpPeekHost, applied)
#define GNP_OFF_PEEK_COUNT     offsetof(GnpMvpPeekHost, count)

/* 编译期尺寸锁（不符即编译失败，fail-closed）——用 __LINE__ 生成唯一 typedef 名，
 * 避免对字符串字面量做 ## 拼接（C99 回退分支合法）。 */
#define GNP_SA_CAT2(a, b) a##b
#define GNP_SA_CAT(a, b) GNP_SA_CAT2(a, b)
#ifdef __cplusplus
#define GNP_STATIC_ASSERT(c, m) static_assert((c), m)
#else
#if defined(__STDC_VERSION__) && __STDC_VERSION__ >= 201112L
#define GNP_STATIC_ASSERT(c, m) _Static_assert((c), m)
#else
#define GNP_STATIC_ASSERT(c, m) typedef char GNP_SA_CAT(gnp_sa_, __LINE__)[(c) ? 1 : -1]
#endif
#endif
GNP_STATIC_ASSERT(GNP_OFF_MAGIC == 0,   "GNP magic offset");
GNP_STATIC_ASSERT(GNP_OFF_VERSION == 4, "GNP version offset");
GNP_STATIC_ASSERT(GNP_OFF_SEQ == 8,     "GNP seq offset");
GNP_STATIC_ASSERT(GNP_OFF_MSG_TYPE == 12, "GNP msgType offset");
GNP_STATIC_ASSERT(GNP_OFF_COUNT == 13,  "GNP count offset");
GNP_STATIC_ASSERT(GNP_OFF_LENGTH == 14, "GNP length offset");
GNP_STATIC_ASSERT(GNP_OFF_BLOB == 16,   "GNP blob offset");
GNP_STATIC_ASSERT(GNP_OFF_CRC == 496,   "GNP crc offset");
GNP_STATIC_ASSERT(GNP_OFF_DOORBELL == 498, "GNP doorbell offset");
GNP_STATIC_ASSERT(GNP_OFF_TAG == 500,    "GNP tag offset");
GNP_STATIC_ASSERT(GNP_MB_SIZE == 532,    "GNP mailbox size");
GNP_STATIC_ASSERT(GNP_FRAME_SIZE == 532, "GNP frame size");
GNP_STATIC_ASSERT(GNP_HMAC_TAG_SIZE == 32, "GNP tag size");
GNP_STATIC_ASSERT(sizeof(GnpMvpMailboxHost) == GNP_FRAME_SIZE, "GNP struct/frame size");
GNP_STATIC_ASSERT(GNP_CRC_SPAN == 496,  "GNP crc span");
GNP_STATIC_ASSERT(GNP_BLOB_SIZE == 480, "GNP blob size");

/* ===== manifest（方案 A：新 ROM 绝对地址）=====
 * 具名宏 GNP_MB_IW/GNP_PEEK_IW/GNP_APPLIED_IW/GNP_ROM_MD5_HEX 由
 * "platform/gboy/gnp_manifest.h" 提供（唯一允许裸 hex 的生成文件），由各 .c include。
 * 禁对这些绝对地址再套 SIO_IW()/NAV_IW()（二次平移）。 */
#define GNP_IWRAM_LO  0x03000000u
#define GNP_IWRAM_HI  0x03008000u
static int gnpAbsIwOk(uint32_t addr, uint32_t span) {
    return (addr >= GNP_IWRAM_LO) && (addr < GNP_IWRAM_HI) &&
           ((uint64_t) addr + (uint64_t) span <= (uint64_t) GNP_IWRAM_HI);
}

/* 整 ROM md5 身份绑定（替代 gLastWrittenSector —— 其值随存档变化，禁作身份判据）。 */
static int gnpRomMd5Matches(const uint8_t* rom, size_t romSize, const char* hex32) {
    uint8_t digest[16];
    size_t i;
    if (!rom || !romSize || !hex32 || strlen(hex32) != 32u) { return 0; }
    md5Buffer(rom, romSize, digest);
    for (i = 0; i < 16u; ++i) {
        char h = hex32[i * 2u], l = hex32[i * 2u + 1u];
        unsigned hi, lo;
        if (h >= '0' && h <= '9') { hi = (unsigned) (h - '0'); }
        else if (h >= 'a' && h <= 'f') { hi = (unsigned) (h - 'a') + 10u; }
        else if (h >= 'A' && h <= 'F') { hi = (unsigned) (h - 'A') + 10u; }
        else { return 0; }
        if (l >= '0' && l <= '9') { lo = (unsigned) (l - '0'); }
        else if (l >= 'a' && l <= 'f') { lo = (unsigned) (l - 'a') + 10u; }
        else if (l >= 'A' && l <= 'F') { lo = (unsigned) (l - 'A') + 10u; }
        else { return 0; }
        if (digest[i] != (uint8_t) ((hi << 4) | lo)) { return 0; }
    }
    return 1;
}

/* ===== host CRC16 镜像：逐位复刻 gen8 src/util.c:240 CalcCRC16WithTable =====
 * init=0x1121 / 反射 poly=0x8408 表 / 末 ~crc；表由 poly 运行时生成。
 * 覆盖 [GNP_OFF_MAGIC, GNP_CRC_SPAN) = 496B，不含 crc@496 / doorbell@498 / tag@500..531。
 * 纯机械校验，非 HMAC、不证来源真实。 */
static uint16_t s_gnpCrc16Table[256];
static int      s_gnpCrc16TableReady = 0;

static void gnpCrc16BuildTable(void) {
    uint16_t i;
    for (i = 0; i < 256u; ++i) {
        uint16_t v = (uint16_t) i;
        int k;
        for (k = 0; k < 8; ++k) {
            v = (uint16_t) ((v & 1u) ? ((v >> 1) ^ GNP_CRC_POLY_REFLECTED) : (v >> 1));
        }
        s_gnpCrc16Table[i] = v;
    }
    s_gnpCrc16TableReady = 1;
}

static uint16_t gnpCrc16(const uint8_t* data, size_t len) {
    uint16_t crc = GNP_CRC_INIT;
    size_t i;
    if (!s_gnpCrc16TableReady) { gnpCrc16BuildTable(); }
    for (i = 0; i < len; ++i) {
        uint8_t byte = (uint8_t) (crc >> 8);
        crc ^= (uint16_t) data[i];
        crc = (uint16_t) (byte ^ s_gnpCrc16Table[(uint8_t) crc]);
    }
    return (uint16_t) ~crc;
}

/* 逐位参考实现（无表），仅用于 selftest 交叉验证；与表版结果恒等（gen8 CalcCRC16）。 */
static uint16_t gnpCrc16Bitwise(const uint8_t* data, size_t len) {
    uint16_t crc = GNP_CRC_INIT;
    size_t i;
    int k;
    for (i = 0; i < len; ++i) {
        crc ^= (uint16_t) data[i];
        for (k = 0; k < 8; ++k) {
            crc = (uint16_t) ((crc & 1u) ? ((crc >> 1) ^ GNP_CRC_POLY_REFLECTED) : (crc >> 1));
        }
    }
    return (uint16_t) ~crc;
}

/* 已知向量 selftest（父会话已用独立 Python 验证 14 golden + host 7 向量全 PASS）。 */
static int gnpCrc16Selftest(void) {
    static const uint8_t v0[] = { 0 };
    static const uint8_t v1[] = { 1 };
    static const uint8_t vff[] = { 0xFF };
    static const uint8_t v9[] = { '1','2','3','4','5','6','7','8','9' };
    static const uint8_t v16[] = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
    static const uint8_t vgnp[] = { 'G','N','P','V' };
    struct { const uint8_t* p; size_t n; uint16_t want; } t[] = {
        { v0,   1u, UINT16_C(0xCF65) },
        { v1,   1u, UINT16_C(0xDEEC) },
        { vff,  1u, UINT16_C(0xC01D) },
        { v9,   9u, UINT16_C(0xBE75) },
        { v16, 16u, UINT16_C(0x6C60) },
        { vgnp, 4u, UINT16_C(0x00E1) },
        { (const uint8_t*) 0, 0u, UINT16_C(0xEEDE) },
    };
    size_t i;
    for (i = 0; i < sizeof(t) / sizeof(t[0]); ++i) {
        uint16_t a = gnpCrc16(t[i].p, t[i].n);
        uint16_t b = gnpCrc16Bitwise(t[i].p, t[i].n);
        if (a != t[i].want || b != t[i].want) { return 0; }
    }
    return 1;
}

#endif  /* GUARD_GBOY_NETPARTY_ABI_H */
