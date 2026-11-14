package com.kwad.components.offline.api.core.adInnerEc;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.content.Context;
import java.util.Map;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IPluginDataService {
    void convert(String str);

    Activity getActivityFromContext(Context context);

    String getAppChannel();

    String getAppOriginChannel();

    String getAppVersion();

    String getBoardPlatform();

    int getCloudIdTag();

    int getDeviceIdTag();

    String getDeviceName();

    int getIntConfig(String str);

    String getKwaiServiceId();

    String getKwaiServiceToken();

    String getKwaiUserId();

    String getLaneId();

    String getODeviceId();

    int getOperatorType();

    String getRDeviceId();

    String getSocNameV2();

    String getThermalStatus();

    String getUserId();

    boolean isAgreePrivacy();

    boolean isAppOnForeground();

    boolean isOpenTeenageMode();

    void onDestroy();

    void reportException(Throwable th);

    void request(Map<String, Object> map, IKRNRequestListener iKRNRequestListener);

    void showToast(String str);
}
