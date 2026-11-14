package com.bytedance.sdk.openadsdk.core.component.reward.business.xj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.hf.hf;
import com.bytedance.sdk.openadsdk.x.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private TextView c;
    private ObjectAnimator d;
    private ObjectAnimator f;
    private final ws hf;
    private View kd;
    private final hf tf;
    private ViewGroup u;
    private ImageView w;
    private final TTBaseVideoActivity xj;
    private LinearLayout y;

    public xj(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, hf hfVar) {
        this.xj = tTBaseVideoActivity;
        this.hf = wsVar;
        this.tf = hfVar;
    }

    public int hf() {
        int identifier = this.xj.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.xj.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void u() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f.cancel();
            this.f = null;
        }
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.d.cancel();
            this.d = null;
        }
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.kd;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.tf.f();
    }

    public void w() {
        u();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kd, "alpha", 1.0f, 0.3f);
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                xj.this.kd.setAlpha(1.0f);
                xj.this.tf.d();
            }
        });
        ofFloat.start();
    }

    public void xj(ViewGroup viewGroup, View view) {
        this.u = viewGroup;
        this.kd = view;
        this.w = new ImageView(this.xj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, r.w(this.xj, 76.0f));
        layoutParams.gravity = 80;
        this.w.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.u.addView(this.w, layoutParams);
    }

    public void xj() {
        int yo;
        LinearLayout linearLayout = new LinearLayout(this.xj);
        this.y = linearLayout;
        linearLayout.setGravity(1);
        this.y.setPadding(0, r.w(this.xj, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, r.w(this.xj, 76.0f));
        TextView textView = new TextView(this.xj);
        this.c = textView;
        textView.setTextSize(12.0f);
        this.c.setTextColor(-1);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.START);
        this.c.setGravity(5);
        this.c.setMaxWidth(r.w(this.xj, 260.0f));
        this.y.addView(this.c);
        TextView textView2 = new TextView(this.xj);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj.this.u();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = r.w(this.xj, 10.0f);
        this.y.addView(textView2, layoutParams2);
        xj(25, h.hf(this.hf));
        int w = r.w(this.xj, 76.0f);
        this.u.addView(this.y, layoutParams);
        try {
            int hf = f.hf(this.xj);
            if (r.u((Activity) this.xj)) {
                yo = (f.w(this.xj) - hf) - hf();
            } else {
                yo = r.yo(this.xj);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, "translationY", hf, (hf - w) + yo);
            this.f = ofFloat;
            ofFloat.setDuration(300L);
            this.f.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kd, "translationY", 0.0f, -w);
            this.d = ofFloat2;
            ofFloat2.setDuration(300L);
            this.d.start();
        } catch (Throwable th) {
            pl.u("layout", th.getMessage());
        }
    }

    public void xj(final int i, String str) {
        com.bytedance.sdk.openadsdk.f.hf.xj(str).type(2).config(Bitmap.Config.ARGB_8888).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj.2
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                try {
                    Bitmap result = zgVar.getResult();
                    if (result == null) {
                        return;
                    }
                    if (result.getConfig() == Bitmap.Config.RGB_565) {
                        result = result.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(xj.this.xj, result, i);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(xj.this.xj.getResources(), xj);
                    c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (xj.this.y != null) {
                                xj.this.y.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (xj.this.w != null) {
                                xj.this.w.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    pl.u("layout", th.getMessage());
                }
            }
        }, 4);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        tf tfVar = new tf();
        tfVar.hf(true);
        if (hfVar != null) {
            hfVar.xj(tfVar);
            hfVar.xj(null, tfVar);
        }
    }

    public void xj(long j) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
