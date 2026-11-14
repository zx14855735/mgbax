package com.czhj.sdk.common.Database;

import J3FDQU.A2egSU;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SQLiteMTAHelper extends SQLiteOpenHelper {
    public static final long DB_ERROR_BAD_INPUT = -2;
    public static final long DB_WRITE_ERROR = -1;
    public static final String TABLE_POINT = "point";

    /* renamed from: a, reason: collision with root package name */
    private static String f10550a = "sigmob_mta.db";
    private static final int b = 10;
    private static String c = "CREATE TABLE point ( point_id integer  primary key  ,item text , encryption int);\n";
    private static final long d = -6;
    private static final long e = -5;
    private static final long f = -4;
    private static final long g = 0;
    private static SQLiteMTAHelper h;
    private static SQLiteDatabase i;

    public interface ExecCallBack {
        void onFailed(Throwable th);

        void onSuccess();
    }

    public SQLiteMTAHelper(Context context) {
        super(context, f10550a, (SQLiteDatabase.CursorFactory) null, 10);
    }

    private static long a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return d;
        }
        if (!sQLiteDatabase.isOpen()) {
            return e;
        }
        if (sQLiteDatabase.isReadOnly()) {
            return f;
        }
        return 0L;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS point");
        onCreate(sQLiteDatabase);
    }

    public static SQLiteMTAHelper getInstance() {
        return h;
    }

    public static void initialize(Context context) {
        if (h == null) {
            synchronized (SQLiteMTAHelper.class) {
                try {
                    if (h == null) {
                        h = new SQLiteMTAHelper(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void insert(SQLiteDatabase sQLiteDatabase, SQLiteBuider.Insert insert, ExecCallBack execCallBack) {
        sQLiteDatabase.beginTransaction();
        try {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(insert.b);
            for (int i2 = 1; i2 <= insert.d.size(); i2++) {
                Object obj = insert.c.get((String) insert.d.get(i2 - 1));
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
            if (execCallBack != null) {
                execCallBack.onSuccess();
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (execCallBack != null) {
                    execCallBack.onFailed(th);
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th2) {
                    SigmobLog.e(th2.getMessage());
                    if (execCallBack != null) {
                        execCallBack.onFailed(th2);
                    }
                }
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th3) {
                    SigmobLog.e(th3.getMessage());
                    if (execCallBack != null) {
                        execCallBack.onFailed(th3);
                    }
                }
            }
        }
    }

    public void clearDb() {
        b(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(c);
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
        if (i2 == 9) {
            b(sQLiteDatabase);
        } else if (i3 > 8) {
            sQLiteDatabase.execSQL("ALTER TABLE point ADD COLUMN 'encryption' int ");
        }
    }

    public void transactionWriteExecSQL(SQLiteDatabase sQLiteDatabase, String str, ExecCallBack execCallBack) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(str, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            if (execCallBack != null) {
                execCallBack.onSuccess();
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (execCallBack != null) {
                    execCallBack.onFailed(th);
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
