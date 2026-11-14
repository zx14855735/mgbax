package com.sigmob.windad.rewardVideo;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindRewardAdRequest extends WindAdRequest {
    private boolean b;
    private boolean c;

    public WindRewardAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map, 1);
    }

    public static WindRewardAdRequest getWindVideoAdRequest(WindAdRequest windAdRequest) {
        if (windAdRequest == null) {
            return null;
        }
        return new WindRewardAdRequest(windAdRequest.getPlacementId(), windAdRequest.getUserId(), windAdRequest.getOptions());
    }

    public boolean isEnableKeepOn() {
        return this.c;
    }

    public boolean isEnableScreenLockDisPlayAd() {
        return this.b;
    }

    public void setEnableKeepOn(boolean z) {
        this.c = z;
    }

    public void setEnableScreenLockDisPlayAd(boolean z) {
        this.b = z;
    }
}
