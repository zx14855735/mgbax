package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static List<WeakReference<k.b>> Ps;

    /* renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0291a {
        private b PA;
        private d PB;
        private boolean PC;
        private boolean PD;
        private long PE;
        private boolean PF;
        private boolean PG;
        public String PI;
        public a.C0353a PJ;
        private JSONObject PM;
        private boolean PO;
        private int PP;
        private int PQ;
        private int PR;
        private int PS;
        private Callable<String> PT;
        private String PU;
        private boolean PV;
        private boolean Pt;
        private boolean Pu;
        private boolean Pv;
        private boolean Pw;
        private boolean Px;
        private boolean Py;
        private boolean Pz;
        private AdTemplate adTemplate;
        private final Context context;
        private int mF;
        private int mH;
        public aj.a mJ;
        public long yY;
        public int PH = -1;
        public int PK = 0;
        public int PL = -1;
        private boolean PN = false;

        public C0291a(Context context) {
            this.context = context;
        }

        public final C0291a A(long j) {
            this.PE = j;
            return this;
        }

        public final C0291a B(long j) {
            this.yY = j;
            return this;
        }

        public final C0291a a(Callable<String> callable) {
            this.PT = callable;
            return this;
        }

        public final void aA(int i) {
            this.PQ = i;
        }

        public final C0291a aB(int i) {
            this.PS = i;
            return this;
        }

        public final C0291a aC(int i) {
            this.mH = i;
            return this;
        }

        public final C0291a aD(int i) {
            this.mF = i;
            return this;
        }

        public final C0291a aE(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0291a aF(int i) {
            this.PL = i;
            return this;
        }

        public final C0291a aG(int i) {
            this.PP = i;
            return this;
        }

        public final C0291a aH(int i) {
            this.PR = i;
            return this;
        }

        public final C0291a ao(String str) {
            this.PU = str;
            return this;
        }

        public final C0291a ap(boolean z) {
            this.Py = z;
            return this;
        }

        public final C0291a aq(boolean z) {
            this.Pz = true;
            return this;
        }

        public final C0291a ar(boolean z) {
            this.Px = true;
            return this;
        }

        public final C0291a as(boolean z) {
            this.PC = z;
            return this;
        }

        public final C0291a at(boolean z) {
            this.PF = z;
            return this;
        }

        public final C0291a au(boolean z) {
            this.PG = z;
            return this;
        }

        public final C0291a av(boolean z) {
            this.PN = z;
            return this;
        }

        public final C0291a aw(boolean z) {
            this.Pu = z;
            return this;
        }

        public final C0291a ax(boolean z) {
            this.Pw = true;
            return this;
        }

        public final C0291a ay(boolean z) {
            this.Pt = z;
            return this;
        }

        public final C0291a az(boolean z) {
            this.PO = z;
            return this;
        }

        public final C0291a b(d dVar) {
            this.PB = dVar;
            return this;
        }

        public final C0291a d(aj.a aVar) {
            this.mJ = aVar;
            return this;
        }

        public final int dX() {
            return this.mF;
        }

        public final int ea() {
            return this.mH;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final d ik() {
            return this.PB;
        }

        public final JSONObject iy() {
            return this.PM;
        }

        public final boolean pA() {
            return this.Pz;
        }

        public final boolean pB() {
            return this.PC;
        }

        public final long pC() {
            return this.PE;
        }

        public final boolean pD() {
            return this.PF;
        }

        public final boolean pE() {
            return this.PG;
        }

        public final com.kwad.sdk.core.adlog.c.a pF() {
            return com.kwad.sdk.core.adlog.c.a.Gz().dp(this.mH).dE(this.PI).e(this.mJ).dq(this.PK).dr(this.PL).au(this.yY).a(this.PJ).ds(this.PH);
        }

        public final boolean pG() {
            return this.PN;
        }

        public final boolean pH() {
            return this.Pu;
        }

        public final boolean pI() {
            return this.Pw;
        }

        public final boolean pJ() {
            return this.Pt;
        }

        public final boolean pK() {
            return this.PO;
        }

        public final int pL() {
            return this.PP;
        }

        public final int pM() {
            return this.PR;
        }

        public final boolean pN() {
            return this.Pv;
        }

        public final boolean pO() {
            return this.PV;
        }

        public final String ps() {
            return this.PU;
        }

        public final Callable<String> pt() {
            return this.PT;
        }

        public final boolean pu() {
            return this.PD;
        }

        public final int pv() {
            return this.PQ;
        }

        public final b pw() {
            return this.PA;
        }

        public final boolean px() {
            return this.Px;
        }

        public final int py() {
            return this.PS;
        }

        public final boolean pz() {
            return this.Py;
        }

        public final C0291a a(b bVar) {
            this.PA = bVar;
            return this;
        }

        public final C0291a aA(boolean z) {
            this.Pv = true;
            return this;
        }

        public final void aB(boolean z) {
            this.PV = true;
        }

        public final C0291a aE(int i) {
            this.PK = i;
            return this;
        }

        public final void ao(boolean z) {
            this.PD = true;
        }

        public final C0291a ap(String str) {
            this.PI = str;
            return this;
        }

        public final C0291a d(JSONObject jSONObject) {
            this.PM = jSONObject;
            return this;
        }

        public final C0291a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.PJ == null) {
                this.PJ = new a.C0353a();
            }
            this.PJ.a(this.adTemplate, null, null, null);
            return this;
        }
    }

    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, d dVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        e.aC(false);
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0291a av = new C0291a(context).aE(adTemplate).a(bVar).b(dVar).as(z).at(z2).ap(z4).av(false);
        int ao = com.kwad.sdk.core.response.b.a.ao(er);
        if (!z3 && av.pM() != 2 && av.pM() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(er)) && !av.pI()) {
            if (ao == 1) {
                return com.kwad.sdk.core.response.b.a.bj(er) ? k(av) : l(av);
            }
            if (ao == 2) {
                int h = h(av);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                return com.kwad.sdk.core.response.b.a.bj(er) ? k(av) : l(av);
            }
        }
        int h2 = h(av);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aG(er)) {
            if (j(av)) {
                return 11;
            }
            return l(av);
        }
        int m = m(av);
        int i = er.status;
        if (i != 2 && i != 3) {
            e(av);
        }
        return m;
    }

    private static int b(C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(er) || c0291a.pu() || c0291a.pz()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0304a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aJ(true).rV());
            d(adTemplate, 20);
            return 20;
        }
        c0291a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0291a);
        d(adTemplate, 19);
        return 19;
    }

    public static boolean c(C0291a c0291a) {
        return com.kwad.sdk.core.response.b.a.aG(com.kwad.sdk.core.response.b.e.er(c0291a.getAdTemplate())) ? !c0291a.pK() && d.E(c0291a) == 3 : d(c0291a) == 1;
    }

    private static int d(C0291a c0291a) {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(c0291a.getAdTemplate());
        if (er.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int dX = c0291a.dX();
        return dX != 2 ? dX != 3 ? er.unDownloadConf.unDownloadRegionConf.actionBarType : er.unDownloadConf.unDownloadRegionConf.materialJumpType : er.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void e(C0291a c0291a) {
        if (c0291a.pu() || c0291a.pO()) {
            return;
        }
        g(c0291a);
        f(c0291a);
        if (c0291a.pw() != null) {
            try {
                c0291a.pw().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.br(c0291a.getAdTemplate());
    }

    private static void f(C0291a c0291a) {
        if (c0291a.pE()) {
            com.kwad.sdk.core.adlog.c.a(c0291a.adTemplate, c0291a.pF(), c0291a.iy());
        }
    }

    private static void g(C0291a c0291a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Ps;
        if (list == null || list.isEmpty() || c0291a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : Ps) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.eB(c0291a.adTemplate));
            }
        }
    }

    private static int h(C0291a c0291a) {
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        int a2 = e.a(c0291a, 1);
        if (a2 != 1) {
            if (a2 == 2) {
                e(c0291a);
                d(adTemplate, 16);
            }
            return a2;
        }
        e.aC(true);
        e(c0291a);
        if ((com.kwad.sdk.core.response.b.a.cR(er) || com.kwad.sdk.core.response.b.a.cS(er)) && !c0291a.pN()) {
            com.kwad.sdk.core.adlog.c.m(c0291a.getAdTemplate(), (int) Math.ceil(c0291a.pC() / 1000.0f));
        }
        d(adTemplate, 13);
        return a2;
    }

    private static int i(C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(c0291a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0291a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.U(er) || c0291a.pu() || !f.F(er) || c0291a.pz()) {
            int e = f.e(context, adTemplate);
            if (e == 1) {
                e(c0291a);
                d(adTemplate, 12);
            }
            return e;
        }
        c0291a.aA(1);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0291a);
        e(c0291a);
        d(adTemplate, 17);
        return 2;
    }

    private static boolean j(C0291a c0291a) {
        AdTemplate adTemplate = c0291a.getAdTemplate();
        boolean l = com.kwad.sdk.utils.e.l(c0291a.getContext(), adTemplate);
        if (l) {
            e(c0291a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return l;
    }

    private static int k(C0291a c0291a) {
        e(c0291a);
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(c0291a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0291a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(er) || c0291a.pu() || c0291a.pz()) {
            AdWebViewVideoActivityProxy.launch(c0291a.getContext(), adTemplate);
            d(adTemplate, 15);
            return 15;
        }
        c0291a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0291a);
        d(adTemplate, 19);
        return 19;
    }

    private static int l(C0291a c0291a) {
        e(c0291a);
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(er) || c0291a.pu() || c0291a.pz()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0304a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aK(c0291a.px()).aQ(com.kwad.sdk.core.response.b.a.dA(er) ? 2 : 1).rV());
            d(adTemplate, 14);
            return 14;
        }
        c0291a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0291a);
        d(adTemplate, 19);
        return 19;
    }

    private static int m(C0291a c0291a) {
        d ik = c0291a.ik();
        if (ik == null) {
            ik = new d(c0291a.adTemplate);
            c0291a.b(ik);
        }
        int v = ik.v(c0291a);
        d(c0291a.getAdTemplate(), v);
        return v;
    }

    private static int n(C0291a c0291a) {
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (j(c0291a)) {
            return 11;
        }
        return (!com.kwad.sdk.core.response.b.a.b(er, com.kwad.sdk.core.config.e.Hc()) || adTemplate.mAdWebVideoPageShowing) ? l(c0291a) : k(c0291a);
    }

    public static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bM(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bK(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bL(adTemplate);
                break;
        }
    }

    public static void b(k.b bVar) {
        if (Ps == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= Ps.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = Ps.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            Ps.remove(i);
        }
    }

    public static int a(C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        e.aC(false);
        if (c0291a.pA()) {
            return b(c0291a);
        }
        if (c0291a.pJ()) {
            return a(context, adTemplate, c0291a.pw(), c0291a.ik(), c0291a.PC, c0291a.pD(), false, c0291a.pz());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0291a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        if (com.kwad.sdk.core.response.b.a.dA(er) && !adTemplate.hasInnerEcFailed()) {
            e(c0291a);
            c0291a.aB(true);
            int a2 = com.kwad.components.core.innerEc.f.a(context, adTemplate, c0291a);
            if (a2 == 1) {
                return 14;
            }
            if (a2 == 2) {
                com.kwad.components.core.innerEc.qcpx.b.h(context, adTemplate);
                com.kwad.components.core.innerEc.f.g(context, adTemplate);
                return 14;
            }
            if (a2 == 3) {
                return com.kwad.components.core.innerEc.f.G(c0291a);
            }
        }
        int ao = com.kwad.sdk.core.response.b.a.ao(er);
        if (c0291a.pM() != 2 && c0291a.pM() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(er)) && !c0291a.pI()) {
            if (ao == 1) {
                if (com.kwad.sdk.core.response.b.a.bj(er)) {
                    return k(c0291a);
                }
                return l(c0291a);
            }
            if (ao == 2) {
                int h = h(c0291a);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bj(er)) {
                    return k(c0291a);
                }
                return l(c0291a);
            }
        }
        int h2 = h(c0291a);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        int i = i(c0291a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0291a.pH() && !com.kwad.sdk.core.response.b.a.aG(er)) {
            return n(c0291a);
        }
        if (!com.kwad.sdk.core.response.b.a.aG(er)) {
            if (adTemplate.isWebViewDownload) {
                int m = m(c0291a);
                adTemplate.isWebViewDownload = false;
                return m;
            }
            if (j(c0291a)) {
                return 11;
            }
            return l(c0291a);
        }
        if (c0291a.pM() != 2 && c0291a.pM() != 1) {
            if (c0291a.pH() && com.kwad.sdk.core.response.b.a.b(er, com.kwad.sdk.core.config.e.Hc()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(er)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int u = c0291a.ik().u(c0291a);
                if (u == 0) {
                    return k(c0291a);
                }
                e(c0291a);
                d(adTemplate, u);
                return u;
            }
            e(c0291a);
            c0291a.av(true);
            return m(c0291a);
        }
        c0291a.av(false);
        e(c0291a);
        return m(c0291a);
    }

    public static void a(k.b bVar) {
        if (Ps == null) {
            Ps = new CopyOnWriteArrayList();
        }
        Ps.add(new WeakReference<>(bVar));
    }
}
