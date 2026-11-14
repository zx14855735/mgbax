package com.bytedance.sdk.component.f.hf.kd;

import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf implements Comparable<hf>, Runnable {
    private String w;
    private int xj = 5;
    private String hf = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public hf(String str) {
        this.w = str;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public int xj() {
        return this.xj;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
        if (xj() < hfVar.xj()) {
            return 1;
        }
        return xj() >= hfVar.xj() ? -1 : 0;
    }
}
