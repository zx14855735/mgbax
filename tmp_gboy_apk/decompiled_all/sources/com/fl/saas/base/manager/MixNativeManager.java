package com.fl.saas.base.manager;

import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.MixNativeAdManager;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.adapter.AdViewMixNativeAdapter;
import com.fl.saas.base.adapter.MixNativeAPI;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.adapter.manager.MixNativeAPIManager;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MixNativeManager implements MixNativeAdManager, ManagerLoader<AdViewMixNativeAdapter> {
    private static final MixNativeAPIManager<? extends MixNativeAPI> mMixNativeManager = new MixNativeAPIManager<>(MixNativeHandler.class);
    private boolean isFailedCallBack = false;
    private final WeakReference<Context> mContextRef;
    private NativeLoadListener mLoadListener;
    private final BaseLoader<AdViewMixNativeAdapter> mLoader;
    private final AdParams mParams;
    private final OnNativeReleaseListener onNativeReleaseListener;

    /* renamed from: com.fl.saas.base.manager.MixNativeManager$1, reason: invalid class name */
    public class AnonymousClass1 extends BaseLoader<AdViewMixNativeAdapter> {
        public AnonymousClass1(ManagerLoader managerLoader, int i) {
            super(managerLoader, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadAdapter$0(MixNativeAPI mixNativeAPI, AdSource adSource, Context context) {
            mixNativeAPI.setContext(context);
            mixNativeAPI.setAdSource(adSource);
            mixNativeAPI.setAdParams(MixNativeManager.this.mParams);
            AdViewMixNativeAdapter adViewMixNativeAdapter = new AdViewMixNativeAdapter(mixNativeAPI);
            adViewMixNativeAdapter.setOnNativeReleaseListener(MixNativeManager.this.onNativeReleaseListener);
            adViewMixNativeAdapter.setKey(adViewMixNativeAdapter.getKey());
            adViewMixNativeAdapter.setContext(context);
            adViewMixNativeAdapter.setAdSource(adSource);
            loadAdapter(adViewMixNativeAdapter);
        }

        private void loadAdapter(final MixNativeAPI mixNativeAPI, final AdSource adSource) {
            if (mixNativeAPI == null || adSource == null) {
                return;
            }
            this.mLoader.getContextOpt().ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.ADYaiT
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    MixNativeManager.AnonymousClass1.this.lambda$loadAdapter$0(mixNativeAPI, adSource, (Context) obj);
                }
            });
        }

        @Override // com.fl.saas.base.manager.loader.BaseLoader
        public void handleSDKBidAd(AdSource adSource, Object obj) {
            if (obj instanceof MixNativeHandler) {
                loadAdapter((MixNativeAPI) obj, adSource);
            } else {
                requestAd(adSource);
            }
        }

        @Override // com.fl.saas.base.manager.api.AdapterGenerator
        public void requestAd(AdSource adSource) {
            loadAdapter((MixNativeAPI) MixNativeManager.mMixNativeManager.loadAdapter(adSource.adv_id, adSource.customClassName), adSource);
        }
    }

    public interface OnNativeReleaseListener {
        void release();
    }

    static {
        QySx();
    }

    public MixNativeManager(Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        this.mParams = adParams;
        this.mContextRef = new WeakReference<>(context);
        this.mLoadListener = nativeLoadListener;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this, 10);
        this.mLoader = anonymousClass1;
        this.onNativeReleaseListener = new A5SV6n(anonymousClass1);
    }

    private static /* synthetic */ void QySx() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindAdapter$0(NativeAd nativeAd) {
        if (this.mLoadListener != null) {
            if (nativeAd != null) {
                nativeAd.setNativeAdParams(this.mParams);
            }
            this.mLoadListener.onNativeAdLoaded(nativeAd);
        }
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public AdViewMixNativeAdapter bindAdapter(AdViewMixNativeAdapter adViewMixNativeAdapter) {
        return adViewMixNativeAdapter.setLoadListener(new A4TApA(3, this));
    }

    @Override // com.fl.saas.base.manager.api.ManagerLoader
    public Optional<Context> getContextOpt() {
        return Optional.ofNullable(this.mContextRef.get());
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.isFailedCallBack;
    }

    @Override // com.fl.saas.api.mixNative.MixNativeAdManager
    public void load() {
        this.mLoader.request(this.mParams.getKey());
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public void onAdFailed(YdError ydError) {
        if (this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        NativeLoadListener nativeLoadListener = this.mLoadListener;
        if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(ydError);
        }
        this.mLoadListener = null;
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        onAdFailed(ydError);
    }

    public void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        this.mLoader.preload(adPlace, preloadDoneCallback);
    }
}
