package Oay4Bh;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadLocal f6517A2egSU = new ThreadLocal();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ThreadLocal f6518A4TApA = new ThreadLocal();

    static {
        oGiL();
    }

    public static void A2egSU(ViewGroup viewGroup, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewGroup) {
            A2egSU(viewGroup, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }

    public static void A4TApA(ViewGroup viewGroup, View view, Rect rect) {
        ThreadLocal threadLocal = f6517A2egSU;
        Matrix matrix = (Matrix) threadLocal.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal.set(matrix);
        } else {
            matrix.reset();
        }
        A2egSU(viewGroup, view, matrix);
        ThreadLocal threadLocal2 = f6518A4TApA;
        RectF rectF = (RectF) threadLocal2.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal2.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static /* synthetic */ void oGiL() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
