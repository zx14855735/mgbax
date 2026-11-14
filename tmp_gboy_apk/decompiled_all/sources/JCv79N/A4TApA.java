package JCv79N;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A4TApA f4127AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A4TApA f4128AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A4TApA f4129AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final /* synthetic */ A4TApA[] f4130AzWtSf;

    static {
        A4TApA a4TApA = new A4TApA("NO_VALUE", 0);
        f4127AcNBzu = a4TApA;
        A4TApA a4TApA2 = new A4TApA("VIDEO_CELL", 1);
        A4TApA a4TApA3 = new A4TApA("VIDEO_HEAD", 2);
        A4TApA a4TApA4 = new A4TApA("LIVE_CELL", 3);
        f4128AlLFFp = a4TApA4;
        A4TApA a4TApA5 = new A4TApA("LIVE_CARD", 4);
        f4129AmA8tU = a4TApA5;
        f4130AzWtSf = new A4TApA[]{a4TApA, a4TApA2, a4TApA3, a4TApA4, a4TApA5};
        KOfSV();
    }

    private static /* synthetic */ void KOfSV() {
        char[] charArray = "\u0085\u0089\u008bÈ\u0081\u0087\u008b\u0083È\u0084\u0089\u009fÈ\u0095\u008e\u0083\u008a\u008aÈ¬\u0088\u008f¤\u0094\u008f\u0082\u0081\u0083".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 230);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0085\u008a\u008f\u0088\u008f\u0092".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 230);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A4TApA valueOf(String str) {
        return (A4TApA) Enum.valueOf(A4TApA.class, str);
    }

    public static A4TApA[] values() {
        return (A4TApA[]) f4130AzWtSf.clone();
    }
}
