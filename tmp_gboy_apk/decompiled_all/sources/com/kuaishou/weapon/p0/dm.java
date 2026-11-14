package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class dm {

    /* renamed from: a, reason: collision with root package name */
    private static a f12277a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A;

        static {
            ZkEMp();
        }

        private static /* synthetic */ void ZkEMp() {
            char[] charArray = "\u0019\u0015\u0017T\u001d\u001b\u0017\u001fT\u0018\u0015\u0003T\t\u0012\u001f\u0016\u0016T0\u0014\u00138\b\u0013\u001e\u001d\u001f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'z');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0019\u0016\u0013\u0014\u0013\u000e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'z');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private dm() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        boolean is64Bit;
        a aVar = f12277a;
        if (aVar != null) {
            return aVar;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            f12277a = is64Bit ? a.ARM64_V8A : a.ARMEABI_V7A;
        } else {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                f12277a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f12277a = a.ARM64_V8A;
                    } else {
                        f12277a = a.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f12277a = a.UNKNOWN;
                }
            }
        }
        return f12277a;
    }
}
