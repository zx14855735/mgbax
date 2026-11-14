package BV3sI0;

import android.content.res.Resources;
import android.os.Build;
import java.lang.reflect.Method;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final JrXYwF.A4TApA f1490A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final B25kr6.AZkASS f1491A4TApA;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f1490A2egSU = new AlLFFp();
        } else if (i >= 28) {
            f1490A2egSU = new AcNBzu();
        } else if (i >= 26) {
            f1490A2egSU = new AaHO0E();
        } else if (i < 24 || AZkASS.f1499AcNBzu == null) {
            f1490A2egSU = new AZOQYO();
        } else {
            f1490A2egSU = new AZkASS();
        }
        f1491A4TApA = new B25kr6.AZkASS(16);
        crwR();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r4.equals(r7) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface A2egSU(android.content.Context r12, BTvldC.ARc23Z r13, android.content.res.Resources r14, int r15, java.lang.String r16, int r17, int r18, BTvldC.B2KMhB r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BV3sI0.AYUAbz.A2egSU(android.content.Context, BTvldC.ARc23Z, android.content.res.Resources, int, java.lang.String, int, int, BTvldC.B2KMhB, boolean):android.graphics.Typeface");
    }

    public static String A4TApA(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + Soundex.SILENT_MARKER + str + Soundex.SILENT_MARKER + i2 + Soundex.SILENT_MARKER + i + Soundex.SILENT_MARKER + i3;
    }

    private static /* synthetic */ void crwR() {
        char[] charArray = "\u0084\u0088\u008aÉ\u0080\u0086\u008a\u0082É\u0085\u0088\u009eÉ\u0094\u008f\u0082\u008b\u008bÉ\u00ad\u0089\u008e¥\u0095\u008e\u0083\u0080\u0082".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 231);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0084\u008b\u008e\u0089\u008e\u0093".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 231);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
