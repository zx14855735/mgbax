package com.bytedance.sdk.openadsdk.core.qt;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static int hf = 0;
    public static int kd = 3;
    public static int u = 2;
    public static int w = 1;
    public static int xj = -1;
    private int y = xj;
    private long c = 0;
    private long f = 0;
    private long d = 0;
    private final List<y> tf = new ArrayList();

    public void hf(long j) {
        int i;
        int i2 = this.y;
        if (i2 == xj || i2 == (i = kd)) {
            return;
        }
        this.y = i;
        this.d = j;
    }

    public void u(long j) {
        int i = this.y;
        if (i == xj || i != u) {
            return;
        }
        this.y = w;
        this.tf.add(new y(this.f, j));
        this.f = 0L;
    }

    public void w(long j) {
        int i;
        int i2 = this.y;
        if (i2 == xj || i2 == (i = u) || i2 == kd) {
            return;
        }
        this.y = i;
        this.f = j;
    }

    public void xj(long j) {
        this.y = hf;
        this.c = j;
    }

    public long xj(long j, long j2) {
        long j3;
        long j4;
        long hf2;
        long j5 = this.d;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (y yVar : this.tf) {
            if (yVar.hf() > j) {
                if (j < yVar.xj()) {
                    j4 = i;
                    hf2 = yVar.hf() - yVar.xj();
                } else {
                    j4 = i;
                    hf2 = yVar.hf() - j;
                }
                i = (int) (hf2 + j4);
            }
        }
        long j6 = this.c;
        if (j6 < j) {
            long j7 = this.f;
            if (j7 == 0) {
                j7 = this.d;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - i;
        }
        long j8 = this.f;
        if (j8 == 0) {
            j8 = this.d;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - i;
        return j3 - i;
    }

    public int xj() {
        return this.y;
    }
}
