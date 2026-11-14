package ms.bz.bd.c.Pgl;

import java.util.ArrayList;
import java.util.List;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class c extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        m1 A5SV6n2 = m1.A5SV6n(pblv.f14062A4TApA.f14063A2egSU);
        synchronized (A5SV6n2) {
            StringBuilder sb = new StringBuilder();
            int size = A5SV6n2.f14027B25kr6.size();
            if (size <= 0) {
                return null;
            }
            try {
                ArrayList arrayList = A5SV6n2.f14027B25kr6;
                int i = size - 50;
                if (i <= 0) {
                    i = 0;
                }
                List<JSONArray> subList = arrayList.subList(i, size);
                if (subList.size() > 0) {
                    for (JSONArray jSONArray : subList) {
                        if (jSONArray != null) {
                            sb.append(jSONArray.get(0).toString());
                            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28f2c7", new byte[]{111}));
                            sb.append(jSONArray.get(1).toString());
                            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f414bd", new byte[]{59}));
                            sb.append(jSONArray.get(2).toString());
                            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98efac", new byte[]{com.sigmob.sdk.archives.tar.e.L}));
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.delete(sb.length() - 1, sb.length());
                }
            } catch (Throwable unused) {
            }
            return sb.toString();
        }
    }
}
