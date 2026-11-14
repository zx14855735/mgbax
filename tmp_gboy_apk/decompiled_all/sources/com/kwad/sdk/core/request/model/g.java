package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String aNA;
    public String aNx;
    public String aNy;
    public String aNz;
    public String serviceToken;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g KH() {
        return new g();
    }

    public final g eK(String str) {
        this.aNx = str;
        return this;
    }

    public final g eL(String str) {
        this.aNz = str;
        return this;
    }

    public final g eM(String str) {
        this.serviceToken = str;
        return this;
    }

    public final void eN(String str) {
        this.aNA = str;
    }
}
