package Mm8v1u;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final ASJ6gh f5488AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final ASJ6gh f5489AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final ASJ6gh f5490AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final ASJ6gh f5491AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final /* synthetic */ ASJ6gh[] f5492B25kr6;

    static {
        ASJ6gh aSJ6gh = new ASJ6gh("CENTER_CROP", 0);
        f5488AcNBzu = aSJ6gh;
        ASJ6gh aSJ6gh2 = new ASJ6gh("CENTER_INSIDE", 1);
        f5489AlLFFp = aSJ6gh2;
        ASJ6gh aSJ6gh3 = new ASJ6gh("FIT_XY", 2);
        f5490AmA8tU = aSJ6gh3;
        ASJ6gh aSJ6gh4 = new ASJ6gh("ORIGINAL", 3);
        f5491AzWtSf = aSJ6gh4;
        f5492B25kr6 = new ASJ6gh[]{aSJ6gh, aSJ6gh2, aSJ6gh3, aSJ6gh4};
        QmQZNHf();
    }

    private static /* synthetic */ void QmQZNHf() {
        char[] charArray = "\u0081\u008d\u008fÌ\u0085\u0083\u008f\u0087Ì\u0080\u008d\u009bÌ\u0091\u008a\u0087\u008e\u008eÌ¨\u008c\u008b \u0090\u008b\u0086\u0085\u0087".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 226);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0081\u008e\u008b\u008c\u008b\u0096".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 226);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ASJ6gh valueOf(String str) {
        return (ASJ6gh) Enum.valueOf(ASJ6gh.class, str);
    }

    public static ASJ6gh[] values() {
        return (ASJ6gh[]) f5492B25kr6.clone();
    }
}
