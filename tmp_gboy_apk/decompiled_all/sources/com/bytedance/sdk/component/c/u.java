package com.bytedance.sdk.component.c;

import android.content.Context;
import com.bytedance.sdk.component.u.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {

    public static class xj {
        private volatile String hf;
        private volatile boolean kd;
        private volatile boolean u;
        private volatile int w;
        private volatile Context xj;
        private volatile int y;

        private com.bytedance.sdk.component.u.hf.w w() {
            com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.component.c.hf.xj.xj.xj(this.xj, this.hf, this.u, this.y);
            this.kd = true;
            if (xj != null) {
                return xj;
            }
            this.kd = false;
            return hf();
        }

        public xj hf(int i) {
            this.y = i;
            return this;
        }

        public xj xj(Context context) {
            if (context == null) {
                return this;
            }
            this.xj = context.getApplicationContext();
            w.xj(this.xj);
            return this;
        }

        private com.bytedance.sdk.component.u.hf.w hf() {
            return this.u ? com.bytedance.sdk.component.c.w.xj.xj.xj(this.hf) : ((d) com.bytedance.sdk.openadsdk.ats.w.xj("kv_store_factory")).get(this.hf);
        }

        public xj xj(String str) {
            this.hf = str;
            return this;
        }

        public xj xj(int i) {
            this.w = i;
            return this;
        }

        public xj xj(boolean z) {
            this.u = z;
            return this;
        }

        public com.bytedance.sdk.component.u.hf.w xj() {
            if (this.w != 2) {
                return hf();
            }
            return w();
        }
    }
}
