package I3HV03;

import ADYaiT.DUi7mC;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements HSHyT0.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3803A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f3804A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f3805A5SV6n;

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2) {
        this.f3803A2egSU = i;
        this.f3804A4TApA = obj;
        this.f3805A5SV6n = obj2;
    }

    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        BPw6Q8 bPw6Q8;
        boolean z;
        ItGa5w.AMqCpz aMqCpz;
        switch (this.f3803A2egSU) {
            case 0:
                HXc4pW.BTvldC A2egSU2 = ((HSHyT0.B25kr6) this.f3804A4TApA).A2egSU(obj, i, i2, amA8tU);
                if (A2egSU2 == null) {
                    return null;
                }
                return new ARc23Z((Resources) this.f3805A5SV6n, A2egSU2);
            case 1:
                HXc4pW.BTvldC A5SV6n2 = ((I9dkCd.A5SV6n) this.f3804A4TApA).A5SV6n((Uri) obj);
                if (A5SV6n2 == null) {
                    return null;
                }
                return B9tovu.A2egSU((HZUvgL.ADYaiT) this.f3805A5SV6n, (Drawable) ((I9dkCd.A4TApA) A5SV6n2).get(), i, i2);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof BPw6Q8) {
                    bPw6Q8 = (BPw6Q8) inputStream;
                    z = false;
                } else {
                    bPw6Q8 = new BPw6Q8(inputStream, (HZUvgL.AaHO0E) this.f3805A5SV6n);
                    z = true;
                }
                ArrayDeque arrayDeque = ItGa5w.AMqCpz.f4076AmA8tU;
                synchronized (arrayDeque) {
                    aMqCpz = (ItGa5w.AMqCpz) arrayDeque.poll();
                }
                if (aMqCpz == null) {
                    aMqCpz = new ItGa5w.AMqCpz();
                }
                ItGa5w.AMqCpz aMqCpz2 = aMqCpz;
                aMqCpz2.f4077AcNBzu = bPw6Q8;
                ItGa5w.AZkASS aZkASS = new ItGa5w.AZkASS(aMqCpz2);
                A4TApA a4TApA = new A4TApA(bPw6Q8, 1, aMqCpz2);
                try {
                    B4ZgIw b4ZgIw = (B4ZgIw) this.f3804A4TApA;
                    ARc23Z A2egSU3 = b4ZgIw.A2egSU(new DUi7mC(b4ZgIw.f3841A5SV6n, aZkASS, b4ZgIw.f3842ADYaiT), i, i2, amA8tU, a4TApA);
                    aMqCpz2.A2egSU();
                    if (z) {
                        bPw6Q8.A4TApA();
                    }
                    return A2egSU3;
                } finally {
                }
        }
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, HSHyT0.AmA8tU amA8tU) {
        switch (this.f3803A2egSU) {
            case 0:
                return ((HSHyT0.B25kr6) this.f3804A4TApA).A4TApA(obj, amA8tU);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((B4ZgIw) this.f3804A4TApA).getClass();
                return true;
        }
    }

    public A2egSU(Resources resources, HSHyT0.B25kr6 b25kr6) {
        this.f3803A2egSU = 0;
        this.f3805A5SV6n = resources;
        this.f3804A4TApA = b25kr6;
    }
}
