package com.qq.e.ads.nativ;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener, IReward {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final NativeUnifiedADData f12855AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public NativeADEventListener f12856AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public NativeADMediaListener f12857AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public DownloadConfirmListener f12858AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public NegativeFeedbackListener f12859B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ADRewardListener f12860B2KMhB;

    public class UnifiedAdListener implements ADListener {
        public UnifiedAdListener() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = NativeUnifiedADDataAdapter.this;
            if (nativeUnifiedADDataAdapter.f12856AlLFFp != null) {
                int type = aDEvent.getType();
                if (type == 103) {
                    nativeUnifiedADDataAdapter.f12856AlLFFp.onADExposed();
                    return;
                }
                if (type == 105) {
                    NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f12856AlLFFp;
                    if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                        ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f12856AlLFFp).onADClicked((View) aDEvent.getParam(View.class));
                        return;
                    } else {
                        nativeADEventListener.onADClicked();
                        return;
                    }
                }
                if (type == 107) {
                    nativeUnifiedADDataAdapter.f12856AlLFFp.onADError(AdErrorConvertor.getAdError(aDEvent));
                    return;
                } else if (type == 111) {
                    nativeUnifiedADDataAdapter.f12856AlLFFp.onADStatusChanged();
                    return;
                }
            }
            if (nativeUnifiedADDataAdapter.f12857AmA8tU != null) {
                switch (aDEvent.getType()) {
                    case 201:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoLoaded(num.intValue());
                            break;
                        }
                        break;
                    case 202:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoStart();
                        break;
                    case 203:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoResume();
                        break;
                    case 204:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoPause();
                        break;
                    case 205:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoStop();
                        break;
                    case 206:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoCompleted();
                        break;
                    case 207:
                        Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                        if (num2 != null) {
                            nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                            break;
                        }
                        break;
                    case 208:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoClicked();
                        break;
                    case 209:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoInit();
                        break;
                    case 210:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoReady();
                        break;
                    case 211:
                        nativeUnifiedADDataAdapter.f12857AmA8tU.onVideoLoading();
                        break;
                }
                return;
            }
            if (nativeUnifiedADDataAdapter.f12859B25kr6 != null && aDEvent.getType() == 304) {
                nativeUnifiedADDataAdapter.f12859B25kr6.onComplainSuccess();
            } else {
                if (nativeUnifiedADDataAdapter.f12860B2KMhB == null || aDEvent.getType() != 104 || (str = (String) aDEvent.getParam(String.class)) == null) {
                    return;
                }
                nativeUnifiedADDataAdapter.f12860B2KMhB.onReward(A2egSU.BI9f7h("transId", str));
            }
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f12855AcNBzu = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener());
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.f12855AcNBzu.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f12855AcNBzu.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f12855AcNBzu.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        this.f12855AcNBzu.bindImageViews(list, i);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f12857AmA8tU = nativeADMediaListener;
        this.f12855AcNBzu.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f12855AcNBzu.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f12855AcNBzu.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f12855AcNBzu;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f12855AcNBzu.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f12855AcNBzu.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.f12855AcNBzu.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f12855AcNBzu.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f12855AcNBzu.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f12855AcNBzu.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.f12855AcNBzu.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f12855AcNBzu.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.f12855AcNBzu.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f12855AcNBzu.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f12855AcNBzu.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f12855AcNBzu.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f12855AcNBzu.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f12855AcNBzu.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f12855AcNBzu.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f12855AcNBzu.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f12855AcNBzu.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f12855AcNBzu.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f12855AcNBzu.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f12855AcNBzu.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f12855AcNBzu.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f12855AcNBzu.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f12855AcNBzu.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f12855AcNBzu.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f12855AcNBzu.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f12855AcNBzu.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f12855AcNBzu.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f12858AzWtSf;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f12855AcNBzu.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f12855AcNBzu.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f12855AcNBzu.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f12855AcNBzu.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f12855AcNBzu.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.f12855AcNBzu.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.f12855AcNBzu.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f12858AzWtSf = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f12855AcNBzu;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f12856AlLFFp = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12859B25kr6 = negativeFeedbackListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f12860B2KMhB = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12855AcNBzu.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f12855AcNBzu.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f12855AcNBzu.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f12855AcNBzu.stopVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f12855AcNBzu.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.f12855AcNBzu.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f12855AcNBzu.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f12855AcNBzu.sendWinNotification(map);
    }
}
