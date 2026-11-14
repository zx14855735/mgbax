package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, ai.xj {
    private Handler am;
    private int c;
    private float d;
    private int f;
    private int g;
    private List<String> hf;
    private Context kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10194pl;
    private int tf;
    private final int u;
    private int w;
    Animation.AnimationListener xj;
    private TextView y;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.hf = new ArrayList();
        this.w = 0;
        this.u = 1;
        this.am = new ai(Looper.getMainLooper(), this);
        this.xj = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.y != null) {
                    AnimationText.this.y.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.kd = context;
        this.f = i;
        this.d = f;
        this.tf = i2;
        this.g = i3;
        w();
    }

    private void w() {
        setFactory(this);
    }

    public void hf() {
        List<String> list = this.hf;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.w;
        this.w = i + 1;
        this.p = i;
        setText(this.hf.get(i));
        if (this.w > this.hf.size() - 1) {
            this.w = 0;
        }
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.y = textView;
        textView.setTextColor(this.f);
        this.y.setTextSize(this.d);
        this.y.setMaxLines(this.tf);
        this.y.setTextAlignment(this.g);
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.am.sendEmptyMessageDelayed(1, this.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.am.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(p.hf(this.hf.get(this.p), this.d, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    public void setAnimationDuration(int i) {
        this.c = i;
    }

    public void setAnimationText(List<String> list) {
        this.hf = list;
    }

    public void setAnimationType(int i) {
        this.f10194pl = i;
    }

    public void setMaxLines(int i) {
        this.tf = i;
    }

    public void setTextColor(int i) {
        this.f = i;
    }

    public void setTextSize(float f) {
        this.d = f;
    }

    public void xj() {
        int i = this.f10194pl;
        if (i == 1) {
            setInAnimation(getContext(), jk.pl(this.kd, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), jk.pl(this.kd, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), jk.pl(this.kd, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), jk.pl(this.kd, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.xj);
            getOutAnimation().setAnimationListener(this.xj);
        }
        this.am.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 1) {
            return;
        }
        hf();
        this.am.sendEmptyMessageDelayed(1, this.c);
    }
}
