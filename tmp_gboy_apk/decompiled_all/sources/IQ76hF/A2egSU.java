package IQ76hF;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Set f3932AcNBzu = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f3933AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f3934AmA8tU;

    @Override // IQ76hF.ASJ6gh
    public final void A4TApA(AYUAbz aYUAbz) {
        this.f3932AcNBzu.remove(aYUAbz);
    }

    @Override // IQ76hF.ASJ6gh
    public final void ASJ6gh(AYUAbz aYUAbz) {
        this.f3932AcNBzu.add(aYUAbz);
        if (this.f3934AmA8tU) {
            aYUAbz.onDestroy();
        } else if (this.f3933AlLFFp) {
            aYUAbz.onStart();
        } else {
            aYUAbz.onStop();
        }
    }
}
