package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import io.dcloud.openapi.core.util.ScreenUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CSJSplashAOL2 extends DCBaseAOLLoader implements TTAdNative.CSJSplashAdListener, CSJSplashAd.SplashAdListener {

    /* renamed from: a, reason: collision with root package name */
    public String f13959a;
    public CSJSplashAd b;

    public CSJSplashAOL2(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a(ViewGroup viewGroup) {
        viewGroup.addView(this.b.getSplashView());
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void init(String str, String str2) {
        this.f13959a = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return this.b != null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        CSJInit.getInstance().init(getActivity(), this.f13959a, getType(), new TTAdSdk.InitCallback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJSplashAOL2.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
                CSJSplashAOL2.this.loadFail(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TTAdManager adManager = TTAdSdk.getAdManager();
                AdSlot build = new AdSlot.Builder().setCodeId(CSJSplashAOL2.this.getSlotId()).setSupportDeepLink(true).setImageAcceptedSize(CSJSplashAOL2.this.getSlot().getWidth() == 0 ? ScreenUtil.dw(CSJSplashAOL2.this.getActivity()) : CSJSplashAOL2.this.getSlot().getWidth(), CSJSplashAOL2.this.getSlot().getHeight() == 0 ? ScreenUtil.dh(CSJSplashAOL2.this.getActivity()) : CSJSplashAOL2.this.getSlot().getHeight()).build();
                CSJSplashAOL2.this.startLoadTime();
                adManager.createAdNative(CSJSplashAOL2.this.getActivity()).loadSplashAd(build, CSJSplashAOL2.this, 5000);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadFail(CSJAdError cSJAdError) {
        loadFail(cSJAdError.getCode(), cSJAdError.getMsg());
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(cSJAdError.getCode(), cSJAdError.getMsg());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
        this.b = cSJSplashAd;
        cSJSplashAd.setSplashAdListener(this);
        loadSuccess();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(ViewGroup viewGroup) {
        if (this.b == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            }
        } else if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            viewGroup.addView(this.b.getSplashView());
        } else {
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, viewGroup, 1));
        }
    }
}
