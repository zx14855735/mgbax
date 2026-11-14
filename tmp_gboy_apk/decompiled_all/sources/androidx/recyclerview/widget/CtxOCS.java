package androidx.recyclerview.widget;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CtxOCS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final CtxOCS f9336AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final CtxOCS f9337AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final CtxOCS f9338AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final /* synthetic */ CtxOCS[] f9339AzWtSf;

    static {
        CtxOCS ctxOCS = new CtxOCS("ALLOW", 0);
        f9336AcNBzu = ctxOCS;
        CtxOCS ctxOCS2 = new CtxOCS("PREVENT_WHEN_EMPTY", 1);
        f9337AlLFFp = ctxOCS2;
        CtxOCS ctxOCS3 = new CtxOCS("PREVENT", 2);
        f9338AmA8tU = ctxOCS3;
        f9339AzWtSf = new CtxOCS[]{ctxOCS, ctxOCS2, ctxOCS3};
        Ofquwhc();
    }

    private static /* synthetic */ void Ofquwhc() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static CtxOCS valueOf(String str) {
        return (CtxOCS) Enum.valueOf(CtxOCS.class, str);
    }

    public static CtxOCS[] values() {
        return (CtxOCS[]) f9339AzWtSf.clone();
    }
}
