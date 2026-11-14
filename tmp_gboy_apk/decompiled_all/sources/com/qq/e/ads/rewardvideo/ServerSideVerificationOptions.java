package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f12873A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f12874A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final JSONObject f12875A5SV6n = new JSONObject();

    public static class Builder {

        /* renamed from: A2egSU, reason: collision with root package name */
        public String f12876A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public String f12877A4TApA;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f12876A2egSU = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f12877A4TApA = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f12873A2egSU = builder.f12876A2egSU;
        this.f12874A4TApA = builder.f12877A4TApA;
    }

    public String getCustomData() {
        return this.f12873A2egSU;
    }

    public JSONObject getOptions() {
        return this.f12875A5SV6n;
    }

    public String getUserId() {
        return this.f12874A4TApA;
    }
}
