package I3HV03;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn implements HSHyT0.B3GDIM {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HSHyT0.B3GDIM f3844A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f3845A5SV6n;

    public BChYOn(HSHyT0.B3GDIM b3gdim, boolean z) {
        this.f3844A4TApA = b3gdim;
        this.f3845A5SV6n = z;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        this.f3844A4TApA.A2egSU(messageDigest);
    }

    @Override // HSHyT0.B3GDIM
    public final HXc4pW.BTvldC A4TApA(Context context, HXc4pW.BTvldC bTvldC, int i, int i2) {
        HZUvgL.ADYaiT aDYaiT = com.bumptech.glide.A4TApA.A4TApA(context).f9875AcNBzu;
        Drawable drawable = (Drawable) bTvldC.get();
        ARc23Z A2egSU2 = B9tovu.A2egSU(aDYaiT, drawable, i, i2);
        if (A2egSU2 != null) {
            HXc4pW.BTvldC A4TApA2 = this.f3844A4TApA.A4TApA(context, A2egSU2, i, i2);
            if (!A4TApA2.equals(A2egSU2)) {
                return new ARc23Z(context.getResources(), A4TApA2);
            }
            A4TApA2.A2egSU();
            return bTvldC;
        }
        if (!this.f3845A5SV6n) {
            return bTvldC;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof BChYOn) {
            return this.f3844A4TApA.equals(((BChYOn) obj).f3844A4TApA);
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return this.f3844A4TApA.hashCode();
    }
}
