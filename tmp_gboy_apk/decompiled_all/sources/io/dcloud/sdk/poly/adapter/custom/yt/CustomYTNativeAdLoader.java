package io.dcloud.sdk.poly.adapter.custom.yt;

import Dphsd2.AlLFFp;
import DuwtYk.A5SV6n;
import DuwtYk.AMqCpz;
import DuwtYk.ARc23Z;
import DvK7DB.A2egSU;
import H0qugq.AZkASS;
import android.app.Activity;
import android.content.Context;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAdLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTNativeAdLoader extends UniAdCustomNativeAdLoader {
    private static final String TAG = "CustomYTNativeAdLoader";
    private A5SV6n saAllianceAd;

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$load$0(UniAdSlot uniAdSlot, final Activity activity) {
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f2478A2egSU = uniAdSlot.getSlotId();
        aMqCpz.f2479A4TApA = px2dp(activity, uniAdSlot.getWidth());
        aMqCpz.f2480A5SV6n = 0;
        int i = ARc23Z.f2485A2egSU;
        new EY4UKY.ARc23Z();
        EY4UKY.AMqCpz A2egSU2 = EY4UKY.ARc23Z.A2egSU(activity);
        this.saAllianceAd = A2egSU2;
        A2egSU2.A5SV6n(aMqCpz, 3, -1, new DvK7DB.A5SV6n() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTNativeAdLoader.1
            @Override // DuwtYk.A2egSU
            public void onError(int i2, String str) {
                CustomYTNativeAdLoader.this.onLoadFail(i2, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // DvK7DB.A5SV6n
            public void onExpressFeedAdLoad(List<A2egSU> list) {
                if (list == null || list.isEmpty()) {
                    CustomYTNativeAdLoader.this.onLoadFail(36222434, "加载失败，广告为空");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (A2egSU a2egSU : list) {
                    CustomYTNativeAd customYTNativeAd = new CustomYTNativeAd(activity, a2egSU, CustomYTNativeAdLoader.this.saAllianceAd);
                    try {
                        if (CustomYTNativeAdLoader.this.getBidType() == 1) {
                            CustomYTNativeAdLoader.this.setBidPrice(Integer.parseInt(((AZkASS) a2egSU).f3255A2egSU));
                        }
                    } catch (Exception unused) {
                        String str = ((AZkASS) a2egSU).f3255A2egSU;
                    }
                    arrayList.add(customYTNativeAd);
                }
                CustomYTNativeAdLoader.this.onLoadSuccess(arrayList);
            }

            @Override // DuwtYk.A2egSU
            public void onResourceLoad() {
            }
        });
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (uniAdSlot == null || uniAdSlot.getSlotId() == null || uniAdSlot.getSlotId().isEmpty()) {
            onLoadFail(36222431, "posId无效");
        } else if (activity == null) {
            onLoadFail(36222432, "activity为空");
        } else {
            ThreadUtils.runOnThreadPool(new AlLFFp(13, this, uniAdSlot, activity));
        }
    }
}
