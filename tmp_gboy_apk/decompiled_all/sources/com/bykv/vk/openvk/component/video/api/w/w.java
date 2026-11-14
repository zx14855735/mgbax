package com.bykv.vk.openvk.component.video.api.w;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private String c;
    private String d;
    private String f;
    private int g;
    private int hf;
    private String kd;
    private double p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10024pl;
    private String tf;
    private double u;
    private long w;
    private int xj;
    private String y;
    private float am = -1.0f;
    private int qt = 0;
    private int zg = 0;
    private int e = 0;
    private int yo = 0;
    private int v = 307200;
    private int jk = 1;

    public String am() {
        return this.d;
    }

    public double c() {
        return this.p;
    }

    public String d() {
        return this.kd;
    }

    public int dk() {
        return this.jk;
    }

    public int e() {
        return this.e;
    }

    public float f() {
        return this.am;
    }

    public String g() {
        return this.f;
    }

    public int hf() {
        return this.xj;
    }

    public boolean ht() {
        return this.yo == 1;
    }

    public int jk() {
        return this.qt;
    }

    public long kd() {
        return this.w;
    }

    public String p() {
        return this.y;
    }

    public String pl() {
        return this.c;
    }

    public int pz() {
        return this.zg;
    }

    public String qt() {
        if (TextUtils.isEmpty(this.tf)) {
            this.tf = com.bykv.vk.openvk.component.video.api.y.hf.xj(this.c);
        }
        return this.tf;
    }

    public boolean ra() {
        return this.e == 0;
    }

    public int[] tf() {
        try {
            int indexOf = this.kd.indexOf("x");
            return new int[]{Integer.parseInt(this.kd.substring(0, indexOf).trim()), Integer.parseInt(this.kd.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public int u() {
        return this.g;
    }

    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", hf());
            jSONObject.put("cover_url", p());
            jSONObject.put("cover_width", w());
            jSONObject.put("endcard", g());
            jSONObject.put("file_hash", qt());
            jSONObject.put("resolution", d());
            jSONObject.put("size", kd());
            jSONObject.put("video_duration", y());
            jSONObject.put("video_url", pl());
            jSONObject.put("playable_download_url", am());
            jSONObject.put("if_playable_loading_show", jk());
            jSONObject.put("remove_loading_page_type", pz());
            jSONObject.put("fallback_endcard_judge", xj());
            jSONObject.put("video_preload_size", zg());
            jSONObject.put("reward_video_cached_type", e());
            jSONObject.put("execute_cached_type", yo());
            jSONObject.put("endcard_render", u());
            jSONObject.put("replay_time", dk());
            jSONObject.put("play_speed_ratio", f());
            if (c() > 0.0d) {
                jSONObject.put("start", c());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int w() {
        return this.hf;
    }

    public int xj() {
        return this.f10024pl;
    }

    public double y() {
        return this.u;
    }

    public int yo() {
        return this.yo;
    }

    public int zg() {
        if (this.v < 0) {
            this.v = 307200;
        }
        long j = this.v;
        long j2 = this.w;
        if (j > j2) {
            this.v = (int) j2;
        }
        return this.v;
    }

    public void hf(int i) {
        this.xj = i;
    }

    public void kd(String str) {
        this.tf = str;
    }

    public void u(String str) {
        this.f = str;
    }

    public void w(int i) {
        this.hf = i;
    }

    public void xj(int i) {
        this.f10024pl = i;
    }

    public void y(int i) {
        this.yo = i;
    }

    public void hf(double d) {
        this.p = d;
    }

    public void kd(int i) {
        this.e = i;
    }

    public void u(int i) {
        this.v = i;
    }

    public void w(String str) {
        this.c = str;
    }

    public void xj(long j) {
        this.w = j;
    }

    public void hf(String str) {
        this.y = str;
    }

    public void xj(double d) {
        this.u = d;
    }

    public void xj(float f) {
        this.am = f;
    }

    public void xj(String str) {
        this.kd = str;
    }
}
