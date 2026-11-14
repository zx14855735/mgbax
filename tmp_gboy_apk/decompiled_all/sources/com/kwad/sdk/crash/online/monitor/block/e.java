package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aUO;

    public static com.kwad.sdk.crash.online.monitor.a.a NE() {
        return aUO;
    }

    public static boolean NF() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aUO;
        return aVar != null && aVar.NI();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.NL()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.NC()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aUO = aVar;
            boolean bL = a.bL(true);
            com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bL);
            if (aVar.aAi < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.NJ() && bL) {
                c.b(aVar);
            }
            if (aVar.NK()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.bM(false));
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }
}
