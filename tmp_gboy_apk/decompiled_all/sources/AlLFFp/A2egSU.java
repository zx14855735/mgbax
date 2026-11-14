package AlLFFp;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU extends ARc23Z {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final HashMap f942B25kr6 = new HashMap();

    @Override // AlLFFp.ARc23Z
    public final A5SV6n A2egSU(Object obj) {
        return (A5SV6n) this.f942B25kr6.get(obj);
    }

    @Override // AlLFFp.ARc23Z
    public final Object A4TApA(Object obj) {
        Object A4TApA2 = super.A4TApA(obj);
        this.f942B25kr6.remove(obj);
        return A4TApA2;
    }
}
