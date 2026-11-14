package com.fl.saas.base.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.widget.CountDownProgressView;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewInterstitialAdapter extends BuilderLoadAdapter<InnerInterstitialBuilder<?>, AdViewInterstitialListener> {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f10729A2egSU = 0;
    private static final String TAG = CommConstant.getClassTag(AdViewInterstitialAdapter.class);
    private WeakReference<Activity> activityRef;
    private boolean canCallback = true;
    private boolean canCallbackClose = true;
    private CountDownProgressView countDownTextView;
    private boolean hasCloseInterstitialAd;
    private boolean hasReturnCloseEvent;
    private boolean haveShowCloseView;
    private boolean isIntersReady;
    private String showActivityName;
    private long showTime;
    private WeakReference<Activity> topActivityRef;

    static {
        SBMxaRq();
    }

    private static /* synthetic */ void SBMxaRq() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInterstitialListener() {
        try {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                if (countDownProgressView.getVisibilityState() == 0) {
                    closeInterstitialAd(this.topActivityRef.get());
                } else {
                    this.countDownTextView.setOnVisibilityChanged(new AMqCpz(this, 0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeView() {
        WeakReference<Activity> weakReference;
        if (this.showTime <= 0 || System.currentTimeMillis() - this.showTime < 500 || (weakReference = this.topActivityRef) == null) {
            return;
        }
        try {
            Activity activity = weakReference.get();
            String str = TAG;
            LogcatUtil.d(str, "removeViewActivity:" + activity);
            if (this.countDownTextView != null && activity != null && !activity.isFinishing()) {
                activity.getWindowManager().removeViewImmediate(this.countDownTextView);
            }
            if (selfCloseInterstitialAd()) {
                return;
            }
            String topActivityName = getTopActivityName();
            LogcatUtil.d(str, "removeViewTopActivityName:" + topActivityName);
            LogcatUtil.d(str, "removeViewShowActivityName:" + this.showActivityName);
            if (compareActivity(topActivityName, this.showActivityName)) {
                View topView = ViewHelper.getTopView();
                if (topView != null && activity != null && !activity.isFinishing()) {
                    activity.getWindowManager().removeView(topView);
                }
            } else {
                Activity topActivity = DeviceUtil.getTopActivity();
                if (topActivity != null) {
                    activity = topActivity;
                }
                if (activity != null && !this.showActivityName.equals(activity.getComponentName().getClassName()) && !activity.isFinishing()) {
                    activity.finish();
                }
            }
            onClosedEvent();
            this.countDownTextView = null;
            this.topActivityRef = null;
            this.activityRef = null;
        } catch (Throwable th) {
            th.printStackTrace();
            this.countDownTextView = null;
            this.topActivityRef = null;
            this.activityRef = null;
        }
    }

    private boolean compareActivity(String str, String str2) {
        WeakReference<Activity> weakReference;
        if ((this.showActivityName != null && (weakReference = this.topActivityRef) != null && weakReference.get() != null && this.showActivityName.equals(this.topActivityRef.get().getComponentName().getClassName())) || str == null || str2 == null || str.equals(str2)) {
            return true;
        }
        return str.substring(str.lastIndexOf(46) + 1).equals(str2.substring(str2.lastIndexOf(46) + 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        r0 = ((android.app.ActivityManager) r2.activityRef.get().getSystemService(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).topActivity;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getTopActivityName() {
        /*
            r2 = this;
            java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activityRef     // Catch: java.lang.Exception -> L37
            if (r0 == 0) goto L3b
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L37
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L37
            boolean r0 = r0.isFinishing()     // Catch: java.lang.Exception -> L37
            if (r0 != 0) goto L3b
            java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activityRef     // Catch: java.lang.Exception -> L37
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L37
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L37
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Exception -> L37
            r1 = 1
            java.util.List r0 = r0.getRunningTasks(r1)     // Catch: java.lang.Exception -> L37
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L37
            android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0     // Catch: java.lang.Exception -> L37
            android.content.ComponentName r0 = DaOi9o.COJEAR.A5SV6n(r0)     // Catch: java.lang.Exception -> L37
            if (r0 == 0) goto L3b
            java.lang.String r0 = r0.getClassName()     // Catch: java.lang.Exception -> L37
            return r0
        L37:
            r0 = move-exception
            r0.printStackTrace()
        L3b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.adapter.AdViewInterstitialAdapter.getTopActivityName():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeInterstitialListener$10(Integer num) {
        if (num.intValue() == 0) {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                countDownProgressView.unOnVisibilityChanged();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new A5SV6n(this, 5), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeInterstitialListener$9() {
        closeInterstitialAd(this.topActivityRef.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShowEvent$4() {
        if (this.hasCloseInterstitialAd) {
            return;
        }
        setTopActivityRef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$showAutoCloseView$5(Integer num) {
        return "点击关闭广告  " + num + "S";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoCloseView$6(View view) {
        closeInterstitialListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$showAutoCloseView$7(Integer num) {
        return num + "S后自动关闭";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoCloseView$8(View view) {
        closeInterstitialListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showInterstitialAd$0(Activity activity) {
        return !activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$1() {
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null && weakReference.get() != null && !this.activityRef.get().isFinishing()) {
            showInterstitial(this.activityRef.get());
        } else if (requiresActivityDetection()) {
            onAdFailed(YdError.create(ErrorCodeConstant.CONTEXT_ERROR, "request show but Activity is null or invalid"));
        } else {
            showInterstitial(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$2(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        try {
            this.showActivityName = activity.getComponentName().getClassName();
            LogcatUtil.d(TAG, "showActivityName:" + this.showActivityName);
            DeviceUtil.postUIDelayed(50L, new A5SV6n(this, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$3() {
        if (requiresActivityDetection()) {
            onAdFailed(YdError.create(ErrorCodeConstant.CONTEXT_ERROR, "request show but Activity is null or invalid"));
        } else {
            showInterstitial(null);
        }
    }

    private void setTopActivityRef(boolean z) {
        WeakReference<Activity> weakReference;
        Activity topActivity = DeviceUtil.getTopActivity();
        if (topActivity == null && (weakReference = this.activityRef) != null) {
            topActivity = weakReference.get();
        }
        if (topActivity != null) {
            this.topActivityRef = new WeakReference<>(topActivity);
            LogcatUtil.d(TAG, "addAutoCloseViewTopActivity:" + topActivity);
            if (z) {
                showAutoCloseView(topActivity);
            }
        }
    }

    public void checkReRequest(Activity activity) {
        if (activity == null) {
            return;
        }
        if (changeReRequestCount()) {
            reRequest();
            closeInterstitialAd(activity);
        } else if (getAdSource().isAutoClose()) {
            closeInterstitialAd(activity);
        }
    }

    public void closeInterstitialAd(Activity activity) {
        if (activity == null || this.hasCloseInterstitialAd) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            closeView();
        } else {
            new Handler(Looper.getMainLooper()).post(new A5SV6n(this, 2));
        }
    }

    public void closeTopCountDownView() {
        this.hasCloseInterstitialAd = true;
        LogcatUtil.d(TAG, "closeTopCountDownView");
        try {
            WeakReference<Activity> weakReference = this.topActivityRef;
            if (weakReference != null) {
                Activity activity = weakReference.get();
                if (this.countDownTextView != null && activity != null && !activity.isFinishing()) {
                    activity.getWindowManager().removeView(this.countDownTextView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.countDownTextView = null;
        this.topActivityRef = null;
        this.activityRef = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        this.activityRef = null;
        this.topActivityRef = null;
        this.countDownTextView = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public final boolean isIntersReady() {
        return this.isIntersReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        this.haveShowCloseView = true;
        if (this.canCallback) {
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewVideoListener) {
                AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
                adViewVideoListener.onAdClick("");
                if (getAdSource().reward_callback_option == 2) {
                    adViewVideoListener.onVideoReward(getAdSource().getECPM());
                }
            } else if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdClick("");
            }
        }
        AdapterAPI interstitialAdapter = AdCacheManager.getInstance().getInterstitialAdapter();
        if (interstitialAdapter instanceof AdViewInterstitialAdapter) {
            try {
                this.canCallback = false;
                this.canCallbackClose = false;
                if (!selfCloseInterstitialAd()) {
                    this.canCallback = true;
                    this.canCallbackClose = true;
                    return;
                }
                if (interstitialAdapter instanceof BiddingResult) {
                    ((BiddingResult) interstitialAdapter).biddingResult(true, interstitialAdapter.getAdSource().getPrice(), 0, 0);
                }
                ((AdViewInterstitialAdapter) interstitialAdapter).setCanCallBack(false);
                ((AdViewInterstitialAdapter) interstitialAdapter).setCanCallBackClose(true);
                ((AdViewInterstitialAdapter) interstitialAdapter).showInterstitialAd(getActivityOrNull());
                AdCacheManager.getInstance().clearInterstitialAdapter(false);
            } catch (Exception e) {
                this.canCallback = true;
                this.canCallbackClose = true;
                e.printStackTrace();
            }
        }
    }

    public void onClosedEvent() {
        this.hasCloseInterstitialAd = true;
        if (this.hasReturnCloseEvent) {
            return;
        }
        this.hasReturnCloseEvent = true;
        closeTopCountDownView();
        if (this.canCallbackClose) {
            AdCacheManager.getInstance().clearInterstitialAdapter(true);
            AdViewListener eventListener = getEventListener();
            if (!(eventListener instanceof AdViewVideoListener)) {
                if (eventListener instanceof AdViewInterstitialListener) {
                    ((AdViewInterstitialListener) eventListener).onAdClosed();
                }
            } else {
                AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
                adViewVideoListener.onAdClose();
                if (getAdSource().reward_callback_option == 1) {
                    adViewVideoListener.onVideoReward(getAdSource().getECPM());
                }
            }
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isIntersReady = true;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.showTime = System.currentTimeMillis();
        this.isIntersReady = false;
        super.onShowEvent();
        if (this.canCallback) {
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewVideoListener) {
                ((AdViewVideoListener) eventListener).onAdShow();
            } else if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdDisplay();
            }
        }
        setTopActivityRef(false);
        new Handler(Looper.getMainLooper()).postDelayed(new A5SV6n(this, 1), 500L);
    }

    public boolean requiresActivityDetection() {
        return true;
    }

    public boolean selfCloseInterstitialAd() {
        return false;
    }

    public void setCanCallBack(boolean z) {
        this.canCallback = z;
    }

    public void setCanCallBackClose(boolean z) {
        this.canCallbackClose = z;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (isReRequest()) {
            showInterstitialAd(null);
            return;
        }
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoPrepared();
        } else if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdReady();
        }
    }

    public void showAutoCloseView(Activity activity) {
        COJEAR.AZOQYO azoqyo;
        if (activity == null || this.haveShowCloseView) {
            return;
        }
        int i = 1;
        this.haveShowCloseView = true;
        int closeCountdown = getAdSource().getCloseCountdown();
        boolean z = closeCountdown > 0;
        boolean isUnifiedCloseButtonShow = getAdSource().isUnifiedCloseButtonShow();
        if (z || isUnifiedCloseButtonShow) {
            CountDownProgressView countDownProgressView = new CountDownProgressView(activity);
            this.countDownTextView = countDownProgressView;
            countDownProgressView.setCount(closeCountdown);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(DeviceUtil.dip2px(20.0f));
            gradientDrawable.setColor(Color.parseColor("#60000000"));
            gradientDrawable.setStroke(DeviceUtil.dip2px(2.0f), Color.parseColor("#D9D9D9"));
            this.countDownTextView.setBackground(gradientDrawable);
            this.countDownTextView.setElevation(20.0f);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 8;
            layoutParams.format = 1;
            if (!z || isUnifiedCloseButtonShow || getAdSource().isDisplayCountDown()) {
                layoutParams.width = DeviceUtil.dip2px(160.0f);
                i = DeviceUtil.dip2px(32.0f);
            } else {
                layoutParams.width = 1;
            }
            layoutParams.height = i;
            layoutParams.gravity = 81;
            layoutParams.y = DeviceUtil.dip2px(80.0f);
            activity.getWindowManager().addView(this.countDownTextView, layoutParams);
            CountDownProgressView countDownProgressView2 = this.countDownTextView;
            if (!z) {
                countDownProgressView2.setText("    点击关闭广告    ");
                final int i2 = 0;
                this.countDownTextView.setOnClickListener(new View.OnClickListener(this) { // from class: com.fl.saas.base.adapter.ADYaiT

                    /* renamed from: AlLFFp, reason: collision with root package name */
                    public final /* synthetic */ AdViewInterstitialAdapter f10718AlLFFp;

                    {
                        this.f10718AlLFFp = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                this.f10718AlLFFp.lambda$showAutoCloseView$8(view);
                                break;
                            default:
                                this.f10718AlLFFp.lambda$showAutoCloseView$6(view);
                                break;
                        }
                    }
                });
                return;
            }
            if (isUnifiedCloseButtonShow) {
                azoqyo = new COJEAR.AZOQYO(26);
                countDownProgressView2.setOnTick(azoqyo);
                final int i3 = 1;
                this.countDownTextView.setOnClickListener(new View.OnClickListener(this) { // from class: com.fl.saas.base.adapter.ADYaiT

                    /* renamed from: AlLFFp, reason: collision with root package name */
                    public final /* synthetic */ AdViewInterstitialAdapter f10718AlLFFp;

                    {
                        this.f10718AlLFFp = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i3) {
                            case 0:
                                this.f10718AlLFFp.lambda$showAutoCloseView$8(view);
                                break;
                            default:
                                this.f10718AlLFFp.lambda$showAutoCloseView$6(view);
                                break;
                        }
                    }
                });
            } else {
                azoqyo = new COJEAR.AZOQYO(27);
                countDownProgressView2.setOnTick(azoqyo);
            }
            this.countDownTextView.setFinish(new A5SV6n(this, 0));
            this.countDownTextView.start();
        }
    }

    public abstract void showInterstitial(Activity activity);

    public final void showInterstitialAd(Activity activity) {
        int intValue = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(24)).orElse(0)).intValue();
        if (intValue > 0 && getAdSource().getCloseCountdown() == 0) {
            getAdSource().setCloseCountdown(intValue);
            getAdSource().cp_display_countdown = 1;
        }
        this.isIntersReady = false;
        reportRequestShow();
        Optional.ofNullable(activity).filter(new COJEAR.AZOQYO(25)).or(new ARc23Z(this)).ifPresentOrElse(new AMqCpz(this, 1), new A5SV6n(this, 3));
    }
}
