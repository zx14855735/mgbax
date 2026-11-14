package NGepWW;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DXuj49 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Map f5736A2egSU = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Map f5737A4TApA = Collections.synchronizedMap(new WeakHashMap());

    public final void A2egSU(boolean z, NSK3xo.A4TApA a4TApA) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f5736A2egSU) {
            hashMap = new HashMap(this.f5736A2egSU);
        }
        synchronized (this.f5737A4TApA) {
            hashMap2 = new HashMap(this.f5737A4TApA);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((DRlcZ9) entry.getKey()).AMqCpz(a4TApA);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((NIA37H.A4TApA) entry2.getKey()).A2egSU(new NSK3xo.AzWtSf(a4TApA));
            }
        }
    }
}
