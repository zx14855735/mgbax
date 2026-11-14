package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b ags;
    private int ahy = 0;
    private a ahz;

    public interface a {
        void onAdShow();
    }

    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String Om;
        private String PI;
        private int actionType;
        private AdTemplate adTemplate;
        private int ahA;

        public final int getActionType() {
            return this.actionType;
        }

        public final String oH() {
            return this.Om;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.ahA = jSONObject.optInt("refreshType");
            this.PI = jSONObject.optString("payload");
            this.Om = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.offline.a.f.a.a.aK(jSONObject.optInt("adCacheId")), this.Om);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", this.PI);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", this.ahA);
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.Om);
            return jSONObject;
        }

        public final String we() {
            return this.PI;
        }
    }

    public am(com.kwad.sdk.core.webview.b bVar) {
        this.ags = bVar;
    }

    private AdTemplate c(b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.ags.dx(bVar.Om);
    }

    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public void b(boolean z, AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.s.b.ut().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public final void a(a aVar) {
        this.ahz = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(b bVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b dF = new com.kwad.sdk.core.adlog.c.b().dF(bVar.PI);
            a aVar = this.ahz;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                dF.dz(this.ahy);
                b(true, bVar.adTemplate, null, dF);
                return;
            }
            if (bp.isNullString(bVar.oH())) {
                b(true, this.ags.getAdTemplate(), null, dF);
                return;
            }
            if (this.ags.MC() != null) {
                for (AdTemplate adTemplate : this.ags.MC()) {
                    if (bp.isEquals(bVar.oH(), String.valueOf(com.kwad.sdk.core.response.b.e.eB(adTemplate)))) {
                        b(false, adTemplate, null, dF);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (bVar.actionType != 2) {
            if (bVar.actionType == 12006) {
                com.kwad.components.core.o.a.tz().f(c(bVar), bVar.ahA, this.ahy);
                return;
            }
            if (bVar.actionType != 140) {
                if (bVar.actionType == 141) {
                    com.kwad.sdk.core.adlog.c.e(c(bVar), this.ags.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dF(bVar.PI));
                    return;
                } else {
                    com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.ags.mReportExtData, bVar.PI);
                    com.kwad.components.core.webview.tachikoma.e.a.xj().bu(bVar.PI);
                    return;
                }
            }
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.ags.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dF(bVar.PI));
            return;
        }
        com.kwad.sdk.widget.g gVar = this.ags.aRL;
        com.kwad.sdk.core.adlog.c.b dF2 = new com.kwad.sdk.core.adlog.c.b().dz(this.ahy).dF(bVar.PI);
        if (gVar != null) {
            dF2.f(gVar.getTouchCoords());
        }
        a(dF2);
        com.kwad.sdk.core.adlog.c.a(c(bVar), dF2, this.ags.mReportExtData);
    }
}
