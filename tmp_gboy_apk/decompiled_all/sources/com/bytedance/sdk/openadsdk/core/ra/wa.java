package com.bytedance.sdk.openadsdk.core.ra;

import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class wa {
    private xj am;
    private int c;
    private int f;
    private int g;
    private String hf;
    private int kd;
    private hf p;

    /* renamed from: pl, reason: collision with root package name */
    private hf f10420pl;
    private int qt;
    private int u;
    private int xj;
    private int y;
    private boolean w = false;
    private String d = "#008DEA";
    private String tf = "点击查看";
    private float zg = 0.0f;
    private int e = 0;
    private int yo = 0;
    private int v = 55;
    private int jk = 0;
    private float pz = 0.0f;
    private int ht = 100;
    private int ra = 0;
    private int dk = 0;
    private int et = 0;

    public class hf {
        int xj;

        public hf(JSONObject jSONObject, int i) {
            this.xj = 14;
            if (jSONObject == null) {
                return;
            }
            this.xj = jSONObject.optInt("font_size", i);
        }

        public int hf() {
            return this.xj;
        }

        public JSONObject xj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.xj);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    public class xj {
        int hf;
        int u;
        int w;
        int xj;

        public xj(JSONObject jSONObject, int i) {
            this.xj = 30;
            this.hf = 30;
            this.w = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
            this.u = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.w = 40;
                    this.u = 20;
                    return;
                }
                return;
            }
            int optInt = jSONObject.optInt("left_margin", 30);
            this.xj = optInt;
            if (optInt < 0 || optInt > wa.this.x()) {
                this.xj = 30;
            }
            int optInt2 = jSONObject.optInt("right_margin", 30);
            this.hf = optInt2;
            if (optInt2 < 0 || optInt2 > wa.this.x()) {
                this.hf = 30;
            }
            if (i == 2) {
                int optInt3 = jSONObject.optInt("top_margin", 40);
                this.w = optInt3;
                if (optInt3 < 0 || optInt3 > wa.this.io()) {
                    this.w = 40;
                }
                int optInt4 = jSONObject.optInt("bottom_margin", 20);
                this.u = optInt4;
                if (optInt4 < 0 || optInt4 > wa.this.io()) {
                    this.u = 20;
                    return;
                }
                return;
            }
            int optInt5 = jSONObject.optInt("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
            this.w = optInt5;
            if (optInt5 < 0 || optInt5 > wa.this.io()) {
                this.w = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
            }
            int optInt6 = jSONObject.optInt("bottom_margin", 40);
            this.u = optInt6;
            if (optInt6 < 0 || optInt6 > wa.this.io()) {
                this.u = 40;
            }
        }

        public int hf() {
            return this.hf;
        }

        public JSONObject kd() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int u() {
            return this.u;
        }

        public int w() {
            return this.w;
        }

        public int xj() {
            return this.xj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int io() {
        return com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.a.r.kd(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        return com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    public xj am() {
        return this.am;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        if (this.u == 4 && !com.bytedance.sdk.openadsdk.core.f.zg().xj(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            this.u = 0;
        } else if (this.u == 7 && !com.bytedance.sdk.openadsdk.core.f.zg().hf(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            this.u = 0;
        }
        return this.u;
    }

    public int dk() {
        return this.et;
    }

    public int e() {
        return this.e;
    }

    public float et() {
        return this.pz;
    }

    public int f() {
        return this.qt;
    }

    public hf g() {
        return this.f10420pl;
    }

    public int ht() {
        return this.ra;
    }

    public int jk() {
        return this.jk;
    }

    public int kd() {
        return this.y;
    }

    public String p() {
        return this.tf;
    }

    public hf pl() {
        return this.p;
    }

    public int pz() {
        return this.ht;
    }

    public int qt() {
        return this.g;
    }

    public int ra() {
        return this.dk;
    }

    public String tf() {
        return this.d;
    }

    public int u() {
        return this.kd;
    }

    public int v() {
        return this.v;
    }

    public boolean w() {
        return this.w;
    }

    public int y() {
        return this.c;
    }

    public int yo() {
        return this.yo;
    }

    public float zg() {
        return this.zg;
    }

    public void am(int i) {
        this.ra = i;
    }

    public void c(int i) {
        this.u = i;
    }

    public void f(int i) {
        if (i <= 0 || i >= io()) {
            this.g = 5;
        } else {
            this.g = i;
        }
    }

    public void g(int i) {
        this.ht = i;
    }

    public String hf() {
        if (this.u == 4 && !com.bytedance.sdk.openadsdk.core.f.zg().xj(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            this.hf = "点击跳转至详情页或第三方应用";
        } else if (this.u == 7 && !com.bytedance.sdk.openadsdk.core.f.zg().hf(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            this.hf = "点击跳转至详情页或第三方应用";
        }
        return this.hf;
    }

    public void kd(int i) {
        this.f = i;
    }

    public void p(int i) {
        this.v = i;
    }

    public void pl(int i) {
        this.jk = i;
    }

    public void qt(int i) {
        this.dk = i;
    }

    public void tf(int i) {
        this.yo = i;
    }

    public void u(int i) {
        this.c = i;
    }

    public void w(int i) {
        this.y = i;
    }

    public int xj() {
        return this.xj;
    }

    public void y(int i) {
        this.qt = i;
    }

    public void zg(int i) {
        this.et = i;
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.u;
            if (i == 7) {
                this.tf = "扭动手机";
                return;
            } else if (i == 5) {
                this.tf = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.tf = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.tf = str;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            this.w = true;
            int i = this.u;
            if (i == 3) {
                this.hf = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.hf = "前往详情页或第三方应用";
                return;
            } else if (i != 5 && i != 7) {
                this.hf = "点击跳转至详情页或第三方应用";
                return;
            } else {
                this.hf = "前往详情页或第三方应用";
                return;
            }
        }
        this.hf = str;
    }

    public void d(int i) {
        this.e = i;
    }

    public void hf(int i) {
        this.kd = i;
    }

    public void hf(String str) {
        try {
            Color.parseColor(str);
            this.d = str;
        } catch (Throwable unused) {
            this.d = "#008DEA";
        }
    }

    public void hf(JSONObject jSONObject) {
        this.f10420pl = new hf(jSONObject, 20);
    }

    public void hf(float f) {
        this.pz = f;
    }

    public void xj(JSONObject jSONObject) {
        this.p = new hf(jSONObject, 14);
    }

    public void xj(JSONObject jSONObject, int i) {
        this.am = new xj(jSONObject, i);
    }

    public void xj(float f) {
        this.zg = f;
    }
}
