package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.AdSizeUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDFlowAOLLoader extends DCBaseAOLLoader implements BaiduNativeManager.ExpressAdListener {
    public BDFlowAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final String getType() {
        return Const.TYPE_BD;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void init(String str, String str2) {
        BDInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final boolean isValid() {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void load() {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(getActivity(), getSlotId());
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.setWidth((int) AdSizeUtil.convertSize(getSlot().getWidth(), getActivity(), true, true));
        baiduNativeManager.loadExpressAd(builder.build(), this);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNativeFail(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNativeLoad(List<ExpressResponse> list) {
        int parseInt;
        if (list == null || list.size() == 0) {
            loadFail(-200000, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ExpressResponse expressResponse : list) {
            BDFeedAOLEntry bDFeedAOLEntry = new BDFeedAOLEntry(getSlot(), getActivity());
            bDFeedAOLEntry.setAdEntry(expressResponse);
            if (isSlotSupportBidding()) {
                String eCPMLevel = expressResponse.getECPMLevel();
                if (!TextUtils.isEmpty(eCPMLevel)) {
                    try {
                        parseInt = Integer.parseInt(eCPMLevel);
                    } catch (Exception unused) {
                    }
                    bDFeedAOLEntry.setBiddingECPM(parseInt);
                }
                parseInt = -1;
                bDFeedAOLEntry.setBiddingECPM(parseInt);
            }
            arrayList.add(bDFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNoAd(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onVideoDownloadFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onVideoDownloadSuccess() {
    }
}
