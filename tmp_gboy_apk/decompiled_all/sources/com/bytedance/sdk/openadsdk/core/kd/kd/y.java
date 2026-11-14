package com.bytedance.sdk.openadsdk.core.kd.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y<T> implements kd<T> {
    private final kd<T> xj;

    public y(kd<T> kdVar) {
        this.xj = kdVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
    public void hf(final T t) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.y.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.xj != null) {
                    y.this.xj.hf(t);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
    public void xj(final T t) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.y.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.xj != null) {
                    y.this.xj.xj(t);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
    public void xj(final int i, final String str) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.kd.y.3
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.xj != null) {
                    y.this.xj.xj(i, str);
                }
            }
        });
    }
}
