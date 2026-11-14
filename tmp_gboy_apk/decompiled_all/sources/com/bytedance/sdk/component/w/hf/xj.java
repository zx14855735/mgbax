package com.bytedance.sdk.component.w.hf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.w.hf.v;
import com.czhj.sdk.common.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    final ProxySelector c;
    final SSLSocketFactory d;
    final Proxy f;
    final qt hf;
    final List<dk> kd;
    final c p;
    final HostnameVerifier tf;
    final hf u;
    final SocketFactory w;
    final v xj;
    final List<p> y;

    public xj(String str, int i, qt qtVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, c cVar, hf hfVar, Proxy proxy, List<dk> list, List<p> list2, ProxySelector proxySelector) {
        this.xj = new v.xj().xj(sSLSocketFactory != null ? "https" : Constants.HTTP).u(str).xj(i).w();
        if (qtVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.hf = qtVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.w = socketFactory;
        if (hfVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.u = hfVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.kd = com.bytedance.sdk.component.w.hf.xj.w.xj(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.y = com.bytedance.sdk.component.w.hf.xj.w.xj(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.c = proxySelector;
        this.f = proxy;
        this.d = sSLSocketFactory;
        this.tf = hostnameVerifier;
        this.p = cVar;
    }

    public ProxySelector c() {
        return this.c;
    }

    public SSLSocketFactory d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xj)) {
            return false;
        }
        xj xjVar = (xj) obj;
        return this.xj.equals(xjVar.xj) && xj(xjVar);
    }

    public Proxy f() {
        return this.f;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + A2egSU.A5SV6n(this.y, A2egSU.A5SV6n(this.kd, (this.u.hashCode() + ((this.hf.hashCode() + ((this.xj.hashCode() + 527) * 31)) * 31)) * 31, 31), 31)) * 31;
        Proxy proxy = this.f;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.d;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.tf;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        c cVar = this.p;
        return hashCode4 + (cVar != null ? cVar.hashCode() : 0);
    }

    public qt hf() {
        return this.hf;
    }

    public List<dk> kd() {
        return this.kd;
    }

    public c p() {
        return this.p;
    }

    public HostnameVerifier tf() {
        return this.tf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.xj.c());
        sb.append(":");
        sb.append(this.xj.f());
        if (this.f != null) {
            sb.append(", proxy=");
            sb.append(this.f);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.c);
        }
        sb.append("}");
        return sb.toString();
    }

    public hf u() {
        return this.u;
    }

    public SocketFactory w() {
        return this.w;
    }

    public v xj() {
        return this.xj;
    }

    public List<p> y() {
        return this.y;
    }

    public boolean xj(xj xjVar) {
        return this.hf.equals(xjVar.hf) && this.u.equals(xjVar.u) && this.kd.equals(xjVar.kd) && this.y.equals(xjVar.y) && this.c.equals(xjVar.c) && com.bytedance.sdk.component.w.hf.xj.w.xj(this.f, xjVar.f) && com.bytedance.sdk.component.w.hf.xj.w.xj(this.d, xjVar.d) && com.bytedance.sdk.component.w.hf.xj.w.xj(this.tf, xjVar.tf) && com.bytedance.sdk.component.w.hf.xj.w.xj(this.p, xjVar.p) && xj().f() == xjVar.xj().f();
    }
}
