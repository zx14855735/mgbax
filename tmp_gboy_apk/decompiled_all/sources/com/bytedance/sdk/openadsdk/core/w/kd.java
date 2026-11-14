package com.bytedance.sdk.openadsdk.core.w;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private volatile String c;
    public String xj;
    private volatile String y;
    private volatile int w = -1;
    private volatile long u = -1;
    private volatile float kd = -1.0f;
    private volatile int f = -1;
    private volatile int d = -1;
    private volatile int tf = -1;
    private volatile int p = -1;

    /* renamed from: pl, reason: collision with root package name */
    private volatile int f10456pl = 0;
    private volatile int g = -1;
    private volatile int am = -1;
    private volatile int qt = -1;
    private volatile SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), yo(), 0);

    public static class xj {
        private static kd xj = new kd();

        static {
            Zpev();
        }

        private static /* synthetic */ void Zpev() {
            char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 21);
            }
            String str = new String(charArray);
            char[] charArray2 = "vy|{|a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 21);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yo() {
        return "sp_exec_getad_config_bst";
    }

    public int qt() {
        if (this.qt == -1) {
            this.qt = xj("splash_policy", 0);
        }
        return this.qt;
    }

    public void zg() {
        try {
            SharedPreferences.Editor edit = this.hf.edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public int am() {
        if (this.f10456pl <= 0) {
            this.f10456pl = xj("splash_render_timeout_backup", 100);
        }
        return this.f10456pl;
    }

    public int g() {
        if (this.p == -1) {
            this.p = xj("spl_common_conf", 0);
        }
        return this.p;
    }

    public int p() {
        if (this.f == -1) {
            this.f = xj("spl_cache_conf", 14);
        }
        return this.f;
    }

    public int pl() {
        if (this.tf == -1) {
            this.tf = xj("spl_thread_conf", 1);
        }
        return this.tf;
    }

    public boolean tf() {
        return xj("is_spl_cache_remove_change", false);
    }

    public static class hf {
        private Map<String, Object> xj = new HashMap();

        public hf c(int i) {
            if (kd.xj().f10456pl == i) {
                return this;
            }
            kd.xj().f10456pl = i;
            this.xj.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public hf f(int i) {
            if (kd.xj().g == i) {
                return this;
            }
            kd.xj().g = i;
            this.xj.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public hf hf(String str) {
            if (str != null && str.equals(kd.xj().c)) {
                return this;
            }
            kd.xj().c = str;
            Map<String, Object> map = this.xj;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public hf kd(int i) {
            if (kd.xj().p == i) {
                return this;
            }
            kd.xj().p = i;
            this.xj.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public hf u(int i) {
            if (kd.xj().tf == i) {
                return this;
            }
            kd.xj().tf = i;
            this.xj.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public hf w(int i) {
            if (kd.xj().f == i) {
                return this;
            }
            kd.xj().f = i;
            this.xj.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public hf xj(long j) {
            if (kd.xj().u == j) {
                return this;
            }
            kd.xj().u = j;
            this.xj.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            return this;
        }

        public hf y(int i) {
            if (kd.xj().d == i) {
                return this;
            }
            kd.xj().d = i;
            this.xj.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public hf hf(int i) {
            if (kd.xj().am == i) {
                return this;
            }
            kd.xj().am = i;
            this.xj.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public hf w(String str) {
            if (str != null && str.equals(kd.xj().xj)) {
                return this;
            }
            kd.xj().xj = str;
            Map<String, Object> map = this.xj;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public hf xj(int i) {
            if (kd.xj().w == i) {
                return this;
            }
            kd.xj().w = i;
            this.xj.put("max", Integer.valueOf(i));
            return this;
        }

        public hf xj(float f) {
            if (kd.xj().kd == f) {
                return this;
            }
            kd.xj().kd = f;
            this.xj.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public hf xj(String str) {
            if (str != null && str.equals(kd.xj().y)) {
                return this;
            }
            kd.xj().y = str;
            Map<String, Object> map = this.xj;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public hf xj(boolean z) {
            this.xj.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public hf xj(JSONObject jSONObject) {
            int optInt;
            if (jSONObject == null || kd.xj().qt == (optInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            kd.xj().qt = optInt;
            this.xj.put("splash_policy", Integer.valueOf(optInt));
            return this;
        }

        public void xj() {
            try {
                if (w.xj().hf()) {
                    String yo = kd.yo();
                    for (Map.Entry<String, Object> entry : this.xj.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj(yo, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj(yo, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj(yo, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj(yo, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.c.w.xj.hf.xj(yo, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor edit = kd.xj().hf.edit();
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
                edit.commit();
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public void c() {
        this.c = "";
        this.y = "";
        xj("ab_test_version", "");
        xj("ab_test_param", "");
    }

    public int d() {
        if (this.am == -1) {
            this.am = xj("cypher_version", 40001);
        }
        return this.am;
    }

    public boolean f() {
        if (this.g == -1) {
            this.g = xj("dl_storage_internal", 1);
        }
        return this.g == 1;
    }

    public String kd() {
        if (this.y == null) {
            this.y = hf("ab_test_version", "");
        }
        return this.y;
    }

    public float u() {
        if (this.kd == -1.0f) {
            this.kd = xj("aggMultiple", -1.0f);
        }
        return this.kd;
    }

    public int w() {
        if (this.w == -1) {
            this.w = xj("max", 50);
        }
        return this.w;
    }

    public String y() {
        if (this.c == null) {
            this.c = hf("ab_test_param", "");
        }
        return this.c;
    }

    public long hf() {
        if (this.u == -1) {
            this.u = xj(MediationConstant.EXTRA_DURATION, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return this.u;
    }

    public static kd xj() {
        return xj.xj;
    }

    public String hf(String str, String str2) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.hf(yo(), str, str2);
            }
            return this.hf.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public boolean xj(String str, boolean z) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj(yo(), str, z);
            }
            return this.hf.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public long xj(String str, long j) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj(yo(), str, j);
            }
            return this.hf.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float xj(String str, float f) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj(yo(), str, f);
            }
            return this.hf.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int xj(String str, int i) {
        try {
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.xj(yo(), str, i);
            }
            return this.hf.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void xj(String str, String str2) {
        try {
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj(yo(), str, str2);
                return;
            }
            SharedPreferences.Editor edit = this.hf.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
