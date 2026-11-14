package com.bytedance.sdk.component.p.f;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt >= 'A' && charAt <= 'Z') {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (charAt + ' '));
                }
                sb.append(charAt);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String xj(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z) {
            str = str.substring(1);
        }
        return xj(str);
    }
}
