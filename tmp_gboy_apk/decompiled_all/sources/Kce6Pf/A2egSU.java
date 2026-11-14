package Kce6Pf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.fl.saas.base.custom.fullvideo.CustomFullVideoAdapter;
import com.fl.saas.base.custom.rewardvideo.CustomRewardVideoAdapter;
import com.fl.saas.base.inner.banner.BannerViewEvent;
import com.fl.saas.base.inner.banner.BannerViewHelper;
import com.fl.saas.base.inner.interstitial.InterstitialViewEvent;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMVView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMHView;
import com.fl.saas.base.inner.spread.SpreadViewEvent;
import com.fl.saas.base.inner.spread.SpreadViewHelper;
import com.fl.saas.base.inner.spread.coustomView.SpreadHorizontalView;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.S2SFullVideoAdapter;
import com.fl.saas.s2s.S2SRewardVideoAdapter;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4256A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f4257A4TApA;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f4256A2egSU = i;
        this.f4257A4TApA = obj;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f4256A2egSU) {
            case 0:
                ((SpreadHorizontalView) this.f4257A4TApA).lambda$loadIcon$3((Bitmap) obj);
                break;
            case 1:
                ((AdViewListener) obj).onAdFailed((YdError) this.f4257A4TApA);
                break;
            case 2:
                ((S2SFullVideoAdapter) this.f4257A4TApA).lambda$showRewardVideo$0((Activity) obj);
                break;
            case 3:
                ((S2SRewardVideoAdapter) this.f4257A4TApA).lambda$showRewardVideo$0((Activity) obj);
                break;
            case 4:
                ((S2STemplateViewHelper) this.f4257A4TApA).lambda$loadImage$2((Drawable) obj);
                break;
            case 5:
                ((CustomFullVideoAdapter) this.f4257A4TApA).show((Activity) obj);
                break;
            case 6:
                ((CustomRewardVideoAdapter) this.f4257A4TApA).show((Activity) obj);
                break;
            case 7:
                ((BannerViewHelper) this.f4257A4TApA).lambda$loadView$1((Drawable) obj);
                break;
            case 8:
                ((BannerViewEvent) this.f4257A4TApA).onAdFailed((YdError) obj);
                break;
            case 9:
                ((InterstitialViewEvent) this.f4257A4TApA).onAdFailed((YdError) obj);
                break;
            case 10:
                ((InterstitialEnvelopeView) this.f4257A4TApA).lambda$loadIcon$2((Bitmap) obj);
                break;
            case 11:
                ((InterstitialFullScreenView) this.f4257A4TApA).lambda$loadIcon$6((Bitmap) obj);
                break;
            case 12:
                ((InterstitialHMVView) this.f4257A4TApA).lambda$loadIcon$1((Bitmap) obj);
                break;
            case 13:
                ((InterstitialVMHView) this.f4257A4TApA).lambda$loadIcon$3((Bitmap) obj);
                break;
            case 14:
                ((View) this.f4257A4TApA).setBackground((Drawable) obj);
                break;
            case 15:
                ((SpreadViewHelper) this.f4257A4TApA).lambda$loadView$3((Drawable) obj);
                break;
            default:
                ((SpreadViewEvent) this.f4257A4TApA).onAdFailed((YdError) obj);
                break;
        }
    }
}
