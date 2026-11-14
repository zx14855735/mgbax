package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v {
    private static final HashSet xj = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    static {
        KbRuDU();
    }

    private static /* synthetic */ void KbRuDU() {
        char[] charArray = "ÆÊÈ\u008bÂÄÈÀ\u008bÇÊÜ\u008bÖÍÀÉÉ\u008bïËÌç×ÌÁÂÀ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 165);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÆÉÌËÌÑ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 165);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String hf() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<String>> l;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0 && (l = com.bytedance.msdk.core.hf.hf().l()) != null && !l.isEmpty()) {
            for (String str : l.keySet()) {
                if (xj(l.get(str), stackTraceElementArr)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static boolean u() {
        Map<String, List<String>> l = com.bytedance.msdk.core.hf.hf().l();
        if (l == null || l.size() == 0) {
            return false;
        }
        return xj(com.bytedance.msdk.core.hf.hf().ff());
    }

    public static double w() {
        return com.bytedance.msdk.core.hf.hf().ff();
    }

    public static String xj() {
        StackTraceElement[] stackTraceElementArr;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    if (!xj.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && className.startsWith("android.app")) {
                            break;
                        }
                        jSONArray.put(stackTraceElement.toString());
                    } else {
                        continue;
                    }
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return "";
        }
    }

    public static String xj(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (xj(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return "";
        }
    }

    private static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean xj(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i))) {
                                return true;
                            }
                        } catch (OutOfMemoryError e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean xj(com.bytedance.msdk.hf.w wVar) {
        if (wVar == null || !wVar.sv()) {
            return false;
        }
        return u();
    }

    public static boolean xj(com.bytedance.msdk.core.tf.tf tfVar) {
        if (tfVar == null || !tfVar.r()) {
            return false;
        }
        return u();
    }

    public static boolean xj(double d) {
        return d > 0.0d && Math.random() <= d;
    }
}
