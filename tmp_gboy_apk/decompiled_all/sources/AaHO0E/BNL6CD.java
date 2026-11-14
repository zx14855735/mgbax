package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final PorterDuff.Mode f661A4TApA = PorterDuff.Mode.SRC_IN;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static BNL6CD f662A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public FpcJKS f663A2egSU;

    static {
        rmIr();
    }

    public static synchronized BNL6CD A2egSU() {
        BNL6CD bnl6cd;
        synchronized (BNL6CD.class) {
            try {
                if (f662A5SV6n == null) {
                    ADYaiT();
                }
                bnl6cd = f662A5SV6n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bnl6cd;
    }

    public static synchronized PorterDuffColorFilter A5SV6n(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter AYUAbz2;
        synchronized (BNL6CD.class) {
            AYUAbz2 = FpcJKS.AYUAbz(i, mode);
        }
        return AYUAbz2;
    }

    public static synchronized void ADYaiT() {
        synchronized (BNL6CD.class) {
            if (f662A5SV6n == null) {
                BNL6CD bnl6cd = new BNL6CD();
                f662A5SV6n = bnl6cd;
                bnl6cd.f663A2egSU = FpcJKS.ADYaiT();
                f662A5SV6n.f663A2egSU.AlLFFp(new BJ7GGh());
            }
        }
    }

    public static void AMqCpz(Drawable drawable, GJee0v gJee0v, int[] iArr) {
        PorterDuff.Mode mode = FpcJKS.f853AYUAbz;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = gJee0v.f882ADYaiT;
            if (z || gJee0v.f881A5SV6n) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = z ? gJee0v.f879A2egSU : null;
                PorterDuff.Mode mode2 = gJee0v.f881A5SV6n ? gJee0v.f880A4TApA : FpcJKS.f853AYUAbz;
                if (colorStateList != null && mode2 != null) {
                    porterDuffColorFilter = FpcJKS.AYUAbz(colorStateList.getColorForState(iArr, 0), mode2);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    private static /* synthetic */ void rmIr() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized Drawable A4TApA(Context context, int i) {
        return this.f663A2egSU.ARc23Z(context, i);
    }
}
