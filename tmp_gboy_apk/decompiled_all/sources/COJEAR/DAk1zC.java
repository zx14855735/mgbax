package COJEAR;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DAk1zC {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final ArrayList f1676ADYaiT = new ArrayList();

    /* renamed from: A2egSU, reason: collision with root package name */
    public WeakHashMap f1677A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public SparseArray f1678A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public WeakReference f1679A5SV6n;

    static {
        RjdEC();
    }

    private static /* synthetic */ void RjdEC() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final View A2egSU(View view) {
        int size;
        WeakHashMap weakHashMap = this.f1677A2egSU;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View A2egSU2 = A2egSU(viewGroup.getChildAt(childCount));
                if (A2egSU2 != null) {
                    return A2egSU2;
                }
            }
        }
        ArrayList arrayList = (ArrayList) view.getTag(2131298067);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return null;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }
}
