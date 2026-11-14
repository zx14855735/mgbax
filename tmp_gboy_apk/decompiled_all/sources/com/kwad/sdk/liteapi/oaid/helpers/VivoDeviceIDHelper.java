package com.kwad.sdk.liteapi.oaid.helpers;

import A5SV6n.A2egSU;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.liteapi.LiteApiLogger;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class VivoDeviceIDHelper {
    private static final String TAG = "VivoDeviceIDHelper";
    private Context mContext;

    public VivoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                LiteApiLogger.i(TAG, "getOAID oaid:" + str);
            }
            return str;
        } catch (Exception e) {
            LiteApiLogger.i(TAG, "getOAID fail");
            LiteApiLogger.printStackTraceOnly(e);
            return str;
        } finally {
            OaidInnerUtils.closeQuietly(cursor);
        }
    }
}
