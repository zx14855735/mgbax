package HXc4pW;

import ADYaiT.DUi7mC;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BpkvW3 implements ASJ6gh, ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f3647AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AZkASS f3648AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3649AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ADYaiT f3650AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Object f3651B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public volatile Hjvs0g.BChYOn f3652B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AMqCpz f3653B3GDIM;

    public BpkvW3(AYUAbz aYUAbz, AZkASS aZkASS) {
        this.f3647AcNBzu = aYUAbz;
        this.f3648AlLFFp = aZkASS;
    }

    @Override // HXc4pW.ASJ6gh
    public final boolean A2egSU() {
        Object obj = this.f3651B25kr6;
        if (obj != null) {
            this.f3651B25kr6 = null;
            int i = ItGa5w.ASJ6gh.f4081A2egSU;
            SystemClock.elapsedRealtimeNanos();
            try {
                HSHyT0.A4TApA ADYaiT2 = this.f3647AcNBzu.ADYaiT(obj);
                DUi7mC dUi7mC = new DUi7mC(9, ADYaiT2, obj, this.f3647AcNBzu.f3509AZOQYO);
                HSHyT0.AZkASS aZkASS = this.f3652B2KMhB.f3742A2egSU;
                AYUAbz aYUAbz = this.f3647AcNBzu;
                this.f3653B3GDIM = new AMqCpz(aZkASS, aYUAbz.f3514AmA8tU);
                aYUAbz.f3508AYUAbz.A2egSU().A2egSU(this.f3653B3GDIM, dUi7mC);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Objects.toString(this.f3653B3GDIM);
                    obj.toString();
                    ADYaiT2.toString();
                    SystemClock.elapsedRealtimeNanos();
                }
                this.f3652B2KMhB.f3744A5SV6n.AMqCpz();
                this.f3650AzWtSf = new ADYaiT(Collections.singletonList(this.f3652B2KMhB.f3742A2egSU), this.f3647AcNBzu, this);
            } catch (Throwable th) {
                this.f3652B2KMhB.f3744A5SV6n.AMqCpz();
                throw th;
            }
        }
        ADYaiT aDYaiT = this.f3650AzWtSf;
        if (aDYaiT != null && aDYaiT.A2egSU()) {
            return true;
        }
        this.f3650AzWtSf = null;
        this.f3652B2KMhB = null;
        boolean z = false;
        while (!z && this.f3649AmA8tU < this.f3647AcNBzu.A4TApA().size()) {
            ArrayList A4TApA2 = this.f3647AcNBzu.A4TApA();
            int i2 = this.f3649AmA8tU;
            this.f3649AmA8tU = i2 + 1;
            this.f3652B2KMhB = (Hjvs0g.BChYOn) A4TApA2.get(i2);
            if (this.f3652B2KMhB != null && (this.f3647AcNBzu.f3516B25kr6.A5SV6n(this.f3652B2KMhB.f3744A5SV6n.getDataSource()) || this.f3647AcNBzu.A5SV6n(this.f3652B2KMhB.f3744A5SV6n.A2egSU()) != null)) {
                this.f3652B2KMhB.f3744A5SV6n.ARc23Z(this.f3647AcNBzu.f3515AzWtSf, new K1Z3yj.A2egSU(this, this.f3652B2KMhB, 27, false));
                z = true;
            }
        }
        return z;
    }

    @Override // HXc4pW.ARc23Z
    public final void A4TApA(HSHyT0.AZkASS aZkASS, Exception exc, com.bumptech.glide.load.data.AMqCpz aMqCpz, int i) {
        this.f3648AlLFFp.A4TApA(aZkASS, exc, aMqCpz, this.f3652B2KMhB.f3744A5SV6n.getDataSource());
    }

    @Override // HXc4pW.ARc23Z
    public final void A5SV6n(HSHyT0.AZkASS aZkASS, Object obj, com.bumptech.glide.load.data.AMqCpz aMqCpz, int i, HSHyT0.AZkASS aZkASS2) {
        this.f3648AlLFFp.A5SV6n(aZkASS, obj, aMqCpz, this.f3652B2KMhB.f3744A5SV6n.getDataSource(), aZkASS);
    }

    @Override // HXc4pW.ASJ6gh
    public final void cancel() {
        Hjvs0g.BChYOn bChYOn = this.f3652B2KMhB;
        if (bChYOn != null) {
            bChYOn.f3744A5SV6n.cancel();
        }
    }
}
