package KBDfKG;

import GJee0v.AMqCpz;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Application f4203A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f4204A4TApA;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public String f4208ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public long f4209AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public String f4210AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public long f4211AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public String f4212AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public long f4213AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public String f4214AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f4215AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public String f4216AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public long f4217B25kr6;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f4205A5SV6n = new ArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f4206ADYaiT = new ArrayList();
    public final ArrayList AMqCpz = new ArrayList();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final ArrayList f4207ARc23Z = new ArrayList();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f4218B2KMhB = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f4219B3GDIM = false;

    public A4TApA(Context context) {
        AMqCpz aMqCpz = new AMqCpz(this);
        this.f4204A4TApA = context;
        if (context instanceof Application) {
            this.f4203A2egSU = (Application) context;
        }
        Application application = this.f4203A2egSU;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(aMqCpz);
        }
    }

    public static JSONObject A2egSU(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return jSONObject;
        }
    }
}
