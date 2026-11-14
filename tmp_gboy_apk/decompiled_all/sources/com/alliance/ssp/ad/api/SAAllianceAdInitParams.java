package com.alliance.ssp.ad.api;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class SAAllianceAdInitParams {
    private String androidId;
    private boolean canUseAndroidId;
    private boolean canUseCarrier;
    private boolean canUseIMei;
    private boolean canUseInstallAppList;
    private boolean canUseLocation;
    private boolean canUseMac;
    private boolean canUseMotionSensor;
    private boolean canUseOaid;
    private boolean canUseWifiState;
    private String carrier;
    private boolean enablePersonalized;
    private String imei;
    private boolean isDebug;
    private double[] location;
    private String mac;
    private String oaid;
    private String userId;

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public boolean f9699A2egSU = false;

        /* renamed from: A4TApA, reason: collision with root package name */
        public boolean f9700A4TApA = true;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public boolean f9701A5SV6n = true;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public boolean f9702ADYaiT = true;
        public boolean AMqCpz = true;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public boolean f9703ARc23Z = true;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public boolean f9704ASJ6gh = true;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public boolean f9705AYUAbz = true;
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public boolean getDebug() {
        return this.isDebug;
    }

    public String getImei() {
        return this.imei;
    }

    public double[] getLocation() {
        return this.location;
    }

    public String getMac() {
        return this.mac;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isCanUseAndroidId() {
        return this.canUseAndroidId;
    }

    public boolean isCanUseCarrier() {
        return this.canUseCarrier;
    }

    public boolean isCanUseIMei() {
        return this.canUseIMei;
    }

    public boolean isCanUseInstallAppList() {
        return this.canUseInstallAppList;
    }

    public boolean isCanUseLocation() {
        return this.canUseLocation;
    }

    public boolean isCanUseMac() {
        return this.canUseMac;
    }

    public boolean isCanUseMotionSensor() {
        return this.canUseMotionSensor;
    }

    public boolean isCanUseOaid() {
        return this.canUseOaid;
    }

    public boolean isCanUseWifiState() {
        return this.canUseWifiState;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isEnablePersonalized() {
        return this.enablePersonalized;
    }

    private SAAllianceAdInitParams(A2egSU a2egSU) {
        this.isDebug = false;
        this.androidId = "";
        this.imei = "";
        this.oaid = "";
        this.mac = "";
        this.enablePersonalized = true;
        this.userId = "";
        this.carrier = "";
        this.canUseIMei = true;
        this.canUseOaid = true;
        this.canUseAndroidId = true;
        this.canUseLocation = true;
        this.canUseMac = true;
        this.canUseCarrier = true;
        this.canUseInstallAppList = true;
        this.canUseMotionSensor = true;
        this.canUseWifiState = true;
        this.isDebug = a2egSU.f9699A2egSU;
        this.androidId = "";
        this.imei = "";
        this.oaid = "";
        this.mac = "";
        this.userId = "";
        this.enablePersonalized = a2egSU.f9700A4TApA;
        this.location = null;
        this.carrier = "";
        this.canUseIMei = true;
        this.canUseOaid = a2egSU.f9701A5SV6n;
        this.canUseAndroidId = true;
        this.canUseLocation = a2egSU.f9702ADYaiT;
        this.canUseMac = a2egSU.AMqCpz;
        this.canUseCarrier = a2egSU.f9703ARc23Z;
        this.canUseInstallAppList = a2egSU.f9704ASJ6gh;
        this.canUseMotionSensor = true;
        this.canUseWifiState = a2egSU.f9705AYUAbz;
    }
}
