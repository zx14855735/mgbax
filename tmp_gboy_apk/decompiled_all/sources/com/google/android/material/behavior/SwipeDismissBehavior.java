package com.google.android.material.behavior;

import COJEAR.DG07BK;
import CqNSpT.ARc23Z;
import IQ76hF.AmA8tU;
import NrhEUx.A5SV6n;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ARc23Z f11342AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f11343AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f11344AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f11345AzWtSf = 2;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final float f11346B25kr6 = 0.5f;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f11347B2KMhB = 0.0f;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public float f11348B3GDIM = 0.5f;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final A5SV6n f11349B4ZgIw = new A5SV6n(this);

    public boolean AMqCpz(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z = this.f11343AlLFFp;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.AYUAbz(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f11343AlLFFp = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f11343AlLFFp = false;
        }
        if (z) {
            if (this.f11342AcNBzu == null) {
                this.f11342AcNBzu = new ARc23Z(coordinatorLayout.getContext(), coordinatorLayout, this.f11349B4ZgIw);
            }
            if (!this.f11344AmA8tU && this.f11342AcNBzu.B2KMhB(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            DG07BK.B25kr6(1048576, view);
            DG07BK.AaHO0E(0, view);
            if (AMqCpz(view)) {
                DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1763AcNBzu, null, new AmA8tU(20, this));
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f11342AcNBzu == null) {
            return false;
        }
        if (this.f11344AmA8tU && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f11342AcNBzu.AZkASS(motionEvent);
        return true;
    }
}
