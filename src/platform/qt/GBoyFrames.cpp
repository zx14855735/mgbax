/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyFrames.h"

#include <cstring>

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

QByteArray stateFrame(const QByteArray& state) {
	QByteArray body;
	body.resize(int(4 + state.size()));
	putInt(&body, 0, quint32(state.size()));
	if (!state.isEmpty()) {
		memcpy(body.data() + 4, state.constData(), size_t(state.size()));
	}
	return frame(TYPE_STATE, body);
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

QByteArray registerFrame(int playerCount, int baseStateCount) {
	QByteArray out(16, 0);
	putInt(&out, 0, 12);
	putShort(&out, 4, TYPE_REGISTER);
	putInt(&out, 6, quint32(playerCount));
	putShort(&out, 10, 0);
	putInt(&out, 12, quint32(baseStateCount));
	return out;
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
