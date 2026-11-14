package I3HV03;

import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements HSHyT0.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AMqCpz f3819A2egSU = new AMqCpz();

    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource((ByteBuffer) obj);
        return this.f3819A2egSU.A5SV6n(createSource, i, i2, amA8tU);
    }

    @Override // HSHyT0.B25kr6
    public final /* bridge */ /* synthetic */ boolean A4TApA(Object obj, HSHyT0.AmA8tU amA8tU) {
        return true;
    }
}
