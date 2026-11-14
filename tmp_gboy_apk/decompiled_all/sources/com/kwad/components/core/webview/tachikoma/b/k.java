package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class k extends w {
    b akx = new b() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1
        @Override // com.kwad.components.core.webview.tachikoma.b.k.b
        public final void S(final long j) {
            if (k.this.qm != null) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j;
                        k.this.qm.a(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c qm;

    public static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        void S(long j);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.akx);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qm = cVar;
        com.kwad.components.core.e.d.a.a(this.akx);
    }
}
