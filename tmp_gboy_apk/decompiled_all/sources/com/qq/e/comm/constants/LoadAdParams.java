package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LoadAdParams {

    /* renamed from: A2egSU, reason: collision with root package name */
    public LoginType f12913A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public String f12914A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public String f12915A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public String f12916ADYaiT;
    public Map AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public JSONObject f12917ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final JSONObject f12918ASJ6gh = new JSONObject();

    public Map getDevExtra() {
        return this.AMqCpz;
    }

    public String getDevExtraJsonString() {
        try {
            Map map = this.AMqCpz;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.AMqCpz).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f12917ARc23Z;
    }

    public String getLoginAppId() {
        return this.f12914A4TApA;
    }

    public String getLoginOpenid() {
        return this.f12915A5SV6n;
    }

    public LoginType getLoginType() {
        return this.f12913A2egSU;
    }

    public JSONObject getParams() {
        return this.f12918ASJ6gh;
    }

    public String getUin() {
        return this.f12916ADYaiT;
    }

    public void setDevExtra(Map<String, String> map) {
        this.AMqCpz = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f12917ARc23Z = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f12914A4TApA = str;
    }

    public void setLoginOpenid(String str) {
        this.f12915A5SV6n = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f12913A2egSU = loginType;
    }

    public void setUin(String str) {
        this.f12916ADYaiT = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f12913A2egSU + ", loginAppId=" + this.f12914A4TApA + ", loginOpenid=" + this.f12915A5SV6n + ", uin=" + this.f12916ADYaiT + ", passThroughInfo=" + this.AMqCpz + ", extraInfo=" + this.f12917ARc23Z + '}';
    }
}
