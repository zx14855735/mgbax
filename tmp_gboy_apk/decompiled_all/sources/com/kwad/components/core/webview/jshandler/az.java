package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class az extends com.kwad.components.core.webview.tachikoma.b.w {

    public static final class a implements com.kwad.sdk.core.b {
        private String aid;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lifeStatus", this.aid);
            return jSONObject;
        }
    }

    private void bk(String str) {
        a aVar = new a();
        aVar.aid = str;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void wg() {
        bk("showStart");
    }

    public final void wh() {
        bk("showEnd");
    }

    public final void wi() {
        bk("hideStart");
    }

    public final void wj() {
        bk("hideEnd");
    }

    public final void wk() {
        bk("pageVisiable");
    }

    public final void wl() {
        bk("pageInvisiable");
    }
}
