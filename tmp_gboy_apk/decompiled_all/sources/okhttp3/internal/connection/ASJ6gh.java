package okhttp3.internal.connection;

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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ASJ6gh {
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<Proxy> proxies;
    private final AMqCpz routeDatabase;

    public static final class A2egSU {
        private int nextRouteIndex = 0;
        private final List<Route> routes;

        public A2egSU(List<Route> list) {
            this.routes = list;
        }

        public final ArrayList A2egSU() {
            return new ArrayList(this.routes);
        }

        public final boolean A4TApA() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final Route A5SV6n() {
            if (!A4TApA()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    public ASJ6gh(Address address, AMqCpz aMqCpz, Call call, EventListener eventListener) {
        List list = Collections.EMPTY_LIST;
        this.proxies = list;
        this.inetSocketAddresses = list;
        this.postponedRoutes = new ArrayList();
        this.address = address;
        this.routeDatabase = aMqCpz;
        this.call = call;
        this.eventListener = eventListener;
        HttpUrl url = address.url();
        Proxy proxy = address.proxy();
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = address.proxySelector().select(url.uri());
            this.proxies = (select == null || select.isEmpty()) ? okhttp3.internal.A5SV6n.AzWtSf(Proxy.NO_PROXY) : okhttp3.internal.A5SV6n.AmA8tU(select);
        }
        this.nextProxyIndex = 0;
    }

    public final void A2egSU(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.A4TApA(route);
    }

    public final boolean A4TApA() {
        return this.nextProxyIndex < this.proxies.size() || !this.postponedRoutes.isEmpty();
    }

    public final A2egSU A5SV6n() {
        String host;
        int port;
        if (!A4TApA()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.nextProxyIndex < this.proxies.size()) {
            if (!(this.nextProxyIndex < this.proxies.size())) {
                throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
            }
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            this.inetSocketAddresses = new ArrayList();
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                host = this.address.url().host();
                port = this.address.url().port();
            } else {
                SocketAddress address = proxy.address();
                if (!(address instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                host = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                port = inetSocketAddress.getPort();
            }
            if (port < 1 || port > 65535) {
                throw new SocketException("No route to " + host + ":" + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(host, port));
            } else {
                this.eventListener.dnsStart(this.call, host);
                List<InetAddress> lookup = this.address.dns().lookup(host);
                if (lookup.isEmpty()) {
                    throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
                }
                this.eventListener.dnsEnd(this.call, host, lookup);
                int size = lookup.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i2), port));
                }
            }
            int size2 = this.inetSocketAddresses.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Route route = new Route(this.address, proxy, this.inetSocketAddresses.get(i3));
                if (this.routeDatabase.A5SV6n(route)) {
                    this.postponedRoutes.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new A2egSU(arrayList);
    }
}
