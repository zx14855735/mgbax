package De4eam;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f2401A2egSU;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f2401A2egSU = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
        vznHtgN();
    }

    public static boolean A2egSU(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (A2egSU(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static /* synthetic */ void vznHtgN() {
        char[] charArray = "\u0012\u001e\u001c_\u0016\u0010\u001c\u0014_\u0013\u001e\b_\u0002\u0019\u0014\u001d\u001d_;\u001f\u00183\u0003\u0018\u0015\u0016\u0014".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'q');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0012\u001d\u0018\u001f\u0018\u0005".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
