package De4eam;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2407A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f2408A4TApA;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f2407A2egSU = i;
        this.f2408A4TApA = obj;
    }

    @Override // De4eam.AYUAbz, androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onChanged() {
        switch (this.f2407A2egSU) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.f2408A4TApA;
                viewPager2.f9589B25kr6 = true;
                viewPager2.f9596BI9f7h.f9582AcNBzu = true;
                break;
            default:
                ((AZkASS) this.f2408A4TApA).A2egSU();
                break;
        }
    }
}
