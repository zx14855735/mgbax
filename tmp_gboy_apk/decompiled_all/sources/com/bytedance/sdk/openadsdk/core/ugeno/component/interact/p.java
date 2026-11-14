package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p extends com.bytedance.adsdk.ugeno.widget.frame.xj {
    private final float[] lm;
    private String my;

    public p(Context context) {
        super(context);
        this.lm = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    private void p(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String trim = str.trim();
        if (trim.length() <= 2 || (split = trim.substring(1, trim.length() - 1).split(",")) == null || split.length != 4) {
            return;
        }
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.lm[i] = Float.parseFloat(com.bytedance.sdk.openadsdk.upie.xj.xj.xj(str2.trim(), this.u));
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.frame.xj, com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        p(this.my);
        super.hf();
    }

    public float[] s() {
        return this.lm;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.my = str2;
        } else {
            super.xj(str, str2);
        }
    }
}
