package com.bytedance.sdk.component.w.hf;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class j {
    final Proxy hf;
    final InetSocketAddress w;
    final xj xj;

    public j(xj xjVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (xjVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.xj = xjVar;
        this.hf = proxy;
        this.w = inetSocketAddress;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.xj.equals(this.xj) && jVar.hf.equals(this.hf) && jVar.w.equals(this.w);
    }

    public int hashCode() {
        return this.w.hashCode() + ((this.hf.hashCode() + ((this.xj.hashCode() + 527) * 31)) * 31);
    }

    public Proxy hf() {
        return this.hf;
    }

    public String toString() {
        return "Route{" + this.w + "}";
    }

    public boolean u() {
        return this.xj.d != null && this.hf.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress w() {
        return this.w;
    }

    public xj xj() {
        return this.xj;
    }
}
