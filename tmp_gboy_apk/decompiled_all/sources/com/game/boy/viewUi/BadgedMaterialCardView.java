package com.game.boy.viewUi;

import LLYwnm.AMqCpz;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.game.boy.R$styleable;
import com.google.android.material.card.MaterialCardView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BadgedMaterialCardView extends MaterialCardView {

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final TextView f11146BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public volatile int f11147BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f11148BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11149BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final float f11150BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final int f11151BniPrB;

    public BadgedMaterialCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11147BPw6Q8 = 0;
        this.f11148BTvldC = -65536;
        this.f11149BV3sI0 = -1;
        this.f11150BmvVmW = 14.0f;
        this.f11151BniPrB = 24;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f10882A4TApA);
            this.f11148BTvldC = obtainStyledAttributes.getColor(0, -65536);
            this.f11149BV3sI0 = obtainStyledAttributes.getColor(2, -1);
            this.f11150BmvVmW = obtainStyledAttributes.getDimension(3, 14.0f);
            this.f11151BniPrB = obtainStyledAttributes.getDimensionPixelSize(1, 24);
            obtainStyledAttributes.recycle();
        }
        TextView textView = new TextView(getContext());
        this.f11146BNL6CD = textView;
        textView.setGravity(17);
        this.f11146BNL6CD.setTextColor(this.f11149BV3sI0);
        this.f11146BNL6CD.setTextSize(0, this.f11150BmvVmW);
        this.f11146BNL6CD.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(this.f11148BTvldC);
        this.f11146BNL6CD.setBackground(gradientDrawable);
        int i = this.f11151BniPrB;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 8388661;
        int i2 = (int) (2 * getResources().getDisplayMetrics().density);
        layoutParams.topMargin = i2;
        layoutParams.rightMargin = i2;
        this.f11146BNL6CD.setLayoutParams(layoutParams);
        addView(this.f11146BNL6CD);
    }

    public final void A5SV6n() {
        if (this.f11147BPw6Q8 <= 0) {
            this.f11146BNL6CD.setVisibility(8);
            return;
        }
        this.f11146BNL6CD.setText(String.valueOf(this.f11147BPw6Q8));
        this.f11146BNL6CD.setVisibility(0);
        post(new AMqCpz(16, this));
    }

    public int getBadgeCount() {
        return this.f11147BPw6Q8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        TextView textView = this.f11146BNL6CD;
        if (textView != null) {
            textView.bringToFront();
        }
    }

    public void setBadgeColor(int i) {
        this.f11148BTvldC = i;
        TextView textView = this.f11146BNL6CD;
        if (textView == null || !(textView.getBackground() instanceof GradientDrawable)) {
            return;
        }
        ((GradientDrawable) this.f11146BNL6CD.getBackground()).setColor(this.f11148BTvldC);
        invalidate();
    }

    public void setBadgeTextColor(int i) {
        this.f11149BV3sI0 = i;
        TextView textView = this.f11146BNL6CD;
        if (textView != null) {
            textView.setTextColor(i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            this.f11147BPw6Q8 = 0;
        } else {
            A5SV6n();
        }
    }
}
