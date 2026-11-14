package com.kwad.components.core.s;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e {
    public static String a(long j, boolean z) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j > 1) {
            double d = j;
            int log = (int) (Math.log(d) / Math.log(1024.0d));
            return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS ? d / Math.pow(1024.0d, log) : d / 1024.0d), strArr[log]);
        }
        return j + "B";
    }
}
