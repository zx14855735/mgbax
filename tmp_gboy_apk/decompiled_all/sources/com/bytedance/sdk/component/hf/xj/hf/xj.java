package com.bytedance.sdk.component.hf.xj.hf;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.views.r;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements hf, w, Cloneable, ByteChannel {
    private static final byte[] w = {e.H, e.I, e.J, e.K, e.L, e.M, e.N, e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    long hf;
    y xj;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xj)) {
            return false;
        }
        xj xjVar = (xj) obj;
        long j = this.hf;
        if (j != xjVar.hf) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        y yVar = this.xj;
        y yVar2 = xjVar.xj;
        int i = yVar.hf;
        int i2 = yVar2.hf;
        while (j2 < this.hf) {
            long min = Math.min(yVar.w - i, yVar2.w - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (yVar.xj[i] != yVar2.xj[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == yVar.w) {
                yVar = yVar.y;
                i = yVar.hf;
            }
            if (i2 == yVar2.w) {
                yVar2 = yVar2.y;
                i2 = yVar2.hf;
            }
            j2 += min;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        y yVar = this.xj;
        if (yVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = yVar.w;
            for (int i3 = yVar.hf; i3 < i2; i3++) {
                i = (i * 31) + yVar.xj[i3];
            }
            yVar = yVar.y;
        } while (yVar != this.xj);
        return i;
    }

    public byte hf() {
        long j = this.hf;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        y yVar = this.xj;
        int i = yVar.hf;
        int i2 = yVar.w;
        int i3 = i + 1;
        byte b = yVar.xj[i];
        this.hf = j - 1;
        if (i3 != i2) {
            yVar.hf = i3;
            return b;
        }
        this.xj = yVar.hf();
        c.xj(yVar);
        return b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final u kd() {
        long j = this.hf;
        if (j <= 2147483647L) {
            return u((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hf);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        y yVar = this.xj;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), yVar.w - yVar.hf);
        byteBuffer.put(yVar.xj, yVar.hf, min);
        int i = yVar.hf + min;
        yVar.hf = i;
        this.hf -= min;
        if (i == yVar.w) {
            this.xj = yVar.hf();
            c.xj(yVar);
        }
        return min;
    }

    public String toString() {
        return kd().toString();
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public xj clone() {
        xj xjVar = new xj();
        if (this.hf == 0) {
            return xjVar;
        }
        y xj = this.xj.xj();
        xjVar.xj = xj;
        xj.c = xj;
        xj.y = xj;
        y yVar = this.xj;
        while (true) {
            yVar = yVar.y;
            if (yVar == this.xj) {
                xjVar.hf = this.hf;
                return xjVar;
            }
            xjVar.xj.c.xj(yVar.xj());
        }
    }

    public String w() {
        try {
            return xj(this.hf, tf.xj);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            y w2 = w(1);
            int min = Math.min(i, 8192 - w2.w);
            byteBuffer.get(w2.xj, w2.w, min);
            i -= min;
            w2.w += min;
        }
        this.hf += remaining;
        return remaining;
    }

    public boolean xj() {
        return this.hf == 0;
    }

    public String xj(long j, Charset charset) {
        tf.xj(this.hf, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        y yVar = this.xj;
        int i = yVar.hf;
        if (i + j > yVar.w) {
            return new String(xj(j), charset);
        }
        String str = new String(yVar.xj, i, (int) j, charset);
        int i2 = (int) (yVar.hf + j);
        yVar.hf = i2;
        this.hf -= j;
        if (i2 == yVar.w) {
            this.xj = yVar.hf();
            c.xj(yVar);
        }
        return str;
    }

    public y w(int i) {
        if (i > 0 && i <= 8192) {
            y yVar = this.xj;
            if (yVar == null) {
                y xj = c.xj();
                this.xj = xj;
                xj.c = xj;
                xj.y = xj;
                return xj;
            }
            y yVar2 = yVar.c;
            return (yVar2.w + i > 8192 || !yVar2.kd) ? yVar2.xj(c.xj()) : yVar2;
        }
        throw new IllegalArgumentException();
    }

    public final u u(int i) {
        if (i == 0) {
            return u.w;
        }
        return new f(this, i);
    }

    public xj hf(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            tf.xj(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                y w2 = w(1);
                int min = Math.min(i3 - i, 8192 - w2.w);
                System.arraycopy(bArr, i, w2.xj, w2.w, min);
                i += min;
                w2.w += min;
            }
            this.hf += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] xj(long j) {
        tf.xj(this.hf, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            xj(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public xj hf(int i) {
        y w2 = w(1);
        byte[] bArr = w2.xj;
        int i2 = w2.w;
        w2.w = i2 + 1;
        bArr[i2] = (byte) i;
        this.hf++;
        return this;
    }

    public void xj(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int xj = xj(bArr, i, bArr.length - i);
            if (xj == -1) {
                throw new EOFException();
            }
            i += xj;
        }
    }

    public xj hf(long j) {
        if (j == 0) {
            return hf(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        y w2 = w(numberOfTrailingZeros);
        byte[] bArr = w2.xj;
        int i = w2.w;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = w[(int) (15 & j)];
            j >>>= 4;
        }
        w2.w += numberOfTrailingZeros;
        this.hf += numberOfTrailingZeros;
        return this;
    }

    public int xj(byte[] bArr, int i, int i2) {
        tf.xj(bArr.length, i, i2);
        y yVar = this.xj;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(i2, yVar.w - yVar.hf);
        System.arraycopy(yVar.xj, yVar.hf, bArr, i, min);
        int i3 = yVar.hf + min;
        yVar.hf = i3;
        this.hf -= min;
        if (i3 == yVar.w) {
            this.xj = yVar.hf();
            c.xj(yVar);
        }
        return min;
    }

    public xj xj(String str) {
        return xj(str, 0, str.length());
    }

    public xj xj(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
                B9tovu2.append(str.length());
                throw new IllegalArgumentException(B9tovu2.toString());
            }
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    y w2 = w(1);
                    byte[] bArr = w2.xj;
                    int i3 = w2.w - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    int i5 = w2.w;
                    int i6 = (i3 + i) - i5;
                    w2.w = i5 + i6;
                    this.hf += i6;
                } else {
                    if (charAt2 < 2048) {
                        hf((charAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                        hf((charAt2 & '?') | r.b.d);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            hf((i8 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                            hf(((i8 >> 12) & 63) | r.b.d);
                            hf(((i8 >> 6) & 63) | r.b.d);
                            hf((i8 & 63) | r.b.d);
                            i += 2;
                        } else {
                            hf(63);
                            i = i7;
                        }
                    } else {
                        hf((charAt2 >> '\f') | 224);
                        hf(((charAt2 >> 6) & 63) | r.b.d);
                        hf((charAt2 & '?') | r.b.d);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }

    public xj xj(int i) {
        if (i < 128) {
            hf(i);
            return this;
        }
        if (i < 2048) {
            hf((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            hf((i & 63) | r.b.d);
            return this;
        }
        if (i >= 65536) {
            if (i <= 1114111) {
                hf((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                hf(((i >> 12) & 63) | r.b.d);
                hf(((i >> 6) & 63) | r.b.d);
                hf((i & 63) | r.b.d);
                return this;
            }
            throw new IllegalArgumentException(CtFAbx.AzWtSf(new StringBuilder("Unexpected code point: "), i));
        }
        if (i >= 55296 && i <= 57343) {
            hf(63);
            return this;
        }
        hf((i >> 12) | 224);
        hf(((i >> 6) & 63) | r.b.d);
        hf((i & 63) | r.b.d);
        return this;
    }

    public xj xj(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
                B9tovu2.append(str.length());
                throw new IllegalArgumentException(B9tovu2.toString());
            }
            if (charset != null) {
                if (charset.equals(tf.xj)) {
                    return xj(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return hf(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }
}
