package com.bytedance.sdk.component.adexpress.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.xj.w.xj;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.pl;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.models.ClickCommon;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends w {
    private static volatile kd hf;
    private static File xj;
    private AtomicBoolean w = new AtomicBoolean(true);
    private AtomicBoolean u = new AtomicBoolean(false);
    private boolean kd = false;
    private AtomicBoolean y = new AtomicBoolean(false);
    private AtomicInteger c = new AtomicInteger(0);
    private AtomicLong f = new AtomicLong();

    private kd() {
        f();
    }

    public static File c() {
        if (xj == null) {
            try {
                File file = new File(new File(u.xj(), "tt_tmpl_pkg"), ClickCommon.CLICK_SCENE_TEMPLATE);
                file.mkdirs();
                xj = file;
            } catch (Throwable th) {
                pl.w("TemplateManager", "getTemplateDir error", th);
            }
        }
        return xj;
    }

    private void d() {
        if (this.c.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f.get() <= 600000) {
            return;
        }
        y();
    }

    private void f() {
        com.bytedance.sdk.component.adexpress.u.kd.hf(new d("init") { // from class: com.bytedance.sdk.component.adexpress.xj.hf.kd.1
            @Override // java.lang.Runnable
            public void run() {
                f.xj();
                kd.this.w.set(false);
                kd.this.w();
                kd.this.y();
                if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() == null || !e.xj(com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.xj.hf.kd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
                            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj();
                        }
                    }
                });
            }
        }, 10);
    }

    public static kd hf() {
        if (hf == null) {
            synchronized (kd.class) {
                try {
                    if (hf == null) {
                        hf = new kd();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public com.bytedance.sdk.component.adexpress.xj.w.xj kd() {
        return f.hf();
    }

    public boolean u() {
        return this.kd;
    }

    public void w() {
        com.bytedance.sdk.component.adexpress.xj.w.xj hf2 = f.hf();
        if (hf2 == null || !hf2.y()) {
            return;
        }
        boolean xj2 = xj(hf2);
        if (!xj2) {
            f.u();
        }
        this.kd = xj2;
    }

    public void y() {
        xj(false);
    }

    public boolean xj(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar) {
        if (xjVar == null) {
            return false;
        }
        return xj(xjVar.xj()) || xj(xjVar.kd()) || xj(xjVar.getResources());
    }

    @Override // com.bytedance.sdk.component.adexpress.xj.hf.w
    public File xj() {
        return c();
    }

    public void xj(boolean z) {
        List<xj.C0107xj> list;
        boolean z2;
        if (this.w.get()) {
            return;
        }
        try {
            if (this.u.get()) {
                if (z) {
                    this.c.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.u.set(true);
            com.bytedance.sdk.component.adexpress.xj.w.xj w = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().w();
            com.bytedance.sdk.component.adexpress.xj.w.xj hf2 = f.hf();
            if (w != null && w.y()) {
                if (!f.hf(w)) {
                    this.u.set(false);
                    this.f.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
                    com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.xj.hf.kd.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.kd.kd.xj().hf();
                        }
                    });
                }
                f.xj(w);
                boolean xj2 = (w.kd() == null || TextUtils.isEmpty(w.kd().xj())) ? false : xj(w.kd().xj());
                if (w.xj().size() != 0) {
                    list = xj(w, hf2);
                    z2 = list != null;
                } else {
                    list = null;
                    z2 = xj2;
                }
                if (!xj2) {
                    List<xj.C0107xj> hf3 = hf(w, hf2);
                    if (list == null || hf3 == null) {
                        list = hf3;
                    } else {
                        list.addAll(hf3);
                    }
                    if (hf3 == null) {
                        z3 = false;
                    }
                    if (hf3 == null) {
                        this.u.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && xj(w)) {
                    f.xj(w);
                    f.w();
                    hf(list);
                }
                w();
                this.u.set(false);
                this.f.set(System.currentTimeMillis());
                d();
                return;
            }
            this.u.set(false);
            xj(AdEventType.AD_RENDER_SUCCESS);
        } catch (Throwable unused) {
        }
    }
}
