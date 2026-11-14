package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bw;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static Handler aWC = new Handler(Looper.getMainLooper());
    static int aWM = 80;
    static int port = 80;

    public static class a extends Thread {
        LinkedList aWO = new LinkedList();
        volatile boolean aWP = false;
        Selector aWN = Selector.open();

        public a() {
            setName("Connector");
        }

        private void OC() {
            synchronized (this.aWO) {
                while (this.aWO.size() > 0) {
                    try {
                        C0378b c0378b = (C0378b) this.aWO.removeFirst();
                        try {
                            c0378b.aWT.register(this.aWN, 8, c0378b);
                        } catch (Throwable th) {
                            c0378b.aWT.close();
                            c0378b.aWU = th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        private void OD() {
            Iterator<SelectionKey> it = this.aWN.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0378b c0378b = (C0378b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0378b.aWY = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bw.c(socketChannel);
                    c0378b.aWU = th;
                }
            }
        }

        public final void a(C0378b c0378b) {
            final SocketChannel socketChannel;
            Handler handler;
            Runnable runnable;
            try {
                try {
                    socketChannel = SocketChannel.open();
                } catch (Throwable th) {
                    th = th;
                    socketChannel = null;
                }
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0378b.aWS);
                    c0378b.aWT = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0378b.aWX = elapsedRealtime;
                    if (connect) {
                        c0378b.aWY = elapsedRealtime;
                        bw.c(socketChannel);
                    } else {
                        synchronized (this.aWO) {
                            this.aWO.add(c0378b);
                        }
                        Selector selector = this.aWN;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    handler = b.aWC;
                    runnable = new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            bw.c(socketChannel);
                        }
                    };
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bw.c(socketChannel);
                        c0378b.aWU = th;
                        handler = b.aWC;
                        runnable = new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bw.c(socketChannel);
                            }
                        };
                        handler.postDelayed(runnable, c0378b.aWW);
                    } catch (Throwable th3) {
                        try {
                            b.aWC.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bw.c(socketChannel);
                                }
                            }, c0378b.aWW);
                        } catch (Throwable unused2) {
                        }
                        throw th3;
                    }
                }
                handler.postDelayed(runnable, c0378b.aWW);
            } catch (Throwable unused3) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aWN.select() > 0) {
                        OD();
                    }
                    OC();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aWP) {
                    Selector selector = this.aWN;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        public final void shutdown() {
            this.aWP = true;
            Selector selector = this.aWN;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    public static class C0378b {
        InetSocketAddress aWS;
        SocketChannel aWT;
        Throwable aWU;
        private float aWV;
        long aWW;
        long aWX;
        long aWY = 0;
        boolean aWZ = false;
        private boolean success;

        public C0378b(String str) {
            try {
                this.aWS = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aWU = th;
            }
        }

        public final void OE() {
            String str;
            if (this.aWY != 0) {
                str = Long.toString(this.aWY - this.aWX) + "ms";
                this.aWV = this.aWY - this.aWX;
                this.success = true;
            } else {
                Throwable th = this.aWU;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.aWS + " : " + str);
            this.aWZ = true;
        }
    }

    static {
        ntzaFP();
    }

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < cVar.OF(); i++) {
                C0378b c0378b = new C0378b(str);
                c0378b.aWW = j + j2;
                linkedList.add(c0378b);
                try {
                    aVar.a(c0378b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    float f = 0.0f;
                    while (it.hasNext()) {
                        C0378b c0378b2 = (C0378b) it.next();
                        c0378b2.OE();
                        z &= c0378b2.success;
                        cVar.bN(z);
                        f += c0378b2.aWV;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.o(f / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }

    private static /* synthetic */ void ntzaFP() {
        char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 184);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 184);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
