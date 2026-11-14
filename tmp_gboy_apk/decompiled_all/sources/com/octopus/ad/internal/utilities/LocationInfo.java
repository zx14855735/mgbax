package com.octopus.ad.internal.utilities;

import com.octopus.ad.model.OctLocation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LocationInfo {
    private static LocationInfo sUserEnvInfoInstance;
    public boolean locationEnabled = true;
    private int mLocationDecimalDigits = -1;
    public OctLocation octLocation;

    private LocationInfo() {
    }

    public static LocationInfo getInstance() {
        LocationInfo locationInfo;
        synchronized (LocationInfo.class) {
            try {
                if (sUserEnvInfoInstance == null) {
                    sUserEnvInfoInstance = new LocationInfo();
                }
                locationInfo = sUserEnvInfoInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return locationInfo;
    }

    public int getLocationDecimalDigits() {
        return this.mLocationDecimalDigits;
    }

    public void setLocationDecimalDigits(int i) {
        if (i > 6) {
            this.mLocationDecimalDigits = 6;
            HaoboLog.w(HaoboLog.baseLogTag, "Out of range input " + i + ", set location digits after decimal to maximum 6");
            return;
        }
        if (i >= -1) {
            this.mLocationDecimalDigits = i;
            return;
        }
        this.mLocationDecimalDigits = -1;
        HaoboLog.w(HaoboLog.baseLogTag, "Negative input " + i + ", set location digits after decimal to default");
    }
}
