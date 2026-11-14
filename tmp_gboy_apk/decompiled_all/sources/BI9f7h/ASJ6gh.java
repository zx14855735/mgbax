package BI9f7h;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh extends ARc23Z {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1305AlLFFp;

    public ASJ6gh(B25kr6 b25kr6) {
        super(b25kr6);
        if (b25kr6 instanceof AcNBzu) {
            this.AMqCpz = 2;
        } else {
            this.AMqCpz = 3;
        }
    }

    @Override // BI9f7h.ARc23Z
    public final void A5SV6n(int i) {
        if (this.f1302AZkASS) {
            return;
        }
        this.f1302AZkASS = true;
        this.f1299ASJ6gh = i;
        Iterator it = this.f1303AaHO0E.iterator();
        while (it.hasNext()) {
            ADYaiT aDYaiT = (ADYaiT) it.next();
            aDYaiT.update(aDYaiT);
        }
    }
}
