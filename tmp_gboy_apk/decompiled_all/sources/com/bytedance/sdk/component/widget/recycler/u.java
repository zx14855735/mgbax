package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class u implements Runnable {
    long u;
    long w;
    static final ThreadLocal<u> xj = new ThreadLocal<>();
    static Comparator<hf> kd = new Comparator<hf>() { // from class: com.bytedance.sdk.component.widget.recycler.u.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(hf hfVar, hf hfVar2) {
            RecyclerView recyclerView = hfVar.u;
            if ((recyclerView == null) != (hfVar2.u == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = hfVar.xj;
            if (z != hfVar2.xj) {
                return z ? -1 : 1;
            }
            int i = hfVar2.hf - hfVar.hf;
            if (i != 0) {
                return i;
            }
            int i2 = hfVar.w - hfVar2.w;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    ArrayList<RecyclerView> hf = new ArrayList<>();
    private ArrayList<hf> y = new ArrayList<>();

    public static class hf {
        public int hf;
        public int kd;
        public RecyclerView u;
        public int w;
        public boolean xj;

        public void xj() {
            this.xj = false;
            this.hf = 0;
            this.w = 0;
            this.u = null;
            this.kd = 0;
        }
    }

    static {
        ILyqwN();
    }

    private static /* synthetic */ void ILyqwN() {
        char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '[');
        }
        String str = new String(charArray);
        char[] charArray2 = "87252/".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '[');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void hf(RecyclerView recyclerView) {
        this.hf.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV Prefetch");
            if (!this.hf.isEmpty()) {
                int size = this.hf.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.hf.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    xj(TimeUnit.MILLISECONDS.toNanos(j) + this.u);
                }
            }
        } finally {
            this.w = 0L;
            com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
        }
    }

    public void xj(RecyclerView recyclerView) {
        this.hf.add(recyclerView);
    }

    public static class xj implements RecyclerView.d.xj {
        int hf;
        int u;
        int[] w;
        int xj;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d.xj
        public void hf(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.u;
            int i4 = i3 * 2;
            int[] iArr = this.w;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.w = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.w = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.w;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.u++;
        }

        public void xj(int i, int i2) {
            this.xj = i;
            this.hf = i2;
        }

        public void xj(RecyclerView recyclerView, boolean z) {
            this.u = 0;
            int[] iArr = this.w;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.d dVar = recyclerView.am;
            if (recyclerView.g == null || dVar == null || !dVar.am()) {
                return;
            }
            if (z) {
                if (!recyclerView.y.u()) {
                    dVar.xj(recyclerView.g.xj(), this);
                }
            } else if (!recyclerView.pz()) {
                dVar.xj(this.xj, this.hf, recyclerView.q, this);
            }
            int i = this.u;
            if (i > dVar.zg) {
                dVar.zg = i;
                dVar.e = z;
                recyclerView.kd.hf();
            }
        }

        public boolean xj(int i) {
            if (this.w != null) {
                int i2 = this.u * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.w[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void xj() {
            int[] iArr = this.w;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.u = 0;
        }
    }

    private void hf(long j) {
        for (int i = 0; i < this.y.size(); i++) {
            hf hfVar = this.y.get(i);
            if (hfVar.u == null) {
                return;
            }
            xj(hfVar, j);
            hfVar.xj();
        }
    }

    public void xj(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.w == 0) {
            this.w = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.ai.xj(i, i2);
    }

    private void xj() {
        hf hfVar;
        int size = this.hf.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.hf.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.ai.xj(recyclerView, false);
                i += recyclerView.ai.u;
            }
        }
        this.y.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.hf.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                xj xjVar = recyclerView2.ai;
                int abs = Math.abs(xjVar.hf) + Math.abs(xjVar.xj);
                for (int i5 = 0; i5 < xjVar.u * 2; i5 += 2) {
                    if (i3 >= this.y.size()) {
                        hfVar = new hf();
                        this.y.add(hfVar);
                    } else {
                        hfVar = this.y.get(i3);
                    }
                    int[] iArr = xjVar.w;
                    int i6 = iArr[i5 + 1];
                    hfVar.xj = i6 <= abs;
                    hfVar.hf = abs;
                    hfVar.w = i6;
                    hfVar.u = recyclerView2;
                    hfVar.kd = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.y, kd);
    }

    public static boolean xj(RecyclerView recyclerView, int i) {
        int w = recyclerView.c.w();
        for (int i2 = 0; i2 < w; i2++) {
            RecyclerView.ra kd2 = RecyclerView.kd(recyclerView.c.u(i2));
            if (kd2.w == i && !kd2.am()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.ra xj(RecyclerView recyclerView, int i, long j) {
        if (xj(recyclerView, i)) {
            return null;
        }
        RecyclerView.zg zgVar = recyclerView.kd;
        try {
            recyclerView.pl();
            RecyclerView.ra xj2 = zgVar.xj(i, false, j);
            if (xj2 != null) {
                if (xj2.zg() && !xj2.am()) {
                    zgVar.xj(xj2.xj);
                } else {
                    zgVar.xj(xj2, false);
                }
            }
            recyclerView.hf(false);
            return xj2;
        } catch (Throwable th) {
            recyclerView.hf(false);
            throw th;
        }
    }

    private void xj(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.ra && recyclerView.c.w() != 0) {
                recyclerView.w();
            }
            xj xjVar = recyclerView.ai;
            xjVar.xj(recyclerView, true);
            if (xjVar.u != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj("RV Nested Prefetch");
                    recyclerView.q.xj(recyclerView.g);
                    for (int i = 0; i < xjVar.u * 2; i += 2) {
                        xj(recyclerView, xjVar.w[i], j);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.xj.xj.xj.xj();
                }
            }
        }
    }

    private void xj(hf hfVar, long j) {
        RecyclerView.ra xj2 = xj(hfVar.u, hfVar.kd, hfVar.xj ? Long.MAX_VALUE : j);
        if (xj2 == null || xj2.hf == null || !xj2.zg() || xj2.am()) {
            return;
        }
        xj(xj2.hf.get(), j);
    }

    public void xj(long j) {
        xj();
        hf(j);
    }
}
