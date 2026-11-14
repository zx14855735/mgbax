package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.api.YdSDK;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.draw.UniAdCustomDrawAdLoader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLDrawAdLoader extends UniAdCustomDrawAdLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(final Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
        } else {
            YdSDK.loadMixNative(activity, new AdParams.Builder(slotId).build(), new NativeLoadListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLDrawAdLoader.1
                @Override // com.fl.saas.base.interfaces.AdViewListener
                public void onAdFailed(YdError ydError) {
                    CustomFLDrawAdLoader.this.onLoadFail(ydError.getCode(), ydError.getMsg());
                }

                @Override // com.fl.saas.api.mixNative.NativeLoadListener
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    if (nativeAd == null) {
                        CustomFLDrawAdLoader.this.onLoadFail(40003, "广告数据为空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    CustomFLDrawAd customFLDrawAd = new CustomFLDrawAd(activity, nativeAd);
                    if (CustomFLDrawAdLoader.this.getBidType() == 1) {
                        customFLDrawAd.setBidPrice(nativeAd.getECPM());
                    }
                    arrayList.add(customFLDrawAd);
                    CustomFLDrawAdLoader.this.onLoadSuccess(arrayList);
                }
            });
        }
    }
}
