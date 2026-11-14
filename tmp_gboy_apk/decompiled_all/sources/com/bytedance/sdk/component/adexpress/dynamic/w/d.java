package com.bytedance.sdk.component.adexpress.dynamic.w;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public float hf;
    public float xj;

    public d(float f, float f2) {
        this.xj = f;
        this.hf = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (Float.compare(dVar.xj, this.xj) == 0 && Float.compare(dVar.hf, this.hf) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.xj), Float.valueOf(this.hf)});
    }
}
