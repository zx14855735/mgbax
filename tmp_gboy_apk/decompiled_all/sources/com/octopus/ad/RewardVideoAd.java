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
public final class RewardVideoAd implements IBidding, IRewardVideoAd {

    /* renamed from: a, reason: collision with root package name */
    private final InterstitialAdViewImpl f12337a;

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = new InterstitialAdViewImpl(context == null ? q.a().j() : context, p.REWARD, false);
        this.f12337a = interstitialAdViewImpl;
        interstitialAdViewImpl.setAdSlotId(str);
        interstitialAdViewImpl.setRewardVideoAdListener(rewardVideoAdListener);
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void destroy() {
        this.f12337a.destroy();
    }

    public Map<String, Object> getMediaExtraInfo() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        return interstitialAdViewImpl != null ? interstitialAdViewImpl.getMediaExtraInfo() : Collections.EMPTY_MAP;
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public int getPrice() {
        return this.f12337a.getPrice();
    }

    public String getRequestId() {
        return this.f12337a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        if (interstitialAdViewImpl != null) {
            return interstitialAdViewImpl.getShakeValue();
        }
        return null;
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public String getTagId() {
        return this.f12337a.getTagId();
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public boolean isLoaded() {
        return this.f12337a.f();
    }

    public boolean isValid() {
        return isLoaded() && this.f12337a.g();
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void loadAd() {
        this.f12337a.a(new AdRequest.Builder().build().a());
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f12337a.c(z);
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void pause() {
        this.f12337a.t();
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void resume() {
        this.f12337a.u();
    }

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.sendLossNotice(i, str, str2);
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.sendWinNotice(i);
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void setAdSlotId(String str) {
        this.f12337a.setAdSlotId(str);
    }

    public void setChannel(String str) {
        this.f12337a.setChannel(str);
    }

    public void setExtraData(String str) {
        this.f12337a.setExtraData(str);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f12337a.setRequestId(str);
    }

    public void setUserId(String str) {
        this.f12337a.setUserId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f12337a;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setVideoStateListener(videoStateListener);
    }

    @Override // com.octopus.ad.IRewardVideoAd
    public void show(Activity activity) {
        if (isLoaded()) {
            this.f12337a.a(activity);
        }
    }
}
