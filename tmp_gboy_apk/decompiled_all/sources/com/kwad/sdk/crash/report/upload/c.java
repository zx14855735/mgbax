package com.kwad.sdk.crash.report.upload;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c extends com.kwad.sdk.core.network.b {
    public final Map<String, String> aVv;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aVv = hashMap;
        hashMap.put("did", str);
        hashMap.put("sid", str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aVv;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.Jz().X("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
