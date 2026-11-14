package com.fl.saas.s2s;

import Cd8JRx.ADYaiT;
import Kce6Pf.A2egSU;
import android.app.Activity;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoAD;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoADManager;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.spi.SPI;
import java.lang.reflect.Method;

@Advertiser(5)
@SPI({AdapterAPI.class})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SFullVideoAdapter extends AdViewFullVideoAdapter implements OnS2SFullVideoADListener, BiddingResult, AdChangeCacheData {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SFullVideoAdapter.class);
    private S2SFullVideoADManager adManager;
    private AdInfoPoJo adPoJo;
    private S2SFullVideoAD s2SFullVideoAD = null;

    static {
        AzVc();
    }

    private static /* synthetic */ void AzVc() {
        char[] charArray = "\u0095\u0099\u009bØ\u0091\u0097\u009b\u0093Ø\u0094\u0099\u008fØ\u0085\u009e\u0093\u009a\u009aØ¼\u0098\u009f´\u0084\u009f\u0092\u0091\u0093".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 246);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0095\u009a\u009f\u0098\u009f\u0082".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 246);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardVideo$0(Activity activity) {
        onShowEvent();
        S2SFullVideoADManager s2SFullVideoADManager = this.adManager;
        if (s2SFullVideoADManager == null || !s2SFullVideoADManager.isReady()) {
            onFullVideoAdFailed(new YdError(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "暂无可用全屏视频广告，请等待缓存加载或者重新刷新"));
        } else {
            this.adManager.showAd(activity);
        }
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
        AdInfoPoJo adInfoPoJo = this.adPoJo;
        if (adInfoPoJo == null) {
            return;
        }
        if (!z) {
            if (i > 0) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidFail(this.adPoJo);
        } else {
            if (i > 0 && i <= adInfoPoJo.price) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidSuccess(this.adPoJo);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.s2SFullVideoAD == null || isCache()) {
            return;
        }
        this.s2SFullVideoAD.destroy();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        S2SFullVideoAD s2SFullVideoAD = new S2SFullVideoAD(this, new ADYaiT(5, this));
        this.s2SFullVideoAD = s2SFullVideoAD;
        s2SFullVideoAD.loadAd(getAdSource());
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onClick(String str) {
        LogcatUtil.d(TAG, "onADClick");
        onClickedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onClose() {
        LogcatUtil.d(TAG, "onADClose");
        onClosedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onComplete(double d) {
        LogcatUtil.d(TAG, "onComplete");
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onError(YdError ydError) {
        onFullVideoAdFailed(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onFullVideoAdFailed(YdError ydError) {
        disposeError(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onLoad(S2SFullVideoADManager s2SFullVideoADManager) {
        AdInfoPoJo.Creative creative;
        if (s2SFullVideoADManager == null) {
            onError(YdError.create(0, "S2SFullVideoADManager is null"));
            return;
        }
        this.adManager = s2SFullVideoADManager;
        AdInfoPoJo adInfoPoJo = s2SFullVideoADManager.getAdInfoPoJo();
        this.adPoJo = adInfoPoJo;
        if (adInfoPoJo != null && (creative = adInfoPoJo.creative) != null && !TextUtils.isEmpty(creative.cid)) {
            getAdSource().creative_id = this.adPoJo.creative.cid;
        }
        onLoadedEvent();
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        AdInfoPoJo adInfoPoJo = this.adPoJo;
        if (adInfoPoJo != null) {
            adInfoPoJo.trackId = str;
            adInfoPoJo.adPool = adSource.adPool;
            String str2 = adSource.place_id;
            adInfoPoJo.place_id = str2;
            adInfoPoJo.global_group_id = adSource.group_id;
            adInfoPoJo.global_place_id = str2;
            adInfoPoJo.global_test_id = adSource.test_id;
        }
    }

    @Override // com.fl.saas.base.adapter.AdViewFullVideoAdapter
    public void showRewardVideo() {
        getActivityValid().ifPresent(new A2egSU(2, this));
    }
}
