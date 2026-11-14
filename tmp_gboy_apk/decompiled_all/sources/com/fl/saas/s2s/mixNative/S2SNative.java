package com.fl.saas.s2s.mixNative;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.api.mixNative.NativeCustomizeVideo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.bean.MediaReturnMaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.widget.NativeSlidingView;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.common.listener.DeepLinkOpenListener;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeepLinkJumpUtil;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.json.Yson;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import com.fl.saas.s2s.sdk.helper.CommJumpHelper;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.saas.s2s.sdk.util.AdConfigUtil;
import com.fl.saas.s2s.sdk.util.S2SVideoPlayListener;
import com.fl.saas.s2s.sdk.util.S2SVideoView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SNative extends BaseNativeAd<AdInfoPoJo> implements BiddingResult, ActionView, AdChangeCacheData, DeepLinkOpenListener {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SNative.class);
    private List<View> clickViews;
    private boolean isReportExposure;
    private final AdSource mAdSource;
    private final CacheListener mCacheListener;
    private ActionView.Type mType;
    private S2SVideoView mediaView;
    private View tempActionView;
    private boolean touchClick;

    static {
        hFiU();
    }

    public S2SNative(Context context, AdInfoPoJo adInfoPoJo, AdSource adSource, CacheListener cacheListener) {
        super(context, adInfoPoJo);
        this.isReportExposure = false;
        this.mAdSource = adSource;
        this.mCacheListener = cacheListener;
        createMediaView(adInfoPoJo);
    }

    private void adViewClickDispose(Activity activity, AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        if (activity == null || activity.isFinishing()) {
            activity = DeviceUtil.getTopActivity();
        }
        View view = this.tempActionView;
        if (view != null) {
            ViewHelper.removeParent(view);
            this.tempActionView = null;
        }
        DeepLinkJumpUtil.getInstance().setDeepLinkOpenListener(this);
        adInfoPoJo.clickIsDp = "2";
        checkAdShowEvent();
        int clickType = AdConfigUtil.getClickType(activity, adInfoPoJo);
        adInfoPoJo.type = clickType;
        CommReportHelper.getInstance().reportClick(adInfoPoJo);
        AdInfoPoJo.Creative creative = adInfoPoJo.creative;
        if (creative != null && !TextUtils.isEmpty(creative.cid)) {
            this.mAdSource.creative_id = adInfoPoJo.creative.cid;
        }
        if (TextUtils.isEmpty(adInfoPoJo.click_url) || !adInfoPoJo.click_url.startsWith("ECHARGINGCUSTOM")) {
            CommJumpHelper.getInstance().jump(activity, adInfoPoJo);
            onAdClickedEvent(clickType);
        } else {
            onAdClickedCallBackEvent(adInfoPoJo.click_url.replace("ECHARGINGCUSTOM", ""));
        }
        adInfoPoJo.clickType = AdInfoPoJo.ClickType.NORMAL;
        adInfoPoJo.down_x = -999;
        adInfoPoJo.down_y = -999;
        adInfoPoJo.abs_down_x = -999;
        adInfoPoJo.abs_down_y = -999;
        adInfoPoJo.up_x = -999;
        adInfoPoJo.up_y = -999;
        adInfoPoJo.abs_up_x = -999;
        adInfoPoJo.abs_up_y = -999;
        adInfoPoJo.shake_x = -999;
        adInfoPoJo.shake_y = -999;
        adInfoPoJo.shake_z = -999;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void bindClickViews(Activity activity, AdInfoPoJo adInfoPoJo, List<View> list) {
        if (this.clickViews == null) {
            this.clickViews = new ArrayList();
        }
        LogcatUtil.d(TAG, "bindClickViews" + this.clickViews.size() + activity);
        for (View view : this.clickViews) {
            view.setClickable(true);
            view.setEnabled(true);
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.fl.saas.s2s.mixNative.ASJ6gh
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean lambda$bindClickViews$4;
                    lambda$bindClickViews$4 = S2SNative.this.lambda$bindClickViews$4(view2, motionEvent);
                    return lambda$bindClickViews$4;
                }
            });
            ViewHelper.onSingleClickListener(view, new ADYaiT(this, list, activity, 1));
        }
    }

    private void bindMediaViewClick(Activity activity, AdInfoPoJo adInfoPoJo) {
        S2SVideoView s2SVideoView = this.mediaView;
        if (s2SVideoView == null) {
            return;
        }
        s2SVideoView.setOnClickListener(new ADYaiT(this, adInfoPoJo, activity, 0));
    }

    private void bindNativeView() {
        if (this.isReportExposure) {
            return;
        }
        final int i = 0;
        getNativeAdView().setOnVisibilityChanged(new Consumer(this) { // from class: com.fl.saas.s2s.mixNative.ARc23Z

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ S2SNative f10854A4TApA;

            {
                this.f10854A4TApA = this;
            }

            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f10854A4TApA.lambda$bindNativeView$2((Boolean) obj);
                        break;
                    default:
                        this.f10854A4TApA.lambda$bindNativeView$3((Integer) obj);
                        break;
                }
            }
        });
        final int i2 = 1;
        getNativeAdView().setVisibilityRatioChanged(new Consumer(this) { // from class: com.fl.saas.s2s.mixNative.ARc23Z

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ S2SNative f10854A4TApA;

            {
                this.f10854A4TApA = this;
            }

            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.f10854A4TApA.lambda$bindNativeView$2((Boolean) obj);
                        break;
                    default:
                        this.f10854A4TApA.lambda$bindNativeView$3((Integer) obj);
                        break;
                }
            }
        });
    }

    private void checkAdShowEvent() {
        if (this.isReportExposure) {
            return;
        }
        getNativeAdView().unOnVisibilityChanged();
        this.isReportExposure = true;
        onAdImpressedEvent();
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.showTime = System.currentTimeMillis();
            nativeAd.realWidth = getNativeAdView().getWidth();
            nativeAd.realHeight = getNativeAdView().getHeight();
            CommReportHelper.getInstance().reportDisplay(nativeAd, this.mCacheListener.isCache());
            AdInfoPoJo.Creative creative = nativeAd.creative;
            if (creative == null || TextUtils.isEmpty(creative.cid)) {
                return;
            }
            this.mAdSource.creative_id = nativeAd.creative.cid;
        }
    }

    private void createMediaView(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null || this.mediaView != null || TextUtils.isEmpty(adInfoPoJo.video_url) || adInfoPoJo.creative.ctype != 2) {
            return;
        }
        S2SVideoView s2SVideoView = new S2SVideoView(getContext());
        this.mediaView = s2SVideoView;
        s2SVideoView.setVideo(adInfoPoJo);
        this.mediaView.setVideoPlayListener(new S2SVideoPlayListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.2
            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayComplete() {
                S2SNative.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayStart() {
                S2SNative.this.onAdVideoStartEvent();
            }
        });
    }

    private NativeSlidingView getFingerSlidingView(final AdInfoPoJo adInfoPoJo) {
        final NativeSlidingView nativeSlidingView = new NativeSlidingView(getContext());
        nativeSlidingView.setSlidingListener(new NativeSlidingView.SlidingListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.1
            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onDown(int i, int i2) {
                AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                if (adInfoPoJo2 == null) {
                    return;
                }
                adInfoPoJo2.down_x = i;
                adInfoPoJo2.down_y = i2;
                int[] iArr = new int[2];
                nativeSlidingView.getLocationOnScreen(iArr);
                AdInfoPoJo adInfoPoJo3 = adInfoPoJo;
                adInfoPoJo3.abs_down_x = adInfoPoJo3.down_x + iArr[0];
                adInfoPoJo3.abs_down_y = adInfoPoJo3.down_y + iArr[1];
                adInfoPoJo3.DOWN_TIME = System.currentTimeMillis();
            }

            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onSliding() {
                if (S2SNative.this.clickViews != null && !S2SNative.this.clickViews.isEmpty()) {
                    Iterator it = S2SNative.this.clickViews.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View view = (View) it.next();
                        if (!(view instanceof RainTextureView)) {
                            adInfoPoJo.clickType = AdInfoPoJo.ClickType.SLIDE;
                            view.performClick();
                            break;
                        }
                    }
                }
                ViewHelper.removeParent(nativeSlidingView);
            }

            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onUp(int i, int i2) {
                AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                if (adInfoPoJo2 == null) {
                    return;
                }
                adInfoPoJo2.up_x = i;
                adInfoPoJo2.up_y = i2;
                int[] iArr = new int[2];
                nativeSlidingView.getLocationOnScreen(iArr);
                AdInfoPoJo adInfoPoJo3 = adInfoPoJo;
                adInfoPoJo3.abs_up_x = adInfoPoJo3.up_x + iArr[0];
                adInfoPoJo3.abs_up_y = adInfoPoJo3.up_y + iArr[1];
                adInfoPoJo3.UP_TIME = System.currentTimeMillis();
            }
        });
        nativeSlidingView.createView(adInfoPoJo.display_mask == 1);
        return nativeSlidingView;
    }

    private static /* synthetic */ void hFiU() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void handleInclineView(View view, ActionView.Type type, AdInfoPoJo adInfoPoJo) {
        listenInclineView(view, false, type, adInfoPoJo.getShakeSpeed(), new A5SV6n(this, adInfoPoJo, type, view));
    }

    private void handleSharkView(View view, ActionView.Type type, AdInfoPoJo adInfoPoJo) {
        listenShakeView(view, false, type, adInfoPoJo.getShakeSpeed(), new A5SV6n(this, adInfoPoJo, type, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$biddingResult$7(boolean z, int i, AdInfoPoJo adInfoPoJo) {
        if (!z) {
            if (i > 0) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidFail(adInfoPoJo);
        } else {
            if (i > 0 && i <= adInfoPoJo.price) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidSuccess(adInfoPoJo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$bindClickViews$4(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            LogcatUtil.d(TAG, "ACTION_DOWN");
            AdInfoPoJo nativeAd = getNativeAd();
            if (nativeAd != null) {
                nativeAd.down_x = (int) motionEvent.getX();
                nativeAd.down_y = (int) motionEvent.getY();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                nativeAd.abs_down_x = nativeAd.down_x + iArr[0];
                nativeAd.abs_down_y = nativeAd.down_y + iArr[1];
                nativeAd.DOWN_TIME = System.currentTimeMillis();
            }
        }
        if (motionEvent.getAction() == 1) {
            LogcatUtil.d(TAG, "ACTION_UP");
            AdInfoPoJo nativeAd2 = getNativeAd();
            if (nativeAd2 != null) {
                nativeAd2.up_x = (int) motionEvent.getX();
                nativeAd2.up_y = (int) motionEvent.getY();
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                nativeAd2.abs_up_x = nativeAd2.up_x + iArr2[0];
                nativeAd2.abs_up_y = nativeAd2.up_y + iArr2[1];
                nativeAd2.UP_TIME = System.currentTimeMillis();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindClickViews$5(List list, Activity activity, View view) {
        LogcatUtil.d(TAG, "viewClick");
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.clickArea = "1";
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((View) it.next()) == view) {
                        nativeAd.clickArea = "2";
                        break;
                    }
                }
            }
        }
        adViewClickDispose(activity, nativeAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindMediaViewClick$6(AdInfoPoJo adInfoPoJo, Activity activity, View view) {
        adInfoPoJo.clickArea = "1";
        adInfoPoJo.PROGRESS = this.mediaView.getProgress();
        adInfoPoJo.PROGRESS_SEC = this.mediaView.getProgress() / 1000;
        adViewClickDispose(activity, adInfoPoJo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindNativeView$2(Boolean bool) {
        if (bool.booleanValue()) {
            checkAdShowEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindNativeView$3(Integer num) {
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null || num == null) {
            return;
        }
        nativeAd.maxShowRatio = num.intValue();
        if (num.intValue() >= 100) {
            getNativeAdView().unOnVisibilityRatioChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleInclineView$9(AdInfoPoJo adInfoPoJo, ActionView.Type type, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            Iterator<View> it = this.clickViews.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View next = it.next();
                if (!(next instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    next.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSharkView$8(AdInfoPoJo adInfoPoJo, ActionView.Type type, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            Iterator<View> it = this.clickViews.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View next = it.next();
                if (!(next instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    next.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$0(AdInfoPoJo adInfoPoJo, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            Iterator<View> it = this.clickViews.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View next = it.next();
                if (!(next instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    next.performClick();
                    break;
                }
            }
        }
        ViewHelper.removeParent(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$1(View view) {
        LogcatUtil.d(TAG, "onAdClose");
        onAdCloseEvent();
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, int i2, int i3) {
        getNativeAdOpt().ifPresent(new Consumer() { // from class: com.fl.saas.s2s.mixNative.AYUAbz
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                S2SNative.lambda$biddingResult$7(z, i, (AdInfoPoJo) obj);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
    
        if (r3 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0151, code lost:
    
        handleSharkView(r3, r20, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014f, code lost:
    
        if (r3 == null) goto L86;
     */
    @Override // com.fl.saas.base.innterNative.ActionView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View bindActionView(com.fl.saas.base.innterNative.ActionView.Type r20) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.mixNative.S2SNative.bindActionView(com.fl.saas.base.innterNative.ActionView$Type):android.view.View");
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(AdInfoPoJo adInfoPoJo) {
        return S2SMixNativeHandler.adInfoToNativeMaterial(adInfoPoJo, this.mediaView);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        S2SVideoView s2SVideoView = this.mediaView;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
        CommJumpHelper.getInstance().dismissDownLoadDialog();
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public NativeCustomizeVideo getCustomizeVideo() {
        final AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null || TextUtils.isEmpty(nativeAd.video_url) || nativeAd.creative.ctype != 2) {
            return null;
        }
        return new NativeCustomizeVideo() { // from class: com.fl.saas.s2s.mixNative.S2SNative.5
            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public String getVideoUrl() {
                return nativeAd.video_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoAutoStart() {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoBreak(long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoContinue(long j) {
                CommReportHelper.getInstance().reportVideoContinue(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoError(long j, int i, int i2) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoFinish() {
                CommReportHelper.getInstance().reportVideoEnd(nativeAd, 0);
                S2SNative.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoFirst() {
                CommReportHelper.getInstance().reportVideoFirst(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoPause(long j) {
                CommReportHelper.getInstance().reportVideoPause(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoStart() {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoStartError(int i, int i2) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoThird() {
                CommReportHelper.getInstance().reportVideoThird(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideomMidpoint() {
                CommReportHelper.getInstance().reportVideomMidpoint(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoStart(long j) {
                int i = (int) (j / 1000);
                nativeAd.VIDEO_TIME = i;
                CommReportHelper.getInstance().reportVideoStart(nativeAd, i);
                S2SNative.this.onAdVideoStartEvent();
            }
        };
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        if (getNativeAd() == null) {
            return "";
        }
        AdInfoPoJo nativeAd = getNativeAd();
        MediaReturnMaterialBean mediaReturnMaterialBean = new MediaReturnMaterialBean();
        mediaReturnMaterialBean.setImageUrl(nativeAd.img_url);
        mediaReturnMaterialBean.setVideoUrl(nativeAd.video_url);
        mediaReturnMaterialBean.setWidth(nativeAd.width);
        mediaReturnMaterialBean.setHeight(nativeAd.height);
        mediaReturnMaterialBean.setIcon(nativeAd.logo_icon);
        mediaReturnMaterialBean.setTitle(nativeAd.title);
        mediaReturnMaterialBean.setDesc(nativeAd.description);
        mediaReturnMaterialBean.setDeeplinkUrl(nativeAd.deep_url);
        mediaReturnMaterialBean.setLandingPageUrl(nativeAd.click_url);
        mediaReturnMaterialBean.setDownloadUrl(nativeAd.download_url);
        return new Yson().toJson(mediaReturnMaterialBean);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void init(AdInfoPoJo adInfoPoJo) {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public boolean isShakeType() {
        AdSource adSource = this.mAdSource;
        return adSource != null && adSource.needShowShakeTips() && this.mType == null && DeviceUtil.deviceHasAccelerometerSensor;
    }

    @Override // com.fl.saas.common.listener.DeepLinkOpenListener
    public void onDeepLinkOpenFailed(Activity activity) {
        try {
            AdInfoPoJo nativeAd = getNativeAd();
            if (nativeAd == null || TextUtils.isEmpty(nativeAd.click_url)) {
                return;
            }
            nativeAd.dp_result = 1;
            nativeAd.dp_reason = 1;
            CommReportHelper.getInstance().reportDeepLinkFail(nativeAd);
            YdH5Activity.launchWithEnableQuickApp(activity, CommReportHelper.getInstance().gdtReplac(nativeAd.click_url, nativeAd), QuickAppHelper.getInstance().enableQuickApp(nativeAd.place_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void lambda$prepare$0(AdInfoPoJo adInfoPoJo, NativePrepareInfo nativePrepareInfo) {
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null) {
            onAdFailedEvent(YdError.create(ErrorCodeConstant.AD_DATA_ERROR, "S2SMixNative render but AdInfoPoJo is null"));
            return;
        }
        this.clickViews = nativePrepareInfo.getAllClickViews();
        AdSource adSource = this.mAdSource;
        if (adSource != null && adSource.needShowShakeTips() && this.mType == null && DeviceUtil.deviceHasAccelerometerSensor) {
            View shakeTipsView = getShakeTipsView();
            if (this.clickViews == null) {
                this.clickViews = new ArrayList();
            }
            this.clickViews.add(shakeTipsView);
            ShakeView shakeView = (ShakeView) shakeTipsView.findViewById(R.id.yd_shake_view);
            shakeView.setCallback(false);
            shakeView.setShakeListener(nativeAd.getShakeSpeed(), new GnQT2j.A4TApA(6, this, nativeAd, shakeTipsView));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            if (nativePrepareInfo.isSelfRenderShake()) {
                layoutParams.width = 1;
                layoutParams.height = 1;
            }
            getNativeAdView().addView(shakeTipsView, layoutParams);
        }
        AdSource adSource2 = this.mAdSource;
        if (adSource2 != null && adSource2.isLayerSlide() && this.mType == null) {
            getNativeAdView().addView(getFingerSlidingView(nativeAd), ViewHelper.getMatchParent());
        }
        bindNativeView();
        if (nativePrepareInfo.getCloseView() != null) {
            nativePrepareInfo.getCloseView().setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.s2s.mixNative.AMqCpz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S2SNative.this.lambda$render$1(view);
                }
            });
        }
        bindMediaViewClick(nativePrepareInfo.getActivity(), nativeAd);
        bindClickViews(nativePrepareInfo.getActivity(), nativeAd, nativePrepareInfo.getCtaViewList());
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        if (getNativeAd() != null) {
            getNativeAd().trackId = str;
            getNativeAd().place_id = adSource.place_id;
            getNativeAd().global_group_id = adSource.group_id;
            getNativeAd().global_place_id = adSource.place_id;
            getNativeAd().global_test_id = adSource.test_id;
        }
    }
}
