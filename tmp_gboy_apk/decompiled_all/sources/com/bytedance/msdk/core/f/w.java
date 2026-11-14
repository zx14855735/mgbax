package com.bytedance.msdk.core.f;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.f.xj>> hf;
    private Map<String, hf> xj;

    public static class xj {
        private static w xj = new w();

        static {
            evgBWJ();
        }

        private static /* synthetic */ void evgBWJ() {
            char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'd');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'd');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static w xj() {
        return xj.xj;
    }

    private w() {
        this.hf = new ConcurrentHashMap();
    }

    public void xj(ConcurrentHashMap<String, hf> concurrentHashMap) {
        this.xj = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void xj(String str, String str2, String str3) {
        A2egSU.BI9f7h(J3FDQU.A2egSU.BChYOn("setAdnError adnName = ", str, " slotId = ", str2, " error = "), str3, "TTMediationSDK_AdnShowControl");
        Map<String, hf> map = this.xj;
        hf hfVar = map != null ? map.get(str) : null;
        if (hfVar != null) {
            for (String str4 : hfVar.hf()) {
                if (TextUtils.equals(str4, str3)) {
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(str4)));
                    long xj2 = hfVar.xj() + new Date().getTime();
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + y.hf(xj2));
                    com.bytedance.msdk.core.f.xj xjVar = new com.bytedance.msdk.core.f.xj(str, str2, xj2);
                    if (this.hf != null) {
                        ConcurrentHashMap<String, com.bytedance.msdk.core.f.xj> concurrentHashMap = new ConcurrentHashMap<>();
                        concurrentHashMap.put(str2, xjVar);
                        this.hf.put(str, concurrentHashMap);
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.hf);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public com.bytedance.msdk.api.xj xj(String str, String str2) {
        com.bytedance.msdk.core.f.xj xjVar;
        ConcurrentHashMap<String, com.bytedance.msdk.core.f.xj> concurrentHashMap;
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.f.xj>> map = this.hf;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            xjVar = null;
        } else {
            xjVar = concurrentHashMap.get(str2);
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(xjVar)));
        }
        if (xjVar != null && xjVar.xj() != 0) {
            long time = new Date().getTime();
            if (time <= xjVar.xj()) {
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + y.hf(time));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + y.hf(xjVar.xj()));
                return new com.bytedance.msdk.api.hf.xj(40044, com.bytedance.msdk.api.xj.xj(40044));
            }
        }
        return null;
    }
}
