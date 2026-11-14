package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.hf;
import com.bytedance.adsdk.lottie.model.hf.zg;
import com.bytedance.adsdk.lottie.xj.hf.qt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends w {
    private final List<xj> am;
    private final StringBuilder c;
    private final Matrix d;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> dk;
    private final com.bytedance.adsdk.lottie.y e;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> et;
    private final RectF f;
    private final LongSparseArray<String> g;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> ht;

    /* renamed from: io, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> f10050io;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> jk;
    private final Paint p;

    /* renamed from: pl, reason: collision with root package name */
    private final Map<com.bytedance.adsdk.lottie.model.u, List<com.bytedance.adsdk.lottie.xj.xj.u>> f10051pl;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> pz;
    private final qt qt;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> ra;
    private final Paint tf;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> v;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Typeface, Typeface> x;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> yo;
    private final com.bytedance.adsdk.lottie.f zg;

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.pl$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[hf.xj.values().length];
            xj = iArr;
            try {
                iArr[hf.xj.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[hf.xj.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[hf.xj.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class xj {
        private float hf;
        private String xj;

        private xj() {
            this.xj = "";
            this.hf = 0.0f;
        }

        public void xj(String str, float f) {
            this.xj = str;
            this.hf = f;
        }
    }

    public pl(com.bytedance.adsdk.lottie.f fVar, f fVar2) {
        super(fVar, fVar2);
        com.bytedance.adsdk.lottie.model.xj.hf hfVar;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2;
        com.bytedance.adsdk.lottie.model.xj.xj xjVar;
        com.bytedance.adsdk.lottie.model.xj.xj xjVar2;
        this.c = new StringBuilder(2);
        this.f = new RectF();
        this.d = new Matrix();
        int i = 1;
        this.tf = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.pl.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.p = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.pl.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.f10051pl = new HashMap();
        this.g = new LongSparseArray<>();
        this.am = new ArrayList();
        this.zg = fVar;
        this.e = fVar2.xj();
        qt xj2 = fVar2.v().xj();
        this.qt = xj2;
        xj2.xj(this);
        xj(xj2);
        com.bytedance.adsdk.lottie.model.xj.p jk = fVar2.jk();
        if (jk != null && (xjVar2 = jk.xj) != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj3 = xjVar2.xj();
            this.yo = xj3;
            xj3.xj(this);
            xj(this.yo);
        }
        if (jk != null && (xjVar = jk.hf) != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj4 = xjVar.xj();
            this.jk = xj4;
            xj4.xj(this);
            xj(this.jk);
        }
        if (jk != null && (hfVar2 = jk.w) != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj5 = hfVar2.xj();
            this.ht = xj5;
            xj5.xj(this);
            xj(this.ht);
        }
        if (jk == null || (hfVar = jk.u) == null) {
            return;
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj6 = hfVar.xj();
        this.dk = xj6;
        xj6.xj(this);
        xj(this.dk);
    }

    private boolean w(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        super.hf(canvas, matrix, i);
        com.bytedance.adsdk.lottie.model.hf c = this.qt.c();
        com.bytedance.adsdk.lottie.model.w wVar = this.e.zg().get(c.hf);
        if (wVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        xj(c, matrix);
        if (this.zg.io()) {
            xj(c, matrix, wVar, canvas);
        } else {
            xj(c, wVar, canvas);
        }
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        super.xj(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.e.u().width(), this.e.u().height());
    }

    private void xj(com.bytedance.adsdk.lottie.model.hf hfVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar = this.v;
        if (xjVar != null) {
            this.tf.setColor(xjVar.c().intValue());
        } else {
            com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar2 = this.yo;
            if (xjVar2 != null) {
                this.tf.setColor(xjVar2.c().intValue());
            } else {
                this.tf.setColor(hfVar.f);
            }
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar3 = this.pz;
        if (xjVar3 != null) {
            this.p.setColor(xjVar3.c().intValue());
        } else {
            com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xjVar4 = this.jk;
            if (xjVar4 != null) {
                this.p.setColor(xjVar4.c().intValue());
            } else {
                this.p.setColor(hfVar.d);
            }
        }
        int intValue = ((this.u.xj() == null ? 100 : this.u.xj().c().intValue()) * 255) / 100;
        this.tf.setAlpha(intValue);
        this.p.setAlpha(intValue);
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar5 = this.ra;
        if (xjVar5 != null) {
            this.p.setStrokeWidth(xjVar5.c().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar6 = this.ht;
        if (xjVar6 != null) {
            this.p.setStrokeWidth(xjVar6.c().floatValue());
        } else {
            this.p.setStrokeWidth(com.bytedance.adsdk.lottie.kd.d.xj() * hfVar.tf);
        }
    }

    private xj hf(int i) {
        for (int size = this.am.size(); size < i; size++) {
            this.am.add(new xj());
        }
        return this.am.get(i - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(com.bytedance.adsdk.lottie.model.hf r17, android.graphics.Matrix r18, com.bytedance.adsdk.lottie.model.w r19, android.graphics.Canvas r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r1 = r0.f10050io
            if (r1 == 0) goto L13
            java.lang.Object r1 = r1.c()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L15
        L13:
            float r1 = r7.w
        L15:
            r2 = 1120403456(0x42c80000, float:100.0)
            float r4 = r1 / r2
            float r8 = com.bytedance.adsdk.lottie.kd.d.xj(r18)
            java.lang.String r1 = r7.xj
            java.util.List r9 = r0.xj(r1)
            int r10 = r9.size()
            int r1 = r7.kd
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r2 = r0.et
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.c()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L3b:
            float r1 = r1 + r2
        L3c:
            r5 = r1
            goto L4d
        L3e:
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r2 = r0.dk
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r2.c()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L3b
        L4d:
            r11 = 0
            r1 = -1
            r12 = -1
            r13 = 0
        L51:
            if (r13 >= r10) goto La7
            java.lang.Object r1 = r9.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r2 = r7.g
            if (r2 != 0) goto L5f
            r2 = 0
            goto L61
        L5f:
            float r2 = r2.x
        L61:
            r6 = 1
            r3 = r19
            java.util.List r14 = r0.xj(r1, r2, r3, r4, r5, r6)
            r15 = 0
        L69:
            int r1 = r14.size()
            if (r15 >= r1) goto L9d
            java.lang.Object r1 = r14.get(r15)
            com.bytedance.adsdk.lottie.model.layer.pl$xj r1 = (com.bytedance.adsdk.lottie.model.layer.pl.xj) r1
            int r12 = r12 + 1
            r20.save()
            float r2 = com.bytedance.adsdk.lottie.model.layer.pl.xj.xj(r1)
            r3 = r20
            r0.xj(r3, r7, r12, r2)
            java.lang.String r1 = com.bytedance.adsdk.lottie.model.layer.pl.xj.hf(r1)
            r6 = r4
            r2 = r7
            r4 = r3
            r7 = r5
            r5 = r8
            r3 = r19
            r0.xj(r1, r2, r3, r4, r5, r6, r7)
            r4 = r6
            r20.restore()
            int r15 = r15 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L69
        L9d:
            r7 = r5
            r5 = r8
            int r13 = r13 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L51
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.pl.xj(com.bytedance.adsdk.lottie.model.hf, android.graphics.Matrix, com.bytedance.adsdk.lottie.model.w, android.graphics.Canvas):void");
    }

    private void xj(String str, com.bytedance.adsdk.lottie.model.hf hfVar, com.bytedance.adsdk.lottie.model.w wVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.lottie.model.u uVar = this.e.qt().get(com.bytedance.adsdk.lottie.model.u.xj(str.charAt(i), wVar.xj(), wVar.w()));
            if (uVar != null) {
                xj(uVar, f2, hfVar, canvas);
                canvas.translate((com.bytedance.adsdk.lottie.kd.d.xj() * ((float) uVar.hf()) * f2) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(com.bytedance.adsdk.lottie.model.hf r13, com.bytedance.adsdk.lottie.model.w r14, android.graphics.Canvas r15) {
        /*
            r12 = this;
            android.graphics.Typeface r0 = r12.xj(r14)
            if (r0 != 0) goto L9
        L6:
            r4 = r12
            goto Ld3
        L9:
            java.lang.String r1 = r13.xj
            com.bytedance.adsdk.lottie.f r2 = r12.zg
            com.bytedance.adsdk.lottie.jk r2 = r2.et()
            if (r2 == 0) goto L1b
            java.lang.String r3 = r12.p()
            java.lang.String r1 = r2.w(r3, r1)
        L1b:
            android.graphics.Paint r2 = r12.tf
            r2.setTypeface(r0)
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r0 = r12.f10050io
            if (r0 == 0) goto L2f
            java.lang.Object r0 = r0.c()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L31
        L2f:
            float r0 = r13.w
        L31:
            android.graphics.Paint r2 = r12.tf
            float r3 = com.bytedance.adsdk.lottie.kd.d.xj()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r12.p
            android.graphics.Paint r3 = r12.tf
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r12.p
            android.graphics.Paint r3 = r12.tf
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r13.kd
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r3 = r12.et
            if (r3 == 0) goto L68
            java.lang.Object r3 = r3.c()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L66:
            float r2 = r2 + r3
            goto L77
        L68:
            com.bytedance.adsdk.lottie.xj.hf.xj<java.lang.Float, java.lang.Float> r3 = r12.dk
            if (r3 == 0) goto L77
            java.lang.Object r3 = r3.c()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L66
        L77:
            float r3 = com.bytedance.adsdk.lottie.kd.d.xj()
            float r3 = r3 * r2
            float r3 = r3 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r9 = r3 / r0
            java.util.List r0 = r12.xj(r1)
            int r1 = r0.size()
            r2 = 0
            r3 = -1
            r11 = 0
        L8e:
            if (r11 >= r1) goto L6
            java.lang.Object r4 = r0.get(r11)
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            android.graphics.PointF r4 = r13.g
            if (r4 != 0) goto L9e
            r4 = 0
            r6 = 0
            goto La1
        L9e:
            float r4 = r4.x
            r6 = r4
        La1:
            r8 = 0
            r10 = 0
            r4 = r12
            r7 = r14
            java.util.List r14 = r4.xj(r5, r6, r7, r8, r9, r10)
            r5 = 0
        Laa:
            int r6 = r14.size()
            if (r5 >= r6) goto Lcf
            java.lang.Object r6 = r14.get(r5)
            com.bytedance.adsdk.lottie.model.layer.pl$xj r6 = (com.bytedance.adsdk.lottie.model.layer.pl.xj) r6
            int r3 = r3 + 1
            r15.save()
            float r8 = com.bytedance.adsdk.lottie.model.layer.pl.xj.xj(r6)
            r12.xj(r15, r13, r3, r8)
            java.lang.String r6 = com.bytedance.adsdk.lottie.model.layer.pl.xj.hf(r6)
            r12.xj(r6, r13, r15, r9)
            r15.restore()
            int r5 = r5 + 1
            goto Laa
        Lcf:
            int r11 = r11 + 1
            r14 = r7
            goto L8e
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.pl.xj(com.bytedance.adsdk.lottie.model.hf, com.bytedance.adsdk.lottie.model.w, android.graphics.Canvas):void");
    }

    private void xj(Canvas canvas, com.bytedance.adsdk.lottie.model.hf hfVar, int i, float f) {
        PointF pointF = hfVar.f10043pl;
        PointF pointF2 = hfVar.g;
        float xj2 = com.bytedance.adsdk.lottie.kd.d.xj();
        float f2 = (i * hfVar.y * xj2) + (pointF == null ? 0.0f : (hfVar.y * 0.6f * xj2) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.xj[hfVar.u.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate(((f4 / 2.0f) + f3) - (f / 2.0f), f2);
        }
    }

    private Typeface xj(com.bytedance.adsdk.lottie.model.w wVar) {
        Typeface c;
        com.bytedance.adsdk.lottie.xj.hf.xj<Typeface, Typeface> xjVar = this.x;
        if (xjVar != null && (c = xjVar.c()) != null) {
            return c;
        }
        Typeface xj2 = this.zg.xj(wVar);
        return xj2 != null ? xj2 : wVar.u();
    }

    private List<String> xj(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void xj(String str, com.bytedance.adsdk.lottie.model.hf hfVar, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String xj2 = xj(str, i);
            i += xj2.length();
            xj(xj2, hfVar, canvas);
            canvas.translate(this.tf.measureText(xj2) + f, 0.0f);
        }
    }

    private List<xj> xj(String str, float f, com.bytedance.adsdk.lottie.model.w wVar, float f2, float f3, boolean z) {
        float measureText;
        float f4 = 0.0f;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        float f5 = 0.0f;
        int i3 = 0;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.lottie.model.u uVar = this.e.qt().get(com.bytedance.adsdk.lottie.model.u.xj(charAt, wVar.xj(), wVar.w()));
                if (uVar != null) {
                    measureText = (com.bytedance.adsdk.lottie.kd.d.xj() * ((float) uVar.hf()) * f2) + f3;
                }
            } else {
                measureText = this.tf.measureText(str.substring(i4, i4 + 1)) + f3;
            }
            if (charAt == ' ') {
                z2 = true;
                f6 = measureText;
            } else if (z2) {
                i3 = i4;
                f5 = measureText;
                z2 = false;
            } else {
                f5 += measureText;
            }
            f4 += measureText;
            if (f > 0.0f && f4 >= f && charAt != ' ') {
                i++;
                xj hf = hf(i);
                if (i3 == i2) {
                    hf.xj(str.substring(i2, i4).trim(), (f4 - measureText) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = measureText;
                    f5 = f4;
                } else {
                    hf.xj(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            hf(i).xj(str.substring(i2), f4);
        }
        return this.am.subList(0, i);
    }

    private void xj(com.bytedance.adsdk.lottie.model.u uVar, float f, com.bytedance.adsdk.lottie.model.hf hfVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.xj.xj.u> xj2 = xj(uVar);
        for (int i = 0; i < xj2.size(); i++) {
            Path u = xj2.get(i).u();
            u.computeBounds(this.f, false);
            this.d.reset();
            this.d.preTranslate(0.0f, com.bytedance.adsdk.lottie.kd.d.xj() * (-hfVar.c));
            this.d.preScale(f, f);
            u.transform(this.d);
            if (hfVar.p) {
                xj(u, this.tf, canvas);
                xj(u, this.p, canvas);
            } else {
                xj(u, this.p, canvas);
                xj(u, this.tf, canvas);
            }
        }
    }

    private void xj(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void xj(String str, com.bytedance.adsdk.lottie.model.hf hfVar, Canvas canvas) {
        if (hfVar.p) {
            xj(str, this.tf, canvas);
            xj(str, this.p, canvas);
        } else {
            xj(str, this.p, canvas);
            xj(str, this.tf, canvas);
        }
    }

    private void xj(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.xj.xj.u> xj(com.bytedance.adsdk.lottie.model.u uVar) {
        if (this.f10051pl.containsKey(uVar)) {
            return this.f10051pl.get(uVar);
        }
        List<zg> xj2 = uVar.xj();
        int size = xj2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.lottie.xj.xj.u(this.zg, this, xj2.get(i), this.e));
        }
        this.f10051pl.put(uVar, arrayList);
        return arrayList;
    }

    private String xj(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!w(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.g.indexOfKey(j) >= 0) {
            return this.g.get(j);
        }
        this.c.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.c.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.c.toString();
        this.g.put(j, sb);
        return sb;
    }
}
