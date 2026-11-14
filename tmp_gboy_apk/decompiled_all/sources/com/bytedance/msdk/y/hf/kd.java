package com.bytedance.msdk.y.hf;

import android.util.SparseArray;
import com.bytedance.msdk.api.u.tf;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {

    public static class xj extends c {
        public xj(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar) {
            super(hfVar);
        }

        @Override // com.bytedance.msdk.y.hf.c
        public boolean hf() {
            int dq = com.bytedance.msdk.core.hf.hf().dq();
            if (dq > 0) {
                return false;
            }
            if (dq < 0) {
                return true;
            }
            return super.hf();
        }

        @Override // com.bytedance.msdk.y.hf.c
        public boolean xj() {
            int s = com.bytedance.msdk.core.hf.hf().s();
            if (s > 0) {
                return true;
            }
            if (s < 0) {
                return false;
            }
            return super.xj();
        }
    }

    public static JSONObject hf() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.bytedance.msdk.xj.xj.u> hf = hf.xj().hf();
            if (hf != null && hf.size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.xj.xj.u> entry : hf.entrySet()) {
                    String key = entry.getKey();
                    com.bytedance.msdk.xj.xj.u value = entry.getValue();
                    long kd = value.kd();
                    int y = value.y();
                    if (kd != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", y);
                        jSONObject2.put(MediationConstant.EXTRA_DURATION, kd);
                        jSONObject.put(key, jSONObject2);
                        value.c();
                    }
                }
            }
            if (com.bytedance.sdk.gromore.init.kd.y > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", 1);
                jSONObject3.put(MediationConstant.EXTRA_DURATION, com.bytedance.sdk.gromore.init.kd.y);
                jSONObject3.put("plugin", ai.hf() ? 1 : 0);
                jSONObject.put(MediationConstant.ADN_PANGLE, jSONObject3);
                com.bytedance.sdk.gromore.init.kd.y = 0L;
            }
            if (com.bytedance.sdk.gromore.init.kd.c > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", 1);
                jSONObject4.put(MediationConstant.EXTRA_DURATION, com.bytedance.sdk.gromore.init.kd.c);
                jSONObject4.put("plugin", ai.hf() ? 1 : 0);
                jSONObject.put("fusion", jSONObject4);
                com.bytedance.sdk.gromore.init.kd.c = 0L;
            }
            if (com.bytedance.msdk.y.hf.xj.u() != null && com.bytedance.msdk.y.hf.xj.u().xj() != null && com.bytedance.msdk.y.hf.xj.u().xj().size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.api.u.xj.hf.y.xj> entry2 : com.bytedance.msdk.y.hf.xj.u().xj().entrySet()) {
                    String key2 = entry2.getKey();
                    com.bytedance.msdk.api.u.xj.hf.y.xj value2 = entry2.getValue();
                    long kd2 = value2.kd();
                    int y2 = value2.y();
                    if (kd2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("status", y2);
                        jSONObject5.put(MediationConstant.EXTRA_DURATION, kd2);
                        jSONObject.put(key2, jSONObject5);
                        value2.c();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.u uVar) {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = new com.bytedance.sdk.openadsdk.zg.w.w.xj(com.bytedance.msdk.core.xj.p().a().sparseArray());
        uVar.xj(8475, com.bytedance.sdk.openadsdk.zg.w.u.xj(xj(xjVar.p())));
        uVar.xj(8457, com.bytedance.sdk.openadsdk.zg.w.u.xj(xj(xjVar.qt())));
        uVar.xj(1, Boolean.valueOf(com.bytedance.msdk.c.xj.xj.xj().d()));
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.u uVar, com.bytedance.sdk.openadsdk.zg.u uVar2) {
        uVar.xj(8424, com.bytedance.sdk.openadsdk.zg.w.u.xj(uVar2.hf()));
    }

    public static SparseArray<Object> xj(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar) {
        if (xjVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj2.xj(8458, Boolean.valueOf(xjVar.kd()));
        xj2.xj(8459, xjVar.p());
        xj2.xj(8460, xjVar.xj());
        xj2.xj(8461, Boolean.valueOf(xjVar.hf()));
        xj2.xj(8310, new f(xjVar.w()));
        xj2.xj(8462, xjVar.u());
        xj2.xj(8463, xjVar.y());
        xj2.xj(8464, xjVar.c());
        xj2.xj(8465, Boolean.valueOf(xjVar.f()));
        xj2.xj(8466, Boolean.valueOf(xjVar.d()));
        xj2.xj(8467, Boolean.valueOf(xjVar.tf()));
        return xj2.hf();
    }

    public static SparseArray<Object> xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj();
        if (uVar != null) {
            xj2.xj(8311, new xj(uVar.zg()));
            xj2.xj(8023, Boolean.valueOf(uVar.w()));
            xj2.xj(8024, Boolean.valueOf(uVar.xj()));
            xj2.xj(8025, Boolean.valueOf(uVar.kd()));
            xj2.xj(8026, Boolean.valueOf(uVar.hf()));
            xj2.xj(8480, Boolean.valueOf(uVar.u()));
            xj2.xj(8479, Boolean.valueOf(uVar.y()));
            xj2.xj(8312, uVar.d() != null ? new y(uVar.d()) : null);
            xj2.xj(8483, uVar.d());
            xj2.xj(8484, uVar.tf());
            xj2.xj(8485, uVar.am());
            xj2.xj(8486, uVar.pl());
            xj2.xj(8487, uVar.p());
            xj2.xj(8554, uVar.qt());
            xj2.xj(8549, Boolean.valueOf(uVar.c()));
        } else {
            xj2.xj(8311, new xj(null));
            Boolean bool = Boolean.TRUE;
            xj2.xj(8023, bool);
            xj2.xj(8024, bool);
            xj2.xj(8025, bool);
            xj2.xj(8026, bool);
            xj2.xj(8480, bool);
            xj2.xj(8479, bool);
            xj2.xj(8312, new y(null));
            xj2.xj(8483, null);
            xj2.xj(8484, "");
            xj2.xj(8485, "");
            xj2.xj(8486, "");
            xj2.xj(8487, "");
            xj2.xj(8549, bool);
        }
        return xj2.hf();
    }

    public static void xj() {
        tf.xj(new com.bytedance.sdk.openadsdk.zg.w.w.xj(com.bytedance.msdk.core.xj.p().a().sparseArray()).p());
    }
}
