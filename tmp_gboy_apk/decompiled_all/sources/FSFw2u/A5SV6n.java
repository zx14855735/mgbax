package FSFw2u;

import GnQT2j.AcNBzu;
import android.app.Activity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2676AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2677AlLFFp;

    public /* synthetic */ A5SV6n(AZkASS aZkASS, int i) {
        this.f2676AcNBzu = i;
        this.f2677AlLFFp = aZkASS;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AZkASS aZkASS = this.f2677AlLFFp;
        int i = this.f2676AcNBzu;
        aZkASS.getClass();
        switch (i) {
            case 0:
                Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
                HH6JFw.A5SV6n a5SV6n = aZkASS.f2715GGG1xW;
                if (a5SV6n != null && a5SV6n.isShowing() && A5SV6n2 != null && !A5SV6n2.isFinishing()) {
                    aZkASS.f2715GGG1xW.dismiss();
                    break;
                }
                break;
            default:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                AcNBzu.A2egSU().A4TApA(aZkASS.f2718GJee0v.getAdm(), new AYUAbz(aZkASS, 0));
                break;
        }
    }
}
