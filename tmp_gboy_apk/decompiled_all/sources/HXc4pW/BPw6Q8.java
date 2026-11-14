package HXc4pW;

import ADYaiT.DUi7mC;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 implements BTvldC, Ixu71n.A4TApA {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final DUi7mC f3623B25kr6 = Ixu71n.A5SV6n.A2egSU(20, new ADYaiT.BmvVmW(28));

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Ixu71n.ADYaiT f3624AcNBzu = new Ixu71n.ADYaiT();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BTvldC f3625AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f3626AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f3627AzWtSf;

    static {
        wCDo();
    }

    private static /* synthetic */ void wCDo() {
        char[] charArray = "<02q8>2:q=0&q,7:33q\u001516\u001d-6;8:".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '_');
        }
        String str = new String(charArray);
        char[] charArray2 = "<3616+".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '_');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HXc4pW.BTvldC
    public final synchronized void A2egSU() {
        this.f3624AcNBzu.A2egSU();
        this.f3627AzWtSf = true;
        if (!this.f3626AmA8tU) {
            this.f3625AlLFFp.A2egSU();
            this.f3625AlLFFp = null;
            f3623B25kr6.B7CMnp(this);
        }
    }

    @Override // HXc4pW.BTvldC
    public final Class A4TApA() {
        return this.f3625AlLFFp.A4TApA();
    }

    public final synchronized void A5SV6n() {
        this.f3624AcNBzu.A2egSU();
        if (!this.f3626AmA8tU) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f3626AmA8tU = false;
        if (this.f3627AzWtSf) {
            A2egSU();
        }
    }

    @Override // Ixu71n.A4TApA
    public final Ixu71n.ADYaiT ADYaiT() {
        return this.f3624AcNBzu;
    }

    @Override // HXc4pW.BTvldC
    public final Object get() {
        return this.f3625AlLFFp.get();
    }

    @Override // HXc4pW.BTvldC
    public final int getSize() {
        return this.f3625AlLFFp.getSize();
    }
}
