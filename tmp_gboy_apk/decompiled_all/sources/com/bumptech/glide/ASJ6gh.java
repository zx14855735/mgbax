package com.bumptech.glide;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f9928A2egSU = new HashMap();

    public ASJ6gh update(AYUAbz aYUAbz, boolean z) {
        HashMap hashMap = this.f9928A2egSU;
        if (z) {
            hashMap.put(aYUAbz.getClass(), aYUAbz);
            return this;
        }
        hashMap.remove(aYUAbz.getClass());
        return this;
    }
}
