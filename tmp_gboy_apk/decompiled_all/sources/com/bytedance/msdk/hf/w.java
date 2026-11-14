package com.bytedance.msdk.hf;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.c.d;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.api.u.xj.c.kd;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.msdk.f.pz;
import com.bytedance.msdk.xj.hf.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.wo.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w extends u implements Comparable<w> {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f10144a;
    private boolean ai;
    private int am;
    private String aq;
    private double b;
    protected y c;
    private int cy;
    private String d;
    private int dc;
    private boolean dq;
    private String e;
    private String en;
    private int et;
    protected y f;
    private String ff;
    private int ft;
    private int g;
    private int gj;
    private String h;
    protected f hf;
    private String hl;
    private double ht;
    private boolean i;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10145io;
    private long j;
    private int k;
    private String kc;
    protected d kd;
    private String l;
    private String le;
    private String lm;
    private long my;
    private int ne;
    private String no;
    private String oa;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10146pl;
    private String pz;
    private String q;
    private int qd;
    private String qi;
    private int qt;
    private double r;
    private int ra;
    private String rg;
    private String s;
    private int se;
    private volatile boolean si;
    private int ss;
    private String t;
    private String tf;
    private String tu;
    protected com.bytedance.msdk.api.u.xj.u u;
    private volatile boolean ua;
    private com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj ut;
    private double v;
    private String vi;
    private boolean vl;
    private int vm;
    protected com.bytedance.msdk.api.u.xj.hf w;
    private String wn;
    private Map<String, Object> wo;
    private int ws;
    private String x;
    protected com.bytedance.msdk.api.u.xj.c.hf xj;
    private String xv;
    protected com.bytedance.msdk.api.u.xj.w.xj y;
    private String yo;
    private String z;
    private String zb;
    private xj zd;
    private int zg;
    private List<String> jk = new ArrayList();
    private int dk = -1;
    private int eu = 1;
    private int tj = 1;
    private int n = 1;
    private int yy = 1;
    private volatile boolean bl = false;
    private volatile boolean lw = false;
    private volatile boolean wa = false;
    private volatile boolean gh = false;
    private final Map<String, Object> op = new pz();
    private boolean gy = false;
    private boolean nb = false;
    private String da = "1";
    private Map<String, Object> cu = new HashMap();
    private Map<String, Object> mg = new ConcurrentHashMap();

    public interface xj {
        void xj();

        void xj(w wVar);
    }

    public void a(String str) {
    }

    public int ah() {
        return this.zg;
    }

    public boolean ai() {
        return this.gy;
    }

    public void am(String str) {
        this.lm = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public String aq() {
        return this.lm;
    }

    public String b() {
        return this.wn;
    }

    public double bh() {
        return 0.0d;
    }

    public String bl() {
        return this.da;
    }

    public String c() {
        return null;
    }

    public int ci() {
        return this.et;
    }

    public boolean cu() {
        return this.ft == 0;
    }

    public String cy() {
        return this.t;
    }

    public View d() {
        return null;
    }

    public double da() {
        try {
        } catch (NumberFormatException e) {
            pl.xj(e);
        }
        if (si()) {
            if (le() < 0.0d) {
                return 0.0d;
            }
            return le();
        }
        if (lm() || vi()) {
            return this.ht * Double.valueOf(this.da).doubleValue();
        }
        return this.ht;
    }

    public long db() {
        return 0L;
    }

    public final Map<String, Object> dc() {
        return this.cu;
    }

    public int dk() {
        return this.cy;
    }

    public final long dq() {
        return this.my;
    }

    public void e() {
    }

    public boolean en() {
        if (this.wa) {
            return true;
        }
        this.wa = true;
        return false;
    }

    public int et() {
        return this.gj;
    }

    public boolean eu() {
        return false;
    }

    public boolean ew() {
        return false;
    }

    public int ey() {
        return this.am;
    }

    public kd f() {
        return null;
    }

    public int ff() {
        return this.qd;
    }

    public String ft() {
        return this.l;
    }

    public void g(String str) {
        this.vi = str;
    }

    public String gh() {
        return TextUtils.isEmpty(this.le) ? this.oa : this.le;
    }

    public int gj() {
        return this.k;
    }

    public boolean gy() {
        return this.f10145io;
    }

    public String h() {
        return this.z;
    }

    public String he() {
        return this.f10146pl;
    }

    public c hf(Dialog dialog, Integer[] numArr) {
        return null;
    }

    public String hl() {
        return this.kc;
    }

    public Bitmap ho() {
        return null;
    }

    public boolean ht() {
        return this.vl;
    }

    public String i() {
        return si() ? le() < 0.0d ? "-1" : String.valueOf(le()) : String.valueOf(da());
    }

    public int ic() {
        return this.ws;
    }

    public int io() {
        return this.ss;
    }

    public String ir() {
        return null;
    }

    public boolean j() {
        if (this.lw) {
            return true;
        }
        this.lw = true;
        return false;
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.kd jf() {
        return null;
    }

    public boolean jk() {
        return false;
    }

    public String jw() {
        return this.pz;
    }

    public Map<String, Object> k() {
        return this.wo;
    }

    public int kc() {
        return this.ne;
    }

    public void kd(String str) {
        this.wn = str;
    }

    public abstract boolean kd();

    public y kr() {
        return this.c;
    }

    public boolean l() {
        if (this.gh) {
            return true;
        }
        this.gh = true;
        return false;
    }

    public double le() {
        return this.r;
    }

    public boolean lm() {
        return this.ft == 1;
    }

    public String lw() {
        return this.le;
    }

    public int lx() {
        return this.qt;
    }

    public long m() {
        return 0L;
    }

    public List<String> mg() {
        return this.jk;
    }

    public boolean my() {
        int i = this.ft;
        return i == 0 || i == 100;
    }

    public int n() {
        return this.vm;
    }

    public int nb() {
        return this.dk;
    }

    public long ne() {
        return this.j;
    }

    public boolean no() {
        return this.ft == 100;
    }

    public String nt() {
        return this.e;
    }

    public double oa() {
        return this.b;
    }

    public double ol() {
        return this.v;
    }

    public String op() {
        return this.zb;
    }

    public void p() {
    }

    public void pl(String str) {
        this.no = str;
    }

    public String pz() {
        return this.h;
    }

    public Map<String, Object> q() {
        return this.op;
    }

    public Map<String, Object> qd() {
        return this.mg;
    }

    public boolean qf() {
        return this.i;
    }

    public int qi() {
        return this.ft;
    }

    public void qt(String str) {
        this.da = str;
    }

    public String r() {
        return this.s;
    }

    public void ra(int i) {
    }

    public String rg() {
        return this.ff;
    }

    public boolean s() {
        return this.si;
    }

    public String se() {
        return this.en;
    }

    public boolean si() {
        return this.ft == 2;
    }

    public int ss() {
        return this.ra;
    }

    public boolean sv() {
        return (this instanceof com.bytedance.msdk.api.u.xj.hf.hf) || (this instanceof com.bytedance.msdk.w.xj.xj.w);
    }

    public Map<String, String> t() {
        return this.f10144a;
    }

    public View tf() {
        return null;
    }

    public int tj() {
        return this.dc;
    }

    public boolean tu() {
        return this.ua;
    }

    public int u() {
        return -1;
    }

    public String ua() {
        return si() ? oa() < 0.0d ? "-1" : String.valueOf(oa()) : String.valueOf(da());
    }

    public String uf() {
        return this.tf;
    }

    public xj uh() {
        return this.zd;
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
        return null;
    }

    public String ut() {
        return this.p;
    }

    public void v(String str) {
        this.rg = str;
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.pl vh() {
        return null;
    }

    public boolean vi() {
        return this.ft == 3;
    }

    public String vl() {
        return this.q;
    }

    public String vm() {
        return this.no;
    }

    public String vw() {
        return this.d;
    }

    public void w() {
    }

    public String wa() {
        return this.oa;
    }

    public String wn() {
        return this.vi;
    }

    public String wo() {
        return this.tu;
    }

    public String ws() {
        return this.aq;
    }

    public void wx() {
    }

    public boolean x() {
        return this.nb;
    }

    public c xj(Activity activity) {
        return null;
    }

    public boolean xv() {
        if (!TextUtils.isEmpty(this.q) || !TextUtils.isEmpty(this.z) || this.j > 0 || !TextUtils.isEmpty(this.en)) {
            return true;
        }
        Map<String, String> map = this.f10144a;
        return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.ff) && TextUtils.isEmpty(this.no)) ? false : true;
    }

    public void y(String str) {
        this.aq = str;
    }

    public void yo(String str) {
        this.zb = str;
    }

    public int yt() {
        return 0;
    }

    public String yy() {
        return this.qi;
    }

    public boolean z() {
        if (this.bl) {
            return true;
        }
        this.bl = true;
        return false;
    }

    public double zb() {
        if (!si()) {
            return this.ht;
        }
        if (le() < 0.0d) {
            return 0.0d;
        }
        return le();
    }

    public int zd() {
        return this.se;
    }

    public void zg() {
    }

    public int zm() {
        return this.g;
    }

    public boolean a() {
        return this.dq;
    }

    public void ai(String str) {
        this.f10146pl = str;
    }

    public void am(int i) {
        this.et = i;
    }

    public void c(String str) {
        this.hl = str;
    }

    public void d(int i) {
        this.eu = i;
    }

    public void dk(String str) {
        this.en = str;
    }

    public void e(String str) {
        this.oa = str;
    }

    public void et(String str) {
        this.l = str;
    }

    public void f(int i) {
        this.yy = i;
    }

    public final boolean ff(String str) {
        Integer y = y();
        return y.intValue() == 1 ? !com.bytedance.msdk.core.kd.xj.xj.xj().xj(str, this) : y.intValue() == 2;
    }

    public void g(int i) {
        this.k = i;
    }

    public void hf() {
    }

    public void ht(String str) {
        this.q = str;
    }

    public void io(String str) {
        this.ff = str;
    }

    public void jk(String str) {
        this.t = str;
    }

    public void kd(int i) {
        this.dc = i;
    }

    public void p(String str) {
        this.kc = str;
    }

    public void pl(int i) {
        this.dk = i;
    }

    public void pz(String str) {
        this.x = str;
    }

    public void q(String str) {
        this.e = str;
    }

    public void qt(int i) {
        this.ft = i;
    }

    public String ra() {
        return this.xv;
    }

    public void tf(boolean z) {
    }

    public void u(int i) {
        this.qd = i;
    }

    public void v(int i) {
        this.am = i;
    }

    public void w(int i) {
        this.ss = i;
    }

    public void x(String str) {
        this.p = str;
    }

    public void xj() {
    }

    public void y(int i) {
        this.vm = i;
    }

    public void yo(int i) {
        this.g = i;
    }

    public void zg(String str) {
        this.le = str;
    }

    public com.bytedance.msdk.api.u.xj.hf am() {
        return this.w;
    }

    public void c(int i) {
        this.n = i;
    }

    public int d(String str) {
        if (TextUtils.equals(str, this.hl)) {
            return this.yy;
        }
        return this.tj;
    }

    public void e(int i) {
        this.se = i;
    }

    public void en(String str) {
        this.tf = str;
    }

    public int f(String str) {
        if (TextUtils.equals(str, this.hl)) {
            return this.n;
        }
        return this.eu;
    }

    public f g() {
        return this.hf;
    }

    public void hf(Activity activity) {
    }

    public void ht(int i) {
        this.zg = i;
    }

    public void j(String str) {
        this.d = str;
    }

    public void jk(int i) {
        this.ws = i;
    }

    public void kd(boolean z) {
        this.ua = z;
    }

    public void l(String str) {
        this.pz = str;
    }

    public void p(int i) {
        this.ra = i;
    }

    public com.bytedance.msdk.api.u.xj.c.hf pl() {
        return this.xj;
    }

    public void pz(int i) {
        this.qt = i;
    }

    public com.bytedance.msdk.api.u.xj.w.xj qt() {
        return this.y;
    }

    public void ra(String str) {
        this.z = str;
    }

    public void tf(int i) {
        this.tj = i;
    }

    public void u(boolean z) {
        this.dq = z;
    }

    public com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj v() {
        return this.ut;
    }

    public void w(boolean z) {
        this.gy = z;
    }

    public void xj(Activity activity, Object obj, String str) {
    }

    public void y(boolean z) {
        this.si = z;
    }

    public void yo() {
        this.xj = null;
        this.hf = null;
        this.w = null;
    }

    public void z(String str) {
        this.yo = str;
    }

    public void zg(int i) {
        this.ne = i;
    }

    public void c(boolean z) {
        this.f10145io = z;
    }

    public void hf(Map<String, Object> map) {
    }

    public void kd(Map<String, String> map) {
        this.f10144a = map;
    }

    public void tf(String str) {
        this.qi = str;
    }

    public void u(String str) {
        this.s = str;
    }

    public void w(Map<String, Object> map) {
        if (map != null) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "setMediaExtraInfo ".concat(String.valueOf(map)));
            this.op.putAll(map);
        }
    }

    public void xj(Dialog dialog, Integer[] numArr) {
    }

    public Integer y() {
        return 1;
    }

    public void hf(String str) {
        this.xv = str;
    }

    public void u(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.cu.putAll(map);
    }

    public void xj(Bitmap bitmap, int i) {
    }

    public void d(boolean z) {
        this.i = z;
    }

    public void f(boolean z) {
        this.ai = z;
    }

    public void hf(int i) {
        this.gj = i;
    }

    public void w(String str) {
        this.tu = str;
    }

    public void xj(ViewGroup viewGroup) {
    }

    public void hf(boolean z) {
        this.nb = z;
    }

    public void u(double d) {
        this.v = d;
    }

    public void w(double d) {
        this.b = d;
    }

    public void xj(ViewGroup viewGroup, Activity activity) {
    }

    public void hf(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.mg.put(str, obj);
    }

    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
    }

    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
    }

    public void hf(long j) {
        this.j = j;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
    }

    public void hf(double d) {
        this.r = d;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
    }

    public void hf(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public void xj(Object obj) {
    }

    public void xj(Map<String, Object> map) {
    }

    public void xj(String str) {
        this.h = str;
    }

    public void xj(boolean z) {
        this.vl = z;
    }

    private void hf(ViewGroup viewGroup) {
        try {
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            int i = 0;
            if (gj() != 3 && (viewGroup.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                if (MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG.equals(viewGroup2.getTag(2131298151))) {
                    viewGroup.removeView(viewGroup2);
                    int i2 = 0;
                    while (i2 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i2);
                        if (childAt != null) {
                            Object tag = childAt.getTag(2131298152);
                            if ((tag instanceof String) && tag.equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG)) {
                                viewGroup2.removeView(childAt);
                                viewGroup.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i2++;
                    }
                }
            }
            if (gj() == 2 || !(viewGroup.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.getChildAt(0);
            if (MediationConstant.TT_ADMOB_NATIVE_VIEW_ROOT_TAG.equals(viewGroup3.getTag(2131298148))) {
                viewGroup.removeView(viewGroup3);
                while (i < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(2131298149);
                        if ((tag2 instanceof String) && tag2.equals(MediationConstant.TT_ADMOB_NATIVE_VIEW_TAG)) {
                            viewGroup3.removeView(childAt2);
                            viewGroup.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void xj(int i) {
        this.cy = i;
    }

    public void xj(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.cu.put(str, obj);
    }

    public final void xj(long j) {
        if (this.my == 0) {
            this.my = j;
        }
    }

    public void xj(double d) {
        this.ht = d;
    }

    public void xj(List<String> list) {
        if (list != null) {
            this.jk.addAll(list);
        }
    }

    private void xj(ViewGroup viewGroup, tf tfVar) {
        hf(viewGroup);
        View findViewById = viewGroup.findViewById(2131298153);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (tfVar != null) {
            xj(viewGroup.findViewById(tfVar.f10113pl));
        }
    }

    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
        xj(viewGroup, (tf) null);
    }

    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar, List<View> list4) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        xj(viewGroup, tfVar);
    }

    public void xj(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        if (wVar == null || this.se > wVar.zd()) {
            return 1;
        }
        if (this.se < wVar.zd()) {
            return -1;
        }
        if (this.ne > wVar.kc()) {
            return 1;
        }
        return this.ne < wVar.kc() ? -1 : 0;
    }

    public void hf(y yVar) {
        this.f = yVar;
    }

    public void xj(d dVar) {
        this.kd = dVar;
    }

    public void xj(com.bytedance.msdk.api.u.xj.u uVar) {
        this.u = uVar;
    }

    public void xj(com.bytedance.msdk.api.u.xj.c.hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(f fVar) {
        this.hf = fVar;
    }

    public void xj(final com.bytedance.msdk.api.u.xj.hf hfVar) {
        if (hfVar != null) {
            this.w = new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.msdk.hf.w.1
                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf() {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.hf();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj() {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.xj();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.hf(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(final long j, final long j2, final int i, final int i2, final String str, final String str2) {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.xj(j, j2, i, i2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.xj(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(final long j, final String str, final String str2) {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.xj(j, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(final String str, final String str2) {
                    com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.hf.w.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            hfVar.xj(str, str2);
                        }
                    });
                }
            };
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.w.xj xjVar) {
        this.y = xjVar;
    }

    public void xj(y yVar) {
        this.c = yVar;
    }

    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.ut = xjVar;
    }

    public void xj(xj xjVar) {
        this.zd = xjVar;
    }
}
