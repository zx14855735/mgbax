package com.bytedance.sdk.openadsdk.core.l.hf;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ff.xj.kd;
import com.bytedance.sdk.openadsdk.core.l.f;
import com.bytedance.sdk.openadsdk.core.l.hf;
import com.bytedance.sdk.openadsdk.core.l.u;
import com.bytedance.sdk.openadsdk.core.l.y;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private SSWebView hf;
    private int u;
    private Context w;
    ws xj;
    private int kd = 1;
    private int y = -3;
    private int c = -1;

    public xj(SSWebView sSWebView, Context context, int i, ws wsVar) {
        this.hf = sSWebView;
        this.w = context;
        this.u = i;
        this.xj = wsVar;
    }

    public static /* synthetic */ int w(xj xjVar) {
        int i = xjVar.kd;
        xjVar.kd = i + 1;
        return i;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        pl.xj("transmit_TTWifiObject", "getNetOperatorType PhoneNumStatus:" + this.u);
        final int hf = hf();
        if (hf == -1 || hf == -2) {
            final long currentTimeMillis = System.currentTimeMillis();
            c.xj(new d("getNetOperatorType") { // from class: com.bytedance.sdk.openadsdk.core.l.hf.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj(-1, System.currentTimeMillis() - currentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", hf, xj.this.kd);
                }
            });
        }
        pl.xj("transmit_TTWifiObject", "getNetOperatorType type:".concat(String.valueOf(hf)));
        return hf;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(final String str) {
        Context context;
        pl.xj("transmit_TTWifiObject", "send_switch PhoneNumStatus:" + this.u + "  params:" + str);
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.u > 0) {
            c.xj(new d("send_network_switch") { // from class: com.bytedance.sdk.openadsdk.core.l.hf.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    try {
                        i = new JSONObject(str).optInt("operType");
                    } catch (JSONException e) {
                        pl.xj(e);
                        i = -3;
                    }
                    if (i != 1 && i != 2 && i != 3) {
                        i = xj.this.hf();
                    }
                    final int i2 = i;
                    if (i2 == 3 && xj.this.y == 3) {
                        xj.w(xj.this);
                    } else {
                        xj.this.kd = 1;
                    }
                    xj.this.y = i2;
                    if (xj.this.w != null) {
                        new f(xj.this.w, new hf()).xj(str, new u() { // from class: com.bytedance.sdk.openadsdk.core.l.hf.xj.2.1
                            @Override // com.bytedance.sdk.openadsdk.core.l.u
                            public void xj(boolean z, int i3, int i4, String str2, Map<String, List<String>> map, String str3) {
                                pl.xj("transmit_TTWifiObject", "TransmitBusiness_onResponse s : " + z + " code:" + i4 + " msg:" + str2 + "  body:" + str3);
                                if (TextUtils.isEmpty(str3)) {
                                    pl.xj("transmit_TTWifiObject", "TransmitBusiness_onResponse body is null and code:".concat(String.valueOf(i4)));
                                }
                                if (z) {
                                    str2 = "取号成功";
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = "取号失败";
                                }
                                String str4 = str2;
                                xj xjVar = xj.this;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                xjVar.xj(i3, currentTimeMillis2 - currentTimeMillis, z, str4, i2, xj.this.kd);
                                JSONObject jSONObject = new JSONObject();
                                if (str3 == null) {
                                    str3 = "";
                                }
                                try {
                                    jSONObject.put(PointParamKey.DATA, str3);
                                    jSONObject.put("networkType", i3);
                                } catch (JSONException unused) {
                                }
                                if (xj.this.hf != null) {
                                    p.xj(xj.this.hf, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                                }
                            }
                        });
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(PointParamKey.DATA, "取号失败，context is null");
                        jSONObject.put("networkType", 0);
                    } catch (JSONException unused) {
                    }
                    if (xj.this.hf != null) {
                        p.xj(xj.this.hf, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                    }
                    xj.this.xj(-1, System.currentTimeMillis() - currentTimeMillis, false, "context is null", i2, xj.this.kd);
                }
            });
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        if (this.c == -1 && (context = this.w) != null) {
            this.c = y.xj(context, y.xj(context));
        }
        try {
            jSONObject.put(PointParamKey.DATA, "没有wifi网络下获取手机号权限");
            jSONObject.put("networkType", this.c);
        } catch (JSONException unused) {
        }
        SSWebView sSWebView = this.hf;
        if (sSWebView != null) {
            p.xj(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
        }
        xj(-1, System.currentTimeMillis() - currentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.kd);
        return "";
    }

    public int hf() {
        int i = this.u;
        if (i <= 0) {
            return -1;
        }
        Context context = this.w;
        if (context == null || i == 1) {
            return -3;
        }
        int xj = y.xj(context, y.xj(context));
        this.c = xj;
        if (xj == 0 || xj == 2) {
            return -2;
        }
        String xj2 = kd.xj(xj());
        xj2.getClass();
        switch (xj2) {
            case "1":
                return 1;
            case "2":
                return 3;
            case "3":
                return 2;
            default:
                return -3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final int i, final long j, final boolean z, final String str, final int i2, final int i3) {
        pl.xj("transmit_TTWifiObject", "TTWifiObject sendWifiEvent duration:" + j + "  networkType:" + i + "   s:" + z + "  detailInfo:" + str + " simType:" + i2 + "  redirectTime:" + i3);
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.xj, "wifi_auth", "click_other", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.l.hf.xj.3
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
                jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(i));
                jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(j));
                jSONObject2.putOpt("wifi_auth_status", z ? cb.o : "failure");
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.putOpt("wifi_auth_detail_info", str2);
                jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(i2));
                jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(i3));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static String xj() {
        TelephonyManager xj;
        int defaultDataSubscriptionId;
        TelephonyManager createForSubscriptionId;
        try {
            com.bytedance.sdk.openadsdk.zg.w.w.u e = com.bytedance.sdk.openadsdk.core.f.zg().e();
            if ((e != null && !e.w()) || (xj = yo.xj()) == null || Build.VERSION.SDK_INT < 22) {
                return null;
            }
            defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            createForSubscriptionId = xj.createForSubscriptionId(defaultDataSubscriptionId);
            return createForSubscriptionId.getSimOperator();
        } catch (Exception e2) {
            pl.u("transmit_TTWifiObject", " getActiveSimOperator error :" + e2.toString());
            return null;
        }
    }
}
