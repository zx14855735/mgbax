package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.dynamic.w.y;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {
    f hf;
    String xj;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, f fVar, String str) {
        super(context, dynamicRootView, fVar);
        this.xj = str;
        this.hf = fVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        f fVar = this.g;
        if (fVar == null || fVar.tf() == null || this.p == null || TextUtils.isEmpty(this.xj)) {
            return null;
        }
        y kd = this.g.tf().kd();
        String gy = kd != null ? kd.gy() : "";
        if (TextUtils.isEmpty(gy)) {
            return null;
        }
        String AzWtSf2 = A2egSU.AzWtSf(new StringBuilder(), this.xj, "static/lotties/", gy, ".json");
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.p);
        dynamicLottieView.setImageLottieTosPath(AzWtSf2);
        dynamicLottieView.d();
        return dynamicLottieView;
    }
}
