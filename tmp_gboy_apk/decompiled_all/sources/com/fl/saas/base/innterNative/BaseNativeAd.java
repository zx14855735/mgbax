package com.fl.saas.base.innterNative;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.api.mixNative.NativeCustomizeVideo;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.base.ReportEventListener;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.base.widget.FingerSlidingView;
import com.fl.saas.base.widget.InclineView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.widget.VisibilityLayout;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.ydsdk.api.YdSDK;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseNativeAd<T> implements NativeAd, MixNativeCycleDataListener {
    private NativeAdView cycleNativeAdView;
    private AdInfoMapper mAdInfoMapper;
    private NativeClickCallbackListener mClickCallBackListener;
    private final Context mContext;
    private NativeAd mCycleNativeAd;
    private int mCycleNativeTime;
    private Timer mCycleTimer;
    private EcpmMapper mEcpmMapper;
    private NativeEventListener mEventListener;
    private T mNativeAd;
    private NativeAdView mNativeAdView;
    private NativeMaterial mNativeMaterial;
    private ReportEventListener mReportEventListener;
    private Timer mTimer;
    private WinAdInfoMapper mWinAdInfoMapper;
    private MixNativeManager.OnNativeReleaseListener onNativeReleaseListener;
    private ViewGroup parentViewGroup;
    private NativeAd refreshNativeAD;
    private AdParams requestParams;
    private View selfRenderView;
    private WeakReference<Activity> showActivityRef;
    private final String TAG = CommConstant.getObjTag("Native", this);
    private boolean isReportExposure = false;
    private boolean nativeAdViewVisibility = true;
    private boolean mCanRefresh = true;
    private boolean isShowOriginalView = true;

    /* renamed from: com.fl.saas.base.innterNative.BaseNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 extends TimerTask {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (!BaseNativeAd.this.isShowOriginalView) {
                BaseNativeAd.this.isShowOriginalView = true;
                if (BaseNativeAd.this.cycleNativeAdView != null) {
                    BaseNativeAd baseNativeAd = BaseNativeAd.this;
                    baseNativeAd.cycleAnimal(baseNativeAd.mNativeAdView, BaseNativeAd.this.cycleNativeAdView);
                    return;
                }
                return;
            }
            if (BaseNativeAd.this.mNativeAdView == null || !(BaseNativeAd.this.mNativeAdView.getParent() instanceof ViewGroup)) {
                return;
            }
            BaseNativeAd.this.isShowOriginalView = false;
            BaseNativeAd baseNativeAd2 = BaseNativeAd.this;
            baseNativeAd2.parentViewGroup = (ViewGroup) baseNativeAd2.mNativeAdView.getParent();
            if (BaseNativeAd.this.cycleNativeAdView != null) {
                BaseNativeAd baseNativeAd3 = BaseNativeAd.this;
                baseNativeAd3.cycleAnimal(baseNativeAd3.cycleNativeAdView, BaseNativeAd.this.mNativeAdView);
                return;
            }
            BaseNativeAd.this.mCycleNativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.2.1
                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdClicked(NativeAdView nativeAdView) {
                    BaseNativeAd.this.onAdClickedEvent();
                    if (BaseNativeAd.this.parentViewGroup == null || BaseNativeAd.this.cycleNativeAdView == null) {
                        return;
                    }
                    BaseNativeAd.this.parentViewGroup.removeView(BaseNativeAd.this.cycleNativeAdView);
                    BaseNativeAd.this.mNativeAdView.setVisibility(0);
                    BaseNativeAd.this.stopCycle();
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdClose(NativeAdView nativeAdView) {
                    BaseNativeAd.this.parentViewGroup.removeAllViews();
                    BaseNativeAd.this.onAdCloseEvent();
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                    BaseNativeAd.this.onAdFailedEvent(ydError);
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdImpressed(NativeAdView nativeAdView) {
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoEnd(NativeAdView nativeAdView) {
                    BaseNativeAd.this.onAdVideoEndEvent();
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                }

                @Override // com.fl.saas.api.mixNative.NativeEventListener
                public void onAdVideoStart(NativeAdView nativeAdView) {
                    BaseNativeAd.this.onAdVideoStartEvent();
                }
            });
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            BaseNativeAd baseNativeAd4 = BaseNativeAd.this;
            baseNativeAd4.cycleNativeAdView = CycleNativeAdUtil.getCycleView((Activity) baseNativeAd4.showActivityRef.get(), BaseNativeAd.this.mCycleNativeAd, BaseNativeAd.this.requestParams, nativePrepareInfo);
            if (BaseNativeAd.this.cycleNativeAdView != null) {
                BaseNativeAd.this.parentViewGroup.addView(BaseNativeAd.this.cycleNativeAdView);
                BaseNativeAd baseNativeAd5 = BaseNativeAd.this;
                baseNativeAd5.cycleAnimal(baseNativeAd5.cycleNativeAdView, BaseNativeAd.this.mNativeAdView);
                nativePrepareInfo.setActivity((Activity) BaseNativeAd.this.showActivityRef.get());
                BaseNativeAd.this.mCycleNativeAd.prepare(nativePrepareInfo);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || !BaseNativeAd.this.nativeAdViewVisibility) {
                return;
            }
            DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.base.innterNative.ADYaiT
                @Override // java.lang.Runnable
                public final void run() {
                    BaseNativeAd.AnonymousClass2.this.lambda$run$0();
                }
            });
        }
    }

    /* renamed from: com.fl.saas.base.innterNative.BaseNativeAd$3, reason: invalid class name */
    public class AnonymousClass3 extends TimerTask {
        public AnonymousClass3() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || !BaseNativeAd.this.nativeAdViewVisibility) {
                return;
            }
            YdSDK.loadMixNative((Context) BaseNativeAd.this.showActivityRef.get(), BaseNativeAd.this.requestParams, new NativeLoadListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.3.1

                /* renamed from: com.fl.saas.base.innterNative.BaseNativeAd$3$1$1, reason: invalid class name and collision with other inner class name */
                public class C02211 implements NativeEventListener {
                    public C02211() {
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdClicked$1(NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdClicked(BaseNativeAd.this.mNativeAdView);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdClose$2(NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdClose(BaseNativeAd.this.mNativeAdView);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdImpressed$0(NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdImpressed(BaseNativeAd.this.mNativeAdView);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdVideoEnd$4(NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdVideoEnd(BaseNativeAd.this.mNativeAdView);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdVideoProgress$5(long j, NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdVideoProgress(BaseNativeAd.this.mNativeAdView, j);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onAdVideoStart$3(NativeEventListener nativeEventListener) {
                        nativeEventListener.onAdVideoStart(BaseNativeAd.this.mNativeAdView);
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdClicked(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().ifPresent(new AMqCpz(this, 0));
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdClose(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().ifPresent(new AMqCpz(this, 1));
                        BaseNativeAd.this.stopRefresh();
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdImpressed(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().ifPresent(new AMqCpz(this, 2));
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdVideoEnd(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().ifPresent(new AMqCpz(this, 4));
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                        BaseNativeAd.this.getEventListener().ifPresent(new ARc23Z(0, j, this));
                    }

                    @Override // com.fl.saas.api.mixNative.NativeEventListener
                    public void onAdVideoStart(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().ifPresent(new AMqCpz(this, 3));
                    }
                }

                @Override // com.fl.saas.base.interfaces.AdViewListener
                public void onAdFailed(YdError ydError) {
                }

                @Override // com.fl.saas.api.mixNative.NativeLoadListener
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    View adMediaView;
                    if (nativeAd == null || !nativeAd.isNativeExpress()) {
                        return;
                    }
                    if (BaseNativeAd.this.refreshNativeAD != null) {
                        BaseNativeAd.this.refreshNativeAD.destroy();
                    }
                    BaseNativeAd.this.refreshNativeAD = nativeAd;
                    nativeAd.setCanRefresh(false);
                    nativeAd.setNativeEventListener(new C02211());
                    if (nativeAd.getAdMaterial() != null && nativeAd.getAdMaterial().getAdMediaView() != null && (adMediaView = nativeAd.getAdMaterial().getAdMediaView()) != null && BaseNativeAd.this.mNativeAdView != null) {
                        BaseNativeAd.this.mNativeAdView.removeAllViews();
                        BaseNativeAd.this.mNativeAdView.addView(adMediaView, ViewHelper.getMatchParent());
                    }
                    nativeAd.renderAdContainer(BaseNativeAd.this.mNativeAdView, null);
                    NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                    nativePrepareInfo.setActivity((Activity) BaseNativeAd.this.showActivityRef.get());
                    nativeAd.prepare(nativePrepareInfo);
                }
            });
        }
    }

    public interface AdInfoMapper {
        AdInfo getAdInfo();

        AdSource getSource();
    }

    public interface EcpmMapper {
        int getECPM();
    }

    public interface WinAdInfoMapper {
        WinAdInfo getAdInfo();
    }

    public BaseNativeAd(Context context) {
        this.mContext = context;
    }

    private void checkCycleAd() {
        if (this.mCycleTimer != null || this.mCycleNativeAd == null || this.mCycleNativeTime <= 0) {
            return;
        }
        Timer timer = new Timer();
        this.mCycleTimer = timer;
        long j = this.mCycleNativeTime * 1000;
        timer.schedule(new AnonymousClass2(), j, j);
    }

    private void checkDataUpdate() {
        try {
            NativeAdView nativeAdView = this.mNativeAdView;
            if (nativeAdView != null) {
                nativeAdView.setOnViewWindowChangedListener(new VisibilityLayout.OnViewWindowChangedListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.1
                    @Override // com.fl.saas.common.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onDetachedFromWindow() {
                        BaseNativeAd.this.stopRefresh();
                        BaseNativeAd.this.stopCycle();
                    }

                    @Override // com.fl.saas.common.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onViewWindowVisibility(boolean z) {
                        BaseNativeAd.this.nativeAdViewVisibility = z;
                    }
                });
            }
            checkRefreshAd();
            checkCycleAd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkRefreshAd() {
        AdInfoMapper adInfoMapper;
        if (this.mTimer == null && isNativeExpress() && this.mCanRefresh && (adInfoMapper = this.mAdInfoMapper) != null && adInfoMapper.getSource() != null) {
            AdSource source = this.mAdInfoMapper.getSource();
            if (source.refresh != 1 || source.refresh_time <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.mTimer = timer;
            long j = 1000 * source.refresh_time;
            timer.schedule(new AnonymousClass3(), j, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cycleAnimal(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view2.setVisibility(8);
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Optional<NativeEventListener> getEventListener() {
        return Optional.ofNullable(this.mEventListener);
    }

    private Optional<ReportEventListener> getReportEventListener() {
        return Optional.ofNullable(this.mReportEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeMaterial lambda$getAdMaterial$1() {
        return (NativeMaterial) getNativeAdOpt().map(new A5SV6n(this)).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenInclineView$11(InclineView.InclineListener inclineListener, ActionView.Type type, View view, int i, int i2, int i3) {
        if (inclineListener != null) {
            inclineListener.onIncline(i, i2, i3);
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenShakeView$10(ShakeView.ShakeListener shakeListener, ActionView.Type type, View view, int i, int i2, int i3) {
        if (shakeListener != null) {
            shakeListener.onShake(i, i2, i3);
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdClickedEvent$4(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClicked(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdClickedEvent$5(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClicked(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdCloseEvent$6(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClose(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdFailedEvent$2(YdError ydError, NativeEventListener nativeEventListener) {
        nativeEventListener.onAdFailed(this.mNativeAdView, ydError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdImpressedEvent$3(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdImpressed(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoEndEvent$8(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoEnd(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoProgress$9(long j, NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoProgress(this.mNativeAdView, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoStartEvent$7(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoStart(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCycle() {
        Timer timer = this.mCycleTimer;
        if (timer != null) {
            timer.cancel();
            this.mCycleTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRefresh() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public void biddingResultUpload(boolean z, int i, int i2) {
        LogcatUtil.d(this.TAG, "biddingResultUpload");
        try {
            if (this instanceof BiddingResult) {
                ((BiddingResult) this).biddingResult(z, i, i2, 0);
            }
        } catch (Exception e) {
            LogcatUtil.d(this.TAG, "biddingResultUploadError:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void bindContainer(ViewGroup viewGroup) {
        if (this.mNativeAdView == null) {
            onAdFailedEvent(YdError.create(ErrorCodeConstant.RENDER_ERROR, "NativeAdView is null"));
            return;
        }
        LogcatUtil.d(this.TAG, "bindContainer");
        ViewGroup.LayoutParams layoutParams = this.selfRenderView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = ViewHelper.getMatchParent();
        }
        this.mNativeAdView.removeAllViews();
        this.mNativeAdView.addView(viewGroup, layoutParams);
        ViewHelper.removeParent(this.selfRenderView);
        viewGroup.addView(this.selfRenderView, ViewHelper.getMatchParent());
    }

    public void bindNativeAd(T t) {
        this.mNativeAd = t;
        init(t);
    }

    public abstract NativeMaterial createNativeMaterial(T t);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        NativeAd nativeAd = this.refreshNativeAD;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        NativeAd nativeAd2 = this.mCycleNativeAd;
        if (nativeAd2 != null) {
            nativeAd2.destroy();
        }
        LogcatUtil.d(this.TAG, "destroy");
        stopRefresh();
        stopCycle();
        this.mEventListener = null;
        this.mClickCallBackListener = null;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        if (adInfoMapper != null) {
            return adInfoMapper.getAdInfo();
        }
        return null;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public NativeMaterial getAdMaterial() {
        NativeMaterial nativeMaterial = (NativeMaterial) Optional.ofNullable(this.mNativeMaterial).orElseGet(new A5SV6n(this));
        this.mNativeMaterial = nativeMaterial;
        return nativeMaterial;
    }

    public View getAreaShakesView() {
        View inflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_area_shake_spread);
        ImageLoader.loadImage(CommConstant.ImageUrl.CLICK_AREA_BG, (ImageView) inflate.findViewById(R.id.iv_bg));
        return inflate;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public /* synthetic */ NativeCustomizeVideo getCustomizeVideo() {
        return KZ9UvL.A2egSU.A2egSU(this);
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public NativeAd getCycleNativeAd() {
        return null;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public int getECPM() {
        return ((Integer) Optional.ofNullable(this.mEcpmMapper).map(new AZOQYO(22)).orElse(0)).intValue();
    }

    public View getInterstitalShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_interstital);
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public /* synthetic */ String getMaterialJson() {
        return KjUDno.A2egSU.ADYaiT(this);
    }

    public T getNativeAd() {
        return this.mNativeAd;
    }

    public Optional<T> getNativeAdOpt() {
        return Optional.ofNullable(this.mNativeAd);
    }

    public NativeAdView getNativeAdView() {
        return this.mNativeAdView;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public String getReqId() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        return (adInfoMapper == null || adInfoMapper.getSource() == null) ? "" : this.mAdInfoMapper.getSource().req_id;
    }

    public View getSelfRenderView() {
        return this.selfRenderView;
    }

    public View getShakeTipsView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_template);
    }

    public View getSpreadInlineView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_incline_spread);
    }

    public View getSpreadShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_spread);
    }

    public View getSpreadSlidingTwistingView(int i, boolean z, int i2, FingerSlidingAndTwistingView.SlidingListener slidingListener) {
        FingerSlidingAndTwistingView fingerSlidingAndTwistingView = new FingerSlidingAndTwistingView(getContext());
        fingerSlidingAndTwistingView.setScale_type(i);
        fingerSlidingAndTwistingView.setSlidingListener(i2, slidingListener);
        fingerSlidingAndTwistingView.createView(z);
        return fingerSlidingAndTwistingView;
    }

    public View getSpreadSlidingView(int i, int i2, FingerSlidingView.SlidingListener slidingListener) {
        FingerSlidingView fingerSlidingView = new FingerSlidingView(getContext());
        fingerSlidingView.setScale_type(i);
        fingerSlidingView.setSlidingListener(i2, slidingListener);
        fingerSlidingView.createView();
        return fingerSlidingView;
    }

    public View getTemplateShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_template);
    }

    public View getTipsView(int i) {
        float f;
        TextView textView = new TextView(getContext());
        int dip2px = DeviceUtil.dip2px(280.0f);
        int dip2px2 = DeviceUtil.dip2px(80.0f);
        if (i != 1) {
            if (i == 2) {
                dip2px = DeviceUtil.dip2px(320.0f);
                f = 100.0f;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = DeviceUtil.dip2px(30.0f);
            textView.setTextSize(16.0f);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.yd_saas_shake_bg_template);
            textView.setText("点击跳转详情页面或第三方应用>");
            textView.setTextColor(Color.parseColor("#ffffff"));
            return textView;
        }
        dip2px = DeviceUtil.dip2px(300.0f);
        f = 90.0f;
        dip2px2 = DeviceUtil.dip2px(f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dip2px, dip2px2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = DeviceUtil.dip2px(30.0f);
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.yd_saas_shake_bg_template);
        textView.setText("点击跳转详情页面或第三方应用>");
        textView.setTextColor(Color.parseColor("#ffffff"));
        return textView;
    }

    public WinAdInfo getWinAdInfo() {
        WinAdInfoMapper winAdInfoMapper = this.mWinAdInfoMapper;
        if (winAdInfoMapper != null) {
            return winAdInfoMapper.getAdInfo();
        }
        return null;
    }

    public abstract void init(T t);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isShakeType() {
        return false;
    }

    public void listenInclineView(View view, boolean z, ActionView.Type type, int i, InclineView.InclineListener inclineListener) {
        InclineView inclineView;
        if (view == null || (inclineView = (InclineView) view.findViewById(R.id.yd_incline_view)) == null) {
            return;
        }
        inclineView.setCallback(z);
        inclineView.setInclineListener(i, new GnQT2j.A4TApA(3, inclineListener, type, view));
    }

    public void listenShakeView(View view, boolean z, ActionView.Type type, int i, ShakeView.ShakeListener shakeListener) {
        ShakeView shakeView;
        if (view == null || (shakeView = (ShakeView) view.findViewById(R.id.yd_shake_view)) == null) {
            return;
        }
        shakeView.setCallback(z);
        shakeView.setShakeListener(i, new GnQT2j.A4TApA(2, shakeListener, type, view));
    }

    public void onAdClickedCallBackEvent(String str) {
        LogcatUtil.d(this.TAG, "onAdClickedCallBackEvent");
        getReportEventListener().ifPresent(new KiXkPs.A2egSU(24));
        NativeClickCallbackListener nativeClickCallbackListener = this.mClickCallBackListener;
        if (nativeClickCallbackListener != null) {
            nativeClickCallbackListener.onAdClicked(str);
        }
    }

    public void onAdClickedEvent() {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().ifPresent(new KiXkPs.A2egSU(24));
        getEventListener().ifPresent(new A4TApA(this, 0));
    }

    public void onAdCloseEvent() {
        LogcatUtil.d(this.TAG, "onAdCloseEvent");
        this.mCycleNativeAd = null;
        this.mCycleNativeTime = 0;
        stopRefresh();
        stopCycle();
        getEventListener().ifPresent(new A4TApA(this, 3));
    }

    public void onAdFailedEvent(YdError ydError) {
        LogcatUtil.d(this.TAG, "onAdFailed:" + ydError);
        getEventListener().ifPresent(new A2egSU(this, 1, ydError));
    }

    public void onAdImpressedEvent() {
        LogcatUtil.d(this.TAG, "onAdImpressedEvent");
        checkDataUpdate();
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        getReportEventListener().ifPresent(new KiXkPs.A2egSU(23));
        getEventListener().ifPresent(new A4TApA(this, 1));
    }

    public void onAdVideoEndEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoEndEvent");
        getEventListener().ifPresent(new A4TApA(this, 5));
    }

    public void onAdVideoProgress(long j) {
        LogcatUtil.d(this.TAG, "onAdVideoProgress");
        getEventListener().ifPresent(new ARc23Z(1, j, this));
    }

    public void onAdVideoStartEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoStartEvent");
        getEventListener().ifPresent(new A4TApA(this, 2));
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onDetachedVideo() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onPause() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onResume() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void prepare(NativePrepareInfo nativePrepareInfo) {
        this.isShowOriginalView = true;
        if (this.mNativeAdView == null) {
            onAdFailedEvent(YdError.create(ErrorCodeConstant.RENDER_ERROR, "Please execute the renderAdContainer() method first."));
            return;
        }
        if (nativePrepareInfo == null || nativePrepareInfo.getActivity() == null) {
            onAdFailedEvent(YdError.create(ErrorCodeConstant.CONTEXT_ERROR, "prepareInfo or activity is null Please setActivity."));
            return;
        }
        this.showActivityRef = new WeakReference<>(nativePrepareInfo.getActivity());
        getReportEventListener().ifPresent(new KiXkPs.A2egSU(22));
        getNativeAdOpt().ifPresent(new A2egSU(this, 0, nativePrepareInfo));
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void release() {
        MixNativeManager.OnNativeReleaseListener onNativeReleaseListener = this.onNativeReleaseListener;
        if (onNativeReleaseListener != null) {
            onNativeReleaseListener.release();
        }
    }

    /* renamed from: render, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$prepare$0(T t, NativePrepareInfo nativePrepareInfo);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void renderAdContainer(NativeAdView nativeAdView, View view) {
        this.mNativeAdView = nativeAdView;
        this.selfRenderView = view;
    }

    public void setAdInfoMapper(AdInfoMapper adInfoMapper) {
        this.mAdInfoMapper = adInfoMapper;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setCanRefresh(boolean z) {
        this.mCanRefresh = z;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setClickCallBackListener(NativeClickCallbackListener nativeClickCallbackListener) {
        this.mClickCallBackListener = nativeClickCallbackListener;
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public void setCycleNativeAd(List<NativeAd> list, int i) {
        if (list == null || list.isEmpty() || i <= 0) {
            return;
        }
        this.mCycleNativeAd = list.get(0);
        this.mCycleNativeTime = i;
    }

    public void setEcpmMapper(EcpmMapper ecpmMapper) {
        this.mEcpmMapper = ecpmMapper;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setNativeAdParams(AdParams adParams) {
        this.requestParams = adParams;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.mEventListener = nativeEventListener;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setOnNativeReleaseListener(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener) {
        this.onNativeReleaseListener = onNativeReleaseListener;
    }

    public void setReportEventListener(ReportEventListener reportEventListener) {
        this.mReportEventListener = reportEventListener;
    }

    public void setWinAdInfoMapper(WinAdInfoMapper winAdInfoMapper) {
        this.mWinAdInfoMapper = winAdInfoMapper;
    }

    public BaseNativeAd(Context context, T t) {
        this.mNativeAd = t;
        this.mContext = context;
        init(t);
    }

    public void onAdClickedEvent(int i) {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().ifPresent(new KiXkPs.A2egSU(24));
        if (i == 1) {
            getEventListener().ifPresent(new A4TApA(this, 4));
        }
    }
}
