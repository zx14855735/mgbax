package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class hf {
    final xj hf = new xj();
    final List<View> w = new ArrayList();
    final InterfaceC0126hf xj;

    /* renamed from: com.bytedance.sdk.component.widget.recycler.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0126hf {
        View hf(int i);

        RecyclerView.ra hf(View view);

        void hf();

        void u(View view);

        void w(int i);

        void w(View view);

        int xj();

        int xj(View view);

        void xj(int i);

        void xj(View view, int i);

        void xj(View view, int i, ViewGroup.LayoutParams layoutParams);
    }

    public hf(InterfaceC0126hf interfaceC0126hf) {
        this.xj = interfaceC0126hf;
    }

    private void c(View view) {
        this.w.add(view);
        this.xj.w(view);
    }

    private boolean f(View view) {
        if (!this.w.remove(view)) {
            return false;
        }
        this.xj.u(view);
        return true;
    }

    private int y(int i) {
        if (i < 0) {
            return -1;
        }
        int xj2 = this.xj.xj();
        int i2 = i;
        while (i2 < xj2) {
            int kd = i - (i2 - this.hf.kd(i2));
            if (kd == 0) {
                while (this.hf.w(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += kd;
        }
        return -1;
    }

    public View hf(int i) {
        return this.xj.hf(y(i));
    }

    public void kd(int i) {
        int y = y(i);
        this.hf.u(y);
        this.xj.w(y);
    }

    public String toString() {
        return this.hf.toString() + ", hidden list:" + this.w.size();
    }

    public View u(int i) {
        return this.xj.hf(i);
    }

    public View w(int i) {
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.w.get(i2);
            RecyclerView.ra hf = this.xj.hf(view);
            if (hf.u() == i && !hf.am() && !hf.e()) {
                return view;
            }
        }
        return null;
    }

    public void xj(View view, boolean z) {
        xj(view, -1, z);
    }

    public static class xj {
        xj hf;
        long xj = 0;

        private void hf() {
            if (this.hf == null) {
                this.hf = new xj();
            }
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                hf();
                this.hf.insert(i - 64, z);
                return;
            }
            long j = this.xj;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.xj = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                xj(i);
            } else {
                hf(i);
            }
            if (z2 || this.hf != null) {
                hf();
                this.hf.insert(0, z2);
            }
        }

        public int kd(int i) {
            xj xjVar = this.hf;
            if (xjVar == null) {
                return i >= 64 ? Long.bitCount(this.xj) : Long.bitCount(this.xj & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.xj & ((1 << i) - 1));
            }
            return Long.bitCount(this.xj) + xjVar.kd(i - 64);
        }

        public String toString() {
            if (this.hf == null) {
                return Long.toBinaryString(this.xj);
            }
            return this.hf.toString() + "xx" + Long.toBinaryString(this.xj);
        }

        public boolean u(int i) {
            if (i >= 64) {
                hf();
                return this.hf.u(i - 64);
            }
            long j = 1 << i;
            long j2 = this.xj;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.xj = j3;
            long j4 = j - 1;
            this.xj = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            xj xjVar = this.hf;
            if (xjVar != null) {
                if (xjVar.w(0)) {
                    xj(63);
                }
                this.hf.u(0);
            }
            return z;
        }

        public boolean w(int i) {
            if (i < 64) {
                return (this.xj & (1 << i)) != 0;
            }
            hf();
            return this.hf.w(i - 64);
        }

        public void xj(int i) {
            if (i < 64) {
                this.xj |= 1 << i;
            } else {
                hf();
                this.hf.xj(i - 64);
            }
        }

        public void hf(int i) {
            if (i >= 64) {
                xj xjVar = this.hf;
                if (xjVar != null) {
                    xjVar.hf(i - 64);
                    return;
                }
                return;
            }
            this.xj &= ~(1 << i);
        }

        public void xj() {
            this.xj = 0L;
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.xj();
            }
        }
    }

    public void u(View view) {
        int xj2 = this.xj.xj(view);
        if (xj2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.hf.xj(xj2);
        c(view);
    }

    public void xj(View view, int i, boolean z) {
        int xj2 = i < 0 ? this.xj.xj() : y(i);
        this.hf.insert(xj2, z);
        if (z) {
            c(view);
        }
        this.xj.xj(view, xj2);
    }

    public int hf() {
        return this.xj.xj() - this.w.size();
    }

    public int hf(View view) {
        int xj2 = this.xj.xj(view);
        if (xj2 == -1 || this.hf.w(xj2)) {
            return -1;
        }
        return xj2 - this.hf.kd(xj2);
    }

    public void kd(View view) {
        int xj2 = this.xj.xj(view);
        if (xj2 >= 0) {
            if (this.hf.w(xj2)) {
                this.hf.hf(xj2);
                f(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
    }

    public boolean y(View view) {
        int xj2 = this.xj.xj(view);
        if (xj2 == -1) {
            f(view);
            return true;
        }
        if (!this.hf.w(xj2)) {
            return false;
        }
        this.hf.u(xj2);
        f(view);
        this.xj.xj(xj2);
        return true;
    }

    public int w() {
        return this.xj.xj();
    }

    public boolean w(View view) {
        return this.w.contains(view);
    }

    public void xj(View view) {
        int xj2 = this.xj.xj(view);
        if (xj2 >= 0) {
            if (this.hf.u(xj2)) {
                f(view);
            }
            this.xj.xj(xj2);
        }
    }

    public void xj(int i) {
        int y = y(i);
        View hf = this.xj.hf(y);
        if (hf != null) {
            if (this.hf.u(y)) {
                f(hf);
            }
            this.xj.xj(y);
        }
    }

    public void xj() {
        this.hf.xj();
        for (int size = this.w.size() - 1; size >= 0; size--) {
            this.xj.u(this.w.get(size));
            this.w.remove(size);
        }
        this.xj.hf();
    }

    public void xj(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int y;
        if (i < 0) {
            y = this.xj.xj();
        } else {
            y = y(i);
        }
        this.hf.insert(y, z);
        if (z) {
            c(view);
        }
        this.xj.xj(view, y, layoutParams);
    }
}
