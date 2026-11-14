package K1qm5H;

import android.database.sqlite.SQLiteDatabase;
import com.bumptech.glide.AMqCpz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU extends A4TApA {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A2egSU(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L2b
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto La
            goto L2b
        La:
            java.lang.String r3 = "duplicatelog"
            java.lang.String r5 = "path=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L23
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L23
            int r12 = r11.getCount()     // Catch: java.lang.Exception -> L23
            r11.close()     // Catch: java.lang.Exception -> L24
            goto L27
        L23:
            r12 = 0
        L24:
            com.bumptech.glide.AMqCpz.C2rE4F()
        L27:
            if (r12 <= 0) goto L2b
            r11 = 1
            return r11
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: K1qm5H.A2egSU.A2egSU(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @Override // K1qm5H.A4TApA
    public void insert(SQLiteDatabase sQLiteDatabase, K32z9s.A2egSU a2egSU) {
        if (a2egSU == null || A2egSU(sQLiteDatabase, a2egSU.f4176A2egSU)) {
            return;
        }
        super.insert(sQLiteDatabase, (Object) a2egSU);
        try {
            sQLiteDatabase.execSQL("delete from duplicatelog where _id in (select _id from duplicatelog order by insert_time desc limit 1000 offset 500)");
        } catch (Exception unused) {
            AMqCpz.C2rE4F();
        }
    }
}
