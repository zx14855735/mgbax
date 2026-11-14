package a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.SplashAd;
import com.octopus.ad.SplashAdListener;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class h extends UniAdCustomSplashLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7932a = getClass().getSimpleName();
    public SplashAd b;

    public class a implements SplashAdListener {
        public a() {
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdCacheLoaded(boolean z) {
            String unused = h.this.f7932a;
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdClicked() {
            String unused = h.this.f7932a;
            h.this.onAdClicked();
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdClosed() {
            String unused = h.this.f7932a;
            h.this.onAdClosed();
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdFailedToLoad(int i) {
            String unused = h.this.f7932a;
            h.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdLoaded() {
            String unused = h.this.f7932a;
            if (h.this.getBidType() == 1) {
                h hVar = h.this;
                hVar.setBidPrice(hVar.b.getPrice());
            }
            h.this.onLoadSuccess();
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdShown() {
            String unused = h.this.f7932a;
            h.this.onAdShow();
        }

        @Override // com.octopus.ad.SplashAdListener
        public void onAdTick(long j) {
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.destroy();
            this.b = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        SplashAd splashAd = this.b;
        return splashAd != null && splashAd.isValid();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        SplashAd splashAd = new SplashAd(activity, uniAdSlot.getSlotId(), new a());
        this.b = splashAd;
        splashAd.openAdInNativeBrowser(true);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader
    public void show(ViewGroup viewGroup) {
        SplashAd splashAd = this.b;
        if (splashAd == null || !splashAd.isValid() || viewGroup == null) {
            return;
        }
        this.b.showAd(viewGroup);
    }
}
