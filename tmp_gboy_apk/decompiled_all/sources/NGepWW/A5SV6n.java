package NGepWW;

import AaHO0E.HHoABE;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import java.lang.reflect.Method;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends BNL6CD implements NSK3xo.AZkASS, NSK3xo.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f5672A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Handler f5673A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final N8uUiS.A2egSU f5674A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Set f5675ADYaiT;
    public final HHoABE AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public BpkvW3 f5676ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public EiK8oA f5677ASJ6gh;

    static {
        N8uUiS.A2egSU a2egSU = B9tovu.f5695A2egSU;
        KkLyA();
    }

    public A5SV6n(Context context, Handler handler, HHoABE hHoABE, N8uUiS.A2egSU a2egSU) {
        this.f5672A2egSU = context;
        this.f5673A4TApA = handler;
        this.AMqCpz = hHoABE;
        this.f5675ADYaiT = (Set) hHoABE.f926A2egSU;
        this.f5674A5SV6n = a2egSU;
    }

    private static /* synthetic */ void KkLyA() {
        char[] charArray = "VZX\u001bRTXP\u001bWZL\u001bF]PYY\u001b\u007f[\\wG\\QRP".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '5');
        }
        String str = new String(charArray);
        char[] charArray2 = "VY\\[\\A".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '5');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        this.f5676ARc23Z.AlLFFp(this);
    }

    @Override // NSK3xo.AaHO0E
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        this.f5677ASJ6gh.A2egSU(a2egSU);
    }

    @Override // NGepWW.BNL6CD, NGepWW.BTvldC
    public final void AZOQYO(CASmeH cASmeH) {
        this.f5673A4TApA.post(new MOpbMP.A2egSU(this, 14, cASmeH));
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
        this.f5676ARc23Z.AYUAbz();
    }
}
