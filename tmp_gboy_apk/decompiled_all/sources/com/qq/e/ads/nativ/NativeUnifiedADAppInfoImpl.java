package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f12846A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f12847A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final long f12848A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f12849ADYaiT;
    public final String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final String f12850ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final String f12851ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final String f12852AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final String f12853AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final String f12854AZkASS;

    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_INFO_URL = "icp_info_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String SUITABLE_AGE = "suitable_age";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f12846A2egSU = jSONObject.optString("app_name");
        this.f12847A4TApA = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f12848A5SV6n = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f12849ADYaiT = jSONObject.optString(Keys.PERMISSION_URL);
        this.AMqCpz = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f12850ARc23Z = jSONObject.optString(Keys.VERSION_NAME);
        this.f12851ASJ6gh = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.f12852AYUAbz = jSONObject.optString(Keys.ICP_NUMBER);
        this.f12853AZOQYO = jSONObject.optString(Keys.SUITABLE_AGE);
        this.f12854AZkASS = jSONObject.optString(Keys.ICP_INFO_URL);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f12846A2egSU;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f12847A4TApA;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f12851ASJ6gh;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpInfoUrl() {
        return this.f12854AZkASS;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f12852AYUAbz;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f12848A5SV6n;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f12849ADYaiT;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.AMqCpz;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getSuitableAge() {
        return this.f12853AZOQYO;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f12850ARc23Z;
    }
}
