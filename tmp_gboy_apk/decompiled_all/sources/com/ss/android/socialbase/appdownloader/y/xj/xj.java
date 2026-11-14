package com.ss.android.socialbase.appdownloader.y.xj;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class xj implements d {
    private int am;
    private boolean c;
    private int d;
    private int f;
    private int g;
    private u hf;
    private int[] kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int[] f13840pl;
    private int qt;
    private int tf;
    private y u;
    private boolean w = false;
    private C0481xj y = new C0481xj();

    public xj() {
        c();
    }

    private final void c() {
        this.f = -1;
        this.d = -1;
        this.tf = -1;
        this.p = -1;
        this.f13840pl = null;
        this.g = -1;
        this.am = -1;
        this.qt = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x016c, code lost:
    
        throw new java.io.IOException(ADYaiT.CtFAbx.ASJ6gh(r5, "Invalid chunk type (", ")."));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void f() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.y.xj.xj.f():void");
    }

    public int hf() {
        if (this.hf == null) {
            throw new f("Parser is not opened.", this, null);
        }
        try {
            f();
            return this.f;
        } catch (IOException e) {
            xj();
            throw e;
        }
    }

    public int kd() {
        if (this.f != 2) {
            return -1;
        }
        return this.f13840pl.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.y.xj.c
    public String u() {
        return "XML line #" + w();
    }

    @Override // com.ss.android.socialbase.appdownloader.y.xj.c
    public int w() {
        return this.d;
    }

    public void xj(InputStream inputStream) {
        xj();
        if (inputStream != null) {
            this.hf = new u(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.y.xj.c
    public int y() {
        return -1;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.y.xj.xj$xj, reason: collision with other inner class name */
    public static final class C0481xj {
        private int hf;
        private int w;
        private int[] xj = new int[32];

        public final int hf() {
            int i = this.hf;
            if (i == 0) {
                return 0;
            }
            return this.xj[i - 1];
        }

        public final void kd() {
            xj(2);
            int i = this.hf;
            int[] iArr = this.xj;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hf = i + 2;
            this.w++;
        }

        public final int u() {
            return this.w;
        }

        public final boolean w() {
            int[] iArr;
            int i;
            int i2 = this.hf;
            if (i2 == 0 || (i = (iArr = this.xj)[i2 - 1]) == 0) {
                return false;
            }
            int i3 = i - 1;
            int i4 = i2 - 3;
            iArr[i4] = i3;
            iArr[i4 - ((i3 * 2) + 1)] = i3;
            this.hf = i2 - 2;
            return true;
        }

        public final void xj() {
            this.hf = 0;
            this.w = 0;
        }

        public final void y() {
            int i = this.hf;
            if (i != 0) {
                int i2 = this.xj[i - 1] * 2;
                if ((i - 2) - i2 != 0) {
                    this.hf = i - (i2 + 2);
                    this.w--;
                }
            }
        }

        public final void xj(int i, int i2) {
            if (this.w == 0) {
                kd();
            }
            xj(2);
            int i3 = this.hf;
            int i4 = i3 - 1;
            int[] iArr = this.xj;
            int i5 = iArr[i4];
            int i6 = (i3 - 2) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i3] = i2;
            iArr[i3 + 1] = i7;
            this.hf = i3 + 2;
        }

        private void xj(int i) {
            int[] iArr = this.xj;
            int length = iArr.length;
            int i2 = this.hf;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.xj = iArr2;
            }
        }
    }

    private final int kd(int i) {
        if (this.f != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.f13840pl.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException(CtFAbx.ASJ6gh(i, "Invalid attribute index (", ")."));
    }

    public String u(int i) {
        int kd = kd(i);
        int[] iArr = this.f13840pl;
        if (iArr[kd + 3] != 3) {
            return "";
        }
        return this.u.xj(iArr[kd + 2]);
    }

    public int w(int i) {
        return this.f13840pl[kd(i) + 4];
    }

    public void xj() {
        if (this.w) {
            this.w = false;
            this.hf.xj();
            this.hf = null;
            this.u = null;
            this.kd = null;
            this.y.xj();
            c();
        }
    }

    public int hf(int i) {
        return this.f13840pl[kd(i) + 3];
    }

    public String xj(int i) {
        int i2 = this.f13840pl[kd(i) + 1];
        return i2 == -1 ? "" : this.u.xj(i2);
    }
}
