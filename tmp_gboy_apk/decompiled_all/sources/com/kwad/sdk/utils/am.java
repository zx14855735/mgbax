package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class am {
    private static String beO;
    private static boolean beP;

    public static String dl(Context context) {
        Cursor cursor;
        if (!TextUtils.isEmpty(beO) || beP || !bb.Tb()) {
            return beO;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                beO = j(cursor);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        beP = TextUtils.isEmpty(beO);
        return beO;
    }

    public static boolean dm(Context context) {
        Cursor cursor;
        boolean z = false;
        if (!bb.Tb()) {
            return false;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
        } catch (Throwable unused) {
            cursor = null;
        }
        try {
            z = k(cursor);
        } catch (Throwable unused2) {
            try {
                com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                if (!z) {
                    com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
                }
                return z;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
        }
        if (!z && bb.Tb()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return z;
    }

    public static boolean hp(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }

    private static String j(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }

    private static boolean k(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }
}
