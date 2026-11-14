package RLgVYi;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f7865AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f7866AlLFFp;

    static {
        A2egSU a2egSU = new A2egSU("COROUTINE_SUSPENDED", 0);
        f7865AcNBzu = a2egSU;
        f7866AlLFFp = new A2egSU[]{a2egSU, new A2egSU("UNDECIDED", 1), new A2egSU("RESUMED", 2)};
        DGxJ();
    }

    private static /* synthetic */ void DGxJ() {
        char[] charArray = "KGE\u0006OIEM\u0006JGQ\u0006[@MDD\u0006bFAjZALOM".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '(');
        }
        String str = new String(charArray);
        char[] charArray2 = "KDAFA\\".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '(');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f7866AlLFFp.clone();
    }
}
