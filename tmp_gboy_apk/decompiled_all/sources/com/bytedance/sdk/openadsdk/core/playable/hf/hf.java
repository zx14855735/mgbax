package com.bytedance.sdk.openadsdk.core.playable.hf;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private boolean u;
    private boolean xj;
    private long hf = 0;
    private long w = 0;

    public hf(String str) {
        this.u = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public boolean hf(Activity activity, ws wsVar) {
        if (activity != null && wsVar != null) {
            boolean z = this.xj;
            this.xj = false;
            if (!wsVar.d() || !z) {
                return false;
            }
            if (xj.xj(activity) || hf()) {
                return true;
            }
            try {
                if (!this.u) {
                    return xj(activity);
                }
                if (xj.xj()) {
                    return false;
                }
                return xj(activity);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void xj(final Activity activity, ws wsVar) {
        if (activity == null || wsVar == null || !wsVar.d()) {
            return;
        }
        r.w(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.hf.hf.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        hf.this.xj();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.hf.hf.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    r.w(activity);
                                }
                            }, PushUIConfig.dismissTime);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void xj(int i) {
        boolean z = i == 4;
        this.xj = z;
        if (z) {
            this.hf = System.currentTimeMillis();
        }
    }

    public void xj() {
        this.w = System.currentTimeMillis();
    }

    private boolean xj(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean hf() {
        long j = this.hf;
        long abs = j > 0 ? Math.abs(j - this.w) : -1L;
        return abs >= 0 && abs < 300;
    }
}
