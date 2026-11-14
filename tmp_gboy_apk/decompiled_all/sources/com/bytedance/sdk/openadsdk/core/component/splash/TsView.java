package com.bytedance.sdk.openadsdk.core.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.zg;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.lw;
import com.bytedance.sdk.openadsdk.core.ra.op;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TsView extends FrameLayout {
    private boolean am;
    private NativeExpressView c;
    private TextView d;
    private String f;
    private xj g;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.u hf;
    private TextView kd;
    private ws p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10329pl;
    private FrameLayout qt;
    private FrameLayout tf;
    private FrameLayout u;
    private ImageView w;
    private final Context xj;
    private SplashClickBar y;

    public interface xj {
        void d();

        void f();

        void xj(boolean z);
    }

    public TsView(Context context, String str, ws wsVar) {
        super(context);
        this.f10329pl = false;
        this.am = false;
        this.xj = context;
        this.f = str;
        this.p = wsVar;
        w();
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u uVar = this.hf;
        if (uVar == null) {
            return null;
        }
        return uVar.getView();
    }

    private boolean kd() {
        ws wsVar = this.p;
        return wsVar != null && wsVar.rs() == 2;
    }

    private void setComplianceBarLayout(ws wsVar) {
        lw ez;
        if (this.d == null || !w(wsVar) || (ez = wsVar.ez()) == null) {
            return;
        }
        int xj2 = ez.xj();
        int hf = ez.hf();
        int w = ez.w();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = r.w(pz.getContext(), 25.0f);
        layoutParams.rightMargin = r.w(pz.getContext(), 25.0f);
        this.d.setPadding(20, 20, 20, 20);
        this.d.setHighlightColor(0);
        if (xj2 == 2) {
            layoutParams.gravity = 80;
            if (u()) {
                layoutParams.bottomMargin = r.w(pz.getContext(), w);
            } else {
                layoutParams.bottomMargin = r.w(pz.getContext(), hf);
            }
        } else {
            layoutParams.gravity = 48;
            if (u()) {
                layoutParams.topMargin = r.w(pz.getContext(), w);
            } else {
                layoutParams.topMargin = r.w(pz.getContext(), hf);
            }
        }
        this.tf.setLayoutParams(layoutParams);
    }

    private void w() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View xj2 = xj(this.xj);
            if (xj2 == null) {
                return;
            }
            addView(xj2);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.p);
            this.y = splashClickBar;
            addView(splashClickBar);
            FrameLayout hf = hf(this.p);
            this.tf = hf;
            if (hf != null) {
                addView(hf);
            }
        } catch (Throwable unused) {
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.u getCountDownView() {
        return this.hf;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.qt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!kd() && !this.am) {
            r.xj(this, getCountDownLayout());
            r.xj(this, this.w);
        }
        xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.d();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f10329pl) {
            return;
        }
        SplashClickBar splashClickBar = this.y;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!u());
        }
        setComplianceBarLayout(this.p);
        this.f10329pl = true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.xj(z);
        }
    }

    public void setAdlogoViewVisibility(int i) {
        r.xj((View) this.kd, i);
    }

    public void setAttachedToWindowListener(xj xjVar) {
        this.g = xjVar;
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            r.xj((View) this.y, i);
        }
        r.xj((View) this.tf, i);
    }

    public void setCountDownTime(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u uVar = this.hf;
        if (uVar != null) {
            uVar.setCountDownTime(i);
        }
    }

    public void setCountDownViewPosition(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u uVar = this.hf;
        if (uVar == null || uVar.getView() == null || wsVar == null) {
            return;
        }
        View view = this.hf.getView();
        op dx = wsVar.dx();
        if (dx == null) {
            return;
        }
        int xj2 = dx.xj();
        int w = r.w(this.xj, dx.hf());
        int w2 = r.w(this.xj, dx.w());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (xj2 == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = w;
            layoutParams.topMargin = w2;
        } else if (xj2 == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = w;
            layoutParams.bottomMargin = w2;
        } else if (xj2 != 4) {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = w;
            layoutParams.topMargin = w2;
        } else {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = w;
            layoutParams.bottomMargin = w2;
        }
        view.setLayoutParams(layoutParams);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.c = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        this.u.addView(this.c);
        setExpressViewVisibility(0);
    }

    public void setExpressViewVisibility(int i) {
        r.xj((View) this.u, i);
    }

    public void setIsShowSuccess(boolean z) {
        this.am = z;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        zg.xj("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        zg.xj("不允许在Splash广告中注册OnTouchListener");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i) {
        r.xj(getCountDownLayout(), i);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u uVar = this.hf;
        if (uVar == null || uVar.getView() == null) {
            return;
        }
        this.hf.getView().setOnClickListener(onClickListener);
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setVideoViewVisibility(int i) {
        r.xj((View) this.w, i);
    }

    public void setVideoVoiceVisibility(int i) {
        r.xj((View) this.w, i);
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void u(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.hf(wsVar, context, str);
    }

    private View xj(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.u = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.u.setId(2114387581);
        this.u.setLayoutParams(layoutParams);
        frameLayout.addView(this.u);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.qt = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.w = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = r.w(this.xj, 16.0f);
        layoutParams2.leftMargin = r.w(this.xj, 16.0f);
        this.w.setId(2114387580);
        this.w.setLayoutParams(layoutParams2);
        jk.xj(this.xj, "tt_splash_mute", this.w);
        r.xj((View) this.w, 8);
        frameLayout.addView(this.w);
        this.hf = xj(frameLayout, context);
        this.kd = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.kd.setId(2114387578);
        this.kd.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = r.w(this.xj, 40.0f);
        layoutParams3.leftMargin = r.w(this.xj, 20.0f);
        jk.xj(this.xj, "tt_ad_logo_new", this.kd);
        this.kd.setLayoutParams(layoutParams3);
        frameLayout.addView(this.kd);
        return frameLayout;
    }

    public FrameLayout hf(final ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ra.y ut;
        lw ez;
        if (wsVar == null || wsVar.vw() != 4 || (ut = wsVar.ut()) == null || (ez = wsVar.ez()) == null || ez.xj() == 0) {
            return null;
        }
        String am = ut.am();
        if (TextUtils.isEmpty(am)) {
            am = "暂无";
        }
        String kd = ut.kd();
        if (TextUtils.isEmpty(kd)) {
            kd = "补充中，可于应用官网查看";
        }
        String c = ut.c();
        String str = TextUtils.isEmpty(c) ? "补充中，可于应用官网查看" : c;
        StringBuilder sb = new StringBuilder();
        sb.append("应用名：");
        sb.append(am);
        sb.append("；版本号：");
        sb.append(kd);
        sb.append("；开发者：");
        sb.append(str);
        String p = ut.p();
        if (TextUtils.isEmpty(p)) {
            sb.append("；功能 | 权限 | 隐私  ");
        } else {
            sb.append("；功能 | 权限 | 隐私 | 备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int indexOf = sb.indexOf("功能");
        int i = indexOf + 2;
        int indexOf2 = sb.indexOf("隐私");
        int i2 = indexOf2 + 2;
        int indexOf3 = sb.indexOf("权限");
        int i3 = indexOf3 + 2;
        if (!TextUtils.isEmpty(p)) {
            int indexOf4 = sb.indexOf("备案");
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    TsView tsView = TsView.this;
                    tsView.xj(wsVar, tsView.xj, TsView.this.f);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(-1);
                    }
                }
            }, indexOf4, indexOf4 + 2, 34);
        }
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.hf(wsVar, tsView.xj, TsView.this.f);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf, i, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.u(wsVar, tsView.xj, TsView.this.f);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf2, i2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.w(wsVar, tsView.xj, TsView.this.f);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf3, i3, 34);
        this.d = new TextView(this.xj);
        this.tf = new FrameLayout(this.xj);
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
        this.d.setTextColor(-1);
        this.d.setTextSize(11.0f);
        this.d.setText(spannableString);
        this.tf.addView(this.d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(r.w(this.xj, 6.0f));
        this.tf.setBackground(gradientDrawable);
        return this.tf;
    }

    private boolean u() {
        return getHeight() < r.hf(pz.getContext())[1];
    }

    private boolean w(ws wsVar) {
        lw ez;
        return (wsVar == null || wsVar.vw() != 4 || wsVar.ut() == null || (ez = wsVar.ez()) == null || ez.xj() == 0) ? false : true;
    }

    public void w(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.w(wsVar, context, str);
    }

    public void xj(ws wsVar) {
        SplashClickBar splashClickBar = this.y;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.xj(wsVar);
            r.xj(this.kd, wsVar);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void xj(int i, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        SplashClickBar splashClickBar = this.y;
        if (splashClickBar != null) {
            splashClickBar.xj(xjVar);
        }
        if (i == 1) {
            xjVar.xj(this);
            setOnClickListenerInternal(xjVar);
            setOnTouchListenerInternal(xjVar);
        }
    }

    public void hf(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(context, wsVar, str);
    }

    public void hf() {
        TextView textView = this.kd;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u uVar = this.hf;
        if (uVar == null || uVar.getView() == null) {
            return;
        }
        this.hf.xj(true);
        this.hf.getView().setVisibility(8);
    }

    public void xj(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(wsVar, context, str);
    }

    public void xj() {
        TextView textView = this.kd;
        if (textView != null) {
            jk.xj(this.xj, "tt_ad_logo_backup", textView);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.u xj(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        ws wsVar = this.p;
        op dx = wsVar == null ? null : wsVar.dx();
        if ((dx == null ? 1 : dx.u()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = r.w(this.xj, 16.0f);
            layoutParams.rightMargin = r.w(this.xj, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }
}
