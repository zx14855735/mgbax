package com.bytedance.msdk.core.f;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g {
    private Map<String, Pair<String, String>> hf;
    private Map<String, Long> xj;

    public static class xj {
        private static g xj = new g();

        static {
            vZPjQR();
        }

        private static /* synthetic */ void vZPjQR() {
            char[] charArray = "yuw4}{w\u007f4xuc4ir\u007fvv4PtsXhs~}\u007f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 26);
            }
            String str = new String(charArray);
            char[] charArray2 = "yvstsn".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 26);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public void c(final String str) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.f.g.2
            @Override // java.lang.Runnable
            public void run() {
                A2egSU.BI9f7h(new StringBuilder("addShowFreqctlCount ritId = "), str, "TTMediationSDK_IntervalShowControl");
                c tf = g.this.tf(str);
                if (tf == null || !tf.f()) {
                    return;
                }
                for (kd kdVar : tf.p()) {
                    if (kdVar.kd() < kdVar.xj()) {
                        g.this.xj(tf, kdVar.w(), kdVar.kd() + 1);
                    }
                }
            }
        });
    }

    public void d(String str) {
        f.xj().xj(str);
    }

    public boolean f(String str) {
        c tf = tf(str);
        if (tf == null || !tf.f()) {
            return true;
        }
        for (kd kdVar : tf.p()) {
            Date date = new Date();
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + kdVar.u());
            if (date.getTime() > kdVar.u()) {
                xj(tf, kdVar.w(), 0);
                xj(tf, kdVar.w(), y.xj(kdVar.hf()));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + kdVar.w());
            } else {
                if (kdVar.kd() >= kdVar.xj()) {
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + kdVar.w() + " count = " + kdVar.kd());
                    Map<String, Pair<String, String>> map = this.hf;
                    String w = kdVar.w();
                    StringBuilder sb = new StringBuilder();
                    sb.append(kdVar.kd());
                    map.put(str, new Pair<>(w, sb.toString()));
                    return false;
                }
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + kdVar.w() + " count = " + kdVar.kd());
            }
        }
        return true;
    }

    public void hf() {
        this.hf = new ConcurrentHashMap();
        this.xj = new ConcurrentHashMap();
    }

    public d kd(String str) {
        return tf.xj().hf(str);
    }

    public c tf(String str) {
        return f.xj().hf(str);
    }

    public void u(String str) {
        tf.xj().xj(str);
    }

    public boolean w(String str) {
        d kd = kd(str);
        if (kd != null && kd.f() && kd.pl()) {
            long time = new Date().getTime();
            long p = kd.p();
            long d = kd.d() + kd.p();
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + y.hf(time) + " showTime = " + y.hf(p) + " pacingBean.getPacing() = " + kd.d() + " pacingTime = " + y.hf(d));
            if (time <= d) {
                this.xj.put(str, Long.valueOf(time - p));
                return false;
            }
        }
        return true;
    }

    public Pair<String, String> y(String str) {
        return this.hf.get(str);
    }

    private g() {
        hf();
    }

    public static g xj() {
        return xj.xj;
    }

    public void hf(final String str) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.f.g.1
            @Override // java.lang.Runnable
            public void run() {
                A2egSU.BI9f7h(new StringBuilder("updateShowPacingTime ritId = "), str, "TTMediationSDK_IntervalShowControl");
                d kd = g.this.kd(str);
                if (kd == null || !kd.f()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + y.hf(date.getTime()));
                g.this.xj(str, date.getTime());
            }
        });
    }

    public long xj(String str) {
        Long l = this.xj.get(str);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void hf(d dVar) {
        tf.xj().xj(dVar);
    }

    public void hf(c cVar) {
        f.xj().xj(cVar);
    }

    public boolean xj(d dVar) {
        if (dVar == null) {
            return false;
        }
        d kd = kd(dVar.hf());
        if (kd == null) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(dVar.tf())) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            u(dVar.u());
            return false;
        }
        if (TextUtils.equals(kd.tf(), dVar.tf())) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + kd.tf() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + kd.tf() + "  new ruleId = " + dVar.tf());
        StringBuilder sb = new StringBuilder("pacing 删除 ritId = ");
        sb.append(dVar.u());
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", sb.toString());
        u(dVar.u());
        return true;
    }

    public void xj(String str, long j) {
        tf.xj().xj(str, j);
    }

    public boolean xj(c cVar) {
        if (cVar == null) {
            return false;
        }
        c tf = tf(cVar.hf());
        if (tf == null) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(cVar.kd())) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            d(tf.hf());
            return false;
        }
        if (TextUtils.equals(tf.kd(), cVar.kd())) {
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + tf.kd() + "无需处理");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + tf.kd() + "  new version " + cVar.kd());
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
