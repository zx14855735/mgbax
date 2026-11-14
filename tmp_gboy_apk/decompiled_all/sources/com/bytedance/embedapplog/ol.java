package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ol implements m {
    private xv<Boolean> xj = new xv<Boolean>() { // from class: com.bytedance.embedapplog.ol.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Boolean xj(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursor == null) {
                return null;
            }
            try {
                m.xj xjVar = new m.xj();
                xjVar.hf = xj(cursor);
                return xjVar;
            } catch (Throwable th) {
                th = th;
                try {
                    cu.xj(th);
                    return null;
                } finally {
                    no.xj(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        if (context == null) {
            return false;
        }
        return this.xj.hf(context).booleanValue();
    }

    private String xj(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
