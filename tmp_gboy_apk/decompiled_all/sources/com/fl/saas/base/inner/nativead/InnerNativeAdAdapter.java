package com.fl.saas.base.inner.nativead;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.nativead.InnerNativeAdAdapter;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.pojo.NativeADAppMiitInfo;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class InnerNativeAdAdapter extends AdViewNativeAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* renamed from: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(com.fl.saas.base.bidding.A4TApA.A2egSU(nativeAd, InnerNativeAdAdapter.this.handler));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$onNativeAdLoaded$1() {
            return InnerNativeAdAdapter.this.getAdSource().getECPM();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ WinAdInfo lambda$onNativeAdLoaded$2() {
            return InnerNativeAdAdapter.this.getWinInfo();
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeAdAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeAdAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.nativead.A2egSU
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    Integer lambda$onNativeAdLoaded$0;
                    lambda$onNativeAdLoaded$0 = InnerNativeAdAdapter.AnonymousClass1.this.lambda$onNativeAdLoaded$0(nativeAd);
                    return lambda$onNativeAdLoaded$0;
                }
            });
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.fl.saas.base.inner.nativead.A4TApA
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    int lambda$onNativeAdLoaded$1;
                    lambda$onNativeAdLoaded$1 = InnerNativeAdAdapter.AnonymousClass1.this.lambda$onNativeAdLoaded$1();
                    return lambda$onNativeAdLoaded$1;
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.1.1
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(InnerNativeAdAdapter.this.getAdSource().mAdv_id, InnerNativeAdAdapter.this.getAdSource().mTagid);
                }

                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdSource getSource() {
                    return InnerNativeAdAdapter.this.getAdSource();
                }
            });
            baseNativeAd.setWinAdInfoMapper(new BaseNativeAd.WinAdInfoMapper() { // from class: com.fl.saas.base.inner.nativead.A5SV6n
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.WinAdInfoMapper
                public final WinAdInfo getAdInfo() {
                    WinAdInfo lambda$onNativeAdLoaded$2;
                    lambda$onNativeAdLoaded$2 = InnerNativeAdAdapter.AnonymousClass1.this.lambda$onNativeAdLoaded$2();
                    return lambda$onNativeAdLoaded$2;
                }
            });
            InnerNativeAdAdapter.this.mNativeAd = nativeAd;
            InnerNativeAdAdapter.this.render(nativeAd);
        }
    }

    /* renamed from: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements NativeEventListener {
        private boolean isReportExposure = false;
        final /* synthetic */ YdNativePojo val$pojo;
        final /* synthetic */ Optional val$pojoOptional;

        public AnonymousClass4(Optional optional, YdNativePojo ydNativePojo) {
            this.val$pojoOptional = optional;
            this.val$pojo = ydNativePojo;
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdClicked(NativeAdView nativeAdView) {
            InnerNativeAdAdapter.this.onClickedEvent(0);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdClose(NativeAdView nativeAdView) {
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
            InnerNativeAdAdapter.this.onAdFailed(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdImpressed(NativeAdView nativeAdView) {
            if (this.isReportExposure) {
                return;
            }
            this.isReportExposure = true;
            InnerNativeAdAdapter.this.onShowEvent(0);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoEnd(NativeAdView nativeAdView) {
            this.val$pojoOptional.map(new AZOQYO(21)).ifPresent(new ADYaiT(this.val$pojo, 1));
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoStart(NativeAdView nativeAdView) {
            this.val$pojoOptional.map(new AZOQYO(21)).ifPresent(new ADYaiT(this.val$pojo, 0));
        }
    }

    private void bindEvent(NativeAd nativeAd, YdNativePojo ydNativePojo) {
        nativeAd.setNativeEventListener(new AnonymousClass4(Optional.ofNullable(ydNativePojo), ydNativePojo));
    }

    private YdNativePojo createPojo(final NativeAd nativeAd) {
        return new YdNativePojo() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.3
            private List<View> clicks;
            public NativeAdView nativeAdView;

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void bindClickViews(List<View> list) {
                this.clicks = list;
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void bindViewGroup(ViewGroup viewGroup) {
                ViewParent parent = viewGroup.getParent();
                if (parent instanceof NativeAdView) {
                    NativeAdView nativeAdView = (NativeAdView) parent;
                    this.nativeAdView = nativeAdView;
                    nativeAd.renderAdContainer(nativeAdView, viewGroup);
                } else {
                    this.nativeAdView = new NativeAdView(InnerNativeAdAdapter.this.getContext());
                    handleBindView(InnerNativeAdAdapter.this.getContext(), viewGroup, this.nativeAdView);
                    nativeAd.renderAdContainer(this.nativeAdView, viewGroup);
                }
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void closeAd() {
                super.closeAd();
                ViewHelper.removeParent(this.nativeAdView);
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo, com.fl.saas.ydsdk.api.MediaExtraInfo
            public AdInfo getAdInfo() {
                return nativeAd.getAdInfo();
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public View getAdView() {
                return nativeAd.getAdMaterial().getAdMediaView();
            }

            @Override // com.fl.saas.common.pojo.YdNativePojo
            public YdNativePojo.CustomizeVideo getCustomVideo() {
                return nativeAd.getCustomizeVideo();
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void render() {
                NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                nativePrepareInfo.setActivity(InnerNativeAdAdapter.this.getActivityOrNull());
                List<View> list = this.clicks;
                if (list != null) {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        nativePrepareInfo.setClickView(it.next());
                    }
                }
                nativeAd.prepare(nativePrepareInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (nativeAd.isNativeExpress()) {
            LogcatUtil.d(this.TAG, "native but is express ad");
            disposeError(YdError.create(ErrorCodeConstant.RENDER_ERROR, "native but is express ad"));
            return;
        }
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        ArrayList arrayList = new ArrayList();
        YdNativePojo createPojo = createPojo(nativeAd);
        createPojo.setTitle(adMaterial.getTitle());
        createPojo.setDesc(adMaterial.getDescription());
        createPojo.setBtnText(adMaterial.getCallToAction());
        createPojo.setIconUrl(adMaterial.getIconUrl());
        String mainImageUrl = adMaterial.getMainImageUrl();
        List<String> imageUrlList = adMaterial.getImageUrlList();
        if (TextUtils.isEmpty(mainImageUrl) && imageUrlList != null && !imageUrlList.isEmpty()) {
            Iterator<String> it = imageUrlList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    mainImageUrl = next;
                    break;
                }
            }
        }
        createPojo.setImgUrl(mainImageUrl);
        createPojo.setImgList(imageUrlList);
        createPojo.setECPM(getAdSource().getPrice());
        createPojo.setVideoDuration(adMaterial.getVideoDuration());
        createPojo.setCornerMark(adMaterial.getAdLogo());
        createPojo.setAdLogoBitmap(adMaterial.getAdLogoBitmap());
        createPojo.setAdLogoUrl(adMaterial.getAdLogoUrl());
        final NativeAdAppInfo adAppInfo = adMaterial.getAdAppInfo();
        if (adAppInfo != null) {
            createPojo.setAppInfo(new NativeADAppMiitInfo() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.2
                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getAppName() {
                    return adAppInfo.getAppName();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getAuthorName() {
                    return adAppInfo.getPublisher();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getFunctionUrl() {
                    return adAppInfo.getFunctionUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public long getPackageSizeBytes() {
                    return 0L;
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public Map<String, String> getPermissionsMap() {
                    return null;
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getPermissionsUrl() {
                    return adAppInfo.getAppPermissionUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getPrivacyAgreement() {
                    return adAppInfo.getAppPrivacyUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getVersionName() {
                    return adAppInfo.getAppVersion();
                }
            });
        }
        arrayList.add(createPojo);
        onLoadedEvent(arrayList);
        bindEvent(nativeAd, createPojo);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.bidding.BiddingResult
    public final /* synthetic */ void biddingResult(boolean z, int i, int i2, int i3) {
        com.fl.saas.base.inner.A2egSU.A2egSU(this, z, i, i2, i3);
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.interfaces.AdMaterial
    public final /* synthetic */ AdMaterial.AdMaterialData getAdMaterialData() {
        return com.fl.saas.base.inner.A2egSU.A4TApA(this);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedWidth(getWidth()).setImageAcceptedHeight(getHeight()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public final /* synthetic */ void innerDestroy(MixNativeHandler mixNativeHandler, NativeAd nativeAd) {
        com.fl.saas.base.inner.A2egSU.A5SV6n(this, mixNativeHandler, nativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.interfaces.AdValid
    public final /* synthetic */ boolean isValid() {
        return com.fl.saas.base.inner.A2egSU.ADYaiT(this);
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }
}
