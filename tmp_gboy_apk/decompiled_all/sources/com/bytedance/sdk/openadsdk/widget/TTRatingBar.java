package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTRatingBar extends LinearLayout {
    private Drawable c;
    private Drawable d;
    private Drawable f;
    private int hf;
    private float kd;
    private float u;
    private int w;
    private int xj;
    private float y;

    public TTRatingBar(Context context) {
        super(context);
        this.xj = 5;
        this.hf = 0;
        this.w = 0;
        xj(context);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.u), Math.round(this.kd)));
        imageView.setPadding(0, 0, Math.round(this.y), 0);
        return imageView;
    }

    private void xj(Context context) {
        setOrientation(0);
        this.c = jk.w(context, "tt_star_empty_bg");
        this.f = jk.w(context, "tt_star_full_bg");
        this.d = jk.w(context, "tt_star_empty_bg");
        this.u = xj(context, 15.0f);
        this.kd = xj(context, 15.0f);
        this.y = xj(context, 5.0f);
    }

    public Drawable getStarEmptyDrawable() {
        return this.c;
    }

    public int getStarEmptyNum() {
        return this.w;
    }

    public Drawable getStarFillDrawable() {
        return this.f;
    }

    public int getStarFillNum() {
        return this.xj;
    }

    public Drawable getStarHalfDrawable() {
        return this.d;
    }

    public int getStarHalfNum() {
        return this.hf;
    }

    public float getStarImageHeight() {
        return this.kd;
    }

    public float getStarImagePadding() {
        return this.y;
    }

    public float getStarImageWidth() {
        return this.u;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.c = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.w = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f = drawable;
    }

    public void setStarFillNum(int i) {
        this.xj = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.d = drawable;
    }

    public void setStarHalfNum(int i) {
        this.hf = i;
    }

    public void setStarImageHeight(float f) {
        this.kd = f;
    }

    public void setStarImagePadding(float f) {
        this.y = f;
    }

    public void setStarImageWidth(float f) {
        this.u = f;
    }

    private int xj(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void xj() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }
}
