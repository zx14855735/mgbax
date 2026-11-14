package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.ydsdk.api.YdSDK;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAdLoader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLNativeAdLoader extends UniAdCustomNativeAdLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(final Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
            return;
        }
        int px2dip = DeviceUtil.px2dip(DeviceUtil.getMobileWidth());
        if (uniAdSlot.getWidth() > 0) {
            px2dip = DeviceUtil.px2dip(uniAdSlot.getWidth());
        }
        if (uniAdSlot.getHeight() > 0) {
            px2dip = DeviceUtil.px2dip(uniAdSlot.getHeight());
        }
        YdSDK.loadMixNative(activity, new AdParams.Builder(slotId).setExpressWidth(px2dip).setExpressHeight(200).setExpressAutoHeight().setExpressFullWidth().build(), new NativeLoadListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLNativeAdLoader.1
            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                CustomFLNativeAdLoader.this.onLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.api.mixNative.NativeLoadListener
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if (nativeAd == null) {
                    CustomFLNativeAdLoader.this.onLoadFail(40003, "广告数据为空");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                CustomFLNativeAd customFLNativeAd = new CustomFLNativeAd(activity, nativeAd);
                if (CustomFLNativeAdLoader.this.getBidType() == 1) {
                    customFLNativeAd.setBidPrice(nativeAd.getECPM());
                }
                arrayList.add(customFLNativeAd);
                CustomFLNativeAdLoader.this.onLoadSuccess(arrayList);
            }
        });
    }
}
