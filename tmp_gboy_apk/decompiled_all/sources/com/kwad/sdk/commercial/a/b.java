package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aAl;
    public String aAm;
    public String aAn;
    public long aAo;
    public long aAp;
    public int aAq;
    public int aAr;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b FI() {
        return new b();
    }

    public final b ar(long j) {
        this.downloadTime = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bq, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo er = e.er(adTemplate);
        this.url = e.eu(adTemplate);
        try {
            this.aAl = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = er.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = er.adBaseInfo;
        this.aAm = adBaseInfo.appPackageName;
        this.aAn = adBaseInfo.appName;
        this.aAo = er.totalBytes;
        this.aAp = er.soFarBytes;
        return this;
    }

    public final b cN(int i) {
        this.status = i;
        return this;
    }

    public final b cO(int i) {
        this.aAq = i;
        return this;
    }

    public final b cP(int i) {
        this.aAr = i;
        return this;
    }
}
