package COJEAR;

import android.view.View;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class F32kj0 {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final FG7pZc f1744A4TApA = new EdQ5bb().f1721A2egSU.A4TApA().f1747A2egSU.A2egSU().f1747A2egSU.A4TApA().f1747A2egSU.A5SV6n();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final FG7pZc f1745A2egSU;

    static {
        AurJLpl();
    }

    public F32kj0(FG7pZc fG7pZc) {
        this.f1745A2egSU = fG7pZc;
    }

    private static /* synthetic */ void AurJLpl() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public FG7pZc A2egSU() {
        return this.f1745A2egSU;
    }

    public FG7pZc A4TApA() {
        return this.f1745A2egSU;
    }

    public FG7pZc A5SV6n() {
        return this.f1745A2egSU;
    }

    public void ADYaiT(View view) {
    }

    public AcNBzu AMqCpz() {
        return null;
    }

    public BV3sI0.A5SV6n ARc23Z(int i) {
        return BV3sI0.A5SV6n.AMqCpz;
    }

    public BV3sI0.A5SV6n ASJ6gh() {
        return AZkASS();
    }

    public BV3sI0.A5SV6n AYUAbz() {
        return BV3sI0.A5SV6n.AMqCpz;
    }

    public BV3sI0.A5SV6n AZOQYO() {
        return AZkASS();
    }

    public BV3sI0.A5SV6n AZkASS() {
        return BV3sI0.A5SV6n.AMqCpz;
    }

    public BV3sI0.A5SV6n AaHO0E() {
        return AZkASS();
    }

    public FG7pZc AcNBzu(int i, int i2, int i3, int i4) {
        return f1744A4TApA;
    }

    public boolean AlLFFp() {
        return false;
    }

    public boolean AmA8tU() {
        return false;
    }

    public void AzWtSf(BV3sI0.A5SV6n[] a5SV6nArr) {
    }

    public void B25kr6(FG7pZc fG7pZc) {
    }

    public void B2KMhB(BV3sI0.A5SV6n a5SV6n) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F32kj0)) {
            return false;
        }
        F32kj0 f32kj0 = (F32kj0) obj;
        return AmA8tU() == f32kj0.AmA8tU() && AlLFFp() == f32kj0.AlLFFp() && Objects.equals(AZkASS(), f32kj0.AZkASS()) && Objects.equals(AYUAbz(), f32kj0.AYUAbz()) && Objects.equals(AMqCpz(), f32kj0.AMqCpz());
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(AmA8tU()), Boolean.valueOf(AlLFFp()), AZkASS(), AYUAbz(), AMqCpz());
    }
}
