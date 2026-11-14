package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class g implements IOfflineTKCallHandler {
    private final q aoO;

    public g(q qVar) {
        this.aoO = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.aoO;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }
}
