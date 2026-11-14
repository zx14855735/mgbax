package I3HV03;

import ADYaiT.DUi7mC;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements HSHyT0.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3817A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B4ZgIw f3818A4TApA;

    public /* synthetic */ AYUAbz(B4ZgIw b4ZgIw, int i) {
        this.f3817A2egSU = i;
        this.f3818A4TApA = b4ZgIw;
    }

    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        switch (this.f3817A2egSU) {
            case 0:
                AtomicReference atomicReference = ItGa5w.A4TApA.f4072A2egSU;
                ItGa5w.A2egSU a2egSU = new ItGa5w.A2egSU((ByteBuffer) obj);
                Hdahpu.AZOQYO azoqyo = B4ZgIw.f3837AaHO0E;
                B4ZgIw b4ZgIw = this.f3818A4TApA;
                return b4ZgIw.A2egSU(new DUi7mC(b4ZgIw.f3841A5SV6n, a2egSU, b4ZgIw.f3842ADYaiT), i, i2, amA8tU, azoqyo);
            default:
                B4ZgIw b4ZgIw2 = this.f3818A4TApA;
                return b4ZgIw2.A2egSU(new DUi7mC((ParcelFileDescriptor) obj, b4ZgIw2.f3842ADYaiT, b4ZgIw2.f3841A5SV6n), i, i2, amA8tU, B4ZgIw.f3837AaHO0E);
        }
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, HSHyT0.AmA8tU amA8tU) {
        switch (this.f3817A2egSU) {
            case 0:
                this.f3818A4TApA.getClass();
                break;
            default:
                this.f3818A4TApA.getClass();
                break;
        }
        return true;
    }
}
