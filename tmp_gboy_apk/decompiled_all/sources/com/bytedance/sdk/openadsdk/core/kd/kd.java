package com.bytedance.sdk.openadsdk.core.kd;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static final Map<String, xj> xj = new ConcurrentHashMap();

    public static class xj {
        private int u;
        private long xj = 0;
        private int hf = 0;
        private int w = 0;

        public xj(f.w wVar) {
            this.u = wVar.p();
        }

        public void hf(f.w wVar) {
            this.w = 0;
            this.hf = 0;
            this.u = wVar.tf() + this.u;
            this.u = Math.min(wVar.p(), this.u);
        }

        public void xj(f.w wVar) {
            long currentTimeMillis = System.currentTimeMillis();
            if (wVar.y() > 0) {
                if (currentTimeMillis - this.xj < wVar.y()) {
                    this.hf++;
                    this.u = wVar.c() + this.u;
                }
                this.xj = currentTimeMillis;
            }
            if (wVar.f() > 0) {
                int i = this.w + 1;
                this.w = i;
                if (i > wVar.f()) {
                    this.u = wVar.d() + this.u;
                }
            }
        }

        public int xj(int i, f.w wVar) {
            int i2 = this.u - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> pl2 = wVar.pl();
            int i3 = -1;
            if (pl2 == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : pl2.entrySet()) {
                int intValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && intValue > i3) {
                    i3 = intValue;
                }
            }
            return i3;
        }

        public void xj(final int i, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final f.w wVar, final String str, final String str2) {
            am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.xj.1
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject.putOpt("rit", hfVar.u());
                    jSONObject.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("freq_count", Integer.valueOf(xj.this.hf));
                    jSONObject.putOpt("continuous_count", Integer.valueOf(xj.this.w));
                    jSONObject.putOpt("score", Integer.valueOf(xj.this.u));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(wVar.u()));
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("load_score_cache").hf(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }

    static {
        FrJnxZ();
    }

    private static /* synthetic */ void FrJnxZ() {
        char[] charArray = "ëçå¦ïéåí¦êçñ¦ûàíää¦ÂæáÊúáìïí".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        String str = new String(charArray);
        char[] charArray2 = "ëäáæáü".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 136);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj(String str, f.w wVar) {
        if (TextUtils.isEmpty(str)) {
            return new xj(wVar);
        }
        Map<String, xj> map = xj;
        xj xjVar = map.get(str);
        if (xjVar != null) {
            return xjVar;
        }
        xj xjVar2 = new xj(wVar);
        map.put(str, xjVar2);
        return xjVar2;
    }
}
