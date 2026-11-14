package com.bytedance.sdk.openadsdk.core.tf;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static final Object hf = new Object();
    private final String u;
    private final Context w;
    private SQLiteDatabase xj = null;

    public class xj extends AbstractCursor {
        private xj() {
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

    static {
        XdqBLv();
    }

    public u(Context context, String str) {
        this.w = context;
        this.u = str;
    }

    private static /* synthetic */ void XdqBLv() {
        char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 158);
        }
        String str = new String(charArray);
        char[] charArray2 = "ýò÷ð÷ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 158);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean y() {
        SQLiteDatabase sQLiteDatabase = this.xj;
        return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
    }

    public int delete(String str, String str2, String[] strArr) {
        try {
            xj();
            return this.xj.delete(str, str2, strArr);
        } catch (Exception e) {
            pl.xj(e);
            if (y()) {
                throw e;
            }
            return 0;
        }
    }

    public SQLiteDatabase hf() {
        return this.xj;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            xj();
            return this.xj.insert(str, str2, contentValues);
        } catch (Exception e) {
            pl.xj(e);
            if (y()) {
                throw e;
            }
            return -1L;
        }
    }

    public void kd() {
        xj();
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.endTransaction();
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        try {
            xj();
            return this.xj.query(str, strArr, str2, strArr2, str3, str4, str5);
        } catch (Throwable th) {
            xj xjVar = new xj();
            if (y()) {
                throw th;
            }
            return xjVar;
        }
    }

    public void u() {
        xj();
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            xj();
            return this.xj.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            pl.xj(e);
            if (y()) {
                throw e;
            }
            return 0;
        }
    }

    public void w() {
        xj();
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
    }

    public void xj() {
        boolean y;
        SQLiteOpenHelper xjVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.xj;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return;
            }
            synchronized (hf) {
                try {
                    SQLiteDatabase sQLiteDatabase2 = this.xj;
                    if (sQLiteDatabase2 != null) {
                        if (!sQLiteDatabase2.isOpen()) {
                        }
                    }
                    if (TextUtils.equals(this.u, "ttopensdk.db")) {
                        xjVar = new com.bytedance.sdk.openadsdk.core.tf.xj.hf(this.w, ai.w >= 7100 ? 13 : 12);
                    } else {
                        xjVar = TextUtils.equals(this.u, "ttopensdk2.db") ? new com.bytedance.sdk.openadsdk.core.tf.xj.xj(this.w) : null;
                    }
                    if (xjVar != null) {
                        this.xj = xjVar.getWritableDatabase();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            if (!y) {
            }
        }
    }

    public void xj(String str) {
        try {
            xj();
            this.xj.execSQL(str);
        } catch (Throwable th) {
            if (y()) {
                throw th;
            }
        }
    }
}
