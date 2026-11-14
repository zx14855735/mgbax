package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class t {
    private static t E = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f12297a = "k";
    public static final String b = "p";
    public static final String c = "v";
    public static final String d = "l";
    public static final String e = "i";
    public static final String f = "a";
    public static final String g = "s";
    public static final String h = "n";
    public static final String i = "u";
    public static final String j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;
    private int z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    public class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bi.p, (SQLiteDatabase.CursorFactory) null, t.this.z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i >= 3 || i2 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public int c(int i2) {
        Cursor cursor;
        int i3 = 0;
        try {
            cursor = this.C.query(bi.q, new String[]{"n"}, "k=" + i2, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex("n"));
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return 0;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return i3;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    public boolean d(int i2) {
        Cursor cursor;
        boolean z = false;
        try {
            cursor = this.C.query(bi.q, new String[]{"s"}, "k=" + i2, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                            z = true;
                        }
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return false;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return z;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            try {
                if (E == null) {
                    E = new t(context);
                }
                tVar = E;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public boolean b(int i2) {
        Cursor cursor;
        boolean z = false;
        try {
            cursor = this.C.query(bi.q, new String[]{b}, "k=" + i2, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return false;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return z;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    public long a(s sVar) {
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.b));
        contentValues.put(p, Integer.valueOf(sVar.p));
        contentValues.put(b, sVar.c);
        contentValues.put(f, sVar.e);
        contentValues.put("l", sVar.h);
        contentValues.put(c, sVar.d);
        contentValues.put(q, sVar.n);
        contentValues.put(f, sVar.e);
        contentValues.put(r, sVar.o);
        contentValues.put(s, Long.valueOf(sVar.s));
        contentValues.put(w, Integer.valueOf(sVar.w));
        contentValues.put("at", Integer.valueOf(sVar.q));
        contentValues.put(x, Integer.valueOf(sVar.x));
        contentValues.put(y, Integer.valueOf(sVar.y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.j)) {
            contentValues.put(v, sVar.j);
        }
        try {
            if (b(sVar.f12296a)) {
                SQLiteDatabase sQLiteDatabase = this.C;
                return sQLiteDatabase.update(bi.q, contentValues, "k=" + sVar.f12296a, null);
            }
            contentValues.put(f12297a, Integer.valueOf(sVar.f12296a));
            return this.C.insert(bi.q, null, contentValues);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void b() {
        ArrayList arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a2 = r.a();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                s sVar2 = (s) it.next();
                if (a2 != null) {
                    a2.a(sVar2.e);
                }
                this.C.delete(bi.q, "k=" + sVar2.f12296a, null);
                List<Integer> list = r.b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f12296a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + bi.j + sVar2.f12296a);
                }
                if (a2.b() != null && a2.b().get(sVar2.c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bi.q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(i, (Integer) 0);
        try {
            this.C.update(bi.q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(x, Integer.valueOf(i3));
            this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public List<s> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.C.query(bi.q, null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        s sVar = new s();
                        sVar.f12296a = cursor.getInt(cursor.getColumnIndex(f12297a));
                        sVar.c = cursor.getString(cursor.getColumnIndex(b));
                        sVar.e = cursor.getString(cursor.getColumnIndex(f));
                        sVar.h = cursor.getString(cursor.getColumnIndex("l"));
                        sVar.d = cursor.getString(cursor.getColumnIndex(c));
                        sVar.s = cursor.getLong(cursor.getColumnIndex(s));
                        sVar.t = cursor.getInt(cursor.getColumnIndex(t));
                        sVar.w = cursor.getInt(cursor.getColumnIndex(w));
                        sVar.x = cursor.getInt(cursor.getColumnIndex(x));
                        boolean z = true;
                        if (cursor.getInt(cursor.getColumnIndex(y)) != 1) {
                            z = false;
                        }
                        sVar.y = z;
                        arrayList.add(sVar);
                    } catch (Throwable unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                return arrayList;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        return arrayList;
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        r1 = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.C.query(bi.q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f12296a = query.getInt(query.getColumnIndex(f12297a));
                            sVar.b = query.getInt(query.getColumnIndex("n"));
                            sVar.c = query.getString(query.getColumnIndex(b));
                            sVar.e = query.getString(query.getColumnIndex(f));
                            sVar.h = query.getString(query.getColumnIndex("l"));
                            sVar.d = query.getString(query.getColumnIndex(c));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex(t));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.j = query.getString(query.getColumnIndex(v));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            boolean z = true;
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public s a(int i2) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query(bi.q, null, "k=" + i2, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f12296a = i2;
                            sVar.b = query.getInt(query.getColumnIndex("n"));
                            sVar.c = query.getString(query.getColumnIndex(b));
                            sVar.e = query.getString(query.getColumnIndex(f));
                            sVar.h = query.getString(query.getColumnIndex("l"));
                            sVar.d = query.getString(query.getColumnIndex(c));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex(t));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.j = query.getString(query.getColumnIndex(v));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            boolean z = true;
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(i, Integer.valueOf(i3));
            return this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
