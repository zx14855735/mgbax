package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long vY = 300;
    private ImageView ig;
    private ViewGroup vZ;
    private TextView wa;
    private boolean wb;
    private float wc;
    private WeakReference<View> wd;
    private r we;
    private boolean wf = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cW() {
            o.this.hide();
        }
    };

    public o(r rVar) {
        this.we = rVar;
    }

    private synchronized void iJ() {
        if (this.wf) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.tq.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dx(MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT).aw(this.tq.rH.getPlayDuration()));
        this.wf = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator iK() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.vZ, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.ig.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.wa, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(vY);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.vZ;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.ig = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.wa = (TextView) this.vZ.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.vZ.setOnClickListener(this);
    }

    public final void J(boolean z) {
        ViewGroup viewGroup = this.vZ;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        iJ();
        WeakReference<View> weakReference = this.wd;
        if (weakReference != null && weakReference.get() != null) {
            a(this.wd.get().getLayoutParams());
        }
        this.vZ.setVisibility(0);
        if (z) {
            this.vZ.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.iK().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.vZ == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.vZ = (ViewGroup) viewStub.inflate();
            } else {
                this.vZ = (ViewGroup) findViewById(R.id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.tq.gP()) {
            a(new ViewGroup.LayoutParams(-1, this.vZ.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.tq.rJ.a(this);
        }
        this.tq.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.vZ;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.vZ;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.gh().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.adlog.c.e(this.tq.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().dx(MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT).aw(this.tq.rH.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wc = com.kwad.components.ad.reward.a.b.hG();
        this.wb = !com.kwad.components.ad.reward.a.b.hI() && com.kwad.components.ad.reward.a.b.hH();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tq.c(this.mPlayEndPageListener);
        this.tq.rJ.b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.wd = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        StringBuilder sb = new StringBuilder("onActionBarShown: type: ");
        sb.append(showActionBarResult);
        sb.append(", params.height: ");
        sb.append(layoutParams.height);
        sb.append(", params.width: ");
        A2egSU.BChYOn(sb, layoutParams.width, "RewardPlayablePreTips");
        a(layoutParams);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.vZ.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.vZ.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.vZ.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.wd;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i = marginLayoutParams2.height;
                    if (i <= 0 && view != null) {
                        i = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.vZ.setLayoutParams(marginLayoutParams);
        }
    }
}
