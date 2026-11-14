package RPBX6S;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements RJJjP9.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f7873AcNBzu = new A2egSU();

    static {
        UIWkt();
    }

    private static /* synthetic */ void UIWkt() {
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

    @Override // RJJjP9.A2egSU
    public RJJjP9.ADYaiT getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // RJJjP9.A2egSU
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
