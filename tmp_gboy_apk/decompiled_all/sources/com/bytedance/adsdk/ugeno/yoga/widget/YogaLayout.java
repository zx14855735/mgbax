package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.w;
import com.bytedance.adsdk.ugeno.xj.c;
import com.bytedance.adsdk.ugeno.xj.f;
import com.bytedance.adsdk.ugeno.yoga.am;
import com.bytedance.adsdk.ugeno.yoga.d;
import com.bytedance.adsdk.ugeno.yoga.g;
import com.bytedance.adsdk.ugeno.yoga.kd;
import com.bytedance.adsdk.ugeno.yoga.p;
import com.bytedance.adsdk.ugeno.yoga.tf;
import com.bytedance.adsdk.ugeno.yoga.u;
import com.bytedance.adsdk.ugeno.yoga.y;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class YogaLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.hf.hf, c {
    private final tf hf;
    private f u;
    private w w;
    private final Map<View, tf> xj;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        tf xj2;
        this.hf.xj((com.bytedance.adsdk.ugeno.yoga.c) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.xj(this);
            tf yogaNode = virtualYogaLayout.getYogaNode();
            tf tfVar = this.hf;
            tfVar.xj(yogaNode, tfVar.xj());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.xj.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            xj2 = ((YogaLayout) view).getYogaNode();
        } else {
            xj2 = this.xj.containsKey(view) ? this.xj.get(view) : p.xj();
            xj2.xj(view);
            xj2.xj((com.bytedance.adsdk.ugeno.yoga.c) new hf());
        }
        xj((xj) view.getLayoutParams(), xj2, view);
        this.xj.put(view, xj2);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.hf.xj()));
        } else {
            tf tfVar2 = this.hf;
            tfVar2.xj(xj2, tfVar2.xj());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof xj;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new xj(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new xj(layoutParams);
    }

    public float getBorderRadius() {
        return this.u.xj();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRipple() {
        return this.u.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRubIn() {
        return this.u.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getShine() {
        return this.u.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getStretch() {
        return this.u.getStretch();
    }

    public tf getYogaNode() {
        return this.hf;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.hf
    public void hf(int i) {
        tf tfVar = this.hf;
        if (tfVar != null) {
            hf(tfVar, i);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.w;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.w;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w wVar = this.w;
        if (wVar != null) {
            wVar.xj(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.u();
        }
        if (!(getParent() instanceof YogaLayout)) {
            xj(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        xj(this.hf, 0.0f, 0.0f);
        w wVar2 = this.w;
        if (wVar2 != null) {
            wVar2.xj(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            xj(i, i2);
        }
        w wVar = this.w;
        if (wVar != null) {
            int[] xj2 = wVar.xj(i, i2);
            setMeasuredDimension(xj2[0], xj2[1]);
        } else {
            setMeasuredDimension(Math.round(this.hf.f()), Math.round(this.hf.d()));
        }
        w wVar2 = this.w;
        if (wVar2 != null) {
            wVar2.w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w wVar = this.w;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.w;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            xj(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            xj(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        xj(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        xj(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        xj(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            xj(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            xj(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.u.xj(i);
    }

    public void setBorderRadius(float f) {
        this.u.xj(f);
    }

    public void setRipple(float f) {
        f fVar = this.u;
        if (fVar != null) {
            fVar.hf(f);
        }
    }

    public void setRubIn(float f) {
        f fVar = this.u;
        if (fVar != null) {
            fVar.kd(f);
        }
    }

    public void setShine(float f) {
        f fVar = this.u;
        if (fVar != null) {
            fVar.w(f);
        }
    }

    public void setStretch(float f) {
        f fVar = this.u;
        if (fVar != null) {
            fVar.u(f);
        }
    }

    public void u(View view, int i) {
        int xj2;
        view.setVisibility(i);
        try {
            tf tfVar = this.xj.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (xj2 = this.hf.xj(tfVar)) == -1) {
                    return;
                }
                this.hf.hf(xj2);
                view.setTag(151060224, Integer.valueOf(xj2));
                xj(this.hf);
                return;
            }
            if (tag == null || this.hf.xj(tfVar) != -1) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            if (intValue < this.hf.xj()) {
                this.hf.xj(this.xj.get(view), intValue);
            } else {
                this.hf.xj(this.xj.get(view), this.hf.xj());
            }
            xj(this.hf);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.hf
    public void w(View view, int i) {
        u(view, i);
    }

    public tf xj(View view) {
        return this.xj.get(view);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = new f(this);
        tf xj2 = p.xj();
        this.hf = xj2;
        this.xj = new HashMap();
        xj2.xj(this);
        xj2.xj((com.bytedance.adsdk.ugeno.yoga.c) new hf());
        xj((xj) generateDefaultLayoutParams(), xj2, this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.hf
    public void xj(int i) {
        tf tfVar = this.hf;
        if (tfVar != null) {
            xj(tfVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.hf
    public void hf(View view, int i) {
        tf xj2;
        if (view == null || (xj2 = xj(view)) == null) {
            return;
        }
        hf(xj2, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.hf
    public void xj(View view, int i) {
        tf xj2;
        if (view == null || (xj2 = xj(view)) == null) {
            return;
        }
        xj(xj2, i);
        view.requestLayout();
    }

    private void hf(tf tfVar, int i) {
        if (i == -1) {
            tfVar.c(100.0f);
        } else if (i == -2) {
            tfVar.kd();
        } else {
            tfVar.y(i);
        }
    }

    private void xj(tf tfVar, int i) {
        if (i == -1) {
            tfVar.kd(100.0f);
        } else if (i == -2) {
            tfVar.u();
        } else {
            tfVar.u(i);
        }
    }

    public static class hf implements com.bytedance.adsdk.ugeno.yoga.c {
        @Override // com.bytedance.adsdk.ugeno.yoga.c
        public long xj(tf tfVar, float f, com.bytedance.adsdk.ugeno.yoga.f fVar, float f2, com.bytedance.adsdk.ugeno.yoga.f fVar2) {
            View view = (View) tfVar.tf();
            if (view == null || (view instanceof YogaLayout)) {
                return d.xj(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, xj(fVar)), View.MeasureSpec.makeMeasureSpec((int) f2, xj(fVar2)));
            return d.xj(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int xj(com.bytedance.adsdk.ugeno.yoga.f fVar) {
            if (fVar == com.bytedance.adsdk.ugeno.yoga.f.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return fVar == com.bytedance.adsdk.ugeno.yoga.f.EXACTLY ? 1073741824 : 0;
        }
    }

    public static class xj extends ViewGroup.LayoutParams {
        private float am;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        SparseArray<String> hf;
        private float kd;
        private float p;

        /* renamed from: pl, reason: collision with root package name */
        private float f10092pl;
        private float qt;
        private float tf;
        private float u;
        private float v;
        private float w;
        SparseArray<Float> xj;
        private float y;
        private float yo;
        private float zg;

        public xj(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof xj) {
                xj xjVar = (xj) layoutParams;
                this.xj = xjVar.xj.clone();
                this.hf = xjVar.hf.clone();
                return;
            }
            this.xj = new SparseArray<>();
            this.hf = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.xj.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.xj.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void am(float f) {
            this.y = f;
            this.xj.put(20, Float.valueOf(f));
        }

        public void c(float f) {
            this.g = f;
            this.xj.put(10, Float.valueOf(f));
        }

        public void d(float f) {
            this.qt = f;
            this.xj.put(12, Float.valueOf(f));
        }

        public void e(float f) {
            this.v = f;
            this.xj.put(28, Float.valueOf(f));
        }

        public void f(float f) {
            this.am = f;
            this.xj.put(11, Float.valueOf(f));
        }

        public void g(float f) {
            this.kd = f;
            this.xj.put(19, Float.valueOf(f));
        }

        public void hf(float f) {
            this.f = f;
            this.xj.put(6, Float.valueOf(f));
        }

        public void kd(float f) {
            this.p = f;
            this.xj.put(9, Float.valueOf(f));
        }

        public void p(float f) {
            this.w = f;
            this.xj.put(17, Float.valueOf(f));
        }

        public void pl(float f) {
            this.u = f;
            this.xj.put(18, Float.valueOf(f));
        }

        public void qt(float f) {
            this.e = f;
            this.xj.put(25, Float.valueOf(f));
        }

        public void tf(float f) {
            this.zg = f;
            this.xj.put(13, Float.valueOf(f));
        }

        public void u(float f) {
            this.tf = f;
            this.xj.put(8, Float.valueOf(f));
        }

        public void w(float f) {
            this.d = f;
            this.xj.put(7, Float.valueOf(f));
        }

        public void xj(float f) {
            this.c = f;
            this.xj.put(5, Float.valueOf(f));
        }

        public void y(float f) {
            this.f10092pl = f;
            this.xj.put(14, Float.valueOf(f));
        }

        public void zg(float f) {
            this.yo = f;
            this.xj.put(27, Float.valueOf(f));
        }

        public xj(int i, int i2) {
            super(i, i2);
            this.xj = new SparseArray<>();
            this.hf = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.xj.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.xj.put(16, Float.valueOf(i2));
            }
        }
    }

    private void xj(tf tfVar) {
        if (tfVar.hf() != null) {
            xj(tfVar.hf());
        } else {
            tfVar.xj(Float.NaN, Float.NaN);
        }
    }

    public void xj(View view, tf tfVar) {
        this.xj.put(view, tfVar);
        addView(view);
    }

    private void xj(View view, boolean z) {
        tf tfVar = this.xj.get(view);
        if (tfVar == null) {
            return;
        }
        tf hf2 = tfVar.hf();
        int i = 0;
        while (true) {
            if (i >= hf2.xj()) {
                break;
            }
            if (hf2.xj(i).equals(tfVar)) {
                hf2.hf(i);
                break;
            }
            i++;
        }
        tfVar.xj((Object) null);
        this.xj.remove(view);
        if (z) {
            this.hf.xj(Float.NaN, Float.NaN);
        }
    }

    private void xj(tf tfVar, float f, float f2) {
        View view = (View) tfVar.tf();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(tfVar.y() + f);
            int round2 = Math.round(tfVar.c() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(tfVar.f()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(tfVar.d()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int xj2 = tfVar.xj();
        for (int i = 0; i < xj2; i++) {
            if (equals(view)) {
                xj(tfVar.xj(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                xj(tfVar.xj(i), tfVar.y() + f, tfVar.c() + f2);
            }
        }
    }

    private void xj(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.hf.y(size2);
        }
        if (mode == 1073741824) {
            this.hf.u(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.hf.p(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.hf.tf(size);
        }
        this.hf.xj(Float.NaN, Float.NaN);
    }

    public static void xj(xj xjVar, tf tfVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            tfVar.xj(com.bytedance.adsdk.ugeno.yoga.w.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                tfVar.hf(u.LEFT, r0.left);
                tfVar.hf(u.TOP, r0.top);
                tfVar.hf(u.RIGHT, r0.right);
                tfVar.hf(u.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < xjVar.xj.size(); i++) {
            int keyAt = xjVar.xj.keyAt(i);
            float floatValue = xjVar.xj.valueAt(i).floatValue();
            if (keyAt == 4) {
                tfVar.w(com.bytedance.adsdk.ugeno.yoga.xj.xj(Math.round(floatValue)));
            } else if (keyAt == 0) {
                tfVar.xj(com.bytedance.adsdk.ugeno.yoga.xj.xj(Math.round(floatValue)));
            } else if (keyAt == 9) {
                tfVar.hf(com.bytedance.adsdk.ugeno.yoga.xj.xj(Math.round(floatValue)));
            } else if (keyAt == 25) {
                tfVar.pl(floatValue);
            } else if (keyAt == 8) {
                if (floatValue < 0.0f) {
                    tfVar.w();
                } else {
                    tfVar.w(floatValue);
                }
            } else if (keyAt == 1) {
                tfVar.xj(kd.xj(Math.round(floatValue)));
            } else if (keyAt == 6) {
                tfVar.xj(floatValue);
            } else if (keyAt == 7) {
                tfVar.hf(floatValue);
            } else if (keyAt == 16) {
                if (floatValue == -1.0f) {
                    tfVar.c(100.0f);
                } else if (floatValue == -2.0f) {
                    tfVar.kd();
                } else {
                    tfVar.y(floatValue);
                }
            } else if (keyAt == 18) {
                tfVar.xj(u.LEFT, floatValue);
            } else if (keyAt == 3) {
                tfVar.xj(y.xj(Math.round(floatValue)));
            } else if (keyAt == 17) {
                tfVar.xj(u.TOP, floatValue);
            } else if (keyAt == 20) {
                tfVar.xj(u.RIGHT, floatValue);
            } else if (keyAt == 19) {
                tfVar.xj(u.BOTTOM, floatValue);
            } else if (keyAt == 28) {
                tfVar.d(floatValue);
            } else if (keyAt == 27) {
                tfVar.f(floatValue);
            } else if (keyAt == 22) {
                tfVar.hf(u.LEFT, floatValue);
            } else if (keyAt == 21) {
                tfVar.hf(u.TOP, floatValue);
            } else if (keyAt == 24) {
                tfVar.hf(u.RIGHT, floatValue);
            } else if (keyAt == 23) {
                tfVar.hf(u.BOTTOM, floatValue);
            } else if (keyAt == 11) {
                tfVar.w(u.LEFT, floatValue);
            } else if (keyAt == 10) {
                tfVar.w(u.TOP, floatValue);
            } else if (keyAt == 13) {
                tfVar.w(u.RIGHT, floatValue);
            } else if (keyAt == 12) {
                tfVar.w(u.BOTTOM, floatValue);
            } else if (keyAt == 14) {
                tfVar.xj(g.xj(Math.round(floatValue)));
            } else if (keyAt == 15) {
                if (floatValue == -1.0f) {
                    tfVar.kd(100.0f);
                } else if (floatValue == -2.0f) {
                    tfVar.u();
                } else {
                    tfVar.u(floatValue);
                }
            } else if (keyAt == 2) {
                tfVar.xj(am.xj(Math.round(floatValue)));
            }
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.w = wVar;
    }
}
