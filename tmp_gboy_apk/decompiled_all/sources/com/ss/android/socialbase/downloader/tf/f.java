package com.ss.android.socialbase.downloader.tf;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f<K, T> extends LinkedHashMap<K, T> {
    private int xj;

    public f() {
        this(4, 4);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.xj;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public f(int i, int i2) {
        this(i, i2, true);
    }

    public f(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        xj(i2);
    }
}
