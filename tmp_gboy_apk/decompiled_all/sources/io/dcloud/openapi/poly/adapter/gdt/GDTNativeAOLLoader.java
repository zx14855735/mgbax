package io.dcloud.openapi.poly.adapter.gdt;

import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class GDTNativeAOLLoader implements NativeADUnifiedListener {

    /* renamed from: a, reason: collision with root package name */
    public final DCBaseAOLLoader f13973a;

    public GDTNativeAOLLoader(DCBaseAOLLoader dCBaseAOLLoader) {
        this.f13973a = dCBaseAOLLoader;
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        if (list == null || list.size() == 0) {
            this.f13973a.loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeUnifiedADData nativeUnifiedADData : list) {
            GDTFeedAOLEntry gDTFeedAOLEntry = new GDTFeedAOLEntry(this.f13973a.getSlot(), this.f13973a.getActivity());
            gDTFeedAOLEntry.setAdEntry(nativeUnifiedADData);
            if (this.f13973a.isSlotSupportBidding()) {
                gDTFeedAOLEntry.setBiddingECPM(nativeUnifiedADData.getECPM());
            }
            arrayList.add(gDTFeedAOLEntry);
        }
        this.f13973a.loadSuccess(arrayList);
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        this.f13973a.loadFail(adError.getErrorCode(), adError.getErrorMsg());
    }
}
