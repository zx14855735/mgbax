package NCeV4Q;

import AaHO0E.HHoABE;
import NUY5pn.BJ7GGh;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends BJ7GGh {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final N9P37h.A5SV6n f5643BIYEnU;

    public AMqCpz(Context context, Looper looper, HHoABE hHoABE, N9P37h.A5SV6n a5SV6n, NSK3xo.AZkASS aZkASS, NSK3xo.AaHO0E aaHO0E) {
        super(context, looper, 91, hHoABE, aZkASS, aaHO0E);
        a5SV6n = a5SV6n == null ? new N9P37h.A4TApA().A2egSU() : a5SV6n;
        Set<NSK3xo.A2egSU> set = (Set) hHoABE.f927A4TApA;
        if (!set.isEmpty()) {
            N9P37h.A4TApA a4TApA = new N9P37h.A4TApA();
            a4TApA.f5610A2egSU = new HashSet();
            a4TApA.f5610A2egSU = new HashSet(a5SV6n.f5620AlLFFp);
            a4TApA.f5611A4TApA = a5SV6n.f5623B25kr6;
            a4TApA.f5612A5SV6n = a5SV6n.f5624B2KMhB;
            a4TApA.f5613ADYaiT = a5SV6n.f5622AzWtSf;
            a4TApA.AMqCpz = a5SV6n.f5625B3GDIM;
            a4TApA.f5614ARc23Z = a5SV6n.f5621AmA8tU;
            a4TApA.f5615ASJ6gh = a5SV6n.f5626B4ZgIw;
            for (NSK3xo.A2egSU a2egSU : set) {
                HashSet hashSet = a4TApA.f5610A2egSU;
                hashSet.add(a2egSU);
                hashSet.addAll(Arrays.asList(new NSK3xo.A2egSU[0]));
            }
            a5SV6n = a4TApA.A2egSU();
        }
        this.f5643BIYEnU = a5SV6n;
    }

    @Override // NUY5pn.BJ7GGh
    public final String A2egSU() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // NUY5pn.BJ7GGh
    public final IInterface AMqCpz(IBinder iBinder) {
        int i = AmA8tU.f5651A2egSU;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof AzWtSf)) {
            return (AzWtSf) queryLocalInterface;
        }
        AlLFFp alLFFp = new AlLFFp();
        alLFFp.f5650A2egSU = iBinder;
        return alLFFp;
    }

    @Override // NUY5pn.BJ7GGh
    public final String ARc23Z() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // NUY5pn.BJ7GGh, NSK3xo.ARc23Z
    public final Intent d() {
        Object[] objArr = {"getSignInIntent()"};
        BTvldC.ADYaiT aDYaiT = AYUAbz.f5648A2egSU;
        if (aDYaiT.f1447AcNBzu <= 3) {
            ((String) aDYaiT.f1449AmA8tU).concat(String.format("GoogleSignInCommon", objArr));
        }
        Context context = this.f5991AZOQYO;
        A2egSU a2egSU = new A2egSU(3, context.getPackageName(), this.f5643BIYEnU);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(context, SignInHubActivity.class);
        intent.putExtra("config", a2egSU);
        return intent;
    }
}
