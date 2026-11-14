package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a {
    private static volatile a NQ;
    private final SQLiteDatabase NO;
    private ConcurrentHashMap<String, e> NP = new ConcurrentHashMap<>();

    /* renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    public static class C0281a extends SQLiteOpenHelper {
        private static int NT = 1;
        private String NU;
        private String NV;

        public C0281a(Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, NT);
            this.NU = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.NV = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.NU);
            sQLiteDatabase.execSQL(this.NV);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private a(Context context) {
        this.NO = new C0281a(context).getWritableDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends j> void b(List<T> list, String str) {
        try {
            try {
                this.NO.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.NO.insertWithOnConflict(str, null, it.next().ox(), 5));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
                this.NO.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.NO;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.c.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.NO;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.c.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.NO;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.d.c.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    public static a om() {
        if (NQ == null) {
            synchronized (a.class) {
                if (NQ == null) {
                    try {
                        NQ = new a(ServiceProvider.Re());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        NQ = null;
                    }
                }
            }
        }
        return NQ;
    }

    public final e ag(String str) {
        Cursor cursor;
        e eVar;
        ConcurrentHashMap<String, e> concurrentHashMap = this.NP;
        if (concurrentHashMap != null && (eVar = concurrentHashMap.get(str)) != null) {
            A2egSU.B7CMnp("findCacheStrategyList from cache, posId: ", str, "AdCacheDBManager");
            return eVar;
        }
        Cursor cursor2 = null;
        try {
            cursor = this.NO.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            try {
                try {
                    List<e> a2 = e.a(cursor);
                    if (a2 != null && a2.size() > 0) {
                        e eVar2 = a2.get(0);
                        this.NP.put(str, eVar2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return eVar2;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return null;
    }

    public final void j(List<i> list) {
        b(list, "ksad_ad_cache");
    }

    public final void on() {
        try {
            this.NO.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final void oo() {
        Cursor cursor = null;
        try {
            cursor = this.NO.rawQuery("select  * from ksad_ad_cache_strategy", null);
            List<e> a2 = e.a(cursor);
            if (a2 != null && !a2.isEmpty()) {
                for (e eVar : a2) {
                    com.kwad.sdk.core.d.c.d("AdCacheDBManager", "readCacheStrategyList:" + eVar.ot());
                    this.NP.put(eVar.ot(), eVar);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    public final void w(long j) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.NO.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:45:0x0057 */
    public final List<i> a(String str, long j, int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.NO.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<i> a2 = i.a(cursor);
                    if (a2 == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (i iVar : a2) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(iVar.oH());
                            if (i2 == a2.size()) {
                                sb.append(")");
                            } else {
                                sb.append(" OR");
                            }
                        } else if (iVar.oF() >= j) {
                            arrayList.add(iVar);
                        }
                    }
                    if (i2 > i) {
                        this.NO.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    public final void a(final e eVar) {
        this.NP.put(eVar.ot(), eVar);
        GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.components.core.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
            }
        });
    }
}
