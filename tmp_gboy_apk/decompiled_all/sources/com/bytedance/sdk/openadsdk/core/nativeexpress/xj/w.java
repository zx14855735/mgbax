package com.bytedance.sdk.openadsdk.core.nativeexpress.xj;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private static volatile w hf = null;
    public static int xj = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.xj.w.w> kd;
    private final Object w = new Object();
    private final LruCache<String, xj> u = new LruCache<String, xj>(xj) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xj.w.1
        @Override // android.util.LruCache
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, xj xjVar) {
            return 1;
        }
    };
    private AtomicBoolean y = new AtomicBoolean(false);

    private w() {
    }

    private void w(String str) {
        if (!TextUtils.isEmpty(str) && this.u.size() > 0) {
            synchronized (this.w) {
                this.u.remove(str);
            }
        }
    }

    public static w xj() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public List<xj> hf() {
        boolean z = this.y.get();
        this.y.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "ugen_template", null, null, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex(f.f13353a);
                        int columnIndex2 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                        int columnIndex3 = query.getColumnIndex("url");
                        int columnIndex4 = query.getColumnIndex(PointParamKey.DATA);
                        int columnIndex5 = query.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = query.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? query.getString(columnIndex6) : null;
                            String string2 = query.getString(columnIndex);
                            String string3 = query.getString(columnIndex2);
                            String string4 = query.getString(columnIndex3);
                            xj xj2 = new xj().xj(string2).hf(string3).w(string4).u(query.getString(columnIndex4)).kd(string).xj(Long.valueOf(query.getLong(columnIndex5)));
                            arrayList.add(xj2);
                            synchronized (this.w) {
                                this.u.put(string2, xj2);
                            }
                            if (!z) {
                                if (this.kd == null) {
                                    this.kd = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.kd.contains(string2)) {
                                    this.kd.put(string2, new com.bytedance.sdk.component.adexpress.xj.w.w(string, string2, string3));
                                }
                            }
                        }
                    } while (query.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    pl.w("UGTmplDbHelper", "getUgenTemplate error", th);
                } finally {
                    query.close();
                }
            }
        }
        if (query != null) {
        }
        return arrayList;
    }

    public static String w() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    public xj xj(String str, String str2) {
        xj xjVar;
        xj xj2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.w) {
            xjVar = this.u.get(str);
        }
        if (xjVar != null) {
            if (TextUtils.equals(str2, xjVar.hf())) {
                return xjVar;
            }
            w(str2);
            return null;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                do {
                    int columnIndex = query.getColumnIndex(f.f13353a);
                    int columnIndex2 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                    int columnIndex3 = query.getColumnIndex("url");
                    int columnIndex4 = query.getColumnIndex(PointParamKey.DATA);
                    int columnIndex5 = query.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = query.getColumnIndex("rit");
                        String string = query.getString(columnIndex);
                        String string2 = query.getString(columnIndex2);
                        String string3 = query.getString(columnIndex3);
                        String string4 = query.getString(columnIndex4);
                        xj2 = new xj().xj(string).hf(string2).u(string4).w(string3).kd(columnIndex6 != -1 ? query.getString(columnIndex6) : null).xj(Long.valueOf(query.getLong(columnIndex5)));
                        synchronized (this.w) {
                            this.u.put(string, xj2);
                        }
                    }
                    return null;
                } while (query.moveToNext());
                return xj2;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public void hf(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.w wVar;
        try {
            if (this.kd != null && !this.kd.isEmpty() && (wVar = this.kd.get(str)) != null) {
                String xj2 = wVar.xj();
                if (!TextUtils.isEmpty(xj2)) {
                    com.bytedance.sdk.openadsdk.core.w.hf.xj().delete(xj2, str, true);
                }
                this.kd.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(xj xjVar, boolean z) {
        if (xjVar == null || TextUtils.isEmpty(xjVar.xj())) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "ugen_template", null, "id=?", new String[]{xjVar.xj()}, null, null, null);
        boolean z2 = query != null && query.getCount() > 0;
        if (z2) {
            try {
                r3 = query.moveToFirst() ? query.getString(query.getColumnIndex("rit")) : null;
                query.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f13353a, xjVar.xj());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, xjVar.hf());
        contentValues.put("url", xjVar.w());
        contentValues.put(PointParamKey.DATA, xjVar.kd());
        contentValues.put("rit", xjVar.y());
        contentValues.put("update_time", xjVar.u());
        if (z2) {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "ugen_template", contentValues, "id=?", new String[]{xjVar.xj()});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.w) {
            this.u.put(xjVar.xj(), xjVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.kd == null) {
                this.kd = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.xj.w.w wVar = new com.bytedance.sdk.component.adexpress.xj.w.w(xjVar.y(), xjVar.xj(), xjVar.hf());
            this.kd.put(xjVar.xj(), wVar);
            if (r3 != null) {
                com.bytedance.sdk.openadsdk.core.w.hf.xj().delete(r3, wVar.hf(), true);
            }
            com.bytedance.sdk.openadsdk.core.w.hf.xj().update(xjVar.y(), wVar, true);
        } catch (Throwable unused2) {
        }
    }

    public Set<xj> xj(String str) {
        xj xjVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex(f.f13353a);
                        if (columnIndex != -1) {
                            String string = query.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.w) {
                                    xjVar = this.u.get(string);
                                }
                                if (xjVar != null) {
                                    hashSet.add(xjVar);
                                } else {
                                    xj xjVar2 = new xj();
                                    int columnIndex2 = query.getColumnIndex(PointParamKey.DATA);
                                    if (columnIndex2 != -1) {
                                        String string2 = query.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            xjVar2.u(string2);
                                            xjVar2.xj(string);
                                            xjVar2.kd(str);
                                            int columnIndex3 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                                            int columnIndex4 = query.getColumnIndex("url");
                                            int columnIndex5 = query.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                xjVar2.hf(query.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                xjVar2.w(query.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                xjVar2.xj(Long.valueOf(query.getLong(columnIndex5)));
                                            }
                                            hashSet.add(xjVar2);
                                            synchronized (this.w) {
                                                this.u.put(string, xjVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (query.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    pl.w("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                } finally {
                    query.close();
                }
            }
        }
        if (query != null) {
        }
        return hashSet;
    }

    public void xj(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                w(strArr[i]);
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                hf(strArr[i]);
            }
        }
    }
}
