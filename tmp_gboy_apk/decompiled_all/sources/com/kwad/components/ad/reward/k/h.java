package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a Bc;

    public interface a {
        void af(int i);
    }

    public h(a aVar) {
        this.Bc = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        int i;
        if (this.Bc != null) {
            try {
                i = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            this.Bc.af(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Bc = null;
    }
}
