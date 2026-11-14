package NUY5pn;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM extends AlLFFp {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final IBinder f5969ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final BJ7GGh f5970AYUAbz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B3GDIM(BJ7GGh bJ7GGh, int i, IBinder iBinder, Bundle bundle) {
        super(bJ7GGh, i, bundle);
        this.f5970AYUAbz = bJ7GGh;
        this.f5969ASJ6gh = iBinder;
    }

    @Override // NUY5pn.AlLFFp
    public final void A2egSU(NOd7IU.A2egSU a2egSU) {
        BJ7GGh bJ7GGh = this.f5970AYUAbz;
        IQ76hF.AmA8tU amA8tU = bJ7GGh.f6001B4ZgIw;
        if (amA8tU != null) {
            ((NSK3xo.AaHO0E) amA8tU.f3956AlLFFp).A4TApA(a2egSU);
        }
        bJ7GGh.f5989ASJ6gh = a2egSU.f5854AlLFFp;
        bJ7GGh.f5990AYUAbz = System.currentTimeMillis();
    }

    @Override // NUY5pn.AlLFFp
    public final boolean A4TApA() {
        IBinder iBinder = this.f5969ASJ6gh;
        try {
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BJ7GGh bJ7GGh = this.f5970AYUAbz;
            if (!bJ7GGh.ARc23Z().equals(interfaceDescriptor)) {
                new StringBuilder(String.valueOf(interfaceDescriptor).length() + bJ7GGh.ARc23Z().length() + 34);
                return false;
            }
            IInterface AMqCpz = bJ7GGh.AMqCpz(iBinder);
            if (AMqCpz == null || !BJ7GGh.ADYaiT(bJ7GGh, 2, 3, AMqCpz)) {
                return false;
            }
            NGepWW.A2egSU a2egSU = bJ7GGh.f6000B3GDIM;
            if (a2egSU == null) {
                return true;
            }
            ((NSK3xo.AZkASS) a2egSU.f5658AlLFFp).A2egSU(null);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
