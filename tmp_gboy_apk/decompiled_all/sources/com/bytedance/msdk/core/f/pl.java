package com.bytedance.msdk.core.f;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    private static final String xj = "TTMediationSDK_pl";
    private Map<String, Long> hf;

    public static class xj {
        private static pl xj = new pl();

        static {
            pbfwuaH();
        }

        private static /* synthetic */ void pbfwuaH() {
            char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 204);
            }
            String str = new String(charArray);
            char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 204);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public void delete(String str, String str2) {
        tf.xj().xj(str, str2);
    }

    public d u(String str, String str2) {
        return tf.xj().hf(str, str2);
    }

    public boolean w(String str, String str2) {
        String str3 = xj;
        com.bytedance.msdk.xj.kd.w.xj(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        d u = u(str, str2);
        if (u != null && u.f() && u.pl()) {
            long time = new Date().getTime();
            long p = u.p();
            long d = u.d() + u.p();
            com.bytedance.msdk.xj.kd.w.xj(str3, "adn checkPacing currentTime = " + y.hf(time) + " showTime = " + y.hf(p) + " pacingBean.getPacing() = " + u.d() + " pacingTime = " + y.hf(d));
            if (time <= d) {
                this.hf.put(CtFAbx.AlLFFp(str, "_", str2), Long.valueOf(time - p));
                return false;
            }
        }
        return true;
    }

    private pl() {
        this.hf = new ConcurrentHashMap();
    }

    public static pl xj() {
        return xj.xj;
    }

    public void hf(final String str, final String str2) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.f.pl.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = pl.xj;
                StringBuilder sb = new StringBuilder("adn updateShowPacingTime ritId = ");
                sb.append(str);
                sb.append(" adnSlotId = ");
                A2egSU.BI9f7h(sb, str2, str3);
                d u = pl.this.u(str, str2);
                if (u == null || !u.f()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.xj.kd.w.xj(pl.xj, "adn updateShowPacingTime save time = " + y.hf(date.getTime()));
                pl.this.xj(str, str2, date.getTime());
            }
        });
    }

    public void hf(d dVar) {
        tf.xj().xj(dVar);
    }

    public long xj(String str, String str2) {
        Long l = this.hf.get(str + "_" + str2);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public boolean xj(d dVar) {
        if (dVar == null) {
            return false;
        }
        d u = u(dVar.hf(), dVar.w());
        if (u == null) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(dVar.tf())) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn pacing ruleId 为空 清空本地数据 ");
            delete(dVar.hf(), dVar.w());
            return false;
        }
        if (TextUtils.equals(u.tf(), dVar.tf())) {
            com.bytedance.msdk.xj.kd.w.xj(xj, "adn pacing ruleId 一致 ruleId = " + u.tf() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj(xj, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + u.tf() + "  new ruleId = " + dVar.tf());
        delete(dVar.hf(), dVar.w());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, long j) {
        tf.xj().xj(str, str2, j);
    }
}
