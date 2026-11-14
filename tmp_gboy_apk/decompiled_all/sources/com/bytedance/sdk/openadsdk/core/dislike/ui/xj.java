package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends c {
    private boolean c;
    private hf d;
    private SoftReference<View> f;
    private com.bytedance.sdk.openadsdk.core.dislike.w.hf hf;
    private TTDislikeToast kd;
    private final List<com.bytedance.sdk.openadsdk.core.dislike.hf.xj> p;
    private InterfaceC0158xj tf;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.hf u;
    private w w;
    private final Context xj;
    private AtomicBoolean y;

    public static class hf extends Handler {
        public WeakReference<Context> xj;

        public hf(Context context) {
            this.xj = new WeakReference<>(context);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0158xj {
        void hf();

        void xj();

        void xj(int i, String str, boolean z);
    }

    public xj(Context context, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, String str, boolean z) {
        this.y = new AtomicBoolean(false);
        this.p = new ArrayList();
        hfVar.hf(str);
        hfVar.xj(AdnName.OTHER);
        this.xj = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            pl.w("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.hf = hfVar;
        this.c = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            u();
        } else {
            f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.u();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        Context context = this.xj;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.u.isShowing()) {
            return;
        }
        this.u.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ViewGroup viewGroup;
        w wVar = new w(this.xj, this.hf);
        this.w = wVar;
        wVar.xj(new com.bytedance.sdk.openadsdk.core.dislike.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.w
            public void hf() {
                if (xj.this.tf != null) {
                    xj.this.tf.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.w
            public void w() {
                pl.u("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (xj.this.tf == null || xj.this.w()) {
                        return;
                    }
                    xj.this.tf.hf();
                } catch (Throwable th) {
                    pl.w("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.w
            public void xj() {
                xj.this.kd();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.w
            public void xj(int i, y yVar) {
                try {
                    if (!xj.this.p.isEmpty()) {
                        String u = xj.this.u != null ? xj.this.u.u() : "";
                        Iterator it = xj.this.p.iterator();
                        while (it.hasNext()) {
                            ((com.bytedance.sdk.openadsdk.core.dislike.hf.xj) it.next()).xj(yVar, u, xj.this.u);
                        }
                    }
                    if (!yVar.y()) {
                        if (xj.this.tf != null) {
                            xj.this.tf.xj(i, yVar.hf(), xj.this.hf != null ? xj.this.hf.f() : false);
                        }
                        xj.this.y.set(true);
                        if (xj.this.kd != null) {
                            xj.this.kd.xj();
                        }
                        xj.this.y();
                    }
                    pl.u("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + yVar.hf());
                } catch (Throwable th) {
                    pl.w("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ui.hf hfVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.hf(this.xj, this.hf);
        this.u = hfVar;
        hfVar.xj(new com.bytedance.sdk.openadsdk.core.dislike.hf.hf() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.hf
            public void xj() {
                try {
                    if (xj.this.y.get()) {
                        return;
                    }
                    xj.this.w.show();
                    if (xj.this.u != null) {
                        String u = xj.this.u.u();
                        if (TextUtils.isEmpty(u)) {
                            return;
                        }
                        xj.this.w.xj(u);
                    }
                } catch (Throwable th) {
                    pl.w("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.hf
            public void xj(int i, y yVar) {
                try {
                    if (yVar.y()) {
                        return;
                    }
                    if (xj.this.tf != null) {
                        xj.this.tf.xj(i, yVar.hf(), xj.this.hf != null ? xj.this.hf.f() : false);
                    }
                    xj.this.y.set(true);
                    if (xj.this.kd != null) {
                        xj.this.kd.xj();
                    }
                    xj.this.y();
                } catch (Throwable th) {
                    pl.w("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.xj instanceof Activity) && this.c) {
            this.kd = new TTDislikeToast(this.xj);
            Window window = ((Activity) this.xj).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.kd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar = this.hf;
        if (hfVar == null) {
            return;
        }
        final String c = hfVar.c();
        if ("slide_banner_ad".equals(c) || "banner_ad".equals(c) || "embeded_ad".equals(c)) {
            if (this.f.get() != null && this.hf.f()) {
                this.f.get().setVisibility(8);
            }
            if (this.d == null) {
                this.d = new hf(this.xj);
            }
            this.d.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf.hf(PointCategory.DISLIKE);
                    if (xj.this.f == null || xj.this.f.get() == null || !((View) xj.this.f.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(xj.this.xj, xj.this.hf, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(xj.this.xj, xj.this.hf, "close_fail");
                    }
                    xj.this.hf.hf(c);
                }
            }, 500L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
    public void hf() {
        if (this.xj instanceof Activity) {
            w wVar = this.w;
            if (wVar != null) {
                wVar.hide();
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.hf hfVar = this.u;
            if (hfVar != null) {
                hfVar.xj();
            }
            TTDislikeToast tTDislikeToast = this.kd;
            if (tTDislikeToast != null) {
                tTDislikeToast.w();
            }
            this.y.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
    public boolean w() {
        if (!(this.xj instanceof Activity)) {
            return false;
        }
        w wVar = this.w;
        boolean isShowing = wVar != null ? wVar.isShowing() : false;
        com.bytedance.sdk.openadsdk.core.dislike.ui.hf hfVar = this.u;
        return hfVar != null ? hfVar.isShowing() | isShowing : isShowing;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
    public void xj() {
        TTDislikeToast tTDislikeToast;
        Context context = this.xj;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.y.get() && this.c && (tTDislikeToast = this.kd) != null) {
            tTDislikeToast.hf();
        } else {
            if (!z || w()) {
                return;
            }
            this.w.show();
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        if ((this.xj instanceof Activity) && hfVar != null) {
            this.w.xj(hfVar);
            this.u.xj(hfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
    public void xj(final com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.tf = new InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xj.4
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void hf() {
                com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj() {
                com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj(int i, String str, boolean z) {
                com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj(i, str, z);
                }
            }
        };
    }

    public void xj(InterfaceC0158xj interfaceC0158xj) {
        this.tf = interfaceC0158xj;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.xj(str);
        }
    }

    public xj(Context context, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, boolean z) {
        this(context, hfVar, null, z);
    }

    public void xj(View view) {
        this.f = new SoftReference<>(view);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.hf.xj xjVar) {
        this.p.add(xjVar);
        com.bytedance.sdk.openadsdk.core.dislike.ui.hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }
}
