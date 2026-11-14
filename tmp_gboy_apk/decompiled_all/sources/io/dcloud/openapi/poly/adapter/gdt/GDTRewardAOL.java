package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import android.text.TextUtils;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTRewardAOL extends DCBaseAOLLoader implements RewardVideoADListener {

    /* renamed from: a, reason: collision with root package name */
    public RewardVideoAD f13974a;
    public int b;

    public GDTRewardAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13974a != null) {
            int i4 = i3 != 2 ? 10001 : 1;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.WIN_PRICE, i4, IBidding.LOSS_REASON);
            hashMap.put(IBidding.ADN_ID, 2);
            this.f13974a.sendLossNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13974a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.EXPECT_COST_PRICE, i2, IBidding.HIGHEST_LOSS_PRICE);
            this.f13974a.sendWinNotification(hashMap);
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
        RewardVideoAD rewardVideoAD = this.f13974a;
        return rewardVideoAD != null && rewardVideoAD.isValid();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTRewardAOL.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                GDTRewardAOL.this.loadFail(-4001, exc.getMessage());
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                ServerSideVerificationOptions.Builder builder;
                if (TextUtils.isEmpty(GDTRewardAOL.this.getSlot().getUserId())) {
                    builder = null;
                } else {
                    builder = new ServerSideVerificationOptions.Builder();
                    builder.setUserId(GDTRewardAOL.this.getSlot().getUserId());
                }
                if (!TextUtils.isEmpty(GDTRewardAOL.this.getSlot().getExtra())) {
                    if (builder == null) {
                        builder = new ServerSideVerificationOptions.Builder();
                    }
                    builder.setCustomData(GDTRewardAOL.this.getSlot().getExtra());
                }
                GDTRewardAOL.this.f13974a = new RewardVideoAD(GDTRewardAOL.this.getActivity(), GDTRewardAOL.this.getSlotId(), GDTRewardAOL.this);
                if (builder != null) {
                    GDTRewardAOL.this.f13974a.setServerSideVerificationOptions(builder.build());
                }
                GDTRewardAOL.this.f13974a.loadAD();
            }
        });
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        if (getAdStatus() != 1) {
            loadFail(adError.getErrorCode(), adError.getErrorMsg());
            return;
        }
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + adError.getErrorCode() + ";message:" + adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        if (getVideoAdCallback() instanceof AOLLoader.RewVAOLInteractionListener) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", Const.PROVIDER_TYPE_CHINA);
            } catch (JSONException unused) {
            }
            ((AOLLoader.RewVAOLInteractionListener) getVideoAdCallback()).onReward(jSONObject);
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        if (this.f13974a != null && isSlotSupportBidding()) {
            setBiddingECPM(this.f13974a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            if (isSlotSupportBidding()) {
                this.f13974a.setBidECPM(this.b);
            }
            this.f13974a.showAD(activity);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }
}
