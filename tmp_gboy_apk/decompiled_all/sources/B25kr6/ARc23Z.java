package B25kr6;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long f986A2egSU;

    public static long A2egSU(float f, float f2) {
        return (Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ARc23Z) {
            return this.f986A2egSU == ((ARc23Z) obj).f986A2egSU;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f986A2egSU;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        long j = this.f986A2egSU;
        sb.append(Float.intBitsToFloat((int) (j >> 32)));
        sb.append(", ");
        sb.append(Float.intBitsToFloat((int) (j & 4294967295L)));
        sb.append(')');
        return sb.toString();
    }
}
