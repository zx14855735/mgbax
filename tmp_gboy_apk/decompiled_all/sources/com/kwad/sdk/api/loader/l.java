package com.kwad.sdk.api.loader;

import ADYaiT.CtFAbx;
import com.kwad.sdk.api.loader.a;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class l {
    public static int ayz;

    public static class a {
        private int ayA;
        private int ayB;
        private String ayC;
        private String ayD;
        private long ayE;
        private int ayF;
        private String ayG;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ap(long j) {
            this.ayE = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cE(String str) {
            this.ayC = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cF(String str) {
            this.ayD = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cG(String str) {
            this.ayG = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cI(int i) {
            this.ayA = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cJ(int i) {
            this.ayB = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cK(int i) {
            this.ayF = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.ayA));
                jSONObject.putOpt("update_count", Integer.valueOf(this.ayB));
                jSONObject.putOpt("dynamic_version", this.ayC);
                jSONObject.putOpt("download_url", this.ayD);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.ayE));
                jSONObject.putOpt("error_code", Integer.valueOf(this.ayF));
                jSONObject.putOpt("error_msg", this.ayG);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MonitorInfo{load_status=");
            sb.append(this.ayA);
            sb.append(", update_count=");
            sb.append(this.ayB);
            sb.append(", dynamic_version='");
            sb.append(this.ayC);
            sb.append("', download_url='");
            sb.append(this.ayD);
            sb.append("', duration_ms=");
            sb.append(this.ayE);
            sb.append(", error_code=");
            sb.append(this.ayF);
            sb.append(", error_msg='");
            return CtFAbx.B25kr6(sb, this.ayG, "'}");
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void a(a.C0346a c0346a) {
        ayz++;
        a(1, c0346a, 0L, 0, "");
    }

    public static void b(a.C0346a c0346a) {
        a(5, c0346a, 0L, 0, "");
    }

    public static void b(a.C0346a c0346a, long j) {
        a(6, c0346a, j, 0, "");
    }

    public static void a(a.C0346a c0346a, long j) {
        a(2, c0346a, j, 0, "");
    }

    public static void b(a.C0346a c0346a, int i, String str) {
        a(7, c0346a, 0L, i, str);
    }

    public static void a(a.C0346a c0346a, long j, String str) {
        a(3, c0346a, j, 0, str);
    }

    public static void a(a.C0346a c0346a, int i, String str) {
        a(4, c0346a, 0L, i, str);
    }

    private static void a(int i, a.C0346a c0346a, long j, int i2, String str) {
        byte b = 0;
        if (c0346a == null) {
            return;
        }
        try {
            JSONObject json = new a(b).cI(i).cJ(ayz).cE(c0346a.sdkVersion).cF(c0346a.axP).ap(j).cK(i2).cG(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
