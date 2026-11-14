package HZUvgL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements A2egSU {
    @Override // HZUvgL.A2egSU
    public final int A2egSU() {
        return 4;
    }

    @Override // HZUvgL.A2egSU
    public final int A4TApA(Object obj) {
        return ((int[]) obj).length;
    }

    @Override // HZUvgL.A2egSU
    public final String getTag() {
        return "IntegerArrayPool";
    }

    @Override // HZUvgL.A2egSU
    public final Object newArray(int i) {
        return new int[i];
    }
}
