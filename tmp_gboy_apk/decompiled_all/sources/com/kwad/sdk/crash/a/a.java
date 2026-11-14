package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static Context aMG;
    private static String aTS;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File Ns() {
        File file;
        if (TextUtils.isEmpty(aTS)) {
            Context context = aMG;
            if (context == null) {
                context = ServiceProvider.Re();
            }
            if (context == null) {
                try {
                    context = z.EX();
                } catch (Throwable unused) {
                }
            }
            file = context != null ? new File(getDataDir(context), "kwad_ex") : null;
        } else {
            file = new File(aTS);
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Nt() {
        return new File(Ns(), "java_crash/dump");
    }

    public static File Nu() {
        return new File(Ns(), "anr_log/dump");
    }

    public static File Nv() {
        return new File(Ns(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i >= 24 ? context.getDataDir() : null;
        if (dataDir != null) {
            return dataDir;
        }
        File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
        if (file.exists()) {
            return file;
        }
        return new File("/data/data/" + context.getPackageName());
    }

    public static void init(Context context, String str) {
        aMG = context;
        aTS = str;
        aTS = w.R(context, "kwad_ex");
    }
}
