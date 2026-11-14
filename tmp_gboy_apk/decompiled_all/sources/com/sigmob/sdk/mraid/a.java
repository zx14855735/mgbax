package com.sigmob.sdk.mraid;

import ADYaiT.BChYOn;
import DaOi9o.AYUAbz;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.windad.WindAds;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13457a = "AppInfoJS";
    private final WeakReference<c> b;

    public a(c cVar) {
        this.b = new WeakReference<>(cVar);
    }

    public c a() {
        return this.b.get();
    }

    @JavascriptInterface
    public String addMacro(JSONObject jSONObject) {
        try {
            BaseAdUnit b = b();
            String string = jSONObject.has("key") ? jSONObject.getString("key") : null;
            String string2 = jSONObject.has("value") ? jSONObject.getString("value") : null;
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) string) && !com.sigmob.sdk.base.utils.o.a((CharSequence) string2)) {
                b.getMacroCommon().addMarcoKey(string, string2);
                return a(200, "addMacro success", (Object) null);
            }
            return a(300, "key or value is empty", (Object) null);
        } catch (Throwable th) {
            return a(500, "addMacro add fail " + th.getMessage(), (Object) null);
        }
    }

    public BaseAdUnit b() {
        c a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.c;
    }

    @JavascriptInterface
    public String excuteRewardAdTrack(JSONObject jSONObject) {
        String str;
        try {
            BaseAdUnit b = b();
            String string = jSONObject.getString("event");
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) string) && string.equals("click")) {
                com.sigmob.sdk.base.utils.c.a("AppInfoJS", b);
            }
            int b2 = com.sigmob.sdk.base.network.g.b(b, string, true);
            if (b2 == 0) {
                return a(200, "excuteRewardAdTrack success", (Object) null);
            }
            if (b2 == -1) {
                str = "event is empty";
            } else {
                if (b2 != -2) {
                    return a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "unknown error: " + b2, (Object) null);
                }
                str = string + " can't find in trackers";
            }
            return a(300, str, (Object) null);
        } catch (Throwable th) {
            return a(500, "unknown error: " + th.getMessage(), (Object) null);
        }
    }

    @JavascriptInterface
    public String func(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) string)) {
                return a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "func is empty", (Object) null);
            }
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
            methodBuilder.addParam(JSONObject.class, jSONObject);
            return (String) methodBuilder.execute();
        } catch (Throwable th) {
            return a(500, th.getMessage(), (Object) null);
        }
    }

    @JavascriptInterface
    public String getAppInfo(JSONObject jSONObject) {
        char c;
        Object obj;
        int densityDpi;
        try {
            JSONObject jSONObject2 = new JSONObject();
            BaseAdUnit b = b();
            if (jSONObject != null && b != null && jSONObject.has("arguments")) {
                JSONArray jSONArray = jSONObject.getJSONArray("arguments");
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    try {
                        switch (string.hashCode()) {
                            case -1776992973:
                                if (string.equals("ad_source_logo")) {
                                    c = 20;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1590994477:
                                if (string.equals("display_orientation")) {
                                    c = ' ';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1581153970:
                                if (string.equals("settlement_price_enc")) {
                                    c = 29;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1534836170:
                                if (string.equals("google_aid")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1342627961:
                                if (string.equals("bid_price")) {
                                    c = 27;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1295727824:
                                if (string.equals("device_height")) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1152230954:
                                if (string.equals("ad_type")) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1093016302:
                                if (string.equals("client_pixel")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -918718184:
                                if (string.equals("forbiden_parse_landingpage")) {
                                    c = 31;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -901870406:
                                if (string.equals(com.sigmob.sdk.base.n.r)) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -702722614:
                                if (string.equals("creative_type")) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -582019427:
                                if (string.equals("device_width")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -568274923:
                                if (string.equals("screen_density")) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -516987305:
                                if (string.equals("pkgname")) {
                                    c = '\r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -376724013:
                                if (string.equals(PluginConstants.KEY_SDK_VERSION)) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -205033663:
                                if (string.equals("is_override")) {
                                    c = 30;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -41411609:
                                if (string.equals("screenangle")) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -19457365:
                                if (string.equals("network_type")) {
                                    c = '\f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3556:
                                if (string.equals("os")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 116753:
                                if (string.equals(PointParamKey.VID)) {
                                    c = 23;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3062218:
                                if (string.equals("crid")) {
                                    c = 24;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3236040:
                                if (string.equals("imei")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 37109963:
                                if (string.equals(PointParamKey.REQUEST_ID)) {
                                    c = 17;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 93029116:
                                if (string.equals("appid")) {
                                    c = 19;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 549673881:
                                if (string.equals("camp_id")) {
                                    c = 25;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 672836989:
                                if (string.equals("os_version")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 722989291:
                                if (string.equals("android_id")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1103406469:
                                if (string.equals("clienttype")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1127917191:
                                if (string.equals("cust_id")) {
                                    c = 26;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1139668345:
                                if (string.equals("adslot_id")) {
                                    c = 22;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1224358069:
                                if (string.equals(PointParamKey.PLACEMENT_ID)) {
                                    c = 18;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1437471655:
                                if (string.equals("expired_time")) {
                                    c = '!';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1753008747:
                                if (string.equals("product_id")) {
                                    c = 28;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1765767291:
                                if (string.equals("ad_source_channel")) {
                                    c = 21;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                jSONObject2.put(string, 2);
                                break;
                            case 1:
                                obj = "";
                                jSONObject2.put(string, obj);
                                break;
                            case 2:
                                obj = ClientMetadata.getInstance().getAndroidId();
                                jSONObject2.put(string, obj);
                                break;
                            case 3:
                                obj = ClientMetadata.getInstance().getAdvertisingId();
                                jSONObject2.put(string, obj);
                                break;
                            case 4:
                                obj = ClientMetadata.getDeviceModel();
                                jSONObject2.put(string, obj);
                                break;
                            case 5:
                                obj = ClientMetadata.getInstance().getAppVersion();
                                jSONObject2.put(string, obj);
                                break;
                            case 6:
                                obj = com.sigmob.sdk.base.n.k;
                                jSONObject2.put(string, obj);
                                break;
                            case 7:
                                obj = ClientMetadata.getDeviceOsVersion();
                                jSONObject2.put(string, obj);
                                break;
                            case '\b':
                                obj = ClientMetadata.getInstance().getDisplayMetrics().widthPixels + "x" + ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
                                jSONObject2.put(string, obj);
                                break;
                            case '\t':
                                obj = ClientMetadata.getInstance().getDeviceScreenWidthDip();
                                jSONObject2.put(string, obj);
                                break;
                            case '\n':
                                obj = ClientMetadata.getInstance().getDeviceScreenHeightDip();
                                jSONObject2.put(string, obj);
                                break;
                            case 11:
                                densityDpi = ClientMetadata.getInstance().getDensityDpi();
                                jSONObject2.put(string, densityDpi);
                                break;
                            case '\f':
                                densityDpi = ClientMetadata.getInstance().getActiveNetworkType();
                                jSONObject2.put(string, densityDpi);
                                break;
                            case '\r':
                                obj = ClientMetadata.getInstance().getAppPackageName();
                                jSONObject2.put(string, obj);
                                break;
                            case 14:
                                densityDpi = Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90;
                                jSONObject2.put(string, densityDpi);
                                break;
                            case 15:
                                densityDpi = b.getCreativeType();
                                jSONObject2.put(string, densityDpi);
                                break;
                            case 16:
                                densityDpi = b.getAd_type();
                                jSONObject2.put(string, densityDpi);
                                break;
                            case 17:
                                obj = b.getRequestId();
                                jSONObject2.put(string, obj);
                                break;
                            case 18:
                            case 22:
                                obj = b.getAdslot_id();
                                jSONObject2.put(string, obj);
                                break;
                            case 19:
                                obj = WindAds.sharedAds().getAppId();
                                jSONObject2.put(string, obj);
                                break;
                            case 20:
                                obj = b.getAd_source_logo();
                                jSONObject2.put(string, obj);
                                break;
                            case 21:
                                obj = b.getAd_source_channel();
                                jSONObject2.put(string, obj);
                                break;
                            case 23:
                                obj = b.getAd().vid;
                                jSONObject2.put(string, obj);
                                break;
                            case 24:
                                obj = b.getCrid();
                                jSONObject2.put(string, obj);
                                break;
                            case 25:
                                obj = b.getCamp_id();
                                jSONObject2.put(string, obj);
                                break;
                            case 26:
                                obj = b.getAd().cust_id;
                                jSONObject2.put(string, obj);
                                break;
                            case 27:
                                obj = b.getAd().bid_price;
                                jSONObject2.put(string, obj);
                                break;
                            case 28:
                                obj = b.getAd().product_id;
                                jSONObject2.put(string, obj);
                                break;
                            case 29:
                                obj = b.getAd().settlement_price_enc;
                                jSONObject2.put(string, obj);
                                break;
                            case 30:
                                obj = b.getAd().is_override;
                                jSONObject2.put(string, obj);
                                break;
                            case 31:
                                obj = b.getAd().forbiden_parse_landingpage;
                                jSONObject2.put(string, obj);
                                break;
                            case ' ':
                                densityDpi = b.getDisplay_orientation();
                                jSONObject2.put(string, densityDpi);
                                break;
                            case '!':
                                obj = b.getAd().expired_time;
                                jSONObject2.put(string, obj);
                                break;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return a(200, "getAppInfo success ", jSONObject2);
        } catch (Throwable th) {
            return a(500, "getAppInfo error: " + th.getMessage(), (Object) null);
        }
    }

    @JavascriptInterface
    public String hello(JSONObject jSONObject) {
        try {
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @JavascriptInterface
    public String javascriptAddDcLog(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                return a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "not params", (Object) null);
            }
            if (!jSONObject.has(PointParamKey._AC_TYPE)) {
                return a(300, "_ac_type is empty", (Object) null);
            }
            String string = jSONObject.getString(PointParamKey._AC_TYPE);
            BaseAdUnit b = b();
            ae.a(string, b, (LoadAdRequest) null, new AYUAbz(jSONObject, 8, b));
            return a(200, "add dc log success", (Object) null);
        } catch (Throwable th) {
            return a(500, th.toString(), (Object) null);
        }
    }

    @JavascriptInterface
    public String mraidJsLoaded() {
        d dVar;
        c a2 = a();
        if (a2 != null && (dVar = a2.d) != null) {
            dVar.b();
        }
        return null;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        SigmobLog.d("postMessage: raw " + str);
        c a2 = a();
        if (a2 == null) {
            return;
        }
        a2.e.post(new BChYOn(str, 27, a2));
    }

    @JavascriptInterface
    public String tracking(JSONObject jSONObject) {
        try {
            BaseAdUnit b = b();
            String optString = jSONObject.optString("event");
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ai aiVar = new ai(optJSONArray.optString(i), optString, b.getRequestId());
                    aiVar.setRetryNum(Integer.valueOf(b.getTrackingRetryNum()));
                    aiVar.setSource("js");
                    com.sigmob.sdk.base.network.g.a((AdTracker) aiVar, b, false);
                }
                return a(200, "tracking success.", (Object) null);
            }
            return a(300, "urls is empty.", (Object) null);
        } catch (Throwable th) {
            return a(500, "unknown error: " + th.getMessage(), (Object) null);
        }
    }

    public static String a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
                jSONObject.put("message", str);
            }
            if (obj != null) {
                jSONObject.put(PointParamKey.DATA, obj);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.a(jSONObject.optString("event"), jSONObject.optString("subEvent"), jSONObject.optJSONObject("args"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cVar.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(JSONObject jSONObject, BaseAdUnit baseAdUnit, Object obj) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equalsIgnoreCase(com.sigmob.sdk.base.n.m)) {
                try {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(next));
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            hashMap.put(next2, jSONObject2.optString(next2));
                        }
                    } catch (Exception unused) {
                        hashMap.put(com.sigmob.sdk.base.n.m, Base64.encodeToString(jSONObject.getString(com.sigmob.sdk.base.n.m).getBytes(), 2));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (!next.equalsIgnoreCase(PointParamKey._AC_TYPE)) {
                try {
                    hashMap.put(next, jSONObject.getString(next));
                } catch (Throwable unused2) {
                }
            }
        }
        hashMap.put(com.sigmob.sdk.base.n.l, "js");
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            String str = (String) hashMap.get("sub_category");
            if (com.sigmob.sdk.base.utils.q.b(baseAdUnit) && com.sigmob.sdk.base.utils.o.a(str, "click")) {
                ClickCommon clickCommon = baseAdUnit.getClickCommon();
                if (com.sigmob.sdk.base.utils.q.b(clickCommon)) {
                    hashMap.put(ClickCommon.CLICK_LOSE_RATE, String.valueOf(clickCommon.click_lose_rate));
                    hashMap.put(ClickCommon.CLICK_CB_STATE, String.valueOf(clickCommon.click_cb_state));
                }
            }
            pointEntitySigmob.setOptions(hashMap);
        }
    }
}
