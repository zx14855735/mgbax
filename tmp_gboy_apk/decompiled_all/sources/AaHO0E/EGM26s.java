package AaHO0E;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EGM26s {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f762A2egSU = {R.attr.state_checked};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f763A4TApA = new int[0];

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Rect f764A5SV6n = new Rect();

    static {
        kxpcU();
    }

    public static void A2egSU(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        int[] iArr = f762A2egSU;
        int[] iArr2 = f763A4TApA;
        if (i == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(iArr);
            } else {
                drawable.setState(iArr2);
            }
            drawable.setState(state);
            return;
        }
        if (i < 29 || i >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state2 = drawable.getState();
        if (state2 == null || state2.length == 0) {
            drawable.setState(iArr);
        } else {
            drawable.setState(iArr2);
        }
        drawable.setState(state2);
    }

    public static Rect A4TApA(Drawable drawable) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Insets A2egSU2 = ECyGFg.A2egSU(drawable);
            i = A2egSU2.left;
            i2 = A2egSU2.top;
            i3 = A2egSU2.right;
            i4 = A2egSU2.bottom;
            return new Rect(i, i2, i3, i4);
        }
        Drawable DdagTj2 = com.bumptech.glide.A5SV6n.DdagTj(drawable);
        if (i5 >= 29) {
            boolean z = DyaChj.f757A2egSU;
        } else if (DyaChj.f757A2egSU) {
            try {
                Object invoke = DyaChj.f758A4TApA.invoke(DdagTj2, new Object[0]);
                if (invoke != null) {
                    return new Rect(DyaChj.f759A5SV6n.getInt(invoke), DyaChj.f760ADYaiT.getInt(invoke), DyaChj.AMqCpz.getInt(invoke), DyaChj.f761ARc23Z.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f764A5SV6n;
    }

    public static PorterDuff.Mode A5SV6n(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private static /* synthetic */ void kxpcU() {
        char[] charArray = "æêè«âäèà«çêü«öíàéé«ÏëìÇ÷ìáâà".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 133);
        }
        String str = new String(charArray);
        char[] charArray2 = "æéìëìñ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 133);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
