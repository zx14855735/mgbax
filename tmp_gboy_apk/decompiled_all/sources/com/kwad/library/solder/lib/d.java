package com.kwad.library.solder.lib;

import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> auE = new ConcurrentHashMap<>();
    private final Context mContext;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.auE.put(str, aVar);
            }
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.cz(7);
        eVar.BD().Bu().r(eVar);
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.BD().Bu().q(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.cz(0);
        eVar.BD().Bu().n(eVar);
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) {
        b(eVar);
        com.kwad.library.solder.lib.a.a a2 = eVar.ck(eVar.BK()).a(eVar.BP());
        String BB = a2.BB();
        File file = new File(BB);
        eVar.BH();
        com.kwad.library.solder.lib.a.d BD = eVar.BD();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String BH = eVar.BH();
        String version = eVar.getVersion();
        com.kwad.library.solder.lib.a.a cb = cb(BH);
        if (cb != null) {
            a(eVar);
            return cb;
        }
        a2.cf(BH);
        a2.ce(version);
        if (BD.Bt().a(BH, version, eVar.BO())) {
            String G = BD.Bt().G(BH, version);
            if (w.hg(G)) {
                a2.cg(G);
                a2.p(this.mContext, G);
                a(BH, a2);
                a(eVar);
                return a2;
            }
        }
        String b = BD.Bt().b(a2);
        a2.cg(b);
        a2.p(this.mContext, b);
        a(BH, a2);
        if (BB.endsWith(BD.Bq().BW())) {
            w.delete(BB);
        }
        a(eVar);
        return a2;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a cb(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.auE.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(com.kwad.library.solder.lib.a.e eVar) {
        eVar.BH();
        eVar.ch("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.auE.get(eVar.BH());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.BH();
            aVar.BB();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b BP = eVar.BP();
        if (BP == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", PluginError.ERROR_UPD_REQUEST));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> BQ = eVar.BQ();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (BQ != null && !BQ.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : BQ) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.BD().Bt().E(eVar.BH(), aVar3.version);
                }
            }
        }
        if (aVar2 != null) {
            String G = eVar.BD().Bt().G(aVar2.avL, aVar2.version);
            eVar.ci(G);
            eVar.cj(G);
            eVar.cz(2);
            eVar.ce(aVar2.version);
        } else {
            if (!ao.isWifiConnected(this.mContext) && (BP.avP || (BP.avQ && eVar.BJ() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return;
            }
            try {
                if (!eVar.BD().Bs().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, PluginError.ERROR_UPD_REQUEST));
                return;
            }
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String BK = eVar.BK();
        eVar.BH();
        if (TextUtils.isEmpty(BK)) {
            b(eVar, new PluginError.LoadError("path not found", PluginError.ERROR_UPD_FILE_NOT_FOUND));
            return;
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        try {
            com.kwad.library.solder.lib.a.a h = h(eVar);
            eVar.c(h);
            eVar.BH();
            a(eVar, h);
        } catch (PluginError.InstallError e) {
            e = e;
            b(eVar, e);
        } catch (PluginError.LoadError e2) {
            e = e2;
            b(eVar, e);
        } catch (Throwable th2) {
            a.e("PluginLoaderImpl", "load plugin failed, path = " + BK, th2);
            b(eVar, new PluginError.InstallError(A2egSU.B4ZgIw(th2, new StringBuilder("load or install plugin failed:")), 4004));
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.cz(6);
        eVar.j(pluginError);
        eVar.BD().Bu().c(eVar, pluginError);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.cz(8);
        eVar.BD().Bu().a(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.cz(5);
        eVar.BD().Bu().b(eVar, aVar);
    }
}
