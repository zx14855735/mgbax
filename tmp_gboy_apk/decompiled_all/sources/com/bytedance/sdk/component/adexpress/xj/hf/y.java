package com.bytedance.sdk.component.adexpress.xj.hf;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.pl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static volatile y hf = null;
    public static int xj = 2000;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.xj.w.w> kd;
    private final Object u = new Object();
    private AtomicBoolean y = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.xj.w.hf> c = new LruCache<String, com.bytedance.sdk.component.adexpress.xj.w.hf>(xj) { // from class: com.bytedance.sdk.component.adexpress.xj.hf.y.1
        @Override // android.util.LruCache
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.xj.w.hf hfVar) {
            return 1;
        }
    };
    private Set<String> w = Collections.synchronizedSet(new HashSet());

    private y() {
    }

    private void u(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.xj.w.hf> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.c) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.u) {
            this.c.remove(str);
        }
    }

    public static y xj() {
        if (hf == null) {
            synchronized (y.class) {
                try {
                    if (hf == null) {
                        hf = new y();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public Set<com.bytedance.sdk.component.adexpress.xj.w.hf> hf(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.hf hfVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor query = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.u) {
                                hfVar = this.c.get(string);
                            }
                            if (hfVar != null) {
                                hashSet.add(hfVar);
                            } else {
                                String string2 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                                String string3 = query.getString(query.getColumnIndex("url"));
                                String string4 = query.getString(query.getColumnIndex(PointParamKey.DATA));
                                String string5 = query.getString(query.getColumnIndex("version"));
                                com.bytedance.sdk.component.adexpress.xj.w.hf xj2 = new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(str).hf(string).w(string2).u(string3).kd(string4).y(string5).xj(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                                hashSet.add(xj2);
                                synchronized (this.u) {
                                    this.c.put(string, xj2);
                                }
                                this.w.add(string);
                            }
                        }
                    } while (query.moveToNext());
                }
                query.close();
                return hashSet;
            } catch (Exception unused) {
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        return hashSet;
    }

    public void w(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.w wVar;
        try {
            if (this.kd != null && !this.kd.isEmpty() && (wVar = this.kd.get(str)) != null) {
                String xj2 = wVar.xj();
                if (!TextUtils.isEmpty(xj2) && com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y() != null) {
                    com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y().delete(xj2, str);
                }
                this.kd.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public static String w() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    public com.bytedance.sdk.component.adexpress.xj.w.hf xj(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.hf hfVar;
        com.bytedance.sdk.component.adexpress.xj.w.hf xj2;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() == null) {
            return null;
        }
        synchronized (this.u) {
            hfVar = this.c.get(String.valueOf(str));
        }
        if (hfVar != null) {
            return hfVar;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("rit"));
                        String string2 = query.getString(query.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
                        String string3 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                        String string4 = query.getString(query.getColumnIndex("url"));
                        String string5 = query.getString(query.getColumnIndex(PointParamKey.DATA));
                        String string6 = query.getString(query.getColumnIndex("version"));
                        xj2 = new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(string).hf(string2).w(string3).u(string4).kd(string5).y(string6).xj(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                        synchronized (this.u) {
                            this.c.put(string2, xj2);
                        }
                        this.w.add(string2);
                    } while (query.moveToNext());
                    return xj2;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<com.bytedance.sdk.component.adexpress.xj.w.hf> hf() {
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() == null) {
            return null;
        }
        boolean z = this.y.get();
        this.y.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor query = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().query("template_diff_new", null, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("rit"));
                    String string2 = query.getString(query.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
                    String string3 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                    String string4 = query.getString(query.getColumnIndex("url"));
                    String string5 = query.getString(query.getColumnIndex(PointParamKey.DATA));
                    String string6 = query.getString(query.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(string).hf(string2).w(string3).u(string4).kd(string5).y(string6).xj(Long.valueOf(query.getLong(query.getColumnIndex("update_time")))));
                    synchronized (this.u) {
                        this.c.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.w.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y() != null) {
                        if (this.kd == null) {
                            this.kd = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.kd.contains(string2)) {
                            this.kd.put(string2, new com.bytedance.sdk.component.adexpress.xj.w.w(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        pl.w("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        query.close();
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public void xj(com.bytedance.sdk.component.adexpress.xj.w.hf hfVar, boolean z) {
        if (hfVar == null || com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() == null || TextUtils.isEmpty(hfVar.hf())) {
            return;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().query("template_diff_new", null, "id=?", new String[]{hfVar.hf()}, null, null, null);
        boolean z2 = query != null && query.getCount() > 0;
        if (query != null) {
            try {
                r2 = query.moveToFirst() ? query.getString(query.getColumnIndex("rit")) : null;
                query.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", hfVar.xj());
        contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, hfVar.hf());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, hfVar.w());
        contentValues.put("url", hfVar.u());
        contentValues.put(PointParamKey.DATA, hfVar.kd());
        contentValues.put("version", hfVar.y());
        contentValues.put("update_time", hfVar.c());
        if (z2) {
            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().update("template_diff_new", contentValues, "id=?", new String[]{hfVar.hf()});
        } else {
            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().insert("template_diff_new", contentValues);
        }
        synchronized (this.u) {
            this.c.put(hfVar.hf(), hfVar);
        }
        this.w.add(hfVar.hf());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y() == null) {
                return;
            }
            if (this.kd == null) {
                this.kd = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.xj.w.w wVar = new com.bytedance.sdk.component.adexpress.xj.w.w(hfVar.xj(), hfVar.hf(), hfVar.w());
            this.kd.put(hfVar.hf(), wVar);
            if (r2 != null) {
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y().delete(r2, wVar.hf());
            }
            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().y().update(hfVar.xj(), wVar);
        } catch (Throwable unused2) {
        }
    }

    public void xj(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                u(strArr[i]);
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                w(strArr[i]);
            }
        }
    }
}
