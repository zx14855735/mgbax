package com.czhj.sdk.common.mta;

import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.network.Networking;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class PointEntityCommon extends PointEntitySuper {
    public String getBattery_level() {
        return String.format("%.2f", ClientMetadata.getInstance().getBatteryLevel());
    }

    public String getBattery_save_enabled() {
        return String.valueOf(ClientMetadata.getInstance().getBatterySaveEnable());
    }

    public String getBattery_state() {
        return String.valueOf(ClientMetadata.getInstance().getBatteryState());
    }

    public String getBrand() {
        return ClientMetadata.getDeviceBrand();
    }

    public String getBrowser() {
        return Networking.getUserAgent();
    }

    public String getCheight() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenHeightDip());
    }

    public String getClientpixel() {
        return ClientMetadata.getInstance().getDisplayMetrics().widthPixels + "x" + ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
    }

    public String getClienttype() {
        return ClientMetadata.getDeviceModel();
    }

    public String getCwidth() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenWidthDip());
    }

    public String getDevice_type() {
        return ClientMetadata.getInstance().isTablet() ? "5" : "4";
    }

    public String getDheight() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
    }

    public String getDwidth() {
        return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
    }

    public String getIsEmulator() {
        return ClientMetadata.isEmulator() ? "1" : Constants.FAIL;
    }

    public String getLat() {
        DeviceContext deviceContext = getDeviceContext();
        Location location = deviceContext != null ? deviceContext.getLocation() : ClientMetadata.getInstance().getLocation();
        if (location != null) {
            return String.valueOf(location.getLatitude());
        }
        return null;
    }

    public String getLng() {
        DeviceContext deviceContext = getDeviceContext();
        Location location = deviceContext != null ? deviceContext.getLocation() : ClientMetadata.getInstance().getLocation();
        if (location != null) {
            return String.valueOf(location.getLongitude());
        }
        return null;
    }

    public String getPkgname() {
        return ClientMetadata.getInstance().getAppPackageName();
    }

    public String getResolution() {
        return ClientMetadata.getInstance().getRealMetrics().widthPixels + "x" + ClientMetadata.getInstance().getRealMetrics().heightPixels;
    }

    public String getScreenangle() {
        return String.valueOf(Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90);
    }

    public String getScreendensity() {
        return String.valueOf(ClientMetadata.getInstance().getDensityDpi());
    }

    public String getTargetSdkVersion() {
        return ClientMetadata.getInstance().getTargetSdkVersion();
    }

    public String getVender() {
        return ClientMetadata.getDeviceManufacturer();
    }

    public String getWifi_id() {
        String wifiName = ClientMetadata.getInstance().getWifiName();
        return TextUtils.isEmpty(wifiName) ? wifiName : Base64.encodeToString(ClientMetadata.getInstance().getWifiName().getBytes(), 2);
    }

    public String getWifi_mac() {
        return ClientMetadata.getInstance().getWifimac();
    }
}
