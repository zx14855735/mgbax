package NGepWW;

import AaHO0E.HHoABE;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CQhlFr extends NUY5pn.BJ7GGh {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final /* synthetic */ int f5712BIYEnU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CQhlFr(Context context, Looper looper, int i, HHoABE hHoABE, NSK3xo.AZkASS aZkASS, NSK3xo.AaHO0E aaHO0E, int i2) {
        super(context, looper, i, hHoABE, aZkASS, aaHO0E);
        this.f5712BIYEnU = i2;
    }

    @Override // NUY5pn.BJ7GGh
    public final String A2egSU() {
        switch (this.f5712BIYEnU) {
            case 0:
                return "com.google.android.gms.auth.api.accountactivationstate.START";
            default:
                return "com.google.android.gms.auth.api.credentials.service.START";
        }
    }

    @Override // NUY5pn.BJ7GGh
    public final IInterface AMqCpz(IBinder iBinder) {
        switch (this.f5712BIYEnU) {
            case 0:
                int i = CTkVKb.f5714A2egSU;
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
                if (queryLocalInterface != null && (queryLocalInterface instanceof CcAIMM)) {
                    return (CcAIMM) queryLocalInterface;
                }
                CSDoyG cSDoyG = new CSDoyG();
                cSDoyG.f5713A2egSU = iBinder;
                return cSDoyG;
            default:
                int i2 = CkXcdM.f5716A2egSU;
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                if (queryLocalInterface2 != null && (queryLocalInterface2 instanceof CmUvjW)) {
                    return (CmUvjW) queryLocalInterface2;
                }
                CikNvS cikNvS = new CikNvS();
                cikNvS.f5715A2egSU = iBinder;
                return cikNvS;
        }
    }

    @Override // NUY5pn.BJ7GGh
    public final String ARc23Z() {
        switch (this.f5712BIYEnU) {
            case 0:
                return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
            default:
                return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
        }
    }

    @Override // NUY5pn.BJ7GGh
    public Bundle AaHO0E() {
        switch (this.f5712BIYEnU) {
            case 1:
                return new Bundle();
            default:
                return super.AaHO0E();
        }
    }
}
