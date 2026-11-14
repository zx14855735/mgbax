package BTvldC;

import ADYaiT.BChYOn;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadLocal f1468A2egSU = new ThreadLocal();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final WeakHashMap f1469A4TApA = new WeakHashMap(0);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Object f1470A5SV6n = new Object();

    static {
        UjiGB();
    }

    public static void A2egSU(AzWtSf azWtSf, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f1470A5SV6n) {
            try {
                WeakHashMap weakHashMap = f1469A4TApA;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(azWtSf);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(azWtSf, sparseArray);
                }
                sparseArray.append(i, new AmA8tU(colorStateList, azWtSf.f1463A2egSU.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface A4TApA(Context context, int i, TypedValue typedValue, int i2, B2KMhB b2KMhB, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence2 = charSequence.toString();
        Typeface typeface = null;
        if (charSequence2.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            B25kr6.AZkASS aZkASS = BV3sI0.AYUAbz.f1491A4TApA;
            Typeface typeface2 = (Typeface) aZkASS.A2egSU(BV3sI0.AYUAbz.A4TApA(resources, i, charSequence2, i3, i2));
            if (typeface2 != null) {
                if (b2KMhB != null) {
                    new Handler(Looper.getMainLooper()).post(new BChYOn(b2KMhB, 1, typeface2));
                }
                typeface = typeface2;
            } else if (!z2) {
                try {
                    if (charSequence2.toLowerCase().endsWith(".xml")) {
                        ARc23Z A2egSU2 = AZkASS.A2egSU(resources.getXml(i), resources);
                        if (A2egSU2 != null) {
                            typeface = BV3sI0.AYUAbz.A2egSU(context, A2egSU2, resources, i, charSequence2, typedValue.assetCookie, i2, b2KMhB, z);
                        } else if (b2KMhB != null) {
                            b2KMhB.A2egSU(-3);
                        }
                    } else {
                        int i4 = typedValue.assetCookie;
                        Typeface BNL6CD2 = BV3sI0.AYUAbz.f1490A2egSU.BNL6CD(context, resources, i, charSequence2, i2);
                        if (BNL6CD2 != null) {
                            aZkASS.A4TApA(BV3sI0.AYUAbz.A4TApA(resources, i, charSequence2, i4, i2), BNL6CD2);
                        }
                        if (b2KMhB != null) {
                            if (BNL6CD2 != null) {
                                new Handler(Looper.getMainLooper()).post(new BChYOn(b2KMhB, 1, BNL6CD2));
                            } else {
                                b2KMhB.A2egSU(-3);
                            }
                        }
                        typeface = BNL6CD2;
                    }
                } catch (IOException | XmlPullParserException unused) {
                    if (b2KMhB != null) {
                        b2KMhB.A2egSU(-3);
                    }
                }
            }
        } else if (b2KMhB != null) {
            b2KMhB.A2egSU(-3);
        }
        if (typeface != null || b2KMhB != null || z2) {
            return typeface;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    private static /* synthetic */ void UjiGB() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
