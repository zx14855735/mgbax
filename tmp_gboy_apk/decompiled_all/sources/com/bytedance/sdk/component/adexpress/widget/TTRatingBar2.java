package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.jk;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class TTRatingBar2 extends FrameLayout {
    private static final int d = (p.hf("", 0.0f, true)[1] / 2) + 1;
    private static final int tf = (p.hf("", 0.0f, true)[1] / 2) + 3;
    private double c;
    private float f;
    LinearLayout hf;
    private Drawable kd;
    private float u;
    private float w;
    LinearLayout xj;
    private Drawable y;

    static {
        Sqhz();
    }

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xj = new LinearLayout(getContext());
        this.hf = new LinearLayout(getContext());
        this.xj.setOrientation(0);
        this.xj.setGravity(8388611);
        this.hf.setOrientation(0);
        this.hf.setGravity(8388611);
        this.kd = jk.w(context, "tt_star_thick");
        this.y = jk.w(context, "tt_star");
    }

    private static /* synthetic */ void Sqhz() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.w, (int) this.u));
        imageView.setPadding(1, d, 1, tf);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.kd;
    }

    public Drawable getStarFillDrawable() {
        return this.y;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.xj.measure(i, i2);
        double d2 = this.c;
        float f = this.w;
        this.hf.measure(View.MeasureSpec.makeMeasureSpec((int) (((d2 - ((int) d2)) * (f - 2.0f)) + (((int) d2) * f) + 1.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(this.xj.getMeasuredHeight(), 1073741824));
        if (this.f > 0.0f) {
            this.xj.setPadding(0, ((int) (r7.getMeasuredHeight() - this.f)) / 2, 0, 0);
            this.hf.setPadding(0, ((int) (this.xj.getMeasuredHeight() - this.f)) / 2, 0, 0);
        }
    }

    public void xj(double d2, int i, int i2, int i3) {
        float f = i2;
        this.w = (int) f.w(getContext(), f);
        this.u = (int) f.w(getContext(), f);
        this.c = d2;
        this.f = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.hf.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.xj.addView(starImageView2);
        }
        addView(this.xj);
        addView(this.hf);
        requestLayout();
    }
}
