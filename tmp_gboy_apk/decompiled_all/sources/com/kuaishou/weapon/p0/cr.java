package com.kuaishou.weapon.p0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f12249a = false;
    private static volatile boolean b = true;

    static {
        try {
            f12249a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f12249a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f12249a;
    }

    public static boolean b() {
        return b;
    }
}
