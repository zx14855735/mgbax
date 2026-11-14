package OpB85q;

import ADYaiT.DUi7mC;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.game.boy.viewUi.navigationView.ExpandableNavigationView;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM extends DrawerLayout.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ExpandableNavigationView f6796A2egSU;

    public B3GDIM(ExpandableNavigationView expandableNavigationView) {
        this.f6796A2egSU = expandableNavigationView;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.A2egSU, CrfGsy.A5SV6n
    public final void A2egSU(View view) {
        ExpandableNavigationView expandableNavigationView = this.f6796A2egSU;
        if (view == expandableNavigationView) {
            DUi7mC dUi7mC = expandableNavigationView.f6815CASmeH;
            Objects.requireNonNull(dUi7mC);
            view.post(new CtFAbx.A2egSU(7, dUi7mC));
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.A2egSU, CrfGsy.A5SV6n
    public final void A4TApA(View view) {
        ExpandableNavigationView expandableNavigationView = this.f6796A2egSU;
        if (view == expandableNavigationView) {
            expandableNavigationView.f6815CASmeH.BIYEnU();
            if (!expandableNavigationView.f6812BniPrB || expandableNavigationView.f6811BmvVmW == 0) {
                return;
            }
            expandableNavigationView.f6811BmvVmW = 0;
            expandableNavigationView.AZOQYO(expandableNavigationView.getWidth(), expandableNavigationView.getHeight());
        }
    }
}
