package com.kwad.sdk.core.network;

import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NormalResultData extends BaseResultData {
    public int code;
    public String data;
    public Map<String, String> header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.aIW;
        this.header = null;
    }
}
