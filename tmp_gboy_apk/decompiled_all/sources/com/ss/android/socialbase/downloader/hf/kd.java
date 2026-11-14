package com.ss.android.socialbase.downloader.hf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.hf.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.y.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd extends w.xj implements jk {
    private static volatile SQLiteDatabase hf;
    private c kd;
    private c u;
    private c w;
    hf xj;
    private volatile boolean y;

    public kd() {
        this(false);
    }

    private void d() {
        hf.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (hf == null) {
            synchronized (kd.class) {
                try {
                    if (hf == null) {
                        hf = xj.xj().getWritableDatabase();
                        this.w = new c(hf, "downloader", com.ss.android.socialbase.downloader.constants.w.xj, com.ss.android.socialbase.downloader.constants.w.hf);
                        this.u = new c(hf, "downloadChunk", com.ss.android.socialbase.downloader.constants.w.w, com.ss.android.socialbase.downloader.constants.w.u);
                        this.kd = new c(hf, "segments", com.ss.android.socialbase.downloader.constants.w.kd, com.ss.android.socialbase.downloader.constants.w.y);
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        try {
            d();
            hf.delete("downloader", null, null);
            hf.delete("downloadChunk", null, null);
            hf.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                pl.xj(th);
            } finally {
                tf();
            }
        }
    }

    private void tf() {
        try {
            if (hf == null || !hf.inTransaction()) {
                return;
            }
            hf.endTransaction();
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        f();
        if (hf == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.3
            @Override // java.lang.Runnable
            public void run() {
                kd.this.xj(i, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo c(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void g(int i) {
        f();
        if (hf == null) {
            return;
        }
        try {
            xj(i, this.kd.hf());
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public Map<Long, d> pl(int i) {
        Cursor cursor;
        f();
        if (hf != null) {
            try {
                cursor = hf.rawQuery("SELECT * FROM segments WHERE _id = ?", new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        d dVar = new d(jSONArray.getJSONObject(i2));
                        hashMap.put(Long.valueOf(dVar.w()), dVar);
                    }
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    return hashMap;
                }
                com.ss.android.socialbase.downloader.tf.y.xj(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    pl.xj(th);
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> u(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> w(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public boolean y(final int i) {
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.11
            @Override // java.lang.Runnable
            public void run() {
                kd.this.kd(i);
                kd.this.u(i);
                kd.this.g(i);
            }
        });
        return true;
    }

    public kd(boolean z) {
        this.xj = null;
        if (z) {
            this.y = false;
            xj();
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo d(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd(int i) {
        c cVar;
        f();
        if (hf != null && (cVar = this.w) != null) {
            try {
                xj(i, cVar.hf());
                return true;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void hf(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void u(final int i) {
        f();
        if (hf == null || this.u == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.xj(i, kd.this.u.hf());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<com.ss.android.socialbase.downloader.model.hf> w(int i) {
        ArrayList arrayList = new ArrayList();
        f();
        if (hf != null) {
            Cursor cursor = null;
            try {
                cursor = hf.rawQuery("SELECT * FROM downloadChunk WHERE _id = ?", new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.hf(cursor));
                }
                com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                return arrayList;
            } catch (Throwable th) {
                try {
                    pl.xj(th);
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo tf(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i) {
        Cursor cursor;
        f();
        if (hf != null) {
            try {
                cursor = hf.rawQuery("SELECT * FROM downloader WHERE _id = ?", new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.tf.y.xj(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    pl.xj(th);
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!xj(downloadInfo.getId())) {
                w(downloadInfo);
                return;
            }
            c cVar = this.w;
            if (cVar == null) {
                return;
            }
            try {
                hf(downloadInfo, cVar.w());
            } catch (Throwable th) {
                pl.xj(th);
            }
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w
    public DownloadInfo kd(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo f(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ArrayList<d> am(int i) {
        Map<Long, d> pl2 = pl(i);
        if (pl2 == null || pl2.isEmpty()) {
            return null;
        }
        return new ArrayList<>(pl2.values());
    }

    @Override // com.ss.android.socialbase.downloader.hf.w
    public void xj() {
        xj(new SparseArray<>(), new SparseArray<>(), (u) null);
    }

    private void w(final DownloadInfo downloadInfo) {
        f();
        if (hf == null || this.w == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd kdVar = kd.this;
                    kdVar.xj(downloadInfo, kdVar.w.xj());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void hf(com.ss.android.socialbase.downloader.model.hf hfVar) {
        xj(hfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void xj(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> sparseArray2, final u uVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.1
                /* JADX WARN: Code restructure failed: missing block: B:140:0x027c, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:146:0x0285, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:185:0x033f, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:186:0x0341, code lost:
                
                    r0.xj();
                    r18.u.y = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:187:0x0349, code lost:
                
                    r18.u.xj(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:188:0x035b, code lost:
                
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:194:0x0358, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x01a9, code lost:
                
                    if (r0 != null) goto L85;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01ab, code lost:
                
                    r0.xj();
                    r18.u.y = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x01b3, code lost:
                
                    r18.u.xj(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x01bc, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01c2, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 885
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.hf.kd.AnonymousClass1.run():void");
                }
            };
            ExecutorService yo = com.ss.android.socialbase.downloader.downloader.w.yo();
            if (yo != null) {
                yo.execute(runnable);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void hf(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo u(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void w() {
        f();
        if (hf == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.2
            @Override // java.lang.Runnable
            public void run() {
                kd.this.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.tf.y.hf(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public boolean u() {
        return this.y;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo w(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || hf == null) {
            return;
        }
        synchronized (hf) {
            try {
                d();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.f.xj.w().xj("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        hf.delete("downloader", str, strArr);
                        hf.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        hf.delete("downloader", "_id IN (?)", new String[]{join});
                        hf.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    hf.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    hf.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.hf> w = w(keyAt);
                        if (w.size() > 0) {
                            hf.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.hf hfVar : w) {
                                hfVar.hf(downloadInfo.getId());
                                hf.insert("downloadChunk", null, hfVar.xj());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<com.ss.android.socialbase.downloader.model.hf> xj = com.ss.android.socialbase.downloader.tf.y.xj(w(id));
                        if (xj != null && xj.size() > 0) {
                            sparseArray3.put(id, xj);
                        }
                    }
                }
                hf.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        try {
            u(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.hf hfVar : list) {
                    if (hfVar != null) {
                        xj(hfVar);
                        if (hfVar.y()) {
                            Iterator<com.ss.android.socialbase.downloader.model.hf> it = hfVar.c().iterator();
                            while (it.hasNext()) {
                                xj(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w
    public boolean xj(int i) {
        try {
            return hf(i) != null;
        } catch (Throwable th) {
            pl.xj(th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> xj(String str) {
        f();
        ArrayList arrayList = new ArrayList();
        if (hf != null) {
            Cursor cursor = null;
            try {
                cursor = hf.rawQuery("SELECT * FROM downloader WHERE url = ?", new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                return arrayList;
            } catch (Throwable th) {
                try {
                    pl.xj(th);
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.tf.y.xj(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void xj(final com.ss.android.socialbase.downloader.model.hf hfVar) {
        f();
        if (hf == null || this.u == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.xj(hfVar, kd.this.u.xj());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar, SQLiteStatement sQLiteStatement) {
        if (hfVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                hfVar.xj(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void xj(final int i, final int i2, final long j) {
        f();
        if (i == 0 || i2 < 0 || j < 0 || hf == null || this.u == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.xj(i, i2, j, kd.this.u.w());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void xj(final int i, final int i2, final int i3, final long j) {
        f();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || hf == null || this.u == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.xj(i, i2, i3, j, kd.this.u.w());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public void xj(final int i, final int i2, final int i3, final int i4) {
        f();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || hf == null || this.u == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.xj(i, i2, i3, i4, kd.this.u.w());
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                hf.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hf.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hf.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, int i2) {
        f();
        if (hf == null) {
            return null;
        }
        int i3 = 10;
        while (hf.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            } catch (Throwable th2) {
                pl.xj(th2);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        hf.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(final DownloadInfo downloadInfo) {
        f();
        if (downloadInfo == null || hf == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.w.w(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.kd.10
            @Override // java.lang.Runnable
            public void run() {
                kd.this.u(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(int i, Map<Long, d> map) {
        long currentTimeMillis = System.currentTimeMillis();
        f();
        if (hf == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                l.longValue();
                jSONArray.put(map.get(l).p());
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        SQLiteStatement u = this.kd.u();
        synchronized (u) {
            u.clearBindings();
            u.bindLong(1, i);
            u.bindString(2, jSONArray.toString());
            u.execute();
        }
        com.ss.android.socialbase.downloader.w.xj.hf("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.tf.y.w(currentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, ContentValues contentValues) {
        int i2 = 10;
        while (hf.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            } catch (Throwable th2) {
                pl.xj(th2);
                return;
            }
        }
        try {
            hf.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            pl.xj(th3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.hf.w
    public void xj(hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> sparseArray2) {
        try {
            HashMap xj = com.ss.android.socialbase.downloader.tf.y.xj(sparseArray);
            HashMap xj2 = com.ss.android.socialbase.downloader.tf.y.xj(sparseArray2);
            hf hfVar = this.xj;
            if (hfVar != null) {
                hfVar.xj(xj, xj2);
            }
        } catch (Throwable unused) {
        }
    }
}
