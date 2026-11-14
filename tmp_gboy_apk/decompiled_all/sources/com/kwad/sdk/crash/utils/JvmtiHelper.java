package com.kwad.sdk.crash.utils;

import A5SV6n.A2egSU;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class JvmtiHelper {
    private static final String AGENT_LIB = "ti-monitor";
    private static final long DELAY_MS = 200;
    public static final String KEY = "TI_PERF_MONITOR";
    private static final long LOW_MEM_THRESHOLD = 209715200;
    private static final int MB = 1048576;
    private static final int MIN_ALLOC_SIZE = 3145728;
    private static final int MIN_CLASS_LEN = 10485760;
    private static final int MIN_INTERVAL = 10;
    public static final String TAG = "jvmti";
    private static boolean isJdwpEnable;
    private static int mAllocRealSetting;
    private static int mLoadSizeRealSetting;
    private static boolean mLoaded;
    private static long preAllocEventTime;
    private static String preAllocMsg;
    private static String preClassLoadMsg;

    public static native boolean avoidDeoptForReleaseBuild();

    public static native boolean disableJdwp();

    private static void doAllocAsyncReport(String str, long j) {
    }

    private static void doClazzLoadAsyncReport(String str) {
        System.currentTimeMillis();
    }

    private static void doGCAsyncReport(String str) {
        System.currentTimeMillis();
    }

    public static native boolean enableJdwp();

    public static boolean ensureAgentLoad() {
        loadLibrary("openjdkjvmti");
        return true;
    }

    @A2egSU
    public static void fastUnwindStack(String str) {
        try {
            for (StackTraceElement stackTraceElement : frameInfoToTrace(str)) {
                stackTraceElement.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static native StackTraceElement[] frameInfoToTrace(String str);

    public static int getAllocSizeRealSetting() {
        return mAllocRealSetting;
    }

    public static int getLoadSizeRealSetting() {
        return mLoadSizeRealSetting;
    }

    private static native long getObjectSize(Object obj);

    public static boolean isJDWPEnable() {
        return isJdwpEnable;
    }

    public static boolean isLoaded() {
        return mLoaded;
    }

    public static boolean loadLibrary(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "java.lang.System");
            ((Method) declaredMethod2.invoke(cls, "loadLibrary", new Class[]{String.class})).invoke(cls, str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return true;
    }

    private static native boolean loadTiAgent();

    @A2egSU
    public static void logEvent(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!str.startsWith("alloc_obj")) {
                if (str.startsWith("gc_start")) {
                    doGCAsyncReport(str);
                    return;
                }
                if (str.startsWith("class_load") && !str.equals(preClassLoadMsg)) {
                    preClassLoadMsg = str;
                    doClazzLoadAsyncReport(str);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - preAllocEventTime >= 10 && !str.equals(preAllocMsg)) {
                preAllocEventTime = currentTimeMillis;
                preAllocMsg = str;
                doAllocAsyncReport(str, currentTimeMillis);
                return;
            }
            preAllocEventTime = currentTimeMillis;
            preAllocMsg = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static native void setConfig(int i, int i2, int i3, int i4, boolean z, boolean z2, String str, boolean z3);

    private static boolean unlikely(boolean z) {
        return z;
    }

    private static native boolean unloadAgent();

    public static void unloadTiAgent() {
        if (mLoaded) {
            unloadAgent();
            mLoaded = false;
        }
    }
}
