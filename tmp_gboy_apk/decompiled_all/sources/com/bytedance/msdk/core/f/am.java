package com.bytedance.msdk.core.f;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am {
    private static volatile am xj;
    private Map<String, List<hf>> hf;
    private Map<String, ConcurrentHashMap<String, xj>> w = new ConcurrentHashMap();

    private am() {
    }

    public static am xj() {
        if (xj == null) {
            synchronized (am.class) {
                try {
                    if (xj == null) {
                        xj = new am();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(ConcurrentHashMap<String, List<hf>> concurrentHashMap) {
        this.hf = concurrentHashMap;
        if (concurrentHashMap == null) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap is null ");
            return;
        }
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap = " + this.hf);
    }

    public void xj(String str, String str2, String str3, String str4) {
        List<hf> list;
        hf hfVar;
        A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("setRitAdnError rit_level adnName = ", str2, " slotId = ", str3, " error = "), str4, "TTMediationSDK_RitAdnShowControl");
        Map<String, List<hf>> map = this.hf;
        if (map == null || (list = map.get(str2)) == null || list.size() == 0) {
            return;
        }
        Iterator<hf> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                hfVar = it.next();
                if (hfVar.w().contains(str)) {
                    break;
                }
            } else {
                hfVar = null;
                break;
            }
        }
        if (hfVar != null) {
            for (String str5 : hfVar.hf()) {
                if (TextUtils.equals(str5, str4)) {
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "setAdnError rit_level 命中errorCode = ".concat(String.valueOf(str5)));
                    long xj2 = hfVar.xj() + new Date().getTime();
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level 更新时间 = " + y.hf(xj2));
                    xj xjVar = new xj(str2, str3, xj2, str4);
                    Map<String, ConcurrentHashMap<String, xj>> map2 = this.w;
                    if (map2 != null) {
                        ConcurrentHashMap<String, xj> concurrentHashMap = map2.get(str2);
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap<>();
                        }
                        concurrentHashMap.put(str + "_" + str3, xjVar);
                        this.w.put(str2, concurrentHashMap);
                        StringBuilder sb = new StringBuilder("setRitAdnError rit_level mAdnControlMap = ");
                        sb.append(this.w);
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", sb.toString());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public com.bytedance.msdk.api.xj xj(String str, String str2, String str3) {
        xj xjVar;
        ConcurrentHashMap<String, xj> concurrentHashMap;
        StringBuilder BChYOn2 = J3FDQU.A2egSU.BChYOn("checkLoad rit_level adnName = ", str2, " slotId = ", str3, " primeRit = ");
        BChYOn2.append(str);
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", BChYOn2.toString());
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, ConcurrentHashMap<String, xj>> map = this.w;
            if (map == null || (concurrentHashMap = map.get(str2)) == null) {
                xjVar = null;
            } else {
                xjVar = concurrentHashMap.get(str + "_" + str3);
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 取出的showBean = ".concat(String.valueOf(xjVar)));
            }
            if (xjVar != null && xjVar.xj() != 0) {
                long time = new Date().getTime();
                if (time <= xjVar.xj()) {
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 当前时间 = " + y.hf(time));
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 规则有效时间 = " + y.hf(xjVar.xj()));
                    return new com.bytedance.msdk.api.hf.xj(40064, com.bytedance.msdk.api.xj.xj(40064) + ", " + xjVar.hf());
                }
            }
        }
        return null;
    }

    public boolean xj(String str, String str2) {
        Map<String, List<hf>> map;
        List<hf> list;
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_RitAdnShowControl", "hasRitAdnConfig rit_level adnName = " + str2 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (map = this.hf) != null && map.size() != 0 && (list = this.hf.get(str2)) != null && list.size() != 0) {
            Iterator<hf> it = list.iterator();
            while (it.hasNext()) {
                List<String> w = it.next().w();
                if (w != null && w.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
