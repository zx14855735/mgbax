package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.adsdk.ugeno.widget.text.hf {
    public hf(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        if (TextUtils.isEmpty(((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj)) {
            ((UGTextView) this.kd).setText("跳过");
        }
    }

    public void u(boolean z) {
        if (z) {
            hf(0);
            xj(true, true);
        } else {
            u(0);
            kd(0);
        }
    }
}
