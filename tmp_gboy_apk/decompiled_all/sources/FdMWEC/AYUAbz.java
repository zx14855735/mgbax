package FdMWEC;

import android.graphics.Point;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2804A2egSU;

    public /* synthetic */ AYUAbz(AZkASS aZkASS) {
        this.f2804A2egSU = aZkASS;
    }

    public void A2egSU(FrameLayout frameLayout, float f, float f2, float f3, float f4) {
        AZkASS aZkASS = this.f2804A2egSU;
        if (aZkASS.f2865IQ76hF != 5) {
            return;
        }
        aZkASS.f3217CSDoyG = "" + ((int) f);
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz.append((int) f2);
        aZkASS.f3218CTkVKb = AMqCpz.toString();
        StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz2.append((int) f3);
        aZkASS.f3219CcAIMM = AMqCpz2.toString();
        StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz3.append((int) f4);
        aZkASS.f3220Cd8JRx = AMqCpz3.toString();
        Point AaHO0E2 = H0qugq.AZOQYO.AaHO0E(frameLayout, f, f2);
        Point AaHO0E3 = H0qugq.AZOQYO.AaHO0E(frameLayout, f3, f4);
        StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz4.append(AaHO0E2.x);
        aZkASS.f3212C4FrIb = AMqCpz4.toString();
        StringBuilder AMqCpz5 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz5.append(AaHO0E2.y);
        aZkASS.f3213CASmeH = AMqCpz5.toString();
        StringBuilder AMqCpz6 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz6.append(AaHO0E3.x);
        aZkASS.f3214CNPG0E = AMqCpz6.toString();
        StringBuilder AMqCpz7 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz7.append(AaHO0E3.y);
        aZkASS.f3215COJEAR = AMqCpz7.toString();
        aZkASS.EH1KK8("swipe", 0);
    }
}
