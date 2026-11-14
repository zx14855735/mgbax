package com.bykv.vk.openvk.component.video.xj.hf;

import android.util.Log;
import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bykv.vk.openvk.component.video.xj.hf.f;
import com.bykv.vk.openvk.component.video.xj.hf.hf;
import com.bykv.vk.openvk.component.video.xj.hf.pl;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class c extends com.bykv.vk.openvk.component.video.xj.hf.xj {
    private final w am;
    private volatile boolean e;
    private final Socket g;
    private final u qt;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.hf zg;

    public static class hf {
        private int hf;
        private boolean w;
        private final OutputStream xj;

        public hf(OutputStream outputStream, int i) {
            this.xj = outputStream;
            this.hf = i;
        }

        public void hf(byte[] bArr, int i, int i2) {
            try {
                this.xj.write(bArr, i, i2);
                this.hf += i2;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.xj.hf.w.u(e);
            }
        }

        public boolean xj() {
            return this.w;
        }

        public void xj(byte[] bArr, int i, int i2) {
            if (this.w) {
                return;
            }
            try {
                this.xj.write(bArr, i, i2);
                this.w = true;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.xj.hf.w.u(e);
            }
        }

        public int hf() {
            return this.hf;
        }
    }

    public interface w {
        void hf(c cVar);

        void xj(c cVar);
    }

    public c(xj xjVar) {
        super(xjVar.xj, xjVar.hf);
        this.e = true;
        this.g = xjVar.w;
        this.am = xjVar.u;
        this.qt = u.w();
    }

    private void d() {
        com.bykv.vk.openvk.component.video.xj.hf.hf hfVar = this.zg;
        this.zg = null;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    private hf f() {
        try {
            this.d = d.xj(this.g.getInputStream());
            OutputStream outputStream = this.g.getOutputStream();
            com.bykv.vk.openvk.component.video.xj.hf.xj.xj xjVar = this.d.w.xj == 1 ? kd.xj : kd.hf;
            if (xjVar == null) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.xj = xjVar;
            this.c = this.d.w.hf;
            this.f = this.d.w.w;
            this.tf = new pl(this.d.w.c);
            this.y = this.d.hf;
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.d.toString());
            }
            return new hf(outputStream, this.d.w.u);
        } catch (d.u e) {
            com.bykv.vk.openvk.component.video.xj.w.xj.xj(this.g);
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            if (this.xj != null) {
                c();
            }
            return null;
        } catch (IOException e2) {
            com.bykv.vk.openvk.component.video.xj.w.xj.xj(this.g);
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            if (this.xj != null) {
                c();
            }
            return null;
        }
    }

    private void hf(hf hfVar, pl.xj xjVar) {
        byte[] xj2 = xj(this.hf.query(this.f, this.d.w.xj), hfVar, xjVar);
        if (xj2 == null) {
            return;
        }
        hfVar.xj(xj2, 0, xj2.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #1 {all -> 0x00f6, blocks: (B:35:0x00ed, B:36:0x0102, B:38:0x0106, B:39:0x014a, B:42:0x015c, B:88:0x015a, B:91:0x00fe), top: B:25:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016b A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:45:0x0165, B:47:0x016b, B:49:0x0170, B:52:0x01a0, B:59:0x017b, B:54:0x01a7, B:75:0x01ab, B:77:0x01af, B:78:0x01b4, B:56:0x0176), top: B:44:0x0165, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ab A[EDGE_INSN: B:74:0x01ab->B:75:0x01ab BREAK  A[LOOP:0: B:44:0x0165->B:54:0x01a7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:45:0x0165, B:47:0x016b, B:49:0x0170, B:52:0x01a0, B:59:0x017b, B:54:0x01a7, B:75:0x01ab, B:77:0x01af, B:78:0x01b4, B:56:0x0176), top: B:44:0x0165, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015a A[Catch: all -> 0x00f6, TryCatch #1 {all -> 0x00f6, blocks: (B:35:0x00ed, B:36:0x0102, B:38:0x0106, B:39:0x014a, B:42:0x015c, B:88:0x015a, B:91:0x00fe), top: B:25:0x00c8 }] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u(com.bykv.vk.openvk.component.video.xj.hf.c.hf r13, com.bykv.vk.openvk.component.video.xj.hf.pl.xj r14) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.hf.c.u(com.bykv.vk.openvk.component.video.xj.hf.c$hf, com.bykv.vk.openvk.component.video.xj.hf.pl$xj):void");
    }

    private void w(hf hfVar, pl.xj xjVar) {
        if (this.e) {
            File w2 = this.xj.w(this.f);
            long length = w2.length();
            com.bykv.vk.openvk.component.video.xj.hf.hf.xj query = this.hf.query(this.f, this.d.w.xj);
            int hf2 = hfVar.hf();
            if (length > hfVar.hf()) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - hf2));
                }
                xj(query, w2, hfVar, xjVar);
                return;
            }
        }
        u(hfVar, xjVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.xj.hf.hf.xj query;
        hf f = f();
        if (f == null) {
            return;
        }
        w wVar = this.am;
        if (wVar != null) {
            wVar.xj(this);
        }
        this.xj.xj(this.f);
        if (kd.f != 0 && ((query = this.hf.query(this.f, this.d.w.xj)) == null || this.xj.w(this.f).length() < query.w)) {
            this.qt.xj(c(), this.f);
        }
        try {
            xj(f);
        } catch (com.bykv.vk.openvk.component.video.xj.hf.w.xj e) {
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
        } catch (Throwable th) {
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.xj.hf(this.f);
        this.qt.xj(c(), null);
        xj();
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(this.g);
        w wVar2 = this.am;
        if (wVar2 != null) {
            wVar2.hf(this);
        }
    }

    public static final class xj {
        com.bykv.vk.openvk.component.video.xj.hf.hf.w hf;
        w u;
        Socket w;
        com.bykv.vk.openvk.component.video.xj.hf.xj.xj xj;

        public xj xj(com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar) {
            if (wVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.hf = wVar;
            return this;
        }

        public xj xj(Socket socket) {
            if (socket != null) {
                this.w = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        public xj xj(w wVar) {
            this.u = wVar;
            return this;
        }

        public c xj() {
            if (this.hf != null && this.w != null) {
                return new c(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean xj(hf hfVar) {
        while (this.tf.xj()) {
            kd();
            pl.xj hf2 = this.tf.hf();
            try {
                xj(hfVar, hf2);
                return true;
            } catch (f.xj e) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
                this.e = false;
                c();
            } catch (com.bykv.vk.openvk.component.video.xj.hf.w.hf e2) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bykv.vk.openvk.component.video.xj.hf.w.u e3) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.xj.hf.w.w unused) {
                hf2.xj();
                c();
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    hf2.hf();
                }
                if (!hf()) {
                    c();
                } else if (kd.w) {
                    if ("Canceled".equalsIgnoreCase(e4.getMessage())) {
                        com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                    }
                }
            } catch (Exception e5) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
            }
        }
        return false;
    }

    private void xj(hf hfVar, pl.xj xjVar) {
        if (com.sigmob.sdk.downloader.core.c.f13360a.equalsIgnoreCase(this.d.xj.xj)) {
            hf(hfVar, xjVar);
        } else {
            w(hfVar, xjVar);
        }
    }

    private byte[] xj(com.bykv.vk.openvk.component.video.xj.hf.hf.xj xjVar, hf hfVar, pl.xj xjVar2) {
        if (xjVar != null) {
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.xj.w.xj.xj(xjVar, hfVar.hf()).getBytes(com.bykv.vk.openvk.component.video.xj.w.xj.xj);
        }
        com.bykv.vk.openvk.component.video.xj.hf.kd.xj xj2 = xj(xjVar2, 0, -1, com.sigmob.sdk.downloader.core.c.f13360a);
        if (xj2 == null) {
            return null;
        }
        try {
            String xj3 = com.bykv.vk.openvk.component.video.xj.w.xj.xj(xj2, false, false);
            if (xj3 == null) {
                com.bykv.vk.openvk.component.video.xj.hf.hf.xj xj4 = com.bykv.vk.openvk.component.video.xj.w.xj.xj(xj2, this.hf, this.f, this.d.w.xj);
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_ProxyTask", "get header from network");
                }
                byte[] bytes = com.bykv.vk.openvk.component.video.xj.w.xj.xj(xj4, hfVar.hf()).getBytes(com.bykv.vk.openvk.component.video.xj.w.xj.xj);
                com.bykv.vk.openvk.component.video.xj.w.xj.xj(xj2.u());
                return bytes;
            }
            throw new com.bykv.vk.openvk.component.video.xj.hf.w.w(xj3 + ", rawKey: " + this.c + ", url: " + xjVar2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.xj.w.xj.xj(xj2.u());
            throw th;
        }
    }

    private void xj(com.bykv.vk.openvk.component.video.xj.hf.hf.xj xjVar, File file, hf hfVar, pl.xj xjVar2) {
        final com.bytedance.sdk.component.tf.f fVar;
        com.bykv.vk.openvk.component.video.xj.hf.hf hfVar2;
        if (!hfVar.xj()) {
            byte[] xj2 = xj(xjVar, hfVar, xjVar2);
            kd();
            if (xj2 == null) {
                return;
            } else {
                hfVar.xj(xj2, 0, xj2.length);
            }
        }
        f fVar2 = null;
        if (xjVar == null && (xjVar = this.hf.query(this.f, this.d.w.xj)) == null) {
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            xj(null, hfVar, xjVar2);
            xjVar = this.hf.query(this.f, this.d.w.xj);
            if (xjVar == null) {
                throw new com.bykv.vk.openvk.component.video.xj.hf.w.w("failed to get header, rawKey: " + this.c + ", url: " + xjVar2);
            }
        }
        if (file.length() >= xjVar.w || !((hfVar2 = this.zg) == null || hfVar2.hf() || hfVar2.u())) {
            fVar = null;
        } else {
            com.bykv.vk.openvk.component.video.xj.hf.hf xj3 = new hf.xj().xj(this.xj).xj(this.hf).xj(this.c).hf(this.f).xj(new pl(xjVar2.xj)).xj(this.y).xj(this.d).xj(new hf.InterfaceC0015hf() { // from class: com.bykv.vk.openvk.component.video.xj.hf.c.1
                @Override // com.bykv.vk.openvk.component.video.xj.hf.hf.InterfaceC0015hf
                public void xj(com.bykv.vk.openvk.component.video.xj.hf.hf hfVar3) {
                    c.this.w.addAndGet(hfVar3.w.get());
                    c.this.u.addAndGet(hfVar3.u.get());
                    synchronized (hfVar3.g) {
                        hfVar3.g.notifyAll();
                    }
                    if (hfVar3.u()) {
                        c.this.qt.xj(c.this.c(), null);
                    }
                }
            }).xj();
            this.zg = xj3;
            fVar = new com.bytedance.sdk.component.tf.f(xj3, null, 10, 1);
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.xj.hf.c.2
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            if (kd.w) {
                com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        try {
            f fVar3 = new f(file, t.k);
            try {
                fVar3.xj(hfVar.hf());
                int min = this.d.w.kd > 0 ? Math.min(xjVar.w, this.d.w.kd) : xjVar.w;
                while (hfVar.hf() < min) {
                    kd();
                    int xj4 = fVar3.xj(bArr);
                    if (xj4 <= 0) {
                        com.bykv.vk.openvk.component.video.xj.hf.hf hfVar3 = this.zg;
                        if (hfVar3 != null) {
                            com.bykv.vk.openvk.component.video.xj.hf.w.hf d = hfVar3.d();
                            if (d == null) {
                                f.xj f = hfVar3.f();
                                if (f != null) {
                                    throw f;
                                }
                            } else {
                                throw d;
                            }
                        }
                        if (hfVar3 != null && !hfVar3.hf() && !hfVar3.u()) {
                            kd();
                            synchronized (hfVar3.g) {
                                try {
                                    hfVar3.g.wait(1000L);
                                } catch (InterruptedException e) {
                                    com.bytedance.sdk.component.utils.pl.xj(e);
                                }
                            }
                        }
                        if (kd.w) {
                            com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bykv.vk.openvk.component.video.xj.hf.w.w("illegal state download task has finished, rawKey: " + this.c + ", url: " + xjVar2);
                    }
                    hfVar.hf(bArr, 0, xj4);
                    kd();
                }
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_ProxyTask", "read cache file complete: " + hfVar.hf() + ", " + min);
                }
                w();
                fVar3.xj();
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.xj(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fVar2 = fVar3;
                if (fVar2 != null) {
                    fVar2.xj();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th3) {
                        com.bytedance.sdk.component.utils.pl.xj(th3);
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj
    public void xj() {
        super.xj();
        d();
    }
}
