package com.google.android.material.appbar;

import CQhlFr.AYUAbz;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f11270ADYaiT;
    public final /* synthetic */ CoordinatorLayout AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f11271ARc23Z;

    public A4TApA(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f11271ARc23Z = baseBehavior;
        this.f11270ADYaiT = appBarLayout;
        this.AMqCpz = coordinatorLayout;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, AYUAbz aYUAbz) {
        AppBarLayout.BaseBehavior baseBehavior;
        View AmA8tU2;
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
        aYUAbz.AZkASS(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f11270ADYaiT;
        if (appBarLayout.getTotalScrollRange() == 0 || (AmA8tU2 = AppBarLayout.BaseBehavior.AmA8tU((baseBehavior = this.f11271ARc23Z), this.AMqCpz)) == null) {
            return;
        }
        int childCount = appBarLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((AMqCpz) appBarLayout.getChildAt(i).getLayoutParams()).f11277A2egSU != 0) {
                if (baseBehavior.ARc23Z() != (-appBarLayout.getTotalScrollRange())) {
                    aYUAbz.A4TApA(CQhlFr.A5SV6n.f1759AYUAbz);
                    aYUAbz.AlLFFp(true);
                }
                if (baseBehavior.ARc23Z() != 0) {
                    if (!AmA8tU2.canScrollVertically(-1)) {
                        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1760AZOQYO);
                        aYUAbz.AlLFFp(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            aYUAbz.A4TApA(CQhlFr.A5SV6n.f1760AZOQYO);
                            aYUAbz.AlLFFp(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        AppBarLayout appBarLayout = this.f11270ADYaiT;
        if (i == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i != 8192) {
            return super.ASJ6gh(view, i, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.f11271ARc23Z;
        if (baseBehavior.ARc23Z() != 0) {
            View AmA8tU2 = AppBarLayout.BaseBehavior.AmA8tU(baseBehavior, this.AMqCpz);
            if (!AmA8tU2.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i2 = -appBarLayout.getDownNestedPreScrollRange();
            if (i2 != 0) {
                CoordinatorLayout coordinatorLayout = this.AMqCpz;
                AppBarLayout appBarLayout2 = this.f11270ADYaiT;
                this.f11271ARc23Z.B2KMhB(coordinatorLayout, appBarLayout2, AmA8tU2, i2, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
