package com.octopus.ad;

import com.octopus.ad.model.OctLocation;
import com.octopus.ad.model.ShakeValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class OctopusAdSdkController {
    public String getImei() {
        return "";
    }

    public OctLocation getLocation() {
        return null;
    }

    public String getOaid() {
        return "";
    }

    public ShakeValue getShakeValue() {
        return null;
    }

    public boolean isCanShake() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }
}
