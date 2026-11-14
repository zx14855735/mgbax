package com.fl.saas.ydsdk.manager;

import com.fl.saas.base.base.builder.InnerBuilder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdParamConfig {
    private final InnerBuilder<?, ?> mBuilder;

    public static final class Builder extends InnerBuilder<Builder, YdParamConfig> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this.builder = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.fl.saas.base.base.builder.InnerBuilder
        public YdParamConfig build() {
            return new YdParamConfig(this);
        }
    }

    public YdParamConfig(InnerBuilder<?, ?> innerBuilder) {
        this.mBuilder = innerBuilder;
    }

    public InnerBuilder<?, ?> getBuilder() {
        return this.mBuilder;
    }
}
