package NuExGq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6133A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f6134A4TApA;

    public /* synthetic */ A2egSU(BottomAppBar bottomAppBar, int i) {
        this.f6133A2egSU = i;
        this.f6134A4TApA = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar bottomAppBar = this.f6134A4TApA;
        switch (this.f6133A2egSU) {
            case 1:
                int i = BottomAppBar.f11351EUIRHA;
                bottomAppBar.f11354DV2E8K = null;
                break;
            case 2:
                int i2 = BottomAppBar.f11351EUIRHA;
                bottomAppBar.getClass();
                bottomAppBar.f11364DyaChj = false;
                bottomAppBar.f11355DXnQ0V = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        BottomAppBar bottomAppBar = this.f6134A4TApA;
        switch (this.f6133A2egSU) {
            case 0:
                if (!bottomAppBar.f11364DyaChj) {
                    bottomAppBar.BPw6Q8();
                    break;
                }
                break;
            case 1:
                int i = BottomAppBar.f11351EUIRHA;
                break;
            default:
                int i2 = BottomAppBar.f11351EUIRHA;
                bottomAppBar.getClass();
                break;
        }
    }
}
