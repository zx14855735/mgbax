package NCeV4Q;

import NGepWW.EH1KK8;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ADYaiT {
    public static void A2egSU(EH1KK8 eh1kk8) {
        RevocationBoundService revocationBoundService = eh1kk8.f5794BJ7GGh;
        BTvldC.ADYaiT aDYaiT = AYUAbz.f5648A2egSU;
        B3GDIM.A2egSU(revocationBoundService).AMqCpz();
        Object[] objArr = {"Revoking access"};
        BTvldC.ADYaiT aDYaiT2 = AYUAbz.f5648A2egSU;
        if (aDYaiT2.f1447AcNBzu <= 3) {
            ((String) aDYaiT2.f1449AmA8tU).concat(String.format("GoogleSignInCommon", objArr));
        }
        Set set = NSK3xo.AcNBzu.f5944AcNBzu;
        synchronized (set) {
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((NSK3xo.AcNBzu) it.next()).ARc23Z();
        }
        eh1kk8.A5SV6n(new ASJ6gh(N8uUiS.A4TApA.f5594A2egSU, eh1kk8, 0));
    }
}
