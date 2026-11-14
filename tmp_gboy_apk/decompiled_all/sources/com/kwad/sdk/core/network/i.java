package com.kwad.sdk.core.network;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends com.kwad.sdk.commercial.c.a {
    public String aJt;
    public int aJu = 0;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return toJson().toString();
    }
}
