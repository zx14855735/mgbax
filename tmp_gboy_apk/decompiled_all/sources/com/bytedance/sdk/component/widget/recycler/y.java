package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends RecyclerView.v {
    protected PointF w;
    private final float y;
    protected final LinearInterpolator xj = new LinearInterpolator();
    protected final DecelerateInterpolator hf = new DecelerateInterpolator();
    protected int u = 0;
    protected int kd = 0;

    public y(Context context) {
        this.y = xj(context.getResources().getDisplayMetrics());
    }

    private int hf(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int w() {
        PointF pointF = this.w;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.y;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
    public void xj(View view, RecyclerView.jk jkVar, RecyclerView.v.xj xjVar) {
        int hf = hf(view, hf());
        int xj = xj(view, w());
        int xj2 = xj((int) Math.sqrt((xj * xj) + (hf * hf)));
        if (xj2 > 0) {
            xjVar.update(-hf, -xj, xj2, this.hf);
        }
    }

    public int hf(int i) {
        return (int) Math.ceil(Math.abs(i) * this.y);
    }

    public int hf() {
        PointF pointF = this.w;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.x;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    public int hf(View view, int i) {
        RecyclerView.d u = u();
        if (u == null || !u.w()) {
            return 0;
        }
        RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
        return xj(u.c(view) - ((ViewGroup.MarginLayoutParams) tfVar).leftMargin, u.d(view) + ((ViewGroup.MarginLayoutParams) tfVar).rightMargin, u.dk(), u.ht() - u.io(), i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
    public void xj(int i, int i2, RecyclerView.jk jkVar, RecyclerView.v.xj xjVar) {
        if (d() == 0) {
            kd();
            return;
        }
        this.u = hf(this.u, i);
        int hf = hf(this.kd, i2);
        this.kd = hf;
        if (this.u == 0 && hf == 0) {
            xj(xjVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
    public void xj() {
        this.kd = 0;
        this.u = 0;
        this.w = null;
    }

    public float xj(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int xj(int i) {
        return (int) Math.ceil(hf(i) / 0.3356d);
    }

    public void xj(RecyclerView.v.xj xjVar) {
        PointF u = u(f());
        if (u != null && (u.x != 0.0f || u.y != 0.0f)) {
            xj(u);
            this.w = u;
            this.u = (int) (u.x * 10000.0f);
            this.kd = (int) (u.y * 10000.0f);
            xjVar.update((int) (this.u * 1.2f), (int) (this.kd * 1.2f), (int) (hf(10000) * 1.2f), this.xj);
            return;
        }
        xjVar.xj(f());
        kd();
    }

    public int xj(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int xj(View view, int i) {
        RecyclerView.d u = u();
        if (u == null || !u.u()) {
            return 0;
        }
        RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
        return xj(u.f(view) - ((ViewGroup.MarginLayoutParams) tfVar).topMargin, u.tf(view) + ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin, u.et(), u.ra() - u.x(), i);
    }
}
