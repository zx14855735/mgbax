package com.bytedance.adsdk.ugeno.flexbox;

import J3FDQU.A2egSU;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.adsdk.ugeno.y.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class u {
    static final /* synthetic */ boolean w = true;
    long[] hf;
    private boolean[] kd;
    private final com.bytedance.adsdk.ugeno.flexbox.xj u;
    int[] xj;
    private long[] y;

    public static class hf implements Comparable<hf> {
        int hf;
        int xj;

        private hf() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Order{order=");
            sb.append(this.hf);
            sb.append(", index=");
            return A2egSU.B2KMhB(sb, this.xj, '}');
        }

        @Override // java.lang.Comparable
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compareTo(hf hfVar) {
            int i = this.hf;
            int i2 = hfVar.hf;
            return i != i2 ? i - i2 : this.xj - hfVar.xj;
        }
    }

    public static class xj {
        int hf;
        List<w> xj;

        public void xj() {
            this.xj = null;
            this.hf = 0;
        }
    }

    public u(com.bytedance.adsdk.ugeno.flexbox.xj xjVar) {
        this.u = xjVar;
    }

    private int kd(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        return z ? hfVar.am() : hfVar.g();
    }

    private int u(boolean z) {
        return z ? this.u.getPaddingBottom() : this.u.getPaddingEnd();
    }

    private int w(boolean z) {
        return z ? this.u.getPaddingTop() : this.u.getPaddingStart();
    }

    private int y(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        return z ? hfVar.zg() : hfVar.qt();
    }

    public int hf(long j) {
        return (int) (j >> 32);
    }

    public int xj(long j) {
        return (int) j;
    }

    public long hf(int i, int i2) {
        return (i & 4294967295L) | (i2 << 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] xj(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.u.getFlexItemCount();
        List<hf> hf2 = hf(flexItemCount);
        hf hfVar = new hf();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.hf)) {
            hfVar.hf = 1;
        } else {
            hfVar.hf = ((com.bytedance.adsdk.ugeno.flexbox.hf) layoutParams).w();
        }
        if (i == -1 || i == flexItemCount) {
            hfVar.xj = flexItemCount;
        } else if (i < this.u.getFlexItemCount()) {
            hfVar.xj = i;
            while (i < flexItemCount) {
                hf2.get(i).xj++;
                i++;
            }
        } else {
            hfVar.xj = flexItemCount;
        }
        hf2.add(hfVar);
        return xj(flexItemCount + 1, hf2, sparseIntArray);
    }

    private List<hf> hf(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) this.u.xj(i2).getLayoutParams();
            hf hfVar2 = new hf();
            hfVar2.hf = hfVar.w();
            hfVar2.xj = i2;
            arrayList.add(hfVar2);
        }
        return arrayList;
    }

    private int u(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        if (z) {
            return hfVar.qt();
        }
        return hfVar.zg();
    }

    private int w(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        if (z) {
            return hfVar.g();
        }
        return hfVar.am();
    }

    private void w(int i) {
        boolean[] zArr = this.kd;
        if (zArr == null) {
            this.kd = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.kd = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public boolean hf(SparseIntArray sparseIntArray) {
        int flexItemCount = this.u.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View xj2 = this.u.xj(i);
            if (xj2 != null && ((com.bytedance.adsdk.ugeno.flexbox.hf) xj2.getLayoutParams()).w() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void hf(xj xjVar, int i, int i2) {
        xj(xjVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<w>) null);
    }

    private int hf(boolean z) {
        if (z) {
            return this.u.getPaddingEnd();
        }
        return this.u.getPaddingBottom();
    }

    public int[] xj(SparseIntArray sparseIntArray) {
        int flexItemCount = this.u.getFlexItemCount();
        return xj(flexItemCount, hf(flexItemCount), sparseIntArray);
    }

    private int hf(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] xj(int i, List<hf> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (hf hfVar : list) {
            int i3 = hfVar.xj;
            iArr[i2] = i3;
            sparseIntArray.append(i3, hfVar.hf);
            i2++;
        }
        return iArr;
    }

    private int hf(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        if (z) {
            return hfVar.hf();
        }
        return hfVar.xj();
    }

    private void hf(int i, int i2, w wVar, int i3, int i4, boolean z) {
        float f;
        int i5;
        int i6;
        int i7 = wVar.kd;
        float f2 = wVar.p;
        if (f2 <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f2;
        wVar.kd = i4 + wVar.y;
        if (!z) {
            wVar.c = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < wVar.f) {
            int i10 = wVar.qt + i8;
            View hf2 = this.u.hf(i10);
            if (hf2 == null || hf2.getVisibility() == 8) {
                f = f3;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) hf2.getLayoutParams();
                int flexDirection = this.u.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = hf2.getMeasuredHeight();
                    long[] jArr = this.y;
                    if (jArr != null) {
                        measuredHeight = hf(jArr[i10]);
                    }
                    int measuredWidth = hf2.getMeasuredWidth();
                    long[] jArr2 = this.y;
                    if (jArr2 != null) {
                        measuredWidth = xj(jArr2[i10]);
                    }
                    if (!this.kd[i10] && hfVar.kd() > 0.0f) {
                        float kd = measuredHeight - (hfVar.kd() * f3);
                        if (i8 == wVar.f - 1) {
                            kd += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(kd);
                        if (round < hfVar.f()) {
                            round = hfVar.f();
                            this.kd[i10] = true;
                            wVar.p -= hfVar.kd();
                            z2 = true;
                        } else {
                            float f5 = (kd - round) + f4;
                            double d = f5;
                            if (d > 1.0d) {
                                round++;
                                f5 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f5 += 1.0f;
                            }
                            f4 = f5;
                        }
                        int xj2 = xj(i, hfVar, wVar.g);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        hf2.measure(xj2, makeMeasureSpec);
                        int measuredWidth2 = hf2.getMeasuredWidth();
                        int measuredHeight2 = hf2.getMeasuredHeight();
                        xj(i10, xj2, makeMeasureSpec, hf2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    i5 = Math.max(i9, hfVar.qt() + hfVar.g() + measuredWidth + this.u.xj(hf2));
                    wVar.kd = hfVar.zg() + hfVar.am() + measuredHeight + wVar.kd;
                    f = f3;
                } else {
                    int measuredWidth3 = hf2.getMeasuredWidth();
                    long[] jArr3 = this.y;
                    if (jArr3 != null) {
                        measuredWidth3 = xj(jArr3[i10]);
                    }
                    int measuredHeight3 = hf2.getMeasuredHeight();
                    long[] jArr4 = this.y;
                    f = f3;
                    if (jArr4 != null) {
                        measuredHeight3 = hf(jArr4[i10]);
                    }
                    if (!this.kd[i10] && hfVar.kd() > 0.0f) {
                        float kd2 = measuredWidth3 - (hfVar.kd() * f);
                        if (i8 == wVar.f - 1) {
                            kd2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(kd2);
                        if (round2 < hfVar.c()) {
                            i6 = hfVar.c();
                            this.kd[i10] = true;
                            wVar.p -= hfVar.kd();
                            z2 = true;
                        } else {
                            float f6 = (kd2 - round2) + f4;
                            double d2 = f6;
                            if (d2 > 1.0d) {
                                i6 = round2 + 1;
                                f6 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                i6 = round2 - 1;
                                f6 += 1.0f;
                            } else {
                                i6 = round2;
                            }
                            f4 = f6;
                        }
                        int hf3 = hf(i2, hfVar, wVar.g);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                        hf2.measure(makeMeasureSpec2, hf3);
                        int measuredWidth4 = hf2.getMeasuredWidth();
                        int measuredHeight4 = hf2.getMeasuredHeight();
                        xj(i10, makeMeasureSpec2, hf3, hf2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i9, hfVar.zg() + hfVar.am() + measuredHeight3 + this.u.xj(hf2));
                    wVar.kd = hfVar.qt() + hfVar.g() + measuredWidth3 + wVar.kd;
                    i5 = max;
                }
                wVar.c = Math.max(wVar.c, i5);
                i9 = i5;
            }
            i8++;
            f3 = f;
        }
        if (!z2 || i7 == wVar.kd) {
            return;
        }
        hf(i, i2, wVar, i3, i4, true);
    }

    public void xj(xj xjVar, int i, int i2) {
        xj(xjVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<w>) null);
    }

    public void xj(xj xjVar, int i, int i2, int i3, int i4, int i5, List<w> list) {
        int i6;
        xj xjVar2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        w wVar;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = i;
        boolean xj2 = this.u.xj();
        int mode = View.MeasureSpec.getMode(i19);
        int size = View.MeasureSpec.getSize(i19);
        List<w> arrayList = list == null ? new ArrayList() : list;
        xjVar.xj = arrayList;
        boolean z = i5 == -1;
        int xj3 = xj(xj2);
        int hf2 = hf(xj2);
        int w2 = w(xj2);
        int u = u(xj2);
        w wVar2 = new w();
        int i20 = i4;
        wVar2.qt = i20;
        int i21 = xj3 + hf2;
        wVar2.kd = i21;
        int flexItemCount = this.u.getFlexItemCount();
        boolean z2 = z;
        w wVar3 = wVar2;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = Integer.MIN_VALUE;
        while (true) {
            if (i20 >= flexItemCount) {
                i6 = i23;
                xjVar2 = xjVar;
                break;
            }
            View hf3 = this.u.hf(i20);
            if (hf3 == null) {
                if (xj(i20, flexItemCount, wVar3)) {
                    xj(arrayList, wVar3, i20, i22);
                }
                i7 = i21;
            } else {
                i7 = i21;
                if (hf3.getVisibility() == 8) {
                    wVar3.d++;
                    wVar3.f++;
                    if (xj(i20, flexItemCount, wVar3)) {
                        xj(arrayList, wVar3, i20, i22);
                    }
                } else {
                    if (hf3 instanceof CompoundButton) {
                        xj((CompoundButton) hf3);
                    }
                    com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) hf3.getLayoutParams();
                    int i26 = flexItemCount;
                    if (hfVar.y() == 4) {
                        wVar3.am.add(Integer.valueOf(i20));
                    }
                    int xj4 = xj(hfVar, xj2);
                    if (hfVar.pl() != -1.0f && mode == 1073741824) {
                        xj4 = Math.round(hfVar.pl() * size);
                    }
                    if (xj2) {
                        i8 = mode;
                        i11 = this.u.xj(i19, i7 + w(hfVar, true) + u(hfVar, true), xj4);
                        i9 = size;
                        i10 = i22;
                        int hf4 = this.u.hf(i2, w2 + u + kd(hfVar, true) + y(hfVar, true) + i22, hf(hfVar, true));
                        hf3.measure(i11, hf4);
                        xj(i20, i11, hf4, hf3);
                    } else {
                        i8 = mode;
                        i9 = size;
                        i10 = i22;
                        int xj5 = this.u.xj(i2, w2 + u + kd(hfVar, false) + y(hfVar, false) + i10, hf(hfVar, false));
                        int hf5 = this.u.hf(i19, i7 + w(hfVar, false) + u(hfVar, false), xj4);
                        hf3.measure(xj5, hf5);
                        xj(i20, xj5, hf5, hf3);
                        i11 = hf5;
                    }
                    xj(hf3, i20);
                    i23 = View.combineMeasuredStates(i23, hf3.getMeasuredState());
                    i12 = i20;
                    int i27 = i11;
                    w wVar4 = wVar3;
                    int i28 = i24;
                    i13 = i10;
                    size = i9;
                    if (xj(hf3, i8, size, wVar3.kd, xj(hf3, xj2) + w(hfVar, xj2) + u(hfVar, xj2), hfVar, i12, i28, arrayList.size())) {
                        if (wVar4.hf() > 0) {
                            xj(arrayList, wVar4, i12 > 0 ? i12 - 1 : 0, i13);
                            i18 = i13 + wVar4.c;
                        } else {
                            i18 = i13;
                        }
                        if (xj2) {
                            if (hfVar.hf() == -1) {
                                com.bytedance.adsdk.ugeno.flexbox.xj xjVar3 = this.u;
                                hf3.measure(i27, xjVar3.hf(i2, hfVar.zg() + hfVar.am() + xjVar3.getPaddingTop() + this.u.getPaddingBottom() + i18, hfVar.hf()));
                                xj(hf3, i12);
                            }
                        } else if (hfVar.xj() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.xj xjVar4 = this.u;
                            hf3.measure(xjVar4.xj(i2, hfVar.qt() + hfVar.g() + xjVar4.getPaddingLeft() + this.u.getPaddingRight() + i18, hfVar.xj()), i27);
                            xj(hf3, i12);
                        }
                        w wVar5 = new w();
                        wVar5.f = 1;
                        i14 = i7;
                        wVar5.kd = i14;
                        wVar5.qt = i12;
                        i13 = i18;
                        i16 = Integer.MIN_VALUE;
                        wVar = wVar5;
                        i15 = 0;
                    } else {
                        wVar = wVar4;
                        i14 = i7;
                        wVar.f++;
                        i15 = i28 + 1;
                        i16 = i25;
                    }
                    wVar.e |= hfVar.u() != 0.0f;
                    wVar.yo |= hfVar.kd() != 0.0f;
                    int[] iArr = this.xj;
                    if (iArr != null) {
                        iArr[i12] = arrayList.size();
                    }
                    wVar.kd = xj(hf3, xj2) + w(hfVar, xj2) + u(hfVar, xj2) + wVar.kd;
                    wVar.tf = hfVar.u() + wVar.tf;
                    wVar.p = hfVar.kd() + wVar.p;
                    this.u.xj(hf3, i12, i15, wVar);
                    int max = Math.max(i16, hf(hf3, xj2) + kd(hfVar, xj2) + y(hfVar, xj2) + this.u.xj(hf3));
                    wVar.c = Math.max(wVar.c, max);
                    if (xj2) {
                        if (this.u.getFlexWrap() != 2) {
                            wVar.f10067pl = Math.max(wVar.f10067pl, hfVar.am() + hf3.getBaseline());
                        } else {
                            wVar.f10067pl = Math.max(wVar.f10067pl, hfVar.zg() + (hf3.getMeasuredHeight() - hf3.getBaseline()));
                        }
                    }
                    i17 = i26;
                    if (xj(i12, i17, wVar)) {
                        xj(arrayList, wVar, i12, i13);
                        i13 += wVar.c;
                    }
                    if (i5 != -1 && arrayList.size() > 0) {
                        if (((w) A2egSU.AlLFFp(arrayList, 1)).zg >= i5 && i12 >= i5 && !z2) {
                            i13 = -wVar.xj();
                            z2 = true;
                        }
                    }
                    if (i13 > i3 && z2) {
                        xjVar2 = xjVar;
                        i6 = i23;
                        break;
                    }
                    i24 = i15;
                    i25 = max;
                    flexItemCount = i17;
                    i20 = i12 + 1;
                    i21 = i14;
                    wVar3 = wVar;
                    i22 = i13;
                    mode = i8;
                    i19 = i;
                }
            }
            i12 = i20;
            i8 = mode;
            i17 = flexItemCount;
            i13 = i22;
            i14 = i7;
            wVar = wVar3;
            flexItemCount = i17;
            i20 = i12 + 1;
            i21 = i14;
            wVar3 = wVar;
            i22 = i13;
            mode = i8;
            i19 = i;
        }
        xjVar2.hf = i6;
    }

    private int hf(int i, com.bytedance.adsdk.ugeno.flexbox.hf hfVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.xj xjVar = this.u;
        int hf2 = xjVar.hf(i, hfVar.zg() + hfVar.am() + xjVar.getPaddingTop() + this.u.getPaddingBottom() + i2, hfVar.hf());
        int size = View.MeasureSpec.getSize(hf2);
        if (size > hfVar.tf()) {
            return View.MeasureSpec.makeMeasureSpec(hfVar.tf(), View.MeasureSpec.getMode(hf2));
        }
        return size < hfVar.f() ? View.MeasureSpec.makeMeasureSpec(hfVar.f(), View.MeasureSpec.getMode(hf2)) : hf2;
    }

    public void hf(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.u.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            i4 = View.MeasureSpec.getMode(i);
            i5 = View.MeasureSpec.getSize(i);
        } else {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        }
        List<w> flexLinesInternal = this.u.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.u.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).c = i5 - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.u.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    w wVar = new w();
                    wVar.c = i7;
                    flexLinesInternal.add(0, wVar);
                    return;
                }
                if (alignContent == 2) {
                    this.u.setFlexLines(xj(flexLinesInternal, i5, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < i5) {
                        float size2 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size3 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i6 < size3) {
                            arrayList.add(flexLinesInternal.get(i6));
                            if (i6 != flexLinesInternal.size() - 1) {
                                w wVar2 = new w();
                                if (i6 == flexLinesInternal.size() - 2) {
                                    wVar2.c = Math.round(f + size2);
                                    f = 0.0f;
                                } else {
                                    wVar2.c = Math.round(size2);
                                }
                                int i8 = wVar2.c;
                                float f2 = (size2 - i8) + f;
                                if (f2 > 1.0f) {
                                    wVar2.c = i8 + 1;
                                    f2 -= 1.0f;
                                } else if (f2 < -1.0f) {
                                    wVar2.c = i8 - 1;
                                    f2 += 1.0f;
                                }
                                f = f2;
                                arrayList.add(wVar2);
                            }
                            i6++;
                        }
                        this.u.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i5) {
                        this.u.setFlexLines(xj(flexLinesInternal, i5, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    w wVar3 = new w();
                    wVar3.c = size4;
                    for (w wVar4 : flexLinesInternal) {
                        arrayList2.add(wVar3);
                        arrayList2.add(wVar4);
                        arrayList2.add(wVar3);
                    }
                    this.u.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i5) {
                    float size5 = (i5 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i6 < size6) {
                        w wVar5 = flexLinesInternal.get(i6);
                        float f4 = wVar5.c + size5;
                        if (i6 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int round = Math.round(f4);
                        float f5 = (f4 - round) + f3;
                        if (f5 > 1.0f) {
                            round++;
                            f5 -= 1.0f;
                        } else if (f5 < -1.0f) {
                            round--;
                            f5 += 1.0f;
                        }
                        f3 = f5;
                        wVar5.c = round;
                        i6++;
                    }
                }
            }
        }
    }

    private void xj(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) compoundButton.getLayoutParams();
        int c = hfVar.c();
        int f = hfVar.f();
        Drawable xj2 = com.bytedance.adsdk.ugeno.y.kd.xj(compoundButton);
        int minimumWidth = xj2 == null ? 0 : xj2.getMinimumWidth();
        int minimumHeight = xj2 != null ? xj2.getMinimumHeight() : 0;
        if (c == -1) {
            c = minimumWidth;
        }
        hfVar.xj(c);
        if (f == -1) {
            f = minimumHeight;
        }
        hfVar.hf(f);
    }

    private void hf(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) view.getLayoutParams();
        int min = Math.min(Math.max(((i - hfVar.g()) - hfVar.qt()) - this.u.xj(view), hfVar.c()), hfVar.d());
        long[] jArr = this.y;
        if (jArr != null) {
            measuredHeight = hf(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        xj(i2, makeMeasureSpec2, makeMeasureSpec, view);
    }

    private int xj(boolean z) {
        if (z) {
            return this.u.getPaddingStart();
        }
        return this.u.getPaddingTop();
    }

    private int xj(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int xj(com.bytedance.adsdk.ugeno.flexbox.hf hfVar, boolean z) {
        if (z) {
            return hfVar.xj();
        }
        return hfVar.hf();
    }

    private boolean xj(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.flexbox.hf hfVar, int i5, int i6, int i7) {
        if (this.u.getFlexWrap() == 0) {
            return false;
        }
        if (hfVar.p()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.u.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int xj2 = this.u.xj(view, i5, i6);
        if (xj2 > 0) {
            i4 += xj2;
        }
        return i2 < i3 + i4;
    }

    private boolean xj(int i, int i2, w wVar) {
        return i == i2 - 1 && wVar.hf() != 0;
    }

    private void xj(List<w> list, w wVar, int i, int i2) {
        wVar.g = i2;
        this.u.xj(wVar);
        wVar.zg = i;
        list.add(wVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.flexbox.hf r0 = (com.bytedance.adsdk.ugeno.flexbox.hf) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.c()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.c()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.d()
            if (r1 <= r3) goto L26
            int r1 = r0.d()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.f()
            if (r2 >= r5) goto L32
            int r2 = r0.f()
            goto L3e
        L32:
            int r5 = r0.tf()
            if (r2 <= r5) goto L3d
            int r2 = r0.tf()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.xj(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.u.xj(android.view.View, int):void");
    }

    public void xj(int i, int i2) {
        xj(i, i2, 0);
    }

    public void xj(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i4;
        int i5;
        w(this.u.getFlexItemCount());
        if (i3 >= this.u.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.u.getFlexDirection();
        int flexDirection2 = this.u.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.u.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.u.getPaddingLeft();
            paddingRight = this.u.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.u.getLargestMainSize();
            }
            paddingLeft = this.u.getPaddingTop();
            paddingRight = this.u.getPaddingBottom();
        }
        int i6 = paddingLeft + paddingRight;
        int i7 = size;
        int[] iArr = this.xj;
        int i8 = iArr != null ? iArr[i3] : 0;
        List<w> flexLinesInternal = this.u.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i8 < size2) {
            w wVar = flexLinesInternal.get(i8);
            int i9 = wVar.kd;
            if (i9 < i7 && wVar.e) {
                i4 = i;
                i5 = i2;
                xj(i4, i5, wVar, i7, i6, false);
            } else {
                i4 = i;
                i5 = i2;
                if (i9 > i7 && wVar.yo) {
                    hf(i4, i5, wVar, i7, i6, false);
                }
            }
            i8++;
            i = i4;
            i2 = i5;
        }
    }

    private void xj(int i, int i2, w wVar, int i3, int i4, boolean z) {
        int i5;
        float f;
        int i6;
        double d;
        double d2;
        float f2 = wVar.tf;
        if (f2 <= 0.0f || i3 < (i5 = wVar.kd)) {
            return;
        }
        float f3 = (i3 - i5) / f2;
        wVar.kd = i4 + wVar.y;
        if (!z) {
            wVar.c = Integer.MIN_VALUE;
        }
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        float f4 = 0.0f;
        while (i7 < wVar.f) {
            int i9 = wVar.qt + i7;
            View hf2 = this.u.hf(i9);
            if (hf2 == null || hf2.getVisibility() == 8) {
                f = f3;
                z2 = z2;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) hf2.getLayoutParams();
                int flexDirection = this.u.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = hf2.getMeasuredHeight();
                    long[] jArr = this.y;
                    if (jArr != null) {
                        measuredHeight = hf(jArr[i9]);
                    }
                    int measuredWidth = hf2.getMeasuredWidth();
                    long[] jArr2 = this.y;
                    f = f3;
                    boolean z3 = z2;
                    if (jArr2 != null) {
                        measuredWidth = xj(jArr2[i9]);
                    }
                    if (this.kd[i9] || hfVar.u() <= 0.0f) {
                        z2 = z3;
                    } else {
                        float u = (hfVar.u() * f) + measuredHeight;
                        if (i7 == wVar.f - 1) {
                            u += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(u);
                        if (round > hfVar.tf()) {
                            round = hfVar.tf();
                            this.kd[i9] = true;
                            wVar.tf -= hfVar.u();
                            z2 = true;
                        } else {
                            float f5 = (u - round) + f4;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                round++;
                                d2 = d3 - 1.0d;
                            } else {
                                if (d3 < -1.0d) {
                                    round--;
                                    d2 = d3 + 1.0d;
                                }
                                f4 = f5;
                                z2 = z3;
                            }
                            f5 = (float) d2;
                            f4 = f5;
                            z2 = z3;
                        }
                        int xj2 = xj(i, hfVar, wVar.g);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        hf2.measure(xj2, makeMeasureSpec);
                        int measuredWidth2 = hf2.getMeasuredWidth();
                        int measuredHeight2 = hf2.getMeasuredHeight();
                        xj(i9, xj2, makeMeasureSpec, hf2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    i6 = Math.max(i8, hfVar.qt() + hfVar.g() + measuredWidth + this.u.xj(hf2));
                    wVar.kd = hfVar.zg() + hfVar.am() + measuredHeight + wVar.kd;
                } else {
                    f = f3;
                    boolean z4 = z2;
                    int measuredWidth3 = hf2.getMeasuredWidth();
                    long[] jArr3 = this.y;
                    if (jArr3 != null) {
                        measuredWidth3 = xj(jArr3[i9]);
                    }
                    int measuredHeight3 = hf2.getMeasuredHeight();
                    long[] jArr4 = this.y;
                    if (jArr4 != null) {
                        measuredHeight3 = hf(jArr4[i9]);
                    }
                    if (this.kd[i9] || hfVar.u() <= 0.0f) {
                        z2 = z4;
                    } else {
                        float u2 = (hfVar.u() * f) + measuredWidth3;
                        if (i7 == wVar.f - 1) {
                            u2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(u2);
                        if (round2 > hfVar.d()) {
                            round2 = hfVar.d();
                            this.kd[i9] = true;
                            wVar.tf -= hfVar.u();
                            z2 = true;
                        } else {
                            float f6 = (u2 - round2) + f4;
                            double d4 = f6;
                            if (d4 > 1.0d) {
                                round2++;
                                d = d4 - 1.0d;
                            } else {
                                if (d4 < -1.0d) {
                                    round2--;
                                    d = d4 + 1.0d;
                                }
                                f4 = f6;
                                z2 = z4;
                            }
                            f6 = (float) d;
                            f4 = f6;
                            z2 = z4;
                        }
                        int hf3 = hf(i2, hfVar, wVar.g);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        hf2.measure(makeMeasureSpec2, hf3);
                        int measuredWidth4 = hf2.getMeasuredWidth();
                        int measuredHeight4 = hf2.getMeasuredHeight();
                        xj(i9, makeMeasureSpec2, hf3, hf2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i8, hfVar.zg() + hfVar.am() + measuredHeight3 + this.u.xj(hf2));
                    wVar.kd = hfVar.qt() + hfVar.g() + measuredWidth3 + wVar.kd;
                    i6 = max;
                }
                wVar.c = Math.max(wVar.c, i6);
                i8 = i6;
            }
            i7++;
            f3 = f;
        }
        if (!z2 || i5 == wVar.kd) {
            return;
        }
        xj(i, i2, wVar, i3, i4, true);
    }

    private int xj(int i, com.bytedance.adsdk.ugeno.flexbox.hf hfVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.xj xjVar = this.u;
        int xj2 = xjVar.xj(i, hfVar.qt() + hfVar.g() + xjVar.getPaddingLeft() + this.u.getPaddingRight() + i2, hfVar.xj());
        int size = View.MeasureSpec.getSize(xj2);
        if (size > hfVar.d()) {
            return View.MeasureSpec.makeMeasureSpec(hfVar.d(), View.MeasureSpec.getMode(xj2));
        }
        return size < hfVar.c() ? View.MeasureSpec.makeMeasureSpec(hfVar.c(), View.MeasureSpec.getMode(xj2)) : xj2;
    }

    private List<w> xj(List<w> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        w wVar = new w();
        wVar.c = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(wVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(wVar);
            }
        }
        return arrayList;
    }

    public void xj() {
        xj(0);
    }

    public void xj(int i) {
        View hf2;
        if (i >= this.u.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.u.getFlexDirection();
        if (this.u.getAlignItems() == 4) {
            int[] iArr = this.xj;
            List<w> flexLinesInternal = this.u.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                w wVar = flexLinesInternal.get(i2);
                int i3 = wVar.f;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = wVar.qt + i4;
                    if (i4 < this.u.getFlexItemCount() && (hf2 = this.u.hf(i5)) != null && hf2.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) hf2.getLayoutParams();
                        if (hfVar.y() == -1 || hfVar.y() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                                hf(hf2, wVar.c, i5);
                            } else {
                                xj(hf2, wVar.c, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (w wVar2 : this.u.getFlexLinesInternal()) {
            for (Integer num : wVar2.am) {
                View hf3 = this.u.hf(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                    }
                    hf(hf3, wVar2.c, num.intValue());
                } else {
                    xj(hf3, wVar2.c, num.intValue());
                }
            }
        }
    }

    private void xj(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) view.getLayoutParams();
        int min = Math.min(Math.max(((i - hfVar.am()) - hfVar.zg()) - this.u.xj(view), hfVar.f()), hfVar.tf());
        long[] jArr = this.y;
        if (jArr != null) {
            measuredWidth = xj(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        xj(i2, makeMeasureSpec, makeMeasureSpec2, view);
    }

    public void xj(View view, w wVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) view.getLayoutParams();
        int alignItems = this.u.getAlignItems();
        if (hfVar.y() != -1) {
            alignItems = hfVar.y();
        }
        int i5 = wVar.c;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.u.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - hfVar.zg(), i3, i6 - hfVar.zg());
                    return;
                }
                view.layout(i, hfVar.am() + view.getMeasuredHeight() + (i2 - i5), i3, hfVar.am() + view.getMeasuredHeight() + (i4 - i5));
                return;
            }
            if (alignItems == 2) {
                int am = ((hfVar.am() + (i5 - view.getMeasuredHeight())) - hfVar.zg()) / 2;
                if (this.u.getFlexWrap() != 2) {
                    int i7 = i2 + am;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - am;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.u.getFlexWrap() != 2) {
                    int max = Math.max(wVar.f10067pl - view.getBaseline(), hfVar.am());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = Math.max(view.getBaseline() + (wVar.f10067pl - view.getMeasuredHeight()), hfVar.zg());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.u.getFlexWrap() != 2) {
            view.layout(i, hfVar.am() + i2, i3, hfVar.am() + i4);
        } else {
            view.layout(i, i2 - hfVar.zg(), i3, i4 - hfVar.zg());
        }
    }

    public void xj(View view, w wVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.hf hfVar = (com.bytedance.adsdk.ugeno.flexbox.hf) view.getLayoutParams();
        int alignItems = this.u.getAlignItems();
        if (hfVar.y() != -1) {
            alignItems = hfVar.y();
        }
        int i5 = wVar.c;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - hfVar.qt(), i2, ((i3 + i5) - view.getMeasuredWidth()) - hfVar.qt(), i4);
                    return;
                }
                view.layout(hfVar.g() + view.getMeasuredWidth() + (i - i5), i2, hfVar.g() + view.getMeasuredWidth() + (i3 - i5), i4);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int xj2 = ((y.xj(marginLayoutParams) + (i5 - view.getMeasuredWidth())) - y.hf(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + xj2, i2, i3 + xj2, i4);
                    return;
                } else {
                    view.layout(i - xj2, i2, i3 - xj2, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(hfVar.g() + i, i2, hfVar.g() + i3, i4);
        } else {
            view.layout(i - hfVar.qt(), i2, i3 - hfVar.qt(), i4);
        }
    }

    private void xj(int i, int i2, int i3, View view) {
        long[] jArr = this.hf;
        if (jArr != null) {
            jArr[i] = hf(i2, i3);
        }
        long[] jArr2 = this.y;
        if (jArr2 != null) {
            jArr2[i] = hf(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
