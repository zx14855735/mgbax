package com.kwad.sdk.collector;

import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    public static String cP(String str) {
        try {
            return new String(com.kwad.sdk.core.a.c.IZ().encode(q.j(w.V(new File(str)))));
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }
}
