package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    public static class Builder {
        protected Map<String, Integer> am;
        protected int c;
        protected int d;
        protected int f;
        protected int g;
        protected int hf;
        protected int kd;
        protected int p;

        /* renamed from: pl, reason: collision with root package name */
        protected int f10471pl;
        protected int tf;
        protected int u;
        protected int w;
        protected int xj;
        protected int y;

        public Builder(int i) {
            this.am = Collections.EMPTY_MAP;
            this.xj = i;
            this.am = new HashMap();
        }

        public Builder addExtra(String str, int i) {
            this.am.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.am = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i) {
            this.u = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.w = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.tf = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.p = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.f10471pl = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.kd = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.d = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.y = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.c = i;
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.g = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.f = i;
            return this;
        }

        public Builder titleId(int i) {
            this.hf = i;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.xj;
        this.titleId = builder.hf;
        this.decriptionTextId = builder.w;
        this.callToActionId = builder.u;
        this.iconImageId = builder.kd;
        this.mainImageId = builder.y;
        this.mediaViewId = builder.c;
        this.sourceId = builder.f;
        this.extras = builder.am;
        this.groupImage1Id = builder.tf;
        this.groupImage2Id = builder.p;
        this.groupImage3Id = builder.f10471pl;
        this.logoLayoutId = builder.d;
        this.shakeViewContainerId = builder.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
