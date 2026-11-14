package com.fl.saas.base.adapter;

import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.interfaces.AdGetWinInfo;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewAdapter {
    private AdSource adSource;
    private AdViewManager adViewManager;

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0149, code lost:
    
        if (r7.adViewManager.isWaterfallDone == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void processAdResults(com.fl.saas.base.base.AdapterAPI r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.adapter.AdViewAdapter.processAdResults(com.fl.saas.base.base.AdapterAPI, boolean):void");
    }

    public void biddingRestAdSource(AdSource adSource) {
        this.adSource = adSource;
    }

    public boolean canUseEcpm() {
        AdViewManager adViewManager = this.adViewManager;
        return adViewManager == null || adViewManager.getOriginalAdPlace() == null || this.adViewManager.getOriginalAdPlace().fill_price == 1;
    }

    public boolean changeReRequestCount() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            return adViewManager.changeReRequestCount();
        }
        return false;
    }

    public WinAdInfo getWinInfo() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager == null || !(adViewManager.getValidAdapter() instanceof AdGetWinInfo)) {
            return null;
        }
        return ((AdGetWinInfo) this.adViewManager.getValidAdapter()).getWinAdInfo();
    }

    public boolean isReRequest() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            return adViewManager.isReRequest();
        }
        return false;
    }

    public void onFailed(AdapterAPI adapterAPI, ErrorInfo errorInfo) {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager == null || adViewManager.isHasAdErrInfo(errorInfo)) {
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", this.adSource + "广告加载失败:" + errorInfo.code + "___" + errorInfo.msg);
        if (this.adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isApiBidAd");
        }
        if (this.adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isS2SBidAd");
        }
        if (this.adSource.isC2SBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isC2SBidAd");
        }
        if (this.adViewManager.adViewAdapter != null && hashCode() == this.adViewManager.adViewAdapter.hashCode()) {
            this.adViewManager.onAdFailed(new YdError(errorInfo.code, errorInfo.errorType, errorInfo.msg));
            return;
        }
        this.adViewManager.setErrInfo(errorInfo);
        AdSource adSource = this.adSource;
        if (adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "sdk bid失败");
            AdViewManager adViewManager2 = this.adViewManager;
            if (adViewManager2 == null || adViewManager2.adSaasPlace == null || adViewManager2.sdkBidRetrun) {
                return;
            }
            adViewManager2.removeMessages(6);
            AdViewManager adViewManager3 = this.adViewManager;
            adViewManager3.sdkBidRetrun = true;
            adViewManager3.selectAdShow();
            return;
        }
        if (adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "api bid失败");
            AdViewManager adViewManager4 = this.adViewManager;
            if (adViewManager4 == null || adViewManager4.adSaasPlace == null || adViewManager4.apiBidRetrun) {
                return;
            }
            adViewManager4.apiBidRetrun = true;
            adViewManager4.selectAdShow();
            return;
        }
        if (adSource.isBottomAd) {
            AdViewManager adViewManager5 = this.adViewManager;
            adViewManager5.bottomFailNum++;
            adViewManager5.retrunBottomResult();
            return;
        }
        if (!adSource.isC2SBidAd) {
            processAdResults(adapterAPI, false);
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", "c2s bid失败");
        AdViewManager adViewManager6 = this.adViewManager;
        adViewManager6.c2sBidFailNum++;
        adViewManager6.setS2SFailAds(this.adSource, adapterAPI);
        LogcatUtil.d("YdSDK-Adapter", "c2s成功数量:" + this.adViewManager.c2sBidFinishNum + "///c2s失败数量:" + this.adViewManager.c2sBidFailNum);
        AdViewManager adViewManager7 = this.adViewManager;
        if (adViewManager7.c2sBidFailNum + adViewManager7.c2sBidFinishNum == this.adSource.c2sSumNum) {
            LogcatUtil.d("YdSDK-Adapter", "本次请失败，C2S请求全部完成");
            AdViewManager adViewManager8 = this.adViewManager;
            adViewManager8.isC2SAdDone = true;
            adViewManager8.selectAdShow();
        }
    }

    public void onSuccess(AdapterAPI adapterAPI) {
        LogcatUtil.d("YdSDK-Adapter", "广告加载成功:" + this.adSource);
        if (this.adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isApiBidAd");
        }
        if (this.adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isS2SBidAd:");
        }
        if (this.adSource.isC2SBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isC2SBidAd:");
        }
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager == null) {
            return;
        }
        adViewManager.setResponseInfo(this.adSource);
        AdSource adSource = this.adSource;
        if (adSource.isSDKBidAd) {
            AdViewManager adViewManager2 = this.adViewManager;
            if (adViewManager2.sdkBidRetrun) {
                return;
            }
            adViewManager2.removeMessages(6);
            AdViewManager adViewManager3 = this.adViewManager;
            adViewManager3.sdkBidRetrun = true;
            adViewManager3.setSuccessAds(this.adSource, adapterAPI);
            this.adViewManager.selectAdShow();
            return;
        }
        if (adSource.isApiBidAd) {
            if (adSource.getAdCacheBean() != null) {
                this.adViewManager.setSuccessAds(this.adSource, adapterAPI);
                return;
            }
            AdViewManager adViewManager4 = this.adViewManager;
            if (adViewManager4.apiBidRetrun) {
                return;
            }
            adViewManager4.apiBidRetrun = true;
            adViewManager4.setSuccessAds(this.adSource, adapterAPI);
            this.adViewManager.selectAdShow();
            return;
        }
        if (adSource.isBottomAd) {
            AdViewManager adViewManager5 = this.adViewManager;
            adViewManager5.bottomFinishNum++;
            adViewManager5.setBottomSuccessAds(adSource, adapterAPI);
            this.adViewManager.retrunBottomResult();
            return;
        }
        if (!adSource.isC2SBidAd) {
            processAdResults(adapterAPI, true);
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", "c2s bid return");
        ReportHelper.getInstance().reportC2SBiddingAd(this.adSource);
        AdViewManager adViewManager6 = this.adViewManager;
        adViewManager6.c2sBidFinishNum++;
        adViewManager6.setS2SSuccessAds(this.adSource, adapterAPI);
        LogcatUtil.d("YdSDK-Adapter", "c2s成功数量:" + this.adViewManager.c2sBidFinishNum);
        LogcatUtil.d("YdSDK-Adapter", "c2s失败数量:" + this.adViewManager.c2sBidFailNum);
        LogcatUtil.d("YdSDK-Adapter", "adSource.c2sSumNum:" + this.adSource.c2sSumNum);
        AdViewManager adViewManager7 = this.adViewManager;
        if (adViewManager7.c2sBidFailNum + adViewManager7.c2sBidFinishNum == this.adSource.c2sSumNum) {
            LogcatUtil.d("YdSDK-Adapter", "本次请成功，C2S请求全部完成");
            AdViewManager adViewManager8 = this.adViewManager;
            adViewManager8.isC2SAdDone = true;
            adViewManager8.selectAdShow();
        }
    }

    public void sendRequestMsg() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            adViewManager.setRequestInfo(this.adSource);
        }
    }

    public void setAdViewManager(AdViewManager adViewManager) {
        this.adViewManager = adViewManager;
    }
}
