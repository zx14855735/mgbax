package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class s {
    private static boolean bea;
    private static boolean beb;

    public static boolean RH() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(2L)) & bea;
    }

    public static boolean RI() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(4L)) & bea;
    }

    public static boolean RJ() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX)) & bea;
    }

    public static boolean RK() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Df() && bea;
    }

    public static boolean RL() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(16L)) & bea;
    }

    public static boolean RM() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF)) & bea;
    }

    public static boolean RN() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1L)) & bea;
    }

    public static boolean RO() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(128L)) & bea;
    }

    public static boolean RP() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(128L)) & bea;
    }

    public static synchronized void cf(boolean z) {
        synchronized (s.class) {
            if (beb) {
                return;
            }
            beb = true;
            bea = true;
            GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.sdk.utils.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).CP();
                }
            });
        }
    }
}
