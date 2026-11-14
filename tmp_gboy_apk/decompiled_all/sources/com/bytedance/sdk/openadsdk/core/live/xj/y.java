package com.bytedance.sdk.openadsdk.core.live.xj;

import JCv79N.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.am.f;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.s;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class y extends com.bytedance.sdk.openadsdk.core.live.xj.xj {
    protected String kd;
    protected String u;
    protected volatile SoftReference<ws> y;

    public interface xj {
        void xj(boolean z);
    }

    public static String hf(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return "LIVE_CELL".toLowerCase();
            case 5:
                return "LIVE_CARD".toLowerCase();
            default:
                return "NO_VALUE".toLowerCase();
        }
    }

    private int kd(ws wsVar) {
        String jv = wsVar.jv();
        Integer num = (Integer) ht.xj(wsVar.ke(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(jv)) {
            return 0;
        }
        try {
            return new JSONObject(jv).optInt("auth_reward_gold");
        } catch (Throwable th) {
            pl.w("TTLiveSDkBridge", th);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d A[Catch: Exception -> 0x0102, TryCatch #10 {Exception -> 0x0102, blocks: (B:51:0x00f8, B:53:0x011d, B:55:0x0127), top: B:50:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206 A[Catch: Exception -> 0x025a, TryCatch #5 {Exception -> 0x025a, blocks: (B:70:0x01df, B:72:0x0206, B:73:0x025c, B:75:0x028b, B:76:0x028e, B:78:0x029a, B:79:0x02a0), top: B:69:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028b A[Catch: Exception -> 0x025a, TryCatch #5 {Exception -> 0x025a, blocks: (B:70:0x01df, B:72:0x0206, B:73:0x025c, B:75:0x028b, B:76:0x028e, B:78:0x029a, B:79:0x02a0), top: B:69:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x029a A[Catch: Exception -> 0x025a, TryCatch #5 {Exception -> 0x025a, blocks: (B:70:0x01df, B:72:0x0206, B:73:0x025c, B:75:0x028b, B:76:0x028e, B:78:0x029a, B:79:0x02a0), top: B:69:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.os.Bundle w(android.content.Context r25, com.bytedance.sdk.openadsdk.core.ra.ws r26, java.util.Map<java.lang.String, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.xj.y.w(android.content.Context, com.bytedance.sdk.openadsdk.core.ra.ws, java.util.Map):android.os.Bundle");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj
    public void a_(String str) {
        this.kd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    @Deprecated
    public int b_(ws wsVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public String c() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj
    public boolean x_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(ws wsVar, w wVar, String str) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(Function<SparseArray<Object>, Object> function) {
        super.xj(function);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int hf(Context context, ws wsVar, Map<String, Object> map) {
        Object obj;
        long longValue;
        if (map != null) {
            try {
                obj = map.get("reward_countdown");
            } catch (Exception e) {
                pl.hf("TTLiveSDkBridge", e.toString());
            }
            if (obj instanceof Long) {
                longValue = ((Long) obj).longValue();
                if (context != null || wsVar == null) {
                    return 5;
                }
                if (!(context instanceof Activity)) {
                    return 7;
                }
                if (!dc.xj(wsVar)) {
                    return 5;
                }
                if (longValue < 0) {
                    return 8;
                }
                if (dc.hf(wsVar) == 1) {
                    return 9;
                }
                return xj(context, wsVar, map);
            }
        }
        longValue = 0;
        if (context != null) {
        }
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(final Context context, final ws wsVar, final Map<String, Object> map) {
        String str;
        final String str2;
        u(wsVar);
        if (!a_(wsVar)) {
            return 6;
        }
        pl.xj("TTLiveSDkBridge", "openLive key:" + wsVar.ke());
        if (map != null) {
            str = (String) map.get("event_tag");
        } else {
            str = "";
        }
        String str3 = str;
        final int vu = wsVar.vu();
        if (!y()) {
            xj(wsVar, str3, vu, 1, vu == 7 ? 1 : 2);
            return 1;
        }
        wsVar.ko();
        if (this.xj == null) {
            return 4;
        }
        this.hf = str3;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long currentTimeMillis = System.currentTimeMillis();
        if (kd() != 2 ? xj(wsVar, new xj() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.y.1
            @Override // com.bytedance.sdk.openadsdk.core.live.xj.y.xj
            public void xj(boolean z) {
                boolean z2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    y yVar = y.this;
                    yVar.xj(context, wsVar, vu, yVar.hf, (Map<String, Object>) map);
                    z2 = false;
                } else {
                    z2 = true;
                }
                am.xj().xj(wsVar, System.currentTimeMillis() - currentTimeMillis, z, z2);
            }
        }, true) : false) {
            s cc = wsVar.cc();
            if (cc != null) {
                long kd = cc.kd();
                if (kd > 0) {
                    str2 = str3;
                    f.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.y.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                y.this.xj(context, wsVar, vu, str2, (Map<String, Object>) map);
                            }
                        }
                    }, kd);
                } else {
                    str2 = str3;
                }
                if (cc.y() == 1 && com.bytedance.sdk.openadsdk.core.f.zg().u() != null) {
                    new com.bytedance.sdk.openadsdk.core.am.f().xj(new f.xj() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.y.3
                        @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
                        public void xj(boolean z) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
                        public void xj() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                y.this.xj(context, wsVar, vu, str2, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
                        public void xj(String str4) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                y.this.xj(context, wsVar, vu, str2, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return xj(context, wsVar, vu, str3, map);
    }

    public boolean xj(ws wsVar, final xj xjVar, boolean z) {
        s cc;
        if (this.kd == null || (cc = wsVar.cc()) == null || cc.w() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.kd.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int hf = cc.hf();
        boolean z2 = hf > 0;
        if (z) {
            z2 = hf == 3;
        }
        if (z2) {
            this.y = new SoftReference<>(wsVar);
            if (xj(new com.bytedance.sdk.openadsdk.core.live.hf.hf() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.y.4
                @Override // com.bytedance.sdk.openadsdk.core.live.hf.hf
                public void xj(Object obj) {
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        if (map.containsKey(PluginConstants.KEY_ERROR_CODE)) {
                            Object obj2 = map.get(PluginConstants.KEY_ERROR_CODE);
                            if (obj2 instanceof String) {
                                try {
                                    int parseInt = Integer.parseInt((String) obj2);
                                    r1 = parseInt == 1;
                                    pl.xj("TTLiveSDkBridge", "requestDyAuth result:".concat(String.valueOf(parseInt)));
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    xjVar.xj(r1);
                }
            }, hf == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xj(Context context, ws wsVar, int i, String str, Map<String, Object> map) {
        int i2;
        int i3;
        int i4;
        int i5;
        Object apply;
        int i6;
        pl.xj("TTLiveSDkBridge", "openLive key:" + wsVar.ko());
        if (this.xj != null) {
            int i7 = 0;
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(0).xj(Integer.class).xj(0, new en().xj("context", context).xj("bundle", w(context, wsVar, map))).hf());
            i2 = apply != null ? ((Integer) apply).intValue() : 0;
            this.hf = str;
            this.u = wsVar.ke();
            if (i2 == 0) {
                this.y = new SoftReference<>(wsVar);
                int xj2 = com.bytedance.sdk.openadsdk.core.live.kd.w.xj(map);
                if (xj2 == 101 || xj2 == 102) {
                    i2 |= xj2 << 8;
                } else if (xj(wsVar, xj2)) {
                    i7 = w(wsVar);
                    i = 7;
                    if (i7 == 0) {
                        try {
                            new com.bytedance.sdk.openadsdk.core.live.w.xj().xj(str).xj(context, wsVar);
                            i2 |= xj2 << 8;
                        } catch (Exception e) {
                            pl.xj(e);
                        }
                        i6 = 7;
                    } else {
                        i6 = 2;
                    }
                    i4 = i6;
                    i3 = i;
                    i5 = i7;
                }
            } else {
                i7 = 3;
            }
            i6 = i;
            i4 = i6;
            i3 = i;
            i5 = i7;
        } else {
            i2 = 4;
            i3 = i;
            i4 = i3;
            i5 = 1;
        }
        xj(wsVar, str, i3, i4, i5);
        return i2;
    }

    private void xj(JSONArray jSONArray, ws wsVar) {
        com.bytedance.sdk.openadsdk.core.live.u.xj xjVar;
        if (wsVar == null || jSONArray == null || (xjVar = (com.bytedance.sdk.openadsdk.core.live.u.xj) ht.xj(wsVar.ke(), com.bytedance.sdk.openadsdk.core.live.u.xj.class)) == null || xjVar.hf.isEmpty()) {
            return;
        }
        String ho = wsVar.ho();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(PointParamKey.TYPE);
                if (xjVar.hf.contains(ho + "_" + optString)) {
                    jSONObject.put("status", 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String xj(int i) {
        if (i == 7) {
            return A2egSU.f4122AlLFFp.A2egSU();
        }
        if (i == 8) {
            return A2egSU.f4123AmA8tU.A2egSU();
        }
        if (i == 5) {
            return A2egSU.f4124AzWtSf.A2egSU();
        }
        if (i == 9) {
            return A2egSU.f4125B25kr6.A2egSU();
        }
        if (i == 1) {
            return "ad_union_banner";
        }
        if (i == 3 || i == 4) {
            return "ad_union_topview";
        }
        if (i == 2) {
            return "ad_union_former_insert";
        }
        if (i == 6) {
            return "ad_union_patch";
        }
        return A2egSU.f4121AcNBzu.A2egSU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public boolean xj(ws wsVar) {
        return a_(wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(String str) {
        Object apply;
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        if (this.xj == null) {
            return 12;
        }
        if (!y()) {
            return 11;
        }
        Object lw = com.bytedance.sdk.openadsdk.core.f.zg().lw();
        if (lw == null) {
            return 13;
        }
        try {
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8).xj(Boolean.class).xj(0, new en().xj("context", lw).xj("scheme_uri", str)).hf());
            return apply != null ? ((Boolean) apply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(com.bytedance.sdk.openadsdk.core.live.hf.hf hfVar, boolean z) {
        Object apply;
        if (this.xj == null) {
            return 12;
        }
        if (!y()) {
            return 11;
        }
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("expand_method_name", "requestDyAuth");
        BI9f7h2.put("expand_method_param", new Object[]{com.bytedance.sdk.openadsdk.core.f.zg().lw(), hfVar, Boolean.valueOf(z)});
        apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Void.class).xj(0, BI9f7h2).hf());
        pl.xj("TTLiveSDkBridge", "requestDyAuth:" + apply + ", syncAuth = " + z);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(String str, ws wsVar, long j) {
        com.bytedance.sdk.openadsdk.core.video.w.xj.xj(str, wsVar, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(String str, boolean z) {
        if (this.xj != null && y()) {
            HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("expand_method_name", str);
            BI9f7h2.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
            this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Void.class).xj(0, BI9f7h2).hf());
        }
    }
}
