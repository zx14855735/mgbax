package NRGvz2;

import NGepWW.ASJ6gh;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ASJ6gh f5917A2egSU;

    static {
        int i = A5SV6n.f5918A2egSU;
        f5917A2egSU = new ASJ6gh("gms:common:stats:connections:ignored_calling_processes", "", 1);
        new ASJ6gh("gms:common:stats:connections:ignored_calling_services", "", 1);
        new ASJ6gh("gms:common:stats:connections:ignored_target_processes", "", 1);
        new ASJ6gh("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken", 1);
        new ASJ6gh("gms:common:stats:connections:time_out_duration", 600000L, 0);
        MdQZrgz();
    }

    private static /* synthetic */ void MdQZrgz() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
