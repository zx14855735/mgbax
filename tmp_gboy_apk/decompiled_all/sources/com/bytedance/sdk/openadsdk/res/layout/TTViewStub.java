package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class TTViewStub extends View {
    private com.bytedance.sdk.openadsdk.res.layout.xj hf;
    private xj u;
    private Context w;
    private WeakReference<View> xj;

    public interface xj {
    }

    public TTViewStub(Context context, com.bytedance.sdk.openadsdk.res.layout.xj xjVar) {
        super(context);
        this.w = context;
        this.hf = xjVar;
        setVisibility(8);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setOnInflateListener(xj xjVar) {
        this.u = xjVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.xj;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            xj();
        }
    }

    public View xj() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        com.bytedance.sdk.openadsdk.res.layout.xj xjVar = this.hf;
        if (xjVar == null) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        View hf = xjVar.hf(this.w);
        xj(hf, (ViewGroup) parent);
        this.xj = new WeakReference<>(hf);
        return hf;
    }

    private void xj(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }
}
