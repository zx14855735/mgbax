package com.bytedance.msdk.w.f;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.tf.d;
import com.bytedance.msdk.f.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static com.bytedance.msdk.w.xj.xj xj(com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, com.bytedance.msdk.w.xj.hf hfVar3) {
        com.bytedance.msdk.core.tf.xj xj;
        com.bytedance.msdk.api.u.xj.hf.w.xj xj2;
        if (hfVar != null && hfVar2 != null) {
            hfVar.xj(xj(hfVar2, hfVar));
            hfVar.hf(hfVar2.ra());
            if (hfVar.tf()) {
                com.bytedance.msdk.y.hf.xj(com.bytedance.msdk.core.hf.getContext(), hfVar.g());
                if (com.bytedance.msdk.y.hf.xj.xj(hfVar.g()) != null && (xj = com.bytedance.msdk.c.xj.hf.xj().xj(hfVar.g())) != null && xj.u() != null && (xj2 = xj.u().xj(hfVar.io(), hfVar.qt())) != null && xj(xj2)) {
                    return com.bytedance.msdk.w.w.hf.xj.u.xj(xj2.xj(), hfVar, hfVar3);
                }
            } else {
                if (hfVar.p()) {
                    return com.bytedance.msdk.w.w.hf.xj.u.xj(hfVar, hfVar3);
                }
                if (com.bytedance.msdk.core.c.w.xj(hfVar.f())) {
                    return new com.bytedance.msdk.w.w.hf.xj.w(hfVar3);
                }
            }
        }
        return null;
    }

    public static String xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2) {
        if (hfVar != null && hfVar2 != null) {
            r0 = TextUtils.isEmpty(hfVar.xj()) ? null : hfVar.xj();
            if (!TextUtils.isEmpty(hfVar2.pl())) {
                StringBuilder A4TApA2 = AYUAbz.A4TApA(CtFAbx.AcNBzu(r0, "_"));
                A4TApA2.append(hfVar2.pl());
                return A4TApA2.toString();
            }
        }
        return r0;
    }

    public static boolean xj(com.bytedance.msdk.api.u.xj.hf.w.xj xjVar) {
        Object apply;
        if (xjVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> c = com.bytedance.msdk.core.p.xj.xj().c();
        if (c != null) {
            if (!TextUtils.isEmpty(xjVar.xj())) {
                IzHBwY.AYUAbz A4TApA2 = IzHBwY.AYUAbz.A4TApA();
                A4TApA2.ASJ6gh(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, xjVar.xj());
                com.bytedance.msdk.xj.kd.w.hf("TMe", "custom className is " + xjVar.xj());
                A4TApA2.AMqCpz(-99999987, 8229);
                A4TApA2.ARc23Z(-99999985, Boolean.class);
                apply = c.apply(A4TApA2.A2egSU().sparseArray());
                return ((Boolean) apply).booleanValue();
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "custom className is empty");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "load ad check custom name class loader is null ");
        return false;
    }

    public static Map<String, Object> xj(com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hfVar != null && hfVar2 != null) {
            com.bytedance.msdk.core.tf.xj xj = com.bytedance.msdk.core.hf.hf().xj(hfVar.g());
            if (xj != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", xj.hf());
                concurrentHashMap.put("tt_ad_network_config_appKey", xj.w());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(hfVar.am()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(hfVar.qt()));
            Map<String, Object> r = hfVar2.r();
            if (r != null && r.size() > 0) {
                for (Map.Entry<String, Object> entry : r.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        concurrentHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            int et = hfVar2.et();
            int io2 = hfVar2.io();
            if (et < 0) {
                et = 0;
            }
            if (io2 < 0) {
                io2 = 0;
            }
            concurrentHashMap.put("ad_height", Integer.valueOf(io2));
            concurrentHashMap.put("ad_width", Integer.valueOf(et));
            concurrentHashMap.put("ad_type", Integer.valueOf(hfVar2.ht()));
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, d dVar, String str) {
        if (wVar == null || hfVar2 == null || hfVar == null) {
            return;
        }
        if ((hfVar2.v() == 0 || hfVar2.v() == 100) && hfVar2.ai() != 0.0d) {
            wVar.xj(hfVar2.ai());
        }
        if (hfVar2.ra()) {
            wVar.hf(hfVar2.q());
            wVar.w(hfVar2.z());
            if (hfVar2.j() != null) {
                wVar.kd(hfVar2.j().w());
                wVar.y(hfVar2.j().u());
                wVar.w(hfVar2.j().f());
                wVar.u(hfVar2.j().d());
                wVar.u(hfVar2.j().xj());
            }
        }
        wVar.qt(hfVar2.v());
        wVar.e(hfVar2.jk());
        wVar.zg(hfVar2.pz());
        if (str == null) {
            str = "";
        }
        wVar.yo(str);
        wVar.zg(hfVar2.g());
        wVar.e(hfVar2.f() != null ? hfVar2.f().zg() : "");
        wVar.qt(hfVar2.en());
        wVar.xj(SystemClock.elapsedRealtime());
        wVar.jk(hfVar2.pl());
        wVar.v(hfVar2.hf());
        wVar.g(com.bytedance.msdk.hf.xj.hf(hfVar2.g()));
        wVar.c(hfVar2.c());
        wVar.f(hfVar2.y());
        wVar.c(hfVar.xj());
        wVar.d(hfVar2.c());
        wVar.tf(hfVar2.y());
        wVar.y(hfVar2.am());
        wVar.kd(hfVar2.qt());
        wVar.am(hfVar.ht());
        wVar.w(hfVar2.l());
        wVar.xj(hfVar2.x());
        z.xj(wVar, hfVar2.f(), hfVar, false);
        if (dVar != null) {
            int i = dVar.hf;
            wVar.hf("if_test", Integer.valueOf(i == 1 ? i : 0));
            wVar.hf("server_bidding_extra", dVar.xj);
            int f = wVar.f(hfVar.xj());
            if (f == 1 || f == 2) {
                wVar.w(dVar.kd);
            }
        }
        if (hfVar2.j() == null || hfVar2.j() == null) {
            return;
        }
        wVar.xj("extra_data_and_no_parse", hfVar2.j().hf());
    }
}
