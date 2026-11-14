package com.bykv.vk.openvk.component.video.xj.u;

import ADYaiT.CtFAbx;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bykv.vk.openvk.component.video.xj.u.w;
import com.bytedance.sdk.component.utils.ai;
import com.czhj.sdk.common.Constants;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements com.bykv.vk.openvk.component.video.api.xj, w.c, w.hf, w.kd, w.u, w.InterfaceC0020w, w.xj, w.y, ai.xj {
    private volatile ai am;
    private volatile boolean b;
    private SurfaceTexture hf;
    private boolean ht;
    private int kd;
    private boolean p;
    private ArrayList<Runnable> ra;
    private boolean tf;
    private SurfaceHolder w;
    private boolean x;
    private static final AtomicInteger xj = new AtomicInteger(0);

    /* renamed from: io, reason: collision with root package name */
    private static final SparseIntArray f10028io = new SparseIntArray();
    private int u = 0;
    private boolean y = false;
    private volatile w c = null;
    private final boolean f = false;
    private boolean d = false;

    /* renamed from: pl, reason: collision with root package name */
    private volatile int f10030pl = 201;
    private long g = -1;
    private volatile boolean qt = false;
    private boolean zg = false;
    private long e = 0;
    private long yo = Long.MIN_VALUE;
    private long v = 0;
    private long jk = 0;
    private long pz = 0;
    private int dk = 0;
    private String et = Constants.FAIL;
    private final List<WeakReference<xj.InterfaceC0014xj>> ai = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.component.video.api.w.u q = null;
    private boolean z = false;
    private volatile int j = 200;
    private AtomicBoolean en = new AtomicBoolean(false);
    private AtomicBoolean l = new AtomicBoolean(false);
    private AtomicBoolean ff = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private Surface f10029a = null;
    private final Runnable wo = new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.1
        @Override // java.lang.Runnable
        public void run() {
            if (u.this.c == null) {
                return;
            }
            long v = u.this.v();
            if (v > 0 && Build.VERSION.SDK_INT >= 23 && u.this.g() && u.this.yo != Long.MIN_VALUE) {
                try {
                    if (u.this.yo == v) {
                        if (!u.this.zg && u.this.v >= 400) {
                            u.this.hf(701, 800);
                            u.this.zg = true;
                        }
                        u.this.v += u.this.j;
                    } else {
                        if (u.this.zg) {
                            u.this.e += u.this.v;
                            u.this.hf(702, 800);
                            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(u.this.e), "  bufferCount =", Integer.valueOf(u.this.u));
                        }
                        u.this.v = 0L;
                        u.this.zg = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (u.this.yo() > 0) {
                if (u.this.yo != v) {
                    if (com.bykv.vk.openvk.component.video.api.w.u()) {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(u.this.yo), "  curPosition = ", Long.valueOf(v));
                    }
                    u uVar = u.this;
                    uVar.xj(v, uVar.yo());
                }
                u.this.yo = v;
            }
            if (u.this.d()) {
                u uVar2 = u.this;
                uVar2.xj(uVar2.yo(), u.this.yo());
            } else if (u.this.am != null) {
                u.this.am.postDelayed(this, u.this.j);
            }
        }
    };
    private final xj r = new xj();
    private long ws = 0;
    private long eu = 0;
    private boolean tj = false;

    public class xj implements Runnable {
        private long hf;
        private boolean w;

        public xj() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.this.c != null) {
                try {
                    if (!this.w) {
                        long d = u.this.c.d();
                        u.this.g = Math.max(this.hf, d);
                    }
                    long unused = u.this.g;
                } catch (Throwable unused2) {
                }
            }
            if (u.this.am != null) {
                u.this.am.sendEmptyMessageDelayed(100, 0L);
            }
        }

        public void xj(boolean z) {
            this.w = z;
        }

        public void xj(long j) {
            this.hf = j;
        }
    }

    static {
        zHJQ();
    }

    public u(String str) {
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("mda_", str, "_");
        B3GDIM2.append(xj.addAndGet(1));
        xj(B3GDIM2.toString(), (Looper) null);
    }

    private void ai() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.pz;
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xj(this, elapsedRealtime);
            }
        }
        this.y = true;
    }

    private void dk() {
        hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.2
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.am != null) {
                    u.this.am.sendEmptyMessage(104);
                }
            }
        });
    }

    private void en() {
        ArrayList<Runnable> arrayList = this.ra;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.ra.clear();
    }

    private void et() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.c == null) {
            return;
        }
        try {
            this.c.pl();
        } catch (Throwable unused) {
        }
        this.c.xj((w.hf) null);
        this.c.xj((w.c) null);
        this.c.xj((w.xj) null);
        this.c.xj((w.u) null);
        this.c.xj((w.InterfaceC0020w) null);
        this.c.xj((w.kd) null);
        this.c.xj((w.y) null);
        try {
            this.c.p();
        } catch (Throwable unused2) {
        }
    }

    private void ht() {
        this.e = 0L;
        this.u = 0;
        this.v = 0L;
        this.zg = false;
        this.yo = Long.MIN_VALUE;
    }

    private void io() {
        ai aiVar = this.am;
        if (aiVar == null || aiVar.getLooper() == null) {
            return;
        }
        aiVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.8
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.am == null || u.this.am.getLooper() == null) {
                    return;
                }
                try {
                    if (u.this.qt) {
                        u.this.am.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.tf.hf.xj.xj().xj(u.this.am);
                    }
                    u.this.am = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ArrayList<Runnable> arrayList = this.ra;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        z();
    }

    private void q() {
        if (this.am != null) {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.this.c.c();
                        u.this.f10030pl = 207;
                        u.this.b = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        if (this.am != null) {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.12
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.c == null) {
                        try {
                            u.this.c = new hf();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (u.this.c == null) {
                            return;
                        }
                        w unused = u.this.c;
                        u.this.et = Constants.FAIL;
                        u.this.c.xj((w.kd) u.this);
                        u.this.c.xj((w.hf) u.this);
                        u.this.c.xj((w.InterfaceC0020w) u.this);
                        u.this.c.xj((w.xj) u.this);
                        u.this.c.xj((w.y) u.this);
                        u.this.c.xj((w.u) u.this);
                        u.this.c.xj((w.c) u.this);
                        try {
                            u.this.c.w(false);
                        } catch (Throwable unused2) {
                        }
                        u.this.d = false;
                    }
                }
            });
        }
    }

    private void x() {
        SparseIntArray sparseIntArray = f10028io;
        sparseIntArray.put(this.dk, sparseIntArray.get(this.dk) + 1);
    }

    private boolean xj(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    private void z() {
        if (this.tf) {
            return;
        }
        this.tf = true;
        Iterator it = new ArrayList(this.ra).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.ra.clear();
        this.tf = false;
    }

    private static /* synthetic */ void zHJQ() {
        char[] charArray = "ieg$mkgo$hes$yboff$@dcHxcnmo".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\n');
        }
        String str = new String(charArray);
        char[] charArray2 = "ifcdc~".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean am() {
        return ((this.f10030pl != 207 && !this.b) || this.am == null || this.am.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int e() {
        return this.u;
    }

    public int jk() {
        if (qt()) {
            return 203;
        }
        return this.f10030pl;
    }

    public boolean pz() {
        return this.f10030pl == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean qt() {
        return this.p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long v() {
        if (qt()) {
            return 0L;
        }
        if (this.f10030pl == 206 || this.f10030pl == 207) {
            try {
                return this.c.d();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long yo() {
        long j = this.jk;
        if (j != 0) {
            return j;
        }
        if (this.f10030pl == 206 || this.f10030pl == 207) {
            try {
                this.jk = this.c.tf();
            } catch (Throwable unused) {
            }
        }
        return this.jk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long zg() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.eu;
        }
        if (this.zg) {
            long j = this.v;
            if (j > 0) {
                return this.e + j;
            }
        }
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceHolder c() {
        return this.w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean d() {
        return this.f10030pl == 209;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceTexture f() {
        return this.hf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean g() {
        return (this.f10030pl == 206 || (this.am != null && this.am.hasMessages(100))) && !this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void kd() {
        if (qt()) {
            return;
        }
        this.p = true;
        en();
        if (this.am != null) {
            try {
                this.am.removeCallbacksAndMessages(null);
                if (this.c != null) {
                    this.am.sendEmptyMessage(103);
                }
                io();
            } catch (Throwable unused) {
                io();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int p() {
        if (this.c == null || qt()) {
            return 0;
        }
        return this.c.g();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int pl() {
        if (this.c == null || qt()) {
            return 0;
        }
        return this.c.am();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean tf() {
        return pz() || g() || am();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean y() {
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(final boolean z) {
        if (qt()) {
            return;
        }
        this.x = z;
        if (this.c != null) {
            this.c.xj(z);
        } else if (this.am != null) {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.11
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.c != null) {
                        u.this.c.xj(z);
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void u() {
        if (qt()) {
            return;
        }
        hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.3
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.am != null) {
                    u.this.am.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (qt() || this.am == null) {
            return;
        }
        this.am.removeMessages(100);
        this.b = true;
        if (!this.tj) {
            if (!this.ht && !hf(this.q)) {
                xj(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (u.this.am != null) {
                            u.this.am.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            } else {
                if (this.am != null) {
                    this.am.sendEmptyMessage(101);
                    return;
                }
                return;
            }
        }
        if (!this.y && !hf(this.q)) {
            xj(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.17
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.am != null) {
                        u.this.am.sendEmptyMessage(101);
                    }
                }
            });
        } else if (this.am != null) {
            this.am.sendEmptyMessage(101);
        }
    }

    private void hf(long j) {
        this.r.xj(j);
        if (this.x) {
            hf(this.r);
        } else if (hf(this.q)) {
            hf(this.r);
        } else {
            xj(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, long j2) {
        long j3;
        long j4;
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                weakReference.get().xj(this, j3, j4);
            }
            j = j3;
            j2 = j4;
        }
    }

    private void xj(String str, Looper looper) {
        this.dk = 0;
        if (looper != null) {
            this.qt = true;
            this.am = new ai(looper, this);
        } else if (this.am == null) {
            this.am = com.bytedance.sdk.component.tf.hf.xj.xj().xj(this, "csj_" + str);
        }
        this.tj = true;
        ra();
    }

    private boolean hf(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        return uVar != null && uVar.c();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf() {
        if (qt() || this.am == null) {
            return;
        }
        this.en.set(true);
        this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.15
            @Override // java.lang.Runnable
            public void run() {
                if (!u.this.am() || u.this.c == null) {
                    return;
                }
                try {
                    u.this.c.kd();
                    com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : u.this.ai) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    u.this.f10030pl = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.y
    public void w(w wVar) {
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xj((com.bykv.vk.openvk.component.video.api.xj) this, true);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.u
    public boolean hf(w wVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.c != wVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.component.video.api.w.hf hfVar = new com.bykv.vk.openvk.component.video.api.w.hf(i, i2);
            for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().xj(this, hfVar);
                }
            }
        }
        hf(i, i2);
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w(boolean z) {
        if (qt()) {
            return;
        }
        this.c.kd(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj() {
        if (qt() || this.c == null) {
            return;
        }
        if (this.f10030pl != 206) {
            ht();
            this.b = false;
            this.r.xj(true);
            hf(0L);
            if (this.am != null) {
                this.am.removeCallbacks(this.wo);
                this.am.postDelayed(this.wo, this.j);
            }
        }
        this.en.set(true);
        if ((this.l.get() || this.ff.get()) && this.am != null) {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.13
                @Override // java.lang.Runnable
                public void run() {
                    u.this.j();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i, int i2) {
        char c;
        char c2;
        if (i == 701) {
            this.ws = SystemClock.elapsedRealtime();
            this.u++;
            for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().xj(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.u));
            return;
        }
        if (i == 702) {
            if (this.ws > 0) {
                c = 0;
                c2 = 2;
                this.eu = (SystemClock.elapsedRealtime() - this.ws) + this.eu;
                this.ws = 0L;
            } else {
                c = 0;
                c2 = 2;
            }
            for (WeakReference<xj.InterfaceC0014xj> weakReference2 : this.ai) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().xj((com.bykv.vk.openvk.component.video.api.xj) this, Integer.MAX_VALUE);
                }
            }
            Integer valueOf = Integer.valueOf(this.u);
            Long valueOf2 = Long.valueOf(this.eu);
            Object[] objArr = new Object[4];
            objArr[c] = "bufferCount = ";
            objArr[1] = valueOf;
            objArr[c2] = " mBufferTotalTime = ";
            objArr[3] = valueOf2;
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", objArr);
            return;
        }
        if (this.tj && i == 3) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.b);
            j();
            ai();
            xj(this.z);
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z, long j, boolean z2) {
        if (qt()) {
            return;
        }
        ra();
        this.z = z2;
        this.b = false;
        xj(z2);
        if (z) {
            this.g = j;
            dk();
        } else {
            hf(j);
        }
        if (this.am != null) {
            this.am.removeCallbacks(this.wo);
            this.am.postDelayed(this.wo, this.j);
        }
        this.en.set(true);
        if ((this.l.get() || this.ff.get()) && this.am != null) {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.14
                @Override // java.lang.Runnable
                public void run() {
                    u.this.j();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.kd
    public void hf(w wVar) {
        if (qt()) {
            return;
        }
        this.f10030pl = 205;
        try {
            com.bykv.vk.openvk.component.video.api.w.u uVar = this.q;
            if (uVar != null) {
                float qt = uVar.qt();
                if (qt > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.hf hfVar = new com.bykv.vk.openvk.component.video.api.hf();
                    hfVar.xj(qt);
                    this.c.xj(hfVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.am != null) {
            if (this.b) {
                q();
            } else {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.am.sendMessage(this.am.obtainMessage(100, -1, -1));
            }
        }
        f10028io.delete(this.dk);
        com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "onPrepared:" + this.tj + " " + this.ht);
        if (!this.tj && !this.ht) {
            ai();
            this.ht = true;
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().hf(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final long j) {
        if (qt()) {
            return;
        }
        if (this.f10030pl == 207 || this.f10030pl == 206 || this.f10030pl == 209) {
            hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.4
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.am != null) {
                        u.this.am.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final SurfaceTexture surfaceTexture) {
        if (qt()) {
            return;
        }
        this.hf = surfaceTexture;
        hf(true);
        hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.5
            @Override // java.lang.Runnable
            public void run() {
                u.this.ra();
                if (u.this.am != null) {
                    u.this.am.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final SurfaceHolder surfaceHolder) {
        if (qt()) {
            return;
        }
        this.w = surfaceHolder;
        hf(true);
        hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.6
            @Override // java.lang.Runnable
            public void run() {
                u.this.ra();
                if (u.this.am != null) {
                    u.this.am.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (qt()) {
            return;
        }
        this.q = uVar;
        if (uVar != null) {
            this.tj = this.tj && !uVar.c();
        }
        hf(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.7
            @Override // java.lang.Runnable
            public void run() {
                u.this.ra();
                if (u.this.am != null) {
                    u.this.am.obtainMessage(107, uVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = this.f10030pl;
        int i2 = message.what;
        if (this.c != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.f10030pl == 205 || this.f10030pl == 207 || this.f10030pl == 209) {
                            this.c.kd();
                            this.pz = SystemClock.elapsedRealtime();
                            this.f10030pl = 206;
                            if (this.g > 0) {
                                this.c.xj(this.g, this.kd);
                                this.g = -1L;
                            }
                            if (this.q != null) {
                                xj(this.z);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.zg) {
                            this.e += this.v;
                        }
                        this.zg = false;
                        this.v = 0L;
                        this.yo = Long.MIN_VALUE;
                        if (this.f10030pl == 206 || this.f10030pl == 207 || this.f10030pl == 209) {
                            this.c.c();
                            this.f10030pl = 207;
                            this.b = false;
                            for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.c.pl();
                        this.f10030pl = 201;
                        return;
                    case 103:
                        try {
                            et();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                        }
                        for (WeakReference<xj.InterfaceC0014xj> weakReference2 : this.ai) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().w(this);
                            }
                        }
                        this.f10030pl = 203;
                        return;
                    case 104:
                        if (this.f10030pl == 202 || this.f10030pl == 208) {
                            try {
                                this.c.f();
                                return;
                            } catch (Throwable th2) {
                                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                                return;
                            }
                        }
                        break;
                    case 105:
                        if (this.f10030pl == 205 || this.f10030pl == 206 || this.f10030pl == 208 || this.f10030pl == 207 || this.f10030pl == 209) {
                            this.c.y();
                            this.f10030pl = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.f10030pl == 206 || this.f10030pl == 207 || this.f10030pl == 209) {
                            this.c.xj(((Long) message.obj).longValue(), this.kd);
                            return;
                        }
                        break;
                    case 107:
                        ht();
                        if (this.f10030pl == 201 || this.f10030pl == 203) {
                            com.bykv.vk.openvk.component.video.api.w.u uVar = (com.bykv.vk.openvk.component.video.api.w.u) message.obj;
                            if (TextUtils.isEmpty(uVar.kd())) {
                                uVar.xj(com.bykv.vk.openvk.component.video.api.w.xj());
                            }
                            File file = new File(uVar.kd(), uVar.e());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (com.bykv.vk.openvk.component.video.api.w.hf()) {
                                    xj(file.getAbsolutePath());
                                } else {
                                    this.c.xj(file.getAbsolutePath());
                                }
                            } else {
                                uVar.zg();
                                if (uVar.hf == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.c.xj(uVar.zg());
                                    uVar.zg();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.c.xj(uVar);
                                    uVar.zg();
                                } else {
                                    String hf = com.bykv.vk.openvk.component.video.xj.hf.y.xj.xj().hf(uVar);
                                    if (hf != null && com.bykv.vk.openvk.component.video.api.w.hf() && hf.startsWith(n.z)) {
                                        xj(Uri.parse(hf).getPath());
                                    } else {
                                        this.c.xj(hf);
                                    }
                                }
                            }
                            this.f10030pl = 202;
                            return;
                        }
                        break;
                    case 108:
                    case AdEventType.AD_RENDER_SUCCESS /* 109 */:
                    default:
                        return;
                    case 110:
                        this.c.xj((SurfaceHolder) message.obj);
                        this.c.hf(true);
                        this.l.set(true);
                        if (this.en.get()) {
                            j();
                            return;
                        }
                        return;
                    case 111:
                        this.f10029a = new Surface((SurfaceTexture) message.obj);
                        this.c.xj(this.f10029a);
                        this.c.hf(true);
                        this.ff.set(true);
                        if (this.en.get()) {
                            j();
                            return;
                        }
                        return;
                }
                this.f10030pl = 200;
                if (this.d) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.hf hfVar = new com.bykv.vk.openvk.component.video.api.w.hf(308, i2);
                hfVar.xj(i + "," + i2);
                for (WeakReference<xj.InterfaceC0014xj> weakReference3 : this.ai) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().xj(this, hfVar);
                    }
                }
                this.d = true;
            } catch (Throwable unused) {
            }
        }
    }

    private void hf(Runnable runnable) {
        if (runnable == null || qt()) {
            return;
        }
        if (!this.p) {
            runnable.run();
        } else {
            xj(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(int i) {
        if (qt()) {
            return;
        }
        this.j = i;
    }

    private void xj(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.c.xj(fileInputStream.getFD());
        fileInputStream.close();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.xj
    public void xj(w wVar, int i) {
        if (this.c != wVar) {
            return;
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().hf(this, i);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.hf
    public void xj(w wVar) {
        this.f10030pl = 209;
        f10028io.delete(this.dk);
        if (this.am != null) {
            this.am.removeCallbacks(this.wo);
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xj(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.InterfaceC0020w
    public boolean xj(w wVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", "what=" + i + "extra=" + i2);
        x();
        this.f10030pl = 200;
        if (this.am != null) {
            this.am.removeCallbacks(this.wo);
        }
        if (xj(i, i2)) {
            io();
        }
        if (!this.en.get()) {
            return true;
        }
        this.en.set(false);
        com.bykv.vk.openvk.component.video.api.w.hf hfVar = new com.bykv.vk.openvk.component.video.api.w.hf(i, i2);
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xj(this, hfVar);
            }
        }
        return true;
    }

    private void xj(Runnable runnable) {
        try {
            if (this.ra == null) {
                this.ra = new ArrayList<>();
            }
            this.ra.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final boolean z) {
        if (qt()) {
            return;
        }
        if (this.am == null) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.am.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.u.u.10
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.qt() || u.this.c == null) {
                        return;
                    }
                    try {
                        u.this.z = z;
                        u.this.c.u(z);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w.c
    public void xj(w wVar, int i, int i2, int i3, int i4) {
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xj((com.bykv.vk.openvk.component.video.api.xj) this, i, i2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(xj.InterfaceC0014xj interfaceC0014xj) {
        if (interfaceC0014xj == null) {
            return;
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ai) {
            if (weakReference != null && weakReference.get() == interfaceC0014xj) {
                return;
            }
        }
        this.ai.add(new WeakReference<>(interfaceC0014xj));
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(int i) {
        this.kd = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(float f) {
        try {
            com.bykv.vk.openvk.component.video.api.hf hfVar = new com.bykv.vk.openvk.component.video.api.hf();
            hfVar.xj(f);
            this.c.xj(hfVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
