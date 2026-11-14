package RXb0Sz;

import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A4TApA implements RiEDdo.A2egSU, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public transient RiEDdo.A2egSU f7881AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f7882AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Class f7883AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final String f7884AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final String f7885B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final boolean f7886B2KMhB;

    public A4TApA() {
        this(A2egSU.f7880AcNBzu, null, null, null, false);
    }

    public RiEDdo.A2egSU A2egSU() {
        RiEDdo.A2egSU a2egSU = this.f7881AcNBzu;
        if (a2egSU != null) {
            return a2egSU;
        }
        RiEDdo.A2egSU A4TApA2 = A4TApA();
        this.f7881AcNBzu = A4TApA2;
        return A4TApA2;
    }

    public abstract RiEDdo.A2egSU A4TApA();

    public final A5SV6n A5SV6n() {
        Class cls = this.f7883AmA8tU;
        if (cls == null) {
            return null;
        }
        if (this.f7886B2KMhB) {
            AZOQYO.f7892A2egSU.getClass();
            return new AYUAbz(cls);
        }
        AZOQYO.f7892A2egSU.getClass();
        return new ADYaiT(cls);
    }

    public RiEDdo.A2egSU ADYaiT() {
        RiEDdo.A2egSU A2egSU2 = A2egSU();
        if (A2egSU2 != this) {
            return A2egSU2;
        }
        throw new RVj4XZ.A2egSU();
    }

    @Override // RiEDdo.A2egSU
    public Object call(Object... objArr) {
        return ADYaiT().call(objArr);
    }

    public A4TApA(Object obj, Class cls, String str, String str2, boolean z) {
        this.f7882AlLFFp = obj;
        this.f7883AmA8tU = cls;
        this.f7884AzWtSf = str;
        this.f7885B25kr6 = str2;
        this.f7886B2KMhB = z;
    }
}
