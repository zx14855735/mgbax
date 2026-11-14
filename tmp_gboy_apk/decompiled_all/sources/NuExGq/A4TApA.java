package NuExGq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f6135A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f6136A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f6137A5SV6n;

    public A4TApA(BottomAppBar bottomAppBar, ActionMenuView actionMenuView) {
        this.f6137A5SV6n = bottomAppBar;
        this.f6136A4TApA = actionMenuView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f6135A2egSU = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f6135A2egSU) {
            return;
        }
        BottomAppBar bottomAppBar = this.f6137A5SV6n;
        bottomAppBar.getClass();
        bottomAppBar.BmvVmW(this.f6136A4TApA, 0, false);
    }
}
