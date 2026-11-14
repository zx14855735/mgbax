package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationAdSlot implements IMediationAdSlot {
    private float am;
    private boolean c;
    private boolean d;
    private Map<String, Object> f;
    private float g;
    private boolean hf;
    private float kd;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private MediationNativeToBannerListener f10469pl;
    private String qt;
    private String tf;
    private int u;
    private String w;
    private boolean xj;
    private boolean y;
    private MediationSplashRequestInfo zg;

    public static class Builder {
        private boolean c;
        private String f;
        private boolean hf;
        private boolean kd;
        private boolean p;

        /* renamed from: pl, reason: collision with root package name */
        private MediationNativeToBannerListener f10470pl;
        private String qt;
        private int tf;
        private float u;
        private boolean w;
        private boolean xj;
        private MediationSplashRequestInfo zg;
        private Map<String, Object> y = new HashMap();
        private String d = "";
        private float g = 80.0f;
        private float am = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.xj = this.xj;
            mediationAdSlot.hf = this.hf;
            mediationAdSlot.c = this.w;
            mediationAdSlot.kd = this.u;
            mediationAdSlot.y = this.kd;
            mediationAdSlot.f = this.y;
            mediationAdSlot.d = this.c;
            mediationAdSlot.tf = this.f;
            mediationAdSlot.w = this.d;
            mediationAdSlot.u = this.tf;
            mediationAdSlot.p = this.p;
            mediationAdSlot.f10469pl = this.f10470pl;
            mediationAdSlot.g = this.g;
            mediationAdSlot.am = this.am;
            mediationAdSlot.qt = this.qt;
            mediationAdSlot.zg = this.zg;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.p = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.y;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.f10470pl = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.zg = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.w = z;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.tf = i;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.d = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f = str;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.g = f;
            this.am = f2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.hf = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.xj = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.kd = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.u = f;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.qt = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.am;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.qt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.y;
    }

    private MediationAdSlot() {
        this.w = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.f10469pl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.zg;
    }
}
