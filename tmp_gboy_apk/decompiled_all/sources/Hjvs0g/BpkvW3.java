package Hjvs0g;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BpkvW3 implements BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3765AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Resources f3766AlLFFp;

    public /* synthetic */ BpkvW3(Resources resources, int i) {
        this.f3765AcNBzu = i;
        this.f3766AlLFFp = resources;
    }

    @Override // Hjvs0g.BIYEnU
    public final BI9f7h AYUAbz(BmvVmW bmvVmW) {
        switch (this.f3765AcNBzu) {
            case 0:
                return new A4TApA(this.f3766AlLFFp, bmvVmW.A5SV6n(Uri.class, ParcelFileDescriptor.class));
            default:
                return new A4TApA(this.f3766AlLFFp, COJEAR.f3769A2egSU);
        }
    }
}
