package com.bytedance.sdk.component.w.hf.xj.kd;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class qt extends IOException {
    public final hf xj;

    public qt(hf hfVar) {
        super("stream was reset: ".concat(String.valueOf(hfVar)));
        this.xj = hfVar;
    }
}
