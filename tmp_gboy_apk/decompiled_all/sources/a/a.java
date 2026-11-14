package a;

import android.view.View;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.DrawAd;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.internal.nativead.NativeAdEventListener;
import com.octopus.ad.internal.utilities.ViewUtil;
import io.dcloud.api.custom.type.draw.UniAdCustomDrawAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a extends UniAdCustomDrawAd {

    /* renamed from: a, reason: collision with root package name */
    public final String f7918a = "f";
    public DrawAd b;
    public final NativeAdResponse c;

    /* renamed from: a.a$a, reason: collision with other inner class name */
    public class C0005a implements NativeAdEventListener {
        public C0005a() {
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onADExposed() {
            String unused = a.this.f7918a;
            a.this.onAdShow();
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdClick() {
            String unused = a.this.f7918a;
            a.this.onAdClicked();
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdClose() {
            String unused = a.this.f7918a;
            ViewUtil.removeChildFromParent(a.this.c.getNativeView());
            a.this.onAdClosed("");
        }

        @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
        public void onAdRenderFailed(int i) {
            String unused = a.this.f7918a;
            a.this.onRenderFail(i, String.valueOf(i));
        }
    }

    public a(DrawAd drawAd, NativeAdResponse nativeAdResponse) {
        this.b = drawAd;
        this.c = nativeAdResponse;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void destroy() {
        DrawAd drawAd = this.b;
        if (drawAd != null) {
            drawAd.destroy();
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
        DrawAd drawAd = this.b;
        if (drawAd != null) {
            drawAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidSuccess(int i, int i2) {
        DrawAd drawAd = this.b;
        if (drawAd != null) {
            drawAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void render() {
        NativeAdResponse nativeAdResponse = this.c;
        if (nativeAdResponse == null) {
            onRenderFail(80101, "广告数据为空");
        } else {
            nativeAdResponse.setNativeAdEventListener(new C0005a());
            onRenderSuccess();
        }
    }
}
