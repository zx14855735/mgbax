package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements c<ViewGroup> {
    private final FrameLayout hf;
    private final DynamicLottieView xj;

    public tf(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, String str, String str2) {
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.xj = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.hf = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double gh = cVar.gh();
        gh = gh == 0.0d ? 1.0d : gh;
        double op = cVar.op();
        double d = op != 0.0d ? op : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if (!"20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(str);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * gh), (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * d));
            layoutParams2.gravity = 17;
            frameLayout.setLayoutParams(layoutParams2);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
        xj(context, frameLayout, cVar);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, cVar.hl() > 0 ? cVar.hl() : com.bytedance.sdk.component.adexpress.u.xj() ? 0 : AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT);
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setClipChildren(false);
    }

    private void xj(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -q.xj(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(jk.hf(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(textView2, 2097610738, -2, -2);
        ASJ6gh2.setMargins(0, q.xj(context, 5.0f), 0, 0);
        textView2.setLayoutParams(ASJ6gh2);
        textView2.setText(context.getString(jk.hf(context, "tt_splash_brush_mask_hint")));
        if (cVar != null && !TextUtils.isEmpty(cVar.aq())) {
            textView2.setText(cVar.aq());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        try {
            this.xj.c();
            ViewParent parent = this.hf.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.hf);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public ViewGroup w() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        DynamicLottieView dynamicLottieView = this.xj;
        if (dynamicLottieView != null) {
            dynamicLottieView.d();
        }
    }
}
