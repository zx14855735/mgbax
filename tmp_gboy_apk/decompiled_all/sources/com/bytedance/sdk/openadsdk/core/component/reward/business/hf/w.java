package com.bytedance.sdk.openadsdk.core.component.reward.business.hf;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private int hf;
    private String xj;

    public int hf() {
        return this.hf;
    }

    public boolean w() {
        return !TextUtils.isEmpty(this.xj);
    }

    public String xj() {
        return this.xj;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void xj(int i) {
        this.hf = i;
    }
}
