package AaHO0E;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class GIi2tl {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadLocal f872A2egSU = new ThreadLocal();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f873A4TApA = {-16842910};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final int[] f874A5SV6n = {R.attr.state_focused};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f875ADYaiT = {R.attr.state_pressed};
    public static final int[] AMqCpz = {R.attr.state_checked};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final int[] f876ARc23Z = new int[0];

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final int[] f877ASJ6gh = new int[1];

    static {
        EHMI();
    }

    public static void A2egSU(Context context, View view) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.f8022AZkASS);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                view.getClass().toString();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int A4TApA(Context context, int i) {
        ColorStateList ADYaiT2 = ADYaiT(context, i);
        if (ADYaiT2 != null && ADYaiT2.isStateful()) {
            return ADYaiT2.getColorForState(f873A4TApA, ADYaiT2.getDefaultColor());
        }
        ThreadLocal threadLocal = f872A2egSU;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f = typedValue.getFloat();
        return BV3sI0.A2egSU.AMqCpz(A5SV6n(context, i), Math.round(Color.alpha(r4) * f));
    }

    public static int A5SV6n(Context context, int i) {
        int[] iArr = f877ASJ6gh;
        iArr[0] = i;
        GYpKKt AMqCpz2 = GYpKKt.AMqCpz(context, null, iArr);
        try {
            return AMqCpz2.f884A4TApA.getColor(0, 0);
        } finally {
            AMqCpz2.ASJ6gh();
        }
    }

    public static ColorStateList ADYaiT(Context context, int i) {
        int[] iArr = f877ASJ6gh;
        iArr[0] = i;
        GYpKKt AMqCpz2 = GYpKKt.AMqCpz(context, null, iArr);
        try {
            return AMqCpz2.A2egSU(0);
        } finally {
            AMqCpz2.ASJ6gh();
        }
    }

    private static /* synthetic */ void EHMI() {
        char[] charArray = "ÂÎÌ\u008fÆÀÌÄ\u008fÃÎØ\u008fÒÉÄÍÍ\u008fëÏÈãÓÈÅÆÄ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 161);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÂÍÈÏÈÕ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 161);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
