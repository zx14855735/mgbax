package Hjvs0g;

import android.net.Uri;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb implements BI9f7h {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Set f3773A4TApA = Collections.unmodifiableSet(new HashSet(Arrays.asList(n.z, "android.resource", IAdInterListener.AdProdType.PRODUCT_CONTENT)));

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f3774A2egSU;

    static {
        IXUkt();
    }

    public CTkVKb(CSDoyG cSDoyG) {
        this.f3774A2egSU = cSDoyG;
    }

    private static /* synthetic */ void IXUkt() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [Hjvs0g.CSDoyG, java.lang.Object] */
    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        Uri uri = (Uri) obj;
        return new BChYOn(new IssTRV.ADYaiT(uri), this.f3774A2egSU.AaHO0E(uri));
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        return f3773A4TApA.contains(((Uri) obj).getScheme());
    }
}
