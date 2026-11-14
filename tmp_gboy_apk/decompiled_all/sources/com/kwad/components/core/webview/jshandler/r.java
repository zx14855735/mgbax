package com.kwad.components.core.webview.jshandler;

import android.content.Intent;
import android.text.TextUtils;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.a aVar = new q.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (TextUtils.isEmpty(aVar.message)) {
            return;
        }
        Intent intent = new Intent("ksad_webView_local_broadcast");
        intent.putExtra(PointParamKey.DATA, aVar.message);
        com.kwad.sdk.utils.ad.cX(ServiceProvider.getContext()).i(intent);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "postMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
