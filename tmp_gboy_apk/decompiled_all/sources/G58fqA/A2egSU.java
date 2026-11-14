package G58fqA;

import ADYaiT.BChYOn;
import ADYaiT.CTkVKb;
import GJee0v.AZOQYO;
import H0R8Px.AMqCpz;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.FileOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f2977A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f2978A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f2979A5SV6n;

    public A2egSU(A5SV6n a5SV6n, Context context) {
        this.f2979A5SV6n = context;
        this.f2978A4TApA = new CTkVKb(1, a5SV6n);
    }

    public static void A5SV6n(ContextWrapper contextWrapper, String str) {
        if (ADYaiT(str)) {
            new Handler(Looper.getMainLooper()).post(new BChYOn(str, 8, contextWrapper));
        }
    }

    public static boolean ADYaiT(String... strArr) {
        try {
            for (String str : strArr) {
                if (str == null || str.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            int i = AZOQYO.f3039AcNBzu;
            return false;
        }
    }

    public H0R8Px.A4TApA A2egSU() {
        H0R8Px.A4TApA a4TApA;
        synchronized (((AMqCpz) this.f2979A5SV6n)) {
            try {
                if (((H0R8Px.A5SV6n) this.f2978A4TApA).f3136ADYaiT != this) {
                    throw new IllegalStateException();
                }
                a4TApA = new H0R8Px.A4TApA(this, new FileOutputStream(((H0R8Px.A5SV6n) this.f2978A4TApA).A5SV6n(0)));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a4TApA;
    }

    public void A4TApA() {
        Context context;
        CTkVKb cTkVKb = (CTkVKb) this.f2978A4TApA;
        if (cTkVKb != null) {
            try {
                if (!this.f2977A2egSU || (context = (Context) this.f2979A5SV6n) == null) {
                    return;
                }
                context.getApplicationContext().unregisterReceiver(cTkVKb);
                this.f2977A2egSU = false;
            } catch (Exception unused) {
                int i = AZOQYO.f3039AcNBzu;
            }
        }
    }

    public void AMqCpz(String... strArr) {
        Context context;
        CTkVKb cTkVKb = (CTkVKb) this.f2978A4TApA;
        if (cTkVKb != null) {
            try {
                if (strArr.length == 0) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                for (String str : strArr) {
                    if (ADYaiT(str)) {
                        intentFilter.addAction(str);
                    }
                }
                if (intentFilter.countActions() <= 0 || (context = (Context) this.f2979A5SV6n) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    try {
                        context.getApplicationContext().registerReceiver(cTkVKb, intentFilter, Context.class.getField("RECEIVER_EXPORTED").getInt(null));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    context.getApplicationContext().registerReceiver(cTkVKb, intentFilter);
                }
                this.f2977A2egSU = true;
            } catch (Exception unused) {
                int i = AZOQYO.f3039AcNBzu;
            }
        }
    }

    public A2egSU(AMqCpz aMqCpz, H0R8Px.A5SV6n a5SV6n) {
        this.f2979A5SV6n = aMqCpz;
        this.f2978A4TApA = a5SV6n;
    }
}
