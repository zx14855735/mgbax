package io.dcloud.openapi.core.entry;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SplashAOLConfig {
    private int aaaaaaa0;
    private int aaaaaaaa;

    public static final class Builder {
        private int aaaaaaa0;
        private int aaaaaaaa;

        public SplashAOLConfig build() {
            return new SplashAOLConfig(this);
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

    public int getHeight() {
        return this.aaaaaaa0;
    }

    public int getWidth() {
        return this.aaaaaaaa;
    }

    private SplashAOLConfig(Builder builder) {
        this.aaaaaaaa = builder.aaaaaaaa;
        this.aaaaaaa0 = builder.aaaaaaa0;
    }
}
