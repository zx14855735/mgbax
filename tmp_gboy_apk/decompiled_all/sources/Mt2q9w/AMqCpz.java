package Mt2q9w;

import AZkASS.AcNBzu;
import AZkASS.AmA8tU;
import OpB85q.B4ZgIw;
import android.view.MenuItem;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.viewUi.navigationView.ExpandableNavigationView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements A5SV6n, AcNBzu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ExpandableNavigationView f5534AcNBzu;

    public /* synthetic */ AMqCpz(ExpandableNavigationView expandableNavigationView) {
        this.f5534AcNBzu = expandableNavigationView;
    }

    @Override // Mt2q9w.A5SV6n
    public void AMqCpz(ASJ6gh aSJ6gh) {
    }

    @Override // Mt2q9w.A5SV6n
    public void ASJ6gh(AYUAbz aYUAbz) {
        MenuItem AaHO0E2;
        ExpandableNavigationView expandableNavigationView = this.f5534AcNBzu;
        if (expandableNavigationView.f11200CkXcdM == null || (AaHO0E2 = ExpandableNavigationView.AaHO0E(expandableNavigationView, aYUAbz.f5541A4TApA)) == null) {
            return;
        }
        ((EmulatorActivity) expandableNavigationView.f11200CkXcdM).CQhlFr(AaHO0E2);
    }

    @Override // AZkASS.AcNBzu
    public boolean AZkASS(AmA8tU amA8tU, MenuItem menuItem) {
        B4ZgIw b4ZgIw = this.f5534AcNBzu.f6802B9tovu;
        if (b4ZgIw == null) {
            return false;
        }
        ((EmulatorActivity) b4ZgIw).CQhlFr(menuItem);
        return true;
    }

    @Override // AZkASS.AcNBzu
    public void AcNBzu(AmA8tU amA8tU) {
    }
}
