package com.octopus.ad;

import android.content.Context;
import android.view.ViewGroup;
import com.octopus.ad.AdRequest;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.video.VideoStateListener;
import com.octopus.ad.internal.view.SplashAdViewImpl;
import com.octopus.ad.model.ShakeValue;
import com.octopus.ad.utils.ThreadUtils;
import java.util.Collections;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class SplashAd implements AdLifeControl, IBidding {

    /* renamed from: a, reason: collision with root package name */
    private final SplashAdViewImpl f12338a;

    public SplashAd(Context context, String str, ViewGroup viewGroup, SplashAdListener splashAdListener) {
        SplashAdViewImpl splashAdViewImpl = new SplashAdViewImpl(context == null ? q.a().j() : context, viewGroup);
        this.f12338a = splashAdViewImpl;
        splashAdViewImpl.setSplashAdListener(splashAdListener);
        splashAdViewImpl.setAdSlotId(str);
        splashAdViewImpl.a(new AdRequest.Builder().build().a());
    }

    @Override // com.octopus.ad.AdLifeControl
    public void cancel() {
        onDestroyLifeCycle();
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl != null) {
            splashAdViewImpl.cancel();
        }
    }

    @Override // com.octopus.ad.AdLifeControl
    public void destroy() {
        cancel();
    }

    public String getAdSlotId() {
        return this.f12338a.getAdSlotId();
    }

    public Map<String, Object> getMediaExtraInfo() {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        return splashAdViewImpl != null ? splashAdViewImpl.getMediaExtraInfo() : Collections.EMPTY_MAP;
    }

    public int getPrice() {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return 0;
        }
        return splashAdViewImpl.getPrice();
    }

    public String getRequestId() {
        return this.f12338a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl != null) {
            return splashAdViewImpl.getShakeValue();
        }
        return null;
    }

    public String getTagId() {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return null;
        }
        return splashAdViewImpl.getTagId();
    }

    public boolean isLoaded() {
        return this.f12338a.f();
    }

    public boolean isLoading() {
        return this.f12338a.j();
    }

    public boolean isValid() {
        return isLoaded() && this.f12338a.g();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onCreateLifeCycle() {
        this.f12338a.onCreateLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl != null) {
            splashAdViewImpl.onDestroyLifeCycle();
        }
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onPauseLifeCycle() {
        this.f12338a.onPauseLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onRestartLifeCycle() {
        this.f12338a.onRestartLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onResumeLifeCycle() {
        this.f12338a.onResumeLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStartLifeCycle() {
        this.f12338a.onStartLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f12338a.onStopLifeCycle();
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f12338a.c(z);
    }

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return;
        }
        splashAdViewImpl.sendLossNotice(i, str, str2);
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return;
        }
        splashAdViewImpl.sendWinNotice(i);
    }

    public void setAdSlotId(String str) {
        this.f12338a.setAdSlotId(str);
    }

    public void setChannel(String str) {
        this.f12338a.setChannel(str);
    }

    public void setCountDownTime(int i) {
        this.f12338a.setCountDownTime(i);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return;
        }
        splashAdViewImpl.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f12338a.setRequestId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        SplashAdViewImpl splashAdViewImpl = this.f12338a;
        if (splashAdViewImpl == null) {
            return;
        }
        splashAdViewImpl.setVideoStateListener(videoStateListener);
    }

    public void showAd() {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.SplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                if (SplashAd.this.f12338a != null) {
                    SplashAd.this.f12338a.a((ViewGroup) null);
                }
            }
        });
    }

    public void showAd(final ViewGroup viewGroup) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.SplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (SplashAd.this.f12338a == null || viewGroup == null) {
                    return;
                }
                SplashAd.this.f12338a.a(viewGroup);
            }
        });
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }
}
