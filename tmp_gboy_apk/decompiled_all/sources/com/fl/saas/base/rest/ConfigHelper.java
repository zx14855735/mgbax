package com.fl.saas.base.rest;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.fl.saas.base.interfaces.VideoVerifyRequstListener;
import com.fl.saas.common.crash.CrashHandler;
import com.fl.saas.common.listener.ApiSaaSListener;
import com.fl.saas.common.listener.SdkBidListener;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.ConfigLib;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.SPUtil;
import com.fl.saas.config.utils.YdAppBackgroundUtil;
import com.fl.saas.ydsdk.manager.YdConfig;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.sigmob.sdk.mraid.g;
import com.sigmob.windad.WindAds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ConfigHelper {
    private static ConfigHelper sInstance;
    public AdSource adSource;
    private int cacheAdTime;
    private int cacheSwitch;
    private List<String> installeds;
    private int queueNum;
    private long showCount;
    private Map<String, Boolean> videoMutePlay;
    private final boolean[] isTimeout = {false};
    private final boolean[] isReqDone = {false};

    public class ConfigSaveBean {
        private String config;
        private String groupId;
        private String key;
        private String testId;
        private long time;

        public ConfigSaveBean() {
        }

        public String getConfig() {
            return this.config;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getKey() {
            return this.key;
        }

        public String getTestId() {
            return this.testId;
        }

        public long getTime() {
            return this.time;
        }

        public void setConfig(String str) {
            this.config = str;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setTestId(String str) {
            this.testId = str;
        }

        public void setTime(long j) {
            this.time = j;
        }
    }

    private synchronized List<AdSource> buildAdSourceList(String str, JSONObject jSONObject, String str2, String str3) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str2);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdSource adSource = new AdSource();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                adSource.adv_id = optJSONObject.optInt("adv_id");
                adSource.mAdv_id = optJSONObject.optInt("adv_id");
                adSource.app_id = optJSONObject.optString(PluginConstants.KEY_APP_ID);
                adSource.app_key = optJSONObject.optString("app_key");
                adSource.slot_id = optJSONObject.optString("slot_id");
                adSource.bidfloor = optJSONObject.optInt("bidfloor");
                adSource.bidfloor_filter_sts = optJSONObject.optString("bidfloor_filter_sts", "S");
                adSource.tagid = optJSONObject.optString("tagid");
                adSource.mTagid = optJSONObject.optString("tagid");
                adSource.price = optJSONObject.optInt("price");
                adSource.skip = optJSONObject.optString("skip", "S");
                adSource.is_download = optJSONObject.optString("is_download", "S");
                adSource.setCloseButtonShow(optJSONObject.optString("close_button_type", "A"));
                adSource.count_down = optJSONObject.optInt("count_down", 5);
                adSource.button_size = optJSONObject.optInt("button_size", 50);
                adSource.sensitivity = optJSONObject.optInt(g.b, 50);
                adSource.sequence = i;
                adSource.advName = optJSONObject.optString("adv_name", "广告");
                adSource.req_id = str;
                adSource.group_id = jSONObject.optString("group_id");
                adSource.place_id = jSONObject.optString("place_id");
                adSource.test_id = jSONObject.optString("test_id");
                adSource.parseJson(optJSONObject);
                adSource.track_id = str3;
                adSource.customClassName = optJSONObject.optString("adapter_class");
                adSource.customParameJson = optJSONObject.optString(n.m);
                arrayList.add(adSource);
                if (adSource.adv_id == 3) {
                    ConfigLib.getInstance().setKsSensorConfig(optJSONObject);
                    ConfigLib.getInstance().setKsAppConfig(optJSONObject);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String string = SPUtil.getInstance().getString(str + "_config");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        String[] split = string.split(",");
        return split.length == 4 ? split[3] : "";
    }

    private ConfigSaveBean getConfigBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = SPUtil.getInstance().getString(str + "_config");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String[] split = string.split(",");
        if (split.length != 4) {
            return null;
        }
        ConfigSaveBean configSaveBean = new ConfigSaveBean();
        configSaveBean.setGroupId(split[0]);
        configSaveBean.setTestId(split[1]);
        try {
            configSaveBean.setTime(Long.parseLong(split[2]));
        } catch (Exception unused) {
        }
        configSaveBean.setConfig(split[3]);
        return configSaveBean;
    }

    public static ConfigHelper getInstance() {
        if (sInstance == null) {
            synchronized (ConfigHelper.class) {
                sInstance = new ConfigHelper();
            }
        }
        return sInstance;
    }

    private void handleCrashReport(JSONObject jSONObject) {
        if (!"A".equals(jSONObject.optString("crash_log_sts", "S"))) {
            CrashHandler.getInstance().removeCrashLog(DeviceUtil.getContext());
        } else {
            CrashHandler.getInstance().init(DeviceUtil.getContext());
            CrashHandler.getInstance().uploadCrashLog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(boolean z, String str, String str2, JSONObject jSONObject, String str3, ApiSaaSListener apiSaaSListener, long j) {
        String str4;
        if (jSONObject == null) {
            sdkTrafficReq("", str3, "", "", "", false, j);
            apiSaaSListener.onFailed("Incorrect configuration information,check config");
            return;
        }
        if (!jSONObject.has(PluginConstants.KEY_ERROR_CODE) || jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1) == -1) {
            sdkTrafficReq("", str3, "", "", "", false, j);
            if (jSONObject.has(br.c)) {
                str4 = "Incorrect configuration information. msg:" + jSONObject.optString(br.c);
            } else {
                str4 = "Incorrect configuration information.";
            }
            apiSaaSListener.onFailed(str4);
            if (z) {
                ConfigSaveBean configSaveBean = new ConfigSaveBean();
                configSaveBean.setKey(str3);
                configSaveBean.setGroupId("default");
                configSaveBean.setTestId("default");
                configSaveBean.setTime(0L);
                configSaveBean.setConfig(str);
                saveConfigToSP(configSaveBean);
                LogcatUtil.d("YdSDK-API", "保存策略成功");
                return;
            }
            return;
        }
        AdPlace handleData = handleData(jSONObject.optJSONObject("adplace"), str2, str3);
        if (handleData != null) {
            handleData.request_logic = jSONObject.optInt("request_logic", 0);
            LogcatUtil.d("YdSDK-API", "请求策略成功");
            if (!this.isTimeout[0]) {
                apiSaaSListener.onSuccess(handleData);
                sdkTrafficReq(handleData.req_id, str3, handleData.group_id, handleData.test_id, handleData.track_id, false, j);
            }
            if (z) {
                ConfigSaveBean configSaveBean2 = new ConfigSaveBean();
                configSaveBean2.setKey(str3);
                configSaveBean2.setGroupId(handleData.group_id);
                configSaveBean2.setTestId(handleData.test_id);
                configSaveBean2.setTime(handleData.update_time);
                configSaveBean2.setConfig(str);
                saveConfigToSP(configSaveBean2);
                LogcatUtil.d("YdSDK-API", "保存策略成功");
            }
        } else {
            sdkTrafficReq("", str3, "", "", "", false, j);
            apiSaaSListener.onFailed("Incorrect configuration information");
        }
        handleCrashReport(jSONObject);
    }

    private JSONObject requestParam(String str, String str2) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, str2);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt(PluginConstants.KEY_APP_ID, DeviceUtil.appId);
            jSONObject.putOpt("place_id", str);
            ConfigSaveBean configBean = getConfigBean(str);
            if (configBean != null) {
                LogcatUtil.d("YdSDK-API", "req update_time: " + configBean.getTime());
                jSONObject.putOpt("group_id", configBean.getGroupId());
                jSONObject.putOpt("test_id", configBean.getTestId());
                obj = Long.valueOf(configBean.getTime());
            } else {
                LogcatUtil.d("YdSDK-API", "req update_time: 0");
                jSONObject.putOpt("group_id", "");
                jSONObject.putOpt("test_id", "");
                obj = 0;
            }
            jSONObject.putOpt("update_time", obj);
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
            JSONArray jSONArray = DeviceUtil.appList;
            if (jSONArray != null && jSONArray.length() > 0) {
                if (YdConfig.getInstance().hasDisableAppListAccess()) {
                    if (this.installeds == null) {
                        this.installeds = new ArrayList();
                    }
                    this.installeds.clear();
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < DeviceUtil.appList.length(); i++) {
                    JSONObject optJSONObject = DeviceUtil.appList.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("bundle");
                        if (DeviceUtil.checkApkExist(optString)) {
                            List<String> list = this.installeds;
                            if (list != null) {
                                list.add(optString);
                            }
                            jSONArray2.put(optString);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.putOpt("app_list", jSONArray2);
                }
                SPUtil.getInstance().put(SPUtil.UPLOAD_DATE, DeviceUtil.getDate());
                DeviceUtil.appList = null;
            }
            jSONObject.putOpt("cycle_limit", Long.valueOf(this.showCount));
            return jSONObject;
        } catch (JSONException e) {
            e = e;
            e.printStackTrace();
            return jSONObject;
        } catch (Throwable th) {
            e = th;
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject requestSdkBidParam(List<AdSource> list, String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("place_id", str);
            JSONArray jSONArray = new JSONArray();
            Object obj = "";
            Object obj2 = "";
            for (AdSource adSource : list) {
                Object obj3 = adSource.group_id;
                Object obj4 = adSource.test_id;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("bidfloor", Integer.valueOf(adSource.bidfloor));
                jSONObject2.putOpt("bidfloorcur", WindAds.CNY);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("h", 1920);
                jSONObject3.putOpt(IAdInterListener.AdReqParam.WIDTH, 1080);
                jSONObject3.putOpt("minduration", 5);
                jSONObject3.putOpt("maxduration", 60);
                jSONObject2.putOpt("video", jSONObject3);
                jSONObject2.putOpt(PluginConstants.KEY_APP_ID, adSource.app_id);
                jSONObject2.putOpt("tagid", adSource.tagid);
                jSONObject2.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
                jSONObject2.putOpt("slot_id", adSource.slot_id);
                jSONObject2.putOpt("buyer_id", adSource.buyer_id);
                jSONObject2.putOpt("support_h265", Boolean.TRUE);
                jSONObject2.putOpt("support_splash_zoomout", Boolean.FALSE);
                jSONObject2.putOpt("sdk_info", adSource.sdk_info);
                jSONObject2.putOpt("opensdk_ver", adSource.opensdk_ver);
                jSONObject2.putOpt("h", Integer.valueOf(adSource.adSizeH));
                jSONObject2.putOpt(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(adSource.adSizeW));
                jSONArray.put(jSONObject2);
                obj = obj3;
                obj2 = obj4;
            }
            jSONObject.putOpt("imp", jSONArray);
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(WindAds.CNY);
            jSONObject.putOpt("cur", jSONArray2);
            jSONObject.putOpt("api_timeout", Integer.valueOf(i));
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("group_id", obj);
            jSONObject.putOpt("test_id", obj2);
            jSONObject.putOpt(f.f13353a, str2);
            return jSONObject;
        } catch (JSONException e) {
            e = e;
            e.printStackTrace();
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject requestServerVerifyParam(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("user_id", str);
            jSONObject.putOpt("custom_parameters", str2);
            jSONObject.putOpt(PluginConstants.KEY_APP_ID, str3);
            jSONObject.putOpt("place_id", str4);
            jSONObject.putOpt("transaction_id", str5);
            jSONObject.putOpt("reward_ecpm", str6);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void saveConfigToSP(ConfigSaveBean configSaveBean) {
        if (configSaveBean != null) {
            SPUtil.getInstance().putString(CtFAbx.B25kr6(new StringBuilder(), configSaveBean.getKey(), "_config"), configSaveBean.getGroupId() + "," + configSaveBean.getTestId() + "," + configSaveBean.getTime() + "," + configSaveBean.getConfig());
        }
    }

    private void setVideoMutePlay(String str, boolean z) {
        if (this.videoMutePlay == null) {
            this.videoMutePlay = new HashMap();
        }
        this.videoMutePlay.put(str, Boolean.valueOf(z));
    }

    private void startReq(String str, ApiSaaSListener apiSaaSListener, int i, long j) {
        ConfigHelper configHelper;
        final String str2;
        final ApiSaaSListener apiSaaSListener2;
        final long j2;
        final String reqID = DeviceUtil.getReqID(str);
        if (i > 0) {
            configHelper = this;
            str2 = str;
            apiSaaSListener2 = apiSaaSListener;
            j2 = j;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.fl.saas.base.rest.ConfigHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject parseResponseNew;
                    if (ConfigHelper.this.isReqDone[0]) {
                        return;
                    }
                    LogcatUtil.d("YdSDK-API", "Configure timeout and use the local policy");
                    String config = ConfigHelper.this.getConfig(str2);
                    if (TextUtils.isEmpty(config) || (parseResponseNew = NetDataUtils.parseResponseNew(config)) == null) {
                        return;
                    }
                    AdPlace handleData = ConfigHelper.this.handleData(parseResponseNew.optJSONObject("adplace"), reqID, str2);
                    if (handleData != null) {
                        ConfigHelper.this.isTimeout[0] = true;
                        LogcatUtil.d("YdSDK-API", "超时使用缓存策略成功");
                        long currentTimeMillis = System.currentTimeMillis() - j2;
                        apiSaaSListener2.onSuccess(handleData);
                        ConfigHelper.this.sdkTrafficReq(handleData.req_id, str2, handleData.group_id, handleData.test_id, handleData.track_id, false, currentTimeMillis);
                    }
                }
            }, i);
        } else {
            configHelper = this;
            str2 = str;
            apiSaaSListener2 = apiSaaSListener;
            j2 = j;
        }
        final long j3 = j2;
        final String str3 = str2;
        AdHttpUtils.getInstance().doPost(CommConstant.API.URL_CONFIG_NEW, AesUtils.encrypt(requestParam(str2, reqID).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.2
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                ConfigHelper.this.isReqDone[0] = true;
                LogcatUtil.d("YdSDK-API", "req onError: " + exc.getMessage());
                long currentTimeMillis = System.currentTimeMillis() - j3;
                String config = ConfigHelper.this.getConfig(str3);
                if (!TextUtils.isEmpty(config)) {
                    ConfigHelper.this.parseConfig(false, "", reqID, NetDataUtils.parseResponseNew(config), str3, apiSaaSListener2, currentTimeMillis);
                    return;
                }
                ConfigHelper.this.sdkTrafficReq(reqID, str3, "", "", "", false, currentTimeMillis);
                apiSaaSListener2.onFailed("config response error:" + exc.getMessage());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str4) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
            
                if (android.text.TextUtils.isEmpty(r14) == false) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0086, code lost:
            
                r13.this$0.sdkTrafficReq(r5, r4, "", "", "", false, r11);
                r6.onFailed("Incorrect configuration information");
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
            
                r13.this$0.parseConfig(false, "", r5, com.fl.saas.config.http.NetDataUtils.parseResponseNew(r14), r4, r6, r11);
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
            
                if (android.text.TextUtils.isEmpty(r14) == false) goto L19;
             */
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onSuccess(java.lang.String r14) {
                /*
                    r13 = this;
                    com.fl.saas.base.rest.ConfigHelper r0 = com.fl.saas.base.rest.ConfigHelper.this
                    boolean[] r0 = com.fl.saas.base.rest.ConfigHelper.access$000(r0)
                    r1 = 0
                    r2 = 1
                    r0[r1] = r2
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "ResponseData: "
                    r0.<init>(r1)
                    r0.append(r14)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "YdSDK-API"
                    com.fl.saas.config.utils.LogcatUtil.d(r1, r0)
                    long r0 = java.lang.System.currentTimeMillis()
                    long r2 = r2
                    long r11 = r0 - r2
                    boolean r0 = android.text.TextUtils.isEmpty(r14)
                    if (r0 != 0) goto L65
                    org.json.JSONObject r8 = com.fl.saas.config.http.NetDataUtils.parseResponseNew(r14)
                    if (r8 == 0) goto L57
                    java.lang.String r0 = "code"
                    boolean r1 = r8.has(r0)
                    if (r1 == 0) goto L57
                    r1 = -1
                    int r0 = r8.optInt(r0, r1)
                    if (r0 != 0) goto L57
                    java.lang.String r0 = "adplace"
                    boolean r0 = r8.has(r0)
                    if (r0 != 0) goto L57
                    com.fl.saas.base.rest.ConfigHelper r14 = com.fl.saas.base.rest.ConfigHelper.this
                    java.lang.String r0 = r4
                    java.lang.String r14 = com.fl.saas.base.rest.ConfigHelper.access$100(r14, r0)
                    boolean r0 = android.text.TextUtils.isEmpty(r14)
                    if (r0 != 0) goto L86
                    goto L73
                L57:
                    com.fl.saas.base.rest.ConfigHelper r4 = com.fl.saas.base.rest.ConfigHelper.this
                    java.lang.String r7 = r5
                    java.lang.String r9 = r4
                    com.fl.saas.common.listener.ApiSaaSListener r10 = r6
                    r5 = 1
                    r6 = r14
                    com.fl.saas.base.rest.ConfigHelper.access$300(r4, r5, r6, r7, r8, r9, r10, r11)
                    return
                L65:
                    com.fl.saas.base.rest.ConfigHelper r14 = com.fl.saas.base.rest.ConfigHelper.this
                    java.lang.String r0 = r4
                    java.lang.String r14 = com.fl.saas.base.rest.ConfigHelper.access$100(r14, r0)
                    boolean r0 = android.text.TextUtils.isEmpty(r14)
                    if (r0 != 0) goto L86
                L73:
                    org.json.JSONObject r8 = com.fl.saas.config.http.NetDataUtils.parseResponseNew(r14)
                    com.fl.saas.base.rest.ConfigHelper r4 = com.fl.saas.base.rest.ConfigHelper.this
                    java.lang.String r7 = r5
                    java.lang.String r9 = r4
                    com.fl.saas.common.listener.ApiSaaSListener r10 = r6
                    r5 = 0
                    java.lang.String r6 = ""
                    com.fl.saas.base.rest.ConfigHelper.access$300(r4, r5, r6, r7, r8, r9, r10, r11)
                    return
                L86:
                    com.fl.saas.base.rest.ConfigHelper r4 = com.fl.saas.base.rest.ConfigHelper.this
                    java.lang.String r5 = r5
                    java.lang.String r6 = r4
                    java.lang.String r9 = ""
                    r10 = 0
                    java.lang.String r7 = ""
                    java.lang.String r8 = ""
                    r4.sdkTrafficReq(r5, r6, r7, r8, r9, r10, r11)
                    com.fl.saas.common.listener.ApiSaaSListener r14 = r6
                    java.lang.String r0 = "Incorrect configuration information"
                    r14.onFailed(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.rest.ConfigHelper.AnonymousClass2.onSuccess(java.lang.String):void");
            }
        });
    }

    public synchronized void addShowCount() {
        this.showCount++;
        SPUtil.getInstance().putLong("showCount", this.showCount);
    }

    public int getCacheAdTime() {
        return this.cacheAdTime;
    }

    public int getCacheSwitch() {
        return this.cacheSwitch;
    }

    public List<String> getInstalleds() {
        return this.installeds;
    }

    public int getQueueNum() {
        return this.queueNum;
    }

    public boolean getVideoSoundEnable(String str) {
        if (this.videoMutePlay != null) {
            return !Boolean.TRUE.equals(r0.get(str));
        }
        return false;
    }

    public AdPlace handleData(JSONObject jSONObject, String str, String str2) {
        try {
            AdPlace adPlace = new AdPlace();
            String reqID = DeviceUtil.getReqID(str2);
            adPlace.all_time = jSONObject.optInt("all_time");
            adPlace.group_id = jSONObject.optString("group_id");
            adPlace.place_id = jSONObject.optString("place_id");
            adPlace.req_id = TextUtils.isEmpty(str) ? DeviceUtil.getReqID(str2) : str;
            adPlace.test_id = jSONObject.optString("test_id");
            adPlace.request_num = jSONObject.optInt("request_num", 1);
            adPlace.timeout = jSONObject.optInt("timeout");
            adPlace.requestInterval = jSONObject.optInt("request_interval", 500);
            adPlace.has_api_bid = jSONObject.optBoolean("has_api_bid");
            adPlace.api_timeout = jSONObject.optInt("api_timeout", 3000);
            adPlace.client_timeout = jSONObject.optInt("client_timeout", 5000);
            adPlace.server_verify = jSONObject.optBoolean("server_verify", false);
            if ("A".equals(jSONObject.optString("adv_cache_sts", "S"))) {
                adPlace.isOpenCache = true;
            }
            adPlace.enhanceTarget = jSONObject.optInt("enhance_target", 0);
            adPlace.cacheValidTime = jSONObject.optInt("adv_cache_time", 30) * 60 * 1000;
            adPlace.floatingRatio = jSONObject.optDouble("floating_ratio", 1.0d);
            JSONArray optJSONArray = jSONObject.optJSONArray("adv_cacheabled_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                adPlace.advCacheabledList = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    adPlace.advCacheabledList.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            adPlace.track_id = reqID;
            adPlace.refresh_num = jSONObject.optInt("refresh_num", 0);
            adPlace.bid_notice_type = jSONObject.optInt("bid_notice_type", 0);
            adPlace.impress_freq_hour = jSONObject.optInt("impress_freq_hour", 0);
            adPlace.impress_freq_day = jSONObject.optInt("impress_freq_day", 0);
            adPlace.impress_interval = jSONObject.optInt("impress_interval", 0);
            adPlace.update_time = jSONObject.optLong("update_time", 0L);
            adPlace.cache_queue_length = jSONObject.optInt("cache_queue_length", 1);
            adPlace.use_public_adplace = jSONObject.optInt("use_public_adplace", 1);
            adPlace.rela_public_adplace = jSONObject.optInt("rela_public_adplace", 0);
            adPlace.lbs = jSONObject.optInt("lbs", 0);
            adPlace.lbjg = jSONObject.optInt("lbjg", 5);
            adPlace.lbsx = jSONObject.optInt("lbsx", 3);
            adPlace.highest_bid_difference = jSONObject.optInt("highest_bid_difference", 0);
            adPlace.refresh = jSONObject.optInt("refresh", 0);
            adPlace.refresh_time = jSONObject.optInt("refresh_time", 30);
            adPlace.verify_ad_refresh = jSONObject.optInt("verify_ad_refresh", 0);
            adPlace.fill_price = jSONObject.optInt("fill_price", 1);
            QuickAppHelper.getInstance().setEnableQuickApp(adPlace.place_id, jSONObject.optInt("enable_quick_app", 1));
            try {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("quick_app_list");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList.add(optJSONArray2.optString(i2));
                    }
                    QuickAppHelper.getInstance().addListQuickKey(arrayList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVideoMutePlay(adPlace.place_id, jSONObject.optInt("video_mute_playback", 1) == 1);
            int optInt = jSONObject.optInt("bg_wake_up", 0);
            int optInt2 = jSONObject.optInt("bg_wake_up_time", 300);
            if (optInt == 1 && optInt2 > 0) {
                YdAppBackgroundUtil.getInstance().setPlaceId(adPlace.place_id);
                YdAppBackgroundUtil.getInstance().setWakeUpTime(optInt2 * 1000);
            }
            adPlace.ad_sources = buildAdSourceList(str, jSONObject, "ad_sources", reqID);
            adPlace.bid_ad_sources = buildAdSourceList(str, jSONObject, "bid_ad_sources", reqID);
            adPlace.bottom_ad_sources = buildAdSourceList(str, jSONObject, "bottom_ad_sources", reqID);
            adPlace.c2s_bid_ad_sources = buildAdSourceList(str, jSONObject, "client_bid_ad_sources", reqID);
            return adPlace;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void initShowCount() {
        this.showCount = SPUtil.getInstance().getLong("showCount", 0L);
    }

    public void reqSDKBid(List<AdSource> list, String str, String str2, int i, final SdkBidListener sdkBidListener) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_SDK_BID, AesUtils.encrypt(requestSdkBidParam(list, str, str2, i).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.4
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDK-API", "req onError: " + exc.getMessage());
                sdkBidListener.onFailed("config response error:" + exc.getMessage());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str3) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str3) {
                LogcatUtil.d("YdSDK-API", "ResponseData: " + str3);
                JSONObject parseResponseNew = NetDataUtils.parseResponseNew(str3);
                if (parseResponseNew != null) {
                    sdkBidListener.onSuccess(parseResponseNew);
                } else {
                    sdkBidListener.onFailed("config response is null");
                }
            }
        });
    }

    public void reqVideoVerify(String str, String str2, String str3, String str4, String str5, String str6, final VideoVerifyRequstListener videoVerifyRequstListener) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_VIDEO_SERVER_VERIFY, AesUtils.encrypt(requestServerVerifyParam(str, str2, str3, str4, str5, str6).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.3
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str7) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str7) {
                LogcatUtil.d("YdSDK-API", "VideoVerify:" + str7);
                if (TextUtils.isEmpty(str7) || !str7.equals(cb.o)) {
                    return;
                }
                videoVerifyRequstListener.onResult();
            }
        });
    }

    public void requestConfig(String str, ApiSaaSListener apiSaaSListener, long j) {
        JSONObject optJSONObject;
        try {
            this.isReqDone[0] = false;
            this.isTimeout[0] = false;
            String config = getConfig(str);
            if (TextUtils.isEmpty(config) || (optJSONObject = NetDataUtils.parseResponseNew(config).optJSONObject("adplace")) == null) {
                startReq(str, apiSaaSListener, -1, j);
            } else {
                startReq(str, apiSaaSListener, optJSONObject.optInt("config_timeout"), j);
            }
        } catch (Throwable unused) {
            startReq(str, apiSaaSListener, -1, j);
        }
    }

    public void sdkTrafficReq(String str, String str2, String str3, String str4, String str5, boolean z, long j) {
        AdSource adSource = new AdSource();
        adSource.req_id = str;
        adSource.place_id = str2;
        adSource.group_id = str3;
        adSource.test_id = str4;
        adSource.isPreload = z;
        adSource.track_id = str5;
        adSource.cost_time = j;
        ReportHelper.getInstance().reportRequestAd(adSource);
    }

    public void setCacheAdTime(int i) {
        this.cacheAdTime = i;
    }

    public void setCacheSwitch(int i) {
        this.cacheSwitch = i;
    }

    public void setQueueNum(int i) {
        this.queueNum = i;
    }
}
