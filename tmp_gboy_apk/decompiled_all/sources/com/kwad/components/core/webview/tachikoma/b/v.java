package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    private a akF;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.c.n nVar);
    }

    public final void a(a aVar) {
        this.akF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.akF = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.akF != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            try {
                nVar.parseJson(new JSONObject(str));
                this.akF.b(nVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
