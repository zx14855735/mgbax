package io.dcloud.ads.core.v2.fullscreen;

import android.app.Activity;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa.aaaaaaao;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCFullScreenAd extends aaaaaaaa {
    public DCFullScreenAd(Activity activity) {
        super(activity);
    }

    public void load(DCloudAdSlot dCloudAdSlot, final DCFullScreenAdLoadListener dCFullScreenAdLoadListener) {
        super.load(dCloudAdSlot.getSlot(), new aaaaaaao() { // from class: io.dcloud.ads.core.v2.fullscreen.DCFullScreenAd.1
            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
            public void onError(int i, String str, JSONArray jSONArray) {
                DCFullScreenAdLoadListener dCFullScreenAdLoadListener2 = dCFullScreenAdLoadListener;
                if (dCFullScreenAdLoadListener2 != null) {
                    dCFullScreenAdLoadListener2.onError(i, str, jSONArray);
                }
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa.aaaaaaao
            public void onFullScreenAOLLoad() {
                DCFullScreenAdLoadListener dCFullScreenAdLoadListener2 = dCFullScreenAdLoadListener;
                if (dCFullScreenAdLoadListener2 != null) {
                    dCFullScreenAdLoadListener2.onFullScreenAdLoad();
                }
            }
        });
    }

    public void setFullScreenAdListener(DCFullScreenAdListener dCFullScreenAdListener) {
        super.setFullScreenAOLListener(dCFullScreenAdListener);
    }
}
