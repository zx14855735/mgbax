package com.bytedance.sdk.component.f.hf.hf.w;

import J3FDQU.A2egSU;
import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends kd implements Handler.Callback {
    private static int qt = 10;
    private static int zg = 200;
    private volatile boolean am;
    private int c;
    private final long d;
    private final String e;
    private final AtomicInteger f;
    private final List<com.bytedance.sdk.component.f.xj.hf> g;
    private com.bytedance.sdk.component.f.hf.xj.hf ht;
    private volatile String jk;
    private y kd;
    private volatile Handler p;

    /* renamed from: pl, reason: collision with root package name */
    private final List<com.bytedance.sdk.component.f.xj.hf> f10203pl;
    private final HashMap<String, List<com.bytedance.sdk.component.f.xj.hf>> pz;
    private final long tf;
    private final Object u;
    private volatile int v;
    protected com.bytedance.sdk.component.f.hf.xj.kd xj;
    private final int y;
    private final String yo;

    public w(com.bytedance.sdk.component.f.xj.kd kdVar, com.bytedance.sdk.component.f.hf.hf.hf hfVar) {
        super(kdVar, hfVar);
        this.u = new Object();
        this.y = 50;
        this.c = 30;
        this.f = new AtomicInteger(0);
        this.d = PushUIConfig.dismissTime;
        this.tf = 5000000000L;
        this.f10203pl = new ArrayList();
        this.g = new CopyOnWriteArrayList();
        this.am = false;
        this.e = "after_upload";
        this.yo = "prepare_upload";
        this.v = 0;
        this.jk = "DEFAULT";
        this.pz = new HashMap<>();
        this.xj = new com.bytedance.sdk.component.f.hf.xj.w(kdVar, this);
        this.kd = new y(this.hf, this.w);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean xj = this.hf.u().xj(this.hf.getContext());
            if (i == 1) {
                synchronized (w.class) {
                    try {
                        if (!this.g.isEmpty()) {
                            int size = this.g.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                xj(this.g.get(i2), 1, xj);
                            }
                        }
                        this.am = true;
                        this.g.clear();
                    } finally {
                    }
                }
            } else if (i == 3) {
                hf(3, xj);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.f10203pl);
                this.f10203pl.clear();
                xj(arrayList, false, "timeout_dispatch", 5);
            } else if (i == 74) {
                xj((com.bytedance.sdk.component.f.xj.hf) message.obj, 74, xj);
            } else if (i == 71) {
                xj(71, xj);
            } else if (i == 72) {
                xj(72, xj);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w("_ms", A2egSU.B4ZgIw(th, new StringBuilder("error:")), this.hf);
        }
        return true;
    }

    public Handler hf() {
        return this.p;
    }

    public boolean u() {
        return com.bytedance.sdk.component.f.hf.w.xj.xj(this.hf) && this.w.w();
    }

    @Override // com.bytedance.sdk.component.f.hf.hf.w.kd
    public void w() {
        super.w();
        this.p = new Handler(c(), this);
        this.w.xj(this.p);
        this.p.sendEmptyMessage(1);
    }

    public com.bytedance.sdk.component.f.hf.xj.kd xj() {
        return this.xj;
    }

    private void hf(int i, boolean z) {
        hf((com.bytedance.sdk.component.f.xj.hf) null, i, z);
    }

    private void xj(int i, boolean z) {
        hf((com.bytedance.sdk.component.f.xj.hf) null, i, z);
    }

    private boolean hf(com.bytedance.sdk.component.f.xj.hf hfVar, boolean z) {
        return com.bytedance.sdk.component.f.hf.w.xj.xj(this.hf) && this.hf.w();
    }

    public boolean xj(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (this.hf == null) {
            return false;
        }
        return this.xj.xj(i, str, hfVar);
    }

    private void hf(com.bytedance.sdk.component.f.xj.hf hfVar, int i, boolean z) {
        if (hf(hfVar, z)) {
            com.bytedance.sdk.component.f.hf.w.w.xj("_error", " upload cancel cause config " + com.bytedance.sdk.component.f.hf.w.xj.w(hfVar, this.hf), this.hf);
            return;
        }
        boolean u = u();
        boolean z2 = false;
        boolean z3 = com.bytedance.sdk.component.f.hf.w.xj.d(hfVar, this.hf) || i == 3;
        boolean xj = com.bytedance.sdk.component.f.hf.w.xj.xj(i);
        com.bytedance.sdk.component.f.hf.w.w.w("_error", "serbusy:" + u + " isCsjBusy:" + z3 + " flush:" + xj, this.hf);
        if (u && !xj && z3) {
            if (i == 3) {
                com.bytedance.sdk.component.f.hf.w.w.w("_error", "start do flush", this.hf);
                xj(72, z);
                return;
            } else {
                if (i != 74 && i != 1) {
                    com.bytedance.sdk.component.f.hf.w.w.w("_error", "server busy", this.hf);
                    return;
                }
                boolean hasMessages = this.p.hasMessages(3);
                com.bytedance.sdk.component.f.hf.w.w.w("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(hasMessages)), this.hf);
                if (hasMessages) {
                    return;
                }
                this.kd.xj(3, 15000L, this.p);
                return;
            }
        }
        if (!z) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", "AdThread NET IS NOT AVAILABLE!!!", this.hf);
            return;
        }
        boolean xj2 = xj(i, "needUpload check", hfVar);
        if (xj2) {
            List<com.bytedance.sdk.component.f.xj.hf> xj3 = this.xj.xj(i, hfVar, u, this.v + "_" + this.jk);
            if (xj3 != null && xj3.size() != 0) {
                com.bytedance.sdk.component.f.hf.w.w.hf("_ms", "prepare get size =" + xj3.size(), this.hf);
                xj(xj3, i);
            } else {
                com.bytedance.sdk.component.f.hf.w.w.hf("_ms", "prepare get no event need upload", this.hf);
                xj("prepare_upload");
                com.bytedance.sdk.component.f.hf.w.w.xj("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.hf);
            }
        } else {
            com.bytedance.sdk.component.f.hf.w.w.hf("_ms", "prepare upload no need", this.hf);
            this.pz.clear();
            xj("prepare_upload");
        }
        z2 = xj2;
        com.bytedance.sdk.component.f.hf.w.w.xj("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.hf);
    }

    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar, boolean z) {
        if (hfVar == null) {
            return;
        }
        if (z) {
            if (this.p != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(hfVar);
                xj(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.f.hf.w.w.w("_error", "other thread handler is null，ignore is true", this.hf);
            return;
        }
        if (this.am) {
            Message obtain = Message.obtain();
            obtain.obj = hfVar;
            obtain.what = 74;
            this.p.sendMessage(obtain);
            return;
        }
        this.g.add(hfVar);
    }

    public void xj(int i, String str) {
        try {
            if (!this.hf.u().xj(this.hf.getContext())) {
                com.bytedance.sdk.component.f.hf.w.w.w("_error", "AdThread NET IS NOT AVAILABLE", this.hf);
                return;
            }
            boolean xj = xj(i, str + " check", (com.bytedance.sdk.component.f.xj.hf) null);
            com.bytedance.sdk.component.f.hf.w.w.hf("_flush", "notify runOnce check: ".concat(String.valueOf(xj)), this.hf);
            if (xj) {
                Message obtain = Message.obtain();
                obtain.what = i;
                this.p.sendMessage(obtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w(th.getMessage(), this.hf);
        }
    }

    private void xj(com.bytedance.sdk.component.f.xj.hf hfVar, int i, boolean z) {
        try {
            xj(hfVar);
            hf(hfVar, i, z);
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", A2egSU.B4ZgIw(th, new StringBuilder("run exception:")), this.hf);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.w(), 1, this.hf);
        }
    }

    private void hf(List<com.bytedance.sdk.component.f.xj.hf> list, String str, int i) {
        this.f10203pl.addAll(list);
        com.bytedance.sdk.component.f.xj.u u = this.hf.u();
        if (u != null && u.pl() != null) {
            qt = u.pl().u();
        }
        if (this.f10203pl.size() >= qt) {
            if (this.p.hasMessages(5)) {
                this.p.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.f10203pl);
            this.f10203pl.clear();
            xj(arrayList, false, "max_size_dispatch", i);
            return;
        }
        xj(str);
    }

    private void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        this.f.set(0);
        com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.p(), 1, this.hf);
        this.xj.xj(hfVar);
        com.bytedance.sdk.component.f.hf.w.xj.xj(hfVar, this.hf, "_ad");
        com.bytedance.sdk.component.f.hf.w.xj.f(hfVar, this.hf);
    }

    private void xj(String str) {
        if (this.f10203pl.size() != 0) {
            com.bytedance.sdk.component.f.xj.u u = this.hf.u();
            if (this.p.hasMessages(5)) {
                this.p.removeMessages(5);
            }
            long j = zg;
            if (u != null && u.pl() != null) {
                j = u.pl().w();
            }
            this.p.sendEmptyMessageDelayed(5, j);
            this.f10203pl.size();
            return;
        }
        com.bytedance.sdk.component.f.hf.w.w.xj("_ms", "do nothing", this.hf);
    }

    private void xj(List<com.bytedance.sdk.component.f.xj.hf> list, String str, int i) {
        xj(list, false, str, i);
    }

    private void xj(List<com.bytedance.sdk.component.f.xj.hf> list, int i) {
        com.bytedance.sdk.component.f.hf.w.xj.xj(list, this.hf);
        com.bytedance.sdk.component.f.xj.hf hfVar = list.get(0);
        if (hfVar == null) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", "adLogEvent is null", this.hf);
            return;
        }
        if (list.size() <= 1 && !com.bytedance.sdk.component.f.hf.w.xj.hf(this.hf) && !com.bytedance.sdk.component.f.hf.w.xj.u(this.hf)) {
            if (hfVar.kd() == 1) {
                xj(list, "highPriority", i);
                return;
            }
            if (hfVar.u() == 0 && hfVar.kd() == 2) {
                if (hfVar.hf() == 3) {
                    xj(list, "version_v3_single_directly", i);
                    return;
                } else {
                    hf(list, "singleOptimize", i);
                    return;
                }
            }
            if (hfVar.u() == 1) {
                xj(list, "stats_directly", i);
                return;
            }
            if (hfVar.u() == 3) {
                xj(list, "adType_v3_directly", i);
                return;
            } else if (hfVar.u() != 2) {
                com.bytedance.sdk.component.f.hf.w.w.w("_error", "adLogEvent adType error", this.hf);
                return;
            } else {
                xj(list, "other_directly", i);
                return;
            }
        }
        if (hfVar.u() == 0 && hfVar.kd() == 2 && i == 74) {
            if (hfVar.hf() == 3) {
                xj(list, "version_v3_batch", i);
                return;
            } else {
                hf(list, "batchOptimize", i);
                return;
            }
        }
        xj(list, "batchRead", i);
    }

    private void xj(List<com.bytedance.sdk.component.f.xj.hf> list, boolean z, String str, int i) {
        this.kd.xj(list, z, str, i, this.u, this.ht);
        if (z) {
            return;
        }
        xj(i);
    }

    private void xj(int i) {
        long nanoTime;
        xj("after_upload");
        com.bytedance.sdk.component.f.hf.w.xj.hf(i);
        if (i == 72) {
            synchronized (this.u) {
                try {
                    long nanoTime2 = System.nanoTime();
                    this.u.wait(PushUIConfig.dismissTime);
                    nanoTime = System.nanoTime() - nanoTime2;
                } catch (InterruptedException e) {
                    com.bytedance.sdk.component.f.hf.w.w.w("_error", "wait exception:" + e.getMessage(), this.hf);
                }
                if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                    if (u()) {
                        com.bytedance.sdk.component.f.hf.w.w.w("_error", "return wait serverBusy", this.hf);
                        return;
                    }
                    if (this.w.u()) {
                        com.bytedance.sdk.component.f.hf.w.w.w("_error", "return wait otherError", this.hf);
                        return;
                    }
                    com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.hf(), 1, this.hf);
                    int i2 = this.c + 1;
                    this.c = i2;
                    if (i2 < 50) {
                        com.bytedance.sdk.component.f.hf.w.w.hf("_flush", "afterUpload send flush again:" + this.c, this.hf);
                        xj(72, "continue");
                    } else {
                        this.c = 0;
                        if (this.p.hasMessages(72)) {
                            this.p.removeMessages(72);
                        }
                        com.bytedance.sdk.component.f.hf.w.w.w("_error", "afterUpload send flush end:" + this.c, this.hf);
                    }
                    return;
                }
                com.bytedance.sdk.component.f.hf.w.w.w("_error", "return wait timeout", this.hf);
                return;
            }
        }
        this.c = 0;
        if (this.p.hasMessages(72)) {
            this.p.removeMessages(72);
        }
    }
}
