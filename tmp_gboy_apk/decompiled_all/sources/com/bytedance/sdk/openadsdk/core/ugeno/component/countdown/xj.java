package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.adsdk.ugeno.widget.text.hf {
    private String cu;
    protected String lm;
    private String vi;

    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        if (TextUtils.isEmpty(this.cu) || TextUtils.equals(this.cu, "null")) {
            this.cu = "";
        }
        if (TextUtils.isEmpty(this.vi) || TextUtils.equals(this.vi, "null")) {
            this.vi = "";
        }
        String str = this.vi + this.cu;
        ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = str;
        pl(str);
        ((UGTextView) this.kd).setGravity(17);
    }

    public void pl(String str) {
        ((UGTextView) this.kd).setText(str);
        try {
            float measureText = ((UGTextView) this.kd).getPaint().measureText(str);
            if (measureText >= 0.0f) {
                u((int) measureText);
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.lm)) {
            String str = this.lm;
            ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = str;
            pl(str);
            return;
        }
        if (TextUtils.isEmpty(this.cu) || TextUtils.equals(this.cu, "null")) {
            this.cu = "";
        }
        if (TextUtils.isEmpty(this.vi) || TextUtils.equals(this.vi, "null")) {
            this.vi = "";
        }
        String str2 = this.vi + i + this.cu;
        ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = str2;
        pl(str2);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "before":
                this.vi = str2;
                break;
            case "finish":
                this.lm = str2;
                break;
            case "after":
                this.cu = str2;
                break;
        }
    }
}
