package com.bytedance.sdk.component.u.xj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj {
    Function xj;

    public hf(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getAndroidId() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getAppLogDid() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getBoot() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getBuildSerial() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getCarrierName() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getCompilingTime() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getConnType() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDeviceModel() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDeviceName() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getDeviceType(boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDisplayDensity() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getIP() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getImei(Boolean bool) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, bool);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getImsi(Boolean bool) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        sparseArray.put(1, bool);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getIpv6() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getLanguage() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getLocalLanguage() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.u.xj.xj
    public w getLocation() {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        apply = this.xj.apply(sparseArray);
        u uVar = apply;
        if (apply != 0) {
            uVar = new u((Function) apply);
        }
        return uVar;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMacAddress(Boolean bool) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, bool);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMcc() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMnc() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String[] getNewIpAddrs(boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return (String[]) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getOAID(boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getOs() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getOsVersion() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getRom() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getSSID(Boolean bool) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, bool);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTimeZone() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getTimeZoneInt() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTotalMem() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTotalSpace() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getUUId() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getUserAgent() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getVendor() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getWebViewUA() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getWifiMac(Boolean bool) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, bool);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }
}
