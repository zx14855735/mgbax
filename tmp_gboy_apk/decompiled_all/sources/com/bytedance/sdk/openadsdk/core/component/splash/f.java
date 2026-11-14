package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj;
import com.bytedance.sdk.openadsdk.core.ra.bl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.xj> c;
    private Handler d = new Handler(Looper.getMainLooper());
    private SoftReference<com.bytedance.sdk.openadsdk.zg.w.xj.w> f;
    private ws hf;
    private com.bytedance.sdk.openadsdk.core.hf.xj kd;
    private w u;
    private FrameLayout w;
    private Context xj;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w y;

    public interface xj {
        Context getActivity();

        void hf();

        void xj();

        void xj(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.d.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (!com.bytedance.sdk.openadsdk.core.pl.w.w.y.xj) {
                    f.this.hf();
                    return;
                }
                com.bytedance.sdk.openadsdk.core.pl.w.w.y.xj = false;
                if (f.this.y instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) f.this.y).f().xj(new com.bytedance.sdk.openadsdk.core.pl.w.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.4.1
                        @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.xj
                        public void xj() {
                            f.this.hf();
                        }
                    });
                }
            }
        }, 100L);
    }

    public void hf() {
        w wVar = this.u;
        if (wVar != null) {
            wVar.hf();
        }
    }

    public void xj(Context context, ws wsVar) {
        this.xj = context;
        this.hf = wsVar;
        this.w = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.w.setLayoutParams(layoutParams);
        bl.hf(this.hf);
    }

    public ViewGroup xj() {
        return this.w;
    }

    public void xj(String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.xj xjVar, com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.c = new SoftReference<>(xjVar);
        if (wVar != null) {
            this.f = new SoftReference<>(wVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i));
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.hf.xj(this.xj, this.hf, str, 4);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
        SoftReference<com.bytedance.sdk.openadsdk.zg.w.xj.w> softReference = this.f;
        if (softReference == null) {
            xj(str, this.w, null);
        } else {
            xj(str, this.w, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.y);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
            public void xj(View view, int i2) {
                if (f.this.c != null && f.this.c.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.xj) f.this.c.get()).hf();
                }
                f.this.w();
            }
        });
        this.kd = xjVar2;
        w wVar2 = this.u;
        if (wVar2 != null) {
            wVar2.xj(xjVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.pl.hf.w xj(ws wsVar, String str) {
        if (wsVar.vw() == 4) {
            return com.bytedance.sdk.openadsdk.core.pl.f.xj(this.xj, wsVar, str, false);
        }
        return null;
    }

    private void xj(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        ws wsVar = this.hf;
        if (wsVar == null || this.xj == null || viewGroup == null) {
            return;
        }
        this.y = xj(wsVar, str);
        EmptyView emptyView = new EmptyView(this.xj, viewGroup, this.hf.cm());
        emptyView.xj(this.hf, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (wVar != null) {
            xj(wVar);
        }
        emptyView.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
                if (f.this.y != null) {
                    f.this.y.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z) {
                if (f.this.y != null && z) {
                    f.this.y.xj();
                }
                f.this.xj(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                ViewGroup viewGroup2;
                Context context;
                if (f.this.y != null) {
                    f.this.y.xj(false);
                }
                if (f.this.y == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                f.this.y.xj((Activity) context);
            }
        });
    }

    private void xj(final com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar2 = this.y;
        if (wVar2 == null) {
            return;
        }
        wVar2.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.3
            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void hf(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.hf(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void w(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.w(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj() {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.xj(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, String str, String str2) {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.xj(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(String str, String str2) {
                com.bytedance.sdk.openadsdk.zg.w.xj.w wVar3 = wVar;
                if (wVar3 != null) {
                    wVar3.xj(str, str2);
                }
            }
        });
    }

    public void xj(int i) {
        if (i == 2 && bl.xj(this.hf)) {
            this.u = new u();
        }
        w wVar = this.u;
        if (wVar != null) {
            wVar.xj(this.xj, this.w, this.hf);
            this.u.xj(this.kd);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.nativevideo.u uVar, xj xjVar) {
        w wVar = this.u;
        if (wVar != null) {
            wVar.xj(uVar, xjVar);
        }
    }

    public void xj(boolean z) {
        w wVar = this.u;
        if (wVar != null) {
            wVar.xj(z);
        }
    }
}
