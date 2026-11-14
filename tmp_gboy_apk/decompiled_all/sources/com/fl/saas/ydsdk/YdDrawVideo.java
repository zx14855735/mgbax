package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.base.manager.AdViewDrawVideoManager;
import com.fl.saas.base.type.AdType;

@API(AdType.DrawVideo)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdDrawVideo extends BaseAPI<InnerDrawVideoBuilder<?>, AdViewDrawVideoManager> {

    public static class Builder extends InnerDrawVideoBuilder.Builder<Builder, YdDrawVideo> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        public YdDrawVideo build() {
            return new YdDrawVideo(this);
        }

        public Builder setLoadListener(AdViewDrawVideoListener adViewDrawVideoListener) {
            this.listener = adViewDrawVideoListener;
            return this;
        }
    }

    public YdDrawVideo(InnerDrawVideoBuilder<?> innerDrawVideoBuilder) {
        super(innerDrawVideoBuilder);
    }

    public void requestDrawVideo() {
        request();
    }
}
