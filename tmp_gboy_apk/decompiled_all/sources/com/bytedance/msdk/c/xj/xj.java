package com.bytedance.msdk.c.xj;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.core.kd.hf.u;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;
    private int w = -1;
    private long u = -1;
    private int kd = -1;
    private int y = -1;
    private int c = -1;
    private int f = -1;
    private int d = -1;
    private int tf = -1;
    private ai hf = com.bytedance.msdk.c.xj.hf();

    private xj() {
    }

    private synchronized void hf(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("event_batch_size", 100);
            this.w = optInt;
            if (optInt <= 0 || optInt > 1000) {
                this.w = 100;
            }
            long optLong = jSONObject.optLong("event_routine_interval", 120000L);
            this.u = optLong;
            if (optLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || optLong > 300000) {
                this.u = 120000L;
            }
            int optInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
            this.kd = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.kd = 0;
            }
            this.c = jSONObject.optInt("rv_start_time", 5000);
            int optInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
            this.y = optInt3;
            if (optInt3 != 0 && optInt3 != 1) {
                this.y = 0;
            }
            u.xj().xj(jSONObject.optInt("pre_fetch_count", 20));
            this.f = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
            this.d = jSONObject.optInt("can_log", -1);
            this.tf = jSONObject.optInt("enable_abtest_id", 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized JSONObject p() {
        try {
            String hf = this.hf.hf("app_common_config");
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            if (!hf.startsWith("[") && !hf.startsWith("{")) {
                hf = com.bytedance.msdk.f.xj.hf(hf, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf)) {
                try {
                    return new JSONObject(hf);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public synchronized boolean c() {
        JSONObject p;
        int i = this.f;
        if (i != -1) {
            return i == 1;
        }
        if (this.hf == null || (p = p()) == null) {
            return false;
        }
        hf(p);
        return this.f == 1;
    }

    public boolean d() {
        JSONObject p;
        int i = this.d;
        if (i != -1) {
            return i == 1;
        }
        if (this.hf != null && (p = p()) != null) {
            hf(p);
            if (this.d == 1) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f;
    }

    public int kd() {
        JSONObject p;
        int i = this.y;
        if (i != -1) {
            return i;
        }
        if (this.hf == null || (p = p()) == null) {
            return 0;
        }
        hf(p);
        return this.y;
    }

    public int tf() {
        JSONObject p;
        int i = this.tf;
        if (i != -1) {
            return i;
        }
        if (this.hf == null || (p = p()) == null) {
            return 0;
        }
        hf(p);
        return this.tf;
    }

    public int u() {
        JSONObject p;
        int i = this.kd;
        if (i != -1) {
            return i;
        }
        if (this.hf == null || (p = p()) == null) {
            return 0;
        }
        hf(p);
        return this.kd;
    }

    public synchronized long w() {
        JSONObject p;
        long j = this.u;
        if (j != -1) {
            return j;
        }
        if (this.hf == null || (p = p()) == null) {
            return 120000L;
        }
        hf(p);
        return this.u;
    }

    public int y() {
        JSONObject p;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        if (this.hf == null || (p = p()) == null) {
            return 5000;
        }
        hf(p);
        return this.c;
    }

    public synchronized void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            hf(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.hf.xj("app_common_config", jSONObject2);
            }
        }
    }

    public synchronized int hf() {
        JSONObject p;
        int i = this.w;
        if (i != -1) {
            return i;
        }
        if (this.hf == null || (p = p()) == null) {
            return 100;
        }
        hf(p);
        return this.w;
    }
}
