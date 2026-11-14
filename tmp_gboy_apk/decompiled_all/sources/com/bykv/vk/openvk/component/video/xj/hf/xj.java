package com.bykv.vk.openvk.component.video.xj.hf;

import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bykv.vk.openvk.component.video.xj.hf.pl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class xj implements p {
    private static final AtomicLong g = new AtomicLong();
    protected volatile String c;
    protected volatile d d;
    protected volatile String f;
    protected final com.bykv.vk.openvk.component.video.xj.hf.hf.w hf;
    protected com.bykv.vk.openvk.component.video.xj.hf.u.xj kd;
    protected volatile pl tf;
    protected volatile com.bykv.vk.openvk.component.video.xj.hf.xj.xj xj;
    protected volatile List<d.hf> y;
    protected final AtomicInteger w = new AtomicInteger();
    protected final AtomicLong u = new AtomicLong();
    protected volatile boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    public final long f10026pl = g.incrementAndGet();
    private final AtomicInteger am = new AtomicInteger(0);
    private int qt = -1;

    static {
        NFLPWr();
    }

    public xj(com.bykv.vk.openvk.component.video.xj.hf.xj.xj xjVar, com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar) {
        this.xj = xjVar;
        this.hf = wVar;
    }

    private static /* synthetic */ void NFLPWr() {
        char[] charArray = "\\PR\u0011X^RZ\u0011]PF\u0011LWZSS\u0011uQV}MV[XZ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '?');
        }
        String str = new String(charArray);
        char[] charArray2 = "\\SVQVK".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '?');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean c() {
        return y() == 1;
    }

    public boolean hf() {
        return this.am.get() == 1;
    }

    public void kd() {
        if (hf()) {
            throw new com.bykv.vk.openvk.component.video.xj.hf.w.xj();
        }
    }

    public boolean u() {
        return this.am.get() == 2;
    }

    public void w() {
        this.am.compareAndSet(0, 2);
    }

    public int y() {
        return this.d != null ? this.d.w.xj : this.xj instanceof com.bykv.vk.openvk.component.video.xj.hf.xj.hf ? 1 : 0;
    }

    public void xj() {
        this.am.compareAndSet(0, 1);
    }

    public com.bykv.vk.openvk.component.video.xj.hf.kd.xj xj(pl.xj xjVar, int i, int i2, String str) {
        com.bykv.vk.openvk.component.video.xj.hf.kd.hf hf = com.bykv.vk.openvk.component.video.xj.hf.kd.w.xj().hf();
        com.bykv.vk.openvk.component.video.xj.hf.kd.kd kdVar = new com.bykv.vk.openvk.component.video.xj.hf.kd.kd();
        HashMap hashMap = new HashMap();
        kdVar.hf = xjVar.xj;
        kdVar.xj = 0;
        if (com.sigmob.sdk.downloader.core.c.f13360a.equalsIgnoreCase(str)) {
            kdVar.xj = 4;
        }
        List<d.hf> list = this.y;
        if (list != null && !list.isEmpty()) {
            for (d.hf hfVar : list) {
                if (!com.sigmob.sdk.downloader.core.c.b.equalsIgnoreCase(hfVar.xj) && !"Connection".equalsIgnoreCase(hfVar.xj) && !"Proxy-Connection".equalsIgnoreCase(hfVar.xj) && !"Host".equalsIgnoreCase(hfVar.xj)) {
                    hashMap.put(hfVar.xj, hfVar.hf);
                }
            }
        }
        String xj = com.bykv.vk.openvk.component.video.xj.w.xj.xj(i, i2);
        if (xj != null) {
            hashMap.put(com.sigmob.sdk.downloader.core.c.b, xj);
        }
        if (kd.y) {
            hashMap.put("Cache-Control", "no-cache");
        }
        u w = u.w();
        y xj2 = y.xj();
        boolean z = this.d == null;
        w xj3 = z ? w.xj() : xj2.hf();
        w hf2 = z ? w.hf() : xj2.w();
        if (xj3 != null || hf2 != null) {
            if (xj3 != null) {
                kdVar.w = xj3.xj(xjVar.hf);
            }
            if (hf2 != null) {
                kdVar.u = hf2.xj(xjVar.hf);
            }
        }
        kdVar.kd = hashMap;
        if (this.p) {
            this.p = false;
            return null;
        }
        return hf.xj(kdVar);
    }

    public void xj(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = kd.c;
        int y = y();
        if (i3 == 1 || (i3 == 2 && y == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                try {
                    if (i4 <= this.qt) {
                        return;
                    }
                    this.qt = i4;
                    com.bykv.vk.openvk.component.video.xj.w.xj.xj(new Runnable() { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (xj.this.kd != null) {
                                int unused = xj.this.qt;
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
