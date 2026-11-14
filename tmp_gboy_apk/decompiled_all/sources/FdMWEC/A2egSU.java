package FdMWEC;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2790AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2791AlLFFp;

    public /* synthetic */ A2egSU(AZkASS aZkASS, int i) {
        this.f2790AcNBzu = i;
        this.f2791AlLFFp = aZkASS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AZkASS aZkASS = this.f2791AlLFFp;
        int i = this.f2790AcNBzu;
        aZkASS.getClass();
        switch (i) {
            case 0:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                aZkASS.EH1KK8("user", 0);
                break;
            case 1:
                int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                aZkASS.EH1KK8("user", 1);
                break;
            default:
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                aZkASS.EH1KK8("user", 0);
                break;
        }
    }
}
