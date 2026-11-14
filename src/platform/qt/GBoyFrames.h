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

	/**
	 * 官方「断线重连握手包」（KpHwm4.AmA8tU.java:263-272，ARc23Z(Socket)）：
	 * 重连成功后先发一个裸 10 字节 {@code int32 6 + int16 100 + int32 rtt}，
	 * 再进入读循环。它刻意长成一条合法的线帧（长度 6 = 2 字节类型 + 4 字节
	 * rtt），只是类型号 100 在官方消息表里没有别的含义，所以按普通帧解析
	 * 不会错位；接收侧必须把它当握手处理，而不是当成未知类型丢掉。
	 */
	TYPE_RECONNECT = 100,
};

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

/**
 * The registration frame the official client sends the moment the KCP
 * handshake completes: type 1, body {@code int32 playerCount}; the official
 * {@code AmA8tU.A5SV6n:173-178} appends {@code short 0 + int32 baseStateCount}
 * only when {@code playerCount == 1}, so a multiplayer room frame is 10 bytes
 * on the wire and a one-player frame is 16 bytes.
 */
QByteArray registerFrame(int playerCount, int baseStateCount);

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
