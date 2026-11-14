package com.bykv.vk.openvk.component.video.xj.hf;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bykv.vk.openvk.component.video.xj.hf.f;
import com.bykv.vk.openvk.component.video.xj.hf.pl;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class hf extends com.bykv.vk.openvk.component.video.xj.hf.xj {
    final Object am;
    private volatile f.xj e;
    final Object g;
    private final int qt;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.w.hf yo;
    private final InterfaceC0015hf zg;

    /* renamed from: com.bykv.vk.openvk.component.video.xj.hf.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0015hf {
        void xj(hf hfVar);
    }

    public hf(xj xjVar) {
        super(xjVar.u, xjVar.kd);
        this.qt = xjVar.c;
        this.zg = xjVar.d;
        this.g = this;
        this.c = xjVar.xj;
        this.f = xjVar.hf;
        this.y = xjVar.y;
        this.tf = xjVar.w;
        this.d = xjVar.f;
        this.am = xjVar.tf;
    }

    private boolean tf() {
        while (this.tf.xj()) {
            kd();
            pl.xj hf = this.tf.hf();
            try {
                xj(hf);
                return true;
            } catch (f.xj e) {
                this.e = e;
                c();
                return false;
            } catch (com.bykv.vk.openvk.component.video.xj.hf.w.hf e2) {
                this.yo = e2;
                return false;
            } catch (com.bykv.vk.openvk.component.video.xj.hf.w.w unused) {
                hf.xj();
                c();
            } catch (IOException e3) {
                if (e3 instanceof SocketTimeoutException) {
                    hf.hf();
                }
                if (!hf()) {
                    c();
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b9, code lost:
    
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        if (com.bykv.vk.openvk.component.video.xj.hf.kd.w == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cc, code lost:
    
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(r6.u());
        r4.xj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d6, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(com.bykv.vk.openvk.component.video.xj.hf.pl.xj r13) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.hf.hf.xj(com.bykv.vk.openvk.component.video.xj.hf.pl$xj):void");
    }

    public com.bykv.vk.openvk.component.video.xj.hf.w.hf d() {
        return this.yo;
    }

    public f.xj f() {
        return this.e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.xj.xj(this.f);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            tf();
        } catch (Throwable unused) {
        }
        this.u.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.xj.hf(this.f);
        InterfaceC0015hf interfaceC0015hf = this.zg;
        if (interfaceC0015hf != null) {
            interfaceC0015hf.xj(this);
        }
    }

    public static final class xj {
        int c;
        InterfaceC0015hf d;
        d f;
        String hf;
        com.bykv.vk.openvk.component.video.xj.hf.hf.w kd;
        Object tf;
        com.bykv.vk.openvk.component.video.xj.hf.xj.xj u;
        pl w;
        String xj;
        List<d.hf> y;

        public xj hf(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.hf = str;
            return this;
        }

        public xj xj(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.xj = str;
            return this;
        }

        public xj xj(pl plVar) {
            if (plVar != null) {
                this.w = plVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        public xj xj(com.bykv.vk.openvk.component.video.xj.hf.xj.xj xjVar) {
            if (xjVar != null) {
                this.u = xjVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        public xj xj(com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar) {
            if (wVar != null) {
                this.kd = wVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public xj xj(List<d.hf> list) {
            this.y = list;
            return this;
        }

        public xj xj(int i) {
            this.c = i;
            return this;
        }

        public xj xj(InterfaceC0015hf interfaceC0015hf) {
            this.d = interfaceC0015hf;
            return this;
        }

        public xj xj(d dVar) {
            this.f = dVar;
            return this;
        }

        public xj xj(Object obj) {
            this.tf = obj;
            return this;
        }

        public hf xj() {
            if (this.u != null && this.kd != null && !TextUtils.isEmpty(this.xj) && !TextUtils.isEmpty(this.hf) && this.w != null) {
                return new hf(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
