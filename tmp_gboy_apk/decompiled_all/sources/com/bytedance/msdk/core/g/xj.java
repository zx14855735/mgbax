package com.bytedance.msdk.core.g;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.msdk.core.hf;
import com.bytedance.msdk.core.tf.c;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.g;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.ra;
import com.bytedance.msdk.f.y;
import com.bytedance.msdk.w.f.w;
import com.bytedance.msdk.xj.xj.u;
import com.bytedance.sdk.component.d.hf.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;

    /* renamed from: com.bytedance.msdk.core.g.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0057xj {
        void xj(com.bytedance.msdk.api.xj xjVar);

        void xj(c cVar);
    }

    private JSONObject hf() {
        if (TextUtils.isEmpty(hf.hf().g())) {
            return null;
        }
        try {
            return new JSONObject(hf.hf().g());
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    private void w(JSONObject jSONObject) {
        if (y.xj(hf.getContext()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r0.xj);
                jSONObject2.put("longitude", r0.hf);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static int xj(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private JSONObject hf(com.bytedance.msdk.api.xj.hf hfVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int ht = hfVar.ht();
            jSONObject.put(f.f13353a, hfVar.ra());
            jSONObject.put("adtype", ht);
            jSONObject.put("pos", xj(ht));
            xj(jSONObject, "accepted_size", hfVar.et(), hfVar.io());
            jSONObject.put("is_support_dpl", hfVar.ai());
            int x = hfVar.x();
            int i = 1;
            if (x <= 0) {
                x = 1;
            }
            if (x > 3) {
                x = 3;
            }
            if (ht != 7 && ht != 8) {
                i = x;
            }
            jSONObject.put(PointParamKey.AD_COUNT, i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String xj(Map<String, com.bytedance.msdk.w.xj.xj> map, Context context, com.bytedance.msdk.api.xj.hf hfVar, tf tfVar, Map<String, Object> map2) {
        if (hfVar != null && tfVar != null) {
            if (TextUtils.equals("baidu", tfVar.qt())) {
                com.bytedance.msdk.w.y.hf.hf xj2 = com.bytedance.msdk.w.y.hf.hf.xj(tfVar, (com.bytedance.msdk.w.hf.hf.xj) null);
                com.bytedance.msdk.w.xj.xj xj3 = w.xj(xj2, hfVar, (com.bytedance.msdk.w.xj.hf) null);
                if (xj3 == null) {
                    return "";
                }
                try {
                    map.put(String.format("%1$s_%2$s_%3$s", hfVar.xj(), hfVar.ra(), tfVar.yo()), xj3);
                    return xj3.xj(context, xj2, hfVar);
                } catch (Throwable unused) {
                    return "";
                }
            }
            return com.bytedance.msdk.y.hf.xj.xj(map2, tfVar.qt());
        }
        com.bytedance.msdk.xj.kd.w.hf("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
        return "";
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.msdk.core.xj.p().pl());
            jSONObject.put("name", com.bytedance.msdk.core.xj.p().yo());
            hf(jSONObject);
            w(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void hf(JSONObject jSONObject) {
        try {
            jSONObject.put(n.p, l.xj());
            jSONObject.put("version_code", l.hf());
            jSONObject.put("version", l.w());
        } catch (Exception unused) {
        }
    }

    private String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.bytedance.msdk.api.u.xj.hf.y.xj xj2 = com.bytedance.msdk.y.hf.xj.xj(str);
            if (xj2 != null) {
                return xj2.w();
            }
            u xj3 = com.bytedance.msdk.y.hf.hf.xj().xj(str);
            if (xj3 == null) {
                return null;
            }
            return xj3.hf();
        } catch (Throwable th) {
            pl.xj(th);
            com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    public void xj(Map<String, com.bytedance.msdk.w.xj.xj> map, Context context, com.bytedance.msdk.api.xj.hf hfVar, List<tf> list, List<com.bytedance.msdk.hf.w> list2, com.bytedance.msdk.core.tf.hf hfVar2, int i, boolean z, final InterfaceC0057xj interfaceC0057xj) {
        final JSONObject jSONObject = new JSONObject();
        final long currentTimeMillis = System.currentTimeMillis();
        kd hf = com.bytedance.msdk.u.hf.xj().hf().hf();
        hf.xj(com.bytedance.msdk.core.w.w());
        String f = com.bytedance.msdk.core.xj.p().f();
        if (!TextUtils.isEmpty(f)) {
            hf.hf("X-Tt-Env", f);
            hf.hf("x-use-ppe", "1");
        }
        hf.hf("User-Agent", com.bytedance.msdk.hf.hf.xj);
        boolean kd = hf.hf().kd();
        final boolean z2 = !kd;
        if (!kd) {
            hf.hf("x-pglcypher", "4");
            hf.xj("application/octet-stream", l.hf(xj(map, context, hfVar, list, list2, hfVar2, i, z, jSONObject, true)));
        } else {
            hf.w(xj(map, context, hfVar, list, list2, hfVar2, i, z, jSONObject, false));
        }
        hf.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.msdk.core.g.xj.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar3) {
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                if (hfVar3 == null) {
                    com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                    xj.this.xj(-1, "response is null", interfaceC0057xj, z2);
                    return;
                }
                int xj2 = hfVar3.xj();
                if (l.xj(hfVar3)) {
                    String xj3 = l.xj(hfVar3.tf());
                    if (TextUtils.isEmpty(xj3)) {
                        com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        xj.this.xj(xj2, "response is empty", interfaceC0057xj, z2);
                        return;
                    }
                    try {
                        xj.this.xj(new JSONObject(xj3), jSONObject, interfaceC0057xj, z2, currentTimeMillis);
                        return;
                    } catch (Throwable th) {
                        xj.this.xj(81014, th.getMessage(), interfaceC0057xj, z2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(hfVar3.u())) {
                    com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    xj.this.xj(xj2, "response is empty", interfaceC0057xj, z2);
                    return;
                }
                try {
                    JSONObject jSONObject4 = new JSONObject(hfVar3.u());
                    int optInt = jSONObject4.optInt("cypher", -1);
                    String optString = jSONObject4.optString("message");
                    if (optInt < 0 || TextUtils.isEmpty(optString)) {
                        int optInt2 = jSONObject4.optInt("status_code", -2);
                        int optInt3 = jSONObject4.optInt(MediationConstant.KEY_REASON, -2);
                        String optString2 = jSONObject4.optString("desc");
                        com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding onResponse error ");
                        xj.this.xj(optInt2, "reason is " + optInt3 + "，desc is " + optString2, interfaceC0057xj, z2);
                        return;
                    }
                    if (optInt == 2) {
                        String xj4 = l.xj(optString);
                        if (!TextUtils.isEmpty(xj4)) {
                            try {
                                jSONObject3 = new JSONObject(xj4);
                            } catch (Throwable th2) {
                                com.bytedance.msdk.xj.kd.w.xj("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                            }
                            jSONObject2 = jSONObject3;
                        }
                        jSONObject3 = null;
                        jSONObject2 = jSONObject3;
                    } else {
                        if (optInt == 1) {
                            String hf2 = com.bytedance.msdk.f.xj.hf(optString, com.bytedance.msdk.f.hf.xj());
                            if (!TextUtils.isEmpty(hf2)) {
                                try {
                                    jSONObject3 = new JSONObject(hf2);
                                } catch (Throwable th3) {
                                    com.bytedance.msdk.xj.kd.w.xj("ServerBiddingHelper", "server bidding data error: ", th3);
                                }
                                jSONObject2 = jSONObject3;
                            }
                        } else if (optInt == 0) {
                            jSONObject2 = new JSONObject(optString);
                        }
                        jSONObject3 = null;
                        jSONObject2 = jSONObject3;
                    }
                    xj.this.xj(jSONObject2, jSONObject, interfaceC0057xj, z2, currentTimeMillis);
                } catch (Throwable th4) {
                    xj.this.xj(81006, th4.getMessage(), interfaceC0057xj, z2);
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                int i2 = iOException instanceof SocketTimeoutException ? 44405 : 44404;
                com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i2)));
                xj.this.xj(i2, "request fail " + iOException.getMessage(), interfaceC0057xj, z2);
            }
        });
    }

    private void xj(boolean z, long j) {
        ai.xj(z ? "v4Enc_exchange" : "v2Enc_exchange", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str, InterfaceC0057xj interfaceC0057xj, boolean z) {
        ai.xj(z ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i + "，msg = " + str);
        xj(interfaceC0057xj, new com.bytedance.msdk.api.xj(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0057xj interfaceC0057xj, boolean z, long j) {
        String str;
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        com.bytedance.msdk.core.tf.f fVar;
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject == null) {
            com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
            xj(-1, "data is null", interfaceC0057xj, z);
            return;
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            xj(-1, "data.string is null", interfaceC0057xj, z);
            return;
        }
        c cVar = new c();
        cVar.xj(jSONObject2);
        cVar.w(jSONObject.optString(PointParamKey.REQUEST_ID));
        cVar.kd(jSONObject.optString("server_bidding_extra"));
        cVar.u(jSONObject.optString("server_request_id"));
        com.bytedance.msdk.core.tf.f fVar2 = new com.bytedance.msdk.core.tf.f();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("winner");
        String str5 = "price";
        if (optJSONObject2 == null) {
            str = "ServerBiddingHelper";
        } else {
            fVar2.hf(optJSONObject2.optInt("req_bidding_type"));
            fVar2.w(optJSONObject2.optString("price"));
            fVar2.u(optJSONObject2.optString("load_price"));
            fVar2.tf(optJSONObject2.optString("adm"));
            fVar2.kd(optJSONObject2.optString("name"));
            fVar2.c(optJSONObject2.optString(PluginConstants.KEY_APP_ID));
            fVar2.y(optJSONObject2.optString("slot_id"));
            str = "ServerBiddingHelper";
            fVar2.f(optJSONObject2.optString("win_callback", null));
            fVar2.d(optJSONObject2.optString("fail_callback", null));
            fVar2.xj(optJSONObject2.optInt("pricing_type", 1));
            cVar.xj(fVar2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("winners");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            str2 = str;
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    fVar = new com.bytedance.msdk.core.tf.f();
                    optJSONObject = optJSONArray.optJSONObject(i);
                    jSONArray = optJSONArray;
                } catch (Throwable th) {
                    th = th;
                    jSONArray = optJSONArray;
                }
                try {
                    fVar.hf(optJSONObject.optInt("req_bidding_type"));
                    fVar.w(optJSONObject.optString(str5));
                    fVar.u(optJSONObject.optString("load_price"));
                    fVar.tf(optJSONObject.optString("adm"));
                    fVar.kd(optJSONObject.optString("name"));
                    fVar.c(optJSONObject.optString(PluginConstants.KEY_APP_ID));
                    fVar.y(optJSONObject.optString("slot_id"));
                    str3 = str5;
                    try {
                        fVar.f(optJSONObject.optString("win_callback", null));
                        fVar.d(optJSONObject.optString("fail_callback", null));
                        fVar.xj(optJSONObject.optString("m_aid", null));
                        fVar.hf(optJSONObject.optString("ad_extra", null));
                        try {
                            fVar.xj(optJSONObject.optInt("pricing_type", 1));
                            arrayList.add(fVar);
                            str4 = str;
                        } catch (Throwable th2) {
                            th = th2;
                            str4 = str;
                            com.bytedance.msdk.xj.kd.w.xj(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                            i++;
                            str = str4;
                            str5 = str3;
                            optJSONArray = jSONArray;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str4 = str;
                        com.bytedance.msdk.xj.kd.w.xj(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        i++;
                        str = str4;
                        str5 = str3;
                        optJSONArray = jSONArray;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str3 = str5;
                    str4 = str;
                    com.bytedance.msdk.xj.kd.w.xj(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                    i++;
                    str = str4;
                    str5 = str3;
                    optJSONArray = jSONArray;
                }
                i++;
                str = str4;
                str5 = str3;
                optJSONArray = jSONArray;
            }
            str2 = str;
            cVar.xj(arrayList);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("auto_detail");
        if (optJSONObject3 != null) {
            cVar.xj(optJSONObject3.optString("est_price"));
            cVar.xj(optJSONObject3.optInt("est_price_source"));
            cVar.hf(optJSONObject3.optString("bidding_ecpm"));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("waterfall");
        if (optJSONObject4 != null) {
            c.xj xjVar = new c.xj();
            xjVar.xj(optJSONObject4.optString("version"));
            JSONArray optJSONArray2 = optJSONObject4.optJSONArray("adn_rit_conf");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    try {
                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i2);
                        tf tfVar = new tf();
                        tfVar.w(optJSONObject5.optString(MediationConstant.EXTRA_ADN_NAME));
                        tfVar.kd(optJSONObject5.optString("adn_slot_id"));
                        arrayList2.add(tfVar);
                    } catch (Throwable th5) {
                        com.bytedance.msdk.xj.kd.w.xj(str2, "new waterfallListJson parse error: " + th5.toString());
                    }
                }
            }
            xjVar.xj(arrayList2);
            cVar.xj(xjVar);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
        ArrayList arrayList3 = new ArrayList();
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                try {
                    JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i3);
                    com.bytedance.msdk.core.tf.y yVar = new com.bytedance.msdk.core.tf.y();
                    yVar.xj(optJSONObject6.optString("name"));
                    yVar.hf(optJSONObject6.optString("slot_id"));
                    yVar.xj(optJSONObject6.optInt("req_bidding_type"));
                    yVar.hf(optJSONObject6.optInt("error_code"));
                    yVar.w(optJSONObject6.optString("error_msg"));
                    yVar.u(optJSONObject6.optString("level_tag"));
                    arrayList3.add(yVar);
                } catch (Throwable th6) {
                    com.bytedance.msdk.xj.kd.w.xj(str2, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                }
            }
            cVar.hf(arrayList3);
        }
        xj(interfaceC0057xj, cVar);
        xj(z, currentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:6:0x000e, B:8:0x0022, B:12:0x002b, B:16:0x007e, B:18:0x0088, B:21:0x00a4, B:23:0x00aa, B:29:0x003c, B:32:0x0057, B:38:0x006c, B:40:0x0074, B:41:0x00b0, B:35:0x0065, B:26:0x0035), top: B:5:0x000e, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:6:0x000e, B:8:0x0022, B:12:0x002b, B:16:0x007e, B:18:0x0088, B:21:0x00a4, B:23:0x00aa, B:29:0x003c, B:32:0x0057, B:38:0x006c, B:40:0x0074, B:41:0x00b0, B:35:0x0065, B:26:0x0035), top: B:5:0x000e, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(com.bytedance.msdk.core.tf.c r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "ServerBiddingHelper"
            if (r4 != 0) goto L6
            goto Laf
        L6:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Le
            goto Laf
        Le:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L52
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "cypher"
            r2 = -1
            int r5 = r1.optInt(r5, r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "message"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> L52
            if (r5 < 0) goto Lb0
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L52
            if (r2 != 0) goto Lb0
            r2 = 2
            if (r5 != r2) goto L54
            java.lang.String r5 = com.bytedance.msdk.f.l.xj(r1)     // Catch: java.lang.Throwable -> L52
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L7b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3b
            goto L7c
        L3b:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = ">>>>> m_meta data error: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L52
            r1.append(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L52
            com.bytedance.msdk.xj.kd.w.xj(r0, r5)     // Catch: java.lang.Throwable -> L52
            goto L7b
        L52:
            r4 = move-exception
            goto Lb6
        L54:
            r2 = 1
            if (r5 != r2) goto L72
            java.lang.String r5 = com.bytedance.msdk.f.hf.xj()     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = com.bytedance.msdk.f.xj.hf(r1, r5)     // Catch: java.lang.Throwable -> L52
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L7b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L6b
            goto L7c
        L6b:
            r5 = move-exception
            java.lang.String r1 = "m_meta data error: "
            com.bytedance.msdk.xj.kd.w.xj(r0, r1, r5)     // Catch: java.lang.Throwable -> L52
            goto L7b
        L72:
            if (r5 != 0) goto L7b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L52
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L52
            r1 = r5
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto Laa
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L52
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r5 != 0) goto La4
            java.lang.String r5 = "request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.w(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "server_bidding_extra"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.kd(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "server_request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.u(r5)     // Catch: java.lang.Throwable -> L52
            goto Laf
        La4:
            java.lang.String r4 = "m_meta..data.string is null "
            com.bytedance.msdk.xj.kd.w.u(r0, r4)     // Catch: java.lang.Throwable -> L52
            goto Laf
        Laa:
            java.lang.String r4 = "m_meta...data is null"
            com.bytedance.msdk.xj.kd.w.u(r0, r4)     // Catch: java.lang.Throwable -> L52
        Laf:
            return
        Lb0:
            java.lang.String r4 = "m_meta onResponse error "
            com.bytedance.msdk.xj.kd.w.u(r0, r4)     // Catch: java.lang.Throwable -> L52
            return
        Lb6:
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "m_meta onResponse throwable ："
            java.lang.String r4 = r5.concat(r4)
            com.bytedance.msdk.xj.kd.w.u(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.g.xj.xj(com.bytedance.msdk.core.tf.c, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:9:0x0019, B:11:0x002d, B:15:0x0037, B:19:0x008a, B:21:0x0094, B:23:0x0109, B:25:0x010f, B:31:0x0048, B:33:0x0063, B:39:0x0078, B:41:0x0080, B:42:0x0115, B:36:0x0071, B:28:0x0041), top: B:8:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010f A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:9:0x0019, B:11:0x002d, B:15:0x0037, B:19:0x008a, B:21:0x0094, B:23:0x0109, B:25:0x010f, B:31:0x0048, B:33:0x0063, B:39:0x0078, B:41:0x0080, B:42:0x0115, B:36:0x0071, B:28:0x0041), top: B:8:0x0019, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.msdk.core.tf.f xj(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.g.xj.xj(org.json.JSONObject):com.bytedance.msdk.core.tf.f");
    }

    public void xj(String str, InterfaceC0057xj interfaceC0057xj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                c cVar = new c();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                String optString = jSONObject.optString("m_meta");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            com.bytedance.msdk.core.tf.f xj2 = xj(optJSONArray.optJSONObject(i));
                            if (xj2 != null) {
                                arrayList.add(xj2);
                            }
                        } catch (Throwable th) {
                            com.bytedance.msdk.xj.kd.w.xj("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    cVar.xj(arrayList);
                }
                xj(cVar, optString);
                xj(interfaceC0057xj, cVar);
                return;
            } catch (Throwable th2) {
                String th3 = th2.toString();
                com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(th3)));
                if (TextUtils.isEmpty(th3)) {
                    th3 = com.bytedance.msdk.api.xj.xj(-1);
                }
                xj(interfaceC0057xj, new com.bytedance.msdk.api.xj(-1, th3));
                return;
            }
        }
        com.bytedance.msdk.xj.kd.w.u("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        xj(interfaceC0057xj, new com.bytedance.msdk.api.xj(-1, "response is invalid"));
    }

    private void xj(final InterfaceC0057xj interfaceC0057xj, final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.g.xj.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0057xj interfaceC0057xj2 = interfaceC0057xj;
                if (interfaceC0057xj2 != null) {
                    interfaceC0057xj2.xj(xjVar);
                }
            }
        });
    }

    private void xj(final InterfaceC0057xj interfaceC0057xj, final c cVar) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.g.xj.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0057xj interfaceC0057xj2 = interfaceC0057xj;
                if (interfaceC0057xj2 != null) {
                    interfaceC0057xj2.xj(cVar);
                }
            }
        });
    }

    private JSONObject xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    public String xj(Map<String, com.bytedance.msdk.w.xj.xj> map, Context context, com.bytedance.msdk.api.xj.hf hfVar, List<tf> list, com.bytedance.msdk.core.tf.hf hfVar2, int i, boolean z, JSONObject jSONObject) {
        if (context == null) {
            return "";
        }
        return xj(map, context, hfVar, list, null, hfVar2, i, z, jSONObject, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:41|42|(9:43|44|45|46|47|48|49|50|51)|(3:119|120|(21:122|123|124|125|(1:127)|128|59|60|61|62|(2:64|(1:66))(2:112|(1:114))|67|68|(3:70|(2:(1:73)(1:75)|74)|76)(5:93|94|95|96|(11:(1:101)(1:109)|102|103|104|105|78|79|80|81|(2:83|84)(1:85)|37))|77|78|79|80|81|(0)(0)|37))|53|54|55|(1:57)|58|59|60|61|62|(0)(0)|67|68|(0)(0)|77|78|79|80|81|(0)(0)|37) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02cf, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d0, code lost:
    
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0410, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x052f A[Catch: Exception -> 0x048b, TryCatch #1 {Exception -> 0x048b, blocks: (B:154:0x047c, B:156:0x0481, B:157:0x0490, B:159:0x04c7, B:161:0x04cd, B:162:0x04ea, B:166:0x052f, B:168:0x0532, B:170:0x053c, B:171:0x0541, B:173:0x0551, B:174:0x0555, B:176:0x055b, B:178:0x0563, B:180:0x0575, B:182:0x0588, B:183:0x058f, B:185:0x05c7, B:186:0x05d0, B:189:0x057e, B:193:0x05e7, B:213:0x0528), top: B:153:0x047c }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x053c A[Catch: Exception -> 0x048b, TryCatch #1 {Exception -> 0x048b, blocks: (B:154:0x047c, B:156:0x0481, B:157:0x0490, B:159:0x04c7, B:161:0x04cd, B:162:0x04ea, B:166:0x052f, B:168:0x0532, B:170:0x053c, B:171:0x0541, B:173:0x0551, B:174:0x0555, B:176:0x055b, B:178:0x0563, B:180:0x0575, B:182:0x0588, B:183:0x058f, B:185:0x05c7, B:186:0x05d0, B:189:0x057e, B:193:0x05e7, B:213:0x0528), top: B:153:0x047c }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0551 A[Catch: Exception -> 0x048b, TryCatch #1 {Exception -> 0x048b, blocks: (B:154:0x047c, B:156:0x0481, B:157:0x0490, B:159:0x04c7, B:161:0x04cd, B:162:0x04ea, B:166:0x052f, B:168:0x0532, B:170:0x053c, B:171:0x0541, B:173:0x0551, B:174:0x0555, B:176:0x055b, B:178:0x0563, B:180:0x0575, B:182:0x0588, B:183:0x058f, B:185:0x05c7, B:186:0x05d0, B:189:0x057e, B:193:0x05e7, B:213:0x0528), top: B:153:0x047c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02bb A[Catch: all -> 0x02cf, TryCatch #9 {all -> 0x02cf, blocks: (B:62:0x02b2, B:64:0x02bb, B:66:0x02c5, B:67:0x02de, B:70:0x02fc, B:74:0x0313, B:93:0x036c, B:114:0x02d7), top: B:61:0x02b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02fc A[Catch: all -> 0x02cf, TRY_ENTER, TryCatch #9 {all -> 0x02cf, blocks: (B:62:0x02b2, B:64:0x02bb, B:66:0x02c5, B:67:0x02de, B:70:0x02fc, B:74:0x0313, B:93:0x036c, B:114:0x02d7), top: B:61:0x02b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0459 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x036c A[Catch: all -> 0x02cf, TRY_LEAVE, TryCatch #9 {all -> 0x02cf, blocks: (B:62:0x02b2, B:64:0x02bb, B:66:0x02c5, B:67:0x02de, B:70:0x02fc, B:74:0x0313, B:93:0x036c, B:114:0x02d7), top: B:61:0x02b2 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String xj(java.util.Map<java.lang.String, com.bytedance.msdk.w.xj.xj> r34, android.content.Context r35, com.bytedance.msdk.api.xj.hf r36, java.util.List<com.bytedance.msdk.core.tf.tf> r37, java.util.List<com.bytedance.msdk.hf.w> r38, com.bytedance.msdk.core.tf.hf r39, int r40, boolean r41, org.json.JSONObject r42, boolean r43) {
        /*
            Method dump skipped, instructions count: 1564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.g.xj.xj(java.util.Map, android.content.Context, com.bytedance.msdk.api.xj.hf, java.util.List, java.util.List, com.bytedance.msdk.core.tf.hf, int, boolean, org.json.JSONObject, boolean):java.lang.String");
    }

    private String xj(com.bytedance.msdk.api.xj.hf hfVar, tf tfVar) {
        String xj2 = hfVar != null ? hfVar.xj() : null;
        if (tfVar == null) {
            return xj2;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(CtFAbx.AcNBzu(xj2, "_"));
        A4TApA2.append(tfVar.yo());
        return A4TApA2.toString();
    }

    private String xj(JSONObject jSONObject, boolean z, boolean z2) {
        if (z2) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject xj2 = l.xj(jSONObject);
        if (xj2 == null) {
            return null;
        }
        try {
            xj2.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
        } catch (Exception unused2) {
        }
        return xj2.toString();
    }

    private JSONObject xj(com.bytedance.msdk.api.xj.hf hfVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PointParamKey.REQUEST_ID, hfVar.xj());
            jSONObject.put("ad_sdk_version", com.bytedance.msdk.hf.hf.hf());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.hf.hf.u());
            jSONObject.put(n.s, PointCategory.APP);
            jSONObject.put(PointCategory.APP, w());
            JSONObject xj2 = ra.xj(hf.getContext());
            if (xj2 != null && hfVar.l() > 0) {
                xj2.put("orientation", hfVar.l());
            }
            jSONObject.put("device", xj2);
            jSONObject.put("ua", com.bytedance.msdk.hf.hf.xj);
            jSONObject.put("ip", dk.ht());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(hf(hfVar));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (hfVar.ra() != null && hfVar.xj() != null) {
                str = String.valueOf(currentTimeMillis).concat(hfVar.ra()).concat(hfVar.xj());
            }
            jSONObject.put("req_sign", g.xj(str));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void xj(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, i);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }
}
