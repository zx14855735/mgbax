package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class pl<V> {
    private final Throwable hf;
    private final V xj;

    public pl(V v) {
        this.xj = v;
        this.hf = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pl)) {
            return false;
        }
        pl plVar = (pl) obj;
        if (xj() != null && xj().equals(plVar.xj())) {
            return true;
        }
        if (hf() == null || plVar.hf() == null) {
            return false;
        }
        return hf().toString().equals(hf().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{xj(), hf()});
    }

    public Throwable hf() {
        return this.hf;
    }

    public V xj() {
        return this.xj;
    }

    public pl(Throwable th) {
        this.hf = th;
        this.xj = null;
    }
}
