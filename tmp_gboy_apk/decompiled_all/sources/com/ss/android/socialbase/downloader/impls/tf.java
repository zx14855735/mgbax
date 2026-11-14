package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.v;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class tf implements v {
    @Override // com.ss.android.socialbase.downloader.downloader.v
    public long xj(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
