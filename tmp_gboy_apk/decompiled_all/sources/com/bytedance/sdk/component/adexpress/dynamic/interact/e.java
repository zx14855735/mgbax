package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e<E extends SlideUpView> implements c<E> {
    protected Context hf;
    protected int kd;
    protected com.bytedance.sdk.component.adexpress.dynamic.w.c u;
    protected DynamicBaseWidget w;
    protected SlideUpView xj;

    public e(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, int i) {
        this.kd = i;
        this.hf = context;
        this.w = dynamicBaseWidget;
        this.u = cVar;
        u();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        this.xj.hf();
    }

    public void u() {
        this.xj = new SlideUpView(this.hf, this.u.eu());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, 100 - this.kd);
        this.xj.setLayoutParams(layoutParams);
        try {
            this.xj.setGuideText(this.u.aq());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        this.xj.xj();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public E w() {
        return (E) this.xj;
    }

    public e(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        this(context, dynamicBaseWidget, cVar, 0);
    }
}
