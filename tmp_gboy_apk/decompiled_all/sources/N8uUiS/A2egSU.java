package N8uUiS;

import AaHO0E.HHoABE;
import NCeV4Q.AMqCpz;
import NGepWW.AcNBzu;
import NGepWW.BI9f7h;
import NGepWW.BpkvW3;
import NGepWW.CQhlFr;
import NGepWW.CqNSpT;
import NSK3xo.ARc23Z;
import NSK3xo.AZkASS;
import NSK3xo.AaHO0E;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends NSK3xo.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f5593A2egSU;

    @Override // NSK3xo.AMqCpz
    public List A2egSU(N9P37h.A5SV6n a5SV6n) {
        switch (this.f5593A2egSU) {
            case 2:
                return a5SV6n == null ? Collections.EMPTY_LIST : new ArrayList(a5SV6n.f5620AlLFFp);
            default:
                return super.A2egSU(a5SV6n);
        }
    }

    @Override // NSK3xo.A5SV6n
    public final ARc23Z A4TApA(Context context, Looper looper, HHoABE hHoABE, Object obj, AZkASS aZkASS, AaHO0E aaHO0E) {
        switch (this.f5593A2egSU) {
            case 0:
                if (obj == null) {
                    return new CQhlFr(context, looper, 68, hHoABE, aZkASS, aaHO0E, 1);
                }
                throw new ClassCastException();
            case 1:
                if (obj == null) {
                    return new CQhlFr(context, looper, 74, hHoABE, aZkASS, aaHO0E, 0);
                }
                throw new ClassCastException();
            case 2:
                return new AMqCpz(context, looper, hHoABE, (N9P37h.A5SV6n) obj, aZkASS, aaHO0E);
            case 3:
                if (obj == null) {
                    return new CqNSpT(context, looper, hHoABE, aZkASS, aaHO0E);
                }
                throw new ClassCastException();
            case 4:
                if (obj == null) {
                    return new AcNBzu(context, looper, 39, hHoABE, aZkASS, aaHO0E);
                }
                throw new ClassCastException();
            case 5:
                if (((BI9f7h) obj) == null) {
                    BI9f7h bI9f7h = BI9f7h.f5697A2egSU;
                }
                BI9f7h bI9f7h2 = (BI9f7h) hHoABE.f930ARc23Z;
                Integer num = (Integer) hHoABE.f931ASJ6gh;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                if (bI9f7h2 != null) {
                    bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                    bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                    bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                    bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                    bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                    bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                    bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                }
                return new BpkvW3(context, looper, hHoABE, bundle, aZkASS, aaHO0E);
            default:
                obj.getClass();
                throw new ClassCastException();
        }
    }
}
