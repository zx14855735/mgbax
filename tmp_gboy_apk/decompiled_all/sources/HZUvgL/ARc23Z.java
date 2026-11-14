package HZUvgL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements A2egSU {
    @Override // HZUvgL.A2egSU
    public final int A2egSU() {
        return 1;
    }

    @Override // HZUvgL.A2egSU
    public final int A4TApA(Object obj) {
        return ((byte[]) obj).length;
    }

    @Override // HZUvgL.A2egSU
    public final String getTag() {
        return "ByteArrayPool";
    }

    @Override // HZUvgL.A2egSU
    public final Object newArray(int i) {
        return new byte[i];
    }
}
