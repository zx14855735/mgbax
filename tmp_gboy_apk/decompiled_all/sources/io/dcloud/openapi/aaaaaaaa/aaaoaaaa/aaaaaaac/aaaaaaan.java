package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aa0aaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaan {
    private final aaaaaaac aaaaaaa0;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaa;
    private final aoaaaaaa aaaaaaac;
    private List aaaaaaae;
    private int aaaaaaan;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaao;
    private List aaaaaaau;
    private final List aaaaaaav;

    public static final class aaaaaaaa {
        private int aaaaaaa0 = 0;
        private final List aaaaaaaa;

        public aaaaaaaa(List list) {
            this.aaaaaaaa = list;
        }

        public boolean aaaaaaa0() {
            return this.aaaaaaa0 < this.aaaaaaaa.size();
        }

        public List aaaaaaaa() {
            return new ArrayList(this.aaaaaaaa);
        }

        public aa0aaaaa aaaaaaao() {
            if (!aaaaaaa0()) {
                throw new NoSuchElementException();
            }
            List list = this.aaaaaaaa;
            int i = this.aaaaaaa0;
            this.aaaaaaa0 = i + 1;
            return (aa0aaaaa) list.get(i);
        }
    }

    public aaaaaaan(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, aaaaaaac aaaaaaacVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar2, aoaaaaaa aoaaaaaaVar) {
        List list = Collections.EMPTY_LIST;
        this.aaaaaaau = list;
        this.aaaaaaae = list;
        this.aaaaaaav = new ArrayList();
        this.aaaaaaaa = aaaaaaaaVar;
        this.aaaaaaa0 = aaaaaaacVar;
        this.aaaaaaao = aaaaaaacVar2;
        this.aaaaaaac = aoaaaaaaVar;
        aaaaaaaa(aaaaaaaaVar.aaaaeaaa(), aaaaaaaaVar.aaaaaaan());
    }

    private boolean aaaaaaa0() {
        return this.aaaaaaan < this.aaaaaaau.size();
    }

    private Proxy aaaaaaac() {
        if (!aaaaaaa0()) {
            throw new SocketException("No route to " + this.aaaaaaaa.aaaaeaaa().aaaaaaae() + "; exhausted proxy configurations: " + this.aaaaaaau);
        }
        List list = this.aaaaaaau;
        int i = this.aaaaaaan;
        this.aaaaaaan = i + 1;
        Proxy proxy = (Proxy) list.get(i);
        aaaaaaaa(proxy);
        return proxy;
    }

    public boolean aaaaaaaa() {
        return aaaaaaa0() || !this.aaaaaaav.isEmpty();
    }

    public aaaaaaaa aaaaaaao() {
        if (!aaaaaaaa()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (aaaaaaa0()) {
            Proxy aaaaaaac = aaaaaaac();
            int size = this.aaaaaaae.size();
            for (int i = 0; i < size; i++) {
                aa0aaaaa aa0aaaaaVar = new aa0aaaaa(this.aaaaaaaa, aaaaaaac, (InetSocketAddress) this.aaaaaaae.get(i));
                if (this.aaaaaaa0.aaaaaaao(aa0aaaaaVar)) {
                    this.aaaaaaav.add(aa0aaaaaVar);
                } else {
                    arrayList.add(aa0aaaaaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.aaaaaaav);
            this.aaaaaaav.clear();
        }
        return new aaaaaaaa(arrayList);
    }

    public void aaaaaaaa(aa0aaaaa aa0aaaaaVar, IOException iOException) {
        if (aa0aaaaaVar.aaaaaaa0().type() != Proxy.Type.DIRECT && this.aaaaaaaa.aaaaaaav() != null) {
            this.aaaaaaaa.aaaaaaav().connectFailed(this.aaaaaaaa.aaaaeaaa().eaaaaaaa(), aa0aaaaaVar.aaaaaaa0().address(), iOException);
        }
        this.aaaaaaa0.aaaaaaa0(aa0aaaaaVar);
    }

    private void aaaaaaaa(aaaaoaaa aaaaoaaaVar, Proxy proxy) {
        List aaaaaaaa2;
        if (proxy != null) {
            this.aaaaaaau = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.aaaaaaaa.aaaaaaav().select(aaaaoaaaVar.eaaaaaaa());
            if (select != null && !select.isEmpty()) {
                aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(select);
            } else {
                aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(Proxy.NO_PROXY);
            }
            this.aaaaaaau = aaaaaaaa2;
        }
        this.aaaaaaan = 0;
    }

    private void aaaaaaaa(Proxy proxy) {
        String aaaaaaae;
        int aaaeaaaa;
        this.aaaaaaae = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                aaaaaaae = aaaaaaaa(inetSocketAddress);
                aaaeaaaa = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            aaaaaaae = this.aaaaaaaa.aaaaeaaa().aaaaaaae();
            aaaeaaaa = this.aaaaaaaa.aaaaeaaa().aaaeaaaa();
        }
        if (aaaeaaaa >= 1 && aaaeaaaa <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.aaaaaaae.add(InetSocketAddress.createUnresolved(aaaaaaae, aaaeaaaa));
                return;
            }
            this.aaaaaaac.aaaaaaaa(this.aaaaaaao, aaaaaaae);
            List aaaaaaaa2 = this.aaaaaaaa.aaaaaaao().aaaaaaaa(aaaaaaae);
            if (!aaaaaaaa2.isEmpty()) {
                this.aaaaaaac.aaaaaaaa(this.aaaaaaao, aaaaaaae, aaaaaaaa2);
                int size = aaaaaaaa2.size();
                for (int i = 0; i < size; i++) {
                    this.aaaaaaae.add(new InetSocketAddress((InetAddress) aaaaaaaa2.get(i), aaaeaaaa));
                }
                return;
            }
            throw new UnknownHostException(this.aaaaaaaa.aaaaaaao() + " returned no addresses for " + aaaaaaae);
        }
        throw new SocketException("No route to " + aaaaaaae + ":" + aaaeaaaa + "; port is out of range");
    }

    public static String aaaaaaaa(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
