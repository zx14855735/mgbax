package com.bytedance.sdk.openadsdk.ats;

import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.c;
import com.bytedance.sdk.component.panglearmor.d;
import com.bytedance.sdk.component.panglearmor.hf.u;
import com.bytedance.sdk.component.u.xj;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.component.u.xj, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return encrypt((byte[]) sparseArray.get(1));
            case 2:
                return Boolean.valueOf(getArmorLoadStatus());
            case 3:
                return decryptWithCBC((String) sparseArray.get(1));
            case 4:
                return decrypt((byte[]) sparseArray.get(1));
            case 5:
                return Boolean.valueOf(signVerifyMD5withRSA((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 6:
                return Boolean.valueOf(detectHostLocalIp((String) sparseArray.get(1)));
            case 7:
                return getSoftChara();
            case 8:
                pglArmorCallApi2c((MotionEvent) sparseArray.get(1));
                return null;
            case 9:
                return pglArmorCallApi2ccc((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 10:
                pglArmorCallApi2src(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                break;
            case 11:
                return pglArmorCallApi2getProperty((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 12:
                return getArmorContext();
            case 13:
                return getArchEnv();
            case 14:
                setBlt(((Boolean) sparseArray.get(1)).booleanValue());
                break;
            case 15:
                softDecTool2ua(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                break;
            case 16:
                Object obj2 = sparseArray.get(1);
                if (obj2 != null) {
                    obj2 = new com.bytedance.sdk.component.u.hf(AaHO0E.AYUAbz(obj2));
                }
                setHARSensorCallBack((xj.InterfaceC0120xj) obj2);
                break;
            case 17:
                return Boolean.valueOf(registerHarSensors());
            case 18:
                Object obj3 = sparseArray.get(1);
                if (obj3 != null) {
                    obj3 = new com.bytedance.sdk.component.u.w(AaHO0E.AYUAbz(obj3));
                }
                initPglArmorCallApi((xj.hf) obj3);
                break;
            case 19:
                pglArmorCallApiCancelListener();
                break;
            case 20:
                updateScreenStatus((String) sparseArray.get(1));
                break;
            case 21:
                updateNetworkStatus(((Integer) sparseArray.get(1)).intValue());
                break;
            case 22:
                return Integer.valueOf(getSpecificArmorLoadStatus());
            case 23:
                updateHARSettings((JSONObject) sparseArray.get(1));
                break;
            case 24:
                initPglCryptUtils();
                break;
            case 25:
                return Boolean.valueOf(enableSetHARSensorCallBack(((Integer) sparseArray.get(1)).intValue()));
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public byte[] decrypt(byte[] bArr) {
        return d.xj().hf(bArr);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String decryptWithCBC(String str) {
        return d.xj().xj(str);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean detectHostLocalIp(String str) {
        return com.bytedance.sdk.component.panglearmor.u.xj(str);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean enableSetHARSensorCallBack(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean hf = com.bytedance.sdk.component.panglearmor.hf.kd.xj().hf();
        boolean z = ((long) (i - 1)) % com.bytedance.sdk.component.panglearmor.hf.kd.xj().kd() == 0;
        boolean z2 = currentTimeMillis - com.bytedance.sdk.component.panglearmor.hf.u.xj().u() > com.bytedance.sdk.component.panglearmor.hf.kd.xj().u();
        boolean w = com.bytedance.sdk.component.panglearmor.hf.u.xj().w();
        com.bytedance.sdk.component.panglearmor.hf.kd.xj();
        com.bytedance.sdk.component.panglearmor.hf.kd.xj();
        com.bytedance.sdk.component.panglearmor.hf.kd.xj();
        com.bytedance.sdk.component.panglearmor.hf.kd.xj();
        return z && z2 && hf && !w;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public byte[] encrypt(byte[] bArr) {
        return d.xj().xj(bArr);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String getArchEnv() {
        return com.bytedance.sdk.component.panglearmor.y.w();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public Context getArmorContext() {
        return com.bytedance.sdk.component.panglearmor.y.u();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean getArmorLoadStatus() {
        return d.hf();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String getSoftChara() {
        return com.bytedance.sdk.component.panglearmor.y.hf();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public int getSpecificArmorLoadStatus() {
        return d.w();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void initPglArmorCallApi(final xj.hf hfVar) {
        c.xj xj = new c.xj(pz.getContext(), ai.y(), "7132").xj(true);
        xj.xj(new com.bytedance.sdk.component.panglearmor.f() { // from class: com.bytedance.sdk.openadsdk.ats.hf.2
            @Override // com.bytedance.sdk.component.panglearmor.f
            public void xj(long j, boolean z) {
                hfVar.setCryptInitStatus(j, z);
            }

            @Override // com.bytedance.sdk.component.panglearmor.f
            public void xj(String str, JSONObject jSONObject) {
                hfVar.reportSoftDecData(str, jSONObject);
            }
        });
        com.bytedance.sdk.component.panglearmor.y.xj(xj.xj());
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void initPglCryptUtils() {
        d.xj();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        com.bytedance.sdk.component.panglearmor.y.xj(motionEvent);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        return com.bytedance.sdk.component.panglearmor.y.xj(str, j, i, z);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String pglArmorCallApi2getProperty(String str, String str2) {
        return com.bytedance.sdk.component.panglearmor.y.xj(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApi2src(long j, int i) {
        com.bytedance.sdk.component.panglearmor.y.xj(j, i);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApiCancelListener() {
        com.bytedance.sdk.component.panglearmor.y.xj();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean registerHarSensors() {
        return com.bytedance.sdk.component.panglearmor.hf.u.xj().hf();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void setBlt(boolean z) {
        SoftDecTool.setBlt(z);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void setHARSensorCallBack(final xj.InterfaceC0120xj interfaceC0120xj) {
        com.bytedance.sdk.component.panglearmor.hf.u.xj().xj(new u.xj() { // from class: com.bytedance.sdk.openadsdk.ats.hf.1
            @Override // com.bytedance.sdk.component.panglearmor.hf.u.xj
            public void xj(JSONObject jSONObject) {
                interfaceC0120xj.reportSensorData(jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean signVerifyMD5withRSA(String str, String str2) {
        return com.bytedance.sdk.component.panglearmor.u.xj(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void softDecTool2ua(double d, long j) {
        SoftDecTool.ua(d, j);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateHARSettings(JSONObject jSONObject) {
        com.bytedance.sdk.component.panglearmor.hf.kd.xj().xj(jSONObject);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateNetworkStatus(int i) {
        com.bytedance.sdk.component.panglearmor.hf.hf.xj().xj(i);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateScreenStatus(String str) {
        com.bytedance.sdk.component.panglearmor.hf.hf.xj().hf(str);
    }
}
