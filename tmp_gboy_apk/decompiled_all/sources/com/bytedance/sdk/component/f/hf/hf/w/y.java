package com.bytedance.sdk.component.f.hf.hf.w;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.os.Handler;
import com.bytedance.sdk.component.f.xj.tf;
import com.bytedance.sdk.component.utils.pl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private final com.bytedance.sdk.component.f.xj.kd kd;
    private w w;
    private final com.bytedance.sdk.component.f.hf.hf.hf y;
    private volatile long u = 0;
    public final AtomicInteger xj = new AtomicInteger(0);
    public final AtomicInteger hf = new AtomicInteger(0);

    public y(com.bytedance.sdk.component.f.xj.kd kdVar, com.bytedance.sdk.component.f.hf.hf.hf hfVar) {
        this.kd = kdVar;
        this.y = hfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(List<com.bytedance.sdk.component.f.xj.hf> list, boolean z, long j, int i, Object obj) {
        hf xj;
        try {
            com.bytedance.sdk.component.f.xj.hf hfVar = list.get(0);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.jk(), 1, this.kd);
            if (hfVar.u() == 0) {
                xj = com.bytedance.sdk.component.f.hf.hf.y().xj(list);
                xj(xj, list);
                if (xj != null) {
                    com.bytedance.sdk.component.f.hf.w.xj.xj(list, xj.u, this.kd);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().c());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.bytedance.sdk.component.f.hf.w.w.w("_error", "json exception:" + e.getMessage(), this.kd);
                }
                xj = com.bytedance.sdk.component.f.hf.hf.y().xj(jSONObject);
            }
            hf hfVar2 = xj;
            this.hf.decrementAndGet();
            xj(z, hfVar2, list, j, obj, i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", A2egSU.B4ZgIw(th, new StringBuilder("inner exception:")), this.kd);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.w(), 1, this.kd);
            this.hf.decrementAndGet();
        }
    }

    public void xj(List<com.bytedance.sdk.component.f.xj.hf> list, boolean z, String str, int i, Object obj, com.bytedance.sdk.component.f.hf.xj.hf hfVar) {
        this.w = this.y.kd();
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.f.hf.w.xj.xj(list, i, str, this.kd);
        if (this.kd.tf() != null) {
            xj(list, z, currentTimeMillis, obj, i);
        } else {
            com.bytedance.sdk.component.f.hf.w.xj.xj(list, str, hfVar);
            xj(list, z, currentTimeMillis, i, obj);
        }
    }

    private void xj(final List<com.bytedance.sdk.component.f.xj.hf> list, final boolean z, final long j, final int i, final Object obj) {
        com.bytedance.sdk.component.f.xj.u u = this.kd.u();
        if (u != null) {
            Executor d = u.d();
            if (list.get(0).kd() == 1) {
                d = u.f();
            }
            Executor executor = d;
            if (executor == null) {
                return;
            }
            this.hf.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.f.hf.kd.hf("csj_log_upload") { // from class: com.bytedance.sdk.component.f.hf.hf.w.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.hf(list, z, j, i, obj);
                }
            });
        }
    }

    private void xj(hf hfVar, List<com.bytedance.sdk.component.f.xj.hf> list) {
        if (hfVar == null || !hfVar.xj) {
            return;
        }
        List<com.bytedance.sdk.component.f.xj.w> xj = com.bytedance.sdk.component.f.hf.xj.xj();
        if (list == null || xj == null || xj.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.f.xj.hf hfVar2 : list) {
            if (hfVar2.kd() == 1) {
                String xj2 = com.bytedance.sdk.component.f.hf.w.xj.xj(hfVar2, this.kd);
                String y = com.bytedance.sdk.component.f.hf.w.xj.y(hfVar2, this.kd);
                for (com.bytedance.sdk.component.f.xj.w wVar : xj) {
                    if (wVar != null) {
                        wVar.xj(xj2, y);
                    }
                }
            }
        }
    }

    private void xj(List<com.bytedance.sdk.component.f.xj.hf> list, final boolean z, final long j, final Object obj, final int i) {
        this.hf.incrementAndGet();
        com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.jk(), 1, this.kd);
        try {
            this.kd.tf().xj(list, new tf() { // from class: com.bytedance.sdk.component.f.hf.hf.w.y.2
                @Override // com.bytedance.sdk.component.f.xj.tf
                public void xj(List<xj> list2) {
                    try {
                        y.this.hf.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            xj xjVar = list2.get(i2);
                            if (xjVar != null) {
                                y.this.xj(z, xjVar.xj(), xjVar.hf(), j, obj, i);
                            }
                        }
                    } catch (Exception e) {
                        pl.xj(e);
                    }
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", CtFAbx.AZOQYO(e, new StringBuilder("outer exception：")), this.kd);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.w(), 1, this.kd);
            this.hf.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z, hf hfVar, List<com.bytedance.sdk.component.f.xj.hf> list, long j, Object obj, int i) {
        if (z) {
            return;
        }
        if (hfVar != null) {
            int i2 = hfVar.hf;
            if (hfVar.kd) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (hfVar.xj || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.hf.get();
            }
            xj(i3, list, j, obj, i, hfVar);
            return;
        }
        xj(-1, list, j, obj, i, (hf) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c2, code lost:
    
        r13.notify();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(int r9, java.util.List<com.bytedance.sdk.component.f.xj.hf> r10, long r11, java.lang.Object r13, int r14, com.bytedance.sdk.component.f.hf.hf.w.hf r15) {
        /*
            r8 = this;
            com.bytedance.sdk.component.f.hf.hf.w.w r0 = r8.w
            monitor-enter(r13)
            if (r10 == 0) goto Lc7
            if (r0 != 0) goto L9
            goto Lc7
        L9:
            android.os.Handler r1 = r0.hf()     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.xj.kd r6 = r8.kd     // Catch: java.lang.Throwable -> L29
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r15
            com.bytedance.sdk.component.f.hf.w.xj.xj(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.hf.xj.kd r9 = r0.xj()     // Catch: java.lang.Throwable -> L29
            r9.xj(r2, r3, r14)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.xj.kd r9 = r8.kd     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.xj.u r9 = r9.u()     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto L2d
            r9.pl()     // Catch: java.lang.Throwable -> L29
            goto L2d
        L29:
            r0 = move-exception
            r9 = r0
            goto Lc9
        L2d:
            r10 = -2
            r11 = 72
            if (r2 == r10) goto L8e
            r10 = -1
            if (r2 == r10) goto L6d
            if (r2 == 0) goto L8e
            r9 = 200(0xc8, float:2.8E-43)
            if (r2 == r9) goto L6d
            r9 = 509(0x1fd, float:7.13E-43)
            if (r2 == r9) goto L41
            goto Lc0
        L41:
            com.bytedance.sdk.component.f.xj.kd r9 = r8.kd     // Catch: java.lang.Throwable -> L29
            boolean r9 = com.bytedance.sdk.component.f.hf.w.xj.hf(r3, r9)     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto Lc0
            com.bytedance.sdk.component.f.hf.hf.hf r9 = r8.y     // Catch: java.lang.Throwable -> L29
            r10 = 1
            r9.xj(r10)     // Catch: java.lang.Throwable -> L29
            r9 = 3
            boolean r10 = r1.hasMessages(r9)     // Catch: java.lang.Throwable -> L29
            if (r10 != 0) goto Lc0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L29
            long r4 = r8.u     // Catch: java.lang.Throwable -> L29
            long r2 = r2 - r4
            r4 = 15000(0x3a98, double:7.411E-320)
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 < 0) goto Lc0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L29
            r8.u = r2     // Catch: java.lang.Throwable -> L29
            r8.xj(r9, r4, r1)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L6d:
            com.bytedance.sdk.component.f.hf.hf.hf r9 = r8.y     // Catch: java.lang.Throwable -> L29
            boolean r9 = r9.u()     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto L84
            java.lang.String r9 = "_flush"
            java.lang.String r10 = "send reset error"
            com.bytedance.sdk.component.f.xj.kd r12 = r8.kd     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.hf.w.w.w(r9, r10, r12)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = "handle_result"
            r0.xj(r11, r9)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L84:
            com.bytedance.sdk.component.f.hf.hf.hf r9 = r8.y     // Catch: java.lang.Throwable -> L29
            r10 = 0
            r9.xj(r10)     // Catch: java.lang.Throwable -> L29
            r8.xj(r1, r3, r0)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L8e:
            if (r9 == 0) goto Lb7
            java.lang.String r10 = "_error"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            java.lang.String r15 = "net is available:"
            r12.<init>(r15)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.xj.kd r15 = r8.kd     // Catch: java.lang.Throwable -> L29
            android.content.Context r15 = r15.getContext()     // Catch: java.lang.Throwable -> L29
            boolean r9 = r9.xj(r15)     // Catch: java.lang.Throwable -> L29
            r12.append(r9)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = " code:"
            r12.append(r9)     // Catch: java.lang.Throwable -> L29
            r12.append(r2)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = r12.toString()     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.xj.kd r12 = r8.kd     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.f.hf.w.w.w(r10, r9, r12)     // Catch: java.lang.Throwable -> L29
        Lb7:
            com.bytedance.sdk.component.f.hf.hf.hf r9 = r8.y     // Catch: java.lang.Throwable -> L29
            r10 = 2
            r9.xj(r10)     // Catch: java.lang.Throwable -> L29
            r8.xj(r1, r3, r0)     // Catch: java.lang.Throwable -> L29
        Lc0:
            if (r14 != r11) goto Lc5
            r13.notify()     // Catch: java.lang.Throwable -> L29
        Lc5:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            return
        Lc7:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            return
        Lc9:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.hf.w.y.xj(int, java.util.List, long, java.lang.Object, int, com.bytedance.sdk.component.f.hf.hf.w.hf):void");
    }

    private void xj(Handler handler, List<com.bytedance.sdk.component.f.xj.hf> list, w wVar) {
        boolean u = wVar.u();
        boolean hf = com.bytedance.sdk.component.f.hf.w.xj.hf(list, this.kd);
        if (u && hf) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.xj.set(0);
            this.u = 0L;
            com.bytedance.sdk.component.f.hf.w.w.w("_flush", "send reset busy", this.kd);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.u(), 1, this.kd);
            wVar.xj(72, "handle_result");
        }
    }

    public void xj(int i, long j, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", "mHandler == null", this.kd);
            return;
        }
        if (i != 3) {
            com.bytedance.sdk.component.f.hf.w.w.w("_error", "sendBusyMsg error state", this.kd);
            return;
        }
        if (handler.hasMessages(i)) {
            handler.removeMessages(i);
        }
        long j2 = (((r1 - 1) % 4) + 1) * j;
        StringBuilder B7CMnp2 = A2egSU.B7CMnp(i, this.xj.incrementAndGet(), "sendBusyMsg:", "  retryCount:", " delayTime:");
        B7CMnp2.append(j2 / 1000);
        com.bytedance.sdk.component.f.hf.w.w.w("_error", B7CMnp2.toString(), this.kd);
        handler.sendEmptyMessageDelayed(i, j2);
    }
}
