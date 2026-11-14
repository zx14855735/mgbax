package HXc4pW;

import ADYaiT.DUi7mC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DUi7mC f3620A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final List f3621A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f3622A5SV6n;

    public BNL6CD(Class cls, Class cls2, Class cls3, List list, DUi7mC dUi7mC) {
        this.f3620A2egSU = dUi7mC;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f3621A4TApA = list;
        this.f3622A5SV6n = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final BTvldC A2egSU(int i, int i2, C4FrIb.AmA8tU amA8tU, HSHyT0.AmA8tU amA8tU2, com.bumptech.glide.load.data.ASJ6gh aSJ6gh) {
        DUi7mC dUi7mC = this.f3620A2egSU;
        List list = (List) dUi7mC.AYUAbz();
        try {
            List list2 = this.f3621A4TApA;
            int size = list2.size();
            BTvldC bTvldC = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    bTvldC = ((AaHO0E) list2.get(i3)).A2egSU(i, i2, amA8tU, amA8tU2, aSJ6gh);
                } catch (BI9f7h e) {
                    list.add(e);
                }
                if (bTvldC != null) {
                    break;
                }
            }
            if (bTvldC != null) {
                return bTvldC;
            }
            throw new BI9f7h(this.f3622A5SV6n, new ArrayList(list));
        } finally {
            dUi7mC.B7CMnp(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f3621A4TApA.toArray()) + '}';
    }
}
