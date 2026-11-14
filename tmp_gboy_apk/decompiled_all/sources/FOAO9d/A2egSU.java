package FOAO9d;

import ADYaiT.CtFAbx;
import Fyurov.B3GDIM;
import android.content.Intent;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements Fyurov.ARc23Z, G58fqA.A5SV6n, Fyurov.A5SV6n, B3GDIM {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2573AcNBzu;

    public /* synthetic */ A2egSU(AcNBzu acNBzu) {
        this.f2573AcNBzu = acNBzu;
    }

    @Override // Fyurov.B3GDIM
    public void A2egSU(double d, double d2) {
        FrameLayout frameLayout;
        GIi2tl.A2egSU a2egSU;
        AcNBzu acNBzu = this.f2573AcNBzu;
        acNBzu.getClass();
        try {
            synchronized (acNBzu.f2652I3HV03) {
                try {
                    if (!acNBzu.f2651HwAeAU && ((float) d) >= acNBzu.f2637HFjH17) {
                        GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A4TApA(acNBzu, 2));
                        acNBzu.AYUAbz();
                        acNBzu.DuwtYk(1, null, 0, null);
                        acNBzu.f2651HwAeAU = true;
                    }
                } finally {
                }
            }
            if (!acNBzu.f2654I9dkCd && d > 0.0d && (a2egSU = acNBzu.GZqyMh) != null) {
                acNBzu.f2654I9dkCd = true;
                Fyurov.ASJ6gh aSJ6gh = a2egSU.f3016BJ7GGh;
                if (aSJ6gh != null) {
                    aSJ6gh.ADYaiT();
                }
            }
            if (!acNBzu.f3203BIYEnU) {
                float f = acNBzu.f3202BI9f7h;
                if (f > 0.0f && ((float) d) == f && acNBzu.BniPrB() && acNBzu.DcUJf1()) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A4TApA(acNBzu, 3));
                }
            }
            if (!acNBzu.f2640HIguqb && ((int) d) == 3 && acNBzu.f2606ExjC7D == 2 && (frameLayout = acNBzu.f2634H0qugq) != null && frameLayout.getVisibility() == 0 && acNBzu.f2669J3EcKw == 4) {
                GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A4TApA(acNBzu, 4));
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 021: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    @Override // G58fqA.A5SV6n
    public void A4TApA(Intent intent) {
        AcNBzu acNBzu = this.f2573AcNBzu;
        acNBzu.getClass();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        acNBzu.EY4UKY(3);
        acNBzu.f2658IQ76hF.A4TApA();
    }

    @Override // Fyurov.A5SV6n
    public void a(int i, boolean z) {
        AcNBzu acNBzu = this.f2573AcNBzu;
        acNBzu.EY4UKY(1);
        if (i == 1) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            if (acNBzu.EQurEW("user", 1, z)) {
                acNBzu.EY4UKY(1);
                return;
            }
            return;
        }
        if (i == 2) {
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            acNBzu.AZkASS();
            acNBzu.BIYEnU(acNBzu.f3187AYUAbz);
            acNBzu.f3208BV3sI0.ADYaiT(true);
            acNBzu.f3196B2KMhB = 3;
            return;
        }
        if (i == 3) {
            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
            acNBzu.AZOQYO();
            acNBzu.BIYEnU(acNBzu.f3187AYUAbz);
            acNBzu.f3196B2KMhB = 1;
            acNBzu.f3208BV3sI0.ADYaiT(false);
            return;
        }
        if (i == 4) {
            int i5 = GJee0v.AZOQYO.f3039AcNBzu;
            acNBzu.C2rE4F();
            acNBzu.DV2E8K();
            acNBzu.BIYEnU(acNBzu.f3187AYUAbz);
            acNBzu.DuwtYk(0, null, 0, null);
            return;
        }
        if (i != 5) {
            return;
        }
        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
        if (acNBzu.EQurEW("user", 1, z)) {
            acNBzu.EY4UKY(1);
        }
    }

    @Override // Fyurov.ARc23Z
    public void a(int[] iArr) {
        AcNBzu acNBzu = this.f2573AcNBzu;
        if (acNBzu.f2640HIguqb || acNBzu.f3195B25kr6 || acNBzu.f2668IzHBwY != 5 || !acNBzu.DcUJf1()) {
            return;
        }
        acNBzu.f3195B25kr6 = true;
        acNBzu.f3205BNL6CD = iArr;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (acNBzu.EQurEW("shake", 0, false)) {
            acNBzu.EY4UKY(1);
        } else {
            acNBzu.f3195B25kr6 = false;
        }
    }
}
