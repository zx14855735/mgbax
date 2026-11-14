package com.kwad.sdk.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    public static class C0380a extends com.kwad.sdk.commercial.c.a {
        public String aTr;
        public int aYq;
        public String sdkVersion;
    }

    @KsJson
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aYr;
        public String aYs;
        public String aYt;
        public String aYu;
        public String aYv;
        public String aYw;
    }

    public static void Py() {
        h.execute(new bg() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.Pz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Pz() {
        C0380a a2;
        JSONObject jSONObject = (JSONObject) e.Hl().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.a.2
            private static JSONObject p(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return p(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.aYr == 1 && (a2 = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_tt_sdk_info", "sv").z(a2).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
            }
        } catch (Throwable unused) {
        }
    }

    private static C0380a a(ClassLoader classLoader, b bVar) {
        Class<?> a2 = z.a(bVar.aYs, classLoader);
        if (a2 == null) {
            return null;
        }
        C0380a c0380a = new C0380a();
        c0380a.aYq = z.classExists(bVar.aYt) ? 1 : 0;
        Object callStaticMethod = z.callStaticMethod(a2, bVar.aYu, new Object[0]);
        c0380a.sdkVersion = (String) z.callMethod(callStaticMethod, bVar.aYv, new Object[0]);
        c0380a.aTr = (String) z.callMethod(callStaticMethod, bVar.aYw, new Object[0]);
        return c0380a;
    }
}
