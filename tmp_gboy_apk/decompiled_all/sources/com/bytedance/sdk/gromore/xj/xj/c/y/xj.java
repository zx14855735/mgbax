package com.bytedance.sdk.gromore.xj.xj.c.y;

import IzHBwY.AYUAbz;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.d.u;
import com.bytedance.msdk.w.u.g;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.c;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.sdk.openadsdk.zg.w.hf.hf {
    private com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj hf;
    private u kd = new u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.y.xj.2
        @Override // com.bytedance.msdk.api.u.xj.d.u
        public Activity getActivity() {
            return null;
        }

        @Override // com.bytedance.msdk.api.u.xj.d.u
        public void hf() {
            if (xj.this.w != null) {
                xj.this.w.hf();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.d.u
        public void w() {
            if (xj.this.w != null) {
                xj.this.w.xj();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.d.u
        public void xj() {
            if (xj.this.w != null) {
                xj.this.w.xj(xj.this);
            }
        }
    };
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj u;
    private com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf w;
    private g xj;

    public xj(g gVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar) {
        this.xj = gVar;
        this.u = xjVar;
        f();
    }

    private void f() {
        this.xj.xj(new com.bytedance.msdk.api.u.xj.d.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.y.xj.1
            @Override // com.bytedance.msdk.api.u.xj.d.hf
            public void hf(int i) {
                if (xj.this.hf != null) {
                    xj.this.hf.xj(xj.this, i);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.d.hf
            public void kd() {
                if (xj.this.hf != null) {
                    xj.this.hf.xj(xj.this);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.d.hf
            public void u() {
                if (xj.this.hf != null) {
                    xj.this.hf.hf(xj.this);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.d.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xj.this.u == null || xjVar == null) {
                    return;
                }
                xj.this.u.xj(xj.this, new com.bytedance.sdk.gromore.xj.xj.xj(xjVar.xj, xjVar.hf));
            }

            @Override // com.bytedance.msdk.api.u.xj.d.hf
            public void xj(int i) {
                if (xj.this.hf != null) {
                    xj.this.hf.xj(xj.this, i);
                }
            }
        });
        this.xj.xj(this.kd);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public c c() {
        return new com.bytedance.sdk.gromore.xj.xj.y.xj(new hf(this.xj));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public Map<String, Object> kd() {
        g gVar = this.xj;
        if (gVar != null) {
            return gVar.yo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public int u() {
        g gVar = this.xj;
        if (gVar != null) {
            return gVar.e();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void y() {
        g gVar = this.xj;
        if (gVar != null) {
            gVar.dk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public View w() {
        g gVar = this.xj;
        if (gVar != null) {
            return gVar.y();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public View hf() {
        g gVar = this.xj;
        if (gVar != null) {
            return gVar.ht();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public PluginValueSet xj() {
        AYUAbz A5SV6n2 = AYUAbz.A5SV6n(super.xj());
        A5SV6n2.AMqCpz(1, com.bytedance.sdk.gromore.init.xj.xj());
        return A5SV6n2.A2egSU();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        g gVar = this.xj;
        if (gVar != null) {
            gVar.xj(new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.y.xj.3
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

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf hfVar) {
        this.w = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(ViewGroup viewGroup) {
        g gVar = this.xj;
        if (gVar == null || viewGroup == null) {
            return;
        }
        gVar.xj(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(ViewGroup viewGroup, Activity activity) {
        g gVar = this.xj;
        if (gVar == null || viewGroup == null || activity == null) {
            return;
        }
        gVar.xj(viewGroup, activity);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        g gVar = this.xj;
        if (gVar != null) {
            gVar.xj(hfVar);
        }
    }
}
