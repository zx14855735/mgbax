package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.y.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<DislikeView> {
    private int lm;
    private int my;
    private int xj;

    public xj(Context context) {
        super(context);
        this.xj = 0;
        this.lm = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DislikeView xj() {
        DislikeView dislikeView = new DislikeView(this.hf);
        dislikeView.xj(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((DislikeView) this.kd).setRadius(this.n);
        ((DislikeView) this.kd).setStrokeWidth((int) this.dq);
        ((DislikeView) this.kd).setDislikeColor(this.xj);
        ((DislikeView) this.kd).setStrokeColor(this.qd);
        ((DislikeView) this.kd).setDislikeWidth(this.my);
        ((DislikeView) this.kd).setBgColor(this.lm);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "dislikeColor":
                this.xj = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "dislikeWidth":
                this.my = (int) f.xj(this.hf, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.lm = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
        }
    }
}
