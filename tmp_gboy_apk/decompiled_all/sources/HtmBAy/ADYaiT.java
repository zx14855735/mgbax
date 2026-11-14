package HtmBAy;

import HSHyT0.AmA8tU;
import Hjvs0g.BChYOn;
import Hjvs0g.BI9f7h;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f3791A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BI9f7h f3792A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BI9f7h f3793A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Class f3794ADYaiT;

    public ADYaiT(Context context, BI9f7h bI9f7h, BI9f7h bI9f7h2, Class cls) {
        this.f3791A2egSU = context.getApplicationContext();
        this.f3792A4TApA = bI9f7h;
        this.f3793A5SV6n = bI9f7h2;
        this.f3794ADYaiT = cls;
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, AmA8tU amA8tU) {
        Uri uri = (Uri) obj;
        return new BChYOn(new IssTRV.ADYaiT(uri), new A5SV6n(this.f3791A2egSU, this.f3792A4TApA, this.f3793A5SV6n, uri, i, i2, amA8tU, this.f3794ADYaiT));
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && JrXYwF.A4TApA.CikNvS((Uri) obj);
    }
}
