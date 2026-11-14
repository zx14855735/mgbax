package com.bytedance.msdk.core.kd;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.msdk.api.xj.hf;
import com.bytedance.msdk.core.kd.hf.c;
import com.bytedance.msdk.hf.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final Map<String, Integer> xj = new HashMap();
    private final Map<String, Integer> hf = new HashMap();

    public void hf(String str, String str2, int i) {
        this.hf.put(CtFAbx.AlLFFp(str, "_", str2), Integer.valueOf(i));
    }

    public void xj(String str, String str2, int i) {
        this.xj.put(CtFAbx.AlLFFp(str, "_", str2), Integer.valueOf(i));
    }

    public int hf(String str, String str2) {
        Integer num = this.hf.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public int xj(String str, String str2) {
        Integer num = this.xj.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public int xj(c cVar, hf hfVar, hf hfVar2, String str) {
        if (cVar == null || cVar.xj == null) {
            return 4;
        }
        String ra = hfVar2 != null ? hfVar2.ra() : "";
        String lw = cVar.xj.lw();
        String cy = cVar.xj.cy();
        Integer y = cVar.xj.y();
        if (y.intValue() == 1) {
            if (cVar.xj.tu()) {
                A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":广告已show过 ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
                return 7;
            }
            if (xj(ra, cVar.xj)) {
                A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":广告过期了(M配置) ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
                return 2;
            }
            if (!xj(hfVar, hfVar2, cVar.xj)) {
                A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":AdSlot不符合 ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
                return 6;
            }
            A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":复用成功：---", lw, ", adSlotId: "), cy, MediationConstant.TAG);
            return -1;
        }
        if (cVar.xj.tu()) {
            A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":广告已show过 ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
            return 7;
        }
        if (y.intValue() == 3) {
            A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":广告过期了(adn api) ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
            return 1;
        }
        if (y.intValue() == 4) {
            A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":isReady是false ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
            return 5;
        }
        if (!xj(hfVar, hfVar2, cVar.xj)) {
            A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":AdSlot不符合 ---: ", lw, ", adSlotId: "), cy, MediationConstant.TAG);
            return 6;
        }
        A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("--==-- ", str, ":复用成功：---", lw, ", adSlotId: "), cy, MediationConstant.TAG);
        return -1;
    }

    public final boolean xj(String str, w wVar) {
        if (wVar == null || wVar.kd()) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告已经destroy了，视为过期 ------");
            return true;
        }
        boolean z = SystemClock.elapsedRealtime() > wVar.dq() + ((long) xj(str, wVar.cy()));
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 使用了配置的过期时间进行判断 ------");
        return z;
    }

    public static boolean xj(hf hfVar, hf hfVar2, w wVar) {
        if (hfVar != null && hfVar2 != null) {
            if (hfVar.l() != hfVar2.l()) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- orientation, a1: " + hfVar.l() + ", a2: " + hfVar2.l());
                return false;
            }
            if (hfVar.ff() != hfVar2.ff()) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- isMuted, a1: " + hfVar.ff() + ", a2: " + hfVar2.ff());
                return false;
            }
            if (hfVar.et() != hfVar2.et()) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- ImgWidth, a1: " + hfVar.et() + ", a2: " + hfVar2.et());
                return false;
            }
            if (hfVar.io() != hfVar2.io()) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- ImgHeight, a1: " + hfVar.io() + ", a2: " + hfVar2.io());
                return false;
            }
            if (hfVar.q() != null && hfVar2.q() != null) {
                if (!hfVar.q().equals(hfVar2.q())) {
                    com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- rewardName, a1: " + hfVar.q() + ", a2: " + hfVar2.q());
                    return false;
                }
            } else if (hfVar.q() != null || hfVar2.q() != null) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- rewardName=null, a1: " + hfVar.q() + ", a2: " + hfVar2.q());
                return false;
            }
            if (hfVar.z() != hfVar2.z()) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- rewardAmount, a1: " + hfVar.z() + ", a2: " + hfVar2.z());
                return false;
            }
            if (hfVar.en() != null && hfVar2.en() != null) {
                if (!hfVar.en().equals(hfVar2.en())) {
                    com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- reward, userId, a1: " + hfVar.en() + ", a2: " + hfVar2.en());
                    return false;
                }
            } else if (hfVar.en() != null || hfVar2.en() != null) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- reward, userId=null, a1: " + hfVar.en() + ", a2: " + hfVar2.en());
                return false;
            }
            if (hfVar.r() != null && hfVar2.r() != null) {
                if (xj(hfVar.r(), hfVar2.r())) {
                    return true;
                }
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- customData, a1: " + hfVar.r().toString() + ", a2: " + hfVar2.r().toString());
                return false;
            }
            if (hfVar.r() == null && hfVar2.r() == null) {
                return true;
            }
            com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- customData=null, a1: " + hfVar.r() + ", a2: " + hfVar2.r());
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- adSlot = null, a1: " + hfVar + ", a2: " + hfVar2);
        return false;
    }

    public static boolean xj(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                if (str != null) {
                    Object obj = map.get(str);
                    String str2 = obj instanceof String ? (String) obj : null;
                    Object obj2 = map2.get(str);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
