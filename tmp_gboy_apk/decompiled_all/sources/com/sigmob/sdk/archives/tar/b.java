package com.sigmob.sdk.archives.tar;

import J3FDQU.A2egSU;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.sigmob.sdk.archives.c {
    private static final int b = 256;
    private static final int c = 8192;

    /* renamed from: a, reason: collision with root package name */
    protected final d f13025a;
    private boolean d;
    private long e;
    private long f;
    private byte[] g;
    private a h;

    public b(InputStream inputStream) {
        this(inputStream, d.b, 512);
    }

    private byte[] h() {
        if (this.d) {
            return null;
        }
        byte[] d = this.f13025a.d();
        if (d == null || this.f13025a.a(d)) {
            this.d = true;
        }
        if (this.d) {
            return null;
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        r5 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r7 = r0.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r7 == (-1)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r7 != 61) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        r5.append((char) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r5 = r5.toString();
        r4 = r4 - r3;
        r3 = new char[r4];
        r8 = r0.read(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r8 != r4) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r1.put(r5, new java.lang.String(r3, 0, r4 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0066, code lost:
    
        throw new java.io.IOException("Failed to read Paxheader. Expected " + r4 + " chars, read " + r8);
     */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.sigmob.sdk.archives.tar.b$1, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.archives.tar.b.i():void");
    }

    private void j() {
        byte[] h;
        if (this.h.m()) {
            do {
                h = h();
                if (this.d) {
                    this.h = null;
                    return;
                }
            } while (new c(h).a());
        }
    }

    @Override // com.sigmob.sdk.archives.c
    public com.sigmob.sdk.archives.a a() {
        return e();
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.e;
        long j2 = this.f;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13025a.h();
    }

    public int d() {
        return this.f13025a.b();
    }

    public a e() {
        if (this.d) {
            return null;
        }
        if (this.h != null) {
            long j = this.e;
            long j2 = this.f;
            do {
                j -= j2;
                if (j > 0) {
                    j2 = skip(j);
                } else {
                    this.g = null;
                }
            } while (j2 > 0);
            throw new RuntimeException("failed to skip current tar entry");
        }
        byte[] h = h();
        if (this.d) {
            this.h = null;
            return null;
        }
        a aVar = new a(h);
        this.h = aVar;
        this.f = 0L;
        this.e = aVar.b();
        if (this.h.p()) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[256];
            while (true) {
                int read = read(bArr);
                if (read < 0) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
            a();
            if (this.h == null) {
                return null;
            }
            if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.h.a(stringBuffer.toString());
        }
        if (this.h.q()) {
            i();
        }
        if (this.h.o()) {
            j();
        }
        return this.h;
    }

    public final a f() {
        return this.h;
    }

    public final boolean g() {
        return this.d;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.f;
        long j2 = this.e;
        if (j >= j2) {
            return -1;
        }
        if (i2 + j > j2) {
            i2 = (int) (j2 - j);
        }
        byte[] bArr2 = this.g;
        if (bArr2 != null) {
            i3 = i2 > bArr2.length ? bArr2.length : i2;
            System.arraycopy(bArr2, 0, bArr, i, i3);
            byte[] bArr3 = this.g;
            if (i3 >= bArr3.length) {
                this.g = null;
            } else {
                int length = bArr3.length - i3;
                byte[] bArr4 = new byte[length];
                System.arraycopy(bArr3, i3, bArr4, 0, length);
                this.g = bArr4;
            }
            i2 -= i3;
            i += i3;
        } else {
            i3 = 0;
        }
        while (i2 > 0) {
            byte[] d = this.f13025a.d();
            if (d == null) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "unexpected EOF with ", " bytes unread. Occured at byte: ");
                B9tovu2.append(c());
                throw new IOException(B9tovu2.toString());
            }
            a(d.length);
            int length2 = d.length;
            if (length2 > i2) {
                System.arraycopy(d, 0, bArr, i, i2);
                int i4 = length2 - i2;
                byte[] bArr5 = new byte[i4];
                this.g = bArr5;
                System.arraycopy(d, i2, bArr5, 0, i4);
                length2 = i2;
            } else {
                System.arraycopy(d, 0, bArr, i, length2);
            }
            i3 += length2;
            i2 -= length2;
            i += length2;
        }
        this.f += i3;
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        byte[] bArr = new byte[8192];
        long j2 = j;
        while (j2 > 0) {
            long j3 = 8192;
            if (j2 <= j3) {
                j3 = j2;
            }
            int read = read(bArr, 0, (int) j3);
            if (read == -1) {
                break;
            }
            j2 -= read;
        }
        return j - j2;
    }

    public b(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public final void a(a aVar) {
        this.h = aVar;
    }

    public b(InputStream inputStream, int i, int i2) {
        this.f13025a = new d(inputStream, i, i2);
        this.g = null;
        this.d = false;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    @Override // com.sigmob.sdk.archives.c
    public boolean a(com.sigmob.sdk.archives.a aVar) {
        if (aVar instanceof a) {
            return !((a) aVar).o();
        }
        return false;
    }

    public static boolean a(byte[] bArr, int i) {
        if (i < 265) {
            return false;
        }
        if (com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, 257, 6) && com.sigmob.sdk.archives.utils.a.a(e.V, bArr, 263, 2)) {
            return true;
        }
        if (com.sigmob.sdk.archives.utils.a.a(e.W, bArr, 257, 6) && (com.sigmob.sdk.archives.utils.a.a(e.X, bArr, 263, 2) || com.sigmob.sdk.archives.utils.a.a(e.Y, bArr, 263, 2))) {
            return true;
        }
        return com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, 257, 6) && com.sigmob.sdk.archives.utils.a.a(e.aa, bArr, 263, 2);
    }
}
