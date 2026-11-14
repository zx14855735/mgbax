package B9tovu;

import ADYaiT.CtFAbx;
import BChYOn.ARc23Z;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ARc23Z f1092A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f1093A4TApA;

    public A2egSU() {
        this.f1092A2egSU = null;
        this.f1093A4TApA = new HashMap();
    }

    public A2egSU update() {
        ARc23Z aRc23Z = this.f1092A2egSU;
        if (aRc23Z != null) {
            aRc23Z.B3GDIM();
            this.f1092A2egSU.B4ZgIw();
            this.f1092A2egSU.B3GDIM();
            this.f1092A2egSU.B4ZgIw();
            A2egSU a2egSU = this.f1092A2egSU.f1139AZkASS;
            a2egSU.getClass();
            this.f1093A4TApA.clear();
            Iterator it = a2egSU.f1093A4TApA.values().iterator();
            if (it.hasNext()) {
                throw CtFAbx.A5SV6n(it);
            }
        }
        return this;
    }

    public A2egSU(ARc23Z aRc23Z) {
        this.f1092A2egSU = null;
        this.f1093A4TApA = new HashMap();
        this.f1092A2egSU = aRc23Z;
    }

    public A2egSU update(ARc23Z aRc23Z) {
        if (aRc23Z == null) {
            return this;
        }
        this.f1092A2egSU = aRc23Z;
        update();
        return this;
    }
}
