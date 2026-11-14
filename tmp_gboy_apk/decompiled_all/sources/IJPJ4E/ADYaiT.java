package IJPJ4E;

import HSHyT0.B3GDIM;
import HXc4pW.BTvldC;
import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements B3GDIM {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B3GDIM f3898A4TApA;

    public ADYaiT(B3GDIM b3gdim) {
        ItGa5w.ARc23Z.A5SV6n(b3gdim, "Argument must not be null");
        this.f3898A4TApA = b3gdim;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        this.f3898A4TApA.A2egSU(messageDigest);
    }

    @Override // HSHyT0.B3GDIM
    public final BTvldC A4TApA(Context context, BTvldC bTvldC, int i, int i2) {
        A4TApA a4TApA = (A4TApA) bTvldC.get();
        BTvldC aRc23Z = new I3HV03.ARc23Z(com.bumptech.glide.A4TApA.A4TApA(context).f9875AcNBzu, ((AYUAbz) a4TApA.f3888AcNBzu.f2321A4TApA).f3915AcNBzu);
        B3GDIM b3gdim = this.f3898A4TApA;
        BTvldC A4TApA2 = b3gdim.A4TApA(context, aRc23Z, i, i2);
        if (!aRc23Z.equals(A4TApA2)) {
            aRc23Z.A2egSU();
        }
        ((AYUAbz) a4TApA.f3888AcNBzu.f2321A4TApA).A5SV6n(b3gdim, (Bitmap) A4TApA2.get());
        return bTvldC;
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof ADYaiT) {
            return this.f3898A4TApA.equals(((ADYaiT) obj).f3898A4TApA);
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return this.f3898A4TApA.hashCode();
    }
}
