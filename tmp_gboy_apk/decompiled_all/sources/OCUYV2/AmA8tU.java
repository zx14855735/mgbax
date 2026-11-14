package OCUYV2;

import ADYaiT.CtFAbx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AlLFFp f6262A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final List f6263A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final List f6264A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float[] f6265ADYaiT;
    public final float[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f6266ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6267ASJ6gh;

    public AmA8tU(AlLFFp alLFFp, ArrayList arrayList, ArrayList arrayList2) {
        this.f6262A2egSU = alLFFp;
        this.f6263A4TApA = Collections.unmodifiableList(arrayList);
        this.f6264A5SV6n = Collections.unmodifiableList(arrayList2);
        float f = ((AlLFFp) CtFAbx.ADYaiT(arrayList, 1)).A4TApA().f6250A2egSU - alLFFp.A4TApA().f6250A2egSU;
        this.f6266ARc23Z = f;
        float f2 = alLFFp.ADYaiT().f6250A2egSU - ((AlLFFp) CtFAbx.ADYaiT(arrayList2, 1)).ADYaiT().f6250A2egSU;
        this.f6267ASJ6gh = f2;
        this.f6265ADYaiT = ADYaiT(f, arrayList, true);
        this.AMqCpz = ADYaiT(f2, arrayList2, false);
    }

    public static float[] ADYaiT(float f, ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            AlLFFp alLFFp = (AlLFFp) arrayList.get(i2);
            AlLFFp alLFFp2 = (AlLFFp) arrayList.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i2] + ((z ? alLFFp2.A4TApA().f6250A2egSU - alLFFp.A4TApA().f6250A2egSU : alLFFp.ADYaiT().f6250A2egSU - alLFFp2.ADYaiT().f6250A2egSU) / f);
            i++;
        }
        return fArr;
    }

    public static float[] AMqCpz(List list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, f2, f3, f), i - 1, i};
            }
            i++;
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static AlLFFp ARc23Z(AlLFFp alLFFp, int i, int i2, float f, int i3, int i4, int i5) {
        ArrayList arrayList = new ArrayList(alLFFp.f6259A5SV6n);
        arrayList.add(i2, (AcNBzu) arrayList.remove(i));
        AaHO0E aaHO0E = new AaHO0E(alLFFp.f6257A2egSU, i5);
        float f2 = f;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            AcNBzu acNBzu = (AcNBzu) arrayList.get(i6);
            float f3 = acNBzu.f6253ADYaiT;
            aaHO0E.A4TApA((f3 / 2.0f) + f2, acNBzu.f6252A5SV6n, f3, i6 >= i3 && i6 <= i4, acNBzu.AMqCpz, acNBzu.f6254ARc23Z, 0.0f, 0.0f);
            f2 += acNBzu.f6253ADYaiT;
            i6++;
        }
        return aaHO0E.ADYaiT();
    }

    public static AlLFFp ASJ6gh(AlLFFp alLFFp, float f, int i, boolean z, float f2) {
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(1);
        int i2 = alLFFp.AMqCpz;
        int i3 = alLFFp.f6260ADYaiT;
        float f3 = alLFFp.f6257A2egSU;
        List list = alLFFp.f6259A5SV6n;
        float f4 = 2.0f;
        if (ADYaiT2 != 0) {
            ArrayList arrayList = new ArrayList(list);
            AaHO0E aaHO0E = new AaHO0E(f3, i);
            int size = z ? 0 : arrayList.size() - 1;
            int i4 = 0;
            while (i4 < arrayList.size()) {
                AcNBzu acNBzu = (AcNBzu) arrayList.get(i4);
                boolean z2 = acNBzu.AMqCpz;
                if (z2 && i4 == size) {
                    aaHO0E.A4TApA(acNBzu.f6251A4TApA, acNBzu.f6252A5SV6n, acNBzu.f6253ADYaiT, false, true, acNBzu.f6254ARc23Z, 0.0f, 0.0f);
                } else {
                    float f5 = acNBzu.f6251A4TApA;
                    float f6 = z ? f5 + f : f5 - f;
                    float f7 = z ? f : 0.0f;
                    float f8 = z ? 0.0f : f;
                    boolean z3 = i4 >= i3 && i4 <= i2;
                    float f9 = acNBzu.f6253ADYaiT;
                    aaHO0E.A4TApA(f6, acNBzu.f6252A5SV6n, f9, z3, z2, Math.abs(z ? Math.max(0.0f, ((f9 / 2.0f) + f6) - i) : Math.min(0.0f, f6 - (f9 / 2.0f))), f7, f8);
                }
                i4++;
            }
            return aaHO0E.ADYaiT();
        }
        ArrayList arrayList2 = new ArrayList(list);
        AaHO0E aaHO0E2 = new AaHO0E(f3, i);
        Iterator it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((AcNBzu) it.next()).AMqCpz) {
                i5++;
            }
        }
        float size2 = f / (list.size() - i5);
        float f10 = z ? f : 0.0f;
        int i6 = 0;
        while (i6 < arrayList2.size()) {
            AcNBzu acNBzu2 = (AcNBzu) arrayList2.get(i6);
            if (acNBzu2.AMqCpz) {
                aaHO0E2.A4TApA(acNBzu2.f6251A4TApA, acNBzu2.f6252A5SV6n, acNBzu2.f6253ADYaiT, false, true, acNBzu2.f6254ARc23Z, 0.0f, 0.0f);
            } else {
                boolean z4 = i6 >= i3 && i6 <= i2;
                float f11 = acNBzu2.f6253ADYaiT - size2;
                float A4TApA2 = AZOQYO.A4TApA(f11, f3, f2);
                float f12 = (f11 / f4) + f10;
                float abs = Math.abs(f12 - acNBzu2.f6251A4TApA);
                aaHO0E2.A4TApA(f12, A4TApA2, f11, z4, false, acNBzu2.f6254ARc23Z, z ? abs : 0.0f, z ? 0.0f : abs);
                f10 += f11;
            }
            i6++;
            f4 = 2.0f;
        }
        return aaHO0E2.ADYaiT();
    }

    public final AlLFFp A2egSU() {
        return (AlLFFp) J3FDQU.A2egSU.AlLFFp(this.f6264A5SV6n, 1);
    }

    public final AlLFFp A4TApA(float f, float f2, float f3, boolean z) {
        float A4TApA2;
        List list;
        float[] fArr;
        float f4 = this.f6266ARc23Z;
        float f5 = f2 + f4;
        float f6 = this.f6267ASJ6gh;
        float f7 = f3 - f6;
        float f8 = A5SV6n().A2egSU().f6255ASJ6gh;
        float f9 = A2egSU().A2egSU().f6256AYUAbz;
        if (f4 == f8) {
            f5 += f8;
        }
        if (f6 == f9) {
            f7 -= f9;
        }
        if (f < f5) {
            A4TApA2 = NdEzCJ.A2egSU.A4TApA(1.0f, 0.0f, f2, f5, f);
            list = this.f6263A4TApA;
            fArr = this.f6265ADYaiT;
        } else {
            if (f <= f7) {
                return this.f6262A2egSU;
            }
            A4TApA2 = NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, f7, f3, f);
            list = this.f6264A5SV6n;
            fArr = this.AMqCpz;
        }
        if (z) {
            float[] AMqCpz = AMqCpz(list, A4TApA2, fArr);
            return AMqCpz[0] >= 0.5f ? (AlLFFp) list.get((int) AMqCpz[2]) : (AlLFFp) list.get((int) AMqCpz[1]);
        }
        float[] AMqCpz2 = AMqCpz(list, A4TApA2, fArr);
        AlLFFp alLFFp = (AlLFFp) list.get((int) AMqCpz2[1]);
        AlLFFp alLFFp2 = (AlLFFp) list.get((int) AMqCpz2[2]);
        float f10 = AMqCpz2[0];
        if (alLFFp.f6257A2egSU != alLFFp2.f6257A2egSU) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List list2 = alLFFp.f6259A5SV6n;
        int size = list2.size();
        List list3 = alLFFp2.f6259A5SV6n;
        if (size != list3.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            AcNBzu acNBzu = (AcNBzu) list2.get(i);
            AcNBzu acNBzu2 = (AcNBzu) list3.get(i);
            arrayList.add(new AcNBzu(NdEzCJ.A2egSU.A2egSU(acNBzu.f6250A2egSU, acNBzu2.f6250A2egSU, f10), NdEzCJ.A2egSU.A2egSU(acNBzu.f6251A4TApA, acNBzu2.f6251A4TApA, f10), NdEzCJ.A2egSU.A2egSU(acNBzu.f6252A5SV6n, acNBzu2.f6252A5SV6n, f10), NdEzCJ.A2egSU.A2egSU(acNBzu.f6253ADYaiT, acNBzu2.f6253ADYaiT, f10), false, 0.0f, 0.0f, 0.0f));
        }
        return new AlLFFp(alLFFp.f6257A2egSU, arrayList, NdEzCJ.A2egSU.A5SV6n(f10, alLFFp.f6260ADYaiT, alLFFp2.f6260ADYaiT), NdEzCJ.A2egSU.A5SV6n(f10, alLFFp.AMqCpz, alLFFp2.AMqCpz), alLFFp.f6261ARc23Z);
    }

    public final AlLFFp A5SV6n() {
        return (AlLFFp) J3FDQU.A2egSU.AlLFFp(this.f6263A4TApA, 1);
    }
}
