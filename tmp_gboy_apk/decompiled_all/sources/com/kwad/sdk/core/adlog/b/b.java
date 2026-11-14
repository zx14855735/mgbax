package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aAV;
    public int aBW;
    public String aBX;
    public boolean aCg;
    public int aCh;
    public int aCi;
    public long aCj;
    public int retryCount;
    public int status;

    public static b Gx() {
        return new b();
    }

    public final b at(long j) {
        this.aCj = j;
        return this;
    }

    public final b bt(boolean z) {
        this.aCg = z;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cj, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b dB(String str) {
        this.aBX = str;
        return this;
    }

    public final b dd(int i) {
        this.status = i;
        return this;
    }

    public final b de(int i) {
        this.aAV = i;
        return this;
    }

    public final b df(int i) {
        this.retryCount = i;
        return this;
    }

    public final b dg(int i) {
        this.aBW = i;
        return this;
    }

    public final b dh(int i) {
        this.aCh = i;
        return this;
    }

    public final b di(int i) {
        this.aCi = i;
        return this;
    }
}
