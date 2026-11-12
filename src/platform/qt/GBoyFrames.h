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

enum Type {
	TYPE_KEYS = 0,        // Key bitmask for the console this session owns.
	TYPE_REGISTER = 1,    // Session registration (ten byte body) and the plain acknowledgement.
	TYPE_INPUT_2 = 2,     // Key bitmask aimed at another console slot.
	TYPE_READY = 3,       // "Ready" in the handshake; slot 3's key mask while running.
	TYPE_INPUT_4 = 4,
	TYPE_RESET = 5,       // Reset request, the body is an int (0).
	TYPE_STATE = 6,       // Save state transfer, the body is an int length plus the blob.
	TYPE_KEYS_LOCAL = 7,  // Key bitmask for the console the local player drives.
	TYPE_COUNTER = 8,
	TYPE_FPS = 9,
	TYPE_EVENT = 10,
};

/** Bare frame: length = 2, no payload. */
QByteArray frame(int type);

/** Frame carrying a single big endian int. */
QByteArray frame(int type, int value);

/** Frame carrying a raw payload (the length counts the two type bytes). */
QByteArray frame(int type, const QByteArray& payload);

/**
 * TYPE_STATE = a big endian u32 blob length followed by the save-state bytes.
 * This is the sending half of the save-state synchronisation that Android has
 * in GBoyLinkSession.sendState(); the host sends one right after the link is
 * up so both cores start from the same deterministic point.
 */
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
