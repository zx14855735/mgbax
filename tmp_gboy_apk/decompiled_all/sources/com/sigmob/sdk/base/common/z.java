package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class z {
    private static final HashMap<String, z> h = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public int f13166a;
    public int b;
    public long c;
    public int d = 0;
    public int e = 30;
    public int f;
    public long g;

    static {
        UlHgrKp();
    }

    private static /* synthetic */ void UlHgrKp() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized z a(String str) {
        synchronized (z.class) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            z zVar = h.get(str);
            if (zVar == null) {
                zVar = new z();
                try {
                    cursor = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_cache_event where adslot_id = '" + str + "' group by adslot_id", null);
                    a(zVar, cursor);
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
                h.put(str, zVar);
            }
            return zVar;
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.g, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private static void a(z zVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            zVar.f13166a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            zVar.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("pre_req_time"));
            zVar.c = j;
            zVar.g = j;
            zVar.d = cursor.getInt(cursor.getColumnIndexOrThrow("req_interval_time"));
            zVar.e = cursor.getInt(cursor.getColumnIndexOrThrow("req_pool_size"));
        } while (cursor.moveToNext());
    }

    public static void a(final String str, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.g);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("media_request_count", Integer.valueOf(zVar.f13166a));
            hashMap.put("media_ready_count", Integer.valueOf(zVar.b));
            hashMap.put("pre_req_time", Long.valueOf(zVar.c));
            hashMap.put("req_interval_time", Integer.valueOf(zVar.d));
            hashMap.put("req_pool_size", Integer.valueOf(zVar.e));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0448a() { // from class: com.sigmob.sdk.base.common.z.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a() {
                    SigmobLog.d(str + " insert load cache event " + str + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a(Throwable th) {
                    SigmobLog.e(str + " insert load cache event " + str + " onFailed: ", th);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
