package RfS3U2;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends A2egSU {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A5SV6n f7903AzWtSf = new A5SV6n(1, 0, 1);

    static {
        BgQwK();
    }

    private static /* synthetic */ void BgQwK() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A5SV6n)) {
            return false;
        }
        if (isEmpty() && ((A5SV6n) obj).isEmpty()) {
            return true;
        }
        A5SV6n a5SV6n = (A5SV6n) obj;
        if (this.f7896AcNBzu == a5SV6n.f7896AcNBzu) {
            return this.f7897AlLFFp == a5SV6n.f7897AlLFFp;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f7896AcNBzu * 31) + this.f7897AlLFFp;
    }

    public final boolean isEmpty() {
        return this.f7896AcNBzu > this.f7897AlLFFp;
    }

    public final String toString() {
        return this.f7896AcNBzu + ".." + this.f7897AlLFFp;
    }
}
