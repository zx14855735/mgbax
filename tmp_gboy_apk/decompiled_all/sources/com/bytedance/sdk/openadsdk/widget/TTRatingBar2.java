package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTRatingBar2 extends FrameLayout {
    private int c;
    private int d;
    private int f;
    LinearLayout hf;
    private double kd;
    private Drawable p;
    private Drawable tf;
    private int u;
    private int w;
    LinearLayout xj;
    private int y;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xj = new LinearLayout(getContext());
        this.hf = new LinearLayout(getContext());
        this.xj.setOrientation(0);
        this.xj.setGravity(8388611);
        this.hf.setOrientation(0);
        this.hf.setGravity(8388611);
        this.tf = jk.w(context, "tt_ratingbar_empty_star2");
        this.p = jk.w(context, "tt_ratingbar_full_star2");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.w, this.u);
        layoutParams.leftMargin = this.y;
        layoutParams.topMargin = this.c;
        layoutParams.rightMargin = this.f;
        layoutParams.bottomMargin = this.d;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public Drawable getEmptyStarDrawable() {
        return this.tf;
    }

    public Drawable getFillStarDrawable() {
        return this.p;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.xj.measure(i, i2);
        double floor = Math.floor(this.kd);
        int i3 = this.y;
        int i4 = this.f + i3;
        this.hf.measure(View.MeasureSpec.makeMeasureSpec((int) (((this.kd - floor) * this.w) + ((i4 + r2) * floor) + i3), 1073741824), View.MeasureSpec.makeMeasureSpec(this.xj.getMeasuredHeight(), 1073741824));
    }

    public void setRating(double d) {
        this.kd = d;
    }

    public void xj(int i, int i2) {
        this.w = i2;
        this.u = i;
    }

    public void xj() {
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.hf.addView(starImageView);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.xj.addView(starImageView2);
        }
        addView(this.xj);
        addView(this.hf);
        requestLayout();
    }

    public void xj(int i, int i2, int i3, int i4) {
        this.y = i;
        this.c = i2;
        this.f = i3;
        this.d = i4;
    }
}
