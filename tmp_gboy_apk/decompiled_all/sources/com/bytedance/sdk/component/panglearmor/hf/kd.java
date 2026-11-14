package com.bytedance.sdk.component.panglearmor.hf;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static kd xj;
    private boolean hf = false;
    private long w = 180000;
    private long u = 43200000;
    private long kd = 3;
    private long y = 30;
    private long c = 15;

    private kd() {
    }

    public static kd xj() {
        if (xj == null) {
            synchronized (kd.class) {
                try {
                    if (xj == null) {
                        xj = new kd();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public long c() {
        return this.c;
    }

    public boolean hf() {
        return this.hf;
    }

    public long kd() {
        return this.kd;
    }

    public long u() {
        return this.w;
    }

    public long w() {
        return this.u;
    }

    public long y() {
        return this.y;
    }

    public synchronized void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.hf = jSONObject.optBoolean("sensorenable", false);
                this.w = jSONObject.optLong("interval", 180000L);
                this.u = jSONObject.optLong("expireduation", 43200000L);
                this.kd = jSONObject.optLong("showinterval", 3L);
                this.y = jSONObject.optLong("azimuth_unit", 30L);
                this.c = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }
}
