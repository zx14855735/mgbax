package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am implements c<ShakeAnimationView>, qt {
    private com.bytedance.sdk.component.adexpress.dynamic.w.tf c;
    private boolean f;
    private ShakeAnimationView hf;
    private com.bytedance.sdk.component.adexpress.dynamic.w.c kd;
    private DynamicBaseWidget u;
    private Context w;
    public int xj;
    private String y;

    public am(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, String str, com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, boolean z, int i) {
        this.w = context;
        this.u = dynamicBaseWidget;
        this.kd = cVar;
        this.y = str;
        this.c = tfVar;
        this.f = z;
        this.xj = i;
        y();
    }

    private void y() {
        final com.bytedance.sdk.component.adexpress.dynamic.kd.xj dynamicClickListener = this.u.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.xj(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.y)) {
            Context context = this.w;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.w.xj.f(context), this.c, this.f, this.xj);
            this.hf = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.hf.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.w;
            this.hf = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.w.xj.c(context2), this.c, this.f, this.xj);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hf.setGravity(17);
        layoutParams.gravity = 17;
        this.hf.setLayoutParams(layoutParams);
        this.hf.setTranslationY(com.bytedance.sdk.component.adexpress.u.f.xj(this.w, this.kd.gy()));
        this.hf.setShakeText(this.kd.aq());
        this.hf.setClipChildren(false);
        this.hf.setOnShakeViewListener(new ShakeAnimationView.xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.am.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.xj
            public void xj(boolean z) {
                com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = dynamicClickListener;
                if (xjVar != null) {
                    xjVar.xj(z, am.this);
                }
                am.this.hf.setOnClickListener((View.OnClickListener) dynamicClickListener);
                am.this.hf.performClick();
                if (am.this.kd == null || !am.this.kd.dq()) {
                    return;
                }
                am.this.hf.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.qt
    public void kd() {
        if (this.hf.getParent() != null) {
            ((ViewGroup) this.hf.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView w() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        this.hf.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        this.hf.xj();
    }
}
