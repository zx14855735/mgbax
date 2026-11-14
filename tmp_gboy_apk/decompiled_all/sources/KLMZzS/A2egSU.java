package KLMZzS;

import java.lang.reflect.Method;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int f4243A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int f4244A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final PriorityBlockingQueue f4245A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final PriorityBlockingQueue f4246ADYaiT;

    static {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() / 2) + 1;
        f4243A2egSU = availableProcessors < 4 ? 4 : availableProcessors;
        if (availableProcessors < 4) {
            availableProcessors = 4;
        }
        f4244A4TApA = availableProcessors;
        f4245A5SV6n = new PriorityBlockingQueue();
        f4246ADYaiT = new PriorityBlockingQueue();
        jOtLJZf();
    }

    private static /* synthetic */ void jOtLJZf() {
        char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 255);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 255);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
