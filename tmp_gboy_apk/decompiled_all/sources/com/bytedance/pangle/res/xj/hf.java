package com.bytedance.pangle.res.xj;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private boolean am;
    private final byte[] d;
    private int e;
    private final f f;

    /* renamed from: pl, reason: collision with root package name */
    private int[] f10172pl;
    private int qt;
    private c tf;
    private int[] zg;
    HashMap<Integer, Integer> xj = new HashMap<>();
    boolean hf = false;
    private boolean p = false;
    private final xj g = new xj();
    int w = 0;
    int u = 1;
    int kd = 2;
    int y = 3;
    int c = 4;

    public hf(byte[] bArr, f fVar) {
        this.f = fVar;
        this.d = bArr;
        u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ff, code lost:
    
        throw new java.io.IOException(ADYaiT.CtFAbx.ASJ6gh(r2, "Invalid chunk type (", ")."));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void kd() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.xj.hf.kd():void");
    }

    private void u() {
        this.qt = -1;
        this.zg = null;
        this.e = -1;
    }

    public int hf() {
        if (this.tf == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            kd();
            return this.qt;
        } catch (IOException e) {
            xj();
            throw e;
        }
    }

    public int w() {
        return hf();
    }

    public void xj(InputStream inputStream) {
        xj();
        if (inputStream != null) {
            this.tf = new c(new d(new kd(inputStream)));
        }
    }

    public static final class xj {
        private int hf;
        private int w;
        private int[] xj = new int[32];

        public int hf() {
            int i = this.hf;
            if (i == 0) {
                return 0;
            }
            return this.xj[i - 1];
        }

        public void kd() {
            xj(2);
            int i = this.hf;
            int[] iArr = this.xj;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hf = i + 2;
            this.w++;
        }

        public int u() {
            return this.w;
        }

        public boolean w() {
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

        public void xj() {
            this.hf = 0;
            this.w = 0;
        }

        public void y() {
            int i = this.hf;
            if (i == 0) {
                return;
            }
            int i2 = this.xj[i - 1] * 2;
            if ((i - 2) - i2 == 0) {
                return;
            }
            this.hf = i - (i2 + 2);
            this.w--;
        }

        public void xj(int i, int i2) {
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
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.xj = iArr2;
        }
    }

    public void xj() {
        if (this.p) {
            this.p = false;
            this.tf = null;
            this.f10172pl = null;
            this.g.xj();
            u();
        }
    }

    public void hf(InputStream inputStream) {
        xj(inputStream);
    }
}
