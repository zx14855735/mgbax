package com.czhj.sdk.common.utils;

import android.os.Looper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.IllegalFormatException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Preconditions {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10607a = "";

    public static final class NoThrow {

        /* renamed from: a, reason: collision with root package name */
        private static volatile boolean f10608a = true;

        public static boolean checkArgument(boolean z) {
            return Preconditions.b(z, f10608a, "Illegal argument", "");
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.b(obj, f10608a, (String) null, "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.b(f10608a, str, "");
        }

        public static String getLineInfo() {
            try {
                StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
                return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getMethodName();
            } catch (Throwable unused) {
                return "";
            }
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.b(z, f10608a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.b(obj, f10608a, str, "");
        }
    }

    private Preconditions() {
    }

    private static String a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e) {
            SigmobLog.e("Sigmob preconditions had a format exception: " + e.getMessage());
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String a2 = a(str, objArr);
        if (z) {
            throw new NullPointerException(a2);
        }
        SigmobLog.e(a2);
        return false;
    }

    private static boolean c(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String a2 = a(str, objArr);
        if (z2) {
            throw new IllegalStateException(a2);
        }
        SigmobLog.e(a2);
        return false;
    }

    public static void checkNotNull(Object obj) {
        b(obj, true, "Object can not be null.", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String a2 = a(str, objArr);
        if (z) {
            throw new IllegalStateException(a2);
        }
        SigmobLog.e(a2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String a2 = a(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(a2);
        }
        SigmobLog.e(a2);
        return false;
    }
}
