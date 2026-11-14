package GnQT2j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.n;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends SQLiteOpenHelper {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3086AcNBzu = 0;

    public /* synthetic */ A2egSU(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static AZkASS A2egSU(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(n.z, null, "url = ?", new String[]{str}, null, null, null, null);
        AZkASS aZkASS = new AZkASS();
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("fileName"));
                int i = query.getInt(query.getColumnIndex("length"));
                int i2 = query.getInt(query.getColumnIndex("finished"));
                aZkASS.AMqCpz = false;
                aZkASS.f3124A2egSU = string;
                aZkASS.f3125A4TApA = str;
                aZkASS.f3126A5SV6n = i;
                aZkASS.f3127ADYaiT = i2;
            }
            query.close();
        }
        return aZkASS;
    }

    public static void A4TApA(SQLiteDatabase sQLiteDatabase, AZkASS aZkASS) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileName", aZkASS.f3124A2egSU);
        contentValues.put("length", Integer.valueOf(aZkASS.f3126A5SV6n));
        contentValues.put("finished", Integer.valueOf(aZkASS.f3127ADYaiT));
        sQLiteDatabase.update(n.z, contentValues, "url = ?", new String[]{aZkASS.f3125A4TApA});
    }

    private final void A5SV6n(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void ADYaiT(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.f3086AcNBzu) {
            case 0:
                sQLiteDatabase.execSQL("create table file(fileName varchar,url varchar,length integer,finished integer)");
                break;
            default:
                new K1qm5H.A2egSU();
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CREATE TABLE ");
                    sb.append("duplicatelog");
                    sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
                    HashMap hashMap = new HashMap();
                    hashMap.put("path", "TEXT");
                    hashMap.put("insert_time", "INTEGER");
                    hashMap.put("ext1", "TEXT");
                    hashMap.put("ext2", "TEXT");
                    for (String str : hashMap.keySet()) {
                        sb.append(str);
                        sb.append(" ");
                        sb.append((String) hashMap.get(str));
                        sb.append(",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(")");
                    sQLiteDatabase.execSQL(sb.toString());
                    break;
                } catch (Exception e) {
                    pl.xj(e);
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.f3086AcNBzu;
    }

    public A2egSU(Context context) {
        super(context, "download.db", (SQLiteDatabase.CursorFactory) null, 1);
    }
}
