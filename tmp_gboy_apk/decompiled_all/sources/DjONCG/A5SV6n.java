package DjONCG;

import com.alliance.ssp.ad.activity.NMRewardVideoActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2424AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ NMRewardVideoActivity f2425AlLFFp;

    public /* synthetic */ A5SV6n(NMRewardVideoActivity nMRewardVideoActivity, int i) {
        this.f2424AcNBzu = i;
        this.f2425AlLFFp = nMRewardVideoActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2424AcNBzu) {
            case 0:
                NMRewardVideoActivity nMRewardVideoActivity = this.f2425AlLFFp;
                nMRewardVideoActivity.runOnUiThread(new C4FrIb.A2egSU(this, NMRewardVideoActivity.A4TApA(nMRewardVideoActivity.f9651D07BeM.getVideourl()), 3, false));
                break;
            case 1:
                NMRewardVideoActivity nMRewardVideoActivity2 = this.f2425AlLFFp;
                nMRewardVideoActivity2.ARc23Z(nMRewardVideoActivity2.f9615AlLFFp);
                break;
            default:
                NMRewardVideoActivity nMRewardVideoActivity3 = this.f2425AlLFFp;
                nMRewardVideoActivity3.ARc23Z(nMRewardVideoActivity3.f9616AmA8tU);
                break;
        }
    }
}
