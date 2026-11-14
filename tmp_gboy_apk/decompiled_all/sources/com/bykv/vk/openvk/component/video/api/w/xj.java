package com.bykv.vk.openvk.component.video.api.w;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private int f;
    private String hf;
    private String xj;
    private long w = -2147483648L;
    private int u = Integer.MIN_VALUE;
    private long kd = -2147483648L;
    private double y = -2.147483648E9d;
    private double c = -2.147483648E9d;

    public int c() {
        return this.f;
    }

    public String hf() {
        return this.xj;
    }

    public String kd() {
        return this.hf;
    }

    public double u() {
        return this.c;
    }

    public long w() {
        return this.w;
    }

    public JSONObject xj() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.hf)) {
                jSONObject.putOpt("audio_url", this.hf);
            }
            if (!TextUtils.isEmpty(this.xj)) {
                jSONObject.putOpt("file_hash", this.xj);
            }
            long j = this.w;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.u;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.kd;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.y;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.c;
            if (d2 > 0.0d) {
                jSONObject.put("start", d2);
            }
            int i2 = this.f;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public double y() {
        return this.y;
    }

    public void hf(long j) {
        this.kd = j;
    }

    public void hf(String str) {
        this.hf = str;
    }

    public void hf(double d) {
        this.y = d;
    }

    public void hf(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f = i;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void xj(long j) {
        this.w = j;
    }

    public void xj(int i) {
        this.u = i;
    }

    public void xj(double d) {
        this.c = d;
    }
}
