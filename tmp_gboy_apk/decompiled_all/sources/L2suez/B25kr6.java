package L2suez;

import ADYaiT.D8MqeW;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.ref.WeakReference;
import okhttp3.Call;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public WeakReference f4380A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public String f4381A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f4382A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Handler f4383ADYaiT;
    public Call AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public MOpbMP.B7CMnp f4384ARc23Z;

    public static void A2egSU(B25kr6 b25kr6, IOException iOException) {
        Context context = (Context) b25kr6.f4380A2egSU.get();
        if (context == null) {
            String message = iOException.getMessage();
            if (b25kr6.f4384ARc23Z == null) {
                return;
            }
            b25kr6.f4383ADYaiT.post(new D8MqeW(b25kr6, message));
            return;
        }
        if (b25kr6.f4382A5SV6n) {
            b25kr6.f4383ADYaiT.post(new JtTqUo.A4TApA(context));
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            sharedPreferences.edit().apply();
            String string = sharedPreferences.getString("updater", null);
            if (string != null && !string.isEmpty()) {
                b25kr6.f4383ADYaiT.post(new C4FrIb.A2egSU(b25kr6, (MTKlkd.AZOQYO) new Gson().fromJson(string, MTKlkd.AZOQYO.class), 11, false));
                return;
            }
        } catch (Exception unused) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).edit();
            edit.apply();
            edit.remove("updater").apply();
        }
        if (b25kr6.f4384ARc23Z == null) {
            return;
        }
        b25kr6.f4383ADYaiT.post(new D8MqeW(b25kr6, "网络连接失败"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0086, code lost:
    
        if (r8 < r9) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A4TApA(L2suez.B25kr6 r10, MTKlkd.AZOQYO r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L2suez.B25kr6.A4TApA(L2suez.B25kr6, MTKlkd.AZOQYO):void");
    }
}
