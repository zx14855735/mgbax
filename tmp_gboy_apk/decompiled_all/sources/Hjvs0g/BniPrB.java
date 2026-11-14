package Hjvs0g;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB implements BIYEnU, IOxIEW.A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3763AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Resources f3764AlLFFp;

    public /* synthetic */ BniPrB(Resources resources, int i) {
        this.f3763AcNBzu = i;
        this.f3764AlLFFp = resources;
    }

    @Override // IOxIEW.A5SV6n
    public HXc4pW.BTvldC ARc23Z(HXc4pW.BTvldC bTvldC, HSHyT0.AmA8tU amA8tU) {
        if (bTvldC == null) {
            return null;
        }
        return new I3HV03.ARc23Z(this.f3764AlLFFp, bTvldC);
    }

    @Override // Hjvs0g.BIYEnU
    public BI9f7h AYUAbz(BmvVmW bmvVmW) {
        switch (this.f3763AcNBzu) {
            case 0:
                return new A4TApA(this.f3764AlLFFp, bmvVmW.A5SV6n(Uri.class, AssetFileDescriptor.class));
            default:
                return new A4TApA(this.f3764AlLFFp, bmvVmW.A5SV6n(Uri.class, InputStream.class));
        }
    }
}
