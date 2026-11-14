package NGepWW;

import AaHO0E.HHoABE;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BpkvW3 extends NUY5pn.BJ7GGh implements NSK3xo.ARc23Z {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final boolean f5703BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final HHoABE f5704BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final Bundle f5705BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final Integer f5706BPw6Q8;

    public BpkvW3(Context context, Looper looper, HHoABE hHoABE, Bundle bundle, NSK3xo.AZkASS aZkASS, NSK3xo.AaHO0E aaHO0E) {
        super(context, looper, 44, hHoABE, aZkASS, aaHO0E);
        this.f5703BIYEnU = true;
        this.f5704BJ7GGh = hHoABE;
        this.f5705BNL6CD = bundle;
        this.f5706BPw6Q8 = (Integer) hHoABE.f931ASJ6gh;
    }

    @Override // NUY5pn.BJ7GGh
    public final String A2egSU() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // NUY5pn.BJ7GGh
    public final IInterface AMqCpz(IBinder iBinder) {
        int i = BmvVmW.f5702A2egSU;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof BniPrB)) {
            return (BniPrB) queryLocalInterface;
        }
        BV3sI0 bV3sI0 = new BV3sI0();
        bV3sI0.f5701A2egSU = iBinder;
        return bV3sI0;
    }

    @Override // NUY5pn.BJ7GGh
    public final String ARc23Z() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // NUY5pn.BJ7GGh
    public final Bundle AaHO0E() {
        HHoABE hHoABE = this.f5704BJ7GGh;
        boolean equals = this.f5991AZOQYO.getPackageName().equals((String) hHoABE.f929ADYaiT);
        Bundle bundle = this.f5705BNL6CD;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) hHoABE.f929ADYaiT);
        }
        return bundle;
    }

    public final void AlLFFp(BNL6CD bnl6cd) {
        try {
            NUY5pn.AZOQYO AmA8tU2 = AmA8tU();
            ((BV3sI0) ((BniPrB) AcNBzu())).A2egSU(new C2rE4F(1, AmA8tU2), bnl6cd);
        } catch (RemoteException e) {
            try {
                bnl6cd.AZOQYO(new CASmeH(1, new NOd7IU.A2egSU(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final NUY5pn.AZOQYO AmA8tU() {
        String ADYaiT2;
        this.f5704BJ7GGh.getClass();
        Account account = new Account("<<default account>>", "com.google");
        N9P37h.A2egSU a2egSU = null;
        if ("<<default account>>".equals(account.name)) {
            NCeV4Q.B3GDIM A2egSU2 = NCeV4Q.B3GDIM.A2egSU(this.f5991AZOQYO);
            String ADYaiT3 = A2egSU2.ADYaiT("defaultGoogleSignInAccount");
            if (!TextUtils.isEmpty(ADYaiT3) && (ADYaiT2 = A2egSU2.ADYaiT(NCeV4Q.B3GDIM.A5SV6n("googleSignInAccount", ADYaiT3))) != null) {
                try {
                    a2egSU = N9P37h.A2egSU.A2egSU(ADYaiT2);
                } catch (JSONException unused) {
                }
            }
        }
        return new NUY5pn.AZOQYO(2, account, this.f5706BPw6Q8.intValue(), a2egSU);
    }

    @Override // NUY5pn.BJ7GGh, NSK3xo.ARc23Z
    public final boolean i() {
        return this.f5703BIYEnU;
    }
}
