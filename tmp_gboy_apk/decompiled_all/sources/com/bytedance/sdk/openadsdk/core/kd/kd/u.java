package com.bytedance.sdk.openadsdk.core.kd.kd;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.kd.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u<T> extends hf {
    private final long u;

    public interface xj {
        void xj(boolean z);
    }

    public u(int i) {
        super(i);
        this.u = System.currentTimeMillis();
    }

    private void c(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, kd<T> kdVar, tj tjVar) {
        double d;
        f.w tf = this.xj.tf();
        kd.xj xj2 = com.bytedance.sdk.openadsdk.core.kd.kd.xj(hfVar.u(), tf);
        if (tf.hf() > 0) {
            hfVar.u();
            try {
                d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("DeviceRate", "bytebench_value"));
            } catch (Exception unused) {
                d = 0.0d;
            }
            if (d > 0.0d && d < tf.hf()) {
                hfVar.u();
                xj(hfVar, (kd) kdVar, tjVar, true, 0L, "device_score", String.valueOf(d));
                return;
            }
        }
        if (tf.w() > 0) {
            hfVar.u();
            int w = am.w(pz.getContext());
            if (w == 2 ? (tf.w() & 1) != 0 : !(w == 3 ? (2 & tf.w()) == 0 : w == 4 ? (tf.w() & 16) == 0 : w == 5 ? (4 & tf.w()) == 0 : w != 6 || (tf.w() & 8) == 0)) {
                hfVar.u();
                xj(hfVar, (kd) kdVar, tjVar, true, 0L, "net_type", String.valueOf(w));
                return;
            }
        }
        if (tf.u() > 0) {
            hfVar.u();
            xj2.xj(tf);
            int xj3 = xj2.xj(tf.u(), tf);
            if (xj3 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - (xj3 * 60000);
                hfVar.u();
                xj(hfVar, (kd) kdVar, tjVar, true, currentTimeMillis, "good_cache", String.valueOf(xj3));
                return;
            } else if (xj3 == 0) {
                hfVar.u();
                xj(hfVar, (kd) kdVar, tjVar, true, 0L, "behavior_score", String.valueOf(xj3));
                return;
            }
        }
        hfVar.u();
        xj(hfVar, (kd) kdVar, tjVar, false, 0L, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, kd<T> kdVar) {
        if (hfVar == null) {
            return;
        }
        if (i == -1) {
            i = hf();
        }
        hfVar.u();
        if (i == 1) {
            xj(hfVar, kdVar, tjVar);
            return;
        }
        if (i == 2) {
            hf(hfVar, kdVar, tjVar);
            return;
        }
        if (i == 3) {
            w(hfVar, kdVar, tjVar);
            return;
        }
        if (i == 4) {
            kd(hfVar, kdVar, tjVar);
        } else if (i != 5) {
            u(hfVar, kdVar, tjVar);
        } else {
            c(hfVar, kdVar, tjVar);
        }
    }

    private void kd(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final kd<T> kdVar, tj tjVar) {
        xj(hfVar, kdVar, tjVar.y == 2, (com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf) null, 0L, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.10
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
            public void xj(boolean z) {
                if (z) {
                    return;
                }
                kdVar.xj(-3, "no cache");
            }
        });
    }

    private void u(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, kd<T> kdVar, tj tjVar) {
        xj(hfVar, kdVar, tjVar, (com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf) null);
    }

    private void w(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, kd<T> kdVar, tj tjVar) {
        final com.bytedance.sdk.openadsdk.core.kd.kd.xj.w wVar = new com.bytedance.sdk.openadsdk.core.kd.kd.xj.w(this.xj);
        xj(hfVar, kdVar, tjVar, wVar);
        xj(hfVar, kdVar, tjVar.y == 2, wVar, 0L, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.9
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
            public void xj(boolean z) {
                if (z) {
                    return;
                }
                wVar.xj(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, kd<T> kdVar, tj tjVar) {
        long j;
        final f.w tf = this.xj.tf();
        final kd.xj xj2 = com.bytedance.sdk.openadsdk.core.kd.kd.xj(hfVar.u(), tf);
        final com.bytedance.sdk.openadsdk.core.kd.kd.xj.u uVar = new com.bytedance.sdk.openadsdk.core.kd.kd.xj.u(this.xj);
        uVar.xj();
        xj(hfVar, kdVar, tjVar, uVar);
        hfVar.u();
        final int xj3 = xj2.xj(tf.kd(), tf);
        if (xj3 < 0) {
            hfVar.u();
            uVar.xj(false);
            return;
        }
        if (xj3 > 0) {
            j = System.currentTimeMillis() - (xj3 * 60000);
            hfVar.u();
        } else {
            j = 0;
        }
        xj(hfVar, kdVar, tjVar.y == 2, uVar, j, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.11
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
            public void xj(boolean z) {
                hfVar.u();
                uVar.xj(z);
                if (z) {
                    kd.xj xjVar = xj2;
                    int i = u.this.hf;
                    com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2 = hfVar;
                    f.w wVar = tf;
                    StringBuilder sb = new StringBuilder();
                    sb.append(xj3);
                    xjVar.xj(i, hfVar2, wVar, "backup_cache", sb.toString());
                }
            }
        });
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, final kd<T> kdVar) {
        com.bytedance.sdk.openadsdk.x.c.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.hf(hfVar, tjVar, i, new y(kdVar));
            }
        });
    }

    private void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final kd<T> kdVar, final tj tjVar) {
        final com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj(this.xj) { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.6
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj
            public void xj() {
                u.this.xj(hfVar, kdVar, tjVar, this);
            }
        };
        xj(hfVar, kdVar, tjVar.y == 2, xjVar, 0L, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.7
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
            public void xj(boolean z) {
                if (z) {
                    return;
                }
                xjVar.xj(false);
            }
        });
    }

    private void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, kd<T> kdVar, tj tjVar) {
        final com.bytedance.sdk.openadsdk.core.kd.kd.xj.u uVar = new com.bytedance.sdk.openadsdk.core.kd.kd.xj.u(this.xj);
        uVar.xj();
        xj(hfVar, kdVar, tjVar, uVar);
        xj(hfVar, kdVar, tjVar.y == 2, uVar, 0L, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.8
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
            public void xj(boolean z) {
                uVar.xj(true);
            }
        });
    }

    private void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final kd<T> kdVar, final tj tjVar, boolean z, long j, final String str, final String str2) {
        final f.w tf = this.xj.tf();
        final kd.xj xj2 = com.bytedance.sdk.openadsdk.core.kd.kd.xj(hfVar.u(), tf);
        if (z) {
            hfVar.u();
            final com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj(this.xj) { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.12
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj
                public void xj() {
                    hfVar.u();
                    u.this.y(hfVar, kdVar, tjVar);
                }
            };
            xj(hfVar, kdVar, tjVar.y == 2, xjVar, j, new xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.13
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.u.xj
                public void xj(boolean z2) {
                    hfVar.u();
                    if (z2) {
                        xj2.xj(u.this.hf, hfVar, tf, str, str2);
                    } else {
                        xjVar.xj(false);
                    }
                }
            });
        } else {
            hfVar.u();
            y(hfVar, kdVar, tjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hf() {
        f.hf hfVar = this.xj;
        return (hfVar == null || hfVar.f() == -1) ? com.bytedance.sdk.openadsdk.core.kd.kd.xj.xj(this.hf) : this.xj.f();
    }

    private void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final kd<T> kdVar, final boolean z, final com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar2, long j, final xj xjVar) {
        List<ws> list;
        hfVar.u();
        if (!TextUtils.isEmpty(hfVar.pz())) {
            xjVar.xj(false);
            return;
        }
        if (xj(z) == null) {
            xjVar.xj(false);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int min = Math.min(f.xj(this.hf).p(), hfVar.pl());
        com.bytedance.sdk.openadsdk.core.kd.w.xj xjVar2 = this.w;
        if (xjVar2 != null) {
            xjVar2.hf(hfVar.u());
            list = this.w.xj(hfVar.u(), j, min);
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ws wsVar : list) {
                if (xj(wsVar)) {
                    arrayList.add(wsVar);
                }
            }
            if (arrayList.isEmpty()) {
                xjVar.xj(false);
                return;
            }
            if (!xj(z).xj(hfVar, arrayList)) {
                xjVar.xj(false);
                return;
            }
            hfVar.u();
            arrayList.size();
            com.bytedance.sdk.openadsdk.core.kd.hf.xj xjVar3 = new com.bytedance.sdk.openadsdk.core.kd.hf.xj(this.hf);
            xjVar3.xj(currentTimeMillis);
            xjVar3.hf(System.currentTimeMillis());
            xjVar3.xj(arrayList, new com.bytedance.sdk.openadsdk.core.kd.hf.kd() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.2
                @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                public void hf(List<ws> list2) {
                    hfVar.u();
                    list2.size();
                    if (list2.isEmpty()) {
                        xjVar.xj(false);
                    } else {
                        u.this.xj(list2, hfVar, z, hfVar2, kdVar, xjVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                public void w(List<ws> list2) {
                    Iterator<ws> it = list2.iterator();
                    while (it.hasNext()) {
                        u.this.w.xj(hfVar.u(), it.next());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                public void xj(List<ws> list2) {
                    u.this.xj(list2, hfVar, z, hfVar2, kdVar, xjVar);
                }
            });
            return;
        }
        xjVar.xj(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final kd<T> kdVar, final tj tjVar, final com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar2) {
        hfVar.u();
        pz.xj().xj(hfVar, tjVar, this.hf, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.3
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar3) {
                hfVar.u();
                if (u.this.xj(tjVar.y == 2) != null) {
                    u.this.xj(tjVar.y == 2).xj(hfVar, i, str, hfVar3);
                }
                com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar4 = hfVar2;
                if (hfVar4 != null) {
                    hfVar4.xj(kdVar, i, str);
                    return;
                }
                kd kdVar2 = kdVar;
                if (kdVar2 != null) {
                    kdVar2.xj(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, final com.bytedance.sdk.openadsdk.core.ra.hf hfVar3) {
                hfVar.u();
                com.bytedance.sdk.openadsdk.core.kd.xj.xj xj2 = u.this.xj(tjVar.y == 2);
                if (xj2 == null) {
                    return;
                }
                xj2.xj(u.this.hf, xjVar, hfVar3, tjVar, hfVar, kdVar, new c() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.3.1
                    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.c
                    public void xj(w wVar) {
                        if (wVar != null) {
                            com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar4 = hfVar2;
                            if (hfVar4 == null) {
                                wVar.xj();
                            } else {
                                hfVar4.xj(wVar);
                            }
                        }
                        com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar5 = hfVar2;
                        if (hfVar5 != null) {
                            hfVar5.w();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.c
                    public void xj(int i) {
                        kd kdVar2 = kdVar;
                        if (kdVar2 != null) {
                            kdVar2.xj(i, com.bytedance.sdk.openadsdk.core.c.xj(i));
                        }
                        hfVar3.xj(i);
                        com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar3);
                        com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar4 = hfVar2;
                        if (hfVar4 != null) {
                            hfVar4.w();
                        }
                    }
                });
            }
        });
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar) {
        if (hfVar == null) {
            return;
        }
        hfVar.u();
        if (com.bytedance.sdk.openadsdk.core.live.kd.u.xj(hfVar.ht())) {
            com.bytedance.sdk.openadsdk.x.c.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(hfVar.pz())) {
                        if (u.this.xj(tjVar.y == 2) != null) {
                            u.this.xj(tjVar.y == 2).xj(hfVar);
                        }
                    } else if (u.this.hf() != 0 && u.this.w.xj(hfVar.u())) {
                        hfVar.u();
                        u.this.xj(hfVar, (kd) null, tjVar, (com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final List<ws> list, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z, final com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar2, kd<T> kdVar, final xj xjVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean(PointParamKey.IS_CACHE, true);
        bundle.putLong("start_time", this.u);
        xj(z).xj(this.hf, list, hfVar, kdVar, bundle, new c() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.u.5
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.c
            public void xj(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.c
            public void xj(w wVar) {
                com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf hfVar3 = hfVar2;
                if (hfVar3 != null) {
                    hfVar3.hf(wVar);
                    hfVar2.xj(true);
                    list.size();
                    hfVar.u();
                } else {
                    wVar.xj();
                    list.size();
                    hfVar.u();
                }
                xjVar.xj(true);
            }
        });
    }
}
