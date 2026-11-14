package com.kwad.sdk.utils.b;

import J3FDQU.A2egSU;
import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public int bhQ = -1;
    public int bhR = -1;
    public int bhS = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        StringBuilder sb = new StringBuilder("KvOperationRecord{putCount=");
        sb.append(this.bhQ);
        sb.append(", getFailedCount=");
        sb.append(this.bhR);
        sb.append(", getSuccessCount=");
        return A2egSU.B2KMhB(sb, this.bhS, '}');
    }
}
