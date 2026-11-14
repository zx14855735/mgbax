package com.sigmob.sdk.downloader.core.connection;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.i;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0451a {
    private static final String f = "DownloadUrlConnection";
    protected URLConnection b;
    private a c;
    private URL d;
    private i e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Proxy f13366a;
        private Integer b;
        private Integer c;

        public a a(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public a a(Proxy proxy) {
            this.f13366a = proxy;
            return this;
        }
    }

    public static class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private final a f13367a;

        public b() {
            this(null);
        }

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String str) {
            return new c(str, this.f13367a);
        }

        public b(a aVar) {
            this.f13367a = aVar;
        }

        public com.sigmob.sdk.downloader.core.connection.a a(URL url) {
            return new c(url, this.f13367a);
        }
    }

    /* renamed from: com.sigmob.sdk.downloader.core.connection.c$c, reason: collision with other inner class name */
    public static final class C0452c implements i {

        /* renamed from: a, reason: collision with root package name */
        String f13368a;

        @Override // com.sigmob.sdk.downloader.i
        public String a() {
            return this.f13368a;
        }

        @Override // com.sigmob.sdk.downloader.i
        public void a(com.sigmob.sdk.downloader.core.connection.a aVar, a.InterfaceC0451a interfaceC0451a, Map<String, List<String>> map) {
            c cVar = (c) aVar;
            int i = 0;
            for (int d = interfaceC0451a.d(); j.a(d); d = cVar.d()) {
                cVar.b();
                i++;
                if (i > 10) {
                    throw new ProtocolException(CtFAbx.ARc23Z(i, "Too many redirect requests: "));
                }
                String a2 = j.a(interfaceC0451a, d);
                this.f13368a = a2;
                URI create = URI.create(a2);
                if (create != null && !create.isAbsolute()) {
                    try {
                        this.f13368a = ((c) aVar).d.toURI().resolve(create).toString();
                    } catch (Throwable unused) {
                    }
                }
                cVar.d = new URL(this.f13368a);
                cVar.h();
                com.sigmob.sdk.downloader.core.c.b(map, cVar);
                cVar.b.connect();
            }
        }
    }

    public c(String str) {
        this(str, (a) null);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0451a a() {
        Map<String, List<String>> c = c();
        this.b.connect();
        this.e.a(this, this, c);
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String str) {
        return this.b.getRequestProperty(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public String c(String str) {
        return this.b.getHeaderField(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public int d() {
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public InputStream e() {
        return this.b.getInputStream();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public Map<String, List<String>> f() {
        return this.b.getHeaderFields();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public String g() {
        return this.e.a();
    }

    public void h() {
        com.sigmob.sdk.downloader.core.c.b(f, "config connection for " + this.d);
        a aVar = this.c;
        this.b = (aVar == null || aVar.f13366a == null) ? this.d.openConnection() : this.d.openConnection(this.c.f13366a);
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        a aVar2 = this.c;
        if (aVar2 != null) {
            if (aVar2.b != null) {
                this.b.setReadTimeout(this.c.b.intValue());
            }
            if (this.c.c != null) {
                this.b.setConnectTimeout(this.c.c.intValue());
            }
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void b() {
        try {
            InputStream inputStream = this.b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException | Exception unused) {
        }
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> c() {
        return this.b.getRequestProperties();
    }

    public c(URL url, a aVar) {
        this(url, aVar, new C0452c());
    }

    public c(URL url, a aVar, i iVar) {
        this.c = aVar;
        this.d = url;
        this.e = iVar;
        h();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String str, String str2) {
        this.b.addRequestProperty(str, str2);
    }

    public c(URLConnection uRLConnection) {
        this(uRLConnection, new C0452c());
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String str) {
        URLConnection uRLConnection = this.b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    public c(URLConnection uRLConnection, i iVar) {
        this.b = uRLConnection;
        this.d = uRLConnection.getURL();
        this.e = iVar;
    }
}
