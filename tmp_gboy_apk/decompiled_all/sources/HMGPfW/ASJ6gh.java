package HMGPfW;

import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Closeable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final FileInputStream f3408AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Charset f3409AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public byte[] f3410AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3411AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f3412B25kr6;

    public ASJ6gh(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(AYUAbz.f3413A2egSU)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f3408AcNBzu = fileInputStream;
        this.f3409AlLFFp = charset;
        this.f3410AmA8tU = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
    }

    public final String A2egSU() {
        int i;
        synchronized (this.f3408AcNBzu) {
            try {
                byte[] bArr = this.f3410AmA8tU;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f3411AzWtSf >= this.f3412B25kr6) {
                    int read = this.f3408AcNBzu.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f3411AzWtSf = 0;
                    this.f3412B25kr6 = read;
                }
                for (int i2 = this.f3411AzWtSf; i2 != this.f3412B25kr6; i2++) {
                    byte[] bArr2 = this.f3410AmA8tU;
                    if (bArr2[i2] == 10) {
                        int i3 = this.f3411AzWtSf;
                        if (i2 != i3) {
                            i = i2 - 1;
                            if (bArr2[i] == 13) {
                                String str = new String(bArr2, i3, i - i3, this.f3409AlLFFp.name());
                                this.f3411AzWtSf = i2 + 1;
                                return str;
                            }
                        }
                        i = i2;
                        String str2 = new String(bArr2, i3, i - i3, this.f3409AlLFFp.name());
                        this.f3411AzWtSf = i2 + 1;
                        return str2;
                    }
                }
                ARc23Z aRc23Z = new ARc23Z(this, (this.f3412B25kr6 - this.f3411AzWtSf) + 80);
                while (true) {
                    byte[] bArr3 = this.f3410AmA8tU;
                    int i4 = this.f3411AzWtSf;
                    aRc23Z.write(bArr3, i4, this.f3412B25kr6 - i4);
                    this.f3412B25kr6 = -1;
                    byte[] bArr4 = this.f3410AmA8tU;
                    int read2 = this.f3408AcNBzu.read(bArr4, 0, bArr4.length);
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f3411AzWtSf = 0;
                    this.f3412B25kr6 = read2;
                    for (int i5 = 0; i5 != this.f3412B25kr6; i5++) {
                        byte[] bArr5 = this.f3410AmA8tU;
                        if (bArr5[i5] == 10) {
                            int i6 = this.f3411AzWtSf;
                            if (i5 != i6) {
                                aRc23Z.write(bArr5, i6, i5 - i6);
                            }
                            this.f3411AzWtSf = i5 + 1;
                            return aRc23Z.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f3408AcNBzu) {
            try {
                if (this.f3410AmA8tU != null) {
                    this.f3410AmA8tU = null;
                    this.f3408AcNBzu.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
