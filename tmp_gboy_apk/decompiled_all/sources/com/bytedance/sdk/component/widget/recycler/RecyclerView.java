package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.am;
import com.bytedance.sdk.component.widget.recycler.g;
import com.bytedance.sdk.component.widget.recycler.hf;
import com.bytedance.sdk.component.widget.recycler.u;
import com.bytedance.sdk.component.widget.recycler.xj;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.xj.w.w {
    private static final boolean eu;
    static final boolean hf;
    private static final Class<?>[] tj;
    static final boolean u;
    static final boolean w;
    static final Interpolator wo;
    private static final boolean ws;
    static final boolean xj;

    /* renamed from: a, reason: collision with root package name */
    final List<ra> f10246a;
    u.xj ai;
    d am;
    private int aq;
    private kd bl;
    com.bytedance.sdk.component.widget.recycler.hf c;
    private int cy;
    boolean d;
    private am da;
    private int dc;
    boolean dk;
    private int dq;
    boolean e;
    boolean en;
    y et;
    final com.bytedance.sdk.component.widget.recycler.am f;
    final int[] ff;
    private final int ft;
    xj g;
    private EdgeEffect gh;
    private int gj;
    private int gy;
    private int h;
    private final ArrayList<g> hl;
    boolean ht;
    private final int[] i;

    /* renamed from: io, reason: collision with root package name */
    final ht f10247io;
    boolean j;
    boolean jk;
    private boolean k;
    final zg kd;
    final int[] l;
    private y.xj le;
    private Runnable lm;
    private EdgeEffect lw;
    private final int[] my;
    private final yo n;
    private int nb;
    private pl ne;
    private u oa;
    private EdgeEffect op;
    final Rect p;

    /* renamed from: pl, reason: collision with root package name */
    final RectF f10248pl;
    boolean pz;
    final jk q;
    private int qd;
    e qt;
    boolean ra;
    private float rg;
    private List<p> s;
    private final int se;
    private final int[] si;
    private VelocityTracker ss;
    private float t;
    final Runnable tf;
    private final AccessibilityManager tu;
    private com.bytedance.sdk.component.widget.recycler.xj.w.u ua;
    boolean v;
    private final am.hf vi;
    private int vl;
    private g vm;
    private EdgeEffect wa;
    private boolean wn;
    com.bytedance.sdk.component.widget.recycler.u x;
    private int xv;
    com.bytedance.sdk.component.widget.recycler.xj y;
    boolean yo;
    private final Rect yy;
    boolean z;
    private List<am> zb;
    final ArrayList<f> zg;
    private static final int[] r = {R.attr.nestedScrollingEnabled};
    private static final int[] b = {R.attr.clipToPadding};

    public static abstract class am {
        public void xj(RecyclerView recyclerView, int i) {
        }

        public void xj(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public class c implements y.xj {
        public c() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y.xj
        public void xj(ra raVar) {
            raVar.xj(true);
            if (raVar.f != null && raVar.d == null) {
                raVar.f = null;
            }
            raVar.d = null;
            if (raVar.dk() || RecyclerView.this.xj(raVar.xj) || !raVar.yo()) {
                return;
            }
            RecyclerView.this.removeDetachedView(raVar.xj, false);
        }
    }

    public static abstract class d {
        boolean am;
        private int c;
        RecyclerView d;
        boolean e;
        com.bytedance.sdk.component.widget.recycler.hf f;
        boolean g;
        private final g.hf hf;
        private int kd;
        com.bytedance.sdk.component.widget.recycler.g p;

        /* renamed from: pl, reason: collision with root package name */
        v f10249pl;
        boolean qt;
        com.bytedance.sdk.component.widget.recycler.g tf;
        private boolean u;
        private boolean w;
        private final g.hf xj;
        private int y;
        private int yo;
        int zg;

        public interface xj {
            void hf(int i, int i2);
        }

        public d() {
            g.hf hfVar = new g.hf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.d.1
                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int hf() {
                    return d.this.ht() - d.this.io();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public View xj(int i) {
                    return d.this.f(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int hf(View view) {
                    return d.this.d(view) + ((ViewGroup.MarginLayoutParams) ((tf) view.getLayoutParams())).rightMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int xj() {
                    return d.this.dk();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int xj(View view) {
                    return d.this.c(view) - ((ViewGroup.MarginLayoutParams) ((tf) view.getLayoutParams())).leftMargin;
                }
            };
            this.xj = hfVar;
            g.hf hfVar2 = new g.hf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.d.2
                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int hf() {
                    return d.this.ra() - d.this.x();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public View xj(int i) {
                    return d.this.f(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int hf(View view) {
                    return d.this.tf(view) + ((ViewGroup.MarginLayoutParams) ((tf) view.getLayoutParams())).bottomMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int xj() {
                    return d.this.et();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.g.hf
                public int xj(View view) {
                    return d.this.f(view) - ((ViewGroup.MarginLayoutParams) ((tf) view.getLayoutParams())).topMargin;
                }
            };
            this.hf = hfVar2;
            this.tf = new com.bytedance.sdk.component.widget.recycler.g(hfVar);
            this.p = new com.bytedance.sdk.component.widget.recycler.g(hfVar2);
            this.g = false;
            this.am = false;
            this.qt = false;
            this.w = true;
            this.u = true;
        }

        public View ai() {
            View focusedChild;
            RecyclerView recyclerView = this.d;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f.w(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public final boolean am() {
            return this.u;
        }

        public int c(jk jkVar) {
            return 0;
        }

        public boolean d() {
            return false;
        }

        public int dk() {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int e() {
            return com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(this.d);
        }

        public void en() {
            v vVar = this.f10249pl;
            if (vVar != null) {
                vVar.kd();
            }
        }

        public int et() {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int f(jk jkVar) {
            return 0;
        }

        public void g() {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int hf(int i, zg zgVar, jk jkVar) {
            return 0;
        }

        public abstract tf hf();

        public int ht() {
            return this.c;
        }

        public int io() {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int j() {
            return com.bytedance.sdk.component.widget.recycler.xj.w.c.kd(this.d);
        }

        public int jk() {
            return this.kd;
        }

        public int kd(jk jkVar) {
            return 0;
        }

        public boolean l() {
            int v = v();
            for (int i = 0; i < v; i++) {
                ViewGroup.LayoutParams layoutParams = f(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void p(int i) {
        }

        public boolean pl() {
            return false;
        }

        public int pz() {
            return this.y;
        }

        public int q() {
            RecyclerView recyclerView = this.d;
            xj adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.xj();
            }
            return 0;
        }

        public boolean qt() {
            RecyclerView recyclerView = this.d;
            return recyclerView != null && recyclerView.d;
        }

        public int ra() {
            return this.yo;
        }

        public void tf(int i) {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.kd(i);
            }
        }

        public int u(jk jkVar) {
            return 0;
        }

        public int v() {
            com.bytedance.sdk.component.widget.recycler.hf hfVar = this.f;
            if (hfVar != null) {
                return hfVar.hf();
            }
            return 0;
        }

        public int w(jk jkVar) {
            return 0;
        }

        public int x() {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int xj(int i, zg zgVar, jk jkVar) {
            return 0;
        }

        public int y(jk jkVar) {
            return 0;
        }

        public int yo() {
            return -1;
        }

        public int z() {
            return com.bytedance.sdk.component.widget.recycler.xj.w.c.u(this.d);
        }

        public boolean zg() {
            v vVar = this.f10249pl;
            return vVar != null && vVar.c();
        }

        public int am(View view) {
            return ((tf) view.getLayoutParams()).hf.right;
        }

        public void c(int i) {
            xj(i, f(i));
        }

        public void d(int i) {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.y(i);
            }
        }

        public View f(int i) {
            com.bytedance.sdk.component.widget.recycler.hf hfVar = this.f;
            if (hfVar != null) {
                return hfVar.hf(i);
            }
            return null;
        }

        public void hf(jk jkVar) {
        }

        public int kd(View view) {
            Rect rect = ((tf) view.getLayoutParams()).hf;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int p(View view) {
            return ((tf) view.getLayoutParams()).hf.top;
        }

        public int pl(View view) {
            return ((tf) view.getLayoutParams()).hf.bottom;
        }

        public View u(View view, int i) {
            return null;
        }

        public void w(RecyclerView recyclerView) {
        }

        public View xj(View view, int i, zg zgVar, jk jkVar) {
            return null;
        }

        public void y(int i) {
            if (f(i) != null) {
                this.f.xj(i);
            }
        }

        public int c(View view) {
            return view.getLeft() - g(view);
        }

        public int f(View view) {
            return view.getTop() - p(view);
        }

        public int g(View view) {
            return ((tf) view.getLayoutParams()).hf.left;
        }

        public void hf(int i, int i2) {
            this.c = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.kd = mode;
            if (mode == 0 && !RecyclerView.hf) {
                this.c = 0;
            }
            this.yo = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.y = mode2;
            if (mode2 != 0 || RecyclerView.hf) {
                return;
            }
            this.yo = 0;
        }

        public int tf(View view) {
            return pl(view) + view.getBottom();
        }

        public void u(int i) {
        }

        public boolean w() {
            return false;
        }

        public void xj(int i, int i2, jk jkVar, xj xjVar) {
        }

        public int d(View view) {
            return am(view) + view.getRight();
        }

        public void kd(int i, int i2) {
            this.d.setMeasuredDimension(i, i2);
        }

        public boolean u() {
            return false;
        }

        public void w(int i, int i2) {
            int v = v();
            if (v == 0) {
                this.d.kd(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < v; i7++) {
                View f = f(i7);
                Rect rect = this.d.p;
                xj(f, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.d.p.set(i5, i6, i3, i4);
            xj(this.d.p, i, i2);
        }

        public void xj(int i, xj xjVar) {
        }

        public int y(View view) {
            Rect rect = ((tf) view.getLayoutParams()).hf;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int u(View view) {
            return ((tf) view.getLayoutParams()).u();
        }

        public void xj(RecyclerView recyclerView, zg zgVar) {
        }

        public void u(int i, int i2) {
            View f = f(i);
            if (f != null) {
                c(i);
                w(f, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.d.toString());
            }
        }

        public boolean xj(tf tfVar) {
            return tfVar != null;
        }

        public boolean xj(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void xj(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.d = null;
                this.f = null;
                this.c = 0;
                this.yo = 0;
            } else {
                this.d = recyclerView;
                this.f = recyclerView.c;
                this.c = recyclerView.getWidth();
                this.yo = recyclerView.getHeight();
            }
            this.kd = 1073741824;
            this.y = 1073741824;
        }

        public void u(RecyclerView recyclerView) {
            hf(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void hf(RecyclerView recyclerView) {
            this.am = true;
            w(recyclerView);
        }

        public void hf(RecyclerView recyclerView, zg zgVar) {
            this.am = false;
            xj(recyclerView, zgVar);
        }

        public void hf(View view) {
            hf(view, -1);
        }

        public void w(View view) {
            this.f.xj(view);
        }

        public void hf(View view, int i) {
            xj(view, i, false);
        }

        public void w(View view, int i) {
            xj(view, i, (tf) view.getLayoutParams());
        }

        public View hf(int i) {
            int v = v();
            for (int i2 = 0; i2 < v; i2++) {
                View f = f(i2);
                ra kd = RecyclerView.kd(f);
                if (kd != null && kd.u() == i && !kd.L_() && (this.d.q.xj() || !kd.e())) {
                    return f;
                }
            }
            return null;
        }

        public void w(zg zgVar) {
            for (int v = v() - 1; v >= 0; v--) {
                if (!RecyclerView.kd(f(v)).L_()) {
                    xj(v, zgVar);
                }
            }
        }

        public void xj(Rect rect, int i, int i2) {
            kd(xj(i, io() + dk() + rect.width(), z()), xj(i2, x() + et() + rect.height(), j()));
        }

        public void hf(zg zgVar) {
            int kd = zgVar.kd();
            for (int i = kd - 1; i >= 0; i--) {
                View u = zgVar.u(i);
                ra kd2 = RecyclerView.kd(u);
                if (!kd2.L_()) {
                    kd2.xj(false);
                    if (kd2.yo()) {
                        this.d.removeDetachedView(u, false);
                    }
                    y yVar = this.d.et;
                    if (yVar != null) {
                        yVar.u(kd2);
                    }
                    kd2.xj(true);
                    zgVar.hf(u);
                }
            }
            zgVar.y();
            if (kd > 0) {
                this.d.invalidate();
            }
        }

        public static int xj(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void xj(String str) {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.xj(str);
            }
        }

        public boolean xj() {
            return this.qt;
        }

        public void xj(zg zgVar, jk jkVar) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public tf xj(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof tf) {
                return new tf((tf) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new tf((ViewGroup.MarginLayoutParams) layoutParams) : new tf(layoutParams);
        }

        private static boolean hf(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public tf xj(Context context, AttributeSet attributeSet) {
            return new tf(context, attributeSet);
        }

        public void xj(RecyclerView recyclerView, jk jkVar, int i) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        private int[] hf(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int dk = dk();
            int et = et();
            int ht = ht() - io();
            int ra = ra() - x();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - dk;
            int min = Math.min(0, i);
            int i2 = top - et;
            int min2 = Math.min(0, i2);
            int i3 = width - ht;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - ra);
            if (e() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            return new int[]{max, min2};
        }

        public void xj(v vVar) {
            v vVar2 = this.f10249pl;
            if (vVar2 != null && vVar != vVar2 && vVar2.c()) {
                this.f10249pl.kd();
            }
            this.f10249pl = vVar;
            vVar.xj(this.d, this);
        }

        public void xj(View view) {
            xj(view, -1);
        }

        public void xj(View view, int i) {
            xj(view, i, true);
        }

        private void xj(View view, int i, boolean z) {
            ra kd = RecyclerView.kd(view);
            if (!z && !kd.e()) {
                this.d.f.y(kd);
            } else {
                this.d.f.kd(kd);
            }
            tf tfVar = (tf) view.getLayoutParams();
            if (!kd.p() && !kd.d()) {
                if (view.getParent() == this.d) {
                    int hf = this.f.hf(view);
                    if (i == -1) {
                        i = this.f.hf();
                    }
                    if (hf == -1) {
                        StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        sb.append(this.d.indexOfChild(view));
                        throw new IllegalStateException(A2egSU.AcNBzu(this.d, sb));
                    }
                    if (hf != i) {
                        this.d.am.u(hf, i);
                    }
                } else {
                    this.f.xj(view, i, false);
                    tfVar.w = true;
                    v vVar = this.f10249pl;
                    if (vVar != null && vVar.c()) {
                        this.f10249pl.hf(view);
                    }
                }
            } else {
                if (kd.d()) {
                    kd.tf();
                } else {
                    kd.pl();
                }
                this.f.xj(view, i, view.getLayoutParams(), false);
            }
            if (tfVar.u) {
                kd.xj.invalidate();
                tfVar.u = false;
            }
        }

        public void hf(v vVar) {
            if (this.f10249pl == vVar) {
                this.f10249pl = null;
            }
        }

        private void xj(int i, View view) {
            this.f.kd(i);
        }

        public void xj(View view, int i, tf tfVar) {
            ra kd = RecyclerView.kd(view);
            if (kd.e()) {
                this.d.f.kd(kd);
            } else {
                this.d.f.y(kd);
            }
            this.f.xj(view, i, tfVar, kd.e());
        }

        public void xj(View view, zg zgVar) {
            w(view);
            zgVar.xj(view);
        }

        public void xj(int i, zg zgVar) {
            View f = f(i);
            y(i);
            zgVar.xj(f);
        }

        public void xj(zg zgVar) {
            for (int v = v() - 1; v >= 0; v--) {
                xj(zgVar, v, f(v));
            }
        }

        private void xj(zg zgVar, int i, View view) {
            ra kd = RecyclerView.kd(view);
            if (kd.L_()) {
                return;
            }
            if (kd.am() && !kd.e() && !this.d.g.hf()) {
                y(i);
                zgVar.hf(kd);
            } else {
                c(i);
                zgVar.w(view);
                this.d.f.f(kd);
            }
        }

        public boolean xj(View view, int i, int i2, tf tfVar) {
            return (!view.isLayoutRequested() && this.w && hf(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) tfVar).width) && hf(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) tfVar).height)) ? false : true;
        }

        public void xj(View view, int i, int i2) {
            tf tfVar = (tf) view.getLayoutParams();
            Rect d = this.d.d(view);
            int i3 = d.left + d.right + i;
            int i4 = d.top + d.bottom + i2;
            int xj2 = xj(ht(), jk(), io() + dk() + ((ViewGroup.MarginLayoutParams) tfVar).leftMargin + ((ViewGroup.MarginLayoutParams) tfVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) tfVar).width, w());
            int xj3 = xj(ra(), pz(), x() + et() + ((ViewGroup.MarginLayoutParams) tfVar).topMargin + ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) tfVar).height, u());
            if (xj(view, xj2, xj3, tfVar)) {
                view.measure(xj2, xj3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r5 == 1073741824) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int xj(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1c
                if (r7 < 0) goto L13
            L10:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L2e
            L13:
                if (r7 != r1) goto L19
                if (r5 == r2) goto L21
                if (r5 == r3) goto L21
            L19:
                r5 = 0
                r7 = 0
                goto L2e
            L1c:
                if (r7 < 0) goto L1f
                goto L10
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L2e
            L23:
                if (r7 != r0) goto L19
                if (r5 == r2) goto L2b
                if (r5 == r3) goto L2b
                r5 = 0
                goto L21
            L2b:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2e:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.d.xj(int, int, int, int, boolean):int");
        }

        public void xj(View view, int i, int i2, int i3, int i4) {
            tf tfVar = (tf) view.getLayoutParams();
            Rect rect = tfVar.hf;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) tfVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) tfVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) tfVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin);
        }

        public void xj(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((tf) view.getLayoutParams()).hf;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.d != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.d.f10248pl;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void xj(View view, Rect rect) {
            RecyclerView.xj(view, rect);
        }

        public boolean xj(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return xj(recyclerView, view, rect, z, false);
        }

        public boolean xj(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] hf = hf(recyclerView, view, rect, z);
            int i = hf[0];
            int i2 = hf[1];
            if ((z2 && !xj(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.xj(i, i2);
            }
            return true;
        }

        private boolean xj(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int dk = dk();
            int et = et();
            int ht = ht() - io();
            int ra = ra() - x();
            Rect rect = this.d.p;
            xj(focusedChild, rect);
            return rect.left - i < ht && rect.right - i > dk && rect.top - i2 < ra && rect.bottom - i2 > et;
        }

        @Deprecated
        public boolean xj(RecyclerView recyclerView, View view, View view2) {
            return zg() || recyclerView.am();
        }

        public boolean xj(RecyclerView recyclerView, jk jkVar, View view, View view2) {
            return xj(recyclerView, view, view2);
        }

        public void xj(zg zgVar, jk jkVar, int i, int i2) {
            this.d.kd(i, i2);
        }
    }

    public interface e {
    }

    public static abstract class f {
        @Deprecated
        public void xj(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void xj(Rect rect, View view, RecyclerView recyclerView, jk jkVar) {
            xj(rect, ((tf) view.getLayoutParams()).u(), recyclerView);
        }
    }

    public interface g {
        boolean xj(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public class ht implements Runnable {
        private boolean c;
        Interpolator hf;
        private int kd;
        private int u;
        OverScroller xj;
        private boolean y;

        public ht() {
            Interpolator interpolator = RecyclerView.wo;
            this.hf = interpolator;
            this.y = false;
            this.c = false;
            this.xj = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private void u() {
            this.y = false;
            if (this.c) {
                xj();
            }
        }

        private void w() {
            this.c = false;
            this.y = true;
        }

        public void hf(int i, int i2) {
            xj(i, i2, 0, 0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
        
            if (r14 > 0) goto L51;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ff A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 419
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.ht.run():void");
        }

        public void xj() {
            if (this.y) {
                this.c = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(RecyclerView.this, this);
            }
        }

        private int hf(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i4 * i4) + (i3 * i3));
            int sqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float xj = (xj(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2) + f2;
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(xj / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void xj(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.kd = 0;
            this.u = 0;
            this.xj.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            xj();
        }

        public void xj(int i, int i2, int i3, int i4) {
            xj(i, i2, hf(i, i2, i3, i4));
        }

        private float xj(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void xj(int i, int i2, int i3) {
            xj(i, i2, i3, RecyclerView.wo);
        }

        public void hf() {
            RecyclerView.this.removeCallbacks(this);
            this.xj.abortAnimation();
        }

        public void xj(int i, int i2, Interpolator interpolator) {
            int hf = hf(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.wo;
            }
            xj(i, i2, hf, interpolator);
        }

        public void xj(int i, int i2, int i3, Interpolator interpolator) {
            if (this.hf != interpolator) {
                this.hf = interpolator;
                this.xj = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.kd = 0;
            this.u = 0;
            this.xj.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.xj.computeScrollOffset();
            }
            xj();
        }
    }

    public static class kd {
        public EdgeEffect xj(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public interface p {
        void hf(View view);

        void xj(View view);
    }

    public static abstract class pl {
        public abstract boolean xj(int i, int i2);
    }

    public static abstract class pz {
        public abstract View xj(zg zgVar, int i, int i2);
    }

    public interface u {
        int xj(int i, int i2);
    }

    public static abstract class w {
        public void xj() {
        }

        public void xj(int i, int i2, Object obj) {
        }
    }

    public static abstract class xj<VH extends ra> {
        private final hf xj = new hf();
        private boolean hf = false;

        public long hf(int i) {
            return -1L;
        }

        public final void w() {
            this.xj.xj();
        }

        public abstract int xj();

        public int xj(int i) {
            return 0;
        }

        public abstract VH xj(ViewGroup viewGroup, int i);

        public abstract void xj(VH vh, int i);

        public boolean hf(VH vh) {
            return false;
        }

        public void xj(VH vh) {
        }

        public final VH hf(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV CreateView");
                VH xj = xj(viewGroup, i);
                if (xj.xj.getParent() == null) {
                    xj.y = i;
                    return xj;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
            }
        }

        public void xj(VH vh, int i, List<Object> list) {
            xj((xj<VH>) vh, i);
        }

        public void xj(w wVar) {
            this.xj.registerObserver(wVar);
        }

        public final void xj(int i, Object obj) {
            this.xj.xj(i, 1, obj);
        }

        public final void xj(int i, int i2) {
            this.xj.xj(i, i2);
        }

        public final void hf(VH vh, int i) {
            vh.w = i;
            if (hf()) {
                vh.kd = hf(i);
            }
            vh.xj(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV OnBindView");
            xj(vh, i, vh.pz());
            vh.jk();
            ViewGroup.LayoutParams layoutParams = vh.xj.getLayoutParams();
            if (layoutParams instanceof tf) {
                ((tf) layoutParams).w = true;
            }
            com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
        }

        public final boolean hf() {
            return this.hf;
        }

        public void hf(w wVar) {
            this.xj.unregisterObserver(wVar);
        }
    }

    public static abstract class y {
        private xj xj = null;
        private ArrayList<Object> hf = new ArrayList<>();
        private long w = 120;
        private long u = 120;
        private long kd = 250;
        private long y = 250;

        public static class hf {
            public int hf;
            public int u;
            public int w;
            public int xj;

            public hf xj(ra raVar) {
                return xj(raVar, 0);
            }

            public hf xj(ra raVar, int i) {
                View view = raVar.xj;
                this.xj = view.getLeft();
                this.hf = view.getTop();
                this.w = view.getRight();
                this.u = view.getBottom();
                return this;
            }
        }

        public interface xj {
            void xj(ra raVar);
        }

        public boolean c(ra raVar) {
            return true;
        }

        public final void d() {
            int size = this.hf.size();
            for (int i = 0; i < size; i++) {
                this.hf.get(i);
            }
            this.hf.clear();
        }

        public long f() {
            return this.y;
        }

        public abstract boolean hf();

        public abstract boolean hf(ra raVar, hf hfVar, hf hfVar2);

        public long kd() {
            return this.kd;
        }

        public hf tf() {
            return new hf();
        }

        public abstract void u();

        public abstract void u(ra raVar);

        public abstract boolean w(ra raVar, hf hfVar, hf hfVar2);

        public abstract void xj();

        public void xj(xj xjVar) {
            this.xj = xjVar;
        }

        public abstract boolean xj(ra raVar, ra raVar2, hf hfVar, hf hfVar2);

        public abstract boolean xj(ra raVar, hf hfVar, hf hfVar2);

        public long y() {
            return this.w;
        }

        public static int kd(ra raVar) {
            int i = raVar.tf;
            int i2 = i & 14;
            if (raVar.am()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int y = raVar.y();
                int kd = raVar.kd();
                if (y != -1 && kd != -1 && y != kd) {
                    return i2 | 2048;
                }
            }
            return i2;
        }

        public long c() {
            return this.u;
        }

        public hf xj(jk jkVar, ra raVar, int i, List<Object> list) {
            return tf().xj(raVar);
        }

        public final void y(ra raVar) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(raVar);
            }
        }

        public hf xj(jk jkVar, ra raVar) {
            return tf().xj(raVar);
        }

        public boolean xj(ra raVar, List<Object> list) {
            return c(raVar);
        }
    }

    public final class zg {
        private final List<ra> c;
        private pz d;
        private int f;
        ArrayList<ra> hf;
        qt kd;
        int u;
        final ArrayList<ra> w;
        final ArrayList<ra> xj;

        public zg() {
            ArrayList<ra> arrayList = new ArrayList<>();
            this.xj = arrayList;
            this.hf = null;
            this.w = new ArrayList<>();
            this.c = Collections.unmodifiableList(arrayList);
            this.f = 2;
            this.u = 2;
        }

        private void kd(ra raVar) {
            View view = raVar.xj;
            if (view instanceof ViewGroup) {
                xj((ViewGroup) view, false);
            }
        }

        public qt c() {
            if (this.kd == null) {
                this.kd = new qt();
            }
            return this.kd;
        }

        public void d() {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                this.w.get(i).xj();
            }
            int size2 = this.xj.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.xj.get(i2).xj();
            }
            ArrayList<ra> arrayList = this.hf;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.hf.get(i3).xj();
                }
            }
        }

        public void f() {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                ra raVar = this.w.get(i);
                if (raVar != null) {
                    raVar.hf(6);
                    raVar.xj((Object) null);
                }
            }
            xj xjVar = RecyclerView.this.g;
            if (xjVar == null || !xjVar.hf()) {
                u();
            }
        }

        public void hf() {
            d dVar = RecyclerView.this.am;
            this.u = this.f + (dVar != null ? dVar.zg : 0);
            for (int size = this.w.size() - 1; size >= 0 && this.w.size() > this.u; size--) {
                w(size);
            }
        }

        public void tf() {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                tf tfVar = (tf) this.w.get(i).xj.getLayoutParams();
                if (tfVar != null) {
                    tfVar.w = true;
                }
            }
        }

        public void u() {
            for (int size = this.w.size() - 1; size >= 0; size--) {
                w(size);
            }
            this.w.clear();
            if (RecyclerView.u) {
                RecyclerView.this.ai.xj();
            }
        }

        public List<ra> w() {
            return this.c;
        }

        public void xj() {
            this.xj.clear();
            u();
        }

        public void y() {
            this.xj.clear();
            ArrayList<ra> arrayList = this.hf;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public void w(int i) {
            xj(this.w.get(i), true);
            this.w.remove(i);
        }

        public int kd() {
            return this.xj.size();
        }

        public void xj(int i) {
            this.f = i;
            hf();
        }

        public ra kd(int i) {
            int size;
            int hf;
            ArrayList<ra> arrayList = this.hf;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ra raVar = this.hf.get(i2);
                    if (!raVar.p() && raVar.u() == i) {
                        raVar.hf(32);
                        return raVar;
                    }
                }
                if (RecyclerView.this.g.hf() && (hf = RecyclerView.this.y.hf(i)) > 0 && hf < RecyclerView.this.g.xj()) {
                    long hf2 = RecyclerView.this.g.hf(hf);
                    for (int i3 = 0; i3 < size; i3++) {
                        ra raVar2 = this.hf.get(i3);
                        if (!raVar2.p() && raVar2.c() == hf2) {
                            raVar2.hf(32);
                            return raVar2;
                        }
                    }
                }
            }
            return null;
        }

        public View hf(int i) {
            return xj(i, false);
        }

        public void w(View view) {
            ra kd = RecyclerView.kd(view);
            if (!kd.xj(12) && kd.io() && !RecyclerView.this.hf(kd)) {
                if (this.hf == null) {
                    this.hf = new ArrayList<>();
                }
                kd.xj(this, true);
                this.hf.add(kd);
                return;
            }
            if (kd.am() && !kd.e() && !RecyclerView.this.g.hf()) {
                throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            kd.xj(this, false);
            this.xj.add(kd);
        }

        public boolean xj(ra raVar) {
            if (raVar.e()) {
                return RecyclerView.this.q.xj();
            }
            int i = raVar.w;
            if (i >= 0 && i < RecyclerView.this.g.xj()) {
                if (RecyclerView.this.q.xj() || RecyclerView.this.g.xj(raVar.w) == raVar.f()) {
                    return !RecyclerView.this.g.hf() || raVar.c() == RecyclerView.this.g.hf(raVar.w);
                }
                return false;
            }
            StringBuilder sb = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
            sb.append(raVar);
            throw new IndexOutOfBoundsException(A2egSU.AcNBzu(RecyclerView.this, sb));
        }

        public void hf(ra raVar) {
            boolean z;
            boolean z2 = true;
            if (!raVar.d() && raVar.xj.getParent() == null) {
                if (!raVar.yo()) {
                    if (!raVar.L_()) {
                        boolean et = raVar.et();
                        xj xjVar = RecyclerView.this.g;
                        if ((xjVar != null && et && xjVar.hf((xj) raVar)) || raVar.ra()) {
                            if (this.u <= 0 || raVar.xj(526)) {
                                z = false;
                            } else {
                                int size = this.w.size();
                                if (size >= this.u && size > 0) {
                                    w(0);
                                    size--;
                                }
                                if (RecyclerView.u && size > 0 && !RecyclerView.this.ai.xj(raVar.w)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.ai.xj(this.w.get(i).w)) {
                                            break;
                                        } else {
                                            i--;
                                        }
                                    }
                                    size = i + 1;
                                }
                                this.w.add(size, raVar);
                                z = true;
                            }
                            if (!z) {
                                xj(raVar, true);
                                r1 = z;
                                RecyclerView.this.f.c(raVar);
                                if (r1 && !z2 && et) {
                                    raVar.zg = null;
                                    return;
                                }
                                return;
                            }
                            r1 = z;
                        }
                        z2 = false;
                        RecyclerView.this.f.c(raVar);
                        if (r1) {
                            return;
                        } else {
                            return;
                        }
                    }
                    throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
                }
                StringBuilder sb = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(raVar);
                throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, sb));
            }
            StringBuilder sb2 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb2.append(raVar.d());
            sb2.append(" isAttached:");
            sb2.append(raVar.xj.getParent() != null);
            throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, sb2));
        }

        public View u(int i) {
            return this.xj.get(i).xj;
        }

        public void u(ra raVar) {
            xj xjVar = RecyclerView.this.g;
            if (xjVar != null) {
                xjVar.xj((xj) raVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.q != null) {
                recyclerView.f.c(raVar);
            }
        }

        private boolean xj(ra raVar, int i, int i2, long j) {
            raVar.zg = RecyclerView.this;
            int f = raVar.f();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.kd.hf(f, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.g.hf((xj) raVar, i);
            this.kd.hf(raVar.f(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.q.xj()) {
                return true;
            }
            raVar.c = i2;
            return true;
        }

        public void w(ra raVar) {
            if (raVar.am) {
                this.hf.remove(raVar);
            } else {
                this.xj.remove(raVar);
            }
            raVar.g = null;
            raVar.am = false;
            raVar.pl();
        }

        public void w(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.w.size() - 1; size >= 0; size--) {
                ra raVar = this.w.get(size);
                if (raVar != null && (i3 = raVar.w) >= i && i3 < i4) {
                    raVar.hf(2);
                    w(size);
                }
            }
        }

        public View xj(int i, boolean z) {
            return xj(i, z, Long.MAX_VALUE).xj;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01f5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01d9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.bytedance.sdk.component.widget.recycler.RecyclerView.ra xj(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 541
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.zg.xj(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$ra");
        }

        public void hf(View view) {
            ra kd = RecyclerView.kd(view);
            kd.g = null;
            kd.am = false;
            kd.pl();
            hf(kd);
        }

        public ra hf(int i, boolean z) {
            View w;
            int size = this.xj.size();
            for (int i2 = 0; i2 < size; i2++) {
                ra raVar = this.xj.get(i2);
                if (!raVar.p() && raVar.u() == i && !raVar.am() && (RecyclerView.this.q.c || !raVar.e())) {
                    raVar.hf(32);
                    return raVar;
                }
            }
            if (!z && (w = RecyclerView.this.c.w(i)) != null) {
                ra kd = RecyclerView.kd(w);
                RecyclerView.this.c.kd(w);
                int hf = RecyclerView.this.c.hf(w);
                if (hf != -1) {
                    RecyclerView.this.c.kd(hf);
                    w(w);
                    kd.hf(8224);
                    return kd;
                }
                StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                sb.append(kd);
                throw new IllegalStateException(A2egSU.AcNBzu(RecyclerView.this, sb));
            }
            int size2 = this.w.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ra raVar2 = this.w.get(i3);
                if (!raVar2.am() && raVar2.u() == i) {
                    if (!z) {
                        this.w.remove(i3);
                    }
                    return raVar2;
                }
            }
            return null;
        }

        public void hf(int i, int i2) {
            int size = this.w.size();
            for (int i3 = 0; i3 < size; i3++) {
                ra raVar = this.w.get(i3);
                if (raVar != null && raVar.w >= i) {
                    raVar.xj(i2, true);
                }
            }
        }

        private void xj(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    xj((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void xj(View view) {
            ra kd = RecyclerView.kd(view);
            if (kd.yo()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (kd.d()) {
                kd.tf();
            } else if (kd.p()) {
                kd.pl();
            }
            hf(kd);
        }

        public void xj(ra raVar, boolean z) {
            RecyclerView.w(raVar);
            if (raVar.xj(f.a.d)) {
                raVar.xj(0, f.a.d);
            }
            if (z) {
                u(raVar);
            }
            raVar.zg = null;
            c().xj(raVar);
        }

        public ra xj(long j, int i, boolean z) {
            for (int size = this.xj.size() - 1; size >= 0; size--) {
                ra raVar = this.xj.get(size);
                if (raVar.c() == j && !raVar.p()) {
                    if (i == raVar.f()) {
                        raVar.hf(32);
                        if (raVar.e() && !RecyclerView.this.q.xj()) {
                            raVar.xj(2, 14);
                        }
                        return raVar;
                    }
                    if (!z) {
                        this.xj.remove(size);
                        RecyclerView.this.removeDetachedView(raVar.xj, false);
                        hf(raVar.xj);
                    }
                }
            }
            int size2 = this.w.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ra raVar2 = this.w.get(size2);
                if (raVar2.c() == j) {
                    if (i == raVar2.f()) {
                        if (!z) {
                            this.w.remove(size2);
                        }
                        return raVar2;
                    }
                    if (!z) {
                        w(size2);
                        return null;
                    }
                }
            }
        }

        public void xj(xj xjVar, xj xjVar2, boolean z) {
            xj();
            c().xj(xjVar, xjVar2, z);
        }

        public void xj(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.w.size();
            for (int i7 = 0; i7 < size; i7++) {
                ra raVar = this.w.get(i7);
                if (raVar != null && (i6 = raVar.w) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        raVar.xj(i2 - i, false);
                    } else {
                        raVar.xj(i3, false);
                    }
                }
            }
        }

        public void xj(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.w.size() - 1; size >= 0; size--) {
                ra raVar = this.w.get(size);
                if (raVar != null) {
                    int i4 = raVar.w;
                    if (i4 >= i3) {
                        raVar.xj(-i2, z);
                    } else if (i4 >= i) {
                        raVar.hf(8);
                        w(size);
                    }
                }
            }
        }

        public void xj(pz pzVar) {
            this.d = pzVar;
        }

        public void xj(qt qtVar) {
            qt qtVar2 = this.kd;
            if (qtVar2 != null) {
                qtVar2.w();
            }
            this.kd = qtVar;
            if (qtVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.kd.hf();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        xj = false;
        hf = i >= 23;
        w = true;
        u = true;
        ws = false;
        eu = false;
        Class<?> cls = Integer.TYPE;
        tj = new Class[]{Context.class, AttributeSet.class, cls, cls};
        wo = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        bOEmG();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void a() {
        jk jkVar = this.q;
        jkVar.g = -1L;
        jkVar.f10250pl = -1;
        jkVar.am = -1;
    }

    private void ai() {
        boolean z;
        EdgeEffect edgeEffect = this.lw;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.lw.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.wa;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.wa.isFinished();
        }
        EdgeEffect edgeEffect3 = this.gh;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.gh.isFinished();
        }
        EdgeEffect edgeEffect4 = this.op;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.op.isFinished();
        }
        if (z) {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.w(this);
        }
    }

    private void b() {
        this.q.xj(1);
        xj(this.q);
        this.q.d = false;
        kd();
        this.f.xj();
        pl();
        l();
        ff();
        jk jkVar = this.q;
        jkVar.f = jkVar.tf && this.j;
        this.j = false;
        this.z = false;
        jkVar.c = jkVar.p;
        jkVar.kd = this.g.xj();
        xj(this.i);
        if (this.q.tf) {
            int hf2 = this.c.hf();
            for (int i = 0; i < hf2; i++) {
                ra kd2 = kd(this.c.hf(i));
                if (!kd2.L_() && (!kd2.am() || this.g.hf())) {
                    this.f.xj(kd2, this.et.xj(this.q, kd2, y.kd(kd2), kd2.pz()));
                    if (this.q.f && kd2.io() && !kd2.e() && !kd2.L_() && !kd2.am()) {
                        this.f.xj(xj(kd2), kd2);
                    }
                }
            }
        }
        if (this.q.p) {
            yo();
            jk jkVar2 = this.q;
            boolean z = jkVar2.y;
            jkVar2.y = false;
            this.am.xj(this.kd, jkVar2);
            this.q.y = z;
            for (int i2 = 0; i2 < this.c.hf(); i2++) {
                ra kd3 = kd(this.c.hf(i2));
                if (!kd3.L_() && !this.f.u(kd3)) {
                    int kd4 = y.kd(kd3);
                    boolean xj2 = kd3.xj(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                    if (!xj2) {
                        kd4 |= f.a.c;
                    }
                    y.hf xj3 = this.et.xj(this.q, kd3, kd4, kd3.pz());
                    if (xj2) {
                        xj(kd3, xj3);
                    } else {
                        this.f.hf(kd3, xj3);
                    }
                }
            }
            v();
        } else {
            v();
        }
        g();
        xj(false);
        this.q.u = 2;
    }

    private static /* synthetic */ void bOEmG() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @SuppressLint({"InlinedApi"})
    private void dk() {
        if (com.bytedance.sdk.component.widget.recycler.xj.w.c.d(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.hf(this, 8);
        }
    }

    private boolean en() {
        return this.et != null && this.am.pl();
    }

    private void et() {
        this.c = new com.bytedance.sdk.component.widget.recycler.hf(new hf.InterfaceC0126hf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public View hf(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void u(View view) {
                ra kd2 = RecyclerView.kd(view);
                if (kd2 != null) {
                    kd2.hf(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void w(int i) {
                ra kd2;
                View hf2 = hf(i);
                if (hf2 != null && (kd2 = RecyclerView.kd(hf2)) != null) {
                    if (kd2.yo() && !kd2.L_()) {
                        StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                        sb.append(kd2);
                        throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, sb));
                    }
                    kd2.hf(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public int xj() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void hf() {
                int xj2 = xj();
                for (int i = 0; i < xj2; i++) {
                    View hf2 = hf(i);
                    RecyclerView.this.p(hf2);
                    hf2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void xj(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.pl(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public int xj(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void xj(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.p(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public ra hf(View view) {
                return RecyclerView.kd(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void xj(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ra kd2 = RecyclerView.kd(view);
                if (kd2 != null) {
                    if (!kd2.yo() && !kd2.L_()) {
                        StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                        sb.append(kd2);
                        throw new IllegalArgumentException(A2egSU.AcNBzu(RecyclerView.this, sb));
                    }
                    kd2.g();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hf.InterfaceC0126hf
            public void w(View view) {
                ra kd2 = RecyclerView.kd(view);
                if (kd2 != null) {
                    kd2.xj(RecyclerView.this);
                }
            }
        });
    }

    private void eu() {
        RecyclerView recyclerView;
        this.q.xj(4);
        kd();
        pl();
        jk jkVar = this.q;
        jkVar.u = 1;
        if (jkVar.tf) {
            for (int hf2 = this.c.hf() - 1; hf2 >= 0; hf2--) {
                ra kd2 = kd(this.c.hf(hf2));
                if (!kd2.L_()) {
                    long xj2 = xj(kd2);
                    y.hf xj3 = this.et.xj(this.q, kd2);
                    ra xj4 = this.f.xj(xj2);
                    if (xj4 != null && !xj4.L_()) {
                        boolean xj5 = this.f.xj(xj4);
                        boolean xj6 = this.f.xj(kd2);
                        if (!xj5 || xj4 != kd2) {
                            y.hf hf3 = this.f.hf(xj4);
                            this.f.w(kd2, xj3);
                            y.hf w2 = this.f.w(kd2);
                            if (hf3 == null) {
                                xj(xj2, kd2, xj4);
                            } else {
                                xj(xj4, kd2, hf3, w2, xj5, xj6);
                            }
                        }
                    }
                    this.f.w(kd2, xj3);
                }
            }
            recyclerView = this;
            recyclerView.f.xj(recyclerView.vi);
        } else {
            recyclerView = this;
        }
        recyclerView.am.hf(recyclerView.kd);
        jk jkVar2 = recyclerView.q;
        jkVar2.hf = jkVar2.kd;
        recyclerView.ra = false;
        recyclerView.dk = false;
        jkVar2.tf = false;
        jkVar2.p = false;
        recyclerView.am.g = false;
        ArrayList<ra> arrayList = recyclerView.kd.hf;
        if (arrayList != null) {
            arrayList.clear();
        }
        d dVar = recyclerView.am;
        if (dVar.e) {
            dVar.zg = 0;
            dVar.e = false;
            recyclerView.kd.hf();
        }
        recyclerView.am.hf(recyclerView.q);
        g();
        xj(false);
        recyclerView.f.xj();
        int[] iArr = recyclerView.i;
        if (tf(iArr[0], iArr[1])) {
            f(0, 0);
        }
        r();
        a();
    }

    private void ff() {
        View focusedChild = (this.k && hasFocus() && this.g != null) ? getFocusedChild() : null;
        ra u2 = focusedChild != null ? u(focusedChild) : null;
        if (u2 == null) {
            a();
            return;
        }
        this.q.g = this.g.hf() ? u2.c() : -1L;
        this.q.f10250pl = this.ra ? -1 : u2.e() ? u2.u : u2.kd();
        this.q.am = g(u2.xj);
    }

    private com.bytedance.sdk.component.widget.recycler.xj.w.u getScrollingChildHelper() {
        if (this.ua == null) {
            this.ua = new com.bytedance.sdk.component.widget.recycler.xj.w.u(this);
        }
        return this.ua;
    }

    private boolean io() {
        int hf2 = this.c.hf();
        for (int i = 0; i < hf2; i++) {
            ra kd2 = kd(this.c.hf(i));
            if (kd2 != null && !kd2.L_() && kd2.io()) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        this.aq = 0;
    }

    private void kd(ra raVar) {
        View view = raVar.xj;
        boolean z = view.getParent() == this;
        this.kd.w(hf(view));
        if (raVar.yo()) {
            this.c.xj(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.c.u(view);
        } else {
            this.c.xj(view, true);
        }
    }

    private void l() {
        boolean z;
        if (this.ra) {
            this.y.xj();
        }
        if (en()) {
            this.y.hf();
        } else {
            this.y.kd();
        }
        boolean z2 = this.z || this.j;
        this.q.tf = this.v && this.et != null && ((z = this.ra) || z2 || this.am.g) && (!z || this.g.hf());
        jk jkVar = this.q;
        jkVar.p = jkVar.tf && z2 && !this.ra && en();
    }

    private void q() {
        VelocityTracker velocityTracker = this.ss;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        f(0);
        ai();
    }

    private void r() {
        View findViewById;
        if (!this.k || this.g == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!eu || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.c.w(focusedChild)) {
                    return;
                }
            } else if (this.c.hf() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        ra xj2 = (this.q.g == -1 || !this.g.hf()) ? null : xj(this.q.g);
        if (xj2 != null && !this.c.w(xj2.xj) && xj2.xj.hasFocusable()) {
            view = xj2.xj;
        } else if (this.c.hf() > 0) {
            view = wo();
        }
        if (view != null) {
            int i = this.q.am;
            if (i != -1 && (findViewById = view.findViewById(i)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private View wo() {
        ra u2;
        jk jkVar = this.q;
        int i = jkVar.f10250pl;
        if (i == -1) {
            i = 0;
        }
        int u3 = jkVar.u();
        for (int i2 = i; i2 < u3; i2++) {
            ra u4 = u(i2);
            if (u4 == null) {
                break;
            }
            if (u4.xj.hasFocusable()) {
                return u4.xj;
            }
        }
        int min = Math.min(u3, i);
        do {
            min--;
            if (min < 0 || (u2 = u(min)) == null) {
                return null;
            }
        } while (!u2.xj.hasFocusable());
        return u2.xj;
    }

    private void ws() {
        kd();
        pl();
        this.q.xj(6);
        this.y.kd();
        this.q.kd = this.g.xj();
        jk jkVar = this.q;
        jkVar.w = 0;
        jkVar.c = false;
        this.am.xj(this.kd, jkVar);
        jk jkVar2 = this.q;
        jkVar2.y = false;
        jkVar2.tf = jkVar2.tf && this.et != null;
        jkVar2.u = 4;
        g();
        xj(false);
    }

    private void x() {
        this.f10247io.hf();
        d dVar = this.am;
        if (dVar != null) {
            dVar.en();
        }
    }

    private void z() {
        q();
        setScrollState(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        d dVar = this.am;
        if (dVar == null || !dVar.xj(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public boolean am() {
        return this.dq > 0;
    }

    public void c() {
        if (this.lw == null) {
            EdgeEffect xj2 = this.bl.xj(this, 0);
            this.lw = xj2;
            if (this.d) {
                xj2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                xj2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof tf) && this.am.xj((tf) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        d dVar = this.am;
        if (dVar != null && dVar.w()) {
            return this.am.kd(this.q);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        d dVar = this.am;
        if (dVar != null && dVar.w()) {
            return this.am.w(this.q);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        d dVar = this.am;
        if (dVar != null && dVar.w()) {
            return this.am.c(this.q);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        d dVar = this.am;
        if (dVar != null && dVar.u()) {
            return this.am.y(this.q);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        d dVar = this.am;
        if (dVar != null && dVar.u()) {
            return this.am.u(this.q);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        d dVar = this.am;
        if (dVar != null && dVar.u()) {
            return this.am.f(this.q);
        }
        return 0;
    }

    public void d() {
        if (this.wa == null) {
            EdgeEffect xj2 = this.bl.xj(this, 1);
            this.wa = xj2;
            if (this.d) {
                xj2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                xj2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().xj(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().xj(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().xj(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().xj(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.zg.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.zg.get(i);
        }
        EdgeEffect edgeEffect = this.lw;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.d ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.lw;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.wa;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.d) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.wa;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.gh;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.d ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.gh;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.op;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.d) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.op;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if ((z || this.et == null || this.zg.size() <= 0 || !this.et.hf()) ? z : true) {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.w(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void e() {
        int w2 = this.c.w();
        for (int i = 0; i < w2; i++) {
            ((tf) this.c.u(i).getLayoutParams()).w = true;
        }
        this.kd.tf();
    }

    public void f() {
        if (this.gh == null) {
            EdgeEffect xj2 = this.bl.xj(this, 2);
            this.gh = xj2;
            if (this.d) {
                xj2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                xj2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View u2 = this.am.u(view, i);
        if (u2 != null) {
            return u2;
        }
        boolean z2 = (this.g == null || this.am == null || am() || this.pz) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.am.u()) {
                int i2 = i == 2 ? MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (ws) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.am.w()) {
                int i3 = (this.am.e() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (ws) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                u();
                if (w(view) == null) {
                    return null;
                }
                kd();
                this.am.xj(view, i, this.kd, this.q);
                xj(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                u();
                if (w(view) == null) {
                    return null;
                }
                kd();
                view2 = this.am.xj(view, i, this.kd, this.q);
                xj(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return xj(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        xj(view2, (View) null);
        return view;
    }

    public void g() {
        hf(true);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        d dVar = this.am;
        if (dVar != null) {
            return dVar.hf();
        }
        throw new IllegalStateException(A2egSU.AcNBzu(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        d dVar = this.am;
        if (dVar != null) {
            return dVar.xj(getContext(), attributeSet);
        }
        throw new IllegalStateException(A2egSU.AcNBzu(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public xj getAdapter() {
        return this.g;
    }

    @Override // android.view.View
    public int getBaseline() {
        d dVar = this.am;
        return dVar != null ? dVar.yo() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        u uVar = this.oa;
        return uVar == null ? super.getChildDrawingOrder(i, i2) : uVar.xj(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.d;
    }

    public kd getEdgeEffectFactory() {
        return this.bl;
    }

    public y getItemAnimator() {
        return this.et;
    }

    public int getItemDecorationCount() {
        return this.zg.size();
    }

    public d getLayoutManager() {
        return this.am;
    }

    public int getMaxFlingVelocity() {
        return this.ft;
    }

    public int getMinFlingVelocity() {
        return this.se;
    }

    public long getNanoTime() {
        if (u) {
            return System.nanoTime();
        }
        return 0L;
    }

    public pl getOnFlingListener() {
        return this.ne;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.k;
    }

    public qt getRecycledViewPool() {
        return this.kd.c();
    }

    public int getScrollState() {
        return this.gy;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hf();
    }

    public void hf() {
        this.y = new com.bytedance.sdk.component.widget.recycler.xj(new xj.InterfaceC0127xj() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public void hf(int i, int i2) {
                RecyclerView.this.xj(i, i2, false);
                RecyclerView.this.z = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public void u(int i, int i2) {
                RecyclerView.this.y(i, i2);
                RecyclerView.this.z = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public void w(int i, int i2) {
                RecyclerView.this.c(i, i2);
                RecyclerView.this.z = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public ra xj(int i) {
                ra xj2 = RecyclerView.this.xj(i, true);
                if (xj2 == null || RecyclerView.this.c.w(xj2.xj)) {
                    return null;
                }
                return xj2;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public void xj(int i, int i2) {
                RecyclerView.this.xj(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.z = true;
                recyclerView.q.w += i2;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xj.InterfaceC0127xj
            public void xj(int i, int i2, Object obj) {
                RecyclerView.this.xj(i, i2, obj);
                RecyclerView.this.j = true;
            }
        });
    }

    public void ht() {
        ra raVar;
        int hf2 = this.c.hf();
        for (int i = 0; i < hf2; i++) {
            View hf3 = this.c.hf(i);
            ra hf4 = hf(hf3);
            if (hf4 != null && (raVar = hf4.d) != null) {
                View view = raVar.xj;
                int left = hf3.getLeft();
                int top = hf3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.e;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().xj();
    }

    public void jk() {
        int w2 = this.c.w();
        for (int i = 0; i < w2; i++) {
            ra kd2 = kd(this.c.u(i));
            if (kd2 != null && !kd2.L_()) {
                kd2.hf(6);
            }
        }
        e();
        this.kd.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.dq = r0
            r1 = 1
            r5.e = r1
            boolean r2 = r5.v
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.v = r1
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r1 = r5.am
            if (r1 == 0) goto L1e
            r1.hf(r5)
        L1e:
            r5.en = r0
            boolean r0 = com.bytedance.sdk.component.widget.recycler.RecyclerView.u
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<com.bytedance.sdk.component.widget.recycler.u> r0 = com.bytedance.sdk.component.widget.recycler.u.xj
            java.lang.Object r1 = r0.get()
            com.bytedance.sdk.component.widget.recycler.u r1 = (com.bytedance.sdk.component.widget.recycler.u) r1
            r5.x = r1
            if (r1 != 0) goto L5c
            com.bytedance.sdk.component.widget.recycler.u r1 = new com.bytedance.sdk.component.widget.recycler.u
            r1.<init>()
            r5.x = r1
            android.view.Display r1 = com.bytedance.sdk.component.widget.recycler.xj.w.c.c(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            com.bytedance.sdk.component.widget.recycler.u r2 = r5.x
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.u = r3
            r0.set(r2)
        L5c:
            com.bytedance.sdk.component.widget.recycler.u r0 = r5.x
            r0.xj(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.u uVar;
        super.onDetachedFromWindow();
        y yVar = this.et;
        if (yVar != null) {
            yVar.u();
        }
        y();
        this.e = false;
        d dVar = this.am;
        if (dVar != null) {
            dVar.hf(this, this.kd);
        }
        this.f10246a.clear();
        removeCallbacks(this.lm);
        this.f.hf();
        if (!u || (uVar = this.x) == null) {
            return;
        }
        uVar.hf(this);
        this.x = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.zg.size();
        for (int i = 0; i < size; i++) {
            this.zg.get(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r0 = r5.am
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.pz
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r0 = r5.am
            boolean r0 = r0.u()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r3 = r5.am
            boolean r3 = r3.w()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L63
        L3c:
            r3 = 0
            goto L63
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L61
            r0 = 26
            float r3 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r0 = r5.am
            boolean r0 = r0.u()
            if (r0 == 0) goto L57
            float r0 = -r3
            goto L3c
        L57:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$d r0 = r5.am
            boolean r0 = r0.w()
            if (r0 == 0) goto L61
            r0 = 0
            goto L63
        L61:
            r0 = 0
            goto L3c
        L63:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6b
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6b:
            float r2 = r5.rg
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.t
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.xj(r2, r0, r6)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.pz) {
            return false;
        }
        if (xj(motionEvent)) {
            z();
            return true;
        }
        d dVar = this.am;
        if (dVar == null) {
            return false;
        }
        boolean w2 = dVar.w();
        boolean u2 = this.am.u();
        if (this.ss == null) {
            this.ss = VelocityTracker.obtain();
        }
        this.ss.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.wn) {
                this.wn = false;
            }
            this.nb = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.xv = x;
            this.gj = x;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.vl = y2;
            this.cy = y2;
            if (this.gy == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.my;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = w2;
            if (u2) {
                i = (w2 ? 1 : 0) | 2;
            }
            d(i, 0);
        } else if (actionMasked == 1) {
            this.ss.clear();
            f(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.nb);
            if (findPointerIndex < 0) {
                com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Error processing scroll; pointer index for id " + this.nb + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.gy != 1) {
                int i2 = x2 - this.gj;
                int i3 = y3 - this.cy;
                if (w2 == 0 || Math.abs(i2) <= this.h) {
                    z = false;
                } else {
                    this.xv = x2;
                    z = true;
                }
                if (u2 && Math.abs(i3) > this.h) {
                    this.vl = y3;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            z();
        } else if (actionMasked == 5) {
            this.nb = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.xv = x3;
            this.gj = x3;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.vl = y4;
            this.cy = y4;
        } else if (actionMasked == 6) {
            w(motionEvent);
        }
        return this.gy == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV OnLayout");
        zg();
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
        this.v = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        d dVar = this.am;
        if (dVar == null) {
            kd(i, i2);
            return;
        }
        if (dVar.xj()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.am.xj(this.kd, this.q, i, i2);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.g == null) {
                return;
            }
            if (this.q.u == 1) {
                b();
            }
            this.am.hf(i, i2);
            this.q.d = true;
            ws();
            this.am.w(i, i2);
            if (this.am.d()) {
                this.am.hf(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.q.d = true;
                ws();
                this.am.w(i, i2);
                return;
            }
            return;
        }
        if (this.yo) {
            this.am.xj(this.kd, this.q, i, i2);
            return;
        }
        if (this.ht) {
            kd();
            pl();
            l();
            g();
            jk jkVar = this.q;
            if (jkVar.p) {
                jkVar.c = true;
            } else {
                this.y.kd();
                this.q.c = false;
            }
            this.ht = false;
            xj(false);
        } else if (this.q.p) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        xj xjVar = this.g;
        if (xjVar != null) {
            this.q.kd = xjVar.xj();
        } else {
            this.q.kd = 0;
        }
        kd();
        this.am.xj(this.kd, this.q, i, i2);
        xj(false);
        this.q.c = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (am()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p() {
        this.op = null;
        this.wa = null;
        this.gh = null;
        this.lw = null;
    }

    public void pl() {
        this.dq++;
    }

    public boolean pz() {
        return !this.v || this.ra || this.y.u();
    }

    public void qt() {
        if (this.en || !this.e) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(this, this.lm);
        this.en = true;
    }

    public void ra() {
        int i;
        for (int size = this.f10246a.size() - 1; size >= 0; size--) {
            ra raVar = this.f10246a.get(size);
            if (raVar.xj.getParent() == this && !raVar.L_() && (i = raVar.qt) != -1) {
                com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(raVar.xj, i);
                raVar.qt = -1;
            }
        }
        this.f10246a.clear();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        ra kd2 = kd(view);
        if (kd2 != null) {
            if (kd2.yo()) {
                kd2.g();
            } else if (!kd2.L_()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(kd2);
                throw new IllegalArgumentException(A2egSU.AcNBzu(this, sb));
            }
        }
        view.clearAnimation();
        p(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.am.xj(this, this.q, view, view2) && view2 != null) {
            xj(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.am.xj(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.hl.size();
        for (int i = 0; i < size; i++) {
            this.hl.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.dc != 0 || this.pz) {
            this.jk = true;
        } else {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        d dVar = this.am;
        if (dVar == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.pz) {
            return;
        }
        boolean w2 = dVar.w();
        boolean u2 = this.am.u();
        if (w2 || u2) {
            if (!w2) {
                i = 0;
            }
            if (!u2) {
                i2 = 0;
            }
            xj(i, i2, (MotionEvent) null);
        }
    }

    public void setAdapter(xj xjVar) {
        setLayoutFrozen(false);
        xj(xjVar, false, true);
        w(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(u uVar) {
        if (uVar != this.oa) {
            this.oa = uVar;
            setChildrenDrawingOrderEnabled(uVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.d) {
            p();
        }
        this.d = z;
        super.setClipToPadding(z);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(kd kdVar) {
        xj(kdVar);
        this.bl = kdVar;
        p();
    }

    public void setHasFixedSize(boolean z) {
        this.yo = z;
    }

    public void setItemAnimator(y yVar) {
        y yVar2 = this.et;
        if (yVar2 != null) {
            yVar2.u();
            this.et.xj(null);
        }
        this.et = yVar;
        if (yVar != null) {
            yVar.xj(this.le);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.kd.xj(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.pz) {
            xj("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.pz = true;
                this.wn = true;
                y();
                return;
            }
            this.pz = false;
            if (this.jk && this.am != null && this.g != null) {
                requestLayout();
            }
            this.jk = false;
        }
    }

    public void setLayoutManager(d dVar) {
        if (dVar != this.am) {
            y();
            if (this.am != null) {
                y yVar = this.et;
                if (yVar != null) {
                    yVar.u();
                }
                this.am.w(this.kd);
                this.am.hf(this.kd);
                this.kd.xj();
                if (this.e) {
                    this.am.hf(this, this.kd);
                }
                this.am.xj((RecyclerView) null);
                this.am = null;
            } else {
                this.kd.xj();
            }
            this.c.xj();
            this.am = dVar;
            if (dVar != null) {
                if (dVar.d != null) {
                    StringBuilder sb = new StringBuilder("LayoutManager ");
                    sb.append(dVar);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(A2egSU.AcNBzu(dVar.d, sb));
                }
                dVar.xj(this);
                if (this.e) {
                    this.am.hf(this);
                }
            }
            this.kd.hf();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().xj(z);
    }

    public void setOnFlingListener(pl plVar) {
        this.ne = plVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.k = z;
    }

    public void setRecycledViewPool(qt qtVar) {
        this.kd.xj(qtVar);
    }

    public void setRecyclerListener(e eVar) {
        this.qt = eVar;
    }

    public void setScrollState(int i) {
        if (i != this.gy) {
            this.gy = i;
            if (i != 2) {
                x();
            }
            c(i);
        }
    }

    public void setViewCacheExtension(pz pzVar) {
        this.kd.xj(pzVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().hf(i);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.xj.w.hf
    public void stopNestedScroll() {
        getScrollingChildHelper().w();
    }

    public void tf() {
        if (this.op == null) {
            EdgeEffect xj2 = this.bl.xj(this, 3);
            this.op = xj2;
            if (this.d) {
                xj2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                xj2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void u() {
        if (this.v && !this.ra) {
            if (!this.y.u()) {
                return;
            }
            if (this.y.xj(4) && !this.y.xj(11)) {
                com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV PartialInvalidate");
                kd();
                pl();
                this.y.hf();
                if (!this.jk) {
                    if (io()) {
                        zg();
                    } else {
                        this.y.w();
                    }
                }
                xj(true);
                g();
                com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
                return;
            }
            if (!this.y.u()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV FullInvalidate");
        zg();
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
    }

    public void v() {
        int w2 = this.c.w();
        for (int i = 0; i < w2; i++) {
            ra kd2 = kd(this.c.u(i));
            if (!kd2.L_()) {
                kd2.xj();
            }
        }
        this.kd.d();
    }

    public void w() {
        y yVar = this.et;
        if (yVar != null) {
            yVar.u();
        }
        d dVar = this.am;
        if (dVar != null) {
            dVar.w(this.kd);
            this.am.hf(this.kd);
        }
        this.kd.xj();
    }

    public void y() {
        setScrollState(0);
        x();
    }

    public void yo() {
        int w2 = this.c.w();
        for (int i = 0; i < w2; i++) {
            ra kd2 = kd(this.c.u(i));
            if (!kd2.L_()) {
                kd2.hf();
            }
        }
    }

    public void zg() {
        if (this.g == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.am == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        jk jkVar = this.q;
        jkVar.d = false;
        if (jkVar.u == 1) {
            b();
        } else if (!this.y.y() && this.am.ht() == getWidth() && this.am.ra() == getHeight()) {
            this.am.u(this);
            eu();
        }
        this.am.u(this);
        ws();
        eu();
    }

    public static class hf extends Observable<w> {
        public void xj() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((w) ((Observable) this).mObservers.get(size)).xj();
            }
        }

        public void xj(int i, int i2) {
            xj(i, i2, null);
        }

        public void xj(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((w) ((Observable) this).mObservers.get(size)).xj(i, i2, obj);
            }
        }
    }

    public static class jk {
        int am;
        private SparseArray<Object> e;
        long g;

        /* renamed from: pl, reason: collision with root package name */
        int f10250pl;
        int qt;
        int zg;
        int xj = -1;
        int hf = 0;
        int w = 0;
        int u = 1;
        int kd = 0;
        boolean y = false;
        boolean c = false;
        boolean f = false;
        boolean d = false;
        boolean tf = false;
        boolean p = false;

        public boolean hf() {
            return this.p;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.xj + ", mData=" + this.e + ", mItemCount=" + this.kd + ", mIsMeasuring=" + this.d + ", mPreviousLayoutItemCount=" + this.hf + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.w + ", mStructureChanged=" + this.y + ", mInPreLayout=" + this.c + ", mRunSimpleAnimations=" + this.tf + ", mRunPredictiveAnimations=" + this.p + '}';
        }

        public int u() {
            return this.c ? this.hf - this.w : this.kd;
        }

        public boolean w() {
            return this.xj != -1;
        }

        public void xj(int i) {
            if ((this.u & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.u));
        }

        public void xj(xj xjVar) {
            this.u = 1;
            this.kd = xjVar.xj();
            this.c = false;
            this.f = false;
            this.d = false;
        }

        public boolean xj() {
            return this.c;
        }
    }

    public static class qt {
        SparseArray<xj> xj = new SparseArray<>();
        private int hf = 0;

        public static class xj {
            final ArrayList<ra> xj = new ArrayList<>();
            int hf = 5;
            long w = 0;
            long u = 0;
        }

        public void hf(int i, long j) {
            xj hf = hf(i);
            hf.u = xj(hf.u, j);
        }

        public void w() {
            this.hf--;
        }

        public void xj() {
            for (int i = 0; i < this.xj.size(); i++) {
                this.xj.valueAt(i).xj.clear();
            }
        }

        public boolean hf(int i, long j, long j2) {
            long j3 = hf(i).u;
            return j3 == 0 || j + j3 < j2;
        }

        public void hf() {
            this.hf++;
        }

        public ra xj(int i) {
            xj xjVar = this.xj.get(i);
            if (xjVar == null || xjVar.xj.isEmpty()) {
                return null;
            }
            return xjVar.xj.remove(r2.size() - 1);
        }

        private xj hf(int i) {
            xj xjVar = this.xj.get(i);
            if (xjVar != null) {
                return xjVar;
            }
            xj xjVar2 = new xj();
            this.xj.put(i, xjVar2);
            return xjVar2;
        }

        public void xj(ra raVar) {
            int f = raVar.f();
            ArrayList<ra> arrayList = hf(f).xj;
            if (this.xj.get(f).hf > arrayList.size()) {
                raVar.ht();
                arrayList.add(raVar);
            }
        }

        public long xj(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }

        public void xj(int i, long j) {
            xj hf = hf(i);
            hf.w = xj(hf.w, j);
        }

        public boolean xj(int i, long j, long j2) {
            long j3 = hf(i).w;
            return j3 == 0 || j + j3 < j2;
        }

        public void xj(xj xjVar, xj xjVar2, boolean z) {
            if (xjVar != null) {
                w();
            }
            if (!z && this.hf == 0) {
                xj();
            }
            if (xjVar2 != null) {
                hf();
            }
        }
    }

    public static abstract class ra {
        private static final List<Object> e = Collections.EMPTY_LIST;
        WeakReference<RecyclerView> hf;
        int tf;
        public final View xj;
        RecyclerView zg;
        int w = -1;
        int u = -1;
        long kd = -1;
        int y = -1;
        int c = -1;
        ra f = null;
        ra d = null;
        List<Object> p = null;

        /* renamed from: pl, reason: collision with root package name */
        List<Object> f10251pl = null;
        private int yo = 0;
        zg g = null;
        boolean am = false;
        private int v = 0;
        int qt = -1;

        static {
            HLtZ();
        }

        public ra(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.xj = view;
        }

        private static /* synthetic */ void HLtZ() {
            char[] charArray = "\t\u0005\u0007D\r\u000b\u0007\u000fD\b\u0005\u0013D\u0019\u0002\u000f\u0006\u0006D \u0004\u0003(\u0018\u0003\u000e\r\u000f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'j');
            }
            String str = new String(charArray);
            char[] charArray2 = "\t\u0006\u0003\u0004\u0003\u001e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'j');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        private void x() {
            if (this.p == null) {
                ArrayList arrayList = new ArrayList();
                this.p = arrayList;
                this.f10251pl = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean L_() {
            return (this.tf & r.b.d) != 0;
        }

        public boolean am() {
            return (this.tf & 4) != 0;
        }

        public final long c() {
            return this.kd;
        }

        public boolean d() {
            return this.g != null;
        }

        public boolean dk() {
            return (this.tf & 16) != 0;
        }

        public boolean e() {
            return (this.tf & 8) != 0;
        }

        public boolean et() {
            return (this.tf & 16) == 0 && com.bytedance.sdk.component.widget.recycler.xj.w.c.y(this.xj);
        }

        public final int f() {
            return this.y;
        }

        public void g() {
            this.tf &= -257;
        }

        public void hf() {
            if (this.u == -1) {
                this.u = this.w;
            }
        }

        public void ht() {
            this.tf = 0;
            this.w = -1;
            this.u = -1;
            this.kd = -1L;
            this.c = -1;
            this.yo = 0;
            this.f = null;
            this.d = null;
            jk();
            this.v = 0;
            this.qt = -1;
            RecyclerView.w(this);
        }

        public boolean io() {
            return (this.tf & 2) != 0;
        }

        public void jk() {
            List<Object> list = this.p;
            if (list != null) {
                list.clear();
            }
            this.tf &= -1025;
        }

        public final int kd() {
            RecyclerView recyclerView = this.zg;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.u(this);
        }

        public boolean p() {
            return (this.tf & 32) != 0;
        }

        public void pl() {
            this.tf &= -33;
        }

        public List<Object> pz() {
            if ((this.tf & 1024) != 0) {
                return e;
            }
            List<Object> list = this.p;
            return (list == null || list.size() == 0) ? e : this.f10251pl;
        }

        public boolean qt() {
            return (this.tf & 2) != 0;
        }

        public final boolean ra() {
            return (this.tf & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.xj.w.c.y(this.xj);
        }

        public void tf() {
            this.g.w(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.w + " id=" + this.kd + ", oldPos=" + this.u + ", pLpos:" + this.c);
            if (d()) {
                sb.append(" scrap ");
                sb.append(this.am ? "[changeScrap]" : "[attachedScrap]");
            }
            if (am()) {
                sb.append(" invalid");
            }
            if (!zg()) {
                sb.append(" unbound");
            }
            if (qt()) {
                sb.append(" update");
            }
            if (e()) {
                sb.append(" removed");
            }
            if (L_()) {
                sb.append(" ignored");
            }
            if (yo()) {
                sb.append(" tmpDetached");
            }
            if (!ra()) {
                sb.append(" not recyclable(" + this.yo + ")");
            }
            if (v()) {
                sb.append(" undefined adapter position");
            }
            if (this.xj.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final int u() {
            int i = this.c;
            return i == -1 ? this.w : i;
        }

        public boolean v() {
            return (this.tf & 512) != 0 || am();
        }

        public void xj(int i, int i2, boolean z) {
            hf(8);
            xj(i2, z);
            this.w = i;
        }

        public final int y() {
            return this.u;
        }

        public boolean yo() {
            return (this.tf & 256) != 0;
        }

        public boolean zg() {
            return (this.tf & 1) != 0;
        }

        public void hf(int i) {
            this.tf = i | this.tf;
        }

        public void hf(RecyclerView recyclerView) {
            recyclerView.xj(this, this.v);
            this.v = 0;
        }

        public void xj(int i, boolean z) {
            if (this.u == -1) {
                this.u = this.w;
            }
            if (this.c == -1) {
                this.c = this.w;
            }
            if (z) {
                this.c += i;
            }
            this.w += i;
            if (this.xj.getLayoutParams() != null) {
                ((tf) this.xj.getLayoutParams()).w = true;
            }
        }

        public void xj() {
            this.u = -1;
            this.c = -1;
        }

        public void xj(zg zgVar, boolean z) {
            this.g = zgVar;
            this.am = z;
        }

        public boolean xj(int i) {
            return (i & this.tf) != 0;
        }

        public void xj(int i, int i2) {
            this.tf = (i & i2) | (this.tf & (~i2));
        }

        public void xj(Object obj) {
            if (obj == null) {
                hf(1024);
            } else if ((1024 & this.tf) == 0) {
                x();
                this.p.add(obj);
            }
        }

        public void xj(RecyclerView recyclerView) {
            int i = this.qt;
            if (i != -1) {
                this.v = i;
            } else {
                this.v = com.bytedance.sdk.component.widget.recycler.xj.w.c.hf(this.xj);
            }
            recyclerView.xj(this, 4);
        }

        public final void xj(boolean z) {
            int i = this.yo;
            int i2 = z ? i - 1 : i + 1;
            this.yo = i2;
            if (i2 < 0) {
                this.yo = 0;
                com.bytedance.sdk.component.utils.pl.u("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.tf |= 16;
            } else if (z && i2 == 0) {
                this.tf &= -17;
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int g(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public void hf(am amVar) {
        List<am> list = this.zb;
        if (list != null) {
            list.remove(amVar);
        }
    }

    public void p(View view) {
        kd(view);
        List<p> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).hf(view);
            }
        }
    }

    public void pl(View view) {
        kd(view);
        List<p> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).xj(view);
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new yo();
        this.kd = new zg();
        this.f = new com.bytedance.sdk.component.widget.recycler.am();
        this.tf = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.v || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.e) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.pz) {
                    recyclerView2.jk = true;
                } else {
                    recyclerView2.u();
                }
            }
        };
        this.p = new Rect();
        this.yy = new Rect();
        this.f10248pl = new RectF();
        this.zg = new ArrayList<>();
        this.hl = new ArrayList<>();
        this.dc = 0;
        this.ra = false;
        this.dk = false;
        this.dq = 0;
        this.qd = 0;
        this.bl = new kd();
        this.et = new com.bytedance.sdk.component.widget.recycler.w();
        this.gy = 0;
        this.nb = -1;
        this.rg = Float.MIN_VALUE;
        this.t = Float.MIN_VALUE;
        this.k = true;
        this.f10247io = new ht();
        this.ai = u ? new u.xj() : null;
        this.q = new jk();
        this.z = false;
        this.j = false;
        this.le = new c();
        this.en = false;
        this.i = new int[2];
        this.si = new int[2];
        this.l = new int[2];
        this.my = new int[2];
        this.ff = new int[2];
        this.f10246a = new ArrayList();
        this.lm = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                y yVar = RecyclerView.this.et;
                if (yVar != null) {
                    yVar.xj();
                }
                RecyclerView.this.en = false;
            }
        };
        this.vi = new am.hf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.am.hf
            public void hf(ra raVar, y.hf hfVar, y.hf hfVar2) {
                RecyclerView.this.xj(raVar, hfVar, hfVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.am.hf
            public void w(ra raVar, y.hf hfVar, y.hf hfVar2) {
                raVar.xj(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.ra) {
                    if (recyclerView.et.xj(raVar, raVar, hfVar, hfVar2)) {
                        RecyclerView.this.qt();
                    }
                } else if (recyclerView.et.w(raVar, hfVar, hfVar2)) {
                    RecyclerView.this.qt();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.am.hf
            public void xj(ra raVar, y.hf hfVar, y.hf hfVar2) {
                RecyclerView.this.kd.w(raVar);
                RecyclerView.this.hf(raVar, hfVar, hfVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.am.hf
            public void xj(ra raVar) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.am.xj(raVar.xj, recyclerView.kd);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, 0);
                this.d = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
        } else {
            this.d = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.h = viewConfiguration.getScaledTouchSlop();
        this.rg = com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(viewConfiguration, context);
        this.t = com.bytedance.sdk.component.widget.recycler.xj.w.c.hf(viewConfiguration, context);
        this.se = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ft = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.et.xj(this.le);
        hf();
        et();
        dk();
        if (com.bytedance.sdk.component.widget.recycler.xj.w.c.hf(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(this, 1);
        }
        this.tu = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        setNestedScrollingEnabled(true);
    }

    public void y(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int w2 = this.c.w();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < w2; i7++) {
            ra kd2 = kd(this.c.u(i7));
            if (kd2 != null && (i6 = kd2.w) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    kd2.xj(i2 - i, false);
                } else {
                    kd2.xj(i5, false);
                }
                this.q.y = true;
            }
        }
        this.kd.xj(i, i2);
        requestLayout();
    }

    public static class tf extends ViewGroup.MarginLayoutParams {
        final Rect hf;
        boolean u;
        boolean w;
        ra xj;

        public tf(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.hf = new Rect();
            this.w = true;
            this.u = false;
        }

        public boolean hf() {
            return this.xj.e();
        }

        public int u() {
            return this.xj.u();
        }

        public boolean w() {
            return this.xj.io();
        }

        public boolean xj() {
            return this.xj.am();
        }

        public tf(int i, int i2) {
            super(i, i2);
            this.hf = new Rect();
            this.w = true;
            this.u = false;
        }

        public tf(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.hf = new Rect();
            this.w = true;
            this.u = false;
        }

        public tf(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.hf = new Rect();
            this.w = true;
            this.u = false;
        }

        public tf(tf tfVar) {
            super((ViewGroup.MarginLayoutParams) tfVar);
            this.hf = new Rect();
            this.w = true;
            this.u = false;
        }
    }

    public static abstract class v {
        private boolean f;
        private RecyclerView hf;
        private boolean kd;
        private boolean u;
        private d w;
        private View y;
        private int xj = -1;
        private final xj c = new xj(0, 0);

        public interface hf {
            PointF w(int i);
        }

        public static class xj {
            private int c;
            private int hf;
            private Interpolator kd;
            private int u;
            private int w;
            private int xj;
            private boolean y;

            public xj(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void hf() {
                if (this.kd != null && this.w <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.w <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.xj = i;
                this.hf = i2;
                this.w = i3;
                this.kd = interpolator;
                this.y = true;
            }

            public void xj(int i) {
                this.u = i;
            }

            public xj(int i, int i2, int i3, Interpolator interpolator) {
                this.u = -1;
                this.y = false;
                this.c = 0;
                this.xj = i;
                this.hf = i2;
                this.w = i3;
                this.kd = interpolator;
            }

            public boolean xj() {
                return this.u >= 0;
            }

            public void xj(RecyclerView recyclerView) {
                int i = this.u;
                if (i >= 0) {
                    this.u = -1;
                    recyclerView.xj(i);
                    this.y = false;
                    return;
                }
                if (this.y) {
                    hf();
                    Interpolator interpolator = this.kd;
                    if (interpolator == null) {
                        int i2 = this.w;
                        if (i2 == Integer.MIN_VALUE) {
                            recyclerView.f10247io.hf(this.xj, this.hf);
                        } else {
                            recyclerView.f10247io.xj(this.xj, this.hf, i2);
                        }
                    } else {
                        recyclerView.f10247io.xj(this.xj, this.hf, this.w, interpolator);
                    }
                    int i3 = this.c + 1;
                    this.c = i3;
                    if (i3 > 10) {
                        com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.y = false;
                    return;
                }
                this.c = 0;
            }
        }

        public boolean c() {
            return this.kd;
        }

        public int d() {
            return this.hf.am.v();
        }

        public int f() {
            return this.xj;
        }

        public void hf(View view) {
            if (xj(view) == f()) {
                this.y = view;
            }
        }

        public final void kd() {
            if (this.kd) {
                this.kd = false;
                xj();
                this.hf.q.xj = -1;
                this.y = null;
                this.xj = -1;
                this.u = false;
                this.w.hf(this);
                this.w = null;
                this.hf = null;
            }
        }

        public PointF u(int i) {
            Object u = u();
            if (u instanceof hf) {
                return ((hf) u).w(i);
            }
            com.bytedance.sdk.component.utils.pl.hf("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + hf.class.getCanonicalName());
            return null;
        }

        public void w(int i) {
            this.xj = i;
        }

        public abstract void xj();

        public abstract void xj(int i, int i2, jk jkVar, xj xjVar);

        public abstract void xj(View view, jk jkVar, xj xjVar);

        public void xj(RecyclerView recyclerView, d dVar) {
            if (this.f) {
                com.bytedance.sdk.component.utils.pl.hf("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.hf = recyclerView;
            this.w = dVar;
            int i = this.xj;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.q.xj = i;
            this.kd = true;
            this.u = true;
            this.y = kd(f());
            this.hf.f10247io.xj();
            this.f = true;
        }

        public boolean y() {
            return this.u;
        }

        public d u() {
            return this.w;
        }

        public View kd(int i) {
            return this.hf.am.hf(i);
        }

        public void xj(int i, int i2) {
            PointF u;
            RecyclerView recyclerView = this.hf;
            if (!this.kd || this.xj == -1 || recyclerView == null) {
                kd();
            }
            if (this.u && this.y == null && this.w != null && (u = u(this.xj)) != null) {
                float f = u.x;
                if (f != 0.0f || u.y != 0.0f) {
                    recyclerView.xj((int) Math.signum(f), (int) Math.signum(u.y), (int[]) null);
                }
            }
            this.u = false;
            View view = this.y;
            if (view != null) {
                if (xj(view) == this.xj) {
                    xj(this.y, recyclerView.q, this.c);
                    this.c.xj(recyclerView);
                    kd();
                } else {
                    com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.y = null;
                }
            }
            if (this.kd) {
                xj(i, i2, recyclerView.q, this.c);
                boolean xj2 = this.c.xj();
                this.c.xj(recyclerView);
                if (xj2) {
                    if (this.kd) {
                        this.u = true;
                        recyclerView.f10247io.xj();
                    } else {
                        kd();
                    }
                }
            }
        }

        public int xj(View view) {
            return this.hf.f(view);
        }

        public void xj(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    public void hf(int i) {
        if (this.pz) {
            return;
        }
        d dVar = this.am;
        if (dVar == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            dVar.xj(this, this.q, i);
        }
    }

    public class yo extends w {
        public yo() {
        }

        public void hf() {
            if (RecyclerView.w) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.yo && recyclerView.e) {
                    com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(recyclerView, recyclerView.tf);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.ht = true;
            recyclerView2.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.w
        public void xj() {
            RecyclerView.this.xj((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.q.y = true;
            recyclerView.w(true);
            if (RecyclerView.this.y.u()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.w
        public void xj(int i, int i2, Object obj) {
            RecyclerView.this.xj((String) null);
            if (RecyclerView.this.y.xj(i, i2, obj)) {
                hf();
            }
        }
    }

    public String xj() {
        return " " + super.toString() + ", adapter:" + this.g + ", layout:" + this.am + ", context:" + getContext();
    }

    private boolean tf(int i, int i2) {
        xj(this.i);
        int[] iArr = this.i;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void xj(xj xjVar, boolean z, boolean z2) {
        xj xjVar2 = this.g;
        if (xjVar2 != null) {
            xjVar2.hf(this.n);
        }
        if (!z || z2) {
            w();
        }
        this.y.xj();
        xj xjVar3 = this.g;
        this.g = xjVar;
        if (xjVar != null) {
            xjVar.xj(this.n);
        }
        this.kd.xj(xjVar3, this.g, z);
        this.q.y = true;
    }

    public void c(int i, int i2) {
        int w2 = this.c.w();
        for (int i3 = 0; i3 < w2; i3++) {
            ra kd2 = kd(this.c.u(i3));
            if (kd2 != null && !kd2.L_() && kd2.w >= i) {
                kd2.xj(i2, false);
                this.q.y = true;
            }
        }
        this.kd.hf(i, i2);
        requestLayout();
    }

    public Rect d(View view) {
        tf tfVar = (tf) view.getLayoutParams();
        if (!tfVar.w) {
            return tfVar.hf;
        }
        if (this.q.xj() && (tfVar.w() || tfVar.xj())) {
            return tfVar.hf;
        }
        Rect rect = tfVar.hf;
        rect.set(0, 0, 0, 0);
        int size = this.zg.size();
        for (int i = 0; i < size; i++) {
            this.p.set(0, 0, 0, 0);
            this.zg.get(i).xj(this.p, view, this, this.q);
            int i2 = rect.left;
            Rect rect2 = this.p;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        tfVar.w = false;
        return rect;
    }

    public int f(View view) {
        ra kd2 = kd(view);
        if (kd2 != null) {
            return kd2.u();
        }
        return -1;
    }

    public void w(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.lw;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.lw.onRelease();
            z = this.lw.isFinished();
        }
        EdgeEffect edgeEffect2 = this.gh;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.gh.onRelease();
            z |= this.gh.isFinished();
        }
        EdgeEffect edgeEffect3 = this.wa;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.wa.onRelease();
            z |= this.wa.isFinished();
        }
        EdgeEffect edgeEffect4 = this.op;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.op.onRelease();
            z |= this.op.isFinished();
        }
        if (z) {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.w(this);
        }
    }

    public static RecyclerView tf(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView tf2 = tf(viewGroup.getChildAt(i));
            if (tf2 != null) {
                return tf2;
            }
        }
        return null;
    }

    public void f(int i, int i2) {
        this.qd++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        am amVar = this.da;
        if (amVar != null) {
            amVar.xj(this, i, i2);
        }
        List<am> list = this.zb;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.zb.get(size).xj(this, i, i2);
            }
        }
        this.qd--;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean hf(int i, int i2) {
        d dVar = this.am;
        if (dVar == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.pz) {
            return false;
        }
        int w2 = dVar.w();
        boolean u2 = this.am.u();
        if (w2 == 0 || Math.abs(i) < this.se) {
            i = 0;
        }
        if (!u2 || Math.abs(i2) < this.se) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f2 = i;
        float f3 = i2;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = w2 != 0 || u2;
            dispatchNestedFling(f2, f3, z);
            pl plVar = this.ne;
            if (plVar != null && plVar.xj(i, i2)) {
                return true;
            }
            if (z) {
                if (u2) {
                    w2 = (w2 == true ? 1 : 0) | 2;
                }
                d(w2, 1);
                int i3 = this.ft;
                int max = Math.max(-i3, Math.min(i, i3));
                int i4 = this.ft;
                this.f10247io.xj(max, Math.max(-i4, Math.min(i2, i4)));
                return true;
            }
        }
        return false;
    }

    public void kd() {
        int i = this.dc + 1;
        this.dc = i;
        if (i != 1 || this.pz) {
            return;
        }
        this.jk = false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        d dVar = this.am;
        if (dVar != null) {
            return dVar.xj(layoutParams);
        }
        throw new IllegalStateException(A2egSU.AcNBzu(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public void kd(int i, int i2) {
        setMeasuredDimension(d.xj(i, getPaddingRight() + getPaddingLeft(), com.bytedance.sdk.component.widget.recycler.xj.w.c.u(this)), d.xj(i2, getPaddingBottom() + getPaddingTop(), com.bytedance.sdk.component.widget.recycler.xj.w.c.kd(this)));
    }

    @Deprecated
    public int y(View view) {
        return c(view);
    }

    public void y(int i) {
        int hf2 = this.c.hf();
        for (int i2 = 0; i2 < hf2; i2++) {
            this.c.hf(i2).offsetLeftAndRight(i);
        }
    }

    public int c(View view) {
        ra kd2 = kd(view);
        if (kd2 != null) {
            return kd2.kd();
        }
        return -1;
    }

    public static ra kd(View view) {
        if (view == null) {
            return null;
        }
        return ((tf) view.getLayoutParams()).xj;
    }

    public void c(int i) {
        d dVar = this.am;
        if (dVar != null) {
            dVar.p(i);
        }
        am amVar = this.da;
        if (amVar != null) {
            amVar.xj(this, i);
        }
        List<am> list = this.zb;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.zb.get(size).xj(this, i);
            }
        }
    }

    public void kd(int i) {
        int hf2 = this.c.hf();
        for (int i2 = 0; i2 < hf2; i2++) {
            this.c.hf(i2).offsetTopAndBottom(i);
        }
    }

    public void xj(p pVar) {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(pVar);
    }

    public void f(int i) {
        getScrollingChildHelper().w(i);
    }

    public boolean xj(View view) {
        kd();
        boolean y2 = this.c.y(view);
        if (y2) {
            ra kd2 = kd(view);
            this.kd.w(kd2);
            this.kd.hf(kd2);
        }
        xj(!y2);
        return y2;
    }

    public void u(int i, int i2) {
        if (i < 0) {
            c();
            this.lw.onAbsorb(-i);
        } else if (i > 0) {
            f();
            this.gh.onAbsorb(i);
        }
        if (i2 < 0) {
            d();
            this.wa.onAbsorb(-i2);
        } else if (i2 > 0) {
            tf();
            this.op.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.xj.w.c.w(this);
    }

    private void w(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.nb) {
            int i = actionIndex == 0 ? 1 : 0;
            this.nb = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.xv = x;
            this.gj = x;
            int y2 = (int) (motionEvent.getY(i) + 0.5f);
            this.vl = y2;
            this.cy = y2;
        }
    }

    public boolean d(int i, int i2) {
        return getScrollingChildHelper().xj(i, i2);
    }

    private boolean hf(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.vm != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.vm = null;
                }
                return true;
            }
            this.vm = null;
        }
        if (action != 0) {
            int size = this.hl.size();
            for (int i = 0; i < size; i++) {
                g gVar = this.hl.get(i);
                if (gVar.xj(this, motionEvent)) {
                    this.vm = gVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean d(int i) {
        return getScrollingChildHelper().xj(i);
    }

    public void xj(f fVar, int i) {
        d dVar = this.am;
        if (dVar != null) {
            dVar.xj("Cannot add item decoration during a scroll  or layout");
        }
        if (this.zg.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.zg.add(fVar);
        } else {
            this.zg.add(i, fVar);
        }
        e();
        requestLayout();
    }

    public void w(boolean z) {
        this.dk = z | this.dk;
        this.ra = true;
        jk();
    }

    public ra u(View view) {
        View w2 = w(view);
        if (w2 == null) {
            return null;
        }
        return hf(w2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View w(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            return r3
        L13:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.w(android.view.View):android.view.View");
    }

    public void hf(boolean z) {
        int i = this.dq - 1;
        this.dq = i;
        if (i <= 0) {
            this.dq = 0;
            if (z) {
                j();
                ra();
            }
        }
    }

    public ra u(int i) {
        ra raVar = null;
        if (this.ra) {
            return null;
        }
        int w2 = this.c.w();
        for (int i2 = 0; i2 < w2; i2++) {
            ra kd2 = kd(this.c.u(i2));
            if (kd2 != null && !kd2.e() && u(kd2) == i) {
                if (!this.c.w(kd2.xj)) {
                    return kd2;
                }
                raVar = kd2;
            }
        }
        return raVar;
    }

    public ra w(int i) {
        return xj(i, false);
    }

    public static void w(ra raVar) {
        WeakReference<RecyclerView> weakReference = raVar.hf;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == raVar.xj) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            raVar.hf = null;
        }
    }

    public void xj(f fVar) {
        xj(fVar, -1);
    }

    public void xj(am amVar) {
        if (this.zb == null) {
            this.zb = new ArrayList();
        }
        this.zb.add(amVar);
    }

    public void hf(ra raVar, y.hf hfVar, y.hf hfVar2) {
        kd(raVar);
        raVar.xj(false);
        if (this.et.xj(raVar, hfVar, hfVar2)) {
            qt();
        }
    }

    public int u(ra raVar) {
        if (raVar.xj(524) || !raVar.zg()) {
            return -1;
        }
        return this.y.w(raVar.w);
    }

    public void xj(int i) {
        d dVar = this.am;
        if (dVar != null) {
            dVar.u(i);
            awakenScrollBars();
        }
    }

    public boolean hf(ra raVar) {
        y yVar = this.et;
        return yVar == null || yVar.xj(raVar, raVar.pz());
    }

    public ra hf(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return kd(view);
    }

    public void xj(int i, int i2, int[] iArr) {
        kd();
        pl();
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV Scroll");
        xj(this.q);
        int xj2 = i != 0 ? this.am.xj(i, this.kd, this.q) : 0;
        int hf2 = i2 != 0 ? this.am.hf(i2, this.kd, this.q) : 0;
        com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
        ht();
        g();
        xj(false);
        if (iArr != null) {
            iArr[0] = xj2;
            iArr[1] = hf2;
        }
    }

    public boolean xj(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        u();
        if (this.g != null) {
            xj(i, i2, this.ff);
            int[] iArr = this.ff;
            int i7 = iArr[0];
            int i8 = iArr[1];
            i5 = i - i7;
            i6 = i2 - i8;
            i4 = i8;
            i3 = i7;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.zg.isEmpty()) {
            invalidate();
        }
        if (xj(i3, i4, i5, i6, this.si, 0)) {
            int i9 = this.xv;
            int[] iArr2 = this.si;
            int i10 = iArr2[0];
            this.xv = i9 - i10;
            int i11 = this.vl;
            int i12 = iArr2[1];
            this.vl = i11 - i12;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i10, i12);
            }
            int[] iArr3 = this.my;
            int i13 = iArr3[0];
            int[] iArr4 = this.si;
            iArr3[0] = i13 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(motionEvent, 8194)) {
                xj(motionEvent.getX(), i5, motionEvent.getY(), i6);
            }
            w(i, i2);
        }
        if (i3 != 0 || i4 != 0) {
            f(i3, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i3 == 0 && i4 == 0) ? false : true;
    }

    public void xj(boolean z) {
        if (this.dc <= 0) {
            this.dc = 1;
        }
        if (!z && !this.pz) {
            this.jk = false;
        }
        if (this.dc == 1) {
            if (z && this.jk && !this.pz && this.am != null && this.g != null) {
                zg();
            }
            if (!this.pz) {
                this.jk = false;
            }
        }
        this.dc--;
    }

    public void xj(int i, int i2) {
        xj(i, i2, (Interpolator) null);
    }

    public void xj(int i, int i2, Interpolator interpolator) {
        d dVar = this.am;
        if (dVar == null) {
            com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.pz) {
            return;
        }
        if (!dVar.w()) {
            i = 0;
        }
        if (!this.am.u()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.f10247io.xj(i, i2, interpolator);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.c()
            android.widget.EdgeEffect r3 = r6.lw
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            com.bytedance.sdk.component.widget.recycler.xj.w.xj.xj(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.f()
            android.widget.EdgeEffect r3 = r6.gh
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.xj.w.xj.xj(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.d()
            android.widget.EdgeEffect r9 = r6.wa
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            com.bytedance.sdk.component.widget.recycler.xj.w.xj.xj(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.tf()
            android.widget.EdgeEffect r9 = r6.op
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            com.bytedance.sdk.component.widget.recycler.xj.w.xj.xj(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7e
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7e
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            com.bytedance.sdk.component.widget.recycler.xj.w.c.w(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.xj(float, float, float, float):void");
    }

    public static <T> T xj(T t) {
        t.getClass();
        return t;
    }

    private boolean xj(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || w(view2) == null) {
            return false;
        }
        if (view == null || w(view) == null) {
            return true;
        }
        this.p.set(0, 0, view.getWidth(), view.getHeight());
        this.yy.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.p);
        offsetDescendantRectToMyCoords(view2, this.yy);
        char c2 = 65535;
        int i3 = this.am.e() == 1 ? -1 : 1;
        Rect rect = this.p;
        int i4 = rect.left;
        Rect rect2 = this.yy;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                c2 = 0;
            }
        }
        if (i == 1) {
            return c2 < 0 || (c2 == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return c2 > 0 || (c2 == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c2 < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c2 > 0;
        }
        StringBuilder sb = new StringBuilder("Invalid direction: ");
        sb.append(i);
        throw new IllegalArgumentException(A2egSU.AcNBzu(this, sb));
    }

    private void xj(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.p.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof tf) {
            tf tfVar = (tf) layoutParams;
            if (!tfVar.w) {
                Rect rect = tfVar.hf;
                Rect rect2 = this.p;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.p);
            offsetRectIntoDescendantCoords(view, this.p);
        }
        this.am.xj(this, view, this.p, !this.v, view2 == null);
    }

    public void xj(String str) {
        if (am()) {
            if (str == null) {
                throw new IllegalStateException(A2egSU.AcNBzu(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        }
        if (this.qd > 0) {
            com.bytedance.sdk.component.utils.pl.hf("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(A2egSU.AcNBzu(this, new StringBuilder())));
        }
    }

    private boolean xj(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.vm = null;
        }
        int size = this.hl.size();
        for (int i = 0; i < size; i++) {
            g gVar = this.hl.get(i);
            if (gVar.xj(this, motionEvent) && action != 3) {
                this.vm = gVar;
                return true;
            }
        }
        return false;
    }

    public final void xj(jk jkVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f10247io.xj;
            jkVar.qt = overScroller.getFinalX() - overScroller.getCurrX();
            jkVar.zg = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            jkVar.qt = 0;
            jkVar.zg = 0;
        }
    }

    private void xj(long j, ra raVar, ra raVar2) {
        int hf2 = this.c.hf();
        for (int i = 0; i < hf2; i++) {
            ra kd2 = kd(this.c.hf(i));
            if (kd2 != raVar && xj(kd2) == j) {
                xj xjVar = this.g;
                if (xjVar != null && xjVar.hf()) {
                    StringBuilder sb = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    sb.append(kd2);
                    sb.append(" \n View Holder 2:");
                    sb.append(raVar);
                    throw new IllegalStateException(A2egSU.AcNBzu(this, sb));
                }
                StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                sb2.append(kd2);
                sb2.append(" \n View Holder 2:");
                sb2.append(raVar);
                throw new IllegalStateException(A2egSU.AcNBzu(this, sb2));
            }
        }
        com.bytedance.sdk.component.utils.pl.u("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + raVar2 + " cannot be found but it is necessary for " + raVar + xj());
    }

    public void xj(ra raVar, y.hf hfVar) {
        raVar.xj(0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        if (this.q.f && raVar.io() && !raVar.e() && !raVar.L_()) {
            this.f.xj(xj(raVar), raVar);
        }
        this.f.xj(raVar, hfVar);
    }

    private void xj(int[] iArr) {
        int hf2 = this.c.hf();
        if (hf2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < hf2; i3++) {
            ra kd2 = kd(this.c.hf(i3));
            if (!kd2.L_()) {
                int u2 = kd2.u();
                if (u2 < i) {
                    i = u2;
                }
                if (u2 > i2) {
                    i2 = u2;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public long xj(ra raVar) {
        return this.g.hf() ? raVar.c() : raVar.w;
    }

    public void xj(ra raVar, y.hf hfVar, y.hf hfVar2) {
        raVar.xj(false);
        if (this.et.hf(raVar, hfVar, hfVar2)) {
            qt();
        }
    }

    private void xj(ra raVar, ra raVar2, y.hf hfVar, y.hf hfVar2, boolean z, boolean z2) {
        raVar.xj(false);
        if (z) {
            kd(raVar);
        }
        if (raVar != raVar2) {
            if (z2) {
                kd(raVar2);
            }
            raVar.f = raVar2;
            kd(raVar);
            this.kd.w(raVar);
            raVar2.xj(false);
            raVar2.d = raVar;
        }
        if (this.et.xj(raVar, raVar2, hfVar, hfVar2)) {
            qt();
        }
    }

    public void xj(int i, int i2, boolean z) {
        int i3 = i + i2;
        int w2 = this.c.w();
        for (int i4 = 0; i4 < w2; i4++) {
            ra kd2 = kd(this.c.u(i4));
            if (kd2 != null && !kd2.L_()) {
                int i5 = kd2.w;
                if (i5 >= i3) {
                    kd2.xj(-i2, z);
                    this.q.y = true;
                } else if (i5 >= i) {
                    kd2.xj(i - 1, -i2, z);
                    this.q.y = true;
                }
            }
        }
        this.kd.xj(i, i2, z);
        requestLayout();
    }

    public void xj(int i, int i2, Object obj) {
        int i3;
        int w2 = this.c.w();
        int i4 = i + i2;
        for (int i5 = 0; i5 < w2; i5++) {
            View u2 = this.c.u(i5);
            ra kd2 = kd(u2);
            if (kd2 != null && !kd2.L_() && (i3 = kd2.w) >= i && i3 < i4) {
                kd2.hf(2);
                kd2.xj(obj);
                ((tf) u2.getLayoutParams()).w = true;
            }
        }
        this.kd.w(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.widget.recycler.RecyclerView.ra xj(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.hf r0 = r5.c
            int r0 = r0.w()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L38
            com.bytedance.sdk.component.widget.recycler.hf r3 = r5.c
            android.view.View r3 = r3.u(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$ra r3 = kd(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.e()
            if (r4 != 0) goto L35
            if (r7 == 0) goto L23
            int r4 = r3.w
            if (r4 == r6) goto L29
            goto L35
        L23:
            int r4 = r3.u()
            if (r4 != r6) goto L35
        L29:
            com.bytedance.sdk.component.widget.recycler.hf r1 = r5.c
            android.view.View r4 = r3.xj
            boolean r1 = r1.w(r4)
            if (r1 != 0) goto L34
            return r3
        L34:
            r1 = r3
        L35:
            int r2 = r2 + 1
            goto L8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.xj(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$ra");
    }

    public ra xj(long j) {
        xj xjVar = this.g;
        ra raVar = null;
        if (xjVar != null && xjVar.hf()) {
            int w2 = this.c.w();
            for (int i = 0; i < w2; i++) {
                ra kd2 = kd(this.c.u(i));
                if (kd2 != null && !kd2.e() && kd2.c() == j) {
                    if (!this.c.w(kd2.xj)) {
                        return kd2;
                    }
                    raVar = kd2;
                }
            }
        }
        return raVar;
    }

    public static void xj(View view, Rect rect) {
        tf tfVar = (tf) view.getLayoutParams();
        Rect rect2 = tfVar.hf;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) tfVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) tfVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) tfVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin);
    }

    public boolean xj(ra raVar, int i) {
        if (am()) {
            raVar.qt = i;
            this.f10246a.add(raVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(raVar.xj, i);
        return true;
    }

    public boolean xj(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().xj(i, i2, i3, i4, iArr, i5);
    }

    public boolean xj(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().xj(i, i2, iArr, iArr2, i3);
    }
}
