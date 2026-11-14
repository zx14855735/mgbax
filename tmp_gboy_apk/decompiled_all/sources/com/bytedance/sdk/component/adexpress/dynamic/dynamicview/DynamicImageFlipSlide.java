package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.qt;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.hf.p;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicImageFlipSlide extends DynamicImageView {
    private final hf hf;
    private final ImageFlipSlideGroup xj;

    public interface hf {
        void xj(xj xjVar);
    }

    public interface xj {
        void xj();
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.hf = new hf() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.hf
            public void xj(xj xjVar) {
                if (DynamicImageFlipSlide.this.xj != null) {
                    DynamicImageFlipSlide.this.xj.xj(xjVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().m(), "slide"));
        this.xj = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        this.xj.xj(this.f10177pl.p(), hf(this.f10177pl.p()));
        this.xj.hf(this.f10177pl.se(), hf(this.f10177pl.se()));
        this.xj.setFilterColors(this.f10177pl.ft());
        this.xj.w();
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.kd.xj getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.kd.xj dynamicClickListener = this.am.getDynamicClickListener();
        return this.f10177pl.rg() ? new w(dynamicClickListener, this.hf) : dynamicClickListener;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.xj.xj();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.xj.hf();
    }

    public static class w implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.kd.xj {
        hf hf;
        com.bytedance.sdk.component.adexpress.dynamic.kd.xj xj;

        public w(com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar, hf hfVar) {
            this.xj = xjVar;
            this.hf = hfVar;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
        public void hf(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.hf(view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            hf hfVar = this.hf;
            if (hfVar != null) {
                hfVar.xj(new xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.w.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.xj
                    public void xj() {
                        com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = w.this.xj;
                        if (xjVar instanceof View.OnClickListener) {
                            ((View.OnClickListener) xjVar).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar instanceof View.OnClickListener) {
                ((View.OnClickListener) xjVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) xjVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
        public void xj(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
        public void xj(p pVar) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(pVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
        public void xj(boolean z, qt qtVar) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(z, qtVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
        public void xj(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(jSONObject);
            }
        }
    }
}
