package com.bytedance.adsdk.xj.xj.xj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.adsdk.xj.xj.xj.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends d<com.bytedance.adsdk.xj.xj.hf.xj, com.bytedance.adsdk.xj.xj.hf.hf> {
    private com.bytedance.adsdk.xj.xj.hf.hf c;
    private final Paint d;
    private int f;
    private final xj tf;

    public static class xj {
        Rect hf;
        ByteBuffer w;
        byte xj;

        private xj() {
            this.hf = new Rect();
        }
    }

    public hf(com.bytedance.adsdk.xj.xj.w.hf hfVar, d.xj xjVar) {
        super(hfVar, xjVar);
        Paint paint = new Paint();
        this.d = paint;
        this.tf = new xj();
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.xj.xj.hf.hf u() {
        if (this.c == null) {
            this.c = new com.bytedance.adsdk.xj.xj.hf.hf();
        }
        return this.c;
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    public int hf() {
        return this.f;
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    public void w() {
        this.tf.w = null;
        this.c = null;
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.xj.xj.hf.xj w(com.bytedance.adsdk.xj.xj.hf.y yVar) {
        return new com.bytedance.adsdk.xj.xj.hf.xj(yVar);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Rect hf(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        List<kd> xj2 = u.xj(xjVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<kd> it = xj2.iterator();
        w wVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            kd next = it.next();
            if (next instanceof com.bytedance.adsdk.xj.xj.xj.xj) {
                this.f = ((com.bytedance.adsdk.xj.xj.xj.xj) next).w;
                z = true;
            } else if (next instanceof y) {
                wVar = new w(xjVar, (y) next);
                wVar.kd = arrayList;
                wVar.w = bArr;
                this.xj.add(wVar);
            } else if (next instanceof c) {
                if (wVar != null) {
                    wVar.u.add(next);
                }
            } else if (next instanceof tf) {
                if (!z) {
                    g gVar = new g(xjVar);
                    gVar.f = i;
                    gVar.d = i2;
                    this.xj.add(gVar);
                    this.f = 1;
                    break;
                }
                if (wVar != null) {
                    wVar.u.add(next);
                }
            } else if (next instanceof pl) {
                pl plVar = (pl) next;
                i = plVar.hf;
                i2 = plVar.w;
                bArr = plVar.f;
            } else if (!(next instanceof p)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        int i4 = this.w;
        this.kd = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
        xj xjVar2 = this.tf;
        int i5 = this.w;
        xjVar2.w = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d
    public void xj(f<com.bytedance.adsdk.xj.xj.hf.xj, com.bytedance.adsdk.xj.xj.hf.hf> fVar) {
        if (fVar == null || this.y == null) {
            return;
        }
        try {
            Bitmap xj2 = xj(this.y.width() / this.w, this.y.height() / this.w);
            Canvas canvas = this.u.get(xj2);
            if (canvas == null) {
                canvas = new Canvas(xj2);
                this.u.put(xj2, canvas);
            }
            Canvas canvas2 = canvas;
            if (fVar instanceof w) {
                this.kd.rewind();
                xj2.copyPixelsFromBuffer(this.kd);
                if (this.hf == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.tf.hf);
                    xj xjVar = this.tf;
                    byte b = xjVar.xj;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        xjVar.w.rewind();
                        xj2.copyPixelsFromBuffer(this.tf.w);
                    }
                    canvas2.restore();
                }
                if (((w) fVar).hf == 2) {
                    xj xjVar2 = this.tf;
                    if (xjVar2.xj != 2) {
                        xjVar2.w.rewind();
                        xj2.copyPixelsToBuffer(this.tf.w);
                    }
                }
                this.tf.xj = ((w) fVar).hf;
                canvas2.save();
                if (((w) fVar).xj == 0) {
                    int i = fVar.tf;
                    int i2 = this.w;
                    int i3 = fVar.p;
                    canvas2.clipRect(i / i2, i3 / i2, (i + fVar.f) / i2, (i3 + fVar.d) / i2);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.tf.hf;
                int i4 = fVar.tf;
                int i5 = this.w;
                int i6 = fVar.p;
                rect.set(i4 / i5, i6 / i5, (i4 + fVar.f) / i5, (i6 + fVar.d) / i5);
                canvas2.restore();
            }
            Bitmap xj3 = xj(fVar.f, fVar.d);
            xj(fVar.xj(canvas2, this.d, this.w, xj3, u()));
            xj(xj3);
            this.kd.rewind();
            xj2.copyPixelsToBuffer(this.kd);
            xj(xj2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
