package COJEAR;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FG7pZc {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final FG7pZc f1746A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final F32kj0 f1747A2egSU;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f1746A4TApA = F1loUV.f1743B2KMhB;
        } else {
            f1746A4TApA = F32kj0.f1744A4TApA;
            Tqzm();
        }
    }

    public FG7pZc(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f1747A2egSU = new F1loUV(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f1747A2egSU = new ExjC7D(this, windowInsets);
        } else if (i >= 28) {
            this.f1747A2egSU = new EwN40Z(this, windowInsets);
        } else {
            this.f1747A2egSU = new EsrwYR(this, windowInsets);
        }
    }

    public static BV3sI0.A5SV6n AMqCpz(BV3sI0.A5SV6n a5SV6n, int i, int i2, int i3, int i4) {
        int max = Math.max(0, a5SV6n.f1482A2egSU - i);
        int max2 = Math.max(0, a5SV6n.f1483A4TApA - i2);
        int max3 = Math.max(0, a5SV6n.f1484A5SV6n - i3);
        int max4 = Math.max(0, a5SV6n.f1485ADYaiT - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? a5SV6n : BV3sI0.A5SV6n.A4TApA(max, max2, max3, max4);
    }

    public static FG7pZc ASJ6gh(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        FG7pZc fG7pZc = new FG7pZc(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            FG7pZc AZOQYO2 = DG07BK.AZOQYO(view);
            F32kj0 f32kj0 = fG7pZc.f1747A2egSU;
            f32kj0.B25kr6(AZOQYO2);
            f32kj0.ADYaiT(view.getRootView());
        }
        return fG7pZc;
    }

    private static /* synthetic */ void Tqzm() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU() {
        return this.f1747A2egSU.AZkASS().f1485ADYaiT;
    }

    public final int A4TApA() {
        return this.f1747A2egSU.AZkASS().f1482A2egSU;
    }

    public final int A5SV6n() {
        return this.f1747A2egSU.AZkASS().f1484A5SV6n;
    }

    public final int ADYaiT() {
        return this.f1747A2egSU.AZkASS().f1483A4TApA;
    }

    public final WindowInsets ARc23Z() {
        F32kj0 f32kj0 = this.f1747A2egSU;
        if (f32kj0 instanceof ErKPGd) {
            return ((ErKPGd) f32kj0).f1735A5SV6n;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FG7pZc)) {
            return false;
        }
        return Objects.equals(this.f1747A2egSU, ((FG7pZc) obj).f1747A2egSU);
    }

    public final int hashCode() {
        F32kj0 f32kj0 = this.f1747A2egSU;
        if (f32kj0 == null) {
            return 0;
        }
        return f32kj0.hashCode();
    }

    public FG7pZc() {
        this.f1747A2egSU = new F32kj0(this);
    }
}
