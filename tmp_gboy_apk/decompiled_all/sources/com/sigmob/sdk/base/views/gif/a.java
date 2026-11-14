package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    static final int f13292a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = -1;
    private static final String f = "a";
    private static final int g = 4096;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static final int l = -1;
    private static final int m = -1;
    private static final int n = 4;
    private static final int o = 16384;
    private d A;
    private final int[] B;
    private byte[] C;
    private short[] D;
    private Bitmap E;
    private ByteBuffer F;
    private int G;
    private boolean H;
    private int I;
    private byte[] J;
    private byte[] K;
    private int L;
    private int M;
    private int[] p;
    private final InterfaceC0449a q;
    private byte[] r;
    private int s;
    private int t;
    private int u;
    private c v;
    private boolean w;
    private int x;
    private byte[] y;
    private int[] z;

    /* renamed from: com.sigmob.sdk.base.views.gif.a$a, reason: collision with other inner class name */
    public interface InterfaceC0449a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        byte[] a(int i);

        int[] b(int i);
    }

    public a() {
        this(new f());
    }

    private d p() {
        if (this.A == null) {
            this.A = new d();
        }
        return this.A;
    }

    private Bitmap q() {
        Bitmap a2 = this.q.a(this.t, this.s, this.w ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        a(a2);
        return a2;
    }

    private int r() {
        int s = s();
        if (s > 0) {
            try {
                if (this.r == null) {
                    this.r = this.q.a(255);
                }
                int i2 = this.M;
                int i3 = this.L;
                int i4 = i2 - i3;
                if (i4 >= s) {
                    System.arraycopy(this.K, i3, this.r, 0, s);
                    this.L += s;
                    return s;
                }
                if (this.F.remaining() + i4 < s) {
                    this.I = 1;
                    return s;
                }
                System.arraycopy(this.K, this.L, this.r, 0, i4);
                this.L = this.M;
                t();
                int i5 = s - i4;
                System.arraycopy(this.K, 0, this.r, i4, i5);
                this.L += i5;
                return s;
            } catch (Exception e2) {
                SigmobLog.d("Error Reading Block", e2);
                this.I = 1;
            }
        }
        return s;
    }

    private int s() {
        try {
            t();
            byte[] bArr = this.K;
            int i2 = this.L;
            this.L = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.I = 1;
            return 0;
        }
    }

    private void t() {
        if (this.M > this.L) {
            return;
        }
        if (this.K == null) {
            this.K = this.q.a(16384);
        }
        this.L = 0;
        int min = Math.min(this.F.remaining(), 16384);
        this.M = min;
        this.F.get(this.K, 0, min);
    }

    public int a(int i2) {
        if (i2 < 0) {
            return -1;
        }
        c cVar = this.v;
        if (i2 < cVar.d) {
            return cVar.e.get(i2).b;
        }
        return -1;
    }

    public void b() {
        this.v = null;
        byte[] bArr = this.y;
        if (bArr != null) {
            this.q.a(bArr);
        }
        int[] iArr = this.z;
        if (iArr != null) {
            this.q.a(iArr);
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            this.q.a(bitmap);
        }
        this.E = null;
        this.F = null;
        this.w = false;
        byte[] bArr2 = this.r;
        if (bArr2 != null) {
            this.q.a(bArr2);
        }
        byte[] bArr3 = this.K;
        if (bArr3 != null) {
            this.q.a(bArr3);
        }
    }

    public int c() {
        return (this.z.length * 4) + this.F.limit() + this.y.length;
    }

    public int d() {
        return this.u;
    }

    public ByteBuffer e() {
        return this.F;
    }

    public int f() {
        return this.v.d;
    }

    public int g() {
        return this.v.i;
    }

    public int h() {
        return this.v.j;
    }

    public int i() {
        return this.x;
    }

    public int j() {
        int i2;
        if (this.v.d <= 0 || (i2 = this.u) < 0) {
            return 0;
        }
        return a(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:6:0x000e, B:9:0x0035, B:14:0x003e, B:16:0x0052, B:17:0x005e, B:20:0x0067, B:22:0x006b, B:26:0x0080, B:28:0x0084, B:29:0x0092, B:32:0x0063, B:34:0x0098, B:37:0x0016), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:6:0x000e, B:9:0x0035, B:14:0x003e, B:16:0x0052, B:17:0x005e, B:20:0x0067, B:22:0x006b, B:26:0x0080, B:28:0x0084, B:29:0x0092, B:32:0x0063, B:34:0x0098, B:37:0x0016), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080 A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:6:0x000e, B:9:0x0035, B:14:0x003e, B:16:0x0052, B:17:0x005e, B:20:0x0067, B:22:0x006b, B:26:0x0080, B:28:0x0084, B:29:0x0092, B:32:0x0063, B:34:0x0098, B:37:0x0016), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:6:0x000e, B:9:0x0035, B:14:0x003e, B:16:0x0052, B:17:0x005e, B:20:0x0067, B:22:0x006b, B:26:0x0080, B:28:0x0084, B:29:0x0092, B:32:0x0063, B:34:0x0098, B:37:0x0016), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.graphics.Bitmap k() {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to decode frame, status="
            java.lang.String r1 = "No Valid Color Table for frame #"
            java.lang.String r2 = "unable to decode frame, frameCount="
            monitor-enter(r7)
            com.sigmob.sdk.base.views.gif.c r3 = r7.v     // Catch: java.lang.Throwable -> L13
            int r3 = r3.d     // Catch: java.lang.Throwable -> L13
            r4 = 1
            if (r3 <= 0) goto L16
            int r3 = r7.u     // Catch: java.lang.Throwable -> L13
            if (r3 >= 0) goto L35
            goto L16
        L13:
            r0 = move-exception
            goto Lab
        L16:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L13
            com.sigmob.sdk.base.views.gif.c r2 = r7.v     // Catch: java.lang.Throwable -> L13
            int r2 = r2.d     // Catch: java.lang.Throwable -> L13
            r3.append(r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r2 = " framePointer="
            r3.append(r2)     // Catch: java.lang.Throwable -> L13
            int r2 = r7.u     // Catch: java.lang.Throwable -> L13
            r3.append(r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L13
            com.czhj.sdk.logger.SigmobLog.d(r2)     // Catch: java.lang.Throwable -> L13
            r7.I = r4     // Catch: java.lang.Throwable -> L13
        L35:
            int r2 = r7.I     // Catch: java.lang.Throwable -> L13
            r3 = 0
            if (r2 == r4) goto L98
            r5 = 2
            if (r2 != r5) goto L3e
            goto L98
        L3e:
            r0 = 0
            r7.I = r0     // Catch: java.lang.Throwable -> L13
            com.sigmob.sdk.base.views.gif.c r2 = r7.v     // Catch: java.lang.Throwable -> L13
            java.util.List<com.sigmob.sdk.base.views.gif.b> r2 = r2.e     // Catch: java.lang.Throwable -> L13
            int r5 = r7.u     // Catch: java.lang.Throwable -> L13
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L13
            com.sigmob.sdk.base.views.gif.b r2 = (com.sigmob.sdk.base.views.gif.b) r2     // Catch: java.lang.Throwable -> L13
            int r5 = r7.u     // Catch: java.lang.Throwable -> L13
            int r5 = r5 - r4
            if (r5 < 0) goto L5d
            com.sigmob.sdk.base.views.gif.c r6 = r7.v     // Catch: java.lang.Throwable -> L13
            java.util.List<com.sigmob.sdk.base.views.gif.b> r6 = r6.e     // Catch: java.lang.Throwable -> L13
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L13
            com.sigmob.sdk.base.views.gif.b r5 = (com.sigmob.sdk.base.views.gif.b) r5     // Catch: java.lang.Throwable -> L13
            goto L5e
        L5d:
            r5 = r3
        L5e:
            int[] r6 = r2.i     // Catch: java.lang.Throwable -> L13
            if (r6 == 0) goto L63
            goto L67
        L63:
            com.sigmob.sdk.base.views.gif.c r6 = r7.v     // Catch: java.lang.Throwable -> L13
            int[] r6 = r6.f     // Catch: java.lang.Throwable -> L13
        L67:
            r7.p = r6     // Catch: java.lang.Throwable -> L13
            if (r6 != 0) goto L80
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L13
            int r1 = r7.u     // Catch: java.lang.Throwable -> L13
            r0.append(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L13
            com.czhj.sdk.logger.SigmobLog.d(r0)     // Catch: java.lang.Throwable -> L13
            r7.I = r4     // Catch: java.lang.Throwable -> L13
            monitor-exit(r7)
            return r3
        L80:
            boolean r1 = r2.k     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L92
            int[] r1 = r7.B     // Catch: java.lang.Throwable -> L13
            int r3 = r6.length     // Catch: java.lang.Throwable -> L13
            java.lang.System.arraycopy(r6, r0, r1, r0, r3)     // Catch: java.lang.Throwable -> L13
            int[] r1 = r7.B     // Catch: java.lang.Throwable -> L13
            r7.p = r1     // Catch: java.lang.Throwable -> L13
            int r3 = r2.j     // Catch: java.lang.Throwable -> L13
            r1[r3] = r0     // Catch: java.lang.Throwable -> L13
        L92:
            android.graphics.Bitmap r0 = r7.a(r2, r5)     // Catch: java.lang.Throwable -> L13
            monitor-exit(r7)
            return r0
        L98:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L13
            int r0 = r7.I     // Catch: java.lang.Throwable -> L13
            r1.append(r0)     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L13
            com.czhj.sdk.logger.SigmobLog.d(r0)     // Catch: java.lang.Throwable -> L13
            monitor-exit(r7)
            return r3
        Lab:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.k():android.graphics.Bitmap");
    }

    public int l() {
        return this.I;
    }

    public int m() {
        return this.v.m;
    }

    public void n() {
        this.u = -1;
    }

    public void o() {
        this.x = 0;
    }

    public a(InterfaceC0449a interfaceC0449a) {
        this.B = new int[256];
        this.L = 0;
        this.M = 0;
        this.q = interfaceC0449a;
        this.v = new c();
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.G + i2; i10++) {
            byte[] bArr = this.y;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.p[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.G + i12; i13++) {
            byte[] bArr2 = this.y;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.p[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    public boolean b(int i2) {
        if (i2 < -1 || i2 >= f()) {
            return false;
        }
        this.u = i2;
        return true;
    }

    public a(InterfaceC0449a interfaceC0449a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0449a, cVar, byteBuffer, 1);
    }

    public int a(InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                SigmobLog.d("Error reading data from stream", e2);
            }
        } else {
            this.I = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                SigmobLog.d("Error closing stream", e3);
            }
        }
        return this.I;
    }

    public a(InterfaceC0449a interfaceC0449a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0449a);
        a(cVar, byteBuffer, i2);
    }

    public synchronized int a(byte[] bArr) {
        try {
            c c2 = p().a(bArr).c();
            this.v = c2;
            if (bArr != null) {
                a(c2, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.I;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r4.b == r19.j) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap a(com.sigmob.sdk.base.views.gif.b r19, com.sigmob.sdk.base.views.gif.b r20) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.a(com.sigmob.sdk.base.views.gif.b, com.sigmob.sdk.base.views.gif.b):android.graphics.Bitmap");
    }

    private static void a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147 A[LOOP:5: B:68:0x0145->B:69:0x0147, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v40, types: [short] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.sigmob.sdk.base.views.gif.b r29) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.a(com.sigmob.sdk.base.views.gif.b):void");
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        try {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
            int highestOneBit = Integer.highestOneBit(i2);
            this.I = 0;
            this.v = cVar;
            this.w = false;
            this.u = -1;
            o();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.F = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.F.order(ByteOrder.LITTLE_ENDIAN);
            this.H = false;
            Iterator<b> it = cVar.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().c == 3) {
                    this.H = true;
                    break;
                }
            }
            this.G = highestOneBit;
            int i3 = cVar.m;
            this.t = i3 / highestOneBit;
            int i4 = cVar.i;
            this.s = i4 / highestOneBit;
            this.y = this.q.a(i3 * i4);
            this.z = this.q.b(this.t * this.s);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(c cVar, byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    private void a(int[] iArr, b bVar, int i2) {
        int i3 = bVar.h;
        int i4 = this.G;
        int i5 = i3 / i4;
        int i6 = bVar.f / i4;
        int i7 = bVar.g / i4;
        int i8 = bVar.e / i4;
        int i9 = this.t;
        int i10 = (i6 * i9) + i8;
        int i11 = (i5 * i9) + i10;
        while (i10 < i11) {
            int i12 = i10 + i7;
            for (int i13 = i10; i13 < i12; i13++) {
                iArr[i13] = i2;
            }
            i10 += this.t;
        }
    }

    public boolean a() {
        if (this.v.d <= 0) {
            return false;
        }
        if (this.u == f() - 1) {
            this.x++;
        }
        c cVar = this.v;
        int i2 = cVar.j;
        if (i2 != -1 && this.x > i2) {
            return false;
        }
        this.u = (this.u + 1) % cVar.d;
        return true;
    }
}
