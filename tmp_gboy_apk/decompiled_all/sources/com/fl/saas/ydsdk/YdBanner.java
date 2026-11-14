package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.manager.AdViewBannerManager;
import com.fl.saas.base.type.AdType;

@API(AdType.Banner)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdBanner extends BaseAPI<InnerBannerBuilder<?>, AdViewBannerManager> {

    public static final class Builder extends InnerBannerBuilder.Builder<Builder, YdBanner> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        public YdBanner build() {
            return new YdBanner(this);
        }

        public Builder setBannerListener(AdViewBannerListener adViewBannerListener) {
            this.listener = adViewBannerListener;
            return this;
        }
    }

    public YdBanner(InnerBannerBuilder<?> innerBannerBuilder) {
        super(innerBannerBuilder);
    }

    public void requestBanner() {
        request();
    }
}
