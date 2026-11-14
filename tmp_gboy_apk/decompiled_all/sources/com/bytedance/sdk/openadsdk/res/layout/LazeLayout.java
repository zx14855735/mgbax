package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.x.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LazeLayout<T extends View> extends View {
    private View.OnTouchListener c;
    private T f;
    private volatile Context hf;
    private AtomicBoolean kd;
    private AtomicBoolean u;
    private xj w;
    private volatile com.bytedance.sdk.openadsdk.res.layout.xj<T> xj;
    private View.OnClickListener y;

    public interface xj<T extends View> {
        void xj(T t);
    }

    public LazeLayout(Context context, com.bytedance.sdk.openadsdk.res.layout.xj xjVar, xj xjVar2) {
        super(context);
        this.u = new AtomicBoolean(false);
        this.kd = new AtomicBoolean(false);
        this.xj = xjVar;
        this.hf = context;
        this.w = xjVar2;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.kd.set(true);
        if (this.u.get()) {
            return;
        }
        this.u.set(true);
        T t = this.f;
        if (t != null) {
            xj((LazeLayout<T>) t, getParent());
        } else {
            f.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.f = lazeLayout.xj.hf(LazeLayout.this.hf);
                        if (LazeLayout.this.f == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.xj((LazeLayout) lazeLayout2.f, LazeLayout.this.getParent());
                    } catch (Exception e) {
                        pl.hf("LazeLayout", "inflate error", e);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.kd.set(false);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.c = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.kd.get()) {
                f.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.xj((LazeLayout) t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.u.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.kd.get()) {
                        LazeLayout.this.xj((LazeLayout) t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.u.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(T t, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.hf = null;
        this.xj = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.y;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.c;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, indexOfChild);
        }
        xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(t);
        }
        this.f = null;
    }

    public void xj() {
        this.f = null;
        this.xj = null;
        this.hf = null;
        this.w = null;
    }
}
