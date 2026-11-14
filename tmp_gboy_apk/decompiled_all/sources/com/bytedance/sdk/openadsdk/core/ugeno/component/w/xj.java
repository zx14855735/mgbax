package com.bytedance.sdk.openadsdk.core.ugeno.component.w;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w<UpieImageView> {
    protected boolean my;
    protected ImageView.ScaleType xj;

    public xj(Context context) {
        super(context);
        this.xj = ImageView.ScaleType.FIT_XY;
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UpieImageView xj() {
        return new UpieImageView(this.hf, null, null);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ws xj = com.bytedance.sdk.openadsdk.core.xj.xj(this.u);
        if (xj != null) {
            ((UpieImageView) this.kd).xj(com.bytedance.sdk.openadsdk.kd.xj.xj(xj, this.u), com.bytedance.sdk.openadsdk.kd.xj.tf(xj));
            ((UpieImageView) this.kd).setScaleType(this.xj);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.xj = p(str2);
                break;
            case "isBgGaussianBlur":
                this.my = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                break;
        }
    }
}
