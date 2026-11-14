package De4eam;

import COJEAR.DG07BK;
import android.R;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final KCxDWD.A5SV6n f2410A2egSU = new KCxDWD.A5SV6n(14, this);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AZkASS.ARc23Z f2411A4TApA = new AZkASS.ARc23Z(12, this);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AMqCpz f2412A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2413ADYaiT;

    public AZkASS(ViewPager2 viewPager2) {
        this.f2413ADYaiT = viewPager2;
    }

    public final void A2egSU() {
        int itemCount;
        ViewPager2 viewPager2 = this.f2413ADYaiT;
        int i = R.id.accessibilityActionPageLeft;
        DG07BK.B25kr6(R.id.accessibilityActionPageLeft, viewPager2);
        DG07BK.AaHO0E(0, viewPager2);
        DG07BK.B25kr6(R.id.accessibilityActionPageRight, viewPager2);
        DG07BK.AaHO0E(0, viewPager2);
        DG07BK.B25kr6(R.id.accessibilityActionPageUp, viewPager2);
        DG07BK.AaHO0E(0, viewPager2);
        DG07BK.B25kr6(R.id.accessibilityActionPageDown, viewPager2);
        DG07BK.AaHO0E(0, viewPager2);
        if (viewPager2.getAdapter() == null || (itemCount = viewPager2.getAdapter().getItemCount()) == 0 || !viewPager2.f9602BV3sI0) {
            return;
        }
        int orientation = viewPager2.getOrientation();
        AZkASS.ARc23Z aRc23Z = this.f2411A4TApA;
        KCxDWD.A5SV6n a5SV6n = this.f2410A2egSU;
        if (orientation != 0) {
            if (viewPager2.f9588AzWtSf < itemCount - 1) {
                DG07BK.B2KMhB(viewPager2, new CQhlFr.A5SV6n(R.id.accessibilityActionPageDown, (String) null), null, a5SV6n);
            }
            if (viewPager2.f9588AzWtSf > 0) {
                DG07BK.B2KMhB(viewPager2, new CQhlFr.A5SV6n(R.id.accessibilityActionPageUp, (String) null), null, aRc23Z);
                return;
            }
            return;
        }
        boolean z = viewPager2.f9591B3GDIM.getLayoutDirection() == 1;
        int i2 = z ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
        if (z) {
            i = R.id.accessibilityActionPageRight;
        }
        if (viewPager2.f9588AzWtSf < itemCount - 1) {
            DG07BK.B2KMhB(viewPager2, new CQhlFr.A5SV6n(i2, (String) null), null, a5SV6n);
        }
        if (viewPager2.f9588AzWtSf > 0) {
            DG07BK.B2KMhB(viewPager2, new CQhlFr.A5SV6n(i, (String) null), null, aRc23Z);
        }
    }
}
