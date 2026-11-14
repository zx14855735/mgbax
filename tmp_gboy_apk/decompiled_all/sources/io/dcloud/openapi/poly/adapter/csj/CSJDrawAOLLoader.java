package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.AdSizeUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJDrawAOLLoader extends DCBaseAOLLoader implements TTAdNative.NativeExpressAdListener, TTAdNative.DrawFeedAdListener {

    /* renamed from: a, reason: collision with root package name */
    public String f13945a;

    public CSJDrawAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void init(String str, String str2) {
        this.f13945a = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final boolean isValid() {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void load() {
        startLoadTime();
        CSJInit.getInstance().init(getActivity(), this.f13945a, getType(), new TTAdSdk.InitCallback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJDrawAOLLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
                CSJDrawAOLLoader.this.loadFail(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                int convertSize = (int) AdSizeUtil.convertSize(CSJDrawAOLLoader.this.getSlot().getWidth(), CSJDrawAOLLoader.this.getActivity(), true, false);
                int convertSize2 = (int) AdSizeUtil.convertSize(CSJDrawAOLLoader.this.getSlot().getHeight(), CSJDrawAOLLoader.this.getActivity(), true, false);
                TTAdManager adManager = TTAdSdk.getAdManager();
                AdSlot build = new AdSlot.Builder().setAdCount(CSJDrawAOLLoader.this.getSlot().getCount()).setCodeId(CSJDrawAOLLoader.this.getSlotId()).setExpressViewAcceptedSize(convertSize, convertSize2).build();
                CSJDrawAOLLoader.this.startLoadTime();
                if (Const.TYPE_CSJ.equals(CSJDrawAOLLoader.this.getType())) {
                    adManager.createAdNative(CSJDrawAOLLoader.this.getActivity()).loadExpressDrawFeedAd(build, CSJDrawAOLLoader.this);
                } else {
                    adManager.createAdNative(CSJDrawAOLLoader.this.getActivity()).loadDrawFeedAd(build, CSJDrawAOLLoader.this);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
    public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
        if (list == null || list.size() == 0) {
            loadFail(-20001, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTDrawFeedAd tTDrawFeedAd : list) {
            CSJDrawAOLEntry cSJDrawAOLEntry = new CSJDrawAOLEntry(getSlot(), getActivity());
            cSJDrawAOLEntry.setAdEntry(tTDrawFeedAd);
            arrayList.add(cSJDrawAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list == null || list.size() == 0) {
            loadFail(-20001, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTNativeExpressAd tTNativeExpressAd : list) {
            CSJDrawAOLEntry cSJDrawAOLEntry = new CSJDrawAOLEntry(getSlot(), getActivity());
            cSJDrawAOLEntry.setAdEntry(tTNativeExpressAd);
            arrayList.add(cSJDrawAOLEntry);
        }
        loadSuccess(arrayList);
    }
}
