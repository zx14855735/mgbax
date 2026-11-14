package com.fl.saas.s2s;

import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.inner.banner.InnerNativeBannerAdapter;
import com.fl.saas.s2s.mixNative.S2SMixNativeHandler;
import com.fl.spi.SPI;

@Advertiser(5)
@SPI({AdapterAPI.class})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SBannerAdapter extends InnerNativeBannerAdapter {
    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public MixNativeHandler loadNativeHandler() {
        return new S2SMixNativeHandler();
    }
}
