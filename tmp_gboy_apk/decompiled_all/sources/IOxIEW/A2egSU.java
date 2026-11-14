package IOxIEW;

import HSHyT0.AmA8tU;
import HXc4pW.BTvldC;
import I3HV03.BniPrB;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU implements A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Bitmap.CompressFormat f3925AcNBzu = Bitmap.CompressFormat.JPEG;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f3926AlLFFp = 100;

    @Override // IOxIEW.A5SV6n
    public final BTvldC ARc23Z(BTvldC bTvldC, AmA8tU amA8tU) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) bTvldC.get()).compress(this.f3925AcNBzu, this.f3926AlLFFp, byteArrayOutputStream);
        bTvldC.A2egSU();
        return new BniPrB(byteArrayOutputStream.toByteArray());
    }
}
