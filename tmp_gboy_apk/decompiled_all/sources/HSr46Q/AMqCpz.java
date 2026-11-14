package HSr46Q;

import HZUvgL.AaHO0E;
import android.content.ContentResolver;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f3482A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AaHO0E f3483A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ContentResolver f3484A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f3485ADYaiT;

    static {
        koqMEUi();
    }

    public AMqCpz(ArrayList arrayList, ADYaiT aDYaiT, AaHO0E aaHO0E, ContentResolver contentResolver) {
        this.f3482A2egSU = aDYaiT;
        this.f3483A4TApA = aaHO0E;
        this.f3484A5SV6n = contentResolver;
        this.f3485ADYaiT = arrayList;
    }

    private static /* synthetic */ void koqMEUi() {
        char[] charArray = "@LN\rDBNF\rALZ\rPKFOO\riMJaQJGDF".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '#');
        }
        String str = new String(charArray);
        char[] charArray2 = "@OJMJW".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '#');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
