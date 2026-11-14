package D6yqiO;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A4TApA f1997AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A4TApA f1998AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A4TApA f1999AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A4TApA f2000AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A4TApA f2001B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final A4TApA f2002B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final A4TApA f2003B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final /* synthetic */ A4TApA[] f2004B4ZgIw;

    /* JADX INFO: Fake field, exist only in values array */
    A4TApA EF9;

    static {
        A4TApA a4TApA = new A4TApA("PENALTY_LOG", 0);
        A4TApA a4TApA2 = new A4TApA("PENALTY_DEATH", 1);
        A4TApA a4TApA3 = new A4TApA("DETECT_FRAGMENT_REUSE", 2);
        f1997AcNBzu = a4TApA3;
        A4TApA a4TApA4 = new A4TApA("DETECT_FRAGMENT_TAG_USAGE", 3);
        f1998AlLFFp = a4TApA4;
        A4TApA a4TApA5 = new A4TApA("DETECT_WRONG_NESTED_HIERARCHY", 4);
        f1999AmA8tU = a4TApA5;
        A4TApA a4TApA6 = new A4TApA("DETECT_RETAIN_INSTANCE_USAGE", 5);
        f2000AzWtSf = a4TApA6;
        A4TApA a4TApA7 = new A4TApA("DETECT_SET_USER_VISIBLE_HINT", 6);
        f2001B25kr6 = a4TApA7;
        A4TApA a4TApA8 = new A4TApA("DETECT_TARGET_FRAGMENT_USAGE", 7);
        f2002B2KMhB = a4TApA8;
        A4TApA a4TApA9 = new A4TApA("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
        f2003B3GDIM = a4TApA9;
        f2004B4ZgIw = new A4TApA[]{a4TApA, a4TApA2, a4TApA3, a4TApA4, a4TApA5, a4TApA6, a4TApA7, a4TApA8, a4TApA9};
        bhuHj();
    }

    private static /* synthetic */ void bhuHj() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A4TApA valueOf(String str) {
        return (A4TApA) Enum.valueOf(A4TApA.class, str);
    }

    public static A4TApA[] values() {
        return (A4TApA[]) f2004B4ZgIw.clone();
    }
}
