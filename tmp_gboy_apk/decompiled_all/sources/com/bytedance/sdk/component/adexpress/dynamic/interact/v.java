package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.jk;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v implements c<WriggleGuideAnimationView> {
    private com.bytedance.sdk.component.adexpress.dynamic.w.tf c;
    private boolean f;
    private WriggleGuideAnimationView hf;
    private com.bytedance.sdk.component.adexpress.dynamic.w.c kd;
    private DynamicBaseWidget u;
    private Context w;
    public int xj;
    private String y;

    public v(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, String str, com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, boolean z, int i) {
        this.w = context;
        this.u = dynamicBaseWidget;
        this.kd = cVar;
        this.y = str;
        this.c = tfVar;
        this.f = z;
        this.xj = i;
        kd();
    }

    private void kd() {
        int hl = this.kd.hl();
        final com.bytedance.sdk.component.adexpress.dynamic.kd.xj dynamicClickListener = this.u.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.xj(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.y)) {
            Context context = this.w;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.w.xj.d(context), this.c, this.f, this.xj);
            this.hf = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.hf.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.hf.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.kd.nb())) {
                    this.hf.getTopTextView().setText(jk.hf(this.w, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.hf.getTopTextView().setText(this.kd.nb());
                }
            }
        } else {
            Context context2 = this.w;
            this.hf = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.w.xj.d(context2), this.c, this.f, this.xj);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.hf.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.w, hl)));
        this.hf.setLayoutParams(layoutParams);
        this.hf.setShakeText(this.kd.aq());
        this.hf.setClipChildren(false);
        final View wriggleProgressIv = this.hf.getWriggleProgressIv();
        this.hf.setOnShakeViewListener(new WriggleGuideAnimationView.xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.v.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.xj
            public void xj() {
                if (wriggleProgressIv != null) {
                    if (v.this.hf != null) {
                        v.this.hf.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        v.this.hf.performClick();
                    }
                    if (v.this.kd == null || !v.this.kd.dq()) {
                        return;
                    }
                    v.this.hf.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView w() {
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
