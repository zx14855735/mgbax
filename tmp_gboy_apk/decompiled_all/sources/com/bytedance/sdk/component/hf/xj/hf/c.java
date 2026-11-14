package com.bytedance.sdk.component.hf.xj.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class c {
    static long hf;
    static y xj;

    private c() {
    }

    public static y xj() {
        synchronized (c.class) {
            try {
                y yVar = xj;
                if (yVar == null) {
                    return new y();
                }
                xj = yVar.y;
                yVar.y = null;
                hf -= 8192;
                return yVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void xj(y yVar) {
        if (yVar.y == null && yVar.c == null) {
            if (yVar.u) {
                return;
            }
            synchronized (c.class) {
                try {
                    long j = hf;
                    if (j + 8192 > 65536) {
                        return;
                    }
                    hf = j + 8192;
                    yVar.y = xj;
                    yVar.w = 0;
                    yVar.hf = 0;
                    xj = yVar;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
