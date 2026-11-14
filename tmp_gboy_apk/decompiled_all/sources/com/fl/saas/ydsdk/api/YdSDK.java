package com.fl.saas.ydsdk.api;

import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.ConfigUtils;
import com.fl.saas.ydsdk.manager.YdConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdSDK {
    public static void loadMixNative(Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        if (!YdConfig.isInit()) {
            if (nativeLoadListener != null) {
                nativeLoadListener.onAdFailed(YdError.create(ErrorCodeConstant.INIT_ERROR, "Please initialize the SDK first"));
            }
        } else if (adParams == null || !ConfigUtils.checkImpressFreq(adParams.getKey())) {
            ReportHelper.getInstance().reportSDKInit();
            new MixNativeManager(context, adParams, nativeLoadListener).load();
        } else if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(YdError.create(ErrorCodeConstant.FREQUENCY_ERROR, "Request too frequently"));
        }
    }
}
