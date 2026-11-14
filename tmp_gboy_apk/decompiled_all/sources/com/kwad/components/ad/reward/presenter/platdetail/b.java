package com.kwad.components.ad.reward.presenter.platdetail;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bm;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private View xA;
    private View xB;
    private View xC;
    private View xD;
    private Animator xG;
    private Animator xH;
    private Animator xI;
    private bm xL;
    private bm xM;
    private final long xx = 1600;
    private final long xy = 3000;
    private final long xz = PushUIConfig.dismissTime;
    private boolean xE = false;
    private boolean xF = false;
    private Animator xJ = null;
    private long xK = 3000;
    private Interpolator xN = A2egSU.A4TApA(0.0f, 0.0f, 0.58f, 1.0f);
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean xO = false;

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.xE = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 < b.this.xK || this.xO) {
                return;
            }
            this.xO = true;
            b.this.jf();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.xE = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.xE = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.xJ == null || b.this.xJ.isRunning()) {
                return;
            }
            b.this.xJ.start();
            b.a(b.this, (Animator) null);
        }
    };

    public static /* synthetic */ View b(b bVar, View view) {
        bVar.xB = null;
        return null;
    }

    private void jd() {
        this.xL = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.xM = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    private View je() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf() {
        this.xG = b(this.xA, 1600L);
        this.xH = a(this.xC, this.xD);
        this.xI = c(this.xA, 1600L);
        this.xG.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.r(b.this.xB);
                b.b(b.this, (View) null);
                if (b.this.xF) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.xH);
            }
        });
        this.xH.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xI);
                b.r(b.this.xC);
                b.r(b.this.xD);
                b.c(b.this, (View) null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.xI.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xI);
            }
        });
        a(this.xG);
    }

    private Animator q(View view) {
        if (this.xL == null || this.xM == null) {
            jd();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -(((this.xL.getHeight() + this.xM.getHeight()) / 2) + com.kwad.sdk.c.a.a.getScreenHeight(getContext())));
        float Tw = this.xM.Tw() / this.xL.Tw();
        float Tx = this.xM.Tx() / this.xL.Tx();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, Tw);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, Tx);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.xN);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.tq.rH.a(this.jE);
        FrameLayout T = this.tq.rH.lj().T(getContext());
        this.xA = T;
        if (T.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.xA, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.xL.getHeight();
        ViewGroup viewGroup = (FrameLayout) findViewById(R.id.ksad_root_container);
        View je = je();
        this.xB = je;
        viewGroup.addView(je, -1, -1);
        View a2 = a(R.drawable.ksad_image_player_sweep1, viewGroup);
        this.xC = a2;
        viewGroup.addView(a2, layoutParams);
        View a3 = a(R.drawable.ksad_image_player_sweep2, viewGroup);
        this.xD = a3;
        viewGroup.addView(a3, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        jd();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.xA = null;
        com.kwad.components.ad.reward.m.b lj = this.tq.rH.lj();
        if (lj != null) {
            lj.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xE = true;
        Animator animator = this.xH;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.xG;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.xI;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.tq.rH.b(this.jE);
    }

    public static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.xJ = null;
        return null;
    }

    public static /* synthetic */ View c(b bVar, View view) {
        bVar.xC = null;
        return null;
    }

    public static /* synthetic */ View d(b bVar, View view) {
        bVar.xD = null;
        return null;
    }

    private Animator c(View view, long j) {
        Animator b = b(view, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(PushUIConfig.dismissTime);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(b, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.xF = true;
        return true;
    }

    private View a(int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    private Animator b(View view, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.xB;
        if (view2 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.xN);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator animator) {
        if (!this.xE) {
            animator.start();
        } else {
            this.xJ = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator q = q(view);
        Animator q2 = q(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, q2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(q, animatorSet);
        return animatorSet2;
    }
}
