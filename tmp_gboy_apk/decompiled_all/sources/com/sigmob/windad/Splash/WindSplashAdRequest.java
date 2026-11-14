package com.sigmob.windad.Splash;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindSplashAdRequest extends WindAdRequest {
    private int b;
    private boolean c;

    public WindSplashAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map, 2);
        this.b = 5;
        this.c = false;
    }

    public int getFetchDelay() {
        return Math.max(this.b, 3);
    }

    public boolean isDisableAutoHideAd() {
        return this.c;
    }

    public void setDisableAutoHideAd(boolean z) {
        this.c = z;
    }

    public void setFetchDelay(int i) {
        this.b = i;
    }
}
