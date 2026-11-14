package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aAF;
    public String aAG;

    public static b FL() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bQ, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cZ(String str) {
        this.aAF = str;
        return this;
    }

    public final b da(String str) {
        this.aAG = str;
        return this;
    }
}
