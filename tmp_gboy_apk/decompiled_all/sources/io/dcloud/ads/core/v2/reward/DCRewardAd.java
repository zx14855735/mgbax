package io.dcloud.ads.core.v2.reward;

import android.app.Activity;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaao;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCRewardAd extends aaaaaaaa {
    public DCRewardAd(Activity activity) {
        super(activity);
    }

    public void load(DCloudAdSlot dCloudAdSlot, final DCRewardAdLoadListener dCRewardAdLoadListener) {
        super.load(dCloudAdSlot.getSlot(), new aaaaaaao() { // from class: io.dcloud.ads.core.v2.reward.DCRewardAd.1
            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
            public void onError(int i, String str, JSONArray jSONArray) {
                DCRewardAdLoadListener dCRewardAdLoadListener2 = dCRewardAdLoadListener;
                if (dCRewardAdLoadListener2 != null) {
                    dCRewardAdLoadListener2.onError(i, str, jSONArray);
                }
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaao
            public void onRewardAOLLoad() {
                DCRewardAdLoadListener dCRewardAdLoadListener2 = dCRewardAdLoadListener;
                if (dCRewardAdLoadListener2 != null) {
                    dCRewardAdLoadListener2.onRewardAdLoad();
                }
            }
        });
    }

    public void setRewardAdListener(DCRewardAdListener dCRewardAdListener) {
        super.setRewardAOLListener(dCRewardAdListener);
    }
}
