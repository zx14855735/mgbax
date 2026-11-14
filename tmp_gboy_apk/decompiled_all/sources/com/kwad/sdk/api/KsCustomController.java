package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.location.Location;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class KsCustomController {
    @KsAdSdkApi
    @A2egSU
    public boolean canReadInstalledPackages() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canReadLocation() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canUseMacAddress() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canUseNetworkState() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canUseOaid() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canUsePhoneState() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canUseStoragePermission() {
        return true;
    }

    @KsAdSdkApi
    @A2egSU
    public String getAndroidId() {
        return "";
    }

    @KsAdSdkApi
    @A2egSU
    public String getImei() {
        return "";
    }

    @KsAdSdkApi
    @A2egSU
    public String[] getImeis() {
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public List<String> getInstalledPackages() {
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public KsLocation getKsLocation() {
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    public Location getLocation() {
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public String getMacAddress() {
        return "";
    }

    @KsAdSdkApi
    @A2egSU
    public String getOaid() {
        return "";
    }
}
