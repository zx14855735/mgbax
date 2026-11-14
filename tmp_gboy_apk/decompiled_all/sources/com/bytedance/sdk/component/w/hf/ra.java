package com.bytedance.sdk.component.w.hf;

import android.os.Bundle;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.yo;
import com.bytedance.sdk.component.w.hf.zg;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ra implements Cloneable {
    final int ai;
    final SocketFactory am;
    final List<jk> c;
    final zg.xj d;
    final boolean dk;
    final HostnameVerifier e;
    final boolean et;
    final List<jk> f;
    final com.bytedance.sdk.component.w.hf.xj.xj.y g;
    final qt ht;

    /* renamed from: io, reason: collision with root package name */
    final int f10229io;
    final hf jk;
    final List<dk> kd;
    final g p;

    /* renamed from: pl, reason: collision with root package name */
    final w f10230pl;
    final tf pz;
    final int q;
    final SSLSocketFactory qt;
    final boolean ra;
    final ProxySelector tf;
    final Proxy u;
    final hf v;
    final am w;
    final int x;
    final List<p> y;
    final c yo;
    public Set<String> z;
    final com.bytedance.sdk.component.w.hf.xj.d.w zg;
    static final List<dk> xj = com.bytedance.sdk.component.w.hf.xj.w.xj(dk.HTTP_2, dk.HTTP_1_1);
    static final List<p> hf = com.bytedance.sdk.component.w.hf.xj.w.xj(p.xj, p.w);

    public static final class xj {
        public Bundle ai;
        com.bytedance.sdk.component.w.hf.xj.d.w am;
        zg.xj c;
        g d;
        public int dk;
        hf e;
        public TimeUnit en;
        public int et;
        ProxySelector f;
        SSLSocketFactory g;
        Proxy hf;
        boolean ht;

        /* renamed from: io, reason: collision with root package name */
        public int f10231io;
        public TimeUnit j;
        qt jk;
        public final List<jk> kd;
        com.bytedance.sdk.component.w.hf.xj.xj.y p;

        /* renamed from: pl, reason: collision with root package name */
        SocketFactory f10232pl;
        boolean pz;
        public Set<String> q;
        HostnameVerifier qt;
        boolean ra;
        w tf;
        List<p> u;
        tf v;
        public List<dk> w;
        int x;
        am xj;
        final List<jk> y;
        hf yo;
        public TimeUnit z;
        c zg;

        public xj() {
            this("");
        }

        public xj xj(jk jkVar) {
            if (jkVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.kd.add(jkVar);
            return this;
        }

        public xj(String str) {
            this.kd = new ArrayList();
            this.y = new ArrayList();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.z = timeUnit;
            this.j = timeUnit;
            this.en = timeUnit;
            this.xj = new am(str);
            this.w = ra.xj;
            this.u = ra.hf;
            this.c = zg.xj(zg.xj);
            this.f = ProxySelector.getDefault();
            this.d = g.xj;
            this.f10232pl = SocketFactory.getDefault();
            this.qt = com.bytedance.sdk.component.w.hf.xj.d.kd.xj;
            this.zg = c.xj;
            hf hfVar = hf.xj;
            this.e = hfVar;
            this.yo = hfVar;
            this.v = new tf();
            this.jk = qt.xj;
            this.pz = true;
            this.ht = true;
            this.ra = true;
            this.dk = 10000;
            this.et = 10000;
            this.f10231io = 10000;
            this.x = 0;
        }

        public xj xj(zg zgVar) {
            if (zgVar != null) {
                this.c = zg.xj(zgVar);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public ra xj() {
            return new ra(this);
        }
    }

    static {
        com.bytedance.sdk.component.w.hf.xj.xj.xj = new com.bytedance.sdk.component.w.hf.xj.xj() { // from class: com.bytedance.sdk.component.w.hf.ra.1
            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public void hf(tf tfVar, com.bytedance.sdk.component.w.hf.xj.hf.w wVar) {
                tfVar.xj(wVar);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public void xj(yo.xj xjVar, String str) {
                xjVar.xj(str);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public void xj(yo.xj xjVar, String str, String str2) {
                xjVar.hf(str, str2);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public boolean xj(tf tfVar, com.bytedance.sdk.component.w.hf.xj.hf.w wVar) {
                return tfVar.hf(wVar);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public com.bytedance.sdk.component.w.hf.xj.hf.w xj(tf tfVar, com.bytedance.sdk.component.w.hf.xj xjVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar, j jVar) {
                return tfVar.xj(xjVar, cVar, jVar);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public boolean xj(com.bytedance.sdk.component.w.hf.xj xjVar, com.bytedance.sdk.component.w.hf.xj xjVar2) {
                return xjVar.xj(xjVar2);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public Socket xj(tf tfVar, com.bytedance.sdk.component.w.hf.xj xjVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar) {
                return tfVar.xj(xjVar, cVar);
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public com.bytedance.sdk.component.w.hf.xj.hf.u xj(tf tfVar) {
                return tfVar.xj;
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public int xj(q.xj xjVar) {
                return xjVar.w;
            }

            @Override // com.bytedance.sdk.component.w.hf.xj.xj
            public void xj(p pVar, SSLSocket sSLSocket, boolean z) {
                pVar.xj(sSLSocket, z);
            }
        };
        DNcl();
    }

    public ra() {
        this(new xj());
    }

    private static /* synthetic */ void DNcl() {
        char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 212);
        }
        String str = new String(charArray);
        char[] charArray2 = "·¸½º½ ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 212);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private X509TrustManager et() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory xj(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("No System TLS", (Exception) e);
        }
    }

    public hf am() {
        return this.v;
    }

    public com.bytedance.sdk.component.w.hf.xj.xj.y c() {
        w wVar = this.f10230pl;
        return wVar != null ? wVar.xj : this.g;
    }

    public SocketFactory d() {
        return this.am;
    }

    public zg.xj dk() {
        return this.d;
    }

    public boolean e() {
        return this.dk;
    }

    public qt f() {
        return this.ht;
    }

    public hf g() {
        return this.jk;
    }

    public int hf() {
        return this.x;
    }

    public List<jk> ht() {
        return this.c;
    }

    public List<dk> jk() {
        return this.kd;
    }

    public ProxySelector kd() {
        return this.tf;
    }

    public HostnameVerifier p() {
        return this.e;
    }

    public c pl() {
        return this.yo;
    }

    public List<p> pz() {
        return this.y;
    }

    public tf qt() {
        return this.pz;
    }

    public List<jk> ra() {
        return this.f;
    }

    public SSLSocketFactory tf() {
        return this.qt;
    }

    public Proxy u() {
        return this.u;
    }

    public am v() {
        return this.w;
    }

    public int w() {
        return this.ai;
    }

    public g y() {
        return this.p;
    }

    public boolean yo() {
        return this.et;
    }

    public boolean zg() {
        return this.ra;
    }

    public ra(xj xjVar) {
        boolean z;
        this.w = xjVar.xj;
        this.u = xjVar.hf;
        this.kd = xjVar.w;
        List<p> list = xjVar.u;
        this.y = list;
        this.c = com.bytedance.sdk.component.w.hf.xj.w.xj(xjVar.kd);
        this.f = com.bytedance.sdk.component.w.hf.xj.w.xj(xjVar.y);
        this.d = xjVar.c;
        this.tf = xjVar.f;
        this.p = xjVar.d;
        this.f10230pl = xjVar.tf;
        this.g = xjVar.p;
        this.am = xjVar.f10232pl;
        this.z = xjVar.q;
        Iterator<p> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().xj();
            }
        }
        SSLSocketFactory sSLSocketFactory = xjVar.g;
        if (sSLSocketFactory == null && z) {
            X509TrustManager et = et();
            this.qt = xj(et);
            this.zg = com.bytedance.sdk.component.w.hf.xj.d.w.xj(et);
        } else {
            this.qt = sSLSocketFactory;
            this.zg = xjVar.am;
        }
        this.e = xjVar.qt;
        this.yo = xjVar.zg.xj(this.zg);
        this.v = xjVar.e;
        this.jk = xjVar.yo;
        tf tfVar = xjVar.v;
        this.pz = tfVar;
        if (tfVar != null) {
            tfVar.xj(xjVar.ai);
        }
        this.ht = xjVar.jk;
        this.ra = xjVar.pz;
        this.dk = xjVar.ht;
        this.et = xjVar.ra;
        this.f10229io = xjVar.dk;
        this.x = xjVar.et;
        this.ai = xjVar.f10231io;
        this.q = xjVar.x;
        if (this.c.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.c);
        }
        if (this.f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f);
        }
    }

    public int xj() {
        return this.f10229io;
    }

    public kd xj(io ioVar) {
        return et.xj(this, ioVar, false);
    }
}
