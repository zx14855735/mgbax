package com.bykv.vk.openvk.component.video.xj.hf;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.openvk.component.video.xj.hf.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static volatile y u;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.xj.hf c;
    private final c.w d;
    private final SparseArray<Set<c>> f;
    private final AtomicBoolean g;
    private volatile int hf;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.hf.w kd;
    private volatile w p;

    /* renamed from: pl, reason: collision with root package name */
    private final Runnable f10027pl;
    private volatile w tf;
    private final AtomicInteger w = new AtomicInteger(0);
    private volatile ServerSocket xj;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.xj.w y;

    public static final class xj implements Callable<Boolean> {
        private final int hf;
        private final String xj;

        public xj(String str, int i) {
            this.xj = str;
            this.hf = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.xj, this.hf);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.xj.w.xj.xj));
                    outputStream.flush();
                    if (cb.k.equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        return Boolean.TRUE;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "call: ", th);
                        y.xj("ping error", Log.getStackTraceString(th));
                        return Boolean.FALSE;
                    } finally {
                        com.bykv.vk.openvk.component.video.xj.w.xj.xj(socket);
                    }
                }
            } catch (Throwable th3) {
                socket = null;
                th = th3;
            }
            return Boolean.FALSE;
        }
    }

    private y() {
        SparseArray<Set<c>> sparseArray = new SparseArray<>(2);
        this.f = sparseArray;
        this.d = new c.w() { // from class: com.bykv.vk.openvk.component.video.xj.hf.y.1
            @Override // com.bykv.vk.openvk.component.video.xj.hf.c.w
            public void hf(c cVar) {
                boolean z = kd.w;
                int y = cVar.y();
                synchronized (y.this.f) {
                    try {
                        Set set = (Set) y.this.f.get(y);
                        if (set != null) {
                            set.remove(cVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.xj.hf.c.w
            public void xj(c cVar) {
                synchronized (y.this.f) {
                    try {
                        Set set = (Set) y.this.f.get(cVar.y());
                        if (set != null) {
                            set.add(cVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.f10027pl = new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.y.2
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                try {
                    y.this.xj = new ServerSocket(0, 50, InetAddress.getByName(y.this.d()));
                    y yVar = y.this;
                    yVar.hf = yVar.xj.getLocalPort();
                    if (y.this.hf == -1) {
                        y.xj("socket not bound", "");
                        y.this.kd();
                        return;
                    }
                    tf.xj(y.this.d(), y.this.hf);
                    if (y.this.c()) {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "run:  state = ", y.this.w);
                        if (y.this.w.compareAndSet(0, 1)) {
                            com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "run:  state = ", y.this.w);
                            if (kd.w) {
                                com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "proxy server start!");
                            }
                            while (y.this.w.get() == 1) {
                                try {
                                    try {
                                        Socket accept = y.this.xj.accept();
                                        com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar = y.this.kd;
                                        if (wVar != null) {
                                            final c xj2 = new c.xj().xj(wVar).xj(accept).xj(y.this.d).xj();
                                            com.bytedance.sdk.component.tf.c.xj().execute(new com.bytedance.sdk.component.tf.d("ProxyTask", 10) { // from class: com.bykv.vk.openvk.component.video.xj.hf.y.2.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    xj2.run();
                                                }
                                            });
                                        } else {
                                            com.bykv.vk.openvk.component.video.xj.w.xj.xj(accept);
                                        }
                                    } catch (IOException e) {
                                        com.bytedance.sdk.component.utils.pl.xj(e);
                                        y.xj("accept error", Log.getStackTraceString(e));
                                        i++;
                                        if (i > 3) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    String stackTraceString = Log.getStackTraceString(th);
                                    com.bytedance.sdk.component.utils.pl.u("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                    y.xj("error", stackTraceString);
                                }
                            }
                            if (kd.w) {
                                com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "proxy server closed!");
                            }
                            y.this.kd();
                        }
                    }
                } catch (IOException e2) {
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.u("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                    }
                    y.xj("create ServerSocket error", Log.getStackTraceString(e2));
                    y.this.kd();
                }
            }
        };
        this.g = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    public static /* synthetic */ void xj(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean c() {
        com.bytedance.sdk.component.tf.f fVar = new com.bytedance.sdk.component.tf.f(new xj(d(), this.hf), 5, 1);
        com.bytedance.sdk.component.tf.c.xj().submit(fVar);
        f();
        try {
            if (!((Boolean) fVar.get()).booleanValue()) {
                com.bytedance.sdk.component.utils.pl.u("ProxyServer", "Ping error");
                kd();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "pingTest: ");
            if (kd.w) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            kd();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    private void f() {
        Socket socket = null;
        try {
            try {
                socket = this.xj.accept();
                socket.setSoTimeout(2000);
                if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.xj.w.xj.xj));
                    outputStream.flush();
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            com.bykv.vk.openvk.component.video.api.y.w.xj("ProxyServer", "answerPing: ");
        } finally {
            com.bykv.vk.openvk.component.video.xj.w.xj.xj(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        if (this.w.compareAndSet(1, 2) || this.w.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.xj.w.xj.xj(this.xj);
            y();
        }
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f) {
            try {
                int size = this.f.size();
                for (int i = 0; i < size; i++) {
                    SparseArray<Set<c>> sparseArray = this.f;
                    Set<c> set = sparseArray.get(sparseArray.keyAt(i));
                    if (set != null) {
                        arrayList.addAll(set);
                        set.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).xj();
        }
    }

    public w hf() {
        return this.tf;
    }

    public void u() {
        if (this.g.compareAndSet(false, true)) {
            com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(this.f10027pl, "r/ProxyServer");
            wVar.setName("csj_proxy_server");
            wVar.start();
        }
    }

    public w w() {
        return this.p;
    }

    public boolean xj(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f) {
            try {
                Set<c> set = this.f.get(i);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null && str.equals(cVar.f)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static y xj() {
        if (u == null) {
            synchronized (y.class) {
                try {
                    if (u == null) {
                        u = new y();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public void xj(com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar) {
        this.kd = wVar;
    }

    public void xj(com.bykv.vk.openvk.component.video.xj.hf.xj.w wVar) {
        this.y = wVar;
    }

    public String xj(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.kd == null) {
            return strArr[0];
        }
        if ((z ? this.c : this.y) == null) {
            return strArr[0];
        }
        if (this.w.get() != 1) {
            return strArr[0];
        }
        List<String> xj2 = com.bykv.vk.openvk.component.video.xj.w.xj.xj(strArr);
        if (xj2 == null) {
            return strArr[0];
        }
        String xj3 = d.xj(str, z2 ? str : com.bykv.vk.openvk.component.video.api.y.hf.xj(str), xj2);
        if (xj3 == null) {
            return strArr[0];
        }
        if (z) {
            str2 = "https://" + d() + ":" + this.hf + "?f=1&" + xj3;
        } else {
            str2 = "https://" + d() + ":" + this.hf + "?" + xj3;
        }
        return str2.replaceFirst("s", "");
    }
}
