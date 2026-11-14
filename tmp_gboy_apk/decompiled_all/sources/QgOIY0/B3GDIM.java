package QgOIY0;

import android.view.View;
import android.view.Window;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class B3GDIM extends B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B7CMnp f7587A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B7CMnp f7588A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BNL6CD f7589A5SV6n = new BNL6CD();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final DG07BK.A2egSU f7590ADYaiT;
    public QkAq4X.AYUAbz AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f7591ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public CcAIMM f7592ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f7593AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f7594AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final B7CMnp f7595AZkASS;

    public B3GDIM(B7CMnp b7CMnp) {
        this.f7595AZkASS = b7CMnp;
        this.f7587A2egSU = b7CMnp;
        this.f7588A4TApA = b7CMnp;
        this.f7590ADYaiT = b7CMnp.f7598AlLFFp;
    }

    @Override // QgOIY0.B9tovu
    public final View A2egSU(int i) {
        return this.f7595AZkASS.findViewById(i);
    }

    @Override // QgOIY0.B9tovu
    public final boolean A4TApA() {
        Window window = this.f7595AZkASS.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final CcAIMM A5SV6n(String str, boolean z, boolean z2) {
        if (this.AMqCpz == null) {
            this.AMqCpz = new QkAq4X.AYUAbz();
        }
        CcAIMM ccAIMM = (CcAIMM) this.AMqCpz.get(str);
        if (ccAIMM == null && z2) {
            CcAIMM ccAIMM2 = new CcAIMM(str, this, z);
            this.AMqCpz.put(str, ccAIMM2);
            return ccAIMM2;
        }
        if (z && ccAIMM != null && !ccAIMM.f7702ADYaiT) {
            ccAIMM.A5SV6n();
        }
        return ccAIMM;
    }
}
