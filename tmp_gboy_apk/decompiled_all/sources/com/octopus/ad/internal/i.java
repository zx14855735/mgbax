package com.octopus.ad.internal;

import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.HTTPResponse;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends HTTPGet {

    /* renamed from: a, reason: collision with root package name */
    private final String f12438a;
    private HTTPGet.ResponseListener b;

    public i(String str) {
        super(false);
        this.f12438a = str;
    }

    public i a(HTTPGet.ResponseListener responseListener) {
        this.b = responseListener;
        return this;
    }

    @Override // com.octopus.ad.internal.utilities.HTTPGet
    public String getUrl() {
        return this.f12438a;
    }

    @Override // com.octopus.ad.internal.utilities.HTTPGet
    public void onPostExecute(HTTPResponse hTTPResponse) {
        HTTPGet.ResponseListener responseListener = this.b;
        if (responseListener == null || hTTPResponse == null) {
            return;
        }
        responseListener.getResponse(hTTPResponse.getResponseCode(), hTTPResponse.getSucceeded(), hTTPResponse.getResponseBody());
    }
}
