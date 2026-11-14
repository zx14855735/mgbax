package io.dcloud.openapi.poly.adapter.gdt;

import I3HV03.BTvldC;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.A4TApA;
import com.bumptech.glide.RequestBuilder;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTDrawAOLEntry extends DCBaseAOL implements NativeADEventListener, NativeADMediaListener {

    /* renamed from: a, reason: collision with root package name */
    public Object f13963a;
    public View b;
    public int c;

    public GDTDrawAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.c = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13963a instanceof NativeUnifiedADData) {
            int i4 = i3 != 2 ? 10001 : 1;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.WIN_PRICE, i4, IBidding.LOSS_REASON);
            hashMap.put(IBidding.ADN_ID, 2);
            ((NativeUnifiedADData) this.f13963a).sendLossNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13963a instanceof NativeUnifiedADData) {
            this.c = i;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.EXPECT_COST_PRICE, i2, IBidding.HIGHEST_LOSS_PRICE);
            ((NativeUnifiedADData) this.f13963a).sendWinNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        Object obj = this.f13963a;
        if (obj instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) obj).destroy();
        }
        this.f13963a = null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        if (!(this.f13963a instanceof NativeUnifiedADData) || activity == null) {
            return null;
        }
        return this.b;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "gdt";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        Object obj = this.f13963a;
        return (obj instanceof NativeUnifiedADData) && ((NativeUnifiedADData) obj).isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i) {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void render() {
        if (getFeedAdCallback() != null) {
            Object obj = this.f13963a;
            if (!(obj instanceof NativeUnifiedADData)) {
                getFeedAdCallback().onRenderFail();
                return;
            }
            ((NativeUnifiedADData) obj).setNativeAdEventListener(this);
            if (isSlotSupportBidding()) {
                ((NativeUnifiedADData) this.f13963a).setBidECPM(this.c);
            }
            Activity activity = getActivity();
            View inflate = LayoutInflater.from(activity).inflate(R.layout.dcloud_draw_ad, (ViewGroup) null);
            this.b = inflate;
            NativeAdContainer nativeAdContainer = (NativeAdContainer) inflate.findViewById(R.id.dcloud_native_ad_container);
            ArrayList arrayList = new ArrayList();
            TextView textView = (TextView) this.b.findViewById(R.id.dcloud_gdt_draw_ad_title);
            textView.setText(((NativeUnifiedADData) this.f13963a).getTitle());
            TextView textView2 = (TextView) this.b.findViewById(R.id.dcloud_gdt_draw_ad_message);
            textView2.setText(((NativeUnifiedADData) this.f13963a).getDesc());
            TextView textView3 = (TextView) this.b.findViewById(R.id.dcloud_gdt_draw_ad_btn);
            ((RequestBuilder) A4TApA.ARc23Z(activity).AaHO0E(((NativeUnifiedADData) this.f13963a).getIconUrl()).B2KMhB(new BTvldC(), true)).BTvldC((ImageView) this.b.findViewById(R.id.dcloud_gdt_draw_ad_icon));
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) this.f13963a;
            if (nativeUnifiedADData.isAppAd()) {
                int appStatus = nativeUnifiedADData.getAppStatus();
                if (appStatus == 0) {
                    textView3.setText("下载");
                } else if (appStatus == 1) {
                    textView3.setText("启动");
                } else if (appStatus == 2) {
                    textView3.setText("更新");
                } else if (appStatus == 4) {
                    textView3.setText(nativeUnifiedADData.getProgress() + "%");
                } else if (appStatus == 8) {
                    textView3.setText("安装");
                } else if (appStatus != 16) {
                    textView3.setText("浏览");
                } else {
                    textView3.setText("下载失败，重新下载");
                }
            } else {
                textView3.setText("浏览");
            }
            arrayList.add(textView);
            arrayList.add(textView2);
            arrayList.add(textView3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add((LinearLayout) this.b.findViewById(R.id.dcloud_gdt_draw_ad_click_view));
            ((NativeUnifiedADData) this.f13963a).bindAdToView(activity, nativeAdContainer, null, arrayList, arrayList2);
            ((NativeUnifiedADData) this.f13963a).bindMediaView((MediaView) this.b.findViewById(R.id.dcloud_media_view), new VideoOption.Builder().setAutoPlayMuted(false).setEnableUserControl(true).build(), this);
            getFeedAdCallback().onRenderSuccess();
        }
    }

    public void setAdEntry(Object obj) {
        this.f13963a = obj;
    }
}
