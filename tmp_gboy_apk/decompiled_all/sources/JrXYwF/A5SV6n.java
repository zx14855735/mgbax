package JrXYwF;

import ADYaiT.DUi7mC;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static Context f4149A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static long f4150A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static DUi7mC f4151A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final K7mCWO.A5SV6n f4152ADYaiT = new K7mCWO.A5SV6n();
    public static final ADYaiT AMqCpz = new ADYaiT();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static K7mCWO.A4TApA f4153ARc23Z = null;

    static {
        Pofl();
    }

    public static K7mCWO.A4TApA A2egSU() {
        if (f4153ARc23Z == null) {
            synchronized (A5SV6n.class) {
                Context context = f4149A2egSU;
                K7mCWO.A4TApA a4TApA = new K7mCWO.A4TApA();
                a4TApA.f4181A2egSU = hf.hf(context, "npth", 0);
                f4153ARc23Z = a4TApA;
            }
        }
        return f4153ARc23Z;
    }

    private static /* synthetic */ void Pofl() {
        char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 253);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 253);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
