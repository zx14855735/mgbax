package com.octopus.ad.internal.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.base.cache.DatabaseHelper;
import com.octopus.ad.internal.a.n;
import com.octopus.ad.internal.a.s;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f12387a = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    static {
        qruXG();
    }

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        n.a(context);
    }

    private static /* synthetic */ void qruXG() {
        char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 2);
        }
        String str = new String(charArray);
        char[] charArray2 = "anklkv".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 2);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.octopus.ad.internal.a.b.c
    public s a(String str) {
        n.a(str);
        Cursor cursor = null;
        r1 = null;
        s a2 = null;
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", f12387a, "url=?", new String[]{str}, null, null, null);
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.octopus.ad.internal.a.b.c
    public void a(String str, s sVar) {
        n.a(str, sVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(sVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    private s a(Cursor cursor) {
        return new s(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues a(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sVar.f12403a);
        contentValues.put("length", Long.valueOf(sVar.b));
        contentValues.put("mime", sVar.c);
        return contentValues;
    }
}
