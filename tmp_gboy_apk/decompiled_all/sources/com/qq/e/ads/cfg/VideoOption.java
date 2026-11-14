package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class VideoOption {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f12760A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f12761A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f12762A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f12763ADYaiT;
    public final boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final boolean f12764ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final boolean f12765ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final int f12766AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final int f12767AZOQYO;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {

        /* renamed from: A2egSU, reason: collision with root package name */
        public boolean f12768A2egSU = true;

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f12769A4TApA = 1;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public boolean f12770A5SV6n = true;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public boolean f12771ADYaiT = true;
        public boolean AMqCpz = true;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public boolean f12772ARc23Z = false;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public boolean f12773ASJ6gh = false;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public int f12774AYUAbz;

        /* renamed from: AZOQYO, reason: collision with root package name */
        public int f12775AZOQYO;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f12768A2egSU = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                i = 1;
            }
            this.f12769A4TApA = i;
            return this;
        }

        @Deprecated
        public Builder setDetailPageMuted(boolean z) {
            this.f12773ASJ6gh = z;
            return this;
        }

        @Deprecated
        public Builder setEnableDetailPage(boolean z) {
            this.AMqCpz = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f12772ARc23Z = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f12774AYUAbz = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f12775AZOQYO = i;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f12771ADYaiT = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f12770A5SV6n = z;
            return this;
        }
    }

    public VideoOption(Builder builder) {
        this.f12760A2egSU = builder.f12768A2egSU;
        this.f12761A4TApA = builder.f12769A4TApA;
        this.f12762A5SV6n = builder.f12770A5SV6n;
        this.f12763ADYaiT = builder.f12771ADYaiT;
        this.AMqCpz = builder.AMqCpz;
        this.f12764ARc23Z = builder.f12772ARc23Z;
        this.f12765ASJ6gh = builder.f12773ASJ6gh;
        this.f12766AYUAbz = builder.f12774AYUAbz;
        this.f12767AZOQYO = builder.f12775AZOQYO;
    }

    public boolean getAutoPlayMuted() {
        return this.f12760A2egSU;
    }

    public int getAutoPlayPolicy() {
        return this.f12761A4TApA;
    }

    public int getMaxVideoDuration() {
        return this.f12766AYUAbz;
    }

    public int getMinVideoDuration() {
        return this.f12767AZOQYO;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f12760A2egSU));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f12761A4TApA));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f12765ASJ6gh));
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return jSONObject;
        }
    }

    @Deprecated
    public boolean isDetailPageMuted() {
        return this.f12765ASJ6gh;
    }

    @Deprecated
    public boolean isEnableDetailPage() {
        return this.AMqCpz;
    }

    public boolean isEnableUserControl() {
        return this.f12764ARc23Z;
    }

    public boolean isNeedCoverImage() {
        return this.f12763ADYaiT;
    }

    public boolean isNeedProgressBar() {
        return this.f12762A5SV6n;
    }
}
