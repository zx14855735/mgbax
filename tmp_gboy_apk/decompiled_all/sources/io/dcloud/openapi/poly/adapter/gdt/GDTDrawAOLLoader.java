package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTDrawAOLLoader extends DCBaseAOLLoader implements NativeADUnifiedListener {
    public GDTDrawAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
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
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTDrawAOLLoader.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                GDTDrawAOLLoader.this.loadFail(-4001, exc.getMessage());
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                new NativeUnifiedAD(GDTDrawAOLLoader.this.getActivity(), GDTDrawAOLLoader.this.getSlotId(), GDTDrawAOLLoader.this).loadData(GDTDrawAOLLoader.this.getSlot().getCount());
            }
        });
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        if (list == null || list.size() == 0) {
            loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeUnifiedADData nativeUnifiedADData : list) {
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                GDTDrawAOLEntry gDTDrawAOLEntry = new GDTDrawAOLEntry(getSlot(), getActivity());
                gDTDrawAOLEntry.setAdEntry(nativeUnifiedADData);
                if (isSlotSupportBidding()) {
                    gDTDrawAOLEntry.setBiddingECPM(nativeUnifiedADData.getECPM());
                }
                arrayList.add(gDTDrawAOLEntry);
            }
        }
        if (arrayList.size() == 0) {
            loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
        } else {
            loadSuccess(arrayList);
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        loadFail(adError.getErrorCode(), adError.getErrorMsg());
    }
}
