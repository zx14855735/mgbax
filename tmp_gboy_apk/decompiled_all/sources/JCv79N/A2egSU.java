package JCv79N;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f4121AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f4122AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A2egSU f4123AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A2egSU f4124AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A2egSU f4125B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f4126B2KMhB;

    static {
        A2egSU a2egSU = new A2egSU("NO_VALUE", 0);
        f4121AcNBzu = a2egSU;
        A2egSU a2egSU2 = new A2egSU("AD_UNION_EXCITATION", 1);
        f4122AlLFFp = a2egSU2;
        A2egSU a2egSU3 = new A2egSU("AD_UNION_INSERT", 2);
        f4123AmA8tU = a2egSU3;
        A2egSU a2egSU4 = new A2egSU("AD_UNION_FEED", 3);
        f4124AzWtSf = a2egSU4;
        A2egSU a2egSU5 = new A2egSU("AD_UNION_DRAW", 4);
        f4125B25kr6 = a2egSU5;
        f4126B2KMhB = new A2egSU[]{a2egSU, a2egSU2, a2egSU3, a2egSU4, a2egSU5};
        PRMg();
    }

    private static /* synthetic */ void PRMg() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f4126B2KMhB.clone();
    }

    public final String A2egSU() {
        return name().toLowerCase();
    }
}
