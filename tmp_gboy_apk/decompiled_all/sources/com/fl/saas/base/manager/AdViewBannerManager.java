package com.fl.saas.base.manager;

import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.inner.banner.InnerNativeBannerAdapter;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewBannerManager extends BuilderLoadManager<InnerBannerBuilder<?>, AdViewBannerAdapter, AdViewBannerListener> {
    private Timer mTimer;

    public AdViewBannerManager() {
        super(AdType.Banner);
    }

    private void cancelRefresh() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerAutoRefresh() {
        if (this.mTimer == null) {
            return;
        }
        restManagerLoad(AdType.Banner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefresh() {
        int autoSlideInterval = getBuilder().getAutoSlideInterval();
        if (autoSlideInterval <= 0 || !(getShowAdapter() instanceof InnerNativeBannerAdapter)) {
            return;
        }
        TimerTask timerTask = new TimerTask() { // from class: com.fl.saas.base.manager.AdViewBannerManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AdViewBannerManager.this.innerAutoRefresh();
            }
        };
        cancelRefresh();
        long j = autoSlideInterval * 1000;
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(timerTask, j);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerInfoAPI
    public void destroy() {
        super.destroy();
        getValidAdapter().ifPresent(new KiXkPs.A2egSU(25));
        cancelRefresh();
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewBannerListener initProxyEventListener(InnerBannerBuilder<?> innerBannerBuilder) {
        return new AdViewBannerListener(innerBannerBuilder, innerBannerBuilder.getEventListener()) { // from class: com.fl.saas.base.manager.AdViewBannerManager.1
            private final FrameLayout bannerView;
            private boolean isLoaded = false;
            private final FrameLayout.LayoutParams mParams;
            final /* synthetic */ AdViewBannerListener val$adViewAdInterface;
            final /* synthetic */ InnerBannerBuilder val$builder;

            {
                this.val$builder = innerBannerBuilder;
                this.val$adViewAdInterface = r4;
                FrameLayout frameLayout = new FrameLayout(AdViewBannerManager.this.getContextOpt().get());
                this.bannerView = frameLayout;
                frameLayout.setBackgroundColor(-1);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(innerBannerBuilder.getWidth()), DeviceUtil.dip2px(innerBannerBuilder.getHeight()));
                this.mParams = layoutParams;
                frameLayout.setLayoutParams(layoutParams);
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdClick(str);
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdExposure();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdFailed(ydError);
                if (this.isLoaded) {
                    AdViewBannerManager.this.setRefresh();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onClosed() {
                ViewHelper.removeParent(this.bannerView);
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                this.bannerView.removeAllViews();
                this.bannerView.addView(view, this.mParams);
                if (!this.isLoaded) {
                    this.isLoaded = true;
                    AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                    if (adViewBannerListener == null) {
                        return;
                    } else {
                        adViewBannerListener.onReceived(this.bannerView);
                    }
                }
                AdViewBannerManager.this.setRefresh();
            }
        };
    }
}
