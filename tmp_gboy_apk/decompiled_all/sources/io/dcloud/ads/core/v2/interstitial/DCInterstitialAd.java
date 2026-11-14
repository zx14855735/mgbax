package io.dcloud.ads.core.v2.interstitial;

import android.app.Activity;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aa0aaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aa0aaaaa.aaaaaaao;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCInterstitialAd extends aaaaaaaa {
    public DCInterstitialAd(Activity activity) {
        super(activity);
    }

    public void load(DCloudAdSlot dCloudAdSlot, final DCInterstitialAdLoadListener dCInterstitialAdLoadListener) {
        super.load(dCloudAdSlot.getSlot(), new aaaaaaao() { // from class: io.dcloud.ads.core.v2.interstitial.DCInterstitialAd.1
            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aa0aaaaa.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
            public void onError(int i, String str, JSONArray jSONArray) {
                DCInterstitialAdLoadListener dCInterstitialAdLoadListener2 = dCInterstitialAdLoadListener;
                if (dCInterstitialAdLoadListener2 != null) {
                    dCInterstitialAdLoadListener2.onError(i, str, jSONArray);
                }
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aa0aaaaa.aaaaaaao
            public void onInterstitialAOLLoad() {
                DCInterstitialAdLoadListener dCInterstitialAdLoadListener2 = dCInterstitialAdLoadListener;
                if (dCInterstitialAdLoadListener2 != null) {
                    dCInterstitialAdLoadListener2.onInterstitialAdLoad();
                }
            }
        });
    }

    public void setInterstitialAdListener(DCInterstitialAdListener dCInterstitialAdListener) {
        super.setInterstitialAOLListener(dCInterstitialAdListener);
    }
}
