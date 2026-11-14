package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int UO;
    public String aAl;
    public String aAs;
    public int status;
    public String url;

    public static b FO() {
        return new b();
    }

    public final b cV(int i) {
        this.status = i;
        return this;
    }

    public final b cW(int i) {
        this.UO = i;
        return this;
    }

    public final b de(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aAl = url.getHost();
            this.aAs = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
