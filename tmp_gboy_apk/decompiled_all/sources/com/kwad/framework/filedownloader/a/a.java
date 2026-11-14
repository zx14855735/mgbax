package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int V(long j) {
        if (j < BaseConstants.MB_VALUE) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
