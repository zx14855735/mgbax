package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Observable;
import java.util.Observer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a extends w implements Observer {
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        b(this.mAdTemplate.mAdStatusInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getTrackAdStatus";
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        AdStatusInfo adStatusInfo = (AdStatusInfo) obj;
        if (adStatusInfo != null) {
            b(adStatusInfo);
        }
    }
}
