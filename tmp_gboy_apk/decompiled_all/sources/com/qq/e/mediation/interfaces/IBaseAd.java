package com.qq.e.mediation.interfaces;

import java.util.Map;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i, int i2, String str);

    void sendWinNotification(int i);

    void setBidECPM(int i);

    void setPayload(String str);
}
