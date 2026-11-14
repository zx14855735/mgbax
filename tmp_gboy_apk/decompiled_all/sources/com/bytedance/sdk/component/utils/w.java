package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static HashMap<String, ArrayList<String>> xj = new HashMap<>();

    static {
        kMcOoO();
    }

    private static Signature[] hf(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            pl.w(e.toString());
            return null;
        }
    }

    private static /* synthetic */ void kMcOoO() {
        char[] charArray = "+'%f/)%-f*'1f; -$$f\u0002&!\n:!,/-".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'H');
        }
        String str = new String(charArray);
        char[] charArray2 = "+$!&!<".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'H');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ArrayList<String> xj(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (xj.get(str) != null) {
                return xj.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : hf(context, packageName)) {
                    String str2 = "error!";
                    if ("MD5".equals(str)) {
                        str2 = xj(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        str2 = xj(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = xj(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e) {
                pl.w(e.toString());
            }
            xj.put(str, arrayList);
        }
        return arrayList;
    }

    public static String xj(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> xj2 = xj(context, "SHA1");
        if (xj2 != null && xj2.size() != 0) {
            for (int i = 0; i < xj2.size(); i++) {
                sb.append(xj2.get(i));
                if (i < xj2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String xj(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception e) {
            pl.w(e.toString());
            return "error!";
        }
    }
}
