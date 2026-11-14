package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.kd;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private String hf;
    private AtomicBoolean w;
    private volatile String xj;

    public static final class xj {
        static final y xj = new y();

        static {
            pJnKH();
        }

        private static /* synthetic */ void pJnKH() {
            char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 188);
            }
            String str = new String(charArray);
            char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 188);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private void f() {
        final boolean f = f.zg().f();
        boolean d = f.zg().d();
        com.bytedance.embedapplog.xj.xj(f && !d);
        final boolean p = f.zg().p();
        com.bytedance.embedapplog.xj.xj(new com.bytedance.embedapplog.kd() { // from class: com.bytedance.sdk.openadsdk.core.y.2
            @Override // com.bytedance.embedapplog.kd
            public void xj(kd.xj xjVar) {
                if (xjVar != null) {
                    com.bytedance.sdk.openadsdk.core.a.ra.xj(xjVar.xj);
                }
                if (p || !f || y.this.w.get()) {
                    return;
                }
                y.this.xj(new com.bytedance.sdk.openadsdk.qt.u(xjVar));
            }
        });
        if (d) {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.3
                @Override // java.lang.Runnable
                public void run() {
                    y.this.xj(new com.bytedance.sdk.openadsdk.qt.u(com.bytedance.sdk.openadsdk.core.a.ra.w(com.bytedance.sdk.openadsdk.core.a.tf.w(false))));
                }
            });
        } else {
            if (p || !f) {
                return;
            }
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.4
                @Override // java.lang.Runnable
                public void run() {
                    if (y.this.w.get()) {
                        return;
                    }
                    y.this.xj(new com.bytedance.sdk.openadsdk.qt.u("timeout"));
                }
            }, 3000L);
        }
    }

    public String c() {
        return "unionser_slardar_applog";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void hf() {
        com.bytedance.embedapplog.xj.xj(f.zg().f());
        com.bytedance.embedapplog.xj.xj();
    }

    public String kd() {
        return (String) com.bytedance.embedapplog.xj.xj("sdk_version_name", "");
    }

    public String u() {
        if (TextUtils.isEmpty(this.hf)) {
            this.hf = com.bytedance.embedapplog.xj.p();
        }
        return this.hf;
    }

    public String w() {
        if (TextUtils.isEmpty(this.xj)) {
            this.xj = com.bytedance.embedapplog.xj.d();
            com.bytedance.sdk.openadsdk.tools.hf.w(16, this.xj);
            com.bytedance.sdk.openadsdk.core.w.u.xj().pl(this.xj == null ? "" : this.xj);
        }
        return this.xj;
    }

    public String y() {
        return "164362";
    }

    private y() {
        this.xj = null;
        this.hf = null;
        this.w = new AtomicBoolean(false);
        xj(pz.getContext());
    }

    private void xj(Context context) {
        final com.bytedance.sdk.openadsdk.zg.w.w.u e = f.zg().e();
        com.bytedance.embedapplog.f fVar = new com.bytedance.embedapplog.f("164362", "unionser_slardar_applog");
        if (e != null) {
            boolean w = e.w();
            fVar.u(w);
            if (!w) {
                fVar.hf(e.tf());
            }
            fVar.w(e.u());
            if (ai.w >= 4600) {
                fVar.kd(e.y());
                if (ai.c() && ai.w >= 4900) {
                    fVar.xj(e.am());
                }
            }
        }
        fVar.y(!com.bytedance.sdk.openadsdk.core.u.xj.w());
        fVar.xj(new com.bytedance.embedapplog.c() { // from class: com.bytedance.sdk.openadsdk.core.y.1
            @Override // com.bytedance.embedapplog.c
            public String hf() {
                return com.bytedance.sdk.openadsdk.core.a.tf.hf();
            }

            @Override // com.bytedance.embedapplog.c
            public Looper kd() {
                return com.bytedance.sdk.component.utils.f.xj().getLooper();
            }

            @Override // com.bytedance.embedapplog.c
            public boolean u() {
                return com.bytedance.sdk.openadsdk.core.a.zg.xj();
            }

            @Override // com.bytedance.embedapplog.c
            public boolean w() {
                return pz.hf().l();
            }

            @Override // com.bytedance.embedapplog.c
            public String xj() {
                com.bytedance.sdk.openadsdk.zg.w.w.u uVar = e;
                if (uVar == null || uVar.u()) {
                    return com.bytedance.sdk.openadsdk.qt.hf.xj();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.c
            public Looper y() {
                return com.bytedance.sdk.component.utils.f.xj().getLooper();
            }

            @Override // com.bytedance.embedapplog.c
            public String xj(Context context2) {
                return com.bytedance.sdk.component.utils.e.hf(context2);
            }

            @Override // com.bytedance.embedapplog.c
            public String xj(String str) {
                return com.bytedance.sdk.openadsdk.core.a.io.hf(str);
            }

            @Override // com.bytedance.embedapplog.c
            public JSONObject xj(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray f = com.bytedance.sdk.openadsdk.core.a.p.f();
                    try {
                        if (f.length() != 0) {
                            jSONObject.put("ipv6_list", f);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }

            @Override // com.bytedance.embedapplog.c
            public void xj(String[] strArr, int[] iArr, boolean z) {
                com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(iArr);
            }
        });
        fVar.hf(pz.hf().ra());
        fVar.xj(true);
        fVar.hf(0);
        f();
        com.bytedance.embedapplog.xj.xj(context, fVar);
        HashMap hashMap = new HashMap();
        String pz = f.zg().pz();
        hashMap.put("host_appid", TextUtils.isEmpty(pz) ? "164362" : pz);
        hashMap.put("is_plugin", Boolean.valueOf(ai.xj()));
        hashMap.put(PluginConstants.KEY_SDK_VERSION, "7.1.3.2");
        hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        hashMap.put("sdk_api_version", ai.u);
        hashMap.put("channel", ai.kd());
        if (pz.hf().e()) {
            hashMap.put("use_apm_sdk", "1");
        }
        com.bytedance.embedapplog.xj.xj((HashMap<String, Object>) hashMap);
    }

    public static void hf(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.xj.xj(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.qt.u uVar) {
        this.w.set(true);
        com.bytedance.sdk.openadsdk.core.a.ra.xj(uVar);
    }

    public static y xj() {
        return xj.xj;
    }

    public void xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.xj.hf(str, jSONObject);
    }
}
