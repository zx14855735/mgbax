package com.czhj.sdk.common.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DBOperator {

    /* renamed from: a, reason: collision with root package name */
    private static final DBOperator f10539a = new DBOperator();
    private final Object c = new Object();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new BackgroundThreadFactory());

    public interface DataSQLiteLisenter {
        void onFailed(Error error);

        void onSuccess(List<Map> list);
    }

    public class SQLiteDeleteThread implements Runnable {
        private final String b;
        private final String c;
        private final SQLiteLisenter d;
        private final SQLiteDatabase e;

        public SQLiteDeleteThread(SQLiteDatabase sQLiteDatabase, String str, String str2, SQLiteLisenter sQLiteLisenter) {
            this.b = str;
            this.e = sQLiteDatabase;
            this.c = str2;
            this.d = sQLiteLisenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.e.delete(this.b, this.c, null);
                SQLiteLisenter sQLiteLisenter = this.d;
                if (sQLiteLisenter != null) {
                    sQLiteLisenter.onSuccess(null);
                }
            } catch (Throwable th) {
                SQLiteLisenter sQLiteLisenter2 = this.d;
                if (sQLiteLisenter2 != null) {
                    sQLiteLisenter2.onFailed(new Error(th.getMessage()));
                }
            }
        }
    }

    public class SQLiteThread implements Runnable {
        private final String b;
        private final String[] c;
        private final String d;
        private final String[] e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final SQLiteDatabase j;
        private final DataSQLiteLisenter k;

        public SQLiteThread(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
            this.b = str;
            this.j = sQLiteDatabase;
            this.c = strArr;
            this.d = str2;
            this.e = strArr2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.k = dataSQLiteLisenter;
        }

        private List<Map> a(Cursor cursor) {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                String[] columnNames = cursor.getColumnNames();
                HashMap hashMap = new HashMap();
                for (String str : columnNames) {
                    int columnIndex = cursor.getColumnIndex(str);
                    if (columnIndex >= 0) {
                        int type = cursor.getType(columnIndex);
                        if (type == 1) {
                            hashMap.put(str, Long.valueOf(cursor.getLong(columnIndex)));
                        } else if (type == 2) {
                            hashMap.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
                        } else if (type == 3) {
                            hashMap.put(str, cursor.getString(columnIndex));
                        } else if (type == 4) {
                            hashMap.put(str, cursor.getBlob(columnIndex));
                        }
                    }
                }
                arrayList.add(hashMap);
            }
            return arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cursor cursor = null;
            try {
                cursor = this.j.query(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                List<Map> a2 = a(cursor);
                DataSQLiteLisenter dataSQLiteLisenter = this.k;
                if (dataSQLiteLisenter != null) {
                    dataSQLiteLisenter.onSuccess(a2);
                }
            } catch (Throwable th) {
                try {
                    DataSQLiteLisenter dataSQLiteLisenter2 = this.k;
                    if (dataSQLiteLisenter2 != null) {
                        dataSQLiteLisenter2.onFailed(new Error(th.getMessage()));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    }

    static {
        giZlKFx();
    }

    private DBOperator() {
    }

    public static synchronized DBOperator getInstance() {
        DBOperator dBOperator;
        synchronized (DBOperator.class) {
            dBOperator = f10539a;
        }
        return dBOperator;
    }

    private static /* synthetic */ void giZlKFx() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str) {
        return count(sQLiteDatabase, str, null);
    }

    public void delete(SQLiteDatabase sQLiteDatabase, String str, String str2, SQLiteLisenter sQLiteLisenter) {
        SQLiteLisenter sQLiteLisenter2;
        try {
            sQLiteLisenter2 = sQLiteLisenter;
            try {
                this.b.submit(new SQLiteDeleteThread(sQLiteDatabase, str, str2, sQLiteLisenter2));
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                SigmobLog.e(th2.getMessage());
                sQLiteLisenter2.onFailed(new Error(th2.getMessage()));
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteLisenter2 = sQLiteLisenter;
        }
    }

    public void find(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
        this.b.submit(new SQLiteThread(sQLiteDatabase, str, strArr, str2, strArr2, str3, str4, str5, str6, dataSQLiteLisenter));
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query(str, null, str2, null, null, null, null, null);
            try {
                int count = cursor.getCount();
                cursor.close();
                return count;
            } catch (Throwable th2) {
                th = th2;
                try {
                    SigmobLog.e(th.getMessage());
                    if (cursor == null) {
                        return 0;
                    }
                    cursor.close();
                    return 0;
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }
}
