package com.sigmob.sdk.base.device.compat;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private c() {
    }

    public static String a(String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            try {
                str2 = c(str);
            } catch (Exception unused) {
                str2 = null;
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
            try {
                str2 = d(str);
            } catch (IOException unused2) {
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
            try {
                str2 = e(str);
            } catch (IOException unused3) {
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
        }
        return "";
    }

    public static String b(String[] strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            String a2 = a(str);
            if (!a2.isEmpty()) {
                return a2;
            }
        }
        return "";
    }

    @SuppressLint({"PrivateApi"})
    private static String c(String str) {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
    }

    private static String d(String str) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    return readLine;
                }
                try {
                    bufferedReader2.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String e(String str) {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty(str, "");
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return property;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String[] a(String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = a(strArr[i]);
        }
        return strArr2;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(a(str));
    }

    public static boolean c(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (b(str)) {
                return true;
            }
        }
        return false;
    }
}
