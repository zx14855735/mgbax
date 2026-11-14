package ms.bz.bd.c.Pgl;

import java.util.HashMap;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class c0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap A2egSU2 = pblg.A2egSU();
            for (String str2 : A2egSU2.keySet()) {
                jSONObject.put(str2, A2egSU2.get(str2));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "091f3c", new byte[]{58, 38});
        }
    }
}
