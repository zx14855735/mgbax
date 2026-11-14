package com.bytedance.sdk.openadsdk.core.ra;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.core.hf.u;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private final float am;
    private final float c;
    private final long d;
    private int dk;
    private final int e;
    private String et;
    private final float f;
    private final int g;
    private final int[] hf;
    private SparseArray<u.xj> ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10397io;
    private final String jk;
    private final float kd;
    private final int p;

    /* renamed from: pl, reason: collision with root package name */
    private final int f10398pl;
    private final String pz;
    private final int qt;
    private int ra;
    private final long tf;
    private final int[] u;
    private final String v;
    private final int[] w;
    private final boolean x;
    private final int[] xj;
    private final float y;
    private final String yo;
    private final float zg;

    public static class xj {
        private SparseArray<u.xj> e;
        private String et;
        private int[] g;
        int hf;
        private String ht;
        private String jk;
        private int[] p;

        /* renamed from: pl, reason: collision with root package name */
        private int[] f10400pl;
        private String pz;
        private int[] tf;
        private String v;
        float w;
        float xj;
        private int yo;
        private long u = -1;
        private long kd = -1;
        private float y = -1.0f;
        private float c = -1.0f;
        private float f = -1.0f;
        private float d = -1.0f;
        private int am = -1;
        private int qt = -1;
        private int zg = -1024;
        private int ra = -1;
        private int dk = -1;

        /* renamed from: io, reason: collision with root package name */
        private int f10399io = -1;
        private boolean x = false;

        public xj c(int i) {
            this.dk = i;
            return this;
        }

        public xj f(int i) {
            this.f10399io = i;
            return this;
        }

        public xj hf(float f) {
            this.w = f;
            return this;
        }

        public xj kd(float f) {
            this.f = f;
            return this;
        }

        public xj u(float f) {
            this.c = f;
            return this;
        }

        public xj w(float f) {
            this.y = f;
            return this;
        }

        public xj xj(float f) {
            this.xj = f;
            return this;
        }

        public xj y(float f) {
            this.d = f;
            return this;
        }

        public xj hf(int i) {
            this.yo = i;
            return this;
        }

        public xj kd(int i) {
            this.zg = i;
            return this;
        }

        public xj u(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public xj w(int[] iArr) {
            this.f10400pl = iArr;
            return this;
        }

        public xj xj(int i) {
            this.hf = i;
            return this;
        }

        public xj y(int i) {
            this.ra = i;
            return this;
        }

        public xj hf(long j) {
            this.kd = j;
            return this;
        }

        public xj kd(String str) {
            this.et = str;
            return this;
        }

        public xj u(int i) {
            this.qt = i;
            return this;
        }

        public xj w(int i) {
            this.am = i;
            return this;
        }

        public xj xj(SparseArray<u.xj> sparseArray) {
            this.e = sparseArray;
            return this;
        }

        public xj hf(int[] iArr) {
            this.p = iArr;
            return this;
        }

        public xj u(String str) {
            this.ht = str;
            return this;
        }

        public xj w(String str) {
            this.pz = str;
            return this;
        }

        public xj xj(long j) {
            this.u = j;
            return this;
        }

        public xj hf(String str) {
            this.jk = str;
            return this;
        }

        public xj xj(int[] iArr) {
            this.tf = iArr;
            return this;
        }

        public xj xj(String str) {
            this.v = str;
            return this;
        }

        public xj xj(boolean z) {
            this.x = z;
            return this;
        }

        public d xj() {
            return new d(this);
        }
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.xj;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.xj[1]));
            }
            int[] iArr2 = this.hf;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt(MediaFormat.KEY_WIDTH, Integer.valueOf(iArr2[0])).putOpt(MediaFormat.KEY_HEIGHT, Integer.valueOf(this.hf[1]));
            }
            int[] iArr3 = this.w;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.w[1]));
            }
            int[] iArr4 = this.u;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.u[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.ht != null) {
                for (int i = 0; i < this.ht.size(); i++) {
                    u.xj valueAt = this.ht.valueAt(i);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.w)).putOpt("mr", Double.valueOf(valueAt.hf)).putOpt("phase", Integer.valueOf(valueAt.xj)).putOpt("ts", Long.valueOf(valueAt.u));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.e)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.kd)).putOpt("down_y", Float.toString(this.y)).putOpt("up_x", Float.toString(this.c)).putOpt("up_y", Float.toString(this.f)).putOpt("down_time", Long.valueOf(this.d)).putOpt("up_time", Long.valueOf(this.tf)).putOpt("toolType", Integer.valueOf(this.p)).putOpt("deviceId", Integer.valueOf(this.f10398pl)).putOpt(com.sigmob.sdk.base.n.l, Integer.valueOf(this.g)).putOpt("density", Float.valueOf(this.am)).putOpt("densityDpi", Integer.valueOf(this.qt)).putOpt("scaleDensity", Float.valueOf(this.zg)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.yo).putOpt("areaType", this.v).putOpt("rectInfo", this.pz).putOpt("click_area_id", this.jk);
            int i2 = this.ra;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.dk;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.f10397io;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.et);
            }
            if (this.x) {
                jSONObject.put("referer", "directDownload");
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private d(xj xjVar) {
        this.dk = -1;
        this.f10397io = -1;
        this.xj = xjVar.p;
        this.hf = xjVar.f10400pl;
        this.u = xjVar.g;
        this.w = xjVar.tf;
        this.kd = xjVar.d;
        this.y = xjVar.f;
        this.c = xjVar.c;
        this.f = xjVar.y;
        this.d = xjVar.kd;
        this.tf = xjVar.u;
        this.p = xjVar.am;
        this.f10398pl = xjVar.qt;
        this.g = xjVar.zg;
        this.am = xjVar.xj;
        this.yo = xjVar.v;
        this.v = xjVar.jk;
        this.pz = xjVar.ht;
        this.jk = xjVar.pz;
        this.qt = xjVar.hf;
        this.zg = xjVar.w;
        this.e = xjVar.yo;
        this.ht = xjVar.e;
        this.ra = xjVar.ra;
        this.dk = xjVar.dk;
        this.et = xjVar.et;
        this.f10397io = xjVar.f10399io;
        this.x = xjVar.x;
    }
}
