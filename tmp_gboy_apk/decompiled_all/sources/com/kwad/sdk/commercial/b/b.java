package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aAl;
    public String aAs;
    public String aAt;
    public int aAu;
    public int aAv;
    public int status;
    public String url;

    public static b FJ() {
        return new b();
    }

    public final b cQ(int i) {
        this.status = i;
        return this;
    }

    public final b cR(int i) {
        this.aAu = i;
        return this;
    }

    public final b cS(int i) {
        this.aAv = i;
        return this;
    }

    public final b cU(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aAl = url.getHost();
            this.aAs = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cV(String str) {
        this.aAt = str;
        return this;
    }
}
