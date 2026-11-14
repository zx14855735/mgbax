package DV2E8K;

import ADYaiT.AzWtSf;
import android.os.Bundle;
import androidx.lifecycle.AZkASS;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f2192A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Bundle f2193A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f2194ADYaiT;
    public AzWtSf AMqCpz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AlLFFp.ARc23Z f2191A2egSU = new AlLFFp.ARc23Z();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f2195ARc23Z = true;

    public final Bundle A2egSU(String str) {
        if (!this.f2194ADYaiT) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2193A5SV6n;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.f2193A5SV6n;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f2193A5SV6n;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f2193A5SV6n = null;
        return bundle2;
    }

    public final A5SV6n A4TApA() {
        String str;
        A5SV6n a5SV6n;
        Iterator it = this.f2191A2egSU.iterator();
        do {
            AlLFFp.AMqCpz aMqCpz = (AlLFFp.AMqCpz) it;
            if (!aMqCpz.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) aMqCpz.next();
            RXb0Sz.ARc23Z.ADYaiT(entry, "components");
            str = (String) entry.getKey();
            a5SV6n = (A5SV6n) entry.getValue();
        } while (!RXb0Sz.ARc23Z.A2egSU(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return a5SV6n;
    }

    public final void A5SV6n(String str, A5SV6n a5SV6n) {
        Object obj;
        RXb0Sz.ARc23Z.AMqCpz(a5SV6n, "provider");
        AlLFFp.ARc23Z aRc23Z = this.f2191A2egSU;
        AlLFFp.A5SV6n A2egSU2 = aRc23Z.A2egSU(str);
        if (A2egSU2 != null) {
            obj = A2egSU2.f945AlLFFp;
        } else {
            AlLFFp.A5SV6n a5SV6n2 = new AlLFFp.A5SV6n(str, a5SV6n);
            aRc23Z.f956AzWtSf++;
            AlLFFp.A5SV6n a5SV6n3 = aRc23Z.f954AlLFFp;
            if (a5SV6n3 == null) {
                aRc23Z.f953AcNBzu = a5SV6n2;
                aRc23Z.f954AlLFFp = a5SV6n2;
            } else {
                a5SV6n3.f946AmA8tU = a5SV6n2;
                a5SV6n2.f947AzWtSf = a5SV6n3;
                aRc23Z.f954AlLFFp = a5SV6n2;
            }
            obj = null;
        }
        if (((A5SV6n) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void ADYaiT() {
        if (!this.f2195ARc23Z) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        AzWtSf azWtSf = this.AMqCpz;
        if (azWtSf == null) {
            azWtSf = new AzWtSf(this);
        }
        this.AMqCpz = azWtSf;
        try {
            AZkASS.class.getDeclaredConstructor(new Class[0]);
            AzWtSf azWtSf2 = this.AMqCpz;
            if (azWtSf2 != null) {
                ((LinkedHashSet) azWtSf2.f85A4TApA).add(AZkASS.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + AZkASS.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
