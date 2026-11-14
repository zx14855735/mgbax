package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static final /* synthetic */ int f12820BPw6Q8 = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public volatile int f12821B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public volatile int f12822B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final List f12823B7CMnp = Collections.synchronizedList(new ArrayList());

    /* renamed from: B9tovu, reason: collision with root package name */
    public VideoOption f12824B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ADSize f12825BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final NativeExpressADListener f12826BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ADListenerAdapter f12827BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public LoadAdParams f12828BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public volatile ServerSideVerificationOptions f12829BNL6CD;

    public static class ADListenerAdapter implements ADListener {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final NativeExpressADListener f12830A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public NativeExpressMediaListener f12831A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public NegativeFeedbackListener f12832A5SV6n;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public ADRewardListener f12833ADYaiT;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f12830A2egSU = nativeExpressADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            NativeExpressADView nativeExpressADView;
            int i = NativeExpressAD.f12820BPw6Q8;
            NativeExpressADListener nativeExpressADListener = this.f12830A2egSU;
            if (nativeExpressADListener != null) {
                int type = aDEvent.getType();
                if (type == 100) {
                    List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                    if (list != null) {
                        nativeExpressADListener.onADLoaded(list);
                        return;
                    }
                    return;
                }
                if (type == 101) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                    return;
                }
                if (type == 103) {
                    NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView2 != null) {
                        nativeExpressADListener.onADExposure(nativeExpressADView2);
                        return;
                    }
                    return;
                }
                if (type == 303) {
                    NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView3 != null) {
                        nativeExpressADListener.onADLeftApplication(nativeExpressADView3);
                        return;
                    }
                    return;
                }
                if (type == 105) {
                    NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView4 != null) {
                        nativeExpressADListener.onADClicked(nativeExpressADView4);
                        return;
                    }
                    return;
                }
                if (type == 106) {
                    NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView5 != null) {
                        nativeExpressADListener.onADClosed(nativeExpressADView5);
                        nativeExpressADView5.negativeFeedback();
                        return;
                    }
                    return;
                }
                if (type == 109) {
                    NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView6 != null) {
                        nativeExpressADListener.onRenderSuccess(nativeExpressADView6);
                        return;
                    }
                    return;
                }
                if (type == 110) {
                    NativeExpressADView nativeExpressADView7 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView7 != null) {
                        nativeExpressADListener.onRenderFail(nativeExpressADView7);
                        return;
                    }
                    return;
                }
            }
            NativeExpressMediaListener nativeExpressMediaListener = this.f12831A4TApA;
            if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
                int type2 = aDEvent.getType();
                if (type2 == 201) {
                    nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                    return;
                }
                if (type2 == 202) {
                    nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                    return;
                }
                if (type2 == 204) {
                    nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                    return;
                }
                if (type2 == 206) {
                    nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                    return;
                }
                if (type2 == 207) {
                    Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                    if (num != null) {
                        nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                if (type2 == 301) {
                    nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                    return;
                }
                if (type2 == 302) {
                    nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                    return;
                }
                switch (type2) {
                    case 209:
                        nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                        break;
                    case 210:
                        if (((Integer) aDEvent.getParam(1, Integer.class)) != null) {
                            nativeExpressMediaListener.onVideoReady(nativeExpressADView, r7.intValue());
                            break;
                        }
                        break;
                    case 211:
                        nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                        break;
                }
                return;
            }
            NegativeFeedbackListener negativeFeedbackListener = this.f12832A5SV6n;
            if (negativeFeedbackListener != null && aDEvent.getType() == 304) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            ADRewardListener aDRewardListener = this.f12833ADYaiT;
            if (aDRewardListener == null || aDEvent.getType() != 104 || (str = (String) aDEvent.getParam(String.class)) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("transId", str);
            aDRewardListener.onReward(hashMap);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f12833ADYaiT = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f12831A4TApA = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f12832A5SV6n = negativeFeedbackListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f12831A4TApA = nativeExpressMediaListener;
        }
    }

    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f12826BI9f7h = nativeExpressADListener;
        this.f12827BIYEnU = new ADListenerAdapter(nativeExpressADListener);
        if (aDSize == null) {
            GDTLogger.e("初始化错误：参数adSize不能为空");
            a(2001);
        } else {
            this.f12825BChYOn = aDSize;
            a(context, str);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NEADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f12825BChYOn, str, str2, str3, this.f12827BIYEnU);
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f12828BJ7GGh = loadAdParams;
    }

    public void setMaxVideoDuration(int i) {
        this.f12822B4ZgIw = i;
        if (this.f12822B4ZgIw > 0 && this.f12821B3GDIM > this.f12822B4ZgIw) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.f12822B4ZgIw);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f12821B3GDIM = i;
        if (this.f12822B4ZgIw > 0 && this.f12821B3GDIM > this.f12822B4ZgIw) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.f12821B3GDIM);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f12827BIYEnU.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12829BNL6CD = serverSideVerificationOptions;
        T t = this.f12733a;
        if (t != 0) {
            ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f12824B9tovu = videoOption;
        T t = this.f12733a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeExpressADListener nativeExpressADListener = this.f12826BI9f7h;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f12823B7CMnp) {
                    this.f12823B7CMnp.add(Integer.valueOf(i));
                }
                return;
            }
            T t = this.f12733a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f12828BJ7GGh;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        super.a((NativeExpressAD) neadi);
        neadi.setMinVideoDuration(this.f12821B3GDIM);
        neadi.setMaxVideoDuration(this.f12822B4ZgIw);
        ((NEADI) this.f12733a).setServerSideVerificationOptions(this.f12829BNL6CD);
        VideoOption videoOption = this.f12824B9tovu;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f12823B7CMnp) {
            try {
                Iterator it = this.f12823B7CMnp.iterator();
                while (it.hasNext()) {
                    T t = this.f12733a;
                    if (t != 0) {
                        if (this.f12828BJ7GGh != null) {
                            ((NEADI) t).loadAd(((Integer) it.next()).intValue(), this.f12828BJ7GGh);
                        } else {
                            ((NEADI) t).loadAd(((Integer) it.next()).intValue());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f12826BI9f7h = nativeExpressADListener;
        this.f12827BIYEnU = new ADListenerAdapter(nativeExpressADListener);
        if (aDSize == null) {
            GDTLogger.e("初始化错误：参数adSize不能为空");
            a(2001);
        } else {
            this.f12825BChYOn = aDSize;
            a(context, str, str2);
        }
    }
}
