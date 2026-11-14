package com.octopus.ad.internal.a;

import android.content.Context;
import android.os.Environment;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class t {
    public static File a(Context context) {
        return new File(a(context, true), "video-cache");
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), PointParamKey.DATA), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        HaoboLog.w(HaoboLog.storageUtilsLogTag, "Unable to create external cache directory");
        return null;
    }

    private static File a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b = (z && "mounted".equals(str)) ? b(context) : null;
        if (b == null) {
            b = context.getCacheDir();
        }
        if (b != null) {
            return b;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        HaoboLog.w(HaoboLog.storageUtilsLogTag, "Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }
}
