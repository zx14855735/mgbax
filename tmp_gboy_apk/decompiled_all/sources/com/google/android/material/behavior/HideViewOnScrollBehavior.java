package com.google.android.material.behavior;

import ADYaiT.CtFAbx;
import AZkASS.ADYaiT;
import BPw6Q8.ASJ6gh;
import NrhEUx.A2egSU;
import NrhEUx.A4TApA;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.A5SV6n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A5SV6n f11330AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AccessibilityManager f11331AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A2egSU f11332AmA8tU;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f11335B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f11336B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public TimeInterpolator f11337B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TimeInterpolator f11338B7CMnp;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ViewPropertyAnimator f11341BI9f7h;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final boolean f11333AzWtSf = true;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final LinkedHashSet f11334B25kr6 = new LinkedHashSet();

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f11339B9tovu = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f11340BChYOn = 2;

    public HideViewOnScrollBehavior() {
    }

    public final void AMqCpz(int i) {
        A5SV6n a5SV6n = this.f11330AcNBzu;
        if (a5SV6n == null || a5SV6n.CASmeH() != i) {
            if (i == 0) {
                this.f11330AcNBzu = new A4TApA(2);
            } else if (i == 1) {
                this.f11330AcNBzu = new A4TApA(0);
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException(CtFAbx.ASJ6gh(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f11330AcNBzu = new A4TApA(1);
            }
        }
    }

    public final void ARc23Z(View view) {
        if (this.f11340BChYOn == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11341BI9f7h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f11340BChYOn = 2;
        Iterator it = this.f11334B25kr6.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        this.f11330AcNBzu.getClass();
        this.f11341BI9f7h = this.f11330AcNBzu.CNPG0E(0, view).setInterpolator(this.f11337B4ZgIw).setDuration(this.f11335B2KMhB).setListener(new AaHO0E.A5SV6n(6, this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (this.f11331AlLFFp == null) {
            this.f11331AlLFFp = (AccessibilityManager) ASJ6gh.ADYaiT(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f11331AlLFFp;
        if (accessibilityManager != null && this.f11332AmA8tU == null) {
            A2egSU a2egSU = new A2egSU(this, view, 1);
            this.f11332AmA8tU = a2egSU;
            accessibilityManager.addTouchExplorationStateChangeListener(a2egSU);
            view.addOnAttachStateChangeListener(new ADYaiT(6, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i2 = ((androidx.coordinatorlayout.widget.A5SV6n) view.getLayoutParams()).f8429A5SV6n;
        if (i2 == 80 || i2 == 81) {
            AMqCpz(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i2, i);
            AMqCpz((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f11339B9tovu = this.f11330AcNBzu.C4FrIb(view, marginLayoutParams);
        this.f11335B2KMhB = A5SV6n.D07BeM(view.getContext(), 2130969617, 225);
        this.f11336B3GDIM = A5SV6n.D07BeM(view.getContext(), 2130969623, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED);
        this.f11337B4ZgIw = A5SV6n.D6DOie(view.getContext(), 2130969633, NdEzCJ.A2egSU.f6039ADYaiT);
        this.f11338B7CMnp = A5SV6n.D6DOie(view.getContext(), 2130969633, NdEzCJ.A2egSU.f6038A5SV6n);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i2 <= 0) {
            if (i2 < 0) {
                ARc23Z(view);
                return;
            }
            return;
        }
        if (this.f11340BChYOn == 1) {
            return;
        }
        if (this.f11333AzWtSf && (accessibilityManager = this.f11331AlLFFp) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11341BI9f7h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f11340BChYOn = 1;
        Iterator it = this.f11334B25kr6.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        this.f11341BI9f7h = this.f11330AcNBzu.CNPG0E(this.f11339B9tovu, view).setInterpolator(this.f11338B7CMnp).setDuration(this.f11336B3GDIM).setListener(new AaHO0E.A5SV6n(6, this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
