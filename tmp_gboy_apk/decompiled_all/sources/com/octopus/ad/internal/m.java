package com.octopus.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.HTTPResponse;
import com.octopus.ad.internal.utilities.SPUtils;
import com.octopus.ad.utils.ThreadUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m extends HTTPGet {

    /* renamed from: a, reason: collision with root package name */
    private final String f12442a;

    public m(String str) {
        super(true);
        this.f12442a = str;
    }

    @Override // com.octopus.ad.internal.utilities.HTTPGet
    public String getUrl() {
        return this.f12442a;
    }

    @Override // com.octopus.ad.internal.utilities.HTTPGet
    public void onPostExecute(HTTPResponse hTTPResponse) {
        if (hTTPResponse == null || TextUtils.isEmpty(hTTPResponse.getResponseBody())) {
            return;
        }
        try {
            Context j = q.a().j();
            if (!"{}".equals(hTTPResponse.getResponseBody())) {
                SPUtils.put(j, "responseBody", hTTPResponse.getResponseBody());
                ThreadUtils.runOnThreadPool(new com.octopus.ad.utils.b.b(j));
            }
            SPUtils.put(j, "lastReqTime", Long.valueOf(com.octopus.ad.utils.b.i.c()));
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
