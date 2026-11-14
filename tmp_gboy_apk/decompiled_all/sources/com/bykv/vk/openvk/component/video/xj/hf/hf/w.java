package com.bykv.vk.openvk.component.video.xj.hf.hf;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.tf.tf;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile w hf;
    private volatile SQLiteStatement kd;
    private final Executor u;
    private final u w;
    private final SparseArray<Map<String, xj>> xj;

    private w(Context context) {
        SparseArray<Map<String, xj>> sparseArray = new SparseArray<>(2);
        this.xj = sparseArray;
        this.u = new com.bytedance.sdk.component.tf.u.u(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new tf(5, "video_proxy_db"));
        this.w = new u(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, xj> map = this.xj.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.u.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.hf.w.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w.this.w.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void insert(final xj xjVar) {
        if (xjVar != null) {
            Map<String, xj> map = this.xj.get(xjVar.u);
            if (map != null) {
                map.put(xjVar.xj, xjVar);
            }
            this.u.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.hf.w.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (w.this.kd == null) {
                            w wVar = w.this;
                            wVar.kd = wVar.w.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            w.this.kd.clearBindings();
                        }
                        w.this.kd.bindString(1, xjVar.xj);
                        w.this.kd.bindString(2, xjVar.hf);
                        w.this.kd.bindLong(3, xjVar.w);
                        w.this.kd.bindLong(4, xjVar.u);
                        w.this.kd.bindString(5, xjVar.kd);
                        w.this.kd.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public xj query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, xj> map = this.xj.get(i);
        xj xjVar = map == null ? null : map.get(str);
        if (xjVar != null) {
            return xjVar;
        }
        try {
            Cursor query = this.w.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    xjVar = new xj(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex("contentLength")), i, query.getString(query.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA)));
                }
                query.close();
            }
            if (xjVar != null && map != null) {
                map.put(str, xjVar);
            }
            return xjVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String hf(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static w xj(Context context) {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w(context);
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public void xj(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, xj> map = this.xj.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.w.getWritableDatabase().delete("video_http_header_t", "key IN(" + hf(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void xj(final int i) {
        Map<String, xj> map = this.xj.get(i);
        if (map != null) {
            map.clear();
        }
        this.u.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.hf.w.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w.this.w.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
