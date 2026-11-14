package I3HV03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 extends FilterInputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public volatile byte[] f3858AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f3859AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3860AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3861AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f3862B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final HZUvgL.A4TApA f3863B2KMhB;

    public BPw6Q8(InputStream inputStream, HZUvgL.A4TApA a4TApA) {
        super(inputStream);
        this.f3861AzWtSf = -1;
        this.f3863B2KMhB = a4TApA;
        this.f3858AcNBzu = (byte[]) ((HZUvgL.AaHO0E) a4TApA).ADYaiT(65536, byte[].class);
    }

    public static void A5SV6n() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int A2egSU(InputStream inputStream, byte[] bArr) {
        int i = this.f3861AzWtSf;
        if (i != -1) {
            int i2 = this.f3862B25kr6 - i;
            int i3 = this.f3860AmA8tU;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f3859AlLFFp == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) ((HZUvgL.AaHO0E) this.f3863B2KMhB).ADYaiT(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3858AcNBzu = bArr2;
                    ((HZUvgL.AaHO0E) this.f3863B2KMhB).AYUAbz(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.f3862B25kr6 - this.f3861AzWtSf;
                this.f3862B25kr6 = i4;
                this.f3861AzWtSf = 0;
                this.f3859AlLFFp = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.f3862B25kr6;
                if (read > 0) {
                    i5 += read;
                }
                this.f3859AlLFFp = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f3861AzWtSf = -1;
            this.f3862B25kr6 = 0;
            this.f3859AlLFFp = read2;
        }
        return read2;
    }

    public final synchronized void A4TApA() {
        if (this.f3858AcNBzu != null) {
            ((HZUvgL.AaHO0E) this.f3863B2KMhB).AYUAbz(this.f3858AcNBzu);
            this.f3858AcNBzu = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f3858AcNBzu == null || inputStream == null) {
            A5SV6n();
            throw null;
        }
        return (this.f3859AlLFFp - this.f3862B25kr6) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3858AcNBzu != null) {
            ((HZUvgL.AaHO0E) this.f3863B2KMhB).AYUAbz(this.f3858AcNBzu);
            this.f3858AcNBzu = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.f3860AmA8tU = Math.max(this.f3860AmA8tU, i);
        this.f3861AzWtSf = this.f3862B25kr6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f3858AcNBzu;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            A5SV6n();
            throw null;
        }
        if (this.f3862B25kr6 >= this.f3859AlLFFp && A2egSU(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f3858AcNBzu && (bArr = this.f3858AcNBzu) == null) {
            A5SV6n();
            throw null;
        }
        int i = this.f3859AlLFFp;
        int i2 = this.f3862B25kr6;
        if (i - i2 <= 0) {
            return -1;
        }
        this.f3862B25kr6 = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f3858AcNBzu == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.f3861AzWtSf;
        if (-1 == i) {
            throw new HSHyT0.A5SV6n("Mark has been invalidated, pos: " + this.f3862B25kr6 + " markLimit: " + this.f3860AmA8tU);
        }
        this.f3862B25kr6 = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f3858AcNBzu;
        if (bArr == null) {
            A5SV6n();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            A5SV6n();
            throw null;
        }
        int i = this.f3859AlLFFp;
        int i2 = this.f3862B25kr6;
        if (i - i2 >= j) {
            this.f3862B25kr6 = (int) (i2 + j);
            return j;
        }
        long j2 = i - i2;
        this.f3862B25kr6 = i;
        if (this.f3861AzWtSf == -1 || j > this.f3860AmA8tU) {
            long skip = inputStream.skip(j - j2);
            if (skip > 0) {
                this.f3861AzWtSf = -1;
            }
            return j2 + skip;
        }
        if (A2egSU(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.f3859AlLFFp;
        int i4 = this.f3862B25kr6;
        if (i3 - i4 >= j - j2) {
            this.f3862B25kr6 = (int) ((i4 + j) - j2);
            return j;
        }
        long j3 = (j2 + i3) - i4;
        this.f3862B25kr6 = i3;
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f3858AcNBzu;
        if (bArr2 == null) {
            A5SV6n();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.f3862B25kr6;
            int i6 = this.f3859AlLFFp;
            if (i5 < i6) {
                int i7 = i6 - i5;
                if (i7 >= i2) {
                    i7 = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.f3862B25kr6 += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f3861AzWtSf == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (A2egSU(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f3858AcNBzu && (bArr2 = this.f3858AcNBzu) == null) {
                        A5SV6n();
                        throw null;
                    }
                    int i8 = this.f3859AlLFFp;
                    int i9 = this.f3862B25kr6;
                    i4 = i8 - i9;
                    if (i4 >= i3) {
                        i4 = i3;
                    }
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.f3862B25kr6 += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            A5SV6n();
            throw null;
        }
    }
}
