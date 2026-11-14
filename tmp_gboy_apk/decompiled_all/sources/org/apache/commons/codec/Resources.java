package org.apache.commons.codec;

import ADYaiT.CtFAbx;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Resources {
    public static InputStream getInputStream(String str) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException(CtFAbx.BChYOn("Unable to resolve required resource: ", str));
    }
}
