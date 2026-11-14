package com.bytedance.sdk.component.f.hf.xj.xj.hf;

import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.cache.DatabaseHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf extends com.bytedance.sdk.component.f.hf.xj.xj implements w {
    private final Context hf;
    private com.bytedance.sdk.component.f.hf.u.hf.xj u;
    private com.bytedance.sdk.component.f.xj.kd w;
    protected final List<com.bytedance.sdk.component.f.xj.hf> xj = new ArrayList();
    private boolean kd = false;
    private final Runnable y = new Runnable() { // from class: com.bytedance.sdk.component.f.hf.xj.xj.hf.hf.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (hf.this) {
                try {
                    if (hf.this.xj.isEmpty()) {
                        hf.this.kd = false;
                        return;
                    }
                    ArrayList arrayList = new ArrayList(hf.this.xj);
                    hf.this.xj.clear();
                    hf.this.kd = false;
                    hf.this.hf(arrayList);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public hf(Context context, com.bytedance.sdk.component.f.xj.kd kdVar, com.bytedance.sdk.component.f.hf.u.hf.xj xjVar) {
        this.hf = context;
        this.w = kdVar;
        this.u = xjVar;
    }

    private void hf() {
        if (this.kd) {
            return;
        }
        com.bytedance.sdk.component.f.hf.c.xj.xj(u()).xj().postDelayed(this.y, r0.hf());
        this.kd = true;
    }

    public Context getContext() {
        return this.hf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int kd() {
        /*
            r11 = this;
            r1 = 0
            r0 = 0
            android.content.Context r2 = r11.getContext()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r3 = r11.xj()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            com.bytedance.sdk.component.f.xj.kd r10 = r11.w     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.f.hf.xj.xj.hf.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r1 == 0) goto L29
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            goto L29
        L25:
            r0 = move-exception
            goto L2f
        L27:
            goto L35
        L29:
            if (r1 == 0) goto L38
        L2b:
            r1.close()     // Catch: java.lang.Exception -> L38
            goto L38
        L2f:
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.lang.Exception -> L34
        L34:
            throw r0
        L35:
            if (r1 == 0) goto L38
            goto L2b
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.xj.xj.hf.hf.kd():int");
    }

    public abstract com.bytedance.sdk.component.f.xj.kd u();

    public abstract String xj();

    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, int i2, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z) {
        int hf;
        if (this.u == null || hfVar == null || !com.bytedance.sdk.component.f.hf.w.xj.xj(i) || !xj(hfVar) || (hf = this.u.hf()) <= i2) {
            return null;
        }
        return xj(hf - i2, DatabaseHelper.COLUMN_ID, i, z);
    }

    public synchronized void hf(com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (xj(hfVar) && hfVar.c() != null && !TextUtils.isEmpty(hfVar.w())) {
            this.xj.add(hfVar);
            hf();
        }
    }

    public com.bytedance.sdk.component.f.hf.xj.hf xj(int i, List<com.bytedance.sdk.component.f.xj.hf> list) {
        com.bytedance.sdk.component.f.hf.xj.hf hfVar = new com.bytedance.sdk.component.f.hf.xj.hf();
        if (list != null && list.size() != 0 && list.get(0) != null && xj(list.get(0))) {
            if (i != 200 && i != -1 && i != -3) {
                hfVar.xj("code:".concat(String.valueOf(i)));
            } else {
                hfVar.xj(delete(list));
            }
            hfVar.xj(true);
            return hfVar;
        }
        hfVar.xj(false);
        return hfVar;
    }

    public void hf(List<com.bytedance.sdk.component.f.xj.hf> list) {
        com.bytedance.sdk.component.f.hf.xj.xj.hf.insert(getContext(), xj(), list, this.w);
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.f.hf.w.xj.xj(it.next(), this.w, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public List<com.bytedance.sdk.component.f.xj.hf> hf(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list, String str) {
        List<com.bytedance.sdk.component.f.xj.hf> xj = xj(DatabaseHelper.COLUMN_ID, i, z);
        if (!xj(xj, list)) {
            return null;
        }
        xj();
        xj.size();
        return xj;
    }

    public void xj(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.f.xj.hf> it = this.xj.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.f.xj.hf next = it.next();
                if (next != null) {
                    String w = next.w();
                    if (!TextUtils.isEmpty(w) && list.contains(w)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.xj("DBInsertMemRepo", xj() + "deleteMemList: " + th.getMessage(), this.w.kd());
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean hf(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (this.u == null) {
            return false;
        }
        int kd = kd();
        int xj = this.u.xj();
        com.bytedance.sdk.component.f.hf.w.w.xj("check db " + xj() + " count:" + kd + " MaxCacheCount:" + xj + " message:" + com.bytedance.sdk.component.f.hf.w.xj.hf(i), this.w);
        return kd >= xj;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(String str) {
        if (this.u == null) {
            return false;
        }
        int kd = kd();
        com.bytedance.sdk.component.f.hf.w.w.xj("check flush db " + xj() + " count:" + kd, this.w);
        return kd > 0;
    }

    private boolean xj(List<com.bytedance.sdk.component.f.xj.hf> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.f.xj.hf next = it.next();
                    if (next != null) {
                        String w = next.w();
                        if (!TextUtils.isEmpty(w) && list2.contains(w)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.f.hf.w.w.xj("DBInsertMemRepo", A2egSU.B4ZgIw(th, new StringBuilder("deleteMemList: ")), this.w);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
