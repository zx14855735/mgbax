package com.czhj.sdk.logger;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SigmobLog {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10614a = "com.sigmob";
    private static final String b = "sigmob";
    private static final Logger c;
    private static final SigmobLogHandler d;
    private static final boolean e = false;

    public static final class SigmobLogHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<Level, Integer> f10615a;

        static {
            HashMap hashMap = new HashMap(7);
            f10615a = hashMap;
            hashMap.put(Level.FINEST, 2);
            hashMap.put(Level.FINER, 2);
            hashMap.put(Level.FINE, 2);
            hashMap.put(Level.CONFIG, 3);
            hashMap.put(Level.INFO, 3);
            hashMap.put(Level.WARNING, 5);
            hashMap.put(Level.SEVERE, 6);
            sWum();
        }

        private SigmobLogHandler() {
        }

        private static /* synthetic */ void sWum() {
            char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'k');
            }
            String str = new String(charArray);
            char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'k');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // java.util.logging.Handler
        public void close() {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord logRecord) {
            if (isLoggable(logRecord)) {
                Map<Level, Integer> map = f10615a;
                if (map.containsKey(logRecord.getLevel())) {
                    map.get(logRecord.getLevel()).intValue();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(logRecord.getMessage());
                sb.append("\n");
                logRecord.getThrown();
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(f10614a);
        c = logger;
        SigmobLogHandler sigmobLogHandler = new SigmobLogHandler();
        d = sigmobLogHandler;
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        sigmobLogHandler.setLevel(Level.INFO);
        LogManager.getLogManager().addLogger(logger);
        a(logger, sigmobLogHandler);
        rjeH();
    }

    private SigmobLog() {
    }

    private static void a(String str, Throwable th) {
        c.log(Level.FINEST, str, th);
    }

    public static void addHandler(Handler handler) {
        a(c, handler);
    }

    private static void b(String str, Throwable th) {
        c.log(Level.INFO, str, th);
    }

    public static void c(String str) {
        a(str, (Throwable) null);
    }

    public static void d(String str) {
    }

    public static void dd(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str2.length() <= 3072) {
            return;
        }
        while (str2.length() > 3072) {
            str2 = str2.replace(str2.substring(0, 3072), "");
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(str, null);
    }

    public static void i(String str) {
        b(str, null);
    }

    private static /* synthetic */ void rjeH() {
        char[] charArray = "48:y06:2y58.y$?2;;y\u001d9>\u0015%>302".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'W');
        }
        String str = new String(charArray);
        char[] charArray2 = "4;>9>#".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'W');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void setSdkHandlerLevel(Level level) {
        d.setLevel(level);
    }

    public static void v(String str) {
        v(str, null);
    }

    public static void w(String str) {
        w(str, null);
    }

    private static void a(Logger logger, Handler handler) {
        for (Handler handler2 : logger.getHandlers()) {
            if (handler2.equals(handler)) {
                return;
            }
        }
        logger.addHandler(handler);
    }

    public static void d(String str, Throwable th) {
    }

    public static void e(String str, Throwable th) {
        c.log(Level.SEVERE, str, th);
    }

    public static void v(String str, Throwable th) {
        c.log(Level.FINE, str, th);
    }

    public static void w(String str, Throwable th) {
        c.log(Level.WARNING, str, th);
    }
}
