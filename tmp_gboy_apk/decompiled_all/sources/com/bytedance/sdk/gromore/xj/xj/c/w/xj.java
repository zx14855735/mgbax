package com.bytedance.sdk.gromore.xj.xj.c.w;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.zg.w.hf.p;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends p {
    private com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj hf;
    private com.bytedance.msdk.w.u.f xj;

    public xj(com.bytedance.msdk.w.u.f fVar) {
        this.xj = fVar;
        y();
    }

    private void y() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar == null) {
            return;
        }
        fVar.xj(new com.bytedance.msdk.api.u.xj.u.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.w.xj.1
            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void g_() {
                if (xj.this.hf != null) {
                    xj.this.hf.xj();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void h_() {
                if (xj.this.hf != null) {
                    xj.this.hf.hf();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void kd() {
                if (xj.this.hf instanceof com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf) {
                    ((com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf) xj.this.hf).y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void u() {
                if (xj.this.hf != null) {
                    xj.this.hf.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void w() {
                if (xj.this.hf != null) {
                    xj.this.hf.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || !(xj.this.hf instanceof com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf) xj.this.hf).xj(xjVar.xj, xjVar.hf);
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void y() {
                if (xj.this.hf != null) {
                    xj.this.hf.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                if (xj.this.hf instanceof com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf) {
                    ((com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.hf) xj.this.hf).xj(u.xj(xjVar));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.u kd() {
        return new f(new hf(this.xj));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public long u() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public Map<String, Object> hf() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            return fVar.yo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            fVar.xj(new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.w.xj.2
                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf() {
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj() {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj();
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.w(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, int i, int i2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.hf(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public int xj() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            return fVar.e();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(Activity activity) {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            fVar.xj(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(Activity activity, Object obj, String str) {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            fVar.hf(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            fVar.xj(hfVar);
        }
    }
}
