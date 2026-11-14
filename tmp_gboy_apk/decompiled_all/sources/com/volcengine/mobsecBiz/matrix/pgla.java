package com.volcengine.mobsecBiz.matrix;

import com.sigmob.sdk.archives.tar.e;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class pgla {
    public static native Object a(int i, int i2, long j, String str, Object obj);

    public static Object b(int i, int i2, long j, String str, Object obj) {
        pbly.pgla pglaVar = (pbly.pgla) pbly.f14067A2egSU.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) a(16777217, 0, 0L, "c7cf03", new byte[]{125, 37, 80, 17, 0, 32, 101, 86, 119, e.J, e.J, 60, 3, 82, 6, 42, 118, 23, 62, 63, 118}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.A2egSU(i, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
