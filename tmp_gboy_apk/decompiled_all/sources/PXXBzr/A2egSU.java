package PXXBzr;

import AZOQYO.ADYaiT;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f7406A2egSU = {R.attr.theme, 2130970076};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f7407A4TApA = {2130969579};

    static {
        tKhzz();
    }

    public static Context A2egSU(Context context, AttributeSet attributeSet, int i, int i2) {
        return A4TApA(context, attributeSet, i, i2, new int[0]);
    }

    public static Context A4TApA(Context context, AttributeSet attributeSet, int i, int i2, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7407A4TApA, i, i2);
        int[] iArr2 = {obtainStyledAttributes.getResourceId(0, 0)};
        obtainStyledAttributes.recycle();
        int i3 = iArr2[0];
        boolean z = (context instanceof ADYaiT) && ((ADYaiT) context).getThemeResId() == i3;
        if (i3 == 0 || z) {
            return context;
        }
        ADYaiT aDYaiT = new ADYaiT(context, i3);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr3[i4] = obtainStyledAttributes2.getResourceId(i4, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr3[i5];
            if (i6 != 0) {
                aDYaiT.getTheme().applyStyle(i6, true);
            }
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f7406A2egSU);
        int resourceId = obtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes3.getResourceId(1, 0);
        obtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            aDYaiT.getTheme().applyStyle(resourceId, true);
        }
        return aDYaiT;
    }

    private static /* synthetic */ void tKhzz() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
