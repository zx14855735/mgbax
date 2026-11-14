package com.qq.e.ads.rewardvideo;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final RewardVideoADListener f12866B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public volatile boolean f12867B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public LoadAdParams f12868B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public ServerSideVerificationOptions f12869BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final boolean f12870BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ADListenerAdapter f12871BIYEnU;

    public static class ADListenerAdapter implements ADListener {

        /* renamed from: A2egSU, reason: collision with root package name */
        public NegativeFeedbackListener f12872A2egSU;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
                return;
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.f12872A2egSU;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    break;
                case 103:
                    this.adListener.onADExpose();
                    break;
                case 104:
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        HashMap BI9f7h2 = A2egSU.BI9f7h("transId", str);
                        Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num != null) {
                            BI9f7h2.put(ServerSideVerificationOptions.ACTION, num);
                        }
                        this.adListener.onReward(BI9f7h2);
                        break;
                    }
                    break;
                case 105:
                    this.adListener.onADClick();
                    break;
                case 106:
                    this.adListener.onADClose();
                    break;
                case 107:
                    this.adListener.onError(AdErrorConvertor.getAdError(aDEvent));
                    break;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RVADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f12871BIYEnU);
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((RVADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t = this.f12733a;
        if (t != 0) {
            return ((RVADI) t).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f12733a;
        if (t != 0) {
            return ((RVADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.f12733a;
        if (t != 0) {
            return ((RVADI) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f12867B7CMnp = true;
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f12868B9tovu = loadAdParams;
        T t = this.f12733a;
        if (t != 0) {
            ((RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12871BIYEnU.f12872A2egSU = negativeFeedbackListener;
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12869BChYOn = serverSideVerificationOptions;
        T t = this.f12733a;
        if (t != 0) {
            ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.f12733a;
        if (t != 0) {
            ((RVADI) t).showAD();
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(rewardVideoADListener, z);
        a(context, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(RVADI rvadi) {
        rvadi.setVolumeOn(this.f12870BI9f7h);
        rvadi.setLoadAdParams(this.f12868B9tovu);
        rvadi.setServerSideVerificationOptions(this.f12869BChYOn);
        if (this.f12867B7CMnp) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        RewardVideoADListener rewardVideoADListener = this.f12866B4ZgIw;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void showAD(Activity activity) {
        T t = this.f12733a;
        if (t != 0) {
            ((RVADI) t).showAD(activity);
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this(rewardVideoADListener, z);
        a(context, str, str2);
    }

    public RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f12868B9tovu = null;
        this.f12870BI9f7h = z;
        this.f12866B4ZgIw = rewardVideoADListener;
        this.f12871BIYEnU = new ADListenerAdapter(rewardVideoADListener);
    }
}
