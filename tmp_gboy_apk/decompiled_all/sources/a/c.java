package a;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.FullScreenVideoAd;
import com.octopus.ad.FullScreenVideoAdListener;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends UniAdCustomFullScreenVideoLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7922a = getClass().getSimpleName();
    public FullScreenVideoAd b;

    public class a implements FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdCacheLoaded(boolean z) {
            String unused = c.this.f7922a;
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdClicked() {
            String unused = c.this.f7922a;
            c.this.onAdClicked();
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdClosed() {
            String unused = c.this.f7922a;
            c.this.onAdClosed();
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdFailedToLoad(int i) {
            String unused = c.this.f7922a;
            c.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdLoaded() {
            String unused = c.this.f7922a;
            if (c.this.getBidType() == 1) {
                c cVar = c.this;
                cVar.setBidPrice(cVar.b.getPrice());
            }
            c.this.onLoadSuccess();
        }

        @Override // com.octopus.ad.FullScreenVideoAdListener
        public void onAdShown() {
            String unused = c.this.f7922a;
            c.this.onAdShow();
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        FullScreenVideoAd fullScreenVideoAd = this.b;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.destroy();
            this.b = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        FullScreenVideoAd fullScreenVideoAd = this.b;
        return fullScreenVideoAd != null && fullScreenVideoAd.isValid();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        FullScreenVideoAd fullScreenVideoAd = new FullScreenVideoAd(activity, uniAdSlot.getSlotId(), new a());
        this.b = fullScreenVideoAd;
        fullScreenVideoAd.openAdInNativeBrowser(true);
        this.b.loadAd();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        FullScreenVideoAd fullScreenVideoAd = this.b;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        FullScreenVideoAd fullScreenVideoAd = this.b;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader
    public void show(Activity activity) {
        FullScreenVideoAd fullScreenVideoAd = this.b;
        if (fullScreenVideoAd == null || !fullScreenVideoAd.isValid()) {
            return;
        }
        this.b.show(activity);
    }
}
