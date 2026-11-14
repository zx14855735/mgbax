package com.bytedance.msdk.core.f;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.text.TextUtils;
import android.util.Pair;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private static final String xj = "TTMediationSDK_p";
    private Map<String, Pair<String, String>> hf;

    public static class xj {
        private static p xj = new p();

        static {
            XzPef();
        }

        private static /* synthetic */ void XzPef() {
            char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '1');
            }
            String str = new String(charArray);
            char[] charArray2 = "R]X_XE".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '1');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c u(String str, String str2) {
        return f.xj().hf(str, str2);
    }

    public void delete(String str, String str2) {
        f.xj().xj(str, str2);
    }

    public boolean w(String str, String str2) {
        com.bytedance.msdk.xj.kd.w.xj(xj, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        c u = u(str, str2);
        if (u == null || !u.f()) {
            return true;
        }
        for (kd kdVar : u.p()) {
            Date date = new Date();
            String str3 = xj;
            StringBuilder BChYOn2 = A2egSU.BChYOn("adn checkFreqctl ritId = ", str, " adnSlotId = ", str2, "  date = ");
            BChYOn2.append(date.getTime());
            BChYOn2.append(" item.getEffectiveTime() = ");
            BChYOn2.append(kdVar.u());
            com.bytedance.msdk.xj.kd.w.xj(str3, BChYOn2.toString());
            if (date.getTime() > kdVar.u()) {
                xj(u, kdVar.w(), 0);
                xj(u, kdVar.w(), y.xj(kdVar.hf()));
                com.bytedance.msdk.xj.kd.w.xj(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + kdVar.w());
            } else {
                if (kdVar.kd() >= kdVar.xj()) {
                    StringBuilder BChYOn3 = A2egSU.BChYOn("adn checkFreqctl 到了上线不可以展示 ritId = ", str, " adnSlotId = ", str2, " ruleId = ");
                    BChYOn3.append(kdVar.w());
                    BChYOn3.append(" count = ");
                    BChYOn3.append(kdVar.kd());
                    com.bytedance.msdk.xj.kd.w.xj(str3, BChYOn3.toString());
                    Map<String, Pair<String, String>> map = this.hf;
                    String AlLFFp2 = CtFAbx.AlLFFp(str, "_", str2);
                    String w = kdVar.w();
                    StringBuilder sb = new StringBuilder();
                    sb.append(kdVar.kd());
                    map.put(AlLFFp2, new Pair<>(w, sb.toString()));
                    return false;
                }
                StringBuilder BChYOn4 = A2egSU.BChYOn("adn checkFreqctl 未到上线可以展示 ritId = ", str, " adnSlotId = ", str2, " ruleId = ");
                BChYOn4.append(kdVar.w());
                BChYOn4.append(" count = ");
                BChYOn4.append(kdVar.kd());
                com.bytedance.msdk.xj.kd.w.xj(str3, BChYOn4.toString());
            }
        }
        return true;
    }

    private p() {
        this.hf = new ConcurrentHashMap();
    }

    public void hf(final String str, final String str2) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.f.p.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = p.xj;
                StringBuilder sb = new StringBuilder("adn addShowFreqctlCount ritId = ");
                sb.append(str);
                sb.append(" adnSlotId = ");
                com.bykv.vk.component.ttvideo.player.A2egSU.BI9f7h(sb, str2, str3);
                c u = p.this.u(str, str2);
                if (u == null || !u.f()) {
                    return;
                }
                for (kd kdVar : u.p()) {
                    if (kdVar.kd() < kdVar.xj()) {
                        p.this.xj(u, kdVar.w(), kdVar.kd() + 1);
                    }
                }
            }
        });
    }

    public static p xj() {
        return xj.xj;
    }

    public void hf(c cVar) {
        g.xj().hf(cVar);
    }

    public Pair<String, String> xj(String str, String str2) {
        return this.hf.get(str + "_" + str2);
    }

    public boolean xj(c cVar) {
        if (cVar == null) {
            return false;
        }
        c u = u(cVar.hf(), cVar.w());
        if (u == null) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(cVar.y())) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn freqctl version 为空 清空本地数据 ");
            delete(u.hf(), u.w());
            return false;
        }
        if (TextUtils.equals(u.y(), cVar.y())) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn freqctl version 一致 version = " + u.y() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj(xj, "adn freqctl version不一致，缓存新规则 old version = " + u.y() + "  new version " + cVar.y());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(c cVar, String str, int i) {
        f.xj().xj(cVar, str, i);
    }

    private void xj(c cVar, String str, long j) {
        f.xj().xj(cVar, str, j);
    }
}
