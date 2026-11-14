package com.bytedance.sdk.openadsdk.core.w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private volatile String ai;
    private volatile String am;
    protected volatile String c;
    protected volatile String d;
    private volatile String dk;
    private volatile String e;
    private volatile JSONArray et;
    protected volatile String f;
    private volatile String g;
    protected volatile String hf;
    private volatile String ht;

    /* renamed from: io, reason: collision with root package name */
    private volatile String f10457io;
    protected volatile String kd;
    private volatile String pz;
    private volatile String ra;
    protected volatile String tf;
    protected volatile String u;
    protected volatile String w;
    private volatile String x;
    protected volatile String xj;
    protected volatile String y;
    private volatile String yo;
    private volatile String z;

    /* renamed from: pl, reason: collision with root package name */
    private volatile int f10458pl = -1;
    private volatile int qt = -1;
    private volatile int zg = -1;
    private volatile int v = -1;
    private volatile int jk = -1;
    private volatile int q = -1;
    private volatile SharedPreferences p = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sp_exec_getad_config", 0);

    public static class xj {
        private static u xj = new u();

        static {
            xehX();
        }

        private static /* synthetic */ void xehX() {
            char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 166);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 166);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private void dk() {
        try {
            this.ra = com.bytedance.sdk.openadsdk.core.y.xj().kd();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7132);
            jSONObject.put("log_version", this.ra);
            hf("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public static u xj() {
        return xj.xj;
    }

    public String am() {
        if (this.d == null) {
            this.d = w("dev09", (String) null);
        }
        return this.d;
    }

    public boolean c(int i) {
        return i == 3 || i == 4;
    }

    public void d(String str) {
        if (str == null || !str.equals(this.ht)) {
            this.ht = str;
            hf("extra_internal_data", str);
        }
    }

    public JSONArray e() {
        String w;
        if (this.et == null && (w = w("dev12", (String) null)) != null) {
            try {
                this.et = new JSONArray(w);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return this.et;
    }

    public String f(String str) {
        if (this.pz == null) {
            this.pz = w("extra_data", str);
        }
        return this.pz;
    }

    public String g() {
        if (this.f == null) {
            this.f = w("dev18", (String) null);
        }
        return this.f;
    }

    public SharedPreferences hf() {
        return this.p;
    }

    public String ht() {
        if (this.z == null) {
            this.z = w("spl_strategy", "");
        }
        return this.z;
    }

    public int jk() {
        return hf("sp_device_app_direction", -1);
    }

    public String kd() {
        if (this.am == null) {
            this.am = w("app_name", "");
        }
        return this.am;
    }

    public String p(String str) {
        if (this.xj == null) {
            this.xj = w("dev01", str);
        }
        return this.xj;
    }

    public String pl() {
        if (this.c == null) {
            this.c = w("dev17", (String) null);
        }
        return this.c;
    }

    public String pz() {
        if (this.ai == null) {
            this.ai = w("dev16", "");
        }
        return this.ai;
    }

    public String qt() {
        if (this.dk == null) {
            this.dk = w("dev10", (String) null);
        }
        return this.dk;
    }

    public void ra() {
        try {
            SharedPreferences.Editor edit = hf().edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public String tf(String str) {
        if (this.ht == null) {
            this.ht = w("extra_internal_data", str);
        }
        return this.ht;
    }

    public String u() {
        if (this.g == null) {
            this.g = w(PluginConstants.KEY_APP_ID, "");
        }
        return this.g;
    }

    public String v() {
        if (this.x == null) {
            this.x = w("dev15", (String) null);
        }
        return this.x;
    }

    public int w() {
        if (this.f10458pl == -1) {
            this.f10458pl = hf("live_ad_clk_cnt", 0);
        }
        return this.f10458pl;
    }

    public String y(String str) {
        if (this.yo == null) {
            this.yo = w("keywords", str);
        }
        return this.yo;
    }

    public String yo() {
        if (this.f10457io == null) {
            this.f10457io = w("dev13", (String) null);
        }
        return this.f10457io;
    }

    public String zg() {
        if (this.tf == null) {
            this.tf = w("dev11", (String) null);
        }
        return this.tf;
    }

    public void c(String str) {
        if (str == null || !str.equals(this.pz)) {
            this.pz = str;
            hf("extra_data", str);
        }
    }

    public void hf(String str) {
        if (str == null || !str.equals(this.am)) {
            this.am = str;
            hf("app_name", str);
        }
    }

    public void xj(int i) {
        if (this.f10458pl == i) {
            return;
        }
        this.f10458pl = i;
        xj("live_ad_clk_cnt", i);
    }

    public static class hf {
        private Map<String, Object> xj = new HashMap();

        public hf c(String str) {
            if (str == null || str.equals(u.xj().y)) {
                return this;
            }
            u.xj().y = str;
            this.xj.put("dev08", str);
            return this;
        }

        public hf d(String str) {
            if (str == null || str.equals(u.xj().f)) {
                return this;
            }
            u.xj().f = str;
            this.xj.put("dev18", str);
            return this;
        }

        public hf f(String str) {
            if (str == null || str.equals(u.xj().c)) {
                return this;
            }
            u.xj().c = str;
            this.xj.put("dev17", str);
            return this;
        }

        public hf hf(String str) {
            if (str == null || str.equals(u.xj().hf)) {
                return this;
            }
            u.xj().hf = str;
            this.xj.put("dev02", com.bytedance.sdk.component.utils.xj.hf(str));
            return this;
        }

        public hf kd(String str) {
            if (str == null || str.equals(u.xj().tf)) {
                return this;
            }
            u.xj().tf = str;
            this.xj.put("dev11", str);
            return this;
        }

        public hf tf(String str) {
            if (str == null || str.equals(u.xj().d)) {
                return this;
            }
            u.xj().d = str;
            this.xj.put("dev09", str);
            return this;
        }

        public hf u(String str) {
            if (str == null || str.equals(u.xj().u)) {
                return this;
            }
            u.xj().u = str;
            this.xj.put("dev05", str);
            return this;
        }

        public hf w(String str) {
            if (str == null || str.equals(u.xj().w)) {
                return this;
            }
            u.xj().w = str;
            this.xj.put("dev04", str);
            return this;
        }

        public hf xj(String str) {
            if (str == null || str.equals(u.xj().xj)) {
                return this;
            }
            u.xj().xj = str;
            this.xj.put("dev01", str);
            return this;
        }

        public hf y(String str) {
            if (str == null || str.equals(u.xj().kd)) {
                return this;
            }
            u.xj().kd = str;
            this.xj.put("dev07", str);
            return this;
        }

        public void xj() {
            try {
                if (w.xj().hf()) {
                    for (Map.Entry<String, Object> entry : this.xj.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor edit = u.xj().hf().edit();
                for (Map.Entry<String, Object> entry2 : this.xj.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        edit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        edit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        edit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        edit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        edit.putString(key2, (String) value2);
                    }
                }
                edit.apply();
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public void am(String str) {
        if (str == null || str.equals(this.x)) {
            return;
        }
        this.x = str;
        u("dev15", str);
    }

    public String d() {
        if (this.u == null) {
            this.u = w("dev05", (String) null);
        }
        return this.u;
    }

    public String f() {
        if (this.w == null) {
            this.w = w("dev04", (String) null);
        }
        return this.w;
    }

    public void g(String str) {
        if (str == null || str.equals(this.f10457io)) {
            return;
        }
        this.f10457io = str;
        u("dev13", str);
    }

    public void kd(String str) {
        if (str == null || !str.equals(this.yo)) {
            this.yo = str;
            hf("keywords", str);
        }
    }

    public String p() {
        if (this.y == null) {
            this.y = w("dev08", (String) null);
        }
        return this.y;
    }

    public void pl(String str) {
        if (str == null || str.equals(this.dk)) {
            return;
        }
        this.dk = str;
        hf("dev10", str);
    }

    public void qt(String str) {
        if (str == null || !str.equals(this.ai)) {
            this.ai = str;
            hf("dev16", str);
        }
    }

    public String tf() {
        if (this.kd == null) {
            this.kd = w("dev07", (String) null);
        }
        return this.kd;
    }

    public void u(String str) {
        this.e = str;
        hf("dev03", str);
    }

    public String w(String str) {
        if (this.e == null) {
            this.e = w("dev03", str);
        }
        return this.e;
    }

    public int y() {
        if (this.v == -1) {
            this.v = hf("age_group", Integer.MIN_VALUE);
        }
        return this.v;
    }

    public void zg(String str) {
        if (str == null || !str.equals(this.z)) {
            this.z = str;
            hf("spl_strategy", this.z);
        }
    }

    public String c() {
        if (this.hf == null) {
            this.hf = com.bytedance.sdk.component.utils.xj.w(w("dev02", (String) null));
        }
        return this.hf;
    }

    public void hf(boolean z) {
        this.qt = z ? 1 : 2;
        xj("is_paid", this.qt);
    }

    public void xj(String str) {
        if (str == null || !str.equals(this.g)) {
            this.g = str;
            hf(PluginConstants.KEY_APP_ID, str);
        }
    }

    public int u(int i) {
        if (this.jk == -1) {
            this.jk = hf("sdk_theme_status", i);
        }
        return this.jk;
    }

    public void f(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        xj("dev_level", i);
    }

    public void hf(int i) {
        if (i == this.v) {
            return;
        }
        this.v = i;
        xj("age_group", i);
    }

    public String kd(int i) {
        if (TextUtils.isEmpty(this.ra)) {
            try {
                String w = w("logsdk_version", "");
                if (!TextUtils.isEmpty(w)) {
                    JSONObject jSONObject = new JSONObject(w);
                    int optInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.ra = jSONObject.optString("log_version");
                    if (optInt != 7132 || TextUtils.isEmpty(this.ra)) {
                        dk();
                    }
                } else {
                    dk();
                }
            } catch (Exception unused) {
            }
        }
        return this.ra;
    }

    public void w(int i) {
        if (i == this.jk) {
            return;
        }
        this.jk = i;
        xj("sdk_theme_status", i);
    }

    public void y(int i) {
        xj("sp_device_app_direction", i);
    }

    public boolean xj(boolean z) {
        if (this.qt == -1) {
            this.qt = hf("is_paid", z ? 1 : 2);
        }
        return this.qt == 1;
    }

    public void u(boolean z) {
        int i = z ? 1 : 2;
        if (this.zg != i) {
            this.zg = i;
            xj("is_use_mediation", i);
        }
    }

    public boolean hf(String str, boolean z) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, z);
            }
            return hf().getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public boolean w(boolean z) {
        if (this.zg == -1) {
            this.zg = hf("is_use_mediation", z ? 1 : 2);
        }
        return this.zg == 1;
    }

    public String xj(String str, String str2) {
        return w("code_group_rit_".concat(String.valueOf(str)), str2);
    }

    public String u(String str, long j) {
        String w;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            w = w(str, "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(w)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(w);
        if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
            return jSONObject.getString("value");
        }
        return null;
    }

    public void xj(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.et == null ? null : this.et.toString())) {
            return;
        }
        this.et = jSONArray;
        hf("dev12", jSONArray.toString());
    }

    public long hf(String str, long j) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, j);
            }
            return hf().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public String w(String str, String str2) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.hf("sp_exec_getad_config", str, str2);
            }
            return hf().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int hf(String str, int i) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, i);
            }
            return hf().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public String w(String str, long j) {
        String w;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            w = w(str, "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(w)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(w);
        if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
            return jSONObject.getString("value");
        }
        return null;
    }

    public void xj(String str, boolean z) {
        try {
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, Boolean.valueOf(z));
                return;
            }
            SharedPreferences.Editor edit = hf().edit();
            edit.putBoolean(str, z);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void hf(String str, String str2) {
        try {
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, str2);
                return;
            }
            SharedPreferences.Editor edit = hf().edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7132);
            hf(str, jSONObject.toString());
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public void xj(String str, long j) {
        try {
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor edit = hf().edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, int i) {
        try {
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_exec_getad_config", str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor edit = hf().edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
