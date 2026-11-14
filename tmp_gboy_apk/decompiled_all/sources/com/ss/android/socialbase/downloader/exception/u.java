package com.ss.android.socialbase.downloader.exception;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u extends BaseException {
    private final long hf;
    private final long xj;

    public u(long j, long j2) {
        super(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, CtFAbx.AmA8tU("space is not enough required space is : ", String.valueOf(j2), " but available space is :", String.valueOf(j)));
        this.xj = j;
        this.hf = j2;
    }

    public long hf() {
        return this.hf;
    }

    public long xj() {
        return this.xj;
    }
}
