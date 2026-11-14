package NCeV4Q;

import NGepWW.DRlcZ9;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends DRlcZ9 {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final NSK3xo.ASJ6gh f5645AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final NSK3xo.AYUAbz f5646AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f5647B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ASJ6gh(NSK3xo.AYUAbz aYUAbz, NSK3xo.AcNBzu acNBzu, int i) {
        super(acNBzu);
        this.f5647B25kr6 = i;
        NUY5pn.AYUAbz.A5SV6n(acNBzu, "GoogleApiClient must not be null");
        this.f5645AmA8tU = aYUAbz.A2egSU();
        this.f5646AzWtSf = aYUAbz;
    }

    @Override // NGepWW.DRlcZ9
    public final NSK3xo.A4TApA A4TApA(NSK3xo.A4TApA a4TApA) {
        int i = this.f5647B25kr6;
        return a4TApA;
    }

    public final void AZkASS(NSK3xo.ARc23Z aRc23Z) {
        Parcel obtain;
        switch (this.f5647B25kr6) {
            case 0:
                AMqCpz aMqCpz = (AMqCpz) aRc23Z;
                AzWtSf azWtSf = (AzWtSf) aMqCpz.AcNBzu();
                ARc23Z aRc23Z2 = new ARc23Z(this);
                AlLFFp alLFFp = (AlLFFp) azWtSf;
                alLFFp.getClass();
                obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(aRc23Z2);
                    N9P37h.A5SV6n a5SV6n = aMqCpz.f5643BIYEnU;
                    if (a5SV6n != null) {
                        obtain.writeInt(1);
                        a5SV6n.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    alLFFp.f5650A2egSU.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    return;
                } catch (Throwable th) {
                    obtain2.recycle();
                    throw th;
                }
            default:
                NGepWW.B2KMhB b2KMhB = (NGepWW.B2KMhB) ((NGepWW.AcNBzu) aRc23Z).AcNBzu();
                NGepWW.AZkASS aZkASS = new NGepWW.AZkASS(this);
                NGepWW.AzWtSf azWtSf2 = (NGepWW.AzWtSf) b2KMhB;
                azWtSf2.getClass();
                obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    obtain.writeStrongBinder(aZkASS);
                    azWtSf2.f5688A2egSU.transact(1, obtain, null, 1);
                    return;
                } finally {
                    obtain.recycle();
                }
        }
    }

    public final void AaHO0E(NSK3xo.A4TApA a4TApA) {
        NUY5pn.AYUAbz.ASJ6gh(!(a4TApA.f5926AlLFFp <= 0), "Failed result must not be success");
        A2egSU(A4TApA(a4TApA));
    }
}
