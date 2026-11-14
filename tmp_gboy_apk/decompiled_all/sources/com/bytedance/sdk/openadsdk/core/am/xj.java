package com.bytedance.sdk.openadsdk.core.am;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bytedance.sdk.component.f.hf.u.xj.hf {
    private static final AtomicLong w = new AtomicLong(0);
    private AtomicBoolean am = new AtomicBoolean(false);
    private String c;
    private String d;
    private String f;
    private long g;
    protected final JSONObject hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private long f10293pl;
    private com.bytedance.sdk.openadsdk.y.xj.xj tf;
    private JSONObject u;
    public final String xj;
    private String y;

    /* renamed from: com.bytedance.sdk.openadsdk.core.am.xj$xj, reason: collision with other inner class name */
    public static final class C0138xj {
        private String c;
        private JSONObject d;
        private String f;
        private String hf;
        private String kd;
        private com.bytedance.sdk.openadsdk.y.xj.xj p;
        private com.bytedance.sdk.openadsdk.y.xj.hf tf;
        private String u;
        private String w;
        private String xj;
        private String y;

        public C0138xj c(String str) {
            this.f = str;
            return this;
        }

        public C0138xj hf(String str) {
            this.w = str;
            return this;
        }

        public C0138xj kd(String str) {
            this.y = str;
            return this;
        }

        public C0138xj u(String str) {
            this.kd = str;
            return this;
        }

        public C0138xj w(String str) {
            this.u = str;
            return this;
        }

        public C0138xj y(String str) {
            this.c = str;
            return this;
        }

        public C0138xj xj(String str) {
            this.hf = str;
            return this;
        }

        public C0138xj xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.d = jSONObject;
            return this;
        }

        public void xj(com.bytedance.sdk.openadsdk.y.xj.xj xjVar) {
            if (com.bytedance.sdk.openadsdk.core.ht.kd.xj(this.w, 1.0d)) {
                if (this.kd != null) {
                    com.bytedance.sdk.openadsdk.core.qt.w.kd().xj(this.w, this.y, this.f, (JSONObject) null, this.kd);
                }
                this.p = xjVar;
                xj xjVar2 = new xj(this);
                try {
                    com.bytedance.sdk.openadsdk.y.xj.hf hfVar = this.tf;
                    if (hfVar != null) {
                        hfVar.xj(xjVar2.hf);
                    } else {
                        new com.bytedance.sdk.openadsdk.y.xj.w().xj(xjVar2.hf);
                    }
                } catch (Throwable th) {
                    pl.hf("AdEvent", th);
                }
                com.bytedance.sdk.openadsdk.core.ht.hf.xj(xjVar2, this.w);
            }
        }
    }

    static {
        BdzsMB();
    }

    public xj(C0138xj c0138xj) {
        this.u = new JSONObject();
        this.xj = TextUtils.isEmpty(c0138xj.xj) ? UUID.randomUUID().toString() : c0138xj.xj;
        this.tf = c0138xj.p;
        this.p = c0138xj.kd;
        this.kd = c0138xj.hf;
        this.y = c0138xj.w;
        if (TextUtils.isEmpty(c0138xj.u)) {
            this.c = "app_union";
        } else {
            this.c = c0138xj.u;
        }
        this.f = c0138xj.y;
        this.d = c0138xj.c;
        this.u = c0138xj.d = c0138xj.d != null ? c0138xj.d : new JSONObject();
        this.g = System.currentTimeMillis();
        this.hf = new JSONObject();
        try {
            c();
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private static /* synthetic */ void BdzsMB() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void c() {
        this.f10293pl = w.incrementAndGet();
    }

    private void f() {
        this.hf.putOpt("tag", this.kd);
        this.hf.putOpt("label", this.y);
        this.hf.putOpt(PointParamKey.CATEGORY, this.c);
        if (!TextUtils.isEmpty(this.f)) {
            try {
                this.hf.putOpt("value", Long.valueOf(Long.parseLong(this.f)));
            } catch (NumberFormatException unused) {
                this.hf.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.hf.putOpt("ext_value", this.d);
        }
        if (!TextUtils.isEmpty(this.p)) {
            this.hf.putOpt("log_extra", this.p);
        }
        if (!TextUtils.equals(this.y, "pangle_live_sdk_monitor")) {
            this.hf.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
        }
        this.hf.putOpt("nt", Integer.valueOf(am.w(pz.getContext())));
        this.hf.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.f.zg().n());
        Iterator<String> keys = this.u.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.hf.putOpt(next, this.u.opt(next));
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public long hf() {
        return this.f10293pl;
    }

    public JSONObject kd() {
        if (this.am.get()) {
            return this.hf;
        }
        try {
            f();
            com.bytedance.sdk.openadsdk.y.xj.xj xjVar = this.tf;
            if (xjVar != null) {
                xjVar.xj(this.hf);
            }
            xj(this.hf);
            this.am.set(true);
        } catch (Throwable th) {
            pl.hf("AdEvent", th);
        }
        return this.hf;
    }

    public String u() {
        return this.xj;
    }

    public String w() {
        if (!TextUtils.isEmpty(this.y)) {
            return this.y;
        }
        JSONObject jSONObject = this.hf;
        return jSONObject != null ? jSONObject.optString("label") : "";
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public long xj() {
        return this.g;
    }

    public boolean y() {
        JSONObject jSONObject = this.hf;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("label");
        if (!TextUtils.isEmpty(optString)) {
            return w.xj.contains(optString);
        }
        if (TextUtils.isEmpty(this.y)) {
            return false;
        }
        return w.xj.contains(this.y);
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public JSONObject xj(String str) {
        JSONObject jSONObject;
        JSONObject kd = kd();
        try {
            String optString = kd.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
                if (pz.hf().jk() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (pz.hf().jk() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String c = com.bytedance.sdk.openadsdk.core.live.hf.xj().c();
            if (c != null) {
                jSONObject.putOpt("live_plugin_version", c.replaceAll("\\.", ""));
            }
            if (com.bytedance.sdk.openadsdk.core.f.zg().c()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            kd.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            return kd;
        } catch (Exception e) {
            pl.xj(e);
            return kd;
        }
    }

    private void xj(JSONObject jSONObject) {
        try {
            if (this.f10293pl != 0) {
                String optString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.f10293pl);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.bytedance.sdk.component.f.hf.w.xj.xj(this.y));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", com.bytedance.sdk.openadsdk.core.f.zg().ws() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.u.xj.u());
                    jSONObject2.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.ht.hf.xj);
                    if (!TextUtils.isEmpty(wo.d)) {
                        jSONObject2.put("wrong_stats_url", wo.d);
                    }
                    if (!TextUtils.isEmpty(wo.tf)) {
                        jSONObject2.put("wrong_applog_url", wo.tf);
                    }
                    com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(jSONObject2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.f10293pl);
                jSONObject3.put("sdk_event_self_count", com.bytedance.sdk.component.f.hf.w.xj.xj(this.y));
                jSONObject3.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.ht.hf.xj);
                jSONObject3.put("csj_type", com.bytedance.sdk.openadsdk.core.f.zg().ws() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.u.xj.u());
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(wo.d)) {
                    jSONObject3.put("wrong_stats_url", wo.d);
                }
                if (!TextUtils.isEmpty(wo.tf)) {
                    jSONObject3.put("wrong_applog_url", wo.tf);
                }
                com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(jSONObject3);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }
}
