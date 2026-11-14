package com.bytedance.sdk.openadsdk.api.plugin;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class hf {
    public static File hf(Context context) {
        return xj(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static boolean u(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.hf.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String group = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(group) ? 0 : Integer.parseInt(group.substring(8))) > 7132;
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.y.xj(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (listFiles == null || listFiles.length == 0) ? false : true;
    }

    public static File w(Context context) {
        return xj(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    private static File xj(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static SharedPreferences hf(Context context, String str, int i) {
        return i == 0 ? com.bytedance.sdk.openadsdk.ats.u.xj(context, xj(str), i) : com.bytedance.sdk.openadsdk.ats.u.xj(context, str, i);
    }

    public static File xj(Context context) {
        return xj(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File xj(Context context, String str) {
        return xj(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File xj(Context context, String str, int i) {
        return i == 0 ? xj(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    private static String xj(String str) {
        return CtFAbx.BChYOn("pangle_com.byted.pangle_", str);
    }
}
