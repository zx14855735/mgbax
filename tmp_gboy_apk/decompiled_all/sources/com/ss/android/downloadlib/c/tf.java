package com.ss.android.downloadlib.c;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class tf {
    private static Map<String, xj> xj = A2egSU.BIYEnU();

    public interface xj {
        void xj();

        void xj(String str);
    }

    static {
        yAAbce();
    }

    public static boolean hf(String str) {
        return com.ss.android.downloadlib.addownload.pl.kd().xj(com.ss.android.downloadlib.addownload.pl.getContext(), str);
    }

    private static xj w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.remove(str);
    }

    public static void xj(String[] strArr, xj xjVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        xj(valueOf, xjVar);
        TTDelegateActivity.xj(valueOf, strArr);
    }

    private static /* synthetic */ void yAAbce() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(String str) {
        xj w;
        if (TextUtils.isEmpty(str) || (w = w(str)) == null) {
            return;
        }
        w.xj();
    }

    public static void xj(String str, String str2) {
        xj w;
        if (TextUtils.isEmpty(str) || (w = w(str)) == null) {
            return;
        }
        w.xj(str2);
    }

    private static void xj(String str, xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj.put(str, xjVar);
    }
}
