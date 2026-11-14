package QJCbnW;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f7465AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f7466AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f7467AmA8tU;

    static {
        A2egSU a2egSU = new A2egSU("ALWAYS", 0);
        f7465AcNBzu = a2egSU;
        A2egSU a2egSU2 = new A2egSU("LAST", 1);
        f7466AlLFFp = a2egSU2;
        f7467AmA8tU = new A2egSU[]{a2egSU, a2egSU2};
        WWweA();
    }

    private static /* synthetic */ void WWweA() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f7467AmA8tU.clone();
    }
}
