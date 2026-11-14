package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class xj implements kd {
    protected final com.ss.android.socialbase.downloader.f.xj hf;
    protected final String w;
    protected final Context xj;

    public xj(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str) {
        this.xj = context;
        this.hf = xjVar;
        this.w = str;
    }

    public boolean xj() {
        if (this.xj == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.bytedance.sdk.component.utils.pl.w("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return hf().resolveActivity(this.xj.getPackageManager()) != null;
    }
}
