package com.ss.android.socialbase.downloader.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private xj hf;
    private int u = 10;
    private int w;
    private xj xj;

    public static class xj {
        long hf;
        xj u;
        xj w;
        long xj;

        private xj() {
        }
    }

    public long hf(long j, long j2) {
        synchronized (this) {
            try {
                xj xjVar = this.xj;
                if (xjVar == null) {
                    return -1L;
                }
                xj xj2 = xj(j);
                if (xj2 == null) {
                    return -1L;
                }
                long j3 = xjVar.xj - xj2.xj;
                long j4 = j2 - xj2.hf;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean xj(long j, long j2) {
        synchronized (this) {
            try {
                xj xjVar = this.xj;
                if (xjVar != null) {
                    if (j >= xjVar.xj && j2 >= xjVar.hf) {
                        xj xjVar2 = xjVar.w;
                        if (xjVar2 != null && j2 - xjVar2.hf < 1000) {
                            xjVar.xj = j;
                            xjVar.hf = j2;
                            return true;
                        }
                    }
                    return false;
                }
                xj xj2 = xj();
                xj2.xj = j;
                xj2.hf = j2;
                if (xjVar != null) {
                    xj2.w = xjVar;
                    xjVar.u = xj2;
                }
                this.xj = xj2;
                return true;
            } finally {
            }
        }
    }

    private xj xj() {
        xj xjVar;
        int i = this.w;
        if (i >= this.u && (xjVar = this.hf) != null) {
            xj xjVar2 = xjVar.u;
            xjVar.u = null;
            this.hf = xjVar2;
            if (xjVar2 != null) {
                xjVar2.w = null;
            }
            return xjVar;
        }
        this.w = i + 1;
        return new xj();
    }

    private xj xj(long j) {
        xj xjVar = this.xj;
        xj xjVar2 = null;
        while (xjVar != null && xjVar.hf > j) {
            xjVar2 = xjVar;
            xjVar = xjVar.w;
        }
        return (xjVar == null || xjVar2 == null || xjVar == xjVar2 || j - xjVar.hf >= xjVar2.hf - j) ? xjVar2 : xjVar;
    }
}
