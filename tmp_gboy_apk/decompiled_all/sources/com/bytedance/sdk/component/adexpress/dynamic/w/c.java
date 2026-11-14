package com.bytedance.sdk.component.adexpress.dynamic.w;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private String c;
    public String hf;
    private y kd;
    public JSONObject u;
    public String w;
    public int xj;
    private kd y;

    public c(kd kdVar) {
        this.y = kdVar;
        this.xj = kdVar.xj();
        this.hf = kdVar.hf();
        this.w = kdVar.w();
        this.u = kdVar.kd().nb();
        this.c = kdVar.u();
        if (com.bytedance.sdk.component.adexpress.u.hf() == 1) {
            this.kd = kdVar.c();
        } else {
            this.kd = kdVar.kd();
        }
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            this.kd = kdVar.kd();
        }
    }

    private boolean k() {
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.hf) && this.hf.contains("adx:")) || p.hf();
    }

    private boolean t() {
        return (com.bytedance.sdk.component.adexpress.u.xj() && (this.y.getType().contains("logo-union") || this.y.getType().contains("logounion") || this.y.getType().contains("logoad"))) || "logo-union".equals(this.y.getType()) || "logounion".equals(this.y.getType()) || "logoad".equals(this.y.getType());
    }

    public String a() {
        return this.kd.tf();
    }

    public int ai() {
        return xj(this.kd.ra());
    }

    public double am() {
        return this.kd.v();
    }

    public String aq() {
        return this.kd.q();
    }

    public int b() {
        return this.kd.xv();
    }

    public String bl() {
        return this.kd.z();
    }

    public int c() {
        return xj(this.kd.ht());
    }

    public int cy() {
        return this.kd.i();
    }

    public int d() {
        int f = f();
        if (f == 4) {
            return 17;
        }
        return f == 3 ? 8388613 : 8388611;
    }

    public int dc() {
        return this.kd.k();
    }

    public String dk() {
        return this.kd.r();
    }

    public boolean dq() {
        return this.kd.g();
    }

    public float e() {
        return this.kd.pl();
    }

    public int en() {
        return this.kd.kd();
    }

    public String et() {
        return this.kd.jw();
    }

    public String eu() {
        return this.kd.wo();
    }

    public int f() {
        String pz = this.kd.pz();
        if ("left".equals(pz)) {
            return 17;
        }
        if ("center".equals(pz)) {
            return 4;
        }
        return "right".equals(pz) ? 3 : 2;
    }

    public int ff() {
        return this.kd.d();
    }

    public List<String> ft() {
        return this.kd.ir();
    }

    public double g() {
        if (this.xj == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.u.xj() ? (int) r0 : Double.parseDouble(this.hf);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double gh() {
        return this.kd.ff();
    }

    public boolean gj() {
        return this.kd.zb();
    }

    public int gy() {
        return this.kd.vi();
    }

    public boolean h() {
        return this.kd.my();
    }

    public int hf() {
        return (int) this.kd.e();
    }

    public int hl() {
        return this.kd.ey();
    }

    public boolean ht() {
        return this.kd.tj();
    }

    public long io() {
        return this.kd.db();
    }

    public int j() {
        return this.kd.hf();
    }

    public boolean jk() {
        return this.kd.mg();
    }

    public float kd() {
        return this.kd.yo();
    }

    public int l() {
        return this.kd.u();
    }

    public int lw() {
        return this.kd.en();
    }

    public int n() {
        return this.kd.c();
    }

    public String nb() {
        return this.kd.vw();
    }

    public String ne() {
        return this.kd.et();
    }

    public double op() {
        return this.kd.a();
    }

    public String p() {
        int i = this.xj;
        return (i == 1 || i == 29) ? this.hf : "";
    }

    public String pl() {
        return this.c;
    }

    public String pz() {
        return this.kd.dk();
    }

    public double q() {
        return this.kd.f();
    }

    public boolean qd() {
        return this.kd.j();
    }

    public float qt() {
        return this.kd.p();
    }

    public boolean r() {
        return this.kd.gj();
    }

    public int ra() {
        return this.kd.n();
    }

    public boolean rg() {
        return this.kd.lx();
    }

    public String s() {
        return this.kd.nt();
    }

    public String se() {
        return this.xj == 29 ? this.w : "";
    }

    public String ss() {
        return this.kd.da();
    }

    public String tf() {
        int i = this.xj;
        return (i == 2 || i == 13) ? this.hf : "";
    }

    public boolean tj() {
        return this.kd.ua();
    }

    public String tu() {
        return this.kd.lm();
    }

    public int u() {
        return (int) this.kd.zg();
    }

    public int v() {
        return this.kd.ut();
    }

    public int vl() {
        return this.kd.le();
    }

    public int vm() {
        return this.kd.si();
    }

    public int w() {
        return (int) this.kd.qt();
    }

    public int wa() {
        return this.kd.l();
    }

    public boolean wn() {
        return this.kd.my();
    }

    public String wo() {
        return this.kd.b();
    }

    public int ws() {
        return this.kd.cy();
    }

    public int x() {
        String r = this.kd.r();
        if ("skip-with-time-skip-btn".equals(this.y.getType()) || "skip".equals(this.y.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.y.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.y.getType()) && !"skip-with-time".equals(this.y.getType())) {
            if (this.xj == 10 && TextUtils.equals(this.kd.b(), "click")) {
                return 5;
            }
            if (t() && k()) {
                return 0;
            }
            if (t()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.y.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(r) && !r.equals("none")) {
                if (r.equals("video") || (this.y.xj() == 7 && TextUtils.equals(r, PrerollVideoResponse.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.u.xj() && this.y.kd() != null && this.y.kd().zm()) ? 11 : 4;
                }
                if (r.equals(PrerollVideoResponse.NORMAL)) {
                    return 1;
                }
                return (r.equals("creative") || "slide".equals(this.kd.b())) ? 2 : 0;
            }
        }
        return 0;
    }

    public int xj() {
        return (int) this.kd.am();
    }

    public int xv() {
        return this.kd.oa();
    }

    public String y() {
        return this.xj == 0 ? !TextUtils.isEmpty(this.hf) ? this.hf : this.u.optString(com.bytedance.sdk.component.adexpress.u.f.u(com.bytedance.sdk.component.adexpress.u.getContext())) : "";
    }

    public int yo() {
        return this.kd.zd();
    }

    public int yy() {
        return this.kd.kc();
    }

    public int z() {
        return this.kd.w();
    }

    public int zg() {
        return xj(this.kd.io());
    }

    public static float[] hf(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (split == null || split.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public void xj(float f) {
        this.kd.xj(f);
    }

    public static int xj(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return com.sigmob.sdk.base.blurkit.d.f13043a;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (split.length == 4) {
                    return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return com.sigmob.sdk.base.blurkit.d.f13043a;
    }

    public boolean xj(int i) {
        kd kdVar = this.y;
        if (kdVar == null) {
            return false;
        }
        if (i == 1) {
            this.kd = kdVar.c();
        } else {
            this.kd = kdVar.kd();
        }
        return this.kd != null;
    }
}
