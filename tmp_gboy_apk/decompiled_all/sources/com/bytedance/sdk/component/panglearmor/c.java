package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private String hf;
    private f kd;
    private boolean u;
    private String w;
    private Context xj;

    public static class xj {
        private final String hf;
        private final String w;
        private final Context xj;
        private boolean u = false;
        private f kd = null;

        public xj(Context context, String str, String str2) {
            this.xj = context;
            this.w = str2;
            this.hf = str;
        }

        public void xj(f fVar) {
            this.kd = fVar;
        }

        public xj xj(boolean z) {
            this.u = z;
            return this;
        }

        public c xj() {
            c cVar = new c();
            cVar.xj = this.xj;
            cVar.hf = this.hf;
            cVar.w = this.w;
            cVar.kd = this.kd;
            cVar.u = this.u;
            return cVar;
        }
    }

    public f u() {
        return this.kd;
    }

    public boolean w() {
        return this.u;
    }

    public String hf() {
        return this.hf;
    }

    public Context xj() {
        return this.xj;
    }
}
