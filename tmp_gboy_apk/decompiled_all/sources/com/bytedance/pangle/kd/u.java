package com.bytedance.pangle.kd;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.y;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static List<String> hf = new CopyOnWriteArrayList();
    private static String xj;

    static {
        DTjECM();
    }

    private static /* synthetic */ void DTjECM() {
        char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 27);
        }
        String str = new String(charArray);
        char[] charArray2 = "xwruro".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 27);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf(Context context) {
        String xj2 = xj(context);
        return (xj2 == null || !xj2.contains(":")) && xj2 != null && xj2.equals(context.getPackageName());
    }

    private static String xj() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (ZeusLogger.isDebug()) {
                ZeusLogger.d("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }

    public static String xj(Context context) {
        String processName;
        if (!TextUtils.isEmpty(xj)) {
            return xj;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    xj = processName;
                }
                return xj;
            }
        } catch (Throwable unused) {
        }
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                xj = (String) invokeStaticMethod;
            }
            return xj;
        } catch (Exception e) {
            y.xj(e);
            String xj2 = xj();
            xj = xj2;
            return xj2;
        }
    }

    public static String xj(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            return str.split(":")[1];
        }
        return "main";
    }
}
