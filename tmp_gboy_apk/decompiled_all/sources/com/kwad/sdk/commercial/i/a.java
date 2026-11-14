package com.kwad.sdk.commercial.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String aAF;
    public String aAN;
    public String aAO;
    public String aAP;

    public static a FR() {
        return new a();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bR, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final a dg(String str) {
        this.aAP = str;
        return this;
    }

    public final a dh(String str) {
        this.aAF = str;
        return this;
    }

    public final a di(String str) {
        this.aAN = str;
        return this;
    }

    public final a dj(String str) {
        this.aAO = str;
        return this;
    }
}
