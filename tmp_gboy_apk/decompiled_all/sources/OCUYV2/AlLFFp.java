package OCUYV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f6257A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6258A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final List f6259A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6260ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f6261ARc23Z;

    public AlLFFp(float f, ArrayList arrayList, int i, int i2, int i3) {
        this.f6257A2egSU = f;
        this.f6259A5SV6n = Collections.unmodifiableList(arrayList);
        this.f6260ADYaiT = i;
        this.AMqCpz = i2;
        while (i <= i2) {
            if (((AcNBzu) arrayList.get(i)).f6254ARc23Z == 0.0f) {
                this.f6258A4TApA++;
            }
            i++;
        }
        this.f6261ARc23Z = i3;
    }

    public final AcNBzu A2egSU() {
        return (AcNBzu) this.f6259A5SV6n.get(this.f6260ADYaiT);
    }

    public final AcNBzu A4TApA() {
        return (AcNBzu) this.f6259A5SV6n.get(0);
    }

    public final AcNBzu A5SV6n() {
        return (AcNBzu) this.f6259A5SV6n.get(this.AMqCpz);
    }

    public final AcNBzu ADYaiT() {
        return (AcNBzu) J3FDQU.A2egSU.AlLFFp(this.f6259A5SV6n, 1);
    }
}
