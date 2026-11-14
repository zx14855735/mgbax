package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static volatile boolean hasInit;

    private static c NB() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aVi = aVar;
        aVar.aUZ = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void df(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", "configStr:" + str);
                c fV = a.fV(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", fV.toJson().toString());
                e.d(fV.aVi);
                a.access$002(true);
            }
        });
    }

    public static c fV(String str) {
        if (TextUtils.isEmpty(str)) {
            return NB();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("perfMonitor.MonitorManager", e);
            return NB();
        }
    }
}
