package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private boolean xj;

    public class xj extends com.bytedance.msdk.hf.w {
        am d;
        private volatile boolean g = false;
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.w p;
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf tf;

        public xj(am amVar) {
            Map<String, Object> f;
            Function function = null;
            this.tf = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.d.xj.2
                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void hf(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).xj != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).xj.xj();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).xj != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).xj.xj(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, String str, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).xj instanceof com.bytedance.msdk.api.u.xj.c.y) {
                        ((com.bytedance.msdk.api.u.xj.c.y) ((com.bytedance.msdk.hf.w) xj.this).xj).xj(view, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, float f2, float f3) {
                    if (((com.bytedance.msdk.hf.w) xj.this).xj instanceof com.bytedance.msdk.api.u.xj.c.y) {
                        ((com.bytedance.msdk.api.u.xj.c.y) ((com.bytedance.msdk.hf.w) xj.this).xj).xj(f2, f3);
                    }
                }
            };
            this.p = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.w(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.d.xj.3
                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void hf() {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.hf();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void kd() {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.kd();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void u() {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.u();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void w() {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.w();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void xj() {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.xj();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void xj(int i, int i2) {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.xj(new com.bytedance.msdk.api.xj(i, "MediaPlayer inter error code:".concat(String.valueOf(i2))));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.w
                public void xj(long j, long j2) {
                    if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).hf.xj(j, j2);
                    }
                }
            };
            this.d = amVar;
            p(amVar.hf());
            pl(this.d.w());
            c(true);
            if (d.this.xj && (f = amVar.f()) != null) {
                double xj = com.bytedance.msdk.xj.w.hf.xj(f.get("price"));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "pangle 模板native 返回的 cpm价格：".concat(String.valueOf(xj)));
                xj(xj <= 0.0d ? 0.0d : xj);
            }
            xj(MediationConstant.EXTRA_ADID, Long.valueOf(m()));
            xj(MediationConstant.EXTRA_CID, Long.valueOf(db()));
            Map<String, Object> f2 = this.d.f();
            if (f2 != null) {
                u(f2);
                xj("log_extra", f2.toString());
            }
            this.d.xj(this.tf);
            this.d.xj(this.p);
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.d.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            am amVar = this.d;
            if (amVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(amVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            am amVar = this.d;
            if (amVar != null) {
                return com.bytedance.msdk.xj.w.hf.w(amVar.f());
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean jk() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            am amVar = this.d;
            if (amVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(amVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> f;
            am amVar = this.d;
            if (amVar == null || (f = amVar.f()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", f.get("coupon"));
            hashMap.put("live_room", f.get("live_room"));
            hashMap.put("product", f.get("product"));
            w(hashMap);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            am amVar = this.d;
            return amVar != null ? amVar.y() : super.uj();
        }

        @Override // com.bytedance.msdk.hf.w
        public View d() {
            am amVar = this.d;
            if (amVar != null) {
                return amVar.xj();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.g;
        }

        @Override // com.bytedance.msdk.hf.w
        public void p() {
            am amVar = this.d;
            if (amVar != null) {
                amVar.u();
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.d.xj(activity, xjVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            this.g = true;
            com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.d.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    am amVar = xj.this.d;
                    if (amVar != null) {
                        amVar.kd();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.d.xj(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            am amVar = this.d;
            if (amVar != null) {
                return amVar.xj(activity);
            }
            return super.xj(activity);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(hfVar);
            }
        }
    }

    public void xj(boolean z, z zVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.msdk.w.w.hf.xj.hf hfVar2) {
        if (zVar == null || hfVar2 == null) {
            return;
        }
        this.xj = z;
        zVar.xj(hfVar, new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.d.1
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
            public void xj(int i, String str) {
                hfVar2.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
            public void xj(List<am> list) {
                if (list == null || list.size() == 0) {
                    hfVar2.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (am amVar : list) {
                    if (amVar != null) {
                        arrayList.add(d.this.new xj(amVar));
                    }
                }
                hfVar2.xj(arrayList);
            }
        });
    }
}
