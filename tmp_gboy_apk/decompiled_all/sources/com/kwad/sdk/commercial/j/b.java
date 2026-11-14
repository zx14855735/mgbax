package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aAN;
    public String aAO;
    public int aAV;
    public int requestType;
    public int status;

    public static b FV() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bS, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cY(int i) {
        this.status = i;
        return this;
    }

    public final b cZ(int i) {
        this.aAV = i;
        return this;
    }

    public final b da(int i) {
        this.requestType = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: db, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    /* renamed from: do, reason: not valid java name */
    public final b m12do(String str) {
        this.aAN = str;
        return this;
    }

    public final b dp(String str) {
        this.aAO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dq, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
