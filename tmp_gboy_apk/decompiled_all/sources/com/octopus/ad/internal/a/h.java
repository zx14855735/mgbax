package com.octopus.ad.internal.a;

import android.content.Context;
import android.net.Uri;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Object f12391a;
    private final ExecutorService b;
    private final Map<String, i> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final com.octopus.ad.internal.a.c g;
    private final m h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private File f12392a;
        private com.octopus.ad.internal.a.b.c d;
        private com.octopus.ad.internal.a.a.a c = new com.octopus.ad.internal.a.a.g(536870912);
        private com.octopus.ad.internal.a.a.c b = new com.octopus.ad.internal.a.a.f();
        private f e = new d();

        public a(Context context) {
            this.d = com.octopus.ad.internal.a.b.d.a(context);
            this.f12392a = t.a(context);
        }

        private com.octopus.ad.internal.a.c b() {
            return new com.octopus.ad.internal.a.c(this.f12392a, this.b, this.c, this.d, this.e);
        }

        public a a(long j) {
            this.c = new com.octopus.ad.internal.a.a.g(j);
            return this;
        }

        public h a() {
            return new h(b());
        }
    }

    public final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(this.b);
        }
    }

    public final class c implements Runnable {
        private final CountDownLatch b;

        public c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.countDown();
            h.this.b();
        }
    }

    private String c(String str) {
        Locale locale = Locale.US;
        return "http://127.0.0.1:" + this.e + "/" + q.b(str);
    }

    private File d(String str) {
        com.octopus.ad.internal.a.c cVar = this.g;
        return new File(cVar.f12388a, cVar.b.a(str));
    }

    private i e(String str) {
        i iVar;
        synchronized (this.f12391a) {
            try {
                iVar = this.c.get(str);
                if (iVar == null) {
                    iVar = new i(str, this.g);
                    this.c.put(str, iVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public void b(com.octopus.ad.internal.a.b bVar, String str) {
        n.a(bVar, str);
        synchronized (this.f12391a) {
            try {
                e(str).b(bVar);
            } catch (p e) {
                HaoboLog.w(HaoboLog.httpProxyCacheServerLogTag, "Error registering cache listener", e);
            }
        }
    }

    private h(com.octopus.ad.internal.a.c cVar) {
        this.f12391a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (com.octopus.ad.internal.a.c) n.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            k.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new m("127.0.0.1", localPort);
            HaoboLog.i(HaoboLog.httpProxyCacheServerLogTag, "Proxy cache server started. Is it alive? " + a());
        } catch (Exception e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private int c() {
        int i;
        synchronized (this.f12391a) {
            try {
                Iterator<i> it = this.c.values().iterator();
                i = 0;
                while (it.hasNext()) {
                    i += it.next().a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public String a(String str) {
        return a(str, true);
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (Exception e) {
            HaoboLog.w(HaoboLog.httpProxyCacheServerLogTag, "Failed to close socket on proxy side: {}. It seems client have already closed connection.", e);
        }
    }

    public String a(String str, boolean z) {
        if (!z || !b(str)) {
            return a() ? c(str) : str;
        }
        File d = d(str);
        a(d);
        return Uri.fromFile(d).toString();
    }

    public boolean b(String str) {
        n.a(str, "Url can't be null!");
        return d(str).exists();
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            HaoboLog.e(HaoboLog.httpProxyCacheServerLogTag, "Releasing input stream… Socket is closed by client.");
        } catch (Exception e) {
            a(new p("Error closing socket input stream", e));
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (Exception e) {
            a(new p("Error closing socket", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                HaoboLog.d(HaoboLog.httpProxyCacheServerLogTag, "Accept new socket " + accept);
                this.b.submit(new b(accept));
            } catch (Exception e) {
                a(new p("Error during waiting connection", e));
                return;
            }
        }
    }

    public void a(com.octopus.ad.internal.a.b bVar, String str) {
        n.a(bVar, str);
        synchronized (this.f12391a) {
            try {
                e(str).a(bVar);
            } catch (p e) {
                HaoboLog.w(HaoboLog.httpProxyCacheServerLogTag, "Error registering cache listener", e);
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private boolean a() {
        return this.h.a(3, 70);
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (Exception e) {
            HaoboLog.e(HaoboLog.httpProxyCacheServerLogTag, "Error touching file " + file, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        String str;
        StringBuilder sb;
        try {
            try {
                e a2 = e.a(socket.getInputStream());
                HaoboLog.d(HaoboLog.httpProxyCacheServerLogTag, "Request to cache proxy:" + a2);
                String c2 = q.c(a2.f12389a);
                if (this.h.a(c2)) {
                    this.h.a(socket);
                } else {
                    e(c2).a(a2, socket);
                }
                b(socket);
                HaoboLog.d(HaoboLog.httpProxyCacheServerLogTag, "Opened connections: " + c());
            } catch (p e) {
                e = e;
                a(new p("Error processing request", e));
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder("Opened connections: ");
                sb.append(c());
                HaoboLog.d(str, sb.toString());
            } catch (SocketException unused) {
                HaoboLog.e(HaoboLog.httpProxyCacheServerLogTag, "Closing socket… Socket is closed by client.");
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder("Opened connections: ");
                sb.append(c());
                HaoboLog.d(str, sb.toString());
            } catch (IOException e2) {
                e = e2;
                a(new p("Error processing request", e));
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder("Opened connections: ");
                sb.append(c());
                HaoboLog.d(str, sb.toString());
            }
        } catch (Throwable th) {
            b(socket);
            HaoboLog.d(HaoboLog.httpProxyCacheServerLogTag, "Opened connections: " + c());
            throw th;
        }
    }

    private void a(Throwable th) {
        HaoboLog.e(HaoboLog.httpProxyCacheServerLogTag, "HttpProxyCacheServer error", th);
    }
}
