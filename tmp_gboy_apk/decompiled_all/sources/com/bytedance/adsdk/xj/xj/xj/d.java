package com.bytedance.adsdk.xj.xj.xj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.xj.xj.hf.c;
import com.bytedance.adsdk.xj.xj.hf.y;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class d<R extends com.bytedance.adsdk.xj.xj.hf.y, W extends com.bytedance.adsdk.xj.xj.hf.c> {
    private static final Rect am = new Rect();
    private static final String c = "d";
    private final Handler d;
    private final Object e;
    private final com.bytedance.adsdk.xj.xj.w.hf f;
    private final AtomicBoolean g;
    private boolean jk;
    protected ByteBuffer kd;

    /* renamed from: pl, reason: collision with root package name */
    private final Set<xj> f10096pl;
    private volatile hf pz;
    private final Runnable qt;
    private int tf;
    protected Map<Bitmap, Canvas> u;
    private R v;
    protected int w;
    protected volatile Rect y;
    private W yo;
    private final Set<Bitmap> zg;
    protected List<f<R, W>> xj = new ArrayList();
    protected int hf = -1;
    private Integer p = null;

    public enum hf {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING;

        static {
            YKkI();
        }

        private static /* synthetic */ void YKkI() {
            char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 134);
            }
            String str = new String(charArray);
            char[] charArray2 = "åêïèïò".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 134);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface xj {
        void hf();

        void hf(ByteBuffer byteBuffer);

        void xj();
    }

    static {
        qclN();
    }

    public d(com.bytedance.adsdk.xj.xj.w.hf hfVar, xj xjVar) {
        HashSet hashSet = new HashSet();
        this.f10096pl = hashSet;
        this.g = new AtomicBoolean(true);
        this.qt = new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.g.get()) {
                    return;
                }
                if (!d.this.e()) {
                    d.this.d();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                d.this.d.postDelayed(this, Math.max(0L, d.this.yo() - (System.currentTimeMillis() - currentTimeMillis)));
                Iterator it = d.this.f10096pl.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).hf(d.this.kd);
                }
            }
        };
        this.w = 1;
        this.zg = new HashSet();
        this.e = new Object();
        this.u = new WeakHashMap();
        this.yo = u();
        this.v = null;
        this.jk = false;
        this.pz = hf.IDLE;
        this.f = hfVar;
        if (xjVar != null) {
            hashSet.add(xjVar);
        }
        this.d = com.bytedance.sdk.component.tf.hf.xj.xj().hf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void am() {
        this.d.removeCallbacks(this.qt);
        this.xj.clear();
        synchronized (this.e) {
            try {
                for (Bitmap bitmap : this.zg) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                this.zg.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.kd != null) {
            this.kd = null;
        }
        this.u.clear();
        try {
            if (this.v != null) {
                this.v = null;
            }
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        w();
        this.pz = hf.IDLE;
        Iterator<xj> it = this.f10096pl.iterator();
        while (it.hasNext()) {
            it.next().hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (!tf() || this.xj.size() == 0) {
            return false;
        }
        if (zg() <= 0 || this.tf < zg() - 1) {
            return true;
        }
        if (this.tf == zg() - 1 && this.hf < c() - 1) {
            return true;
        }
        this.jk = true;
        return false;
    }

    private static /* synthetic */ void qclN() {
        char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 143);
        }
        String str = new String(charArray);
        char[] charArray2 = "ìãæáæû".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 143);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String qt() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public long yo() {
        int i = this.hf + 1;
        this.hf = i;
        if (i >= c()) {
            this.hf = 0;
            this.tf++;
        }
        f<R, W> xj2 = xj(this.hf);
        if (xj2 == null) {
            return 0L;
        }
        xj(xj2);
        return xj2.f10097pl;
    }

    private int zg() {
        Integer num = this.p;
        return num != null ? num.intValue() : hf();
    }

    public abstract int hf();

    public abstract Rect hf(R r);

    public void p() {
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.8
            @Override // java.lang.Runnable
            public void run() {
                d.this.tf = 0;
                d dVar = d.this;
                dVar.hf = -1;
                dVar.jk = false;
            }
        });
    }

    public int pl() {
        return this.w;
    }

    public boolean tf() {
        return this.pz == hf.RUNNING || this.pz == hf.INITIALIZING;
    }

    public abstract W u();

    public abstract R w(com.bytedance.adsdk.xj.xj.hf.y yVar);

    public abstract void w();

    public abstract void xj(f<R, W> fVar);

    public int c() {
        return this.xj.size();
    }

    public void d() {
        if (this.y == am) {
            return;
        }
        hf hfVar = this.pz;
        hf hfVar2 = hf.FINISHING;
        if (hfVar == hfVar2 || this.pz == hf.IDLE) {
            com.bytedance.sdk.component.utils.pl.xj(c, qt() + "No need to stop");
            return;
        }
        if (this.pz == hf.INITIALIZING) {
            com.bytedance.sdk.component.utils.pl.u(c, qt() + "Processing,wait for finish at " + this.pz);
        }
        this.pz = hfVar2;
        if (Looper.myLooper() == this.d.getLooper()) {
            am();
        } else {
            this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.7
                @Override // java.lang.Runnable
                public void run() {
                    d.this.am();
                }
            });
        }
    }

    public void f() {
        if (this.y == am) {
            return;
        }
        if (this.pz != hf.RUNNING) {
            hf hfVar = this.pz;
            hf hfVar2 = hf.INITIALIZING;
            if (hfVar != hfVar2) {
                if (this.pz == hf.FINISHING) {
                    com.bytedance.sdk.component.utils.pl.u(c, qt() + " Processing,wait for finish at " + this.pz);
                }
                this.pz = hfVar2;
                if (Looper.myLooper() == this.d.getLooper()) {
                    xj();
                    return;
                } else {
                    this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.6
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.xj();
                        }
                    });
                    return;
                }
            }
        }
        com.bytedance.sdk.component.utils.pl.xj(c, qt() + " Already started");
    }

    public void hf(final xj xjVar) {
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.f10096pl.remove(xjVar);
            }
        });
    }

    public void kd() {
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f10096pl.size() == 0) {
                    d.this.d();
                }
            }
        });
    }

    public int w(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int min = Math.min(y().width() / i, y().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > min) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    public Rect y() {
        if (this.y == null) {
            if (this.pz == hf.FINISHING) {
                com.bytedance.sdk.component.utils.pl.u(c, "In finishing,do not interrupt");
            }
            final Thread currentThread = Thread.currentThread();
            this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (d.this.y == null) {
                                if (d.this.v == null) {
                                    d dVar = d.this;
                                    dVar.v = dVar.w(dVar.f.hf());
                                } else {
                                    d.this.v.d_();
                                }
                                d dVar2 = d.this;
                                dVar2.xj(dVar2.hf((d) dVar2.v));
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                            d.this.y = d.am;
                        }
                        LockSupport.unpark(currentThread);
                    } catch (Throwable th) {
                        LockSupport.unpark(currentThread);
                        throw th;
                    }
                }
            });
            LockSupport.park(currentThread);
        }
        return this.y == null ? am : this.y;
    }

    public boolean hf(int i, int i2) {
        final int w = w(i, i2);
        if (w == this.w) {
            return false;
        }
        final boolean tf = tf();
        this.d.removeCallbacks(this.qt);
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                d.this.am();
                try {
                    d dVar = d.this;
                    dVar.w = w;
                    dVar.xj(dVar.hf((d) dVar.w(dVar.f.hf())));
                    if (tf) {
                        d.this.xj();
                    }
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
        return true;
    }

    public Bitmap xj(int i, int i2) {
        synchronized (this.e) {
            try {
                Iterator<Bitmap> it = this.zg.iterator();
                Bitmap bitmap = null;
                while (it.hasNext()) {
                    int i3 = i * i2 * 4;
                    Bitmap next = it.next();
                    if (next != null && next.getAllocationByteCount() >= i3) {
                        it.remove();
                        if (next.getWidth() == i) {
                            if (next.getHeight() != i2) {
                            }
                            next.eraseColor(0);
                            return next;
                        }
                        if (i > 0 && i2 > 0) {
                            next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                    bitmap = next;
                }
                if (i <= 0 || i2 <= 0) {
                    return null;
                }
                try {
                    try {
                        bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                } catch (OutOfMemoryError e2) {
                    com.bytedance.sdk.component.utils.pl.xj(e2);
                }
                return bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xj(Bitmap bitmap) {
        synchronized (this.e) {
            if (bitmap != null) {
                try {
                    this.zg.add(bitmap);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void xj(final xj xjVar) {
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.xj.xj.xj.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.f10096pl.add(xjVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Rect rect) {
        this.y = rect;
        int height = rect.height() * rect.width();
        int i = this.w;
        this.kd = ByteBuffer.allocate(((height / (i * i)) + 1) * 4);
        if (this.yo == null) {
            this.yo = u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void xj() {
        this.g.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.xj.size() == 0) {
                try {
                    R r = this.v;
                    if (r == null) {
                        this.v = w(this.f.hf());
                    } else {
                        r.d_();
                    }
                    xj(hf((d<R, W>) this.v));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
            String str = c;
            com.bytedance.sdk.component.utils.pl.xj(str, qt() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.pz = hf.RUNNING;
            if (zg() != 0 && this.jk) {
                com.bytedance.sdk.component.utils.pl.xj(str, qt() + " No need to started");
                return;
            }
            this.hf = -1;
            this.qt.run();
            Iterator<xj> it = this.f10096pl.iterator();
            while (it.hasNext()) {
                it.next().xj();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(c, qt() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.pz = hf.RUNNING;
            throw th2;
        }
    }

    public f<R, W> xj(int i) {
        if (i < 0 || i >= this.xj.size()) {
            return null;
        }
        return this.xj.get(i);
    }
}
