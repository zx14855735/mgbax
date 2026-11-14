package com.kwad.components.core.webview.jshandler;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class bf implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c agg;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aip;

        public a(int i) {
            this.aip = i;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.agg = cVar;
    }

    public final void aj(boolean z) {
        if (this.agg == null) {
            A2egSU.A4TApA(z ? 1 : 0, "notifyTaskStatus , status:", "WebCardRewardTaskStatusHandler");
        } else {
            this.agg.a(new a(z ? 1 : 0));
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
