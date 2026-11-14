package com.bytedance.dutexplorer;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.x.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tmapcloak {
    static int DexNum;
    public static boolean loadLibSuccess;

    static {
        try {
            if (DexNum > 0) {
                y.xj("maparmor");
            }
            loadLibSuccess = true;
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public static native byte bob_bytedance_call(int i, int i2, Object... objArr);

    public static native char cob_bytedance_call(int i, int i2, Object... objArr);

    public static native double dob_bytedance_call(int i, int i2, Object... objArr);

    public static native float fob_bytedance_call(int i, int i2, Object... objArr);

    public static native int iob_bytedance_call(int i, int i2, Object... objArr);

    public static native long job_bytedance_call(int i, int i2, Object... objArr);

    public static native Object obj_bytedance_call(int i, int i2, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static native short sob_bytedance_call(int i, int i2, Object... objArr);

    public static native void voi_bytedance_call(int i, int i2, Object... objArr);

    public static native boolean zob_bytedance_call(int i, int i2, Object... objArr);

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }
}
