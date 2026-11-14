package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends hf {

    public class xj extends com.bytedance.msdk.hf.w {
        private com.bytedance.msdk.w.y.hf.hf am;
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u d = new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.y.xj.1
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
            public void hf(com.bytedance.sdk.openadsdk.zg.w.hf.p pVar) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "pangle full cached 2");
                xj.this.f10164pl = true;
                xj.this.qt.xj(xj.this, (com.bytedance.msdk.api.xj) null);
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
            public void xj(int i, String str) {
                xj.this.f10164pl = false;
                xj.this.qt.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
            public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.p pVar) {
                if (pVar == null) {
                    xj.this.qt.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用"));
                    return;
                }
                xj.this.p = pVar;
                xj.this.c(true);
                xj xjVar = xj.this;
                xjVar.pl(xjVar.p.xj());
                Map<String, Object> hf = xj.this.p.hf();
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(hf)));
                if (xj.this.am.xj() && hf != null) {
                    double xj = com.bytedance.msdk.xj.w.hf.xj(hf.get("price"));
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", com.bytedance.msdk.xj.kd.kd.hf(xj.this.am.hf(), xj.this.am.pl()) + "pangle 全屏 返回的 cpm价格：" + xj);
                    xj xjVar2 = xj.this;
                    if (xj <= 0.0d) {
                        xj = 0.0d;
                    }
                    xjVar2.xj(xj);
                }
                if (hf != null) {
                    xj.this.u(hf);
                    Object obj = hf.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        xj.this.g = ((Boolean) obj).booleanValue();
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "pangle 全屏 返回的adnPreload：" + xj.this.g);
                    }
                }
                Function function = null;
                xj.this.p.xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.y.xj.1.1
                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void hf(long j, long j2, String str, String str2) {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, j2, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void w(long j, long j2, String str, String str2) {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.hf(j, j2, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void xj() {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void xj(long j, long j2, String str, String str2) {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void xj(long j, String str, String str2) {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
                    public void xj(String str, String str2) {
                        if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                            ((com.bytedance.msdk.hf.w) xj.this).w.xj(str, str2);
                        }
                    }
                });
                xj.this.p.xj(new com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.y.xj.1.2
                    @Override // com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj
                    public void hf() {
                        if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.hf) {
                            xj.this.mq().h_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj
                    public void kd() {
                        if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.hf) {
                            xj.this.mq().y();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj
                    public void u() {
                        if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.hf) {
                            xj.this.mq().u();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj
                    public void w() {
                        if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.hf) {
                            xj.this.mq().w();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj
                    public void xj() {
                        if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.hf) {
                            xj.this.mq().g_();
                        }
                    }
                });
                xj.this.f10164pl = true;
                xj.this.qt.xj(xj.this);
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
            public void xj() {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "pangle full cached");
            }
        };
        private boolean g;
        private com.bytedance.sdk.openadsdk.zg.w.hf.p p;

        /* renamed from: pl, reason: collision with root package name */
        private boolean f10164pl;
        private com.bytedance.msdk.w.w.hf.xj.hf qt;
        private com.bytedance.msdk.api.xj.hf zg;

        public xj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.xj.hf.hf mq() {
            return (com.bytedance.msdk.xj.hf.hf) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(pVar.hf());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean eu() {
            return this.g;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean ew() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            return pVar != null ? com.bytedance.msdk.xj.w.hf.w(pVar.hf()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(pVar.hf());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> hf;
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar == null || (hf = pVar.hf()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", hf.get("coupon"));
            hashMap.put("live_room", hf.get("live_room"));
            hashMap.put("product", hf.get("product"));
            w(hashMap);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.p == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public Integer y() {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            return (pVar == null || pVar.u() <= System.currentTimeMillis()) ? 3 : 2;
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar != null) {
                pVar.xj((com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj) null);
                this.p.xj((com.bytedance.sdk.openadsdk.zg.w.xj.w) null);
                this.p.xj((com.bytedance.sdk.openadsdk.zg.w.xj.hf) null);
                this.p = null;
            }
        }

        public void xj(Context context, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, com.bytedance.msdk.w.w.hf.xj.hf hfVar3) {
            this.am = hfVar2;
            this.qt = hfVar3;
            this.zg = hfVar;
            z xj = y.this.xj(context);
            if (xj == null) {
                return;
            }
            hf.xj xj2 = com.bytedance.msdk.xj.w.hf.xj(this.zg, this.am, false);
            xj2.xj(1080).hf(1920).u(this.zg.l());
            xj.xj(xj2.xj(), this.d);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, Object obj, String str) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.p + "  activity:" + activity);
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar != null) {
                if (obj != null) {
                    pVar.xj(activity, obj, str);
                } else {
                    pVar.xj(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.sdk.openadsdk.zg.w.hf.p pVar = this.p;
            if (pVar != null) {
                pVar.xj(hfVar);
            }
        }
    }

    public y(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        if (hfVar2 == null) {
            xj(new com.bytedance.msdk.api.xj("load ad fail adSlot is null"));
        } else {
            new xj().xj(context.getApplicationContext(), hfVar2, hfVar, this);
        }
    }
}
