package com.bytedance.sdk.openadsdk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdSlot implements SlotType {
    private int am;
    private boolean c;
    private boolean d;
    private TTAdLoadType dk;
    private int e;
    private IMediationAdSlot et;
    private boolean f;
    private int g;
    private int hf;
    private String ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10261io;
    private String jk;
    private float kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10262pl;
    private String pz;
    private boolean qt;
    private String ra;
    private String tf;
    private float u;
    private String v;
    private int w;
    private String x;
    private String xj;
    private int y;
    private String yo;
    private int[] zg;

    public static class Builder {
        private float am;
        private String dk;
        private int e;
        private IMediationAdSlot et;
        private String f;
        private float g;
        private String ht;

        /* renamed from: io, reason: collision with root package name */
        private int f10263io;
        private String jk;
        private int p;

        /* renamed from: pl, reason: collision with root package name */
        private int f10264pl;
        private String ra;
        private String v;
        private String x;
        private String xj;
        private String yo;
        private int[] zg;
        private int hf = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int w = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean u = true;
        private boolean kd = false;
        private boolean y = false;
        private int c = 1;
        private String d = "defaultUser";
        private int tf = 2;
        private boolean qt = true;
        private TTAdLoadType pz = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.xj = this.xj;
            adSlot.y = this.c;
            adSlot.c = this.u;
            adSlot.f = this.kd;
            adSlot.d = this.y;
            adSlot.hf = this.hf;
            adSlot.w = this.w;
            adSlot.u = this.g;
            adSlot.kd = this.am;
            adSlot.tf = this.f;
            adSlot.p = this.d;
            adSlot.f10262pl = this.tf;
            adSlot.am = this.p;
            adSlot.qt = this.qt;
            adSlot.zg = this.zg;
            adSlot.e = this.e;
            adSlot.yo = this.yo;
            adSlot.jk = this.ht;
            adSlot.pz = this.ra;
            adSlot.ht = this.dk;
            adSlot.g = this.f10264pl;
            adSlot.v = this.v;
            adSlot.ra = this.jk;
            adSlot.dk = this.pz;
            adSlot.x = this.x;
            adSlot.f10261io = this.f10263io;
            adSlot.et = this.et;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.c = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.ht = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.pz = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.f10264pl = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.e = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.xj = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.ra = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.g = f;
            this.am = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.dk = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.zg = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.hf = i;
            this.w = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.qt = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.et = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.p = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.tf = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.yo = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.f10263io = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.x = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.u = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.jk = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.d = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.y = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.kd = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.v = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.y;
    }

    public String getAdId() {
        return this.jk;
    }

    public TTAdLoadType getAdLoadType() {
        return this.dk;
    }

    public int getAdType() {
        return this.g;
    }

    public int getAdloadSeq() {
        return this.e;
    }

    public String getBidAdm() {
        return this.v;
    }

    public String getCodeId() {
        return this.xj;
    }

    public String getCreativeId() {
        return this.pz;
    }

    public float getExpressViewAcceptedHeight() {
        return this.kd;
    }

    public float getExpressViewAcceptedWidth() {
        return this.u;
    }

    public String getExt() {
        return this.ht;
    }

    public int[] getExternalABVid() {
        return this.zg;
    }

    public int getImgAcceptedHeight() {
        return this.w;
    }

    public int getImgAcceptedWidth() {
        return this.hf;
    }

    public String getMediaExtra() {
        return this.tf;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.et;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.am;
    }

    public int getOrientation() {
        return this.f10262pl;
    }

    public String getPrimeRit() {
        String str = this.yo;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.f10261io;
    }

    public String getRewardName() {
        return this.x;
    }

    public String getUserData() {
        return this.ra;
    }

    public String getUserID() {
        return this.p;
    }

    public boolean isAutoPlay() {
        return this.qt;
    }

    public boolean isSupportDeepLink() {
        return this.c;
    }

    public boolean isSupportIconStyle() {
        return this.d;
    }

    public boolean isSupportRenderConrol() {
        return this.f;
    }

    public void setAdCount(int i) {
        this.y = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.dk = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.zg = iArr;
    }

    public void setNativeAdType(int i) {
        this.am = i;
    }

    public void setUserData(String str) {
        this.ra = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.xj);
            jSONObject.put("mIsAutoPlay", this.qt);
            jSONObject.put("mImgAcceptedWidth", this.hf);
            jSONObject.put("mImgAcceptedHeight", this.w);
            jSONObject.put("mExpressViewAcceptedWidth", this.u);
            jSONObject.put("mExpressViewAcceptedHeight", this.kd);
            jSONObject.put("mAdCount", this.y);
            jSONObject.put("mSupportDeepLink", this.c);
            jSONObject.put("mSupportRenderControl", this.f);
            jSONObject.put("mSupportIconStyle", this.d);
            jSONObject.put("mMediaExtra", this.tf);
            jSONObject.put("mUserID", this.p);
            jSONObject.put("mOrientation", this.f10262pl);
            jSONObject.put("mNativeAdType", this.am);
            jSONObject.put("mAdloadSeq", this.e);
            jSONObject.put("mPrimeRit", this.yo);
            jSONObject.put("mAdId", this.jk);
            jSONObject.put("mCreativeId", this.pz);
            jSONObject.put("mExt", this.ht);
            jSONObject.put("mBidAdm", this.v);
            jSONObject.put("mUserData", this.ra);
            jSONObject.put("mAdLoadType", this.dk);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.xj + "', mImgAcceptedWidth=" + this.hf + ", mImgAcceptedHeight=" + this.w + ", mExpressViewAcceptedWidth=" + this.u + ", mExpressViewAcceptedHeight=" + this.kd + ", mAdCount=" + this.y + ", mSupportDeepLink=" + this.c + ", mSupportRenderControl=" + this.f + ", mSupportIconStyle=" + this.d + ", mMediaExtra='" + this.tf + "', mUserID='" + this.p + "', mOrientation=" + this.f10262pl + ", mNativeAdType=" + this.am + ", mIsAutoPlay=" + this.qt + ", mPrimeRit" + this.yo + ", mAdloadSeq" + this.e + ", mAdId" + this.jk + ", mCreativeId" + this.pz + ", mExt" + this.ht + ", mUserData" + this.ra + ", mAdLoadType" + this.dk + '}';
    }

    private AdSlot() {
        this.f10262pl = 2;
        this.qt = true;
    }
}
