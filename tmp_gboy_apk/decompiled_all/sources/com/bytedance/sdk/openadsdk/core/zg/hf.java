package com.bytedance.sdk.openadsdk.core.zg;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf {
    private static volatile long hf;
    private static volatile boolean xj;
    private Handler u;
    private final Queue<xj> w = new LinkedList();

    public static class xj {
        private final String hf;
        private final long xj;

        private xj(long j, String str) {
            this.xj = j;
            this.hf = str;
        }
    }

    private synchronized boolean hf(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int hf2 = hf();
        long w = w();
        if (this.w.size() <= 0 || this.w.size() < hf2) {
            this.w.offer(new xj(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - this.w.peek().xj);
            if (abs <= w) {
                hf(w - abs);
                return true;
            }
            this.w.poll();
            this.w.offer(new xj(currentTimeMillis, str));
        }
        return false;
    }

    public abstract int hf();

    public synchronized String kd() {
        String str;
        try {
            HashMap hashMap = new HashMap();
            for (xj xjVar : this.w) {
                if (hashMap.containsKey(xjVar.hf)) {
                    hashMap.put(xjVar.hf, Integer.valueOf(((Integer) hashMap.get(xjVar.hf)).intValue() + 1));
                } else {
                    hashMap.put(xjVar.hf, 1);
                }
            }
            str = "";
            int i = Integer.MIN_VALUE;
            for (String str2 : hashMap.keySet()) {
                int intValue = ((Integer) hashMap.get(str2)).intValue();
                if (i < intValue) {
                    str = str2;
                    i = intValue;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    public boolean u() {
        return xj;
    }

    public abstract long w();

    public synchronized boolean xj(String str) {
        try {
            if (hf(str)) {
                xj(true);
                xj(hf);
            } else {
                xj(false);
            }
        } catch (Throwable th) {
            throw th;
        }
        return xj;
    }

    private void xj(long j) {
        if (this.u == null) {
            this.u = new Handler(Looper.getMainLooper());
        }
        this.u.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zg.hf.1
            @Override // java.lang.Runnable
            public void run() {
                hf.this.xj(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(boolean z) {
        xj = z;
    }

    private synchronized void hf(long j) {
        hf = j;
    }
}
