package com.bytedance.sdk.component.w.hf.xj.hf;

import com.bytedance.sdk.component.w.hf.j;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    private final Set<j> xj = new LinkedHashSet();

    public synchronized void hf(j jVar) {
        this.xj.remove(jVar);
    }

    public synchronized boolean w(j jVar) {
        return this.xj.contains(jVar);
    }

    public synchronized void xj(j jVar) {
        this.xj.add(jVar);
    }
}
