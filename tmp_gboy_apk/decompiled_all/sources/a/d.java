package a;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.InterstitialAd;
import com.octopus.ad.InterstitialAdListener;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends UniAdCustomInterstitialLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7924a = getClass().getSimpleName();
    public InterstitialAd b;

    public class a implements InterstitialAdListener {
        public a() {
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdCacheLoaded(boolean z) {
            String unused = d.this.f7924a;
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdClicked() {
            String unused = d.this.f7924a;
            d.this.onAdClicked();
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdClosed() {
            String unused = d.this.f7924a;
            d.this.onAdClosed();
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdFailedToLoad(int i) {
            String unused = d.this.f7924a;
            d.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdLoaded() {
            String unused = d.this.f7924a;
            if (d.this.getBidType() == 1) {
                d dVar = d.this;
                dVar.setBidPrice(dVar.b.getPrice());
            }
            d.this.onLoadSuccess();
        }

        @Override // com.octopus.ad.InterstitialAdListener
        public void onAdShown() {
            String unused = d.this.f7924a;
            d.this.onAdShow();
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.b = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        InterstitialAd interstitialAd = this.b;
        return interstitialAd != null && interstitialAd.isValid();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(activity, uniAdSlot.getSlotId(), new a());
        this.b = interstitialAd;
        interstitialAd.openAdInNativeBrowser(true);
        this.b.loadAd();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader
    public void show(Activity activity) {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd == null || !interstitialAd.isValid()) {
            return;
        }
        this.b.show(activity);
    }
}
