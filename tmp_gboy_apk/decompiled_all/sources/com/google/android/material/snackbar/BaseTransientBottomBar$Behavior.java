package com.google.android.material.snackbar;

import OLy1FW.AzWtSf;
import PVQ0dw.A2egSU;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final AzWtSf f11810B7CMnp;

    public BaseTransientBottomBar$Behavior() {
        AzWtSf azWtSf = new AzWtSf(5, (byte) 0);
        this.f11347B2KMhB = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f11348B3GDIM = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f11345AzWtSf = 0;
        this.f11810B7CMnp = azWtSf;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean AMqCpz(View view) {
        this.f11810B7CMnp.getClass();
        return view instanceof A2egSU;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f11810B7CMnp.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (A4TApA.A2egSU.f6AlLFFp == null) {
                    A4TApA.A2egSU.f6AlLFFp = new A4TApA.A2egSU();
                }
                synchronized (A4TApA.A2egSU.f6AlLFFp.f7AcNBzu) {
                }
            }
        } else if (coordinatorLayout.AYUAbz(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (A4TApA.A2egSU.f6AlLFFp == null) {
                A4TApA.A2egSU.f6AlLFFp = new A4TApA.A2egSU();
            }
            A4TApA.A2egSU.f6AlLFFp.A2egSU();
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
