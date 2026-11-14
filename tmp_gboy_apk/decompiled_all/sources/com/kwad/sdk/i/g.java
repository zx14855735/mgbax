package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g {
    private String Ml;
    private JSONObject aBT;
    private String aGW;
    private String aGX;
    private String aMW;
    private String aMa;
    private JSONObject aXJ;
    private boolean aXK;
    private String appId;
    private Map<String, String> arl;
    private String sdkVersion;

    private g() {
    }

    public static g ON() {
        return new g();
    }

    public final JSONObject OO() {
        return this.aXJ;
    }

    public final boolean OP() {
        return this.aXK;
    }

    public final String OQ() {
        return this.aMa;
    }

    public final JSONObject OR() {
        return this.aBT;
    }

    public final g bP(boolean z) {
        this.aXK = z;
        return this;
    }

    public final String getAndroidId() {
        return this.aMW;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.Ml;
    }

    public final String getImei() {
        return this.aGW;
    }

    public final String getOaid() {
        return this.aGX;
    }

    public final Map<String, String> getRequestHeader() {
        return this.arl;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g gr(String str) {
        this.appId = str;
        return this;
    }

    public final g gs(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gt(String str) {
        this.aGX = str;
        return this;
    }

    public final g gu(String str) {
        this.Ml = str;
        return this;
    }

    public final g gv(String str) {
        this.aMW = str;
        return this;
    }

    public final g gw(String str) {
        this.aGW = str;
        return this;
    }

    public final g gx(String str) {
        this.aMa = str;
        return this;
    }

    public final g i(Map<String, String> map) {
        this.arl = map;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.aXJ = jSONObject;
        return this;
    }

    public final g o(JSONObject jSONObject) {
        this.aBT = jSONObject;
        return this;
    }
}
