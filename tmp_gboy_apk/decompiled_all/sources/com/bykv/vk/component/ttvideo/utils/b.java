package com.bykv.vk.component.ttvideo.utils;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b {
    public static String a(String str) {
        String str2 = new String();
        if (str != null) {
            str2 = str2.concat(str);
        }
        Random random = new Random();
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str2);
        A4TApA2.append(random.nextInt());
        StringBuilder A4TApA3 = AYUAbz.A4TApA(A4TApA2.toString());
        A4TApA3.append(System.currentTimeMillis());
        return Base64.encodeToString(A4TApA3.toString().getBytes(), 2);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("T");
        }
        sb.append(Long.toString(System.currentTimeMillis()));
        sb.append("T");
        sb.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return sb.toString();
    }
}
