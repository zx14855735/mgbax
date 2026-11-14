package I3HV03;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ASJ6gh implements HSHyT0.B3GDIM {
    @Override // HSHyT0.B3GDIM
    public final HXc4pW.BTvldC A4TApA(Context context, HXc4pW.BTvldC bTvldC, int i, int i2) {
        if (!ItGa5w.AlLFFp.AYUAbz(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        HZUvgL.ADYaiT aDYaiT = com.bumptech.glide.A4TApA.A4TApA(context).f9875AcNBzu;
        Bitmap bitmap = (Bitmap) bTvldC.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap A5SV6n2 = A5SV6n(aDYaiT, bitmap, i, i2);
        return bitmap.equals(A5SV6n2) ? bTvldC : ARc23Z.A5SV6n(aDYaiT, A5SV6n2);
    }

    public abstract Bitmap A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap, int i, int i2);
}
