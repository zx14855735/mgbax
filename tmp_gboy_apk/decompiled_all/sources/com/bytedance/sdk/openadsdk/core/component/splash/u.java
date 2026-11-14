package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.splash.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.bl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class u extends w implements View.OnClickListener {
    private TextView am;
    private ImageView c;
    private FrameLayout d;
    private RelativeLayout e;
    private View f;
    private TextView g;
    private ht ht;
    private RelativeLayout jk;
    protected com.bytedance.sdk.openadsdk.zg.w.hf.c kd;
    private ImageView p;

    /* renamed from: pl, reason: collision with root package name */
    private TextView f10338pl;
    private TextView pz;
    private TextView qt;
    private View.OnClickListener ra;
    private RelativeLayout tf;
    private TextView v;
    private RelativeLayout y;
    private TextView yo;
    private View zg;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = view.getId() == 2114387553 ? 0 : view.getId() == 2114387561 ? 1 : view.getId() == 2114387556 ? 2 : view.getId() == 2114387555 ? 3 : view.getId() == 2114387554 ? 4 : 5;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e) {
            pl.xj(e);
        }
        View.OnClickListener onClickListener = this.ra;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private View xj(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.y = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.y.setClipChildren(false);
        this.y.setVisibility(4);
        this.y.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.y);
        ImageView imageView = new ImageView(context);
        this.f = imageView;
        imageView.setId(2114387561);
        this.f.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.y.addView(this.f);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.y.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.am = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = r.w(context, 8.0f);
        layoutParams3.bottomMargin = r.w(context, 10.0f);
        layoutParams3.rightMargin = r.w(context, 4.0f);
        this.am.setLayoutParams(layoutParams3);
        jk.xj(this.xj, "tt_splash_card_feedback_bg", this.am);
        this.am.setGravity(17);
        this.am.setText(jk.xj(this.xj, "tt_feedback"));
        this.am.setTextColor(Color.parseColor("#99FFFFFF"));
        this.am.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.am);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.tf = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.tf.setLayoutParams(layoutParams4);
        this.tf.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.y.addView(this.tf);
        FrameLayout frameLayout = new FrameLayout(context);
        this.d = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = r.w(context, -42.0f);
        this.d.setElevation(r.w(context, 3.0f));
        this.d.setLayoutParams(layoutParams5);
        this.tf.addView(this.d);
        ImageView imageView2 = new ImageView(context);
        this.p = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f));
        this.p.setLayoutParams(layoutParams6);
        this.d.addView(this.p);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int w = r.w(context, 6.0f);
        gradientDrawable.setCornerRadius(w);
        gradientDrawable.setStroke(w / 3, -1);
        view.setBackground(gradientDrawable);
        this.d.addView(view);
        TextView textView2 = new TextView(context);
        this.f10338pl = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = r.w(context, 16.0f);
        this.f10338pl.setLayoutParams(layoutParams7);
        TextView textView3 = this.f10338pl;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView3.setEllipsize(truncateAt);
        this.f10338pl.setMaxLines(1);
        this.f10338pl.setTextColor(Color.parseColor("#161823"));
        this.f10338pl.setTextSize(2, 20.0f);
        this.tf.addView(this.f10338pl);
        TextView textView4 = new TextView(context);
        this.g = textView4;
        textView4.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(r.w(context, 42.0f));
        layoutParams8.setMarginEnd(r.w(context, 42.0f));
        layoutParams8.topMargin = r.w(context, 8.0f);
        this.g.setLayoutParams(layoutParams8);
        this.g.setEllipsize(truncateAt);
        this.g.setGravity(1);
        this.g.setMaxLines(2);
        this.g.setTextColor(Color.parseColor("#90161823"));
        this.g.setTextSize(2, 14.0f);
        this.tf.addView(this.g);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.e = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = r.w(context, 36.0f);
        this.e.setLayoutParams(layoutParams9);
        jk.xj(this.xj, "tt_splash_card_btn_bg", this.e);
        this.e.setGravity(17);
        this.tf.addView(this.e);
        TextView textView5 = new TextView(context);
        this.yo = textView5;
        textView5.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.yo.setLayoutParams(layoutParams10);
        this.yo.setEllipsize(truncateAt);
        this.yo.setMaxLines(1);
        this.yo.setTextColor(Color.parseColor("#FFFFFF"));
        this.yo.setTextSize(2, 14.0f);
        this.yo.setTypeface(Typeface.defaultFromStyle(1));
        this.e.addView(this.yo);
        TextView textView6 = new TextView(context);
        this.v = textView6;
        textView6.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.v.setLayoutParams(layoutParams11);
        this.v.setEllipsize(truncateAt);
        this.v.setMaxLines(1);
        this.v.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.v.setTextSize(2, 11.0f);
        this.e.addView(this.v);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.jk = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = r.w(context, 36.0f);
        this.jk.setLayoutParams(layoutParams12);
        jk.xj(this.xj, "tt_splash_card_btn_bg", this.jk);
        this.jk.setVisibility(8);
        this.tf.addView(this.jk);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.jk.addView(relativeLayout7);
        View imageView3 = new ImageView(context);
        imageView3.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        jk.xj(this.xj, "tt_splash_card_shake", imageView3);
        relativeLayout7.addView(imageView3);
        TextView textView7 = new TextView(context);
        this.pz = textView7;
        textView7.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = r.w(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.pz.setLayoutParams(layoutParams15);
        this.pz.setEllipsize(truncateAt);
        this.pz.setTypeface(Typeface.defaultFromStyle(1));
        this.pz.setMaxLines(1);
        this.pz.setTextColor(Color.parseColor("#FFFFFF"));
        this.pz.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.pz);
        TextView textView8 = new TextView(context);
        this.qt = textView8;
        textView8.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(r.w(context, 8.0f));
        layoutParams16.bottomMargin = r.w(context, 8.0f);
        this.qt.setLayoutParams(layoutParams16);
        jk.xj(this.xj, "tt_ad_logo_new", this.qt);
        this.tf.addView(this.qt);
        ImageView imageView4 = new ImageView(context);
        this.zg = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = r.w(context, 48.0f);
        this.zg.setLayoutParams(layoutParams17);
        jk.xj(this.xj, "tt_splash_card_close", this.zg);
        relativeLayout.addView(this.zg);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.c = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.c);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable y() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.8
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.c.getWidth() == 0 || u.this.c.getHeight() == 0) {
                    return;
                }
                u.this.c.animate().scaleX(u.this.y.getWidth() / u.this.c.getWidth()).scaleY(u.this.y.getHeight() / u.this.c.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.8.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        u.this.c.setVisibility(8);
                        u.this.y.setVisibility(0);
                        u.this.d.setScaleX(0.0f);
                        u.this.d.setScaleY(0.0f);
                        u.this.d.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        u.this.f10338pl.setScaleX(0.0f);
                        u.this.f10338pl.setScaleY(0.0f);
                        u.this.f10338pl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        u.this.g.setScaleX(0.0f);
                        u.this.g.setScaleY(0.0f);
                        u.this.g.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        u.this.e.setScaleX(0.0f);
                        u.this.e.setScaleY(0.0f);
                        u.this.e.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        f.xj xjVar = u.this.u;
                        if (xjVar != null) {
                            xjVar.xj(bl.y(r5.w));
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public void hf() {
        if (bl.f(this.w)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, "splash_ad", "splash_card_close", jSONObject);
                f.xj xjVar = this.u;
                if (xjVar != null) {
                    xjVar.hf();
                }
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }

    public void kd() {
        f.xj xjVar = this.u;
        if (xjVar == null) {
            return;
        }
        if (this.kd == null) {
            this.kd = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(xjVar.getActivity(), this.w.xl(), "splash_ad", true);
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.u.getActivity(), this.w, (com.bytedance.sdk.openadsdk.core.dislike.ui.xj) this.kd);
        }
        this.kd.xj("splash_card");
        this.kd.xj();
    }

    public String u() {
        ws wsVar = this.w;
        return (wsVar == null || TextUtils.isEmpty(wsVar.kr())) ? "" : this.w.kr();
    }

    public String w() {
        ws wsVar = this.w;
        return wsVar == null ? "" : !TextUtils.isEmpty(wsVar.ci()) ? this.w.ci() : (this.w.vh() == null || TextUtils.isEmpty(this.w.vh().w())) ? "" : this.w.vh().w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public void xj(Context context, ViewGroup viewGroup, ws wsVar) {
        super.xj(context, viewGroup, wsVar);
        View xj = xj(this.xj);
        if (xj == null) {
            return;
        }
        this.hf.addView(xj);
        this.y.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), r.w(pz.getContext(), 18.0f));
            }
        });
        this.y.setClipToOutline(true);
        this.c.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), r.w(pz.getContext(), 28.0f));
            }
        });
        this.c.setClipToOutline(true);
        r.xj(this.qt, this.w);
        List<z> lx = this.w.lx();
        if (lx != null && lx.size() > 0) {
            com.bytedance.sdk.openadsdk.f.hf.xj(lx.get(0)).type(2).config(Bitmap.Config.ARGB_8888).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.3
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap result = zgVar.getResult();
                    if (result == null) {
                        return;
                    }
                    try {
                        if (result.getConfig() == Bitmap.Config.RGB_565) {
                            result = result.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap xj2 = com.bytedance.sdk.component.adexpress.u.hf.xj(u.this.xj, result, 10);
                    if (xj2 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(u.this.xj.getResources(), xj2);
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (u.this.f != null) {
                                u.this.f.setBackground(bitmapDrawable);
                            }
                            if (u.this.c != null) {
                                u.this.c.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(this.w.uf()).to(this.p);
        this.f10338pl.setText(w());
        this.g.setText(u());
        this.am.setVisibility(this.w.oz() ? 0 : 8);
        this.am.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.kd();
            }
        });
        this.yo.setText(bl.u(this.w));
        this.v.setText(bl.w(this.w));
        xj(this.w);
    }

    private void xj(ws wsVar) {
        if (wsVar == null || this.y == null || bl.kd(wsVar) != 1) {
            return;
        }
        r.xj((View) this.jk, 0);
        r.xj((View) this.e, 8);
        TextView textView = this.pz;
        if (textView != null) {
            textView.setText(bl.u(wsVar));
        }
        if (this.ht == null) {
            this.ht = new ht(pz.getContext(), 1, com.bytedance.sdk.openadsdk.core.f.zg().kd());
        }
        this.ht.hf(this.w.ky());
        this.ht.xj(this.w.ki());
        this.ht.hf(this.w.eg());
        this.ht.y(this.w.oa());
        this.ht.xj(wsVar.ee());
        this.ht.w(wsVar.ya());
        this.ht.kd(wsVar.le());
        this.ht.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.5
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i) {
                if (u.this.ra == null || !u.this.y.isShown() || i != 1 || u.this.ra == null) {
                    return;
                }
                if (u.this.ra instanceof com.bytedance.sdk.openadsdk.core.hf.xj) {
                    ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) ((com.bytedance.sdk.openadsdk.core.hf.xj) u.this.ra).xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj();
                }
                u.this.ra.onClick(u.this.y);
            }
        });
        ht htVar = this.ht;
        ws wsVar2 = this.w;
        htVar.xj(wsVar2 != null ? wsVar2.kd() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        if (xjVar == null) {
            return;
        }
        this.ra = xjVar;
        if (bl.c(this.w)) {
            this.y.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.f10338pl.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.tf.setOnClickListener(this);
        }
        this.e.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public void xj(com.bytedance.sdk.openadsdk.core.video.nativevideo.u uVar, f.xj xjVar) {
        super.xj(uVar, xjVar);
        this.hf.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.6
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.y.isAttachedToWindow()) {
                    u.this.y().run();
                } else {
                    u uVar2 = u.this;
                    uVar2.hf.postDelayed(uVar2.y(), 20L);
                }
            }
        });
        if (this.u != null) {
            this.zg.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.am.u.hf(u.this.w, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                    u.this.u.hf();
                }
            });
        }
        bl.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public String xj() {
        return "splash_card_show";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w
    public void xj(boolean z) {
        super.xj(z);
        f.xj xjVar = this.u;
        if (xjVar == null) {
            return;
        }
        if (z) {
            xjVar.xj(-1L);
        } else {
            xjVar.xj();
        }
        ht htVar = this.ht;
        if (htVar != null) {
            if (z) {
                ws wsVar = this.w;
                htVar.xj(wsVar != null ? wsVar.kd() : 0);
            } else {
                ws wsVar2 = this.w;
                htVar.hf(wsVar2 != null ? wsVar2.kd() : 0);
            }
        }
    }
}
