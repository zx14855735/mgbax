package com.bytedance.sdk.component.adexpress.dynamic.w;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.pl;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.language.Soundex;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10182a;
    private List<String> ah;
    private double ai;
    private String am;
    private boolean aq;
    private int b;
    private JSONObject bl;
    private float c;
    private boolean ci;
    private String cu;
    private String cy;
    private float d;
    private int da;
    private String db;
    private int dc;
    private String dk;
    private boolean dq;
    private String e;
    private String en;
    private boolean et;
    private int eu;
    private boolean ew;
    private int ey;
    private float f;
    private String ff;
    private List<xj> ft;
    private String g;
    private int gh;
    private int gj;
    private int gy;
    private int h;
    private int he;
    private float hf;
    private int hl;
    private String ht;
    private int i;
    private String ic;

    /* renamed from: io, reason: collision with root package name */
    private int f10183io;
    private String ir;
    private String j;
    private String jk;
    private String jw;
    private int k;
    private int kc;
    private boolean kd;
    private String l;
    private boolean le;
    private JSONObject lm;
    private int lw;
    private String lx;
    private long m = -1;
    private int mg;
    private JSONObject my;
    private int n;
    private int nb;
    private int ne;
    private boolean no;
    private boolean nt;
    private boolean oa;
    private int ol;
    private int op;
    private double p;

    /* renamed from: pl, reason: collision with root package name */
    private double f10184pl;
    private String pz;
    private double q;
    private String qd;
    private String qf;
    private JSONObject qi;
    private String qt;
    private int r;
    private String ra;
    private int rg;
    private boolean s;
    private int se;
    private double si;
    private int ss;
    private int t;
    private float tf;
    private double tj;
    private boolean tu;
    private float u;
    private boolean ua;
    private int uf;
    private int ut;
    private String v;
    private int vi;
    private boolean vl;
    private boolean vm;
    private int vw;
    private float w;
    private boolean wa;
    private String wn;
    private int wo;
    private int ws;
    private int x;
    private float xj;
    private String xv;
    private float y;
    private String yo;
    private boolean yy;
    private String z;
    private boolean zb;
    private int zd;
    private String zg;
    private String zm;

    private void ai(String str) {
        this.ir = str;
    }

    public static y xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        y yVar = new y();
        yVar.hf(jSONObject.optString("adType", "embeded"));
        yVar.qt(jSONObject.optString("clickArea", "creative"));
        yVar.zg(jSONObject.optString("clickTigger", "click"));
        yVar.w(jSONObject.optString("fontFamily", "PingFangSC"));
        yVar.u(jSONObject.optString("textAlign", "left"));
        yVar.kd(jSONObject.optString("color", "#999999"));
        yVar.y(jSONObject.optString("bgColor", "transparent"));
        yVar.c(jSONObject.optString("bgImgUrl", ""));
        yVar.ai(jSONObject.optString("bgImgData", ""));
        yVar.f(jSONObject.optString("borderColor", "#000000"));
        yVar.d(jSONObject.optString("borderStyle", "solid"));
        yVar.tf(jSONObject.optString("heightMode", LiveConfigKey.AUTO));
        yVar.p(jSONObject.optString("widthMode", "fixed"));
        yVar.pl(jSONObject.optString("interactText", ""));
        yVar.w(jSONObject.optBoolean("isShowBgControl", false));
        yVar.g(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            yVar.c(optJSONObject.optInt("translateY", 0));
            yVar.f(optJSONObject.optInt("translateX", 0));
            yVar.u(optJSONObject.optDouble("scaleX", 0.0d));
            yVar.kd(optJSONObject.optDouble("scaleY", 0.0d));
        }
        yVar.am(jSONObject.optString("interactType", ""));
        yVar.kd(jSONObject.optInt("interactSlideDirection", -1));
        yVar.e(jSONObject.optString("justifyHorizontal", "space-around"));
        yVar.yo(jSONObject.optString("justifyVertical", "flex-start"));
        yVar.hf(jSONObject.optDouble("timingStart"));
        yVar.w(jSONObject.optDouble("timingEnd"));
        yVar.u((float) jSONObject.optDouble(MediaFormat.KEY_WIDTH, 0.0d));
        yVar.w((float) jSONObject.optDouble(MediaFormat.KEY_HEIGHT, 0.0d));
        yVar.xj((float) jSONObject.optDouble("borderRadius", 0.0d));
        yVar.hf((float) jSONObject.optDouble("borderSize", 0.0d));
        yVar.hf(jSONObject.optBoolean("interactValidate", false));
        yVar.d((float) jSONObject.optDouble("fontSize", 0.0d));
        yVar.kd((float) jSONObject.optDouble("paddingBottom", 0.0d));
        yVar.y((float) jSONObject.optDouble("paddingLeft", 0.0d));
        yVar.c((float) jSONObject.optDouble("paddingRight", 0.0d));
        yVar.f((float) jSONObject.optDouble("paddingTop", 0.0d));
        yVar.u(jSONObject.optBoolean("lineFeed", false));
        yVar.d(jSONObject.optInt("lineCount", 0));
        yVar.y(jSONObject.optDouble("lineHeight", 1.2d));
        yVar.am(jSONObject.optInt("letterSpacing", 0));
        yVar.kd(jSONObject.optBoolean("isDataFixed", false));
        yVar.qt(jSONObject.optInt("fontWeight"));
        yVar.y(jSONObject.optBoolean("lineLimit"));
        yVar.zg(jSONObject.optInt("position"));
        yVar.v(jSONObject.optString("align"));
        yVar.c(jSONObject.optBoolean("useLeft"));
        yVar.f(jSONObject.optBoolean("useRight"));
        yVar.d(jSONObject.optBoolean("useTop"));
        yVar.tf(jSONObject.optBoolean("useBottom"));
        yVar.jk(jSONObject.optString(PointParamKey.DATA));
        yVar.hf(jSONObject.optJSONObject("i18n"));
        yVar.pl(jSONObject.optInt("marginLeft"));
        yVar.g(jSONObject.optInt("marginRight"));
        yVar.tf(jSONObject.optInt("marginTop"));
        yVar.p(jSONObject.optInt("marginBottom"));
        yVar.e(jSONObject.optInt("tagMaxCount"));
        yVar.p(jSONObject.optBoolean("allowTextFlow"));
        yVar.yo(jSONObject.optInt("textFlowType"));
        yVar.v(jSONObject.optInt("textFlowDuration"));
        yVar.jk(jSONObject.optInt("left"));
        yVar.pz(jSONObject.optInt("right"));
        yVar.ht(jSONObject.optInt("top"));
        yVar.ra(jSONObject.optInt("bottom"));
        yVar.pz(jSONObject.optString("alignItems", "flex-start"));
        yVar.ht(jSONObject.optString("direction", ""));
        yVar.xj(jSONObject.optBoolean("loop", false));
        yVar.dk(jSONObject.optInt("zIndex"));
        yVar.q(jSONObject.optInt("interactVisibleTime"));
        yVar.et(jSONObject.optInt("interactHiddenTime"));
        yVar.g(jSONObject.optBoolean("interactEnableMask"));
        yVar.am(jSONObject.optBoolean("interactWontHide"));
        yVar.xj(jSONObject.optString("bgGradient"));
        yVar.j(jSONObject.optInt("areaType"));
        yVar.en(jSONObject.optInt("interactSlideThreshold", 0));
        yVar.a(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.u.xj() ? 0 : AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT));
        yVar.yo(jSONObject.optBoolean("openPlayableLandingPage", false));
        yVar.w(jSONObject.optJSONObject("video"));
        yVar.u(jSONObject.optJSONObject("image"));
        yVar.l(jSONObject.optInt("borderShadowExtent"));
        yVar.qt(jSONObject.optBoolean("bgGauseBlur"));
        yVar.ff(jSONObject.optInt("bgGauseBlurRadius"));
        yVar.zg(jSONObject.optBoolean("showTimeProgress", false));
        yVar.e(jSONObject.optBoolean("showPlayButton", false));
        yVar.xj(jSONObject.optDouble("bgColorCg", 0.0d));
        yVar.y(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        yVar.hf(jSONObject.optInt("borderTopLeftRadius", 0));
        yVar.xj(jSONObject.optInt("borderTopRightRadius", 0));
        yVar.u(jSONObject.optInt("borderBottomLeftRadius", 0));
        yVar.w(jSONObject.optInt("borderBottomRightRadius", 0));
        yVar.kd(jSONObject.optJSONObject("interactI18n"));
        yVar.dk(jSONObject.optString("imageObjectFit"));
        yVar.et(jSONObject.optString("interactTitle"));
        yVar.z(jSONObject.optInt("interactTextPositionTop"));
        yVar.ra(jSONObject.optString("imageLottieTosPath"));
        yVar.pl(jSONObject.optBoolean("animationsLoop"));
        yVar.io(jSONObject.optInt("lottieAppNameMaxLength"));
        yVar.ai(jSONObject.optInt("lottieAdDescMaxLength"));
        yVar.x(jSONObject.optInt("lottieAdTitleMaxLength"));
        yVar.x(jSONObject.optString("imageFlipSlideType"));
        yVar.v(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("filterColor");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                yVar.hf(arrayList);
            }
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("animations");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    xj xjVar = new xj();
                    xjVar.w(jSONObject2.optString("animationType"));
                    xjVar.xj(jSONObject2.optDouble("animationDuration"));
                    xjVar.hf(jSONObject2.optDouble("animationScaleX"));
                    xjVar.w(jSONObject2.optDouble("animationScaleY"));
                    xjVar.u(jSONObject2.optString("animationTimeFunction"));
                    xjVar.u(jSONObject2.optDouble("animationDelay"));
                    xjVar.y(jSONObject2.optInt("animationIterationCount"));
                    xjVar.kd(jSONObject2.optString("animationDirection"));
                    xjVar.kd(jSONObject2.optDouble("animationInterval"));
                    xjVar.xj(jSONObject2.optInt("animationBorderWidth"));
                    xjVar.xj(jSONObject2.optLong("key"));
                    xjVar.hf(jSONObject2.optInt("animationEffectWidth"));
                    xjVar.w(jSONObject2.optInt("animationSwing", 1));
                    xjVar.u(jSONObject2.optInt("animationTranslateX"));
                    xjVar.kd(jSONObject2.optInt("animationTranslateY"));
                    xjVar.hf(jSONObject2.optString("animationRippleBackgroundColor"));
                    xjVar.xj(jSONObject2.optString("animationScaleDirection"));
                    xjVar.c(jSONObject2.optInt("animationFadeStart"));
                    xjVar.f(jSONObject2.optInt("animationFadeEnd"));
                    xjVar.y(jSONObject2.optString("animationFillMode"));
                    xjVar.d(jSONObject2.optInt("animationBounceHeight"));
                    if (yVar.v() > 0.0d) {
                        xjVar.u(xjVar.am() + yVar.v());
                    }
                    arrayList2.add(xjVar);
                }
                yVar.xj(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                yVar.io(jSONObject.optString("triggerSlideDirection", Constants.FAIL));
                yVar.xj(jSONObject.optLong("triggerSlideMinDistance", 0L));
                return yVar;
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return yVar;
    }

    public double a() {
        return this.q;
    }

    public float am() {
        return this.y;
    }

    public int aq() {
        return this.n;
    }

    public String b() {
        return this.en;
    }

    public String bl() {
        return this.wn;
    }

    public int c() {
        return this.vi;
    }

    public JSONObject ci() {
        return this.lm;
    }

    public List<xj> cu() {
        return this.ft;
    }

    public int cy() {
        return this.gh;
    }

    public int d() {
        return this.kc;
    }

    public String da() {
        return this.ic;
    }

    public long db() {
        return this.m;
    }

    public int dc() {
        return this.eu;
    }

    public String dk() {
        return this.yo;
    }

    public boolean dq() {
        return this.vm;
    }

    public float e() {
        return this.d;
    }

    public int en() {
        return this.f10183io;
    }

    public String et() {
        return this.ir;
    }

    public String eu() {
        return this.ff;
    }

    public int ey() {
        return this.i;
    }

    public double f() {
        return this.si;
    }

    public double ff() {
        return this.ai;
    }

    public String ft() {
        return this.cy;
    }

    public boolean g() {
        return this.kd;
    }

    public boolean gh() {
        return this.s;
    }

    public boolean gj() {
        return this.wa;
    }

    public String gy() {
        return this.qd;
    }

    public int h() {
        return this.nb;
    }

    public boolean he() {
        return this.le;
    }

    public int hf() {
        return this.zd;
    }

    public int hl() {
        return this.b;
    }

    public String ht() {
        return this.zg;
    }

    public int i() {
        return this.ol;
    }

    public boolean ic() {
        return this.ua;
    }

    public String io() {
        return this.v;
    }

    public List<String> ir() {
        return this.ah;
    }

    public boolean j() {
        return this.et;
    }

    public double jk() {
        return this.f10184pl;
    }

    public String jw() {
        return this.db;
    }

    public int k() {
        return this.ne;
    }

    public int kc() {
        return this.t;
    }

    public int kd() {
        return this.he;
    }

    public int l() {
        return this.x;
    }

    public int le() {
        return this.vw;
    }

    public String lm() {
        return this.zm;
    }

    public boolean lw() {
        return this.aq;
    }

    public boolean lx() {
        return this.ew;
    }

    public String m() {
        return ("flip".equals(this.lx) || "slide".equals(this.lx)) ? this.lx : "slide";
    }

    public boolean mg() {
        return this.zb;
    }

    public boolean my() {
        return this.no;
    }

    public int n() {
        return this.wo;
    }

    public JSONObject nb() {
        return this.bl;
    }

    public int ne() {
        return this.ss;
    }

    public int no() {
        List<xj> list = this.ft;
        if (list == null) {
            return 0;
        }
        for (xj xjVar : list) {
            if ("translate".equals(xjVar.d()) && xjVar.c() < 0) {
                return -xjVar.c();
            }
        }
        return 0;
    }

    public String nt() {
        return this.cu;
    }

    public int oa() {
        return this.uf;
    }

    public void ol() {
        xj(this, this.lm);
    }

    public boolean op() {
        return this.dq;
    }

    public float p() {
        return this.xj;
    }

    public float pl() {
        return this.hf;
    }

    public String pz() {
        return this.qt;
    }

    public String q() {
        return this.ra;
    }

    public int qd() {
        return this.dc;
    }

    public int qi() {
        return this.rg;
    }

    public float qt() {
        return this.c;
    }

    public String r() {
        return this.j;
    }

    public String ra() {
        return this.e;
    }

    public String rg() {
        return this.xv;
    }

    public int s() {
        return this.hl;
    }

    public int se() {
        return this.gj;
    }

    public int si() {
        return this.se;
    }

    public int ss() {
        return this.lw;
    }

    public int t() {
        return this.h;
    }

    public String tf() {
        return this.qf;
    }

    public boolean tj() {
        return this.f10182a;
    }

    public boolean tu() {
        return this.yy;
    }

    public int u() {
        return this.ut;
    }

    public boolean ua() {
        return this.nt;
    }

    public void uf() {
        xj(this, this.my);
    }

    public int ut() {
        return this.da;
    }

    public double v() {
        return this.p;
    }

    public int vi() {
        return this.ey;
    }

    public int vl() {
        return this.gy;
    }

    public int vm() {
        return this.ws;
    }

    public String vw() {
        return this.jw;
    }

    public int w() {
        return this.mg;
    }

    public boolean wa() {
        return this.tu;
    }

    public double wn() {
        return this.tj;
    }

    public String wo() {
        return this.z;
    }

    public String ws() {
        return this.l;
    }

    public String x() {
        return this.pz;
    }

    public int xv() {
        return this.op;
    }

    public JSONObject y() {
        return this.qi;
    }

    public float yo() {
        return this.tf;
    }

    public int yy() {
        return this.r;
    }

    public String z() {
        return this.dk;
    }

    public boolean zb() {
        return this.ci;
    }

    public int zd() {
        return this.k;
    }

    public float zg() {
        return this.f;
    }

    public boolean zm() {
        return this.oa;
    }

    public void a(int i) {
        this.i = i;
    }

    public String ai() {
        return this.ht;
    }

    public void am(String str) {
        this.z = str;
    }

    public void c(float f) {
        this.f = f;
    }

    public void d(float f) {
        this.tf = f;
    }

    public void dk(int i) {
        this.h = i;
    }

    public void e(String str) {
        this.l = str;
    }

    public void en(int i) {
        this.t = i;
    }

    public void et(int i) {
        this.ne = i;
    }

    public void f(float f) {
        this.d = f;
    }

    public void ff(int i) {
        this.da = i;
    }

    public void g(String str) {
        this.dk = str;
    }

    public void hf(int i) {
        this.mg = i;
    }

    public void ht(int i) {
        this.ss = i;
    }

    public void io(int i) {
        this.vw = i;
    }

    public void j(int i) {
        this.rg = i;
    }

    public void jk(String str) {
        this.qd = str;
    }

    public void kd(int i) {
        this.vi = i;
    }

    public void l(int i) {
        this.k = i;
    }

    public void p(String str) {
        this.ht = str;
    }

    public void pl(String str) {
        this.ra = str;
    }

    public void pz(int i) {
        this.nb = i;
    }

    public void q(int i) {
        this.se = i;
    }

    public void qt(String str) {
        this.j = str;
    }

    public void ra(int i) {
        this.gj = i;
    }

    public void tf(String str) {
        this.pz = str;
    }

    public void u(int i) {
        this.he = i;
    }

    public void v(String str) {
        this.wn = str;
    }

    public void w(int i) {
        this.ut = i;
    }

    public void x(int i) {
        this.uf = i;
    }

    public void y(int i) {
        this.kc = i;
    }

    public void yo(String str) {
        this.ff = str;
    }

    public void z(int i) {
        this.ey = i;
    }

    public void zg(String str) {
        this.en = str;
    }

    public void ai(int i) {
        this.ol = i;
    }

    public void am(int i) {
        this.n = i;
    }

    public void c(String str) {
        this.yo = str;
    }

    public void d(String str) {
        this.jk = str;
    }

    public void dk(String str) {
        this.zm = str;
    }

    public void e(int i) {
        this.lw = i;
    }

    public void et(String str) {
        this.jw = str;
    }

    public void f(String str) {
        this.v = str;
    }

    public void g(int i) {
        this.eu = i;
    }

    public void hf(float f) {
        this.hf = f;
    }

    public void ht(String str) {
        this.xv = str;
    }

    public void io(String str) {
        this.db = str;
    }

    public void jk(int i) {
        this.gy = i;
    }

    public void kd(float f) {
        this.y = f;
    }

    public void p(int i) {
        this.b = i;
    }

    public void pl(int i) {
        this.ws = i;
    }

    public void pz(String str) {
        this.cy = str;
    }

    public void qt(int i) {
        this.hl = i;
    }

    public void ra(String str) {
        this.ic = str;
    }

    public void tf(int i) {
        this.r = i;
    }

    public void u(float f) {
        this.u = f;
    }

    public void v(int i) {
        this.op = i;
    }

    public void w(float f) {
        this.w = f;
    }

    public void x(String str) {
        this.lx = str;
    }

    public void y(float f) {
        this.c = f;
    }

    public void yo(int i) {
        this.gh = i;
    }

    public void zg(int i) {
        this.dc = i;
    }

    public void am(boolean z) {
        this.no = z;
    }

    public void c(int i) {
        this.f10183io = i;
    }

    public void d(int i) {
        this.wo = i;
    }

    public void e(boolean z) {
        this.oa = z;
    }

    public void f(int i) {
        this.x = i;
    }

    public void g(boolean z) {
        this.nt = z;
    }

    public void hf(boolean z) {
        this.kd = z;
    }

    public void kd(String str) {
        this.zg = str;
    }

    public void p(boolean z) {
        this.wa = z;
    }

    public void pl(boolean z) {
        this.ci = z;
    }

    public void qt(boolean z) {
        this.zb = z;
    }

    public void tf(boolean z) {
        this.dq = z;
    }

    public void u(String str) {
        this.qt = str;
    }

    public void v(boolean z) {
        this.ew = z;
    }

    public void w(double d) {
        this.f10184pl = d;
    }

    public void y(String str) {
        this.e = str;
    }

    public void yo(boolean z) {
        this.ua = z;
    }

    public void zg(boolean z) {
        this.le = z;
    }

    public void c(boolean z) {
        this.aq = z;
    }

    public void d(boolean z) {
        this.s = z;
    }

    public void f(boolean z) {
        this.tu = z;
    }

    public void hf(double d) {
        this.p = d;
    }

    public void kd(double d) {
        this.q = d;
    }

    public void u(double d) {
        this.ai = d;
    }

    public void w(String str) {
        this.am = str;
    }

    public void y(double d) {
        this.tj = d;
    }

    public void hf(String str) {
        this.g = str;
    }

    public void kd(boolean z) {
        this.yy = z;
    }

    public void u(boolean z) {
        this.f10182a = z;
    }

    public void w(boolean z) {
        this.et = z;
    }

    public void y(boolean z) {
        this.vm = z;
    }

    public void hf(JSONObject jSONObject) {
        this.bl = jSONObject;
    }

    public void kd(JSONObject jSONObject) {
        this.qi = jSONObject;
    }

    public void u(JSONObject jSONObject) {
        this.lm = jSONObject;
    }

    public void w(JSONObject jSONObject) {
        this.my = jSONObject;
    }

    public void hf(List<String> list) {
        this.ah = list;
    }

    public boolean xj() {
        return this.vl;
    }

    public void xj(boolean z) {
        this.vl = z;
    }

    public void xj(int i) {
        this.zd = i;
    }

    public void xj(double d) {
        this.si = d;
    }

    public void xj(String str) {
        this.qf = str;
    }

    public void xj(float f) {
        this.xj = f;
    }

    public void xj(List<xj> list) {
        this.ft = list;
    }

    public void xj(long j) {
        this.m = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void xj(y yVar, JSONObject jSONObject) {
        if (yVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            next.getClass();
            char c = 65535;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1221029593:
                    if (next.equals(MediaFormat.KEY_HEIGHT)) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        c = 18;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c = 19;
                        break;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        c = 20;
                        break;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        c = 21;
                        break;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        c = 22;
                        break;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        c = 23;
                        break;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        c = 24;
                        break;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        c = 25;
                        break;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        c = 26;
                        break;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        c = 27;
                        break;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        c = 28;
                        break;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        c = 29;
                        break;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        c = 30;
                        break;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        c = 31;
                        break;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        c = '!';
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals(PointParamKey.DATA)) {
                        c = '#';
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        c = '$';
                        break;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        c = '%';
                        break;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        c = '&';
                        break;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        c = '(';
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        c = ')';
                        break;
                    }
                    break;
                case 113126854:
                    if (next.equals(MediaFormat.KEY_WIDTH)) {
                        c = '*';
                        break;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        c = '+';
                        break;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        c = ',';
                        break;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        c = Soundex.SILENT_MARKER;
                        break;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        c = '.';
                        break;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        c = '/';
                        break;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        c = '0';
                        break;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        c = '1';
                        break;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        c = '2';
                        break;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        c = '3';
                        break;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        c = '4';
                        break;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        c = '5';
                        break;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        c = '6';
                        break;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        c = '7';
                        break;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        c = '8';
                        break;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        c = '9';
                        break;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        c = ':';
                        break;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        c = ';';
                        break;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        c = '<';
                        break;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        c = '=';
                        break;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        c = '>';
                        break;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        c = '?';
                        break;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        c = '@';
                        break;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        c = 'A';
                        break;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        c = 'B';
                        break;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        c = 'C';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    yVar.w(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    yVar.qt(jSONObject.optString(next));
                    break;
                case 2:
                    yVar.io(jSONObject.optString(next));
                    break;
                case 3:
                    yVar.c(jSONObject.optString(next));
                    break;
                case 4:
                    yVar.d(jSONObject.optInt(next));
                    break;
                case 5:
                    yVar.yo(jSONObject.optBoolean(next));
                    break;
                case 6:
                    yVar.y(jSONObject.optBoolean(next));
                    break;
                case 7:
                    yVar.g(jSONObject.optString(next));
                    break;
                case '\b':
                    yVar.y((float) jSONObject.optDouble(next));
                    break;
                case '\t':
                    yVar.hf(jSONObject.optString(next));
                    break;
                case '\n':
                    yVar.ra(jSONObject.optInt(next));
                    break;
                case 11:
                    yVar.w(jSONObject.optString(next));
                    break;
                case '\f':
                    yVar.w((float) jSONObject.optDouble(next));
                    break;
                case '\r':
                    yVar.u(jSONObject.optString(next));
                    break;
                case 14:
                    yVar.pz(jSONObject.optString(next));
                    break;
                case 15:
                    yVar.hf(jSONObject.optBoolean(next));
                    break;
                case 16:
                    yVar.tf(jSONObject.optInt(next));
                    break;
                case 17:
                    yVar.tf(jSONObject.optBoolean(next));
                    break;
                case 18:
                    yVar.xj(jSONObject.optLong(next));
                    break;
                case 19:
                    yVar.ht(jSONObject.optString(next));
                    break;
                case 20:
                    yVar.e(jSONObject.optInt(next));
                    break;
                case 21:
                    yVar.et(jSONObject.optInt(next));
                    break;
                case 22:
                    yVar.d(jSONObject.optBoolean(next));
                    break;
                case 23:
                    yVar.qt(jSONObject.optInt(next));
                    break;
                case 24:
                    yVar.dk(jSONObject.optInt(next));
                    break;
                case 25:
                    yVar.hf(jSONObject.optDouble(next));
                    break;
                case 26:
                    yVar.y(jSONObject.optDouble(next));
                    break;
                case 27:
                    yVar.v(jSONObject.optInt(next));
                    break;
                case 28:
                    yVar.f(jSONObject.optBoolean(next));
                    break;
                case 29:
                    yVar.p(jSONObject.optInt(next));
                    break;
                case 30:
                    yVar.y(jSONObject.optString(next));
                    break;
                case 31:
                    yVar.am(jSONObject.optBoolean(next));
                    break;
                case ' ':
                    yVar.c(jSONObject.optBoolean(next));
                    break;
                case '!':
                    yVar.p(jSONObject.optString(next));
                    break;
                case '\"':
                    yVar.ht(jSONObject.optInt(next));
                    break;
                case '#':
                    yVar.jk(jSONObject.optString(next));
                    break;
                case '$':
                    yVar.jk(jSONObject.optInt(next));
                    break;
                case '%':
                    yVar.xj(jSONObject.optBoolean(next));
                    break;
                case '&':
                    yVar.f((float) jSONObject.optDouble(next));
                    break;
                case '\'':
                    yVar.v(jSONObject.optString(next));
                    break;
                case '(':
                    yVar.kd(jSONObject.optString(next));
                    break;
                case ')':
                    yVar.pz(jSONObject.optInt(next));
                    break;
                case '*':
                    yVar.u((float) jSONObject.optDouble(next));
                    break;
                case '+':
                    yVar.w(jSONObject.optDouble(next));
                    break;
                case ',':
                    yVar.kd((float) jSONObject.optDouble(next));
                    break;
                case '-':
                    yVar.p(jSONObject.optBoolean(next));
                    break;
                case '.':
                    yVar.am(jSONObject.optBoolean(next));
                    break;
                case '/':
                    yVar.d((float) jSONObject.optDouble(next));
                    break;
                case '0':
                    yVar.yo(jSONObject.optString(next));
                    break;
                case '1':
                    yVar.q(jSONObject.optInt(next));
                    break;
                case '2':
                    yVar.c((float) jSONObject.optDouble(next));
                    break;
                case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                    yVar.f(jSONObject.optString(next));
                    break;
                case '4':
                    yVar.d(jSONObject.optString(next));
                    break;
                case '5':
                    yVar.zg(jSONObject.optInt(next));
                    break;
                case '6':
                    yVar.kd(jSONObject.optBoolean(next));
                    break;
                case '7':
                    yVar.g(jSONObject.optInt(next));
                    break;
                case '8':
                    yVar.e(jSONObject.optString(next));
                    break;
                case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject == null) {
                        break;
                    } else {
                        yVar.c(optJSONObject.optInt("translateY", 0));
                        yVar.f(optJSONObject.optInt("translateX", 0));
                        yVar.u(optJSONObject.optDouble("scaleX", 0.0d));
                        yVar.kd(optJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case ':':
                    yVar.u(jSONObject.optBoolean(next));
                    break;
                case ';':
                    yVar.pl(jSONObject.optString(next));
                    break;
                case '<':
                    yVar.am(jSONObject.optString(next));
                    break;
                case '=':
                    yVar.xj((float) jSONObject.optDouble(next));
                    break;
                case '>':
                    yVar.zg(jSONObject.optString(next));
                    break;
                case '?':
                    yVar.tf(jSONObject.optString(next));
                    break;
                case '@':
                    yVar.yo(jSONObject.optInt(next));
                    break;
                case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                    yVar.hf((float) jSONObject.optDouble(next));
                    break;
                case 'B':
                    yVar.pl(jSONObject.optInt(next));
                    break;
                case 'C':
                    yVar.am(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
