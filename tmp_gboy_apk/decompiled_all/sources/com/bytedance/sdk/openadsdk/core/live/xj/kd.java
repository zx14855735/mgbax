package com.bytedance.sdk.openadsdk.core.live.xj;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends xj {
    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int b_(ws wsVar) {
        Object apply;
        if (this.xj != null) {
            long hf = hf(wsVar);
            if (hf == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", hf);
                apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 2).xj(1, bundle).hf());
                if (apply instanceof Integer) {
                    return ((Integer) apply).intValue();
                }
            } catch (Throwable th) {
                pl.hf("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public String c() {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        try {
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 4).hf());
            if (apply instanceof String) {
                return (String) apply;
            }
            return null;
        } catch (Throwable th) {
            pl.hf("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public JSONObject f() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int hf(Context context, ws wsVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int kd() {
        Object apply;
        boolean z = false;
        if (this.xj != null) {
            try {
                apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 3).hf());
                if (apply instanceof Boolean) {
                    z = ((Boolean) apply).booleanValue();
                }
            } catch (Throwable th) {
                pl.hf("TTLiveSDkBridge", th);
            }
        }
        return z ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void u() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj
    public boolean x_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(com.bytedance.sdk.openadsdk.core.live.hf.hf hfVar, boolean z) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public boolean y() {
        return hf() == 2;
    }

    private String hf(ws wsVar, Map<String, Object> map) {
        if (wsVar == null) {
            return "";
        }
        try {
            Uri xj = com.bytedance.sdk.openadsdk.core.live.w.xj(Uri.parse("sslocal://webcast_room"), xj(wsVar, map));
            pl.xj("TTLiveSDkBridge", "link: " + xj.toString());
            return xj.toString();
        } catch (Throwable th) {
            pl.xj(th);
            pl.u("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(com.bytedance.sdk.openadsdk.qt.u uVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(String str, boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int xj(android.content.Context r10, com.bytedance.sdk.openadsdk.core.ra.ws r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r9 = this;
            r0 = -1
            if (r10 == 0) goto La3
            if (r11 != 0) goto L7
            goto La3
        L7:
            boolean r1 = r9.a_(r11)
            java.lang.String r2 = "TTLiveSDkBridge"
            if (r1 != 0) goto L15
            java.lang.String r10 = "mata has not le property"
            com.bytedance.sdk.component.utils.pl.xj(r2, r10)
            return r0
        L15:
            if (r12 == 0) goto L21
            java.lang.String r0 = "event_tag"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L1f:
            r5 = r0
            goto L24
        L21:
            java.lang.String r0 = ""
            goto L1f
        L24:
            int r6 = r11.vu()
            boolean r0 = r9.y()
            r1 = 1
            if (r0 != 0) goto L3d
            r10 = 7
            if (r6 != r10) goto L34
            r8 = 1
            goto L36
        L34:
            r10 = 2
            r8 = 2
        L36:
            r7 = 1
            r3 = r9
            r4 = r11
            r3.xj(r4, r5, r6, r7, r8)
            return r1
        L3d:
            r3 = r9
            r4 = r11
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r11 = r3.xj
            if (r11 == 0) goto L9d
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r11 = r3.xj
            r0 = 0
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            com.bytedance.sdk.openadsdk.zg.u r1 = com.bykv.vk.component.ttvideo.player.A2egSU.AZOQYO(r0, r1)
            java.lang.String r12 = r9.hf(r4, r12)
            com.bytedance.sdk.openadsdk.zg.u r12 = r1.xj(r0, r12)
            android.util.SparseArray r12 = r12.hf()
            java.lang.Object r11 = P8ccfD.AaHO0E.ASJ6gh(r11, r12)
            if (r11 == 0) goto L66
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r1 = r11
            goto L67
        L66:
            r1 = 0
        L67:
            if (r1 != 0) goto L8c
            boolean r11 = r9.xj(r4, r0)
            if (r11 == 0) goto L8a
            int r11 = r9.w(r4)
            if (r11 != 0) goto L88
            com.bytedance.sdk.openadsdk.core.live.w.xj r12 = new com.bytedance.sdk.openadsdk.core.live.w.xj     // Catch: java.lang.Exception -> L82
            r12.<init>()     // Catch: java.lang.Exception -> L82
            com.bytedance.sdk.openadsdk.core.live.w.xj r12 = r12.xj(r5)     // Catch: java.lang.Exception -> L82
            r12.xj(r10, r4)     // Catch: java.lang.Exception -> L82
            goto L88
        L82:
            r0 = move-exception
            r10 = r0
            com.bytedance.sdk.component.utils.pl.xj(r10)
            goto L8c
        L88:
            r10 = r11
            goto L8d
        L8a:
            r10 = 0
            goto L8d
        L8c:
            r10 = 3
        L8d:
            if (r1 != 0) goto L92
            java.lang.String r11 = "le openliv succ"
            goto L98
        L92:
            java.lang.String r11 = "callR: "
            java.lang.String r11 = ADYaiT.CtFAbx.ARc23Z(r1, r11)
        L98:
            com.bytedance.sdk.component.utils.pl.xj(r2, r11)
            r8 = r10
            goto L9e
        L9d:
            r8 = 1
        L9e:
            r7 = r6
            r3.xj(r4, r5, r6, r7, r8)
            return r1
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.xj.kd.xj(android.content.Context, com.bytedance.sdk.openadsdk.core.ra.ws, java.util.Map):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(String str, ws wsVar, long j) {
        try {
            if (this.xj == null) {
                return;
            }
            Map<String, String> xj = xj(wsVar, (Map<String, Object>) null);
            Map<String, String> xj2 = com.bytedance.sdk.openadsdk.core.video.w.xj.xj(pz.getContext());
            xj2.put("room_id", xj.get("room_id"));
            xj2.put("anchor_id", xj.get("owner_open_id"));
            xj2.put("enter_from_merge", xj.get("enter_from_merge"));
            xj2.put("enter_method", xj.get("enter_method"));
            xj2.put("action_type", "click");
            xj2.put(PointParamKey.REQUEST_ID, xj.get(PointParamKey.REQUEST_ID));
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            xj2.put(MediationConstant.EXTRA_DURATION, sb.toString());
            xj2.put("is_other_channel", "union_ad");
            xj2.put("IESLiveEffectAdTrackExtraServiceKey", xj.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : xj2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(4).xj(Void.class).xj(0, str).xj(1, jSONObject).hf());
        } catch (Throwable th) {
            if (pl.w()) {
                pl.w("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int hf() {
        Object apply;
        if (this.xj != null) {
            try {
                apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 1).hf());
                if (apply instanceof Integer) {
                    return ((Integer) apply).intValue();
                }
            } catch (Throwable th) {
                pl.hf("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    public Map<String, String> xj(ws wsVar, Map<String, Object> map) {
        Object apply;
        Object apply2;
        HashMap hashMap = new HashMap();
        if (wsVar != null) {
            hashMap.put("room_id", wsVar.wr());
            if (this.xj != null) {
                int f = wo.f(wsVar);
                apply = this.xj.apply(A2egSU.AZOQYO(1, String.class).xj(0, Integer.valueOf(f)).hf());
                apply2 = this.xj.apply(A2egSU.AZOQYO(2, String.class).xj(0, Integer.valueOf(f)).xj(1, Boolean.valueOf(com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar))).hf());
                hashMap.put("enter_from_merge", (String) apply);
                hashMap.put("enter_method", (String) apply2);
            }
            hashMap.put("host", "aweme");
            hashMap.put("is_other_channel", "union_ad");
            String xj = xj(wsVar, wsVar.vo(), map);
            if (!TextUtils.isEmpty(xj)) {
                hashMap.put("ecom_live_params", xj);
            }
            zg yt = wsVar.yt();
            if (yt != null && !TextUtils.isEmpty(yt.hf())) {
                try {
                    Uri parse = Uri.parse(yt.hf());
                    JSONObject jSONObject = new JSONObject(parse.getQueryParameter("ad_data_params"));
                    String optString = jSONObject.optString("log_extra");
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                        jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.w.xj(parse, n.l));
                        jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.w.xj(parse, "gd_label"));
                        jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.w.xj(parse, "union_user_id"));
                        jSONObject3.put("ad_event_app_siteid", f.zg().pz());
                        jSONObject3.put("ad_event_live_type", "1");
                        hashMap.put("log_extra", jSONObject3.toString());
                        jSONObject2.put("log_extra", jSONObject3.toString());
                    }
                    String optString2 = jSONObject.optString("cid");
                    jSONObject2.put("creativeID", optString2);
                    hashMap.put("creative_id", optString2);
                    hashMap.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                    String xj2 = com.bytedance.sdk.openadsdk.core.live.w.xj(parse, "owner_open_id");
                    if (TextUtils.isEmpty(xj2)) {
                        xj2 = com.bytedance.sdk.openadsdk.core.live.w.xj(parse, "user_id");
                    }
                    hashMap.put("owner_open_id", xj2);
                    String xj3 = com.bytedance.sdk.openadsdk.core.live.w.xj(parse, "pangle_live_room_data");
                    if (!TextUtils.isEmpty(xj3)) {
                        hashMap.put("pangle_live_room_data", xj3);
                    }
                    hashMap.put(PointParamKey.REQUEST_ID, com.bytedance.sdk.openadsdk.core.live.w.xj(parse, PointParamKey.REQUEST_ID));
                    return hashMap;
                } catch (Exception e) {
                    pl.xj(e);
                }
            }
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public boolean xj(ws wsVar) {
        return a_(wsVar) && this.xj != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(final String str, final ws wsVar, final long j) {
        com.bytedance.sdk.openadsdk.x.c.hf(new d("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.xj.kd.1
            @Override // java.lang.Runnable
            public void run() {
                kd.this.hf(str, wsVar, j);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(ws wsVar, w wVar, String str) {
        Object apply;
        if (wsVar == null || TextUtils.isEmpty(wsVar.wn()) || this.xj == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", wsVar.wn());
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 5).xj(1, bundle).hf());
            if (apply == null) {
                return 4;
            }
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(String str) {
        Object apply;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Object.class).xj(0, 6).xj(1, bundle).hf());
            if (apply instanceof Integer) {
                return ((Integer) apply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
