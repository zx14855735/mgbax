package FdMWEC;

import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A4TApA implements G58fqA.A5SV6n, Fyurov.ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2792AcNBzu;

    public /* synthetic */ A4TApA(AZkASS aZkASS) {
        this.f2792AcNBzu = aZkASS;
    }

    @Override // G58fqA.A5SV6n
    public void A4TApA(Intent intent) {
        AZkASS aZkASS = this.f2792AcNBzu;
        aZkASS.getClass();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (aZkASS.f2865IQ76hF == 7 || intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        aZkASS.DcUJf1();
        aZkASS.f2856Hjvs0g.A4TApA();
    }

    @Override // Fyurov.ARc23Z
    public void a(int[] iArr) {
        AZkASS aZkASS = this.f2792AcNBzu;
        if (aZkASS.f3195B25kr6 || aZkASS.f2865IQ76hF != 5) {
            return;
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.f3195B25kr6 = true;
        aZkASS.f3205BNL6CD = iArr;
        if (aZkASS.EH1KK8("shake", 0)) {
            return;
        }
        aZkASS.f3195B25kr6 = false;
    }
}
