package com.sigmob.sdk.videocache;

import android.content.Context;
import android.os.Environment;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class w {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13746a = "video-cache";

    public static File a(Context context) {
        return new File(a(context, true), f13746a);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "SigmobAndroid"), PointParamKey.DATA), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        SigmobLog.w("Unable to create external cache directory");
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
        SigmobLog.w("Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }
}
