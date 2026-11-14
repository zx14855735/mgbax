package P8ccfD;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.search.SearchBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6984A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f6985A4TApA;

    public /* synthetic */ AlLFFp(AzWtSf azWtSf, int i) {
        this.f6984A2egSU = i;
        this.f6985A4TApA = azWtSf;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f6984A2egSU) {
            case 0:
                AzWtSf azWtSf = this.f6985A4TApA;
                if (!azWtSf.f6989A2egSU.AYUAbz()) {
                    azWtSf.f6989A2egSU.AZkASS();
                }
                azWtSf.f6989A2egSU.setTransitionState(AZkASS.f6978AzWtSf);
                break;
            case 1:
                AzWtSf azWtSf2 = this.f6985A4TApA;
                azWtSf2.f6991A5SV6n.setVisibility(8);
                if (!azWtSf2.f6989A2egSU.AYUAbz()) {
                    azWtSf2.f6989A2egSU.ARc23Z();
                }
                azWtSf2.f6989A2egSU.setTransitionState(AZkASS.f6976AlLFFp);
                break;
            case 2:
                AzWtSf azWtSf3 = this.f6985A4TApA;
                if (!azWtSf3.f6989A2egSU.AYUAbz()) {
                    azWtSf3.f6989A2egSU.AZkASS();
                }
                azWtSf3.f6989A2egSU.setTransitionState(AZkASS.f6978AzWtSf);
                break;
            default:
                AzWtSf azWtSf4 = this.f6985A4TApA;
                azWtSf4.f6991A5SV6n.setVisibility(8);
                if (!azWtSf4.f6989A2egSU.AYUAbz()) {
                    azWtSf4.f6989A2egSU.ARc23Z();
                }
                azWtSf4.f6989A2egSU.setTransitionState(AZkASS.f6976AlLFFp);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f6984A2egSU) {
            case 0:
                AzWtSf azWtSf = this.f6985A4TApA;
                azWtSf.f6991A5SV6n.setVisibility(0);
                SearchBar searchBar = azWtSf.f7003B25kr6;
                searchBar.Ddcejp.getClass();
                View centerView = searchBar.getCenterView();
                if (centerView != null) {
                    centerView.setAlpha(0.0f);
                    break;
                }
                break;
            case 1:
                this.f6985A4TApA.f6989A2egSU.setTransitionState(AZkASS.f6975AcNBzu);
                break;
            case 2:
                AzWtSf azWtSf2 = this.f6985A4TApA;
                azWtSf2.f6991A5SV6n.setVisibility(0);
                azWtSf2.f6989A2egSU.setTransitionState(AZkASS.f6977AmA8tU);
                break;
            default:
                this.f6985A4TApA.f6989A2egSU.setTransitionState(AZkASS.f6975AcNBzu);
                break;
        }
    }
}
