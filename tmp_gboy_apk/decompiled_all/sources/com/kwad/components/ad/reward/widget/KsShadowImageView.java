package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.sdk.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsShadowImageView extends ImageView {
    private Paint Eq;
    private BlurMaskFilter Er;
    private int Es;
    private boolean Et;
    private boolean Eu;
    private boolean Ev;
    private boolean Ew;
    private Rect Ex;
    private int Ey;

    public KsShadowImageView(Context context) {
        super(context);
        this.Ew = true;
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.Eq = new Paint();
        this.Er = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Ex = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.Es = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Ey = obtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.Et = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.Eu = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.Ev = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.Ew = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Eq.setMaskFilter(this.Er);
        this.Eq.setColor(this.Ey);
        this.Eq.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.Ex;
        rect.left = this.Et ? this.Es : 0;
        rect.top = this.Ev ? this.Es : 0;
        rect.right = measuredWidth - (this.Eu ? this.Es : 0);
        rect.bottom = measuredHeight - (this.Ew ? this.Es : 0);
        canvas.drawRect(rect, this.Eq);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ew = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ew = true;
        a(context, attributeSet, i);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Ew = true;
        a(context, attributeSet, i);
    }
}
