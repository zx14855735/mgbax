package JtTqUo;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.AMqCpz;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile A5SV6n f4168A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public volatile Context f4169A2egSU;

    public static A5SV6n A4TApA() {
        if (f4168A4TApA == null) {
            Context context = JrXYwF.A5SV6n.f4149A2egSU;
            A5SV6n a5SV6n = new A5SV6n();
            a5SV6n.f4169A2egSU = context;
            f4168A4TApA = a5SV6n;
        }
        return f4168A4TApA;
    }

    public final void A2egSU(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            JrXYwF.A5SV6n.f4151A5SV6n.BNL6CD();
            JrXYwF.A5SV6n.f4152ADYaiT.getClass();
            String DjONCG2 = JrXYwF.A4TApA.DjONCG(new File(com.bumptech.glide.A5SV6n.DuwtYk(this.f4169A2egSU), "CrashLogJava"), "anr_" + String.valueOf(System.nanoTime()) + ".npth", jSONObject);
            jSONObject.put("upload_scene", "direct");
            boolean z = true;
            if (AMqCpz.D07BeM("https://apmplus.volces.com/apm/collect/crash", jSONObject.toString(), true).f4098A2egSU != 0) {
                z = false;
            }
            if (z && !TextUtils.isEmpty(DjONCG2)) {
                File file = new File(DjONCG2);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
