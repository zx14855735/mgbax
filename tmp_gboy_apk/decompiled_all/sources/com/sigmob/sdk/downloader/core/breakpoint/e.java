package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    static final String f13349a = "taskFileDirty";
    private static final String b = "sig_breakpoint.db";
    private static final int c = 3;
    private static final String d = "FileDownloadResponseFilename";
    private static final String e = "breakpoint";
    private static final String f = "block";

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f13350a = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";
        public static final String b = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";
        public static final String c = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String d = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f13351a = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String b = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final String f13352a = "SELECT * FROM taskFileDirty";
        public static final String b = "SELECT * FROM breakpoint";
        public static final String c = "SELECT * FROM block";
        public static final String d = "SELECT * FROM FileDownloadResponseFilename";
        public static final String e = "SELECT filename FROM FileDownloadResponseFilename WHERE url = ?";
        public static final String f = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public e(Context context) {
        super(context, b, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private static ContentValues a(int i, int i2, com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.h, Integer.valueOf(i));
        contentValues.put(f.i, Integer.valueOf(i2));
        contentValues.put(f.j, Long.valueOf(aVar.b()));
        contentValues.put(f.k, Long.valueOf(aVar.d()));
        contentValues.put(f.l, Long.valueOf(aVar.a()));
        return contentValues;
    }

    private static ContentValues c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f13353a, Integer.valueOf(cVar.f13347a));
        contentValues.put("url", cVar.l());
        contentValues.put(f.c, cVar.k());
        contentValues.put(f.d, cVar.b.getAbsolutePath());
        contentValues.put(f.e, cVar.m());
        contentValues.put(f.f, Integer.valueOf(cVar.d() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(cVar.b() ? 1 : 0));
        return contentValues;
    }

    public SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> b() {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery(c.b, null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(rawQuery));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    cursor2 = rawQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursor2 = writableDatabase.rawQuery(c.c, null);
            while (cursor2.moveToNext()) {
                arrayList2.add(new com.sigmob.sdk.downloader.core.breakpoint.b(cursor2));
            }
            rawQuery.close();
            cursor2.close();
            SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> sparseArray = new SparseArray<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.sigmob.sdk.downloader.core.breakpoint.c h = ((d) it.next()).h();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.sigmob.sdk.downloader.core.breakpoint.b bVar = (com.sigmob.sdk.downloader.core.breakpoint.b) it2.next();
                    if (bVar.a() == h.f13347a) {
                        h.a(bVar.e());
                        it2.remove();
                    }
                }
                sparseArray.put(h.f13347a, h);
            }
            return sparseArray;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void d(int i) {
        getWritableDatabase().delete(f, "breakpoint_id = ?", new String[]{String.valueOf(i)});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(a.f13350a);
        sQLiteDatabase.execSQL(a.b);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.f13352a, null);
            while (cursor.moveToNext()) {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(f.f13353a))));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void b(int i) {
        getWritableDatabase().delete(f13349a, "id = ?", new String[]{String.valueOf(i)});
    }

    public HashMap<String, String> c() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = writableDatabase.rawQuery(c.d, null);
            while (cursor.moveToNext()) {
                int columnIndex = cursor.getColumnIndex("url");
                String str = "";
                String string = columnIndex >= 0 ? cursor.getString(columnIndex) : "";
                int columnIndex2 = cursor.getColumnIndex(f.e);
                if (columnIndex2 >= 0) {
                    str = cursor.getString(columnIndex2);
                }
                hashMap.put(string, str);
            }
            cursor.close();
            return hashMap;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void a(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(f.f13353a, Integer.valueOf(i));
        writableDatabase.insert(f13349a, null, contentValues);
    }

    public void b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.f, new String[]{Integer.toString(cVar.f13347a)});
            if (!cursor.moveToNext()) {
                cursor.close();
                writableDatabase.endTransaction();
                return;
            }
            c(cVar.f13347a);
            a(cVar);
            writableDatabase.setTransactionSuccessful();
            cursor.close();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void c(int i) {
        getWritableDatabase().delete(e, "id = ?", new String[]{String.valueOf(i)});
        d(i);
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        int g = cVar.g();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < g; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b2 = cVar.b(i);
            if (writableDatabase.insert(f, null, a(cVar.f13347a, i, b2)) == -1) {
                throw new com.sigmob.sdk.downloader.core.exception.h("insert block " + b2 + " failed!");
            }
        }
        if (writableDatabase.insert(e, null, c(cVar)) != -1) {
            return;
        }
        throw new com.sigmob.sdk.downloader.core.exception.h("insert info " + cVar + " failed!");
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.l, Long.valueOf(j));
        getWritableDatabase().update(f, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(cVar.f13347a), Integer.toString(i)});
    }

    public void a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", str);
        contentValues.put(f.e, str2);
        synchronized (str.intern()) {
            Cursor cursor = null;
            try {
                try {
                    Cursor rawQuery = writableDatabase.rawQuery(c.e, new String[]{str});
                    try {
                        if (!rawQuery.moveToFirst()) {
                            writableDatabase.insert(d, null, contentValues);
                        } else if (!str2.equals(rawQuery.getString(rawQuery.getColumnIndex(f.e)))) {
                            writableDatabase.replace(d, null, contentValues);
                        }
                        rawQuery.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
