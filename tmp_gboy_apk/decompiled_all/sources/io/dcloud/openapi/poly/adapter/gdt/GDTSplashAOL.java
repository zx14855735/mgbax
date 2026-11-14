package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewGroup;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTSplashAOL extends DCBaseAOLLoader implements SplashADListener {

    /* renamed from: a, reason: collision with root package name */
    public SplashAD f13976a;
    public int b;

    public GDTSplashAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    public final /* synthetic */ void a(ViewGroup viewGroup) {
        this.f13976a.showAd(viewGroup);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13976a != null) {
            int i4 = i3 != 2 ? 10001 : 1;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.WIN_PRICE, i4, IBidding.LOSS_REASON);
            hashMap.put(IBidding.ADN_ID, 2);
            this.f13976a.sendLossNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13976a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.EXPECT_COST_PRICE, i2, IBidding.HIGHEST_LOSS_PRICE);
            this.f13976a.sendWinNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "gdt";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        GDTInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        SplashAD splashAD = this.f13976a;
        return splashAD != null && splashAD.isValid();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTSplashAOL.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                GDTSplashAOL.this.loadFail(-4001, exc.getMessage());
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                GDTSplashAOL.this.f13976a = new SplashAD(GDTSplashAOL.this.getActivity(), GDTSplashAOL.this.getSlotId(), GDTSplashAOL.this);
                GDTSplashAOL.this.f13976a.fetchAdOnly();
            }
        });
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        if (this.f13976a != null && isSlotSupportBidding()) {
            setBiddingECPM(this.f13976a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        if (j != 0 || getVideoAdCallback() == null) {
            return;
        }
        getVideoAdCallback().onClose();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        if (getAdStatus() != 0 && getAdStatus() != 1) {
            loadFail(adError.getErrorCode(), adError.getErrorMsg());
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(final ViewGroup viewGroup) {
        if (this.f13976a == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            }
        } else if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.poly.adapter.gdt.A2egSU
                    @Override // java.lang.Runnable
                    public final void run() {
                        GDTSplashAOL.this.a(viewGroup);
                    }
                });
                return;
            }
            if (isSlotSupportBidding()) {
                this.f13976a.setBidECPM(this.b);
            }
            this.f13976a.showAd(viewGroup);
        }
    }
}
