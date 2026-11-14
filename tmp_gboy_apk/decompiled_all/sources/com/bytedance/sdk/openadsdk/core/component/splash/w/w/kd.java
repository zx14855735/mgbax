package com.bytedance.sdk.openadsdk.core.component.splash.w.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.ra.tj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private c c;
    private com.bytedance.sdk.openadsdk.core.component.splash.xj.xj d;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y f;
    volatile boolean hf;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.kd kd;
    private com.bytedance.sdk.openadsdk.core.component.splash.hf tf;
    volatile boolean u;
    volatile boolean w;
    volatile boolean xj;
    private hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c> y;

    public kd(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.kd kdVar, hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c> hfVar, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar, com.bytedance.sdk.openadsdk.core.component.splash.hf hfVar2) {
        if (kdVar == null || hfVar == null) {
            return;
        }
        this.kd = kdVar;
        this.y = hfVar;
        this.d = xjVar;
        this.tf = hfVar2;
    }

    public void xj(final int i) {
        if (this.kd == null || this.y == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.w().xj(this.kd, this.y);
            return;
        }
        if (i == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj(this.d).xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    kd.this.y.hf(yVar);
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj(i) || kd.this.d == null || kd.this.kd == null) {
                        return;
                    }
                    kd.this.d.hf(kd.this.kd.u(), kd.this.kd.kd());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    if (cVar != null && kd.this.kd != null) {
                        kd.this.kd.xj(cVar.u());
                        kd.this.kd.xj(cVar.w());
                    }
                    if (kd.this.tf == null || !kd.this.tf.hf()) {
                        new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.w().xj(kd.this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                                if (!kd.this.u) {
                                    kd.this.y.hf(yVar);
                                } else {
                                    if (kd.this.d == null || kd.this.kd == null) {
                                        return;
                                    }
                                    kd.this.d.xj(yVar, kd.this.kd.u(), true, 1);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                            public void xj(c cVar2) {
                                kd.this.y.xj(cVar2);
                                if (!com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj(i) || kd.this.d == null || kd.this.kd == null) {
                                    return;
                                }
                                kd.this.d.hf(kd.this.kd.u(), kd.this.kd.kd());
                            }
                        });
                    } else {
                        kd.this.y.xj(cVar);
                    }
                }
            });
            return;
        }
        if (i == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.w().xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    kd.this.f = yVar;
                    if (kd.this.c != null && yVar != null) {
                        yVar.xj(kd.this.c.u());
                        yVar.xj(kd.this.c.w());
                    }
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时物料加载成功 isCache " + yVar.kd());
                    kd.this.y.hf(yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时物料加载失败 ");
                    kd.this.y.xj(cVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj(this.d).xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存物料加载成功 isCache " + yVar.kd());
                    kd.this.y.hf(yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    kd.this.c = cVar;
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存物料加载失败  ");
                    if (kd.this.f != null && cVar != null) {
                        kd.this.f.xj(cVar.u());
                        kd.this.f.xj(cVar.w());
                    }
                    kd.this.y.xj(cVar);
                }
            });
        } else if (i == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.w().xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    kd.this.f = yVar;
                    if (kd.this.w || kd.this.u) {
                        if (kd.this.d == null || kd.this.kd == null) {
                            return;
                        }
                        kd.this.d.xj(yVar, kd.this.kd.u(), true, 3);
                        return;
                    }
                    if (kd.this.c != null && yVar != null) {
                        yVar.xj(kd.this.c.u());
                        yVar.xj(kd.this.c.w());
                    }
                    kd.this.w = true;
                    kd.this.y.hf(yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    kd.this.xj = true;
                    if (kd.this.hf) {
                        kd.this.y.xj(cVar);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj(i) || kd.this.d == null || kd.this.kd == null) {
                        return;
                    }
                    kd.this.d.hf(kd.this.kd.u(), kd.this.kd.kd());
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj(this.d).xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    if (kd.this.w) {
                        return;
                    }
                    kd.this.w = true;
                    kd.this.y.hf(yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    kd.this.c = cVar;
                    if (kd.this.f != null && cVar != null) {
                        kd.this.f.xj(cVar.u());
                        kd.this.f.xj(cVar.w());
                    }
                    kd.this.hf = true;
                    if (kd.this.xj) {
                        kd.this.y.xj(cVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj(this.d).xj(this.kd, new hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                    kd.this.y.hf(yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
                public void xj(c cVar) {
                    kd.this.y.xj(cVar);
                }
            });
        }
    }

    public void xj() {
        this.u = true;
    }

    public static boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar) {
        return (hfVar == null || tjVar == null || TextUtils.isEmpty(hfVar.pz()) || tjVar.u > 0) ? false : true;
    }
}
