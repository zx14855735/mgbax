package com.ss.android.socialbase.appdownloader.hf;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    public static final String xj;

    static {
        StringBuilder sb = new StringBuilder("AppDownloader");
        String str = Build.VERSION.RELEASE;
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = Build.ID;
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        boolean z = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        if (!isEmpty) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (!isEmpty) {
            sb.append(" ");
            sb.append(str);
        }
        if (z || !isEmpty2) {
            sb.append(";");
            if (z) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (!isEmpty2) {
                sb.append(" Build/");
                sb.append(str2);
            }
        }
        sb.append(")");
        xj = sb.toString();
        UVljjca();
    }

    private static /* synthetic */ void UVljjca() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
