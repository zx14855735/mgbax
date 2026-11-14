package Ifhupb;

import HSHyT0.B2KMhB;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3980A2egSU = new ArrayList();

    public final synchronized B2KMhB A2egSU(Class cls) {
        int size = this.f3980A2egSU.size();
        for (int i = 0; i < size; i++) {
            AYUAbz aYUAbz = (AYUAbz) this.f3980A2egSU.get(i);
            if (aYUAbz.f3978A2egSU.isAssignableFrom(cls)) {
                return aYUAbz.f3979A4TApA;
            }
        }
        return null;
    }
}
