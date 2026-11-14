package com.bytedance.sdk.component.adexpress.dynamic.xj;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.u.f;
import com.bytedance.sdk.component.adexpress.dynamic.w.y;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.c;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.hf.p;
import com.bytedance.sdk.component.adexpress.hf.u;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.u.kd;
import com.bytedance.sdk.component.adexpress.w;
import com.bytedance.sdk.component.utils.pl;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.views.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements p, u<DynamicRootView> {
    private ScheduledFuture<?> c;
    private f hf;
    private com.bytedance.sdk.component.adexpress.hf.f kd;
    private c u;
    private Context w;
    private DynamicRootView xj;
    private g y;
    private AtomicBoolean f = new AtomicBoolean(false);
    private volatile boolean d = false;

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.xj.xj$xj, reason: collision with other inner class name */
    public class RunnableC0099xj implements Runnable {
        private int hf;

        public RunnableC0099xj(int i) {
            this.hf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hf == 2) {
                xj.this.xj.xj(xj.this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? 127 : 117, (String) null);
            }
        }
    }

    public xj(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, f fVar, g gVar, com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar) {
        this.w = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, gVar, xjVar);
        this.xj = dynamicRootView;
        this.hf = fVar;
        this.y = gVar;
        dynamicRootView.setRenderListener(this);
        this.y = gVar;
    }

    private boolean d() {
        DynamicRootView dynamicRootView = this.xj;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.y.c().hf(w());
        JSONObject kd = this.y.kd();
        if (com.bytedance.sdk.component.adexpress.xj.hf.hf.xj(kd)) {
            this.hf.xj(new com.bytedance.sdk.component.adexpress.dynamic.kd.hf() { // from class: com.bytedance.sdk.component.adexpress.dynamic.xj.xj.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.hf
                public void xj(final com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
                    xj.this.tf();
                    xj.this.y.c().w(xj.this.w());
                    xj.this.xj(fVar);
                    xj.this.hf(fVar);
                    if (xj.this.d) {
                        xj.this.w(fVar);
                    } else {
                        com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.xj.xj.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                xj.this.w(fVar);
                            }
                        });
                    }
                    if (xj.this.xj == null || fVar == null) {
                        return;
                    }
                    xj.this.xj.setBgColor(fVar.xj());
                    xj.this.xj.setBgMaterialCenterCalcColor(fVar.hf());
                }
            });
            this.hf.xj(this.y);
            return;
        }
        int i = this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? 123 : AdEventType.AD_ZOOM_OUT;
        DynamicRootView dynamicRootView = this.xj;
        StringBuilder sb = new StringBuilder("data null is ");
        sb.append(kd == null);
        dynamicRootView.xj(i, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        try {
            ScheduledFuture<?> scheduledFuture = this.c;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.c.cancel(false);
            this.c = null;
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void kd() {
        this.xj.hf();
    }

    public void u() {
        this.xj.xj();
    }

    public DynamicRootView y() {
        return this.xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        float f;
        float f2;
        List<com.bytedance.sdk.component.adexpress.dynamic.w.f> p;
        if (fVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.w.f> p2 = fVar.p();
        if (p2 == null || p2.size() <= 0) {
            f = 0.0f;
        } else {
            f = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar2 : p2) {
                if (fVar2.c() > fVar.c() - fVar2.d() || (p = fVar2.p()) == null || p.size() <= 0) {
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar3 : p) {
                        if (fVar3.tf().getType().equals("logo-union")) {
                            f2 = fVar3.tf().y();
                            f = ((fVar.c() + (-f2)) - fVar2.c()) + fVar2.tf().kd().no();
                        }
                    }
                }
                hf(fVar2);
                if (f2 <= -15.0f) {
                    fVar2.y(fVar2.d() - f2);
                    fVar2.u(fVar2.c() + f2);
                    for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar4 : fVar2.p()) {
                        fVar4.u(fVar4.c() - f2);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.w.f pl2 = fVar.pl();
        if (pl2 == null) {
            return;
        }
        float y = fVar.y() - pl2.y();
        float c = fVar.c() - pl2.c();
        fVar.w(y);
        fVar.u(c);
        if (f > 0.0f) {
            fVar.u(fVar.c() - f);
            fVar.y(fVar.d() + f);
            for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar5 : fVar.p()) {
                fVar5.u(fVar5.c() + f);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public int w() {
        return this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? 3 : 2;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public void xj(c cVar) {
        this.u = cVar;
        int f = this.y.f();
        if (f < 0) {
            int i = this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? 127 : 117;
            this.xj.xj(i, "time is " + f);
            return;
        }
        this.c = kd.xj(new RunnableC0099xj(2), f, TimeUnit.MILLISECONDS);
        if (this.d) {
            com.bytedance.sdk.component.utils.f.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.f();
                }
            }, this.y.pl());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.y.pl() <= 0) {
            f();
        } else {
            com.bytedance.sdk.component.utils.f.hf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.xj.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.f();
                }
            }, this.y.pl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        if (fVar == null) {
            this.xj.xj(this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? 123 : AdEventType.AD_ZOOM_OUT, "layoutUnit is null");
            return;
        }
        this.y.c().u(w());
        try {
            this.xj.xj(fVar, w());
        } catch (Exception e) {
            int i = this.hf instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c ? r.b.d : TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS;
            this.xj.xj(i, "exception is " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.w.f> p;
        if (fVar == null || (p = fVar.p()) == null || p.size() <= 0) {
            return;
        }
        Collections.sort(p, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.w.f>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.xj.xj.4
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar2, com.bytedance.sdk.component.adexpress.dynamic.w.f fVar3) {
                y kd = fVar2.tf().kd();
                y kd2 = fVar3.tf().kd();
                if (kd == null || kd2 == null) {
                    return 0;
                }
                return kd.t() >= kd2.t() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar2 : p) {
            if (fVar2 != null) {
                xj(fVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public DynamicRootView c() {
        return y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void xj(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                xj(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd) view).hf();
        }
    }

    public void hf() {
        xj(c());
    }

    public void hf(boolean z) {
        this.d = z;
    }

    public void xj(boolean z) {
        this.xj.setSoundMute(z);
    }

    public void xj(com.bytedance.sdk.component.adexpress.hf.f fVar) {
        this.kd = fVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(am amVar) {
        if (this.f.get()) {
            return;
        }
        this.f.set(true);
        if (amVar.w() && d()) {
            this.xj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.u.xj(c(), amVar);
            return;
        }
        this.u.xj(amVar.p(), amVar.tf());
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(View view, int i, w wVar) {
        com.bytedance.sdk.component.adexpress.hf.f fVar = this.kd;
        if (fVar != null) {
            fVar.xj(view, i, wVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(View view, int i, w wVar, int i2) {
        com.bytedance.sdk.component.adexpress.hf.f fVar = this.kd;
        if (fVar != null) {
            fVar.xj(view, i, wVar, i2);
        }
    }
}
