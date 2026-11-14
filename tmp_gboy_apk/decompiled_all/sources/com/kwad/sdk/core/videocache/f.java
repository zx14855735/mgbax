package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ax;
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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f {
    private final Object aPN;
    private final ExecutorService aPO;
    private final Map<String, g> aPP;
    private final ServerSocket aPQ;
    private final Thread aPR;
    private final com.kwad.sdk.core.videocache.c aPS;
    private final int port;

    public static final class a {
        private com.kwad.sdk.core.videocache.d.c aPC;
        private int aPE;
        private File aPz;
        private Context context;
        private int aPF = 0;
        private com.kwad.sdk.core.videocache.a.a aPB = new com.kwad.sdk.core.videocache.a.g(536870912);
        private com.kwad.sdk.core.videocache.a.c aPA = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aPD = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aPz = o.bZ(context);
        }

        private com.kwad.sdk.core.videocache.c Mh() {
            return new com.kwad.sdk.core.videocache.c(this.aPz, this.aPA, this.aPB, this.aPC, this.aPD, this.aPE, this.aPF);
        }

        public final f Mg() {
            this.aPC = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aPF);
            return new f(Mh(), (byte) 0);
        }

        public final a aJ(long j) {
            this.aPB = new com.kwad.sdk.core.videocache.a.g(536870912L);
            return this;
        }

        public final a ef(int i) {
            this.aPE = i;
            return this;
        }

        public final a eg(int i) {
            this.aPF = i;
            return this;
        }
    }

    public final class b implements Runnable {
        private final Socket aPT;

        public b(Socket socket) {
            this.aPT = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aPT);
        }
    }

    public final class c implements Runnable {
        private final CountDownLatch aPV;

        public c(CountDownLatch countDownLatch) {
            this.aPV = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aPV.countDown();
                f.this.Me();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aPQ.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aPO.submit(new b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int Mf() {
        int i;
        synchronized (this.aPN) {
            try {
                Iterator<g> it = this.aPP.values().iterator();
                i = 0;
                while (it.hasNext()) {
                    i += it.next().Mf();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private File ad(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aPS;
        return new File(cVar.aPz, cVar.aPA.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private String fd(String str) {
        Locale locale = Locale.US;
        return "http://127.0.0.1:" + this.port + "/" + l.encode(str);
    }

    private File fe(String str) {
        return new File(this.aPS.aPz, this.aPS.aPA.generate(str) + ".download");
    }

    private g ff(String str) {
        g gVar;
        synchronized (this.aPN) {
            try {
                gVar = this.aPP.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.aPS);
                    this.aPP.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private String g(String str, boolean z) {
        if (!ad(str).exists()) {
            return fd(str);
        }
        File ad = ad(str);
        r(ad);
        return Uri.fromFile(ad).toString();
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }

    private void r(File file) {
        try {
            this.aPS.aPB.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String eZ(String str) {
        return str == null ? "" : g(str, true);
    }

    public final boolean fa(String str) {
        ax.aA(str, "Url can't be null!");
        return ad(str).exists();
    }

    public final boolean fb(String str) {
        ax.aA(str, "Url can't be null!");
        return fe(str).exists() || ad(str).exists();
    }

    public final boolean fc(String str) {
        g gVar = this.aPP.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.aPP.remove(str);
        return true;
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aPN = new Object();
        this.aPO = GlobalThreadPools.Lo();
        this.aPP = new ConcurrentHashMap();
        this.aPS = (com.kwad.sdk.core.videocache.c) ax.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aPQ = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aPR = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aPO.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final boolean a(String str, long j, a.C0366a c0366a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (fa(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(fd(str), null, c0366a, j, false, adHttpResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? r0 = "Opened connections: ";
        try {
            try {
                d b2 = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b2);
                ff(l.decode(b2.uri)).a(b2, socket);
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                socket = new StringBuilder("Opened connections: ");
            }
            r0 = Mf();
            A2egSU.BChYOn(socket, r0, "HttpProxyCacheServer");
        } catch (Throwable th) {
            b(socket);
            A2egSU.BChYOn(new StringBuilder((String) r0), Mf(), "HttpProxyCacheServer");
            throw th;
        }
    }
}
