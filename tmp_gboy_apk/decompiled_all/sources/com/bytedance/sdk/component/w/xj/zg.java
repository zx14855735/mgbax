package com.bytedance.sdk.component.w.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class zg {
    static long hf;
    static qt xj;

    private zg() {
    }

    public static qt xj() {
        synchronized (zg.class) {
            try {
                qt qtVar = xj;
                if (qtVar == null) {
                    return new qt();
                }
                xj = qtVar.y;
                qtVar.y = null;
                hf -= 8192;
                return qtVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void xj(qt qtVar) {
        if (qtVar.y == null && qtVar.c == null) {
            if (qtVar.u) {
                return;
            }
            synchronized (zg.class) {
                try {
                    long j = hf;
                    if (j + 8192 > 65536) {
                        return;
                    }
                    hf = j + 8192;
                    qtVar.y = xj;
                    qtVar.w = 0;
                    qtVar.hf = 0;
                    xj = qtVar;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
