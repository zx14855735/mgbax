package com.bykv.vk.openvk.component.video.xj.hf.xj;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.openvk.component.video.xj.hf.kd;
import com.bykv.vk.openvk.component.video.xj.hf.u;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends com.bykv.vk.openvk.component.video.xj.hf.xj.xj {
    private volatile long c;
    private final hf d;
    private volatile float f;
    private final LinkedHashMap<String, File> hf = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock.WriteLock kd;
    private final Handler p;
    private final Runnable tf;
    private final ReentrantReadWriteLock.ReadLock u;
    private final ReentrantReadWriteLock w;
    public final File xj;
    private final Set<xj> y;

    public static final class hf {
        private final Map<String, Integer> xj;

        private hf() {
            this.xj = new HashMap();
        }

        public synchronized void hf(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.xj.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.xj.remove(str);
                    return;
                }
                this.xj.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized boolean w(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.xj.containsKey(str);
        }

        public synchronized void xj(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.xj.get(str);
                if (num == null) {
                    this.xj.put(str, 1);
                    return;
                }
                this.xj.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    public interface xj {
        void xj(String str);

        void xj(Set<String> set);
    }

    public w(File file) {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.w = reentrantReadWriteLock;
        this.u = reentrantReadWriteLock.readLock();
        this.kd = reentrantReadWriteLock.writeLock();
        this.y = Collections.newSetFromMap(new ConcurrentHashMap());
        this.c = 104857600L;
        this.f = 0.5f;
        this.d = new hf();
        this.tf = new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.w.1
            @Override // java.lang.Runnable
            public void run() {
                c.hf(new d("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.w.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        w wVar = w.this;
                        wVar.hf(wVar.c);
                    }
                });
            }
        };
        this.p = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.xj = file;
            c.hf(new d("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.this.hf();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  ".concat(String.valueOf(str)));
    }

    private void w() {
        this.p.removeCallbacks(this.tf);
        this.p.postDelayed(this.tf, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public File u(String str) {
        if (!this.u.tryLock()) {
            return null;
        }
        File file = this.hf.get(str);
        this.u.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        this.kd.lock();
        try {
            File[] listFiles = this.xj.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.w.3
                    @Override // java.util.Comparator
                    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long longValue = ((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        return longValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.hf.put(xj(file2), file2);
                }
            }
            this.kd.unlock();
            w();
        } catch (Throwable th) {
            this.kd.unlock();
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public File w(String str) {
        this.u.lock();
        File file = this.hf.get(str);
        this.u.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.xj, str);
        this.kd.lock();
        this.hf.put(str, file2);
        this.kd.unlock();
        Iterator<xj> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().xj(str);
        }
        w();
        return file2;
    }

    public void xj(xj xjVar) {
        if (xjVar != null) {
            this.y.add(xjVar);
        }
    }

    public void xj(long j) {
        this.c = j;
        w();
    }

    public void xj() {
        u.w().u();
        Context context = kd.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.xj.hf.hf.w.xj(context).xj(0);
        }
        this.p.removeCallbacks(this.tf);
        c.hf(new d("clear", 1) { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.w.4
            @Override // java.lang.Runnable
            public void run() {
                w.this.hf(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.xj(str);
    }

    private String xj(File file) {
        return file.getName();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.hf(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6 A[LOOP:3: B:39:0x00e0->B:41:0x00e6, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(long r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.hf.xj.w.hf(long):void");
    }
}
