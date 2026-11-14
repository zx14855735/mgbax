package com.fl.saas.base.manager.loader;

import ADYaiT.BChYOn;
import DaOi9o.AYUAbz;
import android.app.Activity;
import android.content.Context;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingRequest;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.interfaces.AdMaterialJson;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.api.AdapterGenerator;
import com.fl.saas.base.manager.api.LoadAPI;
import com.fl.saas.base.manager.api.ManagerInfoAPI;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.listener.ApiSaaSListener;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.YdAppBackgroundUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseLoader<T extends AdapterAPI> implements LoadAPI, ManagerInfoAPI, AdapterGenerator {
    private boolean isTrafficTimeReported = false;
    private String key;
    private AdPlace mAdPlace;
    private int mAdType;
    protected ManagerLoader<T> mLoader;
    private final AdViewManager manager;
    private long trafficStartTime;

    /* renamed from: com.fl.saas.base.manager.loader.BaseLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements ApiSaaSListener {
        final /* synthetic */ String val$key;

        public AnonymousClass1(String str) {
            this.val$key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(String str, Context context) {
            PreloadHelper.getInstance().setPreLoadContext(context);
            if (YdAppBackgroundUtil.getInstance().checkPlaceId(str) && (context instanceof Activity)) {
                YdAppBackgroundUtil.getInstance().setShowName(((Activity) context).getComponentName().getClassName());
            }
        }

        @Override // com.fl.saas.common.listener.ApiSaaSListener
        public void onFailed(String str) {
            BaseLoader.this.onLoadFailed(new YdError(ErrorCodeConstant.CONFIG_ERROR, str));
            LogcatUtil.d("YdSDK", "requestConfig, error: " + str);
        }

        @Override // com.fl.saas.common.listener.ApiSaaSListener
        public void onSuccess(AdPlace adPlace) {
            BaseLoader.this.mAdPlace = adPlace;
            if (adPlace.isBidding()) {
                BaseLoader.this.manager.hasSdkBid();
                BaseLoader.this.reqSdkBidAd(adPlace);
            }
            BaseLoader.this.manager.requestSdkAd(adPlace);
            try {
                Optional<Context> contextOpt = BaseLoader.this.mLoader.getContextOpt();
                final String str = this.val$key;
                contextOpt.ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.loader.AMqCpz
                    @Override // com.fl.saas.common.util.feature.Consumer
                    public final void accept(Object obj) {
                        BaseLoader.AnonymousClass1.lambda$onSuccess$0(str, (Context) obj);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.fl.saas.base.manager.loader.BaseLoader$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType;

        static {
            int[] iArr = new int[AdCacheManager.CacheType.values().length];
            $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType = iArr;
            try {
                iArr[AdCacheManager.CacheType.PLACE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[AdCacheManager.CacheType.SHARE_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BaseLoader(ManagerLoader<T> managerLoader, int i) {
        this.mLoader = managerLoader;
        this.mAdType = i;
        this.manager = new AdViewManager(this, i);
    }

    private Optional<AdSource> getValidAdSource() {
        return getValidAdapter().map(new ADYaiT(3));
    }

    private AdapterAPI handleAdapterConfig(AdapterAPI adapterAPI) {
        return (AdapterAPI) this.mLoader.getContextOpt().map(new AYUAbz(this, 4, adapterAPI)).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AdInfo lambda$getAdInfo$5(AdSource adSource) {
        return AdInfo.create(adSource.mAdv_id, adSource.mTagid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$getValidAdapter$4(AdViewManager adViewManager) {
        try {
            return this.manager.getValidAdapter();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$handleAdapterConfig$2(AdapterAPI adapterAPI, Context context) {
        try {
            return this.mLoader.bindAdapter(adapterAPI).setContext(context).setAdAdapter(this.manager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdapter$0(AdapterAPI adapterAPI) {
        try {
            AdapterAPI handleAdapterConfig = handleAdapterConfig(adapterAPI);
            if (handleAdapterConfig != null) {
                handleAdapterConfig.load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$popCacheAdapter$3(AdCacheManager.CacheType cacheType, String str, long j, Context context) {
        int i = AnonymousClass3.$SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[cacheType.ordinal()];
        AdapterAPI cacheAd = i != 1 ? i != 2 ? null : AdCacheManager.getInstance().getCacheAd(this.mAdType, j) : AdCacheManager.getInstance().getPlaceCacheAd(this.mAdType, str, j);
        if (cacheAd != null) {
            cacheAd = handleAdapterConfig(cacheAd);
            AdSource adSource = cacheAd.getAdSource();
            if (adSource != null) {
                adSource.isPopCacheAd = true;
                int i2 = adSource.price;
                if (i2 > 0) {
                    adSource.bidfloor = i2;
                }
            }
            cacheAd.clearCache();
        }
        return cacheAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reqSdkBidAd$1(final AdPlace adPlace, Context context) {
        new BiddingRequest(this.key, context, new BiddingRequest.BiddingLoadEvent() { // from class: com.fl.saas.base.manager.loader.BaseLoader.2
            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onFailed(YdError ydError) {
                BaseLoader.this.manager.onSDKBidFailed(ydError);
            }

            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onStart() {
                BaseLoader.this.manager.sendMessageDelayed(6, adPlace.api_timeout);
            }

            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onSucc(AdSource adSource, Object obj) {
                BaseLoader.this.handleSDKBidAd(adSource, obj);
            }
        }).reqSdkBidAd(AdType.getType(getClass()), adPlace);
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        this.manager.biddingResultUpload(z, i, i2);
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public void destroy() {
        this.manager.destroy();
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public AdInfo getAdInfo() {
        return (AdInfo) getValidAdSource().map(new ADYaiT(0)).orElseGet(new ADYaiT(1));
    }

    public AdPlace getAdPlace() {
        return this.mAdPlace;
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public int getEcpm() {
        AdPlace adPlace = this.mAdPlace;
        if (adPlace == null || adPlace.fill_price != 0) {
            return ((Integer) getValidAdSource().map(new ADYaiT(2)).orElse(0)).intValue();
        }
        return -1;
    }

    public String getMaterialJson() {
        T validAdapterOrNull = getValidAdapterOrNull();
        return validAdapterOrNull instanceof AdMaterialJson ? ((AdMaterialJson) validAdapterOrNull).getMaterialJson() : "";
    }

    public String getReqId() {
        return (String) getValidAdSource().map(new AZOQYO(29)).orElse("");
    }

    public AdapterAPI getShowAdapter() {
        return this.manager.getValidAdapter();
    }

    public Optional<T> getValidAdapter() {
        return Optional.ofNullable(this.manager).map(new AmA8tU.A2egSU() { // from class: com.fl.saas.base.manager.loader.A5SV6n
            @Override // AmA8tU.A2egSU
            public final Object apply(Object obj) {
                AdapterAPI lambda$getValidAdapter$4;
                lambda$getValidAdapter$4 = BaseLoader.this.lambda$getValidAdapter$4((AdViewManager) obj);
                return lambda$getValidAdapter$4;
            }
        });
    }

    public T getValidAdapterOrNull() {
        return getValidAdapter().orElse(null);
    }

    public abstract void handleSDKBidAd(AdSource adSource, Object obj);

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.mLoader.isFailedCallBack();
    }

    public void loadAdapter(AdapterAPI adapterAPI) {
        DeviceUtil.postUI(new BChYOn(this, 24, adapterAPI));
    }

    public void loadConfig(String str) {
        this.trafficStartTime = System.currentTimeMillis();
        ConfigHelper.getInstance().requestConfig(str, new AnonymousClass1(str), this.trafficStartTime);
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public void onAdFailed(YdError ydError) {
        this.mLoader.onAdFailed(ydError);
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        this.mLoader.onLoadFailed(ydError);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public AdapterAPI popCacheAdapter(final AdCacheManager.CacheType cacheType, final String str, final long j) {
        try {
            return (AdapterAPI) this.mLoader.getContextOpt().map(new AmA8tU.A2egSU() { // from class: com.fl.saas.base.manager.loader.A4TApA
                @Override // AmA8tU.A2egSU
                public final Object apply(Object obj) {
                    AdapterAPI lambda$popCacheAdapter$3;
                    lambda$popCacheAdapter$3 = BaseLoader.this.lambda$popCacheAdapter$3(cacheType, str, j, (Context) obj);
                    return lambda$popCacheAdapter$3;
                }
            }).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.fl.saas.base.manager.api.LoadAPI
    public void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        if (adPlace == null || preloadDoneCallback == null) {
            return;
        }
        this.trafficStartTime = System.currentTimeMillis();
        if (adPlace.isBidding()) {
            this.manager.hasSdkBid();
            reqSdkBidAd(adPlace);
        }
        this.manager.preloadSdkAd(adPlace, preloadDoneCallback);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void pushCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j, List<AdapterAPI> list) {
        try {
            int i = AnonymousClass3.$SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[cacheType.ordinal()];
            if (i == 1) {
                AdCacheManager.getInstance().addPlaceCacheAd(this.mAdType, str, j, list);
            } else {
                if (i != 2) {
                    return;
                }
                AdCacheManager.getInstance().addCacheAd(this.mAdType, str, j, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void reportFullAd(AdSource adSource) {
        if (this.isTrafficTimeReported) {
            return;
        }
        ReportHelper.getInstance().reportFullAd(adSource, System.currentTimeMillis() - this.trafficStartTime);
        this.isTrafficTimeReported = true;
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void reqSdkBidAd(AdPlace adPlace) {
        this.mLoader.getContextOpt().ifPresent(new com.fl.saas.base.innterNative.A2egSU(this, 2, adPlace));
    }

    @Override // com.fl.saas.base.manager.api.LoadAPI
    public void request(String str) {
        this.key = str;
        this.manager.setKey(str);
        LogcatUtil.d("YdSDK-API", "URL: http://ads.adfunlink.com:8080/server/newConfig");
        LogcatUtil.d("YdSDK-API", "请求的: appId:" + DeviceUtil.appId + "   posId:" + str);
        loadConfig(str);
    }

    public void selectBottomAd() {
        this.manager.selectBottomAdapter();
    }
}
