package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aa0aaaaa;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaac {
    private final Set aaaaaaaa = new LinkedHashSet();

    public synchronized void aaaaaaa0(aa0aaaaa aa0aaaaaVar) {
        this.aaaaaaaa.add(aa0aaaaaVar);
    }

    public synchronized void aaaaaaaa(aa0aaaaa aa0aaaaaVar) {
        this.aaaaaaaa.remove(aa0aaaaaVar);
    }

    public synchronized boolean aaaaaaao(aa0aaaaa aa0aaaaaVar) {
        return this.aaaaaaaa.contains(aa0aaaaaVar);
    }
}
