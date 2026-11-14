package GcSJYy;

import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final ADYaiT f3070ADYaiT = new ADYaiT(Looper.getMainLooper());

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A4TApA f3071A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final F32kj0.A2egSU f3072A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AtomicBoolean f3073A5SV6n = new AtomicBoolean();

    static {
        yvgV();
    }

    public AMqCpz(F32kj0.A2egSU a2egSU) {
        this.f3071A2egSU = new A4TApA(this, new A2egSU(a2egSU), 0);
        this.f3072A4TApA = a2egSU;
    }

    private static /* synthetic */ void yvgV() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A2egSU() {
        return this.f3071A2egSU.isCancelled() || this.f3073A5SV6n.get();
    }
}
