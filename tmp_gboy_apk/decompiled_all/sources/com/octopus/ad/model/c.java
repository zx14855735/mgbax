package com.octopus.ad.model;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.octopus.ad.internal.utilities.JsonUtil;
import com.octopus.ad.internal.utilities.SPUtils;
import com.octopus.ad.model.e;
import com.octopus.ad.model.g;
import com.qq.e.comm.constants.Constants;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private g.f f12611a;
        private String b;
        private String c;
        private List<e> d;

        public g.f a() {
            return this.f12611a;
        }

        public String b() {
            return this.b;
        }

        public List<e> c() {
            return this.d;
        }

        public int d() {
            List<e> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(g.f fVar) {
            this.f12611a = fVar;
        }

        public void b(String str) {
            this.c = str;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(List<e> list) {
            this.d = list;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f12612a;
        private String b;
        private String c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private com.octopus.ad.model.e j;
        private ComplianceInfo k;
        private com.octopus.ad.model.i l;
        private String m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r;
        private i s;
        private a t;
        private C0421b u;
        private List<z> v;
        private List<i> w;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private List<String> f12613a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<String> f;
            private List<String> g;
            private List<String> h;
            private List<String> i;
            private List<String> j;
            private List<String> k;
            private List<String> l;
            private List<String> m;
            private List<String> n;
            private List<String> o;

            public void a(List<String> list) {
                this.f12613a = list;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<String> list) {
                this.f = list;
            }

            public void g(List<String> list) {
                this.g = list;
            }

            public void h(List<String> list) {
                this.h = list;
            }

            public void i(List<String> list) {
                this.i = list;
            }

            public void j(List<String> list) {
                this.j = list;
            }

            public void k(List<String> list) {
                this.k = list;
            }

            public void l(List<String> list) {
                this.l = list;
            }

            public void m(List<String> list) {
                this.m = list;
            }

            public void n(List<String> list) {
                this.n = list;
            }

            public void o(List<String> list) {
                this.o = list;
            }

            public List<String> a() {
                return this.b;
            }

            public List<String> b() {
                return this.c;
            }

            public List<String> c() {
                return this.d;
            }

            public List<String> d() {
                return this.e;
            }
        }

        /* renamed from: com.octopus.ad.model.c$b$b, reason: collision with other inner class name */
        public static class C0421b {

            /* renamed from: a, reason: collision with root package name */
            private List<String> f12614a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<a> f;

            /* renamed from: com.octopus.ad.model.c$b$b$a */
            public static class a {

                /* renamed from: a, reason: collision with root package name */
                private int f12615a;
                private List<String> b;

                public void a(int i) {
                    this.f12615a = i;
                }

                public void a(List<String> list) {
                    this.b = list;
                }
            }

            public void a(List<String> list) {
                this.f12614a = list;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<a> list) {
                this.f = list;
            }
        }

        public String a() {
            return this.f12612a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.h;
        }

        public String h() {
            return this.i;
        }

        public ComplianceInfo i() {
            return this.k;
        }

        public String j() {
            return this.m;
        }

        public i k() {
            return this.s;
        }

        public boolean l() {
            return this.o;
        }

        public boolean m() {
            return this.n;
        }

        public boolean n() {
            return this.p;
        }

        public boolean o() {
            return this.q;
        }

        public a p() {
            return this.t;
        }

        public com.octopus.ad.model.i q() {
            return this.l;
        }

        public com.octopus.ad.model.e r() {
            return this.j;
        }

        public List<z> s() {
            return this.v;
        }

        public List<i> t() {
            return this.w;
        }

        public void a(String str) {
            this.f12612a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.e = str;
        }

        public void e(String str) {
            this.f = str;
        }

        public void f(String str) {
            this.g = str;
        }

        public void g(String str) {
            this.h = str;
        }

        public void h(String str) {
            this.i = str;
        }

        public void a(int i) {
            this.d = i;
        }

        public void b(boolean z) {
            this.n = z;
        }

        public void c(boolean z) {
            this.p = z;
        }

        public void d(boolean z) {
            this.q = z;
        }

        public void a(ComplianceInfo complianceInfo) {
            this.k = complianceInfo;
        }

        public void b(int i) {
            this.r = i;
        }

        public void a(boolean z) {
            this.o = z;
        }

        public void b(List<i> list) {
            this.w = list;
        }

        public void a(a aVar) {
            this.t = aVar;
        }

        public void a(C0421b c0421b) {
            this.u = c0421b;
        }

        public void a(com.octopus.ad.model.i iVar) {
            this.l = iVar;
        }

        public void a(com.octopus.ad.model.e eVar) {
            this.j = eVar;
        }

        public void a(List<z> list) {
            this.v = list;
        }
    }

    /* renamed from: com.octopus.ad.model.c$c, reason: collision with other inner class name */
    public static class C0422c {

        /* renamed from: a, reason: collision with root package name */
        private String f12616a;
        private String b;
        private String c;
        private String d;

        public String a() {
            return this.f12616a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.f12616a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f12617a;
        private b b;
        private C0422c c;
        private List<a> d;
        private List<Object> e;
        private int f;
        private String g;
        private String h;
        private long i;

        public String a() {
            return this.f12617a;
        }

        public String b() {
            return this.h;
        }

        public long c() {
            return this.i;
        }

        public b d() {
            return this.b;
        }

        public int e() {
            List<a> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public C0422c f() {
            return this.c;
        }

        public List<a> g() {
            return this.d;
        }

        public List<Object> h() {
            return this.e;
        }

        public int i() {
            List<Object> list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int j() {
            return this.f;
        }

        public String k() {
            return this.g;
        }

        public void a(String str) {
            this.f12617a = str;
        }

        public void b(String str) {
            this.h = str;
        }

        public void c(String str) {
            this.g = str;
        }

        public void a(long j) {
            this.i = j;
        }

        public void a(b bVar) {
            this.b = bVar;
        }

        public void a(C0422c c0422c) {
            this.c = c0422c;
        }

        public void a(List<a> list) {
            this.d = list;
        }

        public void a(int i) {
            this.f = i;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private String f12618a;
        private String b;
        private String c;

        public void a(String str) {
            this.f12618a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public String a() {
            return this.c;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f12619a;
        private String b;

        public String a() {
            return this.f12619a;
        }

        public String b() {
            return this.b;
        }

        public void a(String str) {
            this.f12619a = str;
        }

        public void b(String str) {
            this.b = str;
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private int f12620a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.f12620a;
        }

        public int b() {
            return this.b;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }

        public void a(int i) {
            this.f12620a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.d;
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private int f12621a;
        private int b;

        public void a(int i) {
            this.f12621a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private String f12622a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public String a() {
            return this.f12622a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public void e(String str) {
            this.e = str;
        }

        public void f(String str) {
            this.f = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void h(String str) {
            this.h = str;
        }

        public void i(String str) {
            this.i = str;
        }

        public void a(String str) {
            this.f12622a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private int f12623a;

        public int a() {
            return this.f12623a;
        }

        public void a(int i) {
            this.f12623a = i;
        }
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f12624a;
        private int b;
        private double c;
        private double d;

        public int a() {
            return this.f12624a;
        }

        public int b() {
            return this.b;
        }

        public double c() {
            return this.c;
        }

        public double d() {
            return this.d;
        }

        public void a(int i) {
            this.f12624a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void a(double d) {
            this.c = d;
        }

        public void b(double d) {
            this.d = d;
        }
    }

    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private int f12625a;
        private int b;
        private String c;
        private String d;

        public int a() {
            return this.f12625a;
        }

        public int b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public void a(int i) {
            this.f12625a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.d = str;
        }
    }

    public static class m {

        /* renamed from: a, reason: collision with root package name */
        private int f12626a;
        private int b;

        public void a(int i) {
            this.f12626a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public int a() {
            return this.b;
        }
    }

    public static class n {

        /* renamed from: a, reason: collision with root package name */
        private int f12627a;
        private int b;

        public void a(int i) {
            this.f12627a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    public static class o {

        /* renamed from: a, reason: collision with root package name */
        private m f12628a;
        private r b;
        private u c;
        private s d;

        public m a() {
            return this.f12628a;
        }

        public r b() {
            return this.b;
        }

        public u c() {
            return this.c;
        }

        public s d() {
            return this.d;
        }

        public void a(m mVar) {
            this.f12628a = mVar;
        }

        public void a(r rVar) {
            this.b = rVar;
        }

        public void a(u uVar) {
            this.c = uVar;
        }

        public void a(s sVar) {
            this.d = sVar;
        }
    }

    public static class p {

        /* renamed from: a, reason: collision with root package name */
        private int f12629a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.f12629a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public void a(int i) {
            this.f12629a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }
    }

    public static class q {

        /* renamed from: a, reason: collision with root package name */
        private int f12630a;
        private int b;

        public void a(int i) {
            this.f12630a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    public static class r {

        /* renamed from: a, reason: collision with root package name */
        private int f12631a;
        private String b;

        public int a() {
            return this.f12631a;
        }

        public String b() {
            return this.b;
        }

        public void a(int i) {
            this.f12631a = i;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public static class s {

        /* renamed from: a, reason: collision with root package name */
        private int f12632a;
        private String b;

        public int a() {
            return this.f12632a;
        }

        public String b() {
            return this.b;
        }

        public void a(int i) {
            this.f12632a = i;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public static class t {

        /* renamed from: a, reason: collision with root package name */
        private int f12633a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k = true;
        private Boolean l;
        private boolean m;
        private boolean n;
        private long o;
        private k p;
        private l q;
        private y r;
        private com.octopus.ad.model.h s;
        private ShakeValue t;
        private List<v> u;
        private Map<String, Object> v;

        public int a() {
            List<v> list = this.u;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int b() {
            return this.f12633a;
        }

        public String c() {
            return this.b;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.i;
        }

        public boolean f() {
            return this.j;
        }

        public String g() {
            return this.c;
        }

        public String h() {
            return this.d;
        }

        public String i() {
            return this.e;
        }

        public String j() {
            return this.f;
        }

        public String k() {
            return this.g;
        }

        public boolean l() {
            return this.k;
        }

        public Boolean m() {
            return this.l;
        }

        public boolean n() {
            return this.m;
        }

        public boolean o() {
            return this.n;
        }

        public k p() {
            return this.p;
        }

        public l q() {
            return this.q;
        }

        public y r() {
            return this.r;
        }

        public com.octopus.ad.model.h s() {
            return this.s;
        }

        public ShakeValue t() {
            return this.t;
        }

        public Map<String, Object> u() {
            return this.v;
        }

        public List<v> v() {
            return this.u;
        }

        public void a(int i) {
            this.f12633a = i;
        }

        public void b(boolean z) {
            this.i = z;
        }

        public void c(boolean z) {
            this.j = z;
        }

        public void d(boolean z) {
            SPUtils.put(com.octopus.ad.internal.q.a().j(), "logReportFlag", Boolean.valueOf(z));
        }

        public void e(String str) {
            this.g = str;
        }

        public void f(String str) {
            this.e = str;
        }

        public void g(boolean z) {
            this.n = z;
        }

        public void a(String str) {
            this.b = str;
        }

        public void b(String str) {
            this.c = str;
        }

        public void c(String str) {
            this.d = str;
        }

        public void e(boolean z) {
            this.k = z;
        }

        public void f(boolean z) {
            this.m = z;
        }

        private static t b(String str, String str2, long j, String str3) {
            String str4;
            String str5;
            String str6;
            String str7;
            ArrayList arrayList;
            int i;
            String str8;
            String str9;
            String str10;
            ArrayList arrayList2;
            String str11;
            v vVar;
            JSONObject jSONObject;
            v vVar2;
            v vVar3;
            JSONArray jSONArray;
            ArrayList arrayList3;
            int i2;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            ArrayList arrayList4;
            JSONObject jSONObject2;
            d dVar;
            JSONArray jSONArray2;
            String str19;
            v vVar4;
            JSONArray jSONArray3;
            int i3;
            d dVar2;
            JSONArray jSONArray4;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            ArrayList arrayList5;
            JSONObject jSONObject3;
            int i4;
            ArrayList arrayList6;
            v vVar5;
            int i5;
            d dVar3;
            JSONArray jSONArray5;
            ArrayList arrayList7;
            JSONArray jSONArray6;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            ArrayList arrayList8;
            JSONObject jSONObject4;
            int i6;
            int i7;
            String str30;
            JSONObject jSONObject5;
            o oVar;
            v vVar6;
            String str31 = str3;
            String str32 = "icon";
            String str33 = "description";
            String str34 = "title";
            String str35 = "resId";
            StringBuilder BChYOn2 = A2egSU.BChYOn("slotId = ", str, "，requestId = ", str2, "，encryptStr = ");
            BChYOn2.append(str31);
            com.octopus.ad.utils.b.f.b("ServerResponse", BChYOn2.toString());
            Boolean bool = (Boolean) SPUtils.getFromGroupSdk(com.octopus.ad.internal.q.a().n, "encrypt", Boolean.TRUE);
            if (bool == null || bool.booleanValue()) {
                str31 = com.octopus.ad.utils.b.a.b(com.octopus.ad.utils.b.e.a(), str31);
                com.octopus.ad.utils.b.f.d("ServerResponse", "decryptStr = " + str31);
            }
            t tVar = new t();
            if (str31 != null) {
                try {
                    JSONObject jSONObject6 = new JSONObject(str31);
                    tVar.a(jSONObject6.optString("errcode"));
                    tVar.b(jSONObject6.optString("errmsg"));
                    tVar.a(jSONObject6.optBoolean("preload"));
                    tVar.b(jSONObject6.optBoolean("initSo"));
                    tVar.c(jSONObject6.optBoolean("isHook"));
                    tVar.d(jSONObject6.optBoolean("logReportFlag", true));
                    tVar.a(jSONObject6.optInt("status"));
                    tVar.c(jSONObject6.optString("boostId"));
                    tVar.f(jSONObject6.optString("boostIds"));
                    tVar.a(jSONObject6.optLong("ts"));
                    JSONArray optJSONArray = jSONObject6.optJSONArray("spaceInfo");
                    ArrayList arrayList9 = new ArrayList();
                    if (b(optJSONArray)) {
                        int i8 = 0;
                        while (i8 < optJSONArray.length()) {
                            v vVar7 = new v();
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i8);
                            if (optJSONObject != null) {
                                vVar7.a(optJSONObject.optString("slotId"));
                                vVar7.b(optJSONObject.optString("spaceParam"));
                                vVar7.a(g.a.a(optJSONObject.optInt("adpType")));
                                vVar7.a(optJSONObject.optInt("refreshInterval"));
                                vVar7.c(optJSONObject.optString("wordText"));
                                vVar7.b(optJSONObject.optInt("filter"));
                                vVar7.a(g.h.a(optJSONObject.optInt("screenDirection")));
                                vVar7.d(optJSONObject.optString(MediaFormat.KEY_WIDTH));
                                vVar7.e(optJSONObject.optString(MediaFormat.KEY_HEIGHT));
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("adpPosition");
                                if (optJSONObject2 != null) {
                                    f fVar = new f();
                                    fVar.a(optJSONObject2.optString("x"));
                                    fVar.b(optJSONObject2.optString("y"));
                                    vVar7.a(fVar);
                                }
                                JSONObject optJSONObject3 = optJSONObject.optJSONObject("interEvent");
                                String str36 = "clk";
                                if (optJSONObject3 != null) {
                                    i = i8;
                                    o oVar2 = new o();
                                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("shakeEvent");
                                    if (optJSONObject4 != null) {
                                        arrayList2 = arrayList9;
                                        u uVar = new u();
                                        str8 = str32;
                                        int jSONInt = JsonUtil.getJSONInt(optJSONObject4, com.kuaishou.weapon.p0.t.c);
                                        str9 = str33;
                                        int jSONInt2 = JsonUtil.getJSONInt(optJSONObject4, "show");
                                        str10 = str34;
                                        int jSONInt3 = JsonUtil.getJSONInt(optJSONObject4, "time");
                                        str7 = str35;
                                        vVar6 = vVar7;
                                        jSONObject = optJSONObject;
                                        double jSONDouble = JsonUtil.getJSONDouble(optJSONObject4, "sr");
                                        str30 = "o";
                                        jSONObject5 = optJSONObject3;
                                        double jSONDouble2 = JsonUtil.getJSONDouble(optJSONObject4, "ang");
                                        uVar.a(jSONInt);
                                        uVar.d(jSONInt2);
                                        uVar.a(jSONDouble);
                                        uVar.b(jSONDouble2);
                                        uVar.f(jSONInt3);
                                        uVar.g(optJSONObject4.optInt("clk", 1));
                                        uVar.b(optJSONObject4.getInt("or"));
                                        uVar.c(optJSONObject4.getInt("sn"));
                                        uVar.a(optJSONObject4.getString("tx"));
                                        uVar.e(optJSONObject4.getInt(PointParamKey.TYPE));
                                        oVar2.a(uVar);
                                        if (jSONInt == 1 && jSONInt2 == 1) {
                                            ShakeValue shakeValue = new ShakeValue();
                                            oVar = oVar2;
                                            shakeValue.setAcceleration(Math.max(10.0d * jSONDouble, 15.0d));
                                            shakeValue.setAngle(Math.max(jSONDouble2, 35.0d));
                                            shakeValue.setTime(Math.max(jSONInt3, 3));
                                            tVar.a(shakeValue);
                                        } else {
                                            oVar = oVar2;
                                        }
                                    } else {
                                        str8 = str32;
                                        str9 = str33;
                                        str10 = str34;
                                        str7 = str35;
                                        arrayList2 = arrayList9;
                                        str30 = "o";
                                        jSONObject5 = optJSONObject3;
                                        oVar = oVar2;
                                        vVar6 = vVar7;
                                        jSONObject = optJSONObject;
                                    }
                                    JSONObject jSONObject7 = jSONObject5;
                                    JSONObject optJSONObject5 = jSONObject7.optJSONObject("scrollEvent");
                                    if (optJSONObject5 != null) {
                                        s sVar = new s();
                                        sVar.a(optJSONObject5.getInt(com.kuaishou.weapon.p0.t.c));
                                        sVar.a(optJSONObject5.getString("tx"));
                                        oVar.a(sVar);
                                    }
                                    JSONObject optJSONObject6 = jSONObject7.optJSONObject("fullScreenClk");
                                    if (optJSONObject6 != null) {
                                        m mVar = new m();
                                        mVar.a(optJSONObject6.getInt(com.kuaishou.weapon.p0.t.c));
                                        str11 = str30;
                                        mVar.b(optJSONObject6.getInt(str11));
                                        oVar.a(mVar);
                                    } else {
                                        str11 = str30;
                                    }
                                    JSONObject optJSONObject7 = jSONObject7.optJSONObject("regionScreenClk");
                                    if (optJSONObject7 != null) {
                                        r rVar = new r();
                                        rVar.a(optJSONObject7.getInt(com.kuaishou.weapon.p0.t.c));
                                        rVar.a(optJSONObject7.getString("tx"));
                                        oVar.a(rVar);
                                    }
                                    vVar = vVar6;
                                    vVar.a(oVar);
                                } else {
                                    str8 = str32;
                                    str9 = str33;
                                    str10 = str34;
                                    str7 = str35;
                                    arrayList2 = arrayList9;
                                    str11 = "o";
                                    i = i8;
                                    vVar = vVar7;
                                    jSONObject = optJSONObject;
                                }
                                JSONObject jSONObject8 = jSONObject;
                                JSONObject optJSONObject8 = jSONObject8.optJSONObject("strategy");
                                if (optJSONObject8 != null) {
                                    w wVar = new w();
                                    JSONObject optJSONObject9 = optJSONObject8.optJSONObject("pass");
                                    if (optJSONObject9 != null) {
                                        q qVar = new q();
                                        qVar.a(optJSONObject9.getInt(com.kuaishou.weapon.p0.t.c));
                                        qVar.b(optJSONObject9.getInt(str11));
                                        wVar.a(qVar);
                                        tVar.g(optJSONObject9.getInt(str11) == 1);
                                    }
                                    JSONObject optJSONObject10 = optJSONObject8.optJSONObject("aoclk");
                                    if (optJSONObject10 != null) {
                                        g gVar = new g();
                                        gVar.a(optJSONObject10.getInt("co"));
                                        gVar.b(optJSONObject10.getInt("ct"));
                                        gVar.c(optJSONObject10.getInt("cr"));
                                        gVar.d(optJSONObject10.getInt("cro"));
                                        wVar.a(gVar);
                                    }
                                    JSONObject optJSONObject11 = optJSONObject8.optJSONObject("impCallback");
                                    if (optJSONObject11 != null) {
                                        n nVar = new n();
                                        nVar.a(optJSONObject11.getInt(com.kuaishou.weapon.p0.t.c));
                                        nVar.b(optJSONObject11.getInt(str11));
                                        wVar.a(nVar);
                                        tVar.e(optJSONObject11.getInt(str11) == 1);
                                    }
                                    JSONObject optJSONObject12 = optJSONObject8.optJSONObject("callback");
                                    if (optJSONObject12 != null) {
                                        h hVar = new h();
                                        hVar.a(optJSONObject12.getInt(com.kuaishou.weapon.p0.t.c));
                                        hVar.b(optJSONObject12.getInt(str11));
                                        wVar.a(hVar);
                                        tVar.a(Boolean.valueOf(optJSONObject12.getInt(str11) == 1));
                                    }
                                    JSONObject optJSONObject13 = optJSONObject8.optJSONObject("touchclk");
                                    if (optJSONObject13 != null) {
                                        x xVar = new x();
                                        xVar.a(optJSONObject13.getInt(str11));
                                        wVar.a(xVar);
                                        tVar.f(optJSONObject13.getInt(str11) == 1);
                                    }
                                    JSONObject optJSONObject14 = optJSONObject8.optJSONObject("dialog");
                                    if (optJSONObject14 != null) {
                                        j jVar = new j();
                                        jVar.a(optJSONObject14.getInt(com.kuaishou.weapon.p0.t.c));
                                        wVar.a(jVar);
                                    }
                                    JSONObject optJSONObject15 = optJSONObject8.optJSONObject("nDpUp");
                                    if (optJSONObject15 != null) {
                                        p pVar = new p();
                                        pVar.a(optJSONObject15.getInt("eo"));
                                        pVar.c(optJSONObject15.getInt("et"));
                                        pVar.b(optJSONObject15.getInt("co"));
                                        pVar.d(optJSONObject15.getInt("ct"));
                                        wVar.a(pVar);
                                    }
                                    JSONObject optJSONObject16 = optJSONObject8.optJSONObject("dpClk");
                                    if (optJSONObject16 != null) {
                                        k kVar = new k();
                                        kVar.a(optJSONObject16.getInt("co"));
                                        kVar.b(optJSONObject16.getInt("ct"));
                                        kVar.a(optJSONObject16.getDouble("cx"));
                                        kVar.b(optJSONObject16.getDouble("cy"));
                                        wVar.a(kVar);
                                        tVar.a(kVar);
                                    }
                                    JSONObject optJSONObject17 = optJSONObject8.optJSONObject("dpInt");
                                    if (optJSONObject17 != null) {
                                        l lVar = new l();
                                        lVar.a(optJSONObject17.getInt("ct"));
                                        lVar.a(optJSONObject17.getString("key"));
                                        lVar.b(optJSONObject17.getString("pkg"));
                                        lVar.b(optJSONObject17.getInt("ploy"));
                                        wVar.a(lVar);
                                        tVar.a(lVar);
                                    }
                                    JSONObject optJSONObject18 = optJSONObject8.optJSONObject("vdp");
                                    if (optJSONObject18 != null) {
                                        y yVar = new y();
                                        yVar.a(optJSONObject18.getInt("co"));
                                        yVar.b(optJSONObject18.getInt("ct"));
                                        wVar.a(yVar);
                                        tVar.a(yVar);
                                    }
                                    tVar.e(JsonUtil.getJSONString(optJSONObject8, "dpForbid"));
                                    vVar.a(wVar);
                                }
                                vVar.a(jSONObject8.optBoolean("autoClose"));
                                vVar.b(jSONObject8.optBoolean("manualClosable"));
                                vVar.c(jSONObject8.optBoolean("isStopover"));
                                vVar.d(jSONObject8.optBoolean("isEndPage"));
                                vVar.e(jSONObject8.optBoolean("isTexture"));
                                vVar.f(jSONObject8.optBoolean("isWaitCache"));
                                vVar.c(jSONObject8.optInt("maxTime"));
                                vVar.d(jSONObject8.optInt("minTime"));
                                vVar.e(jSONObject8.optInt("repeatNum"));
                                vVar.g(jSONObject8.optBoolean("wifiPreload"));
                                vVar.h(jSONObject8.optBoolean(com.sigmob.sdk.base.common.a.z));
                                vVar.i(jSONObject8.optBoolean("fullScreen"));
                                vVar.j(jSONObject8.optBoolean("usePkg"));
                                vVar.k(jSONObject8.optBoolean("newDp"));
                                vVar.l(jSONObject8.optBoolean("listenCancel"));
                                vVar.m(jSONObject8.optBoolean("backgroundDim"));
                                vVar.n(jSONObject8.optBoolean("autoPlay"));
                                vVar.h(jSONObject8.optInt("orgID"));
                                vVar.f(jSONObject8.optInt("callModel", 200));
                                vVar.i(jSONObject8.optInt("contentType"));
                                vVar.f(jSONObject8.optString("changeUrl"));
                                vVar.g(jSONObject8.optInt("changeDelay", 5000));
                                vVar.g(jSONObject8.optString("appID"));
                                vVar.j(jSONObject8.optInt("acratio"));
                                vVar.o(JsonUtil.getJSONBoolean(jSONObject8, "isShakeAd"));
                                JSONArray optJSONArray2 = jSONObject8.optJSONArray("adResponse");
                                ArrayList arrayList10 = new ArrayList();
                                if (b(optJSONArray2)) {
                                    int i9 = 0;
                                    while (i9 < optJSONArray2.length()) {
                                        JSONObject optJSONObject19 = optJSONArray2.optJSONObject(i9);
                                        if (optJSONObject19 != null) {
                                            d dVar4 = new d();
                                            dVar4.a(optJSONObject19.optString("extInfo"));
                                            dVar4.b(optJSONObject19.optString("adid"));
                                            JSONArray optJSONArray3 = optJSONObject19.optJSONArray("contentInfo");
                                            ArrayList arrayList11 = new ArrayList();
                                            if (b(optJSONArray3)) {
                                                int i10 = 0;
                                                while (i10 < optJSONArray3.length()) {
                                                    JSONObject optJSONObject20 = optJSONArray3.optJSONObject(i10);
                                                    a aVar = new a();
                                                    aVar.a(optJSONObject20.optString(ClickCommon.CLICK_SCENE_TEMPLATE));
                                                    aVar.b(optJSONObject20.optString("richText"));
                                                    aVar.a(g.f.a(optJSONObject20.optInt("renderType")));
                                                    JSONArray optJSONArray4 = optJSONObject20.optJSONArray("adcontentSlot");
                                                    if (b(optJSONArray4)) {
                                                        ArrayList arrayList12 = new ArrayList();
                                                        jSONArray3 = optJSONArray2;
                                                        int i11 = 0;
                                                        while (i11 < optJSONArray4.length()) {
                                                            JSONObject optJSONObject21 = optJSONArray4.optJSONObject(i11);
                                                            if (optJSONObject21 != null) {
                                                                i5 = i9;
                                                                e eVar = new e();
                                                                jSONArray5 = optJSONArray3;
                                                                int optInt = optJSONObject21.optInt("resType");
                                                                str29 = str7;
                                                                i6 = i10;
                                                                String optString = optJSONObject21.optString(str29);
                                                                jSONArray6 = optJSONArray4;
                                                                str28 = str10;
                                                                i7 = i11;
                                                                String optString2 = optJSONObject21.optString(str28);
                                                                vVar5 = vVar;
                                                                str27 = str9;
                                                                arrayList8 = arrayList10;
                                                                String optString3 = optJSONObject21.optString(str27);
                                                                str25 = str36;
                                                                str26 = str8;
                                                                jSONObject4 = optJSONObject19;
                                                                String optString4 = optJSONObject21.optString(str26);
                                                                dVar3 = dVar4;
                                                                String optString5 = optJSONObject21.optString(IAdInterListener.AdProdType.PRODUCT_CONTENT);
                                                                arrayList7 = arrayList11;
                                                                HashMap hashMap = new HashMap();
                                                                hashMap.put(str29, optString);
                                                                hashMap.put(str28, optString2);
                                                                hashMap.put(str27, optString3);
                                                                hashMap.put(str26, optString4);
                                                                hashMap.put("imageMode", Integer.valueOf(optInt));
                                                                if (optInt == 0) {
                                                                    hashMap.put("imageUrl", optString5);
                                                                } else {
                                                                    hashMap.put("videoUrl", optString5);
                                                                }
                                                                tVar.a(hashMap);
                                                                eVar.b(optJSONObject21.optString(TKDownloadReason.KSAD_TK_MD5));
                                                                eVar.c(optString5);
                                                                String optString6 = optJSONObject21.optString("mime");
                                                                eVar.a(optString6);
                                                                arrayList12.add(eVar);
                                                                tVar.d(optString6);
                                                            } else {
                                                                vVar5 = vVar;
                                                                i5 = i9;
                                                                dVar3 = dVar4;
                                                                jSONArray5 = optJSONArray3;
                                                                arrayList7 = arrayList11;
                                                                jSONArray6 = optJSONArray4;
                                                                str25 = str36;
                                                                str26 = str8;
                                                                str27 = str9;
                                                                str28 = str10;
                                                                str29 = str7;
                                                                arrayList8 = arrayList10;
                                                                jSONObject4 = optJSONObject19;
                                                                i6 = i10;
                                                                i7 = i11;
                                                            }
                                                            i11 = i7 + 1;
                                                            str10 = str28;
                                                            optJSONObject19 = jSONObject4;
                                                            arrayList10 = arrayList8;
                                                            i10 = i6;
                                                            i9 = i5;
                                                            optJSONArray4 = jSONArray6;
                                                            dVar4 = dVar3;
                                                            arrayList11 = arrayList7;
                                                            str9 = str27;
                                                            str7 = str29;
                                                            str8 = str26;
                                                            optJSONArray3 = jSONArray5;
                                                            vVar = vVar5;
                                                            str36 = str25;
                                                        }
                                                        vVar4 = vVar;
                                                        i3 = i9;
                                                        dVar2 = dVar4;
                                                        jSONArray4 = optJSONArray3;
                                                        str20 = str36;
                                                        str21 = str8;
                                                        str22 = str9;
                                                        str23 = str10;
                                                        str24 = str7;
                                                        arrayList5 = arrayList10;
                                                        jSONObject3 = optJSONObject19;
                                                        i4 = i10;
                                                        aVar.a(arrayList12);
                                                        arrayList6 = arrayList11;
                                                    } else {
                                                        vVar4 = vVar;
                                                        jSONArray3 = optJSONArray2;
                                                        i3 = i9;
                                                        dVar2 = dVar4;
                                                        jSONArray4 = optJSONArray3;
                                                        str20 = str36;
                                                        str21 = str8;
                                                        str22 = str9;
                                                        str23 = str10;
                                                        str24 = str7;
                                                        arrayList5 = arrayList10;
                                                        jSONObject3 = optJSONObject19;
                                                        i4 = i10;
                                                        arrayList6 = arrayList11;
                                                    }
                                                    arrayList6.add(aVar);
                                                    i10 = i4 + 1;
                                                    arrayList11 = arrayList6;
                                                    str7 = str24;
                                                    str10 = str23;
                                                    optJSONObject19 = jSONObject3;
                                                    arrayList10 = arrayList5;
                                                    optJSONArray2 = jSONArray3;
                                                    i9 = i3;
                                                    optJSONArray3 = jSONArray4;
                                                    dVar4 = dVar2;
                                                    str9 = str22;
                                                    str8 = str21;
                                                    vVar = vVar4;
                                                    str36 = str20;
                                                }
                                                vVar3 = vVar;
                                                jSONArray = optJSONArray2;
                                                i2 = i9;
                                                str16 = str36;
                                                str13 = str8;
                                                str17 = str9;
                                                str15 = str10;
                                                str18 = str7;
                                                arrayList4 = arrayList10;
                                                jSONObject2 = optJSONObject19;
                                                dVar = dVar4;
                                                dVar.a(arrayList11);
                                            } else {
                                                vVar3 = vVar;
                                                jSONArray = optJSONArray2;
                                                i2 = i9;
                                                str16 = str36;
                                                str13 = str8;
                                                str17 = str9;
                                                str15 = str10;
                                                str18 = str7;
                                                arrayList4 = arrayList10;
                                                jSONObject2 = optJSONObject19;
                                                dVar = dVar4;
                                            }
                                            JSONObject jSONObject9 = jSONObject2;
                                            JSONObject optJSONObject22 = jSONObject9.optJSONObject("adLogo");
                                            if (optJSONObject22 != null) {
                                                C0422c c0422c = new C0422c();
                                                c0422c.b(optJSONObject22.optString("adLabel"));
                                                c0422c.a(optJSONObject22.optString("adLabelUrl"));
                                                c0422c.d(optJSONObject22.optString("sourceLabel"));
                                                c0422c.c(optJSONObject22.optString("sourceUrl"));
                                                dVar.a(c0422c);
                                            }
                                            dVar.a(jSONObject9.optInt("price"));
                                            dVar.c(jSONObject9.optString("tagid"));
                                            dVar.a(jSONObject9.optLong("validTime", com.octopus.ad.internal.q.s));
                                            b bVar = new b();
                                            JSONObject optJSONObject23 = jSONObject9.optJSONObject("interactInfo");
                                            if (optJSONObject23 != null) {
                                                JSONArray optJSONArray5 = optJSONObject23.optJSONArray("thirdpartInfo");
                                                if (b(optJSONArray5)) {
                                                    ArrayList arrayList13 = new ArrayList();
                                                    for (int i12 = 0; i12 < optJSONArray5.length(); i12++) {
                                                        JSONObject optJSONObject24 = optJSONArray5.optJSONObject(i12);
                                                        if (optJSONObject24 != null) {
                                                            i iVar = new i();
                                                            iVar.b(optJSONObject24.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY));
                                                            iVar.a(optJSONObject24.optString("viewUrl"));
                                                            iVar.c(optJSONObject24.optString("dpSucessUrl"));
                                                            iVar.d(optJSONObject24.optString("downSucessUrl"));
                                                            iVar.e(optJSONObject24.optString("convertUrl"));
                                                            iVar.i(optJSONObject24.optString("onFinish"));
                                                            iVar.g(optJSONObject24.optString("onPause"));
                                                            iVar.h(optJSONObject24.optString("onRecover"));
                                                            iVar.f(optJSONObject24.optString("onStart"));
                                                            arrayList13.add(iVar);
                                                        }
                                                    }
                                                    bVar.b(arrayList13);
                                                }
                                                JSONArray optJSONArray6 = optJSONObject23.optJSONArray("videoTrackers");
                                                if (b(optJSONArray6)) {
                                                    ArrayList arrayList14 = new ArrayList();
                                                    str14 = str17;
                                                    int i13 = 0;
                                                    while (i13 < optJSONArray6.length()) {
                                                        JSONObject optJSONObject25 = optJSONArray6.optJSONObject(i13);
                                                        if (optJSONObject25 != null) {
                                                            jSONArray2 = optJSONArray6;
                                                            z zVar = new z();
                                                            str19 = str18;
                                                            zVar.a(optJSONObject25.optString("start"));
                                                            zVar.b(optJSONObject25.optString(com.sigmob.sdk.base.common.a.j));
                                                            zVar.c(optJSONObject25.optString("quarter"));
                                                            zVar.d(optJSONObject25.optString("half"));
                                                            zVar.e(optJSONObject25.optString("threeQuarter"));
                                                            zVar.f(optJSONObject25.optString("complete"));
                                                            zVar.g(optJSONObject25.optString("exit"));
                                                            arrayList14.add(zVar);
                                                        } else {
                                                            jSONArray2 = optJSONArray6;
                                                            str19 = str18;
                                                        }
                                                        i13++;
                                                        optJSONArray6 = jSONArray2;
                                                        str18 = str19;
                                                    }
                                                    str7 = str18;
                                                    bVar.a(arrayList14);
                                                } else {
                                                    str14 = str17;
                                                    str7 = str18;
                                                }
                                                bVar.d(optJSONObject23.optString("apkName"));
                                                bVar.g(optJSONObject23.optString("appDesc"));
                                                bVar.h(optJSONObject23.optString("appDownloadURL"));
                                                bVar.f(optJSONObject23.optString("appStoreID"));
                                                bVar.a(optJSONObject23.optString("landingPageUrl"));
                                                bVar.b(optJSONObject23.optString("deeplinkUrl"));
                                                bVar.c(optJSONObject23.optString("sign"));
                                                bVar.a(optJSONObject23.optInt("interactType"));
                                                bVar.e(optJSONObject23.optString("packageName"));
                                                bVar.b(optJSONObject23.optBoolean("checkSuccess"));
                                                bVar.a(optJSONObject23.optBoolean("useBuiltInBrow"));
                                                bVar.c(JsonUtil.getJSONBoolean(optJSONObject23, "dpCancelOpenUrl", true));
                                                bVar.d(optJSONObject23.optBoolean("preloadWebView"));
                                                bVar.b(optJSONObject23.optInt("openExternal"));
                                                JSONObject optJSONObject26 = optJSONObject23.optJSONObject("complianceInfo");
                                                if (optJSONObject26 != null) {
                                                    ComplianceInfo complianceInfo = new ComplianceInfo();
                                                    complianceInfo.setAppName(optJSONObject26.optString("appName"));
                                                    complianceInfo.setAppVersion(optJSONObject26.optString("appVersion"));
                                                    complianceInfo.setDeveloperName(optJSONObject26.optString("developerName"));
                                                    complianceInfo.setPrivacyUrl(optJSONObject26.optString("privacyUrl"));
                                                    complianceInfo.setPermissionsUrl(optJSONObject26.optString("permissionsUrl"));
                                                    complianceInfo.setFunctionDescUrl(optJSONObject26.optString("functionDescUrl"));
                                                    complianceInfo.setAppIconURL(optJSONObject26.optString("appIconURL"));
                                                    bVar.a(complianceInfo);
                                                }
                                                JSONObject optJSONObject27 = optJSONObject23.optJSONObject("wxReq");
                                                if (optJSONObject27 != null) {
                                                    com.octopus.ad.model.i iVar2 = new com.octopus.ad.model.i();
                                                    iVar2.a(optJSONObject27.optString("path"));
                                                    iVar2.b(optJSONObject27.optString(MedProConst.AD_APPID));
                                                    iVar2.c(optJSONObject27.optString("userName"));
                                                    bVar.a(iVar2);
                                                }
                                                JSONObject jSONObject10 = JsonUtil.getJSONObject(optJSONObject23, "videoMacroExt");
                                                if (jSONObject10 != null) {
                                                    com.octopus.ad.model.h hVar2 = new com.octopus.ad.model.h();
                                                    hVar2.a(JsonUtil.getJSONString(jSONObject10, "__oct_video_start_ts__"));
                                                    hVar2.b(JsonUtil.getJSONString(jSONObject10, "__oct_video_end_ts__"));
                                                    tVar.a(hVar2);
                                                }
                                                JSONObject jSONObject11 = JsonUtil.getJSONObject(optJSONObject23, "clkMacroExt");
                                                if (jSONObject11 != null) {
                                                    com.octopus.ad.model.e eVar2 = new com.octopus.ad.model.e();
                                                    eVar2.d(JsonUtil.getJSONString(jSONObject11, "__oct_down_x__"));
                                                    eVar2.e(JsonUtil.getJSONString(jSONObject11, "__oct_down_y__"));
                                                    eVar2.f(JsonUtil.getJSONString(jSONObject11, "__oct_down_time__"));
                                                    eVar2.a(JsonUtil.getJSONString(jSONObject11, "__oct_up_x__"));
                                                    eVar2.b(JsonUtil.getJSONString(jSONObject11, "__oct_up_y__"));
                                                    eVar2.c(JsonUtil.getJSONString(jSONObject11, "__oct_up_time__"));
                                                    eVar2.g(JsonUtil.getJSONString(jSONObject11, "__oct_x_max_acc__"));
                                                    eVar2.h(JsonUtil.getJSONString(jSONObject11, "__oct_y_max_acc__"));
                                                    eVar2.i(JsonUtil.getJSONString(jSONObject11, "__oct_z_max_acc__"));
                                                    eVar2.k(JsonUtil.getJSONString(jSONObject11, "__oct_shake_acc__"));
                                                    eVar2.l(JsonUtil.getJSONString(jSONObject11, "__oct_shake_ang__"));
                                                    eVar2.j(JsonUtil.getJSONString(jSONObject11, "__oct_shake_cnt__"));
                                                    eVar2.m(JsonUtil.getJSONString(jSONObject11, "__oct_turn_x__"));
                                                    eVar2.n(JsonUtil.getJSONString(jSONObject11, "__oct_turn_y__"));
                                                    eVar2.o(JsonUtil.getJSONString(jSONObject11, "__oct_turn_z__"));
                                                    eVar2.p(JsonUtil.getJSONString(jSONObject11, "__oct_turn_time__"));
                                                    eVar2.q(JsonUtil.getJSONString(jSONObject11, "__oct_s_time__"));
                                                    eVar2.r(JsonUtil.getJSONString(jSONObject11, "__oct_ms_time__"));
                                                    eVar2.a(JsonUtil.getJSONInt(jSONObject11, "accMultiple"));
                                                    JSONObject jSONObject12 = JsonUtil.getJSONObject(jSONObject11, "__oct_click_type__");
                                                    if (jSONObject12 != null) {
                                                        e.a aVar2 = new e.a();
                                                        str12 = str16;
                                                        aVar2.a(JsonUtil.getJSONString(jSONObject12, str12));
                                                        aVar2.b(JsonUtil.getJSONString(jSONObject12, "shake"));
                                                        aVar2.c(JsonUtil.getJSONString(jSONObject12, "scroll"));
                                                        eVar2.a(aVar2);
                                                    } else {
                                                        str12 = str16;
                                                    }
                                                    bVar.a(eVar2);
                                                } else {
                                                    str12 = str16;
                                                }
                                                JSONObject optJSONObject28 = optJSONObject23.optJSONObject("followTrackExt");
                                                if (optJSONObject28 != null) {
                                                    b.a aVar3 = new b.a();
                                                    aVar3.a(a(optJSONObject28.optJSONArray("open")));
                                                    aVar3.b(a(optJSONObject28.optJSONArray("beginDownload")));
                                                    aVar3.c(a(optJSONObject28.optJSONArray("download")));
                                                    aVar3.d(a(optJSONObject28.optJSONArray("beginInstall")));
                                                    aVar3.e(a(optJSONObject28.optJSONArray("install")));
                                                    aVar3.f(a(optJSONObject28.optJSONArray("active")));
                                                    aVar3.g(a(optJSONObject28.optJSONArray("close")));
                                                    aVar3.h(a(optJSONObject28.optJSONArray("showSlide")));
                                                    aVar3.j(a(optJSONObject28.optJSONArray("pageClose")));
                                                    aVar3.i(a(optJSONObject28.optJSONArray("pageLoad")));
                                                    aVar3.k(a(optJSONObject28.optJSONArray("pageAction")));
                                                    aVar3.l(a(optJSONObject28.optJSONArray("deepLinkSuccess")));
                                                    aVar3.m(a(optJSONObject28.optJSONArray("deepLinkFail")));
                                                    aVar3.n(a(optJSONObject28.optJSONArray("dpAppInstalled")));
                                                    aVar3.o(a(optJSONObject28.optJSONArray("dpAppNotInstalled")));
                                                    bVar.a(aVar3);
                                                }
                                                JSONObject optJSONObject29 = optJSONObject23.optJSONObject("videoTrackExt");
                                                if (optJSONObject29 != null) {
                                                    b.C0421b c0421b = new b.C0421b();
                                                    c0421b.a(a(optJSONObject29.optJSONArray("start")));
                                                    c0421b.b(a(optJSONObject29.optJSONArray(com.sigmob.sdk.base.common.a.j)));
                                                    c0421b.c(a(optJSONObject29.optJSONArray("continue")));
                                                    c0421b.d(a(optJSONObject29.optJSONArray("exit")));
                                                    c0421b.e(a(optJSONObject29.optJSONArray("complete")));
                                                    JSONArray optJSONArray7 = optJSONObject29.optJSONArray("showTrack");
                                                    ArrayList arrayList15 = new ArrayList();
                                                    if (b(optJSONArray7)) {
                                                        for (int i14 = 0; i14 < optJSONArray7.length(); i14++) {
                                                            JSONObject optJSONObject30 = optJSONArray7.optJSONObject(i14);
                                                            if (optJSONObject30 != null) {
                                                                b.C0421b.a aVar4 = new b.C0421b.a();
                                                                aVar4.a(optJSONObject30.optInt(com.kwad.components.core.s.t.TAG));
                                                                aVar4.a(a(optJSONObject30.optJSONArray("url")));
                                                                arrayList15.add(aVar4);
                                                            }
                                                        }
                                                        c0421b.f(arrayList15);
                                                    }
                                                    bVar.a(c0421b);
                                                }
                                                dVar.a(bVar);
                                            } else {
                                                str14 = str17;
                                                str7 = str18;
                                                str12 = str16;
                                            }
                                            arrayList3 = arrayList4;
                                            arrayList3.add(dVar);
                                        } else {
                                            vVar3 = vVar;
                                            jSONArray = optJSONArray2;
                                            arrayList3 = arrayList10;
                                            i2 = i9;
                                            str12 = str36;
                                            str13 = str8;
                                            str14 = str9;
                                            str15 = str10;
                                        }
                                        i9 = i2 + 1;
                                        arrayList10 = arrayList3;
                                        str10 = str15;
                                        str9 = str14;
                                        optJSONArray2 = jSONArray;
                                        vVar = vVar3;
                                        str8 = str13;
                                        str36 = str12;
                                    }
                                    vVar2 = vVar;
                                    str4 = str8;
                                    str5 = str9;
                                    str6 = str10;
                                    vVar2.a(arrayList10);
                                } else {
                                    vVar2 = vVar;
                                    str4 = str8;
                                    str5 = str9;
                                    str6 = str10;
                                }
                                arrayList = arrayList2;
                                arrayList.add(vVar2);
                            } else {
                                str4 = str32;
                                str5 = str33;
                                str6 = str34;
                                str7 = str35;
                                arrayList = arrayList9;
                                i = i8;
                            }
                            i8 = i + 1;
                            arrayList9 = arrayList;
                            str34 = str6;
                            str32 = str4;
                            str33 = str5;
                            str35 = str7;
                        }
                        tVar.a(arrayList9);
                        return tVar;
                    }
                } catch (Exception e) {
                    com.octopus.ad.internal.o.a(new com.octopus.ad.internal.l("JSONERROR", str, str2, System.currentTimeMillis() - j, e.getMessage()));
                    com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
            return tVar;
        }

        public void a(boolean z) {
            this.h = z;
        }

        public void d(String str) {
            this.f = str;
        }

        public void a(Boolean bool) {
            this.l = bool;
        }

        public void a(k kVar) {
            this.p = kVar;
        }

        public void a(l lVar) {
            this.q = lVar;
        }

        public void a(y yVar) {
            this.r = yVar;
        }

        public void a(com.octopus.ad.model.h hVar) {
            this.s = hVar;
        }

        public void a(ShakeValue shakeValue) {
            this.t = shakeValue;
        }

        public void a(long j) {
            this.o = j;
        }

        public void a(Map<String, Object> map) {
            this.v = map;
        }

        public void a(List<v> list) {
            this.u = list;
        }

        public static t a(InputStream inputStream, String str, String str2, long j, boolean z) {
            if (inputStream == null) {
                return null;
            }
            try {
                String a2 = a(inputStream);
                if (!TextUtils.isEmpty(a2)) {
                    com.octopus.ad.utils.b.f.c("OctopusAd_Time", "是否缓存广告：" + z);
                    if (z) {
                        SPUtils.put(com.octopus.ad.internal.q.a().j(), "adPreRsp_" + str, a2 + "@#&!" + str2 + "@#&!" + System.currentTimeMillis());
                    }
                    return b(str, str2, j, a2);
                }
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            }
            return null;
        }

        public static t a(String str, String str2, long j, String str3) {
            try {
                return b(str, str2, j, str3);
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }

        private static String a(InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        }

        private static ArrayList<String> a(JSONArray jSONArray) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (b(jSONArray)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }

        private static boolean b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }
    }

    public static class u {

        /* renamed from: a, reason: collision with root package name */
        private int f12634a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private double h;
        private double i;
        private String j;

        public u() {
            this.c = 1;
            this.h = 1.5d;
        }

        public int a() {
            return this.f12634a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.d;
        }

        public double d() {
            return this.h;
        }

        public String e() {
            return this.j;
        }

        public double f() {
            return this.i;
        }

        public int g() {
            return this.c;
        }

        public int h() {
            return this.e;
        }

        public int i() {
            return this.g;
        }

        public void a(int i) {
            this.f12634a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.d = i;
        }

        public void d(int i) {
            this.c = i;
        }

        public void e(int i) {
            this.e = i;
        }

        public void f(int i) {
            this.f = i;
        }

        public void g(int i) {
            this.g = i;
        }

        public void a(double d) {
            this.h = d;
        }

        public void b(double d) {
            this.i = d;
        }

        public u(double d, double d2, int i, String str, int i2, int i3, int i4, int i5) {
            this.h = d;
            this.d = i;
            this.i = d2;
            this.j = str;
            this.c = i2;
            this.b = i3;
            this.e = i4;
            this.f = i5;
        }

        public void a(String str) {
            this.j = str;
        }
    }

    public static class v {
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private boolean E;
        private String F;
        private int G;
        private int H;
        private int I;
        private int J;
        private String K;
        private int L;
        private List<d> M;

        /* renamed from: a, reason: collision with root package name */
        private String f12635a;
        private String b;
        private g.a c;
        private int d;
        private String e;
        private g.h f;
        private int g;
        private String h;
        private String i;
        private f j;
        private o k;
        private w l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private boolean w;
        private boolean x;
        private boolean y;
        private boolean z;

        public int A() {
            return this.I;
        }

        public boolean B() {
            return this.A;
        }

        public boolean C() {
            return this.B;
        }

        public boolean D() {
            return this.C;
        }

        public boolean E() {
            return this.D;
        }

        public boolean F() {
            return this.E;
        }

        public String G() {
            return this.F;
        }

        public int H() {
            return this.G;
        }

        public int I() {
            return this.L;
        }

        public List<d> J() {
            return this.M;
        }

        public int K() {
            List<d> list = this.M;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String a() {
            return this.f12635a;
        }

        public String b() {
            return this.b;
        }

        public g.a c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public g.h f() {
            return this.f;
        }

        public int g() {
            return this.g;
        }

        public String h() {
            return this.h;
        }

        public String i() {
            return this.i;
        }

        public f j() {
            return this.j;
        }

        public o k() {
            return this.k;
        }

        public w l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        public boolean n() {
            return this.n;
        }

        public boolean o() {
            return this.o;
        }

        public boolean p() {
            return this.p;
        }

        public boolean q() {
            return this.q;
        }

        public boolean r() {
            return this.r;
        }

        public int s() {
            return this.s;
        }

        public int t() {
            return this.t;
        }

        public int u() {
            return this.u;
        }

        public boolean v() {
            return this.v;
        }

        public boolean w() {
            return this.w;
        }

        public boolean x() {
            return this.x;
        }

        public boolean y() {
            return this.y;
        }

        public boolean z() {
            return this.z;
        }

        public void a(String str) {
            this.f12635a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.e = str;
        }

        public void d(String str) {
            this.h = str;
        }

        public void e(String str) {
            this.i = str;
        }

        public void f(boolean z) {
            this.r = z;
        }

        public void g(boolean z) {
            this.v = z;
        }

        public void h(boolean z) {
            this.w = z;
        }

        public void i(boolean z) {
            this.x = z;
        }

        public void j(boolean z) {
            this.y = z;
        }

        public void k(boolean z) {
            this.z = z;
        }

        public void l(boolean z) {
            this.A = z;
        }

        public void m(boolean z) {
            this.B = z;
        }

        public void n(boolean z) {
            this.C = z;
        }

        public void o(boolean z) {
            this.E = z;
        }

        public void a(g.a aVar) {
            this.c = aVar;
        }

        public void b(int i) {
            this.g = i;
        }

        public void c(boolean z) {
            this.o = z;
        }

        public void d(boolean z) {
            this.p = z;
        }

        public void e(boolean z) {
            this.q = z;
        }

        public void f(int i) {
            this.I = i;
        }

        public void g(int i) {
            this.G = i;
        }

        public void h(int i) {
            this.H = i;
        }

        public void i(int i) {
            this.J = i;
        }

        public void j(int i) {
            this.L = i;
        }

        public void a(int i) {
            this.d = i;
        }

        public void b(boolean z) {
            this.n = z;
        }

        public void c(int i) {
            this.s = i;
        }

        public void d(int i) {
            this.t = i;
        }

        public void e(int i) {
            this.u = i;
        }

        public void f(String str) {
            this.F = str;
        }

        public void g(String str) {
            this.K = str;
        }

        public void a(g.h hVar) {
            this.f = hVar;
        }

        public void a(f fVar) {
            this.j = fVar;
        }

        public void a(o oVar) {
            this.k = oVar;
        }

        public void a(w wVar) {
            this.l = wVar;
        }

        public void a(boolean z) {
            this.m = z;
        }

        public void a(List<d> list) {
            this.M = list;
        }
    }

    public static class w {

        /* renamed from: a, reason: collision with root package name */
        private q f12636a;
        private g b;
        private n c;
        private h d;
        private x e;
        private j f;
        private p g;
        private k h;
        private l i;
        private y j;

        public void a(q qVar) {
            this.f12636a = qVar;
        }

        public j b() {
            return this.f;
        }

        public p c() {
            return this.g;
        }

        public g a() {
            return this.b;
        }

        public void a(g gVar) {
            this.b = gVar;
        }

        public void a(n nVar) {
            this.c = nVar;
        }

        public void a(h hVar) {
            this.d = hVar;
        }

        public void a(x xVar) {
            this.e = xVar;
        }

        public void a(j jVar) {
            this.f = jVar;
        }

        public void a(p pVar) {
            this.g = pVar;
        }

        public void a(k kVar) {
            this.h = kVar;
        }

        public void a(l lVar) {
            this.i = lVar;
        }

        public void a(y yVar) {
            this.j = yVar;
        }
    }

    public static class x {

        /* renamed from: a, reason: collision with root package name */
        private int f12637a;

        public void a(int i) {
            this.f12637a = i;
        }
    }

    public static class y {

        /* renamed from: a, reason: collision with root package name */
        private int f12638a;
        private int b;

        public int a() {
            return this.f12638a;
        }

        public int b() {
            return this.b;
        }

        public void a(int i) {
            this.f12638a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    public static class z {

        /* renamed from: a, reason: collision with root package name */
        private String f12639a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public String a() {
            return this.f12639a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.g;
        }

        public void a(String str) {
            this.f12639a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public void e(String str) {
            this.e = str;
        }

        public void f(String str) {
            this.f = str;
        }

        public void g(String str) {
            this.g = str;
        }
    }
}
