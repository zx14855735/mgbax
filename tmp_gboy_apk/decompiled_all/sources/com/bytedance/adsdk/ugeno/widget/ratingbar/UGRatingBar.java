package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.w;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.adsdk.ugeno.y.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class UGRatingBar extends FrameLayout {
    private Context c;
    private w f;
    private float hf;
    private LinearLayout kd;
    private float u;
    private double w;
    private float xj;
    private LinearLayout y;

    public UGRatingBar(Context context) {
        super(context);
        this.c = context;
        this.kd = new LinearLayout(context);
        this.y = new LinearLayout(context);
        this.kd.setOrientation(0);
        this.kd.setGravity(8388611);
        this.y.setOrientation(0);
        this.y.setGravity(8388611);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.xj, (int) this.hf);
        float f = this.u;
        layoutParams.leftMargin = (int) f;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.f;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.f;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.f;
        if (wVar != null) {
            wVar.xj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.f;
        if (wVar != null) {
            wVar.xj(i, i2);
        }
        super.onMeasure(i, i2);
        this.kd.measure(i, i2);
        double floor = Math.floor(this.w);
        float f = this.u;
        this.y.measure(View.MeasureSpec.makeMeasureSpec((int) (((this.w - floor) * this.xj) + ((f + f + r2) * floor) + f), 1073741824), View.MeasureSpec.makeMeasureSpec(this.kd.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w wVar = this.f;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.f;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void xj(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.kd.removeAllViews();
        this.y.removeAllViews();
        this.xj = (int) f.xj(this.c, f);
        this.hf = (int) f.xj(this.c, f);
        this.w = d;
        this.u = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(u.hf(this.c, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.y.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(u.hf(this.c, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.kd.addView(starImageView2);
        }
        addView(this.kd);
        addView(this.y);
        requestLayout();
    }

    public void xj(w wVar) {
        this.f = wVar;
    }
}
