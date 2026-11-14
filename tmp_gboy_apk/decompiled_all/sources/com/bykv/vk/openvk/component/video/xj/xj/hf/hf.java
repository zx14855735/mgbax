package com.bykv.vk.openvk.component.video.xj.xj.hf;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.utils.pl;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private u hf;
    private File kd;
    private File u;
    private Context xj;
    private volatile boolean w = false;
    private final List<xj.InterfaceC0012xj> y = new ArrayList();
    private volatile boolean c = false;

    public hf(Context context, u uVar) {
        this.u = null;
        this.kd = null;
        this.xj = context;
        this.hf = uVar;
        this.u = com.bykv.vk.openvk.component.video.xj.kd.w.hf(uVar.kd(), uVar.e());
        this.kd = com.bykv.vk.openvk.component.video.xj.kd.w.w(uVar.kd(), uVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        try {
            if (this.u.renameTo(this.kd)) {
                return;
            }
            throw new IOException("Error renaming file " + this.u + " to " + this.kd + " for completion!");
        } catch (Throwable th) {
            pl.xj(th);
            com.bykv.vk.openvk.component.video.api.y.w.xj("VideoPreload", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            this.kd.delete();
            this.u.delete();
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void w() {
        pl.xj hf = com.bykv.vk.openvk.component.video.api.w.w() != null ? com.bykv.vk.openvk.component.video.api.w.w().hf() : new pl.xj("v_preload");
        long v = this.hf.v();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        hf.xj(v, timeUnit).hf(this.hf.jk(), timeUnit).w(this.hf.pz(), timeUnit);
        com.bytedance.sdk.component.hf.xj.pl xj = hf.xj();
        am.xj xjVar = new am.xj();
        final long length = this.u.length();
        int y = this.hf.y();
        boolean g = this.hf.g();
        int hf2 = this.hf.hf();
        if (hf2 > 0) {
            if (hf2 >= this.hf.pl()) {
                g = true;
            } else {
                y = hf2;
            }
        }
        if (g) {
            xjVar.xj("RANGE", "bytes=" + length + "-").xj(this.hf.zg()).xj().hf();
        } else {
            xjVar.xj("RANGE", "bytes=" + length + "-" + y).xj(this.hf.zg()).xj().hf();
        }
        xj.xj(xjVar.hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bykv.vk.openvk.component.video.xj.xj.hf.hf.1
            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
                hf hfVar2 = hf.this;
                hfVar2.xj(hfVar2.hf, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                w.xj(hf.this.hf);
            }

            /* JADX WARN: Code restructure failed: missing block: B:83:0x0131, code lost:
            
                r0 = r27.hf;
                r0.hf(r0.hf, r29.w());
             */
            /* JADX WARN: Code restructure failed: missing block: B:84:0x013e, code lost:
            
                r27.hf.xj(r14);
                r27.hf.xj(r7);
                r27.hf.xj(r3);
                r27.hf.xj(r29);
                r0 = r27.hf.hf.zg();
                r2 = java.lang.Integer.valueOf(r27.hf.hf.y());
                r3 = new java.lang.Object[4];
                r3[0] = "Pre finally ";
                r3[r18] = r0;
                r3[2] = " Preload size=";
                r3[3] = r2;
                com.bykv.vk.openvk.component.video.api.y.w.xj("VideoPreload", r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:89:0x01b2, code lost:
            
                r24 = r3;
                r25 = r4;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x01c0, code lost:
            
                if (r27.hf.hf.g() == false) goto L61;
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x01ce, code lost:
            
                if (r25 != r27.hf.u.length()) goto L61;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x01d0, code lost:
            
                r27.hf.kd();
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x01d5, code lost:
            
                r0 = r27.hf;
                r0.xj(r0.hf, r29.w());
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01e2, code lost:
            
                r0 = r24;
             */
            /* JADX WARN: Removed duplicated region for block: B:21:0x027a A[Catch: all -> 0x027f, TryCatch #12 {all -> 0x027f, blocks: (B:19:0x026a, B:21:0x027a, B:22:0x0283), top: B:18:0x026a }] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0281  */
            @Override // com.bytedance.sdk.component.hf.xj.w
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponse(com.bytedance.sdk.component.hf.xj.hf r28, com.bytedance.sdk.component.hf.xj.zg r29) {
                /*
                    Method dump skipped, instructions count: 778
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.xj.hf.hf.AnonymousClass1.onResponse(com.bytedance.sdk.component.hf.xj.hf, com.bytedance.sdk.component.hf.xj.zg):void");
            }
        });
    }

    private boolean hf() {
        if (this.kd.exists()) {
            return true;
        }
        if (!this.hf.g()) {
            if (this.u.length() >= this.hf.y()) {
                return true;
            }
            if (this.hf.hf() > 0 && this.u.length() >= this.hf.hf()) {
                return true;
            }
        }
        return false;
    }

    public void xj(xj.InterfaceC0012xj interfaceC0012xj) {
        if (this.c) {
            synchronized (xj.InterfaceC0012xj.class) {
                this.y.add(interfaceC0012xj);
            }
            return;
        }
        this.y.add(interfaceC0012xj);
        if (hf()) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("VideoPreload", "Cache file is exist");
            this.hf.d(1);
            xj(this.hf, 200);
            w.xj(this.hf);
            return;
        }
        this.c = true;
        this.hf.d(0);
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(u uVar, int i) {
        synchronized (xj.InterfaceC0012xj.class) {
            try {
                for (xj.InterfaceC0012xj interfaceC0012xj : this.y) {
                    if (interfaceC0012xj != null) {
                        interfaceC0012xj.hf(uVar, i);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public u xj() {
        return this.hf;
    }

    public void xj(boolean z) {
        this.w = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(u uVar, int i) {
        synchronized (xj.InterfaceC0012xj.class) {
            try {
                for (xj.InterfaceC0012xj interfaceC0012xj : this.y) {
                    if (interfaceC0012xj != null) {
                        interfaceC0012xj.xj(uVar, i);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(u uVar, int i, String str) {
        synchronized (xj.InterfaceC0012xj.class) {
            try {
                for (xj.InterfaceC0012xj interfaceC0012xj : this.y) {
                    if (interfaceC0012xj != null) {
                        interfaceC0012xj.xj(uVar, i, str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
