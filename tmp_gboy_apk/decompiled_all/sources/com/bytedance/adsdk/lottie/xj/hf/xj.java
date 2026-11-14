package com.bytedance.adsdk.lottie.xj.hf;

import J3FDQU.A2egSU;
import android.view.animation.Interpolator;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj<K, A> {
    private final w<K> kd;
    protected com.bytedance.adsdk.lottie.y.w<A> w;
    final List<InterfaceC0024xj> xj = new ArrayList(1);
    private boolean u = false;
    protected float hf = 0.0f;
    private A y = null;
    private float c = -1.0f;
    private float f = -1.0f;

    public static final class hf<T> implements w<T> {
        private hf() {
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public com.bytedance.adsdk.lottie.y.xj<T> hf() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float u() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float w() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean hf(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj(float f) {
            return false;
        }
    }

    public static final class kd<T> implements w<T> {
        private float hf = -1.0f;
        private final com.bytedance.adsdk.lottie.y.xj<T> xj;

        public kd(List<? extends com.bytedance.adsdk.lottie.y.xj<T>> list) {
            this.xj = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public com.bytedance.adsdk.lottie.y.xj<T> hf() {
            return this.xj;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float u() {
            return this.xj.u();
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float w() {
            return this.xj.w();
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean hf(float f) {
            if (this.hf == f) {
                return true;
            }
            this.hf = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj(float f) {
            return !this.xj.kd();
        }
    }

    public static final class u<T> implements w<T> {
        private final List<? extends com.bytedance.adsdk.lottie.y.xj<T>> xj;
        private com.bytedance.adsdk.lottie.y.xj<T> w = null;
        private float u = -1.0f;
        private com.bytedance.adsdk.lottie.y.xj<T> hf = w(0.0f);

        public u(List<? extends com.bytedance.adsdk.lottie.y.xj<T>> list) {
            this.xj = list;
        }

        private com.bytedance.adsdk.lottie.y.xj<T> w(float f) {
            com.bytedance.adsdk.lottie.y.xj<T> xjVar = (com.bytedance.adsdk.lottie.y.xj) A2egSU.AlLFFp(this.xj, 1);
            if (f >= xjVar.w()) {
                return xjVar;
            }
            for (int size = this.xj.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.y.xj<T> xjVar2 = this.xj.get(size);
                if (this.hf != xjVar2 && xjVar2.xj(f)) {
                    return xjVar2;
                }
            }
            return this.xj.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public com.bytedance.adsdk.lottie.y.xj<T> hf() {
            return this.hf;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float u() {
            return ((com.bytedance.adsdk.lottie.y.xj) A2egSU.AlLFFp(this.xj, 1)).u();
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean hf(float f) {
            com.bytedance.adsdk.lottie.y.xj<T> xjVar = this.w;
            com.bytedance.adsdk.lottie.y.xj<T> xjVar2 = this.hf;
            if (xjVar == xjVar2 && this.u == f) {
                return true;
            }
            this.w = xjVar2;
            this.u = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public boolean xj(float f) {
            if (this.hf.xj(f)) {
                return !this.hf.kd();
            }
            this.hf = w(f);
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.xj.hf.xj.w
        public float w() {
            return this.xj.get(0).w();
        }
    }

    public interface w<T> {
        com.bytedance.adsdk.lottie.y.xj<T> hf();

        boolean hf(float f);

        @FloatRange(from = 0.0d, to = 1.0d)
        float u();

        @FloatRange(from = 0.0d, to = 1.0d)
        float w();

        boolean xj();

        boolean xj(float f);
    }

    /* renamed from: com.bytedance.adsdk.lottie.xj.hf.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0024xj {
        void xj();
    }

    public xj(List<? extends com.bytedance.adsdk.lottie.y.xj<K>> list) {
        this.kd = xj(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float d() {
        if (this.c == -1.0f) {
            this.c = this.kd.w();
        }
        return this.c;
    }

    public A c() {
        float u2 = u();
        if (this.w == null && this.kd.hf(u2)) {
            return this.y;
        }
        com.bytedance.adsdk.lottie.y.xj<K> w2 = w();
        Interpolator interpolator = w2.u;
        A xj = (interpolator == null || w2.kd == null) ? xj(w2, kd()) : xj(w2, u2, interpolator.getInterpolation(u2), w2.kd.getInterpolation(u2));
        this.y = xj;
        return xj;
    }

    public float f() {
        return this.hf;
    }

    public void hf() {
        for (int i = 0; i < this.xj.size(); i++) {
            this.xj.get(i).xj();
        }
    }

    public float kd() {
        com.bytedance.adsdk.lottie.y.xj<K> w2 = w();
        if (w2 == null || w2.kd()) {
            return 0.0f;
        }
        return w2.w.getInterpolation(u());
    }

    public float u() {
        if (this.u) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.y.xj<K> w2 = w();
        if (w2.kd()) {
            return 0.0f;
        }
        return (this.hf - w2.w()) / (w2.u() - w2.w());
    }

    public com.bytedance.adsdk.lottie.y.xj<K> w() {
        com.bytedance.adsdk.lottie.kd.xj("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.y.xj<K> hf2 = this.kd.hf();
        com.bytedance.adsdk.lottie.kd.hf("BaseKeyframeAnimation#getCurrentKeyframe");
        return hf2;
    }

    public abstract A xj(com.bytedance.adsdk.lottie.y.xj<K> xjVar, float f);

    public void xj() {
        this.u = true;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float y() {
        if (this.f == -1.0f) {
            this.f = this.kd.u();
        }
        return this.f;
    }

    public void xj(InterfaceC0024xj interfaceC0024xj) {
        this.xj.add(interfaceC0024xj);
    }

    public void xj(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.kd.xj()) {
            return;
        }
        if (f < d()) {
            f = d();
        } else if (f > y()) {
            f = y();
        }
        if (f == this.hf) {
            return;
        }
        this.hf = f;
        if (this.kd.xj(f)) {
            hf();
        }
    }

    public A xj(com.bytedance.adsdk.lottie.y.xj<K> xjVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> w<T> xj(List<? extends com.bytedance.adsdk.lottie.y.xj<T>> list) {
        if (list.isEmpty()) {
            return new hf();
        }
        if (list.size() == 1) {
            return new kd(list);
        }
        return new u(list);
    }
}
