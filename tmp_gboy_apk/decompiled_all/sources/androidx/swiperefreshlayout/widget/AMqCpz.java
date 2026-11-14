package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Animation.AnimationListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f9519A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9520A4TApA;

    public /* synthetic */ AMqCpz(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f9519A2egSU = i;
        this.f9520A4TApA = swipeRefreshLayout;
    }

    private final void A2egSU(Animation animation) {
    }

    private final void A4TApA(Animation animation) {
    }

    private final void A5SV6n(Animation animation) {
    }

    private final void ADYaiT(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        AZOQYO azoqyo;
        switch (this.f9519A2egSU) {
            case 0:
                SwipeRefreshLayout swipeRefreshLayout = this.f9520A4TApA;
                if (!swipeRefreshLayout.mRefreshing) {
                    swipeRefreshLayout.reset();
                    break;
                } else {
                    swipeRefreshLayout.mProgress.setAlpha(255);
                    swipeRefreshLayout.mProgress.start();
                    if (swipeRefreshLayout.mNotify && (azoqyo = swipeRefreshLayout.mListener) != null) {
                        azoqyo.onRefresh();
                    }
                    swipeRefreshLayout.mCurrentTargetOffsetTop = swipeRefreshLayout.mCircleView.getTop();
                    break;
                }
                break;
            default:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f9520A4TApA;
                if (!swipeRefreshLayout2.mScale) {
                    swipeRefreshLayout2.startScaleDownAnimation(null);
                    break;
                }
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f9519A2egSU;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f9519A2egSU;
    }
}
