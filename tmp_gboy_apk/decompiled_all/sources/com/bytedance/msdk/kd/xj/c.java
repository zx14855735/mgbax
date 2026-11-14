package com.bytedance.msdk.kd.xj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static final Object w = new Object();
    private Context hf;
    private xj xj;

    public class xj {
        private SQLiteDatabase hf = null;

        public xj() {
        }

        private void hf() {
            try {
                synchronized (c.w) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.hf;
                        if (sQLiteDatabase != null) {
                            if (!sQLiteDatabase.isOpen()) {
                            }
                        }
                        SQLiteDatabase writableDatabase = new f(c.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.hf = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
                w();
            }
        }

        private boolean w() {
            SQLiteDatabase sQLiteDatabase = this.hf;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        public SQLiteDatabase xj() {
            hf();
            return this.hf;
        }
    }

    static {
        bJnxt();
    }

    public c(Context context) {
        try {
            this.hf = context == null ? com.bytedance.msdk.core.hf.getContext() : context.getApplicationContext();
            if (this.xj == null) {
                this.xj = new xj();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private static /* synthetic */ void bJnxt() {
        char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\b');
        }
        String str = new String(charArray);
        char[] charArray2 = "kdafa|".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.hf;
        return context == null ? com.bytedance.msdk.core.hf.getContext() : context;
    }

    public xj xj() {
        return this.xj;
    }
}
