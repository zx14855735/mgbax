package CASmeH;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Method f1600A2egSU;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f1600A2egSU = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static String A2egSU(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AMqCpz.A5SV6n(AMqCpz.A2egSU(AMqCpz.A4TApA(locale)));
        }
        try {
            return ADYaiT.A2egSU((Locale) f1600A2egSU.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return ADYaiT.A2egSU(locale);
        }
    }
}
