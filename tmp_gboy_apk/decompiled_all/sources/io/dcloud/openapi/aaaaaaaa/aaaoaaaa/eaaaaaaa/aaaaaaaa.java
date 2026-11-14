package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {
    public static int aaaaaaa0(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int aaaaaaaa(Context context) {
        return (int) (context.getResources().getDisplayMetrics().heightPixels * 0.8f);
    }

    public static String aaaaaaaa(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            Matcher matcher = Pattern.compile("[\\w\\.]+[\\.](avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|pdf|rar|zip|docx|doc)").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            if (TextUtils.isEmpty(str3)) {
                return String.valueOf(System.currentTimeMillis()) + ".dat";
            }
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.contains(str2)) {
                return lastPathSegment;
            }
            if (TextUtils.isEmpty(str3)) {
                return String.valueOf(System.currentTimeMillis()) + str2;
            }
        }
        return str3;
    }
}
