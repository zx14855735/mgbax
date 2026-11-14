package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.p {
    @Override // com.ss.android.socialbase.downloader.downloader.p
    public int xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String kd = com.ss.android.socialbase.downloader.tf.y.kd(str + "_" + str2);
        if (TextUtils.isEmpty(kd)) {
            return 0;
        }
        return kd.hashCode();
    }
}
