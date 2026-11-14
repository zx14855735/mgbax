package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    int f13305a;
    private final ImageView b;
    private final TextView c;
    private final TextView d;
    private final int e;
    private TextView f;
    private TextView g;
    private t h;
    private m i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private LinearLayout q;
    private BaseAdUnit r;

    public m(Context context, BaseAdUnit baseAdUnit, String str, String str2, float f, String str3, int i, int i2, String str4, int i3, int i4, int i5, int i6, int i7, float f2) {
        super(context);
        this.f13305a = Dips.asIntPixels(f2, context);
        this.m = Dips.asIntPixels(10.0f, context);
        this.r = baseAdUnit;
        this.j = i;
        this.e = i2;
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setText(str);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        textView.setSingleLine();
        textView.setTypeface(Typeface.defaultFromStyle(0));
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setGravity(16);
        textView.setId(ClientMetadata.generateViewId());
        textView.setPadding(this.m / 6, 0, 0, 0);
        this.l = i5;
        TextView textView2 = new TextView(context);
        this.c = textView2;
        textView2.setId(ClientMetadata.generateViewId());
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(i4);
        textView2.setGravity(17);
        textView.setSingleLine();
        textView2.setEllipsize(truncateAt);
        textView2.setText(str2);
        int asIntPixels = Dips.asIntPixels(5.0f, context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(asIntPixels * 6);
        CircleImageView circleImageView = new CircleImageView(context);
        this.b = circleImageView;
        circleImageView.setScaleType(ImageView.ScaleType.FIT_START);
        circleImageView.setId(ClientMetadata.generateViewId());
        circleImageView.b = false;
        float f3 = asIntPixels * 2;
        circleImageView.f13238a = f3;
        textView2.setBackground(gradientDrawable);
        textView2.setId(ClientMetadata.generateViewId());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f3);
        gradientDrawable2.setColor(i6);
        gradientDrawable2.setAlpha(i7);
        setBackground(gradientDrawable2);
        this.i = this;
        if (i2 == 1) {
            a(context, f);
        } else {
            a(context, str3);
        }
        if (baseAdUnit.getMaterial() != null && baseAdUnit.getMaterial().ad_privacy != null) {
            a(context);
        }
        setupUILayout(context);
        circleImageView.setVisibility(4);
        a(str4);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float a(float f) {
        SigmobLog.e("input: " + f);
        return (float) ((Math.sin(((f - 0.13333334f) * 6.283185307179586d) / 0.4000000059604645d) * Math.pow(2.0d, (-10.0f) * f)) + 1.0d);
    }

    private void d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 0.5f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new ARc23Z());
        f();
        ofPropertyValuesHolder.setDuration(2000L);
        ofPropertyValuesHolder.start();
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private void e() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 0.95f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.6f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.7f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.8f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        f();
        this.p = true;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.sigmob.sdk.base.views.m.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                m.this.o = false;
                m.this.p = false;
                m.this.i.clearAnimation();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m.this.o = false;
                m.this.p = false;
                m.this.i.clearAnimation();
            }
        });
        ofPropertyValuesHolder.start();
    }

    private void f() {
        this.n = true;
        super.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        super.setVisibility(4);
    }

    private void h() {
        SigmobLog.d("startDownToUpAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        f();
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sigmob.sdk.base.views.m.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                m.this.o = false;
                m.this.i.clearAnimation();
                SigmobLog.d("startDownToUpAnimator end");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.i.startAnimation(translateAnimation);
    }

    private void i() {
        SigmobLog.d("startUpToDownAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sigmob.sdk.base.views.m.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                m.this.o = true;
                m.this.i.clearAnimation();
                m.this.g();
                SigmobLog.d("startUpToDownAnimator end");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.i.startAnimation(translateAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.view.ViewGroup, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.ViewGroup, com.sigmob.sdk.base.views.m] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setupUILayout(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 1114636288(0x42700000, float:60.0)
            int r0 = com.czhj.sdk.common.utils.Dips.asIntPixels(r0, r8)
            r1 = 15
            android.widget.RelativeLayout$LayoutParams r2 = J3FDQU.A2egSU.ASJ6gh(r0, r0, r1)
            int r3 = r7.m
            int r4 = r3 / 4
            r5 = 0
            r2.setMargins(r3, r4, r5, r5)
            android.widget.ImageView r3 = r7.b
            int r4 = com.czhj.sdk.common.ClientMetadata.generateViewId()
            r3.setId(r4)
            android.widget.ImageView r3 = r7.b
            r7.addView(r3, r2)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            float r0 = (float) r0
            r3 = 1072064102(0x3fe66666, float:1.8)
            float r0 = r0 / r3
            int r0 = (int) r0
            r3 = -2
            r2.<init>(r3, r0)
            int r0 = r7.m
            r2.setMargins(r5, r5, r0, r5)
            r2.addRule(r1)
            r0 = 11
            r2.addRule(r0)
            android.widget.TextView r0 = r7.c
            int r4 = r7.m
            r0.setPadding(r4, r5, r4, r5)
            android.widget.TextView r0 = r7.c
            r7.addView(r0, r2)
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r0.<init>(r8)
            r2 = 1
            r0.setOrientation(r2)
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r4.<init>(r3, r3)
            int r6 = r7.m
            int r6 = r6 / 2
            r4.setMargins(r6, r5, r5, r5)
            r4.addRule(r1)
            android.widget.ImageView r1 = r7.b
            int r1 = r1.getId()
            r4.addRule(r2, r1)
            android.widget.TextView r1 = r7.c
            int r1 = r1.getId()
            r4.addRule(r5, r1)
            r7.addView(r0, r4)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r3, r3)
            android.widget.TextView r4 = r7.d
            r0.addView(r4, r1)
            android.widget.TextView r1 = r7.f
            r4 = 8
            if (r1 == 0) goto Lc2
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            r1.<init>(r8)
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r8.<init>(r3, r3)
            android.widget.TextView r5 = r7.f
            r1.addView(r5, r8)
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r8.<init>(r3, r3)
            android.widget.TextView r5 = r7.f
            int r5 = r5.getId()
            r8.addRule(r2, r5)
            android.widget.TextView r2 = r7.f
            int r2 = r2.getId()
            r5 = 6
            r8.addRule(r5, r2)
            android.widget.TextView r2 = r7.f
            int r2 = r2.getId()
            r8.addRule(r4, r2)
            com.sigmob.sdk.base.views.t r2 = r7.h
            r1.addView(r2, r8)
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r8.<init>(r3, r3)
        Lbe:
            r0.addView(r1, r8)
            goto Lce
        Lc2:
            android.widget.TextView r8 = r7.g
            if (r8 == 0) goto Lce
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r8.<init>(r3, r3)
            android.widget.TextView r1 = r7.g
            goto Lbe
        Lce:
            android.widget.LinearLayout r8 = r7.q
            if (r8 == 0) goto Le5
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r8.<init>(r3, r3)
            android.widget.ImageView r1 = r7.b
            int r1 = r1.getId()
            r8.addRule(r4, r1)
            android.widget.LinearLayout r1 = r7.q
            r0.addView(r1, r8)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.m.setupUILayout(android.content.Context):void");
    }

    public LinearLayout getFourElementsLayout() {
        return this.q;
    }

    @Override // android.view.View
    public int getVisibility() {
        return super.getVisibility();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.l == 1) {
            this.c.setOnTouchListener(onTouchListener);
        } else {
            super.setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            super.setVisibility(i);
            this.k = false;
            return;
        }
        if (i == 0) {
            this.k = true;
            if (this.i.getAnimation() == null && !this.p && this.b.getVisibility() == 0) {
                c();
                return;
            }
            return;
        }
        if (i != 4) {
            super.setVisibility(i);
        } else {
            if (this.i.getAnimation() != null) {
                return;
            }
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = this.j;
        if (i == 1) {
            e();
            return;
        }
        if (i == 2) {
            h();
        } else if (i != 3) {
            h();
        } else {
            f();
        }
    }

    public boolean b() {
        return this.o;
    }

    public void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.q = linearLayout;
        linearLayout.setOrientation(0);
        this.q.setId(ClientMetadata.generateViewId());
        int asIntPixels = Dips.asIntPixels(2.0f, context);
        String[] strArr = {"名称", "版本", "开发者", "权限", "隐私协议", "介绍"};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            TextView textView = new TextView(context);
            textView.setTextSize(1, 8.0f);
            textView.setText(str);
            textView.setTextColor(-7829368);
            textView.setAlpha(0.7f);
            textView.getPaint().setAntiAlias(true);
            textView.getPaint().setFlags(8);
            int i2 = asIntPixels / 2;
            textView.setPadding(i2, 0, i2, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, asIntPixels, 0);
            this.q.addView(textView, layoutParams);
        }
    }

    public void a(Context context, float f) {
        TextView textView = new TextView(context);
        this.f = textView;
        textView.setTextSize(1, 14.0f);
        this.f.setId(ClientMetadata.generateViewId());
        this.f.setGravity(17);
        this.f.setTextColor(-7829368);
        if (f > 0.0f) {
            this.f.setText(String.format("%.1f", Float.valueOf(f)));
        }
        this.h = new t(context, f);
    }

    public void a(Context context, String str) {
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setId(ClientMetadata.generateViewId());
        this.g.setTextColor(-7829368);
        this.g.setSingleLine();
        this.g.setGravity(17);
        this.g.setTextSize(1, 14.0f);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setText(str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.m.4
            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
            }

            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                m.this.b.setImageBitmap(bitmap);
                m.this.b.setVisibility(0);
                if (m.this.k) {
                    m.this.c();
                }
            }
        });
    }

    public boolean a() {
        return this.n;
    }
}
