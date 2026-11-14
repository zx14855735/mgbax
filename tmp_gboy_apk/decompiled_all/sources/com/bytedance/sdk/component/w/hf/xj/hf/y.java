package com.bytedance.sdk.component.w.hf.xj.hf;

import com.bytedance.sdk.component.w.hf.j;
import com.bytedance.sdk.component.w.hf.v;
import com.bytedance.sdk.component.w.hf.zg;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class y {
    private List<InetSocketAddress> c;
    private final List<j> f;
    private final u hf;
    private List<Proxy> kd;
    private final zg u;
    private final com.bytedance.sdk.component.w.hf.kd w;
    private final com.bytedance.sdk.component.w.hf.xj xj;
    private int y;

    public static final class xj {
        private int hf = 0;
        private final List<j> xj;

        public xj(List<j> list) {
            this.xj = list;
        }

        public j hf() {
            if (!xj()) {
                throw new NoSuchElementException();
            }
            List<j> list = this.xj;
            int i = this.hf;
            this.hf = i + 1;
            return list.get(i);
        }

        public List<j> w() {
            return new ArrayList(this.xj);
        }

        public boolean xj() {
            return this.hf < this.xj.size();
        }
    }

    public y(com.bytedance.sdk.component.w.hf.xj xjVar, u uVar, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar) {
        List list = Collections.EMPTY_LIST;
        this.kd = list;
        this.c = list;
        this.f = new ArrayList();
        this.xj = xjVar;
        this.hf = uVar;
        this.w = kdVar;
        this.u = zgVar;
        xj(xjVar.xj(), xjVar.f());
    }

    private Proxy u() {
        if (!w()) {
            throw new SocketException("No route to " + this.xj.xj().c() + "; exhausted proxy configurations: " + this.kd);
        }
        List<Proxy> list = this.kd;
        int i = this.y;
        this.y = i + 1;
        Proxy proxy = list.get(i);
        xj(proxy);
        return proxy;
    }

    private boolean w() {
        return this.y < this.kd.size();
    }

    public xj hf() {
        if (!xj()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (w()) {
            Proxy u = u();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                j jVar = new j(this.xj, u, this.c.get(i));
                if (this.hf.w(jVar)) {
                    this.f.add(jVar);
                } else {
                    arrayList.add(jVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f);
            this.f.clear();
        }
        return new xj(arrayList);
    }

    public boolean xj() {
        return w() || !this.f.isEmpty();
    }

    public void xj(j jVar, IOException iOException) {
        if (jVar.hf().type() != Proxy.Type.DIRECT && this.xj.c() != null) {
            this.xj.c().connectFailed(this.xj.xj().hf(), jVar.hf().address(), iOException);
        }
        this.hf.xj(jVar);
    }

    private void xj(v vVar, Proxy proxy) {
        List<Proxy> xj2;
        if (proxy != null) {
            this.kd = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> select = this.xj.c().select(vVar.hf());
                if (select != null && !select.isEmpty()) {
                    xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(select);
                } else {
                    xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(Proxy.NO_PROXY);
                }
                this.kd = xj2;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.y = 0;
    }

    private void xj(Proxy proxy) {
        String c;
        int f;
        this.c = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                c = xj(inetSocketAddress);
                f = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            c = this.xj.xj().c();
            f = this.xj.xj().f();
        }
        if (f > 0 && f <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.c.add(InetSocketAddress.createUnresolved(c, f));
                return;
            }
            List<InetAddress> xj2 = this.xj.hf().xj(c);
            if (xj2.isEmpty()) {
                return;
            }
            int size = xj2.size();
            for (int i = 0; i < size; i++) {
                this.c.add(new InetSocketAddress(xj2.get(i), f));
            }
            return;
        }
        throw new SocketException("No route to " + c + ":" + f + "; port is out of range");
    }

    public static String xj(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
