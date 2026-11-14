package com.ss.android.downloadlib.c;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class pl {

    public static class xj {
        private static pl xj = new pl();

        static {
            yDxLkM();
        }

        private static /* synthetic */ void yDxLkM() {
            char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\b');
            }
            String str = new String(charArray);
            char[] charArray2 = "kdafa|".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\b');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static pl xj() {
        return xj.xj;
    }

    public void hf(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "";
        } else {
            str4 = "sdk:" + str + "." + str2 + ":";
        }
        com.bytedance.sdk.component.utils.pl.u("[TTDownloaderLogger]", str4 + str3);
    }

    private pl() {
    }

    public void xj(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextUtils.isEmpty(str2);
    }
}
