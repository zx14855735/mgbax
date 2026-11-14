package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.swiper.hf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BaseIndicator extends LinearLayout {
    private int c;
    private int d;
    private boolean f;
    protected int hf;
    private int kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10079pl;
    private float tf;
    private List<View> u;
    protected int w;
    protected Context xj;
    private int y;

    public BaseIndicator(Context context) {
        super(context);
        this.kd = -65536;
        this.y = -16776961;
        this.c = 5;
        this.hf = 40;
        this.w = 20;
        this.f10079pl = "row";
        this.xj = context;
        this.u = new ArrayList();
        setOrientation(0);
    }

    public int getSize() {
        return this.u.size();
    }

    public abstract Drawable hf(int i);

    public void setIndicatorDirection(String str) {
        this.f10079pl = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorHeight(int i) {
        this.w = i;
    }

    public void setIndicatorWidth(int i) {
        this.hf = i;
    }

    public void setIndicatorX(float f) {
        this.tf = f;
    }

    public void setIndicatorY(float f) {
        this.p = f;
    }

    public void setLoop(boolean z) {
        this.f = z;
    }

    public void setSelectedColor(int i) {
        this.kd = i;
    }

    public void setUnSelectedColor(int i) {
        this.y = i;
    }

    public void xj(int i, int i2) {
        Iterator<View> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().setBackground(hf(this.y));
        }
        if (i < 0 || i >= this.u.size()) {
            i = 0;
        }
        if (this.u.size() > 0) {
            this.u.get(i).setBackground(hf(this.kd));
            this.d = i2;
        }
    }

    public void xj(int i) {
        if (this instanceof DotIndicator) {
            this.w = this.hf;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hf, this.w);
        if (getOrientation() == 1) {
            int i2 = this.c;
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = i2;
        } else {
            int i3 = this.c;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.hf, this.w);
        if (getOrientation() == 1) {
            int i4 = this.c;
            layoutParams2.topMargin = i4;
            layoutParams2.bottomMargin = i4;
        } else {
            int i5 = this.c;
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i5;
        }
        int xj = hf.xj(this.f, this.d, this.u.size());
        int xj2 = hf.xj(this.f, i, this.u.size());
        if (this.u.size() == 0) {
            xj2 = 0;
        }
        if (!this.u.isEmpty() && hf.xj(xj, this.u) && hf.xj(xj2, this.u)) {
            this.u.get(xj).setBackground(hf(this.y));
            this.u.get(xj).setLayoutParams(layoutParams2);
            this.u.get(xj2).setBackground(hf(this.kd));
            this.u.get(xj2).setLayoutParams(layoutParams);
            this.d = i;
        }
    }

    public void xj() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.w = this.hf;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hf, this.w);
        if (getOrientation() == 1) {
            int i = this.c;
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
        } else {
            int i2 = this.c;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        }
        addView(view, layoutParams);
        view.setBackground(hf(this.y));
        this.u.add(view);
    }
}
