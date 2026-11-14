package com.ss.android.socialbase.downloader.exception;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends BaseException {
    public c(int i, String str) {
        super(i, str);
    }

    public c xj(String str) {
        setExtraInfo(str);
        return this;
    }

    public String xj() {
        return getExtraInfo();
    }
}
