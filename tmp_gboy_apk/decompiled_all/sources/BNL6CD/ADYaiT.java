package BNL6CD;

import android.graphics.Matrix;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadLocal f1430A2egSU = new ThreadLocal();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ThreadLocal f1431A4TApA = new ThreadLocal();

    static {
        CNnmews();
    }

    public static void A2egSU(CoordinatorLayout coordinatorLayout, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != coordinatorLayout) {
            A2egSU(coordinatorLayout, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }

    private static /* synthetic */ void CNnmews() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
