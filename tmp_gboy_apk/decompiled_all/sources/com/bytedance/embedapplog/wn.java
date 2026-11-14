package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class wn {
    private volatile JSONObject c;
    private final f hf;
    private final SharedPreferences kd;
    private final SharedPreferences u;
    private final SharedPreferences w;
    private final Context xj;
    private volatile JSONObject y;

    public wn(Context context, f fVar) {
        this.xj = context;
        this.hf = fVar;
        this.kd = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "embed_applog_stats", 0);
        this.w = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "embed_header_custom", 0);
        this.u = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "embed_last_sp_session", 0);
    }

    public String a() {
        return this.hf.v();
    }

    public String ai() {
        return this.kd.getString("user_agent", null);
    }

    public String am() {
        return this.hf.c();
    }

    public String b() {
        return this.hf.ra();
    }

    public JSONObject c() {
        return this.c;
    }

    public int d() {
        return this.kd.getInt("bav_monitor_rate", 0);
    }

    public long dk() {
        return this.kd.getLong("session_interval", 30000L);
    }

    public String e() {
        return this.w.getString("user_unique_id", null);
    }

    public int en() {
        return this.hf.e();
    }

    public long et() {
        return this.kd.getLong("batch_event_interval", 30000L);
    }

    public String eu() {
        return this.hf.j() == null ? "" : this.hf.j();
    }

    public long f() {
        return this.kd.getLong("app_log_last_config_time", 0L);
    }

    public String ff() {
        return this.hf.am();
    }

    public String g() {
        return this.hf.y();
    }

    public String hf() {
        return this.hf.f();
    }

    public f hl() {
        return this.hf;
    }

    public boolean ht() {
        return this.kd.getBoolean("bav_ab_config", false);
    }

    public String io() {
        return null;
    }

    public int j() {
        return this.hf.zg();
    }

    public String jk() {
        return !TextUtils.isEmpty(this.hf.jk()) ? this.hf.jk() : this.w.getString("ab_version", null);
    }

    public SharedPreferences kd() {
        return this.kd;
    }

    public String l() {
        return this.hf.g();
    }

    public boolean n() {
        return this.hf.x();
    }

    public String p() {
        return this.hf.u();
    }

    public String pl() {
        return this.hf.kd();
    }

    public JSONObject pz() {
        JSONObject jSONObject = this.y;
        if (jSONObject != null) {
            return jSONObject;
        }
        synchronized (this) {
            try {
                if (ht()) {
                    jSONObject = new JSONObject(this.w.getString("ab_configure", ""));
                }
            } catch (JSONException unused) {
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.y = jSONObject;
        }
        return jSONObject;
    }

    public String q() {
        return this.hf.pl();
    }

    public String qt() {
        return this.w.getString("header_custom_info", null);
    }

    public String r() {
        return this.hf.ht();
    }

    public boolean ra() {
        return this.kd.getBoolean("bav_log_collect", false);
    }

    public String tf() {
        return this.hf.w();
    }

    public boolean tj() {
        return this.hf.io();
    }

    public int u() {
        return this.u.getInt("session_order", 0);
    }

    public long v() {
        return this.kd.getLong("abtest_fetch_interval", 0L);
    }

    public CharSequence vm() {
        return this.hf.dk();
    }

    public String w() {
        return this.u.getString("session_last_day", "");
    }

    public String wo() {
        return this.hf.pz();
    }

    public String ws() {
        return this.hf.z() == null ? "" : this.hf.z();
    }

    public String x() {
        return this.hf.xj();
    }

    public boolean xj(ArrayList<vl> arrayList) {
        return true;
    }

    public boolean y() {
        return this.hf.hf();
    }

    public boolean yo() {
        if (this.hf.d() == 0) {
            String xj = no.xj(this.xj);
            if (TextUtils.isEmpty(xj)) {
                this.hf.xj(0);
            } else {
                this.hf.xj(xj.contains(":") ? 2 : 1);
            }
        }
        return this.hf.d() == 1;
    }

    public String yy() {
        return this.hf.q();
    }

    public int z() {
        return this.hf.qt();
    }

    public String zg() {
        return this.w.getString("ab_sdk_version", "");
    }

    public static String xj() {
        return "embed_applog_stats";
    }

    public void hf(JSONObject jSONObject) {
        this.w.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public void w(JSONObject jSONObject) {
        cu.xj("setAbConfig, " + jSONObject.toString(), null);
        this.w.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.y = null;
    }

    public void xj(String str, int i) {
        this.u.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public void xj(JSONObject jSONObject) {
        if (cu.hf) {
            cu.xj("setConfig, " + jSONObject.toString(), null);
        }
        this.c = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.kd.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= 604800) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        } else {
            edit.remove("abtest_fetch_interval");
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        cu.xj = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 > 0 && optInt5 <= 100) {
            edit.putInt("bav_monitor_rate", optInt5);
            my.xj(true);
        } else {
            edit.remove("bav_monitor_rate");
            my.xj(false);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }
}
