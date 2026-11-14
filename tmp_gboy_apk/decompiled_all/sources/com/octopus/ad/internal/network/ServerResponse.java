package com.octopus.ad.internal.network;

import B4ZgIw.AYUAbz;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.d;
import com.octopus.ad.internal.j;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.o;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.t;
import com.octopus.ad.internal.u;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.UrlUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.utilities.WebviewUtil;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.model.ShakeValue;
import com.octopus.ad.model.c;
import com.octopus.ad.model.e;
import com.octopus.ad.model.g;
import com.octopus.ad.model.h;
import com.octopus.ad.model.i;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ServerResponse {
    private boolean A;
    private int B;
    private AdLogoInfo C;
    private AdLogoInfo D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private String K;
    private String L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Boolean T;
    private boolean U;
    private boolean V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f12492a;
    private List<c.i> aA;
    private String aB;
    private String aC;
    private long aD;
    private p aE;
    private d aF;
    private List<Pair<j, String>> aG;
    private String aH;
    private String aI;
    private String aJ;
    private String aK;
    private boolean aL;
    private boolean aM;
    private boolean aN;
    private boolean aO;
    private LinkedList<String> aP;
    private HashMap<String, Object> aQ;
    private boolean aR;
    private boolean aS;
    private boolean aT;
    private long aU;
    private long aV;
    private boolean aW;
    private int aX;
    private boolean aY;
    private boolean aZ;
    private String aa;
    private String ab;
    private String ac;
    private int ad;
    private Map<String, Object> ae;
    private com.octopus.ad.a.a af;
    private com.octopus.ad.internal.nativead.c ag;
    private c.k ah;
    private c.l ai;
    private c.y aj;
    private h ak;
    private ShakeValue al;
    private WebView am;
    private e an;
    private k.a ao;
    private c.b.a ap;
    private int aq;
    private String ar;
    private String as;
    private String at;
    private String au;
    private ComplianceInfo av;
    private i aw;
    private c.b ax;
    private c.o ay;
    private c.w az;
    public String b;
    private g.a c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    public static class AdLogoInfo {
        public static int TYPE_PIC = 0;
        public static int TYPE_TEXT = 1;
        String adurl;
        int type = 0;

        public String getAdurl() {
            return this.adurl;
        }

        public int getType() {
            return this.type;
        }

        public void setAdurl(String str) {
            this.adurl = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public ServerResponse(c.t tVar, d dVar, p pVar, String str) {
        this.d = 0;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = false;
        this.B = 0;
        this.C = new AdLogoInfo();
        this.D = new AdLogoInfo();
        this.E = false;
        this.P = false;
        this.Q = false;
        this.R = true;
        this.S = true;
        this.aG = new LinkedList();
        this.aP = new LinkedList<>();
        this.aQ = new HashMap<>();
        this.aR = false;
        this.aS = false;
        this.aX = 0;
        if (tVar == null) {
            HaoboLog.clearLastResponse();
            return;
        }
        HaoboLog.setLastResponse(tVar.toString());
        HaoboLog.d(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_body, HaoboLog.getLastResponse()));
        this.aF = dVar;
        this.aE = pVar;
        this.Y = str;
        a(tVar);
    }

    private void ak() {
        if (this.aF != null) {
            o.a(new l("COPY", e(), this.Y, System.currentTimeMillis() - this.aF.i(), this.Z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.ao != null) {
            k.a().b(this.ao);
        }
    }

    private void am() {
        if (!q.a().d() || TextUtils.isEmpty(this.ab)) {
            return;
        }
        q.a().a(this.O);
        com.octopus.ad.model.a aVar = new com.octopus.ad.model.a();
        aVar.g(this.K);
        aVar.a(this.Y);
        aVar.f(this.ab);
        q.a().g.put("dpForbid", aVar);
    }

    public boolean A() {
        return this.s;
    }

    public boolean B() {
        return this.t;
    }

    public int C() {
        return this.y;
    }

    public int D() {
        return this.z;
    }

    public int E() {
        return this.g;
    }

    public int F() {
        return this.f;
    }

    public int G() {
        return this.e;
    }

    public int H() {
        return this.d;
    }

    public c.o I() {
        return this.ay;
    }

    public c.w J() {
        return this.az;
    }

    public boolean K() {
        return this.u;
    }

    public boolean L() {
        return this.v;
    }

    public boolean M() {
        return this.w;
    }

    public boolean N() {
        return this.x;
    }

    public boolean O() {
        return this.S;
    }

    public Boolean P() {
        return this.T;
    }

    public boolean Q() {
        return this.U;
    }

    public boolean R() {
        return this.V;
    }

    public boolean S() {
        return this.m;
    }

    public String T() {
        return this.aI;
    }

    public String U() {
        return this.aH;
    }

    public String V() {
        return this.aJ;
    }

    public ShakeValue W() {
        return this.al;
    }

    public Map<String, Object> X() {
        return this.ae;
    }

    public void Y() {
        d dVar;
        if (this.G || (dVar = this.aF) == null) {
            return;
        }
        this.G = true;
        o.a(new l("CLOSE", dVar.c(), this.aF.e(), System.currentTimeMillis() - this.aF.i()));
    }

    public boolean Z() {
        c.w wVar = this.az;
        return (wVar == null || wVar.b() == null || this.az.b().a() != 1) ? false : true;
    }

    public LinkedList<String> aa() {
        return this.aP;
    }

    public g.a ab() {
        return this.c;
    }

    public int ac() {
        return this.O;
    }

    public void ad() {
        List<c.z> s;
        c.b bVar = this.ax;
        if (bVar == null || this.aT || (s = bVar.s()) == null) {
            return;
        }
        this.aU = System.currentTimeMillis();
        for (int i = 0; i < s.size(); i++) {
            a(s.get(i).a());
            this.aT = true;
        }
    }

    public void ae() {
        List<c.z> s;
        c.b bVar = this.ax;
        if (bVar == null || this.aW || !this.aT || (s = bVar.s()) == null) {
            return;
        }
        for (int i = 0; i < s.size(); i++) {
            a(s.get(i).b());
            this.aW = true;
        }
    }

    public void af() {
        List<c.z> s;
        c.b bVar = this.ax;
        if (bVar == null || this.aY || !this.aT || (s = bVar.s()) == null) {
            return;
        }
        this.aV = System.currentTimeMillis();
        for (int i = 0; i < s.size(); i++) {
            a(s.get(i).f());
            this.aY = true;
        }
    }

    public void ag() {
        List<c.z> s;
        c.b bVar = this.ax;
        if (bVar == null || this.aZ || !this.aT || (s = bVar.s()) == null) {
            return;
        }
        for (int i = 0; i < s.size(); i++) {
            a(s.get(i).g());
            this.aZ = true;
        }
    }

    public void ah() {
        d();
        al();
        if (this.am != null) {
            ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.network.ServerResponse.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ServerResponse.this.am != null) {
                            ServerResponse.this.am.destroy();
                            ServerResponse.this.am = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            ag();
        }
    }

    public AdLogoInfo ai() {
        return this.C;
    }

    public AdLogoInfo aj() {
        return this.D;
    }

    public String e() {
        return this.K;
    }

    public String f() {
        return this.W;
    }

    public String g() {
        return this.X;
    }

    public String h() {
        return this.aa;
    }

    public c.l i() {
        return this.ai;
    }

    public c.y j() {
        return this.aj;
    }

    public NativeAdResponse k() {
        return this.ag;
    }

    public p l() {
        return this.aE;
    }

    public List<Pair<j, String>> m() {
        return this.aG;
    }

    public int n() {
        return this.h;
    }

    public int o() {
        return this.i;
    }

    public int p() {
        return this.I;
    }

    public int q() {
        return this.J;
    }

    public String r() {
        return this.L;
    }

    public long s() {
        return this.aD;
    }

    public boolean t() {
        return this.aR;
    }

    public boolean u() {
        return this.aS;
    }

    public HashMap<String, Object> v() {
        return this.aQ;
    }

    public boolean w() {
        return this.k;
    }

    public boolean x() {
        return this.o;
    }

    public boolean y() {
        return this.p;
    }

    public boolean z() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) q.a().j().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("wordText", str));
                ak();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private boolean e(c.t tVar) {
        if (tVar.a() > 0) {
            c.v vVar = tVar.v().get(0);
            this.c = vVar.c();
            this.d = vVar.d();
            this.Z = vVar.e();
            this.e = vVar.f() == g.h.PORTRAIT ? 1 : 2;
            this.i = Integer.parseInt(vVar.h());
            this.h = Integer.parseInt(vVar.i());
            this.J = vVar.g();
            List<c.d> J = vVar.J();
            if (J != null && !J.isEmpty()) {
                this.I = J.get(0).j();
                this.L = J.get(0).k();
                this.aD = J.get(0).c();
            }
            this.K = vVar.a();
            this.k = vVar.x();
            this.l = vVar.y();
            this.m = vVar.z();
            this.O = vVar.A();
            this.n = vVar.B();
            this.ac = vVar.G();
            this.ad = vVar.H();
            this.o = vVar.C();
            this.p = vVar.v();
            this.q = vVar.E();
            this.r = vVar.w();
            this.s = vVar.m();
            this.t = vVar.n();
            this.u = vVar.o();
            this.v = vVar.p();
            this.w = vVar.q();
            this.x = vVar.r();
            this.y = vVar.t();
            this.z = vVar.s();
            this.A = vVar.D();
            this.ay = vVar.k();
            this.az = vVar.l();
            this.M = vVar.I();
            this.j = vVar.u();
            if (this.k && this.i == 0 && this.h == 0) {
                this.i = 720;
                this.h = 1280;
            }
            if (vVar.K() > 0) {
                for (c.d dVar : vVar.J()) {
                    if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                        this.aB = dVar.a();
                        if (dVar.e() >= 0) {
                            for (c.a aVar : dVar.g()) {
                                if (this.p) {
                                    for (int i = 0; i < aVar.d(); i++) {
                                        if (!StringUtil.isEmpty(aVar.c().get(i).a())) {
                                            this.aP.add(aVar.c().get(i).a());
                                        }
                                    }
                                }
                                if (aVar.a() == g.f.RENDER_JSON || aVar.a() == g.f.RENDER_VIDEO) {
                                    if (aVar.d() > 0) {
                                        try {
                                            c.C0422c f = dVar.f();
                                            if (f != null) {
                                                if (TextUtils.isEmpty(f.a())) {
                                                    this.C.setAdurl(f.b());
                                                    this.C.setType(AdLogoInfo.TYPE_TEXT);
                                                } else {
                                                    this.C.setAdurl(f.a());
                                                    this.C.setType(AdLogoInfo.TYPE_PIC);
                                                }
                                                if (TextUtils.isEmpty(f.c())) {
                                                    this.D.setAdurl(f.d());
                                                    this.D.setType(AdLogoInfo.TYPE_TEXT);
                                                } else {
                                                    this.D.setAdurl(f.c());
                                                    this.D.setType(AdLogoInfo.TYPE_PIC);
                                                }
                                            }
                                            com.octopus.ad.internal.nativead.c a2 = com.octopus.ad.internal.nativead.c.a(new JSONObject(aVar.b()));
                                            this.ag = a2;
                                            a2.a(this);
                                            this.ag.c(M());
                                            this.ag.a(q());
                                            this.ag.b(aj());
                                            this.ag.a(ai());
                                            this.ag.b(vVar.F());
                                            if (aVar.a() == g.f.RENDER_VIDEO) {
                                                this.ag.a(true);
                                            }
                                            if (dVar.d() != null) {
                                                a(dVar.d());
                                                c.b d = dVar.d();
                                                this.ag.b(!StringUtil.isEmpty(this.aH) ? this.aH : this.aK);
                                                this.ag.a(dVar.d());
                                                c.i k = d.k();
                                                if (k != null && !TextUtils.isEmpty(k.a())) {
                                                    this.ag.c(k.a());
                                                }
                                                if (k != null && !TextUtils.isEmpty(k.b())) {
                                                    this.ag.d(k.b());
                                                }
                                                List<c.i> t = d.t();
                                                if (t != null && !t.isEmpty()) {
                                                    for (int i2 = 0; i2 < t.size(); i2++) {
                                                        String b = t.get(i2).b();
                                                        if (!TextUtils.isEmpty(b)) {
                                                            this.ag.d(b);
                                                        }
                                                        String a3 = t.get(i2).a();
                                                        if (!TextUtils.isEmpty(a3)) {
                                                            this.ag.c(a3);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            f.a("OctopusAd", "An Exception Caught", e);
                                        }
                                        if (this.ag != null) {
                                            this.aR = true;
                                            return true;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.blank_ad));
        }
        if (this.aG.isEmpty()) {
            return false;
        }
        this.aR = true;
        return true;
    }

    private boolean f(c.t tVar) {
        if (tVar.a() > 0) {
            c.v vVar = tVar.v().get(0);
            List<c.d> J = vVar.J();
            if (J != null && !J.isEmpty()) {
                c.d dVar = J.get(0);
                if (dVar.d() != null) {
                    c.b d = dVar.d();
                    a(d);
                    c.i k = d.k();
                    if (k != null && !TextUtils.isEmpty(k.a())) {
                        this.f12492a = k.a();
                    }
                    if (k != null && !TextUtils.isEmpty(k.b())) {
                        this.b = k.b();
                    }
                }
            }
            this.c = vVar.c();
            this.d = vVar.d();
            this.Z = vVar.e();
            this.e = vVar.f() == g.h.PORTRAIT ? 1 : 2;
            this.h = Integer.parseInt(vVar.h());
            this.i = Integer.parseInt(vVar.i());
            this.J = vVar.g();
            List<c.d> J2 = vVar.J();
            if (J2 != null && !J2.isEmpty()) {
                this.I = J2.get(0).j();
                this.L = J2.get(0).k();
                this.aD = J2.get(0).c();
            }
            this.f = 0;
            this.g = 0;
            if (vVar.j() != null && ab() == g.a.ADP_INTERSTITIAL) {
                c.f j = vVar.j();
                this.f = Integer.parseInt(j.a());
                this.g = Integer.parseInt(j.b());
            }
        }
        return false;
    }

    public void c() {
        if (this.aF != null) {
            o.a(new l("FEEDBACK", e(), this.Y, System.currentTimeMillis() - this.aF.i()));
        }
    }

    public void d() {
        if (this.aF != null) {
            o.a(new l("DESTROY", e(), this.Y, System.currentTimeMillis() - this.aF.i()));
        }
    }

    private boolean c(c.t tVar) {
        if (tVar.a() > 0) {
            c.v vVar = tVar.v().get(0);
            this.c = vVar.c();
            this.d = vVar.d();
            this.Z = vVar.e();
            this.e = vVar.f() == g.h.PORTRAIT ? 1 : 2;
            this.i = Integer.parseInt(vVar.h());
            this.h = Integer.parseInt(vVar.i());
            if (vVar.j() != null && ab() == g.a.ADP_INTERSTITIAL) {
                c.f j = vVar.j();
                this.f = Integer.parseInt(j.a());
                this.g = Integer.parseInt(j.b());
            } else if (!StringUtil.isEmpty(vVar.b()) && ab() == g.a.ADP_REWARD) {
                a("REWARD_ITEM", (Object) vVar.b());
            }
            this.K = vVar.a();
            this.k = vVar.x();
            this.l = vVar.y();
            this.m = vVar.z();
            this.O = vVar.A();
            this.n = vVar.B();
            this.ac = vVar.G();
            this.ad = vVar.H();
            this.o = vVar.C();
            this.p = vVar.v();
            this.q = vVar.E();
            this.r = vVar.w();
            this.s = vVar.m();
            this.t = vVar.n();
            this.u = vVar.o();
            this.v = vVar.p();
            this.w = vVar.q();
            this.x = vVar.r();
            this.y = vVar.t();
            this.z = vVar.s();
            this.A = vVar.D();
            this.ay = vVar.k();
            this.az = vVar.l();
            this.M = vVar.I();
            this.J = vVar.g();
            this.j = vVar.u();
            List<c.d> J = vVar.J();
            if (J != null && !J.isEmpty()) {
                this.I = J.get(0).j();
                this.L = J.get(0).k();
                this.aD = J.get(0).c();
            }
            if (this.k && this.i == 0 && this.h == 0) {
                this.i = 720;
                this.h = 1280;
            }
            if (vVar.K() > 0) {
                int i = 0;
                for (c.d dVar : vVar.J()) {
                    if (i == 0) {
                        this.aC = dVar.b();
                        f.a("OctopusAd", "mAdid = " + this.aC);
                    }
                    if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                        this.aB = dVar.a();
                        c.C0422c f = dVar.f();
                        if (f != null) {
                            if (!TextUtils.isEmpty(f.a())) {
                                this.C.setAdurl(f.a());
                                this.C.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.C.setAdurl(f.b());
                                this.C.setType(AdLogoInfo.TYPE_TEXT);
                            }
                            if (!TextUtils.isEmpty(f.c())) {
                                this.D.setAdurl(f.c());
                                this.D.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.D.setAdurl(f.d());
                                this.D.setType(AdLogoInfo.TYPE_TEXT);
                            }
                        }
                        if (dVar.e() > 0) {
                            for (c.a aVar : dVar.g()) {
                                if (this.p) {
                                    for (int i2 = 0; i2 < aVar.d(); i2++) {
                                        if (!StringUtil.isEmpty(aVar.c().get(i2).a())) {
                                            this.aP.add(aVar.c().get(i2).a());
                                        }
                                    }
                                }
                                if (aVar.d() > 0) {
                                    String a2 = aVar.c().get(0).a();
                                    if (aVar.a() != g.f.RENDER_VIDEO && aVar.a() != g.f.RENDER_VAST_VIDEO) {
                                        this.aG.add(Pair.create(j.IMAGE, a2));
                                    } else {
                                        this.aG.add(Pair.create(j.VIDEO, a2));
                                    }
                                }
                            }
                        }
                        if (dVar.d() != null) {
                            c.b d = dVar.d();
                            a(d);
                            c.i k = d.k();
                            if (k != null && !TextUtils.isEmpty(k.a())) {
                                this.f12492a = k.a();
                            }
                            if (k != null && !TextUtils.isEmpty(k.b())) {
                                this.b = k.b();
                            }
                        }
                    }
                    i++;
                    if (!this.aG.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.blank_ad));
        }
        if (this.aG.isEmpty()) {
            return false;
        }
        this.aR = true;
        return true;
    }

    private boolean d(c.t tVar) {
        if (tVar.a() > 0) {
            for (c.v vVar : tVar.v()) {
                this.p = vVar.v();
                if (vVar.K() > 0) {
                    for (c.d dVar : vVar.J()) {
                        if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                            if (dVar.e() > 0) {
                                for (c.a aVar : dVar.g()) {
                                    if (this.p) {
                                        for (int i = 0; i < aVar.d(); i++) {
                                            if (!StringUtil.isEmpty(aVar.c().get(i).a())) {
                                                this.aP.add(aVar.c().get(i).a());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.aP.isEmpty()) {
            return false;
        }
        this.aR = true;
        return true;
    }

    public void a(boolean z) {
        this.E = z;
    }

    public c.b a() {
        return this.ax;
    }

    private void a(c.b bVar) {
        this.ax = bVar;
        this.aA = bVar.t();
        this.ap = bVar.p();
        this.an = bVar.r();
        this.aq = bVar.d();
        this.ar = bVar.e();
        this.as = bVar.f();
        this.at = bVar.g();
        this.au = bVar.h();
        this.av = bVar.i();
        this.aw = bVar.q();
        this.aH = bVar.a();
        this.aI = bVar.b();
        this.aJ = bVar.c();
        this.aL = bVar.m();
        this.aM = bVar.l();
        this.aN = bVar.n();
        this.aO = bVar.o();
        this.aK = bVar.j();
        if (TextUtils.isEmpty(this.as)) {
            this.as = "OctopusAd";
        }
        if (TextUtils.isEmpty(this.ar)) {
            this.ar = "OctopusAd";
        }
        if (TextUtils.isEmpty(this.at)) {
            this.at = "Ad Download";
        }
        if (!TextUtils.isEmpty(this.Z)) {
            if (!this.Z.startsWith("https://") && !this.Z.startsWith("http://")) {
                b(this.Z);
            } else {
                new t(this.Z).a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.network.ServerResponse.1
                    @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
                    public void getResponse(int i, boolean z, String str) {
                        if (!z || TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            ServerResponse.this.b(new JSONObject(str).optString(PointParamKey.DATA));
                        } catch (Exception e) {
                            f.a("OctopusAd", "An Exception Caught", e);
                        }
                    }
                }).execute();
            }
        }
        if (this.aO) {
            ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.network.ServerResponse.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(ServerResponse.this.aH)) {
                        return;
                    }
                    Context j = q.a().j();
                    ServerResponse.this.am = new WebView(new MutableContextWrapper(j));
                    WebviewUtil.setWebViewSettings(ServerResponse.this.am);
                    ServerResponse.this.am.loadUrl(ServerResponse.this.aH);
                }
            });
        }
    }

    public void b() {
        if (this.aF != null) {
            o.a(new l("SHOW", e(), this.Y, System.currentTimeMillis() - this.aF.h()));
        }
    }

    public void b(boolean z) {
        d dVar = this.aF;
        if (dVar != null) {
            o.a(new l("CLK", dVar.c(), this.aF.a(), System.currentTimeMillis() - this.aF.i(), z));
        }
    }

    private boolean b(c.t tVar) {
        if (tVar.b() == 0) {
            return true;
        }
        HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_error, tVar.c(), tVar.g()));
        return false;
    }

    public void d(boolean z) {
        this.P = z;
    }

    public void b(int i) {
        if (this.H) {
            return;
        }
        this.H = true;
        new com.octopus.ad.internal.i(UrlUtil.replaceWinUrl(q.a().m() + "/sdk/nurl?second_price=${SECOND_PRICE}&slot_id=${SLOT_ID}&adx_code=zysdk2", i, this.K)).execute();
    }

    @SuppressLint({"WrongConstant"})
    private void b(Context context) {
        try {
            if (TextUtils.isEmpty(this.aI)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.aI));
            intent.setFlags(268500993);
            context.startActivity(intent);
        } catch (Exception e) {
            c(context);
            a(-9, e.getMessage());
        }
    }

    public void a(com.octopus.ad.model.a aVar, boolean z) {
        d dVar = this.aF;
        if (dVar != null) {
            dVar.c(System.currentTimeMillis());
            if (aVar != null) {
                aVar.c(System.currentTimeMillis());
            }
            o.a(new l("IMP", this.aF.c(), this.aF.a(), System.currentTimeMillis() - this.aF.h(), z));
        }
    }

    private void a(c.t tVar) {
        this.W = tVar.h();
        this.X = tVar.i();
        this.ab = tVar.k();
        this.S = tVar.l();
        this.T = tVar.m();
        this.U = tVar.n();
        this.V = tVar.o();
        this.ah = tVar.p();
        this.ai = tVar.q();
        this.aj = tVar.r();
        this.aa = tVar.j();
        this.ak = tVar.s();
        this.ae = tVar.u();
        this.al = tVar.t();
        if (b(tVar)) {
            p pVar = this.aE;
            if (pVar == p.PREFETCH) {
                if (d(tVar)) {
                    return;
                }
            } else if (pVar != p.NATIVE && pVar != p.BANNER && pVar != p.DRAW) {
                if (c(tVar)) {
                    return;
                }
            } else if (e(tVar)) {
                return;
            }
            f(tVar);
        }
    }

    public ServerResponse(boolean z) {
        this.d = 0;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = false;
        this.B = 0;
        this.C = new AdLogoInfo();
        this.D = new AdLogoInfo();
        this.E = false;
        this.P = false;
        this.Q = false;
        this.R = true;
        this.S = true;
        this.aG = new LinkedList();
        this.aP = new LinkedList<>();
        this.aQ = new HashMap<>();
        this.aR = false;
        this.aX = 0;
        this.aS = z;
    }

    public void a(String str, Object obj) {
        this.aQ.put(str, obj);
    }

    public void a(final boolean z, final com.octopus.ad.a aVar) {
        List<c.i> t;
        this.R = z;
        int i = this.B;
        if (i <= 0) {
            this.B = i + 1;
            if (!StringUtil.isEmpty(this.f12492a)) {
                new com.octopus.ad.internal.i(this.f12492a).execute();
                this.f12492a = "";
            }
            c.b bVar = this.ax;
            if (bVar == null || (t = bVar.t()) == null) {
                return;
            }
            for (int i2 = 0; i2 < t.size(); i2++) {
                c.i iVar = t.get(i2);
                if (iVar != null && !TextUtils.isEmpty(iVar.a())) {
                    String a2 = iVar.a();
                    if (a2.contains("?rv=1")) {
                        ViewUtil.openLocalBrowser(a2, this.j);
                    } else {
                        if (a2.contains("track=oct")) {
                            if (this.P) {
                                a2 = a2.concat("&opt=10");
                            } else if (this.Q) {
                                a2 = a2.concat("&opt=1");
                            } else if (!z) {
                                a2 = a2.concat("&opt=4");
                            } else if (!this.S) {
                                a2 = a2.concat("&opt=11");
                            }
                        }
                        String str = a2;
                        long currentTimeMillis = System.currentTimeMillis();
                        d dVar = this.aF;
                        if (dVar != null) {
                            currentTimeMillis = dVar.h();
                        }
                        u uVar = new u("imp", this.K, this.Y, currentTimeMillis, str, this.aL);
                        if (str.contains("track=octimp")) {
                            uVar.a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.network.ServerResponse.3
                                @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
                                public void getResponse(int i3, boolean z2, String str2) {
                                    com.octopus.ad.a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        if (z2) {
                                            z2 = z;
                                        }
                                        aVar2.a(z2);
                                    }
                                }
                            });
                        }
                        uVar.a();
                    }
                }
            }
        }
    }

    public void c(boolean z) {
        this.Q = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        List<c.i> t;
        Context j;
        c.k kVar;
        try {
            c.b bVar = this.ax;
            if (bVar == null || (t = bVar.t()) == null) {
                return;
            }
            for (int i2 = 0; i2 < t.size(); i2++) {
                c.i iVar = t.get(i2);
                if (iVar != null && !TextUtils.isEmpty(iVar.c())) {
                    String c = iVar.c();
                    if (c.contains("track=oct")) {
                        if (this.P) {
                            c = c + "&opt=10";
                        } else if (this.Q) {
                            c = c + "&opt=1";
                        } else if (!this.R) {
                            c = c + "&opt=4";
                        } else if (this.S) {
                            Boolean bool = Boolean.TRUE;
                            Boolean bool2 = this.T;
                            if (bool != bool2) {
                                if (Boolean.FALSE == bool2) {
                                    c = c + "&opt=8";
                                } else if (this.N != 0) {
                                    c = c + "&opt=" + this.N;
                                } else if (this.U) {
                                    c = c + "&opt=12";
                                }
                            }
                        } else {
                            c = c + "&opt=11";
                        }
                        String str2 = c + "&result=" + i;
                        if (i == 0 && (j = q.a().j()) != null && (kVar = this.ah) != null && kVar.a() == 1) {
                            new com.octopus.ad.utils.a().a(j, this.ah.c(), this.ah.d(), this.ah.b());
                        }
                        a(str2, str);
                    } else {
                        new com.octopus.ad.internal.i(c).execute();
                    }
                }
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void c(Context context) {
        WebView webView;
        if (TextUtils.isEmpty(this.aH)) {
            return;
        }
        if (this.aM && this.E) {
            if (this.aH.startsWith(Constants.HTTP)) {
                am();
                if (this.aO && (webView = this.am) != null) {
                    ViewUtil.openLocalBrowser(webView, this.j);
                    return;
                } else {
                    ViewUtil.openLocalBrowser(this.aH, this.j);
                    return;
                }
            }
            return;
        }
        ViewUtil.openSystemBrowser(context, this.aH);
    }

    public void c(int i) {
        List<c.z> s;
        String str;
        c.b bVar = this.ax;
        if (bVar == null || this.aX == i || !this.aT || (s = bVar.s()) == null) {
            return;
        }
        for (int i2 = 0; i2 < s.size(); i2++) {
            c.z zVar = s.get(i2);
            if (i == 1) {
                str = zVar.c();
            } else if (i == 2) {
                str = zVar.d();
            } else if (i == 3) {
                str = zVar.e();
            } else {
                str = "";
            }
            a(str);
            this.aX = i;
        }
    }

    private void a(final String str, final String str2) {
        new Thread(new Runnable() { // from class: com.octopus.ad.internal.network.ServerResponse.4
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        bArr = new byte[0];
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", str2);
                        bArr = jSONObject.toString().getBytes();
                    }
                    com.octopus.ad.utils.b.d.a(str, bArr);
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        }).start();
    }

    public void a(int i) {
        d dVar;
        if (this.G || (dVar = this.aF) == null) {
            return;
        }
        this.G = true;
        o.a(new l("CHANGECONFIG", dVar.c(), this.aF.e(), i, System.currentTimeMillis() - this.aF.i()));
    }

    public void a(int i, String str, String str2) {
        if (this.H) {
            return;
        }
        this.H = true;
        new com.octopus.ad.internal.i(UrlUtil.replaceLossUrl(q.a().m() + "/sdk/lurl?win_price=${WIN_PRICE}&lose_reason=${LOSS_REASON}&win_bidder=${WIN_BIDDER}&slot_id=${SLOT_ID}&adx_code=zysdk2", i, str, str2, this.K)).execute();
    }

    public void a(View view, int i, boolean z, com.octopus.ad.model.d dVar) {
        Context context;
        if (view == null) {
            context = q.a().j();
        } else {
            context = view.getContext();
        }
        a(context, i, this.P, this.Q, z, dVar);
    }

    private void a(com.octopus.ad.model.d dVar) {
        if (this.ax == null || this.aA == null) {
            return;
        }
        for (int i = 0; i < this.aA.size(); i++) {
            c.i iVar = this.aA.get(i);
            if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
                String b = iVar.b();
                if (b.contains("?rv=1")) {
                    ViewUtil.openLocalBrowser(b, this.j);
                } else {
                    if (b.contains("track=oct")) {
                        if (this.P) {
                            b = b.concat("&opt=10");
                        } else if (this.Q) {
                            b = b.concat("&opt=1");
                        } else if (!this.R) {
                            b = b.concat("&opt=4");
                        } else if (!this.S) {
                            b = b.concat("&opt=11");
                        } else {
                            Boolean bool = Boolean.TRUE;
                            Boolean bool2 = this.T;
                            if (bool != bool2) {
                                if (Boolean.FALSE == bool2) {
                                    b = b.concat("&opt=8");
                                } else if (this.N != 0) {
                                    StringBuilder A5SV6n2 = AYUAbz.A5SV6n(b, "&opt=");
                                    A5SV6n2.append(this.N);
                                    b = A5SV6n2.toString();
                                } else if (this.U) {
                                    b = b.concat("&opt=12");
                                }
                            }
                        }
                    }
                    String replaceClickEventUrl = UrlUtil.replaceClickEventUrl(b, dVar, this.an);
                    long currentTimeMillis = System.currentTimeMillis();
                    d dVar2 = this.aF;
                    if (dVar2 != null) {
                        currentTimeMillis = dVar2.i();
                    }
                    new u("clk", this.K, this.Y, currentTimeMillis, replaceClickEventUrl, this.aL).a();
                }
            }
        }
        this.aA = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:46|47|(3:68|61|63)|56|57|58|59|60|61|63) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bb, code lost:
    
        r9.aJ = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00db, code lost:
    
        com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", r0);
     */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(final android.content.Context r10, int r11, boolean r12, boolean r13, boolean r14, com.octopus.ad.model.d r15) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.network.ServerResponse.a(android.content.Context, int, boolean, boolean, boolean, com.octopus.ad.model.d):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        int i;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String str2 = "";
                if (str.equals("1")) {
                    i = 1;
                } else if (str.equals("-1")) {
                    i = -1;
                } else if (str.startsWith("-2,")) {
                    str2 = str.substring(3);
                    i = -2;
                } else if (str.equals("-3")) {
                    i = -3;
                } else if (str.equals("-4")) {
                    if (this.aN) {
                        c(context);
                    }
                    i = -4;
                } else {
                    str2 = str;
                    i = -5;
                }
                if (i != 1 && i != -4 && i != -5) {
                    b(context);
                }
                a(i, str2);
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
    }

    private boolean a(Context context) {
        if (this.aw != null && com.octopus.ad.utils.b.i.b("com.tencent.mm.opensdk.openapi.IWXAPI")) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, this.aw.b());
            if (createWXAPI.isWXAppInstalled()) {
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = this.aw.c();
                req.path = this.aw.a();
                req.miniprogramType = 0;
                return createWXAPI.sendReq(req);
            }
        }
        return false;
    }

    public void a(com.octopus.ad.a.a aVar) {
        this.af = aVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new com.octopus.ad.internal.i(UrlUtil.replaceVideoTrackerUrl(str, this.ak, this.aU, this.aV)).execute();
    }
}
