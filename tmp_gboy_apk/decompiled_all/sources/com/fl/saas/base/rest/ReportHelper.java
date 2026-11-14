package com.fl.saas.base.rest;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.saas.bean.PreAdPlace;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.JSONUtil;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.OaidUtils;
import com.fl.saas.config.utils.SensorUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ReportHelper {
    private static final int INIT_REP_FAILED = -1;
    private static final int INIT_REP_FINISH = 2;
    private static final int INIT_REP_ING = 1;
    private static final int INIT_REP_INIT = 0;
    private static ReportHelper sInstance;
    private int INIT_REP_STATUS = 0;

    /* renamed from: com.fl.saas.base.rest.ReportHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements HttpCallbackStringListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(List list) {
            list.add(CommConstant.ImageUrl.ICON_RAIN1);
            list.add(CommConstant.ImageUrl.ICON_RAIN2);
            list.add(CommConstant.ImageUrl.ICON_RAIN3);
            list.add(CommConstant.ImageUrl.ICON_RAIN4);
            list.add(CommConstant.ImageUrl.ICON_RAIN5);
            PreResManager.handleDownload(PreResManager.RAIN_CACHE, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$1(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onError(Exception exc) {
            LogcatUtil.d("YdSDk-Preload", "上报失败:" + exc.toString());
            ReportHelper.this.INIT_REP_STATUS = -1;
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onJump(String str) {
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onSuccess(String str) {
            JSONArray optJSONArray;
            ReportHelper.this.INIT_REP_STATUS = 2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject parseResponseNew = NetDataUtils.parseResponseNew(str);
                if (parseResponseNew != null) {
                    JSONArray optJSONArray2 = parseResponseNew.optJSONArray("app_list");
                    if (optJSONArray2 != null) {
                        DeviceUtil.appList = optJSONArray2;
                    }
                    int optInt = parseResponseNew.optInt("cacheSwitch", 0);
                    int optInt2 = parseResponseNew.optInt("cacheAdTime", 30);
                    int optInt3 = parseResponseNew.optInt("queueNum", 5);
                    ConfigHelper.getInstance().setCacheSwitch(optInt);
                    ConfigHelper.getInstance().setCacheAdTime(optInt2);
                    ConfigHelper.getInstance().setQueueNum(optInt3);
                    JSONArray optJSONArray3 = parseResponseNew.optJSONArray("public_config_list");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        LogcatUtil.d("YdSDK-Preload", "configList:" + optJSONArray3.length());
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray3.length(); i++) {
                            String optString = optJSONArray3.optJSONObject(i).optString("place_id");
                            int optInt4 = optJSONArray3.optJSONObject(i).optInt("position");
                            if (!TextUtils.isEmpty(optString) && optInt4 != 0) {
                                JSONObject optJSONObject = optJSONArray3.optJSONObject(i);
                                AdPlace handleData = ConfigHelper.getInstance().handleData(optJSONObject, DeviceUtil.getReqID(optString), optString);
                                if (handleData != null) {
                                    handleData.setSourceStr(optJSONObject.toString());
                                    arrayList.add(PreAdPlace.create(optInt4, handleData));
                                }
                            }
                        }
                        LogcatUtil.d("YdSDK-Preload", "preload adPlaces:" + arrayList.size());
                        if (!arrayList.isEmpty()) {
                            PreloadHelper.getInstance().addAdPlace(arrayList);
                        }
                    }
                    String optString2 = parseResponseNew.optString("global_cache_position");
                    if (!TextUtils.isEmpty(optString2)) {
                        AdCacheManager.getInstance().setGlobalCachePosition(optString2.split(","));
                    }
                    final ArrayList arrayList2 = new ArrayList();
                    if (PreResManager.isRainRedCacheEmpty() && (optJSONArray = parseResponseNew.optJSONArray("img_url_list")) != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList2.add(optJSONArray.optString(i2));
                        }
                    }
                    ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.fl.saas.base.rest.A2egSU
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReportHelper.AnonymousClass1.lambda$onSuccess$0(arrayList2);
                        }
                    });
                    DeviceUtil.setMaterialAdv(JSONUtil.jsonArrayToList(parseResponseNew.optJSONArray("adv_id_list"), new A4TApA()));
                    QuickAppHelper.getInstance().setCollectWebviewWakeup(parseResponseNew.optInt("collect_webview_wakeup", 1));
                    QuickAppHelper.getInstance().setQuickAppBlockRatio(parseResponseNew.optDouble("quick_app_block_ratio", 100.0d));
                    QuickAppHelper.getInstance().setWebviewWakeupLimit(parseResponseNew.optInt("webview_wakeup_limit", 0));
                    QuickAppHelper.getInstance().setQuickAppInterceptionType(parseResponseNew.optInt("quick_app_interception_type", 1));
                    QuickAppHelper.getInstance().setQuickAppFreqDay(parseResponseNew.optInt("quick_app_freq_day", 0));
                    String optString3 = parseResponseNew.optString("whitelist_headers", "");
                    if (optString3.isEmpty()) {
                        return;
                    }
                    QuickAppHelper.getInstance().setWhitelistHeaders(Arrays.asList(optString3.split(",")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void doRequest(int i, AdSource adSource) {
        if (adSource == null) {
            return;
        }
        if (!adSource.isApiBidAd || 9 == i) {
            ThreadPoolManager.getInstance().addTask(new DUi7mC.A2egSU(i, 4, this, adSource));
        }
    }

    private String getAdFullUrl(AdSource adSource, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("price", Integer.valueOf(adSource.getPrice()));
            jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("is_proload", adSource.getPreLoadStr());
            jSONObject.putOpt("traffic_resp_time", Long.valueOf(j));
            jSONObject.putOpt("cost_time", Long.valueOf(adSource.responseTime));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/traffic_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private JSONArray getAdvInfoJsonArray(List<AdSource> list) {
        JSONArray jSONArray = new JSONArray();
        for (AdSource adSource : list) {
            if (adSource.getAdCacheBean() == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
                jSONObject.putOpt("tag_id", adSource.tagid);
                jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
                jSONObject.putOpt("cost_time", Long.valueOf(adSource.cost_time));
                int i = adSource.price;
                jSONObject.putOpt("price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private String getClickUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("creative_id", adSource.creative_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("cost_time", Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!Constants.FAIL.equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/click?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getDisplayUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("creative_id", adSource.creative_id);
            jSONObject.putOpt("is_cached", Integer.valueOf(adSource.isCacheAd ? 1 : 0));
            jSONObject.putOpt("price", Integer.valueOf(adSource.getAdvPrice()));
            int i = adSource.price;
            jSONObject.putOpt("adv_price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            if (adSource.isApiAd) {
                jSONObject.putOpt("ctype", Integer.valueOf(adSource.getCtype()));
                jSONObject.putOpt("title", adSource.getTitle());
                jSONObject.putOpt("desc", adSource.getDesc());
            }
            jSONObject.putOpt("cost_time", Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!Constants.FAIL.equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getErrorUrl(String str, String str2, String str3, String str4, List<ErrorInfo> list, String str5, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, str);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", str2);
            jSONObject.putOpt("group_id", str3);
            jSONObject.putOpt("test_id", str4);
            jSONObject.putOpt("track_id", str5);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            JSONArray jSONArray = new JSONArray();
            for (ErrorInfo errorInfo : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("adv_id", errorInfo.adv_id);
                jSONObject2.putOpt("tagid", errorInfo.tagid);
                int i = errorInfo.code;
                if (i == 20412) {
                    i = errorInfo.errorType;
                }
                if ("1".equals(errorInfo.adv_id) && !TextUtils.isEmpty(errorInfo.msg) && errorInfo.msg.contains("reason:") && errorInfo.msg.contains("message:") && errorInfo.msg.indexOf("message:") > 0) {
                    try {
                        int parseInt = Integer.parseInt(errorInfo.msg.substring(errorInfo.msg.indexOf("reason:") + 7, errorInfo.msg.indexOf("message:")).trim());
                        jSONObject2.putOpt(PluginConstants.KEY_ERROR_CODE, parseInt != 0 ? i + "_" + parseInt : Integer.valueOf(i));
                    } catch (NumberFormatException unused) {
                    }
                    jSONArray.put(jSONObject2);
                }
                jSONObject2.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                jSONArray.put(jSONObject2);
            }
            jSONObject.putOpt("error_info", jSONArray);
            jSONObject.putOpt("cost_time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/error_response2?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + str2;
    }

    public static ReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (ReportHelper.class) {
                sInstance = new ReportHelper();
            }
        }
        return sInstance;
    }

    private String getReportDpUrl(AdSource adSource, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("price", Integer.valueOf(adSource.getPrice()));
            jSONObject.putOpt("time", Long.valueOf(adSource.cost_time));
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("cost_time", Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("js_dpurl", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/js_dpurl?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestC2SBiddingUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            int i = adSource.price;
            jSONObject.putOpt("price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("cost_time", Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
        } catch (JSONException e) {
            e = e;
            e.printStackTrace();
            return "http://adtracker.adfunlink.com/log/bid_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
        } catch (Throwable th) {
            e = th;
            e.printStackTrace();
            return "http://adtracker.adfunlink.com/log/bid_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
        }
        return "http://adtracker.adfunlink.com/log/bid_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestShowUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            int i = adSource.price;
            jSONObject.putOpt("price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("cost_time", Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!Constants.FAIL.equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
        } catch (JSONException e) {
            e = e;
            e.printStackTrace();
            return "http://adtracker.adfunlink.com/log/trigger_impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
        } catch (Throwable th) {
            e = th;
            e.printStackTrace();
            return "http://adtracker.adfunlink.com/log/trigger_impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
        }
        return "http://adtracker.adfunlink.com/log/trigger_impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestUrl(List<AdSource> list, AdPlace adPlace) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.8.8");
            if (adPlace != null) {
                jSONObject.putOpt(f.f13353a, adPlace.req_id);
                jSONObject.putOpt("place_id", adPlace.place_id);
                jSONObject.putOpt("group_id", adPlace.group_id);
                jSONObject.putOpt("test_id", adPlace.test_id);
                str = adPlace.track_id;
            } else {
                jSONObject.putOpt(f.f13353a, list.get(0).req_id);
                jSONObject.putOpt("place_id", list.get(0).place_id);
                jSONObject.putOpt("group_id", list.get(0).group_id);
                jSONObject.putOpt("test_id", list.get(0).test_id);
                str = list.get(0).track_id;
            }
            jSONObject.putOpt("track_id", str);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("adv_info_list", getAdvInfoJsonArray(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/adv_request_merge_info?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + list.get(0).place_id;
    }

    private String getResponseUrl(List<AdSource> list, AdPlace adPlace) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.8.8");
            if (adPlace != null) {
                jSONObject.putOpt(f.f13353a, adPlace.req_id);
                jSONObject.putOpt("place_id", adPlace.place_id);
                jSONObject.putOpt("group_id", adPlace.group_id);
                jSONObject.putOpt("test_id", adPlace.test_id);
                str = adPlace.track_id;
            } else {
                jSONObject.putOpt(f.f13353a, list.get(0).req_id);
                jSONObject.putOpt("place_id", list.get(0).place_id);
                jSONObject.putOpt("group_id", list.get(0).group_id);
                jSONObject.putOpt("test_id", list.get(0).test_id);
                str = list.get(0).track_id;
            }
            jSONObject.putOpt("track_id", str);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("adv_info_list", getAdvInfoJsonArray(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/adv_response_merge_info?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + list.get(0).place_id;
    }

    private String getSDKInitUrl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("is_applist", Boolean.valueOf(DeviceUtil.isAppList()));
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/newInitialization?e=" + AesUtils.encrypt(jSONObject.toString());
    }

    private String getSdkRequestUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("is_proload", adSource.getPreLoadStr());
            jSONObject.putOpt("cost_time", Long.valueOf(adSource.cost_time));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/traffic_request?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRequest$0(int i, AdSource adSource) {
        requestUrl(1 == i ? getDisplayUrl(adSource) : 2 == i ? getClickUrl(adSource) : 8 == i ? getSdkRequestUrl(adSource) : 9 == i ? getRequestShowUrl(adSource) : 10 == i ? getRequestC2SBiddingUrl(adSource) : "");
    }

    private synchronized void requestUrl(String str) {
        AdHttpUtils.getInstance().doGet(str, new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ReportHelper.3
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDk-doRequest", "上报失败:" + exc.toString());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str2) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str2) {
            }
        });
    }

    public synchronized void reportC2SBiddingAd(AdSource adSource) {
        doRequest(10, adSource);
    }

    public synchronized void reportClick(AdSource adSource) {
        doRequest(2, adSource);
    }

    public synchronized void reportDisplay(AdSource adSource) {
        doRequest(1, adSource);
    }

    public synchronized void reportDpUrl(AdSource adSource, String str) {
        if (adSource != null) {
            if (!TextUtils.isEmpty(str)) {
                requestUrl(getReportDpUrl(adSource, str));
            }
        }
    }

    public synchronized void reportFillFail(String str, String str2, String str3, String str4, List<ErrorInfo> list, String str5, long j) {
        try {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        requestUrl(getErrorUrl(str, str2, str3, str4, list, str5, j));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void reportFullAd(AdSource adSource, long j) {
        requestUrl(getAdFullUrl(adSource, j));
    }

    public synchronized void reportRequestAd(AdSource adSource) {
        doRequest(8, adSource);
    }

    public synchronized void reportRequestList(List<AdSource> list, AdPlace adPlace) {
        if (list != null) {
            if (!list.isEmpty()) {
                requestUrl(getRequestUrl(list, adPlace));
            }
        }
    }

    public synchronized void reportRequestShow(AdSource adSource) {
        doRequest(9, adSource);
    }

    public synchronized void reportResponseList(List<AdSource> list, AdPlace adPlace) {
        if (list != null) {
            if (!list.isEmpty()) {
                requestUrl(getResponseUrl(list, adPlace));
            }
        }
    }

    public synchronized void reportSDKBidding(JSONObject jSONObject) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_S2S_BIDDING_REPORT, AesUtils.encrypt(jSONObject.toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ReportHelper.2
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDk-doRequest", "s2s上报失败:" + exc.toString());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
            }
        });
    }

    public synchronized void reportSDKInit() {
        try {
            int i = this.INIT_REP_STATUS;
            if (i != 1 && i != 2) {
                ConfigHelper.getInstance().initShowCount();
                this.INIT_REP_STATUS = 1;
                OaidUtils.init();
                if (DeviceUtil.isCanUseSensor) {
                    boolean checkAccelerometerSensor = DeviceUtil.checkAccelerometerSensor(DeviceUtil.getContext());
                    DeviceUtil.deviceHasAccelerometerSensor = checkAccelerometerSensor;
                    if (checkAccelerometerSensor) {
                        SensorUtil.getInstance().checkSensorEnable();
                    }
                }
                AdHttpUtils.getInstance().doGet(getSDKInitUrl(), new AnonymousClass1());
            }
        } finally {
        }
    }

    public JSONObject reqBidJson(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("adv_id", Integer.valueOf(i));
            jSONObject.putOpt("is_win", Integer.valueOf(i2));
            jSONObject.putOpt("auction_price", str);
            jSONObject.putOpt("highest_loss_price", str2);
            jSONObject.putOpt("win_adv_id", str3);
            jSONObject.putOpt("nurl", str4);
            jSONObject.putOpt("lurl", str5);
            jSONObject.putOpt("tagid", str6);
            jSONObject.putOpt("cost_time", Long.valueOf(j));
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
