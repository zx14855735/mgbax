package com.ss.android.downloadlib.hf;

import android.os.Build;
import com.ss.android.downloadlib.addownload.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    public static boolean xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        return com.ss.android.socialbase.appdownloader.y.kd.kd() && Build.VERSION.SDK_INT < 29 && pl.pl() != null && pl.pl().xj() && com.ss.android.downloadlib.c.kd.xj(xjVar).hf("invoke_app_form_background_switch") == 1 && xjVar.e();
    }
}
