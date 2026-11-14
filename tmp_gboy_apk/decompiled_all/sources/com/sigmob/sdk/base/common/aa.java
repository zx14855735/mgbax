package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aa {
    private static final HashMap<String, aa> d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public int f13097a;
    public int b;
    public String c;

    static {
        WbdHUMr();
    }

    private static /* synthetic */ void WbdHUMr() {
        char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 166);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 166);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized aa a(String str) {
        synchronized (aa.class) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            aa aaVar = d.get(str);
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.c = str;
                try {
                    cursor = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event where adslot_id = '" + str + "' group by adslot_id", null);
                    a(aaVar, cursor);
                } catch (Throwable th) {
                    try {
                        SigmobLog.e(th.getMessage());
                        if (cursor != null && !cursor.isClosed()) {
                        }
                    } finally {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    }
                }
                d.put(str, aaVar);
            }
            return aaVar;
        }
    }

    public static void c() {
        try {
            Cursor rawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event", null);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            do {
                aa aaVar = new aa();
                aaVar.c = rawQuery.getString(rawQuery.getColumnIndexOrThrow("adslot_id"));
                aaVar.f13097a = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("media_request_count"));
                aaVar.b = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("media_ready_count"));
                arrayList.add(aaVar);
                d.put(aaVar.c, aaVar);
            } while (rawQuery.moveToNext());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void b() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        this.f13097a = 0;
        this.b = 0;
        b(this.c);
    }

    public static HashMap<String, aa> a() {
        return d;
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.h, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private static void a(aa aaVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            aaVar.f13097a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            aaVar.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
        } while (cursor.moveToNext());
    }

    public static void a(final String str, aa aaVar) {
        if (TextUtils.isEmpty(str) || aaVar == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.h);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("media_request_count", Integer.valueOf(aaVar.f13097a));
            hashMap.put("media_ready_count", Integer.valueOf(aaVar.b));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0448a() { // from class: com.sigmob.sdk.base.common.aa.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a() {
                    SigmobLog.d(str + " insert load cache event " + str + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a(Throwable th) {
                    SigmobLog.e(str + " insert  load cache event " + str + " onFailed: ", th);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
