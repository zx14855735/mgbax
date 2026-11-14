package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bytedance.adsdk.lottie.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class VideoFrame extends View {
    private Bitmap c;
    private int f;
    private final Matrix hf;
    private ScriptIntrinsicBlur kd;
    private RenderScript u;
    private final d.xj.C0021xj w;
    private final TextureView xj;
    private long y;

    public VideoFrame(Context context, TextureView textureView, d.xj.C0021xj c0021xj) {
        super(context);
        this.y = -1L;
        this.c = null;
        this.f = 0;
        this.xj = textureView;
        this.hf = new Matrix();
        this.w = c0021xj;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.u;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.kd;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript create = RenderScript.create(getContext());
        this.u = create;
        this.kd = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.kd;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.kd = null;
        }
        RenderScript renderScript = this.u;
        if (renderScript != null) {
            renderScript.destroy();
            this.u = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.y >= 40) {
            this.y = elapsedRealtime;
            TextureView textureView = this.xj;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.xj.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.f = (int) (this.xj.getHeight() / width);
                }
                int i = this.f;
                if (i > 0 && (bitmap2 = this.xj.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.c;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.c.recycle();
                    }
                    this.c = xj(bitmap2, this.w.xj);
                    bitmap2.recycle();
                }
            }
        }
        if (this.f <= 0 || (bitmap = this.c) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.hf.reset();
        this.hf.setScale(getWidth() / 160.0f, getHeight() / this.f);
        canvas.concat(this.hf);
        canvas.drawBitmap(this.c, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    public Bitmap xj(Bitmap bitmap, float f) {
        Bitmap bitmap2;
        try {
            RenderScript renderScript = this.u;
            if (renderScript != null && this.kd != null) {
                Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation createTyped = Allocation.createTyped(this.u, createFromBitmap.getType());
                this.kd.setRadius(f);
                this.kd.setInput(createFromBitmap);
                this.kd.forEach(createTyped);
                bitmap2 = Bitmap.createBitmap(bitmap);
                try {
                    createTyped.copyTo(bitmap2);
                    createTyped.destroy();
                    createFromBitmap.destroy();
                    return bitmap2;
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.pl.xj(th);
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmap2 = null;
        }
    }
}
