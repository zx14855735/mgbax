package KiXkPs;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.adapter.base.ReportEventListener;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.manager.AdViewNativeManager;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4267A2egSU;

    public /* synthetic */ A2egSU(int i) {
        this.f4267A2egSU = i;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f4267A2egSU) {
            case 0:
                ((AdViewNativeManager) obj).startVideo();
                break;
            case 1:
                ((AdViewNativeManager) obj).stopVideo();
                break;
            case 2:
                ((AdViewNativeManager) obj).resumeVideo();
                break;
            case 3:
                ((AdViewNativeManager) obj).resume();
                break;
            case 4:
                ((AdViewNativeManager) obj).pauseVideo();
                break;
            case 5:
                ((AdViewBannerListener) obj).onAdExposure();
                break;
            case 6:
                ((AdViewBannerListener) obj).onClosed();
                break;
            case 7:
                ((AdViewBannerListener) obj).onAdClick("");
                break;
            case 8:
                ((AdViewFullVideoListener) obj).onVideoPlayStart();
                break;
            case 9:
                ((AdViewFullVideoListener) obj).onPageDismiss();
                break;
            case 10:
                ((AdViewFullVideoListener) obj).onAdClicked();
                break;
            case 11:
                ((AdViewFullVideoListener) obj).onVideoPrepared();
                break;
            case 12:
                ((AdViewSpreadListener) obj).onAdClose();
                break;
            case 13:
                ((AdViewVideoListener) obj).onVideoPrepared();
                break;
            case 14:
                ((AdViewVideoListener) obj).onAdShow();
                break;
            case 15:
                ((AdViewVideoListener) obj).onAdClick("");
                break;
            case 16:
                ((AdViewVideoListener) obj).onAdClose();
                break;
            case 17:
                ((AdViewVideoListener) obj).onVideoCompleted();
                break;
            case 18:
                ((MixNativeHandler) obj).destroy();
                break;
            case 19:
                ((NativeAd) obj).destroy();
                break;
            case 20:
                ((RainTextureView) obj).stop();
                break;
            case 21:
                ((RainTextureView) obj).start();
                break;
            case 22:
                ((ReportEventListener) obj).reportRequestShow();
                break;
            case 23:
                ((ReportEventListener) obj).onShowEvent();
                break;
            case 24:
                ((ReportEventListener) obj).onClickedEvent();
                break;
            case 25:
                ((AdViewBannerAdapter) obj).destroy();
                break;
            case 26:
                ((AdViewFullVideoAdapter) obj).showRewardVideo();
                break;
            case 27:
                ((AdViewNativeAdapter) obj).pauseVideo();
                break;
            case 28:
                ((AdViewNativeAdapter) obj).resumeVideo();
                break;
            default:
                ((AdViewNativeAdapter) obj).startVideo();
                break;
        }
    }
}
