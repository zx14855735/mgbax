package com.bytedance.sdk.component.u;

import android.content.Context;
import android.view.MotionEvent;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface xj {

    public interface hf {
        void reportSoftDecData(String str, JSONObject jSONObject);

        void setCryptInitStatus(long j, boolean z);
    }

    /* renamed from: com.bytedance.sdk.component.u.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0120xj {
        void reportSensorData(JSONObject jSONObject);
    }

    byte[] decrypt(byte[] bArr);

    String decryptWithCBC(String str);

    boolean detectHostLocalIp(String str);

    boolean enableSetHARSensorCallBack(int i);

    byte[] encrypt(byte[] bArr);

    String getArchEnv();

    Context getArmorContext();

    boolean getArmorLoadStatus();

    String getSoftChara();

    int getSpecificArmorLoadStatus();

    void initPglArmorCallApi(hf hfVar);

    void initPglCryptUtils();

    void pglArmorCallApi2c(MotionEvent motionEvent);

    String pglArmorCallApi2ccc(String str, long j, int i, boolean z);

    String pglArmorCallApi2getProperty(String str, String str2);

    void pglArmorCallApi2src(long j, int i);

    void pglArmorCallApiCancelListener();

    boolean registerHarSensors();

    void setBlt(boolean z);

    void setHARSensorCallBack(InterfaceC0120xj interfaceC0120xj);

    boolean signVerifyMD5withRSA(String str, String str2);

    void softDecTool2ua(double d, long j);

    void updateHARSettings(JSONObject jSONObject);

    void updateNetworkStatus(int i);

    void updateScreenStatus(String str);
}
