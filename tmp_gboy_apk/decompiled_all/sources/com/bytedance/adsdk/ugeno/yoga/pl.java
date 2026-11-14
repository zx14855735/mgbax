package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends YogaNodeJNIBase {
    public void finalize() {
        try {
            g();
        } finally {
            super.finalize();
        }
    }

    public void g() {
        long j = this.xj;
        if (j != 0) {
            this.xj = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
