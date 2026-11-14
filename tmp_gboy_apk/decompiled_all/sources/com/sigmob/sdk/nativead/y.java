package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.network.e;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13624a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private List<BaseAdUnit> h;
    private aa i;
    private final WindNativeAdRequest j;
    private boolean k;
    private final Handler g = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.y.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 20481 && y.this.k) {
                y.this.g.removeMessages(20481);
                y yVar = y.this;
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_TIME_OUT;
                yVar.a((List<WindNativeAdData>) null, windAdError.getErrorCode(), windAdError.getMessage());
            }
        }
    };
    private final int l = 20481;

    public y(WindNativeAdRequest windNativeAdRequest, aa aaVar) {
        this.j = windNativeAdRequest;
        this.i = aaVar;
    }

    public int a(int i, String str, int i2, String str2, String str3) {
        WindAdError windAdError;
        int i3 = 1;
        this.k = true;
        com.sigmob.sdk.base.common.z a2 = com.sigmob.sdk.base.common.z.a(this.j.getPlacementId());
        LoadAdRequest loadAdRequest = new LoadAdRequest(this.j);
        loadAdRequest.setBidToken(str);
        loadAdRequest.setBidFloor(i2);
        loadAdRequest.setCurrency(str2);
        loadAdRequest.setAd_count(i);
        loadAdRequest.setTraceId(str3);
        a2.f13166a++;
        com.sigmob.sdk.base.common.aa a3 = com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId());
        a3.f13097a++;
        if (i < 1) {
            windAdError = WindAdError.ERROR_SIGMOB_NATIVE_ADCOUNT;
        } else {
            long j = a2.g;
            if (j <= 0 || (a2.d * 1000) + j <= System.currentTimeMillis()) {
                this.g.sendEmptyMessageDelayed(20481, com.sigmob.sdk.base.o.a().C());
                a2.g = System.currentTimeMillis();
                com.sigmob.sdk.base.network.e.a(loadAdRequest, this);
                com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a2);
                com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId(), a3);
                return i3;
            }
            List<BaseAdUnit> a4 = com.sigmob.sdk.base.common.h.a(this.j.getPlacementId(), a2.f, i);
            if (!a4.isEmpty()) {
                this.h = a4;
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < a4.size(); i4++) {
                    BaseAdUnit baseAdUnit = a4.get(i4);
                    baseAdUnit.setLoad_id(loadAdRequest.getLoadId());
                    arrayList.add(a(baseAdUnit));
                    if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
                        com.sigmob.sdk.base.common.h.g().f(baseAdUnit);
                    }
                }
                a(this.h.get(0), loadAdRequest);
                a2.b = a4.size() + a2.b;
                a3.b = a4.size() + a3.b;
                a(arrayList, 0, (String) null);
                i3 = 0;
                com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a2);
                com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId(), a3);
                return i3;
            }
            windAdError = WindAdError.ERROR_NO_AD;
        }
        a((List<WindNativeAdData>) null, windAdError.getErrorCode(), windAdError.getMessage());
        i3 = 0;
        com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a2);
        com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId(), a3);
        return i3;
    }

    private WindNativeAdData a(BaseAdUnit baseAdUnit) {
        return new ag(baseAdUnit);
    }

    public Map<String, BiddingResponse> b() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }

    public String a() {
        BaseAdUnit baseAdUnit;
        BiddingResponse biddingResponse;
        List<BaseAdUnit> list = this.h;
        if (list == null || list.isEmpty() || (baseAdUnit = this.h.get(0)) == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
            return null;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        com.sigmob.sdk.base.common.ae.a(PointCategory.RESPOND, Constants.FAIL, loadAdRequest);
        a((List<WindNativeAdData>) null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, List list, String str) {
        aa aaVar = this.i;
        if (aaVar == null) {
            return;
        }
        if (i == 0) {
            aaVar.onNativeAdLoaded(list);
        } else {
            aaVar.onNativeAdLoadFail(i, str);
        }
    }

    public void a(BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest) {
        com.sigmob.sdk.base.common.ae.a(PointCategory.READY, (String) null, baseAdUnit, loadAdRequest, (ae.a) null);
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<WindNativeAdData> list, int i, String str) {
        this.k = false;
        this.g.removeMessages(20481);
        this.g.post(new FZu94u.A2egSU(this, i, list, str, 1));
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        if (com.sigmob.sdk.base.utils.e.a(list)) {
            WindAdError windAdError = WindAdError.ERROR_NO_AD;
            a((List<WindNativeAdData>) null, windAdError.getErrorCode(), windAdError.getMessage());
            return;
        }
        com.sigmob.sdk.base.common.ae.a(PointCategory.RESPOND, "1", list.get(0), loadAdRequest, new AMqCpz(list));
        com.sigmob.sdk.base.common.z a2 = com.sigmob.sdk.base.common.z.a(this.j.getPlacementId());
        if (a2 != null && a2.e > 0) {
            list = com.sigmob.sdk.base.common.h.a(this.j.getPlacementId(), a2.f, this.j.getAdCount());
            if (com.sigmob.sdk.base.utils.e.a(list)) {
                this.h = null;
                WindAdError windAdError2 = WindAdError.ERROR_NO_AD;
                a((List<WindNativeAdData>) null, windAdError2.getErrorCode(), windAdError2.getMessage());
                return;
            }
        }
        this.h = list;
        com.sigmob.sdk.base.common.aa a3 = com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId());
        a2.b = this.h.size() + a2.b;
        a3.b = this.h.size() + a3.b;
        com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a2);
        com.sigmob.sdk.base.common.aa.a(this.j.getPlacementId(), a3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.h.size(); i++) {
            BaseAdUnit baseAdUnit = this.h.get(i);
            arrayList.add(a(baseAdUnit));
            if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
                com.sigmob.sdk.base.common.h.g().f(baseAdUnit);
            }
        }
        a(this.h.get(0), loadAdRequest);
        a(arrayList, 0, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put(PointParamKey.AD_COUNT, String.valueOf(list.size()));
            pointEntitySigmob.setOptions(options);
        }
    }
}
