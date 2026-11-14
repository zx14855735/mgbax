package a;

import android.view.View;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.NativeAd;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.internal.nativead.NativeAdEventListener;
import com.octopus.ad.internal.utilities.ViewUtil;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e extends UniAdCustomNativeAd {

    /* renamed from: a, reason: collision with root package name */
    public final String f7926a = "f";
    public NativeAd b;
    public final NativeAdResponse c;
    public final int d;

    public class a implements NativeAdEventListener {
        public a() {
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onADExposed() {
            String unused = e.this.f7926a;
            e.this.onAdShow();
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdClick() {
            String unused = e.this.f7926a;
            e.this.onAdClicked();
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdClose() {
            String unused = e.this.f7926a;
            ViewUtil.removeChildFromParent(e.this.c.getNativeView());
            e.this.onAdClosed("");
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdRenderFailed(int i) {
            String unused = e.this.f7926a;
            e.this.onRenderFail(i, String.valueOf(i));
        }
    }

    public e(NativeAd nativeAd, NativeAdResponse nativeAdResponse, int i) {
        this.b = nativeAd;
        this.c = nativeAdResponse;
        this.d = i;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void destroy() {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.b = null;
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public View getNativeAd() {
        if (this.b == null) {
            return null;
        }
        return this.c.getNativeView();
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidFail(int i, int i2) {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidSuccess(int i, int i2) {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void render() {
        NativeAdResponse nativeAdResponse = this.c;
        if (nativeAdResponse == null) {
            onRenderFail(80101, "广告数据为空");
            return;
        }
        nativeAdResponse.setAdWidth(this.d);
        this.c.setNativeAdEventListener(new a());
        onRenderSuccess();
    }
}
