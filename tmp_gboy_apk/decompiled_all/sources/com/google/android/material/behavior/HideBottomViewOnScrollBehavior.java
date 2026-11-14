package com.google.android.material.behavior;

import ADYaiT.CtFAbx;
import AZkASS.ADYaiT;
import AaHO0E.A5SV6n;
import BPw6Q8.ASJ6gh;
import NrhEUx.A2egSU;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.A2egSU {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11319AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11320AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public TimeInterpolator f11321AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TimeInterpolator f11322B25kr6;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AccessibilityManager f11324B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public A2egSU f11325B4ZgIw;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ViewPropertyAnimator f11329BI9f7h;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final LinkedHashSet f11318AcNBzu = new LinkedHashSet();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f11323B2KMhB = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f11326B7CMnp = true;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f11327B9tovu = 2;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f11328BChYOn = 0;

    public HideBottomViewOnScrollBehavior() {
    }

    public final void AMqCpz(View view) {
        if (this.f11327B9tovu == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11329BI9f7h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f11327B9tovu = 2;
        Iterator it = this.f11318AcNBzu.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        this.f11329BI9f7h = view.animate().translationY(0).setInterpolator(this.f11321AzWtSf).setDuration(this.f11319AlLFFp).setListener(new A5SV6n(5, this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f11323B2KMhB = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f11319AlLFFp = com.bumptech.glide.A5SV6n.D07BeM(view.getContext(), 2130969617, 225);
        this.f11320AmA8tU = com.bumptech.glide.A5SV6n.D07BeM(view.getContext(), 2130969623, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED);
        this.f11321AzWtSf = com.bumptech.glide.A5SV6n.D6DOie(view.getContext(), 2130969633, NdEzCJ.A2egSU.f6039ADYaiT);
        this.f11322B25kr6 = com.bumptech.glide.A5SV6n.D6DOie(view.getContext(), 2130969633, NdEzCJ.A2egSU.f6038A5SV6n);
        if (this.f11324B3GDIM == null) {
            this.f11324B3GDIM = (AccessibilityManager) ASJ6gh.ADYaiT(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f11324B3GDIM;
        if (accessibilityManager == null || this.f11325B4ZgIw != null) {
            return false;
        }
        A2egSU a2egSU = new A2egSU(this, view, 0);
        this.f11325B4ZgIw = a2egSU;
        accessibilityManager.addTouchExplorationStateChangeListener(a2egSU);
        view.addOnAttachStateChangeListener(new ADYaiT(5, this));
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i2 <= 0) {
            if (i2 < 0) {
                AMqCpz(view);
                return;
            }
            return;
        }
        if (this.f11327B9tovu == 1) {
            return;
        }
        if (this.f11326B7CMnp && (accessibilityManager = this.f11324B3GDIM) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11329BI9f7h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f11327B9tovu = 1;
        Iterator it = this.f11318AcNBzu.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        this.f11329BI9f7h = view.animate().translationY(this.f11323B2KMhB + this.f11328BChYOn).setInterpolator(this.f11322B25kr6).setDuration(this.f11320AmA8tU).setListener(new A5SV6n(5, this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
