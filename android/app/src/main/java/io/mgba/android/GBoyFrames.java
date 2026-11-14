/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.Arrays;

/**
 * The GBoy cloud-link frame layer, byte for byte as the official client
 * (GBoy 26.10.18) speaks it.
 *
 * <pre>
 *   +----------------+----------------+--------------------+
 *   | u32 length (BE)| u16 type (BE)  | payload ...        |
 *   +----------------+----------------+--------------------+
 * </pre>
 *
 * {@code length} counts the two type bytes <em>and</em> the payload, so a bare
 * frame is {@code length = 2} and occupies six bytes on the wire. The official
 * client builds every frame with
 * {@code ByteBuffer.allocate(payload + 6); putInt(payload + 2); putShort(type)}
 * and reads them back with {@code getInt()} / {@code getShort()} on a default
 * (big endian) {@link java.nio.ByteBuffer}.
 *
 * The frame body - type followed by payload - is what the official client
 * queues, so that is what {@link #typeOf} and {@link #intOf} operate on.
 */
final class GBoyFrames {

    /**
     * Largest frame body we accept. A GBA save-state blob is several hundred
     * KiB, so the old 65535 cap silently discarded every TYPE_STATE frame and
     * desynchronised the stream; the official client uses an unrestricted int
     * length. 16 MiB leaves ample headroom while still bounding allocations.
     */
    static final int MAX_FRAME_LENGTH = 16 * 1024 * 1024;

    /*
     * 类型号与官方客户端逐条对齐（KpHwm4.B25kr6 里的 ARc23Z 调用）：
     * 0 节奏 / 1 握手 / 2 名字 / 3 就绪+RTT / 5 就绪确认 / 6 状态 / 9 按键。
     * 官方没用到 4、7、8、10 之后的号，我们自家的「多槽位按键」扩展一律放
     * 到 11 以上，避免再把 0 当按键、9 当 FPS 那样和官方语义错位。
     */

    /** 官方 0：节奏 / 帧率上限（int32）。 */
    static final int TYPE_FPS = 0;
    /** 官方 1：握手（int32 playerCount；长度 0 = 断开）。 */
    static final int TYPE_REGISTER = 1;
    /** 官方 2：名字（32 字节定长 + int16 长度 + 描述串）。 */
    static final int TYPE_NAME = 2;
    /** 官方 3：就绪 + RTT（int32）。 */
    static final int TYPE_READY = 3;
    /** 官方 5：就绪确认（空体，只有客户端路径发）。 */
    static final int TYPE_READY_ACK = 5;
    /** 官方 6：整份 savestate（u32 长度 + blob）。 */
    static final int TYPE_STATE = 6;
    /** 官方 9：按键掩码（int32）。 */
    static final int TYPE_KEYS = 9;

    /**
     * 官方断线重连握手（{@code KpHwm4/AmA8tU.java:263-272 ARc23Z(Socket)}）。
     *
     * <p>它直接把 10 个字节写进 socket，不经过 {@code ARc23Z(short type, int len)}：
     * {@code putInt(6)} + {@code putShort((short) 100)} + {@code putInt(rtt)}。
     * 巧的是长度字段正好等于 6，所以它在线上<b>天然就是一条普通帧</b>——
     * {@code u32 len=6, u16 type=100, int32 rtt}，接收侧的 4B 长度分帧器无需
     * 做任何特殊处理，只要认得 type 100 是「重连握手」即可。</p>
     */
    static final int TYPE_RECONNECT = 100;

    // ---- 以下是我们自己的扩展，从 11 起，不与官方撞号 ----
    static final int TYPE_INPUT_2 = 11;
    static final int TYPE_INPUT_4 = 12;
    static final int TYPE_RESET = 13;
    static final int TYPE_KEYS_LOCAL = 14;
    static final int TYPE_COUNTER = 15;
    static final int TYPE_EVENT = 16;
    /** 槽位 3 的按键掩码（早先借 TYPE_READY 夹带，与官方「3 = RTT」冲突）。 */
    static final int TYPE_INPUT_3 = 17;

    private GBoyFrames() {
    }

    /** Bare frame: {@code length = 2}, no payload. */
    static byte[] frame(int type) {
        byte[] out = new byte[6];
        putInt(out, 0, 2);
        putShort(out, 4, type);
        return out;
    }

    /** Frame carrying a single big endian int. */
    static byte[] frame(int type, int value) {
        byte[] out = new byte[10];
        putInt(out, 0, 6);
        putShort(out, 4, type);
        putInt(out, 6, value);
        return out;
    }

    /** Frame carrying a raw payload (the length counts the two type bytes). */
    static byte[] frame(int type, byte[] payload) {
        byte[] out = new byte[4 + 2 + payload.length];
        putInt(out, 0, 2 + payload.length);
        putShort(out, 4, type);
        System.arraycopy(payload, 0, out, 6, payload.length);
        return out;
    }

    /**
     * The registration frame the official client sends the moment the KCP
     * handshake completes:
     *
     * <pre>
     *   type 1, body: int playerCount, short 0, int baseStateCount
     * </pre>
     *
     * The body is always ten bytes long - the official client allocates
     * {@code ARc23Z((short) 1, 10)} and only fills the trailing six bytes when
     * more than one player is present.
     */
    static byte[] registerFrame(int playerCount, int baseStateCount) {
        byte[] out = new byte[16];
        putInt(out, 0, 12);
        putShort(out, 4, TYPE_REGISTER);
        putInt(out, 6, playerCount);
        putShort(out, 10, 0);
        putInt(out, 12, baseStateCount);
        return out;
    }

    /**
     * 官方重连握手包：{@code int32 6 + int16 100 + int32 rtt}，与
     * {@code frame(TYPE_RECONNECT, rtt)} 字节完全相同（见 {@link #TYPE_RECONNECT}）。
     */
    static byte[] reconnectFrame(int rtt) {
        return frame(TYPE_RECONNECT, rtt);
    }

    /** The message type of a frame body. */
    static int typeOf(byte[] body) {        if (body == null || body.length < 2) {
            return -1;
        }
        return ((body[0] & 0xFF) << 8) | (body[1] & 0xFF);
    }

    /** The int that follows the message type, or 0 when the body is short. */
    static int intOf(byte[] body) {
        if (body == null || body.length < 6) {
            return 0;
        }
        return ((body[2] & 0xFF) << 24) | ((body[3] & 0xFF) << 16)
                | ((body[4] & 0xFF) << 8) | (body[5] & 0xFF);
    }

    /** The payload of a frame body, i.e. everything behind the type. */
    static byte[] payloadOf(byte[] body) {
        if (body == null || body.length <= 2) {
            return new byte[0];
        }
        return Arrays.copyOfRange(body, 2, body.length);
    }

    static void putInt(byte[] out, int offset, int value) {
        out[offset] = (byte) (value >>> 24);
        out[offset + 1] = (byte) (value >>> 16);
        out[offset + 2] = (byte) (value >>> 8);
        out[offset + 3] = (byte) value;
    }

    static void putShort(byte[] out, int offset, int value) {
        out[offset] = (byte) (value >>> 8);
        out[offset + 1] = (byte) value;
    }

    static int getInt(byte[] in, int offset) {
        return ((in[offset] & 0xFF) << 24) | ((in[offset + 1] & 0xFF) << 16)
                | ((in[offset + 2] & 0xFF) << 8) | (in[offset + 3] & 0xFF);
    }

    static int getShort(byte[] in, int offset) {
        return ((in[offset] & 0xFF) << 8) | (in[offset + 1] & 0xFF);
    }

    /**
     * Incremental splitter for the KCP byte stream. The official client does
     * the same thing by hand: read the big endian length, wait until that many
     * bytes are available, then hand the body (type + payload) to the queue.
     */
    static final class Reader {
        private byte[] buffer = new byte[0];
        private int position;

        /** Discards any half-received frame (used after a socket reconnect). */
        void reset() {
            position = 0;
        }

        void append(byte[] data, int length) {
            if (length <= 0) {
                return;
            }            int needed = position + length;
            if (needed > buffer.length) {
                int size = Math.max(needed, buffer.length * 2 + 64);
                buffer = Arrays.copyOf(buffer, size);
            }
            System.arraycopy(data, 0, buffer, position, length);
            position = needed;
        }

        /** Next complete frame body, or null while the frame is incomplete. */
        byte[] next() {
            if (position < 4) {
                return null;
            }
            int length = getInt(buffer, 0);
            if (length < 2 || length > MAX_FRAME_LENGTH) {
                // Not a frame we understand; drop the stream rather than spin.
                // A real save-state frame is far above 64 KiB, so the cap must
                // not reject it (that used to corrupt every following frame).
                position = 0;
                return null;
            }
            if (position < 4 + length) {
                return null;
            }
            byte[] body = Arrays.copyOfRange(buffer, 4, 4 + length);
            int consumed = 4 + length;
            System.arraycopy(buffer, consumed, buffer, 0, position - consumed);
            position -= consumed;
            return body;
        }
    }
}
