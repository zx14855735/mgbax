package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private Vibrator gZ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.gZ = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        bw.a(ServiceProvider.getContext(), this.gZ);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
