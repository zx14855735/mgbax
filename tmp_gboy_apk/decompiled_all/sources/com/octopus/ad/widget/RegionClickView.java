package com.octopus.ad.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class RegionClickView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12716a;
    private GradientDrawable b;
    private TextView c;

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12716a = false;
        a(context);
    }

    public void a(String str, float f) {
        setTitle(str);
        setTitleColor("#FFFFFF");
        setTitleSize(f * 14.0f);
        setBackGroundAlpha(0.7d);
        setBackgroundColor("#80000000");
    }

    public void setBackGroundAlpha(double d) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable == null || d <= 0.0d) {
            return;
        }
        gradientDrawable.setAlpha((int) (d * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitleSize(float f) {
        TextView textView = this.c;
        if (textView == null || f <= 0.0f) {
            return;
        }
        textView.setTextSize(2, f);
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12716a = false;
        a(context);
    }

    private void a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.b = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        this.b.setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD);
        if (i == 1) {
            this.b.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.b.setCornerRadius(ViewUtil.dip2px(context, 30.0f));
        setBackgroundDrawable(this.b);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f12716a = false;
        a(context);
    }

    public void a(Context context) {
        if (this.f12716a) {
            return;
        }
        this.f12716a = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.getPaint().setFakeBoldText(true);
        this.c.setLines(1);
        this.c.setTextSize(2, 14.0f);
        this.c.setTextColor(Color.parseColor("#FFFFFF"));
        this.c.setText("点击跳转至第三方应用或详情页");
        this.c.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.c);
    }
}
