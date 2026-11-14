package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa;

import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class aaaaaaa0 implements Closeable {
    private final Charset aaaaaaa0;
    private final InputStream aaaaaaaa;
    private int aaaaaaac;
    private byte[] aaaaaaao;
    private int aaaaaaau;

    public class aaaaaaaa extends ByteArrayOutputStream {
        public aaaaaaaa(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, aaaaaaa0.this.aaaaaaa0.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public aaaaaaa0(InputStream inputStream, Charset charset) {
        this(inputStream, ProxyCacheUtils.DEFAULT_BUFFER_SIZE, charset);
    }

    private void aaaaaaeo() {
        InputStream inputStream = this.aaaaaaaa;
        byte[] bArr = this.aaaaaaao;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.aaaaaaac = 0;
        this.aaaaaaau = read;
    }

    public String aaaeaaaa() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.aaaaaaaa) {
            try {
                if (this.aaaaaaao == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.aaaaaaac >= this.aaaaaaau) {
                    aaaaaaeo();
                }
                for (int i3 = this.aaaaaaac; i3 != this.aaaaaaau; i3++) {
                    byte[] bArr2 = this.aaaaaaao;
                    if (bArr2[i3] == 10) {
                        int i4 = this.aaaaaaac;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.aaaaaaa0.name());
                                this.aaaaaaac = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.aaaaaaa0.name());
                        this.aaaaaaac = i3 + 1;
                        return str2;
                    }
                }
                aaaaaaaa aaaaaaaaVar = new aaaaaaaa((this.aaaaaaau - this.aaaaaaac) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.aaaaaaao;
                    int i5 = this.aaaaaaac;
                    aaaaaaaaVar.write(bArr3, i5, this.aaaaaaau - i5);
                    this.aaaaaaau = -1;
                    aaaaaaeo();
                    i = this.aaaaaaac;
                    while (i != this.aaaaaaau) {
                        bArr = this.aaaaaaao;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.aaaaaaac;
                if (i != i6) {
                    aaaaaaaaVar.write(bArr, i6, i - i6);
                }
                this.aaaaaaac = i + 1;
                return aaaaaaaaVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.aaaaaaaa) {
            try {
                if (this.aaaaaaao != null) {
                    this.aaaaaaao = null;
                    this.aaaaaaaa.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public aaaaaaa0(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(aaaaaaao.aaaaaaaa)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.aaaaaaaa = inputStream;
        this.aaaaaaa0 = charset;
        this.aaaaaaao = new byte[i];
    }
}
