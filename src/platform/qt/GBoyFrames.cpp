/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyFrames.h"

#include <cstring>
#include "platform/gboy/gboy_netparty_abi.h"   // GNP_OFF_* / GNP_MB_SIZE / GNP_CRC_SPAN / gnpCrc16

namespace QGBA {
namespace GBoyFrames {

QByteArray frame(int type) {
	QByteArray out(6, 0);
	putInt(&out, 0, 2);
	putShort(&out, 4, type);
	return out;
}

QByteArray frame(int type, int value) {
	QByteArray out(10, 0);
	putInt(&out, 0, 6);
	putShort(&out, 4, type);
	putInt(&out, 6, quint32(value));
	return out;
}

QByteArray frame(int type, const QByteArray& payload) {
	QByteArray out;
	out.resize(int(4 + 2 + payload.size()));
	putInt(&out, 0, quint32(2 + payload.size()));
	putShort(&out, 4, type);
	out.replace(6, payload.size(), payload);
	return out;
}

QByteArray payloadOf(const QByteArray& body) {
	if (body.size() <= 2) {
		return QByteArray();
	}
	return body.mid(2);
}

/** 官方 type 2：自我介绍 = 32 字节定长名字 + int16 长度 + 描述串（房间/ROM）。
 *  名字短于 32 字节时右侧补 0，对端按 32 字节固定宽度读。 */
QByteArray nameFrame(const QByteArray& name, const QByteArray& desc) {
	QByteArray body(32, '\0');
	const int n = qMin(32, name.size());
	memcpy(body.data(), name.constData(), size_t(n));
	body.append(char((desc.size() >> 8) & 0xFF));
	body.append(char(desc.size() & 0xFF));
	body.append(desc);
	return frame(TYPE_NAME, body);
}

QByteArray stateFrame(const QByteArray& state) {	QByteArray body;
	body.resize(int(4 + state.size()));
	putInt(&body, 0, quint32(state.size()));
	if (!state.isEmpty()) {
		memcpy(body.data() + 4, state.constData(), size_t(state.size()));
	}
	return frame(TYPE_STATE, body);
}

/* 官方重连握手包：10 字节裸帧，int32 6 + int16 100 + int32 rtt
 * （KpHwm4.AmA8tU.java:263-272）。按普通帧构造即可得到同样的字节：
 * 长度字段 6 = 2 字节类型 + 4 字节 rtt。 */
QByteArray reconnectFrame(int rtt) {
	return frame(TYPE_RECONNECT, rtt);
}

QByteArray stateOf(const QByteArray& body) {
	QByteArray payload = payloadOf(body);
	if (payload.size() < 4) {
		return QByteArray();
	}
	quint32 length = getInt(payload, 0);
	// A SIO bridge packet carries a raw netLink magic in its first four bytes,
	// which is far larger than the remaining payload, so it is rejected here.
	if (length > quint32(payload.size() - 4)) {
		return QByteArray();
	}
	return payload.mid(4, int(length));
}

/** S2：TYPE_PARTY 帧 = u32 长度 + u16 类型 + 500B GNP 邮槽镜像（字节原样）。 */
QByteArray partyFrame(const QByteArray& mailbox500) {
	if (mailbox500.size() != int(GNP_MB_SIZE)) { return QByteArray(); }
	return frame(TYPE_PARTY, mailbox500);          // 复用 frame() 的 u32 长度 + u16 类型信封
}

/** 机械校验 + 原样返回 500B 邮槽镜像；字段非法或 CRC16 不符即空。
 *  非 HMAC、不证来源真实；真实性只由零注入 CROSSED 裁决。 */
QByteArray partyOf(const QByteArray& body) {
	QByteArray mb = payloadOf(body);
	if (mb.size() != int(GNP_MB_SIZE)) { return QByteArray(); }
	const uint8_t* p = reinterpret_cast<const uint8_t*>(mb.constData());
	uint32_t magic = 0;
	uint16_t version = 0, length = 0, crc = 0;
	uint8_t msgType = 0, count = 0;
	memcpy(&magic,   p + GNP_OFF_MAGIC,    sizeof(magic));
	memcpy(&version, p + GNP_OFF_VERSION,  sizeof(version));
	memcpy(&msgType, p + GNP_OFF_MSG_TYPE, sizeof(msgType));
	memcpy(&count,   p + GNP_OFF_COUNT,    sizeof(count));
	memcpy(&length,  p + GNP_OFF_LENGTH,   sizeof(length));
	memcpy(&crc,     p + GNP_OFF_CRC,      sizeof(crc));
	if (magic != GNP_MAGIC || version != GNP_PROTO_VER || msgType != GNP_MSG_PARTY ||
	    length != GNP_BLOB_SIZE || count < 1u || count > GNP_MONS_MAX) {
		return QByteArray();
	}
	if (gnpCrc16(p, GNP_CRC_SPAN) != crc) { return QByteArray(); }
	return mb;
}

/* 官方注册体（KpHwm4.AmA8tU.A5SV6n:173-178）：
 *
 *   type 1 + int32 playerCount
 *   playerCount == 1 时再补 short 0 + int32 baseStateCount
 *
 * 单人房那条尾巴是官方客户端的原样行为；多人房只有 4 字节 int，整帧
 * 10 字节，单人房 16 字节。我们早先无条件写 12 字节体（16 字节帧），
 * 多人房比官方长 6 字节，对端按自己的长度解析就会把后面的帧读错位。 */
/* 官方 B25kr6.ARc23Z(1, 10) 恒分配 16 字节（allocate(len+6)、长度字段 = len+2 = 12），
 * 而且发送线程 A5SV6n 是 `outputStream.write(byteBuffer.array())` —— **写整个
 * backing array**，不受 position/limit 影响。所以线上的注册帧永远是 16 字节：
 * playerCount != 1 时尾部那 6 个字节就是 0，不是"不发"。
 *
 * 早先按「只在 playerCount==1 时才补尾部」实现成 10 字节是误读（那是 fill 与
 * not-fill 的区别，不是长度区别），与官方逐字节不一致。 */
QByteArray registerFrame(int playerCount, int baseStateCount) {
	return registerFrame(playerCount, baseStateCount, LINK_MODE_UNKNOWN);
}

QByteArray registerFrame(int playerCount, int baseStateCount, int linkMode) {
	QByteArray out(16, 0);
	putInt(&out, 0, 12);
	putShort(&out, 4, TYPE_REGISTER);
	putInt(&out, 6, quint32(playerCount));
	if (playerCount == 1) {
		putShort(&out, 10, 0);
		putInt(&out, 12, quint32(baseStateCount));
		/* 单人房尾部承载 baseStateCount，不写能力位；云端房间永远 >= 2 人。 */
		return out;
	}
	if (linkMode == LINK_MODE_A || linkMode == LINK_MODE_B) {
		/* wire[15] == body[11]：官方多人房恒为 0，旧端读到非零只当保留字段忽略。 */
		out[15] = char(LINK_CAP_MAGIC | (linkMode == LINK_MODE_B ? LINK_CAP_MODE_BIT : 0));
	}
	return out;
}

int linkModeOf(const QByteArray& body) {
	if (body.size() < 12 || typeOf(body) != TYPE_REGISTER) {
		return LINK_MODE_UNKNOWN;
	}
	/* 单人房的尾部 6 字节是 short 0 + int32 baseStateCount（官方 A5SV6n:173-178），
	 * body[11] 是 baseStateCount 的**最低字节**，不是能力位 —— 写侧只在
	 * playerCount != 1 时写能力位（registerFrame 的同一条规则），读侧必须镜像它。
	 * 漏了这一步会怎样：1 人房 + baseStateCount=1 时 body[11] == 0x01，
	 * magic 0x40 不匹配 → 判成 INVALID → 对端直接 fail 成「对端能力位畸形」。
	 * 这条是 test-gboylink --c0 抓出来的（首跑 40 ok / 1 FAIL）。 */
	if (intOf(body) == 1) {
		return LINK_MODE_UNKNOWN;
	}
	const quint8 cap = quint8(uchar(body[11]));
	if (cap == 0) {
		return LINK_MODE_UNKNOWN;   // 官方 APK / 旧客户端：未声明
	}
	if ((cap & LINK_CAP_MAGIC) == 0 || (cap & ~(LINK_CAP_MAGIC | LINK_CAP_MODE_BIT)) != 0) {
		return LINK_MODE_INVALID;   // 畸形能力位，按不一致处理，禁止猜测
	}
	return (cap & LINK_CAP_MODE_BIT) ? LINK_MODE_B : LINK_MODE_A;
}

/* C0 的 AUTO 映射。唯一实现，CloudLink::resolveLinkMode() 与测试都走这里，
 * 避免「测试断言的和线上跑的不是同一份逻辑」。 */
int autoLinkMode(int playerCount) {
	/* 1/2 人：path A（SIO 包中继）延迟最低；3/4 人：path A 每端只有 1 核，
	 * 凑不出第三、第四个玩家，只能走 path B 的本地多核（4 核/设备）。 */
	return playerCount >= 3 ? LINK_MODE_B : LINK_MODE_A;
}

int resolveLinkMode(int playerCount, int modeOverride) {
	if (modeOverride == LINK_MODE_A || modeOverride == LINK_MODE_B) {
		return modeOverride;
	}
	return autoLinkMode(playerCount);
}

int typeOf(const QByteArray& body) {
	if (body.size() < 2) {
		return -1;
	}
	return (uchar(body[0]) << 8) | uchar(body[1]);
}

int intOf(const QByteArray& body) {
	if (body.size() < 6) {
		return 0;
	}
	return int(getInt(body, 2));
}

void putInt(QByteArray* out, int offset, quint32 value) {
	uchar* p = reinterpret_cast<uchar*>(out->data()) + offset;
	p[0] = uchar(value >> 24);
	p[1] = uchar(value >> 16);
	p[2] = uchar(value >> 8);
	p[3] = uchar(value);
}

void putShort(QByteArray* out, int offset, quint32 value) {
	uchar* p = reinterpret_cast<uchar*>(out->data()) + offset;
	p[0] = uchar(value >> 8);
	p[1] = uchar(value);
}

quint32 getInt(const QByteArray& in, int offset) {
	const uchar* p = reinterpret_cast<const uchar*>(in.constData()) + offset;
	return (quint32(p[0]) << 24) | (quint32(p[1]) << 16) | (quint32(p[2]) << 8) | quint32(p[3]);
}

quint32 getShort(const QByteArray& in, int offset) {
	const uchar* p = reinterpret_cast<const uchar*>(in.constData()) + offset;
	return (quint32(p[0]) << 8) | quint32(p[1]);
}

void Reader::append(const char* data, int length) {
	if (length <= 0) {
		return;
	}
	int needed = m_position + length;
	if (needed > m_buffer.size()) {
		int size = qMax(needed, m_buffer.size() * 2 + 64);
		m_buffer.resize(size);
	}
	memcpy(m_buffer.data() + m_position, data, length);
	m_position = needed;
}

QByteArray Reader::next() {
	if (m_position < 4) {
		return QByteArray();
	}
	quint32 length = getInt(m_buffer, 0);
	if (length < 2 || length > maxFrameLength) {
		// Not a frame we understand; drop the stream rather than spin.
		m_position = 0;
		return QByteArray();
	}
	if (m_position < int(4 + length)) {
		return QByteArray();
	}
	QByteArray body = m_buffer.mid(4, length);
	int consumed = int(4 + length);
	memmove(m_buffer.data(), m_buffer.constData() + consumed, m_position - consumed);
	m_position -= consumed;
	return body;
}

}
}
