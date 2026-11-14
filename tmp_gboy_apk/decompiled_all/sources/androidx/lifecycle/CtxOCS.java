package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CtxOCS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final LinkedHashMap f9039A2egSU = new LinkedHashMap();

    public final void A2egSU() {
        for (CikNvS cikNvS : this.f9039A2egSU.values()) {
            cikNvS.f9032A5SV6n = true;
            HashMap hashMap = cikNvS.f9030A2egSU;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        Iterator it = cikNvS.f9030A2egSU.values().iterator();
                        while (it.hasNext()) {
                            CikNvS.A2egSU(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = cikNvS.f9031A4TApA;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = cikNvS.f9031A4TApA.iterator();
                        while (it2.hasNext()) {
                            CikNvS.A2egSU((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            cikNvS.A4TApA();
        }
        this.f9039A2egSU.clear();
    }
}
