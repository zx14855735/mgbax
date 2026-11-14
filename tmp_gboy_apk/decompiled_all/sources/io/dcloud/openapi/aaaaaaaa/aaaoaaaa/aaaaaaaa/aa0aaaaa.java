package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aa0aaaaa {
    final Proxy aaaaaaa0;
    final aaaaaaaa aaaaaaaa;
    final InetSocketAddress aaaaaaao;

    public aa0aaaaa(aaaaaaaa aaaaaaaaVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aaaaaaaaVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.aaaaaaaa = aaaaaaaaVar;
        this.aaaaaaa0 = proxy;
        this.aaaaaaao = inetSocketAddress;
    }

    public Proxy aaaaaaa0() {
        return this.aaaaaaa0;
    }

    public aaaaaaaa aaaaaaaa() {
        return this.aaaaaaaa;
    }

    public InetSocketAddress aaaaaaac() {
        return this.aaaaaaao;
    }

    public boolean aaaaaaao() {
        return this.aaaaaaaa.aaaaaaeo != null && this.aaaaaaa0.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aa0aaaaa)) {
            return false;
        }
        aa0aaaaa aa0aaaaaVar = (aa0aaaaa) obj;
        return aa0aaaaaVar.aaaaaaaa.equals(this.aaaaaaaa) && aa0aaaaaVar.aaaaaaa0.equals(this.aaaaaaa0) && aa0aaaaaVar.aaaaaaao.equals(this.aaaaaaao);
    }

    public int hashCode() {
        return this.aaaaaaao.hashCode() + ((this.aaaaaaa0.hashCode() + ((this.aaaaaaaa.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        return "Route{" + this.aaaaaaao + "}";
    }
}
