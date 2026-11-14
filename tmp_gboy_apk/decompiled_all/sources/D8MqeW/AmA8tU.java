package D8MqeW;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends RD2OKB.A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f2027AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f2028AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final RFbdkT.A5SV6n f2029AmA8tU;

    public AmA8tU(AaHO0E aaHO0E, RFbdkT.A5SV6n a5SV6n, ArrayList arrayList, B25kr6.AaHO0E aaHO0E2) {
        if (aaHO0E2.f1000A4TApA != arrayList.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        }
        int i = aaHO0E2.f1000A4TApA;
        if (i == 0) {
            throw new NoSuchElementException("FloatList is empty.");
        }
        float[] fArr = aaHO0E2.f999A2egSU;
        int i2 = 0;
        float f = 0.0f;
        if (fArr[0] != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        }
        if (i == 0) {
            throw new NoSuchElementException("FloatList is empty.");
        }
        if (fArr[i - 1] != 1.0f) {
            throw new IllegalArgumentException("Last outline progress value is expected to be one");
        }
        this.f2027AcNBzu = aaHO0E;
        this.f2029AmA8tU = a5SV6n;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i2 < size) {
            int i3 = i2 + 1;
            if (aaHO0E2.A4TApA(i3) - aaHO0E2.A4TApA(i2) > 1.0E-4f) {
                arrayList2.add(new AlLFFp(this, (A4TApA) arrayList.get(i2), f, aaHO0E2.A4TApA(i3)));
                f = aaHO0E2.A4TApA(i3);
            }
            i2 = i3;
        }
        AlLFFp alLFFp = (AlLFFp) arrayList2.get(RD2OKB.AaHO0E.ADYaiT(arrayList2));
        float f2 = alLFFp.f2025A5SV6n;
        if (1.0f < f2) {
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }
        alLFFp.f2025A5SV6n = f2;
        alLFFp.f2026ADYaiT = 1.0f;
        this.f2028AlLFFp = arrayList2;
    }

    @Override // RD2OKB.A5SV6n
    public final int A2egSU() {
        return this.f2028AlLFFp.size();
    }

    @Override // RD2OKB.A5SV6n, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof AlLFFp) {
            return super.contains((AlLFFp) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return (AlLFFp) this.f2028AlLFFp.get(i);
    }

    @Override // RD2OKB.A5SV6n, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof AlLFFp) {
            return super.indexOf((AlLFFp) obj);
        }
        return -1;
    }

    @Override // RD2OKB.A5SV6n, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof AlLFFp) {
            return super.lastIndexOf((AlLFFp) obj);
        }
        return -1;
    }
}
