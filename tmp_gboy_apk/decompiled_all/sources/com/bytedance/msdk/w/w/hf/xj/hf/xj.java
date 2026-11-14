package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.w.w.hf.xj.hf.hf {
    private com.bytedance.msdk.api.xj.hf hf;
    private com.bytedance.msdk.w.y.hf.hf w;

    public class hf extends com.bytedance.msdk.hf.w {
        am d;
        private final com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf g;
        private boolean p;

        /* renamed from: pl, reason: collision with root package name */
        private volatile boolean f10161pl = false;

        public hf(Context context, am amVar) {
            Map<String, Object> f;
            Function function = null;
            com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.hf.3
                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void hf(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) hf.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                        hf.this.mq().hf(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, int i) {
                    if (((com.bytedance.msdk.hf.w) hf.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                        hf.this.mq().xj(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, String str, int i) {
                    xj.this.xj(new com.bytedance.msdk.api.xj(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, float f2, float f3) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(hf.this);
                    xj.this.xj(arrayList);
                }
            };
            this.g = hfVar;
            this.d = amVar;
            p(amVar.hf());
            pl(this.d.w());
            c(true);
            this.d.xj(hfVar);
            if (context instanceof Activity) {
                this.d.xj((Activity) context, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(function) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.hf.1
                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void hf() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj(int i, String str, boolean z) {
                        if (hf.this.p) {
                            return;
                        }
                        hf.this.p = true;
                        if (((com.bytedance.msdk.hf.w) hf.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                            com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                            hf.this.mq().f_();
                        }
                    }
                });
            }
            if (!xj.this.w.xj() || (f = this.d.f()) == null) {
                return;
            }
            double xj = com.bytedance.msdk.xj.w.hf.xj(f.get("price"));
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(xj)));
            xj(xj <= 0.0d ? 0.0d : xj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.xj.hf.xj mq() {
            return (com.bytedance.msdk.xj.hf.xj) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(str);
            }
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
            return amVar != null ? com.bytedance.msdk.xj.w.hf.w(amVar.f()) : "";
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
        public void p() {
            am amVar = this.d;
            if (amVar != null) {
                amVar.u();
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> f;
            am amVar = this.d;
            if (amVar == null || (f = amVar.f()) == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "getMediaExtraInfo ".concat(String.valueOf(f)));
            w(f);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            am amVar = this.d;
            return amVar != null ? amVar.y() : super.uj();
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            this.f10161pl = true;
            com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.hf.2
                @Override // java.lang.Runnable
                public void run() {
                    am amVar = hf.this.d;
                    if (amVar != null) {
                        amVar.kd();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.f10161pl;
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, final com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.d.xj(activity, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.hf.4
                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void hf() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.hf();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj(int i, String str, boolean z) {
                        if (hf.this.p) {
                            return;
                        }
                        hf.this.p = true;
                        com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
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
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(wVar)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(wVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(wVar)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(wVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hfVar)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(hfVar);
            }
        }
    }

    public class w extends com.bytedance.msdk.hf.w {
        private boolean am;
        am d;
        private boolean g;
        SoftReference<FrameLayout> tf;
        final Object p = new Object();
        private volatile boolean qt = false;
        private final com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf zg = new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.w.4
            @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
            public void hf(View view, int i) {
                if (((com.bytedance.msdk.hf.w) w.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                    w.this.mq().hf(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
            public void xj(View view, int i) {
                if (((com.bytedance.msdk.hf.w) w.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                    w.this.mq().xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
            public void xj(View view, String str, int i) {
                w.this.am = false;
                com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_banner", com.bytedance.msdk.xj.kd.kd.hf(xj.this.w.hf(), xj.this.w.pl()) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
            public void xj(View view, float f, float f2) {
                com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_banner", com.bytedance.msdk.xj.kd.kd.hf(xj.this.w.hf(), xj.this.w.pl()) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + w.this.tf);
                SoftReference<FrameLayout> softReference = w.this.tf;
                if (softReference != null) {
                    FrameLayout frameLayout = softReference.get();
                    if (frameLayout != null) {
                        com.bytedance.msdk.api.kd.xj(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    w.this.am = true;
                }
            }
        };

        public w() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.xj.hf.xj mq() {
            return (com.bytedance.msdk.xj.hf.xj) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public synchronized View d() {
            SoftReference<FrameLayout> softReference = this.tf;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.p) {
                if (frameLayout == null) {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        long j = 2000 + uptimeMillis;
                        while (!this.am && uptimeMillis < j) {
                            this.p.wait(j - uptimeMillis);
                            uptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
            return frameLayout;
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
            return amVar != null ? com.bytedance.msdk.xj.w.hf.w(amVar.f()) : "";
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
        public void ra(int i) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i)));
                this.d.xj(i);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            if (this.d == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : getDislikeInfo");
            return this.d.y();
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            this.qt = true;
            com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.w.2
                @Override // java.lang.Runnable
                public void run() {
                    am amVar = w.this.d;
                    if (amVar != null) {
                        amVar.xj((com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj) null);
                        w.this.d.kd();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.qt;
        }

        public void xj(final Context context) {
            z xj = xj.this.xj(context);
            if (xj == null) {
                return;
            }
            hf.xj xj2 = com.bytedance.msdk.xj.w.hf.xj(xj.this.hf, xj.this.w.pl(), xj.this.w.zg(), xj.this.w.e(), xj.this.w.et(), false);
            float am = xj.this.hf.am();
            xj2.xj(am).hf(xj.this.hf.qt());
            xj.w(xj2.xj(), new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.w.1
                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
                public void xj(int i, String str) {
                    xj.this.xj(new com.bytedance.msdk.api.xj(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
                public void xj(List<am> list) {
                    Map<String, Object> f;
                    if (list == null || list.size() == 0 || context == null) {
                        xj.this.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                        return;
                    }
                    w.this.d = list.get(0);
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        w.this.d.xj((Activity) context2, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.w.1.1
                            @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                            public void hf() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                            public void xj() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                            public void xj(int i, String str, boolean z) {
                                if (w.this.g) {
                                    return;
                                }
                                w.this.g = true;
                                if (((com.bytedance.msdk.hf.w) w.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                                    com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                                    w.this.mq().f_();
                                }
                            }
                        });
                    }
                    w.this.c(true);
                    w wVar = w.this;
                    wVar.pl(wVar.d.w());
                    w wVar2 = w.this;
                    wVar2.p(wVar2.d.hf());
                    if (xj.this.w.xj() && (f = w.this.d.f()) != null) {
                        double xj3 = com.bytedance.msdk.xj.w.hf.xj(f.get("price"));
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", com.bytedance.msdk.xj.kd.kd.hf(xj.this.w.hf(), xj.this.w.pl()) + "pangle banner 返回的 cpm价格：" + xj3);
                        w wVar3 = w.this;
                        if (xj3 <= 0.0d) {
                            xj3 = 0.0d;
                        }
                        wVar3.xj(xj3);
                    }
                    w wVar4 = w.this;
                    wVar4.d.xj(wVar4.zg);
                    w.this.tf = new SoftReference<>(new FrameLayout(context));
                    w.this.d.u();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(w.this);
                    xj.this.xj(arrayList);
                }
            });
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, final com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.d.xj(activity, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.w.3
                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void hf() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.hf();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj(int i, String str, boolean z) {
                        if (w.this.g) {
                            return;
                        }
                        w.this.g = true;
                        com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.d != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.d.xj(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            if (this.d == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.d.xj(activity);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hfVar)));
            am amVar = this.d;
            if (amVar != null) {
                amVar.xj(hfVar);
            }
        }
    }

    /* renamed from: com.bytedance.msdk.w.w.hf.xj.hf.xj$xj, reason: collision with other inner class name */
    public class C0079xj extends com.bytedance.msdk.hf.w {
        private volatile boolean am = false;
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj d = new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.xj.3
            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void hf(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) C0079xj.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                    C0079xj.this.mq().xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) C0079xj.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                    C0079xj.this.mq().xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(g gVar) {
                if (((com.bytedance.msdk.hf.w) C0079xj.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                    C0079xj.this.mq().hf(null);
                }
            }
        };
        private boolean g;
        private com.bytedance.sdk.openadsdk.zg.w.hf.tf p;

        /* renamed from: pl, reason: collision with root package name */
        private Context f10163pl;

        /* JADX WARN: Multi-variable type inference failed */
        public C0079xj(Context context, com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
            Map<String, Object> ht;
            this.p = tfVar;
            this.f10163pl = context;
            com.bytedance.sdk.openadsdk.zg.w.hf.w v = tfVar.v();
            if (v != null) {
                ht(v.xj());
                ra(v.w());
                et(v.u());
                io(v.hf());
                HashMap hashMap = new HashMap();
                Map<String, String> kd = v.kd();
                if (kd != null && kd.size() > 0) {
                    hashMap.putAll(kd);
                }
                kd(hashMap);
                if (com.bytedance.msdk.xj.w.hf.xj("5.4.0.3")) {
                    pl(v.c());
                }
                if (com.bytedance.msdk.xj.w.hf.xj("6.8.1.6")) {
                    tf(v.f());
                }
                p(v.d());
            }
            j(tfVar.c());
            en(tfVar.f());
            q(tfVar.d());
            x(tfVar.am() != null ? tfVar.am().w() : null);
            p(tfVar.e());
            pl(tfVar.zg());
            l(tfVar.g());
            u(tfVar.tf());
            f(tfVar.zg() == 4);
            c(false);
            if (tfVar.e() == 16 || tfVar.e() == 3 || tfVar.e() == 2 || tfVar.e() == 131) {
                if (tfVar.qt() != null && !tfVar.qt().isEmpty() && tfVar.qt().get(0) != null) {
                    com.bytedance.sdk.openadsdk.zg.w.hf.pl plVar = tfVar.qt().get(0);
                    ai(plVar.w());
                    v(plVar.xj());
                    yo(plVar.hf());
                }
            } else if (tfVar.e() == 4 && tfVar.qt() != null && tfVar.qt().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.pl> it = tfVar.qt().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().w());
                }
                xj((List<String>) arrayList);
            }
            p(tfVar.e());
            if (!xj.this.w.xj() || (ht = tfVar.ht()) == null) {
                return;
            }
            double xj = com.bytedance.msdk.xj.w.hf.xj(ht.get("price"));
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(xj)));
            xj(xj <= 0.0d ? 0.0d : xj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.xj.hf.xj mq() {
            return (com.bytedance.msdk.xj.hf.xj) this.c;
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                tfVar.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public int ah() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                return tfVar.u();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(tfVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            return tfVar != null ? com.bytedance.msdk.xj.w.hf.w(tfVar.ht()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean jk() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public int lx() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                return tfVar.w();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(tfVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> ht;
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar == null || (ht = tfVar.ht()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", ht.get("coupon"));
            hashMap.put("live_room", ht.get("live_room"));
            hashMap.put("product", ht.get("product"));
            w(hashMap);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native : getDislikeInfo");
            return this.p.yo();
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            this.am = true;
            com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0079xj.this.p != null) {
                        C0079xj.this.p.xj((com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj) null);
                        C0079xj.this.p.xj((com.bytedance.sdk.openadsdk.zg.w.xj.hf) null);
                        C0079xj.this.p.dk();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c hf(Dialog dialog, Integer[] numArr) {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.p.xj(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.am;
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar2;
            View pz;
            View findViewById;
            super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar3 = this.p;
            if (tfVar3 != null) {
                tfVar3.xj(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.d);
                this.p.xj(activity, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.xj.1
                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void hf() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj(int i, String str, boolean z) {
                        if (C0079xj.this.g) {
                            return;
                        }
                        C0079xj.this.g = true;
                        if (((com.bytedance.msdk.hf.w) C0079xj.this).c instanceof com.bytedance.msdk.xj.hf.xj) {
                            com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                            C0079xj.this.mq().f_();
                        }
                    }
                });
            }
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar4 = this.p;
            if (tfVar4 != null && tfVar4.y() != null && tfVar != null && (findViewById = viewGroup.findViewById(tfVar.f10113pl)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.f10163pl);
                    imageView.setImageBitmap(this.p.y());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.api.kd.w(this.f10163pl, 38.0f);
                    layoutParams.height = com.bytedance.msdk.api.kd.w(this.f10163pl, 38.0f);
                    findViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ((ImageView) findViewById).setImageBitmap(this.p.y());
                }
            }
            if (tfVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tfVar.c)) == null || (tfVar2 = this.p) == null || (pz = tfVar2.pz()) == null) {
                return;
            }
            hf(pz);
            frameLayout.removeAllViews();
            frameLayout.addView(pz, -1, -1);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, final com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.p.xj(activity, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.xj.4
                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void hf() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.hf();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj() {
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                    public void xj(int i, String str, boolean z) {
                        if (C0079xj.this.g) {
                            return;
                        }
                        C0079xj.this.g = true;
                        com.bytedance.msdk.core.hf.xj.xj(xj.this.w.hf());
                        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                        if (xjVar2 != null) {
                            xjVar2.xj(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.p.hf(dialog, numArr);
                }
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.p.xj(activity);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hfVar)));
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.p;
            if (tfVar != null) {
                tfVar.xj(hfVar);
            }
        }
    }

    public xj(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    private void w(final Context context) {
        z xj = xj(context);
        if (xj == null) {
            return;
        }
        hf.xj xj2 = com.bytedance.msdk.xj.w.hf.xj(this.hf, this.w.pl(), this.w.zg(), this.w.e(), this.w.et(), false);
        xj2.xj(this.hf.et()).hf(this.hf.io());
        xj.xj(xj2.xj(), new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.2
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w
            public void xj(int i, String str) {
                xj.this.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w
            public void xj(List<com.bytedance.sdk.openadsdk.zg.w.hf.tf> list) {
                if (list == null || list.isEmpty()) {
                    xj.this.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(xj.this.new C0079xj(context, list.get(0)));
                xj.this.xj(arrayList);
            }
        });
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        this.hf = hfVar2;
        this.w = hfVar;
        if (hfVar2 == null) {
            xj(new com.bytedance.msdk.api.xj("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj == null || ((Integer) obj).intValue() != 4) {
                new w().xj(context.getApplicationContext());
                return;
            }
            Object obj2 = map.get("tt_ad_origin_type");
            if (obj2 != null) {
                int intValue = ((Integer) obj2).intValue();
                if (intValue == 1) {
                    hf(context.getApplicationContext());
                } else if (intValue == 2) {
                    w(context.getApplicationContext());
                } else {
                    xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch"));
                }
            }
        }
    }

    private void hf(final Context context) {
        z xj = xj(context);
        if (xj == null) {
            return;
        }
        hf.xj hf2 = com.bytedance.msdk.xj.w.hf.xj(this.hf, this.w.pl(), this.w.zg(), this.w.e(), this.w.et(), false).xj(this.hf.et()).hf(this.hf.io());
        float am = this.hf.am();
        float qt = this.hf.qt();
        boolean xj2 = com.bytedance.msdk.xj.w.hf.xj(this.hf);
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle banner native express autoHeight:" + xj2 + " width:" + am + "  height:" + qt);
        if (qt > 0.0f && !xj2) {
            hf2.xj(am).hf(qt);
        } else {
            hf2.xj(am).hf(0.0f);
        }
        xj.xj(hf2.xj(), new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.xj.1
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
            public void xj(int i, String str) {
                xj.this.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y
            public void xj(List<am> list) {
                if (list == null || list.size() == 0) {
                    xj.this.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                for (am amVar : list) {
                    if (amVar != null) {
                        xj.this.new hf(context, amVar).p();
                        return;
                    }
                }
            }
        });
    }
}
