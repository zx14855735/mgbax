package com.bytedance.msdk.w.w.hf.xj;

import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.y.hf.kd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends hf {
    private xj hf;
    private com.bytedance.msdk.api.xj.hf u;
    private com.bytedance.msdk.w.y.hf.hf w;

    public w(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        this.w = hfVar;
        this.u = hfVar2;
        com.bytedance.sdk.openadsdk.zg.u xj = xj(hfVar, hfVar2, map);
        if (xj != null) {
            this.hf = new xj(hfVar2, hfVar, this);
            xj.xj(8429, hfVar.zg());
            xj.xj(8430, hfVar.e());
            xj.xj(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.hf);
            xj.xj(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, hfVar.yo());
            xj.xj(8561, Integer.valueOf(hfVar.wo()));
            com.bytedance.msdk.y.hf.xj.hf(hfVar.g());
            xj(context, xj);
        }
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf, com.bytedance.msdk.w.xj.xj
    public String xj(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2) {
        if (hfVar != null && hfVar2 != null) {
            HashMap BI9f7h2 = A2egSU.BI9f7h("bidding_token", "true");
            if (this.hf == null) {
                this.hf = new xj(hfVar2, hfVar, this);
                com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
                xj.xj(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.hf);
                xj.xj(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, hfVar.yo());
                com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj();
                xj2.xj(8449, BI9f7h2);
                com.bytedance.sdk.openadsdk.zg.u xj3 = com.bytedance.sdk.openadsdk.zg.u.xj();
                xj3.xj(8443, xj2.hf());
                xj.xj(8090, com.bytedance.sdk.openadsdk.zg.u.xj(hfVar2.b()).xj(8089, xj3.hf()).hf());
                Function<SparseArray<Object>, Object> c = com.bytedance.msdk.core.p.xj.xj().c();
                if (c != null) {
                    com.bytedance.sdk.openadsdk.zg.u xj4 = com.bytedance.sdk.openadsdk.zg.u.xj();
                    xj4.xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.xj.kd.xj.xj(context)).xj(8106).xj(Void.class);
                    kd.xj(xj4, xj);
                    c.apply(xj4.hf());
                } else {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "load ad class loader is null ");
                }
            }
            if (this.hf != null && hfVar2.pz() != null) {
                com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai = hfVar2.pz().ai();
                return this.hf.xj(context, hfVar.pl(), com.bytedance.msdk.core.zg.xj.xj(ai != null ? ai.y() : null));
            }
        }
        return null;
    }

    private void hf(Context context, com.bytedance.sdk.openadsdk.zg.u uVar) {
        Function<SparseArray<Object>, Object> c = com.bytedance.msdk.core.p.xj.xj().c();
        if (c != null) {
            if (com.bytedance.sdk.gromore.init.xj.xj() >= 5900) {
                com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.xj.kd.xj.xj(context)).xj(8106).xj(Void.class);
                kd.xj(xj, uVar);
                c.apply(xj.hf());
                return;
            } else {
                uVar.xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.xj.kd.xj.xj(context)).xj(8106).xj(Void.class);
                c.apply(uVar.hf());
                return;
            }
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "load ad class loader is null ");
    }

    private void xj(Context context, com.bytedance.sdk.openadsdk.zg.u uVar) {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.w;
        Function<SparseArray<Object>, Object> xj = (hfVar == null || this.u == null) ? null : com.bytedance.msdk.core.xj.xj.kd.xj(hfVar.g(), this.u.ht(), this.w.qt());
        if (xj != null) {
            xj.apply(com.bykv.vk.component.ttvideo.player.A2egSU.AZOQYO(8241, Void.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.xj.kd.xj.xj(context)).xj(8424, uVar.hf()).hf());
        } else {
            hf(context, uVar);
        }
    }

    private com.bytedance.sdk.openadsdk.zg.u xj(com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        HashMap hashMap = null;
        if (hfVar == null || hfVar2 == null || hfVar2.pz() == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj pz = hfVar2.pz();
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai = pz.ai();
        com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj(hfVar2.b()).xj(15, pz.am()).xj(13, Integer.valueOf(hfVar2.x())).xj(7, Integer.valueOf(pz.y())).xj(8, Integer.valueOf(pz.c())).xj(16, Integer.valueOf(pz.qt())).xj(20, Integer.valueOf(pz.yo())).xj(11, Boolean.valueOf(pz.tf())).xj(17, Integer.valueOf(hfVar2.e()));
        com.bytedance.sdk.openadsdk.zg.u xj3 = com.bytedance.sdk.openadsdk.zg.u.xj();
        HashMap hashMap2 = new HashMap();
        if (ai != null) {
            if (ai.y() != null) {
                hashMap2.putAll(ai.y());
            }
            if (hfVar.f() != null) {
                hashMap2.put("waterfall_config", hfVar.f());
            }
            hashMap2.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().u()));
            hashMap2.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().kd()));
            com.bytedance.msdk.core.u.xj.xj(hfVar2, hfVar.f(), hashMap2);
            xj3.xj(8444, Boolean.valueOf(ai.w())).xj(8445, Boolean.valueOf(ai.xj())).xj(8446, Boolean.valueOf(ai.hf())).xj(8447, Float.valueOf(ai.u())).xj(8448, Boolean.valueOf(ai.kd())).xj(8450, Boolean.valueOf(ai.c())).xj(8451, ai.f()).xj(8454, Boolean.valueOf(ai.d())).xj(8455, Float.valueOf(ai.p())).xj(8456, Float.valueOf(ai.pl()));
        } else {
            hashMap2.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().u()));
            hashMap2.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().kd()));
        }
        d hf = com.bytedance.msdk.core.xj.p().ra().hf();
        if (hf != null) {
            hashMap2.put("lng", Double.valueOf(hf.hf()));
            hashMap2.put("lat", Double.valueOf(hf.xj()));
            hashMap2.put("loc_time", Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            A2egSU.BNL6CD(-1, hashMap2, "lng", -1, "lat");
            hashMap2.put("loc_time", -1);
        }
        hashMap2.put("load_type", com.bytedance.msdk.core.xj.xj.kd.xj());
        hashMap2.put("load_can_log", Boolean.valueOf(com.bytedance.msdk.c.xj.xj.xj().d()));
        xj3.xj(8449, hashMap2);
        xj3.xj(8044, hashMap2);
        xj(xj3, pz, ai);
        xj2.xj(8443, xj3.hf());
        xj.xj(8090, com.bytedance.sdk.openadsdk.zg.w.u.xj(com.bytedance.sdk.openadsdk.zg.u.xj(hfVar2.b()).xj(8089, xj2.hf()).hf()));
        xj.xj(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, hfVar.pl());
        xj.xj(4, hfVar2.ra());
        xj.xj(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, hfVar.g());
        xj.xj(17, Integer.valueOf(hfVar2.e()));
        if (hfVar2.r() != null) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, Object> entry : hfVar2.r().entrySet()) {
                Object value = entry.getValue();
                hashMap3.put(entry.getKey(), value == null ? null : value.toString());
            }
            hashMap = hashMap3;
        }
        if (hashMap != null) {
            xj.xj(8013, hashMap);
        }
        if (map != null) {
            xj.xj(8096, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            xj.xj(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            xj.xj(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            Integer num = (Integer) obj3;
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 3) {
                xj.xj(8033, Boolean.TRUE);
            }
            xj.xj(8085, num);
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            xj.xj(8094, (Integer) obj4);
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            Integer num2 = (Integer) obj5;
            num2.intValue();
            xj.xj(8553, num2);
        }
        return xj;
    }

    private void xj(com.bytedance.sdk.openadsdk.zg.u uVar, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar) {
        if (uVar == null || xjVar == null) {
            return;
        }
        if (hfVar != null && !TextUtils.isEmpty(hfVar.am()) && hfVar.qt() != 0) {
            uVar.xj(8452, hfVar.am());
            uVar.xj(8453, Integer.valueOf(hfVar.qt()));
        } else {
            if (TextUtils.isEmpty(xjVar.dk()) || xjVar.et() == 0) {
                return;
            }
            uVar.xj(8452, xjVar.dk());
            uVar.xj(8453, Integer.valueOf(xjVar.et()));
        }
    }

    @Override // com.bytedance.msdk.w.xj.xj
    public String xj(String str) {
        com.bytedance.msdk.xj.xj.u xj = com.bytedance.msdk.y.hf.hf.xj().xj(str);
        if (xj != null) {
            return xj.hf();
        }
        return null;
    }
}
