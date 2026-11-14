package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private final View.OnAttachStateChangeListener am;
    private final Handler c;
    private com.bytedance.msdk.api.u.xj.xj.xj d;
    private final Handler f;
    private final SoftReference<Context> hf;
    private y kd;
    private final com.bytedance.msdk.api.u.xj.xj.xj qt;
    private com.bytedance.msdk.api.u.xj.xj.u tf;
    private y u;
    private com.bytedance.msdk.api.xj.hf w;
    private RefreshableBannerView y;
    private final Runnable zg;
    private int xj = 0;
    private SoftReference<Activity> p = new SoftReference<>(null);

    /* renamed from: pl, reason: collision with root package name */
    private SoftReference<com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj> f10154pl = new SoftReference<>(null);
    private SoftReference<Map<String, Object>> g = new SoftReference<>(null);

    /* renamed from: com.bytedance.msdk.w.u.p$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f.post(new Runnable() { // from class: com.bytedance.msdk.w.u.p.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == 0 || p.this.kd == null) {
                        return;
                    }
                    View xj = p.this.kd.xj((Context) p.this.hf.get());
                    if (xj != null) {
                        p pVar = p.this;
                        pVar.xj(pVar.kd);
                        if (p.this.y != null) {
                            p.this.y.xj(xj);
                        }
                        p.this.f.postDelayed(new Runnable() { // from class: com.bytedance.msdk.w.u.p.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (p.this.u != null) {
                                    p.this.u.xj();
                                }
                                p pVar2 = p.this;
                                pVar2.u = pVar2.kd;
                                p.this.e();
                            }
                        }, 250L);
                    } else {
                        if (p.this.kd != null) {
                            p.this.kd.xj();
                        }
                        p.this.e();
                    }
                    p.this.qt();
                }
            });
        }
    }

    public p(Context context) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.msdk.w.u.p.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (p.this.xj == 0) {
                    return;
                }
                p.this.e();
                p.this.qt();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                p.this.zg();
            }
        };
        this.am = onAttachStateChangeListener;
        this.qt = new com.bytedance.msdk.api.u.xj.xj.xj() { // from class: com.bytedance.msdk.w.u.p.2
            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void f_() {
                p.this.zg();
                if (p.this.d != null) {
                    p.this.d.f_();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void hf(View view) {
                if (p.this.d != null) {
                    p.this.d.hf(view);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(View view) {
                if (p.this.d != null) {
                    p.this.d.xj(view);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (p.this.d != null) {
                    p.this.d.xj(xjVar);
                }
            }
        };
        this.zg = new AnonymousClass3();
        this.hf = new SoftReference<>(context);
        this.u = new y(context);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.y = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.y.setVisibilityChangeListener(new RefreshableBannerView.xj() { // from class: com.bytedance.msdk.w.u.p.4
                @Override // com.bytedance.msdk.core.views.RefreshableBannerView.xj
                public void xj(boolean z) {
                    if (!z) {
                        p.this.zg();
                    } else {
                        if (p.this.xj == 0) {
                            return;
                        }
                        p.this.qt();
                    }
                }
            });
        }
        this.c = new Handler(com.bytedance.msdk.xj.kd.y.hf());
        this.f = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Context context;
        SoftReference<Context> softReference = this.hf;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        y yVar = new y(context);
        this.kd = yVar;
        yVar.xj(this.qt);
        this.kd.xj(this.tf);
        xj(this.w);
        this.kd.xj(this.w, (com.bytedance.msdk.api.u.xj.xj.hf) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(this.zg, this.xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        this.c.removeCallbacksAndMessages(null);
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.u am() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.pz();
        }
        return null;
    }

    public int g() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.e();
        }
        return -1;
    }

    public List<com.bytedance.msdk.api.w> p() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.pl();
        }
        return null;
    }

    public com.bytedance.msdk.api.w pl() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.qt();
        }
        return null;
    }

    public Map<String, Object> c() {
        y yVar = this.u;
        return yVar != null ? yVar.yo() : new HashMap();
    }

    public List<com.bytedance.msdk.api.w> d() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.p();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.hf> f() {
        y yVar = this.u;
        return yVar != null ? yVar.tf() : new ArrayList();
    }

    public View kd() {
        y yVar = this.u;
        if (yVar == null) {
            return null;
        }
        View xj = yVar.xj(this.hf.get());
        y yVar2 = this.u;
        yVar2.xj(yVar2.u);
        if (xj == null || this.y == null) {
            return null;
        }
        xj.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.msdk.w.u.p.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (view.getVisibility() == 0) {
                    p pVar = p.this;
                    pVar.xj(pVar.u);
                    view.removeOnLayoutChangeListener(this);
                }
            }
        });
        this.y.removeAllViews();
        ViewParent parent = xj.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(xj);
        }
        this.y.addView(xj);
        return this.y;
    }

    public com.bytedance.msdk.api.w tf() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.zg();
        }
        return null;
    }

    public boolean u() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.w();
        }
        return false;
    }

    public void w() {
        this.f.removeCallbacksAndMessages(null);
        zg();
        RefreshableBannerView refreshableBannerView = this.y;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.am);
        }
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj();
        }
        y yVar2 = this.kd;
        if (yVar2 != null) {
            yVar2.xj();
        }
    }

    public int y() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.u();
        }
        return 0;
    }

    private void xj(com.bytedance.msdk.api.xj.hf hfVar) {
        com.bytedance.msdk.core.tf.hf xj;
        if (hfVar == null || (xj = com.bytedance.msdk.core.hf.hf().xj(hfVar.ra(), 1, 100)) == null) {
            return;
        }
        int tf = xj.tf(1);
        if (tf >= 10000 && tf <= 180000) {
            this.xj = tf;
            com.bytedance.msdk.xj.kd.w.xj("TMe", "---==-----banner轮播时间：" + this.xj);
            return;
        }
        com.bytedance.msdk.xj.kd.w.xj("TMe", "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + tf + "，禁止banner轮播");
    }

    public void hf() {
        y yVar = this.u;
        if (yVar != null) {
            yVar.y();
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.xj.hf hfVar2) {
        SoftReference<Context> softReference;
        if (this.u == null || (softReference = this.hf) == null || softReference.get() == null) {
            return;
        }
        this.w = hfVar;
        xj(hfVar);
        if (!com.bytedance.msdk.core.hf.hf().xj(hfVar.ra(), 1) && hfVar2 != null) {
            hfVar2.xj(new com.bytedance.msdk.api.xj(840031, com.bytedance.msdk.api.xj.xj(840031)));
        } else if (com.bytedance.msdk.core.hf.hf().qt()) {
            this.u.xj(this.w, hfVar2);
        } else if (hfVar2 != null) {
            hfVar2.xj(new com.bytedance.msdk.api.xj(840032, com.bytedance.msdk.api.xj.xj(840032)));
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.xj.xj xjVar) {
        this.d = xjVar;
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj(this.qt);
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.xj.u uVar) {
        this.tf = uVar;
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj(uVar);
        }
    }

    public void xj() {
        y yVar = this.u;
        if (yVar != null) {
            yVar.kd();
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj(wVar);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        y yVar = this.u;
        if (yVar != null) {
            yVar.hf(hfVar);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj(wVar);
        }
    }

    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.p = new SoftReference<>(activity);
        this.f10154pl = new SoftReference<>(xjVar);
    }

    public void xj(Dialog dialog, Integer[] numArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("dislike_dialog", dialog);
        hashMap.put("dislike_ids", numArr);
        this.g = new SoftReference<>(hashMap);
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.xj(activity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(y yVar) {
        Map<String, Object> map = this.g.get();
        if (map != null) {
            Dialog dialog = (Dialog) map.get("dislike_dialog");
            Integer[] numArr = (Integer[]) map.get("dislike_ids");
            if (dialog != null && numArr != null) {
                yVar.xj(dialog, numArr);
            }
        }
        Activity activity = this.p.get();
        com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar = this.f10154pl.get();
        if (activity == null || xjVar == null) {
            return;
        }
        yVar.xj(activity, xjVar);
    }

    public void xj(String str) {
        y yVar = this.u;
        if (yVar != null) {
            yVar.u(str);
        }
    }
}
