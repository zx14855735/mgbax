package com.sigmob.sdk.base.views.gif;

import B4ZgIw.AYUAbz;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.views.r;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13295a = "GifHeaderParser";
    private static final int b = 2;
    private static final int c = 10;
    private static final int d = 256;
    private final byte[] e = new byte[256];
    private int f = 0;
    private c g;
    private ByteBuffer h;

    private void b(int i) {
        boolean z = false;
        while (!z && !d() && this.g.d <= i) {
            int e = e();
            if (e == 33) {
                int e2 = e();
                if (e2 != 1) {
                    if (e2 == 249) {
                        this.g.c = new b();
                        i();
                    } else if (e2 != 254) {
                        if (e2 != 255) {
                            o();
                        } else {
                            g();
                            String str = "";
                            for (int i2 = 0; i2 < 11; i2++) {
                                StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
                                A4TApA2.append((char) this.e[i2]);
                                str = A4TApA2.toString();
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                l();
                            }
                        }
                    }
                }
                o();
            } else if (e == 44) {
                c cVar = this.g;
                if (cVar.c == null) {
                    cVar.c = new b();
                }
                f();
            } else if (e != 59) {
                this.g.l = 1;
            } else {
                z = true;
            }
        }
    }

    private boolean d() {
        return this.g.l != 0;
    }

    private int e() {
        try {
            return this.h.get() & 255;
        } catch (Exception unused) {
            this.g.l = 1;
            return 0;
        }
    }

    private void f() {
        this.g.c.e = m();
        this.g.c.f = m();
        this.g.c.g = m();
        this.g.c.h = m();
        int e = e();
        boolean z = (e & r.b.d) != 0;
        int pow = (int) Math.pow(2.0d, (e & 7) + 1);
        b bVar = this.g.c;
        bVar.d = (e & 64) != 0;
        if (z) {
            bVar.i = a(pow);
        } else {
            bVar.i = null;
        }
        this.g.c.f13293a = this.h.position();
        p();
        if (d()) {
            return;
        }
        c cVar = this.g;
        cVar.d++;
        cVar.e.add(cVar.c);
    }

    private int g() {
        int e = e();
        this.f = e;
        int i = 0;
        if (e > 0) {
            while (true) {
                try {
                    int i2 = this.f;
                    if (i >= i2) {
                        break;
                    }
                    int i3 = i2 - i;
                    this.h.get(this.e, i, i3);
                    i += i3;
                } catch (Exception unused) {
                    this.g.l = 1;
                }
            }
        }
        return i;
    }

    private void h() {
        b(Integer.MAX_VALUE);
    }

    private void i() {
        e();
        int e = e();
        b bVar = this.g.c;
        int i = (e & 28) >> 2;
        bVar.c = i;
        if (i == 0) {
            bVar.c = 1;
        }
        bVar.k = (e & 1) != 0;
        int m = m();
        if (m < 2) {
            m = 10;
        }
        b bVar2 = this.g.c;
        bVar2.b = m * 10;
        bVar2.j = e();
        e();
    }

    private void j() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
            A4TApA2.append((char) e());
            str = A4TApA2.toString();
        }
        if (!str.startsWith("GIF")) {
            this.g.l = 1;
            return;
        }
        k();
        if (!this.g.g || d()) {
            return;
        }
        c cVar = this.g;
        cVar.f = a(cVar.h);
        c cVar2 = this.g;
        cVar2.f13294a = cVar2.f[cVar2.b];
    }

    private void k() {
        this.g.m = m();
        this.g.i = m();
        int e = e();
        c cVar = this.g;
        cVar.g = (e & r.b.d) != 0;
        cVar.h = 2 << (e & 7);
        cVar.b = e();
        this.g.k = e();
    }

    private void l() {
        do {
            g();
            byte[] bArr = this.e;
            if (bArr[0] == 1) {
                int i = bArr[1] & 255;
                int i2 = bArr[2] & 255;
                c cVar = this.g;
                int i3 = (i2 << 8) | i;
                cVar.j = i3;
                if (i3 == 0) {
                    cVar.j = -1;
                }
            }
            if (this.f <= 0) {
                return;
            }
        } while (!d());
    }

    private int m() {
        return this.h.getShort();
    }

    private void n() {
        this.h = null;
        Arrays.fill(this.e, (byte) 0);
        this.g = new c();
        this.f = 0;
    }

    private void o() {
        int e;
        do {
            try {
                e = e();
                ByteBuffer byteBuffer = this.h;
                byteBuffer.position(byteBuffer.position() + e);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (e > 0);
    }

    private void p() {
        e();
        o();
    }

    public d a(ByteBuffer byteBuffer) {
        n();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.h = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.h.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public c c() {
        if (this.h == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (d()) {
            return this.g;
        }
        j();
        if (!d()) {
            h();
            c cVar = this.g;
            if (cVar.d < 0) {
                cVar.l = 1;
            }
        }
        return this.g;
    }

    public d a(byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        this.h = null;
        this.g.l = 2;
        return this;
    }

    public void a() {
        this.h = null;
        this.g = null;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.h.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | com.sigmob.sdk.base.blurkit.d.f13043a | (bArr[i5] & 255);
                i2 = i7;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            SigmobLog.d("Format Error Reading Color Table", e);
            this.g.l = 1;
            return iArr;
        }
    }

    public boolean b() {
        j();
        if (!d()) {
            b(2);
        }
        return this.g.d > 1;
    }
}
