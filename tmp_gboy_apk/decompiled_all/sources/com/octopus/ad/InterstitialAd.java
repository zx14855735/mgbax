package com.octopus.ad;

import android.app.Activity;
import android.content.Context;
import com.octopus.ad.AdRequest;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.video.VideoStateListener;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.model.ShakeValue;
import java.util.Collections;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class InterstitialAd implements AdLifeControl, IBidding {

    /* renamed from: a, reason: collision with root package name */
    private final InterstitialAdViewImpl f12332a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = new InterstitialAdViewImpl(context == null ? q.a().j() : context, p.INTERSTITIAL, false);
        this.f12332a = interstitialAdViewImpl;
        interstitialAdViewImpl.setAdSlotId(str);
        interstitialAdViewImpl.setInterstitialAdListener(interstitialAdListener);
    }

    @Override // com.octopus.ad.AdLifeControl
    public void cancel() {
        this.f12332a.cancel();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void destroy() {
        onDestroyLifeCycle();
        cancel();
    }

    public String getAdSlotId() {
        return this.f12332a.getAdSlotId();
    }

    public Map<String, Object> getMediaExtraInfo() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        return interstitialAdViewImpl != null ? interstitialAdViewImpl.getMediaExtraInfo() : Collections.EMPTY_MAP;
    }

    public int getPrice() {
        return this.f12332a.getPrice();
    }

    public String getRequestId() {
        return this.f12332a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        if (interstitialAdViewImpl != null) {
            return interstitialAdViewImpl.getShakeValue();
        }
        return null;
    }

    public String getTagId() {
        return this.f12332a.getTagId();
    }

    public boolean isLoaded() {
        return this.f12332a.f();
    }

    public boolean isLoading() {
        return this.f12332a.j();
    }

    public boolean isValid() {
        return isLoaded() && this.f12332a.g();
    }

    public void loadAd() {
        this.f12332a.a(new AdRequest.Builder().build().a());
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        this.f12332a.onDestroyLifeCycle();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f12332a.setOpensNativeBrowser(z);
    }

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.sendLossNotice(i, str, str2);
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.sendWinNotice(i);
    }

    public void setChannel(String str) {
        this.f12332a.setChannel(str);
    }

    public void setClickBackClose(boolean z) {
        this.f12332a.setClickBackClose(z);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f12332a.setRequestId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12332a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setVideoStateListener(videoStateListener);
    }

    public void show(Activity activity) {
        this.f12332a.a(activity.getApplicationContext());
    }

    public void loadAd(AdRequest adRequest) {
        this.f12332a.a(adRequest.a());
    }
}
