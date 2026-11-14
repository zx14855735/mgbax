package FSFw2u;

import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ADYaiT implements Fyurov.A5SV6n, Fyurov.ARc23Z, G58fqA.A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2678AcNBzu;

    public /* synthetic */ ADYaiT(AZkASS aZkASS) {
        this.f2678AcNBzu = aZkASS;
    }

    @Override // G58fqA.A5SV6n
    public void A4TApA(Intent intent) {
        AZkASS aZkASS = this.f2678AcNBzu;
        aZkASS.getClass();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        aZkASS.DcUJf1();
        aZkASS.f2752Ifhupb.A4TApA();
    }

    @Override // Fyurov.ARc23Z
    public void a(int[] iArr) {
        AZkASS aZkASS = this.f2678AcNBzu;
        if (aZkASS.f3195B25kr6) {
            return;
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.f3195B25kr6 = true;
        aZkASS.f3205BNL6CD = iArr;
        if (aZkASS.EH1KK8("shake", 0, false)) {
            return;
        }
        aZkASS.f3195B25kr6 = false;
    }

    @Override // Fyurov.A5SV6n
    public void a(int i, boolean z) {
        AZkASS aZkASS = this.f2678AcNBzu;
        aZkASS.getClass();
        if (i == 1) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            aZkASS.EH1KK8("user", 1, z);
            return;
        }
        if (i == 2) {
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            aZkASS.AZkASS();
            aZkASS.BIYEnU(aZkASS.f3187AYUAbz);
            aZkASS.f3208BV3sI0.ADYaiT(true);
            aZkASS.f3196B2KMhB = 3;
            return;
        }
        if (i == 3) {
            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
            aZkASS.AZOQYO();
            aZkASS.BIYEnU(aZkASS.f3187AYUAbz);
            aZkASS.f3196B2KMhB = 1;
            aZkASS.f3208BV3sI0.ADYaiT(false);
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            int i5 = GJee0v.AZOQYO.f3039AcNBzu;
            aZkASS.EH1KK8("user", 1, z);
            return;
        }
        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.C2rE4F();
        aZkASS.DV2E8K();
        aZkASS.BIYEnU(aZkASS.f3187AYUAbz);
        aZkASS.DuwtYk(1, null);
    }
}
