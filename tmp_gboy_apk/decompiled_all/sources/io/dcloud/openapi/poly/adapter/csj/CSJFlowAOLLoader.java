package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.AdSizeUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJFlowAOLLoader extends DCBaseAOLLoader implements TTAdNative.NativeExpressAdListener, TTAdNative.FeedAdListener {

    /* renamed from: a, reason: collision with root package name */
    public String f13950a;

    public CSJFlowAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        this.f13950a = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        CSJInit.getInstance().init(getActivity(), this.f13950a, getType(), new TTAdSdk.InitCallback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJFlowAOLLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
                CSJFlowAOLLoader.this.loadFail(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(CSJFlowAOLLoader.this.getActivity());
                AdSlot build = new AdSlot.Builder().setCodeId(CSJFlowAOLLoader.this.getSlotId()).setSupportDeepLink(true).setImageAcceptedSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).setAdCount(CSJFlowAOLLoader.this.getSlot().getCount()).setExpressViewAcceptedSize((int) AdSizeUtil.convertSize(CSJFlowAOLLoader.this.getSlot().getWidth(), CSJFlowAOLLoader.this.getActivity(), true, true), 0.0f).build();
                CSJFlowAOLLoader.this.startLoadTime();
                if (!Const.TYPE_CSJ.equals(CSJFlowAOLLoader.this.getType())) {
                    createAdNative.loadFeedAd(build, CSJFlowAOLLoader.this);
                } else if (CSJFlowAOLLoader.this.isExpressAd()) {
                    createAdNative.loadNativeExpressAd(build, CSJFlowAOLLoader.this);
                } else {
                    CSJFlowAOLLoader.this.loadFail(200002, AOLErrorUtil.getErrorMsg(200002));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        if (list == null || list.size() <= 0) {
            loadFail(-20001, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTFeedAd tTFeedAd : list) {
            CSJFeedAOLEntry cSJFeedAOLEntry = new CSJFeedAOLEntry(getSlot(), getActivity());
            cSJFeedAOLEntry.setAdEntry(tTFeedAd);
            cSJFeedAOLEntry.setExpressAd(isExpressAd());
            arrayList.add(cSJFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list == null || list.size() <= 0) {
            loadFail(-20001, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTNativeExpressAd tTNativeExpressAd : list) {
            CSJFeedAOLEntry cSJFeedAOLEntry = new CSJFeedAOLEntry(getSlot(), getActivity());
            cSJFeedAOLEntry.setAdEntry(tTNativeExpressAd);
            cSJFeedAOLEntry.setExpressAd(isExpressAd());
            arrayList.add(cSJFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }
}
