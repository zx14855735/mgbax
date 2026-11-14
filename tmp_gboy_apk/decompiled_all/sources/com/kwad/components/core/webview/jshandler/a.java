package com.kwad.components.core.webview.jshandler;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b afY;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0315a extends com.kwad.sdk.core.response.a.a {
        public String Om;
        public String agb;
        public String agc;
    }

    public interface b {
        void c(C0315a c0315a);
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int agd;
        public long age;
        public boolean agf;
        public int errorCode;
    }

    public a(b bVar) {
        this.afY = bVar;
    }

    private void b(final C0315a c0315a) {
        bw.postOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.this.afY != null) {
                    a.this.afY.c(c0315a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0315a c0315a = new C0315a();
            c0315a.parseJson(new JSONObject(str));
            b(c0315a);
        } catch (Throwable unused) {
        }
    }
}
