package BV3sI0;

import android.graphics.Insets;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {
    public static final A5SV6n AMqCpz = new A5SV6n(0, 0, 0, 0);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f1482A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1483A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f1484A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f1485ADYaiT;

    static {
        tfpFZrN();
    }

    public A5SV6n(int i, int i2, int i3, int i4) {
        this.f1482A2egSU = i;
        this.f1483A4TApA = i2;
        this.f1484A5SV6n = i3;
        this.f1485ADYaiT = i4;
    }

    public static A5SV6n A2egSU(A5SV6n a5SV6n, A5SV6n a5SV6n2) {
        return A4TApA(Math.max(a5SV6n.f1482A2egSU, a5SV6n2.f1482A2egSU), Math.max(a5SV6n.f1483A4TApA, a5SV6n2.f1483A4TApA), Math.max(a5SV6n.f1484A5SV6n, a5SV6n2.f1484A5SV6n), Math.max(a5SV6n.f1485ADYaiT, a5SV6n2.f1485ADYaiT));
    }

    public static A5SV6n A4TApA(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? AMqCpz : new A5SV6n(i, i2, i3, i4);
    }

    public static A5SV6n A5SV6n(Insets insets) {
        int i;
        int i2;
        int i3;
        int i4;
        i = insets.left;
        i2 = insets.top;
        i3 = insets.right;
        i4 = insets.bottom;
        return A4TApA(i, i2, i3, i4);
    }

    private static /* synthetic */ void tfpFZrN() {
        char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 213);
        }
        String str = new String(charArray);
        char[] charArray2 = "¶¹¼»¼¡".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 213);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final Insets ADYaiT() {
        return A4TApA.A2egSU(this.f1482A2egSU, this.f1483A4TApA, this.f1484A5SV6n, this.f1485ADYaiT);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || A5SV6n.class != obj.getClass()) {
            return false;
        }
        A5SV6n a5SV6n = (A5SV6n) obj;
        return this.f1485ADYaiT == a5SV6n.f1485ADYaiT && this.f1482A2egSU == a5SV6n.f1482A2egSU && this.f1484A5SV6n == a5SV6n.f1484A5SV6n && this.f1483A4TApA == a5SV6n.f1483A4TApA;
    }

    public final int hashCode() {
        return (((((this.f1482A2egSU * 31) + this.f1483A4TApA) * 31) + this.f1484A5SV6n) * 31) + this.f1485ADYaiT;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f1482A2egSU);
        sb.append(", top=");
        sb.append(this.f1483A4TApA);
        sb.append(", right=");
        sb.append(this.f1484A5SV6n);
        sb.append(", bottom=");
        return J3FDQU.A2egSU.B2KMhB(sb, this.f1485ADYaiT, '}');
    }
}
