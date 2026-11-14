package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class x {
    private final SharedPreferences.Editor u;
    private final SharedPreferences w;
    private final ReentrantReadWriteLock xj = new ReentrantReadWriteLock();
    private final Map<String, String> hf = new HashMap();

    public x(Context context) {
        SharedPreferences hf = no.hf(context);
        this.w = hf;
        this.u = hf.edit();
    }

    public void hf(String str, String str2) {
        try {
            this.u.putString(str, str2);
            this.u.commit();
        } catch (Exception e) {
            v.hf("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public void xj(String str, String str2) {
        this.xj.writeLock().lock();
        try {
            this.hf.put(str, str2);
            v.xj("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.xj.writeLock().unlock();
        }
    }

    public String xj(String str) {
        String str2 = this.hf.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.xj.readLock().lock();
        try {
            String str3 = this.hf.get(str);
            if (TextUtils.isEmpty(str3)) {
                str3 = this.w.getString(str, "");
                if (!TextUtils.isEmpty(str3)) {
                    this.hf.put(str, str3);
                    if (v.hf()) {
                        v.xj("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return str3 != null ? str3 : "";
        } finally {
            this.xj.readLock().unlock();
        }
    }
}
