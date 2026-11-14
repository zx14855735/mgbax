package CtxOCS;

import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1917A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ByteBuffer f1918A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1919A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f1920ADYaiT;

    public A5SV6n() {
        if (ADYaiT.f1921A2egSU == null) {
            ADYaiT.f1921A2egSU = new AMqCpz();
        }
    }

    public final int A2egSU(int i) {
        if (i < this.f1920ADYaiT) {
            return this.f1918A4TApA.getShort(this.f1919A5SV6n + i);
        }
        return 0;
    }
}
