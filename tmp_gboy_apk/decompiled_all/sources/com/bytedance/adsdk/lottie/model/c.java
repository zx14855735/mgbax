package com.bytedance.adsdk.lottie.model;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c<T> {
    T hf;
    T xj;

    private static boolean hf(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return hf(pair.first, this.xj) && hf(pair.second, this.hf);
    }

    public int hashCode() {
        T t = this.xj;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.hf;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.xj + " " + this.hf + "}";
    }

    public void xj(T t, T t2) {
        this.xj = t;
        this.hf = t2;
    }
}
