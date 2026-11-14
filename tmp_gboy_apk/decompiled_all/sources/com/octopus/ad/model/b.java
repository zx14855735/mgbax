package com.octopus.ad.model;

import com.octopus.ad.internal.q;
import com.octopus.ad.model.f;
import com.octopus.ad.model.g;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f12607a;
        private String b;
        private String c;
        private long d;
        private String e;

        /* renamed from: com.octopus.ad.model.b$a$a, reason: collision with other inner class name */
        public static final class C0419a {

            /* renamed from: a, reason: collision with root package name */
            private String f12608a;
            private String b;
            private String c;
            private long d;
            private String e;

            public C0419a a(String str) {
                this.f12608a = str;
                return this;
            }

            public C0419a b(String str) {
                this.b = str;
                return this;
            }

            public C0419a c(String str) {
                this.c = str;
                return this;
            }

            public a a() {
                a aVar = new a();
                aVar.d = this.d;
                aVar.c = this.c;
                aVar.e = this.e;
                aVar.b = this.b;
                aVar.f12607a = this.f12608a;
                return aVar;
            }
        }

        private a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("slotId", this.f12607a);
                jSONObject.put("spaceParam", this.b);
                jSONObject.put("requestUUID", this.c);
                jSONObject.put("channelReserveTs", this.d);
                jSONObject.put("sdkExtInfo", this.e);
                jSONObject.put("ssl", q.a().c);
                jSONObject.put("ipv6", q.a().d);
                return jSONObject;
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }
    }

    /* renamed from: com.octopus.ad.model.b$b, reason: collision with other inner class name */
    public static class C0420b {

        /* renamed from: a, reason: collision with root package name */
        private String f12609a;
        private String b;
        private g.i c;
        private g.EnumC0424g d;
        private long e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private long k;
        private long l;
        private boolean m;
        private ShakeValue n;
        private f.a o;
        private f.c p;
        private f.b q;
        private ArrayList<a> r;

        /* renamed from: com.octopus.ad.model.b$b$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f12610a;
            private String b;
            private g.i c;
            private g.EnumC0424g d;
            private long e;
            private String f;
            private String g;
            private String h;
            private String i;
            private String j;
            private long k;
            private long l;
            private ShakeValue n;
            private f.a o;
            private f.c p;
            private f.b q;
            private boolean m = true;
            private ArrayList<a> r = new ArrayList<>();

            public a a(String str) {
                this.f12610a = str;
                return this;
            }

            public a b(String str) {
                this.b = str;
                return this;
            }

            public a c(String str) {
                this.f = str;
                return this;
            }

            public a d(String str) {
                this.g = str;
                return this;
            }

            public a e(String str) {
                this.h = str;
                return this;
            }

            public a f(String str) {
                this.i = str;
                return this;
            }

            public a g(String str) {
                this.j = str;
                return this;
            }

            public a a(g.i iVar) {
                this.c = iVar;
                return this;
            }

            public a b(long j) {
                this.k = j;
                return this;
            }

            public a c(long j) {
                this.l = j;
                return this;
            }

            public a a(g.EnumC0424g enumC0424g) {
                this.d = enumC0424g;
                return this;
            }

            public a a(long j) {
                this.e = j;
                return this;
            }

            public a a(boolean z) {
                this.m = z;
                return this;
            }

            public a a(ShakeValue shakeValue) {
                this.n = shakeValue;
                return this;
            }

            public a a(f.a aVar) {
                this.o = aVar;
                return this;
            }

            public a a(f.c cVar) {
                this.p = cVar;
                return this;
            }

            public a a(f.b bVar) {
                this.q = bVar;
                return this;
            }

            public C0420b a() {
                C0420b c0420b = new C0420b();
                c0420b.f = this.f;
                c0420b.g = this.g;
                c0420b.o = this.o;
                c0420b.d = this.d;
                c0420b.k = this.k;
                c0420b.c = this.c;
                c0420b.e = this.e;
                c0420b.i = this.i;
                c0420b.j = this.j;
                c0420b.l = this.l;
                c0420b.m = this.m;
                c0420b.n = this.n;
                c0420b.p = this.p;
                c0420b.q = this.q;
                c0420b.r = this.r;
                c0420b.h = this.h;
                c0420b.f12609a = this.f12610a;
                c0420b.b = this.b;
                return c0420b;
            }

            public void a(a aVar) {
                this.r.add(aVar);
            }
        }

        public String toString() {
            return a();
        }

        private C0420b() {
        }

        private String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.f12609a);
                jSONObject.put("groupVersion", this.b);
                jSONObject.put("srcType", this.c);
                jSONObject.put("reqType", this.d);
                jSONObject.put("timeStamp", this.e);
                jSONObject.put("appid", this.f);
                jSONObject.put("reqid", this.g);
                jSONObject.put("appVersion", this.h);
                jSONObject.put("appName", this.i);
                jSONObject.put("packageName", this.j);
                jSONObject.put("appInstallTime", this.k);
                jSONObject.put("appUpdateTime", this.l);
                jSONObject.put("isCanShake", this.m ? 1 : 0);
                if (this.n != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("acceleration", this.n.getAcceleration());
                    jSONObject2.put("angle", this.n.getAngle());
                    jSONObject2.put("time", this.n.getTime());
                    jSONObject.put("shakeValue", jSONObject2);
                }
                f.a aVar = this.o;
                if (aVar != null) {
                    jSONObject.put("devInfo", aVar.a());
                }
                f.c cVar = this.p;
                if (cVar != null) {
                    jSONObject.put("envInfo", cVar.a());
                }
                f.b bVar = this.q;
                if (bVar != null) {
                    jSONObject.put("locInfo", bVar.a());
                }
                ArrayList<a> arrayList = this.r;
                if (arrayList != null && !arrayList.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.r.size(); i++) {
                        jSONArray.put(this.r.get(i).a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }
    }
}
