package COJEAR;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CQhlFr {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Map f1662A2egSU = Collections.synchronizedMap(new WeakHashMap());

    static {
        DfBlLD();
    }

    private static /* synthetic */ void DfBlLD() {
        char[] charArray = "\u0094\u0098\u009aÙ\u0090\u0096\u009a\u0092Ù\u0095\u0098\u008eÙ\u0084\u009f\u0092\u009b\u009bÙ½\u0099\u009eµ\u0085\u009e\u0093\u0090\u0092".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 247);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0094\u009b\u009e\u0099\u009e\u0083".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 247);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
