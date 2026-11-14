package com.bytedance.adsdk.xj.xj.xj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends f<com.bytedance.adsdk.xj.xj.hf.xj, com.bytedance.adsdk.xj.xj.hf.hf> {
    static final /* synthetic */ boolean xj = true;

    public g(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        super(xjVar);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.f
    public Bitmap xj(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.xj.xj.hf.hf hfVar) {
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.xj.xj.hf.xj) this.c).d_();
            try {
                decodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.xj.xj.hf.xj) this.c).kd(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                decodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.xj.xj.hf.xj) this.c).kd(), null, options2);
            }
            try {
                if (!xj && decodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                return decodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = decodeStream;
                com.bytedance.sdk.component.utils.pl.xj(e);
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
