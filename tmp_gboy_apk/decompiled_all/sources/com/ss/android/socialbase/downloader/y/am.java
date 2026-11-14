package com.ss.android.socialbase.downloader.y;

import com.fl.saas.videocache.ProxyCacheUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class am {
    private int hf;
    private final JSONObject xj;

    private am(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    private int zg() {
        return this.xj.optInt("url_balance", 2);
    }

    public int am() {
        return this.xj.optInt("ratio_segment", 0);
    }

    public long c() {
        long optInt = this.xj.optInt("segment_min_kb", 512) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public long d() {
        long optInt = this.xj.optInt("segment_max_kb", 0) * BaseConstants.MB_VALUE;
        if (optInt < c()) {
            return -1L;
        }
        return optInt;
    }

    public long f() {
        long optInt = this.xj.optInt("segment_min_init_mb", 10) * BaseConstants.MB_VALUE;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public float g() {
        return (float) this.xj.optDouble("main_ratio", 0.0d);
    }

    public boolean hf() {
        return zg() > 0;
    }

    public int kd() {
        return this.xj.optInt("buffer_size", ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
    }

    public long p() {
        long optInt = this.xj.optInt("read_timeout", -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1L;
    }

    public int pl() {
        return this.xj.optInt("ip_strategy", 0);
    }

    public float qt() {
        return Math.min(Math.max(0.0f, (float) this.xj.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public long tf() {
        long optInt = this.xj.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public int u() {
        return this.xj.optInt("buffer_count", 512);
    }

    public boolean w() {
        return zg() == 1;
    }

    public void xj(int i) {
        this.hf = hf(i);
    }

    public boolean y() {
        return this.xj.optInt("segment_mode", 1) == 0;
    }

    private int hf(int i) {
        int optInt = this.xj.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return zg() == 1 ? Math.min(optInt, i) : optInt;
        }
        if (zg() > 0) {
            return i;
        }
        return 1;
    }

    public int xj() {
        return this.hf;
    }

    public static am xj(JSONObject jSONObject) {
        return new am(jSONObject);
    }
}
