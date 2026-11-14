package com.kwad.components.core.c;

import ADYaiT.CtFAbx;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private static void ah(String str) {
        if (op() && com.kwad.sdk.l.DP().CW()) {
            ac.S(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        ah(CtFAbx.ARc23Z(eVar.ou(), "使用缓存策略: "));
    }

    public static boolean op() {
        return false;
    }
}
