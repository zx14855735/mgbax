package K1qm5H;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bumptech.glide.AMqCpz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {
    public void insert(SQLiteDatabase sQLiteDatabase, Object obj) {
        if (sQLiteDatabase == null || obj == null) {
            return;
        }
        try {
            K32z9s.A2egSU a2egSU = (K32z9s.A2egSU) obj;
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", a2egSU.f4176A2egSU);
            contentValues.put("insert_time", Long.valueOf(a2egSU.f4177A4TApA));
            sQLiteDatabase.insert("duplicatelog", null, contentValues);
        } catch (Exception unused) {
            AMqCpz.C2rE4F();
        }
    }
}
