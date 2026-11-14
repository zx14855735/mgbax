package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final AmA8tU f8977AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final AmA8tU f8978AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final AmA8tU f8979AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final AmA8tU f8980AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final AmA8tU f8981B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final /* synthetic */ AmA8tU[] f8982B2KMhB;

    static {
        AmA8tU amA8tU = new AmA8tU("DESTROYED", 0);
        f8977AcNBzu = amA8tU;
        AmA8tU amA8tU2 = new AmA8tU("INITIALIZED", 1);
        f8978AlLFFp = amA8tU2;
        AmA8tU amA8tU3 = new AmA8tU("CREATED", 2);
        f8979AmA8tU = amA8tU3;
        AmA8tU amA8tU4 = new AmA8tU("STARTED", 3);
        f8980AzWtSf = amA8tU4;
        AmA8tU amA8tU5 = new AmA8tU("RESUMED", 4);
        f8981B25kr6 = amA8tU5;
        f8982B2KMhB = new AmA8tU[]{amA8tU, amA8tU2, amA8tU3, amA8tU4, amA8tU5};
        YkeZ();
    }

    private static /* synthetic */ void YkeZ() {
        char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 222);
        }
        String str = new String(charArray);
        char[] charArray2 = "½²·°·ª".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 222);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AmA8tU valueOf(String str) {
        return (AmA8tU) Enum.valueOf(AmA8tU.class, str);
    }

    public static AmA8tU[] values() {
        return (AmA8tU[]) f8982B2KMhB.clone();
    }
}
