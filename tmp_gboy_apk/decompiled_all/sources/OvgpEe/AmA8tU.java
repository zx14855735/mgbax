package OvgpEe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6895A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f6896A4TApA;

    public /* synthetic */ AmA8tU(AzWtSf azWtSf, int i) {
        this.f6895A2egSU = i;
        this.f6896A4TApA = azWtSf;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6895A2egSU) {
            case 1:
                super.onAnimationEnd(animator);
                AzWtSf azWtSf = this.f6896A4TApA;
                azWtSf.A5SV6n();
                A5SV6n a5SV6n = azWtSf.f6907B9tovu;
                if (a5SV6n != null) {
                    a5SV6n.A2egSU((AaHO0E) azWtSf.f135AcNBzu);
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.f6895A2egSU) {
            case 0:
                super.onAnimationRepeat(animator);
                AzWtSf azWtSf = this.f6896A4TApA;
                azWtSf.f6904B3GDIM = (azWtSf.f6904B3GDIM + 1) % azWtSf.f6903B2KMhB.AMqCpz.length;
                azWtSf.f6905B4ZgIw = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}
