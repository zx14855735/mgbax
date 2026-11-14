package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends RecyclerView.d implements RecyclerView.v.hf {
    final xj c;
    private final hf dk;
    private int et;
    f hf;
    private boolean ht;
    private boolean jk;
    int kd;
    private boolean pz;
    private boolean ra;
    int u;
    private boolean v;
    boolean w;
    int xj;
    u y;
    private w yo;

    public static class hf {
        public boolean hf;
        public boolean u;
        public boolean w;
        public int xj;

        public void xj() {
            this.xj = 0;
            this.hf = false;
            this.w = false;
            this.u = false;
        }
    }

    public static class u implements Parcelable {
        public static final Parcelable.Creator<u> CREATOR = new Parcelable.Creator<u>() { // from class: com.bytedance.sdk.component.widget.recycler.kd.u.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public u createFromParcel(Parcel parcel) {
                return new u(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public u[] newArray(int i) {
                return new u[i];
            }
        };
        int hf;
        boolean w;
        int xj;

        static {
            QPiMvY();
        }

        public u() {
        }

        private static /* synthetic */ void QPiMvY() {
            char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 27);
            }
            String str = new String(charArray);
            char[] charArray2 = "xwruro".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 27);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void hf() {
            this.xj = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.xj);
            parcel.writeInt(this.hf);
            parcel.writeInt(this.w ? 1 : 0);
        }

        public boolean xj() {
            return this.xj >= 0;
        }

        public u(Parcel parcel) {
            this.xj = parcel.readInt();
            this.hf = parcel.readInt();
            this.w = parcel.readInt() == 1;
        }
    }

    public static class w {
        int c;
        int hf;
        int kd;

        /* renamed from: pl, reason: collision with root package name */
        boolean f10252pl;
        int tf;
        int u;
        int w;
        int y;
        boolean xj = true;
        int f = 0;
        boolean d = false;
        List<RecyclerView.ra> p = null;

        private View hf() {
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                View view = this.p.get(i).xj;
                RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
                if (!tfVar.hf() && this.u == tfVar.u()) {
                    xj(view);
                    return view;
                }
            }
            return null;
        }

        public boolean xj(RecyclerView.jk jkVar) {
            int i = this.u;
            return i >= 0 && i < jkVar.u();
        }

        public View xj(RecyclerView.zg zgVar) {
            if (this.p != null) {
                return hf();
            }
            View hf = zgVar.hf(this.u);
            this.u += this.kd;
            return hf;
        }

        public View hf(View view) {
            int u;
            int size = this.p.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.p.get(i2).xj;
                RecyclerView.tf tfVar = (RecyclerView.tf) view3.getLayoutParams();
                if (view3 != view && !tfVar.hf() && (u = (tfVar.u() - this.u) * this.kd) >= 0 && u < i) {
                    if (u == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = u;
                }
            }
            return view2;
        }

        public void xj() {
            xj((View) null);
        }

        public void xj(View view) {
            View hf = hf(view);
            if (hf == null) {
                this.u = -1;
            } else {
                this.u = ((RecyclerView.tf) hf.getLayoutParams()).u();
            }
        }
    }

    public static class xj {
        int hf;
        boolean kd;
        boolean u;
        int w;
        f xj;

        public xj() {
            xj();
        }

        public void hf() {
            this.w = this.u ? this.xj.u() : this.xj.w();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.hf + ", mCoordinate=" + this.w + ", mLayoutFromEnd=" + this.u + ", mValid=" + this.kd + '}';
        }

        public void xj() {
            this.hf = -1;
            this.w = Integer.MIN_VALUE;
            this.u = false;
            this.kd = false;
        }

        public void hf(View view, int i) {
            if (this.u) {
                this.w = this.xj.hf() + this.xj.hf(view);
            } else {
                this.w = this.xj.xj(view);
            }
            this.hf = i;
        }

        public boolean xj(View view, RecyclerView.jk jkVar) {
            RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
            return !tfVar.hf() && tfVar.u() >= 0 && tfVar.u() < jkVar.u();
        }

        public void xj(View view, int i) {
            int hf = this.xj.hf();
            if (hf >= 0) {
                hf(view, i);
                return;
            }
            this.hf = i;
            if (this.u) {
                int u = (this.xj.u() - hf) - this.xj.hf(view);
                this.w = this.xj.u() - u;
                if (u > 0) {
                    int kd = this.w - this.xj.kd(view);
                    int w = this.xj.w();
                    int min = kd - (Math.min(this.xj.xj(view) - w, 0) + w);
                    if (min < 0) {
                        this.w = Math.min(u, -min) + this.w;
                        return;
                    }
                    return;
                }
                return;
            }
            int xj = this.xj.xj(view);
            int w2 = xj - this.xj.w();
            this.w = xj;
            if (w2 > 0) {
                int u2 = (this.xj.u() - Math.min(0, (this.xj.u() - hf) - this.xj.hf(view))) - (this.xj.kd(view) + xj);
                if (u2 < 0) {
                    this.w -= Math.min(w2, -u2);
                }
            }
        }
    }

    public kd(Context context) {
        this(context, 1, false);
    }

    private View a() {
        return f(this.w ? v() - 1 : 0);
    }

    private void c(int i, int i2) {
        this.yo.w = i2 - this.hf.w();
        w wVar = this.yo;
        wVar.u = i;
        wVar.kd = this.w ? 1 : -1;
        wVar.y = -1;
        wVar.hf = i2;
        wVar.c = Integer.MIN_VALUE;
    }

    private int d(RecyclerView.jk jkVar) {
        if (v() == 0) {
            return 0;
        }
        y();
        return tf.xj(jkVar, this.hf, xj(!this.ht, true), hf(!this.ht, true), this, this.ht, this.w);
    }

    private void ff() {
        if (this.xj == 1 || !kd()) {
            this.w = this.jk;
        } else {
            this.w = !this.jk;
        }
    }

    private int p(RecyclerView.jk jkVar) {
        if (v() == 0) {
            return 0;
        }
        y();
        return tf.hf(jkVar, this.hf, xj(!this.ht, true), hf(!this.ht, true), this, this.ht);
    }

    private int tf(RecyclerView.jk jkVar) {
        if (v() == 0) {
            return 0;
        }
        y();
        return tf.xj(jkVar, this.hf, xj(!this.ht, true), hf(!this.ht, true), this, this.ht);
    }

    private View wo() {
        return f(this.w ? 0 : v() - 1);
    }

    private void y(int i, int i2) {
        this.yo.w = this.hf.u() - i2;
        w wVar = this.yo;
        wVar.kd = this.w ? -1 : 1;
        wVar.u = i;
        wVar.y = 1;
        wVar.hf = i2;
        wVar.c = Integer.MIN_VALUE;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int f(RecyclerView.jk jkVar) {
        return p(jkVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public RecyclerView.tf hf() {
        return new RecyclerView.tf(-2, -2);
    }

    public boolean kd() {
        return e() == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public boolean pl() {
        return this.y == null && this.v == this.pz;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public boolean u() {
        return this.xj == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public boolean w() {
        return this.xj == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public boolean xj() {
        return true;
    }

    public kd(Context context, int i, boolean z) {
        this.xj = 1;
        this.jk = false;
        this.w = false;
        this.pz = false;
        this.ht = true;
        this.u = -1;
        this.kd = Integer.MIN_VALUE;
        this.y = null;
        this.c = new xj();
        this.dk = new hf();
        this.et = 2;
        xj(i);
        xj(z);
    }

    public boolean f() {
        return this.hf.f() == 0 && this.hf.kd() == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public View hf(int i) {
        int v = v();
        if (v == 0) {
            return null;
        }
        int u2 = i - u(f(0));
        if (u2 >= 0 && u2 < v) {
            View f = f(u2);
            if (u(f) == i) {
                return f;
            }
        }
        return super.hf(i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int kd(RecyclerView.jk jkVar) {
        return tf(jkVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void u(int i) {
        this.u = i;
        this.kd = Integer.MIN_VALUE;
        u uVar = this.y;
        if (uVar != null) {
            uVar.hf();
        }
        g();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v.hf
    public PointF w(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < u(f(0))) != this.w ? -1 : 1;
        return this.xj == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(RecyclerView recyclerView, RecyclerView.zg zgVar) {
        super.xj(recyclerView, zgVar);
        if (this.ra) {
            w(zgVar);
            zgVar.xj();
        }
    }

    private View f(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return xj(0, v());
    }

    public int kd(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.xj == 1) ? 1 : Integer.MIN_VALUE : this.xj == 0 ? 1 : Integer.MIN_VALUE : this.xj == 1 ? -1 : Integer.MIN_VALUE : this.xj == 0 ? -1 : Integer.MIN_VALUE : (this.xj != 1 && kd()) ? -1 : 1 : (this.xj != 1 && kd()) ? 1 : -1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public boolean d() {
        return (pz() == 1073741824 || jk() == 1073741824 || !l()) ? false : true;
    }

    public int p() {
        View xj2 = xj(v() - 1, -1, false, true);
        if (xj2 == null) {
            return -1;
        }
        return u(xj2);
    }

    public int tf() {
        View xj2 = xj(0, v(), false, true);
        if (xj2 == null) {
            return -1;
        }
        return u(xj2);
    }

    private View d(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return xj(v() - 1, -1);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int w(RecyclerView.jk jkVar) {
        return d(jkVar);
    }

    public void xj(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        xj((String) null);
        if (i != this.xj || this.hf == null) {
            f xj2 = f.xj(this, i);
            this.hf = xj2;
            this.c.xj = xj2;
            this.xj = i;
            g();
        }
    }

    public w c() {
        return new w();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void hf(RecyclerView.jk jkVar) {
        super.hf(jkVar);
        this.y = null;
        this.u = -1;
        this.kd = Integer.MIN_VALUE;
        this.c.xj();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int u(RecyclerView.jk jkVar) {
        return d(jkVar);
    }

    public int w(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        this.yo.xj = true;
        y();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        xj(i2, abs, true, jkVar);
        w wVar = this.yo;
        int xj2 = xj(zgVar, wVar, jkVar, false) + wVar.c;
        if (xj2 < 0) {
            return 0;
        }
        if (abs > xj2) {
            i = i2 * xj2;
        }
        this.hf.xj(-i);
        this.yo.tf = i;
        return i;
    }

    public void y() {
        if (this.yo == null) {
            this.yo = c();
        }
    }

    private View u(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return xj(zgVar, jkVar, 0, v(), jkVar.u());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int c(RecyclerView.jk jkVar) {
        return p(jkVar);
    }

    private View c(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return this.w ? d(zgVar, jkVar) : f(zgVar, jkVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int y(RecyclerView.jk jkVar) {
        return tf(jkVar);
    }

    private View y(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return this.w ? f(zgVar, jkVar) : d(zgVar, jkVar);
    }

    private View kd(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return xj(zgVar, jkVar, v() - 1, -1, jkVar.u());
    }

    private void hf(RecyclerView.zg zgVar, RecyclerView.jk jkVar, int i, int i2) {
        if (!jkVar.hf() || v() == 0 || jkVar.xj() || !pl()) {
            return;
        }
        List<RecyclerView.ra> w2 = zgVar.w();
        int size = w2.size();
        int u2 = u(f(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.ra raVar = w2.get(i5);
            if (!raVar.e()) {
                if ((raVar.u() < u2) != this.w) {
                    i3 += this.hf.kd(raVar.xj);
                } else {
                    i4 += this.hf.kd(raVar.xj);
                }
            }
        }
        this.yo.p = w2;
        if (i3 > 0) {
            c(u(a()), i);
            w wVar = this.yo;
            wVar.f = i3;
            wVar.w = 0;
            wVar.xj();
            xj(zgVar, this.yo, jkVar, false);
        }
        if (i4 > 0) {
            y(u(wo()), i2);
            w wVar2 = this.yo;
            wVar2.f = i4;
            wVar2.w = 0;
            wVar2.xj();
            xj(zgVar, this.yo, jkVar, false);
        }
        this.yo.p = null;
    }

    public void xj(boolean z) {
        xj((String) null);
        if (z != this.jk) {
            this.jk = z;
            g();
        }
    }

    private View w(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return this.w ? kd(zgVar, jkVar) : u(zgVar, jkVar);
    }

    public int xj(RecyclerView.jk jkVar) {
        if (jkVar.w()) {
            return this.hf.y();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(RecyclerView recyclerView, RecyclerView.jk jkVar, int i) {
        y yVar = new y(recyclerView.getContext());
        yVar.w(i);
        xj(yVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int xj2;
        int i6;
        View hf2;
        int xj3;
        int i7;
        if ((this.y != null || this.u != -1) && jkVar.u() == 0) {
            w(zgVar);
            return;
        }
        u uVar = this.y;
        if (uVar != null && uVar.xj()) {
            this.u = this.y.xj;
        }
        y();
        this.yo.xj = false;
        ff();
        View ai = ai();
        xj xjVar = this.c;
        if (xjVar.kd && this.u == -1 && this.y == null) {
            if (ai != null && (this.hf.xj(ai) >= this.hf.u() || this.hf.hf(ai) <= this.hf.w())) {
                this.c.xj(ai, u(ai));
            }
        } else {
            xjVar.xj();
            xj xjVar2 = this.c;
            xjVar2.u = this.w ^ this.pz;
            xj(zgVar, jkVar, xjVar2);
            this.c.kd = true;
        }
        int xj4 = xj(jkVar);
        if (this.yo.tf >= 0) {
            i = xj4;
            xj4 = 0;
        } else {
            i = 0;
        }
        int w2 = this.hf.w() + xj4;
        int c = this.hf.c() + i;
        if (jkVar.xj() && (i6 = this.u) != -1 && this.kd != Integer.MIN_VALUE && (hf2 = hf(i6)) != null) {
            if (this.w) {
                i7 = this.hf.u() - this.hf.hf(hf2);
                xj3 = this.kd;
            } else {
                xj3 = this.hf.xj(hf2) - this.hf.w();
                i7 = this.kd;
            }
            int i8 = i7 - xj3;
            if (i8 > 0) {
                w2 += i8;
            } else {
                c -= i8;
            }
        }
        xj(zgVar);
        this.yo.f10252pl = f();
        this.yo.d = jkVar.xj();
        xj xjVar3 = this.c;
        if (xjVar3.u) {
            hf(xjVar3);
            w wVar = this.yo;
            wVar.f = w2;
            xj(zgVar, wVar, jkVar, false);
            w wVar2 = this.yo;
            i3 = wVar2.hf;
            int i9 = wVar2.u;
            int i10 = wVar2.w;
            if (i10 > 0) {
                c += i10;
            }
            xj(this.c);
            w wVar3 = this.yo;
            wVar3.f = c;
            wVar3.u += wVar3.kd;
            xj(zgVar, wVar3, jkVar, false);
            w wVar4 = this.yo;
            i2 = wVar4.hf;
            int i11 = wVar4.w;
            if (i11 > 0) {
                c(i9, i3);
                w wVar5 = this.yo;
                wVar5.f = i11;
                xj(zgVar, wVar5, jkVar, false);
                i3 = this.yo.hf;
            }
        } else {
            xj(xjVar3);
            w wVar6 = this.yo;
            wVar6.f = c;
            xj(zgVar, wVar6, jkVar, false);
            w wVar7 = this.yo;
            i2 = wVar7.hf;
            int i12 = wVar7.u;
            int i13 = wVar7.w;
            if (i13 > 0) {
                w2 += i13;
            }
            hf(this.c);
            w wVar8 = this.yo;
            wVar8.f = w2;
            wVar8.u += wVar8.kd;
            xj(zgVar, wVar8, jkVar, false);
            w wVar9 = this.yo;
            int i14 = wVar9.hf;
            int i15 = wVar9.w;
            if (i15 > 0) {
                y(i12, i2);
                w wVar10 = this.yo;
                wVar10.f = i15;
                xj(zgVar, wVar10, jkVar, false);
                i2 = this.yo.hf;
            }
            i3 = i14;
        }
        if (v() > 0) {
            if (this.w ^ this.pz) {
                int xj5 = xj(i2, zgVar, jkVar, true);
                i4 = i3 + xj5;
                i5 = i2 + xj5;
                xj2 = hf(i4, zgVar, jkVar, false);
            } else {
                int hf3 = hf(i3, zgVar, jkVar, true);
                i4 = i3 + hf3;
                i5 = i2 + hf3;
                xj2 = xj(i5, zgVar, jkVar, false);
            }
            i3 = i4 + xj2;
            i2 = i5 + xj2;
        }
        hf(zgVar, jkVar, i3, i2);
        if (!jkVar.xj()) {
            this.hf.xj();
        } else {
            this.c.xj();
        }
        this.v = this.pz;
    }

    private boolean hf(RecyclerView.zg zgVar, RecyclerView.jk jkVar, xj xjVar) {
        if (v() == 0) {
            return false;
        }
        View ai = ai();
        if (ai != null && xjVar.xj(ai, jkVar)) {
            xjVar.xj(ai, u(ai));
            return true;
        }
        if (this.v != this.pz) {
            return false;
        }
        View hf2 = xjVar.u ? hf(zgVar, jkVar) : w(zgVar, jkVar);
        if (hf2 == null) {
            return false;
        }
        xjVar.hf(hf2, u(hf2));
        if (!jkVar.xj() && pl() && (this.hf.xj(hf2) >= this.hf.u() || this.hf.hf(hf2) < this.hf.w())) {
            xjVar.w = xjVar.u ? this.hf.u() : this.hf.w();
        }
        return true;
    }

    private int hf(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar, boolean z) {
        int w2;
        int w3 = i - this.hf.w();
        if (w3 <= 0) {
            return 0;
        }
        int i2 = -w(w3, zgVar, jkVar);
        int i3 = i + i2;
        if (!z || (w2 = i3 - this.hf.w()) <= 0) {
            return i2;
        }
        this.hf.xj(-w2);
        return i2 - w2;
    }

    private void hf(xj xjVar) {
        c(xjVar.hf, xjVar.w);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int hf(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        if (this.xj == 0) {
            return 0;
        }
        return w(i, zgVar, jkVar);
    }

    private void hf(RecyclerView.zg zgVar, int i) {
        int v = v();
        if (i >= 0) {
            int kd = this.hf.kd() - i;
            if (this.w) {
                for (int i2 = 0; i2 < v; i2++) {
                    View f = f(i2);
                    if (this.hf.xj(f) < kd || this.hf.u(f) < kd) {
                        xj(zgVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = v - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View f2 = f(i4);
                if (this.hf.xj(f2) < kd || this.hf.u(f2) < kd) {
                    xj(zgVar, i3, i4);
                    return;
                }
            }
        }
    }

    private View hf(boolean z, boolean z2) {
        int v;
        int i;
        if (this.w) {
            v = 0;
            i = v();
        } else {
            v = v() - 1;
            i = -1;
        }
        return xj(v, i, z, z2);
    }

    private View hf(RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        return this.w ? u(zgVar, jkVar) : kd(zgVar, jkVar);
    }

    private void xj(RecyclerView.zg zgVar, RecyclerView.jk jkVar, xj xjVar) {
        if (xj(jkVar, xjVar) || hf(zgVar, jkVar, xjVar)) {
            return;
        }
        xjVar.hf();
        xjVar.hf = this.pz ? jkVar.u() - 1 : 0;
    }

    private boolean xj(RecyclerView.jk jkVar, xj xjVar) {
        int i;
        if (!jkVar.xj() && (i = this.u) != -1) {
            if (i >= 0 && i < jkVar.u()) {
                xjVar.hf = this.u;
                u uVar = this.y;
                if (uVar != null && uVar.xj()) {
                    boolean z = this.y.w;
                    xjVar.u = z;
                    if (z) {
                        xjVar.w = this.hf.u() - this.y.hf;
                    } else {
                        xjVar.w = this.hf.w() + this.y.hf;
                    }
                    return true;
                }
                if (this.kd == Integer.MIN_VALUE) {
                    View hf2 = hf(this.u);
                    if (hf2 != null) {
                        if (this.hf.kd(hf2) > this.hf.y()) {
                            xjVar.hf();
                            return true;
                        }
                        if (this.hf.xj(hf2) - this.hf.w() < 0) {
                            xjVar.w = this.hf.w();
                            xjVar.u = false;
                            return true;
                        }
                        if (this.hf.u() - this.hf.hf(hf2) < 0) {
                            xjVar.w = this.hf.u();
                            xjVar.u = true;
                            return true;
                        }
                        xjVar.w = xjVar.u ? this.hf.hf() + this.hf.hf(hf2) : this.hf.xj(hf2);
                    } else {
                        if (v() > 0) {
                            xjVar.u = (this.u < u(f(0))) == this.w;
                        }
                        xjVar.hf();
                    }
                    return true;
                }
                boolean z2 = this.w;
                xjVar.u = z2;
                if (z2) {
                    xjVar.w = this.hf.u() - this.kd;
                } else {
                    xjVar.w = this.hf.w() + this.kd;
                }
                return true;
            }
            this.u = -1;
            this.kd = Integer.MIN_VALUE;
        }
        return false;
    }

    private int xj(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar, boolean z) {
        int u2;
        int u3 = this.hf.u() - i;
        if (u3 <= 0) {
            return 0;
        }
        int i2 = -w(-u3, zgVar, jkVar);
        int i3 = i + i2;
        if (!z || (u2 = this.hf.u() - i3) <= 0) {
            return i2;
        }
        this.hf.xj(u2);
        return u2 + i2;
    }

    private void xj(xj xjVar) {
        y(xjVar.hf, xjVar.w);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int xj(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        if (this.xj == 1) {
            return 0;
        }
        return w(i, zgVar, jkVar);
    }

    private void xj(int i, int i2, boolean z, RecyclerView.jk jkVar) {
        int w2;
        this.yo.f10252pl = f();
        this.yo.f = xj(jkVar);
        w wVar = this.yo;
        wVar.y = i;
        if (i == 1) {
            wVar.f = this.hf.c() + wVar.f;
            View wo = wo();
            w wVar2 = this.yo;
            wVar2.kd = this.w ? -1 : 1;
            int u2 = u(wo);
            w wVar3 = this.yo;
            wVar2.u = u2 + wVar3.kd;
            wVar3.hf = this.hf.hf(wo);
            w2 = this.hf.hf(wo) - this.hf.u();
        } else {
            View a2 = a();
            w wVar4 = this.yo;
            wVar4.f = this.hf.w() + wVar4.f;
            w wVar5 = this.yo;
            wVar5.kd = this.w ? 1 : -1;
            int u3 = u(a2);
            w wVar6 = this.yo;
            wVar5.u = u3 + wVar6.kd;
            wVar6.hf = this.hf.xj(a2);
            w2 = (-this.hf.xj(a2)) + this.hf.w();
        }
        w wVar7 = this.yo;
        wVar7.w = i2;
        if (z) {
            wVar7.w = i2 - w2;
        }
        wVar7.c = w2;
    }

    public void xj(RecyclerView.jk jkVar, w wVar, RecyclerView.d.xj xjVar) {
        int i = wVar.u;
        if (i < 0 || i >= jkVar.u()) {
            return;
        }
        xjVar.hf(i, Math.max(0, wVar.c));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(int i, RecyclerView.d.xj xjVar) {
        boolean z;
        int i2;
        u uVar = this.y;
        if (uVar != null && uVar.xj()) {
            u uVar2 = this.y;
            z = uVar2.w;
            i2 = uVar2.xj;
        } else {
            ff();
            z = this.w;
            i2 = this.u;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.et && i2 >= 0 && i2 < i; i4++) {
            xjVar.hf(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(int i, int i2, RecyclerView.jk jkVar, RecyclerView.d.xj xjVar) {
        if (this.xj != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        y();
        xj(i > 0 ? 1 : -1, Math.abs(i), true, jkVar);
        xj(jkVar, this.yo, xjVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(String str) {
        if (this.y == null) {
            super.xj(str);
        }
    }

    private void xj(RecyclerView.zg zgVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    xj(i, zgVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    xj(i3, zgVar);
                }
            }
        }
    }

    private void xj(RecyclerView.zg zgVar, int i) {
        if (i >= 0) {
            int v = v();
            if (!this.w) {
                for (int i2 = 0; i2 < v; i2++) {
                    View f = f(i2);
                    if (this.hf.hf(f) > i || this.hf.w(f) > i) {
                        xj(zgVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = v - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View f2 = f(i4);
                if (this.hf.hf(f2) > i || this.hf.w(f2) > i) {
                    xj(zgVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void xj(RecyclerView.zg zgVar, w wVar) {
        if (!wVar.xj || wVar.f10252pl) {
            return;
        }
        if (wVar.y == -1) {
            hf(zgVar, wVar.c);
        } else {
            xj(zgVar, wVar.c);
        }
    }

    public int xj(RecyclerView.zg zgVar, w wVar, RecyclerView.jk jkVar, boolean z) {
        int i = wVar.w;
        int i2 = wVar.c;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                wVar.c = i2 + i;
            }
            xj(zgVar, wVar);
        }
        int i3 = wVar.w + wVar.f;
        hf hfVar = this.dk;
        while (true) {
            if ((!wVar.f10252pl && i3 <= 0) || !wVar.xj(jkVar)) {
                break;
            }
            hfVar.xj();
            xj(zgVar, jkVar, wVar, hfVar);
            if (!hfVar.hf) {
                wVar.hf = (hfVar.xj * wVar.y) + wVar.hf;
                if (!hfVar.w || this.yo.p != null || !jkVar.xj()) {
                    int i4 = wVar.w;
                    int i5 = hfVar.xj;
                    wVar.w = i4 - i5;
                    i3 -= i5;
                }
                int i6 = wVar.c;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + hfVar.xj;
                    wVar.c = i7;
                    int i8 = wVar.w;
                    if (i8 < 0) {
                        wVar.c = i7 + i8;
                    }
                    xj(zgVar, wVar);
                }
                if (z && hfVar.u) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - wVar.w;
    }

    public void xj(RecyclerView.zg zgVar, RecyclerView.jk jkVar, w wVar, hf hfVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int dk;
        int y;
        int i5;
        int i6;
        View xj2 = wVar.xj(zgVar);
        if (xj2 == null) {
            hfVar.hf = true;
            return;
        }
        RecyclerView.tf tfVar = (RecyclerView.tf) xj2.getLayoutParams();
        if (wVar.p == null) {
            if (this.w == (wVar.y == -1)) {
                hf(xj2);
            } else {
                hf(xj2, 0);
            }
        } else {
            if (this.w == (wVar.y == -1)) {
                xj(xj2);
            } else {
                xj(xj2, 0);
            }
        }
        xj(xj2, 0, 0);
        hfVar.xj = this.hf.kd(xj2);
        if (this.xj == 1) {
            if (kd()) {
                y = ht() - io();
                dk = y - this.hf.y(xj2);
            } else {
                dk = dk();
                y = this.hf.y(xj2) + dk;
            }
            if (wVar.y == -1) {
                i6 = wVar.hf;
                i5 = i6 - hfVar.xj;
            } else {
                i5 = wVar.hf;
                i6 = hfVar.xj + i5;
            }
            int i7 = dk;
            i4 = i5;
            i3 = i7;
            i2 = i6;
            i = y;
        } else {
            int et = et();
            int y2 = this.hf.y(xj2) + et;
            if (wVar.y == -1) {
                int i8 = wVar.hf;
                i3 = i8 - hfVar.xj;
                i = i8;
                i2 = y2;
            } else {
                int i9 = wVar.hf;
                i = hfVar.xj + i9;
                i2 = y2;
                i3 = i9;
            }
            i4 = et;
        }
        xj(xj2, i3, i4, i, i2);
        if (tfVar.hf() || tfVar.w()) {
            hfVar.w = true;
        }
        hfVar.u = xj2.hasFocusable();
    }

    private View xj(boolean z, boolean z2) {
        int i;
        int v;
        if (this.w) {
            i = v() - 1;
            v = -1;
        } else {
            i = 0;
            v = v();
        }
        return xj(i, v, z, z2);
    }

    public View xj(RecyclerView.zg zgVar, RecyclerView.jk jkVar, int i, int i2, int i3) {
        y();
        int w2 = this.hf.w();
        int u2 = this.hf.u();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View f = f(i);
            int u3 = u(f);
            if (u3 >= 0 && u3 < i3) {
                if (((RecyclerView.tf) f.getLayoutParams()).hf()) {
                    if (view2 == null) {
                        view2 = f;
                    }
                } else {
                    if (this.hf.xj(f) < u2 && this.hf.hf(f) >= w2) {
                        return f;
                    }
                    if (view == null) {
                        view = f;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public View xj(int i, int i2, boolean z, boolean z2) {
        y();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        if (!z2) {
            i3 = 0;
        }
        return (this.xj == 0 ? this.tf : this.p).xj(i, i2, i4, i3);
    }

    public View xj(int i, int i2) {
        int i3;
        int i4;
        y();
        if (i2 > i || i2 < i) {
            if (this.hf.xj(f(i)) < this.hf.w()) {
                i3 = 16644;
                i4 = 16388;
            } else {
                i3 = 4161;
                i4 = 4097;
            }
            return (this.xj == 0 ? this.tf : this.p).xj(i, i2, i3, i4);
        }
        return f(i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public View xj(View view, int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        int kd;
        View y;
        View wo;
        ff();
        if (v() == 0 || (kd = kd(i)) == Integer.MIN_VALUE) {
            return null;
        }
        y();
        y();
        xj(kd, (int) (this.hf.y() * 0.33333334f), false, jkVar);
        w wVar = this.yo;
        wVar.c = Integer.MIN_VALUE;
        wVar.xj = false;
        xj(zgVar, wVar, jkVar, true);
        if (kd == -1) {
            y = c(zgVar, jkVar);
        } else {
            y = y(zgVar, jkVar);
        }
        if (kd == -1) {
            wo = a();
        } else {
            wo = wo();
        }
        if (!wo.hasFocusable()) {
            return y;
        }
        if (y == null) {
            return null;
        }
        return wo;
    }
}
