package com.bytedance.adsdk.ugeno.widget.hf;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.hf;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj extends hf {
    private int cu;

    public xj(Context context) {
        super(context);
        this.cu = d.f13043a;
    }

    private String g(String str) {
        String p = p(str);
        return TextUtils.isEmpty(p) ? "" : "local://".concat(String.valueOf(p));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.hf
    public String c() {
        return "drawable";
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.hf, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        ((hf) this).xj = g(((hf) this).xj);
        super.hf();
        ((RoundImageView) this.kd).setColorFilter(this.cu);
        ((RoundImageView) this.kd).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public abstract String p(String str);

    @Override // com.bytedance.adsdk.ugeno.widget.image.hf, com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        if (str.equals("textColor")) {
            this.cu = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
        }
    }
}
