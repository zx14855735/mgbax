package BTvldC;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final float[][] f1440A2egSU = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final float[][] f1441A4TApA = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final float[] f1442A5SV6n = {95.047f, 100.0f, 108.883f};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final float[][] f1443ADYaiT = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final Object AMqCpz = new Object();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static Method f1444ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static boolean f1445ASJ6gh;

    public static int A2egSU(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static ADYaiT A4TApA(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        ADYaiT aDYaiT;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i2 = typedValue.type;
            if (i2 >= 28 && i2 <= 31) {
                return new ADYaiT((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                aDYaiT = ADYaiT.A2egSU(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception unused) {
                aDYaiT = null;
            }
            if (aDYaiT != null) {
                return aDYaiT;
            }
        }
        return new ADYaiT((Shader) null, (ColorStateList) null, 0);
    }

    public static String A5SV6n(TypedArray typedArray, XmlResourceParser xmlResourceParser, String str, int i) {
        if (ADYaiT(xmlResourceParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static boolean ADYaiT(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int AMqCpz(float f) {
        if (f < 1.0f) {
            return d.f13043a;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f2 = (f + 16.0f) / 116.0f;
        float f3 = f > 8.0f ? f2 * f2 * f2 : f / 903.2963f;
        float f4 = f2 * f2 * f2;
        boolean z = f4 > 0.008856452f;
        float f5 = z ? f4 : ((f2 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f4 = ((f2 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f1442A5SV6n;
        return BV3sI0.A2egSU.A2egSU(f5 * fArr[0], f3 * fArr[1], f4 * fArr[2]);
    }

    public static float ARc23Z(int i) {
        float f = i / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static TypedArray ASJ6gh(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static void AYUAbz(Resources.Theme theme) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            B3GDIM.A2egSU(theme);
            return;
        }
        if (i >= 23) {
            synchronized (AMqCpz) {
                if (!f1445ASJ6gh) {
                    try {
                        Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                        f1444ARc23Z = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    f1445ASJ6gh = true;
                }
                Method method = f1444ARc23Z;
                if (method != null) {
                    try {
                        method.invoke(theme, new Object[0]);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        f1444ARc23Z = null;
                    }
                }
            }
        }
    }

    public static float AZOQYO() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
