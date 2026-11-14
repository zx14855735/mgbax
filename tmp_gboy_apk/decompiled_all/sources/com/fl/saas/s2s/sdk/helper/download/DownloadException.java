package com.fl.saas.s2s.sdk.helper.download;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DownloadException extends IOException {
    private int code;

    public DownloadException(int i, String str) {
        super(str);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
