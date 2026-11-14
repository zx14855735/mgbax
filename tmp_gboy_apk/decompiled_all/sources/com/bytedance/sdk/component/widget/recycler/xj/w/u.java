package com.bytedance.sdk.component.widget.recycler.xj.w;

import android.view.View;
import android.view.ViewParent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private ViewParent hf;
    private int[] kd;
    private boolean u;
    private final View w;
    private ViewParent xj;

    public u(View view) {
        this.w = view;
    }

    private ViewParent u(int i) {
        if (i == 0) {
            return this.xj;
        }
        if (i != 1) {
            return null;
        }
        return this.hf;
    }

    public boolean hf() {
        return xj(0);
    }

    public void w() {
        w(0);
    }

    public void xj(boolean z) {
        if (this.u) {
            c.tf(this.w);
        }
        this.u = z;
    }

    public boolean hf(int i) {
        return xj(i, 0);
    }

    public void w(int i) {
        ViewParent u = u(i);
        if (u != null) {
            f.xj(u, this.w, i);
            xj(i, (ViewParent) null);
        }
    }

    public boolean xj() {
        return this.u;
    }

    public boolean xj(int i) {
        return u(i) != null;
    }

    public boolean xj(int i, int i2) {
        if (xj(i2)) {
            return true;
        }
        if (!xj()) {
            return false;
        }
        View view = this.w;
        for (ViewParent parent = this.w.getParent(); parent != null; parent = parent.getParent()) {
            if (f.xj(parent, view, this.w, i, i2)) {
                xj(i2, parent);
                f.hf(parent, view, this.w, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean xj(int i, int i2, int i3, int i4, int[] iArr) {
        return xj(i, i2, i3, i4, iArr, 0);
    }

    public boolean xj(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent u;
        int i6;
        int i7;
        if (!xj() || (u = u(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.w.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        f.xj(u, this.w, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.w.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean xj(int i, int i2, int[] iArr, int[] iArr2) {
        return xj(i, i2, iArr, iArr2, 0);
    }

    public boolean xj(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent u;
        int i4;
        int i5;
        if (!xj() || (u = u(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.w.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.kd == null) {
                this.kd = new int[2];
            }
            iArr = this.kd;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        f.xj(u, this.w, i, i2, iArr3, i3);
        if (iArr2 != null) {
            this.w.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean xj(float f, float f2, boolean z) {
        ViewParent u;
        if (!xj() || (u = u(0)) == null) {
            return false;
        }
        return f.xj(u, this.w, f, f2, z);
    }

    public boolean xj(float f, float f2) {
        ViewParent u;
        if (!xj() || (u = u(0)) == null) {
            return false;
        }
        return f.xj(u, this.w, f, f2);
    }

    private void xj(int i, ViewParent viewParent) {
        if (i == 0) {
            this.xj = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.hf = viewParent;
        }
    }
}
