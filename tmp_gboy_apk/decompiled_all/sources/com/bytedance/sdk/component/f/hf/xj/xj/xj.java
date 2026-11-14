package com.bytedance.sdk.component.f.hf.xj.xj;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class xj {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile xj w;
    private Context hf;
    private hf xj;

    /* renamed from: com.bytedance.sdk.component.f.hf.xj.xj.xj$xj, reason: collision with other inner class name */
    public class C0110xj extends AbstractCursor {
        private C0110xj() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    private xj(Context context) {
        try {
            this.hf = context.getApplicationContext();
            if (this.xj == null) {
                this.xj = new hf();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.hf;
    }

    public static xj xj(Context context) {
        if (w == null) {
            synchronized (xj.class) {
                try {
                    if (w == null) {
                        w = new xj(context);
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public class hf {
        public hf() {
        }

        private boolean hf(kd kdVar) {
            SQLiteDatabase xj = xj(kdVar);
            return xj != null && xj.inTransaction();
        }

        private SQLiteDatabase xj(kd kdVar) {
            boolean hf;
            try {
                SQLiteDatabase xj = kdVar.hf().xj(kdVar.getContext());
                if (xj == null || !xj.isOpen()) {
                    return null;
                }
                xj.setLockingEnabled(false);
                return xj;
            } finally {
                if (!hf) {
                }
            }
        }

        public int delete(kd kdVar, String str, String str2, String[] strArr) {
            try {
                SQLiteDatabase xj = xj(kdVar);
                if (xj != null) {
                    return xj.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                pl.xj(e);
                if (hf(kdVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(kd kdVar, String str, String str2, ContentValues contentValues) {
            try {
                SQLiteDatabase xj = xj(kdVar);
                if (xj != null) {
                    return xj.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                pl.xj(e);
                if (hf(kdVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        public Cursor query(kd kdVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                SQLiteDatabase xj = xj(kdVar);
                if (xj != null) {
                    return xj.query(str, strArr, str2, strArr2, str3, str4, str5);
                }
                return null;
            } catch (Throwable th) {
                pl.xj(th);
                C0110xj c0110xj = new C0110xj();
                if (hf(kdVar)) {
                    throw th;
                }
                return c0110xj;
            }
        }

        public int update(kd kdVar, String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                SQLiteDatabase xj = xj(kdVar);
                if (xj != null) {
                    return xj.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                pl.xj(e);
                if (hf(kdVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public synchronized void insert(kd kdVar, String str, String str2, List<com.bytedance.sdk.component.f.xj.hf> list) {
            JSONObject c;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = xj(kdVar);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.bytedance.sdk.component.f.xj.hf hfVar = list.get(i);
                            if (hfVar != null && (c = hfVar.c()) != null) {
                                contentValues.put(f.f13353a, hfVar.w());
                                String hf = kdVar.u().hf(c.toString());
                                if (!TextUtils.isEmpty(hf)) {
                                    contentValues.put("value", hf);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabase.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        com.bytedance.sdk.component.f.hf.w.w.xj("DBHelper", str + " insert list size=" + list.size(), kdVar);
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.f.hf.w.w.xj("DBHelper", str + " insert list error=" + list.size(), kdVar);
                    pl.xj(e);
                    if (hf(kdVar)) {
                        throw e;
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                throw th;
            }
        }

        public void xj(kd kdVar, String str) {
            boolean hf;
            try {
                SQLiteDatabase xj = xj(kdVar);
                if (xj != null) {
                    xj.execSQL(str);
                }
            } finally {
                if (!hf) {
                }
            }
        }
    }

    public hf xj() {
        return this.xj;
    }
}
