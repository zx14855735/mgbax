package IzHBwY;

import android.util.SparseArray;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ADYaiT f4110A4TApA = A5SV6n(0).A2egSU();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AMqCpz f4111A5SV6n = new AMqCpz();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final A5SV6n f4112ADYaiT = new A5SV6n(0);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseArray f4113A2egSU;

    static {
        FBld();
    }

    public ARc23Z(SparseArray sparseArray) {
        this.f4113A2egSU = sparseArray == null ? new SparseArray() : sparseArray;
    }

    public static final ARc23Z A4TApA() {
        return new ARc23Z(new SparseArray());
    }

    public static final ARc23Z A5SV6n(int i) {
        return new ARc23Z(new SparseArray(i));
    }

    private static /* synthetic */ void FBld() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final ADYaiT A2egSU() {
        return new ADYaiT(this.f4113A2egSU);
    }

    public final void ADYaiT(int i, int i2) {
        this.f4113A2egSU.put(i, Integer.valueOf(i2));
    }

    public final void AMqCpz(int i, Object obj) {
        this.f4113A2egSU.put(i, obj);
    }

    public final void ARc23Z(int i, String str) {
        this.f4113A2egSU.put(i, str);
    }

    public final void ASJ6gh(int i, boolean z) {
        this.f4113A2egSU.put(i, Boolean.valueOf(z));
    }
}
