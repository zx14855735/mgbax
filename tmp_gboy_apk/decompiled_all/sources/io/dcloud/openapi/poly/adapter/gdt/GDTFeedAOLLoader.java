package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.AdSizeUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTFeedAOLLoader extends DCBaseAOLLoader implements NativeExpressAD.NativeExpressADListener {
    public GDTFeedAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
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
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTFeedAOLLoader.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                GDTFeedAOLLoader.this.loadFail(-4001, exc.getMessage());
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                int convertSize = (int) AdSizeUtil.convertSize(GDTFeedAOLLoader.this.getSlot().getWidth(), GDTFeedAOLLoader.this.getActivity(), true, true);
                GDTFeedAOLLoader.this.startLoadTime();
                if (GDTFeedAOLLoader.this.isExpressAd()) {
                    new NativeExpressAD(GDTFeedAOLLoader.this.getActivity(), new ADSize(convertSize, -2), GDTFeedAOLLoader.this.getSlotId(), GDTFeedAOLLoader.this).loadAD(GDTFeedAOLLoader.this.getSlot().getCount());
                } else {
                    new NativeUnifiedAD(GDTFeedAOLLoader.this.getActivity(), GDTFeedAOLLoader.this.getSlotId(), new GDTNativeAOLLoader(GDTFeedAOLLoader.this)).loadData(GDTFeedAOLLoader.this.getSlot().getCount());
                }
            }
        });
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        GDTFeedAOLEntry gDTFeedAOLEntry = (GDTFeedAOLEntry) nativeExpressADView.getTag();
        if (gDTFeedAOLEntry.getFeedAdCallback() != null) {
            gDTFeedAOLEntry.getFeedAdCallback().onClicked();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        GDTFeedAOLEntry gDTFeedAOLEntry = (GDTFeedAOLEntry) nativeExpressADView.getTag();
        if (gDTFeedAOLEntry.getFeedAdCallback() != null) {
            gDTFeedAOLEntry.getFeedAdCallback().onClosed("");
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        GDTFeedAOLEntry gDTFeedAOLEntry = (GDTFeedAOLEntry) nativeExpressADView.getTag();
        if (gDTFeedAOLEntry.getFeedAdCallback() != null) {
            gDTFeedAOLEntry.getFeedAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        if (list == null || list.size() == 0) {
            loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeExpressADView nativeExpressADView : list) {
            GDTFeedAOLEntry gDTFeedAOLEntry = new GDTFeedAOLEntry(getSlot(), getActivity());
            gDTFeedAOLEntry.setAdEntry(nativeExpressADView);
            if (isSlotSupportBidding()) {
                gDTFeedAOLEntry.setBiddingECPM(nativeExpressADView.getECPM());
            }
            arrayList.add(gDTFeedAOLEntry);
            nativeExpressADView.setTag(gDTFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        loadFail(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        GDTFeedAOLEntry gDTFeedAOLEntry = (GDTFeedAOLEntry) nativeExpressADView.getTag();
        if (gDTFeedAOLEntry.getFeedAdCallback() != null) {
            gDTFeedAOLEntry.getFeedAdCallback().onRenderFail();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        GDTFeedAOLEntry gDTFeedAOLEntry = (GDTFeedAOLEntry) nativeExpressADView.getTag();
        if (gDTFeedAOLEntry.getFeedAdCallback() != null) {
            gDTFeedAOLEntry.getFeedAdCallback().onRenderSuccess();
        }
    }
}
