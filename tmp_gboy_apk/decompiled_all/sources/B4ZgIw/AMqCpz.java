package B4ZgIw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object[] f1071A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1072A4TApA;

    public AMqCpz(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1071A2egSU = new Object[i];
    }

    public Object A2egSU() {
        int i = this.f1072A4TApA;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f1071A2egSU;
        Object obj = objArr[i2];
        RXb0Sz.ARc23Z.A5SV6n(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i2] = null;
        this.f1072A4TApA--;
        return obj;
    }

    public void A4TApA(A4TApA a4TApA) {
        int i = this.f1072A4TApA;
        Object[] objArr = this.f1071A2egSU;
        if (i < objArr.length) {
            objArr[i] = a4TApA;
            this.f1072A4TApA = i + 1;
        }
    }

    public boolean A5SV6n(Object obj) {
        Object[] objArr;
        boolean z;
        RXb0Sz.ARc23Z.AMqCpz(obj, "instance");
        int i = this.f1072A4TApA;
        int i2 = 0;
        while (true) {
            objArr = this.f1071A2egSU;
            if (i2 >= i) {
                z = false;
                break;
            }
            if (objArr[i2] == obj) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.f1072A4TApA;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.f1072A4TApA = i3 + 1;
        return true;
    }

    public AMqCpz() {
        this.f1071A2egSU = new Object[256];
    }
}
