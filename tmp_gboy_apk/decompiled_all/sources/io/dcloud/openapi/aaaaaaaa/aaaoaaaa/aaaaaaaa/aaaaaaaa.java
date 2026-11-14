package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.Constants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa {
    final aeaaaaaa aaaaaaa0;
    final aaaaoaaa aaaaaaaa;
    final aaaaaaa0 aaaaaaac;
    final ProxySelector aaaaaaae;
    final List aaaaaaan;
    final SocketFactory aaaaaaao;
    final List aaaaaaau;
    final Proxy aaaaaaav;
    final SSLSocketFactory aaaaaaeo;
    final aaaaaaae aaaaeaaa;
    final HostnameVerifier aaaeaaaa;

    public aaaaaaaa(String str, int i, aeaaaaaa aeaaaaaaVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, aaaaaaae aaaaaaaeVar, aaaaaaa0 aaaaaaa0Var, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.aaaaaaaa = new aaaaoaaa.aaaaaaaa().aaaaaaan(sSLSocketFactory != null ? "https" : Constants.HTTP).aaaaaaa0(str).aaaaaaaa(i).aaaaaaaa();
        if (aeaaaaaaVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.aaaaaaa0 = aeaaaaaaVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.aaaaaaao = socketFactory;
        if (aaaaaaa0Var == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.aaaaaaac = aaaaaaa0Var;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.aaaaaaau = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.aaaaaaae = proxySelector;
        this.aaaaaaav = proxy;
        this.aaaaaaeo = sSLSocketFactory;
        this.aaaeaaaa = hostnameVerifier;
        this.aaaaeaaa = aaaaaaaeVar;
    }

    public List aaaaaaa0() {
        return this.aaaaaaan;
    }

    public aaaaaaae aaaaaaaa() {
        return this.aaaaeaaa;
    }

    public HostnameVerifier aaaaaaac() {
        return this.aaaeaaaa;
    }

    public aaaaaaa0 aaaaaaae() {
        return this.aaaaaaac;
    }

    public Proxy aaaaaaan() {
        return this.aaaaaaav;
    }

    public aeaaaaaa aaaaaaao() {
        return this.aaaaaaa0;
    }

    public List aaaaaaau() {
        return this.aaaaaaau;
    }

    public ProxySelector aaaaaaav() {
        return this.aaaaaaae;
    }

    public SocketFactory aaaaaaeo() {
        return this.aaaaaaao;
    }

    public aaaaoaaa aaaaeaaa() {
        return this.aaaaaaaa;
    }

    public SSLSocketFactory aaaeaaaa() {
        return this.aaaaaaeo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aaaaaaaa)) {
            return false;
        }
        aaaaaaaa aaaaaaaaVar = (aaaaaaaa) obj;
        return this.aaaaaaaa.equals(aaaaaaaaVar.aaaaaaaa) && aaaaaaaa(aaaaaaaaVar);
    }

    public int hashCode() {
        int hashCode = (this.aaaaaaae.hashCode() + A2egSU.A5SV6n(this.aaaaaaan, A2egSU.A5SV6n(this.aaaaaaau, (this.aaaaaaac.hashCode() + ((this.aaaaaaa0.hashCode() + ((this.aaaaaaaa.hashCode() + 527) * 31)) * 31)) * 31, 31), 31)) * 31;
        Proxy proxy = this.aaaaaaav;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.aaaaaaeo;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.aaaeaaaa;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        aaaaaaae aaaaaaaeVar = this.aaaaeaaa;
        return hashCode4 + (aaaaaaaeVar != null ? aaaaaaaeVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.aaaaaaaa.aaaaaaae());
        sb.append(":");
        sb.append(this.aaaaaaaa.aaaeaaaa());
        if (this.aaaaaaav != null) {
            sb.append(", proxy=");
            sb.append(this.aaaaaaav);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.aaaaaaae);
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean aaaaaaaa(aaaaaaaa aaaaaaaaVar) {
        return this.aaaaaaa0.equals(aaaaaaaaVar.aaaaaaa0) && this.aaaaaaac.equals(aaaaaaaaVar.aaaaaaac) && this.aaaaaaau.equals(aaaaaaaaVar.aaaaaaau) && this.aaaaaaan.equals(aaaaaaaaVar.aaaaaaan) && this.aaaaaaae.equals(aaaaaaaaVar.aaaaaaae) && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaav, aaaaaaaaVar.aaaaaaav) && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaeo, aaaaaaaaVar.aaaaaaeo) && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaeaaaa, aaaaaaaaVar.aaaeaaaa) && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaeaaa, aaaaaaaaVar.aaaaeaaa) && aaaaeaaa().aaaeaaaa() == aaaaaaaaVar.aaaaeaaa().aaaeaaaa();
    }
}
