package HSHyT0;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f3457AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f3458AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A2egSU f3459AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f3460AzWtSf;

    static {
        A2egSU a2egSU = new A2egSU("PREFER_ARGB_8888", 0);
        f3457AcNBzu = a2egSU;
        A2egSU a2egSU2 = new A2egSU("PREFER_RGB_565", 1);
        f3458AlLFFp = a2egSU2;
        f3460AzWtSf = new A2egSU[]{a2egSU, a2egSU2};
        f3459AmA8tU = a2egSU;
        SMnz();
    }

    private static /* synthetic */ void SMnz() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f3460AzWtSf.clone();
    }
}
