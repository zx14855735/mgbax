package com.bytedance.sdk.openadsdk.core.live.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.ai;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.live.xj.c;
import com.bytedance.sdk.openadsdk.core.pz;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    final c xj;

    public xj(c cVar) {
        this.xj = cVar;
    }

    private void c(PluginValueSet pluginValueSet) {
        try {
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            this.xj.xj(Integer.valueOf((String) map.get("is_auth")).intValue() != 0, (String) map.get("open_uid"));
        } catch (Exception e) {
            pl.hf("LiveServiceBridge", e);
        }
    }

    private Integer f(PluginValueSet pluginValueSet) {
        String c = com.bytedance.sdk.openadsdk.core.live.hf.xj().c();
        if (c == null) {
            return null;
        }
        if (c.replaceAll(".", "").startsWith("2112")) {
            Object[] arrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (arrayValue == null || arrayValue.length == 0) {
                return null;
            }
            return (Integer) arrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    private void hf(PluginValueSet pluginValueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get(cb.o);
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            pl.hf("LiveServiceBridge", e);
            message = e.getMessage();
        }
        this.xj.xj(i, message, false, true);
    }

    private Object kd(PluginValueSet pluginValueSet) {
        try {
            Integer f = f(pluginValueSet);
            if (f == null) {
                return null;
            }
            return pz.xj().xj(ai.xj(f.intValue()));
        } catch (Throwable th) {
            pl.hf("TTLiveSDkBridge", "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void u(PluginValueSet pluginValueSet) {
        try {
            this.xj.hf((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            pl.hf("LiveServiceBridge", e);
        }
    }

    private void w(PluginValueSet pluginValueSet) {
        try {
            this.xj.w((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            pl.hf("LiveServiceBridge", e);
        }
    }

    private void y(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.xj.xj(map);
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            if (intValue == 0) {
                return xj(ADYaiT2);
            }
            if (intValue == 1) {
                xj(ADYaiT2.booleanValue(0, false), ADYaiT2.stringValue(1, null), ADYaiT2.stringValue(2, null), (Map) ADYaiT2.objectValue(3, Map.class));
                return null;
            }
            if (intValue == 2) {
                this.xj.xj(ADYaiT2.intValue(0, 0), ADYaiT2.stringValue(1, null), xj(ADYaiT2, 2), false);
                return null;
            }
            if (intValue == 3) {
                int intValue2 = ADYaiT2.intValue(0, 0);
                boolean xj = xj(ADYaiT2, 4);
                if (1000 == intValue2) {
                    this.xj.xj(5, (String) null, xj, false);
                    if (!xj) {
                        this.xj.xj();
                        return null;
                    }
                } else if (1001 == intValue2) {
                    this.xj.xj(-2, ADYaiT2.stringValue(1, null), xj, false);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        if (r1.equals("sendGoldExchangeCoupon") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object xj(com.bykv.vk.openvk.api.proto.PluginValueSet r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.stringValue(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 == 0) goto Ld
            return r3
        Ld:
            r1.getClass()
            r2 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case -1828730287: goto L67;
                case -955478604: goto L5c;
                case -366799433: goto L51;
                case 862273347: goto L46;
                case 1186389324: goto L3b;
                case 1388496268: goto L30;
                case 1562160023: goto L25;
                case 1979487267: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = -1
            goto L70
        L1a:
            java.lang.String r0 = "reportPangleEvent"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L23
            goto L18
        L23:
            r0 = 7
            goto L70
        L25:
            java.lang.String r0 = "getPangleApiVersion"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2e
            goto L18
        L2e:
            r0 = 6
            goto L70
        L30:
            java.lang.String r0 = "onAuthCallback"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L39
            goto L18
        L39:
            r0 = 5
            goto L70
        L3b:
            java.lang.String r0 = "getPanglePluginVersion"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L44
            goto L18
        L44:
            r0 = 4
            goto L70
        L46:
            java.lang.String r0 = "onLiveFakeInitFinish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L4f
            goto L18
        L4f:
            r0 = 3
            goto L70
        L51:
            java.lang.String r0 = "onTaskFinish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L5a
            goto L18
        L5a:
            r0 = 2
            goto L70
        L5c:
            java.lang.String r0 = "getBiddingToken"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L65
            goto L18
        L65:
            r0 = 1
            goto L70
        L67:
            java.lang.String r4 = "sendGoldExchangeCoupon"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L70
            goto L18
        L70:
            switch(r0) {
                case 0: goto L97;
                case 1: goto L92;
                case 2: goto L8e;
                case 3: goto L8a;
                case 4: goto L83;
                case 5: goto L7f;
                case 6: goto L78;
                case 7: goto L74;
                default: goto L73;
            }
        L73:
            goto L9a
        L74:
            r5.y(r6)
            goto L9a
        L78:
            int r6 = com.bytedance.sdk.openadsdk.core.ai.w
            java.lang.String r6 = java.lang.String.valueOf(r6)
            return r6
        L7f:
            r5.c(r6)
            goto L9a
        L83:
            r6 = 7132(0x1bdc, float:9.994E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L8a:
            r5.hf(r6)
            goto L9a
        L8e:
            r5.u(r6)
            goto L9a
        L92:
            java.lang.Object r6 = r5.kd(r6)
            return r6
        L97:
            r5.w(r6)
        L9a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.hf.xj.xj(com.bykv.vk.openvk.api.proto.PluginValueSet):java.lang.Object");
    }

    public void xj(boolean z, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e) {
                pl.xj(e);
                return;
            }
        }
        new xj.C0138xj().xj(str).hf(str2).w(BaseConstants.CATEGORY_UMENG).kd(jSONObject.optString("value")).u(jSONObject.optString("log_extra")).xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.live.hf.xj.1
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA))) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has(BaseConstants.EVENT_LABEL_IS_AD_EVENT)) {
                    return;
                }
                jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            }
        });
    }

    private boolean xj(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            if (map != null && map.containsKey("onlyUpdateState")) {
                if (Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")))) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
