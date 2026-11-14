package com.bytedance.sdk.component.y.w.xj.xj;

import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class w implements Closeable {
    private final Charset hf;
    private int kd;
    private int u;
    private byte[] w;
    private final InputStream xj;

    public w(InputStream inputStream, Charset charset) {
        this(inputStream, ProxyCacheUtils.DEFAULT_BUFFER_SIZE, charset);
    }

    private void w() {
        InputStream inputStream = this.xj;
        byte[] bArr = this.w;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.u = 0;
        this.kd = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.xj) {
            try {
                if (this.w != null) {
                    this.w = null;
                    this.xj.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hf() {
        return this.kd == -1;
    }

    public w(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(u.xj)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.xj = inputStream;
        this.hf = charset;
        this.w = new byte[i];
    }

    public String xj() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.xj) {
            try {
                if (this.w == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.u >= this.kd) {
                    w();
                }
                for (int i3 = this.u; i3 != this.kd; i3++) {
                    byte[] bArr2 = this.w;
                    if (bArr2[i3] == 10) {
                        int i4 = this.u;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.hf.name());
                                this.u = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.hf.name());
                        this.u = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.kd - this.u) + 80) { // from class: com.bytedance.sdk.component.y.w.xj.xj.w.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                            i5--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i5, w.this.hf.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.w;
                    int i5 = this.u;
                    byteArrayOutputStream.write(bArr3, i5, this.kd - i5);
                    this.kd = -1;
                    w();
                    i = this.u;
                    while (i != this.kd) {
                        bArr = this.w;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.u;
                if (i != i6) {
                    byteArrayOutputStream.write(bArr, i6, i - i6);
                }
                this.u = i + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
