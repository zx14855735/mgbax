package Nm94Z2;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AMqCpz extends CoordinatorLayout.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ARc23Z f6065AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f6066AlLFFp = 0;

    public AMqCpz() {
    }

    public final int AMqCpz() {
        ARc23Z aRc23Z = this.f6065AcNBzu;
        if (aRc23Z != null) {
            return aRc23Z.f6070ADYaiT;
        }
        return 0;
    }

    public int ARc23Z() {
        return AMqCpz();
    }

    public void ASJ6gh(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.AZkASS(i, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        ASJ6gh(coordinatorLayout, view, i);
        if (this.f6065AcNBzu == null) {
            this.f6065AcNBzu = new ARc23Z(view);
        }
        ARc23Z aRc23Z = this.f6065AcNBzu;
        View view2 = aRc23Z.f6067A2egSU;
        aRc23Z.f6068A4TApA = view2.getTop();
        aRc23Z.f6069A5SV6n = view2.getLeft();
        this.f6065AcNBzu.A2egSU();
        int i2 = this.f6066AlLFFp;
        if (i2 == 0) {
            return true;
        }
        ARc23Z aRc23Z2 = this.f6065AcNBzu;
        if (aRc23Z2.f6070ADYaiT != i2) {
            aRc23Z2.f6070ADYaiT = i2;
            aRc23Z2.A2egSU();
        }
        this.f6066AlLFFp = 0;
        return true;
    }

    public AMqCpz(int i) {
    }
}
