package com.fl.saas.base.manager.loader;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.cache.AdCacheBean;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.AdCacheRepository;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.WaterfallHierarchyController;
import com.fl.saas.base.manager.api.AdapterGenerator;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.SPUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewManager {
    public static final int REPORT_MSG_COUNT_DOWN = 8;
    public static final int REQ_A2S_BID_TIME_OUT = 7;
    private static final int REQ_ALL_TIME_OUT = 1;
    private static final int REQ_BOTTOM_TIME_OUT = 2;
    private static final int REQ_C2S_BID_TIME_OUT = 3;
    private static final int REQ_NEXT = 5;
    private static final int REQ_QUICK_DONE = 4;
    public static final int REQ_S2S_BID_TIME_OUT = 6;
    private static final int REQ_TIME_OUT = 0;
    public AdPlace adSaasPlace;
    private final int adType;
    public AdapterAPI adViewAdapter;
    public int bottomFailNum;
    public int bottomFinishNum;
    public int c2sBidFailNum;
    public int c2sBidFinishNum;
    private String cacheKey;
    private int currentPriceFloor;
    public String key;
    private final AdapterGenerator mAdapterGenerator;
    protected AdPlace originalAdPlace;
    private PreloadDoneCallback preloadDoneCallback;
    public long reqTime;
    public int sumHierarchyNum;
    public boolean isWaterfallDone = false;
    public int nowNum = 0;
    public Map<AdSource, AdapterAPI> successAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> allSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> bottomSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> c2sSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> c2sFailAds = new ConcurrentHashMap();
    public Map<Integer, WaterfallHierarchyController> adStatus = new ConcurrentHashMap();
    public List<AdSource> c2sResultAds = new ArrayList();
    private int c2sSecondPrice = 0;
    private int c2sSecondAdvId = 0;
    private final List<ErrorInfo> errInfos = new ArrayList();
    private final List<AdSource> listResponseInfo = new ArrayList();
    private final List<AdSource> listRequestInfo = new ArrayList();
    public boolean isCallback = false;
    private boolean oldStrategy = true;
    private boolean haveStartWaterFall = false;
    private boolean isLastHierarchy = false;
    public boolean isBottomAdDone = false;
    public boolean isShowBottomAd = false;
    public boolean isBottomAdCallback = false;
    public boolean has_c2s_bid = false;
    public boolean isC2SAdDone = false;
    public boolean has_api_bid = false;
    public boolean apiBidRetrun = false;
    public boolean has_sdk_bid = false;
    public boolean sdkBidRetrun = false;
    public boolean isOnlySdkBid = false;
    public boolean has_bottom_ad = false;
    private boolean isSetTop = false;
    private boolean isCacheMode = false;
    private int waterfallFlowStop = -1;
    public boolean isPreloadMode = false;
    private boolean isSelectBottomAdapter = false;
    private int needReRequestCount = 0;
    private boolean refreshRequestCount = true;
    private boolean isReRequest = false;
    private boolean isNeedRequestPreloadAdPlace = false;
    private boolean hasLoadCacheAd = false;
    private int cachePrice = 0;
    public boolean hasCallBackLoadAd = false;
    Handler timeHandle = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.base.manager.loader.AdViewManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (3 == message.what) {
                LogcatUtil.d("YdSDK-Manager", "C2S竞价广告时间结束");
                AdViewManager adViewManager = AdViewManager.this;
                adViewManager.isC2SAdDone = true;
                adViewManager.selectAdShow();
            }
            if (6 == message.what) {
                LogcatUtil.d("YdSDK-Adapter", "sdkBidTimeHandler");
                AdViewManager adViewManager2 = AdViewManager.this;
                if (!adViewManager2.sdkBidRetrun) {
                    adViewManager2.sdkBidRetrun = true;
                    adViewManager2.selectAdShow();
                }
            }
            if (7 == message.what) {
                LogcatUtil.d("YdSDK-Adapter", "apiBidTimeHandler");
                AdViewManager adViewManager3 = AdViewManager.this;
                if (adViewManager3.has_api_bid && !adViewManager3.apiBidRetrun) {
                    adViewManager3.apiBidRetrun = true;
                    adViewManager3.selectAdShow();
                }
            }
            if (2 == message.what) {
                LogcatUtil.d("YdSDK-Manager", "兜底广告时间结束:" + AdViewManager.this.isShowBottomAd);
                AdViewManager adViewManager4 = AdViewManager.this;
                adViewManager4.isBottomAdDone = true;
                if (adViewManager4.isShowBottomAd) {
                    adViewManager4.disposeBottomAd();
                }
            }
            if (5 == message.what && !AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).isReqNext() && !AdViewManager.this.isWaterfallDone) {
                LogcatUtil.d("YdSDK-Manager", message.arg1 + "层到达请求间隔时间,未完全全部回调。");
                AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).setReqNext(true);
                AdViewManager.this.nextRequestSdkAd();
            }
            if (message.what == 0) {
                LogcatUtil.d("YdSDK-Manager", "单层超时统计,超时层为:" + message.arg1);
                if (AdViewManager.this.isCallback) {
                    LogcatUtil.d("YdSDK-Manager", message.arg1 + "层超时，已经给过回调不再处理");
                } else {
                    LogcatUtil.d("YdSDK-Manager", message.arg1 + "层超时，判断广告选择逻辑");
                    if (AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)) != null) {
                        AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).setTimeOut(true);
                        if (!AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).isHasAd()) {
                            int i = message.arg1;
                            AdViewManager adViewManager5 = AdViewManager.this;
                            if (i == adViewManager5.sumHierarchyNum - 1) {
                                adViewManager5.waterfallFlowDone();
                            }
                        }
                        AdViewManager.this.cyclicQueryController(message.arg1);
                    }
                }
            }
            if (4 == message.what) {
                Map<AdSource, AdapterAPI> map = AdViewManager.this.successAds;
                if (map == null || map.size() <= 0) {
                    AdViewManager.this.waterfallFlowDone();
                } else {
                    AdViewManager adViewManager6 = AdViewManager.this;
                    adViewManager6.isWaterfallDone = true;
                    adViewManager6.selectAdShow();
                }
            }
            if (1 == message.what) {
                AdViewManager adViewManager7 = AdViewManager.this;
                if (adViewManager7.isPreloadMode && adViewManager7.preloadDoneCallback != null) {
                    AdViewManager.this.preloadDoneCallback.preloadDone();
                }
                Map<AdSource, AdapterAPI> map2 = AdViewManager.this.successAds;
                if (map2 == null || map2.size() <= 0) {
                    AdViewManager.this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.TIMEOUT_ERROR, "request time out"));
                    AdViewManager.this.getPreLoadAdPlace();
                    LogcatUtil.d("YdSDK-Manager", "request time out");
                } else {
                    LogcatUtil.d("YdSDK-Manager", "request time out,AD fill");
                    AdViewManager adViewManager8 = AdViewManager.this;
                    adViewManager8.isWaterfallDone = true;
                    adViewManager8.isC2SAdDone = true;
                    adViewManager8.sdkBidRetrun = true;
                    adViewManager8.apiBidRetrun = true;
                    adViewManager8.selectAdShow();
                }
            }
            if (8 == message.what) {
                AdViewManager.this.mergeReportMsg();
            }
        }
    };

    public AdViewManager(AdapterGenerator adapterGenerator, int i) {
        this.mAdapterGenerator = adapterGenerator;
        this.adType = i;
    }

    private boolean bidResultSelfReturn() {
        AdPlace adPlace = this.originalAdPlace;
        return adPlace == null || adPlace.bid_notice_type != 1;
    }

    private void biddingReq(AdSource adSource) {
        StringBuilder sb;
        int i;
        long bootTime;
        ReportHelper reportHelper;
        ReportHelper reportHelper2;
        int i2;
        String AZkASS2;
        String AZkASS3;
        String str;
        String str2;
        String str3;
        int i3;
        if (this.has_sdk_bid) {
            if (adSource.price > 0) {
                sb = new StringBuilder();
                i = adSource.price;
            } else {
                sb = new StringBuilder();
                i = adSource.bidfloor;
            }
            String AZkASS4 = CtFAbx.AZkASS("", i, sb);
            if (adSource.isSDKBidAd) {
                bootTime = DeviceUtil.getBootTime() - this.reqTime;
                reportHelper = ReportHelper.getInstance();
                reportHelper2 = ReportHelper.getInstance();
                i2 = adSource.adv_id;
                AZkASS2 = CtFAbx.AZkASS("", this.c2sSecondPrice, new StringBuilder());
                AZkASS3 = CtFAbx.AZkASS("", adSource.adv_id, new StringBuilder());
                str = adSource.nurl;
                str2 = adSource.lurl;
                str3 = adSource.tagid;
                i3 = 1;
            } else {
                AdSource adSource2 = null;
                for (AdSource adSource3 : this.successAds.keySet()) {
                    if (adSource3.isSDKBidAd) {
                        adSource2 = adSource3;
                    }
                }
                if (adSource2 == null) {
                    return;
                }
                bootTime = DeviceUtil.getBootTime() - this.reqTime;
                reportHelper = ReportHelper.getInstance();
                AdSource adSource4 = adSource2;
                reportHelper2 = ReportHelper.getInstance();
                i2 = adSource4.adv_id;
                AZkASS2 = CtFAbx.AZkASS("", this.c2sSecondPrice, new StringBuilder());
                AZkASS3 = CtFAbx.AZkASS("", adSource.adv_id, new StringBuilder());
                str = adSource4.nurl;
                str2 = adSource4.lurl;
                str3 = adSource4.tagid;
                i3 = 0;
            }
            reportHelper.reportSDKBidding(reportHelper2.reqBidJson(i2, i3, AZkASS4, AZkASS2, AZkASS3, str, str2, str3, bootTime));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void callBackLoadAd(com.fl.saas.common.saas.bean.AdSource r19) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.manager.loader.AdViewManager.callBackLoadAd(com.fl.saas.common.saas.bean.AdSource):void");
    }

    private AdSource checkCycleAd() {
        if (checkOpenCycle() && (this.adViewAdapter instanceof MixNativeCycleDataListener)) {
            double d = 0.0d;
            AdapterAPI adapterAPI = null;
            for (AdSource adSource : this.successAds.keySet()) {
                if (adSource.is_black == 1 && this.adViewAdapter.getAdSource() != adSource) {
                    double d2 = adSource.bidfloor;
                    if (d2 > d) {
                        adapterAPI = this.successAds.get(adSource);
                        d = d2;
                    }
                }
            }
            for (AdSource adSource2 : this.c2sSuccessAds.keySet()) {
                if (adSource2.is_black == 1 && this.adViewAdapter.getAdSource() != adSource2) {
                    double d3 = adSource2.bidfloor;
                    if (d3 > d) {
                        adapterAPI = this.c2sSuccessAds.get(adSource2);
                        d = d3;
                    }
                }
            }
            if (adapterAPI instanceof MixNativeCycleDataListener) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(((MixNativeCycleDataListener) adapterAPI).getCycleNativeAd());
                ((MixNativeCycleDataListener) this.adViewAdapter).setCycleNativeAd(arrayList, this.originalAdPlace.lbjg);
                return adapterAPI.getAdSource();
            }
        }
        return null;
    }

    private boolean checkOpenCycle() {
        AdPlace adPlace;
        return this.adType == 10 && (adPlace = this.originalAdPlace) != null && adPlace.isOpenCycle();
    }

    private boolean checkOpenInterstitialRefresh() {
        AdPlace adPlace;
        return this.adType == 3 && (adPlace = this.originalAdPlace) != null && adPlace.verify_ad_refresh == 1;
    }

    private AdSource checkRefreshInterstitialAd() {
        AdapterAPI adapterAPI;
        AdapterAPI adapterAPI2;
        if (checkOpenInterstitialRefresh() && (adapterAPI = this.adViewAdapter) != null) {
            double d = 0.0d;
            if (adapterAPI.getAdSource().is_black == 1) {
                adapterAPI2 = null;
                for (AdSource adSource : this.successAds.keySet()) {
                    if (adSource.is_black != 1 && this.adViewAdapter.getAdSource() != adSource) {
                        double d2 = adSource.bidfloor;
                        if (d2 > d) {
                            adapterAPI2 = this.successAds.get(adSource);
                            d = d2;
                        }
                    }
                }
                for (AdSource adSource2 : this.c2sSuccessAds.keySet()) {
                    if (adSource2.is_black != 1 && this.adViewAdapter.getAdSource() != adSource2) {
                        double d3 = adSource2.bidfloor;
                        if (d3 > d) {
                            adapterAPI2 = this.c2sSuccessAds.get(adSource2);
                            d = d3;
                        }
                    }
                }
            } else {
                adapterAPI2 = null;
                for (AdSource adSource3 : this.successAds.keySet()) {
                    if (adSource3.is_black == 1 && this.adViewAdapter.getAdSource() != adSource3) {
                        double d4 = adSource3.bidfloor;
                        if (d4 > d) {
                            adapterAPI2 = this.successAds.get(adSource3);
                            d = d4;
                        }
                    }
                }
                for (AdSource adSource4 : this.c2sSuccessAds.keySet()) {
                    if (adSource4.is_black == 1 && this.adViewAdapter.getAdSource() != adSource4) {
                        double d5 = adSource4.bidfloor;
                        if (d5 > d) {
                            adapterAPI2 = this.c2sSuccessAds.get(adSource4);
                            d = d5;
                        }
                    }
                }
            }
            if (adapterAPI2 != null) {
                AdCacheManager.getInstance().setInterstitialAdapter(adapterAPI2, this.adViewAdapter.getAdSource().getPrice(), this.c2sSecondPrice, this.adViewAdapter.getAdSource().adv_id);
                return adapterAPI2.getAdSource();
            }
        }
        return null;
    }

    private void checkWaterFallData() {
        int i;
        List<AdSource> list;
        if (this.oldStrategy || this.haveStartWaterFall) {
            return;
        }
        if (this.originalAdPlace == null) {
            this.isWaterfallDone = true;
            selectAdShow();
            return;
        }
        Map<AdSource, AdapterAPI> map = this.c2sSuccessAds;
        if (map == null || map.isEmpty()) {
            i = -1;
        } else {
            i = -1;
            for (AdSource adSource : this.c2sSuccessAds.keySet()) {
                if (i == -1 || adSource.getAdvPrice() > i) {
                    i = adSource.getAdvPrice();
                }
            }
        }
        Map<AdSource, AdapterAPI> map2 = this.successAds;
        if (map2 != null && !map2.isEmpty()) {
            for (AdSource adSource2 : this.successAds.keySet()) {
                if (i == -1 || adSource2.getAdvPrice() > i) {
                    i = adSource2.getAdvPrice();
                }
            }
        }
        if (i > 0 && (list = this.originalAdPlace.ad_sources) != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (AdSource adSource3 : this.originalAdPlace.ad_sources) {
                if (adSource3.getAdvPrice() > i) {
                    arrayList.add(adSource3);
                }
            }
            this.originalAdPlace.ad_sources = arrayList;
        }
        List<AdSource> list2 = this.originalAdPlace.ad_sources;
        if (list2 == null || list2.isEmpty()) {
            this.isWaterfallDone = true;
            selectAdShow();
            return;
        }
        startRequestWaterFall();
        if (this.timeHandle != null) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = this.nowNum;
            this.timeHandle.sendMessageDelayed(message, this.originalAdPlace.timeout);
            Message message2 = new Message();
            message2.what = 5;
            message2.arg1 = this.nowNum;
            this.timeHandle.sendMessageDelayed(message2, this.originalAdPlace.requestInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeBottomAd() {
        getPreLoadAdPlace();
        if (this.isBottomAdDone) {
            if (this.bottomSuccessAds.size() <= 0) {
                this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.AD_DATA_ERROR, "bottom ad list is null"));
                return;
            }
        } else if (this.bottomSuccessAds.size() <= 0) {
            return;
        }
        showBottomAd();
    }

    private void getAdxCache(AdPlace adPlace) {
        AdCacheBean cacheAdContent;
        if (this.isPreloadMode || ConfigHelper.getInstance().getCacheSwitch() != 1 || (cacheAdContent = AdCacheRepository.getInstance().getCacheAdContent(this.cacheKey)) == null) {
            return;
        }
        AdSource adSource = new AdSource();
        adSource.tagid = this.key;
        adSource.isApiBidAd = true;
        adSource.group_id = adPlace.group_id;
        adSource.test_id = adPlace.test_id;
        adSource.place_id = adPlace.place_id;
        adSource.req_id = adPlace.req_id;
        adSource.track_id = adPlace.track_id;
        adSource.setAdCacheBean(cacheAdContent);
        requestAdBySource(adSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPreLoadAdPlace() {
        if (this.hasLoadCacheAd) {
            return;
        }
        this.hasLoadCacheAd = true;
        PreloadHelper.getInstance().requestPreloadAd();
        if (this.isNeedRequestPreloadAdPlace) {
            this.isNeedRequestPreloadAdPlace = false;
            AdCacheManager.getInstance().loadCacheAd(this.adType);
        }
    }

    private void init() {
        this.nowNum = 0;
        this.isSetTop = false;
        this.isWaterfallDone = false;
        this.isCallback = false;
        this.successAds.clear();
        this.allSuccessAds.clear();
        this.bottomSuccessAds.clear();
        this.c2sFailAds.clear();
        this.c2sSuccessAds.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callBackLoadAd$0() {
        Optional.ofNullable(this.adViewAdapter).ifPresent(new com.fl.saas.base.manager.A2egSU(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$setCacheAd$1(AdSource adSource, AdSource adSource2) {
        return Integer.compare(adSource2.getPrice(), adSource.getPrice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReportMsg() {
        LogcatUtil.d("YdSDK-Manager", "mergeReportMessagelistResponseInfo:" + this.listResponseInfo.size() + "listRequestInfo:" + this.listRequestInfo.size());
        if (this.originalAdPlace != null) {
            long bootTime = DeviceUtil.getBootTime() - this.reqTime;
            ReportHelper reportHelper = ReportHelper.getInstance();
            AdPlace adPlace = this.originalAdPlace;
            reportHelper.reportFillFail(adPlace.req_id, adPlace.place_id, adPlace.group_id, adPlace.test_id, this.errInfos, adPlace.track_id, bootTime);
            this.errInfos.clear();
        }
        ReportHelper.getInstance().reportResponseList(this.listResponseInfo, this.originalAdPlace);
        this.listResponseInfo.clear();
        ReportHelper.getInstance().reportRequestList(this.listRequestInfo, this.originalAdPlace);
        this.listRequestInfo.clear();
    }

    private void reqAPIBid(AdPlace adPlace) {
        boolean z = adPlace.has_api_bid;
        this.has_api_bid = z;
        if (z) {
            this.adSaasPlace = adPlace;
            AdSource adSource = new AdSource();
            adSource.tagid = this.key;
            adSource.isApiBidAd = true;
            adSource.group_id = adPlace.group_id;
            adSource.test_id = adPlace.test_id;
            adSource.place_id = adPlace.place_id;
            adSource.req_id = adPlace.req_id;
            adSource.track_id = adPlace.track_id;
            requestAdBySource(adSource);
            Handler handler = this.timeHandle;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(7, this.adSaasPlace.api_timeout);
            }
        }
    }

    private void requestAdBySource(AdSource adSource) {
        this.mAdapterGenerator.requestAd(adSource);
    }

    private void requestBottomAd(List<AdSource> list) {
        LogcatUtil.d("YdSDK-Manager", "requestBottomAd");
        for (AdSource adSource : list) {
            adSource.isBottomAd = true;
            adSource.sumNum = list.size();
            requestAdBySource(adSource);
        }
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(2, this.adSaasPlace.timeout);
        }
    }

    private void resetData() {
        this.isWaterfallDone = false;
        this.isCallback = false;
        this.isLastHierarchy = false;
        this.isBottomAdDone = false;
        this.isShowBottomAd = false;
        this.isBottomAdCallback = false;
        this.has_c2s_bid = false;
        this.isC2SAdDone = false;
        this.has_api_bid = false;
        this.apiBidRetrun = false;
        this.has_sdk_bid = false;
        this.sdkBidRetrun = false;
        this.isOnlySdkBid = false;
        this.has_bottom_ad = false;
        this.isSetTop = false;
        this.isCacheMode = false;
        this.isPreloadMode = false;
        this.isSelectBottomAdapter = false;
        this.isNeedRequestPreloadAdPlace = false;
        this.hasLoadCacheAd = false;
        this.hasCallBackLoadAd = false;
        this.cachePrice = 0;
        this.c2sBidFailNum = 0;
        this.c2sBidFinishNum = 0;
        this.bottomFailNum = 0;
        this.bottomFinishNum = 0;
        this.nowNum = 0;
        this.sumHierarchyNum = 0;
        this.c2sSecondPrice = 0;
        this.currentPriceFloor = 0;
        this.waterfallFlowStop = -1;
        this.successAds.clear();
        this.allSuccessAds.clear();
        this.bottomSuccessAds.clear();
        this.c2sSuccessAds.clear();
        this.c2sFailAds.clear();
        this.adStatus.clear();
        this.c2sResultAds.clear();
        this.errInfos.clear();
        this.listResponseInfo.clear();
        this.listRequestInfo.clear();
        Handler handler = this.timeHandle;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    private void setCacheAd(AdSource adSource, AdSource adSource2) {
        AdapterAPI adapterAPI;
        int i;
        ArrayList<Integer> arrayList;
        try {
            this.allSuccessAds.putAll(this.successAds);
            for (Integer num : this.adStatus.keySet()) {
                num.intValue();
                WaterfallHierarchyController waterfallHierarchyController = this.adStatus.get(num);
                if (waterfallHierarchyController.isHasAd()) {
                    this.allSuccessAds.putAll(waterfallHierarchyController.successAds);
                }
            }
            this.allSuccessAds.putAll(this.c2sSuccessAds);
            LogcatUtil.d("YdSDK-Cache", "本次请求成功的广告数量:" + this.allSuccessAds.size());
            for (AdSource adSource3 : this.allSuccessAds.keySet()) {
                if ((!checkOpenCycle() || adSource3.is_black != 1) && adSource3 != adSource && adSource3 != adSource2) {
                    if (adSource3.isSDKBidAd || adSource3.isApiAd) {
                        AdPlace adPlace = this.originalAdPlace;
                        if (adPlace != null && (arrayList = adPlace.advCacheabledList) != null && arrayList.size() > 0) {
                            Iterator<Integer> it = this.originalAdPlace.advCacheabledList.iterator();
                            while (it.hasNext()) {
                                if (adSource3.adv_id == it.next().intValue()) {
                                    LogcatUtil.d("YdSDK-Cache", "匹配到服务端配置，不移除竞价广告:" + adSource3.adv_id);
                                    break;
                                }
                            }
                        }
                    }
                }
                this.allSuccessAds.remove(adSource3);
            }
            LogcatUtil.d("YdSDK-Cache", "可用于缓存的广告数量:" + this.allSuccessAds.size());
            if (!this.allSuccessAds.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(this.allSuccessAds.keySet());
                Collections.sort(arrayList2, new C4FrIb.A5SV6n(4));
                AdPlace adPlace2 = this.originalAdPlace;
                int i2 = adPlace2 != null ? adPlace2.cache_queue_length : 1;
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < Math.min(arrayList2.size(), i2); i3++) {
                    AdSource adSource4 = (AdSource) arrayList2.get(i3);
                    if ((!adSource4.isApiBidAd || ConfigHelper.getInstance().getCacheSwitch() != 1) && (adapterAPI = this.allSuccessAds.get(adSource4)) != null) {
                        if (adSource4.isC2SBidAd && (i = adSource4.price) > 0) {
                            adSource4.bidfloor = i;
                        }
                        LogcatUtil.d("YdSDK-Cache", "保存缓存广告:" + adapterAPI.getAdSource());
                        adapterAPI.getAdSource().c2sSecondPrice = this.c2sSecondPrice;
                        adapterAPI.getAdSource().c2sSecondAdvId = this.c2sSecondAdvId;
                        adapterAPI.getAdSource().isPopCacheAd = false;
                        arrayList3.add(adapterAPI);
                    }
                }
                AdCacheManager.CacheType cacheType = AdCacheManager.CacheType.PLACE_CACHE;
                if (!this.isPreloadMode) {
                    if (AdCacheManager.getInstance().isGlobalCache(this.adType)) {
                    }
                    AdCacheManager.CacheType cacheType2 = cacheType;
                    AdapterGenerator adapterGenerator = this.mAdapterGenerator;
                    AdPlace adPlace3 = this.originalAdPlace;
                    adapterGenerator.pushCacheAdapter(cacheType2, adPlace3.place_id, adPlace3.cacheValidTime, arrayList3);
                }
                cacheType = AdCacheManager.CacheType.SHARE_CACHE;
                AdCacheManager.CacheType cacheType22 = cacheType;
                AdapterGenerator adapterGenerator2 = this.mAdapterGenerator;
                AdPlace adPlace32 = this.originalAdPlace;
                adapterGenerator2.pushCacheAdapter(cacheType22, adPlace32.place_id, adPlace32.cacheValidTime, arrayList3);
            }
            if (this.isPreloadMode) {
                destroy();
            }
        } catch (Exception e) {
            LogcatUtil.d("YdSDK-Cache", "存放缓存异常" + e.getMessage());
        }
    }

    private void setCurrentPriceFloor(int i) {
        int i2 = this.currentPriceFloor;
        if (i2 > 0 && i2 <= i) {
            return;
        }
        this.currentPriceFloor = i;
    }

    private void setDataToAdSource(AdapterAPI adapterAPI) {
        if (adapterAPI == null || this.originalAdPlace == null) {
            return;
        }
        adapterAPI.getAdSource().refresh = this.originalAdPlace.refresh;
        adapterAPI.getAdSource().refresh_time = this.originalAdPlace.refresh_time;
    }

    private void showBottomAd() {
        if (this.isBottomAdCallback) {
            LogcatUtil.d("YdSDK-Manager", "showBottomAd 2");
            return;
        }
        this.isBottomAdCallback = true;
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.removeMessages(2);
            this.timeHandle.removeMessages(1);
        }
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (AdSource adSource : this.bottomSuccessAds.keySet()) {
            if (i == -1) {
                i = adSource.bidfloor;
            } else {
                int i2 = adSource.bidfloor;
                if (i == i2) {
                    if (adSource.isApiBidAd) {
                        arrayList.add(0, adSource);
                    }
                } else if (i2 > i) {
                    arrayList.clear();
                    arrayList.add(adSource);
                    i = i2;
                }
            }
            arrayList.add(adSource);
        }
        LogcatUtil.d("YdSDK-Manager", "Bottom Ads广告数量:" + arrayList.size());
        if (arrayList.size() == 1) {
            this.adViewAdapter = this.bottomSuccessAds.get(arrayList.get(0));
            callBackLoadAd((AdSource) arrayList.get(0));
            return;
        }
        if (arrayList.size() <= 1) {
            this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.AD_DATA_ERROR, "bottom ad list is null"));
            return;
        }
        Iterator it = arrayList.iterator();
        int i3 = 10000;
        AdSource adSource2 = null;
        while (it.hasNext()) {
            AdSource adSource3 = (AdSource) it.next();
            int i4 = adSource3.sequence;
            if (i3 > i4) {
                adSource2 = adSource3;
                i3 = i4;
            }
        }
        if (adSource2 == null) {
            this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.AD_DATA_ERROR, "No available ads found in bottom ad"));
        } else {
            this.adViewAdapter = this.bottomSuccessAds.get(adSource2);
            callBackLoadAd(adSource2);
        }
    }

    private void startRequestWaterFall() {
        AdPlace adPlace;
        List<AdSource> list;
        AdPlace adPlace2 = this.originalAdPlace;
        if (adPlace2 == null) {
            this.isWaterfallDone = true;
            return;
        }
        this.haveStartWaterFall = true;
        List<AdSource> ration = getRation(adPlace2);
        WaterfallHierarchyController waterfallHierarchyController = new WaterfallHierarchyController();
        waterfallHierarchyController.hierarchy = this.nowNum;
        waterfallHierarchyController.adNum = ration.size();
        this.adStatus.put(Integer.valueOf(this.nowNum), waterfallHierarchyController);
        for (AdSource adSource : ration) {
            adSource.adHierarchy = this.nowNum;
            requestAdBySource(adSource);
        }
        if (!this.isLastHierarchy || (adPlace = this.adSaasPlace) == null || (list = adPlace.bottom_ad_sources) == null || list.isEmpty()) {
            return;
        }
        this.has_bottom_ad = true;
        requestBottomAd(this.originalAdPlace.bottom_ad_sources);
    }

    private void testSaveShowAdMsg() {
        if (this.adViewAdapter != null) {
            ConfigHelper.getInstance().adSource = this.adViewAdapter.getAdSource();
        }
    }

    private void updateCacheMessage(AdapterAPI adapterAPI, String str) {
        if (adapterAPI != null) {
            AdSource adSource = adapterAPI.getAdSource();
            adSource.global_group_id = adSource.group_id;
            adSource.global_place_id = adSource.place_id;
            adSource.global_test_id = adSource.test_id;
            adSource.track_id = str;
            AdPlace adPlace = this.originalAdPlace;
            if (adPlace != null) {
                adSource.group_id = adPlace.group_id;
                adSource.place_id = adPlace.place_id;
                adSource.test_id = adPlace.test_id;
            }
            if (adapterAPI instanceof AdChangeCacheData) {
                ((AdChangeCacheData) adapterAPI).setCacheData(str, adSource);
            }
        }
    }

    private void updateImpressFreq() {
        if (this.originalAdPlace == null) {
            return;
        }
        LogcatUtil.d("YdSDK-Manager", "updateImpressFreq");
        String str = this.originalAdPlace.place_id;
        String AcNBzu2 = CtFAbx.AcNBzu(str, "lastShowDay");
        String AcNBzu3 = CtFAbx.AcNBzu(str, "lastDayShowNumber");
        String AcNBzu4 = CtFAbx.AcNBzu(str, "lastShowHour");
        String AcNBzu5 = CtFAbx.AcNBzu(str, "lastHourShowNumber");
        String AcNBzu6 = CtFAbx.AcNBzu(str, "lastShowSec");
        String AcNBzu7 = CtFAbx.AcNBzu(str, "impressFreqDay");
        String AcNBzu8 = CtFAbx.AcNBzu(str, "impressFreqHour");
        String AcNBzu9 = CtFAbx.AcNBzu(str, "impressFreqInterval");
        String string = SPUtil.getInstance().getString(AcNBzu2);
        int i = SPUtil.getInstance().getInt(AcNBzu3);
        long j = SPUtil.getInstance().getLong(AcNBzu4);
        int i2 = SPUtil.getInstance().getInt(AcNBzu5);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String date = DeviceUtil.getDate();
        SPUtil.getInstance().putLong(AcNBzu6, currentTimeMillis);
        if (currentTimeMillis - j > 3600) {
            SPUtil.getInstance().putLong(AcNBzu4, currentTimeMillis);
            SPUtil.getInstance().putInt(AcNBzu5, 1);
        } else {
            SPUtil.getInstance().putInt(AcNBzu5, i2 + 1);
        }
        if (date.equals(string)) {
            SPUtil.getInstance().putInt(AcNBzu3, i + 1);
        } else {
            SPUtil.getInstance().putString(AcNBzu2, date);
            SPUtil.getInstance().putInt(AcNBzu3, 1);
        }
        SPUtil.getInstance().putInt(AcNBzu7, this.originalAdPlace.impress_freq_day);
        SPUtil.getInstance().putInt(AcNBzu8, this.originalAdPlace.impress_freq_hour);
        SPUtil.getInstance().putInt(AcNBzu9, this.originalAdPlace.impress_interval);
    }

    private boolean usePublic() {
        AdPlace adPlace = this.originalAdPlace;
        return adPlace != null && adPlace.rela_public_adplace == 1 && adPlace.use_public_adplace == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waterfallFlowDone() {
        PreloadDoneCallback preloadDoneCallback;
        if (this.has_api_bid || this.has_sdk_bid || this.has_c2s_bid) {
            this.isWaterfallDone = true;
            selectAdShow();
            return;
        }
        if (this.has_bottom_ad) {
            this.isShowBottomAd = true;
            disposeBottomAd();
            return;
        }
        LogcatUtil.d("YdSDK-Manager", "ad no fill");
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.removeMessages(0);
            this.timeHandle.removeMessages(1);
        }
        if (this.isPreloadMode && (preloadDoneCallback = this.preloadDoneCallback) != null) {
            preloadDoneCallback.preloadDone();
        }
        this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.AD_DATA_ERROR, "ad no fill"));
        getPreLoadAdPlace();
        mergeReportMsg();
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        AdapterAPI adapterAPI = this.adViewAdapter;
        if (adapterAPI == null || !(adapterAPI instanceof BiddingResult)) {
            return;
        }
        ((BiddingResult) adapterAPI).biddingResult(z, i, i2, 0);
    }

    public int c2sBidResult() {
        if (this.has_c2s_bid && this.c2sSuccessAds.size() > 0) {
            int i = -1;
            for (AdSource adSource : this.c2sSuccessAds.keySet()) {
                if (!checkOpenCycle() || adSource.is_black != 1) {
                    if (i == -1) {
                        i = adSource.getAdvPrice();
                    } else if (i != adSource.getAdvPrice()) {
                        if (adSource.getAdvPrice() > i) {
                            this.c2sSecondPrice = i;
                            this.c2sSecondAdvId = adSource.adv_id;
                            i = adSource.getAdvPrice();
                            this.c2sResultAds.clear();
                        }
                    }
                    this.c2sResultAds.add(adSource);
                }
            }
            if (this.c2sResultAds.size() > 0) {
                return this.c2sResultAds.get(0).getAdvPrice();
            }
        }
        return -1;
    }

    public boolean changeReRequestCount() {
        int i = this.needReRequestCount;
        if (i <= 0) {
            this.needReRequestCount = 0;
            this.isReRequest = false;
            return false;
        }
        this.needReRequestCount = i - 1;
        resetData();
        this.isReRequest = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        com.fl.saas.config.utils.LogcatUtil.d("YdSDK-Manager", "轮询到第" + r0 + "层广告完成");
        r4.isWaterfallDone = true;
        r4.successAds.putAll(r1.successAds);
        selectAdShow();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void cyclicQueryController(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = "cyclicQueryController:"
            monitor-enter(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r1.append(r5)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = "YdSDK-Manager"
            com.fl.saas.config.utils.LogcatUtil.d(r1, r0)     // Catch: java.lang.Throwable -> L64
            r0 = 0
        L15:
            if (r0 > r5) goto La6
            java.util.Map<java.lang.Integer, com.fl.saas.base.manager.WaterfallHierarchyController> r1 = r4.adStatus     // Catch: java.lang.Throwable -> L64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L64
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L64
            com.fl.saas.base.manager.WaterfallHierarchyController r1 = (com.fl.saas.base.manager.WaterfallHierarchyController) r1     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L27
            goto La6
        L27:
            boolean r2 = r1.isDone()     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L2f
            goto La6
        L2f:
            boolean r2 = r1.isDone()     // Catch: java.lang.Throwable -> L64
            r3 = 1
            if (r2 == 0) goto L66
            boolean r2 = r1.isHasAd()     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L66
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r5.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "轮询到第"
            r5.append(r2)     // Catch: java.lang.Throwable -> L64
            r5.append(r0)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "层广告完成"
            r5.append(r0)     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "YdSDK-Manager"
            com.fl.saas.config.utils.LogcatUtil.d(r0, r5)     // Catch: java.lang.Throwable -> L64
            r4.isWaterfallDone = r3     // Catch: java.lang.Throwable -> L64
            java.util.Map<com.fl.saas.common.saas.bean.AdSource, com.fl.saas.base.base.AdapterAPI> r5 = r4.successAds     // Catch: java.lang.Throwable -> L64
            java.util.Map<com.fl.saas.common.saas.bean.AdSource, com.fl.saas.base.base.AdapterAPI> r0 = r1.successAds     // Catch: java.lang.Throwable -> L64
            r5.putAll(r0)     // Catch: java.lang.Throwable -> L64
            r4.selectAdShow()     // Catch: java.lang.Throwable -> L64
            goto La6
        L64:
            r5 = move-exception
            goto La8
        L66:
            if (r0 != r5) goto L8f
            int r1 = r4.waterfallFlowStop     // Catch: java.lang.Throwable -> L64
            r2 = -1
            if (r1 == r2) goto L8f
            if (r1 != r5) goto L8f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r1.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "轮询到第"
            r1.append(r2)     // Catch: java.lang.Throwable -> L64
            r1.append(r0)     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "层广告,瀑布流有高价填充"
            r1.append(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "YdSDK-Manager"
            com.fl.saas.config.utils.LogcatUtil.d(r2, r1)     // Catch: java.lang.Throwable -> L64
            r4.isWaterfallDone = r3     // Catch: java.lang.Throwable -> L64
            r4.selectAdShow()     // Catch: java.lang.Throwable -> L64
        L8f:
            int r1 = r4.sumHierarchyNum     // Catch: java.lang.Throwable -> L64
            if (r1 != r3) goto L98
            r4.isWaterfallDone = r3     // Catch: java.lang.Throwable -> L64
            r4.selectAdShow()     // Catch: java.lang.Throwable -> L64
        L98:
            int r1 = r4.sumHierarchyNum     // Catch: java.lang.Throwable -> L64
            int r1 = r1 - r3
            if (r1 != r5) goto La2
            r4.isWaterfallDone = r3     // Catch: java.lang.Throwable -> L64
            r4.selectAdShow()     // Catch: java.lang.Throwable -> L64
        La2:
            int r0 = r0 + 1
            goto L15
        La6:
            monitor-exit(r4)
            return
        La8:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L64
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.manager.loader.AdViewManager.cyclicQueryController(int):void");
    }

    public void destroy() {
        try {
            Iterator<Map.Entry<AdSource, AdapterAPI>> it = this.successAds.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
            Iterator<Map.Entry<AdSource, AdapterAPI>> it2 = this.c2sSuccessAds.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().destroy();
            }
            Iterator<Map.Entry<AdSource, AdapterAPI>> it3 = this.bottomSuccessAds.entrySet().iterator();
            while (it3.hasNext()) {
                it3.next().getValue().destroy();
            }
            Handler handler = this.timeHandle;
            if (handler != null) {
                handler.removeMessages(0);
                this.timeHandle.removeMessages(1);
                this.timeHandle.removeMessages(3);
                this.timeHandle.removeMessages(8);
                this.timeHandle = null;
            }
            mergeReportMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdPlace getOriginalAdPlace() {
        return this.originalAdPlace;
    }

    public synchronized List<AdSource> getRation(AdPlace adPlace) {
        if (adPlace == null) {
            return new ArrayList();
        }
        if (adPlace.ad_sources.size() <= adPlace.request_num) {
            this.isLastHierarchy = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < adPlace.ad_sources.size(); i++) {
                if (i == 0 && !this.isSetTop) {
                    adPlace.ad_sources.get(i).isTop = true;
                    this.isSetTop = true;
                }
                adPlace.ad_sources.get(i).sumNum = adPlace.ad_sources.size();
                setCurrentPriceFloor(adPlace.ad_sources.get(i).bidfloor);
                arrayList.add(adPlace.ad_sources.get(i));
            }
            adPlace.ad_sources.clear();
            this.adSaasPlace = adPlace;
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < adPlace.request_num; i2++) {
            if (i2 == 0 && !this.isSetTop) {
                adPlace.ad_sources.get(i2).isTop = true;
                this.isSetTop = true;
            }
            setCurrentPriceFloor(adPlace.ad_sources.get(0).bidfloor);
            adPlace.ad_sources.get(0).sumNum = adPlace.request_num;
            arrayList2.add(adPlace.ad_sources.get(0));
            adPlace.ad_sources.remove(0);
        }
        this.adSaasPlace = adPlace;
        return arrayList2;
    }

    public AdapterAPI getValidAdapter() {
        return this.adViewAdapter;
    }

    public void hasSdkBid() {
        this.has_sdk_bid = true;
    }

    public synchronized boolean isHasAdErrInfo(ErrorInfo errorInfo) {
        try {
            for (ErrorInfo errorInfo2 : this.errInfos) {
                if (errorInfo2.adv_id.equals(errorInfo.adv_id) && errorInfo2.tagid.equals(errorInfo.tagid)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isReRequest() {
        return this.isReRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:3:0x0001, B:7:0x001b, B:11:0x0029, B:15:0x0037, B:20:0x0041, B:22:0x0049, B:23:0x0053, B:25:0x0059, B:29:0x0068, B:31:0x0070, B:32:0x007a, B:34:0x0080, B:41:0x0091, B:45:0x00a1, B:47:0x00ae, B:49:0x00b4, B:50:0x00d2, B:52:0x00d8, B:54:0x00e6, B:56:0x00ea, B:58:0x00ee, B:60:0x00f2, B:62:0x00f8, B:63:0x0101, B:65:0x0105, B:73:0x0030, B:77:0x0022, B:81:0x0011), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[Catch: all -> 0x0017, TRY_ENTER, TryCatch #0 {all -> 0x0017, blocks: (B:3:0x0001, B:7:0x001b, B:11:0x0029, B:15:0x0037, B:20:0x0041, B:22:0x0049, B:23:0x0053, B:25:0x0059, B:29:0x0068, B:31:0x0070, B:32:0x007a, B:34:0x0080, B:41:0x0091, B:45:0x00a1, B:47:0x00ae, B:49:0x00b4, B:50:0x00d2, B:52:0x00d8, B:54:0x00e6, B:56:0x00ea, B:58:0x00ee, B:60:0x00f2, B:62:0x00f8, B:63:0x0101, B:65:0x0105, B:73:0x0030, B:77:0x0022, B:81:0x0011), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x002e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void nextRequestSdkAd() {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.manager.loader.AdViewManager.nextRequestSdkAd():void");
    }

    public void onAdFailed(YdError ydError) {
        this.mAdapterGenerator.onLoadFailed(ydError);
    }

    public void onSDKBidFailed(YdError ydError) {
        LogcatUtil.d("YdSDK-Manager", "reqSDKBid onFailed:" + ydError);
        if (this.isOnlySdkBid) {
            this.isShowBottomAd = true;
        }
        this.sdkBidRetrun = true;
        this.has_sdk_bid = false;
        selectAdShow();
        if (this.isWaterfallDone && this.isOnlySdkBid) {
            this.mAdapterGenerator.onLoadFailed(ydError);
            getPreLoadAdPlace();
        }
    }

    public void preloadSdkAd(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        this.isPreloadMode = true;
        this.preloadDoneCallback = preloadDoneCallback;
        requestSdkAd(adPlace);
    }

    public void removeMessages(int i) {
        Handler handler = this.timeHandle;
        if (handler == null) {
            return;
        }
        handler.removeMessages(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:187:0x00ff, code lost:
    
        if (r6.getAdSource().getAdvPrice() > r5.getAdSource().getAdvPrice()) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestSdkAd(com.fl.saas.common.saas.bean.AdPlace r18) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.manager.loader.AdViewManager.requestSdkAd(com.fl.saas.common.saas.bean.AdPlace):void");
    }

    public void retrunBottomResult() {
        AdPlace adPlace = this.adSaasPlace;
        if (adPlace != null && this.has_bottom_ad && this.bottomFailNum + this.bottomFinishNum == adPlace.bottom_ad_sources.size()) {
            LogcatUtil.d("YdSDK-Manager", "兜底广告全部返回结果," + this.isShowBottomAd);
            this.isBottomAdDone = true;
            if (this.isShowBottomAd) {
                disposeBottomAd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x025d A[Catch: all -> 0x001b, Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:5:0x0003, B:7:0x000e, B:9:0x0012, B:13:0x0021, B:15:0x0025, B:17:0x0029, B:20:0x0032, B:22:0x0036, B:24:0x003a, B:27:0x0043, B:29:0x0047, B:32:0x0053, B:34:0x0057, B:38:0x0061, B:40:0x006b, B:41:0x0079, B:42:0x008a, B:44:0x0090, B:46:0x009c, B:69:0x00a3, B:66:0x00a5, B:50:0x00a9, B:60:0x00ad, B:63:0x00b1, B:55:0x00b7, B:75:0x00bf, B:77:0x00e3, B:79:0x00ed, B:81:0x00f9, B:82:0x010d, B:83:0x011f, B:84:0x017a, B:85:0x0259, B:87:0x025d, B:89:0x0261, B:90:0x0264, B:93:0x0124, B:94:0x0137, B:96:0x013e, B:97:0x0144, B:99:0x014a, B:108:0x0159, B:110:0x015d, B:112:0x0161, B:113:0x0167, B:114:0x0181, B:115:0x0190, B:116:0x0256, B:118:0x019d, B:121:0x01ba, B:123:0x01be, B:126:0x01c5, B:128:0x01cb, B:129:0x01d8, B:131:0x01de, B:134:0x01e8, B:136:0x01ec, B:139:0x01f2, B:142:0x01f9, B:150:0x0205, B:151:0x020f, B:153:0x0215, B:156:0x021f, B:158:0x0223, B:161:0x0229, B:164:0x0230, B:173:0x023e, B:176:0x0245, B:178:0x0249, B:180:0x024d), top: B:4:0x0003, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void selectAdShow() {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.manager.loader.AdViewManager.selectAdShow():void");
    }

    public synchronized void selectBottomAdapter() {
        LogcatUtil.d("YdSDK-Adapter", "selectBottomAdapter");
        if (!this.isSelectBottomAdapter) {
            this.isSelectBottomAdapter = true;
            this.isWaterfallDone = true;
            this.isC2SAdDone = true;
            this.sdkBidRetrun = true;
            this.apiBidRetrun = true;
            selectAdShow();
        }
    }

    public void sendMessageDelayed(int i, long j) {
        if (this.timeHandle == null) {
            return;
        }
        Message message = new Message();
        message.what = i;
        this.timeHandle.sendMessageDelayed(message, j);
    }

    public synchronized void setBottomSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.bottomSuccessAds.put(adSource, adapterAPI);
    }

    public synchronized void setErrInfo(ErrorInfo errorInfo) {
        this.errInfos.add(errorInfo);
    }

    public void setKey(String str) {
        this.key = str;
    }

    public synchronized void setRequestInfo(AdSource adSource) {
        if (adSource.isApiBidAd) {
            return;
        }
        adSource.cost_time = DeviceUtil.getBootTime() - adSource.reqTime;
        this.listRequestInfo.add(adSource);
    }

    public synchronized void setResponseInfo(AdSource adSource) {
        if (adSource.isApiBidAd) {
            return;
        }
        adSource.cost_time = DeviceUtil.getBootTime() - adSource.reqTime;
        this.listResponseInfo.add(adSource);
    }

    public synchronized void setS2SFailAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.c2sFailAds.put(adSource, adapterAPI);
    }

    public synchronized void setS2SSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.c2sSuccessAds.put(adSource, adapterAPI);
    }

    public synchronized void setSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.successAds.put(adSource, adapterAPI);
    }
}
