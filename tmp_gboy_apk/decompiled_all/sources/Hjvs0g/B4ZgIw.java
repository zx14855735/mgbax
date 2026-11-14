package Hjvs0g;

import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw extends ItGa5w.AZOQYO {
    @Override // ItGa5w.AZOQYO
    public final void A5SV6n(Object obj, Object obj2) {
        B7CMnp b7CMnp = (B7CMnp) obj;
        b7CMnp.getClass();
        ArrayDeque arrayDeque = B7CMnp.f3739A4TApA;
        synchronized (arrayDeque) {
            arrayDeque.offer(b7CMnp);
        }
    }
}
