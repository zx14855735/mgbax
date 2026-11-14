package com.czhj.sdk.common.utils;

import android.content.Context;
import com.sigmob.sdk.downloader.core.breakpoint.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ResourceUtil {
    private static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getAnimId(Context context, String str) {
        return a(context, str, "anim");
    }

    public static int getArrayId(Context context, String str) {
        return a(context, str, "array");
    }

    public static int getAttrId(Context context, String str) {
        return a(context, str, "attr");
    }

    public static int getBoolId(Context context, String str) {
        return a(context, str, "bool");
    }

    public static int getColorId(Context context, String str) {
        return a(context, str, "color");
    }

    public static int getDimenId(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int getDrawableId(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int getId(Context context, String str) {
        return a(context, str, f.f13353a);
    }

    public static int getIntegerId(Context context, String str) {
        return a(context, str, "integer");
    }

    public static int getLayoutId(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int getMipmapId(Context context, String str) {
        return a(context, str, "mipmap");
    }

    public static int getStringId(Context context, String str) {
        return a(context, str, "string");
    }

    public static int getStyleId(Context context, String str) {
        return a(context, str, "style");
    }
}
