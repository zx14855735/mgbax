package DaOi9o;

import AaHO0E.GEYgCP;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BpkvW3 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ADYaiT.BmvVmW f2284A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final GEYgCP f2285A4TApA;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f2284A2egSU = new CTkVKb(14);
        } else if (i >= 23) {
            f2284A2egSU = new CSDoyG(14);
        } else if (i >= 22) {
            f2284A2egSU = new CNPG0E(14);
        } else {
            f2284A2egSU = new ADYaiT.BmvVmW(14);
        }
        f2285A4TApA = new GEYgCP(Float.class, "translationAlpha", 6);
        new GEYgCP(Rect.class, "clipBounds", 7);
        DVcN();
    }

    public static void A2egSU(View view, int i, int i2, int i3, int i4) {
        f2284A2egSU.AZOQYO(view, i, i2, i3, i4);
    }

    public static void A4TApA(View view, int i) {
        f2284A2egSU.AcNBzu(view, i);
    }

    private static /* synthetic */ void DVcN() {
        char[] charArray = "W[Y\u001aSUYQ\u001aV[M\u001aG\\QXX\u001a~Z]vF]PSQ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '4');
        }
        String str = new String(charArray);
        char[] charArray2 = "WX]Z]@".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '4');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
