package QkAq4X;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A4TApA extends AYUAbz implements Map {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public A2egSU f7724B4ZgIw;

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f7724B4ZgIw == null) {
            this.f7724B4ZgIw = new A2egSU(0, this);
        }
        A2egSU a2egSU = this.f7724B4ZgIw;
        if (a2egSU.f7720A2egSU == null) {
            a2egSU.f7720A2egSU = new ASJ6gh(0, a2egSU);
        }
        return a2egSU.f7720A2egSU;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f7724B4ZgIw == null) {
            this.f7724B4ZgIw = new A2egSU(0, this);
        }
        A2egSU a2egSU = this.f7724B4ZgIw;
        if (a2egSU.f7721A4TApA == null) {
            a2egSU.f7721A4TApA = new ASJ6gh(1, a2egSU);
        }
        return a2egSU.f7721A4TApA;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        A5SV6n(map.size() + this.f7752AmA8tU);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f7724B4ZgIw == null) {
            this.f7724B4ZgIw = new A2egSU(0, this);
        }
        A2egSU a2egSU = this.f7724B4ZgIw;
        if (a2egSU.f7722A5SV6n == null) {
            a2egSU.f7722A5SV6n = new B25kr6.A5SV6n(1, a2egSU);
        }
        return a2egSU.f7722A5SV6n;
    }
}
