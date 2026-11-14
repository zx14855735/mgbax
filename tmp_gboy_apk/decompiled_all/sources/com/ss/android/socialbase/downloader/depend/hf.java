package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class hf implements ht {
    private boolean xj = false;

    @Override // com.ss.android.socialbase.downloader.depend.ht
    public void xj(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.xj = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.ht
    public boolean xj() {
        return this.xj;
    }
}
