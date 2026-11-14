package L5dZB6;

import LCJm5h.ARc23Z;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.File;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends SQLiteOpenHelper {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f4391AcNBzu;

    public A2egSU(Context context) {
        super(context, "downloads.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.f4391AcNBzu = context;
    }

    public static A4TApA A2egSU(Cursor cursor) {
        A4TApA a4TApA = new A4TApA();
        a4TApA.f4392AcNBzu = A5SV6n(cursor, f.f13353a);
        a4TApA.f4401B9tovu = A5SV6n(cursor, PointParamKey.TYPE);
        a4TApA.f4393AlLFFp = A5SV6n(cursor, "url");
        a4TApA.f4394AmA8tU = A5SV6n(cursor, "image_url");
        a4TApA.f4395AzWtSf = A5SV6n(cursor, "file_name");
        a4TApA.f4396B25kr6 = A5SV6n(cursor, "file_path");
        int columnIndex = cursor.getColumnIndex("file_size");
        a4TApA.f4397B2KMhB = columnIndex != -1 ? cursor.getLong(columnIndex) : 0L;
        int columnIndex2 = cursor.getColumnIndex("downloaded_size");
        a4TApA.f4398B3GDIM = columnIndex2 != -1 ? cursor.getLong(columnIndex2) : 0L;
        int columnIndex3 = cursor.getColumnIndex(PointCategory.PROGRESS);
        a4TApA.f4399B4ZgIw = columnIndex3 != -1 ? cursor.getInt(columnIndex3) : 0;
        int columnIndex4 = cursor.getColumnIndex("status");
        if ((columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0) == 3) {
            String A5SV6n2 = A5SV6n(cursor, "file_path");
            int AmA8tU2 = ARc23Z.AmA8tU(new File(A5SV6n2.toLowerCase(Locale.ROOT).replace(ARc23Z.ASJ6gh(A5SV6n2), A5SV6n(cursor, PointParamKey.TYPE))));
            if (AmA8tU2 == 2 || AmA8tU2 == 3) {
                a4TApA.f4400B7CMnp = 6;
            } else {
                int columnIndex5 = cursor.getColumnIndex("status");
                a4TApA.f4400B7CMnp = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 0;
            }
        }
        a4TApA.f4402BChYOn = A5SV6n(cursor, "expected_checksum");
        int columnIndex6 = cursor.getColumnIndex("verified");
        a4TApA.f4403BI9f7h = (columnIndex6 != -1 ? cursor.getInt(columnIndex6) : 0) == 1;
        return a4TApA;
    }

    public static ContentValues A4TApA(A4TApA a4TApA) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f13353a, a4TApA.f4392AcNBzu);
        contentValues.put(PointParamKey.TYPE, a4TApA.getType());
        contentValues.put("url", a4TApA.f4393AlLFFp);
        contentValues.put("image_url", a4TApA.f4394AmA8tU);
        contentValues.put("file_name", a4TApA.f4395AzWtSf);
        contentValues.put("file_path", a4TApA.f4396B25kr6);
        contentValues.put("file_size", Long.valueOf(a4TApA.f4397B2KMhB));
        contentValues.put("downloaded_size", Long.valueOf(a4TApA.f4398B3GDIM));
        contentValues.put(PointCategory.PROGRESS, Integer.valueOf(a4TApA.f4399B4ZgIw));
        contentValues.put("status", Integer.valueOf(a4TApA.f4400B7CMnp));
        contentValues.put("expected_checksum", a4TApA.f4402BChYOn);
        contentValues.put("verified", Integer.valueOf(a4TApA.f4403BI9f7h ? 1 : 0));
        contentValues.put("update_time", Long.valueOf(System.currentTimeMillis() / 1000));
        return contentValues;
    }

    public static String A5SV6n(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex != -1 ? cursor.getString(columnIndex) : "";
    }

    public final void ADYaiT(A4TApA a4TApA) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.update("downloads", A4TApA(a4TApA), "id = ?", new String[]{a4TApA.f4392AcNBzu});
        writableDatabase.close();
    }

    public Context getContext() {
        return this.f4391AcNBzu;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE downloads(id TEXT PRIMARY KEY,type TEXT NOT NULL,url TEXT NOT NULL,image_url TEXT,file_name TEXT NOT NULL,file_path TEXT NOT NULL,file_size INTEGER DEFAULT 0,downloaded_size INTEGER DEFAULT 0,progress INTEGER DEFAULT 0,status INTEGER DEFAULT 0,expected_checksum TEXT,verified INTEGER DEFAULT 0,create_time INTEGER DEFAULT (strftime('%s','now')),update_time INTEGER DEFAULT (strftime('%s','now')))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(id TEXT PRIMARY KEY,type TEXT NOT NULL,url TEXT NOT NULL,image_url TEXT,file_name TEXT NOT NULL,file_path TEXT NOT NULL,file_size INTEGER DEFAULT 0,downloaded_size INTEGER DEFAULT 0,progress INTEGER DEFAULT 0,status INTEGER DEFAULT 0,expected_checksum TEXT,verified INTEGER DEFAULT 0,create_time INTEGER DEFAULT (strftime('%s','now')),update_time INTEGER DEFAULT (strftime('%s','now')))");
        }
    }
}
