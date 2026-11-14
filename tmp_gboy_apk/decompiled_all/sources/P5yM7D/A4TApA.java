package P5yM7D;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f6957A2egSU = {R.attr.state_pressed};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f6958A4TApA = {R.attr.state_focused};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final int[] f6959A5SV6n = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f6960ADYaiT = {R.attr.state_selected};
    public static final int[] AMqCpz = {R.attr.state_enabled, R.attr.state_pressed};

    static {
        GWQwJKF();
    }

    public static ColorStateList A2egSU(ColorStateList colorStateList) {
        int[] iArr = f6958A4TApA;
        return new ColorStateList(new int[][]{f6960ADYaiT, iArr, StateSet.NOTHING}, new int[]{A4TApA(colorStateList, f6959A5SV6n), A4TApA(colorStateList, iArr), A4TApA(colorStateList, f6957A2egSU)});
    }

    public static int A4TApA(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return BV3sI0.A2egSU.AMqCpz(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList A5SV6n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(AMqCpz, 0));
        }
        return colorStateList;
    }

    private static /* synthetic */ void GWQwJKF() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
