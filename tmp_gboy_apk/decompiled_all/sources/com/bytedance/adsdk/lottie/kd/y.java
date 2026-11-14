package com.bytedance.adsdk.lottie.kd;

import android.view.Choreographer;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends xj implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.y tf;
    private float hf = 1.0f;
    private boolean w = false;
    private long u = 0;
    private float kd = 0.0f;
    private float y = 0.0f;
    private int c = 0;
    private float f = -2.14748365E9f;
    private float d = 2.14748365E9f;
    protected boolean xj = false;
    private boolean p = false;

    private boolean jk() {
        return tf() < 0.0f;
    }

    private void pz() {
        if (this.tf == null) {
            return;
        }
        float f = this.y;
        if (f < this.f || f > this.d) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f), Float.valueOf(this.d), Float.valueOf(this.y)));
        }
    }

    private float v() {
        com.bytedance.adsdk.lottie.y yVar = this.tf;
        if (yVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / yVar.g()) / Math.abs(this.hf);
    }

    @MainThread
    public void am() {
        this.xj = true;
        e();
        this.u = 0L;
        if (jk() && c() == qt()) {
            xj(zg());
        } else if (!jk() && c() == zg()) {
            xj(qt());
        }
        kd();
    }

    public float c() {
        return this.y;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        hf();
        yo();
    }

    public void d() {
        w(-tf());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        e();
        if (this.tf == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.lottie.kd.xj("LottieValueAnimator#doFrame");
        float v = (this.u != 0 ? j - r1 : 0L) / v();
        float f = this.kd;
        if (jk()) {
            v = -v;
        }
        float f2 = f + v;
        boolean w = f.w(f2, qt(), zg());
        float f3 = this.kd;
        float hf = f.hf(f2, qt(), zg());
        this.kd = hf;
        if (this.p) {
            hf = (float) Math.floor(hf);
        }
        this.y = hf;
        this.u = j;
        if (!this.p || this.kd != f3) {
            w();
        }
        if (!w) {
            if (getRepeatCount() == -1 || this.c < getRepeatCount()) {
                xj();
                this.c++;
                if (getRepeatMode() == 2) {
                    this.w = !this.w;
                    d();
                } else {
                    float zg = jk() ? zg() : qt();
                    this.kd = zg;
                    this.y = zg;
                }
                this.u = j;
            } else {
                float qt = this.hf < 0.0f ? qt() : zg();
                this.kd = qt;
                this.y = qt;
                yo();
                hf(jk());
            }
        }
        pz();
        com.bytedance.adsdk.lottie.kd.hf("LottieValueAnimator#doFrame");
    }

    public void e() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void f() {
        this.tf = null;
        this.f = -2.14748365E9f;
        this.d = 2.14748365E9f;
    }

    @MainThread
    public void g() {
        yo();
        u();
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float qt;
        float zg;
        float qt2;
        if (this.tf == null) {
            return 0.0f;
        }
        if (jk()) {
            qt = zg() - this.y;
            zg = zg();
            qt2 = qt();
        } else {
            qt = this.y - qt();
            zg = zg();
            qt2 = qt();
        }
        return qt / (zg - qt2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(y());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.y yVar = this.tf;
        if (yVar == null) {
            return 0L;
        }
        return (long) yVar.kd();
    }

    public void hf(float f) {
        xj(this.f, f);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.xj;
    }

    @MainThread
    public void p() {
        this.xj = true;
        xj(jk());
        xj((int) (jk() ? zg() : qt()));
        this.u = 0L;
        this.c = 0;
        e();
    }

    @MainThread
    public void pl() {
        yo();
        hf(jk());
    }

    public float qt() {
        com.bytedance.adsdk.lottie.y yVar = this.tf;
        if (yVar == null) {
            return 0.0f;
        }
        float f = this.f;
        return f == -2.14748365E9f ? yVar.y() : f;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.w) {
            return;
        }
        this.w = false;
        d();
    }

    public float tf() {
        return this.hf;
    }

    @MainThread
    public void u(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.xj = false;
        }
    }

    public void w(boolean z) {
        this.p = z;
    }

    public void xj(com.bytedance.adsdk.lottie.y yVar) {
        boolean z = this.tf == null;
        this.tf = yVar;
        if (z) {
            xj(Math.max(this.f, yVar.y()), Math.min(this.d, yVar.c()));
        } else {
            xj((int) yVar.y(), (int) yVar.c());
        }
        float f = this.y;
        this.y = 0.0f;
        this.kd = 0.0f;
        xj((int) f);
        w();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float y() {
        com.bytedance.adsdk.lottie.y yVar = this.tf;
        if (yVar == null) {
            return 0.0f;
        }
        return (this.y - yVar.y()) / (this.tf.c() - this.tf.y());
    }

    @MainThread
    public void yo() {
        u(true);
    }

    public float zg() {
        com.bytedance.adsdk.lottie.y yVar = this.tf;
        if (yVar == null) {
            return 0.0f;
        }
        float f = this.d;
        return f == 2.14748365E9f ? yVar.c() : f;
    }

    @Override // com.bytedance.adsdk.lottie.kd.xj
    public void hf() {
        super.hf();
        hf(jk());
    }

    public void w(float f) {
        this.hf = f;
    }

    public void xj(float f) {
        if (this.kd == f) {
            return;
        }
        float hf = f.hf(f, qt(), zg());
        this.kd = hf;
        if (this.p) {
            hf = (float) Math.floor(hf);
        }
        this.y = hf;
        this.u = 0L;
        w();
    }

    public void xj(int i) {
        xj(i, (int) this.d);
    }

    public void xj(float f, float f2) {
        if (f <= f2) {
            com.bytedance.adsdk.lottie.y yVar = this.tf;
            float y = yVar == null ? -3.4028235E38f : yVar.y();
            com.bytedance.adsdk.lottie.y yVar2 = this.tf;
            float c = yVar2 == null ? Float.MAX_VALUE : yVar2.c();
            float hf = f.hf(f, y, c);
            float hf2 = f.hf(f2, y, c);
            if (hf == this.f && hf2 == this.d) {
                return;
            }
            this.f = hf;
            this.d = hf2;
            xj((int) f.hf(this.y, hf, hf2));
            return;
        }
        throw new IllegalArgumentException("minFrame (" + f + ") must be <= maxFrame (" + f2 + ")");
    }
}
