package OCUYV2;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f6242A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6243A4TApA;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AcNBzu f6245ADYaiT;
    public AcNBzu AMqCpz;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f6244A5SV6n = new ArrayList();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6246ARc23Z = -1;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f6247ASJ6gh = -1;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f6248AYUAbz = 0.0f;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f6249AZOQYO = -1;

    public AaHO0E(float f, int i) {
        this.f6242A2egSU = f;
        this.f6243A4TApA = i;
    }

    public final void A2egSU(float f, float f2, float f3, boolean z, boolean z2) {
        float f4;
        float abs;
        float f5 = f3 / 2.0f;
        float f6 = f - f5;
        float f7 = f5 + f;
        float f8 = this.f6243A4TApA;
        if (f7 > f8) {
            abs = Math.abs(f7 - Math.max(f7 - f3, f8));
        } else {
            if (f6 >= 0.0f) {
                f4 = 0.0f;
                A4TApA(f, f2, f3, z, z2, f4, 0.0f, 0.0f);
            }
            abs = Math.abs(f6 - Math.min(f6 + f3, 0.0f));
        }
        f4 = abs;
        A4TApA(f, f2, f3, z, z2, f4, 0.0f, 0.0f);
    }

    public final void A4TApA(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, float f6) {
        if (f3 <= 0.0f) {
            return;
        }
        ArrayList arrayList = this.f6244A5SV6n;
        if (z2) {
            if (z) {
                throw new IllegalArgumentException("Anchor keylines cannot be focal.");
            }
            int i = this.f6249AZOQYO;
            if (i != -1 && i != 0) {
                throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
            }
            this.f6249AZOQYO = arrayList.size();
        }
        AcNBzu acNBzu = new AcNBzu(Float.MIN_VALUE, f, f2, f3, z2, f4, f5, f6);
        if (z) {
            if (this.f6245ADYaiT == null) {
                this.f6245ADYaiT = acNBzu;
                this.f6246ARc23Z = arrayList.size();
            }
            if (this.f6247ASJ6gh != -1 && arrayList.size() - this.f6247ASJ6gh > 1) {
                throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
            }
            if (f3 != this.f6245ADYaiT.f6253ADYaiT) {
                throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
            }
            this.AMqCpz = acNBzu;
            this.f6247ASJ6gh = arrayList.size();
        } else {
            if (this.f6245ADYaiT == null && f3 < this.f6248AYUAbz) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            }
            if (this.AMqCpz != null && f3 > this.f6248AYUAbz) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
        }
        this.f6248AYUAbz = f3;
        arrayList.add(acNBzu);
    }

    public final void A5SV6n(float f, float f2, float f3, int i, boolean z) {
        if (i <= 0 || f3 <= 0.0f) {
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            float f4 = f2;
            float f5 = f3;
            boolean z2 = z;
            A2egSU((i2 * f3) + f, f4, f5, z2, false);
            i2++;
            f2 = f4;
            f3 = f5;
            z = z2;
        }
    }

    public final AlLFFp ADYaiT() {
        if (this.f6245ADYaiT == null) {
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            ArrayList arrayList2 = this.f6244A5SV6n;
            if (i >= arrayList2.size()) {
                return new AlLFFp(this.f6242A2egSU, arrayList, this.f6246ARc23Z, this.f6247ASJ6gh, this.f6243A4TApA);
            }
            AcNBzu acNBzu = (AcNBzu) arrayList2.get(i);
            float f = this.f6245ADYaiT.f6251A4TApA;
            float f2 = this.f6246ARc23Z;
            float f3 = this.f6242A2egSU;
            arrayList.add(new AcNBzu((i * f3) + (f - (f2 * f3)), acNBzu.f6251A4TApA, acNBzu.f6252A5SV6n, acNBzu.f6253ADYaiT, acNBzu.AMqCpz, acNBzu.f6254ARc23Z, acNBzu.f6255ASJ6gh, acNBzu.f6256AYUAbz));
            i++;
        }
    }
}
