package com.kwad.components.core.webview.jshandler.a;

import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0316a extends com.kwad.sdk.core.response.a.a {
        public String aiE;
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String be(String str) {
        try {
            C0316a c0316a = new C0316a();
            c0316a.parseJson(new JSONObject(str));
            return c0316a.aiE;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "checkAppInstalled";
    }
}
