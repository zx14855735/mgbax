package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.wa;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashClickBarBtn extends RelativeLayout {
    private JSONObject ai;
    private Rect am;
    private RelativeLayout c;
    private SplashClickBarArrow d;
    private float dk;
    private final ValueAnimator e;
    private ws en;
    private float et;
    private LinearLayout f;
    private Path g;
    private wa hf;
    private ht ht;

    /* renamed from: io, reason: collision with root package name */
    private float f10327io;
    private int j;
    private int[] jk;
    private LottieAnimationView kd;
    private RockView p;

    /* renamed from: pl, reason: collision with root package name */
    private AnimatorSet f10328pl;
    private boolean pz;
    private JSONObject q;
    private Paint qt;
    private com.bytedance.sdk.openadsdk.core.hf.xj ra;
    private SlideUpView tf;
    private TextView u;
    private LinearGradient v;
    private TextView w;
    private JSONObject x;
    private GradientDrawable xj;
    private RelativeLayout y;
    private final ValueAnimator yo;
    private int z;
    private final AnimatorSet zg;

    public SplashClickBarBtn(Context context, ws wsVar) {
        super(context);
        this.hf = new wa();
        this.zg = new AnimatorSet();
        this.e = new ValueAnimator();
        this.yo = new ValueAnimator();
        this.jk = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.pz = false;
        this.dk = 13.0f;
        this.f10327io = 50.0f;
        this.en = wsVar;
        kd();
    }

    private void tf() {
        wa waVar = this.hf;
        if (waVar == null || waVar.d() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.tf == null) {
                    return;
                }
                SplashClickBarBtn.this.tf.xj();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.tf.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }, 500L);
    }

    public Animator getAnimator() {
        return this.zg;
    }

    public ht getShakeUtils() {
        return this.ht;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.xj();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ht htVar = this.ht;
        if (htVar != null) {
            ws wsVar = this.en;
            htVar.hf(wsVar != null ? wsVar.kd() : 0);
        }
        AnimatorSet animatorSet = this.f10328pl;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.zg;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.tf;
        if (slideUpView != null) {
            slideUpView.hf();
        }
        LottieAnimationView lottieAnimationView = this.kd;
        if (lottieAnimationView != null) {
            lottieAnimationView.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        y();
        super.onDraw(canvas);
        if (this.e.isRunning()) {
            this.qt.setShader(this.v);
            canvas.drawRoundRect(new RectF(this.am), r.w(getContext(), 50.0f), r.w(getContext(), 50.0f), this.qt);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ht htVar = this.ht;
        if (htVar != null) {
            if (z) {
                ws wsVar = this.en;
                htVar.xj(wsVar != null ? wsVar.kd() : 0);
            } else {
                ws wsVar2 = this.en;
                htVar.hf(wsVar2 != null ? wsVar2.kd() : 0);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.xj.setColor(i);
        setBackgroundDrawable(this.xj);
    }

    public void setCalculationMethod(int i) {
        this.z = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.j = i;
    }

    public void setDeepShakeValue(float f) {
        this.et = f;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.ai = jSONObject;
    }

    public void setShakeValue(float f) {
        this.dk = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.x = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.q = jSONObject;
    }

    public void setWriggleValue(float f) {
        this.f10327io = f;
    }

    private void c() {
        int parseColor = Color.parseColor("#57000000");
        int parseColor2 = Color.parseColor(this.hf.tf());
        this.xj.setColor(parseColor);
        this.yo.setIntValues(parseColor, parseColor2);
        this.yo.setEvaluator(new ArgbEvaluator());
        this.yo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.xj.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.xj);
            }
        });
        this.yo.setDuration(300L);
        this.yo.setStartDelay(800L);
        this.yo.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.zg.playTogether(this.yo);
    }

    private void d() {
        if (this.hf != null && isShown()) {
            if (this.hf.d() == 4 || this.hf.d() == 7) {
                if (this.ht == null) {
                    if (this.hf.d() == 4) {
                        this.ht = new ht(pz.getContext(), 1, com.bytedance.sdk.openadsdk.core.f.zg().kd());
                    } else if (this.hf.d() == 7) {
                        this.ht = new ht(pz.getContext(), 2, com.bytedance.sdk.openadsdk.core.f.zg().kd());
                    }
                }
                this.ht.xj(this.dk);
                this.ht.w(this.et);
                this.ht.hf(this.f10327io);
                this.ht.xj(this.x);
                this.ht.w(this.ai);
                this.ht.hf(this.q);
                this.ht.kd(this.z);
                this.ht.y(this.j);
                this.ht.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.ht.xj
                    public void xj(int i) {
                        if (SplashClickBarBtn.this.ra == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.ht.xj() && SplashClickBarBtn.this.en != null) {
                            com.bytedance.sdk.openadsdk.core.pl.w.w.y.u = true;
                        }
                        if (i == 1) {
                            if (SplashClickBarBtn.this.hf.d() == 4) {
                                ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) SplashClickBarBtn.this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj();
                                SplashClickBarBtn.this.ra.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (i == 2 && SplashClickBarBtn.this.hf.d() == 7) {
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) SplashClickBarBtn.this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).hf();
                            SplashClickBarBtn.this.ra.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                ht htVar = this.ht;
                ws wsVar = this.en;
                htVar.xj(wsVar != null ? wsVar.kd() : 0);
            }
        }
    }

    private void f() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.g.moveTo(point.x, point.y);
        this.g.lineTo(point2.x, point2.y);
        this.g.lineTo(point3.x, point3.y);
        this.g.lineTo(point4.x, point4.y);
        this.g.close();
        this.am = getBackground().getBounds();
        final int w = r.w(getContext(), 36.0f);
        final int w2 = r.w(getContext(), 45.0f);
        this.e.setIntValues(point.x - w, point2.x + w);
        this.e.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.e.setDuration(1600L);
        this.e.setStartDelay(1300L);
        this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.v = new LinearGradient(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0.0f, r10 + w, w2, SplashClickBarBtn.this.jk, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.zg.playTogether(this.e);
    }

    private void kd() {
        View xj = xj(getContext());
        if (xj == null) {
            return;
        }
        addView(xj);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.d = splashClickBarArrow;
        this.y.addView(splashClickBarArrow);
        this.d.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.c.getId());
        this.xj = xj(Color.parseColor("#57000000"));
        this.g = new Path();
        Paint paint = new Paint();
        this.qt = paint;
        paint.isAntiAlias();
    }

    private void y() {
        if (this.pz) {
            return;
        }
        this.pz = true;
        int d = this.hf.d();
        if (d == 1 || d == 2) {
            f();
            c();
        }
    }

    public void hf() {
        if (this.hf.d() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void u() {
        if (this.hf.d() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.kd != null) {
                        SplashClickBarBtn.this.kd.xj();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    public void w() {
        RockView rockView;
        if (this.hf.d() == 4 && (rockView = this.p) != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.p != null) {
                        SplashClickBarBtn.this.p.xj();
                    }
                }
            }, 500L);
        }
    }

    private View xj(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.y = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.y.setId(2114387576);
        this.y.setClipChildren(false);
        layoutParams2.addRule(13);
        this.y.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.y);
        this.p = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.p.setId(2114387575);
        layoutParams3.addRule(14);
        this.p.setLayoutParams(layoutParams3);
        r.xj((View) this.p, 8);
        this.y.addView(this.p);
        this.c = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.c.setId(2114387574);
        this.c.setClipChildren(false);
        layoutParams4.addRule(13);
        this.c.setGravity(17);
        this.c.setLayoutParams(layoutParams4);
        this.y.addView(this.c);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.c.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.kd = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.kd.setAnimation("lottie_json/twist_multi_angle.json");
        this.kd.setImageAssetsFolder("images/");
        this.kd.xj(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = r.w(context, 4.0f);
        layoutParams6.gravity = 17;
        this.kd.setLayoutParams(layoutParams6);
        linearLayout.addView(this.kd);
        r.xj((View) this.kd, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.tf = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = r.w(context, -140.0f);
        this.tf.setLayoutParams(layoutParams7);
        linearLayout.addView(this.tf);
        r.xj((View) this.tf, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.f.setGravity(17);
        this.f.setOrientation(1);
        this.f.setLayoutParams(layoutParams8);
        this.c.addView(this.f);
        TextView textView = new TextView(context);
        this.u = textView;
        LinearLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(textView, 2114387568, -2, -2);
        this.u.setSingleLine();
        this.u.setText(jk.xj(context, "tt_splash_click_bar_text"));
        this.u.setTextColor(-1);
        this.u.setTextSize(20.0f);
        this.u.setTypeface(Typeface.defaultFromStyle(1));
        this.u.setLayoutParams(ASJ6gh2);
        this.f.addView(this.u);
        r.xj((View) this.u, 8);
        TextView textView2 = new TextView(context);
        this.w = textView2;
        LinearLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(textView2, 2114387567, -2, -2);
        this.w.setShadowLayer(2.0f, 0.0f, 0.5f, jk.tf(context, "tt_splash_click_bar_text_shadow"));
        this.w.setSingleLine();
        this.w.setText(jk.xj(context, "tt_splash_click_bar_text"));
        this.w.setTextColor(-1);
        this.w.setTextSize(15.0f);
        this.w.setTypeface(Typeface.defaultFromStyle(1));
        this.w.setLayoutParams(ASJ6gh3);
        this.f.addView(this.w);
        r.xj((View) this.w, 8);
        return relativeLayout;
    }

    private GradientDrawable xj(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(r.w(pz.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void xj(wa waVar) {
        if (waVar == null) {
            return;
        }
        this.hf = waVar;
        if (waVar.d() == 4) {
            this.p.xj(this.hf);
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            textView.setVisibility(0);
            this.w.setText(TextUtils.isEmpty(this.hf.hf()) ? "点击跳转至详情页或第三方应用" : this.hf.hf());
            if (this.hf.pl() != null) {
                this.w.setTextSize(2, this.hf.pl().hf());
            }
        }
        if (this.u != null && this.hf.g() != null) {
            this.u.setTextSize(2, this.hf.g().hf());
        }
        this.xj.setColor(Color.parseColor("#57000000"));
        this.d.xj(this.hf.d());
        int d = this.hf.d();
        if (d == 1 || d == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f10328pl = animatorSet;
            animatorSet.playTogether(getAnimator(), this.d.getAnimator());
        } else if (d == 3) {
            TextView textView2 = this.u;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.u.setText(this.hf.p());
            }
            TextView textView3 = this.w;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.xj = xj(Color.parseColor(this.hf.tf()));
        } else {
            if (d == 4) {
                return;
            }
            if (d == 5) {
                SlideUpView slideUpView = this.tf;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.f;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.f.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.u;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.u.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.hf.p())) {
                        this.u.setText("向上滑动");
                    } else {
                        this.u.setText(this.hf.p());
                    }
                }
                TextView textView5 = this.w;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.hf.hf()) ? "滑动查看详情" : this.hf.hf());
                    this.w.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (d != 7) {
                this.xj.setStroke(0, com.sigmob.sdk.base.blurkit.d.f13043a);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f10328pl = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.d.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.hf.tf()));
                } catch (Throwable unused) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
            } else {
                TextView textView6 = this.u;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.u.setText(this.hf.p());
                    this.u.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.w;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.w.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.kd;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        setBackgroundDrawable(this.xj);
    }

    public void xj() {
        AnimatorSet animatorSet = this.f10328pl;
        if (animatorSet != null) {
            animatorSet.start();
        }
        hf();
        w();
        u();
        tf();
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.ra = xjVar;
        if (this.hf.d() == 4 || this.hf.d() == 7 || this.hf.d() == 5 || xjVar == null) {
            return;
        }
        xjVar.xj(this);
        setOnClickListener(xjVar);
        setOnTouchListener(xjVar);
        setId(2114387633);
    }
}
