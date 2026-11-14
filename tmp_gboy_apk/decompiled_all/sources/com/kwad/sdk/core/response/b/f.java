package com.kwad.sdk.core.response.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    private static volatile f aNC;
    private String aND = KM();

    private f() {
    }

    public static f KK() {
        if (aNC == null) {
            synchronized (f.class) {
                try {
                    if (aNC == null) {
                        aNC = new f();
                    }
                } finally {
                }
            }
        }
        return aNC;
    }

    private static String KM() {
        try {
            return w.a(new File(be.dV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static void eQ(String str) {
        try {
            w.a(new File(be.dV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public final String KL() {
        return this.aND;
    }

    public final void eP(String str) {
        if (bp.isEquals(this.aND, str)) {
            return;
        }
        this.aND = str;
        eQ(str);
    }
}
