package com.kwad.components.core.webview.tachikoma.b;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e extends w {
    private final b aks;

    public static class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, this.height);
            return jSONObject;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        int kn();
    }

    public e(b bVar) {
        this.aks = bVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.aks;
        if (bVar != null) {
            aVar.height = bVar.kn();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
