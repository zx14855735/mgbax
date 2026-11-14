package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate != null) {
            this.creativeId = e.eB(adTemplate);
            this.llsid = e.eo(adTemplate);
            this.posId = e.ek(adTemplate);
            AdInfo er = e.er(adTemplate);
            this.campaignType = com.kwad.sdk.core.response.b.a.dq(er);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.dr(er);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.ds(er);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aR(er);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.dt(er);
            AdMatrixInfo.MatrixTemplate bi = com.kwad.sdk.commercial.e.bi(adTemplate);
            if (bi != null) {
                this.templateId = bi.templateId;
                this.templateVersion = String.valueOf(bi.templateVersionCode);
                this.tkPublishType = bi.publishType;
            }
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }
}
