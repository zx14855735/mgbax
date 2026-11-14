package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bk implements com.kwad.sdk.core.webview.c.a {
    private a aiD;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    public interface a {
        boolean eN();
    }

    public bk(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.aiD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aiD;
        boolean eN = aVar != null ? aVar.eN() : true;
        A2egSU.B9tovu("handleJsCall launch AdPlayableActivityProxy : ", "WebShowPlayableHandler", eN);
        if (eN) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }
}
