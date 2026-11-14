package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.g;
import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.zg;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends zg {
    private com.bytedance.sdk.component.hf.xj.xj.xj.xj hf;

    public static class xj implements com.bytedance.sdk.component.hf.xj.hf {
        com.bytedance.sdk.component.w.hf.kd xj;

        public xj(com.bytedance.sdk.component.w.hf.kd kdVar) {
            this.xj = kdVar;
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf
        public com.bytedance.sdk.component.hf.xj.zg hf() {
            return null;
        }

        /* renamed from: kd, reason: merged with bridge method [inline-methods] */
        public com.bytedance.sdk.component.hf.xj.hf clone() {
            return null;
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf
        public boolean u() {
            return this.xj.u();
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf
        public void w() {
            this.xj.w();
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf
        public void xj(com.bytedance.sdk.component.hf.xj.w wVar) {
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf
        public am xj() {
            return new f(this.xj.xj());
        }
    }

    public w(com.bytedance.sdk.component.hf.xj.xj.xj.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.zg
    public void xj(com.bytedance.sdk.component.w.hf.kd kdVar, InetSocketAddress inetSocketAddress, Proxy proxy, dk dkVar, IOException iOException) {
        super.xj(kdVar, inetSocketAddress, proxy, dkVar, iOException);
        com.bytedance.sdk.component.hf.xj.xj.xj.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.xj(new xj(kdVar), inetSocketAddress, proxy, xj(dkVar), iOException);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.zg
    public void xj(com.bytedance.sdk.component.w.hf.kd kdVar, IOException iOException) {
        super.xj(kdVar, iOException);
        com.bytedance.sdk.component.hf.xj.xj.xj.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.xj(new xj(kdVar), iOException);
        }
    }

    private g xj(dk dkVar) {
        try {
            return g.xj(dkVar.toString());
        } catch (IOException unused) {
            return null;
        }
    }
}
