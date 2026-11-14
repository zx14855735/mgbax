package com.kwad.sdk.commercial.smallApp;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aAQ;
    public String aAR;
    public String aAS;
    public String aAl;
    public String aAs;
    public int status;
    public String url;

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.aAS = jumpFrom.getValue();
        }
    }

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    public final b cX(int i) {
        this.status = i;
        return this;
    }

    public final b dk(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aAl = url.getHost();
            this.aAs = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b dl(String str) {
        this.aAQ = str;
        return this;
    }

    public final b dm(String str) {
        this.aAR = str;
        return this;
    }
}
