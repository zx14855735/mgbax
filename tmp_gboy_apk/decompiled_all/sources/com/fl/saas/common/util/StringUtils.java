package com.fl.saas.common.util;

import android.text.TextUtils;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class StringUtils {
    public static String checkEmpty(String str, Supplier<String> supplier) {
        return TextUtils.isEmpty(str) ? supplier.get() : str;
    }

    public static boolean containsField(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int strToInt(String str) {
        return strToInt(str, 0);
    }

    public static int strToInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }
}
