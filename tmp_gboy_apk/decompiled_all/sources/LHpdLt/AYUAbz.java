package LHpdLt;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4469AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4470AlLFFp;

    public /* synthetic */ AYUAbz(AZOQYO azoqyo, int i) {
        this.f4469AcNBzu = i;
        this.f4470AlLFFp = azoqyo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4469AcNBzu) {
            case 0:
                AZOQYO.A4TApA(this.f4470AlLFFp);
                break;
            case 1:
                AZOQYO.A5SV6n(this.f4470AlLFFp);
                break;
            default:
                AZOQYO azoqyo = this.f4470AlLFFp;
                boolean z = !azoqyo.f4505COJEAR.AzWtSf("danmaku_enabled");
                azoqyo.f4505COJEAR.BI9f7h("danmaku_enabled", z);
                azoqyo.B2KMhB(z);
                break;
        }
    }
}
