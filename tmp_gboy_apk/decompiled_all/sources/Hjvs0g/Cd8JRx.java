package Hjvs0g;

import android.net.Uri;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Cd8JRx implements BI9f7h {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Set f3775A4TApA = Collections.unmodifiableSet(new HashSet(Arrays.asList(Constants.HTTP, "https")));

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BI9f7h f3776A2egSU;

    static {
        ONszo();
    }

    public Cd8JRx(BI9f7h bI9f7h) {
        this.f3776A2egSU = bI9f7h;
    }

    private static /* synthetic */ void ONszo() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        return this.f3776A2egSU.A2egSU(new AcNBzu(((Uri) obj).toString(), AlLFFp.f3725A2egSU), i, i2, amA8tU);
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        return f3775A4TApA.contains(((Uri) obj).getScheme());
    }
}
