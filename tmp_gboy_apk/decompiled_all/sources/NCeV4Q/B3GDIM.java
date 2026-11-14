package NCeV4Q;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final ReentrantLock f5653A5SV6n = new ReentrantLock();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static B3GDIM f5654ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ReentrantLock f5655A2egSU = new ReentrantLock();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final SharedPreferences f5656A4TApA;

    static {
        HMmdgZ();
    }

    public B3GDIM(Context context) {
        this.f5656A4TApA = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static B3GDIM A2egSU(Context context) {
        NUY5pn.AYUAbz.A4TApA(context);
        ReentrantLock reentrantLock = f5653A5SV6n;
        reentrantLock.lock();
        try {
            if (f5654ADYaiT == null) {
                f5654ADYaiT = new B3GDIM(context.getApplicationContext());
            }
            B3GDIM b3gdim = f5654ADYaiT;
            reentrantLock.unlock();
            return b3gdim;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static String A5SV6n(String str, String str2) {
        return J3FDQU.A2egSU.B3GDIM(new StringBuilder(String.valueOf(str2).length() + str.length() + 1), str, ":", str2);
    }

    private static /* synthetic */ void HMmdgZ() {
        char[] charArray = "DHJ\t@FJB\tEH^\tTOBKK\tmINeUNC@B".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\'');
        }
        String str = new String(charArray);
        char[] charArray2 = "DKNINS".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\'');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(String str, String str2) {
        ReentrantLock reentrantLock = this.f5655A2egSU;
        reentrantLock.lock();
        try {
            this.f5656A4TApA.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final String ADYaiT(String str) {
        ReentrantLock reentrantLock = this.f5655A2egSU;
        reentrantLock.lock();
        try {
            return this.f5656A4TApA.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void AMqCpz() {
        String ADYaiT2 = ADYaiT("defaultGoogleSignInAccount");
        ARc23Z("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(ADYaiT2)) {
            return;
        }
        ARc23Z(A5SV6n("googleSignInAccount", ADYaiT2));
        ARc23Z(A5SV6n("googleSignInOptions", ADYaiT2));
    }

    public final void ARc23Z(String str) {
        ReentrantLock reentrantLock = this.f5655A2egSU;
        reentrantLock.lock();
        try {
            this.f5656A4TApA.edit().remove(str).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
