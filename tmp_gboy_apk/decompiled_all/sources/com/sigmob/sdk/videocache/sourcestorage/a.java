package com.sigmob.sdk.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.videocache.o;
import com.sigmob.sdk.videocache.v;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13744a = "SourceInfo";
    private static final String b = "_id";
    private static final String c = "url";
    private static final String d = "length";
    private static final String e = "mime";
    private static final String[] f = {"_id", "url", d, e};
    private static final String g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    static {
        Hdntii();
    }

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        o.a(context);
    }

    private static /* synthetic */ void Hdntii() {
        char[] charArray = "¸´¶õ¼º¶¾õ¹´¢õ¨³¾··õ\u0091µ²\u0099©²¿¼¾".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 219);
        }
        String str = new String(charArray);
        char[] charArray2 = "¸·²µ²¯".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 219);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private ContentValues a(v vVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", vVar.f13745a);
        contentValues.put(d, Long.valueOf(vVar.b));
        contentValues.put(e, vVar.c);
        return contentValues;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        o.a(sQLiteDatabase);
        sQLiteDatabase.execSQL(g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private v a(Cursor cursor) {
        return new v(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(d)), cursor.getString(cursor.getColumnIndexOrThrow(e)));
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public v a(String str) {
        o.a(str);
        Cursor cursor = null;
        r1 = null;
        v a2 = null;
        try {
            Cursor query = getReadableDatabase().query(f13744a, f, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a2 = a(query);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a() {
        close();
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a(String str, v vVar) {
        o.a(str, vVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(vVar);
        if (z) {
            getWritableDatabase().update(f13744a, a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(f13744a, null, a2);
        }
    }
}
