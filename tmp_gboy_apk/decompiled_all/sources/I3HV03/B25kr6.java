package I3HV03;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 extends B2KMhB {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final /* synthetic */ int f3825AYUAbz;

    @Override // I3HV03.B2KMhB
    public final int A2egSU(int i, int i2, int i3, int i4) {
        switch (this.f3825AYUAbz) {
            case 2:
                if (A4TApA(i, i2, i3, i4) != 1.0f) {
                    break;
                }
                break;
            case 4:
                if (B2KMhB.f3831ASJ6gh) {
                }
                break;
        }
        return 2;
    }

    @Override // I3HV03.B2KMhB
    public final float A4TApA(int i, int i2, int i3, int i4) {
        switch (this.f3825AYUAbz) {
            case 0:
                if (Math.min(i2 / i4, i / i3) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            case 1:
                int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
                return 1.0f / (r3 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
            case 2:
                return Math.min(1.0f, B2KMhB.f3826A2egSU.A4TApA(i, i2, i3, i4));
            case 3:
                return Math.max(i3 / i, i4 / i2);
            case 4:
                if (B2KMhB.f3831ASJ6gh) {
                    return Math.min(i3 / i, i4 / i2);
                }
                if (Math.max(i2 / i4, i / i3) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
