package io.dcloud.ads.core.v2.splash;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import io.dcloud.ads.core.entry.SplashConfig;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaac;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCSplashAd extends aaaaaaa0 {
    public DCSplashAd(Activity activity) {
        super(activity);
    }

    public void load(SplashConfig splashConfig, final DCSplashAdLoadListener dCSplashAdLoadListener) {
        super.load(splashConfig.getConfig(), new aaaaaaac() { // from class: io.dcloud.ads.core.v2.splash.DCSplashAd.1
            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaac, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
            public void onError(int i, String str, JSONArray jSONArray) {
                DCSplashAdLoadListener dCSplashAdLoadListener2 = dCSplashAdLoadListener;
                if (dCSplashAdLoadListener2 != null) {
                    dCSplashAdLoadListener2.onError(i, str, jSONArray);
                }
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaac
            public void onSplashAOLLoad() {
                DCSplashAdLoadListener dCSplashAdLoadListener2 = dCSplashAdLoadListener;
                if (dCSplashAdLoadListener2 != null) {
                    dCSplashAdLoadListener2.onSplashAdLoad();
                }
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaac
            public void redBag(View view, FrameLayout.LayoutParams layoutParams) {
                DCSplashAdLoadListener dCSplashAdLoadListener2 = dCSplashAdLoadListener;
                if (dCSplashAdLoadListener2 != null) {
                    dCSplashAdLoadListener2.redBag(view, layoutParams);
                }
            }
        });
    }

    public void setSplashAdListener(DCSplashAdListener dCSplashAdListener) {
        super.setSplashAOLListener(dCSplashAdListener);
    }
}
