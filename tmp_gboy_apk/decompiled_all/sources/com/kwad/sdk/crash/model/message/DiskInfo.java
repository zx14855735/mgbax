package com.kwad.sdk.crash.model.message;

import B4ZgIw.AYUAbz;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DiskInfo implements b, Serializable {
    private static final long serialVersionUID = -154725647775465930L;
    public double mDataAvailableGB;
    public double mDataTotalGB;
    public double mExternalStorageAvailableGB;
    public double mExternalStorageTotalGB;

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mDataTotalGB = jSONObject.optDouble("mDataTotalGB");
        this.mDataAvailableGB = jSONObject.optDouble("mDataAvailableGB");
        this.mExternalStorageTotalGB = jSONObject.optDouble("mExternalStorageTotalGB");
        this.mExternalStorageAvailableGB = jSONObject.optDouble("mExternalStorageAvailableGB");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "mDataTotalGB", this.mDataTotalGB);
        aa.putValue(jSONObject, "mDataAvailableGB", this.mDataAvailableGB);
        aa.putValue(jSONObject, "mExternalStorageTotalGB", this.mExternalStorageTotalGB);
        aa.putValue(jSONObject, "mExternalStorageAvailableGB", this.mExternalStorageAvailableGB);
        return jSONObject;
    }

    public String toString() {
        StringBuilder A4TApA2 = AYUAbz.A4TApA("\t总存储空间: ");
        A4TApA2.append(this.mDataTotalGB);
        A4TApA2.append(" (GB)\n\t可用存储空间: ");
        A4TApA2.append(this.mDataAvailableGB);
        A4TApA2.append(" (GB)\n\t总SD卡空间: ");
        A4TApA2.append(this.mExternalStorageTotalGB);
        A4TApA2.append(" (GB)\n\t可用SD卡空间: ");
        A4TApA2.append(this.mExternalStorageAvailableGB);
        A4TApA2.append(" (GB)\n");
        return A4TApA2.substring(0);
    }
}
