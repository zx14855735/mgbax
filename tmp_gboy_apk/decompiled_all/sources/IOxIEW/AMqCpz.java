package IOxIEW;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3930A2egSU = new ArrayList();

    public final synchronized A5SV6n A2egSU(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return ARc23Z.f3931AcNBzu;
        }
        Iterator it = this.f3930A2egSU.iterator();
        while (it.hasNext()) {
            ADYaiT aDYaiT = (ADYaiT) it.next();
            if (aDYaiT.f3927A2egSU.isAssignableFrom(cls) && cls2.isAssignableFrom(aDYaiT.f3928A4TApA)) {
                return aDYaiT.f3929A5SV6n;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized ArrayList A4TApA(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f3930A2egSU.iterator();
        while (it.hasNext()) {
            ADYaiT aDYaiT = (ADYaiT) it.next();
            if (aDYaiT.f3927A2egSU.isAssignableFrom(cls) && cls2.isAssignableFrom(aDYaiT.f3928A4TApA)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
