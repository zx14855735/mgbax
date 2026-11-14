package com.bytedance.sdk.component.u;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.u.xj;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements xj {
    Function xj;

    public u(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public byte[] decrypt(byte[] bArr) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        apply = this.xj.apply(sparseArray);
        return (byte[]) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String decryptWithCBC(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(3, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean detectHostLocalIp(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(6, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean enableSetHARSensorCallBack(int i) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(25, sparseArray, 0, i, 1);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public byte[] encrypt(byte[] bArr) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bArr);
        apply = this.xj.apply(sparseArray);
        return (byte[]) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String getArchEnv() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public Context getArmorContext() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        apply = this.xj.apply(sparseArray);
        return (Context) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean getArmorLoadStatus() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String getSoftChara() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public int getSpecificArmorLoadStatus() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void initPglArmorCallApi(xj.hf hfVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        if (hfVar != null) {
            hfVar = new w(hfVar);
        }
        sparseArray.put(1, hfVar);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void initPglCryptUtils() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, motionEvent);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(9, sparseArray, 0, 1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(4, Integer.valueOf(i));
        sparseArray.put(5, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public String pglArmorCallApi2getProperty(String str, String str2) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(11, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApi2src(long j, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void pglArmorCallApiCancelListener() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean registerHarSensors() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void setBlt(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void setHARSensorCallBack(xj.InterfaceC0120xj interfaceC0120xj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        if (interfaceC0120xj != null) {
            interfaceC0120xj = new hf(interfaceC0120xj);
        }
        sparseArray.put(1, interfaceC0120xj);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public boolean signVerifyMD5withRSA(String str, String str2) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(5, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void softDecTool2ua(double d, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Double.valueOf(d));
        sparseArray.put(3, Long.valueOf(j));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateHARSettings(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, jSONObject);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateNetworkStatus(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(21, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj
    public void updateScreenStatus(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(20, sparseArray, 0, 1, str);
        this.xj.apply(sparseArray);
    }
}
