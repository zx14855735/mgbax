package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.ugeno.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UgenLottieView extends LottieAnimationView {
    private w xj;

    public UgenLottieView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.y();
        }
    }

    public void xj(w wVar) {
        this.xj = wVar;
    }
}
