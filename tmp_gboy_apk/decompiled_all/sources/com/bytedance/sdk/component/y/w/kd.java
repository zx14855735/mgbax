package com.bytedance.sdk.component.y.w;

import android.content.Context;
import com.bytedance.sdk.component.y.ai;
import com.bytedance.sdk.component.y.io;
import com.bytedance.sdk.component.y.j;
import com.bytedance.sdk.component.y.v;
import com.bytedance.sdk.component.y.x;
import com.bytedance.sdk.component.y.yo;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements v {
    private io c;
    private j d;
    private com.bytedance.sdk.component.y.hf f;
    private ExecutorService hf;
    private ai kd;
    private x u;
    private com.bytedance.sdk.component.y.kd w;
    private yo xj;
    private com.bytedance.sdk.component.y.u y;

    public static class xj {
        private io c;
        private j d;
        private com.bytedance.sdk.component.y.hf f;
        private ExecutorService hf;
        private ai kd;
        private x u;
        private com.bytedance.sdk.component.y.kd w;
        private yo xj;
        private com.bytedance.sdk.component.y.u y;

        public xj xj(com.bytedance.sdk.component.y.hf hfVar) {
            this.f = hfVar;
            return this;
        }

        public xj xj(ExecutorService executorService) {
            this.hf = executorService;
            return this;
        }

        public xj xj(com.bytedance.sdk.component.y.kd kdVar) {
            this.w = kdVar;
            return this;
        }

        public kd xj() {
            return new kd(this);
        }
    }

    @Override // com.bytedance.sdk.component.y.v
    public com.bytedance.sdk.component.y.u c() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.y.v
    public com.bytedance.sdk.component.y.hf d() {
        return this.f;
    }

    @Override // com.bytedance.sdk.component.y.v
    public io f() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.y.v
    public ExecutorService hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.v
    public x kd() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.v
    public com.bytedance.sdk.component.y.kd u() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.v
    public j w() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.y.v
    public yo xj() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.y.v
    public ai y() {
        return this.kd;
    }

    private kd(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y;
        this.f = xjVar.f;
        this.c = xjVar.c;
        this.d = xjVar.d;
    }

    public static kd xj(Context context) {
        return new xj().xj();
    }
}
