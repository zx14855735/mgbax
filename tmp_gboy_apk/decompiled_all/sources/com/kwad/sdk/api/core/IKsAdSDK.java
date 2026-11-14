package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

@KsAdSdkDynamicApi("com.kwad.sdk.KsAdSDKImpl")
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface IKsAdSDK {
    @A2egSU
    void addHp(Map<String, String> map);

    @A2egSU
    Object dM(String str, Object... objArr);

    @KsAdSdkDynamicApi
    @A2egSU
    void deleteCache();

    @KsAdSdkDynamicApi
    @A2egSU
    KsLoadManager getAdManager();

    @KsAdSdkDynamicApi
    @A2egSU
    String getApiVersion();

    @KsAdSdkDynamicApi
    @A2egSU
    int getApiVersionCode();

    @KsAdSdkDynamicApi
    @A2egSU
    String getAppId();

    @KsAdSdkDynamicApi
    @A2egSU
    JSONObject getAppInfo();

    @KsAdSdkDynamicApi
    @A2egSU
    String getAppName();

    @KsAdSdkDynamicApi
    @A2egSU
    Context getContext();

    @KsAdSdkDynamicApi
    @A2egSU
    JSONObject getDeviceInfo();

    @KsAdSdkDynamicApi
    @A2egSU
    String getDid();

    @KsAdSdkDynamicApi
    @A2egSU
    JSONObject getNetworkInfo();

    @A2egSU
    String getRD(String str);

    @A2egSU
    String getRM(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    int getSDKType();

    @KsAdSdkDynamicApi
    @A2egSU
    String getSDKVersion();

    @KsAdSdkDynamicApi
    @A2egSU
    int getSDKVersionCode();

    @KsAdSdkDynamicApi
    @A2egSU
    void init(Context context, SdkConfig sdkConfig);

    @KsAdSdkDynamicApi
    @A2egSU
    boolean isDebugLogEnable();

    @KsAdSdkDynamicApi
    @A2egSU
    <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    <T> T newInstance(Class<T> cls);

    @KsAdSdkDynamicApi
    @A2egSU
    void pauseCurrentPlayer();

    @A2egSU
    void re(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    void reportBatchEvent(int i, Map<String, Object> map);

    @KsAdSdkDynamicApi
    @A2egSU
    void resumeCurrentPlayer();

    @A2egSU
    void sR(String str, Map<String, String> map, String str2);

    @KsAdSdkApi
    @A2egSU
    void setAdxEnable(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setApiVersion(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void setApiVersionCode(int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void setAppTag(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void setInitStartTime(long j);

    @KsAdSdkDynamicApi
    @A2egSU
    void setIsExternal(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setLaunchTime(long j);

    @KsAdSdkDynamicApi
    @A2egSU
    void setLoadingLottieAnimation(boolean z, int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void setLoadingLottieAnimationColor(boolean z, int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void setPersonalRecommend(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setProgrammaticRecommend(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setThemeMode(int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void start();

    @KsAdSdkDynamicApi
    @A2egSU
    void unInit();
}
