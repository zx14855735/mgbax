package OLy1FW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final byte f6336A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final byte f6337A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final short f6338A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f6339ADYaiT;
    public final int AMqCpz;

    public A2egSU(int i, int i2, String str) {
        this.f6339ADYaiT = str;
        this.AMqCpz = i2;
        this.f6338A5SV6n = (short) (65535 & i);
        this.f6337A4TApA = (byte) ((i >> 16) & 255);
        this.f6336A2egSU = (byte) ((i >> 24) & 255);
    }
}
