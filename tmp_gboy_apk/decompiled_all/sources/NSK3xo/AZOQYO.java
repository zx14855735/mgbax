package NSK3xo;

import ADYaiT.CtFAbx;
import AaHO0E.HHoABE;
import NGepWW.B9tovu;
import NGepWW.BI9f7h;
import NGepWW.DUi7mC;
import NGepWW.EH1KK8;
import NUY5pn.BJ7GGh;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f5934A5SV6n;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final RevocationBoundService f5936ARc23Z;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public Looper f5939AZOQYO;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashSet f5932A2egSU = new HashSet();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashSet f5933A4TApA = new HashSet();
    public final QkAq4X.A4TApA AMqCpz = new QkAq4X.A4TApA();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final QkAq4X.A4TApA f5937ASJ6gh = new QkAq4X.A4TApA();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final int f5938AYUAbz = -1;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final NOd7IU.ADYaiT f5940AZkASS = NOd7IU.ADYaiT.f5861A4TApA;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final N8uUiS.A2egSU f5941AaHO0E = B9tovu.f5695A2egSU;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f5942AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5943AlLFFp = new ArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f5935ADYaiT = RevocationBoundService.class.getName();

    public AZOQYO(RevocationBoundService revocationBoundService) {
        this.f5936ARc23Z = revocationBoundService;
        this.f5939AZOQYO = revocationBoundService.getMainLooper();
        this.f5934A5SV6n = revocationBoundService.getPackageName();
    }

    public final EH1KK8 A2egSU() {
        NUY5pn.AYUAbz.ASJ6gh(!this.f5937ASJ6gh.isEmpty(), "must call addApi() to add at least one API");
        BI9f7h bI9f7h = BI9f7h.f5697A2egSU;
        QkAq4X.A4TApA a4TApA = this.f5937ASJ6gh;
        AYUAbz aYUAbz = B9tovu.f5696A4TApA;
        if (a4TApA.containsKey(aYUAbz)) {
            bI9f7h = (BI9f7h) a4TApA.get(aYUAbz);
        }
        HashSet hashSet = this.f5932A2egSU;
        HHoABE hHoABE = new HHoABE(hashSet, this.AMqCpz, this.f5934A5SV6n, this.f5935ADYaiT, bI9f7h);
        QkAq4X.A4TApA a4TApA2 = new QkAq4X.A4TApA();
        QkAq4X.A4TApA a4TApA3 = new QkAq4X.A4TApA();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((QkAq4X.ASJ6gh) a4TApA.keySet()).iterator();
        AYUAbz aYUAbz2 = null;
        while (true) {
            QkAq4X.ARc23Z aRc23Z = (QkAq4X.ARc23Z) it;
            if (!aRc23Z.hasNext()) {
                HHoABE hHoABE2 = hHoABE;
                AYUAbz aYUAbz3 = aYUAbz2;
                if (aYUAbz3 != null) {
                    boolean equals = hashSet.equals(this.f5933A4TApA);
                    String str = aYUAbz3.f5931A5SV6n;
                    if (!equals) {
                        throw new IllegalStateException(CtFAbx.BI9f7h("Must not set scopes in GoogleApiClient.Builder when using ", str, ". Set account in GoogleSignInOptions.Builder instead."));
                    }
                }
                EH1KK8 eh1kk8 = new EH1KK8(this.f5936ARc23Z, new ReentrantLock(), this.f5939AZOQYO, hHoABE2, this.f5940AZkASS, this.f5941AaHO0E, a4TApA2, this.f5942AcNBzu, this.f5943AlLFFp, a4TApA3, this.f5938AYUAbz, EH1KK8.AYUAbz(a4TApA3.values(), true), arrayList);
                Set set = AcNBzu.f5944AcNBzu;
                synchronized (set) {
                    set.add(eh1kk8);
                }
                if (this.f5938AYUAbz < 0) {
                    return eh1kk8;
                }
                throw null;
            }
            AYUAbz aYUAbz4 = (AYUAbz) aRc23Z.next();
            Object obj = a4TApA.get(aYUAbz4);
            Map map = (Map) hHoABE.f928A5SV6n;
            if (map.get(aYUAbz4) != null) {
                map.get(aYUAbz4).getClass();
                throw new ClassCastException();
            }
            a4TApA2.put(aYUAbz4, 0);
            DUi7mC dUi7mC = new DUi7mC(aYUAbz4);
            arrayList.add(dUi7mC);
            AYUAbz aYUAbz5 = aYUAbz2;
            A5SV6n a5SV6n = aYUAbz4.f5929A2egSU;
            NUY5pn.AYUAbz.AMqCpz(a5SV6n != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
            a5SV6n.getClass();
            HHoABE hHoABE3 = hHoABE;
            ARc23Z A4TApA2 = a5SV6n.A4TApA(this.f5936ARc23Z, this.f5939AZOQYO, hHoABE3, obj, dUi7mC, dUi7mC);
            a4TApA3.put(aYUAbz4.A2egSU(), A4TApA2);
            BJ7GGh bJ7GGh = (BJ7GGh) A4TApA2;
            bJ7GGh.getClass();
            if (!(bJ7GGh instanceof NCeV4Q.AMqCpz)) {
                aYUAbz2 = aYUAbz5;
            } else {
                if (aYUAbz5 != null) {
                    String valueOf = String.valueOf(aYUAbz4.f5931A5SV6n);
                    String valueOf2 = String.valueOf(aYUAbz5.f5931A5SV6n);
                    throw new IllegalStateException(J3FDQU.A2egSU.B3GDIM(new StringBuilder(valueOf2.length() + valueOf.length() + 21), valueOf, " cannot be used with ", valueOf2));
                }
                aYUAbz2 = aYUAbz4;
            }
            hHoABE = hHoABE3;
        }
    }
}
