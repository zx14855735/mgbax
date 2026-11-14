package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w<UgenGif> {
    protected ImageView.ScaleType my;
    protected String xj;

    public xj(Context context) {
        super(context);
        this.my = ImageView.ScaleType.FIT_CENTER;
    }

    private void f() {
        if (TextUtils.isEmpty(this.xj)) {
            return;
        }
        if (!this.xj.startsWith("local://")) {
            u.xj().hf().xj(this.d, this.xj, (ImageView) this.kd, null);
        } else {
            ((UgenGif) this.kd).xj(com.bytedance.adsdk.ugeno.y.u.hf(this.hf, this.xj.replace("local://", "")), false);
        }
    }

    private ImageView.ScaleType p(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UgenGif xj() {
        UgenGif ugenGif = new UgenGif(this.hf);
        this.kd = ugenGif;
        ugenGif.xj(this);
        return (UgenGif) this.kd;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        f();
        ((UgenGif) this.kd).setScaleType(this.my);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w, com.bytedance.adsdk.ugeno.w
    public void kd() {
        super.kd();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        if (str.equals("scaleType")) {
            this.my = p(str2);
        } else if (str.equals("src")) {
            this.xj = str2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w, com.bytedance.adsdk.ugeno.w
    public void xj(boolean z) {
        super.xj(z);
        if (z) {
            hf();
        }
    }
}
