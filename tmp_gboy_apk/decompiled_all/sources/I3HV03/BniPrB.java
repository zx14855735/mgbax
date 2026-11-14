package I3HV03;

import android.graphics.Bitmap;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB implements HXc4pW.BTvldC {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3868AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3869AlLFFp;

    public BniPrB(byte[] bArr) {
        ItGa5w.ARc23Z.A5SV6n(bArr, "Argument must not be null");
        this.f3869AlLFFp = bArr;
    }

    private final void A5SV6n() {
    }

    private final void ADYaiT() {
    }

    private final void AMqCpz() {
    }

    @Override // HXc4pW.BTvldC
    public final void A2egSU() {
        int i = this.f3868AcNBzu;
    }

    @Override // HXc4pW.BTvldC
    public final Class A4TApA() {
        switch (this.f3868AcNBzu) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            default:
                return ((File) this.f3869AlLFFp).getClass();
        }
    }

    @Override // HXc4pW.BTvldC
    public final Object get() {
        switch (this.f3868AcNBzu) {
            case 0:
                return (Bitmap) this.f3869AlLFFp;
            case 1:
                return (byte[]) this.f3869AlLFFp;
            default:
                return (File) this.f3869AlLFFp;
        }
    }

    @Override // HXc4pW.BTvldC
    public final int getSize() {
        switch (this.f3868AcNBzu) {
            case 0:
                return ItGa5w.AlLFFp.A5SV6n((Bitmap) this.f3869AlLFFp);
            case 1:
                return ((byte[]) this.f3869AlLFFp).length;
            default:
                return 1;
        }
    }

    public BniPrB(File file) {
        ItGa5w.ARc23Z.A5SV6n(file, "Argument must not be null");
        this.f3869AlLFFp = file;
    }

    public BniPrB(Bitmap bitmap) {
        this.f3869AlLFFp = bitmap;
    }
}
