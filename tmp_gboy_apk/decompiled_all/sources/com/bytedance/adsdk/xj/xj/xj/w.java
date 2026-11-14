package com.bytedance.adsdk.xj.xj.xj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends f<com.bytedance.adsdk.xj.xj.hf.xj, com.bytedance.adsdk.xj.xj.hf.hf> {
    static final /* synthetic */ boolean y = true;
    public final byte hf;
    List<kd> kd;
    List<kd> u;
    byte[] w;
    public final byte xj;
    private static final byte[] qt = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] zg = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> e = new ThreadLocal<>();

    public w(com.bytedance.adsdk.xj.xj.hf.xj xjVar, y yVar) {
        super(xjVar);
        this.u = new ArrayList();
        this.kd = new ArrayList();
        this.xj = yVar.am;
        this.hf = yVar.g;
        int i = yVar.p * 1000;
        short s = yVar.f10098pl;
        int i2 = i / (s == 0 ? (short) 100 : s);
        this.f10097pl = i2;
        if (i2 < 10) {
            this.f10097pl = 100;
        }
        this.f = yVar.w;
        this.d = yVar.f;
        this.tf = yVar.d;
        this.p = yVar.tf;
    }

    private CRC32 xj() {
        ThreadLocal<CRC32> threadLocal = e;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    private int xj(com.bytedance.adsdk.xj.xj.hf.hf hfVar) {
        Iterator<kd> it = this.kd.iterator();
        int i = 33;
        while (it.hasNext()) {
            i += it.next().u + 12;
        }
        for (kd kdVar : this.u) {
            if (kdVar instanceof tf) {
                i += kdVar.u + 12;
            } else if (kdVar instanceof c) {
                i = kdVar.u + 8 + i;
            }
        }
        int length = i + zg.length;
        hfVar.w(length);
        hfVar.xj(qt);
        hfVar.hf(13);
        int xj = hfVar.xj();
        hfVar.xj(pl.xj);
        hfVar.hf(this.f);
        hfVar.hf(this.d);
        hfVar.xj(this.w);
        CRC32 xj2 = xj();
        xj2.reset();
        xj2.update(hfVar.hf(), xj, 17);
        hfVar.hf((int) xj2.getValue());
        for (kd kdVar2 : this.kd) {
            if (!(kdVar2 instanceof p)) {
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).d_();
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(kdVar2.c);
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(hfVar.hf(), hfVar.xj(), kdVar2.u + 12);
                hfVar.u(kdVar2.u + 12);
            }
        }
        for (kd kdVar3 : this.u) {
            if (kdVar3 instanceof tf) {
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).d_();
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(kdVar3.c);
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(hfVar.hf(), hfVar.xj(), kdVar3.u + 12);
                hfVar.u(kdVar3.u + 12);
            } else if (kdVar3 instanceof c) {
                hfVar.hf(kdVar3.u - 4);
                int xj3 = hfVar.xj();
                hfVar.xj(tf.xj);
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).d_();
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(kdVar3.c + 12);
                ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).xj(hfVar.hf(), hfVar.xj(), kdVar3.u - 4);
                hfVar.u(kdVar3.u - 4);
                xj2.reset();
                xj2.update(hfVar.hf(), xj3, kdVar3.u);
                hfVar.hf((int) xj2.getValue());
            }
        }
        hfVar.xj(zg);
        return length;
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.f
    public Bitmap xj(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.xj.xj.hf.hf hfVar) {
        Bitmap decodeByteArray;
        try {
            int xj = xj(hfVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] hf = hfVar.hf();
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(hf, 0, xj, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                decodeByteArray = BitmapFactory.decodeByteArray(hf, 0, xj, options2);
            }
            if (!y && decodeByteArray == null) {
                throw new AssertionError();
            }
            Rect rect = this.g;
            rect.left = 0;
            rect.top = 0;
            rect.right = decodeByteArray.getWidth();
            this.g.bottom = decodeByteArray.getHeight();
            Rect rect2 = this.am;
            int i2 = this.tf;
            float f = i;
            rect2.left = (int) (i2 / f);
            rect2.top = (int) (this.p / f);
            rect2.right = (int) ((i2 / f) + decodeByteArray.getWidth());
            this.am.bottom = (int) ((this.p / f) + decodeByteArray.getHeight());
            canvas.drawBitmap(decodeByteArray, this.g, this.am, paint);
            return decodeByteArray;
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
            return null;
        }
    }
}
