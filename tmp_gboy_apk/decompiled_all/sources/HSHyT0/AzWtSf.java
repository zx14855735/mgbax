package HSHyT0;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final AzWtSf f3471AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final AzWtSf f3472AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final /* synthetic */ AzWtSf[] f3473AmA8tU;

    static {
        AzWtSf azWtSf = new AzWtSf("SRGB", 0);
        f3471AcNBzu = azWtSf;
        AzWtSf azWtSf2 = new AzWtSf("DISPLAY_P3", 1);
        f3472AlLFFp = azWtSf2;
        f3473AmA8tU = new AzWtSf[]{azWtSf, azWtSf2};
        kBWeTsQ();
    }

    private static /* synthetic */ void kBWeTsQ() {
        char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 1);
        }
        String str = new String(charArray);
        char[] charArray2 = "bmhohu".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 1);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AzWtSf valueOf(String str) {
        return (AzWtSf) Enum.valueOf(AzWtSf.class, str);
    }

    public static AzWtSf[] values() {
        return (AzWtSf[]) f3473AmA8tU.clone();
    }
}
