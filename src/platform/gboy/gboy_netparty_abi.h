#ifndef GUARD_GBOY_NETPARTY_ABI_H
#define GUARD_GBOY_NETPARTY_ABI_H

#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
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

/* ===== 档1 A 预测回滚门宏族（三端同名同值、默认关、零回归）=====
 * 唯一落点=本共享头（PC sio_link.c / 共享 C mgba_mobile.c 双 include；Android 经
 * jni_bridge.cpp、iOS 经 bridging header 间接可见）。沿用现有门风格：#ifndef 默认 +
 * #if/#error 取值校验 + env/prop 覆盖（由各 driver 实施）。相位/置信用 C enum
 * （GnpPredictPhase/GnpPredictConf），不占 MGBAX_ 宏命名空间。 */
#ifndef MGBAX_ROLLBACK_ENABLE
#define MGBAX_ROLLBACK_ENABLE       0            /* 总门：0=完全走现有 SIO 路径，行为零改动 */
#endif
#ifndef MGBAX_ROLLBACK_LOG
#define MGBAX_ROLLBACK_LOG          0            /* 日志门：0=不产 [RB] 行 */
#endif
#ifndef MGBAX_ROLLBACK_ENV
#define MGBAX_ROLLBACK_ENV          "MGBAX_ROLLBACK_ENABLE"  /* env 覆盖名（三端同值） */
#endif
#ifndef MGBAX_PREDICT_MODE
#define MGBAX_PREDICT_MODE          0            /* 0=last-word hold；1=seq 递增；2=保留扩展 */
#endif
#ifndef MGBAX_PREDICT_HISTORY
#define MGBAX_PREDICT_HISTORY       8            /* 预测字历史深度（轮），环形缓冲容量 */
#endif
#ifndef MGBAX_PREDICT_MASK
#define MGBAX_PREDICT_MASK          0xFFFFu      /* SIO 字比较掩码（16bit 全比） */
#endif
#ifndef MGBAX_ROLLBACK_GRANULARITY
#define MGBAX_ROLLBACK_GRANULARITY  1            /* 1=每次传输点快照；2=每帧；值越大开销越高 */
#endif
#ifndef MGBAX_ROLLBACK_MAX_FRAMES
#define MGBAX_ROLLBACK_MAX_FRAMES   8            /* 最大可回滚帧数（有界，防内存失控/N4 预算） */
#endif
#ifndef MGBAX_ROLLBACK_SNAP_BYTES
#define MGBAX_ROLLBACK_SNAP_BYTES   0            /* 0=用 mCore save-state API 动态取，不写死尺寸 */
#endif

#if (MGBAX_ROLLBACK_ENABLE != 0) && (MGBAX_ROLLBACK_ENABLE != 1)
#error "MGBAX_ROLLBACK_ENABLE must be 0 or 1"
#endif
#if (MGBAX_ROLLBACK_LOG != 0) && (MGBAX_ROLLBACK_LOG != 1)
#error "MGBAX_ROLLBACK_LOG must be 0 or 1"
#endif
#if (MGBAX_PREDICT_MODE < 0) || (MGBAX_PREDICT_MODE > 2)
#error "MGBAX_PREDICT_MODE out of range [0,2]"
#endif
#if MGBAX_PREDICT_HISTORY < 0
#error "MGBAX_PREDICT_HISTORY must be >= 0"
#endif
#if (MGBAX_PREDICT_MASK > 0xFFFFu)
#error "MGBAX_PREDICT_MASK must fit in 16 bits"
#endif
#if MGBAX_ROLLBACK_GRANULARITY < 1
#error "MGBAX_ROLLBACK_GRANULARITY must be >= 1"
#endif
#if (MGBAX_ROLLBACK_MAX_FRAMES < 0) || (MGBAX_ROLLBACK_MAX_FRAMES > 64)
#error "MGBAX_ROLLBACK_MAX_FRAMES out of range [0,64]"
#endif
#if MGBAX_ROLLBACK_SNAP_BYTES < 0
#error "MGBAX_ROLLBACK_SNAP_BYTES must be >= 0"
#endif

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

/* ===== NETGATE 64B 只读诊断镜 host 镜像（三端同名同值，R10/R26 规格）=====
 * 逐字段复刻 gen8 include/netcode.h:178-193 的 struct GnpNetGateDiag（EWRAM，真址
 * 由 gnp_manifest.h 的 GNP_DIAG_EW 给出）。host 逐字段只读 PEEK，零写游戏态；
 * tag_ok 是 ROM 真 HMAC 比较结果，host 逐字读真值、禁无条件置 1（红线）。 */
#define GNP_NG_DIAG_SIZE         64u
#define GNP_NG_SRC_TAG_MAX       32u
#define GNP_NG_STATE_CLOSED      3u                    /* GNP_RX_CLOSED，与 gen8 netcode.h 同值 */
#define GNP_NG_MSG_PARTY         GNP_MSG_PARTY         /* =1，复用既有具名宏 */
#define GNP_NG_STATE_STR         "CLOSED"              /* 仅 state==GNP_NG_STATE_CLOSED 时打印 */
#define GNP_NG_MSG_TYPE_STR      "PARTY"               /* 仅 msg_type==GNP_NG_MSG_PARTY 时打印 */
#define GNP_NG_HEX_BYTES         4u                    /* 4B 指纹 → 8 hex（≥4，无 0x 前缀） */
#define GNP_NG_SP_BYTES          2u                    /* u16 → 4 hex */
#define GNP_NG_MAX_LINES         64u

typedef struct {
    volatile uint8_t  state;                         /*  0 GNP_RX_* 四态，仅 ROM 写 */
    volatile uint8_t  tag_ok;                        /*  1 真 HmacSha256 相等才为 1，host 逐字读 */
    volatile uint8_t  msg_type;                      /*  2 GNP_MSG_PARTY */
    volatile uint8_t  partyCount;                    /*  3 gEnemyPartyCount，>0 */
    volatile uint32_t seq;                           /*  4 真 mailbox.seq（单调） */
    volatile uint16_t sp0;                           /*  8 收到 blob 首只 species */
    volatile uint16_t tx_sp0;                        /* 10 本端 gPlayerParty 首只 species */
    volatile uint8_t  nonce[GNP_NG_HEX_BYTES];       /* 12 seq 派生，非熵源（4B） */
    volatile uint8_t  blob_fp[GNP_NG_HEX_BYTES];     /* 16 收到 blob 真字节 CRC16 指纹（4B） */
    volatile uint8_t  tag[GNP_NG_HEX_BYTES];         /* 20 CRC16 完整性标签，非 HMAC（4B） */
    volatile uint8_t  rx_digest[GNP_NG_HEX_BYTES];   /* 24 收包 blob 真字节 CRC16（4B） */
    volatile uint8_t  tx_digest[GNP_NG_HEX_BYTES];   /* 28 本端 gPlayerParty 真字节 CRC16（4B） */
    volatile char     src_tag[GNP_NG_SRC_TAG_MAX];   /* 32 ROM 内嵌真 file:line，NUL 结尾（32B） */
} GnpNetGateDiagHost;                                /* sizeof = 64 */

/* 14 个 GNP_OFF_NG_* 具名宏（13 字段 offset + 结构尺寸；三端同名同值，禁裸 hex） */
#define GNP_OFF_NG_STATE     offsetof(GnpNetGateDiagHost, state)       /*  0 */
#define GNP_OFF_NG_TAG_OK    offsetof(GnpNetGateDiagHost, tag_ok)      /*  1 */
#define GNP_OFF_NG_MSG_TYPE  offsetof(GnpNetGateDiagHost, msg_type)    /*  2 */
#define GNP_OFF_NG_COUNT     offsetof(GnpNetGateDiagHost, partyCount)  /*  3 */
#define GNP_OFF_NG_SEQ       offsetof(GnpNetGateDiagHost, seq)         /*  4 */
#define GNP_OFF_NG_SP0       offsetof(GnpNetGateDiagHost, sp0)         /*  8 */
#define GNP_OFF_NG_TX_SP0    offsetof(GnpNetGateDiagHost, tx_sp0)      /* 10 */
#define GNP_OFF_NG_NONCE     offsetof(GnpNetGateDiagHost, nonce)       /* 12 */
#define GNP_OFF_NG_BLOB_FP   offsetof(GnpNetGateDiagHost, blob_fp)     /* 16 */
#define GNP_OFF_NG_TAG       offsetof(GnpNetGateDiagHost, tag)         /* 20 */
#define GNP_OFF_NG_RX_DIGEST offsetof(GnpNetGateDiagHost, rx_digest)   /* 24 */
#define GNP_OFF_NG_TX_DIGEST offsetof(GnpNetGateDiagHost, tx_digest)   /* 28 */
#define GNP_OFF_NG_SRC_TAG   offsetof(GnpNetGateDiagHost, src_tag)     /* 32 */
#define GNP_OFF_NG_SIZE      sizeof(GnpNetGateDiagHost)               /* 64 */

/* ===== 档1 A 预测回滚类型（C enum / struct，三端同源，不占 MGBAX_ 宏命名空间）=====
 * 相位/置信度按 D3→裁决归一为具名枚举；predicted/confirmed 标签与 diag 保真 latch
 * 依 E13 §2/§3。这些只声明数据与纯类型，不含预测/回滚本体（第二批另派）。 */
enum GnpPredictPhase {
    GNP_PHASE_INVALID = 0,
    GNP_PHASE_HANDSHAKE,
    GNP_PHASE_CMD_HEADER,
    GNP_PHASE_SEQ_INDEX,
    GNP_PHASE_CHECKSUM,
    GNP_PHASE_BLOCK_DATA,
    GNP_PHASE_PHASE_BLOCK_DATA
};

enum GnpPredictConf {
    GNP_CONF_LOW = 0,
    GNP_CONF_MED,
    GNP_CONF_HIGH
};

/* predicted -> confirmed 标签（E13 §2）；唯一合法迁移 predicted→confirmed，禁超时转正。 */
enum NgTag {
    NG_PREDICTED = 0,
    NG_CONFIRMED = 1
};

/* 按帧号索引的 host 侧历史（不进回滚快照）。word 是 SIO 字，tag 表 provenance。 */
struct NgHist {
    uint32_t frameNo;
    uint32_t word;
    enum NgTag tag;
};

/* host 侧 diag 保真镜像（E13 §3），回滚层只读它：seq 严格增、tag_ok 只 sticky、
 * digest 按 (seq,digest) 绑定。真值只由 ROM 写 diag，host 逐字读、禁无条件置 1。 */
struct NgLatch {
    uint8_t  diag[GNP_NG_DIAG_SIZE];  /*  0..63 最近一次确认真 diag 快照 */
    uint32_t seq;                     /* 64 历史最大 seq */
    uint32_t digestAtSeq;             /* 68 maxSeq 处的 digest */
    int      tagOkSticky;             /* 72 epoch 内 0->1 粘滞，回滚不得 1->0 */
    int      valid;                   /* 76 latch 是否已被稳态采样填充 */
};

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

/* NETGATE 64B diag 镜像 offset/尺寸锁（与 gen8 netcode.h:178-193 逐字段对齐） */
GNP_STATIC_ASSERT(GNP_OFF_NG_STATE == 0,     "NG state offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_TAG_OK == 1,    "NG tag_ok offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_MSG_TYPE == 2,  "NG msg_type offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_COUNT == 3,     "NG count offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_SEQ == 4,       "NG seq offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_SP0 == 8,       "NG sp0 offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_TX_SP0 == 10,   "NG tx_sp0 offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_NONCE == 12,    "NG nonce offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_BLOB_FP == 16,  "NG blob_fp offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_TAG == 20,      "NG tag offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_RX_DIGEST == 24,"NG rx_digest offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_TX_DIGEST == 28,"NG tx_digest offset");
GNP_STATIC_ASSERT(GNP_OFF_NG_SRC_TAG == 32,  "NG src_tag offset");
GNP_STATIC_ASSERT(GNP_NG_DIAG_SIZE == 64,    "NG diag size");
GNP_STATIC_ASSERT(GNP_OFF_NG_SIZE == 64,     "NG struct/frame size");

/* 档1 A 新类型尺寸/偏移锁（三端同值，防 ABI 漂移；含 enum 自洽锁免 C/C++ enum 宽度歧义） */
GNP_STATIC_ASSERT(MGBAX_PREDICT_MODE <= 2,   "predict mode domain");
GNP_STATIC_ASSERT(offsetof(struct NgHist, frameNo) == 0,  "NgHist frameNo offset");
GNP_STATIC_ASSERT(offsetof(struct NgHist, word) == 4,     "NgHist word offset");
GNP_STATIC_ASSERT(offsetof(struct NgHist, tag) == 8,      "NgHist tag offset");
GNP_STATIC_ASSERT(sizeof(struct NgHist) >=
                  (2u * sizeof(uint32_t) + sizeof(enum NgTag)), "NgHist size lower bound");
GNP_STATIC_ASSERT(sizeof(struct NgHist) <= 16u, "NgHist size upper bound");
GNP_STATIC_ASSERT(offsetof(struct NgLatch, diag) == 0,    "NgLatch diag offset");
GNP_STATIC_ASSERT(offsetof(struct NgLatch, seq) == 64,    "NgLatch seq offset");
GNP_STATIC_ASSERT(offsetof(struct NgLatch, digestAtSeq) == 68, "NgLatch digest offset");
GNP_STATIC_ASSERT(offsetof(struct NgLatch, tagOkSticky) == 72, "NgLatch tagOk offset");
GNP_STATIC_ASSERT(offsetof(struct NgLatch, valid) == 76,  "NgLatch valid offset");
GNP_STATIC_ASSERT(sizeof(struct NgLatch) == (GNP_NG_DIAG_SIZE + 16u), "NgLatch size");

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

/* NETGATE diag 实址 GNP_DIAG_EW=0x020298E8 在 EWRAM，不在 IWRAM；gnpAbsIwOk 对它
 * 恒 false。此守卫专用于 64B diag 只读 PEEK（范围含边界检查，防越界读）。 */
#define GNP_EWRAM_LO  0x02000000u
#define GNP_EWRAM_HI  0x02040000u
static int gnpAbsEwOk(uint32_t addr, uint32_t span) {
    return (addr >= GNP_EWRAM_LO) && (addr < GNP_EWRAM_HI) &&
           ((uint64_t) addr + (uint64_t) span <= (uint64_t) GNP_EWRAM_HI);
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

/* ===== NETGATE 拼行共享纯逻辑（C/C++ 兼容，三端同名同值）=====
 * 只做「读 diag 字节 → 格式化成 P14 规范行」，不含任何日志 sink/游戏态写。
 * role/sender/rom_md5 由 driver 身份真值经参数传入（ROM 恒 UNKNOWN 不可自证）。 */
static void gnpNgHexBytes(char* dst, const uint8_t* p, unsigned n) {
    static const char kHex[] = "0123456789ABCDEF";
    unsigned i;
    for (i = 0u; i < n; ++i) {
        dst[i * 2u]      = kHex[(p[i] >> 4) & 0xFu];
        dst[i * 2u + 1u] = kHex[p[i] & 0xFu];
    }
    dst[n * 2u] = '\0';
}

static void gnpNgHex16(char* dst, uint16_t v) {
    uint8_t b[2];
    b[0] = (uint8_t) (v >> 8);
    b[1] = (uint8_t) v;
    gnpNgHexBytes(dst, b, GNP_NG_SP_BYTES);
}

static unsigned gnpNgDec(char* dst, uint32_t v) {
    char tmp[16];
    unsigned n = 0u, i;
    if (v == 0u) { dst[0] = '0'; dst[1] = '\0'; return 1u; }
    while (v != 0u) { tmp[n++] = (char) ('0' + (v % 10u)); v /= 10u; }
    for (i = 0u; i < n; ++i) { dst[i] = tmp[n - 1u - i]; }
    dst[n] = '\0';
    return n;
}

/* src_tag provenance 合法性：NUL 结尾且值内无空格/']'（否则 KV_RE 截断 → fail-closed）。 */
static int gnpNgSrcTagValid(const char* s, unsigned cap) {
    unsigned i;
    int nul = 0;
    if (!s) { return 0; }
    for (i = 0u; i < cap; ++i) {
        if (s[i] == '\0') { nul = 1; break; }
        if (s[i] == ' ' || s[i] == '\t' || s[i] == '\r' || s[i] == '\n' || s[i] == ']') { return 0; }
    }
    if (!nul) { return 0; }
    for (i = 0u; s[i] != '\0'; ++i) {
        if (s[i] == ' ' || s[i] == '\t' || s[i] == '\r' || s[i] == '\n' || s[i] == ']') { return 0; }
    }
    return 1;
}

/* 由 driver 持有的 ROM 字节实测 md5 渲染成 32 位大写 hex（真值，非 manifest 常量样例）。
 * 与 gnpRomMd5Matches 同源 md5Buffer；两端加载同一 ROM 时自然一致，ROM 不同则天然不等。 */
static void gnpNgRomMd5Hex(const uint8_t* rom, size_t romSize, char out[33]) {
    static const char kB[] = "0123456789ABCDEF";
    uint8_t d[16];
    unsigned i;
    if (!rom || !romSize) { out[0] = '\0'; return; }
    md5Buffer(rom, romSize, d);
    for (i = 0u; i < 16u; ++i) {
        out[i * 2u]      = kB[(d[i] >> 4) & 0xFu];
        out[i * 2u + 1u] = kB[d[i] & 0xFu];
    }
    out[32] = '\0';
}

/* diag 内 u32/u16 按 GBA 小端解读（host 大小端无关，逐字节拼值）。 */
static uint32_t gnpNgRead32(const uint8_t* p) {
    return (uint32_t) p[0] | ((uint32_t) p[1] << 8) |
           ((uint32_t) p[2] << 16) | ((uint32_t) p[3] << 24);
}

/* P14 规范行：16 字段顺序/字面严格对齐 diff_party_check.py:1955。
 * 前置条件由调用方保证：diag state==CLOSED、msg_type==PARTY、src_tag 合法、seq 单调去重。
 * tag_ok 逐字读真值（禁写 1）；state/msg_type 打印字面常量（仅前置条件成立时 truthful）。 */
static void gnpNgRender(char* buf, size_t cap, const uint8_t* diag,
                        const char* role, const char* sender, const char* romMd5Hex) {
    char sSeq[16], sCnt[16], sTagOk[16], sSp0[8], sTxSp0[8];
    char sNonce[16], sBlob[16], sTag[16], sRx[16], sTx[16];
    uint16_t sp0, tx_sp0;

    gnpNgDec(sSeq, gnpNgRead32(diag + GNP_OFF_NG_SEQ));
    gnpNgDec(sCnt, (uint32_t) diag[GNP_OFF_NG_COUNT]);
    gnpNgDec(sTagOk, (uint32_t) diag[GNP_OFF_NG_TAG_OK]);
    sp0 = (uint16_t) ((uint16_t) diag[GNP_OFF_NG_SP0] |
                      ((uint16_t) diag[GNP_OFF_NG_SP0 + 1u] << 8));
    tx_sp0 = (uint16_t) ((uint16_t) diag[GNP_OFF_NG_TX_SP0] |
                         ((uint16_t) diag[GNP_OFF_NG_TX_SP0 + 1u] << 8));
    gnpNgHex16(sSp0, sp0);
    gnpNgHex16(sTxSp0, tx_sp0);
    gnpNgHexBytes(sNonce, diag + GNP_OFF_NG_NONCE, GNP_NG_HEX_BYTES);
    gnpNgHexBytes(sBlob,  diag + GNP_OFF_NG_BLOB_FP, GNP_NG_HEX_BYTES);
    gnpNgHexBytes(sTag,   diag + GNP_OFF_NG_TAG, GNP_NG_HEX_BYTES);
    gnpNgHexBytes(sRx,    diag + GNP_OFF_NG_RX_DIGEST, GNP_NG_HEX_BYTES);
    gnpNgHexBytes(sTx,    diag + GNP_OFF_NG_TX_DIGEST, GNP_NG_HEX_BYTES);
    snprintf(buf, cap,
        "[NETGATE] role=%s state=%s seq=%s sender=%s rom_md5=%s blob=%s nonce=%s "
        "tag=%s rx_digest=%s tx_digest=%s msg_type=%s src_tag=%s cnt=%s sp0=%s "
        "tx_sp0=%s tag_ok=%s",
        role, GNP_NG_STATE_STR, sSeq, sender, romMd5Hex, sBlob, sNonce,
        sTag, sRx, sTx, GNP_NG_MSG_TYPE_STR, (const char*) (diag + GNP_OFF_NG_SRC_TAG),
        sCnt, sSp0, sTxSp0, sTagOk);
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
