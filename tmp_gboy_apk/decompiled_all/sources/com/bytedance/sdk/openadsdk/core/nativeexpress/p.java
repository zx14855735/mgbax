package com.bytedance.sdk.openadsdk.core.nativeexpress;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p implements tf {
    private Queue<Runnable> hf = new LinkedList();
    private WeakReference<tf> xj;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.9
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).c();
                }
            });
        } else {
            this.xj.get().c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.12
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).d();
                }
            });
        } else {
            this.xj.get().d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.10
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).f();
                }
            });
        } else {
            this.xj.get().f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long getActualPlayDuration() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.xj.get().getActualPlayDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.xj.get().hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void kd() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.3
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).kd();
                }
            });
        } else {
            this.xj.get().kd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.14
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).p();
                }
            });
        } else {
            this.xj.get().p();
        }
    }

    public tf pl() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.5
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).setPauseFromExpressView(z);
                }
            });
        } else {
            this.xj.get().setPauseFromExpressView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.13
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).tf();
                }
            });
        } else {
            this.xj.get().tf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void u() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.16
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).u();
                }
            });
        } else {
            this.xj.get().u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int w() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.xj.get().w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.7
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).y();
                }
            });
        } else {
            this.xj.get().y();
        }
    }

    public void xj(tf tfVar) {
        this.xj = new WeakReference<>(tfVar);
        while (!this.hf.isEmpty()) {
            try {
                Runnable poll = this.hf.poll();
                if (poll != null) {
                    poll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void hf(final int i) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().hf(i);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).hf(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(final int i) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().w(i);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.8
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).w(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final boolean z) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(z);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.1
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).xj(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final int i) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(i);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).xj(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.xj.get().xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(f, f2, f3, f4, i);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.15
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).xj(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final int i, final String str) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(i, str);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.4
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).xj(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final float f) {
        WeakReference<tf> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(f);
        } else {
            this.hf.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.6
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.xj == null || p.this.xj.get() == null) {
                        return;
                    }
                    ((tf) p.this.xj.get()).xj(f);
                }
            });
        }
    }
}
