package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f8650A2egSU;

    public ASJ6gh(AYUAbz aYUAbz) {
        this.f8650A2egSU = aYUAbz;
    }

    @Override // androidx.emoji2.text.AlLFFp
    public final void A2egSU(Throwable th) {
        this.f8650A2egSU.f8651A2egSU.ADYaiT(th);
    }

    @Override // androidx.emoji2.text.AlLFFp
    public final void A4TApA(AZOQYO.ARc23Z aRc23Z) {
        AYUAbz aYUAbz = this.f8650A2egSU;
        aYUAbz.f8653A5SV6n = aRc23Z;
        AZOQYO.ARc23Z aRc23Z2 = aYUAbz.f8653A5SV6n;
        AmA8tU amA8tU = aYUAbz.f8651A2egSU;
        aYUAbz.f8652A4TApA = new B4ZgIw(aRc23Z2, amA8tU.f8664ASJ6gh, amA8tU.f8666AZOQYO, Build.VERSION.SDK_INT >= 34 ? B2KMhB.A2egSU() : com.bumptech.glide.A5SV6n.BI9f7h());
        AmA8tU amA8tU2 = aYUAbz.f8651A2egSU;
        amA8tU2.getClass();
        ArrayList arrayList = new ArrayList();
        amA8tU2.f8659A2egSU.writeLock().lock();
        try {
            amA8tU2.f8661A5SV6n = 1;
            arrayList.addAll(amA8tU2.f8660A4TApA);
            amA8tU2.f8660A4TApA.clear();
            amA8tU2.f8659A2egSU.writeLock().unlock();
            amA8tU2.f8662ADYaiT.post(new C4FrIb.A4TApA(arrayList, amA8tU2.f8661A5SV6n, (Throwable) null));
        } catch (Throwable th) {
            amA8tU2.f8659A2egSU.writeLock().unlock();
            throw th;
        }
    }
}
