package com.ss.android.downloadlib.u;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.base.cache.DatabaseHelper;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf extends SQLiteOpenHelper {
    static final String[] xj = {DatabaseHelper.COLUMN_ID, MediationConstant.EXTRA_ADID, "req_id", "time"};

    static {
        DDRXKV();
    }

    public hf(Context context) {
        super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private static /* synthetic */ void DDRXKV() {
        char[] charArray = "\u0089\u0085\u0087Ä\u008d\u008b\u0087\u008fÄ\u0088\u0085\u0093Ä\u0099\u0082\u008f\u0086\u0086Ä \u0084\u0083¨\u0098\u0083\u008e\u008d\u008f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 234);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0089\u0086\u0083\u0084\u0083\u009e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 234);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(sQLiteDatabase);
    }
}
