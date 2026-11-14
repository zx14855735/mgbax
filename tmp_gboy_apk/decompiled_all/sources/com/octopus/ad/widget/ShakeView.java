package com.octopus.ad.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.octopus.ad.R;
import com.octopus.ad.internal.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12722a;
    private TextView b;
    private String c;
    private AnimationDrawable d;

    public ShakeView(Context context, int i, float f, float f2, int i2) {
        super(context);
        this.f12722a = false;
        a(context, i, f, f2, i2);
    }

    public void a() {
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void b() {
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void setTitleText(String str) {
        this.c = str;
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a(Context context, int i, float f, float f2, int i2) {
        if (this.f12722a) {
            return;
        }
        this.f12722a = true;
        setGravity(1);
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        int i3 = (int) (i * 0.5d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        if (i2 == 0) {
            imageView.setImageResource(R.drawable.oct_anim_shake);
        } else {
            int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, q.a().q());
            layoutParams.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
            imageView.setImageResource(R.drawable.oct_anim_rotate);
            imageView.setBackgroundResource(R.drawable.oct_bg_rotate);
            int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, q.a().q());
            imageView.setPadding(applyDimension2, (int) TypedValue.applyDimension(1, f2 * 6.0f, q.a().q()), applyDimension2, applyDimension2);
        }
        this.d = (AnimationDrawable) imageView.getDrawable();
        addView(imageView, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.getPaint().setFakeBoldText(true);
        this.b.setGravity(1);
        this.b.setTextColor(-1);
        this.b.setTextSize(2, f);
        this.b.setText(this.c);
        this.b.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        addView(this.b, layoutParams2);
    }
}
