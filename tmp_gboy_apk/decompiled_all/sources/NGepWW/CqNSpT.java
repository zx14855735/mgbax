package NGepWW;

import AaHO0E.HHoABE;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CqNSpT extends NUY5pn.BJ7GGh {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Bundle f5717BIYEnU;

    public CqNSpT(Context context, Looper looper, HHoABE hHoABE, NSK3xo.AZkASS aZkASS, NSK3xo.AaHO0E aaHO0E) {
        super(context, looper, 16, hHoABE, aZkASS, aaHO0E);
        this.f5717BIYEnU = new Bundle();
    }

    @Override // NUY5pn.BJ7GGh
    public final String A2egSU() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // NUY5pn.BJ7GGh
    public final IInterface AMqCpz(IBinder iBinder) {
        int i = CtFAbx.f5719A2egSU;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof CtxOCS)) {
            return (CtxOCS) queryLocalInterface;
        }
        CrfGsy crfGsy = new CrfGsy();
        crfGsy.f5718A2egSU = iBinder;
        return crfGsy;
    }

    @Override // NUY5pn.BJ7GGh
    public final String ARc23Z() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // NUY5pn.BJ7GGh
    public final Bundle AaHO0E() {
        return this.f5717BIYEnU;
    }

    @Override // NUY5pn.BJ7GGh, NSK3xo.ARc23Z
    public final boolean i() {
        HHoABE hHoABE = this.f6004BChYOn;
        hHoABE.getClass();
        if (TextUtils.isEmpty(null)) {
            return false;
        }
        if (((Map) hHoABE.f928A5SV6n).get(N8uUiS.A5SV6n.f5596A2egSU) == null) {
            return !((Set) hHoABE.f926A2egSU).isEmpty();
        }
        throw new ClassCastException();
    }
}
