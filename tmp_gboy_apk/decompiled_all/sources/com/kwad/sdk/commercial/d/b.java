package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public boolean aAB;
    public boolean aAC;
    public String aAD;
    public int adNum;
    public String adSource;
    public String methodName;

    public static b FK() {
        return new b();
    }

    public final b br(boolean z) {
        this.aAB = z;
        return this;
    }

    public final b cT(int i) {
        this.adNum = i;
        return this;
    }

    public final b cW(String str) {
        this.methodName = str;
        return this;
    }

    public final b cX(String str) {
        this.aAD = str;
        return this;
    }

    public final b cY(String str) {
        this.adSource = str;
        return this;
    }
}
