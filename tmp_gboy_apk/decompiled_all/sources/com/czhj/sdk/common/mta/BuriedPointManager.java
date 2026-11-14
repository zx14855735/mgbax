package com.czhj.sdk.common.mta;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.DeflaterOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BuriedPointManager {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10557a = 500000;
    private static BuriedPointManager f;
    private volatile boolean e;
    private SQLiteDatabase h;
    private int i;
    private RepeatingHandlerRunnable j;
    private final ReadWriteLock b = new ReentrantReadWriteLock();
    private HashMap<Integer, String> c = null;
    private List<String> d = null;
    private final Set<Integer> g = new HashSet();

    private BuriedPointManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.h.execSQL("delete from point where item is null");
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        List<String> list = this.d;
        if (list != null && !list.isEmpty()) {
            this.i = this.d.size();
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b.writeLock().lock();
        HashMap<Integer, String> hashMap = this.c;
        if (hashMap != null && !hashMap.isEmpty()) {
            a(this.c.keySet());
            this.e = false;
            this.c = null;
        }
        this.b.writeLock().unlock();
    }

    public static String deflateAndBase64(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
        deflaterOutputStream.flush();
        deflaterOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private void e() {
        List<String> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.d.size();
        int i = this.i;
        if (size > i) {
            this.d = this.d.subList(i, r0.size() - 1);
        } else {
            this.d.clear();
        }
        this.i = 0;
    }

    public static BuriedPointManager getInstance() {
        BuriedPointManager buriedPointManager;
        synchronized (BuriedPointManager.class) {
            try {
                if (f == null) {
                    f = new BuriedPointManager();
                }
                buriedPointManager = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return buriedPointManager;
    }

    public void addWaitSend(String str) {
        if (this.d == null) {
            this.d = new LinkedList();
        }
        this.d.add(str);
    }

    public void clearLogDB() {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.2
            @Override // java.lang.Runnable
            public void run() {
                BuriedPointManager.this.b();
                BuriedPointManager.this.a();
            }
        });
    }

    public Set<Integer> getLogBlackList() {
        return this.g;
    }

    public String sendPoint() {
        HashMap<Integer, String> hashMap;
        String str = null;
        try {
            this.b.readLock().lock();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        if (!this.e && ((hashMap = this.c) == null || hashMap.isEmpty())) {
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, String> a2 = a(Config.sharedInstance().getMax_send_log_records());
            this.c = a2;
            if (!a2.isEmpty()) {
                sb.append("[");
                Iterator<String> it = this.c.values().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    if (it.hasNext()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                String sb2 = sb.toString();
                String str2 = "_batch_value=" + sb2;
                try {
                    SigmobLog.d("_batch_value: " + sb2);
                    SigmobLog.d("BPLog_Count: " + this.c.size());
                    str = PointEntitySuper.toURLEncoded(deflateAndBase64(str2));
                    a(str, true);
                } catch (IOException e) {
                    SigmobLog.e(e.getMessage());
                }
                return str;
            }
        }
        return null;
    }

    public void start() {
        if (this.h == null || this.j == null) {
            this.h = SQLiteMTAHelper.getInstance().getWritableDatabase();
            clearLogDB();
            HandlerThread handlerThread = new HandlerThread("sendLog");
            handlerThread.start();
            RepeatingHandlerRunnable repeatingHandlerRunnable = new RepeatingHandlerRunnable(new Handler(handlerThread.getLooper())) { // from class: com.czhj.sdk.common.mta.BuriedPointManager.1
                @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
                public void doWork() {
                    try {
                        BuriedPointManager.this.sendPoint();
                        BuriedPointManager.this.j.startRepeating(Config.sharedInstance().getSend_log_interval() * 1000);
                    } catch (Throwable th) {
                        A2egSU.BJ7GGh(th, new StringBuilder("retryFaildTracking error "));
                    }
                }
            };
            this.j = repeatingHandlerRunnable;
            repeatingHandlerRunnable.startRepeating(Config.sharedInstance().getSend_log_interval() * 1000);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
    
        if (r1 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.HashMap<java.lang.Integer, java.lang.String> a(int r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.h     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "select * from point where item not null order by point_id"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L67
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L67
            java.lang.String r2 = "item"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "point_id"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "encryption"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5b
            r5 = 0
        L2a:
            if (r5 >= r11) goto L67
            java.lang.String r6 = r1.getString(r2)     // Catch: java.lang.Throwable -> L5b
            int r7 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L5b
            int r8 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L5b
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L5b
            if (r9 != 0) goto L5d
            r9 = 1
            if (r8 != r9) goto L57
            java.lang.String r8 = "sigandroid_mtadb"
            java.lang.String r8 = com.czhj.sdk.common.utils.AESUtil.DecryptString(r6, r8)     // Catch: java.lang.Throwable -> L5b
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L5b
            if (r8 != 0) goto L5d
            java.lang.String r8 = "sigandroid_mtadb"
            java.lang.String r6 = com.czhj.sdk.common.utils.AESUtil.DecryptString(r6, r8)     // Catch: java.lang.Throwable -> L5b
        L57:
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L5b
            goto L5d
        L5b:
            r11 = move-exception
            goto L6f
        L5d:
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5b
            if (r6 != 0) goto L64
            goto L67
        L64:
            int r5 = r5 + 1
            goto L2a
        L67:
            if (r1 == 0) goto L77
        L69:
            r1.close()     // Catch: java.lang.Throwable -> L6d
            goto L77
        L6d:
            r11 = move-exception
            goto L80
        L6f:
            java.lang.String r2 = "getlogs fail"
            com.czhj.sdk.logger.SigmobLog.e(r2, r11)     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L77
            goto L69
        L77:
            monitor-exit(r10)
            return r0
        L79:
            r11 = move-exception
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Throwable -> L6d
        L7f:
            throw r11     // Catch: java.lang.Throwable -> L6d
        L80:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6d
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.mta.BuriedPointManager.a(int):java.util.HashMap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            long queryNumEntries = DatabaseUtils.queryNumEntries(this.h, SQLiteMTAHelper.TABLE_POINT);
            if (queryNumEntries <= 500000) {
                return;
            }
            a(queryNumEntries - 500000);
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private void a(long j) {
        try {
            this.h.execSQL("delete from point where point_id in (  select point_id from point order by point_id  limit " + j + " )");
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private void a(String str, final boolean z) {
        this.e = true;
        BuriedPointRequest.BuriedPointSend(str, new BuriedPointRequest.RequestListener() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3
            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onErrorResponse(VolleyError volleyError) {
                BuriedPointManager.this.e = false;
                BuriedPointManager.this.c = null;
                SigmobLog.e(volleyError.getMessage());
            }

            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onSuccess() {
                if (z) {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BuriedPointManager.this.d();
                        }
                    });
                }
            }
        });
    }

    private void a(Set<Integer> set) {
        try {
            Iterator<Integer> it = set.iterator();
            if (!it.hasNext()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("delete from ");
            sb.append(SQLiteMTAHelper.TABLE_POINT);
            sb.append(" where point_id in ( ");
            while (true) {
                sb.append(it.next());
                if (!it.hasNext()) {
                    sb.append(" )");
                    this.h.execSQL(sb.toString());
                    return;
                } else {
                    sb.append(',');
                    sb.append(' ');
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }
}
