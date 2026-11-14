package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationNativeAdAppInfo {
    private String c;
    private Map<String, Object> d;
    private String f;
    private String hf;
    private Map<String, String> kd;
    private String tf;
    private String u;
    private long w;
    private String xj;
    private String y;

    public Map<String, Object> getAppInfoExtra() {
        return this.d;
    }

    public String getAppName() {
        return this.xj;
    }

    public String getAuthorName() {
        return this.hf;
    }

    public String getFunctionDescUrl() {
        return this.f;
    }

    public long getPackageSizeBytes() {
        return this.w;
    }

    public Map<String, String> getPermissionsMap() {
        return this.kd;
    }

    public String getPermissionsUrl() {
        return this.u;
    }

    public String getPrivacyAgreement() {
        return this.y;
    }

    public String getRegUrl() {
        return this.tf;
    }

    public String getVersionName() {
        return this.c;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.d = map;
    }

    public void setAppName(String str) {
        this.xj = str;
    }

    public void setAuthorName(String str) {
        this.hf = str;
    }

    public void setFunctionDescUrl(String str) {
        this.f = str;
    }

    public void setPackageSizeBytes(long j) {
        this.w = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.kd = map;
    }

    public void setPermissionsUrl(String str) {
        this.u = str;
    }

    public void setPrivacyAgreement(String str) {
        this.y = str;
    }

    public void setRegUrl(String str) {
        this.tf = str;
    }

    public void setVersionName(String str) {
        this.c = str;
    }
}
