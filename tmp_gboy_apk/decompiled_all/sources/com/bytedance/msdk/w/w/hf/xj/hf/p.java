package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cn;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p extends hf {
    private com.bytedance.msdk.api.xj.hf hf;
    private com.bytedance.msdk.w.y.hf.hf w;

    public class xj extends com.bytedance.msdk.hf.w {
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c d = new AnonymousClass1(null);
        private Map<String, Object> g;
        private qt p;

        /* renamed from: pl, reason: collision with root package name */
        private boolean f10158pl;

        public xj(Map<String, Object> map) {
            this.g = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean jq() {
            return !cn.d.equals(p.this.xj(MediationConstant.ADN_PANGLE)) && "4.4.0.0".compareTo(p.this.xj(MediationConstant.ADN_PANGLE)) > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.u.xj.f.xj mq() {
            return (com.bytedance.msdk.api.u.xj.f.xj) this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.u.xj.f.xj zf() {
            return (com.bytedance.msdk.api.u.xj.f.xj) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            qt qtVar = this.p;
            if (qtVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(qtVar.hf());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean eu() {
            return this.f10158pl;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean ew() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            qt qtVar = this.p;
            return qtVar != null ? com.bytedance.msdk.xj.w.hf.w(qtVar.hf()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            qt qtVar = this.p;
            if (qtVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(qtVar.hf());
            }
            return 0L;
        }

        /* renamed from: com.bytedance.msdk.w.w.hf.xj.hf.p$xj$1, reason: invalid class name */
        public class AnonymousClass1 extends com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c {
            public AnonymousClass1(Function function) {
                super(function);
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
            public void hf(qt qtVar) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward_onRewardVideoCached 2");
                xj xjVar = xj.this;
                p.this.xj(xjVar, (com.bytedance.msdk.api.xj) null);
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
            public void xj(int i, String str) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward_onError code:" + i + "  message:" + str);
                p.this.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
            public void xj(qt qtVar) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward_onRewardVideoAdLoad");
                if (qtVar != null) {
                    xj.this.p = qtVar;
                    xj.this.c(true);
                    xj xjVar = xj.this;
                    xjVar.pl(xjVar.p.xj());
                    Map<String, Object> hf = xj.this.p.hf();
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(hf)));
                    if (p.this.w.xj() && hf != null) {
                        double xj = com.bytedance.msdk.xj.w.hf.xj(hf.get("price"));
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", com.bytedance.msdk.xj.kd.kd.hf(p.this.w.hf(), p.this.w.pl()) + "pangle reward 返回的 cpm价格：" + xj);
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
                            xj.this.f10158pl = ((Boolean) obj).booleanValue();
                            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "pangle 激励 返回的adnPreload：" + xj.this.f10158pl);
                        }
                    }
                    Function function = null;
                    xj.this.p.xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.1
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
                    xj.this.p.hf(new com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.2
                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void hf() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick---------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void kd() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onVideoError-----------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().kd();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void u() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onVideoComplete----------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().u();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void w() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdClose-----------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().w();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void xj() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdShow-----------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void y() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onSkippedVideo-------------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().y();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        @Deprecated
                        public void xj(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (xj.this.jq()) {
                                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                    xj.this.mq().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.2.1
                                        @Override // com.bytedance.msdk.api.w.xj
                                        public float hf() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (p.this.hf != null) {
                                                return p.this.hf.z();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public Map<String, Object> u() {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i2));
                                            hashMap.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return hashMap;
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public String w() {
                                            return !TextUtils.isEmpty(str) ? str : p.this.hf != null ? p.this.hf.q() : "";
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public boolean xj() {
                                            return z;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void xj(final boolean z, final int i, final Bundle bundle) {
                            if (xj.this.jq()) {
                                return;
                            }
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onRewardArrived-------------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.mq().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.2.2
                                    @Override // com.bytedance.msdk.api.w.xj
                                    public float hf() {
                                        float f = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (p.this.hf != null) {
                                            return p.this.hf.z();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public Map<String, Object> u() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        hashMap.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public String w() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : p.this.hf != null ? p.this.hf.q() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public boolean xj() {
                                        return z;
                                    }
                                });
                            }
                        }
                    });
                    xj.this.p.xj(new com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.3
                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void hf() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void kd() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onVideoError");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().kd();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void u() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onVideoComplete");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().u();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void w() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdClose");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().w();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void xj() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onAdShow");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void y() {
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onSkippedVideo");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().y();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        @Deprecated
                        public void xj(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (xj.this.jq()) {
                                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                    xj.this.zf().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.3.1
                                        @Override // com.bytedance.msdk.api.w.xj
                                        public float hf() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (p.this.hf != null) {
                                                return p.this.hf.z();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public Map<String, Object> u() {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i2));
                                            hashMap.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return hashMap;
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public String w() {
                                            return !TextUtils.isEmpty(str) ? str : p.this.hf != null ? p.this.hf.q() : "";
                                        }

                                        @Override // com.bytedance.msdk.api.w.xj
                                        public boolean xj() {
                                            return z;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj
                        public void xj(final boolean z, final int i, final Bundle bundle) {
                            if (xj.this.jq()) {
                                return;
                            }
                            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward:onRewardArrived-------------2");
                            if (((com.bytedance.msdk.hf.w) xj.this).c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                                xj.this.zf().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.1.3.2
                                    @Override // com.bytedance.msdk.api.w.xj
                                    public float hf() {
                                        float f = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (p.this.hf != null) {
                                            return p.this.hf.z();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public Map<String, Object> u() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        hashMap.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public String w() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : p.this.hf != null ? p.this.hf.q() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.w.xj
                                    public boolean xj() {
                                        return z;
                                    }
                                });
                            }
                        }
                    });
                    xj xjVar3 = xj.this;
                    p.this.xj(xjVar3);
                    return;
                }
                p.this.xj(new com.bytedance.msdk.api.xj("请求成功，但无广告可用"));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
            public void xj() {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "pangle_reward_onRewardVideoCached");
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.p == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            qt qtVar = this.p;
            if (qtVar != null) {
                w(qtVar.hf());
            }
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public Integer y() {
            qt qtVar = this.p;
            return (qtVar == null || qtVar.u() <= System.currentTimeMillis()) ? 3 : 2;
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            qt qtVar = this.p;
            if (qtVar != null) {
                qtVar.xj((com.bytedance.sdk.openadsdk.zg.w.xj.w) null);
                this.p.xj((com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj) null);
                this.p.xj((com.bytedance.sdk.openadsdk.zg.w.xj.hf) null);
                this.p = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void xj(android.content.Context r9) {
            /*
                r8 = this;
                com.bytedance.msdk.w.w.hf.xj.hf.p r0 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.sdk.openadsdk.core.z r9 = r0.xj(r9)
                if (r9 != 0) goto L9
                return
            L9:
                com.bytedance.msdk.w.w.hf.xj.hf.p r0 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r0 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r0)
                java.util.Map r0 = r0.r()
                if (r0 == 0) goto L28
                java.lang.String r1 = "pangle"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.String
                if (r1 == 0) goto L28
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L28
                goto L2a
            L28:
                java.lang.String r0 = ""
            L2a:
                com.bytedance.msdk.w.w.hf.xj.hf.p r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r1)
                com.bytedance.msdk.w.w.hf.xj.hf.p r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.w.y.hf.hf r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.hf(r1)
                java.lang.String r3 = r1.pl()
                com.bytedance.msdk.w.w.hf.xj.hf.p r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.w.y.hf.hf r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.hf(r1)
                java.lang.String r4 = r1.zg()
                com.bytedance.msdk.w.w.hf.xj.hf.p r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.w.y.hf.hf r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.hf(r1)
                java.lang.String r5 = r1.e()
                com.bytedance.msdk.w.w.hf.xj.hf.p r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.w.y.hf.hf r1 = com.bytedance.msdk.w.w.hf.xj.hf.p.hf(r1)
                java.lang.String r6 = r1.et()
                r7 = 0
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r1 = com.bytedance.msdk.xj.w.hf.xj(r2, r3, r4, r5, r6, r7)
                com.bytedance.msdk.w.w.hf.xj.hf.p r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r2)
                java.lang.String r2 = r2.en()
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r2 = r1.y(r2)
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r0 = r2.kd(r0)
                com.bytedance.msdk.w.w.hf.xj.hf.p r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r2)
                java.lang.String r2 = r2.q()
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r0 = r0.tf(r2)
                com.bytedance.msdk.w.w.hf.xj.hf.p r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r2)
                int r2 = r2.z()
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r0 = r0.f(r2)
                r2 = 1080(0x438, float:1.513E-42)
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r0 = r0.xj(r2)
                r2 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.zg.w.w.hf$xj r0 = r0.hf(r2)
                com.bytedance.msdk.w.w.hf.xj.hf.p r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.this
                com.bytedance.msdk.api.xj.hf r2 = com.bytedance.msdk.w.w.hf.xj.hf.p.xj(r2)
                int r2 = r2.l()
                r0.u(r2)
                com.bytedance.sdk.openadsdk.zg.w.w.hf r0 = r1.xj()
                com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c r1 = r8.d
                r9.xj(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.w.hf.xj.hf.p.xj.xj(android.content.Context):void");
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, Object obj, String str) {
            qt qtVar = this.p;
            if (qtVar != null) {
                if (obj != null) {
                    qtVar.xj(activity, obj, str);
                } else {
                    qtVar.xj(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Object obj) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setRewardAdPlayAgainController rewardAdPlayAgainController:" + obj + "  mTTRewardVideoAd: " + this.p);
            qt qtVar = this.p;
            if (qtVar == null || !(obj instanceof com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf)) {
                return;
            }
            qtVar.xj((com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf) obj);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + hfVar + "  mTTRewardVideoAd: " + this.p);
            qt qtVar = this.p;
            if (qtVar != null) {
                qtVar.xj(hfVar);
            }
        }
    }

    public p(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    public void w() {
        xj(new com.bytedance.msdk.api.xj("load ad fail adSlot is null"));
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        this.hf = hfVar2;
        this.w = hfVar;
        if (hfVar2 == null) {
            w();
        } else {
            new xj(map).xj(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.hf.getContext());
        }
    }
}
