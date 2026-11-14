package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements xj {
    private int am;
    private int c;
    private int d;
    private SmallSlideView e;
    private int f;
    private TextView g;
    private final xj.InterfaceC0143xj hf;
    private TranslateAnimation jk;
    private TextView kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private TextView f10301pl;
    private LinearLayout qt;
    private int tf;
    private LinearLayout v;
    private w w;
    private int y;
    private LinearLayout yo;
    private boolean zg;
    protected final AtomicBoolean xj = new AtomicBoolean(false);
    private boolean u = true;
    private boolean pz = false;
    private boolean ht = false;
    private boolean ra = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hf.this.hf.xj().xj(new RewardFullBaseLayout.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.1.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout.xj
                public void xj() {
                    u uVar = new u();
                    uVar.xj = false;
                    uVar.w = true;
                    uVar.u = true;
                    hf.this.hf.xj().xj();
                    hf.this.hf.getActivity().xj(3, uVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) hf.this.v.getLayoutParams();
            layoutParams.bottomMargin = -hf.this.v.getMeasuredHeight();
            hf.this.v.setLayoutParams(layoutParams);
            hf.this.v.setVisibility(0);
            hf.this.jk = new TranslateAnimation(0.0f, 0.0f, 0.0f, -hf.this.v.getMeasuredHeight());
            hf.this.jk.setDuration(300L);
            hf.this.jk.setRepeatCount(3);
            hf.this.jk.setRepeatMode(2);
            hf.this.jk.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (hf.this.pz) {
                        hf.this.v.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (hf.this.pz && hf.this.jk != null) {
                                    hf.this.hf.xj().getSceneFrameContainer().startAnimation(hf.this.jk);
                                }
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    hf.this.e.xj();
                }
            });
            if (hf.this.jk != null) {
                hf.this.hf.xj().getSceneFrameContainer().startAnimation(hf.this.jk);
            }
        }
    }

    public hf(xj.InterfaceC0143xj interfaceC0143xj) {
        this.hf = interfaceC0143xj;
    }

    private void tf() {
        String str;
        this.c = (j.d() / 1000) + this.hf.kd();
        this.yo = new LinearLayout(this.hf.getActivity());
        int w = r.w(this.hf.getActivity(), 10.0f);
        this.yo.setPadding(w, w, w, w);
        this.yo.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(this.hf.getActivity(), 12.0f));
        this.yo.setBackground(gradientDrawable);
        this.e = new SmallSlideView(this.hf.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r.w(this.hf.getActivity(), 80.0f), r.w(this.hf.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.yo.addView(this.e, layoutParams);
        TextView textView = new TextView(this.hf.getActivity());
        if (j.tf() > 0) {
            str = "上滑继续观看\n提前" + j.tf() + "秒领奖";
        } else {
            str = "上滑继续观看\n才能领奖哦";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.yo.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(r.w(this.hf.getActivity(), 160.0f), r.w(this.hf.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.hf.xj().addView(this.yo, layoutParams2);
        this.v = new LinearLayout(this.hf.getActivity());
        ImageView imageView = new ImageView(this.hf.getActivity());
        jk.xj((Context) this.hf.getActivity(), "tt_ic_back_light", imageView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = r.w(this.hf.getActivity(), 10.0f);
        layoutParams3.bottomMargin = r.w(this.hf.getActivity(), 10.0f);
        this.v.addView(imageView, layoutParams3);
        this.hf.xj().getSceneFrameContainer().setClipChildren(false);
        this.v.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.hf.xj().getSceneFrameContainer().addView(this.v, layoutParams4);
        this.pz = true;
        this.v.post(new AnonymousClass1());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void c() {
        int i;
        int i2;
        if (xj(3)) {
            return;
        }
        if (this.c > 0 && this.hf.kd() >= this.c) {
            this.c = 0;
            u uVar = new u();
            uVar.xj = false;
            uVar.w = false;
            uVar.u = true;
            this.hf.getActivity().xj(3, uVar);
        }
        if (this.f10301pl != null && (i2 = this.f) > 0) {
            this.f = Math.max(0, i2 - 1);
            TextView textView = this.f10301pl;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f);
            textView.setText(sb.toString());
            if (this.f == 0) {
                u uVar2 = new u();
                uVar2.xj = false;
                uVar2.w = false;
                uVar2.u = true;
                this.hf.getActivity().xj(1, uVar2);
                y();
            }
        }
        if (this.f10301pl != null) {
            if (j.g() == 1 && j.xj(this.hf.w()) != 1 && !this.zg && this.hf.d() && this.hf.f()) {
                u uVar3 = new u();
                uVar3.xj = false;
                uVar3.w = false;
                uVar3.u = true;
                this.hf.getActivity().xj(2, uVar3);
            }
            if (this.d > 0 || this.am > 0) {
                if (j.g() != 1) {
                    this.d = Math.max(0, this.d - 1);
                    TextView textView2 = this.f10301pl;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.d);
                    textView2.setText(sb2.toString());
                    if (this.d == 0) {
                        u uVar4 = new u();
                        uVar4.xj = false;
                        uVar4.w = false;
                        uVar4.u = true;
                        this.hf.getActivity().xj(2, uVar4);
                        y();
                    }
                } else if (this.hf.d()) {
                    int max = Math.max(0, this.am - 1);
                    this.am = max;
                    if (max == 0) {
                        y();
                    }
                } else {
                    this.d = Math.max(0, this.d - 1);
                    TextView textView3 = this.f10301pl;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.d);
                    textView3.setText(sb3.toString());
                    if (this.d == 0) {
                        u uVar5 = new u();
                        uVar5.xj = false;
                        uVar5.w = false;
                        uVar5.u = true;
                        this.hf.getActivity().xj(2, uVar5);
                        y();
                    }
                }
            }
        }
        int i3 = this.p;
        if (i3 > 0) {
            int max2 = Math.max(0, i3 - 1);
            this.p = max2;
            if (max2 == 0) {
                this.hf.xj(-1, this.tf);
                return;
            }
            return;
        }
        if (this.f10301pl == null || (i = this.tf) <= 0) {
            return;
        }
        this.tf = Math.max(0, i - 1);
        TextView textView4 = this.f10301pl;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.tf);
        textView4.setText(sb4.toString());
        if (this.tf == 0) {
            y();
            this.f10301pl = null;
            this.hf.p();
        }
    }

    public void d() {
        TextView textView = this.kd;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.kd.getParent()).removeView(this.kd);
        this.kd = null;
    }

    public void f() {
        int y = this.hf.y();
        String ASJ6gh2 = CtFAbx.ASJ6gh(y, "继续看", "秒可领取奖励");
        w wVar = this.w;
        if (wVar != null) {
            if (wVar.w() > 0) {
                if (y <= 0) {
                    ASJ6gh2 = "成功加速" + this.w.w() + "秒，奖励已下发";
                } else {
                    ASJ6gh2 = "加速成功！".concat(String.valueOf(ASJ6gh2));
                }
            } else if (y <= 0) {
                d();
                return;
            }
        }
        TextView textView = this.kd;
        if (textView != null) {
            textView.setText(ASJ6gh2);
        }
        int i = this.y;
        if (i <= 0) {
            d();
            return;
        }
        this.y = i - 1;
        TextView textView2 = this.kd;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.3
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.f();
                }
            }, 500L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public boolean kd() {
        return this.xj.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void y() {
        if (this.qt != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    hf.this.qt.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.qt.startAnimation(alphaAnimation);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public int hf() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.c();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public boolean u() {
        return this.w != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void w() {
        if (j.g() == 1 && this.ra && this.f10301pl != null && this.g != null && !TextUtils.isEmpty(j.p())) {
            this.f10301pl.setText("");
            this.g.setText(j.p());
            int pl2 = j.pl();
            this.am = pl2;
            if (pl2 == 0) {
                this.d = 0;
                y();
            }
        }
        if (this.pz && xj(3)) {
            SmallSlideView smallSlideView = this.e;
            if (smallSlideView != null) {
                smallSlideView.hf();
            }
            TranslateAnimation translateAnimation = this.jk;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.yo;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.hf.xj().removeView(this.yo);
            }
            LinearLayout linearLayout2 = this.v;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.hf.xj().getSceneFrameContainer().removeView(this.v);
            }
            this.hf.xj().xj();
            this.hf.xj(3);
            this.pz = false;
        }
    }

    private void hf(final int i, int i2, int i3) {
        if (i == 1) {
            this.f = i2;
        } else if (i == 2) {
            i2++;
            this.d = i2;
        } else if (i == -1) {
            this.tf = i2;
            if (i3 > 0) {
                this.p = i3;
                return;
            }
            this.p = 0;
        } else {
            i2 = 0;
        }
        LinearLayout linearLayout = this.qt;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.hf.getActivity());
            this.qt = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.qt.setOrientation(0);
            this.qt.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.hf.getActivity().getWindow().getDecorView()).addView(this.qt, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.hf.getActivity());
        this.f10301pl = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.f10301pl.setText(String.valueOf(i2));
        TextView textView2 = this.f10301pl;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView2.setTypeface(typeface);
        this.f10301pl.setTextSize(2, 14.0f);
        this.qt.addView(this.f10301pl);
        TextView textView3 = new TextView(this.hf.getActivity());
        this.g = textView3;
        textView3.setTextColor(-1);
        this.g.setTypeface(typeface);
        this.g.setSingleLine();
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setText(j.y(this.hf.w()));
        this.g.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(r.w(this.hf.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.qt.addView(this.g, layoutParams2);
        TextView textView4 = new TextView(this.hf.getActivity());
        textView4.setText("取消");
        textView4.setTypeface(typeface);
        textView4.setTextSize(2, 13.0f);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                hf.this.zg = true;
                int i5 = i;
                if (i5 == 1) {
                    hf.this.f = 0;
                } else if (i5 == 2) {
                    hf.this.d = 0;
                    hf.this.am = 0;
                } else if (i5 == -1) {
                    hf.this.tf = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PointParamKey.TYPE, i4);
                } catch (JSONException unused) {
                }
                am.xj().xj(hf.this.hf.w(), "stats_switch_tip_cancel", jSONObject);
                hf.this.y();
                hf.this.hf.tf();
            }
        });
        this.qt.addView(textView4);
        this.qt.setPadding(r.w(this.hf.getActivity(), 20.0f), r.w(this.hf.getActivity(), 16.0f), r.w(this.hf.getActivity(), 20.0f), r.yo(this.hf.getActivity()));
        this.qt.setClickable(false);
        if (i == 1) {
            this.ht = true;
        } else if (i == 2) {
            this.ra = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, r.w(this.hf.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.qt.startAnimation(translateAnimation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r2.remove(r0);
        r3.wo(r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w r6, int r7, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u r8) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r0 = r5.hf
            com.bytedance.sdk.openadsdk.core.ra.ws r0 = r0.w()
            r1 = 0
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L37
            java.lang.String r0 = r0.mi()     // Catch: org.json.JSONException -> L37
            r2.<init>(r0)     // Catch: org.json.JSONException -> L37
            r0 = 0
        L11:
            int r3 = r2.length()     // Catch: org.json.JSONException -> L37
            if (r0 >= r3) goto L3b
            org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch: org.json.JSONException -> L37
            com.bytedance.sdk.openadsdk.core.ra.ws r3 = com.bytedance.sdk.openadsdk.core.xj.xj(r3)     // Catch: org.json.JSONException -> L37
            boolean r4 = r5.xj(r3, r7)     // Catch: org.json.JSONException -> L37
            if (r4 == 0) goto L34
            r2.remove(r0)     // Catch: org.json.JSONException -> L31
            java.lang.String r0 = r2.toString()     // Catch: org.json.JSONException -> L31
            r3.wo(r0)     // Catch: org.json.JSONException -> L31
            r1 = r3
            goto L3b
        L31:
            r0 = move-exception
            r1 = r3
            goto L38
        L34:
            int r0 = r0 + 1
            goto L11
        L37:
            r0 = move-exception
        L38:
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L3b:
            if (r1 == 0) goto Lc3
            r0 = 1
            if (r7 != r0) goto L53
            if (r8 == 0) goto L53
            boolean r2 = r8.xj
            if (r2 == 0) goto L53
            boolean r6 = r5.ht
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r6 = r5.hf
            int r8 = r8.hf
            r6.xj(r7, r8)
            goto Lc3
        L53:
            r2 = 2
            if (r7 != r2) goto L68
            if (r8 == 0) goto L68
            boolean r2 = r8.xj
            if (r2 == 0) goto L68
            boolean r6 = r5.ra
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r6 = r5.hf
            int r8 = r8.hf
            r6.xj(r7, r8)
            goto Lc3
        L68:
            r2 = 3
            if (r7 != r2) goto L7d
            if (r8 == 0) goto L7d
            boolean r2 = r8.xj
            if (r2 == 0) goto L7d
            boolean r6 = r5.pz
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r6 = r5.hf
            int r8 = r8.hf
            r6.xj(r7, r8)
            goto Lc3
        L7d:
            com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj r7 = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj()
            java.lang.String r8 = ""
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.a.wo.xj(r1, r8)
            com.bytedance.sdk.openadsdk.zg.w.w.hf r7 = r7.xj(r8)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r8 = r5.hf
            boolean r8 = r8.hf()
            if (r8 == 0) goto La9
            com.bytedance.sdk.openadsdk.core.component.reward.w r8 = new com.bytedance.sdk.openadsdk.core.component.reward.w
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.pz.getContext()
            r8.<init>(r2, r1, r7)
            r8.xj(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r6 = r5.hf
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.xj(r6)
            goto Lbe
        La9:
            com.bytedance.sdk.openadsdk.core.component.reward.hf r8 = new com.bytedance.sdk.openadsdk.core.component.reward.hf
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.pz.getContext()
            r8.<init>(r2, r1, r7)
            r8.xj(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj$xj r6 = r5.hf
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.xj(r6)
        Lbe:
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.xj
            r6.set(r0)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf.xj(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w, int, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u):void");
    }

    private boolean xj(ws wsVar, int i) {
        if (i != 1) {
            return i != 2 ? i == 3 && j.hf(wsVar, true) : j.xj(wsVar, true);
        }
        return j.xj(this.hf.hf(), wsVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void xj(w wVar) {
        this.w = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public int xj() {
        w wVar = this.w;
        if (wVar != null) {
            return Math.max(0, wVar.hf() - this.w.w());
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void xj(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public int xj(int i, boolean z) {
        if (!this.u || xj(i)) {
            return 0;
        }
        if (i == 1) {
            if (j.xj(this.hf.w()) != 1) {
                return 0;
            }
            if (!z) {
                if (!j.xj(this.hf.hf(), u() ? this.hf.u() : ws.hf(this.hf.w()), this.hf.kd())) {
                    return 0;
                }
            }
        } else if (i == 2) {
            if (j.hf(this.hf.w()) != 1) {
                return 0;
            }
            if (!z && this.hf.c() && j.g() == 0) {
                return 0;
            }
            if (j.g() == 1) {
                if (this.zg) {
                    return 0;
                }
                if (this.hf.d()) {
                    if (!this.hf.f()) {
                        return 0;
                    }
                }
            }
            if (!z && !j.xj(this.hf.kd(), this.hf.w(), this.hf.hf())) {
                return 0;
            }
        } else {
            if (i != 3 || j.w(this.hf.w()) != 1 || this.hf.f()) {
                return 0;
            }
            if (!z && !j.xj(this.hf.kd(), this.hf.w())) {
                return 0;
            }
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void hf(boolean z) {
        this.p = 0;
        if (z) {
            this.tf = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public boolean xj(int i) {
        if (this.hf.d()) {
            if (aq.x(this.hf.w()) == com.bytedance.sdk.openadsdk.core.f.u.c) {
                return true;
            }
            if (aq.x(this.hf.w()) == com.bytedance.sdk.openadsdk.core.f.u.f && !this.hf.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void xj(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.kd == null) {
            this.kd = r.e(this.hf.getActivity());
        }
        if (this.kd.getParent() != null) {
            ((ViewGroup) this.kd.getParent()).removeView(this.kd);
        }
        this.y = j.f() * 2;
        frameLayout.addView(this.kd);
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj
    public void xj(int i, int i2, int i3) {
        if (i == -1 || i == 1 || i == 2) {
            hf(i, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            tf();
        }
    }
}
