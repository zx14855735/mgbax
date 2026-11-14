package GTPRn3;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f3056AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f3057AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A2egSU f3058AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A2egSU f3059AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A2egSU f3060B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f3061B2KMhB;

    static {
        A2egSU a2egSU = new A2egSU("START", 0);
        f3056AcNBzu = a2egSU;
        A2egSU a2egSU2 = new A2egSU("RESUME", 1);
        f3057AlLFFp = a2egSU2;
        A2egSU a2egSU3 = new A2egSU("PAUSE", 2);
        f3058AmA8tU = a2egSU3;
        A2egSU a2egSU4 = new A2egSU("STOP", 3);
        f3059AzWtSf = a2egSU4;
        A2egSU a2egSU5 = new A2egSU("DESTROY", 4);
        f3060B25kr6 = a2egSU5;
        f3061B2KMhB = new A2egSU[]{a2egSU, a2egSU2, a2egSU3, a2egSU4, a2egSU5};
        yaqLtYE();
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f3061B2KMhB.clone();
    }

    private static /* synthetic */ void yaqLtYE() {
        char[] charArray = "48:y06:2y58.y$?2;;y\u001d9>\u0015%>302".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'W');
        }
        String str = new String(charArray);
        char[] charArray2 = "4;>9>#".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'W');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
