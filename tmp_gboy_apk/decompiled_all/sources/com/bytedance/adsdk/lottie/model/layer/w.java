package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.model.hf.f;
import com.bytedance.adsdk.lottie.model.layer.f;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import com.bytedance.adsdk.lottie.xj.hf.zg;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w implements xj.InterfaceC0024xj, com.bytedance.adsdk.lottie.xj.xj.kd {
    private final List<com.bytedance.adsdk.lottie.xj.hf.xj<?, ?>> ai;
    private final Paint am;
    private com.bytedance.adsdk.lottie.xj.hf.u dk;
    private final RectF e;
    private final Matrix en;
    private w et;
    private boolean f;
    private final Paint g;
    final com.bytedance.adsdk.lottie.f hf;
    private final String ht;

    /* renamed from: io, reason: collision with root package name */
    private w f10053io;
    private Paint j;
    private final RectF jk;
    float kd;
    private float l;
    private final RectF pz;
    private boolean q;
    private final Paint qt;
    private com.bytedance.adsdk.lottie.xj.hf.f ra;
    final zg u;
    private final RectF v;
    final f w;
    private List<w> x;
    final Matrix xj;
    BlurMaskFilter y;
    private final RectF yo;
    private boolean z;
    private final Paint zg;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Path d = new Path();
    private final Matrix tf = new Matrix();
    private final Matrix p = new Matrix();

    /* renamed from: pl, reason: collision with root package name */
    private final Paint f10054pl = new com.bytedance.adsdk.lottie.xj.xj(1);

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.w$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hf;
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[f.xj.values().length];
            hf = iArr;
            try {
                iArr[f.xj.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hf[f.xj.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hf[f.xj.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                hf[f.xj.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[f.xj.values().length];
            xj = iArr2;
            try {
                iArr2[f.xj.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[f.xj.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                xj[f.xj.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                xj[f.xj.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                xj[f.xj.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                xj[f.xj.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                xj[f.xj.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public w(com.bytedance.adsdk.lottie.f fVar, f fVar2) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.g = new com.bytedance.adsdk.lottie.xj.xj(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.am = new com.bytedance.adsdk.lottie.xj.xj(1, mode2);
        com.bytedance.adsdk.lottie.xj.xj xjVar = new com.bytedance.adsdk.lottie.xj.xj(1);
        this.qt = xjVar;
        this.zg = new com.bytedance.adsdk.lottie.xj.xj(PorterDuff.Mode.CLEAR);
        this.e = new RectF();
        this.yo = new RectF();
        this.v = new RectF();
        this.jk = new RectF();
        this.pz = new RectF();
        this.xj = new Matrix();
        this.ai = new ArrayList();
        this.q = true;
        this.kd = 0.0f;
        this.en = new Matrix();
        this.l = 1.0f;
        this.hf = fVar;
        this.w = fVar2;
        this.ht = fVar2.y() + "#draw";
        if (fVar2.pl() == f.hf.INVERT) {
            xjVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            xjVar.setXfermode(new PorterDuffXfermode(mode));
        }
        zg tf = fVar2.qt().tf();
        this.u = tf;
        tf.xj((xj.InterfaceC0024xj) this);
        if (fVar2.tf() != null && !fVar2.tf().isEmpty()) {
            com.bytedance.adsdk.lottie.xj.hf.f fVar3 = new com.bytedance.adsdk.lottie.xj.hf.f(fVar2.tf());
            this.ra = fVar3;
            Iterator<com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path>> it = fVar3.hf().iterator();
            while (it.hasNext()) {
                it.next().xj(this);
            }
            for (com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2 : this.ra.w()) {
                xj(xjVar2);
                xjVar2.xj(this);
            }
        }
        am();
    }

    private void am() {
        if (this.w.u().isEmpty()) {
            hf(true);
            return;
        }
        com.bytedance.adsdk.lottie.xj.hf.u uVar = new com.bytedance.adsdk.lottie.xj.hf.u(this.w.u());
        this.dk = uVar;
        uVar.xj();
        this.dk.xj(new xj.InterfaceC0024xj() { // from class: com.bytedance.adsdk.lottie.model.layer.w.1
            @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
            public void xj() {
                w wVar = w.this;
                wVar.hf(wVar.dk.d() == 1.0f);
            }
        });
        hf(this.dk.c().floatValue() == 1.0f);
        xj(this.dk);
    }

    private void e() {
        if (this.x != null) {
            return;
        }
        if (this.f10053io == null) {
            this.x = Collections.EMPTY_LIST;
            return;
        }
        this.x = new ArrayList();
        for (w wVar = this.f10053io; wVar != null; wVar = wVar.f10053io) {
            this.x.add(wVar);
        }
    }

    private void qt() {
        this.hf.invalidateSelf();
    }

    private boolean zg() {
        if (this.ra.hf().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.ra.xj().size(); i++) {
            if (this.ra.xj().get(i).xj() != f.xj.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        f fVar = this.w;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public boolean d() {
        com.bytedance.adsdk.lottie.xj.hf.f fVar = this.ra;
        return (fVar == null || fVar.hf().isEmpty()) ? false : true;
    }

    public float f() {
        return this.l;
    }

    public com.bytedance.adsdk.lottie.u.tf g() {
        return this.w.dk();
    }

    public boolean hf() {
        return this.f;
    }

    public boolean kd() {
        return this.et != null;
    }

    public String p() {
        return this.w.y();
    }

    public com.bytedance.adsdk.lottie.model.hf.xj pl() {
        return this.w.ra();
    }

    public boolean tf() {
        return this.q;
    }

    public f u() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<com.bytedance.adsdk.lottie.xj.xj.w> list, List<com.bytedance.adsdk.lottie.xj.xj.w> list2) {
    }

    public Matrix y() {
        return this.en;
    }

    private void kd(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar, com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2) {
        com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.g);
        canvas.drawRect(this.e, this.f10054pl);
        this.am.setAlpha((int) (xjVar2.c().intValue() * 2.55f));
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        canvas.drawPath(this.d, this.am);
        canvas.restore();
    }

    private void u(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar, com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2) {
        com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.g);
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        this.f10054pl.setAlpha((int) (xjVar2.c().intValue() * 2.55f));
        canvas.drawPath(this.d, this.f10054pl);
        canvas.restore();
    }

    public void hf(w wVar) {
        this.f10053io = wVar;
    }

    public void w() {
        this.f = true;
    }

    private void hf(RectF rectF, Matrix matrix) {
        if (kd() && this.w.pl() != f.hf.INVERT) {
            this.jk.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.et.xj(this.jk, matrix, true);
            if (rectF.intersect(this.jk)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void w(float f) {
        this.hf.x().w().xj(this.w.y(), f);
    }

    public void xj(Runnable runnable) {
        this.c.post(runnable);
    }

    public static w xj(u uVar, f fVar, com.bytedance.adsdk.lottie.f fVar2, com.bytedance.adsdk.lottie.y yVar, Context context) {
        switch (AnonymousClass2.xj[fVar.p().ordinal()]) {
            case 1:
                return new tf(fVar2, fVar, uVar, yVar);
            case 2:
                return new u(fVar2, fVar, yVar.hf(fVar.c()), yVar, context);
            case 3:
                return new p(fVar2, fVar);
            case 4:
                if (xj(fVar2, fVar, "text:")) {
                    return new y(fVar2, fVar, context);
                }
                if (xj(fVar2, fVar, "videoview:")) {
                    d.xj xj = xj(fVar2, fVar);
                    if (xj != null) {
                        d.xj.C0021xj c0021xj = xj.xj;
                        if (c0021xj != null && c0021xj.xj > 0.0f) {
                            return new kd(fVar2, fVar, context, c0021xj);
                        }
                        if (xj.hf) {
                            return new hf(fVar2, fVar, context);
                        }
                        return new am(fVar2, fVar, context);
                    }
                    return new am(fVar2, fVar, context);
                }
                if (xj(fVar2, fVar, "animview:")) {
                    return new xj(fVar2, fVar, context);
                }
                if (xj(fVar2, fVar, "view:")) {
                    return new g(fVar2, fVar, context);
                }
                return new c(fVar2, fVar);
            case 5:
                return new d(fVar2, fVar);
            case 6:
                return new pl(fVar2, fVar);
            default:
                com.bytedance.adsdk.lottie.kd.kd.hf("Unknown layer type " + fVar.p());
                return null;
        }
    }

    private void w(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar, com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2) {
        com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.am);
        canvas.drawRect(this.e, this.f10054pl);
        this.am.setAlpha((int) (xjVar2.c().intValue() * 2.55f));
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        canvas.drawPath(this.d, this.am);
        canvas.restore();
    }

    public void hf(Canvas canvas, Matrix matrix, int i) {
        xj(i);
    }

    private void hf(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar, com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2) {
        com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.f10054pl);
        canvas.drawRect(this.e, this.f10054pl);
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        this.f10054pl.setAlpha((int) (xjVar2.c().intValue() * 2.55f));
        canvas.drawPath(this.d, this.am);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        if (z != this.q) {
            this.q = z;
            qt();
        }
    }

    public BlurMaskFilter hf(float f) {
        if (this.kd == f) {
            return this.y;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.y = blurMaskFilter;
        this.kd = f;
        return blurMaskFilter;
    }

    private static d.xj xj(com.bytedance.adsdk.lottie.f fVar, f fVar2) {
        com.bytedance.adsdk.lottie.d y;
        if (fVar == null || fVar2 == null || (y = fVar.y(fVar2.c())) == null) {
            return null;
        }
        return y.tf();
    }

    private static boolean xj(com.bytedance.adsdk.lottie.f fVar, f fVar2, String str) {
        com.bytedance.adsdk.lottie.d y;
        if (fVar == null || fVar2 == null || str == null || (y = fVar.y(fVar2.c())) == null) {
            return false;
        }
        return str.equals(y.g());
    }

    public void xj(boolean z) {
        if (z && this.j == null) {
            this.j = new com.bytedance.adsdk.lottie.xj.xj();
        }
        this.z = z;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        qt();
    }

    public void xj(w wVar) {
        this.et = wVar;
    }

    public void xj(com.bytedance.adsdk.lottie.xj.hf.xj<?, ?> xjVar) {
        if (xjVar == null) {
            return;
        }
        this.ai.add(xjVar);
    }

    public void xj(RectF rectF, Matrix matrix, boolean z) {
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        e();
        this.xj.set(matrix);
        if (z) {
            List<w> list = this.x;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.xj.preConcat(this.x.get(size).u.u());
                }
            } else {
                w wVar = this.f10053io;
                if (wVar != null) {
                    this.xj.preConcat(wVar.u.u());
                }
            }
        }
        this.xj.preConcat(this.u.u());
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer c;
        com.bytedance.adsdk.lottie.kd.xj(this.ht);
        if (this.q && !this.w.ht()) {
            e();
            com.bytedance.adsdk.lottie.kd.xj("Layer#parentMatrix");
            this.en.set(matrix);
            this.tf.reset();
            this.tf.set(matrix);
            for (int size = this.x.size() - 1; size >= 0; size--) {
                this.tf.preConcat(this.x.get(size).u.u());
            }
            com.bytedance.adsdk.lottie.kd.hf("Layer#parentMatrix");
            com.bytedance.adsdk.lottie.xj.hf.xj<?, Integer> xj = this.u.xj();
            int intValue = (int) ((((i / 255.0f) * ((xj == null || (c = xj.c()) == null) ? 100 : c.intValue())) / 100.0f) * 255.0f);
            if (!kd() && !d()) {
                this.tf.preConcat(this.u.u());
                com.bytedance.adsdk.lottie.kd.xj("Layer#drawLayer");
                hf(canvas, this.tf, intValue);
                com.bytedance.adsdk.lottie.kd.hf("Layer#drawLayer");
                w(com.bytedance.adsdk.lottie.kd.hf(this.ht));
                return;
            }
            com.bytedance.adsdk.lottie.kd.xj("Layer#computeBounds");
            xj(this.e, this.tf, false);
            hf(this.e, matrix);
            this.tf.preConcat(this.u.u());
            xj(this.e, this.tf);
            this.yo.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.p);
            if (!this.p.isIdentity()) {
                Matrix matrix2 = this.p;
                matrix2.invert(matrix2);
                this.p.mapRect(this.yo);
            }
            if (!this.e.intersect(this.yo)) {
                this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.bytedance.adsdk.lottie.kd.hf("Layer#computeBounds");
            if (this.e.width() >= 1.0f && this.e.height() >= 1.0f) {
                com.bytedance.adsdk.lottie.kd.xj("Layer#saveLayer");
                this.f10054pl.setAlpha(255);
                com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.f10054pl);
                com.bytedance.adsdk.lottie.kd.hf("Layer#saveLayer");
                xj(canvas);
                com.bytedance.adsdk.lottie.kd.xj("Layer#drawLayer");
                hf(canvas, this.tf, intValue);
                com.bytedance.adsdk.lottie.kd.hf("Layer#drawLayer");
                if (d()) {
                    xj(canvas, this.tf);
                }
                if (kd()) {
                    com.bytedance.adsdk.lottie.kd.xj("Layer#drawMatte");
                    com.bytedance.adsdk.lottie.kd.xj("Layer#saveLayer");
                    com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.qt, 19);
                    com.bytedance.adsdk.lottie.kd.hf("Layer#saveLayer");
                    xj(canvas);
                    this.et.xj(canvas, matrix, intValue);
                    com.bytedance.adsdk.lottie.kd.xj("Layer#restoreLayer");
                    canvas.restore();
                    com.bytedance.adsdk.lottie.kd.hf("Layer#restoreLayer");
                    com.bytedance.adsdk.lottie.kd.hf("Layer#drawMatte");
                }
                com.bytedance.adsdk.lottie.kd.xj("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.kd.hf("Layer#restoreLayer");
            }
            if (this.z && (paint = this.j) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.j.setColor(-251901);
                this.j.setStrokeWidth(4.0f);
                canvas.drawRect(this.e, this.j);
                this.j.setStyle(Paint.Style.FILL);
                this.j.setColor(1357638635);
                canvas.drawRect(this.e, this.j);
            }
            w(com.bytedance.adsdk.lottie.kd.hf(this.ht));
            return;
        }
        com.bytedance.adsdk.lottie.kd.hf(this.ht);
    }

    private void xj(Canvas canvas) {
        com.bytedance.adsdk.lottie.kd.xj("Layer#clearLayer");
        RectF rectF = this.e;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.zg);
        com.bytedance.adsdk.lottie.kd.hf("Layer#clearLayer");
    }

    private void xj(RectF rectF, Matrix matrix) {
        this.v.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.ra.xj().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.lottie.model.hf.f fVar = this.ra.xj().get(i);
                Path c = this.ra.hf().get(i).c();
                if (c != null) {
                    this.d.set(c);
                    this.d.transform(matrix);
                    int i2 = AnonymousClass2.hf[fVar.xj().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && fVar.u()) {
                        return;
                    }
                    this.d.computeBounds(this.pz, false);
                    if (i == 0) {
                        this.v.set(this.pz);
                    } else {
                        RectF rectF2 = this.v;
                        rectF2.set(Math.min(rectF2.left, this.pz.left), Math.min(this.v.top, this.pz.top), Math.max(this.v.right, this.pz.right), Math.max(this.v.bottom, this.pz.bottom));
                    }
                }
            }
            if (rectF.intersect(this.v)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void xj(int i) {
        this.l = (i / 255.0f) * ((this.u.xj() != null ? this.u.xj().c().intValue() : 100) / 100.0f);
    }

    private void xj(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.kd.xj("Layer#saveLayer");
        com.bytedance.adsdk.lottie.kd.d.xj(canvas, this.e, this.g, 19);
        if (Build.VERSION.SDK_INT < 28) {
            xj(canvas);
        }
        com.bytedance.adsdk.lottie.kd.hf("Layer#saveLayer");
        for (int i = 0; i < this.ra.xj().size(); i++) {
            com.bytedance.adsdk.lottie.model.hf.f fVar = this.ra.xj().get(i);
            com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar = this.ra.hf().get(i);
            com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2 = this.ra.w().get(i);
            int i2 = AnonymousClass2.hf[fVar.xj().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f10054pl.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
                        this.f10054pl.setAlpha(255);
                        canvas.drawRect(this.e, this.f10054pl);
                    }
                    if (fVar.u()) {
                        w(canvas, matrix, xjVar, xjVar2);
                    } else {
                        xj(canvas, matrix, xjVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (fVar.u()) {
                            hf(canvas, matrix, xjVar, xjVar2);
                        } else {
                            xj(canvas, matrix, xjVar, xjVar2);
                        }
                    }
                } else if (fVar.u()) {
                    kd(canvas, matrix, xjVar, xjVar2);
                } else {
                    u(canvas, matrix, xjVar, xjVar2);
                }
            } else if (zg()) {
                this.f10054pl.setAlpha(255);
                canvas.drawRect(this.e, this.f10054pl);
            }
        }
        com.bytedance.adsdk.lottie.kd.xj("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.kd.hf("Layer#restoreLayer");
    }

    private void xj(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar, com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2) {
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        this.f10054pl.setAlpha((int) (xjVar2.c().intValue() * 2.55f));
        canvas.drawPath(this.d, this.f10054pl);
    }

    private void xj(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.am, Path> xjVar) {
        this.d.set(xjVar.c());
        this.d.transform(matrix);
        canvas.drawPath(this.d, this.am);
    }

    public void xj(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.u.xj(f);
        if (this.ra != null) {
            for (int i = 0; i < this.ra.hf().size(); i++) {
                this.ra.hf().get(i).xj(f);
            }
        }
        com.bytedance.adsdk.lottie.xj.hf.u uVar = this.dk;
        if (uVar != null) {
            uVar.xj(f);
        }
        w wVar = this.et;
        if (wVar != null) {
            wVar.xj(f);
        }
        for (int i2 = 0; i2 < this.ai.size(); i2++) {
            this.ai.get(i2).xj(f);
        }
    }
}
