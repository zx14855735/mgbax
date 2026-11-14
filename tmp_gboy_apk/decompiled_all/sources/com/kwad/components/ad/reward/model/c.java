package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean jk = com.kwad.components.ad.reward.a.b.hO();

    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (e.HV()) {
            ksVideoPlayConfig = com.kwad.components.core.internal.api.e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData d = f.oy().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (d == null) {
                return null;
            }
            return a(d, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!e.HV() && com.kwad.sdk.core.response.b.e.eH(adTemplate) < 0) {
            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(com.kwad.sdk.core.response.b.a.L(adInfo));
            if (cr == null || !cr.exists()) {
                return false;
            }
        }
        return true;
    }

    public final AdInfo cT() {
        return this.mAdInfo;
    }

    public final boolean cU() {
        return com.kwad.sdk.core.response.b.e.eD(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean it() {
        return com.kwad.sdk.core.response.b.e.k(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(cT()));
    }

    public final boolean iu() {
        return com.kwad.sdk.core.response.b.e.O(getAdTemplate());
    }

    public final AdResultData iv() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig iw() {
        return this.mVideoPlayConfig;
    }

    public final int ix() {
        return this.rewardType;
    }

    public final JSONObject iy() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo iz() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    private static c a(AdResultData adResultData, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate r = com.kwad.sdk.core.response.b.c.r(adResultData);
        if (r == null) {
            com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo er = com.kwad.sdk.core.response.b.e.er(r);
        if (!c(r, er)) {
            return null;
        }
        boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
        r.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = r;
        cVar.mAdInfo = er;
        cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
        cVar.rewardType = i;
        return cVar;
    }
}
