package com.bytedance.sdk.openadsdk.core.tf.xj;

import J3FDQU.A2egSU;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.c;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.u;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.y;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends w {
    private final String hf;

    public hf(Context context, int i) {
        super(context, "ttopensdk.db", i);
        this.hf = "OldSqliteDatabase";
    }

    private void hf(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(y.kd("adevent"));
        sQLiteDatabase.execSQL(u.w("loghighpriority"));
        sQLiteDatabase.execSQL(c.kd("logstats"));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.xj.xj.hf.xj.w("logstatsbatch"));
        w(sQLiteDatabase, i, i2);
    }

    private void w(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.y.y.w());
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.y.y.u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w
    public void xj(SQLiteDatabase sQLiteDatabase, Context context) {
        com.bytedance.sdk.openadsdk.core.ht.hf.w.get();
        sQLiteDatabase.execSQL(y.u("adevent"));
        sQLiteDatabase.execSQL(u.hf("loghighpriority"));
        sQLiteDatabase.execSQL(c.u("logstats"));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.xj.xj.hf.xj.hf("logstatsbatch"));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.y.y.hf());
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.xj.hf.hf.w());
        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.hf.w());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.nativeexpress.xj.w.w());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT)");
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w
    public void xj(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(c.u("logstats"));
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.xj.hf.hf.w());
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.xj.xj.hf.xj.hf("logstatsbatch"));
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.hf.w());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    hf(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    try {
                        w(sQLiteDatabase, i, i2);
                        break;
                    } catch (Exception e) {
                        StringBuilder B9tovu2 = A2egSU.B9tovu(i, "database onUpgrade error version: ", ", msg: ");
                        B9tovu2.append(e.getMessage());
                        pl.u("OldSqliteDatabase", B9tovu2.toString());
                        break;
                    }
            }
            i++;
        }
    }
}
