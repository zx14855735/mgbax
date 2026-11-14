package com.fl.saas.ydsdk;

import KiXkPs.A2egSU;
import KiXkPs.A4TApA;
import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.manager.AdViewNativeManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.Check;
import java.util.List;

@API(AdType.Native)
@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdNative extends BaseAPI<InnerNativeBuilder<?>, AdViewNativeManager> {

    @Deprecated
    public static class Builder extends InnerNativeBuilder.Builder<Builder, YdNative> {
        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        @Deprecated
        public YdNative build() {
            return new YdNative(this);
        }

        @Deprecated
        public Builder setNativeListener(AdViewNativeListener adViewNativeListener) {
            this.listener = adViewNativeListener;
            return this;
        }
    }

    @Deprecated
    public YdNative(InnerNativeBuilder<?> innerNativeBuilder) {
        super(innerNativeBuilder);
    }

    @Deprecated
    public List<YdNativePojo> getBottomAd() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewNativeManager) s).getBottomAd();
        }
        return null;
    }

    @Deprecated
    public void pauseVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, new A2egSU(4));
    }

    @Deprecated
    public void requestNative() {
        request();
    }

    @Deprecated
    public void resume() {
        Check.checkNull((AdViewNativeManager) this.manager, new A2egSU(3));
    }

    @Deprecated
    public void resumeVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, new A2egSU(2));
    }

    @Deprecated
    public void setSoundEnable(boolean z) {
        Check.checkNull((AdViewNativeManager) this.manager, new A4TApA(0, z));
    }

    @Deprecated
    public void startVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, new A2egSU(0));
    }

    @Deprecated
    public void stopVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, new A2egSU(1));
    }
}
