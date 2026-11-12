/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Minimal GIF89a encoder for gameplay clips. Frames are quantized against a
 * fixed web-safe palette (cheap: no per-clip color analysis, and game frames
 * repeat colors heavily so the nearest-color cache absorbs almost every
 * pixel) and LZW-encoded with the standard variable-width code table. The
 * file loops forever via the Netscape extension.
 */
final class GifEncoder {
    private static final int[] PALETTE = new int[256];

    static {
        int n = 0;
        for (int r = 0; r < 6; r++) {
            for (int g = 0; g < 6; g++) {
                for (int b = 0; b < 6; b++) {
                    PALETTE[n++] = 0xFF000000 | (r * 51 << 16) | (g * 51 << 8) | (b * 51);
                }
            }
        }
        for (int i = 0; n < 256; i++, n++) {
            int v = (i + 1) * 255 / 40;
            PALETTE[n] = 0xFF000000 | (v << 16) | (v << 8) | v;
        }
    }

    private final OutputStream out;
    private final int width;
    private final int height;
    private final HashMap<Integer, Integer> cache = new HashMap<>();
    private boolean started;

    GifEncoder(OutputStream out, int width, int height) {
        this.out = out;
        this.width = Math.max(1, width);
        this.height = Math.max(1, height);
    }

    /** Appends one frame; {@code delayCs} is the frame time in 1/100 s units. */
    void addFrame(Bitmap frame, int delayCs) throws IOException {
        if (!started) {
            writeHeader();
            started = true;
        }
        Bitmap source = frame;
        if (source.getWidth() != width || source.getHeight() != height) {
            source = Bitmap.createScaledBitmap(frame, width, height, true);
        }
        int[] pixels = new int[width * height];
        source.getPixels(pixels, 0, width, 0, 0, width, height);
        byte[] indices = new byte[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            indices[i] = (byte) nearest(pixels[i]);
        }
        // Graphic Control Extension: delay, no transparency.
        out.write(0x21);
        out.write(0xF9);
        out.write(4);
        out.write(0x04);
        out.write(delayCs & 0xFF);
        out.write((delayCs >> 8) & 0xFF);
        out.write(0);
        out.write(0);
        // Image Descriptor covering the whole canvas, global palette.
        out.write(0x2C);
        writeLe(0);
        writeLe(0);
        writeLe(width);
        writeLe(height);
        out.write(0);
        lzw(indices);
        out.flush();
    }

    /** Writes the trailer; the encoder is done after this. */
    void finish() throws IOException {
        if (!started) {
            writeHeader();
        }
        out.write(0x3B);
        out.flush();
    }

    private void writeHeader() throws IOException {
        out.write(bytes("GIF89a"));
        writeLe(width);
        writeLe(height);
        out.write(0xF7); // global color table, 8-bit color resolution, 256 entries
        out.write(0);
        out.write(0);
        for (int p : PALETTE) {
            out.write((p >> 16) & 0xFF);
            out.write((p >> 8) & 0xFF);
            out.write(p & 0xFF);
        }
        out.write(0x21);
        out.write(0xFF);
        out.write(0x0B);
        out.write(bytes("NETSCAPE2.0"));
        out.write(3);
        out.write(1);
        out.write(0);
        out.write(0);
        out.write(0);
    }

    private int nearest(int argb) {
        Integer hit = cache.get(argb);
        if (hit != null) {
            return hit;
        }
        int r = (argb >> 16) & 0xFF;
        int g = (argb >> 8) & 0xFF;
        int b = argb & 0xFF;
        int best = 0;
        int bestDist = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            int p = PALETTE[i];
            int dr = r - ((p >> 16) & 0xFF);
            int dg = g - ((p >> 8) & 0xFF);
            int db = b - (p & 0xFF);
            int dist = dr * dr + dg * dg + db * db;
            if (dist < bestDist) {
                bestDist = dist;
                best = i;
            }
        }
        if (cache.size() > 16384) {
            cache.clear();
        }
        cache.put(argb, best);
        return best;
    }

    /** Standard GIF LZW with 8-bit symbols and 255-byte sub-block chunking. */
    private void lzw(byte[] indices) throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream(1 << 16);
        int clear = 256;
        int eoi = 257;
        int next = 258;
        int bits = 9;
        HashMap<Long, Integer> dict = new HashMap<>(1 << 15);
        BitSink sink = new BitSink(data);
        sink.write(clear, bits);
        int prefix = indices[0] & 0xFF;
        for (int i = 1; i < indices.length; i++) {
            int b = indices[i] & 0xFF;
            long key = ((long) prefix << 8) | b;
            Integer code = dict.get(key);
            if (code != null) {
                prefix = code;
                continue;
            }
            sink.write(prefix, bits);
            if (next == 4096) {
                // Table full: flush the pending code, emit CLEAR, start over.
                // The entry for this iteration is skipped — the decoder does
                // not add one for the first code after a CLEAR either, so
                // both sides stay in lockstep.
                sink.write(clear, bits);
                dict.clear();
                next = 258;
                bits = 9;
            } else {
                dict.put(key, next++);
                if (next > (1 << bits) && bits < 12) {
                    bits++;
                }
            }
            prefix = b;
        }
        sink.write(prefix, bits);
        sink.write(eoi, bits);
        sink.finish();
        byte[] packed = data.toByteArray();
        out.write(8); // LZW minimum code size
        int pos = 0;
        while (pos < packed.length) {
            int chunk = Math.min(255, packed.length - pos);
            out.write(chunk);
            out.write(packed, pos, chunk);
            pos += chunk;
        }
        out.write(0);
    }

    /** Packs variable-width LZW codes LSB-first into a byte stream. */
    private static final class BitSink {
        private final OutputStream out;
        private int bits;
        private int count;

        BitSink(OutputStream out) {
            this.out = out;
        }

        void write(int code, int width) throws IOException {
            bits |= code << count;
            count += width;
            while (count >= 8) {
                out.write(bits & 0xFF);
                bits >>>= 8;
                count -= 8;
            }
        }

        void finish() throws IOException {
            if (count > 0) {
                out.write(bits & 0xFF);
            }
            bits = 0;
            count = 0;
        }
    }

    private void writeLe(int value) throws IOException {
        out.write(value & 0xFF);
        out.write((value >> 8) & 0xFF);
    }

    private static byte[] bytes(String text) {
        try {
            return text.getBytes("US-ASCII");
        } catch (java.io.UnsupportedEncodingException e) {
            return new byte[0];
        }
    }
}
