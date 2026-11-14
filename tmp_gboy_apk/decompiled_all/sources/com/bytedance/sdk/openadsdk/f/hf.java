package com.bytedance.sdk.openadsdk.f;

import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.ra.z;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static am xj(String str) {
        return xj(xj().from(str));
    }

    public static am xj(z zVar) {
        return xj(xj().from(zVar.xj()).width(zVar.hf()).height(zVar.w()).key(zVar.c()));
    }

    public static InputStream xj(String str, String str2) {
        return xj().getCacheStream(str, str2);
    }

    public static ht xj() {
        return (ht) com.bytedance.sdk.openadsdk.ats.w.xj("img_service");
    }

    private static am xj(am amVar) {
        return a.xj() ? amVar.track(new w()) : amVar;
    }
}
