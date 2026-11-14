package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements xj.InterfaceC0024xj, g, kd {
    private final boolean c;
    private final com.bytedance.adsdk.lottie.f d;
    private final List<w> f;
    private final RectF hf;
    private final RectF kd;
    private com.bytedance.adsdk.lottie.xj.hf.zg p;
    private List<g> tf;
    private final Path u;
    private final Matrix w;
    private final Paint xj;
    private final String y;

    public u(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.zg zgVar, com.bytedance.adsdk.lottie.y yVar) {
        this(fVar, wVar, zgVar.xj(), zgVar.w(), xj(fVar, yVar, wVar, zgVar.hf()), xj(zgVar.hf()));
    }

    private boolean kd() {
        int i = 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            if ((this.f.get(i2) instanceof kd) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    private static List<w> xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar, List<com.bytedance.adsdk.lottie.model.hf.w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            w xj = list.get(i).xj(fVar, yVar, wVar);
            if (xj != null) {
                arrayList.add(xj);
            }
        }
        return arrayList;
    }

    public List<g> hf() {
        if (this.tf == null) {
            this.tf = new ArrayList();
            for (int i = 0; i < this.f.size(); i++) {
                w wVar = this.f.get(i);
                if (wVar instanceof g) {
                    this.tf.add((g) wVar);
                }
            }
        }
        return this.tf;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        this.w.reset();
        com.bytedance.adsdk.lottie.xj.hf.zg zgVar = this.p;
        if (zgVar != null) {
            this.w.set(zgVar.u());
        }
        this.u.reset();
        if (this.c) {
            return this.u;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            w wVar = this.f.get(size);
            if (wVar instanceof g) {
                this.u.addPath(((g) wVar).u(), this.w);
            }
        }
        return this.u;
    }

    public Matrix w() {
        com.bytedance.adsdk.lottie.xj.hf.zg zgVar = this.p;
        if (zgVar != null) {
            return zgVar.u();
        }
        this.w.reset();
        return this.w;
    }

    public u(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, String str, boolean z, List<w> list, com.bytedance.adsdk.lottie.model.xj.pl plVar) {
        this.xj = new com.bytedance.adsdk.lottie.xj.xj();
        this.hf = new RectF();
        this.w = new Matrix();
        this.u = new Path();
        this.kd = new RectF();
        this.y = str;
        this.d = fVar;
        this.c = z;
        this.f = list;
        if (plVar != null) {
            com.bytedance.adsdk.lottie.xj.hf.zg tf = plVar.tf();
            this.p = tf;
            tf.xj(wVar);
            this.p.xj(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            w wVar2 = list.get(size);
            if (wVar2 instanceof tf) {
                arrayList.add((tf) wVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((tf) arrayList.get(size2)).xj(list.listIterator(list.size()));
        }
    }

    public static com.bytedance.adsdk.lottie.model.xj.pl xj(List<com.bytedance.adsdk.lottie.model.hf.w> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.lottie.model.hf.w wVar = list.get(i);
            if (wVar instanceof com.bytedance.adsdk.lottie.model.xj.pl) {
                return (com.bytedance.adsdk.lottie.model.xj.pl) wVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.d.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        ArrayList arrayList = new ArrayList(this.f.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            w wVar = this.f.get(size);
            wVar.xj(arrayList, this.f.subList(0, size));
            arrayList.add(wVar);
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        if (this.c) {
            return;
        }
        this.w.set(matrix);
        com.bytedance.adsdk.lottie.xj.hf.zg zgVar = this.p;
        if (zgVar != null) {
            this.w.preConcat(zgVar.u());
            i = (int) (((((this.p.xj() == null ? 100 : this.p.xj().c().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.d.tf() && kd() && i != 255;
        if (z) {
            this.hf.set(0.0f, 0.0f, 0.0f, 0.0f);
            xj(this.hf, this.w, true);
            this.xj.setAlpha(i);
            com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.hf, this.xj);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            w wVar = this.f.get(size);
            if (wVar instanceof kd) {
                ((kd) wVar).xj(canvas, this.w, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        this.w.set(matrix);
        com.bytedance.adsdk.lottie.xj.hf.zg zgVar = this.p;
        if (zgVar != null) {
            this.w.preConcat(zgVar.u());
        }
        this.kd.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            w wVar = this.f.get(size);
            if (wVar instanceof kd) {
                ((kd) wVar).xj(this.kd, this.w, z);
                rectF.union(this.kd);
            }
        }
    }
}
