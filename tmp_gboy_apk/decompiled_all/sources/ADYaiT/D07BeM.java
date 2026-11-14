package ADYaiT;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class D07BeM {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Class[] f211A4TApA = {Context.class, AttributeSet.class};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final int[] f212A5SV6n = {R.attr.onClick};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f213ADYaiT = {R.attr.accessibilityHeading};
    public static final int[] AMqCpz = {R.attr.accessibilityPaneTitle};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final int[] f214ARc23Z = {R.attr.screenReaderFocusable};

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final String[] f215ASJ6gh = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final B25kr6.AzWtSf f216AYUAbz = new B25kr6.AzWtSf();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object[] f217A2egSU = new Object[2];

    static {
        ihCCq();
    }

    private static /* synthetic */ void ihCCq() {
        char[] charArray = "÷ûùºóõùñºöûíºçüñøøºÞúýÖæýðóñ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 148);
        }
        String str = new String(charArray);
        char[] charArray2 = "÷øýúýà".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 148);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public AaHO0E.B4ZgIw A2egSU(Context context, AttributeSet attributeSet) {
        return new AaHO0E.B4ZgIw(context, attributeSet);
    }

    public AaHO0E.B9tovu A4TApA(Context context, AttributeSet attributeSet) {
        return new AaHO0E.B9tovu(context, attributeSet, 2130968745);
    }

    public AaHO0E.BChYOn A5SV6n(Context context, AttributeSet attributeSet) {
        return new AaHO0E.BChYOn(context, attributeSet, 2130968775);
    }

    public AaHO0E.CASmeH ADYaiT(Context context, AttributeSet attributeSet) {
        return new AaHO0E.CASmeH(context, attributeSet);
    }

    public AppCompatTextView AMqCpz(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public final View ARc23Z(Context context, String str, String str2) {
        String concat;
        B25kr6.AzWtSf azWtSf = f216AYUAbz;
        Constructor constructor = (Constructor) azWtSf.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f211A4TApA);
            azWtSf.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f217A2egSU);
    }
}
