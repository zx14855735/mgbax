package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final UnifiedBannerAD f12754AcNBzu;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public void destroy() {
        this.f12754AcNBzu.destroy();
    }

    public String getAdNetWorkName() {
        return this.f12754AcNBzu.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f12754AcNBzu.getApkInfoUrl();
    }

    public int getECPM() {
        return this.f12754AcNBzu.getECPM();
    }

    public String getECPMLevel() {
        return this.f12754AcNBzu.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.f12754AcNBzu.getExtraInfo();
    }

    public boolean isValid() {
        return this.f12754AcNBzu.isValid();
    }

    public void loadAD() {
        this.f12754AcNBzu.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f12754AcNBzu.onWindowFocusChanged(z);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f12754AcNBzu.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.f12754AcNBzu.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.f12754AcNBzu.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f12754AcNBzu.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f12754AcNBzu.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12754AcNBzu.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        this.f12754AcNBzu.A4TApA(i);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f12754AcNBzu.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12754AcNBzu.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        UnifiedBannerAD unifiedBannerAD = new UnifiedBannerAD(this, unifiedBannerADListener);
        unifiedBannerAD.a(activity, str);
        this.f12754AcNBzu = unifiedBannerAD;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f12754AcNBzu.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f12754AcNBzu.sendWinNotification(map);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(getClass().getSimpleName().concat("构造函数中 token 参数不可为空"));
        }
        UnifiedBannerAD unifiedBannerAD = new UnifiedBannerAD(this, unifiedBannerADListener);
        unifiedBannerAD.a(activity, str, str2);
        this.f12754AcNBzu = unifiedBannerAD;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }
}
