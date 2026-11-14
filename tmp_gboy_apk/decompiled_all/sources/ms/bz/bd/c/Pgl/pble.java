package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pble {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile int f14038A2egSU = -1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile String f14039A4TApA = "";

    public static String A2egSU(Context context) {
        try {
            if (f14039A4TApA == "") {
                f14039A4TApA = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return f14039A4TApA;
    }

    public static Activity A4TApA() {
        ArrayMap arrayMap;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41fbe3", new byte[]{36, 61, 17, 4, 85, 45, com.sigmob.sdk.archives.tar.e.K, 94, com.sigmob.sdk.archives.tar.e.N, 34, com.sigmob.sdk.archives.tar.e.M, 125, com.sigmob.sdk.archives.tar.e.L, 21, 78, 45, 33, 25, 35, 43, 17, 59, 7, 19, 91, 32}));
            Object invoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "16e3d0", new byte[]{35, 33, 4, 85, 94, 41, 38, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 119, 41, 34, 31, com.sigmob.sdk.archives.tar.e.Q, 66, 19, 58, 5, com.sigmob.sdk.archives.tar.e.I, 98, 36}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b1b05a", new byte[]{126, 18, 18, 80, 3, 96, 104, 4, 58, 101, 96}));
            declaredField.setAccessible(true);
            arrayMap = (ArrayMap) declaredField.get(invoke);
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "422625", new byte[]{36, 57, 126, 69});
        }
        if (arrayMap.size() <= 0) {
            return null;
        }
        for (Object obj : arrayMap.values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "604944", new byte[]{com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.K, 82, 94, 14, 39}));
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e96982", new byte[]{117, 56, 81, 68, 17, 44, 114, 1}));
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(obj);
            }
        }
        return null;
    }
}
