package com.bytedance.pangle.c.xj;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class xj {
    private boolean c;
    private int[] d;
    private hf f;
    private y p;
    private int y;
    private boolean tf = false;

    /* renamed from: pl, reason: collision with root package name */
    private final w f10171pl = new w();
    int xj = 0;
    int hf = 1;
    int w = 2;
    int u = 3;
    int kd = 4;

    public xj() {
        u();
    }

    private int kd(int i) {
        if (this.y != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.d.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException(CtFAbx.ASJ6gh(i, "Invalid attribute index (", ")."));
    }

    public int hf() {
        try {
            if (this.f == null) {
                throw new IOException("Parser is not opened.");
            }
            kd();
            return this.y;
        } catch (IOException e) {
            xj();
            throw e;
        }
    }

    public String u(int i) {
        int kd = kd(i);
        int[] iArr = this.d;
        if (iArr[kd + 3] != 3) {
            return "";
        }
        return this.p.xj(iArr[kd + 2]);
    }

    public int w() {
        if (this.y != 2) {
            return -1;
        }
        return this.d.length / 5;
    }

    public void xj(InputStream inputStream) {
        xj();
        if (inputStream != null) {
            this.f = new hf(inputStream);
        }
    }

    public int w(int i) {
        return this.d[kd(i) + 4];
    }

    public void xj() {
        if (this.tf) {
            this.tf = false;
            this.f.xj();
            this.p = null;
            this.f = null;
            this.f10171pl.xj();
            u();
        }
    }

    private void u() {
        this.d = null;
        this.y = -1;
    }

    public int hf(int i) {
        return this.d[kd(i) + 3];
    }

    public String xj(int i) {
        int i2 = this.d[kd(i) + 1];
        return i2 == -1 ? "" : this.p.xj(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0157, code lost:
    
        throw new java.io.IOException(ADYaiT.CtFAbx.ASJ6gh(r2, "Invalid chunk type (", ")."));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x008b, code lost:
    
        throw new java.io.IOException(ADYaiT.CtFAbx.ASJ6gh(r2, "Invalid resource ids size (", ")."));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void kd() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.c.xj.xj.kd():void");
    }
}
