package io.dcloud.ads.core.entry;

import io.dcloud.openapi.core.entry.SplashAOLConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SplashConfig {
    private int aaaaaaa0;
    private int aaaaaaaa;

    public static final class Builder {
        private int aaaaaaa0;
        private int aaaaaaaa;

        public SplashConfig build() {
            return new SplashConfig(this);
        }

        public Builder height(int i) {
            this.aaaaaaa0 = i;
            return this;
        }

        public Builder width(int i) {
            this.aaaaaaaa = i;
            return this;
        }
    }

    @Deprecated
    public SplashAOLConfig getConfig() {
        return new SplashAOLConfig.Builder().width(this.aaaaaaaa).height(this.aaaaaaa0).build();
    }

    public int getHeight() {
        return this.aaaaaaa0;
    }

    public int getWidth() {
        return this.aaaaaaaa;
    }

    private SplashConfig(Builder builder) {
        this.aaaaaaaa = builder.aaaaaaaa;
        this.aaaaaaa0 = builder.aaaaaaa0;
    }
}
