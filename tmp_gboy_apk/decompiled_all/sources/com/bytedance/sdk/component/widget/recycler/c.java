package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.xj;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class c {
    final xj xj;

    public interface xj {
        xj.hf xj(int i, int i2, int i3, Object obj);

        void xj(xj.hf hfVar);
    }

    public c(xj xjVar) {
        this.xj = xjVar;
    }

    private void w(List<xj.hf> list, int i, xj.hf hfVar, int i2, xj.hf hfVar2) {
        int i3 = hfVar.u;
        int i4 = hfVar2.hf;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = hfVar.hf;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            hfVar.hf = i6 + hfVar2.u;
        }
        int i7 = hfVar2.hf;
        if (i7 <= i3) {
            hfVar.u = i3 + hfVar2.u;
        }
        hfVar2.hf = i7 + i5;
        list.set(i, hfVar2);
        list.set(i2, hfVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(java.util.List<com.bytedance.sdk.component.widget.recycler.xj.hf> r9, int r10, com.bytedance.sdk.component.widget.recycler.xj.hf r11, int r12, com.bytedance.sdk.component.widget.recycler.xj.hf r13) {
        /*
            r8 = this;
            int r0 = r11.u
            int r1 = r13.hf
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.hf = r1
            goto L20
        Ld:
            int r5 = r13.u
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.u = r5
            com.bytedance.sdk.component.widget.recycler.c$xj r0 = r8.xj
            int r1 = r11.hf
            java.lang.Object r5 = r13.w
            com.bytedance.sdk.component.widget.recycler.xj$hf r0 = r0.xj(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.hf
            int r5 = r13.hf
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.hf = r5
            goto L41
        L2b:
            int r6 = r13.u
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            com.bytedance.sdk.component.widget.recycler.c$xj r4 = r8.xj
            int r1 = r1 + r3
            java.lang.Object r3 = r13.w
            com.bytedance.sdk.component.widget.recycler.xj$hf r4 = r4.xj(r2, r1, r5, r3)
            int r1 = r13.u
            int r1 = r1 - r5
            r13.u = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.u
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            com.bytedance.sdk.component.widget.recycler.c$xj r11 = r8.xj
            r11.xj(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.c.hf(java.util.List, int, com.bytedance.sdk.component.widget.recycler.xj$hf, int, com.bytedance.sdk.component.widget.recycler.xj$hf):void");
    }

    public void xj(List<xj.hf> list) {
        while (true) {
            int hf = hf(list);
            if (hf == -1) {
                return;
            } else {
                xj(list, hf, hf + 1);
            }
        }
    }

    private void xj(List<xj.hf> list, int i, int i2) {
        xj.hf hfVar = list.get(i);
        xj.hf hfVar2 = list.get(i2);
        int i3 = hfVar2.xj;
        if (i3 == 1) {
            w(list, i, hfVar, i2, hfVar2);
        } else if (i3 == 2) {
            xj(list, i, hfVar, i2, hfVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            hf(list, i, hfVar, i2, hfVar2);
        }
    }

    public void xj(List<xj.hf> list, int i, xj.hf hfVar, int i2, xj.hf hfVar2) {
        boolean z;
        int i3 = hfVar.hf;
        int i4 = hfVar.u;
        boolean z2 = false;
        if (i3 < i4) {
            if (hfVar2.hf == i3 && hfVar2.u == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (hfVar2.hf == i4 + 1 && hfVar2.u == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = hfVar2.hf;
        if (i4 < i5) {
            hfVar2.hf = i5 - 1;
        } else {
            int i6 = hfVar2.u;
            if (i4 < i5 + i6) {
                hfVar2.u = i6 - 1;
                hfVar.xj = 2;
                hfVar.u = 1;
                if (hfVar2.u == 0) {
                    list.remove(i2);
                    this.xj.xj(hfVar2);
                    return;
                }
                return;
            }
        }
        int i7 = hfVar.hf;
        int i8 = hfVar2.hf;
        xj.hf hfVar3 = null;
        if (i7 <= i8) {
            hfVar2.hf = i8 + 1;
        } else {
            int i9 = hfVar2.u;
            if (i7 < i8 + i9) {
                hfVar3 = this.xj.xj(2, i7 + 1, (i8 + i9) - i7, null);
                hfVar2.u = hfVar.hf - hfVar2.hf;
            }
        }
        if (z2) {
            list.set(i, hfVar2);
            list.remove(i2);
            this.xj.xj(hfVar);
            return;
        }
        if (z) {
            if (hfVar3 != null) {
                int i10 = hfVar.hf;
                if (i10 > hfVar3.hf) {
                    hfVar.hf = i10 - hfVar3.u;
                }
                int i11 = hfVar.u;
                if (i11 > hfVar3.hf) {
                    hfVar.u = i11 - hfVar3.u;
                }
            }
            int i12 = hfVar.hf;
            if (i12 > hfVar2.hf) {
                hfVar.hf = i12 - hfVar2.u;
            }
            int i13 = hfVar.u;
            if (i13 > hfVar2.hf) {
                hfVar.u = i13 - hfVar2.u;
            }
        } else {
            if (hfVar3 != null) {
                int i14 = hfVar.hf;
                if (i14 >= hfVar3.hf) {
                    hfVar.hf = i14 - hfVar3.u;
                }
                int i15 = hfVar.u;
                if (i15 >= hfVar3.hf) {
                    hfVar.u = i15 - hfVar3.u;
                }
            }
            int i16 = hfVar.hf;
            if (i16 >= hfVar2.hf) {
                hfVar.hf = i16 - hfVar2.u;
            }
            int i17 = hfVar.u;
            if (i17 >= hfVar2.hf) {
                hfVar.u = i17 - hfVar2.u;
            }
        }
        list.set(i, hfVar2);
        if (hfVar.hf != hfVar.u) {
            list.set(i2, hfVar);
        } else {
            list.remove(i2);
        }
        if (hfVar3 != null) {
            list.add(i, hfVar3);
        }
    }

    private int hf(List<xj.hf> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).xj != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
