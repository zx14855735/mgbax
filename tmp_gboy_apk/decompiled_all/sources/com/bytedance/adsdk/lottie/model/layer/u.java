package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.layer.f;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends w {
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> c;
    private final RectF d;
    private final List<w> f;
    private final Paint p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10052pl;
    private final RectF tf;

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.u$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[f.hf.values().length];
            xj = iArr;
            try {
                iArr[f.hf.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[f.hf.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public u(com.bytedance.adsdk.lottie.f fVar, f fVar2, List<f> list, com.bytedance.adsdk.lottie.y yVar, Context context) {
        super(fVar, fVar2);
        int i;
        w wVar;
        f.hf pl2;
        int i2;
        this.f = new ArrayList();
        this.d = new RectF();
        this.tf = new RectF();
        this.p = new Paint();
        this.f10052pl = true;
        com.bytedance.adsdk.lottie.model.xj.hf pz = fVar2.pz();
        if (pz != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = pz.xj();
            this.c = xj;
            xj(xj);
            this.c.xj(this);
        } else {
            this.c = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(yVar.am().size());
        int size = list.size() - 1;
        w wVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            f fVar3 = list.get(size);
            w xj2 = w.xj(this, fVar3, fVar, yVar, context);
            if (xj2 != null) {
                longSparseArray.put(xj2.u().kd(), xj2);
                if (wVar2 != null) {
                    wVar2.xj(xj2);
                    wVar2 = null;
                } else {
                    this.f.add(0, xj2);
                    if (fVar3 != null && (pl2 = fVar3.pl()) != null && ((i2 = AnonymousClass1.xj[pl2.ordinal()]) == 1 || i2 == 2)) {
                        wVar2 = xj2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            w wVar3 = (w) longSparseArray.get(longSparseArray.keyAt(i));
            if (wVar3 != null && (wVar = (w) longSparseArray.get(wVar3.u().g())) != null) {
                wVar3.hf(wVar);
            }
        }
    }

    public List<w> am() {
        return this.f;
    }

    public void hf(boolean z) {
        this.f10052pl = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void xj(boolean z) {
        super.xj(z);
        Iterator<w> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().xj(z);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        super.hf(canvas, matrix, i);
        com.bytedance.adsdk.lottie.kd.xj("CompositionLayer#draw");
        this.tf.set(0.0f, 0.0f, this.w.f(), this.w.d());
        matrix.mapRect(this.tf);
        boolean z = this.hf.tf() && this.f.size() > 1 && i != 255;
        if (z) {
            this.p.setAlpha(i);
            com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.tf, this.p);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            if (((this.f10052pl || !"__container".equals(this.w.y())) && !this.tf.isEmpty()) ? canvas.clipRect(this.tf) : true) {
                this.f.get(size).xj(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.kd.hf("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        super.xj(rectF, matrix, z);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.d.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f.get(size).xj(this.d, this.xj, true);
            rectF.union(this.d);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void xj(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.xj(f);
        if (this.c != null) {
            f = ((this.w.xj().g() * this.c.c().floatValue()) - this.w.xj().y()) / (this.hf.x().yo() + 0.01f);
        }
        if (this.c == null) {
            f -= this.w.w();
        }
        if (this.w.hf() != 0.0f && !"__container".equals(this.w.y())) {
            f /= this.w.hf();
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.f.get(size).xj(f);
        }
    }
}
