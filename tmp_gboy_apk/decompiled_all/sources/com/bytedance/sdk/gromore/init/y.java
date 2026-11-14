package com.bytedance.sdk.gromore.init;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements Function<SparseArray<Object>, Object> {
    private Context hf;
    private Function<SparseArray<Object>, Object> xj;

    public y(Context context, Function<SparseArray<Object>, Object> function) {
        this.xj = function;
        this.hf = context;
    }

    private void hf(SparseArray<Object> sparseArray) {
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        boolean z = false;
        int intValue = ADYaiT2.intValue(-99999982, 0);
        Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()));
        if (!com.bytedance.msdk.core.p.xj.xj().w()) {
            if (this.xj instanceof z) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj 代码位未开启聚合开关");
                ((z) this.xj).xj(intValue, ADYaiT2, AYUAbz2);
                return;
            }
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "CSJM_loadAD Type:".concat(String.valueOf(intValue)));
        final com.bytedance.sdk.gromore.xj.xj xjVar = new com.bytedance.sdk.gromore.xj.xj(sparseArray);
        hf.xj xjVar2 = new hf.xj(new com.bytedance.sdk.openadsdk.zg.w.w.hf(sparseArray));
        com.bytedance.msdk.core.p.xj.xj().xj(xjVar.f());
        hf.xj xjVar3 = new hf.xj(new com.bytedance.sdk.openadsdk.zg.w.w.hf(sparseArray));
        xj(xjVar, xjVar3);
        float w = xjVar.w();
        float u = xjVar.u();
        if (xjVar.xj() != 0 && (w == 0.0f || xjVar.xj() == w)) {
            xjVar2.xj(com.bytedance.msdk.api.kd.hf(this.hf, xjVar.xj()));
            if (xjVar.xj() == w) {
                z = true;
            }
        }
        if (xjVar.hf() != 0 && ((w == 0.0f && u == 0.0f) || u == xjVar.hf())) {
            xjVar2.hf(com.bytedance.msdk.api.kd.hf(this.hf, xjVar.hf()));
        }
        if (xjVar.xj() == 0 && w != 0.0f) {
            xjVar2.xj(com.bytedance.msdk.api.kd.xj(this.hf, w));
        }
        if (xjVar.hf() == 0 && u != 0.0f) {
            xjVar2.hf(com.bytedance.msdk.api.kd.xj(this.hf, u));
        }
        PluginValueSet xj = com.bytedance.msdk.core.p.xj.xj().u() ? com.bytedance.msdk.w.f.u.xj(xjVar.kd(), xjVar2, intValue) : com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar2.xj());
        final com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar4 = new com.bytedance.sdk.openadsdk.mediation.hf.hf.xj(xj != null ? xj.sparseArray() : new SparseArray<>());
        PluginValueSet xj2 = xj(ADYaiT2, xjVar3.xj());
        boolean z2 = !TextUtils.isEmpty(xjVar4.q());
        if (intValue == 1) {
            boolean z3 = z;
            if (!com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 1, z2)) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj banner 代码位 = " + xjVar.kd());
                xj(intValue, xj2);
                return;
            }
            com.bytedance.sdk.gromore.xj.xj.xj.xj xjVar5 = new com.bytedance.sdk.gromore.xj.xj.xj.xj(AYUAbz2);
            if (!v.xj) {
                pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                xjVar5.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                return;
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load m banner 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
            com.bytedance.msdk.w.f.hf.xj(this.hf, xjVar4, xjVar5, z3);
            return;
        }
        if (intValue == 3) {
            if (com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 3, z2)) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load m splash 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
            } else {
                if (!com.bytedance.msdk.c.xj.w.xj().w() || xjVar.c() == null || TextUtils.isEmpty(xjVar.c().xj()) || TextUtils.isEmpty(xjVar.c().w()) || TextUtils.isEmpty(xjVar.c().hf())) {
                    com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj splash 代码位 = " + xjVar.kd());
                    xj(intValue, xj2);
                    return;
                }
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load m splash 开屏兜底代码位 = " + xjVar.c().hf());
            }
            final boolean z4 = z;
            final com.bytedance.sdk.gromore.xj.xj.y.hf hfVar = new com.bytedance.sdk.gromore.xj.xj.y.hf(AYUAbz2);
            if (v.xj) {
                com.bytedance.msdk.api.u.tf.xj(new com.bytedance.msdk.api.u.xj.d.xj() { // from class: com.bytedance.sdk.gromore.init.y.1
                    @Override // com.bytedance.msdk.api.u.xj.d.xj
                    public void xj() {
                        com.bytedance.msdk.w.f.hf.xj(y.this.hf, xjVar4, xjVar, hfVar, z4);
                    }
                });
                return;
            } else {
                pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                hfVar.xj(new com.bytedance.sdk.gromore.xj.xj.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
                return;
            }
        }
        if (intValue == 5) {
            boolean booleanValue = xj2.booleanValue(2);
            if (!com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 5, z2)) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj feed 代码位 = " + xjVar.kd() + ", isExpress: " + booleanValue);
                xj(intValue, xj2);
                return;
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load m feed 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u() + ", isExpress: " + booleanValue);
            if (booleanValue) {
                com.bytedance.sdk.gromore.xj.xj.u.p pVar = new com.bytedance.sdk.gromore.xj.xj.u.p(AYUAbz2);
                if (!v.xj) {
                    pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                    pVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                    return;
                }
                Context context = this.hf;
                if (context != null) {
                    com.bytedance.msdk.w.f.hf.xj(context, xjVar4, pVar, z);
                    return;
                } else {
                    pVar.xj(81005, "context is null");
                    return;
                }
            }
            com.bytedance.sdk.gromore.xj.xj.u.pl plVar = new com.bytedance.sdk.gromore.xj.xj.u.pl(AYUAbz2);
            if (!v.xj) {
                pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                plVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                return;
            }
            Context context2 = this.hf;
            if (context2 != null) {
                com.bytedance.msdk.w.f.hf.xj(context2, xjVar4, plVar, z);
                return;
            } else {
                plVar.xj(81005, "context is null");
                return;
            }
        }
        if (intValue == 7) {
            if (!com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 7, z2)) {
                xj(intValue, xj2);
                return;
            }
            com.bytedance.sdk.gromore.xj.xj.kd.hf hfVar2 = new com.bytedance.sdk.gromore.xj.xj.kd.hf(AYUAbz2);
            if (!v.xj) {
                pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                hfVar2.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                return;
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load m reward video 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
            com.bytedance.msdk.w.f.hf.xj(this.hf, xjVar4, hfVar2);
            return;
        }
        if (intValue != 8) {
            if (intValue != 9) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "CSJM_loadAD load default mCSJLoader = " + this.xj);
                xj(intValue, xj2);
                return;
            }
            if (!com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 9, z2)) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj draw 代码位 = " + xjVar.kd());
                xj(intValue, xj2);
                return;
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load m draw 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
            com.bytedance.sdk.gromore.xj.xj.hf.w wVar = new com.bytedance.sdk.gromore.xj.xj.hf.w(AYUAbz2);
            if (!v.xj) {
                pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                wVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
                return;
            }
            Context context3 = this.hf;
            if (context3 != null) {
                com.bytedance.msdk.w.f.hf.xj(context3, xjVar4, wVar);
                return;
            } else {
                wVar.xj(81005, "context is null");
                return;
            }
        }
        if (!com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 8, z2) && !com.bytedance.msdk.core.p.xj.xj().xj(xjVar4.u(), 10, z2)) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load csj full");
            xj(intValue, xj2);
            return;
        }
        com.bytedance.sdk.gromore.xj.xj.w.xj xjVar6 = new com.bytedance.sdk.gromore.xj.xj.w.xj(AYUAbz2);
        if (!v.xj) {
            pl.u("TMe", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xjVar6.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        com.bytedance.msdk.core.tf.hf xj3 = com.bytedance.msdk.core.hf.hf().xj(xjVar4.u(), 8, 101);
        if (xj3 == null) {
            xj3 = com.bytedance.msdk.core.hf.hf().xj(xjVar4.u(), 10, 101);
        }
        if (xj3 == null || xj3.a() != 8) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "load m interstitial full 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
            com.bytedance.msdk.w.f.hf.hf(this.hf, xjVar4, xjVar6);
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "load m full 广告位 = " + xjVar.kd() + ",ritId:" + xjVar4.u());
        com.bytedance.msdk.w.f.hf.xj(this.hf, xjVar4, xjVar6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        r1 = new org.json.JSONObject();
        r2 = com.bytedance.msdk.core.xj.p().hf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if (r2.c() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        r2 = com.czhj.sdk.common.Constants.FAIL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        r1.put("name", "personal_ads_type");
        r1.put("value", r2);
        r0.put(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        return com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(r6, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r2 = "1";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bykv.vk.openvk.api.proto.PluginValueSet xj(com.bykv.vk.openvk.api.proto.PluginValueSet r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            r6 = 0
            return r6
        L4:
            com.bytedance.sdk.openadsdk.zg.w.w.hf r0 = new com.bytedance.sdk.openadsdk.zg.w.w.hf
            android.util.SparseArray r1 = r6.sparseArray()
            r0.<init>(r1)
            java.lang.String r0 = r0.ht()
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L1d
            r0.<init>()     // Catch: java.lang.Throwable -> L1d
            goto L25
        L1d:
            r0 = move-exception
            goto L72
        L1f:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L1d
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L1d
            r0 = r1
        L25:
            r1 = 0
        L26:
            int r2 = r0.length()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "name"
            java.lang.String r4 = "personal_ads_type"
            if (r1 >= r2) goto L44
            org.json.JSONObject r2 = r0.optJSONObject(r1)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L41
            java.lang.String r2 = r2.optString(r3)     // Catch: java.lang.Throwable -> L1d
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L41
            goto L75
        L41:
            int r1 = r1 + 1
            goto L26
        L44:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1d
            r1.<init>()     // Catch: java.lang.Throwable -> L1d
            com.bytedance.msdk.core.xj r2 = com.bytedance.msdk.core.xj.p()     // Catch: java.lang.Throwable -> L1d
            com.bytedance.msdk.xj.w.w r2 = r2.hf()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L75
            boolean r2 = r2.c()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L5c
            java.lang.String r2 = "0"
            goto L5e
        L5c:
            java.lang.String r2 = "1"
        L5e:
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "value"
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> L1d
            r0.put(r1)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1d
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(r6, r0)     // Catch: java.lang.Throwable -> L1d
            return r6
        L72:
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L75:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.y.xj(com.bykv.vk.openvk.api.proto.PluginValueSet):com.bykv.vk.openvk.api.proto.PluginValueSet");
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        hf(sparseArray);
        return null;
    }

    private void xj(int i, PluginValueSet pluginValueSet) {
        if (this.xj instanceof z) {
            Object objectValue = xj(pluginValueSet).objectValue(1, Object.class);
            if (objectValue == null) {
                pl.w("apply->load with null callback");
            } else {
                ((z) this.xj).xj(i, pluginValueSet, com.bytedance.sdk.openadsdk.ai.w.xj(objectValue));
            }
        }
    }

    private void xj(com.bytedance.sdk.gromore.xj.xj xjVar, hf.xj xjVar2) {
        xjVar2.u(xjVar.kd());
        xjVar2.xj(xjVar.w());
        xjVar2.hf(xjVar.u());
        xjVar2.hf(xjVar.hf());
        xjVar2.xj(xjVar.xj());
    }

    private PluginValueSet xj(PluginValueSet pluginValueSet, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        AYUAbz A5SV6n2 = AYUAbz.A5SV6n(pluginValueSet);
        A5SV6n2.ADYaiT(hfVar.d(), 260009);
        A5SV6n2.ADYaiT(hfVar.f(), 260008);
        A5SV6n2.AMqCpz(260007, hfVar.c());
        A5SV6n2.AMqCpz(260006, hfVar.y());
        A5SV6n2.ASJ6gh(260004, hfVar.u());
        return A5SV6n2.A2egSU();
    }
}
