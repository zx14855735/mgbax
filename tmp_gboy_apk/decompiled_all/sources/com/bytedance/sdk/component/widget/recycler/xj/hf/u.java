package com.bytedance.sdk.component.widget.recycler.xj.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {

    public interface xj<T> {
        T xj();

        boolean xj(T t);
    }

    public static class hf<T> implements xj<T> {
        private int hf;
        private final Object[] xj;

        public hf(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.xj = new Object[i];
        }

        private boolean hf(T t) {
            for (int i = 0; i < this.hf; i++) {
                if (this.xj[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.xj.hf.u.xj
        public T xj() {
            int i = this.hf;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.xj;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.hf = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.xj.hf.u.xj
        public boolean xj(T t) {
            if (!hf(t)) {
                int i = this.hf;
                Object[] objArr = this.xj;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.hf = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
