package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class l {
    private Context mContext;

    public l(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID oaid:" + str);
            }
            return str;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return str;
        } finally {
            h.closeQuietly(cursor);
        }
    }
}
