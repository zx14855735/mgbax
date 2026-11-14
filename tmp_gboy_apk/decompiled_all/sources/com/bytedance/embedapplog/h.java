package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class h {
    static final hf[] w;
    private static final vl[] y;
    private String c;
    private final xj kd;
    private final a u;
    public static final int[] xj = {1};
    static final HashMap<String, vl> hf = new HashMap<>();

    public static class hf {
        int hf;
        int w;
        String xj;

        /* JADX INFO: Access modifiers changed from: private */
        public static void hf() {
            for (hf hfVar : h.w) {
                hfVar.xj = "";
                hfVar.hf = 0;
                hfVar.w = 0;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.w);
            sb.append("-");
            sb.append(this.xj);
            sb.append("-");
            sb.append(this.hf);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(vl vlVar) {
            String d = vlVar.d();
            if (d == null || d.length() <= this.hf) {
                return;
            }
            this.xj = vlVar.f();
            this.hf = d.length();
        }
    }

    public static class xj extends SQLiteOpenHelper {
        public xj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.xj(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<vl> it = h.hf.values().iterator();
                while (it.hasNext()) {
                    String w = it.next().w();
                    if (w != null) {
                        sQLiteDatabase.execSQL(w);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    cu.hf(th);
                } finally {
                    no.xj(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            cu.u("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<vl> it = h.hf.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().u());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    onCreate(sQLiteDatabase);
                } finally {
                }
            }
            onCreate(sQLiteDatabase);
        }
    }

    static {
        xj(new k());
        xj(new rg(true));
        xj(new da());
        xj(new t());
        vl[] vlVarArr = {new ne(), new ft(null, false, null), new se("", new JSONObject())};
        y = vlVarArr;
        for (int i = 0; i < 3; i++) {
            xj(vlVarArr[i]);
        }
        w = new hf[]{new hf(), new hf(), new hf()};
        CkVNsD();
    }

    public h(a aVar) {
        this.kd = new xj(aVar.hf(), "bd_embed_tea_agent.db", null, 30);
        this.u = aVar;
    }

    private static /* synthetic */ void CkVNsD() {
        char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '`');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '`');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String hf(String str, boolean z) {
        return A2egSU.B3GDIM(new StringBuilder("DELETE FROM page WHERE session_id"), z ? "='" : "!='", str, "'");
    }

    private String xj(String str, boolean z) {
        StringBuilder sb = new StringBuilder("SELECT * FROM page WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str);
        sb.append("' ORDER BY ");
        return CtFAbx.B25kr6(sb, z ? "session_id," : "", "duration DESC LIMIT 500");
    }

    private String xj(vl vlVar, String str, boolean z, int i, int i2) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(vlVar.u());
        sb.append(" WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str);
        sb.append("' AND event_type='");
        sb.append(i2);
        sb.append("' ORDER BY _id LIMIT ");
        sb.append(i);
        return sb.toString();
    }

    private String xj(String str, int i, String str2, boolean z, long j) {
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("DELETE FROM ", str, " WHERE session_id");
        B3GDIM2.append(z ? "='" : "!='");
        B3GDIM2.append(str2);
        B3GDIM2.append("' AND event_type='");
        B3GDIM2.append(i);
        B3GDIM2.append("' AND _id<=");
        B3GDIM2.append(j);
        return B3GDIM2.toString();
    }

    private String xj(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    private static void xj(vl vlVar) {
        hf.put(vlVar.u(), vlVar);
    }

    private boolean xj(String str) {
        cu.xj("needLaunch, " + this.c + ", " + str);
        if (TextUtils.equals(str, this.c)) {
            return false;
        }
        this.c = str;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.ArrayList<com.bytedance.embedapplog.t> xj(org.json.JSONObject r28) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.h.xj(org.json.JSONObject):java.util.ArrayList");
    }

    private void xj(JSONObject jSONObject, boolean z, t tVar, SQLiteDatabase sQLiteDatabase) {
        t tVar2 = tVar;
        for (int i : xj) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int xj2 = xj(0, sQLiteDatabase, tVar2.u, z, i, jSONArrayArr, jArr);
            if (xj(jArr)) {
                while (true) {
                    long[] jArr2 = jArr;
                    int i2 = i;
                    JSONArray[] jSONArrayArr2 = jSONArrayArr;
                    t tVar3 = tVar2;
                    tVar3.xj(jSONObject, null, null, null, jSONArrayArr2, jArr2, i2);
                    jSONArrayArr = jSONArrayArr2;
                    i = i2;
                    jArr = jArr2;
                    tVar2 = tVar3;
                    boolean z2 = z;
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                    xj(tVar2, z, sQLiteDatabase2, true);
                    xj2 = xj2;
                    while (xj2 < y.length) {
                        xj2 = xj(xj2, sQLiteDatabase2, tVar2.u, z2, i, jSONArrayArr, jArr);
                        if (xj(jArr)) {
                            break;
                        }
                        z2 = z;
                        sQLiteDatabase2 = sQLiteDatabase;
                    }
                }
            }
        }
    }

    private JSONObject xj(rg rgVar, JSONObject jSONObject) {
        if (!TextUtils.equals(rgVar.g, this.u.kd().w()) || rgVar.f10107pl != this.u.kd().hf()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                no.hf(jSONObject2, jSONObject);
                jSONObject2.put(com.sigmob.sdk.base.n.r, rgVar.g);
                jSONObject2.put("version_code", rgVar.f10107pl);
                return jSONObject2;
            } catch (JSONException e) {
                cu.hf(e);
            }
        }
        return jSONObject;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008f -> B:6:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(org.json.JSONObject r12, com.bytedance.embedapplog.rg r13, com.bytedance.embedapplog.t r14, android.database.sqlite.SQLiteDatabase r15, org.json.JSONArray[] r16, long[] r17, java.util.ArrayList<com.bytedance.embedapplog.t> r18) {
        /*
            r11 = this;
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "packCurrentData, "
            r1.<init>(r2)
            java.lang.String r2 = r13.u
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bytedance.embedapplog.cu.xj(r1)
            java.lang.String r1 = r13.u
            boolean r8 = r11.xj(r1)
            java.lang.String r3 = r13.u
            r4 = 1
            r5 = 0
            r1 = 0
            r0 = r11
            r2 = r15
            r6 = r16
            r7 = r17
            int r9 = r0.xj(r1, r2, r3, r4, r5, r6, r7)
            r6 = r7
            r10 = 0
            if (r8 != 0) goto L32
            boolean r0 = r11.xj(r6)
            if (r0 == 0) goto L54
        L32:
            if (r8 == 0) goto L36
            r2 = r13
            goto L37
        L36:
            r2 = r10
        L37:
            r4 = 0
            r7 = 0
            r3 = 0
            r1 = r12
            r0 = r14
            r5 = r16
            r0.xj(r1, r2, r3, r4, r5, r6, r7)
            com.bytedance.embedapplog.vl[] r0 = com.bytedance.embedapplog.h.y
            int r0 = r0.length
            if (r9 < r0) goto L58
            com.bytedance.embedapplog.vl r0 = r14.clone()
            com.bytedance.embedapplog.t r0 = (com.bytedance.embedapplog.t) r0
            r0.tf()
            r1 = r18
            r1.add(r0)
        L54:
            r8 = r14
        L55:
            r2 = r15
        L56:
            r1 = r9
            goto L60
        L58:
            r0 = r14
        L59:
            r1 = 1
            r2 = r15
            r11.xj(r0, r1, r15, r1)
            r8 = r0
            goto L56
        L60:
            com.bytedance.embedapplog.vl[] r0 = com.bytedance.embedapplog.h.y
            int r0 = r0.length
            if (r1 >= r0) goto L91
            java.lang.String r3 = r13.u
            r4 = 1
            r5 = 0
            r0 = r11
            r6 = r16
            r7 = r17
            int r9 = r0.xj(r1, r2, r3, r4, r5, r6, r7)
            r6 = r7
            boolean r0 = r11.xj(r6)
            if (r0 == 0) goto L8f
            java.lang.String r0 = r13.u
            boolean r0 = r11.xj(r0)
            if (r0 == 0) goto L83
            r2 = r13
            goto L84
        L83:
            r2 = r10
        L84:
            r4 = 0
            r7 = 0
            r3 = 0
            r1 = r12
            r5 = r16
            r0 = r8
            r0.xj(r1, r2, r3, r4, r5, r6, r7)
            goto L59
        L8f:
            r0 = r8
            goto L55
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.h.xj(org.json.JSONObject, com.bytedance.embedapplog.rg, com.bytedance.embedapplog.t, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList):void");
    }

    private void xj(JSONObject jSONObject, rg rgVar, t tVar, k kVar, da daVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        cu.xj("packHistoryData, " + rgVar.u);
        JSONArray xj2 = xj(rgVar, true, daVar, kVar, sQLiteDatabase);
        rgVar.am = xj2.length() == 0;
        int xj3 = xj(0, sQLiteDatabase, rgVar.u, true, 0, jSONArrayArr, jArr);
        if (rgVar.am) {
            tVar.xj(jSONObject, xj(rgVar.u) ? rgVar : null, null, null, jSONArrayArr, jArr, 0);
        } else {
            tVar.xj(jSONObject, null, daVar, xj2, jSONArrayArr, jArr, 0);
        }
        while (true) {
            t tVar2 = tVar;
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            xj(tVar2, true, sQLiteDatabase2, true);
            while (xj3 < y.length) {
                xj3 = xj(xj3, sQLiteDatabase2, rgVar.u, true, 0, jSONArrayArr, jArr);
                if (xj(jArr)) {
                    break;
                }
                tVar2 = tVar;
                sQLiteDatabase2 = sQLiteDatabase;
            }
            return;
            tVar2.xj(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0088 -> B:8:0x004d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0061 -> B:9:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(org.json.JSONObject r15, com.bytedance.embedapplog.rg r16, com.bytedance.embedapplog.da r17, com.bytedance.embedapplog.k r18, com.bytedance.embedapplog.t r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21, org.json.JSONArray[] r22, long[] r23) {
        /*
            r14 = this;
            r1 = r16
            r6 = r21
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r2 = "packLostData, "
            java.lang.String r0 = r2.concat(r0)
            com.bytedance.embedapplog.cu.xj(r0)
            r1.u = r6
            r8 = 0
            r1.jk = r8
            r9 = r19
            r9.u = r6
            r2 = 0
            r0 = r14
            r3 = r17
            r4 = r18
            r5 = r20
            org.json.JSONArray r10 = r0.xj(r1, r2, r3, r4, r5)
            r11 = r1
            r4 = 0
            r5 = 0
            r1 = 0
            r2 = r20
            r7 = r23
            r3 = r6
            r6 = r22
            int r1 = r0.xj(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.length()
            r12 = 1
            if (r0 != 0) goto L3e
            r0 = 1
            goto L3f
        L3e:
            r0 = 0
        L3f:
            r11.am = r0
            boolean r0 = r14.xj(r7)
            r13 = 0
            if (r0 != 0) goto L50
            boolean r0 = r11.am
            if (r0 != 0) goto L4d
            goto L50
        L4d:
            r2 = r20
            goto L72
        L50:
            boolean r0 = r11.am
            if (r0 != 0) goto L57
            r2 = r17
            goto L58
        L57:
            r2 = r13
        L58:
            if (r0 != 0) goto L5f
            r4 = r10
        L5b:
            r3 = r2
            r0 = r9
            r9 = r1
            goto L61
        L5f:
            r4 = r13
            goto L5b
        L61:
            r7 = 0
            r2 = 0
            r1 = r15
            r5 = r22
            r6 = r23
            r0.xj(r1, r2, r3, r4, r5, r6, r7)
            r2 = r20
            r14.xj(r0, r8, r2, r12)
            r1 = r9
            r9 = r0
        L72:
            com.bytedance.embedapplog.vl[] r0 = com.bytedance.embedapplog.h.y
            int r0 = r0.length
            if (r1 >= r0) goto L8c
            r4 = 0
            r5 = 0
            r0 = r14
            r3 = r21
            r6 = r22
            r7 = r23
            int r1 = r0.xj(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r14.xj(r7)
            if (r2 == 0) goto L4d
            r2 = r13
            goto L5f
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.h.xj(org.json.JSONObject, com.bytedance.embedapplog.rg, com.bytedance.embedapplog.da, com.bytedance.embedapplog.k, com.bytedance.embedapplog.t, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean xj(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void xj(t tVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        boolean z4;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.kd.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    cu.hf(th);
                    if (z3) {
                        no.xj(sQLiteDatabase);
                        return;
                    }
                    return;
                } finally {
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, tVar.hf((ContentValues) null)) < 0) {
            if (tVar.v != null) {
                xj((String) null);
            }
            if (z3) {
                no.xj(sQLiteDatabase);
                return;
            }
            return;
        }
        long j = tVar.zg;
        if (j > 0) {
            z4 = z;
            sQLiteDatabase.execSQL(xj("event", tVar.tf, tVar.u, z4, j));
        } else {
            z4 = z;
        }
        long j2 = tVar.yo;
        if (j2 > 0) {
            sQLiteDatabase.execSQL(xj("eventv3", tVar.tf, tVar.u, z4, j2));
        }
        long j3 = tVar.pz;
        if (j3 > 0) {
            sQLiteDatabase.execSQL(xj("event_misc", tVar.tf, tVar.u, z4, j3));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z3) {
            no.xj(sQLiteDatabase);
        }
    }

    private int xj(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        hf.hf();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < y.length) {
            xj(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            w[i4].w = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void xj(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        Throwable th;
        vl vlVar = y[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(xj(vlVar, str, z, i, i3), null);
            for (int i4 = 0; rawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    vlVar.xj(rawQuery);
                    w[i2].xj(vlVar);
                    if (cu.hf) {
                        cu.xj("queryEvent, ".concat(String.valueOf(vlVar)), null);
                    }
                    jSONArray.put(vlVar.y());
                    long j2 = vlVar.xj;
                    if (j2 > j) {
                        j = j2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    try {
                        cu.hf(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        jSONArrayArr[i2] = jSONArray;
                        jArr[i2] = j;
                    } finally {
                    }
                }
            }
            rawQuery.close();
        } catch (Throwable th3) {
            th = th3;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        if (r12 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONArray xj(com.bytedance.embedapplog.rg r22, boolean r23, com.bytedance.embedapplog.da r24, com.bytedance.embedapplog.k r25, android.database.sqlite.SQLiteDatabase r26) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.h.xj(com.bytedance.embedapplog.rg, boolean, com.bytedance.embedapplog.da, com.bytedance.embedapplog.k, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r3 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.bytedance.embedapplog.t> xj() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap<java.lang.String, com.bytedance.embedapplog.vl> r1 = com.bytedance.embedapplog.h.hf
            java.lang.String r2 = "pack"
            java.lang.Object r1 = r1.get(r2)
            com.bytedance.embedapplog.t r1 = (com.bytedance.embedapplog.t) r1
            r2 = 0
            com.bytedance.embedapplog.h$xj r3 = r5.kd     // Catch: java.lang.Throwable -> L35
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = "SELECT * FROM pack ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L35
        L1c:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L31
            com.bytedance.embedapplog.vl r1 = r1.clone()     // Catch: java.lang.Throwable -> L2f
            com.bytedance.embedapplog.t r1 = (com.bytedance.embedapplog.t) r1     // Catch: java.lang.Throwable -> L2f
            r1.xj(r3)     // Catch: java.lang.Throwable -> L2f
            r0.add(r1)     // Catch: java.lang.Throwable -> L2f
            goto L1c
        L2f:
            r1 = move-exception
            goto L37
        L31:
            r3.close()
            goto L3d
        L35:
            r1 = move-exception
            r3 = r2
        L37:
            com.bytedance.embedapplog.cu.hf(r1)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L3d
            goto L31
        L3d:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "queryPack, "
            java.lang.String r1 = r3.concat(r1)
            com.bytedance.embedapplog.cu.xj(r1, r2)
            return r0
        L4b:
            r0 = move-exception
            if (r3 == 0) goto L51
            r3.close()
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.h.xj():java.util.ArrayList");
    }

    public void xj(ArrayList<t> arrayList, ArrayList<t> arrayList2, ArrayList<t> arrayList3) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        cu.xj("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<t> it = arrayList2.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.hf) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            writableDatabase = this.kd.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                Iterator<t> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    t next2 = it2.next();
                    if (arrayList3.contains(next2)) {
                        xj(next2, true, writableDatabase, false);
                    } else {
                        writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.xj)});
                    }
                }
            } catch (Throwable th2) {
                cu.hf(th2);
            }
            Iterator<t> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                t next3 = it3.next();
                if (next3.v != null) {
                    xj((String) null);
                }
                if (!arrayList3.contains(next3)) {
                    long j = next3.xj;
                    int i = next3.g + 1;
                    next3.g = i;
                    writableDatabase.execSQL(xj(j, i));
                }
            }
            writableDatabase.setTransactionSuccessful();
            no.xj(writableDatabase);
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = writableDatabase;
            try {
                cu.hf(th);
            } finally {
                no.xj(sQLiteDatabase);
            }
        }
    }

    public void xj(ArrayList<vl> arrayList) {
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.kd.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator<vl> it = arrayList.iterator();
                ContentValues contentValues = null;
                while (it.hasNext()) {
                    vl next = it.next();
                    String u = next.u();
                    contentValues = next.hf(contentValues);
                    next.xj = writableDatabase.insert(u, null, contentValues);
                    if ("event".equals(next.u())) {
                        arrayList3.add(next);
                    } else if ("eventv3".equals(next.u())) {
                        arrayList3.add(next);
                    } else if (next instanceof rg) {
                        arrayList2.add((rg) next);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                no.xj(writableDatabase);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    cu.hf(th);
                } finally {
                    no.xj(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
