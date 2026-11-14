package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class g {
    xj hf = new xj();
    final hf xj;

    public interface hf {
        int hf();

        int hf(View view);

        int xj();

        int xj(View view);

        View xj(int i);
    }

    public static class xj {
        int hf;
        int kd;
        int u;
        int w;
        int xj = 0;

        public boolean hf() {
            int i = this.xj;
            if ((i & 7) != 0 && (i & xj(this.u, this.hf)) == 0) {
                return false;
            }
            int i2 = this.xj;
            if ((i2 & AdEventType.AD_TICK) != 0 && (i2 & (xj(this.u, this.w) << 4)) == 0) {
                return false;
            }
            int i3 = this.xj;
            if ((i3 & 1792) != 0 && (i3 & (xj(this.kd, this.hf) << 8)) == 0) {
                return false;
            }
            int i4 = this.xj;
            return (i4 & 28672) == 0 || (i4 & (xj(this.kd, this.w) << 12)) != 0;
        }

        public int xj(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void xj(int i, int i2, int i3, int i4) {
            this.hf = i;
            this.w = i2;
            this.u = i3;
            this.kd = i4;
        }

        public void xj(int i) {
            this.xj = i | this.xj;
        }

        public void xj() {
            this.xj = 0;
        }
    }

    public g(hf hfVar) {
        this.xj = hfVar;
    }

    public View xj(int i, int i2, int i3, int i4) {
        int xj2 = this.xj.xj();
        int hf2 = this.xj.hf();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View xj3 = this.xj.xj(i);
            this.hf.xj(xj2, hf2, this.xj.xj(xj3), this.xj.hf(xj3));
            if (i3 != 0) {
                this.hf.xj();
                this.hf.xj(i3);
                if (this.hf.hf()) {
                    return xj3;
                }
            }
            if (i4 != 0) {
                this.hf.xj();
                this.hf.xj(i4);
                if (this.hf.hf()) {
                    view = xj3;
                }
            }
            i += i5;
        }
        return view;
    }
}
