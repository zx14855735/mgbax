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
 * 使用，我们早先把它们占成「槽位按键」后，0 被当成按键、9 被当成 FPS，
 * 与官方的语义正好错位（官方 0 = 节奏/帧率上限，9 = 按键掩码）。这样
 * 一来自家两端能通、却与官方客户端互不相认，而且 iOS 又是第三套编号。
 *
 * 现在：0..9 严格照抄官方；我们自己的多槽位扩展一律放到 11 以上。
 */
enum Type {
	TYPE_FPS = 0,         // 官方 0：节奏/帧率上限（int32）
	TYPE_REGISTER = 1,    // 官方 1：握手（int32 playerCount；长度 0 = 断开）
	TYPE_NAME = 2,        // 官方 2：名字（32B name + int16 n + n 字节）
	TYPE_READY = 3,       // 官方 3：就绪 + RTT（int32）
	TYPE_READY_ACK = 5,   // 官方 5：就绪确认（空体，仅客户端路径发）
	TYPE_STATE = 6,       // 官方 6：整份 savestate（u32 长度 + blob）
	TYPE_KEYS = 9,        // 官方 9：按键掩码（int32）

	// ---- 以下是我们自己的扩展，编号从 11 起，绝不与官方撞号 ----
	TYPE_INPUT_2 = 11,    // 指向全局槽位 2 的按键掩码
	TYPE_INPUT_4 = 12,    // 指向全局槽位 4 的按键掩码
	TYPE_RESET = 13,      // 复位请求（官方没有这条消息）
	TYPE_KEYS_LOCAL = 14, // 本机可见核的按键（用于本地回放/诊断）
	TYPE_COUNTER = 15,    // 对端帧计数（诊断）
	TYPE_EVENT = 16,      // 事件通知（诊断）
	/** 槽位 3 的按键掩码。**必须单独占号**：早先借 TYPE_READY(3) 带 int
	 *  的形态夹带，与官方的「3 = RTT」互斥。 */
	TYPE_INPUT_3 = 17,
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

/** Reverse of stateFrame(). Returns empty when the length header does not fit
 *  the payload - the SIO relay bridge also uses type 6, but carries a raw
 *  netLink packet with no length prefix, so those frames must not be mistaken
 *  for save states. */
QByteArray stateOf(const QByteArray& body);

/**
 * The registration frame the official client sends the moment the KCP
 * handshake completes: type 1, body: int playerCount, short 0, int
 * baseStateCount.
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
