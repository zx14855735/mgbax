package BChYOn;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final ADYaiT f1114AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final ADYaiT f1115AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final ADYaiT f1116AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final ADYaiT f1117AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final ADYaiT f1118B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final ADYaiT f1119B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final ADYaiT f1120B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final ADYaiT f1121B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final /* synthetic */ ADYaiT[] f1122B7CMnp;

    /* JADX INFO: Fake field, exist only in values array */
    ADYaiT EF9;

    static {
        ADYaiT aDYaiT = new ADYaiT("NONE", 0);
        ADYaiT aDYaiT2 = new ADYaiT("LEFT", 1);
        f1114AcNBzu = aDYaiT2;
        ADYaiT aDYaiT3 = new ADYaiT("TOP", 2);
        f1115AlLFFp = aDYaiT3;
        ADYaiT aDYaiT4 = new ADYaiT("RIGHT", 3);
        f1116AmA8tU = aDYaiT4;
        ADYaiT aDYaiT5 = new ADYaiT("BOTTOM", 4);
        f1117AzWtSf = aDYaiT5;
        ADYaiT aDYaiT6 = new ADYaiT("BASELINE", 5);
        f1118B25kr6 = aDYaiT6;
        ADYaiT aDYaiT7 = new ADYaiT("CENTER", 6);
        f1119B2KMhB = aDYaiT7;
        ADYaiT aDYaiT8 = new ADYaiT("CENTER_X", 7);
        f1120B3GDIM = aDYaiT8;
        ADYaiT aDYaiT9 = new ADYaiT("CENTER_Y", 8);
        f1121B4ZgIw = aDYaiT9;
        f1122B7CMnp = new ADYaiT[]{aDYaiT, aDYaiT2, aDYaiT3, aDYaiT4, aDYaiT5, aDYaiT6, aDYaiT7, aDYaiT8, aDYaiT9};
        YoOqW();
    }

    private static /* synthetic */ void YoOqW() {
        char[] charArray = "ÓßÝ\u009e×ÑÝÕ\u009eÒßÉ\u009eÃØÕÜÜ\u009eúÞÙòÂÙÔ×Õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 176);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÓÜÙÞÙÄ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 176);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ADYaiT valueOf(String str) {
        return (ADYaiT) Enum.valueOf(ADYaiT.class, str);
    }

    public static ADYaiT[] values() {
        return (ADYaiT[]) f1122B7CMnp.clone();
    }
}
