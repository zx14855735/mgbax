package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.c;
import com.bytedance.sdk.component.widget.recycler.xj.hf.u;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class xj implements c.xj {
    private u.xj<hf> c;
    private int f;
    final ArrayList<hf> hf;
    final boolean kd;
    Runnable u;
    final InterfaceC0127xj w;
    final ArrayList<hf> xj;
    final c y;

    public static class hf {
        int hf;
        int u;
        Object w;
        int xj;

        public hf(int i, int i2, int i3, Object obj) {
            this.xj = i;
            this.hf = i2;
            this.u = i3;
            this.w = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            hf hfVar = (hf) obj;
            int i = this.xj;
            if (i != hfVar.xj) {
                return false;
            }
            if (i == 8 && Math.abs(this.u - this.hf) == 1 && this.u == hfVar.hf && this.hf == hfVar.u) {
                return true;
            }
            if (this.u != hfVar.u || this.hf != hfVar.hf) {
                return false;
            }
            Object obj2 = this.w;
            if (obj2 != null) {
                if (!obj2.equals(hfVar.w)) {
                    return false;
                }
            } else if (hfVar.w != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.xj * 31) + this.hf) * 31) + this.u;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + xj() + ",s:" + this.hf + "c:" + this.u + ",p:" + this.w + "]";
        }

        public String xj() {
            int i = this.xj;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : t.w : "add";
        }
    }

    /* renamed from: com.bytedance.sdk.component.widget.recycler.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0127xj {
        void hf(int i, int i2);

        void u(int i, int i2);

        void w(int i, int i2);

        RecyclerView.ra xj(int i);

        void xj(int i, int i2);

        void xj(int i, int i2, Object obj);
    }

    public xj(InterfaceC0127xj interfaceC0127xj) {
        this(interfaceC0127xj, false);
    }

    private void c(hf hfVar) {
        this.hf.add(hfVar);
        int i = hfVar.xj;
        if (i == 1) {
            this.w.w(hfVar.hf, hfVar.u);
            return;
        }
        if (i == 2) {
            this.w.hf(hfVar.hf, hfVar.u);
        } else if (i == 4) {
            this.w.xj(hfVar.hf, hfVar.u, hfVar.w);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(hfVar)));
            }
            this.w.u(hfVar.hf, hfVar.u);
        }
    }

    private void kd(hf hfVar) {
        int i;
        int i2 = hfVar.xj;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int hf2 = hf(hfVar.hf, i2);
        int i3 = hfVar.hf;
        int i4 = hfVar.xj;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(hfVar)));
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < hfVar.u; i6++) {
            int hf3 = hf((i * i6) + hfVar.hf, hfVar.xj);
            int i7 = hfVar.xj;
            if (i7 == 2 ? hf3 != hf2 : !(i7 == 4 && hf3 == hf2 + 1)) {
                hf xj = xj(i7, hf2, i5, hfVar.w);
                xj(xj, i3);
                xj(xj);
                if (hfVar.xj == 4) {
                    i3 += i5;
                }
                hf2 = hf3;
                i5 = 1;
            } else {
                i5++;
            }
        }
        Object obj = hfVar.w;
        xj(hfVar);
        if (i5 > 0) {
            hf xj2 = xj(hfVar.xj, hf2, i5, obj);
            xj(xj2, i3);
            xj(xj2);
        }
    }

    private void u(hf hfVar) {
        int i = hfVar.hf;
        int i2 = hfVar.u + i;
        int i3 = i;
        char c = 65535;
        int i4 = 0;
        while (i < i2) {
            if (this.w.xj(i) != null || u(i)) {
                if (c == 0) {
                    kd(xj(4, i3, i4, hfVar.w));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    c(xj(4, i3, i4, hfVar.w));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != hfVar.u) {
            Object obj = hfVar.w;
            xj(hfVar);
            hfVar = xj(4, i3, i4, obj);
        }
        if (c == 0) {
            kd(hfVar);
        } else {
            c(hfVar);
        }
    }

    private void y(hf hfVar) {
        c(hfVar);
    }

    public void hf() {
        this.y.xj(this.xj);
        int size = this.xj.size();
        for (int i = 0; i < size; i++) {
            hf hfVar = this.xj.get(i);
            int i2 = hfVar.xj;
            if (i2 == 1) {
                y(hfVar);
            } else if (i2 == 2) {
                w(hfVar);
            } else if (i2 == 4) {
                u(hfVar);
            } else if (i2 == 8) {
                hf(hfVar);
            }
            Runnable runnable = this.u;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.xj.clear();
    }

    public void w() {
        int size = this.hf.size();
        for (int i = 0; i < size; i++) {
            this.hf.get(i);
        }
        xj(this.hf);
        this.f = 0;
    }

    public void xj() {
        xj(this.xj);
        xj(this.hf);
        this.f = 0;
    }

    public xj(InterfaceC0127xj interfaceC0127xj, boolean z) {
        this.c = new u.hf(30);
        this.xj = new ArrayList<>();
        this.hf = new ArrayList<>();
        this.f = 0;
        this.w = interfaceC0127xj;
        this.kd = z;
        this.y = new c(this);
    }

    public boolean y() {
        return (this.hf.isEmpty() || this.xj.isEmpty()) ? false : true;
    }

    public void xj(hf hfVar, int i) {
        int i2 = hfVar.xj;
        if (i2 == 2) {
            this.w.xj(i, hfVar.u);
        } else {
            if (i2 == 4) {
                this.w.xj(i, hfVar.u, hfVar.w);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void w(hf hfVar) {
        boolean z;
        char c;
        int i = hfVar.hf;
        int i2 = hfVar.u + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.w.xj(i3) != null || u(i3)) {
                if (c2 == 0) {
                    kd(xj(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    c(xj(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != hfVar.u) {
            xj(hfVar);
            hfVar = xj(2, i, i4, null);
        }
        if (c2 == 0) {
            kd(hfVar);
        } else {
            c(hfVar);
        }
    }

    public boolean xj(int i) {
        return (i & this.f) != 0;
    }

    public int xj(int i, int i2) {
        int size = this.hf.size();
        while (i2 < size) {
            hf hfVar = this.hf.get(i2);
            int i3 = hfVar.xj;
            if (i3 == 8) {
                int i4 = hfVar.hf;
                if (i4 == i) {
                    i = hfVar.u;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (hfVar.u <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = hfVar.hf;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = hfVar.u;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += hfVar.u;
                }
            }
            i2++;
        }
        return i;
    }

    private void hf(hf hfVar) {
        c(hfVar);
    }

    private int hf(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.hf.size() - 1; size >= 0; size--) {
            hf hfVar = this.hf.get(size);
            int i5 = hfVar.xj;
            if (i5 == 8) {
                int i6 = hfVar.hf;
                int i7 = hfVar.u;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            hfVar.hf = i6 + 1;
                            hfVar.u = i7 + 1;
                        } else if (i2 == 2) {
                            hfVar.hf = i6 - 1;
                            hfVar.u = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        hfVar.u = i7 + 1;
                    } else if (i2 == 2) {
                        hfVar.u = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        hfVar.hf = i6 + 1;
                    } else if (i2 == 2) {
                        hfVar.hf = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = hfVar.hf;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= hfVar.u;
                    } else if (i5 == 2) {
                        i += hfVar.u;
                    }
                } else if (i2 == 1) {
                    hfVar.hf = i8 + 1;
                } else if (i2 == 2) {
                    hfVar.hf = i8 - 1;
                }
            }
        }
        for (int size2 = this.hf.size() - 1; size2 >= 0; size2--) {
            hf hfVar2 = this.hf.get(size2);
            if (hfVar2.xj == 8) {
                int i9 = hfVar2.u;
                if (i9 == hfVar2.hf || i9 < 0) {
                    this.hf.remove(size2);
                    xj(hfVar2);
                }
            } else if (hfVar2.u <= 0) {
                this.hf.remove(size2);
                xj(hfVar2);
            }
        }
        return i;
    }

    private boolean u(int i) {
        int size = this.hf.size();
        for (int i2 = 0; i2 < size; i2++) {
            hf hfVar = this.hf.get(i2);
            int i3 = hfVar.xj;
            if (i3 == 8) {
                if (xj(hfVar.u, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = hfVar.hf;
                int i5 = hfVar.u + i4;
                while (i4 < i5) {
                    if (xj(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public int w(int i) {
        int size = this.xj.size();
        for (int i2 = 0; i2 < size; i2++) {
            hf hfVar = this.xj.get(i2);
            int i3 = hfVar.xj;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = hfVar.hf;
                    if (i4 <= i) {
                        int i5 = hfVar.u;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = hfVar.hf;
                    if (i6 == i) {
                        i = hfVar.u;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (hfVar.u <= i) {
                            i++;
                        }
                    }
                }
            } else if (hfVar.hf <= i) {
                i += hfVar.u;
            }
        }
        return i;
    }

    public boolean xj(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.xj.add(xj(4, i, i2, obj));
        this.f |= 4;
        return this.xj.size() == 1;
    }

    public void kd() {
        w();
        int size = this.xj.size();
        for (int i = 0; i < size; i++) {
            hf hfVar = this.xj.get(i);
            int i2 = hfVar.xj;
            if (i2 == 1) {
                this.w.w(hfVar.hf, hfVar.u);
            } else if (i2 == 2) {
                this.w.xj(hfVar.hf, hfVar.u);
            } else if (i2 == 4) {
                this.w.xj(hfVar.hf, hfVar.u, hfVar.w);
            } else if (i2 == 8) {
                this.w.u(hfVar.hf, hfVar.u);
            }
            Runnable runnable = this.u;
            if (runnable != null) {
                runnable.run();
            }
        }
        xj(this.xj);
        this.f = 0;
    }

    public boolean u() {
        return this.xj.size() > 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xj
    public hf xj(int i, int i2, int i3, Object obj) {
        hf xj = this.c.xj();
        if (xj == null) {
            return new hf(i, i2, i3, obj);
        }
        xj.xj = i;
        xj.hf = i2;
        xj.u = i3;
        xj.w = obj;
        return xj;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xj
    public void xj(hf hfVar) {
        if (this.kd) {
            return;
        }
        hfVar.w = null;
        this.c.xj(hfVar);
    }

    public void xj(List<hf> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            xj(list.get(i));
        }
        list.clear();
    }

    public int hf(int i) {
        return xj(i, 0);
    }
}
