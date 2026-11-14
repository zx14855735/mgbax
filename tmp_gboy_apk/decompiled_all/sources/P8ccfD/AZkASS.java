package P8ccfD;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final AZkASS f6975AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final AZkASS f6976AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final AZkASS f6977AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final AZkASS f6978AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final /* synthetic */ AZkASS[] f6979B25kr6;

    static {
        AZkASS aZkASS = new AZkASS("HIDING", 0);
        f6975AcNBzu = aZkASS;
        AZkASS aZkASS2 = new AZkASS("HIDDEN", 1);
        f6976AlLFFp = aZkASS2;
        AZkASS aZkASS3 = new AZkASS("SHOWING", 2);
        f6977AmA8tU = aZkASS3;
        AZkASS aZkASS4 = new AZkASS("SHOWN", 3);
        f6978AzWtSf = aZkASS4;
        f6979B25kr6 = new AZkASS[]{aZkASS, aZkASS2, aZkASS3, aZkASS4};
        gVoBZ();
    }

    private static /* synthetic */ void gVoBZ() {
        char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 212);
        }
        String str = new String(charArray);
        char[] charArray2 = "·¸½º½ ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 212);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AZkASS valueOf(String str) {
        return (AZkASS) Enum.valueOf(AZkASS.class, str);
    }

    public static AZkASS[] values() {
        return (AZkASS[]) f6979B25kr6.clone();
    }
}
