package com.sigmob.sdk.base.db;

import Dphsd2.AlLFFp;
import J3FDQU.A2egSU;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.utils.k;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13169a = "ads";
    public static final String b = "file_reference";
    public static final String c = "trigger_insert";
    public static final String d = "trigger_delete";
    public static final String e = "tracks";
    public static final String f = "adload_event";
    public static final String g = "adload_cache_event";
    public static final String h = "adload_ready_event";
    public static final String i = "wind.db";
    public static final long j = -2;
    public static final long k = -1;
    private static final int l = 11;
    private static String m = "CREATE TABLE ads ( endcard_md5 text  ,video_md5 text  ,ad blob  ,ad_source_channel text  ,ad_type integer  ,create_time integer  ,crid text  ,load_id text  ,adTrackersMap blob  ,adslot_id text  ,camp_id text  ,request_id text , primary key ( crid ,adslot_id) ); \n";
    private static String n = "CREATE TRIGGER trigger_insert after insert on ads begin insert or replace into file_reference (crid,adslot_id,video_md5,endcard_md5) values(new.crid,new.adslot_id,new.video_md5,new.endcard_md5) ; end; \n";
    private static String o = "CREATE TRIGGER trigger_delete after delete on ads begin delete from file_reference where crid = old.crid  and adslot_id == old.adslot_id; end;\n";
    private static String p = "CREATE TABLE file_reference ( endcard_md5 blob  ,video_md5 blob  ,crid text  ,adslot_id text  , primary key ( crid ,adslot_id ) );\n";
    private static String q = "CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer   );\n";
    private static String r = "CREATE TABLE adload_event ( id integer primary key AUTOINCREMENT , adslot_id text  , error_code integer ,timestamp integer  );\n";
    private static String s = "CREATE TABLE adload_cache_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ,pre_req_time integer , req_interval_time integer ,req_pool_size integer); \n";
    private static String t = "CREATE TABLE adload_ready_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ); \n";
    private static final long u = -6;
    private static final long v = -5;
    private static final long w = -4;
    private static final long x = 0;
    private static a y;
    private static SQLiteDatabase z;

    /* renamed from: com.sigmob.sdk.base.db.a$a, reason: collision with other inner class name */
    public interface InterfaceC0448a {
        void a();

        void a(Throwable th);
    }

    private a(Context context) {
        super(context, i, (SQLiteDatabase.CursorFactory) null, 11);
    }

    private static long a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return u;
        }
        if (!sQLiteDatabase.isOpen()) {
            return v;
        }
        if (sQLiteDatabase.isReadOnly()) {
            return w;
        }
        return 0L;
    }

    public void b() {
        b(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(r);
        sQLiteDatabase.execSQL(s);
        sQLiteDatabase.execSQL(t);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        b(sQLiteDatabase);
    }

    public static a a() {
        return y;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file_reference");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tracks");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_event");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_cache_event");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_ready_event");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_insert");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_delete");
        k.i();
        onCreate(sQLiteDatabase);
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (y == null) {
                y = new a(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase, SQLiteBuider.Insert insert, InterfaceC0448a interfaceC0448a) {
        sQLiteDatabase.beginTransaction();
        try {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(insert.getSql());
            for (int i2 = 1; i2 <= insert.getColumns().size(); i2++) {
                Object obj = insert.getValues().get((String) insert.getColumns().get(i2 - 1));
                if (obj != null) {
                    if (obj instanceof String) {
                        compileStatement.bindString(i2, (String) obj);
                    } else if (obj instanceof Double) {
                        compileStatement.bindDouble(i2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Number) {
                        compileStatement.bindLong(i2, ((Number) obj).longValue());
                    } else if (obj instanceof byte[]) {
                        compileStatement.bindBlob(i2, (byte[]) obj);
                    }
                }
                compileStatement.bindNull(i2);
            }
            compileStatement.execute();
            sQLiteDatabase.setTransactionSuccessful();
            if (interfaceC0448a != null) {
                interfaceC0448a.a();
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (interfaceC0448a != null) {
                    interfaceC0448a.a(th);
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th2) {
                    SigmobLog.e(th2.getMessage());
                    if (interfaceC0448a != null) {
                        interfaceC0448a.a(th2);
                    }
                }
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th3) {
                    SigmobLog.e(th3.getMessage());
                    if (interfaceC0448a != null) {
                        interfaceC0448a.a(th3);
                    }
                }
            }
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, SQLiteBuider.Insert insert, InterfaceC0448a interfaceC0448a) {
        ThreadPoolFactory.getFixIOExecutor().submit(new AlLFFp(4, sQLiteDatabase, insert, interfaceC0448a));
    }

    public void a(SQLiteDatabase sQLiteDatabase, String str, InterfaceC0448a interfaceC0448a) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(str, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            if (interfaceC0448a != null) {
                interfaceC0448a.a();
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (interfaceC0448a != null) {
                    interfaceC0448a.a(th);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("alter table " + str2 + " drop column " + str);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        StringBuilder BChYOn2 = A2egSU.BChYOn("alter table ", str3, " add ", str, " ");
        BChYOn2.append(str2);
        sQLiteDatabase.execSQL(BChYOn2.toString());
    }
}
