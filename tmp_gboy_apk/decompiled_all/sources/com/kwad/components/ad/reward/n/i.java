package com.kwad.components.ad.reward.n;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class i extends d implements View.OnClickListener {
    private KsPriceView CA;
    private TextView CB;
    private KsStyledTextButton CC;
    private TextView CD;
    private TextView CE;
    private View CF;
    private ImageView CG;
    private ViewGroup Cz;
    private TextView fv;
    private TextView kn;
    private KsLogoView mLogoView;
    private KSCornerImageView nQ;
    private com.kwad.components.ad.reward.g tq;
    private ViewGroup vZ;

    public static class a {
        private String CQ;
        private String CR;
        private String CS;
        private String CU;
        private String nv;
        private String rating;
        private String ta;
        private String tb;
        private String title;
        private String uW;

        private a() {
        }

        private void S(String str) {
            this.uW = str;
        }

        public static a ac(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(er);
            a aVar = new a();
            String name = cW.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.ay(er);
            }
            aVar.CS = com.kwad.sdk.core.response.b.a.aF(er);
            aVar.ta = cW.getIcon();
            aVar.tb = com.kwad.sdk.core.response.b.a.av(er);
            aVar.CQ = cW.getPrice();
            aVar.nv = cW.getOriginPrice();
            aVar.CU = cW.getVolume();
            aVar.rating = cW.getRating();
            if (!cW.isCouponListEmpty() && (firstCouponList = cW.getFirstCouponList()) != null) {
                aVar.CR = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.S(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String eC() {
            return this.nv;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hp() {
            return this.ta;
        }

        public final String hq() {
            return this.tb;
        }

        public final String ii() {
            return this.uW;
        }

        public final String lq() {
            return this.CQ;
        }

        public final String lr() {
            return this.CR;
        }

        public final String ls() {
            return this.CS;
        }

        public final String lt() {
            return this.CU;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.tq = gVar;
        this.mLogoView = ksLogoView;
        this.Cz = viewGroup;
        initView();
    }

    public static /* synthetic */ Animator a(i iVar, View view, float f) {
        return a(view, f);
    }

    private void initView() {
        this.vZ = (ViewGroup) this.Cz.findViewById(R.id.ksad_reward_jinniu_root);
        this.nQ = (KSCornerImageView) this.Cz.findViewById(R.id.ksad_reward_jinniu_icon);
        this.kn = (TextView) this.Cz.findViewById(R.id.ksad_reward_jinniu_title);
        this.fv = (TextView) this.Cz.findViewById(R.id.ksad_reward_jinniu_desc);
        this.CA = (KsPriceView) this.Cz.findViewById(R.id.ksad_reward_jinniu_price);
        this.CB = (TextView) this.Cz.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.CC = (KsStyledTextButton) this.Cz.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.CG = (ImageView) this.Cz.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.CF = this.Cz.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.CD = (TextView) this.Cz.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.CE = (TextView) this.Cz.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.vZ.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.CC;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.vZ.getContext();
        if (aq.SM()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.vZ.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.vZ.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hQ() {
        return this.vZ;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.vZ)) {
            this.tq.a(1, view.getContext(), TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, 2);
        } else if (view.equals(this.CC)) {
            this.tq.a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.ac(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.vZ;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator a2 = iVar.a(iVar.vZ, i.this.CC, i.this.mLogoView);
                    if (a2 != null) {
                        a2.start();
                    }
                }
            }, 3000L);
            this.vZ.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.CC == null || i.this.CC.getWidth() == 0) {
                        return;
                    }
                    float width = i.this.CC.getWidth();
                    i iVar = i.this;
                    final Animator a2 = i.a(iVar, iVar.CG, width);
                    if (a2 != null) {
                        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int CI = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.CI >= 3) {
                                    return;
                                }
                                a2.start();
                                this.CI++;
                            }
                        });
                        a2.start();
                    }
                }
            }, PushUIConfig.dismissTime);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.nQ, aVar.hp(), adTemplate, 4);
        TextView textView = this.kn;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.fv;
        if (textView2 != null) {
            textView2.setText(aVar.hq());
        }
        KsPriceView ksPriceView = this.CA;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.CA.getConfig().au(dimensionPixelSize).aw(dimensionPixelSize).av(this.CA.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.CA.d(aVar.lq(), aVar.eC(), true);
        }
        if (this.CB != null) {
            if (!TextUtils.isEmpty(aVar.lt())) {
                this.CB.setText(aVar.lt());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.CB.setText(aVar.getRating());
            } else {
                this.CB.setVisibility(8);
            }
        }
        if (this.CD != null && !TextUtils.isEmpty(aVar.lr())) {
            this.CD.setText(aVar.lr());
        }
        if (this.CC != null && !TextUtils.isEmpty(aVar.ls())) {
            this.CC.setText(aVar.ls());
        }
        int i = TextUtils.isEmpty(aVar.lr()) ? 8 : 0;
        View view = this.CF;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.CE == null || TextUtils.isEmpty(aVar.ii())) {
            return;
        }
        this.CE.setText(aVar.ii());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator A4TApA2 = A2egSU.A4TApA(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(A4TApA2);
        view.getContext();
        if (aq.SM() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = intValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i + i2;
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator A4TApA3 = A2egSU.A4TApA(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(A4TApA3);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    private static Animator a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(A2egSU.A4TApA(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
