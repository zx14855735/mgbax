package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {

    public static class xj extends com.bytedance.msdk.hf.w {
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf d;
        private am p;
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.w tf;

        public xj(am amVar, boolean z) {
            Map<String, Object> f;
            Function function = null;
            this.d = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.u.xj.1
                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void hf(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).y != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).y.xj();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).y != null) {
                        ((com.bytedance.msdk.hf.w) xj.this).y.xj(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, String str, int i) {
                    if (((com.bytedance.msdk.hf.w) xj.this).y instanceof com.bytedance.msdk.api.u.xj.w.u) {
                        ((com.bytedance.msdk.api.u.xj.w.u) ((com.bytedance.msdk.hf.w) xj.this).y).xj(view, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, float f2, float f3) {
                    if (((com.bytedance.msdk.hf.w) xj.this).y instanceof com.bytedance.msdk.api.u.xj.w.u) {
                        ((com.bytedance.msdk.api.u.xj.w.u) ((com.bytedance.msdk.hf.w) xj.this).y).xj(f2, f3);
                    }
                }
            };
            this.tf = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.w(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.u.xj.2
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
            this.p = amVar;
            p(amVar.hf());
            pl(this.p.w());
            c(true);
            if (z && (f = amVar.f()) != null) {
                double xj = com.bytedance.msdk.xj.w.hf.xj(f.get("price"));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：".concat(String.valueOf(xj)));
                xj(xj <= 0.0d ? 0.0d : xj);
            }
            this.p.xj(this.d);
            this.p.xj(this.tf);
            xj(MediationConstant.EXTRA_ADID, Long.valueOf(m()));
            xj(MediationConstant.EXTRA_CID, Long.valueOf(db()));
            Map<String, Object> f2 = this.p.f();
            if (f2 != null) {
                u(f2);
                xj("log_extra", f2.toString());
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.p.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            am amVar = this.p;
            if (amVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(amVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            am amVar = this.p;
            return amVar != null ? com.bytedance.msdk.xj.w.hf.w(amVar.f()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean jk() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            am amVar = this.p;
            if (amVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(amVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> f;
            am amVar = this.p;
            if (amVar == null || (f = amVar.f()) == null) {
                return null;
            }
            w(f);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            am amVar = this.p;
            return amVar != null ? amVar.y() : super.uj();
        }

        @Override // com.bytedance.msdk.hf.w
        public View d() {
            am amVar = this.p;
            if (amVar != null) {
                return amVar.xj();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.p == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public void p() {
            am amVar = this.p;
            if (amVar != null) {
                amVar.u();
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void tf(boolean z) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            am amVar = this.p;
            if (amVar != null) {
                amVar.xj(z);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.p.xj(activity, xjVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            am amVar = this.p;
            if (amVar != null) {
                amVar.kd();
                this.p = null;
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.p.xj(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            am amVar = this.p;
            if (amVar != null) {
                return amVar.xj(activity);
            }
            return super.xj(activity);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(wVar)));
            am amVar = this.p;
            if (amVar != null) {
                amVar.xj(wVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hfVar)));
            am amVar = this.p;
            if (amVar != null) {
                amVar.xj(hfVar);
            }
        }
    }

    public void xj(final boolean z, z zVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.msdk.w.w.hf.xj.hf hfVar2) {
        if (zVar == null || hfVar2 == null) {
            return;
        }
        zVar.hf(hfVar, new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.u.1
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
                        arrayList.add(new xj(amVar, z));
                    }
                }
                hfVar2.xj(arrayList);
            }
        });
    }
}
