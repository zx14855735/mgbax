package NGepWW;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends NUY5pn.BJ7GGh {
    @Override // NUY5pn.BJ7GGh
    public final String A2egSU() {
        return "com.google.android.gms.common.service.START";
    }

    @Override // NUY5pn.BJ7GGh
    public final IInterface AMqCpz(IBinder iBinder) {
        int i = B25kr6.f5689A2egSU;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof B2KMhB)) {
            return (B2KMhB) queryLocalInterface;
        }
        AzWtSf azWtSf = new AzWtSf();
        azWtSf.f5688A2egSU = iBinder;
        return azWtSf;
    }

    @Override // NUY5pn.BJ7GGh
    public final String ARc23Z() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
