package com.kwad.components.ad.reward.b;

import ADYaiT.CtFAbx;
import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends d implements View.OnClickListener {
    private TextView fv;
    private TextView kn;
    private final ViewGroup mRootContainer;
    private int[] tN;
    private View tO;
    private ImageView tP;
    private TextView tQ;
    private Button tR;
    private b tS;

    /* renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    public class AnonymousClass1 extends bg {
        final /* synthetic */ r tT;
        final /* synthetic */ long tU;

        public AnonymousClass1(r rVar, long j) {
            this.tT = rVar;
            this.tU = j;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            a aVar = a.this;
            final Animator a2 = a.a(aVar, aVar.tO);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a2.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.tT.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.tP, AnonymousClass1.this.tU).start();
                    bw.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hR();
                        }
                    }, null, AnonymousClass1.this.tU);
                }
            });
            a2.start();
        }
    }

    public interface b {
        void hU();

        void hV();
    }

    public a(Context context, ViewGroup viewGroup, int[] iArr) {
        this.tN = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.mRootContainer = viewGroup2;
        e(viewGroup2);
    }

    public static /* synthetic */ Animator a(a aVar, View view) {
        return o(view);
    }

    private void e(ViewGroup viewGroup) {
        this.tO = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.tP = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.kn = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.tQ = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.fv = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.tR = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR() {
        final Animator p = p(this.tO);
        p.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                p.removeListener(this);
                if (a.this.tS != null) {
                    a.this.tS.hV();
                }
            }
        });
        p.start();
    }

    private static Animator o(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator p(View view) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        int[] K;
        Interpolator A4TApA2 = A2egSU.A4TApA(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(A4TApA2);
        ofFloat2.setInterpolator(A4TApA2);
        int[] iArr = this.tN;
        if (iArr == null || iArr.length < 2 || (K = com.kwad.sdk.c.a.a.K(view)) == null) {
            objectAnimator = null;
            objectAnimator2 = null;
        } else {
            Interpolator A4TApA3 = A2egSU.A4TApA(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator = ObjectAnimator.ofFloat(view, "translationX", this.tN[0] - K[0]);
            objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", this.tN[1] - K[1]);
            objectAnimator.setInterpolator(A4TApA3);
            objectAnimator2.setInterpolator(A4TApA3);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator, objectAnimator2);
            return animatorSet2;
        }
        animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        return animatorSet2;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hQ() {
        return this.mRootContainer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.tR) || (bVar = this.tS) == null) {
            return;
        }
        bVar.hU();
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    public final void a(b bVar) {
        this.tS = bVar;
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    public static class C0254a {
        private CharSequence title;
        private CharSequence ua;
        private CharSequence ub;
        private CharSequence uc;

        private C0254a(CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.ua = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.ub = "";
            } else {
                this.ub = CtFAbx.BI9f7h("满", couponInfo.displayBase, "可用");
            }
            this.uc = couponInfo.displayActionWords;
        }

        private static C0254a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0254a(couponInfo);
        }

        public final CharSequence Q(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.ua));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence hS() {
            return this.ub;
        }

        public final CharSequence hT() {
            return this.uc;
        }

        public static C0254a Q(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(e.er(adTemplate));
            if (cW == null || (list = cW.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(cW.couponList.get(0));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0254a.Q(rVar.getAdTemplate()));
        this.mRootContainer.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.hJ()));
    }

    private void a(C0254a c0254a) {
        if (c0254a == null) {
            return;
        }
        TextView textView = this.kn;
        if (textView != null) {
            textView.setText(c0254a.getTitle());
        }
        TextView textView2 = this.tQ;
        if (textView2 != null) {
            textView2.setText(c0254a.Q(this.mRootContainer.getContext()));
        }
        TextView textView3 = this.fv;
        if (textView3 != null) {
            textView3.setText(c0254a.hS());
        }
        Button button = this.tR;
        if (button != null) {
            button.setText(c0254a.hT());
        }
    }

    private static Animator a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }
}
