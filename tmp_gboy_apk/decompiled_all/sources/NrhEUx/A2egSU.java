package NrhEUx;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6126A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ View f6127A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.A2egSU f6128A5SV6n;

    public /* synthetic */ A2egSU(CoordinatorLayout.A2egSU a2egSU, View view, int i) {
        this.f6126A2egSU = i;
        this.f6128A5SV6n = a2egSU;
        this.f6127A4TApA = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        switch (this.f6126A2egSU) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f6128A5SV6n;
                if (!z) {
                    hideBottomViewOnScrollBehavior.getClass();
                    break;
                } else if (hideBottomViewOnScrollBehavior.f11327B9tovu == 1) {
                    hideBottomViewOnScrollBehavior.AMqCpz(this.f6127A4TApA);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f6128A5SV6n;
                if (hideViewOnScrollBehavior.f11333AzWtSf && z && hideViewOnScrollBehavior.f11340BChYOn == 1) {
                    hideViewOnScrollBehavior.ARc23Z(this.f6127A4TApA);
                    break;
                }
                break;
        }
    }
}
