package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CmUvjW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final NotificationManager f8562A2egSU;

    static {
        new HashSet();
        arlWGLX();
    }

    public CmUvjW(Context context) {
        this.f8562A2egSU = (NotificationManager) context.getSystemService("notification");
    }

    private static /* synthetic */ void arlWGLX() {
        char[] charArray = "\u009b\u0097\u0095Ö\u009f\u0099\u0095\u009dÖ\u009a\u0097\u0081Ö\u008b\u0090\u009d\u0094\u0094Ö²\u0096\u0091º\u008a\u0091\u009c\u009f\u009d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 248);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009b\u0094\u0091\u0096\u0091\u008c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 248);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
