package com.octopus.ad.internal.utilities;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.octopus.ad.internal.utilities.HaoboLogListener;
import com.octopus.ad.utils.b.f;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class HaoboLog {
    private static final boolean mIsDebug = false;
    public static String baseLogTag = "OCTOPUS_SDK";
    public static String mediationLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-MEDIATION");
    public static String publicFunctionsLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-INTERFACE");
    public static String httpReqLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-REQUEST");
    public static String httpRespLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-RESPONSE");
    public static String pbLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-PB");
    public static String xmlLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-XML");
    public static String jsonLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-JSON");
    public static String jsLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-JS");
    public static String mraidLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-MRAID");
    public static String browserLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-APPBROWSER");
    public static String nativeLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-NATIVE");
    public static String videoLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-VIDEO");
    public static String fixLog = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-FIX");
    public static String pingerLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-PINGER");
    public static String lruDiskUsageLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-LRUDISKUSAGE");
    public static String httpProxyCacheServerLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-CACHESERVER");
    public static String httpUrlSourceLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-URLSOURCE");
    public static String proxyCacheLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-PROXYCACHE");
    public static String proxyCacheUtilsLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-PROXYCACHEUTILS");
    public static String storageUtilsLogTag = CtFAbx.B25kr6(new StringBuilder(), baseLogTag, "-STORAGEUTILS");
    private static SoftReference<Context> sLogContext = new SoftReference<>(null);
    private static String lastRequest = "";
    private static String lastResponse = "";
    private static String lastLog = "";
    private static final ArrayList<HaoboLogListener> listeners = new ArrayList<>();

    static {
        jaHoDtd();
    }

    public static synchronized void clearLastResponse() {
        synchronized (HaoboLog.class) {
            lastResponse = "";
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.D, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.E, str, str2);
            logIfLoggable(str, str2, 6, null);
        }
    }

    public static synchronized String getLastLogRequest() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastLog;
        }
        return str;
    }

    public static synchronized String getLastRequest() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastRequest;
        }
        return str;
    }

    public static synchronized String getLastResponse() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastResponse;
        }
        return str;
    }

    public static String getString(int i) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static void i(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.I, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    private static /* synthetic */ void jaHoDtd() {
        char[] charArray = "\u0096\u009a\u0098Û\u0092\u0094\u0098\u0090Û\u0097\u009a\u008cÛ\u0086\u009d\u0090\u0099\u0099Û¿\u009b\u009c·\u0087\u009c\u0091\u0092\u0090".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 245);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0096\u0099\u009c\u009b\u009c\u0081".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 245);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void logIfLoggable(String str, String str2, int i, Throwable th) {
    }

    private static synchronized void notifyListener(HaoboLogListener.LOG_LEVEL log_level, String str, String str2) {
        synchronized (HaoboLog.class) {
            notifyListener(log_level, str, str2, null);
        }
    }

    public static synchronized boolean registerListener(HaoboLogListener haoboLogListener) {
        boolean z;
        synchronized (HaoboLog.class) {
            if (haoboLogListener != null) {
                z = listeners.add(haoboLogListener);
            }
        }
        return z;
    }

    public static void setErrorContext(Context context) {
        sLogContext = new SoftReference<>(context);
    }

    public static synchronized void setLastLogRequest(String str) {
        synchronized (HaoboLog.class) {
            lastLog = str;
        }
    }

    public static synchronized void setLastRequest(String str) {
        synchronized (HaoboLog.class) {
            lastRequest = str;
        }
    }

    public static synchronized void setLastResponse(String str) {
        synchronized (HaoboLog.class) {
            lastResponse = str;
        }
    }

    public static synchronized void unregisterAllListeners() {
        synchronized (HaoboLog.class) {
            listeners.clear();
        }
    }

    public static synchronized boolean unregisterListener(HaoboLogListener haoboLogListener) {
        boolean z;
        synchronized (HaoboLog.class) {
            if (haoboLogListener != null) {
                z = listeners.remove(haoboLogListener);
            }
        }
        return z;
    }

    public static void v(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.V, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    public static void w(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.W, str, str2);
            logIfLoggable(str, str2, 5, null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.D, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.E, str, str2, th);
            logIfLoggable(str, str2, 6, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.I, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    private static synchronized void notifyListener(HaoboLogListener.LOG_LEVEL log_level, String str, String str2, Throwable th) {
        synchronized (HaoboLog.class) {
            try {
                Iterator<HaoboLogListener> it = listeners.iterator();
                while (it.hasNext()) {
                    HaoboLogListener next = it.next();
                    if (log_level.ordinal() >= next.getLogLevel().ordinal()) {
                        if (th != null) {
                            next.onReceiveMessage(log_level, str, str2, th);
                        } else {
                            next.onReceiveMessage(log_level, str, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.V, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.W, str, str2, th);
            logIfLoggable(str, str2, 5, th);
        }
    }

    public static String getString(int i, long j) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Long.valueOf(j));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, String str) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, String str, int i2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, Integer.valueOf(i2));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, int i2, int i3, int i4, int i5) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, boolean z) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Boolean.valueOf(z));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, String str, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, str2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, int i2, String str, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), str, str2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, String str, int i2, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, Integer.valueOf(i2), str2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, int i2, String str) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), str);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, int i2, int i3, int i4, int i5, String str, boolean z) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, boolean z, int i2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Boolean.valueOf(z), Integer.valueOf(i2));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String getString(int i, int i2, int i3) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }
}
