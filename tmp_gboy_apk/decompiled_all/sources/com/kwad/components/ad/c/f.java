package com.kwad.components.ad.c;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f extends com.kwad.components.core.widget.a.b {
    public f(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        com.kwad.sdk.core.c.b.Ji();
        if (!com.kwad.sdk.core.c.b.isEnable()) {
            return super.ae();
        }
        com.kwad.sdk.core.c.b.Ji();
        return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ae();
    }
}
