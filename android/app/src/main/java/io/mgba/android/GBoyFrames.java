/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.zip.Deflater;

/**
 * Wire format shared by every GBoy / My Boy link flavour.
 *
 * A GBoyLink packet is {@code [u32 payload length][payload]} and the payload
 * opens with a {@code u16} message type:
 *
 *   1 HELLO   u16 type + u32 6 (protocol version)
 *   2 ROMINFO u16 type + 32-byte ASCII MD5 of the ROM + u16 name length + name
 *   3 READY   u16 type only
 *   4 KEYS    u16 type + u32 GBA key mask
 *   5 RESET   u16 type only
 *   6 STATE   u16 type + u32 size + zlib-compressed GBASTATE v4 image
 *
 * The local Wi-Fi link streams these over TCP and the gboy.top cloud room
 * carries the very same payloads inside KCP, so both transports build their
 * packets here.
 */
final class GBoyFrames {
    static final int MSG_HELLO = 1;
    static final int MSG_ROM_INFO = 2;
    static final int MSG_READY = 3;
    static final int MSG_KEYS = 4;
    static final int MSG_RESET = 5;
    static final int MSG_STATE = 6;

    /** Zero-filled body appended to the synthesized state image, in bytes. */
    private static final int STATE_PAD = 900 * 1024;

    private GBoyFrames() {
    }

    /** Bare frame carrying only a message type. */
    static byte[] frame(int messageType) {
        byte[] out = new byte[2];
        out[0] = (byte) (messageType >> 8);
        out[1] = (byte) messageType;
        return out;
    }

    static byte[] frameHello() {
        byte[] frame = new byte[6];
        frame[0] = 0;
        frame[1] = MSG_HELLO;
        frame[2] = 0;
        frame[3] = 0;
        frame[4] = 0;
        frame[5] = 6;
        return frame;
    }

    static byte[] frameKeys(int keys) {
        byte[] frame = new byte[6];
        frame[0] = 0;
        frame[1] = MSG_KEYS;
        frame[2] = (byte) (keys >> 24);
        frame[3] = (byte) (keys >> 16);
        frame[4] = (byte) (keys >> 8);
        frame[5] = (byte) keys;
        return frame;
    }

    static int typeOf(byte[] frame) {
        if (frame == null || frame.length < 2) {
            return -1;
        }
        return ((frame[0] & 0xFF) << 8) | (frame[1] & 0xFF);
    }

    /** Reads the u32 that follows the message type, or 0 when absent. */
    static int valueOf(byte[] frame) {
        if (frame == null || frame.length < 6) {
            return 0;
        }
        return ((frame[2] & 0xFF) << 24) | ((frame[3] & 0xFF) << 16)
                | ((frame[4] & 0xFF) << 8) | (frame[5] & 0xFF);
    }

    /**
     * Builds the ROM_INFO payload: u16 type + 32-char lowercase MD5 of the ROM
     * + u16 name length + file name. GBoy's getRomHash is exactly the MD5 hex
     * of the ROM data, and the 16 bytes at ROM offset 0xA0 carry the
     * title+code it validates savestates against.
     */
    static byte[] romInfo(String path) throws IOException {
        File rom = path == null ? null : new File(path);
        if (rom == null || !rom.isFile()) {
            throw new IOException("找不到当前游戏文件");
        }
        byte[] identity = new byte[16];
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            InputStream in = new FileInputStream(rom);
            try {
                byte[] buf = new byte[65536];
                int n;
                long pos = 0;
                while ((n = in.read(buf)) >= 0) {
                    md.update(buf, 0, n);
                    if (pos < 0xB0 && pos + n > 0xA0) {
                        for (int i = 0; i < n; i++) {
                            long abs = pos + i;
                            if (abs >= 0xA0 && abs < 0xB0) {
                                identity[(int) (abs - 0xA0)] = buf[i];
                            }
                        }
                    }
                    pos += n;
                }
            } finally {
                in.close();
            }
            StringBuilder hex = new StringBuilder(32);
            for (byte b : md.digest()) {
                hex.append(Character.forDigit((b >> 4) & 0xF, 16));
                hex.append(Character.forDigit(b & 0xF, 16));
            }
            byte[] hash = hex.toString().getBytes(StandardCharsets.US_ASCII);
            byte[] name = rom.getName().getBytes(StandardCharsets.UTF_8);
            byte[] frame = new byte[2 + 32 + 2 + name.length];
            frame[0] = 0;
            frame[1] = MSG_ROM_INFO;
            System.arraycopy(hash, 0, frame, 2, 32);
            frame[34] = (byte) (name.length >> 8);
            frame[35] = (byte) name.length;
            System.arraycopy(name, 0, frame, 36, name.length);
            return frame;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("读取游戏失败");
        }
    }

    /** The 32-char MD5 a ROM_INFO payload advertises, or null. */
    static String romHashOf(byte[] frame) {
        if (frame == null || frame.length < 34) {
            return null;
        }
        return new String(frame, 2, 32, StandardCharsets.US_ASCII);
    }

    /**
     * Synthesizes a GBASTATE v4 image the peer will accept: the header GBoy
     * validates (magic, version 4, the 16 ROM identity bytes from offset 0xA0,
     * BIOS flag zero) followed by a zero-filled body, zlib compressed the way
     * GBoy's loadStateFromMemory expects. The peer's link console loads it and
     * that game then simply starts from a fresh boot.
     */
    static byte[] frameState(String path) {
        byte[] raw = new byte[32 + STATE_PAD];
        raw[0] = 'G';
        raw[1] = 'B';
        raw[2] = 'A';
        raw[3] = 'S';
        raw[4] = 'T';
        raw[5] = 'A';
        raw[6] = 'T';
        raw[7] = 'E';
        raw[11] = 4;
        try {
            File rom = path == null ? null : new File(path);
            if (rom != null && rom.isFile()) {
                InputStream in = new FileInputStream(rom);
                try {
                    byte[] head = new byte[16];
                    long skipped = 0;
                    while (skipped < 0xA0) {
                        long step = in.skip(0xA0 - skipped);
                        if (step <= 0) {
                            break;
                        }
                        skipped += step;
                    }
                    int got = 0;
                    while (got < 16) {
                        int n = in.read(head, got, 16 - got);
                        if (n < 0) {
                            break;
                        }
                        got += n;
                    }
                    System.arraycopy(head, 0, raw, 12, 16);
                } finally {
                    in.close();
                }
            }
        } catch (IOException ignored) {
        }
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(raw, 0, raw.length);
            deflater.finish();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream(raw.length / 8 + 64);
            byte[] chunk = new byte[8192];
            int n;
            while ((n = deflater.deflate(chunk)) > 0) {
                buffer.write(chunk, 0, n);
            }
            byte[] compressed = buffer.toByteArray();
            // The u32 after the type is the on-the-wire byte count of the
            // compressed blob (GBoy's h.a() reads exactly that many bytes),
            // not the uncompressed size.
            byte[] frame = new byte[6 + compressed.length];
            frame[0] = 0;
            frame[1] = MSG_STATE;
            int size = compressed.length;
            frame[2] = (byte) (size >> 24);
            frame[3] = (byte) (size >> 16);
            frame[4] = (byte) (size >> 8);
            frame[5] = (byte) size;
            System.arraycopy(compressed, 0, frame, 6, compressed.length);
            return frame;
        } finally {
            deflater.end();
        }
    }
}
