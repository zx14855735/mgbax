package com.kwad.sdk.liteapi.oaid.helpers;

import A5SV6n.A2egSU;
import android.content.Context;
import com.kwad.sdk.liteapi.LiteApiLogger;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Context mContext;

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        Exception e;
        String str;
        try {
            str = (String) OaidJavaCalls.callMethod(OaidJavaCalls.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
        try {
            LiteApiLogger.i(TAG, "getOAID oaid:" + str);
            return str;
        } catch (Exception e3) {
            e = e3;
            LiteApiLogger.i(TAG, "getOAID fail");
            LiteApiLogger.printStackTraceOnly(e);
            return str;
        }
    }
}
