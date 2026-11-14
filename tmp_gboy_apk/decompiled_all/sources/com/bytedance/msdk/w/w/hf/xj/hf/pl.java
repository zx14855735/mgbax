package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends hf {
    private int hf;

    public class xj extends com.bytedance.msdk.hf.w {
        private com.bytedance.msdk.api.xj.hf am;
        private com.bytedance.msdk.w.w.hf.xj.hf g;
        private Map<String, Object> p;

        /* renamed from: pl, reason: collision with root package name */
        private com.bytedance.msdk.w.y.hf.hf f10159pl;
        private com.bytedance.sdk.openadsdk.zg.w.hf.hf tf;

        public xj(Map<String, Object> map) {
            this.p = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.xj.hf.kd mq() {
            return (com.bytedance.msdk.xj.hf.kd) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(hfVar.kd());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            return hfVar != null ? com.bytedance.msdk.xj.w.hf.w(hfVar.kd()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(hfVar.kd());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> kd;
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null && (kd = hfVar.kd()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("coupon", kd.get("coupon"));
                hashMap.put("live_room", kd.get("live_room"));
                hashMap.put("product", kd.get("product"));
                w(hashMap);
            }
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public void wx() {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleSplashLoader hideSkipButton   WaterfallPangleSplashLoader  mCSJSplashAd:" + this.tf);
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null) {
                hfVar.y();
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.tf == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null) {
                hfVar.xj((com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj) null);
                this.tf.xj((com.bytedance.sdk.openadsdk.zg.w.xj.w) null);
                this.tf.xj((com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf) null);
                this.tf = null;
            }
        }

        public void xj(Context context, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, com.bytedance.msdk.w.w.hf.xj.hf hfVar3) {
            this.f10159pl = hfVar2;
            this.g = hfVar3;
            this.am = hfVar;
            z xj = pl.this.xj(context);
            if (xj == null) {
                return;
            }
            Map<String, Object> map = this.p;
            if (map == null) {
                pl.this.hf = 3000;
            } else {
                pl.this.hf = map.get("ad_load_timeout") != null ? ((Integer) this.p.get("ad_load_timeout")).intValue() : 3000;
            }
            hf.xj xj2 = com.bytedance.msdk.xj.w.hf.xj(this.am, this.f10159pl, false);
            xj2.xj(this.am.et()).hf(this.am.io()).xj(this.am.am()).hf(this.am.qt());
            xj(xj, xj2.xj());
        }

        private void xj(z zVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
            com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar = new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.pl.xj.1
                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
                public void hf(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar2) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashRenderSuccess");
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
                public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar2) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashLoadSuccess 111");
                    if (hfVar2 == null) {
                        xj.this.g.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "渲染成功但广告是空"));
                        return;
                    }
                    xj.this.tf = hfVar2;
                    xj.this.c(true);
                    xj xjVar2 = xj.this;
                    xjVar2.pl(xjVar2.tf.u());
                    Map<String, Object> kd = xj.this.tf.kd();
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleSplashLoader WaterfallPangleSplashLoader extraInfo :".concat(String.valueOf(kd)));
                    if (kd != null) {
                        xj.this.u(kd);
                    }
                    if (xj.this.f10159pl.xj() && kd != null) {
                        double xj = com.bytedance.msdk.xj.w.hf.xj(kd.get("price"));
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", com.bytedance.msdk.xj.kd.kd.hf(xj.this.f10159pl.hf(), xj.this.f10159pl.pl()) + "pangle Splash 返回的 cpm价格：" + xj);
                        xj xjVar3 = xj.this;
                        if (xj <= 0.0d) {
                            xj = 0.0d;
                        }
                        xjVar3.xj(xj);
                    }
                    Function function = null;
                    xj.this.tf.xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.pl.xj.1.1
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
                    xj.this.tf.xj(new com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.pl.xj.1.2
                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj
                        public void hf(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar3) {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashAdClick");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq().u();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj
                        public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar3) {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashAdShow");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq().kd();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj
                        public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar3, int i) {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashAdClose closeType = ".concat(String.valueOf(i)));
                            if (i == 1 || i == 3) {
                                if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                    xj.this.mq().xj(i);
                                }
                            } else if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq().hf(i);
                            }
                        }
                    });
                    xj.this.tf.xj(new com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.pl.xj.1.3
                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf
                        public void hf() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashCardClose");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq().l_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf
                        public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar3) {
                            if (hfVar3 != null) {
                                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + hfVar3.w());
                            }
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq();
                            }
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                xj.this.mq().k_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf
                        public void xj() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashCardClick");
                            try {
                                if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.xj.hf.kd) {
                                    xj.this.mq().w();
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.pl.xj(th);
                            }
                        }
                    });
                    xj.this.g.xj(xj.this);
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
                public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.xj xjVar2) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashLoadFail");
                    if (xjVar2 != null) {
                        xj.this.g.xj(new com.bytedance.msdk.api.xj(xjVar2.xj(), xjVar2.hf()));
                    } else {
                        xj.this.g.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
                public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar2, com.bytedance.sdk.openadsdk.zg.w.hf.xj xjVar2) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "new api onSplashRenderFail");
                    if (xjVar2 != null) {
                        xj.this.g.xj(new com.bytedance.msdk.api.xj(xjVar2.xj(), xjVar2.hf()));
                    } else {
                        xj.this.g.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }
            };
            if (zVar != null) {
                zVar.xj(hfVar, xjVar, pl.this.hf);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(ViewGroup viewGroup) {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar == null || viewGroup == null) {
                return;
            }
            hfVar.xj(viewGroup);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(ViewGroup viewGroup, Activity activity) {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar = this.tf;
            if (hfVar != null) {
                hfVar.xj(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar2 = this.tf;
            if (hfVar2 != null) {
                hfVar2.xj(hfVar);
            }
        }
    }

    public pl(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
        this.hf = 3000;
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        if (hfVar2 == null) {
            xj(new com.bytedance.msdk.api.xj("load ad fail adSlot is null"));
        } else {
            new xj(map).xj(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.hf.getContext(), hfVar2, hfVar, this);
        }
    }
}
