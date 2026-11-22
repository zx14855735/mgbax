/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>

namespace QGBA {

/**
 * The GBoy cloud-link frame layer, byte for byte as the official client
 * (GBoy 26.10.18) speaks it:
 *
 * <pre>
 *   +----------------+----------------+--------------------+
 *   | u32 length (BE)| u16 type (BE)  | payload ...        |
 *   +----------------+----------------+--------------------+
 * </pre>
 *
 * {@code length} counts the two type bytes <em>and</em> the payload, so a bare
 * frame is {@code length = 2} and occupies six bytes on the wire.
 */
namespace GBoyFrames {

/** Largest frame body accepted on a lobby stream.
 *
 * 16 MiB, matching the Android `GBoyFrames`. The original 65535 was wrong: a
 * GBA save state is roughly 790 KiB (the Android log measured 790663 bytes),
 * so every `TYPE_STATE` frame was rejected as "not a frame we understand" and
 * the reader dropped the accumulated stream. Everything after it - key frames
 * included - was parsed from a corrupted offset, which showed up as phantom
 * inputs and a state that never reached the peer.
 */
static constexpr quint32 maxFrameLength = 16u * 1024u * 1024u;

/* 帧类型号**必须和官方客户端一致**（KpHwm4.B25kr6 的 ARc23Z 调用）。
 *
 * 官方用的是 0/1/2/3/5/6/9，中间空号不是笔误：4 与 7/8 在官方里没有被
 * 使用（4 只在多对端的按键分发里当槽位下标出现）。
 *
 * 2026-11-15 逐字节复核（tmp_gboy_apk/NETPLAY_AUDIT.md §0）推翻了旧文档：
 *   0 = **按键掩码**（D8MqeW.run 每 5 帧发一次；AYUAbz 的 case 0 → setKeys）
 *   9 = **速度倍率**（倍速菜单 → B25kr6.AZOQYO；case 9 → 改帧闸）
 *   5 = **reset**（EmulatorActivity:1333 发；case 5 → 可见核 + 全部镜像核 reset）
 * 官方**没有**帧率/pacing 消息，也没有 ready-ack。早先按旧文档把 0 当帧率、
 * 9 当按键，等于把整条输入通道的语义反了。
 *
 * 现在：0..9 严格照抄官方；我们自己的多槽位扩展一律放到 11 以上。
 */
enum Type {
	/* 0 = 按键掩码。字节码依据：模拟循环 AaHO0E 每帧 `ARc23Z(0,4)` +
	 * putInt(本帧按键) （p1.txt 0x348364），接收侧 dispatch `case 0` 直接
	 * `Link.A2egSU.setKeys(getInt())`（p2.txt 0x379e44）。早先按旧文档把它
	 * 当成"帧率"是错的 —— 那样官方房间模式里就没有任何一条消息承载按键。 */
	TYPE_KEYS = 0,
	TYPE_REGISTER = 1,    // 官方 1：握手（int32 playerCount；长度 0 = 断开）
	TYPE_NAME = 2,        // 官方 2：名字（32B name + int16 n + n 字节）
	TYPE_READY = 3,       // 官方 3：就绪 + RTT（int32）
	TYPE_RESET = 5,       // 官方 5：复位（int32 0），可见核 + 所有镜像核一起 reset
	TYPE_STATE = 6,       // 官方 6：整份 savestate（u32 长度 + blob）
	/* 9 = 模拟速度倍率（1 / -1 / 2 / 4 = 1x / 0.5x / 2x / 4x）。唯一发送点是
	 * 倍速菜单 B25kr6.AZOQYO(int)（B25kr6.java:253-258），接收侧写
	 * AaHO0E.f4302AZkASS 并重算帧闸。官方**没有**帧率下发消息。 */
	TYPE_SPEED = 9,

	// ---- 以下是我们自己的扩展，编号从 11 起，绝不与官方撞号 ----
	TYPE_INPUT_2 = 11,    // 指向全局槽位 2 的按键掩码
	TYPE_INPUT_4 = 12,    // 指向全局槽位 4 的按键掩码
	TYPE_RESET_LEGACY = 13, // 旧版我们的复位号，仅接收兼容用
	TYPE_KEYS_LOCAL = 14, // 本机可见核的按键（用于本地回放/诊断）
	TYPE_COUNTER = 15,    // 对端帧计数（诊断）
	TYPE_EVENT = 16,      // 事件通知（诊断）
	/** 槽位 3 的按键掩码。**必须单独占号**：早先借 TYPE_READY(3) 带 int
	 *  的形态夹带，与官方的「3 = RTT」互斥。 */
	TYPE_INPUT_3 = 17,

	/** S2 TYPE_PARTY=18：party 哑传输，载荷 = 整份 500B GNP 邮槽镜像（非 savestate）。
	 *  三端帧号静态对齐（Android GBoyFrames.java / iOS Swift 同号）。 */
	TYPE_PARTY = 18,

	/**
	 * 官方「断线重连握手包」（KpHwm4.AmA8tU.java:263-272，ARc23Z(Socket)）：
	 * 重连成功后先发一个裸 10 字节 {@code int32 6 + int16 100 + int32 rtt}，
	 * 再进入读循环。它刻意长成一条合法的线帧（长度 6 = 2 字节类型 + 4 字节
	 * rtt），只是类型号 100 在官方消息表里没有别的含义，所以按普通帧解析
	 * 不会错位；接收侧必须把它当握手处理，而不是当成未知类型丢掉。
	 */
	TYPE_RECONNECT = 100,
};

/**
 * C0 / ADR-002：两套联机架构并存，必须在握手期绑定同一条路径，禁止静默降级。
 *   A = 每端 1 核 + SIO 包中继（type 6 借壳承载裸 20 字节 netLink 包）
 *   B = 本机多核（可见核 + 镜像核） + 网络只传按键（官方 case 6 整份 savestate）
 * 事故背景：CloudLink.cpp:608-610 记过两套帧格式同流、9470 个碎片包耗死读线程。
 */
enum LinkMode {
	LINK_MODE_UNKNOWN = -1,   // 旧客户端 / 官方 APK 未声明能力位
	LINK_MODE_INVALID = -2,   // 能力位畸形（magic 不匹配或保留位非 0）
	LINK_MODE_A = 0,          // SIO 包中继
	LINK_MODE_B = 1,          // 本机多核 + 按键
};

/**
 * 能力位编码在官方 16 字节 type-1 注册帧的**最后一个保留字节**（wire offset 15，
 * 即 12 字节 body 的 index 11）。多人房官方恒把该 6 字节尾清零，写 0 与官方
 * 逐字节一致；官方/旧客户端读到非零也只会当作保留字段忽略，不破坏互通。
 *   bit6 (0x40) = 已声明能力；bit0 = mode（0=A / 1=B）；其余位保留且必须为 0。
 * 只占 1 bit 表达 mode，magic 用于区分「显式 A(0x40)」与「未声明(0x00)」。
 */
constexpr quint8 LINK_CAP_MAGIC = 0x40;
constexpr quint8 LINK_CAP_MODE_BIT = 0x01;

/** Bare frame: length = 2, no payload. */
QByteArray frame(int type);

/** Frame carrying a single big endian int. */
QByteArray frame(int type, int value);

/** Frame carrying a raw payload (the length counts the two type bytes). */
QByteArray frame(int type, const QByteArray& payload);

/**
 * TYPE_STATE = a big endian u32 blob length followed by the save-state bytes. * This is the sending half of the save-state synchronisation that Android has
 * in GBoyLinkSession.sendState(); the host sends one right after the link is
 * up so both cores start from the same deterministic point.
 */
/** 官方 type 2：32 字节定长名字 + int16 长度 + 描述串（房间号 / ROM 名）。 */
QByteArray nameFrame(const QByteArray& name, const QByteArray& desc = QByteArray());

QByteArray stateFrame(const QByteArray& state);

/**
 * 官方的重连握手包（KpHwm4.AmA8tU.java:263-272）：10 字节裸帧，
 * {@code int32 6 + int16 100 + int32 rtt}。数值上等于
 * {@code frame(TYPE_RECONNECT, rtt)}，这里单独取名是为了让调用点读得懂
 * 语义：这是「我重连上来了，上一次的 RTT 是 rtt」。
 */
QByteArray reconnectFrame(int rtt);

/** Reverse of stateFrame(). Returns empty when the length header does not fit
 *  the payload - the SIO relay bridge also uses type 6, but carries a raw
 *  netLink packet with no length prefix, so those frames must not be mistaken
 *  for save states. */
QByteArray stateOf(const QByteArray& body);

/** TYPE_PARTY 载荷 = 500B GNP 邮槽镜像（GnpMvpMailboxHost 字节布局）。
 *  partyFrame 只做长度守门 + 信封封装；partyOf 校验 magic/version/msgType/
 *  length/count 与 host CRC16 镜像（机械校验，非 HMAC），失败返回空 QByteArray。 */
QByteArray partyFrame(const QByteArray& mailbox500);
QByteArray partyOf(const QByteArray& body);

/**
 * The registration frame the official client sends the moment the KCP
 * handshake completes: type 1, body {@code int32 playerCount} + 6 trailing
 * bytes. The frame is **always 16 bytes on the wire** (length field 12 = 2 type
 * bytes + 10 payload bytes): the official {@code B25kr6.ARc23Z(1, 10)} always
 * allocates {@code len + 6 = 16} and the send thread
 * {@code A5SV6n} does {@code outputStream.write(byteBuffer.array())}, i.e. it
 * writes the whole backing array regardless of position/limit.
 *
 * {@code AmA8tU.A5SV6n:173-178} only decides whether the 6 trailing bytes are
 * *filled*: {@code playerCount == 1} writes {@code short 0 + int32
 * baseStateCount} there, otherwise they stay zero. The earlier "10 bytes for a
 * multiplayer room" reading was a misreading of fill-vs-not-fill as
 * length-vs-not-length, and being 6 bytes longer than the official client
 * skewed the peer's frame parsing.
 */
QByteArray registerFrame(int playerCount, int baseStateCount);
/**
 * 带 C0 能力位的注册帧。linkMode 取 LinkMode 枚举值；传 LINK_MODE_UNKNOWN
 * 时退化为 2 参数版本（与官方逐字节一致，供旧客户端互通/测试脚手架使用）。
 * 只在 playerCount != 1 时写能力位：单人房尾部是 baseStateCount，不能占用。
 */
QByteArray registerFrame(int playerCount, int baseStateCount, int linkMode);

/**
 * 从 type-1 注册帧体里读能力位。返回 LinkMode 枚举值：
 * UNKNOWN(未声明/帧体不足/非 type 1/单人房)、INVALID(畸形)、A 或 B。
 * 单人房（playerCount == 1）恒返回 UNKNOWN：那 6 字节尾部承载 baseStateCount，
 * body[11] 是它的最低字节，不是能力位 —— 与 registerFrame()「只在
 * playerCount != 1 时写」的规则严格镜像。
 */
int linkModeOf(const QByteArray& body);

/**
 * C0 / ADR-002 的 AUTO 映射：1/2 人房 → A（每端 1 核 + SIO 包中继），
 * 3/4 人房 → B（本机多核 + 网络只传按键）。
 *
 * 抽成自由函数只为一件事：让没有 session、没有事件循环的测试能直接断言
 * 「AUTO 到底选了哪条路」（test-gboylink --c0）。CloudLink::resolveLinkMode()
 * 转调它，所以测试断言的就是线上跑的那份实现，不是它的副本；CloudLink 的
 * 对外行为（含 m_modeOverride 优先级）不变。
 */
int autoLinkMode(int playerCount);

/**
 * 完整判定：显式 override（只认 A / B）优先，其余值（UNKNOWN / INVALID /
 * 任何脏值）一律按 AUTO 处理。CloudLink::resolveLinkMode() 的实现就是这一句。
 */
int resolveLinkMode(int playerCount, int modeOverride);

/** The message type of a frame body. */
int typeOf(const QByteArray& body);

/** The int that follows the message type, or 0 when the body is short. */
int intOf(const QByteArray& body);

/** The payload of a frame body, i.e. everything behind the type. */
QByteArray payloadOf(const QByteArray& body);

void putInt(QByteArray* out, int offset, quint32 value);
void putShort(QByteArray* out, int offset, quint32 value);
quint32 getInt(const QByteArray& in, int offset);
quint32 getShort(const QByteArray& in, int offset);

/**
 * Incremental splitter for the KCP byte stream: read the big endian length,
 * wait until that many bytes are available, then hand the body (type +
 * payload) to the caller.
 */
class Reader {
public:
	void append(const char* data, int length);

	/** Next complete frame body, or null while the frame is incomplete. */
	QByteArray next();

private:
	QByteArray m_buffer;
	int m_position = 0;
};

}
}
