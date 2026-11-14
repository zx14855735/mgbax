package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.hf.hf;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.kd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UgenBanner extends FrameLayout {
    private View hf;
    private WeakReference<ObjectAnimator> kd;
    private final AtomicBoolean u;
    private boolean w;
    private qt xj;
    private int y;

    public UgenBanner(Context context) {
        super(context);
        this.u = new AtomicBoolean(false);
    }

    public void hf() {
        View view = this.hf;
        if (view == null || this.w) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        layoutParams.topMargin = this.y;
        addView(this.hf, layoutParams);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hf, "translationY", -400.0f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.start();
        this.kd = new WeakReference<>(ofFloat);
    }

    public void setTopMargin(int i) {
        this.y = i;
    }

    public void xj(ws wsVar, hf hfVar) {
        if (wsVar.vh() == null || TextUtils.isEmpty(wsVar.vh().w())) {
            return;
        }
        xj(v.pl(wsVar), wsVar, hfVar, wsVar.vh().w(), wsVar.kr(), TextUtils.isEmpty(wsVar.bh()) ? "立即下载" : wsVar.bh(), false);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar, final ws wsVar, final hf hfVar, final String str, final String str2, final String str3, final boolean z) {
        if (xjVar == null || this.u.getAndSet(true) || wsVar.uf() == null || TextUtils.isEmpty(wsVar.uf().xj())) {
            return;
        }
        kd.xj(xjVar, new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj
            public void xj(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", wsVar.uf().xj());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.hf = ugenBanner.xj(jSONObject, jSONObject2, new yo() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.w.yo
                    public void xj(w wVar, String str4, y.xj xjVar2) {
                    }

                    @Override // com.bytedance.adsdk.ugeno.w.yo
                    public void xj(zg zgVar, yo.hf hfVar2, yo.xj xjVar2) {
                        if (zgVar.w() != null && "banner_click".equals(zgVar.w().optString(PointParamKey.TYPE))) {
                            UgenBanner.this.hf.setTag(2114387594, Boolean.TRUE);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            hfVar.xj(UgenBanner.this.hf, null);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            if (z) {
                                UgenBanner.this.xj();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.hf();
            }
        }, 3000L);
    }

    public void xj() {
        ObjectAnimator objectAnimator;
        this.w = true;
        View view = this.hf;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.kd;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View xj(JSONObject jSONObject, JSONObject jSONObject2, yo yoVar) {
        qt qtVar = new qt(getContext());
        this.xj = qtVar;
        w<View> xj = qtVar.xj(jSONObject);
        this.xj.xj(yoVar);
        this.xj.hf(jSONObject2);
        if (xj == null) {
            return null;
        }
        View d = xj.d();
        if (d != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xj.l(), xj.ff());
            layoutParams.leftMargin = r.w(getContext(), 16.0f);
            layoutParams.rightMargin = r.w(getContext(), 16.0f);
            d.setLayoutParams(layoutParams);
        }
        return d;
    }
}
