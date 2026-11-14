package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String aAO;
    public int aAV;
    public int aCk;
    public int retryCount;
    public int status;

    public static d Gy() {
        return new d();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ck, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d dC(String str) {
        this.aAO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dD, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final d dj(int i) {
        this.status = i;
        return this;
    }

    public final d dk(int i) {
        this.aAV = i;
        return this;
    }

    public final d dl(int i) {
        this.aCk = 1;
        return this;
    }

    public final d dm(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dn, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }
}
