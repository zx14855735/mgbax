package NGepWW;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final NSK3xo.A4TApA f5679A5SV6n = new NSK3xo.A4TApA(8, "The connection to Google Play services was lost");

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final DRlcZ9[] f5680ADYaiT = new DRlcZ9[0];

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Set f5681A2egSU = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AMqCpz f5682A4TApA = new AMqCpz(this);

    static {
        kQQs();
    }

    public ARc23Z(QkAq4X.A4TApA a4TApA) {
    }

    private static /* synthetic */ void kQQs() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        boolean AYUAbz2;
        for (DRlcZ9 dRlcZ9 : (DRlcZ9[]) this.f5681A2egSU.toArray(f5680ADYaiT)) {
            dRlcZ9.f5728ASJ6gh.set(null);
            synchronized (dRlcZ9.f5725A5SV6n) {
                try {
                    if (((NSK3xo.AcNBzu) dRlcZ9.f5724A4TApA.get()) != null) {
                        if (!dRlcZ9.f5733AcNBzu) {
                        }
                        AYUAbz2 = dRlcZ9.AYUAbz();
                    }
                    dRlcZ9.ASJ6gh();
                    AYUAbz2 = dRlcZ9.AYUAbz();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (AYUAbz2) {
                this.f5681A2egSU.remove(dRlcZ9);
            }
        }
    }
}
